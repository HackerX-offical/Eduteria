package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.SingleStudyAdapter3;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.EncryptionModel.EncryptionData;
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
public class SingleStudy2 extends MainFragment implements SingleStudyAdapter3.onButtonClicked, View.OnClickListener {
    public static String parentCourseId = "";
    public static String tile_id = "";
    public static String valid_to = "";
    Activity activity;
    Button backBtn;
    RelativeLayout buttonLow;
    Button buyNowBtn;
    ArrayList<Courselist> courseDataArrayList;
    CourseDetail cousedetail;
    ExamPrepItem examPrepItem;
    ArrayList<FaqData> faqData;
    LinearLayoutManager linearLayoutManager;
    String mainCourseId;
    TextView mrpCutTV;
    Button myLibBtn;
    RelativeLayout no_data_found_RL;
    OverviewData overviewData;
    TextView price;
    LinearLayout priceLL;
    String revertAPI;
    ExamPrepItem searchList;
    SingleStudyAdapter3 singleStudyAdapter3;
    RecyclerView studyCourseRV;
    String tileIdAPI;
    String tileTypeAPI;
    TextView tvGstDesc;
    String typeApi;
    private UtkashRoom utkashRoom;
    int tilePos = 0;
    String course_name = "";
    boolean isCombo = false;
    String isContentCombo = "";
    String actication_key = "";
    private BroadcastReceiver videoDownloadReceiver = new BroadcastReceiver() { // from class: com.appnew.android.Courses.Fragment.SingleStudy2.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("result", -1);
            String stringExtra = intent.getStringExtra("resourceId");
            if (intExtra != 1 || SingleStudy2.this.singleStudyAdapter3 == null || stringExtra == null || stringExtra.equals("") || !SingleStudy2.this.singleStudyAdapter3.contentType.contains("video")) {
                return;
            }
            for (Lists lists : SingleStudy2.this.examPrepItem.getList()) {
                if (lists.getId().equalsIgnoreCase(stringExtra)) {
                    lists.setVideo_download(true);
                    lists.setVideo_status("Downloaded");
                    SingleStudy2.this.singleStudyAdapter3.notifyDataSetChanged();
                    return;
                }
            }
        }
    };
    public int type2 = 2;

    public static SingleStudy2 newInstance(String mainCourseId, boolean isCombo, String parentCourseId2, String course_name, String valid_to2, String tile_id2, String isContentCombo) {
        SingleStudy2 singleStudy2 = new SingleStudy2();
        Bundle bundle = new Bundle();
        bundle.putString(Const.COURSE_ID_MAIN, mainCourseId);
        bundle.putString(Const.COURSE_PARENT_ID, parentCourseId2);
        bundle.putBoolean(Const.IS_COMBO, isCombo);
        bundle.putString("valid_to", valid_to2);
        bundle.putString(AnalyticsConstants.course_name, course_name);
        bundle.putString("tile_id", tile_id2);
        bundle.putString(Const.IS_CONTENT_COMBO, isContentCombo);
        singleStudy2.setArguments(bundle);
        return singleStudy2;
    }

    public void searchContent(String text) {
        Boolean bool = false;
        if (text.isEmpty() && bool.booleanValue()) {
            Boolean.valueOf(false);
        }
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
        ExamPrepItem examPrepItem3 = this.searchList;
        if (examPrepItem3 == null || examPrepItem3.getList() == null) {
            return;
        }
        if (this.searchList.getList().size() > 0) {
            this.singleStudyAdapter3.sendlist(this.searchList);
            return;
        }
        if (text.isEmpty() || text.equalsIgnoreCase("")) {
            ExamPrepItem examPrepItem4 = this.examPrepItem;
            this.searchList = examPrepItem4;
            this.singleStudyAdapter3.sendlist(examPrepItem4);
            return;
        }
        this.singleStudyAdapter3.sendlist(this.searchList);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.studyCourseRV = (RecyclerView) view.findViewById(R.id.studyCourseRV);
        this.mrpCutTV = (TextView) view.findViewById(R.id.mrpCutTV);
        this.tvGstDesc = (TextView) view.findViewById(R.id.tv_gstDesc);
        this.price = (TextView) view.findViewById(R.id.priceTV);
        this.buyNowBtn = (Button) view.findViewById(R.id.buyNowBtn);
        this.myLibBtn = (Button) view.findViewById(R.id.myLibBtn);
        this.buttonLow = (RelativeLayout) view.findViewById(R.id.buttonLow);
        this.priceLL = (LinearLayout) view.findViewById(R.id.priceLL);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.backBtn = (Button) view.findViewById(R.id.backBtn);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity, 1, false);
        this.linearLayoutManager = linearLayoutManager;
        this.studyCourseRV.setLayoutManager(linearLayoutManager);
        this.studyCourseRV.setHasFixedSize(true);
        SharedPreference.getInstance().remove(Const.SINGLE_STUDY);
        this.buyNowBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.buy_now));
        this.buyNowBtn.setOnClickListener(this);
        this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.SingleStudy2$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$0();
            }
        }));
        ((CourseActivity) this.activity).shareIV.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.SingleStudy2$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onViewCreated$1();
            }
        }));
        if (this.utkashRoom == null) {
            this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        }
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
                courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
                courseDetailData.setViewType(list.get(0).getView_type());
                courseDetailData.setIs_activated(list.get(0).getIs_activated());
                courseDetailData.setToken_activation(list.get(0).getToken_activation());
                courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                courseDetailData.setInstallment(list.get(0).getInstallment());
                courseDetailData.setIs_gst(list.get(0).getIs_gst());
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
        dialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showCustomDialog$2(dialog, view);
            }
        });
        dialog.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showCustomDialog$3(editText, dialog, view);
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCustomDialog$2(Dialog dialog, View view) {
        dialog.dismiss();
        this.activity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCustomDialog$3(EditText editText, Dialog dialog, View view) {
        String string = editText.getText().toString();
        this.actication_key = string;
        if (string.isEmpty()) {
            Activity activity = this.activity;
            Toast.makeText(activity, activity.getResources().getString(R.string.please_enter_activation_key), 0).show();
        } else {
            dialog.dismiss();
            NetworkAPICall(API.API_activate_course, "", true, false, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        Constants.revison_set = false;
        if (getArguments() != null) {
            this.isCombo = getArguments().getBoolean(Const.IS_COMBO);
            parentCourseId = getArguments().getString(Const.COURSE_PARENT_ID);
            this.course_name = getArguments().getString(AnalyticsConstants.course_name);
            valid_to = getArguments().getString("valid_to");
            tile_id = getArguments().getString("tile_id");
            this.mainCourseId = getArguments().getString(Const.COURSE_ID_MAIN);
            this.isContentCombo = getArguments().getString(Const.IS_CONTENT_COMBO);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        SingleStudy2 singleStudy2;
        super.onResume();
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.videoDownloadReceiver, new IntentFilter(VideoDownloadService.VIDEO_DOWNLOAD_ACTION));
        if (Constants.revison_set) {
            singleStudy2 = this;
            singleStudy2.NetworkAPICall(API.API_GET_MASTER_DATA, this.typeApi, true, false, false);
            Constants.revison_set = false;
        } else {
            singleStudy2 = this;
        }
        if (!Constants.REMAININGTIME.equalsIgnoreCase("")) {
            for (int i = 0; i < singleStudy2.examPrepItem.getList().size(); i++) {
                if (singleStudy2.examPrepItem.getList().get(i).getId().equalsIgnoreCase(Constants.REMAININGTIME.split("_")[1])) {
                    singleStudy2.examPrepItem.getList().get(i).setRemaining_time(Constants.REMAININGTIME.split("_")[0]);
                }
            }
            singleStudy2.singleStudyAdapter3.sendlist(singleStudy2.examPrepItem);
            Constants.REMAININGTIME = "";
        }
        if (Constants.REFRESHPAGE.equals("true")) {
            Constants.REFRESHPAGE = "false";
            singleStudy2.NetworkAPICall(API.API_GET_MASTER_DATA, singleStudy2.typeApi, true, false, false);
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.videoDownloadReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_single_study, container, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        switch (apitype) {
            case "data_model/course/activate_course":
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setCourse_id(this.mainCourseId);
                encryptionData.setActivation_key(this.actication_key);
                return service.API_activate_course(AES.encrypt(new Gson().toJson(encryptionData)));
            case "https://appapi.videocrypt.in/index.php/data_model/course/get_master_data":
                String str = this.revertAPI.split("\\#")[1];
                if (typeApi.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI) || typeApi.equalsIgnoreCase(Const.FAQ + this.tileIdAPI) || typeApi.equalsIgnoreCase(Const.COMBO + this.tileIdAPI)) {
                    EncryptionData encryptionData2 = new EncryptionData();
                    encryptionData2.setTile_id(this.tileIdAPI);
                    encryptionData2.setType(this.tileTypeAPI);
                    encryptionData2.setRevert_api(this.revertAPI);
                    encryptionData2.setCourse_id(this.mainCourseId);
                    encryptionData2.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    return service.getMasterDataOverviewFAQ(AES.encrypt(new Gson().toJson(encryptionData2)));
                }
                if (str.equalsIgnoreCase("1")) {
                    EncryptionData encryptionData3 = new EncryptionData();
                    encryptionData3.setTile_id(this.tileIdAPI);
                    encryptionData3.setType(this.tileTypeAPI);
                    encryptionData3.setRevert_api(this.revertAPI);
                    encryptionData3.setCourse_id(this.mainCourseId);
                    encryptionData3.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    encryptionData3.setLayer("2");
                    encryptionData3.setSubject_id("0");
                    encryptionData3.setPage("1");
                    return service.getMasterDataVideoTwo(AES.encrypt(new Gson().toJson(encryptionData3)));
                }
                if (str.equalsIgnoreCase("3")) {
                    EncryptionData encryptionData4 = new EncryptionData();
                    encryptionData4.setTile_id(this.tileIdAPI);
                    encryptionData4.setType(this.tileTypeAPI);
                    encryptionData4.setRevert_api(this.revertAPI);
                    encryptionData4.setCourse_id(this.mainCourseId);
                    encryptionData4.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                    encryptionData4.setLayer("3");
                    encryptionData4.setSubject_id("0");
                    encryptionData4.setTopic_id("0");
                    encryptionData4.setPage("1");
                    return service.getMasterDataVideoThree(AES.encrypt(new Gson().toJson(encryptionData4)));
                }
                EncryptionData encryptionData5 = new EncryptionData();
                encryptionData5.setTile_id(this.tileIdAPI);
                encryptionData5.setType(this.tileTypeAPI);
                encryptionData5.setRevert_api(this.revertAPI);
                encryptionData5.setCourse_id(this.mainCourseId);
                encryptionData5.setParent_id(parentCourseId.equals("") ? this.cousedetail.getData().getCourseDetail().getId() : parentCourseId);
                encryptionData5.setLayer("1");
                encryptionData5.setPage("1");
                return service.getMasterDataVideo(AES.encrypt(new Gson().toJson(encryptionData5)));
            case "https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction":
                EncryptionData encryptionData6 = new EncryptionData();
                encryptionData6.setCourse_id(this.cousedetail.getData().getCourseDetail().getId());
                encryptionData6.setCoupon_applied("0");
                encryptionData6.setParent_id(parentCourseId);
                return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData6)));
            case "https://appapi.videocrypt.in/index.php/data_model/course_deprecated/get_course_detail":
                EncryptionData encryptionData7 = new EncryptionData();
                encryptionData7.setCourse_id(this.mainCourseId);
                encryptionData7.setParent_id(parentCourseId);
                return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData7)));
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Gson gson = new Gson();
        apitype.hashCode();
        byte b2 = -1;
        switch (apitype.hashCode()) {
            case -887421682:
                if (apitype.equals(API.API_activate_course)) {
                    b2 = 0;
                }
                break;
            case -171058627:
                if (apitype.equals(API.API_GET_MASTER_DATA)) {
                    b2 = 1;
                }
                break;
            case 114126311:
                if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                    b2 = 2;
                }
                break;
            case 750643905:
                if (apitype.equals(API.CourseDetail_JS)) {
                    b2 = 3;
                }
                break;
        }
        String str = "1";
        switch (b2) {
            case 0:
                if (jsonobject.optString("status").equals("true")) {
                    this.utkashRoom.getCourseDetaildata().updaterecord(this.mainCourseId, MakeMyExam.userId, "1");
                    initButton(this.cousedetail.getData().getCourseDetail());
                    callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                } else {
                    Toast.makeText(this.activity, jsonobject.optString("message"), 0).show();
                    new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.SingleStudy2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SingleStudy2.this.activity.onBackPressed();
                        }
                    }, 2000L);
                }
                break;
            case 1:
                String str2 = this.revertAPI.split("\\#")[1];
                if (jsonobject.optString("status").equals("true")) {
                    if (typeApi.equalsIgnoreCase(Const.OVERVIEW + this.tileIdAPI)) {
                        com.appnew.android.Model.Overview.Data data = (com.appnew.android.Model.Overview.Data) gson.fromJson(jsonobject.optString("data"), com.appnew.android.Model.Overview.Data.class);
                        OverviewData overviewData = new OverviewData();
                        this.overviewData = overviewData;
                        overviewData.setData(data);
                        this.examPrepItem = new ExamPrepItem();
                        this.courseDataArrayList = new ArrayList<>();
                        ArrayList<FaqData> arrayList = new ArrayList<>();
                        this.faqData = arrayList;
                        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, arrayList, typeApi, str2);
                    } else if (typeApi.equalsIgnoreCase(Const.FAQ + this.tileIdAPI)) {
                        JSONArray jSONArrayOptJSONArray = jsonobject.optJSONArray("data");
                        this.faqData = new ArrayList<>();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            this.faqData.add((FaqData) gson.fromJson(jSONArrayOptJSONArray.opt(i).toString(), FaqData.class));
                        }
                        this.overviewData = new OverviewData();
                        this.examPrepItem = new ExamPrepItem();
                        ArrayList<Courselist> arrayList2 = new ArrayList<>();
                        this.courseDataArrayList = arrayList2;
                        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList2, this.faqData, typeApi, str2);
                    } else if (typeApi.equalsIgnoreCase(Const.COMBO + this.tileIdAPI)) {
                        JSONArray jSONArrayOptJSONArray2 = jsonobject.optJSONArray("data");
                        this.courseDataArrayList = new ArrayList<>();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            this.courseDataArrayList.add((Courselist) gson.fromJson(jSONArrayOptJSONArray2.opt(i2).toString(), Courselist.class));
                        }
                        this.faqData = new ArrayList<>();
                        this.examPrepItem = new ExamPrepItem();
                        OverviewData overviewData2 = new OverviewData();
                        this.overviewData = overviewData2;
                        InitTestAdapter(this.cousedetail, this.examPrepItem, overviewData2, this.courseDataArrayList, this.faqData, typeApi, str2);
                    } else {
                        this.examPrepItem = (ExamPrepItem) gson.fromJson(jsonobject.optString("data"), ExamPrepItem.class);
                        this.overviewData = new OverviewData();
                        this.courseDataArrayList = new ArrayList<>();
                        this.faqData = new ArrayList<>();
                        if (str2.equalsIgnoreCase("3")) {
                            for (Lists lists : this.examPrepItem.getList()) {
                                if ((lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("3") && lists.getVideo_type() != null && lists.getVideo_type().equalsIgnoreCase("6")) || (lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("3") && lists.getVideo_type() != null && (lists.getVideo_type().equalsIgnoreCase("7") || (lists.getVideo_type().equalsIgnoreCase("9") && lists.getFile_url() != null && !lists.getFile_url().equalsIgnoreCase(""))))) {
                                    if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
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
                        }
                        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, this.courseDataArrayList, this.faqData, typeApi, str2);
                    }
                } else {
                    if (!str2.equalsIgnoreCase("3")) {
                        this.faqData = new ArrayList<>();
                        this.overviewData = new OverviewData();
                        this.examPrepItem = new ExamPrepItem();
                        ArrayList<Courselist> arrayList3 = new ArrayList<>();
                        this.courseDataArrayList = arrayList3;
                        InitTestAdapter(this.cousedetail, this.examPrepItem, this.overviewData, arrayList3, this.faqData, typeApi, str2);
                    }
                    if (!GenericUtils.isEmpty(jsonobject.optString("auth_code"))) {
                        RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
                    }
                }
                break;
            case 2:
                try {
                    if (jsonobject.optString("status").equals("true")) {
                        this.utkashRoom.getCourseDetaildata().deletecoursedetail(this.cousedetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                        Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                        pushEventForFreeCourse();
                        Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, !parentCourseId.equalsIgnoreCase("") ? parentCourseId : this.cousedetail.getData().getCourseDetail().getId());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
                        Helper.gotoActivity_finish(intent, this.activity);
                    } else {
                        Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                        RetrofitResponse.GetApiData(this.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case 3:
                if (jsonobject.optString("status").equals("true")) {
                    this.studyCourseRV.setVisibility(0);
                    this.no_data_found_RL.setVisibility(8);
                    JSONObject jSONObjectOptJSONObject = jsonobject.optJSONObject("data");
                    String str3 = "id";
                    if (!this.utkashRoom.getuserwisecourse().is_api_code_exits(MakeMyExam.userId, jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                        UserWiseCourseTable userWiseCourseTable = new UserWiseCourseTable();
                        userWiseCourseTable.setUserid(MakeMyExam.userId);
                        userWiseCourseTable.setCode("ut_011");
                        userWiseCourseTable.setVersion("0.000");
                        userWiseCourseTable.setExp(String.valueOf(MakeMyExam.getTime_server()));
                        userWiseCourseTable.setMeta_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                        this.utkashRoom.getuserwisecourse().addUser(userWiseCourseTable);
                    }
                    if (!this.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                        int i3 = 0;
                        while (i3 < jSONObjectOptJSONObject.getJSONArray("tiles").length()) {
                            CourseDetailTable courseDetailTable = new CourseDetailTable();
                            courseDetailTable.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                            courseDetailTable.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str3));
                            courseDetailTable.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                            courseDetailTable.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                            courseDetailTable.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                            courseDetailTable.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                            courseDetailTable.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                            courseDetailTable.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                            courseDetailTable.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
                            courseDetailTable.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                            courseDetailTable.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                            courseDetailTable.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                            courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, str3));
                            courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "meta"));
                            courseDetailTable.setUser_id(MakeMyExam.userId);
                            courseDetailTable.setTile_revert(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).getString(Const.REVERT_API));
                            courseDetailTable.setTile_title(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).getString("tile_name"));
                            courseDetailTable.setType(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).getString("type"));
                            String str4 = str3;
                            if (jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).has("set_as_demo")) {
                                courseDetailTable.setSet_as_demo(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).getString("set_as_demo"));
                            }
                            String str5 = str;
                            if (jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).has("thumbnail")) {
                                courseDetailTable.setThumbnail(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i3).getString("thumbnail"));
                            }
                            courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, Const.REVERT_API));
                            courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "tile_name"));
                            courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "type"));
                            courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i3, "set_as_demo"));
                            courseDetailTable.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                            courseDetailTable.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                            courseDetailTable.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                            courseDetailTable.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                            if (jsonobject.optJSONObject("data").optJSONObject("subscription_all_data") != null) {
                                courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject("data").optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                            }
                            this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
                            i3++;
                            str3 = str4;
                            str = str5;
                        }
                    }
                    String str6 = str;
                    List<CourseDetailTable> list = this.utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + this.mainCourseId, MakeMyExam.userId);
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
                        courseDetailData.setIs_activated(list.get(0).getIs_activated());
                        courseDetailData.setToken_activation(list.get(0).getToken_activation());
                        courseDetailData.setInstallment(list.get(0).getInstallment());
                        courseDetailData.setIs_gst(list.get(0).getIs_gst());
                        this.cousedetail = new CourseDetail();
                        Data data2 = new Data();
                        data2.setCourseDetail(courseDetailData);
                        if (list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                            data2.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                        }
                        ArrayList arrayList4 = new ArrayList();
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            if (!list.get(i4).getType().equalsIgnoreCase(Const.OVERVIEW)) {
                                arrayList4.add(new TilesItem(list.get(i4).getTile_revert(), list.get(i4).getTile_title(), list.get(i4).getTile_id(), list.get(i4).getType(), list.get(i4).getTile_meta(), list.get(i4).getSet_as_demo(), list.get(i4).getThumbnail()));
                            }
                        }
                        data2.setTiles(arrayList4);
                        this.cousedetail.setData(data2);
                        if (((CourseActivity) this.activity).is_coupon) {
                            Intent intent2 = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                            intent2.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                            intent2.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                            intent2.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                            Helper.gotoActivity(intent2, this.activity);
                        } else if (courseDetailData.getIsPurchased().equalsIgnoreCase(str6) && courseDetailData.getToken_activation().equalsIgnoreCase(str6)) {
                            if (courseDetailData.getIsPurchased().equalsIgnoreCase(str6) && courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                                showCustomDialog();
                            } else {
                                initButton(this.cousedetail.getData().getCourseDetail());
                                callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                            }
                        } else {
                            initButton(this.cousedetail.getData().getCourseDetail());
                            callForData(this.cousedetail.getData().getTiles(), this.cousedetail.getData().getCourseDetail().getIsPurchased());
                        }
                        break;
                    }
                } else {
                    this.studyCourseRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
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
                        if (tiles.get(i).getId().equals(tile_id)) {
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
                    if (tiles.get(i2).getId().equals(tile_id)) {
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

    @Override // com.appnew.android.Courses.Adapter.SingleStudyAdapter3.onButtonClicked
    public void onTitleClicked(TilesItem cards, List<TilesItem> tiles, int tilePos) {
        callAdapterData1(tiles, cards, tilePos);
    }

    public void callAdapterData1(List<TilesItem> tiles, TilesItem cards, int pos) {
        TilesItem tilesItem;
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
        int i = 0;
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
                if (lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("3") && lists.getVideo_type() != null && (lists.getVideo_type().equalsIgnoreCase("6") || (lists.getVideo_type().equalsIgnoreCase("9") && lists.getFile_url() != null && !lists.getFile_url().equalsIgnoreCase("")))) {
                    if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
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

    private void InitTestAdapter(CourseDetail cousedetail, ExamPrepItem examPrepItem, OverviewData overviewData, ArrayList<Courselist> courseDataArrayList, ArrayList<FaqData> faqData, String type, String isSkip) {
        if (Constants.is_Show_Search.equalsIgnoreCase("1")) {
            if (examPrepItem != null && examPrepItem.getList() != null) {
                ((CourseActivity) this.activity).searchIV.setVisibility(0);
            } else {
                ((CourseActivity) this.activity).searchIV.setVisibility(8);
            }
        }
        if (this.isContentCombo.equals("0") && this.tileTypeAPI.equalsIgnoreCase(Const.COMBO)) {
            Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY2);
            intent.putExtra(Const.COURSE_ID_MAIN, courseDataArrayList.get(0).getId());
            intent.putExtra(Const.COURSE_PARENT_ID, cousedetail.getData().getCourseDetail().getId());
            intent.putExtra(Const.IS_COMBO, true);
            intent.putExtra("valid_to", cousedetail.getData().getCourseDetail().getValid_to());
            intent.putExtra(AnalyticsConstants.course_name, courseDataArrayList.get(0).getTitle());
            Helper.gotoActivity(intent, this.activity);
            this.activity.finish();
            return;
        }
        if (examPrepItem != null) {
            try {
                if (examPrepItem.getList() != null) {
                    for (Lists lists : examPrepItem.getList()) {
                        if (lists.getFile_type() != null && lists.getFile_type().equalsIgnoreCase("3") && lists.getVideo_type() != null && (lists.getVideo_type().equalsIgnoreCase("6") || (lists.getVideo_type().equalsIgnoreCase("9") && lists.getFile_url() != null && !lists.getFile_url().equalsIgnoreCase("")))) {
                            if (!this.utkashRoom.getOpenHelper().getWritableDatabase().isDbLockedByCurrentThread()) {
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
                }
            } catch (Exception unused) {
                return;
            }
        }
        SingleStudyAdapter3 singleStudyAdapter3 = new SingleStudyAdapter3(this.activity, cousedetail, examPrepItem, overviewData, courseDataArrayList, faqData, this, parentCourseId, this.isCombo, isSkip, this.tilePos, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, this.mainCourseId);
        this.singleStudyAdapter3 = singleStudyAdapter3;
        singleStudyAdapter3.contentType = type;
        this.studyCourseRV.setVisibility(0);
        this.studyCourseRV.setAdapter(this.singleStudyAdapter3);
        this.studyCourseRV.setNestedScrollingEnabled(false);
        ((CourseActivity) this.activity).setToolbarTitle(this.course_name);
        ((CourseActivity) this.activity).shareIV.setVisibility(0);
        Helper.setMargins(((CourseActivity) this.activity).shareIV, 0, 0, 16, 0);
    }

    private void initButton(CourseDetailData course) {
        if (!this.isCombo) {
            if (course.getIsPurchased().equalsIgnoreCase("1")) {
                this.buttonLow.setVisibility(8);
                return;
            }
            if ((course != null && course.getSkip_payment() != null && course.getSkip_payment().equalsIgnoreCase("1")) || "1".equalsIgnoreCase("5")) {
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
                this.myLibBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.SingleStudy2$$ExternalSyntheticLambda2
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
            return;
        }
        CourseDetail courseDetail = this.cousedetail;
        if (courseDetail != null && courseDetail.getData() != null && this.cousedetail.getData().getCourseDetail() != null && this.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("5")) {
            Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
            intent.putExtra("test_data", "");
            intent.putExtra(Const.SINGLE_STUDY, this.cousedetail);
            intent.putExtra("test_id", "0");
            intent.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
            intent.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
            Helper.gotoActivity(intent, this.activity);
            return;
        }
        Intent intent2 = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
        intent2.putExtra(Const.SINGLE_STUDY, this.cousedetail);
        Helper.gotoActivity(intent2, this.activity);
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
