package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import com.tuyenmonkey.mkloader.model.Circle;

/* JADX INFO: loaded from: classes9.dex */
public class ClassicSpinner extends LoaderView {
    private Circle[] circles;
    private int circlesSize = 8;

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        float fMin = Math.min(this.width, this.height) / 10.0f;
        this.circles = new Circle[this.circlesSize];
        for (int i = 0; i < this.circlesSize; i++) {
            this.circles[i] = new Circle();
            this.circles[i].setCenter(this.center.x, fMin);
            this.circles[i].setColor(this.color);
            this.circles[i].setAlpha(126);
            this.circles[i].setRadius(fMin);
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        for (final int i = 0; i < this.circlesSize; i++) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(126, 255, 126);
            valueAnimatorOfInt.setRepeatCount(-1);
            valueAnimatorOfInt.setDuration(1000L);
            valueAnimatorOfInt.setStartDelay(i * 120);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.ClassicSpinner.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ClassicSpinner.this.circles[i].setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    if (ClassicSpinner.this.invalidateListener != null) {
                        ClassicSpinner.this.invalidateListener.reDraw();
                    }
                }
            });
            valueAnimatorOfInt.start();
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.circlesSize; i++) {
            canvas.save();
            canvas.rotate(i * 45, this.center.x, this.center.y);
            this.circles[i].draw(canvas);
            canvas.restore();
        }
    }
}
