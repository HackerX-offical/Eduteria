package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Background.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010-\u001a\u00020.*\u00020/H\u0016J\b\u00100\u001a\u00020.H\u0016J\f\u00101\u001a\u00020.*\u00020/H\u0002J\f\u00102\u001a\u00020.*\u00020/H\u0002J\f\u00103\u001a\u00020**\u00020/H\u0002J\f\u00104\u001a\u00020.*\u000205H\u0016R\u001c\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0010\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/compose/foundation/BackgroundNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "lastSize", "Landroidx/compose/ui/geometry/Size;", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastShape", "tmpOutline", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onObservedReadsChanged", "drawRect", "drawOutline", "getOutline", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class BackgroundNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode, SemanticsModifierNode {
    private float alpha;
    private Brush brush;
    private long color;
    private final boolean isImportantForBounds;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private long lastSize;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private Outline tmpOutline;

    public /* synthetic */ BackgroundNode(long j, Brush brush, float f2, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, brush, f2, shape);
    }

    private BackgroundNode(long j, Brush brush, float f2, Shape shape) {
        this.color = j;
        this.brush = brush;
        this.alpha = f2;
        this.shape = shape;
        this.lastSize = Size.INSTANCE.m5800getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m315setColor8_81llA(long j) {
        this.color = j;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush) {
        this.brush = brush;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f2) {
        this.alpha = f2;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape) {
        this.shape = shape;
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

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect(contentDrawScope);
        } else {
            drawOutline(contentDrawScope);
        }
        contentDrawScope.drawContent();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        this.lastSize = Size.INSTANCE.m5800getUnspecifiedNHjbRc();
        this.lastLayoutDirection = null;
        this.lastOutline = null;
        this.lastShape = null;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final void drawRect(ContentDrawScope contentDrawScope) {
        if (!Color.m5969equalsimpl0(this.color, Color.INSTANCE.m6004getUnspecified0d7_KjU())) {
            DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope, this.color, 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        Brush brush = this.brush;
        if (brush != null) {
            DrawScope.m6542drawRectAsUm42w$default(contentDrawScope, brush, 0L, 0L, this.alpha, null, null, 0, 118, null);
        }
    }

    private final void drawOutline(ContentDrawScope contentDrawScope) {
        Outline outline = getOutline(contentDrawScope);
        if (!Color.m5969equalsimpl0(this.color, Color.INSTANCE.m6004getUnspecified0d7_KjU())) {
            OutlineKt.m6243drawOutlinewDX37Ww$default(contentDrawScope, outline, this.color, 0.0f, null, null, 0, 60, null);
        }
        Brush brush = this.brush;
        if (brush != null) {
            OutlineKt.m6241drawOutlinehn5TExg$default(contentDrawScope, outline, brush, this.alpha, null, null, 0, 56, null);
        }
    }

    private final Outline getOutline(final ContentDrawScope contentDrawScope) {
        Outline outline;
        if (Size.m5788equalsimpl0(contentDrawScope.mo6549getSizeNHjbRc(), this.lastSize) && contentDrawScope.getLayoutDirection() == this.lastLayoutDirection && Intrinsics.areEqual(this.lastShape, this.shape)) {
            outline = this.lastOutline;
            Intrinsics.checkNotNull(outline);
        } else {
            ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.BackgroundNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackgroundNode.getOutline$lambda$0(this.f$0, contentDrawScope);
                }
            });
            outline = this.tmpOutline;
            this.tmpOutline = null;
        }
        this.lastOutline = outline;
        this.lastSize = contentDrawScope.mo6549getSizeNHjbRc();
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
        this.lastShape = this.shape;
        Intrinsics.checkNotNull(outline);
        return outline;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getOutline$lambda$0(BackgroundNode backgroundNode, ContentDrawScope contentDrawScope) {
        backgroundNode.tmpOutline = backgroundNode.shape.mo382createOutlinePq9zytI(contentDrawScope.mo6549getSizeNHjbRc(), contentDrawScope.getLayoutDirection(), contentDrawScope);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setShape(semanticsPropertyReceiver, this.shape);
    }
}
