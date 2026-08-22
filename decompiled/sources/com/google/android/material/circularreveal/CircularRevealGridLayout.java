package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import com.google.android.material.circularreveal.CircularRevealWidget;

/* JADX INFO: loaded from: classes8.dex */
public class CircularRevealGridLayout extends GridLayout implements CircularRevealWidget {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private final CircularRevealHelper f617helper;

    public CircularRevealGridLayout(Context context) {
        this(context, null);
    }

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f617helper = new CircularRevealHelper(this);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void buildCircularRevealCache() {
        this.f617helper.buildCircularRevealCache();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void destroyCircularRevealCache() {
        this.f617helper.destroyCircularRevealCache();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        return this.f617helper.getRevealInfo();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setRevealInfo(CircularRevealWidget.RevealInfo revealInfo) {
        this.f617helper.setRevealInfo(revealInfo);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public int getCircularRevealScrimColor() {
        return this.f617helper.getCircularRevealScrimColor();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealScrimColor(int i) {
        this.f617helper.setCircularRevealScrimColor(i);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f617helper.getCircularRevealOverlayDrawable();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealWidget
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f617helper.setCircularRevealOverlayDrawable(drawable);
    }

    @Override // android.view.View, com.google.android.material.circularreveal.CircularRevealWidget
    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f617helper;
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
        CircularRevealHelper circularRevealHelper = this.f617helper;
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
