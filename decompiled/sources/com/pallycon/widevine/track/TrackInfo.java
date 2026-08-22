package com.pallycon.widevine.track;

import androidx.media3.common.Format;
import com.appnew.android.Utils.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R \u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/pallycon/widevine/track/TrackInfo;", "", "format", "Landroidx/media3/common/Format;", "(Landroidx/media3/common/Format;)V", "bitrate", "", "getBitrate", "()I", "setBitrate", "(I)V", "codecs", "", "getCodecs", "()Ljava/lang/String;", "setCodecs", "(Ljava/lang/String;)V", "id", "getId", "setId", "isDownload", "", "()Z", "setDownload", "(Z)V", Const.LANGUAGE, "getLanguage", "setLanguage", "sampleMimeType", "getSampleMimeType", "setSampleMimeType", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class TrackInfo {
    private int bitrate;
    private String codecs;
    private String id;
    private boolean isDownload;
    private String language;
    private String sampleMimeType;

    public TrackInfo(Format format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.id = format.id;
        this.codecs = format.codecs;
        this.sampleMimeType = format.containerMimeType;
        this.bitrate = format.bitrate;
        this.language = format.language;
        this.isDownload = false;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final String getCodecs() {
        return this.codecs;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getSampleMimeType() {
        return this.sampleMimeType;
    }

    /* JADX INFO: renamed from: isDownload, reason: from getter */
    public final boolean getIsDownload() {
        return this.isDownload;
    }

    public final void setBitrate(int i) {
        this.bitrate = i;
    }

    public final void setCodecs(String str) {
        this.codecs = str;
    }

    public final void setDownload(boolean z) {
        this.isDownload = z;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setSampleMimeType(String str) {
        this.sampleMimeType = str;
    }
}
