package com.appnew.android.feeds.dataclass;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/feeds/dataclass/BannerData;", "", "id", "", "url", "target_meta", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getTarget_meta", "setTarget_meta", "component1", "component2", "component3", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class BannerData {
    public static final int $stable = 8;
    private String id;
    private String target_meta;
    private String url;

    public static /* synthetic */ BannerData copy$default(BannerData bannerData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bannerData.id;
        }
        if ((i & 2) != 0) {
            str2 = bannerData.url;
        }
        if ((i & 4) != 0) {
            str3 = bannerData.target_meta;
        }
        return bannerData.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTarget_meta() {
        return this.target_meta;
    }

    public final BannerData copy(String id, String url, String target_meta) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(target_meta, "target_meta");
        return new BannerData(id, url, target_meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannerData)) {
            return false;
        }
        BannerData bannerData = (BannerData) other;
        return Intrinsics.areEqual(this.id, bannerData.id) && Intrinsics.areEqual(this.url, bannerData.url) && Intrinsics.areEqual(this.target_meta, bannerData.target_meta);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.url.hashCode()) * 31) + this.target_meta.hashCode();
    }

    public String toString() {
        return "BannerData(id=" + this.id + ", url=" + this.url + ", target_meta=" + this.target_meta + ")";
    }

    public BannerData(String id, String url, String target_meta) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(target_meta, "target_meta");
        this.id = id;
        this.url = url;
        this.target_meta = target_meta;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTarget_meta() {
        return this.target_meta;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setTarget_meta(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.target_meta = str;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}
