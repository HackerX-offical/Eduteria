package custom_animations.interpolators;

import android.graphics.Path;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes9.dex */
public class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        return PathInterpolatorCompatApi21.create(path);
    }

    public static Interpolator create(float f2, float f3) {
        return PathInterpolatorCompatApi21.create(f2, f3);
    }

    public static Interpolator create(float f2, float f3, float f4, float f5) {
        return PathInterpolatorCompatApi21.create(f2, f3, f4, f5);
    }
}
