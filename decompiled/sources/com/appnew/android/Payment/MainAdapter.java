package com.appnew.android.Payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.OnSingleClickListener;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class MainAdapter extends RecyclerView.Adapter<ViewHolder> {
    public ArrayList<String> arrayList;
    IOnViewDetailsClick iOnViewDetailsClick;
    ItemClickListener itemClickListener;
    public int selectedPosition;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position;
    }

    public MainAdapter(ArrayList<String> arrayList, int selectedPosition, ItemClickListener itemClickListener, IOnViewDetailsClick iOnViewDetailsClick) {
        this.arrayList = arrayList;
        this.selectedPosition = selectedPosition;
        this.itemClickListener = itemClickListener;
        this.iOnViewDetailsClick = iOnViewDetailsClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_installment_new, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.radioButton.setText(this.arrayList.get(position));
        holder.radioButton.setChecked(position == this.selectedPosition);
        holder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.Payment.MainAdapter.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b2) {
                if (b2) {
                    MainAdapter.this.selectedPosition = holder.getAbsoluteAdapterPosition();
                    MainAdapter.this.itemClickListener.onClick(holder.radioButton.getText().toString(), position);
                }
            }
        });
        holder.viewButton.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Payment.MainAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onBindViewHolder$0(position);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(int i) {
        this.iOnViewDetailsClick.onViewDetailsClick(i, this.arrayList.get(i), false);
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButton;
        TextView viewButton;

        public ViewHolder(View itemView) {
            super(itemView);
            this.radioButton = (RadioButton) itemView.findViewById(R.id.radio_button);
            this.viewButton = (TextView) itemView.findViewById(R.id.viewButton);
        }
    }
}
