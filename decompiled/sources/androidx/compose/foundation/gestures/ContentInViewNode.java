package androidx.compose.foundation.gestures;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.MeasuredSizeAwareModifierNode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: ContentInViewNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001GB9\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\fH\u0002J\u001e\u0010$\u001a\u00020%2\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0096@¢\u0006\u0002\u0010&J\u0017\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u00020%2\b\b\u0002\u0010,\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010*J\u001f\u0010/\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002¢\u0006\u0004\b1\u00102J\n\u00103\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0002J'\u00106\u001a\u00020\n*\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020-H\u0002¢\u0006\u0004\b8\u00109J'\u0010:\u001a\u00020;2\u0006\u00105\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u00192\u0006\u00107\u001a\u00020-H\u0002¢\u0006\u0004\b=\u0010>J\u001c\u0010?\u001a\u00020@*\u00020\u00192\u0006\u0010A\u001a\u00020\u0019H\u0082\u0002¢\u0006\u0004\bB\u0010CJ\u001c\u0010?\u001a\u00020@*\u00020D2\u0006\u0010A\u001a\u00020DH\u0082\u0002¢\u0006\u0004\bE\u0010CJ \u0010F\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/MeasuredSizeAwareModifierNode;", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "reverseDirection", "", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getFocusedRect", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollingLogic;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;Lkotlin/jvm/functions/Function0;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "trackingFocusedChild", "value", "Landroidx/compose/ui/unit/IntSize;", "viewportSize", "getViewportSize-YbymL2g$foundation", "()J", "J", "viewportSizeOrZero", "getViewportSizeOrZero-YbymL2g$foundation", "isAnimationRunning", "calculateRectForParent", "localRect", "requireBringIntoViewSpec", "bringChildIntoView", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "launchAnimation", "viewportAdjustmentForReverseScroll", "Landroidx/compose/ui/unit/IntOffset;", "launchAnimation--gyyYBs", "calculateScrollDelta", "", "calculateScrollDelta-I_oMVgE", "(Landroidx/compose/foundation/gestures/BringIntoViewSpec;J)F", "findBringIntoViewRequest", "computeDestination", "childBounds", "isMaxVisible", "containerOffset", "isMaxVisible--EQwtKw", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "containerSize", "relocationOffset-fbGrOKE", "(Landroidx/compose/ui/geometry/Rect;JJ)J", "compareTo", "", "other", "compareTo-TemP2vQ", "(JJ)I", "Landroidx/compose/ui/geometry/Size;", "compareTo-iLBOSCw", DiscoverItems.Item.UPDATE_ACTION, "Request", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentInViewNode extends Modifier.Node implements BringIntoViewResponder, CompositionLocalConsumerModifierNode, MeasuredSizeAwareModifierNode {
    public static final int $stable = 8;
    private BringIntoViewSpec bringIntoViewSpec;
    private Function0<Rect> getFocusedRect;
    private boolean isAnimationRunning;
    private Orientation orientation;
    private boolean reverseDirection;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    private boolean trackingFocusedChild;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
    private long viewportSize = ContentInViewNodeKt.UnspecifiedIntSize;

    /* JADX INFO: compiled from: ContentInViewNode.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentInViewNode(Orientation orientation, ScrollingLogic scrollingLogic, boolean z, BringIntoViewSpec bringIntoViewSpec, Function0<Rect> function0) {
        this.orientation = orientation;
        this.scrollingLogic = scrollingLogic;
        this.reverseDirection = z;
        this.bringIntoViewSpec = bringIntoViewSpec;
        this.getFocusedRect = function0;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* JADX INFO: renamed from: getViewportSize-YbymL2g$foundation, reason: not valid java name and from getter */
    public final long getViewportSize() {
        return this.viewportSize;
    }

    /* JADX INFO: renamed from: getViewportSizeOrZero-YbymL2g$foundation, reason: not valid java name */
    public final long m533getViewportSizeOrZeroYbymL2g$foundation() {
        long j = this.viewportSize;
        return IntSize.m8999equalsimpl0(j, ContentInViewNodeKt.UnspecifiedIntSize) ? IntSize.INSTANCE.m9006getZeroYbymL2g() : j;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        if (IntSize.m8999equalsimpl0(this.viewportSize, ContentInViewNodeKt.UnspecifiedIntSize)) {
            InlineClassHelperKt.throwIllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
        }
        return computeDestination(localRect);
    }

    private final BringIntoViewSpec requireBringIntoViewSpec() {
        BringIntoViewSpec bringIntoViewSpec = this.bringIntoViewSpec;
        return bringIntoViewSpec == null ? (BringIntoViewSpec) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec()) : bringIntoViewSpec;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Rect rectInvoke = function0.invoke();
        if (rectInvoke != null && !m528isMaxVisibleEQwtKw$default(this, rectInvoke, 0L, 0L, 3, null)) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            if (this.bringIntoViewRequests.enqueue(new Request(function0, cancellableContinuationImpl)) && !this.isAnimationRunning) {
                m530launchAnimationgyyYBs$default(this, 0L, 1, null);
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public void mo477onRemeasuredozmzZPI(long size) {
        long jM8969getZeronOccac;
        long jM533getViewportSizeOrZeroYbymL2g$foundation = m533getViewportSizeOrZeroYbymL2g$foundation();
        this.viewportSize = size;
        if (m525compareToTemP2vQ(size, jM533getViewportSizeOrZeroYbymL2g$foundation) < 0) {
            if (!this.reverseDirection) {
                if (this.orientation == Orientation.Vertical) {
                    jM8969getZeronOccac = IntOffset.m8952constructorimpl((((long) 0) << 32) | (((long) (((int) (jM533getViewportSizeOrZeroYbymL2g$foundation & 4294967295L)) - ((int) (size & 4294967295L)))) & 4294967295L));
                } else {
                    jM8969getZeronOccac = IntOffset.m8952constructorimpl((((long) (((int) (jM533getViewportSizeOrZeroYbymL2g$foundation >> 32)) - ((int) (size >> 32)))) << 32) | (((long) 0) & 4294967295L));
                }
            } else {
                jM8969getZeronOccac = IntOffset.INSTANCE.m8969getZeronOccac();
            }
            long j = jM8969getZeronOccac;
            Rect rectInvoke = this.getFocusedRect.invoke();
            if (rectInvoke != null && !this.isAnimationRunning && !this.trackingFocusedChild && m528isMaxVisibleEQwtKw$default(this, rectInvoke, jM533getViewportSizeOrZeroYbymL2g$foundation, 0L, 2, null)) {
                if (m528isMaxVisibleEQwtKw$default(this, rectInvoke, 0L, j, 1, null)) {
                    return;
                }
                this.trackingFocusedChild = true;
                m529launchAnimationgyyYBs(j);
            }
        }
    }

    /* JADX INFO: renamed from: launchAnimation--gyyYBs$default, reason: not valid java name */
    static /* synthetic */ void m530launchAnimationgyyYBs$default(ContentInViewNode contentInViewNode, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = IntOffset.INSTANCE.m8969getZeronOccac();
        }
        contentInViewNode.m529launchAnimationgyyYBs(j);
    }

    /* JADX INFO: renamed from: launchAnimation--gyyYBs, reason: not valid java name */
    private final void m529launchAnimationgyyYBs(long viewportAdjustmentForReverseScroll) {
        BringIntoViewSpec bringIntoViewSpecRequireBringIntoViewSpec = requireBringIntoViewSpec();
        if (this.isAnimationRunning) {
            InlineClassHelperKt.throwIllegalStateException("launchAnimation called when previous animation was running");
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new ContentInViewNode$launchAnimation$2(this, new UpdatableAnimationState(requireBringIntoViewSpec().getScrollAnimationSpec()), bringIntoViewSpecRequireBringIntoViewSpec, viewportAdjustmentForReverseScroll, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateScrollDelta-I_oMVgE, reason: not valid java name */
    public final float m524calculateScrollDeltaI_oMVgE(BringIntoViewSpec bringIntoViewSpec, long viewportAdjustmentForReverseScroll) {
        long j = this.viewportSize;
        Rect rectFindBringIntoViewRequest = findBringIntoViewRequest();
        if (rectFindBringIntoViewRequest == null) {
            rectFindBringIntoViewRequest = this.trackingFocusedChild ? this.getFocusedRect.invoke() : null;
            if (rectFindBringIntoViewRequest == null) {
                return 0.0f;
            }
        }
        long jM9013toSizeozmzZPI = IntSizeKt.m9013toSizeozmzZPI(j);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return bringIntoViewSpec.calculateScrollDistance(rectFindBringIntoViewRequest.getTop() - IntOffset.m8959getYimpl(viewportAdjustmentForReverseScroll), rectFindBringIntoViewRequest.getBottom() - rectFindBringIntoViewRequest.getTop(), Float.intBitsToFloat((int) (jM9013toSizeozmzZPI & 4294967295L)));
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return bringIntoViewSpec.calculateScrollDistance(rectFindBringIntoViewRequest.getLeft() - IntOffset.m8958getXimpl(viewportAdjustmentForReverseScroll), rectFindBringIntoViewRequest.getRight() - rectFindBringIntoViewRequest.getLeft(), Float.intBitsToFloat((int) (jM9013toSizeozmzZPI >> 32)));
    }

    private final Rect findBringIntoViewRequest() {
        MutableVector mutableVector = this.bringIntoViewRequests.requests;
        int size = mutableVector.getSize() - 1;
        Object[] objArr = mutableVector.content;
        Rect rect = null;
        if (size < objArr.length) {
            while (true) {
                if (size < 0) {
                    break;
                }
                Rect rectInvoke = ((Request) objArr[size]).getCurrentBounds().invoke();
                if (rectInvoke != null) {
                    if (m526compareToiLBOSCw(rectInvoke.m5756getSizeNHjbRc(), IntSizeKt.m9013toSizeozmzZPI(m533getViewportSizeOrZeroYbymL2g$foundation())) <= 0) {
                        rect = rectInvoke;
                    } else if (rect == null) {
                        return rectInvoke;
                    }
                }
                size--;
            }
        }
        return rect;
    }

    private final Rect computeDestination(Rect childBounds) {
        return childBounds.m5760translatek4lQ0M(Offset.m5715constructorimpl(m531relocationOffsetfbGrOKE(childBounds, m533getViewportSizeOrZeroYbymL2g$foundation(), IntOffset.INSTANCE.m8969getZeronOccac()) ^ (-9223372034707292160L)));
    }

    /* JADX INFO: renamed from: isMaxVisible--EQwtKw$default, reason: not valid java name */
    static /* synthetic */ boolean m528isMaxVisibleEQwtKw$default(ContentInViewNode contentInViewNode, Rect rect, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewNode.m533getViewportSizeOrZeroYbymL2g$foundation();
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = IntOffset.INSTANCE.m8969getZeronOccac();
        }
        return contentInViewNode.m527isMaxVisibleEQwtKw(rect, j3, j2);
    }

    /* JADX INFO: renamed from: isMaxVisible--EQwtKw, reason: not valid java name */
    private final boolean m527isMaxVisibleEQwtKw(Rect rect, long j, long j2) {
        long jM531relocationOffsetfbGrOKE = m531relocationOffsetfbGrOKE(rect, j, j2);
        return Math.abs(Float.intBitsToFloat((int) (jM531relocationOffsetfbGrOKE >> 32))) <= 0.5f && Math.abs(Float.intBitsToFloat((int) (jM531relocationOffsetfbGrOKE & 4294967295L))) <= 0.5f;
    }

    /* JADX INFO: renamed from: relocationOffset-fbGrOKE, reason: not valid java name */
    private final long m531relocationOffsetfbGrOKE(Rect childBounds, long containerSize, long containerOffset) {
        long jM9013toSizeozmzZPI = IntSizeKt.m9013toSizeozmzZPI(containerSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(requireBringIntoViewSpec().calculateScrollDistance(childBounds.getLeft() - IntOffset.m8958getXimpl(containerOffset), childBounds.getRight() - childBounds.getLeft(), Float.intBitsToFloat((int) (jM9013toSizeozmzZPI >> 32))))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(requireBringIntoViewSpec().calculateScrollDistance(childBounds.getTop() - IntOffset.m8959getYimpl(containerOffset), childBounds.getBottom() - childBounds.getTop(), Float.intBitsToFloat((int) (jM9013toSizeozmzZPI & 4294967295L))))) & 4294967295L));
    }

    /* JADX INFO: renamed from: compareTo-TemP2vQ, reason: not valid java name */
    private final int m525compareToTemP2vQ(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return Intrinsics.compare((int) (j & 4294967295L), (int) (j2 & 4294967295L));
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return Intrinsics.compare((int) (j >> 32), (int) (j2 >> 32));
    }

    /* JADX INFO: renamed from: compareTo-iLBOSCw, reason: not valid java name */
    private final int m526compareToiLBOSCw(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i == 1) {
            return Float.compare(Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 & 4294967295L)));
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return Float.compare(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)));
    }

    public final void update(Orientation orientation, boolean reverseDirection, BringIntoViewSpec bringIntoViewSpec) {
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    /* JADX INFO: compiled from: ContentInViewNode.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Request {
        public static final int $stable = 8;
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;

        /* JADX WARN: Multi-variable type inference failed */
        public Request(Function0<Rect> function0, CancellableContinuation<? super Unit> cancellableContinuation) {
            this.currentBounds = function0;
            this.continuation = cancellableContinuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        public String toString() {
            String str;
            CoroutineName coroutineName = (CoroutineName) this.continuation.get$context().get(CoroutineName.INSTANCE);
            String name = coroutineName != null ? coroutineName.getName() : null;
            StringBuilder sb = new StringBuilder("Request@");
            String string = Integer.toString(hashCode(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            StringBuilder sbAppend = sb.append(string);
            if (name == null || (str = Constants.AES_PREFIX + name + "](") == null) {
                str = "(";
            }
            return sbAppend.append(str).append("currentBounds()=").append(this.currentBounds.invoke()).append(", continuation=").append(this.continuation).append(')').toString();
        }
    }
}
