package com.appnew.android.WorkManger;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.appnew.android.Utils.SharedPreference;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: WorkTimer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/WorkManger/WorkTimer;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkTimer extends CoroutineWorker {
    public static final int $stable = 8;
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkTimer(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.context = context;
    }

    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1000;
        if (SharedPreference.getInstance().getInt("UserScreenTime") > 1000) {
            intRef.element = SharedPreference.getInstance().getInt("UserScreenTime");
        }
        new Timer().schedule(new TimerTask() { // from class: com.appnew.android.WorkManger.WorkTimer.doWork.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                intRef.element += 1000;
                Intent intent = new Intent("work_timer_data");
                intent.putExtra("current_time", intRef.element);
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.context);
                Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(...)");
                localBroadcastManager.sendBroadcast(intent);
                SharedPreference.getInstance().putInt("UserScreenTime", intRef.element);
            }
        }, 1000L, 1000L);
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess, "success(...)");
        return resultSuccess;
    }
}
