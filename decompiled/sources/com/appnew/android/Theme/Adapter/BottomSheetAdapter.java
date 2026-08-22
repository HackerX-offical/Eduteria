package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.table.MasterCat;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class BottomSheetAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<MasterCat> arrayList;
    Context context;

    public BottomSheetAdapter(Context context, List<MasterCat> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.stream_selection_bottom_sheet_item, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv.setText(this.arrayList.get(position).getCat());
        if (SharedPreference.getInstance().getString("catName").equalsIgnoreCase(this.arrayList.get(position).getCat())) {
            holder.streamCB.setChecked(true);
            ((DashboardActivityTheme7) this.context).setMasterCatData(this.arrayList.get(position).getCat(), 0);
        }
        holder.streamCB.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.BottomSheetAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ((DashboardActivityTheme7) BottomSheetAdapter.this.context).changeInterface.dismiss();
                ((DashboardActivityTheme7) BottomSheetAdapter.this.context).id = BottomSheetAdapter.this.arrayList.get(holder.getAbsoluteAdapterPosition()).getId();
                SharedPreference.getInstance().putString("sub_cat_id", BottomSheetAdapter.this.arrayList.get(holder.getAbsoluteAdapterPosition()).getId());
                ((DashboardActivityTheme7) BottomSheetAdapter.this.context).setMasterCatData(BottomSheetAdapter.this.arrayList.get(holder.getAbsoluteAdapterPosition()).getCat(), 0);
            }
        });
        holder.parentRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.BottomSheetAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ((DashboardActivityTheme7) BottomSheetAdapter.this.context).changeInterface.dismiss();
                ((DashboardActivityTheme7) BottomSheetAdapter.this.context).id = BottomSheetAdapter.this.arrayList.get(holder.getAbsoluteAdapterPosition()).getId();
                SharedPreference.getInstance().putString("sub_cat_id", BottomSheetAdapter.this.arrayList.get(holder.getAbsoluteAdapterPosition()).getId());
                ((DashboardActivityTheme7) BottomSheetAdapter.this.context).setMasterCatData(BottomSheetAdapter.this.arrayList.get(holder.getAbsoluteAdapterPosition()).getCat(), 0);
                ((DashboardActivityTheme7) BottomSheetAdapter.this.context).refreshApiFromDownloads();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout parentRL;
        public CheckBox streamCB;
        public TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.streamText);
            this.parentRL = (RelativeLayout) itemView.findViewById(R.id.parentRL);
            this.streamCB = (CheckBox) itemView.findViewById(R.id.streamCB);
        }
    }
}
