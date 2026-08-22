package com.clevertap.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes7.dex */
public final class ActivityLifecycleCallback {
    private static String cleverTapId = null;
    private static final Application.ActivityLifecycleCallbacks lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.clevertap.android.sdk.ActivityLifecycleCallback.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            CleverTapAPI.onActivityCreated(activity, ActivityLifecycleCallback.cleverTapId);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            CleverTapAPI.onActivityPaused();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            CleverTapAPI.onActivityResumed(activity, ActivityLifecycleCallback.cleverTapId);
        }
    };
    public static boolean registered = false;

    public static void register(android.app.Application application) {
        register(application, null);
    }

    public static void register(android.app.Application application, String str) {
        if (application == null) {
            Logger.i("Application instance is null/system API is too old");
            return;
        }
        if (registered) {
            Logger.v("Lifecycle callbacks have already been registered");
            return;
        }
        cleverTapId = str;
        registered = true;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = lifecycleCallbacks;
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        Logger.i("Activity Lifecycle Callback successfully registered");
    }
}
