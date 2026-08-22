package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LookaheadLayoutCoordinates.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b(\u0010%J\u0017\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020 H\u0016¢\u0006\u0004\b+\u0010%J\u0017\u0010,\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b-\u0010%J\u0017\u0010.\u001a\u00020 2\u0006\u0010'\u001a\u00020 H\u0016¢\u0006\u0004\b/\u0010%J\u001f\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020 H\u0016¢\u0006\u0004\b3\u00104J'\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020 2\u0006\u00105\u001a\u00020\u001bH\u0016¢\u0006\u0004\b6\u00107J\u0018\u00108\u001a\u0002092\u0006\u00101\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u001bH\u0016J\u001f\u0010;\u001a\u00020<2\u0006\u00101\u001a\u00020\u00012\u0006\u0010=\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016¢\u0006\u0004\bB\u0010CJ\u0011\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0012H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000f¨\u0006G"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "<init>", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentCoordinates", "getParentCoordinates", "isAttached", "", "()Z", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "localToScreen", "relativeToLocal", "localToScreen-MK-Hz9U", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "localToRoot", "localToRoot-MK-Hz9U", "localPositionOf", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "clipBounds", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "get", "", "alignmentLine", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public static final int $stable = 0;
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo7453getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return IntSize.m8996constructorimpl((((long) lookaheadDelegate.getWidth()) << 32) | (((long) lookaheadDelegate.getHeight()) & 4294967295L));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy = getCoordinator().getLayoutNode().getOuterCoordinator$ui().getWrappedBy();
        if (wrappedBy == null || (lookaheadDelegate = wrappedBy.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy = getCoordinator().getWrappedBy();
        if (wrappedBy == null || (lookaheadDelegate = wrappedBy.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean getIntroducesMotionFrameOfReference() {
        return this.lookaheadDelegate.getIsPlacedUnderMotionFrameOfReference();
    }

    /* JADX INFO: renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    private final long m7474getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        return Offset.m5727minusMKHz9U(mo7454localPositionOfR5De75A(rootLookaheadDelegate.getCoordinates(), Offset.INSTANCE.m5739getZeroF1C5BW0()), getCoordinator().mo7454localPositionOfR5De75A(rootLookaheadDelegate.getCoordinator(), Offset.INSTANCE.m5739getZeroF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public long mo7459screenToLocalMKHz9U(long relativeToScreen) {
        return Offset.m5728plusMKHz9U(getCoordinator().mo7459screenToLocalMKHz9U(relativeToScreen), m7474getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public long mo7457localToScreenMKHz9U(long relativeToLocal) {
        return getCoordinator().mo7457localToScreenMKHz9U(Offset.m5728plusMKHz9U(relativeToLocal, m7474getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo7462windowToLocalMKHz9U(long relativeToWindow) {
        return Offset.m5728plusMKHz9U(getCoordinator().mo7462windowToLocalMKHz9U(relativeToWindow), m7474getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo7458localToWindowMKHz9U(long relativeToLocal) {
        return getCoordinator().mo7458localToWindowMKHz9U(Offset.m5728plusMKHz9U(relativeToLocal, m7474getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo7456localToRootMKHz9U(long relativeToLocal) {
        return getCoordinator().mo7456localToRootMKHz9U(Offset.m5728plusMKHz9U(relativeToLocal, m7474getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo7454localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return mo7455localPositionOfS_NoaFU(sourceCoordinates, relativeToSource, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-S_NoaFU */
    public long mo7455localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        if (sourceCoordinates instanceof LookaheadLayoutCoordinates) {
            LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinates) sourceCoordinates).lookaheadDelegate;
            lookaheadDelegate.getCoordinator().onCoordinatesUsed$ui();
            LookaheadDelegate lookaheadDelegate2 = getCoordinator().findCommonAncestor$ui(lookaheadDelegate.getCoordinator()).getLookaheadDelegate();
            if (lookaheadDelegate2 != null) {
                long jM8961minusqkQi6aY = IntOffset.m8961minusqkQi6aY(IntOffset.m8962plusqkQi6aY(lookaheadDelegate.m7702positionIniSbpLlY$ui(lookaheadDelegate2, !includeMotionFrameOfReference), IntOffsetKt.m8975roundk4lQ0M(relativeToSource)), this.lookaheadDelegate.m7702positionIniSbpLlY$ui(lookaheadDelegate2, !includeMotionFrameOfReference));
                return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m8958getXimpl(jM8961minusqkQi6aY))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.m8959getYimpl(jM8961minusqkQi6aY))) & 4294967295L));
            }
            LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate);
            long jM8962plusqkQi6aY = IntOffset.m8962plusqkQi6aY(IntOffset.m8962plusqkQi6aY(lookaheadDelegate.m7702positionIniSbpLlY$ui(rootLookaheadDelegate, !includeMotionFrameOfReference), rootLookaheadDelegate.getPosition()), IntOffsetKt.m8975roundk4lQ0M(relativeToSource));
            LookaheadDelegate rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            long jM8961minusqkQi6aY2 = IntOffset.m8961minusqkQi6aY(jM8962plusqkQi6aY, IntOffset.m8962plusqkQi6aY(this.lookaheadDelegate.m7702positionIniSbpLlY$ui(rootLookaheadDelegate2, !includeMotionFrameOfReference), rootLookaheadDelegate2.getPosition()));
            float fM8958getXimpl = IntOffset.m8958getXimpl(jM8961minusqkQi6aY2);
            long jM5715constructorimpl = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m8959getYimpl(jM8961minusqkQi6aY2))) & 4294967295L) | (Float.floatToRawIntBits(fM8958getXimpl) << 32));
            NodeCoordinator wrappedBy = rootLookaheadDelegate2.getCoordinator().getWrappedBy();
            Intrinsics.checkNotNull(wrappedBy);
            NodeCoordinator wrappedBy2 = rootLookaheadDelegate.getCoordinator().getWrappedBy();
            Intrinsics.checkNotNull(wrappedBy2);
            return wrappedBy.mo7455localPositionOfS_NoaFU(wrappedBy2, jM5715constructorimpl, includeMotionFrameOfReference);
        }
        LookaheadDelegate rootLookaheadDelegate3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        long jMo7455localPositionOfS_NoaFU = mo7455localPositionOfS_NoaFU(rootLookaheadDelegate3.getLookaheadLayoutCoordinates(), relativeToSource, includeMotionFrameOfReference);
        long position = rootLookaheadDelegate3.getPosition();
        float fM8958getXimpl2 = IntOffset.m8958getXimpl(position);
        long jM5727minusMKHz9U = Offset.m5727minusMKHz9U(jMo7455localPositionOfS_NoaFU, Offset.m5715constructorimpl((4294967295L & ((long) Float.floatToRawIntBits(IntOffset.m8959getYimpl(position)))) | (Float.floatToRawIntBits(fM8958getXimpl2) << 32)));
        LayoutCoordinates parentCoordinates = rootLookaheadDelegate3.getCoordinator().getParentCoordinates();
        if (parentCoordinates == null) {
            parentCoordinates = rootLookaheadDelegate3.getCoordinator().getCoordinates();
        }
        return Offset.m5728plusMKHz9U(jM5727minusMKHz9U, parentCoordinates.mo7455localPositionOfS_NoaFU(sourceCoordinates, Offset.INSTANCE.m5739getZeroF1C5BW0(), includeMotionFrameOfReference));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public void mo7460transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        getCoordinator().mo7460transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public void mo7461transformToScreen58bKbWc(float[] matrix) {
        getCoordinator().mo7461transformToScreen58bKbWc(matrix);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public int get(AlignmentLine alignmentLine) {
        return this.lookaheadDelegate.get(alignmentLine);
    }
}
