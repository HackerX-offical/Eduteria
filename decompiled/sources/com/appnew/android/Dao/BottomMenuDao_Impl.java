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
import com.appnew.android.table.BottomMenuTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomMenuDao_Impl implements BottomMenuDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<BottomMenuTable> __deletionAdapterOfBottomMenuTable;
    private final EntityInsertionAdapter<BottomMenuTable> __insertionAdapterOfBottomMenuTable;
    private final SharedSQLiteStatement __preparedStmtOfDeleteBottomMenu;
    private final EntityDeletionOrUpdateAdapter<BottomMenuTable> __updateAdapterOfBottomMenuTable;

    public BottomMenuDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfBottomMenuTable = new EntityInsertionAdapter<BottomMenuTable>(__db) { // from class: com.appnew.android.Dao.BottomMenuDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `BottomMenuTable` (`auto_id`,`title`,`icon`,`type`,`param_value`,`user_id`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final BottomMenuTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getTitle() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTitle());
                }
                if (entity.getIcon() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getIcon());
                }
                if (entity.getType() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getType());
                }
                if (entity.getParam_value() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getParam_value());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getUser_id());
                }
            }
        };
        this.__deletionAdapterOfBottomMenuTable = new EntityDeletionOrUpdateAdapter<BottomMenuTable>(__db) { // from class: com.appnew.android.Dao.BottomMenuDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `BottomMenuTable` WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final BottomMenuTable entity) {
                statement.bindLong(1, entity.getAuto_id());
            }
        };
        this.__updateAdapterOfBottomMenuTable = new EntityDeletionOrUpdateAdapter<BottomMenuTable>(__db) { // from class: com.appnew.android.Dao.BottomMenuDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `BottomMenuTable` SET `auto_id` = ?,`title` = ?,`icon` = ?,`type` = ?,`param_value` = ?,`user_id` = ? WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final BottomMenuTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getTitle() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTitle());
                }
                if (entity.getIcon() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getIcon());
                }
                if (entity.getType() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getType());
                }
                if (entity.getParam_value() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getParam_value());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getUser_id());
                }
                statement.bindLong(7, entity.getAuto_id());
            }
        };
        this.__preparedStmtOfDeleteBottomMenu = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.BottomMenuDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM BottomMenuTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.BottomMenuDao
    public long addBottomMenu(final BottomMenuTable bottomMenuTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfBottomMenuTable.insertAndReturnId(bottomMenuTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.BottomMenuDao
    public int deleteBottomMenu(final BottomMenuTable bottomMenuTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfBottomMenuTable.handle(bottomMenuTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.BottomMenuDao
    public int updateBottomMenu(final BottomMenuTable bottomMenuTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfBottomMenuTable.handle(bottomMenuTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.BottomMenuDao
    public void deleteBottomMenu() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteBottomMenu.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeleteBottomMenu.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.BottomMenuDao
    public List<BottomMenuTable> getBottomMenu(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BottomMenuTable where user_id IN (?)", 1);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.BOTTOM_URL);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                BottomMenuTable bottomMenuTable = new BottomMenuTable();
                bottomMenuTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                bottomMenuTable.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                bottomMenuTable.setIcon(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                bottomMenuTable.setType(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                bottomMenuTable.setParam_value(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                bottomMenuTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                arrayList.add(bottomMenuTable);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.BottomMenuDao
    public List<BottomMenuTable> getAllBottomMenu() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BottomMenuTable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.BOTTOM_URL);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                BottomMenuTable bottomMenuTable = new BottomMenuTable();
                bottomMenuTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                bottomMenuTable.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                bottomMenuTable.setIcon(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                bottomMenuTable.setType(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                bottomMenuTable.setParam_value(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                bottomMenuTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                arrayList.add(bottomMenuTable);
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
