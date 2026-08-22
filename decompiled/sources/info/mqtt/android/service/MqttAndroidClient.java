package info.mqtt.android.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.socket.client.Manager;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.jivesoftware.smack.util.TLSUtils;
import timber.log.Timber;

/* JADX INFO: compiled from: MqttAndroidClient.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0087\u00012\u00020\u0001:\u0004\u0086\u0001\u0087\u0001BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010-\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0017H\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u001dH\u0016J\u001c\u00102\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J$\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u000201H\u0002J\u0018\u00109\u001a\u0002012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010:\u001a\u00020\u0017H\u0016J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<H\u0016J\u001c\u0010:\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\"\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0016J(\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\fH\u0016J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010D\u001a\u00020EH\u0016J<\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J,\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010D\u001a\u00020E2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0018\u0010F\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000eH\u0016J#\u0010F\u001a\u00020\u00172\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050G2\u0006\u0010B\u001a\u00020HH\u0016¢\u0006\u0002\u0010IJ,\u0010F\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J7\u0010F\u001a\u00020\u00172\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050G2\u0006\u0010B\u001a\u00020H2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0002\u0010JJ4\u0010F\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010L\u001a\u00020MH\u0016J \u0010F\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020MH\u0016J1\u0010F\u001a\u00020\u00172\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00050G2\u0006\u0010B\u001a\u00020H2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020M0GH\u0016¢\u0006\u0002\u0010PJE\u0010F\u001a\u00020\u00172\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00050G2\u0006\u0010B\u001a\u00020H2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\f\u0010O\u001a\b\u0012\u0004\u0012\u00020M0GH\u0016¢\u0006\u0002\u0010QJ\u0010\u0010R\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0005H\u0016J\u001b\u0010R\u001a\u00020\u00172\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050GH\u0016¢\u0006\u0002\u0010SJ$\u0010R\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J/\u0010R\u001a\u00020\u00172\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050G2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0002\u0010TJ\u0010\u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u00020>H\u0016J\u0013\u0010W\u001a\b\u0012\u0004\u0012\u00020>0GH\u0016¢\u0006\u0002\u0010XJ\u0010\u0010Y\u001a\u0002012\u0006\u00106\u001a\u00020!H\u0016J\u000e\u0010Z\u001a\u0002012\u0006\u00106\u001a\u00020!J\u000e\u0010[\u001a\u0002012\u0006\u00106\u001a\u00020!J\u0010\u0010\\\u001a\u0002012\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010]\u001a\u0002012\u0006\u0010%\u001a\u00020\fJ\u0010\u0010^\u001a\u0002012\u0006\u0010_\u001a\u00020`H\u0002J\u000e\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\u0005J\u0018\u0010c\u001a\u0002012\u0006\u0010b\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0016J\u0010\u0010d\u001a\u0002012\u0006\u0010e\u001a\u00020\fH\u0016J\b\u0010f\u001a\u000201H\u0016J\u0012\u0010g\u001a\u0002012\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0010\u0010h\u001a\u0002012\u0006\u0010_\u001a\u00020`H\u0002J\u0012\u0010i\u001a\u0002012\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0012\u0010j\u001a\u0002012\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u001a\u0010k\u001a\u0002012\b\u0010V\u001a\u0004\u0018\u00010\u00172\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010l\u001a\u0002012\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010m\u001a\u0002012\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010n\u001a\u0002012\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010o\u001a\u0002012\u0006\u0010_\u001a\u00020`H\u0002J\u0012\u0010p\u001a\u0002012\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0012\u0010q\u001a\u0002012\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J\u0012\u0010r\u001a\u0002012\b\u0010V\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010\u00172\u0006\u0010_\u001a\u00020`H\u0002J\u0012\u0010t\u001a\u0004\u0018\u00010\u00172\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010u\u001a\u0002012\u0006\u0010v\u001a\u00020wH\u0016J\b\u0010x\u001a\u00020\u000eH\u0016J\u0010\u0010y\u001a\u00020E2\u0006\u0010z\u001a\u00020\u000eH\u0016J\u0010\u0010{\u001a\u0002012\u0006\u0010z\u001a\u00020\u000eH\u0016J\b\u0010|\u001a\u00020\u000eH\u0016J\u001a\u0010}\u001a\u00020~2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u0005J\t\u0010\u0082\u0001\u001a\u000201H\u0016J\u0012\u0010\u0082\u0001\u001a\u0002012\u0007\u0010\u0083\u0001\u001a\u00020<H\u0016J\u001a\u0010\u0082\u0001\u001a\u0002012\u0006\u0010;\u001a\u00020<2\u0007\u0010\u0083\u0001\u001a\u00020<H\u0016J\u0007\u0010\u0084\u0001\u001a\u000201J\u0007\u0010\u0085\u0001\u001a\u000201R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Linfo/mqtt/android/service/MqttAndroidClient;", "Lorg/eclipse/paho/client/mqttv3/IMqttAsyncClient;", "context", "Landroid/content/Context;", "serverURI", "", "clientId", "ackType", "Linfo/mqtt/android/service/Ack;", "persistence", "Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;", "pingLogging", "", "keepPingRecords", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Linfo/mqtt/android/service/Ack;Lorg/eclipse/paho/client/mqttv3/MqttClientPersistence;ZI)V", "getContext", "()Landroid/content/Context;", "serviceConnection", "Linfo/mqtt/android/service/MqttAndroidClient$MyServiceConnection;", "tokenList", "", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "messageAck", "mqttService", "Linfo/mqtt/android/service/MqttService;", "clientHandle", "clientConnectOptions", "Lorg/eclipse/paho/client/mqttv3/MqttConnectOptions;", "connectToken", "callbacksList", "Ljava/util/ArrayList;", "Lorg/eclipse/paho/client/mqttv3/MqttCallback;", "Lkotlin/collections/ArrayList;", "traceCallback", "Linfo/mqtt/android/service/MqttTraceHandler;", "traceEnabled", "receiverRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "serviceBound", "clientJob", "Lkotlinx/coroutines/Job;", "clientScope", "Lkotlinx/coroutines/CoroutineScope;", "isConnected", "getClientId", "getServerURI", "close", "", "connect", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "userContext", "", "callback", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "collect", "doConnect", "disconnect", "quiesceTimeout", "", "publish", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "topic", "payload", "", "qos", "retained", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "subscribe", "", "", "([Ljava/lang/String;[I)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "([Ljava/lang/String;[ILjava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "topicFilter", "messageListener", "Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;", "topicFilters", "messageListeners", "([Ljava/lang/String;[I[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "([Ljava/lang/String;[ILjava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;[Lorg/eclipse/paho/client/mqttv3/IMqttMessageListener;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "unsubscribe", "([Ljava/lang/String;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "([Ljava/lang/String;Ljava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;)Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "removeMessage", "token", "getPendingDeliveryTokens", "()[Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "setCallback", "addCallback", "removeCallback", "setTraceCallback", "setTraceEnabled", "onReceive", "data", "Landroid/os/Bundle;", "acknowledgeMessage", "messageId", "messageArrivedComplete", "setManualAcks", "manualAcks", Manager.EVENT_RECONNECT, "connectAction", "disconnected", "connectionLostAction", "connectExtendedAction", "simpleAction", "sendAction", "subscribeAction", "unSubscribeAction", "messageDeliveredAction", "messageArrivedAction", "traceAction", "storeToken", "removeMqttToken", "getMqttToken", "setBufferOpts", "bufferOpts", "Lorg/eclipse/paho/client/mqttv3/DisconnectedBufferOptions;", "getBufferedMessageCount", "getBufferedMessage", "bufferIndex", "deleteBufferedMessage", "getInFlightMessageCount", "getSSLSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "keyStore", "Ljava/io/InputStream;", "password", "disconnectForcibly", "disconnectTimeout", "unregisterResources", "registerResources", "MyServiceConnection", "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MqttAndroidClient implements IMqttAsyncClient {
    private static final String SERVICE_NAME = MqttService.class.getName();
    private ArrayList<MqttCallback> callbacksList;
    private MqttConnectOptions clientConnectOptions;
    private String clientHandle;
    private final String clientId;
    private Job clientJob;
    private CoroutineScope clientScope;
    private IMqttToken connectToken;
    private final Context context;
    private final int keepPingRecords;
    private final Ack messageAck;
    private MqttService mqttService;
    private MqttClientPersistence persistence;
    private final boolean pingLogging;
    private volatile AtomicBoolean receiverRegistered;
    private final String serverURI;
    private volatile boolean serviceBound;
    private final MyServiceConnection serviceConnection;
    private final List<IMqttToken> tokenList;
    private MqttTraceHandler traceCallback;
    private boolean traceEnabled;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MqttAndroidClient(Context context, String serverURI, String clientId) {
        this(context, serverURI, clientId, null, null, false, 0, 120, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverURI, "serverURI");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MqttAndroidClient(Context context, String serverURI, String clientId, Ack ackType) {
        this(context, serverURI, clientId, ackType, null, false, 0, 112, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverURI, "serverURI");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(ackType, "ackType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MqttAndroidClient(Context context, String serverURI, String clientId, Ack ackType, MqttClientPersistence mqttClientPersistence) {
        this(context, serverURI, clientId, ackType, mqttClientPersistence, false, 0, 96, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverURI, "serverURI");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(ackType, "ackType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MqttAndroidClient(Context context, String serverURI, String clientId, Ack ackType, MqttClientPersistence mqttClientPersistence, boolean z) {
        this(context, serverURI, clientId, ackType, mqttClientPersistence, z, 0, 64, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverURI, "serverURI");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(ackType, "ackType");
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public int getInFlightMessageCount() {
        return 0;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void reconnect() throws MqttException {
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public boolean removeMessage(IMqttDeliveryToken token) throws MqttException {
        Intrinsics.checkNotNullParameter(token, "token");
        return false;
    }

    public MqttAndroidClient(Context context, String serverURI, String clientId, Ack ackType, MqttClientPersistence mqttClientPersistence, boolean z, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serverURI, "serverURI");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(ackType, "ackType");
        this.context = context;
        this.serverURI = serverURI;
        this.clientId = clientId;
        this.persistence = mqttClientPersistence;
        this.pingLogging = z;
        this.keepPingRecords = i;
        this.serviceConnection = new MyServiceConnection();
        this.tokenList = new ArrayList();
        this.messageAck = ackType;
        this.callbacksList = new ArrayList<>();
        this.receiverRegistered = new AtomicBoolean(false);
    }

    public /* synthetic */ MqttAndroidClient(Context context, String str, String str2, Ack ack, MqttClientPersistence mqttClientPersistence, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, (i2 & 8) != 0 ? Ack.AUTO_ACK : ack, (i2 & 16) != 0 ? null : mqttClientPersistence, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? 1000 : i);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public boolean isConnected() {
        MqttService mqttService;
        String str = this.clientHandle;
        if (str == null || (mqttService = this.mqttService) == null) {
            return false;
        }
        Intrinsics.checkNotNull(str);
        return mqttService.isConnected(str);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public String getClientId() {
        return this.clientId;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public String getServerURI() {
        return this.serverURI;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient, java.lang.AutoCloseable
    public void close() {
        MqttService mqttService = this.mqttService;
        if (mqttService != null) {
            if (this.clientHandle == null) {
                String str = this.serverURI;
                String str2 = this.clientId;
                String packageName = this.context.getApplicationInfo().packageName;
                Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                this.clientHandle = MqttService.getClient$default(mqttService, str, str2, packageName, this.persistence, false, 0, 48, null);
            }
            String str3 = this.clientHandle;
            Intrinsics.checkNotNull(str3);
            mqttService.close(str3);
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken connect() {
        return connect(null, null);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken connect(MqttConnectOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return connect(options, null, null);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken connect(Object userContext, IMqttActionListener callback) {
        return connect(new MqttConnectOptions(), userContext, callback);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken connect(MqttConnectOptions options, Object userContext, IMqttActionListener callback) {
        IMqttActionListener listener;
        Intrinsics.checkNotNullParameter(options, "options");
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, userContext, callback, null, 8, null);
        this.clientConnectOptions = options;
        this.connectToken = mqttTokenAndroid;
        ComponentName componentNameStartService = null;
        if (this.mqttService != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C06671(null), 3, null);
            return mqttTokenAndroid;
        }
        Intent intent = new Intent();
        intent.setClassName(this.context, SERVICE_NAME);
        try {
            componentNameStartService = this.context.startService(intent);
        } catch (IllegalStateException e2) {
            IMqttActionListener listener2 = mqttTokenAndroid.getListener();
            if (listener2 != null) {
                listener2.onFailure(mqttTokenAndroid, e2);
            }
        }
        if (componentNameStartService == null && (listener = mqttTokenAndroid.getListener()) != null) {
            listener.onFailure(mqttTokenAndroid, new RuntimeException("cannot start service " + SERVICE_NAME));
        }
        Boolean.valueOf(this.context.bindService(intent, this.serviceConnection, 1));
        return mqttTokenAndroid;
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttAndroidClient$connect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MqttAndroidClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttAndroidClient$connect$1", f = "MqttAndroidClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06671(Continuation<? super C06671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqttAndroidClient.this.new C06671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MqttAndroidClient mqttAndroidClient = MqttAndroidClient.this;
            mqttAndroidClient.doConnect(mqttAndroidClient.pingLogging, MqttAndroidClient.this.keepPingRecords);
            if (!MqttAndroidClient.this.receiverRegistered.get()) {
                MqttAndroidClient.this.collect();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void collect() {
        if (this.mqttService == null) {
            return;
        }
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.clientJob = completableJobSupervisorJob$default;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default));
        this.clientScope = CoroutineScope;
        if (CoroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }
        this.receiverRegistered.set(true);
    }

    /* JADX INFO: renamed from: info.mqtt.android.service.MqttAndroidClient$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: MqttAndroidClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "info.mqtt.android.service.MqttAndroidClient$collect$1", f = "MqttAndroidClient.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MqttAndroidClient.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: info.mqtt.android.service.MqttAndroidClient$collect$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MqttAndroidClient.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* synthetic */ class C02091 extends FunctionReferenceImpl implements Function1<Bundle, Unit> {
            C02091(Object obj) {
                super(1, obj, MqttAndroidClient.class, "onReceive", "onReceive(Landroid/os/Bundle;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                invoke2(bundle);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bundle p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                ((MqttAndroidClient) this.receiver).onReceive(p0);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MqttService mqttService = MqttAndroidClient.this.mqttService;
                if (mqttService != null) {
                    this.label = 1;
                    if (mqttService.collect(new C02091(MqttAndroidClient.this), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void doConnect(boolean pingLogging, int keepPingRecords) {
        if (this.clientHandle == null) {
            MqttService mqttService = this.mqttService;
            Intrinsics.checkNotNull(mqttService);
            String str = this.serverURI;
            String str2 = this.clientId;
            String packageName = this.context.getApplicationInfo().packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            this.clientHandle = mqttService.getClient(str, str2, packageName, this.persistence, pingLogging, keepPingRecords);
        }
        MqttService mqttService2 = this.mqttService;
        Intrinsics.checkNotNull(mqttService2);
        mqttService2.setTraceEnabled(this.traceEnabled);
        MqttService mqttService3 = this.mqttService;
        Intrinsics.checkNotNull(mqttService3);
        mqttService3.setTraceCallbackId(this.clientHandle);
        storeToken(this.connectToken);
        try {
            MqttService mqttService4 = this.mqttService;
            Intrinsics.checkNotNull(mqttService4);
            String str3 = this.clientHandle;
            Intrinsics.checkNotNull(str3);
            mqttService4.connect(str3, this.clientConnectOptions, this.connectToken);
        } catch (Exception e2) {
            IMqttToken iMqttToken = this.connectToken;
            Intrinsics.checkNotNull(iMqttToken);
            IMqttActionListener listener = iMqttToken.getListener();
            if (listener != null) {
                listener.onFailure(this.connectToken, e2);
            }
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken disconnect() {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, null, null, null, 8, null);
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.disconnect(str, null, mqttTokenAndroid);
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken disconnect(long quiesceTimeout) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, null, null, null, 8, null);
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.disconnect(str, quiesceTimeout, null, mqttTokenAndroid);
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken disconnect(Object userContext, IMqttActionListener callback) {
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, userContext, callback, null, 8, null);
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        if (mqttService != null) {
            String str = this.clientHandle;
            Intrinsics.checkNotNull(str);
            mqttService.disconnect(str, null, mqttTokenAndroid);
        }
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken disconnect(long quiesceTimeout, Object userContext, IMqttActionListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, userContext, callback, null, 8, null);
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.disconnect(str, quiesceTimeout, null, mqttTokenAndroid);
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken publish(String topic, byte[] payload, int qos, boolean retained) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(payload, "payload");
        return publish(topic, payload, qos, retained, null, null);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken publish(String topic, MqttMessage message) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(message, "message");
        return publish(topic, message, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken publish(String topic, byte[] payload, int qos, boolean retained, Object userContext, IMqttActionListener callback) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(payload, "payload");
        MqttMessage mqttMessage = new MqttMessage(payload);
        mqttMessage.setQos(qos);
        mqttMessage.setRetained(retained);
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid = new MqttDeliveryTokenAndroid(this, userContext, callback, mqttMessage);
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid2 = mqttDeliveryTokenAndroid;
        storeToken(mqttDeliveryTokenAndroid2);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttDeliveryTokenAndroid.setDelegate(mqttService.publish(str, topic, payload, QoS.INSTANCE.valueOf(qos), retained, null, mqttDeliveryTokenAndroid2));
        return mqttDeliveryTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken publish(String topic, MqttMessage message, Object userContext, IMqttActionListener callback) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(message, "message");
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid = new MqttDeliveryTokenAndroid(this, userContext, callback, message);
        MqttDeliveryTokenAndroid mqttDeliveryTokenAndroid2 = mqttDeliveryTokenAndroid;
        storeToken(mqttDeliveryTokenAndroid2);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttDeliveryTokenAndroid.setDelegate(mqttService.publish(str, topic, message, null, mqttDeliveryTokenAndroid2));
        return mqttDeliveryTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String topic, int qos) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        return subscribe(topic, qos, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String[] topic, int[] qos) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(qos, "qos");
        return subscribe(topic, qos, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String topic, int qos, Object userContext, IMqttActionListener callback) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, userContext, callback, new String[]{topic});
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.subscribe(str, topic, QoS.INSTANCE.valueOf(qos), (String) null, mqttTokenAndroid);
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String[] topic, int[] qos, Object userContext, IMqttActionListener callback) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(qos, "qos");
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, userContext, callback, topic);
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.subscribe(str, topic, qos, (String) null, mqttTokenAndroid);
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String topicFilter, int qos, Object userContext, IMqttActionListener callback, IMqttMessageListener messageListener) {
        Intrinsics.checkNotNullParameter(topicFilter, "topicFilter");
        Intrinsics.checkNotNullParameter(messageListener, "messageListener");
        return subscribe(new String[]{topicFilter}, new int[]{qos}, userContext, callback, new IMqttMessageListener[]{messageListener});
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String topicFilter, int qos, IMqttMessageListener messageListener) {
        Intrinsics.checkNotNullParameter(topicFilter, "topicFilter");
        Intrinsics.checkNotNullParameter(messageListener, "messageListener");
        return subscribe(topicFilter, qos, (Object) null, (IMqttActionListener) null, messageListener);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String[] topicFilters, int[] qos, IMqttMessageListener[] messageListeners) {
        Intrinsics.checkNotNullParameter(topicFilters, "topicFilters");
        Intrinsics.checkNotNullParameter(qos, "qos");
        Intrinsics.checkNotNullParameter(messageListeners, "messageListeners");
        return subscribe(topicFilters, qos, (Object) null, (IMqttActionListener) null, messageListeners);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken subscribe(String[] topicFilters, int[] qos, Object userContext, IMqttActionListener callback, IMqttMessageListener[] messageListeners) {
        Intrinsics.checkNotNullParameter(topicFilters, "topicFilters");
        Intrinsics.checkNotNullParameter(qos, "qos");
        Intrinsics.checkNotNullParameter(messageListeners, "messageListeners");
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, userContext, callback, topicFilters);
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        ArrayList arrayList = new ArrayList(qos.length);
        for (int i : qos) {
            arrayList.add(QoS.INSTANCE.valueOf(i));
        }
        mqttService.subscribe(str, topicFilters, (QoS[]) arrayList.toArray(new QoS[0]), null, mqttTokenAndroid, messageListeners);
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken unsubscribe(String topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        return unsubscribe(topic, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken unsubscribe(String[] topic) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        return unsubscribe(topic, (Object) null, (IMqttActionListener) null);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken unsubscribe(String topic, Object userContext, IMqttActionListener callback) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, userContext, callback, null, 8, null);
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.unsubscribe(str, topic, (String) null, mqttTokenAndroid);
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttToken unsubscribe(String[] topic, Object userContext, IMqttActionListener callback) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        MqttTokenAndroid mqttTokenAndroid = new MqttTokenAndroid(this, userContext, callback, null, 8, null);
        storeToken(mqttTokenAndroid);
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.unsubscribe(str, topic, (String) null, mqttTokenAndroid);
        return mqttTokenAndroid;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        return mqttService.getPendingDeliveryTokens(str);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void setCallback(MqttCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacksList.clear();
        this.callbacksList.add(callback);
    }

    public final void addCallback(MqttCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacksList.add(callback);
    }

    public final void removeCallback(MqttCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacksList.remove(callback);
    }

    public final void setTraceCallback(MqttTraceHandler traceCallback) {
        this.traceCallback = traceCallback;
    }

    public final void setTraceEnabled(boolean traceEnabled) {
        this.traceEnabled = traceEnabled;
        MqttService mqttService = this.mqttService;
        if (mqttService != null) {
            mqttService.setTraceEnabled(traceEnabled);
        }
    }

    public final boolean acknowledgeMessage(String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (this.messageAck == Ack.MANUAL_ACK) {
            MqttService mqttService = this.mqttService;
            Intrinsics.checkNotNull(mqttService);
            String str = this.clientHandle;
            Intrinsics.checkNotNull(str);
            if (mqttService.acknowledgeMessageArrival(str, messageId) == Status.OK) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void messageArrivedComplete(int messageId, int qos) throws MqttException {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void setManualAcks(boolean manualAcks) {
        throw new UnsupportedOperationException();
    }

    private final void connectAction(Bundle data) {
        IMqttToken iMqttToken = this.connectToken;
        MqttTokenAndroid mqttTokenAndroid = (MqttTokenAndroid) iMqttToken;
        Intrinsics.checkNotNull(mqttTokenAndroid);
        Intrinsics.checkNotNull(data);
        mqttTokenAndroid.setDelegate(new MqttConnectTokenAndroid(data.getBoolean("sessionPresent")));
        removeMqttToken(data);
        simpleAction(iMqttToken, data);
    }

    private final void disconnected(Bundle data) {
        this.clientHandle = null;
        IMqttToken iMqttTokenRemoveMqttToken = removeMqttToken(data);
        if (iMqttTokenRemoveMqttToken != null) {
            ((MqttTokenAndroid) iMqttTokenRemoveMqttToken).notifyComplete();
        }
        Iterator<T> it = this.callbacksList.iterator();
        while (it.hasNext()) {
            ((MqttCallback) it.next()).connectionLost(null);
        }
    }

    private final void connectExtendedAction(Bundle data) {
        Intrinsics.checkNotNull(data);
        boolean z = data.getBoolean(".reconnect", false);
        String string = data.getString(".serverURI");
        for (MqttCallback mqttCallback : this.callbacksList) {
            if (mqttCallback instanceof MqttCallbackExtended) {
                ((MqttCallbackExtended) mqttCallback).connectComplete(z, string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence simpleAction$lambda$6(Bundle bundle, String str) {
        return str + "=" + bundle.getString(str);
    }

    private final void sendAction(Bundle data) {
        simpleAction(getMqttToken(data), data);
    }

    private final void subscribeAction(Bundle data) {
        simpleAction(removeMqttToken(data), data);
    }

    private final void unSubscribeAction(Bundle data) {
        simpleAction(removeMqttToken(data), data);
    }

    private final void messageDeliveredAction(Bundle data) {
        Object serializable;
        IMqttToken iMqttTokenRemoveMqttToken = removeMqttToken(data);
        if (Build.VERSION.SDK_INT >= 33) {
            serializable = data.getSerializable(".callbackStatus", Status.class);
        } else {
            Object serializable2 = data.getSerializable(".callbackStatus");
            if (!(serializable2 instanceof Status)) {
                serializable2 = null;
            }
            serializable = (Serializable) ((Status) serializable2);
        }
        Status status = (Status) serializable;
        if (iMqttTokenRemoveMqttToken != null && status == Status.OK && (iMqttTokenRemoveMqttToken instanceof IMqttDeliveryToken)) {
            Iterator<T> it = this.callbacksList.iterator();
            while (it.hasNext()) {
                ((MqttCallback) it.next()).deliveryComplete((IMqttDeliveryToken) iMqttTokenRemoveMqttToken);
            }
        }
    }

    private final void messageArrivedAction(Bundle data) {
        ParcelableMqttMessage parcelableMqttMessage;
        Intrinsics.checkNotNull(data);
        String string = data.getString("messageId");
        Intrinsics.checkNotNull(string);
        String string2 = data.getString("destinationName");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelableMqttMessage = (Parcelable) data.getParcelable(".PARCEL", ParcelableMqttMessage.class);
        } else {
            Parcelable parcelable = data.getParcelable(".PARCEL");
            if (!(parcelable instanceof ParcelableMqttMessage)) {
                parcelable = null;
            }
            parcelableMqttMessage = (ParcelableMqttMessage) parcelable;
        }
        Intrinsics.checkNotNull(parcelableMqttMessage);
        ParcelableMqttMessage parcelableMqttMessage2 = (ParcelableMqttMessage) parcelableMqttMessage;
        try {
            if (this.messageAck != Ack.AUTO_ACK) {
                parcelableMqttMessage2.setMessageId(string);
                Iterator<T> it = this.callbacksList.iterator();
                while (it.hasNext()) {
                    ((MqttCallback) it.next()).messageArrived(string2, parcelableMqttMessage2);
                }
                return;
            }
            Iterator<T> it2 = this.callbacksList.iterator();
            while (it2.hasNext()) {
                ((MqttCallback) it2.next()).messageArrived(string2, parcelableMqttMessage2);
            }
            MqttService mqttService = this.mqttService;
            Intrinsics.checkNotNull(mqttService);
            String str = this.clientHandle;
            Intrinsics.checkNotNull(str);
            mqttService.acknowledgeMessageArrival(str, string);
        } catch (Exception e2) {
            Timber.INSTANCE.e("failed: " + e2, new Object[0]);
            MqttService mqttService2 = this.mqttService;
            Intrinsics.checkNotNull(mqttService2);
            mqttService2.traceError("messageArrivedAction failed: " + e2);
        }
    }

    private final void traceAction(Bundle data) {
        Object serializable;
        MqttTraceHandler mqttTraceHandler = this.traceCallback;
        if (mqttTraceHandler != null) {
            Intrinsics.checkNotNull(data);
            String string = data.getString(".traceSeverity");
            String string2 = data.getString(".errorMessage");
            if (Intrinsics.areEqual(string, "debug")) {
                mqttTraceHandler.traceDebug(string2);
                return;
            }
            if (Intrinsics.areEqual(string, "error")) {
                mqttTraceHandler.traceError(string2);
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                serializable = data.getSerializable(".exception", Exception.class);
            } else {
                Object serializable2 = data.getSerializable(".exception");
                if (!(serializable2 instanceof Exception)) {
                    serializable2 = null;
                }
                serializable = (Serializable) ((Exception) serializable2);
            }
            mqttTraceHandler.traceException(string2, (Exception) serializable);
        }
    }

    private final synchronized void storeToken(IMqttToken token) {
        Object next;
        if (token != null) {
            Iterator<T> it = this.tokenList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual((IMqttToken) next, token)) {
                        break;
                    }
                }
            }
            if (((IMqttToken) next) == null) {
                this.tokenList.add(token);
                Timber.INSTANCE.d(token + " size=" + this.tokenList.size(), new Object[0]);
            }
        }
    }

    private final synchronized IMqttToken removeMqttToken(Bundle data) {
        String string = data.getString(".activityToken");
        Object obj = null;
        if (string == null || Intrinsics.areEqual(string, Constants.NULL_VERSION_ID)) {
            return null;
        }
        Iterator<T> it = this.tokenList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((IMqttToken) next).toString(), string)) {
                obj = next;
                break;
            }
        }
        IMqttToken iMqttToken = (IMqttToken) obj;
        TypeIntrinsics.asMutableCollection(this.tokenList).remove(iMqttToken);
        Timber.INSTANCE.d("search=" + string + " " + this.tokenList.size(), new Object[0]);
        return iMqttToken;
    }

    private final synchronized IMqttToken getMqttToken(Bundle data) {
        Object next;
        String string = data.getString(".activityToken");
        Iterator<T> it = this.tokenList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((IMqttToken) next).toString(), string)) {
                break;
            }
        }
        return (IMqttToken) next;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void setBufferOpts(DisconnectedBufferOptions bufferOpts) {
        Intrinsics.checkNotNullParameter(bufferOpts, "bufferOpts");
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.setBufferOpts(str, bufferOpts);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public int getBufferedMessageCount() {
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        return mqttService.getBufferedMessageCount(str);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public MqttMessage getBufferedMessage(int bufferIndex) {
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        return mqttService.getBufferedMessage(str, bufferIndex);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void deleteBufferedMessage(int bufferIndex) {
        MqttService mqttService = this.mqttService;
        Intrinsics.checkNotNull(mqttService);
        String str = this.clientHandle;
        Intrinsics.checkNotNull(str);
        mqttService.deleteBufferedMessage(str, bufferIndex);
    }

    public final SSLSocketFactory getSSLSocketFactory(InputStream keyStore, String password) throws MqttSecurityException {
        Intrinsics.checkNotNullParameter(password, "password");
        try {
            KeyStore keyStore2 = KeyStore.getInstance("BKS");
            Intrinsics.checkNotNullExpressionValue(keyStore2, "getInstance(...)");
            char[] charArray = password.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            keyStore2.load(keyStore, charArray);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore2);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            SSLContext sSLContext = SSLContext.getInstance(TLSUtils.PROTO_TLSV1);
            Intrinsics.checkNotNullExpressionValue(sSLContext, "getInstance(...)");
            sSLContext.init(null, trustManagers, null);
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
            return socketFactory;
        } catch (IOException e2) {
            throw new MqttSecurityException(e2);
        } catch (KeyManagementException e3) {
            throw new MqttSecurityException(e3);
        } catch (KeyStoreException e4) {
            throw new MqttSecurityException(e4);
        } catch (NoSuchAlgorithmException e5) {
            throw new MqttSecurityException(e5);
        } catch (CertificateException e6) {
            throw new MqttSecurityException(e6);
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void disconnectForcibly() throws MqttException {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void disconnectForcibly(long disconnectTimeout) throws MqttException {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttAsyncClient
    public void disconnectForcibly(long quiesceTimeout, long disconnectTimeout) throws MqttException {
        throw new UnsupportedOperationException();
    }

    public final void unregisterResources() {
        if (this.receiverRegistered.get()) {
            synchronized (this) {
                Job job = this.clientJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.clientJob = null;
                this.clientScope = null;
                this.receiverRegistered.set(false);
                Unit unit = Unit.INSTANCE;
            }
            if (this.serviceBound) {
                try {
                    this.context.unbindService(this.serviceConnection);
                    this.serviceBound = false;
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public final void registerResources() {
        if (this.receiverRegistered.get()) {
            return;
        }
        collect();
    }

    /* JADX INFO: compiled from: MqttAndroidClient.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Linfo/mqtt/android/service/MqttAndroidClient$MyServiceConnection;", "Landroid/content/ServiceConnection;", "<init>", "(Linfo/mqtt/android/service/MqttAndroidClient;)V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class MyServiceConnection implements ServiceConnection {
        public MyServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(binder, "binder");
            if (MqttServiceBinder.class.isAssignableFrom(binder.getClass())) {
                MqttAndroidClient.this.mqttService = ((MqttServiceBinder) binder).getService();
                MqttAndroidClient.this.serviceBound = true;
                MqttAndroidClient.this.collect();
                MqttAndroidClient mqttAndroidClient = MqttAndroidClient.this;
                mqttAndroidClient.doConnect(mqttAndroidClient.pingLogging, MqttAndroidClient.this.keepPingRecords);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Timber.INSTANCE.d("Service disconnected", new Object[0]);
            MqttAndroidClient.this.mqttService = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onReceive(Bundle data) {
        Object serializable;
        if (Build.VERSION.SDK_INT >= 33) {
            serializable = data.getSerializable(".callbackStatus", Status.class);
        } else {
            Object serializable2 = data.getSerializable(".callbackStatus");
            if (!(serializable2 instanceof Status)) {
                serializable2 = null;
            }
            serializable = (Serializable) ((Status) serializable2);
        }
        Status status = (Status) serializable;
        if (status == Status.ERROR) {
            Timber.INSTANCE.e(status + " " + data, new Object[0]);
        } else {
            String string = data.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase.contentEquals("exception")) {
                Timber.INSTANCE.w(status + " " + data, new Object[0]);
            } else {
                Timber.INSTANCE.v(status + " " + data, new Object[0]);
            }
        }
        String string2 = data.getString(".clientHandle");
        if (string2 == null || !Intrinsics.areEqual(string2, this.clientHandle)) {
            return;
        }
        String string3 = data.getString(".callbackAction");
        if (Intrinsics.areEqual("connect", string3)) {
            connectAction(data);
            return;
        }
        if (Intrinsics.areEqual("connectExtended", string3)) {
            connectExtendedAction(data);
            return;
        }
        if (Intrinsics.areEqual("messageArrived", string3)) {
            messageArrivedAction(data);
            return;
        }
        if (Intrinsics.areEqual("subscribe", string3)) {
            subscribeAction(data);
            return;
        }
        if (Intrinsics.areEqual("unsubscribe", string3)) {
            unSubscribeAction(data);
            return;
        }
        if (Intrinsics.areEqual("send", string3)) {
            sendAction(data);
            return;
        }
        if (Intrinsics.areEqual("messageDelivered", string3)) {
            messageDeliveredAction(data);
            return;
        }
        if (Intrinsics.areEqual("onConnectionLost", string3)) {
            connectionLostAction(data);
            return;
        }
        if (Intrinsics.areEqual("disconnect", string3)) {
            disconnected(data);
        } else {
            if (Intrinsics.areEqual("trace", string3)) {
                traceAction(data);
                return;
            }
            MqttService mqttService = this.mqttService;
            Intrinsics.checkNotNull(mqttService);
            mqttService.traceError("Callback action doesn't exist.");
        }
    }

    private final void connectionLostAction(Bundle data) {
        Exception serializable;
        if (data != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                serializable = data.getSerializable(".exception", Exception.class);
            } else {
                Serializable serializable2 = data.getSerializable(".exception");
                serializable = (Exception) (serializable2 instanceof Exception ? serializable2 : null);
            }
            serializable = (Exception) serializable;
        }
        Iterator<T> it = this.callbacksList.iterator();
        while (it.hasNext()) {
            ((MqttCallback) it.next()).connectionLost((Throwable) serializable);
        }
    }

    private final void simpleAction(IMqttToken token, final Bundle data) {
        Object serializable;
        Object serializable2;
        Object serializable3;
        if (token == null) {
            MqttService mqttService = this.mqttService;
            Intrinsics.checkNotNull(mqttService);
            mqttService.traceError("simpleAction : token is null");
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            serializable = data.getSerializable(".callbackStatus", Status.class);
        } else {
            Object serializable4 = data.getSerializable(".callbackStatus");
            if (!(serializable4 instanceof Status)) {
                serializable4 = null;
            }
            serializable = (Serializable) ((Status) serializable4);
        }
        if (((Status) serializable) == Status.OK) {
            ((MqttTokenAndroid) token).notifyComplete();
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            serializable2 = data.getSerializable(".errorMessage", String.class);
        } else {
            Object serializable5 = data.getSerializable(".errorMessage");
            if (!(serializable5 instanceof String)) {
                serializable5 = null;
            }
            serializable2 = (Serializable) ((String) serializable5);
        }
        String str = (String) serializable2;
        if (Build.VERSION.SDK_INT >= 33) {
            serializable3 = data.getSerializable(".exception", Throwable.class);
        } else {
            Object serializable6 = data.getSerializable(".exception");
            serializable3 = (Serializable) ((Throwable) (serializable6 instanceof Throwable ? serializable6 : null));
        }
        Throwable th = (Throwable) serializable3;
        if (th == null && str != null) {
            th = new Throwable(str);
        } else if (th == null) {
            Set<String> setKeySet = data.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
            th = new Throwable("No Throwable given\n" + CollectionsKt.joinToString$default(setKeySet, ", ", "{", "}", 0, null, new Function1() { // from class: info.mqtt.android.service.MqttAndroidClient$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MqttAndroidClient.simpleAction$lambda$6(data, (String) obj);
                }
            }, 24, null));
        }
        ((MqttTokenAndroid) token).notifyFailure(th);
    }
}
