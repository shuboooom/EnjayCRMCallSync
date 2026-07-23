# EnjayCRMCallSync Setup And Architecture

This document explains how the app is set up, how the main pieces fit together, what is stored locally, and how data is synced with the CRM backend.

## What This App Does

EnjayCRMCallSync is an Android app that:

- stores CRM leads locally
- watches device call state in the background
- matches completed calls to known leads
- stores matched call logs locally
- collects post-call follow-up details
- syncs leads, call logs, and post-call activities with a remote CRM API

The app is designed to work with a local-first model:

- data is created and used locally first
- new or changed records are marked for sync
- background work pushes local changes to the backend
- the app then pulls remote changes back into the device database

## Tech Stack

- Kotlin
- Android SDK 35
- Minimum SDK 26
- Room for local storage
- Retrofit + OkHttp for API calls
- WorkManager for background sync
- Android foreground service for call-state monitoring
- `libphonenumber` for phone normalization and matching

## Project Structure

Main areas in the codebase:

- `app/src/main/java/com/enjay/crm/callsync/data`
  Handles app wiring, Room, repositories, and sync logic.
- `app/src/main/java/com/enjay/crm/callsync/service`
  Handles background call monitoring.
- `app/src/main/java/com/enjay/crm/callsync/sync`
  Handles scheduling and execution of sync jobs.
- `app/src/main/java/com/enjay/crm/callsync/ui`
  Screens, fragments, adapters, and view models.
- `app/src/main/java/com/enjay/crm/callsync/util`
  Helpers such as phone normalization and formatting.

## Setup

### Runtime permissions

The app depends on these Android permissions:

- `READ_CALL_LOG`
- `READ_CONTACTS`
- `READ_PHONE_STATE`
- `CALL_PHONE`
- `POST_NOTIFICATIONS` on Android 13+
- foreground service permissions for sync and call monitoring

Without the required phone-state and notification permissions, the call monitoring foreground service will not stay active.

### Current backend configuration

The Retrofit base URL is currently hardcoded in [AppContainer.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/AppContainer.kt):

```text
https://enjaydummycrm.web.app/
```

That means environment switching is not configurable yet. If this app needs dev/staging/prod support, the next step should be moving the base URL into a build config field or another environment-specific configuration layer.

## High-Level Architecture

```text
UI
 -> ViewModels
 -> Repositories
 -> Room database
 -> Sync repository
 -> Retrofit API

Background call monitoring
 -> Telephony callbacks
 -> Device call log scan
 -> Lead matching
 -> Local call log insert
 -> Optional post-call activity prompt
 -> Immediate sync enqueue

WorkManager sync
 -> Push pending local records
 -> Pull remote updates using cursor
 -> Update local sync metadata
```

## Core Components

### 1. App container and dependency wiring

[AppContainer.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/AppContainer.kt) is the central dependency holder.

It creates:

- the Room database
- local repositories
- the Retrofit sync API client
- the sync repository
- the sync coordinator

[EnjayCallSyncApp.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/EnjayCallSyncApp.kt) initializes the container once at application startup.

### 2. Local database

The app uses Room with database version `4` in [AppDatabase.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/local/AppDatabase.kt).

The main tables are:

- `leads`
- `lead_call_logs`
- `post_call_activities`
- `sync_metadata`

### `leads`

Stored in [LeadEntity.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/local/LeadEntity.kt).

Important fields:

- `externalId`: stable client-side ID like `lead-123`
- `serverId`: remote CRM ID after sync
- `syncState`: pending/synced/failed status
- `phoneLookupKeys`: normalized phone variants for matching
- `createdAt`, `updatedAt`, `deletedAt`

### `lead_call_logs`

Stored in [LeadCallLogEntity.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/local/LeadCallLogEntity.kt).

Important fields:

- `leadId`: local reference to the lead
- `deviceCallLogId`: unique ID from the device call log
- `callType`, `startTime`, `endTime`, `durationSeconds`
- `externalId`, `serverId`, `syncState`

