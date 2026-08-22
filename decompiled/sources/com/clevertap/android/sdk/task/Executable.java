package com.clevertap.android.sdk.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes7.dex */
abstract class Executable<TResult> {
    protected final Executor executor;

    abstract void execute(TResult tresult);

    Executable(Executor executor) {
        this.executor = executor;
    }
}
