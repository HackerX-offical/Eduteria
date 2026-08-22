package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class ImpressionEndpointsItem implements Serializable {
    private String clickTrackingParams;
    private FeedbackEndpoint feedbackEndpoint;

    public FeedbackEndpoint getFeedbackEndpoint() {
        return this.feedbackEndpoint;
    }

    public void setFeedbackEndpoint(FeedbackEndpoint feedbackEndpoint) {
        this.feedbackEndpoint = feedbackEndpoint;
    }

    public String getClickTrackingParams() {
        return this.clickTrackingParams;
    }

    public void setClickTrackingParams(String str) {
        this.clickTrackingParams = str;
    }

    public String toString() {
        return "ImpressionEndpointsItem{feedbackEndpoint = '" + this.feedbackEndpoint + "',clickTrackingParams = '" + this.clickTrackingParams + "'}";
    }
}
