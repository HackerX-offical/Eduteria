package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u000b\u001aK\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000e\u001aS\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0011\u001a{\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u0017\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0018\u001aq\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u0019\u001a\u008d\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u001a\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u001b\u001aA\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001e\b\u0004\u0010\u001d\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u00010\u001eH\u0080\b\u001a\u0014\u0010(\u001a\u00020\u0003*\u00020)2\u0006\u0010*\u001a\u00020+H\u0000\u001a\u0014\u0010(\u001a\u00020\u0003*\u00020)2\u0006\u0010*\u001a\u00020,H\u0000\u001a\f\u0010-\u001a\u00020\u0003*\u00020.H\u0000\u001a\u0010\u0010/\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\f\u00100\u001a\u00020\u0003*\u00020+H\u0002\u001a\f\u00101\u001a\u00020\u0003*\u00020+H\u0002\"\u0018\u0010 \u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0018\u0010$\u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#\"\u0018\u0010&\u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#¨\u00062"}, d2 = {"clickable", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "clickable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "clickable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "combinedClickable-f5TDLPQ", "combinedClickable-hoGz1lA", "combinedClickable-cJG_KMw", "combinedClickable-auXiCPI", "combinedClickable-XVZzFYc", "clickableWithIndicationIfNeeded", "createClickable", "Lkotlin/Function2;", "Landroidx/compose/foundation/IndicationNodeFactory;", "isPress", "Landroidx/compose/ui/input/key/KeyEvent;", "isPress-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isClick", "isClick-ZmokQxo", "isEnter", "isEnter-ZmokQxo", "hasInterestedParent", "Landroidx/compose/ui/node/DelegatingNode;", "event", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "hasScrollableContainer", "Landroidx/compose/ui/node/TraversableNode;", "unsupportedIndicationExceptionMessage", "changedToUp", "changedToUpIgnoreConsumed", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ClickableKt {
    /* JADX INFO: renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m357clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m356clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier clickable_XHw0xAI$lambda$1(boolean z, String str, Role role, Function0 function0, Modifier modifier, Composer composer, int i) {
        MutableInteractionSource mutableInteractionSource;
        composer.startReplaceGroup(-756081143);
        ComposerKt.sourceInformation(composer, "C144@6863L7:Clickable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-756081143, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:144)");
        }
        ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localIndication);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Indication indication = (Indication) objConsume;
        if (indication instanceof IndicationNodeFactory) {
            composer.startReplaceGroup(-1604682242);
            composer.endReplaceGroup();
            mutableInteractionSource = null;
        } else {
            composer.startReplaceGroup(-1604549624);
            ComposerKt.sourceInformation(composer, "153@7310L39");
            ComposerKt.sourceInformationMarkerStart(composer, -744489520, "CC(remember):Clickable.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        Modifier modifierM354clickableO2vRcR0 = m354clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource, indication, z, str, role, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM354clickableO2vRcR0;
    }

    /* JADX INFO: renamed from: clickable-oSLSa3U$default, reason: not valid java name */
    public static /* synthetic */ Modifier m359clickableoSLSa3U$default(Modifier modifier, boolean z, String str, Role role, MutableInteractionSource mutableInteractionSource, Function0 function0, int i, Object obj) {
        MutableInteractionSource mutableInteractionSource2;
        Function0 function02;
        String str2;
        Role role2;
        Modifier modifier2;
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        if ((i & 8) != 0) {
            mutableInteractionSource2 = null;
            str2 = str;
            function02 = function0;
            modifier2 = modifier;
            role2 = role;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            function02 = function0;
            str2 = str;
            role2 = role;
            modifier2 = modifier;
        }
        return m358clickableoSLSa3U(modifier2, z, str2, role2, mutableInteractionSource2, function02);
    }

    /* JADX INFO: renamed from: clickable-oSLSa3U, reason: not valid java name */
    public static final Modifier m358clickableoSLSa3U(Modifier modifier, boolean z, String str, Role role, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0) {
        return modifier.then(new ClickableElement(mutableInteractionSource, null, true, z, str, role, function0, null));
    }

    /* JADX INFO: renamed from: clickable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m355clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return m354clickableO2vRcR0(modifier, mutableInteractionSource, indication, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, function0);
    }

    /* JADX INFO: renamed from: combinedClickable-f5TDLPQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m367combinedClickablef5TDLPQ$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, boolean z2, Function0 function03, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function0 = null;
        }
        if ((i & 32) != 0) {
            function02 = null;
        }
        if ((i & 64) != 0) {
            z2 = true;
        }
        return m366combinedClickablef5TDLPQ(modifier, z, str, role, str2, function0, function02, z2, function03);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier combinedClickable_f5TDLPQ$lambda$1(boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, boolean z2, Function0 function03, Modifier modifier, Composer composer, int i) {
        MutableInteractionSource mutableInteractionSource;
        composer.startReplaceGroup(-1534186401);
        ComposerKt.sourceInformation(composer, "C353@17168L7:Clickable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1534186401, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:353)");
        }
        ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localIndication);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Indication indication = (Indication) objConsume;
        if (indication instanceof IndicationNodeFactory) {
            composer.startReplaceGroup(2095040488);
            composer.endReplaceGroup();
            mutableInteractionSource = null;
        } else {
            composer.startReplaceGroup(2095173106);
            ComposerKt.sourceInformation(composer, "362@17615L39");
            ComposerKt.sourceInformationMarkerStart(composer, -1179332954, "CC(remember):Clickable.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        Modifier modifierM362combinedClickableauXiCPI = m362combinedClickableauXiCPI(Modifier.INSTANCE, mutableInteractionSource, indication, z, str, role, str2, function0, function02, z2, function03);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM362combinedClickableauXiCPI;
    }

    /* JADX INFO: renamed from: combinedClickable-hoGz1lA$default, reason: not valid java name */
    public static /* synthetic */ Modifier m369combinedClickablehoGz1lA$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, boolean z2, MutableInteractionSource mutableInteractionSource, Function0 function03, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function0 = null;
        }
        if ((i & 32) != 0) {
            function02 = null;
        }
        if ((i & 64) != 0) {
            z2 = true;
        }
        if ((i & 128) != 0) {
            mutableInteractionSource = null;
        }
        return m368combinedClickablehoGz1lA(modifier, z, str, role, str2, function0, function02, z2, mutableInteractionSource, function03);
    }

    /* JADX INFO: renamed from: combinedClickable-hoGz1lA, reason: not valid java name */
    public static final Modifier m368combinedClickablehoGz1lA(Modifier modifier, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02, boolean z2, MutableInteractionSource mutableInteractionSource, Function0<Unit> function03) {
        return modifier.then(new CombinedClickableElement(mutableInteractionSource, null, true, z, str, role, function03, str2, function0, function02, z2, null));
    }

    /* JADX INFO: renamed from: combinedClickable-cJG_KMw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m365combinedClickablecJG_KMw$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Function0 function04;
        Function0 function05;
        String str3;
        Function0 function06;
        String str4;
        Role role2;
        Modifier modifier2;
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function0 = null;
        }
        if ((i & 32) != 0) {
            function04 = null;
            str3 = str2;
            function05 = function03;
            str4 = str;
            function06 = function0;
            modifier2 = modifier;
            role2 = role;
        } else {
            function04 = function02;
            function05 = function03;
            str3 = str2;
            function06 = function0;
            str4 = str;
            role2 = role;
            modifier2 = modifier;
        }
        return m364combinedClickablecJG_KMw(modifier2, z, str4, role2, str3, function06, function04, function05);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier combinedClickable_cJG_KMw$lambda$1(boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, Modifier modifier, Composer composer, int i) {
        MutableInteractionSource mutableInteractionSource;
        composer.startReplaceGroup(1969174843);
        ComposerKt.sourceInformation(composer, "C474@22818L7:Clickable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1969174843, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:474)");
        }
        ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localIndication);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Indication indication = (Indication) objConsume;
        if (indication instanceof IndicationNodeFactory) {
            composer.startReplaceGroup(-1270399604);
            composer.endReplaceGroup();
            mutableInteractionSource = null;
        } else {
            composer.startReplaceGroup(-1270266986);
            ComposerKt.sourceInformation(composer, "483@23265L39");
            ComposerKt.sourceInformationMarkerStart(composer, -1703537534, "CC(remember):Clickable.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        Modifier modifierM362combinedClickableauXiCPI = m362combinedClickableauXiCPI(Modifier.INSTANCE, mutableInteractionSource, indication, z, str, role, str2, function0, function02, true, function03);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM362combinedClickableauXiCPI;
    }

    /* JADX INFO: renamed from: combinedClickable-auXiCPI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m363combinedClickableauXiCPI$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, boolean z2, Function0 function03, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            role = null;
        }
        if ((i & 32) != 0) {
            str2 = null;
        }
        if ((i & 64) != 0) {
            function0 = null;
        }
        if ((i & 128) != 0) {
            function02 = null;
        }
        if ((i & 256) != 0) {
            z2 = true;
        }
        return m362combinedClickableauXiCPI(modifier, mutableInteractionSource, indication, z, str, role, str2, function0, function02, z2, function03);
    }

    /* JADX INFO: renamed from: combinedClickable-XVZzFYc$default, reason: not valid java name */
    public static /* synthetic */ Modifier m361combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        Function0 function04;
        Modifier modifier2;
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        Function0 function05;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        String str3 = (i & 8) != 0 ? null : str;
        Role role2 = (i & 16) != 0 ? null : role;
        String str4 = (i & 32) != 0 ? null : str2;
        Function0 function06 = (i & 64) != 0 ? null : function0;
        if ((i & 128) != 0) {
            function04 = null;
            modifier2 = modifier;
            indication2 = indication;
            function05 = function03;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            function04 = function02;
            modifier2 = modifier;
            mutableInteractionSource2 = mutableInteractionSource;
            indication2 = indication;
            function05 = function03;
        }
        return m360combinedClickableXVZzFYc(modifier2, mutableInteractionSource2, indication2, z2, str3, role2, str4, function06, function04, function05);
    }

    public static final Modifier clickableWithIndicationIfNeeded(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final Function2<? super MutableInteractionSource, ? super IndicationNodeFactory, ? extends Modifier> function2) {
        Modifier modifierComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            modifierComposed$default = function2.invoke(mutableInteractionSource, indication);
        } else if (indication == null) {
            modifierComposed$default = function2.invoke(mutableInteractionSource, null);
        } else if (mutableInteractionSource != null) {
            modifierComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(function2.invoke(mutableInteractionSource, null));
        } else {
            modifierComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt.clickableWithIndicationIfNeeded.1
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
                    Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(function2.invoke(mutableInteractionSource2, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(modifierComposed$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m372isPressZmokQxo(KeyEvent keyEvent) {
        return KeyEventType.m7137equalsimpl0(KeyEvent_androidKt.m7145getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7141getKeyDownCS__XNY()) && m371isEnterZmokQxo(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m370isClickZmokQxo(KeyEvent keyEvent) {
        return KeyEventType.m7137equalsimpl0(KeyEvent_androidKt.m7145getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7142getKeyUpCS__XNY()) && m371isEnterZmokQxo(keyEvent);
    }

    /* JADX INFO: renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m371isEnterZmokQxo(KeyEvent keyEvent) {
        long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent);
        return Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6897getDirectionCenterEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6911getEnterEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7008getNumPadEnterEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7059getSpacebarEK5gGoQ());
    }

    public static final boolean hasInterestedParent(DelegatingNode delegatingNode, final IndirectPointerInputChange indirectPointerInputChange) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        GestureNodeKt.traverseAncestorGestureConnections(delegatingNode, new Function1() { // from class: androidx.compose.foundation.ClickableKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ClickableKt.hasInterestedParent$lambda$0(indirectPointerInputChange, booleanRef, (GestureConnection) obj));
            }
        });
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasInterestedParent$lambda$0(IndirectPointerInputChange indirectPointerInputChange, Ref.BooleanRef booleanRef, GestureConnection gestureConnection) {
        booleanRef.element = booleanRef.element || gestureConnection.isInterested(indirectPointerInputChange);
        return !booleanRef.element;
    }

    public static final boolean hasInterestedParent(DelegatingNode delegatingNode, final PointerInputChange pointerInputChange) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        GestureNodeKt.traverseAncestorGestureConnections(delegatingNode, new Function1() { // from class: androidx.compose.foundation.ClickableKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ClickableKt.hasInterestedParent$lambda$1(pointerInputChange, booleanRef, (GestureConnection) obj));
            }
        });
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasInterestedParent$lambda$1(PointerInputChange pointerInputChange, Ref.BooleanRef booleanRef, GestureConnection gestureConnection) {
        booleanRef.element = booleanRef.element || gestureConnection.isInterested(pointerInputChange);
        return !booleanRef.element;
    }

    public static final boolean hasScrollableContainer(TraversableNode traversableNode) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TraversableNodeKt.traverseAncestors(traversableNode, ScrollableContainerNode.INSTANCE, new Function1() { // from class: androidx.compose.foundation.ClickableKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ClickableKt.hasScrollableContainer$lambda$0(booleanRef, (TraversableNode) obj));
            }
        });
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean hasScrollableContainer$lambda$0(kotlin.jvm.internal.Ref.BooleanRef r2, androidx.compose.ui.node.TraversableNode r3) {
        /*
            boolean r0 = r2.element
            r1 = 1
            if (r0 != 0) goto L15
            java.lang.String r0 = "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r0)
            androidx.compose.foundation.gestures.ScrollableContainerNode r3 = (androidx.compose.foundation.gestures.ScrollableContainerNode) r3
            boolean r3 = r3.getEnabled()
            if (r3 == 0) goto L13
            goto L15
        L13:
            r3 = 0
            goto L16
        L15:
            r3 = r1
        L16:
            r2.element = r3
            boolean r2 = r2.element
            r2 = r2 ^ r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt.hasScrollableContainer$lambda$0(kotlin.jvm.internal.Ref$BooleanRef, androidx.compose.ui.node.TraversableNode):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String unsupportedIndicationExceptionMessage(Indication indication) {
        return "clickable only supports IndicationNodeFactory instances provided to LocalIndication, but Indication was provided instead. Either migrate the Indication implementation to implement IndicationNodeFactory, or use the other clickable overload that takes an Indication parameter, and explicitly pass LocalIndication.current there. The Indication instance provided here was: " + indication;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean changedToUp(IndirectPointerInputChange indirectPointerInputChange) {
        return (indirectPointerInputChange.getIsConsumed() || !indirectPointerInputChange.getPreviousPressed() || indirectPointerInputChange.getPressed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean changedToUpIgnoreConsumed(IndirectPointerInputChange indirectPointerInputChange) {
        return indirectPointerInputChange.getPreviousPressed() && !indirectPointerInputChange.getPressed();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* JADX INFO: renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final /* synthetic */ Modifier m356clickableXHw0xAI(Modifier modifier, final boolean z, final String str, final Role role, final Function0 function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("clickable");
                inspectorInfo.getProperties().set(StreamManagement.Enabled.ELEMENT, Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function0);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.foundation.ClickableKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ClickableKt.clickable_XHw0xAI$lambda$1(z, str, role, function0, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    /* JADX INFO: renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m354clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final Function0<Unit> function0) {
        ClickableElement clickableElementComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            clickableElementComposed$default = new ClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, false, z, str, role, function0, null);
        } else if (indication == null) {
            clickableElementComposed$default = new ClickableElement(mutableInteractionSource, null, false, z, str, role, function0, null);
        } else if (mutableInteractionSource != null) {
            clickableElementComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new ClickableElement(mutableInteractionSource, null, false, z, str, role, function0, null));
        } else {
            clickableElementComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
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
                    Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new ClickableElement(mutableInteractionSource2, null, false, z, str, role, function0, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(clickableElementComposed$default);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* JADX INFO: renamed from: combinedClickable-f5TDLPQ, reason: not valid java name */
    public static final /* synthetic */ Modifier m366combinedClickablef5TDLPQ(Modifier modifier, final boolean z, final String str, final Role role, final String str2, final Function0 function0, final Function0 function02, final boolean z2, final Function0 function03) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-f5TDLPQ$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set(StreamManagement.Enabled.ELEMENT, Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
                inspectorInfo.getProperties().set("hapticFeedbackEnabled", Boolean.valueOf(z2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.foundation.ClickableKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ClickableKt.combinedClickable_f5TDLPQ$lambda$1(z, str, role, str2, function0, function02, z2, function03, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final /* synthetic */ Modifier m364combinedClickablecJG_KMw(Modifier modifier, final boolean z, final String str, final Role role, final String str2, final Function0 function0, final Function0 function02, final Function0 function03) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set(StreamManagement.Enabled.ELEMENT, Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.foundation.ClickableKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ClickableKt.combinedClickable_cJG_KMw$lambda$1(z, str, role, str2, function0, function02, function03, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    /* JADX INFO: renamed from: combinedClickable-auXiCPI, reason: not valid java name */
    public static final Modifier m362combinedClickableauXiCPI(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final String str2, final Function0<Unit> function0, final Function0<Unit> function02, final boolean z2, final Function0<Unit> function03) {
        CombinedClickableElement combinedClickableElementComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            combinedClickableElementComposed$default = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, false, z, str, role, function03, str2, function0, function02, z2, null);
        } else if (indication == null) {
            combinedClickableElementComposed$default = new CombinedClickableElement(mutableInteractionSource, null, false, z, str, role, function03, str2, function0, function02, z2, null);
        } else if (mutableInteractionSource != null) {
            combinedClickableElementComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new CombinedClickableElement(mutableInteractionSource, null, false, z, str, role, function03, str2, function0, function02, z2, null));
        } else {
            combinedClickableElementComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-auXiCPI$$inlined$clickableWithIndicationIfNeeded$1
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
                    Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new CombinedClickableElement(mutableInteractionSource2, null, false, z, str, role, function03, str2, function0, function02, z2, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(combinedClickableElementComposed$default);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final /* synthetic */ Modifier m360combinedClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final String str2, final Function0 function0, final Function0 function02, final Function0 function03) {
        CombinedClickableElement combinedClickableElementComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            combinedClickableElementComposed$default = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, false, z, str, role, function03, str2, function0, function02, true, null);
        } else if (indication == null) {
            combinedClickableElementComposed$default = new CombinedClickableElement(mutableInteractionSource, null, false, z, str, role, function03, str2, function0, function02, true, null);
        } else if (mutableInteractionSource != null) {
            combinedClickableElementComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new CombinedClickableElement(mutableInteractionSource, null, false, z, str, role, function03, str2, function0, function02, true, null));
        } else {
            combinedClickableElementComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$clickableWithIndicationIfNeeded$1
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
                    Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new CombinedClickableElement(mutableInteractionSource2, null, false, z, str, role, function03, str2, function0, function02, true, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(combinedClickableElementComposed$default);
    }
}
