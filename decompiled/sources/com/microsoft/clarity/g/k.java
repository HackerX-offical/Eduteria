package com.microsoft.clarity.g;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.microsoft.clarity.g.e;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements com.microsoft.clarity.g.g, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<com.microsoft.clarity.h.e> f955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f960g;

    public enum a {
        /* JADX INFO: Fake field, exist only in values array */
        ON_CREATE,
        /* JADX INFO: Fake field, exist only in values array */
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        /* JADX INFO: Fake field, exist only in values array */
        ON_STOP,
        /* JADX INFO: Fake field, exist only in values array */
        ON_ANY
    }

    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f965b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity) {
            super(0);
            this.f965b = activity;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            k.this.f956c.remove(Integer.valueOf(this.f965b.hashCode()));
            k kVar = k.this;
            if (kVar.f959f || kVar.f960g) {
                com.microsoft.clarity.n.i.d(this.f965b + " is destroyed.");
                Iterator<com.microsoft.clarity.h.e> it = k.this.f955b.iterator();
                while (it.hasNext()) {
                    it.next().onActivityDestroyed(this.f965b);
                }
            }
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
            k.a(k.this, it, ErrorType.ActivityLifecycle);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f968b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity) {
            super(0);
            this.f968b = activity;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            k.this.f956c.put(Integer.valueOf(this.f968b.hashCode()), a.ON_PAUSE);
            k kVar = k.this;
            if (kVar.f959f || kVar.f960g) {
                com.microsoft.clarity.n.i.d(this.f968b + " is paused.");
                Iterator<com.microsoft.clarity.h.e> it = k.this.f955b.iterator();
                while (it.hasNext()) {
                    it.next().onActivityPaused(this.f968b);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Exception, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            k.a(k.this, it);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f971b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Activity activity) {
            super(0);
            this.f971b = activity;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            k.this.a(this.f971b);
            k kVar = k.this;
            if (kVar.f959f || kVar.f960g) {
                com.microsoft.clarity.n.i.d(this.f971b + " is resumed.");
                Iterator<com.microsoft.clarity.h.e> it = k.this.f955b.iterator();
                while (it.hasNext()) {
                    it.next().onActivityResumed(this.f971b);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Exception, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            k.a(k.this, it, ErrorType.ActivityLifecycle);
            return Unit.INSTANCE;
        }
    }

    public k(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f954a = application;
        this.f955b = new ArrayList<>();
        this.f956c = new LinkedHashMap();
        g();
    }

    public static final void a(k kVar, Exception exc, ErrorType errorType) {
        Iterator<com.microsoft.clarity.h.e> it = kVar.f955b.iterator();
        while (it.hasNext()) {
            it.next().a(exc, errorType);
        }
    }

    @Override // com.microsoft.clarity.g.g
    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f956c.put(Integer.valueOf(activity.hashCode()), a.ON_RESUME);
        this.f957d = new WeakReference<>(activity);
    }

    @Override // com.microsoft.clarity.g.g
    public final boolean b() {
        LinkedHashMap linkedHashMap = this.f956c;
        if (linkedHashMap.isEmpty()) {
            return false;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            if (((Map.Entry) it.next()).getValue() == a.ON_RESUME) {
                return true;
            }
        }
        return false;
    }

    @Override // com.microsoft.clarity.g.g
    public final void d() {
        this.f959f = false;
        this.f960g = true;
        this.f958e = false;
        this.f954a.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // com.microsoft.clarity.g.g
    public final void e() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Activity activity2;
        g();
        this.f959f = true;
        this.f960g = false;
        WeakReference<Activity> weakReference2 = this.f957d;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        LinkedHashMap linkedHashMap = this.f956c;
        WeakReference<Activity> weakReference3 = this.f957d;
        if (linkedHashMap.get((weakReference3 == null || (activity2 = weakReference3.get()) == null) ? null : Integer.valueOf(activity2.hashCode())) != a.ON_RESUME || (weakReference = this.f957d) == null || (activity = weakReference.get()) == null) {
            return;
        }
        onActivityResumed(activity);
    }

    @Override // com.microsoft.clarity.g.g
    public final WeakReference<Activity> f() {
        return this.f957d;
    }

    public final void g() {
        if (this.f958e) {
            return;
        }
        this.f954a.registerActivityLifecycleCallbacks(this);
        this.f958e = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.n.e.a(new b(activity), new c(), (e.c) null, 26);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.n.e.a(new d(activity), new e(), (e.c) null, 26);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.microsoft.clarity.n.e.a(new f(activity), new g(), (e.c) null, 26);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static void a(k kVar, Exception exc) {
        ErrorType errorType = ErrorType.ActivityLifecycle;
        Iterator<com.microsoft.clarity.h.e> it = kVar.f955b.iterator();
        while (it.hasNext()) {
            it.next().a(exc, errorType);
        }
    }

    @Override // com.microsoft.clarity.g.h
    public final void a(com.microsoft.clarity.h.e eVar) {
        com.microsoft.clarity.h.e callback = eVar;
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.microsoft.clarity.n.i.d("Register callback.");
        this.f955b.add(callback);
    }
}
