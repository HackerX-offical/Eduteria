package com.clevertap.android.sdk.usereventlogs;

import android.content.ContentValues;
import android.database.Cursor;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.DatabaseHelper;
import com.clevertap.android.sdk.db.Table;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UserEventLogDAOImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0017J*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00150\u0014H\u0017J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0017J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0017J \u0010\u001b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0019H\u0017J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\f\u001a\u00020\rH\u0017J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0017J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/clevertap/android/sdk/usereventlogs/UserEventLogDAOImpl;", "Lcom/clevertap/android/sdk/usereventlogs/UserEventLogDAO;", UserDataStore.DATE_OF_BIRTH, "Lcom/clevertap/android/sdk/db/DatabaseHelper;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "table", "Lcom/clevertap/android/sdk/db/Table;", "<init>", "(Lcom/clevertap/android/sdk/db/DatabaseHelper;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/db/Table;)V", "insertEvent", "", Column.DEVICE_ID, "", "eventName", Column.NORMALIZED_EVENT_NAME, "updateEventByDeviceIdAndNormalizedEventName", "", "upsertEventsByDeviceIdAndNormalizedEventName", "setOfActualAndNormalizedEventNamePair", "", "Lkotlin/Pair;", "readEventByDeviceIdAndNormalizedEventName", "Lcom/clevertap/android/sdk/usereventlogs/UserEventLog;", "readEventCountByDeviceIdAndNormalizedEventName", "", "eventExistsByDeviceIdAndNormalizedEventName", "eventExistsByDeviceIdAndNormalizedEventNameAndCount", "count", "allEventsByDeviceID", "", "allEvents", "cleanUpExtraEvents", "threshold", "numberOfRowsToCleanup", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserEventLogDAOImpl implements UserEventLogDAO {
    private final DatabaseHelper db;
    private final ILogger logger;
    private final Table table;

    public UserEventLogDAOImpl(DatabaseHelper db, ILogger logger, Table table) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(table, "table");
        this.db = db;
        this.logger = logger;
        this.table = table;
    }

    public /* synthetic */ UserEventLogDAOImpl(DatabaseHelper databaseHelper, ILogger iLogger, Table table, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(databaseHelper, iLogger, (i & 4) != 0 ? Table.USER_EVENT_LOGS_TABLE : table);
    }

    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    public long insertEvent(String deviceID, String eventName, String normalizedEventName) {
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(normalizedEventName, "normalizedEventName");
        if (!this.db.belowMemThreshold()) {
            this.logger.verbose(DBAdapter.NOT_ENOUGH_SPACE_LOG);
            return -2L;
        }
        String tableName = this.table.getTableName();
        this.logger.verbose("Inserting event " + eventName + " with deviceID = " + deviceID + " in " + tableName);
        long nowInMillis = Utils.getNowInMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventName", eventName);
        contentValues.put(Column.NORMALIZED_EVENT_NAME, normalizedEventName);
        contentValues.put(Column.FIRST_TS, Long.valueOf(nowInMillis));
        contentValues.put(Column.LAST_TS, Long.valueOf(nowInMillis));
        contentValues.put("count", (Integer) 1);
        contentValues.put(Column.DEVICE_ID, deviceID);
        try {
            return this.db.getWritableDatabase().insertWithOnConflict(tableName, null, contentValues, 5);
        } catch (Exception e2) {
            this.logger.verbose("Error adding row to table " + tableName + " Recreating DB. Exception: " + e2);
            this.db.deleteDatabase();
            return -1L;
        }
    }

    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    public boolean updateEventByDeviceIdAndNormalizedEventName(String deviceID, String normalizedEventName) {
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        Intrinsics.checkNotNullParameter(normalizedEventName, "normalizedEventName");
        String tableName = this.table.getTableName();
        long nowInMillis = Utils.getNowInMillis();
        try {
            String strTrimIndent = StringsKt.trimIndent("\n            UPDATE " + tableName + " \n            SET \n                count = count + 1,\n                lastTs = ?\n            WHERE deviceID = ? \n            AND normalizedEventName = ?;\n        ");
            this.logger.verbose("Updating event " + normalizedEventName + " with deviceID = " + deviceID + " in " + tableName);
            this.db.getWritableDatabase().execSQL(strTrimIndent, new Object[]{Long.valueOf(nowInMillis), deviceID, normalizedEventName});
            return true;
        } catch (Exception e2) {
            this.logger.verbose("Could not update event in database " + tableName + '.', e2);
            return false;
        }
    }

    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    public boolean upsertEventsByDeviceIdAndNormalizedEventName(String deviceID, Set<Pair<String, String>> setOfActualAndNormalizedEventNamePair) {
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        Intrinsics.checkNotNullParameter(setOfActualAndNormalizedEventNamePair, "setOfActualAndNormalizedEventNamePair");
        String tableName = this.table.getTableName();
        this.logger.verbose("UserEventLog: upsert EventLog for bulk events");
        try {
            this.db.getWritableDatabase().beginTransaction();
            Iterator<T> it = setOfActualAndNormalizedEventNamePair.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (eventExistsByDeviceIdAndNormalizedEventName(deviceID, (String) pair.getSecond())) {
                    this.logger.verbose("UserEventLog: Updating EventLog for event " + pair);
                    updateEventByDeviceIdAndNormalizedEventName(deviceID, (String) pair.getSecond());
                } else {
                    this.logger.verbose("UserEventLog: Inserting EventLog for event " + pair);
                    insertEvent(deviceID, (String) pair.getFirst(), (String) pair.getSecond());
                }
            }
            this.db.getWritableDatabase().setTransactionSuccessful();
            this.db.getWritableDatabase().endTransaction();
            return true;
        } catch (Exception e2) {
            this.logger.verbose("Failed to perform bulk upsert on table " + tableName, e2);
            try {
                this.db.getWritableDatabase().endTransaction();
                return false;
            } catch (Exception e3) {
                this.logger.verbose("Failed to end transaction on table " + tableName, e3);
                return false;
            }
        }
    }

    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    public UserEventLog readEventByDeviceIdAndNormalizedEventName(String deviceID, String normalizedEventName) {
        UserEventLog userEventLog;
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        Intrinsics.checkNotNullParameter(normalizedEventName, "normalizedEventName");
        String tableName = this.table.getTableName();
        try {
            Cursor cursorQuery = this.db.getReadableDatabase().query(tableName, null, "deviceID = ? AND normalizedEventName = ?", new String[]{deviceID, normalizedEventName}, null, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    String string = cursor2.getString(cursor2.getColumnIndexOrThrow("eventName"));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = cursor2.getString(cursor2.getColumnIndexOrThrow(Column.NORMALIZED_EVENT_NAME));
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    long j = cursor2.getLong(cursor2.getColumnIndexOrThrow(Column.FIRST_TS));
                    long j2 = cursor2.getLong(cursor2.getColumnIndexOrThrow(Column.LAST_TS));
                    int i = cursor2.getInt(cursor2.getColumnIndexOrThrow("count"));
                    String string3 = cursor2.getString(cursor2.getColumnIndexOrThrow(Column.DEVICE_ID));
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    userEventLog = new UserEventLog(string, string2, j, j2, i, string3);
                } else {
                    userEventLog = null;
                }
                CloseableKt.closeFinally(cursor, null);
                return userEventLog;
            } finally {
            }
        } catch (Exception e2) {
            this.logger.verbose("Could not fetch records out of database " + tableName + '.', e2);
            return null;
        }
    }

    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    public int readEventCountByDeviceIdAndNormalizedEventName(String deviceID, String normalizedEventName) {
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        Intrinsics.checkNotNullParameter(normalizedEventName, "normalizedEventName");
        String tableName = this.table.getTableName();
        try {
            Cursor cursorQuery = this.db.getReadableDatabase().query(tableName, new String[]{"count"}, "deviceID = ? AND normalizedEventName = ?", new String[]{deviceID, normalizedEventName}, null, null, null, null);
            if (cursorQuery == null) {
                return -1;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                int i = cursor2.moveToFirst() ? cursor2.getInt(cursor2.getColumnIndexOrThrow("count")) : 0;
                CloseableKt.closeFinally(cursor, null);
                return i;
            } finally {
            }
        } catch (Exception e2) {
            this.logger.verbose("Could not fetch records out of database " + tableName + '.', e2);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean eventExistsByDeviceIdAndNormalizedEventName(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "deviceID"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "normalizedEventName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.clevertap.android.sdk.db.Table r0 = r5.table
            java.lang.String r0 = r0.getTableName()
            r1 = 2
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = 0
            r1[r2] = r6
            r6 = 1
            r1[r6] = r7
            java.lang.String r7 = "eventExists"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "\n            SELECT EXISTS(\n                SELECT 1 \n                FROM "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = " \n                WHERE deviceID = ? AND normalizedEventName = ?\n            ) AS eventExists;\n        "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = kotlin.text.StringsKt.trimIndent(r3)
            com.clevertap.android.sdk.db.DatabaseHelper r4 = r5.db     // Catch: java.lang.Exception -> L64
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch: java.lang.Exception -> L64
            android.database.Cursor r1 = r4.rawQuery(r3, r1)     // Catch: java.lang.Exception -> L64
            if (r1 == 0) goto L63
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch: java.lang.Exception -> L64
            r3 = r1
            android.database.Cursor r3 = (android.database.Cursor) r3     // Catch: java.lang.Throwable -> L5c
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L56
            int r7 = r3.getColumnIndexOrThrow(r7)     // Catch: java.lang.Throwable -> L5c
            int r7 = r3.getInt(r7)     // Catch: java.lang.Throwable -> L5c
            if (r7 != r6) goto L56
            goto L57
        L56:
            r6 = r2
        L57:
            r7 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r7)     // Catch: java.lang.Exception -> L64
            return r6
        L5c:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L5e
        L5e:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r6)     // Catch: java.lang.Exception -> L64
            throw r7     // Catch: java.lang.Exception -> L64
        L63:
            return r2
        L64:
            r6 = move-exception
            com.clevertap.android.sdk.ILogger r7 = r5.logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Could not fetch records out of database "
            r1.<init>(r3)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 46
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r7.verbose(r0, r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.usereventlogs.UserEventLogDAOImpl.eventExistsByDeviceIdAndNormalizedEventName(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d  */
    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean eventExistsByDeviceIdAndNormalizedEventNameAndCount(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "deviceID"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "normalizedEventName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.clevertap.android.sdk.db.Table r0 = r4.table
            java.lang.String r0 = r0.getTableName()
            r1 = 3
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = 0
            r1[r2] = r5
            r5 = 1
            r1[r5] = r6
            r6 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r1[r6] = r7
            java.lang.String r6 = "eventExists"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r3 = "\n            SELECT EXISTS(\n                SELECT 1 \n                FROM "
            r7.<init>(r3)
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r3 = " \n                WHERE deviceID = ? AND normalizedEventName = ? AND count = ?\n                ) AS eventExists;\n        "
            java.lang.StringBuilder r7 = r7.append(r3)
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = kotlin.text.StringsKt.trimIndent(r7)
            com.clevertap.android.sdk.db.DatabaseHelper r3 = r4.db     // Catch: java.lang.Exception -> L6b
            android.database.sqlite.SQLiteDatabase r3 = r3.getReadableDatabase()     // Catch: java.lang.Exception -> L6b
            android.database.Cursor r7 = r3.rawQuery(r7, r1)     // Catch: java.lang.Exception -> L6b
            if (r7 == 0) goto L6a
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch: java.lang.Exception -> L6b
            r1 = r7
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch: java.lang.Throwable -> L63
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L63
            if (r3 == 0) goto L5d
            int r6 = r1.getColumnIndexOrThrow(r6)     // Catch: java.lang.Throwable -> L63
            int r6 = r1.getInt(r6)     // Catch: java.lang.Throwable -> L63
            if (r6 != r5) goto L5d
            goto L5e
        L5d:
            r5 = r2
        L5e:
            r6 = 0
            kotlin.io.CloseableKt.closeFinally(r7, r6)     // Catch: java.lang.Exception -> L6b
            return r5
        L63:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L65
        L65:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r5)     // Catch: java.lang.Exception -> L6b
            throw r6     // Catch: java.lang.Exception -> L6b
        L6a:
            return r2
        L6b:
            r5 = move-exception
            com.clevertap.android.sdk.ILogger r6 = r4.logger
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not fetch records out of database "
            r7.<init>(r1)
            java.lang.StringBuilder r7 = r7.append(r0)
            r0 = 46
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.verbose(r7, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.usereventlogs.UserEventLogDAOImpl.eventExistsByDeviceIdAndNormalizedEventNameAndCount(java.lang.String, java.lang.String, int):boolean");
    }

    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    public List<UserEventLog> allEventsByDeviceID(String deviceID) {
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        String tableName = this.table.getTableName();
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.db.getReadableDatabase().query(tableName, null, "deviceID = ?", new String[]{deviceID}, null, null, "lastTs ASC", null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    while (cursor2.moveToNext()) {
                        String string = cursor2.getString(cursor2.getColumnIndexOrThrow("eventName"));
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = cursor2.getString(cursor2.getColumnIndexOrThrow(Column.NORMALIZED_EVENT_NAME));
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        long j = cursor2.getLong(cursor2.getColumnIndexOrThrow(Column.FIRST_TS));
                        long j2 = cursor2.getLong(cursor2.getColumnIndexOrThrow(Column.LAST_TS));
                        int i = cursor2.getInt(cursor2.getColumnIndexOrThrow("count"));
                        String string3 = cursor2.getString(cursor2.getColumnIndexOrThrow(Column.DEVICE_ID));
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        arrayList.add(new UserEventLog(string, string2, j, j2, i, string3));
                    }
                    CloseableKt.closeFinally(cursor, null);
                    return arrayList;
                } finally {
                }
            } else {
                return CollectionsKt.emptyList();
            }
        } catch (Exception e2) {
            this.logger.verbose("Could not fetch records out of database " + tableName + '.', e2);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    public List<UserEventLog> allEvents() {
        String tableName = this.table.getTableName();
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.db.getReadableDatabase().query(tableName, null, null, null, null, null, "lastTs ASC");
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    while (cursor2.moveToNext()) {
                        String string = cursor2.getString(cursor2.getColumnIndexOrThrow("eventName"));
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = cursor2.getString(cursor2.getColumnIndexOrThrow(Column.NORMALIZED_EVENT_NAME));
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        long j = cursor2.getLong(cursor2.getColumnIndexOrThrow(Column.FIRST_TS));
                        long j2 = cursor2.getLong(cursor2.getColumnIndexOrThrow(Column.LAST_TS));
                        int i = cursor2.getInt(cursor2.getColumnIndexOrThrow("count"));
                        String string3 = cursor2.getString(cursor2.getColumnIndexOrThrow(Column.DEVICE_ID));
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        arrayList.add(new UserEventLog(string, string2, j, j2, i, string3));
                    }
                    CloseableKt.closeFinally(cursor, null);
                    return arrayList;
                } finally {
                }
            } else {
                return CollectionsKt.emptyList();
            }
        } catch (Exception e2) {
            this.logger.verbose("Could not fetch records out of database " + tableName + '.', e2);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.clevertap.android.sdk.usereventlogs.UserEventLogDAO
    public boolean cleanUpExtraEvents(int threshold, int numberOfRowsToCleanup) {
        if (threshold <= 0) {
            this.logger.verbose("Invalid threshold value: " + threshold + ". Threshold should be greater than 0");
            return false;
        }
        if (numberOfRowsToCleanup < 0) {
            this.logger.verbose("Invalid numberOfRowsToCleanup value: " + numberOfRowsToCleanup + ". Should be greater than or equal to 0");
            return false;
        }
        if (numberOfRowsToCleanup >= threshold) {
            this.logger.verbose("Invalid numberOfRowsToCleanup value: " + numberOfRowsToCleanup + ". Should be less than threshold: " + threshold);
            return false;
        }
        String tableName = this.table.getTableName();
        int i = threshold - numberOfRowsToCleanup;
        try {
            this.db.getWritableDatabase().execSQL(StringsKt.trimIndent("\n            DELETE FROM " + tableName + "\n            WHERE (normalizedEventName, deviceID) IN (\n                SELECT normalizedEventName, deviceID\n                FROM " + tableName + "\n                ORDER BY lastTs ASC \n                LIMIT (\n                SELECT CASE \n                    WHEN COUNT(*) > ? THEN COUNT(*) - ?\n                    ELSE 0\n                END \n                FROM " + tableName + "\n                )\n            );\n        "), new Integer[]{Integer.valueOf(threshold), Integer.valueOf(i)});
            this.logger.verbose("If row count is above " + threshold + " then only keep " + i + " rows in " + tableName);
            return true;
        } catch (Exception e2) {
            this.logger.verbose("Error cleaning up extra events in " + tableName + '.', e2);
            return false;
        }
    }
}
