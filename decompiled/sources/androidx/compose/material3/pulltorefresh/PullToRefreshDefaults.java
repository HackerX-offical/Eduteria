package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jo\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010(\u001a\u00020\u00152\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 0*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007¢\u0006\u0004\b.\u0010/JG\u00100\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\u0015H\u0007¢\u0006\u0004\b2\u00103R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0014\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u001b\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\u001d\u001a\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017¨\u00064"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape$annotations", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "indicatorShape", "getIndicatorShape", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "indicatorContainerColor", "getIndicatorContainerColor", "indicatorColor", "getIndicatorColor", "PositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "getPositionalThreshold-D9Ej5fM", "()F", "F", "IndicatorMaxDistance", "getIndicatorMaxDistance-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM", "LoadingIndicatorElevation", "getLoadingIndicatorElevation-D9Ej5fM", "IndicatorBox", "", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "modifier", "Landroidx/compose/ui/Modifier;", "maxDistance", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "IndicatorBox-1CPYgEU", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;JFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Indicator", "color", "Indicator-2poqoh4", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;JJFLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PullToRefreshDefaults {
    public static final int $stable = 0;
    private static final float Elevation;
    private static final float IndicatorMaxDistance;
    private static final float LoadingIndicatorElevation;
    private static final float PositionalThreshold;
    public static final PullToRefreshDefaults INSTANCE = new PullToRefreshDefaults();
    private static final Shape shape = RoundedCornerShapeKt.getCircleShape();
    private static final Shape indicatorShape = RoundedCornerShapeKt.getCircleShape();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorBox_1CPYgEU$lambda$7(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, float f2, Shape shape2, long j, float f3, Function3 function3, int i, int i2, Composer composer, int i3) {
        pullToRefreshDefaults.m4159IndicatorBox1CPYgEU(pullToRefreshState, z, modifier, f2, shape2, j, f3, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Indicator_2poqoh4$lambda$8(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, long j, long j2, float f2, int i, int i2, Composer composer, int i3) {
        pullToRefreshDefaults.m4158Indicator2poqoh4(pullToRefreshState, z, modifier, j, j2, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Use indicatorContainerColor instead", replaceWith = @ReplaceWith(expression = "indicatorContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Deprecated(message = "Use indicatorShape instead", replaceWith = @ReplaceWith(expression = "indicatorShape", imports = {}))
    public static /* synthetic */ void getShape$annotations() {
    }

    private PullToRefreshDefaults() {
    }

    public final Shape getShape() {
        return shape;
    }

    static {
        float fM8830constructorimpl = Dp.m8830constructorimpl(80);
        PositionalThreshold = fM8830constructorimpl;
        IndicatorMaxDistance = fM8830constructorimpl;
        Elevation = ElevationTokens.INSTANCE.m4425getLevel2D9Ej5fM();
        LoadingIndicatorElevation = ElevationTokens.INSTANCE.m4423getLevel0D9Ej5fM();
    }

    public final Shape getIndicatorShape() {
        return indicatorShape;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1066257972, "C(<get-containerColor>)405@15435L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066257972, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:405)");
        }
        long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurfaceContainerHigh();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return surfaceContainerHigh;
    }

    public final long getIndicatorContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -80510850, "C(<get-indicatorContainerColor>)409@15605L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-80510850, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorContainerColor> (PullToRefresh.kt:409)");
        }
        long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurfaceContainerHigh();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return surfaceContainerHigh;
    }

    public final long getIndicatorColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1441334156, "C(<get-indicatorColor>)413@15766L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1441334156, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorColor> (PullToRefresh.kt:413)");
        }
        long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getOnSurfaceVariant();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return onSurfaceVariant;
    }

    /* JADX INFO: renamed from: getPositionalThreshold-D9Ej5fM, reason: not valid java name */
    public final float m4163getPositionalThresholdD9Ej5fM() {
        return PositionalThreshold;
    }

    /* JADX INFO: renamed from: getIndicatorMaxDistance-D9Ej5fM, reason: not valid java name */
    public final float m4161getIndicatorMaxDistanceD9Ej5fM() {
        return IndicatorMaxDistance;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m4160getElevationD9Ej5fM() {
        return Elevation;
    }

    /* JADX INFO: renamed from: getLoadingIndicatorElevation-D9Ej5fM, reason: not valid java name */
    public final float m4162getLoadingIndicatorElevationD9Ej5fM() {
        return LoadingIndicatorElevation;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX INFO: renamed from: IndicatorBox-1CPYgEU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m4159IndicatorBox1CPYgEU(final androidx.compose.material3.pulltorefresh.PullToRefreshState r23, final boolean r24, androidx.compose.ui.Modifier r25, float r26, androidx.compose.ui.graphics.Shape r27, long r28, float r30, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.m4159IndicatorBox1CPYgEU(androidx.compose.material3.pulltorefresh.PullToRefreshState, boolean, androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorBox_1CPYgEU$lambda$2$lambda$1(ContentDrawScope contentDrawScope) {
        int iM5957getIntersectrtfAjoo = ClipOp.INSTANCE.m5957getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6473clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, iM5957getIntersectrtfAjoo);
            contentDrawScope.drawContent();
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult IndicatorBox_1CPYgEU$lambda$6$lambda$5(final PullToRefreshState pullToRefreshState, final boolean z, final float f2, final float f3, final Shape shape2, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4(placeableMo7445measureBRTryo0, pullToRefreshState, z, f2, f3, shape2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4(Placeable placeable, final PullToRefreshState pullToRefreshState, final boolean z, final float f2, final float f3, final Shape shape2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4$lambda$3(pullToRefreshState, z, f2, f3, shape2, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4$lambda$3(PullToRefreshState pullToRefreshState, boolean z, float f2, float f3, Shape shape2, GraphicsLayerScope graphicsLayerScope) {
        boolean z2 = pullToRefreshState.getDistanceFraction() > 0.0f || z;
        graphicsLayerScope.setTranslationY((pullToRefreshState.getDistanceFraction() * graphicsLayerScope.mo482roundToPx0680j_4(f2)) - Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)));
        graphicsLayerScope.setShadowElevation(z2 ? graphicsLayerScope.mo488toPx0680j_4(f3) : 0.0f);
        graphicsLayerScope.setShape(shape2);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX INFO: renamed from: Indicator-2poqoh4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m4158Indicator2poqoh4(final androidx.compose.material3.pulltorefresh.PullToRefreshState r18, final boolean r19, androidx.compose.ui.Modifier r20, long r21, long r23, float r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.m4158Indicator2poqoh4(androidx.compose.material3.pulltorefresh.PullToRefreshState, boolean, androidx.compose.ui.Modifier, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
