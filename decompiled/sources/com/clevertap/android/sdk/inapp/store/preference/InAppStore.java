package com.clevertap.android.sdk.inapp.store.preference;

import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.StoreProvider;
import com.clevertap.android.sdk.cryption.ICryptHandler;
import com.clevertap.android.sdk.login.ChangeUserCallback;
import com.clevertap.android.sdk.store.preference.ICTPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppStore.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\rJ\u0006\u0010#\u001a\u00020\tJ\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\rH\u0002J\u0006\u0010&\u001a\u00020\tJ\u000e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\tJ\u0006\u0010)\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\u0014J\u0018\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006/"}, d2 = {"Lcom/clevertap/android/sdk/inapp/store/preference/InAppStore;", "Lcom/clevertap/android/sdk/login/ChangeUserCallback;", "ctPreference", "Lcom/clevertap/android/sdk/store/preference/ICTPreference;", "cryptHandler", "Lcom/clevertap/android/sdk/cryption/ICryptHandler;", "<init>", "(Lcom/clevertap/android/sdk/store/preference/ICTPreference;Lcom/clevertap/android/sdk/cryption/ICryptHandler;)V", "clientSideInApps", "Lorg/json/JSONArray;", "serverSideInApps", "clientSideDelayedInApps", "value", "", "mode", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "removeClientSideInApps", "", "removeServerSideInAppsMetaData", "storeClientSideInApps", "storeServerSideInAppsMetaData", "serverSideInAppsMetaData", "storeServerSideInApps", "storeEvaluatedServerSideInAppIds", "evaluatedServerSideInAppIds", "storeSuppressedClientSideInAppIds", "suppressedClientSideInAppIds", "readClientSideInApps", "readServerSideInAppsMetaData", "readEvaluatedServerSideInAppIds", "migrateEvaluatedServerSideInAppIds", "evaluatedIds", "readSuppressedClientSideInAppIds", "migrateInAppHeaderPrefsForEventType", "inAppIds", "readServerSideInApps", "storeClientSideDelayedInApps", "delayedInApps", "readClientSideDelayedInApps", "removeClientSideDelayedInApps", "onChangeUser", Constants.DEVICE_ID_TAG, BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppStore implements ChangeUserCallback {
    public static final String CLIENT_SIDE_MODE = "CS";
    public static final String NO_MODE = "NO_MODE";
    public static final String PREFS_DELAYED_INAPP_KEY_CS = "delayed_inapp_notifs_cs";
    public static final String SERVER_SIDE_MODE = "SS";
    private JSONArray clientSideDelayedInApps;
    private JSONArray clientSideInApps;
    private final ICryptHandler cryptHandler;
    private final ICTPreference ctPreference;
    private String mode;
    private JSONArray serverSideInApps;

    public InAppStore(ICTPreference ctPreference, ICryptHandler cryptHandler) {
        Intrinsics.checkNotNullParameter(ctPreference, "ctPreference");
        Intrinsics.checkNotNullParameter(cryptHandler, "cryptHandler");
        this.ctPreference = ctPreference;
        this.cryptHandler = cryptHandler;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        if (Intrinsics.areEqual(this.mode, str)) {
            return;
        }
        this.mode = str;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode == -1437347487) {
                if (str.equals(NO_MODE)) {
                    removeServerSideInAppsMetaData();
                    removeClientSideInApps();
                    removeClientSideDelayedInApps();
                    return;
                }
                return;
            }
            if (iHashCode == 2160) {
                if (str.equals(CLIENT_SIDE_MODE)) {
                    removeServerSideInAppsMetaData();
                }
            } else if (iHashCode == 2656 && str.equals(SERVER_SIDE_MODE)) {
                removeClientSideInApps();
                removeClientSideDelayedInApps();
            }
        }
    }

    private final void removeClientSideInApps() {
        this.ctPreference.remove("inapp_notifs_cs");
        this.clientSideInApps = null;
    }

    private final void removeServerSideInAppsMetaData() {
        this.ctPreference.remove("inapp_notifs_ss");
    }

    public final void storeClientSideInApps(JSONArray clientSideInApps) {
        Intrinsics.checkNotNullParameter(clientSideInApps, "clientSideInApps");
        this.clientSideInApps = clientSideInApps;
        ICryptHandler iCryptHandler = this.cryptHandler;
        String string = clientSideInApps.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strEncrypt = iCryptHandler.encrypt(string);
        if (strEncrypt != null) {
            this.ctPreference.writeString("inapp_notifs_cs", strEncrypt);
        }
    }

    public final void storeServerSideInAppsMetaData(JSONArray serverSideInAppsMetaData) {
        Intrinsics.checkNotNullParameter(serverSideInAppsMetaData, "serverSideInAppsMetaData");
        ICTPreference iCTPreference = this.ctPreference;
        String string = serverSideInAppsMetaData.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        iCTPreference.writeString("inapp_notifs_ss", string);
    }

    public final void storeServerSideInApps(JSONArray serverSideInApps) {
        Intrinsics.checkNotNullParameter(serverSideInApps, "serverSideInApps");
        this.serverSideInApps = serverSideInApps;
        ICryptHandler iCryptHandler = this.cryptHandler;
        String string = serverSideInApps.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strEncrypt = iCryptHandler.encrypt(string);
        if (strEncrypt != null) {
            this.ctPreference.writeString(Constants.INAPP_KEY, strEncrypt);
        }
    }

    public final void storeEvaluatedServerSideInAppIds(JSONArray evaluatedServerSideInAppIds) {
        Intrinsics.checkNotNullParameter(evaluatedServerSideInAppIds, "evaluatedServerSideInAppIds");
        ICTPreference iCTPreference = this.ctPreference;
        String string = evaluatedServerSideInAppIds.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        iCTPreference.writeString(Constants.PREFS_EVALUATED_INAPP_KEY_SS, string);
    }

    public final void storeSuppressedClientSideInAppIds(JSONArray suppressedClientSideInAppIds) {
        Intrinsics.checkNotNullParameter(suppressedClientSideInAppIds, "suppressedClientSideInAppIds");
        ICTPreference iCTPreference = this.ctPreference;
        String string = suppressedClientSideInAppIds.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        iCTPreference.writeString(Constants.PREFS_SUPPRESSED_INAPP_KEY_CS, string);
    }

    public final JSONArray readClientSideInApps() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = this.clientSideInApps;
        if (jSONArray2 != null) {
            Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type org.json.JSONArray");
            return jSONArray2;
        }
        String string = this.ctPreference.readString("inapp_notifs_cs", "");
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = new JSONArray(this.cryptHandler.decrypt(string));
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
        }
        this.clientSideInApps = jSONArray;
        Intrinsics.checkNotNull(jSONArray, "null cannot be cast to non-null type org.json.JSONArray");
        return jSONArray;
    }

    public final JSONArray readServerSideInAppsMetaData() {
        String string = this.ctPreference.readString("inapp_notifs_ss", "");
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            return new JSONArray();
        }
        return new JSONArray(string);
    }

    public final JSONArray readEvaluatedServerSideInAppIds() {
        String string = this.ctPreference.readString(Constants.PREFS_EVALUATED_INAPP_KEY_SS, "");
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            return new JSONArray();
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            return migrateEvaluatedServerSideInAppIds(string);
        }
    }

    public final JSONArray migrateEvaluatedServerSideInAppIds(String evaluatedIds) {
        Intrinsics.checkNotNullParameter(evaluatedIds, "evaluatedIds");
        try {
            JSONObject jSONObject = new JSONObject(evaluatedIds);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(Constants.RAISED);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("profile");
            JSONArray jSONArray = new JSONArray();
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    jSONArray.put(jSONArrayOptJSONArray.get(i));
                }
            }
            if (jSONArrayOptJSONArray2 != null) {
                int length2 = jSONArrayOptJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    jSONArray.put(jSONArrayOptJSONArray2.get(i2));
                }
            }
            return jSONArray;
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public final JSONArray readSuppressedClientSideInAppIds() {
        String string = this.ctPreference.readString(Constants.PREFS_SUPPRESSED_INAPP_KEY_CS, "");
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            return new JSONArray();
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            return migrateInAppHeaderPrefsForEventType(string);
        }
    }

    private final JSONArray migrateInAppHeaderPrefsForEventType(String inAppIds) {
        try {
            JSONObject jSONObject = new JSONObject(inAppIds);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(Constants.RAISED);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("profile");
            JSONArray jSONArray = new JSONArray();
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    jSONArray.put(jSONArrayOptJSONArray.get(i));
                }
            }
            if (jSONArrayOptJSONArray2 != null) {
                int length2 = jSONArrayOptJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    jSONArray.put(jSONArrayOptJSONArray2.get(i2));
                }
            }
            return jSONArray;
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public final JSONArray readServerSideInApps() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = this.serverSideInApps;
        if (jSONArray2 != null) {
            Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type org.json.JSONArray");
            return jSONArray2;
        }
        String string = this.ctPreference.readString(Constants.INAPP_KEY, "");
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = new JSONArray(this.cryptHandler.decrypt(string));
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
        }
        this.serverSideInApps = jSONArray;
        Intrinsics.checkNotNull(jSONArray, "null cannot be cast to non-null type org.json.JSONArray");
        return jSONArray;
    }

    public final void storeClientSideDelayedInApps(JSONArray delayedInApps) {
        Intrinsics.checkNotNullParameter(delayedInApps, "delayedInApps");
        this.clientSideDelayedInApps = delayedInApps;
        ICryptHandler iCryptHandler = this.cryptHandler;
        String string = delayedInApps.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strEncrypt = iCryptHandler.encrypt(string);
        if (strEncrypt != null) {
            this.ctPreference.writeString(PREFS_DELAYED_INAPP_KEY_CS, strEncrypt);
        }
    }

    public final JSONArray readClientSideDelayedInApps() {
        JSONArray jSONArray;
        JSONArray jSONArray2 = this.clientSideDelayedInApps;
        if (jSONArray2 != null) {
            Intrinsics.checkNotNull(jSONArray2, "null cannot be cast to non-null type org.json.JSONArray");
            return jSONArray2;
        }
        String string = this.ctPreference.readString(PREFS_DELAYED_INAPP_KEY_CS, "");
        String str = string;
        if (str == null || StringsKt.isBlank(str)) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = new JSONArray(this.cryptHandler.decrypt(string));
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
        }
        this.clientSideDelayedInApps = jSONArray;
        Intrinsics.checkNotNull(jSONArray, "null cannot be cast to non-null type org.json.JSONArray");
        return jSONArray;
    }

    public final void removeClientSideDelayedInApps() {
        this.ctPreference.remove(PREFS_DELAYED_INAPP_KEY_CS);
        this.clientSideDelayedInApps = null;
    }

    @Override // com.clevertap.android.sdk.login.ChangeUserCallback
    public void onChangeUser(String deviceId, String accountId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        this.ctPreference.changePreferenceName(StoreProvider.INSTANCE.getInstance().constructStorePreferenceName(1, deviceId, accountId));
    }
}
