package com.appnew.android.player;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.PollLeaderboard;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RankAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    boolean isForAll;
    List<PollLeaderboard> studentList;

    public RankAdapter(Context context, List<PollLeaderboard> studentList, boolean isForAll) {
        this.context = context;
        this.studentList = studentList;
        this.isForAll = isForAll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.list_rank, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        PollLeaderboard pollLeaderboard = this.studentList.get(position);
        if (!TextUtils.isEmpty(pollLeaderboard.getUser_id()) && pollLeaderboard.getUser_id().equalsIgnoreCase(MakeMyExam.getUserId())) {
            holder.mainRL.setBackground(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.shape1, this.context.getTheme()));
            holder.rank.setTextColor(ResourcesCompat.getColor(this.context.getResources(), R.color.white, this.context.getTheme()));
            holder.name.setTextColor(ResourcesCompat.getColor(this.context.getResources(), R.color.white, this.context.getTheme()));
            holder.time.setTextColor(ResourcesCompat.getColor(this.context.getResources(), R.color.white, this.context.getTheme()));
        } else {
            holder.mainRL.setBackground(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.shape2, this.context.getTheme()));
            holder.rank.setTextColor(ResourcesCompat.getColor(this.context.getResources(), R.color.colorPrimary, this.context.getTheme()));
            holder.name.setTextColor(ResourcesCompat.getColor(this.context.getResources(), R.color.colorPrimary, this.context.getTheme()));
            holder.time.setTextColor(ResourcesCompat.getColor(this.context.getResources(), R.color.colorPrimary, this.context.getTheme()));
        }
        holder.name.setText(!TextUtils.isEmpty(pollLeaderboard.getName()) ? pollLeaderboard.getName() : "N/A");
        holder.rank.setText(!TextUtils.isEmpty(pollLeaderboard.getRank()) ? pollLeaderboard.getRank() : "N/A");
        if (this.isForAll) {
            holder.time.setText(TextUtils.isEmpty(pollLeaderboard.getCorrect_count()) ? "N/A" : pollLeaderboard.getCorrect_count());
        } else if (!TextUtils.isEmpty(pollLeaderboard.getTimetaken()) && TextUtils.isDigitsOnly(pollLeaderboard.getTimetaken())) {
            holder.time.setText(Helper.concerter(Long.parseLong(pollLeaderboard.getTimetaken()) * 1000));
        } else {
            holder.time.setText("N/A");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        RelativeLayout mainRL;
        TextView name;
        TextView rank;
        TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mainRL = (RelativeLayout) itemView.findViewById(R.id.mainRL);
            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.rank = (TextView) itemView.findViewById(R.id.rank);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}
