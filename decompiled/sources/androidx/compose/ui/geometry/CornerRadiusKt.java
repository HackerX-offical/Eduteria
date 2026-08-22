package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: CornerRadius.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CornerRadiusKt {
    public static final long CornerRadius(float f2, float f3) {
        return CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    public static /* synthetic */ long CornerRadius$default(float f2, float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f3 = f2;
        }
        return CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    /* JADX INFO: renamed from: lerp-3Ry4LBc, reason: not valid java name */
    public static final long m5696lerp3Ry4LBc(long j, long j2, float f2) {
        float fLerp = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)), f2);
        float fLerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 & 4294967295L)), f2);
        return CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(fLerp)) << 32) | (((long) Float.floatToRawIntBits(fLerp2)) & 4294967295L));
    }
}
