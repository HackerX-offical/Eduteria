package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkerParameters;
import com.facebook.appevents.ml.ModelManager;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.b.a;
import com.microsoft.clarity.g.g;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.n.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/CleanupWorker;", "Lcom/microsoft/clarity/workers/BaseWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0})
public final class CleanupWorker extends BaseWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1101a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CleanupWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        this.f1101a = context;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final ListenableWorker.Result a() {
        i.d("Cleanup worker started.");
        String simpleName = Reflection.getOrCreateKotlinClass(UpdateClarityCachedConfigsWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        String simpleName2 = Reflection.getOrCreateKotlinClass(ReportExceptionWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName2);
        String simpleName3 = Reflection.getOrCreateKotlinClass(ReportMetricsWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName3);
        String simpleName4 = Reflection.getOrCreateKotlinClass(UploadSessionPayloadWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName4);
        WorkQuery workQueryBuild = WorkQuery.Builder.fromTags(CollectionsKt.listOf((Object[]) new String[]{simpleName, simpleName2, simpleName3, simpleName4})).build();
        Intrinsics.checkNotNullExpressionValue(workQueryBuild, "fromTags(tags).build()");
        WorkManager workManager = WorkManager.getInstance(this.f1101a);
        Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
        List<WorkInfo> list = workManager.getWorkInfos(workQueryBuild).get();
        Intrinsics.checkNotNullExpressionValue(list, "workManager\n            …query)\n            .get()");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            WorkInfo w = (WorkInfo) obj;
            Intrinsics.checkNotNullExpressionValue(w, "w");
            if (a(w)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(workManager.cancelWorkById(((WorkInfo) it.next()).getId()));
        }
        g gVar = a.f689a;
        com.microsoft.clarity.m.a aVarE = a.C0184a.e(this.f1101a);
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) ModelManager.MODEL_REQUEST_INTERVAL_MILLISECONDS);
        i.b("Deleting files before " + jCurrentTimeMillis + '.');
        List listA = com.microsoft.clarity.m.a.a(aVarE, null, true, 1);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listA) {
            if (((File) obj2).lastModified() < jCurrentTimeMillis) {
                arrayList3.add(obj2);
            }
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            ((File) it2.next()).delete();
        }
        aVarE.a();
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess, "success()");
        return resultSuccess;
    }

    @Override // com.microsoft.clarity.workers.BaseWorker
    public final void a(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String string = getInputData().getString("PROJECT_ID");
        if (string == null) {
            return;
        }
        g gVar = a.f689a;
        a.C0184a.a(this.f1101a, string).a(exception, ErrorType.CleanupWorker, (PageMetadata) null);
    }

    public static boolean a(WorkInfo workInfo) {
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) 172800000);
        Set<String> tags = workInfo.getTags();
        Intrinsics.checkNotNullExpressionValue(tags, "info.tags");
        for (String enqueueTimeTag : tags) {
            Intrinsics.checkNotNullExpressionValue(enqueueTimeTag, "t");
            if (StringsKt.startsWith(enqueueTimeTag, "ENQUEUED_AT_", true)) {
                Intrinsics.checkNotNullExpressionValue(enqueueTimeTag, "enqueueTimeTag");
                long j = Long.parseLong((String) CollectionsKt.last(StringsKt.split$default((CharSequence) enqueueTimeTag, new String[]{"_"}, false, 0, 6, (Object) null)));
                boolean z = j < jCurrentTimeMillis;
                if (z) {
                    i.b(b.a("Worker ").append(workInfo.getId()).append(" (enqueuedAt: ").append(j).append(" < timestamp: ").append(jCurrentTimeMillis).append(") should be cancelled.").toString());
                }
                return z;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
