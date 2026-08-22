package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: Divider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\t\u001a-\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"HorizontalDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "HorizontalDivider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "VerticalDivider", "VerticalDivider-9IZ8Weo", "Divider", "Divider-9IZ8Weo", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DividerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Divider_9IZ8Weo$lambda$6(Modifier modifier, float f2, long j, int i, int i2, Composer composer, int i3) {
        m2849Divider9IZ8Weo(modifier, f2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalDivider_9IZ8Weo$lambda$2(Modifier modifier, float f2, long j, int i, int i2, Composer composer, int i3) {
        m2850HorizontalDivider9IZ8Weo(modifier, f2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDivider_9IZ8Weo$lambda$5(Modifier modifier, float f2, long j, int i, int i2, Composer composer, int i3) {
        m2851VerticalDivider9IZ8Weo(modifier, f2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: HorizontalDivider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2850HorizontalDivider9IZ8Weo(androidx.compose.ui.Modifier r16, float r17, long r18, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m2850HorizontalDivider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalDivider_9IZ8Weo$lambda$1$lambda$0(float f2, long j, DrawScope drawScope) {
        float f3 = drawScope.mo488toPx0680j_4(f2);
        float f4 = 2;
        DrawScope.m6535drawLineNGM6Ib0$default(drawScope, j, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(drawScope.mo488toPx0680j_4(f2) / f4)) & 4294967295L)), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(drawScope.mo488toPx0680j_4(f2) / f4)) & 4294967295L)), f3, 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: VerticalDivider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2851VerticalDivider9IZ8Weo(androidx.compose.ui.Modifier r16, float r17, long r18, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m2851VerticalDivider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDivider_9IZ8Weo$lambda$4$lambda$3(float f2, long j, DrawScope drawScope) {
        float f3 = drawScope.mo488toPx0680j_4(f2);
        float f4 = 2;
        DrawScope.m6535drawLineNGM6Ib0$default(drawScope, j, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(drawScope.mo488toPx0680j_4(f2) / f4)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(drawScope.mo488toPx0680j_4(f2) / f4)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L)))) & 4294967295L)), f3, 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
    @kotlin.Deprecated(message = "Renamed to HorizontalDivider", replaceWith = @kotlin.ReplaceWith(expression = "HorizontalDivider(modifier, thickness, color)", imports = {}))
    /* JADX INFO: renamed from: Divider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2849Divider9IZ8Weo(androidx.compose.ui.Modifier r14, float r15, long r16, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DividerKt.m2849Divider9IZ8Weo(androidx.compose.ui.Modifier, float, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
