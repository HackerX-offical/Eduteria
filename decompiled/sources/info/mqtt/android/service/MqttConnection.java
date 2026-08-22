package info.mqtt.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import info.mqtt.android.service.ping.AlarmPingSender;
import info.mqtt.android.service.room.entity.MqMessageEntity;
import io.socket.client.Manager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;
import timber.log.Timber;

/* JADX INFO: compiled from: MqttConnection.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 w2\u00020\u0001:\u0002vwBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ$\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010!2\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010#J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u000207H\u0002J\u0018\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010:\u001a\u0002012\u0006\u00106\u001a\u000207H\u0002J\u001c\u0010;\u001a\u0002012\u0006\u00106\u001a\u0002072\n\u0010<\u001a\u00060=j\u0002`>H\u0002J\b\u0010?\u001a\u000201H\u0002J$\u0010@\u001a\u0002072\b\u0010A\u001a\u0004\u0018\u00010\u00052\b\u0010B\u001a\u0004\u0018\u00010\u00052\u0006\u0010C\u001a\u00020\u001cH\u0002J\u0006\u0010D\u001a\u000201J \u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020G2\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#J\u001a\u0010E\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010#J<\u0010J\u001a\u0004\u0018\u00010\u001a2\u0006\u0010B\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#J*\u0010J\u001a\u0004\u0018\u00010\u001a2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u001c2\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#J(\u0010P\u001a\u0002012\u0006\u0010B\u001a\u00020\u00052\u0006\u0010M\u001a\u00020N2\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#J5\u0010P\u001a\u0002012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050Q2\b\u0010M\u001a\u0004\u0018\u00010R2\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#¢\u0006\u0002\u0010SJI\u0010P\u001a\u0002012\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00050Q2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0Q2\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010Q¢\u0006\u0002\u0010WJ \u0010X\u001a\u0002012\u0006\u0010B\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#J+\u0010X\u001a\u0002012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050Q2\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#¢\u0006\u0002\u0010YJ\u0012\u0010]\u001a\u0002012\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0010\u0010`\u001a\u0002012\u0006\u0010a\u001a\u00020\u001aH\u0016J\u0018\u0010b\u001a\u0002012\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u001cH\u0016J\u0012\u0010c\u001a\u0004\u0018\u0001072\u0006\u0010a\u001a\u00020\u001aH\u0002J4\u0010d\u001a\u0002012\u0006\u0010B\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u001c2\b\u0010a\u001a\u0004\u0018\u00010\u001a2\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020#H\u0002J\b\u0010f\u001a\u000201H\u0002J\b\u0010g\u001a\u000201H\u0002J\u0006\u0010h\u001a\u000201J\u000e\u00109\u001a\u0002012\u0006\u0010i\u001a\u00020jJ\u0010\u0010k\u001a\u0002012\u0006\u0010*\u001a\u00020\u000bH\u0002J\u0010\u0010l\u001a\u0002012\b\u0010m\u001a\u0004\u0018\u00010/J\u000e\u0010q\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\rJ\u000e\u0010s\u001a\u0002012\u0006\u0010r\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00050\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00050\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00050\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0018\u00010,R\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010H\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001a0Q8F¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0011\u0010n\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0011\u0010t\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bu\u0010p¨\u0006x"}, d2 = {"Linfo/mqtt/android/service/MqttConnection;", "Lorg/eclipse/paho/client/mqttv3/MqttCallbackExtended;", NotificationCompat.CATEGORY_SERVICE, "Linfo/mqtt/android/service/MqttService;", "serverURI", "", "clientId", "persistence", "Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;", "clientHandle", "pingLogging", "", "keepPingRecords", "", "<init>", "(Linfo/mqtt/android/service/MqttService;Ljava/lang/String;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;Ljava/lang/String;ZI)V", "getServerURI", "()Ljava/lang/String;", "setServerURI", "(Ljava/lang/String;)V", "getClientId", "setClientId", "getClientHandle", "setClientHandle", "mapTopics", "", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "mapSentMessages", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "mapActivityTokens", "mapInvocationContexts", "wakeLockTag", "connectOptions", "Lorg/eclipse/paho/client/mqttv3/MqttConnectOptions;", "reconnectActivityToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "myClient", "Lorg/eclipse/paho/client/mqttv3/MqttAsyncClient;", "alarmPingSender", "Linfo/mqtt/android/service/ping/AlarmPingSender;", "disconnected", "cleanSession", "isConnecting", "wakelock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "disconnectedBufferOptions", "Lorg/eclipse/paho/client/mqttv3/DisconnectedBufferOptions;", "connect", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "invocationContext", "activityToken", "doAfterConnectSuccess", "resultBundle", "Landroid/os/Bundle;", "connectComplete", Manager.EVENT_RECONNECT, "doAfterConnectFail", "handleException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "deliverBacklog", "messageToBundle", "messageId", "topic", "message", "close", "disconnect", "quiesceTimeout", "", "isConnected", "()Z", "publish", "payload", "", "qos", "Linfo/mqtt/android/service/QoS;", "retained", "subscribe", "", "", "([Ljava/lang/String;[ILjava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;)V", "topicFilters", "messageListeners", "Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;", "([Ljava/lang/String;[Linfo/mqtt/android/service/QoS;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;)V", "unsubscribe", "([Ljava/lang/String;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/IMqttToken;)V", "pendingDeliveryTokens", "getPendingDeliveryTokens", "()[Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "connectionLost", "why", "", "deliveryComplete", "messageToken", "messageArrived", "popSendDetails", "storeSendDetailsInMemory", "msg", "acquireWakeLock", "releaseWakeLock", OfflineMessageRequest.ELEMENT, "context", "Landroid/content/Context;", "setConnectingState", "setBufferOpts", "bufferOpts", "bufferedMessageCount", "getBufferedMessageCount", "()I", "getBufferedMessage", "bufferIndex", "deleteBufferedMessage", "inFlightMessageCount", "getInFlightMessageCount", "MqttConnectionListener", "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MqttConnection implements MqttCallbackExtended {
    private static final String NOT_CONNECTED = "not connected";
    private static final String TEMP = "MqttConnection";
    private AlarmPingSender alarmPingSender;
    private boolean cleanSession;
    private String clientHandle;
    private String clientId;
    private MqttConnectOptions connectOptions;
    private volatile boolean disconnected;
    private DisconnectedBufferOptions disconnectedBufferOptions;
    private volatile boolean isConnecting;
    private final int keepPingRecords;
    private final Map<IMqttDeliveryToken, String> mapActivityTokens;
    private final Map<IMqttDeliveryToken, String> mapInvocationContexts;
    private final Map<IMqttDeliveryToken, MqttMessage> mapSentMessages;
    private final Map<IMqttDeliveryToken, String> mapTopics;
    private MqttAsyncClient myClient;
    private MqttClientPersistence persistence;
    private final boolean pingLogging;
    private IMqttToken reconnectActivityToken;
    private String serverURI;
    private final MqttService service;
    private final String wakeLockTag;
    private PowerManager.WakeLock wakelock;

    public MqttConnection(MqttService service, String serverURI, String clientId, MqttClientPersistence mqttClientPersistence, String clientHandle, boolean z, int i) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(serverURI, "serverURI");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        this.service = service;
        this.serverURI = serverURI;
        this.clientId = clientId;
        this.persistence = mqttClientPersistence;
        this.clientHandle = clientHandle;
        this.pingLogging = z;
        this.keepPingRecords = i;
        this.mapTopics = new HashMap();
        this.mapSentMessages = new HashMap();
        this.mapActivityTokens = new HashMap();
        this.mapInvocationContexts = new HashMap();
        this.wakeLockTag = getClass().getSimpleName() + " " + this.clientId + " on host " + this.serverURI;
        this.disconnected = true;
        this.cleanSession = true;
    }

    public final String getServerURI() {
        return this.serverURI;
    }

    public final void setServerURI(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serverURI = str;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final void setClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientId = str;
    }

    public final String getClientHandle() {
        return this.clientHandle;
    }

    public final void setClientHandle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientHandle = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c2 A[PHI: r12
      0x00c2: PHI (r12v19 java.io.File) = (r12v7 java.io.File), (r12v9 java.io.File) binds: [B:16:0x0097, B:18:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void connect(org.eclipse.paho.client.mqttv3.MqttConnectOptions r10, java.lang.String r11, org.eclipse.paho.client.mqttv3.IMqttToken r12) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: info.mqtt.android.service.MqttConnection.connect(org.eclipse.paho.client.mqttv3.MqttConnectOptions, java.lang.String, org.eclipse.paho.client.mqttv3.IMqttToken):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAfterConnectSuccess(Bundle resultBundle) {
        acquireWakeLock();
        this.service.callbackToActivity(this.clientHandle, Status.OK, resultBundle);
        deliverBacklog();
        setConnectingState(false);
        this.disconnected = false;
        releaseWakeLock();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
    public void connectComplete(boolean reconnect, String serverURI) {
        Intrinsics.checkNotNullParameter(serverURI, "serverURI");
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "connectExtended");
        bundle.putBoolean(".reconnect", reconnect);
        bundle.putString(".serverURI", serverURI);
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAfterConnectFail(Bundle resultBundle) {
        acquireWakeLock();
        this.disconnected = true;
        setConnectingState(false);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, resultBundle);
        releaseWakeLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleException(Bundle resultBundle, Exception e2) {
        resultBundle.putString(".errorMessage", e2.getLocalizedMessage());
        resultBundle.putSerializable(".exception", e2);
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, resultBundle);
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttConnection$deliverBacklog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MqttConnection.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttConnection$deliverBacklog$1", f = "MqttConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06681(Continuation<? super C06681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqttConnection.this.new C06681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<MqMessageEntity> listAllArrived = MqttConnection.this.service.getMessageDatabase().persistenceDao().allArrived(MqttConnection.this.getClientHandle());
                MqttConnection mqttConnection = MqttConnection.this;
                for (MqMessageEntity mqMessageEntity : listAllArrived) {
                    Bundle bundleMessageToBundle = mqttConnection.messageToBundle(mqMessageEntity.getMessageId(), mqMessageEntity.getTopic(), mqMessageEntity.getMqttMessage());
                    bundleMessageToBundle.putString(".callbackAction", "messageArrived");
                    mqttConnection.service.callbackToActivity(mqttConnection.getClientHandle(), Status.OK, bundleMessageToBundle);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void deliverBacklog() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C06681(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle messageToBundle(String messageId, String topic, MqttMessage message) {
        Bundle bundle = new Bundle();
        bundle.putString("messageId", messageId);
        bundle.putString("destinationName", topic);
        bundle.putParcelable(".PARCEL", new ParcelableMqttMessage(message));
        return bundle;
    }

    public final void close() {
        this.service.traceDebug("close()");
        try {
            MqttAsyncClient mqttAsyncClient = this.myClient;
            if (mqttAsyncClient != null) {
                mqttAsyncClient.close();
            }
        } catch (MqttException e2) {
            handleException(new Bundle(), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void disconnect(long r7, java.lang.String r9, org.eclipse.paho.client.mqttv3.IMqttToken r10) {
        /*
            r6 = this;
            java.lang.String r0 = "activityToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            info.mqtt.android.service.MqttService r0 = r6.service
            java.lang.String r1 = "disconnect()"
            r0.traceDebug(r1)
            r0 = 1
            r6.disconnected = r0
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r0 = ".activityToken"
            java.lang.String r10 = r10.toString()
            r1.putString(r0, r10)
            java.lang.String r10 = ".invocationContext"
            r1.putString(r10, r9)
            java.lang.String r10 = ".callbackAction"
            java.lang.String r0 = "disconnect"
            r1.putString(r10, r0)
            org.eclipse.paho.client.mqttv3.MqttAsyncClient r10 = r6.myClient
            if (r10 == 0) goto L4e
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            boolean r10 = r10.isConnected()
            if (r10 == 0) goto L4e
            info.mqtt.android.service.MqttConnection$MqttConnectionListener r10 = new info.mqtt.android.service.MqttConnection$MqttConnectionListener
            r10.<init>(r6, r1)
            org.eclipse.paho.client.mqttv3.IMqttActionListener r10 = (org.eclipse.paho.client.mqttv3.IMqttActionListener) r10
            org.eclipse.paho.client.mqttv3.MqttAsyncClient r0 = r6.myClient     // Catch: java.lang.Exception -> L46
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> L46
            r0.disconnect(r7, r9, r10)     // Catch: java.lang.Exception -> L46
            goto L65
        L46:
            r0 = move-exception
            r7 = r0
            r6.handleException(r1, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            goto L65
        L4e:
            java.lang.String r7 = ".errorMessage"
            java.lang.String r8 = "not connected"
            r1.putString(r7, r8)
            info.mqtt.android.service.MqttService r7 = r6.service
            java.lang.String r8 = "disconnect not connected"
            r7.traceError(r8)
            info.mqtt.android.service.MqttService r7 = r6.service
            java.lang.String r8 = r6.clientHandle
            info.mqtt.android.service.Status r9 = info.mqtt.android.service.Status.ERROR
            r7.callbackToActivity(r8, r9, r1)
        L65:
            org.eclipse.paho.client.mqttv3.MqttConnectOptions r7 = r6.connectOptions
            if (r7 == 0) goto L8c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            boolean r7 = r7.isCleanSession()
            if (r7 == 0) goto L8c
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            kotlinx.coroutines.CoroutineScope r0 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r7)
            info.mqtt.android.service.MqttConnection$disconnect$1 r7 = new info.mqtt.android.service.MqttConnection$disconnect$1
            r8 = 0
            r7.<init>(r8)
            r3 = r7
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
        L8c:
            r6.releaseWakeLock()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: info.mqtt.android.service.MqttConnection.disconnect(long, java.lang.String, org.eclipse.paho.client.mqttv3.IMqttToken):void");
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttConnection$disconnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MqttConnection.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttConnection$disconnect$1", f = "MqttConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06691(Continuation<? super C06691> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqttConnection.this.new C06691(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MqttConnection.this.service.getMessageDatabase().persistenceDao().deleteClientHandle(MqttConnection.this.getClientHandle());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void disconnect(java.lang.String r7, org.eclipse.paho.client.mqttv3.IMqttToken r8) {
        /*
            r6 = this;
            info.mqtt.android.service.MqttService r0 = r6.service
            java.lang.String r1 = "disconnect()"
            r0.traceDebug(r1)
            r0 = 1
            r6.disconnected = r0
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r0 = ".activityToken"
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r1.putString(r0, r8)
            java.lang.String r8 = ".invocationContext"
            r1.putString(r8, r7)
            java.lang.String r8 = ".callbackAction"
            java.lang.String r0 = "disconnect"
            r1.putString(r8, r0)
            org.eclipse.paho.client.mqttv3.MqttAsyncClient r8 = r6.myClient
            if (r8 == 0) goto L49
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            boolean r8 = r8.isConnected()
            if (r8 == 0) goto L49
            info.mqtt.android.service.MqttConnection$MqttConnectionListener r8 = new info.mqtt.android.service.MqttConnection$MqttConnectionListener
            r8.<init>(r6, r1)
            org.eclipse.paho.client.mqttv3.IMqttActionListener r8 = (org.eclipse.paho.client.mqttv3.IMqttActionListener) r8
            org.eclipse.paho.client.mqttv3.MqttAsyncClient r0 = r6.myClient     // Catch: java.lang.Exception -> L41
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> L41
            r0.disconnect(r7, r8)     // Catch: java.lang.Exception -> L41
            goto L60
        L41:
            r0 = move-exception
            r7 = r0
            r6.handleException(r1, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            goto L60
        L49:
            java.lang.String r7 = ".errorMessage"
            java.lang.String r8 = "not connected"
            r1.putString(r7, r8)
            info.mqtt.android.service.MqttService r7 = r6.service
            java.lang.String r8 = "disconnect not connected"
            r7.traceError(r8)
            info.mqtt.android.service.MqttService r7 = r6.service
            java.lang.String r8 = r6.clientHandle
            info.mqtt.android.service.Status r0 = info.mqtt.android.service.Status.ERROR
            r7.callbackToActivity(r8, r0, r1)
        L60:
            org.eclipse.paho.client.mqttv3.MqttConnectOptions r7 = r6.connectOptions
            if (r7 == 0) goto L87
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            boolean r7 = r7.isCleanSession()
            if (r7 == 0) goto L87
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            kotlinx.coroutines.CoroutineScope r0 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r7)
            info.mqtt.android.service.MqttConnection$disconnect$2 r7 = new info.mqtt.android.service.MqttConnection$disconnect$2
            r8 = 0
            r7.<init>(r8)
            r3 = r7
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
        L87:
            r6.releaseWakeLock()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: info.mqtt.android.service.MqttConnection.disconnect(java.lang.String, org.eclipse.paho.client.mqttv3.IMqttToken):void");
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttConnection$disconnect$2, reason: invalid class name */
    /* JADX INFO: compiled from: MqttConnection.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttConnection$disconnect$2", f = "MqttConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqttConnection.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MqttConnection.this.service.getMessageDatabase().persistenceDao().deleteClientHandle(MqttConnection.this.getClientHandle());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final boolean isConnected() {
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient == null) {
            return false;
        }
        Intrinsics.checkNotNull(mqttAsyncClient);
        return mqttAsyncClient.isConnected();
    }

    public final IMqttDeliveryToken publish(String topic, byte[] payload, QoS qos, boolean retained, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(qos, "qos");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "send");
        bundle.putString(".activityToken", activityToken.toString());
        bundle.putString(".invocationContext", invocationContext);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        IMqttDeliveryToken iMqttDeliveryToken = null;
        if (mqttAsyncClient != null) {
            Intrinsics.checkNotNull(mqttAsyncClient);
            if (mqttAsyncClient.isConnected()) {
                MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(this, bundle);
                try {
                    MqttMessage mqttMessage = new MqttMessage(payload);
                    mqttMessage.setQos(qos.getValue());
                    mqttMessage.setRetained(retained);
                    MqttAsyncClient mqttAsyncClient2 = this.myClient;
                    Intrinsics.checkNotNull(mqttAsyncClient2);
                    IMqttDeliveryToken iMqttDeliveryTokenPublish = mqttAsyncClient2.publish(topic, payload, qos.getValue(), retained, invocationContext, mqttConnectionListener);
                    try {
                        storeSendDetailsInMemory(topic, mqttMessage, iMqttDeliveryTokenPublish, invocationContext, activityToken);
                        return iMqttDeliveryTokenPublish;
                    } catch (Exception e2) {
                        e = e2;
                        iMqttDeliveryToken = iMqttDeliveryTokenPublish;
                        handleException(bundle, e);
                        return iMqttDeliveryToken;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        }
        bundle.putString(".errorMessage", NOT_CONNECTED);
        this.service.traceError("send not connected");
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.eclipse.paho.client.mqttv3.IMqttDeliveryToken publish(java.lang.String r10, org.eclipse.paho.client.mqttv3.MqttMessage r11, java.lang.String r12, org.eclipse.paho.client.mqttv3.IMqttToken r13) {
        /*
            r9 = this;
            java.lang.String r0 = "topic"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "activityToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r0 = ".callbackAction"
            java.lang.String r4 = "send"
            r7.putString(r0, r4)
            java.lang.String r0 = ".activityToken"
            java.lang.String r4 = r13.toString()
            r7.putString(r0, r4)
            java.lang.String r0 = ".invocationContext"
            r7.putString(r0, r12)
            org.eclipse.paho.client.mqttv3.MqttAsyncClient r0 = r9.myClient
            r4 = 0
            if (r0 == 0) goto L55
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L55
            info.mqtt.android.service.MqttConnection$MqttConnectionListener r0 = new info.mqtt.android.service.MqttConnection$MqttConnectionListener
            r0.<init>(r9, r7)
            org.eclipse.paho.client.mqttv3.IMqttActionListener r0 = (org.eclipse.paho.client.mqttv3.IMqttActionListener) r0
            org.eclipse.paho.client.mqttv3.MqttAsyncClient r8 = r9.myClient     // Catch: java.lang.Exception -> L50
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch: java.lang.Exception -> L50
            org.eclipse.paho.client.mqttv3.IMqttDeliveryToken r4 = r8.publish(r10, r11, r12, r0)     // Catch: java.lang.Exception -> L50
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r12
            r6 = r13
            r1.storeSendDetailsInMemory(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L50
            return r4
        L50:
            r0 = move-exception
            r9.handleException(r7, r0)
            goto L83
        L55:
            org.eclipse.paho.client.mqttv3.MqttAsyncClient r0 = r9.myClient
            if (r0 == 0) goto L84
            org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions r0 = r9.disconnectedBufferOptions
            if (r0 == 0) goto L84
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isBufferEnabled()
            if (r0 == 0) goto L84
            info.mqtt.android.service.MqttConnection$MqttConnectionListener r0 = new info.mqtt.android.service.MqttConnection$MqttConnectionListener
            r0.<init>(r9, r7)
            org.eclipse.paho.client.mqttv3.IMqttActionListener r0 = (org.eclipse.paho.client.mqttv3.IMqttActionListener) r0
            org.eclipse.paho.client.mqttv3.MqttAsyncClient r6 = r9.myClient     // Catch: java.lang.Exception -> L7f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch: java.lang.Exception -> L7f
            org.eclipse.paho.client.mqttv3.IMqttDeliveryToken r4 = r6.publish(r10, r11, r12, r0)     // Catch: java.lang.Exception -> L7f
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r12
            r6 = r13
            r1.storeSendDetailsInMemory(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L7f
            return r4
        L7f:
            r0 = move-exception
            r9.handleException(r7, r0)
        L83:
            return r4
        L84:
            timber.log.Timber$Forest r0 = timber.log.Timber.INSTANCE
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "Client is not connected, so not sending message"
            r0.i(r3, r2)
            java.lang.String r0 = ".errorMessage"
            java.lang.String r2 = "not connected"
            r7.putString(r0, r2)
            info.mqtt.android.service.MqttService r0 = r9.service
            java.lang.String r2 = "send not connected"
            r0.traceError(r2)
            info.mqtt.android.service.MqttService r0 = r9.service
            java.lang.String r2 = r9.clientHandle
            info.mqtt.android.service.Status r3 = info.mqtt.android.service.Status.ERROR
            r0.callbackToActivity(r2, r3, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: info.mqtt.android.service.MqttConnection.publish(java.lang.String, org.eclipse.paho.client.mqttv3.MqttMessage, java.lang.String, org.eclipse.paho.client.mqttv3.IMqttToken):org.eclipse.paho.client.mqttv3.IMqttDeliveryToken");
    }

    public final void subscribe(String topic, QoS qos, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(qos, "qos");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        this.service.traceDebug("subscribe({" + topic + "}," + qos + ",{" + invocationContext + "}, {" + activityToken + "}");
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "subscribe");
        bundle.putString(".activityToken", activityToken.toString());
        bundle.putString(".invocationContext", invocationContext);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null) {
            Intrinsics.checkNotNull(mqttAsyncClient);
            if (mqttAsyncClient.isConnected()) {
                MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(this, bundle);
                try {
                    MqttAsyncClient mqttAsyncClient2 = this.myClient;
                    Intrinsics.checkNotNull(mqttAsyncClient2);
                    mqttAsyncClient2.subscribe(topic, qos.getValue(), invocationContext, mqttConnectionListener);
                    return;
                } catch (Exception e2) {
                    handleException(bundle, e2);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
        }
        bundle.putString(".errorMessage", NOT_CONNECTED);
        this.service.traceError("subscribe not connected");
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public final void subscribe(String[] topic, int[] qos, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        MqttService mqttService = this.service;
        String string = Arrays.toString(topic);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String string2 = Arrays.toString(qos);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        mqttService.traceDebug("subscribe({" + string + "}," + string2 + ",{" + invocationContext + "}, {" + activityToken + "}");
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "subscribe");
        bundle.putString(".activityToken", activityToken.toString());
        bundle.putString(".invocationContext", invocationContext);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null) {
            Intrinsics.checkNotNull(mqttAsyncClient);
            if (mqttAsyncClient.isConnected()) {
                MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(this, bundle);
                try {
                    MqttAsyncClient mqttAsyncClient2 = this.myClient;
                    Intrinsics.checkNotNull(mqttAsyncClient2);
                    mqttAsyncClient2.subscribe(topic, qos, invocationContext, mqttConnectionListener);
                    return;
                } catch (Exception e2) {
                    handleException(bundle, e2);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
        }
        bundle.putString(".errorMessage", NOT_CONNECTED);
        this.service.traceError("subscribe not connected");
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public final void subscribe(String[] topicFilters, QoS[] qos, String invocationContext, IMqttToken activityToken, IMqttMessageListener[] messageListeners) {
        Intrinsics.checkNotNullParameter(topicFilters, "topicFilters");
        Intrinsics.checkNotNullParameter(qos, "qos");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        MqttService mqttService = this.service;
        String string = Arrays.toString(topicFilters);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String string2 = Arrays.toString(qos);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        mqttService.traceDebug("subscribe({" + string + "}," + string2 + ",{" + invocationContext + "}, {" + activityToken + "}");
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "subscribe");
        bundle.putString(".activityToken", activityToken.toString());
        bundle.putString(".invocationContext", invocationContext);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null) {
            Intrinsics.checkNotNull(mqttAsyncClient);
            if (mqttAsyncClient.isConnected()) {
                MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(this, bundle);
                try {
                    MqttAsyncClient mqttAsyncClient2 = this.myClient;
                    Intrinsics.checkNotNull(mqttAsyncClient2);
                    ArrayList arrayList = new ArrayList(qos.length);
                    for (QoS qoS : qos) {
                        arrayList.add(Integer.valueOf(qoS.getValue()));
                    }
                    mqttAsyncClient2.subscribe(topicFilters, CollectionsKt.toIntArray(arrayList), (Object) null, mqttConnectionListener, messageListeners);
                    return;
                } catch (Exception e2) {
                    handleException(bundle, e2);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
        }
        bundle.putString(".errorMessage", NOT_CONNECTED);
        this.service.traceError("subscribe not connected");
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public final void unsubscribe(String topic, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        this.service.traceDebug("unsubscribe({" + topic + "},{" + invocationContext + "}, {" + activityToken + "})");
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "unsubscribe");
        bundle.putString(".activityToken", activityToken.toString());
        bundle.putString(".invocationContext", invocationContext);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null) {
            Intrinsics.checkNotNull(mqttAsyncClient);
            if (mqttAsyncClient.isConnected()) {
                MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(this, bundle);
                try {
                    MqttAsyncClient mqttAsyncClient2 = this.myClient;
                    Intrinsics.checkNotNull(mqttAsyncClient2);
                    mqttAsyncClient2.unsubscribe(topic, invocationContext, mqttConnectionListener);
                    return;
                } catch (Exception e2) {
                    handleException(bundle, e2);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
        }
        bundle.putString(".errorMessage", NOT_CONNECTED);
        this.service.traceError("subscribe not connected");
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public final void unsubscribe(String[] topic, String invocationContext, IMqttToken activityToken) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(activityToken, "activityToken");
        MqttService mqttService = this.service;
        String string = Arrays.toString(topic);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        mqttService.traceDebug("unsubscribe({" + string + "},{" + invocationContext + "}, {" + activityToken + "})");
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "unsubscribe");
        bundle.putString(".activityToken", activityToken.toString());
        bundle.putString(".invocationContext", invocationContext);
        MqttAsyncClient mqttAsyncClient = this.myClient;
        if (mqttAsyncClient != null) {
            Intrinsics.checkNotNull(mqttAsyncClient);
            if (mqttAsyncClient.isConnected()) {
                MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(this, bundle);
                try {
                    MqttAsyncClient mqttAsyncClient2 = this.myClient;
                    Intrinsics.checkNotNull(mqttAsyncClient2);
                    mqttAsyncClient2.unsubscribe(topic, invocationContext, mqttConnectionListener);
                    return;
                } catch (Exception e2) {
                    handleException(bundle, e2);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
        }
        bundle.putString(".errorMessage", NOT_CONNECTED);
        this.service.traceError("subscribe not connected");
        this.service.callbackToActivity(this.clientHandle, Status.ERROR, bundle);
    }

    public final IMqttDeliveryToken[] getPendingDeliveryTokens() {
        MqttAsyncClient mqttAsyncClient = this.myClient;
        Intrinsics.checkNotNull(mqttAsyncClient);
        IMqttDeliveryToken[] pendingDeliveryTokens = mqttAsyncClient.getPendingDeliveryTokens();
        Intrinsics.checkNotNullExpressionValue(pendingDeliveryTokens, "getPendingDeliveryTokens(...)");
        return pendingDeliveryTokens;
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttCallback
    public void connectionLost(Throwable why) {
        if (why != null) {
            this.service.traceDebug("connectionLost(" + why.getMessage() + ")");
        } else {
            this.service.traceDebug("connectionLost(NO_REASON)");
        }
        this.disconnected = true;
        try {
            MqttConnectOptions mqttConnectOptions = this.connectOptions;
            Intrinsics.checkNotNull(mqttConnectOptions);
            if (!mqttConnectOptions.isAutomaticReconnect()) {
                MqttAsyncClient mqttAsyncClient = this.myClient;
                Intrinsics.checkNotNull(mqttAsyncClient);
                mqttAsyncClient.disconnect(null, new IMqttActionListener() { // from class: info.mqtt.android.service.MqttConnection.connectionLost.1
                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    }

                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onSuccess(IMqttToken asyncActionToken) {
                        Intrinsics.checkNotNullParameter(asyncActionToken, "asyncActionToken");
                    }
                });
            } else {
                AlarmPingSender alarmPingSender = this.alarmPingSender;
                Intrinsics.checkNotNull(alarmPingSender);
                alarmPingSender.schedule(100L);
            }
        } catch (Exception unused) {
        }
        Bundle bundle = new Bundle();
        bundle.putString(".callbackAction", "onConnectionLost");
        if (why != null) {
            bundle.putString(".errorMessage", why.getMessage());
            if (why instanceof MqttException) {
                bundle.putSerializable(".exception", why);
            }
            bundle.putString(".exceptionStack", Log.getStackTraceString(why));
        }
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundle);
        releaseWakeLock();
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttCallback
    public void deliveryComplete(IMqttDeliveryToken messageToken) {
        Intrinsics.checkNotNullParameter(messageToken, "messageToken");
        this.service.traceDebug("deliveryComplete(" + messageToken + ")");
        Bundle bundlePopSendDetails = popSendDetails(messageToken);
        if (bundlePopSendDetails != null) {
            if (Intrinsics.areEqual("send", bundlePopSendDetails.getString(".callbackAction"))) {
                this.service.callbackToActivity(this.clientHandle, Status.OK, bundlePopSendDetails);
            }
            bundlePopSendDetails.putString(".callbackAction", "messageDelivered");
            this.service.callbackToActivity(this.clientHandle, Status.OK, bundlePopSendDetails);
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttCallback
    public void messageArrived(String topic, MqttMessage message) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(message, "message");
        this.service.traceDebug("messageArrived(" + topic + ",{" + message + "})");
        String strStoreArrived = this.service.getMessageDatabase().storeArrived(this.clientHandle, topic, message);
        Bundle bundleMessageToBundle = messageToBundle(strStoreArrived, topic, message);
        bundleMessageToBundle.putString(".callbackAction", "messageArrived");
        bundleMessageToBundle.putString("messageId", strStoreArrived);
        this.service.callbackToActivity(this.clientHandle, Status.OK, bundleMessageToBundle);
    }

    private final synchronized Bundle popSendDetails(IMqttDeliveryToken messageToken) {
        MqttMessage mqttMessageRemove = this.mapSentMessages.remove(messageToken);
        if (mqttMessageRemove == null) {
            return null;
        }
        String strRemove = this.mapTopics.remove(messageToken);
        String strRemove2 = this.mapActivityTokens.remove(messageToken);
        String strRemove3 = this.mapInvocationContexts.remove(messageToken);
        Bundle bundleMessageToBundle = messageToBundle(null, strRemove, mqttMessageRemove);
        if (strRemove2 != null) {
            bundleMessageToBundle.putString(".callbackAction", "send");
            bundleMessageToBundle.putString(".activityToken", strRemove2);
            bundleMessageToBundle.putString(".invocationContext", strRemove3);
        }
        return bundleMessageToBundle;
    }

    private final synchronized void storeSendDetailsInMemory(String topic, MqttMessage msg, IMqttDeliveryToken messageToken, String invocationContext, IMqttToken activityToken) {
        this.mapTopics.put(messageToken, topic);
        this.mapSentMessages.put(messageToken, msg);
        this.mapActivityTokens.put(messageToken, activityToken.toString());
        if (invocationContext != null) {
            this.mapInvocationContexts.put(messageToken, invocationContext);
        }
    }

    private final void acquireWakeLock() {
        if (this.wakelock == null) {
            Object systemService = this.service.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            this.wakelock = ((PowerManager) systemService).newWakeLock(1, this.wakeLockTag);
        }
        PowerManager.WakeLock wakeLock = this.wakelock;
        Intrinsics.checkNotNull(wakeLock);
        wakeLock.acquire(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
    }

    private final void releaseWakeLock() {
        PowerManager.WakeLock wakeLock = this.wakelock;
        if (wakeLock != null) {
            Intrinsics.checkNotNull(wakeLock);
            if (wakeLock.isHeld()) {
                PowerManager.WakeLock wakeLock2 = this.wakelock;
                Intrinsics.checkNotNull(wakeLock2);
                wakeLock2.release();
            }
        }
    }

    public final void offline() {
        if (this.disconnected || this.cleanSession) {
            return;
        }
        connectionLost(new Exception("Android offline"));
    }

    public final synchronized void reconnect(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.myClient == null) {
            this.service.traceError("Reconnect myClient = null. Will not do reconnect");
            return;
        }
        if (this.isConnecting) {
            this.service.traceDebug("The client is connecting. Reconnect return directly.");
            return;
        }
        if (!this.service.isOnline(context)) {
            this.service.traceDebug("The network is not reachable. Will not do reconnect");
            return;
        }
        MqttConnectOptions mqttConnectOptions = this.connectOptions;
        Intrinsics.checkNotNull(mqttConnectOptions);
        if (mqttConnectOptions.isAutomaticReconnect()) {
            Timber.INSTANCE.i("Requesting Automatic reconnect using New Java AC", new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putString(".activityToken", String.valueOf(this.reconnectActivityToken));
            bundle.putString(".invocationContext", null);
            bundle.putString(".callbackAction", "connect");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C06701(bundle, null), 3, null);
        } else if (this.disconnected && !this.cleanSession) {
            this.service.traceDebug("Do Real Reconnect!");
            final Bundle bundle2 = new Bundle();
            bundle2.putString(".activityToken", String.valueOf(this.reconnectActivityToken));
            bundle2.putString(".invocationContext", null);
            bundle2.putString(".callbackAction", "connect");
            try {
                MqttConnectionListener mqttConnectionListener = new MqttConnectionListener(bundle2) { // from class: info.mqtt.android.service.MqttConnection$reconnect$listener$1
                    final /* synthetic */ Bundle $resultBundle;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(this.this$0, bundle2);
                        this.$resultBundle = bundle2;
                    }

                    @Override // info.mqtt.android.service.MqttConnection.MqttConnectionListener, org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onSuccess(IMqttToken asyncActionToken) {
                        Intrinsics.checkNotNullParameter(asyncActionToken, "asyncActionToken");
                        this.this$0.service.traceDebug("Reconnect Success!");
                        this.this$0.service.traceDebug("DeliverBacklog when reconnect.");
                        this.$resultBundle.putBoolean("sessionPresent", asyncActionToken.getSessionPresent());
                        this.this$0.doAfterConnectSuccess(this.$resultBundle);
                    }

                    @Override // info.mqtt.android.service.MqttConnection.MqttConnectionListener, org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        this.$resultBundle.putString(".errorMessage", exception != null ? exception.getLocalizedMessage() : null);
                        this.$resultBundle.putSerializable(".exception", exception);
                        this.this$0.service.callbackToActivity(this.this$0.getClientHandle(), Status.ERROR, this.$resultBundle);
                        this.this$0.doAfterConnectFail(this.$resultBundle);
                    }
                };
                MqttAsyncClient mqttAsyncClient = this.myClient;
                Intrinsics.checkNotNull(mqttAsyncClient);
                mqttAsyncClient.connect(this.connectOptions, null, mqttConnectionListener);
                setConnectingState(true);
            } catch (MqttException e2) {
                this.service.traceError("Cannot reconnect to remote server." + e2.getMessage());
                setConnectingState(false);
                handleException(bundle2, e2);
            } catch (Exception e3) {
                this.service.traceError("Cannot reconnect to remote server." + e3.getMessage());
                setConnectingState(false);
                handleException(bundle2, new MqttException(6, e3.getCause()));
            }
        }
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttConnection$reconnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MqttConnection.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttConnection$reconnect$1", f = "MqttConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $resultBundle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06701(Bundle bundle, Continuation<? super C06701> continuation) {
            super(2, continuation);
            this.$resultBundle = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqttConnection.this.new C06701(this.$resultBundle, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    MqttAsyncClient mqttAsyncClient = MqttConnection.this.myClient;
                    Intrinsics.checkNotNull(mqttAsyncClient);
                    mqttAsyncClient.reconnect();
                } catch (MqttException e2) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C02101(e2, MqttConnection.this, this.$resultBundle, null), 3, null);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: info.mqtt.android.service.MqttConnection$reconnect$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MqttConnection.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "info.mqtt.android.service.MqttConnection$reconnect$1$1", f = "MqttConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C02101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MqttException $ex;
            final /* synthetic */ Bundle $resultBundle;
            int label;
            final /* synthetic */ MqttConnection this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02101(MqttException mqttException, MqttConnection mqttConnection, Bundle bundle, Continuation<? super C02101> continuation) {
                super(2, continuation);
                this.$ex = mqttException;
                this.this$0 = mqttConnection;
                this.$resultBundle = bundle;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02101(this.$ex, this.this$0, this.$resultBundle, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Timber.Companion companion = Timber.INSTANCE;
                MqttException mqttException = this.$ex;
                companion.e(mqttException, "Exception occurred attempting to reconnect: " + mqttException.getMessage(), new Object[0]);
                this.this$0.setConnectingState(false);
                this.this$0.handleException(this.$resultBundle, this.$ex);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void setConnectingState(boolean isConnecting) {
        this.isConnecting = isConnecting;
    }

    public final void setBufferOpts(DisconnectedBufferOptions bufferOpts) {
        this.disconnectedBufferOptions = bufferOpts;
        MqttAsyncClient mqttAsyncClient = this.myClient;
        Intrinsics.checkNotNull(mqttAsyncClient);
        mqttAsyncClient.setBufferOpts(bufferOpts);
    }

    public final int getBufferedMessageCount() {
        MqttAsyncClient mqttAsyncClient = this.myClient;
        Intrinsics.checkNotNull(mqttAsyncClient);
        return mqttAsyncClient.getBufferedMessageCount();
    }

    public final MqttMessage getBufferedMessage(int bufferIndex) {
        MqttAsyncClient mqttAsyncClient = this.myClient;
        Intrinsics.checkNotNull(mqttAsyncClient);
        MqttMessage bufferedMessage = mqttAsyncClient.getBufferedMessage(bufferIndex);
        Intrinsics.checkNotNullExpressionValue(bufferedMessage, "getBufferedMessage(...)");
        return bufferedMessage;
    }

    public final void deleteBufferedMessage(int bufferIndex) {
        MqttAsyncClient mqttAsyncClient = this.myClient;
        Intrinsics.checkNotNull(mqttAsyncClient);
        mqttAsyncClient.deleteBufferedMessage(bufferIndex);
    }

    public final int getInFlightMessageCount() {
        MqttAsyncClient mqttAsyncClient = this.myClient;
        Intrinsics.checkNotNull(mqttAsyncClient);
        return mqttAsyncClient.getInFlightMessageCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MqttConnection.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0092\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Linfo/mqtt/android/service/MqttConnection$MqttConnectionListener;", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "resultBundle", "Landroid/os/Bundle;", "<init>", "(Linfo/mqtt/android/service/MqttConnection;Landroid/os/Bundle;)V", "onSuccess", "", "asyncActionToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "onFailure", "exception", "", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    class MqttConnectionListener implements IMqttActionListener {
        private final Bundle resultBundle;
        final /* synthetic */ MqttConnection this$0;

        public MqttConnectionListener(MqttConnection mqttConnection, Bundle resultBundle) {
            Intrinsics.checkNotNullParameter(resultBundle, "resultBundle");
            this.this$0 = mqttConnection;
            this.resultBundle = resultBundle;
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onSuccess(IMqttToken asyncActionToken) {
            Intrinsics.checkNotNullParameter(asyncActionToken, "asyncActionToken");
            this.this$0.service.callbackToActivity(this.this$0.getClientHandle(), Status.OK, this.resultBundle);
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            this.resultBundle.putString(".errorMessage", exception != null ? exception.getLocalizedMessage() : null);
            this.resultBundle.putSerializable(".exception", exception);
            this.this$0.service.callbackToActivity(this.this$0.getClientHandle(), Status.ERROR, this.resultBundle);
        }
    }
}
