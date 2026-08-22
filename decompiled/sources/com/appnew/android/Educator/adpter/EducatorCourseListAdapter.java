package com.appnew.android.Educator.adpter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Educator.adpter.EducatorCourseListAdapter;
import com.appnew.android.Educator.model.EduClassCourseItem;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Payment.PurchaseActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.home.liveclasses.Datum;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class EducatorCourseListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NetworkCall.MyNetworkCallBack {
    Activity activity;
    private ArrayList<Courselist> courseList;
    private ArrayList<EduClassCourseItem> eduClassCourseItemsList;
    private ArrayList<Datum> liveClass;
    private String viewType;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        return null;
    }

    public EducatorCourseListAdapter(Activity activity, ArrayList<Courselist> courselists, String viewType) {
        this.activity = activity;
        this.courseList = courselists;
        this.viewType = viewType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CourseViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.edu_course_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CourseViewHolder) holder).bind(this.activity, this.courseList.get(position), holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.courseList.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView addToLib;
        TextView buyNowId;
        TextView courseTitle;
        TextView discount;
        RelativeLayout discountRL;
        TextView exploreId;
        TextView freeCourseText;
        ImageView imageBanner;
        TextView originalPrice;
        LinearLayout paidCourseLay;
        TextView price;
        FrameLayout soldOutImg;
        TextView validity;

        public CourseViewHolder(View itemView) {
            super(itemView);
            this.imageBanner = (ImageView) itemView.findViewById(R.id.imageBanner);
            this.courseTitle = (TextView) itemView.findViewById(R.id.courseTitle);
            this.validity = (TextView) itemView.findViewById(R.id.validity);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.discount = (TextView) itemView.findViewById(R.id.discount);
            this.originalPrice = (TextView) itemView.findViewById(R.id.originalPrice);
            this.discountRL = (RelativeLayout) itemView.findViewById(R.id.discountRL);
            this.paidCourseLay = (LinearLayout) itemView.findViewById(R.id.paidCourseLay);
            this.exploreId = (TextView) itemView.findViewById(R.id.exploreId);
            this.buyNowId = (TextView) itemView.findViewById(R.id.buyNowId);
            this.addToLib = (TextView) itemView.findViewById(R.id.addToLib);
            this.freeCourseText = (TextView) itemView.findViewById(R.id.freeCourseText);
            this.soldOutImg = (FrameLayout) itemView.findViewById(R.id.soldOutImg);
        }

        public void bind(final Activity activity, final Courselist courselist, RecyclerView.ViewHolder holder, int position) {
            this.courseTitle.setText(courselist.getTitle());
            Helper.applyPrimaryColorLight(activity, this.exploreId, 10.0f, R.drawable.discount_light_bg);
            Helper.applyPrimaryColorLight(activity, this.discountRL, 6.0f, R.drawable.discount_bg);
            Glide.with(this.itemView.getContext()).load(courselist.getCover_image()).placeholder(R.mipmap.square_placeholder_new).into(this.imageBanner);
            final boolean z = courselist.getExtra_json() != null && "1".equalsIgnoreCase(courselist.getExtra_json().getSold_out());
            final boolean z2 = courselist.getIs_purchased() != null && "1".equalsIgnoreCase(courselist.getIs_purchased());
            this.soldOutImg.setVisibility(8);
            this.buyNowId.setEnabled(true);
            this.buyNowId.setText(R.string.buy_now);
            this.buyNowId.setBackgroundResource(R.drawable.discount_solid_bg);
            int i = !TextUtils.isEmpty(courselist.getDiscount()) ? (int) Double.parseDouble(courselist.getDiscount()) : 0;
            if (courselist.getCourseSp() != null && courselist.getCourseSp().equalsIgnoreCase("0")) {
                this.price.setText(activity.getResources().getString(R.string.free));
                this.price.setTextAlignment(2);
                this.validity.setText(courselist.getValidity());
                this.originalPrice.setVisibility(8);
                this.discount.setVisibility(8);
                this.buyNowId.setVisibility(8);
            } else if (courselist.getCourseSp() != null && courselist.getCourseSp().equalsIgnoreCase(courselist.getMrp())) {
                this.originalPrice.setVisibility(8);
                this.discount.setVisibility(8);
                this.validity.setText(courselist.getValidity());
                this.price.setText("₹" + courselist.getCourseSp());
                this.originalPrice.setText("₹" + courselist.getMrp() + "/-");
                this.discount.setVisibility(0);
                setDiscount(this.discount, i);
                if (z2) {
                    this.buyNowId.setVisibility(8);
                } else {
                    this.buyNowId.setVisibility(0);
                }
            } else {
                this.validity.setText(courselist.getValidity());
                this.price.setText("₹" + courselist.getCourseSp());
                this.originalPrice.setText("₹" + courselist.getMrp());
                TextView textView = this.originalPrice;
                textView.setPaintFlags(textView.getPaintFlags() | 16);
                setDiscount(this.discount, i);
                if (z2) {
                    this.buyNowId.setVisibility(8);
                } else {
                    this.buyNowId.setVisibility(0);
                }
            }
            if (courselist.getMrp().equalsIgnoreCase("") || courselist.getMrp().equalsIgnoreCase("0")) {
                this.discountRL.setVisibility(8);
            }
            this.buyNowId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.EducatorCourseListAdapter$CourseViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EducatorCourseListAdapter.CourseViewHolder.lambda$bind$0(z, z2, activity, courselist, view);
                }
            });
            this.exploreId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.EducatorCourseListAdapter$CourseViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EducatorCourseListAdapter.CourseViewHolder.lambda$bind$1(activity, courselist, view);
                }
            });
            if (z && !z2) {
                this.buyNowId.setVisibility(0);
                this.buyNowId.setEnabled(true);
                this.buyNowId.setText(R.string.sold_out);
                this.buyNowId.setBackgroundResource(R.drawable.sold_out_solid);
                FrameLayout frameLayout = this.soldOutImg;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                    return;
                }
                return;
            }
            this.buyNowId.setEnabled(true);
            this.buyNowId.setText(R.string.buy_now);
            this.buyNowId.setBackgroundResource(R.drawable.discount_solid_bg);
            FrameLayout frameLayout2 = this.soldOutImg;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }

        static /* synthetic */ void lambda$bind$0(boolean z, boolean z2, Activity activity, Courselist courselist, View view) {
            if (z && !z2) {
                Toast.makeText(activity, R.string.sold_out_msg, 0).show();
                return;
            }
            if (!Helper.isConnected(activity)) {
                Helper.showInternetToast(activity);
                return;
            }
            SingleStudy.parentCourseId = "";
            Intent intent = new Intent(activity, (Class<?>) PurchaseActivity.class);
            intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
            intent.putExtra("mainCourseId", courselist.getId());
            intent.putExtra(Const.IS_BOOK, courselist.getCat_type());
            intent.putExtra(Const.DELIVERY_CHARGE, courselist.getDelivery_charge());
            Helper.gotoActivity(intent, activity);
        }

        static /* synthetic */ void lambda$bind$1(Activity activity, Courselist courselist, View view) {
            if (Helper.isNetworkConnected(activity)) {
                if (TextUtils.isEmpty(courselist.getMaintenanceText())) {
                    Intent intent = new Intent(activity, (Class<?>) CourseActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent.putExtra(Const.COURSE_ID_MAIN, courselist.getId());
                    intent.putExtra(Const.CONTENT_TYPE_1, courselist.getContent_type());
                    intent.putExtra(Const.COURSE_PARENT_ID, "");
                    intent.putExtra(Const.IS_COMBO, false);
                    intent.putExtra(AnalyticsConstants.course_name, courselist.getTitle());
                    intent.putExtra(Const.COMBO_ID, courselist.getCombo_course_ids());
                    Helper.gotoActivity(intent, activity);
                    return;
                }
                Helper.getCourseMaintanaceDialog(activity, "", courselist.getMaintenanceText());
                return;
            }
            Helper.showInternetToast(activity);
        }

        private void setDiscount(TextView discount, int a2) {
            if (a2 == 0) {
                discount.setVisibility(8);
            } else {
                discount.setText(String.format("%s", a2 + "% off"));
            }
        }
    }
}
