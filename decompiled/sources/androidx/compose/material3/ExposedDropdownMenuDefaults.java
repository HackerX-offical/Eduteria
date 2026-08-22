package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\nJ\u0095\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0007¢\u0006\u0004\b6\u00107J\u0095\u0003\u00108\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0007¢\u0006\u0004\b=\u00107J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010BJ\u0081\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0007¢\u0006\u0004\bD\u0010EJ\u0081\u0003\u00108\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0007¢\u0006\u0004\bF\u0010EJÿ\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010G\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010H\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007¢\u0006\u0004\bI\u0010JJÿ\u0001\u00108\u001a\u00020\f2\b\b\u0002\u0010G\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010H\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007¢\u0006\u0004\bK\u0010JR\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006L"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "<init>", "()V", "TrailingIcon", "", "expanded", "", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "textFieldColors", "Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "textFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "outlinedTextFieldColors-FD9MK7s", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "(ZLandroidx/compose/runtime/Composer;I)V", "containerColor", "textFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-tN0la-I", "textColor", "placeholderColor", "textFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-St-qZLY", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();
    private static final PaddingValues ItemContentPadding = PaddingKt.m1145PaddingValuesYgX7TsA(ExposedDropdownMenuKt.ExposedDropdownMenuItemHorizontalPadding, Dp.m8830constructorimpl(0));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailingIcon$lambda$0(ExposedDropdownMenuDefaults exposedDropdownMenuDefaults, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        exposedDropdownMenuDefaults.TrailingIcon(z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailingIcon$lambda$1(ExposedDropdownMenuDefaults exposedDropdownMenuDefaults, boolean z, int i, Composer composer, int i2) {
        exposedDropdownMenuDefaults.TrailingIcon(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1732824199);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrailingIcon)N(expanded,modifier)512@22846L83:ExposedDropdownMenu.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1732824199, i3, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:511)");
            }
            IconKt.m2997Iconww6aTOc(Icons.Filled.INSTANCE.getArrowDropDown$material3(), (String) null, RotateKt.rotate(modifier, z ? 180.0f : 0.0f), 0L, composerStartRestartGroup, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuDefaults.TrailingIcon$lambda$0(this.f$0, z, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: textFieldColors-FD9MK7s, reason: not valid java name */
    public final TextFieldColors m2893textFieldColorsFD9MK7s(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        int i7;
        long value;
        int i8;
        long value2;
        int i9;
        long value3;
        int i10;
        long value4;
        int i11;
        long value5;
        int i12;
        long value6;
        ComposerKt.sourceInformationMarkerStart(composer, -375683630, "C(textFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)565@26918L5,566@27006L5,568@27113L5,571@27301L5,572@27396L5,573@27493L5,574@27589L5,575@27682L5,576@27763L5,577@27859L5,578@27938L7,580@28058L5,582@28173L5,584@28295L5,588@28520L5,590@28636L5,591@28737L5,593@28857L5,597@29076L5,599@29194L5,601@29309L5,603@29431L5,607@29653L5,608@29745L5,609@29834L5,610@29930L5,611@30020L5,612@30118L5,613@30218L5,615@30337L5,618@30537L5,619@30630L5,620@30725L5,622@30839L5,625@31034L5,626@31127L5,627@31222L5,629@31336L5,632@31531L5,634@31589L2230:ExposedDropdownMenu.kt#uh7d8r");
        long value7 = (i5 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, 6) : j;
        long value8 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j2;
        long jM5967copywmQWz5c$default = (i5 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value9 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, 6) : j4;
        long value10 = (i5 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j5;
        long value11 = (i5 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j6;
        long value12 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j7;
        long value13 = (i5 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j8;
        long value14 = (i5 & 256) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j9;
        long value15 = (i5 & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j10;
        if ((i5 & 1024) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i5 & 2048) != 0) {
            i7 = 6;
            value = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer, 6);
        } else {
            i7 = 6;
            value = j11;
        }
        long value16 = (i5 & 4096) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer, i7) : j12;
        long jM5967copywmQWz5c$default2 = (i5 & 8192) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer, i7), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        if ((i5 & 16384) != 0) {
            i8 = 6;
            value2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer, 6);
        } else {
            i8 = 6;
            value2 = j14;
        }
        long value17 = (i5 & 32768) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, i8) : j15;
        long value18 = (i5 & 65536) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, i8) : j16;
        long jM5967copywmQWz5c$default3 = (i5 & 131072) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, i8), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((i5 & 262144) != 0) {
            i9 = 6;
            value3 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i9 = 6;
            value3 = j18;
        }
        long value19 = (i5 & 524288) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i9) : j19;
        long value20 = (i5 & 1048576) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i9) : j20;
        long jM5967copywmQWz5c$default4 = (i5 & 2097152) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i9), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if ((i5 & 4194304) != 0) {
            i10 = 6;
            value4 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i10 = 6;
            value4 = j22;
        }
        long value21 = (i5 & 8388608) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i10) : j23;
        long value22 = (i5 & 16777216) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i10) : j24;
        long value23 = (i5 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i10) : j25;
        long value24 = (i5 & 67108864) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, i10) : j26;
        long value25 = (i5 & 134217728) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i10) : j27;
        long value26 = (i5 & 268435456) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i10) : j28;
        long jM5967copywmQWz5c$default5 = (i5 & 536870912) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i10), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j29;
        if ((i5 & 1073741824) != 0) {
            i11 = 6;
            value5 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i11 = 6;
            value5 = j30;
        }
        long value27 = (i6 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j31;
        long value28 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j32;
        long jM5967copywmQWz5c$default6 = (i6 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i11), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j33;
        if ((i6 & 8) != 0) {
            i12 = 6;
            value6 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i12 = 6;
            value6 = j34;
        }
        long value29 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j35;
        long value30 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j36;
        long jM5967copywmQWz5c$default7 = (i6 & 64) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i12), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j37;
        long value31 = (i6 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j38;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-375683630, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:634)");
        }
        int i13 = i4 << 12;
        int i14 = i4 >> 18;
        int i15 = (i14 & 14) | 3072 | (i14 & 112) | (i14 & 896);
        long j39 = jM5967copywmQWz5c$default2;
        long j40 = jM5967copywmQWz5c$default;
        long j41 = value11;
        long j42 = value14;
        TextFieldColors textFieldColorsM3674colors0hiis_0 = TextFieldDefaults.INSTANCE.m3674colors0hiis_0(value7, value8, j40, value9, value10, j41, value12, value13, j42, value15, textSelectionColors3, value, value16, j39, value2, value17, value18, jM5967copywmQWz5c$default3, value3, value19, value20, jM5967copywmQWz5c$default4, value4, value21, value22, value23, value24, value25, value26, jM5967copywmQWz5c$default5, value5, 0L, 0L, 0L, 0L, value27, value28, jM5967copywmQWz5c$default6, value6, value29, value30, jM5967copywmQWz5c$default7, value31, composer, i & 2147483646, i2 & 2147483646, i3 & 2147483646, (i4 & 14) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (234881024 & i13) | (i13 & 1879048192), i15, 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM3674colors0hiis_0;
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-FD9MK7s, reason: not valid java name */
    public final TextFieldColors m2890outlinedTextFieldColorsFD9MK7s(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        int i7;
        long value;
        int i8;
        long value2;
        int i9;
        long value3;
        int i10;
        long value4;
        int i11;
        long value5;
        int i12;
        long value6;
        int i13;
        long value7;
        ComposerKt.sourceInformationMarkerStart(composer, -325161132, "C(outlinedTextFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)726@37797L5,727@37887L5,729@37996L5,732@38188L5,737@38504L5,738@38602L5,739@38681L7,740@38780L5,741@38874L5,743@38987L5,746@39185L5,748@39303L5,750@39418L5,752@39540L5,756@39763L5,758@39883L5,760@40000L5,762@40124L5,766@40350L5,767@40444L5,768@40535L5,770@40645L5,773@40838L5,774@40938L5,776@41052L5,778@41173L5,781@41377L5,782@41472L5,783@41569L5,785@41685L5,788@41884L5,789@41979L5,790@42076L5,792@42192L5,795@42391L5,797@42457L2206:ExposedDropdownMenu.kt#uh7d8r");
        long value8 = (i5 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, 6) : j;
        long value9 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j2;
        long jM5967copywmQWz5c$default = (i5 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value10 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, 6) : j4;
        long jM6003getTransparent0d7_KjU = (i5 & 16) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j5;
        long jM6003getTransparent0d7_KjU2 = (i5 & 32) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j6;
        long jM6003getTransparent0d7_KjU3 = (i5 & 64) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j7;
        long jM6003getTransparent0d7_KjU4 = (i5 & 128) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j8;
        long value11 = (i5 & 256) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j9;
        long value12 = (i5 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j10;
        if ((i5 & 1024) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i5 & 2048) != 0) {
            i7 = 6;
            value = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer, 6);
        } else {
            i7 = 6;
            value = j11;
        }
        long value13 = (i5 & 4096) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer, i7) : j12;
        long jM5967copywmQWz5c$default2 = (i5 & 8192) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer, i7), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        if ((i5 & 16384) != 0) {
            i8 = 6;
            value2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer, 6);
        } else {
            i8 = 6;
            value2 = j14;
        }
        long value14 = (i5 & 32768) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, i8) : j15;
        long value15 = (i5 & 65536) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, i8) : j16;
        long jM5967copywmQWz5c$default3 = (i5 & 131072) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, i8), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((i5 & 262144) != 0) {
            i9 = 6;
            value3 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i9 = 6;
            value3 = j18;
        }
        long value16 = (i5 & 524288) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i9) : j19;
        long value17 = (i5 & 1048576) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i9) : j20;
        long jM5967copywmQWz5c$default4 = (i5 & 2097152) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i9), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if ((i5 & 4194304) != 0) {
            i10 = 6;
            value4 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i10 = 6;
            value4 = j22;
        }
        long value18 = (i5 & 8388608) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i10) : j23;
        long value19 = (i5 & 16777216) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i10) : j24;
        long jM5967copywmQWz5c$default5 = (i5 & GroupFlagsKt.HasAuxSlotFlag) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i10), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j25;
        if ((i5 & 67108864) != 0) {
            i11 = 6;
            value5 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6);
        } else {
            i11 = 6;
            value5 = j26;
        }
        long value20 = (i5 & 134217728) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j27;
        long value21 = (i5 & 268435456) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j28;
        long jM5967copywmQWz5c$default6 = (i5 & 536870912) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i11), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j29;
        if ((i5 & 1073741824) != 0) {
            i12 = 6;
            value6 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i12 = 6;
            value6 = j30;
        }
        long value22 = (i6 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j31;
        long value23 = (i6 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j32;
        long jM5967copywmQWz5c$default7 = (i6 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i12), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j33;
        if ((i6 & 8) != 0) {
            i13 = 6;
            value7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i13 = 6;
            value7 = j34;
        }
        long value24 = (i6 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i13) : j35;
        long value25 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i13) : j36;
        long jM5967copywmQWz5c$default8 = (i6 & 64) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i13), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j37;
        long value26 = (i6 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j38;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-325161132, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:797)");
        }
        int i14 = i4 << 12;
        int i15 = i4 >> 18;
        int i16 = (i15 & 14) | 3072 | (i15 & 112) | (i15 & 896);
        long j39 = jM5967copywmQWz5c$default2;
        long j40 = jM5967copywmQWz5c$default;
        long j41 = jM6003getTransparent0d7_KjU2;
        long j42 = value11;
        TextFieldColors textFieldColorsM3242colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m3242colors0hiis_0(value8, value9, j40, value10, jM6003getTransparent0d7_KjU, j41, jM6003getTransparent0d7_KjU3, jM6003getTransparent0d7_KjU4, j42, value12, textSelectionColors3, value, value13, j39, value2, value14, value15, jM5967copywmQWz5c$default3, value3, value16, value17, jM5967copywmQWz5c$default4, value4, value18, value19, jM5967copywmQWz5c$default5, value5, value20, value21, jM5967copywmQWz5c$default6, value6, 0L, 0L, 0L, 0L, value22, value23, jM5967copywmQWz5c$default7, value7, value24, value25, jM5967copywmQWz5c$default8, value26, composer, i & 2147483646, i2 & 2147483646, i3 & 2147483646, (i4 & 14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), i16, 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM3242colors0hiis_0;
    }

    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final /* synthetic */ void TrailingIcon(boolean z, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1803742020);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrailingIcon)N(expanded)849@45151L32:ExposedDropdownMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1803742020, i2, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:849)");
            }
            z2 = z;
            TrailingIcon(z2, Modifier.INSTANCE, composerStartRestartGroup, (i2 & 14) | 48 | ((i2 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z2 = z;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuDefaults.TrailingIcon$lambda$1(this.f$0, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: textFieldColors-tN0la-I, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2895textFieldColorstN0laI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        int i7;
        long value;
        long j37;
        int i8;
        long value2;
        int i9;
        long value3;
        int i10;
        long value4;
        int i11;
        long value5;
        int i12;
        long value6;
        ComposerKt.sourceInformationMarkerStart(composer, 1357676928, "C(textFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)854@45398L5,855@45486L5,857@45593L5,860@45781L5,861@45869L5,862@45962L5,863@46043L5,864@46139L5,865@46218L7,867@46338L5,869@46453L5,871@46575L5,875@46800L5,877@46916L5,878@47017L5,880@47137L5,884@47356L5,886@47474L5,888@47589L5,890@47711L5,894@47933L5,895@48025L5,896@48114L5,897@48210L5,898@48300L5,899@48398L5,900@48498L5,902@48617L5,905@48817L5,906@48910L5,907@49005L5,909@49119L5,912@49314L5,913@49407L5,914@49502L5,916@49616L5,919@49811L5,921@49851L2215:ExposedDropdownMenu.kt#uh7d8r");
        long value7 = (i5 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, 6) : j;
        long value8 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j2;
        long jM5967copywmQWz5c$default = (i5 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value9 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, 6) : j4;
        long value10 = (i5 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j5;
        long value11 = (i5 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j6;
        long value12 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j7;
        long value13 = (i5 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j8;
        if ((i5 & 256) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i5 & 512) != 0) {
            i7 = 6;
            value = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer, 6);
        } else {
            i7 = 6;
            value = j9;
        }
        long value14 = (i5 & 1024) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer, i7) : j10;
        long jM5967copywmQWz5c$default2 = (i5 & 2048) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer, i7), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        if ((i5 & 4096) != 0) {
            j37 = jM5967copywmQWz5c$default2;
            i8 = 6;
            value2 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer, 6);
        } else {
            j37 = jM5967copywmQWz5c$default2;
            i8 = 6;
            value2 = j12;
        }
        long value15 = (i5 & 8192) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, i8) : j13;
        long value16 = (i5 & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, i8) : j14;
        long jM5967copywmQWz5c$default3 = (32768 & i5) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, i8), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        if ((65536 & i5) != 0) {
            i9 = 6;
            value3 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i9 = 6;
            value3 = j16;
        }
        long value17 = (131072 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i9) : j17;
        long value18 = (262144 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i9) : j18;
        long jM5967copywmQWz5c$default4 = (524288 & i5) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i9), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        if ((1048576 & i5) != 0) {
            i10 = 6;
            value4 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i10 = 6;
            value4 = j20;
        }
        long value19 = (2097152 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i10) : j21;
        long value20 = (4194304 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i10) : j22;
        long value21 = (8388608 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i10) : j23;
        long value22 = (16777216 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, i10) : j24;
        long value23 = (33554432 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i10) : j25;
        long value24 = (67108864 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i10) : j26;
        long jM5967copywmQWz5c$default5 = (134217728 & i5) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i10), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j27;
        if ((268435456 & i5) != 0) {
            i11 = 6;
            value5 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i11 = 6;
            value5 = j28;
        }
        long value25 = (536870912 & i5) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j29;
        long value26 = (i5 & 1073741824) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j30;
        long jM5967copywmQWz5c$default6 = (i6 & 1) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i11), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j31;
        if ((i6 & 2) != 0) {
            i12 = 6;
            value6 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i12 = 6;
            value6 = j32;
        }
        long value27 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j33;
        long value28 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j34;
        long jM5967copywmQWz5c$default7 = (i6 & 16) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i12), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j35;
        long value29 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j36;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1357676928, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:921)");
        }
        int i13 = i << 6;
        int i14 = (65534 & i) | ((i << 3) & 458752) | (i13 & 3670016) | (i13 & 29360128) | (i13 & 234881024) | (i13 & 1879048192);
        int i15 = i2 << 6;
        int i16 = i3 << 6;
        int i17 = ((i2 >> 24) & 126) | (i16 & 896) | (i16 & 7168) | (i16 & 57344) | (i16 & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192);
        int i18 = i4 << 6;
        long j38 = value10;
        TextFieldColors textFieldColorsM2893textFieldColorsFD9MK7s = m2893textFieldColorsFD9MK7s(value7, value8, jM5967copywmQWz5c$default, value9, j38, value10, j38, value11, value12, value13, textSelectionColors3, value, value14, j37, value2, value15, value16, jM5967copywmQWz5c$default3, value3, value17, value18, jM5967copywmQWz5c$default4, value4, value19, value20, value21, value22, value23, value24, jM5967copywmQWz5c$default5, value5, value25, value26, jM5967copywmQWz5c$default6, value6, value27, value28, jM5967copywmQWz5c$default7, value29, composer, i14, ((i >> 24) & 126) | (i15 & 896) | (i15 & 7168) | (i15 & 57344) | (i15 & 458752) | (i15 & 3670016) | (i15 & 29360128) | (i15 & 234881024) | (i15 & 1879048192), i17, ((i3 >> 24) & 126) | (i18 & 896) | (i18 & 7168) | (i18 & 57344) | (i18 & 458752) | (i18 & 3670016) | (i18 & 29360128) | (i18 & 234881024) | (i18 & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM2893textFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: outlinedTextFieldColors-tN0la-I, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2892outlinedTextFieldColorstN0laI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, TextSelectionColors textSelectionColors, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, Composer composer, int i, int i2, int i3, int i4, int i5, int i6) {
        TextSelectionColors textSelectionColors2;
        int i7;
        long value;
        long j37;
        int i8;
        long value2;
        int i9;
        long value3;
        int i10;
        long value4;
        int i11;
        long value5;
        int i12;
        long value6;
        int i13;
        long value7;
        ComposerKt.sourceInformationMarkerStart(composer, -907010558, "C(outlinedTextFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)966@52291L5,967@52381L5,969@52490L5,972@52682L5,975@52872L5,976@52970L5,977@53049L7,978@53148L5,979@53242L5,981@53355L5,984@53553L5,986@53671L5,988@53786L5,990@53908L5,994@54131L5,996@54251L5,998@54368L5,1000@54492L5,1004@54718L5,1005@54812L5,1006@54903L5,1008@55013L5,1011@55206L5,1012@55306L5,1014@55420L5,1016@55541L5,1019@55745L5,1020@55840L5,1021@55937L5,1023@56053L5,1026@56252L5,1027@56347L5,1028@56444L5,1030@56560L5,1033@56759L5,1035@56799L2199:ExposedDropdownMenu.kt#uh7d8r");
        long value8 = (i5 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), composer, 6) : j;
        long value9 = (i5 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j2;
        long jM5967copywmQWz5c$default = (i5 & 4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value10 = (i5 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), composer, 6) : j4;
        long jM6003getTransparent0d7_KjU = (i5 & 16) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j5;
        long jM6003getTransparent0d7_KjU2 = (i5 & 32) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j6;
        long value11 = (i5 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j7;
        long value12 = (i5 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j8;
        if ((i5 & 256) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        if ((i5 & 512) != 0) {
            i7 = 6;
            value = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer, 6);
        } else {
            i7 = 6;
            value = j9;
        }
        long value13 = (i5 & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer, i7) : j10;
        long jM5967copywmQWz5c$default2 = (i5 & 2048) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer, i7), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        if ((i5 & 4096) != 0) {
            j37 = jM5967copywmQWz5c$default2;
            i8 = 6;
            value2 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer, 6);
        } else {
            j37 = jM5967copywmQWz5c$default2;
            i8 = 6;
            value2 = j12;
        }
        long value14 = (i5 & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, i8) : j13;
        long value15 = (i5 & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, i8) : j14;
        long jM5967copywmQWz5c$default3 = (32768 & i5) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, i8), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        if ((65536 & i5) != 0) {
            i9 = 6;
            value3 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6);
        } else {
            i9 = 6;
            value3 = j16;
        }
        long value16 = (131072 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, i9) : j17;
        long value17 = (262144 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, i9) : j18;
        long jM5967copywmQWz5c$default4 = (524288 & i5) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, i9), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        if ((1048576 & i5) != 0) {
            i10 = 6;
            value4 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6);
        } else {
            i10 = 6;
            value4 = j20;
        }
        long value18 = (2097152 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, i10) : j21;
        long value19 = (4194304 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, i10) : j22;
        long jM5967copywmQWz5c$default5 = (8388608 & i5) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, i10), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if ((16777216 & i5) != 0) {
            i11 = 6;
            value5 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6);
        } else {
            i11 = 6;
            value5 = j24;
        }
        long value20 = (33554432 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j25;
        long value21 = (67108864 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i11) : j26;
        long jM5967copywmQWz5c$default6 = (134217728 & i5) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i11), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j27;
        if ((268435456 & i5) != 0) {
            i12 = 6;
            value6 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i12 = 6;
            value6 = j28;
        }
        long value22 = (536870912 & i5) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j29;
        long value23 = (i5 & 1073741824) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i12) : j30;
        long jM5967copywmQWz5c$default7 = (i6 & 1) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i12), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j31;
        if ((i6 & 2) != 0) {
            i13 = 6;
            value7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6);
        } else {
            i13 = 6;
            value7 = j32;
        }
        long value24 = (i6 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i13) : j33;
        long value25 = (i6 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, i13) : j34;
        long jM5967copywmQWz5c$default8 = (i6 & 16) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, i13), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j35;
        long value26 = (i6 & 32) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j36;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-907010558, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:1035)");
        }
        int i14 = i << 6;
        int i15 = (65534 & i) | ((i << 3) & 458752) | (i14 & 3670016) | (i14 & 29360128) | (i14 & 234881024) | (i14 & 1879048192);
        int i16 = i2 << 6;
        int i17 = i3 << 6;
        int i18 = ((i2 >> 24) & 126) | (i17 & 896) | (i17 & 7168) | (i17 & 57344) | (i17 & 458752) | (i17 & 3670016) | (i17 & 29360128) | (i17 & 234881024) | (i17 & 1879048192);
        int i19 = i4 << 6;
        long j38 = jM6003getTransparent0d7_KjU;
        TextFieldColors textFieldColorsM2890outlinedTextFieldColorsFD9MK7s = m2890outlinedTextFieldColorsFD9MK7s(value8, value9, jM5967copywmQWz5c$default, value10, j38, jM6003getTransparent0d7_KjU, j38, jM6003getTransparent0d7_KjU2, value11, value12, textSelectionColors3, value, value13, j37, value2, value14, value15, jM5967copywmQWz5c$default3, value3, value16, value17, jM5967copywmQWz5c$default4, value4, value18, value19, jM5967copywmQWz5c$default5, value5, value20, value21, jM5967copywmQWz5c$default6, value6, value22, value23, jM5967copywmQWz5c$default7, value7, value24, value25, jM5967copywmQWz5c$default8, value26, composer, i15, ((i >> 24) & 126) | (i16 & 896) | (i16 & 7168) | (i16 & 57344) | (i16 & 458752) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), i18, ((i3 >> 24) & 126) | (i19 & 896) | (i19 & 7168) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (i19 & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM2890outlinedTextFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: textFieldColors-St-qZLY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2894textFieldColorsStqZLY(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, Composer composer, int i, int i2, int i3, int i4) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -2013303349, "C(textFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1080@59201L5,1082@59308L5,1085@59495L5,1086@59576L5,1087@59672L5,1088@59751L7,1090@59871L5,1092@59986L5,1094@60108L5,1098@60333L5,1100@60449L5,1101@60550L5,1103@60670L5,1107@60889L5,1109@61007L5,1111@61122L5,1113@61244L5,1117@61466L5,1118@61558L5,1119@61647L5,1120@61743L5,1121@61833L5,1122@61924L5,1124@62038L5,1160@63993L5,1161@64087L5,1163@64204L5,1166@64408L5,1167@64500L5,1168@64594L5,1170@64711L5,1173@64915L5,1128@62177L2754:ExposedDropdownMenu.kt#uh7d8r");
        long value = (i4 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j;
        long jM5967copywmQWz5c$default = (i4 & 2) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long value2 = (i4 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer, 6) : j3;
        long value3 = (i4 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j4;
        long value4 = (i4 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j5;
        if ((i4 & 32) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value5 = (i4 & 64) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer, 6) : j6;
        long value6 = (i4 & 128) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer, 6) : j7;
        long jM5967copywmQWz5c$default2 = (i4 & 256) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long value7 = (i4 & 512) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer, 6) : j9;
        long value8 = (i4 & 1024) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, 6) : j10;
        long value9 = (i4 & 2048) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, 6) : j11;
        long jM5967copywmQWz5c$default3 = (i4 & 4096) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j12;
        long value10 = (i4 & 8192) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6) : j13;
        long value11 = (i4 & 16384) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, 6) : j14;
        long value12 = (32768 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, 6) : j15;
        long jM5967copywmQWz5c$default4 = (65536 & i4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long value13 = (131072 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6) : j17;
        long value14 = (262144 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, 6) : j18;
        long value15 = (524288 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, 6) : j19;
        long value16 = (1048576 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, 6) : j20;
        long value17 = (2097152 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6) : j21;
        long value18 = (4194304 & i4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j22;
        long jM5967copywmQWz5c$default5 = (i4 & 8388608) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013303349, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:1128)");
        }
        int i5 = i << 3;
        int i6 = (i & 14) | (i5 & 112) | (i5 & 896);
        int i7 = i << 9;
        int i8 = i6 | (i7 & 7168) | ((i << 6) & 57344) | (i7 & 458752) | ((i << 12) & 3670016);
        int i9 = i << 15;
        int i10 = i8 | (i9 & 29360128) | (i9 & 234881024) | (i9 & 1879048192);
        int i11 = i2 << 15;
        int i12 = i3 << 15;
        int i13 = i3 << 18;
        int i14 = ((i2 >> 15) & 65534) | (i12 & 458752) | (i12 & 3670016) | (i12 & 29360128) | (i13 & 234881024) | (i13 & 1879048192);
        int i15 = ((i3 >> 6) & 14) | (i12 & 1879048192);
        long j24 = value;
        long j25 = value2;
        TextFieldColors textFieldColorsM2893textFieldColorsFD9MK7s = m2893textFieldColorsFD9MK7s(j24, value, jM5967copywmQWz5c$default, j24, j25, j25, j25, j25, value3, value4, textSelectionColors2, value5, value6, jM5967copywmQWz5c$default2, value7, value8, value9, jM5967copywmQWz5c$default3, value10, value11, value12, jM5967copywmQWz5c$default4, value13, value14, value15, value16, value17, value18, value18, jM5967copywmQWz5c$default5, value18, ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), composer, i10, ((i >> 15) & 65534) | (i11 & 458752) | (i11 & 3670016) | (i11 & 29360128) | (i11 & 234881024) | (i11 & 1879048192), i14, i15, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM2893textFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: outlinedTextFieldColors-St-qZLY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2891outlinedTextFieldColorsStqZLY(long j, long j2, long j3, long j4, long j5, TextSelectionColors textSelectionColors, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, Composer composer, int i, int i2, int i3, int i4) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -83147315, "C(outlinedTextFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1179@65144L5,1181@65253L5,1185@65488L5,1186@65586L5,1187@65665L7,1188@65764L5,1189@65858L5,1191@65971L5,1194@66169L5,1196@66287L5,1198@66402L5,1200@66524L5,1204@66747L5,1206@66867L5,1208@66984L5,1210@67108L5,1214@67334L5,1215@67428L5,1216@67519L5,1218@67629L5,1221@67822L5,1222@67915L5,1224@68031L5,1260@69972L5,1261@70066L5,1263@70183L5,1266@70387L5,1267@70479L5,1268@70573L5,1270@70690L5,1273@70894L5,1228@68172L2738:ExposedDropdownMenu.kt#uh7d8r");
        long value = (i4 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer, 6) : j;
        long jM5967copywmQWz5c$default = (i4 & 2) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6003getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.INSTANCE.m6003getTransparent0d7_KjU() : j3;
        long value2 = (i4 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer, 6) : j4;
        long value3 = (i4 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer, 6) : j5;
        if ((i4 & 32) != 0) {
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) objConsume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i4 & 64) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer, 6) : j6;
        long value5 = (i4 & 128) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer, 6) : j7;
        long jM5967copywmQWz5c$default2 = (i4 & 256) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long value6 = (i4 & 512) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer, 6) : j9;
        long value7 = (i4 & 1024) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer, 6) : j10;
        long value8 = (i4 & 2048) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer, 6) : j11;
        long jM5967copywmQWz5c$default3 = (i4 & 4096) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j12;
        long value9 = (i4 & 8192) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer, 6) : j13;
        long value10 = (i4 & 16384) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer, 6) : j14;
        long value11 = (32768 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer, 6) : j15;
        long jM5967copywmQWz5c$default4 = (65536 & i4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long value12 = (131072 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer, 6) : j17;
        long value13 = (262144 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer, 6) : j18;
        long value14 = (524288 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer, 6) : j19;
        long jM5967copywmQWz5c$default5 = (1048576 & i4) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long value15 = (2097152 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer, 6) : j21;
        long value16 = (4194304 & i4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6) : j22;
        long jM5967copywmQWz5c$default6 = (i4 & 8388608) != 0 ? Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-83147315, i, i2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:1228)");
        }
        int i5 = i << 3;
        int i6 = (i & 14) | (i5 & 112) | (i5 & 896);
        int i7 = i << 9;
        int i8 = i6 | (i7 & 7168) | ((i << 6) & 57344) | (i7 & 458752) | ((i << 12) & 3670016);
        int i9 = i << 15;
        int i10 = i8 | (i9 & 29360128) | (i9 & 234881024) | (i9 & 1879048192);
        int i11 = i2 << 15;
        int i12 = i3 << 15;
        int i13 = i3 << 18;
        int i14 = ((i2 >> 15) & 65534) | (i12 & 458752) | (i12 & 3670016) | (i12 & 29360128) | (i13 & 234881024) | (i13 & 1879048192);
        int i15 = ((i3 >> 6) & 14) | (i12 & 1879048192);
        long j24 = value;
        long j25 = jM6003getTransparent0d7_KjU;
        TextFieldColors textFieldColorsM2890outlinedTextFieldColorsFD9MK7s = m2890outlinedTextFieldColorsFD9MK7s(j24, value, jM5967copywmQWz5c$default, j24, j25, j25, j25, j25, value2, value3, textSelectionColors2, value4, value5, jM5967copywmQWz5c$default2, value6, value7, value8, jM5967copywmQWz5c$default3, value9, value10, value11, jM5967copywmQWz5c$default4, value12, value13, value14, jM5967copywmQWz5c$default5, value15, value16, value16, jM5967copywmQWz5c$default6, value16, ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), Color.m5967copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), composer, 6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer, 6), composer, i10, ((i >> 15) & 65534) | (i11 & 458752) | (i11 & 3670016) | (i11 & 29360128) | (i11 & 234881024) | (i11 & 1879048192), i14, i15, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textFieldColorsM2890outlinedTextFieldColorsFD9MK7s;
    }
}
