package com.clevertap.android.sdk.pushnotification.fcm;

import com.clevertap.android.sdk.pushnotification.PushType;

/* JADX INFO: loaded from: classes7.dex */
public interface IFcmSdkHandler {
    PushType getPushType();

    boolean isAvailable();

    boolean isSupported();

    void requestToken();
}
