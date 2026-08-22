package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class DatePickerKt$DatePickerContent$2$4$2 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ CalendarMonth $displayedMonth;
    final /* synthetic */ long $displayedMonthMillis;
    final /* synthetic */ LazyListState $monthsListState;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;
    final /* synthetic */ IntRange $yearRange;

    DatePickerKt$DatePickerContent$2$4$2(long j, MutableState<Boolean> mutableState, CoroutineScope coroutineScope, LazyListState lazyListState, IntRange intRange, CalendarMonth calendarMonth, SelectableDates selectableDates, CalendarModel calendarModel, DatePickerColors datePickerColors) {
        this.$displayedMonthMillis = j;
        this.$yearPickerVisible$delegate = mutableState;
        this.$coroutineScope = coroutineScope;
        this.$monthsListState = lazyListState;
        this.$yearRange = intRange;
        this.$displayedMonth = calendarMonth;
        this.$selectableDates = selectableDates;
        this.$calendarModel = calendarModel;
        this.$colors = datePickerColors;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
        invoke(animatedVisibilityScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1632@75845L48,1633@75947L30,1633@75910L1888:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1193716082, i, -1, "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1632)");
        }
        Strings.Companion companion = Strings.INSTANCE;
        final String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_picker_year_picker_pane_title), composer, 0);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 404900432, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged = composer.changed(strM4145getString2EP1pXo);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2$4$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DatePickerKt$DatePickerContent$2$4$2.invoke$lambda$1$lambda$0(strM4145getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null);
        long j = this.$displayedMonthMillis;
        final MutableState<Boolean> mutableState = this.$yearPickerVisible$delegate;
        final CoroutineScope coroutineScope = this.$coroutineScope;
        final LazyListState lazyListState = this.$monthsListState;
        final IntRange intRange = this.$yearRange;
        final CalendarMonth calendarMonth = this.$displayedMonth;
        SelectableDates selectableDates = this.$selectableDates;
        CalendarModel calendarModel = this.$calendarModel;
        DatePickerColors datePickerColors = this.$colors;
        ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer);
        Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 872659188, "C1645@76721L767,1634@76001L1712,1662@77734L46:DatePicker.kt#uh7d8r");
        Modifier modifierM1153paddingVpY3zN4$default = PaddingKt.m1153paddingVpY3zN4$default(SizeKt.m1210requiredHeight3ABfNKs(Modifier.INSTANCE, Dp.m8830constructorimpl(Dp.m8830constructorimpl(DatePickerKt.getRecommendedSizeForAccessibility() * 7) - DividerDefaults.INSTANCE.m2844getThicknessD9Ej5fM())), DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, null);
        ComposerKt.sourceInformationMarkerStart(composer, -1357300997, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged2 = composer.changed(mutableState) | composer.changedInstance(coroutineScope) | composer.changed(lazyListState) | composer.changedInstance(intRange) | composer.changed(calendarMonth);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function1() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2$4$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DatePickerKt$DatePickerContent$2$4$2.invoke$lambda$4$lambda$3$lambda$2(coroutineScope, mutableState, lazyListState, intRange, calendarMonth, ((Integer) obj2).intValue());
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue2 = obj;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DatePickerKt.YearPicker(modifierM1153paddingVpY3zN4$default, j, (Function1) objRememberedValue2, selectableDates, calendarModel, intRange, datePickerColors, composer, 6);
        DividerKt.m2850HorizontalDivider9IZ8Weo(null, 0.0f, datePickerColors.getDividerColor(), composer, 0, 3);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(CoroutineScope coroutineScope, MutableState mutableState, LazyListState lazyListState, IntRange intRange, CalendarMonth calendarMonth, int i) {
        DatePickerKt.DatePickerContent$lambda$27(mutableState, !DatePickerKt.DatePickerContent$lambda$26(mutableState));
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DatePickerKt$DatePickerContent$2$4$2$2$1$1$1(lazyListState, i, intRange, calendarMonth, null), 3, null);
        return Unit.INSTANCE;
    }
}
