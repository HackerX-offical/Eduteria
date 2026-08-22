package androidx.compose.material3;

import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppBarDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00020\r*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/OverflowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/material3/AppBarOverflowState;", "maxItemCount", "", "isVertical", "", "<init>", "(Landroidx/compose/material3/AppBarOverflowState;IZ)V", "getMaxItemCount", "()I", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OverflowMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable = 0;
    private final boolean isVertical;
    private final int maxItemCount;
    private final AppBarOverflowState overflowState;

    public OverflowMeasurePolicy(AppBarOverflowState appBarOverflowState, int i, boolean z) {
        this.overflowState = appBarOverflowState;
        this.maxItemCount = i;
        this.isVertical = z;
    }

    public /* synthetic */ OverflowMeasurePolicy(AppBarOverflowState appBarOverflowState, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(appBarOverflowState, i, (i2 & 4) != 0 ? false : z);
    }

    public final int getMaxItemCount() {
        return this.maxItemCount;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.ui.layout.MeasureResult mo1016measure3p2s80s(androidx.compose.ui.layout.MeasureScope r21, java.util.List<? extends java.util.List<? extends androidx.compose.ui.layout.Measurable>> r22, long r23) {
        /*
            Method dump skipped, instruction units count: 890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OverflowMeasurePolicy.mo1016measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$11(List list, List list2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        int i = 0;
        int height = 0;
        while (i < size) {
            Placeable placeable = (Placeable) list.get(i);
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, 0, height, 0.0f, 4, null);
            height += placeable.getHeight();
            i++;
            placementScope = placementScope2;
        }
        Placeable.PlacementScope placementScope3 = placementScope;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Placeable.PlacementScope.placeRelative$default(placementScope3, (Placeable) list2.get(i2), 0, height, 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$14(List list, List list2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        int i = 0;
        int width = 0;
        while (i < size) {
            Placeable placeable = (Placeable) list.get(i);
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, width, 0, 0.0f, 4, null);
            width += placeable.getWidth();
            i++;
            placementScope = placementScope2;
        }
        Placeable.PlacementScope placementScope3 = placementScope;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                Placeable.PlacementScope.placeRelative$default(placementScope3, (Placeable) list2.get(i2), width, 0, 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }
}
