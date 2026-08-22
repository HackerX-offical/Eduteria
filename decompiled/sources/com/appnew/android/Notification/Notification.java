package com.appnew.android.Notification;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.Model.NotificationModel.Datum;
import com.appnew.android.Model.NotificationModel.NotificationdataModel;
import com.appnew.android.Model.Video;
import com.appnew.android.Notification.Adapter.NotificationAdapter;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.player.LiveStreamingYoutube;
import com.appnew.android.player.Liveawsactivity;
import com.appnew.android.player.VODPlayerActivity;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodulessc.TestBaseActivitySSCPattern;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class Notification extends AppCompatActivity implements NetworkCall.MyNetworkCallBack, OnDataSendListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static long server_time;
    private Activity activity;
    Button backBtn;
    ImageView image_back;
    TextView markasread;
    private NestedScrollView nestedScrollView;
    private NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    NotificationAdapter notificationAdapter;
    NotificationdataModel notificationdata;
    List<Datum> notificationlist;
    private RecyclerView notificationrecyceler;
    ProgressBar paginationLoader;
    private SwipeRefreshLayout pullToReferesh;
    boolean status;
    public Video video;
    private int mPage = 1;
    private boolean loading = false;
    private boolean isPaginationAvailable = true;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;
    private String rating = "";
    private String courseId = "";
    private String ratingMessage = "";
    private int rating_type = 0;
    private String live_class_feedback = "";
    private String live_test_feedback = "";
    final Utils.FeedbackBottomSheetDialog[] feedbackDialog = new Utils.FeedbackBottomSheetDialog[1];
    private boolean isBottomSheetOpen = false;
    ItemTouchHelper.SimpleCallback itemtouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, 12) { // from class: com.appnew.android.Notification.Notification.3
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition >= 0 && absoluteAdapterPosition < Notification.this.notificationlist.size()) {
                Notification.this.notificationAdapter.selectedpositionid = Notification.this.notificationlist.get(absoluteAdapterPosition).getId();
                Notification.this.notificationAdapter.selectedposition = absoluteAdapterPosition;
                Notification.this.notificationAdapter.delete_notification_api();
                return;
            }
            Notification.this.notificationAdapter.notifyDataSetChanged();
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_notification);
        this.activity = this;
        initListener();
        this.live_class_feedback = SharedPreference.getInstance().getString(Const.LIVE_CLASS_FEEDBACK);
        this.live_test_feedback = SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK);
        Log.e("TAG_APP", "onCreate: Notification");
        if (this.notificationlist == null) {
            this.notificationlist = new ArrayList();
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.notification);
        this.notificationrecyceler = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.notificationrecyceler.setNestedScrollingEnabled(false);
        this.pullToReferesh = (SwipeRefreshLayout) findViewById(R.id.pullto_referesh);
        this.nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        this.markasread = (TextView) findViewById(R.id.markasread);
        this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
        this.backBtn = (Button) findViewById(R.id.backBtn);
        this.paginationLoader = (ProgressBar) findViewById(R.id.progressBar);
        View viewFindViewById = findViewById(R.id.root);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
        this.markasread.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Notification.Notification$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Notification.Notification$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$1();
            }
        }));
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Notification.Notification$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$2();
            }
        }));
        this.networkCall = new NetworkCall(this, this);
        if (this.notificationlist.size() == 0) {
            hit_api_for_notificationdata(true);
        } else {
            this.no_data_found_RL.setVisibility(8);
            this.notificationrecyceler.setVisibility(0);
            NotificationAdapter notificationAdapter = new NotificationAdapter(this, this.notificationlist);
            this.notificationAdapter = notificationAdapter;
            this.notificationrecyceler.setAdapter(notificationAdapter);
            this.notificationAdapter.setNestedScrollView(this.nestedScrollView);
        }
        this.pullToReferesh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.appnew.android.Notification.Notification.1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                Notification.this.initialState();
                Notification.this.status = false;
                Notification.this.hit_api_for_notificationdata(true);
                Notification.this.pullToReferesh.setRefreshing(false);
                Notification.this.getStudentClass();
            }
        });
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.Notification.Notification.2
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (v.getChildAt(v.getChildCount() - 1) == null || scrollY < v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight() || scrollY <= oldScrollY || !Notification.this.loading || !Notification.this.isPaginationAvailable) {
                    return;
                }
                Notification.this.paginationLoader.setVisibility(0);
                Notification.this.mPage++;
                Notification.this.status = true;
                Notification.this.hit_api_for_notificationdata(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        hit_api_for_all_read();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2() {
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStudentClass() {
        SharedPreference.getInstance().remove("Student_List");
        if (BuildConfig.FLAVOR.equalsIgnoreCase("Narayana")) {
            if (SharedPreference.getInstance().getString("Student_List") == null || SharedPreference.getInstance().getString("Student_List").equalsIgnoreCase("")) {
                this.networkCall.NetworkAPICall(API.API_STUDENT_CLASS, "", false, false);
            }
        }
    }

    private void hit_api_for_all_read() {
        this.networkCall.NetworkAPICall(API.mark_as_allread, "", true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_for_notificationdata(boolean showProgress) {
        this.networkCall.NetworkAPICall(API.get_notification_data, "", showProgress, false);
    }

    public void initialState() {
        this.mPage = 1;
        this.loading = true;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/course/post_course_review":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setCourse_id(this.courseId);
                encryptionData.setRating(this.rating);
                encryptionData.setMessage(this.ratingMessage);
                encryptionData.setRating_type(Integer.valueOf(this.rating_type));
                return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData)));
            case "data_model/users/student_class":
                return service.getStudentClass();
            case "https://appapi.videocrypt.in/index.php/data_model/notification/get_notifications":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setPage("" + this.mPage);
                return service.getNotification(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/notification/set_all_read":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setPage("" + this.mPage);
                return service.MarkAllRead(AES.encrypt(new Gson().toJson(encryptionData3)));
            default:
                return null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Notification notification;
        Exception e2;
        NotificationAdapter notificationAdapter;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1203 && resultCode == -1 && data != null) {
            try {
                String strCopyFileToInternalStorage = copyFileToInternalStorage(data.getData(), "SubjectiveTestPDF");
                notification = this;
                try {
                    Helper.GoToPDFScreenActivity(notification, Constants.SUB_TEST_ID, strCopyFileToInternalStorage, false, strCopyFileToInternalStorage.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r10.length - 1], this.video.getPayloadData().getCourse_id() + MqttTopic.MULTI_LEVEL_WILDCARD + Constants.SUB_TEST_ID, true);
                } catch (Exception e3) {
                    e2 = e3;
                    Toast.makeText(this, R.string.unable_to_upload_this_file, 0).show();
                    e2.printStackTrace();
                    return;
                }
            } catch (Exception e4) {
                e2 = e4;
                Toast.makeText(this, R.string.unable_to_upload_this_file, 0).show();
                e2.printStackTrace();
                return;
            }
        } else {
            notification = this;
        }
        if (requestCode != 100011 || data == null || !data.getStringExtra(Const.FromPdfScreen).equalsIgnoreCase("SubjectiveTest") || (notificationAdapter = notification.notificationAdapter) == null) {
            return;
        }
        notificationAdapter.hit_api_for_iniializetest();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -2088930306:
                if (apitype.equals(API.POST_COURSE_REVIEW)) {
                    b2 = 0;
                }
                break;
            case 662399602:
                if (apitype.equals(API.API_STUDENT_CLASS)) {
                    b2 = 1;
                }
                break;
            case 732420302:
                if (apitype.equals(API.get_notification_data)) {
                    b2 = 2;
                }
                break;
            case 1585683010:
                if (apitype.equals(API.mark_as_allread)) {
                    b2 = 3;
                }
                break;
        }
        switch (b2) {
            case 0:
                Utils.INSTANCE.showGreetingDialog(this, "Thank’s for your valuable feedback !");
                break;
            case 1:
                if (jsonstring.optString("status").equals("true")) {
                    SharedPreference.getInstance().putString("Student_List", jsonstring.toString());
                }
                break;
            case 2:
                try {
                    if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                        server_time = jsonstring.optLong("time") * 1000;
                        this.isPaginationAvailable = true;
                        if (this.status) {
                            NotificationdataModel notificationdataModel = (NotificationdataModel) new Gson().fromJson(jsonstring.toString(), NotificationdataModel.class);
                            this.notificationdata = notificationdataModel;
                            if (notificationdataModel.getData() != null) {
                                int size = this.notificationdata.getData().size();
                                if (this.notificationdata.getData().size() > 0) {
                                    this.notificationlist.addAll(this.notificationdata.getData());
                                    this.notificationAdapter.notifyItemRangeInserted(this.notificationlist.size(), this.notificationlist.size() - size);
                                }
                            } else {
                                Toast.makeText(this, this.activity.getResources().getString(R.string.data_not_found), 0).show();
                            }
                        } else {
                            initialState();
                            List<Datum> list = this.notificationlist;
                            if (list != null && list.size() != 0) {
                                this.notificationlist.clear();
                            }
                            NotificationdataModel notificationdataModel2 = (NotificationdataModel) new Gson().fromJson(jsonstring.toString(), NotificationdataModel.class);
                            this.notificationdata = notificationdataModel2;
                            if (notificationdataModel2.getData() != null) {
                                this.notificationlist.addAll(this.notificationdata.getData());
                                if (this.notificationlist.size() > 0) {
                                    this.no_data_found_RL.setVisibility(8);
                                    this.notificationrecyceler.setVisibility(0);
                                    this.notificationAdapter = new NotificationAdapter(this, this.notificationlist);
                                    new ItemTouchHelper(this.itemtouchHelperCallback).attachToRecyclerView(this.notificationrecyceler);
                                    this.notificationrecyceler.setAdapter(this.notificationAdapter);
                                    this.notificationAdapter.setNestedScrollView(this.nestedScrollView);
                                    this.notificationAdapter.notifyDataSetChanged();
                                } else {
                                    this.no_data_found_RL.setVisibility(0);
                                    this.notificationrecyceler.setVisibility(8);
                                }
                            } else {
                                this.no_data_found_RL.setVisibility(0);
                                this.notificationrecyceler.setVisibility(8);
                            }
                        }
                        ProgressBar progressBar = this.paginationLoader;
                        if (progressBar != null && progressBar.isShown()) {
                            this.paginationLoader.setVisibility(8);
                            break;
                        }
                    } else {
                        if (!this.status) {
                            this.no_data_found_RL.setVisibility(0);
                            this.notificationrecyceler.setVisibility(8);
                        }
                        this.isPaginationAvailable = false;
                        ProgressBar progressBar2 = this.paginationLoader;
                        if (progressBar2 != null && progressBar2.isShown()) {
                            this.paginationLoader.setVisibility(8);
                        }
                        RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                        break;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 3:
                try {
                    if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                        for (int i = 0; i < this.notificationlist.size(); i++) {
                            this.notificationlist.get(i).setViewState("1");
                        }
                        this.notificationAdapter.notifyDataSetChanged();
                        SharedPreference.getInstance().putInt(Const.NOTIFICATION_COUNT, 0);
                        ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
                    } else {
                        RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        ProgressBar progressBar;
        apitype.hashCode();
        if (apitype.equals(API.get_notification_data) && (progressBar = this.paginationLoader) != null && progressBar.isShown()) {
            this.paginationLoader.setVisibility(8);
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

    @Override // com.appnew.android.LiveClass.interface_.OnDataSendListener
    public void onDataSent(long isLive, String particularId, String attemptOrReAttempt, int ratingType) {
        this.courseId = particularId;
        this.rating_type = ratingType;
        if ((TextUtils.isEmpty(this.live_class_feedback) || !this.live_class_feedback.equalsIgnoreCase("1")) && (TextUtils.isEmpty(this.live_test_feedback) || !this.live_test_feedback.equalsIgnoreCase("1") || TextUtils.isEmpty(attemptOrReAttempt) || !attemptOrReAttempt.equalsIgnoreCase(Const.ATTEMPT))) {
            return;
        }
        openFeedbackBottomSheet();
    }

    private void openFeedbackBottomSheet() {
        if (this.isBottomSheetOpen) {
            return;
        }
        this.isBottomSheetOpen = true;
        this.feedbackDialog[0] = new Utils.FeedbackBottomSheetDialog(this, new Utils.FeedbackBottomSheetDialog.Listener() { // from class: com.appnew.android.Notification.Notification.4
            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onClose() {
                Notification.this.feedbackDialog[0].dismiss();
                Notification.this.isBottomSheetOpen = false;
            }

            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onSubmit() {
                RatingBar ratingBar = (RatingBar) Notification.this.feedbackDialog[0].findViewById(R.id.ratingBar);
                EditText editText = (EditText) Notification.this.feedbackDialog[0].findViewById(R.id.ratingComment);
                Notification.this.rating = String.valueOf(ratingBar != null ? ratingBar.getRating() : 0.0f);
                Notification.this.ratingMessage = editText != null ? editText.getText().toString().trim() : "";
                if (ratingBar.getRating() <= 0.0f) {
                    Toast.makeText(Notification.this, "Please select rating!", 0).show();
                } else {
                    if (Notification.this.ratingMessage.isEmpty()) {
                        Toast.makeText(Notification.this, "Please write feedback!", 0).show();
                        return;
                    }
                    Notification.this.networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", false, false);
                    Notification.this.feedbackDialog[0].dismiss();
                    Notification.this.isBottomSheetOpen = false;
                }
            }
        });
        Utils.INSTANCE.bottomSheet(new Utils.FeedbackBottomSheetDialog[]{this.feedbackDialog[0]});
        this.feedbackDialog[0].show();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        initListener();
    }

    private void initListener() {
        VODPlayerActivity.setOnDataSendListener(this);
        Liveawsactivity.setOnDataSendListener(this);
        LiveStreamingYoutube.setOnDataSendListener(this);
        QuizActivity.setOnDataSendListener(this);
        TestBaseActivity.setOnDataSendListener(this);
        TestBaseActivitySSCPattern.setOnDataSendListener(this);
    }
}
