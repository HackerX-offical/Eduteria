package com.tuyenmonkey.mkloader.type;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.callback.InvalidateListener;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LoaderView {
    protected PointF center;
    protected int color;
    protected int height;
    protected InvalidateListener invalidateListener;
    protected int width;
    protected int desiredWidth = 150;
    protected int desiredHeight = 150;

    public abstract void draw(Canvas canvas);

    public abstract void initializeObjects();

    public abstract void setUpAnimation();

    public void setColor(int i) {
        this.color = i;
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        this.center = new PointF(i / 2.0f, i2 / 2.0f);
    }

    public void setInvalidateListener(InvalidateListener invalidateListener) {
        this.invalidateListener = invalidateListener;
    }

    public int getDesiredWidth() {
        return this.desiredWidth;
    }

    public int getDesiredHeight() {
        return this.desiredHeight;
    }

    public boolean isDetached() {
        return this.invalidateListener == null;
    }

    public void onDetach() {
        if (this.invalidateListener != null) {
            this.invalidateListener = null;
        }
    }
}
