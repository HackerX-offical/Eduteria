package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.Model.DueEmiTable;
import com.appnew.android.TypeConverter.Converters;
import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class DueEmiDao_Impl implements DueEmiDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<DueEmiTable> __insertionAdapterOfDueEmiTable;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllDueEmi;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecord;

    public DueEmiDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDueEmiTable = new EntityInsertionAdapter<DueEmiTable>(__db) { // from class: com.appnew.android.Dao.DueEmiDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `DueEmiTable` (`auto_id`,`id`,`txn_id`,`viewType`,`holderType`,`maintenanceText`,`title`,`segment_information`,`courseAttribute`,`isSelect`,`isExpand`,`cover_image`,`descHeaderImage`,`mrp`,`courseSp`,`colorCode`,`validity`,`avg_rating`,`user_rated`,`learner`,`is_activated`,`check_for_expiry`,`isLive`,`is_locked`,`home_screen`,`lastread`,`skipUnit`,`skipChapter`,`combo_course_ids`,`payment_type`,`is_postal_available`,`expiry_date`,`purchase_date`,`url`,`prices`,`batch_id`,`subject_id`,`lang_id`,`type_id`,`delete`,`payment_mode`,`emi_payment`,`subscription_code`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final DueEmiTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                if (entity.getTxn_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getTxn_id());
                }
                if (entity.getViewType() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getViewType());
                }
                if (entity.getHolderType() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getHolderType());
                }
                if (entity.getMaintenanceText() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getMaintenanceText());
                }
                if (entity.getTitle() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getTitle());
                }
                if (entity.getSegment_information() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getSegment_information());
                }
                if (entity.getCourseAttribute() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCourseAttribute());
                }
                if (entity.getIsSelect() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getIsSelect());
                }
                if (entity.getIsExpand() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getIsExpand());
                }
                if (entity.getCover_image() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getCover_image());
                }
                if (entity.getDescHeaderImage() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getDescHeaderImage());
                }
                if (entity.getMrp() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getMrp());
                }
                if (entity.getCourseSp() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getCourseSp());
                }
                if (entity.getColorCode() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getColorCode());
                }
                if (entity.getValidity() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getValidity());
                }
                if (entity.getAvg_rating() == null) {
                    statement.bindNull(18);
                } else {
                    statement.bindString(18, entity.getAvg_rating());
                }
                if (entity.getUser_rated() == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, entity.getUser_rated());
                }
                if (entity.getLearner() == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, entity.getLearner());
                }
                if (entity.getIs_activated() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getIs_activated());
                }
                if (entity.getCheck_for_expiry() == null) {
                    statement.bindNull(22);
                } else {
                    statement.bindString(22, entity.getCheck_for_expiry());
                }
                if (entity.getIsLive() == null) {
                    statement.bindNull(23);
                } else {
                    statement.bindString(23, entity.getIsLive());
                }
                if (entity.getIs_locked() == null) {
                    statement.bindNull(24);
                } else {
                    statement.bindString(24, entity.getIs_locked());
                }
                if (entity.getHome_screen() == null) {
                    statement.bindNull(25);
                } else {
                    statement.bindString(25, entity.getHome_screen());
                }
                if (entity.getLastread() == null) {
                    statement.bindNull(26);
                } else {
                    statement.bindString(26, entity.getLastread());
                }
                if (entity.getSkipUnit() == null) {
                    statement.bindNull(27);
                } else {
                    statement.bindString(27, entity.getSkipUnit());
                }
                if (entity.getSkipChapter() == null) {
                    statement.bindNull(28);
                } else {
                    statement.bindString(28, entity.getSkipChapter());
                }
                if (entity.getCombo_course_ids() == null) {
                    statement.bindNull(29);
                } else {
                    statement.bindString(29, entity.getCombo_course_ids());
                }
                if (entity.getPayment_type() == null) {
                    statement.bindNull(30);
                } else {
                    statement.bindString(30, entity.getPayment_type());
                }
                if (entity.getIs_postal_available() == null) {
                    statement.bindNull(31);
                } else {
                    statement.bindString(31, entity.getIs_postal_available());
                }
                if (entity.getExpiry_date() == null) {
                    statement.bindNull(32);
                } else {
                    statement.bindString(32, entity.getExpiry_date());
                }
                if (entity.getPurchase_date() == null) {
                    statement.bindNull(33);
                } else {
                    statement.bindString(33, entity.getPurchase_date());
                }
                if (entity.getUrl() == null) {
                    statement.bindNull(34);
                } else {
                    statement.bindString(34, entity.getUrl());
                }
                String strFromArrayList = Converters.fromArrayList(entity.getPrices());
                if (strFromArrayList == null) {
                    statement.bindNull(35);
                } else {
                    statement.bindString(35, strFromArrayList);
                }
                if (entity.getBatch_id() == null) {
                    statement.bindNull(36);
                } else {
                    statement.bindString(36, entity.getBatch_id());
                }
                if (entity.getSubject_id() == null) {
                    statement.bindNull(37);
                } else {
                    statement.bindString(37, entity.getSubject_id());
                }
                if (entity.getLang_id() == null) {
                    statement.bindNull(38);
                } else {
                    statement.bindString(38, entity.getLang_id());
                }
                if (entity.getType_id() == null) {
                    statement.bindNull(39);
                } else {
                    statement.bindString(39, entity.getType_id());
                }
                statement.bindLong(40, entity.getDelete());
                if (entity.getPayment_mode() == null) {
                    statement.bindNull(41);
                } else {
                    statement.bindString(41, entity.getPayment_mode());
                }
                if (entity.getEmi_payment() == null) {
                    statement.bindNull(42);
                } else {
                    statement.bindString(42, entity.getEmi_payment());
                }
                if (entity.getSubscription_code() == null) {
                    statement.bindNull(43);
                } else {
                    statement.bindString(43, entity.getSubscription_code());
                }
            }
        };
        this.__preparedStmtOfDeleteRecord = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.DueEmiDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM DueEmiTable WHERE id= ?";
            }
        };
        this.__preparedStmtOfDeleteAllDueEmi = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.DueEmiDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM DueEmiTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.DueEmiDao
    public void addDueEmiData(final DueEmiTable dueEmiTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDueEmiTable.insert(dueEmiTable);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.DueEmiDao
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

    @Override // com.appnew.android.Dao.DueEmiDao
    public void deleteAllDueEmi() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllDueEmi.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeleteAllDueEmi.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.DueEmiDao
    public List<DueEmiTable> getDueData() throws Throwable {
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
        int i3;
        String string26;
        String string27;
        String string28;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM DueEmiTable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "txn_id");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "holderType");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maintenanceText");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "segment_information");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseAttribute");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelect");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExpand");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "descHeaderImage");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseSp");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "colorCode");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avg_rating");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_rated");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "learner");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_activated");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "check_for_expiry");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLive");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_locked");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "home_screen");
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
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                DueEmiTable dueEmiTable = new DueEmiTable();
                ArrayList arrayList2 = arrayList;
                dueEmiTable.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                dueEmiTable.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                dueEmiTable.setTxn_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                dueEmiTable.setViewType(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                dueEmiTable.setHolderType(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                dueEmiTable.setMaintenanceText(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                dueEmiTable.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                dueEmiTable.setSegment_information(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                dueEmiTable.setCourseAttribute(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                dueEmiTable.setIsSelect(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                dueEmiTable.setIsExpand(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                dueEmiTable.setCover_image(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                dueEmiTable.setDescHeaderImage(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i5 = i4;
                if (cursorQuery.isNull(i5)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(i5);
                }
                dueEmiTable.setMrp(string);
                int i6 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i6)) {
                    i2 = i6;
                    string2 = null;
                } else {
                    i2 = i6;
                    string2 = cursorQuery.getString(i6);
                }
                dueEmiTable.setCourseSp(string2);
                int i7 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i7)) {
                    columnIndexOrThrow16 = i7;
                    string3 = null;
                } else {
                    columnIndexOrThrow16 = i7;
                    string3 = cursorQuery.getString(i7);
                }
                dueEmiTable.setColorCode(string3);
                int i8 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i8)) {
                    columnIndexOrThrow17 = i8;
                    string4 = null;
                } else {
                    columnIndexOrThrow17 = i8;
                    string4 = cursorQuery.getString(i8);
                }
                dueEmiTable.setValidity(string4);
                int i9 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i9)) {
                    columnIndexOrThrow18 = i9;
                    string5 = null;
                } else {
                    columnIndexOrThrow18 = i9;
                    string5 = cursorQuery.getString(i9);
                }
                dueEmiTable.setAvg_rating(string5);
                int i10 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i10)) {
                    columnIndexOrThrow19 = i10;
                    string6 = null;
                } else {
                    columnIndexOrThrow19 = i10;
                    string6 = cursorQuery.getString(i10);
                }
                dueEmiTable.setUser_rated(string6);
                int i11 = columnIndexOrThrow20;
                if (cursorQuery.isNull(i11)) {
                    columnIndexOrThrow20 = i11;
                    string7 = null;
                } else {
                    columnIndexOrThrow20 = i11;
                    string7 = cursorQuery.getString(i11);
                }
                dueEmiTable.setLearner(string7);
                int i12 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i12)) {
                    columnIndexOrThrow21 = i12;
                    string8 = null;
                } else {
                    columnIndexOrThrow21 = i12;
                    string8 = cursorQuery.getString(i12);
                }
                dueEmiTable.setIs_activated(string8);
                int i13 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i13)) {
                    columnIndexOrThrow22 = i13;
                    string9 = null;
                } else {
                    columnIndexOrThrow22 = i13;
                    string9 = cursorQuery.getString(i13);
                }
                dueEmiTable.setCheck_for_expiry(string9);
                int i14 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow23 = i14;
                    string10 = null;
                } else {
                    columnIndexOrThrow23 = i14;
                    string10 = cursorQuery.getString(i14);
                }
                dueEmiTable.setIsLive(string10);
                int i15 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow24 = i15;
                    string11 = null;
                } else {
                    columnIndexOrThrow24 = i15;
                    string11 = cursorQuery.getString(i15);
                }
                dueEmiTable.setIs_locked(string11);
                int i16 = columnIndexOrThrow25;
                if (cursorQuery.isNull(i16)) {
                    columnIndexOrThrow25 = i16;
                    string12 = null;
                } else {
                    columnIndexOrThrow25 = i16;
                    string12 = cursorQuery.getString(i16);
                }
                dueEmiTable.setHome_screen(string12);
                int i17 = columnIndexOrThrow26;
                if (cursorQuery.isNull(i17)) {
                    columnIndexOrThrow26 = i17;
                    string13 = null;
                } else {
                    columnIndexOrThrow26 = i17;
                    string13 = cursorQuery.getString(i17);
                }
                dueEmiTable.setLastread(string13);
                int i18 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow27 = i18;
                    string14 = null;
                } else {
                    columnIndexOrThrow27 = i18;
                    string14 = cursorQuery.getString(i18);
                }
                dueEmiTable.setSkipUnit(string14);
                int i19 = columnIndexOrThrow28;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow28 = i19;
                    string15 = null;
                } else {
                    columnIndexOrThrow28 = i19;
                    string15 = cursorQuery.getString(i19);
                }
                dueEmiTable.setSkipChapter(string15);
                int i20 = columnIndexOrThrow29;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow29 = i20;
                    string16 = null;
                } else {
                    columnIndexOrThrow29 = i20;
                    string16 = cursorQuery.getString(i20);
                }
                dueEmiTable.setCombo_course_ids(string16);
                int i21 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i21)) {
                    columnIndexOrThrow30 = i21;
                    string17 = null;
                } else {
                    columnIndexOrThrow30 = i21;
                    string17 = cursorQuery.getString(i21);
                }
                dueEmiTable.setPayment_type(string17);
                int i22 = columnIndexOrThrow31;
                if (cursorQuery.isNull(i22)) {
                    columnIndexOrThrow31 = i22;
                    string18 = null;
                } else {
                    columnIndexOrThrow31 = i22;
                    string18 = cursorQuery.getString(i22);
                }
                dueEmiTable.setIs_postal_available(string18);
                int i23 = columnIndexOrThrow32;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow32 = i23;
                    string19 = null;
                } else {
                    columnIndexOrThrow32 = i23;
                    string19 = cursorQuery.getString(i23);
                }
                dueEmiTable.setExpiry_date(string19);
                int i24 = columnIndexOrThrow33;
                if (cursorQuery.isNull(i24)) {
                    columnIndexOrThrow33 = i24;
                    string20 = null;
                } else {
                    columnIndexOrThrow33 = i24;
                    string20 = cursorQuery.getString(i24);
                }
                dueEmiTable.setPurchase_date(string20);
                int i25 = columnIndexOrThrow34;
                if (cursorQuery.isNull(i25)) {
                    columnIndexOrThrow34 = i25;
                    string21 = null;
                } else {
                    columnIndexOrThrow34 = i25;
                    string21 = cursorQuery.getString(i25);
                }
                dueEmiTable.setUrl(string21);
                int i26 = columnIndexOrThrow35;
                columnIndexOrThrow35 = i26;
                dueEmiTable.setPrices(Converters.fromString(cursorQuery.isNull(i26) ? null : cursorQuery.getString(i26)));
                int i27 = columnIndexOrThrow36;
                if (cursorQuery.isNull(i27)) {
                    columnIndexOrThrow36 = i27;
                    string22 = null;
                } else {
                    columnIndexOrThrow36 = i27;
                    string22 = cursorQuery.getString(i27);
                }
                dueEmiTable.setBatch_id(string22);
                int i28 = columnIndexOrThrow37;
                if (cursorQuery.isNull(i28)) {
                    columnIndexOrThrow37 = i28;
                    string23 = null;
                } else {
                    columnIndexOrThrow37 = i28;
                    string23 = cursorQuery.getString(i28);
                }
                dueEmiTable.setSubject_id(string23);
                int i29 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i29)) {
                    columnIndexOrThrow38 = i29;
                    string24 = null;
                } else {
                    columnIndexOrThrow38 = i29;
                    string24 = cursorQuery.getString(i29);
                }
                dueEmiTable.setLang_id(string24);
                int i30 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i30)) {
                    columnIndexOrThrow39 = i30;
                    string25 = null;
                } else {
                    columnIndexOrThrow39 = i30;
                    string25 = cursorQuery.getString(i30);
                }
                dueEmiTable.setType_id(string25);
                int i31 = columnIndexOrThrow40;
                dueEmiTable.setDelete(cursorQuery.getInt(i31));
                int i32 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i32)) {
                    i3 = i31;
                    string26 = null;
                } else {
                    i3 = i31;
                    string26 = cursorQuery.getString(i32);
                }
                dueEmiTable.setPayment_mode(string26);
                int i33 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i33)) {
                    columnIndexOrThrow42 = i33;
                    string27 = null;
                } else {
                    columnIndexOrThrow42 = i33;
                    string27 = cursorQuery.getString(i33);
                }
                dueEmiTable.setEmi_payment(string27);
                int i34 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i34)) {
                    columnIndexOrThrow43 = i34;
                    string28 = null;
                } else {
                    columnIndexOrThrow43 = i34;
                    string28 = cursorQuery.getString(i34);
                }
                dueEmiTable.setSubscription_code(string28);
                arrayList2.add(dueEmiTable);
                int i35 = i2;
                i4 = i5;
                columnIndexOrThrow15 = i35;
                columnIndexOrThrow40 = i3;
                columnIndexOrThrow41 = i32;
                arrayList = arrayList2;
                columnIndexOrThrow = i;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.appnew.android.Dao.DueEmiDao
    public DueEmiTable getDueEmiData(final String courseId) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        DueEmiTable dueEmiTable;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM DUEEMITABLE WHERE id=?", 1);
        if (courseId == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, courseId);
        }
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
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelect");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExpand");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "descHeaderImage");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "courseSp");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "colorCode");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "validity");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avg_rating");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_rated");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "learner");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_activated");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "check_for_expiry");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLive");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_locked");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "home_screen");
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
                if (cursorQuery.moveToFirst()) {
                    DueEmiTable dueEmiTable2 = new DueEmiTable();
                    dueEmiTable2.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                    dueEmiTable2.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    dueEmiTable2.setTxn_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    dueEmiTable2.setViewType(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    dueEmiTable2.setHolderType(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    dueEmiTable2.setMaintenanceText(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    dueEmiTable2.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    dueEmiTable2.setSegment_information(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    dueEmiTable2.setCourseAttribute(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    dueEmiTable2.setIsSelect(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    dueEmiTable2.setIsExpand(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    dueEmiTable2.setCover_image(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    dueEmiTable2.setDescHeaderImage(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    dueEmiTable2.setMrp(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    dueEmiTable2.setCourseSp(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    dueEmiTable2.setColorCode(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    dueEmiTable2.setValidity(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    dueEmiTable2.setAvg_rating(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    dueEmiTable2.setUser_rated(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    dueEmiTable2.setLearner(cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20));
                    dueEmiTable2.setIs_activated(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    dueEmiTable2.setCheck_for_expiry(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    dueEmiTable2.setIsLive(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    dueEmiTable2.setIs_locked(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                    dueEmiTable2.setHome_screen(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    dueEmiTable2.setLastread(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    dueEmiTable2.setSkipUnit(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    dueEmiTable2.setSkipChapter(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    dueEmiTable2.setCombo_course_ids(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                    dueEmiTable2.setPayment_type(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    dueEmiTable2.setIs_postal_available(cursorQuery.isNull(columnIndexOrThrow31) ? null : cursorQuery.getString(columnIndexOrThrow31));
                    dueEmiTable2.setExpiry_date(cursorQuery.isNull(columnIndexOrThrow32) ? null : cursorQuery.getString(columnIndexOrThrow32));
                    dueEmiTable2.setPurchase_date(cursorQuery.isNull(columnIndexOrThrow33) ? null : cursorQuery.getString(columnIndexOrThrow33));
                    dueEmiTable2.setUrl(cursorQuery.isNull(columnIndexOrThrow34) ? null : cursorQuery.getString(columnIndexOrThrow34));
                    dueEmiTable2.setPrices(Converters.fromString(cursorQuery.isNull(columnIndexOrThrow35) ? null : cursorQuery.getString(columnIndexOrThrow35)));
                    dueEmiTable2.setBatch_id(cursorQuery.isNull(columnIndexOrThrow36) ? null : cursorQuery.getString(columnIndexOrThrow36));
                    dueEmiTable2.setSubject_id(cursorQuery.isNull(columnIndexOrThrow37) ? null : cursorQuery.getString(columnIndexOrThrow37));
                    dueEmiTable2.setLang_id(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38));
                    dueEmiTable2.setType_id(cursorQuery.isNull(columnIndexOrThrow39) ? null : cursorQuery.getString(columnIndexOrThrow39));
                    dueEmiTable2.setDelete(cursorQuery.getInt(columnIndexOrThrow40));
                    dueEmiTable2.setPayment_mode(cursorQuery.isNull(columnIndexOrThrow41) ? null : cursorQuery.getString(columnIndexOrThrow41));
                    dueEmiTable2.setEmi_payment(cursorQuery.isNull(columnIndexOrThrow42) ? null : cursorQuery.getString(columnIndexOrThrow42));
                    dueEmiTable2.setSubscription_code(cursorQuery.isNull(columnIndexOrThrow43) ? null : cursorQuery.getString(columnIndexOrThrow43));
                    dueEmiTable = dueEmiTable2;
                } else {
                    dueEmiTable = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return dueEmiTable;
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
