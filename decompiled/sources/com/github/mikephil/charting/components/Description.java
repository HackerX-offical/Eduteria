package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes7.dex */
public class Description extends ComponentBase {
    private MPPointF mPosition;
    private String text = "Description Label";
    private Paint.Align mTextAlign = Paint.Align.RIGHT;

    public Description() {
        this.mTextSize = Utils.convertDpToPixel(8.0f);
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }

    public void setPosition(float f2, float f3) {
        MPPointF mPPointF = this.mPosition;
        if (mPPointF == null) {
            this.mPosition = MPPointF.getInstance(f2, f3);
        } else {
            mPPointF.x = f2;
            this.mPosition.y = f3;
        }
    }

    public MPPointF getPosition() {
        return this.mPosition;
    }

    public void setTextAlign(Paint.Align align) {
        this.mTextAlign = align;
    }

    public Paint.Align getTextAlign() {
        return this.mTextAlign;
    }
}
