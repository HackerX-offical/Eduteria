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
import com.appnew.android.TypeConverter.FilterConverter;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.MasteAllCatTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class GetMasterAllCatDao_Impl implements GetMasterAllCatDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MasteAllCatTable> __deletionAdapterOfMasteAllCatTable;
    private final EntityInsertionAdapter<MasteAllCatTable> __insertionAdapterOfMasteAllCatTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final EntityDeletionOrUpdateAdapter<MasteAllCatTable> __updateAdapterOfMasteAllCatTable;

    public GetMasterAllCatDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfMasteAllCatTable = new EntityInsertionAdapter<MasteAllCatTable>(__db) { // from class: com.appnew.android.Dao.GetMasterAllCatDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `MasteAllCatTable` (`auto_id`,`id`,`name`,`parent_id`,`master_type`,`user_id`,`app_hide`,`font_color`,`bg_color`,`image`,`filters`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final MasteAllCatTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                if (entity.getName() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getName());
                }
                if (entity.getParent_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getParent_id());
                }
                if (entity.getMaster_type() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getMaster_type());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getUser_id());
                }
                if (entity.getApp_hide() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getApp_hide());
                }
                if (entity.getFont_color() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getFont_color());
                }
                if (entity.getBg_color() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getBg_color());
                }
                if (entity.getImage() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getImage());
                }
                String strFromArrayList = FilterConverter.fromArrayList(entity.getFilters());
                if (strFromArrayList == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, strFromArrayList);
                }
            }
        };
        this.__deletionAdapterOfMasteAllCatTable = new EntityDeletionOrUpdateAdapter<MasteAllCatTable>(__db) { // from class: com.appnew.android.Dao.GetMasterAllCatDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `MasteAllCatTable` WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final MasteAllCatTable entity) {
                statement.bindLong(1, entity.getAuto_id());
            }
        };
        this.__updateAdapterOfMasteAllCatTable = new EntityDeletionOrUpdateAdapter<MasteAllCatTable>(__db) { // from class: com.appnew.android.Dao.GetMasterAllCatDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `MasteAllCatTable` SET `auto_id` = ?,`id` = ?,`name` = ?,`parent_id` = ?,`master_type` = ?,`user_id` = ?,`app_hide` = ?,`font_color` = ?,`bg_color` = ?,`image` = ?,`filters` = ? WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final MasteAllCatTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                if (entity.getName() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getName());
                }
                if (entity.getParent_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getParent_id());
                }
                if (entity.getMaster_type() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getMaster_type());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getUser_id());
                }
                if (entity.getApp_hide() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getApp_hide());
                }
                if (entity.getFont_color() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getFont_color());
                }
                if (entity.getBg_color() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getBg_color());
                }
                if (entity.getImage() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getImage());
                }
                String strFromArrayList = FilterConverter.fromArrayList(entity.getFilters());
                if (strFromArrayList == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, strFromArrayList);
                }
                statement.bindLong(12, entity.getAuto_id());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.GetMasterAllCatDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM MasteAllCatTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.GetMasterAllCatDao
    public long addUser(final MasteAllCatTable getMasterData_allcat) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfMasteAllCatTable.insertAndReturnId(getMasterData_allcat);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.GetMasterAllCatDao
    public int deleteUser(final MasteAllCatTable getMasterData_allcat) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfMasteAllCatTable.handle(getMasterData_allcat);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.GetMasterAllCatDao
    public int updateUser(final MasteAllCatTable getMasterData_allcat) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfMasteAllCatTable.handle(getMasterData_allcat);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.GetMasterAllCatDao
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

    @Override // com.appnew.android.Dao.GetMasterAllCatDao
    public List<MasteAllCatTable> getAllUser() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM MasteAllCatTable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PARENT_ID);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "master_type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "app_hide");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "font_color");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filters");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MasteAllCatTable masteAllCatTable = new MasteAllCatTable();
                masteAllCatTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                masteAllCatTable.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                masteAllCatTable.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                masteAllCatTable.setParent_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                masteAllCatTable.setMaster_type(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                masteAllCatTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                masteAllCatTable.setApp_hide(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                masteAllCatTable.setFont_color(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                masteAllCatTable.setBg_color(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                masteAllCatTable.setImage(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                masteAllCatTable.setFilters(FilterConverter.fromString(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11)));
                arrayList.add(masteAllCatTable);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.GetMasterAllCatDao
    public List<MasteAllCatTable> getmaster_allcat(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM MasteAllCatTable where user_id IN (?)", 1);
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
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PARENT_ID);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "master_type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "app_hide");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "font_color");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filters");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MasteAllCatTable masteAllCatTable = new MasteAllCatTable();
                masteAllCatTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                masteAllCatTable.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                masteAllCatTable.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                masteAllCatTable.setParent_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                masteAllCatTable.setMaster_type(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                masteAllCatTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                masteAllCatTable.setApp_hide(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                masteAllCatTable.setFont_color(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                masteAllCatTable.setBg_color(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                masteAllCatTable.setImage(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                masteAllCatTable.setFilters(FilterConverter.fromString(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11)));
                arrayList.add(masteAllCatTable);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.GetMasterAllCatDao
    public boolean isRecordExistsUserId(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM MasteAllCatTable WHERE user_id = ?)", 1);
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

    @Override // com.appnew.android.Dao.GetMasterAllCatDao
    public String getfilteddata(final String id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT filters FROM MasteAllCatTable where id IN (?)", 1);
        if (id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                string = cursorQuery.getString(0);
            }
            return string;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
