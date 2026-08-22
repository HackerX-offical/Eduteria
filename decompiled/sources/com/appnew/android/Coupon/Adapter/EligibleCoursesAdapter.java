package com.appnew.android.Coupon.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Coupon.Activity.CouponPurchaseActivity;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class EligibleCoursesAdapter extends RecyclerView.Adapter<EligibleCourseHolder> {
    Context context;
    List<CoursesCoupon> coursesCouponList;
    String discount;
    String id;

    public EligibleCoursesAdapter(Context context, List<CoursesCoupon> coursesCouponList, String discount, String id) {
        this.context = context;
        this.coursesCouponList = coursesCouponList;
        this.discount = discount;
        this.id = id;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EligibleCourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EligibleCourseHolder(LayoutInflater.from(this.context).inflate(R.layout.eligible_courses_item, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EligibleCourseHolder holder, int pos) {
        final int absoluteAdapterPosition = holder.getAbsoluteAdapterPosition();
        Glide.with(this.context).load(this.coursesCouponList.get(absoluteAdapterPosition).getCover_image()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder).error(R.mipmap.course_placeholder)).into(holder.ibt_single_vd_iv);
        holder.coupon_name.setText(this.coursesCouponList.get(absoluteAdapterPosition).getTitle());
        holder.coupon_discount.setText(this.discount);
        if (this.coursesCouponList.get(absoluteAdapterPosition).getIs_purchased() != null && this.coursesCouponList.get(absoluteAdapterPosition).getIs_purchased().equalsIgnoreCase("1")) {
            holder.buy_now_btn.setTextColor(this.context.getResources().getColor(R.color.colorWhite));
            holder.buy_now_btn.setBackground(this.context.getResources().getDrawable(R.drawable.green_is_purchase));
            holder.buy_now_btn.setText(this.context.getResources().getString(R.string.purchased_));
        } else {
            holder.buy_now_btn.setBackground(this.context.getResources().getDrawable(R.drawable.background_coupon_black));
            holder.buy_now_btn.setTextColor(this.context.getResources().getColor(R.color.white));
            holder.buy_now_btn.setText(SharedPreference.getInstance().getString(Const.ENROLL_NOW).equalsIgnoreCase("1") ? "Enroll Now" : this.context.getResources().getString(R.string.buy_now));
        }
        holder.buy_now_btn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Coupon.Adapter.EligibleCoursesAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$0(absoluteAdapterPosition);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(int i) {
        if (this.coursesCouponList.get(i).getIs_purchased() != null && this.coursesCouponList.get(i).getIs_purchased().equalsIgnoreCase("1")) {
            Context context = this.context;
            Toast.makeText(context, context.getResources().getString(R.string.this_course_is_already_purchased_you_can_directly_access_to_my_library), 0).show();
            return null;
        }
        Intent intent = new Intent(this.context, (Class<?>) CouponPurchaseActivity.class);
        intent.putExtra(Const.COURSE_DATA, this.coursesCouponList.get(i));
        intent.putExtra("discount", this.discount);
        intent.putExtra("id", this.id);
        Helper.gotoActivity(intent, (Activity) this.context);
        ((Activity) this.context).finish();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.coursesCouponList.size();
    }

    public class EligibleCourseHolder extends RecyclerView.ViewHolder {
        TextView buy_now_btn;
        TextView coupon_discount;
        TextView coupon_name;
        RoundedImageView ibt_single_vd_iv;

        public EligibleCourseHolder(View itemView) {
            super(itemView);
            this.ibt_single_vd_iv = (RoundedImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.coupon_name = (TextView) itemView.findViewById(R.id.coupon_name);
            this.coupon_discount = (TextView) itemView.findViewById(R.id.coupon_discount);
            this.buy_now_btn = (TextView) itemView.findViewById(R.id.buy_now_btn);
        }
    }
}
