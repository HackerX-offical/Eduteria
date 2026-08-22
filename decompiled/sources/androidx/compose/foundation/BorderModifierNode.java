package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Border.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ,\u0010%\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002JC\u0010-\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b3\u00104J\f\u00105\u001a\u000206*\u000207H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private final boolean isImportantForBounds;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private float width;

    public /* synthetic */ BorderModifierNode(float f2, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, brush, shape);
    }

    private BorderModifierNode(float f2, Brush brush, Shape shape) {
        this.width = f2;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderModifierNode.drawWithCacheModifierNode$lambda$0(this.f$0, (CacheDrawScope) obj);
            }
        }));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* JADX INFO: renamed from: isImportantForBounds, reason: from getter */
    public boolean getIsImportantForBounds() {
        return this.isImportantForBounds;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m340setWidth0680j_4(float f2) {
        if (Dp.m8835equalsimpl0(this.width, f2)) {
            return;
        }
        this.width = f2;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush) {
        if (Intrinsics.areEqual(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
        SemanticsModifierNodeKt.invalidateSemantics(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawWithCacheModifierNode$lambda$0(BorderModifierNode borderModifierNode, CacheDrawScope cacheDrawScope) {
        if (cacheDrawScope.mo488toPx0680j_4(borderModifierNode.width) < 0.0f || Size.m5791getMinDimensionimpl(cacheDrawScope.m5503getSizeNHjbRc()) <= 0.0f) {
            return BorderKt.drawContentWithoutBorder(cacheDrawScope);
        }
        float f2 = 2;
        float fMin = Math.min(Dp.m8835equalsimpl0(borderModifierNode.width, Dp.INSTANCE.m8848getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo488toPx0680j_4(borderModifierNode.width)), (float) Math.ceil(Size.m5791getMinDimensionimpl(cacheDrawScope.m5503getSizeNHjbRc()) / f2));
        float f3 = fMin / f2;
        long jM5715constructorimpl = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (((long) Float.floatToRawIntBits(f3)) << 32));
        long jM5783constructorimpl = Size.m5783constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m5503getSizeNHjbRc() & 4294967295L)) - fMin)) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m5503getSizeNHjbRc() >> 32)) - fMin)) << 32));
        boolean z = f2 * fMin > Size.m5791getMinDimensionimpl(cacheDrawScope.m5503getSizeNHjbRc());
        Outline outlineMo382createOutlinePq9zytI = borderModifierNode.shape.mo382createOutlinePq9zytI(cacheDrawScope.m5503getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        if (outlineMo382createOutlinePq9zytI instanceof Outline.Generic) {
            return borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.brush, (Outline.Generic) outlineMo382createOutlinePq9zytI, z, fMin);
        }
        if (outlineMo382createOutlinePq9zytI instanceof Outline.Rounded) {
            return borderModifierNode.m338drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode.brush, (Outline.Rounded) outlineMo382createOutlinePq9zytI, jM5715constructorimpl, jM5783constructorimpl, z, fMin);
        }
        if (outlineMo382createOutlinePq9zytI instanceof Outline.Rectangle) {
            return BorderKt.m333drawRectBorderNsqcLGU(cacheDrawScope, borderModifierNode.brush, jM5715constructorimpl, jM5783constructorimpl, z, fMin);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Type inference failed for: r25v3, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r44, final androidx.compose.ui.graphics.Brush r45, final androidx.compose.ui.graphics.Outline.Generic r46, boolean r47, float r48) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawGenericBorder$lambda$0(Outline.Generic generic, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m6538drawPathGBMwjPU$default(contentDrawScope, generic.getPath(), brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawGenericBorder$lambda$3(Rect rect, Ref.ObjectRef objectRef, long j, ColorFilter colorFilter, ContentDrawScope contentDrawScope) throws Throwable {
        float f2;
        contentDrawScope.drawContent();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float left = rect.getLeft();
        float top = rect.getTop();
        contentDrawScope2.getDrawContext().getTransform().translate(left, top);
        try {
        } catch (Throwable th) {
            th = th;
            f2 = top;
        }
        try {
            DrawScope.m6532drawImageAZ2fEMs$default(contentDrawScope2, (ImageBitmap) objectRef.element, 0L, j, 0L, 0L, 0.0f, null, colorFilter, 0, 0, 890, null);
            contentDrawScope2.getDrawContext().getTransform().translate(-left, -top);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            left = left;
            f2 = top;
            contentDrawScope2.getDrawContext().getTransform().translate(-left, -f2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    private final DrawResult m338drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f2) {
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long jM5773getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m5773getTopLeftCornerRadiuskKHJgLs();
            final float f3 = f2 / 2;
            final Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BorderModifierNode.drawRoundRectBorder_JqoCqck$lambda$0(z, brush, jM5773getTopLeftCornerRadiuskKHJgLs, f3, f2, j, j2, stroke, (ContentDrawScope) obj);
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        final Path pathCreateRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f2, z);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderModifierNode.drawRoundRectBorder_JqoCqck$lambda$1(pathCreateRoundRectPath, brush, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRoundRectBorder_JqoCqck$lambda$0(boolean z, Brush brush, long j, float f2, float f3, long j2, long j3, Stroke stroke, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (z) {
            DrawScope.m6544drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
        } else if (Float.intBitsToFloat((int) (j >> 32)) < f2) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.mo6549getSizeNHjbRc() >> 32)) - f3;
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.mo6549getSizeNHjbRc() & 4294967295L)) - f3;
            int iM5956getDifferencertfAjoo = ClipOp.INSTANCE.m5956getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo6473clipRectN_I0leg(f3, f3, fIntBitsToFloat, fIntBitsToFloat2, iM5956getDifferencertfAjoo);
                DrawScope.m6544drawRoundRectZuiqVtQ$default(contentDrawScope2, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            }
        } else {
            DrawScope.m6544drawRoundRectZuiqVtQ$default(contentDrawScope, brush, j2, j3, BorderKt.m334shrinkKibmq7A(j, f2), 0.0f, stroke, null, 0, 208, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRoundRectBorder_JqoCqck$lambda$1(Path path, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m6538drawPathGBMwjPU$default(contentDrawScope, path, brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, this.shape);
    }
}
