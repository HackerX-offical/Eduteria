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
import com.appnew.android.table.LanguagesTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class LaunguageDao_Impl implements LaunguageDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<LanguagesTable> __insertionAdapterOfLanguagesTable;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;

    public LaunguageDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfLanguagesTable = new EntityInsertionAdapter<LanguagesTable>(__db) { // from class: com.appnew.android.Dao.LaunguageDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `LanguagesTable` (`autoid`,`id`,`language`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final LanguagesTable entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                if (entity.getLanguage() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getLanguage());
                }
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.LaunguageDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LanguagesTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.LaunguageDao
    public long addLaunguage(final LanguagesTable languagesTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfLanguagesTable.insertAndReturnId(languagesTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.LaunguageDao
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

    @Override // com.appnew.android.Dao.LaunguageDao
    public List<LanguagesTable> getLaunguagedetail() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LanguagesTable", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Const.LANGUAGE);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                LanguagesTable languagesTable = new LanguagesTable();
                languagesTable.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                languagesTable.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                languagesTable.setLanguage(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                arrayList.add(languagesTable);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
