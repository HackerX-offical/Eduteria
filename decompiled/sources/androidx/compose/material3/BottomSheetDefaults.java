package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u000bH\u0007¢\u0006\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0015\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0017\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001e\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b \u0010\u0011¨\u0006+"}, d2 = {"Landroidx/compose/material3/BottomSheetDefaults;", "", "<init>", "()V", "HiddenShape", "Landroidx/compose/ui/graphics/Shape;", "getHiddenShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "ExpandedShape", "getExpandedShape", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ScrimColor", "getScrimColor", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "SheetMaxWidth", "getSheetMaxWidth-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "PositionalThreshold", "getPositionalThreshold-D9Ej5fM$material3", "VelocityThreshold", "getVelocityThreshold-D9Ej5fM$material3", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetDefaults {
    public static final int $stable = 0;
    private static final float PositionalThreshold;
    private static final float SheetPeekHeight;
    public static final BottomSheetDefaults INSTANCE = new BottomSheetDefaults();
    private static final float Elevation = SheetBottomTokens.INSTANCE.m4779getDockedModalContainerElevationD9Ej5fM();
    private static final float SheetMaxWidth = Dp.m8830constructorimpl(640);
    private static final float VelocityThreshold = Dp.m8830constructorimpl(125);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandle_lgZ2HuY$lambda$2(BottomSheetDefaults bottomSheetDefaults, Modifier modifier, float f2, float f3, Shape shape, long j, int i, int i2, Composer composer, int i3) {
        bottomSheetDefaults.m2487DragHandlelgZ2HuY(modifier, f2, f3, shape, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private BottomSheetDefaults() {
    }

    public final Shape getHiddenShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1971658024, "C(<get-HiddenShape>)375@15714L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1971658024, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:375)");
        }
        Shape value = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExpandedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1683783414, "C(<get-ExpandedShape>)379@15912L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1683783414, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:379)");
        }
        Shape value = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 433375448, "C(<get-ContainerColor>)383@16075L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(433375448, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:383)");
        }
        long value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    static {
        float f2 = 56;
        SheetPeekHeight = Dp.m8830constructorimpl(f2);
        PositionalThreshold = Dp.m8830constructorimpl(f2);
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2488getElevationD9Ej5fM() {
        return Elevation;
    }

    public final long getScrimColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2040719176, "C(<get-ScrimColor>)390@16359L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2040719176, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:390)");
        }
        long jM5967copywmQWz5c$default = Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM5967copywmQWz5c$default;
    }

    /* JADX INFO: renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m2491getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }

    /* JADX INFO: renamed from: getSheetMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m2490getSheetMaxWidthD9Ej5fM() {
        return SheetMaxWidth;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -511309409, "C(<get-windowInsets>)401@16789L11:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511309409, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:401)");
        }
        WindowInsets windowInsetsM1250onlybOOhFvg = WindowInsetsKt.m1250onlybOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1266plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1274getBottomJoeWqyM(), WindowInsetsSides.INSTANCE.m1280getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1250onlybOOhFvg;
    }

    /* JADX INFO: renamed from: getPositionalThreshold-D9Ej5fM$material3, reason: not valid java name */
    public final float m2489getPositionalThresholdD9Ej5fM$material3() {
        return PositionalThreshold;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM$material3, reason: not valid java name */
    public final float m2492getVelocityThresholdD9Ej5fM$material3() {
        return VelocityThreshold;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae  */
    /* JADX INFO: renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2487DragHandlelgZ2HuY(androidx.compose.ui.Modifier r23, float r24, float r25, androidx.compose.ui.graphics.Shape r26, long r27, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetDefaults.m2487DragHandlelgZ2HuY(androidx.compose.ui.Modifier, float, float, androidx.compose.ui.graphics.Shape, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandle_lgZ2HuY$lambda$1$lambda$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }
}
