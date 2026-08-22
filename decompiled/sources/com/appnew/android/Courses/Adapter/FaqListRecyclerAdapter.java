package com.appnew.android.Courses.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.FAQs.FaqData;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class FaqListRecyclerAdapter extends RecyclerView.Adapter<FaqListHolder> {
    ArrayList<FaqData> faqData;
    int positions;

    public FaqListRecyclerAdapter(ArrayList<FaqData> faqData, int position) {
        this.positions = position;
        this.faqData = faqData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FaqListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FaqListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_faq_data, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.faqData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(FaqListHolder holder, int position) {
        holder.setSingleFAQData(this.faqData.get(position).getQuestion(), position, this.faqData.get(position).getDescription());
    }

    public class FaqListHolder extends RecyclerView.ViewHolder {
        private TextView answertextTV;
        private ImageView dropDownIV;
        private LinearLayout mainLL;
        private LinearLayout parentLL;
        private TextView questiontextTV;

        public FaqListHolder(View itemView) {
            super(itemView);
            this.questiontextTV = (TextView) itemView.findViewById(R.id.questiontextTV);
            this.dropDownIV = (ImageView) itemView.findViewById(R.id.dropDownIV);
            this.answertextTV = (TextView) itemView.findViewById(R.id.answertextTV);
            this.mainLL = (LinearLayout) itemView.findViewById(R.id.lowerViewItem);
            this.parentLL = (LinearLayout) itemView.findViewById(R.id.parentLL);
        }

        public void setSingleFAQData(String singlefaqdata, int pos, String answersData) {
            this.parentLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.FaqListRecyclerAdapter$FaqListHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setSingleFAQData$0(view);
                }
            });
            this.questiontextTV.setText(singlefaqdata);
            this.answertextTV.setText(answersData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSingleFAQData$0(View view) {
            if (this.mainLL.getVisibility() == 8) {
                this.mainLL.setVisibility(0);
                this.dropDownIV.setImageResource(R.mipmap.up_black);
            } else {
                this.mainLL.setVisibility(8);
                this.dropDownIV.setImageResource(R.mipmap.down_black);
            }
        }
    }
}
