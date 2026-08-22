package com.appnew.android.Educator.adpter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Educator.model.EduClassCourseItem;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.Author;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.subscription.SubscriptionAllData;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Utils.ZoomFeatureHelper;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.home.liveclasses.Datum;
import com.appnew.android.table.CourseDetailTable;
import com.appnew.android.table.UserWiseCourseTable;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class EduCCAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    public static CourseDetail cousedetail;
    public static String mainCourseId;
    public static String parentCourseId;
    public static UtkashRoom utkashRoom;
    Activity activity;
    String content_type;
    private ArrayList<EduClassCourseItem> eduClassCourseItemsList;
    private ArrayList<Datum> liveClass;
    private String viewType;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public EduCCAdapter(Activity activity, ArrayList<Datum> liveClass, String viewType) {
        this.activity = activity;
        this.liveClass = liveClass;
        this.viewType = viewType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.activity);
        if (viewType == 0) {
            return new CourseViewHolder(layoutInflaterFrom.inflate(R.layout.edu_course_adapter, parent, false));
        }
        if (viewType == 1 || viewType == 2) {
            return new ClassViewHolder(layoutInflaterFrom.inflate(R.layout.edu_class_adapter, parent, false));
        }
        throw new IllegalArgumentException("Invalid view type");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ClassViewHolder) holder).bind(this.liveClass.get(position), this.activity, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.liveClass.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        String str = this.viewType;
        return (str == "free_classes" || str == "live_classes") ? 1 : 0;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.CourseDetail_JS)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(mainCourseId);
        encryptionData.setParent_id(parentCourseId);
        return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        int i;
        apitype.hashCode();
        if (apitype.equals(API.CourseDetail_JS) && jsonobject.optString("status").equals("true")) {
            JSONObject jSONObjectOptJSONObject = jsonobject.optJSONObject("data");
            if (!utkashRoom.getuserwisecourse().is_api_code_exits(MakeMyExam.userId, jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                UserWiseCourseTable userWiseCourseTable = new UserWiseCourseTable();
                userWiseCourseTable.setUserid(MakeMyExam.userId);
                userWiseCourseTable.setCode("ut_011");
                userWiseCourseTable.setVersion("0.000");
                userWiseCourseTable.setExp(String.valueOf(MakeMyExam.getTime_server()));
                userWiseCourseTable.setMeta_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                utkashRoom.getuserwisecourse().addUser(userWiseCourseTable);
            }
            if (!utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                for (int i2 = 0; i2 < jSONObjectOptJSONObject.getJSONArray("tiles").length(); i2++) {
                    if ("1".equalsIgnoreCase("7")) {
                        if (!Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "type").equalsIgnoreCase("content")) {
                            CourseDetailTable courseDetailTable = new CourseDetailTable();
                            courseDetailTable.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                            courseDetailTable.setCourse_id(parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
                            courseDetailTable.setCover_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                            courseDetailTable.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                            courseDetailTable.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                            courseDetailTable.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                            courseDetailTable.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                            courseDetailTable.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
                            courseDetailTable.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                            courseDetailTable.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                            courseDetailTable.setTransaction_status(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.TRANSACTION_STATUS));
                            courseDetailTable.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                            courseDetailTable.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                            courseDetailTable.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                            courseDetailTable.setDisplay_locked(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("display_locked"));
                            courseDetailTable.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                            if (jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i2).has("thumbnail")) {
                                courseDetailTable.setThumbnail(jSONObjectOptJSONObject.getJSONArray("tiles").getJSONObject(i2).getString("thumbnail"));
                            }
                            courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "id"));
                            courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "meta"));
                            courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                            courseDetailTable.setUser_id(MakeMyExam.userId);
                            courseDetailTable.setContent_type(this.content_type);
                            courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                            courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                            courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "type"));
                            courseDetailTable.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                            courseDetailTable.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has("avg_rating") && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"))) {
                                courseDetailTable.setAvg_rating(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"));
                            } else {
                                courseDetailTable.setAvg_rating("");
                            }
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has("user_rated") && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("user_rated"))) {
                                courseDetailTable.setUser_rated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("user_rated"));
                            } else {
                                courseDetailTable.setUser_rated("");
                            }
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has("stocks") && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("stocks"))) {
                                courseDetailTable.setStocks(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("stocks"));
                            } else {
                                courseDetailTable.setStocks("");
                            }
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
                            courseDetailTable.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                            if (jsonobject.optJSONObject("data").optJSONObject("subscription_all_data") != null) {
                                courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject("data").optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
                            }
                            utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
                        }
                    } else {
                        setData(jSONObjectOptJSONObject, jsonobject, i2);
                    }
                }
            }
            List<CourseDetailTable> list = utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + mainCourseId, MakeMyExam.userId);
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
            courseDetailData.setCover_image(list.get(0).getCover_image());
            courseDetailData.setDescHeaderImage(list.get(0).getDesc_header_image());
            courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
            courseDetailData.setViewType(list.get(0).getView_type());
            courseDetailData.setIs_combo(list.get(0).getIs_combo());
            courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
            if (list.get(0).getAvg_rating() != null) {
                courseDetailData.setAvg_rating(list.get(0).getAvg_rating());
                courseDetailData.setUser_rated(list.get(0).getUser_rated());
                courseDetailData.setStocks(list.get(0).getStocks());
            }
            courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
            courseDetailData.setCat_type(list.get(0).getCat_type());
            courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
            courseDetailData.setIs_activated(list.get(0).getIs_activated());
            courseDetailData.setToken_activation(list.get(0).getToken_activation());
            courseDetailData.setTransaction_status(list.get(0).getTransaction_status());
            courseDetailData.setTxn_id(list.get(0).getTxn_id());
            courseDetailData.setInstallment(list.get(0).getInstallment());
            courseDetailData.setIs_gst(list.get(0).getIs_gst());
            courseDetailData.setDisplay_locked(list.get(0).getDisplay_locked());
            cousedetail = new CourseDetail();
            Data data = new Data();
            data.setCourseDetail(courseDetailData);
            if (list.size() > 0) {
                i = 0;
                if (list.get(0) != null && list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                    data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                }
            } else {
                i = 0;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = i; i3 < list.size(); i3++) {
                list.get(i3).getType().equalsIgnoreCase(Const.COMBO);
                arrayList.add(new TilesItem(list.get(i3).getTile_revert(), list.get(i3).getTile_title(), list.get(i3).getTile_id(), list.get(i3).getType(), list.get(i3).getTile_meta(), list.get(i3).getSet_as_demo(), list.get(i3).getThumbnail()));
            }
            data.setTiles(arrayList);
            cousedetail.setData(data);
            Intent intent = new Intent(this.activity, (Class<?>) PurchaseActivity.class);
            intent.putExtra(Const.SINGLE_STUDY, cousedetail);
            if (cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                intent.putExtra("quantityOfBooks", "1");
            }
            intent.putExtra(Const.IS_BOOK, cousedetail.getData().getCourseDetail().getCat_type());
            intent.putExtra(Const.DELIVERY_CHARGE, cousedetail.getData().getCourseDetail().getDelivery_charge());
            Helper.gotoActivity(intent, this.activity);
        }
    }

    private void setData(JSONObject jsonObject, JSONObject jsonobject, int i) throws JSONException {
        CourseDetailTable courseDetailTable = new CourseDetailTable();
        courseDetailTable.setCourse_title(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
        courseDetailTable.setCourse_id(parentCourseId + "_" + jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
        courseDetailTable.setCover_image(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
        courseDetailTable.setDesc_header_image(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
        courseDetailTable.setMrp(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
        courseDetailTable.setCourse_sp(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
        courseDetailTable.setValidity(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
        courseDetailTable.setIs_purchased(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("is_purchased"));
        courseDetailTable.setIs_activated(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
        courseDetailTable.setToken_activation(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
        courseDetailTable.setTransaction_status(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.TRANSACTION_STATUS));
        courseDetailTable.setTax(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
        courseDetailTable.setView_type(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
        courseDetailTable.setIs_combo(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("external_coupon_off")) {
            courseDetailTable.setExternal_coupon_off(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("external_coupon_off"));
        } else {
            courseDetailTable.setExternal_coupon_off("");
        }
        courseDetailTable.setAuthor_title(jsonObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
        if (jsonObject.getJSONArray("tiles").getJSONObject(i).has("thumbnail")) {
            courseDetailTable.setThumbnail(jsonObject.getJSONArray("tiles").getJSONObject(i).getString("thumbnail"));
        }
        courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jsonObject, i, "id"));
        courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jsonObject, i, "meta"));
        courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jsonObject, i, "set_as_demo"));
        courseDetailTable.setUser_id(MakeMyExam.userId);
        courseDetailTable.setContent_type(this.content_type);
        courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jsonObject, i, Const.REVERT_API));
        courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jsonObject, i, "tile_name"));
        courseDetailTable.setType(Helper.checkAndGetCourseTileData(jsonObject, i, "type"));
        courseDetailTable.setInstallment(jsonObject.getJSONObject("instalment").toString());
        courseDetailTable.setDisplay_locked(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("display_locked"));
        courseDetailTable.setIs_gst(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("avg_rating") && !TextUtils.isEmpty(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"))) {
            courseDetailTable.setAvg_rating(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("avg_rating"));
        } else {
            courseDetailTable.setAvg_rating("");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("user_rated") && !TextUtils.isEmpty(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("user_rated"))) {
            courseDetailTable.setUser_rated(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("user_rated"));
        } else {
            courseDetailTable.setUser_rated("");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).has("stocks") && !TextUtils.isEmpty(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("stocks"))) {
            courseDetailTable.setStocks(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("stocks"));
        } else {
            courseDetailTable.setStocks("");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment") != null) {
            courseDetailTable.setSkip_payment(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("skip_payment"));
        } else {
            courseDetailTable.setSkip_payment("1");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("cat_type") != null) {
            courseDetailTable.setCat_type(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("cat_type"));
        } else {
            courseDetailTable.setCat_type("");
        }
        if (jsonObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.DELIVERY_CHARGE) != null) {
            courseDetailTable.setDelivery_charge(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.DELIVERY_CHARGE));
        } else {
            courseDetailTable.setDelivery_charge("0");
        }
        courseDetailTable.setTxn_id(jsonObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
        if (jsonobject.optJSONObject("data").optJSONObject("subscription_all_data") != null) {
            courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject("data").optJSONObject("subscription_all_data").toString(), SubscriptionAllData.class)));
        }
        utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView addToLib;
        TextView buyNowId;
        TextView courseTitle;
        TextView discount;
        TextView exploreId;
        TextView freeCourseText;
        ImageView imageBanner;
        TextView originalPrice;
        LinearLayout paidCourseLay;
        TextView price;
        TextView validity;

        public CourseViewHolder(View itemView) {
            super(itemView);
            this.imageBanner = (ImageView) itemView.findViewById(R.id.imageBanner);
            this.courseTitle = (TextView) itemView.findViewById(R.id.courseTitle);
            this.validity = (TextView) itemView.findViewById(R.id.validity);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.discount = (TextView) itemView.findViewById(R.id.discount);
            this.originalPrice = (TextView) itemView.findViewById(R.id.originalPrice);
            this.paidCourseLay = (LinearLayout) itemView.findViewById(R.id.paidCourseLay);
            this.exploreId = (TextView) itemView.findViewById(R.id.exploreId);
            this.buyNowId = (TextView) itemView.findViewById(R.id.buyNowId);
            this.addToLib = (TextView) itemView.findViewById(R.id.addToLib);
            this.freeCourseText = (TextView) itemView.findViewById(R.id.freeCourseText);
            if (this.courseTitle == null || this.validity == null || this.price == null || this.discount == null || this.originalPrice == null) {
                throw new IllegalStateException("One or more views are null in CourseViewHolder");
            }
        }

        public void bind(Courselist courselist) {
            this.courseTitle.setText(courselist.getTitle());
            this.validity.setText(String.format(" %s", courselist.getValidity() + " Days"));
            Glide.with(this.itemView.getContext()).load(courselist.getDescHeaderImage()).error(R.drawable.ic_launcher_background).placeholder(R.drawable.ic_launcher_background).into(this.imageBanner);
        }
    }

    class ClassViewHolder extends RecyclerView.ViewHolder {
        ImageView courseImage;
        TextView courseName;
        TextView liveDate;
        ImageView liveIV;
        TextView liveTime;
        RelativeLayout liveWatchRL;
        ImageView lockIcon;
        ImageView share;
        TextView studyItemTitle;
        TextView timing;

        public ClassViewHolder(View itemView) {
            super(itemView);
            this.courseName = (TextView) itemView.findViewById(R.id.courseName);
            this.studyItemTitle = (TextView) itemView.findViewById(R.id.studyItemTitle);
            this.liveDate = (TextView) itemView.findViewById(R.id.liveDate);
            this.liveTime = (TextView) itemView.findViewById(R.id.liveTime);
            this.timing = (TextView) itemView.findViewById(R.id.timing);
            this.courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            this.share = (ImageView) itemView.findViewById(R.id.share);
            this.liveWatchRL = (RelativeLayout) itemView.findViewById(R.id.liveWatchRL);
            this.lockIcon = (ImageView) itemView.findViewById(R.id.lockIcon);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(1000L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            this.liveIV.startAnimation(alphaAnimation);
        }

        public void bind(final Datum data, final Activity activity, final int position) {
            if (data == null) {
                return;
            }
            EduCCAdapter.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
            Helper.applyPrimaryColorLight(activity, this.liveWatchRL, 10.0f, R.drawable.discount_light_bg);
            this.courseName.setText(data.getTitle());
            this.studyItemTitle.setText(data.getDescription());
            this.liveDate.setText("Start Date: " + new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(data.getStartdate()) * 1000)));
            this.liveTime.setText(data.getStartdate());
            this.timing.setText(data.getVideoLength());
            Glide.with(this.itemView.getContext()).load(data.getThumbnailUrl()).error(R.mipmap.square_placeholder_new).placeholder(R.mipmap.square_placeholder_new).into(this.courseImage);
            this.lockIcon.setVisibility((data.getIs_lock() == null || !data.getIs_lock().equalsIgnoreCase("1")) ? 8 : 0);
            this.liveIV.setVisibility((data.getIs_live() == null || !data.getIs_live().equalsIgnoreCase("1")) ? 8 : 0);
            this.liveWatchRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.EduCCAdapter.ClassViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Helper.isNetworkConnected(activity)) {
                        if (data.getIs_lock().equalsIgnoreCase("0")) {
                            if (data.getVideoType().equalsIgnoreCase("5")) {
                                if (data.getLiveStatus().equalsIgnoreCase("1")) {
                                    if (TextUtils.isEmpty(data.getFileUrl()) && TextUtils.isEmpty(data.getId())) {
                                        Activity activity2 = activity;
                                        Toast.makeText(activity2, activity2.getResources().getString(R.string.url_is_not_found), 0).show();
                                        return;
                                    } else {
                                        Helper.GoToLiveAwsVideoActivityDatumLiveCls(data.getVideoType(), data.getChatNode(), activity, data.getFileUrl(), "5", data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getPayload().getCourse_id(), data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIschatlock(), "0", SingleStudy.parentCourseId, data.getStartdate(), Helper.addToList(data));
                                        return;
                                    }
                                }
                                if (data.getLiveStatus().equalsIgnoreCase("0")) {
                                    Activity activity3 = activity;
                                    Toast.makeText(activity3, activity3.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                                    return;
                                } else if (data.getLiveStatus().equalsIgnoreCase("2")) {
                                    Activity activity4 = activity;
                                    Toast.makeText(activity4, activity4.getResources().getString(R.string.live_class_is_ended), 0).show();
                                    return;
                                } else {
                                    if (data.getLiveStatus().equalsIgnoreCase("3")) {
                                        Activity activity5 = activity;
                                        Toast.makeText(activity5, activity5.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (data.getVideoType().equalsIgnoreCase("4")) {
                                if (data.getLiveStatus().equalsIgnoreCase("1")) {
                                    if (TextUtils.isEmpty(data.getFileUrl()) && TextUtils.isEmpty(data.getId())) {
                                        Activity activity6 = activity;
                                        Toast.makeText(activity6, activity6.getResources().getString(R.string.url_is_not_found), 0).show();
                                        return;
                                    } else if (data.getOpenInApp().equalsIgnoreCase("1")) {
                                        Helper.GoToLiveVideoActivity(data.getChatNode(), activity, data.getFileUrl(), data.getVideoType(), data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getIschatlock(), data.getPayload().getCourse_id(), String.valueOf(position), "", data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIs_live(), new ArrayList());
                                        return;
                                    } else {
                                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + data.getFileUrl())));
                                        return;
                                    }
                                }
                                if (data.getLiveStatus().equalsIgnoreCase("0")) {
                                    Activity activity7 = activity;
                                    Toast.makeText(activity7, activity7.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                                    return;
                                } else if (data.getLiveStatus().equalsIgnoreCase("2")) {
                                    Activity activity8 = activity;
                                    Toast.makeText(activity8, activity8.getResources().getString(R.string.live_class_is_ended), 0).show();
                                    return;
                                } else {
                                    if (data.getLiveStatus().equalsIgnoreCase("3")) {
                                        Activity activity9 = activity;
                                        Toast.makeText(activity9, activity9.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (data.getVideoType().equalsIgnoreCase("0")) {
                                Helper.GoToLiveAwsVideoActivityDatumLiveCls(data.getVideoType(), data.getChatNode(), activity, data.getId(), data.getVideoType(), data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getPayload().getCourse_id(), data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIschatlock(), "0", SingleStudy.parentCourseId, data.getStartdate(), Helper.addToList(data));
                                return;
                            }
                            if (data.getVideoType().equalsIgnoreCase("1")) {
                                if (data.getOpenInApp() != null && data.getOpenInApp().equalsIgnoreCase("1")) {
                                    Helper.GoToLiveVideoActivity(data.getChatNode(), activity, data.getFileUrl(), data.getIs_live(), data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getIschatlock(), data.getPayload().getCourse_id(), String.valueOf(position), SingleStudy.parentCourseId, data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIs_live(), new ArrayList());
                                    return;
                                } else {
                                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + data.getFileUrl())));
                                    return;
                                }
                            }
                            if (data.getVideoType().equalsIgnoreCase("6")) {
                                return;
                            }
                            if (data.getVideoType().equalsIgnoreCase("7")) {
                                if (data.getIsdrm().equals("0")) {
                                    if (TextUtils.isEmpty(data.getFileUrl()) && TextUtils.isEmpty(data.getId())) {
                                        Activity activity10 = activity;
                                        Toast.makeText(activity10, activity10.getResources().getString(R.string.url_is_not_found), 0).show();
                                        return;
                                    } else {
                                        Helper.GoToLiveAwsVideoActivityDatumLiveCls(data.getVideoType(), data.getChatNode(), activity, data.getFileUrl(), "0", data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getPayload().getCourse_id(), data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIschatlock(), "0", SingleStudy.parentCourseId, data.getStartdate(), Helper.addToList(data));
                                        return;
                                    }
                                }
                                if (data.getIsdrm().equals("1")) {
                                    if (TextUtils.isEmpty(data.getFileUrl()) && TextUtils.isEmpty(data.getId())) {
                                        Activity activity11 = activity;
                                        Toast.makeText(activity11, activity11.getResources().getString(R.string.url_is_not_found), 0).show();
                                        return;
                                    } else {
                                        Helper.GoToVideoCryptActivity(activity, data.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), data.getVideoType(), data.getChatNode(), data.getId(), data.getVideoType(), data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getPayload().getCourse_id(), data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIschatlock(), String.valueOf(position), SingleStudy.parentCourseId, data.getStartdate(), "0", new ArrayList());
                                        return;
                                    }
                                }
                                return;
                            }
                            if (data.getVideoType().equalsIgnoreCase("8")) {
                                if (data.getIsdrm().equals("0")) {
                                    if (data.getLiveStatus().equalsIgnoreCase("1")) {
                                        if (TextUtils.isEmpty(data.getFileUrl()) && TextUtils.isEmpty(data.getId())) {
                                            Activity activity12 = activity;
                                            Toast.makeText(activity12, activity12.getResources().getString(R.string.url_is_not_found), 0).show();
                                            return;
                                        } else {
                                            Helper.GoToLiveAwsVideoActivity(data.getVideoType(), data.getChatNode(), activity, data.getFileUrl(), "5", data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getPayload().getCourse_id(), data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIschatlock(), "", "", data.getStartdate(), new ArrayList());
                                            return;
                                        }
                                    }
                                    if (data.getLiveStatus().equalsIgnoreCase("0")) {
                                        Activity activity13 = activity;
                                        Toast.makeText(activity13, activity13.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                                        return;
                                    } else if (data.getLiveStatus().equalsIgnoreCase("2")) {
                                        Activity activity14 = activity;
                                        Toast.makeText(activity14, activity14.getResources().getString(R.string.live_class_is_ended), 0).show();
                                        return;
                                    } else {
                                        if (data.getLiveStatus().equalsIgnoreCase("3")) {
                                            Activity activity15 = activity;
                                            Toast.makeText(activity15, activity15.getResources().getString(R.string.live_class_is_ended), 0).show();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (data.getIsdrm().equals("1")) {
                                    if (data.getLiveStatus().equalsIgnoreCase("1")) {
                                        if (TextUtils.isEmpty(data.getFileUrl()) && TextUtils.isEmpty(data.getId())) {
                                            Activity activity16 = activity;
                                            Toast.makeText(activity16, activity16.getResources().getString(R.string.url_is_not_found), 0).show();
                                            return;
                                        } else {
                                            Helper.GoToVideoCryptActivity(activity, data.getVdc_id(), SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getDeviceId(), data.getVideoType(), data.getChatNode(), data.getId(), data.getVideoType(), data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getPayload().getCourse_id(), data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIschatlock(), String.valueOf(position), SingleStudy.parentCourseId, data.getStartdate(), "0", new ArrayList());
                                            return;
                                        }
                                    }
                                    if (data.getLiveStatus().equalsIgnoreCase("0")) {
                                        Activity activity17 = activity;
                                        Toast.makeText(activity17, activity17.getResources().getString(R.string.live_class_is_not_started_yet), 0).show();
                                        return;
                                    } else if (data.getLiveStatus().equalsIgnoreCase("2")) {
                                        Activity activity18 = activity;
                                        Toast.makeText(activity18, activity18.getResources().getString(R.string.live_class_is_ended), 0).show();
                                        return;
                                    } else {
                                        if (data.getLiveStatus().equalsIgnoreCase("3")) {
                                            Activity activity19 = activity;
                                            Toast.makeText(activity19, activity19.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            if (data.getVideoType().equalsIgnoreCase("9")) {
                                if (data.getLiveStatus().equalsIgnoreCase("1")) {
                                    if (data.getZoom_meeting_id().equalsIgnoreCase("") && data.getZoom_meeting_passcode().equalsIgnoreCase("")) {
                                        return;
                                    }
                                    if (!SharedPreference.getInstance().getString(Const.ZOOM_ACCESS_KEY).equalsIgnoreCase("")) {
                                        ZoomFeatureHelper.launchZoomFeature(activity, data.getZoom_meeting_id(), data.getZoom_meeting_passcode(), "qwertyui", SharedPreference.getInstance().getLoggedInUser().getId(), SharedPreference.getInstance().getLoggedInUser().getName(), SharedPreference.getInstance().getLoggedInUser().getEmail(), SharedPreference.getInstance().getLoggedInUser().getMobile());
                                        return;
                                    }
                                    Toast.makeText(activity, "Zoom SDK key not found!", 0).show();
                                    return;
                                }
                                if (data.getLiveStatus().equalsIgnoreCase("2")) {
                                    if (!data.getFileUrl().equalsIgnoreCase("") || !data.getFileUrl().isEmpty()) {
                                        Intent intent = new Intent(activity, (Class<?>) ZoomRecodedPlayer.class);
                                        intent.putExtra("videoUrl", data.getFileUrl());
                                        intent.putExtra(Const.VIDEO_ID, data.getId());
                                        activity.startActivity(intent);
                                        return;
                                    }
                                    Toast.makeText(activity, "No Video Found !", 0).show();
                                    return;
                                }
                                Toast.makeText(activity, "Zoom class is not yet started.", 0).show();
                                return;
                            }
                            if (data.getVideoType().equalsIgnoreCase("11")) {
                                Datum datum = data;
                                if (datum.getFileUrl() != null && datum.getFileUrl().isEmpty()) {
                                    Activity activity20 = activity;
                                    Toast.makeText(activity20, activity20.getResources().getString(R.string.url_is_not_found), 0).show();
                                    return;
                                }
                                if (datum.getLiveStatus().equalsIgnoreCase("0")) {
                                    Toast.makeText(activity, activity.getResources().getString(R.string.live_class_will_start_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(datum.getStartdate()) * 1000)), 0).show();
                                    return;
                                }
                                if (datum.getLiveStatus().equalsIgnoreCase("2")) {
                                    Activity activity21 = activity;
                                    Toast.makeText(activity21, activity21.getResources().getString(R.string.live_class_is_ended), 0).show();
                                    return;
                                } else if (datum.getLiveStatus().equalsIgnoreCase("3")) {
                                    Activity activity22 = activity;
                                    Toast.makeText(activity22, activity22.getResources().getString(R.string.live_class_is_cancelled), 0).show();
                                    return;
                                } else {
                                    try {
                                        Helper.goToIvsPlayerActivity(activity, data.getVideoType(), data.getChatNode(), data.getFileUrl(), "5", data.getId(), data.getTitle(), "0", data.getThumbnailUrl(), data.getPayload().getCourse_id(), data.getPayload().getTile_id(), data.getPayload().getTile_type(), data.getIschatlock(), "", "", data.getStartdate(), new ArrayList());
                                        return;
                                    } catch (Exception e2) {
                                        Helper.logPrinter("LiveClass: ", "e", e2.getLocalizedMessage(), "");
                                        return;
                                    }
                                }
                            }
                            if (!data.getFileUrl().equalsIgnoreCase("") || !data.getFileUrl().isEmpty()) {
                                Intent intent2 = new Intent(activity, (Class<?>) ZoomRecodedPlayer.class);
                                intent2.putExtra("videoUrl", data.getFileUrl());
                                intent2.putExtra(Const.VIDEO_ID, data.getId());
                                activity.startActivity(intent2);
                                return;
                            }
                            Toast.makeText(activity, "No Video Found yet please some time !", 0).show();
                            return;
                        }
                        EduCCAdapter.parentCourseId = data.getPayload().getCourse_id();
                        EduCCAdapter.mainCourseId = data.getPayload().getCourse_id();
                        ClassViewHolder.this.getCourseDetailsData(data.getPayload().getCourse_id(), data.getPayload().getCourse_id(), activity);
                        return;
                    }
                    Helper.showInternetToast(activity);
                }
            });
            this.share.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.EduCCAdapter.ClassViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Helper.shareLiveClass(activity, data.getPayload().getCourse_id(), data.getId(), data.getPayload().getTopic_id(), data.getPayload().getTile_type(), data.getPayload().getTile_id(), data.getPayload().getRevert_api(), "video", data.getThumbnailUrl(), data.getTitle(), "", "1");
                }
            });
        }

        public void getCourseDetailsData(String parentCourseId, String mainCourseId, Activity activity) {
            if (!EduCCAdapter.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, parentCourseId + "_" + mainCourseId)) {
                new NetworkCall(EduCCAdapter.this, activity).NetworkAPICall(API.CourseDetail_JS, "", true, false);
                return;
            }
            List<CourseDetailTable> list = EduCCAdapter.utkashRoom.getCourseDetaildata().getcoursedetail(parentCourseId + "_" + mainCourseId, MakeMyExam.userId);
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
            courseDetailData.setCover_image(list.get(0).getCover_image());
            courseDetailData.setDescHeaderImage(list.get(0).getDesc_header_image());
            courseDetailData.setIsPurchased(list.get(0).getIs_purchased());
            courseDetailData.setViewType(list.get(0).getView_type());
            courseDetailData.setIs_combo(list.get(0).getIs_combo());
            courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
            if (list.get(0).getAvg_rating() != null) {
                courseDetailData.setAvg_rating(list.get(0).getAvg_rating());
                courseDetailData.setUser_rated(list.get(0).getUser_rated());
                courseDetailData.setStocks(list.get(0).getStocks());
            }
            courseDetailData.setSkip_payment(list.get(0).getSkip_payment());
            courseDetailData.setCat_type(list.get(0).getCat_type());
            courseDetailData.setDelivery_charge(list.get(0).getDelivery_charge());
            courseDetailData.setIs_activated(list.get(0).getIs_activated());
            courseDetailData.setToken_activation(list.get(0).getToken_activation());
            courseDetailData.setTransaction_status(list.get(0).getTransaction_status());
            courseDetailData.setTxn_id(list.get(0).getTxn_id());
            courseDetailData.setInstallment(list.get(0).getInstallment());
            courseDetailData.setIs_gst(list.get(0).getIs_gst());
            courseDetailData.setDisplay_locked(list.get(0).getDisplay_locked());
            EduCCAdapter.cousedetail = new CourseDetail();
            Data data = new Data();
            data.setCourseDetail(courseDetailData);
            if (list.size() > 0 && list.get(0) != null && list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).getType().equalsIgnoreCase(Const.COMBO);
                arrayList.add(new TilesItem(list.get(i).getTile_revert(), list.get(i).getTile_title(), list.get(i).getTile_id(), list.get(i).getType(), list.get(i).getTile_meta(), list.get(i).getSet_as_demo(), list.get(i).getThumbnail()));
            }
            data.setTiles(arrayList);
            EduCCAdapter.cousedetail.setData(data);
            Intent intent = new Intent(activity, (Class<?>) PurchaseActivity.class);
            intent.putExtra(Const.SINGLE_STUDY, EduCCAdapter.cousedetail);
            if (EduCCAdapter.cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("1")) {
                intent.putExtra("quantityOfBooks", "1");
            }
            intent.putExtra(Const.IS_BOOK, EduCCAdapter.cousedetail.getData().getCourseDetail().getCat_type());
            intent.putExtra(Const.DELIVERY_CHARGE, EduCCAdapter.cousedetail.getData().getCourseDetail().getDelivery_charge());
            Helper.gotoActivity(intent, activity);
        }
    }
}
