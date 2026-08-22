package com.example.paytm_gateway;

import kotlin.Metadata;

/* JADX INFO: compiled from: PaytmConst.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/paytm_gateway/PaytmConst;", "", "<init>", "()V", "CALLBACK_URL_TEST", "", "CALLBACK_URL_LIVE", "SHOW_PAYMENT_URL_TEST", "SHOW_PAYMENT_URL_LIVE", "MID_TEST", "MID_LIVE", "paytm_gateway_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaytmConst {
    public static final String CALLBACK_URL_LIVE = "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=";
    public static final String CALLBACK_URL_TEST = "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=";
    public static final PaytmConst INSTANCE = new PaytmConst();
    public static final String MID_LIVE = "vyKtLE92667053853484";
    public static final String MID_TEST = "vyKtLE92667053853484";
    public static final String SHOW_PAYMENT_URL_LIVE = "https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage";
    public static final String SHOW_PAYMENT_URL_TEST = "https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage";

    private PaytmConst() {
    }
}
