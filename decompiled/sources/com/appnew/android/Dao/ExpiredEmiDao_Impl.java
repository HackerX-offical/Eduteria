package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.Model.ExpiredEmiModel;
import com.appnew.android.TypeConverter.Converters;
import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ExpiredEmiDao_Impl implements ExpiredEmiDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ExpiredEmiModel> __insertionAdapterOfExpiredEmiModel;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecord;

    public ExpiredEmiDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfExpiredEmiModel = new EntityInsertionAdapter<ExpiredEmiModel>(__db) { // from class: com.appnew.android.Dao.ExpiredEmiDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `ExpiredEMI` (`auto_id`,`id`,`txn_id`,`viewType`,`holderType`,`maintenanceText`,`title`,`segment_information`,`courseAttribute`,`cover_image`,`descHeaderImage`,`mrp`,`courseSp`,`colorCode`,`validity`,`avg_rating`,`user_rated`,`learner`,`is_activated`,`is_subscription`,`check_for_expiry`,`isLive`,`is_locked`,`home_screen`,`isExpand`,`lastread`,`skipUnit`,`skipChapter`,`combo_course_ids`,`payment_type`,`is_postal_available`,`expiry_date`,`purchase_date`,`url`,`prices`,`batch_id`,`subject_id`,`lang_id`,`type_id`,`delete`,`payment_mode`,`emi_payment`,`subscription_code`,`isSelect`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ExpiredEmiModel expiredEmiModel) {
                supportSQLiteStatement.bindLong(1, expiredEmiModel.getAuto_id());
                if (expiredEmiModel.getId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, expiredEmiModel.getId());
                }
                if (expiredEmiModel.getTxn_id() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, expiredEmiModel.getTxn_id());
                }
                if (expiredEmiModel.getViewType() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, expiredEmiModel.getViewType());
                }
                if (expiredEmiModel.getHolderType() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, expiredEmiModel.getHolderType());
                }
                if (expiredEmiModel.getMaintenanceText() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, expiredEmiModel.getMaintenanceText());
                }
                if (expiredEmiModel.getTitle() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, expiredEmiModel.getTitle());
                }
                if (expiredEmiModel.getSegment_information() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, expiredEmiModel.getSegment_information());
                }
                if (expiredEmiModel.getCourseAttribute() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, expiredEmiModel.getCourseAttribute());
                }
                if (expiredEmiModel.getCover_image() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, expiredEmiModel.getCover_image());
                }
                if (expiredEmiModel.getDescHeaderImage() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, expiredEmiModel.getDescHeaderImage());
                }
                if (expiredEmiModel.getMrp() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, expiredEmiModel.getMrp());
                }
                if (expiredEmiModel.getCourseSp() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, expiredEmiModel.getCourseSp());
                }
                if (expiredEmiModel.getColorCode() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, expiredEmiModel.getColorCode());
                }
                if (expiredEmiModel.getValidity() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, expiredEmiModel.getValidity());
                }
                if (expiredEmiModel.getAvg_rating() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, expiredEmiModel.getAvg_rating());
                }
                if (expiredEmiModel.getUser_rated() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, expiredEmiModel.getUser_rated());
                }
                if (expiredEmiModel.getLearner() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, expiredEmiModel.getLearner());
                }
                if (expiredEmiModel.getIs_activated() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, expiredEmiModel.getIs_activated());
                }
                if (expiredEmiModel.getIs_subscription() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, expiredEmiModel.getIs_subscription());
                }
                if (expiredEmiModel.getCheck_for_expiry() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, expiredEmiModel.getCheck_for_expiry());
                }
                if (expiredEmiModel.getIsLive() == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, expiredEmiModel.getIsLive());
                }
                if (expiredEmiModel.getIs_locked() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, expiredEmiModel.getIs_locked());
                }
                if (expiredEmiModel.getHome_screen() == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindString(24, expiredEmiModel.getHome_screen());
                }
                supportSQLiteStatement.bindLong(25, expiredEmiModel.isExpand() ? 1L : 0L);
                if (expiredEmiModel.getLastread() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindString(26, expiredEmiModel.getLastread());
                }
                if (expiredEmiModel.getSkipUnit() == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindString(27, expiredEmiModel.getSkipUnit());
                }
                if (expiredEmiModel.getSkipChapter() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, expiredEmiModel.getSkipChapter());
                }
                if (expiredEmiModel.getCombo_course_ids() == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindString(29, expiredEmiModel.getCombo_course_ids());
                }
                if (expiredEmiModel.getPayment_type() == null) {
                    supportSQLiteStatement.bindNull(30);
                } else {
                    supportSQLiteStatement.bindString(30, expiredEmiModel.getPayment_type());
                }
                if (expiredEmiModel.getIs_postal_available() == null) {
                    supportSQLiteStatement.bindNull(31);
                } else {
                    supportSQLiteStatement.bindString(31, expiredEmiModel.getIs_postal_available());
                }
                if (expiredEmiModel.getExpiry_date() == null) {
                    supportSQLiteStatement.bindNull(32);
                } else {
                    supportSQLiteStatement.bindString(32, expiredEmiModel.getExpiry_date());
                }
                if (expiredEmiModel.getPurchase_date() == null) {
                    supportSQLiteStatement.bindNull(33);
                } else {
                    supportSQLiteStatement.bindString(33, expiredEmiModel.getPurchase_date());
                }
                if (expiredEmiModel.getUrl() == null) {
                    supportSQLiteStatement.bindNull(34);
                } else {
                    supportSQLiteStatement.bindString(34, expiredEmiModel.getUrl());
                }
                String strFromArrayList = Converters.fromArrayList(expiredEmiModel.getPrices());
                if (strFromArrayList == null) {
                    supportSQLiteStatement.bindNull(35);
                } else {
                    supportSQLiteStatement.bindString(35, strFromArrayList);
                }
                if (expiredEmiModel.getBatch_id() == null) {
                    supportSQLiteStatement.bindNull(36);
                } else {
                    supportSQLiteStatement.bindString(36, expiredEmiModel.getBatch_id());
                }
                if (expiredEmiModel.getSubject_id() == null) {
                    supportSQLiteStatement.bindNull(37);
                } else {
                    supportSQLiteStatement.bindString(37, expiredEmiModel.getSubject_id());
                }
                if (expiredEmiModel.getLang_id() == null) {
                    supportSQLiteStatement.bindNull(38);
                } else {
                    supportSQLiteStatement.bindString(38, expiredEmiModel.getLang_id());
                }
                if (expiredEmiModel.getType_id() == null) {
                    supportSQLiteStatement.bindNull(39);
                } else {
                    supportSQLiteStatement.bindString(39, expiredEmiModel.getType_id());
                }
                supportSQLiteStatement.bindLong(40, expiredEmiModel.getDelete());
                if (expiredEmiModel.getPayment_mode() == null) {
                    supportSQLiteStatement.bindNull(41);
                } else {
                    supportSQLiteStatement.bindString(41, expiredEmiModel.getPayment_mode());
                }
                if (expiredEmiModel.getEmi_payment() == null) {
                    supportSQLiteStatement.bindNull(42);
                } else {
                    supportSQLiteStatement.bindString(42, expiredEmiModel.getEmi_payment());
                }
                if (expiredEmiModel.getSubscription_code() == null) {
                    supportSQLiteStatement.bindNull(43);
                } else {
                    supportSQLiteStatement.bindString(43, expiredEmiModel.getSubscription_code());
                }
                supportSQLiteStatement.bindLong(44, expiredEmiModel.isSelect() ? 1L : 0L);
            }
        };
        this.__preparedStmtOfDeleteRecord = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.ExpiredEmiDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM EXPIREDEMI WHERE id= ?";
            }
        };
    }

    @Override // com.appnew.android.Dao.ExpiredEmiDao
    public void addCancelledData(final ExpiredEmiModel courselist) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfExpiredEmiModel.insert(courselist);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.ExpiredEmiDao
    public void deleteRecord(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteRecord.acquire();
        if (id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, id);
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
            this.__preparedStmtOfDeleteRecord.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.ExpiredEmiDao
    public List<ExpiredEmiModel> getCancelledData() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        int i3;
        boolean z;
        int i4;
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
        int i5;
        String string25;
        String string26;
        String string27;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ExpiredEMI", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "txn_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "holderType");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maintenanceText");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "segment_information");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseAttribute");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "descHeaderImage");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseSp");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "colorCode");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avg_rating");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_rated");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "learner");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_activated");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_subscription");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "check_for_expiry");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLive");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_locked");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "home_screen");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExpand");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastread");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skipUnit");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skipChapter");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, FirebaseAnalytics.Param.PAYMENT_TYPE);
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_postal_available");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiry_date");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "purchase_date");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "url");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prices");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.BATCH_ID);
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.SUBJECT_ID);
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lang_id");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type_id");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payment_mode");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "emi_payment");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subscription_code");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelect");
                int i6 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    ExpiredEmiModel expiredEmiModel = new ExpiredEmiModel();
                    ArrayList arrayList2 = arrayList;
                    expiredEmiModel.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                    expiredEmiModel.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    expiredEmiModel.setTxn_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    expiredEmiModel.setViewType(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    expiredEmiModel.setHolderType(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    expiredEmiModel.setMaintenanceText(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    expiredEmiModel.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    expiredEmiModel.setSegment_information(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    expiredEmiModel.setCourseAttribute(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    expiredEmiModel.setCover_image(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    expiredEmiModel.setDescHeaderImage(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    expiredEmiModel.setMrp(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    expiredEmiModel.setCourseSp(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i7 = i6;
                    if (cursorQuery.isNull(i7)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(i7);
                    }
                    expiredEmiModel.setColorCode(string);
                    int i8 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i8)) {
                        i2 = i8;
                        string2 = null;
                    } else {
                        i2 = i8;
                        string2 = cursorQuery.getString(i8);
                    }
                    expiredEmiModel.setValidity(string2);
                    int i9 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow16 = i9;
                        string3 = null;
                    } else {
                        columnIndexOrThrow16 = i9;
                        string3 = cursorQuery.getString(i9);
                    }
                    expiredEmiModel.setAvg_rating(string3);
                    int i10 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i10)) {
                        columnIndexOrThrow17 = i10;
                        string4 = null;
                    } else {
                        columnIndexOrThrow17 = i10;
                        string4 = cursorQuery.getString(i10);
                    }
                    expiredEmiModel.setUser_rated(string4);
                    int i11 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i11)) {
                        columnIndexOrThrow18 = i11;
                        string5 = null;
                    } else {
                        columnIndexOrThrow18 = i11;
                        string5 = cursorQuery.getString(i11);
                    }
                    expiredEmiModel.setLearner(string5);
                    int i12 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow19 = i12;
                        string6 = null;
                    } else {
                        columnIndexOrThrow19 = i12;
                        string6 = cursorQuery.getString(i12);
                    }
                    expiredEmiModel.setIs_activated(string6);
                    int i13 = columnIndexOrThrow20;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow20 = i13;
                        string7 = null;
                    } else {
                        columnIndexOrThrow20 = i13;
                        string7 = cursorQuery.getString(i13);
                    }
                    expiredEmiModel.setIs_subscription(string7);
                    int i14 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow21 = i14;
                        string8 = null;
                    } else {
                        columnIndexOrThrow21 = i14;
                        string8 = cursorQuery.getString(i14);
                    }
                    expiredEmiModel.setCheck_for_expiry(string8);
                    int i15 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i15)) {
                        columnIndexOrThrow22 = i15;
                        string9 = null;
                    } else {
                        columnIndexOrThrow22 = i15;
                        string9 = cursorQuery.getString(i15);
                    }
                    expiredEmiModel.setIsLive(string9);
                    int i16 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i16)) {
                        columnIndexOrThrow23 = i16;
                        string10 = null;
                    } else {
                        columnIndexOrThrow23 = i16;
                        string10 = cursorQuery.getString(i16);
                    }
                    expiredEmiModel.setIs_locked(string10);
                    int i17 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow24 = i17;
                        string11 = null;
                    } else {
                        columnIndexOrThrow24 = i17;
                        string11 = cursorQuery.getString(i17);
                    }
                    expiredEmiModel.setHome_screen(string11);
                    int i18 = columnIndexOrThrow25;
                    if (cursorQuery.getInt(i18) != 0) {
                        i3 = i18;
                        z = true;
                    } else {
                        i3 = i18;
                        z = false;
                    }
                    expiredEmiModel.setExpand(z);
                    int i19 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i19)) {
                        i4 = i19;
                        string12 = null;
                    } else {
                        i4 = i19;
                        string12 = cursorQuery.getString(i19);
                    }
                    expiredEmiModel.setLastread(string12);
                    int i20 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i20)) {
                        columnIndexOrThrow27 = i20;
                        string13 = null;
                    } else {
                        columnIndexOrThrow27 = i20;
                        string13 = cursorQuery.getString(i20);
                    }
                    expiredEmiModel.setSkipUnit(string13);
                    int i21 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow28 = i21;
                        string14 = null;
                    } else {
                        columnIndexOrThrow28 = i21;
                        string14 = cursorQuery.getString(i21);
                    }
                    expiredEmiModel.setSkipChapter(string14);
                    int i22 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow29 = i22;
                        string15 = null;
                    } else {
                        columnIndexOrThrow29 = i22;
                        string15 = cursorQuery.getString(i22);
                    }
                    expiredEmiModel.setCombo_course_ids(string15);
                    int i23 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow30 = i23;
                        string16 = null;
                    } else {
                        columnIndexOrThrow30 = i23;
                        string16 = cursorQuery.getString(i23);
                    }
                    expiredEmiModel.setPayment_type(string16);
                    int i24 = columnIndexOrThrow31;
                    if (cursorQuery.isNull(i24)) {
                        columnIndexOrThrow31 = i24;
                        string17 = null;
                    } else {
                        columnIndexOrThrow31 = i24;
                        string17 = cursorQuery.getString(i24);
                    }
                    expiredEmiModel.setIs_postal_available(string17);
                    int i25 = columnIndexOrThrow32;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow32 = i25;
                        string18 = null;
                    } else {
                        columnIndexOrThrow32 = i25;
                        string18 = cursorQuery.getString(i25);
                    }
                    expiredEmiModel.setExpiry_date(string18);
                    int i26 = columnIndexOrThrow33;
                    if (cursorQuery.isNull(i26)) {
                        columnIndexOrThrow33 = i26;
                        string19 = null;
                    } else {
                        columnIndexOrThrow33 = i26;
                        string19 = cursorQuery.getString(i26);
                    }
                    expiredEmiModel.setPurchase_date(string19);
                    int i27 = columnIndexOrThrow34;
                    if (cursorQuery.isNull(i27)) {
                        columnIndexOrThrow34 = i27;
                        string20 = null;
                    } else {
                        columnIndexOrThrow34 = i27;
                        string20 = cursorQuery.getString(i27);
                    }
                    expiredEmiModel.setUrl(string20);
                    int i28 = columnIndexOrThrow35;
                    columnIndexOrThrow35 = i28;
                    expiredEmiModel.setPrices(Converters.fromString(cursorQuery.isNull(i28) ? null : cursorQuery.getString(i28)));
                    int i29 = columnIndexOrThrow36;
                    if (cursorQuery.isNull(i29)) {
                        columnIndexOrThrow36 = i29;
                        string21 = null;
                    } else {
                        columnIndexOrThrow36 = i29;
                        string21 = cursorQuery.getString(i29);
                    }
                    expiredEmiModel.setBatch_id(string21);
                    int i30 = columnIndexOrThrow37;
                    if (cursorQuery.isNull(i30)) {
                        columnIndexOrThrow37 = i30;
                        string22 = null;
                    } else {
                        columnIndexOrThrow37 = i30;
                        string22 = cursorQuery.getString(i30);
                    }
                    expiredEmiModel.setSubject_id(string22);
                    int i31 = columnIndexOrThrow38;
                    if (cursorQuery.isNull(i31)) {
                        columnIndexOrThrow38 = i31;
                        string23 = null;
                    } else {
                        columnIndexOrThrow38 = i31;
                        string23 = cursorQuery.getString(i31);
                    }
                    expiredEmiModel.setLang_id(string23);
                    int i32 = columnIndexOrThrow39;
                    if (cursorQuery.isNull(i32)) {
                        columnIndexOrThrow39 = i32;
                        string24 = null;
                    } else {
                        columnIndexOrThrow39 = i32;
                        string24 = cursorQuery.getString(i32);
                    }
                    expiredEmiModel.setType_id(string24);
                    int i33 = columnIndexOrThrow12;
                    int i34 = columnIndexOrThrow40;
                    expiredEmiModel.setDelete(cursorQuery.getInt(i34));
                    int i35 = columnIndexOrThrow41;
                    if (cursorQuery.isNull(i35)) {
                        i5 = i34;
                        string25 = null;
                    } else {
                        i5 = i34;
                        string25 = cursorQuery.getString(i35);
                    }
                    expiredEmiModel.setPayment_mode(string25);
                    int i36 = columnIndexOrThrow42;
                    if (cursorQuery.isNull(i36)) {
                        columnIndexOrThrow42 = i36;
                        string26 = null;
                    } else {
                        columnIndexOrThrow42 = i36;
                        string26 = cursorQuery.getString(i36);
                    }
                    expiredEmiModel.setEmi_payment(string26);
                    int i37 = columnIndexOrThrow43;
                    if (cursorQuery.isNull(i37)) {
                        columnIndexOrThrow43 = i37;
                        string27 = null;
                    } else {
                        columnIndexOrThrow43 = i37;
                        string27 = cursorQuery.getString(i37);
                    }
                    expiredEmiModel.setSubscription_code(string27);
                    int i38 = columnIndexOrThrow44;
                    columnIndexOrThrow44 = i38;
                    expiredEmiModel.setSelect(cursorQuery.getInt(i38) != 0);
                    arrayList2.add(expiredEmiModel);
                    columnIndexOrThrow25 = i3;
                    columnIndexOrThrow40 = i5;
                    columnIndexOrThrow15 = i2;
                    columnIndexOrThrow41 = i35;
                    i6 = i7;
                    columnIndexOrThrow12 = i33;
                    columnIndexOrThrow26 = i4;
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
