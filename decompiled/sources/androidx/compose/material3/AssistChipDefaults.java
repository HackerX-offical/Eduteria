package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJ_\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018JK\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007¢\u0006\u0004\b%\u0010&J5\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0007¢\u0006\u0004\b.\u0010/J-\u0010'\u001a\u0002002\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0007¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\rJ_\u00103\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0004\b4\u0010\u0018JK\u00107\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007¢\u0006\u0004\b8\u0010&R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0018\u0010\u0019\u001a\u00020\f*\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u00105\u001a\u00020\f*\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u001cR\u0011\u00109\u001a\u00020:8G¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006="}, d2 = {"Landroidx/compose/material3/AssistChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "assistChipColors", "Landroidx/compose/material3/ChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "defaultAssistChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultAssistChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "assistChipBorder", "Landroidx/compose/foundation/BorderStroke;", StreamManagement.Enabled.ELEMENT, "", "borderColor", "disabledBorderColor", "borderWidth", "assistChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "Landroidx/compose/material3/ChipBorder;", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "defaultElevatedAssistChipColors", "getDefaultElevatedAssistChipColors$material3", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssistChipDefaults {
    public static final int $stable = 0;
    public static final AssistChipDefaults INSTANCE = new AssistChipDefaults();
    private static final float Height = AssistChipTokens.INSTANCE.m4190getContainerHeightD9Ej5fM();
    private static final float IconSize = AssistChipTokens.INSTANCE.m4199getIconSizeD9Ej5fM();

    private AssistChipDefaults() {
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m2479getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2480getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ChipColors assistChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1961061417, "C(assistChipColors)1013@48649L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1961061417, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1013)");
        }
        ChipColors defaultAssistChipColors$material3 = getDefaultAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultAssistChipColors$material3;
    }

    /* JADX INFO: renamed from: assistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m2475assistChipColorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -391745725, "C(assistChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,leadingIconContentColor:c#ui.graphics.Color,trailingIconContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconContentColor:c#ui.graphics.Color,disabledTrailingIconContentColor:c#ui.graphics.Color)1039@50070L11:Chip.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        long jM6004getUnspecified0d7_KjU7 = (i2 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j7;
        long jM6004getUnspecified0d7_KjU8 = (i2 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-391745725, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1039)");
        }
        ChipColors chipColorsM2563copyFD3wquc = getDefaultAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2563copyFD3wquc(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, jM6004getUnspecified0d7_KjU7, jM6004getUnspecified0d7_KjU8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM2563copyFD3wquc;
    }

    public final ChipColors getDefaultAssistChipColors$material3(ColorScheme colorScheme) {
        ChipColors defaultAssistChipColorsCached = colorScheme.getDefaultAssistChipColorsCached();
        if (defaultAssistChipColorsCached != null) {
            return defaultAssistChipColorsCached;
        }
        ChipColors chipColors = new ChipColors(Color.INSTANCE.m6003getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getIconColor()), ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getIconColor()), Color.INSTANCE.m6003getTransparent0d7_KjU(), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledLabelTextColor()), AssistChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultAssistChipColorsCached$material3(chipColors);
        return chipColors;
    }

    /* JADX INFO: renamed from: assistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m2476assistChipElevationaqJV_2Y(float f2, float f3, float f4, float f5, float f6, float f7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 245366099, "C(assistChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = AssistChipTokens.INSTANCE.m4197getFlatContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        float f9 = (i2 & 2) != 0 ? f8 : f3;
        float f10 = (i2 & 4) != 0 ? f8 : f4;
        float f11 = (i2 & 8) != 0 ? f8 : f5;
        float fM4191getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? AssistChipTokens.INSTANCE.m4191getDraggedContainerElevationD9Ej5fM() : f6;
        float f12 = (i2 & 32) != 0 ? f8 : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(245366099, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:1092)");
        }
        ChipElevation chipElevation = new ChipElevation(f8, f9, f10, f11, fM4191getDraggedContainerElevationD9Ej5fM, f12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipElevation;
    }

    /* JADX INFO: renamed from: assistChipBorder-h1eT-Ww, reason: not valid java name */
    public final BorderStroke m2474assistChipBorderh1eTWw(boolean z, long j, long j2, float f2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1458649561, "C(assistChipBorder)N(enabled,borderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp)1112@53758L5,1114@53856L5:Chip.kt#uh7d8r");
        long value = (i2 & 2) != 0 ? ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : j;
        long jM5967copywmQWz5c$default = (i2 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), AssistChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        float fM4198getFlatOutlineWidthD9Ej5fM = (i2 & 8) != 0 ? AssistChipTokens.INSTANCE.m4198getFlatOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1458649561, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1118)");
        }
        if (!z) {
            value = jM5967copywmQWz5c$default;
        }
        BorderStroke borderStrokeM348BorderStrokecXLIe8U = BorderStrokeKt.m348BorderStrokecXLIe8U(fM4198getFlatOutlineWidthD9Ej5fM, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM348BorderStrokecXLIe8U;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the assistChipBorder function that returns BorderStroke instead", replaceWith = @ReplaceWith(expression = "assistChipBorder(enabled, borderColor, disabledBorderColor, borderWidth)", imports = {}))
    /* JADX INFO: renamed from: assistChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m2473assistChipBorderd_3_b6Q(long j, long j2, float f2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 382372847, "C(assistChipBorder)N(borderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp)1139@54932L5,1141@55030L5:Chip.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : j;
        long jM5967copywmQWz5c$default = (i2 & 2) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), AssistChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        float fM4198getFlatOutlineWidthD9Ej5fM = (i2 & 4) != 0 ? AssistChipTokens.INSTANCE.m4198getFlatOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(382372847, i, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1146)");
        }
        ChipBorder chipBorder = new ChipBorder(value, jM5967copywmQWz5c$default, fM4198getFlatOutlineWidthD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipBorder;
    }

    public final ChipColors elevatedAssistChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 655175583, "C(elevatedAssistChipColors)1157@55586L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(655175583, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1157)");
        }
        ChipColors defaultElevatedAssistChipColors$material3 = getDefaultElevatedAssistChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedAssistChipColors$material3;
    }

    /* JADX INFO: renamed from: elevatedAssistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m2477elevatedAssistChipColorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -535762675, "C(elevatedAssistChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,leadingIconContentColor:c#ui.graphics.Color,trailingIconContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconContentColor:c#ui.graphics.Color,disabledTrailingIconContentColor:c#ui.graphics.Color)1183@57027L11:Chip.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        long jM6004getUnspecified0d7_KjU7 = (i2 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j7;
        long jM6004getUnspecified0d7_KjU8 = (i2 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-535762675, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1183)");
        }
        ChipColors chipColorsM2563copyFD3wquc = SuggestionChipDefaults.INSTANCE.getDefaultElevatedSuggestionChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2563copyFD3wquc(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, jM6004getUnspecified0d7_KjU7, jM6004getUnspecified0d7_KjU8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM2563copyFD3wquc;
    }

    public final ChipColors getDefaultElevatedAssistChipColors$material3(ColorScheme colorScheme) {
        ChipColors defaultElevatedAssistChipColorsCached = colorScheme.getDefaultElevatedAssistChipColorsCached();
        if (defaultElevatedAssistChipColorsCached != null) {
            return defaultElevatedAssistChipColorsCached;
        }
        ChipColors chipColors = new ChipColors(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getElevatedContainerColor()), ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getIconColor()), ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getIconColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor()), AssistChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledLabelTextColor()), AssistChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, AssistChipTokens.INSTANCE.getDisabledIconColor()), AssistChipTokens.INSTANCE.getDisabledIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultElevatedAssistChipColorsCached$material3(chipColors);
        return chipColors;
    }

    /* JADX INFO: renamed from: elevatedAssistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m2478elevatedAssistChipElevationaqJV_2Y(float f2, float f3, float f4, float f5, float f6, float f7, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1457698077, "C(elevatedAssistChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f2 = AssistChipTokens.INSTANCE.m4192getElevatedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 2) != 0) {
            f3 = AssistChipTokens.INSTANCE.m4196getElevatedPressedContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 4) != 0) {
            f4 = AssistChipTokens.INSTANCE.m4194getElevatedFocusContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        if ((i2 & 8) != 0) {
            f5 = AssistChipTokens.INSTANCE.m4195getElevatedHoverContainerElevationD9Ej5fM();
        }
        float f11 = f5;
        float fM4191getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? AssistChipTokens.INSTANCE.m4191getDraggedContainerElevationD9Ej5fM() : f6;
        float fM4193getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? AssistChipTokens.INSTANCE.m4193getElevatedDisabledContainerElevationD9Ej5fM() : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1457698077, i, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:1238)");
        }
        ChipElevation chipElevation = new ChipElevation(f8, f9, f10, f11, fM4191getDraggedContainerElevationD9Ej5fM, fM4193getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1988153916, "C(<get-shape>)1249@60742L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1988153916, i, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:1249)");
        }
        Shape value = ShapesKt.getValue(AssistChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }
}
