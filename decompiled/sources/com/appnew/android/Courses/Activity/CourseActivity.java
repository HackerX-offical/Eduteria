package com.appnew.android.Courses.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.Courses.Fragment.CommonFragForList;
import com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7;
import com.appnew.android.Courses.Fragment.DirectLayer3;
import com.appnew.android.Courses.Fragment.ExamPrepLayer1;
import com.appnew.android.Courses.Fragment.ExamPrepLayer2;
import com.appnew.android.Courses.Fragment.ShowAllClassesFragment;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.Fragment.SingleStudy2;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.LiveClass.interface_.OnDataSendListener;
import com.appnew.android.Login.Fragment.CommonWebViewFragment;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.Course;
import com.appnew.android.Model.Courses.CourseCategory;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.Courses.Reviews;
import com.appnew.android.Model.Courses.SingleCourseData;
import com.appnew.android.Model.Courses.SinglestudyModel;
import com.appnew.android.Model.MediaFile;
import com.appnew.android.Model.Video;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.AmazonUpload.AmazonCallBack;
import com.appnew.android.Utils.AmazonUpload.s3ImageUploading;
import com.appnew.android.Utils.AppPermissionsRunTime;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.home.Activity.BaseABNoNavActivity;
import com.appnew.android.player.LiveStreamingYoutube;
import com.appnew.android.player.Liveawsactivity;
import com.appnew.android.player.VODPlayerActivity;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.fragment.RankFragement;
import com.appnew.android.testmodule.model.SubjectiveResultData;
import com.appnew.android.testmodulessc.TestBaseActivitySSCPattern;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageView;
import com.eduteria.app.app.R;
import com.google.common.base.Ascii;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CourseActivity extends BaseABNoNavActivity implements AmazonCallBack, OnDataSendListener, NetworkCall.MyNetworkCallBack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static CourseActivity instance = null;
    public static boolean wantToRefresh = false;
    public String contentType;
    Course course;
    CourseCategory courseCategory;
    CourseDetailData courseDetailData;
    public Courselist courselist;
    CourseDetail cousedetail;
    public ExamPrepItem examPrepItem;
    public boolean isPurchased;
    public String issearchnable;
    public Lists listSubject;
    public Lists lists;
    private int masterTilePos;
    private List<TilesItem> masterTiles;
    public ArrayList<AppPermissionsRunTime.MyPermissionConstants> myPermissionConstantsArrayList;
    NetworkCall networkCall;
    int position;
    String revertAPI;
    Reviews[] reviews;
    private s3ImageUploading s3IU;
    SingleCourseData singleCourseData;
    private ArrayList<SinglestudyModel> singleStudy;
    public CourseDetail singlestudyModel;
    public SubjectiveResultData subjectiveResultData;
    String tileIdAPI;
    String tileTypeAPI;
    public String title;
    public String total;
    ArrayList<Video> videoArrayList;
    public final int REQUEST_CODE_PERMISSION_MULTIPLE = 123;
    public final int REQUEST_CODE_MULTIPLE_PIKER = 1203;
    public boolean testThird = false;
    public int isrelated = 0;
    public String unit_id = "";
    public String chapter_id = "";
    public String topic_id = "";
    public String subtopic_id = "";
    public int positionOfTest = -1;
    public String singleStudyAdapterItemPosition = "";
    public String mainCourseId = "";
    public String valid_to = "";
    public boolean isCombo = false;
    public boolean share_type = false;
    public boolean is_coupon = false;
    public String pos_txn_id = "";
    public String courseName = "";
    public String course_name = "";
    public boolean isMoved = false;
    public int requestCode = -1;
    final Utils.FeedbackBottomSheetDialog[] feedbackDialog = new Utils.FeedbackBottomSheetDialog[1];
    private boolean isBottomSheetOpen = false;
    String skip_unit = "";
    boolean payment_done = false;
    String skip_chapter = "";
    String image = "";
    String parentCourseId = "";
    String allsubcatindex_id = "";
    boolean isFromDashBoard8 = false;
    String isContentCombo = "";
    String tabTileVisibility = "";
    String str_imgTypeClick = "str_imgTypeClick";
    private String frag_type = "";
    private String emi_type = "";
    private String path = "";
    private String strUrl = "";
    private String searchQuery = "";
    private String serarch_title = "";
    private String batch_id = "";
    private String comboid = "";
    private String content_type = "";
    public String content_master = "";
    private String rating = "";
    private String courseId = "";
    private String ratingMessage = "";
    public int rating_type = 0;
    private String live_class_feedback = "";
    private String live_test_feedback = "";
    public int stopValidationOnCoupon = 0;
    public boolean stopAnimationOnBackPress = false;
    Boolean isCourseCombo = false;
    String linkType = "";
    private ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), new ActivityResultCallback() { // from class: com.appnew.android.Courses.Activity.CourseActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$1((CropImageView.CropResult) obj);
        }
    });
    public ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.appnew.android.Courses.Activity.CourseActivity$$ExternalSyntheticLambda2
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$2((ActivityResult) obj);
        }
    });

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected boolean addBackButton() {
        return true;
    }

    public void recallData() {
    }

    public static CourseActivity getInstance() {
        return instance;
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected void initViews() {
        instance = this;
        if (getIntent().getExtras() != null) {
            this.isCombo = getIntent().getExtras().getBoolean(Const.IS_COMBO);
            this.is_coupon = getIntent().getExtras().getBoolean(Const.is_coupon);
            this.mainCourseId = getIntent().getExtras().getString(Const.COURSE_ID_MAIN);
            this.valid_to = getIntent().getExtras().getString("valid_to");
            this.course_name = getIntent().getExtras().getString(AnalyticsConstants.course_name);
            String string = getIntent().getExtras().getString(Const.COMBO_ID);
            this.comboid = string;
            if (string != null && string.equalsIgnoreCase(Constants.NULL_VERSION_ID)) {
                this.comboid = null;
            }
            String str = this.course_name;
            if (str == null) {
                str = "Details";
            }
            this.courseName = str;
            this.issearchnable = getIntent().getStringExtra("searchenable");
            if (getIntent().hasExtra(Const.CONTENT_TYPE_1)) {
                this.content_type = getIntent().getExtras().getString(Const.CONTENT_TYPE_1);
            }
            if (getIntent().hasExtra(Const.CONTENT_MASTER)) {
                this.content_master = getIntent().getExtras().getString(Const.CONTENT_MASTER);
            }
            if (getIntent().hasExtra("masterPosition")) {
                this.masterTilePos = getIntent().getExtras().getInt("masterPosition");
            }
            try {
                this.masterTiles = (List) getIntent().getExtras().getSerializable("masterTileItem");
                this.cousedetail = (CourseDetail) getIntent().getExtras().getSerializable("cousedetail");
            } catch (Exception unused) {
            }
            String string2 = getIntent().getExtras().getString(Const.COURSE_PARENT_ID);
            this.parentCourseId = string2;
            if (string2 != null && string2.equalsIgnoreCase("")) {
                this.parentCourseId = SharedPreference.getInstance().getString("parentcourseid");
                SharedPreference.getInstance().putString("parentcourseid", null);
            }
            this.frag_type = getIntent().getExtras().getString(Const.FRAG_TYPE);
            if (getIntent().hasExtra("isFromDashBoard8")) {
                this.isFromDashBoard8 = true;
            }
            if (getIntent().hasExtra(Const.BATCH_ID)) {
                this.batch_id = getIntent().getStringExtra(Const.BATCH_ID);
            }
            this.emi_type = getIntent().getExtras().getString(Const.EMI_TYPE);
            this.searchQuery = getIntent().getExtras().getString(Const.SEARCH_QUERY);
            this.skip_unit = getIntent().getExtras().getString(Const.SKIP_UNIT);
            if (getIntent().hasExtra(Const.PAYMENT_DONE)) {
                this.payment_done = getIntent().getExtras().getInt(Const.PAYMENT_DONE, 0) == 1;
            } else {
                this.payment_done = false;
            }
            this.skip_chapter = getIntent().getExtras().getString(Const.SKIP_CHAPTER);
            this.listSubject = (Lists) getIntent().getExtras().getSerializable(Const.LIST_SUBJECT);
            if (getIntent().hasExtra(Const.ISMOVED)) {
                this.isMoved = true;
            } else {
                this.isMoved = false;
            }
            this.image = getIntent().getExtras().getString("image");
            this.serarch_title = getIntent().getExtras().getString("serach_title");
            this.type = getIntent().getExtras().getString("type");
            this.courseCategory = (CourseCategory) getIntent().getExtras().getSerializable(Const.COURSE_CATEGORY);
            this.course = (Course) getIntent().getExtras().getSerializable(Const.COURSES);
            this.courseDetailData = (CourseDetailData) getIntent().getExtras().getSerializable("courseDetailData");
            this.testThird = getIntent().getExtras().getBoolean(Const.TEST_THIRD);
            this.contentType = getIntent().getExtras().getString("content_type");
            this.courselist = (Courselist) getIntent().getExtras().getSerializable(Const.COURSESLIST);
            this.singleCourseData = (SingleCourseData) getIntent().getExtras().getSerializable(Const.COURSE_DES);
            this.singleStudy = (ArrayList) getIntent().getExtras().getSerializable(Const.SINGLE_STUDY);
            this.reviews = (Reviews[]) getIntent().getExtras().getSerializable(Const.REVIEWS);
            this.title = getIntent().getExtras().getString("title");
            this.subjectiveResultData = (SubjectiveResultData) getIntent().getExtras().getSerializable(Const.RANK);
            this.path = getIntent().getExtras().getString("path");
            this.unit_id = getIntent().getExtras().getString(Const.UNIT_ID);
            this.chapter_id = getIntent().getExtras().getString(Const.CHAPTER_ID);
            this.topic_id = getIntent().getExtras().getString(Const.TOPIC_ID);
            this.subtopic_id = getIntent().getExtras().getString(Const.SUBTOPIC_ID);
            this.position = getIntent().getExtras().getInt(Const.POSITION);
            this.strUrl = getIntent().getExtras().getString(Const.PRIVACYURL);
            this.tileIdAPI = getIntent().getExtras().getString("tile_id");
            this.tileTypeAPI = getIntent().getExtras().getString(Const.TILE_TYPE);
            this.isContentCombo = getIntent().getExtras().getString(Const.IS_CONTENT_COMBO) != null ? getIntent().getExtras().getString(Const.IS_CONTENT_COMBO) : "1";
            this.tabTileVisibility = getIntent().getExtras().getString(Const.TAB_TILE_VISIBILITY) != null ? getIntent().getExtras().getString(Const.TAB_TILE_VISIBILITY) : "1";
            this.revertAPI = getIntent().getExtras().getString(Const.REVERT_API);
            this.allsubcatindex_id = getIntent().getExtras().getString(Const.SUB_CAT);
            this.isCourseCombo = Boolean.valueOf(getIntent().getExtras().getBoolean(Const.IS_COURSE_COMBO));
            this.linkType = getIntent().getExtras().getString(Const.LINK_TYPE);
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SINGLE_STUDY_DATA))) {
                this.singlestudyModel = (CourseDetail) new Gson().fromJson(SharedPreference.getInstance().getString(Const.SINGLE_STUDY_DATA), CourseDetail.class);
            } else {
                this.singlestudyModel = new CourseDetail();
            }
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.EXAMPREP))) {
                this.examPrepItem = (ExamPrepItem) new Gson().fromJson(SharedPreference.getInstance().getString(Const.EXAMPREP), ExamPrepItem.class);
            } else {
                this.examPrepItem = new ExamPrepItem();
            }
            if (!TextUtils.isEmpty(SharedPreference.getInstance().getString("list"))) {
                this.lists = (Lists) new Gson().fromJson(SharedPreference.getInstance().getString("list"), Lists.class);
            } else {
                this.lists = new Lists();
            }
        }
        pushEvent();
        if (this.frag_type.equals(Const.SEEALL_COURSE) || this.frag_type.equals(Const.ALLCOURSES) || this.frag_type.equals(Const.EXAMPREPLAST) || this.frag_type.equals(Const.DIRECTLAYER3) || this.frag_type.equals(Const.SINGLE_STUDY2) || this.frag_type.equals(Const.EXAMPREP)) {
            this.searchView.setVisibility(0);
        } else {
            this.searchView.setVisibility(8);
        }
        String str2 = this.contentType;
        if (str2 != null || !TextUtils.isEmpty(str2)) {
            this.total = getIntent().getExtras().getString(Const.TEST_TYPE);
        }
        if ("1".equalsIgnoreCase("7")) {
            this.iv_whatsapp.setVisibility(8);
        } else {
            this.iv_whatsapp.setVisibility(8);
        }
    }

    private void initFeedback() {
        VODPlayerActivity.setOnDataSendListener(this);
        Liveawsactivity.setOnDataSendListener(this);
        LiveStreamingYoutube.setOnDataSendListener(this);
        QuizActivity.setOnDataSendListener(this);
        TestBaseActivity.setOnDataSendListener(this);
        TestBaseActivitySSCPattern.setOnDataSendListener(this);
        this.networkCall = new NetworkCall(this, this);
        this.live_class_feedback = SharedPreference.getInstance().getString(Const.LIVE_CLASS_FEEDBACK);
        this.live_test_feedback = SharedPreference.getInstance().getString(Const.LIVE_TEST_FEEDBACK);
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

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected Fragment getFragment() {
        Log.e("TAG_APP", "getFragment: " + this.frag_type);
        String str = this.frag_type;
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -2144493806:
                if (str.equals(Const.SINGLE_STUDY)) {
                    b2 = 0;
                }
                break;
            case -2054798496:
                if (str.equals(Const.SINGLE_STUDY2)) {
                    b2 = 1;
                }
                break;
            case -1180887788:
                if (str.equals(Const.MYCART)) {
                    b2 = 2;
                }
                break;
            case -1072108485:
                if (str.equals(Const.COURSE_DETAILS_FOR_THEME7)) {
                    b2 = 3;
                }
                break;
            case -975993222:
                if (str.equals(Const.DIRECTLAYER3)) {
                    b2 = 4;
                }
                break;
            case -368409615:
                if (str.equals(Const.SEEALL_COURSE)) {
                    b2 = 5;
                }
                break;
            case 101142:
                if (str.equals(Const.FAQ)) {
                    b2 = 6;
                }
                break;
            case 2507820:
                if (str.equals(Const.RANK)) {
                    b2 = 7;
                }
                break;
            case 40060921:
                if (str.equals(Const.ALLCOURSES)) {
                    b2 = 8;
                }
                break;
            case 652662084:
                if (str.equals(Const.MYCOURSES)) {
                    b2 = 9;
                }
                break;
            case 793418437:
                if (str.equals(Const.MYEMICOURSES)) {
                    b2 = 10;
                }
                break;
            case 806592302:
                if (str.equals(Const.LEADERBOARD)) {
                    b2 = 11;
                }
                break;
            case 926873033:
                if (str.equals(Const.PRIVACY_POLICY)) {
                    b2 = 12;
                }
                break;
            case 956399458:
                if (str.equals(Const.EXAMPREPLAST)) {
                    b2 = 13;
                }
                break;
            case 1005734546:
                if (str.equals(Const.SEARCH_COURSE)) {
                    b2 = 14;
                }
                break;
            case 1255389400:
                if (str.equals(Const.SHOW_ALL_COURSES)) {
                    b2 = Ascii.SI;
                }
                break;
            case 1937584844:
                if (str.equals(Const.EXAMPREP)) {
                    b2 = 16;
                }
                break;
        }
        switch (b2) {
            case 0:
                if (this.isMoved) {
                    moveFromPayment();
                }
                setToolbarTitle(this.courseName);
                com.appnew.android.home.Constants.REMAININGTIME = "";
                if (this.content_master.equalsIgnoreCase("content_master002")) {
                    return SingleStudy.newInstance1(this.mainCourseId, this.isCombo, this.parentCourseId, this.courseName, this.valid_to, this.comboid, this.content_type, this.issearchnable, this.masterTiles, this.masterTilePos, this.content_master, this.cousedetail);
                }
                return SingleStudy.newInstance(this.mainCourseId, this.isCombo, this.parentCourseId, this.courseName, this.valid_to, this.comboid, this.content_type, this.issearchnable, this.isCourseCombo.booleanValue(), this.linkType);
            case 1:
                if (this.isMoved) {
                    moveFromPayment();
                }
                setToolbarTitle(this.courseName);
                return SingleStudy2.newInstance(this.mainCourseId, this.isCombo, this.parentCourseId, this.courseName, this.valid_to, this.tileIdAPI, this.isContentCombo);
            case 2:
            case 8:
                setToolbarTitle(getResources().getString(R.string.mycart));
                return CommonFragForList.newInstance(this.frag_type);
            case 3:
                if (this.isMoved) {
                    moveFromPayment();
                }
                setToolbarTitle(this.courseName);
                if (this.isFromDashBoard8) {
                    return CourseDetailsFragmentTheme7.newInstance(this.courselist, this.mainCourseId, this.parentCourseId, this.title, this.batch_id);
                }
                return CourseDetailsFragmentTheme7.newInstance(this.courselist, this.mainCourseId, this.parentCourseId);
            case 4:
                return DirectLayer3.newInstance(this.mainCourseId, this.isCombo, this.parentCourseId, this.courseName, this.valid_to, this.allsubcatindex_id);
            case 5:
                return CommonFragForList.newInstance(this.frag_type, this.courseCategory);
            case 6:
                setToolbarTitle(getResources().getString(R.string.faq_title));
                return CommonFragForList.newInstance(this.frag_type, this.course);
            case 7:
                setToolbarTitle(getResources().getString(R.string.RANK));
                return RankFragement.newInstance(this.subjectiveResultData);
            case 9:
                setToolbarTitle(getResources().getString(R.string.mycourse));
                return CommonFragForList.newInstance(this.frag_type, this.courseCategory);
            case 10:
                setToolbarTitle(getResources().getString(R.string.mycourse));
                return CommonFragForList.newInstance(this.frag_type, this.mainCourseId);
            case 11:
                setToolbarTitle(Const.LEADERBOARD);
                return CommonFragForList.newInstance(this.frag_type, this.courseCategory);
            case 12:
                setToolbarTitle(getResources().getString(R.string.privacy_policy));
                return CommonWebViewFragment.newInstance(this.strUrl, true);
            case 13:
                return ExamPrepLayer2.newInstance(this.examPrepItem, this.lists, this.listSubject, this.contentType, this.title, this.total, this.singlestudyModel, this.isCombo, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, this.serarch_title, this.tabTileVisibility);
            case 14:
                setToolbarTitle(getResources().getString(R.string.course));
                return CommonFragForList.newInstance(this.frag_type, this.courseCategory, this.searchQuery);
            case 15:
                if (this.isMoved) {
                    moveFromPayment();
                }
                setToolbarTitle(this.courseName);
                return ShowAllClassesFragment.newInstance(this.mainCourseId, this.isCombo, this.parentCourseId, this.courseName, this.valid_to);
            case 16:
                return ExamPrepLayer1.newInstance(this.examPrepItem, this.lists, this.contentType, this.title, this.singlestudyModel, this.isCombo, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, this.tabTileVisibility);
            default:
                return null;
        }
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        initListeners();
        initFeedback();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }

    @Override // com.appnew.android.Utils.AmazonUpload.AmazonCallBack
    public void onS3UploadData(ArrayList<MediaFile> images) {
        if (images == null || images.isEmpty()) {
            return;
        }
        SingleStudy.setUserAndAdharImage(images.get(0).getFile());
    }

    public void checkStoragePermission(final int type) {
        Dexter.withContext(this).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Courses.Activity.CourseActivity.1
            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (type == 1) {
                    CourseActivity.this.imgClick(new CharSequence[]{"Take Photo", "Cancel"});
                } else {
                    CourseActivity.this.imgClick(new CharSequence[]{"Take Photo", "Choose from Gallery", "Cancel"});
                }
            }

            @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imgClick(final CharSequence[] options) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.add_photo));
        builder.setItems(options, new DialogInterface.OnClickListener() { // from class: com.appnew.android.Courses.Activity.CourseActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$imgClick$0(options, dialogInterface, i);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$imgClick$0(CharSequence[] charSequenceArr, DialogInterface dialogInterface, int i) {
        if (charSequenceArr[i].equals("Take Photo")) {
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uriForFile = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_image.jpg"));
                SharedPreference.getInstance().putString(this.str_imgTypeClick, "PhotoCameraRequest");
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
            Uri uriForFile2 = FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp_gallery.jpg"));
            SharedPreference.getInstance().putString(this.str_imgTypeClick, "PhotoGalleryRequest");
            intent2.putExtra("output", uriForFile2);
            this.someActivityResultLauncher.launch(intent2);
            this.requestCode = 20000;
            return;
        }
        if (charSequenceArr[i].equals("Cancel")) {
            dialogInterface.dismiss();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.payment_done) {
            if (!"1".equalsIgnoreCase("1")) {
                if (!"1".equalsIgnoreCase("6")) {
                    if (!"1".equalsIgnoreCase("2")) {
                        if ("1".equalsIgnoreCase("5")) {
                            startActivity(new Intent(this, (Class<?>) DashboardActivityTheme5.class).setFlags(268468224));
                            return;
                        }
                        return;
                    }
                    startActivity(new Intent(this, (Class<?>) DashboardActivityTheme2.class).setFlags(268468224));
                    return;
                }
                startActivity(new Intent(this, (Class<?>) DashboardActivityTheme7.class).setFlags(268468224));
                return;
            }
            startActivity(new Intent(this, (Class<?>) DashboardActivityTheme1.class).setFlags(268468224));
            return;
        }
        super.onBackPressed();
        if (this.stopAnimationOnBackPress) {
            overridePendingTransition(0, 0);
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
                    new File(getFilesDir() + "/Utkarsh/ProfileImage/").mkdirs();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this, this, null);
                    ArrayList arrayList = new ArrayList();
                    MediaFile mediaFile = new MediaFile();
                    mediaFile.setFile_type("image");
                    mediaFile.setImage(bitmapDecodeStream);
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
                    new File(getFilesDir() + "/utkarsh/ProfileImage/").mkdirs();
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream2);
                    Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream2.toByteArray()));
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    this.s3IU = new s3ImageUploading("", "vc-10000386-38616500102/166/application/profile/", this, this, null);
                    ArrayList arrayList2 = new ArrayList();
                    MediaFile mediaFile2 = new MediaFile();
                    mediaFile2.setFile_type("image");
                    mediaFile2.setImage(bitmapDecodeStream2);
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
        if (this.requestCode == 10000 && activityResult.getResultCode() == -1) {
            try {
                File file = new File(String.valueOf(getExternalFilesDir(Environment.DIRECTORY_PICTURES)));
                File[] fileArrListFiles = file.listFiles();
                int length = fileArrListFiles.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    File file2 = fileArrListFiles[i];
                    if (file2.getName().equals("temp_image.jpg")) {
                        file = file2;
                        break;
                    }
                    i++;
                }
                this.cropImage.launch(new CropImageContractOptions(FileProvider.getUriForFile(this, "com.eduteria.app.app.provider", file), Helper.cropImageOptions(this)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (this.requestCode == 20000 && activityResult.getResultCode() == -1) {
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
            if (this.requestCode != 1203 || activityResult.getResultCode() != -1 || activityResult.getData() == null) {
                return;
            }
            String strCopyFileToInternalStorage = copyFileToInternalStorage(activityResult.getData().getData(), "SubjectiveTestPDF");
            try {
                Helper.GoToWebViewPDFActivity(this, com.appnew.android.home.Constants.SUB_TEST_ID, strCopyFileToInternalStorage, true, strCopyFileToInternalStorage.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r13.length - 1], SingleStudy.parentCourseId + MqttTopic.MULTI_LEVEL_WILDCARD + com.appnew.android.home.Constants.SUB_TEST_ID, true, "CourseActivity", true);
                return;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
        }
        Toast.makeText(this, "Unable to upload this file", 0).show();
        e.printStackTrace();
    }

    private void pushEvent() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.device_type, AnalyticHelper.INSTANCE.getDeviceType());
        map.put(AnalyticsConstants.course_content_name, this.courseName);
        map.put("action_type", AnalyticsConstants.COURSE_ACCESS);
        AnalyticEvents.INSTANCE.pushEvents(this, AnalyticsConstants.COURSE_ACCESS, map);
    }

    private void openFeedbackBottomSheet() {
        if (this.isBottomSheetOpen) {
            return;
        }
        this.isBottomSheetOpen = true;
        this.feedbackDialog[0] = new Utils.FeedbackBottomSheetDialog(this, new Utils.FeedbackBottomSheetDialog.Listener() { // from class: com.appnew.android.Courses.Activity.CourseActivity.2
            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onClose() {
                CourseActivity.this.feedbackDialog[0].dismiss();
                CourseActivity.this.isBottomSheetOpen = false;
            }

            @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
            public void onSubmit() {
                RatingBar ratingBar = (RatingBar) CourseActivity.this.feedbackDialog[0].findViewById(R.id.ratingBar);
                EditText editText = (EditText) CourseActivity.this.feedbackDialog[0].findViewById(R.id.ratingComment);
                CourseActivity.this.rating = String.valueOf(ratingBar != null ? ratingBar.getRating() : 0.0f);
                CourseActivity.this.ratingMessage = editText != null ? editText.getText().toString().trim() : "";
                if (ratingBar.getRating() <= 0.0f) {
                    Toast.makeText(CourseActivity.this, "Please select rating!", 0).show();
                } else {
                    if (CourseActivity.this.ratingMessage.isEmpty()) {
                        Toast.makeText(CourseActivity.this, "Please write feedback!", 0).show();
                        return;
                    }
                    CourseActivity.this.networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", false, false);
                    CourseActivity.this.feedbackDialog[0].dismiss();
                    CourseActivity.this.isBottomSheetOpen = false;
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
            Log.e("TAG_APP", "SuccessCallBack: " + this.frag_type);
            Utils.INSTANCE.showGreetingDialog(this, "Thank’s for your valuable feedback !");
        }
    }

    @Override // com.appnew.android.LiveClass.interface_.OnDataSendListener
    public void onDataSent(long isLive, String particularId, String attemptOrReAttempt, int ratingType) {
        Log.e("TAG_APP", "onDataSent: " + isLive + " " + particularId + " , " + ratingType);
        this.courseId = particularId;
        this.rating_type = ratingType;
        if ((TextUtils.isEmpty(this.live_class_feedback) || !this.live_class_feedback.equalsIgnoreCase("1")) && (TextUtils.isEmpty(this.live_test_feedback) || !this.live_test_feedback.equalsIgnoreCase("1") || TextUtils.isEmpty(attemptOrReAttempt) || !attemptOrReAttempt.equalsIgnoreCase(Const.ATTEMPT))) {
            return;
        }
        openFeedbackBottomSheet();
    }

    private void initListeners() {
        VODPlayerActivity.setOnDataSendListener(this);
        Liveawsactivity.setOnDataSendListener(this);
        LiveStreamingYoutube.setOnDataSendListener(this);
        QuizActivity.setOnDataSendListener(this);
        TestBaseActivity.setOnDataSendListener(this);
        TestBaseActivitySSCPattern.setOnDataSendListener(this);
    }
}
