package com.appnew.android.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.appnew.android.Model.VideoViewCount;

/* JADX INFO: loaded from: classes6.dex */
public class DBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "viewCountDetails";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_VIDEO_ID = "videoId";
    private static final String KEY_VIEW_COUNT = "viewCount";
    private static final String TABLE_VIEWCOUNT = "ViewCountTable";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS ViewCountTable(userId TEXT, videoId TEXT PRIMARY KEY, viewCount INTEGER (10))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ViewCountTable");
        onCreate(db);
    }

    public void addData(VideoViewCount viewCount) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER_ID, viewCount.getUser_id());
        contentValues.put(KEY_VIDEO_ID, viewCount.getVideo_id());
        contentValues.put(KEY_VIEW_COUNT, Integer.valueOf(viewCount.getViewCount()));
        writableDatabase.insert(TABLE_VIEWCOUNT, null, contentValues);
        writableDatabase.close();
    }

    public VideoViewCount getData(String userId, String videoId) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM ViewCountTable WHERE userId=? AND videoId=?", new String[]{userId, videoId});
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
        }
        if (cursorRawQuery.moveToFirst()) {
            return new VideoViewCount(cursorRawQuery.getString(0), cursorRawQuery.getString(1), Integer.parseInt(cursorRawQuery.getString(2)));
        }
        return null;
    }

    public String updateData(VideoViewCount viewCount) {
        Cursor cursorRawQuery = getWritableDatabase().rawQuery("UPDATE ViewCountTable SET viewCount=? WHERE userId=? AND videoId=?", new String[]{String.valueOf(viewCount.getViewCount()), viewCount.getUser_id(), viewCount.getVideo_id()});
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
            return "Data Updated";
        }
        return "data not updated";
    }
}
