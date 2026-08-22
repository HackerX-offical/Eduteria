package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<Boolean> $anchorsInitialized$delegate;
    final /* synthetic */ DrawerState $drawerState;

    NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(DrawerState drawerState, MutableState<Boolean> mutableState) {
        this.$drawerState = drawerState;
        this.$anchorsInitialized$delegate = mutableState;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final Placeable placeableMo7445measureBRTryo0 = list.get(0).mo7445measureBRTryo0(j);
        final Placeable placeableMo7445measureBRTryo02 = list.get(1).mo7445measureBRTryo0(j);
        int width = placeableMo7445measureBRTryo02.getWidth();
        int height = placeableMo7445measureBRTryo02.getHeight();
        final DrawerState drawerState = this.$drawerState;
        final MutableState<Boolean> mutableState = this.$anchorsInitialized$delegate;
        return MeasureScope.layout$default(measureScope, width, height, null, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.measure_3p2s80s$lambda$1(drawerState, placeableMo7445measureBRTryo0, placeableMo7445measureBRTryo02, mutableState, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(DrawerState drawerState, Placeable placeable, Placeable placeable2, MutableState mutableState, Placeable.PlacementScope placementScope) {
        float fPositionOf = drawerState.getAnchoredDraggableState$material3().getAnchors().positionOf(DrawerValue.Closed);
        final float f2 = -placeable.getWidth();
        if (!NavigationDrawerKt.DismissibleNavigationDrawer$lambda$27(mutableState) || fPositionOf != f2) {
            if (!NavigationDrawerKt.DismissibleNavigationDrawer$lambda$27(mutableState)) {
                NavigationDrawerKt.DismissibleNavigationDrawer$lambda$28(mutableState, true);
            }
            AnchoredDraggableState.updateAnchors$default(drawerState.getAnchoredDraggableState$material3(), AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.measure_3p2s80s$lambda$1$lambda$0(f2, (DraggableAnchorsConfig) obj);
                }
            }), null, 2, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, placeable.getWidth() + MathKt.roundToInt(drawerState.requireOffset$material3()), 0, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, MathKt.roundToInt(drawerState.requireOffset$material3()), 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1$lambda$0(float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(DrawerValue.Closed, f2);
        draggableAnchorsConfig.at(DrawerValue.Open, 0.0f);
        return Unit.INSTANCE;
    }
}
