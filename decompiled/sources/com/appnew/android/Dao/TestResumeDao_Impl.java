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
import com.appnew.android.table.TestResumeTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class TestResumeDao_Impl implements TestResumeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<TestResumeTable> __deletionAdapterOfTestResumeTable;
    private final EntityInsertionAdapter<TestResumeTable> __insertionAdapterOfTestResumeTable;
    private final SharedSQLiteStatement __preparedStmtOfDelete_test_data;
    private final EntityDeletionOrUpdateAdapter<TestResumeTable> __updateAdapterOfTestResumeTable;

    public TestResumeDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfTestResumeTable = new EntityInsertionAdapter<TestResumeTable>(__db) { // from class: com.appnew.android.Dao.TestResumeDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `TestResumeTable` (`id`,`courseName`,`user_id`,`remaining_time`,`lastPosition`,`courseDescription`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final TestResumeTable entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getCourseName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getCourseName());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
                if (entity.getRemaining_time() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getRemaining_time());
                }
                statement.bindLong(5, entity.getLastPosition());
                if (entity.getCourseDescription() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getCourseDescription());
                }
            }
        };
        this.__deletionAdapterOfTestResumeTable = new EntityDeletionOrUpdateAdapter<TestResumeTable>(__db) { // from class: com.appnew.android.Dao.TestResumeDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `TestResumeTable` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final TestResumeTable entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfTestResumeTable = new EntityDeletionOrUpdateAdapter<TestResumeTable>(__db) { // from class: com.appnew.android.Dao.TestResumeDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `TestResumeTable` SET `id` = ?,`courseName` = ?,`user_id` = ?,`remaining_time` = ?,`lastPosition` = ?,`courseDescription` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final TestResumeTable entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getCourseName() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getCourseName());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
                if (entity.getRemaining_time() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getRemaining_time());
                }
                statement.bindLong(5, entity.getLastPosition());
                if (entity.getCourseDescription() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getCourseDescription());
                }
                statement.bindLong(7, entity.getId());
            }
        };
        this.__preparedStmtOfDelete_test_data = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.TestResumeDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE  FROM TestResumeTable WHERE courseName = ?";
            }
        };
    }

    @Override // com.appnew.android.Dao.TestResumeDao
    public void insert(final TestResumeTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTestResumeTable.insert(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TestResumeDao
    public void delete(final TestResumeTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfTestResumeTable.handle(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TestResumeDao
    public void update(final TestResumeTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfTestResumeTable.handle(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TestResumeDao
    public void delete_test_data(final String test_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_test_data.acquire();
        if (test_id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, test_id);
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
            this.__preparedStmtOfDelete_test_data.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.TestResumeDao
    public TestResumeTable test_data(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM TestResumeTable WHERE  courseName = ? AND user_id=?", 2);
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
        TestResumeTable testResumeTable = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastPosition");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseDescription");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                TestResumeTable testResumeTable2 = new TestResumeTable(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), string, cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                testResumeTable2.setId(cursorQuery.getInt(columnIndexOrThrow));
                testResumeTable = testResumeTable2;
            }
            return testResumeTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.TestResumeDao
    public TestResumeTable test_data(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM TestResumeTable WHERE  user_id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        TestResumeTable testResumeTable = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.remaining_time);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastPosition");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseDescription");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                TestResumeTable testResumeTable2 = new TestResumeTable(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), string, cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                testResumeTable2.setId(cursorQuery.getInt(columnIndexOrThrow));
                testResumeTable = testResumeTable2;
            }
            return testResumeTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.TestResumeDao
    public boolean testData(final String test_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM TestResumeTable WHERE  courseName = ?)", 1);
        if (test_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, test_id);
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
