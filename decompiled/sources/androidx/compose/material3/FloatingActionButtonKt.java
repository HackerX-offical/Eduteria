package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.tokens.ExtendedFabLargeTokens;
import androidx.compose.material3.tokens.ExtendedFabMediumTokens;
import androidx.compose.material3.tokens.ExtendedFabSmallTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001an\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u0012\u001an\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001d\u0010\u0012\u001ay\u0010\u001e\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001f¢\u0006\u0002\b\u0010¢\u0006\u0002\b!H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u008b\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b(\u0010)\u001a»\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003¢\u0006\u0004\b-\u0010.\u001a\r\u0010G\u001a\u00020HH\u0003¢\u0006\u0002\u0010I\u001a\r\u0010J\u001a\u00020KH\u0003¢\u0006\u0002\u0010L\"\u0010\u0010/\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00103\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00104\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00107\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00108\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00109\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010:\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010;\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u0010<\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010=\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010>\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010?\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010@\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010A\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u0010B\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010C\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010D\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010E\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010F\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006M"}, d2 = {"FloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "FloatingActionButton-lF-WlFE", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "ExtendedFloatingActionButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "startPadding", "endPadding", "iconPadding", "ExtendedFloatingActionButton-qtIzBjc", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFFFFLandroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SmallExtendedFabMinimumWidth", "F", "SmallExtendedFabMinimumHeight", "SmallExtendedFabPaddingStart", "SmallExtendedFabPaddingEnd", "SmallExtendedFabIconPadding", "SmallExtendedFabTextStyle", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "MediumExtendedFabMinimumWidth", "MediumExtendedFabMinimumHeight", "MediumExtendedFabPaddingStart", "MediumExtendedFabPaddingEnd", "MediumExtendedFabIconPadding", "MediumExtendedFabTextStyle", "LargeExtendedFabMinimumWidth", "LargeExtendedFabMinimumHeight", "LargeExtendedFabPaddingStart", "LargeExtendedFabPaddingEnd", "LargeExtendedFabIconPadding", "LargeExtendedFabTextStyle", "ExtendedFabStartIconPadding", "ExtendedFabEndIconPadding", "ExtendedFabTextPadding", "ExtendedFabMinimumWidth", "extendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "extendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonKt {
    private static final float ExtendedFabEndIconPadding;
    private static final float ExtendedFabStartIconPadding;
    private static final float LargeExtendedFabIconPadding;
    private static final float MediumExtendedFabIconPadding;
    private static final float SmallExtendedFabMinimumWidth = ExtendedFabSmallTokens.INSTANCE.m4449getContainerHeightD9Ej5fM();
    private static final float SmallExtendedFabMinimumHeight = ExtendedFabSmallTokens.INSTANCE.m4449getContainerHeightD9Ej5fM();
    private static final float SmallExtendedFabPaddingStart = ExtendedFabSmallTokens.INSTANCE.m4452getLeadingSpaceD9Ej5fM();
    private static final float SmallExtendedFabPaddingEnd = ExtendedFabSmallTokens.INSTANCE.m4453getTrailingSpaceD9Ej5fM();
    private static final float SmallExtendedFabIconPadding = ExtendedFabSmallTokens.INSTANCE.m4450getIconLabelSpaceD9Ej5fM();
    private static final TypographyKeyTokens SmallExtendedFabTextStyle = TypographyKeyTokens.TitleMedium;
    private static final float MediumExtendedFabMinimumWidth = ExtendedFabMediumTokens.INSTANCE.m4434getContainerHeightD9Ej5fM();
    private static final float MediumExtendedFabMinimumHeight = ExtendedFabMediumTokens.INSTANCE.m4434getContainerHeightD9Ej5fM();
    private static final float MediumExtendedFabPaddingStart = ExtendedFabMediumTokens.INSTANCE.m4437getLeadingSpaceD9Ej5fM();
    private static final float MediumExtendedFabPaddingEnd = ExtendedFabMediumTokens.INSTANCE.m4438getTrailingSpaceD9Ej5fM();
    private static final TypographyKeyTokens MediumExtendedFabTextStyle = TypographyKeyTokens.TitleLarge;
    private static final float LargeExtendedFabMinimumWidth = ExtendedFabLargeTokens.INSTANCE.m4429getContainerHeightD9Ej5fM();
    private static final float LargeExtendedFabMinimumHeight = ExtendedFabLargeTokens.INSTANCE.m4429getContainerHeightD9Ej5fM();
    private static final float LargeExtendedFabPaddingStart = ExtendedFabLargeTokens.INSTANCE.m4432getLeadingSpaceD9Ej5fM();
    private static final float LargeExtendedFabPaddingEnd = ExtendedFabLargeTokens.INSTANCE.m4433getTrailingSpaceD9Ej5fM();
    private static final TypographyKeyTokens LargeExtendedFabTextStyle = TypographyKeyTokens.HeadlineSmall;
    private static final float ExtendedFabTextPadding = Dp.m8830constructorimpl(20);
    private static final float ExtendedFabMinimumWidth = Dp.m8830constructorimpl(80);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_ElI5_7k$lambda$8(Function2 function2, Function2 function22, Function0 function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m2936ExtendedFloatingActionButtonElI57k(function2, function22, function0, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_X_z6DiA$lambda$7(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2937ExtendedFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$9(Function2 function2, Function2 function22, Function0 function0, TextStyle textStyle, float f2, float f3, float f4, float f5, float f6, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        m2938ExtendedFloatingActionButtonqtIzBjc(function2, function22, function0, textStyle, f2, f3, f4, f5, f6, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_X_z6DiA$lambda$0(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2939FloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_lF_WlFE$lambda$4(Function0 function0, TextStyle textStyle, float f2, float f3, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        m2940FloatingActionButtonlFWlFE(function0, textStyle, f2, f3, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeFloatingActionButton_X_z6DiA$lambda$6(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2941LargeFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmallFloatingActionButton_X_z6DiA$lambda$5(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2942SmallFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0105  */
    /* JADX INFO: renamed from: FloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2939FloatingActionButtonXz6DiA(final kotlin.jvm.functions.Function0<kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, androidx.compose.material3.FloatingActionButtonElevation r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2939FloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX INFO: renamed from: FloatingActionButton-lF-WlFE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m2940FloatingActionButtonlFWlFE(final kotlin.jvm.functions.Function0<kotlin.Unit> r33, final androidx.compose.ui.text.TextStyle r34, final float r35, final float r36, androidx.compose.ui.Modifier r37, androidx.compose.ui.graphics.Shape r38, long r39, long r41, androidx.compose.material3.FloatingActionButtonElevation r43, androidx.compose.foundation.interaction.MutableInteractionSource r44, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 841
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2940FloatingActionButtonlFWlFE(kotlin.jvm.functions.Function0, androidx.compose.ui.text.TextStyle, float, float, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_lF_WlFE$lambda$3$lambda$2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8013getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0105  */
    /* JADX INFO: renamed from: SmallFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2942SmallFloatingActionButtonXz6DiA(final kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, androidx.compose.material3.FloatingActionButtonElevation r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2942SmallFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0105  */
    /* JADX INFO: renamed from: LargeFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2941LargeFloatingActionButtonXz6DiA(final kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, androidx.compose.material3.FloatingActionButtonElevation r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2941LargeFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2937ExtendedFloatingActionButtonXz6DiA(final kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, androidx.compose.material3.FloatingActionButtonElevation r35, androidx.compose.foundation.interaction.MutableInteractionSource r36, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2937ExtendedFloatingActionButtonXz6DiA(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2936ExtendedFloatingActionButtonElI57k(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, final kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.ui.graphics.Shape r33, long r34, long r36, androidx.compose.material3.FloatingActionButtonElevation r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2936ExtendedFloatingActionButtonElI57k(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0113  */
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-qtIzBjc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m2938ExtendedFloatingActionButtonqtIzBjc(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, final kotlin.jvm.functions.Function0<kotlin.Unit> r37, final androidx.compose.ui.text.TextStyle r38, final float r39, final float r40, final float r41, final float r42, final float r43, androidx.compose.ui.Modifier r44, boolean r45, androidx.compose.ui.graphics.Shape r46, long r47, long r49, androidx.compose.material3.FloatingActionButtonElevation r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 951
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.FloatingActionButtonKt.m2938ExtendedFloatingActionButtonqtIzBjc(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, androidx.compose.ui.text.TextStyle, float, float, float, float, float, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.material3.FloatingActionButtonElevation, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    static {
        float f2 = 12;
        MediumExtendedFabIconPadding = Dp.m8830constructorimpl(f2);
        float f3 = 16;
        LargeExtendedFabIconPadding = Dp.m8830constructorimpl(f3);
        ExtendedFabStartIconPadding = Dp.m8830constructorimpl(f3);
        ExtendedFabEndIconPadding = Dp.m8830constructorimpl(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExitTransition extendedFabCollapseAnimation(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -56172201, "C(extendedFabCollapseAnimation)797@35053L7,800@35162L7:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-56172201, i, -1, "androidx.compose.material3.extendedFabCollapseAnimation (FloatingActionButton.kt:795)");
        }
        ExitTransition exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6), 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), Alignment.INSTANCE.getStart(), false, null, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return exitTransitionPlus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterTransition extendedFabExpandAnimation(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -719787506, "C(extendedFabExpandAnimation)808@35431L7,811@35537L7:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-719787506, i, -1, "androidx.compose.material3.extendedFabExpandAnimation (FloatingActionButton.kt:806)");
        }
        EnterTransition enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), 0.0f, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6), Alignment.INSTANCE.getStart(), false, null, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterTransitionPlus;
    }
}
