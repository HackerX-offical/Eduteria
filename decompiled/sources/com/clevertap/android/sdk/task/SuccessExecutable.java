package com.clevertap.android.sdk.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes7.dex */
class SuccessExecutable<TResult> extends Executable<TResult> {
    private final OnSuccessListener<TResult> successListener;

    protected SuccessExecutable(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        super(executor);
        this.successListener = onSuccessListener;
    }

    public OnSuccessListener<TResult> getSuccessListener() {
        return this.successListener;
    }

    @Override // com.clevertap.android.sdk.task.Executable
    void execute(final TResult tresult) {
        this.executor.execute(new Runnable() { // from class: com.clevertap.android.sdk.task.SuccessExecutable$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m11940x4e6c24d3(tresult);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$execute$0$com-clevertap-android-sdk-task-SuccessExecutable, reason: not valid java name */
    /* synthetic */ void m11940x4e6c24d3(Object obj) {
        this.successListener.onSuccess(obj);
    }
}
