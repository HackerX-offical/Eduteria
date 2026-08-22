package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.g.g;
import com.microsoft.clarity.l.c;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.n.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/ReportMetricsWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0})
public final class ReportMetricsWorker extends BaseWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1103a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportMetricsWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f1103a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() {
        i.d("Report metric worker started.");
        g gVar = a.f689a;
        c cVarF = a.C0184a.f(this.f1103a);
        String string = getInputData().getString("PROJECT_ID");
        if (string == null) {
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(resultFailure, "failure()");
            return resultFailure;
        }
        String string2 = getInputData().getString("METRIC_DATA");
        if (string2 == null) {
            ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(resultFailure2, "failure()");
            return resultFailure2;
        }
        if (cVarF.a(string, string2)) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(resultSuccess, "{\n            Result.success()\n        }");
            return resultSuccess;
        }
        ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
        Intrinsics.checkNotNullExpressionValue(resultRetry, "{\n            Result.retry()\n        }");
        return resultRetry;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final void a(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String string = getInputData().getString("PROJECT_ID");
        if (string == null) {
            return;
        }
        g gVar = a.f689a;
        a.C0184a.a(this.f1103a, string).a(exception, ErrorType.ReportMetricsWorker, (PageMetadata) null);
    }
}
