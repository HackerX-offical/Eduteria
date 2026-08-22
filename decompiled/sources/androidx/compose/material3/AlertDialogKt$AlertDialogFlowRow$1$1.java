package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class AlertDialogKt$AlertDialogFlowRow$1$1 implements MeasurePolicy {
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ float $mainAxisSpacing;

    AlertDialogKt$AlertDialogFlowRow$1$1(float f2, float f3) {
        this.$mainAxisSpacing = f2;
        this.$crossAxisSpacing = f3;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        List<? extends Measurable> list2 = list;
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        ArrayList arrayList4 = new ArrayList();
        Ref.IntRef intRef3 = new Ref.IntRef();
        Ref.IntRef intRef4 = new Ref.IntRef();
        float f2 = this.$mainAxisSpacing;
        float f3 = this.$crossAxisSpacing;
        int size = list2.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = size;
            Placeable placeableMo7445measureBRTryo0 = list2.get(i2).mo7445measureBRTryo0(j);
            Ref.IntRef intRef5 = intRef3;
            intRef3 = intRef5;
            if (measure_3p2s80s$canAddToCurrentSequence(arrayList4, intRef5, measureScope, f2, j, placeableMo7445measureBRTryo0)) {
                i = i2;
            } else {
                i = i2;
                measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, f3, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
            }
            if (!arrayList4.isEmpty()) {
                intRef3.element += measureScope.mo482roundToPx0680j_4(f2);
            }
            arrayList4.add(placeableMo7445measureBRTryo0);
            intRef3.element += placeableMo7445measureBRTryo0.getWidth();
            intRef4.element = Math.max(intRef4.element, placeableMo7445measureBRTryo0.getHeight());
            i2 = i + 1;
            list2 = list;
            size = i3;
        }
        if (!arrayList4.isEmpty()) {
            measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, this.$crossAxisSpacing, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
        }
        final int iMax = Math.max(intRef.element, Constraints.m8785getMinWidthimpl(j));
        int iMax2 = Math.max(intRef2.element, Constraints.m8784getMinHeightimpl(j));
        final float f4 = this.$mainAxisSpacing;
        return MeasureScope.layout$default(measureScope, iMax, iMax2, null, new Function1() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AlertDialogKt$AlertDialogFlowRow$1$1.measure_3p2s80s$lambda$4(arrayList, measureScope, f4, iMax, arrayList3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f2, long j, Placeable placeable) {
        return list.isEmpty() || (intRef.element + measureScope.mo482roundToPx0680j_4(f2)) + placeable.getWidth() <= Constraints.m8783getMaxWidthimpl(j);
    }

    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f2, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
        if (!list.isEmpty()) {
            intRef.element += measureScope.mo482roundToPx0680j_4(f2);
        }
        list.add(0, CollectionsKt.toList(list2));
        list3.add(Integer.valueOf(intRef2.element));
        list4.add(Integer.valueOf(intRef.element));
        intRef.element += intRef2.element;
        intRef3.element = Math.max(intRef3.element, intRef4.element);
        list2.clear();
        intRef4.element = 0;
        intRef2.element = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$4(List list, MeasureScope measureScope, float f2, int i, List list2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            List list3 = (List) list.get(i2);
            int size2 = list3.size();
            int[] iArr = new int[size2];
            int i3 = 0;
            while (i3 < size2) {
                iArr[i3] = ((Placeable) list3.get(i3)).getWidth() + (i3 < CollectionsKt.getLastIndex(list3) ? measureScope.mo482roundToPx0680j_4(f2) : 0);
                i3++;
            }
            int[] iArr2 = new int[size2];
            Arrangement.INSTANCE.getEnd().arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
            int size3 = list3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) list3.get(i4), iArr2[i4], ((Number) list2.get(i2)).intValue(), 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }
}
