package com.appnew.android.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes6.dex */
public class CustomViewPager extends ViewPager {
    private SwipeDirection direction;
    private float initialXValue;

    public enum SwipeDirection {
        all,
        left,
        right,
        none
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.direction = SwipeDirection.all;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (IsSwipeAllowed(event)) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (IsSwipeAllowed(event)) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    private boolean IsSwipeAllowed(MotionEvent event) {
        if (this.direction == SwipeDirection.all) {
            return true;
        }
        if (this.direction == SwipeDirection.none) {
            return false;
        }
        if (event.getAction() == 0) {
            this.initialXValue = event.getX();
            return true;
        }
        if (event.getAction() == 2) {
            try {
                float x = event.getX() - this.initialXValue;
                if (x > 0.0f && this.direction == SwipeDirection.right) {
                    return false;
                }
                if (x < 0.0f) {
                    if (this.direction == SwipeDirection.left) {
                        return false;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    public void setAllowedSwipeDirection(SwipeDirection direction) {
        this.direction = direction;
    }
}
