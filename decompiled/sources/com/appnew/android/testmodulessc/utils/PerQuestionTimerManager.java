package com.appnew.android.testmodulessc.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PerQuestionTimerManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u0012J\u0006\u0010\u0013\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/appnew/android/testmodulessc/utils/PerQuestionTimerManager;", "", "<init>", "()V", "handler", "Landroid/os/Handler;", "runnable", "Ljava/lang/Runnable;", "startRealtime", "", "baseSeconds", "", "running", "", "start", "", "alreadySpentSeconds", "onTick", "Lkotlin/Function1;", "stop", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PerQuestionTimerManager {
    public static final int $stable = 8;
    private int baseSeconds;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    private boolean running;
    private long startRealtime;

    public final void start(int alreadySpentSeconds, final Function1<? super Integer, Unit> onTick) {
        Intrinsics.checkNotNullParameter(onTick, "onTick");
        stop();
        this.baseSeconds = alreadySpentSeconds;
        this.startRealtime = SystemClock.elapsedRealtime();
        this.running = true;
        Runnable runnable = new Runnable() { // from class: com.appnew.android.testmodulessc.utils.PerQuestionTimerManager.start.1
            @Override // java.lang.Runnable
            public void run() {
                if (PerQuestionTimerManager.this.running) {
                    onTick.invoke(Integer.valueOf(PerQuestionTimerManager.this.baseSeconds + ((int) ((SystemClock.elapsedRealtime() - PerQuestionTimerManager.this.startRealtime) / ((long) 1000)))));
                    PerQuestionTimerManager.this.handler.postDelayed(this, 1000L);
                }
            }
        };
        this.runnable = runnable;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable);
        handler.post(runnable);
    }

    public final void stop() {
        this.running = false;
        Runnable runnable = this.runnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        this.runnable = null;
    }
}
