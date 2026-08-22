package com.microsoft.clarity.f;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.clevertap.android.sdk.network.NetworkRepo;
import com.csvreader.CsvReader;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.display.common.Asset;
import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import com.microsoft.clarity.models.display.paints.shaders.LocalMatrixShader;
import com.microsoft.clarity.models.display.paints.shaders.Shader;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import com.microsoft.clarity.models.ingest.BaseWebViewEvent;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.ingest.analytics.BaselineEvent;
import com.microsoft.clarity.models.ingest.analytics.FragmentVisibility;
import com.microsoft.clarity.models.ingest.analytics.Visibility;
import com.microsoft.clarity.models.ingest.mutation.MutationErrorEvent;
import com.microsoft.clarity.models.ingest.mutation.MutationEvent;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.models.viewhierarchy.WebViewData;
import com.microsoft.clarity.workers.UploadSessionPayloadWorker;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class q implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClarityConfig f857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DynamicConfig f858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.microsoft.clarity.k.b f859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.microsoft.clarity.e.d f860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.microsoft.clarity.e.e f861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SessionMetadata f863h;
    public int i;
    public long j;
    public int k;
    public PayloadMetadata l;
    public boolean m;
    public LinkedHashSet n;
    public DisplayFrame o;
    public final LinkedHashMap p;
    public final List<BaseWebViewEvent> q;
    public final com.microsoft.clarity.e.h r;
    public final com.microsoft.clarity.k.d s;
    public Visibility t;
    public final LinkedHashMap u;
    public final LinkedBlockingQueue<Function0<Unit>> v;

    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            Function0 function0 = (Function0) q.this.v.take();
            com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Task queue size: ").append(q.this.v.size()).append('.').toString());
            function0.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            q.this.f861f.a(it, ErrorType.EventProcessingTaskExecution, q.this.a());
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnalyticsEvent f866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f867b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(q qVar, AnalyticsEvent analyticsEvent) {
            super(0);
            this.f866a = analyticsEvent;
            this.f867b = qVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final kotlin.Unit invoke() {
            /*
                r5 = this;
                java.lang.String r0 = "New analytics event "
                java.lang.StringBuilder r0 = com.microsoft.clarity.a.b.a(r0)
                com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent r1 = r5.f866a
                com.microsoft.clarity.models.ingest.EventType r1 = r1.getType()
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r1 = " received for activity "
                java.lang.StringBuilder r0 = r0.append(r1)
                com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent r1 = r5.f866a
                java.lang.String r1 = r1.getActivityName()
                java.lang.StringBuilder r0 = r0.append(r1)
                r1 = 35
                java.lang.StringBuilder r0 = r0.append(r1)
                com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent r1 = r5.f866a
                int r1 = r1.getActivityId()
                java.lang.StringBuilder r0 = r0.append(r1)
                r1 = 46
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.microsoft.clarity.n.i.b(r0)
                com.microsoft.clarity.f.q r0 = r5.f867b
                boolean r0 = r0.e()
                if (r0 == 0) goto L85
                com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent r0 = r5.f866a
                long r0 = r0.getTimestamp()
                com.microsoft.clarity.f.q r2 = r5.f867b
                long r3 = r2.j
                int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r0 < 0) goto L85
                com.microsoft.clarity.models.display.DisplayFrame r0 = r2.o
                if (r0 == 0) goto L85
                com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent r1 = r5.f866a
                int r1 = r1.getActivityId()
                int r0 = r0.getActivityId()
                if (r1 != r0) goto L85
                com.microsoft.clarity.f.q r0 = r5.f867b
                boolean r0 = r0.f()
                if (r0 == 0) goto L71
                java.lang.String r0 = "Dropping Analytics Event because current page payload count limit has been exceeded"
                com.microsoft.clarity.n.i.b(r0)
                goto L8a
            L71:
                com.microsoft.clarity.f.q r0 = r5.f867b
                com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent r1 = r5.f866a
                r0.b(r1)
                com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent r0 = r5.f866a
                boolean r1 = r0 instanceof com.microsoft.clarity.models.ingest.analytics.Visibility
                if (r1 == 0) goto L8a
                com.microsoft.clarity.f.q r1 = r5.f867b
                com.microsoft.clarity.models.ingest.analytics.Visibility r0 = (com.microsoft.clarity.models.ingest.analytics.Visibility) r0
                r1.t = r0
                goto L8a
            L85:
                java.lang.String r0 = "Skipping residual analytics event from another page."
                com.microsoft.clarity.n.i.b(r0)
            L8a:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.f.q.c.invoke():java.lang.Object");
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DisplayFrame f868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f869b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(q qVar, DisplayFrame displayFrame) {
            super(0);
            this.f868a = displayFrame;
            this.f869b = qVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() throws Throwable {
            String string;
            com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("New frame received for activity ").append(this.f868a.getActivityName()).append(CsvReader.Letters.POUND).append(this.f868a.getActivityId()).append('.').toString());
            if (this.f868a.getTimestamp() < this.f869b.j) {
                string = com.microsoft.clarity.a.b.a("Frame dropped because its timestamp ").append(this.f868a.getTimestamp()).append(" is smaller than the current page timestamp ").append(this.f869b.j).append('.').toString();
            } else {
                this.f869b.d(this.f868a);
                if (!this.f869b.f()) {
                    this.f869b.c(this.f868a);
                    DisplayFrame displayFrame = this.f868a;
                    displayFrame.setTimestamp(displayFrame.getTimestamp() - this.f869b.j);
                    this.f869b.a(this.f868a.getTimestamp(), this.f868a.getActivityName(), this.f868a.getActivityId());
                    PayloadMetadata payloadMetadata = this.f869b.l;
                    Intrinsics.checkNotNull(payloadMetadata);
                    payloadMetadata.updateDuration(this.f868a.getTimestamp());
                    com.microsoft.clarity.k.b bVar = this.f869b.f859d;
                    PayloadMetadata payloadMetadata2 = this.f869b.l;
                    Intrinsics.checkNotNull(payloadMetadata2);
                    q qVar = this.f869b;
                    DisplayFrame displayFrame2 = this.f868a;
                    qVar.getClass();
                    bVar.a(payloadMetadata2, q.b(displayFrame2));
                    q.b(this.f869b, this.f868a);
                    q.a(this.f869b, this.f868a);
                    this.f869b.k++;
                    this.f869b.o = this.f868a;
                    return Unit.INSTANCE;
                }
                string = "Dropping Display Frame because current page payload count has been exceeded";
            }
            com.microsoft.clarity.n.i.b(string);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ErrorDisplayFrame f871b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ErrorDisplayFrame errorDisplayFrame) {
            super(0);
            this.f871b = errorDisplayFrame;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            if (q.this.e() && this.f871b.getAbsoluteTimestamp() >= q.this.j) {
                if (q.this.f()) {
                    com.microsoft.clarity.n.i.b("Dropping Error Frame because current page payload count has been exceeded");
                } else {
                    long absoluteTimestamp = this.f871b.getAbsoluteTimestamp() - q.this.j;
                    q.this.a(absoluteTimestamp, this.f871b.getActivityName(), this.f871b.getActivityId());
                    PayloadMetadata payloadMetadata = q.this.l;
                    Intrinsics.checkNotNull(payloadMetadata);
                    payloadMetadata.updateDuration(absoluteTimestamp);
                    com.microsoft.clarity.k.b bVar = q.this.f859d;
                    PayloadMetadata payloadMetadata2 = q.this.l;
                    Intrinsics.checkNotNull(payloadMetadata2);
                    bVar.a(payloadMetadata2, new MutationErrorEvent(absoluteTimestamp, this.f871b.getReason()));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebViewAnalyticsEvent f872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f873b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(WebViewAnalyticsEvent webViewAnalyticsEvent, q qVar) {
            super(0);
            this.f872a = webViewAnalyticsEvent;
            this.f873b = qVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() throws Throwable {
            com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Received web view analytics event ").append(this.f872a.getData()).append('.').toString());
            q.a(this.f873b, this.f872a);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebViewMutationEvent f874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f875b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(WebViewMutationEvent webViewMutationEvent, q qVar) {
            super(0);
            this.f874a = webViewMutationEvent;
            this.f875b = qVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() throws Throwable {
            com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Received web view mutation event ").append(this.f874a.getData()).append('.').toString());
            q.a(this.f875b, this.f874a);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PayloadMetadata f878c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, q qVar, PayloadMetadata payloadMetadata) {
            super(0);
            this.f876a = str;
            this.f877b = qVar;
            this.f878c = payloadMetadata;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() throws com.microsoft.clarity.c.f {
            com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Live upload session ").append(this.f876a).append('.').toString());
            this.f877b.f860e.a(this.f878c);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<Exception, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            q.this.f861f.a(it, ErrorType.UploadSessionPayloadLive, q.this.a());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class j extends FunctionReferenceImpl implements Function2<String, byte[], Unit> {
        public j(Object obj) {
            super(2, obj, q.class, "processWebAsset", "processWebAsset(Ljava/lang/String;[B)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(String str, byte[] bArr) {
            String p0 = str;
            byte[] p1 = bArr;
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            q.a((q) this.receiver, p0, p1);
            return Unit.INSTANCE;
        }
    }

    public q(Context context, ClarityConfig config, DynamicConfig dynamicConfig, com.microsoft.clarity.k.b sessionRepository, com.microsoft.clarity.e.d sessionUploader, com.microsoft.clarity.e.e telemetryTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(sessionUploader, "sessionUploader");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        this.f856a = context;
        this.f857b = config;
        this.f858c = dynamicConfig;
        this.f859d = sessionRepository;
        this.f860e = sessionUploader;
        this.f861f = telemetryTracker;
        this.m = true;
        this.n = new LinkedHashSet();
        this.p = new LinkedHashMap();
        this.q = Collections.synchronizedList(new ArrayList());
        this.r = new com.microsoft.clarity.e.h(context, config, new j(this));
        this.s = new com.microsoft.clarity.k.d(context);
        this.u = new LinkedHashMap();
        this.v = new LinkedBlockingQueue<>();
        d();
    }

    public static final void a(q qVar, DisplayFrame displayFrame) {
        Set<String> setEmptySet;
        Set<String> setEmptySet2;
        DisplayFrame displayFrame2;
        ViewHierarchy viewHierarchy;
        DisplayFrame displayFrame3 = qVar.o;
        if (displayFrame3 == null || displayFrame3.getActivityId() != displayFrame.getActivityId() || (displayFrame2 = qVar.o) == null || (viewHierarchy = displayFrame2.getViewHierarchy()) == null || (setEmptySet = viewHierarchy.getVisibleFragments()) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        ViewHierarchy viewHierarchy2 = displayFrame.getViewHierarchy();
        if (viewHierarchy2 == null || (setEmptySet2 = viewHierarchy2.getVisibleFragments()) == null) {
            setEmptySet2 = SetsKt.emptySet();
        }
        Set setMinus = SetsKt.minus((Set) setEmptySet2, (Iterable) setEmptySet);
        Iterator it = SetsKt.minus((Set) setEmptySet, (Iterable) setEmptySet2).iterator();
        while (it.hasNext()) {
            qVar.b(new FragmentVisibility(displayFrame.getTimestamp() + qVar.j, displayFrame.getActivityName(), displayFrame.getActivityId(), "hidden", (String) it.next()));
        }
        Iterator it2 = setMinus.iterator();
        while (it2.hasNext()) {
            qVar.b(new FragmentVisibility(displayFrame.getTimestamp() + qVar.j, displayFrame.getActivityName(), displayFrame.getActivityId(), "visible", (String) it2.next()));
        }
    }

    public static final void a(q qVar, Asset asset) {
        String dataHash = asset.getDataHash();
        if (dataHash == null || dataHash.length() == 0 || CollectionsKt.contains(qVar.n, asset.getDataHash())) {
            return;
        }
        com.microsoft.clarity.k.b bVar = qVar.f859d;
        SessionMetadata sessionMetadata = qVar.f863h;
        Intrinsics.checkNotNull(sessionMetadata);
        String sessionId = sessionMetadata.getSessionId();
        String dataHash2 = asset.getDataHash();
        Intrinsics.checkNotNull(dataHash2);
        AssetType type = asset.getType();
        Intrinsics.checkNotNullExpressionValue(type, "asset.type");
        byte[] data = asset.getData();
        Intrinsics.checkNotNullExpressionValue(data, "asset.data");
        bVar.a(sessionId, dataHash2, type, data);
        LinkedHashSet linkedHashSet = qVar.n;
        String dataHash3 = asset.getDataHash();
        Intrinsics.checkNotNull(dataHash3);
        linkedHashSet.add(dataHash3);
    }

    public static final void a(String id, q this$0, PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(id, "$id");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(payloadMetadata, "$payloadMetadata");
        com.microsoft.clarity.n.e.a(new h(id, this$0, payloadMetadata), this$0.new i(), (o.c) null, 10);
    }

    public static MutationEvent b(DisplayFrame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        byte[] byteArray = frame.toProtobufInstance().toByteArray();
        long timestamp = frame.getTimestamp();
        String strEncodeToString = Base64.getEncoder().encodeToString(byteArray);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "getEncoder().encodeToString(data)");
        return new MutationEvent(timestamp, true, strEncodeToString);
    }

    public static final void b(q qVar, DisplayFrame displayFrame) throws Throwable {
        qVar.getClass();
        ViewHierarchy viewHierarchy = displayFrame.getViewHierarchy();
        Intrinsics.checkNotNull(viewHierarchy);
        for (WebViewData webViewData : viewHierarchy.getWebViewsData()) {
            if (webViewData.getFoundInDisplayList() && !qVar.p.containsKey(Integer.valueOf(webViewData.getHashCode()))) {
                com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Registering webview #").append(webViewData.getHashCode()).append(" load time to ").append(displayFrame.getTimestamp()).append('.').toString());
                qVar.p.put(Integer.valueOf(webViewData.getHashCode()), Long.valueOf(displayFrame.getTimestamp()));
                int hashCode = webViewData.getHashCode();
                com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Flushing queued web view events (queue size: ").append(qVar.q.size()).append(").").toString());
                Long l = (Long) qVar.p.get(Integer.valueOf(hashCode));
                if (l != null) {
                    long jLongValue = l.longValue();
                    List<BaseWebViewEvent> webViewEvents = qVar.q;
                    Intrinsics.checkNotNullExpressionValue(webViewEvents, "webViewEvents");
                    ArrayList<BaseWebViewEvent> arrayList = new ArrayList();
                    for (Object obj : webViewEvents) {
                        if (((BaseWebViewEvent) obj).getWebViewHashCode() == hashCode) {
                            arrayList.add(obj);
                        }
                    }
                    for (BaseWebViewEvent event : arrayList) {
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        long absoluteTimestamp = event.getAbsoluteTimestamp() - qVar.j;
                        if (absoluteTimestamp < 0 || absoluteTimestamp < jLongValue) {
                            absoluteTimestamp = 1 + jLongValue;
                        }
                        event.setTimestamp(absoluteTimestamp);
                        qVar.a(event);
                    }
                    com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Number of queued web view events to remove: ").append(arrayList.size()).append('.').toString());
                    qVar.q.removeAll(arrayList);
                }
            }
        }
    }

    public static final void h(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        while (true) {
            com.microsoft.clarity.n.e.a(this$0.new a(), this$0.new b(), (o.c) null, 10);
        }
    }

    @Override // com.microsoft.clarity.f.n
    public final PageMetadata a() {
        if (this.f863h == null) {
            return null;
        }
        SessionMetadata sessionMetadata = this.f863h;
        Intrinsics.checkNotNull(sessionMetadata);
        return new PageMetadata(sessionMetadata, this.i);
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(DisplayFrame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        com.microsoft.clarity.n.i.b("Enqueuing display frame task for activity " + frame.getActivityName() + CsvReader.Letters.POUND + frame.getActivityId() + '.');
        this.v.add(new d(this, frame));
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(ErrorDisplayFrame errorDisplayFrame) {
        Intrinsics.checkNotNullParameter(errorDisplayFrame, "errorDisplayFrame");
        com.microsoft.clarity.n.i.b("Enqueuing error frame task for activity " + errorDisplayFrame.getActivityName() + CsvReader.Letters.POUND + errorDisplayFrame.getActivityId() + '.');
        this.v.add(new e(errorDisplayFrame));
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(WebViewAnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        com.microsoft.clarity.n.i.b("Enqueuing webview analytics task for activity " + event.getWebViewActivityName() + CsvReader.Letters.POUND + event.getWebViewActivityHashCode() + '.');
        this.v.add(new f(event, this));
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(WebViewMutationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        com.microsoft.clarity.n.i.b("Enqueuing webview mutation task for activity " + event.getWebViewActivityName() + CsvReader.Letters.POUND + event.getWebViewActivityHashCode() + '.');
        this.v.add(new g(event, this));
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        com.microsoft.clarity.n.i.b("Enqueuing analytics event " + event.getType() + " task received for activity " + event.getActivityName() + CsvReader.Letters.POUND + event.getActivityId() + '.');
        this.v.add(new c(this, event));
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(String customUserId) {
        Intrinsics.checkNotNullParameter(customUserId, "customUserId");
        this.f862g = customUserId;
    }

    public final void a(final String str, final PayloadMetadata payloadMetadata) {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.q$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                q.a(str, this, payloadMetadata);
            }
        }).start();
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.u.put(key, value);
    }

    public final void b(AnalyticsEvent analyticsEvent) {
        analyticsEvent.setTimestamp(analyticsEvent.getTimestamp() - this.j);
        a(analyticsEvent.getTimestamp(), analyticsEvent.getActivityName(), analyticsEvent.getActivityId());
        PayloadMetadata payloadMetadata = this.l;
        Intrinsics.checkNotNull(payloadMetadata);
        payloadMetadata.updateDuration(analyticsEvent.getTimestamp());
        com.microsoft.clarity.k.b bVar = this.f859d;
        PayloadMetadata payloadMetadata2 = this.l;
        Intrinsics.checkNotNull(payloadMetadata2);
        bVar.a(payloadMetadata2, analyticsEvent);
    }

    @Override // com.microsoft.clarity.f.m
    public final void c() {
        this.f861f.a("Clarity_LowDeviceMemory_WebViewEventQueueSize", this.q.size());
        this.f861f.a("Clarity_LowDeviceMemory_SessionManagerTaskQueueSize", this.v.size());
        this.q.clear();
        this.v.clear();
    }

    public final void c(DisplayFrame frame) {
        Shader shader;
        Intrinsics.checkNotNullParameter(frame, "frame");
        Iterator<T> it = frame.getTypefaces().iterator();
        while (it.hasNext()) {
            a(this, (Typeface) it.next());
        }
        Iterator<T> it2 = frame.getImages().iterator();
        while (it2.hasNext()) {
            a(this, (Image) it2.next());
        }
        for (Paint paint : frame.getPaints()) {
            if (paint.getShader() != null && (paint.getShader() instanceof ImageShader)) {
                shader = paint.getShader();
            } else if (paint.getShader() != null && (paint.getShader() instanceof LocalMatrixShader) && (((LocalMatrixShader) paint.getShader()).getShader() instanceof ImageShader)) {
                shader = ((LocalMatrixShader) paint.getShader()).getShader();
            }
            a(this, ((ImageShader) shader).getImage());
        }
    }

    public final void d() {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.q$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                q.h(this.f$0);
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.microsoft.clarity.models.display.DisplayFrame r32) {
        /*
            Method dump skipped, instruction units count: 1202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.f.q.d(com.microsoft.clarity.models.display.DisplayFrame):void");
    }

    public final boolean e() {
        return this.f863h != null;
    }

    public final boolean f() {
        if (this.m) {
            PayloadMetadata payloadMetadata = this.l;
            Intrinsics.checkNotNull(payloadMetadata);
            boolean z = payloadMetadata.getSequence() <= 100;
            this.m = z;
            if (!z) {
                com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Stopping page tracking as tracking payload sequence limit has been exceeded. PageNum: ").append(this.i).append(" at Timestamp:").append(this.j).toString());
            }
        }
        return !this.m;
    }

    public static final void a(q qVar, String str, byte[] bArr) {
        qVar.getClass();
        com.microsoft.clarity.n.i.b("Received web asset " + str + '.');
        com.microsoft.clarity.k.b bVar = qVar.f859d;
        SessionMetadata sessionMetadata = qVar.f863h;
        Intrinsics.checkNotNull(sessionMetadata);
        bVar.a(sessionMetadata.getSessionId(), str, AssetType.Web, bArr);
    }

    public static final void a(q qVar, BaseWebViewEvent baseWebViewEvent) throws Throwable {
        if (qVar.e()) {
            if (qVar.f()) {
                com.microsoft.clarity.n.i.b("Dropping WebView Event because current page payload count has been exceeded");
                return;
            }
            if (qVar.p.containsKey(Integer.valueOf(baseWebViewEvent.getWebViewHashCode()))) {
                Object obj = qVar.p.get(Integer.valueOf(baseWebViewEvent.getWebViewHashCode()));
                Intrinsics.checkNotNull(obj);
                long jLongValue = ((Number) obj).longValue();
                long absoluteTimestamp = baseWebViewEvent.getAbsoluteTimestamp() - qVar.j;
                if (absoluteTimestamp < 0 || absoluteTimestamp < jLongValue) {
                    baseWebViewEvent.setTimestamp(jLongValue + 1);
                } else {
                    baseWebViewEvent.setTimestamp(absoluteTimestamp);
                }
                qVar.a(baseWebViewEvent);
                return;
            }
            com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Enqueuing web view event ").append(baseWebViewEvent.getData()).append('.').toString());
            qVar.q.add(baseWebViewEvent);
        }
    }

    public final void a(BaseWebViewEvent baseWebViewEvent) throws Throwable {
        com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Appending web view event ").append(baseWebViewEvent.getData()).append('.').toString());
        long absoluteTimestamp = baseWebViewEvent.getAbsoluteTimestamp() - this.j;
        a(absoluteTimestamp, baseWebViewEvent.getWebViewActivityName(), baseWebViewEvent.getWebViewActivityHashCode());
        PayloadMetadata payloadMetadata = this.l;
        Intrinsics.checkNotNull(payloadMetadata);
        payloadMetadata.updateDuration(absoluteTimestamp);
        if (baseWebViewEvent instanceof WebViewMutationEvent) {
            WebViewMutationEvent webViewMutationEvent = (WebViewMutationEvent) baseWebViewEvent;
            this.r.a(webViewMutationEvent);
            com.microsoft.clarity.k.b bVar = this.f859d;
            PayloadMetadata payloadMetadata2 = this.l;
            Intrinsics.checkNotNull(payloadMetadata2);
            bVar.a(payloadMetadata2, webViewMutationEvent);
            return;
        }
        if (baseWebViewEvent instanceof WebViewAnalyticsEvent) {
            com.microsoft.clarity.k.b bVar2 = this.f859d;
            PayloadMetadata payloadMetadata3 = this.l;
            Intrinsics.checkNotNull(payloadMetadata3);
            bVar2.a(payloadMetadata3, (WebViewAnalyticsEvent) baseWebViewEvent);
        }
    }

    public final UUID a(PayloadMetadata payloadMetadata, String str, long j2) {
        if (payloadMetadata.getFallbackWorkerId() != null) {
            WorkManager workManager = WorkManager.getInstance(this.f856a);
            UUID fallbackWorkerId = payloadMetadata.getFallbackWorkerId();
            Intrinsics.checkNotNull(fallbackWorkerId);
            WorkInfo.State state = workManager.getWorkInfoById(fallbackWorkerId).get().getState();
            Intrinsics.checkNotNullExpressionValue(state, "getInstance(context).get…             .get().state");
            if (state != WorkInfo.State.RUNNING && !state.isFinished()) {
                Long fallbackWorkerStartTime = payloadMetadata.getFallbackWorkerStartTime();
                Intrinsics.checkNotNull(fallbackWorkerStartTime);
                if (Math.abs(fallbackWorkerStartTime.longValue() - System.currentTimeMillis()) >= 5000) {
                    WorkManager workManager2 = WorkManager.getInstance(this.f856a);
                    UUID fallbackWorkerId2 = payloadMetadata.getFallbackWorkerId();
                    Intrinsics.checkNotNull(fallbackWorkerId2);
                    workManager2.cancelWorkById(fallbackWorkerId2);
                }
            }
            com.microsoft.clarity.n.i.b("Skipping enqueueing worker with payload " + payloadMetadata + " and delay " + j2);
            return null;
        }
        com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Enqueueing payload upload worker for session ").append(payloadMetadata.getSessionId()).append(", payload ").append(payloadMetadata).append(" and delay ").append(j2).toString());
        Constraints.Builder builder = new Constraints.Builder();
        Boolean UPLOAD_REQUIRES_UNMETERED_NETWORK = com.microsoft.clarity.a.a.f680e;
        Intrinsics.checkNotNullExpressionValue(UPLOAD_REQUIRES_UNMETERED_NETWORK, "UPLOAD_REQUIRES_UNMETERED_NETWORK");
        Constraints.Builder requiredNetworkType = builder.setRequiredNetworkType((!UPLOAD_REQUIRES_UNMETERED_NETWORK.booleanValue() || this.f857b.getAllowMeteredNetworkUsage()) ? NetworkType.CONNECTED : NetworkType.UNMETERED);
        Boolean UPLOAD_REQUIRES_NOT_LOW_BATTERY = com.microsoft.clarity.a.a.f679d;
        Intrinsics.checkNotNullExpressionValue(UPLOAD_REQUIRES_NOT_LOW_BATTERY, "UPLOAD_REQUIRES_NOT_LOW_BATTERY");
        Constraints constraintsBuild = requiredNetworkType.setRequiresBatteryNotLow(UPLOAD_REQUIRES_NOT_LOW_BATTERY.booleanValue()).build();
        OneTimeWorkRequest.Builder builder2 = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) UploadSessionPayloadWorker.class);
        Pair[] pairArr = {TuplesKt.to("PROJECT_ID", this.f857b.getProjectId()), TuplesKt.to("PAYLOAD_METADATA", payloadMetadata.toJson())};
        Data.Builder builder3 = new Data.Builder();
        for (int i2 = 0; i2 < 2; i2++) {
            Pair pair = pairArr[i2];
            builder3.put((String) pair.getFirst(), pair.getSecond());
        }
        Data dataBuild = builder3.build();
        Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
        OneTimeWorkRequest.Builder inputData = builder2.setInputData(dataBuild);
        Duration durationOfMillis = Duration.ofMillis(j2);
        Intrinsics.checkNotNullExpressionValue(durationOfMillis, "ofMillis(initialDelayMs)");
        OneTimeWorkRequest.Builder constraints = inputData.setInitialDelay(durationOfMillis).setConstraints(constraintsBuild);
        String simpleName = Reflection.getOrCreateKotlinClass(UploadSessionPayloadWorker.class).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        OneTimeWorkRequest oneTimeWorkRequestBuild = constraints.addTag(simpleName).addTag(com.microsoft.clarity.a.b.a("ENQUEUED_AT_").append(System.currentTimeMillis()).toString()).build();
        WorkManager.getInstance(this.f856a).beginUniqueWork(str, ExistingWorkPolicy.APPEND_OR_REPLACE, oneTimeWorkRequestBuild).enqueue();
        return oneTimeWorkRequestBuild.getId();
    }

    @Override // com.microsoft.clarity.f.n
    public final String b() {
        SessionMetadata sessionMetadata;
        PageMetadata pageMetadataA = a();
        if (pageMetadataA == null || (sessionMetadata = pageMetadataA.getSessionMetadata()) == null) {
            return null;
        }
        return sessionMetadata.getSessionId();
    }

    public final void a(int i2, long j2, long j3, String str, int i3) {
        PayloadMetadata payloadMetadata;
        Boolean USE_WORKERS = com.microsoft.clarity.a.a.f681f;
        if (!USE_WORKERS.booleanValue() && e() && this.l != null) {
            SessionMetadata sessionMetadata = this.f863h;
            Intrinsics.checkNotNull(sessionMetadata);
            String sessionId = sessionMetadata.getSessionId();
            PayloadMetadata payloadMetadata2 = this.l;
            Intrinsics.checkNotNull(payloadMetadata2);
            a(sessionId, payloadMetadata2);
        }
        Intrinsics.checkNotNullExpressionValue(USE_WORKERS, "USE_WORKERS");
        if (USE_WORKERS.booleanValue() && (payloadMetadata = this.l) != null) {
            Intrinsics.checkNotNull(payloadMetadata);
            PayloadMetadata payloadMetadata3 = this.l;
            Intrinsics.checkNotNull(payloadMetadata3);
            a(payloadMetadata, payloadMetadata3.getSessionId(), 0L);
        }
        SessionMetadata sessionMetadata2 = this.f863h;
        Intrinsics.checkNotNull(sessionMetadata2);
        this.l = new PayloadMetadata(sessionMetadata2.getSessionId(), this.i, i2, j2, null, Long.valueOf(j3), 16, null);
        StringBuilder sbA = com.microsoft.clarity.a.b.a("Starting new payload with sequence ");
        PayloadMetadata payloadMetadata4 = this.l;
        Intrinsics.checkNotNull(payloadMetadata4);
        StringBuilder sbAppend = sbA.append(payloadMetadata4.getSequence()).append(", start ");
        PayloadMetadata payloadMetadata5 = this.l;
        Intrinsics.checkNotNull(payloadMetadata5);
        StringBuilder sbAppend2 = sbAppend.append(payloadMetadata5.getStart()).append(", true start ");
        PayloadMetadata payloadMetadata6 = this.l;
        Intrinsics.checkNotNull(payloadMetadata6);
        StringBuilder sbAppend3 = sbAppend2.append(payloadMetadata6.getStartTimeRelativeToPage()).append(" and max duration ");
        PayloadMetadata payloadMetadata7 = this.l;
        Intrinsics.checkNotNull(payloadMetadata7);
        com.microsoft.clarity.n.i.b(sbAppend3.append(payloadMetadata7.getMaxPayloadDuration()).toString());
        com.microsoft.clarity.k.b bVar = this.f859d;
        SessionMetadata sessionMetadata3 = this.f863h;
        Intrinsics.checkNotNull(sessionMetadata3);
        String sessionId2 = sessionMetadata3.getSessionId();
        PayloadMetadata payloadMetadata8 = this.l;
        Intrinsics.checkNotNull(payloadMetadata8);
        bVar.a(sessionId2, payloadMetadata8);
        long j4 = j2 + this.j;
        Visibility visibility = this.t;
        b(new BaselineEvent(j4, str, i3, Intrinsics.areEqual(visibility != null ? visibility.getState() : null, "visible")));
        Intrinsics.checkNotNullExpressionValue(USE_WORKERS, "USE_WORKERS");
        if (USE_WORKERS.booleanValue()) {
            PayloadMetadata payloadMetadata9 = this.l;
            Intrinsics.checkNotNull(payloadMetadata9);
            PayloadMetadata payloadMetadata10 = this.l;
            Intrinsics.checkNotNull(payloadMetadata10);
            int maxPayloadDuration = payloadMetadata10.getMaxPayloadDuration() + NetworkRepo.MAX_DELAY_FREQUENCY;
            StringBuilder sb = new StringBuilder();
            PayloadMetadata payloadMetadata11 = this.l;
            Intrinsics.checkNotNull(payloadMetadata11);
            StringBuilder sbAppend4 = sb.append(payloadMetadata11.getSessionId()).append('_');
            PayloadMetadata payloadMetadata12 = this.l;
            Intrinsics.checkNotNull(payloadMetadata12);
            StringBuilder sbAppend5 = sbAppend4.append(payloadMetadata12.getPageNum()).append('_');
            PayloadMetadata payloadMetadata13 = this.l;
            Intrinsics.checkNotNull(payloadMetadata13);
            String string = sbAppend5.append(payloadMetadata13.getSequence()).append("_fallback").toString();
            PayloadMetadata payloadMetadata14 = this.l;
            Intrinsics.checkNotNull(payloadMetadata14);
            long j5 = maxPayloadDuration;
            payloadMetadata14.setFallbackWorkerStartTime(Long.valueOf(System.currentTimeMillis() + j5));
            PayloadMetadata payloadMetadata15 = this.l;
            Intrinsics.checkNotNull(payloadMetadata15);
            payloadMetadata15.setFallbackWorkerId(a(payloadMetadata9, string, j5));
        }
    }

    public final void a(long j2, String str, int i2) {
        PayloadMetadata payloadMetadata = this.l;
        Intrinsics.checkNotNull(payloadMetadata);
        Long startTimeRelativeToPage = payloadMetadata.getStartTimeRelativeToPage();
        Intrinsics.checkNotNull(startTimeRelativeToPage);
        long jLongValue = j2 - startTimeRelativeToPage.longValue();
        Intrinsics.checkNotNull(this.l);
        if (jLongValue > r2.getMaxPayloadDuration()) {
            PayloadMetadata payloadMetadata2 = this.l;
            Intrinsics.checkNotNull(payloadMetadata2);
            int sequence = payloadMetadata2.getSequence() + 1;
            PayloadMetadata payloadMetadata3 = this.l;
            Intrinsics.checkNotNull(payloadMetadata3);
            long start = payloadMetadata3.getStart();
            PayloadMetadata payloadMetadata4 = this.l;
            Intrinsics.checkNotNull(payloadMetadata4);
            Long duration = payloadMetadata4.getDuration();
            Intrinsics.checkNotNull(duration);
            a(sequence, duration.longValue() + start, j2, str, i2);
        }
    }
}
