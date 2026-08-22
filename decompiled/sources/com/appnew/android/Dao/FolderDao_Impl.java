package com.appnew.android.Dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.appnew.android.table.FolderEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class FolderDao_Impl implements FolderDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<FolderEntity> __insertionAdapterOfFolderEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDataParticular;

    public FolderDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfFolderEntity = new EntityInsertionAdapter<FolderEntity>(__db) { // from class: com.appnew.android.Dao.FolderDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `FolderEntity` (`auto_id`,`hitCount`,`data`) VALUES (nullif(?, 0),?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final FolderEntity entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getHitCount() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getHitCount());
                }
                if (entity.getData() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getData());
                }
            }
        };
        this.__preparedStmtOfDeleteData = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FolderDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM FolderEntity";
            }
        };
        this.__preparedStmtOfDeleteDataParticular = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.FolderDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM FolderEntity WHERE hitCount = ?";
            }
        };
    }

    @Override // com.appnew.android.Dao.FolderDao
    public long addFolderData(final FolderEntity folderEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfFolderEntity.insertAndReturnId(folderEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.FolderDao
    public void deleteData() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteData.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeleteData.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FolderDao
    public void deleteDataParticular(final String hitCount) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteDataParticular.acquire();
        if (hitCount == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, hitCount);
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
            this.__preparedStmtOfDeleteDataParticular.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.FolderDao
    public boolean hasFolderData(final String hitCount) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("Select * from FolderEntity where hitCount = ?", 1);
        if (hitCount == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, hitCount);
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

    @Override // com.appnew.android.Dao.FolderDao
    public List<FolderEntity> getAllUser() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM FolderEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hitCount");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                FolderEntity folderEntity = new FolderEntity();
                folderEntity.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                folderEntity.setHitCount(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                folderEntity.setData(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                arrayList.add(folderEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.FolderDao
    public FolderEntity getParticularData(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM FolderEntity WHERE hitCount = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        FolderEntity folderEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hitCount");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
            if (cursorQuery.moveToFirst()) {
                FolderEntity folderEntity2 = new FolderEntity();
                folderEntity2.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                folderEntity2.setHitCount(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                    string = cursorQuery.getString(columnIndexOrThrow3);
                }
                folderEntity2.setData(string);
                folderEntity = folderEntity2;
            }
            return folderEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
