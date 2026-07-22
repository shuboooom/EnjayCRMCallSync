package com.enjay.crm.callsync.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.enjay.crm.callsync.data.model.CallType;
import java.lang.Class;
import java.lang.Exception;
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
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LeadCallLogDao_Impl implements LeadCallLogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LeadCallLogEntity> __insertionAdapterOfLeadCallLogEntity;

  private final CallSyncTypeConverters __callSyncTypeConverters = new CallSyncTypeConverters();

  public LeadCallLogDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLeadCallLogEntity = new EntityInsertionAdapter<LeadCallLogEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `lead_call_logs` (`id`,`leadId`,`deviceCallLogId`,`phoneNumber`,`callType`,`startTime`,`endTime`,`durationSeconds`,`timestamp`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LeadCallLogEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getLeadId());
        statement.bindLong(3, entity.getDeviceCallLogId());
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhoneNumber());
        }
        final String _tmp = __callSyncTypeConverters.callTypeToString(entity.getCallType());
        if (_tmp == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp);
        }
        statement.bindLong(6, entity.getStartTime());
        statement.bindLong(7, entity.getEndTime());
        statement.bindLong(8, entity.getDurationSeconds());
        statement.bindLong(9, entity.getTimestamp());
        statement.bindLong(10, entity.getCreatedAt());
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
          final int _cursorIndexOfLeadId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadId");
          final int _cursorIndexOfDeviceCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceCallLogId");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfCallType = CursorUtil.getColumnIndexOrThrow(_cursor, "callType");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "durationSeconds");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<LeadCallLogEntity> _result = new ArrayList<LeadCallLogEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LeadCallLogEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
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
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCallType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCallType);
            }
            _tmpCallType = __callSyncTypeConverters.stringToCallType(_tmp);
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
            _item = new LeadCallLogEntity(_tmpId,_tmpLeadId,_tmpDeviceCallLogId,_tmpPhoneNumber,_tmpCallType,_tmpStartTime,_tmpEndTime,_tmpDurationSeconds,_tmpTimestamp,_tmpCreatedAt);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
