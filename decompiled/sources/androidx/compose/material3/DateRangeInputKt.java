package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DateRangeInput.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0002\u0010\u0017\"\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"DateRangeInputContent", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = Dp.m8830constructorimpl(8);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangeInputContent$lambda$8(Long l, Long l2, Function2 function2, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, int i, Composer composer, int i2) {
        DateRangeInputContent(l, l2, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DateRangeInputContent(final Long l, final Long l2, final Function2<? super Long, ? super Long, Unit> function2, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i) {
        int i2;
        IntRange intRange2;
        SelectableDates selectableDates2;
        final Function2<? super Long, ? super Long, Unit> function22;
        Composer composer2;
        String str;
        Object dateInputValidator;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1372713366);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangeInputContent)N(selectedStartDateMillis,selectedEndDateMillis,onDatesSelectionChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)47@1831L89,48@1948L45,49@2028L44,50@2106L45,51@2180L50,53@2268L531,70@3012L2615:DateRangeInput.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(l2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            intRange2 = intRange;
            i2 |= composerStartRestartGroup.changedInstance(intRange2) ? 16384 : 8192;
        } else {
            intRange2 = intRange;
        }
        if ((196608 & i) == 0) {
            i2 |= (i & 262144) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= composerStartRestartGroup.changed(selectableDates2) ? 1048576 : 524288;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i & 12582912) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changed(focusRequester) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 38347923) != 38347922, i2 & 1)) {
            function22 = function2;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1372713366, i2, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:44)");
            }
            Locale locale = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 622601007, "CC(remember):DateRangeInput.kt#9igjgp");
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
            Strings.Companion companion4 = Strings.INSTANCE;
            String strM4145getString2EP1pXo4 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_range_input_invalid_range_input), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 622615433, "CC(remember):DateRangeInput.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(dateInputFormat) | ((i2 & 458752) == 131072 || ((i2 & 262144) != 0 && composerStartRestartGroup.changed(datePickerFormatter)));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                str = "CC(remember):DateRangeInput.kt#9igjgp";
                i3 = i2;
                dateInputValidator = new DateInputValidator(intRange2, selectableDates2, dateInputFormat, datePickerFormatter, strM4145getString2EP1pXo, strM4145getString2EP1pXo2, strM4145getString2EP1pXo3, strM4145getString2EP1pXo4);
                dateInputFormat = dateInputFormat;
                composerStartRestartGroup.updateRememberedValue(dateInputValidator);
            } else {
                dateInputValidator = objRememberedValue2;
                i3 = i2;
                str = "CC(remember):DateRangeInput.kt#9igjgp";
            }
            DateInputValidator dateInputValidator2 = (DateInputValidator) dateInputValidator;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            dateInputValidator2.setCurrentStartDateMillis(l);
            dateInputValidator2.setCurrentEndDateMillis(l2);
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DateInputKt.getInputTextFieldPadding());
            Arrangement.HorizontalOrVertical horizontalOrVerticalM825spacedBy0680j_4 = Arrangement.INSTANCE.m825spacedBy0680j_4(TextFieldSpacing);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM825spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
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
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 34166529, "C75@3274L56,88@3872L203,79@3468L219,86@3715L62,76@3339L1026,99@4393L54,111@4959L199,103@4585L191,109@4804L62,100@4456L1165:DateRangeInput.kt#uh7d8r");
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            Strings.Companion companion5 = Strings.INSTANCE;
            String strM4145getString2EP1pXo5 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_range_picker_start_headline), composerStartRestartGroup, 0);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null);
            int iM3030getStartDateInputJ2x2o4M = InputIdentifier.INSTANCE.m3030getStartDateInputJ2x2o4M();
            Locale locale2 = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1122021, str);
            int i4 = i3 & 896;
            int i5 = i3 & 112;
            boolean z = (i4 == 256) | (i5 == 32);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.DateRangeInputKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangeInputKt.DateRangeInputContent$lambda$7$lambda$4$lambda$3(function2, l2, (Long) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = i3 & 7168;
            int i7 = i3 >> 21;
            int i8 = i7 & 14;
            String str2 = str;
            int i9 = i3;
            composer2 = composerStartRestartGroup;
            DateInputKt.m2716DateInputTextFieldxJ3Ic0Y(modifierWeight$default, l, (Function1) objRememberedValue3, calendarModel, ComposableLambdaKt.rememberComposableLambda(1740538748, true, new DateRangeInputKt$DateRangeInputContent$2$2(strM4145getString2EP1pXo5, upperCase), composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1229526589, true, new DateRangeInputKt$DateRangeInputContent$2$3(upperCase), composerStartRestartGroup, 54), iM3030getStartDateInputJ2x2o4M, dateInputValidator2, dateInputFormat, locale2, datePickerColors, focusRequester, composer2, ((i3 << 3) & 112) | 1794048 | i6, i7 & 126);
            Strings.Companion companion6 = Strings.INSTANCE;
            String strM4145getString2EP1pXo6 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_range_picker_end_headline), composer2, 0);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.5f, false, 2, null);
            int iM3028getEndDateInputJ2x2o4M = InputIdentifier.INSTANCE.m3028getEndDateInputJ2x2o4M();
            Locale locale3 = calendarModel.getLocale();
            ComposerKt.sourceInformationMarkerStart(composer2, 1156801, str2);
            boolean z2 = (i4 == 256) | ((i9 & 14) == 4);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (z2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                function22 = function2;
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.DateRangeInputKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangeInputKt.DateRangeInputContent$lambda$7$lambda$6$lambda$5(function22, l, (Long) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                function22 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            DateInputKt.m2716DateInputTextFieldxJ3Ic0Y(modifierWeight$default2, l2, (Function1) objRememberedValue4, calendarModel, ComposableLambdaKt.rememberComposableLambda(-882370893, true, new DateRangeInputKt$DateRangeInputContent$2$5(strM4145getString2EP1pXo6, upperCase), composer2, 54), ComposableLambdaKt.rememberComposableLambda(1956183348, true, new DateRangeInputKt$DateRangeInputContent$2$6(upperCase), composer2, 54), iM3028getEndDateInputJ2x2o4M, dateInputValidator2, dateInputFormat, locale3, datePickerColors, null, composer2, i5 | 1794048 | i6, i8 | 48);
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
            final Function2<? super Long, ? super Long, Unit> function23 = function22;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangeInputKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangeInputKt.DateRangeInputContent$lambda$8(l, l2, function23, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangeInputContent$lambda$7$lambda$4$lambda$3(Function2 function2, Long l, Long l2) {
        function2.invoke(l2, l);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangeInputContent$lambda$7$lambda$6$lambda$5(Function2 function2, Long l, Long l2) {
        function2.invoke(l, l2);
        return Unit.INSTANCE;
    }
}
