package com.appnew.android.player;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
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
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.dash.DefaultDashChunkSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.smoothstreaming.DefaultSsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Modal.OnlineUser;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.PlayerPojo.Pdf;
import com.appnew.android.Model.PlayerPojo.Polldata;
import com.appnew.android.Model.PlayerPojo.VideoTimeFramePojo;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.RealPathUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.UserHistroyTable;
import com.appnew.android.table.YoutubePlayerTable;
import com.bumptech.glide.Glide;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageView;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.network.connectionclass.ConnectionQuality;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import io.socket.engineio.client.transports.Polling;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class YoutubePlayerActivity extends AppCompatActivity implements AmazonCallBack, TakeImageClass.imagefromcropper, NetworkCall.MyNetworkCallBack {
    private static DefaultBandwidthMeter BANDWIDTH_METER;
    private static int newOrientation;
    private static long playPosition;
    private Adapter_recycleveiw_vedio adapter;
    TextView addBookmark;
    ImageView audiocaetimage;
    private BookmarkAdapter bookmarkAdapter;
    private ImageView bookmarkIcon;
    private LinearLayout bookmarkLinear;
    private CardView bookmark_btn;
    private BottomSetting bottomSetting;
    ChatAdapter chatAdapter;
    private ImageView chatAddButton;
    private LinearLayout chatLinear;
    private CardView chat_btn;
    LinearLayout chatlayout;
    ChildEventListener childEventListener;
    ChildEventListener childEventListenercompleteclass;
    ImageView cross;
    LinearLayoutCompat cvr;
    DataSource.Factory dataSourceFactory;
    private Dialog dialog;
    SharedPreferences.Editor editor;
    EditText etMessage;
    ImageView expand;
    private String fileName;
    private ImageView file_upload;
    TextView floatingText;
    private ImageView fullscreen;
    ChildEventListener getchatdata;
    private Handler handler;
    private Handler handler1;
    Bitmap image;
    private boolean inErrorState;
    private ImageView indexIcon;
    private LinearLayout indexLinear;
    private CardView index_btn;
    private boolean isShowingTrackSelectionDialog;
    private String isaudio;
    private String islive;
    String islockedback;
    ImageView ivSend;
    private LeftMenu leftMenu;
    LinearLayout linearLayout;
    private ImageView liveChatIcon;
    private ImageView liveDot;
    LinearLayout llll;
    private TextView loveImage;
    private DatabaseReference mFirebaseDatabaseReference1;
    private DatabaseReference mFirebaseDatabaseReferenceone2many;
    private DatabaseReference mFirebaseDatabaseReferenceone2one;
    private DatabaseReference mFirebaseDatabaseReferenceone2oneget;
    private DatabaseReference mFirebaseDatabaseReferencepolldata;
    private FrameLayout mFullScreenButton;
    private Dialog mFullScreenDialog;
    private ImageView mFullScreenIcon;
    private DataSource.Factory mediaDataSourceFactory;
    MediaPlayer mediaPlayer;
    MediaSource mediaSource;
    float minute;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    NetworkCall networkCall;
    private NotesAdapter notesAdapter;
    Query onetomantquery;
    ChildEventListener onetomanychildEventListener;
    DatabaseReference onetomanyrootRef;
    ValueEventListener onetomanyvalueEventListener;
    private ImageView pdfIcon;
    private LinearLayout pdfLinear;
    private TextView pdfText;
    private CardView pdf_btn;
    public RelativeLayout pdf_view_layout;
    private TextView pinChat;
    private LinearLayout pinll;
    Button play;
    private ExoPlayer player;
    String playerSpeed;
    public PlayerView playerView;
    private CardView poll;
    public PollAdapter pollAdapter;
    private ImageView pollIcon;
    private LinearLayout pollMain;
    private TextView pollText;
    int pos;
    ProgressBar progressBar;
    ImageView quality;
    Query query;
    private MediaRecorder recorder;
    TextView recordtime;
    public RecyclerView recyclerChat;
    DatabaseReference rootRef;
    DatabaseReference rootRefcompleteclass;
    View rootView;
    private Runnable runable1;
    private s3ImageUploading s3IU;
    private int savedOrientation;
    SharedPreferences sharedPreferences;
    public ExoPlayer simpleExoPlayer;
    private List<String> sparseAdaptiveResolutionList;
    private HashMap<String, String> sparseAdaptiveVideoUrlList;
    private List<String> sparseKeyList;
    private List<String> sparseMuxedResolutionList;
    private HashMap<String, String> sparseMuxedVideoUrlList;
    private List<String> sparseOPUSAudioUrl;
    private TextView speedTV;
    Button startaudio;
    Button stopaudio;
    private Timer timer;
    private RelativeLayout topImage;
    private TrackSelectionHelper trackSelectionHelper;
    DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    private TextView tvGoLive;
    TextView txtTimer;
    private String userAgent;
    UtkashRoom utkashRoom;
    ValueEventListener valueEventListener;
    ImageView video_bookmark;
    String video_id;
    String video_name;
    TextView video_name_text;
    private ImageView vodChatIcon;
    private LinearLayout vodchatLinear;
    private CardView vodchat_btn;
    private boolean wasRunning;
    PDFView webView;
    boolean isEjjaberedChat = false;
    long currentTime = 0;
    String isclicked = "";
    private String deletedindex = "";
    String str_imgTypeClick = "";
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    private int multiplePermissionCounter = 0;
    public boolean ischatload = false;
    String audio_url = "";
    private ConnectionQuality mConnectionClass = ConnectionQuality.UNKNOWN;
    String url = "";
    public boolean isGoingToPdf = false;
    ArrayList<chatPojo> arrChat = new ArrayList<>();
    ArrayList<chatPojo> pollarr = new ArrayList<>();
    ArrayList<chatPojo> lockarr = new ArrayList<>();
    ArrayList<Polldata> pollarraylist = new ArrayList<>();
    String speedx = "";
    private boolean mExoPlayerFullscreen = false;
    private final String STATE_PLAYER_FULLSCREEN = "playerFullscreen";
    String thumbnailurl = "";
    public boolean isActivityLive = false;
    private boolean isintractavailable = false;
    private List<VideoTimeFramePojo> indexdata = new ArrayList();
    private List<VideoTimeFramePojo> bookmarkdata = new ArrayList();
    private List<Pdf> pdf = new ArrayList();
    private String time = "";

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private String f330info = "";
    private String state = "";
    private boolean state1 = false;
    String Chat_node = "";
    String courseid = "";
    String tileid = "0";
    String tiletype = "";
    String videotype = "";
    String add_bookmark = "";
    private CardView doubt_btn = null;
    private LinearLayout doubtLinear = null;
    private ImageView doubtIcon = null;
    private TextView doubtText = null;
    private boolean isPublicChatEnabled = false;
    private int requestCode = -1;
    String link = "";
    String position = "";
    String parentid = "";
    private int STORAGE_PERMISSION_TYPE = 0;
    private int PERMISSION_TYPE = 0;
    private int seconds = 0;
    private boolean running = false;
    private boolean isChatPin = false;
    private List<String> keyset = new ArrayList();
    ArrayList<chatPojo> pinchatList = new ArrayList<>();
    String bookmarkState = "";
    String videoId_value = "";
    int i = 0;
    DefaultTimeBar defaultTimeBar = null;
    TextView exo_duration = null;
    TextView exo_position = null;
    boolean isTextChanging = false;
    private String timing = "";
    boolean bitrateapply = false;
    int lastseleted = -1;
    String checkstatus = "";
    String islocked = "0";
    private ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda28
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$24((CropImageView.CropResult) obj);
        }
    });
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda29
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$25((ActivityResult) obj);
        }
    });
    Player.Listener listener = new Player.Listener() { // from class: com.appnew.android.player.YoutubePlayerActivity.37
        @Override // androidx.media3.common.Player.Listener
        public void onEvents(Player player, Player.Events events) {
            super.onEvents(player, events);
            if (player == null || !player.isPlaying() || YoutubePlayerActivity.this.chatAdapter == null) {
                return;
            }
            YoutubePlayerActivity.this.chatAdapter.pauseAudio();
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
                if (YoutubePlayerActivity.this.handler1 != null) {
                    YoutubePlayerActivity.this.isActivityLive = false;
                    YoutubePlayerActivity.this.handler1.removeCallbacks(YoutubePlayerActivity.this.runable1);
                    YoutubePlayerActivity.this.runable1 = null;
                    YoutubePlayerActivity.this.handler1 = null;
                }
                YoutubePlayerActivity.this.progressBar.setVisibility(8);
                return;
            }
            if (playbackState == 2) {
                YoutubePlayerActivity.this.progressBar.setVisibility(0);
                if (YoutubePlayerActivity.this.handler1 != null) {
                    YoutubePlayerActivity.this.isActivityLive = false;
                    YoutubePlayerActivity.this.handler1.removeCallbacks(YoutubePlayerActivity.this.runable1);
                    YoutubePlayerActivity.this.runable1 = null;
                    YoutubePlayerActivity.this.handler1 = null;
                    return;
                }
                return;
            }
            if (playbackState != 3) {
                if (playbackState == 4) {
                    YoutubePlayerActivity.this.isActivityLive = false;
                    if (YoutubePlayerActivity.this.countDownTimer != null) {
                        YoutubePlayerActivity.this.countDownTimer.cancel();
                    }
                    if (YoutubePlayerActivity.this.countDownTimer2 != null) {
                        YoutubePlayerActivity.this.countDownTimer2.cancel();
                    }
                    if (YoutubePlayerActivity.this.handler1 != null) {
                        YoutubePlayerActivity.this.handler1.removeCallbacks(YoutubePlayerActivity.this.runable1);
                        YoutubePlayerActivity.this.runable1 = null;
                        YoutubePlayerActivity.this.handler1 = null;
                        return;
                    }
                    return;
                }
                return;
            }
            YoutubePlayerActivity.this.progressBar.setVisibility(8);
            if (YoutubePlayerActivity.this.isPlaying()) {
                if (!YoutubePlayerActivity.this.isActivityLive && YoutubePlayerActivity.this.is_limited.equalsIgnoreCase("1")) {
                    if (YoutubePlayerActivity.this.totalRemainingtime != 0) {
                        YoutubePlayerActivity.this.timestamp = System.currentTimeMillis();
                        YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                        youtubePlayerActivity.starttime = String.valueOf(youtubePlayerActivity.timestamp);
                        YoutubePlayerActivity youtubePlayerActivity2 = YoutubePlayerActivity.this;
                        youtubePlayerActivity2.setTimer(youtubePlayerActivity2.totalRemainingtime);
                        YoutubePlayerActivity youtubePlayerActivity3 = YoutubePlayerActivity.this;
                        youtubePlayerActivity3.setTimer1(youtubePlayerActivity3.totalRemainingtime1);
                    } else {
                        YoutubePlayerActivity.this.releasePlayer();
                        YoutubePlayerActivity youtubePlayerActivity4 = YoutubePlayerActivity.this;
                        youtubePlayerActivity4.makeDialog(youtubePlayerActivity4, youtubePlayerActivity4.getResources().getString(R.string.alert), YoutubePlayerActivity.this.getResources().getString(R.string.video_time_is_expired), YoutubePlayerActivity.this.getResources().getString(R.string.ok), false);
                    }
                }
                YoutubePlayerActivity.this.isActivityLive = true;
                return;
            }
            if (YoutubePlayerActivity.this.countDownTimer != null) {
                YoutubePlayerActivity.this.countDownTimer.cancel();
            }
            if (YoutubePlayerActivity.this.countDownTimer2 != null) {
                YoutubePlayerActivity.this.countDownTimer2.cancel();
            }
            YoutubePlayerActivity.this.isActivityLive = false;
            if (YoutubePlayerActivity.this.handler1 != null) {
                YoutubePlayerActivity.this.handler1.removeCallbacks(YoutubePlayerActivity.this.runable1);
                YoutubePlayerActivity.this.runable1 = null;
                YoutubePlayerActivity.this.handler1 = null;
            }
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
            if (isPlaying && YoutubePlayerActivity.this.islive.equalsIgnoreCase("5")) {
                if (YoutubePlayerActivity.this.simpleExoPlayer.getDuration() <= YoutubePlayerActivity.this.simpleExoPlayer.getContentPosition() + 30000) {
                    if (YoutubePlayerActivity.this.speedTV.getVisibility() == 0) {
                        if (YoutubePlayerActivity.this.playerSpeed != null && !YoutubePlayerActivity.this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
                            YoutubePlayerActivity.this.playerSpeed = Const.Normal;
                            YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                        }
                        YoutubePlayerActivity.this.speedTV.setVisibility(8);
                        YoutubePlayerActivity.this.speedTV.setText(Const.Normal);
                        return;
                    }
                    return;
                }
                YoutubePlayerActivity.this.speedTV.setVisibility(0);
            }
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
            YoutubePlayerActivity.this.inErrorState = true;
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
    long endtime = 0;
    private CountDownTimer countDownTimer = null;
    private CountDownTimer countDownTimer2 = null;
    private long totalRemainingtime = 0;
    private long totalRemainingtime1 = 820130816;
    private String starttime = "";
    long timestamp = 0;
    private String totalTime = "";
    private String feedback_required = "";
    private String is_limited = "0";
    private String leftTime = "";
    private String demo_percent = "";
    private String remainingtime = "";
    float total = 0.0f;
    float attempt_1_count = 0.0f;
    float attempt_2_count = 0.0f;
    float attempt_3_count = 0.0f;
    float attempt_4_count = 0.0f;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_liveawsactivity);
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        if (getIntent().getExtras() != null) {
            this.url = getIntent().getExtras().getString(Const.VIDEO_LINK);
            this.islive = getIntent().getExtras().getString("live");
            this.isaudio = getIntent().getExtras().getString("isaudio");
            this.video_id = getIntent().getStringExtra(Const.VIDEO_ID);
            this.video_name = getIntent().getStringExtra("video_name");
            this.Chat_node = getIntent().getStringExtra("Chat_node");
            this.courseid = getIntent().getStringExtra("courseid");
            this.tileid = getIntent().getStringExtra("tileid");
            this.tiletype = getIntent().getStringExtra("tiletype");
            this.videotype = getIntent().getStringExtra(Const.VIDEO_TYPE);
            this.thumbnailurl = getIntent().getStringExtra("thumbnail");
            this.islockedback = getIntent().getStringExtra("islocked");
            this.position = getIntent().getStringExtra(Constants.INAPP_POSITION);
            this.parentid = getIntent().getStringExtra(Const.shareparentid);
            this.add_bookmark = getIntent().getStringExtra("bookmark");
            this.timing = getIntent().getStringExtra("starttime");
        }
        String str = this.courseid;
        if ((str != null || !str.equalsIgnoreCase("")) && this.courseid.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
            String[] strArrSplit = this.courseid.split(MqttTopic.MULTI_LEVEL_WILDCARD);
            if (strArrSplit.length == 2) {
                this.courseid = strArrSplit[1];
            } else {
                this.courseid = strArrSplit[0];
            }
        }
        if (MakeMyExam.userId.equalsIgnoreCase("") || MakeMyExam.userId.equalsIgnoreCase("0")) {
            MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
            MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
        }
        this.networkCall = new NetworkCall(this, this);
        if (this.isaudio.equalsIgnoreCase("1")) {
            new Thread(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreate$0();
                }
            }).start();
        }
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference != null) {
            databaseReference.removeEventListener(this.valueEventListener);
            Query query = this.query;
            if (query != null) {
                query.removeEventListener(this.childEventListener);
            }
            DatabaseReference databaseReference2 = this.rootRefcompleteclass;
            if (databaseReference2 != null) {
                databaseReference2.removeEventListener(this.childEventListenercompleteclass);
            }
        }
        BANDWIDTH_METER = new DefaultBandwidthMeter.Builder(this).build();
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.playerView = (PlayerView) findViewById(R.id.player_view_new);
        this.speedTV = (TextView) findViewById(R.id.exo_playback_speed);
        this.fullscreen = (ImageView) findViewById(R.id.exo_fullscreen_icon);
        this.defaultTimeBar = (DefaultTimeBar) findViewById(R.id.exo_progress);
        this.exo_position = (TextView) findViewById(R.id.exo_position);
        this.exo_duration = (TextView) findViewById(R.id.exo_duration);
        this.audiocaetimage = (ImageView) findViewById(R.id.audiocaetimage);
        this.quality = (ImageView) findViewById(R.id.quality);
        this.rootView = findViewById(R.id.root_new);
        this.txtTimer = (TextView) findViewById(R.id.txt_timer);
        this.pinChat = (TextView) findViewById(R.id.pinChat);
        this.video_bookmark = (ImageView) findViewById(R.id.video_bookmark);
        this.ivSend = (ImageView) findViewById(R.id.iv_send);
        this.llll = (LinearLayout) findViewById(R.id.llll);
        EditText editText = (EditText) findViewById(R.id.et_message);
        this.etMessage = editText;
        handleChatCopyPaste(editText);
        this.chatAddButton = (ImageView) findViewById(R.id.chatAddButton);
        this.tvGoLive = (TextView) findViewById(R.id.tv_go_live);
        this.recyclerChat = (RecyclerView) findViewById(R.id.recycler_view);
        this.linearLayout = (LinearLayout) findViewById(R.id.bottomlayout);
        this.chatlayout = (LinearLayout) findViewById(R.id.linearLayout);
        this.addBookmark = (TextView) findViewById(R.id.add_bookmark);
        this.file_upload = (ImageView) findViewById(R.id.file_upload);
        this.bookmark_btn = (CardView) findViewById(R.id.bookmark_btn);
        this.bookmarkLinear = (LinearLayout) findViewById(R.id.bookmarkLinear);
        this.bookmarkIcon = (ImageView) findViewById(R.id.bookmarkIcon);
        this.index_btn = (CardView) findViewById(R.id.index_btn);
        this.indexLinear = (LinearLayout) findViewById(R.id.indexLinear);
        this.indexIcon = (ImageView) findViewById(R.id.indexIcon);
        this.vodchat_btn = (CardView) findViewById(R.id.vodchat_btn);
        this.vodchatLinear = (LinearLayout) findViewById(R.id.vodchatLinear);
        this.vodChatIcon = (ImageView) findViewById(R.id.vodChatIcon);
        this.chat_btn = (CardView) findViewById(R.id.chat_btn);
        this.chatLinear = (LinearLayout) findViewById(R.id.chatLinear);
        this.liveChatIcon = (ImageView) findViewById(R.id.liveChatIcon);
        this.liveDot = (ImageView) findViewById(R.id.liveDot);
        this.poll = (CardView) findViewById(R.id.poll);
        this.pollMain = (LinearLayout) findViewById(R.id.pollMain);
        this.pollIcon = (ImageView) findViewById(R.id.pollIcon);
        this.pollText = (TextView) findViewById(R.id.pollText);
        this.pdf_btn = (CardView) findViewById(R.id.pdf_btn);
        this.pdfLinear = (LinearLayout) findViewById(R.id.pdfLinear);
        this.pdfIcon = (ImageView) findViewById(R.id.pdfIcon);
        this.pdfText = (TextView) findViewById(R.id.pdfText);
        this.doubt_btn = (CardView) findViewById(R.id.doubt_btn);
        this.doubtLinear = (LinearLayout) findViewById(R.id.doubtLinear);
        this.doubtIcon = (ImageView) findViewById(R.id.doubtIcon);
        this.doubtText = (TextView) findViewById(R.id.doubtText);
        this.topImage = (RelativeLayout) findViewById(R.id.topImage);
        this.loveImage = (TextView) findViewById(R.id.loveImage);
        showReactButton(false);
        isvisiblelayouts(0, 0, 0, 0, 0, 0, 0);
        manageButtonUI(false, false, false, false, false, false, false);
        this.floatingText = (TextView) findViewById(R.id.floatingText_new);
        this.video_name_text = (TextView) findViewById(R.id.video_name);
        this.pdf_view_layout = (RelativeLayout) findViewById(R.id.pdf_view_layout);
        this.startaudio = (Button) findViewById(R.id.startaudio);
        this.stopaudio = (Button) findViewById(R.id.stopaudio);
        this.pinll = (LinearLayout) findViewById(R.id.pinll);
        this.cvr = (LinearLayoutCompat) findViewById(R.id.cvr);
        if ((SharedPreference.getInstance().getString(Const.IS_LIVE_CLASS_PDF_SHOW) != null && SharedPreference.getInstance().getString(Const.IS_LIVE_CLASS_PDF_SHOW).equalsIgnoreCase("1")) || BuildConfig.FLAVOR.equalsIgnoreCase("NextToppers")) {
            this.pdfText.setText(getResources().getString(R.string.pdf));
        }
        this.webView = (PDFView) findViewById(R.id.pdfViewPager);
        this.cross = (ImageView) findViewById(R.id.cross);
        this.expand = (ImageView) findViewById(R.id.expand);
        this.video_name_text.setText(this.video_name);
        String mobile = SharedPreference.getInstance().getLoggedInUser().getMobile();
        String email = SharedPreference.getInstance().getLoggedInUser().getEmail();
        if (mobile.isEmpty()) {
            mobile = email;
        }
        if (Helper.isShowingFloatingMobile()) {
            this.floatingText.setVisibility(0);
            this.floatingText.setText(mobile);
            this.floatingText.measure(0, 0);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    YoutubePlayerActivity.this.blink();
                }
            }, 3000L);
        } else {
            this.floatingText.setVisibility(8);
        }
        this.speedTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                YoutubePlayerActivity.this.showSpeedOptions();
            }
        });
        this.fullscreen.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.hideSoftKeyboard(YoutubePlayerActivity.this);
                Helper.closeKeyboard(YoutubePlayerActivity.this);
                if (YoutubePlayerActivity.this.mExoPlayerFullscreen) {
                    YoutubePlayerActivity.this.closeFullScreenDialogNew();
                } else {
                    YoutubePlayerActivity.this.openFullScreenDialogNew();
                }
            }
        });
        if (savedInstanceState != null) {
            this.mExoPlayerFullscreen = savedInstanceState.getBoolean("playerFullscreen");
        }
        this.userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        DatabaseReference databaseReference3 = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference3 != null) {
            databaseReference3.removeEventListener(this.valueEventListener);
            Query query2 = this.query;
            if (query2 != null) {
                query2.removeEventListener(this.childEventListener);
            }
            DatabaseReference databaseReference4 = this.rootRefcompleteclass;
            if (databaseReference4 != null) {
                databaseReference4.removeEventListener(this.childEventListenercompleteclass);
            }
        }
        DatabaseReference databaseReference5 = this.mFirebaseDatabaseReferenceone2many;
        if (databaseReference5 != null) {
            databaseReference5.removeEventListener(this.onetomanyvalueEventListener);
            Query query3 = this.onetomantquery;
            if (query3 != null) {
                query3.removeEventListener(this.onetomanychildEventListener);
            }
            DatabaseReference databaseReference6 = this.rootRefcompleteclass;
            if (databaseReference6 != null) {
                databaseReference6.removeEventListener(this.childEventListenercompleteclass);
            }
        }
        this.trackSelectorParameters = new DefaultTrackSelector.ParametersBuilder().build();
        if (this.islive.equalsIgnoreCase("8") || this.islive.equalsIgnoreCase("5")) {
            this.islive = "5";
            completeclass();
        } else if (this.islive.equalsIgnoreCase("7") || this.islive.equalsIgnoreCase("0")) {
            this.islive = "0";
        }
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            ThemeSettings themeSettingsData = this.utkashRoom.getthemeSettingdao().data();
            this.bottomSetting = (BottomSetting) new Gson().fromJson(themeSettingsData.getBottom(), BottomSetting.class);
            this.leftMenu = (LeftMenu) new Gson().fromJson(themeSettingsData.getLeft_menu(), LeftMenu.class);
        }
        LeftMenu leftMenu = this.leftMenu;
        if (leftMenu != null) {
            if (leftMenu.getChatPinUnPin() != null && this.leftMenu.getChatPinUnPin().equalsIgnoreCase("1")) {
                this.pinChat.setVisibility(0);
                this.pinll.setVisibility(0);
            } else {
                this.pinChat.setVisibility(8);
                this.pinll.setVisibility(8);
            }
        }
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null) {
            if (bottomSetting.getAttachment() != null && this.bottomSetting.getAttachment().equalsIgnoreCase("1")) {
                this.file_upload.setVisibility(0);
                this.chatAddButton.setVisibility(0);
            } else {
                this.file_upload.setVisibility(8);
                this.chatAddButton.setVisibility(8);
            }
            if (this.bottomSetting.getAudio() != null && this.bottomSetting.getAudio().equalsIgnoreCase("1")) {
                this.cvr.setVisibility(0);
            } else {
                this.cvr.setVisibility(8);
            }
        }
        hit_api_for_meta();
        hit_api_for_video_link();
        initFullscreenDialog();
        if (this.Chat_node.equalsIgnoreCase("")) {
            this.linearLayout.setVisibility(8);
        }
        if ((this.videotype.equalsIgnoreCase("1") || this.videotype.equalsIgnoreCase("7") || this.videotype.equalsIgnoreCase("9")) && SharedPreference.getInstance().getString(Const.BOOK_MARK) != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.BOOK_MARK)) && SharedPreference.getInstance().getString(Const.BOOK_MARK).equalsIgnoreCase("1")) {
            this.video_bookmark.setVisibility(0);
        } else {
            this.video_bookmark.setVisibility(8);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("VOD_VIDEO_BOOKMARK", 0);
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
        String string = this.sharedPreferences.getString(this.video_id, "");
        this.videoId_value = string;
        if (!string.isEmpty() || !this.videoId_value.equals("")) {
            if (this.videoId_value.equals("0")) {
                this.video_bookmark.setImageResource(R.mipmap.bookmark_selected);
                this.bookmarkState = "0";
            } else {
                this.video_bookmark.setImageResource(R.mipmap.bookmark_unselected);
                this.bookmarkState = "1";
            }
        } else {
            String str2 = this.add_bookmark;
            if (str2 != null && str2.equals("1")) {
                this.video_bookmark.setImageResource(R.mipmap.bookmark_selected);
                this.bookmarkState = "0";
            }
        }
        this.video_bookmark.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$2();
            }
        });
        this.pinChat.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$3();
            }
        }));
        this.bookmark_btn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$4();
            }
        }));
        this.index_btn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$5();
            }
        }));
        this.vodchat_btn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.chat_btn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        this.poll.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$8();
            }
        }));
        this.pdf_btn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$9();
            }
        }));
        this.chatAddButton.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$10();
            }
        }));
        this.startaudio.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$11(savedInstanceState);
            }
        }));
        this.file_upload.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Helper.isNetworkConnected(YoutubePlayerActivity.this)) {
                    YoutubePlayerActivity.this.STORAGE_PERMISSION_TYPE = 3;
                    YoutubePlayerActivity.this.checkStoragePermission2();
                } else {
                    YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                    Toast.makeText(youtubePlayerActivity, youtubePlayerActivity.getResources().getString(R.string.no_internet_connection), 0).show();
                }
            }
        });
        findViewById(R.id.quality).setVisibility(0);
        findViewById(R.id.quality).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$12();
            }
        }));
        String str3 = this.isaudio;
        if (str3 != null && str3.equalsIgnoreCase("1")) {
            this.quality.setVisibility(8);
        }
        if (this.islive.equalsIgnoreCase("5")) {
            this.speedTV.setVisibility(8);
            this.tvGoLive.setVisibility(0);
            BottomSetting bottomSetting2 = this.bottomSetting;
            if (bottomSetting2 != null) {
                if (bottomSetting2.getSeek_bar() != null && this.bottomSetting.getSeek_bar().equalsIgnoreCase("1")) {
                    this.defaultTimeBar.setVisibility(0);
                    this.exo_position.setVisibility(0);
                    this.exo_duration.setVisibility(0);
                } else {
                    this.defaultTimeBar.setVisibility(4);
                    this.exo_position.setVisibility(4);
                    this.exo_duration.setVisibility(4);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
            findViewById(R.id.exo_ffwd).setLayoutParams(layoutParams);
            findViewById(R.id.exo_rew).setLayoutParams(layoutParams);
        } else {
            this.speedTV.setVisibility(0);
            this.tvGoLive.setVisibility(8);
        }
        TextView textView = this.speedTV;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.normal));
            this.speedTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    YoutubePlayerActivity.this.showSpeedOptions();
                }
            });
        }
        TextView textView2 = this.tvGoLive;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (YoutubePlayerActivity.this.speedTV.getVisibility() == 0) {
                        if (YoutubePlayerActivity.this.playerSpeed != null && !YoutubePlayerActivity.this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
                            YoutubePlayerActivity.this.playerSpeed = Const.Normal;
                            YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                        }
                        YoutubePlayerActivity.this.speedTV.setVisibility(8);
                        YoutubePlayerActivity.this.speedTV.setText(Const.Normal);
                    }
                    YoutubePlayerActivity.this.goLive();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        try {
            this.image = BitmapFactory.decodeStream(new URL(this.thumbnailurl).openConnection().getInputStream());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        if (this.bookmarkState.equals("0")) {
            this.bookmarkState = "1";
            this.editor.remove(this.video_id);
            this.editor.apply();
            this.video_bookmark.setImageResource(R.mipmap.bookmark_unselected);
            this.networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
            return;
        }
        this.bookmarkState = "0";
        this.editor.putString(this.video_id, "0");
        this.editor.apply();
        this.video_bookmark.setImageResource(R.mipmap.bookmark_selected);
        this.networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2() {
        try {
            new OrientationEventListener(getApplicationContext()) { // from class: com.appnew.android.player.YoutubePlayerActivity.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    try {
                        if (Settings.System.getInt(YoutubePlayerActivity.this.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            boolean zIsPortrait = YoutubePlayerActivity.this.isPortrait(orientation);
                            if (!zIsPortrait && YoutubePlayerActivity.this.savedOrientation == 1) {
                                YoutubePlayerActivity.this.savedOrientation = 0;
                                YoutubePlayerActivity.this.setRequestedOrientation(2);
                            } else if (zIsPortrait && YoutubePlayerActivity.this.savedOrientation == 0) {
                                YoutubePlayerActivity.this.savedOrientation = 1;
                                YoutubePlayerActivity.this.setRequestedOrientation(2);
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
    public /* synthetic */ Unit lambda$onCreate$3() {
        if (Helper.isConnected(this)) {
            this.isChatPin = true;
            setUpPinChat();
            return null;
        }
        Toast.makeText(this, getResources().getString(R.string.please_connect_internet_connection), 0).show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$4() {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(true, false, false, false, false, false, false);
            setBookMark();
            return null;
        }
        Helper.showInternetToast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$5() {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(false, true, false, false, false, false, false);
            setIndex();
            return null;
        }
        Helper.showInternetToast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(false, false, true, false, false, false, false);
            setvodchat();
        } else {
            Helper.showInternetToast(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(false, false, false, true, false, false, false);
            this.isChatPin = false;
            setchat();
            return;
        }
        Helper.showInternetToast(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$8() {
        if (Helper.isConnected(this)) {
            manageButtonUI(false, false, false, false, true, false, false);
            setPoll();
            return null;
        }
        Helper.showInternetToast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$9() {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(false, false, false, false, false, true, false);
            setNotes();
            return null;
        }
        Helper.showInternetToast(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$10() {
        checkStoragePermission();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$11(Bundle bundle) {
        stopWatch(bundle);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$12() {
        if (this.sparseAdaptiveResolutionList == null) {
            Toast.makeText(this, getResources().getString(R.string.no_quality_found_till_yet), 0).show();
            return null;
        }
        if (this.simpleExoPlayer != null) {
            showAlertDialog();
            return null;
        }
        Toast.makeText(this, getResources().getString(R.string.no_quality_found_till_yet), 0).show();
        return null;
    }

    private void handleChatCopyPaste(final EditText etMessage) {
        if (Const.IS_CHAT_COPY_PASTE_ENABLE) {
            etMessage.setInputType(524288);
            etMessage.setLongClickable(false);
            etMessage.setTextIsSelectable(false);
            etMessage.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.player.YoutubePlayerActivity.8
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (YoutubePlayerActivity.this.isTextChanging) {
                        return;
                    }
                    YoutubePlayerActivity.this.isTextChanging = true;
                    if (after - count > 1) {
                        try {
                            etMessage.setText(s);
                            etMessage.setSelection(s.toString().length());
                        } finally {
                            YoutubePlayerActivity.this.isTextChanging = false;
                        }
                    }
                }
            });
        }
    }

    private void manageButtonUI(boolean forBookmark, boolean forIndex, boolean forVODchat, boolean forChat, boolean forPoll, boolean forPDF, boolean forDoubt) {
        this.bookmarkLinear.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forBookmark), getTheme()));
        this.indexLinear.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forIndex), getTheme()));
        this.vodchatLinear.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forVODchat), getTheme()));
        this.chatLinear.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forChat), getTheme()));
        this.pollMain.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forPoll), getTheme()));
        this.pdfLinear.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forPDF), getTheme()));
        this.doubtLinear.setBackground(ResourcesCompat.getDrawable(getResources(), getSelectedDrawable(forDoubt), getTheme()));
    }

    private int getSelectedDrawable(boolean isSelected) {
        if (BuildConfig.FLAVOR.equalsIgnoreCase("NextToppers")) {
            showTileIcon(0);
            return isSelected ? R.drawable.border_green : R.drawable.gray_border;
        }
        showTileIcon(8);
        return isSelected ? R.drawable.border_green_without_icon : R.drawable.grey_border_without_icon;
    }

    private void showTileIcon(int visibleGone) {
        setTintWithAppColor(this.indexIcon, visibleGone);
        setTintWithAppColor(this.bookmarkIcon, visibleGone);
        setTintWithAppColor(this.vodChatIcon, visibleGone);
        setTintWithAppColor(this.liveChatIcon, visibleGone);
        setTintWithAppColor(this.pollIcon, visibleGone);
        setTintWithAppColor(this.pdfIcon, visibleGone);
        setTintWithAppColor(this.doubtIcon, visibleGone);
    }

    private void setTintWithAppColor(ImageView imageView, int visibleGone) {
        imageView.setVisibility(visibleGone);
        imageView.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFullScreenDialogNew() {
        this.llll.setVisibility(8);
        this.linearLayout.setVisibility(8);
        setRequestedOrientation(0);
        this.mExoPlayerFullscreen = true;
        this.fullscreen.setImageDrawable(ContextCompat.getDrawable(this, 2131231286));
        this.video_name_text.setVisibility(8);
        this.chatlayout.setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.linearLayout.setVisibility(8);
        getWindow().setFlags(1024, 1024);
        this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        if (this.recorder != null) {
            stopRecording();
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
        }
        this.seconds = 0;
        this.running = false;
        this.fileName = "";
        this.handler.removeCallbacksAndMessages(null);
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeFullScreenDialogNew() {
        setRequestedOrientation(1);
        this.llll.setVisibility(0);
        if (getResources().getConfiguration().orientation == 2) {
            this.linearLayout.setVisibility(8);
        } else {
            this.linearLayout.setVisibility(0);
        }
    }

    private void SpeedDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.speed_dailog);
        TextView textView = (TextView) dialog.findViewById(R.id.tvVarySmall);
        TextView textView2 = (TextView) dialog.findViewById(R.id.tvSmall);
        TextView textView3 = (TextView) dialog.findViewById(R.id.tvMedium);
        TextView textView4 = (TextView) dialog.findViewById(R.id.tvLarge);
        TextView textView5 = (TextView) dialog.findViewById(R.id.tv720);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                YoutubePlayerActivity.this.speedTV.setText("0.25x");
                PlaybackParameters playbackParameters = new PlaybackParameters(0.25f);
                dialog.dismiss();
                YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                YoutubePlayerActivity.this.speedTV.setText("0.5x");
                PlaybackParameters playbackParameters = new PlaybackParameters(0.5f);
                dialog.dismiss();
                YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                YoutubePlayerActivity.this.speedTV.setText("1x");
                PlaybackParameters playbackParameters = new PlaybackParameters(1.0f);
                dialog.dismiss();
                YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                YoutubePlayerActivity.this.speedTV.setText("1.5x");
                PlaybackParameters playbackParameters = new PlaybackParameters(1.5f);
                dialog.dismiss();
                YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                YoutubePlayerActivity.this.speedTV.setText("2x");
                PlaybackParameters playbackParameters = new PlaybackParameters(2.0f);
                dialog.dismiss();
                YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(playbackParameters);
            }
        });
        dialog.show();
    }

    private void setUpPinChat() {
        this.pinchatList.clear();
        for (int i = 0; i < this.arrChat.size(); i++) {
            if (this.arrChat.get(i).getPin() != null && this.arrChat.get(i).getPin().equalsIgnoreCase("1")) {
                this.pinchatList.add(this.arrChat.get(i));
            }
        }
        this.linearLayout.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.chatAdapter = new ChatAdapter(this, Const.SHOW_PIN, this.pinchatList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerChat.setLayoutManager(linearLayoutManager);
        this.recyclerChat.setAdapter(this.chatAdapter);
        disableAll();
        this.pinChat.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.pinChat.setTextColor(getResources().getColor(android.R.color.black));
        resumePlayer();
    }

    private void stopWatch(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.seconds = savedInstanceState.getInt("seconds");
            this.running = savedInstanceState.getBoolean("running");
            this.wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    private void runTimer() {
        Dialog dialog = new Dialog(this);
        this.dialog = dialog;
        dialog.setContentView(R.layout.custom_dialog_new);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setCancelable(false);
        this.dialog.show();
        final Button button = (Button) this.dialog.findViewById(R.id.record);
        this.recordtime = (TextView) this.dialog.findViewById(R.id.timerno);
        this.play = (Button) this.dialog.findViewById(R.id.play);
        Button button2 = (Button) this.dialog.findViewById(R.id.send);
        Button button3 = (Button) this.dialog.findViewById(R.id.cancel);
        Handler handler = new Handler();
        this.handler = handler;
        handler.post(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity.14
            @Override // java.lang.Runnable
            public void run() {
                YoutubePlayerActivity.this.time = String.format(Locale.getDefault(), "%d:%02d:%02d", Integer.valueOf(YoutubePlayerActivity.this.seconds / 3600), Integer.valueOf((YoutubePlayerActivity.this.seconds % 3600) / 60), Integer.valueOf(YoutubePlayerActivity.this.seconds % 60));
                YoutubePlayerActivity.this.recordtime.setText(YoutubePlayerActivity.this.time);
                if (YoutubePlayerActivity.this.running) {
                    YoutubePlayerActivity.this.seconds++;
                }
                YoutubePlayerActivity.this.handler.postDelayed(this, 1000L);
            }
        });
        button.setText(getResources().getString(R.string.record));
        button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$runTimer$13();
            }
        }));
        button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$runTimer$14(button);
            }
        }));
        this.play.setText(getResources().getString(R.string.play));
        this.play.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$runTimer$15(button);
            }
        }));
        button3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$runTimer$16();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$runTimer$13() {
        if (Helper.isNetworkConnected(this)) {
            String str = this.fileName;
            if (str == "" || str == null) {
                Toast.makeText(this, getResources().getString(R.string.please_record_audio), 0).show();
            } else {
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    this.mediaPlayer.pause();
                }
                this.seconds = 0;
                this.running = false;
                sendaudio();
                this.handler.removeCallbacksAndMessages(null);
                this.dialog.dismiss();
            }
        } else {
            Toast.makeText(this, getResources().getString(R.string.no_internet_connection), 0).show();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$runTimer$14(Button button) {
        if (button.getText().equals("Record")) {
            onRecordBtnClicked(button);
            return null;
        }
        if (!button.getText().equals("Stop")) {
            return null;
        }
        button.setText(getResources().getString(R.string.record));
        this.running = false;
        stopRecording();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$runTimer$15(Button button) {
        if (!button.getText().equals("Stop")) {
            if (this.play.getText().equals("Play")) {
                if (this.seconds == 0) {
                    Toast.makeText(this, getResources().getString(R.string.please_record_audio), 0).show();
                    return null;
                }
                MediaPlayer mediaPlayerCreate = MediaPlayer.create(this, Uri.parse(this.fileName));
                this.mediaPlayer = mediaPlayerCreate;
                mediaPlayerCreate.start();
                this.play.setText(getResources().getString(R.string.pause));
                starttimer();
                return null;
            }
            if (!this.play.getText().equals("Pause")) {
                return null;
            }
            stoptimer();
            this.play.setText(getResources().getString(R.string.play));
            this.mediaPlayer.pause();
            return null;
        }
        Helper.showToast(this, getResources().getString(R.string.you_can_not_play_the_audio_while_record), 0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$runTimer$16() {
        stopRecording();
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
        }
        this.seconds = 0;
        this.running = false;
        this.fileName = "";
        this.dialog.dismiss();
        this.handler.removeCallbacksAndMessages(null);
        return null;
    }

    public void starttimer() {
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.appnew.android.player.YoutubePlayerActivity.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (YoutubePlayerActivity.this.mediaPlayer.isPlaying()) {
                    return;
                }
                YoutubePlayerActivity.this.stoptimer();
                YoutubePlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YoutubePlayerActivity.this.play.setText(YoutubePlayerActivity.this.getResources().getString(R.string.play));
                    }
                });
            }
        }, 0L, 1000L);
    }

    public void stoptimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    private void stopRecording() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            this.recorder.reset();
            this.recorder.release();
            this.recorder = null;
        }
    }

    public void onRecordBtnClicked(Button record) {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            pausePlayer();
            this.PERMISSION_TYPE = 3;
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 10);
        } else {
            pausePlayer();
            this.seconds = 0;
            this.running = true;
            record.setText("Stop");
            startRecording();
        }
    }

    private void startRecording() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            this.recorder.reset();
            this.recorder.release();
            this.recorder = null;
        }
        this.fileName = getExternalCacheDir().getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + UUID.randomUUID().toString() + ".mp3";
        MediaRecorder mediaRecorder2 = new MediaRecorder();
        this.recorder = mediaRecorder2;
        mediaRecorder2.setAudioSource(1);
        this.recorder.setOutputFormat(6);
        this.recorder.setOutputFile(this.fileName);
        this.recorder.setAudioEncoder(3);
        try {
            this.recorder.prepare();
        } catch (IOException unused) {
        }
        this.recorder.start();
    }

    public void sendaudio() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            this.recorder.reset();
            this.recorder.release();
            this.recorder = null;
        }
        this.s3IU = new s3ImageUploading(this.Chat_node, "vc-10000386-38616500102/application/chat_system/" + this.Chat_node + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
        ArrayList arrayList = new ArrayList();
        MediaFile mediaFile = new MediaFile();
        mediaFile.setFile_type("audio");
        mediaFile.setFile(this.fileName);
        arrayList.add(mediaFile);
        this.s3IU.execute(arrayList);
        this.fileName = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStoragePermission2() {
        this.PERMISSION_TYPE = 2;
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.16
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                YoutubePlayerActivity.this.OpenChooser();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OpenChooser() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/pdf");
            this.someActivityResultLauncher.launch(intent);
            this.requestCode = 101;
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blink() {
        try {
            this.floatingText.setVisibility(4);
            PlayerView playerView = this.playerView;
            if (playerView != null) {
                playerView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass17());
            }
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.YoutubePlayerActivity$17, reason: invalid class name */
    class AnonymousClass17 implements ViewTreeObserver.OnPreDrawListener {
        AnonymousClass17() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            YoutubePlayerActivity.this.playerView.getViewTreeObserver().removeOnPreDrawListener(this);
            try {
                int measuredHeight = YoutubePlayerActivity.this.playerView.getMeasuredHeight();
                int measuredWidth = YoutubePlayerActivity.this.playerView.getMeasuredWidth();
                int iNextInt = 5;
                int iNextInt2 = (YoutubePlayerActivity.this.floatingText.getWidth() <= 0 || measuredWidth - YoutubePlayerActivity.this.floatingText.getWidth() <= 0) ? 5 : ThreadLocalRandom.current().nextInt(YoutubePlayerActivity.this.floatingText.getWidth(), measuredWidth - YoutubePlayerActivity.this.floatingText.getWidth());
                if (YoutubePlayerActivity.this.floatingText.getHeight() > 0 && measuredHeight - YoutubePlayerActivity.this.floatingText.getHeight() > 0) {
                    iNextInt = ThreadLocalRandom.current().nextInt(YoutubePlayerActivity.this.floatingText.getHeight(), measuredHeight - YoutubePlayerActivity.this.floatingText.getHeight());
                }
                if (YoutubePlayerActivity.this.floatingText.getWidth() + iNextInt2 > measuredWidth) {
                    YoutubePlayerActivity.this.floatingText.setX(iNextInt2 - YoutubePlayerActivity.this.floatingText.getWidth());
                } else {
                    YoutubePlayerActivity.this.floatingText.setX(iNextInt2);
                }
                if (YoutubePlayerActivity.this.floatingText.getHeight() + iNextInt > measuredHeight) {
                    YoutubePlayerActivity.this.floatingText.setY(iNextInt - YoutubePlayerActivity.this.floatingText.getHeight());
                } else {
                    YoutubePlayerActivity.this.floatingText.setY(iNextInt);
                }
            } catch (IllegalArgumentException unused) {
            }
            new Thread(new AnonymousClass1(new Handler())).start();
            return true;
        }

        /* JADX INFO: renamed from: com.appnew.android.player.YoutubePlayerActivity$17$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ Handler val$handler;

            AnonymousClass1(final Handler val$handler) {
                this.val$handler = val$handler;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception unused) {
                }
                this.val$handler.post(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity.17.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YoutubePlayerActivity.this.floatingText.setVisibility(0);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity.17.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                YoutubePlayerActivity.this.blink();
                            }
                        }, 3000L);
                    }
                });
            }
        }
    }

    private void extractquality(final String url) {
        this.sparseAdaptiveVideoUrlList = new HashMap<>();
        this.sparseAdaptiveResolutionList = new ArrayList();
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$extractquality$18(url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractquality$18(String str) {
        List<String> list;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains("RESOLUTION")) {
                        for (String str2 : line.split(Constants.SEPARATOR_COMMA)) {
                            if (str2.contains("RESOLUTION")) {
                                this.sparseAdaptiveResolutionList.add(str2);
                            }
                        }
                    }
                    if (line.contains(".m3u8") && (list = this.sparseAdaptiveResolutionList) != null && list.size() > 0) {
                        this.sparseAdaptiveVideoUrlList.put(this.sparseAdaptiveResolutionList.get(r4.size() - 1), generateurl(line, str));
                    }
                } else {
                    runOnUiThread(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda32
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$extractquality$17();
                        }
                    });
                    bufferedReader.close();
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractquality$17() {
        List<String> list = this.sparseAdaptiveResolutionList;
        if (list == null || list.size() <= 0) {
            return;
        }
        playVideo(this.sparseAdaptiveVideoUrlList.get(this.sparseAdaptiveResolutionList.get(0)));
    }

    private void extractquality2(final String url) {
        this.sparseAdaptiveVideoUrlList = new HashMap<>();
        this.sparseAdaptiveResolutionList = new ArrayList();
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$extractquality2$20(url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractquality2$20(String str) {
        List<String> list;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains("RESOLUTION")) {
                        for (String str2 : line.split(Constants.SEPARATOR_COMMA)) {
                            if (str2.contains("RESOLUTION")) {
                                this.sparseAdaptiveResolutionList.add(str2);
                            }
                        }
                    }
                    if (line.contains(".m3u8") && (list = this.sparseAdaptiveResolutionList) != null && list.size() > 0) {
                        this.sparseAdaptiveVideoUrlList.put(this.sparseAdaptiveResolutionList.get(r4.size() - 1), generateurl2(line, str));
                    }
                } else {
                    runOnUiThread(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda21
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$extractquality2$19();
                        }
                    });
                    bufferedReader.close();
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractquality2$19() {
        List<String> list = this.sparseAdaptiveResolutionList;
        if (list == null || list.size() <= 0) {
            return;
        }
        playVideo(this.sparseAdaptiveVideoUrlList.get(this.sparseAdaptiveResolutionList.get(0)));
    }

    private String generateurl2(String input, String url) {
        String[] strArrSplit = url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        String str = "";
        int i = 0;
        while (i < strArrSplit.length) {
            if (i == strArrSplit.length - 1) {
                str = str + "/start/" + this.timing + MqttTopic.TOPIC_LEVEL_SEPARATOR + input;
            } else {
                str = i == 0 ? str + strArrSplit[i] : str + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[i];
            }
            i++;
        }
        return str;
    }

    private String generateurl(String input, String url) {
        String[] strArrSplit = url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        String str = "";
        int i = 0;
        while (i < strArrSplit.length) {
            if (i == strArrSplit.length - 1) {
                str = str + MqttTopic.TOPIC_LEVEL_SEPARATOR + input;
            } else {
                str = i == 0 ? str + strArrSplit[i] : str + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[i];
            }
            i++;
        }
        return str;
    }

    private void hit_api_for_video_link() {
        this.networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", false, false);
    }

    public void playVideo(String uri) {
        try {
            if (this.islive.equalsIgnoreCase("0") && !this.bitrateapply) {
                if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, this.isaudio)) {
                    playPosition = this.utkashRoom.getyoutubedata().getyoutubedata(MakeMyExam.userId, this.video_id, this.isaudio);
                } else {
                    playPosition = 0L;
                }
            }
            this.bitrateapply = false;
            if (this.playerView == null) {
                this.playerView = (PlayerView) findViewById(R.id.player_view_new);
            }
            if (this.isaudio.equalsIgnoreCase("1")) {
                this.playerView.setControllerShowTimeoutMs(0);
                this.playerView.setControllerHideOnTouch(false);
                this.audiocaetimage.setVisibility(0);
                Helper.setThumbnailImage(this, this.thumbnailurl, getDrawable(R.mipmap.course_placeholder), this.audiocaetimage);
            } else {
                this.audiocaetimage.setVisibility(8);
            }
            this.trackSelector = new DefaultTrackSelector(this);
            this.trackSelectionHelper = new TrackSelectionHelper();
            Uri.parse(uri);
            this.audio_url = uri;
            this.url = uri;
            this.link = uri;
            if (this.playerView != null && this.simpleExoPlayer != null) {
                ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this).setSeekForwardIncrementMs(10000L).setSeekBackIncrementMs(10000L).build();
                this.simpleExoPlayer = exoPlayerBuild;
                this.playerView.setPlayer(exoPlayerBuild);
                this.simpleExoPlayer.setMediaItem(MediaItem.fromUri(uri));
                this.simpleExoPlayer.prepare();
                this.playerView.setKeepScreenOn(true);
                this.simpleExoPlayer.setPlayWhenReady(true);
                this.simpleExoPlayer.seekTo(playPosition);
                this.simpleExoPlayer.addListener(this.listener);
            }
            if (!TextUtils.isEmpty(this.speedx)) {
                this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf(this.speedx.replace("x", "")).floatValue(), 1.0f));
            }
            if (this.islive.equalsIgnoreCase("0")) {
                try {
                    if (this.isaudio.equalsIgnoreCase("1")) {
                        try {
                            UserHistroyTable userHistroyTable = new UserHistroyTable();
                            userHistroyTable.setVideo_id(this.video_id);
                            userHistroyTable.setVideo_name(this.video_name);
                            userHistroyTable.setType("AWS Audio");
                            userHistroyTable.setTileid(this.tileid);
                            userHistroyTable.setYoutube_url(this.thumbnailurl);
                            userHistroyTable.setUser_id(MakeMyExam.userId);
                            userHistroyTable.setUrl(this.thumbnailurl);
                            if (this.parentid.equalsIgnoreCase("")) {
                                userHistroyTable.setCourse_id(this.courseid + MqttTopic.MULTI_LEVEL_WILDCARD + this.courseid);
                            } else {
                                userHistroyTable.setCourse_id(this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + this.courseid);
                            }
                            userHistroyTable.setCurrent_time("" + MakeMyExam.getTime_server());
                            this.utkashRoom.getuserhistorydao().addUser(userHistroyTable);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    try {
                        UserHistroyTable userHistroyTable2 = new UserHistroyTable();
                        userHistroyTable2.setVideo_id(this.video_id);
                        userHistroyTable2.setVideo_name(this.video_name);
                        userHistroyTable2.setTileid(this.tileid);
                        userHistroyTable2.setType("AWS Video");
                        userHistroyTable2.setYoutube_url(this.thumbnailurl);
                        userHistroyTable2.setUser_id(MakeMyExam.userId);
                        if (this.parentid.equalsIgnoreCase("")) {
                            userHistroyTable2.setCourse_id(this.courseid + MqttTopic.MULTI_LEVEL_WILDCARD);
                        } else {
                            userHistroyTable2.setCourse_id(this.parentid + MqttTopic.MULTI_LEVEL_WILDCARD + this.courseid);
                        }
                        userHistroyTable2.setCurrent_time("" + MakeMyExam.getTime_server());
                        this.utkashRoom.getuserhistorydao().addUser(userHistroyTable2);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void showAlertDialog() {
        final int[] iArr = {-1};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.select_track));
        String[] strArr = new String[this.sparseAdaptiveResolutionList.size()];
        for (int i = 0; i < this.sparseAdaptiveResolutionList.size(); i++) {
            if (this.sparseAdaptiveResolutionList.get(i).contains("720")) {
                strArr[i] = getResources().getString(R.string.very_high_quality_720);
            } else if (this.sparseAdaptiveResolutionList.get(i).contains("480")) {
                strArr[i] = getResources().getString(R.string.high_quality_480);
            } else if (this.sparseAdaptiveResolutionList.get(i).contains("360")) {
                strArr[i] = getResources().getString(R.string.medium_quality_360);
            } else if (this.sparseAdaptiveResolutionList.get(i).contains("240")) {
                strArr[i] = getResources().getString(R.string.low_quality_240);
            } else if (this.sparseAdaptiveResolutionList.get(i).contains("1080")) {
                strArr[i] = getResources().getString(R.string.extremly_high_quality_1080);
            }
        }
        int i2 = this.lastseleted;
        if (i2 == -1) {
            i2 = 0;
        }
        builder.setSingleChoiceItems(strArr, i2, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.18
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                iArr[0] = which;
                YoutubePlayerActivity.this.lastseleted = which;
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda30
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f$0.lambda$showAlertDialog$21(iArr, dialogInterface, i3);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda31
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f$0.lambda$showAlertDialog$22(dialogInterface, i3);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialog$21(int[] iArr, DialogInterface dialogInterface, int i) {
        playPosition = this.simpleExoPlayer.getCurrentPosition();
        this.bitrateapply = true;
        if (iArr[0] == -1) {
            Toast.makeText(this, R.string.please_change_quality_first, 0).show();
            return;
        }
        playPosition = this.simpleExoPlayer.getCurrentPosition();
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        TextView textView = this.speedTV;
        if (textView != null) {
            this.playerSpeed = Const.Normal;
            textView.setText(getResources().getString(R.string.normal));
            setTimer(this.totalRemainingtime);
        }
        playVideo(this.sparseAdaptiveVideoUrlList.get(this.sparseAdaptiveResolutionList.get(iArr[0])));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialog$22(DialogInterface dialogInterface, int i) {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null && exoPlayer.getPlayWhenReady()) {
            resumePlayer();
        } else {
            pausePlayer();
        }
        dialogInterface.cancel();
    }

    private void hit_api_for_meta() {
        this.networkCall.NetworkAPICall(API.get_meta, "", false, false);
    }

    private MediaSource buildMediaSource(Uri uri, String overrideExtension) {
        int iInferContentType = Util.inferContentType(uri, overrideExtension);
        if (iInferContentType == 0) {
            return new DashMediaSource.Factory(new DefaultDashChunkSource.Factory(this.mediaDataSourceFactory), buildDataSourceFactory(false)).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 1) {
            return new SsMediaSource.Factory(new DefaultSsChunkSource.Factory(this.mediaDataSourceFactory), buildDataSourceFactory(false)).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 2) {
            return new HlsMediaSource.Factory(this.mediaDataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 4) {
            return new ProgressiveMediaSource.Factory(this.mediaDataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
        }
        throw new IllegalStateException("Unsupported type: " + iInferContentType);
    }

    private void checkStoragePermission() {
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.19
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                YoutubePlayerActivity.this.imgClick();
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
                    int i2 = this.multiplePermissionCounter + 1;
                    this.multiplePermissionCounter = i2;
                    if (i2 >= 2) {
                        Helper.aDialogOnPermissionDenied(this);
                        return;
                    } else {
                        AppPermissionsRunTime.checkPermission(this, this.myPermissionConstantsArrayList, 123);
                        return;
                    }
                }
            }
            int i3 = this.PERMISSION_TYPE;
            if (i3 != 1 && i3 == 2) {
                OpenChooser();
                return;
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private DataSource.Factory buildDataSourceFactory(boolean useBandwidthMeter) {
        return buildDataSourceFactory(useBandwidthMeter ? BANDWIDTH_METER : null);
    }

    public DataSource.Factory buildDataSourceFactory(TransferListener listener) {
        return new DefaultDataSourceFactory(this, listener, buildHttpDataSourceFactory(listener));
    }

    public HttpDataSource.Factory buildHttpDataSourceFactory(TransferListener listener) {
        return new DefaultHttpDataSource.Factory();
    }

    private void setvodchat() {
        this.isclicked = "6";
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        resumePlayer();
        this.chatAdapter = new ChatAdapter(this, "", this.arrChat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerChat.setLayoutManager(linearLayoutManager);
        this.recyclerChat.setAdapter(this.chatAdapter);
        disableAll();
        if (this.islocked.equalsIgnoreCase("1")) {
            if (getResources().getConfiguration().orientation == 2) {
                this.linearLayout.setVisibility(8);
            } else {
                this.linearLayout.setVisibility(0);
            }
        } else if (this.islocked.equalsIgnoreCase("0")) {
            if (this.islockedback.equalsIgnoreCase("1")) {
                this.linearLayout.setVisibility(8);
                this.chatlayout.setVisibility(8);
            } else {
                if (getResources().getConfiguration().orientation == 2) {
                    this.linearLayout.setVisibility(8);
                } else {
                    this.linearLayout.setVisibility(0);
                }
                this.chatlayout.setVisibility(0);
            }
        } else {
            this.linearLayout.setVisibility(8);
        }
        this.chatlayout.setVisibility(0);
    }

    private void setchat() {
        this.isclicked = "1";
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        resumePlayer();
        this.chatAdapter = new ChatAdapter(this, "", this.arrChat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerChat.setLayoutManager(linearLayoutManager);
        this.recyclerChat.setAdapter(this.chatAdapter);
        disableAll();
        if (this.islocked.equalsIgnoreCase("1")) {
            if (getResources().getConfiguration().orientation == 2) {
                this.linearLayout.setVisibility(8);
            } else {
                this.linearLayout.setVisibility(0);
            }
        } else if (this.islocked.equalsIgnoreCase("0")) {
            if (this.islockedback.equalsIgnoreCase("1")) {
                this.linearLayout.setVisibility(8);
                this.chatlayout.setVisibility(8);
            } else {
                if (getResources().getConfiguration().orientation == 2) {
                    this.linearLayout.setVisibility(8);
                } else {
                    this.linearLayout.setVisibility(0);
                }
                this.chatlayout.setVisibility(0);
            }
        } else {
            this.linearLayout.setVisibility(8);
        }
        this.chatlayout.setVisibility(0);
    }

    private void setNotes() {
        this.isclicked = "4";
        this.linearLayout.setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        setNotesAdapter();
    }

    private void setPoll() {
        this.isclicked = "5";
        this.linearLayout.setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        this.pollText.setText(getResources().getString(R.string.poll));
        setpollAdapter();
    }

    private void setpollAdapter() {
        PollAdapter pollAdapter = new PollAdapter(this, this.pollarraylist);
        this.pollAdapter = pollAdapter;
        this.recyclerChat.setAdapter(pollAdapter);
    }

    public void setunPin(chatPojo chatPojo, int pos) {
        if (this.isPublicChatEnabled) {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2many;
            if (databaseReference != null) {
                try {
                    databaseReference.child(this.keyset.get(pos)).child("pin").setValue("0");
                    chatPojo.setPin("0");
                    this.chatAdapter.notifyItemChanged(pos);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference2 != null) {
            try {
                databaseReference2.child(this.keyset.get(pos)).child("pin").setValue("0");
                chatPojo.setPin("0");
                this.chatAdapter.notifyItemChanged(pos);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void setpin(chatPojo chatPojo, int pos) {
        if (this.isPublicChatEnabled) {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2many;
            if (databaseReference != null) {
                try {
                    databaseReference.child(this.keyset.get(pos)).child("pin").setValue("1");
                    chatPojo.setPin("1");
                    this.chatAdapter.notifyItemChanged(pos);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference2 != null) {
            try {
                databaseReference2.child(this.keyset.get(pos)).child("pin").setValue("1");
                chatPojo.setPin("1");
                this.chatAdapter.notifyItemChanged(pos);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void fireBaseOperation() {
        this.mFirebaseDatabaseReferenceone2many = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
        this.mFirebaseDatabaseReferenceone2one = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        if (this.isPublicChatEnabled) {
            ValueEventListener valueEventListener = new ValueEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.20
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() == null) {
                        YoutubePlayerActivity.this.checkstatus = "1";
                        YoutubePlayerActivity.this.onetomanygetupdatedchatdata(MakeMyExam.getTime_server());
                        return;
                    }
                    try {
                        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                            chatPojo chatpojo = (chatPojo) dataSnapshot2.getValue(chatPojo.class);
                            if (!chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                                YoutubePlayerActivity.this.arrChat.add(chatpojo);
                                YoutubePlayerActivity.this.pollarr.add(chatpojo);
                                YoutubePlayerActivity.this.keyset.add(dataSnapshot2.getKey());
                            } else {
                                if (chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                                    YoutubePlayerActivity.this.lockarr.add(chatpojo);
                                }
                                YoutubePlayerActivity.this.pollarr.add(chatpojo);
                            }
                            YoutubePlayerActivity.this.chatAdapter.notifyDataSetChanged();
                        }
                        YoutubePlayerActivity.this.recyclerChat.smoothScrollToPosition(YoutubePlayerActivity.this.arrChat.size());
                        YoutubePlayerActivity.this.checkstatus = "1";
                        YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                        youtubePlayerActivity.onetomanygetupdatedchatdata(youtubePlayerActivity.pollarr.get(YoutubePlayerActivity.this.pollarr.size() - 1).getDate());
                        if (YoutubePlayerActivity.this.lockarr.size() > 0) {
                            if (YoutubePlayerActivity.this.lockarr.get(YoutubePlayerActivity.this.lockarr.size() - 1).getMessage().equalsIgnoreCase("0")) {
                                YoutubePlayerActivity.this.islocked = "1";
                                YoutubePlayerActivity.this.showchat();
                            } else {
                                YoutubePlayerActivity.this.islocked = "2";
                                YoutubePlayerActivity.this.hidechat();
                            }
                        }
                    } catch (Exception unused) {
                        Toast.makeText(YoutubePlayerActivity.this, "null pointer exception", 0).show();
                    }
                }
            };
            this.onetomanyvalueEventListener = valueEventListener;
            this.mFirebaseDatabaseReferenceone2many.addListenerForSingleValueEvent(valueEventListener);
            this.mFirebaseDatabaseReferenceone2many.limitToLast(500);
        } else {
            ValueEventListener valueEventListener2 = new ValueEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.21
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() == null) {
                        YoutubePlayerActivity.this.checkstatus = "1";
                        YoutubePlayerActivity.this.getupdatedchatdata(MakeMyExam.getTime_server());
                        return;
                    }
                    try {
                        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                            chatPojo chatpojo = (chatPojo) dataSnapshot2.getValue(chatPojo.class);
                            if (!chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                                YoutubePlayerActivity.this.arrChat.add(chatpojo);
                                YoutubePlayerActivity.this.keyset.add(dataSnapshot2.getKey());
                                YoutubePlayerActivity.this.pollarr.add(chatpojo);
                            } else {
                                if (chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                                    YoutubePlayerActivity.this.lockarr.add(chatpojo);
                                }
                                YoutubePlayerActivity.this.pollarr.add(chatpojo);
                            }
                            YoutubePlayerActivity.this.chatAdapter.notifyDataSetChanged();
                        }
                        YoutubePlayerActivity.this.recyclerChat.smoothScrollToPosition(YoutubePlayerActivity.this.arrChat.size());
                        YoutubePlayerActivity.this.checkstatus = "1";
                        YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                        youtubePlayerActivity.getupdatedchatdata(youtubePlayerActivity.pollarr.get(YoutubePlayerActivity.this.pollarr.size() - 1).getDate());
                        if (YoutubePlayerActivity.this.lockarr.size() > 0) {
                            if (YoutubePlayerActivity.this.lockarr.get(YoutubePlayerActivity.this.lockarr.size() - 1).getMessage().equalsIgnoreCase("0")) {
                                YoutubePlayerActivity.this.islocked = "1";
                                YoutubePlayerActivity.this.showchat();
                            } else {
                                YoutubePlayerActivity.this.islocked = "2";
                                YoutubePlayerActivity.this.hidechat();
                            }
                        }
                    } catch (Exception unused) {
                        YoutubePlayerActivity youtubePlayerActivity2 = YoutubePlayerActivity.this;
                        Toast.makeText(youtubePlayerActivity2, youtubePlayerActivity2.getResources().getString(R.string.null_pointer_exception), 0).show();
                    }
                }
            };
            this.valueEventListener = valueEventListener2;
            this.mFirebaseDatabaseReferenceone2one.addListenerForSingleValueEvent(valueEventListener2);
            this.mFirebaseDatabaseReferenceone2one.limitToLast(500);
        }
        this.ivSend.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Helper.isConnected(YoutubePlayerActivity.this)) {
                    if (!YoutubePlayerActivity.this.etMessage.getText().toString().trim().equals("")) {
                        if (!YoutubePlayerActivity.this.isintractavailable) {
                            YoutubePlayerActivity.this.checkintract();
                        }
                        if (Helper.IsValidUrl(YoutubePlayerActivity.this.etMessage.getText().toString().trim())) {
                            chatPojo chatpojo = new chatPojo(MakeMyExam.userId, YoutubePlayerActivity.this.etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "url", YoutubePlayerActivity.this.courseid);
                            YoutubePlayerActivity.this.mFirebaseDatabaseReferenceone2one.push().setValue(chatpojo);
                            YoutubePlayerActivity.this.mFirebaseDatabaseReferenceone2many.push().setValue(chatpojo);
                            YoutubePlayerActivity.this.etMessage.setText("");
                            Helper.hideKeyboard(YoutubePlayerActivity.this);
                            return;
                        }
                        chatPojo chatpojo2 = new chatPojo(MakeMyExam.userId, YoutubePlayerActivity.this.etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "text", YoutubePlayerActivity.this.courseid);
                        YoutubePlayerActivity.this.mFirebaseDatabaseReferenceone2one.push().setValue(chatpojo2);
                        YoutubePlayerActivity.this.mFirebaseDatabaseReferenceone2many.push().setValue(chatpojo2);
                        YoutubePlayerActivity.this.etMessage.setText("");
                        Helper.hideKeyboard(YoutubePlayerActivity.this);
                        return;
                    }
                    Helper.showSnackBar(YoutubePlayerActivity.this.ivSend, "Please enter your query first.");
                    return;
                }
                Helper.showSnackBar(YoutubePlayerActivity.this.ivSend, "Please connect internet first.");
            }
        });
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.arrChat.clear();
        this.chatAdapter = new ChatAdapter(this, "", this.arrChat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        this.recyclerChat.setLayoutManager(linearLayoutManager);
        this.recyclerChat.setAdapter(this.chatAdapter);
        resumePlayer();
    }

    public void onetomanygetupdatedchatdata(long actualdate) {
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
        this.onetomanyrootRef = databaseReferenceChild;
        this.onetomantquery = databaseReferenceChild.orderByChild("date").startAt(actualdate);
        ChildEventListener childEventListener = new ChildEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.23
            @Override // com.google.firebase.database.ChildEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (YoutubePlayerActivity.this.checkstatus.equalsIgnoreCase("1")) {
                    YoutubePlayerActivity.this.chatAdapter.notifyDataSetChanged();
                    YoutubePlayerActivity.this.recyclerChat.smoothScrollToPosition(YoutubePlayerActivity.this.arrChat.size());
                    try {
                        chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                        if (chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                            if (YoutubePlayerActivity.this.pollarraylist.size() == 0) {
                                YoutubePlayerActivity.this.getpolldatawithid(chatpojo.getFirebase_id());
                            }
                        } else if (chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                            if (YoutubePlayerActivity.this.lockarr.size() == 0) {
                                if (chatpojo.getMessage().equalsIgnoreCase("0")) {
                                    YoutubePlayerActivity.this.islocked = "1";
                                    YoutubePlayerActivity.this.showchat();
                                } else {
                                    YoutubePlayerActivity.this.islocked = "2";
                                    YoutubePlayerActivity.this.hidechat();
                                }
                            }
                        } else if (YoutubePlayerActivity.this.arrChat.size() == 0) {
                            YoutubePlayerActivity.this.arrChat.add(chatpojo);
                            YoutubePlayerActivity.this.keyset.add(dataSnapshot.getKey());
                            YoutubePlayerActivity.this.chatAdapter.notifyDataSetChanged();
                            YoutubePlayerActivity.this.recyclerChat.smoothScrollToPosition(YoutubePlayerActivity.this.arrChat.size());
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    YoutubePlayerActivity.this.checkstatus = "0";
                    return;
                }
                if (dataSnapshot == null) {
                    return;
                }
                try {
                    chatPojo chatpojo2 = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                    if (chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                        if (chatpojo2.getIs_active().equalsIgnoreCase("2")) {
                            for (int i = 0; i < YoutubePlayerActivity.this.pollarraylist.size(); i++) {
                                if (YoutubePlayerActivity.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(chatpojo2.getFirebase_id())) {
                                    YoutubePlayerActivity.this.pollarraylist.get(i).setStatus("2");
                                    YoutubePlayerActivity.this.pollAdapter.notifyDataSetChanged();
                                    YoutubePlayerActivity.this.pollText.setText("Poll");
                                }
                            }
                        } else {
                            YoutubePlayerActivity.this.getpolldatawithid(chatpojo2.getFirebase_id());
                        }
                    } else if (!chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo2.getType().equalsIgnoreCase("is_chat_locked")) {
                        YoutubePlayerActivity.this.arrChat.add(chatpojo2);
                        YoutubePlayerActivity.this.keyset.add(dataSnapshot.getKey());
                    } else if (chatpojo2.getMessage().equalsIgnoreCase("0")) {
                        YoutubePlayerActivity.this.islocked = "1";
                        YoutubePlayerActivity.this.showchat();
                        YoutubePlayerActivity.this.lockarr.add(chatpojo2);
                    } else {
                        YoutubePlayerActivity.this.islocked = "2";
                        YoutubePlayerActivity.this.hidechat();
                        YoutubePlayerActivity.this.lockarr.add(chatpojo2);
                    }
                    YoutubePlayerActivity.this.chatAdapter.notifyDataSetChanged();
                    YoutubePlayerActivity.this.recyclerChat.smoothScrollToPosition(YoutubePlayerActivity.this.arrChat.size());
                } catch (Exception unused) {
                    Toast.makeText(YoutubePlayerActivity.this, "null pointer exception", 0).show();
                }
            }
        };
        this.onetomanychildEventListener = childEventListener;
        this.onetomantquery.addChildEventListener(childEventListener);
    }

    public void getupdatedchatdata(long actualdate) {
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        this.rootRef = databaseReferenceChild;
        this.query = databaseReferenceChild.orderByChild("date").startAt(actualdate);
        ChildEventListener childEventListener = new ChildEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.24
            @Override // com.google.firebase.database.ChildEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (YoutubePlayerActivity.this.checkstatus.equalsIgnoreCase("1")) {
                    YoutubePlayerActivity.this.chatAdapter.notifyDataSetChanged();
                    YoutubePlayerActivity.this.recyclerChat.smoothScrollToPosition(YoutubePlayerActivity.this.arrChat.size());
                    try {
                        chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                        if (chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                            if (YoutubePlayerActivity.this.pollarraylist.size() == 0) {
                                YoutubePlayerActivity.this.getpolldatawithid(chatpojo.getFirebase_id());
                            }
                        } else if (chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                            if (YoutubePlayerActivity.this.lockarr.size() == 0) {
                                if (chatpojo.getMessage().equalsIgnoreCase("0")) {
                                    YoutubePlayerActivity.this.islocked = "1";
                                    YoutubePlayerActivity.this.showchat();
                                } else {
                                    YoutubePlayerActivity.this.islocked = "2";
                                    YoutubePlayerActivity.this.hidechat();
                                }
                            }
                        } else if (YoutubePlayerActivity.this.arrChat.size() == 0) {
                            YoutubePlayerActivity.this.arrChat.add(chatpojo);
                            YoutubePlayerActivity.this.keyset.add(dataSnapshot.getKey());
                            YoutubePlayerActivity.this.chatAdapter.notifyDataSetChanged();
                            YoutubePlayerActivity.this.recyclerChat.smoothScrollToPosition(YoutubePlayerActivity.this.arrChat.size());
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    YoutubePlayerActivity.this.checkstatus = "0";
                    return;
                }
                if (dataSnapshot == null) {
                    return;
                }
                try {
                    chatPojo chatpojo2 = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                    if (chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                        if (chatpojo2.getIs_active().equalsIgnoreCase("2")) {
                            for (int i = 0; i < YoutubePlayerActivity.this.pollarraylist.size(); i++) {
                                if (YoutubePlayerActivity.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(chatpojo2.getFirebase_id())) {
                                    YoutubePlayerActivity.this.pollarraylist.get(i).setStatus("2");
                                    YoutubePlayerActivity.this.pollAdapter.notifyDataSetChanged();
                                    YoutubePlayerActivity.this.pollText.setText(YoutubePlayerActivity.this.getResources().getString(R.string.poll));
                                }
                            }
                        } else {
                            YoutubePlayerActivity.this.getpolldatawithid(chatpojo2.getFirebase_id());
                        }
                    } else if (!chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo2.getType().equalsIgnoreCase("is_chat_locked")) {
                        YoutubePlayerActivity.this.arrChat.add(chatpojo2);
                        YoutubePlayerActivity.this.keyset.add(dataSnapshot.getKey());
                    } else if (chatpojo2.getMessage().equalsIgnoreCase("0")) {
                        YoutubePlayerActivity.this.islocked = "1";
                        YoutubePlayerActivity.this.showchat();
                        YoutubePlayerActivity.this.lockarr.add(chatpojo2);
                    } else {
                        YoutubePlayerActivity.this.islocked = "2";
                        YoutubePlayerActivity.this.hidechat();
                        YoutubePlayerActivity.this.lockarr.add(chatpojo2);
                    }
                    YoutubePlayerActivity.this.chatAdapter.notifyDataSetChanged();
                    YoutubePlayerActivity.this.recyclerChat.smoothScrollToPosition(YoutubePlayerActivity.this.arrChat.size());
                } catch (Exception unused) {
                    YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                    Toast.makeText(youtubePlayerActivity, youtubePlayerActivity.getResources().getString(R.string.null_pointer_exception), 0).show();
                }
            }
        };
        this.childEventListener = childEventListener;
        this.query.addChildEventListener(childEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkintract() {
        DatabaseReference databaseReference = this.mFirebaseDatabaseReference1;
        if (databaseReference != null) {
            try {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.25
                    @Override // com.google.firebase.database.ValueEventListener
                    public void onCancelled(DatabaseError databaseError) {
                    }

                    @Override // com.google.firebase.database.ValueEventListener
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() != null) {
                            OnlineUser onlineUser = (OnlineUser) dataSnapshot.getValue(OnlineUser.class);
                            YoutubePlayerActivity.this.isintractavailable = true;
                            if (((OnlineUser) Objects.requireNonNull(onlineUser)).getInteract() == null) {
                                YoutubePlayerActivity.this.mFirebaseDatabaseReference1.child("interact").setValue("1");
                            } else if (onlineUser.getInteract().equalsIgnoreCase("0")) {
                                YoutubePlayerActivity.this.mFirebaseDatabaseReference1.child("interact").setValue("1");
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getpolldatawithid(final String randomid) {
        this.mFirebaseDatabaseReferencepolldata = null;
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + randomid);
        this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
        databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.26
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null) {
                    return;
                }
                Polldata polldata = (Polldata) new Gson().fromJson(new Gson().toJson(dataSnapshot.getValue()), Polldata.class);
                for (int i = 0; i < YoutubePlayerActivity.this.pollarraylist.size(); i++) {
                    if (YoutubePlayerActivity.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(randomid)) {
                        YoutubePlayerActivity.this.pollarraylist.get(i).setStatus("1");
                        YoutubePlayerActivity.this.pollAdapter.notifyDataSetChanged();
                        YoutubePlayerActivity.this.pollText.setText(YoutubePlayerActivity.this.getResources().getString(R.string.new_poll));
                        return;
                    }
                }
                try {
                    String str = randomid;
                    if (str != null) {
                        polldata.setRendomkey(str);
                        polldata.setStatus("1");
                        Snackbar.make(YoutubePlayerActivity.this.rootView.getRootView(), "New Poll Added", -1).show();
                        YoutubePlayerActivity.this.pollText.setText(YoutubePlayerActivity.this.getResources().getString(R.string.new_poll));
                        ((Polldata) Objects.requireNonNull(polldata)).setMyAnswer("0");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(0, polldata);
                        arrayList.addAll(YoutubePlayerActivity.this.pollarraylist);
                        YoutubePlayerActivity.this.pollarraylist.clear();
                        YoutubePlayerActivity.this.pollarraylist.addAll(arrayList);
                        YoutubePlayerActivity.this.pollAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void showDialog(View view) {
        if (Helper.isNetworkConnected(this)) {
            if (this.simpleExoPlayer != null) {
                pausePlayer();
                this.isActivityLive = false;
                final String str = formattedTime(this.simpleExoPlayer.getCurrentPosition());
                final Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
                dialog.requestWindowFeature(1);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.add_book_dialog);
                ((TextView) dialog.findViewById(R.id.text_dialog_time)).setText(getResources().getString(R.string.time_) + str);
                final EditText editText = (EditText) dialog.findViewById(R.id.nameTV);
                dialog.findViewById(R.id.btn_dialog_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.27
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        dialog.dismiss();
                        if (YoutubePlayerActivity.this.simpleExoPlayer != null) {
                            int playbackState = YoutubePlayerActivity.this.simpleExoPlayer.getPlaybackState();
                            ExoPlayer exoPlayer = YoutubePlayerActivity.this.simpleExoPlayer;
                            if (playbackState == 3) {
                                YoutubePlayerActivity.this.simpleExoPlayer.setPlayWhenReady(true);
                            }
                        }
                    }
                });
                dialog.findViewById(R.id.btn_dialog_submit).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.28
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        String string = editText.getText().toString();
                        if (string.length() > 0) {
                            dialog.dismiss();
                            Helper.hideKeyboard(YoutubePlayerActivity.this);
                            YoutubePlayerActivity.this.BookMarkApi("", str, string, "1");
                        } else {
                            YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                            Toast.makeText(youtubePlayerActivity, youtubePlayerActivity.getResources().getString(R.string.add_title), 0).show();
                        }
                    }
                });
                dialog.show();
                return;
            }
            Toast.makeText(this, getResources().getString(R.string.player_is_not_initialized_yet), 0).show();
            return;
        }
        Helper.showInternetToast(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BookMarkApi(String id, String time, String info2, final String state) {
        this.time = time;
        this.f330info = info2;
        this.state = state;
        this.networkCall.NetworkAPICall(API.add_video_index, "", false, false);
    }

    private String formattedTime(long millis) {
        if (millis < 1) {
            return "00:00:00";
        }
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(millis)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        try {
            boolean z = true;
            if (newConfig.orientation == 1) {
                this.mExoPlayerFullscreen = false;
                this.fullscreen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.exo_controls_fullscreen_enter));
                this.llll.setVisibility(0);
                this.linearLayout.setVisibility(0);
                this.video_name_text.setVisibility(0);
                if (this.isclicked.equalsIgnoreCase("1")) {
                    if (this.lockarr.size() > 0) {
                        if (this.islocked.equalsIgnoreCase("1")) {
                            if (!this.isChatPin) {
                                this.linearLayout.setVisibility(0);
                            }
                            this.chatlayout.setVisibility(0);
                        } else {
                            this.linearLayout.setVisibility(8);
                            this.chatlayout.setVisibility(8);
                        }
                    } else if (this.islockedback.equalsIgnoreCase("1")) {
                        this.linearLayout.setVisibility(8);
                        this.chatlayout.setVisibility(8);
                    } else {
                        if (!this.isChatPin) {
                            this.linearLayout.setVisibility(0);
                        }
                        this.chatlayout.setVisibility(0);
                    }
                }
                if (this.isclicked.equalsIgnoreCase("2")) {
                    if (!this.isChatPin) {
                        this.linearLayout.setVisibility(0);
                    }
                    this.addBookmark.setVisibility(0);
                }
                getWindow().clearFlags(1024);
                float f2 = getResources().getDisplayMetrics().density;
                if ((getResources().getConfiguration().screenLayout & 15) != 4) {
                    z = false;
                }
                this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ((f2 * ((getResources().getConfiguration().screenLayout & 15) == 3 ? 350.0f : z ? 450.0f : 230.0f)) + 0.5f)));
                Dialog dialog = this.dialog;
                if (dialog == null || !dialog.isShowing()) {
                    return;
                }
                if (this.recorder != null) {
                    stopRecording();
                }
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    this.mediaPlayer.pause();
                }
                this.seconds = 0;
                this.running = false;
                this.fileName = "";
                this.handler.removeCallbacksAndMessages(null);
                this.dialog.dismiss();
                return;
            }
            this.llll.setVisibility(8);
            this.linearLayout.setVisibility(8);
            this.mExoPlayerFullscreen = true;
            this.fullscreen.setImageDrawable(ContextCompat.getDrawable(this, 2131231286));
            this.video_name_text.setVisibility(8);
            this.chatlayout.setVisibility(8);
            this.addBookmark.setVisibility(8);
            this.linearLayout.setVisibility(8);
            getWindow().setFlags(1024, 1024);
            this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            Dialog dialog2 = this.dialog;
            if (dialog2 == null || !dialog2.isShowing()) {
                return;
            }
            if (this.recorder != null) {
                stopRecording();
            }
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
                this.mediaPlayer.pause();
            }
            this.seconds = 0;
            this.running = false;
            this.fileName = "";
            this.handler.removeCallbacksAndMessages(null);
            this.dialog.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
            Helper.hideSoftKeyboard(this);
        }
    }

    public void pausePlayer() {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.simpleExoPlayer.getPlaybackState();
        }
    }

    public void resumePlayer() {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(true);
            this.simpleExoPlayer.getPlaybackState();
        }
    }

    private void setUserOnline() {
        this.mFirebaseDatabaseReference1 = null;
        try {
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/").child(this.Chat_node).child("User").child(MakeMyExam.userId);
            this.mFirebaseDatabaseReference1 = databaseReferenceChild;
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.29
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() == null) {
                        YoutubePlayerActivity.this.mFirebaseDatabaseReference1.setValue(new OnlineUser(SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "true", MakeMyExam.userId, SharedPreference.getInstance().getLoggedInUser().getMobile(), "0", MakeMyExam.getTime_server()));
                    } else {
                        YoutubePlayerActivity.this.mFirebaseDatabaseReference1.child("online").setValue("true");
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setUserOffline() {
        if (this.mFirebaseDatabaseReference1 == null || ServerValue.TIMESTAMP == null) {
            return;
        }
        try {
            this.mFirebaseDatabaseReference1.child("online").setValue(ServerValue.TIMESTAMP);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        String str;
        if (images == null || images.isEmpty()) {
            return;
        }
        if (images.get(0).getFile().contains(".pdf")) {
            str = Const.PDF;
        } else if (images.get(0).getFile().contains(".mp3")) {
            str = "audio";
        } else {
            str = "image";
        }
        String str2 = str;
        try {
            if (images.get(0).getFile().trim().equals("")) {
                return;
            }
            if (!this.isintractavailable) {
                checkintract();
            }
            chatPojo chatpojo = new chatPojo(MakeMyExam.userId, images.get(0).getFile(), SharedPreference.getInstance().getLoggedInUser().getName(), MakeMyExam.getTime_server(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", str2, this.courseid);
            this.mFirebaseDatabaseReferenceone2one.push().setValue(chatpojo);
            this.mFirebaseDatabaseReferenceone2many.push().setValue(chatpojo);
            Helper.hideKeyboard(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -1548568073:
                if (apitype.equals(API.delete_video_index)) {
                    b2 = 0;
                }
                break;
            case -1423837165:
                if (apitype.equals(API.add_video_index)) {
                    b2 = 1;
                }
                break;
            case -1175877907:
                if (apitype.equals(API.user_video_view_data)) {
                    b2 = 2;
                }
                break;
            case -1124739567:
                if (apitype.equals(API.get_meta)) {
                    b2 = 3;
                }
                break;
            case -685656370:
                if (apitype.equals(API.update_video_view_time)) {
                    b2 = 4;
                }
                break;
            case 551901514:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source")) {
                    b2 = 5;
                }
                break;
            case 689906520:
                if (apitype.equals(API.API_ADD_TO_BOOKMARK)) {
                    b2 = 6;
                }
                break;
            case 2035937690:
                if (apitype.equals(API.get_video_logging)) {
                    b2 = 7;
                }
                break;
        }
        switch (b2) {
            case 0:
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setIndex_id(this.deletedindex);
                return service.deletevideoindex(AES.encrypt(new Gson().toJson(encryptionData)));
            case 1:
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setVideo_id(this.video_id);
                encryptionData2.setTime(this.time);
                encryptionData2.setInfo(this.f330info);
                return service.addvideoindex(AES.encrypt(new Gson().toJson(encryptionData2)));
            case 2:
                this.endtime = System.currentTimeMillis();
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setUser_id(MakeMyExam.getUserId());
                encryptionData3.setVideo_id(this.video_id);
                encryptionData3.setCourse_id(this.courseid);
                encryptionData3.setTile_id(TextUtils.isEmpty(this.tileid) ? "0" : this.tileid);
                encryptionData3.setType(this.videotype);
                encryptionData3.setStart_time(this.starttime);
                encryptionData3.setTotal_time(this.totalTime);
                encryptionData3.setPlatform("android");
                encryptionData3.setRemaining_time(String.valueOf(this.totalRemainingtime / 1000));
                encryptionData3.setEnd_time(String.valueOf(this.endtime));
                encryptionData3.setStart_time(String.valueOf(this.starttime));
                encryptionData3.setView_time(String.valueOf(((long) Float.parseFloat(this.remainingtime.split("_")[0])) - (this.totalRemainingtime / 1000)));
                return service.user_video_view_data(AES.encrypt(new Gson().toJson(encryptionData3)));
            case 3:
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setUser_id(MakeMyExam.getUserId());
                encryptionData4.setToken(this.video_id);
                encryptionData4.setCourse_id(this.courseid);
                return service.getmetaData(AES.encrypt(new Gson().toJson(encryptionData4)));
            case 4:
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setUser_id(MakeMyExam.getUserId());
                encryptionData5.setVideo_id(this.video_id);
                encryptionData5.setTile_id(TextUtils.isEmpty(this.tileid) ? "0" : this.tileid);
                encryptionData5.setCourse_id(this.courseid);
                encryptionData5.setStart_time(this.starttime);
                encryptionData5.setType(this.videotype);
                encryptionData5.setTotal_time(this.totalTime);
                encryptionData5.setView_time(String.valueOf(((long) Float.parseFloat(this.remainingtime.split("_")[0])) - (this.totalRemainingtime / 1000)));
                return service.update_video_view_time(AES.encrypt(new Gson().toJson(encryptionData5)));
            case 5:
                EncryptionData encryptionData6 = new EncryptionData();
                encryptionData6.setName(this.video_id + "_0_0");
                encryptionData6.setCourse_id(this.courseid);
                encryptionData6.setTile_id(TextUtils.isEmpty(this.tileid) ? "0" : this.tileid);
                encryptionData6.setType(this.tiletype);
                return service.getVideoLink(AES.encrypt(new Gson().toJson(encryptionData6)));
            case 6:
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setContent_id(this.video_id);
                encryptionData7.setIs_unbookmarked(this.bookmarkState);
                encryptionData7.setContent_type("3");
                return service.addPdfBookMark(AES.encrypt(new Gson().toJson(encryptionData7)));
            case 7:
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.endtime = jCurrentTimeMillis;
                long j = (jCurrentTimeMillis - this.currentTime) / 1000;
                EncryptionData encryptionData8 = new EncryptionData();
                encryptionData8.setVideo_id(this.video_id);
                encryptionData8.setEnd_time(String.valueOf(j));
                return service.get_video_logging(AES.encrypt(new Gson().toJson(encryptionData8)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03b0  */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r18, java.lang.String r19, java.lang.String r20, boolean r21) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.YoutubePlayerActivity.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        try {
            Toast.makeText(this, jsonstring, 0).show();
            if (!apitype.equalsIgnoreCase(API.user_video_view_data) && !apitype.equalsIgnoreCase(API.update_video_view_time)) {
                return;
            }
            HashMap map = new HashMap();
            map.put("user_id", SharedPreference.getInstance().getLoggedInUser().getId());
            map.put("course_id", this.courseid);
            map.put(Const.VIDEO_ID, this.video_id);
            map.put("tile_id", this.tileid);
            map.put(Const.TOTAL_TIME, this.totalTime);
            map.put(Const.VIDEO_TYPE, this.videotype);
            map.put(Const.ENDTime, String.valueOf(this.endtime));
            map.put(Const.StartTime, String.valueOf(this.starttime));
            map.put("platform", "android");
            map.put(Const.VIEW_TIME, String.valueOf(((long) Float.parseFloat(this.remainingtime.split("_")[0])) - (this.totalRemainingtime / 1000)));
            map.put(Const.remaining_time, String.valueOf(this.totalRemainingtime / 1000));
            SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setIndex() {
        this.isclicked = "3";
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.linearLayout.setVisibility(8);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        setAdapter();
    }

    public void setVideoTimeMS(int timeMS) {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.seekTo(timeMS);
        } else {
            Toast.makeText(this, getResources().getString(R.string.please_wait_player_is_not_ready), 0).show();
        }
    }

    void disableAll() {
        this.pinChat.setBackgroundColor(getResources().getColor(R.color.off_white));
        if (this.isclicked.equalsIgnoreCase("1") || this.isclicked.equalsIgnoreCase("6")) {
            this.pinll.setVisibility(0);
        } else {
            this.pinll.setVisibility(8);
        }
    }

    private void setAdapter() {
        Adapter_recycleveiw_vedio adapter_recycleveiw_vedio = new Adapter_recycleveiw_vedio(this, this.indexdata, "live");
        this.adapter = adapter_recycleveiw_vedio;
        this.recyclerChat.setAdapter(adapter_recycleveiw_vedio);
    }

    private void setbookmarkadapter() {
        BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(this, this.bookmarkdata, "Liveaws");
        this.bookmarkAdapter = bookmarkAdapter;
        this.recyclerChat.setAdapter(bookmarkAdapter);
    }

    private void setBookMark() {
        this.isclicked = "2";
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        if (getResources().getConfiguration().orientation == 2) {
            this.linearLayout.setVisibility(8);
        } else {
            this.linearLayout.setVisibility(0);
        }
        disableAll();
        this.addBookmark.setVisibility(0);
        this.chatlayout.setVisibility(8);
        setbookmarkadapter();
    }

    private void setNotesAdapter() {
        NotesAdapter notesAdapter = new NotesAdapter(this, this.pdf, "");
        this.notesAdapter = notesAdapter;
        this.recyclerChat.setAdapter(notesAdapter);
    }

    public void isvisiblelayouts(int ispoll, int isindex, int isbookmark, int islivechat, int ispdf, int isvod, int isDoubt) {
        this.bookmark_btn.setVisibility(0);
        this.index_btn.setVisibility(0);
        this.vodchat_btn.setVisibility(0);
        this.chat_btn.setVisibility(0);
        this.poll.setVisibility(0);
        this.pdf_btn.setVisibility(0);
        this.doubt_btn.setVisibility(0);
        try {
            this.liveDot.setVisibility(0);
            Glide.with((FragmentActivity) this).asGif().load(Integer.valueOf(R.drawable.live_dot_blinker)).into(this.liveDot);
        } catch (Exception unused) {
            this.liveDot.setVisibility(8);
        }
        if (isbookmark == 0) {
            this.bookmark_btn.setVisibility(8);
        }
        if (isindex == 0) {
            this.index_btn.setVisibility(8);
        }
        if (isvod == 0) {
            this.vodchat_btn.setVisibility(8);
        }
        if (islivechat == 0) {
            this.chat_btn.setVisibility(8);
        }
        if (ispoll == 0) {
            this.poll.setVisibility(8);
        } else {
            BottomSetting bottomSetting = this.bottomSetting;
            if (bottomSetting != null) {
                if (bottomSetting.getPoll_management() != null && this.bottomSetting.getPoll_management().equalsIgnoreCase("1")) {
                    this.poll.setVisibility(0);
                } else {
                    this.poll.setVisibility(8);
                }
            }
        }
        if (ispdf == 0) {
            this.pdf_btn.setVisibility(8);
        }
        if (isDoubt == 0) {
            this.doubt_btn.setVisibility(8);
        }
        if (islivechat == 1) {
            manageButtonUI(false, false, false, true, false, false, false);
        } else {
            manageButtonUI(true, false, false, false, false, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSpeedOptions() {
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
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.30
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    YoutubePlayerActivity.this.playerSpeed = item.getTitle().toString();
                    if (YoutubePlayerActivity.this.simpleExoPlayer == null) {
                        return false;
                    }
                    YoutubePlayerActivity.this.speedTV.setText(YoutubePlayerActivity.this.playerSpeed);
                    if (YoutubePlayerActivity.this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
                        YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                        if (!YoutubePlayerActivity.this.isPlaying()) {
                            return false;
                        }
                        YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                        youtubePlayerActivity.setTimer(youtubePlayerActivity.totalRemainingtime);
                        return false;
                    }
                    YoutubePlayerActivity.this.simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf(YoutubePlayerActivity.this.playerSpeed.replace("x", "")).floatValue()));
                    if (!YoutubePlayerActivity.this.isPlaying()) {
                        return false;
                    }
                    YoutubePlayerActivity youtubePlayerActivity2 = YoutubePlayerActivity.this;
                    youtubePlayerActivity2.setTimer(youtubePlayerActivity2.totalRemainingtime);
                    return false;
                }
            });
            popupMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goLive() {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.seekTo(exoPlayer.getDuration());
        }
    }

    private void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen) { // from class: com.appnew.android.player.YoutubePlayerActivity.31
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (YoutubePlayerActivity.this.mExoPlayerFullscreen) {
                    YoutubePlayerActivity.this.closeFullScreenDialogNew();
                }
                super.onBackPressed();
            }
        };
    }

    public void setpollcount(final String pollkey, final String answer) {
        this.mFirebaseDatabaseReferencepolldata = null;
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + pollkey);
        this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
        databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.32
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() == null) {
                        return;
                    }
                    for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        String key = dataSnapshot2.getKey();
                        if (answer.equalsIgnoreCase("1")) {
                            if (key.equalsIgnoreCase("attempt_1")) {
                                YoutubePlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_1");
                            }
                        } else if (answer.equalsIgnoreCase("2")) {
                            if (key.equalsIgnoreCase("attempt_2")) {
                                YoutubePlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_2");
                            }
                        } else if (answer.equalsIgnoreCase("3")) {
                            if (key.equalsIgnoreCase("attempt_3")) {
                                YoutubePlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_3");
                            }
                        } else if (answer.equalsIgnoreCase("4") && key.equalsIgnoreCase("attempt_4")) {
                            YoutubePlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_4");
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void setcountincrement(final long count, final String child) {
        try {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferencepolldata;
            if (databaseReference != null) {
                databaseReference.child(child).setValue(Long.valueOf(count));
            } else {
                Toast.makeText(this, getResources().getString(R.string.key_is_empty), 0).show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String getdate(String timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * 1000));
    }

    public void onDelete(VideoTimeFramePojo data, int position) {
        BookMarkDeleteApi(data.getId(), "", "", "2");
        this.pos = position;
    }

    private void BookMarkDeleteApi(String id, String s, String s1, String s2) {
        this.deletedindex = id;
        this.networkCall.NetworkAPICall(API.delete_video_index, "", false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imgClick() {
        final CharSequence[] charSequenceArr = {getResources().getString(R.string.take_photo), getResources().getString(R.string.choose_from_gallery), getResources().getString(R.string.cancel)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.add_photo));
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$imgClick$23(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$imgClick$23(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals(getResources().getString(R.string.take_photo))) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getFilesDir(), "temp_image.jpg"));
                this.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                this.someActivityResultLauncher.launch(intent);
                this.requestCode = 10000;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (charSequenceArr[i].equals(getResources().getString(R.string.choose_from_gallery))) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Uri uriForFile2 = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getFilesDir(), "temp_gallery.jpg"));
            this.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            this.someActivityResultLauncher.launch(intent2);
            this.requestCode = 20000;
            return;
        }
        if (charSequenceArr[i].equals(getResources().getString(R.string.cancel))) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$24(CropImageView.CropResult cropResult) {
        if (cropResult.isSuccessful()) {
            if (this.str_imgTypeClick.equalsIgnoreCase("PhotoCameraRequest")) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), cropResult.getUriContent());
                    String str = getFilesDir() + "/Utkarsh/Profile/";
                    new File(str).mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str + File.separator + (MakeMyExam.userId + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.s3IU = new s3ImageUploading(this.Chat_node, "vc-10000386-38616500102/application/chat_system/" + this.Chat_node + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
                    ArrayList arrayList = new ArrayList();
                    MediaFile mediaFile = new MediaFile();
                    mediaFile.setFile_type("image");
                    mediaFile.setImage(bitmap);
                    arrayList.add(mediaFile);
                    this.s3IU.execute(arrayList);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (this.str_imgTypeClick.equalsIgnoreCase("PhotoGalleryRequest")) {
                try {
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), cropResult.getUriContent());
                    String str2 = getFilesDir() + "/utkarsh/ProfileImage/";
                    new File(str2).mkdirs();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str2 + File.separator + (MakeMyExam.userId + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.s3IU = new s3ImageUploading(this.Chat_node, "vc-10000386-38616500102/application/chat_system/" + this.Chat_node + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
                    ArrayList arrayList2 = new ArrayList();
                    MediaFile mediaFile2 = new MediaFile();
                    mediaFile2.setFile_type("image");
                    mediaFile2.setImage(bitmap2);
                    arrayList2.add(mediaFile2);
                    this.s3IU.execute(arrayList2);
                    return;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            return;
        }
        Log.d("TAGCropImage", "CropImage: " + cropResult.getError().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$25(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            int i = this.requestCode;
            if (i != 10000) {
                if (i == 20000) {
                    try {
                        this.cropImage.launch(new CropImageContractOptions(activityResult.getData().getData(), Helper.cropImageOptions(this)));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                if (i != 101 || activityResult.getData() == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 30) {
                    setupDoc(copyFileToInternalStorage(activityResult.getData().getData(), getString(R.string.pdf_path_last_segment)));
                    return;
                } else {
                    setupDoc(RealPathUtil.getPath(this, activityResult.getData().getData()));
                    return;
                }
            }
            try {
                File file = new File(String.valueOf(getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
                File[] fileArrListFiles = file.listFiles();
                int length = fileArrListFiles.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    File file2 = fileArrListFiles[i2];
                    if (file2.getName().equals("temp_image.jpg")) {
                        file = file2;
                        break;
                    }
                    i2++;
                }
                this.cropImage.launch(new CropImageContractOptions(FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", file), Helper.cropImageOptions(this)));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private String copyFileToInternalStorage(Uri uri, String newDirName) {
        File file;
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (!newDirName.equals("")) {
            File file2 = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        } else {
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        }
        try {
            if (!file.exists()) {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                inputStreamOpenInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return file.getPath();
    }

    public void setupDoc(String selectedURI) {
        MediaFile mediaFile = new MediaFile();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(selectedURI) && !selectedURI.contains(getResources().getString(R.string.pdf_extension)) && !selectedURI.contains(getResources().getString(R.string.doc_extension)) && !selectedURI.contains(getResources().getString(R.string.xls_extension))) {
            Toast.makeText(this, getResources().getString(R.string.file_format_error), 0).show();
            return;
        }
        if (selectedURI.contains(getResources().getString(R.string.pdf_extension))) {
            mediaFile.setImage(BitmapFactory.decodeResource(getResources(), R.mipmap.pdf));
            mediaFile.setFile_type(Const.PDF);
        }
        this.s3IU = new s3ImageUploading(this.Chat_node, "vc-10000386-38616500102/application/chat_system/" + this.Chat_node + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
        String[] strArrSplit = selectedURI.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        mediaFile.setFile_name(strArrSplit[strArrSplit.length - 1]);
        mediaFile.setFile(selectedURI);
        mediaFile.setFile_type(Const.PDF);
        arrayList.add(mediaFile);
        this.s3IU.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimer(long time) {
        String str = this.playerSpeed;
        final int iRound = (str == null || str.equalsIgnoreCase(Const.Normal)) ? 1000 : Math.round(1000.0f / Float.parseFloat(this.playerSpeed.replace("x", "")));
        this.txtTimer.setVisibility(0);
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity.33
            @Override // java.lang.Runnable
            public void run() {
                YoutubePlayerActivity.this.video_name_text.setSelected(true);
            }
        }, 300L);
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
            Runnable runnable = new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity.34
                @Override // java.lang.Runnable
                public void run() {
                    if (YoutubePlayerActivity.this.simpleExoPlayer != null) {
                        YoutubePlayerActivity.this.totalRemainingtime -= 1000;
                        YoutubePlayerActivity.this.txtTimer.setText(Html.fromHtml("Remaining video time\n <font color='#018da4'>" + Helper.formatSeconds(((int) YoutubePlayerActivity.this.totalRemainingtime) / 1000) + "</font>"));
                        YoutubePlayerActivity.this.minute = r0.simpleExoPlayer.getCurrentPosition() / 1000;
                        if (YoutubePlayerActivity.this.demo_percent != null && !YoutubePlayerActivity.this.demo_percent.equalsIgnoreCase("") && (YoutubePlayerActivity.this.minute * Integer.parseInt(YoutubePlayerActivity.this.demo_percent)) / 100.0f > YoutubePlayerActivity.this.minute) {
                            YoutubePlayerActivity.this.pausePlayer();
                            YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                            Helper.showDialog(youtubePlayerActivity, youtubePlayerActivity.getResources().getString(R.string.this_is_demo_video_if_you_want_to_watch_this_video_please_purchase_this_course_thanks));
                        }
                        float f2 = YoutubePlayerActivity.this.minute;
                    }
                    if (YoutubePlayerActivity.this.totalRemainingtime > 0) {
                        YoutubePlayerActivity.this.handler1.postDelayed(this, iRound);
                    } else {
                        YoutubePlayerActivity.this.totalRemainingtime = 0L;
                        YoutubePlayerActivity.this.callFinishRemainingTime();
                    }
                }
            };
            this.runable1 = runnable;
            this.handler1.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callFinishRemainingTime() {
        findViewById(R.id.quality).setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.totalRemainingtime = 0L;
        this.networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
        releasePlayer();
        DialogUtils.makeDialog(this, getResources().getString(R.string.alert), getResources().getString(R.string.video_time_is_expired), getResources().getString(R.string.ok), getResources().getString(R.string.cancel), false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.player.YoutubePlayerActivity.35
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                YoutubePlayerActivity.this.releasePlayer();
                YoutubePlayerActivity.this.finish();
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda16
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                this.f$0.lambda$callFinishRemainingTime$26();
            }
        });
        this.txtTimer.setText(Html.fromHtml(getResources().getString(R.string.remaining_video_time)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callFinishRemainingTime$26() {
        releasePlayer();
        finish();
    }

    public void makeDialog(Context context, String titleTxt, String messageTxt, String submitTxt, boolean isCancelable) {
        try {
            final Dialog dialog = new Dialog(context);
            dialog.setCancelable(isCancelable);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
            dialog.setContentView(R.layout.dialog_alert_simple_1);
            TextView textView = (TextView) dialog.findViewById(R.id.titleDialog);
            TextView textView2 = (TextView) dialog.findViewById(R.id.msgDialog);
            Button button = (Button) dialog.findViewById(R.id.btn_cancel);
            Button button2 = (Button) dialog.findViewById(R.id.btn_submit);
            if (TextUtils.isEmpty(titleTxt)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(titleTxt);
            }
            textView2.setText(messageTxt);
            button2.setText(submitTxt);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$makeDialog$27(dialog, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeDialog$27(Dialog dialog, View view) {
        try {
            releasePlayer();
            dialog.dismiss();
            finish();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.appnew.android.player.YoutubePlayerActivity$36] */
    public void setTimer1(long time) {
        this.countDownTimer2 = new CountDownTimer(time, 1000L) { // from class: com.appnew.android.player.YoutubePlayerActivity.36
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                YoutubePlayerActivity.this.totalRemainingtime1 = millisUntilFinished;
            }
        }.start();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isActivityLive = false;
        Handler handler = this.handler1;
        if (handler != null) {
            handler.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
            if (this.is_limited.equalsIgnoreCase("1") && !this.remainingtime.equalsIgnoreCase("")) {
                saveLocaltime();
                this.networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
            }
        }
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.simpleExoPlayer.release();
            this.simpleExoPlayer = null;
        }
        if ("1".equalsIgnoreCase("2")) {
            addRecordTime();
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.countDownTimer2;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        Handler handler2 = this.handler1;
        if (handler2 != null) {
            handler2.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
        }
    }

    private void saveLocaltime() {
        com.appnew.android.home.Constants.REMAININGTIME = String.valueOf(this.totalRemainingtime / 1000) + "_" + this.video_id;
        HashMap map = new HashMap();
        map.put("user_id", SharedPreference.getInstance().getLoggedInUser().getId());
        map.put("course_id", this.courseid);
        map.put(Const.VIDEO_ID, this.video_id);
        map.put("tile_id", this.tileid);
        map.put(Const.TOTAL_TIME, this.totalTime);
        map.put(Const.VIDEO_TYPE, this.videotype);
        map.put(Const.ENDTime, String.valueOf(this.endtime));
        map.put(Const.StartTime, String.valueOf(this.starttime));
        map.put("platform", "android");
        map.put(Const.VIEW_TIME, String.valueOf(((long) Float.parseFloat(this.remainingtime.split("_")[0])) - (this.totalRemainingtime / 1000)));
        map.put(Const.remaining_time, String.valueOf(this.totalRemainingtime / 1000));
        SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 3 && this.simpleExoPlayer.getPlayWhenReady();
    }

    private void addRecordTime() {
        this.networkCall.NetworkAPICall(API.get_video_logging, "", false, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.simpleExoPlayer = null;
        }
        if (this.islive.equalsIgnoreCase("0")) {
            try {
                if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, this.isaudio)) {
                    this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(playPosition), this.video_id, MakeMyExam.userId, this.isaudio);
                } else {
                    YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
                    youtubePlayerTable.setYoutubeid(this.url);
                    youtubePlayerTable.setYoutubetime(playPosition);
                    youtubePlayerTable.setIsaudio(this.isaudio);
                    youtubePlayerTable.setVideoid(this.video_id);
                    youtubePlayerTable.setVideoname(this.video_name);
                    youtubePlayerTable.setUserid(MakeMyExam.userId);
                    this.utkashRoom.getyoutubedata().addVideo(youtubePlayerTable);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        super.onStop();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        String str;
        if (getResources().getConfiguration().orientation == 2) {
            closeFullScreenDialogNew();
        } else if (this.isaudio.equalsIgnoreCase("1") && (str = this.url) != null && !str.equalsIgnoreCase("")) {
            background_play();
        } else {
            releasePlayer();
            super.onBackPressed();
        }
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter == null || chatAdapter.mediaPlayer == null || !this.chatAdapter.mediaPlayer.isPlaying()) {
            return;
        }
        this.chatAdapter.mediaPlayer.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releasePlayer() {
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.simpleExoPlayer.release();
            this.playerView.setPlayer(null);
            this.simpleExoPlayer = null;
            this.url = "";
            newOrientation = 0;
        }
    }

    private void background_play() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage(getResources().getString(R.string.app_name));
        builder.setPositiveButton(Html.fromHtml("<font color='#000000'>Stop</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$background_play$29(dialogInterface, i);
            }
        });
        builder.setNeutralButton(Html.fromHtml("<font color='#000000'>Cancel</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton(Html.fromHtml("<font color='#000000'>Play In background</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$background_play$31(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$background_play$29(DialogInterface dialogInterface, int i) {
        AudioPlayerService.isAudioPlaying = false;
        AudioPlayerService.videoid = "";
        AudioPlayerService.media_id = "";
        AudioPlayerService.video_currentpos = 0L;
        MakeMyExam.bitmap = null;
        if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, this.isaudio)) {
            if (this.simpleExoPlayer != null) {
                this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(this.simpleExoPlayer.getCurrentPosition()), this.video_id, MakeMyExam.userId, this.isaudio);
            }
        } else {
            YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
            youtubePlayerTable.setYoutubeid(this.url);
            youtubePlayerTable.setYoutubetime(playPosition);
            youtubePlayerTable.setIsaudio(this.isaudio);
            youtubePlayerTable.setVideoid(this.video_id);
            youtubePlayerTable.setVideoname(this.video_name);
            youtubePlayerTable.setUserid(MakeMyExam.userId);
            this.utkashRoom.getyoutubedata().addVideo(youtubePlayerTable);
        }
        releasePlayer();
        dialogInterface.cancel();
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$background_play$31(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this, (Class<?>) AudioPlayerService.class);
        intent.putExtra("videoUrl", this.audio_url);
        String str = this.islive;
        if (str == null || str.equalsIgnoreCase("5")) {
            intent.putExtra("isLive", true);
        } else {
            intent.putExtra("isLive", true);
        }
        intent.putExtra("shopView", false);
        intent.putExtra("type", "aws");
        MakeMyExam.bitmap = this.image;
        intent.putExtra(SDKConstants.PARAM_INTENT, "videos");
        intent.setAction("Start_Service");
        intent.putExtra("setAudioSeekPosition", true);
        try {
            intent.putExtra("audioTitle", this.video_name);
        } catch (Exception unused) {
            intent.putExtra("audioTitle", this.video_name);
        }
        intent.putExtra("audioOnly", true);
        intent.putExtra("audioDesc", this.video_name);
        intent.putExtra("videoid", this.video_id);
        intent.putExtra(SDKConstants.PARAM_A2U_MEDIA_ID, this.url);
        intent.putExtra("player_pos", this.simpleExoPlayer.getCurrentPosition());
        if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, this.isaudio)) {
            if (this.simpleExoPlayer != null) {
                this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(this.simpleExoPlayer.getCurrentPosition()), this.video_id, MakeMyExam.userId, this.isaudio);
            }
        } else {
            YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
            youtubePlayerTable.setYoutubeid(this.url);
            youtubePlayerTable.setYoutubetime(playPosition);
            youtubePlayerTable.setIsaudio(this.isaudio);
            youtubePlayerTable.setVideoid(this.video_id);
            youtubePlayerTable.setVideoname(this.video_name);
            youtubePlayerTable.setUserid(MakeMyExam.userId);
            this.utkashRoom.getyoutubedata().addVideo(youtubePlayerTable);
        }
        Util.startForegroundService(this, intent);
        AudioPlayerService.isAudioPlaying = true;
        com.appnew.android.home.Constants.pos = "1";
        releasePlayer();
        finish();
        dialogInterface.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Handler handler = this.handler1;
        Player player = null;
        if (handler != null) {
            handler.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
            if (this.is_limited.equalsIgnoreCase("1") && !this.remainingtime.equalsIgnoreCase("")) {
                this.networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
            }
        }
        if (this.isPublicChatEnabled) {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2many;
            if (databaseReference != null) {
                databaseReference.removeEventListener(this.onetomanyvalueEventListener);
                Query query = this.onetomantquery;
                if (query != null) {
                    query.removeEventListener(this.onetomanychildEventListener);
                }
            }
        } else {
            DatabaseReference databaseReference2 = this.mFirebaseDatabaseReferenceone2one;
            if (databaseReference2 != null) {
                databaseReference2.removeEventListener(this.valueEventListener);
                this.mFirebaseDatabaseReferenceone2one.removeEventListener(this.valueEventListener);
                Query query2 = this.query;
                if (query2 != null) {
                    query2.removeEventListener(this.childEventListener);
                }
                DatabaseReference databaseReference3 = this.rootRefcompleteclass;
                if (databaseReference3 != null) {
                    databaseReference3.removeEventListener(this.childEventListenercompleteclass);
                }
            }
        }
        if (this.islive.equalsIgnoreCase("5")) {
            setUserOffline();
        }
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.player.release();
            this.player = null;
            player.removeListener(this.listener);
        }
        this.playerView = null;
        this.utkashRoom = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.simpleExoPlayer == null) {
            this.simpleExoPlayer = new ExoPlayer.Builder(this).setSeekForwardIncrementMs(10000L).setSeekBackIncrementMs(10000L).build();
        }
        this.simpleExoPlayer.setPlayWhenReady(true);
        this.currentTime = System.currentTimeMillis();
        try {
            if (MakeMyExam.userId.equalsIgnoreCase("") || MakeMyExam.userId.equalsIgnoreCase("0")) {
                MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
                MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
            }
            ((TelephonyManager) getSystemService("phone")).listen(new PhoneStateListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.38
                @Override // android.telephony.PhoneStateListener
                public void onCallStateChanged(int state, String incomingNumber) {
                    if (state == 1) {
                        YoutubePlayerActivity.this.oncall(true);
                    }
                    if (state == 2) {
                        YoutubePlayerActivity.this.oncall(true);
                    }
                    if (state == 0) {
                        YoutubePlayerActivity.this.oncall(false);
                        ((AudioManager) YoutubePlayerActivity.this.getApplicationContext().getSystemService("audio")).setMode(0);
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
        String str = this.link;
        if (str != null && !str.equalsIgnoreCase("")) {
            playVideo(this.link);
        }
        this.playerSpeed = Const.Normal;
        this.speedTV.setText(Const.Normal);
    }

    public void oncall(final boolean b2) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity.39
            @Override // java.lang.Runnable
            public void run() {
                if (b2) {
                    YoutubePlayerActivity.this.pausePlayer();
                }
            }
        });
    }

    public void showchat() {
        if (!this.isclicked.equalsIgnoreCase("1") || getResources().getConfiguration().orientation == 2) {
            return;
        }
        this.linearLayout.setVisibility(0);
        this.chatlayout.setVisibility(0);
    }

    public void hidechat() {
        if (!this.isclicked.equalsIgnoreCase("1") || getResources().getConfiguration().orientation == 2) {
            return;
        }
        this.linearLayout.setVisibility(8);
        this.chatlayout.setVisibility(8);
    }

    public HashMap<String, Float> getServeyData(final Polldata polldata) {
        final HashMap<String, Float> map = new HashMap<>();
        this.mFirebaseDatabaseReferencepolldata = null;
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + polldata.getRendomkey());
        this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
        databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.40
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() == null) {
                        return;
                    }
                    for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        String key = dataSnapshot2.getKey();
                        if (key.equalsIgnoreCase("attempt_1")) {
                            YoutubePlayerActivity.this.attempt_1_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                        }
                        if (key.equalsIgnoreCase("attempt_2")) {
                            YoutubePlayerActivity.this.attempt_2_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                        }
                        if (key.equalsIgnoreCase("attempt_3")) {
                            YoutubePlayerActivity.this.attempt_3_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                        }
                        if (key.equalsIgnoreCase("attempt_4")) {
                            YoutubePlayerActivity.this.attempt_4_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                        }
                    }
                    YoutubePlayerActivity youtubePlayerActivity = YoutubePlayerActivity.this;
                    youtubePlayerActivity.total = youtubePlayerActivity.attempt_1_count + YoutubePlayerActivity.this.attempt_2_count + YoutubePlayerActivity.this.attempt_3_count + YoutubePlayerActivity.this.attempt_4_count;
                    map.put("total", Float.valueOf(YoutubePlayerActivity.this.total));
                    if (YoutubePlayerActivity.this.attempt_1_count != 0.0f) {
                        map.put("perA", Float.valueOf((YoutubePlayerActivity.this.attempt_1_count / YoutubePlayerActivity.this.total) * 100.0f));
                    } else {
                        map.put("perA", Float.valueOf(0.0f));
                    }
                    if (YoutubePlayerActivity.this.attempt_2_count != 0.0f) {
                        map.put("perB", Float.valueOf((YoutubePlayerActivity.this.attempt_2_count / YoutubePlayerActivity.this.total) * 100.0f));
                    } else {
                        map.put("perB", Float.valueOf(0.0f));
                    }
                    if (YoutubePlayerActivity.this.attempt_3_count != 0.0f) {
                        map.put("perC", Float.valueOf((YoutubePlayerActivity.this.attempt_3_count / YoutubePlayerActivity.this.total) * 100.0f));
                    } else {
                        map.put("perC", Float.valueOf(0.0f));
                    }
                    if (YoutubePlayerActivity.this.attempt_4_count != 0.0f) {
                        map.put("perD", Float.valueOf((YoutubePlayerActivity.this.attempt_4_count / YoutubePlayerActivity.this.total) * 100.0f));
                    } else {
                        map.put("perD", Float.valueOf(0.0f));
                    }
                    YoutubePlayerActivity.this.pollAdapter.SetServeyresult(polldata, map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        return map;
    }

    public void showPDF(final String url) {
        try {
            PDFView pDFView = this.webView;
            if (pDFView != null) {
                pDFView.recycle();
            }
            this.webView.fromUri(Uri.fromFile(new File(url))).onLoad(new OnLoadCompleteListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda18
                @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
                public final void loadComplete(int i) {
                    Helper.dismissProgressDialog();
                }
            }).onError(new OnErrorListener() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda19
                @Override // com.github.barteksc.pdfviewer.listener.OnErrorListener
                public final void onError(Throwable th) {
                    this.f$0.lambda$showPDF$33(th);
                }
            }).load();
        } catch (Exception e2) {
            fr.maxcom.util.Log.d("showPDF", "showPDF: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPDF$33(Throwable th) {
        Helper.dismissProgressDialog();
        Toast.makeText(this, getResources().getString(R.string.error_in_loading_pdf), 0).show();
    }

    public void deleteChat(int position) {
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference != null) {
            try {
                databaseReference.child(this.keyset.get(position)).removeValue();
                this.keyset.remove(position);
                this.arrChat.remove(position);
                this.chatAdapter.notifyDataSetChanged();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void completeclass() {
        this.rootRefcompleteclass = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/completevideo/");
        ChildEventListener childEventListener = new ChildEventListener() { // from class: com.appnew.android.player.YoutubePlayerActivity.41
            @Override // com.google.firebase.database.ChildEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot != null) {
                    try {
                        if (dataSnapshot.getKey().equalsIgnoreCase("offline_status") && ((Long) dataSnapshot.getValue()).longValue() == 0) {
                            com.appnew.android.home.Constants.REFRESHPAGE = "true";
                            com.appnew.android.home.Constants.revison_set = true;
                            YoutubePlayerActivity.this.finish();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot != null) {
                    try {
                        if (dataSnapshot.getKey().equalsIgnoreCase("offline_status") && ((Long) dataSnapshot.getValue()).longValue() == 0) {
                            com.appnew.android.home.Constants.REFRESHPAGE = "true";
                            com.appnew.android.home.Constants.revison_set = true;
                            YoutubePlayerActivity.this.finish();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
        this.childEventListenercompleteclass = childEventListener;
        this.rootRefcompleteclass.addChildEventListener(childEventListener);
    }

    public void showReactButton(final boolean isShow) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.YoutubePlayerActivity$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showReactButton$34(isShow);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showReactButton$34(boolean z) {
        if (z) {
            this.topImage.setVisibility(0);
            this.loveImage.setVisibility(0);
        } else {
            this.topImage.setVisibility(8);
            this.loveImage.setVisibility(8);
        }
    }
}
