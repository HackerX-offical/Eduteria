package com.github.kotvertolet.youtubejextractor.models;

import android.os.Parcelable;
import com.github.kotvertolet.youtubejextractor.models.newModels.AdaptiveFormatsItem;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.Cipher;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class StreamItem implements Parcelable, Serializable {
    protected Integer approxDurationMs;
    protected int averageBitrate;
    protected int bitrate;
    protected Cipher cipher;
    protected String codec;
    protected String extension;
    protected int iTag;
    protected String url;

    protected StreamItem(String str, String str2, int i, int i2, String str3, int i3, int i4) {
        this.extension = str;
        this.codec = str2;
        this.bitrate = i;
        this.iTag = i2;
        this.url = str3;
        this.averageBitrate = i3;
        this.approxDurationMs = Integer.valueOf(i4);
    }

    protected StreamItem(AdaptiveFormatsItem adaptiveFormatsItem) {
        String[] strArrSplit = adaptiveFormatsItem.getMimeType().split("[/;]");
        this.extension = strArrSplit[1];
        this.codec = strArrSplit[2].split("=")[1].replaceAll("\"", "");
        this.url = adaptiveFormatsItem.getUrl();
        this.iTag = adaptiveFormatsItem.getItag();
        this.bitrate = adaptiveFormatsItem.getBitrate();
        this.averageBitrate = adaptiveFormatsItem.getAverageBitrate();
        String approxDurationMs = adaptiveFormatsItem.getApproxDurationMs();
        this.approxDurationMs = Integer.valueOf(approxDurationMs == null ? 0 : Integer.valueOf(approxDurationMs).intValue());
        this.cipher = adaptiveFormatsItem.getCipher();
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public String getCodec() {
        return this.codec;
    }

    public void setCodec(String str) {
        this.codec = str;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(int i) {
        this.bitrate = i;
    }

    public int getAverageBitrate() {
        return this.averageBitrate;
    }

    public void setAverageBitrate(int i) {
        this.averageBitrate = i;
    }

    public int getiTag() {
        return this.iTag;
    }

    public void setiTag(int i) {
        this.iTag = i;
    }

    public String getUrl() {
        if (this.url == null && getCipher() != null) {
            this.url = String.format("%s&%s=%s", getCipher().getUrl(), getCipher().getSp(), getCipher().getS());
        }
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getApproxDurationMs() {
        return this.approxDurationMs.intValue();
    }

    public void setApproxDurationMs(int i) {
        this.approxDurationMs = Integer.valueOf(i);
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            StreamItem streamItem = (StreamItem) obj;
            if (this.bitrate != streamItem.bitrate || this.iTag != streamItem.iTag || this.averageBitrate != streamItem.averageBitrate) {
                return false;
            }
            String str = this.extension;
            if (str == null ? streamItem.extension != null : !str.equals(streamItem.extension)) {
                return false;
            }
            String str2 = this.codec;
            if (str2 == null ? streamItem.codec != null : !str2.equals(streamItem.codec)) {
                return false;
            }
            String str3 = this.url;
            if (str3 == null ? streamItem.url != null : !str3.equals(streamItem.url)) {
                return false;
            }
            Integer num = this.approxDurationMs;
            Integer num2 = streamItem.approxDurationMs;
            if (num != null) {
                return num.equals(num2);
            }
            if (num2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.extension;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.codec;
        int iHashCode2 = (((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.bitrate) * 31) + this.iTag) * 31;
        String str3 = this.url;
        int iHashCode3 = (((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.averageBitrate) * 31;
        Integer num = this.approxDurationMs;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "StreamItem{extension='" + this.extension + "', codec='" + this.codec + "', bitrate=" + this.bitrate + ", averageBitrate=" + this.averageBitrate + ", iTag=" + this.iTag + ", url='" + this.url + "', approxDurationMs=" + this.approxDurationMs + '}';
    }
}
