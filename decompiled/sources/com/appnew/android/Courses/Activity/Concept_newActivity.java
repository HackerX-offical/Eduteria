package com.appnew.android.Courses.Activity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.Courses.Modal.Example;
import com.appnew.android.Courses.Modal.NotesPDF.NoteData;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Video;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.ReadJSInterface;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.StoreProvider;
import com.appnew.android.table.HtmlTbale;
import com.appnew.android.table.UserHistroyTable;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.share.internal.ShareConstants;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import okhttp3.HttpUrl;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class Concept_newActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final int REQUEST_SELECT_FILE = 100;
    public static String somesalthashmap;
    ImageView action_text_formate;
    JSONObject annotateJson;
    private HashMap<String, String> annotationLocalIdsMap;
    private Button brightBackBtn;
    private AppCompatSeekBar brightnessSeekBar;
    private int contentBackColor;
    String courseId;
    private Button darkBackBtn;
    private ArrayList<Example> example;
    HtmlTbale htmlTbale;
    ImageView image_back;
    private boolean isLastSection;
    private ImageView iv_back;
    ObservableWebView mChapterContentWebView;
    private ProgressDialog mProgressDialog;
    private Toolbar mReadChapterContentActionbar;
    private ValueCallback<Uri> mUploadMessage;
    private View markBlack;
    private View markWhite;
    NetworkCall networkCall;
    private RelativeLayout nextChapterLayout;
    ImageView notesIV;
    private int oldTextSize;
    String parentid;
    ReadJSInterface readJSInterface;
    ImageView refresh;
    String sendcourseid;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FrameLayout textDecreaseBtn;
    private FrameLayout textIncreaseBtn;
    RelativeLayout textformatterdialog;
    String tileId;
    TextView toolbarTitleTV;
    private String unzipLocation;
    public ValueCallback<Uri[]> uploadMessage;
    UtkashRoom utkashRoom;
    Video video;
    private View.OnTouchListener webTouchListener;
    private String zipFile;
    private String zip_url;
    int currentSection = 0;
    int size = 1;
    private boolean isInterract = true;
    private final boolean isLoggedIn = true;
    private final boolean mShopView = false;
    private boolean annotationTap = false;
    private boolean isFocusRemoved = true;
    private String action = "";
    private final boolean webSearchTap = false;
    String htmlFilePath = "";
    String final_filename = "";
    String highlightdata = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    int requestCode = -1;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda7
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$8((ActivityResult) obj);
        }
    });

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_newconcept);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            if (this.utkashRoom == null) {
                UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
                this.utkashRoom = appDatabase;
                appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
            }
            Video video = new Video();
            this.video = video;
            video.setId(getIntent().getExtras().getString("id"));
            this.video.setTitle(getIntent().getExtras().getString("name"));
            this.video.setModified(getIntent().getExtras().getString(StoreProvider.StoreData.MODIFIED_DATE) == null ? "0" : getIntent().getExtras().getString(StoreProvider.StoreData.MODIFIED_DATE));
            this.courseId = getIntent().getExtras().getString("course_id");
            this.tileId = getIntent().getExtras().getString("tile_id");
            if (this.courseId.contains(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                String[] strArrSplit = this.courseId.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                if (strArrSplit.length == 1) {
                    this.sendcourseid = strArrSplit[0];
                    this.parentid = "";
                } else {
                    this.sendcourseid = strArrSplit[1];
                    this.parentid = strArrSplit[0];
                }
            } else {
                this.sendcourseid = this.courseId;
            }
            this.networkCall = new NetworkCall(this, this);
            this.nextChapterLayout = (RelativeLayout) findViewById(R.id.nextChapterLayout);
            this.notesIV = (ImageView) findViewById(R.id.notesIV);
            this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
            this.mReadChapterContentActionbar = (Toolbar) findViewById(R.id.readchaptertoolbar);
            this.brightnessSeekBar = (AppCompatSeekBar) findViewById(R.id.brightnessSeekBar);
            this.textDecreaseBtn = (FrameLayout) findViewById(R.id.textSizeDecrease);
            this.textIncreaseBtn = (FrameLayout) findViewById(R.id.textSizeIncrease);
            this.refresh = (ImageView) findViewById(R.id.refresh);
            this.markBlack = findViewById(R.id.markBlack);
            this.markWhite = findViewById(R.id.markWhite);
            this.brightBackBtn = (Button) findViewById(R.id.whitebackbtn);
            this.darkBackBtn = (Button) findViewById(R.id.darkbackbtn);
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.read_swipe_refresh);
            this.swipeRefreshLayout = swipeRefreshLayout;
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    this.f$0.updateContent();
                }
            });
            this.refresh.setVisibility(8);
            this.textformatterdialog = (RelativeLayout) findViewById(R.id.textformatterdialog);
            this.action_text_formate = (ImageView) findViewById(R.id.action_text_formate);
            this.textformatterdialog.setVisibility(8);
            ImageView imageView = (ImageView) findViewById(R.id.iv_back);
            this.iv_back = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Concept_newActivity.this.onBackPressed();
                }
            });
            this.oldTextSize = 12;
            if (getSupportActionBar() == null) {
                setSupportActionBar(this.mReadChapterContentActionbar);
                if (getSupportActionBar() == null) {
                    return;
                }
                this.toolbarTitleTV.setSelected(true);
                this.toolbarTitleTV.setText(this.video.getTitle());
            }
            this.nextChapterLayout.setVisibility(8);
            startRequiredRead();
            this.mChapterContentWebView = (ObservableWebView) findViewById(R.id.chapter_content_webview);
            this.readJSInterface = new ReadJSInterface(this.mChapterContentWebView, this);
            this.mChapterContentWebView.setWebChromeClient(new ChatBotChromeClient());
            this.action_text_formate.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Concept_newActivity.this.textformatterdialog.getVisibility() == 0) {
                        Concept_newActivity.this.textformatterdialog.setVisibility(8);
                        Concept_newActivity.this.action_text_formate.getDrawable().clearColorFilter();
                    } else {
                        Concept_newActivity.this.textformatterdialog.setVisibility(0);
                        if (Concept_newActivity.this.mChapterContentWebView.hasFocus()) {
                            Concept_newActivity.this.mChapterContentWebView.clearFocus();
                        }
                        Concept_newActivity.this.action_text_formate.getDrawable().mutate().setColorFilter(Concept_newActivity.this.getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
                    }
                }
            });
            this.mReadChapterContentActionbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$0(view);
                }
            });
            this.mChapterContentWebView.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.3
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView view, String url) {
                    Concept_newActivity concept_newActivity = Concept_newActivity.this;
                    concept_newActivity.configureWebView(concept_newActivity.mChapterContentWebView, 0);
                    Concept_newActivity.this.getWindow().clearFlags(16);
                    Concept_newActivity.this.setupNextChapterUI();
                    if (!Concept_newActivity.this.mChapterContentWebView.canScrollVertically(-1) && !Concept_newActivity.this.mChapterContentWebView.canScrollVertically(1) && Concept_newActivity.this.nextChapterLayout.getVisibility() != 0 && !Concept_newActivity.this.isLastSection && Concept_newActivity.this.currentSection + 1 < Concept_newActivity.this.size) {
                        Concept_newActivity.this.nextChapterLayout.setVisibility(0);
                    }
                    view.evaluateJavascript("window.TextToSpeech.processContent(document.getElementsByTagName('body')[0].innerText, document.getElementsByTagName('body')[0].innerText.length, document.getElementsByTagName('body')[0].innerText.split(' '));", null);
                }
            });
            this.mChapterContentWebView.addJavascriptInterface(this.readJSInterface, "ReadJSInterface");
            this.annotationLocalIdsMap = new HashMap<>();
            configureWebView(this.mChapterContentWebView, 0);
            somesalthashmap = UUID.randomUUID().toString();
            this.example = new ArrayList<>();
            if (this.utkashRoom.gethtmllink().is_concept_exit(MakeMyExam.userId, this.video.getId())) {
                HtmlTbale htmlTbale = this.utkashRoom.gethtmllink().getconcept(MakeMyExam.userId, this.video.getId());
                if ((htmlTbale != null && htmlTbale.getValid_to() == null) || Long.parseLong(this.video.getModified()) > Long.parseLong(((HtmlTbale) Objects.requireNonNull(htmlTbale)).getValid_to())) {
                    this.utkashRoom.gethtmllink().delete_viaconceptid(this.video.getId(), MakeMyExam.userId);
                    hit_api_for_html();
                } else {
                    this.highlightdata = htmlTbale.getHighight();
                    this.example = (ArrayList) new Gson().fromJson(this.highlightdata, new TypeToken<ArrayList<Example>>() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.4
                    }.getType());
                    try {
                        UserHistroyTable userHistroyTable = new UserHistroyTable();
                        userHistroyTable.setVideo_id(this.video.getId());
                        userHistroyTable.setVideo_name(this.video.getTitle());
                        userHistroyTable.setType("CONCEPT");
                        userHistroyTable.setUser_id(MakeMyExam.userId);
                        userHistroyTable.setTileid(this.tileId);
                        userHistroyTable.setCourse_id(this.courseId);
                        userHistroyTable.setValid_to(this.video.getModified());
                        userHistroyTable.setCurrent_time("" + MakeMyExam.getTime_server());
                        UtkashRoom.getAppDatabase(this).getuserhistorydao().addUser(userHistroyTable);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    load_data(htmlTbale.getHtml());
                }
            } else {
                hit_api_for_html();
            }
            this.notesIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Concept_newActivity.this.example.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (Example example : Concept_newActivity.this.example) {
                            NoteData noteData = new NoteData();
                            if (example.getText() != null && !example.getText().equalsIgnoreCase("")) {
                                noteData.setType(Const.NOTE);
                                noteData.setUserId(MakeMyExam.userId);
                                noteData.setTitle(example.getText());
                                noteData.setQueryData(example.getQuote());
                            } else {
                                noteData.setType("");
                                noteData.setUserId(MakeMyExam.userId);
                                noteData.setQueryData(example.getQuote());
                            }
                            arrayList.add(noteData);
                        }
                        if (arrayList.size() > 0) {
                            Intent intent = new Intent(Concept_newActivity.this, (Class<?>) MyNotesActivity.class);
                            intent.putExtra("video", Concept_newActivity.this.video);
                            intent.putExtra("course_id", Concept_newActivity.this.courseId);
                            intent.putExtra("notes_data", new Gson().toJson(arrayList));
                            intent.putExtra("tile_id", Concept_newActivity.this.tileId);
                            Helper.gotoActivity(intent, Concept_newActivity.this);
                            return;
                        }
                        Snackbar.make(Concept_newActivity.this.nextChapterLayout, Concept_newActivity.this.getResources().getString(R.string.no_notes_found), -1).show();
                        return;
                    }
                    Snackbar.make(Concept_newActivity.this.nextChapterLayout, Concept_newActivity.this.getResources().getString(R.string.no_notes_found), -1).show();
                }
            });
            this.brightnessSeekBar.setMax(100);
            try {
                this.brightnessSeekBar.setProgress(Settings.System.getInt(getContentResolver(), "screen_brightness"), true);
            } catch (Settings.SettingNotFoundException unused) {
            }
            this.brightnessSeekBar.jumpDrawablesToCurrentState();
            this.brightnessSeekBar.incrementProgressBy(5);
            this.brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.6
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b2) {
                    float f2 = progress / 100.0f;
                    WindowManager.LayoutParams attributes = Concept_newActivity.this.getWindow().getAttributes();
                    attributes.screenBrightness = f2;
                    Concept_newActivity.this.getWindow().setAttributes(attributes);
                }
            });
            this.markWhite.setBackgroundColor(ActivityCompat.getColor(this, R.color.colorPrimaryDark));
            this.brightBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$1(view);
                }
            });
            this.darkBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$2(view);
                }
            });
            this.textIncreaseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$3(view);
                }
            });
            this.textDecreaseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$4(view);
                }
            });
            this.mChapterContentWebView.setDownloadListener(new DownloadListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.7
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Concept_newActivity.this.toolbarTitleTV.getText().toString().trim());
                    ((DownloadManager) Concept_newActivity.this.getSystemService("download")).enqueue(request);
                    Toast.makeText(Concept_newActivity.this.getApplicationContext(), Concept_newActivity.this.getResources().getString(R.string.downloading_file), 1).show();
                    Helper.dismissProgressDialog();
                }
            });
        } catch (Exception e3) {
            Helper.dismissProgressDialog();
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.contentBackColor = 0;
        configureWebView(this.mChapterContentWebView, 0);
        this.markWhite.setBackgroundColor(ActivityCompat.getColor(this, R.color.colorPrimaryDark));
        this.markBlack.setBackgroundColor(Color.parseColor("#333333"));
        this.nextChapterLayout.setBackgroundResource(R.color.white);
        ((TextView) this.nextChapterLayout.findViewById(R.id.nameLabel)).setTextColor(Color.parseColor(Constants.BLACK));
        ((TextView) this.nextChapterLayout.findViewById(R.id.chapterNameTxt)).setTextColor(Color.parseColor(Constants.BLACK));
        ((AppCompatImageView) this.nextChapterLayout.findViewById(R.id.nextImageView)).clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.contentBackColor = R.color.colorWhite;
        configureWebView(this.mChapterContentWebView, R.color.colorWhite);
        this.markBlack.setBackgroundColor(ActivityCompat.getColor(this, R.color.colorPrimaryDark));
        this.markWhite.setBackgroundColor(Color.parseColor("#F2F2F2"));
        this.nextChapterLayout.setBackgroundResource(R.color.colorWhite);
        ((TextView) this.nextChapterLayout.findViewById(R.id.nameLabel)).setTextColor(Color.parseColor("#ffffff"));
        ((TextView) this.nextChapterLayout.findViewById(R.id.chapterNameTxt)).setTextColor(Color.parseColor("#ffffff"));
        ((AppCompatImageView) this.nextChapterLayout.findViewById(R.id.nextImageView)).setColorFilter(Color.parseColor("#ffffff"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (this.oldTextSize + 2 <= 54) {
            this.mChapterContentWebView.getSettings().setTextZoom(this.mChapterContentWebView.getSettings().getTextZoom() + 2);
            this.oldTextSize += 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        if (this.oldTextSize - 2 >= 12) {
            this.mChapterContentWebView.getSettings().setTextZoom(this.mChapterContentWebView.getSettings().getTextZoom() - 2);
            this.oldTextSize -= 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContent() {
        if (Helper.isNetworkConnected(this)) {
            this.networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", false, false);
        } else {
            this.swipeRefreshLayout.setRefreshing(false);
            Snackbar.make(this.mChapterContentWebView, getResources().getString(R.string.no_internet_connection), -1).show();
        }
    }

    private void hit_api_for_html() {
        this.networkCall.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source", "", true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupNextChapterUI() {
        this.nextChapterLayout.setVisibility(8);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode mode) {
        mode.getMenu().clear();
        super.onSupportActionModeStarted(mode);
    }

    private void startRequiredRead() {
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureWebView(final WebView webView, int colorId) {
        if (colorId == 0) {
            webView.evaluateJavascript("document.body.style.backgroundColor=\"white\";document.body.style.color=\"black\";", null);
            webView.evaluateJavascript("document.body.classList.add('blackTheme');", null);
            webView.evaluateJavascript("document.body.classList.remove('whiteTheme');", null);
        } else {
            webView.evaluateJavascript("document.body.style.backgroundColor=\"black\";document.body.style.color=\"white\";", null);
            webView.evaluateJavascript("document.body.classList.add('whiteTheme');", null);
            webView.evaluateJavascript("document.body.classList.remove('blackTheme');", null);
        }
        webView.setLayerType(2, null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setClickable(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        File cacheDir = getCacheDir();
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }
        webView.getSettings().setCacheMode(-1);
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.8
            private static final int MAX_CLICK_DISTANCE = 15;
            private static final int MAX_CLICK_DURATION = 700;
            private long pressStartTime;
            private float pressedX;
            private float pressedY;
            private boolean stayedWithinClickDistance;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Concept_newActivity.this.isInterract = false;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.pressedX = motionEvent.getX();
                    this.pressedY = motionEvent.getY();
                    this.stayedWithinClickDistance = true;
                    if (Concept_newActivity.this.textformatterdialog.getVisibility() == 0) {
                        Concept_newActivity.this.action_text_formate.getDrawable().clearColorFilter();
                        Concept_newActivity.this.textformatterdialog.setVisibility(8);
                    }
                } else if (action == 2 && this.stayedWithinClickDistance && Concept_newActivity.this.distance(this.pressedX, this.pressedY, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                    this.stayedWithinClickDistance = false;
                    if ((Concept_newActivity.this.getSupportActionBar().isShowing() || Concept_newActivity.this.nextChapterLayout.getVisibility() == 0 || !Concept_newActivity.this.mChapterContentWebView.canScrollVertically(1)) && Concept_newActivity.this.nextChapterLayout.getVisibility() == 0 && (Concept_newActivity.this.mChapterContentWebView.canScrollVertically(-1) || Concept_newActivity.this.mChapterContentWebView.canScrollVertically(1))) {
                        Concept_newActivity.this.isInterract = true;
                        Concept_newActivity.this.nextChapterLayout.setVisibility(8);
                    }
                }
                return Concept_newActivity.this.isInterract;
            }
        };
        this.webTouchListener = onTouchListener;
        webView.setOnTouchListener(onTouchListener);
        webView.setWebChromeClient(new ChatBotChromeClient());
        webView.getSettings().setDefaultFontSize(14);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$configureWebView$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$configureWebView$5(View view) {
        return this.isInterract;
    }

    private float pxToDp(float px) {
        return px / getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float distance(float x1, float y1, float x2, float y2) {
        float f2 = x1 - x2;
        float f3 = y1 - y2;
        return pxToDp((float) Math.sqrt((f2 * f2) + (f3 * f3)));
    }

    private String getOfflineKatexConfig(String formulaString) {
        if (formulaString != null) {
            return ("<!DOCTYPE html>\n<html>\n    <head>\n        <meta charset=\"UTF-8\">\n        <title>Auto-render test</title>\n        <link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/katex/katex.min.css\">\n        <link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/annotator/annotator.touch.css\"/>\n        <script type=\"text/javascript\" src=\"file:///android_asset/annotator/jquery-1.11.2.min.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///android_asset/katex/katex.min.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///android_asset/annotator/annotator-full.min.js\"/></script>\n        <script type=\"text/javascript\" src=\"file:///android_asset/annotator/annotator.touch.min.js\"/></script>\n        <script type=\"text/javascript\" src=\"file:///android_asset/katex/contrib/auto-render.min.js\"></script>\n <style type='text/css'>body {margin: 5px;padding: 10px;font-size:12pxcolor:#EEEEEE; } </style>    </head>\n    <body id='highlightPos'>\n<div id=\"htmlreadingcontent\">\n        <div id=\"htmlContent\">\n        {formula}\n</div>\n</div>\n        <script>\n          renderMathInElement(\n              document.body\n          );\nvar annotation;\nvar json =" + this.highlightdata + ";\nannotation = $('#htmlreadingcontent').annotator();\n    annotation.annotator('addPlugin', 'Touch', {\n      force: location.search.indexOf('force') > -1,\n      useHighlighter: location.search.indexOf('highlighter') > -1\n    });\n     Annotator.Plugin.StoreLogger = function (element) {\n        return {\n            pluginInit: function () {   \n                this.annotator\n\n                .subscribe(\"annotationCreated\", function (annotation) {\n                    console.log(\"after created=\"+JSON.stringify(annotation));\n                    ReadJSInterface.annotationData(JSON.stringify(annotation),\"create\");\n                                  \n                })\n                .subscribe(\"annotationUpdated\", function (annotation) {\n                    console.log(\"after updated=\"+JSON.stringify(annotation));\n                    ReadJSInterface.annotationData(JSON.stringify(annotation),\"update\");\n                                  \n                })\n                .subscribe(\"annotationDeleted\", function (annotation) {\n                    console.log(\"after deleted=\"+JSON.stringify(annotation));\n                    ReadJSInterface.annotationData(JSON.stringify(annotation),\"delete\");\n                                  \n                })\n               \n            }\n        } \n    };    \n  \n\nwindow.onscroll = function(ev) {\nif ((window.innerHeight + window.pageYOffset) >= document.body.offsetHeight) {\n       ReadJSInterface.scrollEnd(); \n    }\n};\nannotation.annotator('loadAnnotations', json);\nannotation.annotator('addPlugin', 'StoreLogger');\nvar customPosition = document.getElementById('highlightPos');\n\n        </script>\n    </body>\n</html>").replace("{formula}", formulaString);
        }
        return "";
    }

    public void onScrolledBottom() {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onScrolledBottom$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onScrolledBottom$6() {
        this.nextChapterLayout.setVisibility(8);
    }

    public void onAnnotationCall(String annotationString, String action) {
        if (annotationString.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(annotationString);
            if (!jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_QUOTE) || jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_QUOTE).isEmpty()) {
                return;
            }
            if (!jSONObject.has("id") && !getLocalId(jSONObject.getString("ranges")).isEmpty()) {
                jSONObject.put("id", getLocalId(jSONObject.getString("ranges")));
            }
            handleAnnotation(jSONObject, action);
        } catch (JSONException unused) {
        }
    }

    public void onAnnotationTap(boolean state) {
        this.annotationTap = state;
    }

    public void onWebSearchTap(final String query) {
        if (getSupportActionBar() != null) {
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onWebSearchTap$7(query);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onWebSearchTap$7(String str) {
        Helper.GoWebViewPDFActivity(this, getResources().getString(R.string.web_search), "https://www.google.com/search?q=" + str);
        invalidateOptionsMenu();
    }

    private String getLocalId(String key) {
        if (this.annotationLocalIdsMap.containsKey(key)) {
            return this.annotationLocalIdsMap.get(key);
        }
        return "";
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode mode) {
        this.isFocusRemoved = false;
        super.onActionModeStarted(mode);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void handleAnnotation(final JSONObject annotateJson, String action) {
        byte b2 = 1;
        this.isFocusRemoved = true;
        this.annotationTap = false;
        action.hashCode();
        switch (action.hashCode()) {
            case -1352294148:
                b2 = !action.equals("create") ? (byte) -1 : (byte) 0;
                break;
            case -1335458389:
                if (!action.equals("delete")) {
                    b2 = -1;
                }
                break;
            case -838846263:
                b2 = !action.equals(DiscoverItems.Item.UPDATE_ACTION) ? (byte) -1 : (byte) 2;
                break;
            default:
                b2 = -1;
                break;
        }
        try {
            switch (b2) {
                case 0:
                    if (Helper.isNetworkConnected(this)) {
                        add_anitaion(annotateJson, action);
                    }
                    break;
                case 1:
                    if (Helper.isNetworkConnected(this)) {
                        delete_annotation(annotateJson, action);
                    }
                    break;
                case 2:
                    if (Helper.isNetworkConnected(this)) {
                        add_anitaion(annotateJson, action);
                    }
                    break;
            }
        } catch (Exception unused) {
        }
    }

    private void add_anitaion(JSONObject annotateJson, String action) {
        this.annotateJson = annotateJson;
        this.action = action;
        this.networkCall.NetworkAPICall(API.create_annotation, "", false, false);
    }

    private void delete_annotation(JSONObject annotateJson, String action) {
        this.annotateJson = annotateJson;
        this.action = action;
        this.networkCall.NetworkAPICall(API.delete_annotation, "", false, false);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        RelativeLayout relativeLayout = this.textformatterdialog;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.textformatterdialog.setVisibility(8);
            this.action_text_formate.getDrawable().clearColorFilter();
            return;
        }
        ObservableWebView observableWebView = this.mChapterContentWebView;
        if (observableWebView != null && observableWebView.hasFocus() && this.annotationTap) {
            this.mChapterContentWebView.clearFocus();
            this.isFocusRemoved = true;
            this.annotationTap = false;
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/delete_annotation":
                try {
                    EncryptionData encryptionData = new EncryptionData();
                    encryptionData.setAnnotation_id(this.annotateJson.getString("id"));
                    return service.delete_annotation(AES.encrypt(new Gson().toJson(encryptionData)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setName(this.video.getId() + "_0_0");
                encryptionData2.setCourse_id(this.sendcourseid);
                encryptionData2.setParent_id(this.parentid);
                encryptionData2.setTile_id(this.tileId);
                encryptionData2.setType(Const.CONCEPT);
                return service.get_video_link_concept(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/create_annotation":
                break;
            default:
                return null;
        }
        EncryptionData encryptionData3 = new EncryptionData();
        try {
            if (this.action.equalsIgnoreCase("create")) {
                encryptionData3.setId("");
            } else {
                encryptionData3.setId(this.annotateJson.getString("id"));
            }
            encryptionData3.setFile_id(this.video.getId());
            if (this.annotateJson.has("text")) {
                encryptionData3.setText(this.annotateJson.getString("text"));
            } else {
                encryptionData3.setText("");
            }
            encryptionData3.setQuote(this.annotateJson.getString(ShareConstants.WEB_DIALOG_PARAM_QUOTE));
            encryptionData3.setRanges(this.annotateJson.getString("ranges"));
            return service.create_annotation(AES.encrypt(new Gson().toJson(encryptionData3)));
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/delete_annotation":
                try {
                    if (jsonobject.getString("status").equalsIgnoreCase("true")) {
                        Snackbar.make(this.nextChapterLayout, "" + new JSONObject(jsonobject.toString()).getString("message"), -1).show();
                        for (int i = 0; i < this.example.size(); i++) {
                            try {
                                if (!getLocalId(this.annotateJson.getString("ranges")).isEmpty()) {
                                    this.annotationLocalIdsMap.remove(this.annotateJson.getString("ranges"));
                                }
                            } catch (NullPointerException | JSONException unused) {
                            }
                            if (this.example.get(i).getId().equalsIgnoreCase(this.annotateJson.getString("id"))) {
                                this.example.remove(i);
                                this.utkashRoom.gethtmllink().update_highlight(new Gson().toJson(this.example), MakeMyExam.userId, this.video.getId());
                                return;
                            }
                        }
                        return;
                    }
                    ErrorCallBack(jsonobject.getString("message"), apitype, typeApi);
                    RetrofitResponse.GetApiData(this, jsonobject.getString("auth_code"), jsonobject.getString("message"), false);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    break;
                }
                break;
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/on_request_meta_source":
                try {
                    if (this.swipeRefreshLayout.isRefreshing()) {
                        this.utkashRoom.gethtmllink().deletedata();
                        this.swipeRefreshLayout.setRefreshing(false);
                    }
                    if (jsonobject.getString("status").equalsIgnoreCase("true")) {
                        JSONObject jSONObject = new JSONObject(jsonobject.toString());
                        if (jSONObject.has("data")) {
                            String string = jSONObject.getJSONObject("data").getString("description");
                            String string2 = jSONObject.getJSONObject("data").getString("annotations");
                            this.highlightdata = string2;
                            if (string2.equalsIgnoreCase(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                                this.highlightdata = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                            } else {
                                this.example = (ArrayList) new Gson().fromJson(this.highlightdata, new TypeToken<ArrayList<Example>>() { // from class: com.appnew.android.Courses.Activity.Concept_newActivity.9
                                }.getType());
                            }
                            HtmlTbale htmlTbale = new HtmlTbale();
                            this.htmlTbale = htmlTbale;
                            htmlTbale.setHtml(string);
                            this.htmlTbale.setUser_id(MakeMyExam.userId);
                            this.htmlTbale.setHighight(this.highlightdata);
                            this.htmlTbale.setConcept_id(this.video.getId());
                            this.htmlTbale.setCourse_id(this.courseId);
                            this.htmlTbale.setTile_id(this.tileId);
                            this.htmlTbale.setValid_to(this.video.getModified());
                            this.utkashRoom.gethtmllink().addUser(this.htmlTbale);
                            try {
                                UserHistroyTable userHistroyTable = new UserHistroyTable();
                                userHistroyTable.setVideo_id(this.video.getId());
                                userHistroyTable.setVideo_name(this.video.getTitle());
                                userHistroyTable.setType("CONCEPT");
                                userHistroyTable.setUser_id(MakeMyExam.userId);
                                userHistroyTable.setTileid(this.tileId);
                                userHistroyTable.setValid_to(this.video.getModified());
                                userHistroyTable.setCourse_id(this.courseId);
                                userHistroyTable.setCurrent_time("" + MakeMyExam.getTime_server());
                                UtkashRoom.getAppDatabase(this).getuserhistorydao().addUser(userHistroyTable);
                                break;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            load_data(string);
                            return;
                        }
                        Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
                        return;
                    }
                    ErrorCallBack(jsonobject.getString("message"), apitype, typeApi);
                    RetrofitResponse.GetApiData(this, jsonobject.getString("auth_code"), jsonobject.getString("message"), false);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            case "https://appapi.videocrypt.in/index.php/data_model/meta_distributer/create_annotation":
                break;
            default:
                return;
        }
        try {
            if (jsonobject.getString("status").equalsIgnoreCase("true")) {
                JSONObject jSONObject2 = new JSONObject(jsonobject.toString());
                Snackbar.make(this.nextChapterLayout, "" + jSONObject2.getString("message"), -1).show();
                if (this.action.equalsIgnoreCase("create")) {
                    String string3 = jSONObject2.getJSONObject("data").getString("id");
                    this.annotationLocalIdsMap.put(this.annotateJson.getString("ranges"), string3);
                    Example example = (Example) new Gson().fromJson(this.annotateJson.toString(), Example.class);
                    example.setId(string3);
                    this.example.add(example);
                    this.highlightdata = new Gson().toJson(this.example);
                } else {
                    String string4 = jSONObject2.getJSONObject("data").getString("id");
                    int i2 = 0;
                    while (true) {
                        if (i2 < this.example.size()) {
                            try {
                                this.annotationLocalIdsMap.put(this.annotateJson.getString("ranges"), string4);
                            } catch (NullPointerException | JSONException unused3) {
                            }
                            if (this.example.get(i2).getId().equalsIgnoreCase(string4)) {
                                Example example2 = (Example) new Gson().fromJson(this.annotateJson.toString(), Example.class);
                                example2.setId(string4);
                                this.example.set(i2, example2);
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                this.utkashRoom.gethtmllink().update_highlight(new Gson().toJson(this.example), MakeMyExam.userId, this.video.getId());
                return;
            }
            ErrorCallBack(jsonobject.getString("message"), apitype, typeApi);
            RetrofitResponse.GetApiData(this, jsonobject.getString("auth_code"), jsonobject.getString("message"), false);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Toast.makeText(this, jsonstring, 0).show();
    }

    class DownloadMapAsync extends AsyncTask<String, String, String> {
        String result = "";

        DownloadMapAsync() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            Concept_newActivity.this.mProgressDialog = new ProgressDialog(Concept_newActivity.this);
            Concept_newActivity.this.mProgressDialog.setMessage("Please Wait...Extracting zip file ... ");
            Concept_newActivity.this.mProgressDialog.setProgressStyle(0);
            Concept_newActivity.this.mProgressDialog.setCancelable(false);
            Concept_newActivity.this.mProgressDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... aurl) {
            try {
                URL url = new URL(aurl[0]);
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.connect();
                int contentLength = uRLConnectionOpenConnection.getContentLength();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(Concept_newActivity.this.zipFile);
                byte[] bArr = new byte[1024];
                long j = 0;
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i != -1) {
                        j += (long) i;
                        publishProgress("" + ((int) ((100 * j) / ((long) contentLength))));
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        this.result = "true";
                        return null;
                    }
                }
            } catch (Exception unused) {
                this.result = "false";
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String unused) {
            if (this.result.equalsIgnoreCase("true")) {
                try {
                    Concept_newActivity.this.unzip();
                    return;
                } catch (IOException e2) {
                    Concept_newActivity.this.mProgressDialog.dismiss();
                    e2.printStackTrace();
                    return;
                }
            }
            Concept_newActivity.this.mProgressDialog.dismiss();
        }
    }

    public void unzip() throws IOException {
        new UnZipTask().execute(this.zipFile, this.unzipLocation);
    }

    private class UnZipTask extends AsyncTask<String, Void, Boolean> {
        private UnZipTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... params) {
            String str = params[0];
            String str2 = params[1];
            try {
                ZipFile zipFile = new ZipFile(new File(str));
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    unzipEntry(zipFile, enumerationEntries.nextElement(), str2);
                }
                Concept_newActivity concept_newActivity = Concept_newActivity.this;
                concept_newActivity.new UnzipUtil(concept_newActivity.zipFile, Concept_newActivity.this.unzipLocation).unzip();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            Concept_newActivity.this.mProgressDialog.dismiss();
            if (result.booleanValue() && new File(Concept_newActivity.this.final_filename).exists() && new File(Concept_newActivity.this.final_filename).getName().contains(".html")) {
                Concept_newActivity concept_newActivity = Concept_newActivity.this;
                String htmlContent = concept_newActivity.getHtmlContent(concept_newActivity.final_filename);
                Concept_newActivity.this.htmlTbale = new HtmlTbale();
                Concept_newActivity.this.htmlTbale.setHtml(htmlContent);
                Concept_newActivity.this.htmlTbale.setCourse_id(Concept_newActivity.this.zip_url);
                Concept_newActivity.this.htmlTbale.setUser_id(MakeMyExam.userId);
                Concept_newActivity.this.htmlTbale.setHighight(Concept_newActivity.this.highlightdata);
                Concept_newActivity.this.utkashRoom.gethtmllink().addUser(Concept_newActivity.this.htmlTbale);
                Concept_newActivity.this.loadHtml(htmlContent, false);
            }
        }

        private void unzipEntry(ZipFile zipfile, ZipEntry entry, String outputDir) throws IOException {
            if (entry.isDirectory()) {
                createDir(new File(outputDir, entry.getName()));
                return;
            }
            File file = new File(outputDir, entry.getName());
            if (!file.getParentFile().exists()) {
                createDir(file.getParentFile());
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipfile.getInputStream(entry));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();
        }

        private void createDir(File dir) {
            if (!dir.exists() && !dir.mkdirs()) {
                throw new RuntimeException("Can not create dir " + dir);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadHtml(String html, boolean data_img_exist) {
        String strSubstring;
        if (html.contains("../Images")) {
            StringBuilder sb = new StringBuilder();
            String str = this.zip_url;
            String strReplace = html.replace("../Images", sb.append(str.substring(0, str.lastIndexOf(47))).append("/extract/OEBPS/Images").toString());
            if (strReplace.contains("../Styles/")) {
                StringBuilder sb2 = new StringBuilder();
                String str2 = this.zip_url;
                strReplace = strReplace.replace("../Styles", sb2.append(str2.substring(0, str2.lastIndexOf(47))).append("/extract/OEBPS/Styles").toString());
            }
            if (strReplace.contains("fonts/")) {
                StringBuilder sb3 = new StringBuilder();
                String str3 = this.zip_url;
                strReplace = strReplace.replace("fonts/", sb3.append(str3.substring(0, str3.lastIndexOf(47))).append("/extract/OEBPS/fonts/").toString());
            }
            load_data(strReplace);
            return;
        }
        if (html.contains("Images/")) {
            Matcher matcher = Pattern.compile("(?i)<img[^>]+?src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>").matcher(html);
            while (true) {
                if (!matcher.find()) {
                    strSubstring = "";
                    break;
                }
                data_img_exist = true;
                String strGroup = matcher.group(1);
                if (((String) Objects.requireNonNull(strGroup)).contains("OEBPS")) {
                    strSubstring = strGroup.substring(0, strGroup.lastIndexOf(47));
                    break;
                }
            }
            if (data_img_exist) {
                if (strSubstring.equalsIgnoreCase("")) {
                    return;
                }
                String strReplace2 = html.replace(strSubstring, "Images").replace("Images/", strSubstring + MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (strReplace2.contains("/funlearn/downloadEpubImage?source=upload/")) {
                    strReplace2 = strReplace2.replace("/funlearn/downloadEpubImage?source=upload/", "https://utkarsh-efs.s3.ap-south-1.amazonaws.com/v1/");
                }
                load_data(strReplace2);
                return;
            }
            load_data(html);
            return;
        }
        load_data(html);
    }

    public class UnzipUtil {
        private final String _location;
        private final String _zipFile;

        public UnzipUtil(String zipFile, String location) {
            this._zipFile = zipFile;
            this._location = location;
            _dirChecker("");
        }

        public void unzip() {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(this._zipFile));
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    if (nextEntry.isDirectory()) {
                        _dirChecker(nextEntry.getName());
                    } else if (nextEntry.getName().contains(".html")) {
                        FileOutputStream fileOutputStream = new FileOutputStream(this._location + nextEntry.getName());
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = zipInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, i);
                            }
                        }
                        fileOutputStream.close();
                        zipInputStream.closeEntry();
                        Concept_newActivity.this.final_filename = this._location + nextEntry.getName();
                    }
                }
                zipInputStream.close();
            } catch (Exception unused) {
            }
        }

        private void _dirChecker(String dir) {
            File file = new File(this._location + dir);
            if (file.isDirectory()) {
                return;
            }
            file.mkdirs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getHtmlContent(String htmlFilePath) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(htmlFilePath);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                bufferedReader.close();
            }
            return sb.toString();
        } catch (IOException unused) {
            return "";
        }
    }

    private void load_data(String data) {
        String strReplaceAll = getOfflineKatexConfig(data).replaceAll("</head>", "<style>\n@font-face { font-family: 'Work Sans Regular'; src: url('file:///android_asset/fonts/WorkSans-Regular.ttf');}@font-face { font-family: 'Work Sans Medium'; src: url('file:///android_asset/fonts/WorkSans-Medium.ttf');}@font-face { font-family: 'Work Sans Light'; src: url('file:///android_asset/fonts/WorkSans-Light.ttf');}@font-face { font-family: 'Work Sans Bold'; src: url('file:///android_asset/fonts/WorkSans-Bold.ttf');}@font-face { font-family: 'Work Sans SemiBold'; src: url('file:///android_asset/fonts/WorkSans-SemiBold.ttf');}html, body {\n  font-family: 'Work Sans Light' !important; \n  font-size: 16px;\n  line-height: 24px;\n  letter-spacing: 0.01em;\n  color: #1B2733;\n  font-weight: 300;\n  overflow: auto;\n  overflow-x: hidden;\n  -webkit-overflow-scrolling: touch;\n}.table-responsive {\n   display: block;\n   width: 100%;\n   overflow-x: auto;\n   -webkit-overflow-scrolling: touch;\n   -ms-overflow-style: -ms-autohiding-scrollbar;\n}body a, p, span, ul, li {\n}.blackTheme {\ncolor:black !important;\n}\n.whiteTheme {\ncolor:white !important;\n}\n.whiteTheme p span{\ncolor:white !important;\n}\n#htmlreadingcontent img {\n   max-width: 100%;\n   height: auto;\n   border: 0; }\n #htmlreadingcontent h1 {\n   font-family: “Work Sans”, sans-serif;\n   font-size: 30px !important;\n   line-height: 36px !important;\n   letter-spacing: 0.04em !important;\n   color: #1B2733 !important; }\n #htmlreadingcontent h2 {\n   font-family: “Work Sans”, sans-serif;\n   font-size: 24px !important;\n   line-height: 30px !important;\n   letter-spacing: 0.02em !important;\n   color: #1B2733 !important; }\n #htmlreadingcontent h3 {\n   font-family: “Work Sans”, sans-serif;\n   font-size: 18px !important;\n   line-height: 28px !important;\n   letter-spacing: 0.01em !important;\n   color: #1B2733 !important; }\n #htmlreadingcontent p, #htmlreadingcontent span {\n   font-family: “Work Sans”, sans-serif; }\n #htmlreadingcontent span.annotator-hlh {\n   font-size: inherit !important;\n   font-family: inherit; }\n #htmlreadingcontent span.annotator-hl {\n   font-size: inherit !important;\n   font-family: inherit; }\n\n#htmlreadingcontent table {\n   width: 100% !important;\n    border-collapse: collapse;\n}\n#htmlreadingcontent table td p {\ntext-align:unset !important;\n}\n </style>");
        this.mChapterContentWebView.getSettings().setLoadWithOverviewMode(false);
        this.mChapterContentWebView.getSettings().setUseWideViewPort(false);
        this.mChapterContentWebView.getSettings().setSupportZoom(true);
        if (strReplaceAll.contains("<table")) {
            strReplaceAll = strReplaceAll.replace("<table", "<div class=table-responsive><table").replace("</table>", "</table></div>");
        }
        this.mChapterContentWebView.loadDataWithBaseURL("file:///android_asset/font/", strReplaceAll, Mimetypes.MIMETYPE_HTML, "UTF-8", "about:blank");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
        }
        RelativeLayout relativeLayout = this.textformatterdialog;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.textformatterdialog.setVisibility(8);
        this.action_text_formate.getDrawable().clearColorFilter();
    }

    public void changeThemeColor(String color) {
        if (!color.contains(":") || color.split(":").length <= 1) {
            return;
        }
        this.iv_back.setColorFilter(Color.parseColor(SharedPreference.getInstance().getString("theme_color_hai_bhai").split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.notesIV.setColorFilter(Color.parseColor(SharedPreference.getInstance().getString("theme_color_hai_bhai").split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.toolbarTitleTV.setTextColor(Color.parseColor(color.split(":")[1]));
        this.mReadChapterContentActionbar.setBackgroundColor(Color.parseColor(color.split(":")[0]));
        SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(Color.parseColor(color.split(":")[0]));
    }

    class ChatBotChromeClient extends WebChromeClient {
        ChatBotChromeClient() {
        }

        protected void openFileChooser(ValueCallback uploadMsg, String acceptType) {
            Concept_newActivity.this.mUploadMessage = uploadMsg;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            Concept_newActivity.this.someActivityResultLauncher.launch(Intent.createChooser(intent, "File Chooser"));
            Concept_newActivity.this.requestCode = 1;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (Concept_newActivity.this.uploadMessage != null) {
                Concept_newActivity.this.uploadMessage.onReceiveValue(null);
                Concept_newActivity.this.uploadMessage = null;
            }
            Concept_newActivity.this.uploadMessage = filePathCallback;
            fileChooserParams.getAcceptTypes();
            try {
                Concept_newActivity.this.someActivityResultLauncher.launch(fileChooserParams.createIntent());
                Concept_newActivity.this.requestCode = 100;
                return true;
            } catch (ActivityNotFoundException unused) {
                Concept_newActivity.this.uploadMessage = null;
                Concept_newActivity concept_newActivity = Concept_newActivity.this;
                Toast.makeText(concept_newActivity, concept_newActivity.getResources().getString(R.string.cannot_open_file_chooser), 1).show();
                return false;
            }
        }

        protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            Concept_newActivity.this.mUploadMessage = uploadMsg;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            Concept_newActivity.this.someActivityResultLauncher.launch(Intent.createChooser(intent, "File Chooser"));
            Concept_newActivity.this.requestCode = 1;
        }

        protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
            Concept_newActivity.this.mUploadMessage = uploadMsg;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            Concept_newActivity.this.someActivityResultLauncher.launch(Intent.createChooser(intent, "File Chooser"));
            Concept_newActivity.this.requestCode = 1;
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(final PermissionRequest request) {
            request.grant(request.getResources());
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage cm) {
            if (cm == null) {
                return true;
            }
            cm.sourceId().length();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 100) {
            ValueCallback<Uri[]> valueCallback = this.uploadMessage;
            if (valueCallback == null) {
                return;
            }
            valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, intent));
            this.uploadMessage = null;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$8(ActivityResult activityResult) {
        ValueCallback<Uri[]> valueCallback;
        if (this.requestCode != 100 || (valueCallback = this.uploadMessage) == null) {
            return;
        }
        valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(activityResult.getResultCode(), activityResult.getData()));
        this.uploadMessage = null;
    }
}
