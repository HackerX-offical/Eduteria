package com.appnew.android.feeds.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.BannerAdapterImageviewBinding;
import com.appnew.android.feeds.dataclass.BannerData;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Banner_ViewPager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/feeds/adapters/Banner_ViewPager;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "list_banners", "", "Lcom/appnew/android/feeds/dataclass/BannerData;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "getCount", "", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", Const.POSITION, "isViewFromObject", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "object", "destroyItem", "", "getPageWidth", "", "clickBanner", "target_meta", "", "updateItems", "data", "ctx", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Banner_ViewPager extends PagerAdapter {
    public static final int $stable = 8;
    private Context context;
    private List<BannerData> list_banners;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return view == object;
    }

    public Banner_ViewPager(Context context, List<BannerData> list) {
        this.context = context;
        this.list_banners = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<BannerData> list = this.list_banners;
        if (list == null) {
            return 0;
        }
        Intrinsics.checkNotNull(list);
        if (list.isEmpty()) {
            return 0;
        }
        List<BannerData> list2 = this.list_banners;
        Intrinsics.checkNotNull(list2);
        return list2.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        BannerAdapterImageviewBinding bannerAdapterImageviewBindingInflate = BannerAdapterImageviewBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(bannerAdapterImageviewBindingInflate, "inflate(...)");
        bannerAdapterImageviewBindingInflate.setBannerviewadapter(this);
        List<BannerData> list = this.list_banners;
        Intrinsics.checkNotNull(list);
        bannerAdapterImageviewBindingInflate.setBannerdata(list.get(position));
        bannerAdapterImageviewBindingInflate.getRoot().setTag(Integer.valueOf(position));
        container.addView(bannerAdapterImageviewBindingInflate.getRoot());
        View root = bannerAdapterImageviewBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int position) {
        List<BannerData> list = this.list_banners;
        Intrinsics.checkNotNull(list);
        return list.size() > 1 ? 0.9f : 1.0f;
    }

    public final void clickBanner(String target_meta) {
        Intrinsics.checkNotNullParameter(target_meta, "target_meta");
        try {
            if (StringsKt.equals(target_meta, "", true)) {
                return;
            }
            Helper.gotoActivity(new Intent("android.intent.action.VIEW", Uri.parse(target_meta)), (Activity) this.context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void updateItems(List<BannerData> data, Context ctx) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.context = ctx;
        this.list_banners = data;
    }
}
