package com.appnew.android.Courses.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Interfaces.AsyncTaskCompleteListener;
import com.appnew.android.Courses.PdfUtils.PdfUtils;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Datum;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.PreferencesUtil;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.home.Constants;
import com.appnew.android.table.PDFDataTable;
import com.appnew.android.table.UserHistroyTable;
import com.clevertap.android.sdk.PushPermissionHandler;
import com.eduteria.app.app.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class PdfDetailScreen extends AppCompatActivity implements AsyncTaskCompleteListener, OnLoadCompleteListener, OnErrorListener, AmazonCallBack, NetworkCall.MyNetworkCallBack {
    private static final int STORAGE_PERMISSION_CODE = 101;
    private String Downloaded_Url;
    TextView Save_pdf;
    private Activity activity;
    private ImageView back;
    private TextView blink;
    private ImageView downarrowFB;
    Button download_btn;
    SharedPreferences.Editor editor;
    private String file_type;
    private String from;
    ArrayList<MediaFile> images;
    private boolean isDownload;
    private boolean isDownloadComplete;
    private ProgressDialog mProgressDialog;
    NetworkCall networkCall;
    public PDFView pdfViewPager;
    private ImageView pdf_Rotate;
    ImageView pdf_bookmark;
    private TextView pdf_name;
    public ProgressDialog progressBar;
    private ProgressBar progressbar_pdf;
    SwipeRefreshLayout pull_refresh_pdf;
    s3ImageUploading s3ImageUploading;
    ImageView searchPDF;
    CardView shareFloatingActionButton;
    SharedPreferences sharedPreferences;
    private String subjective_paper;
    private String thumbnail;
    RelativeLayout toolbar_layout;
    private String unzipLocation;
    private boolean uploadPdf;
    private String url;
    private String zipFile;
    private String name = "";
    private String PDF_NAME = "";
    private String pdf_id = "";
    private String type = "";
    private String course_id = "";
    private String valid_to = "";
    private String bookMark = "";
    private String rank = "";
    InputStream input = null;
    boolean saved = false;
    boolean download_file = false;
    OutputStream output = null;
    int totalPage = 0;
    private String isShare = "0";
    HttpURLConnection urlConnection = null;
    String bookmarkState = "";
    String videoId_value = "";
    int i = 0;
    String exactcourseid = "";
    String forwhat = "";
    ArrayList<MediaFile> imageArrayList = new ArrayList<>();
    int status = 0;
    Handler handler = new Handler();
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen$$ExternalSyntheticLambda5
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$5((Boolean) obj);
        }
    });

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String str;
        String string;
        String str2;
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        this.networkCall = new NetworkCall(this, this);
        this.activity = this;
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                PdfDetailScreen.this.handleBackPressed();
            }
        });
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        setContentView(R.layout.pdf_viewer);
        this.searchPDF = (ImageView) findViewById(R.id.searchPDF);
        this.pdf_Rotate = (ImageView) findViewById(R.id.pdf_Rotate);
        this.download_btn = (Button) findViewById(R.id.procceed_btn);
        this.shareFloatingActionButton = (CardView) findViewById(R.id.shareFloatingActionButton);
        this.pdf_name = (TextView) findViewById(R.id.pdf_name);
        this.progressbar_pdf = (ProgressBar) findViewById(R.id.progressbar_pdf);
        this.toolbar_layout = (RelativeLayout) findViewById(R.id.toolbar_layout);
        this.downarrowFB = (ImageView) findViewById(R.id.download_pdf);
        this.back = (ImageView) findViewById(R.id.back);
        this.pdfViewPager = (PDFView) findViewById(R.id.pdfView);
        this.Save_pdf = (TextView) findViewById(R.id.Save_pdf);
        this.pdf_bookmark = (ImageView) findViewById(R.id.pdf_bookmark);
        this.blink = (TextView) findViewById(R.id.blink);
        View viewFindViewById = findViewById(R.id.root);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyInsets(this, getWindow(), viewFindViewById, false, null);
        }
        this.blink.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        this.blink.measure(0, 0);
        this.url = getIntent().getStringExtra("url");
        this.thumbnail = getIntent().getStringExtra(Const.THUMBNAIL);
        this.course_id = getIntent().getStringExtra("course_id");
        this.type = getIntent().getStringExtra("type");
        this.rank = getIntent().getStringExtra("rank");
        this.pdf_id = getIntent().getStringExtra("title");
        this.name = getIntent().getStringExtra("pdf_name");
        this.saved = getIntent().getBooleanExtra("save", false);
        this.download_file = getIntent().getBooleanExtra("download_file", false);
        this.valid_to = getIntent().getStringExtra("valid_to");
        this.bookMark = getIntent().getStringExtra("bookmark");
        this.file_type = getIntent().getStringExtra("file_type");
        this.subjective_paper = getIntent().getStringExtra("subjective_paper");
        this.from = getIntent().hasExtra("from") ? getIntent().getStringExtra("from") : "";
        this.forwhat = getIntent().getStringExtra(Const.FORWHAT);
        try {
            this.uploadPdf = getIntent().getBooleanExtra("uploadPdf", false);
        } catch (Exception unused) {
        }
        String strSanitizeFilenameForS3 = Helper.sanitizeFilenameForS3(this.name);
        try {
            Helper.logPrinter(getLocalClassName(), "e", strSanitizeFilenameForS3, "Message");
            Log.d("filename", "onCreate: ", new Exception(strSanitizeFilenameForS3));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.isDownload = getIntent().getBooleanExtra(Const.IS_DOWNLOAD, false);
        if (getIntent().getStringExtra("is_share") != null) {
            this.isShare = getIntent().getStringExtra("is_share");
        }
        try {
            if (this.subjective_paper != null) {
                StringBuilder sbAppend = new StringBuilder().append(this.pdf_id);
                if (this.subjective_paper.equalsIgnoreCase(Const.ANSWER)) {
                    str2 = "ans";
                } else {
                    str2 = this.subjective_paper.equalsIgnoreCase(Const.QUESTION) ? "qus" : "";
                }
                string = sbAppend.append(str2).append(".pdf").toString();
            } else {
                string = this.pdf_id + ".pdf";
            }
            for (PDFDataTable pDFDataTable : UtkashRoom.getAppDatabase(this).getPDFDataDao().getListOfData()) {
                if (this.download_file) {
                    if (pDFDataTable.getPdfId().equalsIgnoreCase(this.course_id)) {
                        this.Downloaded_Url = pDFDataTable.getPdfUrl();
                        this.download_file = true;
                    }
                } else if (pDFDataTable.getPdfId().equalsIgnoreCase(string)) {
                    this.Downloaded_Url = pDFDataTable.getPdfUrl();
                    this.download_file = true;
                }
            }
        } catch (Exception unused2) {
        }
        if (this.isShare.equalsIgnoreCase("1")) {
            if (this.saved) {
                this.shareFloatingActionButton.setVisibility(0);
            }
        } else {
            this.shareFloatingActionButton.setVisibility(8);
        }
        String str3 = this.file_type;
        if (str3 != null && str3.equalsIgnoreCase("st")) {
            this.download_btn.setVisibility(8);
            this.pdf_bookmark.setVisibility(8);
        } else {
            String str4 = this.type;
            if ((str4 == null || !str4.equalsIgnoreCase("notice_board")) && SharedPreference.getInstance().getString(Const.BOOK_MARK) != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.BOOK_MARK)) && SharedPreference.getInstance().getString(Const.BOOK_MARK).equalsIgnoreCase("1")) {
                String str5 = this.from;
                if (str5 != null && str5.equalsIgnoreCase("ChatAdapter")) {
                    this.pdf_bookmark.setVisibility(8);
                } else {
                    this.pdf_bookmark.setVisibility(0);
                }
                String str6 = this.from;
                if (str6 != null && str6.equalsIgnoreCase("CourseActivity")) {
                    this.pdf_bookmark.setVisibility(8);
                } else {
                    this.pdf_bookmark.setVisibility(0);
                }
            } else {
                this.pdf_bookmark.setVisibility(8);
            }
        }
        SharedPreferences sharedPreferences = getSharedPreferences("PDF_BOOKMARK", 0);
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
        String string2 = this.sharedPreferences.getString(this.pdf_id, "");
        this.videoId_value = string2;
        if (!string2.isEmpty() || !this.videoId_value.equals("")) {
            if (this.videoId_value.equals("0")) {
                this.pdf_bookmark.setImageResource(R.mipmap.bookmark_selected);
                this.bookmarkState = "0";
            } else {
                this.pdf_bookmark.setImageResource(R.mipmap.bookmark_unselected);
                this.bookmarkState = "1";
            }
        } else {
            String str7 = this.bookMark;
            if (str7 != null && str7.equals("1")) {
                this.pdf_bookmark.setImageResource(R.mipmap.bookmark_selected);
                this.bookmarkState = "0";
            }
        }
        this.pdf_bookmark.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PdfDetailScreen.this.i < 3) {
                    PdfDetailScreen.this.i++;
                    if (PdfDetailScreen.this.bookmarkState.equals("0")) {
                        PdfDetailScreen.this.bookmarkState = "1";
                        PdfDetailScreen.this.editor.remove(PdfDetailScreen.this.pdf_id);
                        PdfDetailScreen.this.editor.apply();
                        PdfDetailScreen.this.pdf_bookmark.setImageResource(R.mipmap.bookmark_unselected);
                        PdfDetailScreen.this.networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
                        return;
                    }
                    PdfDetailScreen.this.bookmarkState = "0";
                    PdfDetailScreen.this.editor.putString(PdfDetailScreen.this.pdf_id, PdfDetailScreen.this.bookmarkState);
                    PdfDetailScreen.this.editor.apply();
                    PdfDetailScreen.this.pdf_bookmark.setImageResource(R.mipmap.bookmark_selected);
                    PdfDetailScreen.this.networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
                }
            }
        });
        if (this.url.contains("\\/")) {
            this.url = this.url.replace("\\/", MqttTopic.TOPIC_LEVEL_SEPARATOR);
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana") && (this.name.equalsIgnoreCase("OMR") || this.name.equalsIgnoreCase(Const.SOLUTION))) {
            this.pdf_bookmark.setVisibility(8);
        }
        if (Helper.isNetworkConnected(this)) {
            String str8 = this.url;
            if (str8 != null && !str8.isEmpty()) {
                this.pdf_name.setSelected(true);
                TextView textView = this.pdf_name;
                if (TextUtils.isEmpty(strSanitizeFilenameForS3)) {
                    strSanitizeFilenameForS3 = getResources().getString(R.string.app_name);
                }
                textView.setText(strSanitizeFilenameForS3);
                if (this.isDownload) {
                    if (getIntent().hasExtra("cat_type") && getIntent().getStringExtra("cat_type").equalsIgnoreCase("3")) {
                        this.download_btn.setVisibility(0);
                    } else {
                        this.downarrowFB.setVisibility(0);
                    }
                    if (SharedPreference.getInstance().getString(Const.WEBVIEW_PDF).equalsIgnoreCase("1")) {
                        if (this.download_file) {
                            this.pdfViewPager.setVisibility(0);
                            this.searchPDF.setVisibility(0);
                            this.downarrowFB.setEnabled(false);
                            this.downarrowFB.setImageResource(R.drawable.ic_downloaded_chapter);
                            this.download_btn.setText("View PDF");
                            if (!this.saved) {
                                this.download_btn.setVisibility(0);
                            }
                            String str9 = this.Downloaded_Url;
                            this.url = str9;
                            PdfOpenInWebView(str9);
                        } else if (this.uploadPdf) {
                            this.Save_pdf.setVisibility(0);
                            this.isDownloadComplete = false;
                            this.searchPDF.setVisibility(8);
                            this.downarrowFB.setVisibility(8);
                            if (!SharedPreference.getInstance().getString(Const.WEBVIEW_PDF).equalsIgnoreCase("1")) {
                                Helper.showProgressDialog(this);
                            }
                            showPDF(this.url);
                            this.download_btn.setVisibility(8);
                        } else {
                            this.pdfViewPager.setVisibility(0);
                            this.searchPDF.setVisibility(0);
                            PdfOpenInWebView(this.url);
                        }
                    } else if (this.uploadPdf) {
                        this.Save_pdf.setVisibility(0);
                        this.isDownloadComplete = false;
                        this.searchPDF.setVisibility(8);
                        this.downarrowFB.setVisibility(8);
                        if (!SharedPreference.getInstance().getString(Const.WEBVIEW_PDF).equalsIgnoreCase("1")) {
                            Helper.showProgressDialog(this);
                        }
                        showPDF(this.url);
                        this.download_btn.setVisibility(8);
                    } else if (checkPdfSave()) {
                        this.isDownloadComplete = true;
                        this.downarrowFB.setEnabled(false);
                        this.downarrowFB.setImageResource(R.drawable.ic_downloaded_chapter);
                        if (!SharedPreference.getInstance().getString(Const.WEBVIEW_PDF).equalsIgnoreCase("1")) {
                            Helper.showProgressDialog(this);
                        }
                        this.download_btn.setText("View PDF");
                        this.download_btn.setVisibility(0);
                        new LOADURL_new(this).execute(this.url);
                    } else if (this.download_file) {
                        if (!SharedPreference.getInstance().getString(Const.WEBVIEW_PDF).equalsIgnoreCase("1")) {
                            Helper.showProgressDialog(this);
                        }
                        showPDF(this.url);
                        this.isDownloadComplete = true;
                        this.downarrowFB.setEnabled(false);
                        this.downarrowFB.setImageResource(R.drawable.ic_downloaded_chapter);
                        this.download_btn.setText("View PDF");
                        this.download_btn.setVisibility(8);
                    } else {
                        checkForDownloadRefresh(Boolean.valueOf(this.saved));
                    }
                } else if (this.uploadPdf) {
                    this.Save_pdf.setVisibility(0);
                    this.isDownloadComplete = false;
                    this.searchPDF.setVisibility(8);
                    this.downarrowFB.setVisibility(8);
                    if (!SharedPreference.getInstance().getString(Const.WEBVIEW_PDF).equalsIgnoreCase("1")) {
                        Helper.showProgressDialog(this);
                    }
                    showPDF(this.url);
                    this.download_btn.setVisibility(8);
                } else {
                    this.isDownloadComplete = false;
                    this.downarrowFB.setVisibility(8);
                    PdfUtils.INSTANCE.checkPermissionsAndDownload(this, this.url, this.pdfViewPager, this.progressbar_pdf, this.requestPermissionLauncher);
                }
            }
        } else {
            this.downarrowFB.setVisibility(8);
            this.Save_pdf.setVisibility(8);
            TextView textView2 = this.pdf_name;
            if (TextUtils.isEmpty(strSanitizeFilenameForS3)) {
                strSanitizeFilenameForS3 = getResources().getString(R.string.app_name);
            }
            textView2.setText(strSanitizeFilenameForS3);
            if (this.isDownload && (str = this.url) != null && !str.isEmpty()) {
                showPDF(this.url);
            }
        }
        this.downarrowFB.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Helper.isNetworkConnected(PdfDetailScreen.this)) {
                    if (PdfDetailScreen.this.getFileExist().exists()) {
                        String str10 = PdfDetailScreen.this.pdf_id + ".pdf";
                        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
                            new File(PdfDetailScreen.this.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str10).delete();
                        } else {
                            new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/EDUTERIA_doc_folder/" + str10).delete();
                        }
                    }
                    PdfDetailScreen.this.mProgressDialog = new ProgressDialog(PdfDetailScreen.this);
                    PdfDetailScreen.this.mProgressDialog.setMessage("Download Pdf");
                    PdfDetailScreen.this.mProgressDialog.setIndeterminate(true);
                    PdfDetailScreen.this.mProgressDialog.setProgressStyle(1);
                    PdfDetailScreen.this.mProgressDialog.setCancelable(false);
                    PdfDetailScreen.this.showDownloadNotification();
                    Log.e("SATYA_TEST_VERSION_CODE", "onClick: 53");
                    PdfDetailScreen pdfDetailScreen = PdfDetailScreen.this;
                    final DownloadTask downloadTask = pdfDetailScreen.new DownloadTask(pdfDetailScreen);
                    downloadTask.execute(PdfDetailScreen.this.url);
                    PdfDetailScreen.this.mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.3.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialog) {
                            downloadTask.cancel(true);
                        }
                    });
                    PdfDetailScreen.this.pushEventForDownload();
                    return;
                }
                PdfDetailScreen pdfDetailScreen2 = PdfDetailScreen.this;
                Toast.makeText(pdfDetailScreen2, pdfDetailScreen2.getResources().getString(R.string.no_internet_connection), 0).show();
            }
        });
        this.download_btn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Helper.isNetworkConnected(PdfDetailScreen.this)) {
                    if (PdfDetailScreen.this.download_btn.getText().equals("View PDF")) {
                        String[] strArrSplit = SharedPreference.getInstance().getString(Const.MY_DOWNLOAD_TABS).split(MqttTopic.MULTI_LEVEL_WILDCARD);
                        if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[1].equalsIgnoreCase("1")) {
                            Intent intent = new Intent(PdfDetailScreen.this, (Class<?>) DownloadActivity.class);
                            intent.putExtra("mode", OfflineMessageRequest.ELEMENT);
                            intent.putExtra("is_share", PdfDetailScreen.this.isShare);
                            PdfDetailScreen.this.startActivity(intent);
                            return;
                        }
                        PdfDetailScreen pdfDetailScreen = PdfDetailScreen.this;
                        Toast.makeText(pdfDetailScreen, pdfDetailScreen.getResources().getString(R.string.Pdf_view_detail), 0).show();
                        return;
                    }
                    if (PdfDetailScreen.this.getFileExist().exists()) {
                        String str10 = PdfDetailScreen.this.pdf_id + ".pdf";
                        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
                            new File(PdfDetailScreen.this.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str10).delete();
                        } else {
                            new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/EDUTERIA_doc_folder/" + str10).delete();
                        }
                    }
                    PdfDetailScreen.this.mProgressDialog = new ProgressDialog(PdfDetailScreen.this);
                    PdfDetailScreen.this.mProgressDialog.setMessage("Download Pdf");
                    PdfDetailScreen.this.mProgressDialog.setIndeterminate(true);
                    PdfDetailScreen.this.mProgressDialog.setProgressStyle(1);
                    PdfDetailScreen.this.mProgressDialog.setCancelable(false);
                    PdfDetailScreen pdfDetailScreen2 = PdfDetailScreen.this;
                    final DownloadTask downloadTask = pdfDetailScreen2.new DownloadTask(pdfDetailScreen2);
                    downloadTask.execute(PdfDetailScreen.this.url);
                    PdfDetailScreen.this.download_btn.setClickable(false);
                    PdfDetailScreen.this.mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.4.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialog) {
                            PdfDetailScreen.this.download_btn.setClickable(true);
                            downloadTask.cancel(true);
                        }
                    });
                    PdfDetailScreen.this.pushEventForDownload();
                    return;
                }
                PdfDetailScreen pdfDetailScreen3 = PdfDetailScreen.this;
                Toast.makeText(pdfDetailScreen3, pdfDetailScreen3.getResources().getString(R.string.no_internet_connection), 0).show();
            }
        });
        this.shareFloatingActionButton.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.Save_pdf.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
        this.pdf_Rotate.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PdfDetailScreen.this.getResources().getConfiguration().orientation == 2) {
                    PdfDetailScreen.this.setRequestedOrientation(1);
                    PdfDetailScreen.this.getWindow().clearFlags(1024);
                } else {
                    PdfDetailScreen.this.setRequestedOrientation(0);
                    PdfDetailScreen.this.getWindow().setFlags(1024, 1024);
                }
            }
        });
        if (SharedPreference.getInstance().getString(Const.WATERMARK_ON_PDF).equalsIgnoreCase("1")) {
            this.blink.setVisibility(0);
            blink();
        } else {
            this.blink.setVisibility(8);
        }
        searchPDF();
        if (TextUtils.isEmpty(this.from)) {
            return;
        }
        if (this.from.equalsIgnoreCase("GroupChatAdapter2") || this.from.equalsIgnoreCase("ChatAdapter")) {
            PdfUtils.INSTANCE.checkPermissionsAndDownload(this, this.url, this.pdfViewPager, this.progressbar_pdf, this.requestPermissionLauncher);
            if (this.downarrowFB.getVisibility() == 0) {
                this.downarrowFB.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        sharePdf();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        setupDoc(this.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBackPressed() {
        Helper.dismissProgressDialog();
        if (getIntent().hasExtra("backPressed") && "1".equalsIgnoreCase(getIntent().getStringExtra("backPressed"))) {
            Intent intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
            intent.setFlags(67141632);
            Helper.gotoActivity_finish(intent, this);
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    private void PdfOpenInWebView(String pdfUrl) {
        if (pdfUrl != null) {
            PdfUtils.INSTANCE.checkPermissionsAndDownload(this, pdfUrl, this.pdfViewPager, this.progressbar_pdf, this.requestPermissionLauncher);
            this.searchPDF.setVisibility(0);
        } else {
            Toast.makeText(this, "Invalid PDF URL!", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushEventForDownload() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put("content_id", this.pdf_id);
        map.put(AnalyticsConstants.content_name, this.name);
        map.put("content_type", "PDF");
        map.put("course_id", this.course_id);
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.CONTENT_DOWNLOAD, map);
    }

    private void sharePdf() {
        File file;
        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
            file = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.pdf_id);
        } else {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/EDUTERIA_doc_folder/" + this.pdf_id);
        }
        if (file.exists()) {
            Uri uriForFile = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("application/pdf");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            intent.addFlags(1);
            try {
                startActivity(Intent.createChooser(intent, "Share PDF using"));
            } catch (ActivityNotFoundException unused) {
            }
        }
    }

    private boolean checkPdfSave() {
        String string;
        String str;
        if (this.subjective_paper != null) {
            StringBuilder sbAppend = new StringBuilder().append(this.pdf_id);
            if (this.subjective_paper.equalsIgnoreCase(Const.ANSWER)) {
                str = "ans";
            } else {
                str = this.subjective_paper.equalsIgnoreCase(Const.QUESTION) ? "qus" : "";
            }
            string = sbAppend.append(str).append(".pdf").toString();
        } else {
            string = this.pdf_id + ".pdf";
        }
        return UtkashRoom.getAppDatabase(this).getPDFDataDao().pdfData(string);
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
    public void loadComplete(int nbPages) {
        try {
            this.totalPage = nbPages;
            Activity activity = this.activity;
            if (activity != null && !activity.isFinishing() && !this.activity.isDestroyed()) {
                new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Helper.dismissProgressDialog();
                    }
                }, 750L);
            }
            InputStream inputStream = this.input;
            if (inputStream != null) {
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.urlConnection;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void searchPDF() {
        this.searchPDF.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (SharedPreference.getInstance().getString(Const.WEBVIEW_PDF).equalsIgnoreCase("1")) {
                    PdfDetailScreen.this.totalPage = PdfUtils.INSTANCE.getGetPdfPageCount();
                }
                final Dialog dialog = new Dialog(PdfDetailScreen.this);
                dialog.setContentView(R.layout.popupjump);
                dialog.getWindow().setLayout(-1, -2);
                dialog.setCancelable(false);
                TextView textView = (TextView) dialog.findViewById(R.id.okay_text);
                TextView textView2 = (TextView) dialog.findViewById(R.id.cancel_text);
                final EditText editText = (EditText) dialog.findViewById(R.id.enterPdfET);
                final TextView textView3 = (TextView) dialog.findViewById(R.id.redAlert);
                ((TextView) dialog.findViewById(R.id.totalPageTV)).setText(String.valueOf(PdfDetailScreen.this.totalPage));
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v2) {
                        String string = editText.getText().toString();
                        if (!string.isEmpty()) {
                            try {
                                int i = Integer.parseInt(string);
                                if (i > 0 && i <= PdfDetailScreen.this.pdfViewPager.getPageCount()) {
                                    PdfDetailScreen.this.pdfViewPager.jumpTo(i - 1);
                                    dialog.dismiss();
                                    return;
                                } else {
                                    textView3.setText("Invalid page number");
                                    textView3.setVisibility(0);
                                    return;
                                }
                            } catch (NumberFormatException unused) {
                                textView3.setText("Please enter a valid number");
                                textView3.setVisibility(0);
                                return;
                            }
                        }
                        textView3.setText("Please enter a valid page number.");
                        textView3.setVisibility(0);
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.7.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v2) {
                        dialog.dismiss();
                        Toast.makeText(PdfDetailScreen.this, "Cancel clicked", 0).show();
                    }
                });
                dialog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blink() {
        try {
            this.blink.setVisibility(4);
            PDFView pDFView = this.pdfViewPager;
            if (pDFView != null) {
                pDFView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass8());
            }
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Courses.Activity.PdfDetailScreen$8, reason: invalid class name */
    class AnonymousClass8 implements ViewTreeObserver.OnPreDrawListener {
        AnonymousClass8() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            PdfDetailScreen.this.pdfViewPager.getViewTreeObserver().removeOnPreDrawListener(this);
            try {
                int measuredHeight = PdfDetailScreen.this.pdfViewPager.getMeasuredHeight();
                int measuredWidth = PdfDetailScreen.this.pdfViewPager.getMeasuredWidth();
                int iNextInt = 5;
                int iNextInt2 = (PdfDetailScreen.this.blink.getWidth() <= 0 || measuredWidth - PdfDetailScreen.this.blink.getWidth() <= 0) ? 5 : ThreadLocalRandom.current().nextInt(PdfDetailScreen.this.blink.getWidth(), measuredWidth - PdfDetailScreen.this.blink.getWidth());
                if (PdfDetailScreen.this.blink.getHeight() > 0 && measuredHeight - PdfDetailScreen.this.blink.getHeight() > 0) {
                    iNextInt = ThreadLocalRandom.current().nextInt(PdfDetailScreen.this.blink.getHeight(), measuredHeight - PdfDetailScreen.this.blink.getHeight());
                }
                if (PdfDetailScreen.this.blink.getWidth() + iNextInt2 > measuredWidth) {
                    PdfDetailScreen.this.blink.setX(iNextInt2 - PdfDetailScreen.this.blink.getWidth());
                } else {
                    PdfDetailScreen.this.blink.setX(iNextInt2);
                }
                if (PdfDetailScreen.this.blink.getHeight() + iNextInt > measuredHeight) {
                    PdfDetailScreen.this.blink.setY(iNextInt - PdfDetailScreen.this.blink.getHeight());
                } else {
                    PdfDetailScreen.this.blink.setY(iNextInt);
                }
            } catch (IllegalArgumentException unused) {
            }
            new Thread(new AnonymousClass1(new Handler())).start();
            return true;
        }

        /* JADX INFO: renamed from: com.appnew.android.Courses.Activity.PdfDetailScreen$8$1, reason: invalid class name */
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
                this.val$handler.post(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.8.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PdfDetailScreen.this.blink.setVisibility(0);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.8.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PdfDetailScreen.this.blink();
                            }
                        }, 3000L);
                    }
                });
            }
        }
    }

    public void setupDoc(String docpath) {
        if (TextUtils.isEmpty(docpath) && !docpath.toLowerCase().endsWith(".pdf") && !docpath.toLowerCase().endsWith(".doc") && !docpath.toLowerCase().endsWith(".docx") && !docpath.toLowerCase().endsWith(".xls") && !docpath.toLowerCase().endsWith(".xlsx")) {
            Toast.makeText(this, getResources().getString(R.string.file_format_error), 0).show();
            return;
        }
        File file = new File(docpath);
        if (!file.exists() || file.length() == 0) {
            Toast.makeText(this, "File not found or is empty", 0).show();
            return;
        }
        String strSanitizeFilenameForS3 = Helper.sanitizeFilenameForS3(docpath.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r8.length - 1]);
        MediaFile mediaFile = new MediaFile();
        if (strSanitizeFilenameForS3.toLowerCase().endsWith(".pdf")) {
            mediaFile.setImage(BitmapFactory.decodeResource(getResources(), R.mipmap.pdf));
            mediaFile.setFile_type(Const.PDF);
        }
        mediaFile.setFile_name(strSanitizeFilenameForS3);
        mediaFile.setFile(file.getAbsolutePath());
        mediaFile.setId(Constants.SUB_TEST_ID);
        this.imageArrayList.clear();
        this.imageArrayList.add(mediaFile);
        upload();
    }

    public static boolean permissions() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.API_ADD_TO_BOOKMARK)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setContent_id(this.pdf_id);
            encryptionData.setContent_type("1");
            encryptionData.setIs_unbookmarked(this.bookmarkState);
            return service.addPdfBookMark(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.API_SUBJECTIVE_SUBMIT)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.images.size(); i++) {
            Datum datum = new Datum();
            datum.setTitle(this.imageArrayList.get(i).getFile_name());
            datum.setUrl(this.images.get(i).getFile());
            arrayList.add(datum);
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setTest_id(Constants.SUB_TEST_ID);
        encryptionData2.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        encryptionData2.setAnswers(this.images.get(0).getFile());
        encryptionData2.setCourse_id(this.exactcourseid);
        return service.API_SUBJECTIVE_SUBMIT(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonResponse, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.API_ADD_TO_BOOKMARK)) {
            if (jsonResponse.optString("status").equals("true")) {
                Toast.makeText(this, jsonResponse.optString("message"), 0).show();
                return;
            } else {
                Toast.makeText(this, jsonResponse.optString("message"), 0).show();
                return;
            }
        }
        if (apitype.equals(API.API_SUBJECTIVE_SUBMIT)) {
            if (jsonResponse.optString("status").equals("true")) {
                this.imageArrayList.clear();
                Toast.makeText(this, jsonResponse.optString("message"), 0).show();
                CourseActivity.wantToRefresh = true;
                String str = this.forwhat;
                if (str == null || !str.equalsIgnoreCase("forNotification")) {
                    Constants.REFRESHPAGE = "true";
                }
                new Intent().putExtra(Const.FromPdfScreen, "SubjectiveTest");
                PreferencesUtil.INSTANCE.setStringPreference(this, Const.SUBJECTIVE_TEST_UPLOADED, "1");
                finish();
                return;
            }
            CourseActivity.wantToRefresh = false;
            Toast.makeText(this, jsonResponse.optString("message"), 0).show();
        }
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        this.images = images;
        this.exactcourseid = this.course_id.split(MqttTopic.MULTI_LEVEL_WILDCARD)[0];
        this.networkCall.NetworkAPICall(API.API_SUBJECTIVE_SUBMIT, "", true, false);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void upload() {
        s3ImageUploading s3imageuploading = new s3ImageUploading("vc-10000386-38616500102/EDUTERIA_doc_folder", this, this, null);
        this.s3ImageUploading = s3imageuploading;
        s3imageuploading.execute(this.imageArrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class DownloadTask extends AsyncTask<String, Integer, String> {
        private String capturedPdfName;
        private Context context;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.capturedPdfName = PdfDetailScreen.this.pdf_name.getText().toString();
            super.onPreExecute();
            PdfDetailScreen.this.mProgressDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate((Object[]) progress);
            try {
                PdfDetailScreen.this.mProgressDialog.setIndeterminate(false);
                PdfDetailScreen.this.mProgressDialog.setMax(100);
                PdfDetailScreen.this.mProgressDialog.setProgress(progress[0].intValue());
            } catch (IllegalArgumentException e2) {
                Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e2.getMessage());
            } catch (Exception e3) {
                Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e3.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            PdfDetailScreen.this.download_btn.setClickable(true);
            try {
                if (PdfDetailScreen.this.activity != null && !PdfDetailScreen.this.activity.isFinishing() && !PdfDetailScreen.this.activity.isDestroyed()) {
                    PdfDetailScreen.this.activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen$DownloadTask$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onPostExecute$0();
                        }
                    });
                }
            } catch (IllegalArgumentException e2) {
                Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e2.getMessage());
            } catch (Exception e3) {
                Log.d("TAGPDFDETAIL", "onProgressUpdate: " + e3.getMessage());
            }
            if (result != null) {
                Toast.makeText(this.context, PdfDetailScreen.this.getResources().getString(R.string.download_error) + result, 1).show();
                return;
            }
            PdfDetailScreen.this.downarrowFB.setEnabled(false);
            PdfDetailScreen.this.downarrowFB.setImageResource(R.drawable.ic_downloaded_chapter);
            if (PdfDetailScreen.this.getIntent().hasExtra("cat_type") && PdfDetailScreen.this.getIntent().getStringExtra("cat_type").equalsIgnoreCase("3")) {
                Toast.makeText(this.context, "Your admit card has been downloaded successfully.", 0).show();
            } else {
                Toast.makeText(this.context, PdfDetailScreen.this.getResources().getString(R.string.file_downloaded), 0).show();
            }
            PdfDetailScreen.this.download_btn.setText("View PDF");
            PdfDetailScreen.this.download_btn.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$0() {
            if (PdfDetailScreen.this.mProgressDialog == null || !PdfDetailScreen.this.mProgressDialog.isShowing()) {
                return;
            }
            try {
                PdfDetailScreen.this.mProgressDialog.dismiss();
            } catch (IllegalArgumentException e2) {
                Log.d("TAG", "Dismiss error: " + e2.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x01fb, code lost:
        
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x01fe, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0201, code lost:
        
            if (r9 == null) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0203, code lost:
        
            r9.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0206, code lost:
        
            r22.this$0.download_btn.setClickable(r4);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:100:0x029a  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0288 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:131:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x028d A[Catch: IOException -> 0x0298, TryCatch #1 {IOException -> 0x0298, blocks: (B:95:0x0288, B:97:0x028d, B:98:0x0290), top: B:107:0x0288 }] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v13, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r5v8 */
        /* JADX WARN: Type inference failed for: r5v9 */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r23) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 670
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Courses.Activity.PdfDetailScreen.DownloadTask.doInBackground(java.lang.String[]):java.lang.String");
        }
    }

    private void showPDF(final String url) {
        try {
            if (isDestroyed()) {
                return;
            }
            this.pdfViewPager.post(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showPDF$3(url);
                }
            });
        } catch (Exception e2) {
            Log.d("TAGPDFDETAIL", "showPDF: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPDF$3(String str) {
        this.pdfViewPager.fromFile(new File(str)).enableAnnotationRendering(true).onLoad(this).onError(this).load();
    }

    public File getFileExist() {
        String str = this.pdf_id + ".pdf";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
            return new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str);
        }
        return new File(file + "/EDUTERIA_doc_folder/" + str);
    }

    private void clearPDFView() {
        PdfUtils.INSTANCE.getCurrentDownloadCall().cancel();
        this.pdfViewPager.recycle();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        if (!checkPdfSave() && this.isDownload) {
            checkForDownloadRefresh(Boolean.valueOf(this.saved));
        }
        super.onResume();
    }

    @Override // com.appnew.android.Courses.Interfaces.AsyncTaskCompleteListener
    public void onTaskComplete(String inputStream, final File file) {
        try {
            if (inputStream.equalsIgnoreCase("success")) {
                try {
                    UserHistroyTable userHistroyTable = new UserHistroyTable();
                    userHistroyTable.setVideo_id(this.pdf_id);
                    userHistroyTable.setPdf_name(this.name);
                    userHistroyTable.setType("PDF");
                    userHistroyTable.setPdf_url(this.url);
                    userHistroyTable.setUser_id(MakeMyExam.userId);
                    userHistroyTable.setCourse_id(this.course_id);
                    userHistroyTable.setValid_to(this.valid_to);
                    userHistroyTable.setCurrent_time("" + System.currentTimeMillis());
                    UtkashRoom.getAppDatabase(this).getuserhistorydao().addUser(userHistroyTable);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                showPDF(file.getAbsolutePath());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTaskComplete$4(file);
                    }
                }, 2000L);
                return;
            }
            Helper.dismissProgressDialog();
            this.downarrowFB.setVisibility(8);
            Toast.makeText(this, getResources().getString(R.string.pdf_loading_error_please_wait), 0).show();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTaskComplete$4(File file) {
        if (!this.isDownload && file.exists()) {
            this.isDownloadComplete = false;
            file.delete();
        }
        Helper.dismissProgressDialog();
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
        if (this.isDownload) {
            Toast.makeText(this, getResources().getString(R.string.unable_to_open_this_file), 0).show();
        }
        finish();
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
            PdfDetailScreen pdfDetailScreen;
            try {
                try {
                    try {
                        PdfDetailScreen.this.urlConnection = (HttpURLConnection) new URL(strings[0]).openConnection();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    this.response = "error";
                    if (PdfDetailScreen.this.output != null) {
                        pdfDetailScreen = PdfDetailScreen.this;
                    }
                }
                if (PdfDetailScreen.this.urlConnection.getResponseCode() != 200) {
                    this.response = "error";
                    String str = "Server returned HTTP " + PdfDetailScreen.this.urlConnection.getResponseCode() + " " + PdfDetailScreen.this.urlConnection.getResponseMessage();
                    try {
                        if (PdfDetailScreen.this.output != null) {
                            PdfDetailScreen.this.output.close();
                        }
                    } catch (Exception unused3) {
                    }
                    return str;
                }
                if (PdfDetailScreen.this.urlConnection.getResponseCode() == 200) {
                    PdfDetailScreen.this.urlConnection.getContentLength();
                    PdfDetailScreen.this.input = new BufferedInputStream(PdfDetailScreen.this.urlConnection.getInputStream());
                    this.response = "success";
                    PdfDetailScreen.this.setUserHistory();
                }
                if (PdfDetailScreen.this.output != null) {
                    pdfDetailScreen = PdfDetailScreen.this;
                    pdfDetailScreen.output.close();
                }
                return this.response;
            } catch (Throwable th) {
                try {
                    if (PdfDetailScreen.this.output != null) {
                        PdfDetailScreen.this.output.close();
                    }
                } catch (Exception unused4) {
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
            Helper.dismissProgressDialog();
            try {
                PdfDetailScreen.this.pdfViewPager.fromStream(PdfDetailScreen.this.input).onLoad(PdfDetailScreen.this).onError(new OnErrorListener() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.LOADURL_new.1
                    @Override // com.github.barteksc.pdfviewer.listener.OnErrorListener
                    public void onError(Throwable t) {
                        Toast.makeText(PdfDetailScreen.this, "No", 0).show();
                    }
                }).load();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            Helper.dismissProgressDialog();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        try {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.mProgressDialog.dismiss();
            }
            PDFView pDFView = this.pdfViewPager;
            if (pDFView != null) {
                pDFView.recycle();
            }
            OutputStream outputStream = this.output;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused) {
                }
                this.output = null;
            }
            InputStream inputStream = this.input;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                this.input = null;
            }
            HttpURLConnection httpURLConnection = this.urlConnection;
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
                this.urlConnection = null;
            }
        } catch (Exception e2) {
            Log.d("TAGPDFVIEW", "onDestroy: " + e2.getMessage());
        }
        super.onDestroy();
    }

    public void showDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        final ProgressBar progressBar = (ProgressBar) dialog.findViewById(R.id.progress_horizontal);
        final TextView textView = (TextView) dialog.findViewById(R.id.value123);
        new Thread(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.9
            @Override // java.lang.Runnable
            public void run() {
                while (PdfDetailScreen.this.status < 100) {
                    PdfDetailScreen.this.status++;
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    PdfDetailScreen.this.handler.post(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            progressBar.setProgress(PdfDetailScreen.this.status);
                            textView.setText(String.valueOf(PdfDetailScreen.this.status));
                            if (PdfDetailScreen.this.status == 100) {
                                PdfDetailScreen.this.isDownloadComplete = true;
                                PdfDetailScreen.this.downarrowFB.setImageResource(R.drawable.ic_downloaded_chapter);
                                dialog.dismiss();
                            }
                        }
                    });
                }
            }
        }).start();
        dialog.show();
        dialog.getWindow().setLayout(-1, -2);
    }

    void showDownloadNotification() {
        try {
            Intent intent = new Intent(this, (Class<?>) DownloadActivity.class);
            intent.addFlags(603979776);
            intent.putExtra("pdf_notification", 1);
            NotificationCompat.Builder priority = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(this.name).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, 0, intent, 201326592)).setPriority(1);
            NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this);
            NotificationChannel notificationChannel = new NotificationChannel(BuildConfig.PDF_CHANNEL_ID, "Channel human readable title", 3);
            notificationChannel.setSound(null, null);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            if (notificationManagerCompatFrom != null) {
                notificationManagerCompatFrom.createNotificationChannel(notificationChannel);
            }
            priority.setChannelId(BuildConfig.PDF_CHANNEL_ID);
            if (ActivityCompat.checkSelfPermission(this, PushPermissionHandler.ANDROID_PERMISSION_STRING) != 0) {
                return;
            }
            notificationManagerCompatFrom.notify(1, priority.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        try {
            if (newConfig.orientation == 1) {
                this.toolbar_layout.setVisibility(0);
            } else {
                this.toolbar_layout.setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserHistory() {
        try {
            UserHistroyTable userHistroyTable = new UserHistroyTable();
            userHistroyTable.setVideo_id(this.pdf_id);
            userHistroyTable.setPdf_name(this.name);
            userHistroyTable.setType("PDF");
            userHistroyTable.setPdf_url(this.url);
            if (this.isDownload) {
                userHistroyTable.setPdf_download("1");
            } else {
                userHistroyTable.setPdf_download("0");
            }
            userHistroyTable.setUser_id(MakeMyExam.userId);
            userHistroyTable.setCourse_id(this.course_id);
            userHistroyTable.setValid_to(this.valid_to);
            userHistroyTable.setCurrent_time("" + System.currentTimeMillis());
            UtkashRoom.getAppDatabase(this).getuserhistorydao().addUser(userHistroyTable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public File getFileExist(String fileName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/EDUTERIA_doc_folder/");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
            return new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
        }
        return new File(file + fileName);
    }

    private void checkForDownloadRefresh(Boolean isSaved) {
        PdfDetailScreen pdfDetailScreen;
        if (!isSaved.booleanValue()) {
            this.isDownloadComplete = false;
            this.downarrowFB.setImageResource(R.drawable.ic_menu_download);
            if (SharedPreference.getInstance().getString(Const.WEBVIEW_PDF).equalsIgnoreCase("1")) {
                pdfDetailScreen = this;
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Activity.PdfDetailScreen.10
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                }, 750L);
                pdfDetailScreen = this;
                PdfUtils.INSTANCE.checkPermissionsAndDownload(pdfDetailScreen, this.url, this.pdfViewPager, this.progressbar_pdf, this.requestPermissionLauncher);
                pdfDetailScreen.searchPDF.setVisibility(0);
            }
            pdfDetailScreen.download_btn.setVisibility(8);
            pdfDetailScreen.downarrowFB.setEnabled(true);
            return;
        }
        this.isDownloadComplete = true;
        this.downarrowFB.setEnabled(false);
        this.downarrowFB.setImageResource(R.drawable.ic_downloaded_chapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(Boolean bool) {
        if (bool.booleanValue()) {
            PdfUtils.INSTANCE.downloadAndSavePdf(this, this.url, this.pdfViewPager, this.progressbar_pdf);
        } else {
            Toast.makeText(this, "Permission denied!", 0).show();
        }
    }

    public boolean isPdfExists(Context context, String fileName) {
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Downloads.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_display_name=?", new String[]{fileName}, null);
        boolean z = cursorQuery != null && cursorQuery.moveToFirst();
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z;
    }
}
