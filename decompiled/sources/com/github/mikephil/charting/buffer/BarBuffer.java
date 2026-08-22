package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX INFO: loaded from: classes7.dex */
public class BarBuffer extends AbstractBuffer<IBarDataSet> {
    protected float mBarWidth;
    protected boolean mContainsStacks;
    protected int mDataSetCount;
    protected int mDataSetIndex;
    protected boolean mInverted;

    public BarBuffer(int i, int i2, boolean z) {
        super(i);
        this.mDataSetIndex = 0;
        this.mInverted = false;
        this.mBarWidth = 1.0f;
        this.mDataSetCount = i2;
        this.mContainsStacks = z;
    }

    public void setBarWidth(float f2) {
        this.mBarWidth = f2;
    }

    public void setDataSet(int i) {
        this.mDataSetIndex = i;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    protected void addBar(float f2, float f3, float f4, float f5) {
        float[] fArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        fArr[i] = f2;
        float[] fArr2 = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        fArr2[i2] = f3;
        float[] fArr3 = this.buffer;
        int i3 = this.index;
        this.index = i3 + 1;
        fArr3[i3] = f4;
        float[] fArr4 = this.buffer;
        int i4 = this.index;
        this.index = i4 + 1;
        fArr4[i4] = f5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.buffer.AbstractBuffer
    public void feed(IBarDataSet iBarDataSet) {
        float f2;
        float fAbs;
        float fAbs2;
        float f3;
        float entryCount = iBarDataSet.getEntryCount() * this.phaseX;
        float f4 = this.mBarWidth / 2.0f;
        for (int i = 0; i < entryCount; i++) {
            BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForIndex(i);
            if (barEntry != null) {
                float x = barEntry.getX();
                float y = barEntry.getY();
                float[] yVals = barEntry.getYVals();
                if (!this.mContainsStacks || yVals == null) {
                    float f5 = x - f4;
                    float f6 = x + f4;
                    if (this.mInverted) {
                        f2 = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                    } else {
                        float f7 = y >= 0.0f ? y : 0.0f;
                        if (y > 0.0f) {
                            y = 0.0f;
                        }
                        float f8 = y;
                        y = f7;
                        f2 = f8;
                    }
                    if (y > 0.0f) {
                        y *= this.phaseY;
                    } else {
                        f2 *= this.phaseY;
                    }
                    addBar(f5, y, f6, f2);
                } else {
                    float f9 = -barEntry.getNegativeSum();
                    float f10 = 0.0f;
                    int i2 = 0;
                    while (i2 < yVals.length) {
                        float f11 = yVals[i2];
                        if (f11 == 0.0f && (f10 == 0.0f || f9 == 0.0f)) {
                            fAbs = f11;
                            fAbs2 = f9;
                            f9 = fAbs;
                        } else if (f11 >= 0.0f) {
                            fAbs = f11 + f10;
                            fAbs2 = f9;
                            f9 = f10;
                            f10 = fAbs;
                        } else {
                            fAbs = Math.abs(f11) + f9;
                            fAbs2 = Math.abs(f11) + f9;
                        }
                        float f12 = x - f4;
                        float f13 = x + f4;
                        if (this.mInverted) {
                            f3 = f9 >= fAbs ? f9 : fAbs;
                            if (f9 > fAbs) {
                                f9 = fAbs;
                            }
                        } else {
                            float f14 = f9 >= fAbs ? f9 : fAbs;
                            if (f9 > fAbs) {
                                f9 = fAbs;
                            }
                            float f15 = f9;
                            f9 = f14;
                            f3 = f15;
                        }
                        addBar(f12, f9 * this.phaseY, f13, f3 * this.phaseY);
                        i2++;
                        f9 = fAbs2;
                    }
                }
            }
        }
        reset();
    }
}
