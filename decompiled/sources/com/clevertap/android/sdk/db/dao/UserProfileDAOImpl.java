package com.clevertap.android.sdk.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.DBEncryptionHandler;
import com.clevertap.android.sdk.db.DatabaseHelper;
import com.clevertap.android.sdk.db.Table;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: UserProfileDAOImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\f\u001a\u00020\rH\u0017J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/sdk/db/dao/UserProfileDAOImpl;", "Lcom/clevertap/android/sdk/db/dao/UserProfileDAO;", "dbHelper", "Lcom/clevertap/android/sdk/db/DatabaseHelper;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "dbEncryptionHandler", "Lcom/clevertap/android/sdk/db/DBEncryptionHandler;", "<init>", "(Lcom/clevertap/android/sdk/db/DatabaseHelper;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/db/DBEncryptionHandler;)V", "storeUserProfile", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", Constants.DEVICE_ID_TAG, "profile", "Lorg/json/JSONObject;", "fetchUserProfilesByAccountId", "", "fetchUserProfile", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileDAOImpl implements UserProfileDAO {
    private final DBEncryptionHandler dbEncryptionHandler;
    private final DatabaseHelper dbHelper;
    private final ILogger logger;

    public UserProfileDAOImpl(DatabaseHelper dbHelper, ILogger logger, DBEncryptionHandler dbEncryptionHandler) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(dbEncryptionHandler, "dbEncryptionHandler");
        this.dbHelper = dbHelper;
        this.logger = logger;
        this.dbEncryptionHandler = dbEncryptionHandler;
    }

    @Override // com.clevertap.android.sdk.db.dao.UserProfileDAO
    public long storeUserProfile(String accountId, String deviceId, JSONObject profile) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(profile, "profile");
        if (!this.dbHelper.belowMemThreshold()) {
            this.logger.verbose(DBAdapter.NOT_ENOUGH_SPACE_LOG);
            return -2L;
        }
        String tableName = Table.USER_PROFILES.getTableName();
        this.logger.verbose("Inserting or updating userProfile for accountID = " + accountId + " + deviceID = " + deviceId);
        ContentValues contentValues = new ContentValues();
        DBEncryptionHandler dBEncryptionHandler = this.dbEncryptionHandler;
        String string = profile.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        contentValues.put("data", dBEncryptionHandler.wrapDbData(string));
        contentValues.put("_id", accountId);
        contentValues.put(Column.DEVICE_ID, deviceId);
        try {
            return this.dbHelper.getWritableDatabase().insertWithOnConflict(tableName, null, contentValues, 5);
        } catch (SQLiteException e2) {
            this.logger.verbose("Error adding data to table " + tableName + ". Recreating DB", e2);
            this.dbHelper.deleteDatabase();
            return -1L;
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.UserProfileDAO
    public Map<String, JSONObject> fetchUserProfilesByAccountId(String accountId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String tableName = Table.USER_PROFILES.getTableName();
        try {
            Cursor cursorQuery = this.dbHelper.getReadableDatabase().query(tableName, null, "_id = ?", new String[]{accountId}, null, null, null);
            if (cursorQuery == null) {
                return linkedHashMap;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                int columnIndex = cursor2.getColumnIndex("data");
                int columnIndex2 = cursor2.getColumnIndex(Column.DEVICE_ID);
                while (cursor2.moveToNext()) {
                    String string = cursor2.getString(columnIndex);
                    String string2 = cursor2.getString(columnIndex2);
                    String strUnwrapDbData = this.dbEncryptionHandler.unwrapDbData(string);
                    if (strUnwrapDbData != null) {
                        linkedHashMap.put(string2, new JSONObject(strUnwrapDbData));
                    } else {
                        this.logger.verbose("Error decrypting JSON for profile");
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
                return linkedHashMap;
            } finally {
            }
        } catch (SQLiteException e2) {
            this.logger.verbose("Could not fetch records out of database " + tableName + '.', e2);
            return linkedHashMap;
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.UserProfileDAO
    public JSONObject fetchUserProfile(String accountId, String deviceId) {
        SQLiteException sQLiteException;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        String tableName = Table.USER_PROFILES.getTableName();
        JSONObject jSONObject2 = null;
        try {
            Cursor cursorQuery = this.dbHelper.getReadableDatabase().query(tableName, null, "_id = ? AND deviceID = ?", new String[]{accountId, deviceId}, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                try {
                    try {
                        if (cursor2.moveToFirst()) {
                            int columnIndex = cursor2.getColumnIndex("data");
                            if (columnIndex >= 0) {
                                String strUnwrapDbData = this.dbEncryptionHandler.unwrapDbData(cursor2.getString(columnIndex));
                                if (strUnwrapDbData != null) {
                                    jSONObject = new JSONObject(strUnwrapDbData);
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(cursor, null);
                                    return jSONObject;
                                }
                                this.logger.verbose("Failed profile decryption");
                            }
                        } else {
                            this.logger.verbose("There was no profile found in DB");
                        }
                        CloseableKt.closeFinally(cursor, null);
                        return jSONObject;
                    } catch (SQLiteException e2) {
                        sQLiteException = e2;
                        jSONObject2 = jSONObject;
                    }
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    jSONObject2 = jSONObject;
                    Throwable th2 = th;
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(cursor, th2);
                        throw th3;
                    }
                }
                jSONObject = null;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (SQLiteException e3) {
            sQLiteException = e3;
        }
        this.logger.verbose("Could not fetch records out of database " + tableName + '.', sQLiteException);
        return jSONObject2;
    }
}
