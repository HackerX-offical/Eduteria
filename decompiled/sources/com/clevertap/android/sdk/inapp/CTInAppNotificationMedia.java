package com.clevertap.android.sdk.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.Constants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: CTInAppNotificationMedia.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0012\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\b\u0010\u0017\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dJ\u0013\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTInAppNotificationMedia;", "Landroid/os/Parcelable;", "mediaUrl", "", "contentType", "contentDescription", "cacheKey", Constants.KEY_ORIENTATION, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getMediaUrl", "()Ljava/lang/String;", "setMediaUrl", "(Ljava/lang/String;)V", "getContentType", "getContentDescription", "getCacheKey", "getOrientation", "()I", "describeContents", "writeToParcel", "", "dest", "flags", "isAudio", "", "isGIF", "isImage", "isVideo", "isMediaStreamable", "equals", "other", "", "hashCode", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNotificationMedia implements Parcelable {
    private final String cacheKey;
    private final String contentDescription;
    private final String contentType;
    private String mediaUrl;
    private final int orientation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<CTInAppNotificationMedia> CREATOR = new Parcelable.Creator<CTInAppNotificationMedia>() { // from class: com.clevertap.android.sdk.inapp.CTInAppNotificationMedia$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CTInAppNotificationMedia createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CTInAppNotificationMedia(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CTInAppNotificationMedia[] newArray(int size) {
            return new CTInAppNotificationMedia[size];
        }
    };

    public /* synthetic */ CTInAppNotificationMedia(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @JvmStatic
    public static final CTInAppNotificationMedia create(JSONObject jSONObject, int i) {
        return INSTANCE.create(jSONObject, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getMediaUrl() {
        return this.mediaUrl;
    }

    public final void setMediaUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaUrl = str;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public CTInAppNotificationMedia(String mediaUrl, String contentType, String contentDescription, String str, int i) {
        Intrinsics.checkNotNullParameter(mediaUrl, "mediaUrl");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        this.mediaUrl = mediaUrl;
        this.contentType = contentType;
        this.contentDescription = contentDescription;
        this.cacheKey = str;
        this.orientation = i;
    }

    private CTInAppNotificationMedia(Parcel parcel) {
        String string = parcel.readString();
        this.mediaUrl = string == null ? "" : string;
        String string2 = parcel.readString();
        this.contentType = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        this.contentDescription = string3 != null ? string3 : "";
        this.cacheKey = parcel.readString();
        this.orientation = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.mediaUrl);
        dest.writeString(this.contentType);
        dest.writeString(this.contentDescription);
        dest.writeString(this.cacheKey);
        dest.writeInt(this.orientation);
    }

    public final boolean isAudio() {
        return !StringsKt.isBlank(this.mediaUrl) && StringsKt.startsWith$default(this.contentType, "audio", false, 2, (Object) null);
    }

    public final boolean isGIF() {
        return !StringsKt.isBlank(this.mediaUrl) && Intrinsics.areEqual(this.contentType, "image/gif");
    }

    public final boolean isImage() {
        return (StringsKt.isBlank(this.mediaUrl) || !StringsKt.startsWith$default(this.contentType, "image", false, 2, (Object) null) || Intrinsics.areEqual(this.contentType, "image/gif")) ? false : true;
    }

    public final boolean isVideo() {
        return !StringsKt.isBlank(this.mediaUrl) && StringsKt.startsWith$default(this.contentType, "video", false, 2, (Object) null);
    }

    public final boolean isMediaStreamable() {
        return isVideo() || isAudio();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.clevertap.android.sdk.inapp.CTInAppNotificationMedia");
        CTInAppNotificationMedia cTInAppNotificationMedia = (CTInAppNotificationMedia) other;
        return this.orientation == cTInAppNotificationMedia.orientation && Intrinsics.areEqual(this.mediaUrl, cTInAppNotificationMedia.mediaUrl) && Intrinsics.areEqual(this.contentType, cTInAppNotificationMedia.contentType) && Intrinsics.areEqual(this.contentDescription, cTInAppNotificationMedia.contentDescription) && Intrinsics.areEqual(this.cacheKey, cTInAppNotificationMedia.cacheKey);
    }

    public int hashCode() {
        int iHashCode = ((((((this.orientation * 31) + this.mediaUrl.hashCode()) * 31) + this.contentType.hashCode()) * 31) + this.contentDescription.hashCode()) * 31;
        String str = this.cacheKey;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    /* JADX INFO: compiled from: CTInAppNotificationMedia.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTInAppNotificationMedia$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/clevertap/android/sdk/inapp/CTInAppNotificationMedia;", "create", "json", "Lorg/json/JSONObject;", Constants.KEY_ORIENTATION, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CTInAppNotificationMedia create(JSONObject json, int orientation) {
            Intrinsics.checkNotNullParameter(json, "json");
            String strOptString = json.optString("content_type");
            Intrinsics.checkNotNull(strOptString);
            String str = null;
            if (StringsKt.isBlank(strOptString)) {
                return null;
            }
            String strOptString2 = json.optString("url");
            Intrinsics.checkNotNull(strOptString2);
            if (!StringsKt.isBlank(strOptString2) && StringsKt.startsWith$default(strOptString, "image", false, 2, (Object) null)) {
                str = UUID.randomUUID() + json.optString("key");
            }
            String strOptString3 = json.optString(Constants.KEY_ALT_TEXT);
            Intrinsics.checkNotNull(strOptString3);
            return new CTInAppNotificationMedia(strOptString2, strOptString, strOptString3, str, orientation);
        }
    }
}
