package com.clevertap.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.clevertap.android.sdk.events.BaseEventQueueManager;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.task.CTExecutors;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.Clock;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes7.dex */
class ActivityLifeCycleManager {
    private final AnalyticsManager analyticsManager;
    private final BaseEventQueueManager baseEventQueueManager;
    private final BaseCallbackManager callbackManager;
    private final Clock clock;
    private final CleverTapInstanceConfig config;
    private final Context context;
    private final CoreMetaData coreMetaData;
    private final CTExecutors executors;
    private final InAppController inAppController;
    private final PushProviders pushProviders;
    private final SessionManager sessionManager;

    ActivityLifeCycleManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, AnalyticsManager analyticsManager, CoreMetaData coreMetaData, SessionManager sessionManager, PushProviders pushProviders, BaseCallbackManager baseCallbackManager, InAppController inAppController, BaseEventQueueManager baseEventQueueManager, CTExecutors cTExecutors, Clock clock) {
        this.context = context;
        this.config = cleverTapInstanceConfig;
        this.analyticsManager = analyticsManager;
        this.coreMetaData = coreMetaData;
        this.sessionManager = sessionManager;
        this.pushProviders = pushProviders;
        this.callbackManager = baseCallbackManager;
        this.inAppController = inAppController;
        this.baseEventQueueManager = baseEventQueueManager;
        this.executors = cTExecutors;
        this.clock = clock;
    }

    public void activityPaused() {
        CoreMetaData.setAppForeground(false);
        this.sessionManager.setAppLastSeen(System.currentTimeMillis());
        this.config.getLogger().verbose(this.config.getAccountId(), "App in background");
        this.executors.postAsyncSafelyTask().execute("activityPaused", new Callable<Void>() { // from class: com.clevertap.android.sdk.ActivityLifeCycleManager.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!ActivityLifeCycleManager.this.coreMetaData.inCurrentSession()) {
                    return null;
                }
                try {
                    StorageHelper.putInt(ActivityLifeCycleManager.this.context, ActivityLifeCycleManager.this.config.getAccountId(), Constants.LAST_SESSION_EPOCH, iCurrentTimeMillis);
                    ActivityLifeCycleManager.this.config.getLogger().verbose(ActivityLifeCycleManager.this.config.getAccountId(), "Updated session time: " + iCurrentTimeMillis);
                    return null;
                } catch (Throwable th) {
                    ActivityLifeCycleManager.this.config.getLogger().verbose(ActivityLifeCycleManager.this.config.getAccountId(), "Failed to update session time time: " + th.getMessage());
                    return null;
                }
            }
        });
    }

    public void activityResumed(Activity activity) {
        this.config.getLogger().verbose(this.config.getAccountId(), "App in foreground");
        this.sessionManager.checkTimeoutSession();
        if (!this.coreMetaData.isAppLaunchPushed()) {
            this.analyticsManager.pushAppLaunchedEvent();
            this.analyticsManager.fetchFeatureFlags();
            this.pushProviders.onTokenRefresh();
            this.executors.postAsyncSafelyTask().execute("HandlingInstallReferrer", new Callable<Void>() { // from class: com.clevertap.android.sdk.ActivityLifeCycleManager.2
                @Override // java.util.concurrent.Callable
                public Void call() {
                    if (ActivityLifeCycleManager.this.coreMetaData.isInstallReferrerDataSent() || !ActivityLifeCycleManager.this.coreMetaData.isFirstSession()) {
                        return null;
                    }
                    ActivityLifeCycleManager.this.handleInstallReferrerOnFirstInstall();
                    return null;
                }
            });
            this.executors.ioTask().execute("CleanUpOldGIFs", new Callable() { // from class: com.clevertap.android.sdk.ActivityLifeCycleManager$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m11846x83c0bded();
                }
            });
            try {
                if (this.callbackManager.getGeofenceCallback() != null) {
                    this.callbackManager.getGeofenceCallback().triggerLocation();
                }
            } catch (IllegalStateException e2) {
                this.config.getLogger().verbose(this.config.getAccountId(), e2.getLocalizedMessage());
            } catch (Exception unused) {
                this.config.getLogger().verbose(this.config.getAccountId(), "Failed to trigger location");
            }
        }
        this.baseEventQueueManager.pushInitialEventsAsync();
        this.inAppController.showNotificationIfAvailable();
    }

    /* JADX INFO: renamed from: lambda$activityResumed$0$com-clevertap-android-sdk-ActivityLifeCycleManager, reason: not valid java name */
    /* synthetic */ Void m11846x83c0bded() throws Exception {
        Utils.cleanupOldGIFs(this.context, this.config, this.clock);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000a A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x0002, B:8:0x0018, B:10:0x001e, B:12:0x0027, B:5:0x000a), top: B:20:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityCreated(android.os.Bundle r2, android.net.Uri r3, java.lang.String r4) {
        /*
            r1 = this;
            if (r4 != 0) goto La
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r1.config     // Catch: java.lang.Throwable -> L35
            boolean r0 = r0.isDefaultInstance()     // Catch: java.lang.Throwable -> L35
            if (r0 != 0) goto L16
        La:
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r1.config     // Catch: java.lang.Throwable -> L35
            java.lang.String r0 = r0.getAccountId()     // Catch: java.lang.Throwable -> L35
            boolean r4 = r0.equals(r4)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L4c
        L16:
            if (r2 == 0) goto L2c
            boolean r4 = r2.isEmpty()     // Catch: java.lang.Throwable -> L35
            if (r4 != 0) goto L2c
            java.lang.String r4 = "wzrk_pn"
            boolean r4 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L2c
            com.clevertap.android.sdk.AnalyticsManager r4 = r1.analyticsManager     // Catch: java.lang.Throwable -> L35
            r4.pushNotificationClickedEvent(r2)     // Catch: java.lang.Throwable -> L35
        L2c:
            if (r3 == 0) goto L4c
            com.clevertap.android.sdk.AnalyticsManager r2 = r1.analyticsManager     // Catch: java.lang.Throwable -> L4c
            r4 = 0
            r2.pushDeepLink(r3, r4)     // Catch: java.lang.Throwable -> L4c
            goto L4c
        L35:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Throwable - "
            r3.<init>(r4)
            java.lang.String r2 = r2.getLocalizedMessage()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            com.clevertap.android.sdk.Logger.v(r2)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.ActivityLifeCycleManager.onActivityCreated(android.os.Bundle, android.net.Uri, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInstallReferrerOnFirstInstall() {
        this.config.getLogger().verbose(this.config.getAccountId(), "Starting to handle install referrer");
        try {
            InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(this.context).build();
            installReferrerClientBuild.startConnection(new AnonymousClass3(installReferrerClientBuild));
        } catch (Throwable th) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Google Play Install Referrer's InstallReferrerClient Class not found - " + th.getLocalizedMessage() + " \n Please add implementation 'com.android.installreferrer:installreferrer:2.1' to your build.gradle");
        }
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.ActivityLifeCycleManager$3, reason: invalid class name */
    class AnonymousClass3 implements InstallReferrerStateListener {
        final /* synthetic */ InstallReferrerClient val$referrerClient;

        AnonymousClass3(InstallReferrerClient installReferrerClient) {
            this.val$referrerClient = installReferrerClient;
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
            if (ActivityLifeCycleManager.this.coreMetaData.isInstallReferrerDataSent()) {
                return;
            }
            ActivityLifeCycleManager.this.handleInstallReferrerOnFirstInstall();
        }

        /* JADX INFO: renamed from: lambda$onInstallReferrerSetupFinished$0$com-clevertap-android-sdk-ActivityLifeCycleManager$3, reason: not valid java name */
        /* synthetic */ void m11847xafee3a16(InstallReferrerClient installReferrerClient, ReferrerDetails referrerDetails) {
            try {
                String installReferrer = referrerDetails.getInstallReferrer();
                ActivityLifeCycleManager.this.coreMetaData.setReferrerClickTime(referrerDetails.getReferrerClickTimestampSeconds());
                ActivityLifeCycleManager.this.coreMetaData.setAppInstallTime(referrerDetails.getInstallBeginTimestampSeconds());
                ActivityLifeCycleManager.this.analyticsManager.pushInstallReferrer(installReferrer);
                ActivityLifeCycleManager.this.coreMetaData.setInstallReferrerDataSent(true);
                ActivityLifeCycleManager.this.config.getLogger().debug(ActivityLifeCycleManager.this.config.getAccountId(), "Install Referrer data set [Referrer URL-" + installReferrer + Constants.AES_SUFFIX);
            } catch (NullPointerException e2) {
                ActivityLifeCycleManager.this.config.getLogger().debug(ActivityLifeCycleManager.this.config.getAccountId(), "Install referrer client null pointer exception caused by Google Play Install Referrer library - " + e2.getMessage());
                installReferrerClient.endConnection();
                ActivityLifeCycleManager.this.coreMetaData.setInstallReferrerDataSent(false);
            }
        }

        /* JADX INFO: renamed from: lambda$onInstallReferrerSetupFinished$1$com-clevertap-android-sdk-ActivityLifeCycleManager$3, reason: not valid java name */
        /* synthetic */ ReferrerDetails m11848xca09b8b5(InstallReferrerClient installReferrerClient) throws Exception {
            try {
                return installReferrerClient.getInstallReferrer();
            } catch (RemoteException e2) {
                ActivityLifeCycleManager.this.config.getLogger().debug(ActivityLifeCycleManager.this.config.getAccountId(), "Remote exception caused by Google Play Install Referrer library - " + e2.getMessage());
                installReferrerClient.endConnection();
                ActivityLifeCycleManager.this.coreMetaData.setInstallReferrerDataSent(false);
                return null;
            }
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int i) {
            if (i == 0) {
                Task taskPostAsyncSafelyTask = ActivityLifeCycleManager.this.executors.postAsyncSafelyTask();
                final InstallReferrerClient installReferrerClient = this.val$referrerClient;
                taskPostAsyncSafelyTask.addOnSuccessListener(new OnSuccessListener() { // from class: com.clevertap.android.sdk.ActivityLifeCycleManager$3$$ExternalSyntheticLambda0
                    @Override // com.clevertap.android.sdk.task.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        this.f$0.m11847xafee3a16(installReferrerClient, (ReferrerDetails) obj);
                    }
                });
                final InstallReferrerClient installReferrerClient2 = this.val$referrerClient;
                taskPostAsyncSafelyTask.execute("ActivityLifeCycleManager#getInstallReferrer", new Callable() { // from class: com.clevertap.android.sdk.ActivityLifeCycleManager$3$$ExternalSyntheticLambda1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f$0.m11848xca09b8b5(installReferrerClient2);
                    }
                });
                return;
            }
            if (i == 1) {
                ActivityLifeCycleManager.this.config.getLogger().debug(ActivityLifeCycleManager.this.config.getAccountId(), "Install Referrer data not set, connection to Play Store unavailable");
            } else {
                if (i != 2) {
                    return;
                }
                ActivityLifeCycleManager.this.config.getLogger().debug(ActivityLifeCycleManager.this.config.getAccountId(), "Install Referrer data not set, API not supported by Play Store on device");
            }
        }
    }
}
