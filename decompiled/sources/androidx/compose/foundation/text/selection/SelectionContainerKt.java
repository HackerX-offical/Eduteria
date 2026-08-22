package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.ClipboardEventsHandler_jvmAndAndroidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: SelectionContainer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002"}, d2 = {"SelectionContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DisableSelection", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SelectionContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisableSelection$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        DisableSelection(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$11(Modifier modifier, Selection selection, Function1 function1, Function2 function2, int i, int i2, Composer composer, int i3) {
        SelectionContainer(modifier, selection, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$4(Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        SelectionContainer(modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SelectionContainer(final Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(1949207773);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionContainer)N(modifier,content)57@2606L45,61@2764L18,58@2656L161:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1949207773, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:56)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 582932362, "CC(remember):SelectionContainer.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = i3;
            Selection selectionSelectionContainer$lambda$1 = SelectionContainer$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 582937391, "CC(remember):SelectionContainer.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SelectionContainerKt.SelectionContainer$lambda$3$0(mutableState, (Selection) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = (i5 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i5 << 6) & 7168);
            Modifier modifier2 = modifier;
            function22 = function2;
            SelectionContainer(modifier2, selectionSelectionContainer$lambda$1, (Function1) objRememberedValue2, function22, composerStartRestartGroup, i6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectionContainerKt.SelectionContainer$lambda$4(modifier, function22, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$3$0(MutableState mutableState, Selection selection) {
        mutableState.setValue(selection);
        return Unit.INSTANCE;
    }

    public static final void DisableSelection(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1162635549);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisableSelection)N(content)74@3108L82:SelectionContainer.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162635549, i2, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:73)");
            }
            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null), function2, composerStartRestartGroup, ((i2 << 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectionContainerKt.DisableSelection$lambda$0(function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SelectionContainer(Modifier modifier, final Selection selection, final Function1<? super Selection, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Modifier.Companion companion;
        Composer composerStartRestartGroup = composer.startRestartGroup(-917932944);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionContainer)N(modifier,selection,onSelectionChange,children)95@3856L28,95@3801L83,97@3904L44,99@3985L7,100@4018L24,101@4092L7,103@4136L345,112@4525L7,123@4949L148,135@5475L2468,135@5418L2525,191@7975L106,191@7949L132:SelectionContainer.kt#eksfi3");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-917932944, i3, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:93)");
            }
            Object[] objArr = new Object[0];
            Saver<SelectionRegistrarImpl, Long> saver = SelectionRegistrarImpl.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1665249940, "CC(remember):SelectionContainer.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SelectionContainerKt.SelectionContainer$lambda$5$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1665248388, "CC(remember):SelectionContainer.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final SelectionManager selectionManager = (SelectionManager) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Clipboard> localClipboard = CompositionLocalsKt.getLocalClipboard();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localClipboard);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Clipboard clipboard = (Clipboard) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localHapticFeedback);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            selectionManager.setHapticFeedBack((HapticFeedback) objConsume2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1665240663, "CC(remember):SelectionContainer.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(coroutineScope) | composerStartRestartGroup.changed(clipboard);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = ClipboardUtils_androidKt.isWriteSupported(clipboard) ? new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SelectionContainerKt.SelectionContainer$lambda$7$0(coroutineScope, clipboard, (AnnotatedString) obj);
                    }
                } : null;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            selectionManager.setOnCopyHandler((Function1) objRememberedValue4);
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            selectionManager.setTextToolbar((TextToolbar) objConsume3);
            selectionManager.setOnSelectionChange(function1);
            selectionManager.setSelection(selection);
            if (ComposeFoundationFlags.isSmartSelectionEnabled) {
                composerStartRestartGroup.startReplaceGroup(-82280708);
                ComposerKt.sourceInformation(composerStartRestartGroup, "118@4777L69");
                selectionManager.setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.StaticText, null, composerStartRestartGroup, 54));
                selectionManager.setCoroutineScope$foundation(coroutineScope);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-82105806);
                composerStartRestartGroup.endReplaceGroup();
            }
            new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return selectionManager.getSelectedText$foundation();
                }
            };
            selectionManager.isNonEmptySelection$foundation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1264411026, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvmAndAndroid.kt#423gt5");
            ClipboardEventsHandler_jvmAndAndroidKt.AnonymousClass1 anonymousClass1 = ClipboardEventsHandler_jvmAndAndroidKt.AnonymousClass1.INSTANCE;
            ClipboardEventsHandler_jvmAndAndroidKt.AnonymousClass3 anonymousClass3 = ClipboardEventsHandler_jvmAndAndroidKt.AnonymousClass3.INSTANCE;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            selectionManager.setShouldIgnoreCopyKeyEvent$foundation(false);
            SimpleLayoutKt.SimpleLayout(companion.then(selectionManager.getModifier()), ComposableLambdaKt.rememberComposableLambda(-1799563674, true, new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectionContainerKt.SelectionContainer$lambda$9(selectionManager, selectionRegistrarImpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1665118054, "CC(remember):SelectionContainer.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(selectionManager);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SelectionContainerKt.SelectionContainer$lambda$10$0(selectionManager, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(selectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = companion;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectionContainerKt.SelectionContainer$lambda$11(modifier3, selection, function1, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SelectionRegistrarImpl SelectionContainer$lambda$5$0() {
        return new SelectionRegistrarImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$7$0(CoroutineScope coroutineScope, Clipboard clipboard, AnnotatedString annotatedString) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new SelectionContainerKt$SelectionContainer$3$1$1(clipboard, annotatedString, null), 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$9(final SelectionManager selectionManager, final SelectionRegistrarImpl selectionRegistrarImpl, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C136@5510L2427,136@5485L2452:SelectionContainer.kt#eksfi3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1799563674, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:136)");
            }
            ContextMenu_androidKt.ContextMenuArea(selectionManager, ComposableLambdaKt.rememberComposableLambda(-284825865, true, new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectionContainerKt.SelectionContainer$lambda$9$0(selectionRegistrarImpl, function2, selectionManager, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$9$0(SelectionRegistrarImpl selectionRegistrarImpl, final Function2 function2, final SelectionManager selectionManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C137@5597L2330,137@5524L2403:SelectionContainer.kt#eksfi3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-284825865, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:137)");
            }
            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(selectionRegistrarImpl), ComposableLambdaKt.rememberComposableLambda(610483127, true, new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelectionContainerKt.SelectionContainer$lambda$9$0$0(function2, selectionManager, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionContainer$lambda$9$0$0(Function2 function2, final SelectionManager selectionManager, Composer composer, int i) {
        Object obj;
        ResolvedTextDirection direction;
        float endHandleLineHeight;
        ComposerKt.sourceInformation(composer, "C138@5615L10:SelectionContainer.kt#eksfi3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(610483127, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:138)");
            }
            function2.invoke(composer, 0);
            if (selectionManager.isInTouchMode() && selectionManager.getHasFocus() && !selectionManager.isTriviallyCollapsedSelection$foundation()) {
                composer.startReplaceGroup(-1736224054);
                ComposerKt.sourceInformation(composer, "");
                Selection selection = selectionManager.getSelection();
                if (selection != null) {
                    composer.startReplaceGroup(2011629176);
                    ComposerKt.sourceInformation(composer, "");
                    composer.startReplaceGroup(-1736222526);
                    ComposerKt.sourceInformation(composer, "*147@6016L137,152@6252L385,180@7689L127,173@7251L596");
                    List listListOf = CollectionsKt.listOf((Object[]) new Boolean[]{true, false});
                    int size = listListOf.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        boolean zBooleanValue = ((Boolean) listListOf.get(i2)).booleanValue();
                        ComposerKt.sourceInformationMarkerStart(composer, -465225385, "CC(remember):SelectionContainer.kt#9igjgp");
                        boolean zChanged = composer.changed(zBooleanValue);
                        Object objRememberedValue = composer.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = selectionManager.handleDragObserver(zBooleanValue);
                            composer.updateRememberedValue(objRememberedValue);
                        }
                        final TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerStart(composer, -465217585, "CC(remember):SelectionContainer.kt#9igjgp");
                        boolean zChanged2 = composer.changed(zBooleanValue);
                        Object objRememberedValue2 = composer.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            if (zBooleanValue) {
                                obj = new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return SelectionContainerKt.SelectionContainer$lambda$9$0$0$0$0$1$0(selectionManager);
                                    }
                                };
                            } else {
                                obj = new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return SelectionContainerKt.SelectionContainer$lambda$9$0$0$0$0$1$1(selectionManager);
                                    }
                                };
                            }
                            objRememberedValue2 = obj;
                            composer.updateRememberedValue(objRememberedValue2);
                        }
                        Function0 function0 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (zBooleanValue) {
                            direction = selection.getStart().getDirection();
                        } else {
                            direction = selection.getEnd().getDirection();
                        }
                        if (zBooleanValue) {
                            endHandleLineHeight = selectionManager.getStartHandleLineHeight();
                        } else {
                            endHandleLineHeight = selectionManager.getEndHandleLineHeight();
                        }
                        float f2 = endHandleLineHeight;
                        SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 = new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(function0);
                        boolean handlesCrossed = selection.getHandlesCrossed();
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer, -465171859, "CC(remember):SelectionContainer.kt#9igjgp");
                        boolean zChangedInstance = composer.changedInstance(textDragObserver);
                        Object objRememberedValue3 = composer.rememberedValue();
                        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (PointerInputEventHandler) new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1
                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectDownAndDragGesturesWithObserver = LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(pointerInputScope, textDragObserver, continuation);
                                    return objDetectDownAndDragGesturesWithObserver == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDownAndDragGesturesWithObserver : Unit.INSTANCE;
                                }
                            };
                            composer.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        AndroidSelectionHandles_androidKt.m2271SelectionHandlewLIcFTc(selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0, zBooleanValue, direction, handlesCrossed, 0L, f2, SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) objRememberedValue3), composer, 0, 16);
                    }
                    composer.endReplaceGroup();
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(2011629175);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2013602667);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset SelectionContainer$lambda$9$0$0$0$0$1$0(SelectionManager selectionManager) {
        Offset offsetM2333getStartHandlePosition_m7T9E = selectionManager.m2333getStartHandlePosition_m7T9E();
        return Offset.m5712boximpl(offsetM2333getStartHandlePosition_m7T9E != null ? offsetM2333getStartHandlePosition_m7T9E.m5733unboximpl() : Offset.INSTANCE.m5738getUnspecifiedF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset SelectionContainer$lambda$9$0$0$0$0$1$1(SelectionManager selectionManager) {
        Offset offsetM2332getEndHandlePosition_m7T9E = selectionManager.m2332getEndHandlePosition_m7T9E();
        return Offset.m5712boximpl(offsetM2332getEndHandlePosition_m7T9E != null ? offsetM2332getEndHandlePosition_m7T9E.m5733unboximpl() : Offset.INSTANCE.m5738getUnspecifiedF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SelectionContainer$lambda$10$0(final SelectionManager selectionManager, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$lambda$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                selectionManager.onRelease();
                selectionManager.setHasFocus(false);
            }
        };
    }
}
