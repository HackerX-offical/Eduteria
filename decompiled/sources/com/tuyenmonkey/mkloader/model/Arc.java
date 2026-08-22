package com.tuyenmonkey.mkloader.model;

import android.graphics.Canvas;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes9.dex */
public class Arc extends GraphicObject {
    private RectF oval;
    private float startAngle;
    private float sweepAngle;
    private boolean useCenter;

    public void setOval(RectF rectF) {
        this.oval = rectF;
    }

    public void setStartAngle(float f2) {
        this.startAngle = f2;
    }

    public void setSweepAngle(float f2) {
        this.sweepAngle = f2;
    }

    public void setUseCenter(boolean z) {
        this.useCenter = z;
    }

    public float getStartAngle() {
        return this.startAngle;
    }

    @Override // com.tuyenmonkey.mkloader.model.GraphicObject
    public void draw(Canvas canvas) {
        canvas.drawArc(this.oval, this.startAngle, this.sweepAngle, this.useCenter, this.paint);
    }
}
