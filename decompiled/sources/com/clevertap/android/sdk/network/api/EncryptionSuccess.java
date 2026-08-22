package com.clevertap.android.sdk.network.api;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncryptionResult.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/sdk/network/api/EncryptionSuccess;", "Lcom/clevertap/android/sdk/network/api/EncryptionResult;", "data", "", "iv", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getIv", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class EncryptionSuccess extends EncryptionResult {
    private final String data;
    private final String iv;

    public static /* synthetic */ EncryptionSuccess copy$default(EncryptionSuccess encryptionSuccess, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = encryptionSuccess.data;
        }
        if ((i & 2) != 0) {
            str2 = encryptionSuccess.iv;
        }
        return encryptionSuccess.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIv() {
        return this.iv;
    }

    public final EncryptionSuccess copy(String data, String iv) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(iv, "iv");
        return new EncryptionSuccess(data, iv);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptionSuccess)) {
            return false;
        }
        EncryptionSuccess encryptionSuccess = (EncryptionSuccess) other;
        return Intrinsics.areEqual(this.data, encryptionSuccess.data) && Intrinsics.areEqual(this.iv, encryptionSuccess.iv);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.iv.hashCode();
    }

    public String toString() {
        return "EncryptionSuccess(data=" + this.data + ", iv=" + this.iv + ')';
    }

    public final String getData() {
        return this.data;
    }

    public final String getIv() {
        return this.iv;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptionSuccess(String data, String iv) {
        super(null);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(iv, "iv");
        this.data = data;
        this.iv = iv;
    }
}
