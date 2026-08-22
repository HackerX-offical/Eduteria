package com.appnew.android.Theme.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Theme.Adapter.BottomBannerAdapter;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.table.BannerListTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: BottomBannerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/Theme/Adapter/BottomBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/BottomBannerAdapter$BottomBannerViewHolder;", "activity", "Landroid/app/Activity;", "bannerList", "", "Lcom/appnew/android/table/BannerListTable;", "bannerClick", "Lcom/appnew/android/Theme/Adapter/BottomBannerAdapter$BannerClick;", "<init>", "(Landroid/app/Activity;Ljava/util/List;Lcom/appnew/android/Theme/Adapter/BottomBannerAdapter$BannerClick;)V", "getActivity", "()Landroid/app/Activity;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "BottomBannerViewHolder", "BannerClick", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomBannerAdapter extends RecyclerView.Adapter<BottomBannerViewHolder> {
    public static final int $stable = 8;
    private final Activity activity;
    private final BannerClick bannerClick;
    private final List<BannerListTable> bannerList;

    /* JADX INFO: compiled from: BottomBannerAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/Theme/Adapter/BottomBannerAdapter$BannerClick;", "", "BannerClickItem", "", "bannerItem", "Lcom/appnew/android/table/BannerListTable;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface BannerClick {
        void BannerClickItem(BannerListTable bannerItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomBannerAdapter(Activity activity, List<? extends BannerListTable> bannerList, BannerClick bannerClick) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bannerList, "bannerList");
        Intrinsics.checkNotNullParameter(bannerClick, "bannerClick");
        this.activity = activity;
        this.bannerList = bannerList;
        this.bannerClick = bannerClick;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BottomBannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_banner, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new BottomBannerViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BottomBannerViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setData(this.activity, this.bannerList.get(position), this.bannerClick);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bannerList.size();
    }

    /* JADX INFO: compiled from: BottomBannerAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/appnew/android/Theme/Adapter/BottomBannerAdapter$BottomBannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "setData", "", "activity", "Landroid/app/Activity;", "bannerListTable", "Lcom/appnew/android/table/BannerListTable;", "bannerClick", "Lcom/appnew/android/Theme/Adapter/BottomBannerAdapter$BannerClick;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BottomBannerViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ImageView imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BottomBannerViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.bannerIV);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.imageView = (ImageView) viewFindViewById;
        }

        public final void setData(final Activity activity, final BannerListTable bannerListTable, final BannerClick bannerClick) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bannerListTable, "bannerListTable");
            Intrinsics.checkNotNullParameter(bannerClick, "bannerClick");
            Glide.with(activity).load(bannerListTable.getBanner_url()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)).into(this.imageView);
            this.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.BottomBannerAdapter$BottomBannerViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomBannerAdapter.BottomBannerViewHolder.setData$lambda$0(bannerListTable, activity, bannerClick, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setData$lambda$0(BannerListTable bannerListTable, Activity activity, BannerClick bannerClick, View view) {
            if (!StringsKt.equals("1", "2", true)) {
                if (bannerListTable.getCourse_id() != null) {
                    if (!Intrinsics.areEqual(bannerListTable.getCourse_id(), "0")) {
                        Intent intent = new Intent(activity, (Class<?>) CourseActivity.class);
                        intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                        intent.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
                        intent.putExtra(Const.COURSE_PARENT_ID, "");
                        intent.putExtra(Const.IS_COMBO, false);
                        intent.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title());
                        Helper.gotoActivity(intent, activity);
                        return;
                    }
                    if (GenericUtils.isEmpty(bannerListTable.getLink())) {
                        return;
                    }
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bannerListTable.getLink())));
                    return;
                }
                return;
            }
            Activity activity2 = activity;
            if (!Helper.isNetworkConnected(activity2)) {
                Toast.makeText(activity2, "Internet Not Connected!!!", 0).show();
                return;
            }
            FacebookEventLogger.logBannerClicked(activity2, bannerListTable.getBanner_title());
            Helper.firebaseAnalytics(activity, bannerListTable.getBanner_title() + "=" + bannerListTable.getCourse_id(), "NA", "NA", "NA", "NA", "NA", "Banner");
            if (bannerListTable.getCourse_id() != null) {
                if (StringsKt.equals(bannerListTable.getBanner_location(), "7", true) && StringsKt.equals(bannerListTable.getLink_type(), "4", true)) {
                    if (bannerClick != null) {
                        bannerClick.BannerClickItem(bannerListTable);
                        return;
                    }
                    return;
                }
                if (StringsKt.equals(bannerListTable.getLink_type(), "3", true)) {
                    if (bannerClick != null) {
                        bannerClick.BannerClickItem(bannerListTable);
                    }
                } else {
                    if (StringsKt.equals(bannerListTable.getLink_type(), "2", true) && !GenericUtils.isEmpty(bannerListTable.getLink())) {
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bannerListTable.getLink())));
                        return;
                    }
                    if (Intrinsics.areEqual(bannerListTable.getCourse_id(), "0") || StringsKt.equals(bannerListTable.getBanner_location(), "5", true)) {
                        return;
                    }
                    Intent intent2 = new Intent(activity2, (Class<?>) CourseActivity.class);
                    intent2.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                    intent2.putExtra(Const.COURSE_ID_MAIN, bannerListTable.getCourse_id());
                    intent2.putExtra(Const.COURSE_PARENT_ID, "");
                    intent2.putExtra(Const.IS_COMBO, false);
                    intent2.putExtra(AnalyticsConstants.course_name, bannerListTable.getBanner_title() != null ? bannerListTable.getBanner_title() : "Course");
                    Helper.gotoActivity(intent2, activity);
                }
            }
        }
    }
}
