package com.appnew.android.Login.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Response.Registration.SubStreamResponse;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class SubCategoryExamsAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    ArrayList<SubStreamResponse> specializationResponseArrayList;

    public SubCategoryExamsAdapter(Context activity, ArrayList<SubStreamResponse> specializationResponseArrayList) {
        this.context = activity;
        this.specializationResponseArrayList = specializationResponseArrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.exams_subcategory_selection_ver, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.title.setText(this.specializationResponseArrayList.get(position).getText_name());
        holder.imageView.setImageDrawable(this.context.getResources().getDrawable(com.appnew.android.R.drawable.bank_exams));
        holder.parent.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Adapter.SubCategoryExamsAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SharedPreference.getInstance().putString(Const.SUB_CAT, SubCategoryExamsAdapter.this.specializationResponseArrayList.get(position).getId());
                Intent intent = new Intent(SubCategoryExamsAdapter.this.context, Helper.setLoginCatActivity());
                intent.putExtra(Const.FRAG_TYPE, Const.INTRO);
                intent.putExtra(Const.SUB_CAT, SubCategoryExamsAdapter.this.specializationResponseArrayList.get(position).getText_name());
                SubCategoryExamsAdapter.this.context.startActivity(intent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.specializationResponseArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        LinearLayout parent;
        TextView subTitle;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.examsCategoryIV);
            this.title = (TextView) itemView.findViewById(R.id.examsCategoryTitleTV);
            this.subTitle = (TextView) itemView.findViewById(R.id.examsCategorySubtitleTV);
            this.parent = (LinearLayout) itemView.findViewById(R.id.examsCategoryMainLL);
        }
    }
}
