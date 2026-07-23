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
public final class PostCallActivityDao_Impl implements PostCallActivityDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PostCallActivityEntity> __insertionAdapterOfPostCallActivityEntity;

  private final CallSyncTypeConverters __callSyncTypeConverters = new CallSyncTypeConverters();

  private final EntityDeletionOrUpdateAdapter<PostCallActivityEntity> __updateAdapterOfPostCallActivityEntity;

  private final SharedSQLiteStatement __preparedStmtOfReassignLead;

  public PostCallActivityDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPostCallActivityEntity = new EntityInsertionAdapter<PostCallActivityEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `post_call_activities` (`id`,`externalId`,`serverId`,`syncState`,`lastSyncAttemptAt`,`lastSyncedAt`,`syncError`,`deletedAt`,`leadId`,`leadCallLogId`,`callNotes`,`callOutcome`,`followUpAt`,`nextAction`,`additionalRemarks`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PostCallActivityEntity entity) {
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
        statement.bindLong(10, entity.getLeadCallLogId());
        if (entity.getCallNotes() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getCallNotes());
        }
        if (entity.getCallOutcome() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getCallOutcome());
        }
        statement.bindLong(13, entity.getFollowUpAt());
        if (entity.getNextAction() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getNextAction());
        }
        if (entity.getAdditionalRemarks() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getAdditionalRemarks());
        }
        statement.bindLong(16, entity.getCreatedAt());
        statement.bindLong(17, entity.getUpdatedAt());
      }
    };
    this.__updateAdapterOfPostCallActivityEntity = new EntityDeletionOrUpdateAdapter<PostCallActivityEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `post_call_activities` SET `id` = ?,`externalId` = ?,`serverId` = ?,`syncState` = ?,`lastSyncAttemptAt` = ?,`lastSyncedAt` = ?,`syncError` = ?,`deletedAt` = ?,`leadId` = ?,`leadCallLogId` = ?,`callNotes` = ?,`callOutcome` = ?,`followUpAt` = ?,`nextAction` = ?,`additionalRemarks` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PostCallActivityEntity entity) {
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
        statement.bindLong(10, entity.getLeadCallLogId());
        if (entity.getCallNotes() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getCallNotes());
        }
        if (entity.getCallOutcome() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getCallOutcome());
        }
        statement.bindLong(13, entity.getFollowUpAt());
        if (entity.getNextAction() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getNextAction());
        }
        if (entity.getAdditionalRemarks() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getAdditionalRemarks());
        }
        statement.bindLong(16, entity.getCreatedAt());
        statement.bindLong(17, entity.getUpdatedAt());
        statement.bindLong(18, entity.getId());
      }
    };
    this.__preparedStmtOfReassignLead = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE post_call_activities SET leadId = ? WHERE leadId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertPostCallActivity(final PostCallActivityEntity activity,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPostCallActivityEntity.insertAndReturnId(activity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePostCallActivity(final PostCallActivityEntity activity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPostCallActivityEntity.handle(activity);
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
  public Flow<List<PostCallActivityEntity>> observePostCallActivitiesByLeadId(final long leadId) {
    final String _sql = "SELECT * FROM post_call_activities WHERE leadId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, leadId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"post_call_activities"}, new Callable<List<PostCallActivityEntity>>() {
      @Override
      @NonNull
      public List<PostCallActivityEntity> call() throws Exception {
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
          final int _cursorIndexOfLeadCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadCallLogId");
          final int _cursorIndexOfCallNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "callNotes");
          final int _cursorIndexOfCallOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "callOutcome");
          final int _cursorIndexOfFollowUpAt = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpAt");
          final int _cursorIndexOfNextAction = CursorUtil.getColumnIndexOrThrow(_cursor, "nextAction");
          final int _cursorIndexOfAdditionalRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "additionalRemarks");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<PostCallActivityEntity> _result = new ArrayList<PostCallActivityEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PostCallActivityEntity _item;
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
            final long _tmpLeadCallLogId;
            _tmpLeadCallLogId = _cursor.getLong(_cursorIndexOfLeadCallLogId);
            final String _tmpCallNotes;
            if (_cursor.isNull(_cursorIndexOfCallNotes)) {
              _tmpCallNotes = null;
            } else {
              _tmpCallNotes = _cursor.getString(_cursorIndexOfCallNotes);
            }
            final String _tmpCallOutcome;
            if (_cursor.isNull(_cursorIndexOfCallOutcome)) {
              _tmpCallOutcome = null;
            } else {
              _tmpCallOutcome = _cursor.getString(_cursorIndexOfCallOutcome);
            }
            final long _tmpFollowUpAt;
            _tmpFollowUpAt = _cursor.getLong(_cursorIndexOfFollowUpAt);
            final String _tmpNextAction;
            if (_cursor.isNull(_cursorIndexOfNextAction)) {
              _tmpNextAction = null;
            } else {
              _tmpNextAction = _cursor.getString(_cursorIndexOfNextAction);
            }
            final String _tmpAdditionalRemarks;
            if (_cursor.isNull(_cursorIndexOfAdditionalRemarks)) {
              _tmpAdditionalRemarks = null;
            } else {
              _tmpAdditionalRemarks = _cursor.getString(_cursorIndexOfAdditionalRemarks);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new PostCallActivityEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpLeadCallLogId,_tmpCallNotes,_tmpCallOutcome,_tmpFollowUpAt,_tmpNextAction,_tmpAdditionalRemarks,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<PostCallActivityEntity> observePostCallActivityById(final long activityId) {
    final String _sql = "SELECT * FROM post_call_activities WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, activityId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"post_call_activities"}, new Callable<PostCallActivityEntity>() {
      @Override
      @Nullable
      public PostCallActivityEntity call() throws Exception {
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
          final int _cursorIndexOfLeadCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadCallLogId");
          final int _cursorIndexOfCallNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "callNotes");
          final int _cursorIndexOfCallOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "callOutcome");
          final int _cursorIndexOfFollowUpAt = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpAt");
          final int _cursorIndexOfNextAction = CursorUtil.getColumnIndexOrThrow(_cursor, "nextAction");
          final int _cursorIndexOfAdditionalRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "additionalRemarks");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final PostCallActivityEntity _result;
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
            final long _tmpLeadCallLogId;
            _tmpLeadCallLogId = _cursor.getLong(_cursorIndexOfLeadCallLogId);
            final String _tmpCallNotes;
            if (_cursor.isNull(_cursorIndexOfCallNotes)) {
              _tmpCallNotes = null;
            } else {
              _tmpCallNotes = _cursor.getString(_cursorIndexOfCallNotes);
            }
            final String _tmpCallOutcome;
            if (_cursor.isNull(_cursorIndexOfCallOutcome)) {
              _tmpCallOutcome = null;
            } else {
              _tmpCallOutcome = _cursor.getString(_cursorIndexOfCallOutcome);
            }
            final long _tmpFollowUpAt;
            _tmpFollowUpAt = _cursor.getLong(_cursorIndexOfFollowUpAt);
            final String _tmpNextAction;
            if (_cursor.isNull(_cursorIndexOfNextAction)) {
              _tmpNextAction = null;
            } else {
              _tmpNextAction = _cursor.getString(_cursorIndexOfNextAction);
            }
            final String _tmpAdditionalRemarks;
            if (_cursor.isNull(_cursorIndexOfAdditionalRemarks)) {
              _tmpAdditionalRemarks = null;
            } else {
              _tmpAdditionalRemarks = _cursor.getString(_cursorIndexOfAdditionalRemarks);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new PostCallActivityEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpLeadCallLogId,_tmpCallNotes,_tmpCallOutcome,_tmpFollowUpAt,_tmpNextAction,_tmpAdditionalRemarks,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getPendingPostCallActivities(final int limit,
      final Continuation<? super List<PostCallActivityEntity>> $completion) {
    final String _sql = "SELECT * FROM post_call_activities WHERE syncState != 'SYNCED' ORDER BY updatedAt ASC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PostCallActivityEntity>>() {
      @Override
      @NonNull
      public List<PostCallActivityEntity> call() throws Exception {
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
          final int _cursorIndexOfLeadCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadCallLogId");
          final int _cursorIndexOfCallNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "callNotes");
          final int _cursorIndexOfCallOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "callOutcome");
          final int _cursorIndexOfFollowUpAt = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpAt");
          final int _cursorIndexOfNextAction = CursorUtil.getColumnIndexOrThrow(_cursor, "nextAction");
          final int _cursorIndexOfAdditionalRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "additionalRemarks");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<PostCallActivityEntity> _result = new ArrayList<PostCallActivityEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PostCallActivityEntity _item;
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
            final long _tmpLeadCallLogId;
            _tmpLeadCallLogId = _cursor.getLong(_cursorIndexOfLeadCallLogId);
            final String _tmpCallNotes;
            if (_cursor.isNull(_cursorIndexOfCallNotes)) {
              _tmpCallNotes = null;
            } else {
              _tmpCallNotes = _cursor.getString(_cursorIndexOfCallNotes);
            }
            final String _tmpCallOutcome;
            if (_cursor.isNull(_cursorIndexOfCallOutcome)) {
              _tmpCallOutcome = null;
            } else {
              _tmpCallOutcome = _cursor.getString(_cursorIndexOfCallOutcome);
            }
            final long _tmpFollowUpAt;
            _tmpFollowUpAt = _cursor.getLong(_cursorIndexOfFollowUpAt);
            final String _tmpNextAction;
            if (_cursor.isNull(_cursorIndexOfNextAction)) {
              _tmpNextAction = null;
            } else {
              _tmpNextAction = _cursor.getString(_cursorIndexOfNextAction);
            }
            final String _tmpAdditionalRemarks;
            if (_cursor.isNull(_cursorIndexOfAdditionalRemarks)) {
              _tmpAdditionalRemarks = null;
            } else {
              _tmpAdditionalRemarks = _cursor.getString(_cursorIndexOfAdditionalRemarks);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new PostCallActivityEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpLeadCallLogId,_tmpCallNotes,_tmpCallOutcome,_tmpFollowUpAt,_tmpNextAction,_tmpAdditionalRemarks,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<Integer> observePendingPostCallActivityCount() {
    final String _sql = "SELECT COUNT(*) FROM post_call_activities WHERE syncState != 'SYNCED'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"post_call_activities"}, new Callable<Integer>() {
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
  public Object getById(final long id,
      final Continuation<? super PostCallActivityEntity> $completion) {
    final String _sql = "SELECT * FROM post_call_activities WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PostCallActivityEntity>() {
      @Override
      @Nullable
      public PostCallActivityEntity call() throws Exception {
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
          final int _cursorIndexOfLeadCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadCallLogId");
          final int _cursorIndexOfCallNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "callNotes");
          final int _cursorIndexOfCallOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "callOutcome");
          final int _cursorIndexOfFollowUpAt = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpAt");
          final int _cursorIndexOfNextAction = CursorUtil.getColumnIndexOrThrow(_cursor, "nextAction");
          final int _cursorIndexOfAdditionalRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "additionalRemarks");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final PostCallActivityEntity _result;
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
            final long _tmpLeadCallLogId;
            _tmpLeadCallLogId = _cursor.getLong(_cursorIndexOfLeadCallLogId);
            final String _tmpCallNotes;
            if (_cursor.isNull(_cursorIndexOfCallNotes)) {
              _tmpCallNotes = null;
            } else {
              _tmpCallNotes = _cursor.getString(_cursorIndexOfCallNotes);
            }
            final String _tmpCallOutcome;
            if (_cursor.isNull(_cursorIndexOfCallOutcome)) {
              _tmpCallOutcome = null;
            } else {
              _tmpCallOutcome = _cursor.getString(_cursorIndexOfCallOutcome);
            }
            final long _tmpFollowUpAt;
            _tmpFollowUpAt = _cursor.getLong(_cursorIndexOfFollowUpAt);
            final String _tmpNextAction;
            if (_cursor.isNull(_cursorIndexOfNextAction)) {
              _tmpNextAction = null;
            } else {
              _tmpNextAction = _cursor.getString(_cursorIndexOfNextAction);
            }
            final String _tmpAdditionalRemarks;
            if (_cursor.isNull(_cursorIndexOfAdditionalRemarks)) {
              _tmpAdditionalRemarks = null;
            } else {
              _tmpAdditionalRemarks = _cursor.getString(_cursorIndexOfAdditionalRemarks);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new PostCallActivityEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpLeadCallLogId,_tmpCallNotes,_tmpCallOutcome,_tmpFollowUpAt,_tmpNextAction,_tmpAdditionalRemarks,_tmpCreatedAt,_tmpUpdatedAt);
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
      final Continuation<? super PostCallActivityEntity> $completion) {
    final String _sql = "SELECT * FROM post_call_activities WHERE serverId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (serverId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, serverId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PostCallActivityEntity>() {
      @Override
      @Nullable
      public PostCallActivityEntity call() throws Exception {
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
          final int _cursorIndexOfLeadCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadCallLogId");
          final int _cursorIndexOfCallNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "callNotes");
          final int _cursorIndexOfCallOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "callOutcome");
          final int _cursorIndexOfFollowUpAt = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpAt");
          final int _cursorIndexOfNextAction = CursorUtil.getColumnIndexOrThrow(_cursor, "nextAction");
          final int _cursorIndexOfAdditionalRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "additionalRemarks");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final PostCallActivityEntity _result;
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
            final long _tmpLeadCallLogId;
            _tmpLeadCallLogId = _cursor.getLong(_cursorIndexOfLeadCallLogId);
            final String _tmpCallNotes;
            if (_cursor.isNull(_cursorIndexOfCallNotes)) {
              _tmpCallNotes = null;
            } else {
              _tmpCallNotes = _cursor.getString(_cursorIndexOfCallNotes);
            }
            final String _tmpCallOutcome;
            if (_cursor.isNull(_cursorIndexOfCallOutcome)) {
              _tmpCallOutcome = null;
            } else {
              _tmpCallOutcome = _cursor.getString(_cursorIndexOfCallOutcome);
            }
            final long _tmpFollowUpAt;
            _tmpFollowUpAt = _cursor.getLong(_cursorIndexOfFollowUpAt);
            final String _tmpNextAction;
            if (_cursor.isNull(_cursorIndexOfNextAction)) {
              _tmpNextAction = null;
            } else {
              _tmpNextAction = _cursor.getString(_cursorIndexOfNextAction);
            }
            final String _tmpAdditionalRemarks;
            if (_cursor.isNull(_cursorIndexOfAdditionalRemarks)) {
              _tmpAdditionalRemarks = null;
            } else {
              _tmpAdditionalRemarks = _cursor.getString(_cursorIndexOfAdditionalRemarks);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new PostCallActivityEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpLeadCallLogId,_tmpCallNotes,_tmpCallOutcome,_tmpFollowUpAt,_tmpNextAction,_tmpAdditionalRemarks,_tmpCreatedAt,_tmpUpdatedAt);
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
      final Continuation<? super PostCallActivityEntity> $completion) {
    final String _sql = "SELECT * FROM post_call_activities WHERE externalId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (externalId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, externalId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PostCallActivityEntity>() {
      @Override
      @Nullable
      public PostCallActivityEntity call() throws Exception {
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
          final int _cursorIndexOfLeadCallLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "leadCallLogId");
          final int _cursorIndexOfCallNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "callNotes");
          final int _cursorIndexOfCallOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "callOutcome");
          final int _cursorIndexOfFollowUpAt = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpAt");
          final int _cursorIndexOfNextAction = CursorUtil.getColumnIndexOrThrow(_cursor, "nextAction");
          final int _cursorIndexOfAdditionalRemarks = CursorUtil.getColumnIndexOrThrow(_cursor, "additionalRemarks");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final PostCallActivityEntity _result;
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
            final long _tmpLeadCallLogId;
            _tmpLeadCallLogId = _cursor.getLong(_cursorIndexOfLeadCallLogId);
            final String _tmpCallNotes;
            if (_cursor.isNull(_cursorIndexOfCallNotes)) {
              _tmpCallNotes = null;
            } else {
              _tmpCallNotes = _cursor.getString(_cursorIndexOfCallNotes);
            }
            final String _tmpCallOutcome;
            if (_cursor.isNull(_cursorIndexOfCallOutcome)) {
              _tmpCallOutcome = null;
            } else {
              _tmpCallOutcome = _cursor.getString(_cursorIndexOfCallOutcome);
            }
            final long _tmpFollowUpAt;
            _tmpFollowUpAt = _cursor.getLong(_cursorIndexOfFollowUpAt);
            final String _tmpNextAction;
            if (_cursor.isNull(_cursorIndexOfNextAction)) {
              _tmpNextAction = null;
            } else {
              _tmpNextAction = _cursor.getString(_cursorIndexOfNextAction);
            }
            final String _tmpAdditionalRemarks;
            if (_cursor.isNull(_cursorIndexOfAdditionalRemarks)) {
              _tmpAdditionalRemarks = null;
            } else {
              _tmpAdditionalRemarks = _cursor.getString(_cursorIndexOfAdditionalRemarks);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new PostCallActivityEntity(_tmpId,_tmpExternalId,_tmpServerId,_tmpSyncState,_tmpLastSyncAttemptAt,_tmpLastSyncedAt,_tmpSyncError,_tmpDeletedAt,_tmpLeadId,_tmpLeadCallLogId,_tmpCallNotes,_tmpCallOutcome,_tmpFollowUpAt,_tmpNextAction,_tmpAdditionalRemarks,_tmpCreatedAt,_tmpUpdatedAt);
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
