package com.appnew.android.Educator.adpter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.COURSEDETAIL.Author;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Model.COURSEDETAIL.CourseDetailData;
import com.appnew.android.Model.COURSEDETAIL.Data;
import com.appnew.android.Model.COURSEDETAIL.TilesItem;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Model.Courses.InstallmentResponse;
import com.appnew.android.Model.subscription.SubscriptionAllData;
import com.appnew.android.Payment.InstantPurchase;
import com.appnew.android.Payment.PaymentGatewayListener;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.table.CourseDetailTable;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class HomeTCAdapter extends RecyclerView.Adapter<TCViewHolder> implements NetworkCall.MyNetworkCallBack {
    private Activity activity;
    String content_type;
    private ArrayList<Courselist> courseLists;
    CourseDetail cousedetail;
    NetworkCall networkCall;
    PaymentGatewayListener paymentGatewayListener;
    PaymentResultListener paymentResultListener;
    InstantPurchase purchaseBottomSheetFragment;
    String parentCourseId = "";
    public String mainCourseId = "";
    long mLastClickTime = 0;
    UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public HomeTCAdapter(Activity activity, ArrayList<Courselist> courseLists, PaymentGatewayListener paymentGatewayListener, PaymentResultListener paymentResultListener) {
        this.activity = activity;
        this.courseLists = courseLists;
        this.paymentGatewayListener = paymentGatewayListener;
        this.paymentResultListener = paymentResultListener;
        this.networkCall = new NetworkCall(this, activity);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TCViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.home_trending_class_item, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final TCViewHolder holder, int position) {
        final Courselist courselist = this.courseLists.get(position);
        Helper.applyPrimaryColorLight(this.activity, holder.discountRLTC, 6.0f, R.drawable.discount_bg);
        Helper.applyPrimaryColorLight(this.activity, holder.exploreIdTC, 10.0f, R.drawable.discount_light_bg);
        Glide.with(this.activity).load(courselist.getCover_image()).placeholder(R.mipmap.square_placeholder_new).into(holder.courseBannerTC);
        holder.courseTitleTC.setText(courselist.getTitle());
        holder.buyNowIdTC.setEnabled(true);
        holder.buyNowIdTC.setText(R.string.buy_now);
        holder.buyNowIdTC.setBackgroundResource(R.drawable.discount_solid_bg);
        holder.buyNowIdTC.setTextColor(this.activity.getResources().getColor(R.color.white));
        if (holder.soldOutImgTC != null) {
            holder.soldOutImgTC.setVisibility(8);
        }
        holder.liveIV.clearAnimation();
        holder.liveIV.setVisibility(8);
        holder.newCourse.setVisibility(8);
        boolean zEquals = "1".equals(courselist.getExtra_json().getIs_new());
        boolean zEquals2 = "1".equals(courselist.getExtra_json().getIs_live());
        final boolean z = courselist.getExtra_json() != null && "1".equals(courselist.getExtra_json().getSold_out());
        final boolean zEquals3 = "1".equals(courselist.getIs_purchased());
        holder.newCourse.setVisibility(zEquals ? 0 : 8);
        holder.liveIV.setVisibility(zEquals2 ? 0 : 8);
        if (zEquals) {
            Glide.with(this.activity).asGif().load(Integer.valueOf(R.mipmap.new_)).into(holder.newCourse);
        }
        if (zEquals2) {
            Glide.with(this.activity).asGif().load(Integer.valueOf(R.mipmap.live)).into(holder.liveIV);
        }
        int i = !TextUtils.isEmpty(courselist.getDiscount()) ? (int) Double.parseDouble(courselist.getDiscount()) : 0;
        if (courselist.getCourseSp() != null && courselist.getCourseSp().equalsIgnoreCase("0")) {
            holder.buyNowIdTC.setVisibility(8);
            holder.exploreIdTC.setVisibility(0);
            holder.priceTC.setText(this.activity.getResources().getString(R.string.free));
            holder.priceTC.setTextAlignment(2);
            holder.validityTC.setText(courselist.getValidity());
            holder.originalPriceTC.setVisibility(8);
            holder.discountTC.setVisibility(8);
        } else {
            if (courselist.getIs_purchased() != null && courselist.getIs_purchased().equalsIgnoreCase("1")) {
                holder.buyNowIdTC.setVisibility(8);
                holder.exploreIdTC.setVisibility(0);
            } else {
                holder.buyNowIdTC.setVisibility(0);
                holder.exploreIdTC.setVisibility(8);
            }
            if (courselist.getCourseSp() != null && courselist.getCourseSp().equalsIgnoreCase(courselist.getMrp())) {
                holder.originalPriceTC.setVisibility(8);
                holder.discountTC.setVisibility(0);
                setDiscount(holder, i);
                holder.validityTC.setText(courselist.getValidity());
                holder.priceTC.setText(String.format("%s%s%s", Constants.currencyType, courselist.getCourseSp(), "/-"));
                holder.originalPriceTC.setText(String.format("%s%s%s", Constants.currencyType, courselist.getMrp(), "/-"));
            } else {
                holder.validityTC.setText(courselist.getValidity());
                holder.priceTC.setText(String.format("%s%s%s", Constants.currencyType, courselist.getCourseSp(), "/-"));
                holder.originalPriceTC.setText(String.format("%s%s%s", Constants.currencyType, courselist.getMrp(), "/-"));
                holder.originalPriceTC.setPaintFlags(holder.originalPriceTC.getPaintFlags() | 16);
                setDiscount(holder, i);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.HomeTCAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Helper.isNetworkConnected(HomeTCAdapter.this.activity)) {
                    Helper.SingleClick(holder.itemView);
                    if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                        Intent intent = new Intent(HomeTCAdapter.this.activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                        intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                        intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                        Helper.gotoActivity(intent, HomeTCAdapter.this.activity);
                        return;
                    }
                    Helper.getCourseMaintanaceDialog(HomeTCAdapter.this.activity, "", courselist.getMaintenanceText());
                    return;
                }
                Helper.showInternetToast(HomeTCAdapter.this.activity);
            }
        });
        holder.exploreIdTC.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.HomeTCAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Helper.isNetworkConnected(HomeTCAdapter.this.activity)) {
                    if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                        Intent intent = new Intent(HomeTCAdapter.this.activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                        intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                        intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                        Helper.gotoActivity(intent, HomeTCAdapter.this.activity);
                        return;
                    }
                    Helper.getCourseMaintanaceDialog(HomeTCAdapter.this.activity, "", courselist.getMaintenanceText());
                    return;
                }
                Helper.showInternetToast(HomeTCAdapter.this.activity);
            }
        });
        holder.buyNowIdTC.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.HomeTCAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (z && !zEquals3) {
                    Toast.makeText(HomeTCAdapter.this.activity, R.string.sold_out_msg, 0).show();
                    return;
                }
                if (SystemClock.elapsedRealtime() - HomeTCAdapter.this.mLastClickTime < 1000) {
                    return;
                }
                HomeTCAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
                if (!Helper.isConnected(HomeTCAdapter.this.activity)) {
                    Helper.showInternetToast(HomeTCAdapter.this.activity);
                    return;
                }
                HomeTCAdapter.this.mainCourseId = courselist.getId();
                HomeTCAdapter.this.parentCourseId = "";
                Courselist courselist2 = courselist;
                if (courselist2 != null && courselist2.getCombo_course_ids() != null && courselist.getCombo_course_ids().isEmpty()) {
                    HomeTCAdapter homeTCAdapter = HomeTCAdapter.this;
                    homeTCAdapter.parentCourseId = homeTCAdapter.mainCourseId;
                }
                HomeTCAdapter.this.networkCall.NetworkAPICall(API.CourseDetail_JS, "", true, false);
            }
        });
        if (z && !zEquals3) {
            holder.buyNowIdTC.setVisibility(0);
            holder.exploreIdTC.setVisibility(8);
            holder.buyNowIdTC.setEnabled(true);
            holder.buyNowIdTC.setText(R.string.sold_out);
            holder.buyNowIdTC.setBackgroundResource(R.drawable.sold_out_solid);
            holder.buyNowIdTC.setTextColor(this.activity.getResources().getColor(R.color.white));
            if (holder.soldOutImgTC != null) {
                holder.soldOutImgTC.setVisibility(0);
                return;
            }
            return;
        }
        holder.buyNowIdTC.setEnabled(true);
        holder.buyNowIdTC.setText(R.string.buy_now);
        holder.buyNowIdTC.setBackgroundResource(R.drawable.discount_solid_bg);
        if (holder.soldOutImgTC != null) {
            holder.soldOutImgTC.setVisibility(8);
        }
    }

    private void setDiscount(TCViewHolder holder, int a2) {
        if (a2 == 0) {
            holder.discountTC.setVisibility(8);
        } else {
            holder.discountTC.setText(String.format("%s", a2 + "% off"));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<Courselist> arrayList = this.courseLists;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.CourseDetail_JS)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.mainCourseId);
        encryptionData.setParent_id(this.parentCourseId);
        return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        JSONObject jSONObject;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        int i;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        apitype.hashCode();
        if (apitype.equals(API.CourseDetail_JS)) {
            if (jsonobject.optString("status").equals("true")) {
                JSONObject jSONObjectOptJSONObject = jsonobject.optJSONObject("data");
                String str40 = "is_purchased";
                String strOptString = (jSONObjectOptJSONObject.has(Const.COURSE_DETAIL) && jSONObjectOptJSONObject.optJSONObject(Const.COURSE_DETAIL).has("is_purchased")) ? jSONObjectOptJSONObject.optJSONObject(Const.COURSE_DETAIL).optString("is_purchased") : "0";
                SharedPreference.getInstance().putString(Const.IS_IGST, jSONObjectOptJSONObject.optString(Const.IS_IGST));
                String str41 = "_";
                String str42 = "id";
                String str43 = "type";
                String str44 = "1";
                String str45 = "skip_payment";
                String str46 = strOptString;
                String str47 = "tiles";
                String str48 = "subscription_all_data";
                String str49 = "cat_type";
                String str50 = "hide_validity";
                String str51 = "data";
                String str52 = "title";
                String str53 = "0";
                String str54 = "tax_rate";
                String str55 = "combo_has_book";
                String str56 = "external_coupon_off";
                String str57 = "";
                if (this.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, this.parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"))) {
                    str = Const.DELIVERY_CHARGE;
                    str2 = "cat_type";
                    str3 = "hide_validity";
                    str4 = "tiles";
                    str5 = "skip_payment";
                    str6 = "type";
                    str7 = str48;
                    str8 = str51;
                    str9 = str53;
                    str10 = "is_purchased";
                    str11 = "";
                    str12 = "1";
                    str13 = "id";
                    jSONObject = jsonobject;
                } else {
                    str = Const.DELIVERY_CHARGE;
                    int i2 = 0;
                    while (true) {
                        str15 = str50;
                        if (i2 >= jSONObjectOptJSONObject.getJSONArray(str47).length()) {
                            break;
                        }
                        if (str44.equalsIgnoreCase("7")) {
                            String str58 = str57;
                            String str59 = str49;
                            if (Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43).equalsIgnoreCase("content")) {
                                str16 = str45;
                                str19 = str51;
                                str18 = str48;
                                str20 = str53;
                                str22 = str40;
                                str24 = str44;
                                str29 = str42;
                                str23 = str58;
                                str26 = str15;
                                i = i2;
                                str27 = str43;
                                str25 = str59;
                                str31 = str47;
                                str30 = str19;
                            } else {
                                CourseDetailTable courseDetailTable = new CourseDetailTable();
                                courseDetailTable.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                String str60 = str44;
                                courseDetailTable.setCourse_id(this.parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str42));
                                courseDetailTable.setCover_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                                courseDetailTable.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                                courseDetailTable.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                                courseDetailTable.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                                courseDetailTable.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                                courseDetailTable.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str40));
                                courseDetailTable.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                                courseDetailTable.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                                courseDetailTable.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                                courseDetailTable.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                                courseDetailTable.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                                courseDetailTable.setDisplay_locked(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("display_locked"));
                                courseDetailTable.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                                courseDetailTable.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str42));
                                courseDetailTable.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "meta"));
                                courseDetailTable.setUser_id(MakeMyExam.userId);
                                courseDetailTable.setContent_type(this.content_type);
                                if (jSONObjectOptJSONObject.getJSONArray(str47).getJSONObject(i2).has("thumbnail")) {
                                    courseDetailTable.setThumbnail(jSONObjectOptJSONObject.getJSONArray(str47).getJSONObject(i2).getString("thumbnail"));
                                }
                                courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                                courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                                courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43));
                                courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                                courseDetailTable.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                                courseDetailTable.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str45) != null) {
                                    courseDetailTable.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str45));
                                    str37 = str60;
                                } else {
                                    str37 = str60;
                                    courseDetailTable.setSkip_payment(str37);
                                }
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str59) != null) {
                                    courseDetailTable.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str59));
                                    str38 = str58;
                                } else {
                                    str38 = str58;
                                    courseDetailTable.setCat_type(str38);
                                }
                                str17 = str59;
                                str16 = str45;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15) != null) {
                                    courseDetailTable.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15));
                                } else {
                                    courseDetailTable.setHide_validity(str38);
                                }
                                String str61 = str;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str61) != null) {
                                    courseDetailTable.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str61));
                                    str39 = str53;
                                } else {
                                    str39 = str53;
                                    courseDetailTable.setDelivery_charge(str39);
                                }
                                str = str61;
                                str21 = str47;
                                courseDetailTable.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                String str62 = str56;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str62) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str62))) {
                                    courseDetailTable.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str62));
                                } else {
                                    courseDetailTable.setExternal_coupon_off(str38);
                                }
                                str56 = str62;
                                String str63 = str55;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str63) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str63))) {
                                    courseDetailTable.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str63));
                                } else {
                                    courseDetailTable.setCombo_has_book(str39);
                                }
                                str55 = str63;
                                String str64 = str54;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str64) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str64))) {
                                    courseDetailTable.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str64));
                                } else {
                                    courseDetailTable.setTax_rate(str39);
                                }
                                str54 = str64;
                                str19 = str51;
                                String str65 = str38;
                                str20 = str39;
                                String str66 = str48;
                                if (jsonobject.optJSONObject(str19).optJSONObject(str66) != null) {
                                    str22 = str40;
                                    str18 = str66;
                                    courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject(str19).optJSONObject(str66).toString(), SubscriptionAllData.class)));
                                } else {
                                    str22 = str40;
                                    str18 = str66;
                                }
                                this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
                                str24 = str37;
                                str23 = str65;
                                str26 = str15;
                                i = i2;
                                str27 = str43;
                                str25 = str17;
                                str30 = str19;
                                str31 = str21;
                                str29 = str42;
                            }
                        } else {
                            str16 = str45;
                            str17 = str49;
                            str18 = str48;
                            str19 = str51;
                            str20 = str53;
                            str21 = str47;
                            str22 = str40;
                            str23 = str57;
                            String str67 = this.content_type;
                            if (str67 != null && !TextUtils.isEmpty(str67) && this.content_type.equalsIgnoreCase(str44)) {
                                if (Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43).equalsIgnoreCase("content")) {
                                    str24 = str44;
                                    str26 = str15;
                                    i = i2;
                                    str27 = str43;
                                    str25 = str17;
                                    str30 = str19;
                                    str31 = str21;
                                } else {
                                    CourseDetailTable courseDetailTable2 = new CourseDetailTable();
                                    courseDetailTable2.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                    courseDetailTable2.setCourse_id(this.parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str42));
                                    courseDetailTable2.setCover_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                                    courseDetailTable2.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                                    courseDetailTable2.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                                    courseDetailTable2.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                                    courseDetailTable2.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                                    courseDetailTable2.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str22));
                                    courseDetailTable2.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                                    courseDetailTable2.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                                    courseDetailTable2.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                                    courseDetailTable2.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                                    courseDetailTable2.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                                    courseDetailTable2.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                                    courseDetailTable2.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str42));
                                    courseDetailTable2.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "meta"));
                                    courseDetailTable2.setUser_id(MakeMyExam.userId);
                                    courseDetailTable2.setContent_type(this.content_type);
                                    if (jSONObjectOptJSONObject.getJSONArray(str21).getJSONObject(i2).has("thumbnail")) {
                                        courseDetailTable2.setThumbnail(jSONObjectOptJSONObject.getJSONArray(str21).getJSONObject(i2).getString("thumbnail"));
                                    }
                                    courseDetailTable2.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                                    courseDetailTable2.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                                    courseDetailTable2.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43));
                                    courseDetailTable2.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                                    courseDetailTable2.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                                    courseDetailTable2.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str16) != null) {
                                        courseDetailTable2.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str16));
                                    } else {
                                        courseDetailTable2.setSkip_payment(str44);
                                    }
                                    String str68 = str44;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17) != null) {
                                        courseDetailTable2.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17));
                                    } else {
                                        courseDetailTable2.setCat_type(str23);
                                    }
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15) != null) {
                                        courseDetailTable2.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15));
                                    } else {
                                        courseDetailTable2.setHide_validity(str23);
                                    }
                                    String str69 = str;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str69) != null) {
                                        courseDetailTable2.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str69));
                                        str35 = str20;
                                    } else {
                                        str35 = str20;
                                        courseDetailTable2.setDelivery_charge(str35);
                                    }
                                    str = str69;
                                    str16 = str16;
                                    courseDetailTable2.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                    String str70 = str56;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str70) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str70))) {
                                        courseDetailTable2.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str70));
                                    } else {
                                        courseDetailTable2.setExternal_coupon_off(str23);
                                    }
                                    str56 = str70;
                                    String str71 = str55;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str71) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str71))) {
                                        courseDetailTable2.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str71));
                                    } else {
                                        courseDetailTable2.setCombo_has_book(str35);
                                    }
                                    str55 = str71;
                                    String str72 = str54;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str72) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str72))) {
                                        courseDetailTable2.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str72));
                                    } else {
                                        courseDetailTable2.setTax_rate(str35);
                                    }
                                    String str73 = str35;
                                    str54 = str72;
                                    if (jsonobject.optJSONObject(str19).optJSONObject(str18) != null) {
                                        Gson gson = new Gson();
                                        str36 = str23;
                                        String string = jsonobject.optJSONObject(str19).optJSONObject(str18).toString();
                                        str18 = str18;
                                        courseDetailTable2.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) gson.fromJson(string, SubscriptionAllData.class)));
                                    } else {
                                        str36 = str23;
                                        str18 = str18;
                                    }
                                    this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable2);
                                    str24 = str68;
                                    str26 = str15;
                                    str23 = str36;
                                    i = i2;
                                    str27 = str43;
                                    str20 = str73;
                                    str25 = str17;
                                    str31 = str21;
                                    str30 = str19;
                                }
                            } else {
                                String str74 = str44;
                                String str75 = str46;
                                if (str75.equalsIgnoreCase(str20)) {
                                    str46 = str75;
                                    if (Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43).equalsIgnoreCase("content")) {
                                        str29 = str42;
                                        str24 = str74;
                                        str23 = str23;
                                        i = i2;
                                        str20 = str20;
                                        str26 = str15;
                                        str25 = str17;
                                        str31 = str21;
                                        str27 = str43;
                                        str30 = str19;
                                    } else {
                                        CourseDetailTable courseDetailTable3 = new CourseDetailTable();
                                        courseDetailTable3.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                        courseDetailTable3.setCourse_id(this.parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str42));
                                        courseDetailTable3.setCover_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                                        courseDetailTable3.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                                        courseDetailTable3.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                                        courseDetailTable3.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                                        courseDetailTable3.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                                        courseDetailTable3.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str22));
                                        courseDetailTable3.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                                        courseDetailTable3.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                                        courseDetailTable3.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                                        courseDetailTable3.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                                        courseDetailTable3.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                                        courseDetailTable3.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                                        courseDetailTable3.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str42));
                                        courseDetailTable3.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "meta"));
                                        courseDetailTable3.setUser_id(MakeMyExam.userId);
                                        courseDetailTable3.setContent_type(this.content_type);
                                        if (jSONObjectOptJSONObject.getJSONArray(str21).getJSONObject(i2).has("thumbnail")) {
                                            courseDetailTable3.setThumbnail(jSONObjectOptJSONObject.getJSONArray(str21).getJSONObject(i2).getString("thumbnail"));
                                        }
                                        courseDetailTable3.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                                        courseDetailTable3.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                                        courseDetailTable3.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43));
                                        courseDetailTable3.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                                        courseDetailTable3.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                                        courseDetailTable3.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str16) != null) {
                                            courseDetailTable3.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str16));
                                            str32 = str74;
                                        } else {
                                            str32 = str74;
                                            courseDetailTable3.setSkip_payment(str32);
                                        }
                                        String str76 = str32;
                                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17) != null) {
                                            courseDetailTable3.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17));
                                            str33 = str23;
                                        } else {
                                            str33 = str23;
                                            courseDetailTable3.setCat_type(str33);
                                        }
                                        str16 = str16;
                                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15) != null) {
                                            courseDetailTable3.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15));
                                        } else {
                                            courseDetailTable3.setHide_validity(str33);
                                        }
                                        String str77 = str;
                                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str77) != null) {
                                            courseDetailTable3.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str77));
                                        } else {
                                            courseDetailTable3.setDelivery_charge(str20);
                                        }
                                        str = str77;
                                        courseDetailTable3.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                        String str78 = str56;
                                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str78) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str78))) {
                                            courseDetailTable3.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str78));
                                        } else {
                                            courseDetailTable3.setExternal_coupon_off(str33);
                                        }
                                        str56 = str78;
                                        String str79 = str55;
                                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str79) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str79))) {
                                            courseDetailTable3.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str79));
                                        } else {
                                            courseDetailTable3.setCombo_has_book(str20);
                                        }
                                        str55 = str79;
                                        String str80 = str54;
                                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str80) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str80))) {
                                            courseDetailTable3.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str80));
                                        } else {
                                            courseDetailTable3.setTax_rate(str20);
                                        }
                                        String str81 = str33;
                                        str54 = str80;
                                        if (jsonobject.optJSONObject(str19).optJSONObject(str18) != null) {
                                            Gson gson2 = new Gson();
                                            str34 = str20;
                                            String string2 = jsonobject.optJSONObject(str19).optJSONObject(str18).toString();
                                            str18 = str18;
                                            courseDetailTable3.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) gson2.fromJson(string2, SubscriptionAllData.class)));
                                        } else {
                                            str18 = str18;
                                            str34 = str20;
                                        }
                                        this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable3);
                                        str24 = str76;
                                        str26 = str15;
                                        str23 = str81;
                                        i = i2;
                                        str27 = str43;
                                        str20 = str34;
                                        str25 = str17;
                                        str31 = str21;
                                        str30 = str19;
                                    }
                                } else {
                                    str46 = str75;
                                    str23 = str23;
                                    CourseDetailTable courseDetailTable4 = new CourseDetailTable();
                                    courseDetailTable4.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                                    courseDetailTable4.setCourse_id(this.parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str42));
                                    courseDetailTable4.setCover_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                                    courseDetailTable4.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                                    courseDetailTable4.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                                    courseDetailTable4.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                                    courseDetailTable4.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                                    courseDetailTable4.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str22));
                                    courseDetailTable4.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                                    courseDetailTable4.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                                    courseDetailTable4.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                                    courseDetailTable4.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                                    courseDetailTable4.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                                    courseDetailTable4.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                                    courseDetailTable4.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str42));
                                    courseDetailTable4.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "meta"));
                                    courseDetailTable4.setUser_id(MakeMyExam.userId);
                                    courseDetailTable4.setContent_type(this.content_type);
                                    if (jSONObjectOptJSONObject.getJSONArray(str21).getJSONObject(i2).has("thumbnail")) {
                                        courseDetailTable4.setThumbnail(jSONObjectOptJSONObject.getJSONArray(str21).getJSONObject(i2).getString("thumbnail"));
                                    }
                                    courseDetailTable4.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                                    courseDetailTable4.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                                    courseDetailTable4.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43));
                                    courseDetailTable4.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                                    courseDetailTable4.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                                    courseDetailTable4.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str16) != null) {
                                        courseDetailTable4.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str16));
                                        str24 = str74;
                                    } else {
                                        str24 = str74;
                                        courseDetailTable4.setSkip_payment(str24);
                                    }
                                    i = i2;
                                    str25 = str17;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str25) != null) {
                                        courseDetailTable4.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str25));
                                    } else {
                                        courseDetailTable4.setCat_type(str23);
                                    }
                                    str16 = str16;
                                    str26 = str15;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str26) != null) {
                                        courseDetailTable4.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str26));
                                    } else {
                                        courseDetailTable4.setHide_validity(str23);
                                    }
                                    str27 = str43;
                                    String str82 = str;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str82) != null) {
                                        courseDetailTable4.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str82));
                                        str28 = str20;
                                    } else {
                                        str28 = str20;
                                        courseDetailTable4.setDelivery_charge(str28);
                                    }
                                    str = str82;
                                    str29 = str42;
                                    courseDetailTable4.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                    String str83 = str56;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str83) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str83))) {
                                        courseDetailTable4.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str83));
                                    } else {
                                        courseDetailTable4.setExternal_coupon_off(str23);
                                    }
                                    str56 = str83;
                                    String str84 = str55;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str84) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str84))) {
                                        courseDetailTable4.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str84));
                                    } else {
                                        courseDetailTable4.setCombo_has_book(str28);
                                    }
                                    str55 = str84;
                                    String str85 = str54;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str85) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str85))) {
                                        courseDetailTable4.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str85));
                                    } else {
                                        courseDetailTable4.setTax_rate(str28);
                                    }
                                    str54 = str85;
                                    str30 = str19;
                                    str20 = str28;
                                    if (jsonobject.optJSONObject(str30).optJSONObject(str18) != null) {
                                        Gson gson3 = new Gson();
                                        str31 = str21;
                                        String string3 = jsonobject.optJSONObject(str30).optJSONObject(str18).toString();
                                        str18 = str18;
                                        courseDetailTable4.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) gson3.fromJson(string3, SubscriptionAllData.class)));
                                    } else {
                                        str31 = str21;
                                        str18 = str18;
                                    }
                                    this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable4);
                                }
                            }
                            str29 = str42;
                        }
                        int i3 = i + 1;
                        str44 = str24;
                        str57 = str23;
                        str51 = str30;
                        str50 = str26;
                        str40 = str22;
                        str42 = str29;
                        str45 = str16;
                        str43 = str27;
                        str53 = str20;
                        str48 = str18;
                        str49 = str25;
                        i2 = i3;
                        str47 = str31;
                    }
                    str2 = str49;
                    str3 = str15;
                    str4 = str47;
                    str5 = str45;
                    str12 = str44;
                    str7 = str48;
                    str9 = str53;
                    jSONObject = jsonobject;
                    str10 = str40;
                    str11 = str57;
                    str6 = str43;
                    str13 = str42;
                    str8 = str51;
                }
                List<CourseDetailTable> list = this.utkashRoom.getCourseDetaildata().getcoursedetail(this.parentCourseId + "_" + this.mainCourseId, MakeMyExam.userId);
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
                    courseDetailData.setCover_image(list.get(0).getCover_image());
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
                    courseDetailData.setTxn_id(list.get(0).getTxn_id());
                    courseDetailData.setInstallment(list.get(0).getInstallment());
                    courseDetailData.setIs_gst(list.get(0).getIs_gst());
                    courseDetailData.setDisplay_locked(list.get(0).getDisplay_locked());
                    courseDetailData.setExternal_coupon_off(list.get(0).getExternal_coupon_off());
                    courseDetailData.setCombo_has_book(list.get(0).getCombo_has_book());
                    courseDetailData.setTax_rate(list.get(0).getTax_rate());
                    this.cousedetail = new CourseDetail();
                    Data data = new Data();
                    data.setCourseDetail(courseDetailData);
                    if (list.size() > 0 && list.get(0) != null && list.get(0).getSubscription_all_data() != null && !list.get(0).getSubscription_all_data().isEmpty()) {
                        data.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                    }
                    ArrayList<TilesItem> arrayList = new ArrayList();
                    int i4 = 0;
                    while (i4 < list.size()) {
                        list.get(i4).getType().equalsIgnoreCase(Const.COMBO);
                        if (!Const.TIME_TABLE.equals(list.get(i4).getType()) || list.get(i4).getIs_purchased().equalsIgnoreCase(str12)) {
                            TilesItem tilesItem = new TilesItem(list.get(i4).getTile_revert(), list.get(i4).getTile_title(), list.get(i4).getTile_id(), list.get(i4).getType(), list.get(i4).getTile_meta(), list.get(i4).getSet_as_demo(), list.get(i4).getThumbnail());
                            arrayList.add(tilesItem);
                            i4++;
                        } else {
                            i4++;
                        }
                    }
                    if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW)) && SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW).equalsIgnoreCase(str12)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (TilesItem tilesItem2 : arrayList) {
                            if (!tilesItem2.getType().equalsIgnoreCase("content")) {
                                arrayList2.add(tilesItem2);
                            }
                        }
                        arrayList.clear();
                        arrayList.addAll(arrayList2);
                    }
                    data.setTiles(arrayList);
                    this.cousedetail.setData(data);
                    try {
                        CourseDetail courseDetail = this.cousedetail;
                        if (courseDetail != null && courseDetail.getData().getCourseDetail().getInstallment() != null && !this.cousedetail.getData().getCourseDetail().getInstallment().equalsIgnoreCase(str11)) {
                            this.cousedetail.getData().setInstalment((InstallmentResponse) new Gson().fromJson(this.cousedetail.getData().getCourseDetail().getInstallment(), InstallmentResponse.class));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    handleBuyNowClick(this.cousedetail);
                    return;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.has(Const.COURSE_DETAIL) ? jSONObjectOptJSONObject.optJSONObject(Const.COURSE_DETAIL) : null;
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has(str3)) {
                    jSONObjectOptJSONObject2.optString(str3);
                }
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has(str2)) {
                    jSONObjectOptJSONObject2.optString(str2);
                }
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("desc_header_image")) {
                    jSONObjectOptJSONObject2.optString("desc_header_image");
                }
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("title")) {
                    jSONObjectOptJSONObject2.optString("title");
                }
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("validity")) {
                    jSONObjectOptJSONObject2.optString("validity");
                }
                JSONObject jSONObjectOptJSONObject3 = (jSONObjectOptJSONObject2 == null || !jSONObjectOptJSONObject2.has("desc_header_image")) ? null : jSONObjectOptJSONObject2.optJSONObject("desc_header_image");
                if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has("title")) {
                    jSONObjectOptJSONObject3.optString("title");
                }
                if (jSONObjectOptJSONObject.has(Const.COURSE_DETAIL)) {
                    ArrayList arrayList3 = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        String str86 = str4;
                        str4 = str86;
                        if (i5 >= jSONObjectOptJSONObject.getJSONArray(str86).length()) {
                            break;
                        }
                        CourseDetailTable courseDetailTable5 = new CourseDetailTable();
                        List<CourseDetailTable> list2 = list;
                        courseDetailTable5.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str52));
                        ArrayList arrayList4 = arrayList3;
                        StringBuilder sbAppend = new StringBuilder().append(this.parentCourseId).append(str41);
                        String str87 = str41;
                        String str88 = str13;
                        courseDetailTable5.setCourse_id(sbAppend.append(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str88)).toString());
                        courseDetailTable5.setCover_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                        courseDetailTable5.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                        courseDetailTable5.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                        courseDetailTable5.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                        courseDetailTable5.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                        courseDetailTable5.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str10));
                        courseDetailTable5.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                        courseDetailTable5.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                        courseDetailTable5.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                        courseDetailTable5.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                        courseDetailTable5.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                        courseDetailTable5.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString(str52));
                        courseDetailTable5.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i5, str88));
                        courseDetailTable5.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i5, "meta"));
                        courseDetailTable5.setUser_id(MakeMyExam.userId);
                        courseDetailTable5.setContent_type(this.content_type);
                        courseDetailTable5.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i5, Const.REVERT_API));
                        courseDetailTable5.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i5, "tile_name"));
                        String str89 = str6;
                        courseDetailTable5.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i5, str89));
                        courseDetailTable5.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                        String str90 = str52;
                        courseDetailTable5.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                        String str91 = str5;
                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str91) != null) {
                            courseDetailTable5.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str91));
                        } else {
                            courseDetailTable5.setSkip_payment(str12);
                        }
                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str2) != null) {
                            courseDetailTable5.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str2));
                        } else {
                            courseDetailTable5.setCat_type(str11);
                        }
                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str3) != null) {
                            courseDetailTable5.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str3));
                        } else {
                            courseDetailTable5.setHide_validity(str11);
                        }
                        String str92 = str12;
                        String str93 = str;
                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str93) != null) {
                            courseDetailTable5.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str93));
                            str14 = str9;
                        } else {
                            str14 = str9;
                            courseDetailTable5.setDelivery_charge(str14);
                        }
                        str = str93;
                        String str94 = str2;
                        courseDetailTable5.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                        String str95 = str56;
                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str95) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str95))) {
                            courseDetailTable5.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str95));
                        } else {
                            courseDetailTable5.setExternal_coupon_off(str11);
                        }
                        str56 = str95;
                        String str96 = str55;
                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str96) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str96))) {
                            courseDetailTable5.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str96));
                        } else {
                            courseDetailTable5.setCombo_has_book(str14);
                        }
                        str55 = str96;
                        String str97 = str54;
                        if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str97) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str97))) {
                            courseDetailTable5.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str97));
                        } else {
                            courseDetailTable5.setTax_rate(str14);
                        }
                        str9 = str14;
                        String str98 = str7;
                        if (jSONObject.optJSONObject(str8).optJSONObject(str98) != null) {
                            str54 = str97;
                            str7 = str98;
                            courseDetailTable5.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jSONObject.optJSONObject(str8).optJSONObject(str98).toString(), SubscriptionAllData.class)));
                        } else {
                            str7 = str98;
                            str54 = str97;
                        }
                        arrayList4.add(courseDetailTable5);
                        this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable5);
                        i5++;
                        arrayList3 = arrayList4;
                        str12 = str92;
                        str5 = str91;
                        str52 = str90;
                        str2 = str94;
                        str6 = str89;
                        str13 = str88;
                        str41 = str87;
                        list = list2;
                    }
                    List<CourseDetailTable> list3 = list;
                    ArrayList arrayList5 = arrayList3;
                    String str99 = str41;
                    if (arrayList5.size() > 0) {
                        CourseDetailData courseDetailData2 = new CourseDetailData();
                        courseDetailData2.setTitle(((CourseDetailTable) arrayList5.get(0)).getCourse_title());
                        courseDetailData2.setCourseSp(((CourseDetailTable) arrayList5.get(0)).getCourse_sp());
                        Author author2 = new Author();
                        author2.setTitle(((CourseDetailTable) arrayList5.get(0)).getAuthor_title());
                        courseDetailData2.setAuthor(author2);
                        courseDetailData2.setMrp(((CourseDetailTable) arrayList5.get(0)).getMrp());
                        courseDetailData2.setTax(((CourseDetailTable) arrayList5.get(0)).getTax());
                        courseDetailData2.setValidity(((CourseDetailTable) arrayList5.get(0)).getValidity());
                        courseDetailData2.setId(((CourseDetailTable) arrayList5.get(0)).getCourse_id().split(str99)[1]);
                        courseDetailData2.setCourseSp(((CourseDetailTable) arrayList5.get(0)).getCourse_sp());
                        courseDetailData2.setCover_image(((CourseDetailTable) arrayList5.get(0)).getCover_image());
                        courseDetailData2.setDescHeaderImage(((CourseDetailTable) arrayList5.get(0)).getDesc_header_image());
                        courseDetailData2.setIsPurchased(((CourseDetailTable) arrayList5.get(0)).getIs_purchased());
                        courseDetailData2.setViewType(((CourseDetailTable) arrayList5.get(0)).getView_type());
                        courseDetailData2.setIs_combo(((CourseDetailTable) arrayList5.get(0)).getIs_combo());
                        courseDetailData2.setSkip_payment(((CourseDetailTable) arrayList5.get(0)).getSkip_payment());
                        courseDetailData2.setCat_type(((CourseDetailTable) arrayList5.get(0)).getCat_type());
                        courseDetailData2.setHide_validity(((CourseDetailTable) arrayList5.get(0)).getHide_validity());
                        courseDetailData2.setDelivery_charge(((CourseDetailTable) arrayList5.get(0)).getDelivery_charge());
                        courseDetailData2.setIs_activated(((CourseDetailTable) arrayList5.get(0)).getIs_activated());
                        courseDetailData2.setToken_activation(((CourseDetailTable) arrayList5.get(0)).getToken_activation());
                        courseDetailData2.setTxn_id(((CourseDetailTable) arrayList5.get(0)).getTxn_id());
                        courseDetailData2.setInstallment(((CourseDetailTable) arrayList5.get(0)).getInstallment());
                        courseDetailData2.setIs_gst(((CourseDetailTable) arrayList5.get(0)).getIs_gst());
                        courseDetailData2.setDisplay_locked(((CourseDetailTable) arrayList5.get(0)).getDisplay_locked());
                        courseDetailData2.setExternal_coupon_off(((CourseDetailTable) arrayList5.get(0)).getExternal_coupon_off());
                        courseDetailData2.setCombo_has_book(((CourseDetailTable) arrayList5.get(0)).getCombo_has_book());
                        courseDetailData2.setTax_rate(((CourseDetailTable) arrayList5.get(0)).getTax_rate());
                        this.cousedetail = new CourseDetail();
                        Data data2 = new Data();
                        data2.setCourseDetail(courseDetailData2);
                        if (list3.size() > 0 && list3.get(0) != null && list3.get(0).getSubscription_all_data() != null && !list3.get(0).getSubscription_all_data().isEmpty()) {
                            data2.setSubscriptionAllData((SubscriptionAllData) new Gson().fromJson(list3.get(0).getSubscription_all_data(), SubscriptionAllData.class));
                        }
                        this.cousedetail.setData(data2);
                        try {
                            CourseDetail courseDetail2 = this.cousedetail;
                            if (courseDetail2 != null && courseDetail2.getData().getCourseDetail().getInstallment() != null && !this.cousedetail.getData().getCourseDetail().getInstallment().equalsIgnoreCase(str11)) {
                                this.cousedetail.getData().setInstalment((InstallmentResponse) new Gson().fromJson(this.cousedetail.getData().getCourseDetail().getInstallment(), InstallmentResponse.class));
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        handleBuyNowClick(this.cousedetail);
                        return;
                    }
                    return;
                }
                return;
            }
            RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
        }
    }

    public class TCViewHolder extends RecyclerView.ViewHolder {
        TextView buyNowIdTC;
        ImageView courseBannerTC;
        TextView courseTitleTC;
        RelativeLayout discountRLTC;
        TextView discountTC;
        TextView exploreIdTC;
        ImageView liveIV;
        ImageView newCourse;
        TextView originalPriceTC;
        TextView priceTC;
        FrameLayout soldOutImgTC;
        TextView validityTC;

        public TCViewHolder(View itemView) {
            super(itemView);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.newCourse = (ImageView) itemView.findViewById(R.id.new_course);
            this.courseBannerTC = (ImageView) itemView.findViewById(R.id.courseBannerTC);
            this.courseTitleTC = (TextView) itemView.findViewById(R.id.courseTitleTC);
            this.validityTC = (TextView) itemView.findViewById(R.id.validityTC);
            this.priceTC = (TextView) itemView.findViewById(R.id.priceTC);
            this.originalPriceTC = (TextView) itemView.findViewById(R.id.originalPriceTC);
            this.discountTC = (TextView) itemView.findViewById(R.id.discountTC);
            this.exploreIdTC = (TextView) itemView.findViewById(R.id.exploreIdTC);
            this.discountRLTC = (RelativeLayout) itemView.findViewById(R.id.discountRLTC);
            this.buyNowIdTC = (TextView) itemView.findViewById(R.id.buyNowIdTC);
            this.soldOutImgTC = (FrameLayout) itemView.findViewById(R.id.soldOutImgTC);
        }
    }

    public boolean isEMIAvailable(CourseDetail courseDetail) {
        if (courseDetail == null || courseDetail.getData() == null || courseDetail.getData().getInstalment() == null || courseDetail.getData().getInstalment().getInstallment() == null || courseDetail.getData().getInstalment().getInstallment().isEmpty()) {
            return false;
        }
        return "2".equals(courseDetail.getData().getInstalment().getPayment_mode()) || "1".equals(courseDetail.getData().getInstalment().getPayment_mode());
    }

    private void handleBuyNowClick(final CourseDetail cousedetail) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Educator.adpter.HomeTCAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Helper.directPayment() && !HomeTCAdapter.this.isEMIAvailable(cousedetail)) {
                        AppCompatActivity appCompatActivity = (AppCompatActivity) HomeTCAdapter.this.activity;
                        if (appCompatActivity.getSupportFragmentManager().isStateSaved() || appCompatActivity.isFinishing() || appCompatActivity.isDestroyed()) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("test_data", "");
                        bundle.putString("test_id", "");
                        bundle.putString("parentCourseId", HomeTCAdapter.this.parentCourseId);
                        bundle.putSerializable(Const.SINGLE_STUDY, cousedetail);
                        bundle.putString(Const.IS_BOOK, cousedetail.getData().getCourseDetail().getCat_type());
                        bundle.putString(Const.DELIVERY_CHARGE, cousedetail.getData().getCourseDetail().getDelivery_charge());
                        HomeTCAdapter.this.purchaseBottomSheetFragment = InstantPurchase.INSTANCE.newInstance(HomeTCAdapter.this.paymentGatewayListener, HomeTCAdapter.this.paymentResultListener, true, bundle);
                        HomeTCAdapter.this.purchaseBottomSheetFragment.show(((AppCompatActivity) HomeTCAdapter.this.activity).getSupportFragmentManager(), "PurchaseBottomSheetFragment");
                        return;
                    }
                    CourseDetail courseDetail = cousedetail;
                    if (courseDetail != null && courseDetail.getData() != null && cousedetail.getData().getCourseDetail() != null && cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("5")) {
                        Intent intent = new Intent(HomeTCAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                        intent.putExtra("test_data", "");
                        intent.putExtra(Const.SINGLE_STUDY, cousedetail);
                        intent.putExtra("test_id", "0");
                        intent.putExtra(Const.IS_BOOK, cousedetail.getData().getCourseDetail().getCat_type());
                        intent.putExtra(Const.DELIVERY_CHARGE, cousedetail.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent, HomeTCAdapter.this.activity);
                        return;
                    }
                    Intent intent2 = new Intent(HomeTCAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent2.putExtra(Const.SINGLE_STUDY, cousedetail);
                    intent2.putExtra("test_id", "");
                    intent2.putExtra(Const.IS_BOOK, cousedetail.getData().getCourseDetail().getCat_type());
                    intent2.putExtra(Const.DELIVERY_CHARGE, cousedetail.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent2, HomeTCAdapter.this.activity);
                } catch (IllegalStateException e2) {
                    Log.e("handleBuyNowClick", "" + e2.getMessage());
                }
            }
        });
    }

    public void onPaymentSuccess(String s) {
        InstantPurchase instantPurchase = this.purchaseBottomSheetFragment;
        if (instantPurchase != null) {
            instantPurchase.onPaymentSuccess(s);
        }
    }

    public void onPaymentError(int i, String s) {
        InstantPurchase instantPurchase = this.purchaseBottomSheetFragment;
        if (instantPurchase != null) {
            instantPurchase.onPaymentError(i, s);
        }
    }

    public void onSuccess(String posTxnId) {
        InstantPurchase instantPurchase = this.purchaseBottomSheetFragment;
        if (instantPurchase != null) {
            instantPurchase.onSuccess(posTxnId);
        }
    }

    public void onSuccessEsewa(String productId, String totalAmount, String referenceId, String scdId) {
        InstantPurchase instantPurchase = this.purchaseBottomSheetFragment;
        if (instantPurchase != null) {
            instantPurchase.onSuccessEsewa(productId, totalAmount, referenceId, scdId);
        }
    }

    public void onFailed(boolean isFailure) {
        InstantPurchase instantPurchase = this.purchaseBottomSheetFragment;
        if (instantPurchase != null) {
            instantPurchase.onFailed(isFailure);
        }
    }
}
