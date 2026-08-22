package androidx.compose.material3;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $dismissActionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2$1(String str, String str2, String str3) {
        this.$actionTag = str;
        this.$dismissActionTag = str2;
        this.$textTag = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0156 A[PHI: r0 r4
      0x0156: PHI (r0v12 int) = (r0v11 int), (r0v18 int), (r0v18 int) binds: [B:61:0x014b, B:56:0x011d, B:58:0x0129] A[DONT_GENERATE, DONT_INLINE]
      0x0156: PHI (r4v5 int) = (r4v4 int), (r4v13 int), (r4v13 int) binds: [B:61:0x014b, B:56:0x011d, B:58:0x0129] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.layout.MeasureResult mo44measure3p2s80s(androidx.compose.ui.layout.MeasureScope r22, java.util.List<? extends androidx.compose.ui.layout.Measurable> r23, long r24) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.mo44measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$4(Placeable placeable, int i, Placeable placeable2, int i2, int i3, Placeable placeable3, int i4, int i5, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2, i3, 0.0f, 4, null);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i4, i5, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
