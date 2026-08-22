package com.razorpay;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoreInitializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/razorpay/CoreInitializer$deferCoreInitUntilFirstActivity$callbacks$1", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "checkout-otpelf-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoreInitializer$deferCoreInitUntilFirstActivity$callbacks$1 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Application $application;
    final /* synthetic */ boolean[] $hasTriggered;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    CoreInitializer$deferCoreInitUntilFirstActivity$callbacks$1(boolean[] zArr, Application application, Context context) {
        this.$hasTriggered = zArr;
        this.$application = application;
        this.$appContext = context;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean[] zArr = this.$hasTriggered;
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        this.$application.unregisterActivityLifecycleCallbacks(this);
        final Context context = this.$appContext;
        new Thread(new Runnable() { // from class: com.razorpay.CoreInitializer$deferCoreInitUntilFirstActivity$callbacks$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CoreInitializer$deferCoreInitUntilFirstActivity$callbacks$1.m12324onActivityResumed$lambda0(context);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onActivityResumed$lambda-0, reason: not valid java name */
    public static final void m12324onActivityResumed$lambda0(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "$appContext");
        try {
            ConfigCheckout.ensureInitialized(appContext);
            Lumberjack.transmitSavedEvents(appContext);
        } catch (Throwable th) {
            Logger.e("Error in CoreInitializer background task", th);
        }
    }
}
