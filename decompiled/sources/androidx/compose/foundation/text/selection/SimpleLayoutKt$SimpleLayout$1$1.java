package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SimpleLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class SimpleLayoutKt$SimpleLayout$1$1 implements MeasurePolicy {
    public static final SimpleLayoutKt$SimpleLayout$1$1 INSTANCE = new SimpleLayoutKt$SimpleLayout$1$1();

    SimpleLayoutKt$SimpleLayout$1$1() {
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size; i++) {
            Placeable placeableMo7445measureBRTryo0 = list.get(i).mo7445measureBRTryo0(j);
            iMax = Math.max(iMax, placeableMo7445measureBRTryo0.getWidth());
            iMax2 = Math.max(iMax2, placeableMo7445measureBRTryo0.getHeight());
            arrayList.add(placeableMo7445measureBRTryo0);
        }
        final ArrayList arrayList2 = arrayList;
        return MeasureScope.layout$default(measureScope, iMax, iMax2, null, new Function1() { // from class: androidx.compose.foundation.text.selection.SimpleLayoutKt$SimpleLayout$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SimpleLayoutKt$SimpleLayout$1$1.measure_3p2s80s$lambda$1(arrayList2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(List list, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
