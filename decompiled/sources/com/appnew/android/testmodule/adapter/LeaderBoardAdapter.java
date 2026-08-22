package com.appnew.android.testmodule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.TestReportModel.LeaderBoard;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class LeaderBoardAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<LeaderBoard> leaderBoards;

    public LeaderBoardAdapter(Context context, List<LeaderBoard> leaderBoards) {
        new ArrayList();
        this.context = context;
        this.leaderBoards = leaderBoards;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textname.setText("Student " + String.valueOf(position + 1));
        holder.textrank.setText(this.leaderBoards.get(position).getRank());
        holder.mark.setText(this.leaderBoards.get(position).getMarks());
        if (position == 0) {
            holder.rankLL.setBackground(this.context.getResources().getDrawable(R.drawable.background_rank_one));
            holder.imgSuccess.setVisibility(0);
        } else if (position == 1) {
            holder.rankLL.setBackground(this.context.getResources().getDrawable(R.drawable.background_rank_two));
            holder.imgSuccess.setVisibility(0);
        } else if (position == 2) {
            holder.rankLL.setBackground(this.context.getResources().getDrawable(R.drawable.background_rank_three));
            holder.imgSuccess.setVisibility(0);
        } else {
            holder.rankLL.setBackgroundColor(this.context.getResources().getColor(R.color.colorGray));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.leaderBoards.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageIVText;
        CircleImageView imgSuccess;
        CircleImageView imgthumb;
        TextView mark;
        LinearLayout rankLL;
        TextView textname;
        TextView textrank;
        TextView tv_your_rank;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tv_your_rank = (TextView) itemView.findViewById(R.id.tv_your_rank);
            this.imgthumb = (CircleImageView) itemView.findViewById(R.id.imgthumb);
            this.textname = (TextView) itemView.findViewById(R.id.textname);
            this.textrank = (TextView) itemView.findViewById(R.id.textrank);
            this.imageIVText = (ImageView) itemView.findViewById(R.id.imageIVText);
            this.mark = (TextView) itemView.findViewById(R.id.mark);
            this.rankLL = (LinearLayout) itemView.findViewById(R.id.rankLL);
            this.imgSuccess = (CircleImageView) itemView.findViewById(R.id.imgSuccess);
        }
    }
}
