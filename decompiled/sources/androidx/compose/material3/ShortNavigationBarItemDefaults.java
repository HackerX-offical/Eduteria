package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: compiled from: ShortNavigationBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JU\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\u0005*\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/ShortNavigationBarItemDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/NavigationItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "colors-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/NavigationItemColors;", "defaultShortNavigationBarItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultShortNavigationBarItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/NavigationItemColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ShortNavigationBarItemDefaults {
    public static final int $stable = 0;
    public static final ShortNavigationBarItemDefaults INSTANCE = new ShortNavigationBarItemDefaults();

    private ShortNavigationBarItemDefaults() {
    }

    public final NavigationItemColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 954437293, "C(colors)287@12395L11:ShortNavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(954437293, i, -1, "androidx.compose.material3.ShortNavigationBarItemDefaults.colors (ShortNavigationBar.kt:287)");
        }
        NavigationItemColors defaultShortNavigationBarItemColors$material3 = getDefaultShortNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultShortNavigationBarItemColors$material3;
    }

    /* JADX INFO: renamed from: colors-69fazGs, reason: not valid java name */
    public final NavigationItemColors m3430colors69fazGs(long j, long j2, long j3, long j4, long j5, long j6, long j7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1801697574, "C(colors)N(selectedIconColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,selectedIndicatorColor:c#ui.graphics.Color,unselectedIconColor:c#ui.graphics.Color,unselectedTextColor:c#ui.graphics.Color,disabledIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color)304@13432L5,305@13519L5,306@13611L5,307@13697L5,308@13788L5,312@14015L11:ShortNavigationBar.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIconColor(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveLabelTextColor(), composer, 6) : j2;
        long value3 = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorColor(), composer, 6) : j3;
        long value4 = (i2 & 8) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveIconColor(), composer, 6) : j4;
        long value5 = (i2 & 16) != 0 ? ColorSchemeKt.getValue(NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor(), composer, 6) : j5;
        long jM5967copywmQWz5c$default = (i2 & 32) != 0 ? Color.m5967copywmQWz5c$default(value4, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM5967copywmQWz5c$default2 = (i2 & 64) != 0 ? Color.m5967copywmQWz5c$default(value5, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801697574, i, -1, "androidx.compose.material3.ShortNavigationBarItemDefaults.colors (ShortNavigationBar.kt:312)");
        }
        NavigationItemColors navigationItemColorsM3174copy4JmcsL4 = getDefaultShortNavigationBarItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3174copy4JmcsL4(value, value2, value3, value4, value5, jM5967copywmQWz5c$default, jM5967copywmQWz5c$default2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return navigationItemColorsM3174copy4JmcsL4;
    }

    public final NavigationItemColors getDefaultShortNavigationBarItemColors$material3(ColorScheme colorScheme) {
        NavigationItemColors defaultShortNavigationBarItemColorsCached = colorScheme.getDefaultShortNavigationBarItemColorsCached();
        if (defaultShortNavigationBarItemColorsCached != null) {
            return defaultShortNavigationBarItemColorsCached;
        }
        NavigationItemColors navigationItemColors = new NavigationItemColors(ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getItemActiveIconColor()), ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getItemActiveLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getItemActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getItemInactiveIconColor()), ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getItemInactiveIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, NavigationBarTokens.INSTANCE.getItemInactiveLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultShortNavigationBarItemColorsCached$material3(navigationItemColors);
        return navigationItemColors;
    }
}
