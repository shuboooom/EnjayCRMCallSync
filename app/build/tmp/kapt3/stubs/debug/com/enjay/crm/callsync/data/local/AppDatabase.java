package com.enjay.crm.callsync.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/enjay/crm/callsync/data/local/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "leadCallLogDao", "Lcom/enjay/crm/callsync/data/local/LeadCallLogDao;", "leadDao", "Lcom/enjay/crm/callsync/data/local/LeadDao;", "postCallActivityDao", "Lcom/enjay/crm/callsync/data/local/PostCallActivityDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.enjay.crm.callsync.data.local.LeadEntity.class, com.enjay.crm.callsync.data.local.LeadCallLogEntity.class, com.enjay.crm.callsync.data.local.PostCallActivityEntity.class}, version = 3, exportSchema = false)
@androidx.room.TypeConverters(value = {com.enjay.crm.callsync.data.local.CallSyncTypeConverters.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_2_3 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.enjay.crm.callsync.data.local.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.enjay.crm.callsync.data.local.LeadDao leadDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.enjay.crm.callsync.data.local.LeadCallLogDao leadCallLogDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.enjay.crm.callsync.data.local.PostCallActivityDao postCallActivityDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/enjay/crm/callsync/data/local/AppDatabase$Companion;", "", "()V", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_1_2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_2_3() {
            return null;
        }
    }
}