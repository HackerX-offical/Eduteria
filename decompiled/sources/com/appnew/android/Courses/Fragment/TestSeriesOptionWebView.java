package com.appnew.android.Courses.Fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes6.dex */
public class TestSeriesOptionWebView extends WebView {
    private boolean check;

    class LongClick implements View.OnLongClickListener {
        final TestSeriesOptionWebView testSeriesOptionWebView;

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }

        LongClick(TestSeriesOptionWebView testSeriesOptionWebView) {
            this.testSeriesOptionWebView = testSeriesOptionWebView;
        }
    }

    public TestSeriesOptionWebView(Context context) {
        super(context);
        this.check = false;
        handleClick();
    }

    public TestSeriesOptionWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.check = false;
        handleClick();
    }

    public TestSeriesOptionWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.check = false;
        handleClick();
    }

    private void handleClick() {
        setFocusable(false);
        setLayerType(1, null);
        setVerticalScrollBarEnabled(false);
        setBackgroundColor(0);
        setHapticFeedbackEnabled(false);
        setLayerType(2, null);
        setOnLongClickListener(new LongClick(this));
    }

    public void setDisableWebViewTouchListener(boolean z) {
        this.check = z;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.check) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean canScrollHorizontal(int i) {
        int iComputeHorizontalScrollOffset = computeHorizontalScrollOffset();
        int iComputeHorizontalScrollRange = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (iComputeHorizontalScrollRange == 0) {
            return false;
        }
        return i < 0 ? iComputeHorizontalScrollOffset > 0 : iComputeHorizontalScrollOffset < iComputeHorizontalScrollRange - 1;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        getLayoutParams().height = -2;
    }
}
