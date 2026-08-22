package com.clevertap.android.sdk.network.api;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EncryptedResponseBody.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/sdk/network/api/EncryptedResponseBody;", "", "encryptedPayload", "", "iv", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEncryptedPayload", "()Ljava/lang/String;", "getIv", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class EncryptedResponseBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String encryptedPayload;
    private final String iv;

    public static /* synthetic */ EncryptedResponseBody copy$default(EncryptedResponseBody encryptedResponseBody, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = encryptedResponseBody.encryptedPayload;
        }
        if ((i & 2) != 0) {
            str2 = encryptedResponseBody.iv;
        }
        return encryptedResponseBody.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEncryptedPayload() {
        return this.encryptedPayload;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIv() {
        return this.iv;
    }

    public final EncryptedResponseBody copy(String encryptedPayload, String iv) {
        Intrinsics.checkNotNullParameter(encryptedPayload, "encryptedPayload");
        Intrinsics.checkNotNullParameter(iv, "iv");
        return new EncryptedResponseBody(encryptedPayload, iv);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptedResponseBody)) {
            return false;
        }
        EncryptedResponseBody encryptedResponseBody = (EncryptedResponseBody) other;
        return Intrinsics.areEqual(this.encryptedPayload, encryptedResponseBody.encryptedPayload) && Intrinsics.areEqual(this.iv, encryptedResponseBody.iv);
    }

    public int hashCode() {
        return (this.encryptedPayload.hashCode() * 31) + this.iv.hashCode();
    }

    public String toString() {
        return "EncryptedResponseBody(encryptedPayload=" + this.encryptedPayload + ", iv=" + this.iv + ')';
    }

    public EncryptedResponseBody(String encryptedPayload, String iv) {
        Intrinsics.checkNotNullParameter(encryptedPayload, "encryptedPayload");
        Intrinsics.checkNotNullParameter(iv, "iv");
        this.encryptedPayload = encryptedPayload;
        this.iv = iv;
    }

    public final String getEncryptedPayload() {
        return this.encryptedPayload;
    }

    public final String getIv() {
        return this.iv;
    }

    /* JADX INFO: compiled from: EncryptedResponseBody.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/network/api/EncryptedResponseBody$Companion;", "", "<init>", "()V", "fromJsonString", "Lcom/clevertap/android/sdk/network/api/EncryptedResponseBody;", "json", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EncryptedResponseBody fromJsonString(String json) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            JSONObject jSONObject = new JSONObject(json);
            String string = jSONObject.getString("itp");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = jSONObject.getString("itv");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return new EncryptedResponseBody(string, string2);
        }
    }
}
