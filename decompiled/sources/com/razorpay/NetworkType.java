package com.razorpay;

import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes9.dex */
enum NetworkType {
    WIFI(Constants.CLTAP_CONNECTED_TO_WIFI),
    CELLULAR("cellular"),
    BLUETOOTH("bluetooth"),
    UNKNOWN("unknown");

    private String mNetworkTypeName;

    NetworkType(String str) {
        this.mNetworkTypeName = str;
    }

    final String getNetworkTypeName() {
        return this.mNetworkTypeName;
    }
}
