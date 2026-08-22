package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.github.kotvertolet.youtubejextractor.models.youtube.videoData.VideoDetails;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class PlayerResponse implements Serializable {
    private Attestation attestation;
    private List<MessagesItem> messages;
    private Microformat microformat;
    private PlayabilityStatus playabilityStatus;
    private PlaybackTracking playbackTracking;
    private PlayerConfig playerConfig;

    @SerializedName("streamingData")
    private RawStreamingData rawStreamingData;
    private Storyboards storyboards;
    private String trackingParams;
    private VideoDetails videoDetails;

    public PlayerConfig getPlayerConfig() {
        return this.playerConfig;
    }

    public void setPlayerConfig(PlayerConfig playerConfig) {
        this.playerConfig = playerConfig;
    }

    public String getTrackingParams() {
        return this.trackingParams;
    }

    public void setTrackingParams(String str) {
        this.trackingParams = str;
    }

    public Attestation getAttestation() {
        return this.attestation;
    }

    public void setAttestation(Attestation attestation) {
        this.attestation = attestation;
    }

    public VideoDetails getVideoDetails() {
        return this.videoDetails;
    }

    public void setVideoDetails(VideoDetails videoDetails) {
        this.videoDetails = videoDetails;
    }

    public RawStreamingData getRawStreamingData() {
        return this.rawStreamingData;
    }

    public void setRawStreamingData(RawStreamingData rawStreamingData) {
        this.rawStreamingData = rawStreamingData;
    }

    public PlayabilityStatus getPlayabilityStatus() {
        return this.playabilityStatus;
    }

    public void setPlayabilityStatus(PlayabilityStatus playabilityStatus) {
        this.playabilityStatus = playabilityStatus;
    }

    public List<MessagesItem> getMessages() {
        return this.messages;
    }

    public void setMessages(List<MessagesItem> list) {
        this.messages = list;
    }

    public PlaybackTracking getPlaybackTracking() {
        return this.playbackTracking;
    }

    public void setPlaybackTracking(PlaybackTracking playbackTracking) {
        this.playbackTracking = playbackTracking;
    }

    public Microformat getMicroformat() {
        return this.microformat;
    }

    public void setMicroformat(Microformat microformat) {
        this.microformat = microformat;
    }

    public Storyboards getStoryboards() {
        return this.storyboards;
    }

    public void setStoryboards(Storyboards storyboards) {
        this.storyboards = storyboards;
    }

    public String toString() {
        return "PlayerResponse{playerConfig = '" + this.playerConfig + "',trackingParams = '" + this.trackingParams + "',attestation = '" + this.attestation + "',videoDetails = '" + this.videoDetails + "',rawStreamingData = '" + this.rawStreamingData + "',playabilityStatus = '" + this.playabilityStatus + "',messages = '" + this.messages + "',playbackTracking = '" + this.playbackTracking + "',microformat = '" + this.microformat + "',storyboards = '" + this.storyboards + "'}";
    }
}
