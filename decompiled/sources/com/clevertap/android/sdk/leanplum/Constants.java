package com.clevertap.android.sdk.leanplum;

import kotlin.Metadata;

/* JADX INFO: compiled from: Constants.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/leanplum/Constants;", "", "<init>", "()V", "IDENTITY", "", "STATE_PREFIX", "CHARGED_EVENT_PARAM", "VALUE_PARAM", "CURRENCY_CODE_PARAM", "INFO_PARAM", "GP_PURCHASE_DATA_PARAM", "GP_PURCHASE_DATA_SIGNATURE_PARAM", "IAP_ITEM_PARAM", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Constants {
    public static final String CHARGED_EVENT_PARAM = "event";
    public static final String CURRENCY_CODE_PARAM = "currencyCode";
    public static final String GP_PURCHASE_DATA_PARAM = "googlePlayPurchaseData";
    public static final String GP_PURCHASE_DATA_SIGNATURE_PARAM = "googlePlayPurchaseDataSignature";
    public static final String IAP_ITEM_PARAM = "item";
    public static final String IDENTITY = "Identity";
    public static final String INFO_PARAM = "info";
    public static final Constants INSTANCE = new Constants();
    public static final String STATE_PREFIX = "state_";
    public static final String VALUE_PARAM = "value";

    private Constants() {
    }
}
