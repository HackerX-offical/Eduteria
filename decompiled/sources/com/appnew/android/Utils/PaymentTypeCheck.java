package com.appnew.android.Utils;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public interface PaymentTypeCheck {
    void onPaymentType(String mode, JSONObject data);

    void onPaymentTypeCancel();
}
