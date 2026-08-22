package com.clevertap.android.sdk.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CTInAppNotificationButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020\u001aH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTInAppNotificationButton;", "Landroid/os/Parcelable;", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "text", "", "getText", "()Ljava/lang/String;", "backgroundColor", "getBackgroundColor$clevertap_core_release", "borderColor", "getBorderColor$clevertap_core_release", "borderRadius", "getBorderRadius$clevertap_core_release", "textColor", "getTextColor$clevertap_core_release", "action", "Lcom/clevertap/android/sdk/inapp/CTInAppAction;", "getKeyValues", "", "describeContents", "", "writeToParcel", "", "dest", "flags", "equals", "", "other", "", "hashCode", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNotificationButton implements Parcelable {
    public final CTInAppAction action;
    private final String backgroundColor;
    private final String borderColor;
    private final String borderRadius;
    private final String text;
    private final String textColor;
    public static final Parcelable.Creator<CTInAppNotificationButton> CREATOR = new Parcelable.Creator<CTInAppNotificationButton>() { // from class: com.clevertap.android.sdk.inapp.CTInAppNotificationButton$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CTInAppNotificationButton createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CTInAppNotificationButton(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CTInAppNotificationButton[] newArray(int size) {
            return new CTInAppNotificationButton[size];
        }
    };

    public /* synthetic */ CTInAppNotificationButton(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: getBackgroundColor$clevertap_core_release, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: getBorderColor$clevertap_core_release, reason: from getter */
    public final String getBorderColor() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: getBorderRadius$clevertap_core_release, reason: from getter */
    public final String getBorderRadius() {
        return this.borderRadius;
    }

    /* JADX INFO: renamed from: getTextColor$clevertap_core_release, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    public CTInAppNotificationButton(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.text = jsonObject.optString("text");
        this.textColor = jsonObject.optString("color", Constants.BLUE);
        this.backgroundColor = jsonObject.optString(Constants.KEY_BG, "#FFFFFF");
        this.borderColor = jsonObject.optString(Constants.KEY_BORDER, "#FFFFFF");
        this.borderRadius = jsonObject.optString(Constants.KEY_RADIUS);
        this.action = CTInAppAction.INSTANCE.createFromJson(jsonObject.optJSONObject(Constants.KEY_ACTIONS));
    }

    private CTInAppNotificationButton(Parcel parcel) {
        String string = parcel.readString();
        this.text = string == null ? "" : string;
        String string2 = parcel.readString();
        this.textColor = string2 == null ? Constants.BLUE : string2;
        String string3 = parcel.readString();
        this.backgroundColor = string3 == null ? "#FFFFFF" : string3;
        String string4 = parcel.readString();
        this.borderColor = string4 != null ? string4 : "#FFFFFF";
        String string5 = parcel.readString();
        this.borderRadius = string5 != null ? string5 : "";
        this.action = (CTInAppAction) parcel.readParcelable(CTInAppAction.class.getClassLoader());
    }

    public final Map<String, String> getKeyValues() {
        CTInAppAction cTInAppAction = this.action;
        return cTInAppAction != null ? cTInAppAction.getKeyValues() : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.text);
        dest.writeString(this.textColor);
        dest.writeString(this.backgroundColor);
        dest.writeString(this.borderColor);
        dest.writeString(this.borderRadius);
        dest.writeParcelable(this.action, flags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.clevertap.android.sdk.inapp.CTInAppNotificationButton");
        CTInAppNotificationButton cTInAppNotificationButton = (CTInAppNotificationButton) other;
        return Intrinsics.areEqual(this.backgroundColor, cTInAppNotificationButton.backgroundColor) && Intrinsics.areEqual(this.borderColor, cTInAppNotificationButton.borderColor) && Intrinsics.areEqual(this.borderRadius, cTInAppNotificationButton.borderRadius) && Intrinsics.areEqual(this.text, cTInAppNotificationButton.text) && Intrinsics.areEqual(this.textColor, cTInAppNotificationButton.textColor) && Intrinsics.areEqual(this.action, cTInAppNotificationButton.action);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.backgroundColor.hashCode() * 31) + this.borderColor.hashCode()) * 31) + this.borderRadius.hashCode()) * 31) + this.text.hashCode()) * 31) + this.textColor.hashCode()) * 31;
        CTInAppAction cTInAppAction = this.action;
        return iHashCode + (cTInAppAction != null ? cTInAppAction.hashCode() : 0);
    }
}
