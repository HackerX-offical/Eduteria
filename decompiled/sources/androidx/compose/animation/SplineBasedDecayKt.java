package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: SplineBasedDecay.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Inflection", "", "StartTension", "EndTension", "P1", "P2", "computeSplineInfo", "", "splinePositions", "", "splineTimes", "nbSamples", "", "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", ExifInterface.GPS_DIRECTION_TRUE, "density", "Landroidx/compose/ui/unit/Density;", "animation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SplineBasedDecayKt {
    private static final float EndTension = 1.0f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float StartTension = 0.5f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void computeSplineInfo(float[] fArr, float[] fArr2, int i) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11 = 0.0f;
        int i2 = 0;
        float f12 = 0.0f;
        while (true) {
            float f13 = 1.0f;
            if (i2 < i) {
                float f14 = i2 / i;
                float f15 = 1.0f;
                while (true) {
                    f2 = ((f15 - f11) / 2.0f) + f11;
                    f3 = f13 - f2;
                    f4 = f2 * 3.0f * f3;
                    f5 = f2 * f2 * f2;
                    float f16 = (((f3 * P1) + (f2 * P2)) * f4) + f5;
                    f6 = f13;
                    if (Math.abs(f16 - f14) < 1.0E-5d) {
                        break;
                    }
                    if (f16 > f14) {
                        f15 = f2;
                    } else {
                        f11 = f2;
                    }
                    f13 = f6;
                }
                float f17 = 0.5f;
                fArr[i2] = (f4 * ((f3 * 0.5f) + f2)) + f5;
                float f18 = f6;
                while (true) {
                    f7 = ((f18 - f12) / 2.0f) + f12;
                    f8 = f6 - f7;
                    f9 = f7 * 3.0f * f8;
                    f10 = f7 * f7 * f7;
                    float f19 = (((f8 * f17) + f7) * f9) + f10;
                    float f20 = f14;
                    if (Math.abs(f19 - f14) >= 1.0E-5d) {
                        if (f19 > f20) {
                            f18 = f7;
                        } else {
                            f12 = f7;
                        }
                        f14 = f20;
                        f17 = 0.5f;
                    }
                }
                fArr2[i2] = (f9 * ((f8 * P1) + (f7 * P2))) + f10;
                i2++;
            } else {
                fArr2[i] = 1.0f;
                fArr[i] = 1.0f;
                return;
            }
        }
    }

    public static final <T> DecayAnimationSpec<T> splineBasedDecay(Density density) {
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(density));
    }
}
