package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.shadow.DropShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B(\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010B\u001a\u00020\tH\u0016J\b\u0010C\u001a\u00020\tH\u0016J\b\u0010D\u001a\u00020\tH\u0002J'\u0010E\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nJ\f\u0010F\u001a\u00020\t*\u00020GH\u0016J\b\u0010H\u001a\u00020\u0012H\u0002J\b\u0010I\u001a\u00020\tH\u0016J\b\u0010J\u001a\u00020\tH\u0002J\u0013\u0010K\u001a\u00020\u00142\b\u0010L\u001a\u0004\u0018\u00010MH\u0096\u0002J\b\u0010N\u001a\u00020OH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R@\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR$\u0010 \u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010#R$\u0010$\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010#R&\u0010(\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020'@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R&\u0010/\u001a\u00020.2\u0006\u0010\u0015\u001a\u00020.@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b0\u0010*\"\u0004\b1\u0010,R(\u00103\u001a\u0004\u0018\u0001022\b\u0010\u0015\u001a\u0004\u0018\u000102@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u001b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010#R&\u0010<\u001a\u00020;2\u0006\u0010\u0015\u001a\u00020;@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006P"}, d2 = {"Landroidx/compose/ui/draw/BlockDropShadowNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/draw/DropShadowScope;", "shape", "Landroidx/compose/ui/graphics/Shape;", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;)V", "densityObject", "Landroidx/compose/ui/unit/Density;", "targetShadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadowPainter", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "blockRead", "", "value", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "setBlock", "(Lkotlin/jvm/functions/Function1;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", Constants.KEY_RADIUS, "getRadius", "setRadius", "(F)V", "spread", "getSpread", "setSpread", "Landroidx/compose/ui/geometry/Offset;", "offset", "getOffset-F1C5BW0", "()J", "setOffset-k-4lQ0M", "(J)V", "J", "Landroidx/compose/ui/graphics/Color;", "color", "getColor-0d7_KjU", "setColor-8_81llA", "Landroidx/compose/ui/graphics/Brush;", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "alpha", "getAlpha", "setAlpha", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "onAttach", "onDensityChange", "updateDensity", DiscoverItems.Item.UPDATE_ACTION, "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "obtainPainter", "onObservedReadsChanged", "invalidateShadow", "equals", "other", "", "hashCode", "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockDropShadowNode extends Modifier.Node implements DrawModifierNode, ObserverModifierNode, DropShadowScope {
    public static final int $stable = 0;
    private Function1<? super DropShadowScope, Unit> block;
    private boolean blockRead;
    private Brush brush;
    private Density densityObject;
    private float radius;
    private DropShadowPainter shadowPainter;
    private Shape shape;
    private float spread;
    private Shadow targetShadow;
    private long offset = Offset.INSTANCE.m5739getZeroF1C5BW0();
    private long color = Color.INSTANCE.m5994getBlack0d7_KjU();
    private float alpha = 1.0f;
    private int blendMode = BlendMode.INSTANCE.m5908getSrcOver0nO6VwU();

    public BlockDropShadowNode(Shape shape, Function1<? super DropShadowScope, Unit> function1) {
        this.shape = shape;
        this.block = function1;
    }

    private final void setShape(Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        invalidateShadow();
    }

    private final void setBlock(Function1<? super DropShadowScope, Unit> function1) {
        if (this.block != function1) {
            this.block = function1;
            this.blockRead = false;
            DrawModifierNodeKt.invalidateDraw(this);
        }
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: getDensity */
    public float get_density() {
        Density density = this.densityObject;
        if (density != null) {
            return density.get_density();
        }
        return 1.0f;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: getFontScale */
    public float get_fontScale() {
        Density density = this.densityObject;
        if (density != null) {
            return density.get_fontScale();
        }
        return 1.0f;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public float getRadius() {
        return this.radius;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public void setRadius(float f2) {
        if (this.radius == f2) {
            return;
        }
        this.radius = f2;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public float getSpread() {
        return this.spread;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public void setSpread(float f2) {
        if (this.spread == f2) {
            return;
        }
        this.spread = f2;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name and from getter */
    public long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* JADX INFO: renamed from: setOffset-k-4lQ0M, reason: not valid java name */
    public void mo5487setOffsetk4lQ0M(long j) {
        if (Offset.m5720equalsimpl0(this.offset, j)) {
            return;
        }
        this.offset = j;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public long getColor() {
        return this.color;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public void mo5486setColor8_81llA(long j) {
        if (j == 16) {
            j = Color.INSTANCE.m5994getBlack0d7_KjU();
        }
        if (Color.m5969equalsimpl0(this.color, j)) {
            return;
        }
        this.color = j;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public Brush getBrush() {
        return this.brush;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public void setBrush(Brush brush) {
        if (Intrinsics.areEqual(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    public void setAlpha(float f2) {
        if (this.alpha == f2) {
            return;
        }
        this.alpha = f2;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.draw.ShadowScope
    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public void mo5485setBlendModes9anfk8(int i) {
        if (BlendMode.m5877equalsimpl0(this.blendMode, i)) {
            return;
        }
        this.blendMode = i;
        invalidateShadow();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        updateDensity();
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        if (getIsAttached()) {
            updateDensity();
        }
    }

    private final void updateDensity() {
        Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
        if (Intrinsics.areEqual(this.densityObject, densityRequireDensity)) {
            return;
        }
        this.densityObject = densityRequireDensity;
        this.blockRead = false;
        invalidateShadow();
    }

    public final void update(Shape shape, Function1<? super DropShadowScope, Unit> block) {
        setShape(shape);
        setBlock(block);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Painter.m6674drawx_KDEd0$default(obtainPainter(), contentDrawScope, contentDrawScope.mo6549getSizeNHjbRc(), 0.0f, null, 6, null);
        contentDrawScope.drawContent();
    }

    private final DropShadowPainter obtainPainter() {
        Shadow shadow;
        if (!this.blockRead) {
            this.blockRead = true;
            ShadowKt.resetShadow(this);
            ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.draw.BlockDropShadowNode.obtainPainter.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BlockDropShadowNode.this.block.invoke(BlockDropShadowNode.this);
                }
            });
        }
        Shadow shadow2 = this.targetShadow;
        DropShadowPainter dropShadowPainter = this.shadowPainter;
        Brush brush = getBrush();
        float f2 = mo484toDpu2uoSUM(getRadius());
        float f3 = mo484toDpu2uoSUM(getSpread());
        float f4 = mo484toDpu2uoSUM(Float.intBitsToFloat((int) (getOffset() >> 32)));
        long jM8886constructorimpl = DpOffset.m8886constructorimpl((((long) Float.floatToRawIntBits(mo484toDpu2uoSUM(Float.intBitsToFloat((int) (getOffset() & 4294967295L))))) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32));
        if (dropShadowPainter != null && shadow2 != null && Dp.m8835equalsimpl0(shadow2.getRadius(), f2) && Dp.m8835equalsimpl0(shadow2.getSpread(), f3) && Color.m5969equalsimpl0(shadow2.getColor(), getColor()) && Intrinsics.areEqual(shadow2.getBrush(), brush) && shadow2.getAlpha() == getAlpha() && BlendMode.m5877equalsimpl0(shadow2.getBlendMode(), getBlendMode()) && DpOffset.m8890equalsimpl0(shadow2.getOffset(), jM8886constructorimpl)) {
            return dropShadowPainter;
        }
        if (brush != null) {
            shadow = new Shadow(f2, brush, f3, jM8886constructorimpl, getAlpha(), getBlendMode(), (DefaultConstructorMarker) null);
        } else {
            shadow = new Shadow(f2, getColor(), f3, jM8886constructorimpl, getAlpha(), getBlendMode(), (DefaultConstructorMarker) null);
        }
        this.targetShadow = shadow;
        DropShadowPainter dropShadowPainterCreateDropShadowPainter = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createDropShadowPainter(this.shape, shadow);
        this.shadowPainter = dropShadowPainterCreateDropShadowPainter;
        return dropShadowPainterCreateDropShadowPainter;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        this.blockRead = false;
        invalidateShadow();
    }

    private final void invalidateShadow() {
        this.targetShadow = null;
        this.shadowPainter = null;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof BlockDropShadowNode)) {
            BlockDropShadowNode blockDropShadowNode = (BlockDropShadowNode) other;
            return getAlpha() == blockDropShadowNode.getAlpha() && Intrinsics.areEqual(this.shape, blockDropShadowNode.shape) && this.block == blockDropShadowNode.block && getRadius() == blockDropShadowNode.getRadius() && getSpread() == blockDropShadowNode.getSpread() && Offset.m5720equalsimpl0(getOffset(), blockDropShadowNode.getOffset()) && Color.m5969equalsimpl0(getColor(), blockDropShadowNode.getColor()) && Intrinsics.areEqual(getBrush(), blockDropShadowNode.getBrush()) && BlendMode.m5877equalsimpl0(getBlendMode(), blockDropShadowNode.getBlendMode());
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Float.hashCode(getAlpha()) * 31) + this.shape.hashCode()) * 31) + this.block.hashCode()) * 31) + Float.hashCode(getRadius())) * 31) + Float.hashCode(getSpread())) * 31) + Offset.m5725hashCodeimpl(getOffset())) * 31) + Color.m5975hashCodeimpl(getColor())) * 31;
        Brush brush = getBrush();
        return ((iHashCode + (brush != null ? brush.hashCode() : 0)) * 31) + BlendMode.m5878hashCodeimpl(getBlendMode());
    }
}
