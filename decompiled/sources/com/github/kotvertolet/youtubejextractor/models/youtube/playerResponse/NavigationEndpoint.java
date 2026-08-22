package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class NavigationEndpoint implements Serializable {
    private String clickTrackingParams;
    private UrlEndpoint urlEndpoint;

    public String getClickTrackingParams() {
        return this.clickTrackingParams;
    }

    public void setClickTrackingParams(String str) {
        this.clickTrackingParams = str;
    }

    public UrlEndpoint getUrlEndpoint() {
        return this.urlEndpoint;
    }

    public void setUrlEndpoint(UrlEndpoint urlEndpoint) {
        this.urlEndpoint = urlEndpoint;
    }

    public String toString() {
        return "NavigationEndpoint{clickTrackingParams = '" + this.clickTrackingParams + "',urlEndpoint = '" + this.urlEndpoint + "'}";
    }
}
