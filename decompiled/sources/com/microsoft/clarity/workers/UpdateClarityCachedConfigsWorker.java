package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.e.a;
import com.microsoft.clarity.g.g;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.n.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/UpdateClarityCachedConfigsWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0})
public final class UpdateClarityCachedConfigsWorker extends BaseWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1104a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateClarityCachedConfigsWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f1104a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() {
        ListenableWorker.Result resultSuccess;
        String str;
        i.d("Update Clarity config worker started.");
        String string = getInputData().getString("PROJECT_ID");
        if (string == null) {
            resultSuccess = ListenableWorker.Result.failure();
            str = "failure()";
        } else {
            a.a(this.f1104a, string);
            resultSuccess = ListenableWorker.Result.success();
            str = "success()";
        }
        Intrinsics.checkNotNullExpressionValue(resultSuccess, str);
        return resultSuccess;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final void a(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String string = getInputData().getString("PROJECT_ID");
        if (string == null) {
            return;
        }
        g gVar = com.microsoft.clarity.b.a.f689a;
        a.C0184a.a(this.f1104a, string).a(exception, ErrorType.UpdateClarityCachedConfigsWorker, (PageMetadata) null);
    }
}
