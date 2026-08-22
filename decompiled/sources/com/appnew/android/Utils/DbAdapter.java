package com.appnew.android.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class DbAdapter extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "eMedicozdb";
    public static final String TABLE_NAME_COLORCODE = "colorcode";
    private static DbAdapter mDbHelper;
    private final String DATABASE_CREATE_TABLE_COLORCODE;

    public DbAdapter(Context context) throws PackageManager.NameNotFoundException {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        this.DATABASE_CREATE_TABLE_COLORCODE = "CREATE TABLE colorcode(user_id, color_code)";
    }

    public static synchronized DbAdapter getInstance(Context context) {
        if (mDbHelper == null) {
            try {
                mDbHelper = new DbAdapter(context);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return mDbHelper;
    }

    public String insertQuery(String TABLE_NAME, ContentValues contentValues) throws SQLException {
        long jInsert;
        try {
            jInsert = getWritableDatabase().insert(TABLE_NAME, null, contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
            jInsert = 0;
        }
        return String.valueOf(jInsert);
    }

    public Cursor fetchQuery(String TABLE_NAME, String userid) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT  * FROM " + TABLE_NAME + " WHERE user_id =?", new String[]{userid});
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
        }
        return cursorRawQuery;
    }

    public void deleteAll(String TABLE_NAME) {
        try {
            getWritableDatabase().delete(TABLE_NAME, null, null);
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE colorcode(user_id, color_code)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS colorcode");
        onCreate(db);
    }

    public void saveColorforUser(String userid, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", userid);
        contentValues.put(Const.COLOR_CODE, Integer.valueOf(i));
        insertQuery(TABLE_NAME_COLORCODE, contentValues);
    }

    public Integer getColorforUser(String userid) {
        int iValueOf = 0;
        Cursor cursorFetchQuery = fetchQuery(TABLE_NAME_COLORCODE, userid);
        for (int i = 0; i < cursorFetchQuery.getCount(); i++) {
            iValueOf = Integer.valueOf(cursorFetchQuery.getInt(cursorFetchQuery.getColumnIndex(Const.COLOR_CODE)));
            cursorFetchQuery.moveToNext();
        }
        return iValueOf;
    }

    public Integer getColor(String userid) {
        int iNextInt = new Random().nextInt(8) + 1;
        int iIntValue = getColorforUser(userid).intValue();
        if (iIntValue == 0) {
            saveColorforUser(userid, iNextInt);
        } else {
            iNextInt = iIntValue;
        }
        return Integer.valueOf(iNextInt);
    }
}
