package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Label.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0002\u0010\u000f\u001a%\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {TextFieldImplKt.LabelId, "", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPersistent", "", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "HandleInteractions", StreamManagement.Enabled.ELEMENT, "state", "Landroidx/compose/material3/TooltipState;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LabelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleInteractions$lambda$7(boolean z, TooltipState tooltipState, MutableInteractionSource mutableInteractionSource, int i, Composer composer, int i2) {
        HandleInteractions(z, tooltipState, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$5(Function3 function3, Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        Label(function3, modifier, mutableInteractionSource, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x020a  */
    /* JADX WARN: Type inference failed for: r8v17, types: [T, androidx.compose.runtime.MutableState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Label(final kotlin.jvm.functions.Function3<? super androidx.compose.material3.TooltipScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.interaction.MutableInteractionSource r23, boolean r24, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.LabelKt.Label(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates Label$lambda$4$lambda$3(Ref.ObjectRef objectRef) {
        return (LayoutCoordinates) ((MutableState) objectRef.element).getValue();
    }

    private static final void HandleInteractions(final boolean z, final TooltipState tooltipState, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-627258109);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HandleInteractions)N(enabled,state,interactionSource):Label.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
        }
        boolean z2 = false;
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627258109, i2, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(756598818);
                ComposerKt.sourceInformation(composerStartRestartGroup, "110@4434L587,110@4400L621");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499612882, "CC(remember):Label.kt#9igjgp");
                boolean z3 = (i2 & 896) == 256;
                if ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(tooltipState))) {
                    z2 = true;
                }
                boolean z4 = z3 | z2;
                LabelKt$HandleInteractions$1$1 labelKt$HandleInteractions$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4 || labelKt$HandleInteractions$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    labelKt$HandleInteractions$1$1RememberedValue = new LabelKt$HandleInteractions$1$1(mutableInteractionSource, tooltipState, null);
                    composerStartRestartGroup.updateRememberedValue(labelKt$HandleInteractions$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) labelKt$HandleInteractions$1$1RememberedValue, composerStartRestartGroup, (i2 >> 6) & 14);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(757210975);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LabelKt.HandleInteractions$lambda$7(z, tooltipState, mutableInteractionSource, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
