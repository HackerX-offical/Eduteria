package com.appnew.android.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes6.dex */
public class EnhancedWrapContentViewPager extends ViewPager {
    public EnhancedWrapContentViewPager(Context context) {
        super(context);
    }

    public EnhancedWrapContentViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int i = 0;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                childAt.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i) {
                    i = measuredHeight;
                }
            }
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