This table links a device call to a CRM lead.

### `post_call_activities`

Stored in [PostCallActivityEntity.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/local/PostCallActivityEntity.kt).

Important fields:

- `leadId`
- `leadCallLogId`
- `callNotes`
- `callOutcome`
- `followUpAt`
- `nextAction`
- `additionalRemarks`
- sync metadata fields

This table stores the follow-up action taken after a call.

### `sync_metadata`

Stored in [SyncMetadataEntity.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/local/SyncMetadataEntity.kt).

Important fields:

- `deviceId`
- `lastSuccessfulCursor`
- `lastSyncStartedAt`
- `lastSyncCompletedAt`
- `lastSyncStatus`
- `lastSyncError`

This is a singleton row used to track sync state for the whole app.

### 3. Lead storage and phone matching

[RoomLeadRepository.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/repository/RoomLeadRepository.kt) handles local lead creation and duplicate prevention.

When a lead is created:

- it is inserted locally first
- it starts with `syncState = PENDING_CREATE`
- its `externalId` is assigned after insert using the local database ID
- its phone number is converted into a lookup-key blob

Phone matching uses [PhoneNumberNormalizer.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/util/PhoneNumberNormalizer.kt).

The app generates multiple lookup variants for the same number, such as:

- digits only
- number without leading zeroes
- last 10 digits
- parsed national number
- E.164-style digits

This helps the app match the same person even when the number format differs between:

- manually entered leads
- device contacts
- device call logs
- backend records

Default parsing region is currently `IN`.

### 4. Call monitoring flow

[CallMonitoringService.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/service/CallMonitoringService.kt) runs as a foreground service.

What it does:

1. listens for telephony call-state changes
2. waits for a call to move back to `IDLE`
3. scans recent device call logs
4. filters candidate calls near the detected completion time
5. finds a matching lead by normalized phone number
6. creates a `lead_call_logs` record if a lead match exists
7. enqueues an immediate sync
8. opens the post-call activity screen or shows a notification to collect follow-up details

Important behavior:

- unmatched calls are ignored for CRM storage
- blank phone numbers are ignored
- repeated handling is limited by an in-memory recently-handled call-log set
- zero-duration calls skip the post-call activity prompt

[CallMonitoringServiceManager.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/service/CallMonitoringServiceManager.kt) starts or stops the service depending on whether required permissions are granted.

### 5. Sync architecture

The sync flow is coordinated by:

- [SyncWorkScheduler.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/sync/SyncWorkScheduler.kt)
- [SyncWorker.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/sync/SyncWorker.kt)
- [SyncCoordinator.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/sync/SyncCoordinator.kt)
- [DefaultSyncRepository.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/sync/DefaultSyncRepository.kt)

### Scheduling

The app schedules sync in three common ways:

- periodic sync every 15 minutes
- immediate sync after call-log capture
- manual sync when requested from the app

At device boot, [SyncBootReceiver.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/sync/SyncBootReceiver.kt) re-enables periodic sync and also queues an immediate sync.

### Single-run protection

[SyncCoordinator.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/sync/SyncCoordinator.kt) uses a `Mutex` to prevent multiple sync runs from executing at the same time.

### Push then pull

`DefaultSyncRepository.runSync()` follows this order:

1. ensure `sync_metadata` exists
2. mark sync as running
3. push pending local records in batches
4. pull remote changes using the last successful cursor
5. save success or failure metadata

This is a local-first sync model with cursor-based incremental pull.

## What gets pushed

The app pushes three record types:

- leads
- lead call logs
- post-call activities

Each record carries both:

- a local identity (`sourceRecordId`, `externalId`)
- a remote identity (`id` or `serverId` when available)

This makes it possible for the backend to understand whether the app is:

- creating a brand new record
- updating an already-synced record
- retrying a previous record

## How pushed records are marked

Before an API call:

- pending records are loaded in batches
- `lastSyncAttemptAt` is updated
- previous sync error text is cleared

After a successful API response:

