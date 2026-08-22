package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.g.g;
import com.microsoft.clarity.l.c;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.telemetry.ErrorDetails;
import com.microsoft.clarity.n.i;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/ReportExceptionWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0})
public final class ReportExceptionWorker extends BaseWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1102a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportExceptionWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f1102a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() throws JSONException {
        PageMetadata pageMetadata;
        i.d("Report exception worker started.");
        g gVar = a.f689a;
        c cVarF = a.C0184a.f(this.f1102a);
        String string = getInputData().getString("ERROR_DETAILS");
        if (string == null) {
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(resultFailure, "failure()");
            return resultFailure;
        }
        String string2 = getInputData().getString("PAGE_METADATA");
        ErrorDetails errorDetailsFromJson = ErrorDetails.INSTANCE.fromJson(string);
        if (string2 == null || (pageMetadata = PageMetadata.INSTANCE.fromJson(string2)) == null) {
            String string3 = getInputData().getString("PROJECT_ID");
            if (string3 == null) {
                string3 = "DUMMY";
            }
            pageMetadata = new PageMetadata(new SessionMetadata("DUMMY", string3, "DUMMY", "DUMMY", System.currentTimeMillis(), 1, false, "https://www.clarity.ms/eus2/"), 0);
        }
        if (cVarF.a(errorDetailsFromJson, pageMetadata)) {
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
        i.c(exception.getMessage());
        i.c(ExceptionsKt.stackTraceToString(exception));
    }
}
