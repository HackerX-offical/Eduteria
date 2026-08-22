package androidx.compose.foundation.border;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.unit.IntSize;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BorderLogic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\r\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u001c\u001a\u00020\bH\u0082\bJ7\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00112\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0017\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J)\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00112\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020!H\u0002J)\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00112\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020#H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e¢\u0006\u0002\b\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/foundation/border/BorderLogic;", "", "<init>", "()V", "borderPath", "Landroidx/compose/ui/graphics/Path;", "borderWidth", "Lkotlin/Function0;", "", "lastBrush", "Landroidx/compose/ui/graphics/Brush;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "drawBorder", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawScope", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "brush", "graphicsLayerProvider", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "outline", "offset", "Landroidx/compose/ui/geometry/Offset;", "drawBorder-2gY9BTk$foundation", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Outline;J)V", "strokeWidthPx", "createDrawGenericBorder", "Landroidx/compose/ui/graphics/Outline$Generic;", "obtainPath", "createDrawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "createDrawRectBorder", "Landroidx/compose/ui/graphics/Outline$Rectangle;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderLogic {
    public static final int $stable = 8;
    private Path borderPath;
    private Function0<Float> borderWidth;
    private Function1<? super DrawScope, Unit> drawBorder;
    private Brush lastBrush;
    private Outline lastOutline;

    /* JADX INFO: renamed from: drawBorder-2gY9BTk$foundation, reason: not valid java name */
    public final void m428drawBorder2gY9BTk$foundation(DrawScope drawScope, Function0<Float> width, Brush brush, Function0<GraphicsLayer> graphicsLayerProvider, Outline outline, long offset) {
        Function1<DrawScope, Unit> function1CreateDrawRectBorder;
        this.borderWidth = width;
        if (!Intrinsics.areEqual(brush, this.lastBrush) || !Intrinsics.areEqual(outline, this.lastOutline) || this.drawBorder == null) {
            this.lastBrush = brush;
            this.lastOutline = outline;
            if (outline instanceof Outline.Generic) {
                function1CreateDrawRectBorder = createDrawGenericBorder(brush, graphicsLayerProvider, (Outline.Generic) outline);
            } else if (outline instanceof Outline.Rounded) {
                function1CreateDrawRectBorder = createDrawRoundRectBorder(brush, (Outline.Rounded) outline);
            } else {
                if (!(outline instanceof Outline.Rectangle)) {
                    throw new NoWhenBranchMatchedException();
                }
                function1CreateDrawRectBorder = createDrawRectBorder(brush, (Outline.Rectangle) outline);
            }
            this.drawBorder = function1CreateDrawRectBorder;
        }
        if (Offset.m5720equalsimpl0(offset, Offset.INSTANCE.m5739getZeroF1C5BW0())) {
            Function1<? super DrawScope, Unit> function1 = this.drawBorder;
            Intrinsics.checkNotNull(function1);
            function1.invoke(drawScope);
            return;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (offset >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & offset));
        drawScope.getDrawContext().getTransform().translate(fIntBitsToFloat, fIntBitsToFloat2);
        try {
            Function1<? super DrawScope, Unit> function12 = this.drawBorder;
            Intrinsics.checkNotNull(function12);
            function12.invoke(drawScope);
        } finally {
            drawScope.getDrawContext().getTransform().translate(-fIntBitsToFloat, -fIntBitsToFloat2);
        }
    }

    private final float strokeWidthPx() {
        Function0<Float> function0 = this.borderWidth;
        Intrinsics.checkNotNull(function0);
        return RangesKt.coerceAtLeast(function0.invoke().floatValue(), 0.0f);
    }

    private final Function1<DrawScope, Unit> createDrawGenericBorder(final Brush brush, final Function0<GraphicsLayer> graphicsLayerProvider, final Outline.Generic outline) {
        final Rect bounds = outline.getPath().getBounds();
        final float minDimension = bounds.getMinDimension();
        final Path pathObtainPath = obtainPath();
        pathObtainPath.reset();
        Path.addRect$default(pathObtainPath, bounds, null, 2, null);
        pathObtainPath.mo5857opN5in7k0(pathObtainPath, outline.getPath(), PathOperation.INSTANCE.m6276getDifferenceb3I0S0c());
        final long jM8996constructorimpl = IntSize.m8996constructorimpl((((long) ((int) Math.ceil(bounds.getBottom() - bounds.getTop()))) & 4294967295L) | (((long) ((int) Math.ceil(bounds.getRight() - bounds.getLeft()))) << 32));
        return new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderLogic.createDrawGenericBorder$lambda$1(this.f$0, minDimension, outline, brush, graphicsLayerProvider, bounds, jM8996constructorimpl, pathObtainPath, (DrawScope) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDrawGenericBorder$lambda$1$0$0(Rect rect, Outline.Generic generic, Brush brush, float f2, Path path, DrawScope drawScope) {
        float f3 = -rect.getLeft();
        float f4 = -rect.getTop();
        drawScope.getDrawContext().getTransform().translate(f3, f4);
        try {
            DrawScope.m6538drawPathGBMwjPU$default(drawScope, generic.getPath(), brush, 0.0f, new Stroke(f2 * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
            float f5 = 1;
            float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)) + f5) / Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32));
            float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L)) + f5) / Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L));
            long jMo6548getCenterF1C5BW0 = drawScope.mo6548getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo6477scale0AR0LA0(fIntBitsToFloat, fIntBitsToFloat2, jMo6548getCenterF1C5BW0);
                DrawScope.m6538drawPathGBMwjPU$default(drawScope, path, brush, 0.0f, null, null, BlendMode.INSTANCE.m5881getClear0nO6VwU(), 28, null);
                drawScope.getDrawContext().getTransform().translate(-f3, -f4);
                return Unit.INSTANCE;
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            }
        } catch (Throwable th) {
            drawScope.getDrawContext().getTransform().translate(-f3, -f4);
            throw th;
        }
    }

    private final Path obtainPath() {
        Path path = this.borderPath;
        if (path != null) {
            return path;
        }
        Path Path = AndroidPath_androidKt.Path();
        this.borderPath = Path;
        return Path;
    }

    private final Function1<DrawScope, Unit> createDrawRoundRectBorder(final Brush brush, Outline.Rounded outline) {
        final RoundRect roundRect = outline.getRoundRect();
        if (RoundRectKt.isSimple(roundRect)) {
            return new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BorderLogic.createDrawRoundRectBorder$lambda$0(this.f$0, roundRect, brush, (DrawScope) obj);
                }
            };
        }
        final Path pathObtainPath = obtainPath();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = Float.NaN;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        return new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderLogic.createDrawRoundRectBorder$lambda$1(this.f$0, roundRect, floatRef, objectRef, pathObtainPath, brush, (DrawScope) obj);
            }
        };
    }

    private final Function1<DrawScope, Unit> createDrawRectBorder(final Brush brush, Outline.Rectangle outline) {
        final Rect rect = outline.getRect();
        return new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderLogic.createDrawRectBorder$lambda$0(this.f$0, rect, brush, (DrawScope) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDrawGenericBorder$lambda$1(BorderLogic borderLogic, float f2, final Outline.Generic generic, final Brush brush, Function0 function0, final Rect rect, long j, final Path path, DrawScope drawScope) {
        Function0<Float> function02 = borderLogic.borderWidth;
        Intrinsics.checkNotNull(function02);
        final float fCoerceAtLeast = RangesKt.coerceAtLeast(function02.invoke().floatValue(), 0.0f);
        if (2 * fCoerceAtLeast > f2) {
            DrawScope.m6538drawPathGBMwjPU$default(drawScope, generic.getPath(), brush, 0.0f, null, null, 0, 60, null);
        } else {
            GraphicsLayer graphicsLayer = (GraphicsLayer) function0.invoke();
            graphicsLayer.m6646setCompositingStrategyWpw9cng(CompositingStrategy.INSTANCE.m6631getOffscreenke2Ky5w());
            float left = rect.getLeft();
            float top = rect.getTop();
            drawScope.getDrawContext().getTransform().translate(left, top);
            try {
                drawScope.mo6550recordJVtK1S4(graphicsLayer, j, new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BorderLogic.createDrawGenericBorder$lambda$1$0$0(rect, generic, brush, fCoerceAtLeast, path, (DrawScope) obj);
                    }
                });
                GraphicsLayerKt.drawLayer(drawScope, graphicsLayer);
            } finally {
                drawScope.getDrawContext().getTransform().translate(-left, -top);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDrawRoundRectBorder$lambda$0(BorderLogic borderLogic, RoundRect roundRect, Brush brush, DrawScope drawScope) {
        Function0<Float> function0 = borderLogic.borderWidth;
        Intrinsics.checkNotNull(function0);
        float fCoerceAtLeast = RangesKt.coerceAtLeast(function0.invoke().floatValue(), 0.0f);
        float f2 = 2;
        float f3 = fCoerceAtLeast / f2;
        boolean z = f2 * fCoerceAtLeast > RoundRectKt.getMinDimension(roundRect);
        long jM5773getTopLeftCornerRadiuskKHJgLs = roundRect.m5773getTopLeftCornerRadiuskKHJgLs();
        Stroke stroke = new Stroke(fCoerceAtLeast, 0.0f, 0, 0, null, 30, null);
        if (z) {
            DrawScope.m6544drawRoundRectZuiqVtQ$default(drawScope, brush, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(roundRect.getTop())) & 4294967295L) | (((long) Float.floatToRawIntBits(roundRect.getLeft())) << 32)), Size.m5783constructorimpl((((long) Float.floatToRawIntBits(roundRect.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(roundRect.getWidth())) << 32)), jM5773getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 240, null);
        } else if (Float.intBitsToFloat((int) (jM5773getTopLeftCornerRadiuskKHJgLs >> 32)) < f3) {
            float left = roundRect.getLeft() + fCoerceAtLeast;
            float top = roundRect.getTop() + fCoerceAtLeast;
            float right = roundRect.getRight() - fCoerceAtLeast;
            float bottom = roundRect.getBottom() - fCoerceAtLeast;
            int iM5956getDifferencertfAjoo = ClipOp.INSTANCE.m5956getDifferencertfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo6473clipRectN_I0leg(left, top, right, bottom, iM5956getDifferencertfAjoo);
                DrawScope.m6544drawRoundRectZuiqVtQ$default(drawScope, brush, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(roundRect.getLeft())) << 32) | (((long) Float.floatToRawIntBits(roundRect.getTop())) & 4294967295L)), Size.m5783constructorimpl((4294967295L & ((long) Float.floatToRawIntBits(roundRect.getHeight()))) | (((long) Float.floatToRawIntBits(roundRect.getWidth())) << 32)), jM5773getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 240, null);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            }
        } else {
            DrawScope.m6544drawRoundRectZuiqVtQ$default(drawScope, brush, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(roundRect.getLeft() + f3)) << 32) | (((long) Float.floatToRawIntBits(roundRect.getTop() + f3)) & 4294967295L)), Size.m5783constructorimpl((((long) Float.floatToRawIntBits(roundRect.getHeight() - fCoerceAtLeast)) & 4294967295L) | (((long) Float.floatToRawIntBits(roundRect.getWidth() - fCoerceAtLeast)) << 32)), BorderLogicKt.m430shrinkKibmq7A(jM5773getTopLeftCornerRadiuskKHJgLs, f3), 0.0f, stroke, null, 0, 208, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, androidx.compose.ui.graphics.Path] */
    public static final Unit createDrawRoundRectBorder$lambda$1(BorderLogic borderLogic, RoundRect roundRect, Ref.FloatRef floatRef, Ref.ObjectRef objectRef, Path path, Brush brush, DrawScope drawScope) {
        Function0<Float> function0 = borderLogic.borderWidth;
        Intrinsics.checkNotNull(function0);
        float fCoerceAtLeast = RangesKt.coerceAtLeast(function0.invoke().floatValue(), 0.0f);
        boolean z = ((float) 2) * fCoerceAtLeast > RoundRectKt.getMinDimension(roundRect);
        if (floatRef.element != fCoerceAtLeast) {
            objectRef.element = BorderLogicKt.createRoundRectPath(path, roundRect, fCoerceAtLeast, z);
            floatRef.element = fCoerceAtLeast;
        }
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        DrawScope.m6538drawPathGBMwjPU$default(drawScope, (Path) t, brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDrawRectBorder$lambda$0(BorderLogic borderLogic, Rect rect, Brush brush, DrawScope drawScope) {
        long jM5715constructorimpl;
        long jM5783constructorimpl;
        Function0<Float> function0 = borderLogic.borderWidth;
        Intrinsics.checkNotNull(function0);
        float fCoerceAtLeast = RangesKt.coerceAtLeast(function0.invoke().floatValue(), 0.0f);
        float f2 = 2;
        boolean z = fCoerceAtLeast * f2 > rect.getMinDimension();
        if (z) {
            jM5715constructorimpl = rect.m5758getTopLeftF1C5BW0();
        } else {
            float f3 = fCoerceAtLeast / f2;
            jM5715constructorimpl = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(rect.getTop() + f3)) & 4294967295L) | (((long) Float.floatToRawIntBits(rect.getLeft() + f3)) << 32));
        }
        long j = jM5715constructorimpl;
        if (z) {
            jM5783constructorimpl = rect.m5756getSizeNHjbRc();
        } else {
            jM5783constructorimpl = Size.m5783constructorimpl((4294967295L & ((long) Float.floatToRawIntBits((rect.getBottom() - rect.getTop()) - fCoerceAtLeast))) | (((long) Float.floatToRawIntBits((rect.getRight() - rect.getLeft()) - fCoerceAtLeast)) << 32));
        }
        DrawScope.m6542drawRectAsUm42w$default(drawScope, brush, j, jM5783constructorimpl, 0.0f, z ? Fill.INSTANCE : new Stroke(fCoerceAtLeast, 0.0f, 0, 0, null, 30, null), null, 0, 104, null);
        return Unit.INSTANCE;
    }
}
