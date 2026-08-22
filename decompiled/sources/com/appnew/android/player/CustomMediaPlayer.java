package com.appnew.android.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
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
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.core.layout.WindowSizeClass;
import com.appnew.android.Courses.Modal.OnlineUser;
import com.appnew.android.Download.Audio.AudioPlayerService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Bookmark;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.PlayerPojo.Addindex;
import com.appnew.android.Model.PlayerPojo.Metadata;
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
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.imagecropper.TakeImageClass;
import com.appnew.android.home.Constants;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionDialog;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.appnew.android.table.YoutubePlayerTable;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptionsKt;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.network.connectionclass.ConnectionQuality;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.joda.time.DateTimeConstants;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CustomMediaPlayer extends AppCompatActivity implements AmazonCallBack, TakeImageClass.imagefromcropper, NetworkCall.MyNetworkCallBack {
    private static DefaultBandwidthMeter BANDWIDTH_METER;
    private static int newOrientation;
    private static long playPosition;
    private static String youtubeUri;
    private Activity activity;
    private Adapter_recycleveiw_vedio adapter;
    TextView addBookmark;
    ImageView audiocaetimage;
    private BookmarkAdapter bookmarkAdapter;
    TextView bookmarkBtn;
    ChatAdapter chatAdapter;
    private ImageView chatAddButton;
    TextView chat_btn;
    LinearLayout chatlayout;
    ChildEventListener childEventListener;
    DataSource.Factory dataSourceFactory;
    EditText etMessage;
    TextView floatingText;
    ChildEventListener getchatdata;
    Bitmap image;
    private boolean inErrorState;
    TextView indexBtn;
    private boolean isShowingTrackSelectionDialog;
    private String isaudio;
    private String islive;
    String islockedback;
    ImageView ivSend;
    LinearLayout linearLayout;
    LinearLayout llll;
    private DatabaseReference mFirebaseDatabaseReference1;
    private DatabaseReference mFirebaseDatabaseReferenceone2many;
    private DatabaseReference mFirebaseDatabaseReferenceone2one;
    private DatabaseReference mFirebaseDatabaseReferencepolldata;
    private FrameLayout mFullScreenButton;
    private Dialog mFullScreenDialog;
    private ImageView mFullScreenIcon;
    private DataSource.Factory mediaDataSourceFactory;
    MediaSource mediaSource;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    NetworkCall networkCall;
    private TextView notes;
    private NotesAdapter notesAdapter;
    private ExoPlayer player;
    private TextView poll;
    public PollAdapter pollAdapter;
    int pos;
    ProgressBar progressBar;
    ImageView quality;
    Query query;
    private RecyclerView recyclerChat;
    DatabaseReference rootRef;
    View rootView;
    private s3ImageUploading s3IU;
    private int savedOrientation;
    private List<Integer> sparseAdaptiveResolutionList;
    private HashMap<Integer, String> sparseAdaptiveVideoUrlList;
    private List<Integer> sparseKeyList;
    private List<Integer> sparseMuxedResolutionList;
    private HashMap<Integer, String> sparseMuxedVideoUrlList;
    private List<String> sparseOPUSAudioUrl;
    private TextView speedTV;
    String thumbnailurl;
    private TrackSelectionHelper trackSelectionHelper;
    DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    private TextView tvGoLive;
    private String userAgent;
    UtkashRoom utkashRoom;
    ValueEventListener valueEventListener;
    String video_id;
    String video_name;
    TextView video_name_text;
    String isclicked = "";
    private String deletedindex = "";
    String str_imgTypeClick = "";
    int requestCode = -1;
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    public boolean ischatload = false;
    String audio_url = "";
    String vodliveyoutuveurl = "0";
    private ConnectionQuality mConnectionClass = ConnectionQuality.UNKNOWN;
    String url = "";
    ArrayList<chatPojo> arrChat = new ArrayList<>();
    ArrayList<chatPojo> pollarr = new ArrayList<>();
    ArrayList<Polldata> pollarraylist = new ArrayList<>();
    String speedx = "";
    private boolean mExoPlayerFullscreen = false;
    private final String STATE_PLAYER_FULLSCREEN = "playerFullscreen";
    public boolean isActivityLive = false;
    private List<VideoTimeFramePojo> indexdata = new ArrayList();
    ArrayList<chatPojo> lockarr = new ArrayList<>();
    private List<VideoTimeFramePojo> bookmarkdata = new ArrayList();
    private List<Pdf> pdf = new ArrayList();
    private String time = "";

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private String f326info = "";
    private String state = "";
    String Chat_node = "";
    String course_id = "";
    String tileid = "";
    String tiletype = "";
    String position = "";
    String parentid = "";
    private boolean isintractavailable = false;
    String link = "";
    int lastseleted = -1;
    String checkstatus = "";
    String islocked = "0";
    float total = 0.0f;
    float attempt_1_count = 0.0f;
    float attempt_2_count = 0.0f;
    float attempt_3_count = 0.0f;
    float attempt_4_count = 0.0f;
    private ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda12
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$11((CropImageView.CropResult) obj);
        }
    });
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$12((ActivityResult) obj);
        }
    });

    private void extractYoutubeUrl(String url) {
    }

    private int getLiveIndexResolution(int index) {
        switch (index) {
            case 1:
                return 240;
            case 2:
                return CropImageOptionsKt.DEGREES_360;
            case 3:
                return WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND;
            case 4:
                return 720;
            case 5:
                return 1080;
            case 6:
                return DateTimeConstants.MINUTES_PER_DAY;
            default:
                return 144;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    private void releasePlayer() {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.imagecropper.TakeImageClass.imagefromcropper
    public void imagePath(String str) {
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_custom_media_player);
        this.activity = this;
        getWindow().setFlags(1024, 1024);
        youtubeUri = "";
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        if (getIntent().getExtras() != null) {
            this.url = getIntent().getExtras().getString(Const.VIDEO_LINK);
            this.islive = getIntent().getExtras().getString("live");
            this.isaudio = getIntent().getExtras().getString("isaudio");
            this.thumbnailurl = "http://img.youtube.com/vi/" + this.url + "/0.jpg";
            this.video_id = getIntent().getStringExtra(Const.VIDEO_ID);
            this.video_name = getIntent().getStringExtra("video_name");
            this.Chat_node = getIntent().getStringExtra("Chat_node");
            this.islockedback = getIntent().getStringExtra("islocked");
            this.course_id = getIntent().getStringExtra("courseid");
            this.parentid = getIntent().getStringExtra(Const.shareparentid);
            this.tileid = getIntent().getStringExtra("tileid");
            this.tiletype = getIntent().getStringExtra("tiletype");
        }
        BANDWIDTH_METER = new DefaultBandwidthMeter.Builder(this).build();
        if (MakeMyExam.userId.equalsIgnoreCase("") || MakeMyExam.userId.equalsIgnoreCase("0")) {
            MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
            MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
        }
        this.networkCall = new NetworkCall(this, this);
        if (savedInstanceState != null) {
            this.mExoPlayerFullscreen = savedInstanceState.getBoolean("playerFullscreen");
        }
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.quality = (ImageView) findViewById(R.id.quality);
        this.rootView = findViewById(R.id.root_new);
        this.ivSend = (ImageView) findViewById(R.id.iv_send);
        this.llll = (LinearLayout) findViewById(R.id.llll);
        this.etMessage = (EditText) findViewById(R.id.et_message);
        this.chatAddButton = (ImageView) findViewById(R.id.chatAddButton);
        this.recyclerChat = (RecyclerView) findViewById(R.id.recycler_view);
        this.bookmarkBtn = (TextView) findViewById(R.id.bookmark_btn);
        this.linearLayout = (LinearLayout) findViewById(R.id.bottomlayout);
        this.chatlayout = (LinearLayout) findViewById(R.id.linearLayout);
        this.addBookmark = (TextView) findViewById(R.id.add_bookmark);
        this.indexBtn = (TextView) findViewById(R.id.index_btn);
        this.chat_btn = (TextView) findViewById(R.id.chat_btn);
        this.notes = (TextView) findViewById(R.id.notes);
        this.poll = (TextView) findViewById(R.id.poll);
        this.floatingText = (TextView) findViewById(R.id.floatingText_new);
        TextView textView = (TextView) findViewById(R.id.video_name);
        this.video_name_text = textView;
        textView.setSelected(true);
        this.video_name_text.setText(this.video_name);
        this.floatingText.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        this.floatingText.measure(0, 0);
        this.floatingText.setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.player.CustomMediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                CustomMediaPlayer.this.blink();
            }
        }, 3000L);
        this.userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference != null) {
            databaseReference.removeEventListener(this.valueEventListener);
            Query query = this.query;
            if (query != null) {
                query.removeEventListener(this.childEventListener);
            }
        }
        this.trackSelectorParameters = new DefaultTrackSelector.ParametersBuilder().build();
        hit_api_for_meta();
        hit_api_for_video_link();
        initFullscreenDialog();
        try {
            new OrientationEventListener(getApplicationContext()) { // from class: com.appnew.android.player.CustomMediaPlayer.2
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    try {
                        if (Settings.System.getInt(CustomMediaPlayer.this.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            boolean zIsPortrait = CustomMediaPlayer.this.isPortrait(orientation);
                            if (!zIsPortrait && CustomMediaPlayer.this.savedOrientation == 1) {
                                CustomMediaPlayer.this.savedOrientation = 0;
                                CustomMediaPlayer.this.setRequestedOrientation(2);
                            } else if (zIsPortrait && CustomMediaPlayer.this.savedOrientation == 0) {
                                CustomMediaPlayer.this.savedOrientation = 1;
                                CustomMediaPlayer.this.setRequestedOrientation(2);
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
        this.poll.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.indexBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$1();
            }
        }));
        this.chat_btn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CustomMediaPlayer.this.setchat();
            }
        });
        this.notes.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$2();
            }
        }));
        this.bookmarkBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$3();
            }
        }));
        this.chatAddButton.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CustomMediaPlayer.this.checkStoragePermission();
            }
        });
        findViewById(R.id.quality).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$5();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        setPoll();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        setIndex();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2() {
        setNotes();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$3() {
        setBookMark();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$5() {
        if (this.islive.equalsIgnoreCase("1")) {
            if (this.sparseAdaptiveResolutionList != null && this.player != null) {
                showAlertDialog();
            } else {
                Toast.makeText(this, getResources().getString(R.string.no_quality_found_till_yet), 0).show();
            }
        } else if (this.islive.equalsIgnoreCase("4")) {
            List<Integer> list = this.sparseAdaptiveResolutionList;
            if (list == null || list.size() == 0) {
                DefaultTrackSelector defaultTrackSelector = this.trackSelector;
                if (defaultTrackSelector != null && defaultTrackSelector.getCurrentMappedTrackInfo() != null) {
                    if (this.trackSelector.getCurrentMappedTrackInfo() != null) {
                        this.isShowingTrackSelectionDialog = true;
                        TrackSelectionDialog.createForTrackSelector(this.trackSelector, new DialogInterface.OnDismissListener() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.f$0.lambda$onCreate$4(dialogInterface);
                            }
                        }).show(getSupportFragmentManager(), (String) null);
                    }
                } else {
                    Toast.makeText(this, getResources().getString(R.string.player_not_ready_try_again), 0).show();
                }
            } else if (this.sparseAdaptiveResolutionList != null && this.player != null) {
                showAlertDialogLive();
            } else {
                Toast.makeText(this, getResources().getString(R.string.no_quality_found_till_yet), 0).show();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(DialogInterface dialogInterface) {
        this.isShowingTrackSelectionDialog = false;
    }

    private void showAlertDialogLive() {
        final int[] iArr = {-1};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.select_track));
        String[] strArr = new String[this.sparseAdaptiveResolutionList.size()];
        for (int i = 0; i < this.sparseAdaptiveResolutionList.size(); i++) {
            strArr[i] = String.valueOf(this.sparseAdaptiveResolutionList.get(i) + "p");
        }
        int i2 = this.lastseleted;
        if (i2 == -1) {
            i2 = 0;
        }
        builder.setSingleChoiceItems(strArr, i2, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                iArr[0] = which;
                CustomMediaPlayer.this.lastseleted = which;
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                CustomMediaPlayer.playPosition = CustomMediaPlayer.this.player.getCurrentPosition();
                if (iArr[0] == -1) {
                    CustomMediaPlayer customMediaPlayer = CustomMediaPlayer.this;
                    Toast.makeText(customMediaPlayer, customMediaPlayer.getResources().getString(R.string.please_change_quality_first), 0).show();
                    return;
                }
                if (CustomMediaPlayer.this.player != null) {
                    CustomMediaPlayer.this.player.release();
                    CustomMediaPlayer.this.player = null;
                }
                CustomMediaPlayer customMediaPlayer2 = CustomMediaPlayer.this;
                customMediaPlayer2.Loadyoutubeurl((String) customMediaPlayer2.sparseAdaptiveVideoUrlList.get(CustomMediaPlayer.this.sparseAdaptiveResolutionList.get(iArr[0])));
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                CustomMediaPlayer.this.resumePlayer();
                dialog.cancel();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    private void hit_api_for_meta() {
        this.networkCall.NetworkAPICall(API.get_meta, "", false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStoragePermission() {
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.CustomMediaPlayer.8
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                CustomMediaPlayer.this.imgClick();
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    private void hit_api_for_video_link() {
        this.networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setchat() {
        this.isclicked = "1";
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
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
        this.chat_btn.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.chat_btn.setTextColor(getResources().getColor(android.R.color.black));
    }

    private void showAlertDialog() {
        if (this.vodliveyoutuveurl.equalsIgnoreCase("0")) {
            final int[] iArr = {-1};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.select_track));
            String[] strArr = new String[this.sparseAdaptiveResolutionList.size()];
            for (int i = 0; i < this.sparseAdaptiveResolutionList.size(); i++) {
                strArr[i] = String.valueOf(this.sparseAdaptiveResolutionList.get(i) + "p");
            }
            int size = this.lastseleted;
            if (size == -1) {
                size = this.sparseAdaptiveResolutionList.size() - 1;
            }
            builder.setSingleChoiceItems(strArr, size, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    iArr[0] = which;
                    CustomMediaPlayer.this.lastseleted = which;
                }
            });
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    CustomMediaPlayer.playPosition = CustomMediaPlayer.this.player.getCurrentPosition();
                    if (iArr[0] == -1) {
                        CustomMediaPlayer customMediaPlayer = CustomMediaPlayer.this;
                        Toast.makeText(customMediaPlayer, customMediaPlayer.getResources().getString(R.string.please_change_quality_first), 0).show();
                        return;
                    }
                    if (CustomMediaPlayer.this.player != null) {
                        CustomMediaPlayer.this.player.release();
                        CustomMediaPlayer.this.player = null;
                    }
                    CustomMediaPlayer customMediaPlayer2 = CustomMediaPlayer.this;
                    customMediaPlayer2.Loadyoutubeurl((String) customMediaPlayer2.sparseAdaptiveVideoUrlList.get(CustomMediaPlayer.this.sparseAdaptiveResolutionList.get(iArr[0])));
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    CustomMediaPlayer.this.resumePlayer();
                    dialog.cancel();
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
            return;
        }
        final int[] iArr2 = {-1};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle(getResources().getString(R.string.select_track));
        String[] strArr2 = new String[this.sparseAdaptiveResolutionList.size()];
        for (int i2 = 0; i2 < this.sparseAdaptiveResolutionList.size(); i2++) {
            strArr2[i2] = String.valueOf(this.sparseAdaptiveResolutionList.get(i2) + "p");
        }
        int i3 = this.lastseleted;
        if (i3 == -1) {
            i3 = 0;
        }
        builder2.setSingleChoiceItems(strArr2, i3, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                iArr2[0] = which;
                CustomMediaPlayer.this.lastseleted = which;
            }
        });
        builder2.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                CustomMediaPlayer.playPosition = CustomMediaPlayer.this.player.getCurrentPosition();
                if (iArr2[0] == -1) {
                    CustomMediaPlayer customMediaPlayer = CustomMediaPlayer.this;
                    Toast.makeText(customMediaPlayer, customMediaPlayer.getResources().getString(R.string.please_change_quality_first), 0).show();
                    return;
                }
                if (CustomMediaPlayer.this.player != null) {
                    CustomMediaPlayer.this.player.release();
                    CustomMediaPlayer.this.player = null;
                }
                CustomMediaPlayer customMediaPlayer2 = CustomMediaPlayer.this;
                customMediaPlayer2.Loadyoutubeurl((String) customMediaPlayer2.sparseAdaptiveVideoUrlList.get(CustomMediaPlayer.this.sparseAdaptiveResolutionList.get(iArr2[0])));
            }
        });
        builder2.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                CustomMediaPlayer.this.resumePlayer();
                dialog.cancel();
            }
        });
        AlertDialog alertDialogCreate2 = builder2.create();
        alertDialogCreate2.setCanceledOnTouchOutside(false);
        alertDialogCreate2.show();
    }

    private void setNotes() {
        this.isclicked = "4";
        this.linearLayout.setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        this.notes.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.notes.setTextColor(getResources().getColor(android.R.color.black));
        setNotesAdapter();
    }

    private void setPoll() {
        this.isclicked = "5";
        this.linearLayout.setVisibility(8);
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        this.poll.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.poll.setTextColor(getResources().getColor(android.R.color.black));
        this.poll.setText(getResources().getString(R.string.poll));
        setpollAdapter();
    }

    private void setpollAdapter() {
        PollAdapter pollAdapter = new PollAdapter(this, this.pollarraylist);
        this.pollAdapter = pollAdapter;
        this.recyclerChat.setAdapter(pollAdapter);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        try {
            boolean z = true;
            if (newConfig.orientation == 1) {
                this.mExoPlayerFullscreen = false;
                this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
                this.video_name_text.setVisibility(0);
                if (this.isclicked.equalsIgnoreCase("1")) {
                    if (this.lockarr.size() > 0) {
                        if (this.islocked.equalsIgnoreCase("1")) {
                            this.linearLayout.setVisibility(0);
                            this.chatlayout.setVisibility(0);
                        } else {
                            this.linearLayout.setVisibility(8);
                            this.chatlayout.setVisibility(8);
                        }
                    } else if (this.islockedback.equalsIgnoreCase("1")) {
                        this.linearLayout.setVisibility(8);
                        this.chatlayout.setVisibility(8);
                    } else {
                        this.linearLayout.setVisibility(0);
                        this.chatlayout.setVisibility(0);
                    }
                }
                if (this.isclicked.equalsIgnoreCase("2")) {
                    this.linearLayout.setVisibility(0);
                    this.addBookmark.setVisibility(0);
                }
                getWindow().clearFlags(1024);
                float f2 = getResources().getDisplayMetrics().density;
                if ((getResources().getConfiguration().screenLayout & 15) != 4) {
                    z = false;
                }
                this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ((f2 * ((getResources().getConfiguration().screenLayout & 15) == 3 ? 350.0f : z ? 450.0f : 230.0f)) + 0.5f)));
                return;
            }
            this.mExoPlayerFullscreen = true;
            this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
            this.video_name_text.setVisibility(8);
            this.chatlayout.setVisibility(8);
            this.addBookmark.setVisibility(8);
            this.linearLayout.setVisibility(8);
            getWindow().setFlags(1024, 1024);
            this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.player.getPlaybackState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.CustomMediaPlayer.15
                @Override // com.google.firebase.database.ValueEventListener
                public void onCancelled(DatabaseError databaseError) {
                }

                @Override // com.google.firebase.database.ValueEventListener
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() == null) {
                        CustomMediaPlayer.this.mFirebaseDatabaseReference1.setValue(new OnlineUser(SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "true", MakeMyExam.userId, SharedPreference.getInstance().getLoggedInUser().getMobile(), "0", MakeMyExam.getTime_server()));
                    } else {
                        CustomMediaPlayer.this.mFirebaseDatabaseReference1.child("online").setValue("true");
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

    private void fireBaseOperation() {
        this.mFirebaseDatabaseReferenceone2many = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TOM/");
        this.mFirebaseDatabaseReferenceone2one = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        ValueEventListener valueEventListener = new ValueEventListener() { // from class: com.appnew.android.player.CustomMediaPlayer.16
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null) {
                    CustomMediaPlayer.this.checkstatus = "1";
                    CustomMediaPlayer.this.getupdatedchatdata(MakeMyExam.getTime_server());
                    return;
                }
                try {
                    Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                    while (it.hasNext()) {
                        chatPojo chatpojo = (chatPojo) it.next().getValue(chatPojo.class);
                        if (!chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                            CustomMediaPlayer.this.arrChat.add(chatpojo);
                            CustomMediaPlayer.this.pollarr.add(chatpojo);
                        } else {
                            if (chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                                CustomMediaPlayer.this.lockarr.add(chatpojo);
                            }
                            CustomMediaPlayer.this.pollarr.add(chatpojo);
                        }
                        CustomMediaPlayer.this.chatAdapter.notifyDataSetChanged();
                    }
                    CustomMediaPlayer.this.recyclerChat.smoothScrollToPosition(CustomMediaPlayer.this.arrChat.size());
                    CustomMediaPlayer.this.checkstatus = "1";
                    CustomMediaPlayer customMediaPlayer = CustomMediaPlayer.this;
                    customMediaPlayer.getupdatedchatdata(customMediaPlayer.pollarr.get(CustomMediaPlayer.this.pollarr.size() - 1).getDate());
                    if (CustomMediaPlayer.this.lockarr.size() > 0) {
                        if (CustomMediaPlayer.this.lockarr.get(CustomMediaPlayer.this.lockarr.size() - 1).getMessage().equalsIgnoreCase("0")) {
                            CustomMediaPlayer.this.islocked = "1";
                            CustomMediaPlayer.this.showchat();
                        } else {
                            CustomMediaPlayer.this.islocked = "2";
                            CustomMediaPlayer.this.hidechat();
                        }
                    }
                } catch (Exception unused) {
                    CustomMediaPlayer customMediaPlayer2 = CustomMediaPlayer.this;
                    Toast.makeText(customMediaPlayer2, customMediaPlayer2.getResources().getString(R.string.null_pointer_exception), 0).show();
                }
            }
        };
        this.valueEventListener = valueEventListener;
        this.mFirebaseDatabaseReferenceone2one.addListenerForSingleValueEvent(valueEventListener);
        this.mFirebaseDatabaseReferenceone2one.limitToLast(500);
        this.ivSend.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Helper.isConnected(CustomMediaPlayer.this)) {
                    if (!CustomMediaPlayer.this.etMessage.getText().toString().trim().equals("")) {
                        if (!CustomMediaPlayer.this.isintractavailable) {
                            CustomMediaPlayer.this.checkintract();
                        }
                        chatPojo chatpojo = new chatPojo(MakeMyExam.userId, CustomMediaPlayer.this.etMessage.getText().toString(), SharedPreference.getInstance().getLoggedInUser().getName(), System.currentTimeMillis(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", "text", CustomMediaPlayer.this.course_id);
                        CustomMediaPlayer.this.mFirebaseDatabaseReferenceone2one.push().setValue(chatpojo);
                        CustomMediaPlayer.this.mFirebaseDatabaseReferenceone2many.push().setValue(chatpojo);
                        CustomMediaPlayer.this.etMessage.setText("");
                        Helper.hideKeyboard(CustomMediaPlayer.this);
                        return;
                    }
                    Helper.showSnackBar(CustomMediaPlayer.this.ivSend, "Please enter your query first.");
                    return;
                }
                Helper.showSnackBar(CustomMediaPlayer.this.ivSend, "Please connect internet first.");
            }
        });
        this.arrChat.clear();
        this.chatAdapter = new ChatAdapter(this, "", this.arrChat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(false);
        this.recyclerChat.setLayoutManager(linearLayoutManager);
        this.recyclerChat.setAdapter(this.chatAdapter);
    }

    public void getupdatedchatdata(long actualdate) {
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/1TO1/" + MakeMyExam.userId);
        this.rootRef = databaseReferenceChild;
        this.query = databaseReferenceChild.orderByChild("date").startAt(actualdate);
        ChildEventListener childEventListener = new ChildEventListener() { // from class: com.appnew.android.player.CustomMediaPlayer.18
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
                if (CustomMediaPlayer.this.checkstatus.equalsIgnoreCase("1")) {
                    CustomMediaPlayer.this.chatAdapter.notifyDataSetChanged();
                    CustomMediaPlayer.this.recyclerChat.smoothScrollToPosition(CustomMediaPlayer.this.arrChat.size());
                    try {
                        chatPojo chatpojo = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                        if (chatpojo.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                            if (CustomMediaPlayer.this.pollarraylist.size() == 0) {
                                CustomMediaPlayer.this.getpolldatawithid(chatpojo.getFirebase_id());
                            }
                        } else if (chatpojo.getType().equalsIgnoreCase("is_chat_locked")) {
                            if (CustomMediaPlayer.this.lockarr.size() == 0) {
                                if (chatpojo.getMessage().equalsIgnoreCase("0")) {
                                    CustomMediaPlayer.this.islocked = "1";
                                    CustomMediaPlayer.this.showchat();
                                    CustomMediaPlayer.this.lockarr.add(chatpojo);
                                } else {
                                    CustomMediaPlayer.this.islocked = "2";
                                    CustomMediaPlayer.this.hidechat();
                                    CustomMediaPlayer.this.lockarr.add(chatpojo);
                                }
                            }
                        } else if (CustomMediaPlayer.this.arrChat.size() == 0) {
                            CustomMediaPlayer.this.arrChat.add(chatpojo);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    CustomMediaPlayer.this.checkstatus = "0";
                    return;
                }
                if (dataSnapshot == null) {
                    return;
                }
                try {
                    chatPojo chatpojo2 = (chatPojo) dataSnapshot.getValue(chatPojo.class);
                    if (chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL)) {
                        if (chatpojo2.getIs_active().equalsIgnoreCase("2")) {
                            for (int i = 0; i < CustomMediaPlayer.this.pollarraylist.size(); i++) {
                                if (CustomMediaPlayer.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(chatpojo2.getFirebase_id())) {
                                    CustomMediaPlayer.this.pollarraylist.get(i).setStatus("2");
                                    CustomMediaPlayer.this.pollAdapter.notifyDataSetChanged();
                                    CustomMediaPlayer.this.poll.setText(CustomMediaPlayer.this.getResources().getString(R.string.poll));
                                }
                            }
                        } else {
                            CustomMediaPlayer.this.getpolldatawithid(chatpojo2.getFirebase_id());
                        }
                    } else if (!chatpojo2.getType().equalsIgnoreCase(Polling.EVENT_POLL) && !chatpojo2.getType().equalsIgnoreCase("is_chat_locked")) {
                        CustomMediaPlayer.this.arrChat.add(chatpojo2);
                    } else if (chatpojo2.getMessage().equalsIgnoreCase("0")) {
                        CustomMediaPlayer.this.islocked = "1";
                        CustomMediaPlayer.this.showchat();
                    } else {
                        CustomMediaPlayer.this.islocked = "2";
                        CustomMediaPlayer.this.hidechat();
                    }
                    CustomMediaPlayer.this.chatAdapter.notifyDataSetChanged();
                    CustomMediaPlayer.this.recyclerChat.smoothScrollToPosition(CustomMediaPlayer.this.arrChat.size());
                } catch (Exception unused) {
                    CustomMediaPlayer customMediaPlayer = CustomMediaPlayer.this;
                    Toast.makeText(customMediaPlayer, customMediaPlayer.getResources().getString(R.string.null_pointer_exception), 0).show();
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
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.CustomMediaPlayer.19
                    @Override // com.google.firebase.database.ValueEventListener
                    public void onCancelled(DatabaseError databaseError) {
                    }

                    @Override // com.google.firebase.database.ValueEventListener
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() != null) {
                            OnlineUser onlineUser = (OnlineUser) dataSnapshot.getValue(OnlineUser.class);
                            CustomMediaPlayer.this.isintractavailable = true;
                            if (onlineUser.getInteract() == null || !onlineUser.getInteract().equalsIgnoreCase("0")) {
                                return;
                            }
                            CustomMediaPlayer.this.mFirebaseDatabaseReference1.child("interact").setValue("1");
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
        databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.CustomMediaPlayer.20
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot == null) {
                    return;
                }
                Polldata polldata = (Polldata) new Gson().fromJson(new Gson().toJson(dataSnapshot.getValue()), Polldata.class);
                for (int i = 0; i < CustomMediaPlayer.this.pollarraylist.size(); i++) {
                    if (CustomMediaPlayer.this.pollarraylist.get(i).getRendomkey().equalsIgnoreCase(randomid)) {
                        CustomMediaPlayer.this.pollarraylist.get(i).setStatus("1");
                        CustomMediaPlayer.this.pollAdapter.notifyDataSetChanged();
                        CustomMediaPlayer.this.poll.setText(CustomMediaPlayer.this.getResources().getString(R.string.new_poll));
                        return;
                    }
                }
                try {
                    String str = randomid;
                    if (str != null) {
                        polldata.setRendomkey(str);
                        polldata.setStatus("1");
                        CustomMediaPlayer.this.poll.setText(CustomMediaPlayer.this.getResources().getString(R.string.new_poll));
                        Snackbar.make(CustomMediaPlayer.this.rootView.getRootView(), "New Poll Added", -1).show();
                        ((Polldata) Objects.requireNonNull(polldata)).setMyAnswer("0");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(0, polldata);
                        arrayList.addAll(CustomMediaPlayer.this.pollarraylist);
                        CustomMediaPlayer.this.pollarraylist.clear();
                        CustomMediaPlayer.this.pollarraylist.addAll(arrayList);
                        CustomMediaPlayer.this.pollAdapter.notifyDataSetChanged();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
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
                dialog.findViewById(R.id.btn_dialog_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        dialog.dismiss();
                        if (CustomMediaPlayer.this.player == null || CustomMediaPlayer.this.player.getPlaybackState() != 3) {
                            return;
                        }
                        CustomMediaPlayer.this.player.setPlayWhenReady(true);
                    }
                });
                dialog.findViewById(R.id.btn_dialog_submit).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.22
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        String string = editText.getText().toString();
                        if (string.length() > 0) {
                            dialog.dismiss();
                            Helper.hideKeyboard(CustomMediaPlayer.this);
                            CustomMediaPlayer.this.BookMarkApi("", str, string, "1");
                        } else {
                            CustomMediaPlayer customMediaPlayer = CustomMediaPlayer.this;
                            Toast.makeText(customMediaPlayer, customMediaPlayer.getResources().getString(R.string.add_title), 0).show();
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
        this.f326info = info2;
        this.state = state;
        this.networkCall.NetworkAPICall(API.add_video_index, "", false, false);
    }

    private String formattedTime(long millis) {
        if (millis < 1) {
            return "00:00:00";
        }
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(millis)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
    }

    public void Loadyoutubeurl(String youtubeUri2) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.progressBar.setVisibility(0);
        HashMap<Integer, String> map = this.sparseAdaptiveVideoUrlList;
        if (map != null && map.size() > 0 && this.islive.equalsIgnoreCase("1")) {
            Uri.parse(youtubeUri2);
            if (!this.sparseOPUSAudioUrl.isEmpty()) {
                Uri.parse(this.sparseOPUSAudioUrl.get(0));
            }
            if (this.isaudio.equalsIgnoreCase("1")) {
                if (this.vodliveyoutuveurl.equalsIgnoreCase("0")) {
                    this.sparseOPUSAudioUrl.isEmpty();
                    return;
                } else {
                    this.quality.setVisibility(8);
                    return;
                }
            }
            return;
        }
        if (this.isaudio.equalsIgnoreCase("1")) {
            this.quality.setVisibility(8);
        }
    }

    private void showSpeedOptions() {
        PopupMenu popupMenu = new PopupMenu(this, this.speedTV, R.style.MyPopupMenu);
        Menu menu = popupMenu.getMenu();
        String[] stringArray = getResources().getStringArray(R.array.speed_values);
        if (stringArray.length != 0) {
            for (String str : stringArray) {
                if (str.equalsIgnoreCase("1")) {
                    menu.add(Const.Normal);
                } else {
                    menu.add(str + "x");
                }
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer.23
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    String string = item.getTitle().toString();
                    if (CustomMediaPlayer.this.player == null) {
                        return false;
                    }
                    CustomMediaPlayer.this.speedTV.setText(string);
                    if (string.equalsIgnoreCase(Const.Normal)) {
                        CustomMediaPlayer.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                        return false;
                    }
                    CustomMediaPlayer.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(string.replace("x", "")).floatValue(), 1.0f));
                    return false;
                }
            });
            popupMenu.show();
        }
    }

    public void onDelete(Bookmark data) {
        BookMarkApi(data.getId(), "", "", "2");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (MakeMyExam.userId.equalsIgnoreCase("") || MakeMyExam.userId.equalsIgnoreCase("0")) {
                MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
                MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
            }
            ((TelephonyManager) getSystemService("phone")).listen(new PhoneStateListener() { // from class: com.appnew.android.player.CustomMediaPlayer.24
                @Override // android.telephony.PhoneStateListener
                public void onCallStateChanged(int state, String incomingNumber) {
                    if (state == 1) {
                        CustomMediaPlayer.this.oncall(true);
                    }
                    if (state == 2) {
                        CustomMediaPlayer.this.oncall(true);
                    }
                    if (state == 0) {
                        CustomMediaPlayer.this.oncall(false);
                        ((AudioManager) CustomMediaPlayer.this.getApplicationContext().getSystemService("audio")).setMode(0);
                    }
                }
            }, 32);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str = youtubeUri;
        if (str == null || str.equalsIgnoreCase("")) {
            return;
        }
        Loadyoutubeurl(youtubeUri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blink() {
        try {
            this.floatingText.setVisibility(4);
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void oncall(final boolean b2) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.CustomMediaPlayer.25
            @Override // java.lang.Runnable
            public void run() {
                if (b2) {
                    CustomMediaPlayer.this.pausePlayer();
                }
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.player = null;
        }
        if (this.islive.equalsIgnoreCase("1")) {
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
            closeFullscreenDialog();
            return;
        }
        if (this.isaudio.equalsIgnoreCase("1") && (str = youtubeUri) != null && !str.equalsIgnoreCase("")) {
            Constants.pos = "1";
            background_play();
        } else {
            releasePlayer();
            super.onBackPressed();
        }
    }

    private void background_play() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage(this.video_name);
        builder.setPositiveButton(Html.fromHtml("<font color='#000000'>Stop</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$background_play$6(dialogInterface, i);
            }
        });
        builder.setNeutralButton(Html.fromHtml("<font color='#000000'>Cancel</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton(Html.fromHtml("<font color='#000000'>Play In background</font>"), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$background_play$8(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$background_play$6(DialogInterface dialogInterface, int i) {
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
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$background_play$8(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this, (Class<?>) AudioPlayerService.class);
        intent.putExtra("videoUrl", this.audio_url);
        String str = this.islive;
        if ((str == null || !str.equalsIgnoreCase("4")) && this.vodliveyoutuveurl.equalsIgnoreCase("0")) {
            intent.putExtra("isLive", false);
        } else {
            intent.putExtra("isLive", true);
        }
        intent.putExtra("shopView", false);
        intent.putExtra("type", Const.YOUTUBE);
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
        intent.putExtra("tileid", this.tileid);
        intent.putExtra("tiletype", this.tiletype);
        intent.putExtra("player_pos", this.player.getCurrentPosition());
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
        finish();
        dialogInterface.cancel();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.player.release();
            this.player = null;
        }
    }

    private void goLive() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.seekTo(exoPlayer.getDuration());
        }
    }

    private void openFullscreenDialog() {
        this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
        this.mExoPlayerFullscreen = true;
        setRequestedOrientation(0);
    }

    private void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen) { // from class: com.appnew.android.player.CustomMediaPlayer.26
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (CustomMediaPlayer.this.mExoPlayerFullscreen) {
                    CustomMediaPlayer.this.closeFullscreenDialog();
                }
                super.onBackPressed();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeFullscreenDialog() {
        this.mExoPlayerFullscreen = false;
        setRequestedOrientation(1);
        this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DatabaseReference databaseReference = this.mFirebaseDatabaseReferenceone2one;
        if (databaseReference != null) {
            databaseReference.removeEventListener(this.valueEventListener);
            Query query = this.query;
            if (query != null) {
                query.removeEventListener(this.childEventListener);
            }
        }
        if (this.islive.equalsIgnoreCase("4")) {
            setUserOffline();
        }
        youtubeUri = "";
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.player.release();
            this.player = null;
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
            chatPojo chatpojo = new chatPojo(MakeMyExam.userId, images.get(0).getFile(), SharedPreference.getInstance().getLoggedInUser().getName(), MakeMyExam.getTime_server(), "1", SharedPreference.getInstance().getLoggedInUser().getProfilePicture(), "1", str2, this.course_id);
            this.mFirebaseDatabaseReferenceone2one.push().setValue(chatpojo);
            this.mFirebaseDatabaseReferenceone2many.push().setValue(chatpojo);
            Helper.hideKeyboard(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imgClick() {
        final CharSequence[] charSequenceArr = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo!");
        builder.setItems(charSequenceArr, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$imgClick$9(charSequenceArr, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$imgClick$9(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
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
        if (charSequenceArr[i].equals("Choose from Gallery")) {
            Intent intent2 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            Uri uriForFile2 = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getFilesDir(), "temp_gallery.jpg"));
            this.str_imgTypeClick = "PhotoGalleryRequest";
            intent2.putExtra("output", uriForFile2);
            this.someActivityResultLauncher.launch(intent2);
            this.requestCode = 20000;
            return;
        }
        if (charSequenceArr[i].equals("Cancel")) {
            dialogInterface.dismiss();
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
        this.s3IU = new s3ImageUploading(this.Chat_node, "vc-10000386-38616500102/application/chat_system/", this, this, null);
        String[] strArrSplit = selectedURI.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        mediaFile.setFile_name(strArrSplit[strArrSplit.length - 1]);
        mediaFile.setFile(selectedURI);
        mediaFile.setFile_type(Const.PDF);
        arrayList.add(mediaFile);
        this.s3IU.execute(arrayList);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 123) {
            if (grantResults.length <= 0) {
                AppPermissionsRunTime.checkPermission(this, this.myPermissionConstantsArrayList, 123);
                return;
            } else {
                int i = grantResults[0];
                return;
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058 A[Catch: Exception -> 0x0074, TryCatch #0 {Exception -> 0x0074, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0017, B:10:0x0042, B:15:0x0054, B:17:0x0058, B:19:0x006b, B:7:0x002f, B:9:0x0032, B:11:0x0045, B:13:0x0048), top: B:24:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[Catch: Exception -> 0x0074, TRY_LEAVE, TryCatch #0 {Exception -> 0x0074, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0017, B:10:0x0042, B:15:0x0054, B:17:0x0058, B:19:0x006b, B:7:0x002f, B:9:0x0032, B:11:0x0045, B:13:0x0048), top: B:24:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSeek(com.appnew.android.Model.Bookmark r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getTime()     // Catch: java.lang.Exception -> L74
            if (r0 == 0) goto L73
            java.lang.String r6 = r6.getTime()     // Catch: java.lang.Exception -> L74
            java.lang.String r0 = ":"
            java.lang.String[] r6 = r6.split(r0)     // Catch: java.lang.Exception -> L74
            int r0 = r6.length     // Catch: java.lang.Exception -> L74
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != r1) goto L2f
            r0 = r6[r4]     // Catch: java.lang.Exception -> L74
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L74
            int r0 = r0 * 3600
            r1 = r6[r3]     // Catch: java.lang.Exception -> L74
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L74
            int r1 = r1 * 60
            int r0 = r0 + r1
            r6 = r6[r2]     // Catch: java.lang.Exception -> L74
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Exception -> L74
            goto L42
        L2f:
            int r0 = r6.length     // Catch: java.lang.Exception -> L74
            if (r0 != r2) goto L45
            r0 = r6[r4]     // Catch: java.lang.Exception -> L74
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L74
            int r0 = r0 * 3600
            r6 = r6[r3]     // Catch: java.lang.Exception -> L74
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Exception -> L74
            int r6 = r6 * 60
        L42:
            int r0 = r0 + r6
            long r0 = (long) r0     // Catch: java.lang.Exception -> L74
            goto L54
        L45:
            int r0 = r6.length     // Catch: java.lang.Exception -> L74
            if (r0 != r3) goto L52
            r6 = r6[r4]     // Catch: java.lang.Exception -> L74
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Exception -> L74
            int r6 = r6 * 3600
            long r0 = (long) r6     // Catch: java.lang.Exception -> L74
            goto L54
        L52:
            r0 = 0
        L54:
            boolean r6 = r5.inErrorState     // Catch: java.lang.Exception -> L74
            if (r6 == 0) goto L6b
            android.content.res.Resources r6 = r5.getResources()     // Catch: java.lang.Exception -> L74
            r0 = 2132019053(0x7f14076d, float:1.967643E38)
            java.lang.String r6 = r6.getString(r0)     // Catch: java.lang.Exception -> L74
            android.widget.Toast r6 = android.widget.Toast.makeText(r5, r6, r4)     // Catch: java.lang.Exception -> L74
            r6.show()     // Catch: java.lang.Exception -> L74
            return
        L6b:
            androidx.media3.exoplayer.ExoPlayer r6 = r5.player     // Catch: java.lang.Exception -> L74
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            r6.seekTo(r0)     // Catch: java.lang.Exception -> L74
        L73:
            return
        L74:
            r6 = move-exception
            r6.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.player.CustomMediaPlayer.onSeek(com.appnew.android.Model.Bookmark):void");
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/poll/delete_video_index":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setIndex_id(this.deletedindex);
                return service.deletevideoindex(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/poll/add_video_index":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setVideo_id(this.video_id);
                encryptionData2.setTime(this.time);
                encryptionData2.setInfo(this.f326info);
                return service.addvideoindex(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/poll/get_content_meta":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setUser_id(MakeMyExam.getUserId());
                encryptionData3.setToken(this.video_id);
                encryptionData3.setCourse_id(this.course_id);
                return service.getmetaData(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source":
                EncryptionData encryptionData4 = new EncryptionData();
                encryptionData4.setName(this.video_id + "_0_0");
                encryptionData4.setCourse_id(this.course_id);
                encryptionData4.setTile_id(this.tileid);
                encryptionData4.setType(this.tiletype);
                return service.getVideoLink(AES.encrypt(new Gson().toJson(encryptionData4)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
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
            case -1124739567:
                if (apitype.equals(API.get_meta)) {
                    b2 = 2;
                }
                break;
            case 551901514:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source")) {
                    b2 = 3;
                }
                break;
        }
        try {
            switch (b2) {
                case 0:
                    if (!jsonstring.getString("status").equalsIgnoreCase("true")) {
                        ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
                        RetrofitResponse.GetApiData(this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                    } else {
                        this.bookmarkdata.remove(this.pos);
                        this.bookmarkAdapter.notifyDataSetChanged();
                    }
                    break;
                case 1:
                    try {
                        if (!jsonstring.getString("status").equalsIgnoreCase("true")) {
                            RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                            break;
                        } else {
                            this.bookmarkdata.add(((Addindex) new Gson().fromJson(jsonstring.toString(), Addindex.class)).getData());
                            this.bookmarkAdapter.notifyItemChanged(this.bookmarkdata.size());
                            ExoPlayer exoPlayer = this.player;
                            if (exoPlayer != null && exoPlayer.getPlaybackState() == 3) {
                                this.player.setPlayWhenReady(true);
                                break;
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                    break;
                case 2:
                    try {
                        if (!jsonstring.getString("status").equalsIgnoreCase("true")) {
                            RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                        } else {
                            Metadata metadata = (Metadata) new Gson().fromJson(jsonstring.toString(), Metadata.class);
                            this.indexdata.addAll(metadata.getData().getIndex());
                            this.bookmarkdata.addAll(metadata.getData().getBookmark());
                            this.pdf.addAll(metadata.getData().getPdf());
                            this.pollarraylist.addAll(metadata.getData().getPoll());
                            Collections.reverse(this.pollarraylist);
                            if (this.islive.equalsIgnoreCase("4") && this.isaudio.equalsIgnoreCase("0")) {
                                setpollAdapter();
                                fireBaseOperation();
                                setUserOnline();
                                int i = this.pdf.size() == 0 ? 0 : 1;
                                setchat();
                                isvisiblelayouts(1, 0, 0, 1, i);
                            }
                            if (this.islive.equalsIgnoreCase("1") && this.isaudio.equalsIgnoreCase("0")) {
                                int i2 = this.pdf.size() == 0 ? 0 : 1;
                                int i3 = this.indexdata.size() == 0 ? 0 : 1;
                                setBookMark();
                                isvisiblelayouts(0, i3, 1, 0, i2);
                            }
                            if (this.isaudio.equalsIgnoreCase("1")) {
                                this.linearLayout.setVisibility(8);
                                isvisiblelayouts(0, 0, 0, 0, 0);
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                    break;
                case 3:
                    if (!jsonstring.getString("status").equalsIgnoreCase("true")) {
                        ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
                        RetrofitResponse.GetApiData(this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                    } else {
                        JSONObject jSONObject = new JSONObject(jsonstring.toString());
                        if (!jSONObject.has("data")) {
                            Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
                        } else {
                            this.link = jSONObject.getJSONObject("data").getString("link");
                            this.thumbnailurl = "http://img.youtube.com/vi/" + this.url + "/0.jpg";
                            if (this.isaudio.equalsIgnoreCase("1")) {
                                new Thread(new Runnable() { // from class: com.appnew.android.player.CustomMediaPlayer$$ExternalSyntheticLambda2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$SuccessCallBack$10();
                                    }
                                }).start();
                            }
                            extractYoutubeUrl(this.link);
                        }
                    }
                    break;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$10() {
        try {
            this.image = BitmapFactory.decodeStream(new URL(this.thumbnailurl).openConnection().getInputStream());
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
        this.indexBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.indexBtn.setTextColor(getResources().getColor(android.R.color.black));
        setAdapter();
    }

    public void setVideoTimeMS(int timeMS) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.seekTo(timeMS);
        } else {
            Toast.makeText(this, getResources().getString(R.string.please_wait_player_is_not_ready), 0).show();
        }
    }

    void disableAll() {
        this.bookmarkBtn.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.indexBtn.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.chat_btn.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.poll.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.notes.setBackgroundColor(getResources().getColor(R.color.off_white));
    }

    private void setAdapter() {
        Adapter_recycleveiw_vedio adapter_recycleveiw_vedio = new Adapter_recycleveiw_vedio(this, this.indexdata, "custom");
        this.adapter = adapter_recycleveiw_vedio;
        this.recyclerChat.setAdapter(adapter_recycleveiw_vedio);
    }

    private void setbookmarkadapter() {
        BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(this, this.bookmarkdata, "customplayer");
        this.bookmarkAdapter = bookmarkAdapter;
        this.recyclerChat.setAdapter(bookmarkAdapter);
    }

    private void setBookMark() {
        this.isclicked = "2";
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        this.linearLayout.setVisibility(0);
        disableAll();
        this.addBookmark.setVisibility(0);
        this.chatlayout.setVisibility(8);
        this.bookmarkBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.bookmarkBtn.setTextColor(getResources().getColor(android.R.color.black));
        setbookmarkadapter();
    }

    private void setNotesAdapter() {
        NotesAdapter notesAdapter = new NotesAdapter(this, this.pdf, this.course_id);
        this.notesAdapter = notesAdapter;
        this.recyclerChat.setAdapter(notesAdapter);
    }

    public void isvisiblelayouts(int ispoll, int isindex, int isbookmark, int islivechat, int ispdf) {
        this.poll.setVisibility(0);
        this.bookmarkBtn.setVisibility(0);
        this.indexBtn.setVisibility(0);
        this.chat_btn.setVisibility(0);
        this.notes.setVisibility(0);
        if (ispoll == 0) {
            this.poll.setVisibility(8);
        }
        if (isbookmark == 0) {
            this.bookmarkBtn.setVisibility(8);
        }
        if (isindex == 0) {
            this.indexBtn.setVisibility(8);
        }
        if (ispdf == 0) {
            this.notes.setVisibility(8);
        }
        if (islivechat == 0) {
            this.chat_btn.setVisibility(8);
        }
    }

    public void setpollcount(final String pollkey, final String answer) {
        this.mFirebaseDatabaseReferencepolldata = null;
        DatabaseReference databaseReferenceChild = FirebaseDatabase.getInstance("https://eduteria-b9a30-default-rtdb.firebaseio.com/").getReference().child("166/chat_master/" + this.Chat_node + "/Poll/" + pollkey);
        this.mFirebaseDatabaseReferencepolldata = databaseReferenceChild;
        databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.CustomMediaPlayer.27
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
                                CustomMediaPlayer.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_1");
                            }
                        } else if (answer.equalsIgnoreCase("2")) {
                            if (key.equalsIgnoreCase("attempt_2")) {
                                CustomMediaPlayer.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_2");
                            }
                        } else if (answer.equalsIgnoreCase("3")) {
                            if (key.equalsIgnoreCase("attempt_3")) {
                                CustomMediaPlayer.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_3");
                            }
                        } else if (answer.equalsIgnoreCase("4") && key.equalsIgnoreCase("attempt_4")) {
                            CustomMediaPlayer.this.setcountincrement(((Long) dataSnapshot2.getValue()).longValue() + 1, "attempt_4");
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
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * 1000)));
    }

    public void onDelete(VideoTimeFramePojo data, int position) {
        BookMarkDeleteApi(data.getId(), "", "", "2");
        this.pos = position;
    }

    private void BookMarkDeleteApi(String id, String s, String s1, String s2) {
        this.deletedindex = id;
        this.networkCall.NetworkAPICall(API.delete_video_index, "", false, false);
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
        databaseReferenceChild.addListenerForSingleValueEvent(new ValueEventListener() { // from class: com.appnew.android.player.CustomMediaPlayer.28
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
                            CustomMediaPlayer.this.attempt_1_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                        }
                        if (key.equalsIgnoreCase("attempt_2")) {
                            CustomMediaPlayer.this.attempt_2_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                        }
                        if (key.equalsIgnoreCase("attempt_3")) {
                            CustomMediaPlayer.this.attempt_3_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                        }
                        if (key.equalsIgnoreCase("attempt_4")) {
                            CustomMediaPlayer.this.attempt_4_count = Float.parseFloat(String.valueOf(dataSnapshot2.getValue()));
                        }
                    }
                    CustomMediaPlayer customMediaPlayer = CustomMediaPlayer.this;
                    customMediaPlayer.total = customMediaPlayer.attempt_1_count + CustomMediaPlayer.this.attempt_2_count + CustomMediaPlayer.this.attempt_3_count + CustomMediaPlayer.this.attempt_4_count;
                    map.put("total", Float.valueOf(CustomMediaPlayer.this.total));
                    if (CustomMediaPlayer.this.attempt_1_count != 0.0f) {
                        map.put("perA", Float.valueOf((CustomMediaPlayer.this.attempt_1_count / CustomMediaPlayer.this.total) * 100.0f));
                    } else {
                        map.put("perA", Float.valueOf(0.0f));
                    }
                    if (CustomMediaPlayer.this.attempt_2_count != 0.0f) {
                        map.put("perB", Float.valueOf((CustomMediaPlayer.this.attempt_2_count / CustomMediaPlayer.this.total) * 100.0f));
                    } else {
                        map.put("perB", Float.valueOf(0.0f));
                    }
                    if (CustomMediaPlayer.this.attempt_3_count != 0.0f) {
                        map.put("perC", Float.valueOf((CustomMediaPlayer.this.attempt_3_count / CustomMediaPlayer.this.total) * 100.0f));
                    } else {
                        map.put("perC", Float.valueOf(0.0f));
                    }
                    if (CustomMediaPlayer.this.attempt_4_count != 0.0f) {
                        map.put("perD", Float.valueOf((CustomMediaPlayer.this.attempt_4_count / CustomMediaPlayer.this.total) * 100.0f));
                    } else {
                        map.put("perD", Float.valueOf(0.0f));
                    }
                    CustomMediaPlayer.this.pollAdapter.SetServeyresult(polldata, map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$11(CropImageView.CropResult cropResult) {
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
    public /* synthetic */ void lambda$new$12(ActivityResult activityResult) {
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
                return;
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
}
