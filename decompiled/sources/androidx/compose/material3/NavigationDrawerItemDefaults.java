package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J_\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/NavigationDrawerItemDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedContainerColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContainerColor", "selectedIconColor", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedBadgeColor", "unselectedBadgeColor", "colors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationDrawerItemColors;", "ItemPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerItemDefaults {
    public static final int $stable = 0;
    public static final NavigationDrawerItemDefaults INSTANCE = new NavigationDrawerItemDefaults();
    private static final PaddingValues ItemPadding = PaddingKt.m1146PaddingValuesYgX7TsA$default(Dp.m8830constructorimpl(12), 0.0f, 2, null);

    private NavigationDrawerItemDefaults() {
    }

    /* JADX INFO: renamed from: colors-oq7We08, reason: not valid java name */
    public final NavigationDrawerItemColors m3148colorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1574983348, "C(colors)N(selectedContainerColor:c#ui.graphics.Color,unselectedContainerColor:c#ui.graphics.Color,selectedIconColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color,selectedBadgeColor:c#ui.graphics.Color,unselectedBadgeColor:c#ui.graphics.Color)1163@49558L5,1165@49700L5,1166@49785L5,1167@49871L5,1168@49961L5:NavigationDrawer.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorColor(), composer, 6) : j;
        long jM6003getTransparent0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j2;
        long value2 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIconColor(), composer, 6) : j3;
        long value3 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getInactiveIconColor(), composer, 6) : j4;
        long value4 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveLabelTextColor(), composer, 6) : j5;
        long value5 = (i2 & 32) != 0 ? ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getInactiveLabelTextColor(), composer, 6) : j6;
        long j9 = (i2 & 64) != 0 ? value4 : j7;
        long j10 = (i2 & 128) != 0 ? value5 : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1574983348, i, -1, "androidx.compose.material3.NavigationDrawerItemDefaults.colors (NavigationDrawer.kt:1172)");
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = new DefaultDrawerItemsColor(value2, value3, value4, value5, value, jM6003getTransparent0d7_KjU, j9, j10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDrawerItemsColor;
    }

    public final PaddingValues getItemPadding() {
        return ItemPadding;
    }
}
