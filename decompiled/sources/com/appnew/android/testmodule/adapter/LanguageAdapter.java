package com.appnew.android.testmodule.adapter;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.testmodule.model.TestBasicInst;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class LanguageAdapter extends RecyclerView.Adapter<ViewHolder> {
    Activity activity;
    ArrayList<TestBasicInst.Multi_description> answerCount;

    public LanguageAdapter(Activity activity, ArrayList<TestBasicInst.Multi_description> answerCount) {
        this.activity = activity;
        this.answerCount = answerCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_languagelist, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.languageText.setText(String.valueOf(position + 1) + ". " + ((Object) Html.fromHtml(this.answerCount.get(position).getDescription())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.answerCount.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView languageText;

        public ViewHolder(View itemView) {
            super(itemView);
            this.languageText = (TextView) itemView.findViewById(R.id.languageText);
        }
    }
}
