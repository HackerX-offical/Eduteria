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
import com.appnew.android.Coupon.Activity.CouponActivity;
import com.appnew.android.Coupon.Activity.EligibleCoursesActivity;
import com.appnew.android.Coupon.Models.Available;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class CouponTypeAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<Available> availables;
    Context context;
    int view_type;

    public CouponTypeAdapter(Context context, List<Available> availables, int view_type) {
        this.context = context;
        this.availables = availables;
        this.view_type = view_type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.available_coupon_items, parent, false));
        }
        if (viewType == 1) {
            return new RedeemedViewHolder(LayoutInflater.from(this.context).inflate(R.layout.redeemed_coupon_items, parent, false));
        }
        if (viewType != 2) {
            return null;
        }
        return new ExpiredViewHolder(LayoutInflater.from(this.context).inflate(R.layout.expired_coupon_items, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, int pos) {
        final int absoluteAdapterPosition = holder.getAbsoluteAdapterPosition();
        int itemViewType = getItemViewType(absoluteAdapterPosition);
        if (itemViewType == 0) {
            Glide.with(this.context).load(this.availables.get(absoluteAdapterPosition).getImage()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.book_logo).error(R.drawable.book_logo)).into(holder.ibt_single_vd_iv);
            holder.coupon_name.setText(this.availables.get(absoluteAdapterPosition).getCoupon_title());
            if (this.availables.get(absoluteAdapterPosition).getCoupon_type().equalsIgnoreCase("2")) {
                holder.coupon_discount.setText(this.availables.get(absoluteAdapterPosition).getCoupon_value() + this.context.getResources().getString(R.string.off_uptp) + "₹ " + this.availables.get(absoluteAdapterPosition).getMax_discount());
            } else {
                holder.coupon_discount.setText(this.availables.get(absoluteAdapterPosition).getCoupon_value() + this.context.getResources().getString(R.string.iNR_off));
            }
            holder.coupon_validity.setText(this.context.getResources().getString(R.string.valid_till) + new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(this.availables.get(absoluteAdapterPosition).getEnd()) * 1000)));
            if (this.availables.get(absoluteAdapterPosition).getCourses() != null) {
                if (this.availables.get(absoluteAdapterPosition).getCoupon_for().equalsIgnoreCase("1")) {
                    holder.eligible_course.setText(this.context.getResources().getString(R.string.eligible_for_all_courses));
                } else {
                    holder.eligible_course.setText(this.availables.get(absoluteAdapterPosition).getCourses().size() + " - " + this.context.getResources().getString(R.string.eligible_courses));
                }
            }
            holder.eligible_course.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Coupon.Adapter.CouponTypeAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$0(holder, absoluteAdapterPosition);
                }
            }));
            return;
        }
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                return;
            }
            ExpiredViewHolder expiredViewHolder = (ExpiredViewHolder) holder;
            Glide.with(this.context).load(this.availables.get(absoluteAdapterPosition).getImage()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.book_logo).error(R.drawable.book_logo)).into(expiredViewHolder.ibt_single_vd_iv);
            expiredViewHolder.coupon_name.setText(this.availables.get(absoluteAdapterPosition).getCoupon_title());
            if (this.availables.get(absoluteAdapterPosition).getCoupon_type().equalsIgnoreCase("2")) {
                expiredViewHolder.coupon_discount.setText(this.availables.get(absoluteAdapterPosition).getCoupon_value() + this.context.getResources().getString(R.string.off_uptp) + "₹ " + this.availables.get(absoluteAdapterPosition).getMax_discount());
            } else {
                expiredViewHolder.coupon_discount.setText(this.availables.get(absoluteAdapterPosition).getCoupon_value() + this.context.getResources().getString(R.string.iNR_off));
            }
            expiredViewHolder.coupon_expired.setText(this.context.getResources().getString(R.string.expired_) + new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(Long.parseLong(this.availables.get(absoluteAdapterPosition).getEnd()) * 1000)));
            return;
        }
        RedeemedViewHolder redeemedViewHolder = (RedeemedViewHolder) holder;
        Glide.with(this.context).load(this.availables.get(absoluteAdapterPosition).getImage()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.book_logo).error(R.drawable.book_logo)).into(redeemedViewHolder.ibt_single_vd_iv);
        redeemedViewHolder.coupon_name.setText(this.availables.get(absoluteAdapterPosition).getCoupon_title());
        if (this.availables.get(absoluteAdapterPosition).getCoupon_type().equalsIgnoreCase("2")) {
            redeemedViewHolder.coupon_discount.setText(this.availables.get(absoluteAdapterPosition).getCoupon_value() + this.context.getResources().getString(R.string.off_uptp) + "₹ " + this.availables.get(absoluteAdapterPosition).getMax_discount());
        } else {
            redeemedViewHolder.coupon_discount.setText(this.availables.get(absoluteAdapterPosition).getCoupon_value() + this.context.getResources().getString(R.string.iNR_off));
        }
        if (this.availables.get(absoluteAdapterPosition).getRedeem_json() != null && this.availables.get(absoluteAdapterPosition).getRedeem_json().size() > 0) {
            redeemedViewHolder.coupon_redeemed.setText(this.context.getResources().getString(R.string.redeemed_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US).format(new Date(this.availables.get(absoluteAdapterPosition).getRedeem_json().get(0).getCreated() * 1000)));
            redeemedViewHolder.course_name.setVisibility(0);
            redeemedViewHolder.course_name.setText(this.availables.get(absoluteAdapterPosition).getRedeem_json().get(0).getC_title());
            return;
        }
        redeemedViewHolder.course_name.setVisibility(8);
        redeemedViewHolder.coupon_redeemed.setText(this.context.getResources().getString(R.string.redeemed_on));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(ViewHolder viewHolder, int i) {
        if (viewHolder.eligible_course.getText().toString().equalsIgnoreCase("Eligible For All Courses")) {
            ((CouponActivity) this.context).finish();
            Toast.makeText(this.context, "Eligible For All Courses", 0).show();
            return null;
        }
        if (this.availables.get(i).getExceed_message().equalsIgnoreCase("")) {
            if (this.availables.get(i).getCourses() != null && this.availables.get(i).getCourses().size() > 0) {
                Intent intent = new Intent(this.context, (Class<?>) EligibleCoursesActivity.class);
                intent.putExtra(Const.ELIGIBLE_COURSES, (Serializable) this.availables.get(i).getCourses());
                intent.putExtra("discount", viewHolder.coupon_discount.getText().toString());
                intent.putExtra("id", this.availables.get(i).getId());
                Helper.gotoActivity(intent, (Activity) this.context);
                return null;
            }
            Toast.makeText(this.context, "Sorry. No Eligible Courses With This Coupon", 0).show();
            return null;
        }
        Toast.makeText(this.context, "" + this.availables.get(i).getExceed_message(), 0).show();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        int i = this.view_type;
        if (i == 1) {
            return 0;
        }
        return i == 2 ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.availables.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView coupon_discount;
        TextView coupon_name;
        TextView coupon_validity;
        TextView eligible_course;
        RoundedImageView ibt_single_vd_iv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.ibt_single_vd_iv = (RoundedImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.coupon_name = (TextView) itemView.findViewById(R.id.coupon_name);
            this.coupon_discount = (TextView) itemView.findViewById(R.id.coupon_discount);
            this.coupon_validity = (TextView) itemView.findViewById(R.id.coupon_validity);
            this.eligible_course = (TextView) itemView.findViewById(R.id.eligible_course);
        }
    }

    public class RedeemedViewHolder extends ViewHolder {
        TextView coupon_discount;
        TextView coupon_name;
        TextView coupon_redeemed;
        TextView course_name;
        RoundedImageView ibt_single_vd_iv;

        public RedeemedViewHolder(View itemView) {
            super(itemView);
            this.ibt_single_vd_iv = (RoundedImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.coupon_name = (TextView) itemView.findViewById(R.id.coupon_name);
            this.coupon_discount = (TextView) itemView.findViewById(R.id.coupon_discount);
            this.coupon_redeemed = (TextView) itemView.findViewById(R.id.coupon_redeemed);
            this.course_name = (TextView) itemView.findViewById(R.id.course_name);
        }
    }

    public class ExpiredViewHolder extends ViewHolder {
        TextView coupon_discount;
        TextView coupon_expired;
        TextView coupon_name;
        RoundedImageView ibt_single_vd_iv;

        public ExpiredViewHolder(View itemView) {
            super(itemView);
            this.ibt_single_vd_iv = (RoundedImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
            this.coupon_name = (TextView) itemView.findViewById(R.id.coupon_name);
            this.coupon_discount = (TextView) itemView.findViewById(R.id.coupon_discount);
            this.coupon_expired = (TextView) itemView.findViewById(R.id.coupon_expired);
        }
    }
}
