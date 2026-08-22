package com.clevertap.android.sdk.pushnotification.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTFlushPushImpressionsWork.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/sdk/pushnotification/work/CTFlushPushImpressionsWork;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "tag", "", "getTag", "()Ljava/lang/String;", "doWork", "Landroidx/work/ListenableWorker$Result;", "checkIfStopped", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTFlushPushImpressionsWork extends Worker {
    private final String tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CTFlushPushImpressionsWork(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.tag = "CTFlushPushImpressionsWork";
    }

    public final String getTag() {
        return this.tag;
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Logger.d(this.tag, "hello, this is FlushPushImpressionsWork from CleverTap. I am awake now and ready to flush push impressions:-)");
        Logger.d(this.tag, "initiating push impressions flush...");
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ArrayList<CleverTapAPI> availableInstances = CleverTapAPI.getAvailableInstances(applicationContext);
        Intrinsics.checkNotNullExpressionValue(availableInstances, "getAvailableInstances(...)");
        List listFilterNotNull = CollectionsKt.filterNotNull(availableInstances);
        ArrayList<CleverTapAPI> arrayList = new ArrayList();
        for (Object obj : listFilterNotNull) {
            if (!((CleverTapAPI) obj).getCoreState().getConfig().isAnalyticsOnly()) {
                arrayList.add(obj);
            }
        }
        for (CleverTapAPI cleverTapAPI : arrayList) {
            if (checkIfStopped()) {
                ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
                Intrinsics.checkNotNullExpressionValue(resultSuccess, "success(...)");
                return resultSuccess;
            }
            Logger.d(this.tag, "flushing queue for push impressions on CT instance = " + cleverTapAPI.getAccountId());
            CTXtensions.flushPushImpressionsOnPostAsyncSafely(cleverTapAPI, this.tag, Constants.D_SRC_PI_WM, applicationContext);
        }
        Logger.d(this.tag, "flush push impressions work is DONE! going to sleep now...ˁ(-.-)ˀzzZZ");
        ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess2, "success(...)");
        return resultSuccess2;
    }

    private final boolean checkIfStopped() {
        if (isStopped()) {
            Logger.d(this.tag, "someone told me to stop flushing and go to sleep again! going to sleep now.ˁ(-.-)ˀzzZZ");
        }
        return isStopped();
    }
}
