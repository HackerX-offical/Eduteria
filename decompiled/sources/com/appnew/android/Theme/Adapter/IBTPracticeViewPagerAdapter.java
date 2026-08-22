package com.appnew.android.Theme.Adapter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class IBTPracticeViewPagerAdapter extends FragmentStatePagerAdapter {
    Context context;
    FragmentManager fragmentManager;
    private Fragment mCurrentFragment;
    public ArrayList<Fragment> mFragmentList;
    public ArrayList<String> mFragmentTitleList;
    int num;

    public IBTPracticeViewPagerAdapter(FragmentManager fragmentManager, Activity context, ArrayList<Fragment> mFragmentList, int num) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.context = context;
        this.mFragmentList = mFragmentList;
        this.num = num;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        return this.mFragmentList.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.num;
    }
}
