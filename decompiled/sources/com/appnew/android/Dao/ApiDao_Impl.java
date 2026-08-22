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
import com.appnew.android.table.APITABLE;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ApiDao_Impl implements ApiDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<APITABLE> __deletionAdapterOfAPITABLE;
    private final EntityInsertionAdapter<APITABLE> __insertionAdapterOfAPITABLE;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_api_version;
    private final SharedSQLiteStatement __preparedStmtOfUpdateversion;
    private final EntityDeletionOrUpdateAdapter<APITABLE> __updateAdapterOfAPITABLE;

    public ApiDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAPITABLE = new EntityInsertionAdapter<APITABLE>(__db) { // from class: com.appnew.android.Dao.ApiDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `APITABLE` (`auto_id`,`user_id`,`timestamp`,`cdtimestamp`,`version`,`Apiname`,`Apicode`,`interval`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final APITABLE entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getUser_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUser_id());
                }
                if (entity.getTimestamp() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getTimestamp());
                }
                if (entity.getCdtimestamp() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getCdtimestamp());
                }
                if (entity.getVersion() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getVersion());
                }
                if (entity.getApiname() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getApiname());
                }
                if (entity.getApicode() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getApicode());
                }
                if (entity.getInterval() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getInterval());
                }
            }
        };
        this.__deletionAdapterOfAPITABLE = new EntityDeletionOrUpdateAdapter<APITABLE>(__db) { // from class: com.appnew.android.Dao.ApiDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `APITABLE` WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final APITABLE entity) {
                statement.bindLong(1, entity.getAuto_id());
            }
        };
        this.__updateAdapterOfAPITABLE = new EntityDeletionOrUpdateAdapter<APITABLE>(__db) { // from class: com.appnew.android.Dao.ApiDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `APITABLE` SET `auto_id` = ?,`user_id` = ?,`timestamp` = ?,`cdtimestamp` = ?,`version` = ?,`Apiname` = ?,`Apicode` = ?,`interval` = ? WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final APITABLE entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getUser_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUser_id());
                }
                if (entity.getTimestamp() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getTimestamp());
                }
                if (entity.getCdtimestamp() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getCdtimestamp());
                }
                if (entity.getVersion() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getVersion());
                }
                if (entity.getApiname() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getApiname());
                }
                if (entity.getApicode() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getApicode());
                }
                if (entity.getInterval() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getInterval());
                }
                statement.bindLong(9, entity.getAuto_id());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.ApiDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM APITABLE";
            }
        };
        this.__preparedStmtOfUpdate_api_version = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.ApiDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE APITABLE  SET timestamp =? ,interval=?,cdtimestamp=?   WHERE Apicode = ?  AND user_id =?";
            }
        };
        this.__preparedStmtOfUpdateversion = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.ApiDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE APITABLE SET version =? where  Apicode=? AND user_id=?";
            }
        };
    }

    @Override // com.appnew.android.Dao.ApiDao
    public long addUser(final APITABLE apitable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfAPITABLE.insertAndReturnId(apitable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.ApiDao
    public int deleteUser(final APITABLE apitable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfAPITABLE.handle(apitable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.ApiDao
    public int updateUser(final APITABLE apitable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfAPITABLE.handle(apitable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.ApiDao
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

    @Override // com.appnew.android.Dao.ApiDao
    public void update_api_version(final String apicode, final String userid, final String timestamp, final String interval, final String cdtimestamp) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_api_version.acquire();
        if (timestamp == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, timestamp);
        }
        if (interval == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, interval);
        }
        if (cdtimestamp == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, cdtimestamp);
        }
        if (apicode == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, apicode);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindString(5, userid);
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
            this.__preparedStmtOfUpdate_api_version.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.ApiDao
    public int updateversion(final String version, final String userid, final String apicode) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateversion.acquire();
        if (version == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, version);
        }
        if (apicode == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, apicode);
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
            this.__preparedStmtOfUpdateversion.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.ApiDao
    public boolean is_api_code_exits(final String userid, final String apicode) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM APITABLE WHERE user_id = ? AND Apicode =? ", 2);
        if (userid == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, userid);
        }
        if (apicode == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, apicode);
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

    @Override // com.appnew.android.Dao.ApiDao
    public APITABLE getapidetail(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM APITABLE  WHERE Apicode = ? AND user_id =?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        APITABLE apitable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cdtimestamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "Apiname");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "Apicode");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval");
            if (cursorQuery.moveToFirst()) {
                APITABLE apitable2 = new APITABLE();
                apitable2.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                apitable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                apitable2.setTimestamp(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                apitable2.setCdtimestamp(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                apitable2.setVersion(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                apitable2.setApiname(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                apitable2.setApicode(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                if (!cursorQuery.isNull(columnIndexOrThrow8)) {
                    string = cursorQuery.getString(columnIndexOrThrow8);
                }
                apitable2.setInterval(string);
                apitable = apitable2;
            }
            return apitable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
