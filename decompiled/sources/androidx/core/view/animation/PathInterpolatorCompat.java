package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    public static Interpolator create(float f2, float f3) {
        return Api21Impl.createPathInterpolator(f2, f3);
    }

    public static Interpolator create(float f2, float f3, float f4, float f5) {
        return Api21Impl.createPathInterpolator(f2, f3, f4, f5);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        static Interpolator createPathInterpolator(float f2, float f3) {
            return new PathInterpolator(f2, f3);
        }

        static Interpolator createPathInterpolator(float f2, float f3, float f4, float f5) {
            return new PathInterpolator(f2, f3, f4, f5);
        }
    }
}
