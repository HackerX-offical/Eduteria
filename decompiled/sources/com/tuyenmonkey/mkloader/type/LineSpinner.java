package com.tuyenmonkey.mkloader.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.model.Line;

/* JADX INFO: loaded from: classes9.dex */
public class LineSpinner extends LoaderView {
    private Line[] lines;
    private int numberOfLine = 8;

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void initializeObjects() {
        float fMin = Math.min(this.width, this.height);
        float f2 = fMin / 10.0f;
        this.lines = new Line[this.numberOfLine];
        for (int i = 0; i < this.numberOfLine; i++) {
            this.lines[i] = new Line();
            this.lines[i].setColor(this.color);
            this.lines[i].setAlpha(126);
            this.lines[i].setWidth(f2);
            this.lines[i].setPoint1(new PointF(this.center.x, (this.center.y - (fMin / 2.0f)) + f2));
            this.lines[i].setPoint2(new PointF(this.center.x, this.lines[i].getPoint1().y + (2.0f * f2)));
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void setUpAnimation() {
        for (final int i = 0; i < this.numberOfLine; i++) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(126, 255, 126);
            valueAnimatorOfInt.setRepeatCount(-1);
            valueAnimatorOfInt.setDuration(1000L);
            valueAnimatorOfInt.setStartDelay(i * 120);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tuyenmonkey.mkloader.type.LineSpinner.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LineSpinner.this.lines[i].setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    if (LineSpinner.this.invalidateListener != null) {
                        LineSpinner.this.invalidateListener.reDraw();
                    }
                }
            });
            valueAnimatorOfInt.start();
        }
    }

    @Override // com.tuyenmonkey.mkloader.type.LoaderView
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.numberOfLine; i++) {
            canvas.save();
            canvas.rotate(i * 45, this.center.x, this.center.y);
            this.lines[i].draw(canvas);
            canvas.restore();
        }
    }
}
