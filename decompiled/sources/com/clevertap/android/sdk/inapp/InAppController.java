package com.clevertap.android.sdk.inapp;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import com.clevertap.android.sdk.AnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.InAppFCManager;
import com.clevertap.android.sdk.InAppNotificationListener;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.inapp.InAppActionHandler;
import com.clevertap.android.sdk.inapp.InAppNotificationInflater;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplate;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateInAppData;
import com.clevertap.android.sdk.inapp.customtemplates.TemplatesManager;
import com.clevertap.android.sdk.inapp.data.InAppResponseAdapter;
import com.clevertap.android.sdk.inapp.delay.DelayedInAppResult;
import com.clevertap.android.sdk.inapp.delay.InAppDelayManager;
import com.clevertap.android.sdk.inapp.evaluation.EvaluationManager;
import com.clevertap.android.sdk.inapp.evaluation.TriggerAdapter;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.task.CTExecutors;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.Clock;
import com.clevertap.android.sdk.utils.JsonUtilsKt;
import com.clevertap.android.sdk.variables.JsonUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u0089\u00012\u00020\u0001:\u0004\u0088\u0001\u0089\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&J\u0006\u0010*\u001a\u00020(J\u000e\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020DJ4\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u0002042\b\u0010M\u001a\u0004\u0018\u00010G2\b\u0010N\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010O\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020I2\u0006\u0010P\u001a\u00020Q2\b\u0010N\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010R\u001a\u00020(2\u0006\u0010H\u001a\u00020I2\b\u0010S\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010T\u001a\u00020(2\u0006\u0010H\u001a\u00020I2\b\u0010S\u001a\u0004\u0018\u00010GH\u0016J\u000e\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020DJ\b\u0010W\u001a\u00020(H\u0003J\u0006\u0010X\u001a\u00020(J\u0006\u0010Y\u001a\u00020(J\u0010\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020<H\u0007J.\u0010\\\u001a\u00020(2\u0006\u0010]\u001a\u0002042\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020`0_2\b\u0010a\u001a\u0004\u0018\u00010bH\u0007J@\u0010c\u001a\u00020(2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020`0_2\u0018\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020`0_0f2\b\u0010a\u001a\u0004\u0018\u00010bH\u0007J2\u0010g\u001a\u00020(2\u001e\u0010h\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020`0_0_2\b\u0010i\u001a\u0004\u0018\u00010bH\u0007J\u0018\u0010j\u001a\u00020(2\u0006\u0010k\u001a\u00020<2\b\u0010a\u001a\u0004\u0018\u00010bJ\u0018\u0010l\u001a\u00020(2\u0006\u0010m\u001a\u00020<2\b\u0010a\u001a\u0004\u0018\u00010bJ\u0006\u0010n\u001a\u00020(J\b\u0010o\u001a\u00020(H\u0002J\u0010\u0010p\u001a\u00020(2\u0006\u0010q\u001a\u00020AH\u0002J\u0012\u0010r\u001a\u00020D2\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\b\u0010u\u001a\u00020DH\u0002J\u0010\u0010v\u001a\u00020(2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010w\u001a\u00020(2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010x\u001a\u00020(2\u0006\u0010@\u001a\u00020AH\u0002J\u0016\u0010y\u001a\b\u0012\u0004\u0012\u000204092\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010z\u001a\u00020DH\u0002J\u0010\u0010{\u001a\u00020(2\u0006\u0010H\u001a\u00020IH\u0002J\u0018\u0010|\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010}\u001a\u00020(2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010~\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010\u007f\u001a\u00020(2\u0006\u0010H\u001a\u00020IH\u0003J\u0011\u0010\u0080\u0001\u001a\u00020(2\u0006\u0010H\u001a\u00020IH\u0002J\u0012\u0010\u0081\u0001\u001a\u00020<2\u0007\u0010\u0082\u0001\u001a\u00020<H\u0002J\u0011\u0010\u0083\u0001\u001a\u00020D2\u0006\u0010q\u001a\u00020AH\u0002J\u001e\u0010\u0084\u0001\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u00020I2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020(0,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\n 1*\u0004\u0018\u00010000X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0018\u00103\u001a\n 1*\u0004\u0018\u00010404X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020409X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppController;", "Lcom/clevertap/android/sdk/inapp/InAppListener;", "context", "Landroid/content/Context;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "executors", "Lcom/clevertap/android/sdk/task/CTExecutors;", "controllerManager", "Lcom/clevertap/android/sdk/ControllerManager;", "callbackManager", "Lcom/clevertap/android/sdk/BaseCallbackManager;", "analyticsManager", "Lcom/clevertap/android/sdk/AnalyticsManager;", "coreMetaData", "Lcom/clevertap/android/sdk/CoreMetaData;", "manifestInfo", "Lcom/clevertap/android/sdk/ManifestInfo;", "deviceInfo", "Lcom/clevertap/android/sdk/DeviceInfo;", "inAppQueue", "Lcom/clevertap/android/sdk/inapp/InAppQueue;", "evaluationManager", "Lcom/clevertap/android/sdk/inapp/evaluation/EvaluationManager;", "templatesManager", "Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;", "inAppActionHandler", "Lcom/clevertap/android/sdk/inapp/InAppActionHandler;", "inAppNotificationInflater", "Lcom/clevertap/android/sdk/inapp/InAppNotificationInflater;", "inAppDelayManager", "Lcom/clevertap/android/sdk/inapp/delay/InAppDelayManager;", "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "<init>", "(Landroid/content/Context;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Lcom/clevertap/android/sdk/task/CTExecutors;Lcom/clevertap/android/sdk/ControllerManager;Lcom/clevertap/android/sdk/BaseCallbackManager;Lcom/clevertap/android/sdk/AnalyticsManager;Lcom/clevertap/android/sdk/CoreMetaData;Lcom/clevertap/android/sdk/ManifestInfo;Lcom/clevertap/android/sdk/DeviceInfo;Lcom/clevertap/android/sdk/inapp/InAppQueue;Lcom/clevertap/android/sdk/inapp/evaluation/EvaluationManager;Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;Lcom/clevertap/android/sdk/inapp/InAppActionHandler;Lcom/clevertap/android/sdk/inapp/InAppNotificationInflater;Lcom/clevertap/android/sdk/inapp/delay/InAppDelayManager;Lcom/clevertap/android/sdk/utils/Clock;)V", "inAppDisplayListener", "Ljava/lang/ref/WeakReference;", "Lcom/clevertap/android/sdk/inapp/InAppDisplayListener;", "registerInAppDisplayListener", "", "display", "unregisterInAppDisplayListener", "onAppLaunchEventSent", "Lkotlin/Function0;", "getOnAppLaunchEventSent", "()Lkotlin/jvm/functions/Function0;", "logger", "Lcom/clevertap/android/sdk/Logger;", "kotlin.jvm.PlatformType", "Lcom/clevertap/android/sdk/Logger;", "defaultLogTag", "", "Ljava/lang/String;", "inAppState", "Lcom/clevertap/android/sdk/inapp/InAppController$InAppState;", "inAppExcludedActivityNames", "", "scheduleDelayedInAppsForAllModes", "delayedInApps", "Lorg/json/JSONArray;", "getActiveDelayedInAppsCount", "", "promptPushPrimer", "jsonObject", "Lorg/json/JSONObject;", "promptPermission", "showFallbackSettings", "", "isPushPermissionGranted", "inAppNotificationActionTriggered", "Landroid/os/Bundle;", "inAppNotification", "Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "action", "Lcom/clevertap/android/sdk/inapp/CTInAppAction;", "callToAction", "additionalData", "activityContext", "inAppNotificationDidClick", "button", "Lcom/clevertap/android/sdk/inapp/CTInAppNotificationButton;", "inAppNotificationDidDismiss", "formData", "inAppNotificationDidShow", "discardInApps", "hideInAppIfVisible", "hideCurrentlyDisplayingInApp", "resumeInApps", "suspendInApps", "addInAppNotificationsToQueue", "inappNotifs", "onQueueEvent", "eventName", TriggerAdapter.KEY_EVENT_PROPERTIES, "", "", "userLocation", "Landroid/location/Location;", "onQueueChargedEvent", "chargeDetails", FirebaseAnalytics.Param.ITEMS, "", "onQueueProfileEvent", "userAttributeChangedProperties", "location", "onAppLaunchServerSideInAppsResponse", "appLaunchServerSideInApps", "onAppLaunchServerSideDelayedInAppsResponse", "appLaunchServerSideDelayedInApps", "showNotificationIfAvailable", "_showNotificationIfAvailable", "addInAppNotificationInFrontOfQueue", Constants.INAPP_KEY, "canShowInAppOnActivity", "activity", "Landroid/app/Activity;", "canShowInAppOnCurrentActivity", "displayNotification", "notificationReady", "prepareNotificationForDisplay", "getExcludedActivitiesSet", "checkPendingNotifications", "inAppDidDismiss", "incrementLocalInAppCountInPersistentStore", "checkLimitsBeforeShowing", "checkBeforeShowApprovalBeforeDisplay", "showInApp", "presentTemplate", "filterNonRegisteredCustomTemplates", "inAppNotifications", "isNonRegisteredCustomTemplate", "triggerCustomTemplateAction", "notification", "templateInAppData", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplateInAppData;", "InAppState", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppController implements InAppListener {
    public static final String IS_FIRST_TIME_PERMISSION_REQUEST = "firstTimeRequest";
    public static final String LOCAL_INAPP_COUNT = "local_in_app_count";
    private static volatile CTInAppNotification currentlyDisplayingInApp;
    private final AnalyticsManager analyticsManager;
    private final BaseCallbackManager callbackManager;
    private final Clock clock;
    private final CleverTapInstanceConfig config;
    private final Context context;
    private final ControllerManager controllerManager;
    private final CoreMetaData coreMetaData;
    private final String defaultLogTag;
    private final DeviceInfo deviceInfo;
    private final EvaluationManager evaluationManager;
    private final CTExecutors executors;
    private final InAppActionHandler inAppActionHandler;
    private final InAppDelayManager inAppDelayManager;
    private WeakReference<InAppDisplayListener> inAppDisplayListener;
    private final Set<String> inAppExcludedActivityNames;
    private final InAppNotificationInflater inAppNotificationInflater;
    private final InAppQueue inAppQueue;
    private volatile InAppState inAppState;
    private final Logger logger;
    private final Function0<Unit> onAppLaunchEventSent;
    private final TemplatesManager templatesManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<CTInAppNotification> pendingNotifications = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: InAppController.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InAppActionType.values().length];
            try {
                iArr[InAppActionType.CUSTOM_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InAppActionType.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InAppActionType.OPEN_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InAppActionType.KEY_VALUES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CTInAppType.values().length];
            try {
                iArr2[CTInAppType.CTInAppTypeCoverHTML.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeInterstitialHTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeHalfInterstitialHTML.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeCover.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeHalfInterstitial.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeInterstitial.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeAlert.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeInterstitialImageOnly.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeHalfInterstitialImageOnly.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeCoverImageOnly.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeFooterHTML.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeHeaderHTML.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeFooter.ordinal()] = 13;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeHeader.ordinal()] = 14;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[CTInAppType.CTInAppTypeCustomCodeTemplate.ordinal()] = 15;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public InAppController(Context context, CleverTapInstanceConfig config, CTExecutors executors, ControllerManager controllerManager, BaseCallbackManager callbackManager, AnalyticsManager analyticsManager, CoreMetaData coreMetaData, ManifestInfo manifestInfo, DeviceInfo deviceInfo, InAppQueue inAppQueue, EvaluationManager evaluationManager, TemplatesManager templatesManager, InAppActionHandler inAppActionHandler, InAppNotificationInflater inAppNotificationInflater, InAppDelayManager inAppDelayManager, Clock clock) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(executors, "executors");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(coreMetaData, "coreMetaData");
        Intrinsics.checkNotNullParameter(manifestInfo, "manifestInfo");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(inAppQueue, "inAppQueue");
        Intrinsics.checkNotNullParameter(evaluationManager, "evaluationManager");
        Intrinsics.checkNotNullParameter(templatesManager, "templatesManager");
        Intrinsics.checkNotNullParameter(inAppActionHandler, "inAppActionHandler");
        Intrinsics.checkNotNullParameter(inAppNotificationInflater, "inAppNotificationInflater");
        Intrinsics.checkNotNullParameter(inAppDelayManager, "inAppDelayManager");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.context = context;
        this.config = config;
        this.executors = executors;
        this.controllerManager = controllerManager;
        this.callbackManager = callbackManager;
        this.analyticsManager = analyticsManager;
        this.coreMetaData = coreMetaData;
        this.deviceInfo = deviceInfo;
        this.inAppQueue = inAppQueue;
        this.evaluationManager = evaluationManager;
        this.templatesManager = templatesManager;
        this.inAppActionHandler = inAppActionHandler;
        this.inAppNotificationInflater = inAppNotificationInflater;
        this.inAppDelayManager = inAppDelayManager;
        this.clock = clock;
        this.onAppLaunchEventSent = new Function0() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InAppController.onAppLaunchEventSent$lambda$0(this.f$0);
            }
        };
        this.logger = config.getLogger();
        this.defaultLogTag = config.getAccountId();
        this.inAppState = InAppState.RESUMED;
        this.inAppExcludedActivityNames = getExcludedActivitiesSet(manifestInfo);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: InAppController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppController$InAppState;", "", "<init>", "(Ljava/lang/String;I)V", "DISCARDED", DebugCoroutineInfoImplKt.SUSPENDED, "RESUMED", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class InAppState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InAppState[] $VALUES;
        public static final InAppState DISCARDED = new InAppState("DISCARDED", 0);
        public static final InAppState SUSPENDED = new InAppState(DebugCoroutineInfoImplKt.SUSPENDED, 1);
        public static final InAppState RESUMED = new InAppState("RESUMED", 2);

        private static final /* synthetic */ InAppState[] $values() {
            return new InAppState[]{DISCARDED, SUSPENDED, RESUMED};
        }

        public static EnumEntries<InAppState> getEntries() {
            return $ENTRIES;
        }

        private InAppState(String str, int i) {
        }

        static {
            InAppState[] inAppStateArr$values = $values();
            $VALUES = inAppStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(inAppStateArr$values);
        }

        public static InAppState valueOf(String str) {
            return (InAppState) Enum.valueOf(InAppState.class, str);
        }

        public static InAppState[] values() {
            return (InAppState[]) $VALUES.clone();
        }
    }

    public final void registerInAppDisplayListener(InAppDisplayListener display) {
        Intrinsics.checkNotNullParameter(display, "display");
        this.inAppDisplayListener = new WeakReference<>(display);
    }

    public final void unregisterInAppDisplayListener() {
        this.logger.verbose("Unregistering InAppDisplay Listener");
        this.inAppDisplayListener = null;
    }

    /* JADX INFO: compiled from: InAppController.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R4\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\u000b0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR*\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t8\u0000@BX\u0081\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppController$Companion;", "", "<init>", "()V", "LOCAL_INAPP_COUNT", "", "IS_FIRST_TIME_PERMISSION_REQUEST", "pendingNotifications", "", "Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "kotlin.jvm.PlatformType", "", "Ljava/util/List;", "value", "currentlyDisplayingInApp", "getCurrentlyDisplayingInApp$clevertap_core_release$annotations", "getCurrentlyDisplayingInApp$clevertap_core_release", "()Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "clearCurrentlyDisplayingInApp", "", "clearCurrentlyDisplayingInApp$clevertap_core_release", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCurrentlyDisplayingInApp$clevertap_core_release$annotations() {
        }

        private Companion() {
        }

        public final CTInAppNotification getCurrentlyDisplayingInApp$clevertap_core_release() {
            return InAppController.currentlyDisplayingInApp;
        }

        public final void clearCurrentlyDisplayingInApp$clevertap_core_release() {
            InAppController.currentlyDisplayingInApp = null;
        }
    }

    public final Function0<Unit> getOnAppLaunchEventSent() {
        return this.onAppLaunchEventSent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAppLaunchEventSent$lambda$0(InAppController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, ? extends Object> mapMapFromJson = JsonUtil.mapFromJson(this$0.deviceInfo.getAppLaunchedFields());
        EvaluationManager evaluationManager = this$0.evaluationManager;
        Intrinsics.checkNotNull(mapMapFromJson);
        Pair<JSONArray, JSONArray> pairEvaluateOnAppLaunchedClientSide = evaluationManager.evaluateOnAppLaunchedClientSide(mapMapFromJson, this$0.coreMetaData.getLocationFromUser());
        if (pairEvaluateOnAppLaunchedClientSide.getFirst().length() > 0) {
            this$0.addInAppNotificationsToQueue(pairEvaluateOnAppLaunchedClientSide.getFirst());
        }
        if (pairEvaluateOnAppLaunchedClientSide.getSecond().length() > 0) {
            this$0.scheduleDelayedInAppsForAllModes(pairEvaluateOnAppLaunchedClientSide.getSecond());
        }
        return Unit.INSTANCE;
    }

    public final void scheduleDelayedInAppsForAllModes(JSONArray delayedInApps) {
        Intrinsics.checkNotNullParameter(delayedInApps, "delayedInApps");
        this.logger.verbose(this.config.getAccountId(), "InAppController: Scheduling " + delayedInApps.length() + " delayed in-apps");
        this.inAppDelayManager.scheduleDelayedInApps$clevertap_core_release(delayedInApps, new Function1() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InAppController.scheduleDelayedInAppsForAllModes$lambda$2(this.f$0, (DelayedInAppResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleDelayedInAppsForAllModes$lambda$2(final InAppController this$0, final DelayedInAppResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result instanceof DelayedInAppResult.Success) {
            DelayedInAppResult.Success success = (DelayedInAppResult.Success) result;
            this$0.logger.verbose(this$0.config.getAccountId(), "InAppController: Successfully retrieved delayed in-app " + success.getInAppId());
            this$0.executors.postAsyncSafelyTask(Constants.TAG_FEATURE_IN_APPS).execute("InAppController#executeDelayedInAppCallback-" + success.getInAppId(), new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda12
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return InAppController.scheduleDelayedInAppsForAllModes$lambda$2$lambda$1(this.f$0, result);
                }
            });
        } else {
            if (!(result instanceof DelayedInAppResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            DelayedInAppResult.Error error = (DelayedInAppResult.Error) result;
            this$0.logger.verbose(this$0.config.getAccountId(), "InAppController: Error for delayed in-app " + error.getInAppId() + ": " + error.getReason(), error.getThrowable());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleDelayedInAppsForAllModes$lambda$2$lambda$1(InAppController this$0, DelayedInAppResult result) throws JSONException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.logger.verbose(this$0.config.getAccountId(), "updating ttl L");
        DelayedInAppResult.Success success = (DelayedInAppResult.Success) result;
        EvaluationManager.updateTTL$clevertap_core_release$default(this$0.evaluationManager, success.getInApp(), null, 2, null);
        this$0.addInAppNotificationInFrontOfQueue(success.getInApp());
        return Unit.INSTANCE;
    }

    public final int getActiveDelayedInAppsCount() {
        return this.inAppDelayManager.getActiveCallbackCount$clevertap_core_release();
    }

    public final void promptPushPrimer(final JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        jsonObject.put(Constants.KEY_REQUEST_FOR_NOTIFICATION_PERMISSION, true);
        boolean zOptBoolean = jsonObject.optBoolean(CTLocalInApp.FALLBACK_TO_NOTIFICATION_SETTINGS, false);
        this.inAppActionHandler.launchPushPermissionPrompt(zOptBoolean, zOptBoolean, new InAppActionHandler.PushPermissionPromptPresenter() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda2
            @Override // com.clevertap.android.sdk.inapp.InAppActionHandler.PushPermissionPromptPresenter
            public final void showPrompt(Activity activity) {
                InAppController.promptPushPrimer$lambda$3(this.f$0, jsonObject, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void promptPushPrimer$lambda$3(InAppController this$0, JSONObject jsonObject, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jsonObject, "$jsonObject");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this$0.prepareNotificationForDisplay(jsonObject);
    }

    public final void promptPermission(boolean showFallbackSettings) {
        this.inAppActionHandler.launchPushPermissionPrompt(showFallbackSettings);
    }

    public final boolean isPushPermissionGranted() {
        return this.inAppActionHandler.arePushNotificationsEnabled();
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public Bundle inAppNotificationActionTriggered(CTInAppNotification inAppNotification, CTInAppAction action, String callToAction, Bundle additionalData, Context activityContext) throws JSONException {
        Bundle bundle;
        HashMap<String, String> keyValues;
        Intrinsics.checkNotNullParameter(inAppNotification, "inAppNotification");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(callToAction, "callToAction");
        if (additionalData != null) {
            bundle = new Bundle(additionalData);
        } else {
            bundle = new Bundle();
        }
        bundle.putString(Constants.NOTIFICATION_ID_TAG, inAppNotification.getCampaignId());
        bundle.putString(Constants.KEY_C2A, callToAction);
        if (!inAppNotification.getIsLocalInApp()) {
            this.analyticsManager.pushInAppNotificationStateEvent(true, inAppNotification, bundle);
        }
        InAppActionType type = action.getType();
        if (type == null) {
            this.logger.debug("Triggered in-app action without type");
            return bundle;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            triggerCustomTemplateAction(inAppNotification, action.getCustomTemplateInAppData());
            return bundle;
        }
        if (i != 2) {
            if (i == 3) {
                String actionUrl = action.getActionUrl();
                if (actionUrl != null) {
                    this.inAppActionHandler.openUrl(actionUrl, activityContext);
                    return bundle;
                }
                this.logger.debug("Cannot trigger open url action without url value");
                return bundle;
            }
            if (i == 4 && (keyValues = action.getKeyValues()) != null && (!keyValues.isEmpty()) && this.callbackManager.getInAppNotificationButtonListener() != null) {
                this.callbackManager.getInAppNotificationButtonListener().onInAppButtonClick(keyValues);
                return bundle;
            }
        } else if (CTInAppType.CTInAppTypeCustomCodeTemplate == inAppNotification.getInAppType()) {
            this.templatesManager.closeTemplate(inAppNotification);
        }
        return bundle;
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public Bundle inAppNotificationDidClick(CTInAppNotification inAppNotification, CTInAppNotificationButton button, Context activityContext) {
        Intrinsics.checkNotNullParameter(inAppNotification, "inAppNotification");
        Intrinsics.checkNotNullParameter(button, "button");
        CTInAppAction cTInAppAction = button.action;
        if (cTInAppAction == null) {
            return null;
        }
        return inAppNotificationActionTriggered(inAppNotification, cTInAppAction, button.getText(), null, activityContext);
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void inAppNotificationDidDismiss(final CTInAppNotification inAppNotification, Bundle formData) {
        HashMap<String, Object> map;
        String templateName;
        Intrinsics.checkNotNullParameter(inAppNotification, "inAppNotification");
        if (this.controllerManager.getInAppFCManager() != null) {
            CustomTemplateInAppData customTemplateData = inAppNotification.getCustomTemplateData();
            if (customTemplateData == null || (templateName = customTemplateData.getTemplateName()) == null) {
                templateName = "";
            }
            this.logger.verbose(this.defaultLogTag, "InApp Dismissed: " + inAppNotification.getCampaignId() + ' ' + templateName);
        } else {
            this.logger.verbose(this.defaultLogTag, "Not calling InApp Dismissed: " + inAppNotification.getCampaignId() + " because InAppFCManager is null");
        }
        try {
            InAppNotificationListener inAppNotificationListener = this.callbackManager.getInAppNotificationListener();
            if (inAppNotificationListener != null) {
                if (inAppNotification.getCustomExtras() != null) {
                    map = Utils.convertJSONObjectToHashMap(inAppNotification.getCustomExtras());
                } else {
                    map = new HashMap<>();
                }
                this.logger.verbose("Calling the in-app listener on behalf of " + this.coreMetaData.getSource());
                if (formData != null) {
                    inAppNotificationListener.onDismissed(map, Utils.convertBundleObjectToHashMap(formData));
                } else {
                    inAppNotificationListener.onDismissed(map, null);
                }
            }
        } catch (Throwable th) {
            this.logger.verbose(this.defaultLogTag, "Failed to call the in-app notification listener", th);
        }
        this.executors.postAsyncSafelyTask(Constants.TAG_FEATURE_IN_APPS).execute("InappController#inAppNotificationDidDismiss", new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InAppController.inAppNotificationDidDismiss$lambda$4(this.f$0, inAppNotification);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inAppNotificationDidDismiss$lambda$4(InAppController this$0, CTInAppNotification inAppNotification) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inAppNotification, "$inAppNotification");
        this$0.inAppDidDismiss(inAppNotification);
        this$0._showNotificationIfAvailable();
        return Unit.INSTANCE;
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void inAppNotificationDidShow(CTInAppNotification inAppNotification, Bundle formData) {
        Intrinsics.checkNotNullParameter(inAppNotification, "inAppNotification");
        InAppFCManager inAppFCManager = this.controllerManager.getInAppFCManager();
        if (inAppFCManager != null) {
            inAppFCManager.didShow(this.context, inAppNotification);
        }
        this.analyticsManager.pushInAppNotificationStateEvent(false, inAppNotification, formData);
        try {
            InAppNotificationListener inAppNotificationListener = this.callbackManager.getInAppNotificationListener();
            if (inAppNotificationListener != null) {
                inAppNotificationListener.onShow(inAppNotification);
            }
        } catch (Throwable th) {
            this.logger.verbose(this.defaultLogTag, "Failed to call the in-app notification listener", th);
        }
    }

    public final void discardInApps(boolean hideInAppIfVisible) {
        this.inAppState = InAppState.DISCARDED;
        this.logger.verbose(this.defaultLogTag, "InAppState is DISCARDED");
        if (hideInAppIfVisible) {
            this.logger.verbose(this.defaultLogTag, "Hiding InApp if visible");
            Utils.runOnUiThread(new Runnable() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    InAppController.discardInApps$lambda$5(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void discardInApps$lambda$5(InAppController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideCurrentlyDisplayingInApp();
    }

    private final void hideCurrentlyDisplayingInApp() {
        InAppDisplayListener inAppDisplayListener;
        CTInAppNotification cTInAppNotification = currentlyDisplayingInApp;
        if (cTInAppNotification == null) {
            return;
        }
        this.logger.verbose(this.defaultLogTag, "Hiding currently displaying InApp: " + cTInAppNotification.getCampaignId());
        WeakReference<InAppDisplayListener> weakReference = this.inAppDisplayListener;
        if (weakReference == null || (inAppDisplayListener = weakReference.get()) == null) {
            return;
        }
        inAppDisplayListener.hideInApp();
    }

    public final void resumeInApps() {
        this.inAppState = InAppState.RESUMED;
        this.logger.verbose(this.defaultLogTag, "InAppState is RESUMED");
        this.logger.verbose(this.defaultLogTag, "Resuming InApps by calling showInAppNotificationIfAny()");
        showNotificationIfAvailable();
    }

    public final void suspendInApps() {
        this.inAppState = InAppState.SUSPENDED;
        this.logger.verbose(this.defaultLogTag, "InAppState is SUSPENDED");
    }

    public final void addInAppNotificationsToQueue(JSONArray inappNotifs) {
        Intrinsics.checkNotNullParameter(inappNotifs, "inappNotifs");
        try {
            this.inAppQueue.enqueueAll(filterNonRegisteredCustomTemplates(inappNotifs));
            showNotificationIfAvailable();
        } catch (Exception e2) {
            this.logger.debug(this.defaultLogTag, "InAppController: : InApp notification handling error.", e2);
        }
    }

    public final void onQueueEvent(String eventName, Map<String, ? extends Object> eventProperties, Location userLocation) throws JSONException {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        Map<String, ? extends Object> mapMapFromJson = JsonUtil.mapFromJson(this.deviceInfo.getAppLaunchedFields());
        mapMapFromJson.putAll(eventProperties);
        EvaluationManager evaluationManager = this.evaluationManager;
        Intrinsics.checkNotNull(mapMapFromJson);
        Pair<JSONArray, JSONArray> pairEvaluateOnEvent = evaluationManager.evaluateOnEvent(eventName, mapMapFromJson, userLocation);
        if (pairEvaluateOnEvent.getFirst().length() > 0) {
            addInAppNotificationsToQueue(pairEvaluateOnEvent.getFirst());
        }
        if (pairEvaluateOnEvent.getSecond().length() > 0) {
            scheduleDelayedInAppsForAllModes(pairEvaluateOnEvent.getSecond());
        }
    }

    public final void onQueueChargedEvent(Map<String, ? extends Object> chargeDetails, List<? extends Map<String, ? extends Object>> items, Location userLocation) throws JSONException {
        Intrinsics.checkNotNullParameter(chargeDetails, "chargeDetails");
        Intrinsics.checkNotNullParameter(items, "items");
        Map<String, ? extends Object> mapMapFromJson = JsonUtil.mapFromJson(this.deviceInfo.getAppLaunchedFields());
        mapMapFromJson.putAll(chargeDetails);
        EvaluationManager evaluationManager = this.evaluationManager;
        Intrinsics.checkNotNull(mapMapFromJson);
        Pair<JSONArray, JSONArray> pairEvaluateOnChargedEvent = evaluationManager.evaluateOnChargedEvent(mapMapFromJson, items, userLocation);
        if (pairEvaluateOnChargedEvent.getFirst().length() > 0) {
            addInAppNotificationsToQueue(pairEvaluateOnChargedEvent.getFirst());
        }
        if (pairEvaluateOnChargedEvent.getSecond().length() > 0) {
            scheduleDelayedInAppsForAllModes(pairEvaluateOnChargedEvent.getSecond());
        }
    }

    public final void onQueueProfileEvent(Map<String, ? extends Map<String, ? extends Object>> userAttributeChangedProperties, Location location) throws JSONException {
        Intrinsics.checkNotNullParameter(userAttributeChangedProperties, "userAttributeChangedProperties");
        Map<String, ? extends Object> mapMapFromJson = JsonUtil.mapFromJson(this.deviceInfo.getAppLaunchedFields());
        EvaluationManager evaluationManager = this.evaluationManager;
        Intrinsics.checkNotNull(mapMapFromJson);
        Pair<JSONArray, JSONArray> pairEvaluateOnUserAttributeChange = evaluationManager.evaluateOnUserAttributeChange(userAttributeChangedProperties, location, mapMapFromJson);
        if (pairEvaluateOnUserAttributeChange.getFirst().length() > 0) {
            addInAppNotificationsToQueue(pairEvaluateOnUserAttributeChange.getFirst());
        }
        if (pairEvaluateOnUserAttributeChange.getSecond().length() > 0) {
            scheduleDelayedInAppsForAllModes(pairEvaluateOnUserAttributeChange.getSecond());
        }
    }

    public final void onAppLaunchServerSideInAppsResponse(JSONArray appLaunchServerSideInApps, Location userLocation) throws JSONException {
        Intrinsics.checkNotNullParameter(appLaunchServerSideInApps, "appLaunchServerSideInApps");
        Map<String, ? extends Object> mapMapFromJson = JsonUtil.mapFromJson(this.deviceInfo.getAppLaunchedFields());
        List<JSONObject> jSONObjectList = Utils.toJSONObjectList(appLaunchServerSideInApps);
        EvaluationManager evaluationManager = this.evaluationManager;
        Intrinsics.checkNotNull(jSONObjectList);
        Intrinsics.checkNotNull(mapMapFromJson);
        JSONArray jSONArrayEvaluateOnAppLaunchedServerSide = evaluationManager.evaluateOnAppLaunchedServerSide(jSONObjectList, mapMapFromJson, userLocation);
        if (jSONArrayEvaluateOnAppLaunchedServerSide.length() > 0) {
            addInAppNotificationsToQueue(jSONArrayEvaluateOnAppLaunchedServerSide);
        }
    }

    public final void onAppLaunchServerSideDelayedInAppsResponse(JSONArray appLaunchServerSideDelayedInApps, Location userLocation) throws JSONException {
        Intrinsics.checkNotNullParameter(appLaunchServerSideDelayedInApps, "appLaunchServerSideDelayedInApps");
        Map<String, ? extends Object> mapMapFromJson = JsonUtil.mapFromJson(this.deviceInfo.getAppLaunchedFields());
        List<JSONObject> jSONObjectList = Utils.toJSONObjectList(appLaunchServerSideDelayedInApps);
        EvaluationManager evaluationManager = this.evaluationManager;
        Intrinsics.checkNotNull(jSONObjectList);
        Intrinsics.checkNotNull(mapMapFromJson);
        JSONArray jSONArrayEvaluateOnAppLaunchedDelayedServerSide = evaluationManager.evaluateOnAppLaunchedDelayedServerSide(jSONObjectList, mapMapFromJson, userLocation);
        if (jSONArrayEvaluateOnAppLaunchedDelayedServerSide.length() > 0) {
            scheduleDelayedInAppsForAllModes(jSONArrayEvaluateOnAppLaunchedDelayedServerSide);
        }
    }

    public final void showNotificationIfAvailable() {
        if (this.config.isAnalyticsOnly()) {
            return;
        }
        this.executors.postAsyncSafelyTask(Constants.TAG_FEATURE_IN_APPS).execute("InappController#showNotificationIfAvailable", new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InAppController.showNotificationIfAvailable$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showNotificationIfAvailable$lambda$6(InAppController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._showNotificationIfAvailable();
        return Unit.INSTANCE;
    }

    private final void _showNotificationIfAvailable() {
        JSONObject jSONObjectDequeue;
        try {
            if (!canShowInAppOnCurrentActivity()) {
                this.logger.verbose("Not showing notification on blacklisted activity");
                return;
            }
            if (this.inAppState == InAppState.SUSPENDED) {
                this.logger.debug(this.defaultLogTag, "InApp Notifications are set to be suspended, not showing the InApp Notification");
                return;
            }
            if (checkPendingNotifications() || (jSONObjectDequeue = this.inAppQueue.dequeue()) == null) {
                return;
            }
            if (this.inAppState != InAppState.DISCARDED) {
                prepareNotificationForDisplay(jSONObjectDequeue);
            } else {
                this.logger.debug(this.defaultLogTag, "InApp Notifications are set to be discarded, dropping the InApp Notification");
            }
        } catch (Throwable th) {
            this.logger.verbose(this.defaultLogTag, "InApp: Couldn't parse JSON array string from prefs", th);
        }
    }

    private final void addInAppNotificationInFrontOfQueue(JSONObject inApp) {
        if (isNonRegisteredCustomTemplate(inApp)) {
            return;
        }
        this.inAppQueue.insertInFront(inApp);
        showNotificationIfAvailable();
    }

    private final boolean canShowInAppOnActivity(Activity activity) {
        if (activity == null) {
            return true;
        }
        String localClassName = activity.getLocalClassName();
        Intrinsics.checkNotNullExpressionValue(localClassName, "getLocalClassName(...)");
        Iterator<String> it = this.inAppExcludedActivityNames.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) localClassName, (CharSequence) it.next(), false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    private final boolean canShowInAppOnCurrentActivity() {
        return canShowInAppOnActivity(CoreMetaData.getCurrentActivity());
    }

    private final void displayNotification(final CTInAppNotification inAppNotification) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.executors.mainTask().execute("InAppController:displayNotification", new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return InAppController.displayNotification$lambda$7(this.f$0, inAppNotification);
                }
            });
            return;
        }
        if (inAppNotification.getIsRequestForPushPermission() && this.inAppActionHandler.arePushNotificationsEnabled()) {
            this.logger.verbose(this.defaultLogTag, "Not showing push permission request, permission is already granted");
            this.inAppActionHandler.notifyPushPermissionListeners();
            showNotificationIfAvailable();
        } else {
            checkLimitsBeforeShowing(inAppNotification);
            incrementLocalInAppCountInPersistentStore(this.context, inAppNotification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayNotification$lambda$7(InAppController this$0, CTInAppNotification inAppNotification) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inAppNotification, "$inAppNotification");
        this$0.displayNotification(inAppNotification);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notificationReady(CTInAppNotification inAppNotification) {
        String templateName;
        if (inAppNotification.getError() != null) {
            this.logger.debug(this.defaultLogTag, "Unable to process inapp notification " + inAppNotification.getError());
            return;
        }
        CustomTemplateInAppData customTemplateData = inAppNotification.getCustomTemplateData();
        CustomTemplate template = (customTemplateData == null || (templateName = customTemplateData.getTemplateName()) == null) ? null : this.templatesManager.getTemplate(templateName);
        this.logger.debug(this.defaultLogTag, "Notification ready: " + inAppNotification.getJsonDescription());
        if (template != null && !template.getIsVisual()) {
            presentTemplate(inAppNotification);
        } else {
            displayNotification(inAppNotification);
        }
    }

    private final void prepareNotificationForDisplay(JSONObject jsonObject) {
        this.logger.debug(this.defaultLogTag, "Preparing In-App for display: " + jsonObject);
        this.inAppNotificationInflater.inflate(jsonObject, "InappController#prepareNotificationForDisplay", new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.InAppController$prepareNotificationForDisplay$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppController.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 implements InAppNotificationInflater.InAppNotificationReadyListener, FunctionAdapter {
        AnonymousClass1() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof InAppNotificationInflater.InAppNotificationReadyListener) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, InAppController.this, InAppController.class, "notificationReady", "notificationReady(Lcom/clevertap/android/sdk/inapp/CTInAppNotification;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.clevertap.android.sdk.inapp.InAppNotificationInflater.InAppNotificationReadyListener
        public final void onNotificationReady(CTInAppNotification p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            InAppController.this.notificationReady(p0);
        }
    }

    private final Set<String> getExcludedActivitiesSet(ManifestInfo manifestInfo) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String excludedActivities = manifestInfo.getExcludedActivities();
        if (excludedActivities != null) {
            Iterator it = StringsKt.split$default((CharSequence) excludedActivities, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null).iterator();
            while (it.hasNext()) {
                String string = StringsKt.trim((CharSequence) it.next()).toString();
                if (!StringsKt.isBlank(string)) {
                    linkedHashSet.add(string);
                }
            }
        }
        this.logger.debug(this.defaultLogTag, "In-app notifications will not be shown on " + CollectionsKt.joinToString$default(linkedHashSet, null, null, null, 0, null, null, 63, null));
        return linkedHashSet;
    }

    private final boolean checkPendingNotifications() {
        this.logger.verbose(this.defaultLogTag, "checking Pending Notifications");
        List<CTInAppNotification> pendingNotifications2 = pendingNotifications;
        Intrinsics.checkNotNullExpressionValue(pendingNotifications2, "pendingNotifications");
        synchronized (pendingNotifications2) {
            if (pendingNotifications2.isEmpty()) {
                return false;
            }
            CTInAppNotification cTInAppNotificationRemove = pendingNotifications2.remove(0);
            Intrinsics.checkNotNull(cTInAppNotificationRemove);
            checkLimitsBeforeShowing(cTInAppNotificationRemove);
            return true;
        }
    }

    private final void inAppDidDismiss(CTInAppNotification inAppNotification) {
        this.logger.verbose(this.defaultLogTag, "Running inAppDidDismiss");
        if (currentlyDisplayingInApp != null) {
            CTInAppNotification cTInAppNotification = currentlyDisplayingInApp;
            if (Intrinsics.areEqual(cTInAppNotification != null ? cTInAppNotification.getCampaignId() : null, inAppNotification.getCampaignId())) {
                currentlyDisplayingInApp = null;
                checkPendingNotifications();
            }
        }
    }

    private final void incrementLocalInAppCountInPersistentStore(final Context context, CTInAppNotification inAppNotification) {
        if (inAppNotification.getIsLocalInApp()) {
            this.deviceInfo.incrementLocalInAppCount();
            this.executors.ioTask().execute("InAppController#incrementLocalInAppCountInPersistentStore", new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return InAppController.incrementLocalInAppCountInPersistentStore$lambda$10(context, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit incrementLocalInAppCountInPersistentStore$lambda$10(Context context, InAppController this$0) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StorageHelper.INSTANCE.putIntImmediate(context, LOCAL_INAPP_COUNT, this$0.deviceInfo.getLocalInAppCount());
        return Unit.INSTANCE;
    }

    private final void checkLimitsBeforeShowing(final CTInAppNotification inAppNotification) {
        Task taskIoTask = this.executors.ioTask();
        taskIoTask.addOnSuccessListener(new OnSuccessListener() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda8
            @Override // com.clevertap.android.sdk.task.OnSuccessListener
            public final void onSuccess(Object obj) {
                InAppController.checkLimitsBeforeShowing$lambda$11(this.f$0, inAppNotification, (Boolean) obj);
            }
        });
        taskIoTask.execute("checkLimitsBeforeShowing", new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InAppController.checkLimitsBeforeShowing$lambda$13(this.f$0, inAppNotification);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkLimitsBeforeShowing$lambda$11(InAppController this$0, CTInAppNotification inAppNotification, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inAppNotification, "$inAppNotification");
        if (bool.booleanValue()) {
            this$0.showInApp(inAppNotification);
        } else {
            this$0.showNotificationIfAvailable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean checkLimitsBeforeShowing$lambda$13(final InAppController this$0, CTInAppNotification inAppNotification) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inAppNotification, "$inAppNotification");
        InAppFCManager inAppFCManager = this$0.controllerManager.getInAppFCManager();
        if (inAppFCManager != null) {
            if (!inAppFCManager.canShow(inAppNotification, new Function2() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(InAppController.checkLimitsBeforeShowing$lambda$13$lambda$12(this.f$0, (JSONObject) obj, (String) obj2));
                }
            })) {
                this$0.logger.verbose(this$0.defaultLogTag, "InApp has been rejected by FC, not showing " + inAppNotification.getCampaignId());
                return false;
            }
            return true;
        }
        this$0.logger.verbose(this$0.defaultLogTag, "InAppFCManager() is null, not showing " + inAppNotification.getCampaignId());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean checkLimitsBeforeShowing$lambda$13$lambda$12(InAppController this$0, JSONObject inAppJSON, String inAppId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inAppJSON, "inAppJSON");
        Intrinsics.checkNotNullParameter(inAppId, "inAppId");
        return !this$0.evaluationManager.matchWhenLimitsBeforeDisplay(InAppResponseAdapter.INSTANCE.getListOfWhenLimits(inAppJSON), inAppId);
    }

    private final boolean checkBeforeShowApprovalBeforeDisplay(CTInAppNotification inAppNotification) {
        HashMap<String, Object> map;
        InAppNotificationListener inAppNotificationListener = this.callbackManager.getInAppNotificationListener();
        if (inAppNotificationListener == null) {
            return true;
        }
        if (inAppNotification.getCustomExtras() != null) {
            map = Utils.convertJSONObjectToHashMap(inAppNotification.getCustomExtras());
        } else {
            map = new HashMap<>();
        }
        return inAppNotificationListener.beforeShow(map);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void showInApp(com.clevertap.android.sdk.inapp.CTInAppNotification r8) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.InAppController.showInApp(com.clevertap.android.sdk.inapp.CTInAppNotification):void");
    }

    private final void presentTemplate(CTInAppNotification inAppNotification) {
        this.templatesManager.presentTemplate(inAppNotification, this, FileResourceProvider.INSTANCE.getInstance(this.context, this.logger));
    }

    private final JSONArray filterNonRegisteredCustomTemplates(JSONArray inAppNotifications) {
        return JsonUtilsKt.filterObjects(inAppNotifications, new Function1() { // from class: com.clevertap.android.sdk.inapp.InAppController$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(InAppController.filterNonRegisteredCustomTemplates$lambda$14(this.f$0, (JSONObject) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterNonRegisteredCustomTemplates$lambda$14(InAppController this$0, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return !this$0.isNonRegisteredCustomTemplate(jsonObject);
    }

    private final boolean isNonRegisteredCustomTemplate(JSONObject inApp) {
        CustomTemplateInAppData customTemplateInAppDataCreateFromJson = CustomTemplateInAppData.INSTANCE.createFromJson(inApp);
        String templateName = customTemplateInAppDataCreateFromJson != null ? customTemplateInAppDataCreateFromJson.getTemplateName() : null;
        boolean z = (templateName == null || this.templatesManager.isTemplateRegistered(templateName)) ? false : true;
        if (z) {
            this.logger.info("CustomTemplates", "Template with name \"" + templateName + "\" is not registered and cannot be presented");
        }
        return z;
    }

    private final void triggerCustomTemplateAction(CTInAppNotification notification, CustomTemplateInAppData templateInAppData) throws JSONException {
        String templateName = templateInAppData != null ? templateInAppData.getTemplateName() : null;
        if (templateName != null) {
            CustomTemplate template = this.templatesManager.getTemplate(templateName);
            if (template != null) {
                CustomTemplateInAppData customTemplateInAppDataCopy$clevertap_core_release = templateInAppData.copy$clevertap_core_release();
                customTemplateInAppDataCopy$clevertap_core_release.setAction$clevertap_core_release(true);
                CTInAppNotification cTInAppNotificationCreateNotificationForAction$clevertap_core_release = notification.createNotificationForAction$clevertap_core_release(customTemplateInAppDataCopy$clevertap_core_release);
                if (cTInAppNotificationCreateNotificationForAction$clevertap_core_release == null) {
                    this.logger.debug("Failed to present custom template with name: " + templateName);
                    return;
                } else if (template.getIsVisual()) {
                    addInAppNotificationInFrontOfQueue(cTInAppNotificationCreateNotificationForAction$clevertap_core_release.getJsonDescription());
                    return;
                } else {
                    prepareNotificationForDisplay(cTInAppNotificationCreateNotificationForAction$clevertap_core_release.getJsonDescription());
                    return;
                }
            }
            this.logger.debug("Cannot present non-registered template with name: " + templateName);
            return;
        }
        this.logger.debug("Cannot present template without name.");
    }
}
