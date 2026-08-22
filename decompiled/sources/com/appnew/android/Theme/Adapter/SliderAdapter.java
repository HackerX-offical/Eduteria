package com.appnew.android.Theme.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Theme.DashboardActivityTheme1;
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
public class SliderAdapter extends RecyclerView.Adapter<SliderAdapterViewHolder> {
    BannerClick bannerClick;
    Context context;
    private final List<BannerListTable> mSliderItems;

    public interface BannerClick {
        void BannerClickItem(BannerListTable bannerItem);
    }

    public SliderAdapter(Context context, List<BannerListTable> sliderDataArrayList) {
        this.mSliderItems = sliderDataArrayList;
        this.context = context;
    }

    public SliderAdapter(Context context, List<BannerListTable> sliderDataArrayList, BannerClick bannerClick) {
        this.mSliderItems = sliderDataArrayList;
        this.context = context;
        this.bannerClick = bannerClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_banner, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new SliderAdapterViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {
        final BannerListTable bannerListTable = this.mSliderItems.get(position);
        Glide.with(viewHolder.itemView).load(!TextUtils.isEmpty(bannerListTable.getBanner_url()) ? bannerListTable.getBanner_url() : "").apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.placeholder_course).error(R.mipmap.placeholder_course)).fitCenter().into(viewHolder.imageViewBackground);
        viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.SliderAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(bannerListTable, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(BannerListTable bannerListTable, View view) {
        String parent_id;
        Helper.firebaseAnalytics((DashboardActivityTheme1) this.context, bannerListTable.getBanner_title(), "NA", "NA", "NA", bannerListTable.getCourse_id(), "NA", "Banner");
        if (!Helper.isNetworkConnected(this.context)) {
            Toast.makeText(this.context, "Internet Not Connected!!!", 0).show();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("BannerTitleAndroid", bannerListTable.getBanner_title());
        FacebookEventLogger.logEvent(this.context, "Banner_Clicked", bundle);
        if (bannerListTable.getCourse_id() != null) {
            if (bannerListTable.getBanner_location().equalsIgnoreCase("7") && bannerListTable.getLink_type().equalsIgnoreCase("4")) {
                BannerClick bannerClick = this.bannerClick;
                if (bannerClick != null) {
                    bannerClick.BannerClickItem(bannerListTable);
                    return;
                }
                return;
            }
            if (bannerListTable.getLink_type().equalsIgnoreCase("3")) {
                BannerClick bannerClick2 = this.bannerClick;
                if (bannerClick2 != null) {
                    bannerClick2.BannerClickItem(bannerListTable);
                    return;
                }
                return;
            }
            if (bannerListTable.getLink_type().equalsIgnoreCase("2") && !GenericUtils.isEmpty(bannerListTable.getLink())) {
                try {
                    this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bannerListTable.getLink())));
                    return;
                } catch (Exception unused) {
                    Toast.makeText(this.context, "Invalid Link", 0).show();
                    return;
                }
            }
            if (bannerListTable.getCourse_id().equals("0") || bannerListTable.getBanner_location().equalsIgnoreCase("5")) {
                return;
            }
            if (bannerListTable != null && !TextUtils.isEmpty(bannerListTable.getCourse_id()) && !TextUtils.isEmpty(bannerListTable.getParent_id()) && bannerListTable.getCourse_id().equalsIgnoreCase(bannerListTable.getParent_id())) {
                parent_id = bannerListTable.getParent_id();
            } else {
                parent_id = "";
            }
            if ("1".equals("7")) {
                Intent intent = new Intent(this.context, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.COURSE_DETAILS_FOR_THEME7);
                intent.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, parent_id);
                intent.putExtra(Const.IS_COMBO, false);
                intent.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title() != null ? bannerListTable.getBanner_title() : "Course");
                Helper.gotoActivity(intent, (Activity) this.context);
                return;
            }
            Intent intent2 = new Intent(this.context, (Class<?>) CourseActivity.class);
            intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
            intent2.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
            intent2.putExtra(Const.COURSE_PARENT_ID, parent_id);
            intent2.putExtra(Const.IS_COMBO, false);
            intent2.putExtra(Const.IS_COURSE_COMBO, bannerListTable.getIs_combo() == 1);
            intent2.putExtra(Const.LINK_TYPE, bannerListTable.getLink_type());
            intent2.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title() != null ? bannerListTable.getBanner_title() : "Course");
            Helper.gotoActivity(intent2, (Activity) this.context);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mSliderItems.size();
    }

    static class SliderAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewBackground;
        View itemView;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            this.imageViewBackground = (ImageView) itemView.findViewById(R.id.bannerIV);
            this.itemView = itemView;
        }
    }
}
