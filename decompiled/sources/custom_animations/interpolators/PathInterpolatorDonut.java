package custom_animations.interpolators;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes9.dex */
public class PathInterpolatorDonut implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorDonut(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = (int) (length / 0.002f);
        int i2 = i + 1;
        this.mX = new float[i2];
        this.mY = new float[i2];
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < i2; i3++) {
            pathMeasure.getPosTan((i3 * length) / i, fArr, null);
            this.mX[i3] = fArr[0];
            this.mY[i3] = fArr[1];
        }
    }

    public PathInterpolatorDonut(float f2, float f3) {
        this(createQuad(f2, f3));
    }

    public PathInterpolatorDonut(float f2, float f3, float f4, float f5) {
        this(createCubic(f2, f3, f4, f5));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f2 < this.mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.mX;
        float f3 = fArr[length];
        float f4 = fArr[i];
        float f5 = f3 - f4;
        if (f5 == 0.0f) {
            return this.mY[i];
        }
        float f6 = (f2 - f4) / f5;
        float[] fArr2 = this.mY;
        float f7 = fArr2[i];
        return f7 + (f6 * (fArr2[length] - f7));
    }

    private static Path createQuad(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        return path;
    }

    private static Path createCubic(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        return path;
    }
}
