package com.appnew.android.testmodule.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.CreateTest.Activity.TestCreateActivity;
import com.appnew.android.Webview.RevisionTest;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.interfaces.NumberPadOnClick;
import com.appnew.android.testmodule.model.Question;
import com.appnew.android.testmodule.model.QuestionDump;
import com.appnew.android.testmodule.model.Questions2;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MyRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Activity activity;
    private int itemLayout;
    private List<ViewModel> items;
    private NumberPadOnClick numberPadOnClick;
    public List<Question> questionBankList;
    public List<Questions2> questionBankList1;
    public List<QuestionDump> questionDumpList;
    private int selectedPosition;
    boolean solution;
    String type;

    public MyRecyclerAdapter(List<Question> questionBankList, Activity activity, List<ViewModel> items, int itemLayout, NumberPadOnClick numberPadOnClick) {
        this.solution = false;
        this.items = items;
        this.itemLayout = itemLayout;
        this.activity = activity;
        this.numberPadOnClick = numberPadOnClick;
        this.questionBankList = questionBankList;
    }

    public MyRecyclerAdapter(List<Question> questionBankList, List<QuestionDump> questionDumpList, Activity activity, List<ViewModel> items, int itemLayout, NumberPadOnClick numberPadOnClick) {
        this.solution = false;
        this.items = items;
        this.itemLayout = itemLayout;
        this.activity = activity;
        this.numberPadOnClick = numberPadOnClick;
        this.questionBankList = questionBankList;
        this.questionDumpList = questionDumpList;
    }

    public MyRecyclerAdapter(List<Questions2> questionBankList, Activity activity, int itemLayout, NumberPadOnClick numberPadOnClick, boolean solution) {
        this.itemLayout = itemLayout;
        this.activity = activity;
        this.numberPadOnClick = numberPadOnClick;
        this.questionBankList1 = questionBankList;
        this.solution = solution;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(this.itemLayout, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        List<Question> list;
        if (this.solution) {
            holder.imageIVText.setVisibility(0);
            holder.text.setText(String.valueOf(position + 1));
            Activity activity = this.activity;
            if ((activity instanceof TestBaseActivity) || (activity instanceof RevisionTest) || (activity instanceof TestCreateActivity)) {
                holder.imageIVText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.adapter.MyRecyclerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MyRecyclerAdapter.this.numberPadOnClick.sendOnclickInd(position);
                        if (MyRecyclerAdapter.this.activity instanceof RevisionTest) {
                            ((RevisionTest) MyRecyclerAdapter.this.activity).changeTextOnNextAndPrevButton();
                        } else if (MyRecyclerAdapter.this.activity instanceof TestCreateActivity) {
                            ((TestCreateActivity) MyRecyclerAdapter.this.activity).changeTextOnNextAndPrevButton();
                        } else {
                            ((TestBaseActivity) MyRecyclerAdapter.this.activity).changeTextOnNextAndPrevButton();
                        }
                    }
                });
                if (this.selectedPosition == position) {
                    holder.imageIVText.setImageResource(R.drawable.bg_selected_question);
                    holder.text.setTextColor(this.activity.getResources().getColor(R.color.blue));
                } else if (this.questionBankList1.get(position).getState().equalsIgnoreCase("not_visited")) {
                    holder.imageIVText.setImageResource(R.drawable.circle_skip);
                    holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
                } else if (this.questionBankList1.get(position).getState().equalsIgnoreCase("unanswered")) {
                    holder.imageIVText.setImageResource(R.drawable.circle_unanswered);
                    holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
                } else if (!this.questionBankList1.get(position).getState().equalsIgnoreCase("not_visited") && !this.questionBankList1.get(position).getState().equalsIgnoreCase("unanswered")) {
                    holder.imageIVText.setImageResource(R.drawable.circle_answered);
                    holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
                }
                if (this.questionBankList1.get(position).getState().equalsIgnoreCase("marked_for_review")) {
                    holder.rlselected.setVisibility(0);
                    holder.imageIVText.setImageResource(R.drawable.bg_selected_question);
                    holder.text.setTextColor(this.activity.getResources().getColor(R.color.blue));
                    return;
                } else if (this.questionBankList1.get(position).getState().equalsIgnoreCase("bookmarked")) {
                    holder.rlselected.setVisibility(0);
                    return;
                } else {
                    holder.rlselected.setVisibility(8);
                    return;
                }
            }
            holder.imageIVText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.adapter.MyRecyclerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0(position, view);
                }
            });
            if (this.selectedPosition == position) {
                holder.imageIVText.setImageResource(R.drawable.circle_unanswered);
                holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
                return;
            } else {
                holder.imageIVText.setImageResource(R.drawable.circle_answered);
                holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
                return;
            }
        }
        Activity activity2 = this.activity;
        if ((activity2 instanceof TestBaseActivity) && !TextUtils.isEmpty(((TestBaseActivity) activity2).basicInfo.getAllow_user_move()) && ((TestBaseActivity) this.activity).basicInfo.getAllow_user_move().equalsIgnoreCase("0")) {
            if (!TextUtils.isEmpty(TestBaseActivity.currentSectionIdforTest) && (list = this.questionBankList) != null && !list.isEmpty() && !TextUtils.isEmpty(this.questionBankList.get(position).getSubjectId()) && TestBaseActivity.currentSectionIdforTest.equals(this.questionBankList.get(position).getSubjectId())) {
                holder.itemView.setVisibility(0);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            } else {
                holder.itemView.setVisibility(8);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
        }
        holder.imageIVText.setVisibility(0);
        holder.text.setText(String.valueOf(position + 1));
        Activity activity3 = this.activity;
        if ((activity3 instanceof TestBaseActivity) || (activity3 instanceof RevisionTest) || (activity3 instanceof TestCreateActivity)) {
            holder.imageIVText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.adapter.MyRecyclerAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MyRecyclerAdapter.this.numberPadOnClick.sendOnclickInd(position);
                    if (MyRecyclerAdapter.this.activity instanceof RevisionTest) {
                        ((RevisionTest) MyRecyclerAdapter.this.activity).changeTextOnNextAndPrevButton();
                    } else if (MyRecyclerAdapter.this.activity instanceof TestCreateActivity) {
                        ((TestCreateActivity) MyRecyclerAdapter.this.activity).changeTextOnNextAndPrevButton();
                    } else {
                        ((TestBaseActivity) MyRecyclerAdapter.this.activity).changeTextOnNextAndPrevButton();
                    }
                }
            });
            if (this.selectedPosition == position) {
                holder.imageIVText.setImageResource(R.drawable.bg_selected_question);
                holder.text.setTextColor(this.activity.getResources().getColor(R.color.blue));
            } else if (this.questionBankList.get(position).getAnswerPosttion() == -1) {
                holder.imageIVText.setImageResource(R.drawable.circle_skip);
                holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
            } else if (this.questionBankList.get(position).getAnswerPosttion() == 0) {
                holder.imageIVText.setImageResource(R.drawable.circle_unanswered);
                holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
            } else if (this.questionBankList.get(position).getAnswerPosttion() != -1 && this.questionBankList.get(position).getAnswerPosttion() != 0) {
                holder.imageIVText.setImageResource(R.drawable.circle_answered);
                holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
            }
            if (this.questionBankList.get(position).isMarkForReview() && this.questionBankList.get(position).getAnswerPosttion() != -1 && this.questionBankList.get(position).getAnswerPosttion() != 0) {
                holder.rlselected.setVisibility(0);
                holder.imageIVText.setImageResource(R.drawable.circle_answered);
                holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
                return;
            } else if (this.questionBankList.get(position).isMarkForReview()) {
                holder.rlselected.setVisibility(0);
                holder.imageIVText.setImageResource(R.drawable.bg_selected_question);
                holder.text.setTextColor(this.activity.getResources().getColor(R.color.blue));
                return;
            } else if (this.questionBankList.get(position).isIssaveMarkForReview()) {
                holder.rlselected.setVisibility(0);
                return;
            } else {
                holder.rlselected.setVisibility(8);
                return;
            }
        }
        holder.imageIVText.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.adapter.MyRecyclerAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyRecyclerAdapter.this.numberPadOnClick.sendOnclickInd(position);
            }
        });
        if (this.selectedPosition == position) {
            holder.imageIVText.setImageResource(R.drawable.circle_unanswered);
            holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
        } else {
            holder.imageIVText.setImageResource(R.drawable.circle_answered);
            holder.text.setTextColor(this.activity.getResources().getColor(R.color.white));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
        this.numberPadOnClick.sendOnclickInd(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.solution) {
            return this.questionBankList1.size();
        }
        return this.questionBankList.size();
    }

    public void setSelectePosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    public int getselectePosition() {
        return this.selectedPosition;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout countLL;
        public ImageView imageIVText;
        public TextView questionTV;
        private RelativeLayout rlselected;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            this.countLL = (LinearLayout) itemView.findViewById(R.id.countLL);
            this.imageIVText = (ImageView) itemView.findViewById(R.id.imageIVText);
            this.text = (TextView) itemView.findViewById(R.id.myImageViewText);
            this.rlselected = (RelativeLayout) itemView.findViewById(R.id.rl_selected);
            this.questionTV = (TextView) itemView.findViewById(R.id.questionTV);
        }
    }
}
