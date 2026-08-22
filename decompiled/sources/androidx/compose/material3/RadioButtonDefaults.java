package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/RadioButtonDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/RadioButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RadioButtonColors;", "defaultRadioButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultRadioButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RadioButtonColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    public final RadioButtonColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1191566130, "C(colors)135@5709L11:RadioButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1191566130, i, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:135)");
        }
        RadioButtonColors defaultRadioButtonColors$material3 = getDefaultRadioButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultRadioButtonColors$material3;
    }

    /* JADX INFO: renamed from: colors-ro_MJ88, reason: not valid java name */
    public final RadioButtonColors m3303colorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -351083046, "C(colors)N(selectedColor:c#ui.graphics.Color,unselectedColor:c#ui.graphics.Color,disabledSelectedColor:c#ui.graphics.Color,disabledUnselectedColor:c#ui.graphics.Color)155@6681L11:RadioButton.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-351083046, i, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:155)");
        }
        RadioButtonColors radioButtonColorsM3298copyjRlVdoo = getDefaultRadioButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3298copyjRlVdoo(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return radioButtonColorsM3298copyjRlVdoo;
    }

    public final RadioButtonColors getDefaultRadioButtonColors$material3(ColorScheme colorScheme) {
        RadioButtonColors defaultRadioButtonColorsCached = colorScheme.getDefaultRadioButtonColorsCached();
        if (defaultRadioButtonColorsCached != null) {
            return defaultRadioButtonColorsCached;
        }
        RadioButtonColors radioButtonColors = new RadioButtonColors(ColorSchemeKt.fromToken(colorScheme, RadioButtonTokens.INSTANCE.getSelectedIconColor()), ColorSchemeKt.fromToken(colorScheme, RadioButtonTokens.INSTANCE.getUnselectedIconColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, RadioButtonTokens.INSTANCE.getDisabledSelectedIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, RadioButtonTokens.INSTANCE.getDisabledUnselectedIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultRadioButtonColorsCached$material3(radioButtonColors);
        return radioButtonColors;
    }
}
