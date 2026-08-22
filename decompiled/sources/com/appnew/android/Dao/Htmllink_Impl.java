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
import com.appnew.android.table.HtmlTbale;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class Htmllink_Impl implements Htmllink {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<HtmlTbale> __deletionAdapterOfHtmlTbale;
    private final EntityInsertionAdapter<HtmlTbale> __insertionAdapterOfHtmlTbale;
    private final SharedSQLiteStatement __preparedStmtOfDelete_viaconceptid;
    private final SharedSQLiteStatement __preparedStmtOfDeletedata;
    private final SharedSQLiteStatement __preparedStmtOfUpdate_highlight;
    private final EntityDeletionOrUpdateAdapter<HtmlTbale> __updateAdapterOfHtmlTbale;

    public Htmllink_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfHtmlTbale = new EntityInsertionAdapter<HtmlTbale>(__db) { // from class: com.appnew.android.Dao.Htmllink_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR ABORT INTO `HtmlTbale` (`autoid`,`concept_id`,`tile_id`,`user_id`,`course_id`,`highight`,`html`,`valid_to`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final HtmlTbale entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getConcept_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getConcept_id());
                }
                if (entity.getTile_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getTile_id());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getUser_id());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getCourse_id());
                }
                if (entity.getHighight() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getHighight());
                }
                if (entity.getHtml() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getHtml());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getValid_to());
                }
            }
        };
        this.__deletionAdapterOfHtmlTbale = new EntityDeletionOrUpdateAdapter<HtmlTbale>(__db) { // from class: com.appnew.android.Dao.Htmllink_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `HtmlTbale` WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final HtmlTbale entity) {
                statement.bindLong(1, entity.getAutoid());
            }
        };
        this.__updateAdapterOfHtmlTbale = new EntityDeletionOrUpdateAdapter<HtmlTbale>(__db) { // from class: com.appnew.android.Dao.Htmllink_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `HtmlTbale` SET `autoid` = ?,`concept_id` = ?,`tile_id` = ?,`user_id` = ?,`course_id` = ?,`highight` = ?,`html` = ?,`valid_to` = ? WHERE `autoid` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final HtmlTbale entity) {
                statement.bindLong(1, entity.getAutoid());
                if (entity.getConcept_id() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getConcept_id());
                }
                if (entity.getTile_id() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getTile_id());
                }
                if (entity.getUser_id() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getUser_id());
                }
                if (entity.getCourse_id() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getCourse_id());
                }
                if (entity.getHighight() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getHighight());
                }
                if (entity.getHtml() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getHtml());
                }
                if (entity.getValid_to() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getValid_to());
                }
                statement.bindLong(9, entity.getAutoid());
            }
        };
        this.__preparedStmtOfUpdate_highlight = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.Htmllink_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE htmltbale SET    highight=?  where  user_id =?  AND concept_id =?";
            }
        };
        this.__preparedStmtOfDeletedata = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.Htmllink_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM HtmlTbale";
            }
        };
        this.__preparedStmtOfDelete_viaconceptid = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.Htmllink_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "Delete from HtmlTbale where concept_id = ? AND user_id=?";
            }
        };
    }

    @Override // com.appnew.android.Dao.Htmllink
    public long addUser(final HtmlTbale htmlTbale) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfHtmlTbale.insertAndReturnId(htmlTbale);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.Htmllink
    public int deleteUser(final HtmlTbale htmlTbale) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfHtmlTbale.handle(htmlTbale);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.Htmllink
    public int updateUser(final HtmlTbale htmlTbale) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfHtmlTbale.handle(htmlTbale);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.Htmllink
    public void update_highlight(final String highight, final String userid, final String concept_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate_highlight.acquire();
        if (highight == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, highight);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, userid);
        }
        if (concept_id == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, concept_id);
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
            this.__preparedStmtOfUpdate_highlight.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.Htmllink
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

    @Override // com.appnew.android.Dao.Htmllink
    public void delete_viaconceptid(final String videoid, final String userid) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_viaconceptid.acquire();
        if (videoid == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, videoid);
        }
        if (userid == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, userid);
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
            this.__preparedStmtOfDelete_viaconceptid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.Htmllink
    public boolean is_concept_exit(final String user_id, final String concept_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM HtmlTbale WHERE user_id = ? AND concept_id =?)", 2);
        if (user_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, user_id);
        }
        if (concept_id == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, concept_id);
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

    @Override // com.appnew.android.Dao.Htmllink
    public HtmlTbale getconcept(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM HtmlTbale  WHERE user_id =? AND concept_id=?", 2);
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
        HtmlTbale htmlTbale = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "autoid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "concept_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tile_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "user_id");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "course_id");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "highight");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "html");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "valid_to");
            if (cursorQuery.moveToFirst()) {
                HtmlTbale htmlTbale2 = new HtmlTbale();
                htmlTbale2.setAutoid(cursorQuery.getInt(columnIndexOrThrow));
                htmlTbale2.setConcept_id(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                htmlTbale2.setTile_id(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                htmlTbale2.setUser_id(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                htmlTbale2.setCourse_id(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                htmlTbale2.setHighight(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                htmlTbale2.setHtml(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                if (!cursorQuery.isNull(columnIndexOrThrow8)) {
                    string = cursorQuery.getString(columnIndexOrThrow8);
                }
                htmlTbale2.setValid_to(string);
                htmlTbale = htmlTbale2;
            }
            return htmlTbale;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
