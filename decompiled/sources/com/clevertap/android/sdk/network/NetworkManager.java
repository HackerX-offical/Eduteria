package com.clevertap.android.sdk.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplate;
import com.clevertap.android.sdk.interfaces.NotificationRenderedListener;
import com.clevertap.android.sdk.network.api.CtApi;
import com.clevertap.android.sdk.network.api.CtApiWrapper;
import com.clevertap.android.sdk.network.api.DefineTemplatesRequestBody;
import com.clevertap.android.sdk.network.api.EncryptedSendQueueRequestBody;
import com.clevertap.android.sdk.network.api.EncryptionFailure;
import com.clevertap.android.sdk.network.api.EncryptionResult;
import com.clevertap.android.sdk.network.api.EncryptionSuccess;
import com.clevertap.android.sdk.network.api.SendQueueRequestBody;
import com.clevertap.android.sdk.network.http.Response;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.clevertap.android.sdk.pushnotification.PushNotificationUtil;
import com.clevertap.android.sdk.response.ARPResponse;
import com.clevertap.android.sdk.response.ClevertapResponseHandler;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0000\u0018\u0000 p2\u00020\u0001:\u0001pBy\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&J\u000e\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020&J(\u0010+\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020!J\u0018\u00103\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0007J\u0010\u00106\u001a\u0002012\u0006\u0010,\u001a\u00020-H\u0007J\u0012\u0010:\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020-H\u0007J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020/H\u0002J\u0014\u0010=\u001a\u0004\u0018\u00010>2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0018\u0010?\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0003J\u0010\u0010C\u001a\u0002012\u0006\u0010A\u001a\u00020BH\u0002J4\u0010D\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u000201J.\u0010G\u001a\u0002012\u0006\u0010,\u001a\u00020-2\u0006\u0010H\u001a\u00020I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020(0K2\u0006\u00100\u001a\u000201H\u0002J\u0018\u0010L\u001a\u00020(2\u0006\u0010H\u001a\u00020I2\u0006\u0010M\u001a\u00020NH\u0002J\u0016\u0010O\u001a\u0002012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0QH\u0007J\u001a\u0010S\u001a\u00020(2\b\u0010T\u001a\u0004\u0018\u00010>2\u0006\u0010M\u001a\u00020NH\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010>2\u0006\u0010V\u001a\u00020/H\u0007J\u0018\u0010W\u001a\u00020B2\u0006\u0010,\u001a\u00020-2\u0006\u0010X\u001a\u00020IH\u0003J\u0010\u0010Y\u001a\u00020B2\u0006\u0010X\u001a\u00020IH\u0002J\u0010\u0010Z\u001a\u00020B2\u0006\u0010X\u001a\u00020IH\u0002J\u0010\u0010[\u001a\u0002012\u0006\u0010A\u001a\u00020BH\u0002J\u0018\u0010\\\u001a\u00020(2\u0006\u0010A\u001a\u00020B2\u0006\u0010]\u001a\u00020/H\u0002J\u0010\u0010^\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010_\u001a\u0002012\u0006\u0010A\u001a\u00020BH\u0003J.\u0010`\u001a\u0002012\u0006\u0010A\u001a\u00020B2\u0006\u0010a\u001a\u0002012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020(0K2\u0006\u00100\u001a\u000201H\u0003J\u000e\u0010b\u001a\u0002012\u0006\u0010A\u001a\u00020BJ\u0010\u0010c\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010d\u001a\u0002012\u0006\u0010X\u001a\u00020IH\u0002J\u0010\u0010e\u001a\u00020(2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010f\u001a\u00020(2\u0006\u0010g\u001a\u00020/H\u0002J\u0012\u0010h\u001a\u00020(2\b\u0010i\u001a\u0004\u0018\u00010/H\u0003J\u0010\u0010j\u001a\u00020(2\u0006\u0010k\u001a\u00020!H\u0002J\u0010\u0010l\u001a\u00020(2\u0006\u0010m\u001a\u00020/H\u0003J\u0010\u0010n\u001a\u00020(2\u0006\u0010o\u001a\u000201H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006q"}, d2 = {"Lcom/clevertap/android/sdk/network/NetworkManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "deviceInfo", "Lcom/clevertap/android/sdk/DeviceInfo;", "coreMetaData", "Lcom/clevertap/android/sdk/CoreMetaData;", "controllerManager", "Lcom/clevertap/android/sdk/ControllerManager;", "databaseManager", "Lcom/clevertap/android/sdk/db/BaseDatabaseManager;", "callbackManager", "Lcom/clevertap/android/sdk/BaseCallbackManager;", "ctApiWrapper", "Lcom/clevertap/android/sdk/network/api/CtApiWrapper;", "encryptionManager", "Lcom/clevertap/android/sdk/network/NetworkEncryptionManager;", "arpResponse", "Lcom/clevertap/android/sdk/response/ARPResponse;", "networkRepo", "Lcom/clevertap/android/sdk/network/NetworkRepo;", "queueHeaderBuilder", "Lcom/clevertap/android/sdk/network/QueueHeaderBuilder;", "cleverTapResponseHandler", "Lcom/clevertap/android/sdk/response/ClevertapResponseHandler;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "<init>", "(Landroid/content/Context;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Lcom/clevertap/android/sdk/DeviceInfo;Lcom/clevertap/android/sdk/CoreMetaData;Lcom/clevertap/android/sdk/ControllerManager;Lcom/clevertap/android/sdk/db/BaseDatabaseManager;Lcom/clevertap/android/sdk/BaseCallbackManager;Lcom/clevertap/android/sdk/network/api/CtApiWrapper;Lcom/clevertap/android/sdk/network/NetworkEncryptionManager;Lcom/clevertap/android/sdk/response/ARPResponse;Lcom/clevertap/android/sdk/network/NetworkRepo;Lcom/clevertap/android/sdk/network/QueueHeaderBuilder;Lcom/clevertap/android/sdk/response/ClevertapResponseHandler;Lcom/clevertap/android/sdk/ILogger;)V", "responseFailureCount", "", "networkRetryCount", "minDelayFrequency", "mNetworkHeadersListeners", "", "Lcom/clevertap/android/sdk/network/NetworkHeadersListener;", "addNetworkHeadersListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeNetworkHeadersListener", "flushDBQueue", "eventGroup", "Lcom/clevertap/android/sdk/events/EventGroup;", "caller", "", "isUserSwitchFlush", "", "getDelayFrequency", "initHandshake", "handshakeSuccessCallback", "Ljava/lang/Runnable;", "needsHandshakeForDomain", "currentRequestTimestamp", "getCurrentRequestTimestamp", "()I", "getDomain", "hasDomainChanged", "newDomain", "getQueueHeader", "Lorg/json/JSONObject;", "performHandshakeForDomain", "saveDomainChanges", SaslNonza.Response.ELEMENT, "Lcom/clevertap/android/sdk/network/http/Response;", "shouldMuteSdk", "sendQueue", "queue", "Lorg/json/JSONArray;", "networkCall", "requestBody", "Lcom/clevertap/android/sdk/network/api/SendQueueRequestBody;", "notifyNetworkHeaderListeners", "Lkotlin/Function0;", "notifyHeaderListeners", "endpointId", "Lcom/clevertap/android/sdk/network/EndpointId;", "defineTemplates", "templates", "", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplate;", "applyQueueHeaderListeners", "queueHeader", "fetchInAppPreviewPayloadFromUrl", "url", "callApiForEventGroup", "body", "sendQueueApi", "sendImpressionsApi", "handleVariablesResponse", "handleVarsOrTemplatesResponseError", "logTag", "handleTemplateResponseSuccess", "handlePushImpressionsResponse", "handleSendQueueResponse", "isFullResponse", "abortDueToDomainChange", "handleSendQueueResponseError", "doesBodyContainAppLaunchedOrFetchEvents", "notifyListenersForPushImpressionSentToServer", "notifyListenerForPushImpressionSentToServer", "listenerKey", "setDomain", "domainName", "setFirstRequestTimestampIfNeeded", CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, "setSpikyDomain", "spikyDomainName", "setMuted", "mute", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkManager {
    private static final int BATCH_SIZE = 50;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ARPResponse arpResponse;
    private final BaseCallbackManager callbackManager;
    private final ClevertapResponseHandler cleverTapResponseHandler;
    private final CleverTapInstanceConfig config;
    private final Context context;
    private final ControllerManager controllerManager;
    private final CoreMetaData coreMetaData;
    private final CtApiWrapper ctApiWrapper;
    private final BaseDatabaseManager databaseManager;
    private final DeviceInfo deviceInfo;
    private final NetworkEncryptionManager encryptionManager;
    private final ILogger logger;
    private final List<NetworkHeadersListener> mNetworkHeadersListeners;
    private int minDelayFrequency;
    private final NetworkRepo networkRepo;
    private int networkRetryCount;
    private final QueueHeaderBuilder queueHeaderBuilder;
    private int responseFailureCount;

    /* JADX INFO: compiled from: NetworkManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventGroup.values().length];
            try {
                iArr[EventGroup.VARIABLES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventGroup.REGULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventGroup.PUSH_NOTIFICATION_VIEWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final boolean isNetworkOnline(Context context) {
        return INSTANCE.isNetworkOnline(context);
    }

    public NetworkManager(Context context, CleverTapInstanceConfig config, DeviceInfo deviceInfo, CoreMetaData coreMetaData, ControllerManager controllerManager, BaseDatabaseManager databaseManager, BaseCallbackManager callbackManager, CtApiWrapper ctApiWrapper, NetworkEncryptionManager encryptionManager, ARPResponse arpResponse, NetworkRepo networkRepo, QueueHeaderBuilder queueHeaderBuilder, ClevertapResponseHandler cleverTapResponseHandler, ILogger logger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(coreMetaData, "coreMetaData");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(databaseManager, "databaseManager");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(ctApiWrapper, "ctApiWrapper");
        Intrinsics.checkNotNullParameter(encryptionManager, "encryptionManager");
        Intrinsics.checkNotNullParameter(arpResponse, "arpResponse");
        Intrinsics.checkNotNullParameter(networkRepo, "networkRepo");
        Intrinsics.checkNotNullParameter(queueHeaderBuilder, "queueHeaderBuilder");
        Intrinsics.checkNotNullParameter(cleverTapResponseHandler, "cleverTapResponseHandler");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.context = context;
        this.config = config;
        this.deviceInfo = deviceInfo;
        this.coreMetaData = coreMetaData;
        this.controllerManager = controllerManager;
        this.databaseManager = databaseManager;
        this.callbackManager = callbackManager;
        this.ctApiWrapper = ctApiWrapper;
        this.encryptionManager = encryptionManager;
        this.arpResponse = arpResponse;
        this.networkRepo = networkRepo;
        this.queueHeaderBuilder = queueHeaderBuilder;
        this.cleverTapResponseHandler = cleverTapResponseHandler;
        this.logger = logger;
        this.mNetworkHeadersListeners = new ArrayList();
    }

    public /* synthetic */ NetworkManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, CoreMetaData coreMetaData, ControllerManager controllerManager, BaseDatabaseManager baseDatabaseManager, BaseCallbackManager baseCallbackManager, CtApiWrapper ctApiWrapper, NetworkEncryptionManager networkEncryptionManager, ARPResponse aRPResponse, NetworkRepo networkRepo, QueueHeaderBuilder queueHeaderBuilder, ClevertapResponseHandler clevertapResponseHandler, ILogger iLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, cleverTapInstanceConfig, deviceInfo, coreMetaData, controllerManager, baseDatabaseManager, baseCallbackManager, ctApiWrapper, networkEncryptionManager, aRPResponse, networkRepo, queueHeaderBuilder, clevertapResponseHandler, (i & 8192) != 0 ? cleverTapInstanceConfig.getLogger() : iLogger);
    }

    /* JADX INFO: compiled from: NetworkManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/network/NetworkManager$Companion;", "", "<init>", "()V", "BATCH_SIZE", "", "isNetworkOnline", "", "context", "Landroid/content/Context;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean isNetworkOnline(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService = context.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager == null) {
                    return true;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    public final void addNetworkHeadersListener(NetworkHeadersListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mNetworkHeadersListeners.add(listener);
    }

    public final void removeNetworkHeadersListener(NetworkHeadersListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mNetworkHeadersListeners.remove(listener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00eb, code lost:
    
        r4 = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void flushDBQueue(android.content.Context r12, com.clevertap.android.sdk.events.EventGroup r13, java.lang.String r14, boolean r15) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.network.NetworkManager.flushDBQueue(android.content.Context, com.clevertap.android.sdk.events.EventGroup, java.lang.String, boolean):void");
    }

    public final int getDelayFrequency() {
        this.minDelayFrequency = this.networkRepo.getMinDelayFrequency(this.minDelayFrequency, this.networkRetryCount);
        this.logger.debug(this.config.getAccountId(), "Setting delay frequency to " + this.minDelayFrequency);
        return this.minDelayFrequency;
    }

    public final void initHandshake(EventGroup eventGroup, Runnable handshakeSuccessCallback) {
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        Intrinsics.checkNotNullParameter(handshakeSuccessCallback, "handshakeSuccessCallback");
        this.responseFailureCount = 0;
        performHandshakeForDomain(eventGroup, handshakeSuccessCallback);
    }

    public final boolean needsHandshakeForDomain(EventGroup eventGroup) {
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        boolean zNeedsHandshake = this.ctApiWrapper.needsHandshake(eventGroup == EventGroup.PUSH_NOTIFICATION_VIEWED);
        boolean z = this.responseFailureCount > 5;
        if (z) {
            setDomain(null);
        }
        return zNeedsHandshake || z;
    }

    public final int getCurrentRequestTimestamp() {
        return this.ctApiWrapper.getCtApi().getCurrentRequestTimestampSeconds();
    }

    public final String getDomain(EventGroup eventGroup) {
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        return this.ctApiWrapper.getCtApi().getActualDomain(eventGroup == EventGroup.PUSH_NOTIFICATION_VIEWED);
    }

    private final boolean hasDomainChanged(String newDomain) {
        return !Intrinsics.areEqual(newDomain, this.networkRepo.getDomain());
    }

    private final JSONObject getQueueHeader(String caller) {
        return this.queueHeaderBuilder.buildHeader(caller);
    }

    public final void performHandshakeForDomain(EventGroup eventGroup, Runnable handshakeSuccessCallback) {
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        Intrinsics.checkNotNullParameter(handshakeSuccessCallback, "handshakeSuccessCallback");
        try {
            Response responsePerformHandshakeForDomain = this.ctApiWrapper.getCtApi().performHandshakeForDomain(eventGroup == EventGroup.PUSH_NOTIFICATION_VIEWED);
            try {
                Response response = responsePerformHandshakeForDomain;
                if (response.isSuccess()) {
                    this.logger.verbose(this.config.getAccountId(), "Received success from handshake :)");
                    if (shouldMuteSdk(response)) {
                        CloseableKt.closeFinally(responsePerformHandshakeForDomain, null);
                        return;
                    } else {
                        saveDomainChanges(response);
                        this.logger.verbose(this.config.getAccountId(), "We are not muted");
                        handshakeSuccessCallback.run();
                    }
                } else {
                    this.logger.verbose(this.config.getAccountId(), "Invalid HTTP status code received for handshake - " + response.getCode());
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(responsePerformHandshakeForDomain, null);
            } finally {
            }
        } catch (Exception e2) {
            this.logger.verbose(this.config.getAccountId(), "Failed to perform handshake!", e2);
        }
    }

    private final void saveDomainChanges(Response response) {
        String headerValue = response.getHeaderValue(CtApi.HEADER_DOMAIN_NAME);
        Logger.v("Getting domain from header - " + headerValue);
        String str = headerValue;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        String headerValue2 = response.getHeaderValue(CtApi.SPIKY_HEADER_DOMAIN_NAME);
        Logger.v("Getting spiky domain from header - " + headerValue2);
        setMuted(false);
        setDomain(headerValue);
        Logger.v("Setting spiky domain from header as -" + headerValue2);
        if (headerValue2 == null) {
            setSpikyDomain(headerValue);
        } else {
            setSpikyDomain(headerValue2);
        }
    }

    private final boolean shouldMuteSdk(Response response) {
        String string;
        String headerValue = response.getHeaderValue(CtApi.HEADER_MUTE);
        if (headerValue != null && (string = StringsKt.trim((CharSequence) headerValue).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                if (Intrinsics.areEqual(string, "true")) {
                    setMuted(true);
                    return true;
                }
                setMuted(false);
            }
        }
        return false;
    }

    public static /* synthetic */ boolean sendQueue$default(NetworkManager networkManager, Context context, EventGroup eventGroup, JSONArray jSONArray, String str, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return networkManager.sendQueue(context, eventGroup, jSONArray, str, z);
    }

    public final boolean sendQueue(Context context, EventGroup eventGroup, JSONArray queue, String caller, boolean isUserSwitchFlush) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        if (queue != null && queue.length() > 0) {
            if (this.deviceInfo.getDeviceID() == null) {
                this.logger.debug(this.config.getAccountId(), "CleverTap Id not finalized, unable to send queue");
                return false;
            }
            final EndpointId endpointIdFromEventGroup = EndpointId.INSTANCE.fromEventGroup(eventGroup);
            JSONObject queueHeader = getQueueHeader(caller);
            applyQueueHeaderListeners(queueHeader, endpointIdFromEventGroup);
            final SendQueueRequestBody sendQueueRequestBody = new SendQueueRequestBody(queueHeader, queue);
            this.logger.debug(this.config.getAccountId(), "Send queue contains " + queue.length() + " items: " + sendQueueRequestBody);
            try {
                return networkCall(eventGroup, sendQueueRequestBody, new Function0() { // from class: com.clevertap.android.sdk.network.NetworkManager$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NetworkManager.sendQueue$lambda$3(this.f$0, sendQueueRequestBody, endpointIdFromEventGroup);
                    }
                }, isUserSwitchFlush);
            } catch (Exception e2) {
                this.networkRetryCount++;
                this.responseFailureCount++;
                this.logger.debug(this.config.getAccountId(), "An exception occurred while sending the queue, will retry: ", e2);
                if (this.callbackManager.getFailureFlushListener() != null) {
                    this.callbackManager.getFailureFlushListener().failureFlush(context);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendQueue$lambda$3(NetworkManager this$0, SendQueueRequestBody requestBody, EndpointId endpointId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestBody, "$requestBody");
        Intrinsics.checkNotNullParameter(endpointId, "$endpointId");
        this$0.notifyHeaderListeners(requestBody, endpointId);
        return Unit.INSTANCE;
    }

    private final boolean networkCall(EventGroup eventGroup, SendQueueRequestBody requestBody, Function0<Unit> notifyNetworkHeaderListeners, boolean isUserSwitchFlush) {
        boolean zHandleVariablesResponse;
        Response responseCallApiForEventGroup = callApiForEventGroup(eventGroup, requestBody);
        try {
            Response response = responseCallApiForEventGroup;
            int i = 0;
            this.networkRetryCount = 0;
            int i2 = WhenMappings.$EnumSwitchMapping$0[eventGroup.ordinal()];
            if (i2 == 1) {
                zHandleVariablesResponse = handleVariablesResponse(response);
            } else if (i2 == 2) {
                zHandleVariablesResponse = handleSendQueueResponse(response, doesBodyContainAppLaunchedOrFetchEvents(requestBody), notifyNetworkHeaderListeners, isUserSwitchFlush);
                if (!zHandleVariablesResponse) {
                    i = this.responseFailureCount + 1;
                }
                this.responseFailureCount = i;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                zHandleVariablesResponse = handlePushImpressionsResponse(response);
                if (!zHandleVariablesResponse) {
                    i = this.responseFailureCount + 1;
                }
                this.responseFailureCount = i;
            }
            CloseableKt.closeFinally(responseCallApiForEventGroup, null);
            return zHandleVariablesResponse;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(responseCallApiForEventGroup, th);
                throw th2;
            }
        }
    }

    private final void notifyHeaderListeners(SendQueueRequestBody requestBody, EndpointId endpointId) {
        if (requestBody.getQueueHeader() != null) {
            Iterator<NetworkHeadersListener> it = this.mNetworkHeadersListeners.iterator();
            while (it.hasNext()) {
                it.next().onSentHeaders(requestBody.getQueueHeader(), endpointId);
            }
        }
    }

    public final boolean defineTemplates(Collection<CustomTemplate> templates) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        JSONObject queueHeader = getQueueHeader(null);
        if (queueHeader == null) {
            return false;
        }
        DefineTemplatesRequestBody defineTemplatesRequestBody = new DefineTemplatesRequestBody(queueHeader, templates);
        this.logger.debug(this.config.getAccountId(), "Will define templates: " + defineTemplatesRequestBody);
        try {
            Response responseDefineTemplates = this.ctApiWrapper.getCtApi().defineTemplates(defineTemplatesRequestBody);
            try {
                Response response = responseDefineTemplates;
                if (response.isSuccess()) {
                    handleTemplateResponseSuccess(response);
                    CloseableKt.closeFinally(responseDefineTemplates, null);
                    return true;
                }
                handleVarsOrTemplatesResponseError(response, "CustomTemplates");
                CloseableKt.closeFinally(responseDefineTemplates, null);
                return false;
            } finally {
            }
        } catch (Exception e2) {
            this.logger.debug(this.config.getAccountId(), "An exception occurred while defining templates.", e2);
            return false;
        }
    }

    private final void applyQueueHeaderListeners(JSONObject queueHeader, EndpointId endpointId) throws JSONException {
        if (queueHeader != null) {
            Iterator<NetworkHeadersListener> it = this.mNetworkHeadersListeners.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectOnAttachHeaders = it.next().onAttachHeaders(endpointId);
                if (jSONObjectOnAttachHeaders != null) {
                    CTXtensions.copyFrom(queueHeader, jSONObjectOnAttachHeaders);
                }
            }
        }
    }

    public final JSONObject fetchInAppPreviewPayloadFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Response responseFetchFromUrl = this.ctApiWrapper.getCtApi().fetchFromUrl(url);
            try {
                Response response = responseFetchFromUrl;
                if (response.isSuccess()) {
                    JSONObject jsonOrNull = CTXtensions.toJsonOrNull(response.readBody());
                    CloseableKt.closeFinally(responseFetchFromUrl, null);
                    return jsonOrNull;
                }
                this.logger.debug(this.config.getAccountId(), "Failed to fetch inapp payload. Response code: " + response.getCode());
                CloseableKt.closeFinally(responseFetchFromUrl, null);
                return null;
            } finally {
            }
        } catch (Exception e2) {
            this.logger.debug(this.config.getAccountId(), "An exception occurred while fetching the inapp payload from URL", e2);
            return null;
        }
    }

    private final Response callApiForEventGroup(EventGroup eventGroup, SendQueueRequestBody body) {
        int i = WhenMappings.$EnumSwitchMapping$0[eventGroup.ordinal()];
        if (i == 1) {
            return this.ctApiWrapper.getCtApi().defineVars(body);
        }
        if (i == 2) {
            return sendQueueApi(body);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return sendImpressionsApi(body);
    }

    private final Response sendQueueApi(SendQueueRequestBody body) throws JSONException {
        if (this.config.isEncryptionInTransitEnabled() && !this.coreMetaData.isRelaxNetwork()) {
            EncryptionResult encryptionResultEncryptResponse = this.encryptionManager.encryptResponse(body.toString());
            String strSessionEncryptionKey = this.encryptionManager.sessionEncryptionKey();
            if (encryptionResultEncryptResponse instanceof EncryptionSuccess) {
                EncryptionSuccess encryptionSuccess = (EncryptionSuccess) encryptionResultEncryptResponse;
                String data = encryptionSuccess.getData();
                Intrinsics.checkNotNull(strSessionEncryptionKey);
                String jsonString = new EncryptedSendQueueRequestBody(data, strSessionEncryptionKey, encryptionSuccess.getIv()).toJsonString();
                this.logger.verbose("Encrypted Request = " + jsonString);
                return this.ctApiWrapper.getCtApi().sendQueue(jsonString, true);
            }
            this.logger.verbose("Normal Request cause encryption failed = " + body);
        }
        return CtApi.sendQueue$default(this.ctApiWrapper.getCtApi(), body.toString(), false, 2, null);
    }

    private final Response sendImpressionsApi(SendQueueRequestBody body) {
        return this.ctApiWrapper.getCtApi().sendImpressions(body.toString());
    }

    private final boolean handleVariablesResponse(Response response) {
        if (response.isSuccess()) {
            String body = response.readBody();
            JSONObject jsonOrNull = CTXtensions.toJsonOrNull(body);
            this.logger.verbose(this.config.getAccountId(), "Processing variables response : " + jsonOrNull);
            this.arpResponse.processResponse(jsonOrNull, body, this.context);
            return true;
        }
        handleVarsOrTemplatesResponseError(response, "Variables");
        return false;
    }

    private final void handleVarsOrTemplatesResponseError(Response response, String logTag) {
        int code = response.getCode();
        if (code != 400) {
            if (code == 401) {
                this.logger.info(logTag, "Unauthorized access from a non-test profile. Please mark this profile as a test profile from the CleverTap dashboard.");
                return;
            } else {
                this.logger.info(logTag, "Response code " + response.getCode() + " while syncing.");
                return;
            }
        }
        JSONObject jsonOrNull = CTXtensions.toJsonOrNull(response.readBody());
        if (jsonOrNull != null && !TextUtils.isEmpty(jsonOrNull.optString("error"))) {
            this.logger.info(logTag, "Error while syncing: " + jsonOrNull.optString("error"));
        } else {
            this.logger.info(logTag, "Error while syncing.");
        }
    }

    private final void handleTemplateResponseSuccess(Response response) {
        this.logger.info(this.config.getAccountId(), "Custom templates defined successfully.");
        JSONObject jsonOrNull = CTXtensions.toJsonOrNull(response.readBody());
        if (jsonOrNull != null) {
            String strOptString = jsonOrNull.optString("error");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.logger.info(this.config.getAccountId(), "Custom templates warnings: " + strOptString);
        }
    }

    private final boolean handlePushImpressionsResponse(Response response) {
        if (!response.isSuccess()) {
            this.logger.info("Received error response code: " + response.getCode());
            return false;
        }
        if (abortDueToDomainChange(response) || shouldMuteSdk(response)) {
            return false;
        }
        saveDomainChanges(response);
        this.logger.debug(this.config.getAccountId(), "Push Impressions sent successfully");
        this.networkRepo.setLastRequestTs(getCurrentRequestTimestamp());
        setFirstRequestTimestampIfNeeded(getCurrentRequestTimestamp());
        this.logger.verbose(this.config.getAccountId(), "Processing response : " + CTXtensions.toJsonOrNull(response.readBody()));
        return true;
    }

    private final boolean handleSendQueueResponse(Response response, boolean isFullResponse, Function0<Unit> notifyNetworkHeaderListeners, boolean isUserSwitchFlush) {
        if (!response.isSuccess()) {
            handleSendQueueResponseError(response);
            return false;
        }
        if (abortDueToDomainChange(response) || shouldMuteSdk(response)) {
            return false;
        }
        saveDomainChanges(response);
        notifyNetworkHeaderListeners.invoke();
        this.logger.debug(this.config.getAccountId(), "Queue sent successfully");
        this.networkRepo.setLastRequestTs(getCurrentRequestTimestamp());
        setFirstRequestTimestampIfNeeded(getCurrentRequestTimestamp());
        String body = response.readBody();
        JSONObject jsonOrNull = CTXtensions.toJsonOrNull(body);
        this.logger.verbose(this.config.getAccountId(), "Processing response : " + jsonOrNull);
        String str = body;
        if (str != null && !StringsKt.isBlank(str) && jsonOrNull != null) {
            if (Boolean.parseBoolean(response.getHeaderValue(CtApi.HEADER_ENCRYPTION_ENABLED))) {
                EncryptionResult encryptionResultDecryptResponse = this.encryptionManager.decryptResponse(body);
                if (encryptionResultDecryptResponse instanceof EncryptionFailure) {
                    this.logger.verbose(this.config.getAccountId(), "Failed to decrypt response");
                    return false;
                }
                if (!(encryptionResultDecryptResponse instanceof EncryptionSuccess)) {
                    throw new NoWhenBranchMatchedException();
                }
                body = ((EncryptionSuccess) encryptionResultDecryptResponse).getData();
                jsonOrNull = CTXtensions.toJsonOrNull(body);
                this.logger.verbose("Decrypted response = " + body);
            }
            this.cleverTapResponseHandler.handleResponse(isFullResponse, jsonOrNull, body, isUserSwitchFlush);
        }
        return true;
    }

    public final boolean abortDueToDomainChange(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        String headerValue = response.getHeaderValue(CtApi.HEADER_DOMAIN_NAME);
        if (!CTXtensions.isNotNullAndBlank(headerValue) || !hasDomainChanged(headerValue)) {
            return false;
        }
        setDomain(headerValue);
        this.logger.debug(this.config.getAccountId(), "The domain has changed to " + headerValue + ". The request will be retried shortly.");
        return true;
    }

    private final void handleSendQueueResponseError(Response response) {
        this.logger.info("Received error response code: " + response.getCode());
        int code = response.getCode();
        if (code == 402) {
            this.logger.verbose("Encryption in transit feature on not enabled for your account, please contact Clevertap support.");
            this.coreMetaData.setRelaxNetwork(true);
        } else {
            if (code != 419) {
                return;
            }
            this.logger.verbose("There is decryption failure on backend, disabling encrypted requests.");
            this.coreMetaData.setRelaxNetwork(true);
        }
    }

    private final boolean doesBodyContainAppLaunchedOrFetchEvents(SendQueueRequestBody body) {
        int length = body.getQueue().length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = body.getQueue().getJSONObject(i);
                if (Intrinsics.areEqual("event", jSONObject.getString("type"))) {
                    String string = jSONObject.getString(Constants.KEY_EVT_NAME);
                    if (Intrinsics.areEqual(Constants.APP_LAUNCHED_EVENT, string) || Intrinsics.areEqual(Constants.WZRK_FETCH, string)) {
                        return true;
                    }
                } else {
                    continue;
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    private final void notifyListenersForPushImpressionSentToServer(JSONArray queue) throws JSONException {
        int length = queue.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObjectOptJSONObject = queue.getJSONObject(i).optJSONObject(Constants.KEY_EVT_DATA);
                if (jSONObjectOptJSONObject != null) {
                    String strBuildPushNotificationRenderedListenerKey = PushNotificationUtil.buildPushNotificationRenderedListenerKey(jSONObjectOptJSONObject.optString(Constants.WZRK_ACCT_ID_KEY), jSONObjectOptJSONObject.optString(Constants.WZRK_PUSH_ID));
                    Intrinsics.checkNotNullExpressionValue(strBuildPushNotificationRenderedListenerKey, "buildPushNotificationRenderedListenerKey(...)");
                    notifyListenerForPushImpressionSentToServer(strBuildPushNotificationRenderedListenerKey);
                }
            } catch (JSONException unused) {
                this.logger.verbose(this.config.getAccountId(), "Encountered an exception while parsing the push notification viewed event queue");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.logger.verbose(this.config.getAccountId(), "push notification viewed event sent successfully");
    }

    private final void notifyListenerForPushImpressionSentToServer(String listenerKey) {
        NotificationRenderedListener notificationRenderedListener = CleverTapAPI.getNotificationRenderedListener(listenerKey);
        if (notificationRenderedListener != null) {
            this.logger.verbose(this.config.getAccountId(), "notifying listener " + listenerKey + ", that push impression sent successfully");
            notificationRenderedListener.onNotificationRendered(true);
        }
    }

    private final void setDomain(String domainName) {
        this.logger.verbose(this.config.getAccountId(), "Setting domain to " + domainName);
        this.networkRepo.setDomain(domainName);
        this.ctApiWrapper.getCtApi().setCachedDomain(domainName);
        if (this.callbackManager.getSCDomainListener() != null) {
            if (domainName != null) {
                this.callbackManager.getSCDomainListener().onSCDomainAvailable(Utils.getSCDomain(domainName));
            } else {
                this.callbackManager.getSCDomainListener().onSCDomainUnavailable();
            }
        }
    }

    private final void setFirstRequestTimestampIfNeeded(int ts) {
        if (this.networkRepo.getFirstRequestTs() > 0) {
            return;
        }
        this.networkRepo.setFirstRequestTs(ts);
    }

    private final void setSpikyDomain(String spikyDomainName) {
        this.logger.verbose(this.config.getAccountId(), "Setting spiky domain to " + spikyDomainName);
        this.networkRepo.setSpikyDomain(spikyDomainName);
        this.ctApiWrapper.getCtApi().setCachedSpikyDomain(spikyDomainName);
    }

    private final void setMuted(boolean mute) {
        if (mute) {
            this.networkRepo.setMuted(true);
            this.networkRepo.setDomain(null);
            CTExecutorFactory.executors(this.config).postAsyncSafelyTask().execute("CommsManager#setMuted", new Callable() { // from class: com.clevertap.android.sdk.network.NetworkManager$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return NetworkManager.setMuted$lambda$9(this.f$0);
                }
            });
            return;
        }
        this.networkRepo.setMuted(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setMuted$lambda$9(NetworkManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.databaseManager.clearQueues(this$0.context);
        return Unit.INSTANCE;
    }
}
