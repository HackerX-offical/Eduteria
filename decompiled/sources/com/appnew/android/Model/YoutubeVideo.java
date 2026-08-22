package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YoutubeVideo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/Model/YoutubeVideo;", "", "data", "", "Lcom/appnew/android/Model/YoutubeVideoData;", "message", "", "status", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "getData", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "getStatus", "()Z", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class YoutubeVideo {
    public static final int $stable = 8;
    private final List<YoutubeVideoData> data;
    private final String message;
    private final boolean status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ YoutubeVideo copy$default(YoutubeVideo youtubeVideo, List list, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = youtubeVideo.data;
        }
        if ((i & 2) != 0) {
            str = youtubeVideo.message;
        }
        if ((i & 4) != 0) {
            z = youtubeVideo.status;
        }
        return youtubeVideo.copy(list, str, z);
    }

    public final List<YoutubeVideoData> component1() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    public final YoutubeVideo copy(List<YoutubeVideoData> data, String message, boolean status) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        return new YoutubeVideo(data, message, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YoutubeVideo)) {
            return false;
        }
        YoutubeVideo youtubeVideo = (YoutubeVideo) other;
        return Intrinsics.areEqual(this.data, youtubeVideo.data) && Intrinsics.areEqual(this.message, youtubeVideo.message) && this.status == youtubeVideo.status;
    }

    public int hashCode() {
        return (((this.data.hashCode() * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.status);
    }

    public String toString() {
        return "YoutubeVideo(data=" + this.data + ", message=" + this.message + ", status=" + this.status + ")";
    }

    public YoutubeVideo(List<YoutubeVideoData> data, String message, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        this.data = data;
        this.message = message;
        this.status = z;
    }

    public final List<YoutubeVideoData> getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getStatus() {
        return this.status;
    }
}
