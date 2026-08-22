package com.microsoft.clarity.g;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.csvreader.CsvReader;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.h.e;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements j, com.microsoft.clarity.h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClarityConfig f998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DynamicConfig f999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f1000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f1001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f1002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f1003g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f1004h;
    public final LinkedHashSet i;
    public final LinkedHashSet j;
    public final LinkedHashSet k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public boolean q;

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f1005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f1006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f1007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f1008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f1009e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(WebView webView, o oVar, int i, String str, String str2) {
            super(0);
            this.f1005a = webView;
            this.f1006b = oVar;
            this.f1007c = i;
            this.f1008d = str;
            this.f1009e = str2;
        }

        public static final void a(WebView webView, String startScript, String str) {
            Intrinsics.checkNotNullParameter(webView, "$webView");
            Intrinsics.checkNotNullParameter(startScript, "$startScript");
            webView.evaluateJavascript(startScript, null);
        }

        public final void a() {
            int[] iArr_values = n._values();
            String result = this.f1009e;
            for (int i : iArr_values) {
                int iA = com.microsoft.clarity.e.g.a(i);
                Intrinsics.checkNotNullExpressionValue(result, "result");
                if (iA == Integer.parseInt(StringsKt.trim(result, '\"'))) {
                    if (i == 4) {
                        com.microsoft.clarity.n.i.b("Clarity is active.");
                        return;
                    }
                    if (this.f1005a.getUrl() == null) {
                        com.microsoft.clarity.n.i.b("WebView url is null.");
                        return;
                    }
                    o oVar = this.f1006b;
                    List<String> allowedDomains = oVar.f998b.getAllowedDomains();
                    String url = this.f1005a.getUrl();
                    Intrinsics.checkNotNull(url);
                    if (!o.a(oVar, allowedDomains, url)) {
                        com.microsoft.clarity.n.i.b("WebView domain is not allowed.");
                        return;
                    }
                    int iA2 = com.microsoft.clarity.e.g.a(i);
                    if (iA2 != 0) {
                        if (iA2 != 2) {
                            com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("ClarityJs state ").append(n.a(i)).append('.').toString());
                            return;
                        }
                        com.microsoft.clarity.n.i.b("Sending port.");
                        o.a(this.f1007c, this.f1005a, this.f1006b, this.f1008d);
                        return;
                    }
                    com.microsoft.clarity.n.i.b("Injecting Clarity.");
                    final String strReplace$default = StringsKt.replace$default(this.f1006b.n, this.f1006b.m, o.a(this.f1005a, this.f1006b), false, 4, (Object) null);
                    WebView webView = this.f1005a;
                    String str = this.f1006b.l;
                    final WebView webView2 = this.f1005a;
                    webView.evaluateJavascript(str, new ValueCallback() { // from class: com.microsoft.clarity.g.o$a$$ExternalSyntheticLambda0
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(Object obj) {
                            o.a.a(webView2, strReplace$default, (String) obj);
                        }
                    });
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f1010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WebView f1011b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebView webView, o oVar) {
            super(1);
            this.f1010a = oVar;
            this.f1011b = webView;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            o.a(this.f1010a, it, ErrorType.ClarityJsInjection);
            this.f1010a.k.add(new WeakReference(this.f1011b));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f1012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WebView f1013b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WebView webView, o oVar) {
            super(0);
            this.f1012a = oVar;
            this.f1013b = webView;
        }

        public static final boolean a(WebView webView, WeakReference it) {
            Intrinsics.checkNotNullParameter(webView, "$webView");
            Intrinsics.checkNotNullParameter(it, "it");
            return Intrinsics.areEqual(it.get(), webView);
        }

        public final void a() {
            ArrayList arrayList = this.f1012a.f1001e;
            final WebView webView = this.f1013b;
            arrayList.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.o$c$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return o.c.a(webView, (WeakReference) obj);
                }
            });
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public o(Context context, g lifecycleObserver, ClarityConfig config, DynamicConfig dynamicConfig) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        this.f997a = lifecycleObserver;
        this.f998b = config;
        this.f999c = dynamicConfig;
        this.f1000d = new ArrayList();
        this.f1001e = new ArrayList();
        this.f1002f = new ArrayList();
        this.f1003g = new LinkedHashMap();
        this.f1004h = new ArrayList();
        this.i = new LinkedHashSet();
        this.j = new LinkedHashSet();
        this.k = new LinkedHashSet();
        InputStream inputStreamOpen = context.getAssets().open("clarity.js");
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "context.assets\n        .open(\"clarity.js\")");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            this.l = text;
            this.m = "[[START_PARAMS]]";
            this.n = "startClarity([[START_PARAMS]]);";
            this.o = "clearClarity();";
            this.p = "(function() {if(typeof window[\"clarityhybrid\"] === \"undefined\") return \"0\";else return window[\"clarityhybrid\"](\"state\");})();";
            lifecycleObserver.a(this);
        } finally {
        }
    }

    public static final String a(WebView webView, o oVar) {
        String string;
        oVar.getClass();
        StringBuilder sbAppend = new StringBuilder().append(webView.getId()).append(CsvReader.Letters.COMMA).append(webView.getUniqueDrawingId()).append(",\"");
        String string2 = new JSONArray((Collection) oVar.f999c.getWebMaskSelectors()).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "JSONArray(set).toString()");
        StringBuilder sbAppend2 = sbAppend.append(com.microsoft.clarity.n.k.a(string2)).append("\",\"");
        if (oVar.f999c.getMaskingMode() != MaskingMode.Relaxed || oVar.f999c.getWebUnmaskSelectors().contains("body") || oVar.c(webView)) {
            string = new JSONArray((Collection) oVar.f999c.getWebUnmaskSelectors()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(set).toString()");
        } else {
            string = new JSONArray((Collection) SetsKt.plus(oVar.f999c.getWebUnmaskSelectors(), "body")).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(set).toString()");
        }
        return sbAppend2.append(com.microsoft.clarity.n.k.a(string)).append("\",").append(!oVar.c(webView)).toString();
    }

    public static final void a(WebView webView, o this$0, int i, String activityName, String str) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activityName, "$activityName");
        com.microsoft.clarity.n.e.a(new a(webView, this$0, i, activityName, str), new b(webView, this$0), new c(webView, this$0), 2);
    }

    public static final boolean a(WebView webView, WeakReference it) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.get(), webView);
    }

    public static final void b(WebView it, o this$0) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.evaluateJavascript(this$0.o, null);
    }

    public static final boolean b(WebView webView, WeakReference it) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.get(), webView);
    }

    public static final void c(WebView it, o this$0) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.evaluateJavascript(this$0.o, null);
    }

    public static final boolean c(WebView webView, WeakReference it) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.get(), webView);
    }

    @Override // com.microsoft.clarity.g.h
    public final void a() {
        this.q = false;
    }

    @Override // com.microsoft.clarity.h.e, com.microsoft.clarity.h.d
    public final void a(Exception exc, ErrorType errorType) {
        e.a.a(exc, errorType);
    }

    @Override // com.microsoft.clarity.g.j
    public final void b(final WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (c(webView)) {
            return;
        }
        WeakReference weakReference = new WeakReference(webView);
        this.j.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.o$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return o.a(webView, (WeakReference) obj);
            }
        });
        this.i.add(weakReference);
        if (d(webView)) {
            this.f1004h.add(weakReference);
        }
    }

    public final void b(final WebView webView, final int i, final String str) {
        ArrayList arrayList = this.f1001e;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), webView)) {
                    return;
                }
            }
        }
        this.f1001e.add(new WeakReference(webView));
        webView.evaluateJavascript(this.p, new ValueCallback() { // from class: com.microsoft.clarity.g.o$$ExternalSyntheticLambda2
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                o.a(webView, this, i, str, (String) obj);
            }
        });
    }

    @Override // com.microsoft.clarity.g.h
    public final void c() {
        this.q = true;
        Iterator it = this.f1002f.iterator();
        while (it.hasNext()) {
            final WebView webView = (WebView) ((WeakReference) ((Pair) it.next()).getFirst()).get();
            if (webView != null) {
                webView.post(new Runnable() { // from class: com.microsoft.clarity.g.o$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.c(webView, this);
                    }
                });
            }
        }
        this.f1002f.clear();
    }

    public final void c(final WebView webView, int i, String str) {
        com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Restarting Clarity JS for webview #").append(webView.getUniqueDrawingId()).append('.').toString());
        webView.evaluateJavascript(this.o, null);
        b(webView, i, str);
        this.f1004h.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.o$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return o.b(webView, (WeakReference) obj);
            }
        });
    }

    public final boolean c(WebView webView) {
        LinkedHashSet linkedHashSet = this.i;
        if ((linkedHashSet instanceof Collection) && linkedHashSet.isEmpty()) {
            return false;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((WeakReference) it.next()).get(), webView)) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(WebView webView) {
        ArrayList arrayList = this.f1002f;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((WeakReference) ((Pair) it.next()).getFirst()).get(), webView)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityDestroyed(Activity activity) {
        e.a.a(activity);
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ArrayList arrayList = this.f1002f;
        ArrayList<Pair> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Number) ((Pair) obj).getSecond()).intValue() == activity.hashCode()) {
                arrayList2.add(obj);
            }
        }
        for (Pair pair : arrayList2) {
            final WebView webView = (WebView) ((WeakReference) pair.getFirst()).get();
            if (webView != null) {
                webView.post(new Runnable() { // from class: com.microsoft.clarity.g.o$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.b(webView, this);
                    }
                });
            }
            this.f1002f.remove(pair);
            StringBuilder sb = new StringBuilder("Webview ");
            WebView webView2 = (WebView) ((WeakReference) pair.getFirst()).get();
            com.microsoft.clarity.n.i.b(sb.append(webView2 != null ? Long.valueOf(webView2.getUniqueDrawingId()) : null).append(" in activity ").append(activity.getClass().getSimpleName()).append(CsvReader.Letters.POUND).append(activity.hashCode()).append(" will be cleared").toString());
        }
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityResumed(Activity activity) {
        e.a.c(activity);
    }

    public static final boolean a(o oVar, List list, String str) {
        URL url;
        oVar.getClass();
        try {
            url = new URL(str);
        } catch (Exception e2) {
            com.microsoft.clarity.n.i.e("Failed to parse URL " + str + " because of " + e2 + '.');
            url = null;
        }
        if (url != null) {
            String host = url.getHost();
            String protocol = url.getProtocol();
            if (!list.contains(host) && !list.contains("*") && !Intrinsics.areEqual(protocol, "file") && !Intrinsics.areEqual(host, "appassets.androidplatform.net") && !Intrinsics.areEqual(host, "localhost")) {
                return false;
            }
        }
        return true;
    }

    public static final void a(o oVar, Exception exc, ErrorType errorType) {
        Iterator it = oVar.f1000d.iterator();
        while (it.hasNext()) {
            ((com.microsoft.clarity.h.g) it.next()).a(exc, errorType);
        }
    }

    public static final void a(int i, WebView webView, o oVar, String str) {
        WebMessagePort webMessagePort = (WebMessagePort) oVar.f1003g.get(Integer.valueOf(webView.hashCode()));
        if (webMessagePort != null) {
            webMessagePort.close();
        }
        WebMessagePort[] webMessagePortArrCreateWebMessageChannel = webView.createWebMessageChannel();
        Intrinsics.checkNotNullExpressionValue(webMessagePortArrCreateWebMessageChannel, "webView.createWebMessageChannel()");
        WebMessagePort nativePort = webMessagePortArrCreateWebMessageChannel[0];
        WebMessagePort webMessagePort2 = webMessagePortArrCreateWebMessageChannel[1];
        nativePort.setWebMessageCallback(new p(i, webView, oVar, str));
        webView.postWebMessage(new WebMessage("clarityNativePort", new WebMessagePort[]{webMessagePort2}), Uri.parse("*"));
        LinkedHashMap linkedHashMap = oVar.f1003g;
        Integer numValueOf = Integer.valueOf(webView.hashCode());
        Intrinsics.checkNotNullExpressionValue(nativePort, "nativePort");
        linkedHashMap.put(numValueOf, nativePort);
    }

    @Override // com.microsoft.clarity.g.h
    public final void a(com.microsoft.clarity.h.g gVar) {
        com.microsoft.clarity.h.g callback = gVar;
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f1000d.add(callback);
    }

    @Override // com.microsoft.clarity.g.j
    public final void a(WebView webView, int i, String activityName) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        LinkedHashSet linkedHashSet = this.k;
        if (!(linkedHashSet instanceof Collection) || !linkedHashSet.isEmpty()) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), webView)) {
                    return;
                }
            }
        }
        if (com.microsoft.clarity.n.n.a(webView)) {
            return;
        }
        try {
            if (d(webView)) {
                ArrayList arrayList = this.f1004h;
                if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual(((WeakReference) it2.next()).get(), webView)) {
                            c(webView, i, activityName);
                            break;
                        }
                    }
                }
            } else {
                webView.getSettings().setJavaScriptEnabled(true);
                this.f1002f.add(new Pair(new WeakReference(webView), Integer.valueOf(i)));
            }
            b(webView, i, activityName);
        } catch (Exception e2) {
            ErrorType errorType = ErrorType.WebViewTracking;
            Iterator it3 = this.f1000d.iterator();
            while (it3.hasNext()) {
                ((com.microsoft.clarity.h.g) it3.next()).a(e2, errorType);
            }
            this.k.add(new WeakReference(webView));
        }
    }

    @Override // com.microsoft.clarity.g.j
    public final void a(final WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        LinkedHashSet linkedHashSet = this.j;
        if (!(linkedHashSet instanceof Collection) || !linkedHashSet.isEmpty()) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), webView)) {
                    return;
                }
            }
        }
        WeakReference weakReference = new WeakReference(webView);
        this.i.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.o$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return o.c(webView, (WeakReference) obj);
            }
        });
        this.j.add(weakReference);
        if (d(webView)) {
            this.f1004h.add(weakReference);
        }
    }
}
