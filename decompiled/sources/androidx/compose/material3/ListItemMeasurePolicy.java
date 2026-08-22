package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J(\u0010\u0013\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J(\u0010\u0015\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J(\u0010\u0016\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016JV\u0010\u0017\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000f2,\u0010\u0018\u001a(\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000f0\u0019¢\u0006\u0002\b\u001cH\u0002JV\u0010\u001d\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000f2,\u0010\u0018\u001a(\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000f0\u0019¢\u0006\u0002\b\u001cH\u0002¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/ListItemMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "minIntrinsicHeight", "minIntrinsicWidth", "calculateIntrinsicWidth", "intrinsicMeasure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "calculateIntrinsicHeight", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ListItemMeasurePolicy implements MultiContentMeasurePolicy {
    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1016measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        long j2;
        Placeable placeableMo7445measureBRTryo0;
        long j3;
        Placeable placeableMo7445measureBRTryo02;
        Placeable placeable;
        Placeable placeable2;
        Placeable placeableMo7445measureBRTryo03;
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        List<? extends Measurable> list4 = list.get(2);
        List<? extends Measurable> list5 = list.get(3);
        List<? extends Measurable> list6 = list.get(4);
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        float listItemStartPadding = ListItemKt.getListItemStartPadding();
        float listItemEndPadding = ListItemKt.getListItemEndPadding();
        int i = measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(listItemStartPadding + listItemEndPadding));
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull((List) list5);
        int iMinIntrinsicWidth = measurable != null ? measurable.minIntrinsicWidth(Constraints.m8782getMaxHeightimpl(j)) : 0;
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull((List) list6);
        int iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(Constraints.m8783getMaxWidthimpl(jM8773copyZbe2FdA$default), iMinIntrinsicWidth + (measurable2 != null ? measurable2.minIntrinsicWidth(Constraints.m8782getMaxHeightimpl(j)) : 0) + i);
        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull((List) list4);
        float f2 = 2;
        long jM8802offsetNN6EwU = ConstraintsKt.m8802offsetNN6EwU(jM8773copyZbe2FdA$default, -i, -measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(ListItemKt.m3064verticalPaddingyh95HIg(ListItemType.INSTANCE.m3077invokeZLSjz4$material3(CollectionsKt.firstOrNull((List) list3) != null, CollectionsKt.firstOrNull((List) list4) != null, ListItemKt.isSupportingMultilineHeuristic(measureScope, measurable3 != null ? measurable3.minIntrinsicHeight(iSubtractConstraintSafely) : 0))) * f2)));
        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull((List) list5);
        Placeable placeableMo7445measureBRTryo04 = measurable4 != null ? measurable4.mo7445measureBRTryo0(jM8802offsetNN6EwU) : null;
        int widthOrZero = LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo04);
        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull((List) list6);
        if (measurable5 != null) {
            j2 = jM8802offsetNN6EwU;
            placeableMo7445measureBRTryo0 = measurable5.mo7445measureBRTryo0(ConstraintsKt.m8803offsetNN6EwU$default(j2, -widthOrZero, 0, 2, null));
        } else {
            j2 = jM8802offsetNN6EwU;
            placeableMo7445measureBRTryo0 = null;
        }
        int widthOrZero2 = widthOrZero + LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo0);
        Measurable measurable6 = (Measurable) CollectionsKt.firstOrNull((List) list2);
        if (measurable6 != null) {
            j3 = j2;
            placeableMo7445measureBRTryo02 = measurable6.mo7445measureBRTryo0(ConstraintsKt.m8803offsetNN6EwU$default(j2, -widthOrZero2, 0, 2, null));
        } else {
            j3 = j2;
            placeableMo7445measureBRTryo02 = null;
        }
        int heightOrZero = LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo02);
        Measurable measurable7 = (Measurable) CollectionsKt.firstOrNull((List) list4);
        if (measurable7 != null) {
            placeable = placeableMo7445measureBRTryo0;
            placeable2 = placeableMo7445measureBRTryo04;
            placeableMo7445measureBRTryo03 = measurable7.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(j3, -widthOrZero2, -heightOrZero));
        } else {
            placeable = placeableMo7445measureBRTryo0;
            placeable2 = placeableMo7445measureBRTryo04;
            placeableMo7445measureBRTryo03 = null;
        }
        int heightOrZero2 = heightOrZero + LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo03);
        boolean z = (placeableMo7445measureBRTryo03 == null || placeableMo7445measureBRTryo03.get(AlignmentLineKt.getFirstBaseline()) == placeableMo7445measureBRTryo03.get(AlignmentLineKt.getLastBaseline())) ? false : true;
        Measurable measurable8 = (Measurable) CollectionsKt.firstOrNull((List) list3);
        Placeable placeableMo7445measureBRTryo05 = measurable8 != null ? measurable8.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(j3, -widthOrZero2, -heightOrZero2)) : null;
        int iM3077invokeZLSjz4$material3 = ListItemType.INSTANCE.m3077invokeZLSjz4$material3(placeableMo7445measureBRTryo05 != null, placeableMo7445measureBRTryo03 != null, z);
        float fM3064verticalPaddingyh95HIg = ListItemKt.m3064verticalPaddingyh95HIg(iM3077invokeZLSjz4$material3);
        MeasureScope measureScope2 = measureScope;
        return ListItemKt.place(measureScope, ListItemKt.m3063calculateWidthyeHjK3Y(measureScope2, LayoutUtilKt.getWidthOrZero(placeable2), LayoutUtilKt.getWidthOrZero(placeable), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo02), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo05), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo03), i, j), ListItemKt.m3062calculateHeightN4Jib3Y(measureScope2, LayoutUtilKt.getHeightOrZero(placeable2), LayoutUtilKt.getHeightOrZero(placeable), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo02), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo05), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo03), iM3077invokeZLSjz4$material3, measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f2 * fM3064verticalPaddingyh95HIg)), j), placeable2, placeable, placeableMo7445measureBRTryo02, placeableMo7445measureBRTryo05, placeableMo7445measureBRTryo03, ListItemType.m3069equalsimpl0(iM3077invokeZLSjz4$material3, ListItemType.INSTANCE.m3075getThreeLineAlXitO8()), measureScope.mo482roundToPx0680j_4(listItemStartPadding), measureScope.mo482roundToPx0680j_4(listItemEndPadding), measureScope.mo482roundToPx0680j_4(fM3064verticalPaddingyh95HIg));
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    /* JADX INFO: compiled from: ListItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicHeight", "maxIntrinsicHeight(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, list, i, AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ListItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C03971 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C03971 INSTANCE = new C03971();

        C03971() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicWidth", "maxIntrinsicWidth(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(intrinsicMeasureScope, list, i, C03971.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ListItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C03981 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C03981 INSTANCE = new C03981();

        C03981() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicHeight", "minIntrinsicHeight(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, list, i, C03981.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ListItem.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C03991 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {
        public static final C03991 INSTANCE = new C03991();

        C03991() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicWidth", "minIntrinsicWidth(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
            return invoke(intrinsicMeasurable, num.intValue());
        }
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(intrinsicMeasureScope, list, i, C03991.INSTANCE);
    }

    private final int calculateIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        List<? extends IntrinsicMeasurable> list2 = list.get(0);
        List<? extends IntrinsicMeasurable> list3 = list.get(1);
        List<? extends IntrinsicMeasurable> list4 = list.get(2);
        List<? extends IntrinsicMeasurable> list5 = list.get(3);
        List<? extends IntrinsicMeasurable> list6 = list.get(4);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list5);
        int iIntValue = intrinsicMeasurable != null ? function2.invoke(intrinsicMeasurable, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list6);
        int iIntValue2 = intrinsicMeasurable2 != null ? function2.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list2);
        int iIntValue3 = intrinsicMeasurable3 != null ? function2.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list3);
        int iIntValue4 = intrinsicMeasurable4 != null ? function2.invoke(intrinsicMeasurable4, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list4);
        return ListItemKt.m3063calculateWidthyeHjK3Y(intrinsicMeasureScope, iIntValue, iIntValue2, iIntValue3, iIntValue4, intrinsicMeasurable5 != null ? function2.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue() : 0, intrinsicMeasureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }

    private final int calculateIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        int iIntValue;
        int iIntValue2;
        List<? extends IntrinsicMeasurable> list2 = list.get(0);
        List<? extends IntrinsicMeasurable> list3 = list.get(1);
        List<? extends IntrinsicMeasurable> list4 = list.get(2);
        List<? extends IntrinsicMeasurable> list5 = list.get(3);
        List<? extends IntrinsicMeasurable> list6 = list.get(4);
        int iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(i, intrinsicMeasureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())));
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list5);
        if (intrinsicMeasurable != null) {
            iIntValue = function2.invoke(intrinsicMeasurable, Integer.valueOf(iSubtractConstraintSafely)).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list6);
        if (intrinsicMeasurable2 != null) {
            iIntValue2 = function2.invoke(intrinsicMeasurable2, Integer.valueOf(iSubtractConstraintSafely)).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue2 = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list3);
        int iIntValue3 = intrinsicMeasurable3 != null ? function2.invoke(intrinsicMeasurable3, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list2);
        int iIntValue4 = intrinsicMeasurable4 != null ? function2.invoke(intrinsicMeasurable4, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List) list4);
        int iIntValue5 = intrinsicMeasurable5 != null ? function2.invoke(intrinsicMeasurable5, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0;
        int iM3077invokeZLSjz4$material3 = ListItemType.INSTANCE.m3077invokeZLSjz4$material3(iIntValue3 > 0, iIntValue5 > 0, ListItemKt.isSupportingMultilineHeuristic(intrinsicMeasureScope, iIntValue5));
        return ListItemKt.m3062calculateHeightN4Jib3Y(intrinsicMeasureScope, iIntValue, iIntValue2, iIntValue4, iIntValue3, iIntValue5, iM3077invokeZLSjz4$material3, intrinsicMeasureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(ListItemKt.m3064verticalPaddingyh95HIg(iM3077invokeZLSjz4$material3) * 2)), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }
}
