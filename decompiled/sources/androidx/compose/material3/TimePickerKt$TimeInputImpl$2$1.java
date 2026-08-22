package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.tokens.TimeInputTokens;
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
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class TimePickerKt$TimeInputImpl$2$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;
    final /* synthetic */ Ref<Boolean> $userOverride;

    TimePickerKt$TimeInputImpl$2$1(MutableState<TextFieldValue> mutableState, TimePickerState timePickerState, Ref<Boolean> ref, TimePickerColors timePickerColors, MutableState<TextFieldValue> mutableState2) {
        this.$hourValue$delegate = mutableState;
        this.$state = timePickerState;
        this.$userOverride = ref;
        this.$colors = timePickerColors;
        this.$minuteValue$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1032@43808L3645:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1306700887, i, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:1032)");
        }
        final MutableState<TextFieldValue> mutableState = this.$hourValue$delegate;
        final TimePickerState timePickerState = this.$state;
        final Ref<Boolean> ref = this.$userOverride;
        TimePickerColors timePickerColors = this.$colors;
        final MutableState<TextFieldValue> mutableState2 = this.$minuteValue$delegate;
        ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
        Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 587485559, "C1035@43926L529,1049@44532L508,1070@45481L52,1033@43830L1785,1074@45632L123,1079@45875L422,1091@46376L486,1112@47305L52,1077@45772L1667:TimePicker.kt#uh7d8r");
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1127329796, "CC(remember):TimePicker.kt#9igjgp");
        boolean zChanged = composer.changed(mutableState) | composer.changedInstance(timePickerState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$1$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m3772invokeZmokQxo(keyEvent.m7133unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m3772invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    int iM7146getUtf16CodePointZmokQxo = KeyEvent_androidKt.m7146getUtf16CodePointZmokQxo(keyEvent);
                    if (48 <= iM7146getUtf16CodePointZmokQxo && iM7146getUtf16CodePointZmokQxo < 58 && TextRange.m8273getStartimpl(TimePickerKt.TimeInputImpl$lambda$18(mutableState).getSelection()) == 2 && TimePickerKt.TimeInputImpl$lambda$18(mutableState).getText().length() == 2) {
                        timePickerState.mo2419setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI());
                    }
                    return false;
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion2, (Function1) objRememberedValue);
        TextFieldValue textFieldValueTimeInputImpl$lambda$18 = TimePickerKt.TimeInputImpl$lambda$18(mutableState);
        ComposerKt.sourceInformationMarkerStart(composer, 1127349167, "CC(remember):TimePicker.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(timePickerState) | composer.changed(mutableState) | composer.changedInstance(ref);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$3$lambda$2(timePickerState, ref, mutableState, (TextFieldValue) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function1 function1 = (Function1) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int iM3790getHouryecRtBI = TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI();
        KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8515getNumberPjHm6EE(), ImeAction.INSTANCE.m8461getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
        ComposerKt.sourceInformationMarkerStart(composer, 1127379079, "CC(remember):TimePicker.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(timePickerState);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$5$lambda$4(timePickerState, (KeyboardActionScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TimePickerKt.m3756TimePickerTextField1vLObsk(modifierOnKeyEvent, textFieldValueTimeInputImpl$lambda$18, function1, timePickerState, iM3790getHouryecRtBI, keyboardOptions, new KeyboardActions(null, null, (Function1) objRememberedValue3, null, null, null, 59, null), timePickerColors, composer, 24576, 0);
        TimePickerKt.DisplaySeparator(SizeKt.m1223sizeVpY3zN4(Modifier.INSTANCE, TimePickerKt.DisplaySeparatorWidth, TimeInputTokens.INSTANCE.m4870getPeriodSelectorContainerHeightD9Ej5fM()), composer, 6);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1127392057, "CC(remember):TimePicker.kt#9igjgp");
        boolean zChanged2 = composer.changed(mutableState2) | composer.changedInstance(timePickerState);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$1$4$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m3773invokeZmokQxo(keyEvent.m7133unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m3773invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    boolean z = KeyEvent_androidKt.m7146getUtf16CodePointZmokQxo(keyEvent) == 0 && TextRange.m8273getStartimpl(TimePickerKt.TimeInputImpl$lambda$22(mutableState2).getSelection()) == 0;
                    if (z) {
                        timePickerState.mo2419setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI());
                    }
                    return Boolean.valueOf(z);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(companion3, (Function1) objRememberedValue4);
        TextFieldValue textFieldValueTimeInputImpl$lambda$22 = TimePickerKt.TimeInputImpl$lambda$22(mutableState2);
        ComposerKt.sourceInformationMarkerStart(composer, 1127408153, "CC(remember):TimePicker.kt#9igjgp");
        boolean zChangedInstance3 = composer.changedInstance(timePickerState) | composer.changed(mutableState2) | composer.changedInstance(ref);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChangedInstance3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$9$lambda$8(timePickerState, ref, mutableState2, (TextFieldValue) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Function1 function12 = (Function1) objRememberedValue5;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int iM3791getMinuteyecRtBI = TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI();
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8515getNumberPjHm6EE(), ImeAction.INSTANCE.m8459getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
        ComposerKt.sourceInformationMarkerStart(composer, 1127437447, "CC(remember):TimePicker.kt#9igjgp");
        boolean zChangedInstance4 = composer.changedInstance(timePickerState);
        Object objRememberedValue6 = composer.rememberedValue();
        if (zChangedInstance4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$11$lambda$10(timePickerState, (KeyboardActionScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TimePickerKt.m3756TimePickerTextField1vLObsk(modifierOnPreviewKeyEvent, textFieldValueTimeInputImpl$lambda$22, function12, timePickerState, iM3791getMinuteyecRtBI, keyboardOptions2, new KeyboardActions(null, null, (Function1) objRememberedValue6, null, null, null, 59, null), timePickerColors, composer, 24576, 0);
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
    public static final Unit invoke$lambda$12$lambda$3$lambda$2(TimePickerState timePickerState, Ref ref, final MutableState mutableState, TextFieldValue textFieldValue) {
        TimePickerKt.m3766timeInputOnChange_K77t0(TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI(), timePickerState, textFieldValue, TimePickerKt.TimeInputImpl$lambda$18(mutableState), timePickerState.getIs24hour() ? 23 : 12, ref, new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$3$lambda$2$lambda$1(mutableState, (TextFieldValue) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$3$lambda$2$lambda$1(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$5$lambda$4(TimePickerState timePickerState, KeyboardActionScope keyboardActionScope) {
        timePickerState.mo2419setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$9$lambda$8(TimePickerState timePickerState, Ref ref, final MutableState mutableState, TextFieldValue textFieldValue) {
        TimePickerKt.m3766timeInputOnChange_K77t0(TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI(), timePickerState, textFieldValue, TimePickerKt.TimeInputImpl$lambda$22(mutableState), 59, ref, new Function1() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$2$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt$TimeInputImpl$2$1.invoke$lambda$12$lambda$9$lambda$8$lambda$7(mutableState, (TextFieldValue) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$9$lambda$8$lambda$7(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$11$lambda$10(TimePickerState timePickerState, KeyboardActionScope keyboardActionScope) {
        timePickerState.mo2419setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI());
        return Unit.INSTANCE;
    }
}
