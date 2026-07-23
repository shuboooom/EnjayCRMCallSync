package com.enjay.crm.callsync.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [LeadEntity::class, LeadCallLogEntity::class, PostCallActivityEntity::class, SyncMetadataEntity::class],
    version = 4,
    exportSchema = false,
)
@TypeConverters(CallSyncTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun leadDao(): LeadDao
    abstract fun leadCallLogDao(): LeadCallLogDao
    abstract fun postCallActivityDao(): PostCallActivityDao
    abstract fun syncMetadataDao(): SyncMetadataDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """
                    ALTER TABLE leads
                    ADD COLUMN phoneLookupKeys TEXT NOT NULL DEFAULT ''
                    """.trimIndent(),
                )
                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS lead_call_logs (
                        id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        leadId INTEGER NOT NULL,
                        deviceCallLogId INTEGER NOT NULL,
                        phoneNumber TEXT NOT NULL,
                        callType TEXT NOT NULL,
                        startTime INTEGER NOT NULL,
                        endTime INTEGER NOT NULL,
                        durationSeconds INTEGER NOT NULL,
                        timestamp INTEGER NOT NULL,
                        createdAt INTEGER NOT NULL,
                        updatedAt INTEGER NOT NULL,
                        FOREIGN KEY(leadId) REFERENCES leads(id) ON DELETE CASCADE
                    )
                    """.trimIndent(),
                )
                db.execSQL(
                    """
                    CREATE INDEX IF NOT EXISTS index_lead_call_logs_leadId
                    ON lead_call_logs(leadId)
                    """.trimIndent(),
                )
                db.execSQL(
                    """
                    CREATE UNIQUE INDEX IF NOT EXISTS index_lead_call_logs_deviceCallLogId
                    ON lead_call_logs(deviceCallLogId)
                    """.trimIndent(),
                )
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS post_call_activities (
                        id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        leadId INTEGER NOT NULL,
                        leadCallLogId INTEGER NOT NULL,
                        callNotes TEXT NOT NULL,
                        callOutcome TEXT NOT NULL,
                        followUpAt INTEGER NOT NULL,
                        nextAction TEXT NOT NULL,
                        additionalRemarks TEXT,
                        createdAt INTEGER NOT NULL,
                        updatedAt INTEGER NOT NULL,
                        FOREIGN KEY(leadId) REFERENCES leads(id) ON DELETE CASCADE,
                        FOREIGN KEY(leadCallLogId) REFERENCES lead_call_logs(id) ON DELETE CASCADE
                    )
                    """.trimIndent(),
                )
                db.execSQL(
                    """
                    CREATE INDEX IF NOT EXISTS index_post_call_activities_leadId
                    ON post_call_activities(leadId)
                    """.trimIndent(),
                )
                db.execSQL(
                    """
                    CREATE INDEX IF NOT EXISTS index_post_call_activities_leadCallLogId
                    ON post_call_activities(leadCallLogId)
                    """.trimIndent(),
                )
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE leads ADD COLUMN externalId TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE leads ADD COLUMN serverId TEXT")
                db.execSQL("ALTER TABLE leads ADD COLUMN syncState TEXT NOT NULL DEFAULT 'PENDING_CREATE'")
                db.execSQL("ALTER TABLE leads ADD COLUMN lastSyncAttemptAt INTEGER")
                db.execSQL("ALTER TABLE leads ADD COLUMN lastSyncedAt INTEGER")
                db.execSQL("ALTER TABLE leads ADD COLUMN syncError TEXT")
                db.execSQL("ALTER TABLE leads ADD COLUMN deletedAt INTEGER")
                db.execSQL("UPDATE leads SET externalId = 'lead-' || id WHERE externalId = ''")
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_leads_externalId ON leads(externalId)")
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_leads_serverId ON leads(serverId)")

                db.execSQL("ALTER TABLE lead_call_logs ADD COLUMN externalId TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE lead_call_logs ADD COLUMN serverId TEXT")
                db.execSQL("ALTER TABLE lead_call_logs ADD COLUMN syncState TEXT NOT NULL DEFAULT 'PENDING_CREATE'")
                db.execSQL("ALTER TABLE lead_call_logs ADD COLUMN lastSyncAttemptAt INTEGER")
                db.execSQL("ALTER TABLE lead_call_logs ADD COLUMN lastSyncedAt INTEGER")
                db.execSQL("ALTER TABLE lead_call_logs ADD COLUMN syncError TEXT")
                db.execSQL("ALTER TABLE lead_call_logs ADD COLUMN deletedAt INTEGER")
                db.execSQL("ALTER TABLE lead_call_logs ADD COLUMN updatedAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("UPDATE lead_call_logs SET updatedAt = createdAt WHERE updatedAt = 0")
                db.execSQL("UPDATE lead_call_logs SET externalId = 'call-' || deviceCallLogId WHERE externalId = ''")
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_lead_call_logs_externalId ON lead_call_logs(externalId)")
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_lead_call_logs_serverId ON lead_call_logs(serverId)")

                db.execSQL("ALTER TABLE post_call_activities ADD COLUMN externalId TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE post_call_activities ADD COLUMN serverId TEXT")
                db.execSQL("ALTER TABLE post_call_activities ADD COLUMN syncState TEXT NOT NULL DEFAULT 'PENDING_CREATE'")
                db.execSQL("ALTER TABLE post_call_activities ADD COLUMN lastSyncAttemptAt INTEGER")
                db.execSQL("ALTER TABLE post_call_activities ADD COLUMN lastSyncedAt INTEGER")
                db.execSQL("ALTER TABLE post_call_activities ADD COLUMN syncError TEXT")
                db.execSQL("ALTER TABLE post_call_activities ADD COLUMN deletedAt INTEGER")
                db.execSQL("UPDATE post_call_activities SET externalId = 'activity-' || id WHERE externalId = ''")
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_post_call_activities_externalId ON post_call_activities(externalId)")
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_post_call_activities_serverId ON post_call_activities(serverId)")

                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS sync_metadata (
                        id INTEGER NOT NULL PRIMARY KEY,
                        deviceId TEXT NOT NULL,
                        lastSuccessfulCursor TEXT,
                        lastSyncStartedAt INTEGER,
                        lastSyncCompletedAt INTEGER,
                        lastSyncStatus TEXT,
                        lastSyncError TEXT
                    )
                    """.trimIndent(),
                )
            }
        }
    }
}
