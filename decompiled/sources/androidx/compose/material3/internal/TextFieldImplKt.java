package androidx.compose.material3.internal;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\u001a\u0099\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\b¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010 \u001a2\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b0\u00101\u001a*\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b2\u00103\u001a\u001c\u00104\u001a\u000205*\u0002052\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0000\u001a\u001c\u00108\u001a\u000205*\u0002052\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0000\u001a\u001a\u0010=\u001a\u000205*\u0002052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0007H\u0000\u001aÔ\u0001\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020,2\u0006\u0010!\u001a\u00020\u00162\u0099\u0001\u0010/\u001a\u0094\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020,0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(L\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020,0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(M\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(N\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00010F¢\u0006\u0002\b\bH\u0083\b¢\u0006\u0004\bP\u0010Q\u001aE\u0010R\u001a\b\u0012\u0004\u0012\u00020S0G2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010T\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020?H\u0001¢\u0006\u0004\bW\u0010X\u001a\r\u0010b\u001a\u00020?H\u0001¢\u0006\u0002\u0010c\u001a\r\u0010d\u001a\u00020?H\u0001¢\u0006\u0002\u0010c\"\u0018\u0010!\u001a\u00020\u0016*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0018\u0010$\u001a\u00020%*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0018\u0010(\u001a\u00020%*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'\"\u000e\u0010Y\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010e\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010g\"\u0016\u0010i\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bj\u0010g\"\u0016\u0010k\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bl\u0010g\"\u0016\u0010m\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bn\u0010g\"\u0016\u0010o\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bp\u0010g\"\u0016\u0010q\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\br\u0010g\"\u0016\u0010s\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bt\u0010g\"\u0016\u0010u\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bv\u0010g¨\u0006w²\u0006\n\u0010x\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010y\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"CommonDecorationBox", "", "type", "Landroidx/compose/material3/internal/TextFieldType;", "visualText", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Lkotlin/ExtensionFunctionType;", "placeholder", "leadingIcon", "trailingIcon", "prefix", DynamicLink.Builder.KEY_SUFFIX, "supportingText", "singleLine", "", StreamManagement.Enabled.ELEMENT, "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "showExpandedLabel", "getShowExpandedLabel", "(Landroidx/compose/material3/TextFieldLabelPosition;)Z", "minimizedAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "getMinimizedAlignment", "(Landroidx/compose/material3/TextFieldLabelPosition;)Landroidx/compose/ui/Alignment$Horizontal;", "expandedAlignment", "getExpandedAlignment", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "defaultErrorSemantics", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "", "textFieldBackground", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "shape", "Landroidx/compose/ui/graphics/Shape;", "textFieldLabelMinHeight", "minHeight", "Landroidx/compose/ui/unit/Dp;", "TextFieldTransitionScope", "inputState", "Landroidx/compose/material3/internal/InputPhase;", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelColor", "Lkotlin/Function5;", "Landroidx/compose/runtime/State;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "TextFieldTransitionScope-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "animateBorderStrokeAsState", "Landroidx/compose/foundation/BorderStroke;", "focused", "focusedBorderThickness", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TextFieldId", "PlaceholderId", "LabelId", "LeadingId", "TrailingId", "PrefixId", "SuffixId", "SupportingId", "ContainerId", "textFieldHorizontalIconPadding", "(Landroidx/compose/runtime/Composer;I)F", "minimizedLabelHalfHeight", "TextFieldPadding", "getTextFieldPadding", "()F", "F", "AboveLabelHorizontalPadding", "getAboveLabelHorizontalPadding", "AboveLabelBottomPadding", "getAboveLabelBottomPadding", "SupportingTopPadding", "getSupportingTopPadding", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "MinTextLineHeight", "getMinTextLineHeight", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "material3", "showPlaceholder", "showPrefixSuffix"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldImplKt {
    private static final float AboveLabelBottomPadding;
    private static final float AboveLabelHorizontalPadding;
    public static final String ContainerId = "Container";
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding;
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding;
    public static final String TrailingId = "Trailing";
    private static final float PrefixSuffixTextPadding = Dp.m8830constructorimpl(2);
    private static final float MinTextLineHeight = Dp.m8830constructorimpl(24);

    /* JADX INFO: compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            try {
                iArr[TextFieldType.Filled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldType.Outlined.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$19(TextFieldType textFieldType, CharSequence charSequence, Function2 function2, TextFieldLabelPosition textFieldLabelPosition, Function3 function3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2 function28, int i, int i2, Composer composer, int i3) {
        CommonDecorationBox(textFieldType, charSequence, function2, textFieldLabelPosition, function3, function22, function23, function24, function25, function26, function27, z, z2, z3, interactionSource, paddingValues, textFieldColors, function28, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration_3J_VO9M$lambda$20(long j, TextStyle textStyle, Function2 function2, int i, Composer composer, int i2) {
        m4148Decoration3JVO9M(j, textStyle, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration_Iv8Zu3U$lambda$21(long j, Function2 function2, int i, Composer composer, int i2) {
        m4149DecorationIv8Zu3U(j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:196:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x06c6  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x07d3  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0853  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0887  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08c0  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0911  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x094a  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0a61  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0add  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CommonDecorationBox(final androidx.compose.material3.internal.TextFieldType r44, final java.lang.CharSequence r45, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, final androidx.compose.material3.TextFieldLabelPosition r47, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.TextFieldLabelScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, final boolean r55, final boolean r56, final boolean r57, final androidx.compose.foundation.interaction.InteractionSource r58, final androidx.compose.foundation.layout.PaddingValues r59, final androidx.compose.material3.TextFieldColors r60, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, androidx.compose.runtime.Composer r62, final int r63, final int r64) {
        /*
            Method dump skipped, instruction units count: 2850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.CommonDecorationBox(androidx.compose.material3.internal.TextFieldType, java.lang.CharSequence, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldLabelPosition, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CommonDecorationBox$lambda$18$lambda$7$lambda$6(State state) {
        return ((Number) state.getValue()).floatValue() > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CommonDecorationBox$lambda$18$lambda$10$lambda$9(State state) {
        return ((Number) state.getValue()).floatValue() > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonDecorationBox$lambda$18$lambda$17$lambda$16(TextFieldLabelPosition textFieldLabelPosition, State state, MutableState mutableState, Size size) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return Unit.INSTANCE;
        }
        float fFloatValue = ((Number) state.getValue()).floatValue();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size.m5797unboximpl() >> 32)) * fFloatValue;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size.m5797unboximpl() & 4294967295L)) * fFloatValue;
        if (Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m5797unboximpl() >> 32)) != fIntBitsToFloat || Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m5797unboximpl() & 4294967295L)) != fIntBitsToFloat2) {
            mutableState.setValue(Size.m5780boximpl(Size.m5783constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L))));
        }
        return Unit.INSTANCE;
    }

    private static final boolean getShowExpandedLabel(TextFieldLabelPosition textFieldLabelPosition) {
        return (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) && !((TextFieldLabelPosition.Attached) textFieldLabelPosition).getAlwaysMinimize();
    }

    public static final Alignment.Horizontal getMinimizedAlignment(TextFieldLabelPosition textFieldLabelPosition) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return ((TextFieldLabelPosition.Above) textFieldLabelPosition).getAlignment();
        }
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) {
            return ((TextFieldLabelPosition.Attached) textFieldLabelPosition).getMinimizedAlignment();
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition);
    }

    public static final Alignment.Horizontal getExpandedAlignment(TextFieldLabelPosition textFieldLabelPosition) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return ((TextFieldLabelPosition.Above) textFieldLabelPosition).getAlignment();
        }
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) {
            return ((TextFieldLabelPosition.Attached) textFieldLabelPosition).getExpandedAlignment();
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Decoration-3J-VO9M, reason: not valid java name */
    public static final void m4148Decoration3JVO9M(long j, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final TextStyle textStyle2;
        final long j2;
        Composer composerStartRestartGroup = composer.startRestartGroup(396611577);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,textStyle,content)325@13794L62:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(396611577, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:325)");
            }
            ProvideContentColorTextStyleKt.m4064ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, composerStartRestartGroup, i2 & 1022);
            j2 = j;
            textStyle2 = textStyle;
            function22 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function22 = function2;
            textStyle2 = textStyle;
            j2 = j;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_3J_VO9M$lambda$20(j2, textStyle2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Decoration-Iv8Zu3U, reason: not valid java name */
    public static final void m4149DecorationIv8Zu3U(final long j, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(590397809);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,content)330@14001L84:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(590397809, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:330)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(j)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_Iv8Zu3U$lambda$21(j, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.defaultErrorSemantics$lambda$22(str, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit defaultErrorSemantics$lambda$22(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    public static final Modifier textFieldBackground(Modifier modifier, final ColorProducer colorProducer, final Shape shape) {
        return DrawModifierKt.drawWithCache(modifier, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldBackground$lambda$24(shape, colorProducer, (CacheDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult textFieldBackground$lambda$24(Shape shape, final ColorProducer colorProducer, CacheDrawScope cacheDrawScope) {
        final Outline outlineMo382createOutlinePq9zytI = shape.mo382createOutlinePq9zytI(cacheDrawScope.m5503getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        return cacheDrawScope.onDrawBehind(new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldBackground$lambda$24$lambda$23(outlineMo382createOutlinePq9zytI, colorProducer, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textFieldBackground$lambda$24$lambda$23(Outline outline, ColorProducer colorProducer, DrawScope drawScope) {
        OutlineKt.m6243drawOutlinewDX37Ww$default(drawScope, outline, colorProducer.mo2834invoke0d7_KjU(), 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    public static final Modifier textFieldLabelMinHeight(Modifier modifier, final Function0<Dp> function0) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.textFieldLabelMinHeight$lambda$26(function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult textFieldLabelMinHeight$lambda$26(Function0 function0, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        float fM8844unboximpl = ((Dp) function0.invoke()).m8844unboximpl();
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(constraints.getValue(), 0, 0, ConstraintsKt.m8799constrainHeightK40F9xA(constraints.getValue(), !Dp.m8835equalsimpl0(fM8844unboximpl, Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM()) ? measureScope.mo482roundToPx0680j_4(fM8844unboximpl) : 0), 0, 11, null));
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldLabelMinHeight$lambda$26$lambda$25(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textFieldLabelMinHeight$lambda$26$lambda$25(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0240  */
    /* JADX INFO: renamed from: TextFieldTransitionScope-Jy8F4Js, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m4150TextFieldTransitionScopeJy8F4Js(androidx.compose.material3.internal.InputPhase r25, long r26, long r28, long r30, boolean r32, kotlin.jvm.functions.Function7<? super androidx.compose.runtime.State<java.lang.Float>, ? super androidx.compose.runtime.State<androidx.compose.ui.graphics.Color>, ? super androidx.compose.runtime.State<androidx.compose.ui.graphics.Color>, ? super androidx.compose.runtime.State<java.lang.Float>, ? super androidx.compose.runtime.State<java.lang.Float>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35) {
        /*
            Method dump skipped, instruction units count: 1156
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.TextFieldImplKt.m4150TextFieldTransitionScopeJy8F4Js(androidx.compose.material3.internal.InputPhase, long, long, long, boolean, kotlin.jvm.functions.Function7, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m4153animateBorderStrokeAsStateNuRrP5Q(boolean z, boolean z2, boolean z3, TextFieldColors textFieldColors, float f2, float f3, Composer composer, int i) {
        State<Color> stateRememberUpdatedState;
        State<Dp> stateRememberUpdatedState2;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 2047013045, "C(animateBorderStrokeAsState)N(enabled,isError,focused,colors,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)475@19543L14,483@19812L11,492@20135L73:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2047013045, i, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:472)");
        }
        long jM3652indicatorColorXeAY9LY$material3 = textFieldColors.m3652indicatorColorXeAY9LY$material3(z, z2, z3);
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer2, 6);
        if (z) {
            composer2.startReplaceGroup(-1674507999);
            ComposerKt.sourceInformation(composer2, "478@19618L52");
            stateRememberUpdatedState = SingleValueAnimationKt.m162animateColorAsStateeuL9pac(jM3652indicatorColorXeAY9LY$material3, finiteAnimationSpecValue, null, null, composer, 0, 12);
            composer2 = composer;
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-1674427244);
            ComposerKt.sourceInformation(composer2, "480@19700L33");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m5958boximpl(jM3652indicatorColorXeAY9LY$material3), composer2, 0);
            composer2.endReplaceGroup();
        }
        FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer2, 6);
        if (z) {
            composer2.startReplaceGroup(-1674245832);
            ComposerKt.sourceInformation(composer2, "487@19979L57");
            stateRememberUpdatedState2 = AnimateAsStateKt.m189animateDpAsStateAjpBEmI(z3 ? f2 : f3, finiteAnimationSpecValue2, null, null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-1674063769);
            ComposerKt.sourceInformation(composer2, "489@20066L46");
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Dp.m8828boximpl(f3), composer2, (i >> 15) & 14);
            composer2.endReplaceGroup();
        }
        State<BorderStroke> stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m348BorderStrokecXLIe8U(stateRememberUpdatedState2.getValue().m8844unboximpl(), stateRememberUpdatedState.getValue().m5978unboximpl()), composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return stateRememberUpdatedState3;
    }

    public static final float textFieldHorizontalIconPadding(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1986450462, "C(textFieldHorizontalIconPadding)521@21199L7:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1986450462, i, -1, "androidx.compose.material3.internal.textFieldHorizontalIconPadding (TextFieldImpl.kt:520)");
        }
        ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMinimumInteractiveComponentSize);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM8844unboximpl = ((Dp) objConsume).m8844unboximpl();
        if (Float.isNaN(fM8844unboximpl)) {
            fM8844unboximpl = Dp.m8830constructorimpl(0);
        }
        float fM8830constructorimpl = Dp.m8830constructorimpl(RangesKt.coerceAtLeast(Dp.m8830constructorimpl(Dp.m8830constructorimpl(fM8844unboximpl - SmallIconButtonTokens.INSTANCE.m4800getIconSizeD9Ej5fM()) / 2), Dp.m8830constructorimpl(0)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM8830constructorimpl;
    }

    public static final float minimizedLabelHalfHeight(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1251545215, "C(minimizedLabelHalfHeight)528@21499L10,531@21709L7:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1251545215, i, -1, "androidx.compose.material3.internal.minimizedLabelHalfHeight (TextFieldImpl.kt:527)");
        }
        long jM8312getLineHeightXSAIIZE = MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall().m8312getLineHeightXSAIIZE();
        long jM4909getBodySmallLineHeightXSAIIZE = TypeScaleTokens.INSTANCE.m4909getBodySmallLineHeightXSAIIZE();
        if (!TextUnit.m9027isSpimpl(jM8312getLineHeightXSAIIZE)) {
            jM8312getLineHeightXSAIIZE = jM4909getBodySmallLineHeightXSAIIZE;
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM8830constructorimpl = Dp.m8830constructorimpl(((Density) objConsume).mo483toDpGaN1DYA(jM8312getLineHeightXSAIIZE) / 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM8830constructorimpl;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getAboveLabelHorizontalPadding() {
        return AboveLabelHorizontalPadding;
    }

    public static final float getAboveLabelBottomPadding() {
        return AboveLabelBottomPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    private static final boolean CommonDecorationBox$lambda$18$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean CommonDecorationBox$lambda$18$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static {
        float f2 = 16;
        TextFieldPadding = Dp.m8830constructorimpl(f2);
        float f3 = 4;
        AboveLabelHorizontalPadding = Dp.m8830constructorimpl(f3);
        AboveLabelBottomPadding = Dp.m8830constructorimpl(f3);
        SupportingTopPadding = Dp.m8830constructorimpl(f3);
        MinFocusedLabelLineHeight = Dp.m8830constructorimpl(f2);
        MinSupportingTextLineHeight = Dp.m8830constructorimpl(f2);
    }
}
