package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
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

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class NavigationDrawerKt$ModalNavigationDrawer$2$6$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<Boolean> $anchorsInitialized$delegate;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ MutableFloatState $minValue$delegate;

    NavigationDrawerKt$ModalNavigationDrawer$2$6$1(DrawerState drawerState, MutableState<Boolean> mutableState, MutableFloatState mutableFloatState, float f2) {
        this.$drawerState = drawerState;
        this.$anchorsInitialized$delegate = mutableState;
        this.$minValue$delegate = mutableFloatState;
        this.$maxValue = f2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Integer numValueOf;
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).mo7445measureBRTryo0(jM8773copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        Integer num = null;
        int i2 = 1;
        if (arrayList2.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i3 = 1;
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Placeable) arrayList2.get(i3)).getWidth());
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        Integer num2 = numValueOf;
        int iIntValue = num2 != null ? num2.intValue() : 0;
        if (!arrayList2.isEmpty()) {
            Integer numValueOf3 = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex2) {
                while (true) {
                    Integer numValueOf4 = Integer.valueOf(((Placeable) arrayList2.get(i2)).getHeight());
                    if (numValueOf4.compareTo(numValueOf3) > 0) {
                        numValueOf3 = numValueOf4;
                    }
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2++;
                }
            }
            num = numValueOf3;
        }
        Integer num3 = num;
        int iIntValue2 = num3 != null ? num3.intValue() : 0;
        final DrawerState drawerState = this.$drawerState;
        final MutableState<Boolean> mutableState = this.$anchorsInitialized$delegate;
        final int i4 = iIntValue;
        final MutableFloatState mutableFloatState = this.$minValue$delegate;
        final float f2 = this.$maxValue;
        return MeasureScope.layout$default(measureScope, i4, iIntValue2, null, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$6$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt$ModalNavigationDrawer$2$6$1.measure_3p2s80s$lambda$5(drawerState, i4, arrayList2, mutableState, mutableFloatState, f2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$5(DrawerState drawerState, int i, List list, MutableState mutableState, final MutableFloatState mutableFloatState, final float f2, Placeable.PlacementScope placementScope) {
        float fPositionOf = drawerState.getAnchoredDraggableState$material3().getAnchors().positionOf(DrawerValue.Closed);
        float f3 = -i;
        if (!NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$5(mutableState) || fPositionOf != f3) {
            if (!NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$5(mutableState)) {
                NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$6(mutableState, true);
            }
            mutableFloatState.setFloatValue(f3);
            AnchoredDraggableState.updateAnchors$default(drawerState.getAnchoredDraggableState$material3(), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$6$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavigationDrawerKt$ModalNavigationDrawer$2$6$1.measure_3p2s80s$lambda$5$lambda$3(f2, mutableFloatState, (DraggableAnchorsConfig) obj);
                }
            }), null, 2, null);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i2), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$5$lambda$3(float f2, MutableFloatState mutableFloatState, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(DrawerValue.Closed, NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$8(mutableFloatState));
        draggableAnchorsConfig.at(DrawerValue.Open, f2);
        return Unit.INSTANCE;
    }
}
