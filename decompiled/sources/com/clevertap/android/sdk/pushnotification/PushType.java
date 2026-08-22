package com.clevertap.android.sdk.pushnotification;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PushType {
    private final String ctProviderClassName;
    private final String messagingSDKClassName;
    private final String tokenPrefKey;
    private final String type;

    public PushType(String str, String str2, String str3, String str4) {
        this.type = str;
        this.tokenPrefKey = str2;
        this.ctProviderClassName = str3;
        this.messagingSDKClassName = str4;
    }

    public String getCtProviderClassName() {
        return this.ctProviderClassName;
    }

    public String getMessagingSDKClassName() {
        return this.messagingSDKClassName;
    }

    public String getTokenPrefKey() {
        return this.tokenPrefKey;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return " [PushType:" + this.type + "] ";
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ctProviderClassName", this.ctProviderClassName);
            jSONObject.put("messagingSDKClassName", this.messagingSDKClassName);
            jSONObject.put("tokenPrefKey", this.tokenPrefKey);
            jSONObject.put("type", this.type);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static PushType fromJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("ctProviderClassName");
            String string2 = jSONObject.getString("messagingSDKClassName");
            return new PushType(jSONObject.getString("type"), jSONObject.getString("tokenPrefKey"), string, string2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushType)) {
            return false;
        }
        PushType pushType = (PushType) obj;
        return Objects.equals(this.ctProviderClassName, pushType.ctProviderClassName) && Objects.equals(this.messagingSDKClassName, pushType.messagingSDKClassName) && Objects.equals(this.tokenPrefKey, pushType.tokenPrefKey) && Objects.equals(this.type, pushType.type);
    }

    public int hashCode() {
        return Objects.hash(this.ctProviderClassName, this.messagingSDKClassName, this.tokenPrefKey, this.type);
    }
}
