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
import com.appnew.android.table.PDFDataTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class PDFDataDao_Impl implements PDFDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PDFDataTable> __deletionAdapterOfPDFDataTable;
    private final EntityInsertionAdapter<PDFDataTable> __insertionAdapterOfPDFDataTable;
    private final SharedSQLiteStatement __preparedStmtOfDelete_pdf_data;
    private final EntityDeletionOrUpdateAdapter<PDFDataTable> __updateAdapterOfPDFDataTable;

    public PDFDataDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPDFDataTable = new EntityInsertionAdapter<PDFDataTable>(__db) { // from class: com.appnew.android.Dao.PDFDataDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `PDFDataTable` (`id`,`userId`,`pdfName`,`pdfFile`,`pdfId`,`pdfImage`,`pdfPath`,`is_selected`,`pdfUrl`,`isShare`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PDFDataTable entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getUserId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUserId());
                }
                if (entity.getPdfName() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getPdfName());
                }
                if (entity.getPdfFile() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getPdfFile());
                }
                if (entity.getPdfId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getPdfId());
                }
                if (entity.getPdfImage() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getPdfImage());
                }
                if (entity.getPdfPath() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getPdfPath());
                }
                if (entity.getIs_selected() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getIs_selected());
                }
                if (entity.getPdfUrl() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getPdfUrl());
                }
                if (entity.getIsShare() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getIsShare());
                }
            }
        };
        this.__deletionAdapterOfPDFDataTable = new EntityDeletionOrUpdateAdapter<PDFDataTable>(__db) { // from class: com.appnew.android.Dao.PDFDataDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `PDFDataTable` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PDFDataTable entity) {
                statement.bindLong(1, entity.getId());
            }
        };
        this.__updateAdapterOfPDFDataTable = new EntityDeletionOrUpdateAdapter<PDFDataTable>(__db) { // from class: com.appnew.android.Dao.PDFDataDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `PDFDataTable` SET `id` = ?,`userId` = ?,`pdfName` = ?,`pdfFile` = ?,`pdfId` = ?,`pdfImage` = ?,`pdfPath` = ?,`is_selected` = ?,`pdfUrl` = ?,`isShare` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PDFDataTable entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getUserId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getUserId());
                }
                if (entity.getPdfName() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getPdfName());
                }
                if (entity.getPdfFile() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getPdfFile());
                }
                if (entity.getPdfId() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getPdfId());
                }
                if (entity.getPdfImage() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getPdfImage());
                }
                if (entity.getPdfPath() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getPdfPath());
                }
                if (entity.getIs_selected() == null) {
                    statement.bindNull(8);
                } else {
                    statement.bindString(8, entity.getIs_selected());
                }
                if (entity.getPdfUrl() == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindString(9, entity.getPdfUrl());
                }
                if (entity.getIsShare() == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindString(10, entity.getIsShare());
                }
                statement.bindLong(11, entity.getId());
            }
        };
        this.__preparedStmtOfDelete_pdf_data = new SharedSQLiteStatement(__db) { // from class: com.appnew.android.Dao.PDFDataDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE  FROM PDFDataTable WHERE pdfId = ?";
            }
        };
    }

    @Override // com.appnew.android.Dao.PDFDataDao
    public void insert(final PDFDataTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPDFDataTable.insert(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.PDFDataDao
    public void delete(final PDFDataTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfPDFDataTable.handle(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.PDFDataDao
    public void update(final PDFDataTable model) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPDFDataTable.handle(model);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.appnew.android.Dao.PDFDataDao
    public void delete_pdf_data(final String test_id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete_pdf_data.acquire();
        if (test_id == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, test_id);
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
            this.__preparedStmtOfDelete_pdf_data.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.appnew.android.Dao.PDFDataDao
    public PDFDataTable pdf_data(String str, String str2, String str3) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PDFDataTable WHERE  pdfId = ? AND pdfName=? AND userId=?", 3);
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
        if (str3 == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, str3);
        }
        this.__db.assertNotSuspendingTransaction();
        PDFDataTable pDFDataTable = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfName");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfFile");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfImage");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfPath");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isShare");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                PDFDataTable pDFDataTable2 = new PDFDataTable(string, cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7), string2, cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                pDFDataTable2.setId(cursorQuery.getInt(columnIndexOrThrow));
                pDFDataTable = pDFDataTable2;
            }
            return pDFDataTable;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.appnew.android.Dao.PDFDataDao
    public boolean pdfData(final String test_id) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT * FROM PDFDataTable WHERE  pdfId = ?)", 1);
        if (test_id == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, test_id);
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

    @Override // com.appnew.android.Dao.PDFDataDao
    public List<PDFDataTable> getListOfData() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM PDFDataTable", 0);
        this.__db.assertNotSuspendingTransaction();
        String str = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfName");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfFile");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfImage");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfPath");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_selected");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pdfUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isShare");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(columnIndexOrThrow2) ? str : cursorQuery.getString(columnIndexOrThrow2);
                String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? str : cursorQuery.getString(columnIndexOrThrow3);
                PDFDataTable pDFDataTable = new PDFDataTable(string, cursorQuery.isNull(columnIndexOrThrow4) ? str : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? str : cursorQuery.getString(columnIndexOrThrow5), cursorQuery.isNull(columnIndexOrThrow7) ? str : cursorQuery.getString(columnIndexOrThrow7), string2, cursorQuery.isNull(columnIndexOrThrow6) ? str : cursorQuery.getString(columnIndexOrThrow6), cursorQuery.isNull(columnIndexOrThrow8) ? str : cursorQuery.getString(columnIndexOrThrow8), cursorQuery.isNull(columnIndexOrThrow9) ? str : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? str : cursorQuery.getString(columnIndexOrThrow10));
                pDFDataTable.setId(cursorQuery.getInt(columnIndexOrThrow));
                arrayList.add(pDFDataTable);
                str = null;
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
