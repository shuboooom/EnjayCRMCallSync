package com.enjay.crm.callsync.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile LeadDao _leadDao;

  private volatile LeadCallLogDao _leadCallLogDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `leads` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `phone` TEXT NOT NULL, `phoneLookupKeys` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `lead_call_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `leadId` INTEGER NOT NULL, `deviceCallLogId` INTEGER NOT NULL, `phoneNumber` TEXT NOT NULL, `callType` TEXT NOT NULL, `startTime` INTEGER NOT NULL, `endTime` INTEGER NOT NULL, `durationSeconds` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, FOREIGN KEY(`leadId`) REFERENCES `leads`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_lead_call_logs_leadId` ON `lead_call_logs` (`leadId`)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_lead_call_logs_deviceCallLogId` ON `lead_call_logs` (`deviceCallLogId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '971193405110fd5aaf2d8dc8b9d3d0ab')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `leads`");
        db.execSQL("DROP TABLE IF EXISTS `lead_call_logs`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsLeads = new HashMap<String, TableInfo.Column>(6);
        _columnsLeads.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("phoneLookupKeys", new TableInfo.Column("phoneLookupKeys", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLeads = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLeads = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLeads = new TableInfo("leads", _columnsLeads, _foreignKeysLeads, _indicesLeads);
        final TableInfo _existingLeads = TableInfo.read(db, "leads");
        if (!_infoLeads.equals(_existingLeads)) {
          return new RoomOpenHelper.ValidationResult(false, "leads(com.enjay.crm.callsync.data.local.LeadEntity).\n"
                  + " Expected:\n" + _infoLeads + "\n"
                  + " Found:\n" + _existingLeads);
        }
        final HashMap<String, TableInfo.Column> _columnsLeadCallLogs = new HashMap<String, TableInfo.Column>(10);
        _columnsLeadCallLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("leadId", new TableInfo.Column("leadId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("deviceCallLogId", new TableInfo.Column("deviceCallLogId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("callType", new TableInfo.Column("callType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("endTime", new TableInfo.Column("endTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("durationSeconds", new TableInfo.Column("durationSeconds", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeadCallLogs.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLeadCallLogs = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysLeadCallLogs.add(new TableInfo.ForeignKey("leads", "CASCADE", "NO ACTION", Arrays.asList("leadId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesLeadCallLogs = new HashSet<TableInfo.Index>(2);
        _indicesLeadCallLogs.add(new TableInfo.Index("index_lead_call_logs_leadId", false, Arrays.asList("leadId"), Arrays.asList("ASC")));
        _indicesLeadCallLogs.add(new TableInfo.Index("index_lead_call_logs_deviceCallLogId", true, Arrays.asList("deviceCallLogId"), Arrays.asList("ASC")));
        final TableInfo _infoLeadCallLogs = new TableInfo("lead_call_logs", _columnsLeadCallLogs, _foreignKeysLeadCallLogs, _indicesLeadCallLogs);
        final TableInfo _existingLeadCallLogs = TableInfo.read(db, "lead_call_logs");
        if (!_infoLeadCallLogs.equals(_existingLeadCallLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "lead_call_logs(com.enjay.crm.callsync.data.local.LeadCallLogEntity).\n"
                  + " Expected:\n" + _infoLeadCallLogs + "\n"
                  + " Found:\n" + _existingLeadCallLogs);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "971193405110fd5aaf2d8dc8b9d3d0ab", "a5be8146d678f16bd49795b49dce5128");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "leads","lead_call_logs");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `leads`");
      _db.execSQL("DELETE FROM `lead_call_logs`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LeadDao.class, LeadDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LeadCallLogDao.class, LeadCallLogDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public LeadDao leadDao() {
    if (_leadDao != null) {
      return _leadDao;
    } else {
      synchronized(this) {
        if(_leadDao == null) {
          _leadDao = new LeadDao_Impl(this);
        }
        return _leadDao;
      }
    }
  }

  @Override
  public LeadCallLogDao leadCallLogDao() {
    if (_leadCallLogDao != null) {
      return _leadCallLogDao;
    } else {
      synchronized(this) {
        if(_leadCallLogDao == null) {
          _leadCallLogDao = new LeadCallLogDao_Impl(this);
        }
        return _leadCallLogDao;
      }
    }
  }
}
