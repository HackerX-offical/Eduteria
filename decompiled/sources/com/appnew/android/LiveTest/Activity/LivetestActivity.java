package com.appnew.android.LiveTest.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.LiveTest.Fragment.CompletedTest;
import com.appnew.android.LiveTest.Fragment.Ongoing;
import com.appnew.android.LiveTest.Fragment.UpcomingTest;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomViewPager;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodulessc.TestBaseActivitySSCPattern;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class LivetestActivity extends AppCompatActivity implements AmazonCallBack, NetworkCall.MyNetworkCallBack, OnDataSendListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static CustomViewPager view_pager;
    private Context activity;
    private LiveViewPagerAdapter adapter;
    private CompletedTest completedFragment;
    ImageView image_back;
    private Ongoing liveclassesFragment;
    private Timer myTimer;
    NetworkCall networkCall;
    private s3ImageUploading s3IU;
    private TabLayout tabLayout;
    TextView toolbarTitleTV;
    private UpcomingTest upcomingFragment;
    private boolean state = false;
    String str_imgTypeClick = "str_imgTypeClick";
    String ttl = "";
    private String rating = "";
    private String courseId = "";
    private String ratingMessage = "";
    private int rating_type = 0;
    private String live_test_feedback = "";
    final Utils.FeedbackBottomSheetDialog[] feedbackDialog = new Utils.FeedbackBottomSheetDialog[1];
    private boolean isBottomSheetOpen = false;
    public int requestCode = -1;
    private boolean feedbackShown = false;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.appnew.android.LiveTest.Activity.LivetestActivity.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Helper.dismissProgressDialog();
        }
    };
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;
    private ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.LiveTest.Activity.LivetestActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$1((CropImageView.CropResult) obj);
        }
    });
    public ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.LiveTest.Activity.LivetestActivity$$ExternalSyntheticLambda2
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$2((ActivityResult) obj);
        }
    });

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_livetest);
        this.activity = this;
        this.toolbarTitleTV = (TextView) findViewById(R.id.toolbarTitleTV);
        View viewFindViewById = findViewById(R.id.root);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
        initListeners();
        this.networkCall = new NetworkCall(this, this);
        this.live_test_feedback = SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK);
        String stringExtra = getIntent().getStringExtra("title") != null ? getIntent().getStringExtra("title") : "";
        this.ttl = stringExtra;
        if (!stringExtra.isEmpty() && (this.ttl.contains("live") || this.ttl.contains("Live"))) {
            this.toolbarTitleTV.setText(getResources().getString(R.string.live_tests1));
        } else if (!this.ttl.isEmpty() && (this.ttl.contains(TransferTable.COLUMN_SPEED) || this.ttl.contains("Speed"))) {
            this.toolbarTitleTV.setText(getResources().getString(R.string.speed_test));
        }
        try {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
            this.tabLayout = (TabLayout) findViewById(R.id.tabs);
            view_pager = (CustomViewPager) findViewById(R.id.view_pager);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.LiveTest.Activity.LivetestActivity.1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                }
            });
            this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.LiveTest.Activity.LivetestActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$0();
                }
            }));
            this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.appnew.android.LiveTest.Activity.LivetestActivity.2
                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabReselected(TabLayout.Tab tab) {
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabSelected(TabLayout.Tab tab) {
                    int position = tab.getPosition();
                    if (position == 0 && LivetestActivity.this.liveclassesFragment != null) {
                        LivetestActivity.this.liveclassesFragment.refresh_data();
                        return;
                    }
                    if (position == 1 && LivetestActivity.this.upcomingFragment != null) {
                        LivetestActivity.this.upcomingFragment.refresh_data();
                    } else {
                        if (position != 2 || LivetestActivity.this.completedFragment == null) {
                            return;
                        }
                        LivetestActivity.this.completedFragment.refresh_data();
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        setupViewPager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Timer timer = this.myTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void setupViewPager() {
        try {
            this.adapter = new LiveViewPagerAdapter(getSupportFragmentManager());
            Ongoing ongoing = new Ongoing();
            this.liveclassesFragment = ongoing;
            ongoing.updateList(this.state);
            this.adapter.addFragment(this.liveclassesFragment, this.activity.getResources().getString(R.string.live));
            UpcomingTest upcomingTest = new UpcomingTest();
            this.upcomingFragment = upcomingTest;
            upcomingTest.UpcomingListUpdate(this.state);
            this.upcomingFragment.chnagevisiblity(false);
            this.adapter.addFragment(this.upcomingFragment, this.activity.getResources().getString(R.string.upcoming));
            CompletedTest completedTest = new CompletedTest();
            this.completedFragment = completedTest;
            this.adapter.addFragment(completedTest, this.activity.getResources().getString(R.string.completed));
            view_pager.setAdapter(this.adapter);
            this.tabLayout.setupWithViewPager(view_pager);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.state = true;
        if (SharedPreference.getInstance().getBoolean("completed_state") || !this.state) {
            return;
        }
        setupViewPager();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        initListeners();
        if (SharedPreference.getInstance().getBoolean(Const.TEST_RESUME_STATE)) {
            SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, false);
        }
        try {
            if (Constants.REFRESHPAGE.equalsIgnoreCase("true")) {
                if (view_pager.getCurrentItem() == 0) {
                    this.liveclassesFragment.refresh_data();
                } else if (view_pager.getCurrentItem() == 1) {
                    this.upcomingFragment.refresh_data();
                } else if (view_pager.getCurrentItem() == 2) {
                    this.completedFragment.refresh_data();
                }
                Constants.REFRESHPAGE = "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        if (images == null || images.isEmpty()) {
            return;
        }
        SingleStudy.setUserAndAdharImage(images.get(0).getFile());
    }

    @Override // com.appnew.android.LiveClass.interface_.OnDataSendListener
    public void onDataSent(long isLive, String particularId, String attemptOrReAttempt, int testOrVideo) {
        Log.e("TAG_APP", "onDataSent: Livetest activity " + attemptOrReAttempt + " , " + testOrVideo);
        this.courseId = particularId;
        this.rating_type = testOrVideo;
        if (TextUtils.isEmpty(this.live_test_feedback) || !this.live_test_feedback.equalsIgnoreCase("1") || TextUtils.isEmpty(particularId) || TextUtils.isEmpty(attemptOrReAttempt) || !attemptOrReAttempt.equalsIgnoreCase(Const.ATTEMPT)) {
            return;
        }
        openFeedbackBottomSheet();
    }

    public void refreshOnTimerExpiry() {
        Ongoing ongoing = this.liveclassesFragment;
        if (ongoing != null) {
            ongoing.refresh_data();
        }
        UpcomingTest upcomingTest = this.upcomingFragment;
        if (upcomingTest != null) {
            upcomingTest.refresh_data();
        }
        CompletedTest completedTest = this.completedFragment;
        if (completedTest != null) {
            completedTest.refresh_data();
        }
    }

    public void refreshOnTestEnded() {
        Ongoing ongoing = this.liveclassesFragment;
        if (ongoing != null) {
            ongoing.refresh_data();
        }
        CompletedTest completedTest = this.completedFragment;
        if (completedTest != null) {
            completedTest.refresh_data();
        }
    }

    public class LiveViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList;
        private final List<String> mFragmentTitleList;

        public LiveViewPagerAdapter(FragmentManager fm) {
            super(fm);
            this.mFragmentList = new ArrayList();
            this.mFragmentTitleList = new ArrayList();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return this.mFragmentList.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* JADX INFO: renamed from: getCount */
        public int getTotalTabs() {
            return this.mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(title);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return this.mFragmentTitleList.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(CropImageView.CropResult cropResult) {
        if (cropResult.isSuccessful()) {
            String string = SharedPreference.getInstance().getString(this.str_imgTypeClick);
            if (string.equalsIgnoreCase("PhotoCameraRequest")) {
                SharedPreference.getInstance().putString(this.str_imgTypeClick, "");
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), cropResult.getUriContent());
                    String str = getFilesDir() + "/Utkarsh/ProfileImage/";
                    new File(str).mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str + File.separator + (SharedPreference.getInstance().getLoggedInUser().getId() + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this, this, null);
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
            if (string.equalsIgnoreCase("PhotoGalleryRequest")) {
                SharedPreference.getInstance().putString(this.str_imgTypeClick, "");
                try {
                    Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), cropResult.getUriContent());
                    String str2 = getFilesDir() + "/utkarsh/ProfileImage/";
                    new File(str2).mkdirs();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str2 + File.separator + (SharedPreference.getInstance().getLoggedInUser().getId() + "_" + Calendar.getInstance().getTimeInMillis() + ".jpg")));
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this, this, null);
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
    public /* synthetic */ void lambda$new$2(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            int i = this.requestCode;
            if (i == 10000) {
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
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (i == 20000) {
                try {
                    this.cropImage.launch(new CropImageContractOptions(activityResult.getData().getData(), Helper.cropImageOptions(this)));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (fragmentFindFragmentById instanceof SingleStudy) {
                fragmentFindFragmentById.onActivityResult(this.requestCode, activityResult.getResultCode(), activityResult.getData());
            }
            try {
                if (this.requestCode == 1203 && activityResult.getData() != null) {
                    String strCopyFileToInternalStorage = copyFileToInternalStorage(activityResult.getData().getData(), "SubjectiveTestPDF");
                    try {
                        Helper.GoToWebViewPDFActivity(this, Constants.SUB_TEST_ID, strCopyFileToInternalStorage, false, strCopyFileToInternalStorage.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r13.length - 1], Constants.Live_TEST_COURSEID + MqttTopic.MULTI_LEVEL_WILDCARD + Constants.SUB_TEST_ID, true, "CourseActivity", true);
                    } catch (Exception e4) {
                        e = e4;
                        Toast.makeText(this, getResources().getString(R.string.unable_to_upload_this_file), 0).show();
                        e.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
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

    private void openFeedbackBottomSheet() {
        if (this.isBottomSheetOpen) {
            return;
        }
        this.isBottomSheetOpen = true;
        this.feedbackDialog[0] = new Utils.FeedbackBottomSheetDialog(this, new Utils.FeedbackBottomSheetDialog.Listener() { // from class: com.appnew.android.LiveTest.Activity.LivetestActivity.4
            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onClose() {
                LivetestActivity.this.feedbackDialog[0].dismiss();
                LivetestActivity.this.isBottomSheetOpen = false;
            }

            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onSubmit() {
                RatingBar ratingBar = (RatingBar) LivetestActivity.this.feedbackDialog[0].findViewById(R.id.ratingBar);
                EditText editText = (EditText) LivetestActivity.this.feedbackDialog[0].findViewById(R.id.ratingComment);
                LivetestActivity.this.rating = String.valueOf(ratingBar != null ? ratingBar.getRating() : 0.0f);
                LivetestActivity.this.ratingMessage = editText != null ? editText.getText().toString().trim() : "";
                if (ratingBar.getRating() <= 0.0f) {
                    Toast.makeText(LivetestActivity.this, "Please select rating!", 0).show();
                } else {
                    if (LivetestActivity.this.ratingMessage.isEmpty()) {
                        Toast.makeText(LivetestActivity.this, "Please write feedback!", 0).show();
                        return;
                    }
                    LivetestActivity.this.networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", false, false);
                    LivetestActivity.this.feedbackDialog[0].dismiss();
                    LivetestActivity.this.isBottomSheetOpen = false;
                }
            }
        });
        Utils.INSTANCE.bottomSheet(new Utils.FeedbackBottomSheetDialog[]{this.feedbackDialog[0]});
        this.feedbackDialog[0].show();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.POST_COURSE_REVIEW)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.courseId);
        encryptionData.setRating(this.rating);
        encryptionData.setMessage(this.ratingMessage);
        encryptionData.setRating_type(Integer.valueOf(this.rating_type));
        return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.POST_COURSE_REVIEW)) {
            Utils.INSTANCE.showGreetingDialog(this, "Thank’s for your valuable feedback !");
        }
    }

    private void initListeners() {
        QuizActivity.setOnDataSendListener(this);
        TestBaseActivity.setOnDataSendListener(this);
        TestBaseActivitySSCPattern.setOnDataSendListener(this);
    }
}
