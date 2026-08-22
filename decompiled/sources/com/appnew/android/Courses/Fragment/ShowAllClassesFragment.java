package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter;
import com.appnew.android.Courses.Adapter.ShowAllClassesMainCategoryAdapter;
import com.appnew.android.Courses.overview.adapter.OverviewRVAdapter;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.COURSEDETAIL.Author;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.FAQs.FaqData;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Overview.OverviewData;
import com.appnew.android.Model.Video;
import com.appnew.android.Model.subscription.SubscriptionAllData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.home.Constants;
import com.appnew.android.table.CourseDetailTable;
import com.appnew.android.table.UserWiseCourseTable;
import com.appnew.android.table.VideosDownload;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ShowAllClassesFragment extends MainFragment {
    public static ArrayList<Video> actual_videolist = new ArrayList<>();
    public static String parentCourseId = "";
    TextView authorname;
    BottomSetting bottomSetting;
    RelativeLayout buttonLow;
    TextView buyNowBtn;
    ArrayList<TilesItem> cardsArrayList;
    String catType;
    ArrayList<Courselist> courseDataArrayList;
    ImageView courseImagebg;
    TextView course_name_text;
    CourseDetail cousedetail;
    ExamPrepLayer3Adapter examPrepLayer3Adapter;
    RecyclerView examPrepLayerRV;
    ArrayList<FaqData> faqData;
    RelativeLayout headerLL;
    LeftMenu leftMenu;
    LinearLayoutCompat ll_compat;
    String mainCourseId;
    TextView mrpCutTV;
    Button myLibBtn;
    private NestedScrollView nestedScrollView;
    RelativeLayout no_data_found_RL;
    OverviewData overviewData;
    ProgressBar paginationLoader;
    TextView price;
    LinearLayout priceLL;
    RelativeLayout relativeL;
    RelativeLayout relativeLL;
    String revertAPI;
    ShowAllClassesMainCategoryAdapter showAllClassesMainCategoryAdapter;
    RecyclerView subjectRecyclerView;
    String tileIdAPI;
    TileItemsAdapter tileItemsAdapter;
    RecyclerView tileRv;
    TileSubjectItemsAdapter tileSubjectItemsAdapter;
    String tileTypeAPI;
    List<TilesItem> tilesItem;
    TextView tvGstDesc;
    String typeApi;
    private UtkashRoom utkashRoom;
    TextView validityTV;
    boolean isCombo = false;
    private ArrayList<Video> seleced_tile_list = new ArrayList<>();
    private ArrayList<Video> custom_video_list = new ArrayList<>();
    private ArrayList<Video> custom_link_list = new ArrayList<>();
    String file_type_attributes = "";
    String contentTypeTile = "";
    String contentTypeSubjectID = "";
    public String tile_id = "";
    private String course_name = "";
    ArrayList<Video> videoArrayList = new ArrayList<>();
    public UtkashRoom myDBClass = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
    private int mPage = 1;
    boolean status = false;
    private boolean isPaginationAvailable = true;
    ExamPrepItem examPrepItem = new ExamPrepItem();
    int tilePos = 0;
    private BroadcastReceiver videoDownloadReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("result", -1);
            String stringExtra = intent.getStringExtra("video_time");
            String stringExtra2 = intent.getStringExtra("resourceId");
            if (intExtra == 1) {
                for (Video video : ShowAllClassesFragment.this.videoArrayList) {
                    if (video.getId().equalsIgnoreCase(stringExtra2)) {
                        video.setVideo_download(true);
                        video.setVideo_status("Downloaded");
                        video.setVideotime(stringExtra);
                        ShowAllClassesFragment.this.examPrepLayer3Adapter.notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    };
    String fileType = "0";
    Boolean isLodded = true;

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.videoDownloadReceiver);
    }

    public static ShowAllClassesFragment newInstance(String mainCourseId, boolean isCombo, String parentCourseId2, String course_name, String valid_to) {
        ShowAllClassesFragment showAllClassesFragment = new ShowAllClassesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Const.COURSE_ID_MAIN, mainCourseId);
        bundle.putString(Const.COURSE_PARENT_ID, parentCourseId2);
        bundle.putBoolean(Const.IS_COMBO, isCombo);
        bundle.putString("valid_to", valid_to);
        bundle.putString(AnalyticsConstants.course_name, course_name);
        showAllClassesFragment.setArguments(bundle);
        return showAllClassesFragment;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.isCombo = getArguments().getBoolean(Const.IS_COMBO);
            parentCourseId = getArguments().getString(Const.COURSE_PARENT_ID);
            this.course_name = getArguments().getString(AnalyticsConstants.course_name);
            this.mainCourseId = getArguments().getString(Const.COURSE_ID_MAIN);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.tileRv = (RecyclerView) view.findViewById(R.id.tilesRV);
        this.subjectRecyclerView = (RecyclerView) view.findViewById(R.id.subjectRecyclerView);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.validityTV = (TextView) view.findViewById(R.id.validityTV);
        this.authorname = (TextView) view.findViewById(R.id.authorname);
        this.course_name_text = (TextView) view.findViewById(R.id.course_name);
        this.ll_compat = (LinearLayoutCompat) view.findViewById(R.id.ll_compat);
        this.headerLL = (RelativeLayout) view.findViewById(R.id.headerLL);
        this.courseImagebg = (ImageView) view.findViewById(R.id.courseImagebg);
        this.examPrepLayerRV = (RecyclerView) view.findViewById(R.id.examPrepLayerRV);
        this.paginationLoader = (ProgressBar) view.findViewById(R.id.progressBar);
        this.nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll);
        this.mrpCutTV = (TextView) view.findViewById(R.id.mrpCutTV);
        this.price = (TextView) view.findViewById(R.id.priceTV);
        this.buyNowBtn = (TextView) view.findViewById(R.id.buyNowBtn);
        this.buttonLow = (RelativeLayout) view.findViewById(R.id.buttonLow);
        this.myLibBtn = (Button) view.findViewById(R.id.myLibBtn);
        this.priceLL = (LinearLayout) view.findViewById(R.id.priceLL);
        this.relativeLL = (RelativeLayout) view.findViewById(R.id.relativeLL);
        this.relativeL = (RelativeLayout) view.findViewById(R.id.relativeL);
        this.tvGstDesc = (TextView) view.findViewById(R.id.tv_gstDesc);
        this.buyNowBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.buy_now));
        if (this.utkashRoom == null) {
            this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        }
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this.activity);
        this.utkashRoom = appDatabase;
        this.leftMenu = (LeftMenu) new Gson().fromJson(appDatabase.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
        checkPaymentMode();
        if (this.utkashRoom.getCourseDetaildata() != null) {
            if (!this.isCombo) {
                parentCourseId = this.mainCourseId;
            }
            if (!this.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + this.mainCourseId)) {
                NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
            } else {
                List<CourseDetailTable> list = this.utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + this.mainCourseId, MakeMyExam.userId);
                CourseDetailData courseDetailData = new CourseDetailData();
                if (list.size() > 0) {
                    courseDetailData.setTitle(list.get(0).getCourse_title());
                    courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                    Author author = new Author();
                    author.setTitle(list.get(0).getAuthor_title());
                    courseDetailData.setAuthor(author);
                    courseDetailData.setMrp(list.get(0).getMrp());
                    courseDetailData.setTax(list.get(0).getTax());
                    courseDetailData.setValidity(list.get(0).getValidity());
                    courseDetailData.setId(list.get(0).getCourse_id().split("_")[1]);
                    courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                    courseDetailData.setDescHeaderImage(list.get(0).getDesc_header_image());
                    courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
                    courseDetailData.setViewType(list.get(0).getView_type());
                    courseDetailData.setIs_combo(list.get(0).getIs_combo());
                    courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                    courseDetailData.setCat_type(list.get(0).getCat_type());
                    courseDetailData.setHide_validity(list.get(0).getHide_validity());
                    courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
                    courseDetailData.setIs_activated(list.get(0).getIs_activated());
                    courseDetailData.setIs_gst(list.get(0).getIs_gst());
                    courseDetailData.setCourse_code(list.get(0).getCourse_code());
                    courseDetailData.setToken_activation(list.get(0).getToken_activation());
                    courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
                    courseDetailData.setCombo_has_book(list.get(0).getCombo_has_book());
                    courseDetailData.setTax_rate(list.get(0).getTax_rate());
                    this.cousedetail = new CourseDetail();
                    Data data = new Data();
                    data.setCourseDetail(courseDetailData);
                    if (list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                        data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        arrayList.add(new TilesItem(list.get(i).getTile_revert(), list.get(i).getTile_title(), list.get(i).getTile_id(), list.get(i).getType(), list.get(i).getTile_meta(), list.get(i).getSet_as_demo(), list.get(i).getThumbnail()));
                    }
                    data.setTiles(arrayList);
                    this.cousedetail.setData(data);
                    if (((CourseActivity) this.activity).is_coupon) {
                        Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                        intent.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                        intent.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                        intent.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent, this.activity);
                    } else if (!courseDetailData.getIsPurchased().equalsIgnoreCase("1") || !courseDetailData.getToken_activation().equalsIgnoreCase("1") || !courseDetailData.getIsPurchased().equalsIgnoreCase("1") || !courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                        initlizeTilesAdapter();
                        initButton(this.cousedetail.getData().getCourseDetail());
                    }
                } else {
                    this.utkashRoom.getCourseDetaildata().deletecoursedetail(parentCourseId, MakeMyExam.userId);
                    NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
                }
            }
        }
        ((CourseActivity) this.activity).shareIV.setVisibility(0);
        ((CourseActivity) this.activity).shareIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$0();
            }
        }));
        this.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$1(view2);
            }
        });
        this.myLibBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$2(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$0() {
        Helper.shareCourse(this.activity, this.mainCourseId, String.valueOf(this.isCombo), parentCourseId, this.course_name, this.cousedetail.getData().getCourseDetail().getDescHeaderImage(), this.cousedetail.getData().getCourseDetail().getTitle());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(View view) {
        Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
        intent.putExtra(Const.SINGLE_STUDY, this.cousedetail);
        CourseDetail courseDetail = this.cousedetail;
        if (courseDetail != null && courseDetail.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getCat_type() != null) {
            intent.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
        } else {
            intent.putExtra(Const.IS_BOOK, this.catType);
        }
        intent.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
        Helper.gotoActivity(intent, this.activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(View view) {
        NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ShowAllClassesFragment showAllClassesFragment;
        super.onResume();
        if (Constants.REFRESHPAGE.equalsIgnoreCase("")) {
            showAllClassesFragment = this;
        } else {
            showAllClassesFragment = this;
            showAllClassesFragment.NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            Constants.REFRESHPAGE = "";
        }
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(showAllClassesFragment.videoDownloadReceiver, new IntentFilter(VideoDownloadService.VIDEO_DOWNLOAD_ACTION));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_master_data":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setTile_id(this.tile_id);
                encryptionData.setType(this.tileTypeAPI);
                encryptionData.setRevert_api(this.revertAPI);
                encryptionData.setCourse_id(this.mainCourseId);
                encryptionData.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                encryptionData.setPage("" + this.mPage);
                encryptionData.setSubject_id(this.contentTypeSubjectID);
                encryptionData.setTopic_id("0");
                encryptionData.setLayer("3");
                return service.getMasterDataVideo(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setCourse_id(this.mainCourseId);
                encryptionData2.setCoupon_applied("0");
                encryptionData2.setParent_id(parentCourseId);
                return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/course_deprecated/get_course_detail":
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setCourse_id(this.mainCourseId);
                encryptionData3.setParent_id(parentCourseId);
                return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData3)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        int i;
        ShowAllClassesFragment showAllClassesFragment = this;
        Gson gson = new Gson();
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -171058627:
                if (apitype.equals(API.API_GET_MASTER_DATA)) {
                    b2 = 0;
                }
                break;
            case 114126311:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                    b2 = 1;
                }
                break;
            case 750643905:
                if (apitype.equals(API.CourseDetail_JS)) {
                    b2 = 2;
                }
                break;
        }
        switch (b2) {
            case 0:
                if (jsonstring.optString("status").equals("true")) {
                    ProgressBar progressBar = showAllClassesFragment.paginationLoader;
                    if (progressBar != null && progressBar.isShown()) {
                        showAllClassesFragment.paginationLoader.setVisibility(8);
                    }
                    showAllClassesFragment.isPaginationAvailable = true;
                    if (showAllClassesFragment.status) {
                        JSONObject jSONObject = jsonstring.getJSONObject("data");
                        if (jSONObject.has("cat_type")) {
                            showAllClassesFragment.catType = jSONObject.optString("cat_type");
                        } else {
                            showAllClassesFragment.catType = "";
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONObject.optJSONArray("list").length(); i2++) {
                            arrayList.add((Video) gson.fromJson(jSONObject.optJSONArray("list").get(i2).toString(), Video.class));
                        }
                        if (arrayList.size() > 0) {
                            int size = showAllClassesFragment.videoArrayList.size();
                            showAllClassesFragment.videoArrayList.addAll(arrayList);
                            ArrayList<Video> arrayList2 = showAllClassesFragment.videoArrayList;
                            actual_videolist = arrayList2;
                            for (Video video : arrayList2) {
                                if (video.getFile_type() != null && video.getFile_type().equalsIgnoreCase("3") && video.getVideo_type() != null && (video.getVideo_type().equalsIgnoreCase("6") || video.getVideo_type().equalsIgnoreCase("7") || (video.getVideo_type().equalsIgnoreCase("9") && video.getFile_url() != null && !video.getFile_url().equalsIgnoreCase("")))) {
                                    if (!showAllClassesFragment.myDBClass.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                                        if (showAllClassesFragment.myDBClass.getvideoDownloadao().isvideo_exit(video.getId(), MakeMyExam.userId)) {
                                            VideosDownload videosDownload = showAllClassesFragment.myDBClass.getvideoDownloadao().getvideo_byuserid(video.getId(), MakeMyExam.userId);
                                            if (videosDownload.getToal_downloadlocale() != null) {
                                                if (video.getIs_Download().equalsIgnoreCase("1") && videosDownload.getVideo_status().equalsIgnoreCase("")) {
                                                    video.setVideo_status("Download");
                                                } else {
                                                    video.setVideo_status(videosDownload.getVideo_status());
                                                }
                                                video.setVideotime(videosDownload.getVideotime());
                                                video.setVideo_download(videosDownload.getIs_complete().equalsIgnoreCase("1"));
                                                video.setVideo_currentpos(videosDownload.getVideoCurrentPosition());
                                            }
                                        } else if (video.getIs_Download().equalsIgnoreCase("1")) {
                                            video.setVideo_status("Download");
                                            video.setVideo_download(false);
                                            video.setVideo_currentpos(0L);
                                        } else {
                                            video.setVideo_status("");
                                            video.setVideo_download(false);
                                            video.setVideo_currentpos(0L);
                                        }
                                    }
                                }
                            }
                            ExamPrepLayer3Adapter examPrepLayer3Adapter = showAllClassesFragment.examPrepLayer3Adapter;
                            if (examPrepLayer3Adapter != null) {
                                examPrepLayer3Adapter.notifyItemRangeInserted(showAllClassesFragment.videoArrayList.size() - 1, showAllClassesFragment.videoArrayList.size() - size);
                            }
                        }
                    } else {
                        ArrayList<Video> arrayList3 = showAllClassesFragment.videoArrayList;
                        if (arrayList3 != null && arrayList3.size() > 0) {
                            showAllClassesFragment.videoArrayList.clear();
                        }
                        JSONObject jSONObject2 = jsonstring.getJSONObject("data");
                        ArrayList arrayList4 = new ArrayList();
                        for (int i3 = 0; i3 < jSONObject2.optJSONArray("list").length(); i3++) {
                            arrayList4.add((Video) gson.fromJson(jSONObject2.optJSONArray("list").get(i3).toString(), Video.class));
                        }
                        if (arrayList4.size() > 0) {
                            showAllClassesFragment.videoArrayList.addAll(arrayList4);
                            ArrayList<Video> arrayList5 = showAllClassesFragment.videoArrayList;
                            actual_videolist = arrayList5;
                            for (Video video2 : arrayList5) {
                                if (video2.getFile_type() == null || !video2.getFile_type().equalsIgnoreCase("3") || video2.getVideo_type() == null || (!(video2.getVideo_type().equalsIgnoreCase("6") || video2.getVideo_type().equalsIgnoreCase("7") || !(!video2.getVideo_type().equalsIgnoreCase("9") || video2.getFile_url() == null || video2.getFile_url().equalsIgnoreCase(""))) || showAllClassesFragment.myDBClass.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread())) {
                                    i = 0;
                                } else if (showAllClassesFragment.myDBClass.getvideoDownloadao().isvideo_exit(video2.getId(), MakeMyExam.userId)) {
                                    VideosDownload videosDownload2 = showAllClassesFragment.myDBClass.getvideoDownloadao().getvideo_byuserid(video2.getId(), MakeMyExam.userId);
                                    if (videosDownload2.getToal_downloadlocale() != null) {
                                        if (video2.getIs_Download() != null && video2.getIs_Download().equalsIgnoreCase("1") && videosDownload2.getVideo_status().equalsIgnoreCase("")) {
                                            video2.setVideo_status("Download");
                                        } else {
                                            video2.setVideo_status(videosDownload2.getVideo_status());
                                        }
                                        video2.setVideotime(videosDownload2.getVideotime());
                                        video2.setVideo_download(videosDownload2.getIs_complete().equalsIgnoreCase("1"));
                                        video2.setVideo_currentpos(videosDownload2.getVideoCurrentPosition());
                                    }
                                    i = 0;
                                } else if (video2.getIs_Download() != null && video2.getIs_Download().equalsIgnoreCase("1")) {
                                    video2.setVideo_status("Download");
                                    i = 0;
                                    video2.setVideo_download(false);
                                    video2.setVideo_currentpos(0L);
                                } else {
                                    i = 0;
                                    video2.setVideo_status("");
                                    video2.setVideo_download(false);
                                    video2.setVideo_currentpos(0L);
                                }
                                showAllClassesFragment.no_data_found_RL.setVisibility(8);
                                showAllClassesFragment.examPrepLayerRV.setVisibility(i);
                                showAllClassesFragment.InitTestAdapter(showAllClassesFragment.videoArrayList);
                            }
                        } else {
                            showAllClassesFragment.no_data_found_RL.setVisibility(0);
                            showAllClassesFragment.examPrepLayerRV.setVisibility(8);
                        }
                    }
                } else {
                    if (!showAllClassesFragment.status) {
                        showAllClassesFragment.no_data_found_RL.setVisibility(0);
                        showAllClassesFragment.examPrepLayerRV.setVisibility(8);
                    }
                    ProgressBar progressBar2 = showAllClassesFragment.paginationLoader;
                    if (progressBar2 != null && progressBar2.isShown()) {
                        showAllClassesFragment.paginationLoader.setVisibility(8);
                    }
                    showAllClassesFragment.isPaginationAvailable = false;
                    if (!GenericUtils.isEmpty(jsonstring.optString("auth_code"))) {
                        RetrofitResponse.GetApiData(showAllClassesFragment.activity, jsonstring.optString("auth_code"), jsonstring.optString("message"), false);
                    }
                }
                break;
            case 1:
                try {
                    if (jsonstring.optString("status").equals("true")) {
                        showAllClassesFragment.utkashRoom.getCourseDetaildata().deletecoursedetail(showAllClassesFragment.cousedetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                        Toast.makeText(showAllClassesFragment.activity, "" + jsonstring.optString("message"), 0).show();
                        showAllClassesFragment.pushEventForFreeCourse();
                        Intent intent = new Intent(showAllClassesFragment.activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SHOW_ALL_COURSES);
                        intent.putExtra(Const.COURSE_ID_MAIN, !parentCourseId.equalsIgnoreCase("") ? parentCourseId : showAllClassesFragment.cousedetail.getData().getCourseDetail().getId());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra("valid_to", showAllClassesFragment.cousedetail.getData().getCourseDetail().getValid_to());
                        intent.putExtra(AnalyticsConstants.course_name, showAllClassesFragment.cousedetail.getData().getCourseDetail().getTitle());
                        Helper.gotoActivity_finish(intent, showAllClassesFragment.activity);
                    } else {
                        Toast.makeText(showAllClassesFragment.activity, "" + jsonstring.optString("message"), 0).show();
                        RetrofitResponse.GetApiData(showAllClassesFragment.activity, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 2:
                if (jsonstring.optString("status").equals("true")) {
                    JSONObject jSONObjectOptJSONObject = jsonstring.optJSONObject("data");
                    SharedPreference.getInstance().putString(Const.IS_IGST, jsonstring.optString(Const.IS_IGST));
                    String str = "id";
                    if (!showAllClassesFragment.utkashRoom.getuserwisecourse().is_api_code_exits(MakeMyExam.userId, jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                        UserWiseCourseTable userWiseCourseTable = new UserWiseCourseTable();
                        userWiseCourseTable.setUserid(MakeMyExam.userId);
                        userWiseCourseTable.setCode("ut_011");
                        userWiseCourseTable.setVersion("0.000");
                        userWiseCourseTable.setExp(String.valueOf(MakeMyExam.getTime_server()));
                        userWiseCourseTable.setMeta_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                        showAllClassesFragment.utkashRoom.getuserwisecourse().addUser(userWiseCourseTable);
                    }
                    if (!showAllClassesFragment.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                        int i4 = 0;
                        while (i4 < jSONObjectOptJSONObject.getJSONArray("tiles").length()) {
                            CourseDetailTable courseDetailTable = new CourseDetailTable();
                            courseDetailTable.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                            courseDetailTable.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str));
                            courseDetailTable.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                            courseDetailTable.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                            courseDetailTable.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                            courseDetailTable.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                            courseDetailTable.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
                            courseDetailTable.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                            courseDetailTable.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                            courseDetailTable.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                            courseDetailTable.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                            courseDetailTable.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                            courseDetailTable.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                            courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, str));
                            courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, "meta"));
                            courseDetailTable.setUser_id(MakeMyExam.userId);
                            courseDetailTable.setTile_revert(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i4).getString(Const.REVERT_API));
                            courseDetailTable.setTile_title(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i4).getString("tile_name"));
                            courseDetailTable.setType(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i4).getString("type"));
                            if (jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i4).has("set_as_demo")) {
                                courseDetailTable.setSet_as_demo(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i4).getString("set_as_demo"));
                            }
                            String str2 = str;
                            if (jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i4).has("thumbnail")) {
                                courseDetailTable.setThumbnail(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i4).getString("thumbnail"));
                            }
                            courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, Const.REVERT_API));
                            courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, "tile_name"));
                            courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, "type"));
                            courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, "set_as_demo"));
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment") != null) {
                                courseDetailTable.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment"));
                            } else {
                                courseDetailTable.setSkip_payment("1");
                            }
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cat_type") != null) {
                                courseDetailTable.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cat_type"));
                            } else {
                                courseDetailTable.setCat_type("");
                            }
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.DELIVERY_CHARGE) != null) {
                                courseDetailTable.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.DELIVERY_CHARGE));
                            } else {
                                courseDetailTable.setDelivery_charge("0");
                            }
                            courseDetailTable.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                            courseDetailTable.setCourse_code(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_code"));
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has("combo_has_book") && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("combo_has_book"))) {
                                courseDetailTable.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("combo_has_book"));
                            } else {
                                courseDetailTable.setCombo_has_book("0");
                            }
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has("external_coupon_off") && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("external_coupon_off"))) {
                                courseDetailTable.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("external_coupon_off"));
                            } else {
                                courseDetailTable.setExternal_coupon_off("");
                            }
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has("tax_rate") && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax_rate"))) {
                                courseDetailTable.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax_rate"));
                            } else {
                                courseDetailTable.setTax_rate("0");
                            }
                            if (jsonstring.optJSONObject("data").optJSONObject("subscription_all_data") != null) {
                                courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonstring.optJSONObject("data").optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                            }
                            showAllClassesFragment = this;
                            showAllClassesFragment.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
                            i4++;
                            str = str2;
                        }
                    }
                    List<CourseDetailTable> list = showAllClassesFragment.utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + showAllClassesFragment.mainCourseId, MakeMyExam.userId);
                    if (list != null && list.size() > 0) {
                        CourseDetailData courseDetailData = new CourseDetailData();
                        courseDetailData.setTitle(list.get(0).getCourse_title());
                        courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                        Author author = new Author();
                        author.setTitle(list.get(0).getAuthor_title());
                        courseDetailData.setAuthor(author);
                        courseDetailData.setMrp(list.get(0).getMrp());
                        courseDetailData.setTax(list.get(0).getTax());
                        courseDetailData.setValidity(list.get(0).getValidity());
                        courseDetailData.setId(list.get(0).getCourse_id().split("_")[1]);
                        courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                        courseDetailData.setDescHeaderImage(list.get(0).getDesc_header_image());
                        courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
                        courseDetailData.setViewType(list.get(0).getView_type());
                        courseDetailData.setIs_combo(list.get(0).getIs_combo());
                        courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                        courseDetailData.setCat_type(list.get(0).getCat_type());
                        courseDetailData.setHide_validity(list.get(0).getHide_validity());
                        courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
                        courseDetailData.setIs_activated(list.get(0).getIs_activated());
                        courseDetailData.setToken_activation(list.get(0).getToken_activation());
                        courseDetailData.setIs_gst(list.get(0).getIs_gst());
                        courseDetailData.setCourse_code(list.get(0).getCourse_code());
                        courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
                        courseDetailData.setCombo_has_book(list.get(0).getCombo_has_book());
                        courseDetailData.setTax_rate(list.get(0).getTax_rate());
                        showAllClassesFragment.cousedetail = new CourseDetail();
                        Data data = new Data();
                        data.setCourseDetail(courseDetailData);
                        if (list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                            data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                        }
                        showAllClassesFragment.tilesItem = new ArrayList();
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            showAllClassesFragment.tilesItem.add(new TilesItem(list.get(i5).getTile_revert(), list.get(i5).getTile_title(), list.get(i5).getTile_id(), list.get(i5).getType(), list.get(i5).getTile_meta(), list.get(i5).getSet_as_demo(), list.get(i5).getThumbnail()));
                        }
                        data.setTiles(showAllClassesFragment.tilesItem);
                        showAllClassesFragment.cousedetail.setData(data);
                        if (((CourseActivity) showAllClassesFragment.activity).is_coupon) {
                            Intent intent2 = new Intent(showAllClassesFragment.activity, (Class<?>) PurchaseActivity.class);
                            intent2.putExtra(Const.SINGLE_STUDY, showAllClassesFragment.cousedetail);
                            intent2.putExtra(Const.IS_BOOK, showAllClassesFragment.cousedetail.getData().getCourseDetail().getCat_type());
                            intent2.putExtra(Const.DELIVERY_CHARGE, showAllClassesFragment.cousedetail.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent2, showAllClassesFragment.activity);
                        } else if (courseDetailData.getIsPurchased().equalsIgnoreCase("1") && courseDetailData.getToken_activation().equalsIgnoreCase("1")) {
                            if (!courseDetailData.getIsPurchased().equalsIgnoreCase("1") || !courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                                showAllClassesFragment.initButton(showAllClassesFragment.cousedetail.getData().getCourseDetail());
                                showAllClassesFragment.initlizeTilesAdapter();
                            }
                        } else {
                            showAllClassesFragment.initButton(showAllClassesFragment.cousedetail.getData().getCourseDetail());
                            showAllClassesFragment.initlizeTilesAdapter();
                        }
                    } else {
                        showAllClassesFragment.no_data_found_RL.setVisibility(0);
                        showAllClassesFragment.buttonLow.setVisibility(8);
                    }
                } else {
                    showAllClassesFragment.no_data_found_RL.setVisibility(0);
                    showAllClassesFragment.buttonLow.setVisibility(8);
                    RetrofitResponse.GetApiData(showAllClassesFragment.activity, jsonstring.optString("auth_code"), jsonstring.optString("message"), false);
                }
                break;
        }
    }

    public void initlizeTilesAdapter() {
        this.headerLL.setVisibility(8);
        this.tileRv.setVisibility(0);
        this.cardsArrayList = new ArrayList<>();
        for (TilesItem tilesItem : this.cousedetail.getData().getTiles()) {
            if (!tilesItem.getType().equalsIgnoreCase(Const.FAQ) && !tilesItem.getType().equalsIgnoreCase("content") && !tilesItem.getType().equalsIgnoreCase(Const.COMBO)) {
                this.cardsArrayList.add(tilesItem);
            }
        }
        this.file_type_attributes = "0";
        if (this.cardsArrayList.size() > 0) {
            this.contentTypeTile = this.cardsArrayList.get(0).getType() + this.cardsArrayList.get(0).getId();
            this.tile_id = this.cardsArrayList.get(0).getId();
            this.tileTypeAPI = this.cardsArrayList.get(0).getType();
            if (this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                this.revertAPI = "1#2#0#0";
            } else {
                this.revertAPI = "0#2#0#0";
            }
            if (this.cardsArrayList.get(0).getType().equalsIgnoreCase(Const.LIVE_VIDEO) || this.cardsArrayList.get(0).getType().equalsIgnoreCase(Const.UPCOMING_VIDEO)) {
                ((CourseActivity) this.activity).contentType = "video" + this.cardsArrayList.get(0).getId();
            } else {
                ((CourseActivity) this.activity).contentType = this.cardsArrayList.get(0).getType() + this.cardsArrayList.get(0).getId();
            }
            if (this.cardsArrayList.get(0).getType().equalsIgnoreCase(Const.OVERVIEW)) {
                com.appnew.android.Model.Overview.Data data = (com.appnew.android.Model.Overview.Data) new Gson().fromJson(this.cardsArrayList.get(0).getMeta(), com.appnew.android.Model.Overview.Data.class);
                OverviewData overviewData = new OverviewData();
                this.overviewData = overviewData;
                overviewData.setData(data);
                this.examPrepItem = new ExamPrepItem();
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.cardsArrayList.get(0).getMeta());
                    if (jSONObject.optJSONArray("list") != null && jSONObject.optJSONArray("list").length() > 0) {
                        JSONArray jSONArray = jSONObject.getJSONArray("list");
                        ArrayList<Lists> arrayList = new ArrayList<>();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add((Lists) new Gson().fromJson(jSONArray.opt(i).toString(), Lists.class));
                        }
                        this.examPrepItem.setList(arrayList);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            initSubjectAdapter(this.examPrepItem, this.cardsArrayList.get(0).getType(), this.cousedetail.getData().getCourseDetail());
        } else {
            this.relativeL.setVisibility(8);
            this.relativeLL.setVisibility(8);
            this.subjectRecyclerView.setVisibility(8);
            this.buttonLow.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
        }
        this.tileItemsAdapter = new TileItemsAdapter(this.activity, this.cardsArrayList, this.tileRv);
        this.tileRv.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        this.tileRv.setNestedScrollingEnabled(false);
        this.tileRv.setAdapter(this.tileItemsAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSubjectAdapter(ExamPrepItem examPrepItem, String tileType, CourseDetailData cousedetail) {
        if (tileType.equalsIgnoreCase(Const.OVERVIEW)) {
            this.examPrepLayerRV.setVisibility(8);
            this.subjectRecyclerView.setVisibility(0);
            this.tileSubjectItemsAdapter = new TileSubjectItemsAdapter(this.activity, examPrepItem, this.subjectRecyclerView, tileType, cousedetail);
            this.subjectRecyclerView.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
            this.subjectRecyclerView.setAdapter(this.tileSubjectItemsAdapter);
            return;
        }
        if (tileType.equalsIgnoreCase(Const.LIVE_VIDEO) || tileType.equalsIgnoreCase(Const.UPCOMING_VIDEO)) {
            this.examPrepLayerRV.setVisibility(0);
            this.subjectRecyclerView.setVisibility(8);
            this.revertAPI = "0#3#1#0";
            hit_api_for_data(true);
            this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment$$ExternalSyntheticLambda3
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    this.f$0.lambda$initSubjectAdapter$3(nestedScrollView, i, i2, i3, i4);
                }
            });
            return;
        }
        if (examPrepItem.getList() == null || examPrepItem.getList().size() <= 0) {
            return;
        }
        this.examPrepLayerRV.setVisibility(0);
        this.subjectRecyclerView.setVisibility(0);
        this.contentTypeSubjectID = examPrepItem.getList().get(0).getId();
        this.tileSubjectItemsAdapter = new TileSubjectItemsAdapter(this.activity, examPrepItem, this.subjectRecyclerView, tileType, cousedetail);
        this.subjectRecyclerView.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        this.subjectRecyclerView.setAdapter(this.tileSubjectItemsAdapter);
        hit_api_for_data(true);
        this.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment$$ExternalSyntheticLambda4
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                this.f$0.lambda$initSubjectAdapter$4(nestedScrollView, i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSubjectAdapter$3(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4 || !this.isPaginationAvailable) {
            return;
        }
        this.paginationLoader.setVisibility(0);
        this.mPage++;
        this.status = true;
        hit_api_for_data(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSubjectAdapter$4(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) == null || i2 < nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() || i2 <= i4 || !this.isPaginationAvailable) {
            return;
        }
        this.paginationLoader.setVisibility(0);
        this.mPage++;
        this.status = true;
        hit_api_for_data(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hit_api_for_data(boolean showProgress) {
        NetworkAPICall(API.API_GET_MASTER_DATA, this.contentTypeTile, showProgress, false, false);
    }

    private void hit_api_for_live_data(boolean showProgress) {
        NetworkAPICall(API.get_liveclasses_data, this.contentTypeTile, showProgress, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_all_classes, container, false);
    }

    public void checkPaymentMode() {
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InitTestAdapter(ArrayList<Video> videoArrayList) {
        if (videoArrayList != null && videoArrayList.size() > 0) {
            RecyclerView recyclerView = this.examPrepLayerRV;
            if (recyclerView != null && this.no_data_found_RL != null) {
                recyclerView.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
            }
            RecyclerView recyclerView2 = this.examPrepLayerRV;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
                this.examPrepLayerRV.setItemAnimator(new DefaultItemAnimator());
                this.headerLL.setVisibility(8);
                Activity activity = this.activity;
                CourseDetail courseDetail = this.cousedetail;
                String str = this.tile_id;
                ExamPrepLayer3Adapter examPrepLayer3Adapter = new ExamPrepLayer3Adapter(activity, courseDetail, videoArrayList, str, this.tileTypeAPI, this.revertAPI, str, courseDetail.getData().getCourseDetail().getIsPurchased());
                this.examPrepLayer3Adapter = examPrepLayer3Adapter;
                this.examPrepLayerRV.setAdapter(examPrepLayer3Adapter);
                return;
            }
            return;
        }
        RecyclerView recyclerView3 = this.examPrepLayerRV;
        if (recyclerView3 == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView3.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    public class TileItemsAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<TilesItem> cards;
        private Context context;
        private RecyclerView tileRv;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public LinearLayout parent;
            public TextView tilesText;

            public MyViewHolder(View view) {
                super(view);
                this.tilesText = (TextView) view.findViewById(R.id.tilesTextTv);
                this.parent = (LinearLayout) view.findViewById(R.id.parentBottom);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(6, 0, 6, 0);
                this.parent.setLayoutParams(layoutParams);
                this.tilesText.setPadding(Math.round(Helper.convertDpToPixel(16, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(16, TileItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileItemsAdapter.this.context)));
            }
        }

        public TileItemsAdapter(Context context, ArrayList<TilesItem> cards, RecyclerView tileRv) {
            this.cards = cards;
            this.context = context;
            this.tileRv = tileRv;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View viewInflate;
            if ("1".equalsIgnoreCase("6")) {
                viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_tiles_new, parent, false);
            } else {
                viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_layout2, parent, false);
            }
            return new MyViewHolder(viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final TilesItem tilesItem = this.cards.get(position);
            TilesItem tilesItem2 = this.cards.get(0);
            holder.tilesText.setText(tilesItem.getTileName());
            if (ShowAllClassesFragment.this.contentTypeTile.equals(tilesItem.getType() + tilesItem.getId())) {
                this.cards.get(position).setActivate(true);
            }
            if ("1".equalsIgnoreCase("6")) {
                if (tilesItem.isActivate()) {
                    holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.bg_btn_testpause));
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.whie));
                } else {
                    holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.course_tiles_item));
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                }
            } else if (tilesItem.isActivate()) {
                holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.round_bg_1));
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.whie));
            } else {
                holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.ronded_bg));
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
            }
            if (tilesItem2.getType().equalsIgnoreCase(Const.PDF)) {
                ShowAllClassesFragment.this.fileType = "1";
            } else if (tilesItem2.getType().equalsIgnoreCase(Const.PPT)) {
                ShowAllClassesFragment.this.fileType = "2";
            } else if (tilesItem2.getType().equalsIgnoreCase("video")) {
                ShowAllClassesFragment.this.fileType = "3";
            } else if (tilesItem2.getType().equalsIgnoreCase(Const.EPUB)) {
                ShowAllClassesFragment.this.fileType = "4";
            } else if (tilesItem2.getType().equalsIgnoreCase(Const.DOC)) {
                ShowAllClassesFragment.this.fileType = "5";
            } else if (tilesItem2.getType().equalsIgnoreCase("image")) {
                ShowAllClassesFragment.this.fileType = "6";
            } else if (tilesItem2.getType().equalsIgnoreCase(Const.CONCEPT)) {
                ShowAllClassesFragment.this.fileType = "7";
            } else if (tilesItem2.getType().equalsIgnoreCase("link")) {
                ShowAllClassesFragment.this.fileType = "8";
            } else if (tilesItem2.getType().equalsIgnoreCase(Const.TEST)) {
                ShowAllClassesFragment.this.file_type_attributes = "t";
                ShowAllClassesFragment.this.fileType = "t";
            } else if (tilesItem2.getType().equalsIgnoreCase(Const.SUBJECTIVE_TEST)) {
                ShowAllClassesFragment.this.file_type_attributes = "st";
                ShowAllClassesFragment.this.fileType = "st";
            } else if (tilesItem2.getType().equalsIgnoreCase(Const.Daily_assignment)) {
                ShowAllClassesFragment.this.file_type_attributes = Const.CONTENT_daily_assign;
                ShowAllClassesFragment.this.fileType = Const.CONTENT_daily_assign;
            } else {
                ShowAllClassesFragment.this.file_type_attributes = "0";
                ShowAllClassesFragment.this.fileType = "0";
            }
            holder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment.TileItemsAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ShowAllClassesFragment.this.mPage = 1;
                    ShowAllClassesFragment.this.status = false;
                    ShowAllClassesFragment.this.file_type_attributes = "";
                    if (ShowAllClassesFragment.this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                        ShowAllClassesFragment.this.contentTypeTile = "";
                    }
                    ShowAllClassesFragment.this.contentTypeTile = tilesItem.getType() + tilesItem.getId();
                    ShowAllClassesFragment.this.tile_id = tilesItem.getId();
                    ShowAllClassesFragment.this.tileTypeAPI = tilesItem.getType();
                    if (ShowAllClassesFragment.this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                        ShowAllClassesFragment.this.revertAPI = "1#2#0#0";
                    } else {
                        ShowAllClassesFragment.this.revertAPI = "0#2#0#0";
                    }
                    if (tilesItem.getType().equalsIgnoreCase(Const.LIVE_VIDEO) || tilesItem.getType().equalsIgnoreCase(Const.UPCOMING_VIDEO)) {
                        ((CourseActivity) ShowAllClassesFragment.this.activity).contentType = "video" + tilesItem.getId();
                    } else {
                        ((CourseActivity) ShowAllClassesFragment.this.activity).contentType = tilesItem.getType() + tilesItem.getId();
                    }
                    for (int i = 0; i < TileItemsAdapter.this.cards.size(); i++) {
                        if (i != position) {
                            ((TilesItem) TileItemsAdapter.this.cards.get(i)).setActivate(false);
                        }
                    }
                    TileItemsAdapter.this.notifyDataSetChanged();
                    if (tilesItem.getType().equalsIgnoreCase(Const.PDF)) {
                        ShowAllClassesFragment.this.fileType = "1";
                    } else if (tilesItem.getType().equalsIgnoreCase(Const.PPT)) {
                        ShowAllClassesFragment.this.fileType = "2";
                    } else if (tilesItem.getType().equalsIgnoreCase("video")) {
                        ShowAllClassesFragment.this.fileType = "3";
                    } else if (tilesItem.getType().equalsIgnoreCase(Const.EPUB)) {
                        ShowAllClassesFragment.this.fileType = "4";
                    } else if (tilesItem.getType().equalsIgnoreCase(Const.DOC)) {
                        ShowAllClassesFragment.this.fileType = "5";
                    } else if (tilesItem.getType().equalsIgnoreCase("image")) {
                        ShowAllClassesFragment.this.fileType = "6";
                    } else if (tilesItem.getType().equalsIgnoreCase(Const.CONCEPT)) {
                        ShowAllClassesFragment.this.fileType = "7";
                    } else if (tilesItem.getType().equalsIgnoreCase("link")) {
                        ShowAllClassesFragment.this.fileType = "8";
                    } else if (tilesItem.getType().equalsIgnoreCase(Const.TEST)) {
                        ShowAllClassesFragment.this.file_type_attributes = "t";
                        ShowAllClassesFragment.this.fileType = "t";
                    } else if (tilesItem.getType().equalsIgnoreCase(Const.SUBJECTIVE_TEST)) {
                        ShowAllClassesFragment.this.file_type_attributes = "st";
                        ShowAllClassesFragment.this.fileType = "st";
                    } else if (tilesItem.getType().equalsIgnoreCase(Const.Daily_assignment)) {
                        ShowAllClassesFragment.this.file_type_attributes = Const.CONTENT_daily_assign;
                        ShowAllClassesFragment.this.fileType = Const.CONTENT_daily_assign;
                    } else {
                        ShowAllClassesFragment.this.file_type_attributes = "0";
                        ShowAllClassesFragment.this.fileType = "0";
                    }
                    ShowAllClassesFragment.this.seleced_tile_list.clear();
                    ShowAllClassesFragment.this.custom_video_list.clear();
                    ShowAllClassesFragment.this.custom_link_list.clear();
                    if (tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW)) {
                        com.appnew.android.Model.Overview.Data data = (com.appnew.android.Model.Overview.Data) new Gson().fromJson(tilesItem.getMeta(), com.appnew.android.Model.Overview.Data.class);
                        ShowAllClassesFragment.this.overviewData = new OverviewData();
                        ShowAllClassesFragment.this.overviewData.setData(data);
                        ShowAllClassesFragment.this.examPrepItem = new ExamPrepItem();
                    } else {
                        try {
                            JSONArray jSONArray = new JSONObject(tilesItem.getMeta()).getJSONArray("list");
                            ArrayList<Lists> arrayList = new ArrayList<>();
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                arrayList.add((Lists) new Gson().fromJson(jSONArray.opt(i2).toString(), Lists.class));
                            }
                            ShowAllClassesFragment.this.examPrepItem.setList(arrayList);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    ShowAllClassesFragment.this.initSubjectAdapter(ShowAllClassesFragment.this.examPrepItem, tilesItem.getType(), ShowAllClassesFragment.this.cousedetail.getData().getCourseDetail());
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.cards.size();
        }
    }

    public class TileSubjectItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private ArrayList<Lists> cards;
        private Context context;
        CourseDetailData courseDetailData;
        private RecyclerView tileRv;
        String tileType;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public LinearLayout parent;
            public TextView tilesText;

            public MyViewHolder(View view) {
                super(view);
                this.tilesText = (TextView) view.findViewById(R.id.tilesTextTv);
                this.parent = (LinearLayout) view.findViewById(R.id.parentBottom);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(6, 0, 6, 0);
                this.parent.setLayoutParams(layoutParams);
                this.tilesText.setPadding(Math.round(Helper.convertDpToPixel(16, TileSubjectItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileSubjectItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(16, TileSubjectItemsAdapter.this.context)), Math.round(Helper.convertDpToPixel(8, TileSubjectItemsAdapter.this.context)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return this.tileType.equalsIgnoreCase(Const.OVERVIEW) ? 1 : 0;
        }

        public class OverViewHolder extends RecyclerView.ViewHolder {
            Button backBtn;
            RelativeLayout no_data_found_RL;
            RecyclerView recyclerView;

            OverViewHolder(View itemView) {
                super(itemView);
                this.recyclerView = (RecyclerView) itemView.findViewById(R.id.overviewRV);
                this.no_data_found_RL = (RelativeLayout) itemView.findViewById(R.id.no_data_found_RL);
                this.backBtn = (Button) itemView.findViewById(R.id.backBtn);
            }

            public void setData(CourseDetailData basic, OverviewData overview) {
                boolean z;
                boolean z2;
                if (overview != null) {
                    this.recyclerView.setVisibility(0);
                    this.no_data_found_RL.setVisibility(8);
                    if (overview.getData().getVisibility().equalsIgnoreCase("1")) {
                        z = false;
                        z2 = false;
                    } else if (overview.getData().getVisibility().equalsIgnoreCase("2")) {
                        z2 = false;
                        z = true;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    OverviewRVAdapter overviewRVAdapter = new OverviewRVAdapter(ShowAllClassesFragment.this.activity, basic, overview, this.recyclerView, z, z2);
                    this.recyclerView.setLayoutManager(new LinearLayoutManager(ShowAllClassesFragment.this.activity, 1, false));
                    this.recyclerView.setAdapter(overviewRVAdapter);
                    return;
                }
                this.recyclerView.setVisibility(8);
                this.no_data_found_RL.setVisibility(0);
                this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment.TileSubjectItemsAdapter.OverViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        ShowAllClassesFragment.this.activity.finish();
                    }
                });
            }
        }

        public TileSubjectItemsAdapter(Context context, ExamPrepItem examPrepItem, RecyclerView tileRv, String tileType, CourseDetailData courseDetailData) {
            this.cards = examPrepItem.getList();
            this.context = context;
            this.tileRv = tileRv;
            this.tileType = tileType;
            this.courseDetailData = courseDetailData;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == 0) {
                return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card_layout2, parent, false));
            }
            return new OverViewHolder(LayoutInflater.from(ShowAllClassesFragment.this.activity).inflate(R.layout.course_overview_layout, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final RecyclerView.ViewHolder holders, final int position) {
            if (getItemViewType(position) == 0) {
                MyViewHolder myViewHolder = (MyViewHolder) holders;
                final Lists lists = this.cards.get(position);
                myViewHolder.tilesText.setText(lists.getTitle());
                if (ShowAllClassesFragment.this.contentTypeSubjectID.equals(lists.getId())) {
                    this.cards.get(position).setActivated(true);
                }
                if (lists.isActivated()) {
                    myViewHolder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.round_bg_1));
                    myViewHolder.tilesText.setTextColor(this.context.getResources().getColor(R.color.whie));
                } else {
                    myViewHolder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.ronded_bg));
                    myViewHolder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
                }
                myViewHolder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ShowAllClassesFragment.TileSubjectItemsAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        ShowAllClassesFragment.this.file_type_attributes = "";
                        if (!"1".equalsIgnoreCase("6")) {
                            if (ShowAllClassesFragment.this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
                                ShowAllClassesFragment.this.contentTypeSubjectID = lists.getId();
                            }
                        } else {
                            ShowAllClassesFragment.this.contentTypeSubjectID = lists.getId();
                        }
                        ShowAllClassesFragment.this.seleced_tile_list.clear();
                        ShowAllClassesFragment.this.custom_video_list.clear();
                        ShowAllClassesFragment.this.custom_link_list.clear();
                        for (int i = 0; i < TileSubjectItemsAdapter.this.cards.size(); i++) {
                            if (i != position) {
                                ((Lists) TileSubjectItemsAdapter.this.cards.get(i)).setActivated(false);
                            }
                        }
                        TileSubjectItemsAdapter.this.notifyDataSetChanged();
                        for (Video video : ShowAllClassesFragment.this.videoArrayList) {
                            if (ShowAllClassesFragment.this.fileType.equalsIgnoreCase(video.getFile_type())) {
                                video.setIs_deleted(false);
                                ShowAllClassesFragment.this.seleced_tile_list.add(video);
                            }
                            if ("10".equalsIgnoreCase(video.getFile_type())) {
                                video.setIs_deleted(true);
                                ShowAllClassesFragment.this.custom_video_list.add(video);
                            }
                            if ("11".equalsIgnoreCase(video.getFile_type())) {
                                video.setIs_deleted(true);
                                ShowAllClassesFragment.this.custom_link_list.add(video);
                            }
                        }
                        if (!"1".equalsIgnoreCase("6")) {
                            if (ShowAllClassesFragment.this.fileType.equalsIgnoreCase("0")) {
                                ShowAllClassesFragment.this.InitTestAdapter(ShowAllClassesFragment.this.videoArrayList);
                                return;
                            }
                            if (ShowAllClassesFragment.this.fileType.equalsIgnoreCase("3")) {
                                ShowAllClassesFragment.this.seleced_tile_list.addAll(ShowAllClassesFragment.this.custom_video_list);
                                ShowAllClassesFragment.this.InitTestAdapter(ShowAllClassesFragment.this.seleced_tile_list);
                                return;
                            } else if (ShowAllClassesFragment.this.fileType.equalsIgnoreCase("8")) {
                                ShowAllClassesFragment.this.seleced_tile_list.addAll(ShowAllClassesFragment.this.custom_link_list);
                                ShowAllClassesFragment.this.InitTestAdapter(ShowAllClassesFragment.this.seleced_tile_list);
                                return;
                            } else {
                                ShowAllClassesFragment.this.InitTestAdapter(ShowAllClassesFragment.this.seleced_tile_list);
                                return;
                            }
                        }
                        ShowAllClassesFragment.this.mPage = 1;
                        ShowAllClassesFragment.this.status = false;
                        ShowAllClassesFragment.this.contentTypeSubjectID = ShowAllClassesFragment.this.examPrepItem.getList().get(position).getId();
                        ShowAllClassesFragment.this.hit_api_for_data(true);
                    }
                });
                return;
            }
            ((OverViewHolder) holders).setData(this.courseDetailData, ShowAllClassesFragment.this.overviewData);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.tileType.equalsIgnoreCase(Const.OVERVIEW)) {
                return 1;
            }
            return this.cards.size();
        }
    }

    private void initButton(CourseDetailData course) {
        this.cardsArrayList = new ArrayList<>();
        for (TilesItem tilesItem : this.cousedetail.getData().getTiles()) {
            if (!tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) && !tilesItem.getType().equalsIgnoreCase(Const.FAQ) && !tilesItem.getType().equalsIgnoreCase("content") && !tilesItem.getType().equalsIgnoreCase(Const.COMBO)) {
                this.cardsArrayList.add(tilesItem);
            }
        }
        if (course.getIsPurchased().equalsIgnoreCase("1")) {
            this.buttonLow.setVisibility(8);
        } else {
            if ((course == null || course.getSkip_payment() == null || !course.getSkip_payment().equalsIgnoreCase("1")) && this.cardsArrayList.size() > 0) {
                this.buttonLow.setVisibility(0);
            } else {
                this.buttonLow.setVisibility(8);
            }
            int i = (int) (Float.parseFloat(course.getMrp()) + Float.parseFloat(course.getTax()));
            if (i == 0) {
                this.mrpCutTV.setVisibility(8);
                this.priceLL.setVisibility(8);
                this.buyNowBtn.setVisibility(8);
                this.myLibBtn.setVisibility(0);
            } else {
                this.priceLL.setVisibility(0);
                this.myLibBtn.setVisibility(8);
                this.price.setText(String.format("%s %s %s", Constants.currencyType, "" + i, "/-"));
                setGstDesc(course);
                if (Integer.parseInt(course.getCourseSp()) > 0) {
                    this.mrpCutTV.setText(String.format("%s %s %s", Constants.currencyType, course.getCourseSp().trim(), "/-"), TextView.BufferType.SPANNABLE);
                    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                    Spannable spannable = (Spannable) this.mrpCutTV.getText();
                    if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                        this.mrpCutTV.setVisibility(0);
                    } else {
                        this.mrpCutTV.setVisibility(8);
                    }
                    spannable.setSpan(strikethroughSpan, 2, new String(course.getCourseSp()).length() + 2, 33);
                } else {
                    this.mrpCutTV.setVisibility(8);
                }
            }
        }
        if (this.cardsArrayList.size() > 0) {
            return;
        }
        this.no_data_found_RL.setVisibility(0);
        this.relativeL.setVisibility(8);
        this.relativeLL.setVisibility(8);
        this.subjectRecyclerView.setVisibility(8);
        this.buttonLow.setVisibility(8);
    }

    private void setGstDesc(CourseDetailData course) {
        if (course.getIs_gst() != null && !course.getIs_gst().equalsIgnoreCase("")) {
            if (course.getIs_gst().equalsIgnoreCase("0")) {
                this.tvGstDesc.setText(Constants.gstIncludedText);
            } else {
                this.tvGstDesc.setText(Constants.gstExcludedText);
                this.price.setText(String.format("%s %s %s", Constants.currencyType, "" + ((int) Float.parseFloat(course.getMrp())), "/-"));
            }
        } else {
            this.tvGstDesc.setText("N/A");
        }
        if (!TextUtils.isEmpty(course.getTax_rate()) && !course.getTax_rate().equalsIgnoreCase("0")) {
            this.tvGstDesc.setVisibility(0);
        } else {
            this.tvGstDesc.setVisibility(8);
        }
    }

    private void pushEventForFreeCourse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put("course_id", this.mainCourseId);
        map.put(AnalyticsConstants.course_name, "NA");
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.FREE_USER, map);
    }
}
