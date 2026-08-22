package com.appnew.android.player.music_player;

import android.media.MediaPlayer;
import com.appnew.android.Model.Song;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.revosleap.samplemusicplayer.playback.PlaybackInfoListener;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlayerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u000eH&J\b\u0010\u0013\u001a\u00020\u000eH&J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\tH&J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0003H&J\u001e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 H&J\b\u0010!\u001a\u00020\u000eH&J\b\u0010\"\u001a\u00020\u000eH&¨\u0006#"}, d2 = {"Lcom/appnew/android/player/music_player/PlayerAdapter;", "", "isMediaPlayer", "", "isPlaying", "isReset", "getCurrentSong", "Lcom/appnew/android/Model/Song;", "getState", "", "getPlayerPosition", "getMediaPlayer", "Landroid/media/MediaPlayer;", "initMediaPlayer", "", Constants.INAPP_POSITION, "release", "resumeOrPause", "reset", "instantReset", "skip", "isNext", "seekTo", Const.POSITION, "setPlaybackInfoListener", "playbackInfoListener", "Lcom/revosleap/samplemusicplayer/playback/PlaybackInfoListener;", "registerNotificationActionsReceiver", "isRegister", "setCurrentSong", "song", "songs", "", "onPauseActivity", "onResumeActivity", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PlayerAdapter {
    Song getCurrentSong();

    MediaPlayer getMediaPlayer();

    int getPlayerPosition();

    int getState();

    void initMediaPlayer(int pos);

    void instantReset();

    boolean isMediaPlayer();

    boolean isPlaying();

    boolean isReset();

    void onPauseActivity();

    void onResumeActivity();

    void registerNotificationActionsReceiver(boolean isRegister);

    void release();

    void reset();

    void resumeOrPause();

    void seekTo(int position);

    void setCurrentSong(Song song, List<Song> songs);

    void setPlaybackInfoListener(PlaybackInfoListener playbackInfoListener);

    void skip(boolean isNext);
}
