package com.microsoft.clarity.g;

import android.app.Activity;
import com.microsoft.clarity.h.e;
import com.microsoft.clarity.models.ingest.analytics.ScriptError;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements h, Thread.UncaughtExceptionHandler, com.microsoft.clarity.h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<com.microsoft.clarity.h.b> f881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Activity> f883c;

    public a(g lifecycleObserver) {
        Intrinsics.checkNotNullParameter(lifecycleObserver, "lifecycleObserver");
        this.f881a = new ArrayList<>();
        this.f882b = Thread.getDefaultUncaughtExceptionHandler();
        lifecycleObserver.a(this);
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // com.microsoft.clarity.h.e, com.microsoft.clarity.h.d
    public final void a(Exception exc, ErrorType errorType) {
        e.a.a(exc, errorType);
    }

    @Override // com.microsoft.clarity.g.h
    public final void a(Object obj) {
        com.microsoft.clarity.h.b callback = (com.microsoft.clarity.h.b) obj;
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.microsoft.clarity.n.i.d("Register callback.");
        this.f881a.add(callback);
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
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f883c = new WeakReference<>(activity);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread t, Throwable e2) {
        Activity activity;
        Activity activity2;
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e2, "e");
        Throwable cause = e2;
        while (cause.getCause() != null) {
            cause = cause.getCause();
            Intrinsics.checkNotNull(cause);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        WeakReference<Activity> weakReference = this.f883c;
        String simpleName = (weakReference == null || (activity2 = weakReference.get()) == null) ? null : activity2.getClass().getSimpleName();
        if (simpleName == null) {
            simpleName = "";
        }
        WeakReference<Activity> weakReference2 = this.f883c;
        ScriptError scriptError = new ScriptError(jCurrentTimeMillis, simpleName, (weakReference2 == null || (activity = weakReference2.get()) == null) ? 0 : activity.hashCode(), com.microsoft.clarity.a.b.a("[Native] ").append(cause.getMessage()).toString(), ArraysKt.contentDeepToString(cause.getStackTrace()));
        Iterator<com.microsoft.clarity.h.b> it = this.f881a.iterator();
        while (it.hasNext()) {
            it.next().a(scriptError);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f882b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t, e2);
        }
    }
}
