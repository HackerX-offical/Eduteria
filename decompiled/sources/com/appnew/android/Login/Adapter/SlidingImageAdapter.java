package com.appnew.android.Login.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public class SlidingImageAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    int[] slidImages;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public SlidingImageAdapter(int[] slidImages, Context context) {
        this.slidImages = slidImages;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.slidImages.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        View viewInflate = this.layoutInflater.inflate(R.layout.pager_item, container, false);
        ((ImageView) viewInflate.findViewById(R.id.imageView)).setBackgroundResource(this.slidImages[position]);
        container.addView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
