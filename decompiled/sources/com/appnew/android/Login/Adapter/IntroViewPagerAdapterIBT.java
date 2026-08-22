package com.appnew.android.Login.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class IntroViewPagerAdapterIBT extends PagerAdapter {
    Context context;
    int[] layoutdata = {R.layout.ibt_intro_bluelayout1, R.layout.ibt_intro_orangelayout2, R.layout.ibt_intro_purplelayout3, R.layout.ibt_intro_greenlayout4};
    String title;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public IntroViewPagerAdapterIBT(Context context, String title) {
        this.context = context;
        this.title = title;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        View viewInflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(this.layoutdata[position], container, false);
        if (position == 0) {
            ((TextView) viewInflate.findViewById(R.id.firstTitle)).setText(this.title);
        }
        container.addView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.layoutdata.length;
    }
}
