package com.karumi.dexter;

import android.os.Looper;

/* JADX INFO: loaded from: classes9.dex */
final class ThreadFactory {
    ThreadFactory() {
    }

    public static Thread makeMainThread() {
        return new MainThread();
    }

    public static Thread makeSameThread() {
        return runningMainThread() ? new MainThread() : new WorkerThread();
    }

    private static boolean runningMainThread() {
        return Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }
}
