package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.table.PigibagTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class PigiBag_Impl implements PigiBag {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PigibagTable> __insertionAdapterOfPigibagTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfDeletepigibagdata;
    private final SharedSQLiteStatement __preparedStmtOfUpdaterecord;

    public PigiBag_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPigibagTable = new EntityInsertionAdapter<PigibagTable>(__db) { // from class: com.appnew.android.Dao.PigiBag_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `PigibagTable` (`auto_id`,`cdtimestamp`,`user_id`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PigibagTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getCdtimestamp() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getCdtimestamp());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
            }
        };
        this.__preparedStmtOfUpdaterecord = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.PigiBag_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE PigibagTable SET cdtimestamp =?  where  user_id=?";
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.PigiBag_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM PigibagTable";
            }
        };
        this.__preparedStmtOfDeletepigibagdata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.PigiBag_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete  FROM PigibagTable  WHERE user_id =?";
            }
        };
    }

    @Override // com.appnew.android.Dao.PigiBag
    public long addApiedata(final PigibagTable pigibag) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfPigibagTable.insertAndReturnId(pigibag);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.PigiBag
    public int updaterecord(final String userid, final String cdtimestamp) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdaterecord.acquire();
        if (cdtimestamp == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, cdtimestamp);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, userid);
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

    @Override // com.appnew.android.Dao.PigiBag
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

    @Override // com.appnew.android.Dao.PigiBag
    public int deletepigibagdata(final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletepigibagdata.acquire();
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, userid);
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
            this.__preparedStmtOfDeletepigibagdata.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.PigiBag
    public boolean isRecordExistsUserId(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM PigibagTable WHERE user_id = ?)", 1);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
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

    @Override // com.appnew.android.Dao.PigiBag
    public PigibagTable getpigidetail(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PigibagTable  WHERE  user_id =?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        PigibagTable pigibagTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cdtimestamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            if (cursorQuery.moveToFirst()) {
                PigibagTable pigibagTable2 = new PigibagTable();
                pigibagTable2.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                pigibagTable2.setCdtimestamp(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                    string = cursorQuery.getString(columnIndexOrThrow3);
                }
                pigibagTable2.setUser_id(string);
                pigibagTable = pigibagTable2;
            }
            return pigibagTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.PigiBag
    public PigibagTable getuserid() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PigibagTable", 0);
        this.__db.assertNotSuspendingTransaction();
        PigibagTable pigibagTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cdtimestamp");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            if (cursorQuery.moveToFirst()) {
                PigibagTable pigibagTable2 = new PigibagTable();
                pigibagTable2.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                pigibagTable2.setCdtimestamp(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                    string = cursorQuery.getString(columnIndexOrThrow3);
                }
                pigibagTable2.setUser_id(string);
                pigibagTable = pigibagTable2;
            }
            return pigibagTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
