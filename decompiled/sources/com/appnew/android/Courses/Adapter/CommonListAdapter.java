package com.appnew.android.Courses.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Model.Courses.FAQ;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.HelperProgress;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CommonListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<FAQ> faqArrayList;
    LayoutInflater layoutInflater;
    ArrayList<ResultTestSeries> resultTestSeriesArrayList;
    String type;

    public CommonListAdapter(Context activity, String type, ArrayList<FAQ> faqArrayList) {
        this.context = activity;
        this.type = type;
        this.faqArrayList = faqArrayList;
        this.layoutInflater = (LayoutInflater) activity.getApplicationContext().getSystemService("layout_inflater");
    }

    public CommonListAdapter(Context activity, ArrayList<ResultTestSeries> resultTestSeriesArrayList) {
        this.context = activity;
        this.resultTestSeriesArrayList = resultTestSeriesArrayList;
        this.layoutInflater = (LayoutInflater) activity.getApplicationContext().getSystemService("layout_inflater");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        String str = this.type;
        return (str == null || !str.equals(Const.FAQ)) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_faq, parent, false));
        }
        if (viewType == 1) {
            return new LeaderboardHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_leaderboard, parent, false));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder sholder, final int position) {
        String str = this.type;
        if (str != null && str.equals(Const.FAQ)) {
            ((ViewHolder) sholder).setSingleFAQData(this.faqArrayList.get(position));
            return;
        }
        LeaderboardHolder leaderboardHolder = (LeaderboardHolder) sholder;
        leaderboardHolder.nameTV.setText(this.resultTestSeriesArrayList.get(position).getTest_series_name());
        Helper.setThumbnailImage(this.context, this.resultTestSeriesArrayList.get(position).getImage(), this.context.getResources().getDrawable(R.mipmap.course_placeholder), leaderboardHolder.imageIV);
        leaderboardHolder.timeTV.setText(HelperProgress.getFormatDateMillis(Long.valueOf(Long.parseLong(this.resultTestSeriesArrayList.get(position).getCreation_time()))));
        leaderboardHolder.seeResultLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.CommonListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(CommonListAdapter.this.context, (Class<?>) QuizActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.RESULT_SCREEN);
                intent.putExtra("status", CommonListAdapter.this.resultTestSeriesArrayList.get(position).getId());
                intent.putExtra(Const.PRACTICE, "");
                CommonListAdapter.this.context.startActivity(intent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (getItemViewType(0) == 0) {
            return this.faqArrayList.size();
        }
        return this.resultTestSeriesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView answertextTV;
        private View dividerId;
        private ImageView dropDownIV;
        private LinearLayout mainLL;
        private LinearLayout parentLL;
        private TextView questiontextTV;

        public ViewHolder(View itemView) {
            super(itemView);
            this.questiontextTV = (TextView) itemView.findViewById(R.id.questiontextTV);
            this.dropDownIV = (ImageView) itemView.findViewById(R.id.dropDownIV);
            this.answertextTV = (TextView) itemView.findViewById(R.id.answertextTV);
            this.mainLL = (LinearLayout) itemView.findViewById(R.id.lowerViewItem);
            this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
            this.dividerId = itemView.findViewById(R.id.dividerV);
        }

        public void setSingleFAQData(FAQ singlefaqdata) {
            this.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.CommonListAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ViewHolder.this.mainLL.getVisibility() == 8) {
                        ViewHolder.this.mainLL.setVisibility(0);
                        ViewHolder.this.dividerId.setVisibility(0);
                        ViewHolder.this.dropDownIV.setImageResource(R.mipmap.up_black);
                    } else {
                        ViewHolder.this.mainLL.setVisibility(8);
                        ViewHolder.this.dividerId.setVisibility(8);
                        ViewHolder.this.dropDownIV.setImageResource(R.mipmap.down_black);
                    }
                }
            });
            this.questiontextTV.setText(singlefaqdata.getQuestion());
            this.answertextTV.setText(singlefaqdata.getDescription());
        }
    }

    public class LeaderboardHolder extends RecyclerView.ViewHolder {
        ImageView imageIV;
        TextView nameTV;
        RelativeLayout seeResultLL;
        TextView timeTV;

        public LeaderboardHolder(View itemView) {
            super(itemView);
            this.nameTV = (TextView) itemView.findViewById(R.id.nameTV);
            this.seeResultLL = (RelativeLayout) itemView.findViewById(R.id.seeResultLL);
            this.imageIV = (ImageView) itemView.findViewById(R.id.imageIV);
            this.timeTV = (TextView) itemView.findViewById(R.id.timeTV);
        }
    }
}
