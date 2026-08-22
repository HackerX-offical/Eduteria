package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.appnew.android.Utils.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AnimateBoundsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u001dJ\u001d\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b*\u0010+J6\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020DJ\u0018\u0010E\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020DH\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010!\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\"\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u001dR\u0013\u0010%\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010,\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b,\u0010-R/\u0010/\u001a\u0004\u0018\u00010\u00062\b\u0010.\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b0\u0010'\"\u0004\b1\u00102R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b5\u0010'R\u0016\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006F"}, d2 = {"Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "", "<init>", "()V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "value", "Landroidx/compose/ui/geometry/Size;", "targetSize", "getTargetSize-NH-jbRc", "()J", "J", "Landroidx/compose/ui/geometry/Offset;", "targetOffset", "getTargetOffset-F1C5BW0", "isPending", "", "lookaheadAnimationVisualDebugHelper", "Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "getLookaheadAnimationVisualDebugHelper", "()Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "setLookaheadAnimationVisualDebugHelper", "(Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;)V", "updateTargetSize", "", "size", "updateTargetSize-uvyYCjk", "(J)V", "updateTargetOffset", "offset", "updateTargetOffset-k-4lQ0M", "currentPosition", "currentSize", "getCurrentSize-NH-jbRc", "setCurrentSize-uvyYCjk", "currentBounds", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "updateCurrentBounds", Const.POSITION, "updateCurrentBounds-tz77jQw", "(JJ)V", "isIdle", "()Z", "<set-?>", "animatedValue", "getAnimatedValue", "setAnimatedValue", "(Landroidx/compose/ui/geometry/Rect;)V", "animatedValue$delegate", "Landroidx/compose/runtime/MutableState;", "getValue", "directManipulationParents", "", "Landroidx/compose/ui/layout/LayoutCoordinates;", "additionalOffset", "updateTargetOffsetAndAnimate", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "directManipulationParentsDirty", "includeMotionFrameOfReference", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "animate", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BoundsTransformDeferredAnimation {
    public static final int $stable = 8;
    private Animatable<Rect, AnimationVector4D> animatable;
    private List<LayoutCoordinates> directManipulationParents;
    private boolean isPending;
    private LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper;
    private long targetSize = Size.INSTANCE.m5800getUnspecifiedNHjbRc();
    private long targetOffset = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
    private long currentPosition = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
    private long currentSize = Size.INSTANCE.m5800getUnspecifiedNHjbRc();

    /* JADX INFO: renamed from: animatedValue$delegate, reason: from kotlin metadata */
    private final MutableState animatedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private long additionalOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();

    /* JADX INFO: renamed from: getTargetSize-NH-jbRc, reason: not valid java name and from getter */
    public final long getTargetSize() {
        return this.targetSize;
    }

    /* JADX INFO: renamed from: getTargetOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getTargetOffset() {
        return this.targetOffset;
    }

    public final LookaheadAnimationVisualDebugHelper getLookaheadAnimationVisualDebugHelper() {
        return this.lookaheadAnimationVisualDebugHelper;
    }

    public final void setLookaheadAnimationVisualDebugHelper(LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper) {
        this.lookaheadAnimationVisualDebugHelper = lookaheadAnimationVisualDebugHelper;
    }

    /* JADX INFO: renamed from: updateTargetSize-uvyYCjk, reason: not valid java name */
    public final void m85updateTargetSizeuvyYCjk(long size) {
        if (this.targetSize != InlineClassHelperKt.UnspecifiedPackedFloats && !IntSize.m8999equalsimpl0(IntSizeKt.m9009roundToIntSizeuvyYCjk(size), IntSizeKt.m9009roundToIntSizeuvyYCjk(this.targetSize))) {
            this.isPending = true;
        }
        this.targetSize = size;
        if (this.currentSize == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.currentSize = size;
        }
    }

    /* JADX INFO: renamed from: updateTargetOffset-k-4lQ0M, reason: not valid java name */
    private final void m79updateTargetOffsetk4lQ0M(long offset) {
        if ((this.targetOffset & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats && !IntOffset.m8957equalsimpl0(IntOffsetKt.m8975roundk4lQ0M(offset), IntOffsetKt.m8975roundk4lQ0M(this.targetOffset))) {
            this.isPending = true;
        }
        this.targetOffset = offset;
        if ((this.currentPosition & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.currentPosition = offset;
        }
    }

    /* JADX INFO: renamed from: getCurrentSize-NH-jbRc, reason: not valid java name and from getter */
    public final long getCurrentSize() {
        return this.currentSize;
    }

    /* JADX INFO: renamed from: setCurrentSize-uvyYCjk, reason: not valid java name */
    public final void m83setCurrentSizeuvyYCjk(long j) {
        this.currentSize = j;
    }

    public final Rect getCurrentBounds() {
        long j = this.currentSize;
        long j2 = this.currentPosition;
        if ((9223372034707292159L & j2) == InlineClassHelperKt.UnspecifiedPackedFloats || j == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return null;
        }
        return RectKt.m5763Recttz77jQw(j2, j);
    }

    /* JADX INFO: renamed from: updateCurrentBounds-tz77jQw, reason: not valid java name */
    public final void m84updateCurrentBoundstz77jQw(long position, long size) {
        this.currentPosition = position;
        this.currentSize = size;
    }

    public final boolean isIdle() {
        if (this.isPending) {
            return false;
        }
        Animatable<Rect, AnimationVector4D> animatable = this.animatable;
        return animatable == null || !animatable.isRunning();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Rect getAnimatedValue() {
        return (Rect) this.animatedValue.getValue();
    }

    private final void setAnimatedValue(Rect rect) {
        this.animatedValue.setValue(rect);
    }

    public final Rect getValue() {
        if (isIdle()) {
            return null;
        }
        return getAnimatedValue();
    }

    public final void updateTargetOffsetAndAnimate(LookaheadScope lookaheadScope, Placeable.PlacementScope placementScope, CoroutineScope coroutineScope, boolean directManipulationParentsDirty, boolean includeMotionFrameOfReference, BoundsTransform boundsTransform) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates != null) {
            LayoutCoordinates lookaheadScopeCoordinates = lookaheadScope.getLookaheadScopeCoordinates(placementScope);
            long jM5739getZeroF1C5BW0 = Offset.INSTANCE.m5739getZeroF1C5BW0();
            if (!includeMotionFrameOfReference && directManipulationParentsDirty) {
                ArrayList arrayList = this.directManipulationParents;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                int i = 0;
                LayoutCoordinates parentCoordinates = coordinates;
                while (!Intrinsics.areEqual(lookaheadScope.toLookaheadCoordinates(parentCoordinates), lookaheadScopeCoordinates)) {
                    if (parentCoordinates.getIntroducesMotionFrameOfReference()) {
                        if (arrayList.size() == i) {
                            arrayList.add(parentCoordinates);
                            jM5739getZeroF1C5BW0 = Offset.m5728plusMKHz9U(jM5739getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(parentCoordinates));
                        } else if (!Intrinsics.areEqual(arrayList.get(i), parentCoordinates)) {
                            long jM5727minusMKHz9U = Offset.m5727minusMKHz9U(jM5739getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(arrayList.get(i)));
                            arrayList.set(i, parentCoordinates);
                            jM5739getZeroF1C5BW0 = Offset.m5728plusMKHz9U(jM5727minusMKHz9U, LayoutCoordinatesKt.positionInParent(parentCoordinates));
                        }
                        i++;
                    }
                    parentCoordinates = parentCoordinates.getParentCoordinates();
                    if (parentCoordinates == null) {
                        break;
                    }
                }
                int size = arrayList.size() - 1;
                if (i <= size) {
                    while (true) {
                        jM5739getZeroF1C5BW0 = Offset.m5727minusMKHz9U(jM5739getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(arrayList.get(size)));
                        arrayList.remove(arrayList.size() - 1);
                        if (size == i) {
                            break;
                        } else {
                            size--;
                        }
                    }
                }
                this.directManipulationParents = arrayList;
            }
            this.additionalOffset = Offset.m5728plusMKHz9U(this.additionalOffset, jM5739getZeroF1C5BW0);
            m79updateTargetOffsetk4lQ0M(Offset.m5728plusMKHz9U(LookaheadScope.m7475localLookaheadPositionOfauaQtc$default(lookaheadScope, lookaheadScopeCoordinates, coordinates, 0L, includeMotionFrameOfReference, 2, null), this.additionalOffset));
            setAnimatedValue(animate(coroutineScope, boundsTransform).m5760translatek4lQ0M(Offset.m5715constructorimpl(this.additionalOffset ^ (-9223372034707292160L))));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.geometry.Rect animate(kotlinx.coroutines.CoroutineScope r14, androidx.compose.animation.BoundsTransform r15) {
        /*
            r13 = this;
            long r0 = r13.targetOffset
            r2 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            long r2 = r2 & r0
            r4 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L7a
            long r2 = r13.targetSize
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L7a
            androidx.compose.ui.geometry.Rect r6 = androidx.compose.ui.geometry.RectKt.m5763Recttz77jQw(r0, r2)
            androidx.compose.animation.core.Animatable<androidx.compose.ui.geometry.Rect, androidx.compose.animation.core.AnimationVector4D> r0 = r13.animatable
            if (r0 != 0) goto L30
            androidx.compose.animation.core.Animatable r5 = new androidx.compose.animation.core.Animatable
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r7 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter(r0)
            r10 = 12
            r11 = 0
            r8 = 0
            r9 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0 = r5
        L30:
            r13.animatable = r0
            boolean r1 = r13.isPending
            if (r1 == 0) goto L7a
            r1 = 0
            r13.isPending = r1
            boolean r1 = androidx.compose.animation.IsLookaheadAnimationVisualDebuggingEnabledKt.isLookaheadAnimationVisualDebuggingEnabled()
            if (r1 == 0) goto L61
            androidx.compose.animation.LookaheadAnimationVisualDebugHelper r1 = r13.lookaheadAnimationVisualDebugHelper
            if (r1 == 0) goto L61
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.ui.geometry.Rect r2 = r13.getCurrentBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.compose.animation.core.FiniteAnimationSpec r2 = r15.createAnimationSpec(r2, r6)
            androidx.compose.ui.geometry.Rect r3 = r13.getCurrentBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Object r4 = r0.getVelocity()
            androidx.compose.ui.geometry.Rect r4 = (androidx.compose.ui.geometry.Rect) r4
            r1.calculatePath$animation(r2, r3, r6, r4)
        L61:
            kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
            androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1 r5 = new androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1
            r10 = 0
            r9 = r13
            r8 = r15
            r7 = r6
            r6 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r15 = r9
            r10 = r5
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 1
            r12 = 0
            r8 = 0
            r7 = r14
            r9 = r1
            kotlinx.coroutines.BuildersKt.launch$default(r7, r8, r9, r10, r11, r12)
            goto L7b
        L7a:
            r15 = r13
        L7b:
            androidx.compose.animation.core.Animatable<androidx.compose.ui.geometry.Rect, androidx.compose.animation.core.AnimationVector4D> r14 = r15.animatable
            if (r14 == 0) goto L89
            java.lang.Object r14 = r14.getValue()
            androidx.compose.ui.geometry.Rect r14 = (androidx.compose.ui.geometry.Rect) r14
            if (r14 != 0) goto L88
            goto L89
        L88:
            return r14
        L89:
            androidx.compose.ui.geometry.Rect$Companion r14 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r14 = r14.getZero()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.BoundsTransformDeferredAnimation.animate(kotlinx.coroutines.CoroutineScope, androidx.compose.animation.BoundsTransform):androidx.compose.ui.geometry.Rect");
    }

    /* JADX INFO: renamed from: androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimateBoundsModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1", f = "AnimateBoundsModifier.kt", i = {}, l = {537}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Animatable<Rect, AnimationVector4D> $anim;
        final /* synthetic */ BoundsTransform $boundsTransform;
        final /* synthetic */ Rect $target;
        int label;
        final /* synthetic */ BoundsTransformDeferredAnimation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Animatable<Rect, AnimationVector4D> animatable, Rect rect, BoundsTransform boundsTransform, BoundsTransformDeferredAnimation boundsTransformDeferredAnimation, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$anim = animatable;
            this.$target = rect;
            this.$boundsTransform = boundsTransform;
            this.this$0 = boundsTransformDeferredAnimation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$anim, this.$target, this.$boundsTransform, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Rect, AnimationVector4D> animatable = this.$anim;
                Rect rect = this.$target;
                BoundsTransform boundsTransform = this.$boundsTransform;
                Rect currentBounds = this.this$0.getCurrentBounds();
                Intrinsics.checkNotNull(currentBounds);
                this.label = 1;
                if (Animatable.animateTo$default(animatable, rect, boundsTransform.createAnimationSpec(currentBounds, this.$target), null, null, this, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
