package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000fJ\u0091\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJK\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u0005H\u0007¢\u0006\u0004\b,\u0010-J[\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\u00112\b\b\u0002\u00104\u001a\u00020\u00112\b\b\u0002\u00105\u001a\u00020\u00112\b\b\u0002\u00106\u001a\u00020\u00112\b\b\u0002\u00107\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\u0005H\u0007¢\u0006\u0004\b9\u0010:R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0018\u0010 \u001a\u00020\u000e*\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010;\u001a\u00020<8G¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006?"}, d2 = {"Landroidx/compose/material3/InputChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "AvatarSize", "getAvatarSize-D9Ej5fM", "inputChipColors", "Landroidx/compose/material3/SelectableChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "inputChipColors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "defaultInputChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultInputChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "inputChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "inputChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "inputChipBorder", "Landroidx/compose/foundation/BorderStroke;", StreamManagement.Enabled.ELEMENT, "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "inputChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InputChipDefaults {
    public static final int $stable = 0;
    public static final InputChipDefaults INSTANCE = new InputChipDefaults();
    private static final float Height = InputChipTokens.INSTANCE.m4542getContainerHeightD9Ej5fM();
    private static final float IconSize = InputChipTokens.INSTANCE.m4544getLeadingIconSizeD9Ej5fM();
    private static final float AvatarSize = InputChipTokens.INSTANCE.m4540getAvatarSizeD9Ej5fM();

    private InputChipDefaults() {
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m3016getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3017getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getAvatarSize-D9Ej5fM, reason: not valid java name */
    public final float m3015getAvatarSizeD9Ej5fM() {
        return AvatarSize;
    }

    public final SelectableChipColors inputChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -770375587, "C(inputChipColors)1562@77510L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-770375587, i, -1, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1562)");
        }
        SelectableChipColors defaultInputChipColors$material3 = getDefaultInputChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultInputChipColors$material3;
    }

    /* JADX INFO: renamed from: inputChipColors-kwJvTHA, reason: not valid java name */
    public final SelectableChipColors m3019inputChipColorskwJvTHA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1312840646, "C(inputChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,disabledSelectedContainerColor:c#ui.graphics.Color,selectedLabelColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)1599@79651L11:Chip.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        long jM6004getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j7;
        long jM6004getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j8;
        long jM6004getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j9;
        long jM6004getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j10;
        long jM6004getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j11;
        long jM6004getUnspecified0d7_KjU12 = (i3 & 2048) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j12;
        long jM6004getUnspecified0d7_KjU13 = (i3 & 4096) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1312840646, i, i2, "androidx.compose.material3.InputChipDefaults.inputChipColors (Chip.kt:1599)");
        }
        SelectableChipColors selectableChipColorsM3403copydaRQuJA = getDefaultInputChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3403copydaRQuJA(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, jM6004getUnspecified0d7_KjU7, jM6004getUnspecified0d7_KjU8, jM6004getUnspecified0d7_KjU9, jM6004getUnspecified0d7_KjU10, jM6004getUnspecified0d7_KjU11, jM6004getUnspecified0d7_KjU12, jM6004getUnspecified0d7_KjU13);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipColorsM3403copydaRQuJA;
    }

    public final SelectableChipColors getDefaultInputChipColors$material3(ColorScheme colorScheme) {
        SelectableChipColors defaultInputChipColorsCached = colorScheme.getDefaultInputChipColorsCached();
        if (defaultInputChipColorsCached != null) {
            return defaultInputChipColorsCached;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getDisabledLabelTextColor()), InputChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getDisabledLeadingIconColor()), InputChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getDisabledTrailingIconColor()), InputChipTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getSelectedContainerColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getDisabledSelectedContainerColor()), InputChipTokens.INSTANCE.getDisabledSelectedContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, InputChipTokens.INSTANCE.getSelectedTrailingIconColor()), null);
        colorScheme.setDefaultInputChipColorsCached$material3(selectableChipColors);
        return selectableChipColors;
    }

    /* JADX INFO: renamed from: inputChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m3020inputChipElevationaqJV_2Y(float f2, float f3, float f4, float f5, float f6, float f7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1745270109, "C(inputChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = InputChipTokens.INSTANCE.m4541getContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        float f9 = (i2 & 2) != 0 ? f8 : f3;
        float f10 = (i2 & 4) != 0 ? f8 : f4;
        float f11 = (i2 & 8) != 0 ? f8 : f5;
        float fM4543getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? InputChipTokens.INSTANCE.m4543getDraggedContainerElevationD9Ej5fM() : f6;
        float f12 = (i2 & 32) != 0 ? f8 : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1745270109, i, -1, "androidx.compose.material3.InputChipDefaults.inputChipElevation (Chip.kt:1666)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f8, f9, f10, f11, fM4543getDraggedContainerElevationD9Ej5fM, f12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipElevation;
    }

    /* JADX INFO: renamed from: inputChipBorder-_7El2pE, reason: not valid java name */
    public final BorderStroke m3018inputChipBorder_7El2pE(boolean z, boolean z2, long j, long j2, long j3, long j4, float f2, float f3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2050575347, "C(inputChipBorder)N(enabled,selected,borderColor:c#ui.graphics.Color,selectedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,disabledSelectedBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp,selectedBorderWidth:c#ui.unit.Dp)1694@84974L5,1697@85133L5:Chip.kt#uh7d8r");
        long value = (i2 & 4) != 0 ? ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getUnselectedOutlineColor(), composer, 6) : j;
        long jM6003getTransparent0d7_KjU = (i2 & 8) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j2;
        long jM5967copywmQWz5c$default = (i2 & 16) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(InputChipTokens.INSTANCE.getDisabledUnselectedOutlineColor(), composer, 6), InputChipTokens.INSTANCE.getDisabledUnselectedOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM6003getTransparent0d7_KjU2 = (i2 & 32) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j4;
        float fM4547getUnselectedOutlineWidthD9Ej5fM = (i2 & 64) != 0 ? InputChipTokens.INSTANCE.m4547getUnselectedOutlineWidthD9Ej5fM() : f2;
        float fM4545getSelectedOutlineWidthD9Ej5fM = (i2 & 128) != 0 ? InputChipTokens.INSTANCE.m4545getSelectedOutlineWidthD9Ej5fM() : f3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2050575347, i, -1, "androidx.compose.material3.InputChipDefaults.inputChipBorder (Chip.kt:1703)");
        }
        if (!z) {
            value = z2 ? jM6003getTransparent0d7_KjU2 : jM5967copywmQWz5c$default;
        } else if (z2) {
            value = jM6003getTransparent0d7_KjU;
        }
        if (z2) {
            fM4547getUnselectedOutlineWidthD9Ej5fM = fM4545getSelectedOutlineWidthD9Ej5fM;
        }
        BorderStroke borderStrokeM348BorderStrokecXLIe8U = BorderStrokeKt.m348BorderStrokecXLIe8U(fM4547getUnselectedOutlineWidthD9Ej5fM, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM348BorderStrokecXLIe8U;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1052444143, "C(<get-shape>)1715@85906L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052444143, i, -1, "androidx.compose.material3.InputChipDefaults.<get-shape> (Chip.kt:1715)");
        }
        Shape value = ShapesKt.getValue(InputChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }
}
