package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007\u001a\u001c\u0010%\u001a\u00020&*\u00020'2\u0006\u0010(\u001a\u00020&H\u0082@¢\u0006\u0004\b)\u0010*\" \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0018\u001a\u00020\u0007*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u000e\u0010\u001b\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u001d\u001a\u00020\u001eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$\"\u000e\u0010+\u001a\u00020,X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", StreamManagement.Enabled.ELEMENT, "", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "getCanDragCalculation", "()Lkotlin/jvm/functions/Function1;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "shouldBeTriggeredByMouseWheel", "getShouldBeTriggeredByMouseWheel", "(Landroidx/compose/foundation/gestures/FlingBehavior;)Z", "DefaultScrollMotionDurationScaleFactor", "", "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "UnityDensity", "Landroidx/compose/ui/unit/Density;", "getUnityDensity", "()Landroidx/compose/ui/unit/Density;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "VerticalAxisThresholdAngle", "", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ScrollableKt {
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final double VerticalAxisThresholdAngle = 0.7853981633974483d;
    private static final Function1<PointerType, Boolean> CanDragCalculation = new Function1() { // from class: androidx.compose.foundation.gestures.ScrollableKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(ScrollableKt.CanDragCalculation$lambda$0((PointerType) obj));
        }
    };
    private static final ScrollScope NoOpScrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float pixels) {
            return pixels;
        }
    };
    private static final MotionDurationScale DefaultScrollMotionDurationScale = new MotionDurationScale() { // from class: androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1
        @Override // androidx.compose.ui.MotionDurationScale
        public float getScaleFactor() {
            return 1.0f;
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public /* bridge */ <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) MotionDurationScale.DefaultImpls.fold(this, r, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public /* bridge */ <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
            return (E) MotionDurationScale.DefaultImpls.get(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public /* bridge */ CoroutineContext minusKey(CoroutineContext.Key<?> key) {
            return MotionDurationScale.DefaultImpls.minusKey(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public /* bridge */ CoroutineContext plus(CoroutineContext coroutineContext) {
            return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
        }
    };
    private static final Density UnityDensity = new Density() { // from class: androidx.compose.foundation.gestures.ScrollableKt$UnityDensity$1
        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: getDensity */
        public float get_density() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* JADX INFO: renamed from: getFontScale */
        public float get_fontScale() {
            return 1.0f;
        }
    };

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        return scrollable(modifier, scrollableState, orientation, z3, z2, (i & 16) != 0 ? null : flingBehavior, (i & 32) != 0 ? null : mutableInteractionSource);
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        return scrollable$default(modifier, scrollableState, orientation, null, z, z2, flingBehavior, mutableInteractionSource, null, 128, null);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, int i, Object obj) {
        BringIntoViewSpec bringIntoViewSpec2;
        Modifier modifier2;
        ScrollableState scrollableState2;
        Orientation orientation2;
        OverscrollEffect overscrollEffect2;
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z3 = z;
        boolean z4 = (i & 16) != 0 ? false : z2;
        FlingBehavior flingBehavior2 = (i & 32) != 0 ? null : flingBehavior;
        MutableInteractionSource mutableInteractionSource2 = (i & 64) != 0 ? null : mutableInteractionSource;
        if ((i & 128) != 0) {
            bringIntoViewSpec2 = null;
            modifier2 = modifier;
            orientation2 = orientation;
            overscrollEffect2 = overscrollEffect;
            scrollableState2 = scrollableState;
        } else {
            bringIntoViewSpec2 = bringIntoViewSpec;
            modifier2 = modifier;
            scrollableState2 = scrollableState;
            orientation2 = orientation;
            overscrollEffect2 = overscrollEffect;
        }
        return scrollable(modifier2, scrollableState2, orientation2, overscrollEffect2, z3, z4, flingBehavior2, mutableInteractionSource2, bringIntoViewSpec2);
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        return modifier.then(new ScrollableElement(scrollableState, orientation, overscrollEffect, z, z2, flingBehavior, mutableInteractionSource, bringIntoViewSpec));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CanDragCalculation$lambda$0(PointerType pointerType) {
        return !(pointerType == null ? false : PointerType.m7385equalsimpl0(pointerType.getValue(), PointerType.INSTANCE.m7390getMouseT8wyACA()));
    }

    public static final Function1<PointerType, Boolean> getCanDragCalculation() {
        return CanDragCalculation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getShouldBeTriggeredByMouseWheel(FlingBehavior flingBehavior) {
        return !(flingBehavior instanceof ScrollableDefaultFlingBehavior);
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }

    public static final Density getUnityDensity() {
        return UnityDensity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m675semanticsScrollByd4ec7I(androidx.compose.foundation.gestures.ScrollingLogic r10, long r11, kotlin.coroutines.Continuation<? super androidx.compose.ui.geometry.Offset> r13) {
        /*
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$FloatRef r10 = (kotlin.jvm.internal.Ref.FloatRef) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r11 = (androidx.compose.foundation.gestures.ScrollingLogic) r11
            kotlin.ResultKt.throwOnFailure(r13)
            r8 = r10
            r10 = r11
            goto L5e
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.jvm.internal.Ref$FloatRef r8 = new kotlin.jvm.internal.Ref$FloatRef
            r8.<init>()
            androidx.compose.foundation.MutatePriority r13 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2 r4 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2
            r9 = 0
            r5 = r10
            r6 = r11
            r4.<init>(r5, r6, r8, r9)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r10 = r5.scroll(r13, r4, r0)
            if (r10 != r1) goto L5d
            return r1
        L5d:
            r10 = r5
        L5e:
            float r11 = r8.element
            long r10 = r10.m696toOffsettuRUvjQ(r11)
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m5712boximpl(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m675semanticsScrollByd4ec7I(androidx.compose.foundation.gestures.ScrollingLogic, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
