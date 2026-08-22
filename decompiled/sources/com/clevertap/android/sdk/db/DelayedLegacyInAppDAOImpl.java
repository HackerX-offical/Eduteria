package com.clevertap.android.sdk.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.utils.Clock;
import com.facebook.appevents.UserDataStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DelayedLegacyInAppDAO.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0017J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0015\u001a\u00020\rH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/db/DelayedLegacyInAppDAOImpl;", "Lcom/clevertap/android/sdk/db/DelayedLegacyInAppDAO;", UserDataStore.DATE_OF_BIRTH, "Lcom/clevertap/android/sdk/db/DatabaseHelper;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "table", "Lcom/clevertap/android/sdk/db/Table;", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "<init>", "(Lcom/clevertap/android/sdk/db/DatabaseHelper;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/db/Table;Lcom/clevertap/android/sdk/utils/Clock;)V", "insertBatch", "", "delayedInApps", "", "Lcom/clevertap/android/sdk/db/DelayedLegacyInAppData;", "remove", Column.INAPP_ID, "", "fetchSingleInApp", "clearAll", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DelayedLegacyInAppDAOImpl implements DelayedLegacyInAppDAO {
    private final Clock clock;
    private final DatabaseHelper db;
    private final ILogger logger;
    private final Table table;

    public DelayedLegacyInAppDAOImpl(DatabaseHelper db, ILogger logger, Table table, Clock clock) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.db = db;
        this.logger = logger;
        this.table = table;
        this.clock = clock;
    }

    public /* synthetic */ DelayedLegacyInAppDAOImpl(DatabaseHelper databaseHelper, ILogger iLogger, Table table, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(databaseHelper, iLogger, table, (i & 8) != 0 ? Clock.SYSTEM : clock);
    }

    @Override // com.clevertap.android.sdk.db.DelayedLegacyInAppDAO
    public boolean insertBatch(List<DelayedLegacyInAppData> delayedInApps) {
        Intrinsics.checkNotNullParameter(delayedInApps, "delayedInApps");
        if (delayedInApps.isEmpty()) {
            this.logger.verbose("DelayedLegacyInAppDAO: Empty batch insert list");
            return true;
        }
        if (!this.db.belowMemThreshold()) {
            this.logger.verbose(DBAdapter.NOT_ENOUGH_SPACE_LOG);
            return false;
        }
        String tableName = this.table.getTableName();
        this.logger.verbose("DelayedLegacyInAppDAO: Batch insert for " + delayedInApps.size() + " delayed legacy in-apps");
        try {
            this.db.getWritableDatabase().beginTransaction();
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            for (DelayedLegacyInAppData delayedLegacyInAppData : delayedInApps) {
                this.logger.verbose("DelayedLegacyInAppDAO: Batch inserting " + delayedLegacyInAppData.getInAppId());
                ContentValues contentValues = new ContentValues();
                contentValues.put(Column.INAPP_ID, delayedLegacyInAppData.getInAppId());
                contentValues.put("delay", Integer.valueOf(delayedLegacyInAppData.getDelay()));
                contentValues.put("data", delayedLegacyInAppData.getInAppData());
                contentValues.put(Column.CREATED_AT, Long.valueOf(jCurrentTimeMillis));
                this.db.getWritableDatabase().insertWithOnConflict(tableName, null, contentValues, 5);
            }
            this.db.getWritableDatabase().setTransactionSuccessful();
            this.db.getWritableDatabase().endTransaction();
            this.logger.verbose("DelayedLegacyInAppDAO: Batch insert completed successfully for " + delayedInApps.size() + " items");
            return true;
        } catch (Exception e2) {
            this.logger.verbose("Failed to perform batch insert on table " + tableName, e2);
            try {
                this.db.getWritableDatabase().endTransaction();
            } catch (Exception e3) {
                this.logger.verbose("Failed to end transaction on table " + tableName, e3);
            }
            return false;
        }
    }

    @Override // com.clevertap.android.sdk.db.DelayedLegacyInAppDAO
    public boolean remove(String inAppId) {
        Intrinsics.checkNotNullParameter(inAppId, "inAppId");
        String tableName = this.table.getTableName();
        try {
            this.logger.verbose("Removing delayed legacy in-app: " + inAppId + " from " + tableName);
            return this.db.getWritableDatabase().delete(tableName, "inAppId = ?", new String[]{inAppId}) > 0;
        } catch (SQLiteException e2) {
            this.logger.verbose("Could not remove delayed legacy in-app from database " + tableName + '.', e2);
            return false;
        }
    }

    @Override // com.clevertap.android.sdk.db.DelayedLegacyInAppDAO
    public String fetchSingleInApp(String inAppId) {
        Intrinsics.checkNotNullParameter(inAppId, "inAppId");
        String tableName = this.table.getTableName();
        try {
            Cursor cursorQuery = this.db.getReadableDatabase().query(tableName, new String[]{"data"}, "inAppId = ?", new String[]{inAppId}, null, null, null, null);
            try {
                Cursor cursor = cursorQuery;
                String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndexOrThrow("data")) : null;
                CloseableKt.closeFinally(cursorQuery, null);
                return string;
            } finally {
            }
        } catch (Exception e2) {
            this.logger.verbose("Could not fetch delayed legacy in-app from database " + tableName + '.', e2);
            return null;
        }
    }

    @Override // com.clevertap.android.sdk.db.DelayedLegacyInAppDAO
    public boolean clearAll() {
        String tableName = this.table.getTableName();
        try {
            this.logger.verbose("Clearing all delayed legacy in-apps from " + tableName);
            this.db.getWritableDatabase().delete(tableName, null, null);
            this.logger.verbose("Successfully cleared all delayed legacy in-apps from " + tableName);
            return true;
        } catch (SQLiteException e2) {
            this.logger.verbose("Error clearing all delayed legacy in-apps from table " + tableName + '.', e2);
            return false;
        }
    }
}
