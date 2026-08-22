package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class PlaybackTracking implements Serializable {
    private AtrUrl atrUrl;
    private PtrackingUrl ptrackingUrl;
    private QoeUrl qoeUrl;
    private SetAwesomeUrl setAwesomeUrl;
    private VideostatsDelayplayUrl videostatsDelayplayUrl;
    private VideostatsPlaybackUrl videostatsPlaybackUrl;
    private VideostatsWatchtimeUrl videostatsWatchtimeUrl;

    public VideostatsWatchtimeUrl getVideostatsWatchtimeUrl() {
        return this.videostatsWatchtimeUrl;
    }

    public void setVideostatsWatchtimeUrl(VideostatsWatchtimeUrl videostatsWatchtimeUrl) {
        this.videostatsWatchtimeUrl = videostatsWatchtimeUrl;
    }

    public VideostatsDelayplayUrl getVideostatsDelayplayUrl() {
        return this.videostatsDelayplayUrl;
    }

    public void setVideostatsDelayplayUrl(VideostatsDelayplayUrl videostatsDelayplayUrl) {
        this.videostatsDelayplayUrl = videostatsDelayplayUrl;
    }

    public QoeUrl getQoeUrl() {
        return this.qoeUrl;
    }

    public void setQoeUrl(QoeUrl qoeUrl) {
        this.qoeUrl = qoeUrl;
    }

    public SetAwesomeUrl getSetAwesomeUrl() {
        return this.setAwesomeUrl;
    }

    public void setSetAwesomeUrl(SetAwesomeUrl setAwesomeUrl) {
        this.setAwesomeUrl = setAwesomeUrl;
    }

    public VideostatsPlaybackUrl getVideostatsPlaybackUrl() {
        return this.videostatsPlaybackUrl;
    }

    public void setVideostatsPlaybackUrl(VideostatsPlaybackUrl videostatsPlaybackUrl) {
        this.videostatsPlaybackUrl = videostatsPlaybackUrl;
    }

    public PtrackingUrl getPtrackingUrl() {
        return this.ptrackingUrl;
    }

    public void setPtrackingUrl(PtrackingUrl ptrackingUrl) {
        this.ptrackingUrl = ptrackingUrl;
    }

    public AtrUrl getAtrUrl() {
        return this.atrUrl;
    }

    public void setAtrUrl(AtrUrl atrUrl) {
        this.atrUrl = atrUrl;
    }

    public String toString() {
        return "PlaybackTracking{videostatsWatchtimeUrl = '" + this.videostatsWatchtimeUrl + "',videostatsDelayplayUrl = '" + this.videostatsDelayplayUrl + "',qoeUrl = '" + this.qoeUrl + "',setAwesomeUrl = '" + this.setAwesomeUrl + "',videostatsPlaybackUrl = '" + this.videostatsPlaybackUrl + "',ptrackingUrl = '" + this.ptrackingUrl + "',atrUrl = '" + this.atrUrl + "'}";
    }
}
