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
import com.appnew.android.table.UserWiseCourseTable;
import com.facebook.AuthenticationTokenClaims;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class UserWiseCourseDao_Impl implements UserWiseCourseDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<UserWiseCourseTable> __deletionAdapterOfUserWiseCourseTable;
    private final EntityInsertionAdapter<UserWiseCourseTable> __insertionAdapterOfUserWiseCourseTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_api_version;
    private final SharedSQLiteStatement __preparedStmtOfUpdateversion;
    private final EntityDeletionOrUpdateAdapter<UserWiseCourseTable> __updateAdapterOfUserWiseCourseTable;

    public UserWiseCourseDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfUserWiseCourseTable = new EntityInsertionAdapter<UserWiseCourseTable>(__db) { // from class: com.appnew.android.Dao.UserWiseCourseDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `UserWiseCourseTable` (`auto_id`,`meta_id`,`code`,`version`,`exp`,`userid`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final UserWiseCourseTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getMeta_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getMeta_id());
                }
                if (entity.getCode() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getCode());
                }
                if (entity.getVersion() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getVersion());
                }
                if (entity.getExp() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getExp());
                }
                if (entity.getUserid() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getUserid());
                }
            }
        };
        this.__deletionAdapterOfUserWiseCourseTable = new EntityDeletionOrUpdateAdapter<UserWiseCourseTable>(__db) { // from class: com.appnew.android.Dao.UserWiseCourseDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `UserWiseCourseTable` WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final UserWiseCourseTable entity) {
                statement.bindLong(1, entity.getAuto_id());
            }
        };
        this.__updateAdapterOfUserWiseCourseTable = new EntityDeletionOrUpdateAdapter<UserWiseCourseTable>(__db) { // from class: com.appnew.android.Dao.UserWiseCourseDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `UserWiseCourseTable` SET `auto_id` = ?,`meta_id` = ?,`code` = ?,`version` = ?,`exp` = ?,`userid` = ? WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final UserWiseCourseTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getMeta_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getMeta_id());
                }
                if (entity.getCode() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getCode());
                }
                if (entity.getVersion() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getVersion());
                }
                if (entity.getExp() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getExp());
                }
                if (entity.getUserid() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getUserid());
                }
                statement.bindLong(7, entity.getAuto_id());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserWiseCourseDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM UserWiseCourseTable";
            }
        };
        this.__preparedStmtOfUpdate_api_version = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserWiseCourseDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE UserWiseCourseTable  SET  version =?  WHERE meta_id = ?  AND userid =?";
            }
        };
        this.__preparedStmtOfUpdateversion = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.UserWiseCourseDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE UserWiseCourseTable SET version =? where  meta_id=? AND userid=?";
            }
        };
    }

    @Override // com.appnew.android.Dao.UserWiseCourseDao
    public long addUser(final UserWiseCourseTable apitable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfUserWiseCourseTable.insertAndReturnId(apitable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.UserWiseCourseDao
    public int deleteUser(final UserWiseCourseTable apitable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfUserWiseCourseTable.handle(apitable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.UserWiseCourseDao
    public int updateUser(final UserWiseCourseTable apitable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfUserWiseCourseTable.handle(apitable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.UserWiseCourseDao
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

    @Override // com.appnew.android.Dao.UserWiseCourseDao
    public void update_api_version(final String apicode, final String userid, final String version) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_api_version.acquire();
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
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfUpdate_api_version.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.UserWiseCourseDao
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

    @Override // com.appnew.android.Dao.UserWiseCourseDao
    public boolean is_api_code_exits(final String userid, final String apicode) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM UserWiseCourseTable WHERE userid = ? AND meta_id =? ", 2);
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

    @Override // com.appnew.android.Dao.UserWiseCourseDao
    public UserWiseCourseTable getapidetail(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM UserWiseCourseTable  WHERE meta_id = ? AND userid =?", 2);
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
        UserWiseCourseTable userWiseCourseTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "meta_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "code");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "version");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, AuthenticationTokenClaims.JSON_KEY_EXP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userid");
            if (cursorQuery.moveToFirst()) {
                UserWiseCourseTable userWiseCourseTable2 = new UserWiseCourseTable();
                userWiseCourseTable2.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                userWiseCourseTable2.setMeta_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                userWiseCourseTable2.setCode(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                userWiseCourseTable2.setVersion(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                userWiseCourseTable2.setExp(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                if (!cursorQuery.isNull(columnIndexOrThrow6)) {
                    string = cursorQuery.getString(columnIndexOrThrow6);
                }
                userWiseCourseTable2.setUserid(string);
                userWiseCourseTable = userWiseCourseTable2;
            }
            return userWiseCourseTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
