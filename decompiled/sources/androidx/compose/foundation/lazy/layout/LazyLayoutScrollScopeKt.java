package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: compiled from: LazyLayoutScrollScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a\u0014\u0010\f\u001a\u00020\u0006*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a2\u0010\u0010\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0080@¢\u0006\u0002\u0010\u0015\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"TargetDistance", "Landroidx/compose/ui/unit/Dp;", "F", "BoundDistance", "MinimumDistance", "DEBUG", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "isItemVisible", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", FirebaseAnalytics.Param.INDEX, "", "animateScrollToItem", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyLayoutScrollScopeKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m8830constructorimpl(2500);
    private static final float BoundDistance = Dp.m8830constructorimpl(1500);
    private static final float MinimumDistance = Dp.m8830constructorimpl(50);

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt$animateScrollToItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutScrollScope.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt", f = "LazyLayoutScrollScope.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {ByteCode.RETURN, 264}, m = "animateScrollToItem", n = {"$this$animateScrollToItem", "loop", "anim", "loops", FirebaseAnalytics.Param.INDEX, "scrollOffset", "numOfItemsForTeleport", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$animateScrollToItem", FirebaseAnalytics.Param.INDEX, "scrollOffset"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "F$0", "F$1", "F$2", "I$3", "L$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LazyLayoutScrollScopeKt.animateScrollToItem(null, 0, 0, 0, null, this);
        }
    }

    private static final void debugLog(Function0<String> function0) {
    }

    public static final boolean isItemVisible(LazyLayoutScrollScope lazyLayoutScrollScope, int i) {
        return i <= lazyLayoutScrollScope.getLastVisibleItemIndex() && lazyLayoutScrollScope.getFirstVisibleItemIndex() <= i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:(1:(2:39|40))|(1:(17:50|53|(1:55)(1:56)|57|(1:59)(1:60)|61|62|119|63|64|111|65|66|113|67|(8:70|18|125|71|72|115|35|(4:37|39|40|(0)(4:42|123|43|(1:46))))|102)(1:51))(0)|52|53|(0)(0)|57|(0)(0)|61|62|119|63|64|111|65|66|113|67|(0)|102) */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01da, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01db, code lost:
    
        r21 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00eb A[Catch: ItemFoundInScroll -> 0x01e8, TryCatch #4 {ItemFoundInScroll -> 0x01e8, blocks: (B:35:0x00e7, B:37:0x00eb, B:39:0x00f1, B:53:0x0120, B:57:0x015c, B:61:0x0164), top: B:115:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024c  */
    /* JADX WARN: Type inference failed for: r8v0, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Type inference failed for: r8v16, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x01b4 -> B:18:0x0073). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object animateScrollToItem(androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope r37, int r38, int r39, int r40, androidx.compose.ui.unit.Density r41, kotlin.coroutines.Continuation<? super kotlin.Unit> r42) {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt.animateScrollToItem(androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope, int, int, int, androidx.compose.ui.unit.Density, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean animateScrollToItem$isOvershot(boolean z, LazyLayoutScrollScope lazyLayoutScrollScope, int i, int i2) {
        if (z) {
            if (lazyLayoutScrollScope.getFirstVisibleItemIndex() > i) {
                return true;
            }
            return lazyLayoutScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() > i2;
        }
        if (lazyLayoutScrollScope.getFirstVisibleItemIndex() < i) {
            return true;
        }
        return lazyLayoutScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() < i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit animateScrollToItem$lambda$5(LazyLayoutScrollScope lazyLayoutScrollScope, int i, float f2, Ref.FloatRef floatRef, Ref.BooleanRef booleanRef, boolean z, float f3, Ref.IntRef intRef, int i2, int i3, Ref.ObjectRef objectRef, AnimationScope animationScope) {
        float fCoerceAtLeast;
        if (!isItemVisible(lazyLayoutScrollScope, i)) {
            if (f2 > 0.0f) {
                fCoerceAtLeast = RangesKt.coerceAtMost(((Number) animationScope.getValue()).floatValue(), f2);
            } else {
                fCoerceAtLeast = RangesKt.coerceAtLeast(((Number) animationScope.getValue()).floatValue(), f2);
            }
            float f4 = fCoerceAtLeast - floatRef.element;
            float fScrollBy = lazyLayoutScrollScope.scrollBy(f4);
            if (!isItemVisible(lazyLayoutScrollScope, i) && !animateScrollToItem$isOvershot(z, lazyLayoutScrollScope, i, i3)) {
                if (f4 != fScrollBy) {
                    animationScope.cancelAnimation();
                    booleanRef.element = false;
                    return Unit.INSTANCE;
                }
                floatRef.element += f4;
                if (z) {
                    if (((Number) animationScope.getValue()).floatValue() > f3) {
                        animationScope.cancelAnimation();
                    }
                } else if (((Number) animationScope.getValue()).floatValue() < (-f3)) {
                    animationScope.cancelAnimation();
                }
                if (z) {
                    if (intRef.element >= 2 && i - lazyLayoutScrollScope.getLastVisibleItemIndex() > i2) {
                        lazyLayoutScrollScope.snapToItem(i - i2, 0);
                    }
                } else if (intRef.element >= 2 && lazyLayoutScrollScope.getFirstVisibleItemIndex() - i > i2) {
                    lazyLayoutScrollScope.snapToItem(i2 + i, 0);
                }
            }
        }
        if (animateScrollToItem$isOvershot(z, lazyLayoutScrollScope, i, i3)) {
            lazyLayoutScrollScope.snapToItem(i, i3);
            booleanRef.element = false;
            animationScope.cancelAnimation();
            return Unit.INSTANCE;
        }
        if (isItemVisible(lazyLayoutScrollScope, i)) {
            throw new ItemFoundInScroll(LazyLayoutScrollScope.calculateDistanceTo$default(lazyLayoutScrollScope, i, 0, 2, null), (AnimationState) objectRef.element);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateScrollToItem$lambda$7(float f2, Ref.FloatRef floatRef, LazyLayoutScrollScope lazyLayoutScrollScope, AnimationScope animationScope) {
        float fCoerceAtLeast = 0.0f;
        if (f2 > 0.0f) {
            fCoerceAtLeast = RangesKt.coerceAtMost(((Number) animationScope.getValue()).floatValue(), f2);
        } else if (f2 < 0.0f) {
            fCoerceAtLeast = RangesKt.coerceAtLeast(((Number) animationScope.getValue()).floatValue(), f2);
        }
        float f3 = fCoerceAtLeast - floatRef.element;
        if (f3 != lazyLayoutScrollScope.scrollBy(f3) || fCoerceAtLeast != ((Number) animationScope.getValue()).floatValue()) {
            animationScope.cancelAnimation();
        }
        floatRef.element += f3;
        return Unit.INSTANCE;
    }
}
