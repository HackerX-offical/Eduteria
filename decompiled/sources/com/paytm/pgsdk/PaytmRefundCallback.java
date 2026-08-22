package com.paytm.pgsdk;

import android.os.Bundle;

/* JADX INFO: loaded from: classes9.dex */
public interface PaytmRefundCallback {
    void onRefundCompleted(Bundle bundle);

    void onRefundFailed(String str);
}
