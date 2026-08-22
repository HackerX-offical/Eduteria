package com.clevertap.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.clevertap.android.sdk.PushPermissionHandler;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushPermissionHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0004*+,-BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000bJ(\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\"\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/clevertap/android/sdk/PushPermissionHandler;", "", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "ctListeners", "", "Lcom/clevertap/android/sdk/PushPermissionResponseListener;", "callback", "Lcom/clevertap/android/sdk/PushPermissionHandler$PushPermissionResultCallback;", "cacheProvider", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcom/clevertap/android/sdk/CTPreferenceCache;", "systemPermissionInterface", "Lcom/clevertap/android/sdk/PushPermissionHandler$SystemPushPermissionInterface;", "<init>", "(Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Ljava/util/List;Lcom/clevertap/android/sdk/PushPermissionHandler$PushPermissionResultCallback;Lkotlin/jvm/functions/Function1;Lcom/clevertap/android/sdk/PushPermissionHandler$SystemPushPermissionInterface;)V", "pushPermissionCallback", "Ljava/lang/ref/WeakReference;", "isFromNotificationSettingsActivity", "", "isPushPermissionGranted", "context", "notifyPushPermissionListeners", "", "notifyPushPermissionExternalListeners", "requestPermission", "activity", "Landroid/app/Activity;", "fallbackToSettings", "requestCallback", "Lcom/clevertap/android/sdk/PushPermissionHandler$PushPermissionRequestCallback;", "alwaysRequestIfNotGranted", "onActivityResume", "onRequestPermissionsResult", "requestCode", "", "grantResults", "", "notifyListeners", "isPermissionGranted", "notifyExternalListeners", "PushPermissionResultCallback", "PushPermissionRequestCallback", "Companion", "SystemPushPermissionInterface", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PushPermissionHandler {
    public static final String ANDROID_PERMISSION_STRING = "android.permission.POST_NOTIFICATIONS";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<Context, CTPreferenceCache> cacheProvider;
    private final CleverTapInstanceConfig config;
    private final List<PushPermissionResponseListener> ctListeners;
    private boolean isFromNotificationSettingsActivity;
    private final WeakReference<PushPermissionResultCallback> pushPermissionCallback;
    private final SystemPushPermissionInterface systemPermissionInterface;

    /* JADX INFO: compiled from: PushPermissionHandler.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/clevertap/android/sdk/PushPermissionHandler$PushPermissionRequestCallback;", "", "onRequestPermission", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PushPermissionRequestCallback {
        void onRequestPermission();
    }

    /* JADX INFO: compiled from: PushPermissionHandler.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/clevertap/android/sdk/PushPermissionHandler$PushPermissionResultCallback;", "", "onPushPermissionResult", "", "isGranted", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PushPermissionResultCallback {
        void onPushPermissionResult(boolean isGranted);
    }

    /* JADX INFO: compiled from: PushPermissionHandler.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/PushPermissionHandler$SystemPushPermissionInterface;", "", "isPushPermissionGranted", "", "context", "Landroid/content/Context;", "requestPushPermission", "", "activity", "Landroid/app/Activity;", "navigateToNotificationSettings", "shouldShowRequestPermissionRationale", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface SystemPushPermissionInterface {
        boolean isPushPermissionGranted(Context context);

        void navigateToNotificationSettings(Activity activity);

        void requestPushPermission(Activity activity);

        boolean shouldShowRequestPermissionRationale(Activity activity);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushPermissionHandler(CleverTapInstanceConfig config, List<? extends PushPermissionResponseListener> list) {
        this(config, list, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushPermissionHandler(CleverTapInstanceConfig config, List<? extends PushPermissionResponseListener> list, PushPermissionResultCallback pushPermissionResultCallback) {
        this(config, list, pushPermissionResultCallback, null, null, 24, null);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushPermissionHandler(CleverTapInstanceConfig config, List<? extends PushPermissionResponseListener> list, PushPermissionResultCallback pushPermissionResultCallback, Function1<? super Context, CTPreferenceCache> cacheProvider) {
        this(config, list, pushPermissionResultCallback, cacheProvider, null, 16, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(cacheProvider, "cacheProvider");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PushPermissionHandler(CleverTapInstanceConfig config, List<? extends PushPermissionResponseListener> list, PushPermissionResultCallback pushPermissionResultCallback, Function1<? super Context, CTPreferenceCache> cacheProvider, SystemPushPermissionInterface systemPermissionInterface) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(cacheProvider, "cacheProvider");
        Intrinsics.checkNotNullParameter(systemPermissionInterface, "systemPermissionInterface");
        this.config = config;
        this.ctListeners = list;
        this.cacheProvider = cacheProvider;
        this.systemPermissionInterface = systemPermissionInterface;
        this.pushPermissionCallback = new WeakReference<>(pushPermissionResultCallback);
    }

    public /* synthetic */ PushPermissionHandler(CleverTapInstanceConfig cleverTapInstanceConfig, List list, PushPermissionResultCallback pushPermissionResultCallback, Function1 function1, SystemPushPermissionInterface systemPushPermissionInterface, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cleverTapInstanceConfig, list, (i & 4) != 0 ? null : pushPermissionResultCallback, (i & 8) != 0 ? INSTANCE.defaultCacheProvider(cleverTapInstanceConfig) : function1, (i & 16) != 0 ? INSTANCE.defaultSystemInterface() : systemPushPermissionInterface);
    }

    /* JADX INFO: compiled from: PushPermissionHandler.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/PushPermissionHandler$Companion;", "", "<init>", "()V", "ANDROID_PERMISSION_STRING", "", "defaultCacheProvider", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcom/clevertap/android/sdk/CTPreferenceCache;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "defaultSystemInterface", "Lcom/clevertap/android/sdk/PushPermissionHandler$SystemPushPermissionInterface;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Function1<Context, CTPreferenceCache> defaultCacheProvider(final CleverTapInstanceConfig config) {
            return new Function1() { // from class: com.clevertap.android.sdk.PushPermissionHandler$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PushPermissionHandler.Companion.defaultCacheProvider$lambda$0(config, (Context) obj);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CTPreferenceCache defaultCacheProvider$lambda$0(CleverTapInstanceConfig config, Context context) {
            Intrinsics.checkNotNullParameter(config, "$config");
            Intrinsics.checkNotNullParameter(context, "context");
            return CTPreferenceCache.INSTANCE.getInstance(context, config);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SystemPushPermissionInterface defaultSystemInterface() {
            return new SystemPushPermissionInterface() { // from class: com.clevertap.android.sdk.PushPermissionHandler$Companion$defaultSystemInterface$1
                @Override // com.clevertap.android.sdk.PushPermissionHandler.SystemPushPermissionInterface
                public boolean isPushPermissionGranted(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    return ContextCompat.checkSelfPermission(context, PushPermissionHandler.ANDROID_PERMISSION_STRING) == 0;
                }

                @Override // com.clevertap.android.sdk.PushPermissionHandler.SystemPushPermissionInterface
                public void requestPushPermission(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    ActivityCompat.requestPermissions(activity, new String[]{PushPermissionHandler.ANDROID_PERMISSION_STRING}, 102);
                }

                @Override // com.clevertap.android.sdk.PushPermissionHandler.SystemPushPermissionInterface
                public void navigateToNotificationSettings(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Utils.navigateToAndroidSettingsForNotifications(activity);
                }

                @Override // com.clevertap.android.sdk.PushPermissionHandler.SystemPushPermissionInterface
                public boolean shouldShowRequestPermissionRationale(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    return ActivityCompat.shouldShowRequestPermissionRationale(activity, PushPermissionHandler.ANDROID_PERMISSION_STRING);
                }
            };
        }
    }

    public final boolean isPushPermissionGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.systemPermissionInterface.isPushPermissionGranted(context);
    }

    public final void notifyPushPermissionListeners(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        notifyListeners(isPushPermissionGranted(context));
    }

    public final void notifyPushPermissionExternalListeners(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        notifyExternalListeners(isPushPermissionGranted(context));
    }

    public static /* synthetic */ boolean requestPermission$default(PushPermissionHandler pushPermissionHandler, Activity activity, boolean z, PushPermissionRequestCallback pushPermissionRequestCallback, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return pushPermissionHandler.requestPermission(activity, z, pushPermissionRequestCallback, z2);
    }

    public final boolean requestPermission(Activity activity, boolean fallbackToSettings, PushPermissionRequestCallback requestCallback, boolean alwaysRequestIfNotGranted) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(requestCallback, "requestCallback");
        if (isPushPermissionGranted(activity)) {
            notifyListeners(true);
            return false;
        }
        boolean zIsFirstTimeRequest = this.cacheProvider.invoke(activity).isFirstTimeRequest();
        boolean zShouldShowRequestPermissionRationale = this.systemPermissionInterface.shouldShowRequestPermissionRationale(activity);
        if (alwaysRequestIfNotGranted || zIsFirstTimeRequest || zShouldShowRequestPermissionRationale) {
            requestCallback.onRequestPermission();
            return true;
        }
        if (fallbackToSettings) {
            this.isFromNotificationSettingsActivity = true;
            this.systemPermissionInterface.navigateToNotificationSettings(activity);
            return true;
        }
        notifyListeners(false);
        return false;
    }

    public final void requestPermission(final Activity activity, boolean fallbackToSettings) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        requestPermission$default(this, activity, fallbackToSettings, new PushPermissionRequestCallback() { // from class: com.clevertap.android.sdk.PushPermissionHandler.requestPermission.1
            @Override // com.clevertap.android.sdk.PushPermissionHandler.PushPermissionRequestCallback
            public void onRequestPermission() {
                PushPermissionHandler.this.systemPermissionInterface.requestPushPermission(activity);
            }
        }, false, 8, null);
    }

    public final void onActivityResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.isFromNotificationSettingsActivity) {
            this.isFromNotificationSettingsActivity = false;
            if (Build.VERSION.SDK_INT >= 33) {
                notifyListeners(isPushPermissionGranted(activity));
            }
        }
    }

    public final void onRequestPermissionsResult(Activity activity, int requestCode, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        CTPreferenceCache cTPreferenceCacheInvoke = this.cacheProvider.invoke(activity);
        boolean z = false;
        cTPreferenceCacheInvoke.setFirstTimeRequest(false);
        cTPreferenceCacheInvoke.updateCacheToDisk(activity, this.config);
        if (requestCode == 102) {
            Integer numFirstOrNull = ArraysKt.firstOrNull(grantResults);
            if (numFirstOrNull != null && numFirstOrNull.intValue() == 0) {
                z = true;
            }
            notifyListeners(z);
        }
    }

    private final void notifyListeners(boolean isPermissionGranted) {
        notifyExternalListeners(isPermissionGranted);
        PushPermissionResultCallback pushPermissionResultCallback = this.pushPermissionCallback.get();
        if (pushPermissionResultCallback != null) {
            pushPermissionResultCallback.onPushPermissionResult(isPermissionGranted);
        }
    }

    private final void notifyExternalListeners(boolean isPermissionGranted) {
        List<PushPermissionResponseListener> list = this.ctListeners;
        if (list != null) {
            for (PushPermissionResponseListener pushPermissionResponseListener : list) {
                if (pushPermissionResponseListener != null) {
                    pushPermissionResponseListener.onPushPermissionResponse(isPermissionGranted);
                }
            }
        }
    }
}
