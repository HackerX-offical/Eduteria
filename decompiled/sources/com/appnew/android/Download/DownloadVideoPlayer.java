package com.appnew.android.Download;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSourceFactory;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.PlayerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AesDataSource;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.PreferencesUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.appnew.android.player.music_player.ZoomableVideoView;
import com.appnew.android.table.VideosDownload;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadVideoPlayer extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    private static DefaultBandwidthMeter BANDWIDTH_METER;
    private TextView MarqueeText;
    private Long current_pos;
    private Dialog dialog;
    private ImageView fullscren;
    private Handler handler1;
    HashMap<String, String> hashMap1;
    private String link;
    LinearLayout ll_main;
    private FrameLayout mFullScreenButton;
    private Dialog mFullScreenDialog;
    private ImageView mFullScreenIcon;
    private DataSource.Factory mediaDataSourceFactory;
    MediaSource mediaSource;
    float minute;
    NetworkCall networkCall;
    String playerSpeed;
    public PlayerView playerView;
    private ProgressBar progressBar;
    private RelativeLayout root_new;
    private Runnable runable1;
    private int savedOrientation;
    public ExoPlayer simpleExoPlayer;
    private List<Integer> sparseAdaptiveResolutionList;
    private HashMap<Integer, String> sparseAdaptiveVideoUrlList;
    private List<Integer> sparseKeyList;
    private List<Integer> sparseMuxedResolutionList;
    private HashMap<Integer, String> sparseMuxedVideoUrlList;
    private List<String> sparseOPUSAudioUrl;
    private TextView speedTV;
    private TrackSelectionHelper trackSelectionHelper;
    DefaultTrackSelector trackSelector;
    private TextView txtTimer;
    private String userAgent;
    private UtkashRoom utkashRoom;
    private String video_name;
    private TextView video_name_txt;
    private String video_time;
    private boolean mExoPlayerFullscreen = false;
    String url = "";
    private String video_id = "";
    private String video_play = "";
    private String course_id = "";
    private String tileid = "";
    private String valid_to = "";
    private String vdc_id = "";
    private String video_url = "";
    private String video_url1 = "";
    private String is_limited = "";
    private String multiplayer = "";
    private String remaining_time = "";
    private CountDownTimer countDownTimer = null;
    private CountDownTimer countDownTimer2 = null;
    public boolean isActivityLive = false;
    private long totalRemainingtime = 0;
    private long totalRemainingtime1 = 820130816;
    private String starttime = "";
    long timestamp = 0;
    private String totalTime = "";
    private String feedback_required = "";
    private String leftTime = "";
    private String demo_percent = "";
    private String remainingtime = "";
    private String video_length = "";
    long endtime = 0;
    private Long playPosition = 0L;
    private final String STATE_PLAYER_FULLSCREEN = "playerFullscreen";
    private boolean isSecure = true;
    private String video_type = "";
    boolean localapi = false;
    private boolean rePlay = true;
    Player.Listener listener = new Player.Listener() { // from class: com.appnew.android.Download.DownloadVideoPlayer.11
        @Override // androidx.media3.common.Player.Listener
        public void onEvents(Player player, Player.Events events) {
            super.onEvents(player, events);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTimelineChanged(Timeline timeline, int reason) {
            super.onTimelineChanged(timeline, reason);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMediaItemTransition(MediaItem mediaItem, int reason) {
            super.onMediaItemTransition(mediaItem, reason);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTracksChanged(Tracks tracks) {
            super.onTracksChanged(tracks);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            super.onMediaMetadataChanged(mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            super.onPlaylistMetadataChanged(mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onIsLoadingChanged(boolean isLoading) {
            super.onIsLoadingChanged(isLoading);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onLoadingChanged(boolean isLoading) {
            super.onLoadingChanged(isLoading);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAvailableCommandsChanged(Player.Commands availableCommands) {
            super.onAvailableCommandsChanged(availableCommands);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTrackSelectionParametersChanged(TrackSelectionParameters parameters) {
            super.onTrackSelectionParametersChanged(parameters);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.media3.common.Player.Listener
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
            super.onPlayerStateChanged(playWhenReady, playbackState);
            if (playbackState == 1) {
                if (DownloadVideoPlayer.this.handler1 != null) {
                    DownloadVideoPlayer.this.isActivityLive = false;
                    DownloadVideoPlayer.this.handler1.removeCallbacks(DownloadVideoPlayer.this.runable1);
                    DownloadVideoPlayer.this.runable1 = null;
                    DownloadVideoPlayer.this.handler1 = null;
                }
                DownloadVideoPlayer.this.progressBar.setVisibility(8);
                return;
            }
            if (playbackState == 2) {
                DownloadVideoPlayer.this.progressBar.setVisibility(0);
                if (DownloadVideoPlayer.this.handler1 != null) {
                    DownloadVideoPlayer.this.isActivityLive = false;
                    DownloadVideoPlayer.this.handler1.removeCallbacks(DownloadVideoPlayer.this.runable1);
                    DownloadVideoPlayer.this.runable1 = null;
                    DownloadVideoPlayer.this.handler1 = null;
                    return;
                }
                return;
            }
            if (playbackState != 3) {
                if (playbackState == 4) {
                    DownloadVideoPlayer.this.isActivityLive = false;
                    if (DownloadVideoPlayer.this.countDownTimer != null) {
                        DownloadVideoPlayer.this.countDownTimer.cancel();
                    }
                    if (DownloadVideoPlayer.this.countDownTimer2 != null) {
                        DownloadVideoPlayer.this.countDownTimer2.cancel();
                    }
                    if (DownloadVideoPlayer.this.handler1 != null) {
                        DownloadVideoPlayer.this.handler1.removeCallbacks(DownloadVideoPlayer.this.runable1);
                        DownloadVideoPlayer.this.runable1 = null;
                        DownloadVideoPlayer.this.handler1 = null;
                    }
                    DownloadVideoPlayer.this.playPosition = 0L;
                    if (DownloadVideoPlayer.this.utkashRoom.getvideoDownloadao().isvideo_exit(DownloadVideoPlayer.this.video_id, MakeMyExam.userId)) {
                        DownloadVideoPlayer.this.utkashRoom.getvideoDownloadao().update_videocurrenttime(DownloadVideoPlayer.this.video_id, MakeMyExam.userId, 0L, DownloadVideoPlayer.this.video_time);
                    }
                    if (DownloadVideoPlayer.this.simpleExoPlayer != null) {
                        DownloadVideoPlayer.this.simpleExoPlayer.seekTo(0L);
                        DownloadVideoPlayer.this.simpleExoPlayer.setPlayWhenReady(false);
                        return;
                    }
                    return;
                }
                return;
            }
            DownloadVideoPlayer.this.progressBar.setVisibility(8);
            if (DownloadVideoPlayer.this.isPlaying()) {
                if (!DownloadVideoPlayer.this.isActivityLive && DownloadVideoPlayer.this.is_limited.equalsIgnoreCase("1")) {
                    if (DownloadVideoPlayer.this.totalRemainingtime > 0) {
                        DownloadVideoPlayer.this.timestamp = System.currentTimeMillis();
                        DownloadVideoPlayer downloadVideoPlayer = DownloadVideoPlayer.this;
                        downloadVideoPlayer.starttime = String.valueOf(downloadVideoPlayer.timestamp);
                        DownloadVideoPlayer downloadVideoPlayer2 = DownloadVideoPlayer.this;
                        downloadVideoPlayer2.setTimer(downloadVideoPlayer2.totalRemainingtime);
                    } else {
                        DownloadVideoPlayer.this.releasePlayer();
                        DownloadVideoPlayer downloadVideoPlayer3 = DownloadVideoPlayer.this;
                        downloadVideoPlayer3.makeDialog(downloadVideoPlayer3, downloadVideoPlayer3.getResources().getString(R.string.alert), DownloadVideoPlayer.this.getResources().getString(R.string.video_time_is_expired), DownloadVideoPlayer.this.getResources().getString(R.string.ok), false);
                    }
                }
                DownloadVideoPlayer.this.isActivityLive = true;
            } else {
                if (DownloadVideoPlayer.this.countDownTimer != null) {
                    DownloadVideoPlayer.this.countDownTimer.cancel();
                }
                if (DownloadVideoPlayer.this.countDownTimer2 != null) {
                    DownloadVideoPlayer.this.countDownTimer2.cancel();
                }
                DownloadVideoPlayer.this.isActivityLive = false;
                if (DownloadVideoPlayer.this.handler1 != null) {
                    DownloadVideoPlayer.this.handler1.removeCallbacks(DownloadVideoPlayer.this.runable1);
                    DownloadVideoPlayer.this.runable1 = null;
                    DownloadVideoPlayer.this.handler1 = null;
                }
            }
            DownloadVideoPlayer.this.rePlay = false;
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackStateChanged(int playbackState) {
            super.onPlaybackStateChanged(playbackState);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
            super.onPlayWhenReadyChanged(playWhenReady, reason);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {
            super.onPlaybackSuppressionReasonChanged(playbackSuppressionReason);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onIsPlayingChanged(boolean isPlaying) {
            super.onIsPlayingChanged(isPlaying);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRepeatModeChanged(int repeatMode) {
            super.onRepeatModeChanged(repeatMode);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
            super.onShuffleModeEnabledChanged(shuffleModeEnabled);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayerError(PlaybackException error) {
            super.onPlayerError(error);
            if (error == null || error.getLocalizedMessage() == null || !DownloadVideoPlayer.this.rePlay || !error.getLocalizedMessage().equalsIgnoreCase("Source error")) {
                return;
            }
            if (DownloadVideoPlayer.this.simpleExoPlayer != null) {
                DownloadVideoPlayer.this.simpleExoPlayer.stop();
                DownloadVideoPlayer.this.simpleExoPlayer.setPlayWhenReady(false);
                DownloadVideoPlayer.this.simpleExoPlayer.release();
                DownloadVideoPlayer.this.playerView.setPlayer(null);
                DownloadVideoPlayer.this.simpleExoPlayer = null;
            }
            DownloadVideoPlayer.this.rePlay = false;
            DownloadVideoPlayer downloadVideoPlayer = DownloadVideoPlayer.this;
            downloadVideoPlayer.buildMediaSourceNew(Uri.parse(downloadVideoPlayer.url));
            DownloadVideoPlayer downloadVideoPlayer2 = DownloadVideoPlayer.this;
            downloadVideoPlayer2.link = downloadVideoPlayer2.url;
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayerErrorChanged(PlaybackException error) {
            super.onPlayerErrorChanged(error);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPositionDiscontinuity(int reason) {
            super.onPositionDiscontinuity(reason);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int reason) {
            super.onPositionDiscontinuity(oldPosition, newPosition, reason);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            super.onPlaybackParametersChanged(playbackParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSeekBackIncrementChanged(long seekBackIncrementMs) {
            super.onSeekBackIncrementChanged(seekBackIncrementMs);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSeekForwardIncrementChanged(long seekForwardIncrementMs) {
            super.onSeekForwardIncrementChanged(seekForwardIncrementMs);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMaxSeekToPreviousPositionChanged(long maxSeekToPreviousPositionMs) {
            super.onMaxSeekToPreviousPositionChanged(maxSeekToPreviousPositionMs);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAudioSessionIdChanged(int audioSessionId) {
            super.onAudioSessionIdChanged(audioSessionId);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            super.onAudioAttributesChanged(audioAttributes);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVolumeChanged(float volume) {
            super.onVolumeChanged(volume);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
            super.onSkipSilenceEnabledChanged(skipSilenceEnabled);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            super.onDeviceInfoChanged(deviceInfo);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onDeviceVolumeChanged(int volume, boolean muted) {
            super.onDeviceVolumeChanged(volume, muted);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVideoSizeChanged(VideoSize videoSize) {
            super.onVideoSizeChanged(videoSize);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSurfaceSizeChanged(int width, int height) {
            super.onSurfaceSizeChanged(width, height);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRenderedFirstFrame() {
            super.onRenderedFirstFrame();
        }

        @Override // androidx.media3.common.Player.Listener
        public void onCues(List<Cue> cues) {
            super.onCues(cues);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onCues(CueGroup cueGroup) {
            super.onCues(cueGroup);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMetadata(Metadata metadata) {
            super.onMetadata(metadata);
        }

        public int hashCode() {
            return super.hashCode();
        }

        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public String toString() {
            return super.toString();
        }

        protected void finalize() throws Throwable {
            super.finalize();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_download_video_player);
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
        this.utkashRoom = appDatabase;
        appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
        this.networkCall = new NetworkCall(this, this);
        BANDWIDTH_METER = new DefaultBandwidthMeter.Builder(this).build();
        if (getIntent().getExtras() != null) {
            this.video_name = getIntent().getStringExtra("video_name");
            this.video_id = getIntent().getExtras().getString(Const.VIDEO_ID);
            this.video_play = getIntent().getExtras().getString("video");
            this.video_time = getIntent().getExtras().getString("video_time");
            this.course_id = getIntent().getExtras().getString("course_id");
            this.valid_to = getIntent().getExtras().getString("valid_to");
            this.vdc_id = getIntent().getStringExtra("vdc_id");
            this.video_url = getIntent().getStringExtra("video_url");
            this.tileid = getIntent().getStringExtra("tile_id");
            this.is_limited = getIntent().getStringExtra("is_limited");
            this.multiplayer = getIntent().getStringExtra("multiplayer");
            this.remainingtime = getIntent().getStringExtra(Const.remaining_time);
            this.video_length = getIntent().getStringExtra("video_length");
            String stringExtra = getIntent().getStringExtra(Const.VIDEO_TYPE);
            this.video_type = stringExtra;
            if (stringExtra != null && stringExtra.equalsIgnoreCase("1")) {
                this.isSecure = false;
            }
            if (!TextUtils.isEmpty(this.remainingtime) && !this.remainingtime.split("_")[0].equalsIgnoreCase("")) {
                this.totalRemainingtime = ((long) Float.parseFloat(this.remainingtime.split("_")[0])) * 1000;
            }
            String str = this.video_time;
            if (str == null) {
                str = "";
            }
            this.video_time = str;
            this.current_pos = Long.valueOf(getIntent().getExtras().getLong("current_pos", 0L));
            String str2 = this.video_name;
            if (str2 == null) {
                str2 = "";
            }
            this.video_name = str2;
            String str3 = this.is_limited;
            if (str3 == null) {
                str3 = "0";
            }
            this.is_limited = str3;
            String str4 = this.multiplayer;
            if (str4 == null) {
                str4 = "0";
            }
            this.multiplayer = str4;
            String str5 = this.video_length;
            this.video_length = str5 != null ? str5 : "0";
            String str6 = this.tileid;
            this.tileid = str6 != null ? str6 : "";
        }
        this.totalTime = this.video_length;
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        PlayerView playerView = (PlayerView) findViewById(R.id.player_view_new);
        this.playerView = playerView;
        playerView.requestFocus();
        this.speedTV = (TextView) findViewById(R.id.exo_playback_speed);
        this.fullscren = (ImageView) findViewById(R.id.exo_fullscreen_icon);
        this.root_new = (RelativeLayout) findViewById(R.id.root_new);
        this.video_name_txt = (TextView) findViewById(R.id.video_name);
        this.MarqueeText = (TextView) findViewById(R.id.MarqueeText);
        this.txtTimer = (TextView) findViewById(R.id.txt_timer);
        this.ll_main = (LinearLayout) findViewById(R.id.ll_main);
        this.video_name_txt.setText(this.video_name);
        this.video_name_txt.setSelected(true);
        View viewFindViewById = findViewById(R.id.mainRoot);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyInsets(this, getWindow(), viewFindViewById, false, null);
        }
        if (!BuildConfig.FLAVOR.equalsIgnoreCase("dabraclasses") && !BuildConfig.FLAVOR.equalsIgnoreCase("tMPWealthcon")) {
            String mobile = SharedPreference.getInstance().getLoggedInUser().getMobile();
            String email = SharedPreference.getInstance().getLoggedInUser().getEmail();
            if (DownloadVideoPlayer$$ExternalSyntheticBackport0.m(mobile)) {
                this.MarqueeText.setText(email);
            } else {
                this.MarqueeText.setText(mobile);
            }
            this.MarqueeText.measure(0, 0);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Download.DownloadVideoPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadVideoPlayer.this.blink();
                }
            }, 3000L);
        } else {
            this.MarqueeText.setVisibility(8);
        }
        this.userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        getWindow().clearFlags(1024);
        this.root_new.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ((getResources().getDisplayMetrics().density * ((getResources().getConfiguration().screenLayout & 15) == 3 ? 350.0f : (getResources().getConfiguration().screenLayout & 15) == 4 ? 450.0f : 230.0f)) + 0.5f)));
        if (savedInstanceState != null) {
            this.mExoPlayerFullscreen = savedInstanceState.getBoolean("playerFullscreen");
        }
        findViewById(R.id.quality).setVisibility(8);
        initFullscreenDialog();
        this.speedTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.fullscren.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        TextView textView = this.speedTV;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.normal));
        }
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$2();
            }
        });
        if (Helper.isNetworkConnected(this)) {
            if (SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW) != null) {
                this.localapi = true;
            } else {
                this.is_limited.equalsIgnoreCase("1");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        showSpeedOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (this.mExoPlayerFullscreen) {
            closeFullScreenDialogNew();
        } else {
            openFullScreenDialogNew();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2() {
        try {
            new OrientationEventListener(getApplicationContext()) { // from class: com.appnew.android.Download.DownloadVideoPlayer.2
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    try {
                        if (Settings.System.getInt(DownloadVideoPlayer.this.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            boolean zIsPortrait = DownloadVideoPlayer.this.isPortrait(orientation);
                            if (!zIsPortrait && DownloadVideoPlayer.this.savedOrientation == 1) {
                                DownloadVideoPlayer.this.savedOrientation = 0;
                                DownloadVideoPlayer.this.setRequestedOrientation(2);
                            } else if (zIsPortrait && DownloadVideoPlayer.this.savedOrientation == 0) {
                                DownloadVideoPlayer.this.savedOrientation = 1;
                                DownloadVideoPlayer.this.setRequestedOrientation(2);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }.enable();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blink() {
        try {
            this.MarqueeText.setVisibility(4);
            PlayerView playerView = this.playerView;
            if (playerView != null) {
                playerView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass3());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Download.DownloadVideoPlayer$3, reason: invalid class name */
    class AnonymousClass3 implements ViewTreeObserver.OnPreDrawListener {
        AnonymousClass3() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            DownloadVideoPlayer.this.playerView.getViewTreeObserver().removeOnPreDrawListener(this);
            try {
                int measuredHeight = DownloadVideoPlayer.this.playerView.getMeasuredHeight();
                int measuredWidth = DownloadVideoPlayer.this.playerView.getMeasuredWidth() - (DownloadVideoPlayer.this.MarqueeText.getMeasuredWidth() > 0 ? DownloadVideoPlayer.this.MarqueeText.getMeasuredWidth() : DownloadVideoPlayer.this.MarqueeText.getWidth());
                int measuredHeight2 = measuredHeight - (DownloadVideoPlayer.this.MarqueeText.getMeasuredHeight() > 0 ? DownloadVideoPlayer.this.MarqueeText.getMeasuredHeight() : DownloadVideoPlayer.this.MarqueeText.getHeight());
                int iNextInt = measuredWidth > 0 ? ThreadLocalRandom.current().nextInt(10, measuredWidth) : 10;
                int iNextInt2 = measuredHeight2 > 0 ? ThreadLocalRandom.current().nextInt(10, measuredHeight2) : 10;
                DownloadVideoPlayer.this.MarqueeText.setX(iNextInt);
                DownloadVideoPlayer.this.MarqueeText.setY(iNextInt2);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
            final Handler handler = new Handler(Looper.getMainLooper());
            new Thread(new Runnable() { // from class: com.appnew.android.Download.DownloadVideoPlayer$3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPreDraw$2(handler);
                }
            }).start();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreDraw$2(Handler handler) {
            try {
                Thread.sleep(1000);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            handler.post(new Runnable() { // from class: com.appnew.android.Download.DownloadVideoPlayer$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPreDraw$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreDraw$1() {
            DownloadVideoPlayer.this.MarqueeText.setVisibility(0);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Download.DownloadVideoPlayer$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onPreDraw$0();
                }
            }, 3000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreDraw$0() {
            DownloadVideoPlayer.this.blink();
        }
    }

    private void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen) { // from class: com.appnew.android.Download.DownloadVideoPlayer.4
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (DownloadVideoPlayer.this.mExoPlayerFullscreen) {
                    DownloadVideoPlayer.this.closeFullScreenDialogNew();
                }
                super.onBackPressed();
            }
        };
    }

    private void openFullScreenDialogNew() {
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyInsetsNew(this, getWindow(), findViewById(R.id.mainRoot), false, null);
        }
        this.ll_main.setVisibility(8);
        setRequestedOrientation(0);
        this.mExoPlayerFullscreen = true;
        this.fullscren.setImageDrawable(ContextCompat.getDrawable(this, 2131231286));
        getWindow().setFlags(1024, 1024);
        this.root_new.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeFullScreenDialogNew() {
        setRequestedOrientation(1);
        this.ll_main.setVisibility(0);
        int i = getResources().getConfiguration().orientation;
    }

    private void showSpeedOptions() {
        String[] stringArray;
        PopupMenu popupMenu = new PopupMenu(this, this.speedTV, R.style.MyPopupMenu);
        Menu menu = popupMenu.getMenu();
        if (SharedPreference.getInstance().getString(Const.MAX_SPEED).equalsIgnoreCase("1")) {
            stringArray = getResources().getStringArray(R.array.speed_values_max);
        } else {
            stringArray = getResources().getStringArray(R.array.speed_values);
        }
        if (stringArray.length != 0) {
            for (String str : stringArray) {
                if (str.equalsIgnoreCase("1")) {
                    menu.add(Const.Normal);
                } else {
                    menu.add(str + "x");
                }
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda4
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return this.f$0.lambda$showSpeedOptions$3(menuItem);
                }
            });
            popupMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showSpeedOptions$3(MenuItem menuItem) {
        String string = menuItem.getTitle().toString();
        this.playerSpeed = string;
        if (this.simpleExoPlayer == null) {
            return false;
        }
        this.speedTV.setText(string);
        if (this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
            this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
            if (!isPlaying() || !this.is_limited.equalsIgnoreCase("1")) {
                return false;
            }
            setTimer(this.totalRemainingtime);
            return false;
        }
        this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf(this.playerSpeed.replace("x", "")).floatValue()));
        if (!isPlaying() || !this.is_limited.equalsIgnoreCase("1")) {
            return false;
        }
        setTimer(this.totalRemainingtime);
        return false;
    }

    private void SpeedDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.speed_dailog);
        TextView textView = (TextView) dialog.findViewById(R.id.tvVarySmall);
        TextView textView2 = (TextView) dialog.findViewById(R.id.tvSmall);
        TextView textView3 = (TextView) dialog.findViewById(R.id.tvMedium);
        TextView textView4 = (TextView) dialog.findViewById(R.id.tvLarge);
        TextView textView5 = (TextView) dialog.findViewById(R.id.tv720);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$SpeedDialog$4(dialog, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$SpeedDialog$5(dialog, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$SpeedDialog$6(dialog, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$SpeedDialog$7(dialog, view);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$SpeedDialog$8(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SpeedDialog$4(Dialog dialog, View view) {
        this.speedTV.setText("0.25x");
        PlaybackParameters playbackParameters = new PlaybackParameters(0.25f);
        dialog.dismiss();
        this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SpeedDialog$5(Dialog dialog, View view) {
        this.speedTV.setText("0.5x");
        PlaybackParameters playbackParameters = new PlaybackParameters(0.5f);
        dialog.dismiss();
        this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SpeedDialog$6(Dialog dialog, View view) {
        this.speedTV.setText("1x");
        PlaybackParameters playbackParameters = new PlaybackParameters(1.0f);
        dialog.dismiss();
        this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SpeedDialog$7(Dialog dialog, View view) {
        this.speedTV.setText("1.5x");
        PlaybackParameters playbackParameters = new PlaybackParameters(1.5f);
        dialog.dismiss();
        this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SpeedDialog$8(Dialog dialog, View view) {
        this.speedTV.setText("2x");
        PlaybackParameters playbackParameters = new PlaybackParameters(2.0f);
        dialog.dismiss();
        this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        try {
            if (Build.VERSION.SDK_INT == 36) {
                EdgeToEdgeHelperOld.applyInsetsNew(this, getWindow(), findViewById(R.id.mainRoot), false, null);
            }
            if (newConfig.orientation == 1) {
                this.mExoPlayerFullscreen = false;
                this.fullscren.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
                this.ll_main.setVisibility(0);
                getWindow().clearFlags(1024);
                this.root_new.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ((getResources().getDisplayMetrics().density * ((getResources().getConfiguration().screenLayout & 15) == 3 ? 350.0f : (getResources().getConfiguration().screenLayout & 15) == 4 ? 450.0f : 230.0f)) + 0.5f)));
                return;
            }
            this.ll_main.setVisibility(8);
            this.mExoPlayerFullscreen = true;
            this.fullscren.setImageDrawable(ContextCompat.getDrawable(this, 2131231286));
            getWindow().setFlags(1024, 1024);
            this.root_new.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private MediaSource buildMediaSource(Uri uri, DataSource.Factory factory) {
        int iInferContentType = Util.inferContentType(uri.getLastPathSegment());
        if (iInferContentType == 0) {
            return new DashMediaSource.Factory(factory).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 1) {
            return new SsMediaSource.Factory(factory).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 2) {
            return new HlsMediaSource.Factory(factory).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 4) {
            return new ProgressiveMediaSource.Factory(factory).createMediaSource(MediaItem.fromUri(uri));
        }
        throw new IllegalStateException("Unsupported type: " + iInferContentType);
    }

    private DataSource.Factory buildDataSourceFactory(boolean useBandwidthMeter) {
        return buildDataSourceFactory(useBandwidthMeter ? BANDWIDTH_METER : null);
    }

    public DataSource.Factory buildDataSourceFactory(TransferListener listener) {
        return new DefaultDataSourceFactory(this, listener, buildHttpDataSourceFactory(listener));
    }

    public DefaultDataSourceFactory buildHttpDataSourceFactory(TransferListener listener) {
        return new DefaultDataSourceFactory(getApplicationContext(), this.userAgent, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaSource buildMediaSourceNew(Uri uri) {
        return new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(this, Util.getUserAgent(this, getString(R.string.app_name)))).createMediaSource(MediaItem.fromUri(uri));
    }

    public void loadVideoOffline() {
        try {
            if (new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS, this.video_play + ".mp4").exists()) {
                String strValueOf = String.valueOf(new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS, this.video_play + ".mp4"));
                this.video_url = strValueOf;
                this.url = strValueOf;
            }
            String str = this.video_type;
            if (str != null && str.equalsIgnoreCase("1")) {
                this.video_url = this.video_url;
            }
            playVideo(this.video_url);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void playVideo(String uri) {
        DownloadVideoPlayer downloadVideoPlayer;
        try {
            if (this.utkashRoom.getvideoDownloadao().isvideo_exit(this.video_id, MakeMyExam.userId)) {
                VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(this.video_id, "1", MakeMyExam.userId);
                if (this.is_limited.equalsIgnoreCase("1")) {
                    long jMin = Math.min(this.totalRemainingtime, Long.parseLong(videosDownload.getRemaining_time()) * 1000);
                    this.totalRemainingtime = jMin;
                    if (jMin < 0) {
                        this.totalRemainingtime = 0L;
                    }
                }
                this.playPosition = videosDownload.getVideoCurrentPosition();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.isSecure) {
            try {
                final AesDataSource aesDataSource = new AesDataSource(Helper.getCipher(this.vdc_id));
                ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this).setSeekForwardIncrementMs(10000L).setMediaSourceFactory(new ProgressiveMediaSource.Factory(new DataSource.Factory() { // from class: com.appnew.android.Download.DownloadVideoPlayer.5
                    @Override // androidx.media3.datasource.DataSource.Factory
                    public DataSource createDataSource() {
                        return aesDataSource;
                    }
                })).setSeekBackIncrementMs(10000L).build();
                this.simpleExoPlayer = exoPlayerBuild;
                this.playerView.setPlayer(exoPlayerBuild);
                videoPinchInOutPinning();
                this.simpleExoPlayer.setMediaItem(MediaItem.fromUri(uri));
                this.simpleExoPlayer.prepare();
                this.simpleExoPlayer.seekTo(this.playPosition.longValue());
                this.playerView.setKeepScreenOn(true);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else {
            ExoPlayer exoPlayerBuild2 = new ExoPlayer.Builder(this).setSeekForwardIncrementMs(10000L).setSeekBackIncrementMs(10000L).build();
            this.simpleExoPlayer = exoPlayerBuild2;
            this.playerView.setPlayer(exoPlayerBuild2);
            videoPinchInOutPinning();
            this.simpleExoPlayer.setMediaItem(MediaItem.fromUri(uri));
            this.simpleExoPlayer.prepare();
            this.simpleExoPlayer.seekTo(this.playPosition.longValue());
            this.playerView.setKeepScreenOn(true);
        }
        String str = this.playerSpeed;
        if (str == null || str.isEmpty() || this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
            this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
        } else {
            this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf(this.playerSpeed.replace("x", "")).floatValue()));
        }
        if (this.is_limited.equalsIgnoreCase("1") && this.totalRemainingtime < 1000) {
            this.simpleExoPlayer.setPlayWhenReady(false);
            if (this.dialog == null) {
                downloadVideoPlayer = this;
                downloadVideoPlayer.makeDialog(this, getResources().getString(R.string.alert), getResources().getString(R.string.video_time_is_expired), getResources().getString(R.string.ok), false);
            } else {
                downloadVideoPlayer = this;
            }
        } else {
            downloadVideoPlayer = this;
            downloadVideoPlayer.simpleExoPlayer.setPlayWhenReady(true);
        }
        downloadVideoPlayer.simpleExoPlayer.addListener(new Player.Listener() { // from class: com.appnew.android.Download.DownloadVideoPlayer.6
            @Override // androidx.media3.common.Player.Listener
            public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onAudioSessionIdChanged(int audioSessionId) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onAvailableCommandsChanged(Player.Commands availableCommands) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onCues(List<Cue> cues) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onDeviceVolumeChanged(int volume, boolean muted) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onEvents(Player player, Player.Events events) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onIsLoadingChanged(boolean isLoading) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onMediaItemTransition(MediaItem mediaItem, int reason) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayerError(PlaybackException error) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayerErrorChanged(PlaybackException error) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int reason) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onRenderedFirstFrame() {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onRepeatModeChanged(int repeatMode) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onSeekBackIncrementChanged(long seekBackIncrementMs) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onSeekForwardIncrementChanged(long seekForwardIncrementMs) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onSurfaceSizeChanged(int width, int height) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onTimelineChanged(Timeline timeline, int reason) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onVideoSizeChanged(VideoSize videoSize) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onVolumeChanged(float volume) {
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int playbackState) {
                if (playbackState == 2) {
                    DownloadVideoPlayer.this.progressBar.setVisibility(0);
                    return;
                }
                if (playbackState != 3) {
                    if (playbackState != 4) {
                        return;
                    }
                    DownloadVideoPlayer.this.isActivityLive = false;
                    if (DownloadVideoPlayer.this.countDownTimer != null) {
                        DownloadVideoPlayer.this.countDownTimer.cancel();
                    }
                    if (DownloadVideoPlayer.this.countDownTimer2 != null) {
                        DownloadVideoPlayer.this.countDownTimer2.cancel();
                    }
                    if (DownloadVideoPlayer.this.simpleExoPlayer != null) {
                        DownloadVideoPlayer.this.simpleExoPlayer.seekTo(0L);
                        DownloadVideoPlayer.this.simpleExoPlayer.setPlayWhenReady(false);
                        DownloadVideoPlayer.this.playPosition = 0L;
                        if (DownloadVideoPlayer.this.handler1 != null) {
                            DownloadVideoPlayer.this.handler1.removeCallbacks(DownloadVideoPlayer.this.runable1);
                            DownloadVideoPlayer.this.runable1 = null;
                            DownloadVideoPlayer.this.handler1 = null;
                            if (DownloadVideoPlayer.this.is_limited.equalsIgnoreCase("1") && !DownloadVideoPlayer.this.remainingtime.equalsIgnoreCase("")) {
                                DownloadVideoPlayer.this.saveLocal();
                                DownloadVideoPlayer.this.utkashRoom.getvideoDownloadao().update_videoRemainingtime(DownloadVideoPlayer.this.video_id, MakeMyExam.userId, String.valueOf(DownloadVideoPlayer.this.totalRemainingtime / 1000));
                            }
                        }
                        if (DownloadVideoPlayer.this.utkashRoom.getvideoDownloadao().isvideo_exit(DownloadVideoPlayer.this.video_id, MakeMyExam.userId)) {
                            DownloadVideoPlayer.this.utkashRoom.getvideoDownloadao().update_videocurrenttime(DownloadVideoPlayer.this.video_id, MakeMyExam.userId, 0L, String.valueOf(DownloadVideoPlayer.this.totalTime));
                            return;
                        }
                        return;
                    }
                    return;
                }
                DownloadVideoPlayer.this.progressBar.setVisibility(8);
                if (DownloadVideoPlayer.this.isPlaying()) {
                    if (!DownloadVideoPlayer.this.isActivityLive && DownloadVideoPlayer.this.is_limited.equalsIgnoreCase("1")) {
                        if (DownloadVideoPlayer.this.totalRemainingtime > 0) {
                            DownloadVideoPlayer.this.timestamp = System.currentTimeMillis();
                            DownloadVideoPlayer downloadVideoPlayer2 = DownloadVideoPlayer.this;
                            downloadVideoPlayer2.starttime = String.valueOf(downloadVideoPlayer2.timestamp);
                            DownloadVideoPlayer downloadVideoPlayer3 = DownloadVideoPlayer.this;
                            downloadVideoPlayer3.totalTime = downloadVideoPlayer3.video_length;
                            DownloadVideoPlayer downloadVideoPlayer4 = DownloadVideoPlayer.this;
                            downloadVideoPlayer4.setTimer(downloadVideoPlayer4.totalRemainingtime);
                        } else {
                            DownloadVideoPlayer.this.releasePlayer();
                            if (DownloadVideoPlayer.this.dialog == null) {
                                DownloadVideoPlayer downloadVideoPlayer5 = DownloadVideoPlayer.this;
                                downloadVideoPlayer5.makeDialog(downloadVideoPlayer5, downloadVideoPlayer5.getResources().getString(R.string.alert), DownloadVideoPlayer.this.getResources().getString(R.string.video_time_is_expired), DownloadVideoPlayer.this.getResources().getString(R.string.ok), false);
                            }
                        }
                    }
                    DownloadVideoPlayer.this.isActivityLive = true;
                    return;
                }
                if (DownloadVideoPlayer.this.countDownTimer != null) {
                    DownloadVideoPlayer.this.countDownTimer.cancel();
                }
                if (DownloadVideoPlayer.this.countDownTimer2 != null) {
                    DownloadVideoPlayer.this.countDownTimer2.cancel();
                }
                DownloadVideoPlayer.this.isActivityLive = false;
                if (DownloadVideoPlayer.this.handler1 != null) {
                    DownloadVideoPlayer.this.handler1.removeCallbacks(DownloadVideoPlayer.this.runable1);
                    DownloadVideoPlayer.this.runable1 = null;
                    DownloadVideoPlayer.this.handler1 = null;
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public void onIsPlayingChanged(boolean isPlaying) {
                if (!isPlaying || !DownloadVideoPlayer.this.is_limited.equalsIgnoreCase("1")) {
                    if (!DownloadVideoPlayer.this.is_limited.equalsIgnoreCase("1") || DownloadVideoPlayer.this.handler1 == null) {
                        return;
                    }
                    DownloadVideoPlayer.this.handler1.removeCallbacks(DownloadVideoPlayer.this.runable1);
                    DownloadVideoPlayer.this.runable1 = null;
                    DownloadVideoPlayer.this.handler1 = null;
                    return;
                }
                if (DownloadVideoPlayer.this.handler1 == null) {
                    DownloadVideoPlayer downloadVideoPlayer2 = DownloadVideoPlayer.this;
                    downloadVideoPlayer2.setTimer(downloadVideoPlayer2.totalRemainingtime);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (SharedPreference.getInstance().getString(Const.DOWNLOAD_VISIBLE_WITH_INTERNET).equalsIgnoreCase("1")) {
            if (!Helper.isNetworkConnected(this)) {
                Helper.buildDialogNoInternet(this);
                return;
            }
            this.networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
        }
        if (Helper.isNetworkConnected(this)) {
            if (SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW) != null) {
                this.localapi = true;
            } else {
                this.is_limited.equalsIgnoreCase("1");
            }
        }
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(true);
        }
        try {
            ((TelephonyManager) getSystemService("phone")).listen(new PhoneStateListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer.7
                @Override // android.telephony.PhoneStateListener
                public void onCallStateChanged(int state, String incomingNumber) {
                    if (state == 1) {
                        DownloadVideoPlayer.this.oncall(true);
                    }
                    if (state == 2) {
                        DownloadVideoPlayer.this.oncall(true);
                    }
                    if (state == 0) {
                        DownloadVideoPlayer.this.oncall(false);
                        ((AudioManager) DownloadVideoPlayer.this.getApplicationContext().getSystemService("audio")).setMode(0);
                    }
                }
            }, 32);
            AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService("audio");
            if (!audioManager.isMicrophoneMute()) {
                audioManager.setMicrophoneMute(true);
            } else {
                audioManager.setMicrophoneMute(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        loadVideoOffline();
    }

    public void oncall(final boolean b2) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Download.DownloadVideoPlayer.8
            @Override // java.lang.Runnable
            public void run() {
                if (b2) {
                    DownloadVideoPlayer.this.pausePlayer();
                }
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getResources().getConfiguration().orientation == 2) {
            closeFullScreenDialogNew();
        } else {
            releasePlayer();
            super.onBackPressed();
        }
    }

    public void releasePlayer() {
        if (this.simpleExoPlayer != null) {
            if (this.is_limited.equalsIgnoreCase("1") && !this.remainingtime.equalsIgnoreCase("")) {
                this.utkashRoom.getvideoDownloadao().update_videoRemainingtime(this.video_id, MakeMyExam.userId, String.valueOf(this.totalRemainingtime / 1000));
                Constants.revison_set = true;
            }
            this.utkashRoom.getvideoDownloadao().update_videocurrenttime(this.video_id, MakeMyExam.userId, Long.valueOf(this.simpleExoPlayer.getCurrentPosition()), this.video_time);
            this.simpleExoPlayer.stop();
            this.simpleExoPlayer.setPlayWhenReady(false);
            this.simpleExoPlayer.release();
            this.playerView.setPlayer(null);
            this.simpleExoPlayer = null;
            this.url = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlaying() {
        return this.playerView.getPlayer().getPlaybackState() == 3 && this.playerView.getPlayer().getPlayWhenReady();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isActivityLive = false;
        this.rePlay = true;
        Handler handler = this.handler1;
        if (handler != null) {
            handler.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
            if (this.is_limited.equalsIgnoreCase("1") && !this.remainingtime.equalsIgnoreCase("")) {
                saveLocal();
                this.utkashRoom.getvideoDownloadao().update_videoRemainingtime(this.video_id, MakeMyExam.userId, String.valueOf(this.totalRemainingtime / 1000));
            }
        }
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            this.current_pos = Long.valueOf(exoPlayer.getCurrentPosition());
            this.utkashRoom.getvideoDownloadao().update_videocurrenttime(this.video_id, MakeMyExam.userId, Long.valueOf(this.simpleExoPlayer.getCurrentPosition()), this.video_time);
            releasePlayer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLocal() {
        HashMap map = new HashMap();
        map.put("user_id", SharedPreference.getInstance().getLoggedInUser().getId());
        map.put("course_id", this.course_id);
        map.put(Const.VIDEO_ID, this.video_id);
        map.put("tile_id", this.tileid);
        map.put(Const.TOTAL_TIME, this.totalTime);
        map.put(Const.VIDEO_TYPE, "6");
        map.put(Const.ENDTime, String.valueOf(this.endtime));
        map.put(Const.StartTime, String.valueOf(this.starttime));
        map.put("platform", "android");
        map.put(Const.VIEW_TIME, String.valueOf(Long.parseLong(this.remainingtime.split("_")[0]) - (this.totalRemainingtime / 1000)));
        map.put(Const.remaining_time, String.valueOf(this.totalRemainingtime / 1000));
        SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, map);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SharedPreference.getInstance().putString(Const.IS_RECENT_REFRESH, "1");
        Handler handler = this.handler1;
        if (handler != null) {
            handler.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
            if (this.is_limited.equalsIgnoreCase("1")) {
                this.remainingtime.equalsIgnoreCase("");
            }
        }
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.simpleExoPlayer.stop();
            this.simpleExoPlayer.release();
            this.playerView.setPlayer(null);
            this.simpleExoPlayer = null;
            this.trackSelector = null;
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        String strEncrypt;
        apitype.hashCode();
        if (!apitype.equals(API.user_video_view_data)) {
            if (!apitype.equals(API.get_meta)) {
                return null;
            }
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(MakeMyExam.getUserId());
            encryptionData.setToken(this.video_id);
            if (this.course_id.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                if (this.course_id.split(MqttTopic.MULTI_LEVEL_WILDCARD).length > 1) {
                    this.course_id = this.course_id.split(MqttTopic.MULTI_LEVEL_WILDCARD)[1];
                } else {
                    this.course_id = this.course_id.split(MqttTopic.MULTI_LEVEL_WILDCARD)[0];
                }
            }
            encryptionData.setCourse_id(this.course_id);
            return service.getmetaData(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (this.localapi) {
            this.hashMap1 = SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW);
            EncryptionData encryptionData2 = new EncryptionData();
            encryptionData2.setUser_id(MakeMyExam.getUserId());
            encryptionData2.setVideo_id(this.hashMap1.get(Const.VIDEO_ID));
            encryptionData2.setTile_id(this.hashMap1.get("tile_id"));
            encryptionData2.setCourse_id(this.hashMap1.get("course_id"));
            encryptionData2.setType(this.hashMap1.get(Const.VIDEO_TYPE));
            encryptionData2.setStart_time(this.hashMap1.get(Const.StartTime));
            encryptionData2.setTotal_time(this.hashMap1.get(Const.TOTAL_TIME));
            encryptionData2.setPlatform(this.hashMap1.get("platform"));
            encryptionData2.setRemaining_time(this.hashMap1.get(Const.remaining_time));
            encryptionData2.setEnd_time(this.hashMap1.get(Const.ENDTime));
            encryptionData2.setStart_time(this.hashMap1.get(Const.StartTime));
            encryptionData2.setView_time(this.hashMap1.get(Const.VIEW_TIME));
            strEncrypt = AES.encrypt(new Gson().toJson(encryptionData2));
        } else {
            this.endtime = System.currentTimeMillis();
            EncryptionData encryptionData3 = new EncryptionData();
            encryptionData3.setUser_id(MakeMyExam.getUserId());
            encryptionData3.setVideo_id(this.video_id);
            encryptionData3.setCourse_id(this.course_id);
            encryptionData3.setTile_id(this.tileid);
            encryptionData3.setType("6");
            encryptionData3.setStart_time(this.starttime);
            encryptionData3.setTotal_time(this.totalTime);
            encryptionData3.setPlatform("android");
            encryptionData3.setRemaining_time(String.valueOf(this.totalRemainingtime / 1000));
            encryptionData3.setEnd_time(String.valueOf(this.endtime));
            encryptionData3.setStart_time(String.valueOf(this.starttime));
            encryptionData3.setView_time(String.valueOf(((long) Float.parseFloat(this.remainingtime.split("_")[0])) - (this.totalRemainingtime / 1000)));
            strEncrypt = AES.encrypt(new Gson().toJson(encryptionData3));
        }
        return service.user_video_view_data(strEncrypt);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        String str = "0";
        apitype.hashCode();
        if (apitype.equals(API.user_video_view_data)) {
            if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                if (this.localapi) {
                    try {
                        HashMap<String, String> map = this.hashMap1;
                        if (map != null && !((String) Objects.requireNonNull(map.get(Const.remaining_time))).equalsIgnoreCase("")) {
                            this.totalRemainingtime = Long.parseLong((String) Objects.requireNonNull(this.hashMap1.get(Const.remaining_time))) * 1000;
                        }
                        SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, null);
                        loadVideoOffline();
                        this.localapi = false;
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, null);
                releasePlayer();
                finish();
                return;
            }
            if (SharedPreference.getInstance().getString(Const.DOWNLOAD_VISIBLE_WITH_INTERNET).equalsIgnoreCase("1")) {
                return;
            }
            Toast.makeText(this, jsonstring.optString("message"), 0).show();
            return;
        }
        if (apitype.equals(API.get_meta)) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    com.appnew.android.Model.PlayerPojo.Metadata metadata = (com.appnew.android.Model.PlayerPojo.Metadata) new Gson().fromJson(jsonstring.toString(), com.appnew.android.Model.PlayerPojo.Metadata.class);
                    if (metadata.getData().getVideo().getData() != null) {
                        if (!this.course_id.equalsIgnoreCase("0")) {
                            String is_limited = metadata.getData().getVideo().getData().getIs_limited();
                            this.is_limited = is_limited;
                            if (is_limited == null) {
                                this.is_limited = "0";
                            }
                        }
                        if (metadata.getData().getVideo().getVideo_length() != null && !metadata.getData().getVideo().getVideo_length().equalsIgnoreCase("") && metadata.getData().getVideo().getMultiplayer() != null && !metadata.getData().getVideo().getMultiplayer().equalsIgnoreCase("")) {
                            this.totalTime = String.valueOf(Float.parseFloat(metadata.getData().getVideo().getVideo_length()) * Float.parseFloat(metadata.getData().getVideo().getMultiplayer()));
                        }
                        this.feedback_required = metadata.getData().getVideo().getData().getFeedback_video();
                        if (metadata.getData().getVideo().getRemaining_time() != null) {
                            this.remainingtime = metadata.getData().getVideo().getRemaining_time();
                        }
                        this.demo_percent = metadata.getData().getVideo().getData().getDemo_percent();
                        if (!this.remainingtime.split("_")[0].equalsIgnoreCase("")) {
                            this.totalRemainingtime = ((long) Float.parseFloat(this.remainingtime.split("_")[0])) * 1000;
                        }
                        String str2 = this.is_limited;
                        if (str2 == null) {
                            str2 = "0";
                        }
                        this.is_limited = str2;
                        String str3 = this.demo_percent;
                        if (str3 == null) {
                            str3 = "0";
                        }
                        this.demo_percent = str3;
                        String str4 = this.feedback_required;
                        if (str4 != null) {
                            str = str4;
                        }
                        this.feedback_required = str;
                        loadVideoOffline();
                        return;
                    }
                    return;
                }
                RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this, jsonstring, 0).show();
        if (apitype.equalsIgnoreCase(API.user_video_view_data) || apitype.equalsIgnoreCase(API.update_video_view_time)) {
            HashMap map = new HashMap();
            map.put("user_id", SharedPreference.getInstance().getLoggedInUser().getId());
            map.put("course_id", this.course_id);
            map.put(Const.VIDEO_ID, this.video_id);
            map.put("tile_id", this.tileid);
            map.put(Const.TOTAL_TIME, this.totalTime);
            map.put(Const.VIDEO_TYPE, "6");
            map.put(Const.ENDTime, String.valueOf(this.endtime));
            map.put(Const.StartTime, String.valueOf(this.starttime));
            map.put("platform", "android");
            map.put(Const.VIEW_TIME, String.valueOf(Long.parseLong(this.remainingtime.split("_")[0]) - (this.totalRemainingtime / 1000)));
            map.put(Const.remaining_time, String.valueOf(this.totalRemainingtime / 1000));
            SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimer(long time) {
        String str = this.playerSpeed;
        final int iRound = (str == null || str.equalsIgnoreCase(Const.Normal)) ? 1000 : Math.round(1000.0f / Float.parseFloat(this.playerSpeed.replace("x", "")));
        this.txtTimer.setVisibility(0);
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.countDownTimer = null;
        }
        Handler handler = this.handler1;
        if (handler != null) {
            handler.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
        }
        if (this.totalRemainingtime > 0) {
            this.handler1 = new Handler();
            Runnable runnable = new Runnable() { // from class: com.appnew.android.Download.DownloadVideoPlayer.9
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadVideoPlayer.this.simpleExoPlayer != null) {
                        DownloadVideoPlayer.this.totalRemainingtime -= 1000;
                        DownloadVideoPlayer.this.txtTimer.setText(Html.fromHtml("Remaining video time\n <font color='#018da4'>" + Helper.formatSeconds(((int) DownloadVideoPlayer.this.totalRemainingtime) / 1000) + "</font>"));
                        DownloadVideoPlayer.this.minute = r0.simpleExoPlayer.getCurrentPosition() / 1000;
                        if (DownloadVideoPlayer.this.demo_percent != null && !DownloadVideoPlayer.this.demo_percent.equalsIgnoreCase("") && (DownloadVideoPlayer.this.minute * Integer.parseInt(DownloadVideoPlayer.this.demo_percent)) / 100.0f > DownloadVideoPlayer.this.minute) {
                            DownloadVideoPlayer.this.pausePlayer();
                            DownloadVideoPlayer downloadVideoPlayer = DownloadVideoPlayer.this;
                            Helper.showDialog(downloadVideoPlayer, downloadVideoPlayer.getResources().getString(R.string.this_is_demo_video_if_you_want_to_watch_this_video_please_purchase_this_course_thanks));
                        }
                        float f2 = DownloadVideoPlayer.this.minute;
                    }
                    if (DownloadVideoPlayer.this.totalRemainingtime > 0) {
                        DownloadVideoPlayer.this.handler1.postDelayed(this, iRound);
                    } else {
                        DownloadVideoPlayer.this.totalRemainingtime = 0L;
                        DownloadVideoPlayer.this.callFinishRemainingTime();
                    }
                }
            };
            this.runable1 = runnable;
            this.handler1.postDelayed(runnable, 500L);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.appnew.android.Download.DownloadVideoPlayer$10] */
    private void setTimer1(long time) {
        this.countDownTimer2 = new CountDownTimer(time, 1000L) { // from class: com.appnew.android.Download.DownloadVideoPlayer.10
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                DownloadVideoPlayer.this.totalRemainingtime1 = millisUntilFinished;
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callFinishRemainingTime() {
        DownloadVideoPlayer downloadVideoPlayer;
        this.totalRemainingtime = 0L;
        releasePlayer();
        if (this.dialog == null) {
            downloadVideoPlayer = this;
            downloadVideoPlayer.makeDialog(this, getResources().getString(R.string.alert), getResources().getString(R.string.video_time_is_expired), getResources().getString(R.string.ok), false);
        } else {
            downloadVideoPlayer = this;
        }
        downloadVideoPlayer.txtTimer.setText(Html.fromHtml(getResources().getString(R.string.remaining_video_time)));
    }

    public void pausePlayer() {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.simpleExoPlayer.getPlaybackState();
        }
    }

    public void makeDialog(Context context, String titleTxt, String messageTxt, String submitTxt, boolean isCancelable) {
        try {
            Dialog dialog = new Dialog(context);
            this.dialog = dialog;
            dialog.setCancelable(isCancelable);
            this.dialog.requestWindowFeature(1);
            this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            this.dialog.setContentView(R.layout.dialog_alert_simple_1);
            TextView textView = (TextView) this.dialog.findViewById(R.id.titleDialog);
            TextView textView2 = (TextView) this.dialog.findViewById(R.id.msgDialog);
            Button button = (Button) this.dialog.findViewById(R.id.btn_cancel);
            Button button2 = (Button) this.dialog.findViewById(R.id.btn_submit);
            if (TextUtils.isEmpty(titleTxt)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(titleTxt);
            }
            textView2.setText(messageTxt);
            button2.setText(submitTxt);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$makeDialog$9(view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$makeDialog$10(view);
                }
            });
            this.dialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeDialog$9(View view) {
        try {
            releasePlayer();
            this.dialog.dismiss();
            finish();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeDialog$10(View view) {
        try {
            this.dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    private void videoPinchInOutPinning() {
        PreferencesUtil.INSTANCE.setupPlayPauseButtonVisibility(this.simpleExoPlayer, this.playerView);
        PreferencesUtil.INSTANCE.changeFastForwardBackwardIcons(this.playerView);
        ((ZoomableVideoView) findViewById(R.id.zoomableVideoView)).setZoomListener(new ZoomableVideoView.ZoomListener() { // from class: com.appnew.android.Download.DownloadVideoPlayer$$ExternalSyntheticLambda12
            @Override // com.appnew.android.player.music_player.ZoomableVideoView.ZoomListener
            public final void onSingleTap() {
                this.f$0.lambda$videoPinchInOutPinning$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$videoPinchInOutPinning$11() {
        if (this.playerView.isControllerFullyVisible()) {
            this.playerView.hideController();
        } else {
            this.playerView.showController();
        }
    }
}
