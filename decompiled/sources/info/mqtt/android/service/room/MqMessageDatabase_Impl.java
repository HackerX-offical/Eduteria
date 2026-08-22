package info.mqtt.android.service.room;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: MqMessageDatabase_Impl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00120\u0010H\u0014J\u0016\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00110\u0014H\u0016J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\u001a\u0010\u0018\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0011\u0012\u0004\u0012\u00020\u00150\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDatabase_Impl;", "Linfo/mqtt/android/service/room/MqMessageDatabase;", "<init>", "()V", "_mqMessageDao", "Lkotlin/Lazy;", "Linfo/mqtt/android/service/room/MqMessageDao;", "_pingDao", "Linfo/mqtt/android/service/room/PingDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "persistenceDao", "pingDao", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MqMessageDatabase_Impl extends MqMessageDatabase {
    private final Lazy<MqMessageDao> _mqMessageDao = LazyKt.lazy(new Function0() { // from class: info.mqtt.android.service.room.MqMessageDatabase_Impl$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MqMessageDatabase_Impl._mqMessageDao$lambda$0(this.f$0);
        }
    });
    private final Lazy<PingDao> _pingDao = LazyKt.lazy(new Function0() { // from class: info.mqtt.android.service.room.MqMessageDatabase_Impl$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MqMessageDatabase_Impl._pingDao$lambda$1(this.f$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final MqMessageDao_Impl _mqMessageDao$lambda$0(MqMessageDatabase_Impl mqMessageDatabase_Impl) {
        return new MqMessageDao_Impl(mqMessageDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PingDao_Impl _pingDao$lambda$1(MqMessageDatabase_Impl mqMessageDatabase_Impl) {
        return new PingDao_Impl(mqMessageDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: info.mqtt.android.service.room.MqMessageDatabase_Impl$createOpenDelegate$_openDelegate$1
            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
            }

            {
                super(2, "28d9483c66f87d7f10041b140dac8fe9", "7da52c069a3cbc0057ed55a080456c33");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `MqMessageEntity` (`messageId` TEXT NOT NULL, `clientHandle` TEXT NOT NULL, `topic` TEXT NOT NULL, `mqttMessage` TEXT NOT NULL, `qos` INTEGER NOT NULL, `retained` INTEGER NOT NULL, `duplicate` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`messageId`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_MqMessageEntity_clientHandle` ON `MqMessageEntity` (`clientHandle`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `PingEntity` (`timestamp` INTEGER NOT NULL, `clientId` TEXT, `serverURI` TEXT, `success` INTEGER NOT NULL, `message` TEXT, PRIMARY KEY(`timestamp`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_PingEntity_timestamp` ON `PingEntity` (`timestamp`)");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '28d9483c66f87d7f10041b140dac8fe9')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) throws Exception {
                Intrinsics.checkNotNullParameter(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `MqMessageEntity`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `PingEntity`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                this.this$0.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter(connection, "connection");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("messageId", new TableInfo.Column("messageId", "TEXT", true, 1, null, 1));
                linkedHashMap.put("clientHandle", new TableInfo.Column("clientHandle", "TEXT", true, 0, null, 1));
                linkedHashMap.put("topic", new TableInfo.Column("topic", "TEXT", true, 0, null, 1));
                linkedHashMap.put("mqttMessage", new TableInfo.Column("mqttMessage", "TEXT", true, 0, null, 1));
                linkedHashMap.put("qos", new TableInfo.Column("qos", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("retained", new TableInfo.Column("retained", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("duplicate", new TableInfo.Column("duplicate", "INTEGER", true, 0, null, 1));
                linkedHashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_MqMessageEntity_clientHandle", false, CollectionsKt.listOf("clientHandle"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo = new TableInfo("MqMessageEntity", linkedHashMap, linkedHashSet, linkedHashSet2);
                TableInfo tableInfo2 = TableInfo.INSTANCE.read(connection, "MqMessageEntity");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "MqMessageEntity(info.mqtt.android.service.room.entity.MqMessageEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 1, null, 1));
                linkedHashMap2.put("clientId", new TableInfo.Column("clientId", "TEXT", false, 0, null, 1));
                linkedHashMap2.put("serverURI", new TableInfo.Column("serverURI", "TEXT", false, 0, null, 1));
                linkedHashMap2.put("success", new TableInfo.Column("success", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_PingEntity_timestamp", false, CollectionsKt.listOf("timestamp"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo3 = new TableInfo("PingEntity", linkedHashMap2, linkedHashSet3, linkedHashSet4);
                TableInfo tableInfo4 = TableInfo.INSTANCE.read(connection, "PingEntity");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "PingEntity(info.mqtt.android.service.room.entity.PingEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "MqMessageEntity", "PingEntity");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "MqMessageEntity", "PingEntity");
    }

    @Override // androidx.room.RoomDatabase
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(MqMessageDao.class), MqMessageDao_Impl.INSTANCE.getRequiredConverters());
        linkedHashMap.put(Reflection.getOrCreateKotlinClass(PingDao.class), PingDao_Impl.INSTANCE.getRequiredConverters());
        return linkedHashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // info.mqtt.android.service.room.MqMessageDatabase
    public MqMessageDao persistenceDao() {
        return this._mqMessageDao.getValue();
    }

    @Override // info.mqtt.android.service.room.MqMessageDatabase
    public PingDao pingDao() {
        return this._pingDao.getValue();
    }
}
