package com.pallycon.widevine.track;

import androidx.media3.common.Format;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/track/TextTrackInfo;", "Lcom/pallycon/widevine/track/TrackInfo;", "format", "Landroidx/media3/common/Format;", "(Landroidx/media3/common/Format;)V", "getFormat", "()Landroidx/media3/common/Format;", "setFormat", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TextTrackInfo extends TrackInfo {
    private Format format;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextTrackInfo(Format format) {
        super(format);
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
    }

    public final Format getFormat() {
        return this.format;
    }

    public final void setFormat(Format format) {
        Intrinsics.checkNotNullParameter(format, "<set-?>");
        this.format = format;
    }
}
