package com.paytm.pgsdk;

import android.os.Bundle;

/* JADX INFO: loaded from: classes9.dex */
public interface PaytmStatusQueryCallback {
    void onStatusQueryCompleted(Bundle bundle);

    void onStatusQueryFailed(String str);
}
