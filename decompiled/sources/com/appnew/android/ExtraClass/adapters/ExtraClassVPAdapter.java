package com.appnew.android.ExtraClass.adapters;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.appnew.android.ExtraClass.Fragment.ExtraLiveFragment;
import com.appnew.android.ExtraClass.Fragment.ExtraVodFragment;
import com.appnew.android.Utils.Const;
import com.appnew.android.home.model.ExtraVideoType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExtraClassVPAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/ExtraClass/adapters/ExtraClassVPAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "context", "Landroid/content/Context;", "fm", "Landroidx/fragment/app/FragmentManager;", "totalTabs", "", "videoTypeArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/home/model/ExtraVideoType;", "Lkotlin/collections/ArrayList;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;ILjava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getTotalTabs$app_EDUTERIARelease", "()I", "setTotalTabs$app_EDUTERIARelease", "(I)V", "getVideoTypeArrayList", "()Ljava/util/ArrayList;", "getItem", "Landroidx/fragment/app/Fragment;", Const.POSITION, "getCount", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraClassVPAdapter extends FragmentPagerAdapter {
    public static final int $stable = 8;
    private final Context context;
    private int totalTabs;
    private final ArrayList<ExtraVideoType> videoTypeArrayList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtraClassVPAdapter(Context context, FragmentManager fm, int i, ArrayList<ExtraVideoType> videoTypeArrayList) {
        super(fm);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fm, "fm");
        Intrinsics.checkNotNullParameter(videoTypeArrayList, "videoTypeArrayList");
        this.context = context;
        this.totalTabs = i;
        this.videoTypeArrayList = videoTypeArrayList;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getTotalTabs$app_EDUTERIARelease() {
        return this.totalTabs;
    }

    public final ArrayList<ExtraVideoType> getVideoTypeArrayList() {
        return this.videoTypeArrayList;
    }

    public final void setTotalTabs$app_EDUTERIARelease(int i) {
        this.totalTabs = i;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        if (position == 0) {
            ArrayList<ExtraVideoType> arrayList = new ArrayList<>();
            ArrayList<ExtraVideoType> arrayList2 = this.videoTypeArrayList;
            Intrinsics.checkNotNull(arrayList2);
            Iterator<ExtraVideoType> it = arrayList2.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                ExtraVideoType next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                ExtraVideoType extraVideoType = next;
                if (StringsKt.equals$default(extraVideoType.getVideoType(), "8", false, 2, null) || StringsKt.equals$default(extraVideoType.getVideoType(), "4", false, 2, null)) {
                    arrayList.add(extraVideoType);
                }
            }
            return ExtraLiveFragment.INSTANCE.newInstance(arrayList);
        }
        if (position == 1) {
            ArrayList<ExtraVideoType> arrayList3 = new ArrayList<>();
            ArrayList<ExtraVideoType> arrayList4 = this.videoTypeArrayList;
            Intrinsics.checkNotNull(arrayList4);
            Iterator<ExtraVideoType> it2 = arrayList4.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                ExtraVideoType next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                ExtraVideoType extraVideoType2 = next2;
                if (StringsKt.equals$default(extraVideoType2.getVideoType(), "7", false, 2, null) || StringsKt.equals$default(extraVideoType2.getVideoType(), "1", false, 2, null)) {
                    arrayList3.add(extraVideoType2);
                }
            }
            return ExtraVodFragment.INSTANCE.newInstance(arrayList3);
        }
        return ExtraLiveFragment.INSTANCE.newInstance(this.videoTypeArrayList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* JADX INFO: renamed from: getCount, reason: from getter */
    public int getTotalTabs() {
        return this.totalTabs;
    }
}
