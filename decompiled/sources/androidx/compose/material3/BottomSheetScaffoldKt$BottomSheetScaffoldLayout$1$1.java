package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ SheetState $sheetState;

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(SheetState sheetState, Function0<Float> function0) {
        this.$sheetState = sheetState;
        this.$sheetOffset = function0;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1016measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Integer numValueOf;
        List<? extends Measurable> list2 = list.get(0);
        int i = 1;
        List<? extends Measurable> list3 = list.get(1);
        List<? extends Measurable> list4 = list.get(2);
        List<? extends Measurable> list5 = list.get(3);
        final int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j);
        final int iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j);
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list4.size());
        int size = list4.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list4.get(i2).mo7445measureBRTryo0(jM8773copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            arrayList3.add(list2.get(i3).mo7445measureBRTryo0(jM8773copyZbe2FdA$default));
        }
        final ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((Placeable) arrayList4.get(0)).getHeight());
            int lastIndex = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Placeable) arrayList4.get(i)).getHeight());
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        Integer num = numValueOf;
        final int iIntValue = num != null ? num.intValue() : 0;
        long jM8773copyZbe2FdA$default2 = Constraints.m8773copyZbe2FdA$default(jM8773copyZbe2FdA$default, 0, 0, 0, iM8782getMaxHeightimpl - iIntValue, 7, null);
        ArrayList arrayList5 = new ArrayList(list3.size());
        int size3 = list3.size();
        for (int i4 = 0; i4 < size3; i4++) {
            arrayList5.add(list3.get(i4).mo7445measureBRTryo0(jM8773copyZbe2FdA$default2));
        }
        final ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = new ArrayList(list5.size());
        int size4 = list5.size();
        for (int i5 = 0; i5 < size4; i5++) {
            arrayList7.add(list5.get(i5).mo7445measureBRTryo0(jM8773copyZbe2FdA$default));
        }
        final ArrayList arrayList8 = arrayList7;
        final SheetState sheetState = this.$sheetState;
        final Function0<Float> function0 = this.$sheetOffset;
        return MeasureScope.layout$default(measureScope, iM8783getMaxWidthimpl, iM8782getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.measure_3p2s80s$lambda$12(arrayList2, iM8783getMaxWidthimpl, arrayList8, sheetState, function0, iM8782getMaxHeightimpl, arrayList6, arrayList4, iIntValue, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$12(List list, int i, List list2, SheetState sheetState, Function0 function0, int i2, List list3, List list4, int i3, Placeable.PlacementScope placementScope) {
        Integer numValueOf;
        Integer numValueOf2;
        int iRoundToInt;
        Integer numValueOf3 = null;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((Placeable) list.get(0)).getWidth());
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i4 = 1;
                while (true) {
                    Integer numValueOf4 = Integer.valueOf(((Placeable) list.get(i4)).getWidth());
                    if (numValueOf4.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf4;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
        }
        Integer num = numValueOf;
        int iMax = Math.max(0, (i - (num != null ? num.intValue() : 0)) / 2);
        if (list2.isEmpty()) {
            numValueOf2 = null;
        } else {
            numValueOf2 = Integer.valueOf(((Placeable) list2.get(0)).getWidth());
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                int i5 = 1;
                while (true) {
                    Integer numValueOf5 = Integer.valueOf(((Placeable) list2.get(i5)).getWidth());
                    if (numValueOf5.compareTo(numValueOf2) > 0) {
                        numValueOf2 = numValueOf5;
                    }
                    if (i5 == lastIndex2) {
                        break;
                    }
                    i5++;
                }
            }
        }
        Integer num2 = numValueOf2;
        int iIntValue = num2 != null ? num2.intValue() : 0;
        if (!list2.isEmpty()) {
            numValueOf3 = Integer.valueOf(((Placeable) list2.get(0)).getHeight());
            int lastIndex3 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex3) {
                int i6 = 1;
                while (true) {
                    Integer numValueOf6 = Integer.valueOf(((Placeable) list2.get(i6)).getHeight());
                    if (numValueOf6.compareTo(numValueOf3) > 0) {
                        numValueOf3 = numValueOf6;
                    }
                    if (i6 == lastIndex3) {
                        break;
                    }
                    i6++;
                }
            }
        }
        Integer num3 = numValueOf3;
        int iIntValue2 = num3 != null ? num3.intValue() : 0;
        int i7 = (i - iIntValue) / 2;
        int i8 = WhenMappings.$EnumSwitchMapping$0[sheetState.getCurrentValue().ordinal()];
        if (i8 == 1) {
            iRoundToInt = MathKt.roundToInt(((Number) function0.invoke()).floatValue()) - iIntValue2;
        } else {
            if (i8 != 2 && i8 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            iRoundToInt = i2 - iIntValue2;
        }
        int size = list3.size();
        for (int i9 = 0; i9 < size; i9++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list3.get(i9), 0, i3, 0.0f, 4, null);
        }
        int size2 = list4.size();
        for (int i10 = 0; i10 < size2; i10++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list4.get(i10), 0, 0, 0.0f, 4, null);
        }
        int size3 = list.size();
        for (int i11 = 0; i11 < size3; i11++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i11), iMax, 0, 0.0f, 4, null);
        }
        int size4 = list2.size();
        for (int i12 = 0; i12 < size4; i12++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list2.get(i12), i7, iRoundToInt, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
