package com.clevertap.android.sdk.inbox;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTInboxImageData.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/clevertap/android/sdk/inbox/CTInboxImageData;", "", "url", "", "contentDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getContentDescription", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class CTInboxImageData {
    private final String contentDescription;
    private final String url;

    public static /* synthetic */ CTInboxImageData copy$default(CTInboxImageData cTInboxImageData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cTInboxImageData.url;
        }
        if ((i & 2) != 0) {
            str2 = cTInboxImageData.contentDescription;
        }
        return cTInboxImageData.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final CTInboxImageData copy(String url, String contentDescription) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        return new CTInboxImageData(url, contentDescription);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CTInboxImageData)) {
            return false;
        }
        CTInboxImageData cTInboxImageData = (CTInboxImageData) other;
        return Intrinsics.areEqual(this.url, cTInboxImageData.url) && Intrinsics.areEqual(this.contentDescription, cTInboxImageData.contentDescription);
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.contentDescription.hashCode();
    }

    public String toString() {
        return "CTInboxImageData(url=" + this.url + ", contentDescription=" + this.contentDescription + ')';
    }

    public CTInboxImageData(String url, String contentDescription) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        this.url = url;
        this.contentDescription = contentDescription;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }
}
