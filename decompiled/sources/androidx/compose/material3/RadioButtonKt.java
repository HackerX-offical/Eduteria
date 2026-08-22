package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0013"}, d2 = {"RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "RadioButtonPadding", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonDotSize", "RadioStrokeWidth", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonKt {
    private static final float RadioButtonDotSize = Dp.m8830constructorimpl(12);
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$2(boolean z, Function0 function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        RadioButton(z, function0, modifier, z2, radioButtonColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RadioButton(final boolean r24, final kotlin.jvm.functions.Function0<kotlin.Unit> r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.RadioButtonColors r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.RadioButtonKt.RadioButton(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.RadioButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RadioButton$lambda$1$lambda$0(State state, State state2, DrawScope drawScope) {
        float f2 = drawScope.mo488toPx0680j_4(RadioStrokeWidth);
        float f3 = 2;
        float f4 = f2 / f3;
        DrawScope.m6530drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m5978unboximpl(), drawScope.mo488toPx0680j_4(Dp.m8830constructorimpl(RadioButtonTokens.INSTANCE.m4764getIconSizeD9Ej5fM() / f3)) - f4, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (Dp.m8829compareTo0680j_4(((Dp) state2.getValue()).m8844unboximpl(), Dp.m8830constructorimpl(0)) > 0) {
            DrawScope.m6530drawCircleVaOC9Bg$default(drawScope, ((Color) state.getValue()).m5978unboximpl(), drawScope.mo488toPx0680j_4(((Dp) state2.getValue()).m8844unboximpl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
        }
        return Unit.INSTANCE;
    }

    static {
        float f2 = 2;
        RadioButtonPadding = Dp.m8830constructorimpl(f2);
        RadioStrokeWidth = Dp.m8830constructorimpl(f2);
    }
}
