package com.appnew.android.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.ExtendValidity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class ExtendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private BottomSheetDialog bottomSheetDialog;
    Context context;
    public List<ExtendValidity> planlist;

    public ExtendAdapter(Context context, List<ExtendValidity> planlist, BottomSheetDialog bottomSheetDialog) {
        this.context = context;
        this.planlist = planlist;
        this.bottomSheetDialog = bottomSheetDialog;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StreamHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.topup_list_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder sholder, final int position) {
        try {
            final StreamHolder streamHolder = (StreamHolder) sholder;
            streamHolder.price.setText(Constants.currencyType + " " + this.planlist.get(streamHolder.getAbsoluteAdapterPosition()).getPrice() + ".00/-");
            streamHolder.days.setText(this.context.getResources().getString(R.string.for_) + this.planlist.get(streamHolder.getAbsoluteAdapterPosition()).getValidity() + " days");
            if (this.planlist.get(streamHolder.getAbsoluteAdapterPosition()).isIs_select()) {
                streamHolder.selected.setImageResource(R.mipmap.topup_selected);
                streamHolder.price.setTextColor(this.context.getResources().getColor(R.color.white, null));
                streamHolder.days.setTextColor(this.context.getResources().getColor(R.color.white, null));
                streamHolder.select_plan.setImageResource(R.drawable.radio_select_plan);
            } else {
                streamHolder.selected.setImageResource(R.mipmap.topup_default);
                streamHolder.days.setTextColor(this.context.getResources().getColor(R.color.shadowMsgInput, null));
                streamHolder.price.setTextColor(this.context.getResources().getColor(R.color.shadowMsgInput, null));
                streamHolder.select_plan.setImageResource(R.drawable.radio_deselct_plan);
            }
            streamHolder.layout_select.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.home.adapters.ExtendAdapter$$ExternalSyntheticLambda0
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
        for (int i = 0; i < this.planlist.size(); i++) {
            if (this.planlist.get(i).isIs_select()) {
                this.planlist.get(i).setIs_select(false);
            }
        }
        this.planlist.get(streamHolder.getAbsoluteAdapterPosition()).setIs_select(true);
        notifyDataSetChanged();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ExtendValidity> list = this.planlist;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.planlist.size();
    }

    public class StreamHolder extends RecyclerView.ViewHolder {
        TextView days;
        RelativeLayout layout_select;
        TextView price;
        ImageView select_plan;
        ImageView selected;

        public StreamHolder(View itemView) {
            super(itemView);
            this.days = (TextView) itemView.findViewById(R.id.days);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.select_plan = (ImageView) itemView.findViewById(R.id.select_plan);
            this.selected = (ImageView) itemView.findViewById(R.id.selected);
            this.layout_select = (RelativeLayout) itemView.findViewById(R.id.layout_select);
        }
    }
}
