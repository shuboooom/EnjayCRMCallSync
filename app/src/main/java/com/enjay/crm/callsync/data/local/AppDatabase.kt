package com.enjay.crm.callsync.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [LeadEntity::class, LeadCallLogEntity::class, PostCallActivityEntity::class],
    version = 3,
    exportSchema = false,
)
@TypeConverters(CallSyncTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun leadDao(): LeadDao
    abstract fun leadCallLogDao(): LeadCallLogDao
    abstract fun postCallActivityDao(): PostCallActivityDao

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
    }
}
