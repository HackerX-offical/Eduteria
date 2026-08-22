package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;

/* JADX INFO: loaded from: classes8.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements CircularRevealWidget {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private final CircularRevealHelper f621helper;

    public CircularRevealCoordinatorLayout(Context context) {
        this(context, null);
    }

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f621helper = new CircularRevealHelper(this);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void buildCircularRevealCache() {
        this.f621helper.buildCircularRevealCache();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void destroyCircularRevealCache() {
        this.f621helper.destroyCircularRevealCache();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setRevealInfo(CircularRevealWidget.RevealInfo revealInfo) {
        this.f621helper.setRevealInfo(revealInfo);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        return this.f621helper.getRevealInfo();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealScrimColor(int i) {
        this.f621helper.setCircularRevealScrimColor(i);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public int getCircularRevealScrimColor() {
        return this.f621helper.getCircularRevealScrimColor();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f621helper.getCircularRevealOverlayDrawable();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f621helper.setCircularRevealOverlayDrawable(drawable);
    }

    @Override // android.view.View, com.google.android.material.circularreveal.CircularRevealWidget
    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f621helper;
        if (circularRevealHelper != null) {
            circularRevealHelper.draw(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.Delegate
    public void actualDraw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View, com.google.android.material.circularreveal.CircularRevealWidget
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f621helper;
        if (circularRevealHelper != null) {
            return circularRevealHelper.isOpaque();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.Delegate
    public boolean actualIsOpaque() {
        return super.isOpaque();
    }
}