- `serverId` is stored if provided
- `syncState` becomes `SYNCED` for accepted outcomes
- `syncState` becomes `FAILED_PERMANENT` for rejected outcomes
- `updatedAt` and `lastSyncedAt` are refreshed from server timestamps when available

If a network error or server-side 5xx error happens:

- affected records are marked `FAILED_RETRYABLE`
- WorkManager may retry the job

## What gets pulled

The app pulls the same three record types from the backend:

- leads
- lead call logs
- post-call activities

The backend returns:

- records
- `nextCursor`
- `hasMore`

The app keeps pulling in batches until `hasMore` is false or the internal max-batch limit is reached.

## Merge rules during pull

### Leads

When lead data comes from the server, the app tries to find an existing local record by:

1. `serverId`
2. local source ID if the record originally came from this same device
3. `externalId`
4. phone-number lookup match

If both identity-based matching and phone-based matching find different local records, the repository consolidates them:

- one record becomes canonical
- related call logs are reassigned
- related post-call activities are reassigned
- the duplicate lead is deleted

This is one of the most important anti-duplication parts of the app.

### Call logs and post-call activities

For child records, the app first resolves their parent records locally:

- a call log must find its lead
- a post-call activity must find both its lead and call log

If parents are missing locally, the child record is skipped for that pull cycle.

## Sync identity model

The app uses several IDs for different purposes:

- `id`: local Room primary key
- `externalId`: stable client-generated identifier
- `serverId`: CRM/backend identifier after sync
- `deviceId`: device-level identity stored in `sync_metadata`
- `sourceRecordId`: local row ID sent to the server for traceability

This layered identity model is what allows the app to:

- work offline
- retry safely
- map local rows to remote rows later
- merge records from the same device without duplicating them

## API contract

[SyncApi.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/sync/SyncApi.kt) exposes two endpoints:

- `POST /api/sync/push`
- `POST /api/sync/pull`

Request and response DTOs are defined in [SyncDtos.kt](/Users/shubhoooom/Documents/EnjayCRMCallSync/app/src/main/java/com/enjay/crm/callsync/data/sync/SyncDtos.kt).

The backend is expected to:

- accept batched push payloads
- return per-record push results
- support cursor-based pull
- preserve source device and source record metadata for reconciliation

## How data is stored

In practical terms, storage works like this:

- leads are the parent CRM records
- matched device calls become `lead_call_logs`
- follow-up notes become `post_call_activities`
- sync status for each row stays with the row itself
- global sync progress stays in `sync_metadata`

That means the app can always answer:

- what has been created locally
- what still needs to sync
- what synced successfully
- what failed and should retry
- what the backend last acknowledged

## App startup and background behavior

At startup:

- the application initializes shared dependencies
- UI screens read data from Room-backed repositories

In the background:

- the call monitoring service watches live phone state
- WorkManager handles network-dependent syncing
- boot receiver restores sync scheduling after reboot

## Important limitations and implementation notes

- The backend base URL is hardcoded today.
- Release signing is not configured yet.
- Phone normalization assumes India as the default parsing region.
- The app depends on Android call-log behavior, so timing around recent-call detection may vary by device vendor.
- Build outputs and Gradle caches exist in the repo working tree, but they are generated artifacts rather than source architecture.

## Suggested next improvements

- move the backend base URL into build configuration
- add separate dev/staging/prod environments
- document the backend sync contract beside the mobile app
- add integration tests around push/pull merge cases
- persist more diagnostic sync logs for troubleshooting field issues

## Quick mental model

If someone new joins the project, the simplest way to think about it is:

1. leads are stored locally in Room
2. phone numbers are normalized so calls can be matched reliably
3. when a real phone call ends, the app looks for a matching lead
4. if matched, it stores a local CRM-linked call log
5. the app asks for post-call details
6. WorkManager pushes local records to the backend
7. the app pulls remote changes back using a cursor
8. sync metadata prevents duplicate work and helps resume safely

That is the core architecture of the app today.
