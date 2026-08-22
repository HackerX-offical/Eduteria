package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class ButtonRenderer implements Serializable {
    private NavigationEndpoint navigationEndpoint;
    private ServiceEndpoint serviceEndpoint;
    private String size;
    private String style;
    private Text text;
    private String trackingParams;

    public String getTrackingParams() {
        return this.trackingParams;
    }

    public void setTrackingParams(String str) {
        this.trackingParams = str;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String str) {
        this.style = str;
    }

    public Text getText() {
        return this.text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public NavigationEndpoint getNavigationEndpoint() {
        return this.navigationEndpoint;
    }

    public void setNavigationEndpoint(NavigationEndpoint navigationEndpoint) {
        this.navigationEndpoint = navigationEndpoint;
    }

    public ServiceEndpoint getServiceEndpoint() {
        return this.serviceEndpoint;
    }

    public void setServiceEndpoint(ServiceEndpoint serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }

    public String toString() {
        return "ButtonRenderer{trackingParams = '" + this.trackingParams + "',size = '" + this.size + "',style = '" + this.style + "',text = '" + this.text + "',navigationEndpoint = '" + this.navigationEndpoint + "',serviceEndpoint = '" + this.serviceEndpoint + "'}";
    }
}
