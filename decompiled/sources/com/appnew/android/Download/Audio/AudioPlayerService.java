package com.appnew.android.Download.Audio;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.util.NotificationUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DefaultDataSourceFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.ui.PlayerNotificationManager;
import com.appnew.android.BuildConfig;
import com.appnew.android.Login.Activity.SplashScreen;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class AudioPlayerService extends Service {
    public static final String AUDIO_PLAYER_ACTION = "audio_player_action_receiver";
    public static final String RESULT = "result";
    public static final String RES_ID = "resourceId";
    private static int audioNotificationId;
    private static int currentVideoSource;
    public static boolean isAudioPlaying;
    private static String pausedTimeSpent;
    public static ExoPlayer player;
    public static String position;
    private String audioDesc;
    private Bitmap audioThumbnailBitmap;
    private String audioTitle;
    private Uri audioUri;
    private Context context;
    DashMediaSource dashMediaSource;
    ProgressiveMediaSource extractorMediaSource;
    HlsMediaSource hlsMediaSource;
    private boolean isDashContent;
    private boolean isHlsContent;
    private boolean isLiveStream;
    private MediaSessionCompat mediaSession;
    private PlayerNotificationManager playerNotificationManager;
    private String resLink;
    private Uri shareAudioUri;
    private Uri videoUri;
    private String youtubeUri;
    public static Long video_currentpos = 0L;
    public static String videoid = "";
    public static String media_id = "";
    public static String tileid = "";
    public static String tiletype = "";
    public static String type = "";
    private static String histStartTime = null;
    private final String TAG = "AudioPlayerService";
    private final String NOTIFICATION_CHANNEL = BuildConfig.AUDIO_SERVICE_CHANNEL;
    private Player.Listener playerEventListener = new Player.Listener() { // from class: com.appnew.android.Download.Audio.AudioPlayerService.3
        @Override // androidx.media3.common.Player.Listener
        public void onPlayerError(PlaybackException error) {
            super.onPlayerError(error);
            if (!Helper.isBehindLiveWindow(error) && AudioPlayerService.isAudioPlaying) {
                AudioPlayerService.this.releaseAll();
                AudioPlayerService.isAudioPlaying = false;
                AudioPlayerService.this.stopForeground(true);
                AudioPlayerService.this.stopSelf();
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.context = this;
        this.audioThumbnailBitmap = MakeMyExam.bitmap;
        initNotificationManager();
    }

    public void releaseAll() {
        try {
            PlayerNotificationManager playerNotificationManager = this.playerNotificationManager;
            if (playerNotificationManager != null) {
                playerNotificationManager.setPlayer(null);
                this.playerNotificationManager = null;
            }
            ExoPlayer exoPlayer = player;
            if (exoPlayer != null) {
                video_currentpos = Long.valueOf(exoPlayer.getCurrentPosition());
                player.release();
                player = null;
            }
            MediaSessionCompat mediaSessionCompat = this.mediaSession;
            if (mediaSessionCompat != null) {
                if (mediaSessionCompat.isActive()) {
                    this.mediaSession.setActive(false);
                }
                this.mediaSession.release();
                this.mediaSession = null;
            }
            isAudioPlaying = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void initNotificationManager() {
        try {
            if (this.context == null) {
                this.context = this;
            }
            releaseAll();
            NotificationUtil.createNotificationChannel(this.context, BuildConfig.AUDIO_SERVICE_CHANNEL, R.string.app_name, R.string.app_name, 0);
            player = new ExoPlayer.Builder(this).setSeekBackIncrementMs(10000L).setSeekForwardIncrementMs(10000L).build();
            this.playerNotificationManager = new PlayerNotificationManager.Builder(this.context, audioNotificationID(), BuildConfig.AUDIO_SERVICE_CHANNEL).setMediaDescriptionAdapter(new PlayerNotificationManager.MediaDescriptionAdapter() { // from class: com.appnew.android.Download.Audio.AudioPlayerService.2
                @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
                public String getCurrentContentTitle(Player player2) {
                    return AudioPlayerService.this.audioTitle;
                }

                @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
                public PendingIntent createCurrentContentIntent(Player player2) {
                    Intent intent = new Intent(AudioPlayerService.this, (Class<?>) SplashScreen.class);
                    intent.putExtra("url", AudioPlayerService.this.youtubeUri);
                    intent.putExtra(SDKConstants.PARAM_A2U_MEDIA_ID, AudioPlayerService.media_id);
                    intent.putExtra("type", AudioPlayerService.type);
                    intent.putExtra("videoid", AudioPlayerService.videoid);
                    intent.putExtra("tileid", AudioPlayerService.tileid == null ? "" : AudioPlayerService.tileid);
                    intent.putExtra("tiletype", AudioPlayerService.tiletype != null ? AudioPlayerService.tileid : "");
                    intent.setFlags(603979776);
                    return PendingIntent.getActivity(AudioPlayerService.this.getApplicationContext(), AudioPlayerService.audioNotificationId, intent, Build.VERSION.SDK_INT >= 31 ? GroupFlagsKt.HasAuxSlotFlag : 268435456);
                }

                @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
                public String getCurrentContentText(Player player2) {
                    return AudioPlayerService.this.audioDesc;
                }

                @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
                public Bitmap getCurrentLargeIcon(Player player2, PlayerNotificationManager.BitmapCallback callback) {
                    return AudioPlayerService.this.audioThumbnailBitmap;
                }
            }).setNotificationListener(new PlayerNotificationManager.NotificationListener() { // from class: com.appnew.android.Download.Audio.AudioPlayerService.1
                @Override // androidx.media3.ui.PlayerNotificationManager.NotificationListener
                public void onNotificationPosted(int notificationId, Notification notification, boolean ongoing) {
                    super.onNotificationPosted(notificationId, notification, ongoing);
                    try {
                        AudioPlayerService.this.startForeground(notificationId, notification);
                        AudioPlayerService.this.sendResults(false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // androidx.media3.ui.PlayerNotificationManager.NotificationListener
                public void onNotificationCancelled(int notificationId, boolean dismissedByUser) {
                    super.onNotificationCancelled(notificationId, dismissedByUser);
                    AudioPlayerService.this.stopSelf();
                    AudioPlayerService.isAudioPlaying = false;
                    AudioPlayerService.this.sendResults(true);
                }
            }).setCustomActionReceiver(new CustomAudioActionReceiverListen(this)).build();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void sendResults(boolean status) {
        Intent intent = new Intent(AUDIO_PLAYER_ACTION);
        intent.putExtra("result", status);
        intent.putExtra("resourceId", videoid);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        PlayerNotificationManager playerNotificationManager = this.playerNotificationManager;
        if (playerNotificationManager != null) {
            playerNotificationManager.setPlayer(null);
            this.playerNotificationManager = null;
            ExoPlayer exoPlayer = player;
            if (exoPlayer != null) {
                exoPlayer.release();
                player = null;
            }
        }
        pausedTimeSpent = null;
        histStartTime = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null && !intent.getAction().isEmpty()) {
            if (intent.getAction().equalsIgnoreCase("Start_Service")) {
                this.youtubeUri = intent.getStringExtra("videoUrl");
                this.audioTitle = intent.getStringExtra("audioTitle");
                videoid = intent.getStringExtra("videoid");
                media_id = intent.getStringExtra(SDKConstants.PARAM_A2U_MEDIA_ID);
                this.audioDesc = intent.getStringExtra("audioDesc");
                tileid = intent.getStringExtra("tileid");
                tiletype = intent.getStringExtra("tiletype");
                String stringExtra = intent.getStringExtra("type");
                type = stringExtra;
                if (stringExtra == null) {
                    type = "";
                }
                this.isLiveStream = intent.getBooleanExtra("isLive", false);
                video_currentpos = Long.valueOf(intent.getLongExtra("player_pos", 0L));
                if (this.isLiveStream) {
                    this.isHlsContent = true;
                }
                initPlayer();
                return 1;
            }
            if (intent.getAction().equalsIgnoreCase("Stop_Service") && isAudioPlaying) {
                releaseAll();
                videoid = "";
                media_id = "";
                isAudioPlaying = false;
                try {
                    stopForeground(true);
                    stopSelf(startId);
                } catch (Exception unused) {
                }
            }
        }
        return 2;
    }

    private int audioNotificationID() {
        int i = Integer.parseInt(new SimpleDateFormat("ddHHmmss", Locale.getDefault()).format(new Date()));
        audioNotificationId = i;
        return i;
    }

    private void initPlayer() {
        try {
            if (this.playerNotificationManager == null) {
                initNotificationManager();
            }
            this.playerNotificationManager.setPlayer(player);
            this.playerNotificationManager.setColorized(true);
            this.playerNotificationManager.setUseChronometer(true);
            this.playerNotificationManager.setSmallIcon(R.drawable.exo_notification_pause);
            this.playerNotificationManager.setBadgeIconType(0);
            this.playerNotificationManager.setVisibility(1);
            this.playerNotificationManager.setPriority(1);
            this.videoUri = Uri.parse(this.youtubeUri);
            DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, getResources().getString(R.string.app_name)));
            if (this.isHlsContent) {
                this.hlsMediaSource = new HlsMediaSource.Factory(defaultDataSourceFactory).createMediaSource(MediaItem.fromUri(this.videoUri));
                player.setPlayWhenReady(true);
                player.prepare(this.hlsMediaSource);
            } else {
                this.extractorMediaSource = new ProgressiveMediaSource.Factory(defaultDataSourceFactory).createMediaSource(MediaItem.fromUri(this.videoUri));
                player.setPlayWhenReady(true);
                player.prepare(this.extractorMediaSource);
            }
            if (this.isDashContent) {
                this.dashMediaSource = new DashMediaSource.Factory(defaultDataSourceFactory).createMediaSource(MediaItem.fromUri(this.videoUri));
                player.setPlayWhenReady(true);
                player.prepare(this.dashMediaSource);
            } else if (this.isHlsContent) {
                this.hlsMediaSource = new HlsMediaSource.Factory(defaultDataSourceFactory).createMediaSource(MediaItem.fromUri(this.videoUri));
                player.setPlayWhenReady(true);
                player.prepare(this.hlsMediaSource);
            } else if (!this.youtubeUri.isEmpty() && (this.youtubeUri.contains("jwplayer") || this.youtubeUri.contains("jwplatform"))) {
                this.extractorMediaSource = new ProgressiveMediaSource.Factory(defaultDataSourceFactory).createMediaSource(MediaItem.fromUri(this.videoUri));
                player.setPlayWhenReady(true);
                player.prepare(this.extractorMediaSource);
            }
            player.addListener(this.playerEventListener);
            player.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), true);
            isAudioPlaying = true;
            player.seekTo(video_currentpos.longValue());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        UtkashRoom.destroyInstance();
    }
}
