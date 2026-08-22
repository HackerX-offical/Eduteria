package com.razorpay;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes9.dex */
class RazorpayExceptionHandler implements Thread.UncaughtExceptionHandler {
    Context context;
    Thread.UncaughtExceptionHandler existingHandler;

    RazorpayExceptionHandler(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.existingHandler = uncaughtExceptionHandler;
        this.context = context;
    }

    static void register(Context context) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof RazorpayExceptionHandler) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new RazorpayExceptionHandler(context, defaultUncaughtExceptionHandler));
    }

    static void unregister() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof RazorpayExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(((RazorpayExceptionHandler) defaultUncaughtExceptionHandler).existingHandler);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(final Thread thread, final Throwable th) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.razorpay.RazorpayExceptionHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m12335lambda$uncaughtException$0$comrazorpayRazorpayExceptionHandler(th, thread);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$uncaughtException$0$com-razorpay-RazorpayExceptionHandler, reason: not valid java name */
    /* synthetic */ void m12335lambda$uncaughtException$0$comrazorpayRazorpayExceptionHandler(Throwable th, Thread thread) {
        AnalyticsUtil.reportUncaughtException(th);
        Lumberjack.saveEventsToPreferences(this.context.getApplicationContext());
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.existingHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
