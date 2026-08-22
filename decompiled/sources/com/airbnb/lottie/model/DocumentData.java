package com.airbnb.lottie.model;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes4.dex */
public class DocumentData {
    public float baselineShift;
    public PointF boxPosition;
    public PointF boxSize;
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;
    public int tracking;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f2, Justification justification, int i, float f3, float f4, int i2, int i3, float f5, boolean z, PointF pointF, PointF pointF2) {
        set(str, str2, f2, justification, i, f3, f4, i2, i3, f5, z, pointF, pointF2);
    }

    public DocumentData() {
    }

    public void set(String str, String str2, float f2, Justification justification, int i, float f3, float f4, int i2, int i3, float f5, boolean z, PointF pointF, PointF pointF2) {
        this.text = str;
        this.fontName = str2;
        this.size = f2;
        this.justification = justification;
        this.tracking = i;
        this.lineHeight = f3;
        this.baselineShift = f4;
        this.color = i2;
        this.strokeColor = i3;
        this.strokeWidth = f5;
        this.strokeOverFill = z;
        this.boxPosition = pointF;
        this.boxSize = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size)) * 31) + this.justification.ordinal()) * 31) + this.tracking;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.lineHeight);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.color;
    }
}
