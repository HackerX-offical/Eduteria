package androidx.compose.foundation.pager;

import android.os.Trace;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import com.clevertap.android.sdk.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: PagerMeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\"\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002\u001a\u0017\u0010'\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0003H\u0082\b\"\u000e\u0010&\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"rememberPagerMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "cacheWindowLogic", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "visiblePagesList", "", "Landroidx/compose/foundation/pager/PageInfo;", "DebugEnabled", "debugLog", "generateMsg", "", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PagerMeasurePolicyKt {
    private static final boolean DebugEnabled = false;

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0145 A[PHI: r3
      0x0145: PHI (r3v22 int) = (r3v20 int), (r3v23 int) binds: [B:102:0x0143, B:98:0x0139] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[PHI: r4
      0x00a1: PHI (r4v25 androidx.compose.ui.Alignment$Horizontal) = (r4v23 androidx.compose.ui.Alignment$Horizontal), (r4v26 androidx.compose.ui.Alignment$Horizontal) binds: [B:44:0x009f, B:40:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bd A[PHI: r9
      0x00bd: PHI (r9v13 androidx.compose.ui.Alignment$Vertical) = (r9v10 androidx.compose.ui.Alignment$Vertical), (r9v14 androidx.compose.ui.Alignment$Vertical) binds: [B:54:0x00bb, B:50:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d9 A[PHI: r12
      0x00d9: PHI (r12v11 float) = (r12v9 float), (r12v12 float) binds: [B:64:0x00d7, B:60:0x00d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5 A[PHI: r13
      0x00f5: PHI (r13v11 androidx.compose.foundation.pager.PageSize) = (r13v9 androidx.compose.foundation.pager.PageSize), (r13v12 androidx.compose.foundation.pager.PageSize) binds: [B:74:0x00f3, B:70:0x00ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010f A[PHI: r14
      0x010f: PHI (r14v11 androidx.compose.foundation.gestures.snapping.SnapPosition) = 
      (r14v8 androidx.compose.foundation.gestures.snapping.SnapPosition)
      (r14v12 androidx.compose.foundation.gestures.snapping.SnapPosition)
     binds: [B:84:0x010d, B:80:0x0106] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0133  */
    /* JADX INFO: renamed from: rememberPagerMeasurePolicy-8u0NR3k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy m1479rememberPagerMeasurePolicy8u0NR3k(kotlin.jvm.functions.Function0<androidx.compose.foundation.pager.PagerLazyLayoutItemProvider> r21, androidx.compose.foundation.pager.PagerState r22, androidx.compose.foundation.layout.PaddingValues r23, boolean r24, androidx.compose.foundation.gestures.Orientation r25, int r26, float r27, androidx.compose.foundation.pager.PageSize r28, androidx.compose.ui.Alignment.Horizontal r29, androidx.compose.ui.Alignment.Vertical r30, androidx.compose.foundation.gestures.snapping.SnapPosition r31, kotlinx.coroutines.CoroutineScope r32, kotlin.jvm.functions.Function0<java.lang.Integer> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerMeasurePolicyKt.m1479rememberPagerMeasurePolicy8u0NR3k(kotlin.jvm.functions.Function0, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepAroundItems(LazyLayoutMeasureScope lazyLayoutMeasureScope, CacheWindowLogic cacheWindowLogic, List<? extends PageInfo> list) {
        Trace.beginSection("compose:pager:cache_window:keepAroundItems");
        try {
            if (cacheWindowLogic.hasValidBounds() && !list.isEmpty()) {
                int index = ((PageInfo) CollectionsKt.first((List) list)).getIndex();
                int index2 = ((PageInfo) CollectionsKt.last((List) list)).getIndex();
                for (int prefetchWindowStartLine = cacheWindowLogic.getPrefetchWindowStartLine(); prefetchWindowStartLine < index; prefetchWindowStartLine++) {
                    lazyLayoutMeasureScope.compose(prefetchWindowStartLine);
                }
                int i = index2 + 1;
                int prefetchWindowEndLine = cacheWindowLogic.getPrefetchWindowEndLine();
                if (i <= prefetchWindowEndLine) {
                    while (true) {
                        lazyLayoutMeasureScope.compose(i);
                        if (i == prefetchWindowEndLine) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
