package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.wang.avi.Indicator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class CubeTransitionIndicator extends Indicator {
    float degrees;
    float[] translateX = new float[2];
    float[] translateY = new float[2];
    float scaleFloat = 1.0f;

    @Override // com.wang.avi.Indicator
    public void draw(Canvas canvas, Paint paint) {
        float width = getWidth() / 5;
        float height = getHeight() / 5;
        for (int i = 0; i < 2; i++) {
            canvas.save();
            canvas.translate(this.translateX[i], this.translateY[i]);
            canvas.rotate(this.degrees);
            float f2 = this.scaleFloat;
            canvas.scale(f2, f2);
            canvas.drawRect(new RectF((-width) / 2.0f, (-height) / 2.0f, width / 2.0f, height / 2.0f), paint);
            canvas.restore();
        }
    }

    @Override // com.wang.avi.Indicator
    public ArrayList<ValueAnimator> onCreateAnimators() {
        char c2;
        char c3;
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        float width = getWidth() / 5;
        float height = getHeight() / 5;
        char c4 = 0;
        final int i = 0;
        while (i < 2) {
            this.translateX[i] = width;
            float[] fArr = new float[5];
            fArr[c4] = width;
            fArr[1] = getWidth() - width;
            fArr[2] = getWidth() - width;
            fArr[3] = width;
            fArr[4] = width;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            if (i == 1) {
                c2 = c4;
                c3 = 2;
                float[] fArr2 = new float[5];
                fArr2[c2] = getWidth() - width;
                fArr2[1] = width;
                fArr2[2] = width;
                fArr2[3] = getWidth() - width;
                fArr2[4] = getWidth() - width;
                valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr2);
            } else {
                c2 = c4;
                c3 = 2;
            }
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.setDuration(1600L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.wang.avi.indicators.CubeTransitionIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CubeTransitionIndicator.this.translateX[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CubeTransitionIndicator.this.postInvalidate();
                }
            });
            this.translateY[i] = height;
            float[] fArr3 = new float[5];
            fArr3[c2] = height;
            fArr3[1] = height;
            fArr3[c3] = getHeight() - height;
            fArr3[3] = getHeight() - height;
            fArr3[4] = height;
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(fArr3);
            if (i == 1) {
                float[] fArr4 = new float[5];
                fArr4[c2] = getHeight() - height;
                fArr4[1] = getHeight() - height;
                fArr4[c3] = height;
                fArr4[3] = height;
                fArr4[4] = getHeight() - height;
                valueAnimatorOfFloat2 = ValueAnimator.ofFloat(fArr4);
            }
            valueAnimatorOfFloat2.setDuration(1600L);
            valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat2.setRepeatCount(-1);
            addUpdateListener(valueAnimatorOfFloat2, new ValueAnimator.AnimatorUpdateListener() { // from class: com.wang.avi.indicators.CubeTransitionIndicator.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CubeTransitionIndicator.this.translateY[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CubeTransitionIndicator.this.postInvalidate();
                }
            });
            arrayList.add(valueAnimatorOfFloat);
            arrayList.add(valueAnimatorOfFloat2);
            i++;
            c4 = c2;
        }
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.5f, 1.0f, 0.5f, 1.0f);
        valueAnimatorOfFloat3.setDuration(1600L);
        valueAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat3.setRepeatCount(-1);
        addUpdateListener(valueAnimatorOfFloat3, new ValueAnimator.AnimatorUpdateListener() { // from class: com.wang.avi.indicators.CubeTransitionIndicator.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CubeTransitionIndicator.this.scaleFloat = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CubeTransitionIndicator.this.postInvalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(0.0f, 180.0f, 360.0f, 540.0f, 720.0f);
        valueAnimatorOfFloat4.setDuration(1600L);
        valueAnimatorOfFloat4.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat4.setRepeatCount(-1);
        addUpdateListener(valueAnimatorOfFloat4, new ValueAnimator.AnimatorUpdateListener() { // from class: com.wang.avi.indicators.CubeTransitionIndicator.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CubeTransitionIndicator.this.degrees = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CubeTransitionIndicator.this.postInvalidate();
            }
        });
        arrayList.add(valueAnimatorOfFloat3);
        arrayList.add(valueAnimatorOfFloat4);
        return arrayList;
    }
}
