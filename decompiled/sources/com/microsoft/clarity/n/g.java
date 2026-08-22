package com.microsoft.clarity.n;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HandlerThread f1086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Handler f1087f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SparseIntArray[] f1089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<WeakReference<Activity>> f1090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Window.OnFrameMetricsAvailableListener f1091d;

    public /* synthetic */ g() {
        this(1);
    }

    public g(int i) {
        this.f1088a = i;
        this.f1089b = new SparseIntArray[9];
        this.f1090c = new ArrayList<>();
        this.f1091d = new Window.OnFrameMetricsAvailableListener() { // from class: com.microsoft.clarity.n.g$$ExternalSyntheticLambda0
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i2) {
                g.a(this.f$0, window, frameMetrics, i2);
            }
        };
    }

    public static void a(SparseIntArray sparseIntArray, long j) {
        if (sparseIntArray == null) {
            return;
        }
        int i = (int) ((((long) 500000) + j) / ((long) 1000000));
        if (j >= 0) {
            sparseIntArray.put(i, sparseIntArray.get(i) + 1);
        }
    }

    public static final void a(g this$0, Window window, FrameMetrics frameMetrics, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((this$0.f1088a & 1) != 0) {
            a(this$0.f1089b[0], frameMetrics.getMetric(8));
        }
        if ((this$0.f1088a & 2) != 0) {
            a(this$0.f1089b[1], frameMetrics.getMetric(1));
        }
        if ((this$0.f1088a & 4) != 0) {
            a(this$0.f1089b[2], frameMetrics.getMetric(3));
        }
        if ((this$0.f1088a & 8) != 0) {
            a(this$0.f1089b[3], frameMetrics.getMetric(4));
        }
        if ((this$0.f1088a & 16) != 0) {
            a(this$0.f1089b[4], frameMetrics.getMetric(5));
        }
        if ((this$0.f1088a & 64) != 0) {
            a(this$0.f1089b[6], frameMetrics.getMetric(7));
        }
        if ((this$0.f1088a & 32) != 0) {
            a(this$0.f1089b[5], frameMetrics.getMetric(6));
        }
        if ((this$0.f1088a & 128) != 0) {
            a(this$0.f1089b[7], frameMetrics.getMetric(0));
        }
        if ((this$0.f1088a & 256) != 0) {
            a(this$0.f1089b[8], frameMetrics.getMetric(2));
        }
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (f1086e == null) {
            HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
            f1086e = handlerThread;
            Intrinsics.checkNotNull(handlerThread);
            handlerThread.start();
            HandlerThread handlerThread2 = f1086e;
            Intrinsics.checkNotNull(handlerThread2);
            f1087f = new Handler(handlerThread2.getLooper());
        }
        for (int i = 0; i < 9; i++) {
            SparseIntArray[] sparseIntArrayArr = this.f1089b;
            if (sparseIntArrayArr[i] == null && (this.f1088a & (1 << i)) != 0) {
                sparseIntArrayArr[i] = new SparseIntArray();
            }
        }
        activity.getWindow().addOnFrameMetricsAvailableListener(this.f1091d, f1087f);
        this.f1090c.add(new WeakReference<>(activity));
    }

    public final SparseIntArray[] a() {
        SparseIntArray[] sparseIntArrayArr = this.f1089b;
        this.f1089b = new SparseIntArray[9];
        return sparseIntArrayArr;
    }

    public final void b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<WeakReference<Activity>> it = this.f1090c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference<Activity> next = it.next();
            if (next.get() == activity) {
                this.f1090c.remove(next);
                break;
            }
        }
        activity.getWindow().removeOnFrameMetricsAvailableListener(this.f1091d);
    }
}
