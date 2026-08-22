package com.microsoft.clarity.g;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.microsoft.clarity.g.e;
import com.microsoft.clarity.h.e;
import com.microsoft.clarity.models.ingest.analytics.AnalyticsEvent;
import com.microsoft.clarity.models.ingest.analytics.Click;
import com.microsoft.clarity.models.ingest.analytics.DoubleClick;
import com.microsoft.clarity.models.ingest.analytics.Visibility;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements i, com.microsoft.clarity.h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<com.microsoft.clarity.h.f> f973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f979g;

    public final class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f981b;

        public a(l lVar, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f981b = lVar;
            this.f980a = activity;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent e2) {
            Intrinsics.checkNotNullParameter(e2, "e");
            long jCurrentTimeMillis = System.currentTimeMillis();
            DoubleClick doubleClick = new DoubleClick(jCurrentTimeMillis, this.f980a.getClass().getSimpleName(), this.f980a.hashCode(), e2.getPointerId(e2.getActionIndex()), e2.getX(), e2.getY());
            Click click = new Click(jCurrentTimeMillis, this.f980a.getClass().getSimpleName(), this.f980a.hashCode(), e2.getX(), e2.getY());
            this.f981b.c(doubleClick);
            this.f981b.c(click);
            com.microsoft.clarity.n.i.d("Double click event watched (" + doubleClick.serialize() + ") (" + click.serialize() + ").");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent e2) {
            Intrinsics.checkNotNullParameter(e2, "e");
            Click click = new Click(System.currentTimeMillis(), this.f980a.getClass().getSimpleName(), this.f980a.hashCode(), e2.getX(), e2.getY());
            this.f981b.c(click);
            com.microsoft.clarity.n.i.d("Click event watched (" + click + ").");
            return false;
        }
    }

    public final class b implements Window.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Window.Callback f982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Activity f983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final GestureDetector f984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f985d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ l f986e;

        public static final class a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MotionEvent f987a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f988b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ l f989c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(MotionEvent motionEvent, b bVar, l lVar) {
                super(0);
                this.f987a = motionEvent;
                this.f988b = bVar;
                this.f989c = lVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x00ba  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final kotlin.Unit invoke() {
                /*
                    Method dump skipped, instruction units count: 285
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.g.l.b.a.invoke():java.lang.Object");
            }
        }

        /* JADX INFO: renamed from: com.microsoft.clarity.g.l$b$b, reason: collision with other inner class name */
        public static final class C0190b extends Lambda implements Function1<Exception, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f990a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0190b(l lVar) {
                super(1);
                this.f990a = lVar;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Exception exc) {
                Exception it = exc;
                Intrinsics.checkNotNullParameter(it, "it");
                l.a(this.f990a, it, ErrorType.CapturingTouchEvent);
                return Unit.INSTANCE;
            }
        }

        public b(l lVar, Window.Callback windowCallback, Activity activity) {
            Intrinsics.checkNotNullParameter(windowCallback, "windowCallback");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f986e = lVar;
            this.f982a = windowCallback;
            this.f983b = activity;
            this.f984c = new GestureDetector(activity, new a(lVar, activity));
            this.f985d = true;
        }

        public final void a() {
            this.f985d = false;
        }

        public final Window.Callback b() {
            return this.f982a;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return this.f982a.dispatchGenericMotionEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f982a.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return this.f982a.dispatchKeyShortcutEvent(keyEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return this.f982a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (this.f985d) {
                com.microsoft.clarity.n.e.a(new a(event, this, this.f986e), new C0190b(this.f986e), (e.c) null, 26);
            }
            return this.f982a.dispatchTouchEvent(event);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return this.f982a.dispatchTrackballEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(ActionMode actionMode) {
            this.f982a.onActionModeFinished(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(ActionMode actionMode) {
            this.f982a.onActionModeStarted(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.f982a.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            this.f982a.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i, Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            return this.f982a.onCreatePanelMenu(i, menu);
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int i) {
            return this.f982a.onCreatePanelView(i);
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.f982a.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int i, MenuItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return this.f982a.onMenuItemSelected(i, item);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int i, Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            return this.f982a.onMenuOpened(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int i, Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            this.f982a.onPanelClosed(i, menu);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int i, View view, Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            return this.f982a.onPreparePanel(i, view, menu);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.f982a.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent searchEvent) {
            return this.f982a.onSearchRequested(searchEvent);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            this.f982a.onWindowAttributesChanged(layoutParams);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean z) {
            this.f982a.onWindowFocusChanged(z);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.f982a.onWindowStartingActionMode(callback);
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return this.f982a.onWindowStartingActionMode(callback, i);
        }
    }

    public l(g lifecycleObserver) {
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        this.f973a = new ArrayList<>();
        this.f974b = new Handler(Looper.getMainLooper());
        lifecycleObserver.a(this);
    }

    public static final void a(l lVar, Exception exc, ErrorType errorType) {
        Iterator<com.microsoft.clarity.h.f> it = lVar.f973a.iterator();
        while (it.hasNext()) {
            it.next().a(exc, errorType);
        }
    }

    @Override // com.microsoft.clarity.g.h
    public final void a() {
        this.f979g = false;
    }

    @Override // com.microsoft.clarity.h.e, com.microsoft.clarity.h.d
    public final void a(Exception exc, ErrorType errorType) {
        e.a.a(exc, errorType);
    }

    public final void b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f978f > 5) {
            return;
        }
        Window.Callback callback = activity.getWindow().getCallback();
        if (callback instanceof b) {
            return;
        }
        com.microsoft.clarity.n.i.b("Watch touches for " + activity + '.');
        if (this.f977e != null) {
            com.microsoft.clarity.n.i.b("Had to deactivate the previously set callback.");
            b bVar = this.f977e;
            if (bVar != null) {
                bVar.a();
            }
        }
        Intrinsics.checkNotNullExpressionValue(callback, "callback");
        b bVar2 = new b(this, callback, activity);
        this.f977e = bVar2;
        activity.getWindow().setCallback(bVar2);
        this.f978f++;
    }

    @Override // com.microsoft.clarity.g.h
    public final void c() {
        this.f979g = true;
    }

    public final void c(AnalyticsEvent analyticsEvent) {
        int activityId = analyticsEvent.getActivityId();
        Integer num = this.f976d;
        if (num == null || activityId != num.intValue()) {
            com.microsoft.clarity.n.i.b("Dropping analytics event from an old activity.");
        } else {
            if (this.f979g) {
                return;
            }
            Iterator<com.microsoft.clarity.h.f> it = this.f973a.iterator();
            while (it.hasNext()) {
                it.next().a(analyticsEvent);
            }
        }
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityDestroyed(Activity activity) {
        e.a.a(activity);
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.n.i.b("Clear window callback for " + activity + '.');
        m mVar = this.f975c;
        if (mVar != null) {
            this.f974b.removeCallbacks(mVar);
        }
        Window.Callback callback = activity.getWindow().getCallback();
        if (callback instanceof b) {
            activity.getWindow().setCallback(((b) callback).b());
        }
        b bVar = this.f977e;
        if (bVar != null) {
            bVar.a();
        }
        this.f977e = null;
        this.f978f = 0;
        c(new Visibility(System.currentTimeMillis(), activity.getClass().getSimpleName(), activity.hashCode(), "hidden"));
    }

    @Override // com.microsoft.clarity.h.e
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f976d = Integer.valueOf(activity.hashCode());
        b(activity);
        com.microsoft.clarity.n.i.b("Register setting window callback task for " + activity + '.');
        m mVar = new m(this, activity);
        this.f975c = mVar;
        Handler handler = this.f974b;
        Intrinsics.checkNotNull(mVar);
        handler.post(mVar);
        c(new Visibility(System.currentTimeMillis(), activity.getClass().getSimpleName(), activity.hashCode(), "visible"));
    }

    @Override // com.microsoft.clarity.g.h
    public final void a(com.microsoft.clarity.h.f fVar) {
        com.microsoft.clarity.h.f callback = fVar;
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.microsoft.clarity.n.i.d("Register callback.");
        this.f973a.add(callback);
    }
}
