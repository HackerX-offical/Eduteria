package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ComponentBase {
    protected boolean mEnabled = true;
    protected float mXOffset = 5.0f;
    protected float mYOffset = 5.0f;
    protected Typeface mTypeface = null;
    protected float mTextSize = Utils.convertDpToPixel(10.0f);
    protected int mTextColor = -16777216;

    public float getXOffset() {
        return this.mXOffset;
    }

    public void setXOffset(float f2) {
        this.mXOffset = Utils.convertDpToPixel(f2);
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public void setYOffset(float f2) {
        this.mYOffset = Utils.convertDpToPixel(f2);
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }

    public void setTextSize(float f2) {
        if (f2 > 24.0f) {
            f2 = 24.0f;
        }
        if (f2 < 6.0f) {
            f2 = 6.0f;
        }
        this.mTextSize = Utils.convertDpToPixel(f2);
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }
}
