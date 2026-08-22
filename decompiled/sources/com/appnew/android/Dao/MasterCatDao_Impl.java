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
import com.appnew.android.table.MasterCat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class MasterCatDao_Impl implements MasterCatDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MasterCat> __deletionAdapterOfMasterCat;
    private final EntityInsertionAdapter<MasterCat> __insertionAdapterOfMasterCat;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final EntityDeletionOrUpdateAdapter<MasterCat> __updateAdapterOfMasterCat;

    public MasterCatDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfMasterCat = new EntityInsertionAdapter<MasterCat>(__db) { // from class: com.appnew.android.Dao.MasterCatDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `MasterCat` (`auto_id`,`id`,`cat`,`user_id`,`app_hide`,`isSelected`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, MasterCat masterCat) {
                supportSQLiteStatement.bindLong(1, masterCat.getAuto_id());
                if (masterCat.getId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, masterCat.getId());
                }
                if (masterCat.getCat() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, masterCat.getCat());
                }
                if (masterCat.getUser_id() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, masterCat.getUser_id());
                }
                if (masterCat.getApp_hide() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, masterCat.getApp_hide());
                }
                supportSQLiteStatement.bindLong(6, masterCat.isSelected() ? 1L : 0L);
            }
        };
        this.__deletionAdapterOfMasterCat = new EntityDeletionOrUpdateAdapter<MasterCat>(__db) { // from class: com.appnew.android.Dao.MasterCatDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `MasterCat` WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final MasterCat entity) {
                statement.bindLong(1, entity.getAuto_id());
            }
        };
        this.__updateAdapterOfMasterCat = new EntityDeletionOrUpdateAdapter<MasterCat>(__db) { // from class: com.appnew.android.Dao.MasterCatDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `MasterCat` SET `auto_id` = ?,`id` = ?,`cat` = ?,`user_id` = ?,`app_hide` = ?,`isSelected` = ? WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, MasterCat masterCat) {
                supportSQLiteStatement.bindLong(1, masterCat.getAuto_id());
                if (masterCat.getId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, masterCat.getId());
                }
                if (masterCat.getCat() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, masterCat.getCat());
                }
                if (masterCat.getUser_id() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, masterCat.getUser_id());
                }
                if (masterCat.getApp_hide() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, masterCat.getApp_hide());
                }
                supportSQLiteStatement.bindLong(6, masterCat.isSelected() ? 1L : 0L);
                supportSQLiteStatement.bindLong(7, masterCat.getAuto_id());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.MasterCatDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM MasterCat";
            }
        };
    }

    @Override // com.appnew.android.Dao.MasterCatDao
    public long addUser(final MasterCat courseTypeMasterTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfMasterCat.insertAndReturnId(courseTypeMasterTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.MasterCatDao
    public int deleteUser(final MasterCat courseTypeMasterTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfMasterCat.handle(courseTypeMasterTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.MasterCatDao
    public int updateUser(final MasterCat courseTypeMasterTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfMasterCat.handle(courseTypeMasterTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.MasterCatDao
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

    @Override // com.appnew.android.Dao.MasterCatDao
    public List<MasterCat> getmastercat(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM MasterCat where user_id IN (?)", 1);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "app_hide");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelected");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MasterCat masterCat = new MasterCat();
                masterCat.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                masterCat.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                masterCat.setCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                masterCat.setUser_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                masterCat.setApp_hide(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                masterCat.setSelected(cursorQuery.getInt(columnIndexOrThrow6) != 0);
                arrayList.add(masterCat);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.MasterCatDao
    public List<MasterCat> getAllUser() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM MasterCat", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "app_hide");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelected");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MasterCat masterCat = new MasterCat();
                masterCat.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                masterCat.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                masterCat.setCat(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                masterCat.setUser_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                masterCat.setApp_hide(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                masterCat.setSelected(cursorQuery.getInt(columnIndexOrThrow6) != 0);
                arrayList.add(masterCat);
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
