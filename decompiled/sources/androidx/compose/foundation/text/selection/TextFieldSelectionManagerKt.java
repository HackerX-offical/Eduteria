package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.internal.PlatformUtils_androidKt;
import androidx.compose.foundation.text.CommonContextMenuAreaKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000¨\u0006\u0019"}, d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "isSelectionHandleInVisibleBoundDefault", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "contextMenuState", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldSelectionManagerKt {

    /* JADX INFO: compiled from: TextFieldSelectionManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldSelectionHandle$lambda$3(boolean z, ResolvedTextDirection resolvedTextDirection, TextFieldSelectionManager textFieldSelectionManager, int i, Composer composer, int i2) {
        TextFieldSelectionHandle(z, resolvedTextDirection, textFieldSelectionManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void TextFieldSelectionHandle(final boolean z, final ResolvedTextDirection resolvedTextDirection, final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1344558920);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldSelectionHandle)N(isStartHandle,direction,manager)1366@58081L78,1369@58207L44,1375@58510L51,1368@58165L403:TextFieldSelectionManager.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(resolvedTextDirection.ordinal()) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1344558920, i2, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:1365)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 664039142, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChanged = (i3 == 4) | composerStartRestartGroup.changed(textFieldSelectionManager);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = textFieldSelectionManager.handleDragObserver$foundation(z);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 664043140, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(textFieldSelectionManager) | (i3 == 4);
            OffsetProvider offsetProviderRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || offsetProviderRememberedValue == Composer.INSTANCE.getEmpty()) {
                offsetProviderRememberedValue = new OffsetProvider() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1
                    @Override // androidx.compose.foundation.text.selection.OffsetProvider
                    /* JADX INFO: renamed from: provide-F1C5BW0 */
                    public final long mo1654provideF1C5BW0() {
                        return textFieldSelectionManager.m2370getHandlePositiontuRUvjQ$foundation(z);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(offsetProviderRememberedValue);
            }
            OffsetProvider offsetProvider = (OffsetProvider) offsetProviderRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zM8272getReversedimpl = TextRange.m8272getReversedimpl(textFieldSelectionManager.getValue$foundation().getSelection());
            float handleLineHeight$foundation = textFieldSelectionManager.getHandleLineHeight$foundation(z);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 664052843, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(textDragObserver);
            PointerInputEventHandler pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        Object objDetectDownAndDragGesturesWithObserver = LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(pointerInputScope, textDragObserver, continuation);
                        return objDetectDownAndDragGesturesWithObserver == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDownAndDragGesturesWithObserver : Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidSelectionHandles_androidKt.m2271SelectionHandlewLIcFTc(offsetProvider, z, resolvedTextDirection, zM8272getReversedimpl, 0L, handleLineHeight$foundation, SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), composerStartRestartGroup, (i2 << 3) & 1008, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldSelectionManagerKt.TextFieldSelectionHandle$lambda$3(z, resolvedTextDirection, textFieldSelectionManager, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final boolean isSelectionHandleInVisibleBoundDefault(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        LayoutCoordinates layoutCoordinates;
        Rect rectVisibleBounds;
        LegacyTextFieldState state = textFieldSelectionManager.getState();
        if (state == null || (layoutCoordinates = state.getLayoutCoordinates()) == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) == null) {
            return false;
        }
        return SelectionManagerKt.m2340containsInclusiveUv8p0NA(rectVisibleBounds, textFieldSelectionManager.m2370getHandlePositiontuRUvjQ$foundation(z));
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m2380calculateSelectionMagnifierCenterAndroidO0kMr_c(TextFieldSelectionManager textFieldSelectionManager, long j) {
        int iM8273getStartimpl;
        TextLayoutResultProxy layoutResult;
        TextDelegate textDelegate;
        AnnotatedString text;
        Offset offsetM2368getCurrentDragPosition_m7T9E = textFieldSelectionManager.m2368getCurrentDragPosition_m7T9E();
        if (offsetM2368getCurrentDragPosition_m7T9E == null) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        long jM5733unboximpl = offsetM2368getCurrentDragPosition_m7T9E.m5733unboximpl();
        AnnotatedString transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation();
        if (transformedText$foundation == null || transformedText$foundation.length() == 0) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = textFieldSelectionManager.getDraggingHandle();
        int i = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i == -1) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        if (i == 1 || i == 2) {
            iM8273getStartimpl = TextRange.m8273getStartimpl(textFieldSelectionManager.getValue$foundation().getSelection());
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            iM8273getStartimpl = TextRange.m8268getEndimpl(textFieldSelectionManager.getValue$foundation().getSelection());
        }
        LegacyTextFieldState state = textFieldSelectionManager.getState();
        if (state == null || (layoutResult = state.getLayoutResult()) == null) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        LegacyTextFieldState state2 = textFieldSelectionManager.getState();
        if (state2 == null || (textDelegate = state2.getTextDelegate()) == null || (text = textDelegate.getText()) == null) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        int iCoerceIn = RangesKt.coerceIn(textFieldSelectionManager.getOffsetMapping().originalToTransformed(iM8273getStartimpl), 0, text.length());
        float fIntBitsToFloat = Float.intBitsToFloat((int) (layoutResult.m1864translateDecorationToInnerCoordinatesMKHz9U$foundation(jM5733unboximpl) >> 32));
        TextLayoutResult value = layoutResult.getValue();
        int lineForOffset = value.getLineForOffset(iCoerceIn);
        float lineLeft = value.getLineLeft(lineForOffset);
        float lineRight = value.getLineRight(lineForOffset);
        float fCoerceIn = RangesKt.coerceIn(fIntBitsToFloat, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
        if (!IntSize.m8999equalsimpl0(j, IntSize.INSTANCE.m9006getZeroYbymL2g()) && Math.abs(fIntBitsToFloat - fCoerceIn) > ((int) (j >> 32)) / 2) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        float lineTop = value.getLineTop(lineForOffset);
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fCoerceIn)) << 32) | (((long) Float.floatToRawIntBits(((value.getLineBottom(lineForOffset) - lineTop) / 2) + lineTop)) & 4294967295L));
    }

    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionManager textFieldSelectionManager, final ContextMenuState contextMenuState, final State<MenuItemsAvailability> state) {
        return new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0(state, textFieldSelectionManager, contextMenuState, (ContextMenuScope) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$0(State state, final TextFieldSelectionManager textFieldSelectionManager, ContextMenuState contextMenuState, ContextMenuScope contextMenuScope) {
        int iM1804unboximpl = ((MenuItemsAvailability) state.getValue()).m1804unboximpl();
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, TextContextMenuItems.Cut, MenuItemsAvailability.m1799getCanCutimpl(iM1804unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$0(textFieldSelectionManager);
            }
        });
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, TextContextMenuItems.Copy, MenuItemsAvailability.m1798getCanCopyimpl(iM1804unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$1(textFieldSelectionManager);
            }
        });
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, TextContextMenuItems.Paste, MenuItemsAvailability.m1800getCanPasteimpl(iM1804unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$2(textFieldSelectionManager);
            }
        });
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, TextContextMenuItems.SelectAll, MenuItemsAvailability.m1801getCanSelectAllimpl(iM1804unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$3(textFieldSelectionManager);
            }
        });
        if (PlatformUtils_androidKt.isAutofillAvailable()) {
            contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, TextContextMenuItems.Autofill, MenuItemsAvailability.m1797getCanAutofillimpl(iM1804unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionManagerKt.contextMenuBuilder$lambda$0$4(textFieldSelectionManager);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$0$0(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.cut$foundation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$0$1(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.copy$foundation(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$0$2(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.paste$foundation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$0$3(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.selectAll$foundation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$0$4(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.autofill$foundation();
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$0$textFieldItem(ContextMenuScope contextMenuScope, ContextMenuState contextMenuState, TextContextMenuItems textContextMenuItems, boolean z, Function0<Unit> function0) {
        if (z) {
            ContextMenuScope.item$default(contextMenuScope, new CommonContextMenuAreaKt.AnonymousClass1(textContextMenuItems), null, false, null, new CommonContextMenuAreaKt.AnonymousClass2(function0, contextMenuState), 14, null);
        }
    }
}
