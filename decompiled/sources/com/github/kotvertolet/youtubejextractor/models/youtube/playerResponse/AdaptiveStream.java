package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class AdaptiveStream implements Serializable {
    private String approxDurationMs;
    private int audioChannels;
    private String audioQuality;
    private String audioSampleRate;
    private int averageBitrate;
    private int bitrate;

    @SerializedName(alternate = {"cipher"}, value = "signatureCipher")
    private Cipher cipher;
    private ColorInfo colorInfo;
    private String contentLength;
    private int fps;
    private int height;
    private boolean highReplication;
    private IndexRange indexRange;
    private InitRange initRange;
    private int itag;
    private String lastModified;
    private String mimeType;
    private String projectionType;
    private String quality;
    private String qualityLabel;
    private String url;
    private int width;

    public int getItag() {
        return this.itag;
    }

    public void setItag(int i) {
        this.itag = i;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public IndexRange getIndexRange() {
        return this.indexRange;
    }

    public void setIndexRange(IndexRange indexRange) {
        this.indexRange = indexRange;
    }

    public String getProjectionType() {
        return this.projectionType;
    }

    public void setProjectionType(String str) {
        this.projectionType = str;
    }

    public InitRange getInitRange() {
        return this.initRange;
    }

    public void setInitRange(InitRange initRange) {
        this.initRange = initRange;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(int i) {
        this.bitrate = i;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String getAudioQuality() {
        return this.audioQuality;
    }

    public void setAudioQuality(String str) {
        this.audioQuality = str;
    }

    public String getApproxDurationMs() {
        return this.approxDurationMs;
    }

    public void setApproxDurationMs(String str) {
        this.approxDurationMs = str;
    }

    public String getAudioSampleRate() {
        return this.audioSampleRate;
    }

    public void setAudioSampleRate(String str) {
        this.audioSampleRate = str;
    }

    public String getQuality() {
        return this.quality;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    public int getAudioChannels() {
        return this.audioChannels;
    }

    public void setAudioChannels(int i) {
        this.audioChannels = i;
    }

    public String getContentLength() {
        return this.contentLength;
    }

    public void setContentLength(String str) {
        this.contentLength = str;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(String str) {
        this.lastModified = str;
    }

    public int getAverageBitrate() {
        return this.averageBitrate;
    }

    public void setAverageBitrate(int i) {
        this.averageBitrate = i;
    }

    public boolean isHighReplication() {
        return this.highReplication;
    }

    public void setHighReplication(boolean z) {
        this.highReplication = z;
    }

    public int getFps() {
        return this.fps;
    }

    public void setFps(int i) {
        this.fps = i;
    }

    public String getQualityLabel() {
        return this.qualityLabel;
    }

    public void setQualityLabel(String str) {
        this.qualityLabel = str;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public ColorInfo getColorInfo() {
        return this.colorInfo;
    }

    public void setColorInfo(ColorInfo colorInfo) {
        this.colorInfo = colorInfo;
    }

    public String getUrl() {
        if (this.url == null && getCipher() != null) {
            this.url = String.format("%s&%s=%s", getCipher().getUrl(), getCipher().getSp(), getCipher().getS());
        }
        return this.url;
    }

    public String toString() {
        return "AdaptiveFormatItem{itag = '" + this.itag + "',cipher = '" + this.cipher + "',indexRange = '" + this.indexRange + "',projectionType = '" + this.projectionType + "',initRange = '" + this.initRange + "',bitrate = '" + this.bitrate + "',mimeType = '" + this.mimeType + "',audioQuality = '" + this.audioQuality + "',approxDurationMs = '" + this.approxDurationMs + "',audioSampleRate = '" + this.audioSampleRate + "',quality = '" + this.quality + "',audioChannels = '" + this.audioChannels + "',contentLength = '" + this.contentLength + "',lastModified = '" + this.lastModified + "',averageBitrate = '" + this.averageBitrate + "',highReplication = '" + this.highReplication + "',fps = '" + this.fps + "',qualityLabel = '" + this.qualityLabel + "',width = '" + this.width + "',height = '" + this.height + "',colorInfo = '" + this.colorInfo + "'}";
    }
}
