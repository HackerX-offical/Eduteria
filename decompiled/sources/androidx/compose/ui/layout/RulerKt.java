package androidx.compose.ui.layout;

import kotlin.Metadata;

/* JADX INFO: compiled from: Ruler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"mergeRulerValues", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "useGreater", "", "rulers", "", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Z[Landroidx/compose/ui/layout/Ruler;F)F", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RulerKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float mergeRulerValues(androidx.compose.ui.layout.Placeable.PlacementScope r7, boolean r8, androidx.compose.ui.layout.Ruler[] r9, float r10) {
        /*
            int r0 = r9.length
            r1 = 2143289344(0x7fc00000, float:NaN)
            r2 = 0
            r4 = r1
            r3 = r2
        L6:
            if (r3 >= r0) goto L21
            r5 = r9[r3]
            float r5 = r7.current(r5, r1)
            boolean r6 = java.lang.Float.isNaN(r4)
            if (r6 != 0) goto L1d
            int r6 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r6 <= 0) goto L1a
            r6 = 1
            goto L1b
        L1a:
            r6 = r2
        L1b:
            if (r8 != r6) goto L1e
        L1d:
            r4 = r5
        L1e:
            int r3 = r3 + 1
            goto L6
        L21:
            boolean r7 = java.lang.Float.isNaN(r4)
            if (r7 == 0) goto L28
            return r10
        L28:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.RulerKt.mergeRulerValues(androidx.compose.ui.layout.Placeable$PlacementScope, boolean, androidx.compose.ui.layout.Ruler[], float):float");
    }
}
