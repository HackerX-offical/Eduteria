package com.clevertap.android.sdk.pushnotification;

/* JADX INFO: loaded from: classes7.dex */
public interface CTPushProvider {
    PushType getPushType();

    boolean isAvailable();

    boolean isSupported();

    int minSDKSupportVersionCode();

    void requestToken();
}
