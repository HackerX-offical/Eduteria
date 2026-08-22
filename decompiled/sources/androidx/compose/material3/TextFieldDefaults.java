package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0019\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2 \b\u0002\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0004\b:\u0010;JU\u0010<\u001a\u000207*\u0002072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t¢\u0006\u0004\b>\u0010?J¦\u0002\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020B2\u0011\u0010C\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u00182\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010GJ5\u0010H\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\t¢\u0006\u0004\bM\u0010NJ5\u0010O\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\t¢\u0006\u0004\bP\u0010NJ7\u0010Q\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0000¢\u0006\u0004\bR\u0010NJ\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010SJÂ\u0003\u0010/\u001a\u0002002\b\b\u0002\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020U2\b\b\u0002\u0010W\u001a\u00020U2\b\b\u0002\u0010X\u001a\u00020U2\b\b\u0002\u0010Y\u001a\u00020U2\b\b\u0002\u0010Z\u001a\u00020U2\b\b\u0002\u0010[\u001a\u00020U2\b\b\u0002\u0010\\\u001a\u00020U2\b\b\u0002\u0010]\u001a\u00020U2\b\b\u0002\u0010^\u001a\u00020U2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`2\b\b\u0002\u0010a\u001a\u00020U2\b\b\u0002\u0010b\u001a\u00020U2\b\b\u0002\u0010c\u001a\u00020U2\b\b\u0002\u0010d\u001a\u00020U2\b\b\u0002\u0010e\u001a\u00020U2\b\b\u0002\u0010f\u001a\u00020U2\b\b\u0002\u0010g\u001a\u00020U2\b\b\u0002\u0010h\u001a\u00020U2\b\b\u0002\u0010i\u001a\u00020U2\b\b\u0002\u0010j\u001a\u00020U2\b\b\u0002\u0010k\u001a\u00020U2\b\b\u0002\u0010l\u001a\u00020U2\b\b\u0002\u0010m\u001a\u00020U2\b\b\u0002\u0010n\u001a\u00020U2\b\b\u0002\u0010o\u001a\u00020U2\b\b\u0002\u0010p\u001a\u00020U2\b\b\u0002\u0010q\u001a\u00020U2\b\b\u0002\u0010r\u001a\u00020U2\b\b\u0002\u0010s\u001a\u00020U2\b\b\u0002\u0010t\u001a\u00020U2\b\b\u0002\u0010u\u001a\u00020U2\b\b\u0002\u0010v\u001a\u00020U2\b\b\u0002\u0010w\u001a\u00020U2\b\b\u0002\u0010x\u001a\u00020U2\b\b\u0002\u0010y\u001a\u00020U2\b\b\u0002\u0010z\u001a\u00020U2\b\b\u0002\u0010{\u001a\u00020U2\b\b\u0002\u0010|\u001a\u00020U2\b\b\u0002\u0010}\u001a\u00020U2\b\b\u0002\u0010~\u001a\u00020U2\b\b\u0002\u0010\u007f\u001a\u00020U2\t\b\u0002\u0010\u0080\u0001\u001a\u00020UH\u0007¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001d\u0010\u0083\u0001\u001a\u000200*\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020`H\u0000¢\u0006\u0003\b\u0086\u0001JI\u0010<\u001a\u000207*\u0002072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J9\u0010\u0089\u0001\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0003\u0010\u008a\u0001J9\u0010\u0097\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u0098\u0001\u0010NJ9\u0010\u0099\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u009a\u0001\u0010NJ9\u0010\u009b\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u009c\u0001\u0010NR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u001d\u0010\u008b\u0001\u001a\u00020\u00058GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008c\u0001\u0010\u0003\u001a\u0005\b\u008d\u0001\u0010\u0007R\u001d\u0010\u008e\u0001\u001a\u00020\u00058GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008f\u0001\u0010\u0003\u001a\u0005\b\u0090\u0001\u0010\u0007R!\u0010\u0091\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\f\u0012\u0005\b\u0092\u0001\u0010\u0003\u001a\u0005\b\u0093\u0001\u0010\u000bR!\u0010\u0094\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\f\u0012\u0005\b\u0095\u0001\u0010\u0003\u001a\u0005\b\u0096\u0001\u0010\u000b¨\u0006\u009d\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", StreamManagement.Enabled.ELEMENT, "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", DynamicLink.Builder.KEY_SUFFIX, "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", TextFieldImplKt.ContainerId, "modifier", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "indicatorLine", "textFieldShape", "indicatorLine-AWlRVLg", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)Landroidx/compose/ui/Modifier;", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "contentPaddingWithLabel", "start", "end", ViewHierarchyConstants.DIMENSION_TOP_KEY, "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "localTextSelectionColors", "defaultTextFieldColors$material3", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "ContainerBox", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "filledShape", "getFilledShape$annotations", "getFilledShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m8830constructorimpl(56);
    private static final float MinWidth = Dp.m8830constructorimpl(280);
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContainerBox$lambda$7(TextFieldDefaults textFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, int i, int i2, Composer composer, int i3) {
        textFieldDefaults.ContainerBox(z, z2, interactionSource, textFieldColors, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Container_4EFweAY$lambda$0(TextFieldDefaults textFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, Modifier modifier, TextFieldColors textFieldColors, Shape shape, float f2, float f3, int i, int i2, Composer composer, int i3) {
        textFieldDefaults.m3673Container4EFweAY(z, z2, interactionSource, modifier, textFieldColors, shape, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DecorationBox$lambda$3(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, Function2 function28, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function29, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function22, function23, function24, function25, function26, function27, function28, shape, textFieldColors, paddingValues, function29, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3665getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3666getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    private TextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1941327459, "C(<get-shape>)68@3251L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1941327459, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:68)");
        }
        Shape value = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m3679getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m3680getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getUnfocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m3682getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    /* JADX INFO: renamed from: getFocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m3678getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldDefaults$decorator$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldDefaults.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements TextFieldDecorator {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ Function2<Composer, Integer, Unit> $container;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ Function3<TextFieldLabelScope, Composer, Integer, Unit> $label;
        final /* synthetic */ TextFieldLabelPosition $labelPosition;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ TextFieldLineLimits $lineLimits;
        final /* synthetic */ OutputTransformation $outputTransformation;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(OutputTransformation outputTransformation, TextFieldState textFieldState, TextFieldLineLimits textFieldLineLimits, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z, boolean z2, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2<? super Composer, ? super Integer, Unit> function27) {
            this.$outputTransformation = outputTransformation;
            this.$state = textFieldState;
            this.$lineLimits = textFieldLineLimits;
            this.$labelPosition = textFieldLabelPosition;
            this.$label = function3;
            this.$placeholder = function2;
            this.$leadingIcon = function22;
            this.$trailingIcon = function23;
            this.$prefix = function24;
            this.$suffix = function25;
            this.$supportingText = function26;
            this.$enabled = z;
            this.$isError = z2;
            this.$interactionSource = interactionSource;
            this.$contentPadding = paddingValues;
            this.$colors = textFieldColors;
            this.$container = function27;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit Decoration$lambda$2(AnonymousClass2 anonymousClass2, Function2 function2, int i, Composer composer, int i2) {
            anonymousClass2.Decoration(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
            int i2;
            Composer composer2;
            TextFieldBuffer textFieldBuffer;
            CharSequence charSequenceAsCharSequence;
            Composer composerStartRestartGroup = composer.startRestartGroup(-94654579);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(innerTextField)191@10152L718:TextFieldDefaults.kt#uh7d8r");
            if ((i & 6) == 0) {
                i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
            }
            if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-94654579, i2, -1, "androidx.compose.material3.TextFieldDefaults.decorator.<no name provided>.Decoration (TextFieldDefaults.kt:179)");
                }
                if (this.$outputTransformation == null) {
                    charSequenceAsCharSequence = this.$state.getText();
                } else {
                    TextFieldState textFieldState = this.$state;
                    TextFieldBuffer textFieldBufferStartEdit = textFieldState.startEdit();
                    try {
                        textFieldState.commitEdit(textFieldBufferStartEdit);
                        textFieldState.finishEditing();
                        OutputTransformation outputTransformation = this.$outputTransformation;
                        if (textFieldBufferStartEdit == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("buffer");
                            textFieldBuffer = null;
                        } else {
                            textFieldBuffer = textFieldBufferStartEdit;
                        }
                        outputTransformation.transformOutput(textFieldBuffer);
                        charSequenceAsCharSequence = textFieldBufferStartEdit.asCharSequence();
                    } catch (Throwable th) {
                        textFieldState.finishEditing();
                        throw th;
                    }
                }
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, charSequenceAsCharSequence, function2, this.$labelPosition, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$prefix, this.$suffix, this.$supportingText, Intrinsics.areEqual(this.$lineLimits, TextFieldLineLimits.SingleLine.INSTANCE), this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$container, composer2, ((i2 << 6) & 896) | 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldDefaults$decorator$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.AnonymousClass2.Decoration$lambda$2(this.f$0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    public final TextFieldDecorator decorator(TextFieldState textFieldState, boolean z, TextFieldLineLimits textFieldLineLimits, OutputTransformation outputTransformation, InteractionSource interactionSource, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z2, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function27, Composer composer, int i, int i2, int i3) {
        TextFieldDefaults textFieldDefaults;
        final TextFieldColors textFieldColorsColors;
        PaddingValues paddingValues2;
        final boolean z3;
        final InteractionSource interactionSource2;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        PaddingValues paddingValuesM3664contentPaddingWithoutLabela9UjIt4$default;
        ComposerKt.sourceInformationMarkerStart(composer, 320881373, "C(decorator)N(state,enabled,lineLimits,outputTransformation,interactionSource,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,colors,contentPadding,container)160@8861L8,167@9160L391:TextFieldDefaults.kt#uh7d8r");
        TextFieldLabelPosition attached = (i3 & 32) != 0 ? new TextFieldLabelPosition.Attached(false, null, null, 7, null) : textFieldLabelPosition;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function32 = (i3 & 64) != 0 ? null : function3;
        Function2<? super Composer, ? super Integer, Unit> function28 = (i3 & 128) != 0 ? null : function2;
        Function2<? super Composer, ? super Integer, Unit> function29 = (i3 & 256) != 0 ? null : function22;
        Function2<? super Composer, ? super Integer, Unit> function210 = (i3 & 512) != 0 ? null : function23;
        Function2<? super Composer, ? super Integer, Unit> function211 = (i3 & 1024) != 0 ? null : function24;
        Function2<? super Composer, ? super Integer, Unit> function212 = (i3 & 2048) != 0 ? null : function25;
        Function2<? super Composer, ? super Integer, Unit> function213 = (i3 & 4096) != 0 ? null : function26;
        final boolean z5 = (i3 & 8192) != 0 ? false : z2;
        if ((i3 & 16384) != 0) {
            textFieldDefaults = this;
            textFieldColorsColors = textFieldDefaults.colors(composer, (i2 >> 21) & 14);
        } else {
            textFieldDefaults = this;
            textFieldColorsColors = textFieldColors;
        }
        if ((32768 & i3) != 0) {
            if (function32 == null || (attached instanceof TextFieldLabelPosition.Above)) {
                paddingValuesM3664contentPaddingWithoutLabela9UjIt4$default = m3664contentPaddingWithoutLabela9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
            } else {
                paddingValuesM3664contentPaddingWithoutLabela9UjIt4$default = m3663contentPaddingWithLabela9UjIt4$default(textFieldDefaults, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
            }
            paddingValues2 = paddingValuesM3664contentPaddingWithoutLabela9UjIt4$default;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i3 & 65536) != 0) {
            z3 = z;
            interactionSource2 = interactionSource;
            z4 = z5;
            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(245572296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults.decorator.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C173@9367L5,168@9174L367:TextFieldDefaults.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(245572296, i4, -1, "androidx.compose.material3.TextFieldDefaults.decorator.<anonymous> (TextFieldDefaults.kt:168)");
                    }
                    TextFieldDefaults.INSTANCE.m3673Container4EFweAY(z3, z5, interactionSource2, null, textFieldColorsColors, TextFieldDefaults.INSTANCE.getShape(composer2, 6), TextFieldDefaults.INSTANCE.m3678getFocusedIndicatorThicknessD9Ej5fM(), TextFieldDefaults.INSTANCE.m3682getUnfocusedIndicatorThicknessD9Ej5fM(), composer2, 114819072, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
        } else {
            z3 = z;
            interactionSource2 = interactionSource;
            z4 = z5;
            function2RememberComposableLambda = function27;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(320881373, i, i2, "androidx.compose.material3.TextFieldDefaults.decorator (TextFieldDefaults.kt:178)");
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(outputTransformation, textFieldState, textFieldLineLimits, attached, function32, function28, function29, function210, function211, function212, function213, z3, z4, interactionSource2, paddingValues2, textFieldColorsColors, function2RememberComposableLambda);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return anonymousClass2;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX INFO: renamed from: Container-4EFweAY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3673Container4EFweAY(final boolean r22, final boolean r23, final androidx.compose.foundation.interaction.InteractionSource r24, androidx.compose.ui.Modifier r25, androidx.compose.material3.TextFieldColors r26, androidx.compose.ui.graphics.Shape r27, float r28, float r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.m3673Container4EFweAY(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: indicatorLine-AWlRVLg$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3667indicatorLineAWlRVLg$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f2, float f3, int i, Object obj) {
        if ((i & 8) != 0) {
            textFieldColors = null;
        }
        if ((i & 16) != 0) {
            shape = null;
        }
        if ((i & 32) != 0) {
            f2 = FocusedIndicatorThickness;
        }
        if ((i & 64) != 0) {
            f3 = UnfocusedIndicatorThickness;
        }
        return textFieldDefaults.m3683indicatorLineAWlRVLg(modifier, z, z2, interactionSource, textFieldColors, shape, f2, f3);
    }

    /* JADX INFO: renamed from: indicatorLine-AWlRVLg, reason: not valid java name */
    public final Modifier m3683indicatorLineAWlRVLg(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f2, float f3) {
        return modifier.then(new IndicatorLineElement(z, z2, interactionSource, textFieldColors, shape, f2, f3, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:299:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void DecorationBox(final java.lang.String r36, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, final boolean r38, final boolean r39, final androidx.compose.ui.text.input.VisualTransformation r40, final androidx.compose.foundation.interaction.InteractionSource r41, boolean r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.ui.graphics.Shape r50, androidx.compose.material3.TextFieldColors r51, androidx.compose.foundation.layout.PaddingValues r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instruction units count: 1362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.DecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: renamed from: contentPaddingWithLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3663contentPaddingWithLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f5 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m3675contentPaddingWithLabela9UjIt4(f2, f3, f4, f5);
    }

    /* JADX INFO: renamed from: contentPaddingWithLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3675contentPaddingWithLabela9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m1147PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: contentPaddingWithoutLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3664contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3676contentPaddingWithoutLabela9UjIt4(f2, f3, f4, f5);
    }

    /* JADX INFO: renamed from: contentPaddingWithoutLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3676contentPaddingWithoutLabela9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m1147PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3670supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f3 = TextFieldImplKt.getSupportingTopPadding();
        }
        if ((i & 4) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f5 = Dp.m8830constructorimpl(0);
        }
        return textFieldDefaults.m3686supportingTextPaddinga9UjIt4$material3(f2, f3, f4, f5);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3, reason: not valid java name */
    public final PaddingValues m3686supportingTextPaddinga9UjIt4$material3(float start, float top, float end, float bottom) {
        return PaddingKt.m1147PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 831731228, "C(colors)478@24135L11,478@24195L7:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(831731228, i, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:478)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localTextSelectionColors);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldColors textFieldColorsDefaultTextFieldColors$material3 = defaultTextFieldColors$material3(colorScheme, (TextSelectionColors) objConsume);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsDefaultTextFieldColors$material3;
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m3674colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        ComposerKt.sourceInformationMarkerStart(composer, 1513344955, "C(colors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedSupportingTextColor:c#ui.graphics.Color,unfocusedSupportingTextColor:c#ui.graphics.Color,disabledSupportingTextColor:c#ui.graphics.Color,errorSupportingTextColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)580@31011L11,581@31084L7:TextFieldDefaults.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i6 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        long jM6004getUnspecified0d7_KjU7 = (i6 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j7;
        long jM6004getUnspecified0d7_KjU8 = (i6 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j8;
        long jM6004getUnspecified0d7_KjU9 = (i6 & 256) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j9;
        long jM6004getUnspecified0d7_KjU10 = (i6 & 512) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors2 = (i6 & 1024) != 0 ? null : textSelectionColors;
        long jM6004getUnspecified0d7_KjU11 = (i6 & 2048) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j11;
        long jM6004getUnspecified0d7_KjU12 = (i6 & 4096) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j12;
        long jM6004getUnspecified0d7_KjU13 = (i6 & 8192) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j13;
        long jM6004getUnspecified0d7_KjU14 = (i6 & 16384) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j14;
        long jM6004getUnspecified0d7_KjU15 = (32768 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j15;
        long jM6004getUnspecified0d7_KjU16 = (65536 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j16;
        long jM6004getUnspecified0d7_KjU17 = (131072 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j17;
        long jM6004getUnspecified0d7_KjU18 = (262144 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j18;
        long jM6004getUnspecified0d7_KjU19 = (524288 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j19;
        long jM6004getUnspecified0d7_KjU20 = (1048576 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j20;
        long jM6004getUnspecified0d7_KjU21 = (2097152 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j21;
        long jM6004getUnspecified0d7_KjU22 = (4194304 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j22;
        long jM6004getUnspecified0d7_KjU23 = (8388608 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j23;
        long jM6004getUnspecified0d7_KjU24 = (16777216 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j24;
        long jM6004getUnspecified0d7_KjU25 = (33554432 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j25;
        long jM6004getUnspecified0d7_KjU26 = (67108864 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j26;
        long jM6004getUnspecified0d7_KjU27 = (134217728 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j27;
        long jM6004getUnspecified0d7_KjU28 = (268435456 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j28;
        long jM6004getUnspecified0d7_KjU29 = (536870912 & i6) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j29;
        long jM6004getUnspecified0d7_KjU30 = (i6 & 1073741824) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j30;
        long jM6004getUnspecified0d7_KjU31 = (i7 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j31;
        long jM6004getUnspecified0d7_KjU32 = (i7 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j32;
        long jM6004getUnspecified0d7_KjU33 = (i7 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j33;
        long jM6004getUnspecified0d7_KjU34 = (i7 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j34;
        long jM6004getUnspecified0d7_KjU35 = (i7 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j35;
        long jM6004getUnspecified0d7_KjU36 = (i7 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j36;
        long jM6004getUnspecified0d7_KjU37 = (i7 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j37;
        long jM6004getUnspecified0d7_KjU38 = (i7 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j38;
        long jM6004getUnspecified0d7_KjU39 = (i7 & 256) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j39;
        long jM6004getUnspecified0d7_KjU40 = (i7 & 512) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j40;
        long jM6004getUnspecified0d7_KjU41 = (i7 & 1024) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j41;
        long jM6004getUnspecified0d7_KjU42 = (i7 & 2048) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1513344955, i, i2, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:580)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localTextSelectionColors);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldColors textFieldColorsM3608copyejIjP34 = defaultTextFieldColors$material3(colorScheme, (TextSelectionColors) objConsume).m3608copyejIjP34(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, jM6004getUnspecified0d7_KjU7, jM6004getUnspecified0d7_KjU8, jM6004getUnspecified0d7_KjU9, jM6004getUnspecified0d7_KjU10, textSelectionColors2, jM6004getUnspecified0d7_KjU11, jM6004getUnspecified0d7_KjU12, jM6004getUnspecified0d7_KjU13, jM6004getUnspecified0d7_KjU14, jM6004getUnspecified0d7_KjU15, jM6004getUnspecified0d7_KjU16, jM6004getUnspecified0d7_KjU17, jM6004getUnspecified0d7_KjU18, jM6004getUnspecified0d7_KjU19, jM6004getUnspecified0d7_KjU20, jM6004getUnspecified0d7_KjU21, jM6004getUnspecified0d7_KjU22, jM6004getUnspecified0d7_KjU23, jM6004getUnspecified0d7_KjU24, jM6004getUnspecified0d7_KjU25, jM6004getUnspecified0d7_KjU26, jM6004getUnspecified0d7_KjU27, jM6004getUnspecified0d7_KjU28, jM6004getUnspecified0d7_KjU29, jM6004getUnspecified0d7_KjU30, jM6004getUnspecified0d7_KjU31, jM6004getUnspecified0d7_KjU32, jM6004getUnspecified0d7_KjU33, jM6004getUnspecified0d7_KjU34, jM6004getUnspecified0d7_KjU35, jM6004getUnspecified0d7_KjU36, jM6004getUnspecified0d7_KjU37, jM6004getUnspecified0d7_KjU38, jM6004getUnspecified0d7_KjU39, jM6004getUnspecified0d7_KjU40, jM6004getUnspecified0d7_KjU41, jM6004getUnspecified0d7_KjU42);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM3608copyejIjP34;
    }

    public final TextFieldColors defaultTextFieldColors$material3(ColorScheme colorScheme, TextSelectionColors textSelectionColors) {
        TextFieldColors defaultTextFieldColorsCached = colorScheme.getDefaultTextFieldColorsCached();
        if (defaultTextFieldColorsCached != null) {
            if (!Intrinsics.areEqual(defaultTextFieldColorsCached.getTextSelectionColors(), textSelectionColors)) {
                defaultTextFieldColorsCached = TextFieldColors.m3606copyejIjP34$default(defaultTextFieldColorsCached, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, textSelectionColors, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1025, 2047, null);
                colorScheme.setDefaultTextFieldColorsCached$material3(defaultTextFieldColorsCached);
            }
            if (defaultTextFieldColorsCached != null) {
                return defaultTextFieldColorsCached;
            }
        }
        TextFieldColors textFieldColors = new TextFieldColors(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusInputColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorInputColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getCaretColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor()), textSelectionColors, ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor()), FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getLabelColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledLabelColor()), FilledTextFieldTokens.INSTANCE.getDisabledLabelOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getSupportingColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor()), FilledTextFieldTokens.INSTANCE.getDisabledSupportingOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
        colorScheme.setDefaultTextFieldColorsCached$material3(textFieldColors);
        return textFieldColors;
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3668indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f2, float f3, int i, Object obj) {
        if ((i & 16) != 0) {
            f2 = FocusedIndicatorThickness;
        }
        return textFieldDefaults.m3684indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f2, (i & 32) != 0 ? UnfocusedIndicatorThickness : f3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `textFieldShape`.")
    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final /* synthetic */ Modifier m3684indicatorLinegv0btCI(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f2, float f3) {
        return m3683indicatorLineAWlRVLg(modifier, z, z2, interactionSource, textFieldColors, null, f2, f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0133  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Renamed to TextFieldDefaults.Container", replaceWith = @kotlin.ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ContainerBox(final boolean r21, final boolean r22, final androidx.compose.foundation.interaction.InteractionSource r23, final androidx.compose.material3.TextFieldColors r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.ContainerBox(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -584749279, "C(<get-outlinedShape>)782@42187L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584749279, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:782)");
        }
        Shape shape = OutlinedTextFieldDefaults.INSTANCE.getShape(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    public final Shape getFilledShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 611926497, "C(<get-filledShape>)790@42434L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(611926497, i, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:790)");
        }
        Shape shape = getShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3681getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3677getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3671textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        if ((i & 8) != 0) {
            f5 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }
        return textFieldDefaults.m3687textFieldWithLabelPaddinga9UjIt4(f2, f3, f4, f5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3687textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return m3675contentPaddingWithLabela9UjIt4(start, end, top, bottom);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3672textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3688textFieldWithoutLabelPaddinga9UjIt4(f2, f3, f4, f5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3688textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return m3676contentPaddingWithoutLabela9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3669outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f5 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3685outlinedTextFieldPaddinga9UjIt4(f2, f3, f4, f5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3685outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return OutlinedTextFieldDefaults.INSTANCE.m3243contentPaddinga9UjIt4(start, top, end, bottom);
    }

    static {
        float fM8830constructorimpl = Dp.m8830constructorimpl(1);
        UnfocusedIndicatorThickness = fM8830constructorimpl;
        float fM8830constructorimpl2 = Dp.m8830constructorimpl(2);
        FocusedIndicatorThickness = fM8830constructorimpl2;
        UnfocusedBorderThickness = fM8830constructorimpl;
        FocusedBorderThickness = fM8830constructorimpl2;
    }
}
