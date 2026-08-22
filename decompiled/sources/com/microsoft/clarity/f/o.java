package com.microsoft.clarity.f;

import android.content.Context;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.display.common.Asset;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.ingest.analytics.Resize;
import com.microsoft.clarity.models.ingest.mutation.MutationErrorEvent;
import com.microsoft.clarity.models.ingest.mutation.MutationEvent;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.models.viewhierarchy.WebViewData;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClarityConfig f845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.microsoft.clarity.l.b f846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.microsoft.clarity.e.e f847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DisplayFrame f851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f852h;
    public final com.microsoft.clarity.e.h i;

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnalyticsEvent f853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f854b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AnalyticsEvent analyticsEvent, o oVar) {
            super(0);
            this.f853a = analyticsEvent;
            this.f854b = oVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AnalyticsEvent analyticsEvent = this.f853a;
            analyticsEvent.setTimestamp(analyticsEvent.getTimestamp() - this.f854b.f848d);
            this.f854b.f846b.a(this.f853a, com.microsoft.clarity.l.e.Analytics);
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
            o.this.f847c.a(it, ErrorType.LiveModeEventProcessing, (PageMetadata) null);
            return Unit.INSTANCE;
        }
    }

    public o(Context context, ClarityConfig config, com.microsoft.clarity.l.f livePlayerService, com.microsoft.clarity.e.e telemetryTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(livePlayerService, "livePlayerService");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        this.f845a = config;
        this.f846b = livePlayerService;
        this.f847c = telemetryTracker;
        this.f852h = new LinkedHashMap();
        this.i = new com.microsoft.clarity.e.h(context, config, new p(this));
    }

    public static final void a(o this$0, WebViewAnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.f846b.a(event.getData(), com.microsoft.clarity.l.e.Analytics);
    }

    public static final void a(o this$0, WebViewMutationEvent event) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.i.a(event);
        this$0.f846b.a(event.getData(), com.microsoft.clarity.l.e.Playback);
    }

    public static final void a(DisplayFrame frame, o this$0) {
        boolean z;
        Intrinsics.checkNotNullParameter(frame, "$frame");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List listPlus = CollectionsKt.plus((Collection) frame.getImages(), (Iterable) frame.getTypefaces());
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listPlus) {
                String dataHash = ((Asset) obj).getDataHash();
                if (dataHash != null && dataHash.length() != 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (Object obj2 : arrayList) {
                com.microsoft.clarity.l.b bVar = this$0.f846b;
                String dataHash2 = ((Asset) obj2).getDataHash();
                Intrinsics.checkNotNull(dataHash2);
                AssetType type = ((Asset) obj2).getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                byte[] data = ((Asset) obj2).getData();
                Intrinsics.checkNotNullExpressionValue(data, "it.data");
                arrayList2.add(Boolean.valueOf(bVar.a(type, data, dataHash2)));
            }
            Iterator it = arrayList2.iterator();
            loop2: while (true) {
                while (it.hasNext()) {
                    z = z && ((Boolean) it.next()).booleanValue();
                }
            }
            if (z) {
                return;
            }
            com.microsoft.clarity.n.i.c(arrayList2.toString());
        } catch (Exception e2) {
            this$0.f847c.a(e2, ErrorType.LiveModeUploadAssets, (PageMetadata) null);
        }
    }

    public static final void a(AnalyticsEvent event, o this$0) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.microsoft.clarity.n.e.a(new a(event, this$0), this$0.new b(), (o.c) null, 10);
    }

    public static final void b(o this$0, String path, byte[] content) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(content, "$content");
        this$0.f846b.a(this$0.f845a.getProjectId() + "/*clarity-playback-token-placeholder*/0/" + path, content);
    }

    public static final void b(DisplayFrame frame, o this$0) {
        Intrinsics.checkNotNullParameter(frame, "$frame");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        byte[] byteArray = frame.toProtobufInstance().toByteArray();
        com.microsoft.clarity.l.b bVar = this$0.f846b;
        long timestamp = frame.getTimestamp();
        String strEncodeToString = Base64.getEncoder().encodeToString(byteArray);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "getEncoder().encodeToString(data)");
        bVar.a(new MutationEvent(timestamp, true, strEncodeToString), com.microsoft.clarity.l.e.Playback);
    }

    @Override // com.microsoft.clarity.f.n
    public final PageMetadata a() {
        return null;
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(DisplayFrame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        com.microsoft.clarity.n.i.b("New frame received");
        long j = 10;
        this.f848d = frame.getTimestamp() - j;
        DisplayFrame displayFrame = this.f851g;
        if (displayFrame == null || frame.getActivityId() != displayFrame.getActivityId()) {
            this.f848d = frame.getTimestamp() - j;
        }
        if (this.f849e != frame.getScreenWidth() || this.f850f != frame.getScreenHeight()) {
            this.f846b.a(new Resize(0L, "", 0, frame.getScreenWidth(), frame.getScreenHeight()), com.microsoft.clarity.l.e.Analytics);
            this.f849e = frame.getScreenWidth();
            this.f850f = frame.getScreenHeight();
        }
        b(frame);
        frame.setTimestamp(frame.getTimestamp() - this.f848d);
        c(frame);
        ViewHierarchy viewHierarchy = frame.getViewHierarchy();
        Intrinsics.checkNotNull(viewHierarchy);
        for (WebViewData webViewData : viewHierarchy.getWebViewsData()) {
            if (webViewData.getFoundInDisplayList() && !this.f852h.containsKey(Integer.valueOf(webViewData.getHashCode()))) {
                com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Registering webview #").append(webViewData.getHashCode()).append(" load time to ").append(frame.getTimestamp()).append('.').toString());
                this.f852h.put(Integer.valueOf(webViewData.getHashCode()), Long.valueOf(frame.getTimestamp()));
            }
        }
        this.f851g = frame;
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(ErrorDisplayFrame errorDisplayFrame) {
        Intrinsics.checkNotNullParameter(errorDisplayFrame, "errorDisplayFrame");
        this.f846b.a(new MutationErrorEvent(errorDisplayFrame.getAbsoluteTimestamp() - this.f848d, "FrameProcessingError"), com.microsoft.clarity.l.e.Playback);
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(final WebViewAnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.o$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                o.a(this.f$0, event);
            }
        }).start();
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(final WebViewMutationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.o$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                o.a(this.f$0, event);
            }
        }).start();
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(final AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.o$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                o.a(event, this);
            }
        }).start();
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(String customUserId) {
        Intrinsics.checkNotNullParameter(customUserId, "customUserId");
    }

    @Override // com.microsoft.clarity.f.m
    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public final void a(final String str, final byte[] bArr) {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.o$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                o.b(this.f$0, str, bArr);
            }
        }).start();
    }

    @Override // com.microsoft.clarity.f.n
    public final String b() {
        return null;
    }

    public final void b(final DisplayFrame displayFrame) {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.o$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                o.a(displayFrame, this);
            }
        }).start();
    }

    @Override // com.microsoft.clarity.f.m
    public final void c() {
    }

    public final void c(final DisplayFrame displayFrame) {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.o$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                o.b(displayFrame, this);
            }
        }).start();
    }
}
