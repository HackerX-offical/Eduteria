package com.pallycon.widevine.track;

import androidx.media3.common.Format;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/pallycon/widevine/track/VideoTrackInfo;", "Lcom/pallycon/widevine/track/TrackInfo;", "format", "Landroidx/media3/common/Format;", "(Landroidx/media3/common/Format;)V", "frameRate", "", "getFrameRate", "()F", "setFrameRate", "(F)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "getHeight", "()I", "setHeight", "(I)V", "maxInputSize", "getMaxInputSize", "setMaxInputSize", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth", "setWidth", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VideoTrackInfo extends TrackInfo {
    private float frameRate;
    private int height;
    private int maxInputSize;
    private int width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTrackInfo(Format format) {
        super(format);
        Intrinsics.checkNotNullParameter(format, "format");
        this.width = format.width;
        this.height = format.height;
        this.maxInputSize = format.maxInputSize;
        this.frameRate = format.frameRate;
    }

    public final float getFrameRate() {
        return this.frameRate;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMaxInputSize() {
        return this.maxInputSize;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setFrameRate(float f2) {
        this.frameRate = f2;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setMaxInputSize(int i) {
        this.maxInputSize = i;
    }

    public final void setWidth(int i) {
        this.width = i;
    }
}
