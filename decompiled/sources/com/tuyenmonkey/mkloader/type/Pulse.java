package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.exception.InvalidNumberOfPulseException;
import com.tuyenmonkey.mkloader.model.Line;

/* JADX INFO: loaded from: classes9.dex */
public class Pulse extends LoaderView {
    private float lineDistance;
    private float lineWidth;
    private Line[] lines;
    private int numberOfLines;
    private float[] scaleY;

    public Pulse(int i) throws InvalidNumberOfPulseException {
        if (i < 3 || i > 5) {
            throw new InvalidNumberOfPulseException();
        }
        this.numberOfLines = i;
        this.lines = new Line[i];
        this.scaleY = new float[i];
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        float f2 = this.width / (this.numberOfLines * 2);
        this.lineWidth = f2;
        this.lineDistance = f2 / 4.0f;
        float f3 = this.width;
        float f4 = this.lineWidth;
        float f5 = ((f3 - ((this.numberOfLines * f4) + (this.lineDistance * (r3 - 1)))) / 2.0f) + (f4 / 2.0f);
        for (int i = 0; i < this.numberOfLines; i++) {
            this.lines[i] = new Line();
            this.lines[i].setColor(this.color);
            this.lines[i].setWidth(this.lineWidth);
            this.lines[i].setPoint1(new PointF(f5, this.center.y - (this.height / 4.0f)));
            this.lines[i].setPoint2(new PointF(f5, this.center.y + (this.height / 4.0f)));
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        for (final int i = 0; i < this.numberOfLines; i++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.5f, 1.0f);
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.setStartDelay(i * 120);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.Pulse.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Pulse.this.scaleY[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (Pulse.this.invalidateListener != null) {
                        Pulse.this.invalidateListener.reDraw();
                    }
                }
            });
            valueAnimatorOfFloat.start();
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.numberOfLines; i++) {
            canvas.save();
            canvas.translate(i * (this.lineWidth + this.lineDistance), 0.0f);
            canvas.scale(1.0f, this.scaleY[i], this.lines[i].getPoint1().x, this.center.y);
            this.lines[i].draw(canvas);
            canvas.restore();
        }
    }
}
