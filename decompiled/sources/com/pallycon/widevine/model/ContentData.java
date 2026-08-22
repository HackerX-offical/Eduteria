package com.pallycon.widevine.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.pallycon.widevine.exception.PallyConException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BQ\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010 \u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003JU\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u00061"}, d2 = {"Lcom/pallycon/widevine/model/ContentData;", "Landroid/os/Parcelable;", "url", "", "drmConfig", "Lcom/pallycon/widevine/model/PallyConDrmConfigration;", "(Ljava/lang/String;Lcom/pallycon/widevine/model/PallyConDrmConfigration;)V", "contentId", "cookie", "httpHeaders", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/pallycon/widevine/model/PallyConDrmConfigration;Ljava/lang/String;Ljava/util/Map;)V", "getContentId", "()Ljava/lang/String;", "setContentId", "(Ljava/lang/String;)V", "getCookie", "setCookie", "getDrmConfig", "()Lcom/pallycon/widevine/model/PallyConDrmConfigration;", "setDrmConfig", "(Lcom/pallycon/widevine/model/PallyConDrmConfigration;)V", "getHttpHeaders", "()Ljava/util/Map;", "setHttpHeaders", "(Ljava/util/Map;)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ContentData implements Parcelable {
    private String contentId;
    private String cookie;
    private PallyConDrmConfigration drmConfig;
    private Map<String, String> httpHeaders;
    private String url;
    private static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ContentData> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003J \u0010\u0013\u001a\u00020\u00002\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/pallycon/widevine/model/ContentData$Builder;", "", "url", "", "drmConfig", "Lcom/pallycon/widevine/model/PallyConDrmConfigration;", "(Ljava/lang/String;Lcom/pallycon/widevine/model/PallyConDrmConfigration;)V", "()V", "contentId", "cookie", "httpHeaders", "", "addHttpHeader", "key", "value", InAppPurchaseConstants.METHOD_BUILD, "", "setContentId", "setCookie", "setHttpHeaders", "", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private String contentId;
        private String cookie;
        private PallyConDrmConfigration drmConfig;
        private Map<String, String> httpHeaders;
        private String url;

        public Builder() {
        }

        public final Builder addHttpHeader(String key, String value) {
            if (this.httpHeaders == null) {
                this.httpHeaders = new LinkedHashMap();
            }
            Map<String, String> map = this.httpHeaders;
            if (map != null) {
                map.put(key, value);
            }
            return this;
        }

        public final void build() {
            String str = this.url;
            if (str == null) {
                throw new PallyConException.ContentDataException(null, "url must not be empty");
            }
            PallyConDrmConfigration pallyConDrmConfigration = this.drmConfig;
            if (pallyConDrmConfigration == null) {
                throw new PallyConException.ContentDataException(null, "drmConfig must not be empty");
            }
            new ContentData(this.contentId, str, pallyConDrmConfigration, this.cookie, this.httpHeaders);
        }

        public final Builder setContentId(String contentId) {
            this.contentId = contentId;
            return this;
        }

        public final Builder setCookie(String cookie) {
            this.cookie = cookie;
            return this;
        }

        public final Builder setHttpHeaders(Map<String, String> httpHeaders) {
            this.httpHeaders = httpHeaders != null ? MapsKt.toMutableMap(httpHeaders) : null;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(String url, PallyConDrmConfigration drmConfig) {
            this();
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(drmConfig, "drmConfig");
            this.url = url;
            this.drmConfig = drmConfig;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/pallycon/widevine/model/ContentData$Companion;", "Lkotlinx/parcelize/Parceler;", "Lcom/pallycon/widevine/model/ContentData;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements Parceler<ContentData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.parcelize.Parceler
        public ContentData[] newArray(int i) {
            return (ContentData[]) Parceler.DefaultImpls.newArray(this, i);
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.parcelize.Parceler
        public ContentData create(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            PallyConDrmConfigration pallyConDrmConfigration = Build.VERSION.SDK_INT >= 33 ? (PallyConDrmConfigration) parcel.readParcelable(PallyConDrmConfigration.class.getClassLoader(), PallyConDrmConfigration.class) : (PallyConDrmConfigration) parcel.readParcelable(PallyConDrmConfigration.class.getClassLoader());
            String string3 = parcel.readString();
            int i = parcel.readInt();
            if (i > 0) {
                linkedHashMap = new LinkedHashMap();
                for (int i2 = 0; i2 < i; i2++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            } else {
                linkedHashMap = null;
            }
            return new ContentData(string, string2, pallyConDrmConfigration, string3, linkedHashMap);
        }

        @Override // kotlinx.parcelize.Parceler
        public void write(ContentData contentData, Parcel parcel, int i) {
            Unit unit;
            Intrinsics.checkNotNullParameter(contentData, "<this>");
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(contentData.getContentId());
            parcel.writeString(contentData.getUrl());
            parcel.writeParcelable(contentData.getDrmConfig(), i);
            parcel.writeString(contentData.getCookie());
            Map<String, String> httpHeaders = contentData.getHttpHeaders();
            if (httpHeaders != null) {
                parcel.writeInt(httpHeaders.size());
                for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    parcel.writeString(key);
                    parcel.writeString(value);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                parcel.writeInt(0);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContentData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContentData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return ContentData.Companion.create(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContentData[] newArray(int i) {
            return new ContentData[i];
        }
    }

    public ContentData() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentData copy$default(ContentData contentData, String str, String str2, PallyConDrmConfigration pallyConDrmConfigration, String str3, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contentData.contentId;
        }
        if ((i & 2) != 0) {
            str2 = contentData.url;
        }
        if ((i & 4) != 0) {
            pallyConDrmConfigration = contentData.drmConfig;
        }
        if ((i & 8) != 0) {
            str3 = contentData.cookie;
        }
        if ((i & 16) != 0) {
            map = contentData.httpHeaders;
        }
        Map map2 = map;
        PallyConDrmConfigration pallyConDrmConfigration2 = pallyConDrmConfigration;
        return contentData.copy(str, str2, pallyConDrmConfigration2, str3, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContentId() {
        return this.contentId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PallyConDrmConfigration getDrmConfig() {
        return this.drmConfig;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    public final Map<String, String> component5() {
        return this.httpHeaders;
    }

    public final ContentData copy(String contentId, String url, PallyConDrmConfigration drmConfig, String cookie, Map<String, String> httpHeaders) {
        return new ContentData(contentId, url, drmConfig, cookie, httpHeaders);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentData)) {
            return false;
        }
        ContentData contentData = (ContentData) other;
        return Intrinsics.areEqual(this.contentId, contentData.contentId) && Intrinsics.areEqual(this.url, contentData.url) && Intrinsics.areEqual(this.drmConfig, contentData.drmConfig) && Intrinsics.areEqual(this.cookie, contentData.cookie) && Intrinsics.areEqual(this.httpHeaders, contentData.httpHeaders);
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getCookie() {
        return this.cookie;
    }

    public final PallyConDrmConfigration getDrmConfig() {
        return this.drmConfig;
    }

    public final Map<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.contentId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        PallyConDrmConfigration pallyConDrmConfigration = this.drmConfig;
        int iHashCode3 = (iHashCode2 + (pallyConDrmConfigration == null ? 0 : pallyConDrmConfigration.hashCode())) * 31;
        String str3 = this.cookie;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, String> map = this.httpHeaders;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setCookie(String str) {
        this.cookie = str;
    }

    public final void setDrmConfig(PallyConDrmConfigration pallyConDrmConfigration) {
        this.drmConfig = pallyConDrmConfigration;
    }

    public final void setHttpHeaders(Map<String, String> map) {
        this.httpHeaders = map;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "ContentData(contentId=" + this.contentId + ", url=" + this.url + ", drmConfig=" + this.drmConfig + ", cookie=" + this.cookie + ", httpHeaders=" + this.httpHeaders + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Companion.write(this, parcel, flags);
    }

    public ContentData(String str, String str2, PallyConDrmConfigration pallyConDrmConfigration, String str3, Map<String, String> map) {
        this.contentId = str;
        this.url = str2;
        this.drmConfig = pallyConDrmConfigration;
        this.cookie = str3;
        this.httpHeaders = map;
    }

    public /* synthetic */ ContentData(String str, String str2, PallyConDrmConfigration pallyConDrmConfigration, String str3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : pallyConDrmConfigration, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentData(String url, PallyConDrmConfigration drmConfig) {
        this(null, null, null, null, null, 31, null);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(drmConfig, "drmConfig");
        this.contentId = null;
        this.url = url;
        this.drmConfig = drmConfig;
        this.cookie = null;
        this.httpHeaders = null;
    }
}
