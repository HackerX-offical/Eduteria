package com.paytm.pgsdk;

/* JADX INFO: loaded from: classes9.dex */
public interface ApiCallback<T> {
    void onError();

    void onSuccess(T t);
}
