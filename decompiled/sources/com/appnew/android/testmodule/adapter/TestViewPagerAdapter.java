package com.appnew.android.testmodule.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class TestViewPagerAdapter extends FragmentStatePagerAdapter {
    Context context;
    FragmentManager fragmentManager;
    public ArrayList<Fragment> mFragmentList;
    public ArrayList<String> mFragmentTitleList;
    int num;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        return -2;
    }

    public TestViewPagerAdapter(FragmentManager fragmentManager, Activity context, ArrayList<Fragment> mFragmentList, int num) {
        super(fragmentManager);
        this.mFragmentList = new ArrayList<>();
        this.mFragmentTitleList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
        this.context = context;
        this.mFragmentList = mFragmentList;
        this.num = num;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        try {
            return this.mFragmentTitleList.get(position);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        return this.mFragmentList.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragmentList.size();
    }
}
