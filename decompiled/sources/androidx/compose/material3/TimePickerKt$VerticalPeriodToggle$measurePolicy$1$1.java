package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 implements MeasurePolicy {
    public static final TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 INSTANCE = new TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1();

    TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(List list, Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(0), 0, 0, 0.0f, 4, null);
        Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(1), 0, ((Placeable) list.get(0)).getHeight(), 0.0f, 4, null);
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, ((Placeable) list.get(0)).getHeight() - (placeable.getHeight() / 2), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, measureScope.mo482roundToPx0680j_4(TimePickerTokens.INSTANCE.m4883getPeriodSelectorOutlineWidthD9Ej5fM()), 3, null));
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Measurable measurable2 = list.get(i2);
                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "Spacer")) {
                        arrayList.add(measurable2);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(arrayList2.size());
                int size3 = arrayList2.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    arrayList3.add(((Measurable) arrayList2.get(i3)).mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, Constraints.m8782getMaxHeightimpl(j) / 2, 3, null)));
                }
                final ArrayList arrayList4 = arrayList3;
                return MeasureScope.layout$default(measureScope, Constraints.m8783getMaxWidthimpl(j), Constraints.m8782getMaxHeightimpl(j), null, new Function1() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.measure_3p2s80s$lambda$3(arrayList4, placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
                    }
                }, 4, null);
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
