package info.mqtt.android.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import info.mqtt.android.service.room.MqMessageDatabase;
import io.socket.client.Manager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import timber.log.Timber;

/* JADX INFO: compiled from: MqttService.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001~B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016J\"\u0010*\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0016J\u001e\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\"J\"\u00103\u001a\u00020$2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020$05H\u0086@¢\u0006\u0002\u00106J<\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010=\u001a\u00020\u00132\b\b\u0002\u0010>\u001a\u00020+J\"\u0010?\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010CJ\u000e\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0007J\b\u0010H\u001a\u00020$H\u0002J\"\u0010I\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010CJ(\u0010I\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010K\u001a\u00020L2\b\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020CJ\u000e\u0010M\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0007JD\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00132\b\u0010J\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010CJ2\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010V\u001a\u00020W2\b\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020CJ0\u0010X\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010S\u001a\u00020T2\b\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020CJ=\u0010X\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070Y2\b\u0010S\u001a\u0004\u0018\u00010Z2\b\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020C¢\u0006\u0002\u0010[JS\u0010X\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00070Y2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0Y2\b\u0010J\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010C2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010Y¢\u0006\u0002\u0010_J(\u0010`\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020CJ5\u0010`\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070Y2\b\u0010J\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010C¢\u0006\u0002\u0010aJ\u0019\u0010b\u001a\b\u0012\u0004\u0012\u00020O0Y2\u0006\u0010/\u001a\u00020\u0007¢\u0006\u0002\u0010cJ\u0010\u0010d\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0010\u0010e\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0016\u0010f\u001a\u0002012\u0006\u0010/\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007J\u0010\u0010h\u001a\u00020$2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u0012\u0010i\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010j\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010k\u001a\u00020$2\u0006\u0010l\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010m\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010\u00072\u000e\u0010n\u001a\n\u0018\u00010oj\u0004\u0018\u0001`pH\u0016J\b\u0010q\u001a\u00020$H\u0002J\b\u0010r\u001a\u00020$H\u0002J\u000e\u0010s\u001a\u00020\u00132\u0006\u0010E\u001a\u00020FJ\b\u0010t\u001a\u00020$H\u0002J\u0010\u0010u\u001a\u00020\u00132\u0006\u0010E\u001a\u00020FH\u0002J\u0018\u0010v\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\b\u0010w\u001a\u0004\u0018\u00010xJ\u000e\u0010y\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0007J\u0016\u0010z\u001a\u00020W2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010{\u001a\u00020+J\u0016\u0010|\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010{\u001a\u00020+J\u000e\u0010}\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0007R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u007f"}, d2 = {"Linfo/mqtt/android/service/MqttService;", "Landroid/app/Service;", "Linfo/mqtt/android/service/MqttTraceHandler;", "<init>", "()V", "connections", "", "", "Linfo/mqtt/android/service/MqttConnection;", "getConnections$serviceLibrary_release", "()Ljava/util/Map;", "messageDatabase", "Linfo/mqtt/android/service/room/MqMessageDatabase;", "getMessageDatabase", "()Linfo/mqtt/android/service/room/MqMessageDatabase;", "setMessageDatabase", "(Linfo/mqtt/android/service/room/MqMessageDatabase;)V", "traceCallbackId", "isForegroundStarted", "", "isTraceEnabled", "()Z", "setTraceEnabled", "(Z)V", "networkConnectionMonitor", "Linfo/mqtt/android/service/MqttService$NetworkConnectionIntentReceiver;", "mqttServiceBinder", "Linfo/mqtt/android/service/MqttServiceBinder;", "serviceJob", "Lkotlinx/coroutines/Job;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroid/os/Bundle;", "onCreate", "", "onDestroy", "onBind", "Landroid/os/IBinder;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "callbackToActivity", "clientHandle", "status", "Linfo/mqtt/android/service/Status;", "dataBundle", "collect", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClient", "serverURI", "clientId", "contextId", "persistence", "Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;", "pingLogging", "keepPingRecords", "connect", "connectOptions", "Lorg/eclipse/paho/client/mqttv3/MqttConnectOptions;", "activityToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", Manager.EVENT_RECONNECT, "context", "Landroid/content/Context;", "close", "stopService", "disconnect", "invocationContext", "quiesceTimeout", "", "isConnected", "publish", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "topic", "payload", "", "qos", "Linfo/mqtt/android/service/QoS;", "retained", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "subscribe", "", "", "(Ljava/lang/String;[Ljava/lang/String;[ILjava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;)V", "topicFilters", "messageListeners", "Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;", "(Ljava/lang/String;[Ljava/lang/String;[Linfo/mqtt/android/service/QoS;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;)V", "unsubscribe", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;)V", "getPendingDeliveryTokens", "(Ljava/lang/String;)[Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "getConnection", "isConnectionAvailable", "acknowledgeMessageArrival", "id", "setTraceCallbackId", "traceDebug", "traceError", "traceCallback", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "traceException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "registerBroadcastReceivers", "unregisterBroadcastReceivers", "isOnline", "notifyClientsOffline", "isInternetAvailable", "setBufferOpts", "bufferOpts", "Lorg/eclipse/paho/client/mqttv3/DisconnectedBufferOptions;", "getBufferedMessageCount", "getBufferedMessage", "bufferIndex", "deleteBufferedMessage", "getInFlightMessageCount", "NetworkConnectionIntentReceiver", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MqttService extends Service implements MqttTraceHandler {
    private final Map<String, MqttConnection> connections = new ConcurrentHashMap();
    private final MutableSharedFlow<Bundle> flow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    private boolean isForegroundStarted;
    private boolean isTraceEnabled;
    public MqMessageDatabase messageDatabase;
    private MqttServiceBinder mqttServiceBinder;
    private NetworkConnectionIntentReceiver networkConnectionMonitor;
    private Job serviceJob;
    private CoroutineScope serviceScope;
    private String traceCallbackId;

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttService$collect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MqttService.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttService", f = "MqttService.kt", i = {}, l = {259}, m = "collect", n = {}, s = {})
    static final class C06711 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06711(Continuation<? super C06711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MqttService.this.collect(null, this);
        }
    }

    public final Map<String, MqttConnection> getConnections$serviceLibrary_release() {
        return this.connections;
    }

    public final MqMessageDatabase getMessageDatabase() {
        MqMessageDatabase mqMessageDatabase = this.messageDatabase;
        if (mqMessageDatabase != null) {
            return mqMessageDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("messageDatabase");
        return null;
    }

    public final void setMessageDatabase(MqMessageDatabase mqMessageDatabase) {
        Intrinsics.checkNotNullParameter(mqMessageDatabase, "<set-?>");
        this.messageDatabase = mqMessageDatabase;
    }

    /* JADX INFO: renamed from: isTraceEnabled, reason: from getter */
    public final boolean getIsTraceEnabled() {
        return this.isTraceEnabled;
    }

    public final void setTraceEnabled(boolean z) {
        this.isTraceEnabled = z;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.serviceJob = completableJobSupervisorJob$default;
        this.serviceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(completableJobSupervisorJob$default));
        this.mqttServiceBinder = new MqttServiceBinder(this);
        setMessageDatabase(MqMessageDatabase.Companion.getDatabase$default(MqMessageDatabase.INSTANCE, this, null, 2, null));
    }

    @Override // android.app.Service
    public void onDestroy() {
        Timber.INSTANCE.i("Destroy service", new Object[0]);
        Iterator<MqttConnection> it = this.connections.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect(null, null);
        }
        Job job = this.serviceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.serviceJob = null;
        this.serviceScope = null;
        this.mqttServiceBinder = null;
        unregisterBroadcastReceivers();
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(".activityToken");
        MqttServiceBinder mqttServiceBinder = this.mqttServiceBinder;
        Intrinsics.checkNotNull(mqttServiceBinder);
        mqttServiceBinder.setActivityToken(stringExtra);
        return this.mqttServiceBinder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        registerBroadcastReceivers();
        return 1;
    }

    public final void callbackToActivity(String clientHandle, Status status, Bundle dataBundle) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(dataBundle, "dataBundle");
        Bundle bundle = new Bundle(dataBundle);
        bundle.putString(".clientHandle", clientHandle);
        bundle.putSerializable(".callbackStatus", status);
        CoroutineScope coroutineScope = this.serviceScope;
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(bundle, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttService$callbackToActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: MqttService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttService$callbackToActivity$1", f = "MqttService.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $bundle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bundle bundle, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bundle = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqttService.this.new AnonymousClass1(this.$bundle, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MqttService.this.flow.emit(this.$bundle, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttService$collect$2, reason: invalid class name */
    /* JADX INFO: compiled from: MqttService.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 implements FlowCollector, FunctionAdapter {
        final /* synthetic */ Function1<Bundle, Unit> $tmp0;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Bundle, Unit> function1) {
            this.$tmp0 = function1;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(2, this.$tmp0, Intrinsics.Kotlin.class, "suspendConversion0", "collect$suspendConversion0(Lkotlin/jvm/functions/Function1;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(Bundle bundle, Continuation<? super Unit> continuation) {
            Object objCollect$suspendConversion0 = MqttService.collect$suspendConversion0(this.$tmp0, bundle, continuation);
            return objCollect$suspendConversion0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect$suspendConversion0 : Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Bundle) obj, (Continuation<? super Unit>) continuation);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof info.mqtt.android.service.MqttService.C06711
            if (r0 == 0) goto L14
            r0 = r6
            info.mqtt.android.service.MqttService$collect$1 r0 = (info.mqtt.android.service.MqttService.C06711) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            info.mqtt.android.service.MqttService$collect$1 r0 = new info.mqtt.android.service.MqttService$collect$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 == r3) goto L2e
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.MutableSharedFlow<android.os.Bundle> r6 = r4.flow
            info.mqtt.android.service.MqttService$collect$2 r2 = new info.mqtt.android.service.MqttService$collect$2
            r2.<init>(r5)
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            r0.label = r3
            java.lang.Object r5 = r6.collect(r2, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: info.mqtt.android.service.MqttService.collect(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object collect$suspendConversion0(Function1 function1, Bundle bundle, Continuation continuation) {
        function1.invoke(bundle);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ String getClient$default(MqttService mqttService, String str, String str2, String str3, MqttClientPersistence mqttClientPersistence, boolean z, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            i = 1000;
        }
        return mqttService.getClient(str, str2, str3, mqttClientPersistence, z2, i);
    }

    public final String getClient(String serverURI, String clientId, String contextId, MqttClientPersistence persistence, boolean pingLogging, int keepPingRecords) {
        Intrinsics.checkNotNullParameter(serverURI, "serverURI");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(contextId, "contextId");
        String str = serverURI + ":" + clientId + ":" + contextId;
        if (this.connections.containsKey(str)) {
            return str;
        }
        this.connections.put(str, new MqttConnection(this, serverURI, clientId, persistence, str, pingLogging, keepPingRecords));
        return str;
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttService$connect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MqttService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttService$connect$1", f = "MqttService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IMqttToken $activityToken;
        final /* synthetic */ MqttConnection $client;
        final /* synthetic */ MqttConnectOptions $connectOptions;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06721(MqttConnection mqttConnection, MqttConnectOptions mqttConnectOptions, IMqttToken iMqttToken, Continuation<? super C06721> continuation) {
            super(2, continuation);
            this.$client = mqttConnection;
            this.$connectOptions = mqttConnectOptions;
            this.$activityToken = iMqttToken;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06721(this.$client, this.$connectOptions, this.$activityToken, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$client.connect(this.$connectOptions, null, this.$activityToken);
            return Unit.INSTANCE;
        }
    }

    public final void connect(String clientHandle, MqttConnectOptions connectOptions, IMqttToken activityToken) throws MqttException {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C06721(getConnection(clientHandle), connectOptions, activityToken, null), 3, null);
    }

    public final void reconnect(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        traceDebug("Reconnect to server, client size=" + this.connections.size());
        for (MqttConnection mqttConnection : this.connections.values()) {
            traceDebug("Reconnect Client:" + mqttConnection.getClientId() + MqttTopic.TOPIC_LEVEL_SEPARATOR + mqttConnection.getServerURI());
            if (isOnline(context)) {
                mqttConnection.reconnect(context);
            }
        }
    }

    public final void close(String clientHandle) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        getConnection(clientHandle).close();
    }

    private final void stopService() {
        if (this.isForegroundStarted) {
            stopForeground(1);
        }
        stopSelf();
    }

    public final void disconnect(String clientHandle, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        if (isConnectionAvailable(clientHandle)) {
            getConnection(clientHandle).disconnect(invocationContext, activityToken);
            this.connections.remove(clientHandle);
        } else {
            Timber.INSTANCE.w("Connection is not available " + clientHandle, new Object[0]);
        }
        stopService();
    }

    public final void disconnect(String clientHandle, long quiesceTimeout, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        getConnection(clientHandle).disconnect(quiesceTimeout, invocationContext, activityToken);
        this.connections.remove(clientHandle);
        stopService();
    }

    public final boolean isConnected(String clientHandle) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        return getConnection(clientHandle).isConnected();
    }

    public final IMqttDeliveryToken publish(String clientHandle, String topic, byte[] payload, QoS qos, boolean retained, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(qos, "qos");
        MqttConnection connection = getConnection(clientHandle);
        Intrinsics.checkNotNull(activityToken);
        return connection.publish(topic, payload, qos, retained, invocationContext, activityToken);
    }

    public final IMqttDeliveryToken publish(String clientHandle, String topic, MqttMessage message, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        return getConnection(clientHandle).publish(topic, message, invocationContext, activityToken);
    }

    public final void subscribe(String clientHandle, String topic, QoS qos, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(qos, "qos");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        getConnection(clientHandle).subscribe(topic, qos, invocationContext, activityToken);
    }

    public final void subscribe(String clientHandle, String[] topic, int[] qos, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        getConnection(clientHandle).subscribe(topic, qos, invocationContext, activityToken);
    }

    public final void subscribe(String clientHandle, String[] topicFilters, QoS[] qos, String invocationContext, IMqttToken activityToken, IMqttMessageListener[] messageListeners) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topicFilters, "topicFilters");
        Intrinsics.checkNotNullParameter(qos, "qos");
        MqttConnection connection = getConnection(clientHandle);
        Intrinsics.checkNotNull(activityToken);
        connection.subscribe(topicFilters, qos, invocationContext, activityToken, messageListeners);
    }

    public final void unsubscribe(String clientHandle, String topic, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        getConnection(clientHandle).unsubscribe(topic, invocationContext, activityToken);
    }

    public final void unsubscribe(String clientHandle, String[] topic, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        MqttConnection connection = getConnection(clientHandle);
        Intrinsics.checkNotNull(activityToken);
        connection.unsubscribe(topic, invocationContext, activityToken);
    }

    public final IMqttDeliveryToken[] getPendingDeliveryTokens(String clientHandle) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        return getConnection(clientHandle).getPendingDeliveryTokens();
    }

    private final MqttConnection getConnection(String clientHandle) {
        MqttConnection mqttConnection = this.connections.get(clientHandle);
        if (mqttConnection != null) {
            return mqttConnection;
        }
        throw new IllegalArgumentException("Invalid ClientHandle >" + clientHandle + "<");
    }

    private final boolean isConnectionAvailable(String clientHandle) {
        return this.connections.containsKey(clientHandle);
    }

    public final Status acknowledgeMessageArrival(String clientHandle, String id) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(id, "id");
        if (getMessageDatabase().discardArrived(clientHandle, id)) {
            return Status.OK;
        }
        return Status.ERROR;
    }

    public final void setTraceCallbackId(String traceCallbackId) {
        this.traceCallbackId = traceCallbackId;
    }

    @Override // info.mqtt.android.service.MqttTraceHandler
    public void traceDebug(String message) {
        traceCallback("debug", message);
    }

    @Override // info.mqtt.android.service.MqttTraceHandler
    public void traceError(String message) {
        traceCallback("error", message);
    }

    private final void traceCallback(String severity, String message) {
        String str = this.traceCallbackId;
        if (str == null || !this.isTraceEnabled) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "trace");
        bundle.putString(".traceSeverity", severity);
        bundle.putString(".errorMessage", message);
        callbackToActivity(str, Status.ERROR, bundle);
    }

    @Override // info.mqtt.android.service.MqttTraceHandler
    public void traceException(String message, Exception e2) {
        String str = this.traceCallbackId;
        if (str != null) {
            Bundle bundle = new Bundle();
            bundle.putString(".callbackAction", "trace");
            bundle.putString(".traceSeverity", "exception");
            bundle.putString(".errorMessage", message);
            bundle.putSerializable(".exception", e2);
            callbackToActivity(str, Status.ERROR, bundle);
        }
    }

    private final void registerBroadcastReceivers() {
        if (this.networkConnectionMonitor == null) {
            NetworkConnectionIntentReceiver networkConnectionIntentReceiver = new NetworkConnectionIntentReceiver();
            this.networkConnectionMonitor = networkConnectionIntentReceiver;
            registerReceiver(networkConnectionIntentReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private final void unregisterBroadcastReceivers() {
        NetworkConnectionIntentReceiver networkConnectionIntentReceiver = this.networkConnectionMonitor;
        if (networkConnectionIntentReceiver != null) {
            unregisterReceiver(networkConnectionIntentReceiver);
            this.networkConnectionMonitor = null;
        }
    }

    public final boolean isOnline(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isInternetAvailable(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyClientsOffline() {
        Iterator<T> it = this.connections.values().iterator();
        while (it.hasNext()) {
            ((MqttConnection) it.next()).offline();
        }
    }

    private final boolean isInternetAvailable(Context context) {
        NetworkCapabilities networkCapabilities;
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    public final void setBufferOpts(String clientHandle, DisconnectedBufferOptions bufferOpts) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        getConnection(clientHandle).setBufferOpts(bufferOpts);
    }

    public final int getBufferedMessageCount(String clientHandle) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        return getConnection(clientHandle).getBufferedMessageCount();
    }

    public final MqttMessage getBufferedMessage(String clientHandle, int bufferIndex) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        return getConnection(clientHandle).getBufferedMessage(bufferIndex);
    }

    public final void deleteBufferedMessage(String clientHandle, int bufferIndex) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        getConnection(clientHandle).deleteBufferedMessage(bufferIndex);
    }

    public final int getInFlightMessageCount(String clientHandle) {
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        return getConnection(clientHandle).getInFlightMessageCount();
    }

    /* JADX INFO: compiled from: MqttService.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¨\u0006\n"}, d2 = {"Linfo/mqtt/android/service/MqttService$NetworkConnectionIntentReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Linfo/mqtt/android/service/MqttService;)V", "onReceive", "", "context", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class NetworkConnectionIntentReceiver extends BroadcastReceiver {
        public NetworkConnectionIntentReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            MqttService.this.traceDebug("Internal network status receive.");
            Object systemService = MqttService.this.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, "MQTT:tag");
            wakeLockNewWakeLock.acquire(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
            MqttService.this.traceDebug("Reconnect for Network recovery.");
            if (!MqttService.this.isOnline(context)) {
                MqttService.this.notifyClientsOffline();
            } else {
                MqttService.this.traceDebug("Online,reconnect.");
                MqttService.this.reconnect(context);
            }
            wakeLockNewWakeLock.release();
        }
    }
}
