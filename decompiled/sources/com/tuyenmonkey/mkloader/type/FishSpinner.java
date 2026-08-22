package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import com.tuyenmonkey.mkloader.model.Circle;

/* JADX INFO: loaded from: classes9.dex */
public class FishSpinner extends LoaderView {
    private Circle[] circles;
    private int numberOfCircle = 5;
    private float[] rotates = new float[5];

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        float fMin = Math.min(this.width, this.height) / 10.0f;
        this.circles = new Circle[this.numberOfCircle];
        for (int i = 0; i < this.numberOfCircle; i++) {
            this.circles[i] = new Circle();
            this.circles[i].setCenter(this.center.x, fMin);
            this.circles[i].setColor(this.color);
            this.circles[i].setRadius(fMin - ((i * fMin) / 6.0f));
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        for (final int i = 0; i < this.numberOfCircle; i++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setDuration(1700L);
            valueAnimatorOfFloat.setStartDelay(i * 100);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.FishSpinner.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FishSpinner.this.rotates[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (FishSpinner.this.invalidateListener != null) {
                        FishSpinner.this.invalidateListener.reDraw();
                    }
                }
            });
            valueAnimatorOfFloat.start();
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.numberOfCircle; i++) {
            canvas.save();
            canvas.rotate(this.rotates[i], this.center.x, this.center.y);
            this.circles[i].draw(canvas);
            canvas.restore();
        }
    }
}
