package com.tuyenmonkey.mkloader.model;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes9.dex */
public abstract class GraphicObject {
    protected Paint paint;

    public abstract void draw(Canvas canvas);

    public GraphicObject() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
    }

    public void setColor(int i) {
        this.paint.setColor(i);
    }

    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    public void setWidth(float f2) {
        this.paint.setStrokeWidth(f2);
    }

    public void setStyle(Paint.Style style) {
        this.paint.setStyle(style);
    }
}
