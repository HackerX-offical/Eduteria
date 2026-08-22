package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.motion.widget.Key;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: TransformGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u000f\u001a\n\u0010\u0010\u001a\u00020\f*\u00020\u0011\u001a\u0013\u0010\u0012\u001a\u00020\f*\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\f*\u00020\u0011\u001a\u000f\u0010\u0016\u001a\u00020\u0007*\u00020\u0011¢\u0006\u0002\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\f*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0002\u0010\u001b\u001a/\u0010\u001a\u001a\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u001dH\u0000¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "", "onGesture", "Lkotlin/Function4;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "", "zoom", Key.ROTATION, "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRotation", "Landroidx/compose/ui/input/pointer/PointerEvent;", "angle", "angle-k-4lQ0M", "(J)F", "calculateZoom", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateCentroidSize", "useCurrent", "calculateCentroid", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "pointerInputChangeMatcher", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Landroidx/compose/ui/input/pointer/PointerEvent;ZLkotlin/jvm/functions/Function1;)J", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TransformGestureDetectorKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransformGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {60, 62}, m = "invokeSuspend", n = {"$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"}, v = 1)
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$panZoomLock = z;
            this.$onGesture = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$panZoomLock, this.$onGesture, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x009e, code lost:
        
            if (r3 == r1) goto L16;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0163  */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [int] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x009e -> B:17:0x00a1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 430
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass2(z, function4, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i3 = 0;
            }
            i2 += i3;
            i++;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        long jCalculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i4 = 0; i4 < size2; i4++) {
            PointerInputChange pointerInputChange2 = changes2.get(i4);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long position = pointerInputChange2.getPosition();
                long jM5727minusMKHz9U = Offset.m5727minusMKHz9U(pointerInputChange2.getPreviousPosition(), jCalculateCentroid2);
                long jM5727minusMKHz9U2 = Offset.m5727minusMKHz9U(position, jCalculateCentroid);
                float fM722anglek4lQ0M = m722anglek4lQ0M(jM5727minusMKHz9U2) - m722anglek4lQ0M(jM5727minusMKHz9U);
                float fM5721getDistanceimpl = Offset.m5721getDistanceimpl(Offset.m5728plusMKHz9U(jM5727minusMKHz9U2, jM5727minusMKHz9U)) / 2.0f;
                if (fM722anglek4lQ0M > 180.0f) {
                    fM722anglek4lQ0M -= 360.0f;
                } else if (fM722anglek4lQ0M < -180.0f) {
                    fM722anglek4lQ0M += 360.0f;
                }
                f3 += fM722anglek4lQ0M * fM5721getDistanceimpl;
                f2 += fM5721getDistanceimpl;
            }
        }
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f3 / f2;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        float fCalculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float fCalculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (fCalculateCentroidSize == 0.0f || fCalculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return fCalculateCentroidSize / fCalculateCentroidSize2;
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        if (Offset.m5720equalsimpl0(jCalculateCentroid, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0())) {
            return Offset.INSTANCE.m5739getZeroF1C5BW0();
        }
        return Offset.m5727minusMKHz9U(jCalculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, z);
        float fM5721getDistanceimpl = 0.0f;
        if (Offset.m5720equalsimpl0(jCalculateCentroid, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                fM5721getDistanceimpl += Offset.m5721getDistanceimpl(Offset.m5727minusMKHz9U(z ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition(), jCalculateCentroid));
                i++;
            }
        }
        return fM5721getDistanceimpl / i;
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z) {
        return calculateCentroid(pointerEvent, z, new Function1() { // from class: androidx.compose.foundation.gestures.TransformGestureDetectorKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TransformGestureDetectorKt.calculateCentroid$lambda$0((PointerInputChange) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean calculateCentroid$lambda$0(PointerInputChange pointerInputChange) {
        return pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed();
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z, function1);
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z, Function1<? super PointerInputChange, Boolean> function1) {
        long jM5739getZeroF1C5BW0 = Offset.INSTANCE.m5739getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (function1.invoke(pointerInputChange).booleanValue()) {
                jM5739getZeroF1C5BW0 = Offset.m5728plusMKHz9U(jM5739getZeroF1C5BW0, z ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition());
                i++;
            }
        }
        if (i == 0) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        return Offset.m5718divtuRUvjQ(jM5739getZeroF1C5BW0, i);
    }

    /* JADX INFO: renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m722anglek4lQ0M(long j) {
        if (Float.intBitsToFloat((int) (j >> 32)) == 0.0f && Float.intBitsToFloat((int) (j & 4294967295L)) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Float.intBitsToFloat(r0), Float.intBitsToFloat((int) (j & 4294967295L))))) * 180.0f) / 3.1415927f;
    }
}
