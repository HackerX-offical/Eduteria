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
import com.appnew.android.table.TopperReviewTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class TopperReviewDao_Impl implements TopperReviewDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<TopperReviewTable> __deletionAdapterOfTopperReviewTable;
    private final EntityInsertionAdapter<TopperReviewTable> __insertionAdapterOfTopperReviewTable;
    private final SharedSQLiteStatement __preparedStmtOfDeleteTopperReview;
    private final EntityDeletionOrUpdateAdapter<TopperReviewTable> __updateAdapterOfTopperReviewTable;

    public TopperReviewDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfTopperReviewTable = new EntityInsertionAdapter<TopperReviewTable>(__db) { // from class: com.appnew.android.Dao.TopperReviewDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `TopperReviewTable` (`auto_id`,`id`,`user_id`,`title`,`file_url`,`thumbnail_url`,`banner_url`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final TopperReviewTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
                if (entity.getTitle() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getTitle());
                }
                if (entity.getFile_url() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getFile_url());
                }
                if (entity.getThumbnail_url() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getThumbnail_url());
                }
                if (entity.getBanner_url() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getBanner_url());
                }
            }
        };
        this.__deletionAdapterOfTopperReviewTable = new EntityDeletionOrUpdateAdapter<TopperReviewTable>(__db) { // from class: com.appnew.android.Dao.TopperReviewDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `TopperReviewTable` WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final TopperReviewTable entity) {
                statement.bindLong(1, entity.getAuto_id());
            }
        };
        this.__updateAdapterOfTopperReviewTable = new EntityDeletionOrUpdateAdapter<TopperReviewTable>(__db) { // from class: com.appnew.android.Dao.TopperReviewDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `TopperReviewTable` SET `auto_id` = ?,`id` = ?,`user_id` = ?,`title` = ?,`file_url` = ?,`thumbnail_url` = ?,`banner_url` = ? WHERE `auto_id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final TopperReviewTable entity) {
                statement.bindLong(1, entity.getAuto_id());
                if (entity.getId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getId());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getUser_id());
                }
                if (entity.getTitle() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getTitle());
                }
                if (entity.getFile_url() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getFile_url());
                }
                if (entity.getThumbnail_url() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getThumbnail_url());
                }
                if (entity.getBanner_url() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getBanner_url());
                }
                statement.bindLong(8, entity.getAuto_id());
            }
        };
        this.__preparedStmtOfDeleteTopperReview = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.TopperReviewDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM TopperReviewTable";
            }
        };
    }

    @Override // com.appnew.android.Dao.TopperReviewDao
    public long addTopperReview(final TopperReviewTable topperReviewTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfTopperReviewTable.insertAndReturnId(topperReviewTable);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TopperReviewDao
    public int deleteopperReview(final TopperReviewTable topperReviewTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfTopperReviewTable.handle(topperReviewTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TopperReviewDao
    public int updateopperReview(final TopperReviewTable topperReviewTable) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfTopperReviewTable.handle(topperReviewTable);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.TopperReviewDao
    public void deleteTopperReview() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteTopperReview.acquire();
        try {
            this.__db.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeleteTopperReview.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.TopperReviewDao
    public TopperReviewTable getTopperReview(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM TopperReviewTable where user_id IN (?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        TopperReviewTable topperReviewTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_url");
            if (cursorQuery.moveToFirst()) {
                TopperReviewTable topperReviewTable2 = new TopperReviewTable();
                topperReviewTable2.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                topperReviewTable2.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                topperReviewTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                topperReviewTable2.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                topperReviewTable2.setFile_url(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                topperReviewTable2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                if (!cursorQuery.isNull(columnIndexOrThrow7)) {
                    string = cursorQuery.getString(columnIndexOrThrow7);
                }
                topperReviewTable2.setBanner_url(string);
                topperReviewTable = topperReviewTable2;
            }
            return topperReviewTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.TopperReviewDao
    public TopperReviewTable getTopperReview() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM TopperReviewTable", 0);
        this.__db.assertNotSuspendingTransaction();
        TopperReviewTable topperReviewTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "auto_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "file_url");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "thumbnail_url");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "banner_url");
            if (cursorQuery.moveToFirst()) {
                TopperReviewTable topperReviewTable2 = new TopperReviewTable();
                topperReviewTable2.setAuto_id(cursorQuery.getInt(columnIndexOrThrow));
                topperReviewTable2.setId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                topperReviewTable2.setUser_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                topperReviewTable2.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                topperReviewTable2.setFile_url(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                topperReviewTable2.setThumbnail_url(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                if (!cursorQuery.isNull(columnIndexOrThrow7)) {
                    string = cursorQuery.getString(columnIndexOrThrow7);
                }
                topperReviewTable2.setBanner_url(string);
                topperReviewTable = topperReviewTable2;
            }
            return topperReviewTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
