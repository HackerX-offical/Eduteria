package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseEntry {
    private Object mData;
    private Drawable mIcon;
    private float y;

    public BaseEntry() {
        this.y = 0.0f;
        this.mData = null;
        this.mIcon = null;
    }

    public BaseEntry(float f2) {
        this.mData = null;
        this.mIcon = null;
        this.y = f2;
    }

    public BaseEntry(float f2, Object obj) {
        this(f2);
        this.mData = obj;
    }

    public BaseEntry(float f2, Drawable drawable) {
        this(f2);
        this.mIcon = drawable;
    }

    public BaseEntry(float f2, Drawable drawable, Object obj) {
        this(f2);
        this.mIcon = drawable;
        this.mData = obj;
    }

    public float getY() {
        return this.y;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public void setY(float f2) {
        this.y = f2;
    }

    public Object getData() {
        return this.mData;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }
}
