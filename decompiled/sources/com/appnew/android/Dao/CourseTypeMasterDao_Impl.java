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
import com.appnew.android.table.CourseTypeMasterTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class CourseTypeMasterDao_Impl implements CourseTypeMasterDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<CourseTypeMasterTable> __deletionAdapterOfCourseTypeMasterTable;
    private final EntityInsertionAdapter<CourseTypeMasterTable> __insertionAdapterOfCourseTypeMasterTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final EntityDeletionOrUpdateAdapter<CourseTypeMasterTable> __updateAdapterOfCourseTypeMasterTable;

    public CourseTypeMasterDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfCourseTypeMasterTable = new EntityInsertionAdapter<CourseTypeMasterTable>(__db) { // from class: com.appnew.android.Dao.CourseTypeMasterDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `CourseTypeMasterTable` (`display_type`,`auto_id`,`id`,`name`,`user_id`,`icon`,`font_color`,`bg_color`,`cat_type`,`master_category_id`,`course_id`,`description`,`sec_color`,`sec_bg_color`,`view_type`,`weblink_url`,`sub_cat_id`) VALUES (?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final CourseTypeMasterTable entity) {
                if (entity.getDisplay_type() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getDisplay_type());
                }
                statement.bindLong(2, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getId());
                }
                if (entity.getName() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getName());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getUser_id());
                }
                if (entity.getIcon() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getIcon());
                }
                if (entity.getFont_color() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getFont_color());
                }
                if (entity.getBg_color() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getBg_color());
                }
                if (entity.getCat_type() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCat_type());
                }
                if (entity.getMaster_category_id() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getMaster_category_id());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getCourse_id());
                }
                if (entity.getDescription() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getDescription());
                }
                if (entity.getSec_color() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getSec_color());
                }
                if (entity.getSec_bg_color() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getSec_bg_color());
                }
                if (entity.getView_type() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getView_type());
                }
                if (entity.getWeblink_url() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getWeblink_url());
                }
                if (entity.getSub_cat_id() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getSub_cat_id());
                }
            }
        };
        this.__deletionAdapterOfCourseTypeMasterTable = new EntityDeletionOrUpdateAdapter<CourseTypeMasterTable>(__db) { // from class: com.appnew.android.Dao.CourseTypeMasterDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `CourseTypeMasterTable` WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final CourseTypeMasterTable entity) {
                statement.bindLong(1, entity.getAuto_id());
            }
        };
        this.__updateAdapterOfCourseTypeMasterTable = new EntityDeletionOrUpdateAdapter<CourseTypeMasterTable>(__db) { // from class: com.appnew.android.Dao.CourseTypeMasterDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `CourseTypeMasterTable` SET `display_type` = ?,`auto_id` = ?,`id` = ?,`name` = ?,`user_id` = ?,`icon` = ?,`font_color` = ?,`bg_color` = ?,`cat_type` = ?,`master_category_id` = ?,`course_id` = ?,`description` = ?,`sec_color` = ?,`sec_bg_color` = ?,`view_type` = ?,`weblink_url` = ?,`sub_cat_id` = ? WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final CourseTypeMasterTable entity) {
                if (entity.getDisplay_type() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getDisplay_type());
                }
                statement.bindLong(2, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getId());
                }
                if (entity.getName() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getName());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getUser_id());
                }
                if (entity.getIcon() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getIcon());
                }
                if (entity.getFont_color() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getFont_color());
                }
                if (entity.getBg_color() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getBg_color());
                }
                if (entity.getCat_type() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCat_type());
                }
                if (entity.getMaster_category_id() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getMaster_category_id());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getCourse_id());
                }
                if (entity.getDescription() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getDescription());
                }
                if (entity.getSec_color() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getSec_color());
                }
                if (entity.getSec_bg_color() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getSec_bg_color());
                }
                if (entity.getView_type() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getView_type());
                }
                if (entity.getWeblink_url() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getWeblink_url());
                }
                if (entity.getSub_cat_id() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getSub_cat_id());
                }
                statement.bindLong(18, entity.getAuto_id());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CourseTypeMasterDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM CourseTypeMasterTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.CourseTypeMasterDao
    public long addUser(final CourseTypeMasterTable courseTypeMasterTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfCourseTypeMasterTable.insertAndReturnId(courseTypeMasterTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CourseTypeMasterDao
    public int deleteUser(final CourseTypeMasterTable courseTypeMasterTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfCourseTypeMasterTable.handle(courseTypeMasterTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CourseTypeMasterDao
    public int updateUser(final CourseTypeMasterTable courseTypeMasterTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfCourseTypeMasterTable.handle(courseTypeMasterTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CourseTypeMasterDao
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

    @Override // com.appnew.android.Dao.CourseTypeMasterDao
    public List<CourseTypeMasterTable> getcourse_typemaster(final String userid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        String string5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CourseTypeMasterTable where user_id IN (?)", 1);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "font_color");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.MASTER_CATEGORY_ID);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sec_color");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sec_bg_color");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_type");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "weblink_url");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    CourseTypeMasterTable courseTypeMasterTable = new CourseTypeMasterTable();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    courseTypeMasterTable.setDisplay_type(string);
                    courseTypeMasterTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow2));
                    courseTypeMasterTable.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    courseTypeMasterTable.setName(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    courseTypeMasterTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    courseTypeMasterTable.setIcon(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    courseTypeMasterTable.setFont_color(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    courseTypeMasterTable.setBg_color(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    courseTypeMasterTable.setCat_type(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    courseTypeMasterTable.setMaster_category_id(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    courseTypeMasterTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    courseTypeMasterTable.setDescription(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    courseTypeMasterTable.setSec_color(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    if (cursorQuery.isNull(i5)) {
                        i2 = i5;
                        string2 = null;
                    } else {
                        i2 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    courseTypeMasterTable.setSec_bg_color(string2);
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i3 = i6;
                        string3 = null;
                    } else {
                        i3 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    courseTypeMasterTable.setView_type(string3);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string4 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string4 = cursorQuery.getString(i7);
                    }
                    courseTypeMasterTable.setWeblink_url(string4);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string5 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string5 = cursorQuery.getString(i8);
                    }
                    courseTypeMasterTable.setSub_cat_id(string5);
                    arrayList.add(courseTypeMasterTable);
                    columnIndexOrThrow15 = i3;
                    i4 = i2;
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

    @Override // com.appnew.android.Dao.CourseTypeMasterDao
    public List<CourseTypeMasterTable> getAllUser() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        int i3;
        String string3;
        String string4;
        String string5;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CourseTypeMasterTable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "icon");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "font_color");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.MASTER_CATEGORY_ID);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sec_color");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sec_bg_color");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_type");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "weblink_url");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sub_cat_id");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    CourseTypeMasterTable courseTypeMasterTable = new CourseTypeMasterTable();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    courseTypeMasterTable.setDisplay_type(string);
                    courseTypeMasterTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow2));
                    courseTypeMasterTable.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    courseTypeMasterTable.setName(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    courseTypeMasterTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    courseTypeMasterTable.setIcon(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    courseTypeMasterTable.setFont_color(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    courseTypeMasterTable.setBg_color(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    courseTypeMasterTable.setCat_type(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    courseTypeMasterTable.setMaster_category_id(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    courseTypeMasterTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    courseTypeMasterTable.setDescription(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    courseTypeMasterTable.setSec_color(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    if (cursorQuery.isNull(i5)) {
                        i2 = i5;
                        string2 = null;
                    } else {
                        i2 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    courseTypeMasterTable.setSec_bg_color(string2);
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i3 = i6;
                        string3 = null;
                    } else {
                        i3 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    courseTypeMasterTable.setView_type(string3);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string4 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string4 = cursorQuery.getString(i7);
                    }
                    courseTypeMasterTable.setWeblink_url(string4);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string5 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string5 = cursorQuery.getString(i8);
                    }
                    courseTypeMasterTable.setSub_cat_id(string5);
                    arrayList.add(courseTypeMasterTable);
                    columnIndexOrThrow15 = i3;
                    i4 = i2;
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
