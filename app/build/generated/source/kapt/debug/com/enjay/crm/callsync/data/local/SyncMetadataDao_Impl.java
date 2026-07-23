package com.enjay.crm.callsync.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SyncMetadataDao_Impl implements SyncMetadataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SyncMetadataEntity> __insertionAdapterOfSyncMetadataEntity;

  public SyncMetadataDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSyncMetadataEntity = new EntityInsertionAdapter<SyncMetadataEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `sync_metadata` (`id`,`deviceId`,`lastSuccessfulCursor`,`lastSyncStartedAt`,`lastSyncCompletedAt`,`lastSyncStatus`,`lastSyncError`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SyncMetadataEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDeviceId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDeviceId());
        }
        if (entity.getLastSuccessfulCursor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getLastSuccessfulCursor());
        }
        if (entity.getLastSyncStartedAt() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getLastSyncStartedAt());
        }
        if (entity.getLastSyncCompletedAt() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getLastSyncCompletedAt());
        }
        if (entity.getLastSyncStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getLastSyncStatus());
        }
        if (entity.getLastSyncError() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getLastSyncError());
        }
      }
    };
  }

  @Override
  public Object upsert(final SyncMetadataEntity metadata,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSyncMetadataEntity.insert(metadata);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<SyncMetadataEntity> observeById(final int id) {
    final String _sql = "SELECT * FROM sync_metadata WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sync_metadata"}, new Callable<SyncMetadataEntity>() {
      @Override
      @Nullable
      public SyncMetadataEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfLastSuccessfulCursor = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSuccessfulCursor");
          final int _cursorIndexOfLastSyncStartedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncStartedAt");
          final int _cursorIndexOfLastSyncCompletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncCompletedAt");
          final int _cursorIndexOfLastSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncStatus");
          final int _cursorIndexOfLastSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncError");
          final SyncMetadataEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpLastSuccessfulCursor;
            if (_cursor.isNull(_cursorIndexOfLastSuccessfulCursor)) {
              _tmpLastSuccessfulCursor = null;
            } else {
              _tmpLastSuccessfulCursor = _cursor.getString(_cursorIndexOfLastSuccessfulCursor);
            }
            final Long _tmpLastSyncStartedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncStartedAt)) {
              _tmpLastSyncStartedAt = null;
            } else {
              _tmpLastSyncStartedAt = _cursor.getLong(_cursorIndexOfLastSyncStartedAt);
            }
            final Long _tmpLastSyncCompletedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncCompletedAt)) {
              _tmpLastSyncCompletedAt = null;
            } else {
              _tmpLastSyncCompletedAt = _cursor.getLong(_cursorIndexOfLastSyncCompletedAt);
            }
            final String _tmpLastSyncStatus;
            if (_cursor.isNull(_cursorIndexOfLastSyncStatus)) {
              _tmpLastSyncStatus = null;
            } else {
              _tmpLastSyncStatus = _cursor.getString(_cursorIndexOfLastSyncStatus);
            }
            final String _tmpLastSyncError;
            if (_cursor.isNull(_cursorIndexOfLastSyncError)) {
              _tmpLastSyncError = null;
            } else {
              _tmpLastSyncError = _cursor.getString(_cursorIndexOfLastSyncError);
            }
            _result = new SyncMetadataEntity(_tmpId,_tmpDeviceId,_tmpLastSuccessfulCursor,_tmpLastSyncStartedAt,_tmpLastSyncCompletedAt,_tmpLastSyncStatus,_tmpLastSyncError);
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
  public Object getById(final int id, final Continuation<? super SyncMetadataEntity> $completion) {
    final String _sql = "SELECT * FROM sync_metadata WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<SyncMetadataEntity>() {
      @Override
      @Nullable
      public SyncMetadataEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
          final int _cursorIndexOfLastSuccessfulCursor = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSuccessfulCursor");
          final int _cursorIndexOfLastSyncStartedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncStartedAt");
          final int _cursorIndexOfLastSyncCompletedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncCompletedAt");
          final int _cursorIndexOfLastSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncStatus");
          final int _cursorIndexOfLastSyncError = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncError");
          final SyncMetadataEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDeviceId;
            if (_cursor.isNull(_cursorIndexOfDeviceId)) {
              _tmpDeviceId = null;
            } else {
              _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
            }
            final String _tmpLastSuccessfulCursor;
            if (_cursor.isNull(_cursorIndexOfLastSuccessfulCursor)) {
              _tmpLastSuccessfulCursor = null;
            } else {
              _tmpLastSuccessfulCursor = _cursor.getString(_cursorIndexOfLastSuccessfulCursor);
            }
            final Long _tmpLastSyncStartedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncStartedAt)) {
              _tmpLastSyncStartedAt = null;
            } else {
              _tmpLastSyncStartedAt = _cursor.getLong(_cursorIndexOfLastSyncStartedAt);
            }
            final Long _tmpLastSyncCompletedAt;
            if (_cursor.isNull(_cursorIndexOfLastSyncCompletedAt)) {
              _tmpLastSyncCompletedAt = null;
            } else {
              _tmpLastSyncCompletedAt = _cursor.getLong(_cursorIndexOfLastSyncCompletedAt);
            }
            final String _tmpLastSyncStatus;
            if (_cursor.isNull(_cursorIndexOfLastSyncStatus)) {
              _tmpLastSyncStatus = null;
            } else {
              _tmpLastSyncStatus = _cursor.getString(_cursorIndexOfLastSyncStatus);
            }
            final String _tmpLastSyncError;
            if (_cursor.isNull(_cursorIndexOfLastSyncError)) {
              _tmpLastSyncError = null;
            } else {
              _tmpLastSyncError = _cursor.getString(_cursorIndexOfLastSyncError);
            }
            _result = new SyncMetadataEntity(_tmpId,_tmpDeviceId,_tmpLastSuccessfulCursor,_tmpLastSyncStartedAt,_tmpLastSyncCompletedAt,_tmpLastSyncStatus,_tmpLastSyncError);
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
