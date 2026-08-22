package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.CourseDetailTable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class CourseDetailDao_Impl implements CourseDetailDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<CourseDetailTable> __insertionAdapterOfCourseDetailTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletecoursedetail;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdaterecord;

    public CourseDetailDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfCourseDetailTable = new EntityInsertionAdapter<CourseDetailTable>(__db) { // from class: com.appnew.android.Dao.CourseDetailDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `CourseDetailTable` (`autoid`,`coursetitle`,`couseid`,`display_locked`,`tax`,`is_purchased`,`is_gst`,`course_code`,`content_type`,`validity`,`is_activated`,`token_activation`,`course_sp`,`userid`,`tileid`,`tiletitile`,`tilerevert`,`description`,`tilemeta`,`skip_payment`,`cat_type`,`delivery_charge`,`txnid`,`instalment`,`mrp`,`view_type`,`author_title`,`type`,`is_combo`,`desc_header_image`,`is_trial`,`last_paid_txn_id`,`is_rating`,`payment_mode`,`event_location`,`location`,`start_date`,`end_date`,`extra_json`,`cover_image`,`subscription_all_data`,`hide_validity`,`avg_rating`,`user_rated`,`stocks`,`external_coupon_off`,`transaction_status`,`combo_has_book`,`tax_rate`,`set_as_demo`,`thumbnail`,`book_redirection_link`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final CourseDetailTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getCourse_title() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getCourse_title());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getCourse_id());
                }
                if (entity.getDisplay_locked() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getDisplay_locked());
                }
                if (entity.getTax() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getTax());
                }
                if (entity.getIs_purchased() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getIs_purchased());
                }
                if (entity.getIs_gst() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getIs_gst());
                }
                if (entity.getCourse_code() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getCourse_code());
                }
                if (entity.getContent_type() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getContent_type());
                }
                if (entity.getValidity() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getValidity());
                }
                if (entity.getIs_activated() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getIs_activated());
                }
                if (entity.getToken_activation() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getToken_activation());
                }
                if (entity.getCourse_sp() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getCourse_sp());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getUser_id());
                }
                if (entity.getTile_id() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getTile_id());
                }
                if (entity.getTile_title() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getTile_title());
                }
                if (entity.getTile_revert() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getTile_revert());
                }
                if (entity.getDescription() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getDescription());
                }
                if (entity.getTile_meta() == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, entity.getTile_meta());
                }
                if (entity.getSkip_payment() == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, entity.getSkip_payment());
                }
                if (entity.getCat_type() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getCat_type());
                }
                if (entity.getDelivery_charge() == null) {
                    statement.bindNull(22);
                } else {
                    statement.bindString(22, entity.getDelivery_charge());
                }
                if (entity.getTxn_id() == null) {
                    statement.bindNull(23);
                } else {
                    statement.bindString(23, entity.getTxn_id());
                }
                if (entity.getInstallment() == null) {
                    statement.bindNull(24);
                } else {
                    statement.bindString(24, entity.getInstallment());
                }
                if (entity.getMrp() == null) {
                    statement.bindNull(25);
                } else {
                    statement.bindString(25, entity.getMrp());
                }
                if (entity.getView_type() == null) {
                    statement.bindNull(26);
                } else {
                    statement.bindString(26, entity.getView_type());
                }
                if (entity.getAuthor_title() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getAuthor_title());
                }
                if (entity.getType() == null) {
                    statement.bindNull(28);
                } else {
                    statement.bindString(28, entity.getType());
                }
                if (entity.getIs_combo() == null) {
                    statement.bindNull(29);
                } else {
                    statement.bindString(29, entity.getIs_combo());
                }
                if (entity.getDesc_header_image() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getDesc_header_image());
                }
                if (entity.getIs_trial() == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, entity.getIs_trial());
                }
                if (entity.getLast_paid_txn_id() == null) {
                    statement.bindNull(32);
                } else {
                    statement.bindString(32, entity.getLast_paid_txn_id());
                }
                if (entity.getIs_rating() == null) {
                    statement.bindNull(33);
                } else {
                    statement.bindString(33, entity.getIs_rating());
                }
                if (entity.getPayment_mode() == null) {
                    statement.bindNull(34);
                } else {
                    statement.bindString(34, entity.getPayment_mode());
                }
                if (entity.getEvent_location() == null) {
                    statement.bindNull(35);
                } else {
                    statement.bindString(35, entity.getEvent_location());
                }
                if (entity.getLocation() == null) {
                    statement.bindNull(36);
                } else {
                    statement.bindString(36, entity.getLocation());
                }
                if (entity.getStart_date() == null) {
                    statement.bindNull(37);
                } else {
                    statement.bindString(37, entity.getStart_date());
                }
                if (entity.getEnd_date() == null) {
                    statement.bindNull(38);
                } else {
                    statement.bindString(38, entity.getEnd_date());
                }
                if (entity.getExtra_json() == null) {
                    statement.bindNull(39);
                } else {
                    statement.bindString(39, entity.getExtra_json());
                }
                if (entity.getCover_image() == null) {
                    statement.bindNull(40);
                } else {
                    statement.bindString(40, entity.getCover_image());
                }
                if (entity.getSubscription_all_data() == null) {
                    statement.bindNull(41);
                } else {
                    statement.bindString(41, entity.getSubscription_all_data());
                }
                if (entity.getHide_validity() == null) {
                    statement.bindNull(42);
                } else {
                    statement.bindString(42, entity.getHide_validity());
                }
                if (entity.getAvg_rating() == null) {
                    statement.bindNull(43);
                } else {
                    statement.bindString(43, entity.getAvg_rating());
                }
                if (entity.getUser_rated() == null) {
                    statement.bindNull(44);
                } else {
                    statement.bindString(44, entity.getUser_rated());
                }
                if (entity.getStocks() == null) {
                    statement.bindNull(45);
                } else {
                    statement.bindString(45, entity.getStocks());
                }
                if (entity.getExternal_coupon_off() == null) {
                    statement.bindNull(46);
                } else {
                    statement.bindString(46, entity.getExternal_coupon_off());
                }
                if (entity.getTransaction_status() == null) {
                    statement.bindNull(47);
                } else {
                    statement.bindString(47, entity.getTransaction_status());
                }
                if (entity.getCombo_has_book() == null) {
                    statement.bindNull(48);
                } else {
                    statement.bindString(48, entity.getCombo_has_book());
                }
                if (entity.getTax_rate() == null) {
                    statement.bindNull(49);
                } else {
                    statement.bindString(49, entity.getTax_rate());
                }
                if (entity.getSet_as_demo() == null) {
                    statement.bindNull(50);
                } else {
                    statement.bindString(50, entity.getSet_as_demo());
                }
                if (entity.getThumbnail() == null) {
                    statement.bindNull(51);
                } else {
                    statement.bindString(51, entity.getThumbnail());
                }
                if (entity.getBook_redirection_link() == null) {
                    statement.bindNull(52);
                } else {
                    statement.bindString(52, entity.getBook_redirection_link());
                }
            }
        };
        this.__preparedStmtOfDeletecoursedetail = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CourseDetailDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete  FROM CourseDetailTable  WHERE couseid LIKE '%' || ? AND userid =?";
            }
        };
        this.__preparedStmtOfUpdaterecord = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CourseDetailDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE CourseDetailTable SET is_activated=? WHERE couseid LIKE '%' || ? AND userid =?";
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.CourseDetailDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM CourseDetailTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.CourseDetailDao
    public long addCoursedetail(final CourseDetailTable coursedetail) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfCourseDetailTable.insertAndReturnId(coursedetail);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.CourseDetailDao
    public int deletecoursedetail(final String courseid, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeletecoursedetail.acquire();
        if (courseid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, courseid);
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
            this.__preparedStmtOfDeletecoursedetail.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.CourseDetailDao
    public int updaterecord(final String courseid, final String userid, final String is_activate) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdaterecord.acquire();
        if (is_activate == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, is_activate);
        }
        if (courseid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, courseid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
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

    @Override // com.appnew.android.Dao.CourseDetailDao
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

    @Override // com.appnew.android.Dao.CourseDetailDao
    public boolean isRecordExistsUserId(final String userid, final String course_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM CourseDetailTable WHERE couseid LIKE '%' || ? AND userid = ?)", 2);
        if (course_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, course_id);
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

    @Override // com.appnew.android.Dao.CourseDetailDao
    public List<CourseDetailTable> getcoursedetail(final String courseid, final String userid) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        String string2;
        int i2;
        String string3;
        String string4;
        String string5;
        String string6;
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
        String string19;
        String string20;
        String string21;
        String string22;
        String string23;
        String string24;
        String string25;
        String string26;
        String string27;
        String string28;
        String string29;
        String string30;
        String string31;
        String string32;
        String string33;
        String string34;
        String string35;
        String string36;
        String string37;
        String string38;
        String string39;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM CourseDetailTable  WHERE couseid = ? AND userid =?", 2);
        if (courseid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, courseid);
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
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "coursetitle");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "couseid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_locked");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tax");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_purchased");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_gst");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_code");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_activated");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "token_activation");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_sp");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tileid");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tiletitile");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tilerevert");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "description");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tilemeta");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skip_payment");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.DELIVERY_CHARGE);
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "txnid");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "instalment");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_type");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author_title");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.IS_COMBO);
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "desc_header_image");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_trial");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_paid_txn_id");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.IS_RATING);
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payment_mode");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "event_location");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "location");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.START_DATE);
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.END_DATE);
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra_json");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subscription_all_data");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hide_validity");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avg_rating");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_rated");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stocks");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "external_coupon_off");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.TRANSACTION_STATUS);
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_has_book");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tax_rate");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "set_as_demo");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_redirection_link");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    CourseDetailTable courseDetailTable = new CourseDetailTable();
                    ArrayList arrayList2 = arrayList;
                    courseDetailTable.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    courseDetailTable.setCourse_title(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    courseDetailTable.setCourse_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    courseDetailTable.setDisplay_locked(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    courseDetailTable.setTax(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    courseDetailTable.setIs_purchased(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    courseDetailTable.setIs_gst(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    courseDetailTable.setCourse_code(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    courseDetailTable.setContent_type(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    courseDetailTable.setValidity(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    courseDetailTable.setIs_activated(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    courseDetailTable.setToken_activation(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    courseDetailTable.setCourse_sp(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    if (cursorQuery.isNull(i4)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(i4);
                    }
                    courseDetailTable.setUser_id(string);
                    int i5 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i5)) {
                        columnIndexOrThrow15 = i5;
                        string2 = null;
                    } else {
                        columnIndexOrThrow15 = i5;
                        string2 = cursorQuery.getString(i5);
                    }
                    courseDetailTable.setTile_id(string2);
                    int i6 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i6)) {
                        i2 = i6;
                        string3 = null;
                    } else {
                        i2 = i6;
                        string3 = cursorQuery.getString(i6);
                    }
                    courseDetailTable.setTile_title(string3);
                    int i7 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow17 = i7;
                        string4 = null;
                    } else {
                        columnIndexOrThrow17 = i7;
                        string4 = cursorQuery.getString(i7);
                    }
                    courseDetailTable.setTile_revert(string4);
                    int i8 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow18 = i8;
                        string5 = null;
                    } else {
                        columnIndexOrThrow18 = i8;
                        string5 = cursorQuery.getString(i8);
                    }
                    courseDetailTable.setDescription(string5);
                    int i9 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow19 = i9;
                        string6 = null;
                    } else {
                        columnIndexOrThrow19 = i9;
                        string6 = cursorQuery.getString(i9);
                    }
                    courseDetailTable.setTile_meta(string6);
                    int i10 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow20 = i10;
                        string7 = null;
                    } else {
                        columnIndexOrThrow20 = i10;
                        string7 = cursorQuery.getString(i10);
                    }
                    courseDetailTable.setSkip_payment(string7);
                    int i11 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow21 = i11;
                        string8 = null;
                    } else {
                        columnIndexOrThrow21 = i11;
                        string8 = cursorQuery.getString(i11);
                    }
                    courseDetailTable.setCat_type(string8);
                    int i12 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow22 = i12;
                        string9 = null;
                    } else {
                        columnIndexOrThrow22 = i12;
                        string9 = cursorQuery.getString(i12);
                    }
                    courseDetailTable.setDelivery_charge(string9);
                    int i13 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow23 = i13;
                        string10 = null;
                    } else {
                        columnIndexOrThrow23 = i13;
                        string10 = cursorQuery.getString(i13);
                    }
                    courseDetailTable.setTxn_id(string10);
                    int i14 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow24 = i14;
                        string11 = null;
                    } else {
                        columnIndexOrThrow24 = i14;
                        string11 = cursorQuery.getString(i14);
                    }
                    courseDetailTable.setInstallment(string11);
                    int i15 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i15)) {
                        columnIndexOrThrow25 = i15;
                        string12 = null;
                    } else {
                        columnIndexOrThrow25 = i15;
                        string12 = cursorQuery.getString(i15);
                    }
                    courseDetailTable.setMrp(string12);
                    int i16 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i16)) {
                        columnIndexOrThrow26 = i16;
                        string13 = null;
                    } else {
                        columnIndexOrThrow26 = i16;
                        string13 = cursorQuery.getString(i16);
                    }
                    courseDetailTable.setView_type(string13);
                    int i17 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow27 = i17;
                        string14 = null;
                    } else {
                        columnIndexOrThrow27 = i17;
                        string14 = cursorQuery.getString(i17);
                    }
                    courseDetailTable.setAuthor_title(string14);
                    int i18 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow28 = i18;
                        string15 = null;
                    } else {
                        columnIndexOrThrow28 = i18;
                        string15 = cursorQuery.getString(i18);
                    }
                    courseDetailTable.setType(string15);
                    int i19 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow29 = i19;
                        string16 = null;
                    } else {
                        columnIndexOrThrow29 = i19;
                        string16 = cursorQuery.getString(i19);
                    }
                    courseDetailTable.setIs_combo(string16);
                    int i20 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow30 = i20;
                        string17 = null;
                    } else {
                        columnIndexOrThrow30 = i20;
                        string17 = cursorQuery.getString(i20);
                    }
                    courseDetailTable.setDesc_header_image(string17);
                    int i21 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow31 = i21;
                        string18 = null;
                    } else {
                        columnIndexOrThrow31 = i21;
                        string18 = cursorQuery.getString(i21);
                    }
                    courseDetailTable.setIs_trial(string18);
                    int i22 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow32 = i22;
                        string19 = null;
                    } else {
                        columnIndexOrThrow32 = i22;
                        string19 = cursorQuery.getString(i22);
                    }
                    courseDetailTable.setLast_paid_txn_id(string19);
                    int i23 = columnIndexOrThrow33;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow33 = i23;
                        string20 = null;
                    } else {
                        columnIndexOrThrow33 = i23;
                        string20 = cursorQuery.getString(i23);
                    }
                    courseDetailTable.setIs_rating(string20);
                    int i24 = columnIndexOrThrow34;
                    if (cursorQuery.isNull(i24)) {
                        columnIndexOrThrow34 = i24;
                        string21 = null;
                    } else {
                        columnIndexOrThrow34 = i24;
                        string21 = cursorQuery.getString(i24);
                    }
                    courseDetailTable.setPayment_mode(string21);
                    int i25 = columnIndexOrThrow35;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow35 = i25;
                        string22 = null;
                    } else {
                        columnIndexOrThrow35 = i25;
                        string22 = cursorQuery.getString(i25);
                    }
                    courseDetailTable.setEvent_location(string22);
                    int i26 = columnIndexOrThrow36;
                    if (cursorQuery.isNull(i26)) {
                        columnIndexOrThrow36 = i26;
                        string23 = null;
                    } else {
                        columnIndexOrThrow36 = i26;
                        string23 = cursorQuery.getString(i26);
                    }
                    courseDetailTable.setLocation(string23);
                    int i27 = columnIndexOrThrow37;
                    if (cursorQuery.isNull(i27)) {
                        columnIndexOrThrow37 = i27;
                        string24 = null;
                    } else {
                        columnIndexOrThrow37 = i27;
                        string24 = cursorQuery.getString(i27);
                    }
                    courseDetailTable.setStart_date(string24);
                    int i28 = columnIndexOrThrow38;
                    if (cursorQuery.isNull(i28)) {
                        columnIndexOrThrow38 = i28;
                        string25 = null;
                    } else {
                        columnIndexOrThrow38 = i28;
                        string25 = cursorQuery.getString(i28);
                    }
                    courseDetailTable.setEnd_date(string25);
                    int i29 = columnIndexOrThrow39;
                    if (cursorQuery.isNull(i29)) {
                        columnIndexOrThrow39 = i29;
                        string26 = null;
                    } else {
                        columnIndexOrThrow39 = i29;
                        string26 = cursorQuery.getString(i29);
                    }
                    courseDetailTable.setExtra_json(string26);
                    int i30 = columnIndexOrThrow40;
                    if (cursorQuery.isNull(i30)) {
                        columnIndexOrThrow40 = i30;
                        string27 = null;
                    } else {
                        columnIndexOrThrow40 = i30;
                        string27 = cursorQuery.getString(i30);
                    }
                    courseDetailTable.setCover_image(string27);
                    int i31 = columnIndexOrThrow41;
                    if (cursorQuery.isNull(i31)) {
                        columnIndexOrThrow41 = i31;
                        string28 = null;
                    } else {
                        columnIndexOrThrow41 = i31;
                        string28 = cursorQuery.getString(i31);
                    }
                    courseDetailTable.setSubscription_all_data(string28);
                    int i32 = columnIndexOrThrow42;
                    if (cursorQuery.isNull(i32)) {
                        columnIndexOrThrow42 = i32;
                        string29 = null;
                    } else {
                        columnIndexOrThrow42 = i32;
                        string29 = cursorQuery.getString(i32);
                    }
                    courseDetailTable.setHide_validity(string29);
                    int i33 = columnIndexOrThrow43;
                    if (cursorQuery.isNull(i33)) {
                        columnIndexOrThrow43 = i33;
                        string30 = null;
                    } else {
                        columnIndexOrThrow43 = i33;
                        string30 = cursorQuery.getString(i33);
                    }
                    courseDetailTable.setAvg_rating(string30);
                    int i34 = columnIndexOrThrow44;
                    if (cursorQuery.isNull(i34)) {
                        columnIndexOrThrow44 = i34;
                        string31 = null;
                    } else {
                        columnIndexOrThrow44 = i34;
                        string31 = cursorQuery.getString(i34);
                    }
                    courseDetailTable.setUser_rated(string31);
                    int i35 = columnIndexOrThrow45;
                    if (cursorQuery.isNull(i35)) {
                        columnIndexOrThrow45 = i35;
                        string32 = null;
                    } else {
                        columnIndexOrThrow45 = i35;
                        string32 = cursorQuery.getString(i35);
                    }
                    courseDetailTable.setStocks(string32);
                    int i36 = columnIndexOrThrow46;
                    if (cursorQuery.isNull(i36)) {
                        columnIndexOrThrow46 = i36;
                        string33 = null;
                    } else {
                        columnIndexOrThrow46 = i36;
                        string33 = cursorQuery.getString(i36);
                    }
                    courseDetailTable.setExternal_coupon_off(string33);
                    int i37 = columnIndexOrThrow47;
                    if (cursorQuery.isNull(i37)) {
                        columnIndexOrThrow47 = i37;
                        string34 = null;
                    } else {
                        columnIndexOrThrow47 = i37;
                        string34 = cursorQuery.getString(i37);
                    }
                    courseDetailTable.setTransaction_status(string34);
                    int i38 = columnIndexOrThrow48;
                    if (cursorQuery.isNull(i38)) {
                        columnIndexOrThrow48 = i38;
                        string35 = null;
                    } else {
                        columnIndexOrThrow48 = i38;
                        string35 = cursorQuery.getString(i38);
                    }
                    courseDetailTable.setCombo_has_book(string35);
                    int i39 = columnIndexOrThrow49;
                    if (cursorQuery.isNull(i39)) {
                        columnIndexOrThrow49 = i39;
                        string36 = null;
                    } else {
                        columnIndexOrThrow49 = i39;
                        string36 = cursorQuery.getString(i39);
                    }
                    courseDetailTable.setTax_rate(string36);
                    int i40 = columnIndexOrThrow50;
                    if (cursorQuery.isNull(i40)) {
                        columnIndexOrThrow50 = i40;
                        string37 = null;
                    } else {
                        columnIndexOrThrow50 = i40;
                        string37 = cursorQuery.getString(i40);
                    }
                    courseDetailTable.setSet_as_demo(string37);
                    int i41 = columnIndexOrThrow51;
                    if (cursorQuery.isNull(i41)) {
                        columnIndexOrThrow51 = i41;
                        string38 = null;
                    } else {
                        columnIndexOrThrow51 = i41;
                        string38 = cursorQuery.getString(i41);
                    }
                    courseDetailTable.setThumbnail(string38);
                    int i42 = columnIndexOrThrow52;
                    if (cursorQuery.isNull(i42)) {
                        columnIndexOrThrow52 = i42;
                        string39 = null;
                    } else {
                        columnIndexOrThrow52 = i42;
                        string39 = cursorQuery.getString(i42);
                    }
                    courseDetailTable.setBook_redirection_link(string39);
                    arrayList2.add(courseDetailTable);
                    columnIndexOrThrow16 = i2;
                    i3 = i4;
                    arrayList = arrayList2;
                    columnIndexOrThrow = i;
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
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
