package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes7.dex */
public class CandleEntry extends Entry {
    private float mClose;
    private float mOpen;
    private float mShadowHigh;
    private float mShadowLow;

    public CandleEntry(float f2, float f3, float f4, float f5, float f6) {
        super(f2, (f3 + f4) / 2.0f);
        this.mShadowHigh = f3;
        this.mShadowLow = f4;
        this.mOpen = f5;
        this.mClose = f6;
    }

    public CandleEntry(float f2, float f3, float f4, float f5, float f6, Object obj) {
        super(f2, (f3 + f4) / 2.0f, obj);
        this.mShadowHigh = f3;
        this.mShadowLow = f4;
        this.mOpen = f5;
        this.mClose = f6;
    }

    public CandleEntry(float f2, float f3, float f4, float f5, float f6, Drawable drawable) {
        super(f2, (f3 + f4) / 2.0f, drawable);
        this.mShadowHigh = f3;
        this.mShadowLow = f4;
        this.mOpen = f5;
        this.mClose = f6;
    }

    public CandleEntry(float f2, float f3, float f4, float f5, float f6, Drawable drawable, Object obj) {
        super(f2, (f3 + f4) / 2.0f, drawable, obj);
        this.mShadowHigh = f3;
        this.mShadowLow = f4;
        this.mOpen = f5;
        this.mClose = f6;
    }

    public float getShadowRange() {
        return Math.abs(this.mShadowHigh - this.mShadowLow);
    }

    public float getBodyRange() {
        return Math.abs(this.mOpen - this.mClose);
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    public CandleEntry copy() {
        return new CandleEntry(getX(), this.mShadowHigh, this.mShadowLow, this.mOpen, this.mClose, getData());
    }

    public float getHigh() {
        return this.mShadowHigh;
    }

    public void setHigh(float f2) {
        this.mShadowHigh = f2;
    }

    public float getLow() {
        return this.mShadowLow;
    }

    public void setLow(float f2) {
        this.mShadowLow = f2;
    }

    public float getClose() {
        return this.mClose;
    }

    public void setClose(float f2) {
        this.mClose = f2;
    }

    public float getOpen() {
        return this.mOpen;
    }

    public void setOpen(float f2) {
        this.mOpen = f2;
    }
}
