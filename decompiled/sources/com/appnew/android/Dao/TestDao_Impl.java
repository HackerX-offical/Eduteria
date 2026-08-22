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
import com.appnew.android.table.TestTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class TestDao_Impl implements TestDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<TestTable> __deletionAdapterOfTestTable;
    private final EntityInsertionAdapter<TestTable> __insertionAdapterOfTestTable;
    private final SharedSQLiteStatement __preparedStmtOfDelete_test_data;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final EntityDeletionOrUpdateAdapter<TestTable> __updateAdapterOfTestTable;

    public TestDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfTestTable = new EntityInsertionAdapter<TestTable>(__db) { // from class: com.appnew.android.Dao.TestDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `TestTable` (`autoid`,`test_id`,`user_id`,`course_id`,`status`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final TestTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getTest_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTest_id());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getCourse_id());
                }
                if (entity.getStatus() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getStatus());
                }
            }
        };
        this.__deletionAdapterOfTestTable = new EntityDeletionOrUpdateAdapter<TestTable>(__db) { // from class: com.appnew.android.Dao.TestDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `TestTable` WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final TestTable entity) {
                statement.bindLong(1, entity.getAutoid());
            }
        };
        this.__updateAdapterOfTestTable = new EntityDeletionOrUpdateAdapter<TestTable>(__db) { // from class: com.appnew.android.Dao.TestDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `TestTable` SET `autoid` = ?,`test_id` = ?,`user_id` = ?,`course_id` = ?,`status` = ? WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final TestTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getTest_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTest_id());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getCourse_id());
                }
                if (entity.getStatus() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getStatus());
                }
                statement.bindLong(6, entity.getAutoid());
            }
        };
        this.__preparedStmtOfDelete_test_data = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.TestDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE  FROM TestTable WHERE user_id = ?   AND test_id = ?";
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.TestDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM MasteAllCatTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.TestDao
    public long addUser(final TestTable audioTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfTestTable.insertAndReturnId(audioTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TestDao
    public int deleteUser(final TestTable audioTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfTestTable.handle(audioTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TestDao
    public int updateUser(final TestTable audioTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfTestTable.handle(audioTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TestDao
    public int delete_test_data(final String userid, final String test_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_test_data.acquire();
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, userid);
        }
        if (test_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, test_id);
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
            this.__preparedStmtOfDelete_test_data.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.TestDao
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

    @Override // com.appnew.android.Dao.TestDao
    public TestTable test_data(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM TestTable WHERE  test_id = ? AND user_id=?", 2);
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
        TestTable testTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "test_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            if (cursorQuery.moveToFirst()) {
                TestTable testTable2 = new TestTable();
                testTable2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                testTable2.setTest_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                testTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                testTable2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    string = cursorQuery.getString(columnIndexOrThrow5);
                }
                testTable2.setStatus(string);
                testTable = testTable2;
            }
            return testTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.TestDao
    public boolean is_test_exit(final String test_id, final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM TestTable WHERE test_id = ? AND user_id=?)", 2);
        if (test_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, test_id);
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
