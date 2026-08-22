package com.github.kotvertolet.youtubejextractor.models.newModels;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: SubscribeButtonRenderer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010I\u001a\u00020\nH\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R&\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR \u00104\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR \u00107\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R \u0010=\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010C\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeButtonRenderer;", "", "()V", "buttonText", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ButtonText;", "getButtonText", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/ButtonText;", "setButtonText", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/ButtonText;)V", "channelId", "", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "isShowPreferences", "setShowPreferences", "isSubscribed", "setSubscribed", "serviceEndpoints", "", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/ServiceEndpointsItem;", "getServiceEndpoints", "()Ljava/util/List;", "setServiceEndpoints", "(Ljava/util/List;)V", "signInEndpoint", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/SignInEndpoint;", "getSignInEndpoint", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/SignInEndpoint;", "setSignInEndpoint", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/SignInEndpoint;)V", "subscribeAccessibility", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeAccessibility;", "getSubscribeAccessibility", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeAccessibility;", "setSubscribeAccessibility", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribeAccessibility;)V", "subscribedButtonText", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribedButtonText;", "getSubscribedButtonText", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribedButtonText;", "setSubscribedButtonText", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/SubscribedButtonText;)V", "trackingParams", "getTrackingParams", "setTrackingParams", "type", "getType", "setType", "unsubscribeAccessibility", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeAccessibility;", "getUnsubscribeAccessibility", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeAccessibility;", "setUnsubscribeAccessibility", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeAccessibility;)V", "unsubscribeButtonText", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeButtonText;", "getUnsubscribeButtonText", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeButtonText;", "setUnsubscribeButtonText", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribeButtonText;)V", "unsubscribedButtonText", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribedButtonText;", "getUnsubscribedButtonText", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribedButtonText;", "setUnsubscribedButtonText", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/UnsubscribedButtonText;)V", InAppPurchaseConstants.METHOD_TO_STRING, "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribeButtonRenderer {

    @SerializedName("buttonText")
    private ButtonText buttonText;

    @SerializedName("channelId")
    private String channelId;

    @SerializedName(StreamManagement.Enabled.ELEMENT)
    private boolean isEnabled;

    @SerializedName("showPreferences")
    private boolean isShowPreferences;

    @SerializedName("subscribed")
    private boolean isSubscribed;

    @SerializedName("serviceEndpoints")
    private List<ServiceEndpointsItem> serviceEndpoints;

    @SerializedName("signInEndpoint")
    private SignInEndpoint signInEndpoint;

    @SerializedName("subscribeAccessibility")
    private SubscribeAccessibility subscribeAccessibility;

    @SerializedName("subscribedButtonText")
    private SubscribedButtonText subscribedButtonText;

    @SerializedName("trackingParams")
    private String trackingParams;

    @SerializedName("type")
    private String type;

    @SerializedName("unsubscribeAccessibility")
    private UnsubscribeAccessibility unsubscribeAccessibility;

    @SerializedName("unsubscribeButtonText")
    private UnsubscribeButtonText unsubscribeButtonText;

    @SerializedName("unsubscribedButtonText")
    private UnsubscribedButtonText unsubscribedButtonText;

    public final ButtonText getButtonText() {
        return this.buttonText;
    }

    public final void setButtonText(ButtonText buttonText) {
        this.buttonText = buttonText;
    }

    public final SubscribeAccessibility getSubscribeAccessibility() {
        return this.subscribeAccessibility;
    }

    public final void setSubscribeAccessibility(SubscribeAccessibility subscribeAccessibility) {
        this.subscribeAccessibility = subscribeAccessibility;
    }

    /* JADX INFO: renamed from: isShowPreferences, reason: from getter */
    public final boolean getIsShowPreferences() {
        return this.isShowPreferences;
    }

    public final void setShowPreferences(boolean z) {
        this.isShowPreferences = z;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final SubscribedButtonText getSubscribedButtonText() {
        return this.subscribedButtonText;
    }

    public final void setSubscribedButtonText(SubscribedButtonText subscribedButtonText) {
        this.subscribedButtonText = subscribedButtonText;
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final UnsubscribeButtonText getUnsubscribeButtonText() {
        return this.unsubscribeButtonText;
    }

    public final void setUnsubscribeButtonText(UnsubscribeButtonText unsubscribeButtonText) {
        this.unsubscribeButtonText = unsubscribeButtonText;
    }

    public final SignInEndpoint getSignInEndpoint() {
        return this.signInEndpoint;
    }

    public final void setSignInEndpoint(SignInEndpoint signInEndpoint) {
        this.signInEndpoint = signInEndpoint;
    }

    /* JADX INFO: renamed from: isSubscribed, reason: from getter */
    public final boolean getIsSubscribed() {
        return this.isSubscribed;
    }

    public final void setSubscribed(boolean z) {
        this.isSubscribed = z;
    }

    public final UnsubscribeAccessibility getUnsubscribeAccessibility() {
        return this.unsubscribeAccessibility;
    }

    public final void setUnsubscribeAccessibility(UnsubscribeAccessibility unsubscribeAccessibility) {
        this.unsubscribeAccessibility = unsubscribeAccessibility;
    }

    public final String getTrackingParams() {
        return this.trackingParams;
    }

    public final void setTrackingParams(String str) {
        this.trackingParams = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final UnsubscribedButtonText getUnsubscribedButtonText() {
        return this.unsubscribedButtonText;
    }

    public final void setUnsubscribedButtonText(UnsubscribedButtonText unsubscribedButtonText) {
        this.unsubscribedButtonText = unsubscribedButtonText;
    }

    public final List<ServiceEndpointsItem> getServiceEndpoints() {
        return this.serviceEndpoints;
    }

    public final void setServiceEndpoints(List<ServiceEndpointsItem> list) {
        this.serviceEndpoints = list;
    }

    public String toString() {
        return "SubscribeButtonRenderer{buttonText = '" + this.buttonText + "',subscribeAccessibility = '" + this.subscribeAccessibility + "',showPreferences = '" + this.isShowPreferences + "',type = '" + this.type + "',subscribedButtonText = '" + this.subscribedButtonText + "',enabled = '" + this.isEnabled + "',unsubscribeButtonText = '" + this.unsubscribeButtonText + "',signInEndpoint = '" + this.signInEndpoint + "',subscribed = '" + this.isSubscribed + "',unsubscribeAccessibility = '" + this.unsubscribeAccessibility + "',trackingParams = '" + this.trackingParams + "',channelId = '" + this.channelId + "',unsubscribedButtonText = '" + this.unsubscribedButtonText + "',serviceEndpoints = '" + this.serviceEndpoints + "'}";
    }
}
