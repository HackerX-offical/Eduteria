package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* JADX INFO: loaded from: classes4.dex */
class TransferDBBase {
    private static final String BASE_PATH = "transfers";
    private static final int TRANSFERS = 10;
    private static final int TRANSFER_ID = 20;
    private static final int TRANSFER_PART = 30;
    private static final int TRANSFER_STATE = 40;
    private final Uri contentUri;
    private final Context context;
    private SQLiteDatabase database;
    private final TransferDatabaseHelper databaseHelper;
    private final UriMatcher uriMatcher;
    private static final Log LOGGER = LogFactory.getLog(TransferDBBase.class);
    private static final Object LOCK = new Object();

    public TransferDBBase(Context context) {
        this.context = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.databaseHelper = transferDatabaseHelper;
        this.database = transferDatabaseHelper.getWritableDatabase();
        this.contentUri = Uri.parse("content://" + packageName + "/transfers");
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.uriMatcher = uriMatcher;
        uriMatcher.addURI(packageName, BASE_PATH, 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    TransferDatabaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public void closeDBHelper() {
        this.databaseHelper.close();
    }

    public Uri getContentUri() {
        return this.contentUri;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        int iMatch = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (iMatch == 10) {
            return Uri.parse("transfers/" + this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, null, contentValues));
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(TransferTable.TABLE_TRANSFER);
        int iMatch = this.uriMatcher.match(uri);
        if (iMatch == 10) {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        } else if (iMatch == 20) {
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
        } else if (iMatch == 30) {
            sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
        } else if (iMatch == 40) {
            sQLiteQueryBuilder.appendWhere("state=");
            sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        ensureDatabaseOpen();
        return sQLiteQueryBuilder.query(this.database, strArr, str, strArr2, null, null, str2);
    }

    public synchronized int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdate;
        int iMatch = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (iMatch == 10) {
            iUpdate = this.database.update(TransferTable.TABLE_TRANSFER, contentValues, str, strArr);
        } else if (iMatch == 20) {
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(str)) {
                iUpdate = this.database.update(TransferTable.TABLE_TRANSFER, contentValues, "_id=" + lastPathSegment, null);
            } else {
                iUpdate = this.database.update(TransferTable.TABLE_TRANSFER, contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
            }
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return iUpdate;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int iMatch = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (iMatch == 10) {
            return this.database.delete(TransferTable.TABLE_TRANSFER, str, strArr);
        }
        if (iMatch == 20) {
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(str)) {
                return this.database.delete(TransferTable.TABLE_TRANSFER, "_id=" + lastPathSegment, null);
            }
            return this.database.delete(TransferTable.TABLE_TRANSFER, "_id=" + lastPathSegment + " and " + str, strArr);
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int iMatch = this.uriMatcher.match(uri);
        ensureDatabaseOpen();
        if (iMatch == 10) {
            int iInsertOrThrow = 0;
            try {
                try {
                    this.database.beginTransaction();
                    iInsertOrThrow = (int) this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, null, contentValuesArr[0]);
                    for (int i = 1; i < contentValuesArr.length; i++) {
                        contentValuesArr[i].put(TransferTable.COLUMN_MAIN_UPLOAD_ID, Integer.valueOf(iInsertOrThrow));
                        this.database.insertOrThrow(TransferTable.TABLE_TRANSFER, null, contentValuesArr[i]);
                    }
                    this.database.setTransactionSuccessful();
                } catch (Exception e2) {
                    LOGGER.error("bulkInsert error : ", e2);
                }
                return iInsertOrThrow;
            } finally {
                this.database.endTransaction();
            }
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    private void ensureDatabaseOpen() {
        synchronized (LOCK) {
            if (!this.database.isOpen()) {
                this.database = this.databaseHelper.getWritableDatabase();
            }
        }
    }

    SQLiteDatabase getDatabase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (LOCK) {
            sQLiteDatabase = this.database;
        }
        return sQLiteDatabase;
    }
}
