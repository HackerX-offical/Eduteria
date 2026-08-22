package com.google.android.datatransport.runtime.retries;

/* JADX INFO: loaded from: classes7.dex */
public interface RetryStrategy<TInput, TResult> {
    TInput shouldRetry(TInput tinput, TResult tresult);
}
