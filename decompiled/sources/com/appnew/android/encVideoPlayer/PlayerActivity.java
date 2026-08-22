package com.appnew.android.encVideoPlayer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.appnew.android.Model.Video;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.FileUtils;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.eduteria.app.app.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import fr.maxcom.http.LocalSingleHttpServer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PlayerActivity extends AppCompatActivity {
    private static DefaultBandwidthMeter BANDWIDTH_METER = null;
    private static final String LOG_TAG = "PlayerActivity";
    private static final String TAG = "h";
    private static Context context = null;
    static String path = "";
    String courseId;
    private TextView exo_position;
    private TextView floatingText_new;
    private boolean inErrorState;
    private FrameLayout mFullScreenButton;
    private ImageView mFullScreenIcon;
    private LocalSingleHttpServer mServer;
    private ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    File path1;
    private TextView pixel_rate;
    private ExoPlayer player;
    public PlayerView playerView;
    ProgressDialog progressDialog;
    ImageView quality;
    private ExoPlayer simpleExoPlayer;
    ImageView speedOption;
    private TrackSelectionHelper trackSelectionHelper;
    private String userAgent;
    Video videodata;
    int REQUEST_TAKE_GALLERY_VIDEO = 2221;
    private String starttime = "";
    long timestamp = 0;
    boolean isSomethingPIckedUp = false;
    private final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private long playPosition = 0;
    int lastseleted = -1;
    boolean bitrateapply = false;
    TextView exo_duration = null;
    DefaultTimeBar defaultTimeBar = null;
    private boolean mExoPlayerFullscreen = false;
    String speedx = "";
    long currentTime = 0;
    private int multiplePermissionCounter = 0;
    String audio_url = "";
    String url = "";
    String link = "";

    /* JADX INFO: Access modifiers changed from: private */
    public void blink() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enc_video_player);
        getWindow().addFlags(128);
        context = this;
        initViews();
        this.videodata = (Video) getIntent().getSerializableExtra("video");
        checkStoragePermission();
        this.userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        BANDWIDTH_METER = new DefaultBandwidthMeter.Builder(this).build();
    }

    private void showSpeedOptions() {
        String[] stringArray;
        PopupMenu popupMenu = new PopupMenu(this, this.speedOption, R.style.MyPopupMenu);
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
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.encVideoPlayer.PlayerActivity.1
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    String string = item.getTitle().toString();
                    if (PlayerActivity.this.simpleExoPlayer == null) {
                        return false;
                    }
                    if (string.equalsIgnoreCase(Const.Normal)) {
                        PlayerActivity.this.speedx = "";
                        PlayerActivity.this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                        return false;
                    }
                    PlayerActivity.this.speedx = string;
                    PlayerActivity.this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf(string.replace("x", "")).floatValue(), 1.0f));
                    return false;
                }
            });
            popupMenu.show();
        }
    }

    private void initViews() {
        this.pixel_rate = (TextView) findViewById(R.id.pixel_rate);
        this.exo_position = (TextView) findViewById(R.id.exo_position);
        this.floatingText_new = (TextView) findViewById(R.id.floatingText_new);
        this.playerView = (PlayerView) findViewById(R.id.player_view_new);
        this.speedOption = (ImageView) findViewById(R.id.speedOption);
        this.floatingText_new.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        this.floatingText_new.measure(0, 0);
        this.floatingText_new.setVisibility(8);
        this.speedOption.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.encVideoPlayer.PlayerActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initViews$0();
            }
        }));
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.encVideoPlayer.PlayerActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.blink();
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initViews$0() {
        showSpeedOptions();
        return null;
    }

    private void checkStoragePermission() {
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.encVideoPlayer.PlayerActivity.2
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                PlayerActivity.this.chooseFiles();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 123) {
            for (int i : grantResults) {
                if (i != 0) {
                    this.multiplePermissionCounter++;
                    AppPermissionsRunTime.checkPermission(this, this.myPermissionConstantsArrayList, 123);
                    return;
                }
            }
            chooseFiles();
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        File file;
        super.onDestroy();
        if (this.isSomethingPIckedUp && (file = this.path1) != null) {
            deleteRecursive(file.getParentFile());
        }
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.simpleExoPlayer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseFiles() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        intent.setType("*/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        intent.putExtra("android.provider.extra.INITIAL_URI", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
        startActivityForResult(Intent.createChooser(intent, "Select .enc data"), this.REQUEST_TAKE_GALLERY_VIDEO);
    }

    public Cipher getCipher() throws GeneralSecurityException {
        String[] strArrSplit = Const.KEY.split("1090##", 2);
        String str = strArrSplit[0];
        String[] strArrSplit2 = strArrSplit[1].split("=", 2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(MessageDigest.getInstance(StringUtils.MD5).digest(new String(Base64.decode(strArrSplit2[0] + "=", 0), StandardCharsets.UTF_8).concat(new String(Base64.decode(strArrSplit2[1], 0), StandardCharsets.UTF_8)).getBytes()), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");
        cipher.init(2, secretKeySpec);
        return cipher;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) throws Throwable {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode == this.REQUEST_TAKE_GALLERY_VIDEO) {
                Uri data2 = data.getData();
                FileUtils.getPath(this, data2);
                if (data2 != null) {
                    ProgressDialog progressDialog = new ProgressDialog(this);
                    this.progressDialog = progressDialog;
                    progressDialog.setTitle("Loading.....");
                    this.progressDialog.setCanceledOnTouchOutside(false);
                    this.progressDialog.setCancelable(false);
                    this.progressDialog.setIndeterminate(true);
                    this.progressDialog.setProgressStyle(1);
                    new DownloadTask(this, new File(FileUtils.getPath(this, data2))).execute(FileUtils.getPath(this, data2));
                    return;
                }
                return;
            }
            return;
        }
        finish();
    }

    public class DownloadTask extends AsyncTask<String, Integer, String> {
        File actualFile;
        byte[] arrayPdf;
        ByteArrayOutputStream bao;
        Context context;
        FileOutputStream fileOutputStream;
        InputStream is;

        public DownloadTask(Context context, File actualFile) {
            this.context = context;
            this.actualFile = actualFile;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            if (PlayerActivity.this.progressDialog == null || PlayerActivity.this.progressDialog.isShowing()) {
                return;
            }
            PlayerActivity.this.progressDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x009a, code lost:
        
            r13.is.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00b4, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b9, code lost:
        
            return null;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r14) {
            /*
                Method dump skipped, instruction units count: 321
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.encVideoPlayer.PlayerActivity.DownloadTask.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... values) {
            super.onProgressUpdate((Object[]) values);
            PlayerActivity.this.progressDialog.setIndeterminate(false);
            PlayerActivity.this.progressDialog.setMax(100);
            PlayerActivity.this.progressDialog.setProgress(values[0].intValue());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String s) {
            super.onPostExecute(s);
            PlayerActivity.this.progressDialog.dismiss();
            if (s != null) {
                Toast.makeText(this.context, "Error while reading....", 0).show();
                PlayerActivity playerActivity = PlayerActivity.this;
                playerActivity.deleteRecursive((File) Objects.requireNonNull(playerActivity.path1.getParentFile()));
                return;
            }
            PlayerActivity.this.progressDialog.dismiss();
            String[] strArrSplit = PlayerActivity.this.path1.getAbsolutePath().split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            strArrSplit[strArrSplit.length - 1] = strArrSplit[strArrSplit.length - 1].replace("%20", " ");
            if ((PlayerActivity.this.videodata.getTitle() + ".mp4").equals(strArrSplit[strArrSplit.length - 1])) {
                PlayerActivity playerActivity2 = PlayerActivity.this;
                playerActivity2.setVideoPlayer1(playerActivity2.path1.getAbsolutePath(), Long.parseLong(PlayerActivity.this.videodata.getRemaining_time()));
            } else {
                Toast.makeText(this.context, "Please browse the right video.", 1).show();
                PlayerActivity.this.finish();
            }
        }
    }

    void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File file : fileOrDirectory.listFiles()) {
                deleteRecursive(file);
            }
        }
        fileOrDirectory.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoPlayer1(final String contentId, final long content_played_count) {
        try {
            this.mServer = new LocalSingleHttpServer();
            this.mServer.setCipher(getCipher());
            this.mServer.start();
            String url = this.mServer.getURL(contentId);
            path = url;
            playVideo(url, 1);
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.timestamp = jCurrentTimeMillis;
            this.starttime = String.valueOf(jCurrentTimeMillis);
        } catch (Exception e2) {
            Toast.makeText(context, "No Data", 0).show();
            e2.printStackTrace();
            finish();
        }
    }

    private void initializePlayer(final String downloadUrl) {
        Toast.makeText(context, "" + downloadUrl, 0).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.currentTime = System.currentTimeMillis();
        try {
            if (MakeMyExam.userId.equalsIgnoreCase("") || MakeMyExam.userId.equalsIgnoreCase("0")) {
                MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
                MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
            }
            ((TelephonyManager) getSystemService("phone")).listen(new PhoneStateListener() { // from class: com.appnew.android.encVideoPlayer.PlayerActivity.3
                @Override // android.telephony.PhoneStateListener
                public void onCallStateChanged(int state, String incomingNumber) {
                    if (state == 1) {
                        PlayerActivity.this.oncall(true);
                    }
                    if (state == 2) {
                        PlayerActivity.this.oncall(true);
                    }
                    if (state == 0) {
                        PlayerActivity.this.oncall(false);
                        ((AudioManager) PlayerActivity.this.getApplicationContext().getSystemService("audio")).setMode(0);
                    }
                }
            }, 32);
            AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService("audio");
            audioManager.setMode(-1);
            if (!audioManager.isMicrophoneMute()) {
                audioManager.setMicrophoneMute(true);
            } else {
                audioManager.setMicrophoneMute(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.play();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            this.playPosition = exoPlayer.getCurrentPosition();
            this.simpleExoPlayer.pause();
        }
    }

    public void oncall(final boolean b2) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.encVideoPlayer.PlayerActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (b2) {
                    PlayerActivity.this.pausePlayer();
                }
            }
        });
    }

    public void pausePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.player.getPlaybackState();
        }
    }

    public void resumePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(true);
            this.player.getPlaybackState();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        releasePlayer();
        super.onBackPressed();
    }

    private void releasePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            this.playPosition = exoPlayer.getCurrentPosition();
            this.player.release();
            this.player = null;
            this.url = "";
        }
    }

    public void playVideo(String uri, final int type) {
        new DefaultHttpDataSource.Factory();
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this).setSeekForwardIncrementMs(10000L).setSeekBackIncrementMs(10000L).build();
        this.simpleExoPlayer = exoPlayerBuild;
        this.playerView.setPlayer(exoPlayerBuild);
        this.simpleExoPlayer.setMediaItem(MediaItem.fromUri(uri));
        this.simpleExoPlayer.prepare();
        this.playerView.setKeepScreenOn(true);
        this.simpleExoPlayer.setPlayWhenReady(true);
        this.simpleExoPlayer.addListener(new Player.Listener() { // from class: com.appnew.android.encVideoPlayer.PlayerActivity.5
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
            public void onIsPlayingChanged(boolean isPlaying) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onMediaItemTransition(MediaItem mediaItem, int reason) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onMetadata(Metadata metadata) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int playbackState) {
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
        });
    }
}
