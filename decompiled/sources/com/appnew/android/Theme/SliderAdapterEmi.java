package com.appnew.android.Theme;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.ExpiredEmiModel;
import com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.eduteria.app.app.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class SliderAdapterEmi extends RecyclerView.Adapter<SliderViewHolder> {
    private Context activity;
    private RecyclerView emiRecyclerView;
    private LinearLayout linearLayout;
    private List<ExpiredEmiModel> sliderItems;
    private UtkashRoom utkashRoom;

    SliderAdapterEmi(List<ExpiredEmiModel> sliderItems, Context activity, RecyclerView emiRecyclerView) {
        this.sliderItems = sliderItems;
        this.activity = activity;
        this.emiRecyclerView = emiRecyclerView;
        this.utkashRoom = UtkashRoom.getAppDatabase(activity);
    }

    SliderAdapterEmi(List<ExpiredEmiModel> sliderItems, Context activity, RecyclerView emiRecyclerView, LinearLayout linearLayout) {
        this.sliderItems = sliderItems;
        this.activity = activity;
        this.emiRecyclerView = emiRecyclerView;
        this.utkashRoom = UtkashRoom.getAppDatabase(activity);
        this.linearLayout = linearLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SliderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item_container, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SliderViewHolder holder, int position) {
        holder.setDetails(this.sliderItems.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private TextView btnCancel;
        private TextView txtTitle;

        SliderViewHolder(View itemView) {
            super(itemView);
            this.btnCancel = (TextView) itemView.findViewById(R.id.btnCancel);
            this.txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        }

        void setDetails(final ExpiredEmiModel sliderItems, final int position) {
            this.txtTitle.setText("Your next EMI due on " + SliderAdapterEmi.this.getdate(Long.parseLong(String.valueOf(Long.parseLong(sliderItems.getExpiry_date()) * 1000))));
            this.txtTitle.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.SliderAdapterEmi$SliderViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setDetails$0(sliderItems, view);
                }
            });
            this.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.SliderAdapterEmi$SliderViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setDetails$1(sliderItems, position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setDetails$0(ExpiredEmiModel expiredEmiModel, View view) {
            Intent intent = new Intent(SliderAdapterEmi.this.activity, (Class<?>) InstallmentDetailActivity.class);
            intent.putExtra("order_data", expiredEmiModel);
            intent.putExtra("fromWhere", Const.ExpireEmi);
            intent.putExtra("invoiceUrl", expiredEmiModel.getUrl());
            intent.putExtra("description_img", expiredEmiModel.getDescHeaderImage());
            intent.putExtra("is_subscription", expiredEmiModel.getIs_subscription());
            intent.putExtra("type", Const.Installment);
            SliderAdapterEmi.this.activity.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setDetails$1(ExpiredEmiModel expiredEmiModel, int i, View view) {
            expiredEmiModel.setCheck_for_expiry(String.valueOf(Long.valueOf(Long.parseLong(String.valueOf(System.currentTimeMillis())) + 86400000)));
            SliderAdapterEmi.this.utkashRoom.getExpiredCancelledDao().addCancelledData(expiredEmiModel);
            SliderAdapterEmi.this.removeAt(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAt(int position) {
        if (this.sliderItems.size() == 1) {
            this.sliderItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, this.sliderItems.size());
            this.emiRecyclerView.setVisibility(8);
            if (this.linearLayout != null) {
                int i = (int) (new DisplayMetrics().scaledDensity * 110.0f);
                ViewGroup.LayoutParams layoutParams = this.linearLayout.getLayoutParams();
                layoutParams.height = i;
                layoutParams.width = -2;
                this.linearLayout.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.sliderItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.sliderItems.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getdate(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp))));
    }
}
