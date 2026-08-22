package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.util.Log;

/* JADX INFO: loaded from: classes7.dex */
public class PieEntry extends Entry {
    private String label;

    public PieEntry(float f2) {
        super(0.0f, f2);
    }

    public PieEntry(float f2, Object obj) {
        super(0.0f, f2, obj);
    }

    public PieEntry(float f2, Drawable drawable) {
        super(0.0f, f2, drawable);
    }

    public PieEntry(float f2, Drawable drawable, Object obj) {
        super(0.0f, f2, drawable, obj);
    }

    public PieEntry(float f2, String str) {
        super(0.0f, f2);
        this.label = str;
    }

    public PieEntry(float f2, String str, Object obj) {
        super(0.0f, f2, obj);
        this.label = str;
    }

    public PieEntry(float f2, String str, Drawable drawable) {
        super(0.0f, f2, drawable);
        this.label = str;
    }

    public PieEntry(float f2, String str, Drawable drawable, Object obj) {
        super(0.0f, f2, drawable, obj);
        this.label = str;
    }

    public float getValue() {
        return getY();
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float f2) {
        super.setX(f2);
        Log.i("DEPRECATED", "Pie entries do not have x values");
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.getX();
    }

    @Override // com.github.mikephil.charting.data.Entry
    public PieEntry copy() {
        return new PieEntry(getY(), this.label, getData());
    }
}
