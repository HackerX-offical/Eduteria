package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.AudioTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class AudioDao_Impl implements AudioDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AudioTable> __deletionAdapterOfAudioTable;
    private final EntityInsertionAdapter<AudioTable> __insertionAdapterOfAudioTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_audio_currentpos;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_videotime;
    private final EntityDeletionOrUpdateAdapter<AudioTable> __updateAdapterOfAudioTable;

    public AudioDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAudioTable = new EntityInsertionAdapter<AudioTable>(__db) { // from class: com.appnew.android.Dao.AudioDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `AudioTable` (`autoid`,`video_id`,`video_name`,`user_id`,`audio_url`,`audio_currentpos`,`jw_url`,`valid_to`,`course_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final AudioTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getVideo_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getVideo_id());
                }
                if (entity.getVideo_name() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getVideo_name());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getUser_id());
                }
                if (entity.getAudio_url() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getAudio_url());
                }
                if (entity.getAudio_currentpos() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, entity.getAudio_currentpos().longValue());
                }
                if (entity.getJw_url() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getJw_url());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getValid_to());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCourse_id());
                }
            }
        };
        this.__deletionAdapterOfAudioTable = new EntityDeletionOrUpdateAdapter<AudioTable>(__db) { // from class: com.appnew.android.Dao.AudioDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `AudioTable` WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final AudioTable entity) {
                statement.bindLong(1, entity.getAutoid());
            }
        };
        this.__updateAdapterOfAudioTable = new EntityDeletionOrUpdateAdapter<AudioTable>(__db) { // from class: com.appnew.android.Dao.AudioDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `AudioTable` SET `autoid` = ?,`video_id` = ?,`video_name` = ?,`user_id` = ?,`audio_url` = ?,`audio_currentpos` = ?,`jw_url` = ?,`valid_to` = ?,`course_id` = ? WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final AudioTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getVideo_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getVideo_id());
                }
                if (entity.getVideo_name() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getVideo_name());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getUser_id());
                }
                if (entity.getAudio_url() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getAudio_url());
                }
                if (entity.getAudio_currentpos() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, entity.getAudio_currentpos().longValue());
                }
                if (entity.getJw_url() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getJw_url());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getValid_to());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCourse_id());
                }
                statement.bindLong(10, entity.getAutoid());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.AudioDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM AudioTable";
            }
        };
        this.__preparedStmtOfUpdate_audio_currentpos = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.AudioDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE audiotable SET   audio_currentpos =?   WHERE video_id = ?  AND user_id =?";
            }
        };
        this.__preparedStmtOfUpdate_videotime = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.AudioDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE audiotable SET audio_url =? ,  audio_currentpos =?   WHERE video_id = ?  AND user_id =?";
            }
        };
    }

    @Override // com.appnew.android.Dao.AudioDao
    public long addUser(final AudioTable audioTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfAudioTable.insertAndReturnId(audioTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.AudioDao
    public int deleteUser(final AudioTable audioTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfAudioTable.handle(audioTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.AudioDao
    public int updateUser(final AudioTable audioTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfAudioTable.handle(audioTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.AudioDao
    public void deletedata() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletedata.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeletedata.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.AudioDao
    public void update_audio_currentpos(final String videoid, final String userid, final Long getCurrentPosition) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_audio_currentpos.acquire();
        if (getCurrentPosition == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, getCurrentPosition.longValue());
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_audio_currentpos.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.AudioDao
    public void update_videotime(final String videoid, final String userid, final Long getCurrentPosition, final String audio_url) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_videotime.acquire();
        if (audio_url == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, audio_url);
        }
        if (getCurrentPosition == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindLong(2, getCurrentPosition.longValue());
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_videotime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.AudioDao
    public void update_videotime(final String videoid, final String userid, final Long getCurrentPosition) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_audio_currentpos.acquire();
        if (getCurrentPosition == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, getCurrentPosition.longValue());
        }
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_audio_currentpos.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.AudioDao
    public AudioTable getuser(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM AudioTable  WHERE video_id = ? AND user_id =?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        AudioTable audioTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audio_url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audio_currentpos");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            if (cursorQuery.moveToFirst()) {
                AudioTable audioTable2 = new AudioTable();
                audioTable2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                audioTable2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioTable2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioTable2.setAudio_url(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioTable2.setAudio_currentpos(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)));
                audioTable2.setJw_url(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioTable2.setValid_to(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                if (!cursorQuery.isNull(columnIndexOrThrow9)) {
                    string = cursorQuery.getString(columnIndexOrThrow9);
                }
                audioTable2.setCourse_id(string);
                audioTable = audioTable2;
            }
            return audioTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.AudioDao
    public boolean isvideo_exit(final String video_id, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM AudioTable WHERE video_id = ?   AND user_id = ?)", 2);
        if (video_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, video_id);
        }
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, user_id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
