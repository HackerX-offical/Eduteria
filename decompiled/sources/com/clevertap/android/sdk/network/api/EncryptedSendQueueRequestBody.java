package com.clevertap.android.sdk.network.api;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EncryptedSendQueueRequestBody.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/clevertap/android/sdk/network/api/EncryptedSendQueueRequestBody;", "", "encryptedPayload", "", "key", "iv", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEncryptedPayload", "()Ljava/lang/String;", "getKey", "getIv", "toJsonString", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class EncryptedSendQueueRequestBody {
    private static final String KEY_ENCRYPTED_PAYLOAD = "itp";
    private static final String KEY_IV = "itv";
    private static final String KEY_KEY = "itk";
    private final String encryptedPayload;
    private final String iv;
    private final String key;

    public static /* synthetic */ EncryptedSendQueueRequestBody copy$default(EncryptedSendQueueRequestBody encryptedSendQueueRequestBody, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = encryptedSendQueueRequestBody.encryptedPayload;
        }
        if ((i & 2) != 0) {
            str2 = encryptedSendQueueRequestBody.key;
        }
        if ((i & 4) != 0) {
            str3 = encryptedSendQueueRequestBody.iv;
        }
        return encryptedSendQueueRequestBody.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEncryptedPayload() {
        return this.encryptedPayload;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIv() {
        return this.iv;
    }

    public final EncryptedSendQueueRequestBody copy(String encryptedPayload, String key, String iv) {
        Intrinsics.checkNotNullParameter(encryptedPayload, "encryptedPayload");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(iv, "iv");
        return new EncryptedSendQueueRequestBody(encryptedPayload, key, iv);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptedSendQueueRequestBody)) {
            return false;
        }
        EncryptedSendQueueRequestBody encryptedSendQueueRequestBody = (EncryptedSendQueueRequestBody) other;
        return Intrinsics.areEqual(this.encryptedPayload, encryptedSendQueueRequestBody.encryptedPayload) && Intrinsics.areEqual(this.key, encryptedSendQueueRequestBody.key) && Intrinsics.areEqual(this.iv, encryptedSendQueueRequestBody.iv);
    }

    public int hashCode() {
        return (((this.encryptedPayload.hashCode() * 31) + this.key.hashCode()) * 31) + this.iv.hashCode();
    }

    public String toString() {
        return "EncryptedSendQueueRequestBody(encryptedPayload=" + this.encryptedPayload + ", key=" + this.key + ", iv=" + this.iv + ')';
    }

    public EncryptedSendQueueRequestBody(String encryptedPayload, String key, String iv) {
        Intrinsics.checkNotNullParameter(encryptedPayload, "encryptedPayload");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(iv, "iv");
        this.encryptedPayload = encryptedPayload;
        this.key = key;
        this.iv = iv;
    }

    public final String getEncryptedPayload() {
        return this.encryptedPayload;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getIv() {
        return this.iv;
    }

    public final String toJsonString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_ENCRYPTED_PAYLOAD, this.encryptedPayload);
        jSONObject.put(KEY_KEY, this.key);
        jSONObject.put(KEY_IV, this.iv);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
