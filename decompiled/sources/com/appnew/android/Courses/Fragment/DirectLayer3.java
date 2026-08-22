package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.DirectLayer3Adapter;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter2;
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
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class DirectLayer3 extends MainFragment implements DirectLayer3Adapter.onButtonClicked, View.OnClickListener {
    public static String parentCourseId = "";
    public static String valid_to = "";
    TextView Course_name;
    DirectLayer3Adapter DirectLayer3Adapter;
    Activity activity;
    TextView authorname;
    Button backBtn;
    BottomSetting bottomSetting;
    RelativeLayout buttonLow;
    Button buyNowBtn;
    ArrayList<Courselist> courseDataArrayList;
    ImageView coursebg;
    TextView courseid;
    CourseDetail cousedetail;
    ExamPrepItem examPrepItem;
    ArrayList<FaqData> faqData;
    RelativeLayout headerLL;
    LinearLayout imageRL;
    LinearLayoutManager linearLayoutManager;
    String mainCourseId;
    TextView mrpCutTV;
    Button myLibBtn;
    RelativeLayout no_data_found_RL;
    OverviewData overviewData;
    TextView price;
    LinearLayout priceLL;
    String revertAPI;
    private ImageView searchIV;
    ExamPrepItem searchList;
    private SearchView searchView;
    SingleStudyAdapter2 singleStudyAdapter2;
    RecyclerView studyCourseRV;
    String tileIdAPI;
    LinearLayout tileLL;
    RecyclerView tileRv;
    String tileTypeAPI;
    TextView tvGstDesc;
    TextView type;
    String typeApi;
    private UtkashRoom utkashRoom;
    TextView validityTV;
    int tilePos = 0;
    public String allsubcatindex_id = "";
    String course_name = "";
    boolean isCombo = false;
    ArrayList<TilesItem> cardsArrayList = new ArrayList<>();
    private BroadcastReceiver videoDownloadReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.DirectLayer3.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("result", -1);
            String stringExtra = intent.getStringExtra("resourceId");
            if (intExtra != 1 || DirectLayer3.this.DirectLayer3Adapter == null || stringExtra == null || stringExtra.equals("") || !DirectLayer3.this.DirectLayer3Adapter.contentType.contains("video")) {
                return;
            }
            for (Lists lists : DirectLayer3.this.examPrepItem.getList()) {
                if (lists.getId().equalsIgnoreCase(stringExtra)) {
                    lists.setVideo_download(true);
                    lists.setVideo_status("Downloaded");
                    DirectLayer3.this.DirectLayer3Adapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    };
    String actication_key = "";
    String contentType = "";

    public static DirectLayer3 newInstance(String mainCourseId, boolean isCombo, String parentCourseId2, String course_name, String valid_to2, String allsubcatindex_id) {
        DirectLayer3 directLayer3 = new DirectLayer3();
        Bundle bundle = new Bundle();
        bundle.putString(Const.COURSE_ID_MAIN, mainCourseId);
        bundle.putString(Const.COURSE_PARENT_ID, parentCourseId2);
        bundle.putString(Const.SUB_CAT, allsubcatindex_id);
        bundle.putBoolean(Const.IS_COMBO, isCombo);
        bundle.putString("valid_to", valid_to2);
        bundle.putString(AnalyticsConstants.course_name, course_name);
        directLayer3.setArguments(bundle);
        return directLayer3;
    }

    public void checkPaymentMode() {
        if (this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getBottom(), BottomSetting.class);
        }
    }

    public void searchContent(String text) {
        ExamPrepItem examPrepItem = this.examPrepItem;
        if (examPrepItem == null || examPrepItem.getList() == null) {
            return;
        }
        ExamPrepItem examPrepItem2 = this.searchList;
        if (examPrepItem2 == null) {
            this.searchList = new ExamPrepItem();
        } else {
            examPrepItem2.getList().clear();
        }
        if (this.searchList != null) {
            ArrayList<Lists> arrayList = new ArrayList<>();
            ExamPrepItem examPrepItem3 = this.examPrepItem;
            if (examPrepItem3 != null && examPrepItem3.getList() != null) {
                for (Lists lists : this.examPrepItem.getList()) {
                    if (lists.getTitle() != null) {
                        if (lists.getTitle().trim().toLowerCase().contains(text.toLowerCase()) || lists.getTitle().trim().toUpperCase().contains(text.toUpperCase())) {
                            arrayList.add(lists);
                        }
                    } else if (lists.getDescription() != null && (Html.fromHtml(lists.getDescription()).toString().trim().toLowerCase().contains(text.toLowerCase()) || Html.fromHtml(lists.getDescription()).toString().trim().contains(text.toUpperCase()))) {
                        arrayList.add(lists);
                    }
                }
                this.searchList.setList(arrayList);
            }
        }
        ExamPrepItem examPrepItem4 = this.searchList;
        if (examPrepItem4 == null || examPrepItem4.getList() == null) {
            return;
        }
        if (this.searchList.getList().size() > 0) {
            this.DirectLayer3Adapter.sendlist(this.searchList);
            return;
        }
        if (text.isEmpty() || text.equalsIgnoreCase("")) {
            ExamPrepItem examPrepItem5 = this.examPrepItem;
            this.searchList = examPrepItem5;
            this.DirectLayer3Adapter.sendlist(examPrepItem5);
            return;
        }
        this.DirectLayer3Adapter.sendlist(this.searchList);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.headerLL = (RelativeLayout) view.findViewById(R.id.headerLL);
        this.searchView = (SearchView) getActivity().findViewById(R.id.sv_search);
        this.searchIV = (ImageView) getActivity().findViewById(R.id.searchIV);
        this.tileRv = (RecyclerView) view.findViewById(R.id.tileRv);
        this.imageRL = (LinearLayout) view.findViewById(R.id.imageRL);
        this.coursebg = (ImageView) view.findViewById(R.id.courseImagebg);
        this.Course_name = (TextView) view.findViewById(R.id.course_name);
        this.authorname = (TextView) view.findViewById(R.id.authorname);
        this.courseid = (TextView) view.findViewById(R.id.courseid);
        this.type = (TextView) view.findViewById(R.id.type);
        this.validityTV = (TextView) view.findViewById(R.id.validityTV);
        this.tvGstDesc = (TextView) view.findViewById(R.id.tv_gstDesc);
        this.studyCourseRV = (RecyclerView) view.findViewById(R.id.studyCourseRV);
        this.mrpCutTV = (TextView) view.findViewById(R.id.mrpCutTV);
        this.price = (TextView) view.findViewById(R.id.priceTV);
        this.buyNowBtn = (Button) view.findViewById(R.id.buyNowBtn);
        this.myLibBtn = (Button) view.findViewById(R.id.myLibBtn);
        this.buttonLow = (RelativeLayout) view.findViewById(R.id.buttonLow);
        this.priceLL = (LinearLayout) view.findViewById(R.id.priceLL);
        this.tileLL = (LinearLayout) view.findViewById(R.id.tileLL);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.backBtn = (Button) view.findViewById(R.id.backBtn);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity, 1, false);
        this.linearLayoutManager = linearLayoutManager;
        this.studyCourseRV.setLayoutManager(linearLayoutManager);
        this.studyCourseRV.setHasFixedSize(true);
        SharedPreference.getInstance().remove(Const.SINGLE_STUDY);
        this.buyNowBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.buy_now));
        this.buyNowBtn.setOnClickListener(this);
        this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.DirectLayer3$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$0();
            }
        }));
        ((CourseActivity) this.activity).shareIV.setVisibility(8);
        ((CourseActivity) this.activity).shareIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.DirectLayer3$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$1();
            }
        }));
        ((CourseActivity) this.activity).setToolbarTitle(this.course_name);
        if ("1".equalsIgnoreCase("7")) {
            this.tileRv.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_bg_tile_theme8));
        }
        if (this.utkashRoom == null) {
            this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        }
        checkPaymentMode();
        if (this.utkashRoom.getCourseDetaildata() != null) {
            if (!this.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + this.mainCourseId)) {
                NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
                return;
            }
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
                courseDetailData.setIsPurchased("1");
                courseDetailData.setViewType(list.get(0).getView_type());
                courseDetailData.setIs_combo(list.get(0).getIs_combo());
                courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                courseDetailData.setCat_type(list.get(0).getCat_type());
                courseDetailData.setHide_validity(list.get(0).getHide_validity());
                courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
                courseDetailData.setIs_activated(list.get(0).getIs_activated());
                courseDetailData.setToken_activation(list.get(0).getToken_activation());
                courseDetailData.setTxn_id(list.get(0).getTxn_id());
                courseDetailData.setInstallment(list.get(0).getInstallment());
                courseDetailData.setIs_gst(list.get(0).getIs_gst());
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
                    return;
                }
                if (courseDetailData.getIsPurchased().equalsIgnoreCase("1") && courseDetailData.getToken_activation().equalsIgnoreCase("1")) {
                    if (courseDetailData.getIsPurchased().equalsIgnoreCase("1") && courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                        showCustomDialog();
                        return;
                    } else {
                        initButton(this.cousedetail.getData().getCourseDetail());
                        callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                        return;
                    }
                }
                initButton(this.cousedetail.getData().getCourseDetail());
                callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                return;
            }
            this.utkashRoom.getCourseDetaildata().deletecoursedetail(parentCourseId, MakeMyExam.userId);
            NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$0() {
        this.activity.finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onViewCreated$1() {
        Helper.shareCourse(this.activity, this.mainCourseId, String.valueOf(this.isCombo), parentCourseId, this.course_name, this.cousedetail.getData().getCourseDetail().getDescHeaderImage(), this.cousedetail.getData().getCourseDetail().getTitle());
        return null;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        Constants.revison_set = false;
        if (getArguments() != null) {
            this.isCombo = getArguments().getBoolean(Const.IS_COMBO);
            parentCourseId = getArguments().getString(Const.COURSE_PARENT_ID);
            this.allsubcatindex_id = getArguments().getString(Const.SUB_CAT);
            this.course_name = getArguments().getString(AnalyticsConstants.course_name);
            valid_to = getArguments().getString("valid_to");
            this.mainCourseId = getArguments().getString(Const.COURSE_ID_MAIN);
        }
        if (!Helper.isNetworkConnected(this.activity) || SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW) == null) {
            return;
        }
        NetworkAPICall(API.user_video_view_data, "", false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        DirectLayer3 directLayer3;
        String string;
        super.onResume();
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.videoDownloadReceiver, new IntentFilter(VideoDownloadService.VIDEO_DOWNLOAD_ACTION));
        if (Constants.revison_set) {
            directLayer3 = this;
            directLayer3.NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            Constants.revison_set = false;
        } else {
            directLayer3 = this;
        }
        if (!Constants.REMAININGTIME.equalsIgnoreCase("")) {
            for (int i = 0; i < directLayer3.examPrepItem.getList().size(); i++) {
                if (directLayer3.examPrepItem.getList().get(i).getId().equalsIgnoreCase(Constants.REMAININGTIME.split("_")[1])) {
                    directLayer3.examPrepItem.getList().get(i).setRemaining_time(Constants.REMAININGTIME.split("_")[0]);
                }
            }
            directLayer3.DirectLayer3Adapter.sendlist(directLayer3.examPrepItem);
            Constants.REMAININGTIME = "";
        }
        if (getView() == null || (string = SharedPreference.getInstance().getString("DEFERRED_RESULT_MSG")) == null || string.isEmpty()) {
            return;
        }
        Snackbar.make(getView(), string, 0).show();
        SharedPreference.getInstance().remove("DEFERRED_RESULT_MSG");
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.videoDownloadReceiver);
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this.activity);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_course_activation);
        dialog.setCancelable(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = -2;
        layoutParams.height = -2;
        final EditText editText = (EditText) dialog.findViewById(R.id.et_post);
        ((Button) dialog.findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.DirectLayer3.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                dialog.dismiss();
                DirectLayer3.this.activity.onBackPressed();
            }
        });
        ((Button) dialog.findViewById(R.id.btn_submit)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.DirectLayer3.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DirectLayer3.this.actication_key = editText.getText().toString();
                if (DirectLayer3.this.actication_key.isEmpty()) {
                    Toast.makeText(DirectLayer3.this.activity, DirectLayer3.this.activity.getResources().getString(R.string.please_enter_activation_key), 0).show();
                } else {
                    dialog.dismiss();
                    DirectLayer3.this.NetworkAPICall(API.API_activate_course, "", true, false, false);
                }
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_direct_layer, container, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "https://appapi.videocrypt.in/index.php/data_model/course/user_video_view_data":
                HashMap<String, String> hashMapdata = SharedPreference.getInstance().getHashMapdata(Const.API_UPDATE_VIDEO_VIEW);
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setUser_id(MakeMyExam.getUserId());
                encryptionData.setVideo_id(hashMapdata.get(Const.VIDEO_ID));
                encryptionData.setTile_id(hashMapdata.get("tile_id"));
                encryptionData.setCourse_id(hashMapdata.get("course_id"));
                encryptionData.setType(hashMapdata.get(Const.VIDEO_TYPE));
                encryptionData.setStart_time(hashMapdata.get(Const.StartTime));
                encryptionData.setTotal_time(hashMapdata.get(Const.TOTAL_TIME));
                encryptionData.setPlatform(hashMapdata.get("platform"));
                encryptionData.setRemaining_time(hashMapdata.get(Const.remaining_time));
                encryptionData.setEnd_time(hashMapdata.get(Const.ENDTime));
                encryptionData.setStart_time(hashMapdata.get(Const.StartTime));
                encryptionData.setView_time(hashMapdata.get(Const.VIEW_TIME));
                return service.user_video_view_data(AES.encrypt(new Gson().toJson(encryptionData)));
            case "data_model/course/activate_course":
                EncryptionData encryptionData2 = new EncryptionData();
                encryptionData2.setCourse_id(this.mainCourseId);
                encryptionData2.setActivation_key(this.actication_key);
                return service.API_activate_course(AES.encrypt(new Gson().toJson(encryptionData2)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/update_video_view_time":
                HashMap<String, String> hashMapdata2 = SharedPreference.getInstance().getHashMapdata(Const.API_VIDEO_VIEW_TIME);
                EncryptionData encryptionData3 = new EncryptionData();
                encryptionData3.setUser_id(MakeMyExam.getUserId());
                encryptionData3.setVideo_id(hashMapdata2.get(Const.VIDEO_ID));
                encryptionData3.setTile_id(hashMapdata2.get("tile_id"));
                encryptionData3.setType(hashMapdata2.get(Const.VIDEO_TYPE));
                encryptionData3.setStart_time(hashMapdata2.get(Const.StartTime));
                encryptionData3.setCourse_id(hashMapdata2.get("course_id"));
                encryptionData3.setTotal_time(hashMapdata2.get(Const.TOTAL_TIME));
                encryptionData3.setView_time(hashMapdata2.get(Const.VIEW_TIME));
                return service.update_video_view_time(AES.encrypt(new Gson().toJson(encryptionData3)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_master_data":
                String str = this.revertAPI.split("\\#")[1];
                if (typeApi.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI) || typeApi.equalsIgnoreCase(Const.FAQ + this.tileIdAPI) || typeApi.equalsIgnoreCase(Const.COMBO + this.tileIdAPI)) {
                    EncryptionData encryptionData4 = new EncryptionData();
                    encryptionData4.setTile_id(this.tileIdAPI);
                    encryptionData4.setType(this.tileTypeAPI);
                    encryptionData4.setRevert_api(this.revertAPI);
                    encryptionData4.setCourse_id(this.mainCourseId);
                    encryptionData4.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    return service.getMasterDataOverviewFAQ(AES.encrypt(new Gson().toJson(encryptionData4)));
                }
                if (str.equalsIgnoreCase("1")) {
                    EncryptionData encryptionData5 = new EncryptionData();
                    encryptionData5.setTile_id(this.tileIdAPI);
                    encryptionData5.setType(this.tileTypeAPI);
                    encryptionData5.setRevert_api(this.revertAPI);
                    encryptionData5.setCourse_id(this.mainCourseId);
                    encryptionData5.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    encryptionData5.setLayer("2");
                    encryptionData5.setSubject_id("0");
                    encryptionData5.setPage("1");
                    return service.getMasterDataVideoTwo(AES.encrypt(new Gson().toJson(encryptionData5)));
                }
                if (str.equalsIgnoreCase("3")) {
                    EncryptionData encryptionData6 = new EncryptionData();
                    encryptionData6.setTile_id(this.tileIdAPI);
                    encryptionData6.setType(this.tileTypeAPI);
                    encryptionData6.setRevert_api(this.revertAPI);
                    encryptionData6.setCourse_id(this.mainCourseId);
                    encryptionData6.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    encryptionData6.setLayer("3");
                    encryptionData6.setSubject_id("0");
                    encryptionData6.setTopic_id("0");
                    encryptionData6.setPage("1");
                    return service.getMasterDataVideoThree(AES.encrypt(new Gson().toJson(encryptionData6)));
                }
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setTile_id(this.tileIdAPI);
                encryptionData7.setType(this.tileTypeAPI);
                encryptionData7.setRevert_api(this.revertAPI);
                encryptionData7.setCourse_id(this.mainCourseId);
                encryptionData7.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                encryptionData7.setLayer("1");
                encryptionData7.setPage("1");
                return service.getMasterDataVideo(AES.encrypt(new Gson().toJson(encryptionData7)));
            case "https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction":
                EncryptionData encryptionData8 = new EncryptionData();
                encryptionData8.setCourse_id(this.cousedetail.getData().getCourseDetail().getId());
                encryptionData8.setCoupon_applied("0");
                encryptionData8.setParent_id(parentCourseId);
                return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData8)));
            case "https://appapi.videocrypt.in/index.php/data_model/course_deprecated/get_course_detail":
                EncryptionData encryptionData9 = new EncryptionData();
                encryptionData9.setCourse_id(this.mainCourseId);
                encryptionData9.setParent_id(parentCourseId);
                return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData9)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        char c2;
        DirectLayer3 directLayer3 = this;
        Gson gson = new Gson();
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -1175877907:
                if (apitype.equals(API.user_video_view_data)) {
                    b2 = 0;
                }
                break;
            case -887421682:
                if (apitype.equals(API.API_activate_course)) {
                    b2 = 1;
                }
                break;
            case -685656370:
                if (apitype.equals(API.update_video_view_time)) {
                    b2 = 2;
                }
                break;
            case -171058627:
                if (apitype.equals(API.API_GET_MASTER_DATA)) {
                    b2 = 3;
                }
                break;
            case 114126311:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                    b2 = 4;
                }
                break;
            case 750643905:
                if (apitype.equals(API.CourseDetail_JS)) {
                    b2 = 5;
                }
                break;
        }
        switch (b2) {
            case 0:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        SharedPreference.getInstance().saveHashMap(Const.API_UPDATE_VIDEO_VIEW, null);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 1:
                if (jsonobject.optString("status").equals("true")) {
                    directLayer3.utkashRoom.getCourseDetaildata().updaterecord(directLayer3.mainCourseId, MakeMyExam.userId, "1");
                    directLayer3.initButton(directLayer3.cousedetail.getData().getCourseDetail());
                    directLayer3.callForData(directLayer3.cousedetail.getData().getTiles(), directLayer3.cousedetail.getData().getCourseDetail().getIsPurchased());
                    Toast.makeText(directLayer3.activity, jsonobject.optString("message"), 0).show();
                } else {
                    Toast.makeText(directLayer3.activity, jsonobject.optString("message"), 0).show();
                    new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.DirectLayer3.4
                        @Override // java.lang.Runnable
                        public void run() {
                            DirectLayer3.this.activity.onBackPressed();
                        }
                    }, 2000L);
                }
                break;
            case 2:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        SharedPreference.getInstance().saveHashMap(Const.API_VIDEO_VIEW_TIME, null);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case 3:
                String str = directLayer3.revertAPI.split("\\#")[1];
                if (jsonobject.optString("status").equals("true")) {
                    if (typeApi.equalsIgnoreCase(Const.OVERVIEW + directLayer3.tileIdAPI)) {
                        com.appnew.android.Model.Overview.Data data = (com.appnew.android.Model.Overview.Data) gson.fromJson(jsonobject.optString("data"), com.appnew.android.Model.Overview.Data.class);
                        OverviewData overviewData = new OverviewData();
                        directLayer3.overviewData = overviewData;
                        overviewData.setData(data);
                        directLayer3.examPrepItem = new ExamPrepItem();
                        directLayer3.courseDataArrayList = new ArrayList<>();
                        ArrayList<FaqData> arrayList = new ArrayList<>();
                        directLayer3.faqData = arrayList;
                        directLayer3.InitTestAdapter(directLayer3.cousedetail, directLayer3.examPrepItem, directLayer3.overviewData, directLayer3.courseDataArrayList, arrayList, typeApi, str);
                    } else if (typeApi.equalsIgnoreCase(Const.FAQ + directLayer3.tileIdAPI)) {
                        JSONArray jSONArrayOptJSONArray = jsonobject.optJSONArray("data");
                        directLayer3.faqData = new ArrayList<>();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            directLayer3.faqData.add((FaqData) gson.fromJson(jSONArrayOptJSONArray.opt(i).toString(), FaqData.class));
                        }
                        directLayer3.overviewData = new OverviewData();
                        directLayer3.examPrepItem = new ExamPrepItem();
                        ArrayList<Courselist> arrayList2 = new ArrayList<>();
                        directLayer3.courseDataArrayList = arrayList2;
                        directLayer3.InitTestAdapter(directLayer3.cousedetail, directLayer3.examPrepItem, directLayer3.overviewData, arrayList2, directLayer3.faqData, typeApi, str);
                    } else if (typeApi.equalsIgnoreCase(Const.COMBO + directLayer3.tileIdAPI)) {
                        JSONArray jSONArrayOptJSONArray2 = jsonobject.optJSONArray("data");
                        directLayer3.courseDataArrayList = new ArrayList<>();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            directLayer3.courseDataArrayList.add((Courselist) gson.fromJson(jSONArrayOptJSONArray2.opt(i2).toString(), Courselist.class));
                        }
                        directLayer3.faqData = new ArrayList<>();
                        directLayer3.examPrepItem = new ExamPrepItem();
                        OverviewData overviewData2 = new OverviewData();
                        directLayer3.overviewData = overviewData2;
                        directLayer3.InitTestAdapter(directLayer3.cousedetail, directLayer3.examPrepItem, overviewData2, directLayer3.courseDataArrayList, directLayer3.faqData, typeApi, str);
                    } else {
                        directLayer3.examPrepItem = (ExamPrepItem) gson.fromJson(jsonobject.optString("data"), ExamPrepItem.class);
                        directLayer3.overviewData = new OverviewData();
                        directLayer3.courseDataArrayList = new ArrayList<>();
                        directLayer3.faqData = new ArrayList<>();
                        if (str.equalsIgnoreCase("3")) {
                            for (Lists lists : directLayer3.examPrepItem.getList()) {
                                if (lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("3") && lists.getVideo_type() != null && lists.getVideo_type().equalsIgnoreCase("6") && !directLayer3.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                                    if (directLayer3.utkashRoom.getvideoDownloadao().isvideo_exit(lists.getId(), MakeMyExam.userId)) {
                                        VideosDownload videosDownload = directLayer3.utkashRoom.getvideoDownloadao().getvideo_byuserid(lists.getId(), MakeMyExam.userId);
                                        if (videosDownload.getToal_downloadlocale() != null) {
                                            if (lists.getIs_download_available().equalsIgnoreCase("1") && videosDownload.getVideo_status().equalsIgnoreCase("")) {
                                                lists.setVideo_status("Download");
                                            } else {
                                                lists.setVideo_status(videosDownload.getVideo_status());
                                            }
                                            lists.setVideo_time(videosDownload.getVideotime());
                                            lists.setVideo_download(videosDownload.getIs_complete().equalsIgnoreCase("1"));
                                            lists.setVideo_currentpos(videosDownload.getVideoCurrentPosition());
                                        }
                                    } else if (lists.getIs_download_available().equalsIgnoreCase("1")) {
                                        lists.setVideo_status("Download");
                                        lists.setVideo_download(false);
                                        lists.setVideo_currentpos(0L);
                                    } else {
                                        lists.setVideo_status("");
                                        lists.setVideo_download(false);
                                        lists.setVideo_currentpos(0L);
                                    }
                                }
                            }
                        }
                        directLayer3.InitTestAdapter(directLayer3.cousedetail, directLayer3.examPrepItem, directLayer3.overviewData, directLayer3.courseDataArrayList, directLayer3.faqData, typeApi, str);
                    }
                } else {
                    if (!str.equalsIgnoreCase("3")) {
                        directLayer3.faqData = new ArrayList<>();
                        directLayer3.overviewData = new OverviewData();
                        directLayer3.examPrepItem = new ExamPrepItem();
                        ArrayList<Courselist> arrayList3 = new ArrayList<>();
                        directLayer3.courseDataArrayList = arrayList3;
                        directLayer3.InitTestAdapter(directLayer3.cousedetail, directLayer3.examPrepItem, directLayer3.overviewData, arrayList3, directLayer3.faqData, typeApi, str);
                    }
                    if (!GenericUtils.isEmpty(jsonobject.optString("auth_code"))) {
                        RetrofitResponse.GetApiData(directLayer3.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                    }
                }
                break;
            case 4:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        directLayer3.utkashRoom.getCourseDetaildata().deletecoursedetail(directLayer3.cousedetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                        Toast.makeText(directLayer3.activity, "" + jsonobject.optString("message"), 0).show();
                        directLayer3.pushEventForFreeCourse();
                        Intent intent = new Intent(directLayer3.activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, !parentCourseId.equalsIgnoreCase("") ? parentCourseId : directLayer3.cousedetail.getData().getCourseDetail().getId());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(AnalyticsConstants.course_name, directLayer3.cousedetail.getData().getCourseDetail().getTitle());
                        Helper.gotoActivity_finish(intent, directLayer3.activity);
                    } else {
                        Toast.makeText(directLayer3.activity, "" + jsonobject.optString("message"), 0).show();
                        RetrofitResponse.GetApiData(directLayer3.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
            case 5:
                if (jsonobject.optString("status").equals("true")) {
                    directLayer3.studyCourseRV.setVisibility(0);
                    directLayer3.no_data_found_RL.setVisibility(8);
                    JSONObject jSONObjectOptJSONObject = jsonobject.optJSONObject("data");
                    if (!directLayer3.utkashRoom.getuserwisecourse().is_api_code_exits(MakeMyExam.userId, jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                        UserWiseCourseTable userWiseCourseTable = new UserWiseCourseTable();
                        userWiseCourseTable.setUserid(MakeMyExam.userId);
                        userWiseCourseTable.setCode("ut_011");
                        userWiseCourseTable.setVersion("0.000");
                        userWiseCourseTable.setExp(String.valueOf(MakeMyExam.getTime_server()));
                        userWiseCourseTable.setMeta_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                        directLayer3.utkashRoom.getuserwisecourse().addUser(userWiseCourseTable);
                    }
                    if (directLayer3.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                        c2 = 1;
                    } else {
                        int i3 = 0;
                        while (true) {
                            c2 = 1;
                            if (i3 < jSONObjectOptJSONObject.getJSONArray("tiles").length()) {
                                CourseDetailTable courseDetailTable = new CourseDetailTable();
                                courseDetailTable.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                courseDetailTable.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                                courseDetailTable.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
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
                                courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "id"));
                                courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "meta"));
                                courseDetailTable.setUser_id(MakeMyExam.userId);
                                if (jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).has("thumbnail")) {
                                    courseDetailTable.setThumbnail(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).getString("thumbnail"));
                                }
                                courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, Const.REVERT_API));
                                courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "tile_name"));
                                courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "type"));
                                courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "set_as_demo"));
                                courseDetailTable.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                                courseDetailTable.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
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
                                courseDetailTable.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                if (jsonobject.optJSONObject("data").optJSONObject("subscription_all_data") != null) {
                                    courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject("data").optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                                }
                                directLayer3 = this;
                                directLayer3.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
                                i3++;
                            }
                        }
                    }
                    List<CourseDetailTable> list = directLayer3.utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + directLayer3.mainCourseId, MakeMyExam.userId);
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
                        courseDetailData.setId(list.get(0).getCourse_id().split("_")[c2]);
                        courseDetailData.setCourseSp(list.get(0).getCourse_sp());
                        courseDetailData.setDescHeaderImage(list.get(0).getDesc_header_image());
                        courseDetailData.setIsPurchased("1");
                        courseDetailData.setViewType(list.get(0).getView_type());
                        courseDetailData.setIs_combo(list.get(0).getIs_combo());
                        courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                        courseDetailData.setCat_type(list.get(0).getCat_type());
                        courseDetailData.setHide_validity(list.get(0).getHide_validity());
                        courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
                        courseDetailData.setIs_activated(list.get(0).getIs_activated());
                        courseDetailData.setToken_activation(list.get(0).getToken_activation());
                        courseDetailData.setTxn_id(list.get(0).getTxn_id());
                        courseDetailData.setInstallment(list.get(0).getInstallment());
                        courseDetailData.setIs_gst(list.get(0).getIs_gst());
                        courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
                        courseDetailData.setCombo_has_book(list.get(0).getCombo_has_book());
                        courseDetailData.setTax_rate(list.get(0).getTax_rate());
                        directLayer3.cousedetail = new CourseDetail();
                        Data data2 = new Data();
                        data2.setCourseDetail(courseDetailData);
                        if (list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                            data2.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                        }
                        ArrayList arrayList4 = new ArrayList();
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            arrayList4.add(new TilesItem(list.get(i4).getTile_revert(), list.get(i4).getTile_title(), list.get(i4).getTile_id(), list.get(i4).getType(), list.get(i4).getTile_meta(), list.get(i4).getSet_as_demo(), list.get(i4).getThumbnail()));
                        }
                        data2.setTiles(arrayList4);
                        directLayer3.cousedetail.setData(data2);
                        if (((CourseActivity) directLayer3.activity).is_coupon) {
                            Intent intent2 = new Intent(directLayer3.activity, (Class<?>) PurchaseActivity.class);
                            intent2.putExtra(Const.SINGLE_STUDY, directLayer3.cousedetail);
                            intent2.putExtra(Const.IS_BOOK, directLayer3.cousedetail.getData().getCourseDetail().getCat_type());
                            intent2.putExtra(Const.DELIVERY_CHARGE, directLayer3.cousedetail.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent2, directLayer3.activity);
                        } else if (courseDetailData.getIsPurchased().equalsIgnoreCase("1") && courseDetailData.getToken_activation().equalsIgnoreCase("1")) {
                            if (courseDetailData.getIsPurchased().equalsIgnoreCase("1") && courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                                directLayer3.showCustomDialog();
                            } else {
                                directLayer3.initButton(directLayer3.cousedetail.getData().getCourseDetail());
                                directLayer3.callForData(directLayer3.cousedetail.getData().getTiles(), directLayer3.cousedetail.getData().getCourseDetail().getIsPurchased());
                            }
                        } else {
                            directLayer3.initButton(directLayer3.cousedetail.getData().getCourseDetail());
                            directLayer3.callForData(directLayer3.cousedetail.getData().getTiles(), directLayer3.cousedetail.getData().getCourseDetail().getIsPurchased());
                        }
                        break;
                    }
                } else {
                    directLayer3.studyCourseRV.setVisibility(8);
                    directLayer3.no_data_found_RL.setVisibility(0);
                    RetrofitResponse.GetApiData(directLayer3.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                    break;
                }
                break;
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        RecyclerView recyclerView;
        if (!apitype.equalsIgnoreCase(API.CourseDetail_JS) || (recyclerView = this.studyCourseRV) == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
    }

    public void callForData(List<TilesItem> tiles, String ispurchased) {
        String str;
        String str2;
        if (ispurchased.equalsIgnoreCase("0")) {
            if (tiles != null && tiles.size() >= 1) {
                int i = 0;
                while (true) {
                    if (i >= tiles.size()) {
                        str2 = "";
                        i = 0;
                        break;
                    } else {
                        if (tiles.get(i).getId().equals(this.contentType)) {
                            str2 = tiles.get(i).getType() + tiles.get(i).getId();
                            break;
                        }
                        i++;
                    }
                }
                if (str2.equalsIgnoreCase("")) {
                    callAdapterData1(tiles, null, 0);
                    return;
                } else {
                    callAdapterData1(tiles, null, i);
                    return;
                }
            }
            this.faqData = new ArrayList<>();
            this.overviewData = new OverviewData();
            this.examPrepItem = new ExamPrepItem();
            ArrayList<Courselist> arrayList = new ArrayList<>();
            this.courseDataArrayList = arrayList;
            InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList, this.faqData, Const.NO_DATA, "0");
            return;
        }
        if (tiles != null && tiles.size() >= 1) {
            int i2 = 0;
            while (true) {
                if (i2 >= tiles.size()) {
                    str = "";
                    i2 = 0;
                    break;
                } else {
                    if (tiles.get(i2).getId().equals(this.contentType)) {
                        str = tiles.get(i2).getType() + tiles.get(i2).getId();
                        break;
                    }
                    i2++;
                }
            }
            if (str.equalsIgnoreCase("")) {
                callAdapterData1(tiles, null, 0);
                return;
            } else {
                callAdapterData1(tiles, null, i2);
                return;
            }
        }
        this.faqData = new ArrayList<>();
        this.overviewData = new OverviewData();
        this.examPrepItem = new ExamPrepItem();
        ArrayList<Courselist> arrayList2 = new ArrayList<>();
        this.courseDataArrayList = arrayList2;
        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList2, this.faqData, Const.NO_DATA, "0");
    }

    public void callAdapterData1(List<TilesItem> tiles, TilesItem cards, int pos) {
        TilesItem tilesItem;
        int i = 0;
        this.searchView.setQuery("", false);
        Gson gson = new Gson();
        this.tilePos = pos;
        if (cards != null) {
            this.tileTypeAPI = cards.getType();
            this.tileIdAPI = cards.getId();
            this.revertAPI = cards.getRevertApi();
            this.typeApi = cards.getType() + cards.getId();
            tilesItem = cards;
        } else {
            this.tileTypeAPI = tiles.get(pos).getType();
            this.tileIdAPI = tiles.get(pos).getId();
            this.revertAPI = tiles.get(pos).getRevertApi();
            this.typeApi = tiles.get(pos).getType() + tiles.get(pos).getId();
            tilesItem = tiles.get(pos);
        }
        String str = this.revertAPI.split("\\#")[1];
        if (this.typeApi.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI)) {
            com.appnew.android.Model.Overview.Data data = (com.appnew.android.Model.Overview.Data) gson.fromJson(tilesItem.getMeta(), com.appnew.android.Model.Overview.Data.class);
            OverviewData overviewData = new OverviewData();
            this.overviewData = overviewData;
            overviewData.setData(data);
            this.examPrepItem = new ExamPrepItem();
            this.courseDataArrayList = new ArrayList<>();
            ArrayList<FaqData> arrayList = new ArrayList<>();
            this.faqData = arrayList;
            InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, arrayList, this.typeApi, str);
            return;
        }
        if (this.typeApi.equalsIgnoreCase(Const.COMBO + this.tileIdAPI)) {
            try {
                JSONArray jSONArray = new JSONObject(tilesItem.getMeta()).getJSONArray("list");
                this.courseDataArrayList = new ArrayList<>();
                while (i < jSONArray.length()) {
                    this.courseDataArrayList.add((Courselist) gson.fromJson(jSONArray.opt(i).toString(), Courselist.class));
                    i++;
                }
                this.faqData = new ArrayList<>();
                this.examPrepItem = new ExamPrepItem();
                OverviewData overviewData2 = new OverviewData();
                this.overviewData = overviewData2;
                InitTestAdapter(this.cousedetail, this.examPrepItem, overviewData2, this.courseDataArrayList, this.faqData, this.typeApi, str);
                return;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (this.typeApi.equalsIgnoreCase(Const.FAQ + this.tileIdAPI)) {
            try {
                JSONArray jSONArray2 = new JSONObject(tilesItem.getMeta()).getJSONArray("list");
                this.faqData = new ArrayList<>();
                while (i < jSONArray2.length()) {
                    this.faqData.add((FaqData) gson.fromJson(jSONArray2.opt(i).toString(), FaqData.class));
                    i++;
                }
                this.overviewData = new OverviewData();
                this.examPrepItem = new ExamPrepItem();
                ArrayList<Courselist> arrayList2 = new ArrayList<>();
                this.courseDataArrayList = arrayList2;
                InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList2, this.faqData, this.typeApi, str);
                return;
            } catch (JSONException e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (str.equalsIgnoreCase("3")) {
            NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            return;
        }
        this.examPrepItem = new ExamPrepItem();
        this.overviewData = new OverviewData();
        this.courseDataArrayList = new ArrayList<>();
        this.faqData = new ArrayList<>();
        if (str.equalsIgnoreCase("3")) {
            for (Lists lists : this.examPrepItem.getList()) {
                if (lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("3") && lists.getVideo_type() != null && lists.getVideo_type().equalsIgnoreCase("6") && !this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
                    if (this.utkashRoom.getvideoDownloadao().isvideo_exit(lists.getId(), MakeMyExam.userId)) {
                        VideosDownload videosDownload = this.utkashRoom.getvideoDownloadao().getvideo_byuserid(lists.getId(), MakeMyExam.userId);
                        if (videosDownload.getToal_downloadlocale() != null) {
                            if (lists.getIs_download_available().equalsIgnoreCase("1") && videosDownload.getVideo_status().equalsIgnoreCase("")) {
                                lists.setVideo_status("Download");
                            } else {
                                lists.setVideo_status(videosDownload.getVideo_status());
                            }
                            lists.setVideo_time(videosDownload.getVideotime());
                            lists.setVideo_download(videosDownload.getIs_complete().equalsIgnoreCase("1"));
                            lists.setVideo_currentpos(videosDownload.getVideoCurrentPosition());
                        }
                    } else if (lists.getIs_download_available().equalsIgnoreCase("1")) {
                        lists.setVideo_status("Download");
                        lists.setVideo_download(false);
                        lists.setVideo_currentpos(0L);
                    } else {
                        lists.setVideo_status("");
                        lists.setVideo_download(false);
                        lists.setVideo_currentpos(0L);
                    }
                }
            }
        }
        if (str.equalsIgnoreCase("1")) {
            try {
                JSONObject jSONObject = new JSONObject(tilesItem.getMeta());
                if (jSONObject.getJSONArray("list").length() > 0) {
                    JSONArray jSONArray3 = jSONObject.getJSONArray("list");
                    ArrayList<Lists> arrayList3 = new ArrayList<>();
                    for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                        if (jSONArray3.optJSONObject(i2).getJSONArray("list").length() > 0) {
                            for (int i3 = 0; i3 < jSONArray3.optJSONObject(i2).getJSONArray("list").length(); i3++) {
                                arrayList3.add((Lists) gson.fromJson(jSONArray3.optJSONObject(i2).getJSONArray("list").get(i3).toString(), Lists.class));
                            }
                        }
                    }
                    this.examPrepItem.setList(arrayList3);
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        } else {
            try {
                JSONArray jSONArray4 = new JSONObject(tilesItem.getMeta()).getJSONArray("list");
                ArrayList<Lists> arrayList4 = new ArrayList<>();
                for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                    arrayList4.add((Lists) gson.fromJson(jSONArray4.opt(i4).toString(), Lists.class));
                }
                this.examPrepItem.setList(arrayList4);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            if (str.equalsIgnoreCase("0")) {
                try {
                    JSONObject jSONObject2 = new JSONObject(tilesItem.getMeta());
                    if (jSONObject2.getJSONArray("list").length() > 0) {
                        JSONArray jSONArray5 = jSONObject2.getJSONArray("list");
                        for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                            ArrayList<Lists> arrayList5 = new ArrayList<>();
                            if (jSONArray5.optJSONObject(i5).getJSONArray("list").length() > 0) {
                                for (int i6 = 0; i6 < jSONArray5.optJSONObject(i5).getJSONArray("list").length(); i6++) {
                                    arrayList5.add((Lists) gson.fromJson(jSONArray5.optJSONObject(i5).getJSONArray("list").get(i6).toString(), Lists.class));
                                }
                            }
                            this.examPrepItem.getList().get(i5).setList(arrayList5);
                        }
                    }
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
            }
        }
        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, this.typeApi, str);
    }

    public void callForData(List<TilesItem> tiles) {
        if (tiles != null && tiles.size() >= 1) {
            callAdapterData1(tiles, null, 0);
            return;
        }
        this.faqData = new ArrayList<>();
        this.overviewData = new OverviewData();
        this.examPrepItem = new ExamPrepItem();
        ArrayList<Courselist> arrayList = new ArrayList<>();
        this.courseDataArrayList = arrayList;
        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList, this.faqData, Const.NO_DATA, "0");
    }

    @Override // com.appnew.android.Courses.Adapter.DirectLayer3Adapter.onButtonClicked
    public void onTitleClicked(TilesItem cards, List<TilesItem> tiles, int tilePos) {
        callAdapterData1(tiles, cards, tilePos);
    }

    private void InitTestAdapter(CourseDetail cousedetail, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, String type, String isSkip) {
        try {
            if (Constants.is_Show_Search.equalsIgnoreCase("1")) {
                if (examPrepItem != null && examPrepItem.getList() != null) {
                    ((CourseActivity) this.activity).searchIV.setVisibility(0);
                } else {
                    ((CourseActivity) this.activity).searchIV.setVisibility(8);
                }
            }
            DirectLayer3Adapter directLayer3Adapter = new DirectLayer3Adapter(this.activity, cousedetail, examPrepItem, overviewData, courseDataArrayList, faqData, this, parentCourseId, this.isCombo, isSkip, this.tilePos, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, createVideoList(examPrepItem));
            this.DirectLayer3Adapter = directLayer3Adapter;
            directLayer3Adapter.contentType = type;
            this.studyCourseRV.setNestedScrollingEnabled(false);
            ((CourseActivity) this.activity).setToolbarTitle(this.course_name);
            Helper.setMargins(((CourseActivity) this.activity).shareIV, 0, 0, 16, 0);
        } catch (Exception unused) {
        }
    }

    private void initButton(CourseDetailData course) {
        setDataHeader(this.cousedetail);
        if ("1".equals("7") && this.cardsArrayList.size() == 1) {
            this.tileLL.setVisibility(8);
        } else {
            this.tileLL.setVisibility(0);
        }
        if (!this.isCombo) {
            if (course.getIsPurchased().equalsIgnoreCase("1")) {
                this.buttonLow.setVisibility(8);
                return;
            }
            if (course != null && course.getSkip_payment() != null && course.getSkip_payment().equalsIgnoreCase("1")) {
                this.buttonLow.setVisibility(8);
            } else {
                this.buttonLow.setVisibility(0);
            }
            int i = (int) (Float.parseFloat(course.getMrp()) + Float.parseFloat(course.getTax()));
            if (i == 0) {
                this.buyNowBtn.setVisibility(8);
                this.mrpCutTV.setVisibility(8);
                this.priceLL.setVisibility(8);
                this.myLibBtn.setVisibility(0);
                this.myLibBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.DirectLayer3$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.onClick(view);
                    }
                });
                return;
            }
            this.buyNowBtn.setVisibility(0);
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
                return;
            }
            this.mrpCutTV.setVisibility(8);
            return;
        }
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.buyNowBtn) {
            if (id != R.id.myLibBtn) {
                return;
            }
            NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false, false);
        } else {
            Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
            intent.putExtra(Const.SINGLE_STUDY, this.cousedetail);
            intent.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
            intent.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
            Helper.gotoActivity(intent, this.activity);
        }
    }

    public void setDataHeader(CourseDetail singleStudy) {
        if (singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
            this.headerLL.setBackgroundColor(this.activity.getResources().getColor(R.color.white));
            this.imageRL.setVisibility(8);
        } else {
            this.headerLL.setBackgroundColor(this.activity.getResources().getColor(R.color.colorPrimaryDark));
            this.imageRL.setVisibility(0);
            if (!TextUtils.isEmpty(singleStudy.getData().getCourseDetail().getDescHeaderImage())) {
                Helper.setThumbnailImage(this.activity, singleStudy.getData().getCourseDetail().getDescHeaderImage(), this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.coursebg);
            } else {
                this.coursebg.setImageResource(R.mipmap.square_placeholder);
            }
            if (singleStudy.getData().getCourseDetail() != null) {
                this.Course_name.setText(singleStudy.getData().getCourseDetail().getTitle());
                if (!GenericUtils.isEmpty(singleStudy.getData().getCourseDetail().getAuthor().getTitle()) && !singleStudy.getData().getCourseDetail().getAuthor().getTitle().equalsIgnoreCase("Utkarsh classes")) {
                    this.authorname.setText(this.activity.getResources().getString(R.string.by) + singleStudy.getData().getCourseDetail().getAuthor().getTitle());
                } else {
                    this.authorname.setText(this.activity.getResources().getString(R.string.by) + this.activity.getResources().getString(R.string.app_name));
                }
                if (singleStudy.getData().getCourseDetail().getValidity().equals("") || singleStudy.getData().getCourseDetail().getValidity().equals("0") || singleStudy.getData().getCourseDetail().getValidity().equalsIgnoreCase("0 Days") || singleStudy.getData().getCourseDetail().getValidity().equals("-1") || singleStudy.getData().getCourseDetail().getValidity().equalsIgnoreCase("-1 Days")) {
                    this.validityTV.setVisibility(8);
                } else {
                    this.validityTV.setVisibility(0);
                }
                this.validityTV.setText(this.activity.getResources().getString(R.string.validity_) + singleStudy.getData().getCourseDetail().getValidity());
                this.courseid.setText(singleStudy.getData().getCourseDetail().getId());
                if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("0")) {
                    this.type.setText(this.activity.getResources().getString(R.string.online));
                } else if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("1")) {
                    this.type.setText(this.activity.getResources().getString(R.string.offline));
                } else if (singleStudy.getData().getCourseDetail().getViewType().equalsIgnoreCase("2")) {
                    this.type.setText(this.activity.getResources().getString(R.string.package_));
                }
            }
        }
        this.cardsArrayList.clear();
        if (singleStudy.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("1")) {
            for (TilesItem tilesItem : singleStudy.getData().getTiles()) {
                if (!tilesItem.getType().equalsIgnoreCase(Const.OVERVIEW) && !tilesItem.getType().equalsIgnoreCase(Const.FAQ) && !tilesItem.getType().equalsIgnoreCase("content") && !tilesItem.getType().equalsIgnoreCase(Const.COMBO)) {
                    this.cardsArrayList.add(tilesItem);
                }
            }
        } else {
            Iterator<TilesItem> it = singleStudy.getData().getTiles().iterator();
            while (it.hasNext()) {
                this.cardsArrayList.add(it.next());
            }
        }
        ArrayList<TilesItem> arrayList = this.cardsArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.contentType = this.cardsArrayList.get(0).getType() + this.cardsArrayList.get(0).getId();
        }
        TileItemsAdapter tileItemsAdapter = new TileItemsAdapter(this.activity, this.cardsArrayList);
        this.tileRv.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        this.tileRv.setAdapter(tileItemsAdapter);
        this.tileRv.setNestedScrollingEnabled(false);
        this.tileRv.scrollToPosition(this.tilePos);
        if ("1".equals("7")) {
            if (this.cardsArrayList.size() == 1) {
                this.tileLL.setVisibility(8);
            } else {
                this.tileLL.setVisibility(0);
            }
        }
    }

    public class TileItemsAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<TilesItem> cards;
        private Context context;

        public TileItemsAdapter(Context context, ArrayList<TilesItem> cards) {
            this.cards = cards;
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final TilesItem tilesItem = this.cards.get(position);
            if (tilesItem != null && !TextUtils.isEmpty(tilesItem.getType()) && tilesItem.getType().equalsIgnoreCase(Const.LIVE_VIDEO)) {
                try {
                    holder.liveIv.setVisibility(0);
                    Glide.with(DirectLayer3.this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(holder.liveIv);
                } catch (Exception unused) {
                    holder.liveIv.setVisibility(8);
                }
                holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(4, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
            } else {
                holder.liveIv.setVisibility(8);
                holder.tilesText.setPadding(Math.round(Helper.convertDpToPixel(16, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)), Math.round(Helper.convertDpToPixel(16, this.context)), Math.round(Helper.convertDpToPixel(8, this.context)));
            }
            holder.tilesText.setText(tilesItem.getTileName());
            if (DirectLayer3.this.contentType.equals(tilesItem.getType() + tilesItem.getId())) {
                if (!"1".equalsIgnoreCase("7")) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(DirectLayer3.this.activity.getResources().getColor(R.color.colorPrimaryDark));
                    gradientDrawable.setCornerRadius(0.0f);
                    holder.parent.setBackground(gradientDrawable);
                    holder.tilesText.setTextColor(-1);
                } else {
                    holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.round_bg_1));
                    holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.whie));
                }
            } else if (!"1".equalsIgnoreCase("7")) {
                holder.parent.setBackground(DirectLayer3.this.activity.getResources().getDrawable(R.drawable.bg_tile_unselected));
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.country_code_text_color));
            } else {
                holder.parent.setBackground(this.context.getResources().getDrawable(R.drawable.round_bg_normal));
                holder.tilesText.setTextColor(this.context.getResources().getColor(R.color.colorPrimary));
            }
            holder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.DirectLayer3$TileItemsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(tilesItem, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(TilesItem tilesItem, int i, View view) {
            DirectLayer3.this.contentType = tilesItem.getType() + tilesItem.getId();
            DirectLayer3.this.tilePos = i;
            DirectLayer3 directLayer3 = DirectLayer3.this;
            directLayer3.callAdapterData1(directLayer3.cousedetail.getData().getTiles(), tilesItem, DirectLayer3.this.tilePos);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View viewInflate;
            if ("1".equalsIgnoreCase("7")) {
                viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_tiles_theme8, parent, false);
            } else {
                viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_tiles, parent, false);
            }
            return new MyViewHolder(viewInflate);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView liveIv;
            public LinearLayout parent;
            public TextView tilesText;

            public MyViewHolder(View view) {
                super(view);
                this.tilesText = (TextView) view.findViewById(R.id.tilesTextTv);
                this.parent = (LinearLayout) view.findViewById(R.id.parentBottom);
                this.liveIv = (ImageView) view.findViewById(R.id.liveIV);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(6, 0, 6, 0);
                this.parent.setLayoutParams(layoutParams);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.cards.size();
        }
    }

    private ArrayList<Video> createVideoList(ExamPrepItem examPrepItem) {
        try {
            ArrayList<Video> arrayList = new ArrayList<>();
            Gson gson = new Gson();
            Iterator<Lists> it = examPrepItem.getList().iterator();
            while (it.hasNext()) {
                arrayList.add((Video) gson.fromJson(gson.toJson(it.next()), Video.class));
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void pushEventForFreeCourse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put("course_id", this.cousedetail.getData().getCourseDetail().getId());
        map.put(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.FREE_USER, map);
    }
}
