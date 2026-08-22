package com.github.kotvertolet.youtubejextractor.models.newModels;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: compiled from: ServiceEndpoint.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/github/kotvertolet/youtubejextractor/models/newModels/ServiceEndpoint;", "", "()V", "clickTrackingParams", "", "getClickTrackingParams", "()Ljava/lang/String;", "setClickTrackingParams", "(Ljava/lang/String;)V", "commandMetadata", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/CommandMetadata;", "getCommandMetadata", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/CommandMetadata;", "setCommandMetadata", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/CommandMetadata;)V", "feedbackEndpoint", "Lcom/github/kotvertolet/youtubejextractor/models/newModels/FeedbackEndpoint;", "getFeedbackEndpoint", "()Lcom/github/kotvertolet/youtubejextractor/models/newModels/FeedbackEndpoint;", "setFeedbackEndpoint", "(Lcom/github/kotvertolet/youtubejextractor/models/newModels/FeedbackEndpoint;)V", InAppPurchaseConstants.METHOD_TO_STRING, "youtubejextractor_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceEndpoint {

    @SerializedName("clickTrackingParams")
    private String clickTrackingParams;

    @SerializedName("commandMetadata")
    private CommandMetadata commandMetadata;

    @SerializedName("feedbackEndpoint")
    private FeedbackEndpoint feedbackEndpoint;

    public final FeedbackEndpoint getFeedbackEndpoint() {
        return this.feedbackEndpoint;
    }

    public final void setFeedbackEndpoint(FeedbackEndpoint feedbackEndpoint) {
        this.feedbackEndpoint = feedbackEndpoint;
    }

    public final CommandMetadata getCommandMetadata() {
        return this.commandMetadata;
    }

    public final void setCommandMetadata(CommandMetadata commandMetadata) {
        this.commandMetadata = commandMetadata;
    }

    public final String getClickTrackingParams() {
        return this.clickTrackingParams;
    }

    public final void setClickTrackingParams(String str) {
        this.clickTrackingParams = str;
    }

    public String toString() {
        return "ServiceEndpoint{feedbackEndpoint = '" + this.feedbackEndpoint + "',commandMetadata = '" + this.commandMetadata + "',clickTrackingParams = '" + this.clickTrackingParams + "'}";
    }
}
