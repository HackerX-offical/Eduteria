package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\"\u0010#\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010&\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010'\u001a\u00020\tH\u0016J\"\u0010(\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010)\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010'\u001a\u00020\tH\u0016JK\u0010*\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\tH\u0002¢\u0006\u0004\b2\u00103R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u00064"}, d2 = {"Landroidx/compose/material3/TopAppBarMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "titleBottomPadding", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Landroidx/compose/ui/unit/Dp;", "<init>", "(Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScrolledOffset", "()Landroidx/compose/material3/internal/FloatProducer;", "getTitleVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTitleHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getTitleBottomPadding", "()I", "getHeight-D9Ej5fM", "()F", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicWidth", "maxIntrinsicHeight", "placeTopAppBar", "layoutHeight", "maxLayoutHeight", "navigationIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "titlePlaceable", "actionIconsPlaceable", "titleBaseline", "placeTopAppBar-mpW86Vk", "(Landroidx/compose/ui/layout/MeasureScope;JIILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;I)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TopAppBarMeasurePolicy implements MeasurePolicy {
    private final float height;
    private final FloatProducer scrolledOffset;
    private final int titleBottomPadding;
    private final Alignment.Horizontal titleHorizontalAlignment;
    private final Arrangement.Vertical titleVerticalArrangement;

    public /* synthetic */ TopAppBarMeasurePolicy(FloatProducer floatProducer, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(floatProducer, vertical, horizontal, i, f2);
    }

    private TopAppBarMeasurePolicy(FloatProducer floatProducer, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, float f2) {
        this.scrolledOffset = floatProducer;
        this.titleVerticalArrangement = vertical;
        this.titleHorizontalAlignment = horizontal;
        this.titleBottomPadding = i;
        this.height = f2;
    }

    public final FloatProducer getScrolledOffset() {
        return this.scrolledOffset;
    }

    public final Arrangement.Vertical getTitleVerticalArrangement() {
        return this.titleVerticalArrangement;
    }

    public final Alignment.Horizontal getTitleHorizontalAlignment() {
        return this.titleHorizontalAlignment;
    }

    public final int getTitleBottomPadding() {
        return this.titleBottomPadding;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getHeight() {
        return this.height;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Integer num;
        int i2 = intrinsicMeasureScope.mo482roundToPx0680j_4(this.height);
        if (list.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf = Integer.valueOf(list.get(0).minIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i3).minIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            num = numValueOf;
        }
        Integer num2 = num;
        return Math.max(i2, num2 != null ? num2.intValue() : 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Integer num;
        int i2 = intrinsicMeasureScope.mo482roundToPx0680j_4(this.height);
        if (list.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf = Integer.valueOf(list.get(0).maxIntrinsicHeight(i));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i3).maxIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
            num = numValueOf;
        }
        Integer num2 = num;
        return Math.max(i2, num2 != null ? num2.intValue() : 0);
    }

    /* JADX INFO: renamed from: placeTopAppBar-mpW86Vk, reason: not valid java name */
    private final MeasureResult m3945placeTopAppBarmpW86Vk(final MeasureScope measureScope, final long j, final int i, final int i2, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final int i3) {
        return MeasureScope.layout$default(measureScope, Constraints.m8783getMaxWidthimpl(j), i, null, new Function1() { // from class: androidx.compose.material3.TopAppBarMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TopAppBarMeasurePolicy.placeTopAppBar_mpW86Vk$lambda$8(placeable, i, placeable2, placeable3, j, measureScope, this, i3, i2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit placeTopAppBar_mpW86Vk$lambda$8(androidx.compose.ui.layout.Placeable r10, int r11, androidx.compose.ui.layout.Placeable r12, androidx.compose.ui.layout.Placeable r13, long r14, androidx.compose.ui.layout.MeasureScope r16, androidx.compose.material3.TopAppBarMeasurePolicy r17, int r18, int r19, androidx.compose.ui.layout.Placeable.PlacementScope r20) {
        /*
            r0 = r17
            r1 = r19
            int r2 = r10.getHeight()
            int r2 = r11 - r2
            int r6 = r2 / 2
            r8 = 4
            r9 = 0
            r5 = 0
            r7 = 0
            r4 = r10
            r3 = r20
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r3, r4, r5, r6, r7, r8, r9)
            float r2 = androidx.compose.material3.AppBarKt.access$getTopAppBarTitleInset$p()
            r3 = r16
            int r2 = r3.mo482roundToPx0680j_4(r2)
            int r10 = r10.getWidth()
            int r10 = java.lang.Math.max(r2, r10)
            int r2 = r13.getWidth()
            androidx.compose.ui.Alignment$Horizontal r3 = r0.titleHorizontalAlignment
            int r4 = r12.getWidth()
            int r5 = androidx.compose.ui.unit.Constraints.m8783getMaxWidthimpl(r14)
            androidx.compose.ui.unit.LayoutDirection r6 = androidx.compose.ui.unit.LayoutDirection.Ltr
            int r3 = r3.align(r4, r5, r6)
            if (r3 >= r10) goto L41
            int r10 = r10 - r3
        L3f:
            int r3 = r3 + r10
            goto L59
        L41:
            int r10 = r12.getWidth()
            int r10 = r10 + r3
            int r4 = androidx.compose.ui.unit.Constraints.m8783getMaxWidthimpl(r14)
            int r4 = r4 - r2
            if (r10 <= r4) goto L59
            int r10 = androidx.compose.ui.unit.Constraints.m8783getMaxWidthimpl(r14)
            int r10 = r10 - r2
            int r2 = r12.getWidth()
            int r2 = r2 + r3
            int r10 = r10 - r2
            goto L3f
        L59:
            r2 = r3
            androidx.compose.foundation.layout.Arrangement$Vertical r10 = r0.titleVerticalArrangement
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r3 = r3.getCenter()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r3)
            if (r3 == 0) goto L72
            int r10 = r12.getHeight()
            int r10 = r11 - r10
            int r10 = r10 / 2
        L70:
            r3 = r10
            goto La7
        L72:
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r3 = r3.getBottom()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r3)
            r3 = 0
            if (r10 == 0) goto La7
            int r10 = r0.titleBottomPadding
            if (r10 != 0) goto L8a
            int r10 = r12.getHeight()
            int r10 = r11 - r10
            goto L70
        L8a:
            int r0 = r12.getHeight()
            int r0 = r0 - r18
            int r10 = r10 - r0
            int r0 = r12.getHeight()
            int r0 = r0 + r10
            if (r0 <= r1) goto L9a
            int r0 = r0 - r1
            int r10 = r10 - r0
        L9a:
            int r0 = r12.getHeight()
            int r0 = r11 - r0
            int r10 = java.lang.Math.max(r3, r10)
            int r10 = r0 - r10
            goto L70
        La7:
            r5 = 4
            r6 = 0
            r4 = 0
            r1 = r12
            r0 = r20
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r0, r1, r2, r3, r4, r5, r6)
            int r10 = androidx.compose.ui.unit.Constraints.m8783getMaxWidthimpl(r14)
            int r12 = r13.getWidth()
            int r2 = r10 - r12
            int r10 = r13.getHeight()
            int r11 = r11 - r10
            int r3 = r11 / 2
            r1 = r13
            androidx.compose.ui.layout.Placeable.PlacementScope.placeRelative$default(r0, r1, r2, r3, r4, r5, r6)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TopAppBarMeasurePolicy.placeTopAppBar_mpW86Vk$lambda$8(androidx.compose.ui.layout.Placeable, int, androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Placeable, long, androidx.compose.ui.layout.MeasureScope, androidx.compose.material3.TopAppBarMeasurePolicy, int, int, androidx.compose.ui.layout.Placeable$PlacementScope):kotlin.Unit");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iCoerceAtLeast;
        TopAppBarMeasurePolicy topAppBarMeasurePolicy = this;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "navigationIcon")) {
                Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "actionIcons")) {
                        Placeable placeableMo7445measureBRTryo02 = measurable2.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
                        if (Constraints.m8783getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                            iCoerceAtLeast = Constraints.m8783getMaxWidthimpl(j);
                        } else {
                            iCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m8783getMaxWidthimpl(j) - placeableMo7445measureBRTryo0.getWidth()) - placeableMo7445measureBRTryo02.getWidth(), 0);
                        }
                        int i3 = iCoerceAtLeast;
                        int size3 = list2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            Measurable measurable3 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "title")) {
                                Placeable placeableMo7445measureBRTryo03 = measurable3.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, i3, 0, 0, 12, null));
                                int i5 = placeableMo7445measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? placeableMo7445measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) : 0;
                                float fInvoke = topAppBarMeasurePolicy.scrolledOffset.invoke();
                                int iRoundToInt = Float.isNaN(fInvoke) ? 0 : MathKt.roundToInt(fInvoke);
                                int iMax = Math.max(measureScope.mo482roundToPx0680j_4(topAppBarMeasurePolicy.height), placeableMo7445measureBRTryo03.getHeight());
                                return topAppBarMeasurePolicy.m3945placeTopAppBarmpW86Vk(measureScope, j, Constraints.m8782getMaxHeightimpl(j) == Integer.MAX_VALUE ? iMax : RangesKt.coerceAtLeast(iRoundToInt + iMax, 0), iMax, placeableMo7445measureBRTryo0, placeableMo7445measureBRTryo03, placeableMo7445measureBRTryo02, i5);
                            }
                            i4++;
                            topAppBarMeasurePolicy = this;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    topAppBarMeasurePolicy = this;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            topAppBarMeasurePolicy = this;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        int size = list.size();
        int iMinIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMinIntrinsicWidth += list.get(i2).minIntrinsicWidth(i);
        }
        return iMinIntrinsicWidth;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        int size = list.size();
        int iMaxIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMaxIntrinsicWidth += list.get(i2).maxIntrinsicWidth(i);
        }
        return iMaxIntrinsicWidth;
    }
}
