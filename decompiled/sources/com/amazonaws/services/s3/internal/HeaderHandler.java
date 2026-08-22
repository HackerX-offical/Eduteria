package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;

/* JADX INFO: loaded from: classes4.dex */
public interface HeaderHandler<T> {
    void handle(T t, HttpResponse httpResponse);
}
