package com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RawStreamingData implements Serializable {

    @SerializedName("adaptiveFormats")
    private List<AdaptiveStream> adaptiveStreams;
    private String dashManifestUrl;
    private String expiresInSeconds;
    private String hlsManifestUrl;

    @SerializedName("formats")
    private List<MuxedStream> muxedStreams;

    @SerializedName("probeUrl")
    private String probeUrl;

    public List<MuxedStream> getMuxedStreams() {
        return this.muxedStreams;
    }

    public void setMuxedStreams(List<MuxedStream> list) {
        this.muxedStreams = list;
    }

    public String getProbeUrl() {
        return this.probeUrl;
    }

    public void setProbeUrl(String str) {
        this.probeUrl = str;
    }

    public List<AdaptiveStream> getAdaptiveStreams() {
        return this.adaptiveStreams;
    }

    public void setAdaptiveStreams(List<AdaptiveStream> list) {
        this.adaptiveStreams = list;
    }

    public String getExpiresInSeconds() {
        return this.expiresInSeconds;
    }

    public void setExpiresInSeconds(String str) {
        this.expiresInSeconds = str;
    }

    public String getDashManifestUrl() {
        return this.dashManifestUrl;
    }

    public void setDashManifestUrl(String str) {
        this.dashManifestUrl = str;
    }

    public String getHlsManifestUrl() {
        return this.hlsManifestUrl;
    }

    public void setHlsManifestUrl(String str) {
        this.hlsManifestUrl = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RawStreamingData rawStreamingData = (RawStreamingData) obj;
            List<MuxedStream> list = this.muxedStreams;
            if (list == null ? rawStreamingData.muxedStreams != null : !list.equals(rawStreamingData.muxedStreams)) {
                return false;
            }
            String str = this.probeUrl;
            if (str == null ? rawStreamingData.probeUrl != null : !str.equals(rawStreamingData.probeUrl)) {
                return false;
            }
            List<AdaptiveStream> list2 = this.adaptiveStreams;
            if (list2 == null ? rawStreamingData.adaptiveStreams != null : !list2.equals(rawStreamingData.adaptiveStreams)) {
                return false;
            }
            String str2 = this.expiresInSeconds;
            if (str2 == null ? rawStreamingData.expiresInSeconds != null : !str2.equals(rawStreamingData.expiresInSeconds)) {
                return false;
            }
            String str3 = this.dashManifestUrl;
            if (str3 == null ? rawStreamingData.dashManifestUrl != null : !str3.equals(rawStreamingData.dashManifestUrl)) {
                return false;
            }
            String str4 = this.hlsManifestUrl;
            String str5 = rawStreamingData.hlsManifestUrl;
            if (str4 != null) {
                return str4.equals(str5);
            }
            if (str5 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        List<MuxedStream> list = this.muxedStreams;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.probeUrl;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<AdaptiveStream> list2 = this.adaptiveStreams;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str2 = this.expiresInSeconds;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.dashManifestUrl;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.hlsManifestUrl;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "RawStreamingData{formats=" + this.muxedStreams + ", probeUrl='" + this.probeUrl + "', adaptiveFormats=" + this.adaptiveStreams + ", expiresInSeconds='" + this.expiresInSeconds + "', dashManifestUrl='" + this.dashManifestUrl + "', hlsManifestUrl='" + this.hlsManifestUrl + "'}";
    }
}
