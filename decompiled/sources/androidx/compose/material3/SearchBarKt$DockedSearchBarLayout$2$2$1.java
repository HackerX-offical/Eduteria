package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SearchBarKt$DockedSearchBarLayout$2$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ float $maxHeight;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ SearchBarState $state;

    SearchBarKt$DockedSearchBarLayout$2$2$1(SearchBarState searchBarState, float f2, float f3) {
        this.$state = searchBarState;
        this.$maxHeight = f2;
        this.$minHeight = f3;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1016measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        Integer num;
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        int iLerp = MathHelpersKt.lerp(SearchBarKt.getCollapsedBounds(this.$state).getHeight(), measureScope.mo482roundToPx0680j_4(this.$maxHeight), this.$state.getProgress());
        long jM8798constrainN9IONVI = ConstraintsKt.m8798constrainN9IONVI(j, ConstraintsKt.Constraints$default(0, 0, RangesKt.coerceAtMost(measureScope.mo482roundToPx0680j_4(this.$minHeight), iLerp), iLerp, 3, null));
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(jM8798constrainN9IONVI, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list2.size());
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list2.get(i).mo7445measureBRTryo0(jM8773copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i2 = 1;
                while (true) {
                    Integer numValueOf4 = Integer.valueOf(((Placeable) arrayList2.get(i2)).getWidth());
                    if (numValueOf4.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf4;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num2 = numValueOf;
        int iIntValue = num2 != null ? num2.intValue() : 0;
        if (arrayList2.isEmpty()) {
            numValueOf2 = null;
        } else {
            numValueOf2 = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex2) {
                int i3 = 1;
                while (true) {
                    Integer numValueOf5 = Integer.valueOf(((Placeable) arrayList2.get(i3)).getHeight());
                    if (numValueOf5.compareTo(numValueOf2) > 0) {
                        numValueOf2 = numValueOf5;
                    }
                    if (i3 == lastIndex2) {
                        break;
                    }
                    i3++;
                }
            }
        }
        Integer num3 = numValueOf2;
        final int iIntValue2 = num3 != null ? num3.intValue() : 0;
        long jM8773copyZbe2FdA$default2 = Constraints.m8773copyZbe2FdA$default(ConstraintsKt.m8803offsetNN6EwU$default(jM8773copyZbe2FdA$default, 0, -iIntValue2, 1, null), 0, iIntValue, 0, 0, 13, null);
        ArrayList arrayList3 = new ArrayList(list3.size());
        int size2 = list3.size();
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList3.add(list3.get(i4).mo7445measureBRTryo0(jM8773copyZbe2FdA$default2));
        }
        final ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            numValueOf3 = null;
        } else {
            numValueOf3 = Integer.valueOf(((Placeable) arrayList4.get(0)).getHeight());
            int lastIndex3 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex3) {
                int i5 = 1;
                while (true) {
                    Integer numValueOf6 = Integer.valueOf(((Placeable) arrayList4.get(i5)).getHeight());
                    if (numValueOf6.compareTo(numValueOf3) > 0) {
                        numValueOf3 = numValueOf6;
                    }
                    if (i5 == lastIndex3) {
                        break;
                    }
                    i5++;
                }
            }
        }
        Integer num4 = numValueOf3;
        int iIntValue3 = (num4 != null ? num4.intValue() : 0) + iIntValue2;
        if (arrayList4.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf7 = Integer.valueOf(((Placeable) arrayList4.get(0)).getWidth());
            int lastIndex4 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex4) {
                Integer num5 = numValueOf7;
                int i6 = 1;
                while (true) {
                    Integer numValueOf8 = Integer.valueOf(((Placeable) arrayList4.get(i6)).getWidth());
                    if (numValueOf8.compareTo(num5) > 0) {
                        num5 = numValueOf8;
                    }
                    if (i6 == lastIndex4) {
                        break;
                    }
                    i6++;
                }
                num = num5;
            } else {
                num = numValueOf7;
            }
        }
        Integer num6 = num;
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m8800constrainWidthK40F9xA(jM8798constrainN9IONVI, Math.max(iIntValue, num6 != null ? num6.intValue() : 0)), ConstraintsKt.m8799constrainHeightK40F9xA(jM8798constrainN9IONVI, iIntValue3), null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchBarKt$DockedSearchBarLayout$2$2$1.measure_3p2s80s$lambda$8(arrayList2, arrayList4, iIntValue2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$8(List list, List list2, int i, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i2), 0, 0, 0.0f, 4, null);
        }
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list2.get(i3), 0, i, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
