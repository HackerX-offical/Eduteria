package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import com.tuyenmonkey.mkloader.model.Circle;

/* JADX INFO: loaded from: classes9.dex */
public class TwinFishesSpinner extends LoaderView {
    private Circle[] circles;
    private int numberOfCircle = 10;
    private float[] rotates = new float[10];

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        int i;
        float fMin = Math.min(this.width, this.height);
        float f2 = fMin / 10.0f;
        this.circles = new Circle[this.numberOfCircle];
        int i2 = 0;
        while (true) {
            i = this.numberOfCircle;
            if (i2 >= i / 2) {
                break;
            }
            this.circles[i2] = new Circle();
            this.circles[i2].setCenter(this.center.x, f2);
            this.circles[i2].setColor(this.color);
            this.circles[i2].setRadius(f2 - ((i2 * f2) / 6.0f));
            i2++;
        }
        for (int i3 = i / 2; i3 < this.numberOfCircle; i3++) {
            this.circles[i3] = new Circle();
            this.circles[i3].setCenter(this.center.x, fMin - f2);
            this.circles[i3].setColor(this.color);
            this.circles[i3].setRadius(f2 - (((i3 - 5) * f2) / 6.0f));
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        final int i = 0;
        while (i < this.numberOfCircle) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setDuration(1700L);
            valueAnimatorOfFloat.setStartDelay((i >= 5 ? i - 5 : i) * 100);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.TwinFishesSpinner.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TwinFishesSpinner.this.rotates[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (TwinFishesSpinner.this.invalidateListener != null) {
                        TwinFishesSpinner.this.invalidateListener.reDraw();
                    }
                }
            });
            valueAnimatorOfFloat.start();
            i++;
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
