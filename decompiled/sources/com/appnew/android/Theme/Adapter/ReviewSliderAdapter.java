package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.ZoomModel.ReviewData;
import com.appnew.android.table.BannerListTable;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ReviewSliderAdapter extends RecyclerView.Adapter<ReviewSliderAdapterViewHolder> {
    private final List<ReviewData> ReviewData;
    BannerClick bannerClick;
    Context context;

    public interface BannerClick {
        void BannerClickItem(BannerListTable bannerItem);
    }

    public ReviewSliderAdapter(Context context, List<ReviewData> ReviewData) {
        this.ReviewData = ReviewData;
        this.context = context;
    }

    public ReviewSliderAdapter(Context context, List<ReviewData> ReviewData, BannerClick bannerClick) {
        this.ReviewData = ReviewData;
        this.context = context;
        this.bannerClick = bannerClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ReviewSliderAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_review_new, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new ReviewSliderAdapterViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ReviewSliderAdapterViewHolder viewHolder, final int position) {
        viewHolder.nameTV.setText(this.ReviewData.get(position).getName());
        viewHolder.descriptionTV.setText(this.ReviewData.get(position).getMessage());
        viewHolder.ratingBar.setRating(Float.parseFloat(this.ReviewData.get(position).getRating()));
        Glide.with(this.context).load(this.ReviewData.get(position).getProfile_picture()).placeholder(com.appnew.android.R.drawable.user_profile).into(viewHolder.profileImg);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.ReviewData.size();
    }

    static class ReviewSliderAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTV;
        TextView nameTV;
        CircleImageView profileImg;
        RatingBar ratingBar;

        public ReviewSliderAdapterViewHolder(View itemView) {
            super(itemView);
            this.nameTV = (TextView) itemView.findViewById(R.id.nameTV);
            this.descriptionTV = (TextView) itemView.findViewById(R.id.descriptionTV);
            this.ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
            this.profileImg = (CircleImageView) itemView.findViewById(R.id.profileImg);
        }
    }
}
