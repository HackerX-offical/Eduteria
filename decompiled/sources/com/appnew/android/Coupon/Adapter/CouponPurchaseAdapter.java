package com.appnew.android.Coupon.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Coupon.Models.CoursesCoupon;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.OnCouponClicked;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class CouponPurchaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    public List<CoursesCoupon> couponArrayList;
    OnCouponClicked couponClicked;
    EditText coupon_edt;

    public CouponPurchaseAdapter(Context context, ArrayList<CoursesCoupon> couponArrayList, EditText coupon_edt, OnCouponClicked couponClicked) {
        this.context = context;
        this.coupon_edt = coupon_edt;
        this.couponArrayList = couponArrayList;
        this.couponClicked = couponClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StreamHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_purchase_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder sholder, final int position) {
        try {
            final StreamHolder streamHolder = (StreamHolder) sholder;
            streamHolder.applyButton.setPaintFlags(streamHolder.applyButton.getPaintFlags() | 8);
            streamHolder.price.setText(this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getCoupon_title());
            streamHolder.days.setText("Maximum discount: " + Constants.currencyType + this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getDiscount());
            if (this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getCoupon_type().equalsIgnoreCase("1")) {
                streamHolder.descCoupon.setText("Apply Code " + this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getCoupon_title() + " And Save " + Constants.currencyType + this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getDiscount() + " - Your Discount Awaits!");
            } else if (!TextUtils.isEmpty(this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getMax_discount()) && !this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getMax_discount().equalsIgnoreCase("0")) {
                streamHolder.descCoupon.setText("Apply Code " + this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getCoupon_title() + " And Save " + this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getCoupon_value() + "% Off Up To " + Constants.currencyType + this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getMax_discount() + " - Your Discount Awaits!");
            } else {
                streamHolder.descCoupon.setText("Apply Code " + this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getCoupon_title() + " And Save " + this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).getCoupon().getCoupon_value() + "%  - Your Discount Awaits!");
            }
            if (this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).isIs_select()) {
                streamHolder.applyButton.setText(this.context.getString(R.string.coupon_applied_10_off));
                streamHolder.applyButton.setTextColor(this.context.getColor(R.color.correct));
                streamHolder.price.setTextColor(this.context.getResources().getColor(R.color.black));
                streamHolder.days.setTextColor(this.context.getResources().getColor(R.color.correct));
            } else {
                streamHolder.applyButton.setText(this.context.getString(R.string.apply_coupon));
                streamHolder.applyButton.setTextColor(this.context.getColor(R.color.colorPrimary));
                streamHolder.price.setTextColor(this.context.getColor(R.color.black));
                streamHolder.days.setTextColor(this.context.getColor(R.color.correct));
            }
            streamHolder.card_RL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Coupon.Adapter.CouponPurchaseAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$0(streamHolder);
                }
            }));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(StreamHolder streamHolder) {
        for (int i = 0; i < this.couponArrayList.size(); i++) {
            if (this.couponArrayList.get(i).isIs_select()) {
                this.couponArrayList.get(i).setIs_select(false);
            }
        }
        this.couponArrayList.get(streamHolder.getAbsoluteAdapterPosition()).setIs_select(true);
        this.coupon_edt.setText("");
        this.coupon_edt.setHint("Enter Coupon Code");
        notifyDataSetChanged();
        OnCouponClicked onCouponClicked = this.couponClicked;
        if (onCouponClicked == null) {
            return null;
        }
        onCouponClicked.onCouponClicked(this.coupon_edt);
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<CoursesCoupon> list = this.couponArrayList;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.couponArrayList.size();
    }

    public class StreamHolder extends RecyclerView.ViewHolder {
        TextView applyButton;
        RelativeLayout card_RL;
        TextView days;
        TextView descCoupon;
        TextView price;

        public StreamHolder(View itemView) {
            super(itemView);
            this.days = (TextView) itemView.findViewById(R.id.days);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.descCoupon = (TextView) itemView.findViewById(R.id.descCoupon);
            this.applyButton = (TextView) itemView.findViewById(R.id.applyButton);
            this.card_RL = (RelativeLayout) itemView.findViewById(R.id.card_RL);
        }
    }
}
