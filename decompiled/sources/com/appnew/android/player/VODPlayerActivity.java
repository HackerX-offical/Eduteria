package com.appnew.android.player;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Size;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RatingBar;
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
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.dash.DefaultDashChunkSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.smoothstreaming.DefaultSsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.Interfaces.AsyncTaskCompleteListener;
import com.appnew.android.Courses.Modal.OnlineUser;
import com.appnew.android.Courses.PdfUtils.PdfUtils;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.Model.AddOptionModel;
import com.appnew.android.Model.AttemptedUserPoll;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.PlayerPojo.DoubtItemData;
import com.appnew.android.Model.PlayerPojo.DoubtResponse;
import com.appnew.android.Model.PlayerPojo.LeaderboardResponse;
import com.appnew.android.Model.PlayerPojo.LiveChat;
import com.appnew.android.Model.PlayerPojo.Metarespo;
import com.appnew.android.Model.PlayerPojo.Pdf;
import com.appnew.android.Model.PlayerPojo.PollResponse;
import com.appnew.android.Model.PlayerPojo.PollResponseData;
import com.appnew.android.Model.PlayerPojo.Polldata;
import com.appnew.android.Model.PlayerPojo.VideoTimeFramePojo;
import com.appnew.android.Model.PollLocalResult;
import com.appnew.android.Model.SendUserData;
import com.appnew.android.Model.Video;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.DrmLogPrinter;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.MakeMyExamForPoll;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.PreferencesUtil;
import com.appnew.android.Utils.RealPathUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.SharedPreferencePoll;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.cleverTap.WatchTimeTracker;
import com.appnew.android.customview.TrackSelectionDialog;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.player.music_player.ZoomableVideoView;
import com.appnew.android.table.VideosDownload;
import com.appnew.android.table.YoutubePlayerTable;
import com.bumptech.glide.Glide;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageView;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
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
import com.pallycon.exoplayersample.simple.InitializePlayerService;
import com.pallycon.exoplayersample.simple.NetworkCallDrm;
import com.pallycon.exoplayersample.simple.TrackSelectionHelper;
import com.pallycon.exoplayersample.simple.VideoCrypt;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import info.mqtt.android.service.Ack;
import info.mqtt.android.service.MqttAndroidClient;
import info.mqtt.android.service.QoS;
import io.socket.engineio.client.transports.Polling;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class VODPlayerActivity extends AppCompatActivity implements AsyncTaskCompleteListener, OnLoadCompleteListener, OnErrorListener, AmazonCallBack, TakeImageClass.imagefromcropper, NetworkCall.MyNetworkCallBack, InitializePlayerService {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static DefaultBandwidthMeter BANDWIDTH_METER = null;
    private static final String TAG = "ExoplayerActivity";
    private static OnDataSendListener dataSendListener = null;
    private static boolean isUserActive = false;
    private static int newOrientation;
    private static long playPosition;
    Activity activity;
    private long activityStartTime;
    private Adapter_recycleveiw_vedio adapter;
    TextView addBookmark;
    RecyclerView addOptionRecycler;
    RelativeLayout addOptionRl;
    RelativeLayout addPoll;
    ImageView audiocaetimage;
    private Runnable autoFeedbackRunnable;
    private BookmarkAdapter bookmarkAdapter;
    private ImageView bookmarkIcon;
    private LinearLayout bookmarkLinear;
    private CardView bookmark_btn;
    private BottomSetting bottomSetting;
    ChatAdapter chatAdapter;
    private LinearLayout chatLinear;
    RelativeLayout chatMainRl;
    private String chatNode;
    private CardView chat_btn;
    LinearLayout chatlayout;
    ValueEventListener chatvalueEventListener;
    CheckBox checkMark;
    ChildEventListener childEventListener;
    ChildEventListener childEventListenercompleteclass;
    RelativeLayout createPoll;
    NestedScrollView createPollNestedScrollView;
    ImageView cross;
    LinearLayoutCompat cvr;
    DataSource.Factory dataSourceFactory;
    private Dialog dialog;
    private SharedPreferences.Editor editor;
    EditText enterDelayET;
    EditText enterQuestionET;
    TextView enterTimeET;
    EditText etMessage;
    ImageView expand;
    private Handler feedbackHandler;
    private String fileName;
    private ImageView file_upload;
    TextView floatingText;
    private ImageView fullscreen;
    TextView generateLeaderboard;
    ChildEventListener getchatdata;
    RelativeLayout goToCurrentRl;
    private Handler handler;
    private Handler handler1;
    ImageView ic_back_pdf;
    ImageView ic_full_pdf;
    Bitmap image;
    private boolean inErrorState;
    private ImageView indexIcon;
    private LinearLayout indexLinear;
    private CardView index_btn;
    private boolean isShowingTrackSelectionDialog;
    private String isaudio;
    String islockedback;
    ImageView ivSend;
    private LandscapePollDialog landscapePollDialog;
    private TrackGroupArray lastSeenTrackGroupArray;
    private LeftMenu leftMenu;
    LinearLayout linearLayout;
    private String listenUrl;
    private ImageView liveChatIcon;
    private ImageView liveDot;
    LinearLayout llEnableMarkAsRead;
    LinearLayout llll;
    private TextView loveImage;
    private DatabaseReference mFirebaseDatabaseReference1;
    private DatabaseReference mFirebaseDatabaseReferenceChatLocked;
    private DatabaseReference mFirebaseDatabaseReferencePollAdded;
    private DatabaseReference mFirebaseDatabaseReferenceone2many;
    private DatabaseReference mFirebaseDatabaseReferenceone2one;
    private DatabaseReference mFirebaseDatabaseReferenceone2oneget;
    private DatabaseReference mFirebaseDatabaseReferencepolldata;
    private ImageView mFullScreenButton;
    private Dialog mFullScreenDialog;
    private ImageView mFullScreenIcon;
    private DataSource.Factory mediaDataSourceFactory;
    MediaPlayer mediaPlayer;
    MediaSource mediaSource;
    private MediaSource mediaSourceTemp;
    float minute;
    private MqttAndroidClient mqttClientListen;
    private MqttAndroidClient mqttClientPublish;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    NetworkCall networkCall;
    NetworkCallDrm networkCall1;
    private MyTelephonyCallback newCallback;
    private NotesAdapter notesAdapter;
    private MyPhoneStateListener oldListener;
    Query onetomantquery;
    ChildEventListener onetomanychildEventListener;
    DatabaseReference onetomanyrootRef;
    ValueEventListener onetomanyvalueEventListener;
    private ImageView pdfIcon;
    private LinearLayout pdfLinear;
    private TextView pdfText;
    public PDFView pdfViewPager;
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
    ValueEventListener pollAddedEventListener;
    private ImageView pollIcon;
    private LinearLayout pollMain;
    TextView pollType;
    int pos;
    private String privateNode;
    ProgressBar progressBar;
    ProgressBar progress_bar_pdf;
    private String publishUrl;
    ImageView quality;
    Query query;
    private MediaRecorder recorder;
    TextView recordtime;
    public RecyclerView recyclerChat;
    RecyclerView recylerViewPollOperator;
    public RelativeLayout rl_pdf_data;
    DatabaseReference rootRef;
    DatabaseReference rootRefcompleteclass;
    View rootView;
    private Runnable runable1;
    private s3ImageUploading s3IU;
    private int savedOrientation;
    RelativeLayout selectMode;
    private String settingNode;
    private SharedPreferences sharedPreferences;
    private List<String> sparseAdaptiveResolutionList;
    private HashMap<String, String> sparseAdaptiveVideoUrlList;
    private List<String> sparseKeyList;
    private List<String> sparseMuxedResolutionList;
    private HashMap<String, String> sparseMuxedVideoUrlList;
    private List<String> sparseOPUSAudioUrl;
    private TextView speedTV;
    ImageView startaudio;
    Button stopaudio;
    RelativeLayout submitPoll;
    private CompoundButton.OnCheckedChangeListener switchChatChangeListener;
    private CompoundButton.OnCheckedChangeListener switchEmoticonsChangeListener;
    private CompoundButton.OnCheckedChangeListener switchFeedbackChangeListener;
    private CompoundButton.OnCheckedChangeListener switchPublicChangeListener;
    private TelephonyManager telephonyManager;
    private File tempFile;
    RelativeLayout timeDurationRl;
    private Timer timer;
    private RelativeLayout topImage;
    private TrackSelectionHelper trackSelectionHelper;
    DefaultTrackSelector trackSelector;
    DefaultTrackSelector trackSelector1;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    private TextView tvGoLive;
    TextView tvMark;
    TextView txtTimer;
    private String userAgent;
    UtkashRoom utkashRoom;
    ValueEventListener valueEventListener;
    private ImageView video_bookmark;
    ImageView video_feedback;
    String video_id;
    String video_name;
    TextView video_name_text;
    Uri videouri;
    TextView viewLeaderboard;
    private ImageView vodChatIcon;
    private LinearLayout vodchatLinear;
    private CardView vodchat_btn;
    private boolean wasRunning;
    WatchTimeTracker watchTimeTracker;
    PDFView webView;
    String isclicked = "";
    private String deletedindex = "";
    long endtime = 0;
    boolean localapi = false;
    long currentTime = 0;
    String str_imgTypeClick = "";
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    public boolean ischatload = false;
    DrmLogPrinter drmLogPrinter = new DrmLogPrinter();
    String audio_url = "";
    private ConnectionQuality mConnectionClass = ConnectionQuality.UNKNOWN;
    String url = "";
    private String islive = "";
    boolean isUserScrolled = false;
    boolean isOperator = false;
    String modeOfPoll = "2";
    ArrayList<AddOptionModel> optionList = new ArrayList<>();
    boolean isVideoReadMarked = false;
    private String pollId = "";
    private String pollKey = "";
    private String pollDelay = "";
    private String pollValidity = "";
    private String pollQuestion = "";
    private String pollAnswer = "";
    private String pollOption1 = "";
    private String pollOption2 = "";
    private String pollOption3 = "";
    private String pollOption4 = "";
    private String pollOption5 = "";
    private String pollOption6 = "";
    ArrayList<chatPojo> arrChat = new ArrayList<>();
    ArrayList<chatPojo> pollarr = new ArrayList<>();
    ArrayList<chatPojo> lockarr = new ArrayList<>();
    ArrayList<Polldata> pollarraylist = new ArrayList<>();
    private String is_limited = "0";
    String speedx = "";
    private boolean mExoPlayerFullscreen = false;
    private final String STATE_PLAYER_FULLSCREEN = "playerFullscreen";
    String thumbnailurl = "";
    public boolean isActivityLive = false;
    private boolean isintractavailable = false;
    private List<VideoTimeFramePojo> indexdata = new ArrayList();
    private List<VideoTimeFramePojo> bookmarkdata = new ArrayList();
    private List<Pdf> pdf = new ArrayList();
    boolean errorCheck = false;
    private String time = "";

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private String f329info = "";
    private String state = "";
    String Chat_node = "";
    String courseid = "";
    String tileid = "";
    String tiletype = "";
    String videotype = "";
    private boolean isPublicChatEnabled = true;
    private int requestCode = -1;
    String link = "";
    String position = "";
    String parentid = "";
    private boolean isMuted = false;
    private String playerUserAgent = "ExoPlayerDemo";
    String token = "";
    String userId = "";
    String deviceID = "";
    ArrayList<chatPojo> pinchatList = new ArrayList<>();
    private List<String> keyset = new ArrayList();
    private int seconds = 0;
    private boolean running = false;
    private int PERMISSION_TYPE = 0;
    private int STORAGE_PERMISSION_TYPE = 0;
    public boolean isPinChat = false;
    String timing = "";
    DefaultTimeBar defaultTimeBar = null;
    TextView exo_duration = null;
    TextView exo_position = null;
    String bookmarkState = "";
    String videoId_value = "";
    private String add_bookmark = "";
    private int bookmarkHit = 0;
    private ArrayList<Video> allVideosList = new ArrayList<>();
    InputStream input = null;
    HttpURLConnection urlConnection = null;
    OutputStream output = null;
    private boolean retry = true;
    private String finalPdfUrl = "";
    boolean isUserOnPoll = false;
    boolean isFirebaseChat = true;
    boolean isShowViewAllLeaderBoard = false;
    LiveChat liveChat = null;
    Metarespo extraParam = null;
    String videoAdmin = "";
    String contentFlag = "NA";
    long mLastClickTime = 0;
    DoubtVideoAdapter doubtVideoAdapter = null;
    private CardView doubt_btn = null;
    private LinearLayout doubtLinear = null;
    private ImageView doubtIcon = null;
    private TextView doubtText = null;
    LinearLayout forDoubtll = null;
    RelativeLayout publishDoubts = null;
    TextView unpublishtxt = null;
    TextView publishTxt = null;
    RelativeLayout submitDoubts = null;
    RelativeLayout refressDoubtRl = null;
    String doubtPublishStatus = "unPublishDoubt";
    boolean isShowSubmit = true;
    boolean isUserOnDoubt = false;
    boolean isTextChanging = false;
    String defaultTimeDuration = "30 sec";
    String defaultDelayDuration = "20";
    boolean errorCheckNetwork = false;
    private ArrayList<AttemptedUserPoll> userList = new ArrayList<>();
    private LinearLayout textLayout = null;
    private LinearLayout endLayout = null;
    private LinearLayout audioMainLL = null;
    private ImageView pauseAudio = null;
    private ImageView cancelRecording = null;
    private ImageView sendRecording = null;
    private TextView audioRecordTime = null;
    private boolean isAudioRecording = true;
    private boolean isAudioPlaying = false;
    private Integer moveToPermission = 0;
    private String videoQuality = "360";
    private String resolution = "";
    public int resolutionPossition = 0;
    private LinearLayout llChatSetting = null;
    private SwitchCompat switchChat = null;
    private SwitchCompat switchEmoticons = null;
    private SwitchCompat switchPublic = null;
    private SwitchCompat switchFeedback = null;
    public boolean isLandscape = false;
    BroadcastReceiver downloadPdfReceiver = new BroadcastReceiver() { // from class: com.appnew.android.player.VODPlayerActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !intent.hasExtra("chatId")) {
                return;
            }
            intent.getStringExtra("chatId");
            VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (VODPlayerActivity.this.chatAdapter != null) {
                        VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    };
    private final Runnable processQueueRunnable = new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.14
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VODPlayerActivity.this.isDestroyed()) {
                    return;
                }
                if (VODPlayerActivity.this.incomingQueue.size() > 500) {
                    while (VODPlayerActivity.this.incomingQueue.size() > 50) {
                        VODPlayerActivity.this.incomingQueue.poll();
                    }
                }
                chatPojo chatpojo = (chatPojo) VODPlayerActivity.this.incomingQueue.poll();
                if (chatpojo != null) {
                    if (VODPlayerActivity.this.arrChat.size() >= 100) {
                        VODPlayerActivity.this.arrChat.remove(0);
                        if (!VODPlayerActivity.this.isUserScrolled) {
                            VODPlayerActivity.this.chatAdapter.notifyItemRemoved(0);
                        }
                    }
                    VODPlayerActivity.this.arrChat.add(chatpojo);
                    if (!VODPlayerActivity.this.isUserScrolled) {
                        VODPlayerActivity.this.chatAdapter.notifyItemInserted(VODPlayerActivity.this.arrChat.size() - 1);
                    }
                    if (!VODPlayerActivity.this.isUserScrolled && !VODPlayerActivity.this.isUserOnPoll && !VODPlayerActivity.this.isUserOnDoubt) {
                        VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size() - 1);
                    }
                }
                VODPlayerActivity.this.uiHandler.postDelayed(this, 100L);
            } catch (Exception e2) {
                Log.d("MQTT", "processQueueRunnable: " + e2.getMessage());
            }
        }
    };
    private final Runnable processQueueRunnableEmoji = new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.15
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VODPlayerActivity.this.isDestroyed()) {
                    return;
                }
                if (VODPlayerActivity.this.incomingQueueEmoji.size() > 500) {
                    while (VODPlayerActivity.this.incomingQueueEmoji.size() > 50) {
                        VODPlayerActivity.this.incomingQueueEmoji.poll();
                    }
                }
                chatPojo chatpojo = (chatPojo) VODPlayerActivity.this.incomingQueueEmoji.poll();
                if (chatpojo != null) {
                    VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                    vODPlayerActivity.makeFlyAnimation(vODPlayerActivity.emojiToDrawable(chatpojo.getMessage()));
                }
                VODPlayerActivity.this.uiHandlerEmoji.postDelayed(this, 50L);
            } catch (Exception e2) {
                Log.d("MQTT", "processQueueRunnableEmoji: " + e2.getMessage());
            }
        }
    };
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda41
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$34((Boolean) obj);
        }
    });
    int lastseleted = -1;
    String checkstatus = "";
    String islocked = "0";
    private ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda42
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$42((CropImageView.CropResult) obj);
        }
    });
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda43
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$43((ActivityResult) obj);
        }
    });
    private long viewTime1 = 0;
    private long totalRemainingtime = 0;
    private String starttime = "0";
    long timestamp = 0;
    private String totalTime = "";
    private String feedback_required = "";
    private String leftTime = "";
    private String remainingtime = "";
    private String demo_percent = "";
    float total = 0.0f;
    float attempt_1_count = 0.0f;
    float attempt_2_count = 0.0f;
    float attempt_3_count = 0.0f;
    float attempt_4_count = 0.0f;
    Player.Listener playerEventListener = new Player.Listener() { // from class: com.appnew.android.player.VODPlayerActivity.51
        @Override // androidx.media3.common.Player.Listener
        public void onEvents(Player player, Player.Events events) {
            super.onEvents(player, events);
            if (player == null || !player.isPlaying() || VODPlayerActivity.this.chatAdapter == null) {
                return;
            }
            VODPlayerActivity.this.chatAdapter.pauseAudio();
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
            if (playbackState == 2 && !VODPlayerActivity.this.player.getPlayWhenReady()) {
                VODPlayerActivity.this.player.setPlayWhenReady(true);
            }
            if (playbackState == 1) {
                if (VODPlayerActivity.this.handler1 != null) {
                    VODPlayerActivity.this.isActivityLive = false;
                    VODPlayerActivity.this.handler1.removeCallbacks(VODPlayerActivity.this.runable1);
                    VODPlayerActivity.this.runable1 = null;
                    VODPlayerActivity.this.handler1 = null;
                }
                VODPlayerActivity.this.progressBar.setVisibility(0);
                return;
            }
            if (playbackState == 2) {
                VODPlayerActivity.this.progressBar.setVisibility(0);
                if (VODPlayerActivity.this.handler1 != null) {
                    VODPlayerActivity.this.isActivityLive = false;
                    VODPlayerActivity.this.handler1.removeCallbacks(VODPlayerActivity.this.runable1);
                    VODPlayerActivity.this.runable1 = null;
                    VODPlayerActivity.this.handler1 = null;
                    return;
                }
                return;
            }
            if (playbackState == 3) {
                VODPlayerActivity.this.progressBar.setVisibility(8);
                if (VODPlayerActivity.this.isPlaying()) {
                    if (VODPlayerActivity.this.starttime.equalsIgnoreCase("0")) {
                        VODPlayerActivity.this.timestamp = System.currentTimeMillis();
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        vODPlayerActivity.starttime = String.valueOf(vODPlayerActivity.timestamp);
                    }
                    if (!VODPlayerActivity.this.isActivityLive && VODPlayerActivity.this.is_limited != null && VODPlayerActivity.this.is_limited.equalsIgnoreCase("1")) {
                        if (VODPlayerActivity.this.totalRemainingtime > 0) {
                            VODPlayerActivity.this.setTimer();
                        } else {
                            VODPlayerActivity.this.releasePlayer();
                            VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                            vODPlayerActivity2.makeDialog(vODPlayerActivity2, vODPlayerActivity2.getResources().getString(R.string.alert), VODPlayerActivity.this.getResources().getString(R.string.video_time_is_expired), VODPlayerActivity.this.getResources().getString(R.string.ok), false);
                        }
                    }
                    VODPlayerActivity.this.isActivityLive = true;
                    return;
                }
                if (VODPlayerActivity.this.handler1 != null) {
                    VODPlayerActivity.this.handler1.removeCallbacks(VODPlayerActivity.this.runable1);
                    VODPlayerActivity.this.runable1 = null;
                    VODPlayerActivity.this.handler1 = null;
                    if (VODPlayerActivity.this.is_limited.equalsIgnoreCase("1") && !VODPlayerActivity.this.remainingtime.equalsIgnoreCase("")) {
                        VODPlayerActivity.this.saveLocaltime();
                        if (VODPlayerActivity.this.utkashRoom.getvideoDownloadao().isLimitedvideo_exit(VODPlayerActivity.this.video_id, MakeMyExam.userId, VODPlayerActivity.this.is_limited)) {
                            VODPlayerActivity.this.utkashRoom.getvideoDownloadao().update_videoRemainingtime(VODPlayerActivity.this.video_id, MakeMyExam.userId, String.valueOf(VODPlayerActivity.this.totalRemainingtime > 0 ? VODPlayerActivity.this.totalRemainingtime / 1000 : 0L));
                        }
                    }
                }
                VODPlayerActivity.this.isActivityLive = false;
                return;
            }
            if (BuildConfig.FLAVOR.equalsIgnoreCase("garhwalsirenglish") || playbackState != 4) {
                return;
            }
            VODPlayerActivity.this.isActivityLive = false;
            if (VODPlayerActivity.this.handler1 != null) {
                VODPlayerActivity.this.handler1.removeCallbacks(VODPlayerActivity.this.runable1);
                VODPlayerActivity.this.runable1 = null;
                VODPlayerActivity.this.handler1 = null;
            }
            if (VODPlayerActivity.this.islive.equalsIgnoreCase("0") && !VODPlayerActivity.this.starttime.equalsIgnoreCase("0")) {
                try {
                    VODPlayerActivity.playPosition = 0L;
                    if (VODPlayerActivity.this.utkashRoom.getyoutubedata().isUserExist(VODPlayerActivity.this.video_id, MakeMyExam.userId, VODPlayerActivity.this.isaudio)) {
                        VODPlayerActivity.this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(VODPlayerActivity.playPosition), VODPlayerActivity.this.video_id, MakeMyExam.userId, VODPlayerActivity.this.isaudio);
                    } else {
                        YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
                        youtubePlayerTable.setYoutubeid(VODPlayerActivity.this.url);
                        youtubePlayerTable.setYoutubetime(VODPlayerActivity.playPosition);
                        youtubePlayerTable.setIsaudio(VODPlayerActivity.this.isaudio);
                        youtubePlayerTable.setVideoid(VODPlayerActivity.this.video_id);
                        youtubePlayerTable.setVideoname(VODPlayerActivity.this.video_name);
                        youtubePlayerTable.setUserid(MakeMyExam.userId);
                        VODPlayerActivity.this.utkashRoom.getyoutubedata().addVideo(youtubePlayerTable);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (VODPlayerActivity.this.player != null) {
                VODPlayerActivity.this.player.seekTo(0L);
                VODPlayerActivity.this.player.setPlayWhenReady(false);
                if (VODPlayerActivity.this.is_limited.equalsIgnoreCase("1") && !VODPlayerActivity.this.remainingtime.equalsIgnoreCase("")) {
                    VODPlayerActivity.this.saveLocaltime();
                }
                if (!VODPlayerActivity.this.starttime.equalsIgnoreCase("0")) {
                    VODPlayerActivity.this.networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
                }
                if (VODPlayerActivity.this.utkashRoom.getvideoDownloadao().isLimitedvideo_exit(VODPlayerActivity.this.video_id, MakeMyExam.userId, VODPlayerActivity.this.is_limited)) {
                    VODPlayerActivity.this.utkashRoom.getvideoDownloadao().update_videoRemainingtime(VODPlayerActivity.this.video_id, MakeMyExam.userId, String.valueOf(VODPlayerActivity.this.totalRemainingtime > 0 ? VODPlayerActivity.this.totalRemainingtime / 1000 : 0L));
                }
                if (VODPlayerActivity.this.utkashRoom.getvideoDownloadao().isvideo_exit(VODPlayerActivity.this.video_id, MakeMyExam.userId)) {
                    VODPlayerActivity.this.utkashRoom.getvideoDownloadao().update_videocurrenttime(VODPlayerActivity.this.video_id, MakeMyExam.userId, 0L, String.valueOf(VODPlayerActivity.this.totalTime));
                }
            }
            if (SharedPreference.getInstance().getString(Const.IS_AUTO_PLAY).equalsIgnoreCase("1")) {
                VODPlayerActivity.this.autoplayNextVideo();
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
            if (isPlaying) {
                VODPlayerActivity.this.errorCheck = false;
            }
            if (isPlaying) {
                VODPlayerActivity.this.errorCheckNetwork = false;
            }
            if (isPlaying) {
                if (VODPlayerActivity.this.watchTimeTracker != null) {
                    VODPlayerActivity.this.watchTimeTracker.startTracking();
                }
                if (VODPlayerActivity.this.islive.equalsIgnoreCase("5")) {
                    if (VODPlayerActivity.this.player.getDuration() <= VODPlayerActivity.this.player.getContentPosition() + 30000) {
                        if (VODPlayerActivity.this.speedTV.getVisibility() == 0) {
                            if (VODPlayerActivity.this.playerSpeed != null && !VODPlayerActivity.this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
                                VODPlayerActivity.this.playerSpeed = Const.Normal;
                                VODPlayerActivity.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                            }
                            VODPlayerActivity.this.speedTV.setVisibility(8);
                            VODPlayerActivity.this.speedTV.setText(Const.Normal);
                            return;
                        }
                        return;
                    }
                    if (VODPlayerActivity.this.bottomSetting == null || VODPlayerActivity.this.bottomSetting.getSeek_bar() == null || !VODPlayerActivity.this.bottomSetting.getSeek_bar().equalsIgnoreCase("1")) {
                        return;
                    }
                    VODPlayerActivity.this.speedTV.setVisibility(0);
                }
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
            VODPlayerActivity.this.handlePlayerError(error);
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
    private final ConcurrentLinkedQueue<chatPojo> incomingQueue = new ConcurrentLinkedQueue<>();
    private final Handler uiHandler = new Handler(Looper.getMainLooper());
    private final ConcurrentLinkedQueue<chatPojo> incomingQueueEmoji = new ConcurrentLinkedQueue<>();
    private final Handler uiHandlerEmoji = new Handler(Looper.getMainLooper());
    private final ActivityResultLauncher<String> requestPermissionLauncher1 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda45
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$73((Boolean) obj);
        }
    });
    private String rating = "";
    private int ratingType = 3;
    private String ratingMessage = "";
    boolean isReviewSubmitted = false;
    private long FEEDBACK_MIN_WATCH_TIME = 0;
    private long FEEDBACK_AUTO_TRIGGER_TIME = 0;
    private boolean isFeedbackShown = false;
    private boolean isFeedbackOpen = false;
    private boolean isFeedbackOpenByBack = false;
    final Utils.FeedbackBottomSheetDialog[] feedbackDialog = new Utils.FeedbackBottomSheetDialog[1];

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    static /* synthetic */ boolean lambda$handleChatCopyPaste$26(View view) {
        return true;
    }

    static /* synthetic */ void lambda$showConfirmationDialog$66() {
    }

    public String getAttemptedAnswer(String ansValue) {
        return ansValue;
    }

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    public static void setOnDataSendListener(OnDataSendListener listener) {
        dataSendListener = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x08bb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x08de  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0960  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0af6  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(final android.os.Bundle r18) {
        /*
            Method dump skipped, instruction units count: 2830
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.VODPlayerActivity.onCreate(android.os.Bundle):void");
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
        if (Helper.isNetworkConnected(this)) {
            int i = this.bookmarkHit;
            if (i < 3) {
                this.bookmarkHit = i + 1;
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
                return;
            }
            return;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2() {
        try {
            new OrientationEventListener(getApplicationContext()) { // from class: com.appnew.android.player.VODPlayerActivity.5
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    try {
                        if (Settings.System.getInt(VODPlayerActivity.this.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            boolean zIsPortrait = VODPlayerActivity.this.isPortrait(orientation);
                            if (!zIsPortrait && VODPlayerActivity.this.savedOrientation == 1) {
                                VODPlayerActivity.this.savedOrientation = 0;
                                VODPlayerActivity.this.setRequestedOrientation(2);
                            } else if (zIsPortrait && VODPlayerActivity.this.savedOrientation == 0) {
                                VODPlayerActivity.this.savedOrientation = 1;
                                VODPlayerActivity.this.setRequestedOrientation(2);
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
            if (this.optionList.size() <= 0) {
                return null;
            }
            int size = this.optionList.size();
            if (size == 1) {
                this.optionList.add(new AddOptionModel("Option 2", "B", false));
            } else if (size == 2) {
                this.optionList.add(new AddOptionModel("Option 3", "C", false));
            } else if (size == 3) {
                this.optionList.add(new AddOptionModel("Option 4", "D", false));
            } else {
                showMessage("You can add up to 4 option only");
            }
            this.addOptionRecycler.setLayoutManager(new LinearLayoutManager(this));
            if (this.modeOfPoll.equalsIgnoreCase("1")) {
                this.addOptionRecycler.setAdapter(new AddOptionAdapter(this, this.optionList, this.addOptionRl));
                return null;
            }
            this.addOptionRecycler.setAdapter(new AddOptionAdapter(this, this.optionList, true, this.addOptionRl));
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$4() {
        if (Helper.isConnected(this)) {
            PopupMenu popupMenu = new PopupMenu(this, this.selectMode, GravityCompat.START);
            popupMenu.getMenu().add("Survey");
            popupMenu.getMenu().add("Quiz");
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.6
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    VODPlayerActivity.this.optionList.clear();
                    VODPlayerActivity.this.optionList.add(new AddOptionModel("Option 1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false));
                    VODPlayerActivity.this.optionList.add(new AddOptionModel("Option 2", "B", false));
                    VODPlayerActivity.this.optionList.add(new AddOptionModel("Option 3", "C", false));
                    VODPlayerActivity.this.optionList.add(new AddOptionModel("Option 4", "D", false));
                    if (item.getTitle().toString().equalsIgnoreCase("Survey")) {
                        VODPlayerActivity.this.modeOfPoll = "1";
                        VODPlayerActivity.this.pollType.setText("Survey");
                        VODPlayerActivity.this.enterQuestionET.getText().clear();
                        VODPlayerActivity.this.enterTimeET.setText(VODPlayerActivity.this.defaultTimeDuration);
                        VODPlayerActivity.this.enterDelayET.setText(VODPlayerActivity.this.defaultDelayDuration);
                        VODPlayerActivity.this.addOptionRecycler.setLayoutManager(new LinearLayoutManager(VODPlayerActivity.this));
                        RecyclerView recyclerView = VODPlayerActivity.this.addOptionRecycler;
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        recyclerView.setAdapter(new AddOptionAdapter(vODPlayerActivity, vODPlayerActivity.optionList, VODPlayerActivity.this.addOptionRl));
                    } else if (item.getTitle().toString().equalsIgnoreCase("Quiz")) {
                        VODPlayerActivity.this.modeOfPoll = "2";
                        VODPlayerActivity.this.pollType.setText("Quiz");
                        VODPlayerActivity.this.enterQuestionET.getText().clear();
                        VODPlayerActivity.this.enterTimeET.setText(VODPlayerActivity.this.defaultTimeDuration);
                        VODPlayerActivity.this.enterDelayET.setText(VODPlayerActivity.this.defaultDelayDuration);
                        VODPlayerActivity.this.addOptionRecycler.setLayoutManager(new LinearLayoutManager(VODPlayerActivity.this));
                        RecyclerView recyclerView2 = VODPlayerActivity.this.addOptionRecycler;
                        VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                        recyclerView2.setAdapter(new AddOptionAdapter(vODPlayerActivity2, vODPlayerActivity2.optionList, true, VODPlayerActivity.this.addOptionRl));
                    }
                    return false;
                }
            });
            popupMenu.show();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$5() {
        if (Helper.isConnected(this)) {
            PopupMenu popupMenu = new PopupMenu(this, this.enterTimeET, GravityCompat.START);
            popupMenu.getMenu().add("15 sec");
            popupMenu.getMenu().add("30 sec");
            popupMenu.getMenu().add("45 sec");
            popupMenu.getMenu().add("60 sec");
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.7
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    VODPlayerActivity.this.enterTimeET.setText(item.getTitle().toString());
                    return false;
                }
            });
            popupMenu.show();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$6() {
        if (Helper.isConnected(this)) {
            sendWSMessage(leaderboardVideoWiseDataStr(), "GET_LEADERBOARD_VIDEOWISE", this.video_id);
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$7() {
        if (Helper.isConnected(this)) {
            sendWSMessage(generateLeaderboardVideoWiseDataStr(), "GENERATE_LEADERBOARD_VIDEOWISE", "");
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$8() {
        if (Helper.isConnected(this)) {
            this.createPoll.setVisibility(8);
            this.generateLeaderboard.setVisibility(8);
            this.viewLeaderboard.setVisibility(8);
            this.recylerViewPollOperator.setVisibility(8);
            this.addPoll.setVisibility(0);
            this.modeOfPoll = "2";
            this.pollType.setText("Quiz");
            this.enterQuestionET.getText().clear();
            this.enterTimeET.setText(this.defaultTimeDuration);
            this.enterDelayET.setText(this.defaultDelayDuration);
            this.optionList.clear();
            this.optionList.add(new AddOptionModel("Option 1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, false));
            this.optionList.add(new AddOptionModel("Option 2", "B", false));
            this.optionList.add(new AddOptionModel("Option 3", "C", false));
            this.optionList.add(new AddOptionModel("Option 4", "D", false));
            this.addOptionRecycler.setLayoutManager(new LinearLayoutManager(this));
            this.addOptionRecycler.setAdapter(new AddOptionAdapter(this, this.optionList, true, this.addOptionRl));
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$9() {
        boolean z;
        boolean z2;
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < 1000) {
            return null;
        }
        this.mLastClickTime = SystemClock.elapsedRealtime();
        if (Helper.isConnected(this)) {
            if (this.modeOfPoll.equalsIgnoreCase("2")) {
                Iterator<AddOptionModel> it = this.optionList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        z2 = false;
                        break;
                    }
                    AddOptionModel next = it.next();
                    if (TextUtils.isEmpty(next.getAnswer())) {
                        z = true;
                        z2 = false;
                        break;
                    }
                    if (next.isThisAnswerRight()) {
                        z2 = true;
                        z = false;
                        break;
                    }
                }
                if (z) {
                    showMessage("Option can't be blank");
                    return null;
                }
                if (!z2) {
                    showMessage("Please select any answer");
                    return null;
                }
            }
            if (this.enterTimeET.getText().toString().isEmpty() && TextUtils.isEmpty(this.enterTimeET.getText().toString())) {
                showMessage("Please enter time duration");
                return null;
            }
            if (this.enterDelayET.getText().toString().isEmpty() && TextUtils.isEmpty(this.enterDelayET.getText().toString())) {
                showMessage("Please enter delay time");
                return null;
            }
            if (!TextUtils.isDigitsOnly(this.enterDelayET.getText().toString())) {
                showMessage("Please enter valid delay time");
                return null;
            }
            if (this.isFirebaseChat) {
                this.networkCall.NetworkAPICall(API.createPoll, "", true, false);
            } else {
                sendWSMessage(createPollDataStr(), "CREATE_POLL", "");
            }
        } else {
            showMessage(getResources().getString(R.string.please_connect_internet_connection));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$10(Bundle bundle) {
        if (Helper.isNetworkConnected(this)) {
            ((Vibrator) getSystemService("vibrator")).vibrate(VibrationEffect.createOneShot(100L, -1));
            stopWatch(bundle);
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$11() {
        if (Helper.isNetworkConnected(this)) {
            this.isPinChat = true;
            setUpPinChat();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$12() {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(true, false, false, false, false, false, false);
            setBookMark();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$13() {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(false, true, false, false, false, false, false);
            setIndex();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$14() {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(false, false, true, false, false, false, false);
            setvodchat();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(false, false, false, true, false, false, false);
            setchat();
        } else {
            showMessage(getResources().getString(R.string.please_connect_internet_connection));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$16() {
        if (Helper.isConnected(this)) {
            ChatAdapter chatAdapter = this.chatAdapter;
            if (chatAdapter != null) {
                chatAdapter.pauseAudio();
            }
            manageButtonUI(false, false, false, false, true, false, false);
            setPoll();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$17() {
        if (Helper.isNetworkConnected(this)) {
            manageButtonUI(false, false, false, false, false, true, false);
            setNotes();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$18() {
        if (Helper.isNetworkConnected(this)) {
            if (this.isUserOnDoubt) {
                return null;
            }
            getAndUpdateDoubtList();
            return null;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$20() {
        if (Helper.isConnected(this)) {
            DefaultTrackSelector defaultTrackSelector = this.trackSelector1;
            if (defaultTrackSelector != null && defaultTrackSelector.getCurrentMappedTrackInfo() != null) {
                if (this.trackSelector1.getCurrentMappedTrackInfo() != null) {
                    this.isShowingTrackSelectionDialog = true;
                    TrackSelectionDialog.createForTrackSelector(this.trackSelector1, new DialogInterface.OnDismissListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda62
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.f$0.lambda$onCreate$19(dialogInterface);
                        }
                    }, this.resolutionPossition, this.resolution).show(getSupportFragmentManager(), (String) null);
                }
            } else {
                showMessage(getResources().getString(R.string.player_not_ready_try_again));
            }
        } else {
            showMessage(getResources().getString(R.string.no_internet_connection));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$19(DialogInterface dialogInterface) {
        this.isShowingTrackSelectionDialog = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$21(View view) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.10
            @Override // java.lang.Runnable
            public void run() {
                VODPlayerActivity.this.isUserScrolled = false;
                VODPlayerActivity.this.goToCurrentRl.setVisibility(8);
                if (VODPlayerActivity.this.chatAdapter != null) {
                    VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
                }
                VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$22(View view) {
        getAndUpdateDoubtList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBackPressed() {
        String str;
        if (getResources().getConfiguration().orientation == 2) {
            closeFullScreenDialogNew();
        } else if (this.isaudio.equalsIgnoreCase("1") && (str = this.url) != null && !str.equalsIgnoreCase("")) {
            background_play();
        } else {
            releasePlayer();
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
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
            } else {
                showFeedbackOnBack();
            }
        }
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter == null || chatAdapter.mediaPlayer == null || !this.chatAdapter.mediaPlayer.isPlaying()) {
            return;
        }
        this.chatAdapter.mediaPlayer.pause();
    }

    private void markAsReadVideoType1_7(String videotype) {
        if (Helper.isShowMarkAsDone(videotype)) {
            this.llEnableMarkAsRead.setVisibility(0);
        } else {
            this.llEnableMarkAsRead.setVisibility(8);
        }
        ArrayList<Video> arrayList = this.allVideosList;
        if (arrayList != null && arrayList.size() >= 1) {
            Iterator<Video> it = this.allVideosList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Video next = it.next();
                if (next.getId().equalsIgnoreCase(this.video_id) && !TextUtils.isEmpty(next.getMark_as_complete()) && next.getMark_as_complete().equalsIgnoreCase("1")) {
                    this.isVideoReadMarked = true;
                    break;
                }
                this.isVideoReadMarked = false;
            }
        }
        checkMarkUnmark();
        this.checkMark.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                boolean zIsChecked = ((CheckBox) v).isChecked();
                if (zIsChecked) {
                    VODPlayerActivity.this.markCheckAlertDialog(zIsChecked);
                }
            }
        });
    }

    private void checkMarkUnmark() {
        if (this.llEnableMarkAsRead.getVisibility() == 0 && this.isVideoReadMarked) {
            this.checkMark.setChecked(true);
            this.tvMark.setText(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
            this.checkMark.setEnabled(false);
        } else {
            this.checkMark.setChecked(false);
            this.tvMark.setText("Mark Complete");
            this.checkMark.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markCheckAlertDialog(final boolean isChecked) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        builder.setTitle(this.activity.getResources().getString(R.string.mark_read));
        builder.setCancelable(false);
        builder.setMessage(this.activity.getResources().getString(R.string.are_you_sure_you_want_to_mark_video_completed));
        builder.setNegativeButton(this.activity.getResources().getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda70
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$markCheckAlertDialog$23(dialogInterface, i);
            }
        });
        builder.setPositiveButton(this.activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda71
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$markCheckAlertDialog$24(isChecked, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markCheckAlertDialog$23(DialogInterface dialogInterface, int i) {
        this.checkMark.setChecked(false);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markCheckAlertDialog$24(boolean z, DialogInterface dialogInterface, int i) {
        if (Helper.isNetworkConnected(this) && z) {
            this.networkCall.NetworkAPICall(API.MARK_READ_VIDEO_TYPE_1_7, "", true, false);
        } else {
            this.checkMark.setChecked(false);
            showMessage("No internet connection");
        }
        dialogInterface.dismiss();
    }

    private void startMessageProcessor() {
        Handler handler;
        Runnable runnable;
        try {
            if (isDestroyed() || (handler = this.uiHandler) == null || (runnable = this.processQueueRunnable) == null) {
                return;
            }
            handler.post(runnable);
            ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue = this.incomingQueue;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
            }
        } catch (Exception e2) {
            Log.d("MQTT", "startMessageProcessor: " + e2.getMessage());
        }
    }

    private void stopMessageProcessor() {
        Runnable runnable;
        try {
            Handler handler = this.uiHandler;
            if (handler == null || (runnable = this.processQueueRunnable) == null || this.incomingQueue == null) {
                return;
            }
            handler.removeCallbacks(runnable);
            this.incomingQueue.clear();
        } catch (Exception e2) {
            Log.d("MQTT", "stopMessageProcessor: " + e2.getMessage());
        }
    }

    private void startMessageProcessorEmoji() {
        Handler handler;
        Runnable runnable;
        try {
            if (isDestroyed() || (handler = this.uiHandlerEmoji) == null || (runnable = this.processQueueRunnableEmoji) == null) {
                return;
            }
            handler.post(runnable);
            ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue = this.incomingQueueEmoji;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
            }
        } catch (Exception e2) {
            Log.d("MQTT", "startMessageProcessorEmoji: " + e2.getMessage());
        }
    }

    private void stopMessageProcessorEmoji() {
        Runnable runnable;
        try {
            Handler handler = this.uiHandlerEmoji;
            if (handler == null || (runnable = this.processQueueRunnableEmoji) == null || this.incomingQueueEmoji == null) {
                return;
            }
            handler.removeCallbacks(runnable);
            this.incomingQueueEmoji.clear();
        } catch (Exception e2) {
            Log.d("MQTT", "stopMessageProcessorEmoji: " + e2.getMessage());
        }
    }

    private void recordingActivities() {
        this.pauseAudio.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VODPlayerActivity.this.isAudioRecording) {
                    VODPlayerActivity.this.isAudioRecording = false;
                    VODPlayerActivity.this.running = false;
                    VODPlayerActivity.this.stopRecording();
                    VODPlayerActivity.this.pauseAudio.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    return;
                }
                if (!VODPlayerActivity.this.isAudioPlaying) {
                    if (VODPlayerActivity.this.seconds == 0) {
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        vODPlayerActivity.showMessage(vODPlayerActivity.getResources().getString(R.string.please_record_audio));
                    } else {
                        VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                        vODPlayerActivity2.mediaPlayer = MediaPlayer.create(vODPlayerActivity2, Uri.parse(vODPlayerActivity2.fileName));
                        VODPlayerActivity.this.mediaPlayer.start();
                        VODPlayerActivity.this.starttimer();
                    }
                    VODPlayerActivity.this.pauseAudio.setImageResource(R.drawable.ic_baseline_pause_24);
                    VODPlayerActivity.this.isAudioPlaying = true;
                    return;
                }
                VODPlayerActivity.this.isAudioPlaying = false;
                VODPlayerActivity.this.stoptimer();
                VODPlayerActivity.this.mediaPlayer.pause();
                VODPlayerActivity.this.pauseAudio.setImageResource(R.drawable.ic_baseline_play_arrow_24);
            }
        });
        this.cancelRecording.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VODPlayerActivity.this.stopRecording();
                if (VODPlayerActivity.this.mediaPlayer != null && VODPlayerActivity.this.mediaPlayer.isPlaying()) {
                    VODPlayerActivity.this.mediaPlayer.pause();
                }
                VODPlayerActivity.this.seconds = 0;
                VODPlayerActivity.this.running = false;
                VODPlayerActivity.this.fileName = "";
                if (VODPlayerActivity.this.handler != null) {
                    VODPlayerActivity.this.handler.removeCallbacksAndMessages(null);
                }
                if (VODPlayerActivity.this.audioMainLL != null) {
                    VODPlayerActivity.this.audioMainLL.setVisibility(8);
                }
                if (VODPlayerActivity.this.textLayout != null) {
                    VODPlayerActivity.this.textLayout.setVisibility(0);
                }
            }
        });
        this.sendRecording.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    if (Helper.isNetworkConnected(VODPlayerActivity.this)) {
                        if (VODPlayerActivity.this.fileName == null || VODPlayerActivity.this.fileName.isEmpty()) {
                            VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                            vODPlayerActivity.showMessage(vODPlayerActivity.getResources().getString(R.string.please_record_audio));
                        } else {
                            if (VODPlayerActivity.this.mediaPlayer != null && VODPlayerActivity.this.mediaPlayer.isPlaying()) {
                                VODPlayerActivity.this.mediaPlayer.pause();
                            }
                            VODPlayerActivity.this.seconds = 0;
                            VODPlayerActivity.this.running = false;
                            VODPlayerActivity.this.sendaudio();
                            if (VODPlayerActivity.this.handler != null) {
                                VODPlayerActivity.this.handler.removeCallbacksAndMessages(null);
                            }
                        }
                        if (VODPlayerActivity.this.audioMainLL != null) {
                            VODPlayerActivity.this.audioMainLL.setVisibility(8);
                        }
                        if (VODPlayerActivity.this.textLayout != null) {
                            VODPlayerActivity.this.textLayout.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                    vODPlayerActivity2.showMessage(vODPlayerActivity2.getResources().getString(R.string.no_internet_connection));
                } catch (Exception e2) {
                    VODPlayerActivity.this.showMessage("Error: " + e2.getMessage());
                }
            }
        });
        if (this.islive.equalsIgnoreCase("1") || this.islive.equalsIgnoreCase("5")) {
            pushEvent();
        }
    }

    private void handleChatCopyPaste(final EditText etMessage) {
        try {
            if (Const.IS_CHAT_COPY_PASTE_ENABLE) {
                etMessage.setInputType(524288);
                etMessage.setLongClickable(false);
                etMessage.setTextIsSelectable(false);
                etMessage.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda63
                    @Override // android.view.View.OnCreateContextMenuListener
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        contextMenu.clear();
                    }
                });
                etMessage.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda64
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return VODPlayerActivity.lambda$handleChatCopyPaste$26(view);
                    }
                });
                etMessage.setCustomInsertionActionModeCallback(new ActionMode.Callback() { // from class: com.appnew.android.player.VODPlayerActivity.19
                    @Override // android.view.ActionMode.Callback
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public void onDestroyActionMode(ActionMode mode) {
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }
                });
                etMessage.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: com.appnew.android.player.VODPlayerActivity.20
                    @Override // android.view.ActionMode.Callback
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public void onDestroyActionMode(ActionMode mode) {
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }
                });
                etMessage.setOnTouchListener(new View.OnTouchListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda65
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return VODPlayerActivity.lambda$handleChatCopyPaste$27(etMessage, view, motionEvent);
                    }
                });
            }
            etMessage.addTextChangedListener(new TextWatcher() { // from class: com.appnew.android.player.VODPlayerActivity.21
                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    if (VODPlayerActivity.this.bottomSetting == null || !"1".equalsIgnoreCase(VODPlayerActivity.this.bottomSetting.getAudio())) {
                        return;
                    }
                    if (VODPlayerActivity.this.ivSend != null) {
                        VODPlayerActivity.this.ivSend.setVisibility(s.toString().isEmpty() ? 8 : 0);
                    }
                    if (VODPlayerActivity.this.startaudio != null) {
                        VODPlayerActivity.this.startaudio.setVisibility(s.toString().isEmpty() ? 0 : 8);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (!Const.IS_CHAT_COPY_PASTE_ENABLE || VODPlayerActivity.this.isTextChanging) {
                        return;
                    }
                    VODPlayerActivity.this.isTextChanging = true;
                    try {
                        if (after - count > 1) {
                            try {
                                etMessage.setText(s);
                                etMessage.setSelection(s.length());
                            } catch (StackOverflowError e2) {
                                e2.printStackTrace();
                            }
                        }
                    } finally {
                        VODPlayerActivity.this.isTextChanging = false;
                    }
                }
            });
        } catch (Exception e2) {
            Log.d("TAGCopyPaste", "handleChatCopyPaste: " + e2.getMessage());
        }
    }

    static /* synthetic */ boolean lambda$handleChatCopyPaste$27(EditText editText, View view, MotionEvent motionEvent) {
        ClipboardManager clipboardManager;
        try {
            if (motionEvent.getAction() == 0 && (clipboardManager = (ClipboardManager) editText.getContext().getSystemService("clipboard")) != null && clipboardManager.hasPrimaryClip()) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLastVisible() {
        return ((LinearLayoutManager) this.recyclerChat.getLayoutManager()).findFirstCompletelyVisibleItemPosition() >= this.recyclerChat.getAdapter().getItemCount() - 1;
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
        showTileIcon(0);
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

    private void checkStoragePermission2() {
        this.PERMISSION_TYPE = 2;
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.VODPlayerActivity.22
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                VODPlayerActivity.this.OpenChooser();
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

    private void stopWatch(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.seconds = savedInstanceState.getInt("seconds");
            this.running = savedInstanceState.getBoolean("running");
            this.wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        Handler handler = new Handler();
        this.handler = handler;
        handler.post(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.23
            @Override // java.lang.Runnable
            public void run() {
                VODPlayerActivity.this.time = String.format(Locale.getDefault(), "%d:%02d:%02d", Integer.valueOf(VODPlayerActivity.this.seconds / 3600), Integer.valueOf((VODPlayerActivity.this.seconds % 3600) / 60), Integer.valueOf(VODPlayerActivity.this.seconds % 60));
                if (VODPlayerActivity.this.audioRecordTime != null) {
                    VODPlayerActivity.this.audioRecordTime.setText(VODPlayerActivity.this.time);
                }
                if (VODPlayerActivity.this.running) {
                    VODPlayerActivity.this.seconds++;
                }
                VODPlayerActivity.this.handler.postDelayed(this, 1000L);
            }
        });
        if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            this.requestPermissionLauncher.launch("android.permission.RECORD_AUDIO");
        } else {
            enableMicroPhone();
            pausePlayer();
            this.seconds = 0;
            this.running = true;
            startRecording();
        }
        ImageView imageView = this.pauseAudio;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ic_baseline_pause_24);
        }
        this.isAudioRecording = true;
        this.isAudioPlaying = false;
    }

    private void enableMicroPhone() {
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        audioManager.setMode(0);
        audioManager.setMicrophoneMute(false);
    }

    private void runTimer() {
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
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
        handler.post(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.24
            @Override // java.lang.Runnable
            public void run() {
                VODPlayerActivity.this.time = String.format(Locale.getDefault(), "%d:%02d:%02d", Integer.valueOf(VODPlayerActivity.this.seconds / 3600), Integer.valueOf((VODPlayerActivity.this.seconds % 3600) / 60), Integer.valueOf(VODPlayerActivity.this.seconds % 60));
                VODPlayerActivity.this.recordtime.setText(VODPlayerActivity.this.time);
                if (VODPlayerActivity.this.running) {
                    VODPlayerActivity.this.seconds++;
                }
                VODPlayerActivity.this.handler.postDelayed(this, 1000L);
            }
        });
        button.setText(getResources().getString(R.string.record));
        button2.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda56
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$runTimer$28();
            }
        }));
        this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda57
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$runTimer$29(dialogInterface);
            }
        });
        button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda58
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$runTimer$30(button);
            }
        }));
        this.play.setText(getResources().getString(R.string.play));
        this.play.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$runTimer$31(button);
            }
        }));
        button3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$runTimer$32();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$runTimer$28() {
        if (Helper.isNetworkConnected(this)) {
            String str = this.fileName;
            if (str == "" || str == null) {
                showMessage(getResources().getString(R.string.please_record_audio));
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
            showMessage(getResources().getString(R.string.no_internet_connection));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runTimer$29(DialogInterface dialogInterface) {
        resumePlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$runTimer$30(Button button) {
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
    public /* synthetic */ Unit lambda$runTimer$31(Button button) {
        if (!button.getText().equals("Stop")) {
            if (this.play.getText().equals("Play")) {
                if (this.seconds == 0) {
                    showMessage(getResources().getString(R.string.please_record_audio));
                    return null;
                }
                MediaPlayer mediaPlayerCreate = MediaPlayer.create(this, Uri.parse(this.fileName));
                this.mediaPlayer = mediaPlayerCreate;
                mediaPlayerCreate.start();
                starttimer();
                return null;
            }
            if (!this.play.getText().equals("Pause")) {
                return null;
            }
            stoptimer();
            this.mediaPlayer.pause();
            return null;
        }
        showMessage(getResources().getString(R.string.you_can_not_play_the_audio_while_record));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$runTimer$32() {
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
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        audioManager.setMode(0);
        audioManager.setMicrophoneMute(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecording() {
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
            record.setText(getResources().getString(R.string.stop));
            startRecording();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$34(Boolean bool) {
        if (bool.booleanValue()) {
            this.moveToPermission = 1;
            pausePlayer();
            this.seconds = 0;
            this.running = true;
            startRecording();
            return;
        }
        Snackbar snackbarMake = Snackbar.make(findViewById(android.R.id.content), "Microphone permission is required", -1);
        snackbarMake.setAction("Enable", new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$33(view);
            }
        });
        snackbarMake.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$33(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(AnalyticsConstants.PACKAGE, getPackageName(), null));
        startActivity(intent);
    }

    private void startRecording() {
        try {
            enableMicroPhone();
            LinearLayout linearLayout = this.textLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.audioMainLL;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            this.fileName = getExternalCacheDir().getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + UUID.randomUUID().toString() + ".mp3";
            MediaRecorder mediaRecorder = new MediaRecorder();
            this.recorder = mediaRecorder;
            mediaRecorder.setAudioSource(1);
            this.recorder.setOutputFormat(6);
            this.recorder.setOutputFile(this.fileName);
            this.recorder.setAudioEncoder(3);
            this.recorder.prepare();
            this.recorder.start();
        } catch (IOException unused) {
            Log.d("VODPlayerActivity", "startRecording(): prepare() failed");
        } catch (Exception e2) {
            Log.d("VODPlayerActivity", "startRecording() Exception: " + e2.getMessage());
        }
    }

    public void starttimer() {
        if (this.timer == null) {
            Timer timer = new Timer();
            this.timer = timer;
            timer.schedule(new AnonymousClass25(), 0L, 1000L);
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$25, reason: invalid class name */
    class AnonymousClass25 extends TimerTask {
        AnonymousClass25() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (VODPlayerActivity.this.mediaPlayer == null || !VODPlayerActivity.this.mediaPlayer.isPlaying()) {
                    VODPlayerActivity.this.stoptimer();
                    VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$25$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$run$0();
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                VODPlayerActivity.this.stoptimer();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            VODPlayerActivity.this.pauseAudio.setImageResource(R.drawable.ic_baseline_play_arrow_24);
            VODPlayerActivity.this.isAudioPlaying = false;
        }
    }

    public void stoptimer() {
        try {
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.timer = null;
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private String generateurl(String input, String url) {
        String[] strArrSplit = url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        String str = "";
        for (int i = 0; i < strArrSplit.length; i++) {
            if (i == strArrSplit.length - 1) {
                str = str + MqttTopic.TOPIC_LEVEL_SEPARATOR + input.split("<BaseURL>")[1].replaceAll("</BaseURL>", "");
            } else if (i != 0) {
                str = str + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[i];
            } else {
                str = str + strArrSplit[i];
            }
        }
        return str;
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

    private void extractquality(final String url) {
        this.sparseAdaptiveVideoUrlList = new HashMap<>();
        this.sparseAdaptiveResolutionList = new ArrayList();
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda69
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$extractquality$36(url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractquality$36(String str) {
        List<String> list;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains("Representation")) {
                        for (String str2 : line.split(" ")) {
                            if (str2.contains(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                                this.sparseAdaptiveResolutionList.add(str2);
                            }
                        }
                    }
                    if (line.contains("BaseURL") && (list = this.sparseAdaptiveResolutionList) != null && list.size() > 0) {
                        this.sparseAdaptiveVideoUrlList.put(this.sparseAdaptiveResolutionList.get(r3.size() - 1), generateurl(line, str));
                    }
                } else {
                    runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda34
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$extractquality$35();
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
    public /* synthetic */ void lambda$extractquality$35() {
        List<String> list = this.sparseAdaptiveResolutionList;
        if (list != null) {
            list.size();
        }
    }

    private void extractquality2(final String url) {
        this.sparseAdaptiveVideoUrlList = new HashMap<>();
        this.sparseAdaptiveResolutionList = new ArrayList();
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$extractquality2$38(url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractquality2$38(String str) {
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
                    runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda35
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$extractquality2$37();
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
    public /* synthetic */ void lambda$extractquality2$37() {
        List<String> list = this.sparseAdaptiveResolutionList;
        if (list != null) {
            list.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blink() {
        try {
            this.floatingText.setVisibility(4);
            this.playerView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass26());
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$26, reason: invalid class name */
    class AnonymousClass26 implements ViewTreeObserver.OnPreDrawListener {
        AnonymousClass26() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            VODPlayerActivity.this.playerView.getViewTreeObserver().removeOnPreDrawListener(this);
            try {
                int measuredHeight = VODPlayerActivity.this.playerView.getMeasuredHeight();
                int measuredWidth = VODPlayerActivity.this.playerView.getMeasuredWidth();
                int iNextInt = 5;
                int iNextInt2 = (VODPlayerActivity.this.floatingText.getWidth() <= 0 || measuredWidth - VODPlayerActivity.this.floatingText.getWidth() <= 0) ? 5 : ThreadLocalRandom.current().nextInt(VODPlayerActivity.this.floatingText.getWidth(), measuredWidth - VODPlayerActivity.this.floatingText.getWidth());
                if (VODPlayerActivity.this.floatingText.getHeight() > 0 && measuredHeight - VODPlayerActivity.this.floatingText.getHeight() > 0) {
                    iNextInt = ThreadLocalRandom.current().nextInt(VODPlayerActivity.this.floatingText.getHeight(), measuredHeight - VODPlayerActivity.this.floatingText.getHeight());
                }
                if (VODPlayerActivity.this.floatingText.getWidth() + iNextInt2 > measuredWidth) {
                    VODPlayerActivity.this.floatingText.setX(iNextInt2 - VODPlayerActivity.this.floatingText.getWidth());
                } else {
                    VODPlayerActivity.this.floatingText.setX(iNextInt2);
                }
                if (VODPlayerActivity.this.floatingText.getHeight() + iNextInt > measuredHeight) {
                    VODPlayerActivity.this.floatingText.setY(iNextInt - VODPlayerActivity.this.floatingText.getHeight());
                } else {
                    VODPlayerActivity.this.floatingText.setY(iNextInt);
                }
            } catch (IllegalArgumentException unused) {
            }
            new Thread(new AnonymousClass1(new Handler())).start();
            return true;
        }

        /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$26$1, reason: invalid class name */
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
                this.val$handler.post(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.26.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VODPlayerActivity.this.floatingText.setVisibility(0);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.26.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                VODPlayerActivity.this.blink();
                            }
                        }, 3000L);
                    }
                });
            }
        }
    }

    private void hit_api_for_video_link() {
        String string = Settings.Secure.getString(getContentResolver(), "android_id");
        Log.d("TAGDRM", "DRM License Url: " + getDrmLicenseUrl());
        this.networkCall1 = VideoCrypt.getInstance(this).initialize(this, this.token, this.userId, string, BuildConfig.ACCOUNTID, BuildConfig.SecretKey, BuildConfig.AccessKey, this.timing, getDrmLicenseUrl());
    }

    private MediaSource buildMediaSource(Uri uri, String overrideExtension) {
        int iInferContentType = Util.inferContentType(uri, overrideExtension);
        if (iInferContentType == 0) {
            return new DashMediaSource.Factory(new DefaultDashChunkSource.Factory(this.mediaDataSourceFactory), buildDataSourceFactory()).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 1) {
            return new SsMediaSource.Factory(new DefaultSsChunkSource.Factory(this.mediaDataSourceFactory), buildDataSourceFactory()).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 2) {
            return new HlsMediaSource.Factory(this.mediaDataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
        }
        if (iInferContentType == 4) {
            return new ProgressiveMediaSource.Factory(this.mediaDataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
        }
        throw new IllegalStateException("Unsupported type: " + iInferContentType);
    }

    private void hit_api_for_meta() {
        this.networkCall.NetworkAPICall(API.get_meta, "", true, false);
    }

    private void checkStoragePermission() {
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.VODPlayerActivity.27
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                VODPlayerActivity.this.imgClick();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    private DataSource.Factory buildDataSourceFactory() {
        return new DefaultDataSource.Factory(this, buildHttpDataSourceFactory());
    }

    private HttpDataSource.Factory buildHttpDataSourceFactory() {
        return new DefaultHttpDataSource.Factory().setUserAgent(Util.getUserAgent(this, "ExoPlayerSample"));
    }

    private void setchat() {
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        setChatSettingUi(true);
        this.forDoubtll.setVisibility(8);
        this.unpublishtxt.setVisibility(8);
        this.refressDoubtRl.setVisibility(8);
        this.isclicked = "1";
        this.addBookmark.setVisibility(8);
        this.rl_pdf_data.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.chatAdapter = new ChatAdapter(this, "", this.arrChat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerChat.setLayoutManager(linearLayoutManager);
        this.recyclerChat.setAdapter(this.chatAdapter);
        disableAll();
        this.chatMainRl.setVisibility(0);
        this.createPollNestedScrollView.setVisibility(8);
        if (this.islocked.equalsIgnoreCase("1")) {
            this.linearLayout.setVisibility(0);
        } else if (this.islocked.equalsIgnoreCase("0")) {
            if (this.islockedback.equalsIgnoreCase("1")) {
                this.linearLayout.setVisibility(8);
                this.chatlayout.setVisibility(8);
            } else {
                this.linearLayout.setVisibility(0);
                this.chatlayout.setVisibility(0);
            }
        } else {
            this.linearLayout.setVisibility(8);
        }
        this.chatlayout.setVisibility(0);
        this.chat_btn.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        RelativeLayout relativeLayout = this.goToCurrentRl;
        if (relativeLayout != null) {
            relativeLayout.performClick();
        }
        this.llEnableMarkAsRead.setVisibility(8);
    }

    private void setNotes() {
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        this.refressDoubtRl.setVisibility(8);
        this.goToCurrentRl.setVisibility(8);
        setChatSettingUi(false);
        this.forDoubtll.setVisibility(8);
        this.unpublishtxt.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.isclicked = "4";
        this.linearLayout.setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.rl_pdf_data.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        setNotesAdapter();
        this.llEnableMarkAsRead.setVisibility(8);
    }

    private void setPoll() {
        this.isUserOnPoll = true;
        this.isUserOnDoubt = false;
        setChatSettingUi(false);
        this.forDoubtll.setVisibility(8);
        this.unpublishtxt.setVisibility(8);
        this.goToCurrentRl.setVisibility(8);
        this.refressDoubtRl.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.isclicked = "5";
        this.linearLayout.setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.rl_pdf_data.setVisibility(8);
        disableAll();
        if (this.isOperator) {
            this.addPoll.setVisibility(8);
            this.createPoll.setVisibility(0);
            this.generateLeaderboard.setVisibility((this.isFirebaseChat || !Helper.isGenerateLeaderboardEnabled()) ? 8 : 0);
        } else {
            this.addPoll.setVisibility(8);
            this.createPoll.setVisibility(8);
            this.generateLeaderboard.setVisibility(8);
        }
        this.recyclerChat.setVisibility(8);
        this.chatMainRl.setVisibility(8);
        this.createPollNestedScrollView.setVisibility(0);
        this.recylerViewPollOperator.setVisibility(0);
        this.viewLeaderboard.setVisibility((this.isFirebaseChat || this.pollarraylist.isEmpty() || !this.isShowViewAllLeaderBoard) ? 8 : 0);
        setpollAdapter();
        this.llEnableMarkAsRead.setVisibility(8);
    }

    private void setpollAdapter() {
        PollAdapter pollAdapter = new PollAdapter(this, this.pollarraylist);
        this.pollAdapter = pollAdapter;
        this.recylerViewPollOperator.setAdapter(pollAdapter);
    }

    private void fireBaseOperation() {
        try {
            this.mFirebaseDatabaseReferenceone2many = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
            this.mFirebaseDatabaseReferenceone2one = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
            this.mFirebaseDatabaseReferenceChatLocked = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/User/" + MakeMyExam.userId);
            this.mFirebaseDatabaseReferencePollAdded = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll");
            ValueEventListener valueEventListener = new ValueEventListener() { // from class: com.appnew.android.player.VODPlayerActivity.28
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot != null) {
                        try {
                            if (dataSnapshot.getValue() != null) {
                                OnlineUser onlineUser = (OnlineUser) dataSnapshot.getValue(OnlineUser.class);
                                if (!TextUtils.isEmpty(onlineUser.getIs_chat_locked()) && onlineUser.getIs_chat_locked().equalsIgnoreCase("1")) {
                                    VODPlayerActivity.this.islocked = "2";
                                    VODPlayerActivity.this.hidechat();
                                } else {
                                    VODPlayerActivity.this.islocked = "1";
                                    VODPlayerActivity.this.showchat();
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            };
            this.chatvalueEventListener = valueEventListener;
            this.mFirebaseDatabaseReferenceChatLocked.addValueEventListener(valueEventListener);
            AnonymousClass29 anonymousClass29 = new AnonymousClass29();
            this.pollAddedEventListener = anonymousClass29;
            this.mFirebaseDatabaseReferencePollAdded.addValueEventListener(anonymousClass29);
            if (this.isPublicChatEnabled) {
                AnonymousClass30 anonymousClass30 = new AnonymousClass30();
                this.onetomanyvalueEventListener = anonymousClass30;
                this.mFirebaseDatabaseReferenceone2many.addListenerForSingleValueEvent(anonymousClass30);
                this.mFirebaseDatabaseReferenceone2many.limitToLast(500);
            } else {
                AnonymousClass31 anonymousClass31 = new AnonymousClass31();
                this.valueEventListener = anonymousClass31;
                this.mFirebaseDatabaseReferenceone2one.addListenerForSingleValueEvent(anonymousClass31);
                this.mFirebaseDatabaseReferenceone2one.limitToLast(500);
            }
            setSendListener();
            this.arrChat.clear();
            this.chatAdapter = new ChatAdapter(this, "", this.arrChat);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setAutoMeasureEnabled(false);
            this.recyclerChat.setLayoutManager(linearLayoutManager);
            this.recyclerChat.setAdapter(this.chatAdapter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$29, reason: invalid class name */
    class AnonymousClass29 implements ValueEventListener {
        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
        }

        AnonymousClass29() {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(final DataSnapshot dataSnapshot) {
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$29$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDataChange$2(dataSnapshot);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$2(DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue() == null) {
                return;
            }
            Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
            while (it.hasNext()) {
                chatPojo chatpojo = (chatPojo) it.next().getValue(chatPojo.class);
                if (!TextUtils.isEmpty(chatpojo.getType()) && chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                    if (chatpojo.getIs_active().equalsIgnoreCase("2")) {
                        for (int i = 0; i < VODPlayerActivity.this.pollarraylist.size(); i++) {
                            if (VODPlayerActivity.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(chatpojo.getFirebase_id())) {
                                VODPlayerActivity.this.pollarraylist.get(i).setStatus("2");
                                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$29$$ExternalSyntheticLambda1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$onDataChange$0();
                                    }
                                });
                            }
                        }
                    } else {
                        VODPlayerActivity.this.getpolldatawithid(chatpojo.getFirebase_id());
                    }
                }
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$29$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDataChange$1();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$0() {
            if (VODPlayerActivity.this.pollAdapter != null) {
                VODPlayerActivity.this.pollAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$1() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            if (VODPlayerActivity.this.chatAdapter != null) {
                VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$30, reason: invalid class name */
    class AnonymousClass30 implements ValueEventListener {
        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
        }

        AnonymousClass30() {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(final DataSnapshot dataSnapshot) {
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$30$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDataChange$2(dataSnapshot);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$2(DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue() == null) {
                VODPlayerActivity.this.checkstatus = "1";
                VODPlayerActivity.this.onetomanygetupdatedchatdata(MakeMyExam.getTime_server());
                return;
            }
            try {
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    chatPojo chatpojo = (chatPojo) dataSnapshot2.getValue(chatPojo.class);
                    if (!chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                        VODPlayerActivity.this.addOrUpdateItem(chatpojo);
                        VODPlayerActivity.this.pollarr.add(chatpojo);
                        VODPlayerActivity.this.keyset.add(dataSnapshot2.getKey());
                    } else {
                        if (chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                            VODPlayerActivity.this.lockarr.add(chatpojo);
                        }
                        VODPlayerActivity.this.pollarr.add(chatpojo);
                    }
                    VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$30$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onDataChange$0();
                        }
                    });
                }
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$30$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDataChange$1();
                    }
                });
                VODPlayerActivity.this.checkstatus = "1";
                VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                vODPlayerActivity.onetomanygetupdatedchatdata(vODPlayerActivity.pollarr.get(VODPlayerActivity.this.pollarr.size() - 1).getDate());
            } catch (Exception unused) {
                VODPlayerActivity.this.showMessage("null pointer exception");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$0() {
            if (VODPlayerActivity.this.isUserScrolled || VODPlayerActivity.this.chatAdapter == null) {
                return;
            }
            VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$1() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$31, reason: invalid class name */
    class AnonymousClass31 implements ValueEventListener {
        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
        }

        AnonymousClass31() {
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(final DataSnapshot dataSnapshot) {
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$31$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDataChange$2(dataSnapshot);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$2(DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue() == null) {
                VODPlayerActivity.this.checkstatus = "1";
                VODPlayerActivity.this.getupdatedchatdata(System.currentTimeMillis());
                return;
            }
            try {
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    chatPojo chatpojo = (chatPojo) dataSnapshot2.getValue(chatPojo.class);
                    if (!chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                        VODPlayerActivity.this.addOrUpdateItem(chatpojo);
                        VODPlayerActivity.this.pollarr.add(chatpojo);
                        VODPlayerActivity.this.keyset.add(dataSnapshot2.getKey());
                    } else {
                        if (chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                            VODPlayerActivity.this.lockarr.add(chatpojo);
                        }
                        VODPlayerActivity.this.pollarr.add(chatpojo);
                    }
                    VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$31$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onDataChange$0();
                        }
                    });
                }
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$31$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDataChange$1();
                    }
                });
                VODPlayerActivity.this.checkstatus = "1";
                VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                vODPlayerActivity.getupdatedchatdata(vODPlayerActivity.pollarr.get(VODPlayerActivity.this.pollarr.size() - 1).getDate());
            } catch (Exception unused) {
                VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                vODPlayerActivity2.showMessage(vODPlayerActivity2.getResources().getString(R.string.null_pointer_exception));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$0() {
            if (VODPlayerActivity.this.isUserScrolled || VODPlayerActivity.this.chatAdapter == null) {
                return;
            }
            VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$1() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }
    }

    private void setSendListener() {
        this.loveImage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VODPlayerActivity.this.openEmojiPopup();
            }
        });
        this.ivSend.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (Helper.isConnected(VODPlayerActivity.this)) {
                        if (!VODPlayerActivity.this.etMessage.getText().toString().trim().equals("")) {
                            if (!VODPlayerActivity.this.isintractavailable) {
                                VODPlayerActivity.this.checkintract();
                            }
                            if (Helper.IsValidUrl(VODPlayerActivity.this.etMessage.getText().toString().trim())) {
                                if (VODPlayerActivity.this.isFirebaseChat) {
                                    chatPojo chatpojo = new chatPojo(MakeMyExam.userId, VODPlayerActivity.this.etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "url", VODPlayerActivity.this.courseid);
                                    VODPlayerActivity.this.mFirebaseDatabaseReferenceone2one.push().setValue(chatpojo);
                                    VODPlayerActivity.this.mFirebaseDatabaseReferenceone2many.push().setValue(chatpojo);
                                } else {
                                    VODPlayerActivity.this.sendMessage(new Gson().toJson(new chatPojo(MakeMyExam.userId, VODPlayerActivity.this.etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", "url", VODPlayerActivity.this.courseid)), false);
                                }
                            } else if (VODPlayerActivity.this.isFirebaseChat) {
                                chatPojo chatpojo2 = new chatPojo(MakeMyExam.userId, VODPlayerActivity.this.etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "text", VODPlayerActivity.this.courseid);
                                VODPlayerActivity.this.mFirebaseDatabaseReferenceone2one.push().setValue(chatpojo2);
                                VODPlayerActivity.this.mFirebaseDatabaseReferenceone2many.push().setValue(chatpojo2);
                            } else {
                                VODPlayerActivity.this.sendMessage(new Gson().toJson(new chatPojo(MakeMyExam.userId, VODPlayerActivity.this.etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", "text", VODPlayerActivity.this.courseid)), false);
                            }
                            Helper.closeHideKeyboard(VODPlayerActivity.this);
                            VODPlayerActivity.this.enableDisableMsgET();
                            return;
                        }
                        Helper.showSnackBar(VODPlayerActivity.this.ivSend, "Please enter your query first.");
                        return;
                    }
                    Helper.showSnackBar(VODPlayerActivity.this.ivSend, "Please connect internet first.");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void onetomanygetupdatedchatdata(long actualdate) {
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
        this.onetomanyrootRef = databaseReferenceChild;
        this.onetomantquery = databaseReferenceChild.orderByChild("date").startAt(actualdate);
        AnonymousClass34 anonymousClass34 = new AnonymousClass34();
        this.onetomanychildEventListener = anonymousClass34;
        this.onetomantquery.addChildEventListener(anonymousClass34);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$34, reason: invalid class name */
    class AnonymousClass34 implements ChildEventListener {
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

        AnonymousClass34() {
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            if (VODPlayerActivity.this.checkstatus.equalsIgnoreCase("1")) {
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$34$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onChildAdded$2();
                    }
                });
                try {
                    chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                    if (chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                        if (VODPlayerActivity.this.pollarraylist.size() == 0) {
                            VODPlayerActivity.this.getpolldatawithid(chatpojo.getFirebase_id());
                        }
                    } else if (VODPlayerActivity.this.arrChat.size() == 0) {
                        VODPlayerActivity.this.addOrUpdateItem(chatpojo);
                        VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$34$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onChildAdded$3();
                            }
                        });
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                VODPlayerActivity.this.checkstatus = "0";
                return;
            }
            if (dataSnapshot == null) {
                return;
            }
            try {
                chatPojo chatpojo2 = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                if (chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                    if (chatpojo2.getIs_active().equalsIgnoreCase("2")) {
                        for (int i = 0; i < VODPlayerActivity.this.pollarraylist.size(); i++) {
                            if (VODPlayerActivity.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(chatpojo2.getFirebase_id())) {
                                VODPlayerActivity.this.pollarraylist.get(i).setStatus("2");
                                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$34$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$onChildAdded$0();
                                    }
                                });
                            }
                        }
                    } else {
                        VODPlayerActivity.this.getpolldatawithid(chatpojo2.getFirebase_id());
                    }
                } else if (!chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo2.getType().equalsIgnoreCase("is_chat_locked")) {
                    VODPlayerActivity.this.addOrUpdateItem(chatpojo2);
                }
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$34$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onChildAdded$1();
                    }
                });
            } catch (Exception unused) {
                VODPlayerActivity.this.showMessage("null pointer exception");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildAdded$0() {
            if (VODPlayerActivity.this.pollAdapter != null) {
                VODPlayerActivity.this.pollAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildAdded$1() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            if (VODPlayerActivity.this.chatAdapter != null) {
                VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildAdded$2() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            if (VODPlayerActivity.this.chatAdapter != null) {
                VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildAdded$3() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            if (VODPlayerActivity.this.chatAdapter != null) {
                VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }
    }

    public void getupdatedchatdata(long actualdate) {
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        this.rootRef = databaseReferenceChild;
        this.query = databaseReferenceChild.orderByChild("date").startAt(actualdate);
        AnonymousClass35 anonymousClass35 = new AnonymousClass35();
        this.childEventListener = anonymousClass35;
        this.query.addChildEventListener(anonymousClass35);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$35, reason: invalid class name */
    class AnonymousClass35 implements ChildEventListener {
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

        AnonymousClass35() {
        }

        @Override // com.google.firebase.database.ChildEventListener
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            if (VODPlayerActivity.this.checkstatus.equalsIgnoreCase("1")) {
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$35$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onChildAdded$2();
                    }
                });
                try {
                    chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                    if (chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                        if (VODPlayerActivity.this.pollarraylist.size() == 0) {
                            VODPlayerActivity.this.getpolldatawithid(chatpojo.getFirebase_id());
                        }
                    } else if (VODPlayerActivity.this.arrChat.size() == 0) {
                        VODPlayerActivity.this.addOrUpdateItem(chatpojo);
                        VODPlayerActivity.this.keyset.add(dataSnapshot.getKey());
                        VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$35$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onChildAdded$3();
                            }
                        });
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                VODPlayerActivity.this.checkstatus = "0";
                return;
            }
            if (dataSnapshot == null) {
                return;
            }
            try {
                chatPojo chatpojo2 = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                if (chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                    if (chatpojo2.getIs_active().equalsIgnoreCase("2")) {
                        for (int i = 0; i < VODPlayerActivity.this.pollarraylist.size(); i++) {
                            if (VODPlayerActivity.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(chatpojo2.getFirebase_id())) {
                                VODPlayerActivity.this.pollarraylist.get(i).setStatus("2");
                                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$35$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$onChildAdded$0();
                                    }
                                });
                            }
                        }
                    } else {
                        VODPlayerActivity.this.getpolldatawithid(chatpojo2.getFirebase_id());
                    }
                } else if (!chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo2.getType().equalsIgnoreCase("is_chat_locked")) {
                    VODPlayerActivity.this.addOrUpdateItem(chatpojo2);
                    VODPlayerActivity.this.keyset.add(dataSnapshot.getKey());
                }
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$35$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onChildAdded$1();
                    }
                });
            } catch (Exception unused) {
                VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                vODPlayerActivity.showMessage(vODPlayerActivity.getResources().getString(R.string.null_pointer_exception));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildAdded$0() {
            if (VODPlayerActivity.this.pollAdapter != null) {
                VODPlayerActivity.this.pollAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildAdded$1() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            if (VODPlayerActivity.this.chatAdapter != null) {
                VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildAdded$2() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            if (VODPlayerActivity.this.chatAdapter != null) {
                VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildAdded$3() {
            if (VODPlayerActivity.this.isUserScrolled) {
                return;
            }
            if (VODPlayerActivity.this.chatAdapter != null) {
                VODPlayerActivity.this.chatAdapter.notifyDataSetChanged();
            }
            VODPlayerActivity.this.recyclerChat.smoothScrollToPosition(VODPlayerActivity.this.arrChat.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkintract() {
        DatabaseReference databaseReference = this.mFirebaseDatabaseReference1;
        if (databaseReference != null) {
            try {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.VODPlayerActivity.36
                    @Override // com.google.firebase.database.ValueEventListener
                    public void onCancelled(DatabaseError databaseError) {
                    }

                    @Override // com.google.firebase.database.ValueEventListener
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        try {
                            if (dataSnapshot.getValue() != null) {
                                OnlineUser onlineUser = (OnlineUser) dataSnapshot.getValue(OnlineUser.class);
                                VODPlayerActivity.this.isintractavailable = true;
                                if (((OnlineUser) Objects.requireNonNull(onlineUser)).getInteract() == null) {
                                    VODPlayerActivity.this.mFirebaseDatabaseReference1.child("interact").setValue("1");
                                } else if (onlineUser.getInteract().equalsIgnoreCase("0")) {
                                    VODPlayerActivity.this.mFirebaseDatabaseReference1.child("interact").setValue("1");
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOrUpdateItem(final chatPojo newItem) {
        try {
            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda48
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addOrUpdateItem$39(newItem);
                }
            });
        } catch (Exception e2) {
            Log.d("MQTT", "addOrUpdateItem: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addOrUpdateItem$39(chatPojo chatpojo) {
        ArrayList<chatPojo> arrayList = this.arrChat;
        if (arrayList != null && !arrayList.isEmpty() && this.arrChat.size() >= 100) {
            this.arrChat.remove(0);
        }
        ArrayList<chatPojo> arrayList2 = this.arrChat;
        if (arrayList2 != null) {
            arrayList2.add(chatpojo);
        }
    }

    public void getpolldatawithid(String randomid) {
        this.mFirebaseDatabaseReferencepolldata = null;
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + randomid);
        this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
        databaseReferenceChild.addListenerForSingleValueEvent(new AnonymousClass37(randomid));
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$37, reason: invalid class name */
    class AnonymousClass37 implements ValueEventListener {
        final /* synthetic */ String val$randomid;

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
        }

        AnonymousClass37(final String val$randomid) {
            this.val$randomid = val$randomid;
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot == null) {
                return;
            }
            Polldata polldata = (Polldata) new Gson().fromJson(new Gson().toJson(dataSnapshot.getValue()), Polldata.class);
            for (int i = 0; i < VODPlayerActivity.this.pollarraylist.size(); i++) {
                if (VODPlayerActivity.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(this.val$randomid)) {
                    VODPlayerActivity.this.pollarraylist.get(i).setStatus("1");
                    VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$37$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onDataChange$0();
                        }
                    });
                    return;
                }
            }
            try {
                if (Long.parseLong(polldata.getDelay()) > 0 && Long.parseLong(polldata.getDelay()) - (System.currentTimeMillis() / 1000) > 0) {
                    VODPlayerActivity.this.runOnUiThread(new AnonymousClass1(Long.parseLong(polldata.getDelay()) - (System.currentTimeMillis() / 1000), polldata));
                    return;
                }
                String str = this.val$randomid;
                if (str != null) {
                    polldata.setRendomkey(str);
                    polldata.setStatus("1");
                    Snackbar.make(VODPlayerActivity.this.rootView.getRootView(), VODPlayerActivity.this.getResources().getString(R.string.new_poll_added), -1).show();
                    ((Polldata) Objects.requireNonNull(polldata)).setMyAnswer("0");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(0, polldata);
                    arrayList.addAll(VODPlayerActivity.this.pollarraylist);
                    VODPlayerActivity.this.pollarraylist.clear();
                    VODPlayerActivity.this.pollarraylist.addAll(arrayList);
                    VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$37$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onDataChange$1();
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$0() {
            if (VODPlayerActivity.this.pollAdapter != null) {
                VODPlayerActivity.this.pollAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$37$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ Polldata val$polldata;
            final /* synthetic */ long val$timer;

            AnonymousClass1(final long val$timer, final Polldata val$polldata) {
                this.val$timer = val$timer;
                this.val$polldata = val$polldata;
            }

            /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$37$1$1, reason: invalid class name and collision with other inner class name */
            class CountDownTimerC01231 extends CountDownTimer {
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                }

                CountDownTimerC01231(long millisInFuture, long countDownInterval) {
                    super(millisInFuture, countDownInterval);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AnonymousClass37.this.val$randomid != null) {
                        AnonymousClass1.this.val$polldata.setRendomkey(AnonymousClass37.this.val$randomid);
                        AnonymousClass1.this.val$polldata.setStatus("1");
                        VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.37.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Snackbar.make(VODPlayerActivity.this.rootView.getRootView(), "New Poll Added", -1).show();
                            }
                        });
                        AnonymousClass1.this.val$polldata.setMyAnswer("0");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(0, AnonymousClass1.this.val$polldata);
                        arrayList.addAll(VODPlayerActivity.this.pollarraylist);
                        VODPlayerActivity.this.pollarraylist.clear();
                        VODPlayerActivity.this.pollarraylist.addAll(arrayList);
                        VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$37$1$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onFinish$0();
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onFinish$0() {
                    if (VODPlayerActivity.this.pollAdapter != null) {
                        VODPlayerActivity.this.pollAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                new CountDownTimerC01231(this.val$timer * 1000, 1000L).start();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDataChange$1() {
            if (VODPlayerActivity.this.pollAdapter != null) {
                VODPlayerActivity.this.pollAdapter.notifyDataSetChanged();
            }
        }
    }

    public void showDialog(View view) {
        if (Helper.isNetworkConnected(this)) {
            if (this.player != null) {
                pausePlayer();
                this.isActivityLive = false;
                final String str = formattedTime(this.player.getCurrentPosition());
                final Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
                dialog.requestWindowFeature(1);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.add_book_dialog);
                ((TextView) dialog.findViewById(R.id.text_dialog_time)).setText(getResources().getString(R.string.time_) + str);
                final EditText editText = (EditText) dialog.findViewById(R.id.nameTV);
                dialog.findViewById(R.id.btn_dialog_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.38
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        dialog.dismiss();
                        if (VODPlayerActivity.this.player == null || VODPlayerActivity.this.player.getPlaybackState() != 3) {
                            return;
                        }
                        VODPlayerActivity.this.player.setPlayWhenReady(true);
                    }
                });
                dialog.findViewById(R.id.btn_dialog_submit).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.39
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        String string = editText.getText().toString();
                        if (string.length() > 0) {
                            dialog.dismiss();
                            Helper.hideSoftKeyboard(VODPlayerActivity.this);
                            VODPlayerActivity.this.BookMarkApi("", str, string, "1");
                        } else {
                            VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                            vODPlayerActivity.showMessage(vODPlayerActivity.getResources().getString(R.string.add_title));
                        }
                    }
                });
                dialog.show();
                return;
            }
            showMessage(getResources().getString(R.string.player_is_not_initialized_yet));
            return;
        }
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BookMarkApi(String id, String time, String info2, final String state) {
        this.time = time;
        this.f329info = info2;
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
            if (Build.VERSION.SDK_INT == 36) {
                EdgeToEdgeHelperOld.applyInsetsNew(this, getWindow(), findViewById(R.id.mainRoot), false, null);
            }
            Helper.hideSoftKeyboard(this);
            Helper.closeKeyboard(this);
            boolean z = true;
            if (newConfig.orientation == 1) {
                this.mExoPlayerFullscreen = false;
                if (Helper.isShowMarkAsDone(this.videotype) && this.isclicked == "2") {
                    this.llEnableMarkAsRead.setVisibility(0);
                } else {
                    this.llEnableMarkAsRead.setVisibility(8);
                }
                this.fullscreen.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
                this.llll.setVisibility(0);
                this.video_name_text.setVisibility(0);
                if (this.isclicked.equalsIgnoreCase("1")) {
                    if (this.lockarr.size() > 0) {
                        if (this.islocked.equalsIgnoreCase("1")) {
                            if (!this.isPinChat) {
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
                        if (!this.isPinChat) {
                            this.linearLayout.setVisibility(0);
                        }
                        this.chatlayout.setVisibility(0);
                    }
                }
                if (this.isclicked.equalsIgnoreCase("2")) {
                    if (!this.isPinChat) {
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
                if (dialog != null && dialog.isShowing()) {
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
                ArrayList<Polldata> arrayList = this.pollarraylist;
                if (arrayList != null && !arrayList.isEmpty()) {
                    this.landscapePollDialog.showPollIndicator(this.pollarraylist.get(0), false);
                    return;
                } else {
                    this.landscapePollDialog.showPollIndicator(this.pollarraylist.get(0), false);
                    return;
                }
            }
            this.llEnableMarkAsRead.setVisibility(8);
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
            if (dialog2 != null && dialog2.isShowing()) {
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
            }
            ArrayList<Polldata> arrayList2 = this.pollarraylist;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                this.landscapePollDialog.showPollIndicator(this.pollarraylist.get(0), true);
            } else {
                this.landscapePollDialog.showPollIndicator(this.pollarraylist.get(0), false);
            }
            PollAdapter pollAdapter = this.pollAdapter;
            if (pollAdapter == null || pollAdapter.watchlist == null || !this.pollAdapter.watchlist.isShowing()) {
                return;
            }
            this.pollAdapter.watchlist.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
            Helper.hideSoftKeyboard(this);
        }
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

    private void setUserOnline() {
        this.mFirebaseDatabaseReference1 = null;
        try {
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/").child(this.Chat_node).child("User").child(MakeMyExam.userId);
            this.mFirebaseDatabaseReference1 = databaseReferenceChild;
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.VODPlayerActivity.40
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() == null) {
                        VODPlayerActivity.this.mFirebaseDatabaseReference1.setValue(new OnlineUser(SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "true", MakeMyExam.userId, SharedPreference.getInstance().getLoggedInUser().getMobile(), "0", System.currentTimeMillis()));
                    } else {
                        VODPlayerActivity.this.mFirebaseDatabaseReference1.child("online").setValue("true");
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
        String file = images.get(0).getFile();
        if (file != null && file.contains(".pdf")) {
            str = Const.PDF;
        } else if (file != null && file.contains(".mp3")) {
            str = "audio";
        } else {
            str = "image";
        }
        String str2 = str;
        try {
            Helper.closeHideKeyboard(this);
            if (file != null && !file.trim().isEmpty()) {
                if (!this.isintractavailable) {
                    checkintract();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.isFirebaseChat) {
                    chatPojo chatpojo = new chatPojo(MakeMyExam.userId, file, SharedPreference.getInstance().getLoggedInUser().getName(), jCurrentTimeMillis, "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", str2, this.courseid);
                    this.mFirebaseDatabaseReferenceone2one.push().setValue(chatpojo);
                    this.mFirebaseDatabaseReferenceone2many.push().setValue(chatpojo);
                    return;
                }
                chatPojo chatpojo2 = new chatPojo(MakeMyExam.userId, file, SharedPreference.getInstance().getLoggedInUser().getName(), jCurrentTimeMillis, "1", str2, this.courseid);
                sendMessage(new Gson().toJson(chatpojo2), false);
                this.arrChat.add(chatpojo2);
                ChatAdapter chatAdapter = this.chatAdapter;
                if (chatAdapter != null) {
                    chatAdapter.notifyItemInserted(this.arrChat.size() - 1);
                }
                RecyclerView recyclerView = this.recyclerChat;
                if (recyclerView != null) {
                    recyclerView.smoothScrollToPosition(this.arrChat.size() - 1);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        int i;
        String strEncrypt;
        apitype.hashCode();
        i = 0;
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/course/post_course_review":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setCourse_id(this.video_id);
                encryptionData.setRating(this.rating);
                encryptionData.setMessage(this.ratingMessage);
                encryptionData.setRating_type(Integer.valueOf(this.ratingType));
                return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/poll/delete_video_index":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setIndex_id(this.deletedindex);
                return service.deletevideoindex(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/poll/create_poll":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setOption_1(this.optionList.get(0).getAnswer());
                encryptionData3.setOption_2(this.optionList.get(1).getAnswer());
                this.pollOption1 = this.optionList.get(0).getAnswer();
                this.pollOption2 = this.optionList.get(1).getAnswer();
                int size = this.optionList.size();
                if (size == 3) {
                    encryptionData3.setOption_3(this.optionList.get(2).getAnswer());
                    this.pollOption3 = this.optionList.get(2).getAnswer();
                } else if (size == 4) {
                    encryptionData3.setOption_3(this.optionList.get(2).getAnswer());
                    encryptionData3.setOption_4(this.optionList.get(3).getAnswer());
                    this.pollOption3 = this.optionList.get(2).getAnswer();
                    this.pollOption4 = this.optionList.get(3).getAnswer();
                } else if (size == 5) {
                    encryptionData3.setOption_3(this.optionList.get(2).getAnswer());
                    encryptionData3.setOption_4(this.optionList.get(3).getAnswer());
                    encryptionData3.setOption_5(this.optionList.get(4).getAnswer());
                    this.pollOption3 = this.optionList.get(2).getAnswer();
                    this.pollOption4 = this.optionList.get(3).getAnswer();
                    this.pollOption5 = this.optionList.get(4).getAnswer();
                } else if (size == 6) {
                    encryptionData3.setOption_3(this.optionList.get(2).getAnswer());
                    encryptionData3.setOption_4(this.optionList.get(3).getAnswer());
                    encryptionData3.setOption_5(this.optionList.get(4).getAnswer());
                    encryptionData3.setOption_6(this.optionList.get(5).getAnswer());
                    this.pollOption3 = this.optionList.get(2).getAnswer();
                    this.pollOption4 = this.optionList.get(3).getAnswer();
                    this.pollOption5 = this.optionList.get(4).getAnswer();
                    this.pollOption6 = this.optionList.get(5).getAnswer();
                }
                encryptionData3.setQuestion(this.enterQuestionET.getText().toString());
                encryptionData3.setDelay(this.enterDelayET.getText().toString());
                String string = this.enterTimeET.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    String[] strArrSplit = string.split(" ");
                    if (strArrSplit.length > 0) {
                        encryptionData3.setValidity(String.valueOf(Integer.parseInt(strArrSplit[0])));
                        this.pollValidity = String.valueOf(Integer.parseInt(strArrSplit[0]));
                    }
                }
                encryptionData3.setVideo_id(this.video_id);
                while (true) {
                    if (i < this.optionList.size()) {
                        if (this.optionList.get(i).isThisAnswerRight()) {
                            int i2 = i + 1;
                            encryptionData3.setAnswer(String.valueOf(i2));
                            this.pollAnswer = String.valueOf(i2);
                        } else {
                            i++;
                        }
                    }
                }
                return service.createPoll(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/poll/add_video_index":
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setVideo_id(this.video_id);
                encryptionData4.setTime(this.time);
                encryptionData4.setInfo(this.f329info);
                return service.addvideoindex(AES.encrypt(new Gson().toJson(encryptionData4)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/user_video_view_data":
                if (this.localapi) {
                    HashMap<String, String> hashMapdata = SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW);
                    EncryptionData encryptionData5 = new EncryptionData();
                    encryptionData5.setUser_id(MakeMyExam.getUserId());
                    encryptionData5.setVideo_id(hashMapdata.get(Const.VIDEO_ID));
                    encryptionData5.setTile_id(hashMapdata.get("tile_id"));
                    encryptionData5.setCourse_id(hashMapdata.get("course_id"));
                    encryptionData5.setType(hashMapdata.get(Const.VIDEO_TYPE));
                    encryptionData5.setStart_time(hashMapdata.get(Const.StartTime));
                    encryptionData5.setTotal_time(hashMapdata.get(Const.TOTAL_TIME));
                    encryptionData5.setPlatform(hashMapdata.get("platform"));
                    encryptionData5.setRemaining_time(hashMapdata.get(Const.remaining_time));
                    encryptionData5.setEnd_time(hashMapdata.get(Const.ENDTime));
                    encryptionData5.setStart_time(hashMapdata.get(Const.StartTime));
                    encryptionData5.setView_time(hashMapdata.get(Const.VIEW_TIME));
                    strEncrypt = AES.encrypt(new Gson().toJson(encryptionData5));
                } else {
                    this.endtime = System.currentTimeMillis();
                    EncryptionData encryptionData6 = new EncryptionData();
                    encryptionData6.setUser_id(MakeMyExam.getUserId());
                    encryptionData6.setVideo_id(this.video_id);
                    encryptionData6.setCourse_id(this.courseid);
                    encryptionData6.setTile_id(TextUtils.isEmpty(this.tileid) ? "0" : this.tileid);
                    encryptionData6.setType(this.videotype);
                    encryptionData6.setTotal_time(this.totalTime);
                    encryptionData6.setPlatform("android");
                    encryptionData6.setRemaining_time(this.is_limited.equalsIgnoreCase("1") ? String.valueOf(this.totalRemainingtime / 1000) : "0");
                    encryptionData6.setEnd_time(String.valueOf(this.endtime));
                    encryptionData6.setStart_time(String.valueOf(this.starttime));
                    encryptionData6.setView_time(String.valueOf(this.is_limited.equalsIgnoreCase("1") ? ((long) Float.parseFloat(this.remainingtime.split("_")[0])) - (this.totalRemainingtime / 1000) : (this.endtime - Long.parseLong(this.starttime)) / 1000));
                    strEncrypt = AES.encrypt(new Gson().toJson(encryptionData6));
                }
                return service.user_video_view_data(strEncrypt);
            case "https://appapi.videocrypt.in/index.php/data_model/poll/get_content_meta":
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setUser_id(MakeMyExam.getUserId());
                encryptionData7.setToken(this.video_id);
                encryptionData7.setCourse_id(this.courseid);
                return service.getmetaData(AES.encrypt(new Gson().toJson(encryptionData7)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/update_video_view_time":
                EncryptionData encryptionData8 = new EncryptionData();
                encryptionData8.setUser_id(MakeMyExam.getUserId());
                encryptionData8.setVideo_id(this.video_id);
                encryptionData8.setCourse_id(this.courseid);
                encryptionData8.setStart_time(this.starttime);
                encryptionData8.setTile_id(this.tileid);
                encryptionData8.setType(this.videotype);
                encryptionData8.setTotal_time(this.totalTime);
                encryptionData8.setView_time(String.valueOf(((long) Float.parseFloat(this.remainingtime.split("_")[0])) - (this.totalRemainingtime / 1000)));
                return service.update_video_view_time(AES.encrypt(new Gson().toJson(encryptionData8)));
            case "https://appapi.videocrypt.in/index.php/data_model/master_hit/video_markread":
                EncryptionData encryptionData9 = new EncryptionData();
                encryptionData9.setVideo_id(this.video_id);
                encryptionData9.setCourse_id(this.courseid);
                return service.markReadVideoType1_7(AES.encrypt(new Gson().toJson(encryptionData9)));
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source":
                EncryptionData encryptionData10 = new EncryptionData();
                encryptionData10.setName(this.video_id + "_0_0");
                encryptionData10.setCourse_id(this.courseid);
                encryptionData10.setTile_id(this.tileid);
                encryptionData10.setType(this.tiletype);
                return service.getVideoLink(AES.encrypt(new Gson().toJson(encryptionData10)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/create_bookmark":
                EncryptionData encryptionData11 = new EncryptionData();
                encryptionData11.setContent_id(this.video_id);
                encryptionData11.setIs_unbookmarked(this.bookmarkState);
                encryptionData11.setContent_type("3");
                return service.addPdfBookMark(AES.encrypt(new Gson().toJson(encryptionData11)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/video_logging":
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.endtime = jCurrentTimeMillis;
                long j = (jCurrentTimeMillis - this.currentTime) / 1000;
                EncryptionData encryptionData12 = new EncryptionData();
                encryptionData12.setVideo_id(this.video_id);
                encryptionData12.setEnd_time(String.valueOf(j));
                return service.get_video_logging(AES.encrypt(new Gson().toJson(encryptionData12)));
            default:
                return null;
        }
    }

    public void createPollDataWithId(String randomid, String pollId, JSONObject jsonstring) {
        this.mFirebaseDatabaseReferencepolldata = null;
        this.mFirebaseDatabaseReferencepolldata = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + randomid);
        this.mFirebaseDatabaseReferenceone2many = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        this.mFirebaseDatabaseReferenceone2one = databaseReferenceChild;
        databaseReferenceChild.push().getKey();
        if (this.mFirebaseDatabaseReferencePollAdded == null) {
            this.mFirebaseDatabaseReferencePollAdded = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll");
        }
        if (this.modeOfPoll.equalsIgnoreCase("1")) {
            this.pollAnswer = "0";
        }
        chatPojo chatpojo = new chatPojo(MakeMyExam.userId, "", SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", Polling.EVENT_POLL, this.courseid);
        chatpojo.setFirebase_id(randomid);
        this.mFirebaseDatabaseReferencePollAdded.push().setValue(chatpojo);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:290:0x06f4  */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void SuccessCallBack(org.json.JSONObject r24, java.lang.String r25, java.lang.String r26, boolean r27) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 2398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.VODPlayerActivity.SuccessCallBack(org.json.JSONObject, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$40() {
        this.createPollNestedScrollView.smoothScrollTo(0, 0);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        try {
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

    private void setvodchat() {
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        setChatSettingUi(true);
        this.forDoubtll.setVisibility(8);
        this.unpublishtxt.setVisibility(8);
        this.refressDoubtRl.setVisibility(8);
        this.isclicked = "6";
        this.addBookmark.setVisibility(8);
        this.rl_pdf_data.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.chatAdapter = new ChatAdapter(this, "", this.arrChat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerChat.setLayoutManager(linearLayoutManager);
        this.recyclerChat.setAdapter(this.chatAdapter);
        disableAll();
        if (this.islocked.equalsIgnoreCase("1")) {
            this.linearLayout.setVisibility(0);
        } else if (this.islocked.equalsIgnoreCase("0")) {
            if (this.islockedback.equalsIgnoreCase("1")) {
                this.linearLayout.setVisibility(8);
                this.chatlayout.setVisibility(8);
            } else {
                this.linearLayout.setVisibility(0);
                this.chatlayout.setVisibility(0);
            }
        } else {
            this.linearLayout.setVisibility(8);
        }
        this.chatlayout.setVisibility(0);
        RelativeLayout relativeLayout = this.goToCurrentRl;
        if (relativeLayout != null) {
            relativeLayout.performClick();
        }
        this.llEnableMarkAsRead.setVisibility(8);
    }

    private void setIndex() {
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        this.refressDoubtRl.setVisibility(8);
        this.goToCurrentRl.setVisibility(8);
        setChatSettingUi(false);
        this.forDoubtll.setVisibility(8);
        this.unpublishtxt.setVisibility(8);
        this.isclicked = "3";
        this.addBookmark.setVisibility(8);
        this.rl_pdf_data.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.linearLayout.setVisibility(8);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        setAdapter();
        this.llEnableMarkAsRead.setVisibility(8);
    }

    public void setVideoTimeMS(int timeMS) {
        if (this.player != null) {
            if (!Helper.isConnected(this)) {
                showMessage(getResources().getString(R.string.no_internet_connection));
            }
            String str = this.is_limited;
            if (str != null) {
                if (!str.equalsIgnoreCase("1")) {
                    this.player.seekTo(timeMS);
                    return;
                } else if (this.totalRemainingtime > 0) {
                    this.player.seekTo(timeMS);
                    return;
                } else {
                    releasePlayer();
                    makeDialog(this, getResources().getString(R.string.alert), getResources().getString(R.string.video_time_is_expired), getResources().getString(R.string.ok), false);
                    return;
                }
            }
            this.player.seekTo(timeMS);
            return;
        }
        showMessage(getResources().getString(R.string.please_wait_player_is_not_ready));
    }

    void disableAll() {
        this.pinChat.setBackgroundColor(getResources().getColor(R.color.off_white));
        if (this.isclicked.equalsIgnoreCase("1") || this.isclicked.equalsIgnoreCase("6")) {
            LeftMenu leftMenu = this.leftMenu;
            if (leftMenu != null) {
                if (leftMenu.getChatPinUnPin() != null && this.leftMenu.getChatPinUnPin().equalsIgnoreCase("1")) {
                    this.pinll.setVisibility(0);
                    return;
                } else {
                    this.pinll.setVisibility(8);
                    return;
                }
            }
            return;
        }
        this.pinll.setVisibility(8);
    }

    private void setAdapter() {
        Adapter_recycleveiw_vedio adapter_recycleveiw_vedio = new Adapter_recycleveiw_vedio(this, this.indexdata, "drm");
        this.adapter = adapter_recycleveiw_vedio;
        this.recyclerChat.setAdapter(adapter_recycleveiw_vedio);
    }

    private void setbookmarkadapter() {
        BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(this, this.bookmarkdata, "voddrm");
        this.bookmarkAdapter = bookmarkAdapter;
        this.recyclerChat.setAdapter(bookmarkAdapter);
    }

    private void setBookMark() {
        this.isUserOnPoll = false;
        this.isUserOnDoubt = false;
        this.refressDoubtRl.setVisibility(8);
        this.goToCurrentRl.setVisibility(8);
        setChatSettingUi(false);
        this.forDoubtll.setVisibility(8);
        this.unpublishtxt.setVisibility(8);
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.isclicked = "2";
        this.rl_pdf_data.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        this.linearLayout.setVisibility(0);
        disableAll();
        this.addBookmark.setVisibility(0);
        this.chatlayout.setVisibility(8);
        setbookmarkadapter();
        if (Helper.isShowMarkAsDone(this.videotype) && this.isclicked.equalsIgnoreCase("2")) {
            this.llEnableMarkAsRead.setVisibility(0);
        } else {
            this.llEnableMarkAsRead.setVisibility(8);
        }
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

    private void initFullscreenButton() {
        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) findViewById(R.id.exo_progress);
        TextView textView = (TextView) findViewById(R.id.exo_position);
        TextView textView2 = (TextView) findViewById(R.id.exo_duration);
        this.audiocaetimage = (ImageView) findViewById(R.id.audiocaetimage);
        this.tvGoLive = (TextView) findViewById(R.id.tv_go_live);
        String str = this.isaudio;
        if (str != null && str.equalsIgnoreCase("1")) {
            this.quality.setVisibility(8);
        }
        if (this.islive.equalsIgnoreCase("5")) {
            this.speedTV.setVisibility(8);
            this.tvGoLive.setVisibility(0);
            BottomSetting bottomSetting = this.bottomSetting;
            if (bottomSetting != null) {
                if (bottomSetting.getSeek_bar() != null && this.bottomSetting.getSeek_bar().equalsIgnoreCase("1")) {
                    defaultTimeBar.setVisibility(0);
                    textView.setVisibility(0);
                    textView2.setVisibility(0);
                } else {
                    defaultTimeBar.setVisibility(4);
                    textView.setVisibility(4);
                    textView2.setVisibility(4);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
            findViewById(R.id.exo_ffwd).setLayoutParams(layoutParams);
            findViewById(R.id.exo_rew).setLayoutParams(layoutParams);
            if (this.speedTV.getVisibility() == 0) {
                String str2 = this.playerSpeed;
                if (str2 != null && !str2.equalsIgnoreCase(Const.Normal)) {
                    this.playerSpeed = Const.Normal;
                    ExoPlayer exoPlayer = this.player;
                    if (exoPlayer != null) {
                        exoPlayer.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                    }
                }
                this.speedTV.setVisibility(8);
                this.speedTV.setText(Const.Normal);
            }
            goLive();
        } else {
            this.speedTV.setVisibility(0);
            this.tvGoLive.setVisibility(8);
        }
        TextView textView3 = this.speedTV;
        if (textView3 != null) {
            textView3.setText(getResources().getString(R.string.normal));
            this.speedTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.41
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    VODPlayerActivity.this.showSpeedOptions();
                }
            });
        }
        TextView textView4 = this.tvGoLive;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.42
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (VODPlayerActivity.this.speedTV.getVisibility() == 0) {
                        if (VODPlayerActivity.this.playerSpeed != null && !VODPlayerActivity.this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
                            VODPlayerActivity.this.playerSpeed = Const.Normal;
                            if (VODPlayerActivity.this.player != null) {
                                VODPlayerActivity.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                            }
                        }
                        VODPlayerActivity.this.speedTV.setVisibility(8);
                        VODPlayerActivity.this.speedTV.setText(Const.Normal);
                    }
                    VODPlayerActivity.this.goLive();
                }
            });
        }
        ImageView imageView = (ImageView) findViewById(R.id.exo_fullscreen_icon);
        this.mFullScreenButton = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.43
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (VODPlayerActivity.this.mExoPlayerFullscreen) {
                    VODPlayerActivity.this.llEnableMarkAsRead.setVisibility(8);
                    VODPlayerActivity.this.closeFullScreenDialogNew();
                    return;
                }
                if (Helper.isShowMarkAsDone(VODPlayerActivity.this.videotype) && VODPlayerActivity.this.isclicked == "2") {
                    VODPlayerActivity.this.llEnableMarkAsRead.setVisibility(0);
                } else {
                    VODPlayerActivity.this.llEnableMarkAsRead.setVisibility(8);
                }
                VODPlayerActivity.this.openFullScreenDialogNew();
            }
        });
    }

    public void updateList(ArrayList<AddOptionModel> optionList) {
        this.optionList = optionList;
    }

    public void updateListAfterText(ArrayList<AddOptionModel> optionList) {
        this.optionList = optionList;
    }

    public void removeOption(int position) {
        this.optionList.remove(position);
        int i = 0;
        while (i < this.optionList.size()) {
            int i2 = i + 1;
            this.optionList.get(i).setOption("Option " + i2);
            this.optionList.get(i).setAnswer(getPollOptionQues(i));
            i = i2;
        }
        RecyclerView recyclerView = this.addOptionRecycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            if (this.modeOfPoll.equalsIgnoreCase("1")) {
                this.addOptionRecycler.setAdapter(new AddOptionAdapter(this, this.optionList, this.addOptionRl));
            } else {
                this.addOptionRecycler.setAdapter(new AddOptionAdapter(this, this.optionList, true, this.addOptionRl));
            }
        }
    }

    public String getPollOptionQues(int index) {
        if (index == 0) {
            return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        }
        if (index == 1) {
            return "B";
        }
        if (index == 2) {
            return "C";
        }
        if (index == 3) {
            return "D";
        }
        if (index == 4) {
            return ExifInterface.LONGITUDE_EAST;
        }
        return "";
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
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.44
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    String string = item.getTitle().toString();
                    VODPlayerActivity.this.playerSpeed = item.getTitle().toString();
                    if (VODPlayerActivity.this.player == null) {
                        return false;
                    }
                    VODPlayerActivity.this.speedTV.setText(string);
                    if (string.equalsIgnoreCase(Const.Normal)) {
                        VODPlayerActivity.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                    } else {
                        VODPlayerActivity.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(string.replace("x", "")).floatValue(), 1.0f));
                    }
                    if (!VODPlayerActivity.this.isPlaying() || !VODPlayerActivity.this.is_limited.equalsIgnoreCase("1")) {
                        return false;
                    }
                    VODPlayerActivity.this.setTimer();
                    return false;
                }
            });
            popupMenu.show();
        }
    }

    private void openFullscreenDialog() {
        this.fullscreen.setImageDrawable(ContextCompat.getDrawable(this, 2131231286));
        this.mExoPlayerFullscreen = true;
        setRequestedOrientation(0);
    }

    private void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen) { // from class: com.appnew.android.player.VODPlayerActivity.45
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (VODPlayerActivity.this.mExoPlayerFullscreen) {
                    VODPlayerActivity.this.closeFullScreenDialogNew();
                }
                dismiss();
            }
        };
    }

    public void setcountincrement(final long count, final String child, SendUserData userData) {
        try {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferencepolldata;
            if (databaseReference != null) {
                databaseReference.child(child).setValue(Long.valueOf(count));
                this.mFirebaseDatabaseReferencepolldata.child("users").child(MakeMyExam.userId).setValue(userData);
            } else {
                showMessage(getResources().getString(R.string.key_is_empty));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setpollcount(final String pollkey, final String answer, final SendUserData userData) {
        if (this.isFirebaseChat) {
            this.mFirebaseDatabaseReferencepolldata = null;
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + pollkey);
            this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.VODPlayerActivity.46
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
                                    VODPlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_1", userData);
                                }
                            } else if (answer.equalsIgnoreCase("2")) {
                                if (key.equalsIgnoreCase("attempt_2")) {
                                    VODPlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_2", userData);
                                }
                            } else if (answer.equalsIgnoreCase("3")) {
                                if (key.equalsIgnoreCase("attempt_3")) {
                                    VODPlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_3", userData);
                                }
                            } else if (answer.equalsIgnoreCase("4") && key.equalsIgnoreCase("attempt_4")) {
                                VODPlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_4", userData);
                            }
                        }
                        VODPlayerActivity.this.userList.add(new AttemptedUserPoll(answer, pollkey, userData, MakeMyExam.userId));
                        SharedPreferencePoll.getInstance(VODPlayerActivity.this.activity).saveAttemptedUserPollList(VODPlayerActivity.this.userList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return;
        }
        sendWSMessage(updatePollDataStr(pollkey, answer, userData.getTimeleft()), "UPDATE_POLL", "");
    }

    public void setpollcount(final String pollkey, final String answer) {
        if (this.isFirebaseChat) {
            this.mFirebaseDatabaseReferencepolldata = null;
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + pollkey);
            this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.VODPlayerActivity.47
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
                                    VODPlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_1");
                                }
                            } else if (answer.equalsIgnoreCase("2")) {
                                if (key.equalsIgnoreCase("attempt_2")) {
                                    VODPlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_2");
                                }
                            } else if (answer.equalsIgnoreCase("3")) {
                                if (key.equalsIgnoreCase("attempt_3")) {
                                    VODPlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_3");
                                }
                            } else if (answer.equalsIgnoreCase("4") && key.equalsIgnoreCase("attempt_4")) {
                                VODPlayerActivity.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_4");
                            }
                        }
                        VODPlayerActivity.this.userList.add(new AttemptedUserPoll(answer, pollkey, null, MakeMyExam.userId));
                        SharedPreferencePoll.getInstance(VODPlayerActivity.this.activity).saveAttemptedUserPollList(VODPlayerActivity.this.userList);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return;
        }
        sendWSMessage(updatePollDataStr(pollkey, answer, "0"), "UPDATE_POLL", "");
    }

    public void setcountincrement(final long count, final String child) {
        try {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferencepolldata;
            if (databaseReference != null) {
                databaseReference.child(child).setValue(Long.valueOf(count));
            } else {
                showMessage(getResources().getString(R.string.key_is_empty));
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
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda72
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$imgClick$41(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$imgClick$41(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_image.jpg"));
                this.str_imgTypeClick = "PhotoCameraRequest";
                intent.putExtra("output", uriForFile);
                this.someActivityResultLauncher.launch(intent);
                this.requestCode = 10000;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (charSequenceArr[i].equals("Choose from Gallery")) {
            try {
                Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                Uri uriForFile2 = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_gallery.jpg"));
                this.str_imgTypeClick = "PhotoGalleryRequest";
                intent2.putExtra("output", uriForFile2);
                this.someActivityResultLauncher.launch(intent2);
                this.requestCode = 20000;
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (charSequenceArr[i].equals("Cancel")) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$42(CropImageView.CropResult cropResult) {
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
    public /* synthetic */ void lambda$new$43(ActivityResult activityResult) {
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
        } catch (Exception unused) {
        }
        return file.getPath();
    }

    public void setupDoc(String selectedURI) {
        Exception exc;
        String str;
        MediaFile mediaFile = new MediaFile();
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(selectedURI)) {
            return;
        }
        if (!selectedURI.contains(getResources().getString(R.string.pdf_extension)) && !selectedURI.contains(getResources().getString(R.string.doc_extension)) && !selectedURI.contains(getResources().getString(R.string.xls_extension))) {
            showMessage(getResources().getString(R.string.file_format_error));
            return;
        }
        try {
            if (selectedURI.contains(getResources().getString(R.string.pdf_extension))) {
                try {
                    mediaFile.setImage(BitmapFactory.decodeResource(getResources(), R.mipmap.pdf));
                    mediaFile.setFile_type(Const.PDF);
                } catch (Exception e2) {
                    exc = e2;
                    exc.printStackTrace();
                }
            }
            try {
                String[] strArrSplit = selectedURI.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                str = strArrSplit[strArrSplit.length - 1];
            } catch (Exception unused) {
                str = "document.pdf";
            }
            mediaFile.setFile_name(Helper.sanitizeFilenameForS3(str));
            mediaFile.setFile(selectedURI);
            mediaFile.setFile_type(Const.PDF);
            arrayList.add(mediaFile);
        } catch (Exception e3) {
            e = e3;
        }
        try {
            s3ImageUploading s3imageuploading = new s3ImageUploading(this.Chat_node, "vc-10000386-38616500102/application/chat_system/" + this.Chat_node + MqttTopic.TOPIC_LEVEL_SEPARATOR + MakeMyExam.userId, this, this, null);
            this.s3IU = s3imageuploading;
            s3imageuploading.execute(arrayList);
        } catch (Exception e4) {
            e = e4;
            exc = e;
            exc.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.player;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 3 && this.player.getPlayWhenReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimer() {
        String str = this.playerSpeed;
        final int iRound = (str == null || str.equalsIgnoreCase(Const.Normal)) ? 1000 : Math.round(1000.0f / Float.parseFloat(this.playerSpeed.replace("x", "")));
        this.txtTimer.setVisibility(0);
        Handler handler = this.handler1;
        if (handler != null) {
            handler.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
        }
        Handler handler2 = this.handler1;
        if (handler2 != null) {
            handler2.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
        }
        if (this.totalRemainingtime > 0) {
            this.handler1 = new Handler();
            Runnable runnable = new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.48
                @Override // java.lang.Runnable
                public void run() {
                    if (VODPlayerActivity.this.player != null) {
                        VODPlayerActivity.this.totalRemainingtime -= 1000;
                        VODPlayerActivity.this.txtTimer.setText(Html.fromHtml("Remaining video time\n <font color='#018da4'>" + Helper.formatSeconds(((int) VODPlayerActivity.this.totalRemainingtime) / 1000) + "</font>"));
                        VODPlayerActivity.this.minute = r0.player.getCurrentPosition() / 1000;
                        if (VODPlayerActivity.this.demo_percent != null && !VODPlayerActivity.this.demo_percent.equalsIgnoreCase("") && (VODPlayerActivity.this.minute * Integer.parseInt(VODPlayerActivity.this.demo_percent)) / 100.0f > VODPlayerActivity.this.minute) {
                            VODPlayerActivity.this.pausePlayer();
                            VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                            Helper.showDialog(vODPlayerActivity, vODPlayerActivity.getResources().getString(R.string.this_is_demo_video_if_you_want_to_watch_this_video_please_purchase_this_course_thanks));
                        }
                    }
                    if (VODPlayerActivity.this.totalRemainingtime > 0) {
                        VODPlayerActivity.this.handler1.postDelayed(this, iRound);
                    } else {
                        VODPlayerActivity.this.totalRemainingtime = 0L;
                        VODPlayerActivity.this.callFinishRemainingTime();
                    }
                }
            };
            this.runable1 = runnable;
            this.handler1.postDelayed(runnable, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callFinishRemainingTime() {
        findViewById(R.id.quality).setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.totalRemainingtime = 0L;
        if (!this.starttime.equalsIgnoreCase("0")) {
            this.networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
        }
        releasePlayer();
        makeDialog(this, getResources().getString(R.string.alert), getResources().getString(R.string.video_time_is_expired), getResources().getString(R.string.ok), false);
        this.txtTimer.setText(Html.fromHtml(getResources().getString(R.string.remaining_video_time)));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        isUserActive = false;
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.isActivityLive = false;
        Handler handler = this.handler1;
        if (handler != null) {
            handler.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
        }
        if (this.is_limited.equalsIgnoreCase("1") && !this.remainingtime.equalsIgnoreCase("")) {
            saveLocaltime();
            if (this.utkashRoom.getvideoDownloadao().isLimitedvideo_exit(this.video_id, MakeMyExam.userId, this.is_limited)) {
                long j = this.totalRemainingtime;
                this.utkashRoom.getvideoDownloadao().update_videoRemainingtime(this.video_id, MakeMyExam.userId, String.valueOf(j > 0 ? j / 1000 : 0L));
            }
        }
        if (!this.starttime.equalsIgnoreCase("0")) {
            this.networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
        }
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            if (this.utkashRoom.getvideoDownloadao().isvideo_exit(this.video_id, MakeMyExam.userId)) {
                this.utkashRoom.getvideoDownloadao().update_videocurrenttime(this.video_id, MakeMyExam.userId, Long.valueOf(playPosition), String.valueOf(this.totalTime));
            }
            this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(this.player.getCurrentPosition()), this.video_id, MakeMyExam.userId, this.isaudio);
            pausePlayer();
        }
        if (this.islive.equalsIgnoreCase("0") && !this.starttime.equalsIgnoreCase("0")) {
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
        this.starttime = "0";
        if ("1".equalsIgnoreCase("2") || "1".equalsIgnoreCase("1")) {
            addRecordTime();
        }
        try {
            OutputStream outputStream = this.output;
            if (outputStream != null) {
                outputStream.close();
            }
            InputStream inputStream = this.input;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception unused) {
        }
        this.progress_bar_pdf.setVisibility(8);
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private void addRecordTime() {
        this.networkCall.NetworkAPICall(API.get_video_logging, "", false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releasePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(this.player.getCurrentPosition()), this.video_id, MakeMyExam.userId, this.isaudio);
            if (this.utkashRoom.getvideoDownloadao().isLimitedvideo_exit(this.video_id, MakeMyExam.userId, this.is_limited)) {
                long j = this.totalRemainingtime;
                this.utkashRoom.getvideoDownloadao().update_videoRemainingtime(this.video_id, MakeMyExam.userId, String.valueOf(j > 0 ? j / 1000 : 0L));
            }
            if (this.utkashRoom.getvideoDownloadao().isvideo_exit(this.video_id, MakeMyExam.userId)) {
                this.utkashRoom.getvideoDownloadao().update_videocurrenttime(this.video_id, MakeMyExam.userId, Long.valueOf(playPosition), String.valueOf(this.totalTime));
            }
            WatchTimeTracker watchTimeTracker = this.watchTimeTracker;
            if (watchTimeTracker != null) {
                watchTimeTracker.stopTracking();
            }
            this.player.release();
            this.playerView.setPlayer(null);
            this.player = null;
            this.url = "";
            newOrientation = 0;
        }
    }

    private void background_play() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage(getResources().getString(R.string.app_name));
        builder.setPositiveButton(Html.fromHtml("<font color='#000000'>Stop</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda27
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$background_play$44(dialogInterface, i);
            }
        });
        builder.setNeutralButton(Html.fromHtml("<font color='#000000'>Cancel</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda28
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton(Html.fromHtml("<font color='#000000'>Play In background</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda29
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$background_play$46(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$background_play$44(DialogInterface dialogInterface, int i) {
        AudioPlayerService.isAudioPlaying = false;
        AudioPlayerService.videoid = "";
        AudioPlayerService.media_id = "";
        AudioPlayerService.video_currentpos = 0L;
        MakeMyExam.bitmap = null;
        if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, this.isaudio)) {
            if (this.player != null) {
                this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(this.player.getCurrentPosition()), this.video_id, MakeMyExam.userId, this.isaudio);
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
        showFeedbackOnBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$background_play$46(DialogInterface dialogInterface, int i) {
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
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            intent.putExtra("player_pos", exoPlayer.getCurrentPosition());
        }
        if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, this.isaudio)) {
            if (this.player != null) {
                this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(this.player.getCurrentPosition()), this.video_id, MakeMyExam.userId, this.isaudio);
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
        releasePlayer();
        dialogInterface.cancel();
        showFeedbackOnBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLocaltime() {
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
        SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, null);
        SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, map);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Runnable runnable;
        super.onDestroy();
        Handler handler = this.feedbackHandler;
        if (handler != null && (runnable = this.autoFeedbackRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
        try {
            PDFView pDFView = this.pdfViewPager;
            if (pDFView != null) {
                pDFView.recycle();
            }
        } catch (Exception e2) {
            Log.d("TAGPDFVIEW", "onDestroy: " + e2.getMessage());
        }
        this.arrChat = new ArrayList<>();
        if (this.chatAdapter != null) {
            this.chatAdapter = null;
        }
        stopMessageProcessor();
        stopMessageProcessorEmoji();
        MqttAndroidClient mqttAndroidClient = this.mqttClientListen;
        if (mqttAndroidClient != null) {
            mqttDisconnect(mqttAndroidClient);
        }
        MqttAndroidClient mqttAndroidClient2 = this.mqttClientPublish;
        if (mqttAndroidClient2 != null) {
            mqttDisconnect(mqttAndroidClient2);
        }
        SharedPreference.getInstance().putString(Const.IS_RECENT_REFRESH, "1");
        Handler handler2 = this.handler1;
        if (handler2 != null) {
            handler2.removeCallbacks(this.runable1);
            this.runable1 = null;
            this.handler1 = null;
        }
        if (!this.starttime.equalsIgnoreCase("0")) {
            this.networkCall.NetworkAPICall(API.user_video_view_data, "", false, false);
        }
        com.appnew.android.home.Constants.pos = "1";
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
        releasePlayer();
        this.utkashRoom = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (getResources().getConfiguration().orientation == 1) {
                this.landscapePollDialog.dismissLandscapeDialog();
            }
        } catch (Exception e2) {
            Log.d("TAGlandscapePollDialog", "onResume: " + e2.getMessage());
        }
        try {
            isUserActive = true;
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(true);
            }
            if (MakeMyExam.userId.equalsIgnoreCase("") || MakeMyExam.userId.equalsIgnoreCase("0")) {
                MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
                MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
            }
            AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService("audio");
            if (this.moveToPermission.intValue() != 1 && !audioManager.isMicrophoneMute()) {
                audioManager.setMicrophoneMute(true);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                audioManager.setAllowedCapturePolicy(3);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            this.telephonyManager = (TelephonyManager) getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 31) {
                this.newCallback = new MyTelephonyCallback();
                this.telephonyManager.registerTelephonyCallback(getMainExecutor(), this.newCallback);
            } else {
                MyPhoneStateListener myPhoneStateListener = new MyPhoneStateListener();
                this.oldListener = myPhoneStateListener;
                this.telephonyManager.listen(myPhoneStateListener, 32);
            }
        } catch (Exception e2) {
            Log.d("CALL_STATE", "handleCallStateChange: " + e2.getMessage());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        try {
            if (this.telephonyManager != null) {
                if (Build.VERSION.SDK_INT >= 31 && this.newCallback != null) {
                    Log.d("CALL_STATE", "12+ unregister");
                    this.telephonyManager.unregisterTelephonyCallback(this.newCallback);
                } else if (this.oldListener != null) {
                    Log.d("CALL_STATE", "< 12 unregister");
                    this.telephonyManager.listen(this.oldListener, 0);
                }
            }
        } catch (Exception e2) {
            Log.d("CALL_STATE", "handleCallStateChange: " + e2.getMessage());
        }
    }

    private class MyPhoneStateListener extends PhoneStateListener {
        private MyPhoneStateListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int state, String phoneNumber) {
            VODPlayerActivity.this.handleCallStateChange(state);
        }
    }

    private class MyTelephonyCallback extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        private MyTelephonyCallback() {
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int state) {
            VODPlayerActivity.this.handleCallStateChange(state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCallStateChange(int state) {
        try {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            if (state == 0) {
                if (audioManager != null && this.moveToPermission.intValue() != 1 && !audioManager.isMicrophoneMute()) {
                    audioManager.setMicrophoneMute(true);
                }
                if (audioManager != null) {
                    audioManager.setMode(0);
                }
                oncall(false);
                return;
            }
            if (state == 1 || state == 2) {
                Log.d("CALL_STATE", "Incoming call");
                if (audioManager != null && audioManager.isMicrophoneMute()) {
                    audioManager.setMicrophoneMute(false);
                }
                oncall(true);
            }
        } catch (Exception e2) {
            Log.d("CALL_STATE", "handleCallStateChange: " + e2.getMessage());
        }
    }

    public void oncall(final boolean b2) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.49
            @Override // java.lang.Runnable
            public void run() {
                if (b2) {
                    Log.d("CALL_STATE", "Video pause");
                    VODPlayerActivity.this.pausePlayer();
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

    public void getServeyData(final Polldata polldata) {
        final HashMap map = new HashMap();
        if (this.isFirebaseChat) {
            this.mFirebaseDatabaseReferencepolldata = null;
            DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + polldata.getRendomkey());
            this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.VODPlayerActivity.50
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
                                VODPlayerActivity.this.attempt_1_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                            }
                            if (key.equalsIgnoreCase("attempt_2")) {
                                VODPlayerActivity.this.attempt_2_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                            }
                            if (key.equalsIgnoreCase("attempt_3")) {
                                VODPlayerActivity.this.attempt_3_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                            }
                            if (key.equalsIgnoreCase("attempt_4")) {
                                VODPlayerActivity.this.attempt_4_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                            }
                        }
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        vODPlayerActivity.total = vODPlayerActivity.attempt_1_count + VODPlayerActivity.this.attempt_2_count + VODPlayerActivity.this.attempt_3_count + VODPlayerActivity.this.attempt_4_count;
                        map.put("total", Float.valueOf(VODPlayerActivity.this.total));
                        if (VODPlayerActivity.this.attempt_1_count != 0.0f) {
                            map.put("perA", Float.valueOf((VODPlayerActivity.this.attempt_1_count / VODPlayerActivity.this.total) * 100.0f));
                        } else {
                            map.put("perA", Float.valueOf(0.0f));
                        }
                        if (VODPlayerActivity.this.attempt_2_count != 0.0f) {
                            map.put("perB", Float.valueOf((VODPlayerActivity.this.attempt_2_count / VODPlayerActivity.this.total) * 100.0f));
                        } else {
                            map.put("perB", Float.valueOf(0.0f));
                        }
                        if (VODPlayerActivity.this.attempt_3_count != 0.0f) {
                            map.put("perC", Float.valueOf((VODPlayerActivity.this.attempt_3_count / VODPlayerActivity.this.total) * 100.0f));
                        } else {
                            map.put("perC", Float.valueOf(0.0f));
                        }
                        if (VODPlayerActivity.this.attempt_4_count != 0.0f) {
                            map.put("perD", Float.valueOf((VODPlayerActivity.this.attempt_4_count / VODPlayerActivity.this.total) * 100.0f));
                        } else {
                            map.put("perD", Float.valueOf(0.0f));
                        }
                        if (VODPlayerActivity.this.isLandscape) {
                            VODPlayerActivity.this.landscapePollDialog.showPollResult(polldata, map);
                        } else if (VODPlayerActivity.this.pollAdapter != null) {
                            VODPlayerActivity.this.pollAdapter.SetServeyresult(polldata, map);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return;
        }
        sendWSMessage(resultPollDataStr(polldata.getRendomkey()), "GET_POLL", polldata.getRendomkey());
    }

    @Override // com.pallycon.exoplayersample.simple.InitializePlayerService
    public void initializePlayer(MediaSource mediaSource, String url1, String token) {
        if (this.bottomSetting == null) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
        }
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null && bottomSetting.getSeek_bar() != null && this.bottomSetting.getSeek_bar().equalsIgnoreCase("1")) {
            String[] strArrSplit = url1.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            String str = "";
            for (int i = 0; i < strArrSplit.length; i++) {
                if (i != strArrSplit.length - 1) {
                    if (i == 0) {
                        str = str + strArrSplit[i] + "//";
                    }
                    str = str + strArrSplit[i] + MqttTopic.TOPIC_LEVEL_SEPARATOR;
                } else {
                    str = str + "start/" + this.timing + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[strArrSplit.length - 1];
                }
            }
            this.link = str;
            this.link = str.substring(8);
        }
        try {
            if (this.islive.equalsIgnoreCase("0")) {
                if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, this.isaudio)) {
                    playPosition = this.utkashRoom.getyoutubedata().getyoutubedata(MakeMyExam.userId, this.video_id, this.isaudio);
                } else {
                    playPosition = 0L;
                }
                if (this.utkashRoom.getvideoDownloadao().isvideo_exit(this.video_id, MakeMyExam.userId)) {
                    try {
                        VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(this.video_id, "1", MakeMyExam.userId);
                        if (this.is_limited.equalsIgnoreCase("1")) {
                            long jMin = Math.min(this.totalRemainingtime, Long.parseLong(videosDownload.getRemaining_time()) * 1000);
                            this.totalRemainingtime = jMin;
                            if (jMin < 0) {
                                this.totalRemainingtime = 0L;
                            }
                        }
                        playPosition = videosDownload.getVideoCurrentPosition().longValue();
                    } catch (Exception unused) {
                        playPosition = 2L;
                    }
                }
            } else {
                goLive();
            }
            if (this.isaudio.equalsIgnoreCase("1")) {
                this.audiocaetimage.setVisibility(0);
                Helper.setThumbnailImage(this, this.thumbnailurl, getDrawable(R.mipmap.course_placeholder), this.audiocaetimage);
            }
            this.mediaSourceTemp = mediaSource;
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this).setSeekForwardIncrementMs(10000L).setSeekBackIncrementMs(10000L).setTrackSelector(this.trackSelector1).build();
            this.player = exoPlayerBuild;
            exoPlayerBuild.setMediaSource(mediaSource);
            this.player.addListener(this.playerEventListener);
            this.playerView.setPlayer(this.player);
            PreferencesUtil.INSTANCE.setupPlayPauseButtonVisibility(this.player, this.playerView);
            PreferencesUtil.INSTANCE.changeFastForwardBackwardIcons(this.playerView);
            ((ZoomableVideoView) findViewById(R.id.zoomableVideoView)).setZoomListener(new ZoomableVideoView.ZoomListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda75
                @Override // com.appnew.android.player.music_player.ZoomableVideoView.ZoomListener
                public final void onSingleTap() {
                    this.f$0.lambda$initializePlayer$47();
                }
            });
            this.player.setPlayWhenReady(true);
            this.player.prepare();
            if (this.islive.equalsIgnoreCase("0")) {
                this.player.seekTo(playPosition);
            } else {
                this.player.seekToDefaultPosition();
            }
            if (TextUtils.isEmpty(this.playerSpeed) || this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
                this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
            } else {
                this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(this.playerSpeed.replace("x", "")).floatValue(), 1.0f));
            }
            initFullscreenButton();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlayer$47() {
        if (this.playerView.isControllerFullyVisible()) {
            this.playerView.hideController();
        } else {
            this.playerView.showController();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePlayerError(final PlaybackException error) {
        try {
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (Helper.isNetworkConnected(this)) {
                if (!this.errorCheck) {
                    this.errorCheck = true;
                    this.networkCall1 = VideoCrypt.getInstance(this).initialize(this, this.token, this.userId, Settings.Secure.getString(getContentResolver(), "android_id"), BuildConfig.ACCOUNTID, BuildConfig.SecretKey, BuildConfig.AccessKey, this.timing, getDrmLicenseUrl());
                }
            } else if (!this.errorCheckNetwork) {
                this.errorCheckNetwork = true;
                showMessage(getResources().getString(R.string.Retry_with_Internet_connection));
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handlePlayerError$48();
                }
            });
            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handlePlayerError$49(error);
                }
            });
            showPlayerLogs("PlaybackException: " + error.errorCode + " : " + error.getLocalizedMessage());
        } catch (Exception e3) {
            e = e3;
            showPlayerLogs("PlaybackException: " + error.errorCode + " : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePlayerError$48() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.player.prepare();
            this.player.setPlayWhenReady(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePlayerError$49(PlaybackException playbackException) {
        if (playbackException.errorCode == 1002 || playbackException.errorCode == 2000) {
            if (this.islive.equalsIgnoreCase("1") || this.islive.equalsIgnoreCase("5")) {
                goLive();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPlayerLogs(final String message) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.52
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                Log.d("TAGPlayerLogs", message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goLive() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer == null || !exoPlayer.isCurrentMediaItemLive()) {
            return;
        }
        this.player.seekToDefaultPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFullScreenDialogNew() {
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyInsetsNew(this, getWindow(), findViewById(R.id.mainRoot), false, null);
        }
        Helper.hideSoftKeyboard(this);
        Helper.closeKeyboard(this);
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

    public void setpin(chatPojo chatPojo, int pos) {
        if (this.isPublicChatEnabled) {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2many;
            if (databaseReference != null) {
                try {
                    databaseReference.child(this.keyset.get(pos)).child("pin").setValue("1");
                    chatPojo.setPin("1");
                    ChatAdapter chatAdapter = this.chatAdapter;
                    if (chatAdapter != null) {
                        chatAdapter.notifyItemChanged(pos);
                        return;
                    }
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
                ChatAdapter chatAdapter2 = this.chatAdapter;
                if (chatAdapter2 != null) {
                    chatAdapter2.notifyItemChanged(pos);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void setunPin(chatPojo chatPojo, int pos) {
        if (this.isPublicChatEnabled) {
            DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2many;
            if (databaseReference != null) {
                try {
                    databaseReference.child(this.keyset.get(pos)).child("pin").setValue("0");
                    chatPojo.setPin("0");
                    ChatAdapter chatAdapter = this.chatAdapter;
                    if (chatAdapter != null) {
                        chatAdapter.notifyItemChanged(pos);
                        return;
                    }
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
                ChatAdapter chatAdapter2 = this.chatAdapter;
                if (chatAdapter2 != null) {
                    chatAdapter2.notifyItemChanged(pos);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private void setUpPinChat() {
        ChatAdapter chatAdapter = this.chatAdapter;
        if (chatAdapter != null) {
            chatAdapter.pauseAudio();
        }
        this.pinchatList.clear();
        for (int i = 0; i < this.arrChat.size(); i++) {
            if (this.arrChat.get(i).getPin() != null && this.arrChat.get(i).getPin().equalsIgnoreCase("1")) {
                this.pinchatList.add(this.arrChat.get(i));
            }
        }
        this.linearLayout.setVisibility(8);
        this.chatAdapter = new ChatAdapter(this, Const.SHOW_PIN, this.pinchatList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        linearLayoutManager.setStackFromEnd(true);
        this.recyclerChat.setLayoutManager(linearLayoutManager);
        this.recyclerChat.setAdapter(this.chatAdapter);
        disableAll();
        this.pinChat.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.pinChat.setTextColor(getResources().getColor(android.R.color.black));
    }

    public void showPDF(final String url) {
        try {
            PDFView pDFView = this.webView;
            if (pDFView != null) {
                pDFView.recycle();
            }
            this.webView.fromUri(Uri.fromFile(new File(url))).onLoad(new OnLoadCompleteListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda24
                @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
                public final void loadComplete(int i) {
                    Helper.dismissProgressDialog();
                }
            }).onError(new OnErrorListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda25
                @Override // com.github.barteksc.pdfviewer.listener.OnErrorListener
                public final void onError(Throwable th) {
                    this.f$0.lambda$showPDF$51(th);
                }
            }).load();
        } catch (Exception e2) {
            Log.d("showPDF", "showPDF: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPDF$51(Throwable th) {
        Helper.dismissProgressDialog();
        showMessage(getResources().getString(R.string.error_in_loading_pdf));
    }

    public void deleteChat(int position) {
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference != null) {
            try {
                databaseReference.child(this.keyset.get(position)).removeValue();
                this.keyset.remove(position);
                this.arrChat.remove(position);
                ChatAdapter chatAdapter = this.chatAdapter;
                if (chatAdapter != null) {
                    chatAdapter.notifyDataSetChanged();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void completeclass() {
        this.rootRefcompleteclass = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/completevideo/");
        ChildEventListener childEventListener = new ChildEventListener() { // from class: com.appnew.android.player.VODPlayerActivity.53
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
                Long l;
                if (dataSnapshot != null) {
                    try {
                        VODPlayerActivity.this.showPlayerLogs("Complete Class: " + dataSnapshot.getKey() + ": " + dataSnapshot.getValue());
                        String key = dataSnapshot.getKey();
                        if (key == null || !key.equalsIgnoreCase("offline_status") || (l = (Long) dataSnapshot.getValue()) == null || l.longValue() != 0) {
                            return;
                        }
                        com.appnew.android.home.Constants.REFRESHPAGE = "true";
                        com.appnew.android.home.Constants.REFRESHPAGENEW = "true";
                        com.appnew.android.home.Constants.revison_set = true;
                        Log.e(VODPlayerActivity.TAG, "onChildAdded: " + VODPlayerActivity.isUserActive);
                        if (VODPlayerActivity.isActivityVisible() && VODPlayerActivity.dataSendListener != null && !VODPlayerActivity.this.isOperator && !VODPlayerActivity.this.isReviewSubmitted && VODPlayerActivity.this.isShowFeedback()) {
                            VODPlayerActivity.dataSendListener.onDataSent(l.longValue(), String.valueOf(VODPlayerActivity.this.video_id), null, 3);
                        }
                        VODPlayerActivity.this.finish();
                    } catch (Exception e2) {
                        VODPlayerActivity.this.showPlayerLogs("Complete Class: " + e2.getMessage());
                    }
                }
            }

            @Override // com.google.firebase.database.ChildEventListener
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Long l;
                if (dataSnapshot != null) {
                    try {
                        VODPlayerActivity.this.showPlayerLogs("Complete Class: " + dataSnapshot.getKey() + ": " + dataSnapshot.getValue());
                        String key = dataSnapshot.getKey();
                        if (key == null || !key.equalsIgnoreCase("offline_status") || (l = (Long) dataSnapshot.getValue()) == null || l.longValue() != 0) {
                            return;
                        }
                        com.appnew.android.home.Constants.REFRESHPAGE = "true";
                        com.appnew.android.home.Constants.REFRESHPAGENEW = "true";
                        com.appnew.android.home.Constants.revison_set = true;
                        if (VODPlayerActivity.isActivityVisible() && VODPlayerActivity.dataSendListener != null && !VODPlayerActivity.this.isOperator && !VODPlayerActivity.this.isReviewSubmitted && VODPlayerActivity.this.isShowFeedback()) {
                            VODPlayerActivity.dataSendListener.onDataSent(l.longValue(), String.valueOf(VODPlayerActivity.this.video_id), null, 3);
                        }
                        VODPlayerActivity.this.finish();
                    } catch (Exception e2) {
                        VODPlayerActivity.this.showPlayerLogs("Complete Class: " + e2.getMessage());
                    }
                }
            }
        };
        this.childEventListenercompleteclass = childEventListener;
        this.rootRefcompleteclass.addChildEventListener(childEventListener);
    }

    private String convertDataFormate(String timeStamp) {
        String str = null;
        try {
            long j = Long.parseLong(timeStamp) * 1000;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm-ss:mmm");
            str = simpleDateFormat.format(Long.valueOf(j));
            System.out.println(simpleDateFormat.format(Long.valueOf(j)));
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
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
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda53
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$makeDialog$52(dialog, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda54
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
    public /* synthetic */ void lambda$makeDialog$52(Dialog dialog, View view) {
        try {
            releasePlayer();
            dialog.dismiss();
            finish();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoplayNextVideo() {
        boolean z;
        ArrayList<Video> arrayList = this.allVideosList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        byte b2 = 1;
        int i = Integer.parseInt(this.position) + 1;
        if (i == this.allVideosList.size()) {
            return;
        }
        int i2 = Integer.parseInt(this.position) + 1;
        while (true) {
            if (i2 >= this.allVideosList.size()) {
                z = false;
                break;
            } else {
                if (this.allVideosList.get(i2).getFile_type().equalsIgnoreCase("3") && !this.allVideosList.get(i2).getIs_locked().equalsIgnoreCase("1")) {
                    i = i2;
                    z = true;
                    break;
                }
                i2++;
            }
        }
        if (z) {
            Video video = this.allVideosList.get(i);
            String video_type = video.getVideo_type();
            video_type.hashCode();
            switch (video_type.hashCode()) {
                case 48:
                    b2 = !video_type.equals("0") ? (byte) -1 : (byte) 0;
                    break;
                case 49:
                    if (!video_type.equals("1")) {
                        b2 = -1;
                    }
                    break;
                case 50:
                case 51:
                case 54:
                default:
                    b2 = -1;
                    break;
                case 52:
                    b2 = !video_type.equals("4") ? (byte) -1 : (byte) 2;
                    break;
                case 53:
                    b2 = !video_type.equals("5") ? (byte) -1 : (byte) 3;
                    break;
                case 55:
                    b2 = !video_type.equals("7") ? (byte) -1 : (byte) 4;
                    break;
                case 56:
                    b2 = !video_type.equals("8") ? (byte) -1 : (byte) 5;
                    break;
            }
            switch (b2) {
                case 0:
                case 3:
                    Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), this.allVideosList);
                    finish();
                    break;
                case 1:
                    Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_bookmarked(), video.getIs_live(), this.allVideosList);
                    finish();
                    break;
                case 2:
                    int i3 = i;
                    if (video.getLive_status().equalsIgnoreCase("1")) {
                        Helper.GoToLiveVideoActivity(video.getChat_node(), this, video.getFile_url(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getIs_chat_lock(), video.getPayloadData().getCourse_id(), String.valueOf(i3), SingleStudy.parentCourseId, video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_bookmarked(), video.getIs_live(), this.allVideosList);
                        finish();
                    } else if (video.getLive_status().equalsIgnoreCase("2")) {
                        showMessage(getResources().getString(R.string.live_class_is_ended));
                    } else if (video.getLive_status().equalsIgnoreCase("3")) {
                        showMessage(getResources().getString(R.string.live_class_is_cancelled));
                    }
                    break;
                case 4:
                    int i4 = i;
                    if (video.getIs_drm().equalsIgnoreCase("1")) {
                        Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i4), SingleStudy.parentCourseId, video.getStart_date(), "0", this.allVideosList);
                        finish();
                    } else {
                        Helper.GoToLiveAwsVideoActivity1(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i4), SingleStudy.parentCourseId, video.getStart_date(), this.allVideosList);
                        finish();
                    }
                    break;
                case 5:
                    if (video.getIs_drm().equalsIgnoreCase("1")) {
                        Helper.GoToVideoCryptActivity(this, video.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), video.getVideo_type(), video.getChat_node(), video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), "0", this.allVideosList);
                        finish();
                    } else {
                        Helper.GoToLiveAwsVideoActivity(video.getVideo_type(), video.getChat_node(), this, video.getId(), video.getVideo_type(), video.getId(), video.getTitle(), "0", video.getThumbnail_url(), video.getPayloadData().getCourse_id(), video.getPayloadData().getTile_id(), video.getPayloadData().getTile_type(), video.getIs_chat_lock(), String.valueOf(i), SingleStudy.parentCourseId, video.getStart_date(), this.allVideosList);
                        finish();
                    }
                    break;
            }
        }
    }

    public void CallPDFOnSameScreen(final String id, String pdfUrl, final boolean isDownload, final String pdfTitle, final String course_id, final String isShare) {
        this.pdfViewPager.setVisibility(0);
        this.recyclerChat.setVisibility(8);
        this.rl_pdf_data.setVisibility(0);
        this.progress_bar_pdf.setVisibility(8);
        this.finalPdfUrl = pdfUrl;
        PdfUtils.INSTANCE.checkPermissionsAndDownload(this, pdfUrl, this.pdfViewPager, this.progress_bar_pdf, this.requestPermissionLauncher1);
        this.ic_back_pdf.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.54
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VODPlayerActivity.this.recyclerChat.setVisibility(0);
                VODPlayerActivity.this.rl_pdf_data.setVisibility(8);
                try {
                    if (VODPlayerActivity.this.output != null) {
                        VODPlayerActivity.this.output.close();
                    }
                    if (VODPlayerActivity.this.input != null) {
                        VODPlayerActivity.this.input.close();
                    }
                } catch (Exception unused) {
                }
                VODPlayerActivity.this.progress_bar_pdf.setVisibility(8);
                if (VODPlayerActivity.this.urlConnection != null) {
                    VODPlayerActivity.this.urlConnection.disconnect();
                }
            }
        });
        this.ic_full_pdf.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity.55
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VODPlayerActivity.this.recyclerChat.setVisibility(0);
                VODPlayerActivity.this.rl_pdf_data.setVisibility(8);
                VODPlayerActivity.this.progress_bar_pdf.setVisibility(8);
                VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                Helper.GoToWebViewPDFActivity(vODPlayerActivity, id, vODPlayerActivity.finalPdfUrl, isDownload, pdfTitle, course_id, isShare);
            }
        });
    }

    private void showPDFData(final String url) {
        try {
            PDFView pDFView = this.pdfViewPager;
            if (pDFView != null) {
                pDFView.recycle();
            }
            if (isDestroyed()) {
                return;
            }
            this.pdfViewPager.post(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showPDFData$54(url);
                }
            });
        } catch (Exception e2) {
            Log.d("showPDF", "showPDF: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPDFData$54(String str) {
        this.pdfViewPager.fromFile(new File(str)).enableAnnotationRendering(true).onLoad(this).onError(new OnErrorListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda68
            @Override // com.github.barteksc.pdfviewer.listener.OnErrorListener
            public final void onError(Throwable th) {
                this.f$0.onError(th);
            }
        }).load();
    }

    public class LOADURL_new extends AsyncTask<String, Integer, String> {
        private AsyncTaskCompleteListener callback;
        public File filepath;
        String response = "";

        public LOADURL_new(AsyncTaskCompleteListener cb) {
            this.callback = cb;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Finally extract failed */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strings) {
            VODPlayerActivity vODPlayerActivity;
            try {
                try {
                    VODPlayerActivity.this.urlConnection = (HttpURLConnection) new URL(strings[0]).openConnection();
                } catch (Exception unused) {
                    this.response = "error";
                    if (VODPlayerActivity.this.output != null) {
                        vODPlayerActivity = VODPlayerActivity.this;
                    }
                }
                if (VODPlayerActivity.this.urlConnection.getResponseCode() != 200) {
                    this.response = "error";
                    String str = "Server returned HTTP " + VODPlayerActivity.this.urlConnection.getResponseCode() + " " + VODPlayerActivity.this.urlConnection.getResponseMessage();
                    try {
                        if (VODPlayerActivity.this.output != null) {
                            VODPlayerActivity.this.output.close();
                        }
                    } catch (Exception unused2) {
                    }
                    return str;
                }
                if (VODPlayerActivity.this.urlConnection.getResponseCode() == 200) {
                    VODPlayerActivity.this.urlConnection.getContentLength();
                    VODPlayerActivity.this.input = new BufferedInputStream(VODPlayerActivity.this.urlConnection.getInputStream());
                    this.response = "success";
                }
                if (VODPlayerActivity.this.output != null) {
                    vODPlayerActivity = VODPlayerActivity.this;
                    vODPlayerActivity.output.close();
                }
                return this.response;
            } catch (Throwable th) {
                try {
                    if (VODPlayerActivity.this.output != null) {
                        VODPlayerActivity.this.output.close();
                    }
                } catch (Exception unused3) {
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... values) {
            super.onProgressUpdate((Object[]) values);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String response) {
            if (response == null || !response.equalsIgnoreCase("success")) {
                return;
            }
            VODPlayerActivity.this.pdfViewPager.fromFile(VODPlayerActivity.this.tempFile).onLoad(VODPlayerActivity.this).onError(VODPlayerActivity.this).load();
        }
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnErrorListener
    public void onError(Throwable t) {
        Helper.dismissProgressDialog();
        try {
            InputStream inputStream = this.input;
            if (inputStream != null) {
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.urlConnection;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.progress_bar_pdf.setVisibility(8);
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
    public void loadComplete(int nbPages) {
        try {
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.56
                @Override // java.lang.Runnable
                public void run() {
                    VODPlayerActivity.this.progress_bar_pdf.setVisibility(8);
                }
            }, 750L);
            this.pdfViewPager.setVisibility(0);
            InputStream inputStream = this.input;
            if (inputStream != null) {
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.urlConnection;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (this.retry) {
                new LOADURL_new(this).execute(this.finalPdfUrl);
                this.retry = false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Courses.Interfaces.AsyncTaskCompleteListener
    public void onTaskComplete(String inputStream, File filepath) {
        try {
            this.progress_bar_pdf.setVisibility(8);
            if (inputStream.equalsIgnoreCase("success")) {
                showPDFData(filepath.getAbsolutePath());
            } else {
                showMessage(getResources().getString(R.string.pdf_loading_error_please_wait));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void connectToServer() {
        setVisibleUi(false);
        LiveChat liveChat = this.liveChat;
        if (liveChat == null) {
            showMessage("Server url not found");
            return;
        }
        if (TextUtils.isEmpty(liveChat.getListenUrl())) {
            showMessage("Server url not found(listenUrl)");
            return;
        }
        if (TextUtils.isEmpty(this.liveChat.getPort())) {
            showMessage("Server url not found(port)");
            return;
        }
        if (TextUtils.isEmpty(this.liveChat.getChat_node())) {
            showMessage("Server url not found(chat_node)");
            return;
        }
        if (TextUtils.isEmpty(this.liveChat.getSetting_node())) {
            showMessage("Server url not found(setting_node)");
            return;
        }
        if (TextUtils.isEmpty(this.liveChat.getPrivate_chat_node())) {
            showMessage("Server url not found(private_chat_node)");
            return;
        }
        this.listenUrl = "tcp://" + this.liveChat.getListenUrl() + ":" + this.liveChat.getPort();
        this.publishUrl = "tcp://" + this.liveChat.getPublishUrl() + ":" + this.liveChat.getPort();
        this.chatNode = !TextUtils.isEmpty(this.liveChat.getChat_node()) ? this.liveChat.getChat_node() : "";
        this.settingNode = !TextUtils.isEmpty(this.liveChat.getSetting_node()) ? this.liveChat.getSetting_node() : "";
        this.privateNode = TextUtils.isEmpty(this.liveChat.getPrivate_chat_node()) ? "" : this.liveChat.getPrivate_chat_node();
        setVisibleUi(!TextUtils.isEmpty(this.liveChat.getType()) && this.liveChat.getType().equals("room_unlock"));
        showReactButton(!TextUtils.isEmpty(this.liveChat.getEmoji_type()) && this.liveChat.getEmoji_type().equals("emoji_unlock"));
        handleChatSettingButton();
        String str = SharedPreference.getInstance().getLoggedInUser().getId() + "_" + UUID.randomUUID().toString().substring(0, 8);
        if (this.listenUrl.equals(this.publishUrl)) {
            this.mqttClientListen = new MqttAndroidClient(this, this.listenUrl, str, Ack.AUTO_ACK, null, false, 1000);
            handleChatSettingNode();
        } else {
            this.mqttClientListen = new MqttAndroidClient(this, this.listenUrl, str, Ack.AUTO_ACK, null, false, 1000);
            handleChatNode();
            this.mqttClientPublish = new MqttAndroidClient(this, this.publishUrl, str, Ack.AUTO_ACK, null, false, 1000);
            handleSettingNode();
        }
    }

    private void handleChatSettingNode() {
        try {
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName(SharedPreference.getInstance().getLoggedInUser().getName());
            mqttConnectOptions.setPassword(Helper.getUserJWT().toCharArray());
            mqttConnectOptions.setKeepAliveInterval(60);
            mqttConnectOptions.setCleanSession(true);
            mqttConnectOptions.setAutomaticReconnect(true);
            this.mqttClientListen.connect(mqttConnectOptions).setActionCallback(new IMqttActionListener() { // from class: com.appnew.android.player.VODPlayerActivity.57
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    if (VODPlayerActivity.this.chatNode != null) {
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        vODPlayerActivity.subscribeToTopic(vODPlayerActivity.mqttClientListen, VODPlayerActivity.this.chatNode, QoS.AtMostOnce);
                    }
                    if (VODPlayerActivity.this.settingNode != null) {
                        VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                        vODPlayerActivity2.subscribeToTopic(vODPlayerActivity2.mqttClientListen, VODPlayerActivity.this.settingNode, QoS.ExactlyOnce);
                    }
                    if (!VODPlayerActivity.this.isOperator || VODPlayerActivity.this.privateNode == null) {
                        return;
                    }
                    VODPlayerActivity vODPlayerActivity3 = VODPlayerActivity.this;
                    vODPlayerActivity3.subscribeToTopic(vODPlayerActivity3.mqttClientListen, VODPlayerActivity.this.privateNode, QoS.AtMostOnce);
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("MQTT", "onFailure: " + exception.getMessage());
                }
            });
            this.mqttClientListen.setCallback(new MqttCallbackExtended() { // from class: com.appnew.android.player.VODPlayerActivity.58
                @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
                public void connectComplete(boolean reconnect, String serverURI) {
                    if (reconnect) {
                        Log.d("MQTT", "connection reconnect");
                        if (VODPlayerActivity.this.chatNode != null) {
                            VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                            vODPlayerActivity.subscribeToTopic(vODPlayerActivity.mqttClientListen, VODPlayerActivity.this.chatNode, QoS.AtMostOnce);
                        }
                        if (VODPlayerActivity.this.settingNode != null) {
                            VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                            vODPlayerActivity2.subscribeToTopic(vODPlayerActivity2.mqttClientListen, VODPlayerActivity.this.settingNode, QoS.ExactlyOnce);
                        }
                        if (!VODPlayerActivity.this.isOperator || VODPlayerActivity.this.privateNode == null) {
                            return;
                        }
                        VODPlayerActivity vODPlayerActivity3 = VODPlayerActivity.this;
                        vODPlayerActivity3.subscribeToTopic(vODPlayerActivity3.mqttClientListen, VODPlayerActivity.this.privateNode, QoS.AtMostOnce);
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void connectionLost(Throwable cause) {
                    Log.d("MQTT", "connection lost");
                    try {
                        VODPlayerActivity.this.mqttClientListen.reconnect();
                    } catch (MqttException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void messageArrived(String topic, MqttMessage message) {
                    try {
                        if (VODPlayerActivity.this.isDestroyed() || message == null) {
                            return;
                        }
                        String str = new String(message.getPayload());
                        VODPlayerActivity.this.handleChatPojoMessage(str);
                        Log.d("MQTTchatsettingNode", str);
                    } catch (Exception e2) {
                        Log.e("MQTT", e2.getMessage());
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void deliveryComplete(IMqttDeliveryToken token) {
                    Log.d("MQTT", "deliveryComplete");
                }
            });
        } catch (Exception e2) {
            showMessage("connectError: " + e2.getMessage());
        }
    }

    private void handleChatNode() {
        try {
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName(SharedPreference.getInstance().getLoggedInUser().getName());
            mqttConnectOptions.setPassword(Helper.getUserJWT().toCharArray());
            mqttConnectOptions.setKeepAliveInterval(60);
            mqttConnectOptions.setCleanSession(true);
            mqttConnectOptions.setAutomaticReconnect(true);
            this.mqttClientListen.connect(mqttConnectOptions).setActionCallback(new IMqttActionListener() { // from class: com.appnew.android.player.VODPlayerActivity.59
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    if (VODPlayerActivity.this.chatNode != null) {
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        vODPlayerActivity.subscribeToTopic(vODPlayerActivity.mqttClientListen, VODPlayerActivity.this.chatNode, QoS.AtMostOnce);
                    }
                    if (!VODPlayerActivity.this.isOperator || VODPlayerActivity.this.privateNode == null) {
                        return;
                    }
                    VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                    vODPlayerActivity2.subscribeToTopic(vODPlayerActivity2.mqttClientListen, VODPlayerActivity.this.privateNode, QoS.AtMostOnce);
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("MQTT", "onFailure: " + exception.getMessage());
                }
            });
            this.mqttClientListen.setCallback(new MqttCallbackExtended() { // from class: com.appnew.android.player.VODPlayerActivity.60
                @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
                public void connectComplete(boolean reconnect, String serverURI) {
                    if (reconnect) {
                        Log.d("MQTT", "connection reconnect");
                        if (VODPlayerActivity.this.chatNode != null) {
                            VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                            vODPlayerActivity.subscribeToTopic(vODPlayerActivity.mqttClientListen, VODPlayerActivity.this.chatNode, QoS.AtMostOnce);
                        }
                        if (!VODPlayerActivity.this.isOperator || VODPlayerActivity.this.privateNode == null) {
                            return;
                        }
                        VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                        vODPlayerActivity2.subscribeToTopic(vODPlayerActivity2.mqttClientListen, VODPlayerActivity.this.privateNode, QoS.AtMostOnce);
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void connectionLost(Throwable cause) {
                    Log.d("MQTT", "connection lost");
                    try {
                        VODPlayerActivity.this.mqttClientListen.reconnect();
                    } catch (MqttException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void messageArrived(String topic, MqttMessage message) {
                    try {
                        if (VODPlayerActivity.this.isDestroyed() || message == null) {
                            return;
                        }
                        String str = new String(message.getPayload());
                        VODPlayerActivity.this.handleChatPojoMessage(str);
                        Log.d("MQTTchatNode", str);
                    } catch (Exception e2) {
                        Log.e("MQTT", e2.getMessage());
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void deliveryComplete(IMqttDeliveryToken token) {
                    Log.d("MQTT", "deliveryComplete");
                }
            });
        } catch (Exception e2) {
            showMessage("connectError: " + e2.getMessage());
        }
    }

    private void handleSettingNode() {
        try {
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName(SharedPreference.getInstance().getLoggedInUser().getName());
            mqttConnectOptions.setPassword(Helper.getUserJWT().toCharArray());
            mqttConnectOptions.setKeepAliveInterval(60);
            mqttConnectOptions.setCleanSession(true);
            mqttConnectOptions.setAutomaticReconnect(true);
            this.mqttClientPublish.connect(mqttConnectOptions).setActionCallback(new IMqttActionListener() { // from class: com.appnew.android.player.VODPlayerActivity.61
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    if (VODPlayerActivity.this.settingNode != null) {
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        vODPlayerActivity.subscribeToTopic(vODPlayerActivity.mqttClientPublish, VODPlayerActivity.this.settingNode, QoS.ExactlyOnce);
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("MQTT", "onFailure: " + exception.getMessage());
                }
            });
            this.mqttClientPublish.setCallback(new MqttCallbackExtended() { // from class: com.appnew.android.player.VODPlayerActivity.62
                @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
                public void connectComplete(boolean reconnect, String serverURI) {
                    if (reconnect) {
                        Log.d("MQTT", "connection reconnect");
                        if (VODPlayerActivity.this.settingNode != null) {
                            VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                            vODPlayerActivity.subscribeToTopic(vODPlayerActivity.mqttClientPublish, VODPlayerActivity.this.settingNode, QoS.ExactlyOnce);
                        }
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void connectionLost(Throwable cause) {
                    Log.d("MQTT", "connection lost");
                    try {
                        VODPlayerActivity.this.mqttClientPublish.reconnect();
                    } catch (MqttException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void messageArrived(String topic, MqttMessage message) {
                    try {
                        if (VODPlayerActivity.this.isDestroyed() || message == null) {
                            return;
                        }
                        String str = new String(message.getPayload());
                        VODPlayerActivity.this.handleChatPojoMessage(str);
                        Log.d("MQTTsettingNode", str);
                    } catch (Exception e2) {
                        Log.e("MQTT", e2.getMessage());
                    }
                }

                @Override // org.eclipse.paho.client.mqttv3.MqttCallback
                public void deliveryComplete(IMqttDeliveryToken token) {
                    Log.d("MQTT", "deliveryComplete");
                }
            });
        } catch (Exception e2) {
            showMessage("connectError: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void handleChatPojoMessage(String msgData) {
        chatPojo chatpojo;
        ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue;
        Polldata message;
        ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue2;
        ConcurrentLinkedQueue<chatPojo> concurrentLinkedQueue3;
        chatPojo chatpojo2;
        try {
            JSONObject jSONObject = new JSONObject(msgData);
            if (!jSONObject.has("type") || TextUtils.isEmpty(jSONObject.optString("type"))) {
                Log.d("MQTT", "handleChatPojoMessage: invalid response type");
                return;
            }
            String strOptString = jSONObject.optString("type");
            switch (strOptString.hashCode()) {
                case -2129810220:
                    if (strOptString.equals("GET_LEADERBOARD_VIDEOWISE")) {
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda51
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$handleChatPojoMessage$56();
                            }
                        });
                        saveLeaderboardByMQTT(msgData, true);
                    }
                    break;
                case -1888703667:
                    if (strOptString.equals("publishDoubt")) {
                        this.doubtPublishStatus = "publishDoubt";
                        String string = getString(R.string.publishDoubtMsg);
                        if (jSONObject.has("message") && !TextUtils.isEmpty(jSONObject.optString("message"))) {
                            string = jSONObject.optString("message");
                        }
                        Snackbar.make(this.rootView.getRootView(), string, -1).show();
                        if (this.isUserOnDoubt) {
                            getAndUpdateDoubtList();
                        }
                    }
                    break;
                case -1239541617:
                    if (strOptString.equals("emojiReaction") && jSONObject.has("message") && !TextUtils.isEmpty(jSONObject.optString("message")) && (chatpojo = (chatPojo) new Gson().fromJson(msgData, chatPojo.class)) != null && (concurrentLinkedQueue = this.incomingQueueEmoji) != null) {
                        concurrentLinkedQueue.offer(chatpojo);
                        break;
                    }
                    break;
                case -1234464002:
                    if (strOptString.equals("feedback_trigger") && !this.isOperator) {
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda52
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.showAutoFeedback();
                            }
                        });
                        break;
                    }
                    break;
                case -1086137328:
                    if (strOptString.equals("videoCompleted")) {
                        com.appnew.android.home.Constants.REFRESHPAGE = "true";
                        com.appnew.android.home.Constants.REFRESHPAGENEW = "true";
                        com.appnew.android.home.Constants.revison_set = true;
                        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda50
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$handleChatPojoMessage$55();
                            }
                        });
                    }
                    break;
                case -1080577170:
                    if (strOptString.equals("public_chat")) {
                        this.isPublicChatEnabled = true;
                    }
                    break;
                case -1067626993:
                    if (!strOptString.equals("room_lock")) {
                    }
                    setVisibleUi(((chatPojo) new Gson().fromJson(msgData, chatPojo.class)).getType().equals("room_unlock"));
                    break;
                case -917003939:
                    if (!strOptString.equals("emoji_unlock")) {
                    }
                    showReactButton(((chatPojo) new Gson().fromJson(msgData, chatPojo.class)).getType().equals("emoji_unlock"));
                    break;
                case -98490824:
                    if (!strOptString.equals("user_unlock")) {
                    }
                    chatpojo2 = (chatPojo) new Gson().fromJson(msgData, chatPojo.class);
                    if (chatpojo2.getLocked_user_id() == null && chatpojo2.getLocked_user_id().equals(MakeMyExam.userId) && "user_lock".equals(chatpojo2.getType())) {
                        setVisibleUi(false);
                    } else {
                        setVisibleUi(true);
                    }
                    break;
                case 3446719:
                    if (strOptString.equals(Polling.EVENT_POLL)) {
                        PollResponseData pollResponseData = (PollResponseData) new Gson().fromJson(msgData, PollResponseData.class);
                        if ((!this.isOperator || !MakeMyExam.userId.equals(pollResponseData.getUser_id())) && (message = pollResponseData.getMessage()) != null) {
                            handleCreatePoll(message);
                        }
                    }
                    break;
                case 3556653:
                    if (strOptString.equals("text")) {
                        chatPojo chatpojo3 = (chatPojo) new Gson().fromJson(msgData, chatPojo.class);
                        boolean zContains = TextUtils.isEmpty(this.videoAdmin) ? false : Arrays.asList(this.videoAdmin.split(Constants.SEPARATOR_COMMA)).contains(chatpojo3.getId());
                        if (!this.isPublicChatEnabled && (concurrentLinkedQueue3 = this.incomingQueue) != null) {
                            concurrentLinkedQueue3.clear();
                        }
                        if ((this.isPublicChatEnabled || zContains || chatpojo3.getId().equals(MakeMyExam.userId) || "0".equals(chatpojo3.getPlatform())) && chatpojo3 != null && (concurrentLinkedQueue2 = this.incomingQueue) != null) {
                            concurrentLinkedQueue2.offer(chatpojo3);
                        }
                    }
                    break;
                case 86985684:
                    if (strOptString.equals("GET_LEADERBOARD")) {
                        saveLeaderboardByMQTT(msgData, false);
                    }
                    break;
                case 335190656:
                    if (strOptString.equals("publishCompletedDoubt")) {
                        this.doubtPublishStatus = "publishCompletedDoubt";
                        String string2 = getString(R.string.publishCompletedDoubtMsg);
                        if (jSONObject.has("message") && !TextUtils.isEmpty(jSONObject.optString("message"))) {
                            string2 = jSONObject.optString("message");
                        }
                        Snackbar.make(this.rootView.getRootView(), string2, -1).show();
                        if (this.isUserOnDoubt) {
                            getAndUpdateDoubtList();
                        }
                    }
                    break;
                case 339294495:
                    if (strOptString.equals("user_lock")) {
                        chatpojo2 = (chatPojo) new Gson().fromJson(msgData, chatPojo.class);
                        if (chatpojo2.getLocked_user_id() == null) {
                        }
                        setVisibleUi(true);
                    }
                    break;
                case 749615492:
                    if (strOptString.equals("emoji_lock")) {
                        showReactButton(((chatPojo) new Gson().fromJson(msgData, chatPojo.class)).getType().equals("emoji_unlock"));
                    }
                    break;
                case 764657448:
                    if (strOptString.equals("room_unlock")) {
                        setVisibleUi(((chatPojo) new Gson().fromJson(msgData, chatPojo.class)).getType().equals("room_unlock"));
                    }
                    break;
                case 1000480916:
                    if (strOptString.equals("private_chat")) {
                        if (!this.isOperator) {
                            this.isPublicChatEnabled = false;
                        } else {
                            this.isPublicChatEnabled = true;
                        }
                    }
                    break;
                case 1340207238:
                    if (strOptString.equals("unPublishDoubt")) {
                        this.doubtPublishStatus = "unPublishDoubt";
                        if (this.isUserOnDoubt) {
                            getAndUpdateDoubtList();
                        }
                    }
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleChatPojoMessage$55() {
        if (this.mExoPlayerFullscreen) {
            closeFullScreenDialogNew();
        }
        if (isActivityVisible() && dataSendListener != null && !this.isOperator && !this.isReviewSubmitted && isShowFeedback()) {
            dataSendListener.onDataSent(Long.parseLong(this.islive), String.valueOf(this.video_id), null, 3);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleChatPojoMessage$56() {
        this.isShowViewAllLeaderBoard = true;
        this.viewLeaderboard.setVisibility((this.isFirebaseChat || this.pollarraylist.isEmpty() || !this.isShowViewAllLeaderBoard) ? 8 : 0);
    }

    public void saveLeaderboardByMQTT(String msgData, boolean isVideoWise) {
        try {
            JSONObject jSONObject = new JSONObject(msgData);
            String strOptString = jSONObject.has("type") ? jSONObject.optString("type") : "";
            String strOptString2 = jSONObject.has("status_code") ? jSONObject.optString("status_code") : "";
            String strOptString3 = jSONObject.has("poll_id") ? jSONObject.optString("poll_id") : "";
            if (isVideoWise) {
                strOptString3 = String.valueOf(this.video_id);
            }
            savePollResultInLocal(msgData, strOptString, strOptString3, strOptString2);
        } catch (Exception unused) {
            Log.d("MQTT", "mqtt_leaderboard: Error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeToTopic(MqttAndroidClient mqttAndroidClient, final String topic, QoS qos) {
        try {
            mqttAndroidClient.subscribe(topic, qos.getValue(), (Object) null, new IMqttActionListener() { // from class: com.appnew.android.player.VODPlayerActivity.63
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.d("MQTT", "Subscribed to: " + topic);
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("MQTT", "Failed to Subscribed: " + topic);
                }
            });
        } catch (Exception e2) {
            Log.d("MQTT", "subscribeToTopicError: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(String message, boolean isEmoji) {
        try {
            String str = (this.isPublicChatEnabled || this.isOperator) ? this.chatNode : this.privateNode;
            if (TextUtils.isEmpty(str)) {
                Log.d("MQTT", "Empty listen url");
                return;
            }
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setPayload(message.getBytes());
            this.mqttClientListen.publish(str, mqttMessage, (Object) null, new AnonymousClass64(message, isEmoji));
        } catch (Exception e2) {
            Log.d("MQTT", "sendMessageError: " + e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$64, reason: invalid class name */
    class AnonymousClass64 implements IMqttActionListener {
        final /* synthetic */ boolean val$isEmoji;
        final /* synthetic */ String val$message;

        AnonymousClass64(final String val$message, final boolean val$isEmoji) {
            this.val$message = val$message;
            this.val$isEmoji = val$isEmoji;
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onSuccess(IMqttToken asyncActionToken) {
            String str;
            if (!VODPlayerActivity.this.isDestroyed() && !VODPlayerActivity.this.isPublicChatEnabled && !VODPlayerActivity.this.isOperator && (str = this.val$message) != null) {
                VODPlayerActivity.this.handleChatPojoMessage(str);
                Log.d("MQTTchatsettingNodePri", this.val$message);
            }
            VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
            final boolean z = this.val$isEmoji;
            vODPlayerActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$64$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSuccess$0(z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(boolean z) {
            if (z) {
                VODPlayerActivity.this.timerForEmojiClick();
            } else {
                VODPlayerActivity.this.enableDisableMsgET();
            }
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onFailure(IMqttToken asyncActionToken, final Throwable exception) {
            VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$64$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFailure$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$1() {
            VODPlayerActivity.this.showMessage("Reconnecting, please try again");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableDisableMsgET() {
        try {
            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda73
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$enableDisableMsgET$57();
                }
            });
            if (!com.appnew.android.home.Constants.chatMsgTimerEnabled || this.isOperator) {
                return;
            }
            runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda74
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$enableDisableMsgET$58();
                }
            });
            Timer timer = new Timer();
            timer.schedule(new AnonymousClass65(new int[]{30}, timer), 1000L, 1000L);
        } catch (Exception e2) {
            Log.d("MQTT", "enableDisableMsgET: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableDisableMsgET$57() {
        this.etMessage.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableDisableMsgET$58() {
        this.ivSend.setClickable(false);
        this.ivSend.setEnabled(false);
        this.etMessage.setClickable(false);
        this.etMessage.setEnabled(false);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$65, reason: invalid class name */
    class AnonymousClass65 extends TimerTask {
        final /* synthetic */ int[] val$count;
        final /* synthetic */ Timer val$timer;

        AnonymousClass65(final int[] val$count, final Timer val$timer) {
            this.val$count = val$count;
            this.val$timer = val$timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final int[] iArr = this.val$count;
            iArr[0] = iArr[0] - 1;
            VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$65$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0(iArr);
                }
            });
            if (this.val$count[0] == 0) {
                this.val$timer.cancel();
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$65$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$1();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(int[] iArr) {
            StringBuilder sb;
            int i;
            VODPlayerActivity.this.ivSend.setClickable(false);
            VODPlayerActivity.this.ivSend.setEnabled(false);
            VODPlayerActivity.this.etMessage.setClickable(false);
            VODPlayerActivity.this.etMessage.setEnabled(false);
            EditText editText = VODPlayerActivity.this.etMessage;
            if (iArr[0] >= 10) {
                sb = new StringBuilder("Wait for 00:");
                i = iArr[0];
            } else {
                sb = new StringBuilder("Wait for 00:0");
                i = iArr[0];
            }
            editText.setHint(sb.append(i).toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            VODPlayerActivity.this.ivSend.setClickable(true);
            VODPlayerActivity.this.ivSend.setEnabled(true);
            VODPlayerActivity.this.etMessage.setClickable(true);
            VODPlayerActivity.this.etMessage.setEnabled(true);
            VODPlayerActivity.this.etMessage.setHint("Type something...");
        }
    }

    public void mqttDisconnect(MqttAndroidClient mqttAndroidClient) {
        try {
            mqttAndroidClient.disconnect().setActionCallback(new IMqttActionListener() { // from class: com.appnew.android.player.VODPlayerActivity.66
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.d("MQTT", "Successfully disconnected");
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("MQTT", "Failed to disconnect");
                }
            });
        } catch (Exception e2) {
            Log.d("MQTT", "mqttDisconnectError: " + e2.getMessage());
        }
    }

    private void handleChatSettingButton() {
        LiveChat liveChat;
        Metarespo metarespo;
        LiveChat liveChat2;
        LiveChat liveChat3;
        SwitchCompat switchCompat = this.switchChat;
        if (switchCompat != null && (liveChat3 = this.liveChat) != null) {
            switchCompat.setChecked("room_unlock".equals(String.valueOf(liveChat3.getType())));
        }
        SwitchCompat switchCompat2 = this.switchEmoticons;
        if (switchCompat2 != null && (liveChat2 = this.liveChat) != null) {
            switchCompat2.setChecked("emoji_unlock".equals(String.valueOf(liveChat2.getEmoji_type())));
        }
        if (this.switchPublic != null && (metarespo = this.extraParam) != null && metarespo.getVideo() != null && this.extraParam.getVideo().getData() != null) {
            this.switchPublic.setChecked(this.extraParam.getVideo().getData().getPublic_chat() != null && this.extraParam.getVideo().getData().getPublic_chat().equalsIgnoreCase("1"));
        }
        SwitchCompat switchCompat3 = this.switchFeedback;
        if (switchCompat3 != null && (liveChat = this.liveChat) != null) {
            switchCompat3.setChecked(liveChat.getIs_feedback_triggered() != null && this.liveChat.getIs_feedback_triggered().equalsIgnoreCase("1"));
        }
        this.switchChatChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.player.VODPlayerActivity.67
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!Helper.isConnected(VODPlayerActivity.this)) {
                    VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                    vODPlayerActivity.showMessage(vODPlayerActivity.getResources().getString(R.string.no_internet_connection));
                    buttonView.setOnCheckedChangeListener(null);
                    buttonView.setChecked(!isChecked);
                    buttonView.setOnCheckedChangeListener(this);
                    return;
                }
                String str = isChecked ? "room_unlock" : "room_lock";
                VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                vODPlayerActivity2.switchSettingClick(str, vODPlayerActivity2.switchChat, VODPlayerActivity.this.switchChatChangeListener);
            }
        };
        this.switchEmoticonsChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.player.VODPlayerActivity.68
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!Helper.isConnected(VODPlayerActivity.this)) {
                    VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                    vODPlayerActivity.showMessage(vODPlayerActivity.getResources().getString(R.string.no_internet_connection));
                    buttonView.setOnCheckedChangeListener(null);
                    buttonView.setChecked(!isChecked);
                    buttonView.setOnCheckedChangeListener(this);
                    return;
                }
                String str = isChecked ? "emoji_unlock" : "emoji_lock";
                VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                vODPlayerActivity2.switchSettingClick(str, vODPlayerActivity2.switchEmoticons, VODPlayerActivity.this.switchEmoticonsChangeListener);
            }
        };
        this.switchPublicChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.player.VODPlayerActivity.69
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!Helper.isConnected(VODPlayerActivity.this)) {
                    VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                    vODPlayerActivity.showMessage(vODPlayerActivity.getResources().getString(R.string.no_internet_connection));
                    buttonView.setOnCheckedChangeListener(null);
                    buttonView.setChecked(!isChecked);
                    buttonView.setOnCheckedChangeListener(this);
                    return;
                }
                String str = isChecked ? "public_chat" : "private_chat";
                VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                vODPlayerActivity2.switchSettingClick(str, vODPlayerActivity2.switchPublic, VODPlayerActivity.this.switchPublicChangeListener);
            }
        };
        this.switchFeedbackChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.player.VODPlayerActivity.70
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!Helper.isConnected(VODPlayerActivity.this)) {
                    VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                    vODPlayerActivity.showMessage(vODPlayerActivity.getResources().getString(R.string.no_internet_connection));
                    buttonView.setOnCheckedChangeListener(null);
                    buttonView.setChecked(!isChecked);
                    buttonView.setOnCheckedChangeListener(this);
                    return;
                }
                if (isChecked) {
                    VODPlayerActivity vODPlayerActivity2 = VODPlayerActivity.this;
                    vODPlayerActivity2.switchSettingClick("feedback_trigger", vODPlayerActivity2.switchFeedback, VODPlayerActivity.this.switchFeedbackChangeListener);
                } else {
                    VODPlayerActivity.this.showMessage("Feedback already published!");
                    buttonView.setOnCheckedChangeListener(null);
                    buttonView.setChecked(true);
                    buttonView.setOnCheckedChangeListener(this);
                }
            }
        };
        SwitchCompat switchCompat4 = this.switchChat;
        if (switchCompat4 != null) {
            switchCompat4.setOnCheckedChangeListener(this.switchChatChangeListener);
        }
        SwitchCompat switchCompat5 = this.switchEmoticons;
        if (switchCompat5 != null) {
            switchCompat5.setOnCheckedChangeListener(this.switchEmoticonsChangeListener);
        }
        SwitchCompat switchCompat6 = this.switchPublic;
        if (switchCompat6 != null) {
            switchCompat6.setOnCheckedChangeListener(this.switchPublicChangeListener);
        }
        SwitchCompat switchCompat7 = this.switchFeedback;
        if (switchCompat7 != null) {
            switchCompat7.setOnCheckedChangeListener(this.switchFeedbackChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchSettingClick(String type, SwitchCompat switchButton, CompoundButton.OnCheckedChangeListener switchChangeListener) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setVideo_id(this.video_id);
        encryptionData.setType(type);
        encryptionData.setPlatform("1");
        LiveChat liveChat = this.liveChat;
        String publishUrl = "";
        encryptionData.setTopic((liveChat == null || TextUtils.isEmpty(liveChat.getSetting_node())) ? "" : this.liveChat.getSetting_node());
        LiveChat liveChat2 = this.liveChat;
        if (liveChat2 != null && !TextUtils.isEmpty(liveChat2.getPublishUrl())) {
            publishUrl = this.liveChat.getPublishUrl();
        }
        encryptionData.setHost(publishUrl);
        handleChatLockUnlock(new Gson().toJson(encryptionData), switchButton, switchChangeListener);
    }

    public void handleChatLockUnlock(String postData, final SwitchCompat switchButton, final CompoundButton.OnCheckedChangeListener switchChangeListener) {
        LiveChat liveChat = this.liveChat;
        if (liveChat == null || TextUtils.isEmpty(liveChat.getPollSocketUrl())) {
            showMessage("Base URL not found");
            disableSwitchOnError(switchButton, switchChangeListener);
            return;
        }
        if (!Helper.isNetworkConnected(this)) {
            showMessage(getResources().getString(R.string.Retry_with_Internet_connection));
            disableSwitchOnError(switchButton, switchChangeListener);
            return;
        }
        try {
            Helper.showProgressDialog(this);
            Call<String> callManageMqttPublish = ((APIInterface) MakeMyExamForPoll.getRetrofitInstance(this.liveChat.getPollSocketUrl()).create(APIInterface.class)).manageMqttPublish(postData);
            if (callManageMqttPublish != null) {
                callManageMqttPublish.enqueue(new Callback<String>() { // from class: com.appnew.android.player.VODPlayerActivity.71
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        Helper.dismissProgressDialog();
                        if (response != null) {
                            try {
                                if (response.body() != null && !TextUtils.isEmpty(response.body().toString())) {
                                    JSONObject jSONObject = new JSONObject(response.body().toString());
                                    if (jSONObject.has("message")) {
                                        VODPlayerActivity.this.showMessage(jSONObject.optString("message"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e2) {
                                VODPlayerActivity.this.disableSwitchOnError(switchButton, switchChangeListener);
                                VODPlayerActivity.this.showMessage(e2.getMessage());
                                return;
                            }
                        }
                        VODPlayerActivity.this.disableSwitchOnError(switchButton, switchChangeListener);
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        vODPlayerActivity.showMessage(vODPlayerActivity.getString(R.string.no_data_found));
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        Helper.dismissProgressDialog();
                        VODPlayerActivity.this.disableSwitchOnError(switchButton, switchChangeListener);
                        VODPlayerActivity.this.showMessage(t.getMessage());
                    }
                });
            }
        } catch (Exception e2) {
            Helper.dismissProgressDialog();
            disableSwitchOnError(switchButton, switchChangeListener);
            showMessage(e2.getMessage());
        }
    }

    public void disableSwitchOnError(final SwitchCompat switchButton, final CompoundButton.OnCheckedChangeListener switchChangeListener) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                VODPlayerActivity.lambda$disableSwitchOnError$59(switchButton, switchChangeListener);
            }
        });
    }

    static /* synthetic */ void lambda$disableSwitchOnError$59(SwitchCompat switchCompat, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (switchCompat == null || onCheckedChangeListener == null) {
            return;
        }
        switchCompat.setOnCheckedChangeListener(null);
        switchCompat.setChecked(!switchCompat.isChecked());
        switchCompat.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setChatSettingUi(final boolean isShow) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setChatSettingUi$60(isShow);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setChatSettingUi$60(boolean z) {
        if (!this.isFirebaseChat && Helper.isChatSettingEnabled() && this.isOperator && z) {
            LinearLayout linearLayout = this.llChatSetting;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.llChatSetting;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    private void setVisibleUi(final boolean status) {
        if (this.isOperator) {
            status = true;
        }
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda67
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setVisibleUi$61(status);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVisibleUi$61(boolean z) {
        if (z) {
            setSendListener();
            if (this.isUserOnPoll || this.isUserOnDoubt) {
                this.linearLayout.setVisibility(8);
                this.chatlayout.setVisibility(8);
            } else {
                this.linearLayout.setVisibility(0);
                this.chatlayout.setVisibility(0);
            }
            this.islockedback = "0";
            return;
        }
        this.linearLayout.setVisibility(8);
        this.chatlayout.setVisibility(8);
        this.islockedback = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessage(final String message) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.72
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(message)) {
                    return;
                }
                String str = message;
                if (str.contains("failed to connect")) {
                    str = "Failed to connect with server";
                }
                Toast.makeText(VODPlayerActivity.this, str, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePollData(final String messages) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.73
            /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
            
                if (r1.equals("POLL_ADDED") != false) goto L49;
             */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 244
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.VODPlayerActivity.AnonymousClass73.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkPollAlreadyAdded(Polldata polldata) {
        ArrayList<Polldata> arrayList = this.pollarraylist;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<Polldata> it = this.pollarraylist.iterator();
        while (it.hasNext()) {
            if (polldata.getRendomkey().equalsIgnoreCase(it.next().getRendomkey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCreatePoll(final Polldata polldata) {
        try {
            Helper.closeKeyboard(this);
            if (polldata == null || !polldata.getVideoId().equals(this.video_id)) {
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity.74
                @Override // java.lang.Runnable
                public void run() {
                    if (VODPlayerActivity.this.checkPollAlreadyAdded(polldata)) {
                        return;
                    }
                    polldata.setMyAnswer("0");
                    VODPlayerActivity.this.pollarraylist.add(0, polldata);
                    VODPlayerActivity.this.runOnUiThread(new AnonymousClass1());
                }

                /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$74$1, reason: invalid class name */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (VODPlayerActivity.this.pollAdapter != null) {
                            VODPlayerActivity.this.pollAdapter.notifyDataSetChanged();
                        }
                        int i = 8;
                        if (VODPlayerActivity.this.isOperator) {
                            VODPlayerActivity.this.addPoll.setVisibility(8);
                            VODPlayerActivity.this.createPoll.setVisibility(0);
                            VODPlayerActivity.this.generateLeaderboard.setVisibility((VODPlayerActivity.this.isFirebaseChat || !Helper.isGenerateLeaderboardEnabled()) ? 8 : 0);
                        } else {
                            VODPlayerActivity.this.addPoll.setVisibility(8);
                            VODPlayerActivity.this.createPoll.setVisibility(8);
                            VODPlayerActivity.this.generateLeaderboard.setVisibility(8);
                        }
                        TextView textView = VODPlayerActivity.this.viewLeaderboard;
                        if (!VODPlayerActivity.this.isFirebaseChat && !VODPlayerActivity.this.pollarraylist.isEmpty() && VODPlayerActivity.this.isShowViewAllLeaderBoard) {
                            i = 0;
                        }
                        textView.setVisibility(i);
                        VODPlayerActivity.this.enterTimeET.setText(VODPlayerActivity.this.defaultTimeDuration);
                        VODPlayerActivity.this.recylerViewPollOperator.setVisibility(0);
                        if (VODPlayerActivity.this.isUserOnPoll && VODPlayerActivity.this.createPollNestedScrollView != null) {
                            VODPlayerActivity.this.createPollNestedScrollView.post(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$74$1$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$run$0();
                                }
                            });
                        }
                        if (VODPlayerActivity.this.getResources().getConfiguration().orientation == 2) {
                            VODPlayerActivity.this.landscapePollDialog.showPollIndicator(polldata, true);
                            VODPlayerActivity.this.landscapePollDialog.showPollAttempt(polldata);
                        }
                        Snackbar.make(VODPlayerActivity.this.rootView.getRootView(), "New poll added", -1).show();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public /* synthetic */ void lambda$run$0() {
                        VODPlayerActivity.this.createPollNestedScrollView.smoothScrollTo(0, 0);
                    }
                }
            }, !this.isOperator ? (TimeUnit.MILLISECONDS.toSeconds((Long.parseLong(polldata.getValidTill()) - (System.currentTimeMillis() / 1000)) * 1000) - Long.parseLong(polldata.getValidity())) * 1000 : 0L);
        } catch (Exception e2) {
            showMessage(e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePollResult(String messages) {
        try {
            PollResponse pollResponse = (PollResponse) new Gson().fromJson(messages, PollResponse.class);
            Polldata message = pollResponse.getData().getMessage();
            HashMap<String, Float> map = new HashMap<>();
            this.attempt_1_count = pollResponse.getData().getMessage().getAttempt1().longValue();
            this.attempt_2_count = pollResponse.getData().getMessage().getAttempt2().longValue();
            this.attempt_3_count = pollResponse.getData().getMessage().getAttempt3().longValue();
            float fLongValue = pollResponse.getData().getMessage().getAttempt4().longValue();
            this.attempt_4_count = fLongValue;
            float f2 = this.attempt_1_count + this.attempt_2_count + this.attempt_3_count + fLongValue;
            this.total = f2;
            map.put("total", Float.valueOf(f2));
            float f3 = this.attempt_1_count;
            map.put("perA", Float.valueOf(f3 != 0.0f ? (f3 / this.total) * 100.0f : 0.0f));
            float f4 = this.attempt_2_count;
            map.put("perB", Float.valueOf(f4 != 0.0f ? (f4 / this.total) * 100.0f : 0.0f));
            float f5 = this.attempt_3_count;
            map.put("perC", Float.valueOf(f5 != 0.0f ? (f5 / this.total) * 100.0f : 0.0f));
            float f6 = this.attempt_4_count;
            map.put("perD", Float.valueOf(f6 != 0.0f ? (f6 / this.total) * 100.0f : 0.0f));
            if (this.isLandscape) {
                this.landscapePollDialog.showPollResult(message, map);
                return;
            }
            PollAdapter pollAdapter = this.pollAdapter;
            if (pollAdapter != null) {
                pollAdapter.SetServeyresult(message, map);
            }
        } catch (Exception unused) {
            showMessage(getResources().getString(R.string.no_data_found));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSubmitPoll(String messages) {
        showMessage(messages);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLeaderBoardResult(String messages, boolean isForAll) {
        try {
            LeaderboardResponse leaderboardResponse = (LeaderboardResponse) new Gson().fromJson(messages, LeaderboardResponse.class);
            if (this.isLandscape) {
                if (leaderboardResponse != null && leaderboardResponse.getData() != null && leaderboardResponse.getData().size() > 3) {
                    this.landscapePollDialog.showPollLeaderboard(leaderboardResponse.getData(), isForAll);
                    return;
                } else {
                    showMessage("No Leaderboard found");
                    return;
                }
            }
            PollAdapter pollAdapter = this.pollAdapter;
            if (pollAdapter != null) {
                pollAdapter.showLeaderboard(leaderboardResponse, isForAll);
            }
        } catch (Exception e2) {
            showMessage(e2.getMessage());
        }
    }

    private String createPollDataStr() {
        EncryptionData encryptionData = new EncryptionData();
        int i = 0;
        encryptionData.setOption_1(this.optionList.get(0).getAnswer());
        encryptionData.setOption_2(this.optionList.get(1).getAnswer());
        this.pollOption1 = this.optionList.get(0).getAnswer();
        this.pollOption2 = this.optionList.get(1).getAnswer();
        int size = this.optionList.size();
        if (size == 3) {
            encryptionData.setOption_3(this.optionList.get(2).getAnswer());
            this.pollOption3 = this.optionList.get(2).getAnswer();
        } else if (size == 4) {
            encryptionData.setOption_3(this.optionList.get(2).getAnswer());
            encryptionData.setOption_4(this.optionList.get(3).getAnswer());
            this.pollOption3 = this.optionList.get(2).getAnswer();
            this.pollOption4 = this.optionList.get(3).getAnswer();
        } else if (size == 5) {
            encryptionData.setOption_3(this.optionList.get(2).getAnswer());
            encryptionData.setOption_4(this.optionList.get(3).getAnswer());
            encryptionData.setOption_5(this.optionList.get(4).getAnswer());
            this.pollOption3 = this.optionList.get(2).getAnswer();
            this.pollOption4 = this.optionList.get(3).getAnswer();
            this.pollOption5 = this.optionList.get(4).getAnswer();
        } else if (size == 6) {
            encryptionData.setOption_3(this.optionList.get(2).getAnswer());
            encryptionData.setOption_4(this.optionList.get(3).getAnswer());
            encryptionData.setOption_5(this.optionList.get(4).getAnswer());
            encryptionData.setOption_6(this.optionList.get(5).getAnswer());
            this.pollOption3 = this.optionList.get(2).getAnswer();
            this.pollOption4 = this.optionList.get(3).getAnswer();
            this.pollOption5 = this.optionList.get(4).getAnswer();
            this.pollOption6 = this.optionList.get(5).getAnswer();
        }
        encryptionData.setQuestion(this.enterQuestionET.getText().toString());
        encryptionData.setDelay(this.enterDelayET.getText().toString());
        encryptionData.setMy_answer("0");
        if (!TextUtils.isEmpty(this.enterTimeET.getText().toString())) {
            encryptionData.setValidity(String.valueOf(Integer.parseInt(this.enterTimeET.getText().toString().split(" ")[0])));
        }
        this.pollValidity = String.valueOf(Integer.parseInt(this.enterTimeET.getText().toString().split(" ")[0]));
        while (true) {
            if (i >= this.optionList.size()) {
                break;
            }
            if (this.optionList.get(i).isThisAnswerRight()) {
                int i2 = i + 1;
                encryptionData.setAnswer(String.valueOf(i2));
                this.pollAnswer = String.valueOf(i2);
                break;
            }
            i++;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setSetting_node(!TextUtils.isEmpty(this.liveChat.getSetting_node()) ? this.liveChat.getSetting_node() : "");
        encryptionData2.setType("CREATE_POLL");
        encryptionData2.setId(MakeMyExam.getUserId());
        encryptionData2.setName(SharedPreference.getInstance().getLoggedInUser().getName());
        encryptionData2.setVideo_id(this.video_id);
        encryptionData2.setCourse_id(this.courseid);
        encryptionData2.setPlateform("1");
        encryptionData2.setData(encryptionData);
        return new Gson().toJson(encryptionData2);
    }

    private String updatePollDataStr(String pollkey, String answer, String timeleft) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("UPDATE_POLL");
        encryptionData.setPoll_id(pollkey);
        encryptionData.setAttempted(getAttemptedAnswer(answer));
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setTimeleft(timeleft);
        encryptionData.setName(SharedPreference.getInstance().getLoggedInUser().getName());
        encryptionData.setVideo_id(this.video_id);
        return new Gson().toJson(encryptionData);
    }

    private String resultPollDataStr(String pollkey) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("GET_POLL");
        encryptionData.setPoll_id(pollkey);
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setVideo_id(this.video_id);
        return new Gson().toJson(encryptionData);
    }

    public String leaderboardPollDataStr(String pollkey) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("GET_LEADERBOARD");
        encryptionData.setPoll_id(pollkey);
        encryptionData.setVideo_id(this.video_id);
        return new Gson().toJson(encryptionData);
    }

    public String leaderboardVideoWiseDataStr() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("GET_LEADERBOARD_VIDEOWISE");
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setVideo_id(this.video_id);
        return new Gson().toJson(encryptionData);
    }

    public String generateLeaderboardVideoWiseDataStr() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setSetting_node(!TextUtils.isEmpty(this.liveChat.getSetting_node()) ? this.liveChat.getSetting_node() : "");
        encryptionData.setType("GENERATE_LEADERBOARD_VIDEOWISE");
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setVideo_id(this.video_id);
        return new Gson().toJson(encryptionData);
    }

    public void sendWSMessage(String msg, String type, String pollId) {
        try {
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            managePollAPI(msg, type, pollId);
        } catch (Exception e2) {
            showMessage(e2.getMessage());
        }
    }

    public void managePollAPI(String postData, String type, final String pollId) {
        if (TextUtils.isEmpty(this.liveChat.getPollSocketUrl())) {
            showMessage("Base URL not found");
            return;
        }
        if (!Helper.isNetworkConnected(this)) {
            showMessage(getResources().getString(R.string.Retry_with_Internet_connection));
            return;
        }
        try {
            ArrayList<PollLocalResult> filteredPollLocalResults = Helper.getFilteredPollLocalResults(this.video_id, pollId, MakeMyExam.getUserId(), type);
            if (!filteredPollLocalResults.isEmpty()) {
                handlePollData(filteredPollLocalResults.get(0).getMsgData().toString());
            } else {
                Helper.showProgressDialog(this);
                ((APIInterface) MakeMyExamForPoll.getRetrofitInstance(this.liveChat.getPollSocketUrl()).create(APIInterface.class)).managePollNew(postData).enqueue(new Callback<String>() { // from class: com.appnew.android.player.VODPlayerActivity.75
                    @Override // retrofit2.Callback
                    public void onResponse(Call<String> call, Response<String> response) {
                        Helper.dismissProgressDialog();
                        if (response != null) {
                            try {
                                if (response.body() != null && !TextUtils.isEmpty(response.body())) {
                                    JSONObject jSONObject = new JSONObject(response.body().toString());
                                    String strOptString = jSONObject.has("type") ? jSONObject.optString("type") : "";
                                    String strOptString2 = jSONObject.has("status_code") ? jSONObject.optString("status_code") : "";
                                    if (VODPlayerActivity.this.isOperator) {
                                        if (!strOptString.equalsIgnoreCase("CREATE_POLL") && !strOptString.equalsIgnoreCase("POLL_ADDED")) {
                                            VODPlayerActivity.this.savePollResultInLocal(response.body(), strOptString, pollId, strOptString2);
                                        }
                                        VODPlayerActivity.this.handlePollData(response.body().toString());
                                        return;
                                    }
                                    if (strOptString.equalsIgnoreCase("CREATE_POLL") || strOptString.equalsIgnoreCase("POLL_ADDED")) {
                                        return;
                                    }
                                    VODPlayerActivity.this.savePollResultInLocal(response.body(), strOptString, pollId, strOptString2);
                                    VODPlayerActivity.this.handlePollData(response.body().toString());
                                    return;
                                }
                            } catch (Exception e2) {
                                VODPlayerActivity.this.showMessage(e2.getMessage().toString());
                                return;
                            }
                        }
                        VODPlayerActivity vODPlayerActivity = VODPlayerActivity.this;
                        vODPlayerActivity.showMessage(vODPlayerActivity.getString(R.string.no_data_found));
                    }

                    @Override // retrofit2.Callback
                    public void onFailure(Call<String> call, Throwable t) {
                        Helper.dismissProgressDialog();
                        VODPlayerActivity.this.showMessage(t.getMessage().toString());
                    }
                });
            }
        } catch (Exception e2) {
            Helper.dismissProgressDialog();
            showMessage(e2.getMessage().toString());
        }
    }

    public void savePollResultInLocal(String messages, String typeLocal, String pollId, String statusCode) {
        try {
            if (TextUtils.isEmpty(statusCode) || !statusCode.equals("10011") || TextUtils.isEmpty(pollId) || TextUtils.isEmpty(messages) || TextUtils.isEmpty(typeLocal)) {
                return;
            }
            if (typeLocal.equals("GET_POLL") || typeLocal.equals("GET_LEADERBOARD") || typeLocal.equals("GET_LEADERBOARD_VIDEOWISE")) {
                ArrayList<PollLocalResult> pollLoacalResultData = Helper.getPollLoacalResultData();
                PollLocalResult pollLocalResult = new PollLocalResult(this.video_id.toString(), MakeMyExam.getUserId(), pollId, typeLocal, messages);
                int i = 0;
                while (true) {
                    if (i >= pollLoacalResultData.size()) {
                        break;
                    }
                    PollLocalResult pollLocalResult2 = pollLoacalResultData.get(i);
                    if (this.video_id.toString().equals(pollLocalResult2.getVideoId()) && MakeMyExam.getUserId().equals(pollLocalResult2.getUserId()) && pollId.equals(pollLocalResult2.getPollId()) && typeLocal.equals(pollLocalResult2.getType())) {
                        pollLoacalResultData.remove(i);
                        break;
                    }
                    i++;
                }
                pollLoacalResultData.add(pollLocalResult);
                Helper.setPollLoacalResultData(pollLoacalResultData);
            }
        } catch (Exception e2) {
            Log.d("MQTT", "savePollResultInLocal: " + e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void manageDoubtAPI(java.lang.String r4, final java.lang.String r5) {
        /*
            r3 = this;
            com.appnew.android.Model.PlayerPojo.LiveChat r0 = r3.liveChat
            java.lang.String r0 = r0.getPollSocketUrl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L12
            java.lang.String r4 = "Base URL not found"
            r3.showMessage(r4)
            return
        L12:
            boolean r0 = com.appnew.android.Utils.Helper.isNetworkConnected(r3)
            if (r0 != 0) goto L27
            android.content.res.Resources r4 = r3.getResources()
            r5 = 2132017191(0x7f140027, float:1.9672653E38)
            java.lang.String r4 = r4.getString(r5)
            r3.showMessage(r4)
            return
        L27:
            com.appnew.android.Utils.Helper.showProgressDialog(r3)     // Catch: java.lang.Exception -> L83
            com.appnew.android.Model.PlayerPojo.LiveChat r0 = r3.liveChat     // Catch: java.lang.Exception -> L83
            java.lang.String r0 = r0.getPollSocketUrl()     // Catch: java.lang.Exception -> L83
            retrofit2.Retrofit r0 = com.appnew.android.Utils.MakeMyExamForPoll.getRetrofitInstance(r0)     // Catch: java.lang.Exception -> L83
            java.lang.Class<com.appnew.android.Utils.Network.APIInterface> r1 = com.appnew.android.Utils.Network.APIInterface.class
            java.lang.Object r0 = r0.create(r1)     // Catch: java.lang.Exception -> L83
            com.appnew.android.Utils.Network.APIInterface r0 = (com.appnew.android.Utils.Network.APIInterface) r0     // Catch: java.lang.Exception -> L83
            int r1 = r5.hashCode()     // Catch: java.lang.Exception -> L83
            r2 = -373161054(0xffffffffe9c203a2, float:-2.9318596E25)
            if (r1 == r2) goto L6a
            r2 = 540484787(0x203724b3, float:1.5512846E-19)
            if (r1 == r2) goto L5d
            r2 = 583898133(0x22cd9415, float:5.572215E-18)
            if (r1 == r2) goto L50
            goto L77
        L50:
            java.lang.String r1 = "SUBMIT_DOUBT"
            boolean r1 = r5.equals(r1)     // Catch: java.lang.Exception -> L83
            if (r1 == 0) goto L77
            retrofit2.Call r4 = r0.submitDoubts(r4)     // Catch: java.lang.Exception -> L83
            goto L78
        L5d:
            java.lang.String r1 = "GET_DOUBT"
            boolean r1 = r5.equals(r1)     // Catch: java.lang.Exception -> L83
            if (r1 == 0) goto L77
            retrofit2.Call r4 = r0.getDoubts(r4)     // Catch: java.lang.Exception -> L83
            goto L78
        L6a:
            java.lang.String r1 = "MANAGE_DOUBT"
            boolean r1 = r5.equals(r1)     // Catch: java.lang.Exception -> L83
            if (r1 == 0) goto L77
            retrofit2.Call r4 = r0.publishDoubts(r4)     // Catch: java.lang.Exception -> L83
            goto L78
        L77:
            r4 = 0
        L78:
            if (r4 == 0) goto L82
            com.appnew.android.player.VODPlayerActivity$76 r0 = new com.appnew.android.player.VODPlayerActivity$76     // Catch: java.lang.Exception -> L83
            r0.<init>()     // Catch: java.lang.Exception -> L83
            r4.enqueue(r0)     // Catch: java.lang.Exception -> L83
        L82:
            return
        L83:
            r4 = move-exception
            com.appnew.android.Utils.Helper.dismissProgressDialog()
            java.lang.String r4 = r4.getMessage()
            r3.showMessage(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.VODPlayerActivity.manageDoubtAPI(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDoubtData(final String messages, final String type) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleDoubtData$62(messages, type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleDoubtData$62(String str, String str2) {
        Log.i("Doubt", "onMessage " + str);
        String strOptString = this.doubtPublishStatus;
        String strOptString2 = "Something went wrong, Try again";
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("message") && !TextUtils.isEmpty(jSONObject.optString("message"))) {
                    strOptString2 = jSONObject.optString("message");
                }
                if (jSONObject.has("type") && !TextUtils.isEmpty(jSONObject.optString("type"))) {
                    strOptString = jSONObject.optString("type");
                }
                if (!TextUtils.isEmpty(str2)) {
                    int iHashCode = str2.hashCode();
                    if (iHashCode != -373161054) {
                        if (iHashCode != 540484787) {
                            if (iHashCode == 583898133 && str2.equals("SUBMIT_DOUBT")) {
                                try {
                                    this.isShowSubmit = false;
                                    handlePublishSubmitButton();
                                    showMessage(strOptString2);
                                    return;
                                } catch (Exception e2) {
                                    showMessage(e2.getMessage());
                                    return;
                                }
                            }
                        } else if (str2.equals("GET_DOUBT")) {
                            try {
                                DoubtResponse doubtResponse = (DoubtResponse) new Gson().fromJson(str, DoubtResponse.class);
                                List<DoubtItemData> data = doubtResponse.getData();
                                if (!TextUtils.isEmpty(doubtResponse.getState())) {
                                    this.doubtPublishStatus = doubtResponse.getState();
                                }
                                if (data != null) {
                                    setDoubtsData(data);
                                    return;
                                }
                                return;
                            } catch (Exception e3) {
                                showMessage(e3.getMessage());
                                return;
                            }
                        }
                    } else if (str2.equals("MANAGE_DOUBT")) {
                        try {
                            if (strOptString.equals("publishDoubt") || strOptString.equals("unPublishDoubt") || strOptString.equals("publishCompletedDoubt")) {
                                this.doubtPublishStatus = strOptString;
                            }
                            handlePublishSubmitButton();
                            return;
                        } catch (Exception e4) {
                            showMessage(e4.getMessage());
                            return;
                        }
                    }
                    showMessage(strOptString2);
                    return;
                }
                showMessage(strOptString2);
                return;
            } catch (Exception e5) {
                showMessage(e5.getMessage());
                return;
            }
        }
        showMessage("Something went wrong, Try again");
    }

    private void setDoubtsData(List<DoubtItemData> doubtItemList) {
        if (!doubtItemList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (DoubtItemData doubtItemData : doubtItemList) {
                if (!TextUtils.isEmpty(doubtItemData.getIs_upVoted()) && doubtItemData.getIs_upVoted().equalsIgnoreCase("1")) {
                    arrayList.add(doubtItemData);
                }
            }
            if (!arrayList.isEmpty()) {
                this.isShowSubmit = false;
            }
            manageButtonUI(false, false, false, false, false, false, true);
            handlePublishSubmitButton();
            this.isUserOnPoll = false;
            this.isUserOnDoubt = true;
            this.isclicked = "7";
            disableAll();
            ChatAdapter chatAdapter = this.chatAdapter;
            if (chatAdapter != null) {
                chatAdapter.pauseAudio();
            }
            if (this.recyclerChat.getAdapter() != null && (this.recyclerChat.getAdapter() instanceof ChatAdapter)) {
                ((ChatAdapter) this.recyclerChat.getAdapter()).stopMusic();
            }
            if ("publishDoubt".equals(this.doubtPublishStatus) || "publishCompletedDoubt".equals(this.doubtPublishStatus) || this.isOperator) {
                this.recyclerChat.setVisibility(0);
                this.goToCurrentRl.setVisibility(8);
                this.linearLayout.setVisibility(8);
                this.addBookmark.setVisibility(8);
                this.rl_pdf_data.setVisibility(8);
                this.chatMainRl.setVisibility(0);
                this.createPollNestedScrollView.setVisibility(8);
                this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
                DoubtVideoAdapter doubtVideoAdapter = new DoubtVideoAdapter(this, doubtItemList, this.doubtPublishStatus, this.isOperator, this.isShowSubmit);
                this.doubtVideoAdapter = doubtVideoAdapter;
                this.recyclerChat.setAdapter(doubtVideoAdapter);
            } else {
                this.recyclerChat.setVisibility(8);
                this.goToCurrentRl.setVisibility(8);
                this.linearLayout.setVisibility(8);
                this.addBookmark.setVisibility(8);
                this.rl_pdf_data.setVisibility(8);
                this.chatMainRl.setVisibility(0);
                this.createPollNestedScrollView.setVisibility(8);
            }
        } else {
            showMessage("No doubt found");
        }
        this.llEnableMarkAsRead.setVisibility(8);
    }

    private void handlePublishSubmitButton() {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handlePublishSubmitButton$63();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePublishSubmitButton$63() {
        if (this.isOperator) {
            this.unpublishtxt.setVisibility(8);
            this.forDoubtll.setVisibility(0);
            this.publishDoubts.setVisibility(0);
            this.refressDoubtRl.setVisibility(0);
            this.submitDoubts.setVisibility(this.isShowSubmit ? 0 : 8);
        } else {
            String str = this.doubtPublishStatus;
            str.hashCode();
            switch (str) {
                case "publishDoubt":
                    this.refressDoubtRl.setVisibility(8);
                    this.unpublishtxt.setVisibility(8);
                    this.forDoubtll.setVisibility(this.isShowSubmit ? 0 : 8);
                    this.publishDoubts.setVisibility(8);
                    this.submitDoubts.setVisibility(this.isShowSubmit ? 0 : 8);
                    break;
                case "publishCompletedDoubt":
                    this.unpublishtxt.setVisibility(8);
                    this.forDoubtll.setVisibility(8);
                    this.publishDoubts.setVisibility(8);
                    this.submitDoubts.setVisibility(8);
                    this.refressDoubtRl.setVisibility(8);
                    break;
                case "unPublishDoubt":
                    this.unpublishtxt.setVisibility(0);
                    this.forDoubtll.setVisibility(8);
                    this.publishDoubts.setVisibility(8);
                    this.submitDoubts.setVisibility(8);
                    this.refressDoubtRl.setVisibility(8);
                    break;
                default:
                    this.unpublishtxt.setVisibility(0);
                    this.forDoubtll.setVisibility(8);
                    this.publishDoubts.setVisibility(8);
                    this.submitDoubts.setVisibility(8);
                    this.refressDoubtRl.setVisibility(8);
                    break;
            }
        }
        handlePublishUnPublishButton();
    }

    private void handlePublishUnPublishButton() {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handlePublishUnPublishButton$64();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handlePublishUnPublishButton$64() {
        if ("publishDoubt".equals(this.doubtPublishStatus)) {
            TextView textView = this.publishTxt;
            if (textView != null) {
                textView.setText(getString(R.string.unPublishDoubt));
                return;
            }
            return;
        }
        if ("publishCompletedDoubt".equals(this.doubtPublishStatus)) {
            TextView textView2 = this.publishTxt;
            if (textView2 != null) {
                textView2.setText(getString(R.string.completed));
                return;
            }
            return;
        }
        TextView textView3 = this.publishTxt;
        if (textView3 != null) {
            textView3.setText(getString(R.string.publishDoubt));
        }
    }

    private void getAndUpdateDoubtList() {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(MakeMyExam.getUserId());
        encryptionData.setVideo_id(this.video_id);
        manageDoubtAPI(new Gson().toJson(encryptionData), "GET_DOUBT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmationDialog(String msg, final String type) {
        DialogUtils.makeDialog(this, "", msg, getResources().getString(R.string.confirm), getResources().getString(R.string.cancel), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda31
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public final void onOKClick() {
                this.f$0.lambda$showConfirmationDialog$65(type);
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda32
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public final void onCancelClick() {
                VODPlayerActivity.lambda$showConfirmationDialog$66();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConfirmationDialog$65(String str) {
        str.hashCode();
        if (!str.equals("manage")) {
            if (str.equals("submit")) {
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setUser_id(MakeMyExam.getUserId());
                encryptionData.setVideo_id(this.video_id);
                encryptionData.setUpvoted_key(this.doubtVideoAdapter.getSelectedDoubts());
                manageDoubtAPI(new Gson().toJson(encryptionData), "SUBMIT_DOUBT");
                return;
            }
            return;
        }
        String str2 = "publishDoubt";
        if ("publishDoubt".equals(this.doubtPublishStatus)) {
            str2 = "unPublishDoubt";
        } else {
            "unPublishDoubt".equals(this.doubtPublishStatus);
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setType(str2);
        encryptionData2.setId(MakeMyExam.getUserId());
        encryptionData2.setName(SharedPreference.getInstance().getLoggedInUser().getName());
        encryptionData2.setVideo_id(this.video_id);
        encryptionData2.setSetting_node(!TextUtils.isEmpty(this.liveChat.getSetting_node()) ? this.liveChat.getSetting_node() : "");
        manageDoubtAPI(new Gson().toJson(encryptionData2), "MANAGE_DOUBT");
    }

    public void openEmojiPopup() {
        TextView textView = this.loveImage;
        PopupWindow popupWindow = new PopupWindow(textView != null ? textView.getContext() : null);
        popupWindow.setFocusable(true);
        TextView textView2 = this.loveImage;
        View viewInflate = LayoutInflater.from(textView2 != null ? textView2.getContext() : null).inflate(R.layout.emoji_reaction_layout, (ViewGroup) null);
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        popupWindow.setContentView(viewInflate);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        int[] iArr = new int[2];
        this.loveImage.getLocationOnScreen(iArr);
        Size size = new Size(popupWindow.getContentView().getMeasuredWidth(), popupWindow.getContentView().getMeasuredHeight());
        TextView textView3 = this.loveImage;
        int i = iArr[0];
        int width = size.getWidth();
        TextView textView4 = this.loveImage;
        popupWindow.showAtLocation(textView3, 8388659, i - ((width - (textView4 != null ? textView4.getWidth() : 0)) / 2), iArr[1] - size.getHeight());
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.like_text);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.laugh_text);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.angry_text);
        TextView textView8 = (TextView) viewInflate.findViewById(R.id.love_text);
        TextView textView9 = (TextView) viewInflate.findViewById(R.id.sad_text);
        TextView textView10 = (TextView) viewInflate.findViewById(R.id.wow_text);
        onReactClick(textView5, popupWindow);
        onReactClick(textView6, popupWindow);
        onReactClick(textView7, popupWindow);
        onReactClick(textView8, popupWindow);
        onReactClick(textView9, popupWindow);
        onReactClick(textView10, popupWindow);
    }

    private void onReactClick(final TextView view, final PopupWindow popUp) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onReactClick$67(view, popUp, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReactClick$67(TextView textView, PopupWindow popupWindow, View view) {
        if (!Helper.isConnected(this)) {
            showMessage(getResources().getString(R.string.no_internet_connection));
        } else {
            reactClick(textView.getText().toString());
            timerForEmojiClick();
        }
        popupWindow.dismiss();
    }

    private void reactClick(String emoji) {
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setType("emojiReaction");
        encryptionData.setMessage(emoji);
        sendMessage(new Gson().toJson(encryptionData), true);
    }

    public Drawable emojiToDrawable(String emoji) {
        TextView textView = new TextView(this);
        textView.setTextSize(18.0f);
        textView.setText(emoji);
        textView.setTextColor(-16777216);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(textView.getMeasuredWidth(), textView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        textView.draw(new Canvas(bitmapCreateBitmap));
        return new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    public void showReactButton(final boolean isShow) {
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting == null || TextUtils.isEmpty(bottomSetting.getChat_reaction()) || !this.bottomSetting.getChat_reaction().equalsIgnoreCase("1")) {
            isShow = false;
        } else if (this.isOperator) {
            isShow = true;
        }
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showReactButton$68(isShow);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showReactButton$68(boolean z) {
        if (z) {
            this.endLayout.setVisibility(0);
            this.topImage.setVisibility(0);
            this.loveImage.setVisibility(0);
        } else {
            this.topImage.setVisibility(0);
            this.loveImage.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timerForEmojiClick() {
        if (!com.appnew.android.home.Constants.chatMsgTimerEnabled || this.isOperator) {
            return;
        }
        this.loveImage.setClickable(false);
        this.loveImage.setEnabled(false);
        Timer timer = new Timer();
        timer.schedule(new AnonymousClass77(new int[]{30}, timer), 1000L, 1000L);
    }

    /* JADX INFO: renamed from: com.appnew.android.player.VODPlayerActivity$77, reason: invalid class name */
    class AnonymousClass77 extends TimerTask {
        final /* synthetic */ int[] val$count;
        final /* synthetic */ Timer val$timer;

        AnonymousClass77(final int[] val$count, final Timer val$timer) {
            this.val$count = val$count;
            this.val$timer = val$timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final int[] iArr = this.val$count;
            iArr[0] = iArr[0] - 1;
            VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$77$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0(iArr);
                }
            });
            if (this.val$count[0] == 0) {
                this.val$timer.cancel();
                VODPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$77$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$1();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(int[] iArr) {
            VODPlayerActivity.this.loveImage.setClickable(false);
            VODPlayerActivity.this.loveImage.setEnabled(false);
            VODPlayerActivity.this.loveImage.setTextSize(0, VODPlayerActivity.this.getResources().getDimension(R.dimen.text_reaction_small));
            TextView textView = VODPlayerActivity.this.loveImage;
            int i = iArr[0];
            textView.setText(i >= 10 ? String.valueOf(i) : "0" + iArr[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            VODPlayerActivity.this.loveImage.setEnabled(true);
            VODPlayerActivity.this.loveImage.setClickable(true);
            VODPlayerActivity.this.loveImage.setTextSize(0, VODPlayerActivity.this.getResources().getDimension(R.dimen.text_reaction_large));
            VODPlayerActivity.this.loveImage.setText("❤️");
        }
    }

    public void makeFlyAnimation(Drawable drawable) {
        try {
            final ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(drawable);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(15);
            this.topImage.addView(imageView, layoutParams);
            int randomstartX = getRandomstartX(this.topImage.getWidth() > 80 ? this.topImage.getWidth() - 80 : this.topImage.getWidth());
            int height = this.topImage.getHeight();
            imageView.setX(randomstartX);
            float f2 = height - 80;
            imageView.setY(f2);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "y", f2, height - 880);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(2000L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.5f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 1.5f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setDuration(2000L);
            objectAnimatorOfFloat3.setDuration(2000L);
            objectAnimatorOfFloat4.setDuration(1000L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            animatorSet.start();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.player.VODPlayerActivity.78
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    VODPlayerActivity.this.topImage.removeView(imageView);
                }
            });
        } catch (Exception e2) {
            Log.d("MQTT", "makeFlyAnimation: " + e2.getMessage());
        }
    }

    public int getRandomstartX(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : bound;
    }

    private void pushEvent() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map.put(AnalyticsConstants.course_content_name, !TextUtils.isEmpty(this.video_name) ? this.video_name : "NA");
        map.put("action_type", "joined_live_class");
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.CLASS_PARTICIPATION, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openChooseMediaBottomSheet() {
        Utils.INSTANCE.openChooseMediaBottomSheet(this, new Function0() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$openChooseMediaBottomSheet$69();
            }
        }, new Function0() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$openChooseMediaBottomSheet$70();
            }
        }, new Function0() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$openChooseMediaBottomSheet$71();
            }
        }, new Function0() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$openChooseMediaBottomSheet$72();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$openChooseMediaBottomSheet$69() {
        return Boolean.valueOf(Helper.isNetworkConnected(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openChooseMediaBottomSheet$70() {
        checkStoragePermission();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openChooseMediaBottomSheet$71() {
        this.STORAGE_PERMISSION_TYPE = 3;
        checkStoragePermission2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openChooseMediaBottomSheet$72() {
        showMessage(getResources().getString(R.string.please_connect_internet_connection));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isActivityVisible() {
        return isUserActive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$73(Boolean bool) {
        if (bool.booleanValue()) {
            PdfUtils.INSTANCE.downloadAndSavePdf(this, this.url, this.pdfViewPager, this.progress_bar_pdf);
        } else {
            showMessage("Permission denied!");
        }
    }

    private void startAutoFeedbackTimer() {
        this.feedbackHandler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startAutoFeedbackTimer$74();
            }
        };
        this.autoFeedbackRunnable = runnable;
        this.feedbackHandler.postDelayed(runnable, this.FEEDBACK_AUTO_TRIGGER_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAutoFeedbackTimer$74() {
        showAutoFeedback();
        Handler handler = this.feedbackHandler;
        if (handler != null) {
            handler.removeCallbacks(this.autoFeedbackRunnable);
            this.feedbackHandler = null;
            this.autoFeedbackRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAutoFeedback() {
        if (this.isOperator || this.isReviewSubmitted || !isShowFeedback()) {
            return;
        }
        this.isFeedbackShown = true;
        openFeedbackBottomSheet();
    }

    private void showFeedbackOnBack() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.activityStartTime;
        if (!this.isOperator && !this.isReviewSubmitted && isShowFeedback() && !this.isFeedbackShown) {
            long j = this.FEEDBACK_MIN_WATCH_TIME;
            if (j > 0 && jCurrentTimeMillis >= j) {
                this.isFeedbackOpenByBack = true;
                openFeedbackBottomSheet();
                return;
            }
        }
        finish();
    }

    private void manageFeedbackButton() {
        this.video_feedback.setVisibility(isShowFeedback() ? 0 : 8);
        ImageView imageView = this.video_feedback;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.video_feedback.setImageResource(this.isReviewSubmitted ? R.drawable.review_fill : R.drawable.review_unfill);
        }
        ((ImageView) Objects.requireNonNull(this.video_feedback)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$manageFeedbackButton$75(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$manageFeedbackButton$75(View view) {
        if (!Helper.isConnected(this)) {
            showMessage(getResources().getString(R.string.please_connect_internet_connection));
            return;
        }
        if (this.isOperator) {
            showMessage("Operator can not submit feedback.");
        } else if (this.isReviewSubmitted) {
            showMessage(getResources().getString(R.string.feedback_already_submitted));
        } else {
            openFeedbackBottomSheet();
        }
    }

    private void openFeedbackBottomSheet() {
        try {
            if (!isFinishing() && !isDestroyed() && !this.isFeedbackOpen && SystemClock.elapsedRealtime() - this.mLastClickTime >= 1000) {
                this.mLastClickTime = SystemClock.elapsedRealtime();
                this.isFeedbackOpen = true;
                this.feedbackDialog[0] = new Utils.FeedbackBottomSheetDialog(this, new Utils.FeedbackBottomSheetDialog.Listener() { // from class: com.appnew.android.player.VODPlayerActivity.79
                    @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
                    public void onClose() {
                        VODPlayerActivity.this.feedbackDialogDismiss(false);
                    }

                    @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
                    public void onSubmit() {
                        RatingBar ratingBar = (RatingBar) VODPlayerActivity.this.feedbackDialog[0].findViewById(R.id.ratingBar);
                        EditText editText = (EditText) VODPlayerActivity.this.feedbackDialog[0].findViewById(R.id.ratingComment);
                        VODPlayerActivity.this.rating = String.valueOf(ratingBar != null ? ratingBar.getRating() : 0.0f);
                        VODPlayerActivity.this.ratingMessage = editText != null ? editText.getText().toString().trim() : "";
                        if ((ratingBar != null ? ratingBar.getRating() : 0.0f) <= 0.0f) {
                            VODPlayerActivity.this.showMessage("Please select rating!");
                        } else if (VODPlayerActivity.this.ratingMessage.isEmpty()) {
                            VODPlayerActivity.this.showMessage("Please write feedback!");
                        } else {
                            VODPlayerActivity.this.networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", true, false);
                        }
                    }
                });
                Utils.INSTANCE.bottomSheet(new Utils.FeedbackBottomSheetDialog[]{this.feedbackDialog[0]});
                this.feedbackDialog[0].show();
            }
        } catch (Exception unused) {
            Log.d("TAG", "openFeedbackBottomSheet: ${e.message}");
        }
    }

    void feedbackDialogDismiss(boolean isOnSubmit) {
        try {
            this.isFeedbackOpen = false;
            Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = this.feedbackDialog[0];
            if (feedbackBottomSheetDialog != null && feedbackBottomSheetDialog.isShowing()) {
                this.feedbackDialog[0].dismiss();
            }
            if (isOnSubmit) {
                Utils.INSTANCE.showGreetingDialog(this, "Thank’s for your valuable feedback !", this.isFeedbackOpenByBack ? new Utils.DialogDismissCallback() { // from class: com.appnew.android.player.VODPlayerActivity$$ExternalSyntheticLambda23
                    @Override // com.appnew.android.player.music_player.Utils.DialogDismissCallback
                    public final void onDismiss() {
                        this.f$0.finish();
                    }
                } : null);
            } else if (this.isFeedbackOpenByBack) {
                finish();
            }
            this.isFeedbackOpenByBack = false;
        } catch (Exception e2) {
            androidx.media3.common.util.Log.d("TAG", "feedbackDialogDismiss: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowFeedback() {
        String string = SharedPreference.getInstance().getString(Const.LIVE_CLASS_FEEDBACK);
        return !TextUtils.isEmpty(string) && string.equalsIgnoreCase("1");
    }

    public String getDrmLicenseUrl() {
        if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.DRM_LICENSE_URL))) {
            return SharedPreference.getInstance().getString(Const.DRM_LICENSE_URL);
        }
        return "https://license.videocrypt.com/validateLicense";
    }
}
