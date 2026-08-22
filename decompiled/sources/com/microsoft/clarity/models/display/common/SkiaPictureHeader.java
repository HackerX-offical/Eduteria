package com.microsoft.clarity.models.display.common;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/microsoft/clarity/models/display/common/SkiaPictureHeader;", "", "pictureVersion", "", "(J)V", "getPictureVersion", "()J", "component1", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class SkiaPictureHeader {
    private final long pictureVersion;

    public SkiaPictureHeader(long j) {
        this.pictureVersion = j;
    }

    public static /* synthetic */ SkiaPictureHeader copy$default(SkiaPictureHeader skiaPictureHeader, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = skiaPictureHeader.pictureVersion;
        }
        return skiaPictureHeader.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPictureVersion() {
        return this.pictureVersion;
    }

    public final SkiaPictureHeader copy(long pictureVersion) {
        return new SkiaPictureHeader(pictureVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SkiaPictureHeader) && this.pictureVersion == ((SkiaPictureHeader) other).pictureVersion;
    }

    public final long getPictureVersion() {
        return this.pictureVersion;
    }

    public int hashCode() {
        return Long.hashCode(this.pictureVersion);
    }

    public String toString() {
        return b.a("SkiaPictureHeader(pictureVersion=").append(this.pictureVersion).append(')').toString();
    }
}
