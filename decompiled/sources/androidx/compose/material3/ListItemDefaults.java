package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015Ji\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010 \u001a\u00020\u0014*\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/material3/ListItemDefaults;", "", "<init>", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "colors", "Landroidx/compose/material3/ListItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ListItemColors;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "defaultListItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultListItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ListItemColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListItemDefaults {
    public static final int $stable = 0;
    public static final ListItemDefaults INSTANCE = new ListItemDefaults();
    private static final float Elevation = ListTokens.INSTANCE.m4569getListItemContainerElevationD9Ej5fM();

    private ListItemDefaults() {
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m3051getElevationD9Ej5fM() {
        return Elevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -496871597, "C(<get-shape>)532@21325L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-496871597, i, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:532)");
        }
        Shape value = ShapesKt.getValue(ListTokens.INSTANCE.getListItemContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1253579929, "C(<get-containerColor>)536@21490L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1253579929, i, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItem.kt:536)");
        }
        long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1076068327, "C(<get-contentColor>)540@21651L5:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1076068327, i, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItem.kt:540)");
        }
        long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getListItemLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final ListItemColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -552214416, "C(colors)546@21839L11:ListItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-552214416, i, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:546)");
        }
        ListItemColors defaultListItemColors$material3 = getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultListItemColors$material3;
    }

    /* JADX INFO: renamed from: colors-J08w3-E, reason: not valid java name */
    public final ListItemColors m3050colorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -352515689, "C(colors)N(containerColor:c#ui.graphics.Color,headlineColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,overlineColor:c#ui.graphics.Color,supportingColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledHeadlineColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color)576@23403L11:ListItem.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        long jM6004getUnspecified0d7_KjU7 = (i2 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j7;
        long jM6004getUnspecified0d7_KjU8 = (i2 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j8;
        long jM6004getUnspecified0d7_KjU9 = (i2 & 256) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-352515689, i, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:576)");
        }
        ListItemColors listItemColorsM3035copy5r9EGqc = getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3035copy5r9EGqc(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, jM6004getUnspecified0d7_KjU7, jM6004getUnspecified0d7_KjU8, jM6004getUnspecified0d7_KjU9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listItemColorsM3035copy5r9EGqc;
    }

    public final ListItemColors getDefaultListItemColors$material3(ColorScheme colorScheme) {
        ListItemColors defaultListItemColorsCached = colorScheme.getDefaultListItemColorsCached();
        if (defaultListItemColorsCached != null) {
            return defaultListItemColorsCached;
        }
        ListItemColors listItemColors = new ListItemColors(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemContainerColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemOverlineColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemTrailingIconColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemDisabledLabelTextColor()), ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemDisabledLeadingIconColor()), ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getListItemDisabledTrailingIconColor()), ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultListItemColorsCached$material3(listItemColors);
        return listItemColors;
    }
}
