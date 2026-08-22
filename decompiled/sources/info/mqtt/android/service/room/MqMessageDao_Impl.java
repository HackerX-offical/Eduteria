package info.mqtt.android.service.room;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import info.mqtt.android.service.room.entity.MqMessageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: MqMessageDao_Impl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\bH\u0016J!\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0018\"\u00020\bH\u0016¢\u0006\u0002\u0010\u0019J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003¢\u0006\u0002\b\u001aJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDao_Impl;", "Linfo/mqtt/android/service/room/MqMessageDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "all", "", "Linfo/mqtt/android/service/room/entity/MqMessageEntity;", "getAll", "()Ljava/util/List;", "__insertAdapterOfMqMessageEntity", "Landroidx/room/EntityInsertAdapter;", "__converters", "Linfo/mqtt/android/service/room/Converters;", "__deleteAdapterOfMqMessageEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfMqMessageEntity", "insert", "", "mqMessageEntity", "delete", "", "updateAll", "", "([Linfo/mqtt/android/service/room/entity/MqMessageEntity;)V", "_privateGetAll", "allArrived", "clientHandle", "", "deleteId", "", "id", "deleteClientHandle", "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MqMessageDao_Impl implements MqMessageDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Converters __converters;
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<MqMessageEntity> __deleteAdapterOfMqMessageEntity;
    private final EntityInsertAdapter<MqMessageEntity> __insertAdapterOfMqMessageEntity;
    private final EntityDeleteOrUpdateAdapter<MqMessageEntity> __updateAdapterOfMqMessageEntity;

    public MqMessageDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__converters = new Converters();
        this.__db = __db;
        this.__insertAdapterOfMqMessageEntity = new EntityInsertAdapter<MqMessageEntity>() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `MqMessageEntity` (`messageId`,`clientHandle`,`topic`,`mqttMessage`,`qos`,`retained`,`duplicate`,`timestamp`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, MqMessageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo9571bindText(1, entity.getMessageId());
                statement.mo9571bindText(2, entity.getClientHandle());
                statement.mo9571bindText(3, entity.getTopic());
                statement.mo9571bindText(4, MqMessageDao_Impl.this.__converters.fromMqttMessage(entity.getMqttMessage()));
                statement.mo9569bindLong(5, MqMessageDao_Impl.this.__converters.fromQoS(entity.getQos()));
                statement.mo9569bindLong(6, entity.getRetained() ? 1L : 0L);
                statement.mo9569bindLong(7, entity.getDuplicate() ? 1L : 0L);
                statement.mo9569bindLong(8, entity.getTimestamp());
            }
        };
        this.__deleteAdapterOfMqMessageEntity = new EntityDeleteOrUpdateAdapter<MqMessageEntity>() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `MqMessageEntity` WHERE `messageId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, MqMessageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo9571bindText(1, entity.getMessageId());
            }
        };
        this.__updateAdapterOfMqMessageEntity = new EntityDeleteOrUpdateAdapter<MqMessageEntity>() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "UPDATE OR ABORT `MqMessageEntity` SET `messageId` = ?,`clientHandle` = ?,`topic` = ?,`mqttMessage` = ?,`qos` = ?,`retained` = ?,`duplicate` = ?,`timestamp` = ? WHERE `messageId` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, MqMessageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo9571bindText(1, entity.getMessageId());
                statement.mo9571bindText(2, entity.getClientHandle());
                statement.mo9571bindText(3, entity.getTopic());
                statement.mo9571bindText(4, MqMessageDao_Impl.this.__converters.fromMqttMessage(entity.getMqttMessage()));
                statement.mo9569bindLong(5, MqMessageDao_Impl.this.__converters.fromQoS(entity.getQos()));
                statement.mo9569bindLong(6, entity.getRetained() ? 1L : 0L);
                statement.mo9569bindLong(7, entity.getDuplicate() ? 1L : 0L);
                statement.mo9569bindLong(8, entity.getTimestamp());
                statement.mo9571bindText(9, entity.getMessageId());
            }
        };
    }

    @Override // info.mqtt.android.service.room.MqMessageDao
    public List<MqMessageEntity> getAll() {
        return _privateGetAll();
    }

    @Override // info.mqtt.android.service.room.MqMessageDao
    public long insert(final MqMessageEntity mqMessageEntity) {
        Intrinsics.checkNotNullParameter(mqMessageEntity, "mqMessageEntity");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(MqMessageDao_Impl.insert$lambda$0(this.f$0, mqMessageEntity, (SQLiteConnection) obj));
            }
        })).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(MqMessageDao_Impl mqMessageDao_Impl, MqMessageEntity mqMessageEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return mqMessageDao_Impl.__insertAdapterOfMqMessageEntity.insertAndReturnId(_connection, mqMessageEntity);
    }

    @Override // info.mqtt.android.service.room.MqMessageDao
    public void delete(final MqMessageEntity mqMessageEntity) {
        Intrinsics.checkNotNullParameter(mqMessageEntity, "mqMessageEntity");
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MqMessageDao_Impl.delete$lambda$1(this.f$0, mqMessageEntity, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$1(MqMessageDao_Impl mqMessageDao_Impl, MqMessageEntity mqMessageEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        mqMessageDao_Impl.__deleteAdapterOfMqMessageEntity.handle(_connection, mqMessageEntity);
        return Unit.INSTANCE;
    }

    @Override // info.mqtt.android.service.room.MqMessageDao
    public void updateAll(final MqMessageEntity... mqMessageEntity) {
        Intrinsics.checkNotNullParameter(mqMessageEntity, "mqMessageEntity");
        DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MqMessageDao_Impl.updateAll$lambda$2(this.f$0, mqMessageEntity, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateAll$lambda$2(MqMessageDao_Impl mqMessageDao_Impl, MqMessageEntity[] mqMessageEntityArr, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        mqMessageDao_Impl.__updateAdapterOfMqMessageEntity.handleMultiple(_connection, mqMessageEntityArr);
        return Unit.INSTANCE;
    }

    private final List<MqMessageEntity> _privateGetAll() {
        final String str = "SELECT * FROM MQMessageEntity";
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MqMessageDao_Impl.getAll$lambda$3(str, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAll$lambda$3(String str, MqMessageDao_Impl mqMessageDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "messageId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "clientHandle");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "topic");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "mqttMessage");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "qos");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "retained");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "duplicate");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new MqMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), mqMessageDao_Impl.__converters.toMqttMessage(sQLiteStatementPrepare.getText(columnIndexOrThrow4)), mqMessageDao_Impl.__converters.toQoS((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getLong(columnIndexOrThrow8)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // info.mqtt.android.service.room.MqMessageDao
    public List<MqMessageEntity> allArrived(final String clientHandle) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        final String str = "SELECT * FROM MQMessageEntity WHERE clientHandle = ? ORDER BY timestamp ASC";
        return (List) DBUtil.performBlocking(this.__db, true, false, new Function1() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MqMessageDao_Impl.allArrived$lambda$4(str, clientHandle, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allArrived$lambda$4(String str, String str2, MqMessageDao_Impl mqMessageDao_Impl, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        boolean z = true;
        try {
            sQLiteStatementPrepare.mo9571bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "messageId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "clientHandle");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "topic");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "mqttMessage");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "qos");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "retained");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "duplicate");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i = columnIndexOrThrow;
                arrayList.add(new MqMessageEntity(sQLiteStatementPrepare.getText(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), mqMessageDao_Impl.__converters.toMqttMessage(sQLiteStatementPrepare.getText(columnIndexOrThrow4)), mqMessageDao_Impl.__converters.toQoS((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6)) != 0 ? z : false, ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0, sQLiteStatementPrepare.getLong(columnIndexOrThrow8)));
                columnIndexOrThrow = i;
                z = true;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // info.mqtt.android.service.room.MqMessageDao
    public int deleteId(final String clientHandle, final String id) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(id, "id");
        final String str = "DELETE FROM MqMessageEntity WHERE clientHandle = ? AND messageId = ?";
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MqMessageDao_Impl.deleteId$lambda$5(str, clientHandle, id, (SQLiteConnection) obj));
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int deleteId$lambda$5(String str, String str2, String str3, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9571bindText(1, str2);
            sQLiteStatementPrepare.mo9571bindText(2, str3);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // info.mqtt.android.service.room.MqMessageDao
    public int deleteClientHandle(final String clientHandle) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        final String str = "DELETE FROM MqMessageEntity WHERE clientHandle = ?";
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new Function1() { // from class: info.mqtt.android.service.room.MqMessageDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MqMessageDao_Impl.deleteClientHandle$lambda$6(str, clientHandle, (SQLiteConnection) obj));
            }
        })).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int deleteClientHandle$lambda$6(String str, String str2, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo9571bindText(1, str2);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: MqMessageDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
