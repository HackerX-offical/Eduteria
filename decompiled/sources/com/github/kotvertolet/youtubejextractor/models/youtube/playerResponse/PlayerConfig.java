package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class PlayerConfig implements Serializable {
    private AudioConfig audioConfig;
    private MediaCommonConfig mediaCommonConfig;
    private StreamSelectionConfig streamSelectionConfig;

    public MediaCommonConfig getMediaCommonConfig() {
        return this.mediaCommonConfig;
    }

    public void setMediaCommonConfig(MediaCommonConfig mediaCommonConfig) {
        this.mediaCommonConfig = mediaCommonConfig;
    }

    public AudioConfig getAudioConfig() {
        return this.audioConfig;
    }

    public void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    public StreamSelectionConfig getStreamSelectionConfig() {
        return this.streamSelectionConfig;
    }

    public void setStreamSelectionConfig(StreamSelectionConfig streamSelectionConfig) {
        this.streamSelectionConfig = streamSelectionConfig;
    }

    public String toString() {
        return "PlayerConfig{mediaCommonConfig = '" + this.mediaCommonConfig + "',audioConfig = '" + this.audioConfig + "',streamSelectionConfig = '" + this.streamSelectionConfig + "'}";
    }
}
