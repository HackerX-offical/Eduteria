package com.appnew.android.Theme.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.home.interfaces.IOnCourseClickListener;
import com.appnew.android.table.CourseTypeMasterTable;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class IBTPracticeRV2Adapter extends RecyclerView.Adapter<PracticeViewHolder> {
    Context context;
    ArrayList<CourseTypeMasterTable> coursesDataArrayList;
    Fragment fragment;
    IOnCourseClickListener iOnCourseClickListener;

    public IBTPracticeRV2Adapter(Activity activity, ArrayList<CourseTypeMasterTable> coursesDataArrayList, Fragment fragment, IOnCourseClickListener iOnCourseClickListener) {
        this.context = activity;
        this.coursesDataArrayList = coursesDataArrayList;
        this.iOnCourseClickListener = iOnCourseClickListener;
        this.fragment = fragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PracticeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PracticeViewHolder(LayoutInflater.from(this.context).inflate(R.layout.ibt_practice_single_blue_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PracticeViewHolder holder, int position) {
        holder.setData(this.coursesDataArrayList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.coursesDataArrayList.size();
    }

    public class PracticeViewHolder extends RecyclerView.ViewHolder {
        LinearLayout MainLL;
        ImageView image;
        CircleImageView tabIV;
        TextView textView;
        TextView title;

        public PracticeViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.ibt_single_blue_item_tv);
            this.image = (ImageView) itemView.findViewById(R.id.itemIV);
            this.MainLL = (LinearLayout) itemView.findViewById(R.id.MainLL);
            this.tabIV = (CircleImageView) itemView.findViewById(R.id.tabIV);
            this.title = (TextView) itemView.findViewById(R.id.title);
        }

        public void setData(final CourseTypeMasterTable subStreamResponse, final int pos) {
            this.textView.setText(subStreamResponse.getName());
            this.title.setText(subStreamResponse.getName());
            if (subStreamResponse.getIcon() != null) {
                Glide.with(IBTPracticeRV2Adapter.this.context).load(subStreamResponse.getIcon()).placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder).into(this.image);
                Glide.with(IBTPracticeRV2Adapter.this.context).load(subStreamResponse.getIcon()).placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder).into(this.tabIV);
            } else {
                this.image.setImageResource(R.mipmap.placeholder);
                this.tabIV.setImageResource(R.mipmap.placeholder);
            }
            this.MainLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.IBTPracticeRV2Adapter.PracticeViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    IBTPracticeRV2Adapter.this.iOnCourseClickListener.onCourseItemClick(IBTPracticeRV2Adapter.this.coursesDataArrayList.get(pos), pos);
                }
            });
        }
    }
}
