package com.github.kotvertolet.youtubejextractor.network;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: classes7.dex */
public class UserAgentInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36").addHeader("Accept", "*/*").build());
    }
}
