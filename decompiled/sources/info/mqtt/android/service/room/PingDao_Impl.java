package info.mqtt.android.service.room;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import info.mqtt.android.service.ping.PingWorker;
import info.mqtt.android.service.room.entity.PingEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: PingDao_Impl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\tH\u0016J!\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0018\"\u00020\tH\u0016¢\u0006\u0002\u0010\u0019J\u0019\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0003¢\u0006\u0002\b\u001aJ\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Linfo/mqtt/android/service/room/PingDao_Impl;", "Linfo/mqtt/android/service/room/PingDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "all", "Landroidx/lifecycle/LiveData;", "", "Linfo/mqtt/android/service/room/entity/PingEntity;", "getAll", "()Landroidx/lifecycle/LiveData;", "__insertAdapterOfPingEntity", "Landroidx/room/EntityInsertAdapter;", "__deleteAdapterOfPingEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfPingEntity", "insert", "", "pingEntity", "delete", "", "updateAll", "pingEntities", "", "([Linfo/mqtt/android/service/room/entity/PingEntity;)V", "_privateGetAll", "allByState", "statePing", "", "deleteState", "", "removeOldData", PingWorker.KEEP_RECORDS_COUNT, "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PingDao_Impl implements PingDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<PingEntity> __deleteAdapterOfPingEntity;
    private final EntityInsertAdapter<PingEntity> __insertAdapterOfPingEntity;
    private final EntityDeleteOrUpdateAdapter<PingEntity> __updateAdapterOfPingEntity;

    public PingDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfPingEntity = new EntityInsertAdapter<PingEntity>() { // from class: info.mqtt.android.service.room.PingDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `PingEntity` (`timestamp`,`clientId`,`serverURI`,`success`,`message`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, PingEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo9569bindLong(1, entity.getTimestamp());
                String clientId = entity.getClientId();
                if (clientId == null) {
                    statement.mo9570bindNull(2);
                } else {
                    statement.mo9571bindText(2, clientId);
                }
                String serverURI = entity.getServerURI();
                if (serverURI == null) {
                    statement.mo9570bindNull(3);
                } else {
                    statement.mo9571bindText(3, serverURI);
                }
                statement.mo9569bindLong(4, entity.getSuccess() ? 1L : 0L);
                String message = entity.getMessage();
                if (message == null) {
                    statement.mo9570bindNull(5);
                } else {
                    statement.mo9571bindText(5, message);
                }
            }
        };
        this.__deleteAdapterOfPingEntity = new EntityDeleteOrUpdateAdapter<PingEntity>() { // from class: info.mqtt.android.service.room.PingDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `PingEntity` WHERE `timestamp` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, PingEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo9569bindLong(1, entity.getTimestamp());
            }
        };
        this.__updateAdapterOfPingEntity = new EntityDeleteOrUpdateAdapter<PingEntity>() { // from class: info.mqtt.android.service.room.PingDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `PingEntity` SET `timestamp` = ?,`clientId` = ?,`serverURI` = ?,`success` = ?,`message` = ? WHERE `timestamp` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, PingEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo9569bindLong(1, entity.getTimestamp());
                String clientId = entity.getClientId();
                if (clientId == null) {
                    statement.mo9570bindNull(2);
                } else {
                    statement.mo9571bindText(2, clientId);
                }
                String serverURI = entity.getServerURI();
                if (serverURI == null) {
                    statement.mo9570bindNull(3);
                } else {
                    statement.mo9571bindText(3, serverURI);
                }
                statement.mo9569bindLong(4, entity.getSuccess() ? 1L : 0L);
                String message = entity.getMessage();
                if (message == null) {
                    statement.mo9570bindNull(5);
                } else {
                    statement.mo9571bindText(5, message);
                }
                statement.mo9569bindLong(6, entity.getTimestamp());
            }
        };
    }

    @Override // info.mqtt.android.service.room.PingDao
    public LiveData<List<PingEntity>> getAll() {
        return _privateGetAll();
    }

    @Override // info.mqtt.android.service.room.PingDao
    public long insert(final PingEntity pingEntity) {
        Intrinsics.checkNotNullParameter(pingEntity, "pingEntity");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.PingDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(PingDao_Impl.insert$lambda$0(this.f$0, pingEntity, (SQLiteConnection) obj));
            }
        })).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(PingDao_Impl pingDao_Impl, PingEntity pingEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return pingDao_Impl.__insertAdapterOfPingEntity.insertAndReturnId(_connection, pingEntity);
    }

    @Override // info.mqtt.android.service.room.PingDao
    public void delete(final PingEntity pingEntity) {
        Intrinsics.checkNotNullParameter(pingEntity, "pingEntity");
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.PingDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PingDao_Impl.delete$lambda$1(this.f$0, pingEntity, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$1(PingDao_Impl pingDao_Impl, PingEntity pingEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        pingDao_Impl.__deleteAdapterOfPingEntity.handle(_connection, pingEntity);
        return Unit.INSTANCE;
    }

    @Override // info.mqtt.android.service.room.PingDao
    public void updateAll(final PingEntity... pingEntities) {
        Intrinsics.checkNotNullParameter(pingEntities, "pingEntities");
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.PingDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PingDao_Impl.updateAll$lambda$2(this.f$0, pingEntities, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateAll$lambda$2(PingDao_Impl pingDao_Impl, PingEntity[] pingEntityArr, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        pingDao_Impl.__updateAdapterOfPingEntity.handleMultiple(_connection, pingEntityArr);
        return Unit.INSTANCE;
    }

    private final LiveData<List<PingEntity>> _privateGetAll() {
        final String str = "SELECT * FROM PingEntity ORDER BY timestamp ASC";
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PingEntity"}, false, new Function1() { // from class: info.mqtt.android.service.room.PingDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PingDao_Impl.getAll$lambda$3(str, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAll$lambda$3(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "clientId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "serverURI");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "success");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "message");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new PingEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // info.mqtt.android.service.room.PingDao
    public LiveData<List<PingEntity>> allByState(final boolean statePing) {
        final String str = "SELECT * FROM PingEntity WHERE success = ? ORDER BY timestamp ASC";
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PingEntity"}, false, new Function1() { // from class: info.mqtt.android.service.room.PingDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PingDao_Impl.allByState$lambda$4(str, statePing, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allByState$lambda$4(String str, boolean z, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9569bindLong(1, z ? 1L : 0L);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "clientId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "serverURI");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "success");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "message");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new PingEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow3), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4)) != 0, sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // info.mqtt.android.service.room.PingDao
    public int deleteState(final boolean statePing) {
        final String str = "DELETE FROM PingEntity WHERE success = ?";
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.PingDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(PingDao_Impl.deleteState$lambda$5(str, statePing, (SQLiteConnection) obj));
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int deleteState$lambda$5(String str, boolean z, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9569bindLong(1, z ? 1L : 0L);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // info.mqtt.android.service.room.PingDao
    public void removeOldData(final int keepCount) {
        final String str = "DELETE FROM PingEntity WHERE timeStamp IN (SELECT timeStamp FROM PingEntity ORDER BY timeStamp DESC LIMIT 1 OFFSET ?)";
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.PingDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PingDao_Impl.removeOldData$lambda$6(str, keepCount, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeOldData$lambda$6(String str, int i, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9569bindLong(1, i);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: compiled from: PingDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Linfo/mqtt/android/service/room/PingDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
