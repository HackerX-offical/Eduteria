package com.clevertap.android.sdk.pushnotification.fcm;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.pushnotification.CTPushProvider;
import com.clevertap.android.sdk.pushnotification.CTPushProviderListener;
import com.clevertap.android.sdk.pushnotification.PushType;

/* JADX INFO: loaded from: classes7.dex */
public class FcmPushProvider implements CTPushProvider {
    private IFcmSdkHandler handler;

    @Override // com.clevertap.android.sdk.pushnotification.CTPushProvider
    public int minSDKSupportVersionCode() {
        return 0;
    }

    public FcmPushProvider(CTPushProviderListener cTPushProviderListener, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.handler = new FcmSdkHandlerImpl(cTPushProviderListener, context, cleverTapInstanceConfig);
    }

    @Override // com.clevertap.android.sdk.pushnotification.CTPushProvider
    public PushType getPushType() {
        return this.handler.getPushType();
    }

    @Override // com.clevertap.android.sdk.pushnotification.CTPushProvider
    public boolean isAvailable() {
        return this.handler.isAvailable();
    }

    @Override // com.clevertap.android.sdk.pushnotification.CTPushProvider
    public boolean isSupported() {
        return this.handler.isSupported();
    }

    @Override // com.clevertap.android.sdk.pushnotification.CTPushProvider
    public void requestToken() {
        this.handler.requestToken();
    }

    void setHandler(IFcmSdkHandler iFcmSdkHandler) {
        this.handler = iFcmSdkHandler;
    }
}
