package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.table.YoutubePlayerTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class YoutubePlayerDao_Impl implements YoutubePlayerDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<YoutubePlayerTable> __insertionAdapterOfYoutubePlayerTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdateTime;

    public YoutubePlayerDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfYoutubePlayerTable = new EntityInsertionAdapter<YoutubePlayerTable>(__db) { // from class: com.appnew.android.Dao.YoutubePlayerDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `YoutubePlayerTable` (`autoid`,`youtubeid`,`youtubetime`,`userid`,`videoid`,`isaudio`,`videoname`,`valid_to`,`course_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final YoutubePlayerTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getYoutubeid() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getYoutubeid());
                }
                statement.bindLong(3, entity.getYoutubetime());
                if (entity.getUserid() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getUserid());
                }
                if (entity.getVideoid() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getVideoid());
                }
                if (entity.getIsaudio() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getIsaudio());
                }
                if (entity.getVideoname() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getVideoname());
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
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.YoutubePlayerDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM YoutubePlayerTable";
            }
        };
        this.__preparedStmtOfUpdateTime = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.YoutubePlayerDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE YoutubePlayerTable SET youtubetime = ?  WHERE videoid = ? And userid =? AND isaudio =?";
            }
        };
    }

    @Override // com.appnew.android.Dao.YoutubePlayerDao
    public long addVideo(final YoutubePlayerTable youtubePlayerTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfYoutubePlayerTable.insertAndReturnId(youtubePlayerTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.YoutubePlayerDao
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

    @Override // com.appnew.android.Dao.YoutubePlayerDao
    public int updateTime(final Long youtubetime, final String videoid, final String userid, final String isaudio) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateTime.acquire();
        if (youtubetime == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, youtubetime.longValue());
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
        if (isaudio == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, isaudio);
        }
        try {
            this.__db.beginTransaction();
            try {
                int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return iExecuteUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdateTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.YoutubePlayerDao
    public YoutubePlayerTable getdata(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT *  FROM YoutubePlayerTable where youtubeid = ? AND userid = ?", 2);
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str2);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        YoutubePlayerTable youtubePlayerTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "youtubeid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "youtubetime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoid");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isaudio");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoname");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            if (cursorQuery.moveToFirst()) {
                YoutubePlayerTable youtubePlayerTable2 = new YoutubePlayerTable();
                youtubePlayerTable2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                youtubePlayerTable2.setYoutubeid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                youtubePlayerTable2.setYoutubetime(cursorQuery.getLong(columnIndexOrThrow3));
                youtubePlayerTable2.setUserid(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                youtubePlayerTable2.setVideoid(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                youtubePlayerTable2.setIsaudio(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                youtubePlayerTable2.setVideoname(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                youtubePlayerTable2.setValid_to(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                if (!cursorQuery.isNull(columnIndexOrThrow9)) {
                    string = cursorQuery.getString(columnIndexOrThrow9);
                }
                youtubePlayerTable2.setCourse_id(string);
                youtubePlayerTable = youtubePlayerTable2;
            }
            return youtubePlayerTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.YoutubePlayerDao
    public long getyoutubedata(final String userid, final String videoid, final String isaudio) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT youtubetime FROM YoutubePlayerTable where videoid = ? AND userid = ? AND isaudio =?", 3);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        if (isaudio == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, isaudio);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getLong(0) : 0L;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.YoutubePlayerDao
    public boolean isUserExist(final String videoid, final String userid, final String isaudio) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM YoutubePlayerTable WHERE  videoid = ? AND userid =? AND isaudio =?)", 3);
        if (videoid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, videoid);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        if (isaudio == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, isaudio);
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
