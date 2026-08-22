package com.appnew.android.JWextractor;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.PlayerPojo.Addindex;
import com.appnew.android.Model.PlayerPojo.Metadata;
import com.appnew.android.Model.PlayerPojo.Pdf;
import com.appnew.android.Model.PlayerPojo.VideoTimeFramePojo;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.player.Adapter_recycleveiw_vedio;
import com.appnew.android.player.BookmarkAdapter;
import com.appnew.android.player.NotesAdapter;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.appnew.android.table.UserHistroyTable;
import com.canhub.cropper.CropImageOptionsKt;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.network.connectionclass.ConnectionClassManager;
import com.facebook.network.connectionclass.ConnectionQuality;
import com.facebook.network.connectionclass.DeviceBandwidthSampler;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import cz.msebera.android.httpclient.HttpHost;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class JWVideoPlayer extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, GestureDetector.OnDoubleTapListener {
    private static DefaultBandwidthMeter BANDWIDTH_METER = null;
    private static final String TAG = "JWVideoPlayer";
    private static int currentVideoSource = 0;
    private static int newOrientation = 0;
    private static long playPosition = 0;
    private static String stringCurrentVideoSource = null;
    private static String youtubeUri = "";
    private TextView MarqueeText;
    private Adapter_recycleveiw_vedio adapter;
    TextView addBookmark;
    private BookmarkAdapter bookmarkAdapter;
    TextView bookmarkBtn;
    private InternetConnectionChecker broadcastReceiver;
    TextView chat_btn;
    TextView indexBtn;
    private IntentFilter intentFilter;
    private Timer internetSpeedTimer;
    private boolean isInitialResChanged;
    private boolean isShowingTrackSelectionDialog;
    DefaultLoadControl loadControl;
    VideoPopUpMenuAdapter mAdapter;
    private ConnectionClassManager mConnectionClassManager;
    private DeviceBandwidthSampler mDeviceBandwidthSampler;
    private FrameLayout mFullScreenButton;
    private Dialog mFullScreenDialog;
    private ImageView mFullScreenIcon;
    long mLastClickTime_frame5;
    private RecyclerView.LayoutManager mLayoutManager;
    private ConnectionChangedListener mListener;
    private DataSource.Factory mediaDataSourceFactory;
    MediaSource mediaSource;
    NetworkCall networkCall;
    private TextView notes;
    private NotesAdapter notesAdapter;
    RelativeLayout parent_layout;
    ImageButton pauseBtn;
    ImageButton playBtn;
    private ExoPlayer player;
    private TextView poll;
    private RecyclerView popupList;
    private PopupWindow popupWindow;
    int pos;
    ProgressBar progressBar;
    ImageView quality;
    private RecyclerView recyclerChat;
    View rootView;
    private int savedOrientation;
    List<Integer> sparseAdaptiveResolutionList;
    private HashMap<Integer, String> sparseAdaptiveVideoUrlList;
    private List<String> sparseOPUSAudioUrl;
    private TextView speedTV;
    private TrackSelectionHelper trackSelectionHelper;
    DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    private TextView tvGoLive;
    private String userAgent;
    private UtkashRoom utkashRoom;
    private TextView video_name;
    boolean playerError = false;
    String url = "";
    String video_id = "";
    String title = "";
    String value_360 = "";
    String course_id = "";
    Long current_pos = 0L;
    private ConnectionQuality mConnectionClass = ConnectionQuality.UNKNOWN;
    String speedx = "";
    private boolean mExoPlayerFullscreen = false;
    private final String STATE_PLAYER_FULLSCREEN = "playerFullscreen";
    String isclicked = "";
    private String deletedindex = "";
    private List<VideoTimeFramePojo> indexdata = new ArrayList();
    private List<VideoTimeFramePojo> bookmarkdata = new ArrayList();
    private List<Pdf> pdf = new ArrayList();
    private String time = "";

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private String f307info = "";
    private String state = "";
    private long internetCheckDelay = 0;
    private final long internetCheckDelayMultiple = 20;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent e2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent e2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent e2) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_jw_video_player);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        this.utkashRoom = UtkashRoom.getAppDatabase(this);
        this.networkCall = new NetworkCall(this, this);
        if (getIntent().getExtras() != null) {
            this.url = getIntent().getExtras().getString(Const.VIDEO_LINK);
            this.video_id = getIntent().getExtras().getString(Const.VIDEO_ID);
            this.title = getIntent().getExtras().getString("title");
            this.course_id = getIntent().getExtras().getString("course_id");
            Long lValueOf = Long.valueOf(getIntent().getExtras().getLong("current_pos", 0L));
            this.current_pos = lValueOf;
            playPosition = lValueOf.longValue();
        }
        if (savedInstanceState != null) {
            this.mExoPlayerFullscreen = savedInstanceState.getBoolean("playerFullscreen");
        }
        this.loadControl = new DefaultLoadControl.Builder().setAllocator(new DefaultAllocator(true, 16)).setBufferDurationsMs(20000, 20000, 1500, 1500).setTargetBufferBytes(-1).setPrioritizeTimeOverSizeThresholds(true).build();
        this.parent_layout = (RelativeLayout) findViewById(R.id.parent_layout);
        this.recyclerChat = (RecyclerView) findViewById(R.id.recycler_view);
        this.bookmarkBtn = (TextView) findViewById(R.id.bookmark_btn);
        this.addBookmark = (TextView) findViewById(R.id.add_bookmark);
        this.indexBtn = (TextView) findViewById(R.id.index_btn);
        this.chat_btn = (TextView) findViewById(R.id.chat_btn);
        this.notes = (TextView) findViewById(R.id.notes);
        this.poll = (TextView) findViewById(R.id.poll);
        this.mConnectionClassManager = ConnectionClassManager.getInstance();
        this.mDeviceBandwidthSampler = DeviceBandwidthSampler.getInstance();
        this.mListener = new ConnectionChangedListener();
        this.playBtn = (ImageButton) findViewById(R.id.exo_play);
        this.pauseBtn = (ImageButton) findViewById(R.id.exo_pause);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.quality = (ImageView) findViewById(R.id.quality);
        this.rootView = findViewById(R.id.root_new);
        this.MarqueeText = (TextView) findViewById(R.id.MarqueeText);
        TextView textView = (TextView) findViewById(R.id.video_name);
        this.video_name = textView;
        textView.setSelected(true);
        this.video_name.setFocusable(true);
        this.video_name.setFocusableInTouchMode(true);
        this.video_name.setText(this.title);
        this.MarqueeText.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        this.userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        this.trackSelectorParameters = new DefaultTrackSelector.ParametersBuilder().build();
        initFullscreenDialog();
        try {
            new OrientationEventListener(getApplicationContext()) { // from class: com.appnew.android.JWextractor.JWVideoPlayer.1
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    try {
                        if (Settings.System.getInt(JWVideoPlayer.this.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            boolean zIsPortrait = JWVideoPlayer.this.isPortrait(orientation);
                            if (!zIsPortrait && JWVideoPlayer.this.savedOrientation == 1) {
                                JWVideoPlayer.this.savedOrientation = 0;
                                JWVideoPlayer.this.setRequestedOrientation(2);
                            } else if (zIsPortrait && JWVideoPlayer.this.savedOrientation == 0) {
                                JWVideoPlayer.this.savedOrientation = 1;
                                JWVideoPlayer.this.setRequestedOrientation(2);
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
        findViewById(R.id.quality).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.indexBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$1();
            }
        }));
        this.notes.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$2();
            }
        }));
        this.bookmarkBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$3();
            }
        }));
        hit_api_for_meta();
        checkNetwork(new NetworkCheckerInterface() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.2
            @Override // com.appnew.android.JWextractor.NetworkCheckerInterface
            public void continueExecution() {
                JWVideoPlayer.this.startInternetSpeedTimer();
                try {
                    if (JWVideoPlayer.this.url != null && !JWVideoPlayer.this.url.equalsIgnoreCase("")) {
                        JWVideoPlayer jWVideoPlayer = JWVideoPlayer.this;
                        jWVideoPlayer.url = jWVideoPlayer.url.replace(TournamentShareDialogURIBuilder.scheme, HttpHost.DEFAULT_SCHEME_NAME);
                        JWVideoPlayer jWVideoPlayer2 = JWVideoPlayer.this;
                        jWVideoPlayer2.extractJWUrl(jWVideoPlayer2.url);
                        JWVideoPlayer.this.parent_layout.setVisibility(0);
                        return;
                    }
                    JWVideoPlayer.this.showRestartAlertDialog();
                } catch (NullPointerException unused) {
                }
            }

            @Override // com.appnew.android.JWextractor.NetworkCheckerInterface
            public void cancelExecution() {
                JWVideoPlayer.this.onBackPressed();
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        this.intentFilter = intentFilter;
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.broadcastReceiver = new InternetConnectionChecker() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.3
            @Override // com.appnew.android.JWextractor.InternetConnectionChecker, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                JWVideoPlayer jWVideoPlayer = JWVideoPlayer.this;
                jWVideoPlayer.networkStatusChecker(Helper.isNetworkConnected(jWVideoPlayer));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (this.player != null) {
            showPopUpMenu("quality", this.quality);
        } else {
            Snackbar.make(this.rootView, getResources().getString(R.string.reloading_video_please_wait), 0).show();
        }
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

    private void showPopUpMenu(String action, View anchorView) {
        List<Integer> list;
        View viewInflate = getLayoutInflater().inflate(R.layout.video_pop_up_menu_layout, (ViewGroup) null);
        this.popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        this.popupList = (RecyclerView) viewInflate.findViewById(R.id.videopopuplist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLayoutManager = linearLayoutManager;
        this.popupList.setLayoutManager(linearLayoutManager);
        this.popupList.setHasFixedSize(true);
        action.hashCode();
        if (action.equals("quality") && (list = this.sparseAdaptiveResolutionList) != null && !list.isEmpty() && this.player != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Collections.sort(this.sparseAdaptiveResolutionList);
            if (this.sparseAdaptiveResolutionList.contains(180)) {
                arrayList.add("Low");
            }
            if (this.sparseAdaptiveResolutionList.contains(270)) {
                arrayList.add("Medium");
            }
            if (this.sparseAdaptiveResolutionList.contains(Integer.valueOf(CropImageOptionsKt.DEGREES_360))) {
                arrayList.add("High");
            }
            if (this.sparseAdaptiveResolutionList.contains(540)) {
                arrayList.add("Very High");
            }
            if (arrayList.contains("Very High")) {
                arrayList2.add("Very High");
            }
            if (arrayList.contains("High")) {
                arrayList2.add("High");
            }
            if (arrayList.contains("Medium")) {
                arrayList2.add("Medium");
            }
            if (arrayList.contains("Low")) {
                arrayList2.add("Low");
            }
            int i = currentVideoSource;
            if (i == 540) {
                stringCurrentVideoSource = "Very High";
            } else if (i == 360) {
                stringCurrentVideoSource = "High";
            } else if (i == 270) {
                stringCurrentVideoSource = "Medium";
            } else if (i == 180) {
                stringCurrentVideoSource = "Low";
            }
            VideoPopUpMenuAdapter videoPopUpMenuAdapter = new VideoPopUpMenuAdapter(this, this.sparseAdaptiveResolutionList, this.player, "quality", currentVideoSource, arrayList2, stringCurrentVideoSource, true, false, false);
            this.mAdapter = videoPopUpMenuAdapter;
            this.popupList.setAdapter(videoPopUpMenuAdapter);
            this.mAdapter.notifyDataSetChanged();
        }
        this.popupWindow.setOutsideTouchable(true);
        this.popupWindow.setBackgroundDrawable(new ColorDrawable(-1));
        this.popupWindow.setAnimationStyle(android.R.style.Animation.Dialog);
        int[] iArr = new int[2];
        Rect rect = new Rect();
        anchorView.getLocationInWindow(iArr);
        anchorView.getLocalVisibleRect(rect);
        if (newOrientation == 1) {
            this.popupWindow.showAsDropDown(anchorView);
        } else if (action.equalsIgnoreCase(TransferTable.COLUMN_SPEED)) {
            this.popupWindow.showAtLocation(getWindow().getDecorView(), 0, iArr[0] + (anchorView.getWidth() / 2), iArr[1] + anchorView.getHeight() + 50);
        } else {
            this.popupWindow.showAtLocation(getWindow().getDecorView(), 0, iArr[0] + (anchorView.getWidth() / 2), iArr[1] + anchorView.getHeight() + 50);
        }
    }

    private Timer getInternetSpeedTimerInstance() {
        if (this.internetSpeedTimer == null) {
            this.internetSpeedTimer = new Timer();
        }
        return this.internetSpeedTimer;
    }

    private void checkNetwork(NetworkCheckerInterface networkCheckerInterface) {
        checkNetwork(true, networkCheckerInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRestartAlertDialog() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        final AlertDialog alertDialogCreate = builder.create();
        View viewInflate = getLayoutInflater().inflate(R.layout.retry_video_dialog, (ViewGroup) null, false);
        alertDialogCreate.setView(viewInflate);
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        if (!isFinishing()) {
            alertDialogCreate.show();
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.body);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(this.title);
        textView.setText(getResources().getString(R.string.video_playback_has_failed_please_wait_and_try_again_your_patience_is_appreciated));
        Button button = (Button) viewInflate.findViewById(R.id.positiveBtn);
        Button button2 = (Button) viewInflate.findViewById(R.id.negativeBtn);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showRestartAlertDialog$4(alertDialogCreate, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showRestartAlertDialog$5(alertDialogCreate, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRestartAlertDialog$4(AlertDialog alertDialog, View view) {
        String str = this.url;
        if (str == null || str.equalsIgnoreCase("")) {
            Snackbar.make(this.rootView, getResources().getString(R.string.video_getting_issue_please_relaod_again), 0).show();
            onBackPressed();
        } else {
            Snackbar.make(this.rootView, getResources().getString(R.string.reloading_video_please_wait), 0).show();
            String strReplace = this.url.replace(TournamentShareDialogURIBuilder.scheme, HttpHost.DEFAULT_SCHEME_NAME);
            this.url = strReplace;
            extractJWUrl(strReplace);
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRestartAlertDialog$5(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNetwork(boolean showDialogWhenSlow, NetworkCheckerInterface networkCheckerInterface) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        double linkDownstreamBandwidthKbps = ((((double) (networkCapabilities != null ? networkCapabilities.getLinkDownstreamBandwidthKbps() : 0)) / 8.0d) / 1000.0d) / 8.0d;
        String str = "DownSpeed :" + String.format("%.2f", Double.valueOf(linkDownstreamBandwidthKbps)) + " Mb/s";
        if (linkDownstreamBandwidthKbps > 5.0d) {
            networkCheckerInterface.continueExecution();
        } else if (showDialogWhenSlow) {
            networkCheckerInterface.continueExecution();
        } else {
            networkCheckerInterface.onUnstableInternet();
        }
    }

    private void showSlowNetworkAlertDialog(ConnectivityManager netInfo, String downSpeed, final NetworkCheckerInterface networkCheckerInterface) {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime_frame5 < 1000) {
            return;
        }
        this.mLastClickTime_frame5 = SystemClock.elapsedRealtime();
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.slow_network_dialog);
        dialog.getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(3);
        dialog.getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
        dialog.getWindow().setGravity(17);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        if (!isDestroyed() && !isFinishing()) {
            dialog.show();
        }
        TextView textView = (TextView) dialog.findViewById(R.id.body);
        TextView textView2 = (TextView) dialog.findViewById(R.id.body2);
        ((TextView) dialog.findViewById(R.id.title)).setText("Network Information");
        textView.setText(new StringBuilder("You are currently connected to: \n").append(netInfo.getActiveNetworkInfo().getTypeName()).toString() == null ? "Internet" : netInfo.getActiveNetworkInfo().getTypeName() + " Network");
        textView2.setText("Slow network speed will effect video experience.");
        Button button = (Button) dialog.findViewById(R.id.positiveBtn);
        Button button2 = (Button) dialog.findViewById(R.id.negativeBtn);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JWVideoPlayer.lambda$showSlowNetworkAlertDialog$6(networkCheckerInterface, dialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JWVideoPlayer.lambda$showSlowNetworkAlertDialog$7(dialog, networkCheckerInterface, view);
            }
        });
    }

    static /* synthetic */ void lambda$showSlowNetworkAlertDialog$6(NetworkCheckerInterface networkCheckerInterface, Dialog dialog, View view) {
        networkCheckerInterface.continueExecution();
        dialog.dismiss();
    }

    static /* synthetic */ void lambda$showSlowNetworkAlertDialog$7(Dialog dialog, NetworkCheckerInterface networkCheckerInterface, View view) {
        dialog.dismiss();
        networkCheckerInterface.cancelExecution();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternetSpeedTimer() {
        if (getInternetSpeedTimerInstance() != null) {
            this.internetCheckDelay += 20;
            this.internetSpeedTimer.schedule(new TimerTask() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (JWVideoPlayer.this.isDestroyed()) {
                        return;
                    }
                    JWVideoPlayer.this.checkNetwork(false, new NetworkCheckerInterface() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.4.1
                        @Override // com.appnew.android.JWextractor.NetworkCheckerInterface
                        public void cancelExecution() {
                        }

                        @Override // com.appnew.android.JWextractor.NetworkCheckerInterface
                        public void onUnstableInternet() {
                            if (JWVideoPlayer.this.isFinishing() || JWVideoPlayer.this.isDestroyed()) {
                                return;
                            }
                            Snackbar.make(JWVideoPlayer.this.rootView, "Your internet connection is unstable", 0).show();
                            JWVideoPlayer.this.resetInternetSpeedTimer();
                        }

                        @Override // com.appnew.android.JWextractor.NetworkCheckerInterface
                        public void continueExecution() {
                            if (JWVideoPlayer.this.isFinishing() || JWVideoPlayer.this.isDestroyed()) {
                                return;
                            }
                            JWVideoPlayer.this.resetInternetSpeedTimer();
                        }
                    });
                }
            }, this.internetCheckDelay * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetInternetSpeedTimer() {
        cancelInternetSpeedTimer();
        startInternetSpeedTimer();
    }

    private void hit_api_for_meta() {
        this.networkCall.NetworkAPICall(API.get_meta, "", false, false);
    }

    private void cancelInternetSpeedTimer() {
        Timer timer = this.internetSpeedTimer;
        if (timer != null) {
            timer.cancel();
            this.internetSpeedTimer = null;
        }
    }

    private void setBookMark() {
        this.isclicked = "2";
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        this.addBookmark.setVisibility(0);
        disableAll();
        this.addBookmark.setVisibility(0);
        this.bookmarkBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.bookmarkBtn.setTextColor(getResources().getColor(android.R.color.black));
        setbookmarkadapter();
    }

    private void setbookmarkadapter() {
        BookmarkAdapter bookmarkAdapter = new BookmarkAdapter(this, this.bookmarkdata, "jwplayer");
        this.bookmarkAdapter = bookmarkAdapter;
        this.recyclerChat.setAdapter(bookmarkAdapter);
    }

    private void setNotes() {
        this.isclicked = "4";
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        this.notes.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.notes.setTextColor(getResources().getColor(android.R.color.black));
        setNotesAdapter();
    }

    private void setNotesAdapter() {
        NotesAdapter notesAdapter = new NotesAdapter(this, this.pdf, this.course_id);
        this.notesAdapter = notesAdapter;
        this.recyclerChat.setAdapter(notesAdapter);
    }

    void disableAll() {
        this.bookmarkBtn.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.indexBtn.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.chat_btn.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.poll.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.notes.setBackgroundColor(getResources().getColor(R.color.off_white));
        this.addBookmark.setVisibility(8);
    }

    private void setIndex() {
        this.isclicked = "3";
        this.addBookmark.setVisibility(8);
        this.recyclerChat.setVisibility(0);
        this.recyclerChat.setLayoutManager(new LinearLayoutManager(this));
        disableAll();
        this.indexBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.clickcurveback));
        this.indexBtn.setTextColor(getResources().getColor(android.R.color.black));
        setAdapter();
    }

    private void setAdapter() {
        Adapter_recycleveiw_vedio adapter_recycleveiw_vedio = new Adapter_recycleveiw_vedio(this, this.indexdata, "jw");
        this.adapter = adapter_recycleveiw_vedio;
        this.recyclerChat.setAdapter(adapter_recycleveiw_vedio);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void extractJWUrl(String url) {
        new JWPlayerMediaExtractor(new JWPlayerExtractorCallBack() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.5
            @Override // com.appnew.android.JWextractor.JWPlayerExtractorCallBack
            public void onExtractorSuccess(int responseCode, HashMap<Integer, String> mediaResponseMap, boolean isVideoLive) {
                if (mediaResponseMap.get(-1) != null) {
                    JWVideoPlayer.this.sparseAdaptiveResolutionList = new ArrayList(mediaResponseMap.keySet());
                    JWVideoPlayer.this.sparseAdaptiveVideoUrlList = new HashMap();
                    JWVideoPlayer.this.sparseAdaptiveVideoUrlList = mediaResponseMap;
                    if (JWVideoPlayer.this.sparseAdaptiveVideoUrlList == null || JWVideoPlayer.this.sparseAdaptiveVideoUrlList.size() <= 0) {
                        return;
                    }
                    Collections.sort(JWVideoPlayer.this.sparseAdaptiveResolutionList, Collections.reverseOrder());
                    JWVideoPlayer.youtubeUri = (String) JWVideoPlayer.this.sparseAdaptiveVideoUrlList.get(180);
                    JWVideoPlayer.currentVideoSource = 180;
                    JWVideoPlayer.this.progressBar.setVisibility(8);
                    JWVideoPlayer.this.Loadyoutubeurl(JWVideoPlayer.youtubeUri);
                }
            }

            @Override // com.appnew.android.JWextractor.JWPlayerExtractorCallBack
            public void onExtractorError(int responseCode, String error) {
                JWVideoPlayer.this.progressBar.setVisibility(8);
                JWVideoPlayer.this.showRestartAlertDialog();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, url);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        try {
            newOrientation = newConfig.orientation;
            boolean z = true;
            if (newConfig.orientation == 1) {
                this.isclicked.equalsIgnoreCase("1");
                if (this.isclicked.equalsIgnoreCase("2")) {
                    this.addBookmark.setVisibility(0);
                }
                this.mExoPlayerFullscreen = false;
                this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
                getWindow().setFlags(1024, 1024);
                float f2 = getResources().getDisplayMetrics().density;
                if ((getResources().getConfiguration().screenLayout & 15) != 4) {
                    z = false;
                }
                this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ((f2 * ((getResources().getConfiguration().screenLayout & 15) == 3 ? 350.0f : z ? 400.0f : 230.0f)) + 0.5f)));
                return;
            }
            this.mExoPlayerFullscreen = true;
            this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
            this.addBookmark.setVisibility(8);
            getWindow().setFlags(1024, 1024);
            this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void Loadyoutubeurl(String youtubeUri2) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.progressBar.setVisibility(0);
        Uri.parse(youtubeUri2);
        try {
            UserHistroyTable userHistroyTable = new UserHistroyTable();
            userHistroyTable.setVideo_id(this.video_id);
            userHistroyTable.setVideo_name(this.title);
            userHistroyTable.setType("Video");
            userHistroyTable.setCourse_id(this.course_id);
            userHistroyTable.setUser_id(MakeMyExam.userId);
            userHistroyTable.setCurrent_time("" + System.currentTimeMillis());
            this.utkashRoom.getuserhistorydao().addUser(userHistroyTable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer$$ExternalSyntheticLambda8
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return this.f$0.lambda$showSpeedOptions$8(menuItem);
                }
            });
            popupMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showSpeedOptions$8(MenuItem menuItem) {
        String string = menuItem.getTitle().toString();
        if (this.player == null) {
            return false;
        }
        this.speedTV.setText(string);
        if (string.equalsIgnoreCase(Const.Normal)) {
            this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
            return false;
        }
        this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(string.replace("x", "")).floatValue(), 1.0f));
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            ((TelephonyManager) getSystemService("phone")).listen(new PhoneStateListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.6
                @Override // android.telephony.PhoneStateListener
                public void onCallStateChanged(int state, String incomingNumber) {
                    if (state == 1) {
                        JWVideoPlayer.this.oncall(true);
                    }
                    if (state == 2) {
                        JWVideoPlayer.this.oncall(true);
                    }
                    if (state == 0) {
                        JWVideoPlayer.this.oncall(false);
                        ((AudioManager) JWVideoPlayer.this.getApplicationContext().getSystemService("audio")).setMode(0);
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
        if (this.playerError) {
            this.playerError = false;
            ExoPlayer exoPlayer = this.player;
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(true);
                this.player.getPlaybackState();
            } else if (!youtubeUri.equalsIgnoreCase("")) {
                Loadyoutubeurl(youtubeUri);
            } else {
                showRestartAlertDialog();
            }
        }
        this.mConnectionClassManager.register(this.mListener);
        registerReceiver(this.broadcastReceiver, this.intentFilter);
    }

    public void oncall(final boolean b2) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.7
            @Override // java.lang.Runnable
            public void run() {
                if (b2) {
                    JWVideoPlayer.this.pausePlayer();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void networkStatusChecker(boolean networkConnected) {
        if (networkConnected) {
            if (this.playerError) {
                Snackbar.make(this.rootView, getResources().getString(R.string.connect_with_internet_device_is_online), -1).show();
                return;
            }
            return;
        }
        Snackbar.make(this.rootView, getResources().getString(R.string.no_internet_connection_found_device_is_offline), -1).show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.player.setPlayWhenReady(false);
            this.player.getPlaybackState();
        }
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        cancelInternetSpeedTimer();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getResources().getConfiguration().orientation == 2) {
            closeFullscreenDialog();
            return;
        }
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.utkashRoom.getvideoDao().update_video_currentpos(this.video_id, MakeMyExam.userId, Long.valueOf(playPosition));
            this.player.release();
            this.player = null;
            playPosition = 0L;
            youtubeUri = "";
        }
        cancelInternetSpeedTimer();
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            this.playerError = true;
            playPosition = exoPlayer.getCurrentPosition();
            this.utkashRoom.getvideoDao().update_video_currentpos(this.video_id, MakeMyExam.userId, Long.valueOf(playPosition));
        }
        InternetConnectionChecker internetConnectionChecker = this.broadcastReceiver;
        if (internetConnectionChecker != null) {
            unregisterReceiver(internetConnectionChecker);
        }
        this.mConnectionClassManager.remove(this.mListener);
        super.onPause();
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
        int i = newOrientation;
        if (i == 1) {
            setRequestedOrientation(0);
        } else if (i == 2) {
            setRequestedOrientation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeFullscreenDialog() {
        this.mExoPlayerFullscreen = false;
        setRequestedOrientation(1);
        this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
    }

    private void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen) { // from class: com.appnew.android.JWextractor.JWVideoPlayer.8
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (JWVideoPlayer.this.mExoPlayerFullscreen) {
                    JWVideoPlayer.this.closeFullscreenDialog();
                }
                super.onBackPressed();
            }
        };
    }

    public void showDialog1(View view) {
        if (this.player != null) {
            pausePlayer();
            final String str = formattedTime(this.player.getCurrentPosition());
            final Dialog dialog = new Dialog(this, R.style.CustomAlertDialog);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.add_book_dialog);
            ((TextView) dialog.findViewById(R.id.text_dialog_time)).setText("Time :" + str);
            final EditText editText = (EditText) dialog.findViewById(R.id.nameTV);
            dialog.findViewById(R.id.btn_dialog_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.9
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    dialog.dismiss();
                    if (JWVideoPlayer.this.player == null || JWVideoPlayer.this.player.getPlaybackState() != 3) {
                        return;
                    }
                    JWVideoPlayer.this.playBtn.setVisibility(8);
                    JWVideoPlayer.this.pauseBtn.setVisibility(0);
                    JWVideoPlayer.this.player.setPlayWhenReady(true);
                }
            });
            dialog.findViewById(R.id.btn_dialog_submit).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.JWextractor.JWVideoPlayer.10
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    String string = editText.getText().toString();
                    if (string.length() > 0) {
                        dialog.dismiss();
                        Helper.hideKeyboard(JWVideoPlayer.this);
                        JWVideoPlayer.this.BookMarkApi("", str, string, "1");
                    } else {
                        JWVideoPlayer jWVideoPlayer = JWVideoPlayer.this;
                        Toast.makeText(jWVideoPlayer, jWVideoPlayer.getResources().getString(R.string.add_title), 0).show();
                    }
                }
            });
            dialog.show();
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.player_is_not_initialized_yet), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BookMarkApi(String id, String time, String info2, final String state) {
        this.time = time;
        this.f307info = info2;
        this.state = state;
        this.networkCall.NetworkAPICall(API.add_video_index, "", false, false);
    }

    private String formattedTime(long millis) {
        if (millis < 1) {
            return "00:00:00";
        }
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(millis)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));
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
                encryptionData2.setInfo(this.f307info);
                return service.addvideoindex(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/poll/get_content_meta":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setUser_id(MakeMyExam.getUserId());
                encryptionData3.setToken(this.video_id);
                encryptionData3.setCourse_id(this.course_id);
                return service.getmetaData(AES.encrypt(new Gson().toJson(encryptionData3)));
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
        }
        switch (b2) {
            case 0:
                try {
                    if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                        this.bookmarkdata.remove(this.pos);
                        this.bookmarkAdapter.notifyDataSetChanged();
                    } else {
                        ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
                        RetrofitResponse.GetApiData(this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
            case 1:
                try {
                    if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                        this.bookmarkdata.add(((Addindex) new Gson().fromJson(jsonstring.toString(), Addindex.class)).getData());
                        this.bookmarkAdapter.notifyItemChanged(this.bookmarkdata.size());
                        ExoPlayer exoPlayer = this.player;
                        if (exoPlayer != null && exoPlayer.getPlaybackState() == 3) {
                            this.playBtn.setVisibility(8);
                            this.pauseBtn.setVisibility(0);
                            this.player.setPlayWhenReady(true);
                            break;
                        }
                    } else {
                        RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                        break;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 2:
                try {
                    try {
                        if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                            Metadata metadata = (Metadata) new Gson().fromJson(jsonstring.toString(), Metadata.class);
                            this.indexdata.addAll(metadata.getData().getIndex());
                            this.bookmarkdata.addAll(metadata.getData().getBookmark());
                            this.pdf.addAll(metadata.getData().getPdf());
                            int i = this.pdf.size() == 0 ? 0 : 1;
                            int i2 = this.indexdata.size() == 0 ? 0 : 1;
                            setBookMark();
                            isvisiblelayouts(0, i2, 1, 0, i);
                        } else {
                            RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                e.printStackTrace();
                break;
        }
    }

    public void isvisiblelayouts(int ispoll, int isindex, int isbookmark, int islivechat, int ispdf) {
        this.recyclerChat.setVisibility(0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.player.getPlaybackState();
        }
    }

    public void onDelete(VideoTimeFramePojo data, int position) {
        BookMarkDeleteApi(data.getId(), "", "", "2");
        this.pos = position;
    }

    private void BookMarkDeleteApi(String id, String s, String s1, String s2) {
        this.deletedindex = id;
        this.networkCall.NetworkAPICall(API.delete_video_index, "", false, false);
    }

    public void setVideoTimeMS(int timeMS) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null && exoPlayer.getPlayWhenReady()) {
            this.player.seekTo(timeMS);
        } else {
            Toast.makeText(this, getResources().getString(R.string.please_wait_player_is_not_ready), 0).show();
        }
    }

    private class ConnectionChangedListener implements ConnectionClassManager.ConnectionClassStateChangeListener {
        private ConnectionChangedListener() {
        }

        @Override // com.facebook.network.connectionclass.ConnectionClassManager.ConnectionClassStateChangeListener
        public void onBandwidthStateChange(ConnectionQuality bandwidthState) {
            JWVideoPlayer.this.mConnectionClass = bandwidthState;
        }
    }
}
