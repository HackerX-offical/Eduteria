package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class MuxedStream implements Serializable {

    @SerializedName("approxDurationMs")
    private String approxDurationMs;

    @SerializedName("audioChannels")
    private int audioChannels;

    @SerializedName("audioQuality")
    private String audioQuality;

    @SerializedName("audioSampleRate")
    private String audioSampleRate;

    @SerializedName("averageBitrate")
    private int averageBitrate;

    @SerializedName("bitrate")
    private int bitrate;

    @SerializedName("signatureCipher")
    private Cipher cipher;

    @SerializedName("contentLength")
    private String contentLength;

    @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    private int height;

    @SerializedName("itag")
    private int itag;

    @SerializedName("lastModified")
    private String lastModified;

    @SerializedName("mimeType")
    private String mimeType;

    @SerializedName("projectionType")
    private String projectionType;

    @SerializedName("quality")
    private String quality;

    @SerializedName("qualityLabel")
    private String qualityLabel;

    @SerializedName("url")
    private String url;

    @SerializedName(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)
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

    public String getProjectionType() {
        return this.projectionType;
    }

    public void setProjectionType(String str) {
        this.projectionType = str;
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

    public String getQualityLabel() {
        return this.qualityLabel;
    }

    public void setQualityLabel(String str) {
        this.qualityLabel = str;
    }

    public int getAudioChannels() {
        return this.audioChannels;
    }

    public void setAudioChannels(int i) {
        this.audioChannels = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
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

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getAverageBitrate() {
        return this.averageBitrate;
    }

    public void setAverageBitrate(int i) {
        this.averageBitrate = i;
    }

    public String getUrl() {
        if (this.url == null && getCipher() != null) {
            this.url = String.format("%s&%s=%s", getCipher().getUrl(), getCipher().getSp(), getCipher().getS());
        }
        return this.url;
    }

    public String toString() {
        return "NonAdaptiveFormatItem{itag = '" + this.itag + "',cipher = '" + this.cipher + "',projectionType = '" + this.projectionType + "',bitrate = '" + this.bitrate + "',mimeType = '" + this.mimeType + "',audioQuality = '" + this.audioQuality + "',approxDurationMs = '" + this.approxDurationMs + "',audioSampleRate = '" + this.audioSampleRate + "',quality = '" + this.quality + "',qualityLabel = '" + this.qualityLabel + "',audioChannels = '" + this.audioChannels + "',width = '" + this.width + "',contentLength = '" + this.contentLength + "',lastModified = '" + this.lastModified + "',height = '" + this.height + "',averageBitrate = '" + this.averageBitrate + "'}";
    }
}
