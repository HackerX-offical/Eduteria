package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.TooltipState;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.bouncycastle.apache.bzip2.BZip2Constants;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: BasicTooltip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0011\u001aP\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a^\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a,\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a:\u0010\u001f\u001a\u00020\n*\u00020\n2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0002\u001a+\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\u0010%\u001a&\u0010&\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020$H\u0001\u001a\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0(H\u0003¢\u0006\u0002\u0010)¨\u0006*"}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "onDismissRequest", "focusable", "", "enableUserInput", "hasAction", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WrappedAnchor", "forceKeyboardFocusable", "Landroidx/compose/runtime/MutableState;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/runtime/MutableState;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/material3/TooltipState;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineScope;ZLandroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "handleGestures", StreamManagement.Enabled.ELEMENT, "anchorSemantics", "label", "", "keyboardBehavior", "rememberBasicTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "BasicTooltipState", "rememberTouchExplorationOrSwitchAccessServiceState", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTooltipKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTooltipBox$lambda$5(PopupPositionProvider popupPositionProvider, Function2 function2, TooltipState tooltipState, Modifier modifier, Function0 function0, boolean z, boolean z2, boolean z3, Function2 function22, int i, int i2, Composer composer, int i3) {
        BasicTooltipBox(popupPositionProvider, function2, tooltipState, modifier, function0, z, z2, z3, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipPopup$lambda$10(PopupPositionProvider popupPositionProvider, TooltipState tooltipState, Function0 function0, CoroutineScope coroutineScope, boolean z, MutableState mutableState, Function2 function2, int i, Composer composer, int i2) {
        TooltipPopup(popupPositionProvider, tooltipState, function0, coroutineScope, z, mutableState, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrappedAnchor$lambda$7(boolean z, TooltipState tooltipState, MutableState mutableState, boolean z2, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        WrappedAnchor(z, tooltipState, mutableState, z2, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicTooltipBox(final androidx.compose.ui.window.PopupPositionProvider r22, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.material3.TooltipState r24, androidx.compose.ui.Modifier r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26, boolean r27, boolean r28, boolean r29, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt.BasicTooltipBox(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.material3.TooltipState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, boolean, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void WrappedAnchor(final boolean r14, final androidx.compose.material3.TooltipState r15, final androidx.compose.runtime.MutableState<java.lang.Boolean> r16, final boolean r17, androidx.compose.ui.Modifier r18, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt.WrappedAnchor(boolean, androidx.compose.material3.TooltipState, androidx.compose.runtime.MutableState, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void TooltipPopup(final PopupPositionProvider popupPositionProvider, final TooltipState tooltipState, final Function0<Unit> function0, final CoroutineScope coroutineScope, final boolean z, final MutableState<Boolean> mutableState, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1413720282);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipPopup)N(positionProvider,state,onDismissRequest,scope,focusable,forceKeyboardFocusable,content)170@7095L13,173@7197L382,185@7648L251,171@7113L786:BasicTooltip.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(coroutineScope) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1413720282, i2, -1, "androidx.compose.material3.internal.TooltipPopup (BasicTooltip.kt:169)");
            }
            String strDescription = BasicTooltipStrings.INSTANCE.description(composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1375511036, "CC(remember):BasicTooltip.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 896) == 256) | ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(tooltipState))) | composerStartRestartGroup.changedInstance(coroutineScope) | ((458752 & i2) == 131072);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicTooltipKt.TooltipPopup$lambda$9$lambda$8(function0, tooltipState, coroutineScope, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidPopup_androidKt.Popup(popupPositionProvider, (Function0) objRememberedValue, new PopupProperties(z, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1287705660, true, new AnonymousClass2(strDescription, function2), composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTooltipKt.TooltipPopup$lambda$10(popupPositionProvider, tooltipState, function0, coroutineScope, z, mutableState, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipPopup$lambda$9$lambda$8(Function0 function0, TooltipState tooltipState, CoroutineScope coroutineScope, MutableState mutableState) {
        if (function0 == null) {
            if (tooltipState.getIsVisible()) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BasicTooltipKt$TooltipPopup$1$1$1(tooltipState, null), 3, null);
                mutableState.setValue(false);
            }
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$TooltipPopup$2, reason: invalid class name */
    /* JADX INFO: compiled from: BasicTooltip.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ String $tooltipDescription;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, Function2<? super Composer, ? super Integer, Unit> function2) {
            this.$tooltipDescription = str;
            this.$content = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C188@7721L128,186@7658L235:BasicTooltip.kt#mqatfk");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1287705660, i, -1, "androidx.compose.material3.internal.TooltipPopup.<anonymous> (BasicTooltip.kt:186)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -534555548, "CC(remember):BasicTooltip.kt#9igjgp");
            boolean zChanged = composer.changed(this.$tooltipDescription);
            final String str = this.$tooltipDescription;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$TooltipPopup$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BasicTooltipKt.AnonymousClass2.invoke$lambda$1$lambda$0(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
            Function2<Composer, Integer, Unit> function2 = this.$content;
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1518074908, "C193@7874L9:BasicTooltip.kt#mqatfk");
            function2.invoke(composer, 0);
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
            SemanticsPropertiesKt.m8031setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8004getAssertive0phEisY());
            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
            return Unit.INSTANCE;
        }
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z, final TooltipState tooltipState) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, tooltipState, new PointerInputEventHandler() { // from class: androidx.compose.material3.internal.BasicTooltipKt.handleGestures.1

            /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: BasicTooltip.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1", f = "BasicTooltip.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
            static final class C00621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ TooltipState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00621(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation<? super C00621> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00621 c00621 = new C00621(this.$this_pointerInput, this.$state, continuation);
                    c00621.L$0 = obj;
                    return c00621;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: BasicTooltip.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1", f = "BasicTooltip.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {210, 216, 238}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "isLongPressedFlow", "pass", "longPressTimeout", "$this$awaitEachGesture", "isLongPressedFlow", "pass", "isLongPressedFlow"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$0"})
                static final class C00631 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ TooltipState $state;
                    long J$0;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00631(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation<? super C00631> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00631 c00631 = new C00631(this.$$this$coroutineScope, this.$state, continuation);
                        c00631.L$0 = obj;
                        return c00631;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00631) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ff, code lost:
                    
                        if (r3 == r0) goto L39;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
                    /* JADX WARN: Type inference failed for: r2v1 */
                    /* JADX WARN: Type inference failed for: r2v13, types: [kotlinx.coroutines.flow.MutableStateFlow] */
                    /* JADX WARN: Type inference failed for: r2v18 */
                    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.MutableStateFlow] */
                    /* JADX WARN: Type inference failed for: r2v23 */
                    /* JADX WARN: Type inference failed for: r2v24 */
                    /* JADX WARN: Type inference failed for: r2v8 */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
                        /*
                            Method dump skipped, instruction units count: 283
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt.AnonymousClass1.C00621.C00631.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$1", f = "BasicTooltip.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
                    static final class C00641 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                        final /* synthetic */ PointerEventPass $pass;
                        private /* synthetic */ Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00641(PointerEventPass pointerEventPass, Continuation<? super C00641> continuation) {
                            super(2, continuation);
                            this.$pass = pointerEventPass;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C00641 c00641 = new C00641(this.$pass, continuation);
                            c00641.L$0 = obj;
                            return c00641;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                            return ((C00641) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            Object objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation((AwaitPointerEventScope) this.L$0, this.$pass, this);
                            return objWaitForUpOrCancellation == coroutine_suspended ? coroutine_suspended : objWaitForUpOrCancellation;
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3, reason: invalid class name */
                    /* JADX INFO: compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3", f = "BasicTooltip.kt", i = {}, l = {224, 227, 227}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableStateFlow<Boolean> $isLongPressedFlow;
                        final /* synthetic */ TooltipState $state;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(MutableStateFlow<Boolean> mutableStateFlow, TooltipState tooltipState, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.$isLongPressedFlow = mutableStateFlow;
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass3(this.$isLongPressedFlow, this.$state, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
                        
                            if (kotlinx.coroutines.flow.FlowKt.collectLatest(r7.$isLongPressedFlow, new androidx.compose.material3.internal.BasicTooltipKt.AnonymousClass1.C00621.C00631.AnonymousClass3.C00651(r7.$state, null), r7) == r0) goto L30;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
                            /*
                                r7 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r7.label
                                r2 = 0
                                r3 = 3
                                r4 = 2
                                r5 = 1
                                if (r1 == 0) goto L2d
                                if (r1 == r5) goto L27
                                if (r1 == r4) goto L23
                                if (r1 == r3) goto L1a
                                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r8.<init>(r0)
                                throw r8
                            L1a:
                                java.lang.Object r0 = r7.L$0
                                java.lang.Throwable r0 = (java.lang.Throwable) r0
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L91
                            L23:
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L6a
                            L27:
                                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L2b
                                goto L49
                            L2b:
                                r8 = move-exception
                                goto L6d
                            L2d:
                                kotlin.ResultKt.throwOnFailure(r8)
                                kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r8 = r7.$isLongPressedFlow     // Catch: java.lang.Throwable -> L2b
                                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: java.lang.Throwable -> L2b
                                r8.tryEmit(r1)     // Catch: java.lang.Throwable -> L2b
                                androidx.compose.material3.TooltipState r8 = r7.$state     // Catch: java.lang.Throwable -> L2b
                                androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.PreventUserInput     // Catch: java.lang.Throwable -> L2b
                                r6 = r7
                                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L2b
                                r7.label = r5     // Catch: java.lang.Throwable -> L2b
                                java.lang.Object r8 = r8.show(r1, r6)     // Catch: java.lang.Throwable -> L2b
                                if (r8 != r0) goto L49
                                goto L8f
                            L49:
                                androidx.compose.material3.TooltipState r8 = r7.$state
                                boolean r8 = r8.getIsVisible()
                                if (r8 == 0) goto L6a
                                kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r8 = r7.$isLongPressedFlow
                                kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
                                androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1 r1 = new androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1
                                androidx.compose.material3.TooltipState r3 = r7.$state
                                r1.<init>(r3, r2)
                                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                                r2 = r7
                                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                r7.label = r4
                                java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.collectLatest(r8, r1, r2)
                                if (r8 != r0) goto L6a
                                goto L8f
                            L6a:
                                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                                return r8
                            L6d:
                                androidx.compose.material3.TooltipState r1 = r7.$state
                                boolean r1 = r1.getIsVisible()
                                if (r1 == 0) goto L92
                                kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r1 = r7.$isLongPressedFlow
                                kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
                                androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1 r4 = new androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1
                                androidx.compose.material3.TooltipState r5 = r7.$state
                                r4.<init>(r5, r2)
                                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                                r2 = r7
                                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                r7.L$0 = r8
                                r7.label = r3
                                java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.collectLatest(r1, r4, r2)
                                if (r1 != r0) goto L90
                            L8f:
                                return r0
                            L90:
                                r0 = r8
                            L91:
                                r8 = r0
                            L92:
                                throw r8
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt.AnonymousClass1.C00621.C00631.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: BasicTooltip.kt */
                        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isLongPressed", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1", f = "BasicTooltip.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        static final class C00651 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                            final /* synthetic */ TooltipState $state;
                            /* synthetic */ boolean Z$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00651(TooltipState tooltipState, Continuation<? super C00651> continuation) {
                                super(2, continuation);
                                this.$state = tooltipState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                C00651 c00651 = new C00651(this.$state, continuation);
                                c00651.Z$0 = ((Boolean) obj).booleanValue();
                                return c00651;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                                return invoke(bool.booleanValue(), continuation);
                            }

                            public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                                return ((C00651) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                if (!this.Z$0) {
                                    this.$state.dismiss();
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00631(coroutineScope, this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00621(pointerInputScope, tooltipState, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }), tooltipState, new PointerInputEventHandler() { // from class: androidx.compose.material3.internal.BasicTooltipKt.handleGestures.2

            /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: BasicTooltip.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1", f = "BasicTooltip.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ TooltipState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: BasicTooltip.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1", f = "BasicTooltip.kt", i = {0, 0}, l = {253}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "pass"}, s = {"L$0", "L$1"})
                static final class C00661 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ TooltipState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00661(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation<? super C00661> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00661 c00661 = new C00661(this.$$this$coroutineScope, this.$state, continuation);
                        c00661.L$0 = obj;
                        return c00661;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00661) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x0038 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:12:0x0039). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                        /*
                            r11 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r11.label
                            r2 = 1
                            if (r1 == 0) goto L1f
                            if (r1 != r2) goto L17
                            java.lang.Object r1 = r11.L$1
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                            java.lang.Object r3 = r11.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                            kotlin.ResultKt.throwOnFailure(r12)
                            goto L39
                        L17:
                            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r12.<init>(r0)
                            throw r12
                        L1f:
                            kotlin.ResultKt.throwOnFailure(r12)
                            java.lang.Object r12 = r11.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                            r3 = r12
                        L29:
                            r12 = r11
                            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                            r11.L$0 = r3
                            r11.L$1 = r1
                            r11.label = r2
                            java.lang.Object r12 = r3.awaitPointerEvent(r1, r12)
                            if (r12 != r0) goto L39
                            return r0
                        L39:
                            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
                            java.util.List r4 = r12.getChanges()
                            r5 = 0
                            java.lang.Object r4 = r4.get(r5)
                            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                            int r4 = r4.getType()
                            androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
                            int r5 = r5.m7390getMouseT8wyACA()
                            boolean r4 = androidx.compose.ui.input.pointer.PointerType.m7385equalsimpl0(r4, r5)
                            if (r4 == 0) goto L29
                            int r12 = r12.getType()
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                            int r4 = r4.m7256getEnter7fucELk()
                            boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m7252equalsimpl0(r12, r4)
                            if (r4 == 0) goto L7a
                            kotlinx.coroutines.CoroutineScope r5 = r11.$$this$coroutineScope
                            androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1$1 r12 = new androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1$1
                            androidx.compose.material3.TooltipState r4 = r11.$state
                            r6 = 0
                            r12.<init>(r4, r6)
                            r8 = r12
                            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                            r9 = 3
                            r10 = 0
                            r7 = 0
                            kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
                            goto L29
                        L7a:
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                            int r4 = r4.m7257getExit7fucELk()
                            boolean r12 = androidx.compose.ui.input.pointer.PointerEventType.m7252equalsimpl0(r12, r4)
                            if (r12 == 0) goto L29
                            androidx.compose.material3.TooltipState r12 = r11.$state
                            r12.dismiss()
                            goto L29
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt.C04152.AnonymousClass1.C00661.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1$1", f = "BasicTooltip.kt", i = {}, l = {BZip2Constants.MAX_ALPHA_SIZE}, m = "invokeSuspend", n = {}, s = {})
                    static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ TooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00671(TooltipState tooltipState, Continuation<? super C00671> continuation) {
                            super(2, continuation);
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00671(this.$state, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.show(MutatePriority.UserInput, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (this.$this_pointerInput.awaitPointerEventScope(new C00661(coroutineScope, this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipState, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }) : modifier;
    }

    private static final Modifier anchorSemantics(Modifier modifier, final String str, boolean z, final TooltipState tooltipState, final CoroutineScope coroutineScope) {
        return z ? ChildParentSemanticsKt.parentSemantics(modifier, new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BasicTooltipKt.anchorSemantics$lambda$12(str, coroutineScope, tooltipState, (SemanticsPropertyReceiver) obj);
            }
        }) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit anchorSemantics$lambda$12(String str, final CoroutineScope coroutineScope, final TooltipState tooltipState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, str, new Function0() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(BasicTooltipKt.anchorSemantics$lambda$12$lambda$11(coroutineScope, tooltipState));
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean anchorSemantics$lambda$12$lambda$11(CoroutineScope coroutineScope, TooltipState tooltipState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BasicTooltipKt$anchorSemantics$1$1$1(tooltipState, null), 3, null);
        return true;
    }

    private static final Modifier keyboardBehavior(Modifier modifier, boolean z, final TooltipState tooltipState, final CoroutineScope coroutineScope, final boolean z2, final MutableState<Boolean> mutableState) {
        if (z) {
            return KeyInputModifierKt.onPreviewKeyEvent(FocusChangedModifierKt.onFocusChanged(modifier, new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BasicTooltipKt.keyboardBehavior$lambda$13(coroutineScope, tooltipState, (FocusState) obj);
                }
            }), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.internal.BasicTooltipKt.keyboardBehavior.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m4050invokeZmokQxo(keyEvent.m7133unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m4050invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    if (!tooltipState.getIsVisible()) {
                        mutableState.setValue(false);
                    }
                    if (!z2 || !KeyEventType.m7137equalsimpl0(KeyEvent_androidKt.m7145getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7141getKeyDownCS__XNY()) || !Key.m6824equalsimpl0(KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent), Key.INSTANCE.m7072getTabEK5gGoQ()) || !tooltipState.getIsVisible()) {
                        return false;
                    }
                    mutableState.setValue(true);
                    return true;
                }
            });
        }
        mutableState.setValue(false);
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keyboardBehavior$lambda$13(CoroutineScope coroutineScope, TooltipState tooltipState, FocusState focusState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BasicTooltipKt$keyboardBehavior$1$1(focusState, tooltipState, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final TooltipState rememberBasicTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1483057531, "C(rememberBasicTooltipState)N(initialIsVisible,isPersistent,mutatorMutex)346@14311L216:BasicTooltip.kt#mqatfk");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1483057531, i, -1, "androidx.compose.material3.internal.rememberBasicTooltipState (BasicTooltip.kt:346)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 710862269, "CC(remember):BasicTooltip.kt#9igjgp");
        boolean z3 = ((((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(mutatorMutex)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new BasicTooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(objRememberedValue);
        }
        BasicTooltipStateImpl basicTooltipStateImpl = (BasicTooltipStateImpl) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return basicTooltipStateImpl;
    }

    public static /* synthetic */ TooltipState BasicTooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return BasicTooltipState(z, z2, mutatorMutex);
    }

    public static final TooltipState BasicTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new BasicTooltipStateImpl(z, z2, mutatorMutex);
    }

    private static final State<Boolean> rememberTouchExplorationOrSwitchAccessServiceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1960751094, "C(rememberTouchExplorationOrSwitchAccessServiceState)456@18433L170:BasicTooltip.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1960751094, i, -1, "androidx.compose.material3.internal.rememberTouchExplorationOrSwitchAccessServiceState (BasicTooltip.kt:456)");
        }
        State<Boolean> stateRememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(true, true, false, composer, 438, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateRememberAccessibilityServiceState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BasicTooltipBox$lambda$4$lambda$3(final TooltipState tooltipState, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.BasicTooltipKt$BasicTooltipBox$lambda$4$lambda$3$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                tooltipState.onDispose();
            }
        };
    }
}
