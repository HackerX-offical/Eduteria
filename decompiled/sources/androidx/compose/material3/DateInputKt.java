package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.DateInputKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.x5.template.ThemeConfig;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DateInput.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001an\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032#\u0010\u0004\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001a\u009f\u0001\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060%j\u0002`&2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b'\u0010(\"\u0014\u0010)\u001a\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,\"\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u00060²\u0006\n\u00101\u001a\u000202X\u008a\u008e\u0002"}, d2 = {"DateInputContent", "", "selectedDateMillis", "", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "initialDateMillis", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", ThemeConfig.LOCALE, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateInputTextField-xJ3Ic0Y", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/internal/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "text", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding;
    private static final float InputTextNonErroneousBottomPadding = Dp.m8830constructorimpl(16);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateInputContent$lambda$3(Long l, Function1 function1, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, int i, Composer composer, int i2) {
        DateInputContent(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateInputTextField_xJ3Ic0Y$lambda$17(Modifier modifier, Long l, Function1 function1, CalendarModel calendarModel, Function2 function2, Function2 function22, int i, DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, DatePickerColors datePickerColors, FocusRequester focusRequester, int i2, int i3, Composer composer, int i4) {
        m2716DateInputTextFieldxJ3Ic0Y(modifier, l, function1, calendarModel, function2, function22, i, dateInputValidator, dateInputFormat, locale, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static final void DateInputContent(final Long l, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i) {
        int i2;
        IntRange intRange2;
        SelectableDates selectableDates2;
        Composer composer2;
        int i3;
        ?? r3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-432341251);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateInputContent)N(selectedDateMillis,onDateSelectionChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)70@2926L89,71@3043L45,72@3123L44,73@3201L45,75@3284L552,88@3925L42,92@4122L165,98@4311L62,89@3972L951:DateInput.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            intRange2 = intRange;
            i2 |= composerStartRestartGroup.changedInstance(intRange2) ? 2048 : 1024;
        } else {
            intRange2 = intRange;
        }
        if ((i & 24576) == 0) {
            i2 |= (i & 32768) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= composerStartRestartGroup.changed(selectableDates2) ? 131072 : 65536;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(focusRequester) ? 8388608 : 4194304;
        }
        if (!composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-432341251, i2, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:67)");
            }
            Locale locale = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1131899414, "CC(remember):DateInput.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(locale);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = calendarModel.getDateInputFormat(calendarModel.getLocale());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            DateInputFormat dateInputFormat = (DateInputFormat) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Strings.Companion companion = Strings.INSTANCE;
            String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_input_invalid_for_pattern), composerStartRestartGroup, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            String strM4145getString2EP1pXo2 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_input_invalid_year_range), composerStartRestartGroup, 0);
            Strings.Companion companion3 = Strings.INSTANCE;
            String strM4145getString2EP1pXo3 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_input_invalid_not_allowed), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1131911333, "CC(remember):DateInput.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(dateInputFormat) | ((57344 & i2) == 16384 || ((i2 & 32768) != 0 && composerStartRestartGroup.changed(datePickerFormatter)));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                i3 = i2;
                r3 = 1;
                DateInputValidator dateInputValidator = new DateInputValidator(intRange2, selectableDates2, dateInputFormat, datePickerFormatter, strM4145getString2EP1pXo, strM4145getString2EP1pXo2, strM4145getString2EP1pXo3, "");
                composerStartRestartGroup.updateRememberedValue(dateInputValidator);
                objRememberedValue2 = dateInputValidator;
            } else {
                i3 = i2;
                r3 = 1;
            }
            DateInputValidator dateInputValidator2 = (DateInputValidator) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            Strings.Companion companion4 = Strings.INSTANCE;
            String strM4145getString2EP1pXo4 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_input_label), composerStartRestartGroup, 0);
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, r3, null), InputTextFieldPadding);
            int iM3029getSingleDateInputJ2x2o4M = InputIdentifier.INSTANCE.m3029getSingleDateInputJ2x2o4M();
            dateInputValidator2.setCurrentStartDateMillis(l);
            Locale locale2 = calendarModel.getLocale();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-752164549, r3, new AnonymousClass2(strM4145getString2EP1pXo4, upperCase), composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1179434278, r3, new AnonymousClass3(upperCase), composerStartRestartGroup, 54);
            int i4 = i3 << 3;
            composer2 = composerStartRestartGroup;
            m2716DateInputTextFieldxJ3Ic0Y(modifierPadding, l, function1, calendarModel, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, iM3029getSingleDateInputJ2x2o4M, dateInputValidator2, dateInputFormat, locale2, datePickerColors, focusRequester, composer2, (i4 & 7168) | (i4 & 112) | 1794054 | (i4 & 896), (i3 >> 18) & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateInputKt.DateInputContent$lambda$3(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateInputKt$DateInputContent$2, reason: invalid class name */
    /* JADX INFO: compiled from: DateInput.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String $labelText;
        final /* synthetic */ String $pattern;

        AnonymousClass2(String str, String str2) {
            this.$labelText = str;
            this.$pattern = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C95@4215L47,93@4136L141:DateInput.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-752164549, i, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:93)");
            }
            String str = this.$labelText;
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1275622838, "CC(remember):DateInput.kt#9igjgp");
            boolean zChanged = composer.changed(this.$labelText) | composer.changed(this.$pattern);
            final String str2 = this.$labelText;
            final String str3 = this.$pattern;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateInputKt.AnonymousClass2.invoke$lambda$1$lambda$0(str2, str3, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3703TextNvy7gAk(str, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(String str, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str + ", " + str2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateInputKt$DateInputContent$3, reason: invalid class name */
    /* JADX INFO: compiled from: DateInput.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass3 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String $pattern;

        AnonymousClass3(String str) {
            this.$pattern = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C98@4368L2,98@4313L58:DateInput.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1179434278, i, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:98)");
            }
            String str = this.$pattern;
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 435026812, "CC(remember):DateInput.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateInputKt$DateInputContent$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateInputKt.AnonymousClass3.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3703TextNvy7gAk(str, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: DateInputTextField-xJ3Ic0Y, reason: not valid java name */
    public static final void m2716DateInputTextFieldxJ3Ic0Y(final Modifier modifier, Long l, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, final DateInputValidator dateInputValidator, final DateInputFormat dateInputFormat, final Locale locale, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Long l2;
        Composer composer2;
        int i6;
        int i7;
        MutableState mutableState;
        float fM8830constructorimpl;
        char c2;
        final DateInputFormat dateInputFormat2;
        int i8;
        Modifier.Companion companionFocusRequester;
        DateInputKt$DateInputTextField$5$1 dateInputKt$DateInputTextField$5$1;
        final CalendarModel calendarModel2 = calendarModel;
        final Locale locale2 = locale;
        Composer composerStartRestartGroup = composer.startRestartGroup(1456309913);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateInputTextField)N(modifier,initialDateMillis,onDateSelectionChange,calendarModel,label,placeholder,inputIdentifier:c#material3.InputIdentifier,dateInputValidator,dateInputFormat,locale,colors,focusRequester)130@5481L36,130@5429L88,132@5569L715,132@5546L738,164@6980L1604,205@8702L60,215@9086L59,162@6915L2641,228@9583L297,228@9562L318,237@9920L727,237@9886L761:DateInput.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(l) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(calendarModel2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(dateInputValidator) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(dateInputFormat) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(locale2) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(focusRequester) ? 32 : 16;
        }
        int i9 = i5;
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i9 & 19) == 18) ? false : true, i4 & 1)) {
            l2 = l;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1456309913, i4, i9, "androidx.compose.material3.DateInputTextField (DateInput.kt:128)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -645494339, "CC(remember):DateInput.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            int i10 = i4;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$5$lambda$4();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableStateRememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
            Object[] objArr2 = {DateInputTextField_xJ3Ic0Y$lambda$6(mutableStateRememberSaveable)};
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -645490844, "CC(remember):DateInput.kt#9igjgp");
            int i11 = i10 & 29360128;
            int i12 = i10 & 234881024;
            int i13 = i10 & 3670016;
            boolean zChanged = composerStartRestartGroup.changed(mutableStateRememberSaveable) | (i11 == 8388608) | composerStartRestartGroup.changedInstance(calendarModel2) | (i12 == 67108864) | composerStartRestartGroup.changedInstance(locale2) | (i13 == 1048576);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                i6 = i11;
                i7 = i10;
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$9$lambda$8(dateInputValidator, calendarModel2, dateInputFormat, locale2, i, mutableStateRememberSaveable);
                    }
                };
                mutableState = mutableStateRememberSaveable;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                mutableState = mutableStateRememberSaveable;
                i6 = i11;
                i7 = i10;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
            if (StringsKt.isBlank((CharSequence) mutableState2.getValue())) {
                fM8830constructorimpl = InputTextNonErroneousBottomPadding;
            } else {
                PaddingValues paddingValuesM3670supportingTextPaddinga9UjIt4$material3$default = TextFieldDefaults.m3670supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                fM8830constructorimpl = Dp.m8830constructorimpl(InputTextNonErroneousBottomPadding - Dp.m8830constructorimpl(paddingValuesM3670supportingTextPaddinga9UjIt4$material3$default.getBottom() + paddingValuesM3670supportingTextPaddinga9UjIt4$material3$default.getTop()));
            }
            float f2 = fM8830constructorimpl;
            TextFieldValue textFieldValueDateInputTextField_xJ3Ic0Y$lambda$6 = DateInputTextField_xJ3Ic0Y$lambda$6(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -645444803, "CC(remember):DateInput.kt#9igjgp");
            boolean zChanged2 = (i12 == 67108864) | composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(mutableState2) | ((i7 & 896) == 256) | composerStartRestartGroup.changedInstance(calendarModel2) | composerStartRestartGroup.changedInstance(locale2) | (i6 == 8388608) | (i13 == 1048576);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                c2 = 0;
                dateInputFormat2 = dateInputFormat;
                i8 = i7;
                final MutableState mutableState3 = mutableState;
                Function1 function12 = new Function1() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$12$lambda$11(dateInputFormat2, mutableState2, function1, calendarModel2, locale2, dateInputValidator, i, mutableState3, (TextFieldValue) obj);
                    }
                };
                calendarModel2 = calendarModel2;
                locale2 = locale2;
                mutableState = mutableState3;
                composerStartRestartGroup.updateRememberedValue(function12);
                objRememberedValue3 = function12;
            } else {
                dateInputFormat2 = dateInputFormat;
                c2 = 0;
                i8 = i7;
            }
            Function1 function13 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1155paddingqDBjuR0$default = PaddingKt.m1155paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, f2, 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -645391243, "CC(remember):DateInput.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(mutableState2);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$14$lambda$13(mutableState2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM1155paddingqDBjuR0$default, false, (Function1) objRememberedValue4, 1, null);
            if (focusRequester != null) {
                companionFocusRequester = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
            } else {
                companionFocusRequester = Modifier.INSTANCE;
            }
            OutlinedTextFieldKt.OutlinedTextField(textFieldValueDateInputTextField_xJ3Ic0Y$lambda$6, (Function1<? super TextFieldValue, Unit>) function13, modifierSemantics$default.then(companionFocusRequester), false, false, (TextStyle) null, function2, function22, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-357881838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i14) {
                    Composer composer4 = composer3;
                    ComposerKt.sourceInformation(composer4, "C:DateInput.kt#uh7d8r");
                    if (!composer4.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                        composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-357881838, i14, -1, "androidx.compose.material3.DateInputTextField.<anonymous> (DateInput.kt:215)");
                    }
                    if (StringsKt.isBlank(mutableState2.getValue())) {
                        composer4.startReplaceGroup(-1548950640);
                    } else {
                        composer4.startReplaceGroup(-327061465);
                        ComposerKt.sourceInformation(composer4, "215@9122L21");
                        TextKt.m3703TextNvy7gAk(mutableState2.getValue(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 262142);
                        composer4 = composer3;
                    }
                    composer4.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), !StringsKt.isBlank((CharSequence) mutableState2.getValue()), (VisualTransformation) new DateVisualTransformation(dateInputFormat2), new KeyboardOptions(0, (Boolean) false, KeyboardType.INSTANCE.m8515getNumberPjHm6EE(), ImeAction.INSTANCE.m8459getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 113, (DefaultConstructorMarker) null), (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, datePickerColors.getDateTextFieldColors(), composerStartRestartGroup, (i8 << 6) & 33030144, 12779904, 0, 4001592);
            composer2 = composerStartRestartGroup;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -645362814, "CC(remember):DateInput.kt#9igjgp");
            boolean z = (i9 & 112) == 32;
            DateInputKt$DateInputTextField$4$1 dateInputKt$DateInputTextField$4$1RememberedValue = composer2.rememberedValue();
            if (z || dateInputKt$DateInputTextField$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                dateInputKt$DateInputTextField$4$1RememberedValue = new DateInputKt$DateInputTextField$4$1(focusRequester, null);
                composer2.updateRememberedValue(dateInputKt$DateInputTextField$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dateInputKt$DateInputTextField$4$1RememberedValue, composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -645351600, "CC(remember):DateInput.kt#9igjgp");
            boolean zChangedInstance = ((i8 & 112) == 32) | composer2.changedInstance(calendarModel2) | (i12 == 67108864) | composer2.changedInstance(locale2) | composer2.changed(mutableState);
            Object objRememberedValue5 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                l2 = l;
                dateInputKt$DateInputTextField$5$1 = new DateInputKt$DateInputTextField$5$1(l2, calendarModel2, dateInputFormat2, locale, mutableState, null);
                composer2.updateRememberedValue(dateInputKt$DateInputTextField$5$1);
            } else {
                dateInputKt$DateInputTextField$5$1 = objRememberedValue5;
                l2 = l;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(l2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dateInputKt$DateInputTextField$5$1, composer2, (i8 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Long l3 = l2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateInputKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$17(modifier, l3, function1, calendarModel, function2, function22, i, dateInputValidator, dateInputFormat, locale, datePickerColors, focusRequester, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState DateInputTextField_xJ3Ic0Y$lambda$5$lambda$4() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
    }

    private static final TextFieldValue DateInputTextField_xJ3Ic0Y$lambda$6(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState DateInputTextField_xJ3Ic0Y$lambda$9$lambda$8(DateInputValidator dateInputValidator, CalendarModel calendarModel, DateInputFormat dateInputFormat, Locale locale, int i, MutableState mutableState) {
        String strM2719validateXivgLIo;
        if (DateInputTextField_xJ3Ic0Y$lambda$6(mutableState).getText().length() <= 0) {
            strM2719validateXivgLIo = "";
        } else {
            strM2719validateXivgLIo = dateInputValidator.m2719validateXivgLIo(calendarModel.parse(DateInputTextField_xJ3Ic0Y$lambda$6(mutableState).getText(), dateInputFormat.getPatternWithoutDelimiters(), locale), i, locale);
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(strM2719validateXivgLIo, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateInputTextField_xJ3Ic0Y$lambda$12$lambda$11(DateInputFormat dateInputFormat, MutableState mutableState, Function1 function1, CalendarModel calendarModel, Locale locale, DateInputValidator dateInputValidator, int i, MutableState mutableState2, TextFieldValue textFieldValue) {
        if (textFieldValue.getText().length() <= dateInputFormat.getPatternWithoutDelimiters().length()) {
            String text = textFieldValue.getText();
            int i2 = 0;
            while (true) {
                if (i2 < text.length()) {
                    if (!Character.isDigit(text.charAt(i2))) {
                        break;
                    }
                    i2++;
                } else {
                    mutableState2.setValue(textFieldValue);
                    String string = StringsKt.trim((CharSequence) textFieldValue.getText()).toString();
                    Long lValueOf = null;
                    if (string.length() == 0 || string.length() < dateInputFormat.getPatternWithoutDelimiters().length()) {
                        mutableState.setValue("");
                        function1.invoke(null);
                    } else {
                        CalendarDate calendarDate = calendarModel.parse(string, dateInputFormat.getPatternWithoutDelimiters(), locale);
                        mutableState.setValue(dateInputValidator.m2719validateXivgLIo(calendarDate, i, locale));
                        if (((CharSequence) mutableState.getValue()).length() == 0 && calendarDate != null) {
                            lValueOf = Long.valueOf(calendarDate.getUtcTimeMillis());
                        }
                        function1.invoke(lValueOf);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateInputTextField_xJ3Ic0Y$lambda$14$lambda$13(MutableState mutableState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!StringsKt.isBlank((CharSequence) mutableState.getValue())) {
            SemanticsPropertiesKt.error(semanticsPropertyReceiver, (String) mutableState.getValue());
        }
        return Unit.INSTANCE;
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }

    static {
        float f2 = 24;
        InputTextFieldPadding = PaddingKt.m1148PaddingValuesa9UjIt4$default(Dp.m8830constructorimpl(f2), Dp.m8830constructorimpl(10), Dp.m8830constructorimpl(f2), 0.0f, 8, null);
    }
}
