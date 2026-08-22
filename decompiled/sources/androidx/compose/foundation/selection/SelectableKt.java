package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Selectable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\b\n\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\r\u001aO\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"selectable", "Landroidx/compose/ui/Modifier;", "selected", "", StreamManagement.Enabled.ELEMENT, "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "selectable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "selectable-O2vRcR0", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SelectableKt {
    /* JADX INFO: renamed from: selectable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1495selectableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1494selectableXHw0xAI(modifier, z, z2, role, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier selectable_XHw0xAI$lambda$1(boolean z, boolean z2, Role role, Function0 function0, Modifier modifier, Composer composer, int i) {
        MutableInteractionSource mutableInteractionSource;
        composer.startReplaceGroup(-2124609672);
        ComposerKt.sourceInformation(composer, "C82@3691L7:Selectable.kt#gro6r2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2124609672, i, -1, "androidx.compose.foundation.selection.selectable.<anonymous> (Selectable.kt:82)");
        }
        ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localIndication);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Indication indication = (Indication) objConsume;
        if (indication instanceof IndicationNodeFactory) {
            composer.startReplaceGroup(686451247);
            composer.endReplaceGroup();
            mutableInteractionSource = null;
        } else {
            composer.startReplaceGroup(686583865);
            ComposerKt.sourceInformation(composer, "91@4138L39");
            ComposerKt.sourceInformationMarkerStart(composer, -1640413313, "CC(remember):Selectable.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        Modifier modifierM1492selectableO2vRcR0 = m1492selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, indication, z2, role, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM1492selectableO2vRcR0;
    }

    /* JADX INFO: renamed from: selectable-oSLSa3U$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1497selectableoSLSa3U$default(Modifier modifier, boolean z, boolean z2, Role role, MutableInteractionSource mutableInteractionSource, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return m1496selectableoSLSa3U(modifier, z, z2, (i & 4) != 0 ? null : role, (i & 8) != 0 ? null : mutableInteractionSource, function0);
    }

    /* JADX INFO: renamed from: selectable-oSLSa3U, reason: not valid java name */
    public static final Modifier m1496selectableoSLSa3U(Modifier modifier, boolean z, boolean z2, Role role, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0) {
        return modifier.then(new SelectableElement(z, mutableInteractionSource, null, true, z2, role, function0, null));
    }

    /* JADX INFO: renamed from: selectable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1493selectableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m1492selectableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, function0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* JADX INFO: renamed from: selectable-XHw0xAI, reason: not valid java name */
    public static final /* synthetic */ Modifier m1494selectableXHw0xAI(Modifier modifier, final boolean z, final boolean z2, final Role role, final Function0 function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.selection.SelectableKt$selectable-XHw0xAI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("selectable");
                inspectorInfo.getProperties().set("selected", Boolean.valueOf(z));
                inspectorInfo.getProperties().set(StreamManagement.Enabled.ELEMENT, Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function0);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.foundation.selection.SelectableKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SelectableKt.selectable_XHw0xAI$lambda$1(z, z2, role, function0, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    /* JADX INFO: renamed from: selectable-O2vRcR0, reason: not valid java name */
    public static final Modifier m1492selectableO2vRcR0(Modifier modifier, final boolean z, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z2, final Role role, final Function0<Unit> function0) {
        SelectableElement selectableElementComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            selectableElementComposed$default = new SelectableElement(z, mutableInteractionSource, (IndicationNodeFactory) indication, false, z2, role, function0, null);
        } else if (indication == null) {
            selectableElementComposed$default = new SelectableElement(z, mutableInteractionSource, null, false, z2, role, function0, null);
        } else if (mutableInteractionSource != null) {
            selectableElementComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new SelectableElement(z, mutableInteractionSource, null, false, z2, role, function0, null));
        } else {
            selectableElementComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                    return invoke(modifier2, composer, num.intValue());
                }

                public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                    composer.startReplaceGroup(-1525724089);
                    ComposerKt.sourceInformation(composer, "C637@30530L39:Clickable.kt#71ulvw");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:637)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer, -1636999986, "CC(remember):Clickable.kt#9igjgp");
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new SelectableElement(z, mutableInteractionSource2, null, false, z2, role, function0, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(selectableElementComposed$default);
    }
}
