package com.enjay.crm.callsync.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LeadDao_Impl implements LeadDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LeadEntity> __insertionAdapterOfLeadEntity;

  private final CallSyncTypeConverters __callSyncTypeConverters = new CallSyncTypeConverters();

  private final EntityDeletionOrUpdateAdapter<LeadEntity> __updateAdapterOfLeadEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLookupKeys;

  private final SharedSQLiteStatement __preparedStmtOfDeleteLeadById;

  public LeadDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLeadEntity = new EntityInsertionAdapter<LeadEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `leads` (`id`,`externalId`,`serverId`,`syncState`,`lastSyncAttemptAt`,`lastSyncedAt`,`syncError`,`deletedAt`,`name`,`phone`,`phoneLookupKeys`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LeadEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getExternalId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getExternalId());
        }
        if (entity.getServerId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getServerId());
        }
        final String _tmp = __callSyncTypeConverters.syncStateToString(entity.getSyncState());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        if (entity.getLastSyncAttemptAt() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getLastSyncAttemptAt());
        }
        if (entity.getLastSyncedAt() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getLastSyncedAt());
        }
        if (entity.getSyncError() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSyncError());
        }
        if (entity.getDeletedAt() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getDeletedAt());
        }
        if (entity.getName() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getName());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getPhone());
        }
        if (entity.getPhoneLookupKeys() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPhoneLookupKeys());
        }
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getUpdatedAt());
      }
    };
    this.__updateAdapterOfLeadEntity = new EntityDeletionOrUpdateAdapter<LeadEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `leads` SET `id` = ?,`externalId` = ?,`serverId` = ?,`syncState` = ?,`lastSyncAttemptAt` = ?,`lastSyncedAt` = ?,`syncError` = ?,`deletedAt` = ?,`name` = ?,`phone` = ?,`phoneLookupKeys` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LeadEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getExternalId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getExternalId());
        }
        if (entity.getServerId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getServerId());
        }
        final String _tmp = __callSyncTypeConverters.syncStateToString(entity.getSyncState());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        if (entity.getLastSyncAttemptAt() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getLastSyncAttemptAt());
        }
        if (entity.getLastSyncedAt() == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, entity.getLastSyncedAt());
        }
        if (entity.getSyncError() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSyncError());
        }
        if (entity.getDeletedAt() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getDeletedAt());
        }
        if (entity.getName() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getName());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getPhone());
        }
        if (entity.getPhoneLookupKeys() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPhoneLookupKeys());
        }
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getUpdatedAt());
        statement.bindLong(14, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateLookupKeys = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE leads SET phoneLookupKeys = ?, updatedAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteLeadById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM leads WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertLead(final LeadEntity lead, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfLeadEntity.insertAndReturnId(lead);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLead(final LeadEntity lead, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLeadEntity.handle(lead);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLookupKeys(final long leadId, final String phoneLookupKeys,
      final long updatedAt, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLookupKeys.acquire();
        int _argIndex = 1;
        if (phoneLookupKeys == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, phoneLookupKeys);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, updatedAt);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, leadId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateLookupKeys.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteLeadById(final long leadId, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteLeadById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, leadId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteLeadById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<LeadEntity>> observeLeads() {
    final String _sql = "SELECT * FROM leads ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"leads"}, new Callable<List<LeadEntity>>() {
      @Override
      @NonNull
      public List<LeadEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfLastSyncAttemptAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncAttemptAt");
          final int _cursorIndexOfLastSyncedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncedAt");
          final int _cursorIndexOfSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "syncError");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deletedAt");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneLookupKeys = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneLookupKeys");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<LeadEntity> _result = new ArrayList<LeadEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LeadEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getString(_cursorIndexOfServerId);
            }
            final SyncState _tmpSyncState;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __callSyncTypeConverters.stringToSyncState(_tmp);
            final Long _tmpLastSyncAttemptAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncAttemptAt)) {
              _tmpLastSyncAttemptAt = null;
            } else {
              _tmpLastSyncAttemptAt = _cursor.getLong(_cursorIndexOfLastSyncAttemptAt);
            }
            final Long _tmpLastSyncedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncedAt)) {
              _tmpLastSyncedAt = null;
            } else {
              _tmpLastSyncedAt = _cursor.getLong(_cursorIndexOfLastSyncedAt);
            }
            final String _tmpSyncError;
            if (_cursor.isNull(_cursorIndexOfSyncError)) {
              _tmpSyncError = null;
            } else {
              _tmpSyncError = _cursor.getString(_cursorIndexOfSyncError);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneLookupKeys;
            if (_cursor.isNull(_cursorIndexOfPhoneLookupKeys)) {
              _tmpPhoneLookupKeys = null;
            } else {
              _tmpPhoneLookupKeys = _cursor.getString(_cursorIndexOfPhoneLookupKeys);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new LeadEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpName,_tmpPhone,_tmpPhoneLookupKeys,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<LeadEntity> observeLeadById(final long leadId) {
    final String _sql = "SELECT * FROM leads WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, leadId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"leads"}, new Callable<LeadEntity>() {
      @Override
      @Nullable
      public LeadEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfLastSyncAttemptAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncAttemptAt");
          final int _cursorIndexOfLastSyncedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncedAt");
          final int _cursorIndexOfSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "syncError");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deletedAt");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneLookupKeys = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneLookupKeys");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LeadEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getString(_cursorIndexOfServerId);
            }
            final SyncState _tmpSyncState;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __callSyncTypeConverters.stringToSyncState(_tmp);
            final Long _tmpLastSyncAttemptAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncAttemptAt)) {
              _tmpLastSyncAttemptAt = null;
            } else {
              _tmpLastSyncAttemptAt = _cursor.getLong(_cursorIndexOfLastSyncAttemptAt);
            }
            final Long _tmpLastSyncedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncedAt)) {
              _tmpLastSyncedAt = null;
            } else {
              _tmpLastSyncedAt = _cursor.getLong(_cursorIndexOfLastSyncedAt);
            }
            final String _tmpSyncError;
            if (_cursor.isNull(_cursorIndexOfSyncError)) {
              _tmpSyncError = null;
            } else {
              _tmpSyncError = _cursor.getString(_cursorIndexOfSyncError);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneLookupKeys;
            if (_cursor.isNull(_cursorIndexOfPhoneLookupKeys)) {
              _tmpPhoneLookupKeys = null;
            } else {
              _tmpPhoneLookupKeys = _cursor.getString(_cursorIndexOfPhoneLookupKeys);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LeadEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpName,_tmpPhone,_tmpPhoneLookupKeys,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getLeadById(final long leadId, final Continuation<? super LeadEntity> $completion) {
    final String _sql = "SELECT * FROM leads WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, leadId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LeadEntity>() {
      @Override
      @Nullable
      public LeadEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfLastSyncAttemptAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncAttemptAt");
          final int _cursorIndexOfLastSyncedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncedAt");
          final int _cursorIndexOfSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "syncError");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deletedAt");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneLookupKeys = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneLookupKeys");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LeadEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getString(_cursorIndexOfServerId);
            }
            final SyncState _tmpSyncState;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __callSyncTypeConverters.stringToSyncState(_tmp);
            final Long _tmpLastSyncAttemptAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncAttemptAt)) {
              _tmpLastSyncAttemptAt = null;
            } else {
              _tmpLastSyncAttemptAt = _cursor.getLong(_cursorIndexOfLastSyncAttemptAt);
            }
            final Long _tmpLastSyncedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncedAt)) {
              _tmpLastSyncedAt = null;
            } else {
              _tmpLastSyncedAt = _cursor.getLong(_cursorIndexOfLastSyncedAt);
            }
            final String _tmpSyncError;
            if (_cursor.isNull(_cursorIndexOfSyncError)) {
              _tmpSyncError = null;
            } else {
              _tmpSyncError = _cursor.getString(_cursorIndexOfSyncError);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneLookupKeys;
            if (_cursor.isNull(_cursorIndexOfPhoneLookupKeys)) {
              _tmpPhoneLookupKeys = null;
            } else {
              _tmpPhoneLookupKeys = _cursor.getString(_cursorIndexOfPhoneLookupKeys);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LeadEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpName,_tmpPhone,_tmpPhoneLookupKeys,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllLeads(final Continuation<? super List<LeadEntity>> $completion) {
    final String _sql = "SELECT * FROM leads";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<LeadEntity>>() {
      @Override
      @NonNull
      public List<LeadEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfLastSyncAttemptAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncAttemptAt");
          final int _cursorIndexOfLastSyncedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncedAt");
          final int _cursorIndexOfSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "syncError");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deletedAt");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneLookupKeys = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneLookupKeys");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<LeadEntity> _result = new ArrayList<LeadEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LeadEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getString(_cursorIndexOfServerId);
            }
            final SyncState _tmpSyncState;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __callSyncTypeConverters.stringToSyncState(_tmp);
            final Long _tmpLastSyncAttemptAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncAttemptAt)) {
              _tmpLastSyncAttemptAt = null;
            } else {
              _tmpLastSyncAttemptAt = _cursor.getLong(_cursorIndexOfLastSyncAttemptAt);
            }
            final Long _tmpLastSyncedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncedAt)) {
              _tmpLastSyncedAt = null;
            } else {
              _tmpLastSyncedAt = _cursor.getLong(_cursorIndexOfLastSyncedAt);
            }
            final String _tmpSyncError;
            if (_cursor.isNull(_cursorIndexOfSyncError)) {
              _tmpSyncError = null;
            } else {
              _tmpSyncError = _cursor.getString(_cursorIndexOfSyncError);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneLookupKeys;
            if (_cursor.isNull(_cursorIndexOfPhoneLookupKeys)) {
              _tmpPhoneLookupKeys = null;
            } else {
              _tmpPhoneLookupKeys = _cursor.getString(_cursorIndexOfPhoneLookupKeys);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new LeadEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpName,_tmpPhone,_tmpPhoneLookupKeys,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getPendingLeads(final int limit,
      final Continuation<? super List<LeadEntity>> $completion) {
    final String _sql = "SELECT * FROM leads WHERE syncState != 'SYNCED' ORDER BY updatedAt ASC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<LeadEntity>>() {
      @Override
      @NonNull
      public List<LeadEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfLastSyncAttemptAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncAttemptAt");
          final int _cursorIndexOfLastSyncedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncedAt");
          final int _cursorIndexOfSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "syncError");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deletedAt");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneLookupKeys = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneLookupKeys");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<LeadEntity> _result = new ArrayList<LeadEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LeadEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getString(_cursorIndexOfServerId);
            }
            final SyncState _tmpSyncState;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __callSyncTypeConverters.stringToSyncState(_tmp);
            final Long _tmpLastSyncAttemptAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncAttemptAt)) {
              _tmpLastSyncAttemptAt = null;
            } else {
              _tmpLastSyncAttemptAt = _cursor.getLong(_cursorIndexOfLastSyncAttemptAt);
            }
            final Long _tmpLastSyncedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncedAt)) {
              _tmpLastSyncedAt = null;
            } else {
              _tmpLastSyncedAt = _cursor.getLong(_cursorIndexOfLastSyncedAt);
            }
            final String _tmpSyncError;
            if (_cursor.isNull(_cursorIndexOfSyncError)) {
              _tmpSyncError = null;
            } else {
              _tmpSyncError = _cursor.getString(_cursorIndexOfSyncError);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneLookupKeys;
            if (_cursor.isNull(_cursorIndexOfPhoneLookupKeys)) {
              _tmpPhoneLookupKeys = null;
            } else {
              _tmpPhoneLookupKeys = _cursor.getString(_cursorIndexOfPhoneLookupKeys);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new LeadEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpName,_tmpPhone,_tmpPhoneLookupKeys,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<Integer> observePendingLeadCount() {
    final String _sql = "SELECT COUNT(*) FROM leads WHERE syncState != 'SYNCED'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"leads"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object findLeadByLookupKey(final String wrappedLookupKey,
      final Continuation<? super LeadEntity> $completion) {
    final String _sql = "SELECT * FROM leads WHERE phoneLookupKeys LIKE '%' || ? || '%' LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (wrappedLookupKey == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, wrappedLookupKey);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LeadEntity>() {
      @Override
      @Nullable
      public LeadEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfLastSyncAttemptAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncAttemptAt");
          final int _cursorIndexOfLastSyncedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncedAt");
          final int _cursorIndexOfSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "syncError");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deletedAt");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneLookupKeys = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneLookupKeys");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LeadEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getString(_cursorIndexOfServerId);
            }
            final SyncState _tmpSyncState;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __callSyncTypeConverters.stringToSyncState(_tmp);
            final Long _tmpLastSyncAttemptAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncAttemptAt)) {
              _tmpLastSyncAttemptAt = null;
            } else {
              _tmpLastSyncAttemptAt = _cursor.getLong(_cursorIndexOfLastSyncAttemptAt);
            }
            final Long _tmpLastSyncedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncedAt)) {
              _tmpLastSyncedAt = null;
            } else {
              _tmpLastSyncedAt = _cursor.getLong(_cursorIndexOfLastSyncedAt);
            }
            final String _tmpSyncError;
            if (_cursor.isNull(_cursorIndexOfSyncError)) {
              _tmpSyncError = null;
            } else {
              _tmpSyncError = _cursor.getString(_cursorIndexOfSyncError);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneLookupKeys;
            if (_cursor.isNull(_cursorIndexOfPhoneLookupKeys)) {
              _tmpPhoneLookupKeys = null;
            } else {
              _tmpPhoneLookupKeys = _cursor.getString(_cursorIndexOfPhoneLookupKeys);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LeadEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpName,_tmpPhone,_tmpPhoneLookupKeys,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object findByServerId(final String serverId,
      final Continuation<? super LeadEntity> $completion) {
    final String _sql = "SELECT * FROM leads WHERE serverId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (serverId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, serverId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LeadEntity>() {
      @Override
      @Nullable
      public LeadEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfLastSyncAttemptAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncAttemptAt");
          final int _cursorIndexOfLastSyncedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncedAt");
          final int _cursorIndexOfSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "syncError");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deletedAt");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneLookupKeys = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneLookupKeys");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LeadEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getString(_cursorIndexOfServerId);
            }
            final SyncState _tmpSyncState;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __callSyncTypeConverters.stringToSyncState(_tmp);
            final Long _tmpLastSyncAttemptAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncAttemptAt)) {
              _tmpLastSyncAttemptAt = null;
            } else {
              _tmpLastSyncAttemptAt = _cursor.getLong(_cursorIndexOfLastSyncAttemptAt);
            }
            final Long _tmpLastSyncedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncedAt)) {
              _tmpLastSyncedAt = null;
            } else {
              _tmpLastSyncedAt = _cursor.getLong(_cursorIndexOfLastSyncedAt);
            }
            final String _tmpSyncError;
            if (_cursor.isNull(_cursorIndexOfSyncError)) {
              _tmpSyncError = null;
            } else {
              _tmpSyncError = _cursor.getString(_cursorIndexOfSyncError);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneLookupKeys;
            if (_cursor.isNull(_cursorIndexOfPhoneLookupKeys)) {
              _tmpPhoneLookupKeys = null;
            } else {
              _tmpPhoneLookupKeys = _cursor.getString(_cursorIndexOfPhoneLookupKeys);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LeadEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpName,_tmpPhone,_tmpPhoneLookupKeys,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object findByExternalId(final String externalId,
      final Continuation<? super LeadEntity> $completion) {
    final String _sql = "SELECT * FROM leads WHERE externalId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (externalId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, externalId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LeadEntity>() {
      @Override
      @Nullable
      public LeadEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfExternalId = CursorUtil.getColumnIndexOrThrow(_cursor, "externalId");
          final int _cursorIndexOfServerId = CursorUtil.getColumnIndexOrThrow(_cursor, "serverId");
          final int _cursorIndexOfSyncState = CursorUtil.getColumnIndexOrThrow(_cursor, "syncState");
          final int _cursorIndexOfLastSyncAttemptAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncAttemptAt");
          final int _cursorIndexOfLastSyncedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncedAt");
          final int _cursorIndexOfSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "syncError");
          final int _cursorIndexOfDeletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "deletedAt");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneLookupKeys = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneLookupKeys");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LeadEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpExternalId;
            if (_cursor.isNull(_cursorIndexOfExternalId)) {
              _tmpExternalId = null;
            } else {
              _tmpExternalId = _cursor.getString(_cursorIndexOfExternalId);
            }
            final String _tmpServerId;
            if (_cursor.isNull(_cursorIndexOfServerId)) {
              _tmpServerId = null;
            } else {
              _tmpServerId = _cursor.getString(_cursorIndexOfServerId);
            }
            final SyncState _tmpSyncState;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSyncState)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSyncState);
            }
            _tmpSyncState = __callSyncTypeConverters.stringToSyncState(_tmp);
            final Long _tmpLastSyncAttemptAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncAttemptAt)) {
              _tmpLastSyncAttemptAt = null;
            } else {
              _tmpLastSyncAttemptAt = _cursor.getLong(_cursorIndexOfLastSyncAttemptAt);
            }
            final Long _tmpLastSyncedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncedAt)) {
              _tmpLastSyncedAt = null;
            } else {
              _tmpLastSyncedAt = _cursor.getLong(_cursorIndexOfLastSyncedAt);
            }
            final String _tmpSyncError;
            if (_cursor.isNull(_cursorIndexOfSyncError)) {
              _tmpSyncError = null;
            } else {
              _tmpSyncError = _cursor.getString(_cursorIndexOfSyncError);
            }
            final Long _tmpDeletedAt;
            if (_cursor.isNull(_cursorIndexOfDeletedAt)) {
              _tmpDeletedAt = null;
            } else {
              _tmpDeletedAt = _cursor.getLong(_cursorIndexOfDeletedAt);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneLookupKeys;
            if (_cursor.isNull(_cursorIndexOfPhoneLookupKeys)) {
              _tmpPhoneLookupKeys = null;
            } else {
              _tmpPhoneLookupKeys = _cursor.getString(_cursorIndexOfPhoneLookupKeys);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LeadEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpName,_tmpPhone,_tmpPhoneLookupKeys,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
