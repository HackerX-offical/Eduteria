package com.microsoft.clarity.e;

import android.app.Activity;
import android.content.Context;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.h.e;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.telemetry.AggregatedMetric;
import com.microsoft.clarity.models.telemetry.ErrorDetails;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.workers.ReportExceptionWorker;
import com.microsoft.clarity.workers.ReportMetricsWorker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements com.microsoft.clarity.h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f764d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f769e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public double f770f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f771g;

        public a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f765a = name;
        }

        public final int a() {
            return this.f766b;
        }

        public final void a(double d2) {
            if (this.f766b == 0) {
                this.f769e = d2;
                this.f768d = d2;
            } else {
                this.f769e = Math.min(d2, this.f769e);
                this.f768d = Math.max(d2, this.f768d);
            }
            int i = this.f766b + 1;
            this.f766b = i;
            this.f767c += d2;
            double d3 = this.f770f;
            double d4 = d2 - d3;
            double d5 = (d4 / ((double) i)) + d3;
            this.f770f = d5;
            this.f771g = (d4 * (d2 - d5)) + this.f771g;
        }

        public final double b() {
            return this.f768d;
        }

        public final double c() {
            return this.f769e;
        }

        public final String d() {
            return this.f765a;
        }

        public final double e() {
            int i = this.f766b;
            if (i == 0) {
                return 0.0d;
            }
            return Math.sqrt(this.f771g / ((double) i));
        }

        public final double f() {
            return this.f767c;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<AggregatedMetric> f772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f773b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List<AggregatedMetric> list, e eVar) {
            super(0);
            this.f772a = list;
            this.f773b = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            List<AggregatedMetric> list = this.f772a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((AggregatedMetric) it.next()).toJsonObject());
            }
            String string = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(metrics.map { …sonObject() }).toString()");
            this.f773b.a(string);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Exception, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            e.this.a(it, ErrorType.ReportMetricsWorker, (PageMetadata) null);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ErrorDetails f775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PageMetadata f776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f777c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f778d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f779e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ErrorDetails errorDetails, PageMetadata pageMetadata, e eVar, String str, String str2) {
            super(0);
            this.f775a = errorDetails;
            this.f776b = pageMetadata;
            this.f777c = eVar;
            this.f778d = str;
            this.f779e = str2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() throws JSONException {
            String json = this.f775a.toJson();
            PageMetadata pageMetadata = this.f776b;
            String json2 = pageMetadata != null ? pageMetadata.toJson() : null;
            Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) ReportExceptionWorker.class);
            Pair[] pairArr = {TuplesKt.to("PAGE_METADATA", json2), TuplesKt.to("ERROR_DETAILS", json), TuplesKt.to("PROJECT_ID", this.f777c.f762b)};
            Data.Builder builder2 = new Data.Builder();
            for (int i = 0; i < 3; i++) {
                Pair pair = pairArr[i];
                builder2.put((String) pair.getFirst(), pair.getSecond());
            }
            Data dataBuild = builder2.build();
            Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
            WorkManager.getInstance(this.f777c.f761a).enqueue(builder.setInputData(dataBuild).addTag(this.f778d).addTag(this.f779e).addTag(com.microsoft.clarity.a.b.a("ENQUEUED_AT_").append(System.currentTimeMillis()).toString()).setConstraints(constraintsBuild).build());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.microsoft.clarity.e.e$e, reason: collision with other inner class name */
    public static final class C0187e extends Lambda implements Function1<Exception, Unit> {
        public C0187e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            e.a(e.this, it);
            return Unit.INSTANCE;
        }
    }

    public e(Context context, String projectId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        this.f761a = context;
        this.f762b = projectId;
        this.f763c = new LinkedHashMap();
        this.f764d = new LinkedHashMap();
    }

    public static final void a(e eVar, Exception exc) {
        eVar.getClass();
        com.microsoft.clarity.n.i.c(exc.getMessage());
        com.microsoft.clarity.n.i.c(ExceptionsKt.stackTraceToString(exc));
    }

    public static final void a(ErrorDetails errorDetails, PageMetadata pageMetadata, e this$0, String tag, String typeTag) {
        Intrinsics.checkNotNullParameter(errorDetails, "$errorDetails");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Intrinsics.checkNotNullParameter(typeTag, "$typeTag");
        com.microsoft.clarity.n.e.a(new d(errorDetails, pageMetadata, this$0, tag, typeTag), this$0.new C0187e(), (o.c) null, 10);
    }

    public static final void a(List metrics, e this$0) {
        Intrinsics.checkNotNullParameter(metrics, "$metrics");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.microsoft.clarity.n.e.a(new b(metrics, this$0), this$0.new c(), (o.c) null, 10);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f763c) {
            for (a aVar : this.f763c.values()) {
                arrayList.add(new AggregatedMetric("1.3.3", aVar.d(), aVar.a(), aVar.f(), aVar.c(), aVar.b(), aVar.e(), 0, 128, null));
            }
            this.f763c.clear();
            Unit unit = Unit.INSTANCE;
        }
        a(arrayList);
    }

    public final void a(final ErrorDetails errorDetails, final PageMetadata pageMetadata) {
        Intrinsics.checkNotNullParameter(errorDetails, "errorDetails");
        final String simpleName = Reflection.getOrCreateKotlinClass(ReportExceptionWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        final String str = simpleName + '_' + errorDetails.getErrorType();
        if (b(str) > 15) {
            return;
        }
        new Thread(new Runnable() { // from class: com.microsoft.clarity.e.e$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                e.a(errorDetails, pageMetadata, this, simpleName, str);
            }
        }).start();
    }

    @Override // com.microsoft.clarity.h.e, com.microsoft.clarity.h.d
    public final void a(Exception exc, ErrorType errorType) {
        e.a.a(exc, errorType);
    }

    public final void a(String name, double d2) {
        Intrinsics.checkNotNullParameter(name, "name");
        synchronized (this.f763c) {
            LinkedHashMap linkedHashMap = this.f763c;
            Object aVar = linkedHashMap.get(name);
            if (aVar == null) {
                aVar = new a(name);
                linkedHashMap.put(name, aVar);
            }
            ((a) aVar).a(d2);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(final ArrayList metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (!metrics.isEmpty() && com.microsoft.clarity.a.a.f677b.booleanValue() && com.microsoft.clarity.a.a.f681f.booleanValue()) {
            new Thread(new Runnable() { // from class: com.microsoft.clarity.e.e$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    e.a(metrics, this);
                }
            }).start();
        }
    }

    public final int b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        synchronized (this.f764d) {
            if (this.f764d.containsKey(tag)) {
                LinkedHashMap linkedHashMap = this.f764d;
                Object obj = linkedHashMap.get(tag);
                Intrinsics.checkNotNull(obj);
                linkedHashMap.put(tag, Integer.valueOf(((Number) obj).intValue() + 1));
                Object obj2 = this.f764d.get(tag);
                Intrinsics.checkNotNull(obj2);
                return ((Number) obj2).intValue();
            }
            WorkQuery workQueryBuild = WorkQuery.Builder.fromTags(CollectionsKt.listOf(tag)).build();
            Intrinsics.checkNotNullExpressionValue(workQueryBuild, "fromTags(listOf(tag)).build()");
            WorkManager workManager = WorkManager.getInstance(this.f761a);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            this.f764d.put(tag, Integer.valueOf(workManager.getWorkInfos(workQueryBuild).get().size()));
            Object obj3 = this.f764d.get(tag);
            Intrinsics.checkNotNull(obj3);
            return ((Number) obj3).intValue();
        }
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityDestroyed(Activity activity) {
        e.a.a(activity);
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityPaused(Activity activity) {
        e.a.b(activity);
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityResumed(Activity activity) {
        e.a.c(activity);
    }

    public final void a(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String simpleName = Reflection.getOrCreateKotlinClass(ReportMetricsWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        if (b(simpleName) > 50) {
            return;
        }
        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) ReportMetricsWorker.class);
        Pair[] pairArr = {TuplesKt.to("PROJECT_ID", this.f762b), TuplesKt.to("METRIC_DATA", data)};
        Data.Builder builder2 = new Data.Builder();
        for (int i = 0; i < 2; i++) {
            Pair pair = pairArr[i];
            builder2.put((String) pair.getFirst(), pair.getSecond());
        }
        Data dataBuild = builder2.build();
        Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
        WorkManager.getInstance(this.f761a).enqueue(builder.setInputData(dataBuild).addTag(simpleName).addTag(com.microsoft.clarity.a.b.a("ENQUEUED_AT_").append(System.currentTimeMillis()).toString()).setConstraints(constraintsBuild).build());
    }

    public final void a(Exception exception, ErrorType errorType, PageMetadata pageMetadata) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        com.microsoft.clarity.n.i.c(exception.getMessage());
        com.microsoft.clarity.n.i.c(ExceptionsKt.stackTraceToString(exception));
        Boolean ENABLE_TELEMETRY_SERVICE = com.microsoft.clarity.a.a.f677b;
        Intrinsics.checkNotNullExpressionValue(ENABLE_TELEMETRY_SERVICE, "ENABLE_TELEMETRY_SERVICE");
        if (ENABLE_TELEMETRY_SERVICE.booleanValue()) {
            Boolean USE_WORKERS = com.microsoft.clarity.a.a.f681f;
            Intrinsics.checkNotNullExpressionValue(USE_WORKERS, "USE_WORKERS");
            if (USE_WORKERS.booleanValue()) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                String message = exception.getMessage();
                a(new ErrorDetails(errorType, strValueOf, message != null ? StringsKt.take(message, 512) : null, StringsKt.take(ExceptionsKt.stackTraceToString(exception), RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK)), pageMetadata);
            }
        }
    }
}
