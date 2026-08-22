package com.appnew.android.testmodule.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Helper;
import com.appnew.android.testmodule.model.QuestionDump;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class AnswerListAdapter extends RecyclerView.Adapter<AnswerListViewHolder> {
    Activity activity;
    List<QuestionDump> answerCount;

    public AnswerListAdapter(Activity activity, List<QuestionDump> answerCount) {
        this.activity = activity;
        this.answerCount = answerCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AnswerListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AnswerListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item_answer_list, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AnswerListViewHolder answerListViewHolder, int position) {
        if (this.answerCount.get(position).getAnswer() != null) {
            if (this.answerCount.get(position).getAnswer().equals("")) {
                ImageView imageView = answerListViewHolder.imgAnswerCount;
                String strValueOf = String.valueOf(position + 1);
                Activity activity = this.activity;
                imageView.setImageDrawable(Helper.GetDrawableWithCustomColor(strValueOf, activity, activity.getResources().getColor(R.color.skipped)));
                return;
            }
            ImageView imageView2 = answerListViewHolder.imgAnswerCount;
            String strValueOf2 = String.valueOf(position + 1);
            Activity activity2 = this.activity;
            imageView2.setImageDrawable(Helper.GetDrawableWithCustomColor(strValueOf2, activity2, activity2.getResources().getColor(R.color.correct)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.answerCount.size();
    }

    public class AnswerListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAnswerCount;

        public AnswerListViewHolder(View itemView) {
            super(itemView);
            this.imgAnswerCount = (ImageView) itemView.findViewById(R.id.imgAnswerCount);
        }
    }
}
