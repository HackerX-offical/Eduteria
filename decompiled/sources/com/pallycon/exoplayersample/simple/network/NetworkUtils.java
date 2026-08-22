package com.pallycon.exoplayersample.simple.network;

/* JADX INFO: loaded from: classes9.dex */
public class NetworkUtils {
    private static APIinterface service;

    public static APIinterface getClient() {
        if (service == null) {
            service = (APIinterface) RetrofitClientInstance.getRetrofitInstance().create(APIinterface.class);
        }
        return service;
    }
}
