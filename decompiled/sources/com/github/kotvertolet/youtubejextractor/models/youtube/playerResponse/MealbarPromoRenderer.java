package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MealbarPromoRenderer implements Serializable {
    private ActionButton actionButton;
    private DismissButton dismissButton;
    private List<ImpressionEndpointsItem> impressionEndpoints;
    private boolean isVisible;
    private List<MessageTextsItem> messageTexts;
    private MessageTitle messageTitle;
    private String style;
    private String trackingParams;
    private String triggerCondition;

    public String getTriggerCondition() {
        return this.triggerCondition;
    }

    public void setTriggerCondition(String str) {
        this.triggerCondition = str;
    }

    public String getTrackingParams() {
        return this.trackingParams;
    }

    public void setTrackingParams(String str) {
        this.trackingParams = str;
    }

    public List<ImpressionEndpointsItem> getImpressionEndpoints() {
        return this.impressionEndpoints;
    }

    public void setImpressionEndpoints(List<ImpressionEndpointsItem> list) {
        this.impressionEndpoints = list;
    }

    public DismissButton getDismissButton() {
        return this.dismissButton;
    }

    public void setDismissButton(DismissButton dismissButton) {
        this.dismissButton = dismissButton;
    }

    public ActionButton getActionButton() {
        return this.actionButton;
    }

    public void setActionButton(ActionButton actionButton) {
        this.actionButton = actionButton;
    }

    public List<MessageTextsItem> getMessageTexts() {
        return this.messageTexts;
    }

    public void setMessageTexts(List<MessageTextsItem> list) {
        this.messageTexts = list;
    }

    public MessageTitle getMessageTitle() {
        return this.messageTitle;
    }

    public void setMessageTitle(MessageTitle messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String str) {
        this.style = str;
    }

    public boolean isIsVisible() {
        return this.isVisible;
    }

    public void setIsVisible(boolean z) {
        this.isVisible = z;
    }

    public String toString() {
        return "MealbarPromoRenderer{triggerCondition = '" + this.triggerCondition + "',trackingParams = '" + this.trackingParams + "',impressionEndpoints = '" + this.impressionEndpoints + "',dismissButton = '" + this.dismissButton + "',actionButton = '" + this.actionButton + "',messageTexts = '" + this.messageTexts + "',messageTitle = '" + this.messageTitle + "',style = '" + this.style + "',isVisible = '" + this.isVisible + "'}";
    }
}
