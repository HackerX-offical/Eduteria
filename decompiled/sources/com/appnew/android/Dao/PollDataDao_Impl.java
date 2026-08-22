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
import com.appnew.android.table.PollDataTable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class PollDataDao_Impl implements PollDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PollDataTable> __deletionAdapterOfPollDataTable;
    private final EntityInsertionAdapter<PollDataTable> __insertionAdapterOfPollDataTable;
    private final SharedSQLiteStatement __preparedStmtOfDelete_poll_data;
    private final EntityDeletionOrUpdateAdapter<PollDataTable> __updateAdapterOfPollDataTable;

    public PollDataDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPollDataTable = new EntityInsertionAdapter<PollDataTable>(__db) { // from class: com.appnew.android.Dao.PollDataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `PollDataTable` (`id`,`user_id`,`poll_id`,`firebase_node`,`poll_answer`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PollDataTable entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getUser_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUser_id());
                }
                if (entity.getPoll_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getPoll_id());
                }
                if (entity.getFirebase_node() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getFirebase_node());
                }
                if (entity.getPoll_answer() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getPoll_answer());
                }
            }
        };
        this.__deletionAdapterOfPollDataTable = new EntityDeletionOrUpdateAdapter<PollDataTable>(__db) { // from class: com.appnew.android.Dao.PollDataDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `PollDataTable` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PollDataTable entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfPollDataTable = new EntityDeletionOrUpdateAdapter<PollDataTable>(__db) { // from class: com.appnew.android.Dao.PollDataDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `PollDataTable` SET `id` = ?,`user_id` = ?,`poll_id` = ?,`firebase_node` = ?,`poll_answer` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PollDataTable entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getUser_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUser_id());
                }
                if (entity.getPoll_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getPoll_id());
                }
                if (entity.getFirebase_node() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getFirebase_node());
                }
                if (entity.getPoll_answer() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getPoll_answer());
                }
                statement.bindLong(6, entity.getId());
            }
        };
        this.__preparedStmtOfDelete_poll_data = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.PollDataDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE  FROM PollDataTable WHERE poll_Id = ?";
            }
        };
    }

    @Override // com.appnew.android.Dao.PollDataDao
    public void insert(final PollDataTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPollDataTable.insert(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.PollDataDao
    public void delete(final PollDataTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPollDataTable.handle(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.PollDataDao
    public void update(final PollDataTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPollDataTable.handle(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.PollDataDao
    public void delete_poll_data(final String poll_Id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_poll_data.acquire();
        if (poll_Id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, poll_Id);
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
            this.__preparedStmtOfDelete_poll_data.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.PollDataDao
    public PollDataTable poll_data(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PollDataTable WHERE  poll_id = ? AND user_id=?", 2);
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
        PollDataTable pollDataTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "poll_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firebase_node");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "poll_answer");
            if (cursorQuery.moveToFirst()) {
                String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    string = cursorQuery.getString(columnIndexOrThrow5);
                }
                PollDataTable pollDataTable2 = new PollDataTable(string2, string3, string, string4);
                pollDataTable2.setId(cursorQuery.getInt(columnIndexOrThrow));
                pollDataTable = pollDataTable2;
            }
            return pollDataTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.PollDataDao
    public PollDataTable poll_data(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PollDataTable WHERE  user_id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        PollDataTable pollDataTable = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "poll_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firebase_node");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "poll_answer");
            if (cursorQuery.moveToFirst()) {
                String string2 = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string3 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                String string4 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    string = cursorQuery.getString(columnIndexOrThrow5);
                }
                PollDataTable pollDataTable2 = new PollDataTable(string2, string3, string, string4);
                pollDataTable2.setId(cursorQuery.getInt(columnIndexOrThrow));
                pollDataTable = pollDataTable2;
            }
            return pollDataTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.PollDataDao
    public boolean pollData(final String poll_Id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM PollDataTable WHERE  poll_Id = ?)", 1);
        if (poll_Id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, poll_Id);
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
