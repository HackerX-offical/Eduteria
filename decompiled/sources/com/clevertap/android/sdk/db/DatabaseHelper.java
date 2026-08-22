package com.clevertap.android.sdk.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.StorageHelper;
import com.facebook.appevents.UserDataStore;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CtDatabase.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B+\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\u0006\u0010\u001f\u001a\u00020\u0012J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0005H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/clevertap/android/sdk/db/DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", "dbName", "logger", "Lcom/clevertap/android/sdk/ILogger;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/clevertap/android/sdk/ILogger;)V", "getContext", "()Landroid/content/Context;", "getAccountId", "()Ljava/lang/String;", "databaseFile", "Ljava/io/File;", "onCreate", "", UserDataStore.DATE_OF_BIRTH, "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "getDeviceIdForAccountIdFromPrefs", "migrateUserProfilesTable", "migrateDataString", "dataString", "belowMemThreshold", "", "deleteDatabase", "executeStatement", "statement", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6;
    private static final int DB_LIMIT = 25165824;
    private final String accountId;
    private final Context context;
    private final File databaseFile;
    private final ILogger logger;

    public final Context getContext() {
        return this.context;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatabaseHelper(Context context, String accountId, String str, ILogger logger) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 6);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.context = context;
        this.accountId = accountId;
        this.logger = logger;
        this.databaseFile = context.getDatabasePath(str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        this.logger.verbose("Creating CleverTap DB");
        executeStatement(db, CtDatabaseKt.CREATE_EVENTS_TABLE);
        executeStatement(db, CtDatabaseKt.CREATE_USER_EVENT_LOGS_TABLE);
        executeStatement(db, CtDatabaseKt.CREATE_PROFILE_EVENTS_TABLE);
        executeStatement(db, CtDatabaseKt.CREATE_USER_PROFILES_TABLE);
        executeStatement(db, CtDatabaseKt.CREATE_INBOX_MESSAGES_TABLE);
        executeStatement(db, CtDatabaseKt.CREATE_PUSH_NOTIFICATIONS_TABLE);
        executeStatement(db, CtDatabaseKt.CREATE_UNINSTALL_TS_TABLE);
        executeStatement(db, CtDatabaseKt.CREATE_NOTIFICATION_VIEWED_TABLE);
        executeStatement(db, CtDatabaseKt.CREATE_DELAYED_LEGACY_INAPPS_TABLE);
        executeStatement(db, CtDatabaseKt.EVENTS_TIME_INDEX);
        executeStatement(db, CtDatabaseKt.PROFILE_EVENTS_TIME_INDEX);
        executeStatement(db, CtDatabaseKt.UNINSTALL_TS_INDEX);
        executeStatement(db, CtDatabaseKt.PUSH_NOTIFICATIONS_TIME_INDEX);
        executeStatement(db, CtDatabaseKt.INBOX_MESSAGES_COMP_ID_USERID_INDEX);
        executeStatement(db, CtDatabaseKt.NOTIFICATION_VIEWED_INDEX);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(db, "db");
        this.logger.verbose("Upgrading CleverTap DB to version " + newVersion);
        if (oldVersion == 1) {
            executeStatement(db, CtDatabaseKt.DROP_TABLE_UNINSTALL_TS);
            executeStatement(db, CtDatabaseKt.DROP_TABLE_INBOX_MESSAGES);
            executeStatement(db, CtDatabaseKt.DROP_TABLE_PUSH_NOTIFICATION_VIEWED);
            executeStatement(db, CtDatabaseKt.CREATE_INBOX_MESSAGES_TABLE);
            executeStatement(db, CtDatabaseKt.CREATE_PUSH_NOTIFICATIONS_TABLE);
            executeStatement(db, CtDatabaseKt.CREATE_UNINSTALL_TS_TABLE);
            executeStatement(db, CtDatabaseKt.CREATE_NOTIFICATION_VIEWED_TABLE);
            executeStatement(db, CtDatabaseKt.UNINSTALL_TS_INDEX);
            executeStatement(db, CtDatabaseKt.PUSH_NOTIFICATIONS_TIME_INDEX);
            executeStatement(db, CtDatabaseKt.INBOX_MESSAGES_COMP_ID_USERID_INDEX);
            executeStatement(db, CtDatabaseKt.NOTIFICATION_VIEWED_INDEX);
            migrateUserProfilesTable(db);
        } else if (oldVersion == 2) {
            executeStatement(db, CtDatabaseKt.DROP_TABLE_PUSH_NOTIFICATION_VIEWED);
            executeStatement(db, CtDatabaseKt.CREATE_NOTIFICATION_VIEWED_TABLE);
            executeStatement(db, CtDatabaseKt.NOTIFICATION_VIEWED_INDEX);
            migrateUserProfilesTable(db);
        } else if (oldVersion == 3) {
            migrateUserProfilesTable(db);
        }
        if (oldVersion < 5) {
            executeStatement(db, CtDatabaseKt.CREATE_USER_EVENT_LOGS_TABLE);
        }
        if (oldVersion < 6) {
            executeStatement(db, CtDatabaseKt.CREATE_DELAYED_LEGACY_INAPPS_TABLE);
        }
    }

    private final String getDeviceIdForAccountIdFromPrefs(String accountId) {
        String str = "deviceId:" + accountId;
        String str2 = "fallbackId:" + accountId;
        String string = StorageHelper.getString(this.context, str, null);
        if (string != null) {
            return string;
        }
        String string2 = StorageHelper.getString(this.context, str2, "");
        return string2 == null ? "" : string2;
    }

    private final void migrateUserProfilesTable(SQLiteDatabase db) {
        executeStatement(db, CtDatabaseKt.CREATE_TEMP_USER_PROFILES_TABLE);
        String deviceIdForAccountIdFromPrefs = getDeviceIdForAccountIdFromPrefs(this.accountId);
        Cursor cursorRawQuery = db.rawQuery("SELECT _id, data FROM " + Table.USER_PROFILES.getTableName() + ';', null);
        Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "rawQuery(...)");
        Cursor cursor = cursorRawQuery;
        try {
            if (cursorRawQuery.moveToFirst()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("_id"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("data"));
                Intrinsics.checkNotNull(string2);
                executeStatement(db, "INSERT INTO temp_" + Table.USER_PROFILES.getTableName() + " (_id, deviceID, data)\n                                 VALUES ('" + string + "', '" + deviceIdForAccountIdFromPrefs + "', '" + migrateDataString(string2) + "');");
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
            executeStatement(db, CtDatabaseKt.DROP_USER_PROFILES_TABLE);
            executeStatement(db, CtDatabaseKt.RENAME_USER_PROFILES_TABLE);
        } finally {
        }
    }

    private final String migrateDataString(String dataString) {
        try {
            JSONObject jSONObject = new JSONObject(dataString);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objValueOf = jSONObject.get(next);
                if ((objValueOf instanceof String) && StringsKt.startsWith$default((String) objValueOf, Constants.DATE_PREFIX, false, 2, (Object) null)) {
                    objValueOf = Long.valueOf(Long.parseLong(StringsKt.removePrefix((String) objValueOf, (CharSequence) Constants.DATE_PREFIX)));
                    jSONObject.put(next, ((Number) objValueOf).longValue());
                }
                if (objValueOf instanceof JSONObject) {
                    if (!((JSONObject) objValueOf).has(Constants.COMMAND_SET)) {
                        if (((JSONObject) objValueOf).has(Constants.COMMAND_ADD)) {
                            jSONObject.put(next, ((JSONObject) objValueOf).getJSONArray(Constants.COMMAND_ADD));
                        }
                    } else {
                        jSONObject.put(next, ((JSONObject) objValueOf).getJSONArray(Constants.COMMAND_SET));
                    }
                }
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            this.logger.verbose("Error while migrating data column for userProfiles table for data = " + dataString, e2);
            return dataString;
        }
    }

    public final boolean belowMemThreshold() {
        return !this.databaseFile.exists() || Math.max(this.databaseFile.getUsableSpace(), 25165824L) >= this.databaseFile.length();
    }

    public final void deleteDatabase() {
        close();
        if (this.databaseFile.delete()) {
            return;
        }
        this.logger.debug("Could not delete database");
    }

    private final void executeStatement(SQLiteDatabase db, String statement) {
        SQLiteStatement sQLiteStatementCompileStatement = db.compileStatement(statement);
        this.logger.verbose("Executing - " + statement);
        sQLiteStatementCompileStatement.execute();
    }
}
