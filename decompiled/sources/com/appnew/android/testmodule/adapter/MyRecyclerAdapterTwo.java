package com.appnew.android.testmodule.adapter;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.CreateTest.Activity.TestCreateActivity;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Webview.RevisionTest;
import com.appnew.android.testmodule.activity.TestBaseActivity;
import com.appnew.android.testmodule.interfaces.NumberPadOnClick;
import com.appnew.android.testmodule.model.Question;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class MyRecyclerAdapterTwo extends RecyclerView.Adapter<ViewHolder> {
    private Activity activity;
    private int itemLayout;
    private List<ViewModel> items;
    private NumberPadOnClick numberPadOnClick;
    public List<Question> questionBankList;
    String sectionId = "";
    String sectionName = "";
    private int selectedPosition;
    String type;

    public MyRecyclerAdapterTwo(List<Question> questionBankList, Activity activity, List<ViewModel> items, int itemLayout, NumberPadOnClick numberPadOnClick, String type) {
        this.items = items;
        this.itemLayout = itemLayout;
        this.activity = activity;
        this.numberPadOnClick = numberPadOnClick;
        this.questionBankList = questionBankList;
        this.type = type;
        setSectionNames();
    }

    private void setSectionNames() {
        List<Question> list = this.questionBankList;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i = 0;
        String sectionId = this.questionBankList.get(0).getSectionId();
        this.questionBankList.get(0).setSectionName("Section " + Helper.getColumnName(0));
        for (int i2 = 1; i2 < this.questionBankList.size(); i2++) {
            if (!this.questionBankList.get(i2).getSectionId().equalsIgnoreCase(sectionId)) {
                sectionId = this.questionBankList.get(i2).getSectionId();
                i++;
                this.questionBankList.get(i2).setSectionName("Section " + Helper.getColumnName(i));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(this.itemLayout, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.imageIVText.setVisibility(0);
        holder.text.setText(String.valueOf(position + 1));
        if (this.questionBankList.get(position).getQuestion() != null) {
            String.valueOf(Html.fromHtml(this.questionBankList.get(position).getQuestion().replaceAll("<img.+?>", "")));
            if (this.type.equalsIgnoreCase("1")) {
                holder.sectionText.setVisibility(0);
                holder.sectionText.setText(this.questionBankList.get(position).getSectionName());
                holder.questionTV.setVisibility(0);
                if (this.questionBankList.get(position).getFont_type().equalsIgnoreCase("1")) {
                    String question = this.questionBankList.get(position).getQuestion();
                    holder.questionTV.setVisibility(8);
                    holder.webview_questionTV.setVisibility(0);
                    Helper.testOptionFont(holder.webview_questionTV, question, this.questionBankList.get(position).getFont_type());
                } else if (this.questionBankList.get(position).getFont_type().equalsIgnoreCase("2")) {
                    String question2 = this.questionBankList.get(position).getQuestion();
                    holder.questionTV.setVisibility(8);
                    holder.webview_questionTV.setVisibility(0);
                    Helper.testOptionFont(holder.webview_questionTV, question2, this.questionBankList.get(position).getFont_type());
                } else {
                    String question3 = this.questionBankList.get(position).getQuestion();
                    holder.questionTV.setVisibility(8);
                    holder.webview_questionTV.setVisibility(0);
                    Helper.TestWebHTMLLoad(holder.webview_questionTV, question3);
                }
            } else {
                holder.questionTV.setVisibility(8);
            }
        }
        holder.parentLLTestpad.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.adapter.MyRecyclerAdapterTwo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyRecyclerAdapterTwo.this.numberPadOnClick.sendOnclickInd(position);
                if ((MyRecyclerAdapterTwo.this.activity instanceof RevisionTest) || (MyRecyclerAdapterTwo.this.activity instanceof TestBaseActivity) || (MyRecyclerAdapterTwo.this.activity instanceof TestCreateActivity)) {
                    if (MyRecyclerAdapterTwo.this.activity instanceof RevisionTest) {
                        ((RevisionTest) MyRecyclerAdapterTwo.this.activity).changeTextOnNextAndPrevButton();
                    } else if (MyRecyclerAdapterTwo.this.activity instanceof TestCreateActivity) {
                        ((TestCreateActivity) MyRecyclerAdapterTwo.this.activity).changeTextOnNextAndPrevButton();
                    } else {
                        ((TestBaseActivity) MyRecyclerAdapterTwo.this.activity).changeTextOnNextAndPrevButton();
                    }
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
        } else if (this.questionBankList.get(position).isMarkForReview()) {
            holder.imageIVText.setImageResource(R.drawable.bg_selected_question);
            holder.text.setTextColor(this.activity.getResources().getColor(R.color.blue));
            holder.rlselected.setVisibility(0);
        } else if (this.questionBankList.get(position).isIssaveMarkForReview()) {
            holder.rlselected.setVisibility(0);
        } else {
            holder.rlselected.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.questionBankList.size();
    }

    public void setSelectePosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public int getselectePosition() {
        return this.selectedPosition;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageIVText;
        LinearLayout parentLLTestpad;
        public TextView questionTV;
        private RelativeLayout rlselected;
        public TextView sectionText;
        public TextView text;
        ClickableWebView webview_questionTV;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageIVText = (ImageView) itemView.findViewById(R.id.imageIVText);
            this.text = (TextView) itemView.findViewById(R.id.myImageViewText);
            this.rlselected = (RelativeLayout) itemView.findViewById(R.id.rl_selected);
            this.questionTV = (TextView) itemView.findViewById(R.id.questionTV);
            this.webview_questionTV = (ClickableWebView) itemView.findViewById(R.id.webview_questionTV);
            this.parentLLTestpad = (LinearLayout) itemView.findViewById(R.id.parentLLTestpad);
            this.sectionText = (TextView) itemView.findViewById(R.id.sectionText);
        }
    }
}
