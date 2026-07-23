# EnjayCRMCallSync Build Instructions

This project is an android app/module to listen to calls and do some checks and link call logs with leads so it can sync with CRM.

For a fuller setup guide plus architecture overview, see [SETUP_AND_ARCHITECTURE.md](/Users/shubhoooom/Documents/EnjayCRMCallSync/SETUP_AND_ARCHITECTURE.md).

## Requirements

- Android Studio Ladybug or newer is recommended
- Android SDK with:
  - `compileSdk = 35`
  - `targetSdk = 35`
  - `minSdk = 26`
- JDK 17
- Internet access for Gradle dependency download on the first build

## Project Stack

- Android Gradle Plugin: `8.5.2`
- Kotlin: `1.9.24`
- Gradle Wrapper: use `./gradlew`

## Initial Setup

1. Clone or download the repository.
2. Open the project in Android Studio, or use the terminal from the project root.
3. Make sure your local Android SDK path is configured in `local.properties`.

Example `local.properties`:

```properties
sdk.dir=/Users/your-username/Library/Android/sdk
```

Important:
- `local.properties` is machine-specific and should not be shared or committed.

## Build From Android Studio

1. Open the project in Android Studio.
2. Allow Gradle sync to complete.
3. Select an emulator or connected Android device.
4. Click `Run` to install the debug build.

## Build From Command Line

Run all commands from the project root:

### Build debug APK

```bash
./gradlew assembleDebug
```

Generated APK:

```text
app/build/outputs/apk/debug/app-debug.apk
```

### Build release APK

```bash
./gradlew assembleRelease
```

Note:
- Release signing is not configured in this project yet.
- Without a custom signing config, release output is not ready for Play Store distribution.

### Build Android App Bundle

```bash
./gradlew bundleRelease
```

## Install Debug Build on a Connected Device

```bash
./gradlew installDebug
```

## Run Tests

### Unit tests

```bash
./gradlew testDebugUnitTest
```

### Instrumentation tests

Connect an emulator or physical Android device first, then run:

```bash
./gradlew connectedDebugAndroidTest
```

## Clean Build

```bash
./gradlew clean
```

## Verified Commands

The following commands were successfully run for this repository:

```bash
./gradlew tasks --all
./gradlew assembleDebug testDebugUnitTest
```

## Notes for Sharing

- The app package name is `com.enjay.crm.callsync`.
- The app currently requests permissions for call logs, contacts, phone state, notifications, and foreground services.
- The codebase currently includes a hardcoded backend base URL in `app/src/main/java/com/enjay/crm/callsync/data/AppContainer.kt`.

## Troubleshooting

### Gradle sync fails

- Confirm JDK 17 is selected.
- Confirm Android SDK Platform 35 is installed.
- Confirm `local.properties` points to a valid SDK location.

### Build works in Android Studio but not in terminal

- Use the Gradle wrapper included in the repo:

```bash
./gradlew
```

- Do not rely on a separately installed Gradle version.

### Device install fails

- Enable Developer Options and USB debugging on the device.
- Verify the device appears in:

```bash
adb devices
```
