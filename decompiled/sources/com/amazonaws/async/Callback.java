package com.amazonaws.async;

/* JADX INFO: loaded from: classes4.dex */
public interface Callback<R> {
    void onError(Exception exc);

    void onResult(R r);
}
