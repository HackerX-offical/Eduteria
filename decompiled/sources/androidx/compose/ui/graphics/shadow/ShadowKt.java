package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a$\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"lerpNonNull", "Landroidx/compose/ui/graphics/shadow/Shadow;", "a", "b", "t", "", "lerp", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ShadowKt {
    public static final Shadow lerpNonNull(Shadow shadow, Shadow shadow2, float f2) {
        float fM8873lerpMdfbLM = DpKt.m8873lerpMdfbLM(shadow.getRadius(), shadow2.getRadius(), f2);
        float fM8873lerpMdfbLM2 = DpKt.m8873lerpMdfbLM(shadow.getSpread(), shadow2.getSpread(), f2);
        long jM8874lerpxhh869w = DpKt.m8874lerpxhh869w(shadow.getOffset(), shadow2.getOffset(), f2);
        long jM6019lerpjxsXWHM = ColorKt.m6019lerpjxsXWHM(shadow.getColor(), shadow2.getColor(), f2);
        Object objLerp = Interpolatable.INSTANCE.lerp(shadow.getBrush(), shadow2.getBrush(), f2);
        return new Shadow(fM8873lerpMdfbLM, fM8873lerpMdfbLM2, jM8874lerpxhh869w, jM6019lerpjxsXWHM, objLerp instanceof Brush ? (Brush) objLerp : null, MathHelpersKt.lerp(shadow.getAlpha(), shadow2.getAlpha(), f2), f2 < 0.5f ? shadow.getBlendMode() : shadow2.getBlendMode(), (DefaultConstructorMarker) null);
    }

    public static final Shadow lerp(Shadow shadow, Shadow shadow2, float f2) {
        if (shadow == null && shadow2 == null) {
            return null;
        }
        if (shadow != null) {
            return shadow2 == null ? lerpNonNull(shadow, shadow.transparentCopy$ui_graphics(), f2) : lerpNonNull(shadow, shadow2, f2);
        }
        Intrinsics.checkNotNull(shadow2);
        return lerpNonNull(shadow2.transparentCopy$ui_graphics(), shadow2, f2);
    }
}
