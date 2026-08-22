package com.clevertap.android.sdk.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.DatabaseHelper;
import com.clevertap.android.sdk.db.Table;
import com.clevertap.android.sdk.utils.Clock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UninstallTimestampDAOImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0017J\b\u0010\f\u001a\u00020\rH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/db/dao/UninstallTimestampDAOImpl;", "Lcom/clevertap/android/sdk/db/dao/UninstallTimestampDAO;", "dbHelper", "Lcom/clevertap/android/sdk/db/DatabaseHelper;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "<init>", "(Lcom/clevertap/android/sdk/db/DatabaseHelper;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/utils/Clock;)V", "storeUninstallTimestamp", "", "getLastUninstallTimestamp", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UninstallTimestampDAOImpl implements UninstallTimestampDAO {
    private final Clock clock;
    private final DatabaseHelper dbHelper;
    private final ILogger logger;

    public UninstallTimestampDAOImpl(DatabaseHelper dbHelper, ILogger logger, Clock clock) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.dbHelper = dbHelper;
        this.logger = logger;
        this.clock = clock;
    }

    public /* synthetic */ UninstallTimestampDAOImpl(DatabaseHelper databaseHelper, ILogger iLogger, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(databaseHelper, iLogger, (i & 4) != 0 ? Clock.SYSTEM : clock);
    }

    @Override // com.clevertap.android.sdk.db.dao.UninstallTimestampDAO
    public void storeUninstallTimestamp() {
        if (!this.dbHelper.belowMemThreshold()) {
            this.logger.verbose(DBAdapter.NOT_ENOUGH_SPACE_LOG);
            return;
        }
        String tableName = Table.UNINSTALL_TS.getTableName();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column.CREATED_AT, Long.valueOf(this.clock.currentTimeMillis()));
        try {
            this.dbHelper.getWritableDatabase().insert(tableName, null, contentValues);
        } catch (SQLiteException e2) {
            this.logger.verbose("Error adding data to table " + tableName + ". Recreating DB", e2);
            this.dbHelper.deleteDatabase();
        }
    }

    @Override // com.clevertap.android.sdk.db.dao.UninstallTimestampDAO
    public long getLastUninstallTimestamp() {
        String tableName = Table.UNINSTALL_TS.getTableName();
        try {
            Cursor cursorQuery = this.dbHelper.getReadableDatabase().query(tableName, null, null, null, null, null, "created_at DESC", "1");
            if (cursorQuery == null) {
                return 0L;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                j = cursor2.moveToFirst() ? cursor2.getLong(cursor2.getColumnIndexOrThrow(Column.CREATED_AT)) : 0L;
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
                return j;
            } finally {
            }
        } catch (Exception e2) {
            this.logger.verbose("Could not fetch records out of database " + tableName + '.', e2);
            return j;
        }
    }
}
