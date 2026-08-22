package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002\u001a;\u0010\u0012\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0002\u001a\u001b\u0010%\u001a\u00020&*\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0002¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {Constants.KEY_BORDER, "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "fillArea", "", "strokeWidthPx", "", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "roundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "strokeWidth", "createInsetRoundedRect", "widthPx", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BorderKt {
    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    public static final Modifier border(Modifier modifier, BorderStroke borderStroke, Shape shape) {
        return m332borderziNgDLE(modifier, borderStroke.getWidth(), borderStroke.getBrush(), shape);
    }

    /* JADX INFO: renamed from: border-xT4_qwU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m331borderxT4_qwU$default(Modifier modifier, float f2, long j, Shape shape, int i, Object obj) {
        if ((i & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m330borderxT4_qwU(modifier, f2, j, shape);
    }

    /* JADX INFO: renamed from: border-xT4_qwU, reason: not valid java name */
    public static final Modifier m330borderxT4_qwU(Modifier modifier, float f2, long j, Shape shape) {
        return m332borderziNgDLE(modifier, f2, new SolidColor(j, null), shape);
    }

    /* JADX INFO: renamed from: border-ziNgDLE, reason: not valid java name */
    public static final Modifier m332borderziNgDLE(Modifier modifier, float f2, Brush brush, Shape shape) {
        return modifier.then(new BorderModifierNodeElement(f2, brush, shape, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope cacheDrawScope) {
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderKt.drawContentWithoutBorder$lambda$0((ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawContentWithoutBorder$lambda$0(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawRectBorder-NsqcLGU, reason: not valid java name */
    public static final DrawResult m333drawRectBorderNsqcLGU(CacheDrawScope cacheDrawScope, final Brush brush, long j, long j2, boolean z, float f2) {
        final long jM5739getZeroF1C5BW0 = z ? Offset.INSTANCE.m5739getZeroF1C5BW0() : j;
        final long jM5503getSizeNHjbRc = z ? cacheDrawScope.m5503getSizeNHjbRc() : j2;
        final DrawStyle stroke = z ? Fill.INSTANCE : new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderKt.drawRectBorder_NsqcLGU$lambda$0(brush, jM5739getZeroF1C5BW0, jM5503getSizeNHjbRc, stroke, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRectBorder_NsqcLGU$lambda$0(Brush brush, long j, long j2, DrawStyle drawStyle, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m6542drawRectAsUm42w$default(contentDrawScope, brush, j, j2, 0.0f, drawStyle, null, 0, 104, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path createRoundRectPath(Path path, RoundRect roundRect, float f2, boolean z) {
        path.reset();
        Path.addRoundRect$default(path, roundRect, null, 2, null);
        if (!z) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path, createInsetRoundedRect(f2, roundRect), null, 2, null);
            path.mo5857opN5in7k0(path, Path, PathOperation.INSTANCE.m6276getDifferenceb3I0S0c());
        }
        return path;
    }

    private static final RoundRect createInsetRoundedRect(float f2, RoundRect roundRect) {
        return new RoundRect(f2, f2, roundRect.getWidth() - f2, roundRect.getHeight() - f2, m334shrinkKibmq7A(roundRect.m5773getTopLeftCornerRadiuskKHJgLs(), f2), m334shrinkKibmq7A(roundRect.m5774getTopRightCornerRadiuskKHJgLs(), f2), m334shrinkKibmq7A(roundRect.m5772getBottomRightCornerRadiuskKHJgLs(), f2), m334shrinkKibmq7A(roundRect.m5771getBottomLeftCornerRadiuskKHJgLs(), f2), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m334shrinkKibmq7A(long j, float f2) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f2);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f2);
        return CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L));
    }
}
