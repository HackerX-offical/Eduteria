package com.appnew.android.testmodule.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.amulyakhare.textdrawable.TextDrawable;
import com.appnew.android.BuildConfig;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.testmodule.model.TopTenList;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RankAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<TopTenList> topTenLists;

    public RankAdapter(Context context, List<TopTenList> topTenLists) {
        new ArrayList();
        this.context = context;
        this.topTenLists = topTenLists;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rank, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (this.topTenLists.get(position).getName() != null) {
            if (BuildConfig.FLAVOR.equalsIgnoreCase("Clatprep")) {
                holder.textname.setText(this.topTenLists.get(position).getUserId());
            } else {
                holder.textname.setText(this.topTenLists.get(position).getName());
            }
        }
        holder.textrank.setText(this.context.getResources().getString(R.string.rank_) + " " + this.topTenLists.get(position).getRank());
        holder.mark.setText(this.context.getResources().getString(R.string.marks_) + " " + this.topTenLists.get(holder.getAbsoluteAdapterPosition()).getMarks());
        if (this.topTenLists.get(position).getUserId().equalsIgnoreCase(MakeMyExam.getUserId())) {
            holder.tv_your_rank.setVisibility(0);
        } else {
            holder.tv_your_rank.setVisibility(4);
        }
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
        if (!TextUtils.isEmpty(this.topTenLists.get(position).getProfilePicture())) {
            holder.imgthumb.setVisibility(0);
            holder.imageIVText.setVisibility(8);
            Glide.with(this.context).load(this.topTenLists.get(position).getProfilePicture()).into(holder.imgthumb);
            return;
        }
        TextDrawable textDrawableGetDrawable = Helper.GetDrawable(this.topTenLists.get(position).getName(), this.context, this.topTenLists.get(position).getUserId());
        if (textDrawableGetDrawable != null) {
            holder.imgthumb.setVisibility(8);
            holder.imageIVText.setVisibility(0);
            holder.imageIVText.setImageDrawable(textDrawableGetDrawable);
        } else {
            holder.imgthumb.setVisibility(0);
            holder.imageIVText.setVisibility(8);
            holder.imgthumb.setImageResource(R.mipmap.default_pic);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.topTenLists.size();
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
