package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class DatePickerKt$YearPicker$1$1$1$1 implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ int $currentYear;
    final /* synthetic */ int $displayedYear;
    final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ IntRange $yearRange;

    /* JADX WARN: Multi-variable type inference failed */
    DatePickerKt$YearPicker$1$1$1$1(IntRange intRange, CalendarModel calendarModel, int i, int i2, Function1<? super Integer, Unit> function1, SelectableDates selectableDates, DatePickerColors datePickerColors) {
        this.$yearRange = intRange;
        this.$calendarModel = calendarModel;
        this.$displayedYear = i;
        this.$currentYear = i2;
        this.$onYearSelected = function1;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "CN(it)2099@95762L32,2103@95998L54,2090@95278L900:DatePicker.kt#uh7d8r");
        if ((i2 & 48) == 0) {
            i3 = i2 | (composer.changed(i) ? 32 : 16);
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 145) != 144, i3 & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(674613074, i3, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2088)");
        }
        final int first = i + this.$yearRange.getFirst();
        String localString$default = CalendarLocale_jvmKt.toLocalString$default(first, 0, 0, false, this.$calendarModel.getLocale(), 7, null);
        Modifier modifierM1215requiredSizeVpY3zN4 = SizeKt.m1215requiredSizeVpY3zN4(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m4390getSelectionYearContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m4389getSelectionYearContainerHeightD9Ej5fM());
        boolean z = first == this.$displayedYear;
        boolean z2 = first == this.$currentYear;
        ComposerKt.sourceInformationMarkerStart(composer, -236876686, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged = composer.changed(this.$onYearSelected) | composer.changed(first);
        final Function1<Integer, Unit> function1 = this.$onYearSelected;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$1$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DatePickerKt$YearPicker$1$1$1$1.invoke$lambda$1$lambda$0(function1, first);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zIsSelectableYear = this.$selectableDates.isSelectableYear(first);
        Strings.Companion companion = Strings.INSTANCE;
        String str = String.format(Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_picker_navigate_to_year_description), composer, 0), Arrays.copyOf(new Object[]{localString$default}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        DatePickerKt.Year(localString$default, modifierM1215requiredSizeVpY3zN4, z, z2, (Function0) objRememberedValue, zIsSelectableYear, str, this.$colors, composer, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, int i) {
        function1.invoke(Integer.valueOf(i));
        return Unit.INSTANCE;
    }
}
