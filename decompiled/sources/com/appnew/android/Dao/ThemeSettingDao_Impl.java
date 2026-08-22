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
import com.appnew.android.table.ThemeSettings;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class ThemeSettingDao_Impl implements ThemeSettingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ThemeSettings> __deletionAdapterOfThemeSettings;
    private final EntityInsertionAdapter<ThemeSettings> __insertionAdapterOfThemeSettings;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final EntityDeletionOrUpdateAdapter<ThemeSettings> __updateAdapterOfThemeSettings;

    public ThemeSettingDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfThemeSettings = new EntityInsertionAdapter<ThemeSettings>(__db) { // from class: com.appnew.android.Dao.ThemeSettingDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `ThemeSettings` (`autoid`,`theme`,`bottom`,`left_menu`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final ThemeSettings entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getTheme() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTheme());
                }
                if (entity.getBottom() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getBottom());
                }
                if (entity.getLeft_menu() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getLeft_menu());
                }
            }
        };
        this.__deletionAdapterOfThemeSettings = new EntityDeletionOrUpdateAdapter<ThemeSettings>(__db) { // from class: com.appnew.android.Dao.ThemeSettingDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `ThemeSettings` WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final ThemeSettings entity) {
                statement.bindLong(1, entity.getAutoid());
            }
        };
        this.__updateAdapterOfThemeSettings = new EntityDeletionOrUpdateAdapter<ThemeSettings>(__db) { // from class: com.appnew.android.Dao.ThemeSettingDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `ThemeSettings` SET `autoid` = ?,`theme` = ?,`bottom` = ?,`left_menu` = ? WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final ThemeSettings entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getTheme() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getTheme());
                }
                if (entity.getBottom() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getBottom());
                }
                if (entity.getLeft_menu() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getLeft_menu());
                }
                statement.bindLong(5, entity.getAutoid());
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.ThemeSettingDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ThemeSettings";
            }
        };
    }

    @Override // com.appnew.android.Dao.ThemeSettingDao
    public long addUser(final ThemeSettings themeSettings) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfThemeSettings.insertAndReturnId(themeSettings);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.ThemeSettingDao
    public int deleteUser(final ThemeSettings themeSettings) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfThemeSettings.handle(themeSettings);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.ThemeSettingDao
    public int updateUser(final ThemeSettings themeSettings) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfThemeSettings.handle(themeSettings);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.ThemeSettingDao
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

    @Override // com.appnew.android.Dao.ThemeSettingDao
    public ThemeSettings data() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ThemeSettings", 0);
        this.__db.assertNotSuspendingTransaction();
        ThemeSettings themeSettings = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.THEME);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bottom");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "left_menu");
            if (cursorQuery.moveToFirst()) {
                ThemeSettings themeSettings2 = new ThemeSettings();
                themeSettings2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                themeSettings2.setTheme(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                themeSettings2.setBottom(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                if (!cursorQuery.isNull(columnIndexOrThrow4)) {
                    string = cursorQuery.getString(columnIndexOrThrow4);
                }
                themeSettings2.setLeft_menu(string);
                themeSettings = themeSettings2;
            }
            return themeSettings;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.ThemeSettingDao
    public boolean is_setting_exit() {
        boolean z = false;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM ThemeSettings)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                if (cursorQuery.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
