package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import com.tuyenmonkey.mkloader.model.Circle;

/* JADX INFO: loaded from: classes9.dex */
public class Worm extends LoaderView {
    private Circle[] circles;
    private float radius;
    private int circlesSize = 5;
    private int[] transformations = {-2, -1, 0, 1, 2};

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        this.circles = new Circle[this.circlesSize];
        this.radius = (this.width / 10.0f) - (this.width / 100.0f);
        for (int i = 0; i < this.circlesSize; i++) {
            this.circles[i] = new Circle();
            this.circles[i].setColor(this.color);
            this.circles[i].setRadius(this.radius);
            this.circles[i].setCenter(this.center.x, this.center.y);
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        for (final int i = 0; i < this.circlesSize; i++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.center.y, this.height / 4.0f, (this.height * 3) / 4.0f, this.center.y);
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.setStartDelay(i * 120);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.Worm.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Worm.this.circles[i].setCenter(Worm.this.center.x, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (Worm.this.invalidateListener != null) {
                        Worm.this.invalidateListener.reDraw();
                    }
                }
            });
            valueAnimatorOfFloat.start();
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.circlesSize; i++) {
            canvas.save();
            canvas.translate(this.radius * 2.0f * this.transformations[i], 0.0f);
            this.circles[i].draw(canvas);
            canvas.restore();
        }
    }
}
