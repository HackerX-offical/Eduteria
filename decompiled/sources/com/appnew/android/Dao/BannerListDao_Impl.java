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
import com.appnew.android.TypeConverter.SeminarExtraConverter;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.BannerListTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class BannerListDao_Impl implements BannerListDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<BannerListTable> __deletionAdapterOfBannerListTable;
    private final EntityInsertionAdapter<BannerListTable> __insertionAdapterOfBannerListTable;
    private final SharedSQLiteStatement __preparedStmtOfDeleteBanners;
    private final EntityDeletionOrUpdateAdapter<BannerListTable> __updateAdapterOfBannerListTable;

    public BannerListDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfBannerListTable = new EntityInsertionAdapter<BannerListTable>(__db) { // from class: com.appnew.android.Dao.BannerListDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `BannerListTable` (`auto_id`,`id`,`extra`,`banner_title`,`image_type`,`banner_url`,`user_id`,`master_cat`,`course_type`,`link`,`course_id`,`parent_id`,`banner_type`,`banner_location`,`link_type`,`center_id`,`is_combo`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final BannerListTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                String strFromExtraObject = SeminarExtraConverter.fromExtraObject(entity.getExtra());
                if (strFromExtraObject == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, strFromExtraObject);
                }
                if (entity.getBanner_title() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getBanner_title());
                }
                if (entity.getImage_type() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getImage_type());
                }
                if (entity.getBanner_url() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getBanner_url());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getUser_id());
                }
                if (entity.getMaster_cat() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getMaster_cat());
                }
                if (entity.getCourse_type() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCourse_type());
                }
                if (entity.getLink() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getLink());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getCourse_id());
                }
                if (entity.getParent_id() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getParent_id());
                }
                if (entity.getBanner_type() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getBanner_type());
                }
                if (entity.getBanner_location() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getBanner_location());
                }
                if (entity.getLink_type() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getLink_type());
                }
                if (entity.getCenter_id() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getCenter_id());
                }
                statement.bindLong(17, entity.getIs_combo());
            }
        };
        this.__deletionAdapterOfBannerListTable = new EntityDeletionOrUpdateAdapter<BannerListTable>(__db) { // from class: com.appnew.android.Dao.BannerListDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `BannerListTable` WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final BannerListTable entity) {
                statement.bindLong(1, entity.getAuto_id());
            }
        };
        this.__updateAdapterOfBannerListTable = new EntityDeletionOrUpdateAdapter<BannerListTable>(__db) { // from class: com.appnew.android.Dao.BannerListDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `BannerListTable` SET `auto_id` = ?,`id` = ?,`extra` = ?,`banner_title` = ?,`image_type` = ?,`banner_url` = ?,`user_id` = ?,`master_cat` = ?,`course_type` = ?,`link` = ?,`course_id` = ?,`parent_id` = ?,`banner_type` = ?,`banner_location` = ?,`link_type` = ?,`center_id` = ?,`is_combo` = ? WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final BannerListTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                String strFromExtraObject = SeminarExtraConverter.fromExtraObject(entity.getExtra());
                if (strFromExtraObject == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, strFromExtraObject);
                }
                if (entity.getBanner_title() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getBanner_title());
                }
                if (entity.getImage_type() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getImage_type());
                }
                if (entity.getBanner_url() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getBanner_url());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getUser_id());
                }
                if (entity.getMaster_cat() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getMaster_cat());
                }
                if (entity.getCourse_type() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCourse_type());
                }
                if (entity.getLink() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getLink());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getCourse_id());
                }
                if (entity.getParent_id() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getParent_id());
                }
                if (entity.getBanner_type() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getBanner_type());
                }
                if (entity.getBanner_location() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getBanner_location());
                }
                if (entity.getLink_type() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getLink_type());
                }
                if (entity.getCenter_id() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getCenter_id());
                }
                statement.bindLong(17, entity.getIs_combo());
                statement.bindLong(18, entity.getAuto_id());
            }
        };
        this.__preparedStmtOfDeleteBanners = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.BannerListDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM BannerListTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.BannerListDao
    public long addBanner(final BannerListTable bannerListTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfBannerListTable.insertAndReturnId(bannerListTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.BannerListDao
    public int deleteBanner(final BannerListTable bannerListTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfBannerListTable.handle(bannerListTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.BannerListDao
    public int updateBanner(final BannerListTable bannerListTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfBannerListTable.handle(bannerListTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.BannerListDao
    public void deleteBanners() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteBanners.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeleteBanners.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.BannerListDao
    public List<BannerListTable> getBanner(final String userid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BannerListTable where user_id IN (?)", 1);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_title");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_url");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "master_cat");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.COURSE_TYPE);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PARENT_ID);
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_type");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_location");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "center_id");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.IS_COMBO);
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                BannerListTable bannerListTable = new BannerListTable();
                ArrayList arrayList2 = arrayList;
                bannerListTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                bannerListTable.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                bannerListTable.setExtra(SeminarExtraConverter.fromString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3)));
                bannerListTable.setBanner_title(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                bannerListTable.setImage_type(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                bannerListTable.setBanner_url(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                bannerListTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                bannerListTable.setMaster_cat(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                bannerListTable.setCourse_type(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                bannerListTable.setLink(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                bannerListTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                bannerListTable.setParent_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                bannerListTable.setBanner_type(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i4 = i3;
                if (cursorQuery.isNull(i4)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(i4);
                }
                bannerListTable.setBanner_location(string);
                int i5 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i5)) {
                    i2 = i5;
                    string2 = null;
                } else {
                    i2 = i5;
                    string2 = cursorQuery.getString(i5);
                }
                bannerListTable.setLink_type(string2);
                int i6 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i6)) {
                    columnIndexOrThrow16 = i6;
                    string3 = null;
                } else {
                    columnIndexOrThrow16 = i6;
                    string3 = cursorQuery.getString(i6);
                }
                bannerListTable.setCenter_id(string3);
                int i7 = columnIndexOrThrow17;
                bannerListTable.setIs_combo(cursorQuery.getInt(i7));
                arrayList = arrayList2;
                arrayList.add(bannerListTable);
                int i8 = i2;
                i3 = i4;
                columnIndexOrThrow15 = i8;
                columnIndexOrThrow17 = i7;
                columnIndexOrThrow = i;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.appnew.android.Dao.BannerListDao
    public List<BannerListTable> getAllBanners() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM BannerListTable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "image_type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "master_cat");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.COURSE_TYPE);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "link");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.PARENT_ID);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_type");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_location");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LINK_TYPE);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "center_id");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.IS_COMBO);
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BannerListTable bannerListTable = new BannerListTable();
                    ArrayList arrayList2 = arrayList;
                    bannerListTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                    bannerListTable.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    bannerListTable.setExtra(SeminarExtraConverter.fromString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3)));
                    bannerListTable.setBanner_title(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    bannerListTable.setImage_type(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    bannerListTable.setBanner_url(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    bannerListTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    bannerListTable.setMaster_cat(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    bannerListTable.setCourse_type(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    bannerListTable.setLink(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    bannerListTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    bannerListTable.setParent_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    bannerListTable.setBanner_type(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    if (cursorQuery.isNull(i4)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(i4);
                    }
                    bannerListTable.setBanner_location(string);
                    int i5 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i5)) {
                        i2 = i5;
                        string2 = null;
                    } else {
                        i2 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    bannerListTable.setLink_type(string2);
                    int i6 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i6)) {
                        columnIndexOrThrow16 = i6;
                        string3 = null;
                    } else {
                        columnIndexOrThrow16 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    bannerListTable.setCenter_id(string3);
                    int i7 = columnIndexOrThrow17;
                    bannerListTable.setIs_combo(cursorQuery.getInt(i7));
                    arrayList = arrayList2;
                    arrayList.add(bannerListTable);
                    int i8 = i2;
                    i3 = i4;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow17 = i7;
                    columnIndexOrThrow = i;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
