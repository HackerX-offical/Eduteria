package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.contextmenu.ContextMenuAreaKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuStateKt;
import androidx.compose.foundation.text.contextmenu.internal.PlatformDefaultTextContextMenuProviders_androidKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: compiled from: CommonContextMenuArea.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\f\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0004\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\tH\u0080@¢\u0006\u0002\u0010\u0018\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\u0003H\u0080@¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"CommonContextMenuArea", "", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", StreamManagement.Enabled.ELEMENT, "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/SelectionManager;", "(Landroidx/compose/foundation/text/selection/SelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextItem", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "label", "Landroidx/compose/foundation/text/TextContextMenuItems;", "operation", "getContextMenuItemsAvailability", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CommonContextMenuAreaKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CommonContextMenuAreaKt$getContextMenuItemsAvailability$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonContextMenuArea.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.CommonContextMenuAreaKt", f = "CommonContextMenuArea.kt", i = {0}, l = {200}, m = "getContextMenuItemsAvailability", n = {"$this$getContextMenuItemsAvailability"}, s = {"L$0"}, v = 1)
    static final class C03601 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03601(Continuation<? super C03601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonContextMenuAreaKt.getContextMenuItemsAvailability((TextFieldSelectionState) null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CommonContextMenuAreaKt$getContextMenuItemsAvailability$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommonContextMenuArea.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.CommonContextMenuAreaKt", f = "CommonContextMenuArea.kt", i = {0}, l = {212}, m = "getContextMenuItemsAvailability", n = {"$this$getContextMenuItemsAvailability"}, s = {"L$0"}, v = 1)
    static final class C03612 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C03612(Continuation<? super C03612> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommonContextMenuAreaKt.getContextMenuItemsAvailability((TextFieldSelectionManager) null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$11(TextFieldSelectionState textFieldSelectionState, boolean z, Function2 function2, int i, Composer composer, int i2) {
        CommonContextMenuArea(textFieldSelectionState, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$14(SelectionManager selectionManager, Function2 function2, int i, Composer composer, int i2) {
        CommonContextMenuArea(selectionManager, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$4(TextFieldSelectionManager textFieldSelectionManager, Function2 function2, int i, Composer composer, int i2) {
        CommonContextMenuArea(textFieldSelectionManager, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CommonContextMenuArea(final TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(1533506138);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonContextMenuArea)N(manager,content):CommonContextMenuArea.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1533506138, i2, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:46)");
            }
            if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                composerStartRestartGroup.startReplaceGroup(-885604480);
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@2238L88");
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(textFieldSelectionManager.getContextMenuAreaModifier(), function2, composerStartRestartGroup, i2 & 112, 0);
                composerStartRestartGroup.endReplaceGroup();
                function22 = function2;
            } else {
                composerStartRestartGroup.startReplaceGroup(-885475365);
                ComposerKt.sourceInformation(composerStartRestartGroup, "50@2360L31,51@2421L24,52@2482L55,56@2655L17,59@2837L202,54@2587L494");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 525625593, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ContextMenuState(null, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContextMenuState contextMenuState = (ContextMenuState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 525629521, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.m1792boximpl(MenuItemsAvailability.INSTANCE.m1805getNoneJKCFgKw()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 525635019, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$2$0(contextMenuState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function0 function0 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<ContextMenuScope, Unit> function1ContextMenuBuilder = TextFieldSelectionManagerKt.contextMenuBuilder(textFieldSelectionManager, contextMenuState, mutableState);
                boolean enabled = textFieldSelectionManager.getEnabled();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 525641028, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(textFieldSelectionManager);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$3$0(coroutineScope, mutableState, textFieldSelectionManager);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function22 = function2;
                ContextMenuAreaKt.ContextMenuArea(contextMenuState, function0, function1ContextMenuBuilder, null, enabled, (Function0) objRememberedValue5, function22, composerStartRestartGroup, ((i2 << 15) & 3670016) | 54, 8);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$4(textFieldSelectionManager, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$2$0(ContextMenuState contextMenuState) {
        ContextMenuStateKt.close(contextMenuState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$3$0(CoroutineScope coroutineScope, MutableState mutableState, TextFieldSelectionManager textFieldSelectionManager) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$2$1$1(mutableState, textFieldSelectionManager, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final void CommonContextMenuArea(final TextFieldSelectionState textFieldSelectionState, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Modifier.Companion companionShowTextContextMenuOnSecondaryClick;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1442752422);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonContextMenuArea)N(selectionState,enabled,content):CommonContextMenuArea.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            z2 = z;
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1442752422, i2, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:75)");
            }
            if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                composerStartRestartGroup.startReplaceGroup(-1299459355);
                ComposerKt.sourceInformation(composerStartRestartGroup, "92@4044L65");
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-1299415211);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "80@3501L456");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789370658, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionState);
                    CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1 commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1RememberedValue = new CommonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1(textFieldSelectionState, null);
                        composerStartRestartGroup.updateRememberedValue(commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionShowTextContextMenuOnSecondaryClick = TextContextMenuGesturesModifierKt.showTextContextMenuOnSecondaryClick(companion, (Function2) commonContextMenuAreaKt$CommonContextMenuArea$modifier$1$1RememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1298836224);
                    composerStartRestartGroup.endReplaceGroup();
                    companionShowTextContextMenuOnSecondaryClick = Modifier.INSTANCE;
                }
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(companionShowTextContextMenuOnSecondaryClick, function2, composerStartRestartGroup, (i2 >> 3) & 112, 0);
                composerStartRestartGroup.endReplaceGroup();
                z2 = z;
                function22 = function2;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1298667367);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4143L31,95@4204L24,96@4265L55,101@4520L537,116@5190L17,119@5319L209,114@5122L448");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789390777, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ContextMenuState(null, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContextMenuState contextMenuState = (ContextMenuState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789394705, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.m1792boximpl(MenuItemsAvailability.INSTANCE.m1805getNoneJKCFgKw()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                MutableState mutableState2 = mutableState;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789403347, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(coroutineScope);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function2() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$8$0(coroutineScope, (TextFieldSelectionState) obj, (TextContextMenuItems) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<ContextMenuScope, Unit> function1ContextMenuBuilder = TextFieldSelectionStateKt.contextMenuBuilder(textFieldSelectionState, contextMenuState, mutableState2, (Function2) objRememberedValue4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789424267, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$9$0(contextMenuState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function0 function0 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 789428587, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(textFieldSelectionState);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$10$0(coroutineScope, mutableState, textFieldSelectionState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                z2 = z;
                function22 = function2;
                ContextMenuAreaKt.ContextMenuArea(contextMenuState, function0, function1ContextMenuBuilder, null, z2, (Function0) objRememberedValue6, function22, composerStartRestartGroup, ((i2 << 9) & 57344) | 54 | ((i2 << 12) & 3670016), 8);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$11(textFieldSelectionState, z2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$8$0(CoroutineScope coroutineScope, TextFieldSelectionState textFieldSelectionState, TextContextMenuItems textContextMenuItems) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$menuBuilder$1$1$1(textContextMenuItems, textFieldSelectionState, null), 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$9$0(ContextMenuState contextMenuState) {
        ContextMenuStateKt.close(contextMenuState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$10$0(CoroutineScope coroutineScope, MutableState mutableState, TextFieldSelectionState textFieldSelectionState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new CommonContextMenuAreaKt$CommonContextMenuArea$5$1$1(mutableState, textFieldSelectionState, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final void CommonContextMenuArea(final SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(-614342087);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonContextMenuArea)N(manager,content):CommonContextMenuArea.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(selectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-614342087, i2, -1, "androidx.compose.foundation.text.CommonContextMenuArea (CommonContextMenuArea.kt:131)");
            }
            if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                composerStartRestartGroup.startReplaceGroup(-1009319487);
                ComposerKt.sourceInformation(composerStartRestartGroup, "133@5796L88");
                PlatformDefaultTextContextMenuProviders_androidKt.ProvideDefaultPlatformTextContextMenuProviders(selectionManager.getContextMenuAreaModifier(), function2, composerStartRestartGroup, i2 & 112, 0);
                composerStartRestartGroup.endReplaceGroup();
                function22 = function2;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1009204043);
                ComposerKt.sourceInformation(composerStartRestartGroup, "135@5918L31,138@6066L17,136@5998L200");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972217192, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ContextMenuState(null, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContextMenuState contextMenuState = (ContextMenuState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972212470, "CC(remember):CommonContextMenuArea.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$13$0(contextMenuState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function22 = function2;
                ContextMenuAreaKt.ContextMenuArea(contextMenuState, (Function0) objRememberedValue2, SelectionManagerKt.contextMenuBuilder(selectionManager, contextMenuState), null, false, null, function22, composerStartRestartGroup, ((i2 << 15) & 3670016) | 54, 56);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CommonContextMenuAreaKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonContextMenuAreaKt.CommonContextMenuArea$lambda$14(selectionManager, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonContextMenuArea$lambda$13$0(ContextMenuState contextMenuState) {
        ContextMenuStateKt.close(contextMenuState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CommonContextMenuAreaKt$TextItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommonContextMenuArea.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ByteCode.ARETURN)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, String> {
        final /* synthetic */ TextContextMenuItems $label;

        public AnonymousClass1(TextContextMenuItems textContextMenuItems) {
            this.$label = textContextMenuItems;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ String invoke(Composer composer, Integer num) {
            return invoke(composer, num.intValue());
        }

        public final String invoke(Composer composer, int i) {
            composer.startReplaceGroup(-35972707);
            ComposerKt.sourceInformation(composer, "C190@7736L16:CommonContextMenuArea.kt#423gt5");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-35972707, i, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (CommonContextMenuArea.kt:190)");
            }
            String strResolvedString = this.$label.resolvedString(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return strResolvedString;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CommonContextMenuAreaKt$TextItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: CommonContextMenuArea.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ByteCode.ARETURN)
    public static final class AnonymousClass2 implements Function0<Unit> {
        final /* synthetic */ Function0<Unit> $operation;
        final /* synthetic */ ContextMenuState $state;

        public AnonymousClass2(Function0<Unit> function0, ContextMenuState contextMenuState) {
            this.$operation = function0;
            this.$state = contextMenuState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$operation.invoke();
            ContextMenuStateKt.close(this.$state);
        }
    }

    public static final void TextItem(ContextMenuScope contextMenuScope, ContextMenuState contextMenuState, TextContextMenuItems textContextMenuItems, boolean z, Function0<Unit> function0) {
        if (z) {
            ContextMenuScope.item$default(contextMenuScope, new AnonymousClass1(textContextMenuItems), null, false, null, new AnonymousClass2(function0, contextMenuState), 14, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object getContextMenuItemsAvailability(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r4, kotlin.coroutines.Continuation<? super androidx.compose.foundation.text.MenuItemsAvailability> r5) {
        /*
            boolean r0 = r5 instanceof androidx.compose.foundation.text.CommonContextMenuAreaKt.C03601
            if (r0 == 0) goto L14
            r0 = r5
            androidx.compose.foundation.text.CommonContextMenuAreaKt$getContextMenuItemsAvailability$1 r0 = (androidx.compose.foundation.text.CommonContextMenuAreaKt.C03601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            androidx.compose.foundation.text.CommonContextMenuAreaKt$getContextMenuItemsAvailability$1 r0 = new androidx.compose.foundation.text.CommonContextMenuAreaKt$getContextMenuItemsAvailability$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r4 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.updateClipboardEntry(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            boolean r5 = r4.canShowCopyMenuItem()
            boolean r0 = r4.canShowPasteMenuItem()
            boolean r1 = r4.canShowCutMenuItem()
            boolean r2 = r4.canShowSelectAllMenuItem()
            boolean r4 = r4.canShowAutofillMenuItem()
            int r4 = androidx.compose.foundation.text.MenuItemsAvailability.m1794constructorimpl(r5, r0, r1, r2, r4)
            androidx.compose.foundation.text.MenuItemsAvailability r4 = androidx.compose.foundation.text.MenuItemsAvailability.m1792boximpl(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CommonContextMenuAreaKt.getContextMenuItemsAvailability(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object getContextMenuItemsAvailability(androidx.compose.foundation.text.selection.TextFieldSelectionManager r4, kotlin.coroutines.Continuation<? super androidx.compose.foundation.text.MenuItemsAvailability> r5) {
        /*
            boolean r0 = r5 instanceof androidx.compose.foundation.text.CommonContextMenuAreaKt.C03612
            if (r0 == 0) goto L14
            r0 = r5
            androidx.compose.foundation.text.CommonContextMenuAreaKt$getContextMenuItemsAvailability$2 r0 = (androidx.compose.foundation.text.CommonContextMenuAreaKt.C03612) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            androidx.compose.foundation.text.CommonContextMenuAreaKt$getContextMenuItemsAvailability$2 r0 = new androidx.compose.foundation.text.CommonContextMenuAreaKt$getContextMenuItemsAvailability$2
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r4 = (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.updateClipboardEntry$foundation(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            boolean r5 = r4.canShowCopyMenuItem$foundation()
            boolean r0 = r4.canShowPasteMenuItem$foundation()
            boolean r1 = r4.canShowCutMenuItem$foundation()
            boolean r2 = r4.canShowSelectAllMenuItem$foundation()
            boolean r4 = r4.canShowAutofillMenuItem$foundation()
            int r4 = androidx.compose.foundation.text.MenuItemsAvailability.m1794constructorimpl(r5, r0, r1, r2, r4)
            androidx.compose.foundation.text.MenuItemsAvailability r4 = androidx.compose.foundation.text.MenuItemsAvailability.m1792boximpl(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CommonContextMenuAreaKt.getContextMenuItemsAvailability(androidx.compose.foundation.text.selection.TextFieldSelectionManager, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
