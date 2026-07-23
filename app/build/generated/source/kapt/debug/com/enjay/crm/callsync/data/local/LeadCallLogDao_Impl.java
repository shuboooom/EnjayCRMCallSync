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
import com.enjay.crm.callsync.data.model.CallType;
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
public final class LeadCallLogDao_Impl implements LeadCallLogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LeadCallLogEntity> __insertionAdapterOfLeadCallLogEntity;

  private final CallSyncTypeConverters __callSyncTypeConverters = new CallSyncTypeConverters();

  private final EntityDeletionOrUpdateAdapter<LeadCallLogEntity> __updateAdapterOfLeadCallLogEntity;

  private final SharedSQLiteStatement __preparedStmtOfReassignLead;

  public LeadCallLogDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLeadCallLogEntity = new EntityInsertionAdapter<LeadCallLogEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `lead_call_logs` (`id`,`externalId`,`serverId`,`syncState`,`lastSyncAttemptAt`,`lastSyncedAt`,`syncError`,`deletedAt`,`leadId`,`deviceCallLogId`,`phoneNumber`,`callType`,`startTime`,`endTime`,`durationSeconds`,`timestamp`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LeadCallLogEntity entity) {
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
        statement.bindLong(9, entity.getLeadId());
        statement.bindLong(10, entity.getDeviceCallLogId());
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPhoneNumber());
        }
        final String _tmp_1 = __callSyncTypeConverters.callTypeToString(entity.getCallType());
        if (_tmp_1 == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, _tmp_1);
        }
        statement.bindLong(13, entity.getStartTime());
        statement.bindLong(14, entity.getEndTime());
        statement.bindLong(15, entity.getDurationSeconds());
        statement.bindLong(16, entity.getTimestamp());
        statement.bindLong(17, entity.getCreatedAt());
        statement.bindLong(18, entity.getUpdatedAt());
      }
    };
    this.__updateAdapterOfLeadCallLogEntity = new EntityDeletionOrUpdateAdapter<LeadCallLogEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `lead_call_logs` SET `id` = ?,`externalId` = ?,`serverId` = ?,`syncState` = ?,`lastSyncAttemptAt` = ?,`lastSyncedAt` = ?,`syncError` = ?,`deletedAt` = ?,`leadId` = ?,`deviceCallLogId` = ?,`phoneNumber` = ?,`callType` = ?,`startTime` = ?,`endTime` = ?,`durationSeconds` = ?,`timestamp` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LeadCallLogEntity entity) {
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
        statement.bindLong(9, entity.getLeadId());
        statement.bindLong(10, entity.getDeviceCallLogId());
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPhoneNumber());
        }
        final String _tmp_1 = __callSyncTypeConverters.callTypeToString(entity.getCallType());
        if (_tmp_1 == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, _tmp_1);
        }
        statement.bindLong(13, entity.getStartTime());
        statement.bindLong(14, entity.getEndTime());
        statement.bindLong(15, entity.getDurationSeconds());
        statement.bindLong(16, entity.getTimestamp());
        statement.bindLong(17, entity.getCreatedAt());
        statement.bindLong(18, entity.getUpdatedAt());
        statement.bindLong(19, entity.getId());
      }
    };
    this.__preparedStmtOfReassignLead = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE lead_call_logs SET leadId = ? WHERE leadId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertLeadCallLog(final LeadCallLogEntity callLog,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfLeadCallLogEntity.insertAndReturnId(callLog);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateLeadCallLog(final LeadCallLogEntity callLog,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLeadCallLogEntity.handle(callLog);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object reassignLead(final long fromLeadId, final long toLeadId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfReassignLead.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, toLeadId);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, fromLeadId);
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
          __preparedStmtOfReassignLead.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<LeadCallLogEntity>> observeLeadCallLogs(final long leadId) {
    final String _sql = "SELECT * FROM lead_call_logs WHERE leadId = ? ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, leadId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"lead_call_logs"}, new Callable<List<LeadCallLogEntity>>() {
      @Override
      @NonNull
      public List<LeadCallLogEntity> call() throws Exception {
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
          final int _cursorIndexOfLeadId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadId");
          final int _cursorIndexOfDeviceCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceCallLogId");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfCallType = CursorUtil.getColumnIndexOrThrow(_cursor, "callType");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "durationSeconds");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<LeadCallLogEntity> _result = new ArrayList<LeadCallLogEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LeadCallLogEntity _item;
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
            final long _tmpLeadId;
            _tmpLeadId = _cursor.getLong(_cursorIndexOfLeadId);
            final long _tmpDeviceCallLogId;
            _tmpDeviceCallLogId = _cursor.getLong(_cursorIndexOfDeviceCallLogId);
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final CallType _tmpCallType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCallType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfCallType);
            }
            _tmpCallType = __callSyncTypeConverters.stringToCallType(_tmp_1);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final long _tmpEndTime;
            _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            final long _tmpDurationSeconds;
            _tmpDurationSeconds = _cursor.getLong(_cursorIndexOfDurationSeconds);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new LeadCallLogEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpDeviceCallLogId,_tmpPhoneNumber,_tmpCallType,_tmpStartTime,_tmpEndTime,_tmpDurationSeconds,_tmpTimestamp,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getPendingLeadCallLogs(final int limit,
      final Continuation<? super List<LeadCallLogEntity>> $completion) {
    final String _sql = "SELECT * FROM lead_call_logs WHERE syncState != 'SYNCED' ORDER BY timestamp ASC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<LeadCallLogEntity>>() {
      @Override
      @NonNull
      public List<LeadCallLogEntity> call() throws Exception {
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
          final int _cursorIndexOfLeadId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadId");
          final int _cursorIndexOfDeviceCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceCallLogId");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfCallType = CursorUtil.getColumnIndexOrThrow(_cursor, "callType");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "durationSeconds");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<LeadCallLogEntity> _result = new ArrayList<LeadCallLogEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LeadCallLogEntity _item;
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
            final long _tmpLeadId;
            _tmpLeadId = _cursor.getLong(_cursorIndexOfLeadId);
            final long _tmpDeviceCallLogId;
            _tmpDeviceCallLogId = _cursor.getLong(_cursorIndexOfDeviceCallLogId);
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final CallType _tmpCallType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCallType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfCallType);
            }
            _tmpCallType = __callSyncTypeConverters.stringToCallType(_tmp_1);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final long _tmpEndTime;
            _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            final long _tmpDurationSeconds;
            _tmpDurationSeconds = _cursor.getLong(_cursorIndexOfDurationSeconds);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new LeadCallLogEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpDeviceCallLogId,_tmpPhoneNumber,_tmpCallType,_tmpStartTime,_tmpEndTime,_tmpDurationSeconds,_tmpTimestamp,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<Integer> observePendingLeadCallLogCount() {
    final String _sql = "SELECT COUNT(*) FROM lead_call_logs WHERE syncState != 'SYNCED'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"lead_call_logs"}, new Callable<Integer>() {
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
  public Object getById(final long id, final Continuation<? super LeadCallLogEntity> $completion) {
    final String _sql = "SELECT * FROM lead_call_logs WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LeadCallLogEntity>() {
      @Override
      @Nullable
      public LeadCallLogEntity call() throws Exception {
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
          final int _cursorIndexOfLeadId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadId");
          final int _cursorIndexOfDeviceCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceCallLogId");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfCallType = CursorUtil.getColumnIndexOrThrow(_cursor, "callType");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "durationSeconds");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LeadCallLogEntity _result;
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
            final long _tmpLeadId;
            _tmpLeadId = _cursor.getLong(_cursorIndexOfLeadId);
            final long _tmpDeviceCallLogId;
            _tmpDeviceCallLogId = _cursor.getLong(_cursorIndexOfDeviceCallLogId);
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final CallType _tmpCallType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCallType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfCallType);
            }
            _tmpCallType = __callSyncTypeConverters.stringToCallType(_tmp_1);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final long _tmpEndTime;
            _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            final long _tmpDurationSeconds;
            _tmpDurationSeconds = _cursor.getLong(_cursorIndexOfDurationSeconds);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LeadCallLogEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpDeviceCallLogId,_tmpPhoneNumber,_tmpCallType,_tmpStartTime,_tmpEndTime,_tmpDurationSeconds,_tmpTimestamp,_tmpCreatedAt,_tmpUpdatedAt);
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
      final Continuation<? super LeadCallLogEntity> $completion) {
    final String _sql = "SELECT * FROM lead_call_logs WHERE serverId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (serverId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, serverId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LeadCallLogEntity>() {
      @Override
      @Nullable
      public LeadCallLogEntity call() throws Exception {
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
          final int _cursorIndexOfLeadId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadId");
          final int _cursorIndexOfDeviceCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceCallLogId");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfCallType = CursorUtil.getColumnIndexOrThrow(_cursor, "callType");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "durationSeconds");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LeadCallLogEntity _result;
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
            final long _tmpLeadId;
            _tmpLeadId = _cursor.getLong(_cursorIndexOfLeadId);
            final long _tmpDeviceCallLogId;
            _tmpDeviceCallLogId = _cursor.getLong(_cursorIndexOfDeviceCallLogId);
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final CallType _tmpCallType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCallType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfCallType);
            }
            _tmpCallType = __callSyncTypeConverters.stringToCallType(_tmp_1);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final long _tmpEndTime;
            _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            final long _tmpDurationSeconds;
            _tmpDurationSeconds = _cursor.getLong(_cursorIndexOfDurationSeconds);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LeadCallLogEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpDeviceCallLogId,_tmpPhoneNumber,_tmpCallType,_tmpStartTime,_tmpEndTime,_tmpDurationSeconds,_tmpTimestamp,_tmpCreatedAt,_tmpUpdatedAt);
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
      final Continuation<? super LeadCallLogEntity> $completion) {
    final String _sql = "SELECT * FROM lead_call_logs WHERE externalId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (externalId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, externalId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LeadCallLogEntity>() {
      @Override
      @Nullable
      public LeadCallLogEntity call() throws Exception {
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
          final int _cursorIndexOfLeadId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadId");
          final int _cursorIndexOfDeviceCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceCallLogId");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfCallType = CursorUtil.getColumnIndexOrThrow(_cursor, "callType");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "durationSeconds");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final LeadCallLogEntity _result;
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
            final long _tmpLeadId;
            _tmpLeadId = _cursor.getLong(_cursorIndexOfLeadId);
            final long _tmpDeviceCallLogId;
            _tmpDeviceCallLogId = _cursor.getLong(_cursorIndexOfDeviceCallLogId);
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final CallType _tmpCallType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCallType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfCallType);
            }
            _tmpCallType = __callSyncTypeConverters.stringToCallType(_tmp_1);
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final long _tmpEndTime;
            _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            final long _tmpDurationSeconds;
            _tmpDurationSeconds = _cursor.getLong(_cursorIndexOfDurationSeconds);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new LeadCallLogEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpDeviceCallLogId,_tmpPhoneNumber,_tmpCallType,_tmpStartTime,_tmpEndTime,_tmpDurationSeconds,_tmpTimestamp,_tmpCreatedAt,_tmpUpdatedAt);
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
