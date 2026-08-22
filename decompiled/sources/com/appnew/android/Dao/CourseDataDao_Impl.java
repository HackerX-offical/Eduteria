package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.Model.ExtraJson;
import com.appnew.android.TypeConverter.SourceTypeConverter;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.CourseDataTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
public final class CourseDataDao_Impl implements CourseDataDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<CourseDataTable> __insertionAdapterOfCourseDataTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletecoursedata;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdateExtraJson;
    private final SourceTypeConverter __sourceTypeConverter = new SourceTypeConverter();

    public CourseDataDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfCourseDataTable = new EntityInsertionAdapter<CourseDataTable>(__db) { // from class: com.appnew.android.Dao.CourseDataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `CourseDataTable` (`autoid`,`userid`,`cat_type`,`mainid`,`category`,`courseid`,`title`,`cover_image`,`desc_header_image`,`mrp`,`payment_mode`,`course_sp`,`subject_id`,`avg_rating`,`user_rated`,`is_purchased`,`content_type`,`lang_id`,`extra_json`,`validity`,`type_id`,`combo_course_ids`,`viewType`,`valid_to`,`hide_validity`,`discount`,`cart_quantity`,`stocks`,`delivery_charge`,`delivery_charge_out_of_india`,`description`,`book_redirection_link`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final CourseDataTable entity) throws JSONException {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getUser_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUser_id());
                }
                if (entity.getCat_type() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getCat_type());
                }
                if (entity.getMain_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getMain_id());
                }
                if (entity.getCategory() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getCategory());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getCourse_id());
                }
                if (entity.getTitle() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getTitle());
                }
                if (entity.getCover_image() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getCover_image());
                }
                if (entity.getDesc_header_image() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getDesc_header_image());
                }
                if (entity.getMrp() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getMrp());
                }
                if (entity.getPayment_mode() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getPayment_mode());
                }
                if (entity.getCourse_sp() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getCourse_sp());
                }
                if (entity.getSubject_id() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getSubject_id());
                }
                if (entity.getAvg_rating() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getAvg_rating());
                }
                if (entity.getUser_rated() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getUser_rated());
                }
                if (entity.getIs_purchased() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getIs_purchased());
                }
                if (entity.getContent_type() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getContent_type());
                }
                if (entity.getLang_id() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getLang_id());
                }
                String strFromSource = CourseDataDao_Impl.this.__sourceTypeConverter.fromSource(entity.getExtra_json());
                if (strFromSource == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, strFromSource);
                }
                if (entity.getValidity() == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, entity.getValidity());
                }
                if (entity.getType_id() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getType_id());
                }
                if (entity.getCombo_course_ids() == null) {
                    statement.bindNull(22);
                } else {
                    statement.bindString(22, entity.getCombo_course_ids());
                }
                if (entity.getViewType() == null) {
                    statement.bindNull(23);
                } else {
                    statement.bindString(23, entity.getViewType());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(24);
                } else {
                    statement.bindString(24, entity.getValid_to());
                }
                if (entity.getHide_validity() == null) {
                    statement.bindNull(25);
                } else {
                    statement.bindString(25, entity.getHide_validity());
                }
                if (entity.getDiscount() == null) {
                    statement.bindNull(26);
                } else {
                    statement.bindString(26, entity.getDiscount());
                }
                if (entity.getCart_quantity() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getCart_quantity());
                }
                if (entity.getStocks() == null) {
                    statement.bindNull(28);
                } else {
                    statement.bindString(28, entity.getStocks());
                }
                if (entity.getDelivery_charge() == null) {
                    statement.bindNull(29);
                } else {
                    statement.bindString(29, entity.getDelivery_charge());
                }
                if (entity.getDelivery_charge_out_of_india() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getDelivery_charge_out_of_india());
                }
                if (entity.getDescription() == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, entity.getDescription());
                }
                if (entity.getBook_redirection_link() == null) {
                    statement.bindNull(32);
                } else {
                    statement.bindString(32, entity.getBook_redirection_link());
                }
            }
        };
        this.__preparedStmtOfDeletecoursedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CourseDataDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete  FROM CourseDataTable  WHERE mainid = ? AND userid =?";
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CourseDataDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM CourseDataTable";
            }
        };
        this.__preparedStmtOfUpdateExtraJson = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CourseDataDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE CourseDataTable SET extra_json = ? WHERE courseid = ? AND mainid = ? AND userid = ?";
            }
        };
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public long addCoursedata(final CourseDataTable coursedetail) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfCourseDataTable.insertAndReturnId(coursedetail);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public int deletecoursedata(final String main_id, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletecoursedata.acquire();
        if (main_id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, main_id);
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
            this.__preparedStmtOfDeletecoursedata.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
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

    @Override // com.appnew.android.Dao.CourseDataDao
    public void updateExtraJson(final String courseId, final String mainId, final String userId, final ExtraJson extraJson) throws JSONException {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateExtraJson.acquire();
        String strFromSource = this.__sourceTypeConverter.fromSource(extraJson);
        if (strFromSource == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, strFromSource);
        }
        if (courseId == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, courseId);
        }
        if (mainId == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, mainId);
        }
        if (userId == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, userId);
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
            this.__preparedStmtOfUpdateExtraJson.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public boolean isRecordExistsUserId(final String mainid, final String userid, final String courseid, final String type_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM CourseDataTable WHERE mainid = ? AND  courseid = ? AND userid = ? AND type_id = ?)", 4);
        if (mainid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, mainid);
        }
        if (courseid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, courseid);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, userid);
        }
        if (type_id == null) {
            roomSQLiteQueryAcquire.bindNull(4);
        } else {
            roomSQLiteQueryAcquire.bindString(4, type_id);
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

    @Override // com.appnew.android.Dao.CourseDataDao
    public List<CourseDataTable> getcoursedatawithfilter(final String main_id, final String userid, final String category) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        String string3;
        int i2;
        String string4;
        String string5;
        String string6;
        int i3;
        int i4;
        int i5;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CourseDataTable  WHERE mainid = ? AND userid =? AND type_id=? ORDER BY autoid", 3);
        if (main_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, main_id);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        if (category == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, category);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mainid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.CATEGORY);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseid");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "desc_header_image");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payment_mode");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_sp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.SUBJECT_ID);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avg_rating");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_rated");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_purchased");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lang_id");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_json");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type_id");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hide_validity");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "discount");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cart_quantity");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stocks");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.DELIVERY_CHARGE);
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delivery_charge_out_of_india");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_redirection_link");
                    int i6 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        CourseDataTable courseDataTable = new CourseDataTable();
                        ArrayList arrayList2 = arrayList;
                        courseDataTable.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                        courseDataTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        courseDataTable.setCat_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        courseDataTable.setMain_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        courseDataTable.setCategory(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        courseDataTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        courseDataTable.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        courseDataTable.setCover_image(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        courseDataTable.setDesc_header_image(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        courseDataTable.setMrp(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        courseDataTable.setPayment_mode(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        courseDataTable.setCourse_sp(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        courseDataTable.setSubject_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                        int i7 = i6;
                        if (cursorQuery.isNull(i7)) {
                            i = columnIndexOrThrow;
                            string = null;
                        } else {
                            i = columnIndexOrThrow;
                            string = cursorQuery.getString(i7);
                        }
                        courseDataTable.setAvg_rating(string);
                        int i8 = columnIndexOrThrow15;
                        if (cursorQuery.isNull(i8)) {
                            columnIndexOrThrow15 = i8;
                            string2 = null;
                        } else {
                            columnIndexOrThrow15 = i8;
                            string2 = cursorQuery.getString(i8);
                        }
                        courseDataTable.setUser_rated(string2);
                        int i9 = columnIndexOrThrow16;
                        if (cursorQuery.isNull(i9)) {
                            columnIndexOrThrow16 = i9;
                            string3 = null;
                        } else {
                            columnIndexOrThrow16 = i9;
                            string3 = cursorQuery.getString(i9);
                        }
                        courseDataTable.setIs_purchased(string3);
                        int i10 = columnIndexOrThrow17;
                        if (cursorQuery.isNull(i10)) {
                            i2 = i10;
                            string4 = null;
                        } else {
                            i2 = i10;
                            string4 = cursorQuery.getString(i10);
                        }
                        courseDataTable.setContent_type(string4);
                        int i11 = columnIndexOrThrow18;
                        if (cursorQuery.isNull(i11)) {
                            columnIndexOrThrow18 = i11;
                            string5 = null;
                        } else {
                            columnIndexOrThrow18 = i11;
                            string5 = cursorQuery.getString(i11);
                        }
                        courseDataTable.setLang_id(string5);
                        int i12 = columnIndexOrThrow19;
                        if (cursorQuery.isNull(i12)) {
                            columnIndexOrThrow19 = i12;
                            string6 = null;
                            i4 = i7;
                            i3 = columnIndexOrThrow13;
                        } else {
                            columnIndexOrThrow19 = i12;
                            string6 = cursorQuery.getString(i12);
                            i3 = columnIndexOrThrow13;
                            i4 = i7;
                        }
                        courseDataTable.setExtra_json(this.__sourceTypeConverter.toSource(string6));
                        int i13 = columnIndexOrThrow20;
                        courseDataTable.setValidity(cursorQuery.isNull(i13) ? null : cursorQuery.getString(i13));
                        int i14 = columnIndexOrThrow21;
                        if (cursorQuery.isNull(i14)) {
                            i5 = i13;
                            string7 = null;
                        } else {
                            i5 = i13;
                            string7 = cursorQuery.getString(i14);
                        }
                        courseDataTable.setType_id(string7);
                        int i15 = columnIndexOrThrow22;
                        if (cursorQuery.isNull(i15)) {
                            columnIndexOrThrow22 = i15;
                            string8 = null;
                        } else {
                            columnIndexOrThrow22 = i15;
                            string8 = cursorQuery.getString(i15);
                        }
                        courseDataTable.setCombo_course_ids(string8);
                        int i16 = columnIndexOrThrow23;
                        if (cursorQuery.isNull(i16)) {
                            columnIndexOrThrow23 = i16;
                            string9 = null;
                        } else {
                            columnIndexOrThrow23 = i16;
                            string9 = cursorQuery.getString(i16);
                        }
                        courseDataTable.setViewType(string9);
                        int i17 = columnIndexOrThrow24;
                        if (cursorQuery.isNull(i17)) {
                            columnIndexOrThrow24 = i17;
                            string10 = null;
                        } else {
                            columnIndexOrThrow24 = i17;
                            string10 = cursorQuery.getString(i17);
                        }
                        courseDataTable.setValid_to(string10);
                        int i18 = columnIndexOrThrow25;
                        if (cursorQuery.isNull(i18)) {
                            columnIndexOrThrow25 = i18;
                            string11 = null;
                        } else {
                            columnIndexOrThrow25 = i18;
                            string11 = cursorQuery.getString(i18);
                        }
                        courseDataTable.setHide_validity(string11);
                        int i19 = columnIndexOrThrow26;
                        if (cursorQuery.isNull(i19)) {
                            columnIndexOrThrow26 = i19;
                            string12 = null;
                        } else {
                            columnIndexOrThrow26 = i19;
                            string12 = cursorQuery.getString(i19);
                        }
                        courseDataTable.setDiscount(string12);
                        int i20 = columnIndexOrThrow27;
                        if (cursorQuery.isNull(i20)) {
                            columnIndexOrThrow27 = i20;
                            string13 = null;
                        } else {
                            columnIndexOrThrow27 = i20;
                            string13 = cursorQuery.getString(i20);
                        }
                        courseDataTable.setCart_quantity(string13);
                        int i21 = columnIndexOrThrow28;
                        if (cursorQuery.isNull(i21)) {
                            columnIndexOrThrow28 = i21;
                            string14 = null;
                        } else {
                            columnIndexOrThrow28 = i21;
                            string14 = cursorQuery.getString(i21);
                        }
                        courseDataTable.setStocks(string14);
                        int i22 = columnIndexOrThrow29;
                        if (cursorQuery.isNull(i22)) {
                            columnIndexOrThrow29 = i22;
                            string15 = null;
                        } else {
                            columnIndexOrThrow29 = i22;
                            string15 = cursorQuery.getString(i22);
                        }
                        courseDataTable.setDelivery_charge(string15);
                        int i23 = columnIndexOrThrow30;
                        if (cursorQuery.isNull(i23)) {
                            columnIndexOrThrow30 = i23;
                            string16 = null;
                        } else {
                            columnIndexOrThrow30 = i23;
                            string16 = cursorQuery.getString(i23);
                        }
                        courseDataTable.setDelivery_charge_out_of_india(string16);
                        int i24 = columnIndexOrThrow31;
                        if (cursorQuery.isNull(i24)) {
                            columnIndexOrThrow31 = i24;
                            string17 = null;
                        } else {
                            columnIndexOrThrow31 = i24;
                            string17 = cursorQuery.getString(i24);
                        }
                        courseDataTable.setDescription(string17);
                        int i25 = columnIndexOrThrow32;
                        if (cursorQuery.isNull(i25)) {
                            columnIndexOrThrow32 = i25;
                            string18 = null;
                        } else {
                            columnIndexOrThrow32 = i25;
                            string18 = cursorQuery.getString(i25);
                        }
                        courseDataTable.setBook_redirection_link(string18);
                        arrayList2.add(courseDataTable);
                        int i26 = i2;
                        i6 = i4;
                        columnIndexOrThrow17 = i26;
                        arrayList = arrayList2;
                        columnIndexOrThrow20 = i5;
                        columnIndexOrThrow = i;
                        columnIndexOrThrow21 = i14;
                        columnIndexOrThrow13 = i3;
                    }
                    ArrayList arrayList3 = arrayList;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList3;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public List<CourseDataTable> getcoursedata(final String main_id, final String userid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        int i2;
        String string3;
        String string4;
        String string5;
        String string6;
        int i3;
        int i4;
        int i5;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CourseDataTable  WHERE mainid = ? AND userid =? GROUP BY courseid ORDER BY autoid", 2);
        if (main_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, main_id);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mainid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.CATEGORY);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseid");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "desc_header_image");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payment_mode");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_sp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.SUBJECT_ID);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avg_rating");
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_rated");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_purchased");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lang_id");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_json");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type_id");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hide_validity");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "discount");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cart_quantity");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stocks");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.DELIVERY_CHARGE);
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delivery_charge_out_of_india");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_redirection_link");
                    int i6 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        CourseDataTable courseDataTable = new CourseDataTable();
                        ArrayList arrayList2 = arrayList;
                        courseDataTable.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                        courseDataTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        courseDataTable.setCat_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        courseDataTable.setMain_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        courseDataTable.setCategory(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        courseDataTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        courseDataTable.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        courseDataTable.setCover_image(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        courseDataTable.setDesc_header_image(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        courseDataTable.setMrp(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        courseDataTable.setPayment_mode(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        courseDataTable.setCourse_sp(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        courseDataTable.setSubject_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                        int i7 = i6;
                        if (cursorQuery.isNull(i7)) {
                            i = columnIndexOrThrow;
                            string = null;
                        } else {
                            i = columnIndexOrThrow;
                            string = cursorQuery.getString(i7);
                        }
                        courseDataTable.setAvg_rating(string);
                        int i8 = columnIndexOrThrow15;
                        if (cursorQuery.isNull(i8)) {
                            columnIndexOrThrow15 = i8;
                            string2 = null;
                        } else {
                            columnIndexOrThrow15 = i8;
                            string2 = cursorQuery.getString(i8);
                        }
                        courseDataTable.setUser_rated(string2);
                        int i9 = columnIndexOrThrow16;
                        if (cursorQuery.isNull(i9)) {
                            i2 = i9;
                            string3 = null;
                        } else {
                            i2 = i9;
                            string3 = cursorQuery.getString(i9);
                        }
                        courseDataTable.setIs_purchased(string3);
                        int i10 = columnIndexOrThrow17;
                        if (cursorQuery.isNull(i10)) {
                            columnIndexOrThrow17 = i10;
                            string4 = null;
                        } else {
                            columnIndexOrThrow17 = i10;
                            string4 = cursorQuery.getString(i10);
                        }
                        courseDataTable.setContent_type(string4);
                        int i11 = columnIndexOrThrow18;
                        if (cursorQuery.isNull(i11)) {
                            columnIndexOrThrow18 = i11;
                            string5 = null;
                        } else {
                            columnIndexOrThrow18 = i11;
                            string5 = cursorQuery.getString(i11);
                        }
                        courseDataTable.setLang_id(string5);
                        int i12 = columnIndexOrThrow19;
                        if (cursorQuery.isNull(i12)) {
                            columnIndexOrThrow19 = i12;
                            string6 = null;
                            i4 = i7;
                            i3 = columnIndexOrThrow13;
                        } else {
                            columnIndexOrThrow19 = i12;
                            string6 = cursorQuery.getString(i12);
                            i3 = columnIndexOrThrow13;
                            i4 = i7;
                        }
                        courseDataTable.setExtra_json(this.__sourceTypeConverter.toSource(string6));
                        int i13 = columnIndexOrThrow20;
                        courseDataTable.setValidity(cursorQuery.isNull(i13) ? null : cursorQuery.getString(i13));
                        int i14 = columnIndexOrThrow21;
                        if (cursorQuery.isNull(i14)) {
                            i5 = i13;
                            string7 = null;
                        } else {
                            i5 = i13;
                            string7 = cursorQuery.getString(i14);
                        }
                        courseDataTable.setType_id(string7);
                        int i15 = columnIndexOrThrow22;
                        if (cursorQuery.isNull(i15)) {
                            columnIndexOrThrow22 = i15;
                            string8 = null;
                        } else {
                            columnIndexOrThrow22 = i15;
                            string8 = cursorQuery.getString(i15);
                        }
                        courseDataTable.setCombo_course_ids(string8);
                        int i16 = columnIndexOrThrow23;
                        if (cursorQuery.isNull(i16)) {
                            columnIndexOrThrow23 = i16;
                            string9 = null;
                        } else {
                            columnIndexOrThrow23 = i16;
                            string9 = cursorQuery.getString(i16);
                        }
                        courseDataTable.setViewType(string9);
                        int i17 = columnIndexOrThrow24;
                        if (cursorQuery.isNull(i17)) {
                            columnIndexOrThrow24 = i17;
                            string10 = null;
                        } else {
                            columnIndexOrThrow24 = i17;
                            string10 = cursorQuery.getString(i17);
                        }
                        courseDataTable.setValid_to(string10);
                        int i18 = columnIndexOrThrow25;
                        if (cursorQuery.isNull(i18)) {
                            columnIndexOrThrow25 = i18;
                            string11 = null;
                        } else {
                            columnIndexOrThrow25 = i18;
                            string11 = cursorQuery.getString(i18);
                        }
                        courseDataTable.setHide_validity(string11);
                        int i19 = columnIndexOrThrow26;
                        if (cursorQuery.isNull(i19)) {
                            columnIndexOrThrow26 = i19;
                            string12 = null;
                        } else {
                            columnIndexOrThrow26 = i19;
                            string12 = cursorQuery.getString(i19);
                        }
                        courseDataTable.setDiscount(string12);
                        int i20 = columnIndexOrThrow27;
                        if (cursorQuery.isNull(i20)) {
                            columnIndexOrThrow27 = i20;
                            string13 = null;
                        } else {
                            columnIndexOrThrow27 = i20;
                            string13 = cursorQuery.getString(i20);
                        }
                        courseDataTable.setCart_quantity(string13);
                        int i21 = columnIndexOrThrow28;
                        if (cursorQuery.isNull(i21)) {
                            columnIndexOrThrow28 = i21;
                            string14 = null;
                        } else {
                            columnIndexOrThrow28 = i21;
                            string14 = cursorQuery.getString(i21);
                        }
                        courseDataTable.setStocks(string14);
                        int i22 = columnIndexOrThrow29;
                        if (cursorQuery.isNull(i22)) {
                            columnIndexOrThrow29 = i22;
                            string15 = null;
                        } else {
                            columnIndexOrThrow29 = i22;
                            string15 = cursorQuery.getString(i22);
                        }
                        courseDataTable.setDelivery_charge(string15);
                        int i23 = columnIndexOrThrow30;
                        if (cursorQuery.isNull(i23)) {
                            columnIndexOrThrow30 = i23;
                            string16 = null;
                        } else {
                            columnIndexOrThrow30 = i23;
                            string16 = cursorQuery.getString(i23);
                        }
                        courseDataTable.setDelivery_charge_out_of_india(string16);
                        int i24 = columnIndexOrThrow31;
                        if (cursorQuery.isNull(i24)) {
                            columnIndexOrThrow31 = i24;
                            string17 = null;
                        } else {
                            columnIndexOrThrow31 = i24;
                            string17 = cursorQuery.getString(i24);
                        }
                        courseDataTable.setDescription(string17);
                        int i25 = columnIndexOrThrow32;
                        if (cursorQuery.isNull(i25)) {
                            columnIndexOrThrow32 = i25;
                            string18 = null;
                        } else {
                            columnIndexOrThrow32 = i25;
                            string18 = cursorQuery.getString(i25);
                        }
                        courseDataTable.setBook_redirection_link(string18);
                        arrayList2.add(courseDataTable);
                        int i26 = i2;
                        i6 = i4;
                        columnIndexOrThrow16 = i26;
                        arrayList = arrayList2;
                        columnIndexOrThrow20 = i5;
                        columnIndexOrThrow = i;
                        columnIndexOrThrow21 = i14;
                        columnIndexOrThrow13 = i3;
                    }
                    ArrayList arrayList3 = arrayList;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    return arrayList3;
                } catch (Throwable th) {
                    th = th;
                    cursorQuery.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public List<CourseDataTable> getcoursedatafilterforpaid(final String main_id, final String userid, final String category, final String subject_id, final String langid) throws Throwable {
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
        String string2;
        String string3;
        String string4;
        String string5;
        int i2;
        String string6;
        int i3;
        int i4;
        int i5;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CourseDataTable  WHERE mainid = ? AND userid =? AND type_id=? AND subject_id=? AND lang_id=? AND mrp>0", 5);
        if (main_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, main_id);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        if (category == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, category);
        }
        if (subject_id == null) {
            roomSQLiteQueryAcquire.bindNull(4);
        } else {
            roomSQLiteQueryAcquire.bindString(4, subject_id);
        }
        if (langid == null) {
            roomSQLiteQueryAcquire.bindNull(5);
        } else {
            roomSQLiteQueryAcquire.bindString(5, langid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mainid");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.CATEGORY);
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseid");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "desc_header_image");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payment_mode");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_sp");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.SUBJECT_ID);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avg_rating");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_rated");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_purchased");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lang_id");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_json");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hide_validity");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "discount");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cart_quantity");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stocks");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.DELIVERY_CHARGE);
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delivery_charge_out_of_india");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_redirection_link");
            int i6 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                CourseDataTable courseDataTable = new CourseDataTable();
                ArrayList arrayList2 = arrayList;
                courseDataTable.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                courseDataTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                courseDataTable.setCat_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                courseDataTable.setMain_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                courseDataTable.setCategory(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                courseDataTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                courseDataTable.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                courseDataTable.setCover_image(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                courseDataTable.setDesc_header_image(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                courseDataTable.setMrp(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                courseDataTable.setPayment_mode(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                courseDataTable.setCourse_sp(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                courseDataTable.setSubject_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i7 = i6;
                if (cursorQuery.isNull(i7)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(i7);
                }
                courseDataTable.setAvg_rating(string);
                int i8 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i8)) {
                    columnIndexOrThrow15 = i8;
                    string2 = null;
                } else {
                    columnIndexOrThrow15 = i8;
                    string2 = cursorQuery.getString(i8);
                }
                courseDataTable.setUser_rated(string2);
                int i9 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i9)) {
                    columnIndexOrThrow16 = i9;
                    string3 = null;
                } else {
                    columnIndexOrThrow16 = i9;
                    string3 = cursorQuery.getString(i9);
                }
                courseDataTable.setIs_purchased(string3);
                int i10 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i10)) {
                    columnIndexOrThrow17 = i10;
                    string4 = null;
                } else {
                    columnIndexOrThrow17 = i10;
                    string4 = cursorQuery.getString(i10);
                }
                courseDataTable.setContent_type(string4);
                int i11 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i11)) {
                    columnIndexOrThrow18 = i11;
                    string5 = null;
                } else {
                    columnIndexOrThrow18 = i11;
                    string5 = cursorQuery.getString(i11);
                }
                courseDataTable.setLang_id(string5);
                int i12 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i12)) {
                    i2 = i12;
                    string6 = null;
                    i4 = i7;
                    i3 = columnIndexOrThrow13;
                } else {
                    i2 = i12;
                    string6 = cursorQuery.getString(i12);
                    i3 = columnIndexOrThrow13;
                    i4 = i7;
                }
                courseDataTable.setExtra_json(this.__sourceTypeConverter.toSource(string6));
                int i13 = columnIndexOrThrow20;
                courseDataTable.setValidity(cursorQuery.isNull(i13) ? null : cursorQuery.getString(i13));
                int i14 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i14)) {
                    i5 = i13;
                    string7 = null;
                } else {
                    i5 = i13;
                    string7 = cursorQuery.getString(i14);
                }
                courseDataTable.setType_id(string7);
                int i15 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow22 = i15;
                    string8 = null;
                } else {
                    columnIndexOrThrow22 = i15;
                    string8 = cursorQuery.getString(i15);
                }
                courseDataTable.setCombo_course_ids(string8);
                int i16 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i16)) {
                    columnIndexOrThrow23 = i16;
                    string9 = null;
                } else {
                    columnIndexOrThrow23 = i16;
                    string9 = cursorQuery.getString(i16);
                }
                courseDataTable.setViewType(string9);
                int i17 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i17)) {
                    columnIndexOrThrow24 = i17;
                    string10 = null;
                } else {
                    columnIndexOrThrow24 = i17;
                    string10 = cursorQuery.getString(i17);
                }
                courseDataTable.setValid_to(string10);
                int i18 = columnIndexOrThrow25;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow25 = i18;
                    string11 = null;
                } else {
                    columnIndexOrThrow25 = i18;
                    string11 = cursorQuery.getString(i18);
                }
                courseDataTable.setHide_validity(string11);
                int i19 = columnIndexOrThrow26;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow26 = i19;
                    string12 = null;
                } else {
                    columnIndexOrThrow26 = i19;
                    string12 = cursorQuery.getString(i19);
                }
                courseDataTable.setDiscount(string12);
                int i20 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow27 = i20;
                    string13 = null;
                } else {
                    columnIndexOrThrow27 = i20;
                    string13 = cursorQuery.getString(i20);
                }
                courseDataTable.setCart_quantity(string13);
                int i21 = columnIndexOrThrow28;
                if (cursorQuery.isNull(i21)) {
                    columnIndexOrThrow28 = i21;
                    string14 = null;
                } else {
                    columnIndexOrThrow28 = i21;
                    string14 = cursorQuery.getString(i21);
                }
                courseDataTable.setStocks(string14);
                int i22 = columnIndexOrThrow29;
                if (cursorQuery.isNull(i22)) {
                    columnIndexOrThrow29 = i22;
                    string15 = null;
                } else {
                    columnIndexOrThrow29 = i22;
                    string15 = cursorQuery.getString(i22);
                }
                courseDataTable.setDelivery_charge(string15);
                int i23 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow30 = i23;
                    string16 = null;
                } else {
                    columnIndexOrThrow30 = i23;
                    string16 = cursorQuery.getString(i23);
                }
                courseDataTable.setDelivery_charge_out_of_india(string16);
                int i24 = columnIndexOrThrow31;
                if (cursorQuery.isNull(i24)) {
                    columnIndexOrThrow31 = i24;
                    string17 = null;
                } else {
                    columnIndexOrThrow31 = i24;
                    string17 = cursorQuery.getString(i24);
                }
                courseDataTable.setDescription(string17);
                int i25 = columnIndexOrThrow32;
                if (cursorQuery.isNull(i25)) {
                    columnIndexOrThrow32 = i25;
                    string18 = null;
                } else {
                    columnIndexOrThrow32 = i25;
                    string18 = cursorQuery.getString(i25);
                }
                courseDataTable.setBook_redirection_link(string18);
                arrayList2.add(courseDataTable);
                int i26 = i2;
                i6 = i4;
                columnIndexOrThrow19 = i26;
                arrayList = arrayList2;
                columnIndexOrThrow20 = i5;
                columnIndexOrThrow = i;
                columnIndexOrThrow21 = i14;
                columnIndexOrThrow13 = i3;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public List<CourseDataTable> getcoursedatafilterforfree(final String main_id, final String userid, final String category, final String subject_id, final String langid) throws Throwable {
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
        String string2;
        String string3;
        String string4;
        String string5;
        int i2;
        String string6;
        int i3;
        int i4;
        int i5;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CourseDataTable  WHERE mainid = ? AND userid =? AND type_id=? AND subject_id=? AND lang_id=? AND mrp==0", 5);
        if (main_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, main_id);
        }
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, userid);
        }
        if (category == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, category);
        }
        if (subject_id == null) {
            roomSQLiteQueryAcquire.bindNull(4);
        } else {
            roomSQLiteQueryAcquire.bindString(4, subject_id);
        }
        if (langid == null) {
            roomSQLiteQueryAcquire.bindNull(5);
        } else {
            roomSQLiteQueryAcquire.bindString(5, langid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mainid");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.CATEGORY);
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseid");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "desc_header_image");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payment_mode");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_sp");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.SUBJECT_ID);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avg_rating");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_rated");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_purchased");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lang_id");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_json");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hide_validity");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "discount");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cart_quantity");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stocks");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.DELIVERY_CHARGE);
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delivery_charge_out_of_india");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_redirection_link");
            int i6 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                CourseDataTable courseDataTable = new CourseDataTable();
                ArrayList arrayList2 = arrayList;
                courseDataTable.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                courseDataTable.setUser_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                courseDataTable.setCat_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                courseDataTable.setMain_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                courseDataTable.setCategory(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                courseDataTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                courseDataTable.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                courseDataTable.setCover_image(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                courseDataTable.setDesc_header_image(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                courseDataTable.setMrp(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                courseDataTable.setPayment_mode(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                courseDataTable.setCourse_sp(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                courseDataTable.setSubject_id(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i7 = i6;
                if (cursorQuery.isNull(i7)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(i7);
                }
                courseDataTable.setAvg_rating(string);
                int i8 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i8)) {
                    columnIndexOrThrow15 = i8;
                    string2 = null;
                } else {
                    columnIndexOrThrow15 = i8;
                    string2 = cursorQuery.getString(i8);
                }
                courseDataTable.setUser_rated(string2);
                int i9 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i9)) {
                    columnIndexOrThrow16 = i9;
                    string3 = null;
                } else {
                    columnIndexOrThrow16 = i9;
                    string3 = cursorQuery.getString(i9);
                }
                courseDataTable.setIs_purchased(string3);
                int i10 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i10)) {
                    columnIndexOrThrow17 = i10;
                    string4 = null;
                } else {
                    columnIndexOrThrow17 = i10;
                    string4 = cursorQuery.getString(i10);
                }
                courseDataTable.setContent_type(string4);
                int i11 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i11)) {
                    columnIndexOrThrow18 = i11;
                    string5 = null;
                } else {
                    columnIndexOrThrow18 = i11;
                    string5 = cursorQuery.getString(i11);
                }
                courseDataTable.setLang_id(string5);
                int i12 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i12)) {
                    i2 = i12;
                    string6 = null;
                    i4 = i7;
                    i3 = columnIndexOrThrow13;
                } else {
                    i2 = i12;
                    string6 = cursorQuery.getString(i12);
                    i3 = columnIndexOrThrow13;
                    i4 = i7;
                }
                courseDataTable.setExtra_json(this.__sourceTypeConverter.toSource(string6));
                int i13 = columnIndexOrThrow20;
                courseDataTable.setValidity(cursorQuery.isNull(i13) ? null : cursorQuery.getString(i13));
                int i14 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i14)) {
                    i5 = i13;
                    string7 = null;
                } else {
                    i5 = i13;
                    string7 = cursorQuery.getString(i14);
                }
                courseDataTable.setType_id(string7);
                int i15 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow22 = i15;
                    string8 = null;
                } else {
                    columnIndexOrThrow22 = i15;
                    string8 = cursorQuery.getString(i15);
                }
                courseDataTable.setCombo_course_ids(string8);
                int i16 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i16)) {
                    columnIndexOrThrow23 = i16;
                    string9 = null;
                } else {
                    columnIndexOrThrow23 = i16;
                    string9 = cursorQuery.getString(i16);
                }
                courseDataTable.setViewType(string9);
                int i17 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i17)) {
                    columnIndexOrThrow24 = i17;
                    string10 = null;
                } else {
                    columnIndexOrThrow24 = i17;
                    string10 = cursorQuery.getString(i17);
                }
                courseDataTable.setValid_to(string10);
                int i18 = columnIndexOrThrow25;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow25 = i18;
                    string11 = null;
                } else {
                    columnIndexOrThrow25 = i18;
                    string11 = cursorQuery.getString(i18);
                }
                courseDataTable.setHide_validity(string11);
                int i19 = columnIndexOrThrow26;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow26 = i19;
                    string12 = null;
                } else {
                    columnIndexOrThrow26 = i19;
                    string12 = cursorQuery.getString(i19);
                }
                courseDataTable.setDiscount(string12);
                int i20 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow27 = i20;
                    string13 = null;
                } else {
                    columnIndexOrThrow27 = i20;
                    string13 = cursorQuery.getString(i20);
                }
                courseDataTable.setCart_quantity(string13);
                int i21 = columnIndexOrThrow28;
                if (cursorQuery.isNull(i21)) {
                    columnIndexOrThrow28 = i21;
                    string14 = null;
                } else {
                    columnIndexOrThrow28 = i21;
                    string14 = cursorQuery.getString(i21);
                }
                courseDataTable.setStocks(string14);
                int i22 = columnIndexOrThrow29;
                if (cursorQuery.isNull(i22)) {
                    columnIndexOrThrow29 = i22;
                    string15 = null;
                } else {
                    columnIndexOrThrow29 = i22;
                    string15 = cursorQuery.getString(i22);
                }
                courseDataTable.setDelivery_charge(string15);
                int i23 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow30 = i23;
                    string16 = null;
                } else {
                    columnIndexOrThrow30 = i23;
                    string16 = cursorQuery.getString(i23);
                }
                courseDataTable.setDelivery_charge_out_of_india(string16);
                int i24 = columnIndexOrThrow31;
                if (cursorQuery.isNull(i24)) {
                    columnIndexOrThrow31 = i24;
                    string17 = null;
                } else {
                    columnIndexOrThrow31 = i24;
                    string17 = cursorQuery.getString(i24);
                }
                courseDataTable.setDescription(string17);
                int i25 = columnIndexOrThrow32;
                if (cursorQuery.isNull(i25)) {
                    columnIndexOrThrow32 = i25;
                    string18 = null;
                } else {
                    columnIndexOrThrow32 = i25;
                    string18 = cursorQuery.getString(i25);
                }
                courseDataTable.setBook_redirection_link(string18);
                arrayList2.add(courseDataTable);
                int i26 = i2;
                i6 = i4;
                columnIndexOrThrow19 = i26;
                arrayList = arrayList2;
                columnIndexOrThrow20 = i5;
                columnIndexOrThrow = i;
                columnIndexOrThrow21 = i14;
                columnIndexOrThrow13 = i3;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public void deleteMultipleId(final List<String> ids) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM CourseDataTable WHERE courseid IN (");
        int i = 1;
        StringUtil.appendPlaceholders(sbNewStringBuilder, ids == null ? 1 : ids.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        if (ids == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            for (String str : ids) {
                if (str == null) {
                    supportSQLiteStatementCompileStatement.bindNull(i);
                } else {
                    supportSQLiteStatementCompileStatement.bindString(i, str);
                }
                i++;
            }
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public List<CourseDataTable> getcoursedatafilterforfree2(final SupportSQLiteQuery query) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, query, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(__entityCursorConverter_comAppnewAndroidTableCourseDataTable(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.appnew.android.Dao.CourseDataDao
    public List<CourseDataTable> getcoursedatafilterforpaid2(final SupportSQLiteQuery query) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, query, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(__entityCursorConverter_comAppnewAndroidTableCourseDataTable(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    private CourseDataTable __entityCursorConverter_comAppnewAndroidTableCourseDataTable(final Cursor cursor) {
        int columnIndex = CursorUtil.getColumnIndex(cursor, "autoid");
        int columnIndex2 = CursorUtil.getColumnIndex(cursor, "userid");
        int columnIndex3 = CursorUtil.getColumnIndex(cursor, "cat_type");
        int columnIndex4 = CursorUtil.getColumnIndex(cursor, "mainid");
        int columnIndex5 = CursorUtil.getColumnIndex(cursor, Const.CATEGORY);
        int columnIndex6 = CursorUtil.getColumnIndex(cursor, "courseid");
        int columnIndex7 = CursorUtil.getColumnIndex(cursor, "title");
        int columnIndex8 = CursorUtil.getColumnIndex(cursor, "cover_image");
        int columnIndex9 = CursorUtil.getColumnIndex(cursor, "desc_header_image");
        int columnIndex10 = CursorUtil.getColumnIndex(cursor, "mrp");
        int columnIndex11 = CursorUtil.getColumnIndex(cursor, "payment_mode");
        int columnIndex12 = CursorUtil.getColumnIndex(cursor, "course_sp");
        int columnIndex13 = CursorUtil.getColumnIndex(cursor, Const.SUBJECT_ID);
        int columnIndex14 = CursorUtil.getColumnIndex(cursor, "avg_rating");
        int columnIndex15 = CursorUtil.getColumnIndex(cursor, "user_rated");
        int columnIndex16 = CursorUtil.getColumnIndex(cursor, "is_purchased");
        int columnIndex17 = CursorUtil.getColumnIndex(cursor, "content_type");
        int columnIndex18 = CursorUtil.getColumnIndex(cursor, "lang_id");
        int columnIndex19 = CursorUtil.getColumnIndex(cursor, "extra_json");
        int columnIndex20 = CursorUtil.getColumnIndex(cursor, "validity");
        int columnIndex21 = CursorUtil.getColumnIndex(cursor, "type_id");
        int columnIndex22 = CursorUtil.getColumnIndex(cursor, "combo_course_ids");
        int columnIndex23 = CursorUtil.getColumnIndex(cursor, "viewType");
        int columnIndex24 = CursorUtil.getColumnIndex(cursor, "valid_to");
        int columnIndex25 = CursorUtil.getColumnIndex(cursor, "hide_validity");
        int columnIndex26 = CursorUtil.getColumnIndex(cursor, "discount");
        int columnIndex27 = CursorUtil.getColumnIndex(cursor, "cart_quantity");
        int columnIndex28 = CursorUtil.getColumnIndex(cursor, "stocks");
        int columnIndex29 = CursorUtil.getColumnIndex(cursor, Const.DELIVERY_CHARGE);
        int columnIndex30 = CursorUtil.getColumnIndex(cursor, "delivery_charge_out_of_india");
        int columnIndex31 = CursorUtil.getColumnIndex(cursor, "description");
        int columnIndex32 = CursorUtil.getColumnIndex(cursor, "book_redirection_link");
        CourseDataTable courseDataTable = new CourseDataTable();
        if (columnIndex != -1) {
            courseDataTable.setAutoid(cursor.getInt(columnIndex));
        }
        if (columnIndex2 != -1) {
            courseDataTable.setUser_id(cursor.isNull(columnIndex2) ? null : cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            courseDataTable.setCat_type(cursor.isNull(columnIndex3) ? null : cursor.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            courseDataTable.setMain_id(cursor.isNull(columnIndex4) ? null : cursor.getString(columnIndex4));
        }
        if (columnIndex5 != -1) {
            courseDataTable.setCategory(cursor.isNull(columnIndex5) ? null : cursor.getString(columnIndex5));
        }
        if (columnIndex6 != -1) {
            courseDataTable.setCourse_id(cursor.isNull(columnIndex6) ? null : cursor.getString(columnIndex6));
        }
        if (columnIndex7 != -1) {
            courseDataTable.setTitle(cursor.isNull(columnIndex7) ? null : cursor.getString(columnIndex7));
        }
        if (columnIndex8 != -1) {
            courseDataTable.setCover_image(cursor.isNull(columnIndex8) ? null : cursor.getString(columnIndex8));
        }
        if (columnIndex9 != -1) {
            courseDataTable.setDesc_header_image(cursor.isNull(columnIndex9) ? null : cursor.getString(columnIndex9));
        }
        if (columnIndex10 != -1) {
            courseDataTable.setMrp(cursor.isNull(columnIndex10) ? null : cursor.getString(columnIndex10));
        }
        if (columnIndex11 != -1) {
            courseDataTable.setPayment_mode(cursor.isNull(columnIndex11) ? null : cursor.getString(columnIndex11));
        }
        if (columnIndex12 != -1) {
            courseDataTable.setCourse_sp(cursor.isNull(columnIndex12) ? null : cursor.getString(columnIndex12));
        }
        if (columnIndex13 != -1) {
            courseDataTable.setSubject_id(cursor.isNull(columnIndex13) ? null : cursor.getString(columnIndex13));
        }
        if (columnIndex14 != -1) {
            courseDataTable.setAvg_rating(cursor.isNull(columnIndex14) ? null : cursor.getString(columnIndex14));
        }
        if (columnIndex15 != -1) {
            courseDataTable.setUser_rated(cursor.isNull(columnIndex15) ? null : cursor.getString(columnIndex15));
        }
        if (columnIndex16 != -1) {
            courseDataTable.setIs_purchased(cursor.isNull(columnIndex16) ? null : cursor.getString(columnIndex16));
        }
        if (columnIndex17 != -1) {
            courseDataTable.setContent_type(cursor.isNull(columnIndex17) ? null : cursor.getString(columnIndex17));
        }
        if (columnIndex18 != -1) {
            courseDataTable.setLang_id(cursor.isNull(columnIndex18) ? null : cursor.getString(columnIndex18));
        }
        if (columnIndex19 != -1) {
            courseDataTable.setExtra_json(this.__sourceTypeConverter.toSource(cursor.isNull(columnIndex19) ? null : cursor.getString(columnIndex19)));
        }
        if (columnIndex20 != -1) {
            courseDataTable.setValidity(cursor.isNull(columnIndex20) ? null : cursor.getString(columnIndex20));
        }
        if (columnIndex21 != -1) {
            courseDataTable.setType_id(cursor.isNull(columnIndex21) ? null : cursor.getString(columnIndex21));
        }
        if (columnIndex22 != -1) {
            courseDataTable.setCombo_course_ids(cursor.isNull(columnIndex22) ? null : cursor.getString(columnIndex22));
        }
        if (columnIndex23 != -1) {
            courseDataTable.setViewType(cursor.isNull(columnIndex23) ? null : cursor.getString(columnIndex23));
        }
        if (columnIndex24 != -1) {
            courseDataTable.setValid_to(cursor.isNull(columnIndex24) ? null : cursor.getString(columnIndex24));
        }
        if (columnIndex25 != -1) {
            courseDataTable.setHide_validity(cursor.isNull(columnIndex25) ? null : cursor.getString(columnIndex25));
        }
        if (columnIndex26 != -1) {
            courseDataTable.setDiscount(cursor.isNull(columnIndex26) ? null : cursor.getString(columnIndex26));
        }
        if (columnIndex27 != -1) {
            courseDataTable.setCart_quantity(cursor.isNull(columnIndex27) ? null : cursor.getString(columnIndex27));
        }
        if (columnIndex28 != -1) {
            courseDataTable.setStocks(cursor.isNull(columnIndex28) ? null : cursor.getString(columnIndex28));
        }
        if (columnIndex29 != -1) {
            courseDataTable.setDelivery_charge(cursor.isNull(columnIndex29) ? null : cursor.getString(columnIndex29));
        }
        if (columnIndex30 != -1) {
            courseDataTable.setDelivery_charge_out_of_india(cursor.isNull(columnIndex30) ? null : cursor.getString(columnIndex30));
        }
        if (columnIndex31 != -1) {
            courseDataTable.setDescription(cursor.isNull(columnIndex31) ? null : cursor.getString(columnIndex31));
        }
        if (columnIndex32 != -1) {
            courseDataTable.setBook_redirection_link(cursor.isNull(columnIndex32) ? null : cursor.getString(columnIndex32));
        }
        return courseDataTable;
    }
}
