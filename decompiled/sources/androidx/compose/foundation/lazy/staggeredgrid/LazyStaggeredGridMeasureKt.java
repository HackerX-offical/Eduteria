package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.Placeable;
import androidx.exifinterface.media.ExifInterface;
import com.appnew.android.Utils.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: LazyStaggeredGridMeasure.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "withDebugLogging", ExifInterface.GPS_DIRECTION_TRUE, "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", Const.POSITION, "Lkotlin/Function2;", "calculateExtraItems", "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", "action", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", "transform", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* JADX INFO: renamed from: measureStaggeredGrid-C6celF4, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1437measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int i5;
        int iM1436maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo != null ? lazyStaggeredGridLayoutInfo.getVisibleItemsInfo() : null, graphicsContext, null);
        int[] iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation.length || (iM1436maxInRangejy6DScQ = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation[i6]) == -1) {
                    iM1436maxInRangejy6DScQ = i6 == 0 ? 0 : m1436maxInRangejy6DScQ(iArr, SpanRange.m1447constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = iM1436maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                if (i7 < scrollOffsets.length) {
                    i5 = scrollOffsets[i7];
                } else {
                    i5 = i7 == 0 ? 0 : iArr2[i7 - 1];
                }
                iArr2[i7] = i5;
                i7++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation(z4)), iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation, scrollOffsets, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x02f6, code lost:
    
        r6 = indexOfMinValue$default(r9, 0, 1, null);
        r7 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0301, code lost:
    
        if (r6 == r7) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0307, code lost:
    
        if (r9[r6] != r9[r7]) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0309, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x030b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x030c, code lost:
    
        r7 = r28[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x030f, code lost:
    
        if (r7 != (-1)) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0311, code lost:
    
        r7 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0312, code lost:
    
        r7 = findPreviousItemIndex(r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0316, code lost:
    
        if (r7 >= 0) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0318, code lost:
    
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x031a, code lost:
    
        if (r1 != false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0320, code lost:
    
        if (measure$lambda$0$misalignedStart(r10, r0, r9, r6) == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0322, code lost:
    
        if (r50 == false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0324, code lost:
    
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x032f, code lost:
    
        if (r3 >= r1) goto L563;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0331, code lost:
    
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0338, code lost:
    
        r1 = r9.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x033c, code lost:
    
        if (r4 >= r1) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x033e, code lost:
    
        r3[r4] = r9[r6];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x034c, code lost:
    
        return measure(r0, r27, r2, r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x034d, code lost:
    
        r11 = r27;
        r47 = r2;
        r28 = r3;
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0357, code lost:
    
        r11 = r27;
        r10 = r28;
        r26 = r1;
        r47 = r2;
        r1 = r0.m1431getSpanRangelOCCd4c(r0.getItemProvider(), r7, r6);
        r6 = r0.getLaneInfo();
        r30 = r12;
        r27 = r13;
        r12 = (int) (r1 & 4294967295L);
        r28 = r3;
        r13 = r4;
        r3 = (int) (r1 >> r18);
        r4 = r12 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x037b, code lost:
    
        if (r4 == 1) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x037d, code lost:
    
        r29 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0380, code lost:
    
        r29 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0382, code lost:
    
        if (r29 == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0384, code lost:
    
        r15 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0386, code lost:
    
        r15 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0387, code lost:
    
        r6.setLane(r7, r15);
        r6 = r0.getMeasuredItemProvider().m1440getAndMeasurejy6DScQ(r7, r1);
        r1 = m1436maxInRangejy6DScQ(r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0397, code lost:
    
        if (r4 == 1) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0399, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x039b, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x039c, code lost:
    
        if (r2 == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x039e, code lost:
    
        r2 = r0.getLaneInfo().getGaps(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03a7, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03a8, code lost:
    
        if (r3 >= r12) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03ac, code lost:
    
        if (r9[r3] == r1) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03ae, code lost:
    
        r26 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03b0, code lost:
    
        r48[r3].addFirst(r6);
        r10[r3] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03b7, code lost:
    
        if (r2 != null) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03b9, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x03bb, code lost:
    
        r4 = r2[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03bd, code lost:
    
        r9[r3] = (r1 + r6.getMainAxisSizeWithSpacings()) + r4;
        r3 = r3 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:332:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0715  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x071f A[LOOP:21: B:315:0x0671->B:356:0x071f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x08d5  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0731 A[EDGE_INSN: B:537:0x0731->B:358:0x0731 BREAK  A[LOOP:21: B:315:0x0671->B:356:0x071f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measure(final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r46, int r47, int[] r48, int[] r49, boolean r50) {
        /*
            Method dump skipped, instruction units count: 2838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int, int[], int[], boolean):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$0$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$0$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, final List list, final boolean z, final long j, final LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyStaggeredGridMeasureKt.measure$lambda$0$37$0(list, z, j, lazyLayoutMeasureScope, (Placeable.PlacementScope) obj);
            }
        });
        ObservableScopeInvalidator.m1393attachToScopeimpl(lazyStaggeredGridMeasureContext.getState().m1445getPlacementScopeInvalidatorzYiylxw$foundation());
        return Unit.INSTANCE;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i, int i2, int i3) {
        int size = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            size += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i4 = -1;
                    int i5 = Integer.MAX_VALUE;
                    for (int i6 = 0; i6 < length; i6++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemFirstOrNull = arrayDequeArr[i6].firstOrNull();
                        int index = lazyStaggeredGridMeasuredItemFirstOrNull != null ? lazyStaggeredGridMeasuredItemFirstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i5 > index) {
                            i4 = i6;
                            i5 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemRemoveFirst = arrayDequeArr[i4].removeFirst();
                    if (lazyStaggeredGridMeasuredItemRemoveFirst.getLane() == i4) {
                        long jM1447constructorimpl = SpanRange.m1447constructorimpl(lazyStaggeredGridMeasuredItemRemoveFirst.getLane(), lazyStaggeredGridMeasuredItemRemoveFirst.getSpan());
                        int iM1436maxInRangejy6DScQ = m1436maxInRangejy6DScQ(iArr, jM1447constructorimpl);
                        int i7 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i4];
                        if (lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSize() + iM1436maxInRangejy6DScQ >= i2 && iM1436maxInRangejy6DScQ <= i3) {
                            lazyStaggeredGridMeasuredItemRemoveFirst.position(iM1436maxInRangejy6DScQ, i7, i);
                            arrayList.add(lazyStaggeredGridMeasuredItemRemoveFirst);
                        }
                        int i8 = (int) (jM1447constructorimpl & 4294967295L);
                        for (int i9 = (int) (jM1447constructorimpl >> 32); i9 < i8; i9++) {
                            iArr[i9] = lazyStaggeredGridMeasuredItemRemoveFirst.getMainAxisSizeWithSpacings() + iM1436maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r7, int r8, int r9, boolean r10, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem, ? super java.lang.Integer, kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.itemsRetainedForLookahead(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int, int, boolean, kotlin.jvm.functions.Function2):java.util.List");
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int iIntValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                        long jM1431getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m1431getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1440getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1440getAndMeasurejy6DScQ(iIntValue, jM1431getSpanRangelOCCd4c);
                        function1.invoke(lazyStaggeredGridMeasuredItemM1440getAndMeasurejy6DScQ);
                        arrayList.add(lazyStaggeredGridMeasuredItemM1440getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iIntValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(iIntValue2)).booleanValue()) {
                    long jM1431getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m1431getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM1440getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1440getAndMeasurejy6DScQ(iIntValue2, jM1431getSpanRangelOCCd4c2);
                    function1.invoke(lazyStaggeredGridMeasuredItemM1440getAndMeasurejy6DScQ2);
                    arrayList.add(lazyStaggeredGridMeasuredItemM1440getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m1435forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* JADX INFO: renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m1436maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int iMax = Integer.MIN_VALUE;
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            iMax = Math.max(iMax, iArr[i2]);
        }
        return iMax;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int iIntValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > iIntValue) {
                i = i3;
                i2 = iIntValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            int i3 = iArr[length];
            if (i3 >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), i3)) {
                if (lazyStaggeredGridMeasureContext.getLaneInfo().getLane(i3) == -2) {
                    int length2 = iArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            i4 = -1;
                            break;
                        } else if (iArr[i4] == i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    int i5 = i4 + 1;
                    if (i5 <= length) {
                        while (true) {
                            if (iArr[i5] == i3) {
                                iArr[i5] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, i3, i5);
                            }
                            if (i5 == length) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                    length = i4;
                }
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(i3, length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                function1.invoke(list.get(size));
                if (i < 0) {
                    return;
                } else {
                    size = i;
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i2 = size - 1;
                function1.invoke(list.get(size));
                if (i2 < 0) {
                    return;
                } else {
                    size = i2;
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$0$37$0(List list, boolean z, long j, LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyStaggeredGridMeasuredItem) list.get(i)).m1443placeGMOY1bU(placementScope, z, j, lazyLayoutMeasureScope.isLookingAhead());
        }
        return Unit.INSTANCE;
    }
}
