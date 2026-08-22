package androidx.compose.material3;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J\u008b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0004\b\"\u0010#J$\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+J+\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\bH\u0007¢\u0006\u0004\b5\u00106J=\u00107\u001a\u00020/2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u00100\u001a\u0002012\u0006\u0010(\u001a\u00020)2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\bH\u0007¢\u0006\u0004\b:\u0010;J'\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AH\u0001¢\u0006\u0004\bC\u0010DR\u0018\u0010$\u001a\u00020\u0005*\u00020%8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010I\u001a\u00020J¢\u0006\n\n\u0002\u0010M\u001a\u0004\bK\u0010LR\u0011\u0010N\u001a\u00020O8G¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010R\u001a\u00020S¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020+X\u0086T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "defaultDatePickerColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "DatePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "DatePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DatePickerHeadline", "selectedDateMillis", "", "DatePickerHeadline-ISIPfiY", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "YearMonthSkeleton", "YearAbbrMonthDaySkeleton", "YearMonthWeekdayDaySkeleton", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatePickerDefaults {
    public static final int $stable = 0;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final IntRange YearRange = new IntRange(1900, 2100);
    private static final float TonalElevation = ElevationTokens.INSTANCE.m4423getLevel0D9Ej5fM();
    private static final SelectableDates AllDates = new SelectableDates() { // from class: androidx.compose.material3.DatePickerDefaults$AllDates$1
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerHeadline_ISIPfiY$lambda$4(DatePickerDefaults datePickerDefaults, Long l, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        datePickerDefaults.m2749DatePickerHeadlineISIPfiY(l, i, datePickerFormatter, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerTitle_FNtVw6o$lambda$1(DatePickerDefaults datePickerDefaults, int i, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        datePickerDefaults.m2750DatePickerTitleFNtVw6o(i, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private DatePickerDefaults() {
    }

    public final DatePickerColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -275219611, "C(colors)447@19770L11,447@19782L23:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-275219611, i, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:447)");
        }
        DatePickerColors defaultDatePickerColors = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDatePickerColors;
    }

    /* JADX INFO: renamed from: colors-bSRYm20, reason: not valid java name */
    public final DatePickerColors m2751colorsbSRYm20(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, TextFieldColors textFieldColors, Composer composer, int i, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 1991626358, "C(colors)N(containerColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,headlineContentColor:c#ui.graphics.Color,weekdayContentColor:c#ui.graphics.Color,subheadContentColor:c#ui.graphics.Color,navigationContentColor:c#ui.graphics.Color,yearContentColor:c#ui.graphics.Color,disabledYearContentColor:c#ui.graphics.Color,currentYearContentColor:c#ui.graphics.Color,selectedYearContentColor:c#ui.graphics.Color,disabledSelectedYearContentColor:c#ui.graphics.Color,selectedYearContainerColor:c#ui.graphics.Color,disabledSelectedYearContainerColor:c#ui.graphics.Color,dayContentColor:c#ui.graphics.Color,disabledDayContentColor:c#ui.graphics.Color,selectedDayContentColor:c#ui.graphics.Color,disabledSelectedDayContentColor:c#ui.graphics.Color,selectedDayContainerColor:c#ui.graphics.Color,disabledSelectedDayContainerColor:c#ui.graphics.Color,todayContentColor:c#ui.graphics.Color,todayDateBorderColor:c#ui.graphics.Color,dayInSelectionRangeContentColor:c#ui.graphics.Color,dayInSelectionRangeContainerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color,dateTextFieldColors)516@24067L11,516@24079L23:DatePicker.kt#uh7d8r");
        long jM6004getUnspecified0d7_KjU = (i4 & 1) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        long jM6004getUnspecified0d7_KjU2 = (i4 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j2;
        long jM6004getUnspecified0d7_KjU3 = (i4 & 4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j3;
        long jM6004getUnspecified0d7_KjU4 = (i4 & 8) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j4;
        long jM6004getUnspecified0d7_KjU5 = (i4 & 16) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j5;
        long jM6004getUnspecified0d7_KjU6 = (i4 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j6;
        long jM6004getUnspecified0d7_KjU7 = (i4 & 64) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j7;
        long jM6004getUnspecified0d7_KjU8 = (i4 & 128) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j8;
        long jM6004getUnspecified0d7_KjU9 = (i4 & 256) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j9;
        long jM6004getUnspecified0d7_KjU10 = (i4 & 512) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j10;
        long jM6004getUnspecified0d7_KjU11 = (i4 & 1024) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j11;
        long jM6004getUnspecified0d7_KjU12 = (i4 & 2048) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j12;
        long jM6004getUnspecified0d7_KjU13 = (i4 & 4096) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j13;
        long jM6004getUnspecified0d7_KjU14 = (i4 & 8192) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j14;
        long jM6004getUnspecified0d7_KjU15 = (i4 & 16384) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j15;
        long jM6004getUnspecified0d7_KjU16 = (32768 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j16;
        long jM6004getUnspecified0d7_KjU17 = (65536 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j17;
        long jM6004getUnspecified0d7_KjU18 = (131072 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j18;
        long jM6004getUnspecified0d7_KjU19 = (262144 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j19;
        long jM6004getUnspecified0d7_KjU20 = (524288 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j20;
        long jM6004getUnspecified0d7_KjU21 = (1048576 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j21;
        long jM6004getUnspecified0d7_KjU22 = (2097152 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j22;
        long jM6004getUnspecified0d7_KjU23 = (4194304 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j23;
        long jM6004getUnspecified0d7_KjU24 = (8388608 & i4) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j24;
        TextFieldColors textFieldColors2 = (i4 & 16777216) != 0 ? null : textFieldColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1991626358, i, i2, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:516)");
        }
        DatePickerColors datePickerColorsM2722copytNwlRmA = getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i3 >> 12) & 112).m2722copytNwlRmA(jM6004getUnspecified0d7_KjU, jM6004getUnspecified0d7_KjU2, jM6004getUnspecified0d7_KjU3, jM6004getUnspecified0d7_KjU4, jM6004getUnspecified0d7_KjU5, jM6004getUnspecified0d7_KjU6, jM6004getUnspecified0d7_KjU7, jM6004getUnspecified0d7_KjU8, jM6004getUnspecified0d7_KjU9, jM6004getUnspecified0d7_KjU10, jM6004getUnspecified0d7_KjU11, jM6004getUnspecified0d7_KjU12, jM6004getUnspecified0d7_KjU13, jM6004getUnspecified0d7_KjU14, jM6004getUnspecified0d7_KjU15, jM6004getUnspecified0d7_KjU16, jM6004getUnspecified0d7_KjU17, jM6004getUnspecified0d7_KjU18, jM6004getUnspecified0d7_KjU19, jM6004getUnspecified0d7_KjU20, jM6004getUnspecified0d7_KjU21, jM6004getUnspecified0d7_KjU23, jM6004getUnspecified0d7_KjU22, jM6004getUnspecified0d7_KjU24, textFieldColors2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerColorsM2722copytNwlRmA;
    }

    public final DatePickerColors getDefaultDatePickerColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1180555308, "C(<get-defaultDatePickerColors>):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1180555308, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:546)");
        }
        DatePickerColors defaultDatePickerColorsCached = colorScheme.getDefaultDatePickerColorsCached();
        if (defaultDatePickerColorsCached != null) {
            composer.startReplaceGroup(642290457);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(642416503);
            ComposerKt.sourceInformation(composer, "604@29806L30");
            DatePickerColors datePickerColors = new DatePickerColors(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), colorScheme.getOnSurfaceVariant(), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), Color.m5967copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, DividerTokens.INSTANCE.getColor()), OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(colorScheme, composer, (i & 14) | 48), null);
            colorScheme.setDefaultDatePickerColorsCached$material3(datePickerColors);
            composer.endReplaceGroup();
            defaultDatePickerColorsCached = datePickerColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDatePickerColorsCached;
    }

    public static /* synthetic */ DatePickerFormatter dateFormatter$default(DatePickerDefaults datePickerDefaults, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = YearMonthSkeleton;
        }
        if ((i & 2) != 0) {
            str2 = YearAbbrMonthDaySkeleton;
        }
        if ((i & 4) != 0) {
            str3 = YearMonthWeekdayDaySkeleton;
        }
        return datePickerDefaults.dateFormatter(str, str2, str3);
    }

    public final DatePickerFormatter dateFormatter(String yearSelectionSkeleton, String selectedDateSkeleton, String selectedDateDescriptionSkeleton) {
        return new DatePickerFormatterImpl(yearSelectionSkeleton, selectedDateSkeleton, selectedDateDescriptionSkeleton);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DatePickerTitle-FNtVw6o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2750DatePickerTitleFNtVw6o(final int r34, androidx.compose.ui.Modifier r35, long r36, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDefaults.m2750DatePickerTitleFNtVw6o(int, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cb  */
    /* JADX INFO: renamed from: DatePickerHeadline-ISIPfiY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2749DatePickerHeadlineISIPfiY(java.lang.Long r37, final int r38, androidx.compose.material3.DatePickerFormatter r39, androidx.compose.ui.Modifier r40, long r41, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instruction units count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDefaults.m2749DatePickerHeadlineISIPfiY(java.lang.Long, int, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerHeadline_ISIPfiY$lambda$3$lambda$2(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8031setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8005getPolite0phEisY());
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2036003494, "C(rememberSnapFlingBehavior)N(lazyListState,decayAnimationSpec)743@35490L7,744@35513L639:DatePicker.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, i, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:741)");
        }
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, 1905742201, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(lazyListState)) || (i & 6) == 4) | composer.changed(decayAnimationSpec);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final SnapLayoutInfoProvider snapLayoutInfoProviderSnapLayoutInfoProvider$default = LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider$default(lazyListState, null, 2, null);
            objRememberedValue = SnapFlingBehaviorKt.snapFlingBehavior(new SnapLayoutInfoProvider() { // from class: androidx.compose.material3.DatePickerDefaults$rememberSnapFlingBehavior$1$snapLayoutInfoProvider$1
                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float calculateApproachOffset(float velocity, float decayOffset) {
                    return 0.0f;
                }

                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float calculateSnapOffset(float velocity) {
                    return snapLayoutInfoProviderSnapLayoutInfoProvider$default.calculateSnapOffset(velocity);
                }
            }, decayAnimationSpec, finiteAnimationSpecValue);
            composer.updateRememberedValue(objRememberedValue);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return targetedFlingBehavior;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m2752getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 700927667, "C(<get-shape>)770@36532L5:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:770)");
        }
        Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final SelectableDates getAllDates() {
        return AllDates;
    }
}
