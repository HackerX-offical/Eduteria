package com.appnew.android.Webview;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.github.clans.fab.FloatingActionButton;
import com.github.jorgecastilloprz.FABProgressCircle;
import com.github.jorgecastilloprz.listeners.FABProgressListener;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class SearchRevisionVideosActivity extends AppCompatActivity implements View.OnClickListener, FABProgressListener, NetworkCall.MyNetworkCallBack {
    private static final String TAG = "SearchRevisionVideosActivity";
    private String SelectedChapter;
    private String bookId;
    private FloatingActionButton browserAddContent;
    private String chapterDesc;
    private String chapterName;
    private FABProgressCircle fabProgressCircle;
    private String grade;
    private boolean isFromDeepLink;
    ImageView iv_back;
    private String level;
    private RelativeLayout mContentView;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private FrameLayout mCustomViewContainer;
    private boolean mShopView;
    private ValueCallback<Uri[]> mUploadMessage;
    private String resourceContext;
    private String resourceIntent;
    private String searchString;
    private boolean showAddResourceBtn;
    private boolean solutionAdded;
    private String subject;
    private String syllabus;
    TextView toolbartitleTV;
    private String urlString;
    private boolean videoAdded;
    private boolean videoResourceLocal;
    private WSWebChromeClient webChromeClient;
    private Toolbar webResourceBottomBar;
    private Toolbar webResourceToolbar;
    private WebView webResourceWebView;
    private ProgressBar webresourceloader;
    private String videoUrl = "";
    private String tile_id = "";
    private String course_id = "";
    private String mChapterId = "";
    private String mCameraPhotoPath = null;
    ArrayList<Video> videoArrayList = new ArrayList<>();
    ArrayList<Video> seleced_tile_list = new ArrayList<>();
    private String query = "";
    private String f_id = "";
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Webview.SearchRevisionVideosActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$1((ActivityResult) obj);
        }
    });

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_searchvideo_revision);
        this.searchString = getIntent().getStringExtra(Const.SEARCH_QUERY);
        this.tile_id = getIntent().getStringExtra("t_id");
        this.course_id = getIntent().getStringExtra("c_id");
        this.f_id = getIntent().getStringExtra("f_id");
        this.toolbartitleTV = (TextView) findViewById(R.id.toolbartitleTV);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        this.iv_back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.SearchRevisionVideosActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchRevisionVideosActivity.this.onBackPressed();
            }
        });
        this.seleced_tile_list = (ArrayList) getIntent().getSerializableExtra("s_list");
        this.videoArrayList = (ArrayList) getIntent().getSerializableExtra("v_list");
        if (getIntent().getStringExtra("resourceContext") != null && !getIntent().getStringExtra("resourceContext").equalsIgnoreCase(Constants.NULL_VERSION_ID)) {
            this.resourceContext = getIntent().getStringExtra("resourceContext");
            this.showAddResourceBtn = true;
        } else {
            this.resourceContext = "";
        }
        if (getIntent().getStringExtra(SDKConstants.PARAM_INTENT) != null && !getIntent().getStringExtra(SDKConstants.PARAM_INTENT).equalsIgnoreCase(Constants.NULL_VERSION_ID)) {
            this.resourceIntent = getIntent().getStringExtra(SDKConstants.PARAM_INTENT);
        } else {
            this.resourceIntent = "";
        }
        this.webResourceWebView = (WebView) findViewById(R.id.webresourcewebview);
        this.webResourceToolbar = (Toolbar) findViewById(R.id.webresourcetoolbar);
        this.webresourceloader = (ProgressBar) findViewById(R.id.webresourceloader);
        FABProgressCircle fABProgressCircle = (FABProgressCircle) findViewById(R.id.fabProgressCircle);
        this.fabProgressCircle = fABProgressCircle;
        fABProgressCircle.attachListener(this);
        this.webresourceloader.setVisibility(0);
        this.browserAddContent = (FloatingActionButton) findViewById(R.id.add_weblink);
        if (!this.showAddResourceBtn || isResourceList(this.searchString)) {
            this.fabProgressCircle.setVisibility(8);
        } else {
            this.fabProgressCircle.setVisibility(0);
        }
        this.browserAddContent.setOnClickListener(this);
        if (getSupportActionBar() == null) {
            setSupportActionBar(this.webResourceToolbar);
            if (getSupportActionBar() == null) {
                return;
            }
            String str = this.resourceIntent;
            if (str != null && !str.isEmpty()) {
                if (this.resourceIntent.equalsIgnoreCase("videos")) {
                    this.toolbartitleTV.setText(getResources().getString(R.string.video_references));
                } else if (this.resourceIntent.equalsIgnoreCase("webref")) {
                    this.toolbartitleTV.setText(getResources().getString(R.string.web_references));
                } else {
                    this.toolbartitleTV.setText(getResources().getString(R.string.references));
                }
            } else {
                this.toolbartitleTV.setText(getResources().getString(R.string.references));
            }
        }
        if (this.mChapterId.isEmpty() && this.mShopView) {
            this.browserAddContent.setVisibility(8);
        }
        configureWebView(this.webResourceWebView);
        String str2 = this.searchString;
        if (str2 != null && !str2.equalsIgnoreCase("")) {
            this.webResourceWebView.loadUrl(this.searchString);
            return;
        }
        String str3 = this.urlString;
        if (str3 != null && !str3.equalsIgnoreCase("")) {
            this.webResourceWebView.loadUrl(this.urlString);
        } else {
            Toast.makeText(this, getResources().getString(R.string.url_not_valid), 0).show();
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.resourceIntent.equalsIgnoreCase("videos")) {
            if (newConfig.orientation == 2) {
                Toolbar toolbar = this.webResourceToolbar;
                if (toolbar != null) {
                    toolbar.setVisibility(8);
                }
                getWindow().addFlags(1024);
                return;
            }
            Toolbar toolbar2 = this.webResourceToolbar;
            if (toolbar2 != null) {
                toolbar2.setVisibility(0);
            }
            getWindow().clearFlags(1024);
        }
    }

    private void configureWebView(final WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setClickable(true);
        webView.setLongClickable(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        WebView.setWebContentsDebuggingEnabled(false);
        WSWebChromeClient wSWebChromeClient = new WSWebChromeClient();
        this.webChromeClient = wSWebChromeClient;
        webView.setWebChromeClient(wSWebChromeClient);
        webView.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.Webview.SearchRevisionVideosActivity.2
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String url, Bitmap favicon) {
                super.onPageStarted(webView2, url, favicon);
                SearchRevisionVideosActivity.this.webresourceloader.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                view.loadUrl("about:blank");
                SearchRevisionVideosActivity searchRevisionVideosActivity = SearchRevisionVideosActivity.this;
                Toast.makeText(searchRevisionVideosActivity, searchRevisionVideosActivity.getResources().getString(R.string.links_to_some_external_content_might_not_open_here), 0).show();
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        webView.getSettings().setDisplayZoomControls(false);
        webView.setDownloadListener(new DownloadListener() { // from class: com.appnew.android.Webview.SearchRevisionVideosActivity$$ExternalSyntheticLambda1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                this.f$0.lambda$configureWebView$0(str, str2, str3, str4, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureWebView$0(String str, String str2, String str3, String str4, long j) {
        if (str4.toLowerCase().contains("PDF".toLowerCase())) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.urlString)));
        } else {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        if (getSupportActionBar() == null) {
            return true;
        }
        onBackPressed();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isResourceList(String link) {
        String strGroup;
        String str = this.resourceContext;
        if (str != null && !str.isEmpty() && this.resourceContext.equalsIgnoreCase(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB)) {
            return link == null || link.contains("www.google.com/search?");
        }
        String str2 = this.resourceContext;
        if (str2 == null || str2.isEmpty() || !this.resourceContext.equalsIgnoreCase("video")) {
            return false;
        }
        Matcher matcher = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200c\u200b2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*").matcher(link);
        if (matcher.find()) {
            strGroup = matcher.group();
        } else {
            strGroup = "";
        }
        return strGroup == null || strGroup.isEmpty();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.video_link)) {
            return null;
        }
        if (this.resourceContext.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(this.course_id);
            encryptionData.setType("2");
            encryptionData.setFile_id(this.f_id);
            encryptionData.setTile_id(this.tile_id);
            encryptionData.setLink(this.videoUrl);
            return service.video_link(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setCourse_id(this.course_id);
        encryptionData2.setType("1");
        encryptionData2.setFile_id(this.f_id);
        encryptionData2.setTile_id(this.tile_id);
        encryptionData2.setLink(this.videoUrl);
        return service.video_link(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.video_link)) {
            try {
                if (jsonstring.optString("status").equals("true")) {
                    JSONObject jSONObject = jsonstring.getJSONObject("data");
                    if ((jSONObject.optString("file_type") != null && jSONObject.optString("file_type").equalsIgnoreCase("10")) || jSONObject.optString("file_type").equalsIgnoreCase("11")) {
                        if (this.seleced_tile_list.get(0).getFile_type() != null && this.seleced_tile_list.get(0).getFile_type().equalsIgnoreCase("3")) {
                            ArrayList<Video> arrayList = this.videoArrayList;
                            arrayList.add(arrayList.size(), (Video) new Gson().fromJson(jSONObject.toString(), Video.class));
                            ArrayList<Video> arrayList2 = this.seleced_tile_list;
                            arrayList2.add(arrayList2.size(), (Video) new Gson().fromJson(jSONObject.toString(), Video.class));
                        } else {
                            ArrayList<Video> arrayList3 = this.videoArrayList;
                            arrayList3.add(arrayList3.size(), (Video) new Gson().fromJson(jSONObject.toString(), Video.class));
                        }
                    }
                    com.appnew.android.home.Constants.revison_set = true;
                    MakeMyExam.videoArrayList = this.videoArrayList;
                    MakeMyExam.seleced_tile_list = this.seleced_tile_list;
                    this.fabProgressCircle.beginFinalAnimation();
                    Toast.makeText(this, "" + jsonstring.optString("message"), 0).show();
                    this.browserAddContent.setEnabled(false);
                    return;
                }
                this.browserAddContent.setEnabled(true);
                this.fabProgressCircle.hide();
                RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
            } catch (Exception e2) {
                this.browserAddContent.setEnabled(true);
                this.fabProgressCircle.hide();
                ErrorCallBack(e2.getMessage() + " : " + e2.getLocalizedMessage(), apitype, typeApi);
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        this.browserAddContent.setEnabled(true);
        this.fabProgressCircle.hide();
    }

    public class WSWebChromeClient extends WebChromeClient {
        FrameLayout.LayoutParams LayoutParameters = new FrameLayout.LayoutParams(-1, -1);

        public WSWebChromeClient() {
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
            if (newProgress == 100) {
                SearchRevisionVideosActivity.this.webresourceloader.setVisibility(8);
                if (SearchRevisionVideosActivity.this.showAddResourceBtn) {
                    if (SearchRevisionVideosActivity.this.isResourceList(view.getUrl())) {
                        SearchRevisionVideosActivity.this.fabProgressCircle.setVisibility(8);
                        return;
                    } else {
                        SearchRevisionVideosActivity.this.fabProgressCircle.setVisibility(0);
                        return;
                    }
                }
                SearchRevisionVideosActivity.this.fabProgressCircle.setVisibility(8);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            if (SearchRevisionVideosActivity.this.resourceIntent.equalsIgnoreCase("videos")) {
                if (SearchRevisionVideosActivity.this.mCustomView != null) {
                    callback.onCustomViewHidden();
                    return;
                }
                SearchRevisionVideosActivity searchRevisionVideosActivity = SearchRevisionVideosActivity.this;
                searchRevisionVideosActivity.mContentView = (RelativeLayout) searchRevisionVideosActivity.findViewById(R.id.webresourceviewlayout);
                SearchRevisionVideosActivity.this.mContentView.setVisibility(8);
                SearchRevisionVideosActivity.this.mCustomViewContainer = new FrameLayout(SearchRevisionVideosActivity.this);
                SearchRevisionVideosActivity.this.mCustomViewContainer.setLayoutParams(this.LayoutParameters);
                SearchRevisionVideosActivity.this.mCustomViewContainer.setBackgroundResource(android.R.color.black);
                view.setLayoutParams(this.LayoutParameters);
                SearchRevisionVideosActivity.this.mCustomViewContainer.addView(view);
                SearchRevisionVideosActivity.this.mCustomView = view;
                SearchRevisionVideosActivity.this.mCustomViewCallback = callback;
                SearchRevisionVideosActivity.this.mCustomViewContainer.setVisibility(0);
                SearchRevisionVideosActivity searchRevisionVideosActivity2 = SearchRevisionVideosActivity.this;
                searchRevisionVideosActivity2.setContentView(searchRevisionVideosActivity2.mCustomViewContainer);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (!SearchRevisionVideosActivity.this.resourceIntent.equalsIgnoreCase("videos") || SearchRevisionVideosActivity.this.mCustomView == null) {
                return;
            }
            SearchRevisionVideosActivity.this.mCustomView.setVisibility(8);
            SearchRevisionVideosActivity.this.mCustomViewContainer.removeView(SearchRevisionVideosActivity.this.mCustomView);
            SearchRevisionVideosActivity.this.mCustomView = null;
            SearchRevisionVideosActivity.this.mCustomViewContainer.setVisibility(8);
            SearchRevisionVideosActivity.this.mCustomViewCallback.onCustomViewHidden();
            SearchRevisionVideosActivity.this.mContentView.setVisibility(0);
            SearchRevisionVideosActivity searchRevisionVideosActivity = SearchRevisionVideosActivity.this;
            searchRevisionVideosActivity.setContentView(searchRevisionVideosActivity.mContentView);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView view, ValueCallback<Uri[]> filePath, WebChromeClient.FileChooserParams fileChooserParams) {
            File fileCreateImageFile;
            Intent[] intentArr;
            Intent intent = null;
            if (SearchRevisionVideosActivity.this.mUploadMessage != null) {
                SearchRevisionVideosActivity.this.mUploadMessage.onReceiveValue(null);
            }
            SearchRevisionVideosActivity.this.mUploadMessage = filePath;
            Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent2.resolveActivity(SearchRevisionVideosActivity.this.getPackageManager()) != null) {
                try {
                    fileCreateImageFile = SearchRevisionVideosActivity.this.createImageFile();
                    try {
                        intent2.putExtra("PhotoPath", SearchRevisionVideosActivity.this.mCameraPhotoPath);
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    fileCreateImageFile = null;
                }
                if (fileCreateImageFile != null) {
                    SearchRevisionVideosActivity.this.mCameraPhotoPath = "file:" + fileCreateImageFile.getAbsolutePath();
                    intent2.putExtra("output", Uri.fromFile(fileCreateImageFile));
                    intent = intent2;
                }
            } else {
                intent = intent2;
            }
            Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
            intent3.addCategory("android.intent.category.OPENABLE");
            intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            intent3.setType("*/*");
            if (intent != null) {
                intentArr = new Intent[]{intent};
            } else {
                intentArr = new Intent[2];
            }
            Intent intent4 = new Intent("android.intent.action.CHOOSER");
            intent4.putExtra("android.intent.extra.INTENT", intent3);
            intent4.putExtra("android.intent.extra.TITLE", "Image Chooser");
            intent4.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            SearchRevisionVideosActivity.this.someActivityResultLauncher.launch(Intent.createChooser(intent4, "Select images"));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(ActivityResult activityResult) {
        InputStream inputStreamOpenInputStream;
        if (activityResult.getResultCode() == -1) {
            try {
                inputStreamOpenInputStream = getContentResolver().openInputStream(((Intent) Objects.requireNonNull(activityResult.getData())).getData());
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                inputStreamOpenInputStream = null;
            }
            BitmapFactory.decodeStream(inputStreamOpenInputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File createImageFile() throws IOException {
        return File.createTempFile("JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_", ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.web_resource_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.add_weblink) {
            return;
        }
        this.browserAddContent.setEnabled(false);
        this.fabProgressCircle.show();
        if (this.searchString.contains(Const.YOUTUBE)) {
            this.browserAddContent.setEnabled(false);
            String str = this.resourceContext;
            if (str != null && str.equalsIgnoreCase("video")) {
                Matcher matcher = Pattern.compile("(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200c\u200b2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*").matcher(this.webResourceWebView.getUrl());
                if (matcher.find()) {
                    this.fabProgressCircle.beginFinalAnimation();
                    this.videoUrl = matcher.group();
                    new NetworkCall(this, this).NetworkAPICall(API.video_link, "", false, false);
                    return;
                } else {
                    this.browserAddContent.setEnabled(true);
                    this.fabProgressCircle.hide();
                    Toast.makeText(this, getResources().getString(R.string.this_video_will_not_attach), 0).show();
                    return;
                }
            }
            this.browserAddContent.setEnabled(true);
            return;
        }
        if (this.searchString.contains("google")) {
            this.browserAddContent.setEnabled(false);
            String str2 = this.resourceContext;
            if (str2 != null && str2.equalsIgnoreCase(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB)) {
                String url = this.webResourceWebView.getUrl();
                if (url != null && !url.contains("www.google.com/search?")) {
                    this.fabProgressCircle.beginFinalAnimation();
                    this.videoUrl = url;
                    new NetworkCall(this, this).NetworkAPICall(API.video_link, "", false, false);
                    return;
                } else {
                    this.browserAddContent.setEnabled(true);
                    this.fabProgressCircle.hide();
                    Toast.makeText(this, getResources().getString(R.string.this_link_will_not_attach), 0).show();
                    return;
                }
            }
            Toast.makeText(this, getResources().getString(R.string.this_link_will_not_attach), 0).show();
            this.fabProgressCircle.hide();
            this.browserAddContent.setEnabled(true);
        }
    }

    @Override // com.github.jorgecastilloprz.listeners.FABProgressListener
    public void onFABProgressAnimationEnd() {
        if (this.solutionAdded) {
            Toast.makeText(this, getResources().getString(R.string.your_selected_weblink_successfully_added_to_the_chapter), 0).show();
        }
        if (this.videoAdded) {
            Toast.makeText(this, getResources().getString(R.string.your_selected_video_has_been_successfully_added_to_the_chapter), 0).show();
        }
    }
}
