package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonRenderer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\b\u0010$\u001a\u00020\u0011H\u0016J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020#HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u0006*"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/ButtonRenderer;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "navigationEndpoint", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/NavigationEndpoint;", "getNavigationEndpoint", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/NavigationEndpoint;", "setNavigationEndpoint", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/NavigationEndpoint;)V", "serviceEndpoint", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ServiceEndpoint;", "getServiceEndpoint", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/ServiceEndpoint;", "setServiceEndpoint", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/ServiceEndpoint;)V", "size", "", "getSize", "()Ljava/lang/String;", "setSize", "(Ljava/lang/String;)V", "style", "getStyle", "setStyle", "text", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Text;", "getText", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Text;", "setText", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Text;)V", "trackingParams", "getTrackingParams", "setTrackingParams", "describeContents", "", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonRenderer implements Parcelable, Serializable {
    public static final Parcelable.Creator<ButtonRenderer> CREATOR = new Creator();

    @SerializedName("navigationEndpoint")
    private NavigationEndpoint navigationEndpoint;

    @SerializedName("serviceEndpoint")
    private ServiceEndpoint serviceEndpoint;

    @SerializedName("size")
    private String size;

    @SerializedName("style")
    private String style;

    @SerializedName("text")
    private Text text;

    @SerializedName("trackingParams")
    private String trackingParams;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ButtonRenderer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ButtonRenderer createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new ButtonRenderer();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ButtonRenderer[] newArray(int i) {
            return new ButtonRenderer[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(1);
    }

    public final String getTrackingParams() {
        return this.trackingParams;
    }

    public final void setTrackingParams(String str) {
        this.trackingParams = str;
    }

    public final String getSize() {
        return this.size;
    }

    public final void setSize(String str) {
        this.size = str;
    }

    public final String getStyle() {
        return this.style;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    public final Text getText() {
        return this.text;
    }

    public final void setText(Text text) {
        this.text = text;
    }

    public final ServiceEndpoint getServiceEndpoint() {
        return this.serviceEndpoint;
    }

    public final void setServiceEndpoint(ServiceEndpoint serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }

    public final NavigationEndpoint getNavigationEndpoint() {
        return this.navigationEndpoint;
    }

    public final void setNavigationEndpoint(NavigationEndpoint navigationEndpoint) {
        this.navigationEndpoint = navigationEndpoint;
    }

    public String toString() {
        return "ButtonRenderer{trackingParams = '" + this.trackingParams + "',size = '" + this.size + "',style = '" + this.style + "',text = '" + this.text + "',serviceEndpoint = '" + this.serviceEndpoint + "',navigationEndpoint = '" + this.navigationEndpoint + "'}";
    }
}
