package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.canhub.cropper.CropImageOptionsKt;
import com.wang.avi.Indicator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class BallPulseIndicator extends Indicator {
    public static final float SCALE = 1.0f;
    private float[] scaleFloats = {1.0f, 1.0f, 1.0f};

    @Override // com.wang.avi.Indicator
    public void draw(Canvas canvas, Paint paint) {
        float fMin = (Math.min(getWidth(), getHeight()) - 8.0f) / 6.0f;
        float f2 = 2.0f * fMin;
        float width = (getWidth() / 2) - (f2 + 4.0f);
        float height = getHeight() / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f3 = i;
            canvas.translate((f2 * f3) + width + (f3 * 4.0f), height);
            float f4 = this.scaleFloats[i];
            canvas.scale(f4, f4);
            canvas.drawCircle(0.0f, 0.0f, fMin, paint);
            canvas.restore();
        }
    }

    @Override // com.wang.avi.Indicator
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {120, 240, CropImageOptionsKt.DEGREES_360};
        for (final int i = 0; i < 3; i++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            valueAnimatorOfFloat.setDuration(750L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setStartDelay(iArr[i]);
            addUpdateListener(valueAnimatorOfFloat, new ValueAnimator.AnimatorUpdateListener() { // from class: com.wang.avi.indicators.BallPulseIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseIndicator.this.scaleFloats[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallPulseIndicator.this.postInvalidate();
                }
            });
            arrayList.add(valueAnimatorOfFloat);
        }
        return arrayList;
    }
}
