package androidx.compose.ui.geometry;

import com.appnew.android.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: GeometryUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toStringAsFixed", "", "", "digits", "", "ui-geometry"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class GeometryUtilsKt {
    public static final String toStringAsFixed(float f2, int i) {
        if (Float.isNaN(f2)) {
            return BuildConfig.FAQ_URL;
        }
        if (Float.isInfinite(f2)) {
            return f2 < 0.0f ? "-Infinity" : "Infinity";
        }
        int iMax = Math.max(i, 0);
        float fPow = (float) Math.pow(10.0f, iMax);
        float f3 = f2 * fPow;
        int i2 = (int) f3;
        if (f3 - i2 >= 0.5f) {
            i2++;
        }
        float f4 = i2 / fPow;
        if (iMax > 0) {
            return String.valueOf(f4);
        }
        return String.valueOf((int) f4);
    }
}
