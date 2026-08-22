package com.appnew.android.feeds.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.ItemViewPagerFeedBinding;
import com.appnew.android.table.BannerListTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: FeedViewPagerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedViewPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/feeds/adapters/FeedViewPagerAdapter$ViewHolder;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "bannerListTable", "", "Lcom/appnew/android/table/BannerListTable;", "<init>", "(Landroid/content/Context;Landroid/app/Activity;Ljava/util/List;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedViewPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Activity activity;
    private final List<BannerListTable> bannerListTable;
    private final Context context;

    /* JADX INFO: compiled from: FeedViewPagerAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/feeds/adapters/FeedViewPagerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemViewPagerFeedBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/FeedViewPagerAdapter;Lcom/appnew/android/databinding/ItemViewPagerFeedBinding;)V", "getBinding$app_EDUTERIARelease", "()Lcom/appnew/android/databinding/ItemViewPagerFeedBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemViewPagerFeedBinding binding;
        final /* synthetic */ FeedViewPagerAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(FeedViewPagerAdapter feedViewPagerAdapter, ItemViewPagerFeedBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = feedViewPagerAdapter;
            this.binding = binding;
        }

        /* JADX INFO: renamed from: getBinding$app_EDUTERIARelease, reason: from getter */
        public final ItemViewPagerFeedBinding getBinding() {
            return this.binding;
        }
    }

    public FeedViewPagerAdapter(Context context, Activity activity, List<BannerListTable> bannerListTable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bannerListTable, "bannerListTable");
        this.context = context;
        this.activity = activity;
        this.bannerListTable = bannerListTable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemViewPagerFeedBinding itemViewPagerFeedBindingInflate = ItemViewPagerFeedBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemViewPagerFeedBindingInflate, "inflate(...)");
        return new ViewHolder(this, itemViewPagerFeedBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemViewPagerFeedBinding binding = holder.getBinding();
        Glide.with(this.context).load(this.bannerListTable.get(position).getBanner_url()).diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.imageView);
        binding.shareRl.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.feeds.adapters.FeedViewPagerAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FeedViewPagerAdapter.onBindViewHolder$lambda$2$lambda$0(this.f$0, position);
            }
        }));
        binding.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.adapters.FeedViewPagerAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedViewPagerAdapter.onBindViewHolder$lambda$2$lambda$1(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$0(FeedViewPagerAdapter feedViewPagerAdapter, int i) {
        Helper.shareBanner(feedViewPagerAdapter.activity, feedViewPagerAdapter.bannerListTable.get(i).getId(), feedViewPagerAdapter.bannerListTable.get(i).getBanner_url(), "Banner");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$1(FeedViewPagerAdapter feedViewPagerAdapter, int i, View view) {
        if (!Helper.isNetworkConnected(feedViewPagerAdapter.context)) {
            Toast.makeText(feedViewPagerAdapter.context, "Internet Not Connected!!!", 0).show();
            return;
        }
        if (feedViewPagerAdapter.bannerListTable.get(i).getCourse_id() != null) {
            if (!Intrinsics.areEqual(feedViewPagerAdapter.bannerListTable.get(i).getCourse_id(), "0")) {
                Intent intent = new Intent(feedViewPagerAdapter.context, (Class<?>) CourseActivity.class);
                intent.putExtra(Const.FRAG_TYPE, Const.SINGLE_STUDY);
                intent.putExtra(Const.COURSE_ID_MAIN, feedViewPagerAdapter.bannerListTable.get(i).getCourse_id());
                intent.putExtra(Const.COURSE_PARENT_ID, "");
                intent.putExtra(Const.IS_COMBO, false);
                intent.putExtra(AnalyticsConstants.course_name, feedViewPagerAdapter.bannerListTable.get(i).getBanner_title() != null ? feedViewPagerAdapter.bannerListTable.get(i).getBanner_title() : "Course");
                Context context = feedViewPagerAdapter.context;
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                Helper.gotoActivity(intent, (Activity) context);
            }
            if (GenericUtils.isEmpty(feedViewPagerAdapter.bannerListTable.get(i).getLink())) {
                return;
            }
            feedViewPagerAdapter.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(feedViewPagerAdapter.bannerListTable.get(i).getLink())));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.bannerListTable.size();
    }
}
