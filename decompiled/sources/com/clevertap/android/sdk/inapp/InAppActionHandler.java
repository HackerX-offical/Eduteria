package com.clevertap.android.sdk.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.PushPermissionHandler;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.utils.PlayStoreReviewHandler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InAppActionHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0015\u001a\u00020\u0011JN\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u001928\u0010\u001a\u001a4\u0012*\u0012(\u0018\u00010 j\u0013\u0018\u0001`\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00170\u001bJ\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011J \u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006)"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppActionHandler;", "", "context", "Landroid/content/Context;", "ctConfig", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "pushPermissionHandler", "Lcom/clevertap/android/sdk/PushPermissionHandler;", "playStoreReviewHandler", "Lcom/clevertap/android/sdk/utils/PlayStoreReviewHandler;", "<init>", "(Landroid/content/Context;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;Lcom/clevertap/android/sdk/PushPermissionHandler;Lcom/clevertap/android/sdk/utils/PlayStoreReviewHandler;)V", "logger", "Lcom/clevertap/android/sdk/Logger;", "kotlin.jvm.PlatformType", "Lcom/clevertap/android/sdk/Logger;", "openUrl", "", "url", "", "launchContext", "isPlayStoreReviewLibraryAvailable", "launchPlayStoreReviewFlow", "", "onCompleted", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "Lkotlin/Exception;", "Lkotlin/ParameterName;", "name", "e", "Ljava/lang/Exception;", "arePushNotificationsEnabled", "notifyPushPermissionListeners", "launchPushPermissionPrompt", "fallbackToSettings", "alwaysRequestIfNotGranted", "presenter", "Lcom/clevertap/android/sdk/inapp/InAppActionHandler$PushPermissionPromptPresenter;", "PushPermissionPromptPresenter", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppActionHandler {
    private final Context context;
    private final CleverTapInstanceConfig ctConfig;
    private final Logger logger;
    private final PlayStoreReviewHandler playStoreReviewHandler;
    private final PushPermissionHandler pushPermissionHandler;

    /* JADX INFO: compiled from: InAppActionHandler.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppActionHandler$PushPermissionPromptPresenter;", "", "showPrompt", "", "activity", "Landroid/app/Activity;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PushPermissionPromptPresenter {
        void showPrompt(Activity activity);
    }

    public InAppActionHandler(Context context, CleverTapInstanceConfig ctConfig, PushPermissionHandler pushPermissionHandler, PlayStoreReviewHandler playStoreReviewHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ctConfig, "ctConfig");
        Intrinsics.checkNotNullParameter(pushPermissionHandler, "pushPermissionHandler");
        Intrinsics.checkNotNullParameter(playStoreReviewHandler, "playStoreReviewHandler");
        this.context = context;
        this.ctConfig = ctConfig;
        this.pushPermissionHandler = pushPermissionHandler;
        this.playStoreReviewHandler = playStoreReviewHandler;
        this.logger = ctConfig.getLogger();
    }

    public /* synthetic */ InAppActionHandler(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, PushPermissionHandler pushPermissionHandler, PlayStoreReviewHandler playStoreReviewHandler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, cleverTapInstanceConfig, pushPermissionHandler, (i & 8) != 0 ? new PlayStoreReviewHandler() : playStoreReviewHandler);
    }

    public static /* synthetic */ boolean openUrl$default(InAppActionHandler inAppActionHandler, String str, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            context = null;
        }
        return inAppActionHandler.openUrl(str, context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean openUrl(String url, Context launchContext) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Uri uri = Uri.parse(StringsKt.replace$default(StringsKt.replace$default(url, "\n", "", false, 4, (Object) null), "\r", "", false, 4, (Object) null));
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            Bundle bundle = new Bundle();
            Set<String> set = queryParameterNames;
            if (set != null && !set.isEmpty()) {
                for (String str : queryParameterNames) {
                    bundle.putString(str, uri.getQueryParameter(str));
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!bundle.isEmpty()) {
                intent.putExtras(bundle);
            }
            if (launchContext == null) {
                intent.setFlags(268435456);
                launchContext = this.context;
            }
            Utils.setPackageNameFromResolveInfoList(launchContext, intent);
            launchContext.startActivity(intent);
            return true;
        } catch (Exception unused) {
            if (StringsKt.startsWith$default(url, Constants.WZRK_URL_SCHEMA, false, 2, (Object) null)) {
                return true;
            }
            this.logger.debug("No activity found to open url: " + url);
            return false;
        }
    }

    public final boolean isPlayStoreReviewLibraryAvailable() {
        return this.playStoreReviewHandler.isPlayStoreReviewLibraryAvailable();
    }

    public final void launchPlayStoreReviewFlow(Function0<Unit> onCompleted, Function1<? super Exception, Unit> onError) {
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
        Intrinsics.checkNotNullParameter(onError, "onError");
        PlayStoreReviewHandler playStoreReviewHandler = this.playStoreReviewHandler;
        Context context = this.context;
        Logger logger = this.logger;
        Intrinsics.checkNotNullExpressionValue(logger, "logger");
        playStoreReviewHandler.launchReview(context, logger, onCompleted, onError);
    }

    public final boolean arePushNotificationsEnabled() {
        return this.pushPermissionHandler.isPushPermissionGranted(this.context);
    }

    public final void notifyPushPermissionListeners() {
        this.pushPermissionHandler.notifyPushPermissionListeners(this.context);
    }

    public final boolean launchPushPermissionPrompt(final boolean fallbackToSettings) {
        return launchPushPermissionPrompt$default(this, fallbackToSettings, false, new PushPermissionPromptPresenter() { // from class: com.clevertap.android.sdk.inapp.InAppActionHandler$$ExternalSyntheticLambda0
            @Override // com.clevertap.android.sdk.inapp.InAppActionHandler.PushPermissionPromptPresenter
            public final void showPrompt(Activity activity) {
                InAppActionHandler.launchPushPermissionPrompt$lambda$0(fallbackToSettings, this, activity);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchPushPermissionPrompt$lambda$0(boolean z, InAppActionHandler this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof InAppNotificationActivity) {
            ((InAppNotificationActivity) activity).showPushPermissionPrompt(z);
        } else {
            InAppNotificationActivity.launchForPushPermissionPrompt(activity, this$0.ctConfig, z);
        }
    }

    public static /* synthetic */ boolean launchPushPermissionPrompt$default(InAppActionHandler inAppActionHandler, boolean z, boolean z2, PushPermissionPromptPresenter pushPermissionPromptPresenter, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return inAppActionHandler.launchPushPermissionPrompt(z, z2, pushPermissionPromptPresenter);
    }

    public final boolean launchPushPermissionPrompt(boolean fallbackToSettings, boolean alwaysRequestIfNotGranted, final PushPermissionPromptPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        final Activity currentActivity = CoreMetaData.getCurrentActivity();
        if (currentActivity == null) {
            this.logger.debug("CurrentActivity reference is null. SDK can't prompt the user with Notification Permission! Ensure the following things:\n1. Calling ActivityLifecycleCallback.register(this) in your custom application class before super.onCreate().\n   Alternatively, register CleverTap SDK's Application class in the manifest using com.clevertap.android.sdk.Application.\n2. Ensure that the promptPushPrimer() API is called from the onResume() lifecycle method, not onCreate().");
            return false;
        }
        return this.pushPermissionHandler.requestPermission(currentActivity, fallbackToSettings, new PushPermissionHandler.PushPermissionRequestCallback() { // from class: com.clevertap.android.sdk.inapp.InAppActionHandler.launchPushPermissionPrompt.2
            @Override // com.clevertap.android.sdk.PushPermissionHandler.PushPermissionRequestCallback
            public void onRequestPermission() {
                presenter.showPrompt(currentActivity);
            }
        }, alwaysRequestIfNotGranted);
    }
}
