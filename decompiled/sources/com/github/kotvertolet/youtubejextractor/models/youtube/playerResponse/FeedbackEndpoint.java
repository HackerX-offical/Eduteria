package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class FeedbackEndpoint implements Serializable {
    private String feedbackToken;
    private UiActions uiActions;

    public UiActions getUiActions() {
        return this.uiActions;
    }

    public void setUiActions(UiActions uiActions) {
        this.uiActions = uiActions;
    }

    public String getFeedbackToken() {
        return this.feedbackToken;
    }

    public void setFeedbackToken(String str) {
        this.feedbackToken = str;
    }

    public String toString() {
        return "FeedbackEndpoint{uiActions = '" + this.uiActions + "',feedbackToken = '" + this.feedbackToken + "'}";
    }
}
