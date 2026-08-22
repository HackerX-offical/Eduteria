package com.clevertap.android.sdk.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.DatabaseHelper;
import com.clevertap.android.sdk.db.Table;
import com.clevertap.android.sdk.utils.Clock;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushNotificationDAOImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0017¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u001b\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0017¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\rH\u0017J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/clevertap/android/sdk/db/dao/PushNotificationDAOImpl;", "Lcom/clevertap/android/sdk/db/dao/PushNotificationDAO;", "dbHelper", "Lcom/clevertap/android/sdk/db/DatabaseHelper;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "<init>", "(Lcom/clevertap/android/sdk/db/DatabaseHelper;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/utils/Clock;)V", "rtlDirtyFlag", "", "storePushNotificationId", "", "id", "", "ttlInSeconds", "", "fetchPushNotificationIds", "", "()[Ljava/lang/String;", "doesPushNotificationIdExist", "updatePushNotificationIds", "ids", "([Ljava/lang/String;)V", "cleanUpPushNotifications", "fetchPushNotificationId", "getTemplateMarkersList", "count", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PushNotificationDAOImpl implements PushNotificationDAO {
    private final Clock clock;
    private final DatabaseHelper dbHelper;
    private final ILogger logger;
    private volatile boolean rtlDirtyFlag;

    public PushNotificationDAOImpl(DatabaseHelper dbHelper, ILogger logger, Clock clock) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.dbHelper = dbHelper;
        this.logger = logger;
        this.clock = clock;
        this.rtlDirtyFlag = true;
    }

    public /* synthetic */ PushNotificationDAOImpl(DatabaseHelper databaseHelper, ILogger iLogger, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(databaseHelper, iLogger, (i & 4) != 0 ? Clock.SYSTEM : clock);
    }

    @Override // com.clevertap.android.sdk.db.dao.PushNotificationDAO
    public void storePushNotificationId(String id, long ttlInSeconds) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (!this.dbHelper.belowMemThreshold()) {
            this.logger.verbose(DBAdapter.NOT_ENOUGH_SPACE_LOG);
            return;
        }
        String tableName = Table.PUSH_NOTIFICATIONS.getTableName();
        if (ttlInSeconds <= 0) {
            ttlInSeconds = this.clock.currentTimeSeconds() + Constants.DEFAULT_PUSH_TTL_SECONDS;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", id);
        contentValues.put(Column.CREATED_AT, Long.valueOf(ttlInSeconds));
        contentValues.put("isRead", (Integer) 0);
        try {
            this.dbHelper.getWritableDatabase().insert(tableName, null, contentValues);
            this.rtlDirtyFlag = true;
            this.logger.verbose("Stored PN - " + id + " with TTL - " + ttlInSeconds);
        } catch (SQLiteException e2) {
            this.logger.verbose("Error adding data to table " + tableName + ". Recreating DB", e2);
            this.dbHelper.deleteDatabase();
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.PushNotificationDAO
    public String[] fetchPushNotificationIds() {
        if (!this.rtlDirtyFlag) {
            return new String[0];
        }
        String tableName = Table.PUSH_NOTIFICATIONS.getTableName();
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.dbHelper.getReadableDatabase().query(tableName, null, "isRead = 0", null, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    while (cursor2.moveToNext()) {
                        int columnIndex = cursor2.getColumnIndex("data");
                        if (columnIndex >= 0) {
                            String string = cursor2.getString(columnIndex);
                            this.logger.verbose("Fetching PID - " + string);
                            if (string != null) {
                                arrayList.add(string);
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
        } catch (SQLiteException e2) {
            this.logger.verbose("Could not fetch records out of database " + tableName + '.', e2);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.clevertap.android.sdk.db.dao.PushNotificationDAO
    public boolean doesPushNotificationIdExist(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return Intrinsics.areEqual(id, fetchPushNotificationId(id));
    }

    @Override // com.clevertap.android.sdk.db.dao.PushNotificationDAO
    public void updatePushNotificationIds(String[] ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        if (ids.length == 0) {
            return;
        }
        if (!this.dbHelper.belowMemThreshold()) {
            this.logger.verbose(DBAdapter.NOT_ENOUGH_SPACE_LOG);
            return;
        }
        String tableName = Table.PUSH_NOTIFICATIONS.getTableName();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", (Integer) 1);
        try {
            this.dbHelper.getWritableDatabase().update(tableName, contentValues, "data IN (" + getTemplateMarkersList(ids.length) + ')', ids);
            this.rtlDirtyFlag = false;
        } catch (SQLiteException e2) {
            this.logger.verbose("Error updating data in table " + tableName + ". Recreating DB", e2);
            this.dbHelper.deleteDatabase();
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.PushNotificationDAO
    public void cleanUpPushNotifications() {
        long jCurrentTimeSeconds = this.clock.currentTimeSeconds();
        String tableName = Table.PUSH_NOTIFICATIONS.getTableName();
        try {
            this.dbHelper.getWritableDatabase().delete(tableName, "created_at <= " + jCurrentTimeSeconds, null);
        } catch (SQLiteException e2) {
            this.logger.verbose("Error removing stale push notification records from " + tableName + ". Recreating DB.", e2);
            this.dbHelper.deleteDatabase();
        }
    }

    private final String fetchPushNotificationId(String id) {
        Exception exc;
        String tableName = Table.PUSH_NOTIFICATIONS.getTableName();
        String string = "";
        try {
            Cursor cursorQuery = this.dbHelper.getReadableDatabase().query(tableName, null, "data = ?", new String[]{id}, null, null, null);
            if (cursorQuery == null) {
                return "";
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    string = cursor2.getString(cursor2.getColumnIndexOrThrow("data"));
                }
                this.logger.verbose("Fetching PID for check - " + string);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
                return string;
            } catch (Throwable th) {
                String str = string;
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        CloseableKt.closeFinally(cursor, th);
                        throw th2;
                    } catch (Exception e2) {
                        exc = e2;
                        string = str;
                    }
                }
            }
        } catch (Exception e3) {
            exc = e3;
        }
        this.logger.verbose("Could not fetch records out of database " + tableName + '.', exc);
        return string;
    }

    private final String getTemplateMarkersList(int count) {
        StringBuilder sb = new StringBuilder();
        if (count > 0) {
            sb.append("?");
            int i = count - 1;
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(", ?");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
