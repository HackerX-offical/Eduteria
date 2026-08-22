package com.clevertap.android.sdk.pushnotification.work;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTWorkManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/pushnotification/work/CTWorkManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "<init>", "(Landroid/content/Context;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;)V", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", "logger", "Lcom/clevertap/android/sdk/Logger;", "schedulePushImpressionsFlushWork", "", "init", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTWorkManager {
    private final String accountId;
    private final Context context;
    private final Logger logger;

    public CTWorkManager(Context context, CleverTapInstanceConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        String accountId = config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        this.accountId = accountId;
        Logger logger = config.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        this.logger = logger;
    }

    private final void schedulePushImpressionsFlushWork() {
        this.logger.verbose(this.accountId, "scheduling one time work request to flush push impressions...");
        try {
            WorkManager.INSTANCE.getInstance(this.context).enqueueUniqueWork(Constants.FLUSH_PUSH_IMPRESSIONS_ONE_TIME_WORKER_NAME, ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) CTFlushPushImpressionsWork.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresCharging(true).build()).build());
            this.logger.verbose(this.accountId, "Finished scheduling one time work request to flush push impressions...");
        } catch (Throwable th) {
            this.logger.verbose(this.accountId, "Failed to schedule one time work request to flush push impressions.", th);
            th.printStackTrace();
        }
    }

    public final void init() {
        if (CTXtensions.isPackageAndOsTargetsAbove(this.context, 26)) {
            Context context = this.context;
            if (Utils.isMainProcess(context, context.getPackageName())) {
                schedulePushImpressionsFlushWork();
            }
        }
    }
}
