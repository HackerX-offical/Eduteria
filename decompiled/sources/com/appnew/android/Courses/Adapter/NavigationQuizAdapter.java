package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.amulyakhare.textdrawable.TextDrawable;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Model.Courses.quiz.Questions;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class NavigationQuizAdapter extends RecyclerView.Adapter<NavigationHolder> {
    Context context;
    QuizModel quiz;
    ArrayList<Questions> resultTestSeriesArrayList;

    public NavigationQuizAdapter(Activity quizActivity, QuizModel quiz) {
        this.context = quizActivity;
        this.quiz = quiz;
    }

    public NavigationQuizAdapter(Activity quizActivity, ArrayList<Questions> resultTestSeriesArrayList) {
        this.context = quizActivity;
        this.resultTestSeriesArrayList = resultTestSeriesArrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NavigationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NavigationHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_navigation, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final NavigationHolder holder, final int position) {
        int i = position + 1;
        TextDrawable textDrawableBuildRound = TextDrawable.builder().buildRound(String.valueOf(i), this.context.getResources().getColor(R.color.greayrefcode_dark));
        TextDrawable textDrawableBuildRound2 = TextDrawable.builder().buildRound(String.valueOf(i), this.context.getResources().getColor(R.color.theme_and_header_color));
        QuizModel quizModel = this.quiz;
        if (quizModel != null) {
            if (quizModel.getQuestion_bank().get(position).isAnswered()) {
                holder.counterIV.setImageDrawable(textDrawableBuildRound2);
            } else {
                holder.counterIV.setImageDrawable(textDrawableBuildRound);
            }
        } else if (this.resultTestSeriesArrayList.get(position).isAnswered()) {
            holder.counterIV.setImageDrawable(textDrawableBuildRound2);
        } else {
            holder.counterIV.setImageDrawable(textDrawableBuildRound);
        }
        holder.counterIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.NavigationQuizAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((QuizActivity) NavigationQuizAdapter.this.context).counterCallbackListener(position);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        QuizModel quizModel = this.quiz;
        if (quizModel != null) {
            return quizModel.getQuestion_bank().size();
        }
        return this.resultTestSeriesArrayList.size();
    }

    public class NavigationHolder extends RecyclerView.ViewHolder {
        ImageView counterIV;

        public NavigationHolder(View itemView) {
            super(itemView);
            this.counterIV = (ImageView) itemView.findViewById(R.id.counterIV);
        }
    }
}
