package androidx.compose.ui.node;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.message_correct.element.MessageCorrectExtension;

/* JADX INFO: compiled from: LookaheadDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002opB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0011\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0086\u0002J\u0010\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020/H&J\r\u00108\u001a\u00020 H ¢\u0006\u0002\b9J\f\u0010E\u001a\u00020 *\u00020FH\u0004J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020L2\u0006\u0010R\u001a\u00020PJ\u0018\u0010S\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020LH\u0002J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020LH\u0002J\u0014\u0010U\u001a\u00020\u0010*\u00020\u00142\u0006\u0010V\u001a\u00020\u0014H\u0002J\u0015\u0010W\u001a\u00020 2\u0006\u0010Q\u001a\u00020LH\u0000¢\u0006\u0002\bXJ`\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u00020-2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020-0]2\u0019\u0010^\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e¢\u0006\u0002\b!2\u0017\u0010_\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020 0\u001e¢\u0006\u0002\b!H\u0016J\u0017\u0010`\u001a\u00020 2\b\u0010a\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0002\bbJ+\u0010c\u001a\u00020 2\u0006\u0010d\u001a\u00020#2\b\b\u0002\u0010e\u001a\u00020\u00072\b\b\u0002\u0010f\u001a\u00020gH\u0002¢\u0006\u0004\bh\u0010iJ\u0010\u0010`\u001a\u00020 2\u0006\u0010d\u001a\u00020#H\u0002J\u001c\u0010j\u001a\u00020 2\u0012\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140N0MH\u0002J\u0016\u0010l\u001a\u00020 2\u0006\u0010Q\u001a\u00020L2\u0006\u0010m\u001a\u00020PJ\u0016\u0010n\u001a\u00020 2\u0006\u0010Q\u001a\u00020L2\u0006\u0010m\u001a\u00020PR\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e¢\u0006\u0002\b!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010&R\u0018\u0010)\u001a\u00060\u001cR\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u00101\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010&R\u0012\u00104\u001a\u000205X \u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u0010:\u001a\u00020;X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010&R\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0012R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010J\u001a\u001c\u0012\u0004\u0012\u00020L\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140N0M\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "<init>", "()V", Const.POSITION, "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", Message.Thread.PARENT_ATTRIBUTE_NAME, "getParent", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "_rulerScope", "Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "rulersLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "cachedRulerPlaceableResult", "Landroidx/compose/ui/node/PlaceableResult;", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "updatePlacedUnderMotionFrameOfReference", "newMFR", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "get", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLine", "isShallowPlacing", "isShallowPlacing$ui", "setShallowPlacing$ui", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui", "()Landroidx/compose/ui/layout/MeasureResult;", MessageCorrectExtension.ELEMENT, "replace$ui", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "isPlacingForAlignment", "isPlacingForAlignment$ui", "setPlacingForAlignment$ui", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLookingAhead", "rulerValues", "Landroidx/compose/ui/node/RulerTrackingMap;", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "findRulerValue", "", "ruler", "defaultValue", "addRulerReader", "findAncestorRulerDefiner", "isLayoutNodeAncestor", "ancestor", "invalidateChildrenOfDefiningRuler", "invalidateChildrenOfDefiningRuler$ui", "layout", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "alignmentLines", "", "rulers", "placementBlock", "captureRulersIfNeeded", "result", "captureRulersIfNeeded$ui", "captureRulers", "placeableResult", "positionOnScreen", "size", "Landroidx/compose/ui/unit/IntSize;", "captureRulers-OSxE8f4", "(Landroidx/compose/ui/node/PlaceableResult;JJ)V", "notifyRulerValueChange", "layoutNodes", "provideRulerValue", "value", "provideRelativeRulerValue", "ResettableRulerScope", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    public static final int $stable = 0;
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = new Function1<PlaceableResult, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlaceableResult placeableResult) {
            invoke2(placeableResult);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlaceableResult placeableResult) {
            if (placeableResult.isValidOwnerScope()) {
                placeableResult.getPlaceable().captureRulersIfNeeded(placeableResult);
            }
        }
    };
    private ResettableRulerScope _rulerScope;
    private PlaceableResult cachedRulerPlaceableResult;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private RulerTrackingMap rulerValues;
    private Function1<? super RulerScope, Unit> rulersLambda;

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui();

    public abstract LookaheadCapablePlaceable getParent();

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long getPosition();

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    public abstract void replace$ui();

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    /* JADX INFO: renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean newMFR) {
        LookaheadCapablePlaceable parent = getParent();
        LayoutNode layoutNode = parent != null ? parent.getLayoutNode() : null;
        if (Intrinsics.areEqual(layoutNode, getLayoutNode())) {
            setPlacedUnderMotionFrameOfReference(newMFR);
            return;
        }
        if ((layoutNode != null ? layoutNode.getLayoutState$ui() : null) != LayoutNode.LayoutState.LayingOut) {
            if ((layoutNode != null ? layoutNode.getLayoutState$ui() : null) != LayoutNode.LayoutState.LookaheadLayingOut) {
                return;
            }
        }
        setPlacedUnderMotionFrameOfReference(newMFR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResettableRulerScope getRulerScope() {
        ResettableRulerScope resettableRulerScope = this._rulerScope;
        if (resettableRulerScope != null) {
            return resettableRulerScope;
        }
        ResettableRulerScope resettableRulerScope2 = new ResettableRulerScope();
        this._rulerScope = resettableRulerScope2;
        return resettableRulerScope2;
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int iCalculateAlignmentLine;
        int iM8959getYimpl;
        if (!getHasMeasureResult() || (iCalculateAlignmentLine = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            iM8959getYimpl = IntOffset.m8958getXimpl(getApparentToRealOffset());
        } else {
            iM8959getYimpl = IntOffset.m8959getYimpl(getApparentToRealOffset());
        }
        return iCalculateAlignmentLine + iM8959getYimpl;
    }

    /* JADX INFO: renamed from: isShallowPlacing$ui, reason: from getter */
    public final boolean getIsShallowPlacing() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing$ui(boolean z) {
        this.isShallowPlacing = z;
    }

    /* JADX INFO: renamed from: isPlacingForAlignment$ui, reason: from getter */
    public final boolean getIsPlacingForAlignment() {
        return this.isPlacingForAlignment;
    }

    public final void setPlacingForAlignment$ui(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    protected final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped = nodeCoordinator.getWrapped();
        if (!Intrinsics.areEqual(wrapped != null ? wrapped.getLayoutNode() : null, nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    public final float findRulerValue(Ruler ruler, float defaultValue) {
        if (this.isPlacingForAlignment) {
            return defaultValue;
        }
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            RulerTrackingMap rulerTrackingMap = lookaheadCapablePlaceable.rulerValues;
            float orDefault = rulerTrackingMap != null ? rulerTrackingMap.getOrDefault(ruler, Float.NaN) : Float.NaN;
            if (!Float.isNaN(orDefault)) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return ruler.calculateCoordinate$ui(orDefault, lookaheadCapablePlaceable.getCoordinates(), getCoordinates());
            }
            LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
            if (parent == null) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return defaultValue;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addRulerReader(androidx.compose.ui.node.LayoutNode r32, androidx.compose.ui.layout.Ruler r33) {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.addRulerReader(androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.Ruler):void");
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable parent;
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            RulerTrackingMap rulerTrackingMap = lookaheadCapablePlaceable.rulerValues;
            if ((rulerTrackingMap != null && rulerTrackingMap.contains(ruler)) || (parent = lookaheadCapablePlaceable.getParent()) == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    private final boolean isLayoutNodeAncestor(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode == layoutNode2) {
            return true;
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        if (parent$ui != null) {
            return isLayoutNodeAncestor(parent$ui, layoutNode2);
        }
        return false;
    }

    public final void invalidateChildrenOfDefiningRuler$ui(Ruler ruler) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = findAncestorRulerDefiner(ruler).rulerReaders;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSetRemove = mutableScatterMap != null ? mutableScatterMap.remove(ruler) : null;
        if (mutableScatterSetRemove != null) {
            notifyRulerValueChange(mutableScatterSetRemove);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void captureRulersIfNeeded$ui(androidx.compose.ui.layout.MeasureResult r24) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulersIfNeeded$ui(androidx.compose.ui.layout.MeasureResult):void");
    }

    /* JADX INFO: renamed from: captureRulers-OSxE8f4$default, reason: not valid java name */
    static /* synthetic */ void m7690captureRulersOSxE8f4$default(LookaheadCapablePlaceable lookaheadCapablePlaceable, PlaceableResult placeableResult, long j, long j2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: captureRulers-OSxE8f4");
        }
        if ((i & 2) != 0) {
            j = IntOffset.INSTANCE.m8968getMaxnOccac();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = IntSize.INSTANCE.m9006getZeroYbymL2g();
        }
        lookaheadCapablePlaceable.m7689captureRulersOSxE8f4(placeableResult, j3, j2);
    }

    /* JADX INFO: renamed from: captureRulers-OSxE8f4, reason: not valid java name */
    private final void m7689captureRulersOSxE8f4(final PlaceableResult placeableResult, final long positionOnScreen, final long size) {
        OwnerSnapshotObserver snapshotObserver;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null && (snapshotObserver = owner.getSnapshotObserver()) != null) {
            snapshotObserver.observer.observeReads(placeableResult, onCommitAffectingRuler, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    this.this$0.getRulerScope().setCoordinatesAccessed(false);
                    this.this$0.getRulerScope().m7694setPositionOnScreengyyYBs(positionOnScreen);
                    this.this$0.getRulerScope().m7695setSizeozmzZPI(size);
                    Function1<RulerScope, Unit> rulers = placeableResult.getResult().getRulers();
                    if (rulers != null) {
                        rulers.invoke(this.this$0.getRulerScope());
                    }
                }
            });
        }
        rulerTrackingMap.notifyChanged(isLookingAhead(), this, mutableScatterMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void captureRulersIfNeeded(androidx.compose.ui.node.PlaceableResult r15) {
        /*
            r14 = this;
            boolean r0 = r14.isPlacingForAlignment
            if (r0 == 0) goto L5
            goto L5e
        L5:
            androidx.compose.ui.layout.MeasureResult r0 = r15.getResult()
            kotlin.jvm.functions.Function1 r0 = r0.getRulers()
            androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<androidx.compose.ui.node.WeakReference<androidx.compose.ui.node.LayoutNode>>> r1 = r14.rulerReaders
            if (r0 != 0) goto L5f
            if (r1 == 0) goto L5e
            r15 = r1
            androidx.collection.ScatterMap r15 = (androidx.collection.ScatterMap) r15
            java.lang.Object[] r0 = r15.values
            long[] r15 = r15.metadata
            int r2 = r15.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L5b
            r3 = 0
            r4 = r3
        L21:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L56
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L3b:
            if (r9 >= r7) goto L54
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L50
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.collection.MutableScatterSet r10 = (androidx.collection.MutableScatterSet) r10
            r14.notifyRulerValueChange(r10)
        L50:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L3b
        L54:
            if (r7 != r8) goto L5b
        L56:
            if (r4 == r2) goto L5b
            int r4 = r4 + 1
            goto L21
        L5b:
            r1.clear()
        L5e:
            return
        L5f:
            r11 = 6
            r12 = 0
            r7 = 0
            r9 = 0
            r5 = r14
            r6 = r15
            m7690captureRulersOSxE8f4$default(r5, r6, r7, r9, r11, r12)
            r5.rulersLambda = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulersIfNeeded(androidx.compose.ui.node.PlaceableResult):void");
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> layoutNodes) {
        LayoutNode layoutNode;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet = layoutNodes;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i3]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui(false);
                        } else {
                            layoutNode.requestRelayout$ui(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void provideRulerValue(Ruler ruler, float value) {
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        rulerTrackingMap.set(ruler, value);
    }

    public final void provideRelativeRulerValue(Ruler ruler, float value) {
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        if (getLayoutDirection() != LayoutDirection.Ltr) {
            value = getWidth() - value;
        }
        rulerTrackingMap.set(ruler, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: LookaheadDelegate.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096\u0004J\u0015\u0010\u001e\u001a\u00020\u001a*\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"¨\u0006%"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "Landroidx/compose/ui/layout/RulerScope;", "<init>", "(Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "coordinatesAccessed", "", "getCoordinatesAccessed", "()Z", "setCoordinatesAccessed", "(Z)V", "positionOnScreen", "Landroidx/compose/ui/unit/IntOffset;", "getPositionOnScreen-nOcc-ac", "()J", "setPositionOnScreen--gyyYBs", "(J)V", "J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "setSize-ozmzZPI", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "provides", "", "Landroidx/compose/ui/layout/Ruler;", "value", "", "providesRelative", "Landroidx/compose/ui/layout/VerticalRuler;", "density", "getDensity", "()F", "fontScale", "getFontScale", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    final class ResettableRulerScope implements RulerScope {
        private boolean coordinatesAccessed;
        private long positionOnScreen = IntOffset.INSTANCE.m8968getMaxnOccac();
        private long size = IntSize.INSTANCE.m9006getZeroYbymL2g();

        public ResettableRulerScope() {
        }

        public final boolean getCoordinatesAccessed() {
            return this.coordinatesAccessed;
        }

        public final void setCoordinatesAccessed(boolean z) {
            this.coordinatesAccessed = z;
        }

        /* JADX INFO: renamed from: getPositionOnScreen-nOcc-ac, reason: not valid java name and from getter */
        public final long getPositionOnScreen() {
            return this.positionOnScreen;
        }

        /* JADX INFO: renamed from: setPositionOnScreen--gyyYBs, reason: not valid java name */
        public final void m7694setPositionOnScreengyyYBs(long j) {
            this.positionOnScreen = j;
        }

        /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
        public final long getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: setSize-ozmzZPI, reason: not valid java name */
        public final void m7695setSizeozmzZPI(long j) {
            this.size = j;
        }

        @Override // androidx.compose.ui.layout.RulerScope
        public LayoutCoordinates getCoordinates() {
            this.coordinatesAccessed = true;
            LayoutCoordinates coordinates = LookaheadCapablePlaceable.this.getCoordinates();
            if (IntOffset.m8957equalsimpl0(this.positionOnScreen, IntOffset.INSTANCE.m8968getMaxnOccac())) {
                this.positionOnScreen = IntOffsetKt.m8975roundk4lQ0M(LayoutCoordinatesKt.positionOnScreen(coordinates));
                this.size = coordinates.mo7453getSizeYbymL2g();
            }
            LookaheadCapablePlaceable.this.getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
            return coordinates;
        }

        @Override // androidx.compose.ui.layout.RulerScope
        public void provides(Ruler ruler, float f2) {
            LookaheadCapablePlaceable.this.provideRulerValue(ruler, f2);
        }

        @Override // androidx.compose.ui.layout.RulerScope
        public void providesRelative(VerticalRuler verticalRuler, float f2) {
            LookaheadCapablePlaceable.this.provideRelativeRulerValue(verticalRuler, f2);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: getDensity */
        public float get_density() {
            return LookaheadCapablePlaceable.this.get_density();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* JADX INFO: renamed from: getFontScale */
        public float get_fontScale() {
            return LookaheadCapablePlaceable.this.get_fontScale();
        }
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super RulerScope, Unit> rulers, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        if (!((width & (-16777216)) == 0 && ((-16777216) & height) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.layout.1
            @Override // androidx.compose.ui.layout.MeasureResult
            /* JADX INFO: renamed from: getWidth, reason: from getter */
            public int get$w() {
                return width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* JADX INFO: renamed from: getHeight, reason: from getter */
            public int get$h() {
                return height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1<RulerScope, Unit> getRulers() {
                return rulers;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                placementBlock.invoke(this.getPlacementScope());
            }
        };
    }
}
