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
import com.appnew.android.table.CenterIdTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class CenterIdDao_Impl implements CenterIdDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<CenterIdTable> __deletionAdapterOfCenterIdTable;
    private final EntityInsertionAdapter<CenterIdTable> __insertionAdapterOfCenterIdTable;
    private final SharedSQLiteStatement __preparedStmtOfDelete_test_data;
    private final SharedSQLiteStatement __preparedStmtOfUpdate;
    private final EntityDeletionOrUpdateAdapter<CenterIdTable> __updateAdapterOfCenterIdTable;

    public CenterIdDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfCenterIdTable = new EntityInsertionAdapter<CenterIdTable>(__db) { // from class: com.appnew.android.Dao.CenterIdDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `CenterIdTable` (`id`,`center_id`,`user_id`,`center_name`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final CenterIdTable entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getCenter_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getCenter_id());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
                if (entity.getCenter_name() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getCenter_name());
                }
            }
        };
        this.__deletionAdapterOfCenterIdTable = new EntityDeletionOrUpdateAdapter<CenterIdTable>(__db) { // from class: com.appnew.android.Dao.CenterIdDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `CenterIdTable` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final CenterIdTable entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfCenterIdTable = new EntityDeletionOrUpdateAdapter<CenterIdTable>(__db) { // from class: com.appnew.android.Dao.CenterIdDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `CenterIdTable` SET `id` = ?,`center_id` = ?,`user_id` = ?,`center_name` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final CenterIdTable entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getCenter_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getCenter_id());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
                if (entity.getCenter_name() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getCenter_name());
                }
                statement.bindLong(5, entity.getId());
            }
        };
        this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CenterIdDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE CenterIdTable SET center_id = ?, center_name = ? WHERE user_id = ?";
            }
        };
        this.__preparedStmtOfDelete_test_data = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CenterIdDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE  FROM CenterIdTable WHERE center_id = ?";
            }
        };
    }

    @Override // com.appnew.android.Dao.CenterIdDao
    public void insert(final CenterIdTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCenterIdTable.insert(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CenterIdDao
    public void delete(final CenterIdTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfCenterIdTable.handle(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CenterIdDao
    public void update(final CenterIdTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfCenterIdTable.handle(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CenterIdDao
    public void update(final String centerID, final String centerName, final String userID) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate.acquire();
        if (centerID == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, centerID);
        }
        if (centerName == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, centerName);
        }
        if (userID == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userID);
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
            this.__preparedStmtOfUpdate.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.CenterIdDao
    public void delete_test_data(final String centerId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_test_data.acquire();
        if (centerId == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, centerId);
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

    @Override // com.appnew.android.Dao.CenterIdDao
    public CenterIdTable center_data(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CenterIdTable WHERE  center_id=? AND user_id=?", 2);
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
        CenterIdTable centerIdTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "center_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "center_name");
            if (cursorQuery.moveToFirst()) {
                String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                    string = cursorQuery.getString(columnIndexOrThrow4);
                }
                CenterIdTable centerIdTable2 = new CenterIdTable(string2, string3, string);
                centerIdTable2.setId(cursorQuery.getInt(columnIndexOrThrow));
                centerIdTable = centerIdTable2;
            }
            return centerIdTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.CenterIdDao
    public List<CenterIdTable> getCenterIdList() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CenterIdTable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "center_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "center_name");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                CenterIdTable centerIdTable = new CenterIdTable(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                centerIdTable.setId(cursorQuery.getInt(columnIndexOrThrow));
                arrayList.add(centerIdTable);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
