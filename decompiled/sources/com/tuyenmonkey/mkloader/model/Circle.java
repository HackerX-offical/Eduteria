package com.tuyenmonkey.mkloader.model;

import android.graphics.Canvas;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes9.dex */
public class Circle extends GraphicObject {
    private PointF center = new PointF();
    private float radius;

    public void setRadius(float f2) {
        this.radius = f2;
    }

    public void setCenter(float f2, float f3) {
        this.center.set(f2, f3);
    }

    @Override // com.tuyenmonkey.mkloader.model.GraphicObject
    public void draw(Canvas canvas) {
        canvas.drawCircle(this.center.x, this.center.y, this.radius, this.paint);
    }
}
