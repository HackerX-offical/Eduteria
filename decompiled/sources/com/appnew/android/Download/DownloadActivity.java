package com.appnew.android.Download;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.pdf.PdfRenderer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.appnew.android.Download.Adapter.DownloadAudioAdapter;
import com.appnew.android.Download.Adapter.DownloadPDFAdapter;
import com.appnew.android.Download.Adapter.DownloadVideoAdapter;
import com.appnew.android.Download.Interface.onItemClick;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.model.MyCourse;
import com.appnew.android.player.music_player.MusicService;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.MycourseTable;
import com.appnew.android.table.PDFDataTable;
import com.appnew.android.table.VideosDownload;
import com.canhub.cropper.CropImageOptionsKt;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadActivity extends AppCompatActivity implements onItemClick, NetworkCall.MyNetworkCallBack {
    private static final Log log = LogFactory.getLog(DownloadActivity.class);
    private Integer FROM_PDF_NOTIFICATION;
    Button backBtn;
    private TextView delete;
    LinearLayout downloadAudio;
    private DownloadAudioAdapter downloadAudioAdapter;
    private TextView downloadAudioButton;
    LinearLayout downloadPDF;
    private DownloadPDFAdapter downloadPDFAdapter;
    private TextView downloadPdfButton;
    LinearLayout downloadVideo;
    private DownloadVideoAdapter downloadVideoAdapter;
    private TextView downloadVideoButton;
    RecyclerView download_recycler;
    File filepath;
    private ImageView image_back;
    LinearLayout layout;
    LinearLayout linear_tab;
    private Toolbar main_toolbar;
    RelativeLayout no_data_found_RL;
    private CheckBox select_all_delete;
    private TextView toolbarTitleTV;
    public UtkashRoom utkashRoom;
    private List<VideosDownload> download_videos = new ArrayList();
    private List<VideosDownload> audioDataList = new ArrayList();
    private String issue_type = "";
    int tabPosition = 0;
    private List<PDFDataTable> pdfDataTables = new ArrayList();
    private boolean isAllreadyClicked = false;
    private boolean only_download_pdf = true;
    private final BroadcastReceiver videoDownloadReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Download.DownloadActivity.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VideosDownload videosDownload;
            int intExtra = intent.getIntExtra("result", -1);
            String stringExtra = intent.getStringExtra("resourceId");
            int i = 0;
            if (intExtra == 1) {
                VideosDownload videosDownload2 = DownloadActivity.this.utkashRoom.getvideoDownloadao().getuser(stringExtra, "1");
                if (videosDownload2 == null || videosDownload2.getVideo_id() == null || DownloadActivity.this.download_videos.size() <= 0) {
                    return;
                }
                Iterator it = DownloadActivity.this.download_videos.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int i2 = i + 1;
                    if (((VideosDownload) it.next()).getVideo_id().equalsIgnoreCase(videosDownload2.getVideo_id())) {
                        DownloadActivity.this.download_videos.set(i, videosDownload2);
                        i = i2;
                        break;
                    }
                    i = i2;
                }
                if (DownloadActivity.this.download_recycler != null) {
                    DownloadActivity.this.setRecyclerView(i);
                    return;
                }
                DownloadActivity downloadActivity = DownloadActivity.this;
                downloadActivity.download_recycler = (RecyclerView) downloadActivity.findViewById(R.id.download_recycler);
                DownloadActivity.this.setRecyclerView(i);
                return;
            }
            if (intExtra == -101) {
                Toast.makeText(context, DownloadActivity.this.getResources().getString(R.string.please_retry_download_video), 0).show();
                return;
            }
            if (intExtra == -110) {
                Toast.makeText(context, DownloadActivity.this.getResources().getString(R.string.internet_issue_download_is_not_complete_please_try), 0).show();
                DownloadActivity downloadActivity2 = DownloadActivity.this;
                downloadActivity2.download_videos = downloadActivity2.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId);
                DownloadActivity.this.downloadVideoAdapter.notifyDataSetChanged();
                return;
            }
            if (intExtra == 3) {
                DownloadActivity.this.download_videos.clear();
                DownloadActivity downloadActivity3 = DownloadActivity.this;
                downloadActivity3.download_videos = downloadActivity3.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId);
                DownloadActivity.this.downloadVideoAdapter.notifydata(DownloadActivity.this.download_videos);
                return;
            }
            if (intExtra == 2021) {
                DownloadActivity.this.download_videos.clear();
                DownloadActivity downloadActivity4 = DownloadActivity.this;
                downloadActivity4.download_videos = downloadActivity4.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId);
                DownloadActivity.this.downloadVideoAdapter.notifydata(DownloadActivity.this.download_videos);
                return;
            }
            if (intExtra == 2) {
                VideosDownload videosDownload3 = DownloadActivity.this.utkashRoom.getvideoDownloadao().getuser(stringExtra, "0");
                if (videosDownload3 == null || videosDownload3.getVideo_id() == null || DownloadActivity.this.download_videos.size() <= 0) {
                    return;
                }
                Iterator it2 = DownloadActivity.this.download_videos.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    int i3 = i + 1;
                    if (((VideosDownload) it2.next()).getVideo_id().equalsIgnoreCase(videosDownload3.getVideo_id())) {
                        DownloadActivity.this.download_videos.set(i, videosDownload3);
                        i = i3;
                        break;
                    }
                    i = i3;
                }
                DownloadActivity.this.downloadVideoAdapter.notifyItemChanged(i - 1);
                return;
            }
            if (intExtra != 6 || DownloadActivity.this.download_videos.size() != 0 || (videosDownload = DownloadActivity.this.utkashRoom.getvideoDownloadao().getuser(stringExtra, "0")) == null || videosDownload.getVideo_id() == null) {
                return;
            }
            Iterator it3 = DownloadActivity.this.download_videos.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                int i4 = i + 1;
                if (((VideosDownload) it3.next()).getVideo_id().equalsIgnoreCase(videosDownload.getVideo_id())) {
                    DownloadActivity.this.download_videos.set(i, videosDownload);
                    i = i4;
                    break;
                }
                i = i4;
            }
            if (DownloadActivity.this.download_recycler != null) {
                DownloadActivity.this.setRecyclerView(i);
                return;
            }
            DownloadActivity downloadActivity5 = DownloadActivity.this;
            downloadActivity5.download_recycler = (RecyclerView) downloadActivity5.findViewById(R.id.download_recycler);
            DownloadActivity.this.setRecyclerView(i);
        }
    };
    private BroadcastReceiver musicServiceReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Download.DownloadActivity.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            intent.getStringExtra("resourceId");
            Boolean boolValueOf = Boolean.valueOf(intent.getBooleanExtra("isRefresh", true));
            if (booleanExtra && DownloadActivity.this.downloadAudioAdapter != null && boolValueOf.booleanValue()) {
                DownloadActivity.this.downloadAudioAdapter.notifyDataSetChanged();
            }
        }
    };
    private BroadcastReceiver percentage_receiver = new BroadcastReceiver() { // from class: com.appnew.android.Download.DownloadActivity.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VideosDownload videosDownload = DownloadActivity.this.utkashRoom.getvideoDownloadao().getuser(intent.getStringExtra("resourceId"), "0");
            if (videosDownload == null || videosDownload.getVideo_id() == null || DownloadActivity.this.download_videos.size() <= 0) {
                return;
            }
            Iterator it = DownloadActivity.this.download_videos.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i2 = i + 1;
                if (((VideosDownload) it.next()).getVideo_id().equalsIgnoreCase(videosDownload.getVideo_id())) {
                    DownloadActivity.this.download_videos.set(i, videosDownload);
                    i = i2;
                    break;
                }
                i = i2;
            }
            if (DownloadActivity.this.download_recycler != null) {
                DownloadActivity.this.setRecyclerView(i);
                return;
            }
            DownloadActivity downloadActivity = DownloadActivity.this;
            downloadActivity.download_recycler = (RecyclerView) downloadActivity.findViewById(R.id.download_recycler);
            DownloadActivity.this.setRecyclerView(i);
        }
    };

    public interface PDFValidationCallback {
        void onResult(List<PDFDataTable> validList);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Download.Interface.onItemClick
    public void getvideo_url(int pos, VideosDownload videoDownload, String type) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_download);
        this.downloadVideo = (LinearLayout) findViewById(R.id.downloadVideo);
        this.downloadPDF = (LinearLayout) findViewById(R.id.downloadPDF);
        this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
        this.main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        this.downloadPdfButton = (TextView) findViewById(R.id.downloadPdfButton);
        this.downloadVideoButton = (TextView) findViewById(R.id.downloadVideoButton);
        this.downloadAudio = (LinearLayout) findViewById(R.id.downloadAudio);
        this.downloadAudioButton = (TextView) findViewById(R.id.downloadAudioButton);
        this.linear_tab = (LinearLayout) findViewById(R.id.linear_tab);
        this.download_recycler = (RecyclerView) findViewById(R.id.download_recycler);
        this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
        this.backBtn = (Button) findViewById(R.id.backBtn);
        this.select_all_delete = (CheckBox) findViewById(R.id.select_all_delete);
        this.layout = (LinearLayout) findViewById(R.id.layout);
        this.delete = (TextView) findViewById(R.id.delete);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        View viewFindViewById = findViewById(R.id.layout);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, this.main_toolbar);
        }
        this.FROM_PDF_NOTIFICATION = Integer.valueOf(getIntent().getIntExtra("pdf_notification", 0));
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
            if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getId() != null && !SharedPreference.getInstance().getLoggedInUser().getId().equalsIgnoreCase("0")) {
                MakeMyExam.setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
                MakeMyExam.userId = SharedPreference.getInstance().getLoggedInUser().getId();
            }
            FirebaseCrashlytics.getInstance().setUserId(MakeMyExam.userId);
            this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$0();
                }
            }));
            this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$1();
                }
            }));
            this.select_all_delete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$onCreate$2(compoundButton, z);
                }
            });
            this.delete.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$3(view);
                }
            });
            if (getIntent().getStringExtra("mode") != null && getIntent().getStringExtra("mode").equalsIgnoreCase(OfflineMessageRequest.ELEMENT)) {
                this.only_download_pdf = false;
            }
            handleMyDownloadTabs();
            this.downloadVideo.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$4();
                }
            }));
            this.downloadPDF.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$5();
                }
            }));
            this.downloadAudio.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$6();
                }
            }));
            if (this.only_download_pdf) {
                if (Helper.isConnected(this)) {
                    new NetworkCall(this, this).NetworkAPICall(API.get_my_courses, "", true, false);
                } else {
                    getAllVideo();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        handleBackPress();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        handleBackPress();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(CompoundButton compoundButton, boolean z) {
        int i = this.tabPosition;
        if (i == 0) {
            if (z) {
                if (this.downloadVideoAdapter == null || this.download_videos.size() <= 0) {
                    return;
                }
                this.downloadVideoAdapter.visible_layout(this.select_all_delete.isChecked(), this.download_videos);
                return;
            }
            if (this.downloadVideoAdapter == null || this.download_videos.size() <= 0) {
                return;
            }
            this.downloadVideoAdapter.visible_layout(false, this.download_videos);
            return;
        }
        if (i == 1) {
            if (z) {
                if (this.downloadPDFAdapter == null || this.pdfDataTables.size() <= 0) {
                    return;
                }
                this.downloadPDFAdapter.visible_layout(this.select_all_delete.isChecked(), (ArrayList) this.pdfDataTables);
                return;
            }
            if (this.downloadPDFAdapter == null || this.pdfDataTables.size() <= 0) {
                return;
            }
            this.downloadPDFAdapter.visible_layout(false, (ArrayList) this.pdfDataTables);
            return;
        }
        if (i == 2) {
            if (z) {
                if (this.downloadAudioAdapter == null || this.audioDataList.size() <= 0) {
                    return;
                }
                this.downloadAudioAdapter.visible_layout(this.select_all_delete.isChecked(), (ArrayList) this.audioDataList);
                return;
            }
            if (this.downloadAudioAdapter == null || this.audioDataList.size() <= 0) {
                return;
            }
            this.downloadAudioAdapter.visible_layout(false, (ArrayList) this.audioDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (this.isAllreadyClicked) {
            return;
        }
        alert_dialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$4() {
        videoClick();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$5() {
        pdfClick();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$6() {
        audioClick();
        return null;
    }

    private void handleMyDownloadTabs() {
        try {
            String string = SharedPreference.getInstance().getString(Const.MY_DOWNLOAD_TABS);
            if (TextUtils.isEmpty(string) || string.equalsIgnoreCase("0#0#0")) {
                string = "1#0#0";
            } else if (string.equalsIgnoreCase("0#1#0")) {
                this.only_download_pdf = false;
                string = "1#1#0";
            } else if (string.equalsIgnoreCase("0#0#1")) {
                string = "1#0#1";
            }
            String[] strArrSplit = string.split(MqttTopic.MULTI_LEVEL_WILDCARD);
            if (strArrSplit.length > 0 && strArrSplit[0].equalsIgnoreCase("1")) {
                this.linear_tab.setVisibility(0);
                this.downloadVideo.setVisibility(0);
            } else {
                this.linear_tab.setVisibility(0);
                this.downloadVideo.setVisibility(8);
            }
            if (strArrSplit.length > 1 && strArrSplit[1].equalsIgnoreCase("1")) {
                this.linear_tab.setVisibility(0);
                this.downloadPDF.setVisibility(0);
            } else {
                this.linear_tab.setVisibility(0);
                this.downloadPDF.setVisibility(8);
            }
            if (strArrSplit.length > 2 && strArrSplit[2].equalsIgnoreCase("1")) {
                this.linear_tab.setVisibility(0);
                this.downloadAudio.setVisibility(0);
            } else {
                this.linear_tab.setVisibility(0);
                this.downloadAudio.setVisibility(8);
            }
            try {
                int i = 0;
                for (String str : strArrSplit) {
                    i += Integer.parseInt(str);
                }
                if (i == 1) {
                    this.linear_tab.setVisibility(8);
                }
            } catch (NumberFormatException e2) {
                android.util.Log.d("MyDownloadTabs", "handleMyDownloadTabs: " + e2.getMessage());
            }
            if (this.FROM_PDF_NOTIFICATION.intValue() != 1 && this.only_download_pdf) {
                videoClick();
                return;
            }
            if (strArrSplit.length > 1 && strArrSplit[1].equalsIgnoreCase("1")) {
                pdfClick();
            } else {
                videoClick();
                Snackbar.make(this.no_data_found_RL, "PDF feature is not enable at this moment.", -1).show();
            }
        } catch (Exception e3) {
            android.util.Log.e("MyDownloadTabs: ", "handleMyDownloadTabs: " + e3.getMessage());
        }
    }

    private void videoClick() {
        this.downloadVideo.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        this.downloadVideoButton.setTextColor(getResources().getColor(R.color.white));
        this.downloadPDF.setBackgroundColor(getResources().getColor(R.color.logout_bg_color));
        this.downloadPdfButton.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.downloadAudio.setBackgroundColor(getResources().getColor(R.color.logout_bg_color));
        this.downloadAudioButton.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.downloadVideoAdapter = null;
        this.tabPosition = 0;
        this.download_videos.clear();
        this.pdfDataTables.clear();
        this.audioDataList.clear();
        getAllVideo();
    }

    private void pdfClick() {
        this.downloadPDF.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        this.downloadPdfButton.setTextColor(getResources().getColor(R.color.white));
        this.downloadVideo.setBackgroundColor(getResources().getColor(R.color.logout_bg_color));
        this.downloadVideoButton.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.downloadAudio.setBackgroundColor(getResources().getColor(R.color.logout_bg_color));
        this.downloadAudioButton.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.tabPosition = 1;
        this.download_videos.clear();
        this.pdfDataTables.clear();
        this.audioDataList.clear();
        getAllPdfs();
    }

    private void audioClick() {
        this.downloadAudio.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        this.downloadAudioButton.setTextColor(getResources().getColor(R.color.white));
        this.downloadVideo.setBackgroundColor(getResources().getColor(R.color.logout_bg_color));
        this.downloadVideoButton.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.downloadPDF.setBackgroundColor(getResources().getColor(R.color.logout_bg_color));
        this.downloadPdfButton.setTextColor(getResources().getColor(R.color.colorPrimary));
        this.tabPosition = 2;
        this.download_videos.clear();
        this.pdfDataTables.clear();
        this.audioDataList.clear();
        getAllAudios();
    }

    private void getAllVideo() {
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getAllVideo$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllVideo$8() {
        try {
            this.download_videos = this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId);
            android.util.Log.e("SATYA_TEST_download_videos", "onCreate: " + this.download_videos);
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getAllVideo$7();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllVideo$7() {
        Helper.dismissProgressDialog();
        if (this.download_videos.size() > 0) {
            this.select_all_delete.setChecked(false);
            this.delete.setVisibility(8);
            this.select_all_delete.setVisibility(0);
            this.download_recycler.setVisibility(0);
            this.no_data_found_RL.setVisibility(8);
            DownloadVideoAdapter downloadVideoAdapter = this.downloadVideoAdapter;
            if (downloadVideoAdapter == null) {
                this.downloadVideoAdapter = new DownloadVideoAdapter(this, this.download_videos, this);
                this.download_recycler.setLayoutManager(new LinearLayoutManager(this, 1, false));
                this.download_recycler.setAdapter(this.downloadVideoAdapter);
                ((SimpleItemAnimator) Objects.requireNonNull(this.download_recycler.getItemAnimator())).setSupportsChangeAnimations(false);
                return;
            }
            ((DownloadVideoAdapter) Objects.requireNonNull(downloadVideoAdapter)).notifydata(this.download_videos);
            return;
        }
        this.delete.setVisibility(8);
        this.select_all_delete.setVisibility(8);
        this.download_recycler.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    private void getAllPdfs() {
        try {
            List<PDFDataTable> listOfData = UtkashRoom.getAppDatabase(this).getPDFDataDao().getListOfData();
            android.util.Log.d("PDFDataTables", "Before: " + listOfData.size());
            validatePDFListInBackground(this, listOfData, new PDFValidationCallback() { // from class: com.appnew.android.Download.DownloadActivity.1
                @Override // com.appnew.android.Download.DownloadActivity.PDFValidationCallback
                public void onResult(List<PDFDataTable> validList) {
                    android.util.Log.d("PDFDataTables", "After: " + validList.size());
                    DownloadActivity.this.pdfDataTables = validList;
                    DownloadActivity downloadActivity = DownloadActivity.this;
                    downloadActivity.no_data_found_RL = (RelativeLayout) downloadActivity.findViewById(R.id.no_data_found_RL);
                    if (!DownloadActivity.this.pdfDataTables.isEmpty()) {
                        DownloadActivity.this.download_recycler.setLayoutManager(new LinearLayoutManager(DownloadActivity.this, 1, false));
                        DownloadActivity downloadActivity2 = DownloadActivity.this;
                        DownloadActivity downloadActivity3 = DownloadActivity.this;
                        downloadActivity2.downloadPDFAdapter = new DownloadPDFAdapter(downloadActivity3, (ArrayList) downloadActivity3.pdfDataTables, DownloadActivity.this);
                        DownloadActivity.this.download_recycler.setAdapter(DownloadActivity.this.downloadPDFAdapter);
                        DownloadActivity.this.select_all_delete.setVisibility(0);
                        DownloadActivity.this.select_all_delete.setChecked(false);
                        DownloadActivity.this.delete.setVisibility(8);
                        DownloadActivity.this.no_data_found_RL.setVisibility(8);
                        DownloadActivity.this.download_recycler.setVisibility(0);
                        return;
                    }
                    DownloadActivity.this.download_recycler.setVisibility(8);
                    DownloadActivity.this.no_data_found_RL.setVisibility(0);
                    DownloadActivity.this.select_all_delete.setVisibility(8);
                    DownloadActivity.this.delete.setVisibility(8);
                }
            });
        } catch (Exception e2) {
            android.util.Log.d("downloadedFilePath", "eroor: " + e2.getMessage());
        }
    }

    public void validatePDFListInBackground(final Context context, final List<PDFDataTable> listOfData, final PDFValidationCallback callback) {
        try {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            final Handler handler = new Handler(Looper.getMainLooper());
            executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$validatePDFListInBackground$10(listOfData, context, handler, callback);
                }
            });
        } catch (Exception e2) {
            android.util.Log.d("downloadedFilePath", "eroor: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$validatePDFListInBackground$10(List list, Context context, Handler handler, final PDFValidationCallback pDFValidationCallback) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PDFDataTable pDFDataTable = (PDFDataTable) it.next();
            if (!isValidPDF(pDFDataTable.getPdfPath())) {
                File fileExist = getFileExist(pDFDataTable.getPdfFile());
                if (fileExist.exists()) {
                    fileExist.delete();
                }
                UtkashRoom.getAppDatabase(context).getPDFDataDao().delete(pDFDataTable);
            }
        }
        final List<PDFDataTable> listOfData = UtkashRoom.getAppDatabase(context).getPDFDataDao().getListOfData();
        handler.post(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                DownloadActivity.lambda$validatePDFListInBackground$9(pDFValidationCallback, listOfData);
            }
        });
    }

    static /* synthetic */ void lambda$validatePDFListInBackground$9(PDFValidationCallback pDFValidationCallback, List list) {
        if (pDFValidationCallback != null) {
            pDFValidationCallback.onResult(list);
        }
    }

    public boolean isValidPDF(String downloadedFilePath) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(downloadedFilePath), 268435456);
            new PdfRenderer(parcelFileDescriptorOpen).close();
            parcelFileDescriptorOpen.close();
            android.util.Log.d("downloadedFilePath", "The PDF file is valid.");
            return true;
        } catch (Exception e2) {
            android.util.Log.d("downloadedFilePath", "eroor: " + e2.getMessage());
            return false;
        }
    }

    public File getFileExist(String fileName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
            this.filepath = new File(getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
        } else {
            this.filepath = new File(file + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
        }
        return this.filepath;
    }

    private void getAllAudios() {
        ArrayList arrayList = (ArrayList) UtkashRoom.getAppDatabase(this).getvideoDownloadao().getalldownload_videos_for_audio(MakeMyExam.getUserId());
        this.audioDataList = arrayList;
        if (arrayList.size() > 0) {
            this.no_data_found_RL.setVisibility(8);
            this.download_recycler.setVisibility(0);
            this.download_recycler.setLayoutManager(new LinearLayoutManager(this, 1, false));
            DownloadAudioAdapter downloadAudioAdapter = new DownloadAudioAdapter(this, this.audioDataList, this);
            this.downloadAudioAdapter = downloadAudioAdapter;
            this.download_recycler.setAdapter(downloadAudioAdapter);
            this.select_all_delete.setVisibility(0);
            this.select_all_delete.setChecked(false);
            this.delete.setVisibility(8);
            return;
        }
        this.download_recycler.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
        this.select_all_delete.setVisibility(8);
        this.delete.setVisibility(8);
    }

    private void handleBackPress() {
        if (Helper.isConnected(this)) {
            Intent intent = new Intent();
            intent.putExtra("fromDownloads", true);
            setResult(1000, intent);
            super.onBackPressed();
            return;
        }
        finishAffinity();
    }

    private void unstallvideos() {
        File file = new File(getExternalFilesDir(null) + "/.Videos");
        if (!file.exists() || file.listFiles() == null || ((File[]) Objects.requireNonNull(file.listFiles())).length == 0) {
            getbelow10videos();
        } else if (((File[]) Objects.requireNonNull(file.listFiles())).length > 0 && !Helper.isNetworkConnected(this)) {
            Snackbar.make(this.no_data_found_RL, getResources().getString(R.string.no_internet_connection), -1).show();
        } else {
            new ArrayList();
            getbelow10videos();
        }
    }

    private void getbelow10videos() {
        File file = new File(Environment.getExternalStorageDirectory() + VideoDownloadService.DOWNLOADED_VIDEOS);
        if (!file.exists() || file.listFiles() == null || ((File[]) Objects.requireNonNull(file.listFiles())).length == 0) {
            getAllVideo();
        } else {
            getAllVideo();
        }
    }

    private void logout_user_videos() {
        if (this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId).size() == 0) {
            File file = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS);
            if (!file.exists() || file.listFiles() == null || ((File[]) Objects.requireNonNull(file.listFiles())).length == 0) {
                unstallvideos();
                return;
            } else if (((File[]) Objects.requireNonNull(file.listFiles())).length > 0 && !Helper.isNetworkConnected(this)) {
                Snackbar.make(this.no_data_found_RL, getResources().getString(R.string.no_internet_please_connect_device_to_internet), 0).show();
                return;
            } else {
                unstallvideos();
                return;
            }
        }
        unstallvideos();
    }

    private void alert_dialog() {
        this.isAllreadyClicked = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        int i = this.tabPosition;
        if (i == 0) {
            builder.setTitle(R.string.delete_video);
            builder.setMessage(R.string.are_you_sure_you_want_to_delete_the_selected_videos);
        } else if (i == 1) {
            builder.setTitle(R.string.delete_pdf);
            builder.setMessage(R.string.are_you_sure_you_want_to_delete_the_selected_pdfs);
        } else if (i == 2) {
            builder.setTitle(R.string.delete_audio);
            builder.setMessage(R.string.are_you_sure_you_want_to_delete_the_selected_audios);
        }
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda16
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$alert_dialog$18(dialogInterface, i2);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.Download.DownloadActivity.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialog) {
                DownloadActivity.this.isAllreadyClicked = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$18(DialogInterface dialogInterface, int i) {
        int i2 = this.tabPosition;
        int i3 = 0;
        if (i2 == 0) {
            while (i3 < this.download_videos.size()) {
                if (this.download_videos.get(i3).getIs_selected() != null && this.download_videos.get(i3).getIs_selected().equalsIgnoreCase("1")) {
                    File file = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + this.download_videos.get(i3).getVideo_history() + ".mp4");
                    File file2 = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + this.download_videos.get(i3).getVideo_history() + ".mp4");
                    if (file.exists() || file2.exists()) {
                        file.delete();
                    }
                    if (this.download_videos.get(i3).getCourse_id() != null && !this.download_videos.get(i3).getCourse_id().equalsIgnoreCase("")) {
                        this.utkashRoom.getuserhistorydao().delete_viavideo_id(this.download_videos.get(i3).getVideo_id(), this.download_videos.get(i3).getCourse_id(), MakeMyExam.userId);
                    } else {
                        this.utkashRoom.getuserhistorydao().deletevideo_id(this.download_videos.get(i3).getVideo_id(), MakeMyExam.userId);
                    }
                    if (this.download_videos.get(i3).getVideo_type().equalsIgnoreCase("1")) {
                        this.utkashRoom.getvideoDownloadao().delete_viavideoid_for_youtube(this.download_videos.get(i3).getVideo_id(), MakeMyExam.userId);
                    } else {
                        this.utkashRoom.getvideoDownloadao().delete_viavideoid(this.download_videos.get(i3).getVideo_id(), MakeMyExam.userId);
                    }
                }
                i3++;
            }
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$alert_dialog$13();
                }
            });
        } else if (i2 == 1) {
            while (i3 < this.pdfDataTables.size()) {
                if (this.pdfDataTables.get(i3).getIs_selected() != null && this.pdfDataTables.get(i3).getIs_selected().equalsIgnoreCase("1")) {
                    File fileExist = getFileExist(this.pdfDataTables.get(i3).getPdfFile());
                    if (fileExist.exists()) {
                        fileExist.delete();
                    }
                    this.utkashRoom.getPDFDataDao().delete(this.pdfDataTables.get(i3));
                }
                i3++;
            }
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$alert_dialog$15();
                }
            });
        } else if (i2 == 2) {
            while (i3 < this.audioDataList.size()) {
                if (this.audioDataList.get(i3).getIs_selected() != null && this.audioDataList.get(i3).getIs_selected().equalsIgnoreCase("1")) {
                    File file3 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_AUDIOS + this.audioDataList.get(i3).getVideo_history() + ".mp3");
                    if (file3.exists()) {
                        file3.delete();
                    }
                    this.utkashRoom.getvideoDownloadao().delete_viavideoid_for_audio(this.audioDataList.get(i3).getVideo_id(), MakeMyExam.userId);
                }
                i3++;
            }
            AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$alert_dialog$17();
                }
            });
        }
        dialogInterface.dismiss();
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$13() {
        try {
            this.download_videos = this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId);
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$alert_dialog$12();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$12() {
        List<VideosDownload> list = this.download_videos;
        if (list == null || list.size() == 0) {
            this.download_videos = new ArrayList();
            this.select_all_delete.setVisibility(8);
            this.downloadVideoAdapter.notifydata(this.download_videos);
            this.delete.setVisibility(8);
            this.download_recycler.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            return;
        }
        this.select_all_delete.setVisibility(0);
        this.select_all_delete.setChecked(false);
        this.delete.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$15() {
        try {
            this.pdfDataTables.clear();
            this.pdfDataTables = UtkashRoom.getAppDatabase(this).getPDFDataDao().getListOfData();
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$alert_dialog$14();
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$14() {
        List<PDFDataTable> list = this.pdfDataTables;
        if (list == null || list.size() == 0) {
            this.pdfDataTables = new ArrayList();
            this.select_all_delete.setVisibility(8);
            this.delete.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        } else {
            this.select_all_delete.setVisibility(0);
            this.select_all_delete.setChecked(false);
            this.delete.setVisibility(8);
        }
        this.downloadPDFAdapter.notifydata(this.pdfDataTables);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$17() {
        try {
            this.audioDataList.clear();
            this.audioDataList = this.utkashRoom.getvideoDownloadao().getalldownload_videos_for_audio(MakeMyExam.userId);
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$alert_dialog$16();
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$alert_dialog$16() {
        List<VideosDownload> list = this.audioDataList;
        if (list == null || list.size() == 0) {
            this.audioDataList = new ArrayList();
            this.select_all_delete.setVisibility(8);
            this.delete.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        } else {
            this.select_all_delete.setVisibility(0);
            this.select_all_delete.setChecked(false);
            this.delete.setVisibility(8);
        }
        this.downloadAudioAdapter.notifydata(this.audioDataList);
    }

    public void openwatchlist_dailog_resource(Context context, final HashMap<Integer, String> mediaResponseMap, final VideosDownload videosDownload, final int pos) {
        try {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.videosheetDialogTheme);
            bottomSheetDialog.setContentView(R.layout.quality_download_view);
            ((Window) Objects.requireNonNull(bottomSheetDialog.getWindow())).getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            bottomSheetDialog.setCancelable(false);
            bottomSheetDialog.setCanceledOnTouchOutside(true);
            final LinearLayout linearLayout = (LinearLayout) bottomSheetDialog.findViewById(R.id.lnPreparing);
            final TextView textView = (TextView) bottomSheetDialog.findViewById(R.id.btnLow);
            TextView textView2 = (TextView) bottomSheetDialog.findViewById(R.id.tvResName);
            final TextView textView3 = (TextView) bottomSheetDialog.findViewById(R.id.btnMedium);
            final TextView textView4 = (TextView) bottomSheetDialog.findViewById(R.id.btnHigh);
            textView2.setText(videosDownload.getVideo_name());
            new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadActivity.lambda$openwatchlist_dailog_resource$19(mediaResponseMap, textView, textView3, textView4, linearLayout);
                }
            }, 500L);
            ((TextView) Objects.requireNonNull(textView)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$20(mediaResponseMap, videosDownload, pos, bottomSheetDialog);
                }
            }));
            ((TextView) Objects.requireNonNull(textView3)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$21(mediaResponseMap, videosDownload, pos, bottomSheetDialog);
                }
            }));
            ((TextView) Objects.requireNonNull(textView4)).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$openwatchlist_dailog_resource$22(mediaResponseMap, videosDownload, pos, bottomSheetDialog);
                }
            }));
            if (bottomSheetDialog.isShowing()) {
                return;
            }
            bottomSheetDialog.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void lambda$openwatchlist_dailog_resource$19(HashMap map, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        if (map.get(180) != null) {
            textView.setVisibility(0);
        }
        if (map.get(270) != null) {
            ((TextView) Objects.requireNonNull(textView2)).setVisibility(0);
        }
        if (map.get(Integer.valueOf(CropImageOptionsKt.DEGREES_360)) != null) {
            ((TextView) Objects.requireNonNull(textView3)).setVisibility(0);
        }
        ((LinearLayout) Objects.requireNonNull(linearLayout)).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$20(HashMap map, VideosDownload videosDownload, int i, BottomSheetDialog bottomSheetDialog) {
        if (this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
            return null;
        }
        Download_dialog((String) map.get(180), videosDownload, i);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$21(HashMap map, VideosDownload videosDownload, int i, BottomSheetDialog bottomSheetDialog) {
        if (this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
            return null;
        }
        Download_dialog((String) map.get(270), videosDownload, i);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openwatchlist_dailog_resource$22(HashMap map, VideosDownload videosDownload, int i, BottomSheetDialog bottomSheetDialog) {
        if (this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
            return null;
        }
        Download_dialog((String) map.get(Integer.valueOf(CropImageOptionsKt.DEGREES_360)), videosDownload, i);
        dismissCalculatorDialog(bottomSheetDialog);
        return null;
    }

    private void dismissCalculatorDialog(BottomSheetDialog watchlist) {
        if (watchlist == null || !watchlist.isShowing()) {
            return;
        }
        watchlist.dismiss();
        watchlist.cancel();
    }

    private void Download_dialog(String url, VideosDownload videosDownload, int position) {
        VideosDownload videosDownload2 = this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete());
        if (this.utkashRoom.getvideoDownloadao().isRecordexist_1(videosDownload.getVideo_id(), "1", videosDownload.getUser_id())) {
            if (new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videosDownload.getVideo_name() + ".mp4").exists()) {
                return;
            }
            this.utkashRoom.getvideoDownloadao().delete_viavideoid(videosDownload.getVideo_id(), MakeMyExam.userId);
            return;
        }
        if (this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() == 0) {
            this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), "0", "Downloading Running", 0);
            if (videosDownload.getVideo_id() != null && this.download_videos.size() > 0) {
                Iterator<VideosDownload> it = this.download_videos.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int i2 = i + 1;
                    if (it.next().getVideo_id().equalsIgnoreCase(videosDownload.getVideo_id())) {
                        videosDownload.setVideo_status("Downloading Running");
                        videosDownload.setPercentage(0);
                        this.download_videos.set(i, videosDownload);
                        i = i2;
                        break;
                    }
                    i = i2;
                }
                this.downloadVideoAdapter.notifyItemChanged(i - 1);
            }
            Intent intent = new Intent(this, (Class<?>) VideoDownloadService.class);
            intent.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, false);
            intent.putExtra(VideoDownloadService.URL, url);
            intent.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
            intent.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
            intent.putExtra(Constants.INAPP_POSITION, position);
            intent.putExtra("status", "Downloading Running");
            intent.putExtra("name", videosDownload.getVideo_history());
            Helper.startVideoDownloadService(this, intent);
            return;
        }
        if (this.utkashRoom.getvideoDownloadao().getuser(videosDownload.getVideo_id(), videosDownload.getIs_complete()).getToal_downloadlocale().longValue() >= 0) {
            this.utkashRoom.getvideoDownloadao().update_videostatus(videosDownload.getVideo_id(), "0", "Downloading Running", videosDownload2.getPercentage());
            if (videosDownload.getVideo_id() != null && this.download_videos.size() > 0) {
                Iterator<VideosDownload> it2 = this.download_videos.iterator();
                int i3 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    int i4 = i3 + 1;
                    VideosDownload videosDownload3 = videosDownload2;
                    if (it2.next().getVideo_id().equalsIgnoreCase(videosDownload.getVideo_id())) {
                        videosDownload.setVideo_status("Downloading Running");
                        videosDownload.setPercentage(videosDownload3.getPercentage());
                        this.download_videos.set(i3, videosDownload);
                        i3 = i4;
                        break;
                    }
                    i3 = i4;
                    videosDownload2 = videosDownload3;
                }
                this.downloadVideoAdapter.notifyItemChanged(i3 - 1);
            }
            Intent intent2 = new Intent(this, (Class<?>) VideoDownloadService.class);
            intent2.putExtra(VideoDownloadService.URL, url);
            intent2.putExtra(VideoDownloadService.DOWNLOAD_SERVICE_ID, videosDownload.getVideo_id());
            intent2.putExtra(Constants.INAPP_POSITION, position);
            intent2.putExtra(VideoDownloadService.FILEPATH, videosDownload.getVideo_name());
            intent2.putExtra("name", videosDownload.getVideo_history());
            intent2.putExtra(VideoDownloadService.FILEDOWNLOADSTATUS, true);
            Helper.startVideoDownloadService(this, intent2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.utkashRoom == null) {
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.utkashRoom = appDatabase;
            appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
        }
        if (com.appnew.android.home.Constants.revison_set) {
            getAllVideo();
            com.appnew.android.home.Constants.revison_set = false;
        }
        if (Helper.isConnected(this)) {
            new NetworkCall(this, this).NetworkAPICall(API.get_my_courses, "", true, false);
        } else {
            getAllVideo();
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.videoDownloadReceiver, new IntentFilter(VideoDownloadService.VIDEO_DOWNLOAD_ACTION));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.percentage_receiver, new IntentFilter(VideoDownloadService.VIDEO_DOWNLOAD_PROGRESS));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.musicServiceReceiver, new IntentFilter(MusicService.INSTANCE.getMUSIC_PLAYER_ACTION()));
        DownloadAudioAdapter downloadAudioAdapter = this.downloadAudioAdapter;
        if (downloadAudioAdapter != null) {
            downloadAudioAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecyclerView(int index) {
        DownloadVideoAdapter downloadVideoAdapter = this.downloadVideoAdapter;
        if (downloadVideoAdapter == null) {
            DownloadVideoAdapter downloadVideoAdapter2 = new DownloadVideoAdapter(this, this.download_videos, this);
            this.downloadVideoAdapter = downloadVideoAdapter2;
            this.download_recycler.setAdapter(downloadVideoAdapter2);
            return;
        }
        downloadVideoAdapter.notifyItemChanged(index - 1);
    }

    @Override // com.appnew.android.Download.Interface.onItemClick
    public void OnVideoClick(int pos, VideosDownload videoDownload, String type) {
        if (type.equalsIgnoreCase("play")) {
            Download_dialog(videoDownload.getMp4_download_url(), videoDownload, pos);
            return;
        }
        if (type.equalsIgnoreCase("Pause")) {
            VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(videoDownload.getVideo_id(), videoDownload.getIs_complete(), MakeMyExam.userId);
            if (videosDownload == null || videosDownload.getPercentage() <= 0 || !VideoDownloadService.video_id.equalsIgnoreCase(videosDownload.getVideo_id())) {
                return;
            }
            VideoDownloadService.action = VideoDownloadService.PAUSE;
            return;
        }
        if (type.equalsIgnoreCase("Cancel")) {
            this.issue_type = "";
            if (videoDownload.getPercentage() == 100) {
                File file = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videoDownload.getVideo_history() + ".mp4");
                if (file.exists()) {
                    file.delete();
                }
                this.utkashRoom.getvideoDownloadao().delete_viavideoid(videoDownload.getVideo_id(), MakeMyExam.userId);
                this.download_videos.remove(pos);
                this.downloadVideoAdapter.notifyItemRemoved(pos);
                if (this.download_videos.size() == 0) {
                    this.downloadVideoAdapter.notifyDataSetChanged();
                    this.select_all_delete.setVisibility(8);
                } else {
                    this.downloadVideoAdapter.notifyItemRangeChanged(pos, this.download_videos.size());
                }
                Toast.makeText(this, getResources().getString(R.string.cancel_video_please_wait), 0).show();
                return;
            }
            if (videoDownload.getPercentage() < 0 || videoDownload.getPercentage() >= 100) {
                return;
            }
            if (videoDownload.getVideo_status().equalsIgnoreCase("Downloading Pause")) {
                File file2 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videoDownload.getVideo_history() + ".mp4");
                if (file2.exists()) {
                    file2.delete();
                }
                this.utkashRoom.getvideoDownloadao().delete_viavideoid(videoDownload.getVideo_id(), MakeMyExam.userId);
                this.download_videos.remove(pos);
                this.downloadVideoAdapter.notifyItemRemoved(pos);
                if (this.download_videos.size() == 0) {
                    this.downloadVideoAdapter.notifyDataSetChanged();
                    this.select_all_delete.setVisibility(8);
                } else {
                    this.downloadVideoAdapter.notifyItemRangeChanged(pos, this.download_videos.size());
                }
            } else {
                Toast.makeText(this, getResources().getString(R.string.video_is_deleted_successfully), 0).show();
                if (VideoDownloadService.video_id.equalsIgnoreCase(videoDownload.getVideo_id())) {
                    try {
                        VideoDownloadService.action = VideoDownloadService.CANCEL;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    File file3 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videoDownload.getVideo_history() + ".mp4");
                    if (file3.exists()) {
                        file3.delete();
                    }
                    this.download_videos = this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId);
                    this.utkashRoom.getvideoDownloadao().delete_viavideoid(videoDownload.getVideo_id(), MakeMyExam.userId);
                    this.download_videos.remove(pos);
                    if (this.download_videos.size() == 0) {
                        this.downloadVideoAdapter.notifyDataSetChanged();
                        this.select_all_delete.setVisibility(8);
                    } else {
                        this.downloadVideoAdapter.notifydata(this.download_videos);
                    }
                }
            }
            try {
                this.downloadVideoAdapter.notifyDataSetChanged();
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.videoDownloadReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.videoDownloadReceiver);
        }
        if (this.percentage_receiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.percentage_receiver);
        }
        if (this.musicServiceReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.musicServiceReceiver);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        handleBackPress();
    }

    public void visibleSelectButton(List<VideosDownload> videos) {
        boolean z = false;
        for (VideosDownload videosDownload : videos) {
            if (videosDownload.getIs_selected() != null && videosDownload.getIs_selected().equalsIgnoreCase("1")) {
                this.delete.setVisibility(0);
                this.select_all_delete.setVisibility(8);
                z = true;
            }
        }
        if (z) {
            return;
        }
        this.select_all_delete.setVisibility(0);
        this.delete.setVisibility(8);
    }

    public void visibleSelectButtonPdf(List<PDFDataTable> pdfDataTableList) {
        boolean z = false;
        for (PDFDataTable pDFDataTable : pdfDataTableList) {
            if (pDFDataTable.getIs_selected() != null && pDFDataTable.getIs_selected().equalsIgnoreCase("1")) {
                this.delete.setVisibility(0);
                this.select_all_delete.setVisibility(8);
                z = true;
            }
        }
        if (z) {
            return;
        }
        this.select_all_delete.setVisibility(0);
        this.delete.setVisibility(8);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_my_courses)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setUser_id(MakeMyExam.userId);
        return service.get_my_courses(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        int i;
        apitype.hashCode();
        if (apitype.equals(API.get_my_courses)) {
            if (jsonstring.optString("status").equals("true")) {
                MyCourse myCourse = (MyCourse) new Gson().fromJson(jsonstring.toString(), MyCourse.class);
                if (myCourse.getData().size() > 0) {
                    if (this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_012")) {
                        this.utkashRoom.getapidao().update_api_version("ut_012", MakeMyExam.userId, String.valueOf(jsonstring.optLong("time")), String.valueOf(jsonstring.optLong("interval")), String.valueOf(jsonstring.optLong("cd_time")));
                    } else {
                        APITABLE apitable = new APITABLE();
                        apitable.setApicode("ut_012");
                        apitable.setApiname("get_my_courses");
                        apitable.setInterval(String.valueOf(jsonstring.optLong("interval")));
                        apitable.setUser_id(MakeMyExam.getUserId());
                        apitable.setTimestamp(String.valueOf(jsonstring.optLong("time")));
                        apitable.setCdtimestamp(String.valueOf(jsonstring.optLong("cd_time")));
                        apitable.setVersion("0.000");
                        this.utkashRoom.getapidao().addUser(apitable);
                    }
                    this.utkashRoom.getMyCourseDao().deletedata();
                    if (myCourse.getData().size() > 0) {
                        for (Courselist courselist : myCourse.getData()) {
                            if (!TextUtils.isEmpty(courselist.getBatch_id()) && !courselist.getBatch_id().equalsIgnoreCase("0")) {
                                if (!this.utkashRoom.getMyCourseDao().isRecordExistsUserId(MakeMyExam.userId, "2", courselist.getId())) {
                                    MycourseTable mycourseTable = new MycourseTable();
                                    mycourseTable.setBatch_id(courselist.getBatch_id());
                                    mycourseTable.setBatchtype("2");
                                    mycourseTable.setCover_image(courselist.getCover_image());
                                    mycourseTable.setDescHeaderImage(courselist.getDescHeaderImage());
                                    mycourseTable.setCat_type(courselist.getCat_type());
                                    mycourseTable.setId(courselist.getId());
                                    mycourseTable.setExpiry_date("0");
                                    mycourseTable.setPurchase_date(courselist.getPurchase_date());
                                    mycourseTable.setLastread("" + MakeMyExam.getTime_server());
                                    mycourseTable.setTitle(courselist.getTitle());
                                    mycourseTable.setTxn_id(courselist.getTxn_id());
                                    mycourseTable.setMrp(courselist.getMrp());
                                    mycourseTable.setUserid(MakeMyExam.userId);
                                    mycourseTable.setIs_activated(courselist.getIs_activated());
                                    mycourseTable.setIsExpand(courselist.getCombo_course_ids());
                                    mycourseTable.setCombo_course_ids(courselist.getCombo_course_ids());
                                    mycourseTable.setViewType(courselist.getViewType());
                                    courselist.setPrices(null);
                                    courselist.setExpiry_date("0");
                                    this.utkashRoom.getMyCourseDao().addUser(mycourseTable);
                                }
                            } else if (courselist.getMrp().equalsIgnoreCase("0")) {
                                if (!this.utkashRoom.getMyCourseDao().isRecordExistsUserId(MakeMyExam.userId, "0", courselist.getId())) {
                                    MycourseTable mycourseTable2 = new MycourseTable();
                                    mycourseTable2.setBatch_id("");
                                    mycourseTable2.setBatchtype("0");
                                    mycourseTable2.setCover_image(courselist.getCover_image());
                                    mycourseTable2.setDescHeaderImage(courselist.getDescHeaderImage());
                                    mycourseTable2.setCat_type(courselist.getCat_type());
                                    mycourseTable2.setId(courselist.getId());
                                    mycourseTable2.setExpiry_date(courselist.getExpiry_date());
                                    mycourseTable2.setPurchase_date(courselist.getPurchase_date());
                                    mycourseTable2.setLastread("" + MakeMyExam.getTime_server());
                                    mycourseTable2.setTitle(courselist.getTitle());
                                    mycourseTable2.setTxn_id(courselist.getTxn_id());
                                    mycourseTable2.setMrp(courselist.getMrp());
                                    mycourseTable2.setUserid(MakeMyExam.userId);
                                    mycourseTable2.setIs_activated(courselist.getIs_activated());
                                    mycourseTable2.setCombo_course_ids(courselist.getCombo_course_ids());
                                    mycourseTable2.setViewType(courselist.getViewType());
                                    mycourseTable2.setIsExpand(courselist.getCombo_course_ids());
                                    mycourseTable2.setDelete(1);
                                    if (courselist.getPrices() != null && courselist.getPrices().size() > 0) {
                                        mycourseTable2.setPrices(courselist.getPrices());
                                    }
                                    courselist.setDelete(1);
                                    this.utkashRoom.getMyCourseDao().addUser(mycourseTable2);
                                }
                            } else if (Integer.parseInt(courselist.getMrp()) > 0 && !this.utkashRoom.getMyCourseDao().isRecordExistsUserId(MakeMyExam.userId, "1", courselist.getId())) {
                                MycourseTable mycourseTable3 = new MycourseTable();
                                mycourseTable3.setBatch_id("");
                                mycourseTable3.setBatchtype("1");
                                mycourseTable3.setCover_image(courselist.getCover_image());
                                mycourseTable3.setDescHeaderImage(courselist.getDescHeaderImage());
                                mycourseTable3.setCat_type(courselist.getCat_type());
                                mycourseTable3.setId(courselist.getId());
                                mycourseTable3.setExpiry_date(courselist.getExpiry_date());
                                mycourseTable3.setPurchase_date(courselist.getPurchase_date());
                                mycourseTable3.setLastread("" + MakeMyExam.getTime_server());
                                mycourseTable3.setTitle(courselist.getTitle());
                                mycourseTable3.setTxn_id(courselist.getTxn_id());
                                mycourseTable3.setIs_activated(courselist.getIs_activated());
                                mycourseTable3.setIsExpand(courselist.getCombo_course_ids());
                                mycourseTable3.setCombo_course_ids(courselist.getCombo_course_ids());
                                mycourseTable3.setMrp(courselist.getMrp());
                                mycourseTable3.setViewType(courselist.getViewType());
                                mycourseTable3.setUserid(MakeMyExam.userId);
                                if (courselist.getPrices() != null && courselist.getPrices().size() > 0) {
                                    mycourseTable3.setPrices(courselist.getPrices());
                                }
                                this.utkashRoom.getMyCourseDao().addUser(mycourseTable3);
                            }
                        }
                        List<String> listCourseids = this.utkashRoom.getvideoDownloadao().courseids(MakeMyExam.userId);
                        List<String> listCourseids2 = this.utkashRoom.getuserhistorydao().courseids(MakeMyExam.userId);
                        HashSet hashSet = new HashSet();
                        Iterator<String> it = listCourseids2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (next != null) {
                                String[] strArrSplit = next.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                                if (strArrSplit.length == 2) {
                                    hashSet.add(strArrSplit[1]);
                                } else if (strArrSplit.length > 0) {
                                    hashSet.add(strArrSplit[0]);
                                }
                            }
                        }
                        HashSet hashSet2 = new HashSet();
                        for (String str : listCourseids) {
                            if (str != null) {
                                String[] strArrSplit2 = str.split(MqttTopic.MULTI_LEVEL_WILDCARD);
                                if (strArrSplit2.length == 2) {
                                    hashSet2.add(strArrSplit2[1]);
                                } else if (strArrSplit2.length > 0) {
                                    hashSet2.add(strArrSplit2[0]);
                                }
                            }
                        }
                        HashSet hashSet3 = new HashSet();
                        for (i = 0; i < myCourse.getData().size(); i++) {
                            hashSet3.add(myCourse.getData().get(i).getId());
                            if (myCourse.getData().get(i).getCombo_course_ids() != null && !myCourse.getData().get(i).getCombo_course_ids().equalsIgnoreCase("")) {
                                List listAsList = Arrays.asList(myCourse.getData().get(i).getCombo_course_ids().split(Constants.SEPARATOR_COMMA));
                                if (listAsList.size() > 0) {
                                    hashSet3.addAll(listAsList);
                                }
                            }
                        }
                        ArrayList<String> arrayList = new ArrayList(hashSet2);
                        arrayList.removeAll(hashSet3);
                        ArrayList<String> arrayList2 = new ArrayList(hashSet);
                        arrayList2.removeAll(hashSet3);
                        if (arrayList2.size() > 0) {
                            for (String str2 : arrayList2) {
                                this.utkashRoom.getuserhistorydao().delete(str2 + MqttTopic.MULTI_LEVEL_WILDCARD, MakeMyExam.userId);
                                this.utkashRoom.getuserhistorydao().delete_right(MqttTopic.MULTI_LEVEL_WILDCARD + str2, MakeMyExam.userId);
                            }
                        }
                        if (arrayList.size() > 0) {
                            for (String str3 : arrayList) {
                                List<VideosDownload> list = this.utkashRoom.getvideoDownloadao().getcourse_expire(MqttTopic.MULTI_LEVEL_WILDCARD + str3, MakeMyExam.userId);
                                if (list != null && list.size() > 0) {
                                    for (VideosDownload videosDownload : list) {
                                        File file = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                                        File file2 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADING_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                        this.utkashRoom.getvideoDownloadao().delete(videosDownload.getVideo_id(), videosDownload.getCourse_id(), MakeMyExam.userId);
                                    }
                                }
                                List<VideosDownload> list2 = this.utkashRoom.getvideoDownloadao().getcourse_expire_left(str3 + MqttTopic.MULTI_LEVEL_WILDCARD, MakeMyExam.userId);
                                if (list2 != null && list2.size() > 0) {
                                    for (VideosDownload videosDownload2 : list2) {
                                        File file3 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videosDownload2.getVideo_history() + ".mp4");
                                        File file4 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADING_VIDEOS + videosDownload2.getVideo_history() + ".mp4");
                                        if (file3.exists()) {
                                            file3.delete();
                                        }
                                        if (file4.exists()) {
                                            file4.delete();
                                        }
                                        this.utkashRoom.getvideoDownloadao().delete(videosDownload2.getVideo_id(), videosDownload2.getCourse_id(), MakeMyExam.userId);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (jsonstring.optString("message").equalsIgnoreCase("No Course Found.")) {
                AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$SuccessCallBack$24();
                    }
                });
            }
            int i2 = this.tabPosition;
            if (i2 == 0) {
                getAllVideo();
            } else if (i2 == 1) {
                getAllPdfs();
            } else if (i2 == 2) {
                getAllAudios();
            }
            Helper.dismissProgressDialog();
            logout_user_videos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$24() {
        try {
            for (VideosDownload videosDownload : this.utkashRoom.getvideoDownloadao().getalldownload_videos(MakeMyExam.userId)) {
                File file = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                File file2 = new File(getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADING_VIDEOS + videosDownload.getVideo_history() + ".mp4");
                if (file.exists()) {
                    file.delete();
                }
                if (file2.exists()) {
                    file2.delete();
                }
            }
            this.utkashRoom.getMyCourseDao().deletedata();
            this.utkashRoom.getvideoDownloadao().deletedata();
            runOnUiThread(new Runnable() { // from class: com.appnew.android.Download.DownloadActivity$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$SuccessCallBack$23();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$SuccessCallBack$23() {
        this.download_videos.clear();
        DownloadVideoAdapter downloadVideoAdapter = this.downloadVideoAdapter;
        if (downloadVideoAdapter != null) {
            downloadVideoAdapter.notifydata(this.download_videos);
        }
        this.download_recycler.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
        this.select_all_delete.setVisibility(8);
    }
}
