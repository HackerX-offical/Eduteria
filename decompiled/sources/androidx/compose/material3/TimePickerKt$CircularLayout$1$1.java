package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class TimePickerKt$CircularLayout$1$1 implements MeasurePolicy {
    final /* synthetic */ float $radiusToSizeRatio;

    TimePickerKt$CircularLayout$1$1(float f2) {
        this.$radiusToSizeRatio = f2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, final long j) {
        Measurable measurable;
        Measurable measurable2;
        final float fM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j) * this.$radiusToSizeRatio;
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list.size());
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable3 = list.get(i2);
            Measurable measurable4 = measurable3;
            if (LayoutIdKt.getLayoutId(measurable4) != LayoutId.Selector && LayoutIdKt.getLayoutId(measurable4) != LayoutId.InnerCircle) {
                arrayList.add(measurable3);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            arrayList3.add(((Measurable) arrayList2.get(i3)).mo7445measureBRTryo0(jM8773copyZbe2FdA$default));
        }
        final ArrayList arrayList4 = arrayList3;
        int size3 = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                measurable = null;
                break;
            }
            measurable = list.get(i4);
            if (LayoutIdKt.getLayoutId(measurable) == LayoutId.Selector) {
                break;
            }
            i4++;
        }
        Measurable measurable5 = measurable;
        int size4 = list2.size();
        while (true) {
            if (i >= size4) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i);
            if (LayoutIdKt.getLayoutId(measurable2) == LayoutId.InnerCircle) {
                break;
            }
            i++;
        }
        Measurable measurable6 = measurable2;
        final float size5 = 6.2831855f / arrayList4.size();
        Placeable placeableMo7445measureBRTryo0 = measurable5 != null ? measurable5.mo7445measureBRTryo0(jM8773copyZbe2FdA$default) : null;
        final Placeable placeableMo7445measureBRTryo02 = measurable6 != null ? measurable6.mo7445measureBRTryo0(jM8773copyZbe2FdA$default) : null;
        final Placeable placeable = placeableMo7445measureBRTryo0;
        return MeasureScope.layout$default(measureScope, Constraints.m8785getMinWidthimpl(j), Constraints.m8784getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt$CircularLayout$1$1.measure_3p2s80s$lambda$5(placeable, arrayList4, placeableMo7445measureBRTryo02, j, fM8782getMaxHeightimpl, size5, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$5(Placeable placeable, List list, Placeable placeable2, long j, float f2, float f3, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable placeable3 = (Placeable) list.get(i);
            double d2 = f2;
            double d3 = ((double) (i * f3)) - 1.5707963267948966d;
            Placeable.PlacementScope.place$default(placementScope, placeable3, MathKt.roundToInt((Math.cos(d3) * d2) + ((double) ((Constraints.m8783getMaxWidthimpl(j) / 2) - (placeable3.getWidth() / 2)))), MathKt.roundToInt((d2 * Math.sin(d3)) + ((double) ((Constraints.m8782getMaxHeightimpl(j) / 2) - (placeable3.getHeight() / 2)))), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable2, (Constraints.m8785getMinWidthimpl(j) - placeable2.getWidth()) / 2, (Constraints.m8784getMinHeightimpl(j) - placeable2.getHeight()) / 2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
