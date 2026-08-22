package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.table.HomeApiStatusTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class HomeApiStatusDao_Impl implements HomeApiStatusDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<HomeApiStatusTable> __insertionAdapterOfHomeApiStatusTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdaterecord;

    public HomeApiStatusDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfHomeApiStatusTable = new EntityInsertionAdapter<HomeApiStatusTable>(__db) { // from class: com.appnew.android.Dao.HomeApiStatusDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `HomeApiStatusTable` (`autoid`,`userid`,`mainid`,`status`,`page`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final HomeApiStatusTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getUser_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUser_id());
                }
                if (entity.getMain_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMain_id());
                }
                if (entity.getStatus() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getStatus());
                }
                if (entity.getPage() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getPage());
                }
            }
        };
        this.__preparedStmtOfUpdaterecord = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.HomeApiStatusDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE HomeApiStatusTable SET status=? , page=? WHERE mainid = ? AND  userid = ?";
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.HomeApiStatusDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM HomeApiStatusTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.HomeApiStatusDao
    public long addCoursedata(final HomeApiStatusTable homeApiStatusTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfHomeApiStatusTable.insertAndReturnId(homeApiStatusTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.HomeApiStatusDao
    public int updaterecord(final String page, final String status, final String mainid, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdaterecord.acquire();
        if (status == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, status);
        }
        if (page == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, page);
        }
        if (mainid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, mainid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, userid);
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
            this.__preparedStmtOfUpdaterecord.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.HomeApiStatusDao
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

    @Override // com.appnew.android.Dao.HomeApiStatusDao
    public boolean isRecordExistsUserId(final String userid, final String mainid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM HomeApiStatusTable WHERE mainid = ? AND userid = ?)", 2);
        if (mainid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, mainid);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
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

    @Override // com.appnew.android.Dao.HomeApiStatusDao
    public HomeApiStatusTable getcoursedetail(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM HomeApiStatusTable  WHERE mainid = ? AND userid =?", 2);
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
        HomeApiStatusTable homeApiStatusTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mainid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "page");
            if (cursorQuery.moveToFirst()) {
                HomeApiStatusTable homeApiStatusTable2 = new HomeApiStatusTable();
                homeApiStatusTable2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                homeApiStatusTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                homeApiStatusTable2.setMain_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                homeApiStatusTable2.setStatus(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    string = cursorQuery.getString(columnIndexOrThrow5);
                }
                homeApiStatusTable2.setPage(string);
                homeApiStatusTable = homeApiStatusTable2;
            }
            return homeApiStatusTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
