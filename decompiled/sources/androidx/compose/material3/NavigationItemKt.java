package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: NavigationItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001aÕ\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0004\b*\u0010+\u001a\u008d\u0001\u0010,\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0003¢\u0006\u0004\b2\u00103\u001a³\u0001\u00104\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00072\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0003¢\u0006\u0004\b6\u00107\u001a3\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010B\u001aS\u0010C\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\bE\u0010F\u001aC\u0010G\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010I\u001a\u0091\u0001\u0010J\u001a\u000209*\u00020:2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002010\u00052\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u0010 \u001a\u00020K2\u0006\u0010?\u001a\u00020@2\u0006\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0002¢\u0006\u0004\bL\u0010M\u001a@\u0010N\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00032\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010P\u001a\u001b\u0010Q\u001a\b\u0012\u0004\u0012\u0002010R2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010S\u001a\u001d\u0010T\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020-2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010U\u001a-\u0010V\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0005H\u0003¢\u0006\u0004\bW\u0010X\"\u000e\u0010Y\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u00020ZX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010^\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010_¨\u0006`²\u0006\n\u0010a\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u0010a\u001a\u00020KX\u008a\u008e\u0002²\u0006\n\u00105\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"NavigationItem", "", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "indicatorShape", "Landroidx/compose/ui/graphics/Shape;", "indicatorWidth", "Landroidx/compose/ui/unit/Dp;", "indicatorHorizontalPadding", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "startIconToLabelHorizontalPadding", "topIconItemVerticalPadding", "colors", "Landroidx/compose/material3/NavigationItemColors;", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "label", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NavigationItem-8Df7sds", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;FFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "AnimatedNavigationItem", "topIconIndicatorWidth", "topIconLabelTextStyle", "startIconLabelTextStyle", "topIconIndicatorHorizontalPadding", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "noLabelIndicatorPadding", "itemHorizontalPadding", "AnimatedNavigationItem-DQd_Gtc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;FFFFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "NavigationItemLayout", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "indicatorAnimationProgress", "", "NavigationItemLayout-KmRX-Dg", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;FFFFFLandroidx/compose/runtime/Composer;II)V", "AnimatedNavigationItemLayout", "iconPositionProgress", "AnimatedNavigationItemLayout-he0WsC4", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;FFFFFFFFLandroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndTopIcon", "labelPlaceable", "placeLabelAndTopIcon-qoqLrGI", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JFFF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndStartIcon", "placeLabelAndStartIcon-nru01g4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "placeAnimatedLabelAndIcon", "", "placeAnimatedLabelAndIcon-2QYhCQ8", "(Landroidx/compose/ui/layout/MeasureScope;ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;IJFFFFFFF)Landroidx/compose/ui/layout/MeasureResult;", "StyledLabel", "content", "(ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/NavigationItemColors;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "animateIndicatorProgressAsState", "Landroidx/compose/runtime/State;", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "IndicatorRipple", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "Indicator", "Indicator-3J-VO9M", "(JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "IndicatorVerticalOffset", "F", "material3", "itemWidth", "textStyle"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationItemKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = Dp.m8830constructorimpl(12);
    private static final String LabelLayoutIdTag = "label";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedNavigationItemLayout_he0WsC4$lambda$35(InteractionSource interactionSource, long j, Shape shape, Function0 function0, Function2 function2, int i, Function0 function02, Function2 function22, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i2, int i3, Composer composer, int i4) {
        m3200AnimatedNavigationItemLayouthe0WsC4(interactionSource, j, shape, function0, function2, i, function02, function22, f2, f3, f4, f5, f6, f7, f8, f9, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedNavigationItem_DQd_Gtc$lambda$27(boolean z, Function0 function0, Function2 function2, Shape shape, float f2, TextStyle textStyle, TextStyle textStyle2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, NavigationItemColors navigationItemColors, Modifier modifier, boolean z2, Function2 function22, int i, MutableInteractionSource mutableInteractionSource, int i2, int i3, int i4, Composer composer, int i5) {
        m3199AnimatedNavigationItemDQd_Gtc(z, function0, function2, shape, f2, textStyle, textStyle2, f3, f4, f5, f6, f7, f8, f9, f10, navigationItemColors, modifier, z2, function22, i, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorRipple$lambda$42(InteractionSource interactionSource, Shape shape, int i, Composer composer, int i2) {
        IndicatorRipple(interactionSource, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Indicator_3J_VO9M$lambda$45(long j, Shape shape, Function0 function0, int i, Composer composer, int i2) {
        m3201Indicator3JVO9M(j, shape, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationItemLayout_KmRX_Dg$lambda$31(InteractionSource interactionSource, long j, Shape shape, Function2 function2, int i, Function2 function22, Function0 function0, float f2, float f3, float f4, float f5, float f6, int i2, int i3, Composer composer, int i4) {
        m3203NavigationItemLayoutKmRXDg(interactionSource, j, shape, function2, i, function22, function0, f2, f3, f4, f5, f6, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationItem_8Df7sds$lambda$10(boolean z, Function0 function0, Function2 function2, TextStyle textStyle, Shape shape, float f2, float f3, float f4, float f5, float f6, float f7, NavigationItemColors navigationItemColors, Modifier modifier, boolean z2, Function2 function22, int i, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m3202NavigationItem8Df7sds(z, function0, function2, textStyle, shape, f2, f3, f4, f5, f6, f7, navigationItemColors, modifier, z2, function22, i, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyledLabel$lambda$41(boolean z, TextStyle textStyle, NavigationItemColors navigationItemColors, boolean z2, Function2 function2, int i, Composer composer, int i2) {
        StyledLabel(z, textStyle, navigationItemColors, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: NavigationItem-8Df7sds, reason: not valid java name */
    public static final void m3202NavigationItem8Df7sds(boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Shape shape, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final NavigationItemColors navigationItemColors, final Modifier modifier, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        int i4;
        Shape shape2;
        int i5;
        Composer composer2;
        int i6;
        int i7;
        ComposableLambda composableLambda;
        MappedInteractionSource mappedInteractionSource;
        final boolean z3 = z;
        Composer composerStartRestartGroup = composer.startRestartGroup(2075155418);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationItem)N(selected,onClick,icon,labelTextStyle,indicatorShape,indicatorWidth:c#ui.unit.Dp,indicatorHorizontalPadding:c#ui.unit.Dp,indicatorVerticalPadding:c#ui.unit.Dp,indicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,topIconItemVerticalPadding:c#ui.unit.Dp,colors,modifier,enabled,label,iconPosition:c#material3.NavigationItemIconPosition,interactionSource)247@10748L94,257@11065L33,270@11488L7,271@11562L7,273@11612L24,259@11104L2381:NavigationItem.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            shape2 = shape;
            i4 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(f5) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            i4 |= composerStartRestartGroup.changed(f6) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(f7) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(navigationItemColors) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
        }
        int i8 = i5;
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (599187 & i8) == 599186) ? false : true, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2075155418, i4, i8, "androidx.compose.material3.NavigationItem (NavigationItem.kt:245)");
            }
            final long jM3182iconColorWaAFU9c = navigationItemColors.m3182iconColorWaAFU9c(z3, z2);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1119868672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledIcon$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    ComposerKt.sourceInformation(composer3, "C248@10758L78:NavigationItem.kt#uh7d8r");
                    if (!composer3.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1119868672, i9, -1, "androidx.compose.material3.NavigationItem.<anonymous> (NavigationItem.kt:248)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(jM3182iconColorWaAFU9c)), function2, composer3, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            if (function22 == null) {
                composerStartRestartGroup.startReplaceGroup(-803302356);
                composerStartRestartGroup.endReplaceGroup();
                i6 = i8;
                i7 = i4;
                composableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-803266737);
                ComposerKt.sourceInformation(composerStartRestartGroup, "254@10967L65");
                i6 = i8;
                i7 = i4;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1062206119, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledLabel$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i9) {
                        ComposerKt.sourceInformation(composer3, "C254@10969L61:NavigationItem.kt#uh7d8r");
                        if (!composer3.shouldExecute((i9 & 3) != 2, i9 & 1)) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1062206119, i9, -1, "androidx.compose.material3.NavigationItem.<anonymous> (NavigationItem.kt:254)");
                        }
                        NavigationItemKt.StyledLabel(z3, textStyle, navigationItemColors, z2, function22, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda2;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1359565019, "CC(remember):NavigationItem.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            z3 = z;
            Modifier modifierM1492selectableO2vRcR0 = SelectableKt.m1492selectableO2vRcR0(modifier, z3, mutableInteractionSource, null, z2, Role.m8006boximpl(Role.INSTANCE.m8020getTabo7Vup1c()), function0);
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM8844unboximpl = ((Dp) objConsume).m8844unboximpl();
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1205defaultMinSizeVpY3zN4 = SizeKt.m1205defaultMinSizeVpY3zN4(modifierM1492selectableO2vRcR0, fM8844unboximpl, ((Dp) objConsume2).m8844unboximpl());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1359582514, "CC(remember):NavigationItem.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationItemKt.NavigationItem_8Df7sds$lambda$4$lambda$3(mutableIntState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierM1205defaultMinSizeVpY3zN4, (Function1) objRememberedValue2);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 484584471, "C277@11772L41,304@13049L54,297@12698L781:NavigationItem.kt#uh7d8r");
            final State<Float> stateAnimateIndicatorProgressAsState = animateIndicatorProgressAsState(z3, composerStartRestartGroup, i7 & 14);
            if (NavigationItemIconPosition.m3187equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m3192getTopxw1Ddg())) {
                composerStartRestartGroup.startReplaceGroup(484755993);
                ComposerKt.sourceInformation(composerStartRestartGroup, "284@12247L7,292@12542L136");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long jM5715constructorimpl = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits((NavigationItem_8Df7sds$lambda$1(mutableIntState) - r2.mo482roundToPx0680j_4(f2)) / 2)) << 32) | (((long) Float.floatToRawIntBits(((Density) objConsume3).mo488toPx0680j_4(IndicatorVerticalOffset))) & 4294967295L));
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1092722808, "CC(remember):NavigationItem.kt#9igjgp");
                boolean zChanged = ((i6 & 3670016) == 1048576) | composerStartRestartGroup.changed(jM5715constructorimpl);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new MappedInteractionSource(mutableInteractionSource, jM5715constructorimpl, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mappedInteractionSource = (MappedInteractionSource) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(485471938);
                composerStartRestartGroup.endReplaceGroup();
                mappedInteractionSource = null;
            }
            MutableInteractionSource mutableInteractionSource2 = mappedInteractionSource != null ? mappedInteractionSource : mutableInteractionSource;
            long selectedIndicatorColor = navigationItemColors.getSelectedIndicatorColor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1092706666, "CC(remember):NavigationItem.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateAnimateIndicatorProgressAsState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationItemKt.NavigationItem_8Df7sds$lambda$9$lambda$8$lambda$7(stateAnimateIndicatorProgressAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i9 = i7 << 3;
            composer2 = composerStartRestartGroup;
            m3203NavigationItemLayoutKmRXDg(mutableInteractionSource2, selectedIndicatorColor, shape2, composableLambdaRememberComposableLambda, i, composableLambda, (Function0) objRememberedValue4, f3, f4, f5, f6, f7, composer2, ((i7 >> 6) & 896) | 3072 | ((i6 >> 3) & 57344) | (29360128 & i9) | (234881024 & i9) | (i9 & 1879048192), ((i7 >> 27) & 14) | ((i6 << 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.NavigationItem_8Df7sds$lambda$10(z3, function0, function2, textStyle, shape, f2, f3, f4, f5, f6, f7, navigationItemColors, modifier, z2, function22, i, mutableInteractionSource, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int NavigationItem_8Df7sds$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationItem_8Df7sds$lambda$4$lambda$3(MutableIntState mutableIntState, IntSize intSize) {
        mutableIntState.setIntValue((int) (intSize.m9005unboximpl() >> 32));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationItem_8Df7sds$lambda$9$lambda$8$lambda$7(State state) {
        return RangesKt.coerceAtLeast(((Number) state.getValue()).floatValue(), 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: AnimatedNavigationItem-DQd_Gtc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3199AnimatedNavigationItemDQd_Gtc(final boolean r33, final kotlin.jvm.functions.Function0<kotlin.Unit> r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final androidx.compose.ui.graphics.Shape r36, final float r37, final androidx.compose.ui.text.TextStyle r38, final androidx.compose.ui.text.TextStyle r39, final float r40, final float r41, final float r42, final float r43, final float r44, final float r45, final float r46, final float r47, final androidx.compose.material3.NavigationItemColors r48, final androidx.compose.ui.Modifier r49, final boolean r50, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, final int r52, final androidx.compose.foundation.interaction.MutableInteractionSource r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instruction units count: 1433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationItemKt.m3199AnimatedNavigationItemDQd_Gtc(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, float, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, float, float, float, float, float, float, float, float, androidx.compose.material3.NavigationItemColors, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final int AnimatedNavigationItem_DQd_Gtc$lambda$12(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedNavigationItem_DQd_Gtc$lambda$15$lambda$14(MutableIntState mutableIntState, IntSize intSize) {
        mutableIntState.setIntValue((int) (intSize.m9005unboximpl() >> 32));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$18$lambda$17(boolean z, TextStyle textStyle, TextStyle textStyle2, State state) {
        return (!z || AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(state) >= 0.5f) ? textStyle2 : textStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$23$lambda$22(State state) {
        return RangesKt.coerceAtLeast(((Number) state.getValue()).floatValue(), 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$25$lambda$24(State state) {
        return RangesKt.coerceAtLeast(AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(state), 0.0f);
    }

    /* JADX INFO: renamed from: NavigationItemLayout-KmRX-Dg, reason: not valid java name */
    private static final void m3203NavigationItemLayoutKmRXDg(final InteractionSource interactionSource, final long j, final Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, final int i, final Function2<? super Composer, ? super Integer, Unit> function22, final Function0<Float> function0, final float f2, final float f3, final float f4, final float f5, final float f6, Composer composer, final int i2, final int i3) {
        int i4;
        Function0<Float> function02;
        int i5;
        TopIconOrIconOnlyMeasurePolicy topIconOrIconOnlyMeasurePolicy;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1473868071);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationItemLayout)N(interactionSource,indicatorColor:c#ui.graphics.Color,indicatorShape,icon,iconPosition:c#material3.NavigationItemIconPosition,label,indicatorAnimationProgress,indicatorHorizontalPadding:c#ui.unit.Dp,indicatorVerticalPadding:c#ui.unit.Dp,indicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,topIconItemVerticalPadding:c#ui.unit.Dp)454@19104L1389:NavigationItem.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            function02 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        } else {
            function02 = function0;
        }
        if ((12582912 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(f3) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(f5) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(f6) ? 32 : 16;
        }
        int i6 = i5;
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i6 & 19) == 18) ? false : true, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1473868071, i4, i6, "androidx.compose.material3.NavigationItemLayout (NavigationItem.kt:453)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            if (function22 == null || NavigationItemIconPosition.m3187equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m3192getTopxw1Ddg())) {
                topIconOrIconOnlyMeasurePolicy = new TopIconOrIconOnlyMeasurePolicy(function22 != null, function0, f2, f3, f4, f6, null);
            } else {
                topIconOrIconOnlyMeasurePolicy = new StartIconMeasurePolicy(function02, f2, f3, f5, null);
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBadgeBounds);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m5077setimpl(composerM5069constructorimpl, topIconOrIconOnlyMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087603364, "C458@19231L50,461@19484L69,463@19567L50:NavigationItem.kt#uh7d8r");
            int i7 = i4 >> 3;
            IndicatorRipple(interactionSource, shape, composerStartRestartGroup, (i4 & 14) | (i7 & 112));
            int i8 = i4;
            m3201Indicator3JVO9M(j, shape, function0, composerStartRestartGroup, ((i4 >> 12) & 896) | (i7 & 126));
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 652632167, "C463@19609L6:NavigationItem.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(-2087200706);
                ComposerKt.sourceInformation(composerStartRestartGroup, "466@19668L52");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2123117109, "C466@19711L7:NavigationItem.kt#uh7d8r");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2087119982);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.NavigationItemLayout_KmRX_Dg$lambda$31(interactionSource, j, shape, function2, i, function22, function0, f2, f3, f4, f5, f6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: AnimatedNavigationItemLayout-he0WsC4, reason: not valid java name */
    private static final void m3200AnimatedNavigationItemLayouthe0WsC4(final InteractionSource interactionSource, final long j, final Shape shape, final Function0<Float> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final int i, final Function0<Float> function02, final Function2<? super Composer, ? super Integer, Unit> function22, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8, final float f9, Composer composer, final int i2, final int i3) {
        int i4;
        Function0<Float> function03;
        int i5;
        int i6;
        TopIconOrIconOnlyMeasurePolicy topIconOrIconOnlyMeasurePolicy;
        Composer composerStartRestartGroup = composer.startRestartGroup(94433406);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedNavigationItemLayout)N(interactionSource,indicatorColor:c#ui.graphics.Color,indicatorShape,indicatorAnimationProgress,icon,iconPosition:c#material3.NavigationItemIconPosition,iconPositionProgress,label,topIconIndicatorHorizontalPadding:c#ui.unit.Dp,topIconIndicatorVerticalPadding:c#ui.unit.Dp,topIconIndicatorToLabelVerticalPadding:c#ui.unit.Dp,startIconIndicatorHorizontalPadding:c#ui.unit.Dp,startIconIndicatorVerticalPadding:c#ui.unit.Dp,noLabelIndicatorPadding:c#ui.unit.Dp,startIconToLabelHorizontalPadding:c#ui.unit.Dp,itemHorizontalPadding:c#ui.unit.Dp)509@21184L2129:NavigationItem.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            function03 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function03) ? 2048 : 1024;
        } else {
            function03 = function0;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 = 196608;
            i4 |= composerStartRestartGroup.changed(i) ? 131072 : 65536;
        } else {
            i5 = 196608;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            i4 |= composerStartRestartGroup.changed(f3) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i6 = i3 | (composerStartRestartGroup.changed(f4) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(f5) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= composerStartRestartGroup.changed(f6) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(f7) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(f8) ? 16384 : 8192;
        }
        if ((i3 & i5) == 0) {
            i6 |= composerStartRestartGroup.changed(f9) ? 131072 : 65536;
        }
        int i7 = i6;
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (74899 & i7) == 74898) ? false : true, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(94433406, i4, i7, "androidx.compose.material3.AnimatedNavigationItemLayout (NavigationItem.kt:508)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            if (function22 != null) {
                topIconOrIconOnlyMeasurePolicy = new AnimatedMeasurePolicy(i, function02, function03, f2, f3, f4, f5, f6, f8, f9, null);
            } else {
                float f10 = 0;
                topIconOrIconOnlyMeasurePolicy = new TopIconOrIconOnlyMeasurePolicy(false, function0, f7, f7, Dp.m8830constructorimpl(f10), Dp.m8830constructorimpl(f10), null);
            }
            Object obj = topIconOrIconOnlyMeasurePolicy;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBadgeBounds);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m5077setimpl(composerM5069constructorimpl, obj, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -988347483, "C513@21311L50,516@21564L69,518@21647L50:NavigationItem.kt#uh7d8r");
            int i8 = i4 >> 3;
            IndicatorRipple(interactionSource, shape, composerStartRestartGroup, (i4 & 14) | (i8 & 112));
            int i9 = i4;
            m3201Indicator3JVO9M(j, shape, function0, composerStartRestartGroup, i8 & 1022);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1416456196, "C518@21689L6:NavigationItem.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i9 >> 12) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function22 != null) {
                composerStartRestartGroup.startReplaceGroup(-987944825);
                ComposerKt.sourceInformation(composerStartRestartGroup, "521@21748L52");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 157288374, "C521@21791L7:NavigationItem.kt#uh7d8r");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i9 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-987864101);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return NavigationItemKt.AnimatedNavigationItemLayout_he0WsC4$lambda$35(interactionSource, j, shape, function0, function2, i, function02, function22, f2, f3, f4, f5, f6, f7, f8, f9, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m3209placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        int iM8800constrainWidthK40F9xA = ConstraintsKt.m8800constrainWidthK40F9xA(j, placeable2.getWidth());
        int iM8799constrainHeightK40F9xA = ConstraintsKt.m8799constrainHeightK40F9xA(j, placeable2.getHeight());
        final int width = (iM8800constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final int height = (iM8799constrainHeightK40F9xA - placeable3.getHeight()) / 2;
        final int width2 = (iM8800constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height2 = (iM8799constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width3 = (iM8800constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int height3 = (iM8799constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, iM8800constrainWidthK40F9xA, iM8799constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationItemKt.placeIcon_X9ElhV4$lambda$36(placeable3, width, height, placeable, width2, height2, placeable2, width3, height3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeIcon_X9ElhV4$lambda$36(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i5, i6, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndTopIcon-qoqLrGI, reason: not valid java name */
    public static final MeasureResult m3211placeLabelAndTopIconqoqLrGI(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, float f2, float f3, float f4) {
        int iM8800constrainWidthK40F9xA = ConstraintsKt.m8800constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), placeable3.getWidth()));
        int iM8799constrainHeightK40F9xA = ConstraintsKt.m8799constrainHeightK40F9xA(j, MathKt.roundToInt(placeable3.getHeight() + measureScope.mo488toPx0680j_4(f2) + placeable.getHeight() + (measureScope.mo488toPx0680j_4(f4) * 2)));
        final int i = measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f4 + f3));
        final int width = (iM8800constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int width2 = (iM8800constrainWidthK40F9xA - placeable4.getWidth()) / 2;
        final int i2 = i - measureScope.mo482roundToPx0680j_4(f3);
        final int width3 = (iM8800constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height = i + placeable2.getHeight() + measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f2 + f3));
        final int width4 = (iM8800constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        return MeasureScope.layout$default(measureScope, iM8800constrainWidthK40F9xA, iM8799constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationItemKt.placeLabelAndTopIcon_qoqLrGI$lambda$37(placeable4, width2, i2, placeable, width3, height, placeable2, width, i, placeable3, width4, i2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeLabelAndTopIcon_qoqLrGI$lambda$37(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6, Placeable placeable4, int i7, int i8, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i5, i6, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i7, i8, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndStartIcon-nru01g4, reason: not valid java name */
    public static final MeasureResult m3210placeLabelAndStartIconnru01g4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, float f2) {
        int iM8800constrainWidthK40F9xA = ConstraintsKt.m8800constrainWidthK40F9xA(j, placeable3.getWidth());
        int iM8799constrainHeightK40F9xA = ConstraintsKt.m8799constrainHeightK40F9xA(j, placeable3.getHeight());
        final int width = (iM8800constrainWidthK40F9xA - placeable4.getWidth()) / 2;
        final int height = (iM8799constrainHeightK40F9xA - placeable4.getHeight()) / 2;
        final int height2 = (iM8799constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        final int height3 = (iM8799constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (iM8800constrainWidthK40F9xA - ((placeable2.getWidth() + measureScope.mo482roundToPx0680j_4(f2)) + placeable.getWidth())) / 2;
        final int width3 = placeable2.getWidth() + width2 + measureScope.mo482roundToPx0680j_4(f2);
        final int width4 = (iM8800constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final int height4 = (iM8799constrainHeightK40F9xA - placeable3.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, iM8800constrainWidthK40F9xA, iM8799constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationItemKt.placeLabelAndStartIcon_nru01g4$lambda$38(placeable4, width, height, placeable, width3, height3, placeable2, width2, height2, placeable3, width4, height4, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeLabelAndStartIcon_nru01g4$lambda$38(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6, Placeable placeable4, int i7, int i8, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i5, i6, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i7, i8, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeAnimatedLabelAndIcon-2QYhCQ8, reason: not valid java name */
    public static final MeasureResult m3208placeAnimatedLabelAndIcon2QYhCQ8(MeasureScope measureScope, int i, Function0<Float> function0, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, int i2, long j, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        int iLerp;
        final float fFloatValue = function0.invoke().floatValue();
        boolean zM3187equalsimpl0 = NavigationItemIconPosition.m3187equalsimpl0(i, NavigationItemIconPosition.INSTANCE.m3192getTopxw1Ddg());
        float f9 = 2;
        float f10 = f8 * f9;
        float fM8800constrainWidthK40F9xA = ConstraintsKt.m8800constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), i2 + measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f10)))) + ((ConstraintsKt.m8800constrainWidthK40F9xA(j, placeable3.getWidth() + measureScope.mo482roundToPx0680j_4(f8)) - r8) * fFloatValue);
        int iLerp2 = MathHelpersKt.lerp(ConstraintsKt.m8799constrainHeightK40F9xA(j, MathKt.roundToInt(placeable3.getHeight() + measureScope.mo488toPx0680j_4(f2) + placeable.getHeight())), ConstraintsKt.m8799constrainHeightK40F9xA(j, placeable3.getHeight()), fFloatValue);
        final int i3 = measureScope.mo482roundToPx0680j_4(f8);
        int iRoundToInt = MathKt.roundToInt((fM8800constrainWidthK40F9xA - placeable4.getWidth()) / f9);
        int iRoundToInt2 = MathKt.roundToInt(((i3 + fM8800constrainWidthK40F9xA) - placeable4.getWidth()) / f9);
        if (fFloatValue == 0.0f || fFloatValue == 1.0f) {
            iLerp = MathHelpersKt.lerp(iRoundToInt, iRoundToInt2, fFloatValue);
        } else {
            iLerp = measureScope.mo482roundToPx0680j_4(f8);
        }
        int i4 = measureScope.mo482roundToPx0680j_4(f4) + i3;
        int i5 = measureScope.mo482roundToPx0680j_4(f5) + i3;
        int i6 = measureScope.mo482roundToPx0680j_4(f3);
        int i7 = measureScope.mo482roundToPx0680j_4(f6);
        final int iLerp3 = MathHelpersKt.lerp(i4, i5, fFloatValue);
        final int iLerp4 = MathHelpersKt.lerp(i6, i7, fFloatValue);
        int width = ((placeable2.getWidth() + measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(Dp.m8830constructorimpl(f4 * f9) + Dp.m8830constructorimpl(f10)))) - placeable.getWidth()) / 2;
        int height = placeable2.getHeight() + iLerp4 + measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f2 + f2));
        float width2 = ((placeable2.getWidth() + iLerp3) + measureScope.mo482roundToPx0680j_4(f7)) - ((!zM3187equalsimpl0 || fFloatValue <= 0.0f) ? measureScope.mo482roundToPx0680j_4(f8) * (1.0f - fFloatValue) : 0.0f);
        int height2 = (iLerp2 - placeable.getHeight()) / 2;
        final Object objValueOf = fFloatValue < 0.5f ? Integer.valueOf(width) : Float.valueOf(width2 * fFloatValue);
        final int i8 = fFloatValue < 0.5f ? height : height2;
        final int i9 = iLerp;
        return MeasureScope.layout$default(measureScope, MathKt.roundToInt(fM8800constrainWidthK40F9xA), iLerp2, null, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationItemKt.placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40(placeable4, i9, placeable2, iLerp3, iLerp4, placeable, objValueOf, i8, placeable3, i3, fFloatValue, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40(Placeable placeable, int i, Placeable placeable2, int i2, int i3, Placeable placeable3, Object obj, int i4, Placeable placeable4, int i5, final float f2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable, i, 0, 0.0f, (Function1) null, 12, (Object) null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable2, i2, i3, 0.0f, (Function1) null, 12, (Object) null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable3, ((Number) obj).intValue(), i4, 0.0f, new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return NavigationItemKt.placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40$lambda$39(f2, (GraphicsLayerScope) obj2);
            }
        }, 4, (Object) null);
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable4, i5, 0, 0.0f, (Function1) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeAnimatedLabelAndIcon_2QYhCQ8$lambda$40$lambda$39(float f2, GraphicsLayerScope graphicsLayerScope) {
        float f3 = f2 - 0.5f;
        graphicsLayerScope.setAlpha(4 * f3 * f3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StyledLabel(final boolean z, TextStyle textStyle, final NavigationItemColors navigationItemColors, final boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        TextStyle textStyle2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2136267443);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StyledLabel)N(selected,labelTextStyle,colors,enabled,content)1085@45893L132:NavigationItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(navigationItemColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            textStyle2 = textStyle;
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2136267443, i2, -1, "androidx.compose.material3.StyledLabel (NavigationItem.kt:1083)");
            }
            textStyle2 = textStyle;
            ProvideContentColorTextStyleKt.m4064ProvideContentColorTextStyle3JVO9M(navigationItemColors.m3183textColorWaAFU9c(z, z2), textStyle2, function2, composerStartRestartGroup, (i2 & 112) | ((i2 >> 6) & 896));
            function22 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TextStyle textStyle3 = textStyle2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.StyledLabel$lambda$41(z, textStyle3, navigationItemColors, z2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final State<Float> animateIndicatorProgressAsState(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1105658511, "C(animateIndicatorProgressAsState)N(selected)1097@46316L7,1094@46110L220:NavigationItem.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1105658511, i, -1, "androidx.compose.material3.animateIndicatorProgressAsState (NavigationItem.kt:1094)");
        }
        State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), 0.0f, null, null, composer, 0, 28);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateFloatAsState;
    }

    private static final void IndicatorRipple(final InteractionSource interactionSource, final Shape shape, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-629069867);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IndicatorRipple)N(interactionSource,indicatorShape)1102@46439L151:NavigationItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-629069867, i2, -1, "androidx.compose.material3.IndicatorRipple (NavigationItem.kt:1101)");
            }
            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, IndicatorRippleLayoutIdTag), shape), interactionSource, RippleKt.m3315rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.IndicatorRipple$lambda$42(interactionSource, shape, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: Indicator-3J-VO9M, reason: not valid java name */
    private static final void m3201Indicator3JVO9M(final long j, final Shape shape, final Function0<Float> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-273382589);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)N(indicatorColor:c#ui.graphics.Color,indicatorShape,indicatorAnimationProgress)1117@46816L40,1115@46736L198:NavigationItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273382589, i2, -1, "androidx.compose.material3.Indicator (NavigationItem.kt:1114)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, IndicatorLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -727655829, "CC(remember):NavigationItem.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationItemKt.Indicator_3J_VO9M$lambda$44$lambda$43(function0, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxKt.Box(BackgroundKt.m312backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId, (Function1) objRememberedValue), j, shape), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationItemKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationItemKt.Indicator_3J_VO9M$lambda$45(j, shape, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Indicator_3J_VO9M$lambda$44$lambda$43(Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    private static final float AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$16(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle AnimatedNavigationItem_DQd_Gtc$lambda$26$lambda$19(State<TextStyle> state) {
        return state.getValue();
    }
}
