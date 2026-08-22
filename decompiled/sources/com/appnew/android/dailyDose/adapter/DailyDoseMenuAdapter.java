package com.appnew.android.dailyDose.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Interfaces.IOnDailyDoseClickListener;
import com.appnew.android.table.CourseTypeMasterTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class DailyDoseMenuAdapter extends RecyclerView.Adapter<DailyDoseMenuHolder> {
    Activity activity;
    ArrayList<CourseTypeMasterTable> dailyDoseMenuArrayList;
    IOnDailyDoseClickListener iOnDailyDoseClickListener;

    public DailyDoseMenuAdapter(Activity activity, ArrayList<CourseTypeMasterTable> dailyDoseMenuArrayList, IOnDailyDoseClickListener iOnDailyDoseClickListener) {
        this.activity = activity;
        this.dailyDoseMenuArrayList = dailyDoseMenuArrayList;
        this.iOnDailyDoseClickListener = iOnDailyDoseClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DailyDoseMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DailyDoseMenuHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_dose_menu, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final DailyDoseMenuHolder holder, final int position) {
        holder.itemTitle.setText(this.dailyDoseMenuArrayList.get(position).getName());
        if (!TextUtils.isEmpty(this.dailyDoseMenuArrayList.get(position).getIcon())) {
            Glide.with(this.activity).load(this.dailyDoseMenuArrayList.get(position).getIcon()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.course_placeholder)).into(holder.imageView);
        }
        holder.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.dailyDose.adapter.DailyDoseMenuAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DailyDoseMenuAdapter.this.iOnDailyDoseClickListener.onDailyDoseClick(position);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dailyDoseMenuArrayList.size();
    }

    public class DailyDoseMenuHolder extends RecyclerView.ViewHolder {
        LinearLayout Linear_background;
        ImageView imageView;
        RelativeLayout imageplayerRL;
        TextView itemTitle;
        LinearLayout parentLL;
        View view1;

        public DailyDoseMenuHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.itemIV);
            this.itemTitle = (TextView) itemView.findViewById(R.id.itemTitleTV);
            this.imageplayerRL = (RelativeLayout) itemView.findViewById(R.id.imageplayerRL);
            this.Linear_background = (LinearLayout) itemView.findViewById(R.id.Linear_background);
            this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            this.view1 = itemView.findViewById(R.id.view1);
        }
    }
}
