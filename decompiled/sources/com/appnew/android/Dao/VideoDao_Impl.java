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
import com.appnew.android.table.VideoTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class VideoDao_Impl implements VideoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<VideoTable> __deletionAdapterOfVideoTable;
    private final EntityInsertionAdapter<VideoTable> __insertionAdapterOfVideoTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_video_currentpos;
    private final EntityDeletionOrUpdateAdapter<VideoTable> __updateAdapterOfVideoTable;

    public VideoDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfVideoTable = new EntityInsertionAdapter<VideoTable>(__db) { // from class: com.appnew.android.Dao.VideoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `VideoTable` (`autoid`,`video_id`,`video_name`,`user_id`,`video_currentpos`,`jw_url`,`course_id`,`valid_to`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final VideoTable entity) {
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
                if (entity.getVideo_currentpos() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getVideo_currentpos().longValue());
                }
                if (entity.getJw_url() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getJw_url());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getCourse_id());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getValid_to());
                }
            }
        };
        this.__deletionAdapterOfVideoTable = new EntityDeletionOrUpdateAdapter<VideoTable>(__db) { // from class: com.appnew.android.Dao.VideoDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `VideoTable` WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final VideoTable entity) {
                statement.bindLong(1, entity.getAutoid());
            }
        };
        this.__updateAdapterOfVideoTable = new EntityDeletionOrUpdateAdapter<VideoTable>(__db) { // from class: com.appnew.android.Dao.VideoDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `VideoTable` SET `autoid` = ?,`video_id` = ?,`video_name` = ?,`user_id` = ?,`video_currentpos` = ?,`jw_url` = ?,`course_id` = ?,`valid_to` = ? WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final VideoTable entity) {
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
                if (entity.getVideo_currentpos() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getVideo_currentpos().longValue());
                }
                if (entity.getJw_url() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getJw_url());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getCourse_id());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getValid_to());
                }
                statement.bindLong(9, entity.getAutoid());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM VideoTable";
            }
        };
        this.__preparedStmtOfUpdate_video_currentpos = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.VideoDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE videotable SET   video_currentpos =?   WHERE video_id = ?  AND user_id =?";
            }
        };
    }

    @Override // com.appnew.android.Dao.VideoDao
    public long addUser(final VideoTable videoTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfVideoTable.insertAndReturnId(videoTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.VideoDao
    public int deleteUser(final VideoTable videoTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfVideoTable.handle(videoTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.VideoDao
    public int updateUser(final VideoTable audioTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfVideoTable.handle(audioTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.VideoDao
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

    @Override // com.appnew.android.Dao.VideoDao
    public void update_video_currentpos(final String videoid, final String userid, final Long getCurrentPosition) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_video_currentpos.acquire();
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
            this.__preparedStmtOfUpdate_video_currentpos.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDao
    public void update_videotime(final String videoid, final String userid, final Long getCurrentPosition) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_video_currentpos.acquire();
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
            this.__preparedStmtOfUpdate_video_currentpos.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.VideoDao
    public VideoTable getuser(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM VideoTable  WHERE video_id = ? AND user_id =?", 2);
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
        VideoTable videoTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.VIDEO_ID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video_currentpos");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jw_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            if (cursorQuery.moveToFirst()) {
                VideoTable videoTable2 = new VideoTable();
                videoTable2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                videoTable2.setVideo_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                videoTable2.setVideo_name(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                videoTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                videoTable2.setVideo_currentpos(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                videoTable2.setJw_url(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                videoTable2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                if (!cursorQuery.isNull(columnIndexOrThrow8)) {
                    string = cursorQuery.getString(columnIndexOrThrow8);
                }
                videoTable2.setValid_to(string);
                videoTable = videoTable2;
            }
            return videoTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.VideoDao
    public boolean isvideo_exit(final String video_id, final String user_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM VideoTable WHERE video_id = ?   AND user_id = ?)", 2);
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
