package com.github.kotvertolet.youtubejextractor.models.newModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MealbarPromoRenderer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u00107\u001a\u000208HÖ\u0001J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001eJ\b\u0010<\u001a\u00020,H\u0016J\u0019\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u000208HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R&\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R \u00104\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100¨\u0006A"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/MealbarPromoRenderer;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "()V", "actionButton", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ActionButton;", "getActionButton", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/ActionButton;", "setActionButton", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/ActionButton;)V", "dismissButton", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/DismissButton;", "getDismissButton", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/DismissButton;", "setDismissButton", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/DismissButton;)V", "icon", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/Icon;", "getIcon", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/Icon;", "setIcon", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/Icon;)V", "impressionEndpoints", "", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ImpressionEndpointsItem;", "getImpressionEndpoints", "()Ljava/util/List;", "setImpressionEndpoints", "(Ljava/util/List;)V", "<set-?>", "", "isIsVisible", "()Z", "messageTexts", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/MessageTextsItem;", "getMessageTexts", "setMessageTexts", "messageTitle", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/MessageTitle;", "getMessageTitle", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/MessageTitle;", "setMessageTitle", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/MessageTitle;)V", "style", "", "getStyle", "()Ljava/lang/String;", "setStyle", "(Ljava/lang/String;)V", "trackingParams", "getTrackingParams", "setTrackingParams", "triggerCondition", "getTriggerCondition", "setTriggerCondition", "describeContents", "", "setIsVisible", "", "isVisible", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class MealbarPromoRenderer implements Parcelable, Serializable {
    public static final Parcelable.Creator<MealbarPromoRenderer> CREATOR = new Creator();

    @SerializedName("actionButton")
    private ActionButton actionButton;

    @SerializedName("dismissButton")
    private DismissButton dismissButton;

    @SerializedName("icon")
    private Icon icon;

    @SerializedName("impressionEndpoints")
    private List<ImpressionEndpointsItem> impressionEndpoints;

    @SerializedName("isVisible")
    private boolean isIsVisible;

    @SerializedName("messageTexts")
    private List<MessageTextsItem> messageTexts;

    @SerializedName("messageTitle")
    private MessageTitle messageTitle;

    @SerializedName("style")
    private String style;

    @SerializedName("trackingParams")
    private String trackingParams;

    @SerializedName("triggerCondition")
    private String triggerCondition;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MealbarPromoRenderer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MealbarPromoRenderer createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            if (in.readInt() != 0) {
                return new MealbarPromoRenderer();
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MealbarPromoRenderer[] newArray(int i) {
            return new MealbarPromoRenderer[i];
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

    public final String getTriggerCondition() {
        return this.triggerCondition;
    }

    public final void setTriggerCondition(String str) {
        this.triggerCondition = str;
    }

    public final String getTrackingParams() {
        return this.trackingParams;
    }

    public final void setTrackingParams(String str) {
        this.trackingParams = str;
    }

    public final List<ImpressionEndpointsItem> getImpressionEndpoints() {
        return this.impressionEndpoints;
    }

    public final void setImpressionEndpoints(List<ImpressionEndpointsItem> list) {
        this.impressionEndpoints = list;
    }

    public final DismissButton getDismissButton() {
        return this.dismissButton;
    }

    public final void setDismissButton(DismissButton dismissButton) {
        this.dismissButton = dismissButton;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final void setIcon(Icon icon) {
        this.icon = icon;
    }

    public final ActionButton getActionButton() {
        return this.actionButton;
    }

    public final void setActionButton(ActionButton actionButton) {
        this.actionButton = actionButton;
    }

    public final List<MessageTextsItem> getMessageTexts() {
        return this.messageTexts;
    }

    public final void setMessageTexts(List<MessageTextsItem> list) {
        this.messageTexts = list;
    }

    public final MessageTitle getMessageTitle() {
        return this.messageTitle;
    }

    public final void setMessageTitle(MessageTitle messageTitle) {
        this.messageTitle = messageTitle;
    }

    public final String getStyle() {
        return this.style;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    /* JADX INFO: renamed from: isIsVisible, reason: from getter */
    public final boolean getIsIsVisible() {
        return this.isIsVisible;
    }

    public final void setIsVisible(boolean isVisible) {
        this.isIsVisible = isVisible;
    }

    public String toString() {
        return "MealbarPromoRenderer{triggerCondition = '" + this.triggerCondition + "',trackingParams = '" + this.trackingParams + "',impressionEndpoints = '" + this.impressionEndpoints + "',dismissButton = '" + this.dismissButton + "',icon = '" + this.icon + "',actionButton = '" + this.actionButton + "',messageTexts = '" + this.messageTexts + "',messageTitle = '" + this.messageTitle + "',style = '" + this.style + "',isVisible = '" + this.isIsVisible + "'}";
    }
}
