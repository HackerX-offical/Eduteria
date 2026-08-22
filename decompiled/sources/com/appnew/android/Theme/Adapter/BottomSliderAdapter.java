package com.appnew.android.Theme.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.table.BannerListTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class BottomSliderAdapter extends RecyclerView.Adapter<BottomSliderAdapterViewHolder> {
    BannerClick bannerClick;
    Context context;
    private final List<BannerListTable> mSliderItems;

    public interface BannerClick {
        void BannerClickItem(BannerListTable bannerItem);
    }

    public BottomSliderAdapter(Context context, List<BannerListTable> sliderDataArrayList) {
        this.mSliderItems = sliderDataArrayList;
        this.context = context;
    }

    public BottomSliderAdapter(Context context, List<BannerListTable> sliderDataArrayList, BannerClick bannerClick) {
        this.mSliderItems = sliderDataArrayList;
        this.context = context;
        this.bannerClick = bannerClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BottomSliderAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_banner, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new BottomSliderAdapterViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BottomSliderAdapterViewHolder viewHolder, final int position) {
        final BannerListTable bannerListTable = this.mSliderItems.get(position);
        Glide.with(viewHolder.itemView).load(!TextUtils.isEmpty(bannerListTable.getBanner_url()) ? bannerListTable.getBanner_url() : "").apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.placeholder_course).error(R.mipmap.placeholder_course)).fitCenter().into(viewHolder.imageViewBackground);
        viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.BottomSliderAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(bannerListTable, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(BannerListTable bannerListTable, View view) {
        String parent_id;
        if (bannerListTable.getCourse_id() != null) {
            if (Helper.isNetworkConnected(this.context)) {
                if (bannerListTable.getLink_type().equalsIgnoreCase("3")) {
                    BannerClick bannerClick = this.bannerClick;
                    if (bannerClick != null) {
                        bannerClick.BannerClickItem(bannerListTable);
                        return;
                    }
                    return;
                }
                if (bannerListTable.getLink_type().equalsIgnoreCase("2") && !GenericUtils.isEmpty(bannerListTable.getLink())) {
                    this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bannerListTable.getLink())));
                    return;
                }
                if (bannerListTable.getCourse_id().equals("0") || bannerListTable.getBanner_location().equalsIgnoreCase("5")) {
                    return;
                }
                if (bannerListTable != null && !TextUtils.isEmpty(bannerListTable.getCourse_id()) && !TextUtils.isEmpty(bannerListTable.getParent_id()) && bannerListTable.getCourse_id().equalsIgnoreCase(bannerListTable.getParent_id())) {
                    parent_id = bannerListTable.getParent_id();
                } else {
                    parent_id = "";
                }
                Intent intent = new Intent(this.context, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, parent_id);
                intent.putExtra(Const.IS_COMBO, false);
                intent.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title() != null ? bannerListTable.getBanner_title() : "Course");
                Helper.gotoActivity(intent, (Activity) this.context);
                return;
            }
            Helper.showInternetToast(this.context);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mSliderItems.size();
    }

    static class BottomSliderAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewBackground;
        View itemView;

        public BottomSliderAdapterViewHolder(View itemView) {
            super(itemView);
            this.imageViewBackground = (ImageView) itemView.findViewById(R.id.bannerIV);
            this.itemView = itemView;
        }
    }
}
