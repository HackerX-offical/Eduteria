package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Adapter.ExamPrepLayer1Adapter;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.Courses.ExamPrepItem;
import com.appnew.android.Model.Courses.Lists;
import com.appnew.android.Model.DueEmiTable;
import com.appnew.android.Notification.Notification;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ExamPrepLayer1 extends MainFragment {
    Activity activity;
    Button backBtn;
    RelativeLayout buttonLow;
    TextView buyNowBtn;
    public String contentType;
    RelativeLayout dueEmiLayout;
    ExamPrepItem examPrepItem;
    ExamPrepLayer1Adapter examPrepLayer1Adapter;
    RecyclerView examPrepLayerRV;
    Lists list;
    public String main_id;
    TextView mrpCutTV;
    Button myLibBtn;
    RelativeLayout no_data_found_RL;
    RelativeLayout parentLL;
    TextView payEmi;
    TextView price;
    LinearLayout priceLL;
    String revertAPI;
    ExamPrepItem searchList;
    CourseDetail singleStudy;
    String tileIdAPI;
    String tileTypeAPI;
    public String title;
    TextView tvGstDesc;
    TextView txtTitle;
    private UtkashRoom utkashRoom;
    private String pre_txtid = "";
    boolean isCombo = false;
    String tabTileVisibility = "";

    public static ExamPrepLayer1 newInstance(ExamPrepItem examPrepItem, Lists main_id, String contentType, String title, CourseDetail singlestudyModel, boolean isCombo, String tileIdAPI, String tileTypeAPI, String revertAPI, String tabTileVisibility) {
        ExamPrepLayer1 examPrepLayer1 = new ExamPrepLayer1();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.SINGLE_STUDY_DATA, singlestudyModel);
        bundle.putSerializable(Const.EXAMPREP, examPrepItem);
        bundle.putSerializable("list", main_id);
        bundle.putString("title", title);
        bundle.putString("content_type", contentType);
        bundle.putBoolean(Const.IS_COMBO, isCombo);
        bundle.putString("tile_id", tileIdAPI);
        bundle.putString(Const.TILE_TYPE, tileTypeAPI);
        bundle.putString(Const.REVERT_API, revertAPI);
        bundle.putString(Const.TAB_TILE_VISIBILITY, tabTileVisibility);
        examPrepLayer1.setArguments(bundle);
        return examPrepLayer1;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        if (getArguments() != null) {
            this.isCombo = getArguments().getBoolean(Const.IS_COMBO);
            this.list = (Lists) getArguments().getSerializable("list");
            this.contentType = getArguments().getString("content_type");
            this.title = getArguments().getString("title");
            this.tileIdAPI = getArguments().getString("tile_id");
            this.tileTypeAPI = getArguments().getString(Const.TILE_TYPE);
            this.revertAPI = getArguments().getString(Const.REVERT_API);
            this.examPrepItem = (ExamPrepItem) getArguments().getSerializable(Const.EXAMPREP);
            this.singleStudy = (CourseDetail) getArguments().getSerializable(Const.SINGLE_STUDY_DATA);
            this.tabTileVisibility = getArguments().getString(Const.TAB_TILE_VISIBILITY);
            if (this.singleStudy == null) {
                this.singleStudy = new CourseDetail();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        if (appDatabase == null) {
            this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        }
        initView(view);
        if (TextUtils.isEmpty(this.title)) {
            return;
        }
        ((CourseActivity) this.activity).setToolbarTitle(TextUtils.isEmpty(this.list.getTitle()) ? this.singleStudy.getData().getCourseDetail().getTitle() : this.list.getTitle());
    }

    private void initView(View view) {
        this.parentLL = (RelativeLayout) view.findViewById(R.id.parentLL);
        this.tvGstDesc = (TextView) view.findViewById(R.id.tv_gstDesc);
        this.examPrepLayerRV = (RecyclerView) view.findViewById(R.id.examPrepLayerRV);
        this.mrpCutTV = (TextView) view.findViewById(R.id.mrpCutTV);
        this.price = (TextView) view.findViewById(R.id.priceTV);
        this.buyNowBtn = (TextView) view.findViewById(R.id.buyNowBtn);
        this.buttonLow = (RelativeLayout) view.findViewById(R.id.buttonLow);
        this.myLibBtn = (Button) view.findViewById(R.id.myLibBtn);
        this.priceLL = (LinearLayout) view.findViewById(R.id.priceLL);
        this.buyNowBtn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.activity.getResources().getString(R.string.buy_now));
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.backBtn = (Button) view.findViewById(R.id.backBtn);
        this.dueEmiLayout = (RelativeLayout) view.findViewById(R.id.dueEmiLayout);
        this.txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        this.payEmi = (TextView) view.findViewById(R.id.payEmi);
        if (SharedPreference.getInstance().getBoolean(Const.IS_PAYMENT_DONE)) {
            Constants.IS_PURCHASED = "0";
            this.buttonLow.setVisibility(8);
            SharedPreference.getInstance().putBoolean(Const.SINGLE_STUDY, true);
        } else {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null) {
                initButton(this.singleStudy.getData().getCourseDetail());
            } else {
                this.activity.finish();
            }
        }
        if (this.buttonLow.getVisibility() == 0) {
            this.examPrepLayerRV.setPadding(0, 0, 0, Helper.getValueInDP(this.activity, 70));
        } else {
            this.examPrepLayerRV.setPadding(0, 0, 0, 0);
        }
        this.buyNowBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer1.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ExamPrepLayer1.this.singleStudy != null && ExamPrepLayer1.this.singleStudy.getData() != null && ExamPrepLayer1.this.singleStudy.getData().getCourseDetail() != null && ExamPrepLayer1.this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("5")) {
                    Intent intent = new Intent(ExamPrepLayer1.this.activity, (Class<?>) PurchaseActivity.class);
                    intent.putExtra("test_data", "");
                    intent.putExtra(Const.SINGLE_STUDY, ExamPrepLayer1.this.singleStudy);
                    intent.putExtra("test_id", "0");
                    intent.putExtra(Const.IS_BOOK, ExamPrepLayer1.this.singleStudy.getData().getCourseDetail().getCat_type());
                    intent.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer1.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                    ExamPrepLayer1.this.activity.startActivity(intent);
                    ExamPrepLayer1.this.activity.finish();
                    return;
                }
                Intent intent2 = new Intent(ExamPrepLayer1.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, ExamPrepLayer1.this.singleStudy);
                intent2.putExtra(Const.IS_BOOK, ExamPrepLayer1.this.singleStudy.getData().getCourseDetail().getCat_type());
                intent2.putExtra(Const.DELIVERY_CHARGE, ExamPrepLayer1.this.singleStudy.getData().getCourseDetail().getDelivery_charge());
                ExamPrepLayer1.this.activity.startActivity(intent2);
                ExamPrepLayer1.this.activity.finish();
            }
        });
        this.myLibBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer1$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initView$0(view2);
            }
        });
        this.examPrepLayerRV.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
        InitListAdapter(this.examPrepItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false, false);
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
                CourseDetail courseDetail = this.singleStudy;
                if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null && this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                    this.buttonLow.setVisibility(8);
                } else {
                    this.buttonLow.setVisibility(0);
                }
            }
            int i = (int) (Float.parseFloat(course.getMrp()) + Float.parseFloat(course.getTax()));
            if (i == 0) {
                this.mrpCutTV.setVisibility(8);
                this.priceLL.setVisibility(8);
                this.buyNowBtn.setVisibility(8);
                this.myLibBtn.setVisibility(0);
                if ("1".equalsIgnoreCase("7")) {
                    this.buttonLow.setVisibility(8);
                    return;
                }
                if (course != null && course.getSkip_payment() != null && course.getSkip_payment().equalsIgnoreCase("1")) {
                    this.buttonLow.setVisibility(8);
                    return;
                }
                CourseDetail courseDetail2 = this.singleStudy;
                if (courseDetail2 != null && courseDetail2.getData() != null && this.singleStudy.getData().getCourseDetail() != null && this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                    this.buttonLow.setVisibility(8);
                    return;
                } else {
                    this.buttonLow.setVisibility(0);
                    return;
                }
            }
            this.priceLL.setVisibility(0);
            this.myLibBtn.setVisibility(8);
            String skip_payment = "";
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
            String id = course.getId();
            if (course != null && course.getSkip_payment() != null) {
                skip_payment = course.getSkip_payment();
            }
            getDueEmi(id, skip_payment);
            return;
        }
        this.buttonLow.setVisibility(8);
    }

    public void getDueEmi(String courseId, String is_skip) {
        final DueEmiTable dueEmiData = this.utkashRoom.getDueEmi().getDueEmiData(courseId);
        if (dueEmiData != null) {
            this.buttonLow.setVisibility(8);
            this.dueEmiLayout.setVisibility(0);
            this.txtTitle.setText("Your next EMI due on " + getdate(Long.parseLong(String.valueOf(Long.parseLong(dueEmiData.getExpiry_date()) * 1000))));
            this.payEmi.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer1$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$getDueEmi$1(dueEmiData, view);
                }
            });
            return;
        }
        if (is_skip != null && is_skip.equalsIgnoreCase("1")) {
            this.buttonLow.setVisibility(8);
        } else {
            CourseDetail courseDetail = this.singleStudy;
            if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null && this.singleStudy.getData().getCourseDetail().getCat_type().equalsIgnoreCase("3")) {
                this.buttonLow.setVisibility(8);
            } else {
                this.buttonLow.setVisibility(0);
            }
        }
        this.dueEmiLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDueEmi$1(DueEmiTable dueEmiTable, View view) {
        Intent intent = new Intent(this.activity, (Class<?>) InstallmentDetailActivity.class);
        intent.putExtra("order_data", dueEmiTable);
        intent.putExtra("fromWhere", Const.DueEmi);
        intent.putExtra("invoiceUrl", dueEmiTable.getUrl());
        intent.putExtra("type", Const.Installment);
        intent.putExtra("description_img", this.singleStudy.getData().getCourseDetail().getDescHeaderImage());
        this.activity.startActivity(intent);
    }

    private String getdate(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp))));
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

    private void RefreshDataList() {
        NetworkAPICall(API.API_GET_MASTER_DATA, this.contentType, true, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exam_prep_layer1, container, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_GET_MASTER_DATA)) {
            if (!apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
                return null;
            }
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
            encryptionData.setCoupon_applied("0");
            encryptionData.setParent_id(SingleStudy.parentCourseId);
            return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setTile_id(this.tileIdAPI);
        encryptionData2.setType(this.tileTypeAPI);
        encryptionData2.setRevert_api(this.revertAPI);
        encryptionData2.setCourse_id(this.singleStudy.getData().getCourseDetail().getId());
        encryptionData2.setLayer("2");
        encryptionData2.setParent_id(SingleStudy.parentCourseId.equals("") ? this.singleStudy.getData().getCourseDetail().getId() : SingleStudy.parentCourseId);
        encryptionData2.setPage("1");
        encryptionData2.setSubject_id(this.list.getId() != null ? this.list.getId() : "0");
        return service.getMasterDataVideoTwo(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Gson gson = new Gson();
        apitype.hashCode();
        if (apitype.equals(API.API_GET_MASTER_DATA)) {
            if (jsonobject.optString("status").equals("true")) {
                this.examPrepLayerRV.setVisibility(0);
                this.no_data_found_RL.setVisibility(8);
                ExamPrepItem examPrepItem = (ExamPrepItem) gson.fromJson(jsonobject.optString("data"), ExamPrepItem.class);
                this.examPrepItem = examPrepItem;
                InitListAdapter(examPrepItem);
                return;
            }
            this.examPrepLayerRV.setVisibility(8);
            this.no_data_found_RL.setVisibility(0);
            RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
            return;
        }
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            try {
                if (jsonobject.optString("status").equals("true")) {
                    if (!SingleStudy.parentCourseId.equalsIgnoreCase("")) {
                        this.utkashRoom.getCourseDetaildata().deletecoursedetail(SingleStudy.parentCourseId, MakeMyExam.userId);
                    } else if (!this.singleStudy.getData().getCourseDetail().getId().equalsIgnoreCase("")) {
                        this.utkashRoom.getCourseDetaildata().deletecoursedetail(this.singleStudy.getData().getCourseDetail().getId(), MakeMyExam.userId);
                    }
                    pushEventForFreeCourse();
                    Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                    if (BuildConfig.FLAVOR.equalsIgnoreCase("Anymiix")) {
                        Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, !SingleStudy.parentCourseId.equalsIgnoreCase("") ? SingleStudy.parentCourseId : this.singleStudy.getData().getCourseDetail().getId());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(Const.PAYMENT_DONE, 1);
                        intent.putExtra(AnalyticsConstants.course_name, this.singleStudy.getData().getCourseDetail().getTitle());
                        Helper.gotoActivity_finish_1(intent, this.activity);
                        return;
                    }
                    Intent intent2 = new Intent(this.activity, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent2.putExtra(Const.COURSE_ID_MAIN, !SingleStudy.parentCourseId.equalsIgnoreCase("") ? SingleStudy.parentCourseId : this.singleStudy.getData().getCourseDetail().getId());
                    intent2.putExtra(Const.COURSE_PARENT_ID, "");
                    intent2.putExtra(Const.IS_COMBO, false);
                    intent2.putExtra(Const.PAYMENT_DONE, 1);
                    intent2.putExtra(AnalyticsConstants.course_name, this.singleStudy.getData().getCourseDetail().getTitle());
                    Helper.gotoActivity_finish_1(intent2, this.activity);
                    return;
                }
                Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                RetrofitResponse.GetApiData(this.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void changeThemeColor(String color) {
        if (!color.contains(":") || color.split(":").length <= 1) {
            return;
        }
        SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
        this.buyNowBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color.split(":")[0])));
        this.myLibBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color.split(":")[0])));
        this.buyNowBtn.setTextColor(Color.parseColor(color.split(":")[1]));
        this.myLibBtn.setTextColor(Color.parseColor(color.split(":")[1]));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        if (SharedPreference.getInstance().getBoolean(Const.IS_PAYMENT_DONE)) {
            this.buttonLow.setVisibility(8);
            SharedPreference.getInstance().putBoolean(Const.SINGLE_STUDY, true);
        }
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") != null && !TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
        }
        CourseDetail courseDetail = this.singleStudy;
        if (courseDetail != null && courseDetail.getData() != null && this.singleStudy.getData().getCourseDetail() != null) {
            initButton(this.singleStudy.getData().getCourseDetail());
        }
        super.onResume();
    }

    public void InitListAdapter(ExamPrepItem examPrepItem) {
        if (Constants.is_Show_Search.equalsIgnoreCase("1")) {
            if (examPrepItem != null && examPrepItem.getList() != null) {
                ((CourseActivity) this.activity).searchIV.setVisibility(0);
            } else {
                ((CourseActivity) this.activity).searchIV.setVisibility(8);
            }
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("rankersGurukuls")) {
            ((CourseActivity) this.activity).iv_whatsapp.setVisibility(0);
            ((CourseActivity) this.activity).notificationLL.setVisibility(0);
        } else {
            ((CourseActivity) this.activity).iv_whatsapp.setVisibility(8);
            ((CourseActivity) this.activity).notificationLL.setVisibility(8);
        }
        ((CourseActivity) this.activity).notificationLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$InitListAdapter$2();
            }
        }));
        ((CourseActivity) this.activity).iv_whatsapp.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.ExamPrepLayer1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$InitListAdapter$3(view);
            }
        });
        if (this.parentLL.getVisibility() == 8) {
            this.parentLL.setVisibility(0);
        }
        ExamPrepLayer1Adapter examPrepLayer1Adapter = new ExamPrepLayer1Adapter(this.activity, examPrepItem, this.list, this, this.singleStudy, this.isCombo, this.tileIdAPI, this.tileTypeAPI, this.revertAPI, this.tabTileVisibility);
        this.examPrepLayer1Adapter = examPrepLayer1Adapter;
        this.examPrepLayerRV.setAdapter(examPrepLayer1Adapter);
        this.examPrepLayerRV.setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$InitListAdapter$2() {
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
        }
        Helper.gotoActivity(this.activity, (Class<?>) Notification.class);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$InitListAdapter$3(View view) {
        Helper.openWhatsapp(this.activity);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        RecyclerView recyclerView;
        if (!apitype.equalsIgnoreCase(API.API_GET_MASTER_DATA) || (recyclerView = this.examPrepLayerRV) == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
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
            this.examPrepLayer1Adapter.sendlist(this.searchList);
            return;
        }
        if (text.isEmpty() || text.equalsIgnoreCase("")) {
            ExamPrepItem examPrepItem4 = this.examPrepItem;
            this.searchList = examPrepItem4;
            this.examPrepLayer1Adapter.sendlist(examPrepItem4);
            return;
        }
        this.examPrepLayer1Adapter.sendlist(this.searchList);
    }

    private void pushEventForFreeCourse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map.put(AnalyticsConstants.user_name, AnalyticHelper.INSTANCE.getUserName());
        map.put("course_id", this.singleStudy.getData().getCourseDetail().getId());
        map.put(AnalyticsConstants.course_name, this.singleStudy.getData().getCourseDetail().getTitle());
        AnalyticEvents.INSTANCE.pushEvents(this.activity, AnalyticsConstants.FREE_USER, map);
    }
}
