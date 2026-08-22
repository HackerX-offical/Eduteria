package com.clevertap.android.sdk.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.DBEncryptionHandler;
import com.clevertap.android.sdk.db.DatabaseHelper;
import com.clevertap.android.sdk.db.QueueData;
import com.clevertap.android.sdk.db.Table;
import com.clevertap.android.sdk.utils.Clock;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventDAOImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/clevertap/android/sdk/db/dao/EventDAOImpl;", "Lcom/clevertap/android/sdk/db/dao/EventDAO;", "dbHelper", "Lcom/clevertap/android/sdk/db/DatabaseHelper;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "dbEncryptionHandler", "Lcom/clevertap/android/sdk/db/DBEncryptionHandler;", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "<init>", "(Lcom/clevertap/android/sdk/db/DatabaseHelper;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/db/DBEncryptionHandler;Lcom/clevertap/android/sdk/utils/Clock;)V", "storeEvent", "", "event", "Lorg/json/JSONObject;", "table", "Lcom/clevertap/android/sdk/db/Table;", "fetchEvents", "Lcom/clevertap/android/sdk/db/QueueData;", Constants.KEY_LIMIT, "", "fetchCombinedEvents", "batchSize", "cleanupEventsFromLastId", "", "lastId", "", "cleanupStaleEvents", "removeAllEvents", "updateAllEvents", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EventDAOImpl implements EventDAO {
    private static final long DATA_EXPIRATION = 432000000;
    private final Clock clock;
    private final DBEncryptionHandler dbEncryptionHandler;
    private final DatabaseHelper dbHelper;
    private final ILogger logger;

    public EventDAOImpl(DatabaseHelper dbHelper, ILogger logger, DBEncryptionHandler dbEncryptionHandler, Clock clock) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(dbEncryptionHandler, "dbEncryptionHandler");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.dbHelper = dbHelper;
        this.logger = logger;
        this.dbEncryptionHandler = dbEncryptionHandler;
        this.clock = clock;
    }

    public /* synthetic */ EventDAOImpl(DatabaseHelper databaseHelper, ILogger iLogger, DBEncryptionHandler dBEncryptionHandler, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(databaseHelper, iLogger, dBEncryptionHandler, (i & 8) != 0 ? Clock.SYSTEM : clock);
    }

    @Override // com.clevertap.android.sdk.db.dao.EventDAO
    public long storeEvent(JSONObject event, Table table) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(table, "table");
        if (!this.dbHelper.belowMemThreshold()) {
            this.logger.verbose(DBAdapter.NOT_ENOUGH_SPACE_LOG);
            return -2L;
        }
        String tableName = table.getTableName();
        ContentValues contentValues = new ContentValues();
        DBEncryptionHandler dBEncryptionHandler = this.dbEncryptionHandler;
        String string = event.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        contentValues.put("data", dBEncryptionHandler.wrapDbData(string));
        contentValues.put(Column.CREATED_AT, Long.valueOf(this.clock.currentTimeMillis()));
        try {
            return this.dbHelper.getWritableDatabase().insert(tableName, null, contentValues);
        } catch (Exception e2) {
            this.logger.verbose("Error adding data to table " + tableName + ". Recreating DB", e2);
            this.dbHelper.deleteDatabase();
            return -1L;
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.EventDAO
    public synchronized QueueData fetchEvents(Table table, int limit) {
        QueueData queueData;
        int size;
        Intrinsics.checkNotNullParameter(table, "table");
        queueData = new QueueData();
        String tableName = table.getTableName();
        try {
            int i = 0;
            boolean z = true;
            Cursor cursorQuery = this.dbHelper.getReadableDatabase().query(tableName, new String[]{"_id", "data", Column.CREATED_AT}, null, null, null, null, "created_at ASC", String.valueOf(limit + 1));
            try {
                Cursor cursor = cursorQuery;
                if (cursor.getCount() <= limit) {
                    z = false;
                }
                queueData.setHasMore$clevertap_core_release(z);
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("data");
                while (cursor.moveToNext() && i != limit) {
                    String string = cursor.getString(columnIndexOrThrow);
                    String strUnwrapDbData = this.dbEncryptionHandler.unwrapDbData(cursor.getString(columnIndexOrThrow2));
                    if (strUnwrapDbData == null) {
                        this.logger.verbose("Error parsing event data for id: " + string + " from table: " + tableName);
                    } else {
                        queueData.getData().put(new JSONObject(strUnwrapDbData));
                        if (table == Table.PROFILE_EVENTS) {
                            List<String> profileEventIds$clevertap_core_release = queueData.getProfileEventIds$clevertap_core_release();
                            Intrinsics.checkNotNull(string);
                            profileEventIds$clevertap_core_release.add(string);
                        } else {
                            List<String> eventIds$clevertap_core_release = queueData.getEventIds$clevertap_core_release();
                            Intrinsics.checkNotNull(string);
                            eventIds$clevertap_core_release.add(string);
                        }
                        i++;
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
            } finally {
            }
        } catch (Exception e2) {
            this.logger.verbose("Could not fetch records from table " + tableName, e2);
        }
        if (table == Table.PROFILE_EVENTS) {
            size = queueData.getProfileEventIds$clevertap_core_release().size();
        } else {
            size = queueData.getEventIds$clevertap_core_release().size();
        }
        this.logger.verbose("Fetched " + size + " events from " + tableName);
        return queueData;
    }

    @Override // com.clevertap.android.sdk.db.dao.EventDAO
    public synchronized QueueData fetchCombinedEvents(int batchSize) {
        QueueData queueData;
        queueData = new QueueData();
        QueueData queueDataFetchEvents = fetchEvents(Table.PROFILE_EVENTS, batchSize);
        int length = queueDataFetchEvents.getData().length();
        for (int i = 0; i < length; i++) {
            queueData.getData().put(queueDataFetchEvents.getData().getJSONObject(i));
        }
        queueData.getProfileEventIds$clevertap_core_release().addAll(queueDataFetchEvents.getProfileEventIds$clevertap_core_release());
        queueData.setHasMore$clevertap_core_release(queueDataFetchEvents.getHasMore());
        int size = batchSize - queueData.getProfileEventIds$clevertap_core_release().size();
        if (size > 0 || !queueData.getHasMore()) {
            QueueData queueDataFetchEvents2 = fetchEvents(Table.EVENTS, size);
            int length2 = queueDataFetchEvents2.getData().length();
            for (int i2 = 0; i2 < length2; i2++) {
                queueData.getData().put(queueDataFetchEvents2.getData().getJSONObject(i2));
            }
            queueData.getEventIds$clevertap_core_release().addAll(queueDataFetchEvents2.getEventIds$clevertap_core_release());
            queueData.setHasMore$clevertap_core_release(queueDataFetchEvents2.getHasMore());
        }
        this.logger.verbose("Fetched combined batch: " + queueData.getProfileEventIds$clevertap_core_release().size() + " profile events, " + queueData.getEventIds$clevertap_core_release().size() + " events");
        return queueData;
    }

    @Override // com.clevertap.android.sdk.db.dao.EventDAO
    public synchronized void cleanupEventsFromLastId(String lastId, Table table) {
        Intrinsics.checkNotNullParameter(lastId, "lastId");
        Intrinsics.checkNotNullParameter(table, "table");
        String tableName = table.getTableName();
        try {
            this.dbHelper.getWritableDatabase().delete(tableName, "_id <= ?", new String[]{lastId});
        } catch (SQLiteException e2) {
            this.logger.verbose("Error removing sent data from table " + tableName + " Recreating DB", e2);
            this.dbHelper.deleteDatabase();
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.EventDAO
    public void cleanupStaleEvents(Table table) {
        Intrinsics.checkNotNullParameter(table, "table");
        long jCurrentTimeMillis = this.clock.currentTimeMillis() - DATA_EXPIRATION;
        String tableName = table.getTableName();
        try {
            this.dbHelper.getWritableDatabase().delete(tableName, "created_at <= " + jCurrentTimeMillis, null);
        } catch (Exception e2) {
            this.logger.verbose("Error removing stale event records from " + tableName + ". Recreating DB.", e2);
            this.dbHelper.deleteDatabase();
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.EventDAO
    public void removeAllEvents(Table table) {
        Intrinsics.checkNotNullParameter(table, "table");
        String tableName = table.getTableName();
        try {
            this.dbHelper.getWritableDatabase().delete(tableName, null, null);
        } catch (Exception e2) {
            this.logger.verbose("Error removing all events from table " + tableName + ". Recreating DB", e2);
            this.dbHelper.deleteDatabase();
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.EventDAO
    public synchronized int updateAllEvents(Table table) {
        int i;
        Intrinsics.checkNotNullParameter(table, "table");
        String tableName = table.getTableName();
        try {
            Cursor cursorQuery = this.dbHelper.getReadableDatabase().query(tableName, new String[]{"_id", "data"}, null, null, null, null, null);
            try {
                Cursor cursor = cursorQuery;
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("data");
                i = 0;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(columnIndexOrThrow);
                    String string2 = cursor.getString(columnIndexOrThrow2);
                    if (string2 == null || !this.dbEncryptionHandler.isInCorrectEncryptionFormat(string2)) {
                        String strUnwrapDbData = this.dbEncryptionHandler.unwrapDbData(string2);
                        if (strUnwrapDbData == null) {
                            this.logger.verbose("Error decrypting data for id: " + string + " from table: " + tableName + ", skipping");
                        } else {
                            String strWrapDbData = this.dbEncryptionHandler.wrapDbData(strUnwrapDbData);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("data", strWrapDbData);
                            if (this.dbHelper.getWritableDatabase().update(tableName, contentValues, "_id = ?", new String[]{string}) > 0) {
                                i++;
                            }
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
                this.logger.verbose("Successfully migrated " + i + " rows in table " + tableName);
            } finally {
            }
        } catch (Exception e2) {
            this.logger.verbose("Error updating all events in table " + tableName + ". Recreating DB", e2);
            this.dbHelper.deleteDatabase();
            return -1;
        }
        return i;
    }
}
