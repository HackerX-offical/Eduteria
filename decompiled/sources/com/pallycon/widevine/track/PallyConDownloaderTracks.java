package com.pallycon.widevine.track;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0004j\b\u0012\u0004\u0012\u00020\u0010`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/pallycon/widevine/track/PallyConDownloaderTracks;", "", "()V", "audio", "Ljava/util/ArrayList;", "Lcom/pallycon/widevine/track/AudioTrackInfo;", "Lkotlin/collections/ArrayList;", "getAudio", "()Ljava/util/ArrayList;", "setAudio", "(Ljava/util/ArrayList;)V", "text", "Lcom/pallycon/widevine/track/TextTrackInfo;", "getText", "setText", "video", "Lcom/pallycon/widevine/track/VideoTrackInfo;", "getVideo", "setVideo", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PallyConDownloaderTracks {
    private ArrayList<VideoTrackInfo> video = new ArrayList<>();
    private ArrayList<AudioTrackInfo> audio = new ArrayList<>();
    private ArrayList<TextTrackInfo> text = new ArrayList<>();

    public final ArrayList<AudioTrackInfo> getAudio() {
        return this.audio;
    }

    public final ArrayList<TextTrackInfo> getText() {
        return this.text;
    }

    public final ArrayList<VideoTrackInfo> getVideo() {
        return this.video;
    }

    public final void setAudio(ArrayList<AudioTrackInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.audio = arrayList;
    }

    public final void setText(ArrayList<TextTrackInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.text = arrayList;
    }

    public final void setVideo(ArrayList<VideoTrackInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.video = arrayList;
    }
}
