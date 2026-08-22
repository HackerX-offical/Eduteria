package com.clevertap.android.sdk.login;

import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: ChangeUserCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/sdk/login/ChangeUserCallback;", "", "onChangeUser", "", Constants.DEVICE_ID_TAG, "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ChangeUserCallback {
    void onChangeUser(String deviceId, String accountId);
}
