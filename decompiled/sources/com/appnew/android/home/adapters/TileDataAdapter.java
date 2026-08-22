package com.appnew.android.home.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Models.Available;
import com.appnew.android.Coupon.Models.CouponPojo;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Model.BottomSetting;
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
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.HelperProgress;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.appnew.android.table.CourseDetailTable;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.razorpay.PaymentResultListener;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class TileDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    BottomSetting bottomSetting;
    String content_type;
    private CouponPojo couponPojo;
    ArrayList<Courselist> courseDataArrayList;
    CourseDetailTable courseDetailData;
    List<CourseDetailTable> courseDetailTable;
    String course_id;
    String course_name;
    String course_price;
    String course_quantity;
    String course_tex;
    CourseDetail cousedetail;
    String isBook;
    NetworkCall networkCall;
    PaymentGatewayListener paymentGatewayListener;
    PaymentResultListener paymentResultListener;
    InstantPurchase purchaseBottomSheetFragment;
    long mLastClickTime = 0;
    String parentCourseId = "";
    public String mainCourseId = "";
    boolean isNewStyle = false;
    UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public TileDataAdapter(Activity activity, ArrayList<Courselist> courseDataArrayList, String isBook, PaymentGatewayListener paymentGatewayListener, PaymentResultListener paymentResultListener) {
        this.courseDataArrayList = new ArrayList<>();
        this.paymentGatewayListener = paymentGatewayListener;
        this.paymentResultListener = paymentResultListener;
        this.activity = activity;
        this.isBook = isBook;
        this.networkCall = new NetworkCall(this, activity);
        this.courseDataArrayList = courseDataArrayList;
        if (SharedPreference.getInstance().getUserCoupon() == null || SharedPreference.getInstance().getUserCoupon().getAvailable() == null) {
            return;
        }
        this.couponPojo = SharedPreference.getInstance().getUserCoupon();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate;
        BottomSetting bottomSetting;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.activity);
        if (viewType == 0) {
            if (BuildConfig.FLAVOR.equalsIgnoreCase("rankersGurukuls")) {
                if (SharedPreference.getInstance().getString(Const.IS_HOME_GRID).equalsIgnoreCase("1") || this.isBook.equalsIgnoreCase("1") || ((bottomSetting = this.bottomSetting) != null && bottomSetting.getLayout_type() != null && this.bottomSetting.getLayout_type().equals("1"))) {
                    viewInflate = layoutInflaterFrom.inflate(R.layout.rankerguru_bookgrid_layout, parent, false);
                } else {
                    viewInflate = layoutInflaterFrom.inflate(R.layout.tile_data_item_adapter_new, parent, false);
                }
                return new MyViewHodlerNew(viewInflate);
            }
            return new MyViewHodlerPhysicsGalaxy(layoutInflaterFrom.inflate(R.layout.tile_item_theme_2, parent, false));
        }
        return new ViewHolderTheme8(layoutInflaterFrom.inflate(R.layout.tile_data_item_adapter_theme8, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return "1".equalsIgnoreCase("7") ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if ("1".equalsIgnoreCase("7")) {
            ((ViewHolderTheme8) holder).setData(this.courseDataArrayList.get(position), position);
        } else if (BuildConfig.FLAVOR.equalsIgnoreCase("rankersGurukuls")) {
            ((MyViewHodlerNew) holder).setData(this.courseDataArrayList.get(position), position);
        } else {
            ((MyViewHodlerPhysicsGalaxy) holder).setData(this.courseDataArrayList.get(position), position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseDataArrayList.size();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.CourseDetail_JS)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setCourse_id(this.mainCourseId);
            encryptionData.setParent_id(this.parentCourseId);
            return service.getCourseData(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!apitype.equals(API.COURSE_ADD_TO_CART)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setCourse_id(this.course_id);
        encryptionData2.setCourse_name(this.course_name);
        encryptionData2.setQuantity(this.course_quantity);
        encryptionData2.setCourse_price(this.course_price);
        return service.addItemInCart(AES.encrypt(new Gson().toJson(encryptionData2)));
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
        JSONObject jSONObject;
        String str12;
        String str13;
        String str14;
        JSONObject jSONObject2;
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
        JSONObject jSONObject3;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        apitype.hashCode();
        String str39 = "";
        if (!apitype.equals(API.CourseDetail_JS)) {
            if (apitype.equals(API.COURSE_ADD_TO_CART)) {
                try {
                    if (jsonobject.getString("status").equalsIgnoreCase("true")) {
                        Toast.makeText(this.activity, "" + jsonobject.getString("message"), 0).show();
                        return;
                    } else {
                        Toast.makeText(this.activity, jsonobject.getString("message"), 0).show();
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (jsonobject.optString("status").equals("true")) {
            JSONObject jSONObjectOptJSONObject = jsonobject.optJSONObject("data");
            String str40 = "is_purchased";
            String strOptString = (jSONObjectOptJSONObject.has(Const.COURSE_DETAIL) && jSONObjectOptJSONObject.optJSONObject(Const.COURSE_DETAIL).has("is_purchased")) ? jSONObjectOptJSONObject.optJSONObject(Const.COURSE_DETAIL).optString("is_purchased") : "0";
            SharedPreference.getInstance().putString(Const.IS_IGST, jSONObjectOptJSONObject.optString(Const.IS_IGST));
            String str41 = "_";
            String str42 = "id";
            boolean zIsRecordExistsUserId = this.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, this.parentCourseId + "_" + jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("id"));
            String str43 = "type";
            String str44 = "1";
            String str45 = strOptString;
            String str46 = "skip_payment";
            String str47 = "subscription_all_data";
            String str48 = "tiles";
            String str49 = "cat_type";
            String str50 = "data";
            String str51 = "hide_validity";
            String str52 = "0";
            String str53 = Const.DELIVERY_CHARGE;
            String str54 = "tax_rate";
            String str55 = "combo_has_book";
            if (zIsRecordExistsUserId) {
                str = "external_coupon_off";
                str2 = "cat_type";
                str3 = "";
                str4 = "1";
                str5 = "hide_validity";
                str6 = "tiles";
                str7 = "skip_payment";
                str8 = "type";
                str9 = str47;
                str10 = str50;
                str11 = str52;
                jSONObject = jsonobject;
                str12 = "is_purchased";
                str13 = "id";
            } else {
                str = "external_coupon_off";
                int i2 = 0;
                while (true) {
                    str15 = str51;
                    if (i2 >= jSONObjectOptJSONObject.getJSONArray(str48).length()) {
                        break;
                    }
                    if (str44.equalsIgnoreCase("7")) {
                        String str56 = str39;
                        String str57 = str49;
                        if (Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43).equalsIgnoreCase("content")) {
                            str17 = str46;
                            str19 = str50;
                            str18 = str47;
                            str20 = str52;
                            str22 = str40;
                            str24 = str44;
                            str29 = str42;
                            str16 = str56;
                            str26 = str15;
                            i = i2;
                            str27 = str43;
                            str25 = str57;
                            str30 = str48;
                        } else {
                            CourseDetailTable courseDetailTable = new CourseDetailTable();
                            courseDetailTable.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                            String str58 = str44;
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
                            if (jSONObjectOptJSONObject.getJSONArray(str48).getJSONObject(i2).has("thumbnail")) {
                                courseDetailTable.setThumbnail(jSONObjectOptJSONObject.getJSONArray(str48).getJSONObject(i2).getString("thumbnail"));
                            }
                            courseDetailTable.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                            courseDetailTable.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                            courseDetailTable.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43));
                            courseDetailTable.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                            courseDetailTable.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                            courseDetailTable.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str46) != null) {
                                courseDetailTable.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str46));
                                str24 = str58;
                            } else {
                                str24 = str58;
                                courseDetailTable.setSkip_payment(str24);
                            }
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str57) != null) {
                                courseDetailTable.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str57));
                                str37 = str56;
                            } else {
                                str37 = str56;
                                courseDetailTable.setCat_type(str37);
                            }
                            str17 = str46;
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15) != null) {
                                courseDetailTable.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15));
                            } else {
                                courseDetailTable.setHide_validity(str37);
                            }
                            String str59 = str53;
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str59) != null) {
                                courseDetailTable.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str59));
                                str38 = str52;
                            } else {
                                str38 = str52;
                                courseDetailTable.setDelivery_charge(str38);
                            }
                            str53 = str59;
                            str21 = str48;
                            courseDetailTable.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                            String str60 = str;
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str60) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str60))) {
                                courseDetailTable.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str60));
                            } else {
                                courseDetailTable.setExternal_coupon_off(str37);
                            }
                            str = str60;
                            String str61 = str55;
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str61) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str61))) {
                                courseDetailTable.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str61));
                            } else {
                                courseDetailTable.setCombo_has_book(str38);
                            }
                            str55 = str61;
                            String str62 = str54;
                            if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str62) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str62))) {
                                courseDetailTable.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str62));
                            } else {
                                courseDetailTable.setTax_rate(str38);
                            }
                            str54 = str62;
                            str19 = str50;
                            String str63 = str37;
                            str20 = str38;
                            String str64 = str47;
                            if (jsonobject.optJSONObject(str19).optJSONObject(str64) != null) {
                                str22 = str40;
                                str18 = str64;
                                courseDetailTable.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jsonobject.optJSONObject(str19).optJSONObject(str64).toString(), SubscriptionAllData.class)));
                            } else {
                                str22 = str40;
                                str18 = str64;
                            }
                            this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable);
                            str16 = str63;
                            str26 = str15;
                            i = i2;
                            str27 = str43;
                            str25 = str57;
                            str30 = str21;
                            str29 = str42;
                        }
                    } else {
                        String str65 = str49;
                        str16 = str39;
                        str17 = str46;
                        String str66 = str44;
                        str18 = str47;
                        str19 = str50;
                        str20 = str52;
                        str21 = str48;
                        str22 = str40;
                        String str67 = this.content_type;
                        if (str67 != null && !TextUtils.isEmpty(str67) && this.content_type.equalsIgnoreCase(str66)) {
                            if (Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43).equalsIgnoreCase("content")) {
                                str26 = str15;
                                str27 = str43;
                                str24 = str66;
                                i = i2;
                                str25 = str65;
                                str30 = str21;
                                str29 = str42;
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
                                str48 = str21;
                                if (jSONObjectOptJSONObject.getJSONArray(str48).getJSONObject(i2).has("thumbnail")) {
                                    courseDetailTable2.setThumbnail(jSONObjectOptJSONObject.getJSONArray(str48).getJSONObject(i2).getString("thumbnail"));
                                }
                                courseDetailTable2.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                                courseDetailTable2.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                                courseDetailTable2.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43));
                                courseDetailTable2.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                                courseDetailTable2.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                                courseDetailTable2.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17) != null) {
                                    courseDetailTable2.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17));
                                } else {
                                    courseDetailTable2.setSkip_payment(str66);
                                }
                                str23 = str66;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str65) != null) {
                                    courseDetailTable2.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str65));
                                } else {
                                    courseDetailTable2.setCat_type(str16);
                                }
                                str65 = str65;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15) != null) {
                                    courseDetailTable2.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15));
                                } else {
                                    courseDetailTable2.setHide_validity(str16);
                                }
                                str33 = str15;
                                String str68 = str53;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str68) != null) {
                                    courseDetailTable2.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str68));
                                    str36 = str20;
                                } else {
                                    str36 = str20;
                                    courseDetailTable2.setDelivery_charge(str36);
                                }
                                str53 = str68;
                                str17 = str17;
                                courseDetailTable2.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                String str69 = str;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str69) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str69))) {
                                    courseDetailTable2.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str69));
                                } else {
                                    courseDetailTable2.setExternal_coupon_off(str16);
                                }
                                str = str69;
                                String str70 = str55;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str70) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str70))) {
                                    courseDetailTable2.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str70));
                                } else {
                                    courseDetailTable2.setCombo_has_book(str36);
                                }
                                str55 = str70;
                                String str71 = str54;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str71) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str71))) {
                                    courseDetailTable2.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str71));
                                } else {
                                    courseDetailTable2.setTax_rate(str36);
                                }
                                jSONObject3 = jsonobject;
                                str35 = str36;
                                str54 = str71;
                                if (jSONObject3.optJSONObject(str19).optJSONObject(str18) != null) {
                                    Gson gson = new Gson();
                                    str34 = str16;
                                    String string = jSONObject3.optJSONObject(str19).optJSONObject(str18).toString();
                                    str18 = str18;
                                    courseDetailTable2.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) gson.fromJson(string, SubscriptionAllData.class)));
                                } else {
                                    str34 = str16;
                                    str18 = str18;
                                }
                                this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable2);
                            }
                        } else {
                            str23 = str66;
                            str48 = str21;
                            String str72 = str45;
                            if (str72.equalsIgnoreCase(str20)) {
                                str45 = str72;
                                if (Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43).equalsIgnoreCase("content")) {
                                    str29 = str42;
                                    str16 = str16;
                                    str20 = str20;
                                    str26 = str15;
                                    str27 = str43;
                                    str24 = str23;
                                    i = i2;
                                    str25 = str65;
                                    str30 = str48;
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
                                    if (jSONObjectOptJSONObject.getJSONArray(str48).getJSONObject(i2).has("thumbnail")) {
                                        courseDetailTable3.setThumbnail(jSONObjectOptJSONObject.getJSONArray(str48).getJSONObject(i2).getString("thumbnail"));
                                    }
                                    courseDetailTable3.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                                    courseDetailTable3.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                                    courseDetailTable3.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43));
                                    courseDetailTable3.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                                    courseDetailTable3.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                                    courseDetailTable3.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17) != null) {
                                        courseDetailTable3.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17));
                                        str31 = str23;
                                    } else {
                                        str31 = str23;
                                        courseDetailTable3.setSkip_payment(str31);
                                    }
                                    str23 = str31;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str65) != null) {
                                        courseDetailTable3.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str65));
                                        str32 = str16;
                                    } else {
                                        str32 = str16;
                                        courseDetailTable3.setCat_type(str32);
                                    }
                                    str65 = str65;
                                    str17 = str17;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15) != null) {
                                        courseDetailTable3.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str15));
                                    } else {
                                        courseDetailTable3.setHide_validity(str32);
                                    }
                                    str33 = str15;
                                    String str73 = str53;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str73) != null) {
                                        courseDetailTable3.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str73));
                                    } else {
                                        courseDetailTable3.setDelivery_charge(str20);
                                    }
                                    str53 = str73;
                                    courseDetailTable3.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                    String str74 = str;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str74) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str74))) {
                                        courseDetailTable3.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str74));
                                    } else {
                                        courseDetailTable3.setExternal_coupon_off(str32);
                                    }
                                    str = str74;
                                    String str75 = str55;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str75) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str75))) {
                                        courseDetailTable3.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str75));
                                    } else {
                                        courseDetailTable3.setCombo_has_book(str20);
                                    }
                                    str55 = str75;
                                    String str76 = str54;
                                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str76) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str76))) {
                                        courseDetailTable3.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str76));
                                    } else {
                                        courseDetailTable3.setTax_rate(str20);
                                    }
                                    jSONObject3 = jsonobject;
                                    str34 = str32;
                                    str54 = str76;
                                    if (jSONObject3.optJSONObject(str19).optJSONObject(str18) != null) {
                                        Gson gson2 = new Gson();
                                        str35 = str20;
                                        String string2 = jSONObject3.optJSONObject(str19).optJSONObject(str18).toString();
                                        str18 = str18;
                                        courseDetailTable3.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) gson2.fromJson(string2, SubscriptionAllData.class)));
                                    } else {
                                        str18 = str18;
                                        str35 = str20;
                                    }
                                    this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable3);
                                }
                            } else {
                                str45 = str72;
                                str16 = str16;
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
                                if (jSONObjectOptJSONObject.getJSONArray(str48).getJSONObject(i2).has("thumbnail")) {
                                    courseDetailTable4.setThumbnail(jSONObjectOptJSONObject.getJSONArray(str48).getJSONObject(i2).getString("thumbnail"));
                                }
                                courseDetailTable4.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, Const.REVERT_API));
                                courseDetailTable4.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "tile_name"));
                                courseDetailTable4.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, str43));
                                courseDetailTable4.setSet_as_demo(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i2, "set_as_demo"));
                                courseDetailTable4.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                                courseDetailTable4.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17) != null) {
                                    courseDetailTable4.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str17));
                                    str24 = str23;
                                } else {
                                    str24 = str23;
                                    courseDetailTable4.setSkip_payment(str24);
                                }
                                i = i2;
                                str25 = str65;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str25) != null) {
                                    courseDetailTable4.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str25));
                                } else {
                                    courseDetailTable4.setCat_type(str16);
                                }
                                str17 = str17;
                                str26 = str15;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str26) != null) {
                                    courseDetailTable4.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str26));
                                } else {
                                    courseDetailTable4.setHide_validity(str16);
                                }
                                str27 = str43;
                                String str77 = str53;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str77) != null) {
                                    courseDetailTable4.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str77));
                                    str28 = str20;
                                } else {
                                    str28 = str20;
                                    courseDetailTable4.setDelivery_charge(str28);
                                }
                                str53 = str77;
                                str29 = str42;
                                courseDetailTable4.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                                String str78 = str;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str78) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str78))) {
                                    courseDetailTable4.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str78));
                                } else {
                                    courseDetailTable4.setExternal_coupon_off(str16);
                                }
                                str = str78;
                                String str79 = str55;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str79) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str79))) {
                                    courseDetailTable4.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str79));
                                } else {
                                    courseDetailTable4.setCombo_has_book(str28);
                                }
                                str55 = str79;
                                String str80 = str54;
                                if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str80) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str80))) {
                                    courseDetailTable4.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str80));
                                } else {
                                    courseDetailTable4.setTax_rate(str28);
                                }
                                str54 = str80;
                                str20 = str28;
                                if (jsonobject.optJSONObject(str19).optJSONObject(str18) != null) {
                                    Gson gson3 = new Gson();
                                    str30 = str48;
                                    String string3 = jsonobject.optJSONObject(str19).optJSONObject(str18).toString();
                                    str18 = str18;
                                    courseDetailTable4.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) gson3.fromJson(string3, SubscriptionAllData.class)));
                                } else {
                                    str18 = str18;
                                    str30 = str48;
                                }
                                this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable4);
                            }
                        }
                        str26 = str33;
                        str16 = str34;
                        str27 = str43;
                        str20 = str35;
                        str29 = str42;
                        str24 = str23;
                        i = i2;
                        str25 = str65;
                        str30 = str48;
                    }
                    String str81 = str24;
                    str39 = str16;
                    str49 = str25;
                    i2 = i + 1;
                    str51 = str26;
                    str44 = str81;
                    str50 = str19;
                    str40 = str22;
                    str42 = str29;
                    str46 = str17;
                    str43 = str27;
                    str48 = str30;
                    str52 = str20;
                    str47 = str18;
                }
                str2 = str49;
                str3 = str39;
                str4 = str44;
                str5 = str15;
                str6 = str48;
                str7 = str46;
                str9 = str47;
                str10 = str50;
                str11 = str52;
                str12 = str40;
                str8 = str43;
                str13 = str42;
                jSONObject = jsonobject;
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
                int i3 = 0;
                while (i3 < list.size()) {
                    list.get(i3).getType().equalsIgnoreCase(Const.COMBO);
                    if (!Const.TIME_TABLE.equals(list.get(i3).getType()) || list.get(i3).getIs_purchased().equalsIgnoreCase(str4)) {
                        TilesItem tilesItem = new TilesItem(list.get(i3).getTile_revert(), list.get(i3).getTile_title(), list.get(i3).getTile_id(), list.get(i3).getType(), list.get(i3).getTile_meta(), list.get(i3).getSet_as_demo(), list.get(i3).getThumbnail());
                        arrayList.add(tilesItem);
                        i3++;
                    } else {
                        i3++;
                    }
                }
                if (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW)) && SharedPreference.getInstance().getString(Const.SAME_CONTENT_VIEW).equalsIgnoreCase(str4)) {
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
                    if (courseDetail != null && courseDetail.getData().getCourseDetail().getInstallment() != null && !this.cousedetail.getData().getCourseDetail().getInstallment().equalsIgnoreCase(str3)) {
                        this.cousedetail.getData().setInstalment((InstallmentResponse) new Gson().fromJson(this.cousedetail.getData().getCourseDetail().getInstallment(), InstallmentResponse.class));
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                handleBuyNowClick(this.cousedetail);
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.has(Const.COURSE_DETAIL) ? jSONObjectOptJSONObject.optJSONObject(Const.COURSE_DETAIL) : null;
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has(str5)) {
                jSONObjectOptJSONObject2.optString(str5);
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
                int i4 = 0;
                while (true) {
                    String str82 = str6;
                    str6 = str82;
                    if (i4 >= jSONObjectOptJSONObject.getJSONArray(str82).length()) {
                        break;
                    }
                    CourseDetailTable courseDetailTable5 = new CourseDetailTable();
                    List<CourseDetailTable> list2 = list;
                    courseDetailTable5.setCourse_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("title"));
                    ArrayList arrayList4 = arrayList3;
                    StringBuilder sbAppend = new StringBuilder().append(this.parentCourseId).append(str41);
                    String str83 = str41;
                    String str84 = str13;
                    courseDetailTable5.setCourse_id(sbAppend.append(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str84)).toString());
                    courseDetailTable5.setCover_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("cover_image"));
                    courseDetailTable5.setDesc_header_image(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("desc_header_image"));
                    courseDetailTable5.setMrp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("mrp"));
                    courseDetailTable5.setCourse_sp(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("course_sp"));
                    courseDetailTable5.setValidity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("validity"));
                    courseDetailTable5.setIs_purchased(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str12));
                    courseDetailTable5.setIs_activated(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_activated"));
                    courseDetailTable5.setToken_activation(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("token_activation"));
                    courseDetailTable5.setTax(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("tax"));
                    courseDetailTable5.setView_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("view_type"));
                    courseDetailTable5.setIs_combo(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(Const.IS_COMBO));
                    courseDetailTable5.setAuthor_title(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getJSONObject("author").getString("title"));
                    courseDetailTable5.setTile_id(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, str84));
                    courseDetailTable5.setTile_meta(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, "meta"));
                    courseDetailTable5.setUser_id(MakeMyExam.userId);
                    courseDetailTable5.setContent_type(this.content_type);
                    courseDetailTable5.setTile_revert(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, Const.REVERT_API));
                    courseDetailTable5.setTile_title(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, "tile_name"));
                    courseDetailTable5.setType(Helper.checkAndGetCourseTileData(jSONObjectOptJSONObject, i4, str8));
                    courseDetailTable5.setInstallment(jSONObjectOptJSONObject.getJSONObject("instalment").toString());
                    courseDetailTable5.setIs_gst(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("is_gst"));
                    String str85 = str7;
                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str85) != null) {
                        courseDetailTable5.setSkip_payment(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str85));
                    } else {
                        courseDetailTable5.setSkip_payment(str4);
                    }
                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str2) != null) {
                        courseDetailTable5.setCat_type(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str2));
                    } else {
                        courseDetailTable5.setCat_type(str3);
                    }
                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str5) != null) {
                        courseDetailTable5.setHide_validity(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str5));
                    } else {
                        courseDetailTable5.setHide_validity(str3);
                    }
                    str7 = str85;
                    String str86 = str53;
                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str86) != null) {
                        courseDetailTable5.setDelivery_charge(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str86));
                        str14 = str11;
                    } else {
                        str14 = str11;
                        courseDetailTable5.setDelivery_charge(str14);
                    }
                    str53 = str86;
                    String str87 = str4;
                    courseDetailTable5.setTxn_id(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString("txn_id"));
                    String str88 = str;
                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str88) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str88))) {
                        courseDetailTable5.setExternal_coupon_off(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str88));
                    } else {
                        courseDetailTable5.setExternal_coupon_off(str3);
                    }
                    str = str88;
                    String str89 = str55;
                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str89) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str89))) {
                        courseDetailTable5.setCombo_has_book(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str89));
                    } else {
                        courseDetailTable5.setCombo_has_book(str14);
                    }
                    str55 = str89;
                    String str90 = str54;
                    if (jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).has(str90) && !TextUtils.isEmpty(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str90))) {
                        courseDetailTable5.setTax_rate(jSONObjectOptJSONObject.getJSONObject(Const.COURSE_DETAIL).getString(str90));
                    } else {
                        courseDetailTable5.setTax_rate(str14);
                    }
                    String str91 = str14;
                    String str92 = str9;
                    if (jSONObject.optJSONObject(str10).optJSONObject(str92) != null) {
                        jSONObject2 = jSONObjectOptJSONObject;
                        str9 = str92;
                        courseDetailTable5.setSubscription_all_data(new Gson().toJson((SubscriptionAllData) new Gson().fromJson(jSONObject.optJSONObject(str10).optJSONObject(str92).toString(), SubscriptionAllData.class)));
                    } else {
                        str9 = str92;
                        jSONObject2 = jSONObjectOptJSONObject;
                    }
                    arrayList4.add(courseDetailTable5);
                    this.utkashRoom.getCourseDetaildata().addCoursedetail(courseDetailTable5);
                    i4++;
                    arrayList3 = arrayList4;
                    jSONObjectOptJSONObject = jSONObject2;
                    list = list2;
                    str54 = str90;
                    str4 = str87;
                    str11 = str91;
                    str13 = str84;
                    str41 = str83;
                }
                List<CourseDetailTable> list3 = list;
                ArrayList arrayList5 = arrayList3;
                String str93 = str41;
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
                    courseDetailData2.setId(((CourseDetailTable) arrayList5.get(0)).getCourse_id().split(str93)[1]);
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
                        if (courseDetail2 != null && courseDetail2.getData().getCourseDetail().getInstallment() != null && !this.cousedetail.getData().getCourseDetail().getInstallment().equalsIgnoreCase(str3)) {
                            this.cousedetail.getData().setInstalment((InstallmentResponse) new Gson().fromJson(this.cousedetail.getData().getCourseDetail().getInstallment(), InstallmentResponse.class));
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
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

    public class MyViewHodlerNew extends RecyclerView.ViewHolder {
        CardView buyNow;
        TextView courseDescription;
        ImageView liveIV;
        LinearLayout maiView;
        TextView mrpCutTV;
        TextView price;
        TextView titleCourse;
        ImageView videoImageVIEW;
        CardView viewDemo;
        CardView viewDetails;

        public MyViewHodlerNew(View itemView) {
            super(itemView);
            this.titleCourse = (TextView) itemView.findViewById(R.id.titleCourse);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
            this.maiView = (LinearLayout) itemView.findViewById(R.id.maiView);
            this.videoImageVIEW = (ImageView) itemView.findViewById(R.id.videoImageVIEW);
            this.viewDetails = (CardView) itemView.findViewById(R.id.viewDetails);
            this.viewDemo = (CardView) itemView.findViewById(R.id.viewDemo);
            this.buyNow = (CardView) itemView.findViewById(R.id.buyNow);
            this.liveIV = (ImageView) itemView.findViewById(R.id.liveIV);
            this.courseDescription = (TextView) itemView.findViewById(R.id.courseDescription);
        }

        public void setData(final Courselist course, int position) {
            this.titleCourse.setText(course.getTitle());
            if (course.getDescription() != null && !course.getDescription().equalsIgnoreCase("")) {
                this.courseDescription.setVisibility(0);
                this.courseDescription.setText(Html.fromHtml(course.getDescription(), 63));
            } else {
                this.courseDescription.setVisibility(8);
            }
            if (course.getCourseSp() != null && course.getCourseSp().equalsIgnoreCase("0")) {
                this.price.setText(TileDataAdapter.this.activity.getResources().getString(R.string.free));
                this.price.setTextAlignment(2);
                this.mrpCutTV.setVisibility(8);
            } else if (course.getCourseSp() != null && course.getCourseSp().equalsIgnoreCase(course.getMrp())) {
                this.mrpCutTV.setVisibility(8);
                this.price.setText(Constants.currencyType + "" + course.getMrp() + "/-");
            } else {
                this.price.setText(String.format("%s %s %s", Constants.currencyType, course.getCourseSp(), "/-"));
                this.mrpCutTV.setText(String.format("%s %s %s", Constants.currencyType, course.getMrp(), "/-"), TextView.BufferType.SPANNABLE);
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                Spannable spannable = (Spannable) this.mrpCutTV.getText();
                if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                    if (course.getCat_type() != null && course.getCat_type().equalsIgnoreCase("3")) {
                        this.mrpCutTV.setVisibility(8);
                    } else {
                        this.mrpCutTV.setVisibility(0);
                    }
                } else {
                    this.mrpCutTV.setVisibility(8);
                }
                if (course.getMrp() != null) {
                    spannable.setSpan(strikethroughSpan, 2, new String(course.getMrp()).length() + 2, 33);
                }
                course.getValidity();
            }
            if (course != null && course.getIs_purchased() != null && course.getIs_purchased().equalsIgnoreCase("1")) {
                this.buyNow.setVisibility(8);
            } else {
                this.buyNow.setVisibility(0);
            }
            Glide.with(TileDataAdapter.this.activity).load(Integer.valueOf(R.mipmap.new_)).into(this.liveIV);
            if (course.getExtra_json() != null) {
                if (course.getExtra_json().getIs_new() != null && course.getExtra_json().getIs_new().equals("1")) {
                    this.liveIV.setVisibility(0);
                } else {
                    this.liveIV.setVisibility(8);
                }
            }
            this.viewDetails.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodlerNew$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(course, view);
                }
            });
            this.viewDemo.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodlerNew$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$1(course, view);
                }
            });
            this.buyNow.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodlerNew$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$2(course, view);
                }
            });
            if (SharedPreference.getInstance().getString(Const.IS_HOME_GRID).equalsIgnoreCase("1") || TileDataAdapter.this.isBook.equalsIgnoreCase("1") || (TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1"))) {
                if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImageVIEW);
                    return;
                } else {
                    this.videoImageVIEW.setImageResource(R.mipmap.square_placeholder);
                    return;
                }
            }
            if (!TextUtils.isEmpty(course.getCover_image())) {
                Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImageVIEW);
            } else {
                this.videoImageVIEW.setImageResource(R.mipmap.placeholder_course);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (Helper.isNetworkConnected(TileDataAdapter.this.activity)) {
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    Intent intent = new Intent(TileDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                    Helper.gotoActivity(intent, TileDataAdapter.this.activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(TileDataAdapter.this.activity, "", courselist.getMaintenanceText());
                return;
            }
            Helper.showInternetToast(TileDataAdapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (Helper.isNetworkConnected(TileDataAdapter.this.activity)) {
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    Intent intent = new Intent(TileDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                    intent.putExtra("demo", "demo");
                    Helper.gotoActivity(intent, TileDataAdapter.this.activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(TileDataAdapter.this.activity, "", courselist.getMaintenanceText());
                return;
            }
            Helper.showInternetToast(TileDataAdapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (!Helper.isConnected(TileDataAdapter.this.activity)) {
                Helper.showInternetToast(TileDataAdapter.this.activity);
                return;
            }
            TileDataAdapter.this.mainCourseId = courselist.getId();
            TileDataAdapter.this.parentCourseId = "";
            if (courselist.getCombo_course_ids() != null && courselist.getCombo_course_ids().isEmpty()) {
                TileDataAdapter tileDataAdapter = TileDataAdapter.this;
                tileDataAdapter.parentCourseId = tileDataAdapter.mainCourseId;
            }
            TileDataAdapter.this.networkCall.NetworkAPICall(API.CourseDetail_JS, "", true, false);
        }
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {
        LinearLayout cartLinear;
        TextView courseDescription;
        LinearLayout linear_rating;
        ImageView liveImageView;
        LinearLayout ll_scholorship_discount;
        LinearLayout maiView;
        TextView mrpCutTV;
        ImageView new_course;
        TextView price;
        LinearLayout price_linear;
        RatingBar rating_bar_indicator;
        TextView scholarshipCouponTV;
        LinearLayout tileRL;
        TextView titleTV;
        LinearLayout title_ll;
        TextView userRate_count;
        TextView validityTextTV;
        ImageView videoImage;
        RelativeLayout videoplayerRL;

        public MyViewHodler(View itemView) {
            super(itemView);
            this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.titleTV = (TextView) itemView.findViewById(R.id.ibt_current_affair_title);
            this.validityTextTV = (TextView) itemView.findViewById(R.id.validityTextTV);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
            this.tileRL = (LinearLayout) itemView.findViewById(R.id.currentAffairRL);
            this.linear_rating = (LinearLayout) itemView.findViewById(R.id.linear_rating);
            this.cartLinear = (LinearLayout) itemView.findViewById(R.id.cartLinear);
            this.rating_bar_indicator = (RatingBar) itemView.findViewById(R.id.rating_bar_indicator);
            this.userRate_count = (TextView) itemView.findViewById(R.id.userRate_count);
            this.title_ll = (LinearLayout) itemView.findViewById(R.id.title_ll);
            this.videoplayerRL = (RelativeLayout) itemView.findViewById(R.id.videoplayerRL);
            this.liveImageView = (ImageView) itemView.findViewById(R.id.liveIV);
            this.maiView = (LinearLayout) itemView.findViewById(R.id.maiView);
            this.new_course = (ImageView) itemView.findViewById(R.id.new_course);
            this.scholarshipCouponTV = (TextView) itemView.findViewById(R.id.scholarshipCouponTV);
            this.ll_scholorship_discount = (LinearLayout) itemView.findViewById(R.id.ll_scholorship_discount);
            this.price_linear = (LinearLayout) itemView.findViewById(R.id.price_linear);
            this.courseDescription = (TextView) itemView.findViewById(R.id.courseDescription);
        }

        public void setData(final Courselist course, int position) {
            boolean z;
            int screenWidth;
            int screenWidth2;
            checkShowVisibility();
            if (TileDataAdapter.this.couponPojo == null || TileDataAdapter.this.couponPojo.getAvailable() == null || TileDataAdapter.this.couponPojo.getAvailable().size() <= 0) {
                z = false;
            } else {
                z = false;
                for (Available available : TileDataAdapter.this.couponPojo.getAvailable()) {
                    if (available.getCourses().size() > 0) {
                        Iterator<CoursesCoupon> it = available.getCourses().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                CoursesCoupon next = it.next();
                                if (!course.getIs_purchased().equalsIgnoreCase("1") && course.getId().equalsIgnoreCase(next.getId()) && Long.parseLong(available.getEnd()) * 1000 > Calendar.getInstance().getTimeInMillis()) {
                                    String coupon_value = available.getCoupon_value();
                                    String coupon_type = available.getCoupon_type();
                                    if (!TextUtils.isEmpty(coupon_value) && Integer.parseInt(coupon_value) > 0) {
                                        z = true;
                                    }
                                    if (coupon_type.equalsIgnoreCase("1")) {
                                        this.scholarshipCouponTV.setText("You will get " + TileDataAdapter.this.activity.getResources().getString(R.string.rupees) + coupon_value + " scholarship if you will enroll this course.");
                                    } else {
                                        this.scholarshipCouponTV.setText("You will get " + coupon_value + "% scholarship if you will enroll this course.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                this.ll_scholorship_discount.setVisibility(0);
            } else {
                this.ll_scholorship_discount.setVisibility(8);
            }
            if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                int screenWidth3 = HelperProgress.getScreenWidth() / 2;
                boolean z2 = (TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 4;
                if ((TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 3) {
                    screenWidth2 = HelperProgress.getScreenWidth() / 2;
                } else if (z2) {
                    screenWidth2 = (HelperProgress.getScreenWidth() / 2) + 300;
                } else {
                    screenWidth2 = (HelperProgress.getScreenWidth() / 2) + 100;
                }
                this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth3, screenWidth2));
                this.videoImage.setClipToOutline(true);
            }
            Glide.with(TileDataAdapter.this.activity).load(Integer.valueOf(R.mipmap.live)).into(this.liveImageView);
            Glide.with(TileDataAdapter.this.activity).load(Integer.valueOf(R.mipmap.new_)).into(this.new_course);
            if (course.getExtra_json() != null) {
                if (course.getExtra_json().getIs_new() != null && course.getExtra_json().getIs_new().equals("1")) {
                    this.new_course.setVisibility(0);
                } else {
                    this.new_course.setVisibility(8);
                }
            }
            if (!GenericUtils.isEmpty(TileDataAdapter.this.isBook)) {
                if (TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                    ((ConstraintLayout.LayoutParams) this.videoImage.getLayoutParams()).dimensionRatio = "9:11";
                } else if (SharedPreference.getInstance().getString(Const.IS_HOME_GRID).equalsIgnoreCase("1") || (TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1"))) {
                    int screenWidth4 = HelperProgress.getScreenWidth() / 2;
                    boolean z3 = (TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 4;
                    if (!((TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 3) && z3) {
                        int screenWidth5 = HelperProgress.getScreenWidth() / 2;
                    } else {
                        int screenWidth6 = HelperProgress.getScreenWidth() / 2;
                    }
                    ((ConstraintLayout.LayoutParams) this.videoImage.getLayoutParams()).dimensionRatio = "1:1";
                }
            }
            if (!GenericUtils.isEmpty(TileDataAdapter.this.isBook)) {
                if (BuildConfig.FLAVOR.equalsIgnoreCase("dsl")) {
                    int screenWidth7 = HelperProgress.getScreenWidth() / 2;
                    boolean z4 = (TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 4;
                    if ((TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 3) {
                        screenWidth = HelperProgress.getScreenWidth() / 2;
                    } else if (z4) {
                        screenWidth = (HelperProgress.getScreenWidth() / 2) + 300;
                    } else {
                        screenWidth = (HelperProgress.getScreenWidth() / 2) + 100;
                    }
                    this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth7, screenWidth));
                    this.videoImage.setClipToOutline(true);
                    if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                        Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                    } else {
                        this.videoImage.setImageResource(R.mipmap.book_placeholder);
                    }
                } else if (SharedPreference.getInstance().getString(Const.IS_HOME_GRID).equalsIgnoreCase("1") || TileDataAdapter.this.isBook.equalsIgnoreCase("1") || (TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1"))) {
                    if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                        Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                    } else {
                        this.videoImage.setImageResource(R.mipmap.square_placeholder);
                    }
                } else if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.placeholder_course);
                }
            } else if ("1".equals("5")) {
                if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.square_placeholder);
                }
            } else if (SharedPreference.getInstance().getString(Const.IS_HOME_GRID).equalsIgnoreCase("1") || TileDataAdapter.this.isBook.equalsIgnoreCase("1") || (TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1"))) {
                if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.square_placeholder);
                }
            } else if (!TextUtils.isEmpty(course.getCover_image())) {
                Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImage);
            } else {
                this.videoImage.setImageResource(R.mipmap.placeholder_course);
            }
            if (!TextUtils.isEmpty(course.getColorCode())) {
                this.videoplayerRL.setBackgroundColor(Color.parseColor(course.getColorCode()));
            }
            if (!GenericUtils.isEmpty(TileDataAdapter.this.isBook) && TileDataAdapter.this.isBook.equals("1")) {
                this.titleTV.setTextSize(12.0f);
            } else {
                this.titleTV.setTextSize(14.0f);
            }
            this.titleTV.setText(course.getTitle());
            this.cartLinear.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodler$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(course, view);
                }
            });
            this.maiView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodler$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$1(course, view);
                }
            });
            if (course.getValidity() == null || course.getValidity().equals("") || course.getValidity().equals("0") || course.getValidity().equalsIgnoreCase("0 Days") || course.getValidity().equals("-1") || course.getValidity().equalsIgnoreCase("-1 Days")) {
                this.validityTextTV.setVisibility(8);
                if (course.getCourseSp() == null || course.getCourseSp().equalsIgnoreCase("0")) {
                    this.price.setVisibility(8);
                } else if (course.getCat_type() != null && course.getCat_type().equalsIgnoreCase("3")) {
                    this.price.setVisibility(8);
                } else {
                    this.price.setVisibility(0);
                }
            } else if (course.getCat_type() != null && course.getCat_type().equalsIgnoreCase("3")) {
                this.validityTextTV.setVisibility(8);
                this.price.setVisibility(8);
            } else {
                if (course.getHide_validity() != null && course.getHide_validity().equalsIgnoreCase("1")) {
                    this.validityTextTV.setVisibility(8);
                } else {
                    this.validityTextTV.setVisibility(0);
                }
                this.price.setVisibility(0);
            }
            if (course.getIs_purchased() != null && course.getIs_purchased().equals("1")) {
                this.price_linear.setVisibility(4);
            }
            if (BuildConfig.FLAVOR.equalsIgnoreCase("mahendra") && course.getIs_purchased() != null) {
                if (course.getIs_purchased().equals("1")) {
                    this.cartLinear.setVisibility(8);
                    this.linear_rating.setVisibility(0);
                } else if (course.getCourseSp().equalsIgnoreCase("0")) {
                    this.cartLinear.setVisibility(8);
                    this.linear_rating.setVisibility(8);
                } else {
                    this.cartLinear.setVisibility(0);
                    this.linear_rating.setVisibility(0);
                    this.rating_bar_indicator.setRating(Float.valueOf(course.getAvg_rating()).floatValue());
                    this.userRate_count.setText("(" + course.getUser_rated() + ")");
                }
            }
            if (course.getCourseSp() != null && course.getCourseSp().equalsIgnoreCase("0")) {
                this.price.setText(TileDataAdapter.this.activity.getResources().getString(R.string.free));
                this.price.setTextAlignment(2);
                this.validityTextTV.setText(String.format("%s %s", TileDataAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity()));
                this.mrpCutTV.setVisibility(8);
            } else if (course.getCourseSp() != null && course.getCourseSp().equalsIgnoreCase(course.getMrp())) {
                this.mrpCutTV.setVisibility(8);
                this.validityTextTV.setText(String.format("%s %s", TileDataAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity(), Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
                this.price.setText(Constants.currencyType + "" + course.getMrp() + "/-");
            } else {
                this.price.setText(String.format("%s %s %s", Constants.currencyType, course.getCourseSp(), "/-"));
                this.mrpCutTV.setText(String.format("%s %s %s", Constants.currencyType, course.getMrp(), "/-"), TextView.BufferType.SPANNABLE);
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                Spannable spannable = (Spannable) this.mrpCutTV.getText();
                if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                    if (course.getCat_type() != null && course.getCat_type().equalsIgnoreCase("3")) {
                        this.mrpCutTV.setVisibility(8);
                    } else {
                        this.mrpCutTV.setVisibility(0);
                    }
                } else {
                    this.mrpCutTV.setVisibility(8);
                }
                if (course.getMrp() != null) {
                    spannable.setSpan(strikethroughSpan, 2, new String(course.getMrp()).length() + 2, 33);
                }
                if (course.getValidity() != null) {
                    this.validityTextTV.setText(String.format("%s %s", TileDataAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity(), Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
                }
            }
            if (BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia") && (TileDataAdapter.this.activity instanceof DashboardActivityTheme2)) {
                this.validityTextTV.setVisibility(8);
                this.price.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            TileDataAdapter.this.course_id = courselist.getId();
            TileDataAdapter.this.course_name = courselist.getTitle();
            TileDataAdapter.this.course_price = courselist.getCourseSp();
            TileDataAdapter.this.course_price = courselist.getTxn_id();
            TileDataAdapter.this.course_quantity = "1";
            TileDataAdapter.this.networkCall.NetworkAPICall(API.COURSE_ADD_TO_CART, "", false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (Helper.isNetworkConnected(TileDataAdapter.this.activity)) {
                if (Helper.isTricksWale() && courselist.getCat_type().equalsIgnoreCase("1") && courselist.getIs_purchased() != null && courselist.getIs_purchased().equalsIgnoreCase("1")) {
                    Toast.makeText(TileDataAdapter.this.activity, TileDataAdapter.this.activity.getResources().getString(R.string.book_already_purchased), 0).show();
                    return;
                }
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    Intent intent = new Intent(TileDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                    Helper.gotoActivity(intent, TileDataAdapter.this.activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(TileDataAdapter.this.activity, "", courselist.getMaintenanceText());
                return;
            }
            Helper.showInternetToast(TileDataAdapter.this.activity);
        }

        public void checkShowVisibility() {
            if (TileDataAdapter.this.utkashRoom == null || !TileDataAdapter.this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                return;
            }
            ThemeSettings themeSettingsData = TileDataAdapter.this.utkashRoom.getthemeSettingdao().data();
            TileDataAdapter.this.bottomSetting = (BottomSetting) new Gson().fromJson(themeSettingsData.getBottom(), BottomSetting.class);
        }
    }

    public class MyViewHodlerPhysicsGalaxy extends RecyclerView.ViewHolder {
        TextView buyNowId;
        LinearLayout cartLinear;
        RelativeLayout discountRL;
        TextView discountTV;
        View divider;
        TextView exploreId;
        LinearLayout linear_rating;
        ImageView liveImageView;
        LinearLayout maiView;
        LinearLayout main_rl;
        TextView mrpCutTV;
        ImageView new_course;
        TextView price;
        RelativeLayout price_linear;
        RatingBar rating_bar_indicator;
        FrameLayout soldOutImg;
        LinearLayout tileRL;
        TextView titleTV;
        LinearLayout title_ll;
        TextView userRate_count;
        LinearLayout validityRowId;
        TextView validityTextTV;
        ImageView videoImage;
        RelativeLayout videoplayerRL;

        public MyViewHodlerPhysicsGalaxy(View itemView) {
            super(itemView);
            this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.titleTV = (TextView) itemView.findViewById(R.id.ibt_current_affair_title);
            this.validityTextTV = (TextView) itemView.findViewById(R.id.validityTextTV);
            this.validityRowId = (LinearLayout) itemView.findViewById(R.id.validityRowId);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
            this.tileRL = (LinearLayout) itemView.findViewById(R.id.currentAffairRL);
            this.linear_rating = (LinearLayout) itemView.findViewById(R.id.linear_rating);
            this.cartLinear = (LinearLayout) itemView.findViewById(R.id.cartLinear);
            this.rating_bar_indicator = (RatingBar) itemView.findViewById(R.id.rating_bar_indicator);
            this.userRate_count = (TextView) itemView.findViewById(R.id.userRate_count);
            this.title_ll = (LinearLayout) itemView.findViewById(R.id.title_ll);
            this.videoplayerRL = (RelativeLayout) itemView.findViewById(R.id.videoplayerRL);
            this.liveImageView = (ImageView) itemView.findViewById(R.id.liveIV);
            this.new_course = (ImageView) itemView.findViewById(R.id.new_course);
            this.maiView = (LinearLayout) itemView.findViewById(R.id.maiView);
            this.exploreId = (TextView) itemView.findViewById(R.id.exploreId);
            this.buyNowId = (TextView) itemView.findViewById(R.id.buyNowId);
            this.discountRL = (RelativeLayout) itemView.findViewById(R.id.discountRL);
            this.discountTV = (TextView) itemView.findViewById(R.id.discountTV);
            this.divider = itemView.findViewById(R.id.divider);
            this.price_linear = (RelativeLayout) itemView.findViewById(R.id.price_linear);
            this.soldOutImg = (FrameLayout) itemView.findViewById(R.id.soldOutImg);
        }

        public void setData(final Courselist course, int position) {
            int i;
            boolean z;
            String validity;
            this.price.setTextColor(TileDataAdapter.this.activity.getResources().getColor(R.color.black));
            Helper.applyPrimaryColorLight(TileDataAdapter.this.activity, this.discountRL, 6.0f, R.drawable.discount_bg);
            Helper.applyPrimaryColorLight(TileDataAdapter.this.activity, this.exploreId, 10.0f, R.drawable.discount_light_bg);
            this.exploreId.setTextColor(TileDataAdapter.this.activity.getResources().getColor(R.color.colorPrimary));
            this.buyNowId.setBackgroundResource(R.drawable.discount_solid_bg);
            this.buyNowId.setTextColor(TileDataAdapter.this.activity.getResources().getColor(R.color.white));
            int i2 = !TextUtils.isEmpty(course.getDiscount()) ? (int) Double.parseDouble(course.getDiscount()) : 0;
            if (!TileDataAdapter.this.isBook.equalsIgnoreCase("1") && course.getCourseSp() != null && course.getCourseSp().equalsIgnoreCase("0")) {
                this.buyNowId.setVisibility(8);
            } else {
                if (TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                    this.price.setText(TileDataAdapter.this.activity.getResources().getString(R.string.free));
                    this.price.setTextAlignment(2);
                }
                if (course.getPayment_mode() != null && !course.getPayment_mode().equals("3")) {
                    this.buyNowId.setVisibility(0);
                } else {
                    this.buyNowId.setVisibility(8);
                }
            }
            if (course.getMrp().equalsIgnoreCase("") || course.getMrp().equalsIgnoreCase("0")) {
                this.discountRL.setVisibility(8);
            } else {
                this.discountRL.setVisibility(0);
                TileDataAdapter.this.setDiscount(this.discountTV, i2);
            }
            if (course.getPayment_mode() != null && course.getPayment_mode().equals("3")) {
                i = 0;
                this.validityTextTV.setText("Try for " + course.getValidity() + " in  ₹" + course.getCourseSp().split("\\.")[0]);
            } else {
                i = 0;
                this.validityTextTV.setText(String.format("%s %s", TileDataAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity()));
            }
            if (!TileDataAdapter.this.isBook.equalsIgnoreCase("1") && course.getIs_purchased() != null && course.getIs_purchased().equals("1")) {
                this.buyNowId.setVisibility(8);
            }
            if (course.getExtra_json().getIs_live() != null && course.getExtra_json().getIs_live().equals("1")) {
                this.liveImageView.setVisibility(i);
            } else {
                this.liveImageView.setVisibility(8);
            }
            if (TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                TextView textView = this.exploreId;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else {
                TextView textView2 = this.exploreId;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            }
            checkShowVisibility();
            Glide.with(TileDataAdapter.this.activity).load(Integer.valueOf(R.mipmap.live)).into(this.liveImageView);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(2000L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            this.liveImageView.startAnimation(alphaAnimation);
            Glide.with(TileDataAdapter.this.activity).load(Integer.valueOf(R.mipmap.new_)).into(this.new_course);
            if (course.getExtra_json() != null) {
                if (course.getExtra_json().getIs_new() != null && course.getExtra_json().getIs_new().equals("1")) {
                    this.new_course.setVisibility(0);
                } else {
                    this.new_course.setVisibility(8);
                }
                if (course.getExtra_json().getIs_live() != null && course.getExtra_json().getIs_live().equals("1")) {
                    this.liveImageView.setVisibility(0);
                } else {
                    this.liveImageView.setVisibility(8);
                }
            }
            if (!GenericUtils.isEmpty(TileDataAdapter.this.isBook) && (TileDataAdapter.this.isBook.equalsIgnoreCase("1") || (TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1")))) {
                ViewGroup.LayoutParams layoutParams = this.videoImage.getLayoutParams();
                layoutParams.width = (HelperProgress.getScreenWidth() / 2) - 40;
                layoutParams.height = (int) (((double) layoutParams.width) * 1.5d);
                this.videoImage.setLayoutParams(layoutParams);
                if ((TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1") && SharedPreference.getInstance().getString(Const.HIDE_EXPLORE_BTN).equalsIgnoreCase("1")) || SharedPreference.getInstance().getString(Const.HIDE_EXPLORE_BTN).equalsIgnoreCase("1")) {
                    TextView textView3 = this.exploreId;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                } else {
                    TextView textView4 = this.exploreId;
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                    }
                }
            }
            if (!GenericUtils.isEmpty(TileDataAdapter.this.isBook)) {
                if (TileDataAdapter.this.isBook.equalsIgnoreCase("1") && !TextUtils.isEmpty(course.getCat_type()) && course.getCat_type().equalsIgnoreCase("1")) {
                    if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                        Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                    } else {
                        this.videoImage.setImageResource(R.mipmap.square_placeholder);
                    }
                } else if (TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                    if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                        Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                    } else {
                        this.videoImage.setImageResource(R.mipmap.square_placeholder);
                    }
                    if ((TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1") && SharedPreference.getInstance().getString(Const.HIDE_EXPLORE_BTN).equalsIgnoreCase("1")) || SharedPreference.getInstance().getString(Const.HIDE_EXPLORE_BTN).equalsIgnoreCase("1")) {
                        TextView textView5 = this.exploreId;
                        if (textView5 != null) {
                            textView5.setVisibility(8);
                        }
                    } else {
                        TextView textView6 = this.exploreId;
                        if (textView6 != null) {
                            textView6.setVisibility(0);
                        }
                    }
                } else if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.placeholder_course);
                }
            } else if ("1".equals("5")) {
                if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.square_placeholder);
                }
            } else if (TileDataAdapter.this.isNewStyle) {
                if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.placeholder_course);
                }
            } else if (TileDataAdapter.this.getItemViewType(position) != 2) {
                if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.placeholder_course);
                }
            } else if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImage);
            } else {
                this.videoImage.setImageResource(R.mipmap.placeholder_course);
            }
            if (!TextUtils.isEmpty(course.getColorCode())) {
                this.videoplayerRL.setBackgroundColor(Color.parseColor(course.getColorCode()));
            }
            if (!GenericUtils.isEmpty(TileDataAdapter.this.isBook) && TileDataAdapter.this.isBook.equals("1")) {
                this.titleTV.setTextSize(14.0f);
            } else {
                this.titleTV.setTextSize(18.0f);
            }
            this.titleTV.setText(course.getTitle());
            this.exploreId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodlerPhysicsGalaxy$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(course, view);
                }
            });
            if (BuildConfig.FLAVOR.equalsIgnoreCase("rankBddy")) {
                this.videoImage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodlerPhysicsGalaxy$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$1(course, view);
                    }
                });
            }
            this.buyNowId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodlerPhysicsGalaxy$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$2(course, view);
                }
            });
            this.maiView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodlerPhysicsGalaxy$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$3(course, view);
                }
            });
            if (course.getValidity() == null || course.getValidity().equals("") || course.getValidity().equals("0") || course.getValidity().equalsIgnoreCase("0 Days") || course.getValidity().equals("-1") || course.getValidity().equalsIgnoreCase("-1 Days")) {
                if (TileDataAdapter.this.getItemViewType(position) != 2 || TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                    this.validityRowId.setVisibility(8);
                }
                if (!TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                    if (course.getCourseSp() == null || course.getCourseSp().equalsIgnoreCase("0")) {
                        this.price.setVisibility(8);
                    } else {
                        this.price.setVisibility(0);
                    }
                } else {
                    this.price.setVisibility(0);
                }
            } else {
                this.price.setVisibility(0);
                if (TileDataAdapter.this.getItemViewType(position) != 2) {
                    if (TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                        this.validityRowId.setVisibility(8);
                    } else {
                        this.validityRowId.setVisibility(0);
                    }
                }
            }
            if (course.getCourseSp() != null && course.getCourseSp().equalsIgnoreCase("0")) {
                if (TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                    this.buyNowId.setVisibility(0);
                } else {
                    this.buyNowId.setVisibility(8);
                }
                this.price.setText(TileDataAdapter.this.activity.getResources().getString(R.string.free));
                this.price.setTextAlignment(2);
                if (course.getValidity().contains(":")) {
                    validity = "till :" + course.getValidity().split(":")[1];
                } else {
                    validity = course.getValidity();
                }
                this.validityTextTV.setText(String.format("%s %s", "Validity", validity, Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
                this.mrpCutTV.setVisibility(8);
                z = true;
            } else {
                if ((TileDataAdapter.this.isBook.equalsIgnoreCase("1") || TileDataAdapter.this.courseDataArrayList.get(position).getIs_purchased() == null || !TileDataAdapter.this.courseDataArrayList.get(position).getIs_purchased().equalsIgnoreCase("1")) && course.getPayment_mode() != null && !"3".equals(course.getPayment_mode())) {
                    this.buyNowId.setVisibility(0);
                } else {
                    this.buyNowId.setVisibility(8);
                }
                z = true;
                if (course.getCourseSp() != null && course.getCourseSp().equalsIgnoreCase(course.getMrp())) {
                    this.mrpCutTV.setVisibility(8);
                    if (course.getValidity().contains(":")) {
                        String str = "till :" + course.getValidity().split(":")[1];
                    } else {
                        course.getValidity();
                    }
                    if (course.getPayment_mode() != null && course.getPayment_mode().equals("3")) {
                        this.validityTextTV.setText("Try for " + course.getValidity() + " in  ₹" + course.getCourseSp().split("\\.")[0]);
                    } else {
                        this.validityTextTV.setText(String.format("%s %s", TileDataAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity()));
                    }
                    this.price.setText(Constants.currencyType + "" + course.getMrp() + "/-");
                } else {
                    this.price.setText(Constants.currencyType + "" + course.getCourseSp() + "/-");
                    this.mrpCutTV.setText(String.format("%s%s%s", Constants.currencyType, course.getMrp(), "/-"), TextView.BufferType.SPANNABLE);
                    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                    Spannable spannable = (Spannable) this.mrpCutTV.getText();
                    if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                        this.mrpCutTV.setVisibility(0);
                    } else {
                        this.mrpCutTV.setVisibility(8);
                    }
                    if (course.getMrp() != null) {
                        spannable.setSpan(strikethroughSpan, 2, new String(course.getMrp()).length() + 2, 33);
                    }
                    if (course.getPayment_mode() != null && !course.getPayment_mode().equalsIgnoreCase("3") && course.getValidity() != null && TileDataAdapter.this.getItemViewType(position) != 2) {
                        if (course.getValidity().contains(":")) {
                            this.validityTextTV.setText(String.format("%s %s", "Valid", "till :" + course.getValidity().split(":")[1], Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
                        } else {
                            this.validityTextTV.setText(String.format("%s %s", "Validity", course.getValidity(), Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
                        }
                    }
                }
            }
            if (BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia") && (TileDataAdapter.this.activity instanceof DashboardActivityTheme2)) {
                this.validityTextTV.setVisibility(8);
                this.price.setVisibility(8);
            }
            if (!TileDataAdapter.this.isBook.equalsIgnoreCase("1") && course.getIs_purchased() != null && course.getIs_purchased().equalsIgnoreCase("1")) {
                this.price.setText("Purchased");
                this.mrpCutTV.setVisibility(8);
                this.discountRL.setVisibility(8);
                TextView textView7 = this.exploreId;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                }
            }
            if (course.getPayment_mode() != null && course.getPayment_mode().equals("3")) {
                this.price_linear.setVisibility(8);
                if (course.getIs_purchased() != null && course.getIs_purchased().equals("1")) {
                    this.divider.setVisibility(8);
                    this.validityRowId.setVisibility(8);
                }
            }
            boolean z2 = (course.getExtra_json() == null || !"1".equalsIgnoreCase(course.getExtra_json().getSold_out())) ? false : z;
            if (course.getIs_purchased() == null || !"1".equalsIgnoreCase(course.getIs_purchased())) {
                z = false;
            }
            if (z2 && !z) {
                this.soldOutImg.setVisibility(0);
                this.buyNowId.setVisibility(0);
                this.buyNowId.setBackgroundResource(R.drawable.sold_out_solid);
                this.buyNowId.setText(R.string.sold_out);
                this.buyNowId.setTextColor(TileDataAdapter.this.activity.getResources().getColor(R.color.white));
                this.buyNowId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$MyViewHodlerPhysicsGalaxy$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$4(view);
                    }
                });
                return;
            }
            this.soldOutImg.setVisibility(8);
            this.buyNowId.setBackgroundResource(R.drawable.discount_solid_bg);
            this.buyNowId.setText(R.string.buy_now);
            this.buyNowId.setTextColor(TileDataAdapter.this.activity.getResources().getColor(R.color.white));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (Helper.isNetworkConnected(TileDataAdapter.this.activity)) {
                FacebookEventLogger.logViewCourseDetails(TileDataAdapter.this.activity, courselist.getId(), Helper.getLoggedInUserInfo(TileDataAdapter.this.activity));
                if (!TextUtils.isEmpty(courselist.getBook_redirection_link()) && TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                    TileDataAdapter tileDataAdapter = TileDataAdapter.this;
                    tileDataAdapter.openUrlInBrowser(tileDataAdapter.activity, courselist.getBook_redirection_link());
                    return;
                }
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    Intent intent = new Intent(TileDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                    Helper.gotoActivity(intent, TileDataAdapter.this.activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(TileDataAdapter.this.activity, "", courselist.getMaintenanceText());
                return;
            }
            Helper.showInternetToast(TileDataAdapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$1(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (Helper.isNetworkConnected(TileDataAdapter.this.activity)) {
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    Intent intent = new Intent(TileDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                    Helper.gotoActivity(intent, TileDataAdapter.this.activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(TileDataAdapter.this.activity, "", courselist.getMaintenanceText());
                return;
            }
            Helper.showInternetToast(TileDataAdapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$2(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (!Helper.isConnected(TileDataAdapter.this.activity)) {
                Helper.showInternetToast(TileDataAdapter.this.activity);
                return;
            }
            FacebookEventLogger.logBuyNowClicked(TileDataAdapter.this.activity, courselist.getId(), Helper.getLoggedInUserInfo(TileDataAdapter.this.activity));
            if (!TextUtils.isEmpty(courselist.getBook_redirection_link()) && TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                TileDataAdapter tileDataAdapter = TileDataAdapter.this;
                tileDataAdapter.openUrlInBrowser(tileDataAdapter.activity, courselist.getBook_redirection_link());
                return;
            }
            TileDataAdapter.this.mainCourseId = courselist.getId();
            TileDataAdapter.this.parentCourseId = "";
            if (courselist.getCombo_course_ids() != null && courselist.getCombo_course_ids().isEmpty()) {
                TileDataAdapter tileDataAdapter2 = TileDataAdapter.this;
                tileDataAdapter2.parentCourseId = tileDataAdapter2.mainCourseId;
            }
            TileDataAdapter.this.networkCall.NetworkAPICall(API.CourseDetail_JS, "", true, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$3(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if (Helper.isNetworkConnected(TileDataAdapter.this.activity)) {
                FacebookEventLogger.logViewCourseDetails(TileDataAdapter.this.activity, courselist.getId(), Helper.getLoggedInUserInfo(TileDataAdapter.this.activity));
                if (!TextUtils.isEmpty(courselist.getBook_redirection_link()) && TileDataAdapter.this.isBook.equalsIgnoreCase("1")) {
                    TileDataAdapter tileDataAdapter = TileDataAdapter.this;
                    tileDataAdapter.openUrlInBrowser(tileDataAdapter.activity, courselist.getBook_redirection_link());
                    return;
                }
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    Intent intent = new Intent(TileDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                    Helper.gotoActivity(intent, TileDataAdapter.this.activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(TileDataAdapter.this.activity, "", courselist.getMaintenanceText());
                return;
            }
            Helper.showInternetToast(TileDataAdapter.this.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$4(View view) {
            Toast.makeText(TileDataAdapter.this.activity, R.string.sold_out_msg, 0).show();
        }

        public void checkShowVisibility() {
            if (TileDataAdapter.this.utkashRoom == null || !TileDataAdapter.this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                return;
            }
            ThemeSettings themeSettingsData = TileDataAdapter.this.utkashRoom.getthemeSettingdao().data();
            TileDataAdapter.this.bottomSetting = (BottomSetting) new Gson().fromJson(themeSettingsData.getBottom(), BottomSetting.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDiscount(TextView discountTV, int a2) {
        if (a2 == 0) {
            discountTV.setVisibility(8);
        } else {
            discountTV.setText(String.format("%s", a2 + "% off"));
        }
    }

    class ViewHolderTheme8 extends RecyclerView.ViewHolder {
        ImageView liveImageView;
        RelativeLayout maiView;
        TextView mrpCutTV;
        ImageView new_course;
        TextView price;
        LinearLayout tileRL;
        TextView titleTV;
        LinearLayout title_ll;
        TextView validityTextTV;
        ImageView videoImage;
        RelativeLayout videoplayerRL;

        public ViewHolderTheme8(View itemView) {
            super(itemView);
            this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.titleTV = (TextView) itemView.findViewById(R.id.ibt_current_affair_title);
            this.validityTextTV = (TextView) itemView.findViewById(R.id.validityTextTV);
            this.mrpCutTV = (TextView) itemView.findViewById(R.id.mrpCutTV);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
            this.tileRL = (LinearLayout) itemView.findViewById(R.id.currentAffairRL);
            this.title_ll = (LinearLayout) itemView.findViewById(R.id.title_ll);
            this.videoplayerRL = (RelativeLayout) itemView.findViewById(R.id.videoplayerRL);
            this.liveImageView = (ImageView) itemView.findViewById(R.id.liveIV);
            this.new_course = (ImageView) itemView.findViewById(R.id.new_course);
            this.maiView = (RelativeLayout) itemView.findViewById(R.id.maiView);
        }

        public void setData(final Courselist course, int position) {
            int screenWidth;
            int screenWidth2;
            Log.d("SOLDOUT_DEBUG", "=== setData position=" + position + " | id=" + course.getId() + " | extra_json=" + (course.getExtra_json() != null ? new Gson().toJson(course.getExtra_json()) : "NULL") + " | sold_out=" + (course.getExtra_json() != null ? course.getExtra_json().getSold_out() : "NULL") + " | is_purchased=" + course.getIs_purchased());
            checkShowVisibility();
            if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                int screenWidth3 = HelperProgress.getScreenWidth() / 2;
                boolean z = (TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 4;
                if ((TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 3) {
                    screenWidth2 = HelperProgress.getScreenWidth() / 2;
                } else if (z) {
                    screenWidth2 = (HelperProgress.getScreenWidth() / 2) + 300;
                } else {
                    screenWidth2 = (HelperProgress.getScreenWidth() / 2) + 100;
                }
                this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth3, screenWidth2));
                this.videoImage.setClipToOutline(true);
            }
            Glide.with(TileDataAdapter.this.activity).load(Integer.valueOf(R.mipmap.live)).into(this.liveImageView);
            Glide.with(TileDataAdapter.this.activity).load(Integer.valueOf(R.mipmap.new_)).into(this.new_course);
            if (course.getExtra_json() != null) {
                if (course.getExtra_json().getIs_new() != null && course.getExtra_json().getIs_new().equals("1")) {
                    this.new_course.setVisibility(0);
                } else {
                    this.new_course.setVisibility(8);
                }
            }
            if (!GenericUtils.isEmpty(TileDataAdapter.this.isBook)) {
                if (BuildConfig.FLAVOR.equalsIgnoreCase("dsl")) {
                    int screenWidth4 = HelperProgress.getScreenWidth() / 2;
                    boolean z2 = (TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 4;
                    if ((TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 3) {
                        screenWidth = HelperProgress.getScreenWidth() / 2;
                    } else if (z2) {
                        screenWidth = (HelperProgress.getScreenWidth() / 2) + 300;
                    } else {
                        screenWidth = (HelperProgress.getScreenWidth() / 2) + 100;
                    }
                    this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth4, screenWidth));
                    this.videoImage.setClipToOutline(true);
                    if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                        Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                    } else {
                        this.videoImage.setImageResource(R.mipmap.book_placeholder);
                    }
                } else if (TileDataAdapter.this.isBook.equalsIgnoreCase("1") || (TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1"))) {
                    if (!TextUtils.isEmpty(course.getCover_image())) {
                        Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                    } else {
                        this.videoImage.setImageResource(R.mipmap.square_placeholder);
                    }
                } else if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.placeholder_course);
                }
            } else if ("1".equals("5")) {
                if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.book_placeholder);
                }
            } else if (TileDataAdapter.this.bottomSetting != null && TileDataAdapter.this.bottomSetting.getLayout_type() != null && TileDataAdapter.this.bottomSetting.getLayout_type().equals("1")) {
                if (!TextUtils.isEmpty(course.getCover_image())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getCover_image(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.square_placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.square_placeholder);
                }
            } else if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder_course), this.videoImage);
            } else {
                this.videoImage.setImageResource(R.mipmap.placeholder_course);
            }
            if (!TextUtils.isEmpty(course.getColorCode())) {
                this.videoplayerRL.setBackgroundColor(Color.parseColor(course.getColorCode()));
            }
            if (GenericUtils.isEmpty(TileDataAdapter.this.isBook) || TileDataAdapter.this.isBook.equals("1")) {
                this.titleTV.setTextSize(16.0f);
            } else {
                this.titleTV.setTextSize(16.0f);
            }
            this.titleTV.setText(course.getTitle());
            this.maiView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.adapters.TileDataAdapter$ViewHolderTheme8$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(course, view);
                }
            });
            if (course.getValidity().equals("") || course.getValidity().equals("0") || course.getValidity().equalsIgnoreCase("0 Days") || course.getValidity().equals("-1") || course.getValidity().equalsIgnoreCase("-1 Days")) {
                this.validityTextTV.setVisibility(8);
                if (course.getCourseSp().equalsIgnoreCase("0")) {
                    this.price.setVisibility(8);
                } else if (course.getCat_type() != null && course.getCat_type().equalsIgnoreCase("3")) {
                    this.price.setVisibility(8);
                } else {
                    this.price.setVisibility(0);
                }
            } else if (course.getCat_type() != null && course.getCat_type().equalsIgnoreCase("3")) {
                this.validityTextTV.setVisibility(8);
                this.price.setVisibility(8);
            } else {
                if (course.getHide_validity() != null && course.getHide_validity().equalsIgnoreCase("1")) {
                    this.validityTextTV.setVisibility(8);
                } else {
                    this.validityTextTV.setVisibility(0);
                }
                this.price.setVisibility(0);
            }
            if (course.getCourseSp().equalsIgnoreCase("0")) {
                this.price.setText(TileDataAdapter.this.activity.getResources().getString(R.string.free));
                this.price.setTextAlignment(2);
                this.validityTextTV.setText(String.format("%s %s", TileDataAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity()));
                this.mrpCutTV.setVisibility(8);
            } else if (course.getCourseSp().equalsIgnoreCase(course.getMrp())) {
                this.mrpCutTV.setVisibility(8);
                this.validityTextTV.setText(String.format("%s %s", TileDataAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity(), Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
                this.price.setText(Constants.currencyType + "" + course.getMrp() + "/-");
            } else {
                this.price.setText(String.format("%s %s %s", Constants.currencyType, course.getCourseSp(), "/-"));
                this.mrpCutTV.setText(String.format("%s %s %s", Constants.currencyType, course.getMrp(), "/-"), TextView.BufferType.SPANNABLE);
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                Spannable spannable = (Spannable) this.mrpCutTV.getText();
                if (Constants.is_offerPrice.equalsIgnoreCase("0")) {
                    if (course.getCat_type() != null && course.getCat_type().equalsIgnoreCase("3")) {
                        this.mrpCutTV.setVisibility(8);
                    } else {
                        this.mrpCutTV.setVisibility(0);
                    }
                } else {
                    this.mrpCutTV.setVisibility(8);
                }
                spannable.setSpan(strikethroughSpan, 2, new String(course.getMrp()).length() + 2, 33);
                this.validityTextTV.setText(String.format("%s %s", TileDataAdapter.this.activity.getResources().getString(R.string.validity), course.getValidity(), Boolean.valueOf(course.getValidity().equalsIgnoreCase("0"))));
            }
            if (BuildConfig.FLAVOR.equalsIgnoreCase("onlineSkillIndia") && (TileDataAdapter.this.activity instanceof DashboardActivityTheme2)) {
                this.validityTextTV.setVisibility(8);
                this.price.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(Courselist courselist, View view) {
            if (SystemClock.elapsedRealtime() - TileDataAdapter.this.mLastClickTime < 1000) {
                return;
            }
            TileDataAdapter.this.mLastClickTime = SystemClock.elapsedRealtime();
            if ("1".equals("7")) {
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    Intent intent = new Intent(TileDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.COURSE_DETAILS_FOR_THEME7);
                    intent.putExtra(Const.COURSESLIST, courselist);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                    Helper.gotoActivity(intent, TileDataAdapter.this.activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(TileDataAdapter.this.activity, "", courselist.getMaintenanceText());
                return;
            }
            if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                Intent intent2 = new Intent(TileDataAdapter.this.activity, (Class<?>) CourseActivity.class);
                intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent2.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                intent2.putExtra(Const.COURSE_PARENT_ID, "");
                intent2.putExtra(Const.IS_COMBO, false);
                intent2.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                intent2.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                Helper.gotoActivity(intent2, TileDataAdapter.this.activity);
                return;
            }
            Helper.getCourseMaintanaceDialog(TileDataAdapter.this.activity, "", courselist.getMaintenanceText());
        }

        public void checkShowVisibility() {
            if (TileDataAdapter.this.utkashRoom == null || !TileDataAdapter.this.utkashRoom.getthemeSettingdao().is_setting_exit()) {
                return;
            }
            ThemeSettings themeSettingsData = TileDataAdapter.this.utkashRoom.getthemeSettingdao().data();
            TileDataAdapter.this.bottomSetting = (BottomSetting) new Gson().fromJson(themeSettingsData.getBottom(), BottomSetting.class);
        }
    }

    public boolean isEMIAvailable(CourseDetail courseDetail) {
        if (courseDetail == null || courseDetail.getData() == null || courseDetail.getData().getInstalment() == null || courseDetail.getData().getInstalment().getInstallment() == null || courseDetail.getData().getInstalment().getInstallment().isEmpty()) {
            return false;
        }
        return "2".equals(courseDetail.getData().getInstalment().getPayment_mode()) || "1".equals(courseDetail.getData().getInstalment().getPayment_mode());
    }

    private void handleBuyNowClick(final CourseDetail cousedetail) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.home.adapters.TileDataAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Helper.directPayment() && !TileDataAdapter.this.isEMIAvailable(cousedetail)) {
                        AppCompatActivity appCompatActivity = (AppCompatActivity) TileDataAdapter.this.activity;
                        if (appCompatActivity.getSupportFragmentManager().isStateSaved() || appCompatActivity.isFinishing() || appCompatActivity.isDestroyed()) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("test_data", "");
                        bundle.putString("test_id", "");
                        bundle.putString("parentCourseId", TileDataAdapter.this.parentCourseId);
                        bundle.putSerializable(Const.SINGLE_STUDY, cousedetail);
                        bundle.putString(Const.IS_BOOK, cousedetail.getData().getCourseDetail().getCat_type());
                        bundle.putString(Const.DELIVERY_CHARGE, cousedetail.getData().getCourseDetail().getDelivery_charge());
                        TileDataAdapter.this.purchaseBottomSheetFragment = InstantPurchase.INSTANCE.newInstance(TileDataAdapter.this.paymentGatewayListener, TileDataAdapter.this.paymentResultListener, false, bundle);
                        TileDataAdapter.this.purchaseBottomSheetFragment.show(((AppCompatActivity) TileDataAdapter.this.activity).getSupportFragmentManager(), "PurchaseBottomSheetFragment");
                        return;
                    }
                    CourseDetail courseDetail = cousedetail;
                    if (courseDetail != null && courseDetail.getData() != null && cousedetail.getData().getCourseDetail() != null && cousedetail.getData().getCourseDetail().getCat_type().equalsIgnoreCase("5")) {
                        Intent intent = new Intent(TileDataAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                        intent.putExtra("test_data", "");
                        intent.putExtra(Const.SINGLE_STUDY, cousedetail);
                        intent.putExtra("test_id", "0");
                        intent.putExtra(Const.IS_BOOK, cousedetail.getData().getCourseDetail().getCat_type());
                        intent.putExtra(Const.DELIVERY_CHARGE, cousedetail.getData().getCourseDetail().getDelivery_charge());
                        Helper.gotoActivity(intent, TileDataAdapter.this.activity);
                        return;
                    }
                    Intent intent2 = new Intent(TileDataAdapter.this.activity, (Class<?>) PurchaseActivity.class);
                    intent2.putExtra(Const.SINGLE_STUDY, cousedetail);
                    intent2.putExtra("test_id", "");
                    intent2.putExtra(Const.IS_BOOK, cousedetail.getData().getCourseDetail().getCat_type());
                    intent2.putExtra(Const.DELIVERY_CHARGE, cousedetail.getData().getCourseDetail().getDelivery_charge());
                    Helper.gotoActivity(intent2, TileDataAdapter.this.activity);
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

    public void openUrlInBrowser(Context context, String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        if (!context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "No browser found. Please install one.", 1).show();
        }
    }
}
