package com.appnew.android.Zoom.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.appnew.android.Utils.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DoubtsViewPagerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/DoubtsViewPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "mFragmentList", "", "Landroidx/fragment/app/Fragment;", "mFragmentTitleList", "", "getItem", Const.POSITION, "", "getCount", "addFragment", "", "fragment", "title", "getPageTitle", "", "getFragment", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubtsViewPagerAdapter extends FragmentPagerAdapter {
    public static final int $stable = 8;
    private final List<Fragment> mFragmentList;
    private final List<String> mFragmentTitleList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoubtsViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        Intrinsics.checkNotNull(fragmentManager);
        this.mFragmentList = new ArrayList();
        this.mFragmentTitleList = new ArrayList();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        return this.mFragmentList.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragmentList.size();
    }

    public final void addFragment(Fragment fragment, String title) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(title, "title");
        this.mFragmentList.add(fragment);
        this.mFragmentTitleList.add(title);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.mFragmentTitleList.get(position);
    }

    public final Fragment getFragment(int position) {
        if (position < 0 || position >= this.mFragmentList.size()) {
            return null;
        }
        return this.mFragmentList.get(position);
    }
}
