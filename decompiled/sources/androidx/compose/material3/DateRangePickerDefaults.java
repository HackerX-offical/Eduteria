package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.android.exoplayer2.C;
import com.x5.template.ThemeConfig;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateRangePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJG\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0098\u0001\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0002\b\u001b2\n\u0010\u001e\u001a\u00060\u001fj\u0002` H\u0003¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "<init>", "()V", "DateRangePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "DateRangePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DateRangePickerHeadline", "selectedStartDateMillis", "", "selectedEndDateMillis", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "DateRangePickerHeadline-qS89cEg", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", ThemeConfig.LOCALE, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateRangePickerHeadline-nZrIstQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/util/Locale;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_nZrIstQ$lambda$5(DateRangePickerDefaults dateRangePickerDefaults, Long l, Long l2, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, String str, String str2, Function2 function2, Function2 function22, Function2 function23, Locale locale, int i2, int i3, Composer composer, int i4) {
        dateRangePickerDefaults.m2790DateRangePickerHeadlinenZrIstQ(l, l2, i, datePickerFormatter, modifier, j, str, str2, function2, function22, function23, locale, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_qS89cEg$lambda$1(DateRangePickerDefaults dateRangePickerDefaults, Long l, Long l2, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        dateRangePickerDefaults.m2791DateRangePickerHeadlineqS89cEg(l, l2, i, datePickerFormatter, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerTitle_FNtVw6o$lambda$0(DateRangePickerDefaults dateRangePickerDefaults, int i, Modifier modifier, long j, int i2, int i3, Composer composer, int i4) {
        dateRangePickerDefaults.m2792DateRangePickerTitleFNtVw6o(i, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private DateRangePickerDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DateRangePickerTitle-FNtVw6o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2792DateRangePickerTitleFNtVw6o(final int r34, androidx.compose.ui.Modifier r35, long r36, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.m2792DateRangePickerTitleFNtVw6o(int, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f2  */
    /* JADX INFO: renamed from: DateRangePickerHeadline-qS89cEg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2791DateRangePickerHeadlineqS89cEg(final java.lang.Long r18, final java.lang.Long r19, final int r20, final androidx.compose.material3.DatePickerFormatter r21, androidx.compose.ui.Modifier r22, long r23, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateRangePickerDefaults.m2791DateRangePickerHeadlineqS89cEg(java.lang.Long, java.lang.Long, int, androidx.compose.material3.DatePickerFormatter, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: DateRangePickerHeadline-nZrIstQ, reason: not valid java name */
    private final void m2790DateRangePickerHeadlinenZrIstQ(Long l, final Long l2, final int i, final DatePickerFormatter datePickerFormatter, final Modifier modifier, final long j, final String str, final String str2, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Locale locale, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Long l3;
        Composer composer2;
        String str3;
        String strM4145getString2EP1pXo;
        Composer composerStartRestartGroup = composer.startRestartGroup(1381313200);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerHeadline)N(selectedStartDateMillis,selectedEndDateMillis,displayMode:c#material3.DisplayMode,dateFormatter,modifier,contentColor:c#ui.graphics.Color,startDateText,endDateText,startDatePlaceholder,endDatePlaceholder,datesDelimiter,locale)504@23527L168,502@23453L792:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(l) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(l2) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= (i2 & 4096) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(str2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
        }
        int i6 = i4;
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changedInstance(function23) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(locale) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute(((i6 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i6 & 1)) {
            l3 = l;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1381313200, i6, i5, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:468)");
            }
            int i7 = i5;
            String date$default = DatePickerFormatter.formatDate$default(datePickerFormatter, l, locale, false, 4, null);
            l3 = l;
            String date$default2 = DatePickerFormatter.formatDate$default(datePickerFormatter, l2, locale, false, 4, null);
            String date = datePickerFormatter.formatDate(l3, locale, true);
            String str4 = "";
            if (date != null) {
                str3 = date$default2;
                composerStartRestartGroup.startReplaceGroup(297117483);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(620891895);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (DisplayMode.m2838equalsimpl0(i, DisplayMode.INSTANCE.m2843getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(297125251);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "482@22593L51");
                    Strings.Companion companion = Strings.INSTANCE;
                    str3 = date$default2;
                    date = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_picker_no_selection_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    str3 = date$default2;
                    if (DisplayMode.m2838equalsimpl0(i, DisplayMode.INSTANCE.m2842getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceGroup(297128222);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "483@22686L46");
                        Strings.Companion companion2 = Strings.INSTANCE;
                        String strM4145getString2EP1pXo2 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_input_no_input_description), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        date = strM4145getString2EP1pXo2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(621113326);
                        composerStartRestartGroup.endReplaceGroup();
                        date = "";
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            String date2 = datePickerFormatter.formatDate(l2, locale, true);
            if (date2 != null) {
                composerStartRestartGroup.startReplaceGroup(297133385);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(621382935);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (DisplayMode.m2838equalsimpl0(i, DisplayMode.INSTANCE.m2843getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(297141091);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "494@23088L51");
                    Strings.Companion companion3 = Strings.INSTANCE;
                    strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_picker_no_selection_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (DisplayMode.m2838equalsimpl0(i, DisplayMode.INSTANCE.m2842getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceGroup(297144062);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "495@23181L46");
                    Strings.Companion companion4 = Strings.INSTANCE;
                    strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_date_input_no_input_description), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(621604366);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                    date2 = str4;
                }
                str4 = strM4145getString2EP1pXo;
                composerStartRestartGroup.endReplaceGroup();
                date2 = str4;
            }
            final String str5 = str + ": " + date;
            final String str6 = str2 + ": " + date2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 297155256, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(str5) | composerStartRestartGroup.changed(str6);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DateRangePickerDefaults.DateRangePickerHeadline_nZrIstQ$lambda$3$lambda$2(str5, str6, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) objRememberedValue);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM825spacedBy0680j_4 = Arrangement.INSTANCE.m825spacedBy0680j_4(Dp.m8830constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM825spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClearAndSetSemantics);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -177408791, "C516@24035L16:DateRangePicker.kt#uh7d8r");
            if (date$default != null) {
                composerStartRestartGroup.startReplaceGroup(-177386503);
                ComposerKt.sourceInformation(composerStartRestartGroup, "512@23895L53");
                TextKt.m3703TextNvy7gAk(date$default, null, j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, (i6 >> 9) & 896, 0, 262138);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-177297192);
                ComposerKt.sourceInformation(composer2, "514@23986L22");
                function2.invoke(composer2, Integer.valueOf((i6 >> 24) & 14));
                composer2.endReplaceGroup();
            }
            function23.invoke(composer2, Integer.valueOf(i7 & 14));
            if (str3 != null) {
                composer2.startReplaceGroup(-177171301);
                ComposerKt.sourceInformation(composer2, "518@24112L51");
                TextKt.m3703TextNvy7gAk(str3, null, j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, (i6 >> 9) & 896, 0, 262138);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-177083974);
                ComposerKt.sourceInformation(composer2, "520@24201L20");
                function22.invoke(composer2, Integer.valueOf((i6 >> 27) & 14));
                composer2.endReplaceGroup();
            }
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
            final Long l4 = l3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DateRangePickerDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDefaults.DateRangePickerHeadline_nZrIstQ$lambda$5(this.f$0, l4, l2, i, datePickerFormatter, modifier, j, str, str2, function2, function22, function23, locale, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerHeadline_nZrIstQ$lambda$3$lambda$2(String str, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8031setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8005getPolite0phEisY());
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str + ", " + str2);
        return Unit.INSTANCE;
    }
}
