package com.pallycon.widevine.model;

import android.os.Build;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.media3.common.C;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.pallycon.widevine.exception.PallyConException;
import h.a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006By\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010!\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J\u007f\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020(HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020(HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R#\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00066"}, d2 = {"Lcom/pallycon/widevine/model/PallyConDrmConfigration;", "Landroid/os/Parcelable;", "token", "", "(Ljava/lang/String;)V", "siteId", "(Ljava/lang/String;Ljava/lang/String;)V", "siteKey", "customData", "httpHeaders", "", "cookie", "licenseCipherPath", "drmLicenseUrl", "uuid", "Ljava/util/UUID;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;)V", "getCookie", "()Ljava/lang/String;", "getCustomData", "getDrmLicenseUrl", "getHttpHeaders", "()Ljava/util/Map;", "getLicenseCipherPath", "getSiteId", "getSiteKey", "getToken", "getUuid", "()Ljava/util/UUID;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", Constants.COPY_TYPE, "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PallyConDrmConfigration implements Parcelable {
    private final String cookie;
    private final String customData;
    private final String drmLicenseUrl;
    private final Map<String, String> httpHeaders;
    private final String licenseCipherPath;
    private final String siteId;
    private final String siteKey;
    private final String token;
    private final UUID uuid;
    private static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<PallyConDrmConfigration> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0010\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003J \u0010\u0018\u001a\u00020\u00002\u0018\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/pallycon/widevine/model/PallyConDrmConfigration$Builder;", "", "siteId", "", "token", "(Ljava/lang/String;Ljava/lang/String;)V", "()V", "cookie", "customData", "drmLicenseUrl", "httpHeaders", "", "licenseCipherPath", "siteKey", "uuid", "Ljava/util/UUID;", "addHttpHeader", "key", "value", InAppPurchaseConstants.METHOD_BUILD, "Lcom/pallycon/widevine/model/PallyConDrmConfigration;", "setCookie", "setCustomData", "setDrmLicenseUrl", "setHttpHeaders", "setLicenseCipherPath", "setSiteId", "setSiteKey", "setToken", "setUuid", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private String cookie;
        private String customData;
        private String drmLicenseUrl;
        private Map<String, String> httpHeaders;
        private String licenseCipherPath;
        private String siteId;
        private String siteKey;
        private String token;
        private UUID uuid;

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

        public final PallyConDrmConfigration build() {
            String str = this.siteId;
            if (str == null) {
                str = "FIXD";
            }
            String str2 = str;
            if (this.token == null && this.customData == null) {
                throw new PallyConException.ContentDataException(null, "you have to input the token or customData");
            }
            String str3 = this.drmLicenseUrl;
            if (str3 == null) {
                str3 = a.f1317b;
            }
            String str4 = str3;
            UUID WIDEVINE_UUID = this.uuid;
            if (WIDEVINE_UUID == null) {
                WIDEVINE_UUID = C.WIDEVINE_UUID;
                Intrinsics.checkNotNullExpressionValue(WIDEVINE_UUID, "WIDEVINE_UUID");
            }
            return new PallyConDrmConfigration(str2, this.siteKey, this.token, this.customData, this.httpHeaders, this.cookie, this.licenseCipherPath, str4, WIDEVINE_UUID);
        }

        public final Builder setCookie(String cookie) {
            this.cookie = cookie;
            return this;
        }

        public final Builder setCustomData(String customData) {
            this.customData = customData;
            return this;
        }

        public final Builder setDrmLicenseUrl(String drmLicenseUrl) {
            this.drmLicenseUrl = drmLicenseUrl;
            return this;
        }

        public final Builder setHttpHeaders(Map<String, String> httpHeaders) {
            this.httpHeaders = httpHeaders;
            return this;
        }

        public final Builder setLicenseCipherPath(String licenseCipherPath) {
            this.licenseCipherPath = licenseCipherPath;
            return this;
        }

        public final Builder setSiteId(String siteId) {
            Intrinsics.checkNotNullParameter(siteId, "siteId");
            this.siteId = siteId;
            return this;
        }

        public final Builder setSiteKey(String siteKey) {
            this.siteKey = siteKey;
            return this;
        }

        public final Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public final Builder setUuid(UUID uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            this.uuid = uuid;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(String siteId, String token) {
            this();
            Intrinsics.checkNotNullParameter(siteId, "siteId");
            Intrinsics.checkNotNullParameter(token, "token");
            this.siteId = siteId;
            this.token = token;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/pallycon/widevine/model/PallyConDrmConfigration$Companion;", "Lkotlinx/parcelize/Parceler;", "Lcom/pallycon/widevine/model/PallyConDrmConfigration;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements Parceler<PallyConDrmConfigration> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.parcelize.Parceler
        public PallyConDrmConfigration[] newArray(int i) {
            return (PallyConDrmConfigration[]) Parceler.DefaultImpls.newArray(this, i);
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.parcelize.Parceler
        public PallyConDrmConfigration create(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            if (string == null) {
                throw new PallyConException.ContentDataException(null, "siteId is not defined");
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            if (string3 == null && string4 == null) {
                throw new PallyConException.ContentDataException(null, "you have to input the token or customData");
            }
            int i = parcel.readInt();
            if (i > 0) {
                linkedHashMap = new LinkedHashMap();
                for (int i2 = 0; i2 < i; i2++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            } else {
                linkedHashMap = null;
            }
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            if (string7 == null) {
                string7 = a.f1317b;
            }
            String str = string7;
            ParcelUuid parcelUuid = Build.VERSION.SDK_INT >= 33 ? (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader(), ParcelUuid.class) : (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
            if (parcelUuid == null) {
                throw new PallyConException.ContentDataException(null, "have to uuid");
            }
            UUID uuid = parcelUuid.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            return new PallyConDrmConfigration(string, string2, string3, string4, linkedHashMap, string5, string6, str, uuid);
        }

        @Override // kotlinx.parcelize.Parceler
        public void write(PallyConDrmConfigration pallyConDrmConfigration, Parcel parcel, int i) {
            Unit unit;
            Intrinsics.checkNotNullParameter(pallyConDrmConfigration, "<this>");
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(pallyConDrmConfigration.getSiteId());
            parcel.writeString(pallyConDrmConfigration.getSiteKey());
            parcel.writeString(pallyConDrmConfigration.getToken());
            parcel.writeString(pallyConDrmConfigration.getCustomData());
            Map<String, String> httpHeaders = pallyConDrmConfigration.getHttpHeaders();
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
            parcel.writeString(pallyConDrmConfigration.getCookie());
            parcel.writeString(pallyConDrmConfigration.getLicenseCipherPath());
            parcel.writeString(pallyConDrmConfigration.getDrmLicenseUrl());
            parcel.writeParcelable(new ParcelUuid(pallyConDrmConfigration.getUuid()), i);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PallyConDrmConfigration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PallyConDrmConfigration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return PallyConDrmConfigration.Companion.create(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PallyConDrmConfigration[] newArray(int i) {
            return new PallyConDrmConfigration[i];
        }
    }

    public PallyConDrmConfigration(String siteId, String str, String str2, String str3, Map<String, String> map, String str4, String str5, String drmLicenseUrl, UUID uuid) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(drmLicenseUrl, "drmLicenseUrl");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.siteId = siteId;
        this.siteKey = str;
        this.token = str2;
        this.customData = str3;
        this.httpHeaders = map;
        this.cookie = str4;
        this.licenseCipherPath = str5;
        this.drmLicenseUrl = drmLicenseUrl;
        this.uuid = uuid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PallyConDrmConfigration copy$default(PallyConDrmConfigration pallyConDrmConfigration, String str, String str2, String str3, String str4, Map map, String str5, String str6, String str7, UUID uuid, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pallyConDrmConfigration.siteId;
        }
        if ((i & 2) != 0) {
            str2 = pallyConDrmConfigration.siteKey;
        }
        if ((i & 4) != 0) {
            str3 = pallyConDrmConfigration.token;
        }
        if ((i & 8) != 0) {
            str4 = pallyConDrmConfigration.customData;
        }
        if ((i & 16) != 0) {
            map = pallyConDrmConfigration.httpHeaders;
        }
        if ((i & 32) != 0) {
            str5 = pallyConDrmConfigration.cookie;
        }
        if ((i & 64) != 0) {
            str6 = pallyConDrmConfigration.licenseCipherPath;
        }
        if ((i & 128) != 0) {
            str7 = pallyConDrmConfigration.drmLicenseUrl;
        }
        if ((i & 256) != 0) {
            uuid = pallyConDrmConfigration.uuid;
        }
        String str8 = str7;
        UUID uuid2 = uuid;
        String str9 = str5;
        String str10 = str6;
        Map map2 = map;
        String str11 = str3;
        return pallyConDrmConfigration.copy(str, str2, str11, str4, map2, str9, str10, str8, uuid2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSiteKey() {
        return this.siteKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCustomData() {
        return this.customData;
    }

    public final Map<String, String> component5() {
        return this.httpHeaders;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLicenseCipherPath() {
        return this.licenseCipherPath;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDrmLicenseUrl() {
        return this.drmLicenseUrl;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final UUID getUuid() {
        return this.uuid;
    }

    public final PallyConDrmConfigration copy(String siteId, String siteKey, String token, String customData, Map<String, String> httpHeaders, String cookie, String licenseCipherPath, String drmLicenseUrl, UUID uuid) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(drmLicenseUrl, "drmLicenseUrl");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new PallyConDrmConfigration(siteId, siteKey, token, customData, httpHeaders, cookie, licenseCipherPath, drmLicenseUrl, uuid);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PallyConDrmConfigration)) {
            return false;
        }
        PallyConDrmConfigration pallyConDrmConfigration = (PallyConDrmConfigration) other;
        return Intrinsics.areEqual(this.siteId, pallyConDrmConfigration.siteId) && Intrinsics.areEqual(this.siteKey, pallyConDrmConfigration.siteKey) && Intrinsics.areEqual(this.token, pallyConDrmConfigration.token) && Intrinsics.areEqual(this.customData, pallyConDrmConfigration.customData) && Intrinsics.areEqual(this.httpHeaders, pallyConDrmConfigration.httpHeaders) && Intrinsics.areEqual(this.cookie, pallyConDrmConfigration.cookie) && Intrinsics.areEqual(this.licenseCipherPath, pallyConDrmConfigration.licenseCipherPath) && Intrinsics.areEqual(this.drmLicenseUrl, pallyConDrmConfigration.drmLicenseUrl) && Intrinsics.areEqual(this.uuid, pallyConDrmConfigration.uuid);
    }

    public final String getCookie() {
        return this.cookie;
    }

    public final String getCustomData() {
        return this.customData;
    }

    public final String getDrmLicenseUrl() {
        return this.drmLicenseUrl;
    }

    public final Map<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public final String getLicenseCipherPath() {
        return this.licenseCipherPath;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final String getSiteKey() {
        return this.siteKey;
    }

    public final String getToken() {
        return this.token;
    }

    public final UUID getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int iHashCode = this.siteId.hashCode() * 31;
        String str = this.siteKey;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.token;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.customData;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, String> map = this.httpHeaders;
        int iHashCode5 = (iHashCode4 + (map == null ? 0 : map.hashCode())) * 31;
        String str4 = this.cookie;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.licenseCipherPath;
        return ((((iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.drmLicenseUrl.hashCode()) * 31) + this.uuid.hashCode();
    }

    public String toString() {
        return "PallyConDrmConfigration(siteId=" + this.siteId + ", siteKey=" + this.siteKey + ", token=" + this.token + ", customData=" + this.customData + ", httpHeaders=" + this.httpHeaders + ", cookie=" + this.cookie + ", licenseCipherPath=" + this.licenseCipherPath + ", drmLicenseUrl=" + this.drmLicenseUrl + ", uuid=" + this.uuid + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Companion.write(this, parcel, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PallyConDrmConfigration(String str, String str2, String str3, String str4, Map map, String str5, String str6, String str7, UUID WIDEVINE_UUID, int i, DefaultConstructorMarker defaultConstructorMarker) {
        str2 = (i & 2) != 0 ? null : str2;
        str3 = (i & 4) != 0 ? null : str3;
        str4 = (i & 8) != 0 ? null : str4;
        map = (i & 16) != 0 ? null : map;
        str5 = (i & 32) != 0 ? null : str5;
        str6 = (i & 64) != 0 ? null : str6;
        str7 = (i & 128) != 0 ? a.f1317b : str7;
        if ((i & 256) != 0) {
            WIDEVINE_UUID = C.WIDEVINE_UUID;
            Intrinsics.checkNotNullExpressionValue(WIDEVINE_UUID, "WIDEVINE_UUID");
        }
        this(str, str2, str3, str4, map, str5, str6, str7, WIDEVINE_UUID);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PallyConDrmConfigration(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        UUID WIDEVINE_UUID = C.WIDEVINE_UUID;
        Intrinsics.checkNotNullExpressionValue(WIDEVINE_UUID, "WIDEVINE_UUID");
        this("FIXD", null, token, null, null, null, null, a.f1317b, WIDEVINE_UUID);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PallyConDrmConfigration(String siteId, String token) {
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(token, "token");
        UUID WIDEVINE_UUID = C.WIDEVINE_UUID;
        Intrinsics.checkNotNullExpressionValue(WIDEVINE_UUID, "WIDEVINE_UUID");
        this(siteId, null, token, null, null, null, null, a.f1317b, WIDEVINE_UUID);
    }
}
