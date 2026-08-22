package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Courses.Lists;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class SubItemStudyAdapter extends RecyclerView.Adapter<SubItemHolder> {
    Activity context;
    ArrayList<Lists> listsArrayList;
    String type;

    public SubItemStudyAdapter(Activity activity, ArrayList<Lists> list, String type) {
        this.context = activity;
        this.listsArrayList = list;
        this.type = type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SubItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SubItemHolder(LayoutInflater.from(this.context).inflate(R.layout.exam_prep_subitem, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SubItemHolder holder, int position) {
        holder.subItemTV.setText(String.format("%s %s", this.listsArrayList.get(position).getCount(), this.type));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listsArrayList.size();
    }

    public class SubItemHolder extends RecyclerView.ViewHolder {
        TextView subItemTV;

        public SubItemHolder(View itemView) {
            super(itemView);
            this.subItemTV = (TextView) itemView.findViewById(R.id.row1_1TV);
        }
    }
}
