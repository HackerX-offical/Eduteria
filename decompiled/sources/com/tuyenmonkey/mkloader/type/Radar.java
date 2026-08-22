package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.model.Line;

/* JADX INFO: loaded from: classes9.dex */
public class Radar extends LoaderView {
    private float degree;
    private Line line;

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        float fMin = Math.min(this.width, this.height);
        Line line = new Line();
        this.line = line;
        line.setPoint1(this.center);
        this.line.setPoint2(new PointF(0.0f, fMin / 2.0f));
        this.line.setColor(this.color);
        this.line.setWidth(5.0f);
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 359.0f);
        valueAnimatorOfFloat.setDuration(1000L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.Radar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Radar.this.degree = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Radar.this.invalidateListener != null) {
                    Radar.this.invalidateListener.reDraw();
                }
            }
        });
        valueAnimatorOfFloat.start();
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.degree, this.center.x, this.center.y);
        this.line.draw(canvas);
        canvas.restore();
    }
}
