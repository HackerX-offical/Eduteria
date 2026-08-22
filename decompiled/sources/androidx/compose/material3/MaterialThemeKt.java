package androidx.compose.material3;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aH\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000e\u001aP\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0017\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/MotionScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialExpressiveTheme", "LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "TextSelectionBackgroundOpacity", "", "_localMotionScheme", "get_localMotionScheme$annotations", "()V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialThemeKt {
    public static final float TextSelectionBackgroundOpacity = 0.4f;
    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(MaterialThemeKt.LocalUsingExpressiveTheme$lambda$3());
        }
    });
    private static final ProvidableCompositionLocal<MotionScheme> _localMotionScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MaterialThemeKt._localMotionScheme$lambda$5();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LocalUsingExpressiveTheme$lambda$3() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialExpressiveTheme$lambda$2(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialExpressiveTheme(colorScheme, motionScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$0(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colorScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaterialTheme$lambda$1(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, int i, int i2, Composer composer, int i3) {
        MaterialTheme(colorScheme, motionScheme, shapes, typography, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void get_localMotionScheme$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MaterialTheme(androidx.compose.material3.ColorScheme r9, androidx.compose.material3.Shapes r10, androidx.compose.material3.Typography r11, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r12, androidx.compose.runtime.Composer r13, final int r14, final int r15) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MaterialThemeKt.MaterialTheme(androidx.compose.material3.ColorScheme, androidx.compose.material3.Shapes, androidx.compose.material3.Typography, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MaterialTheme(androidx.compose.material3.ColorScheme r22, androidx.compose.material3.MotionScheme r23, androidx.compose.material3.Shapes r24, androidx.compose.material3.Typography r25, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MaterialThemeKt.MaterialTheme(androidx.compose.material3.ColorScheme, androidx.compose.material3.MotionScheme, androidx.compose.material3.Shapes, androidx.compose.material3.Typography, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MaterialExpressiveTheme(androidx.compose.material3.ColorScheme r19, androidx.compose.material3.MotionScheme r20, androidx.compose.material3.Shapes r21, androidx.compose.material3.Typography r22, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MaterialThemeKt.MaterialExpressiveTheme(androidx.compose.material3.ColorScheme, androidx.compose.material3.MotionScheme, androidx.compose.material3.Shapes, androidx.compose.material3.Typography, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return LocalUsingExpressiveTheme;
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1866455512, "C(rememberTextSelectionColors)N(colorScheme)219@9547L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:217)");
        }
        long primary = colorScheme.getPrimary();
        ComposerKt.sourceInformationMarkerStart(composer, -1632576770, "CC(remember):MaterialTheme.kt#9igjgp");
        boolean zChanged = composer.changed(primary);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(primary, Color.m5967copywmQWz5c$default(primary, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textSelectionColors2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MotionScheme _localMotionScheme$lambda$5() {
        return MotionScheme.INSTANCE.standard$material3();
    }
}
