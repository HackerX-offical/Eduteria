package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: ContextMenuArea.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001aF\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"ContextMenuArea", "", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onDismiss", "Lkotlin/Function0;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "", "onOpenGesture", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ContextMenu", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ContextMenuAreaKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenu$lambda$0(ContextMenuState contextMenuState, Function0 function0, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        ContextMenu(contextMenuState, function0, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenu$lambda$2(ContextMenuState contextMenuState, Function0 function0, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        ContextMenu(contextMenuState, function0, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuArea$lambda$3(ContextMenuState contextMenuState, Function0 function0, Function1 function1, Modifier modifier, boolean z, Function0 function02, Function2 function2, int i, int i2, Composer composer, int i3) {
        ContextMenuArea(contextMenuState, function0, function1, modifier, z, function02, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ContextMenuArea(final androidx.compose.foundation.contextmenu.ContextMenuState r17, final kotlin.jvm.functions.Function0<kotlin.Unit> r18, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.contextmenu.ContextMenuScope, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, kotlin.jvm.functions.Function0<kotlin.Unit> r22, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuAreaKt.ContextMenuArea(androidx.compose.foundation.contextmenu.ContextMenuState, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuArea$lambda$1$0(Function0 function0, ContextMenuState contextMenuState, Offset offset) {
        function0.invoke();
        contextMenuState.setStatus(new ContextMenuState.Status.Open(offset.m5733unboximpl(), null));
        return Unit.INSTANCE;
    }

    public static final void ContextMenu(final ContextMenuState contextMenuState, final Function0<Unit> function0, Modifier modifier, final Function1<? super ContextMenuScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-195055274);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContextMenu)N(state,onDismiss,modifier,contextMenuBuilderBlock)78@2706L76,80@2788L197:ContextMenuArea.kt#3xeu6s");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(contextMenuState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-195055274, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenu (ContextMenuArea.kt:73)");
            }
            ContextMenuState.Status status = contextMenuState.getStatus();
            if (status instanceof ContextMenuState.Status.Open) {
                ContextMenuState.Status.Open open = (ContextMenuState.Status.Open) status;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1530451746, "CC(remember):ContextMenuArea.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(open);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    ContextMenuPopupPositionProvider contextMenuPopupPositionProvider = new ContextMenuPopupPositionProvider(IntOffsetKt.m8975roundk4lQ0M(open.getOffset()), (Function2) null, 2, (DefaultConstructorMarker) null);
                    composerStartRestartGroup.updateRememberedValue(contextMenuPopupPositionProvider);
                    objRememberedValue = contextMenuPopupPositionProvider;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                ContextMenuUiKt.ContextMenuPopup((ContextMenuPopupPositionProvider) objRememberedValue, function0, modifier2, function1, composer2, i3 & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    function2 = new Function2() { // from class: androidx.compose.foundation.contextmenu.ContextMenuAreaKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ContextMenuAreaKt.ContextMenu$lambda$0(contextMenuState, function0, modifier2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
                return;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: androidx.compose.foundation.contextmenu.ContextMenuAreaKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContextMenuAreaKt.ContextMenu$lambda$2(contextMenuState, function0, modifier2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }
}
