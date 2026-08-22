package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0081\u0001\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00132\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0015H\u0003¢\u0006\u0002\u0010%\u001a5\u0010&\u001a\u00020'*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100\u001aM\u00101\u001a\u00020'*\u00020(2\u0006\u00102\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u00103\u001a\u00020#H\u0002¢\u0006\u0004\b4\u00105\"\u000e\u00106\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010;\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>\"\u0010\u0010@\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0016\u0010A\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bB\u0010>\"\u0016\u0010C\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bD\u0010>\"\u0016\u0010E\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bF\u0010>\"\u0010\u0010G\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010H\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010I\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020L0KX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010N¨\u0006O²\u0006\n\u0010P\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", StreamManagement.Enabled.ELEMENT, "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationRailVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getNavigationRailVerticalPadding", "()F", "F", "NavigationRailHeaderPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailItemHeight", "getNavigationRailItemHeight", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPaddingWithLabel", "IndicatorVerticalPaddingNoLabel", "LocalNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationRailOverride;", "getLocalNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel;
    private static final float IndicatorVerticalPaddingWithLabel;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailVerticalPadding;
    private static final float NavigationRailHeaderPadding = Dp.m8830constructorimpl(8);
    private static final float NavigationRailItemWidth = NavigationRailCollapsedTokens.INSTANCE.m4626getNarrowContainerWidthD9Ej5fM();
    private static final float NavigationRailItemHeight = NavigationRailVerticalItemTokens.INSTANCE.m4639getActiveIndicatorWidthD9Ej5fM();
    private static final ProvidableCompositionLocal<NavigationRailOverride> LocalNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NavigationRailKt.LocalNavigationRailOverride$lambda$23();
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem$lambda$11(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, boolean z3, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationRailItem(z, function0, function2, modifier, z2, function22, z3, navigationRailItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItemLayout$lambda$18(Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NavigationRailItemLayout(function2, function22, function23, function24, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRail_qi6gXK8$lambda$1(Modifier modifier, long j, long j2, Function3 function3, WindowInsets windowInsets, Function3 function32, int i, int i2, Composer composer, int i3) {
        m3230NavigationRailqi6gXK8(modifier, j, j2, function3, windowInsets, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd  */
    /* JADX INFO: renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3230NavigationRailqi6gXK8(androidx.compose.ui.Modifier r24, long r25, long r27, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.foundation.layout.WindowInsets r30, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.m3230NavigationRailqi6gXK8(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavigationRailItem(final boolean r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, boolean r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, androidx.compose.material3.NavigationRailItemColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 1225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.NavigationRailItem(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationRailItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationRailItem$lambda$10$lambda$7$lambda$6(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationRailItem$lambda$10$lambda$9$lambda$8(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final void NavigationRailItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final Function0<Float> function0, final Function0<Float> function02, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-759267492);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItemLayout)N(indicatorRipple,indicator,icon,label,alwaysShowLabel,alphaAnimationProgress,sizeAnimationProgress)576@25709L2050,558@25188L2571:NavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-759267492, i2, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:557)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 488409630, "CC(remember):NavigationRail.kt#9igjgp");
            int i3 = 57344 & i2;
            boolean z2 = ((3670016 & i2) == 1048576) | ((i2 & 7168) == 2048) | (i3 == 16384);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Measurable measurable;
                        Placeable placeableMo7445measureBRTryo0;
                        MeasureScope measureScope2 = measureScope;
                        float fCoerceAtLeast = RangesKt.coerceAtLeast(function02.invoke().floatValue(), 0.0f);
                        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        List<? extends Measurable> list2 = list;
                        int size = list2.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Measurable measurable2 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                Placeable placeableMo7445measureBRTryo02 = measurable2.mo7445measureBRTryo0(jM8773copyZbe2FdA$default);
                                float f2 = 2;
                                int width = placeableMo7445measureBRTryo02.getWidth() + measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(NavigationRailKt.IndicatorHorizontalPadding * f2));
                                int iRoundToInt = MathKt.roundToInt(width * fCoerceAtLeast);
                                int height = placeableMo7445measureBRTryo02.getHeight() + measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl((function24 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel) * f2));
                                int size2 = list2.size();
                                for (int i5 = 0; i5 < size2; i5++) {
                                    Measurable measurable3 = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable placeableMo7445measureBRTryo03 = measurable3.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(width, height));
                                        int size3 = list2.size();
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i6);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "indicator")) {
                                                break;
                                            }
                                            i6++;
                                        }
                                        Measurable measurable4 = measurable;
                                        Placeable placeableMo7445measureBRTryo04 = measurable4 != null ? measurable4.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(iRoundToInt, height)) : null;
                                        if (function24 != null) {
                                            int size4 = list2.size();
                                            for (int i7 = 0; i7 < size4; i7++) {
                                                Measurable measurable5 = list.get(i7);
                                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                                    placeableMo7445measureBRTryo0 = measurable5.mo7445measureBRTryo0(jM8773copyZbe2FdA$default);
                                                }
                                            }
                                            ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                            throw new KotlinNothingValueException();
                                        }
                                        placeableMo7445measureBRTryo0 = null;
                                        if (function24 == null) {
                                            return NavigationRailKt.m3233placeIconX9ElhV4(measureScope, placeableMo7445measureBRTryo02, placeableMo7445measureBRTryo03, placeableMo7445measureBRTryo04, j);
                                        }
                                        Intrinsics.checkNotNull(placeableMo7445measureBRTryo0);
                                        return NavigationRailKt.m3234placeLabelAndIconzUg2_y0(measureScope, placeableMo7445measureBRTryo0, placeableMo7445measureBRTryo02, placeableMo7445measureBRTryo03, placeableMo7445measureBRTryo04, j, z, fCoerceAtLeast);
                                    }
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                            i4++;
                            measureScope2 = measureScope;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBadgeBounds);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 772983468, "C561@25271L17,562@25301L11,564@25326L50:NavigationRail.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
            function22.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1280363716, "C564@25368L6:NavigationRail.kt#uh7d8r");
            function23.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function24 != null) {
                composerStartRestartGroup.startReplaceGroup(773116085);
                ComposerKt.sourceInformation(composerStartRestartGroup, "568@25502L109,567@25427L250");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 579131360, "CC(remember):NavigationRail.kt#9igjgp");
                boolean z3 = (i3 == 16384) | ((i4 & 458752) == 131072);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationRailKt.NavigationRailItemLayout$lambda$17$lambda$15$lambda$14(z, function0, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId2, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composerStartRestartGroup);
                Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -995857944, "C572@25652L7:NavigationRail.kt#uh7d8r");
                function24.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(773387087);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItemLayout$lambda$18(function2, function22, function23, function24, z, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItemLayout$lambda$17$lambda$15$lambda$14(boolean z, Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(z ? 1.0f : ((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m3233placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int iM8800constrainWidthK40F9xA = ConstraintsKt.m8800constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        final int iM8799constrainHeightK40F9xA = ConstraintsKt.m8799constrainHeightK40F9xA(j, measureScope.mo482roundToPx0680j_4(NavigationRailItemHeight));
        final int width = (iM8800constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height = (iM8799constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (iM8800constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int height2 = (iM8799constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, iM8800constrainWidthK40F9xA, iM8799constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeIcon_X9ElhV4$lambda$20(placeable3, placeable, width, height, placeable2, width2, height2, iM8800constrainWidthK40F9xA, iM8799constrainHeightK40F9xA, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeIcon_X9ElhV4$lambda$20(Placeable placeable, Placeable placeable2, int i, int i2, Placeable placeable3, int i3, int i4, int i5, int i6, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i5 - placeable.getWidth()) / 2, (i6 - placeable.getHeight()) / 2, 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i3, i4, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m3234placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f2) {
        float height = placeable2.getHeight();
        float f3 = IndicatorVerticalPaddingWithLabel;
        float f4 = height + measureScope.mo488toPx0680j_4(f3);
        float f5 = NavigationRailItemVerticalPadding;
        float f6 = f4 + measureScope.mo488toPx0680j_4(f5) + placeable.getHeight();
        float f7 = 2;
        final float fCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m8784getMinHeightimpl(j) - f6) / f7, measureScope.mo488toPx0680j_4(f3));
        float f8 = f6 + (fCoerceAtLeast * f7);
        final float height2 = ((z ? fCoerceAtLeast : (f8 - placeable2.getHeight()) / f7) - fCoerceAtLeast) * (1 - f2);
        final float height3 = placeable2.getHeight() + fCoerceAtLeast + measureScope.mo488toPx0680j_4(f3) + measureScope.mo488toPx0680j_4(f5);
        final int iM8800constrainWidthK40F9xA = ConstraintsKt.m8800constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        final int width = (iM8800constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int width2 = (iM8800constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int width3 = (iM8800constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final float f9 = fCoerceAtLeast - measureScope.mo488toPx0680j_4(f3);
        return MeasureScope.layout$default(measureScope, iM8800constrainWidthK40F9xA, MathKt.roundToInt(f8), null, new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeLabelAndIcon_zUg2_y0$lambda$22(placeable4, z, f2, placeable, width, height3, height2, placeable2, width2, fCoerceAtLeast, placeable3, width3, f9, iM8800constrainWidthK40F9xA, measureScope, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeLabelAndIcon_zUg2_y0$lambda$22(Placeable placeable, boolean z, float f2, Placeable placeable2, int i, float f3, float f4, Placeable placeable3, int i2, float f5, Placeable placeable4, int i3, float f6, int i4, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i4 - placeable.getWidth()) / 2, MathKt.roundToInt((f5 - measureScope.mo488toPx0680j_4(IndicatorVerticalPaddingWithLabel)) + f4), 0.0f, 4, null);
        }
        if (z || f2 != 0.0f) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, MathKt.roundToInt(f3 + f4), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i2, MathKt.roundToInt(f5 + f4), 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i3, MathKt.roundToInt(f6 + f4), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    public static final ProvidableCompositionLocal<NavigationRailOverride> getLocalNavigationRailOverride() {
        return LocalNavigationRailOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavigationRailOverride LocalNavigationRailOverride$lambda$23() {
        return DefaultNavigationRailOverride.INSTANCE;
    }

    static {
        float f2 = 4;
        NavigationRailVerticalPadding = Dp.m8830constructorimpl(f2);
        NavigationRailItemVerticalPadding = Dp.m8830constructorimpl(f2);
        float f3 = 2;
        IndicatorHorizontalPadding = Dp.m8830constructorimpl(Dp.m8830constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m4639getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m4622getIconSizeD9Ej5fM()) / f3);
        IndicatorVerticalPaddingWithLabel = Dp.m8830constructorimpl(Dp.m8830constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m4638getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m4622getIconSizeD9Ej5fM()) / f3);
        IndicatorVerticalPaddingNoLabel = Dp.m8830constructorimpl(Dp.m8830constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m4639getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m4622getIconSizeD9Ej5fM()) / f3);
    }
}
