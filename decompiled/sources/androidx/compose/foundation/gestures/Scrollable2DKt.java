package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Scrollable2D.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0018\u0010\u0019\u001a\u00020\u0015*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"scrollable2D", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", StreamManagement.Enabled.ELEMENT, "", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic2D;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "magnitude", "", "Landroidx/compose/ui/unit/Velocity;", "getMagnitude-TH1AsA0", "(J)F", "angle", "getAngle-TH1AsA0", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Scrollable2DKt {
    private static final Scroll2DScope NoOpScrollScope = new Scroll2DScope() { // from class: androidx.compose.foundation.gestures.Scrollable2DKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.Scroll2DScope
        /* JADX INFO: renamed from: scrollBy-MK-Hz9U */
        public long mo540scrollByMKHz9U(long delta) {
            return delta;
        }
    };

    public static /* synthetic */ Modifier scrollable2D$default(Modifier modifier, Scrollable2DState scrollable2DState, boolean z, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return scrollable2D(modifier, scrollable2DState, z, (i & 4) != 0 ? null : overscrollEffect, (i & 8) != 0 ? null : flingBehavior, (i & 16) != 0 ? null : mutableInteractionSource);
    }

    public static final Modifier scrollable2D(Modifier modifier, Scrollable2DState scrollable2DState, boolean z, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        return modifier.then(new Scrollable2DElement(scrollable2DState, overscrollEffect, z, flingBehavior, mutableInteractionSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m670semanticsScrollByd4ec7I(androidx.compose.foundation.gestures.ScrollingLogic2D r6, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.geometry.Offset> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$1 r0 = (androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$1 r0 = new androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.internal.Ref$LongRef r6 = (kotlin.jvm.internal.Ref.LongRef) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5c
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r4 = r2.m5739getZeroF1C5BW0()
            r9.element = r4
            androidx.compose.foundation.MutatePriority r2 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$2 r4 = new androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$2
            r5 = 0
            r4.<init>(r7, r9, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r6 = r6.scroll(r2, r4, r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            r6 = r9
        L5c:
            long r6 = r6.element
            androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m5712boximpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.Scrollable2DKt.m670semanticsScrollByd4ec7I(androidx.compose.foundation.gestures.ScrollingLogic2D, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getMagnitude-TH1AsA0, reason: not valid java name */
    public static final float m669getMagnitudeTH1AsA0(long j) {
        double d2 = 2;
        return (float) Math.sqrt(((float) Math.pow(Velocity.m9068getXimpl(j), d2)) + ((float) Math.pow(Velocity.m9069getYimpl(j), d2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAngle-TH1AsA0, reason: not valid java name */
    public static final float m668getAngleTH1AsA0(long j) {
        return (float) Math.atan2(Velocity.m9069getYimpl(j), Velocity.m9068getXimpl(j));
    }
}
