package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJK\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001f\u0010 J5\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u0005H\u0007¢\u0006\u0004\b(\u0010)J-\u0010!\u001a\u00020*2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u0005H\u0007¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJK\u0010-\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b.\u0010\u0016JK\u00103\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0004\b4\u0010 R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0018\u0010/\u001a\u00020\f*\u0002008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00105\u001a\u0002068G¢\u0006\u0006\u001a\u0004\b7\u00108¨\u00069"}, d2 = {"Landroidx/compose/material3/SuggestionChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "suggestionChipColors", "Landroidx/compose/material3/ChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledIconContentColor", "suggestionChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "suggestionChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "suggestionChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "suggestionChipBorder", "Landroidx/compose/foundation/BorderStroke;", StreamManagement.Enabled.ELEMENT, "", "borderColor", "disabledBorderColor", "borderWidth", "suggestionChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "Landroidx/compose/material3/ChipBorder;", "suggestionChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "elevatedSuggestionChipColors", "elevatedSuggestionChipColors-5tl4gsc", "defaultElevatedSuggestionChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedSuggestionChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "elevatedSuggestionChipElevation", "elevatedSuggestionChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SuggestionChipDefaults {
    public static final int $stable = 0;
    public static final SuggestionChipDefaults INSTANCE = new SuggestionChipDefaults();
    private static final float Height = SuggestionChipTokens.INSTANCE.m4845getContainerHeightD9Ej5fM();
    private static final float IconSize = SuggestionChipTokens.INSTANCE.m4854getLeadingIconSizeD9Ej5fM();

    private SuggestionChipDefaults() {
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m3525getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3526getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ChipColors suggestionChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1918570697, "C(suggestionChipColors)1733@86525L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1918570697, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1733)");
        }
        ChipColors defaultSuggestionChipColors = ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSuggestionChipColors;
    }

    /* JADX INFO: renamed from: suggestionChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m3529suggestionChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1882647883, "C(suggestionChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledIconContentColor:c#ui.graphics.Color)1755@87603L11:Chip.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1882647883, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipColors (Chip.kt:1755)");
        }
        ChipColors chipColorsM2563copyFD3wquc = ChipKt.getDefaultSuggestionChipColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2563copyFD3wquc(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, Color.INSTANCE.m6004getUnspecified0d7_KjU(), jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, Color.INSTANCE.m6004getUnspecified0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM2563copyFD3wquc;
    }

    /* JADX INFO: renamed from: suggestionChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m3530suggestionChipElevationaqJV_2Y(float f2, float f3, float f4, float f5, float f6, float f7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1929994057, "C(suggestionChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = SuggestionChipTokens.INSTANCE.m4852getFlatContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        float f9 = (i2 & 2) != 0 ? f8 : f3;
        float f10 = (i2 & 4) != 0 ? f8 : f4;
        float f11 = (i2 & 8) != 0 ? f8 : f5;
        float fM4846getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? SuggestionChipTokens.INSTANCE.m4846getDraggedContainerElevationD9Ej5fM() : f6;
        float f12 = (i2 & 32) != 0 ? f8 : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1929994057, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipElevation (Chip.kt:1786)");
        }
        ChipElevation chipElevation = new ChipElevation(f8, f9, f10, f11, fM4846getDraggedContainerElevationD9Ej5fM, f12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipElevation;
    }

    /* JADX INFO: renamed from: suggestionChipBorder-h1eT-Ww, reason: not valid java name */
    public final BorderStroke m3528suggestionChipBorderh1eTWw(boolean z, long j, long j2, float f2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -637354809, "C(suggestionChipBorder)N(enabled,borderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp)1806@89984L5,1808@90086L5:Chip.kt#uh7d8r");
        long value = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : j;
        long jM5967copywmQWz5c$default = (i2 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        float fM4853getFlatOutlineWidthD9Ej5fM = (i2 & 8) != 0 ? SuggestionChipTokens.INSTANCE.m4853getFlatOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-637354809, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1812)");
        }
        if (!z) {
            value = jM5967copywmQWz5c$default;
        }
        BorderStroke borderStrokeM348BorderStrokecXLIe8U = BorderStrokeKt.m348BorderStrokecXLIe8U(fM4853getFlatOutlineWidthD9Ej5fM, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM348BorderStrokecXLIe8U;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the suggestChipBorder functions instead", replaceWith = @ReplaceWith(expression = "suggestionChipBorder(enabled, borderColor, disabledBorderColor, borderWidth)", imports = {}))
    /* JADX INFO: renamed from: suggestionChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m3527suggestionChipBorderd_3_b6Q(long j, long j2, float f2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 439283919, "C(suggestionChipBorder)N(borderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp)1832@91145L5,1834@91247L5:Chip.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : j;
        long jM5967copywmQWz5c$default = (i2 & 2) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), SuggestionChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        float fM4853getFlatOutlineWidthD9Ej5fM = (i2 & 4) != 0 ? SuggestionChipTokens.INSTANCE.m4853getFlatOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(439283919, i, -1, "androidx.compose.material3.SuggestionChipDefaults.suggestionChipBorder (Chip.kt:1839)");
        }
        ChipBorder chipBorder = new ChipBorder(value, jM5967copywmQWz5c$default, fM4853getFlatOutlineWidthD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipBorder;
    }

    public final ChipColors elevatedSuggestionChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1671233087, "C(elevatedSuggestionChipColors)1851@91827L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1671233087, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1851)");
        }
        ChipColors defaultElevatedSuggestionChipColors$material3 = getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedSuggestionChipColors$material3;
    }

    /* JADX INFO: renamed from: elevatedSuggestionChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m3523elevatedSuggestionChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1269423125, "C(elevatedSuggestionChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledIconContentColor:c#ui.graphics.Color)1873@92926L11:Chip.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1269423125, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipColors (Chip.kt:1873)");
        }
        ChipColors chipColorsM2563copyFD3wquc = getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2563copyFD3wquc(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, Color.INSTANCE.m6004getUnspecified0d7_KjU(), jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, Color.INSTANCE.m6004getUnspecified0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM2563copyFD3wquc;
    }

    public final ChipColors getDefaultElevatedSuggestionChipColors$material3(ColorScheme colorScheme) {
        ChipColors defaultElevatedSuggestionChipColorsCached = colorScheme.getDefaultElevatedSuggestionChipColorsCached();
        if (defaultElevatedSuggestionChipColorsCached != null) {
            return defaultElevatedSuggestionChipColorsCached;
        }
        ChipColors chipColors = new ChipColors(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getElevatedContainerColor()), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getElevatedDisabledContainerColor()), AssistChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6004getUnspecified0d7_KjU(), null);
        colorScheme.setDefaultElevatedSuggestionChipColorsCached$material3(chipColors);
        return chipColors;
    }

    /* JADX INFO: renamed from: elevatedSuggestionChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m3524elevatedSuggestionChipElevationaqJV_2Y(float f2, float f3, float f4, float f5, float f6, float f7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1118088467, "C(elevatedSuggestionChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = SuggestionChipTokens.INSTANCE.m4847getElevatedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 2) != 0) {
            f3 = SuggestionChipTokens.INSTANCE.m4851getElevatedPressedContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 4) != 0) {
            f4 = SuggestionChipTokens.INSTANCE.m4849getElevatedFocusContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 8) != 0) {
            f5 = SuggestionChipTokens.INSTANCE.m4850getElevatedHoverContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        float fM4846getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? SuggestionChipTokens.INSTANCE.m4846getDraggedContainerElevationD9Ej5fM() : f6;
        float fM4848getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? SuggestionChipTokens.INSTANCE.m4848getElevatedDisabledContainerElevationD9Ej5fM() : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1118088467, i, -1, "androidx.compose.material3.SuggestionChipDefaults.elevatedSuggestionChipElevation (Chip.kt:1926)");
        }
        ChipElevation chipElevation = new ChipElevation(f8, f9, f10, f11, fM4846getDraggedContainerElevationD9Ej5fM, fM4848getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 641188183, "C(<get-shape>)1937@96518L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(641188183, i, -1, "androidx.compose.material3.SuggestionChipDefaults.<get-shape> (Chip.kt:1937)");
        }
        Shape value = ShapesKt.getValue(SuggestionChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }
}
