package com.clevertap.android.sdk.inapp.store.db;

import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.cryption.CryptHandler;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.db.DelayedLegacyInAppDAO;
import com.clevertap.android.sdk.db.DelayedLegacyInAppData;
import com.clevertap.android.sdk.inapp.data.InAppDelayConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DelayedLegacyInAppStore.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0007J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\tH\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/clevertap/android/sdk/inapp/store/db/DelayedLegacyInAppStore;", "", "delayedLegacyInAppDAO", "Lcom/clevertap/android/sdk/db/DelayedLegacyInAppDAO;", "cryptHandler", "Lcom/clevertap/android/sdk/cryption/CryptHandler;", "logger", "Lcom/clevertap/android/sdk/ILogger;", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", "<init>", "(Lcom/clevertap/android/sdk/db/DelayedLegacyInAppDAO;Lcom/clevertap/android/sdk/cryption/CryptHandler;Lcom/clevertap/android/sdk/ILogger;Ljava/lang/String;)V", "saveDelayedInAppsBatch", "", "delayedInApps", "Lorg/json/JSONArray;", "getDelayedInApp", "Lorg/json/JSONObject;", Column.INAPP_ID, "removeDelayedInApp", "removeDelayedInAppsBatch", "", "inAppIds", "", "hasDelayedInApp", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DelayedLegacyInAppStore {
    private final String accountId;
    private final CryptHandler cryptHandler;
    private final DelayedLegacyInAppDAO delayedLegacyInAppDAO;
    private final ILogger logger;

    public DelayedLegacyInAppStore(DelayedLegacyInAppDAO delayedLegacyInAppDAO, CryptHandler cryptHandler, ILogger logger, String accountId) {
        Intrinsics.checkNotNullParameter(delayedLegacyInAppDAO, "delayedLegacyInAppDAO");
        Intrinsics.checkNotNullParameter(cryptHandler, "cryptHandler");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        this.delayedLegacyInAppDAO = delayedLegacyInAppDAO;
        this.cryptHandler = cryptHandler;
        this.logger = logger;
        this.accountId = accountId;
    }

    public final boolean saveDelayedInAppsBatch(JSONArray delayedInApps) throws JSONException {
        Intrinsics.checkNotNullParameter(delayedInApps, "delayedInApps");
        if (delayedInApps.length() == 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        int length = delayedInApps.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = delayedInApps.get(i2);
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                String strOptString = jSONObject.optString(Constants.INAPP_ID_IN_PAYLOAD);
                int iOptInt = jSONObject.optInt(InAppDelayConstants.INAPP_DELAY_AFTER_TRIGGER);
                CryptHandler cryptHandler = this.cryptHandler;
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String strEncrypt = cryptHandler.encrypt(string);
                if (strEncrypt == null) {
                    this.logger.verbose(this.accountId, "Failed to encrypt delayed in-app: " + strOptString + ". Skipping this item.");
                    i++;
                } else {
                    Intrinsics.checkNotNull(strOptString);
                    arrayList.add(new DelayedLegacyInAppData(strOptString, iOptInt, strEncrypt));
                }
            }
        }
        if (arrayList.isEmpty()) {
            this.logger.verbose(this.accountId, "No delayed in-apps to save. All items failed encryption or parsing.");
            return false;
        }
        if (i > 0) {
            this.logger.verbose(this.accountId, "Skipped " + i + " delayed in-apps due to encryption failure");
        }
        return this.delayedLegacyInAppDAO.insertBatch(arrayList);
    }

    public final JSONObject getDelayedInApp(String inAppId) {
        Intrinsics.checkNotNullParameter(inAppId, "inAppId");
        String strFetchSingleInApp = this.delayedLegacyInAppDAO.fetchSingleInApp(inAppId);
        if (strFetchSingleInApp == null) {
            return null;
        }
        try {
            String strDecrypt = this.cryptHandler.decrypt(strFetchSingleInApp);
            if (strDecrypt == null) {
                this.logger.verbose(this.accountId, "Failed to decrypt delayed in-app: " + inAppId);
                return null;
            }
            return new JSONObject(strDecrypt);
        } catch (JSONException e2) {
            this.logger.verbose(this.accountId, "Error parsing delayed in-app: " + inAppId, e2);
            return null;
        }
    }

    public final boolean removeDelayedInApp(String inAppId) {
        Intrinsics.checkNotNullParameter(inAppId, "inAppId");
        return this.delayedLegacyInAppDAO.remove(inAppId);
    }

    public final int removeDelayedInAppsBatch(List<String> inAppIds) {
        Intrinsics.checkNotNullParameter(inAppIds, "inAppIds");
        Iterator<T> it = inAppIds.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.delayedLegacyInAppDAO.remove((String) it.next())) {
                i++;
            }
        }
        return i;
    }

    public final boolean hasDelayedInApp(String inAppId) {
        Intrinsics.checkNotNullParameter(inAppId, "inAppId");
        return this.delayedLegacyInAppDAO.fetchSingleInApp(inAppId) != null;
    }
}
