package com.appnew.android.Courses.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.amulyakhare.textdrawable.TextDrawable;
import com.appnew.android.Courses.Activity.QuizActivity;
import com.appnew.android.Courses.Fragment.Quiz;
import com.appnew.android.Model.Courses.quiz.Questions;
import com.appnew.android.Model.Courses.quiz.QuizModel;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class IBTNavigationQuizAdapter extends RecyclerView.Adapter<NavigationHolder> {
    Context context;
    int currentQues;
    Quiz fragment;
    QuizModel quiz;
    ArrayList<Questions> resultTestSeriesArrayList;

    public IBTNavigationQuizAdapter(Activity quizActivity, QuizModel quiz, Fragment fragment) {
        this.context = quizActivity;
        this.quiz = quiz;
        if (fragment instanceof Quiz) {
            this.fragment = (Quiz) fragment;
        }
    }

    public IBTNavigationQuizAdapter(Activity quizActivity, ArrayList<Questions> resultTestSeriesArrayList) {
        this.context = quizActivity;
        this.resultTestSeriesArrayList = resultTestSeriesArrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NavigationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NavigationHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_navigation, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final NavigationHolder holder, final int position) {
        this.currentQues = this.fragment.currentQues;
        int i = position + 1;
        TextDrawable textDrawableBuildRound = TextDrawable.builder().beginConfig().withBorder(4).textColor(R.color.colorWhite).endConfig().buildRound(String.valueOf(i), this.context.getResources().getColor(R.color.white));
        TextDrawable textDrawableBuildRound2 = TextDrawable.builder().beginConfig().withBorder(4).textColor(R.color.darkestblue).endConfig().buildRound(String.valueOf(i), this.context.getResources().getColor(R.color.white));
        TextDrawable textDrawableBuildRound3 = TextDrawable.builder().buildRound(String.valueOf(i), this.context.getResources().getColor(R.color.green));
        TextDrawable textDrawableBuildRound4 = TextDrawable.builder().buildRound(String.valueOf(i), this.context.getResources().getColor(R.color.ibt_red));
        QuizModel quizModel = this.quiz;
        if (quizModel != null) {
            if (quizModel.getQuestion_bank().get(position).isAnswered()) {
                if (this.quiz.getQuestion_bank().get(position).getUser_answer().equals(this.quiz.getQuestion_bank().get(position).getAnswer())) {
                    holder.counterIV.setImageDrawable(textDrawableBuildRound3);
                } else {
                    holder.counterIV.setImageDrawable(textDrawableBuildRound4);
                }
            } else if (position == this.currentQues) {
                holder.counterIV.setImageDrawable(textDrawableBuildRound2);
                holder.itemView.setBackground(this.context.getResources().getDrawable(R.drawable.circle_blue_outline_bg));
            } else {
                holder.counterIV.setImageDrawable(textDrawableBuildRound);
                holder.itemView.setBackground(null);
            }
        } else if (quizModel.getQuestion_bank().get(position).isAnswered()) {
            if (this.quiz.getQuestion_bank().get(position).getUser_answer().equals(this.quiz.getQuestion_bank().get(position).getAnswer())) {
                holder.counterIV.setImageDrawable(textDrawableBuildRound3);
            } else {
                holder.counterIV.setImageDrawable(textDrawableBuildRound4);
            }
        } else if (position == this.currentQues) {
            holder.counterIV.setImageDrawable(textDrawableBuildRound2);
        } else {
            holder.counterIV.setImageDrawable(textDrawableBuildRound);
        }
        holder.counterIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.IBTNavigationQuizAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((QuizActivity) IBTNavigationQuizAdapter.this.context).IBTcounterCallbackListener(position);
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
            setIsRecyclable(false);
        }
    }
}
