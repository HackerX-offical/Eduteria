package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020!0)2\b\b\u0002\u0010*\u001a\u00020%H\u0007¢\u0006\u0002\u0010+J-\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u000202H\u0007¢\u0006\u0004\b3\u00104Jõ\u0001\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020/2\b\b\u0002\u0010F\u001a\u00020/2\b\b\u0002\u0010G\u001a\u00020/2\b\b\u0002\u0010H\u001a\u00020/2\b\b\u0002\u0010I\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020/2\b\b\u0002\u0010K\u001a\u00020/2\b\b\u0002\u0010L\u001a\u00020/H\u0007¢\u0006\u0004\bM\u0010NJ\u008e\u0002\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\b\b\u0002\u0010[\u001a\u00020%2\b\b\u0002\u0010\\\u001a\u00020]2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010g2\b\b\u0002\u0010h\u001a\u00020i2\b\b\u0002\u0010j\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010mJ¢\u0002\u0010O\u001a\u00020P2\u0006\u0010n\u001a\u00020R2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0006\u0010o\u001a\u00020%2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\b\b\u0002\u0010[\u001a\u00020%2\b\b\u0002\u0010\\\u001a\u00020]2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010g2\b\b\u0002\u0010h\u001a\u00020i2\b\b\u0002\u0010j\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010qJÈ\u0001\u0010O\u001a\u00020P2\u0006\u0010r\u001a\u00020W2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0006\u0010o\u001a\u00020%2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010tJ#\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/H\u0007¢\u0006\u0004\bu\u0010vJ\u009b\u0001\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/H\u0007¢\u0006\u0004\bw\u0010xJ\u0087\u0001\u00101\u001a\u0002022\b\b\u0002\u0010y\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010z\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/H\u0007¢\u0006\u0004\b{\u0010|R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u0007R\u0013\u0010\u000e\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006}²\u0006\n\u0010~\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "<init>", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "ShadowElevation", "getShadowElevation-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "inputFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getInputFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "dockedShape", "getDockedShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "fullScreenWindowInsets", "getFullScreenWindowInsets", "enterAlwaysSearchBarScrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "reverseLayout", "(FFLkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarScrollBehavior;", "colors", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "focusedTextColor", "unfocusedTextColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "inputFieldColors-JVEmHcM", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "InputField", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "searchBarState", "Landroidx/compose/material3/SearchBarState;", "onSearch", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "placeholder", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "prefix", DynamicLink.Builder.KEY_SUFFIX, "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "state", "expanded", "onExpandedChange", "(Landroidx/compose/foundation/text/input/TextFieldState;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "query", "onQueryChange", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "colors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "textColor", "placeholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3", "focused"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchBarDefaults {
    public static final int $stable = 0;
    private static final float Elevation;
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float InputFieldHeight;
    private static final float ShadowElevation;
    private static final float TonalElevation;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$20(SearchBarDefaults searchBarDefaults, TextFieldState textFieldState, SearchBarState searchBarState, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, InputTransformation inputTransformation, OutputTransformation outputTransformation, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        searchBarDefaults.InputField(textFieldState, searchBarState, function1, modifier, z, z2, textStyle, function2, function22, function23, function24, function25, inputTransformation, outputTransformation, scrollState, shape, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$33(SearchBarDefaults searchBarDefaults, TextFieldState textFieldState, Function1 function1, boolean z, Function1 function12, Modifier modifier, boolean z2, boolean z3, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, InputTransformation inputTransformation, OutputTransformation outputTransformation, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        searchBarDefaults.InputField(textFieldState, function1, z, function12, modifier, z2, z3, textStyle, function2, function22, function23, function24, function25, inputTransformation, outputTransformation, scrollState, shape, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$44(SearchBarDefaults searchBarDefaults, String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        searchBarDefaults.InputField(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysSearchBarScrollBehavior$lambda$1$lambda$0() {
        return true;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(expression = "TonalElevation", imports = {}))
    /* JADX INFO: renamed from: getElevation-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3329getElevationD9Ej5fM$annotations() {
    }

    private SearchBarDefaults() {
    }

    static {
        float fM4423getLevel0D9Ej5fM = ElevationTokens.INSTANCE.m4423getLevel0D9Ej5fM();
        TonalElevation = fM4423getLevel0D9Ej5fM;
        ShadowElevation = ElevationTokens.INSTANCE.m4423getLevel0D9Ej5fM();
        Elevation = fM4423getLevel0D9Ej5fM;
        InputFieldHeight = SearchBarTokens.INSTANCE.m4769getContainerHeightD9Ej5fM();
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m3335getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* JADX INFO: renamed from: getShadowElevation-D9Ej5fM, reason: not valid java name */
    public final float m3334getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m3332getElevationD9Ej5fM() {
        return Elevation;
    }

    /* JADX INFO: renamed from: getInputFieldHeight-D9Ej5fM, reason: not valid java name */
    public final float m3333getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1770571533, "C(<get-inputFieldShape>)1039@46188L5:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1770571533, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.kt:1039)");
        }
        Shape value = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFullScreenShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2009956471, "C(<get-fullScreenShape>)1043@46362L5:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2009956471, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.kt:1043)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getDockedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1447354121, "C(<get-dockedShape>)1047@46512L5:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1447354121, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.kt:1047)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1795925906, "C(<get-windowInsets>)1053@46670L29:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1795925906, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.kt:1053)");
        }
        WindowInsets windowInsetsM1250onlybOOhFvg = WindowInsetsKt.m1250onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1266plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1276getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1280getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1250onlybOOhFvg;
    }

    public final WindowInsets getFullScreenWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1745169224, "C(<get-fullScreenWindowInsets>)1059@46961L11:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1745169224, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenWindowInsets> (SearchBar.kt:1059)");
        }
        WindowInsets safeDrawing = WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return safeDrawing;
    }

    public final SearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior(float f2, float f3, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, boolean z, Composer composer, int i, int i2) {
        final Function0<Boolean> function02;
        ComposerKt.sourceInformationMarkerStart(composer, 1222500790, "C(enterAlwaysSearchBarScrollBehavior)N(initialOffset,initialOffsetLimit,canScroll,snapAnimationSpec,flingAnimationSpec,reverseLayout)1088@48597L8,1090@48770L7,1091@48835L26,1105@49345L375,1094@48944L776:SearchBar.kt#uh7d8r");
        final float f4 = (i2 & 1) != 0 ? 0.0f : f2;
        final float f5 = (i2 & 2) != 0 ? -3.4028235E38f : f3;
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1997773186, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(SearchBarDefaults.enterAlwaysSearchBarScrollBehavior$lambda$1$lambda$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function02 = (Function0) objRememberedValue;
        } else {
            function02 = function0;
        }
        final AnimationSpec<Float> animationSpecValue = (i2 & 8) != 0 ? MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6) : animationSpec;
        final DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i2 & 16) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        boolean z2 = (i2 & 32) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1222500790, i, -1, "androidx.compose.material3.SearchBarDefaults.enterAlwaysSearchBarScrollBehavior (SearchBar.kt:1094)");
        }
        Object[] objArr = {animationSpecValue, decayAnimationSpecRememberSplineBasedDecay, function02, Boolean.valueOf(z2)};
        Saver<EnterAlwaysSearchBarScrollBehavior, ?> Saver = EnterAlwaysSearchBarScrollBehavior.INSTANCE.Saver(function02, animationSpecValue, decayAnimationSpecRememberSplineBasedDecay);
        ComposerKt.sourceInformationMarkerStart(composer, -1997748883, "CC(remember):SearchBar.kt#9igjgp");
        boolean z3 = true;
        boolean z4 = ((((i & 112) ^ 48) > 32 && composer.changed(f5)) || (i & 48) == 32) | ((((i & 14) ^ 6) > 4 && composer.changed(f4)) || (i & 6) == 4) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(function02)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        if ((((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 || !composer.changed(z2)) && (i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
            z3 = false;
        }
        boolean zChangedInstance = z4 | z3 | composer.changedInstance(animationSpecValue) | composer.changedInstance(decayAnimationSpecRememberSplineBasedDecay);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            final boolean z5 = z2;
            Function0 function03 = new Function0() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchBarDefaults.enterAlwaysSearchBarScrollBehavior$lambda$3$lambda$2(f4, f5, function02, z5, animationSpecValue, decayAnimationSpecRememberSplineBasedDecay);
                }
            };
            composer.updateRememberedValue(function03);
            objRememberedValue2 = function03;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior = (EnterAlwaysSearchBarScrollBehavior) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterAlwaysSearchBarScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior$lambda$3$lambda$2(float f2, float f3, Function0 function0, boolean z, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec) {
        return new EnterAlwaysSearchBarScrollBehavior(f2, f3, function0, z, animationSpec, decayAnimationSpec);
    }

    /* JADX INFO: renamed from: colors-Klgx-Pg, reason: not valid java name */
    public final SearchBarColors m3330colorsKlgxPg(long j, long j2, TextFieldColors textFieldColors, Composer composer, int i, int i2) {
        int i3;
        long j3;
        TextFieldColors textFieldColorsM3338inputFieldColorsJVEmHcM;
        ComposerKt.sourceInformationMarkerStart(composer, 701925149, "C(colors)N(containerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color,inputFieldColors)1128@50345L5,1129@50412L5,1131@50475L202:SearchBar.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer, 6) : j2;
        if ((i2 & 4) != 0) {
            j3 = value;
            i3 = i;
            textFieldColorsM3338inputFieldColorsJVEmHcM = m3338inputFieldColorsJVEmHcM(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, j3, j3, j3, composer, 0, 0, (i & 14) | ((i << 3) & 112) | ((i << 6) & 896) | (i & 7168), 1048575);
        } else {
            i3 = i;
            j3 = value;
            textFieldColorsM3338inputFieldColorsJVEmHcM = textFieldColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(701925149, i3, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:1137)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(j3, value2, textFieldColorsM3338inputFieldColorsJVEmHcM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarColors;
    }

    /* JADX INFO: renamed from: inputFieldColors-JVEmHcM, reason: not valid java name */
    public final TextFieldColors m3338inputFieldColorsJVEmHcM(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -2000124979, "C(inputFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color)1178@53452L5,1179@53526L5,1181@53621L5,1184@53777L5,1185@53856L7,1186@53939L5,1187@54022L5,1189@54130L5,1192@54306L5,1193@54391L5,1195@54501L5,1198@54679L5,1199@54765L5,1201@54867L5,1204@55036L5,1205@55120L5,1207@55215L5,1210@55384L5,1211@55468L5,1213@55563L5,1216@55727L5,1217@55806L5,1218@55884L5,1220@55942L1360:SearchBar.kt#uh7d8r");
        long value = (i4 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j;
        long value2 = (i4 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j2;
        long jM5967copywmQWz5c$default = (i4 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i4 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j4;
        if ((i4 & 16) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i4 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j5;
        long value5 = (i4 & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j6;
        long jM5967copywmQWz5c$default2 = (i4 & 128) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long value6 = (i4 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j8;
        long value7 = (i4 & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j9;
        long jM5967copywmQWz5c$default3 = (i4 & 1024) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long value8 = (i4 & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j11;
        long value9 = (i4 & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j12;
        long jM5967copywmQWz5c$default4 = (i4 & 8192) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long value10 = (i4 & 16384) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j14;
        long value11 = (32768 & i4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j15;
        long jM5967copywmQWz5c$default5 = (65536 & i4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long value12 = (131072 & i4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j17;
        long value13 = (262144 & i4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j18;
        long jM5967copywmQWz5c$default6 = (524288 & i4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long value14 = (1048576 & i4) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j20;
        long value15 = (2097152 & i4) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j21;
        long value16 = (i4 & 4194304) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2000124979, i, i2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1220)");
        }
        int i5 = i3 << 12;
        int i6 = i2 << 3;
        int i7 = i2 << 18;
        int i8 = i2 >> 24;
        TextFieldColors textFieldColorsM3674colors0hiis_0 = TextFieldDefaults.INSTANCE.m3674colors0hiis_0(value, value2, jM5967copywmQWz5c$default, 0L, value14, value15, value16, 0L, value3, 0L, textSelectionColors2, 0L, 0L, 0L, 0L, value4, value5, jM5967copywmQWz5c$default2, 0L, value6, value7, jM5967copywmQWz5c$default3, 0L, 0L, 0L, 0L, 0L, value8, value9, jM5967copywmQWz5c$default4, 0L, 0L, 0L, 0L, 0L, value10, value11, jM5967copywmQWz5c$default5, 0L, value12, value13, jM5967copywmQWz5c$default6, 0L, composer, (i & 1022) | (i5 & 57344) | (i5 & 458752) | (i5 & 3670016) | ((i << 15) & 234881024), ((i >> 12) & 14) | (i & 458752) | (i & 3670016) | (i & 29360128) | ((i << 3) & 1879048192), ((i >> 27) & 14) | (i6 & 112) | (i7 & 29360128) | (i7 & 234881024) | (i7 & 1879048192), (33488896 & i6) | ((i2 << 6) & 1879048192), (i8 & 14) | 3072 | (i8 & 112), 1204058760, 2191);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM3674colors0hiis_0;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0877  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x087a  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0880  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x090d  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0947  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x096d  */
    /* JADX WARN: Removed duplicated region for block: B:399:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void InputField(final androidx.compose.foundation.text.input.TextFieldState r117, final androidx.compose.material3.SearchBarState r118, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r119, androidx.compose.ui.Modifier r120, boolean r121, boolean r122, androidx.compose.ui.text.TextStyle r123, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r124, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, androidx.compose.foundation.text.input.InputTransformation r129, androidx.compose.foundation.text.input.OutputTransformation r130, androidx.compose.foundation.ScrollState r131, androidx.compose.ui.graphics.Shape r132, androidx.compose.material3.TextFieldColors r133, androidx.compose.foundation.interaction.MutableInteractionSource r134, androidx.compose.runtime.Composer r135, final int r136, final int r137, final int r138) {
        /*
            Method dump skipped, instruction units count: 2441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarDefaults.InputField(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.material3.SearchBarState, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.foundation.text.input.OutputTransformation, androidx.compose.foundation.ScrollState, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$9$lambda$8(boolean z, CoroutineScope coroutineScope, SearchBarState searchBarState, FocusState focusState) {
        if (focusState.isFocused() && z) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarDefaults$InputField$2$1$1(searchBarState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$11$lambda$10(String str, SearchBarState searchBarState, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        if (SearchBarKt.isExpanded(searchBarState)) {
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InputField$lambda$13$lambda$12(Function1 function1, TextFieldState textFieldState, Function0 function0) {
        function1.invoke(textFieldState.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$17$lambda$16(SearchBarState searchBarState, CoroutineScope coroutineScope) {
        if (!SearchBarKt.isExpanded(searchBarState)) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarDefaults$InputField$8$1$1(searchBarState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0859  */
    /* JADX WARN: Removed duplicated region for block: B:370:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void InputField(final androidx.compose.foundation.text.input.TextFieldState r111, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r112, final boolean r113, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r114, androidx.compose.ui.Modifier r115, boolean r116, boolean r117, androidx.compose.ui.text.TextStyle r118, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r119, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r120, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r121, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r122, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r123, androidx.compose.foundation.text.input.InputTransformation r124, androidx.compose.foundation.text.input.OutputTransformation r125, androidx.compose.foundation.ScrollState r126, androidx.compose.ui.graphics.Shape r127, androidx.compose.material3.TextFieldColors r128, androidx.compose.foundation.interaction.MutableInteractionSource r129, androidx.compose.runtime.Composer r130, final int r131, final int r132, final int r133) {
        /*
            Method dump skipped, instruction units count: 2167
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarDefaults.InputField(androidx.compose.foundation.text.input.TextFieldState, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.foundation.text.input.OutputTransformation, androidx.compose.foundation.ScrollState, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$25$lambda$24(Function1 function1, FocusState focusState) {
        if (focusState.isFocused()) {
            function1.invoke(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$27$lambda$26(String str, boolean z, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        if (z) {
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InputField$lambda$29$lambda$28(Function1 function1, TextFieldState textFieldState, Function0 function0) {
        function1.invoke(textFieldState.getText().toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void InputField(final java.lang.String r73, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r74, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r75, final boolean r76, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r77, androidx.compose.ui.Modifier r78, boolean r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r81, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r82, androidx.compose.material3.TextFieldColors r83, androidx.compose.foundation.interaction.MutableInteractionSource r84, androidx.compose.runtime.Composer r85, final int r86, final int r87, final int r88) {
        /*
            Method dump skipped, instruction units count: 1403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarDefaults.InputField(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$38$lambda$37(Function1 function1, FocusState focusState) {
        if (focusState.isFocused()) {
            function1.invoke(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$40$lambda$39(String str, boolean z, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        if (z) {
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField$lambda$42$lambda$41(Function1 function1, String str, KeyboardActionScope keyboardActionScope) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: colors-dgg9oW8, reason: not valid java name */
    public final /* synthetic */ SearchBarColors m3331colorsdgg9oW8(long j, long j2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 891254734, "C(colors)N(containerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color)1750@83659L5,1751@83726L5,1757@83916L218:SearchBar.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer, 6) : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(891254734, i, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:1753)");
        }
        int i3 = i << 3;
        long j3 = value;
        SearchBarColors searchBarColors = new SearchBarColors(j3, value2, m3338inputFieldColorsJVEmHcM(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, j3, j3, j3, composer, 0, 0, ((i << 6) & 896) | (i & 14) | (i3 & 112) | (i3 & 7168), 1048575), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarColors;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: inputFieldColors-ITpI4ow, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m3337inputFieldColorsITpI4ow(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -2048506052, "C(inputFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1767@84342L5,1768@84416L5,1770@84511L5,1773@84667L5,1774@84746L7,1775@84829L5,1776@84912L5,1778@85020L5,1781@85196L5,1782@85281L5,1784@85391L5,1787@85569L5,1788@85655L5,1790@85757L5,1809@86804L5,1810@86885L5,1812@86981L5,1815@87155L5,1816@87236L5,1818@87332L5,1821@87501L5,1822@87577L5,1823@87652L5,1794@85884L1784:SearchBar.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j;
        long value2 = (i3 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j2;
        long jM5967copywmQWz5c$default = (i3 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i3 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j4;
        if ((i3 & 16) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j5;
        long value5 = (i3 & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j6;
        long jM5967copywmQWz5c$default2 = (i3 & 128) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long value6 = (i3 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j8;
        long value7 = (i3 & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j9;
        long jM5967copywmQWz5c$default3 = (i3 & 1024) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long value8 = (i3 & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j11;
        long value9 = (i3 & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j12;
        long jM5967copywmQWz5c$default4 = (i3 & 8192) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2048506052, i, i2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1794)");
        }
        long j14 = value3;
        long j15 = jM5967copywmQWz5c$default;
        long j16 = value4;
        long j17 = value6;
        long j18 = value8;
        long j19 = jM5967copywmQWz5c$default2;
        long j20 = jM5967copywmQWz5c$default3;
        TextFieldColors textFieldColorsM3338inputFieldColorsJVEmHcM = m3338inputFieldColorsJVEmHcM(value, value2, j15, j14, textSelectionColors2, j16, value5, j19, j17, value7, j20, j18, value9, jM5967copywmQWz5c$default4, ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6), composer, i & 2147483646, i2 & 8190, (i2 >> 3) & 7168, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM3338inputFieldColorsJVEmHcM;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: inputFieldColors--u-KgnY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m3336inputFieldColorsuKgnY(long j, long j2, long j3, TextSelectionColors textSelectionColors, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, 1842555178, "C(inputFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1829@87858L5,1831@87953L5,1834@88109L5,1835@88188L7,1836@88271L5,1837@88354L5,1839@88462L5,1842@88638L5,1843@88723L5,1845@88833L5,1848@89004L5,1850@89106L5,1854@89216L825:SearchBar.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j;
        long jM5967copywmQWz5c$default = (i3 & 2) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long value2 = (i3 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j3;
        if ((i3 & 8) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value3 = (i3 & 16) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j4;
        long value4 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j5;
        long jM5967copywmQWz5c$default2 = (i3 & 64) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long value5 = (i3 & 128) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j7;
        long value6 = (i3 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j8;
        long jM5967copywmQWz5c$default3 = (i3 & 512) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long value7 = (i3 & 1024) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j10;
        long jM5967copywmQWz5c$default4 = (i3 & 2048) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1842555178, i, i2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1854)");
        }
        int i4 = i << 3;
        int i5 = i2 << 3;
        int i6 = i2 << 6;
        long j12 = value;
        long j13 = value2;
        long j14 = value3;
        long j15 = value4;
        long j16 = jM5967copywmQWz5c$default2;
        long j17 = value6;
        long j18 = value7;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        long j19 = value5;
        long j20 = jM5967copywmQWz5c$default3;
        TextFieldColors textFieldColorsM3338inputFieldColorsJVEmHcM = m3338inputFieldColorsJVEmHcM(j12, j12, jM5967copywmQWz5c$default, j13, textSelectionColors3, j14, j15, j16, j19, j17, j20, j18, j18, jM5967copywmQWz5c$default4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, (i & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), ((i >> 27) & 14) | (i5 & 112) | (i6 & 896) | (i6 & 7168), i5 & 7168, 8372224);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM3338inputFieldColorsJVEmHcM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean InputField$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
