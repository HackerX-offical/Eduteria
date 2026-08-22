package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.NavigationBarHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: ShortNavigationBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001aT\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0081\u0001\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\"\u0016\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+\"\u0016\u0010-\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+\"\u0016\u0010/\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b0\u0010+\"\u0016\u00101\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b2\u0010+\"\u0016\u00103\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b4\u0010+\"\u0016\u00105\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b6\u0010+\"\u0016\u00107\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b8\u0010+¨\u00069"}, d2 = {"ShortNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/ShortNavigationBarArrangement;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ShortNavigationBar-kQ6Tpik", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ShortNavigationBarItem", "selected", "", "onClick", "icon", "label", StreamManagement.Enabled.ELEMENT, "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ShortNavigationBarItem-6ZDA4I0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "LocalShortNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ShortNavigationBarOverride;", "getLocalShortNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "calculateCenteredContentHorizontalPadding", "", "itemsCount", "barWidth", "TopIconItemVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTopIconItemVerticalPadding", "()F", "F", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "StartIconToLabelPadding", "getStartIconToLabelPadding", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShortNavigationBarKt {
    private static final float StartIconIndicatorVerticalPadding;
    private static final float TopIconIndicatorHorizontalPadding;
    private static final float TopIconIndicatorVerticalPadding;
    private static final ProvidableCompositionLocal<ShortNavigationBarOverride> LocalShortNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ShortNavigationBarKt.LocalShortNavigationBarOverride$lambda$4();
        }
    }, 1, null);
    private static final float TopIconItemVerticalPadding = NavigationBarVerticalItemTokens.INSTANCE.m4608getContainerBetweenSpaceD9Ej5fM();
    private static final float TopIconIndicatorToLabelPadding = Dp.m8830constructorimpl(4);
    private static final float StartIconIndicatorHorizontalPadding = NavigationBarHorizontalItemTokens.INSTANCE.m4598getActiveIndicatorLeadingSpaceD9Ej5fM();
    private static final float StartIconToLabelPadding = NavigationBarTokens.INSTANCE.m4603getItemActiveIndicatorIconLabelSpaceD9Ej5fM();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShortNavigationBarItem_6ZDA4I0$lambda$3(boolean z, Function0 function0, Function2 function2, Function2 function22, Modifier modifier, boolean z2, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m3433ShortNavigationBarItem6ZDA4I0(z, function0, function2, function22, modifier, z2, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShortNavigationBar_kQ6Tpik$lambda$1(Modifier modifier, long j, long j2, WindowInsets windowInsets, int i, Function2 function2, int i2, int i3, Composer composer, int i4) {
        m3432ShortNavigationBarkQ6Tpik(modifier, j, j2, windowInsets, i, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX INFO: renamed from: ShortNavigationBar-kQ6Tpik, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3432ShortNavigationBarkQ6Tpik(androidx.compose.ui.Modifier r23, long r24, long r26, androidx.compose.foundation.layout.WindowInsets r28, int r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ShortNavigationBarKt.m3432ShortNavigationBarkQ6Tpik(androidx.compose.ui.Modifier, long, long, androidx.compose.foundation.layout.WindowInsets, int, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f8  */
    /* JADX INFO: renamed from: ShortNavigationBarItem-6ZDA4I0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3433ShortNavigationBarItem6ZDA4I0(final boolean r32, final kotlin.jvm.functions.Function0<kotlin.Unit> r33, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, int r38, androidx.compose.material3.NavigationItemColors r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ShortNavigationBarKt.m3433ShortNavigationBarItem6ZDA4I0(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, int, androidx.compose.material3.NavigationItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ProvidableCompositionLocal<ShortNavigationBarOverride> getLocalShortNavigationBarOverride() {
        return LocalShortNavigationBarOverride;
    }

    static {
        float f2 = 2;
        TopIconIndicatorVerticalPadding = Dp.m8830constructorimpl(Dp.m8830constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m4606getActiveIndicatorHeightD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m4609getIconSizeD9Ej5fM()) / f2);
        TopIconIndicatorHorizontalPadding = Dp.m8830constructorimpl(Dp.m8830constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m4607getActiveIndicatorWidthD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m4609getIconSizeD9Ej5fM()) / f2);
        StartIconIndicatorVerticalPadding = Dp.m8830constructorimpl(Dp.m8830constructorimpl(NavigationBarHorizontalItemTokens.INSTANCE.m4597getActiveIndicatorHeightD9Ej5fM() - NavigationBarHorizontalItemTokens.INSTANCE.m4600getIconSizeD9Ej5fM()) / f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortNavigationBarOverride LocalShortNavigationBarOverride$lambda$4() {
        return DefaultShortNavigationBarOverride.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateCenteredContentHorizontalPadding(int i, int i2) {
        if (i > 6) {
            return 0;
        }
        return MathKt.roundToInt((((100 - ((i + 3) * 10)) / 2.0f) / 100) * i2);
    }

    public static final float getTopIconItemVerticalPadding() {
        return TopIconItemVerticalPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return TopIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return StartIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return TopIconIndicatorToLabelPadding;
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return StartIconToLabelPadding;
    }
}
