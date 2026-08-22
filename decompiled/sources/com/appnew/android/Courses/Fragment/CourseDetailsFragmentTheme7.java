package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.Author;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.FAQs.FaqData;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.Overview.Description;
import com.appnew.android.Model.subscription.SubscriptionAllData;
import com.appnew.android.Model.subscription.SubscriptionMetaItem;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.PurchaseActivity;
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
import com.appnew.android.databinding.FragmentCourseDetailsTheme8Binding;
import com.appnew.android.home.Constants;
import com.appnew.android.table.CourseDetailTable;
import com.appnew.android.table.UserWiseCourseTable;
import com.eduteria.app.app.R;
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
public class CourseDetailsFragmentTheme7 extends MainFragment implements PopupMenu.OnMenuItemClickListener {
    public static String parentCourseId = "";
    private Context context;
    Courselist courseDetailData;
    private CourseDetail cousedetail;
    private Dialog descDialog;
    private Dialog faqDialog;
    private LeftMenu leftMenu;
    String mainCourseId;
    SubscriptionAllData subscriptionAllData;
    private UtkashRoom utkashRoom;
    FragmentCourseDetailsTheme8Binding binding = null;
    boolean show = true;
    boolean isFromDashBoard8 = false;
    private List<FaqData> faqDataList = new ArrayList();
    String clicktype = "";
    ArrayList<SubscriptionMetaItem> subscriptionValidityList = new ArrayList<>();
    ArrayList<SubscriptionMetaItem> subscriptionValidityListForDeliveryMethod = new ArrayList<>();
    String deliverCharges = "";
    private String title = "";
    private String batch_id = "";

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public static CourseDetailsFragmentTheme7 newInstance(Courselist courseDetail, String mainCourseId, String parentCourseId2) {
        CourseDetailsFragmentTheme7 courseDetailsFragmentTheme7 = new CourseDetailsFragmentTheme7();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.COURSE_DETAIL, courseDetail);
        bundle.putString(Const.COURSE_ID_MAIN, mainCourseId);
        bundle.putString(Const.COURSE_PARENT_ID, parentCourseId2);
        courseDetailsFragmentTheme7.setArguments(bundle);
        return courseDetailsFragmentTheme7;
    }

    public static CourseDetailsFragmentTheme7 newInstance(Courselist courseDetail, String mainCourseId, String parentCourseId2, String title, String batch_id) {
        CourseDetailsFragmentTheme7 courseDetailsFragmentTheme7 = new CourseDetailsFragmentTheme7();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.COURSE_DETAIL, courseDetail);
        bundle.putString(Const.COURSE_ID_MAIN, mainCourseId);
        bundle.putString(Const.COURSE_PARENT_ID, parentCourseId2);
        bundle.putString("isFromDashBoard8", "isFromDashBoard8");
        bundle.putString("title", title);
        bundle.putString(Const.BATCH_ID, batch_id);
        courseDetailsFragmentTheme7.setArguments(bundle);
        return courseDetailsFragmentTheme7;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("isFromDashBoard8")) {
                this.isFromDashBoard8 = true;
            }
            this.courseDetailData = (Courselist) arguments.getSerializable(Const.COURSE_DETAIL);
            parentCourseId = getArguments().getString(Const.COURSE_PARENT_ID);
            this.mainCourseId = getArguments().getString(Const.COURSE_ID_MAIN);
            this.title = getArguments().getString("title");
            this.batch_id = getArguments().getString(Const.BATCH_ID);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentCourseDetailsTheme8Binding fragmentCourseDetailsTheme8BindingInflate = FragmentCourseDetailsTheme8Binding.inflate(inflater, container, false);
        this.binding = fragmentCourseDetailsTheme8BindingInflate;
        return fragmentCourseDetailsTheme8BindingInflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        if (appDatabase == null) {
            this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        }
        if (BuildConfig.FLAVOR.equalsIgnoreCase("NavinClasses") || BuildConfig.FLAVOR.equalsIgnoreCase("ICSHomework")) {
            NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
        }
        if (this.utkashRoom.getCourseDetaildata() != null) {
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
                    courseDetailData.setIs_activated(list.get(0).getIs_activated());
                    courseDetailData.setToken_activation(list.get(0).getToken_activation());
                    courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                    courseDetailData.setInstallment(list.get(0).getInstallment());
                    courseDetailData.setIs_gst(list.get(0).getIs_gst());
                    courseDetailData.setDescription(list.get(0).getDescription());
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
                    if (((CourseActivity) this.context).is_coupon) {
                        Intent intent = new Intent(this.context, (Class<?>) PurchaseActivity.class);
                        intent.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                        intent.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                        intent.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent, (Activity) this.context);
                    } else if (!courseDetailData.getIsPurchased().equalsIgnoreCase("1") || !courseDetailData.getToken_activation().equalsIgnoreCase("1") || !courseDetailData.getIsPurchased().equalsIgnoreCase("1") || !courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                        initButton(this.cousedetail.getData().getCourseDetail());
                        setCourseData(courseDetailData);
                    }
                } else {
                    this.utkashRoom.getCourseDetaildata().deletecoursedetail(parentCourseId, MakeMyExam.userId);
                    NetworkAPICall(API.CourseDetail_JS, "", true, false, false);
                }
            }
        }
        this.binding.buyNowLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent2 = new Intent(CourseDetailsFragmentTheme7.this.activity, (Class<?>) PurchaseActivity.class);
                intent2.putExtra(Const.SINGLE_STUDY, CourseDetailsFragmentTheme7.this.cousedetail);
                intent2.putExtra(Const.DELIVERY_CHARGE, CourseDetailsFragmentTheme7.this.deliverCharges);
                Helper.gotoActivity(intent2, CourseDetailsFragmentTheme7.this.activity);
            }
        });
        this.binding.purchasedLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (CourseDetailsFragmentTheme7.this.binding.purchasedLayoutButton.getText().toString().equalsIgnoreCase("Add To \nMy Library")) {
                    CourseDetailsFragmentTheme7.this.NetworkAPICall("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction", "", true, false, false);
                }
            }
        });
        this.binding.faq.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$0(view2);
            }
        });
        this.binding.features.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                List<TilesItem> tiles = CourseDetailsFragmentTheme7.this.cousedetail.getData().getTiles();
                Description description = new Description();
                int i2 = 0;
                while (true) {
                    if (i2 >= tiles.size()) {
                        break;
                    }
                    if (tiles.get(i2).getType().equalsIgnoreCase(Const.OVERVIEW)) {
                        try {
                            description = (Description) new Gson().fromJson(new JSONObject(tiles.get(i2).getMeta()).getJSONObject("description").toString(), Description.class);
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        i2++;
                    }
                }
                if (description != null) {
                    CourseDetailsFragmentTheme7.this.showFaqDescription(description);
                }
            }
        });
        this.binding.courseContentLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$1(view2);
            }
        });
        this.binding.asktousLl.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$2(view2);
            }
        });
        this.binding.deliveryId1.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$3(view2);
            }
        });
        this.binding.deliveryId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$4(view2);
            }
        });
        this.binding.validityId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$5(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        List<TilesItem> tiles = this.cousedetail.getData().getTiles();
        this.faqDataList.clear();
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getTileName().equalsIgnoreCase(Const.FAQ)) {
                try {
                    JSONArray jSONArray = new JSONObject(tiles.get(i).getMeta()).getJSONArray("list");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        this.faqDataList.add((FaqData) new Gson().fromJson(jSONArray.get(i2).toString(), FaqData.class));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        showFaqPoppup(this.context, this.faqDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(View view) {
        if (this.isFromDashBoard8) {
            Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent.putExtra(Const.COURSESLIST, this.courseDetailData);
            intent.putExtra(Const.COURSE_ID_MAIN, this.mainCourseId);
            intent.putExtra(Const.COURSE_PARENT_ID, "");
            intent.putExtra(Const.IS_COMBO, false);
            intent.putExtra(AnalyticsConstants.course_name, this.title);
            intent.putExtra(Const.COMBO_ID, this.batch_id);
            Helper.gotoActivity(intent, this.activity);
            return;
        }
        if (TextUtils.isEmpty(this.courseDetailData.getMaintenanceText())) {
            Intent intent2 = new Intent(this.activity, (Class<?>) CourseActivity.class);
            intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent2.putExtra(Const.COURSESLIST, this.courseDetailData);
            intent2.putExtra(Const.COURSE_ID_MAIN, this.courseDetailData.getId());
            intent2.putExtra(Const.COURSE_PARENT_ID, "");
            intent2.putExtra(Const.IS_COMBO, false);
            intent2.putExtra(AnalyticsConstants.course_name, this.courseDetailData.getTitle());
            intent2.putExtra(Const.COMBO_ID, this.courseDetailData.getCombo_course_ids());
            Helper.gotoActivity(intent2, this.activity);
            return;
        }
        Helper.getCourseMaintanaceDialog(this.activity, "", this.courseDetailData.getMaintenanceText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(View view) {
        openWhatsapp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$3(View view) {
        if (!Helper.isNetworkConnected(this.activity)) {
            Helper.showInternetToast(this.activity);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this.activity, this.binding.deliveryId1, 3);
        ArrayList arrayList = new ArrayList();
        for (SubscriptionMetaItem subscriptionMetaItem : this.subscriptionAllData.getSubscriptionMeta()) {
            if (!arrayList.contains(subscriptionMetaItem.getPlateformsName())) {
                arrayList.add(subscriptionMetaItem.getPlateformsName());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            popupMenu.getMenu().add((String) it.next());
        }
        this.clicktype = "1";
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$4(View view) {
        ArrayList<SubscriptionMetaItem> arrayList = this.subscriptionValidityListForDeliveryMethod;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (!Helper.isNetworkConnected(this.activity)) {
                Helper.showInternetToast(this.activity);
                return;
            }
            PopupMenu popupMenu = new PopupMenu(this.activity, this.binding.deliveryId, 3);
            Iterator<SubscriptionMetaItem> it = this.subscriptionValidityListForDeliveryMethod.iterator();
            while (it.hasNext()) {
                popupMenu.getMenu().add(it.next().getPlanTitle());
            }
            this.clicktype = "2";
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
            return;
        }
        Toast.makeText(this.context, "Select Deliver Method", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$5(View view) {
        SubscriptionAllData subscriptionAllData = this.subscriptionAllData;
        if (subscriptionAllData == null || subscriptionAllData.getSubscriptionMeta() == null) {
            return;
        }
        if (!this.subscriptionValidityList.isEmpty()) {
            if (!Helper.isNetworkConnected(this.activity)) {
                Helper.showInternetToast(this.activity);
                return;
            }
            PopupMenu popupMenu = new PopupMenu(this.activity, this.binding.validityId, 3);
            Iterator<SubscriptionMetaItem> it = this.subscriptionValidityList.iterator();
            while (it.hasNext()) {
                popupMenu.getMenu().add(it.next().getValidityMy());
            }
            this.clicktype = "3";
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
            return;
        }
        Toast.makeText(this.context, "Please Select Plan.", 0).show();
    }

    private void setCourseData(final CourseDetailData courseDetailData) {
        this.binding.courseName.setText(courseDetailData.getTitle());
        if (!TextUtils.isEmpty(courseDetailData.getDescHeaderImage())) {
            Helper.setThumbnailImage(this.context, courseDetailData.getDescHeaderImage(), this.context.getResources().getDrawable(R.mipmap.square_placeholder), this.binding.courseImageIcon);
        } else {
            this.binding.courseImageIcon.setImageResource(R.mipmap.square_placeholder);
        }
        this.binding.courseIntroLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setCourseData$6(courseDetailData, view);
            }
        });
        this.binding.share.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setCourseData$7(courseDetailData);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCourseData$6(CourseDetailData courseDetailData, View view) {
        if (this.show) {
            this.binding.courseDataView.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.slide_down));
            if (courseDetailData.getDescription() != null && courseDetailData.getDescription().isEmpty()) {
                this.binding.courseDataView.setVisibility(8);
            } else {
                this.binding.courseDataView.setVisibility(0);
                Helper.load(this.binding.webViewDesc, courseDetailData.getDescription());
            }
            this.binding.showImgData.setVisibility(0);
            this.binding.hideImgData.setVisibility(8);
            this.binding.courseDataView.setVisibility(0);
            this.show = false;
            return;
        }
        this.binding.courseDataView.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.slide_up));
        new Handler().postDelayed(new Runnable() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7.4
            @Override // java.lang.Runnable
            public void run() {
                CourseDetailsFragmentTheme7.this.binding.courseDataView.setVisibility(8);
                CourseDetailsFragmentTheme7.this.binding.hideImgData.setVisibility(0);
                CourseDetailsFragmentTheme7.this.binding.showImgData.setVisibility(8);
            }
        }, 300L);
        this.show = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setCourseData$7(CourseDetailData courseDetailData) {
        Helper.shareCourse(this.activity, this.mainCourseId, courseDetailData.getIs_combo(), parentCourseId, courseDetailData.getTitle(), this.cousedetail.getData().getCourseDetail().getDescHeaderImage(), this.cousedetail.getData().getCourseDetail().getTitle());
        return null;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(this.cousedetail.getData().getCourseDetail().getId());
            encryptionData.setCoupon_applied("0");
            encryptionData.setParent_id(parentCourseId);
            return service.free_transaction(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.CourseDetail_JS)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setCourse_id(this.mainCourseId);
        encryptionData2.setParent_id(parentCourseId);
        return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")) {
            try {
                if (jsonobject.optString("status").equals("true")) {
                    this.utkashRoom.getCourseDetaildata().deletecoursedetail(this.cousedetail.getData().getCourseDetail().getId(), MakeMyExam.userId);
                    pushEventForFreeCourse();
                    Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                    Intent intent = new Intent(this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, !parentCourseId.equalsIgnoreCase("") ? parentCourseId : this.cousedetail.getData().getCourseDetail().getId());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, this.cousedetail.getData().getCourseDetail().getTitle());
                    Helper.gotoActivity_finish(intent, this.activity);
                    return;
                }
                Toast.makeText(this.activity, "" + jsonobject.optString("message"), 0).show();
                RetrofitResponse.GetApiData(this.activity, jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (apitype.equals(API.CourseDetail_JS)) {
            if (jsonobject.optString("status").equals("true")) {
                this.binding.noDataFond.noDataFoundRL.setVisibility(8);
                JSONObject jSONObjectOptJSONObject = jsonobject.optJSONObject("data");
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
                    for (int i = 0; i < jSONObjectOptJSONObject.getJSONArray("tiles").length(); i++) {
                        CourseDetailTable courseDetailTable = new CourseDetailTable();
                        courseDetailTable.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                        courseDetailTable.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
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
                        courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i, "id"));
                        courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i, "meta"));
                        courseDetailTable.setUser_id(MakeMyExam.userId);
                        if (jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i).has("thumbnail")) {
                            courseDetailTable.setThumbnail(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i).getString("thumbnail"));
                        }
                        courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i, Const.REVERT_API));
                        courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i, "tile_name"));
                        courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i, "type"));
                        courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i, "set_as_demo"));
                        courseDetailTable.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                        courseDetailTable.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                        courseDetailTable.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                        courseDetailTable.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                        courseDetailTable.setDescription(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("description"));
                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment") != null) {
                            courseDetailTable.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment"));
                        } else {
                            courseDetailTable.setSkip_payment("1");
                        }
                        if (jsonobject.optJSONObject("data").optJSONObject("subscription_all_data") != null) {
                            courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject("data").optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                        }
                        this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
                    }
                }
                List<CourseDetailTable> list = this.utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + this.mainCourseId, MakeMyExam.userId);
                if (list == null || list.size() <= 0) {
                    return;
                }
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
                courseDetailData.setDescription(list.get(0).getDescription());
                courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
                this.cousedetail = new CourseDetail();
                Data data = new Data();
                data.setCourseDetail(courseDetailData);
                if (list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                    data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2).getType().equalsIgnoreCase(Const.OVERVIEW)) {
                        arrayList.add(new TilesItem(list.get(i2).getTile_revert(), list.get(i2).getTile_title(), list.get(i2).getTile_id(), list.get(i2).getType(), list.get(i2).getTile_meta(), list.get(i2).getSet_as_demo(), list.get(i2).getThumbnail()));
                    } else {
                        arrayList.add(new TilesItem(list.get(i2).getTile_revert(), list.get(i2).getTile_title(), list.get(i2).getTile_id(), list.get(i2).getType(), list.get(i2).getTile_meta(), list.get(i2).getSet_as_demo(), list.get(i2).getThumbnail()));
                    }
                }
                data.setTiles(arrayList);
                this.cousedetail.setData(data);
                if (((CourseActivity) this.activity).is_coupon) {
                    Intent intent2 = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
                    intent2.putExtra(Const.SINGLE_STUDY, this.cousedetail);
                    intent2.putExtra(Const.IS_BOOK, this.cousedetail.getData().getCourseDetail().getCat_type());
                    intent2.putExtra(Const.DELIVERY_CHARGE, this.cousedetail.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent2, this.activity);
                } else if (!courseDetailData.getIsPurchased().equalsIgnoreCase("1") || !courseDetailData.getToken_activation().equalsIgnoreCase("1") || !courseDetailData.getIsPurchased().equalsIgnoreCase("1") || !courseDetailData.getIs_activated().equalsIgnoreCase("0")) {
                    initButton(this.cousedetail.getData().getCourseDetail());
                    setCourseData(courseDetailData);
                }
                setSubscriptionData(jsonobject);
                return;
            }
            this.binding.noDataFond.noDataFoundRL.setVisibility(0);
            RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
        }
    }

    private void setSubscriptionData(JSONObject jsonobject) {
        CourseDetail courseDetail = this.cousedetail;
        if (courseDetail == null || courseDetail.getData().getCourseDetail() == null || !this.cousedetail.getData().getCourseDetail().getIsPurchased().equalsIgnoreCase("0") || jsonobject.optJSONObject("data").optJSONObject("subscription_all_data") == null) {
            return;
        }
        this.subscriptionAllData = (SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject("data").optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class);
        this.cousedetail.getData().setSubscriptionAllData(this.subscriptionAllData);
        if (this.subscriptionAllData.getSubscriptionMeta() != null && !this.subscriptionAllData.getSubscriptionMeta().isEmpty()) {
            this.binding.deliveryId1.setText(getString(R.string.select_delivery_method));
            this.binding.deliveryId.setText(getString(R.string.select_your_subscription_plan));
            this.binding.validityId.setText(getString(R.string.select_validity));
            this.binding.price.setText(String.format("%s %s %s", Constants.currencyType, "" + ((int) (Float.parseFloat(this.cousedetail.getData().getCourseDetail().getMrp()) + Float.parseFloat(this.cousedetail.getData().getCourseDetail().getTax()))), "/-"));
            this.binding.subscriptionSectionId.setVisibility(0);
            this.binding.cutAmount.setVisibility(8);
            return;
        }
        this.binding.subscriptionSectionId.setVisibility(8);
    }

    private void initButton(CourseDetailData course) {
        if (course.getIsPurchased().equalsIgnoreCase("1")) {
            this.binding.buyNowLayout.setVisibility(8);
            this.binding.cutAmount.setVisibility(8);
            this.binding.price.setVisibility(8);
            this.binding.purchasedLayout.setVisibility(0);
            return;
        }
        if (course != null && course.getSkip_payment() != null && course.getSkip_payment().equalsIgnoreCase("1")) {
            this.binding.buyNow.setVisibility(8);
        } else {
            this.binding.buyNow.setVisibility(0);
        }
        int i = (int) (Float.parseFloat(course.getMrp()) + Float.parseFloat(course.getTax()));
        if (i == 0) {
            this.binding.buyNowLayout.setVisibility(8);
            this.binding.cutAmount.setVisibility(8);
            this.binding.price.setVisibility(8);
            this.binding.purchasedLayout.setVisibility(0);
            this.binding.purchasedLayoutButton.setText("Add To \nMy Library");
            return;
        }
        this.binding.buyNowLayout.setVisibility(0);
        this.binding.purchasedLayout.setVisibility(8);
        this.binding.txtButton.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : "Buy Now");
        this.binding.price.setText(String.format("%s %s %s", Constants.currencyType, "" + i, "/-"));
        if (Integer.parseInt(course.getCourseSp()) > 0) {
            this.binding.cutAmount.setText(String.format("%s %s %s", Constants.currencyType, course.getCourseSp().trim(), "/-"), TextView.BufferType.SPANNABLE);
            StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
            Spannable spannable = (Spannable) this.binding.cutAmount.getText();
            if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                this.binding.cutAmount.setVisibility(0);
            } else {
                this.binding.cutAmount.setVisibility(8);
            }
            spannable.setSpan(strikethroughSpan, 2, new String(course.getCourseSp()).length() + 2, 33);
            return;
        }
        this.binding.cutAmount.setVisibility(8);
    }

    private void showFaqPoppup(Context activity, List<FaqData> faqData) {
        View viewInflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.faq_overview_popup_layout, (ViewGroup) null, false);
        Dialog dialog = new Dialog(activity, R.style.CustomAlertDialog);
        this.faqDialog = dialog;
        dialog.requestWindowFeature(1);
        this.faqDialog.setCanceledOnTouchOutside(false);
        this.faqDialog.setCancelable(true);
        this.faqDialog.setContentView(viewInflate);
        this.faqDialog.getWindow().setLayout(-1, -1);
        this.faqDialog.show();
        findFaqPopViewIDS(viewInflate, faqData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFaqDescription(Description description) {
        View viewInflate = ((LayoutInflater) this.activity.getSystemService("layout_inflater")).inflate(R.layout.description_overview_popup_layout, (ViewGroup) null, false);
        Dialog dialog = new Dialog(this.activity, R.style.CustomAlertDialog);
        this.descDialog = dialog;
        dialog.requestWindowFeature(1);
        this.descDialog.setCanceledOnTouchOutside(false);
        this.descDialog.setCancelable(true);
        this.descDialog.setContentView(viewInflate);
        this.descDialog.getWindow().setLayout(-1, -1);
        this.descDialog.show();
        WebView webView = (WebView) viewInflate.findViewById(R.id.desc_webView);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.no_data_found_RL);
        ((ImageView) viewInflate.findViewById(R.id.image_back)).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CourseDetailsFragmentTheme7.this.descDialog.dismiss();
            }
        });
        if (description.getData() != null && !description.getData().equalsIgnoreCase("")) {
            relativeLayout.setVisibility(8);
            webView.setVisibility(0);
            Helper.showWebDatas((Activity) this.context, Helper.getHtmlUpdatedDatas(description.getData()), webView);
        } else {
            relativeLayout.setVisibility(0);
            webView.setVisibility(8);
        }
    }

    public void openWhatsapp() {
        if (this.leftMenu == null) {
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://wa.me/" + this.leftMenu.getMobile_number())));
    }

    private void findFaqPopViewIDS(View view, List<FaqData> faqData) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image_back);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.faqRV);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        if (faqData != null && faqData.size() > 0) {
            relativeLayout.setVisibility(8);
            recyclerView.setVisibility(0);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
            recyclerView.setAdapter(new FaqListRecyclerAdapter(faqData, 0));
            recyclerView.setNestedScrollingEnabled(false);
        } else {
            relativeLayout.setVisibility(0);
            recyclerView.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$findFaqPopViewIDS$8(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$findFaqPopViewIDS$8(View view) {
        this.faqDialog.dismiss();
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem item) {
        float f2;
        float f3;
        if (this.clicktype.equalsIgnoreCase("2")) {
            for (SubscriptionMetaItem subscriptionMetaItem : this.subscriptionValidityListForDeliveryMethod) {
                if (subscriptionMetaItem.getPlanTitle().equalsIgnoreCase(item.getTitle().toString())) {
                    this.binding.deliveryId.setText(subscriptionMetaItem.getPlanTitle());
                    this.subscriptionValidityList.clear();
                    this.binding.validityId.setText(getString(R.string.select_validity));
                    this.binding.price.setText(String.format("", new Object[0]));
                    this.cousedetail.getData().getCourseDetail().setMrp("");
                    this.cousedetail.getData().getCourseDetail().setTax("");
                    if (MakeMyExam.isDeliveryAddressNeeded) {
                        f2 = Float.parseFloat(subscriptionMetaItem.getPrice()) + Float.parseFloat(subscriptionMetaItem.getTax());
                        f3 = Float.parseFloat(subscriptionMetaItem.getDelivery_charge_subscription());
                    } else {
                        f2 = Float.parseFloat(subscriptionMetaItem.getPrice());
                        f3 = Float.parseFloat(subscriptionMetaItem.getTax());
                    }
                    this.binding.validityId.setText(subscriptionMetaItem.getValidityMy());
                    this.binding.price.setText(String.format("%s %s %s", Constants.currencyType, "" + (f2 + f3), "/-"));
                    this.cousedetail.getData().getCourseDetail().setMrp(subscriptionMetaItem.getPrice());
                    this.cousedetail.getData().getCourseDetail().setTax(subscriptionMetaItem.getTax());
                    this.cousedetail.getData().getSubscriptionAllData().setPlanId(subscriptionMetaItem.getSubscriptionId());
                    if (subscriptionMetaItem.getDelivery_charge_subscription().equalsIgnoreCase("0")) {
                        MakeMyExam.isDeliveryAddressNeeded = false;
                        this.deliverCharges = "";
                    } else {
                        MakeMyExam.isDeliveryAddressNeeded = true;
                        this.deliverCharges = subscriptionMetaItem.getDelivery_charge_subscription();
                    }
                }
            }
        } else if (this.clicktype.equalsIgnoreCase("3")) {
            for (SubscriptionMetaItem subscriptionMetaItem2 : this.subscriptionValidityList) {
                if (subscriptionMetaItem2.getValidityMy().equalsIgnoreCase(item.getTitle().toString())) {
                    this.binding.validityId.setText(subscriptionMetaItem2.getValidityMy());
                    this.binding.price.setText(String.format("%s %s %s", Constants.currencyType, "" + subscriptionMetaItem2.getPrice(), "/-"));
                    this.cousedetail.getData().getCourseDetail().setMrp(subscriptionMetaItem2.getPrice());
                    this.cousedetail.getData().getCourseDetail().setTax(subscriptionMetaItem2.getTax());
                    this.cousedetail.getData().getSubscriptionAllData().setPlanId(subscriptionMetaItem2.getSubscriptionId());
                }
            }
        } else if (this.clicktype.equalsIgnoreCase("1")) {
            for (SubscriptionMetaItem subscriptionMetaItem3 : this.subscriptionAllData.getSubscriptionMeta()) {
                if (subscriptionMetaItem3.getPlateformsName().equalsIgnoreCase(item.getTitle().toString())) {
                    this.binding.deliveryId1.setText(subscriptionMetaItem3.getPlateformsName());
                    this.subscriptionValidityListForDeliveryMethod.clear();
                    this.subscriptionValidityList.clear();
                    this.binding.validityId.setText(getString(R.string.select_validity));
                    this.binding.deliveryId.setText(getString(R.string.select_your_subscription_plan));
                    this.binding.price.setText(String.format("", new Object[0]));
                    this.cousedetail.getData().getCourseDetail().setMrp("");
                    this.cousedetail.getData().getCourseDetail().setTax("");
                    for (SubscriptionMetaItem subscriptionMetaItem4 : this.subscriptionAllData.getSubscriptionMeta()) {
                        if (subscriptionMetaItem4.getPlateformsName().equalsIgnoreCase(subscriptionMetaItem3.getPlateformsName())) {
                            this.subscriptionValidityListForDeliveryMethod.add(subscriptionMetaItem4);
                        }
                    }
                }
            }
        }
        return false;
    }

    public class FaqListRecyclerAdapter extends RecyclerView.Adapter<FaqListHolder> {
        List<FaqData> faqData;
        int positions;

        public FaqListRecyclerAdapter(List<FaqData> faqData, int position) {
            this.positions = position;
            this.faqData = faqData;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public FaqListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new FaqListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_faq_data, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.faqData.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(FaqListHolder holder, int position) {
            holder.setSingleFAQData(this.faqData.get(position).getQuestion(), position, this.faqData.get(position).getDescription());
        }

        public class FaqListHolder extends RecyclerView.ViewHolder {
            private TextView answertextTV;
            private ImageView dropDownIV;
            private LinearLayout mainLL;
            private LinearLayout parentLL;
            private TextView questiontextTV;

            public FaqListHolder(View itemView) {
                super(itemView);
                this.questiontextTV = (TextView) itemView.findViewById(R.id.questiontextTV);
                this.dropDownIV = (ImageView) itemView.findViewById(R.id.dropDownIV);
                this.answertextTV = (TextView) itemView.findViewById(R.id.answertextTV);
                this.mainLL = (LinearLayout) itemView.findViewById(R.id.lowerViewItem);
                this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            }

            public void setSingleFAQData(String singlefaqdata, int pos, String answersData) {
                this.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Fragment.CourseDetailsFragmentTheme7.FaqListRecyclerAdapter.FaqListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (FaqListHolder.this.mainLL.getVisibility() == 8) {
                            FaqListHolder.this.mainLL.setVisibility(0);
                            FaqListHolder.this.dropDownIV.setImageResource(R.mipmap.up_black);
                        } else {
                            FaqListHolder.this.mainLL.setVisibility(8);
                            FaqListHolder.this.dropDownIV.setImageResource(R.mipmap.down_black);
                        }
                    }
                });
                this.questiontextTV.setText(singlefaqdata);
                this.answertextTV.setText(answersData);
            }
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
