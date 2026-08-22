package com.microsoft.clarity.g;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import com.microsoft.clarity.ClarityConfig;
import com.microsoft.clarity.e.b;
import com.microsoft.clarity.h.e;
import com.microsoft.clarity.models.ApplicationFramework;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.MaskingMode;
import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.observers.FramePicture;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.models.viewhierarchy.ViewNode;
import com.microsoft.clarity.models.viewhierarchy.WebViewData;
import com.microsoft.clarity.n.j;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements com.microsoft.clarity.g.f, com.microsoft.clarity.h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClarityConfig f885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DynamicConfig f886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.microsoft.clarity.e.e f887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<com.microsoft.clarity.h.c> f888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet f889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashSet f890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f891h;
    public LinkedHashMap i;
    public final Handler j;
    public Canvas k;
    public final com.microsoft.clarity.n.g l;
    public final Integer m;
    public String n;
    public final String o;
    public boolean p;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebView f892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f893b;

        public a(WebView view, Object obj) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f892a = view;
            this.f893b = obj;
        }

        public final Object a() {
            return this.f893b;
        }

        public final WebView b() {
            return this.f892a;
        }
    }

    /* JADX INFO: renamed from: com.microsoft.clarity.g.b$b, reason: collision with other inner class name */
    public static final class C0189b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewNode f895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Drawable f896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b.C0186b f897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f898e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f899f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f900g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f901h;

        public C0189b(View view, ViewNode viewNode, Drawable drawable, b.C0186b maskingOverlay, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(viewNode, "viewNode");
            Intrinsics.checkNotNullParameter(maskingOverlay, "maskingOverlay");
            this.f894a = view;
            this.f895b = viewNode;
            this.f896c = drawable;
            this.f897d = maskingOverlay;
            this.f898e = i;
            this.f899f = i2;
            this.f900g = i3;
            this.f901h = i4;
        }

        public final b.C0186b a() {
            return this.f897d;
        }

        public final Drawable b() {
            return this.f896c;
        }

        public final int c() {
            return this.f901h;
        }

        public final int d() {
            return this.f898e;
        }

        public final int e() {
            return this.f900g;
        }

        public final int f() {
            return this.f899f;
        }

        public final View g() {
            return this.f894a;
        }

        public final ViewNode h() {
            return this.f895b;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f903b;

        public c(int i, int i2) {
            this.f902a = i;
            this.f903b = i2;
        }

        public final int a() {
            return this.f902a;
        }

        public final int b() {
            return this.f903b;
        }
    }

    public final class d implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f907d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f908e;

        public d(int i, int i2, int i3, Object obj, boolean z) {
            this.f904a = i;
            this.f905b = i2;
            this.f906c = i3;
            this.f907d = obj;
            this.f908e = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object proxy, Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            if (Intrinsics.areEqual(method.getName(), "onDraw")) {
                if (Intrinsics.areEqual(objArr != null ? objArr[0] : null, b.this.k)) {
                    Canvas canvas = b.this.k;
                    Intrinsics.checkNotNull(canvas);
                    canvas.save();
                    if (!b.this.f885b.getEnableWebViewCapture() || this.f908e) {
                        b.a.h(canvas, this.f904a);
                        b.a.a(canvas, this.f905b, this.f906c);
                        b.a.d(canvas, this.f904a);
                    } else {
                        b.a.g(canvas, this.f904a);
                        b.a.c(canvas, this.f904a);
                    }
                    canvas.restore();
                    return null;
                }
            }
            return b.a(b.this, method, this.f907d, objArr);
        }
    }

    public final class e implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f915f;

        public static final class a extends Lambda implements Function0<InvocationHandler> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f917a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f918b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Method f919c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Object[] f920d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, e eVar, Method method, Object[] objArr) {
                super(0);
                this.f917a = bVar;
                this.f918b = eVar;
                this.f919c = method;
                this.f920d = objArr;
            }

            @Override // kotlin.jvm.functions.Function0
            public final InvocationHandler invoke() {
                b bVar = this.f917a;
                e eVar = this.f918b;
                return bVar.new d(eVar.f910a, eVar.f911b, eVar.f912c, b.a(bVar, this.f919c, eVar.f913d, this.f920d), this.f918b.f914e);
            }
        }

        public e(int i, int i2, int i3, Object obj, boolean z) {
            this.f910a = i;
            this.f911b = i2;
            this.f912c = i3;
            this.f913d = obj;
            this.f914e = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object proxy, Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            if (!Intrinsics.areEqual(method.getName(), "getViewDelegate")) {
                return b.a(b.this, method, this.f913d, objArr);
            }
            if (this.f915f == null) {
                HashMap<String, Class<?>> map = com.microsoft.clarity.n.j.f1093a;
                this.f915f = j.a.a(b.class.getClassLoader(), new Class[]{j.a.a(b.this.o + ".WebViewProvider$ViewDelegate")}, new a(b.this, this, method, objArr));
            }
            return this.f915f;
        }
    }

    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f921a;

        static {
            int[] iArr = new int[ApplicationFramework.values().length];
            iArr[ApplicationFramework.Native.ordinal()] = 1;
            iArr[ApplicationFramework.ReactNative.ordinal()] = 2;
            f921a = iArr;
        }
    }

    public static final class g extends Lambda implements Function0<ViewNode> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList<C0189b> f924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList<a> f925d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f926e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List<WebViewData> f927f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Set<String> f928g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(View view, ArrayList arrayList, ArrayList arrayList2, boolean z, ArrayList arrayList3, LinkedHashSet linkedHashSet) {
            super(0);
            this.f923b = view;
            this.f924c = arrayList;
            this.f925d = arrayList2;
            this.f926e = z;
            this.f927f = arrayList3;
            this.f928g = linkedHashSet;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewNode invoke() {
            b bVar = b.this;
            View rootView = this.f923b;
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            return bVar.a(rootView, null, true, this.f924c, this.f925d, this.f926e, false, this.f927f, this.f928g);
        }
    }

    public static final class h extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f930b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(View view, b bVar) {
            super(0);
            this.f929a = view;
            this.f930b = bVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.f929a.draw(this.f930b.k);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<C0189b> f932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList<a> f933c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ArrayList<C0189b> arrayList, ArrayList<a> arrayList2) {
            super(0);
            this.f932b = arrayList;
            this.f933c = arrayList2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() throws com.microsoft.clarity.c.b {
            b.this.a(this.f932b, this.f933c);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FramePicture f935b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FramePicture framePicture) {
            super(0);
            this.f935b = framePicture;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            Iterator<com.microsoft.clarity.h.c> it = b.this.f888e.iterator();
            while (it.hasNext()) {
                it.next().a(this.f935b);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<Exception, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f936a = new k();

        public k() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(Exception exc) {
            Exception f2 = exc;
            Intrinsics.checkNotNullParameter(f2, "f");
            return String.valueOf(f2.getMessage());
        }
    }

    public b(Context context, ClarityConfig config, DynamicConfig dynamicConfig, com.microsoft.clarity.g.g lifecycleObserver, com.microsoft.clarity.e.e telemetryTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dynamicConfig, "dynamicConfig");
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(telemetryTracker, "telemetryTracker");
        this.f884a = context;
        this.f885b = config;
        this.f886c = dynamicConfig;
        this.f887d = telemetryTracker;
        lifecycleObserver.a(this);
        this.f888e = new ArrayList<>();
        this.f889f = new LinkedHashSet();
        this.f890g = new LinkedHashSet();
        this.i = new LinkedHashMap();
        this.j = new Handler(Looper.getMainLooper());
        this.l = new com.microsoft.clarity.n.g();
        this.m = g();
        String name = WebView.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "WebView::class.java.name");
        this.o = StringsKt.replace$default(name, ".WebView", "", false, 4, (Object) null);
    }

    public static final Object a(b bVar, Method method, Object obj, Object[] objArr) {
        bVar.getClass();
        if (obj == null) {
            return null;
        }
        return objArr == null ? method.invoke(obj, new Object[0]) : method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public static final boolean a(View view, WeakReference it) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.get(), view);
    }

    public static final boolean a(WeakReference r) {
        Intrinsics.checkNotNullParameter(r, "r");
        return r.get() == null;
    }

    public static final boolean b(View view, WeakReference it) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.get(), view);
    }

    public static final boolean b(WeakReference r) {
        Intrinsics.checkNotNullParameter(r, "r");
        return r.get() == null;
    }

    @Override // com.microsoft.clarity.g.h
    public final void a() {
        this.p = false;
    }

    @Override // com.microsoft.clarity.g.f
    public final void a(final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f889f.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.b$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return b.b(view, (WeakReference) obj);
            }
        });
        this.f890g.add(new WeakReference(view));
    }

    @Override // com.microsoft.clarity.h.e, com.microsoft.clarity.h.d
    public final void a(Exception exc, ErrorType errorType) {
        e.a.a(exc, errorType);
    }

    @Override // com.microsoft.clarity.g.f
    public final void a(String str) {
        this.n = str;
    }

    public final void b(Activity activity) throws com.microsoft.clarity.c.a {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.n.i.b("Capture frame for " + activity + '.');
        View rootView = activity.getWindow().getDecorView().getRootView();
        if (rootView != null && rootView.isLaidOut()) {
            int iHashCode = activity.hashCode();
            Integer num = this.f891h;
            if (num != null && iHashCode == num.intValue()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Picture picture = new Picture();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                ArrayList arrayList3 = new ArrayList();
                boolean zC = c(activity);
                com.microsoft.clarity.n.i.b("Frame timestamp: " + jCurrentTimeMillis + '.');
                com.microsoft.clarity.n.i.b("Frame shouldMaskCurrentActivity: " + zC + '.');
                try {
                    ViewNode viewNode = (ViewNode) com.microsoft.clarity.n.m.a("Clarity_ProcessViewHierarchy", this.f887d, new g(rootView, arrayList3, arrayList2, zC, arrayList, linkedHashSet));
                    com.microsoft.clarity.n.i.b("Frame updated views count: " + arrayList3.size() + '.');
                    this.k = picture.beginRecording(rootView.getWidth(), rootView.getHeight());
                    com.microsoft.clarity.n.m.a("Clarity_DrawSkPicture", this.f887d, new h(rootView, this));
                    if (viewNode == null) {
                        throw new com.microsoft.clarity.c.a();
                    }
                    String simpleName = activity.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
                    ViewHierarchy viewHierarchy = new ViewHierarchy(jCurrentTimeMillis, viewNode, linkedHashSet, simpleName, activity.hashCode(), arrayList);
                    com.microsoft.clarity.n.m.a("Clarity_Callbacks", this.f887d, new j(new FramePicture(picture, viewHierarchy, jCurrentTimeMillis, viewHierarchy.getActivityName(), viewHierarchy.getActivityHashCode(), zC, rootView.getWidth(), rootView.getHeight(), activity.getResources().getDisplayMetrics().density)));
                    return;
                } finally {
                    com.microsoft.clarity.n.m.a("Clarity_RevertViewHierarchyChanges", this.f887d, new i(arrayList3, arrayList2));
                }
            }
        }
        com.microsoft.clarity.n.i.b("Root view not laid out yet for " + activity + " or it is not the current activity.");
    }

    @Override // com.microsoft.clarity.g.f
    public final void b(final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f890g.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.b$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return b.a(view, (WeakReference) obj);
            }
        });
        this.f889f.add(new WeakReference(view));
    }

    public final void b(ErrorDisplayFrame errorDisplayFrame) {
        Intrinsics.checkNotNullParameter(errorDisplayFrame, "errorDisplayFrame");
        Iterator<com.microsoft.clarity.h.c> it = this.f888e.iterator();
        while (it.hasNext()) {
            it.next().a(errorDisplayFrame);
        }
    }

    public final void b(Exception exception, ErrorType errorType) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Iterator<com.microsoft.clarity.h.c> it = this.f888e.iterator();
        while (it.hasNext()) {
            it.next().a(exception, errorType);
        }
    }

    @Override // com.microsoft.clarity.g.h
    public final void c() {
        this.p = true;
    }

    public final boolean c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean z = false;
        if (this.f886c.getMaskingMode() == MaskingMode.Strict) {
            Set<String> unmaskedActivities = this.f886c.getUnmaskedActivities();
            if (!(unmaskedActivities instanceof Collection) || !unmaskedActivities.isEmpty()) {
                for (String str : unmaskedActivities) {
                    if (Intrinsics.areEqual(str, activity.getClass().getName()) || Intrinsics.areEqual(str, activity.getClass().getSimpleName())) {
                        z = true;
                        break;
                    }
                }
            }
            return !z;
        }
        if (this.f886c.getMaskingMode() != MaskingMode.Balanced && this.f886c.getMaskingMode() != MaskingMode.Relaxed) {
            return false;
        }
        Set<String> maskedActivities = this.f886c.getMaskedActivities();
        if (!(maskedActivities instanceof Collection) || !maskedActivities.isEmpty()) {
            for (String str2 : maskedActivities) {
                if (Intrinsics.areEqual(str2, activity.getClass().getName()) || Intrinsics.areEqual(str2, activity.getClass().getSimpleName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Integer g() {
        try {
            return Integer.valueOf(this.f884a.getResources().getIdentifier("fragment_container_view_tag", "id", this.f884a.getPackageName()));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f889f.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.b$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return b.a((WeakReference) obj);
            }
        });
        this.f890g.removeIf(new Predicate() { // from class: com.microsoft.clarity.g.b$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return b.b((WeakReference) obj);
            }
        });
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.n.i.b("Unregister frame capture task for " + activity + '.');
        int iHashCode = activity.hashCode();
        if (this.i.containsKey(Integer.valueOf(iHashCode))) {
            Handler handler = this.j;
            Object obj = this.i.get(Integer.valueOf(iHashCode));
            Intrinsics.checkNotNull(obj);
            handler.removeCallbacks((Runnable) obj);
            this.i.remove(Integer.valueOf(iHashCode));
        }
        this.l.b(activity);
        SparseIntArray[] frameMetrics = this.l.a();
        Intrinsics.checkNotNullParameter(frameMetrics, "frameMetrics");
        com.microsoft.clarity.n.i.b("Trace frame metrics.");
        SparseIntArray sparseIntArray = frameMetrics[0];
        if (sparseIntArray == null) {
            return;
        }
        int size = sparseIntArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iValueAt = sparseIntArray.valueAt(i2);
            for (int i3 = 0; i3 < iValueAt; i3++) {
                Trace.setCounter("Clarity_TotalFrameDuration", sparseIntArray.keyAt(i2));
                this.f887d.a("Clarity_TotalFrameDuration", sparseIntArray.keyAt(i2));
            }
        }
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.l.a(activity);
        this.f891h = Integer.valueOf(activity.hashCode());
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.n.i.b("Register frame capture task for " + activity + '.');
        String simpleName = activity.getClass().getSimpleName();
        int iHashCode = activity.hashCode();
        this.i.put(Integer.valueOf(iHashCode), new com.microsoft.clarity.g.e(this, activity, simpleName, iHashCode));
        Handler handler = this.j;
        Object obj = this.i.get(Integer.valueOf(iHashCode));
        Intrinsics.checkNotNull(obj);
        handler.post((Runnable) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0629  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.models.viewhierarchy.ViewNode a(android.view.View r42, android.view.ViewGroup r43, boolean r44, java.util.ArrayList<com.microsoft.clarity.g.b.C0189b> r45, java.util.ArrayList<com.microsoft.clarity.g.b.a> r46, boolean r47, boolean r48, java.util.List<com.microsoft.clarity.models.viewhierarchy.WebViewData> r49, java.util.Set<java.lang.String> r50) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 1612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.g.b.a(android.view.View, android.view.ViewGroup, boolean, java.util.ArrayList, java.util.ArrayList, boolean, boolean, java.util.List, java.util.Set):com.microsoft.clarity.models.viewhierarchy.ViewNode");
    }

    @Override // com.microsoft.clarity.g.h
    public final void a(com.microsoft.clarity.h.c cVar) {
        com.microsoft.clarity.h.c callback = cVar;
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.microsoft.clarity.n.i.d("Register callback.");
        this.f888e.add(callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00fb A[Catch: Exception -> 0x013b, TryCatch #1 {Exception -> 0x013b, blocks: (B:4:0x0033, B:6:0x0051, B:7:0x0082, B:9:0x0092, B:10:0x00c3, B:12:0x00d5, B:14:0x00f3, B:16:0x00fe, B:15:0x00fb), top: B:36:0x0033 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.util.ArrayList<com.microsoft.clarity.g.b.C0189b> r11, java.util.ArrayList<com.microsoft.clarity.g.b.a> r12) throws com.microsoft.clarity.c.b {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.g.b.a(java.util.ArrayList, java.util.ArrayList):void");
    }
}
