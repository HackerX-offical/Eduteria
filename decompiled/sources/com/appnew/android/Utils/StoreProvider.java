package com.appnew.android.Utils;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class StoreProvider extends ContentProvider {
    public static boolean isUpgrade = false;
    private static LinkedHashMap<String, String> sDataProjectionMap = null;
    private static final UriMatcher sUriMatcher;
    private static final int videoDownload_DATA = 1;
    private static final String videoDownload_DATABASE_NAME = "MME.db";
    private static final int videoDownload_DATA_APP = 5;
    private static final int videoDownload_DATA_APP_KEY = 3;
    private static final int videoDownload_DATA_ID = 2;
    private static final int videoDownload_DATA_KEY = 4;
    private static final String videoDownload_DATA_TABLE_NAME = "MMEdatastore";
    private static final String videoDownload_TAG = "StoreProvider";
    public static String videoPlayer_AUTHORITY = "com.eduteria.app.app.Utils.StoreProvider";
    public static int videoPlayer_DATABASE_VERSION = 22;
    private DatabaseHelper mOpenHelper;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        sUriMatcher = uriMatcher;
        uriMatcher.addURI(videoPlayer_AUTHORITY, "data", 1);
        uriMatcher.addURI(videoPlayer_AUTHORITY, "data/#", 2);
        uriMatcher.addURI(videoPlayer_AUTHORITY, "data/appkey/*/*", 3);
        uriMatcher.addURI(videoPlayer_AUTHORITY, "data/app/*", 5);
        uriMatcher.addURI(videoPlayer_AUTHORITY, "data/key/*", 4);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        sDataProjectionMap = linkedHashMap;
        linkedHashMap.put("_id", "_id");
        sDataProjectionMap.put("key", "key");
        sDataProjectionMap.put("data", "data");
        sDataProjectionMap.put(StoreData.CREATED_DATE, StoreData.CREATED_DATE);
        sDataProjectionMap.put(StoreData.MODIFIED_DATE, StoreData.MODIFIED_DATE);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String str;
        String str2;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        int iMatch = sUriMatcher.match(uri);
        if (iMatch == 1) {
            sQLiteQueryBuilder.setTables(videoDownload_DATA_TABLE_NAME);
            sQLiteQueryBuilder.setProjectionMap(sDataProjectionMap);
        } else if (iMatch == 2) {
            sQLiteQueryBuilder.setTables(videoDownload_DATA_TABLE_NAME);
            sQLiteQueryBuilder.setProjectionMap(sDataProjectionMap);
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getPathSegments().get(1));
        } else if (iMatch == 3 || iMatch == 4) {
            if (uri.getPathSegments().size() > 3) {
                str2 = uri.getPathSegments().get(2);
                str = uri.getPathSegments().get(3);
            } else {
                str = uri.getPathSegments().get(2);
                str2 = "";
            }
            sQLiteQueryBuilder.setTables(videoDownload_DATA_TABLE_NAME);
            sQLiteQueryBuilder.setProjectionMap(sDataProjectionMap);
            sQLiteQueryBuilder.appendWhere("app=\"" + str2 + "\" AND key=\"" + str + "\"");
        } else {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (TextUtils.isEmpty(sortOrder)) {
            sortOrder = StoreData.DEFAULT_SORT_ORDER;
        }
        Cursor cursorQuery = sQLiteQueryBuilder.query(this.mOpenHelper.getReadableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int iMatch = sUriMatcher.match(uri);
        if (iMatch == 1) {
            return StoreData.CONTENT_TYPE;
        }
        if (iMatch == 2) {
            return StoreData.CONTENT_ITEM_TYPE;
        }
        if (iMatch == 3 || iMatch == 4) {
            return StoreData.CONTENT_TYPE;
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues initialValues) {
        ContentValues contentValues;
        if (sUriMatcher.match(uri) != 3) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (initialValues != null) {
            contentValues = new ContentValues(initialValues);
        } else {
            contentValues = new ContentValues();
        }
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        if (!contentValues.containsKey(StoreData.CREATED_DATE)) {
            contentValues.put(StoreData.CREATED_DATE, lValueOf);
        }
        if (!contentValues.containsKey(StoreData.MODIFIED_DATE)) {
            contentValues.put(StoreData.MODIFIED_DATE, lValueOf);
        }
        if (!contentValues.containsKey("key") || !contentValues.containsKey(StoreData.APP)) {
            throw new SQLException("Failed to insert row into must specify both app name and key");
        }
        if (!contentValues.containsKey("data")) {
            contentValues.remove("data");
        }
        long jInsert = this.mOpenHelper.getWritableDatabase().insert(videoDownload_DATA_TABLE_NAME, "data", contentValues);
        if (jInsert > 0) {
            Uri uriWithAppendedId = ContentUris.withAppendedId(StoreData.CONTENT_URI, jInsert);
            getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
            return uriWithAppendedId;
        }
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String where, String[] whereArgs) {
        int iDelete;
        String str;
        String str2;
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        int iMatch = sUriMatcher.match(uri);
        if (iMatch != 1) {
            if (iMatch == 2) {
                iDelete = writableDatabase.delete(videoDownload_DATA_TABLE_NAME, "_id=" + uri.getPathSegments().get(1) + (TextUtils.isEmpty(where) ? "" : " AND (" + where + ')'), whereArgs);
            } else if (iMatch == 3 || iMatch == 5) {
                if (uri.getPathSegments().size() > 3) {
                    str = uri.getPathSegments().get(2);
                    str2 = uri.getPathSegments().get(3);
                } else {
                    str = uri.getPathSegments().get(2);
                    str2 = null;
                }
                if (str2 == null) {
                    iDelete = writableDatabase.delete(videoDownload_DATA_TABLE_NAME, "app=\"" + str + "\"" + (TextUtils.isEmpty(where) ? "" : " AND (" + where + ')'), whereArgs);
                } else {
                    iDelete = writableDatabase.delete(videoDownload_DATA_TABLE_NAME, "key=\"" + str2 + "\" AND app=\"" + str + "\"" + (TextUtils.isEmpty(where) ? "" : " AND (" + where + ')'), whereArgs);
                }
            } else {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
        } else {
            iDelete = writableDatabase.delete(videoDownload_DATA_TABLE_NAME, where, whereArgs);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        int iUpdate;
        SQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        int iMatch = sUriMatcher.match(uri);
        if (iMatch != 1) {
            if (iMatch == 2) {
                iUpdate = writableDatabase.update(videoDownload_DATA_TABLE_NAME, values, "_id=" + uri.getPathSegments().get(1) + (TextUtils.isEmpty(where) ? "" : " AND (" + where + ')'), whereArgs);
            } else if (iMatch == 3 || iMatch == 4) {
                iUpdate = writableDatabase.update(videoDownload_DATA_TABLE_NAME, values, "key=\"" + uri.getPathSegments().get(1) + "\" AND app=\"" + (uri.getPathSegments().size() > 1 ? uri.getPathSegments().get(2) : "") + "\"" + (TextUtils.isEmpty(where) ? "" : " AND (" + where + ')'), whereArgs);
            } else {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
        } else {
            iUpdate = writableDatabase.update(videoDownload_DATA_TABLE_NAME, values, where, whereArgs);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return iUpdate;
    }

    public static final class StoreData implements BaseColumns {
        public static final String APP = "app";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.mme.storedata";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.mme.storedata";
        public static final Uri CONTENT_URI = Uri.parse("content://" + StoreProvider.videoPlayer_AUTHORITY + "/data");
        public static final String CREATED_DATE = "created";
        public static final String DATA = "data";
        public static final String DEFAULT_SORT_ORDER = "modified DESC";
        public static final String KEY = "key";
        public static final String MODIFIED_DATE = "modified";

        private StoreData() {
        }
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, StoreProvider.videoDownload_DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, StoreProvider.videoPlayer_DATABASE_VERSION);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE MMEdatastore (_id INTEGER PRIMARY KEY,key TEXT,app TEXT,data BLOB,created INTEGER,modified INTEGER, UNIQUE(app,key) ON CONFLICT REPLACE);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            StoreProvider.isUpgrade = true;
        }
    }
}
