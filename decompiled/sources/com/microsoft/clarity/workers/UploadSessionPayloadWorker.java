package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.e.d;
import com.microsoft.clarity.e.e;
import com.microsoft.clarity.g.g;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.n.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/UploadSessionPayloadWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0})
public final class UploadSessionPayloadWorker extends BaseWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1105a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadSessionPayloadWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f1105a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() throws JSONException {
        ListenableWorker.Result resultRetry;
        String str;
        g gVar = a.f689a;
        d dVarC = a.C0184a.c(this.f1105a);
        String string = getInputData().getString("PAYLOAD_METADATA");
        if (string == null) {
            resultRetry = ListenableWorker.Result.failure();
            str = "failure()";
        } else {
            PayloadMetadata payloadMetadataFromJson = PayloadMetadata.INSTANCE.fromJson(string);
            i.d("Upload payload worker started for payload " + payloadMetadataFromJson + ", session " + payloadMetadataFromJson.getSessionId() + '.');
            if (dVarC.a(payloadMetadataFromJson)) {
                resultRetry = ListenableWorker.Result.success();
                str = "{\n            Result.success()\n        }";
            } else {
                resultRetry = ListenableWorker.Result.retry();
                str = "{\n            Result.retry()\n        }";
            }
        }
        Intrinsics.checkNotNullExpressionValue(resultRetry, str);
        return resultRetry;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final void a(Exception exception) {
        SessionMetadata sessionMetadataA;
        Intrinsics.checkNotNullParameter(exception, "exception");
        String string = getInputData().getString("PROJECT_ID");
        if (string == null) {
            return;
        }
        g gVar = a.f689a;
        e eVarA = a.C0184a.a(this.f1105a, string);
        ErrorType errorType = ErrorType.UploadSessionWorker;
        com.microsoft.clarity.k.a aVarB = a.C0184a.b(this.f1105a);
        String string2 = getInputData().getString("PAYLOAD_METADATA");
        eVarA.a(exception, errorType, (string2 == null || (sessionMetadataA = aVarB.a(PayloadMetadata.INSTANCE.fromJson(string2).getSessionId())) == null) ? null : new PageMetadata(sessionMetadataA, 0));
    }
}
