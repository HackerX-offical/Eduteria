package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tuyenmonkey.mkloader.model.Arc;

/* JADX INFO: loaded from: classes9.dex */
public class PhoneWave extends LoaderView {
    private Arc[] arcs;
    private int numberOfArc = 3;

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        float fMin = Math.min(this.width, this.height) / 2.0f;
        this.arcs = new Arc[this.numberOfArc];
        for (int i = 0; i < this.numberOfArc; i++) {
            float f2 = (fMin / 4.0f) + ((i * fMin) / 4.0f);
            this.arcs[i] = new Arc();
            this.arcs[i].setColor(this.color);
            this.arcs[i].setAlpha(126);
            float f3 = fMin / 3.0f;
            this.arcs[i].setOval(new RectF(this.center.x - f2, (this.center.y - f2) + f3, this.center.x + f2, this.center.y + f2 + f3));
            this.arcs[i].setStartAngle(225.0f);
            this.arcs[i].setSweepAngle(90.0f);
            this.arcs[i].setStyle(Paint.Style.STROKE);
            this.arcs[i].setWidth(fMin / 10.0f);
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        for (final int i = 0; i < this.numberOfArc; i++) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(126, 255, 126);
            valueAnimatorOfInt.setRepeatCount(-1);
            valueAnimatorOfInt.setDuration(1000L);
            valueAnimatorOfInt.setStartDelay(i * 120);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.PhoneWave.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PhoneWave.this.arcs[i].setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    if (PhoneWave.this.invalidateListener != null) {
                        PhoneWave.this.invalidateListener.reDraw();
                    }
                }
            });
            valueAnimatorOfInt.start();
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.numberOfArc; i++) {
            this.arcs[i].draw(canvas);
        }
    }
}
