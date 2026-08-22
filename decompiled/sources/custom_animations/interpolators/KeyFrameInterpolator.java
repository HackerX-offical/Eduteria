package custom_animations.interpolators;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes9.dex */
public class KeyFrameInterpolator implements Interpolator {
    private float[] fractions;
    private TimeInterpolator interpolator;

    public static KeyFrameInterpolator easeInOut(float... fArr) {
        KeyFrameInterpolator keyFrameInterpolator = new KeyFrameInterpolator(Ease.inOut(), new float[0]);
        keyFrameInterpolator.setFractions(fArr);
        return keyFrameInterpolator;
    }

    public static KeyFrameInterpolator pathInterpolator(float f2, float f3, float f4, float f5, float... fArr) {
        KeyFrameInterpolator keyFrameInterpolator = new KeyFrameInterpolator(PathInterpolatorCompat.create(f2, f3, f4, f5), new float[0]);
        keyFrameInterpolator.setFractions(fArr);
        return keyFrameInterpolator;
    }

    public KeyFrameInterpolator(TimeInterpolator timeInterpolator, float... fArr) {
        this.interpolator = timeInterpolator;
        this.fractions = fArr;
    }

    public void setFractions(float... fArr) {
        this.fractions = fArr;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (this.fractions.length > 1) {
            int i = 0;
            while (true) {
                float[] fArr = this.fractions;
                if (i >= fArr.length - 1) {
                    break;
                }
                float f3 = fArr[i];
                i++;
                float f4 = fArr[i];
                float f5 = f4 - f3;
                if (f2 >= f3 && f2 <= f4) {
                    return f3 + (this.interpolator.getInterpolation((f2 - f3) / f5) * f5);
                }
            }
        }
        return this.interpolator.getInterpolation(f2);
    }
}
