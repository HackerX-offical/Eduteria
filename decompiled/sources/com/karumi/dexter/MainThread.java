package com.karumi.dexter;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes9.dex */
final class MainThread implements Thread {
    MainThread() {
    }

    private static boolean runningMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    @Override // com.karumi.dexter.Thread
    public void execute(Runnable runnable) {
        if (runningMainThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    @Override // com.karumi.dexter.Thread
    public void loop() {
    }
}
