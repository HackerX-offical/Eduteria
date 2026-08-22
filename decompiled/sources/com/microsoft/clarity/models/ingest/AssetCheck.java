package com.microsoft.clarity.models.ingest;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/microsoft/clarity/models/ingest/AssetCheck;", "", HashElement.ELEMENT, "", "path", "version", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getHash", "()Ljava/lang/String;", "getPath", "getType", "()I", "getVersion", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "toJson", "toJsonObject", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class AssetCheck {
    private final String hash;
    private final String path;
    private final int type;
    private final String version;

    public AssetCheck(String str, String str2, String str3, int i) {
        this.hash = str;
        this.path = str2;
        this.version = str3;
        this.type = i;
    }

    public static /* synthetic */ AssetCheck copy$default(AssetCheck assetCheck, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = assetCheck.hash;
        }
        if ((i2 & 2) != 0) {
            str2 = assetCheck.path;
        }
        if ((i2 & 4) != 0) {
            str3 = assetCheck.version;
        }
        if ((i2 & 8) != 0) {
            i = assetCheck.type;
        }
        return assetCheck.copy(str, str2, str3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final AssetCheck copy(String hash, String path, String version, int type) {
        return new AssetCheck(hash, path, version, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssetCheck)) {
            return false;
        }
        AssetCheck assetCheck = (AssetCheck) other;
        return Intrinsics.areEqual(this.hash, assetCheck.hash) && Intrinsics.areEqual(this.path, assetCheck.path) && Intrinsics.areEqual(this.version, assetCheck.version) && this.type == assetCheck.type;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.hash;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.path;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.version;
        return Integer.hashCode(this.type) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toJson() {
        String string = toJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toJsonObject().toString()");
        return string;
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(HashElement.ELEMENT, this.hash);
        jSONObject.put("path", this.path);
        jSONObject.put("version", this.version);
        jSONObject.put("type", this.type);
        return jSONObject;
    }

    public String toString() {
        return b.a("AssetCheck(hash=").append(this.hash).append(", path=").append(this.path).append(", version=").append(this.version).append(", type=").append(this.type).append(')').toString();
    }
}
