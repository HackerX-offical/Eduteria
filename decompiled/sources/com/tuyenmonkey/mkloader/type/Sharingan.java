package com.tuyenmonkey.mkloader.type;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tuyenmonkey.mkloader.model.Circle;

/* JADX INFO: loaded from: classes9.dex */
public class Sharingan extends LoaderView {
    private Circle eye;
    private Circle eyeBound;
    private float eyeBoundRadius;
    private float eyeBoundRadiusScale;
    private int numberOfSharingan = 3;
    private float rotate;
    private float scale;
    private Circle[] sharingans;

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        float fMin = Math.min(this.width, this.height) / 2.0f;
        this.eyeBoundRadius = fMin / 1.5f;
        Circle circle = new Circle();
        this.eye = circle;
        circle.setCenter(this.center.x, this.center.y);
        this.eye.setColor(this.color);
        this.eye.setRadius(fMin / 4.0f);
        Circle circle2 = new Circle();
        this.eyeBound = circle2;
        circle2.setCenter(this.center.x, this.center.y);
        this.eyeBound.setColor(this.color);
        this.eyeBound.setRadius(this.eyeBoundRadius);
        this.eyeBound.setStyle(Paint.Style.STROKE);
        this.eyeBound.setWidth(fMin / 20.0f);
        this.sharingans = new Circle[this.numberOfSharingan];
        for (int i = 0; i < this.numberOfSharingan; i++) {
            this.sharingans[i] = new Circle();
            this.sharingans[i].setCenter(this.center.x, this.center.y - this.eyeBoundRadius);
            this.sharingans[i].setColor(this.color);
            this.sharingans[i].setRadius(fMin / 6.0f);
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        valueAnimatorOfFloat.setDuration(1500L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.Sharingan.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Sharingan.this.rotate = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Sharingan.this.invalidateListener != null) {
                    Sharingan.this.invalidateListener.reDraw();
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        valueAnimatorOfFloat2.setDuration(1000L);
        valueAnimatorOfFloat2.setRepeatCount(-1);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.Sharingan.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Sharingan.this.scale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Sharingan.this.invalidateListener != null) {
                    Sharingan.this.invalidateListener.reDraw();
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
        animatorSet.start();
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        canvas.save();
        float f2 = this.scale;
        canvas.scale(f2, f2, this.center.x, this.center.y);
        canvas.rotate(this.rotate, this.center.x, this.center.y);
        this.eye.draw(canvas);
        this.eyeBound.draw(canvas);
        for (int i = 0; i < this.numberOfSharingan; i++) {
            canvas.save();
            canvas.rotate(i * 120, this.center.x, this.center.y);
            this.sharingans[i].draw(canvas);
            canvas.restore();
        }
        canvas.restore();
    }
}
