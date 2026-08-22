package com.razorpay;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: RZPProgressBar.java */
/* JADX INFO: loaded from: classes9.dex */
class ResizeWidthAnimation extends Animation {
    private int mStartWidth;
    private View mView;
    private int mWidth;

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }

    ResizeWidthAnimation(View view, int i) {
        this.mView = view;
        this.mWidth = i;
        this.mStartWidth = view.getWidth();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        this.mView.getLayoutParams().width = this.mStartWidth + ((int) ((this.mWidth - r3) * f2));
        this.mView.requestLayout();
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
    }
}
