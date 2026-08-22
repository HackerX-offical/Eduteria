package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0011\u001aO\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010%\u001a;\u0010&\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-\"\u000e\u0010.\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00103\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u00065"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "checkmarkStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "outlineStroke", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", Constants.KEY_RADIUS, "", "stroke", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/material3/CheckDrawingCache;)V", "SnapAnimationDelay", "", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CheckboxKt {
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = Dp.m8830constructorimpl(20);
    private static final float RadiusSize;
    private static final int SnapAnimationDelay = 100;

    /* JADX INFO: compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$3(boolean z, Function1 function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$6(boolean z, Function1 function1, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, stroke, stroke2, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$15(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Stroke stroke, Stroke stroke2, int i, Composer composer, int i2) {
        CheckboxImpl(z, toggleableState, modifier, checkboxColors, stroke, stroke2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TriStateCheckbox$lambda$8(ToggleableState toggleableState, Function0 function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TriStateCheckbox$lambda$9(ToggleableState toggleableState, Function0 function0, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, stroke, stroke2, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Checkbox(final boolean r27, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, androidx.compose.material3.CheckboxColors r31, androidx.compose.foundation.interaction.MutableInteractionSource r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$2$lambda$1(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Checkbox(final boolean r22, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r23, final androidx.compose.ui.graphics.drawscope.Stroke r24, final androidx.compose.ui.graphics.drawscope.Stroke r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.CheckboxColors r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.drawscope.Stroke, androidx.compose.ui.graphics.drawscope.Stroke, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$5$lambda$4(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TriStateCheckbox(final androidx.compose.ui.state.ToggleableState r24, final kotlin.jvm.functions.Function0<kotlin.Unit> r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.CheckboxColors r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TriStateCheckbox(final androidx.compose.ui.state.ToggleableState r21, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, final androidx.compose.ui.graphics.drawscope.Stroke r23, final androidx.compose.ui.graphics.drawscope.Stroke r24, androidx.compose.ui.Modifier r25, boolean r26, androidx.compose.material3.CheckboxColors r27, androidx.compose.foundation.interaction.MutableInteractionSource r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.graphics.drawscope.Stroke, androidx.compose.ui.graphics.drawscope.Stroke, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void CheckboxImpl(final boolean r25, final androidx.compose.ui.state.ToggleableState r26, final androidx.compose.ui.Modifier r27, final androidx.compose.material3.CheckboxColors r28, final androidx.compose.ui.graphics.drawscope.Stroke r29, final androidx.compose.ui.graphics.drawscope.Stroke r30, androidx.compose.runtime.Composer r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 819
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material3.CheckboxColors, androidx.compose.ui.graphics.drawscope.Stroke, androidx.compose.ui.graphics.drawscope.Stroke, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$14$lambda$13(State state, State state2, Stroke stroke, State state3, State state4, State state5, Stroke stroke2, CheckDrawingCache checkDrawingCache, DrawScope drawScope) {
        m2559drawBox1wkBAMs(drawScope, ((Color) state.getValue()).m5978unboximpl(), ((Color) state2.getValue()).m5978unboximpl(), drawScope.mo488toPx0680j_4(RadiusSize), stroke);
        m2560drawCheck3IgeMak(drawScope, ((Color) state3.getValue()).m5978unboximpl(), ((Number) state4.getValue()).floatValue(), ((Number) state5.getValue()).floatValue(), stroke2, checkDrawingCache);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    private static final void m2559drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f2, Stroke stroke) {
        float width = stroke.getWidth() / 2.0f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32));
        if (!Color.m5969equalsimpl0(j, j2)) {
            long jM5715constructorimpl = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(stroke.getWidth())) << 32) | (((long) Float.floatToRawIntBits(stroke.getWidth())) & 4294967295L));
            float f3 = 2;
            long jM5783constructorimpl = Size.m5783constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - (stroke.getWidth() * f3))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat - (stroke.getWidth() * f3))) & 4294967295L));
            float fMax = Math.max(0.0f, f2 - stroke.getWidth());
            DrawScope.m6545drawRoundRectuAw5IA$default(drawScope, j, jM5715constructorimpl, jM5783constructorimpl, CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 224, null);
            long jM5715constructorimpl2 = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(width)) << 32) | (((long) Float.floatToRawIntBits(width)) & 4294967295L));
            float width2 = fIntBitsToFloat - stroke.getWidth();
            float f4 = f2 - width;
            DrawScope.m6545drawRoundRectuAw5IA$default(drawScope, j2, jM5715constructorimpl2, Size.m5783constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - stroke.getWidth())) & 4294967295L) | (Float.floatToRawIntBits(width2) << 32)), CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), stroke, 0.0f, null, 0, 224, null);
            return;
        }
        DrawScope.m6545drawRoundRectuAw5IA$default(drawScope, j, 0L, Size.m5783constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 226, null);
    }

    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    private static final void m2560drawCheck3IgeMak(DrawScope drawScope, long j, float f2, float f3, Stroke stroke, CheckDrawingCache checkDrawingCache) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32));
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f3);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f3);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f3);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f3);
        checkDrawingCache.getCheckPath().rewind();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fIntBitsToFloat, fLerp3 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fIntBitsToFloat, fLerp2 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fIntBitsToFloat, fIntBitsToFloat * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().rewind();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f2, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m6539drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    static {
        float f2 = 2;
        CheckboxDefaultPadding = Dp.m8830constructorimpl(f2);
        RadiusSize = Dp.m8830constructorimpl(f2);
    }
}
