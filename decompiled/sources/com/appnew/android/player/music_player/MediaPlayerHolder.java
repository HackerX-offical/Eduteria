package com.appnew.android.player.music_player;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.appnew.android.Model.Song;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revosleap.samplemusicplayer.playback.PlaybackInfoListener;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaPlayerHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b-\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002RSB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0019H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0016J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\rH\u0016J\b\u00101\u001a\u00020'H\u0016J\b\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u000fH\u0016J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u001bH\u0002J\u0006\u00109\u001a\u00020'J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\b\u0010<\u001a\u00020'H\u0002J\b\u0010=\u001a\u00020'H\u0002J\b\u0010>\u001a\u00020'H\u0002J\b\u0010?\u001a\u00020'H\u0016J\u0010\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020\u001bH\u0016J\n\u0010B\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010C\u001a\u00020'2\u0006\u00100\u001a\u00020\rH\u0016J\b\u0010D\u001a\u00020'H\u0016J\b\u0010E\u001a\u00020\u0019H\u0016J\b\u0010F\u001a\u00020'H\u0016J\b\u0010G\u001a\u00020\u001bH\u0016J\b\u0010H\u001a\u00020\u0019H\u0016J\b\u0010I\u001a\u00020'H\u0016J\b\u0010J\u001a\u00020\u0019H\u0016J\u0010\u0010K\u001a\u00020'2\u0006\u0010L\u001a\u00020\u0019H\u0016J\u0010\u0010M\u001a\u00020'2\u0006\u0010L\u001a\u00020\u0019H\u0002J\u0010\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020\u001bH\u0016J\b\u0010P\u001a\u00020\u001bH\u0016J\b\u0010Q\u001a\u00020'H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/appnew/android/player/music_player/MediaPlayerHolder;", "Lcom/appnew/android/player/music_player/PlayerAdapter;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Landroid/media/MediaPlayer$OnPreparedListener;", "mMusicService", "Lcom/appnew/android/player/music_player/MusicService;", "<init>", "(Lcom/appnew/android/player/music_player/MusicService;)V", "mContext", "Landroid/content/Context;", "mAudioManager", "Landroid/media/AudioManager;", "mMediaPlayer", "Landroid/media/MediaPlayer;", "mPlaybackInfoListener", "Lcom/revosleap/samplemusicplayer/playback/PlaybackInfoListener;", "mExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "mSeekBarPositionUpdateTask", "Ljava/lang/Runnable;", "mSelectedSong", "Lcom/appnew/android/Model/Song;", "mSongs", "", "sReplaySong", "", "mState", "", "getMState$annotations", "()V", "mNotificationActionsReceiver", "Lcom/appnew/android/player/music_player/MediaPlayerHolder$NotificationReceiver;", "mMusicNotificationManager", "Lcom/appnew/android/player/music_player/MusicNotificationManager;", "mCurrentAudioFocusState", "mPlayOnFocusGain", "mOnAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "registerActionsReceiver", "", "unregisterActionsReceiver", "registerNotificationActionsReceiver", "isReceiver", "getCurrentSong", "setCurrentSong", "song", "songs", "onCompletion", "mediaPlayer", "onResumeActivity", "onPauseActivity", "tryToGetAudioFocus", "giveUpAudioFocus", "setPlaybackInfoListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStatus", "state", "resumeMediaPlayer", "pauseMediaPlayer", "resetSong", "startUpdatingCallbackWithPosition", "stopUpdatingCallbackWithPosition", "updateProgressCallbackTask", "instantReset", "initMediaPlayer", Constants.INAPP_POSITION, "getMediaPlayer", "onPrepared", "release", "isPlaying", "resumeOrPause", "getState", "isMediaPlayer", "reset", "isReset", "skip", "isNext", "getSkipSong", "seekTo", Const.POSITION, "getPlayerPosition", "configurePlayerState", "NotificationReceiver", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaPlayerHolder implements PlayerAdapter, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {
    private static final int AUDIO_NO_FOCUS_NO_DUCK = 0;
    private final AudioManager mAudioManager;
    private final Context mContext;
    private ScheduledExecutorService mExecutor;
    private MediaPlayer mMediaPlayer;
    private MusicNotificationManager mMusicNotificationManager;
    private final MusicService mMusicService;
    private NotificationReceiver mNotificationActionsReceiver;
    private boolean mPlayOnFocusGain;
    private PlaybackInfoListener mPlaybackInfoListener;
    private Runnable mSeekBarPositionUpdateTask;
    private Song mSelectedSong;
    private List<Song> mSongs;
    private int mState;
    private boolean sReplaySong;
    public static final int $stable = 8;
    private static final float VOLUME_DUCK = 0.2f;
    private static final float VOLUME_NORMAL = 1.0f;
    private static final int AUDIO_NO_FOCUS_CAN_DUCK = 1;
    private static final int AUDIO_FOCUSED = 2;
    private int mCurrentAudioFocusState = AUDIO_NO_FOCUS_NO_DUCK;
    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.appnew.android.player.music_player.MediaPlayerHolder$$ExternalSyntheticLambda1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i) {
            MediaPlayerHolder.mOnAudioFocusChangeListener$lambda$0(this.f$0, i);
        }
    };

    private static /* synthetic */ void getMState$annotations() {
    }

    public MediaPlayerHolder(MusicService musicService) {
        this.mMusicService = musicService;
        Intrinsics.checkNotNull(musicService);
        Context applicationContext = musicService.getApplicationContext();
        this.mContext = applicationContext;
        Object systemService = applicationContext.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mAudioManager = (AudioManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOnAudioFocusChangeListener$lambda$0(MediaPlayerHolder mediaPlayerHolder, int i) {
        if (i != -3) {
            boolean z = true;
            if (i == -2) {
                mediaPlayerHolder.mCurrentAudioFocusState = AUDIO_NO_FOCUS_NO_DUCK;
                if ((!mediaPlayerHolder.isMediaPlayer() || mediaPlayerHolder.mState != 0) && mediaPlayerHolder.mState != 3) {
                    z = false;
                }
                mediaPlayerHolder.mPlayOnFocusGain = z;
            } else if (i == -1) {
                mediaPlayerHolder.mCurrentAudioFocusState = AUDIO_NO_FOCUS_NO_DUCK;
            } else if (i == 1) {
                mediaPlayerHolder.mCurrentAudioFocusState = AUDIO_FOCUSED;
            }
        } else {
            mediaPlayerHolder.mCurrentAudioFocusState = AUDIO_NO_FOCUS_CAN_DUCK;
        }
        if (mediaPlayerHolder.mMediaPlayer != null) {
            mediaPlayerHolder.configurePlayerState();
        }
    }

    private final void registerActionsReceiver() {
        this.mNotificationActionsReceiver = new NotificationReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MusicNotificationManager.INSTANCE.getPREV_ACTION$app_EDUTERIARelease());
        intentFilter.addAction(MusicNotificationManager.INSTANCE.getPLAY_PAUSE_ACTION$app_EDUTERIARelease());
        intentFilter.addAction(MusicNotificationManager.INSTANCE.getNEXT_ACTION$app_EDUTERIARelease());
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        MusicService musicService = this.mMusicService;
        Intrinsics.checkNotNull(musicService);
        musicService.registerReceiver(this.mNotificationActionsReceiver, intentFilter);
    }

    private final void unregisterActionsReceiver() {
        NotificationReceiver notificationReceiver;
        MusicService musicService = this.mMusicService;
        if (musicService == null || (notificationReceiver = this.mNotificationActionsReceiver) == null) {
            return;
        }
        try {
            musicService.unregisterReceiver(notificationReceiver);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void registerNotificationActionsReceiver(boolean isReceiver) {
        if (isReceiver) {
            registerActionsReceiver();
        } else {
            unregisterActionsReceiver();
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    /* JADX INFO: renamed from: getCurrentSong, reason: from getter */
    public Song getMSelectedSong() {
        return this.mSelectedSong;
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void setCurrentSong(Song song, List<Song> songs) {
        Intrinsics.checkNotNullParameter(song, "song");
        Intrinsics.checkNotNullParameter(songs, "songs");
        this.mSelectedSong = song;
        this.mSongs = songs;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
        PlaybackInfoListener playbackInfoListener = this.mPlaybackInfoListener;
        if (playbackInfoListener != null) {
            Intrinsics.checkNotNull(playbackInfoListener);
            playbackInfoListener.onStateChanged(2);
            PlaybackInfoListener playbackInfoListener2 = this.mPlaybackInfoListener;
            Intrinsics.checkNotNull(playbackInfoListener2);
            playbackInfoListener2.onPlaybackCompleted();
        }
        if (this.sReplaySong) {
            if (isMediaPlayer()) {
                resetSong();
            }
            this.sReplaySong = false;
            return;
        }
        skip(true);
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void onResumeActivity() {
        startUpdatingCallbackWithPosition();
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void onPauseActivity() {
        stopUpdatingCallbackWithPosition();
    }

    private final void tryToGetAudioFocus() {
        if (this.mAudioManager.requestAudioFocus(this.mOnAudioFocusChangeListener, 3, 1) == 1) {
            this.mCurrentAudioFocusState = AUDIO_FOCUSED;
        } else {
            this.mCurrentAudioFocusState = AUDIO_NO_FOCUS_NO_DUCK;
        }
    }

    private final void giveUpAudioFocus() {
        if (this.mAudioManager.abandonAudioFocus(this.mOnAudioFocusChangeListener) == 1) {
            this.mCurrentAudioFocusState = AUDIO_NO_FOCUS_NO_DUCK;
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void setPlaybackInfoListener(PlaybackInfoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPlaybackInfoListener = listener;
    }

    private final void setStatus(int state) {
        this.mState = state;
        PlaybackInfoListener playbackInfoListener = this.mPlaybackInfoListener;
        if (playbackInfoListener != null) {
            Intrinsics.checkNotNull(playbackInfoListener);
            playbackInfoListener.onStateChanged(state);
        }
    }

    public final void resumeMediaPlayer() {
        if (isPlaying()) {
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.start();
        setStatus(3);
        MusicService musicService = this.mMusicService;
        Intrinsics.checkNotNull(musicService);
        int notification_id = MusicNotificationManager.INSTANCE.getNOTIFICATION_ID();
        MusicNotificationManager musicNotificationManager = this.mMusicNotificationManager;
        Intrinsics.checkNotNull(musicNotificationManager);
        musicService.startForeground(notification_id, musicNotificationManager.createNotification());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pauseMediaPlayer() {
        setStatus(1);
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.pause();
        MusicService musicService = this.mMusicService;
        Intrinsics.checkNotNull(musicService);
        musicService.stopForeground(false);
        MusicNotificationManager musicNotificationManager = this.mMusicNotificationManager;
        Intrinsics.checkNotNull(musicNotificationManager);
        NotificationManager notificationManager = musicNotificationManager.getNotificationManager();
        int notification_id = MusicNotificationManager.INSTANCE.getNOTIFICATION_ID();
        MusicNotificationManager musicNotificationManager2 = this.mMusicNotificationManager;
        Intrinsics.checkNotNull(musicNotificationManager2);
        notificationManager.notify(notification_id, musicNotificationManager2.createNotification());
    }

    private final void resetSong() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        mediaPlayer.seekTo(0);
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer2);
        mediaPlayer2.start();
        setStatus(0);
    }

    private final void startUpdatingCallbackWithPosition() {
        if (this.mExecutor == null) {
            this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        }
        if (this.mSeekBarPositionUpdateTask == null) {
            this.mSeekBarPositionUpdateTask = new Runnable() { // from class: com.appnew.android.player.music_player.MediaPlayerHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.updateProgressCallbackTask();
                }
            };
        }
        ScheduledExecutorService scheduledExecutorService = this.mExecutor;
        Intrinsics.checkNotNull(scheduledExecutorService);
        scheduledExecutorService.scheduleAtFixedRate(this.mSeekBarPositionUpdateTask, 0L, 1000L, TimeUnit.MILLISECONDS);
    }

    private final void stopUpdatingCallbackWithPosition() {
        ScheduledExecutorService scheduledExecutorService = this.mExecutor;
        if (scheduledExecutorService != null) {
            Intrinsics.checkNotNull(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
            this.mExecutor = null;
            this.mSeekBarPositionUpdateTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProgressCallbackTask() {
        if (isMediaPlayer()) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = this.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer2);
                int currentPosition = mediaPlayer2.getCurrentPosition();
                PlaybackInfoListener playbackInfoListener = this.mPlaybackInfoListener;
                if (playbackInfoListener != null) {
                    Intrinsics.checkNotNull(playbackInfoListener);
                    playbackInfoListener.onPositionChanged(currentPosition);
                }
            }
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void instantReset() {
        if (isMediaPlayer()) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.getCurrentPosition() < 5000) {
                skip(false);
            } else {
                resetSong();
            }
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void initMediaPlayer(int pos) {
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                Intrinsics.checkNotNull(mediaPlayer);
                mediaPlayer.reset();
            } else {
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                this.mMediaPlayer = mediaPlayer2;
                Intrinsics.checkNotNull(mediaPlayer2);
                mediaPlayer2.setOnPreparedListener(this);
                MediaPlayer mediaPlayer3 = this.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer3);
                mediaPlayer3.setOnCompletionListener(this);
                MediaPlayer mediaPlayer4 = this.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer4);
                mediaPlayer4.setWakeMode(this.mContext, 1);
                MediaPlayer mediaPlayer5 = this.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer5);
                mediaPlayer5.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
                MusicService musicService = this.mMusicService;
                Intrinsics.checkNotNull(musicService);
                this.mMusicNotificationManager = musicService.getMusicNotificationManager();
            }
            tryToGetAudioFocus();
            try {
                MediaPlayer mediaPlayer6 = this.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer6);
                Song song = this.mSelectedSong;
                Intrinsics.checkNotNull(song);
                mediaPlayer6.setDataSource(song.getPath());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                MediaPlayer mediaPlayer7 = this.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer7);
                mediaPlayer7.prepare();
                MediaPlayer mediaPlayer8 = this.mMediaPlayer;
                Intrinsics.checkNotNull(mediaPlayer8);
                mediaPlayer8.seekTo(pos);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    /* JADX INFO: renamed from: getMediaPlayer, reason: from getter */
    public MediaPlayer getMMediaPlayer() {
        return this.mMediaPlayer;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
        startUpdatingCallbackWithPosition();
        setStatus(0);
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void release() {
        if (isMediaPlayer()) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            mediaPlayer.release();
            this.mMediaPlayer = null;
            giveUpAudioFocus();
            unregisterActionsReceiver();
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public boolean isPlaying() {
        if (!isMediaPlayer()) {
            return false;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        return mediaPlayer.isPlaying();
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void resumeOrPause() {
        if (isPlaying()) {
            pauseMediaPlayer();
        } else {
            resumeMediaPlayer();
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    /* JADX INFO: renamed from: getState, reason: from getter */
    public int getMState() {
        return this.mState;
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public boolean isMediaPlayer() {
        return this.mMediaPlayer != null;
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void reset() {
        this.sReplaySong = !this.sReplaySong;
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    /* JADX INFO: renamed from: isReset, reason: from getter */
    public boolean getSReplaySong() {
        return this.sReplaySong;
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void skip(boolean isNext) {
        getSkipSong(isNext);
    }

    private final void getSkipSong(boolean isNext) {
        Song song;
        List<Song> list = this.mSongs;
        Intrinsics.checkNotNull(list);
        int iIndexOf = CollectionsKt.indexOf((List<? extends Song>) list, this.mSelectedSong);
        int i = isNext ? iIndexOf + 1 : iIndexOf - 1;
        try {
            List<Song> list2 = this.mSongs;
            Intrinsics.checkNotNull(list2);
            this.mSelectedSong = list2.get(i);
        } catch (IndexOutOfBoundsException e2) {
            if (iIndexOf != 0) {
                List<Song> list3 = this.mSongs;
                Intrinsics.checkNotNull(list3);
                song = list3.get(0);
            } else {
                List<Song> list4 = this.mSongs;
                Intrinsics.checkNotNull(list4);
                Intrinsics.checkNotNull(this.mSongs);
                song = list4.get(r2.size() - 1);
            }
            this.mSelectedSong = song;
            e2.printStackTrace();
        }
        initMediaPlayer(0);
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public void seekTo(int position) {
        if (isMediaPlayer()) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            mediaPlayer.seekTo(position);
        }
    }

    @Override // com.appnew.android.player.music_player.PlayerAdapter
    public int getPlayerPosition() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        return mediaPlayer.getCurrentPosition();
    }

    private final void configurePlayerState() {
        int i = this.mCurrentAudioFocusState;
        if (i == AUDIO_NO_FOCUS_NO_DUCK) {
            pauseMediaPlayer();
            return;
        }
        if (i == AUDIO_NO_FOCUS_CAN_DUCK) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            float f2 = VOLUME_DUCK;
            mediaPlayer.setVolume(f2, f2);
        } else {
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer2);
            float f3 = VOLUME_NORMAL;
            mediaPlayer2.setVolume(f3, f3);
        }
        if (this.mPlayOnFocusGain) {
            resumeMediaPlayer();
            this.mPlayOnFocusGain = false;
        }
    }

    /* JADX INFO: compiled from: MediaPlayerHolder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/appnew/android/player/music_player/MediaPlayerHolder$NotificationReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/appnew/android/player/music_player/MediaPlayerHolder;)V", "onReceive", "", "context", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class NotificationReceiver extends BroadcastReceiver {
        public NotificationReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                if (Intrinsics.areEqual(action, MusicNotificationManager.INSTANCE.getPREV_ACTION$app_EDUTERIARelease())) {
                    MediaPlayerHolder.this.instantReset();
                    return;
                }
                if (Intrinsics.areEqual(action, MusicNotificationManager.INSTANCE.getPLAY_PAUSE_ACTION$app_EDUTERIARelease())) {
                    MediaPlayerHolder.this.resumeOrPause();
                    return;
                }
                if (Intrinsics.areEqual(action, MusicNotificationManager.INSTANCE.getNEXT_ACTION$app_EDUTERIARelease())) {
                    MediaPlayerHolder.this.skip(true);
                    return;
                }
                if (Intrinsics.areEqual(action, "android.bluetooth.device.action.ACL_DISCONNECTED")) {
                    if (MediaPlayerHolder.this.mSelectedSong != null) {
                        MediaPlayerHolder.this.pauseMediaPlayer();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(action, "android.bluetooth.device.action.ACL_CONNECTED")) {
                    if (MediaPlayerHolder.this.mSelectedSong == null || MediaPlayerHolder.this.isPlaying()) {
                        return;
                    }
                    MediaPlayerHolder.this.resumeMediaPlayer();
                    return;
                }
                if (Intrinsics.areEqual(action, "android.intent.action.HEADSET_PLUG")) {
                    if (MediaPlayerHolder.this.mSelectedSong != null) {
                        int intExtra = intent.getIntExtra("state", -1);
                        if (intExtra == 0) {
                            MediaPlayerHolder.this.pauseMediaPlayer();
                            return;
                        } else {
                            if (intExtra == 1 && !MediaPlayerHolder.this.isPlaying()) {
                                MediaPlayerHolder.this.resumeMediaPlayer();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (Intrinsics.areEqual(action, "android.media.AUDIO_BECOMING_NOISY") && MediaPlayerHolder.this.isPlaying()) {
                    MediaPlayerHolder.this.pauseMediaPlayer();
                }
            }
        }
    }
}
