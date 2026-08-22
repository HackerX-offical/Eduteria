package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.window.core.layout.WindowSizeClass;
import com.canhub.cropper.CropImageOptionsKt;
import com.wang.avi.Indicator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class BallSpinFadeLoaderIndicator extends Indicator {
    public static final int ALPHA = 255;
    public static final float SCALE = 1.0f;
    float[] scaleFloats = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    int[] alphas = {255, 255, 255, 255, 255, 255, 255, 255};

    @Override // com.wang.avi.Indicator
    public void draw(Canvas canvas, Paint paint) {
        float width = getWidth() / 10;
        for (int i = 0; i < 8; i++) {
            canvas.save();
            Point pointCircleAt = circleAt(getWidth(), getHeight(), (getWidth() / 2) - width, 0.7853981633974483d * ((double) i));
            canvas.translate(pointCircleAt.x, pointCircleAt.y);
            float f2 = this.scaleFloats[i];
            canvas.scale(f2, f2);
            paint.setAlpha(this.alphas[i]);
            canvas.drawCircle(0.0f, 0.0f, width, paint);
            canvas.restore();
        }
    }

    @Override // com.wang.avi.Indicator
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {0, 120, 240, CropImageOptionsKt.DEGREES_360, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, 600, 720, 780, WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND};
        for (final int i = 0; i < 8; i++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.4f, 1.0f);
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setStartDelay(iArr[i]);
            addUpdateListener(valueAnimatorOfFloat, new ValueAnimator.AnimatorUpdateListener() { // from class: com.wang.avi.indicators.BallSpinFadeLoaderIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallSpinFadeLoaderIndicator.this.scaleFloats[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallSpinFadeLoaderIndicator.this.postInvalidate();
                }
            });
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 77, 255);
            valueAnimatorOfInt.setDuration(1000L);
            valueAnimatorOfInt.setRepeatCount(-1);
            valueAnimatorOfInt.setStartDelay(iArr[i]);
            addUpdateListener(valueAnimatorOfInt, new ValueAnimator.AnimatorUpdateListener() { // from class: com.wang.avi.indicators.BallSpinFadeLoaderIndicator.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallSpinFadeLoaderIndicator.this.alphas[i] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    BallSpinFadeLoaderIndicator.this.postInvalidate();
                }
            });
            arrayList.add(valueAnimatorOfFloat);
            arrayList.add(valueAnimatorOfInt);
        }
        return arrayList;
    }

    Point circleAt(int i, int i2, float f2, double d2) {
        double d3 = f2;
        return new Point((float) (((double) (i / 2)) + (Math.cos(d2) * d3)), (float) (((double) (i2 / 2)) + (d3 * Math.sin(d2))));
    }

    final class Point {
        public float x;
        public float y;

        public Point(float f2, float f3) {
            this.x = f2;
            this.y = f3;
        }
    }
}
