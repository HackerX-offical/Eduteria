package com.appnew.android.player.music_player;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.util.NotificationUtil;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.ui.PlayerNotificationManager;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.player.AudioPlayerActivity;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MusicService.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0003J\b\u0010,\u001a\u00020*H\u0002J\u0006\u00100\u001a\u00020*J\b\u00101\u001a\u00020*H\u0016J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u0010%\u001a\u00020&H\u0016J\b\u00104\u001a\u00020\u000bH\u0002J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020*H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u00069"}, d2 = {"Lcom/appnew/android/player/music_player/MusicService;", "Landroid/app/Service;", "<init>", "()V", Const.VIDEODATA, "Lcom/appnew/android/Model/Video;", "videoUrl", "", "audioDesc", "audioTitle", "audioNotificationId", "", "playerSpeed", "audioThumbnailBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "value", "Lcom/appnew/android/player/music_player/MediaPlayerHolder;", "mediaPlayerHolder", "getMediaPlayerHolder", "()Lcom/appnew/android/player/music_player/MediaPlayerHolder;", "Lcom/appnew/android/player/music_player/MusicNotificationManager;", "musicNotificationManager", "getMusicNotificationManager", "()Lcom/appnew/android/player/music_player/MusicNotificationManager;", "isRestoredFromPause", "", "()Z", "setRestoredFromPause", "(Z)V", "NOTIFICATION_CHANNEL", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "playerNotificationManager", "Landroidx/media3/ui/PlayerNotificationManager;", "onStartCommand", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "flags", "startId", "onCreate", "", "initNotificationManager", "initPlayer", "playerEventListener", "com/appnew/android/player/music_player/MusicService$playerEventListener$1", "Lcom/appnew/android/player/music_player/MusicService$playerEventListener$1;", "releaseAll", "onDestroy", "onBind", "Landroid/os/IBinder;", "audioNotificationID", "sendResults", "status", "sendOnAudioPlayer", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicService extends Service {
    public static final String MUSIC_PLAYER_ACTION_STOP = "music_player_action_stop_receiver";
    public static final String RESULT = "result";
    public static final String RES_ID = "resourceId";
    public static final String VIDEO_POS = "video_pos";
    private static boolean isAudioPlaying;
    private static int video_currentpos;
    private int audioNotificationId;
    private Bitmap audioThumbnailBitmap;
    private Context context;
    private boolean isRestoredFromPause;
    private MediaPlayerHolder mediaPlayerHolder;
    private MusicNotificationManager musicNotificationManager;
    private ExoPlayer player;
    private PlayerNotificationManager playerNotificationManager;
    private Video videodata;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static String videoid = "";
    private static final String MUSIC_PLAYER_ACTION = "music_player_action_receiver";
    private String videoUrl = "";
    private String audioDesc = "";
    private String audioTitle = "";
    private String playerSpeed = "";
    private final String NOTIFICATION_CHANNEL = "EDUTERIA_Channel_NewAudio_Player";
    private final MusicService$playerEventListener$1 playerEventListener = new Player.Listener() { // from class: com.appnew.android.player.music_player.MusicService$playerEventListener$1
        @Override // androidx.media3.common.Player.Listener
        public void onPlayerError(PlaybackException error) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (Helper.isBehindLiveWindow(error)) {
                return;
            }
            this.this$0.releaseAll();
            this.this$0.stopForeground(true);
            this.this$0.stopSelf();
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    public final MediaPlayerHolder getMediaPlayerHolder() {
        return this.mediaPlayerHolder;
    }

    public final MusicNotificationManager getMusicNotificationManager() {
        return this.musicNotificationManager;
    }

    /* JADX INFO: renamed from: isRestoredFromPause, reason: from getter */
    public final boolean getIsRestoredFromPause() {
        return this.isRestoredFromPause;
    }

    public final void setRestoredFromPause(boolean z) {
        this.isRestoredFromPause = z;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            return 2;
        }
        int iHashCode = action.hashCode();
        if (iHashCode == -1721469032) {
            if (!action.equals("Start_Service")) {
                return 2;
            }
            this.videoUrl = intent.getStringExtra("videoUrl");
            this.audioTitle = String.valueOf(intent.getStringExtra("title"));
            this.audioDesc = String.valueOf(intent.getStringExtra("subTitle"));
            video_currentpos = intent.getIntExtra("player_pos", 0);
            videoid = String.valueOf(intent.getStringExtra(Const.VIDEO_ID));
            this.playerSpeed = String.valueOf(intent.getStringExtra("playerSpeed"));
            Serializable serializableExtra = intent.getSerializableExtra(Const.VIDEODATA);
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.appnew.android.Model.Video");
            this.videodata = (Video) serializableExtra;
            Log.e("onStartCommand", "Start_Service: " + video_currentpos);
            initPlayer();
            return 2;
        }
        if (iHashCode != 638467960 || !action.equals("Stop_Service") || !isAudioPlaying) {
            return 2;
        }
        releaseAll();
        stopForeground(true);
        stopSelf(startId);
        return 2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.context = this;
        this.audioThumbnailBitmap = MakeMyExam.bitmap;
        initNotificationManager();
        Log.e("TAG", "onCreate: ");
    }

    private final void initNotificationManager() {
        try {
            if (this.context == null) {
                this.context = this;
            }
            releaseAll();
            NotificationUtil.createNotificationChannel(this, this.NOTIFICATION_CHANNEL, R.string.app_name, R.string.app_name, 0);
            this.player = new ExoPlayer.Builder(this).setSeekBackIncrementMs(10000L).setSeekForwardIncrementMs(10000L).build();
            this.playerNotificationManager = new PlayerNotificationManager.Builder(this, audioNotificationID(), this.NOTIFICATION_CHANNEL).setMediaDescriptionAdapter(new PlayerNotificationManager.MediaDescriptionAdapter() { // from class: com.appnew.android.player.music_player.MusicService.initNotificationManager.1
                @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
                public String getCurrentContentTitle(Player player) {
                    Intrinsics.checkNotNullParameter(player, "player");
                    return MusicService.this.audioTitle;
                }

                @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
                public PendingIntent createCurrentContentIntent(Player player) {
                    Intrinsics.checkNotNullParameter(player, "player");
                    Intent intent = new Intent(MusicService.this, (Class<?>) AudioPlayerActivity.class);
                    MusicService musicService = MusicService.this;
                    intent.putExtra("videoUrl", musicService.videoUrl);
                    intent.putExtra("title", musicService.audioTitle);
                    intent.putExtra("subTitle", musicService.audioDesc);
                    intent.putExtra("player_pos", MusicService.INSTANCE.getVideo_currentpos());
                    intent.putExtra(Constants.INAPP_POSITION, MusicService.INSTANCE.getVideo_currentpos());
                    intent.putExtra(Const.VIDEO_ID, MusicService.INSTANCE.getVideoid());
                    intent.putExtra(Const.VIDEODATA, musicService.videodata);
                    MusicService.INSTANCE.setVideo_currentpos((int) player.getCurrentPosition());
                    Log.e("initNotification:: ", "createCurrentContentIntent: " + MusicService.INSTANCE.getVideo_currentpos());
                    intent.setFlags(603979776);
                    return PendingIntent.getActivity(MusicService.this.getApplicationContext(), MusicService.this.audioNotificationId, intent, Build.VERSION.SDK_INT >= 31 ? GroupFlagsKt.HasAuxSlotFlag : 268435456);
                }

                @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
                public String getCurrentContentText(Player player) {
                    Intrinsics.checkNotNullParameter(player, "player");
                    return MusicService.this.audioDesc;
                }

                @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
                public Bitmap getCurrentLargeIcon(Player player, PlayerNotificationManager.BitmapCallback callback) {
                    Intrinsics.checkNotNullParameter(player, "player");
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    return MusicService.this.audioThumbnailBitmap;
                }
            }).setNotificationListener(new PlayerNotificationManager.NotificationListener() { // from class: com.appnew.android.player.music_player.MusicService.initNotificationManager.2
                @Override // androidx.media3.ui.PlayerNotificationManager.NotificationListener
                public void onNotificationPosted(int notificationId, Notification notification, boolean ongoing) {
                    Intrinsics.checkNotNullParameter(notification, "notification");
                    MusicService.this.startForeground(notificationId, notification);
                    MusicService.this.sendResults(false);
                }

                @Override // androidx.media3.ui.PlayerNotificationManager.NotificationListener
                public void onNotificationCancelled(int notificationId, boolean dismissedByUser) {
                    MusicService.this.stopSelf();
                    MusicService.INSTANCE.setAudioPlaying(false);
                    MusicService.this.sendResults(true);
                }
            }).build();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void initPlayer() {
        try {
            if (this.playerNotificationManager == null) {
                initNotificationManager();
            }
            PlayerNotificationManager playerNotificationManager = this.playerNotificationManager;
            if (playerNotificationManager != null) {
                playerNotificationManager.setPlayer(this.player);
            }
            PlayerNotificationManager playerNotificationManager2 = this.playerNotificationManager;
            if (playerNotificationManager2 != null) {
                playerNotificationManager2.setColorized(true);
            }
            PlayerNotificationManager playerNotificationManager3 = this.playerNotificationManager;
            if (playerNotificationManager3 != null) {
                playerNotificationManager3.setUseChronometer(true);
            }
            PlayerNotificationManager playerNotificationManager4 = this.playerNotificationManager;
            if (playerNotificationManager4 != null) {
                playerNotificationManager4.setSmallIcon(R.drawable.exo_notification_pause);
            }
            PlayerNotificationManager playerNotificationManager5 = this.playerNotificationManager;
            if (playerNotificationManager5 != null) {
                playerNotificationManager5.setBadgeIconType(0);
            }
            PlayerNotificationManager playerNotificationManager6 = this.playerNotificationManager;
            if (playerNotificationManager6 != null) {
                playerNotificationManager6.setVisibility(1);
            }
            PlayerNotificationManager playerNotificationManager7 = this.playerNotificationManager;
            if (playerNotificationManager7 != null) {
                playerNotificationManager7.setPriority(1);
            }
            ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(new DefaultDataSource.Factory(this));
            String str = this.videoUrl;
            Intrinsics.checkNotNull(str);
            ProgressiveMediaSource progressiveMediaSourceCreateMediaSource = factory.createMediaSource(MediaItem.fromUri(str));
            Intrinsics.checkNotNullExpressionValue(progressiveMediaSourceCreateMediaSource, "createMediaSource(...)");
            ProgressiveMediaSource progressiveMediaSource = progressiveMediaSourceCreateMediaSource;
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.setMediaSource(progressiveMediaSource);
                exoPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), true);
                exoPlayer.setPlayWhenReady(true);
                exoPlayer.seekTo(video_currentpos);
                if (StringsKt.equals(this.playerSpeed, Const.Normal, true)) {
                    exoPlayer.setPlaybackSpeed(1.0f);
                } else {
                    exoPlayer.setPlaybackSpeed(Float.parseFloat(StringsKt.replace$default(this.playerSpeed, "x", "", false, 4, (Object) null)));
                }
                exoPlayer.prepare();
                exoPlayer.addListener(this.playerEventListener);
            }
            isAudioPlaying = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void releaseAll() {
        try {
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                if (exoPlayer != null) {
                    sendOnAudioPlayer();
                    video_currentpos = 0;
                    Log.e("releaseAll:: ", "video_currentpos: 0");
                }
                ExoPlayer exoPlayer2 = this.player;
                if (exoPlayer2 != null) {
                    exoPlayer2.release();
                }
                this.player = null;
            }
            PlayerNotificationManager playerNotificationManager = this.playerNotificationManager;
            if (playerNotificationManager != null) {
                Intrinsics.checkNotNull(playerNotificationManager);
                playerNotificationManager.setPlayer(null);
                this.playerNotificationManager = null;
            }
            isAudioPlaying = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        releaseAll();
    }

    /* JADX INFO: compiled from: MusicService.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0017\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/appnew/android/player/music_player/MusicService$Companion;", "", "<init>", "()V", "isAudioPlaying", "", "()Z", "setAudioPlaying", "(Z)V", "video_currentpos", "", "getVideo_currentpos", "()I", "setVideo_currentpos", "(I)V", "videoid", "", "getVideoid", "()Ljava/lang/String;", "setVideoid", "(Ljava/lang/String;)V", "MUSIC_PLAYER_ACTION", "getMUSIC_PLAYER_ACTION", "MUSIC_PLAYER_ACTION_STOP", "RESULT", "RES_ID", "VIDEO_POS", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isAudioPlaying() {
            return MusicService.isAudioPlaying;
        }

        public final void setAudioPlaying(boolean z) {
            MusicService.isAudioPlaying = z;
        }

        public final int getVideo_currentpos() {
            return MusicService.video_currentpos;
        }

        public final void setVideo_currentpos(int i) {
            MusicService.video_currentpos = i;
        }

        public final String getVideoid() {
            return MusicService.videoid;
        }

        public final void setVideoid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            MusicService.videoid = str;
        }

        public final String getMUSIC_PLAYER_ACTION() {
            return MusicService.MUSIC_PLAYER_ACTION;
        }
    }

    private final int audioNotificationID() {
        Date date = new Date();
        String str = new SimpleDateFormat("ddHHmmss", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        this.audioNotificationId = Integer.parseInt(str);
        String str2 = new SimpleDateFormat("ddHHmmss", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return Integer.parseInt(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendResults(boolean status) {
        Intent intent = new Intent(MUSIC_PLAYER_ACTION);
        intent.putExtra("result", status);
        intent.putExtra("resourceId", videoid);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(...)");
        localBroadcastManager.sendBroadcast(intent);
    }

    private final void sendOnAudioPlayer() {
        Intent intent = new Intent(MUSIC_PLAYER_ACTION_STOP);
        intent.putExtra("result", true);
        intent.putExtra("resourceId", videoid);
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            Long lValueOf = exoPlayer != null ? Long.valueOf(exoPlayer.getCurrentPosition()) : null;
            Intrinsics.checkNotNull(lValueOf);
            intent.putExtra(VIDEO_POS, (int) lValueOf.longValue());
        }
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(...)");
        localBroadcastManager.sendBroadcast(intent);
    }
}
