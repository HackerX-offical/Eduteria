package com.revosleap.samplemusicplayer.playback;

import com.appnew.android.Utils.Const;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: compiled from: PlaybackInfoListener.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/revosleap/samplemusicplayer/playback/PlaybackInfoListener;", "", "<init>", "()V", "onPositionChanged", "", Const.POSITION, "", "onStateChanged", "state", "onPlaybackCompleted", "State", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PlaybackInfoListener {
    public static final int $stable = 0;

    public void onPlaybackCompleted() {
    }

    public void onPositionChanged(int position) {
    }

    public void onStateChanged(int state) {
    }

    /* JADX INFO: compiled from: PlaybackInfoListener.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/revosleap/samplemusicplayer/playback/PlaybackInfoListener$State;", "", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface State {
        public static final int COMPLETED = 2;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int INVALID = -1;
        public static final int PAUSED = 1;
        public static final int PLAYING = 0;
        public static final int RESUMED = 3;

        /* JADX INFO: compiled from: PlaybackInfoListener.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/revosleap/samplemusicplayer/playback/PlaybackInfoListener$State$Companion;", "", "<init>", "()V", "INVALID", "", "PLAYING", "PAUSED", "COMPLETED", "RESUMED", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int COMPLETED = 2;
            public static final int INVALID = -1;
            public static final int PAUSED = 1;
            public static final int PLAYING = 0;
            public static final int RESUMED = 3;

            private Companion() {
            }
        }
    }
}
