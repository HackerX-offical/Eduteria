package com.appnew.android.Educator.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Educator.EducatorsModel;
import com.appnew.android.Utils.Helper;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class HomeEduAdapter extends RecyclerView.Adapter<HomeEduViewHolder> {
    private Context context;
    private ArrayList<EducatorsModel.Datum> educatorList;
    private onEducatorClickListener listener;

    public interface onEducatorClickListener {
        void onEducatorItemClick(EducatorsModel.Datum educatorData);
    }

    public HomeEduAdapter(Context context, ArrayList<EducatorsModel.Datum> educatorList, onEducatorClickListener listener) {
        this.context = context;
        this.educatorList = educatorList;
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HomeEduViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeEduViewHolder(LayoutInflater.from(this.context).inflate(R.layout.home_our_educators_item, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(HomeEduViewHolder holder, int position) {
        final EducatorsModel.Datum datum = this.educatorList.get(position);
        Helper.applyPrimaryColorLight(this.context, holder.educatorExpRel, 6.0f, R.drawable.educator_bg);
        Glide.with(this.context).load(datum.getProfilePicture()).placeholder(R.drawable.user_pic).into(holder.educatorProfileImage);
        holder.educatorFullName.setText(datum.getUsername());
        holder.teachingExp.setText(datum.getExperience());
        holder.educatorsCard.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Educator.adpter.HomeEduAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                HomeEduAdapter.this.listener.onEducatorItemClick(datum);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<EducatorsModel.Datum> arrayList = this.educatorList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class HomeEduViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout educatorExpRel;
        TextView educatorFullName;
        ImageView educatorProfileImage;
        RelativeLayout educatorsCard;
        TextView teachingExp;

        public HomeEduViewHolder(View itemView) {
            super(itemView);
            this.educatorProfileImage = (ImageView) itemView.findViewById(R.id.educatorProfileImage);
            this.educatorFullName = (TextView) itemView.findViewById(R.id.educatorFullName);
            this.teachingExp = (TextView) itemView.findViewById(R.id.teachingExp);
            this.educatorsCard = (RelativeLayout) itemView.findViewById(R.id.educatorsCard);
            this.educatorExpRel = (RelativeLayout) itemView.findViewById(R.id.educatorExpRel);
        }
    }
}
