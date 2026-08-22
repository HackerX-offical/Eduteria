package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.canhub.cropper.CropImageOptionsKt;
import com.tuyenmonkey.mkloader.model.Arc;

/* JADX INFO: loaded from: classes9.dex */
public class Whirlpool extends LoaderView {
    private Arc[] arcs;
    private int numberOfArc = 3;
    private float[] rotates;

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        float fMin = Math.min(this.width, this.height) / 2.0f;
        int i = this.numberOfArc;
        this.arcs = new Arc[i];
        this.rotates = new float[i];
        for (int i2 = 0; i2 < this.numberOfArc; i2++) {
            float f2 = (fMin / 4.0f) + ((i2 * fMin) / 4.0f);
            this.arcs[i2] = new Arc();
            this.arcs[i2].setColor(this.color);
            this.arcs[i2].setOval(new RectF(this.center.x - f2, this.center.y - f2, this.center.x + f2, this.center.y + f2));
            this.arcs[i2].setStartAngle(i2 * 45);
            this.arcs[i2].setSweepAngle(r3 + 90);
            this.arcs[i2].setStyle(Paint.Style.STROKE);
            this.arcs[i2].setWidth(fMin / 10.0f);
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        for (final int i = this.numberOfArc - 1; i >= 0; i--) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.arcs[i].getStartAngle(), this.arcs[i].getStartAngle() + ((i % 2 == 0 ? -1 : 1) * CropImageOptionsKt.DEGREES_360));
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setDuration((i + 1) * 500);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.Whirlpool.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Whirlpool.this.rotates[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (Whirlpool.this.invalidateListener != null) {
                        Whirlpool.this.invalidateListener.reDraw();
                    }
                }
            });
            valueAnimatorOfFloat.start();
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.numberOfArc; i++) {
            canvas.save();
            canvas.rotate(this.rotates[i], this.center.x, this.center.y);
            this.arcs[i].draw(canvas);
            canvas.restore();
        }
    }
}
