package com.microsoft.clarity.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.csvreader.CsvReader;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.h.e;
import com.microsoft.clarity.i.s;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.ingest.WebViewAnalyticsEvent;
import com.microsoft.clarity.models.ingest.WebViewMutationEvent;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.ingest.analytics.Click;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.observers.ObservedEvent;
import com.microsoft.clarity.models.observers.SerializedWebViewEvent;
import com.microsoft.clarity.models.observers.UserInteraction;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.models.viewhierarchy.ViewNode;
import com.microsoft.clarity.models.viewhierarchy.WebViewData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements l, com.microsoft.clarity.h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.g.g f818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.microsoft.clarity.g.f f819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.microsoft.clarity.g.i f820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.microsoft.clarity.g.j f821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.microsoft.clarity.e.e f822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<com.microsoft.clarity.h.a> f823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedBlockingQueue<ObservedEvent> f824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.microsoft.clarity.e.c f825h;
    public ViewHierarchy i;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewNode f826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f829d;

        public a(ViewNode node, int i, boolean z) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.f826a = node;
            this.f827b = z;
            this.f828c = new ArrayList();
            this.f829d = node.getWidth() * node.getHeight();
            a(node.getType(), node.getId(), i);
        }

        public final int a() {
            return this.f829d;
        }

        public final void a(String type, int i, int i2) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (i != -1) {
                this.f828c.add(0, MqttTopic.TOPIC_LEVEL_SEPARATOR + type + CsvReader.Letters.POUND + i + '[' + i2 + ']');
            } else {
                this.f828c.add(0, MqttTopic.TOPIC_LEVEL_SEPARATOR + type + '[' + i2 + ']');
            }
        }

        public final String b() {
            return CollectionsKt.joinToString$default(this.f828c, "", null, null, 0, null, null, 62, null);
        }

        public final boolean c() {
            return this.f827b;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ErrorType> f831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<FramePicture> f832c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.ObjectRef<ErrorType> objectRef, Ref.ObjectRef<FramePicture> objectRef2) {
            super(0);
            this.f831b = objectRef;
            this.f832c = objectRef2;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.microsoft.clarity.models.observers.ObservedEvent, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v5, types: [T, com.microsoft.clarity.models.telemetry.ErrorType] */
        /* JADX WARN: Type inference failed for: r3v0, types: [T, com.microsoft.clarity.models.telemetry.ErrorType] */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ?? event = (ObservedEvent) e.this.f824g.take();
            com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Queue size: ").append(e.this.f824g.size()).append('.').toString());
            if (event instanceof FramePicture) {
                this.f831b.element = ErrorType.PictureProcessing;
                Ref.ObjectRef<FramePicture> objectRef = this.f832c;
                Intrinsics.checkNotNullExpressionValue(event, "event");
                objectRef.element = event;
                FramePicture framePicture = (FramePicture) event;
                DisplayFrame displayFrameA = e.this.f825h.a(framePicture);
                if (displayFrameA != null) {
                    e.a(e.this, displayFrameA);
                }
                e.this.i = framePicture.getViewHierarchy();
            } else if (event instanceof UserInteraction) {
                this.f831b.element = ErrorType.UserInteractionProcessing;
                e.a(e.this, ((UserInteraction) event).getAnalyticsEvent());
            } else if (event instanceof SerializedWebViewEvent) {
                e eVar = e.this;
                Intrinsics.checkNotNullExpressionValue(event, "event");
                e.a(eVar, (SerializedWebViewEvent) event);
            } else if (event instanceof ErrorDisplayFrame) {
                e eVar2 = e.this;
                Intrinsics.checkNotNullExpressionValue(event, "event");
                e.a(eVar2, (ErrorDisplayFrame) event);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Exception, Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ErrorType> f834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<FramePicture> f835c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Ref.ObjectRef<ErrorType> objectRef, Ref.ObjectRef<FramePicture> objectRef2) {
            super(1);
            this.f834b = objectRef;
            this.f835c = objectRef2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            e.a(e.this, it, this.f834b.element);
            FramePicture framePicture = this.f835c.element;
            if (framePicture != null) {
                e eVar = e.this;
                long absoluteTimestamp = framePicture.getAbsoluteTimestamp();
                String activityName = framePicture.getActivityName();
                int activityId = framePicture.getActivityId();
                String message = it.getMessage();
                if (message == null) {
                    message = "";
                }
                e.a(eVar, new ErrorDisplayFrame(absoluteTimestamp, activityName, activityId, message));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((a) t).a()), Integer.valueOf(((a) t2).a()));
        }
    }

    /* JADX INFO: renamed from: com.microsoft.clarity.f.e$e, reason: collision with other inner class name */
    public static final class C0188e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((a) t).a()), Integer.valueOf(((a) t2).a()));
        }
    }

    public e(Context context, ClarityConfig config, DynamicConfig dynamicConfig, s skiaParserFactory, com.microsoft.clarity.g.g lifecycleObserver, com.microsoft.clarity.g.b displayFrameObserver, com.microsoft.clarity.g.l userInteractionObserver, com.microsoft.clarity.g.a crashObserver, com.microsoft.clarity.g.o oVar, com.microsoft.clarity.e.e telemetryTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        Intrinsics.checkNotNullParameter(skiaParserFactory, "skiaParserFactory");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(displayFrameObserver, "displayFrameObserver");
        Intrinsics.checkNotNullParameter(userInteractionObserver, "userInteractionObserver");
        Intrinsics.checkNotNullParameter(crashObserver, "crashObserver");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        this.f818a = lifecycleObserver;
        this.f819b = displayFrameObserver;
        this.f820c = userInteractionObserver;
        this.f821d = oVar;
        this.f822e = telemetryTracker;
        lifecycleObserver.a(this);
        displayFrameObserver.a(new com.microsoft.clarity.f.a(this));
        userInteractionObserver.a(new com.microsoft.clarity.f.b(this));
        if (oVar != null) {
            oVar.a(new com.microsoft.clarity.f.c(this));
        }
        crashObserver.a(new com.microsoft.clarity.f.d(this));
        this.f823f = new ArrayList<>();
        this.f824g = new LinkedBlockingQueue<>();
        this.f825h = new com.microsoft.clarity.e.c(context, dynamicConfig.getMaskingMode(), skiaParserFactory, new f(this));
        b();
    }

    public static a a(ViewNode viewNode, Click click, int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (ViewNode viewNode2 : CollectionsKt.reversed(viewNode.getChildren())) {
            Pair pair = new Pair(viewNode2.getType(), Integer.valueOf(viewNode2.getId()));
            Object obj = linkedHashMap.get(pair);
            if (obj == null) {
                obj = 0;
                linkedHashMap.put(pair, obj);
            }
            int iIntValue = ((Number) obj).intValue();
            if (click.getAbsX() >= viewNode2.getX()) {
                if (click.getAbsX() <= viewNode2.getWidth() + viewNode2.getX() && click.getAbsY() >= viewNode2.getY()) {
                    if (click.getAbsY() <= viewNode2.getHeight() + viewNode2.getY()) {
                        a aVarA = a(viewNode2, click, iIntValue);
                        aVarA.a(viewNode.getType(), viewNode.getId(), i);
                        arrayList.add(aVarA);
                    }
                }
            }
            Object obj2 = linkedHashMap.get(pair);
            Intrinsics.checkNotNull(obj2);
            linkedHashMap.put(pair, Integer.valueOf(((Number) obj2).intValue() + 1));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (((a) obj3).c()) {
                arrayList2.add(obj3);
            }
        }
        a aVar = (a) CollectionsKt.minWithOrNull(arrayList2, new d());
        if (aVar != null) {
            return aVar;
        }
        if (viewNode.getClickable() || arrayList.isEmpty()) {
            return new a(viewNode, i, viewNode.getClickable());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj4 : arrayList) {
            if (!((a) obj4).c()) {
                arrayList3.add(obj4);
            }
        }
        Object objMinWithOrNull = CollectionsKt.minWithOrNull(arrayList3, new C0188e());
        Intrinsics.checkNotNull(objMinWithOrNull);
        return (a) objMinWithOrNull;
    }

    public static final void a(e eVar, AnalyticsEvent analyticsEvent) {
        eVar.getClass();
        if (analyticsEvent instanceof Click) {
            Click click = (Click) analyticsEvent;
            try {
                ViewHierarchy viewHierarchy = eVar.i;
                if (viewHierarchy == null) {
                    com.microsoft.clarity.n.i.e("Null view hierarchy for click correlation (" + click.serialize() + ").");
                } else {
                    a aVarA = a(viewHierarchy.getRoot(), click, 0);
                    if (aVarA.f826a.getIgnoreClicks()) {
                        com.microsoft.clarity.n.i.b("Click event has been ignored (" + click.serialize() + ").");
                        return;
                    }
                    click.setViewId(aVarA.f826a.getId());
                    click.setNodeSelector(aVarA.b());
                    click.setText(a(aVarA.f826a));
                    click.setReaction(!aVarA.f827b);
                    float absX = click.getAbsX();
                    float x = aVarA.f826a.getX();
                    float width = aVarA.f826a.getWidth();
                    Float fValueOf = Float.valueOf(0.0f);
                    float f2 = (absX - x) / width;
                    float f3 = 32767;
                    float fFloor = (float) Math.floor(f2 * f3);
                    if (fValueOf != null) {
                        fFloor = Math.max(fFloor, fValueOf.floatValue());
                    }
                    click.setRelativeX((int) fFloor);
                    float absY = click.getAbsY();
                    float y = aVarA.f826a.getY();
                    float height = aVarA.f826a.getHeight();
                    Float fValueOf2 = Float.valueOf(0.0f);
                    float fFloor2 = (float) Math.floor(((absY - y) / height) * f3);
                    if (fValueOf2 != null) {
                        fFloor2 = Math.max(fFloor2, fValueOf2.floatValue());
                    }
                    click.setRelativeY((int) fFloor2);
                    com.microsoft.clarity.n.i.b("Click event has been correlated (" + click.serialize() + ").");
                }
            } catch (Exception e2) {
                ErrorType errorType = ErrorType.ViewHierarchyClickCorrelation;
                Iterator<com.microsoft.clarity.h.a> it = eVar.f823f.iterator();
                while (it.hasNext()) {
                    it.next().a(e2, errorType);
                }
            }
        }
        Iterator<com.microsoft.clarity.h.a> it2 = eVar.f823f.iterator();
        while (it2.hasNext()) {
            it2.next().b(analyticsEvent);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.microsoft.clarity.models.telemetry.ErrorType] */
    public static final void c(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        while (true) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = ErrorType.EventProcessing;
            com.microsoft.clarity.n.e.a(this$0.new b(objectRef2, objectRef), this$0.new c(objectRef2, objectRef), (o.c) null, 10);
        }
    }

    @Override // com.microsoft.clarity.f.l
    public final void a() {
        this.f819b.a();
        this.f820c.a();
        com.microsoft.clarity.g.j jVar = this.f821d;
        if (jVar != null) {
            jVar.a();
        }
        com.microsoft.clarity.n.i.d("Capturing events is resumed!");
    }

    @Override // com.microsoft.clarity.f.l
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f819b.a(view);
    }

    public final void a(g callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        com.microsoft.clarity.n.i.b("Register a callback.");
        this.f823f.add(callbacks);
    }

    @Override // com.microsoft.clarity.h.e, com.microsoft.clarity.h.d
    public final void a(Exception exc, ErrorType errorType) {
        e.a.a(exc, errorType);
    }

    @Override // com.microsoft.clarity.f.l
    public final void a(String str) {
        this.f819b.a(str);
    }

    @Override // com.microsoft.clarity.f.l
    public final void a(String reasonMetric, boolean z) {
        Intrinsics.checkNotNullParameter(reasonMetric, "reasonMetric");
        int size = this.f824g.size();
        this.f819b.c();
        this.f820c.c();
        com.microsoft.clarity.g.j jVar = this.f821d;
        if (jVar != null) {
            jVar.c();
        }
        if (z) {
            this.f824g.clear();
        }
        com.microsoft.clarity.n.i.e("Capturing events is paused!");
        this.f822e.a(reasonMetric, size);
    }

    public final void b() {
        new Thread(new Runnable() { // from class: com.microsoft.clarity.f.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                e.c(this.f$0);
            }
        }).start();
    }

    @Override // com.microsoft.clarity.f.l
    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f819b.b(view);
    }

    @Override // com.microsoft.clarity.f.l
    public final void b(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (this.f818a.b()) {
            WeakReference<Activity> weakReferenceF = this.f818a.f();
            Activity activity = weakReferenceF != null ? weakReferenceF.get() : null;
            LinkedBlockingQueue<ObservedEvent> linkedBlockingQueue = this.f824g;
            long jCurrentTimeMillis = System.currentTimeMillis();
            String simpleName = activity != null ? activity.getClass().getSimpleName() : null;
            if (simpleName == null) {
                simpleName = "";
            }
            linkedBlockingQueue.add(new ErrorDisplayFrame(jCurrentTimeMillis, simpleName, activity != null ? activity.hashCode() : 0, reason));
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

    public static final void a(e eVar, DisplayFrame displayFrame) {
        Iterator<com.microsoft.clarity.h.a> it = eVar.f823f.iterator();
        while (it.hasNext()) {
            it.next().a(displayFrame);
        }
    }

    public static final void a(e eVar, Exception exc, ErrorType errorType) {
        Iterator<com.microsoft.clarity.h.a> it = eVar.f823f.iterator();
        while (it.hasNext()) {
            it.next().a(exc, errorType);
        }
    }

    public static final void a(e eVar, ErrorDisplayFrame errorDisplayFrame) {
        Iterator<com.microsoft.clarity.h.a> it = eVar.f823f.iterator();
        while (it.hasNext()) {
            it.next().a(errorDisplayFrame);
        }
    }

    public static final void a(e eVar, FramePicture framePicture) {
        com.microsoft.clarity.g.j jVar;
        com.microsoft.clarity.g.j jVar2;
        com.microsoft.clarity.g.j jVar3;
        eVar.f824g.add(framePicture);
        List<WebViewData> webViewsData = framePicture.getViewHierarchy().getWebViewsData();
        ArrayList arrayList = new ArrayList();
        for (Object obj : webViewsData) {
            if (((WebViewData) obj).getMasked()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WebView webView = ((WebViewData) it.next()).getWebView().get();
            if (webView != null && (jVar3 = eVar.f821d) != null) {
                jVar3.b(webView);
            }
        }
        List<WebViewData> webViewsData2 = framePicture.getViewHierarchy().getWebViewsData();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : webViewsData2) {
            if (!((WebViewData) obj2).getMasked()) {
                arrayList2.add(obj2);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            WebView webView2 = ((WebViewData) it2.next()).getWebView().get();
            if (webView2 != null && (jVar2 = eVar.f821d) != null) {
                jVar2.a(webView2);
            }
        }
        Iterator<WebViewData> it3 = framePicture.getViewHierarchy().getWebViewsData().iterator();
        while (it3.hasNext()) {
            WebView webView3 = it3.next().getWebView().get();
            if (webView3 != null && (jVar = eVar.f821d) != null) {
                jVar.a(webView3, framePicture.getActivityId(), framePicture.getActivityName());
            }
        }
    }

    public static final void a(e eVar, SerializedWebViewEvent serializedWebViewEvent) {
        eVar.getClass();
        if (serializedWebViewEvent.isAnalyticsEvent()) {
            WebViewAnalyticsEvent webViewAnalyticsEvent = new WebViewAnalyticsEvent(serializedWebViewEvent.getWebViewHashCode(), serializedWebViewEvent.getData(), serializedWebViewEvent.getAbsoluteTimestamp(), serializedWebViewEvent.getActivityName(), serializedWebViewEvent.getActivityHashCode(), serializedWebViewEvent.getType());
            ArrayList<com.microsoft.clarity.h.a> arrayList = eVar.f823f;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator<com.microsoft.clarity.h.a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(webViewAnalyticsEvent);
                arrayList2.add(Unit.INSTANCE);
            }
            return;
        }
        WebViewMutationEvent webViewMutationEvent = new WebViewMutationEvent(serializedWebViewEvent.getWebViewHashCode(), serializedWebViewEvent.getData(), serializedWebViewEvent.getAbsoluteTimestamp(), serializedWebViewEvent.getActivityName(), serializedWebViewEvent.getActivityHashCode(), serializedWebViewEvent.getType(), serializedWebViewEvent.getPageUrl());
        ArrayList<com.microsoft.clarity.h.a> arrayList3 = eVar.f823f;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator<com.microsoft.clarity.h.a> it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            it2.next().a(webViewMutationEvent);
            arrayList4.add(Unit.INSTANCE);
        }
    }

    public static String a(ViewNode viewNode) {
        if (StringsKt.isBlank(viewNode.getText())) {
            return "";
        }
        String strA = com.microsoft.clarity.n.k.a(viewNode.getText());
        if (StringsKt.isBlank(strA)) {
            return strA;
        }
        if (!viewNode.getIsMasked()) {
            for (int i = 0; i < strA.length(); i++) {
                char cCharAt = strA.charAt(i);
                if (!Character.isDigit(cCharAt) && cCharAt != '@') {
                }
            }
            return strA;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) strA, new String[]{" "}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((String) it.next()).length()));
        }
        String strRepeat = StringsKt.repeat("*", (int) CollectionsKt.averageOfInt(arrayList));
        int size = listSplit$default.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(strRepeat);
        }
        return CollectionsKt.joinToString$default(arrayList2, " ", null, null, 0, null, null, 62, null);
    }
}
