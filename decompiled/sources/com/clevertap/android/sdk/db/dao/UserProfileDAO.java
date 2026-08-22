package com.clevertap.android.sdk.db.dao;

import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: UserProfileDAO.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H'¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/db/dao/UserProfileDAO;", "", "storeUserProfile", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", Constants.DEVICE_ID_TAG, "profile", "Lorg/json/JSONObject;", "fetchUserProfilesByAccountId", "", "fetchUserProfile", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UserProfileDAO {
    JSONObject fetchUserProfile(String accountId, String deviceId);

    Map<String, JSONObject> fetchUserProfilesByAccountId(String accountId);

    long storeUserProfile(String accountId, String deviceId, JSONObject profile);
}
