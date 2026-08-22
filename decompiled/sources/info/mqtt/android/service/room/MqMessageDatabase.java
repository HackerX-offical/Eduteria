package info.mqtt.android.service.room;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import info.mqtt.android.service.QoS;
import info.mqtt.android.service.room.entity.MqMessageEntity;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* JADX INFO: compiled from: MqMessageDatabase.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t¨\u0006\u0012"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "persistenceDao", "Linfo/mqtt/android/service/room/MqMessageDao;", "pingDao", "Linfo/mqtt/android/service/room/PingDao;", "storeArrived", "", "clientHandle", "topic", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "discardArrived", "", "id", "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class MqMessageDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MQ_DB_VERSION = 2;
    private static volatile MqMessageDatabase instance;

    public abstract MqMessageDao persistenceDao();

    public abstract PingDao pingDao();

    public final String storeArrived(String clientHandle, String topic, MqttMessage message) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(message, "message");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C06731(new MqMessageEntity(string, clientHandle, topic, new MqttMessage(message.getPayload()), QoS.INSTANCE.valueOf(message.getQos()), message.isRetained(), message.isDuplicate(), System.currentTimeMillis()), null), 3, null);
        return string;
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.room.MqMessageDatabase$storeArrived$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MqMessageDatabase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.room.MqMessageDatabase$storeArrived$1", f = "MqMessageDatabase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MqMessageEntity $messageArrived;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06731(MqMessageEntity mqMessageEntity, Continuation<? super C06731> continuation) {
            super(2, continuation);
            this.$messageArrived = mqMessageEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqMessageDatabase.this.new C06731(this.$messageArrived, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MqMessageDatabase.this.persistenceDao().insert(this.$messageArrived);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.room.MqMessageDatabase$discardArrived$1, reason: invalid class name */
    /* JADX INFO: compiled from: MqMessageDatabase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.room.MqMessageDatabase$discardArrived$1", f = "MqMessageDatabase.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $clientHandle;
        final /* synthetic */ String $id;
        final /* synthetic */ Ref.BooleanRef $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MqMessageDatabase this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.BooleanRef booleanRef, MqMessageDatabase mqMessageDatabase, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = booleanRef;
            this.this$0 = mqMessageDatabase;
            this.$clientHandle = str;
            this.$id = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$result, this.this$0, this.$clientHandle, this.$id, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.BooleanRef booleanRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, Dispatchers.getIO(), null, new MqMessageDatabase$discardArrived$1$queue$1(this.this$0, this.$clientHandle, this.$id, null), 2, null);
                Ref.BooleanRef booleanRef2 = this.$result;
                this.L$0 = booleanRef2;
                this.label = 1;
                obj = deferredAsync$default.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef = booleanRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            booleanRef.element = ((Boolean) obj).booleanValue();
            return Unit.INSTANCE;
        }
    }

    public final boolean discardArrived(String clientHandle, String id) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(id, "id");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(booleanRef, this, clientHandle, id, null), 3, null);
        return booleanRef.element;
    }

    /* JADX INFO: compiled from: MqMessageDatabase.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDatabase$Companion;", "", "<init>", "()V", "MQ_DB_VERSION", "", "instance", "Linfo/mqtt/android/service/room/MqMessageDatabase;", "getDatabase", "context", "Landroid/content/Context;", "storageName", "", "buildDatabase", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MqMessageDatabase getDatabase$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "messageMQ";
            }
            return companion.getDatabase(context, str);
        }

        public final synchronized MqMessageDatabase getDatabase(Context context, String storageName) {
            MqMessageDatabase mqMessageDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(storageName, "storageName");
            mqMessageDatabase = MqMessageDatabase.instance;
            if (mqMessageDatabase == null) {
                synchronized (this) {
                    mqMessageDatabase = MqMessageDatabase.instance;
                    if (mqMessageDatabase == null) {
                        Companion companion = MqMessageDatabase.INSTANCE;
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        MqMessageDatabase mqMessageDatabaseBuildDatabase = companion.buildDatabase(applicationContext, storageName);
                        Companion companion2 = MqMessageDatabase.INSTANCE;
                        MqMessageDatabase.instance = mqMessageDatabaseBuildDatabase;
                        mqMessageDatabase = mqMessageDatabaseBuildDatabase;
                    }
                }
            }
            return mqMessageDatabase;
        }

        private final MqMessageDatabase buildDatabase(Context context, String storageName) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            return (MqMessageDatabase) Room.databaseBuilder(applicationContext, MqMessageDatabase.class, storageName).fallbackToDestructiveMigrationFrom(1, 2).fallbackToDestructiveMigrationOnDowngrade().build();
        }
    }
}
