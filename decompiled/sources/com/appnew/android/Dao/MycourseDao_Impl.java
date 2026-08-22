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
import com.appnew.android.Model.Courselist;
import com.appnew.android.TypeConverter.Converters;
import com.appnew.android.Utils.Const;
import com.appnew.android.table.MycourseTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class MycourseDao_Impl implements MycourseDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MycourseTable> __deletionAdapterOfMycourseTable;
    private final EntityInsertionAdapter<MycourseTable> __insertionAdapterOfMycourseTable;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_course_lastread;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_course_lastread_1;
    private final EntityDeletionOrUpdateAdapter<MycourseTable> __updateAdapterOfMycourseTable;

    public MycourseDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfMycourseTable = new EntityInsertionAdapter<MycourseTable>(__db) { // from class: com.appnew.android.Dao.MycourseDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `mycoursetable` (`autoid`,`id`,`cat_type`,`is_activated`,`title`,`isSelect`,`isExpand`,`batch_id`,`cover_image`,`desc_header_image`,`expiry_date`,`purchase_date`,`mrp`,`txn_id`,`lastread`,`userid`,`batchtype`,`delete`,`content_type`,`prices`,`combo_course_ids`,`viewType`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final MycourseTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                if (entity.getCat_type() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getCat_type());
                }
                if (entity.getIs_activated() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getIs_activated());
                }
                if (entity.getTitle() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getTitle());
                }
                if (entity.getIsSelect() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getIsSelect());
                }
                if (entity.getIsExpand() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getIsExpand());
                }
                if (entity.getBatch_id() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getBatch_id());
                }
                if (entity.getCover_image() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCover_image());
                }
                if (entity.getDescHeaderImage() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getDescHeaderImage());
                }
                if (entity.getExpiry_date() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getExpiry_date());
                }
                if (entity.getPurchase_date() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getPurchase_date());
                }
                if (entity.getMrp() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getMrp());
                }
                if (entity.getTxn_id() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getTxn_id());
                }
                if (entity.getLastread() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getLastread());
                }
                if (entity.getUserid() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getUserid());
                }
                if (entity.getBatchtype() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getBatchtype());
                }
                statement.bindLong(18, entity.getDelete());
                if (entity.getContent_type() == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, entity.getContent_type());
                }
                String strFromArrayList = Converters.fromArrayList(entity.getPrices());
                if (strFromArrayList == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, strFromArrayList);
                }
                if (entity.getCombo_course_ids() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getCombo_course_ids());
                }
                if (entity.getViewType() == null) {
                    statement.bindNull(22);
                } else {
                    statement.bindString(22, entity.getViewType());
                }
            }
        };
        this.__deletionAdapterOfMycourseTable = new EntityDeletionOrUpdateAdapter<MycourseTable>(__db) { // from class: com.appnew.android.Dao.MycourseDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `mycoursetable` WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final MycourseTable entity) {
                statement.bindLong(1, entity.getAutoid());
            }
        };
        this.__updateAdapterOfMycourseTable = new EntityDeletionOrUpdateAdapter<MycourseTable>(__db) { // from class: com.appnew.android.Dao.MycourseDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `mycoursetable` SET `autoid` = ?,`id` = ?,`cat_type` = ?,`is_activated` = ?,`title` = ?,`isSelect` = ?,`isExpand` = ?,`batch_id` = ?,`cover_image` = ?,`desc_header_image` = ?,`expiry_date` = ?,`purchase_date` = ?,`mrp` = ?,`txn_id` = ?,`lastread` = ?,`userid` = ?,`batchtype` = ?,`delete` = ?,`content_type` = ?,`prices` = ?,`combo_course_ids` = ?,`viewType` = ? WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final MycourseTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                if (entity.getCat_type() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getCat_type());
                }
                if (entity.getIs_activated() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getIs_activated());
                }
                if (entity.getTitle() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getTitle());
                }
                if (entity.getIsSelect() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getIsSelect());
                }
                if (entity.getIsExpand() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getIsExpand());
                }
                if (entity.getBatch_id() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getBatch_id());
                }
                if (entity.getCover_image() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getCover_image());
                }
                if (entity.getDescHeaderImage() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getDescHeaderImage());
                }
                if (entity.getExpiry_date() == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindString(11, entity.getExpiry_date());
                }
                if (entity.getPurchase_date() == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindString(12, entity.getPurchase_date());
                }
                if (entity.getMrp() == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindString(13, entity.getMrp());
                }
                if (entity.getTxn_id() == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindString(14, entity.getTxn_id());
                }
                if (entity.getLastread() == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindString(15, entity.getLastread());
                }
                if (entity.getUserid() == null) {
                    statement.bindNull(16);
                } else {
                    statement.bindString(16, entity.getUserid());
                }
                if (entity.getBatchtype() == null) {
                    statement.bindNull(17);
                } else {
                    statement.bindString(17, entity.getBatchtype());
                }
                statement.bindLong(18, entity.getDelete());
                if (entity.getContent_type() == null) {
                    statement.bindNull(19);
                } else {
                    statement.bindString(19, entity.getContent_type());
                }
                String strFromArrayList = Converters.fromArrayList(entity.getPrices());
                if (strFromArrayList == null) {
                    statement.bindNull(20);
                } else {
                    statement.bindString(20, strFromArrayList);
                }
                if (entity.getCombo_course_ids() == null) {
                    statement.bindNull(21);
                } else {
                    statement.bindString(21, entity.getCombo_course_ids());
                }
                if (entity.getViewType() == null) {
                    statement.bindNull(22);
                } else {
                    statement.bindString(22, entity.getViewType());
                }
                statement.bindLong(23, entity.getAutoid());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.MycourseDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM mycoursetable";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.MycourseDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from mycoursetable where id = ? AND txn_id = ?";
            }
        };
        this.__preparedStmtOfUpdate_course_lastread = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.MycourseDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE mycoursetable SET lastread=? WHERE id = ? AND  userid = ? AND batchtype =?";
            }
        };
        this.__preparedStmtOfUpdate_course_lastread_1 = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.MycourseDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE mycoursetable SET lastread=? WHERE id = ? AND  userid = ? ";
            }
        };
    }

    @Override // com.appnew.android.Dao.MycourseDao
    public long addUser(final MycourseTable getProfileTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfMycourseTable.insertAndReturnId(getProfileTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.MycourseDao
    public int deleteUser(final MycourseTable userTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfMycourseTable.handle(userTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.MycourseDao
    public int updateUser(final MycourseTable userTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfMycourseTable.handle(userTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.MycourseDao
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

    @Override // com.appnew.android.Dao.MycourseDao
    public void delete(final String course_id, final String txn_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        if (course_id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, course_id);
        }
        if (txn_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, txn_id);
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
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.MycourseDao
    public int update_course_lastread(final String lastread_timestamp, final String c_id, final String userid, final String batch_type) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_course_lastread.acquire();
        if (lastread_timestamp == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, lastread_timestamp);
        }
        if (c_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, c_id);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, userid);
        }
        if (batch_type == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, batch_type);
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
            this.__preparedStmtOfUpdate_course_lastread.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.MycourseDao
    public int update_course_lastread(final String lastread_timestamp, final String c_id, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_course_lastread_1.acquire();
        if (lastread_timestamp == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, lastread_timestamp);
        }
        if (c_id == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, c_id);
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
            this.__preparedStmtOfUpdate_course_lastread_1.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.MycourseDao
    public List<MycourseTable> getAllUser() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        String string4;
        int i3;
        String string5;
        String string6;
        String string7;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM mycoursetable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_activated");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelect");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExpand");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.BATCH_ID);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "desc_header_image");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiry_date");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "purchase_date");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "txn_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastread");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "batchtype");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prices");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    MycourseTable mycourseTable = new MycourseTable();
                    ArrayList arrayList2 = arrayList;
                    mycourseTable.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                    mycourseTable.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    mycourseTable.setCat_type(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    mycourseTable.setIs_activated(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    mycourseTable.setTitle(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    mycourseTable.setIsSelect(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    mycourseTable.setIsExpand(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    mycourseTable.setBatch_id(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    mycourseTable.setCover_image(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    mycourseTable.setDescHeaderImage(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    mycourseTable.setExpiry_date(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    mycourseTable.setPurchase_date(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    mycourseTable.setMrp(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    if (cursorQuery.isNull(i5)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(i5);
                    }
                    mycourseTable.setTxn_id(string);
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i2 = i6;
                        string2 = null;
                    } else {
                        i2 = i6;
                        string2 = cursorQuery.getString(i6);
                    }
                    mycourseTable.setLastread(string2);
                    int i7 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i7)) {
                        columnIndexOrThrow16 = i7;
                        string3 = null;
                    } else {
                        columnIndexOrThrow16 = i7;
                        string3 = cursorQuery.getString(i7);
                    }
                    mycourseTable.setUserid(string3);
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string4 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string4 = cursorQuery.getString(i8);
                    }
                    mycourseTable.setBatchtype(string4);
                    int i9 = columnIndexOrThrow18;
                    mycourseTable.setDelete(cursorQuery.getInt(i9));
                    int i10 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i10)) {
                        i3 = i9;
                        string5 = null;
                    } else {
                        i3 = i9;
                        string5 = cursorQuery.getString(i10);
                    }
                    mycourseTable.setContent_type(string5);
                    int i11 = columnIndexOrThrow20;
                    columnIndexOrThrow20 = i11;
                    mycourseTable.setPrices(Converters.fromString(cursorQuery.isNull(i11) ? null : cursorQuery.getString(i11)));
                    int i12 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i12)) {
                        columnIndexOrThrow21 = i12;
                        string6 = null;
                    } else {
                        columnIndexOrThrow21 = i12;
                        string6 = cursorQuery.getString(i12);
                    }
                    mycourseTable.setCombo_course_ids(string6);
                    int i13 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow22 = i13;
                        string7 = null;
                    } else {
                        columnIndexOrThrow22 = i13;
                        string7 = cursorQuery.getString(i13);
                    }
                    mycourseTable.setViewType(string7);
                    arrayList2.add(mycourseTable);
                    int i14 = i2;
                    i4 = i5;
                    columnIndexOrThrow15 = i14;
                    columnIndexOrThrow18 = i3;
                    columnIndexOrThrow19 = i10;
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

    @Override // com.appnew.android.Dao.MycourseDao
    public List<String> getAllcourseid(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT  DISTINCT id  FROM mycoursetable  where  userid=?", 1);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.MycourseDao
    public List<Courselist> getFreecourse(final String mrp, final String batch_type) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        String string3;
        String string4;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM mycoursetable where  mrp = ? AND batchtype=?", 2);
        if (mrp == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, mrp);
        }
        if (batch_type == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, batch_type);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_activated");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelect");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExpand");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.BATCH_ID);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiry_date");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "purchase_date");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "txn_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastread");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prices");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    Courselist courselist = new Courselist();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    courselist.setId(string);
                    courselist.setCat_type(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    courselist.setIs_activated(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    courselist.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    courselist.setSelect(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                    courselist.setExpand(cursorQuery.getInt(columnIndexOrThrow6) != 0);
                    courselist.setBatch_id(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    courselist.setCover_image(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    courselist.setExpiry_date(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    courselist.setPurchase_date(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    courselist.setMrp(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    courselist.setTxn_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    courselist.setLastread(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = i3;
                    int i5 = columnIndexOrThrow11;
                    courselist.setDelete(cursorQuery.getInt(i4));
                    int i6 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i6)) {
                        i2 = i4;
                        string2 = null;
                    } else {
                        i2 = i4;
                        string2 = cursorQuery.getString(i6);
                    }
                    courselist.setContent_type(string2);
                    int i7 = columnIndexOrThrow16;
                    columnIndexOrThrow16 = i7;
                    courselist.setPrices(Converters.fromString(cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7)));
                    int i8 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i8)) {
                        columnIndexOrThrow17 = i8;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i8;
                        string3 = cursorQuery.getString(i8);
                    }
                    courselist.setCombo_course_ids(string3);
                    int i9 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i9)) {
                        columnIndexOrThrow18 = i9;
                        string4 = null;
                    } else {
                        columnIndexOrThrow18 = i9;
                        string4 = cursorQuery.getString(i9);
                    }
                    courselist.setViewType(string4);
                    arrayList.add(courselist);
                    columnIndexOrThrow15 = i6;
                    columnIndexOrThrow11 = i5;
                    i3 = i2;
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

    @Override // com.appnew.android.Dao.MycourseDao
    public List<Courselist> getpaidcourse(final String batch_type) throws Throwable {
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM mycoursetable where  batchtype=?", 1);
        if (batch_type == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, batch_type);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_activated");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelect");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExpand");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.BATCH_ID);
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiry_date");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "purchase_date");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "txn_id");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastread");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prices");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
            int i3 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                Courselist courselist = new Courselist();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                courselist.setId(string);
                courselist.setCat_type(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                courselist.setIs_activated(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                courselist.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                courselist.setSelect(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                courselist.setExpand(cursorQuery.getInt(columnIndexOrThrow6) != 0);
                courselist.setBatch_id(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                courselist.setCover_image(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                courselist.setExpiry_date(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                courselist.setPurchase_date(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                courselist.setMrp(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                courselist.setTxn_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                courselist.setLastread(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i4 = i3;
                int i5 = columnIndexOrThrow11;
                courselist.setDelete(cursorQuery.getInt(i4));
                int i6 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i6)) {
                    i2 = i4;
                    string2 = null;
                } else {
                    i2 = i4;
                    string2 = cursorQuery.getString(i6);
                }
                courselist.setContent_type(string2);
                int i7 = columnIndexOrThrow16;
                columnIndexOrThrow16 = i7;
                courselist.setPrices(Converters.fromString(cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7)));
                int i8 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i8)) {
                    columnIndexOrThrow17 = i8;
                    string3 = null;
                } else {
                    columnIndexOrThrow17 = i8;
                    string3 = cursorQuery.getString(i8);
                }
                courselist.setCombo_course_ids(string3);
                int i9 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i9)) {
                    columnIndexOrThrow18 = i9;
                    string4 = null;
                } else {
                    columnIndexOrThrow18 = i9;
                    string4 = cursorQuery.getString(i9);
                }
                courselist.setViewType(string4);
                arrayList.add(courselist);
                columnIndexOrThrow15 = i6;
                columnIndexOrThrow11 = i5;
                i3 = i2;
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

    @Override // com.appnew.android.Dao.MycourseDao
    public boolean isRecordExistsUserId(final String userid, final String batch_type, final String id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM MycourseTable WHERE userid = ? AND batchtype = ?  AND id = ?)", 3);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        if (batch_type == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, batch_type);
        }
        if (id == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, id);
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

    @Override // com.appnew.android.Dao.MycourseDao
    public boolean isRecordExists(final String userid) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM MycourseTable WHERE userid = ?)", 1);
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

    @Override // com.appnew.android.Dao.MycourseDao
    public Courselist getuser(final String userid, final String id, final String batch_type) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        Courselist courselist;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM mycoursetable where  userid = ? AND batchtype = ?  AND id = ?", 3);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        if (batch_type == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, batch_type);
        }
        if (id == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cat_type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_activated");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelect");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExpand");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.BATCH_ID);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cover_image");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expiry_date");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "purchase_date");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mrp");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "txn_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastread");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "delete");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_type");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "prices");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "combo_course_ids");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "viewType");
                if (cursorQuery.moveToFirst()) {
                    Courselist courselist2 = new Courselist();
                    courselist2.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    courselist2.setCat_type(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    courselist2.setIs_activated(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    courselist2.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    courselist2.setSelect(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                    courselist2.setExpand(cursorQuery.getInt(columnIndexOrThrow6) != 0);
                    courselist2.setBatch_id(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    courselist2.setCover_image(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    courselist2.setExpiry_date(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    courselist2.setPurchase_date(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    courselist2.setMrp(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    courselist2.setTxn_id(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    courselist2.setLastread(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    courselist2.setDelete(cursorQuery.getInt(columnIndexOrThrow14));
                    courselist2.setContent_type(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    courselist2.setPrices(Converters.fromString(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16)));
                    courselist2.setCombo_course_ids(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                    courselist2.setViewType(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    courselist = courselist2;
                } else {
                    courselist = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return courselist;
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
