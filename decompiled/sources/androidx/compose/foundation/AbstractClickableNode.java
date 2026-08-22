package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b!\u0018\u0000 ~2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001~BM\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u00106\u001a\u00020\u000fH\u0002J\n\u00107\u001a\u0004\u0018\u00010%H\u0016J\f\u00108\u001a\u00020\u0017*\u000209H\u0016JS\u0010:\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0004¢\u0006\u0002\b;J\u0017\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0004¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\u0006\u0010G\u001a\u00020\u0017J\b\u0010H\u001a\u00020\u0017H\u0016J\u0006\u0010I\u001a\u00020\u0017J\b\u0010J\u001a\u00020\u0017H\u0004J\u0010\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u000fH\u0002J\b\u0010M\u001a\u00020\u0017H\u0002J\b\u0010N\u001a\u00020\u0017H\u0002J\b\u0010O\u001a\u00020\u0017H\u0002J'\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020R2\u0006\u0010E\u001a\u00020F2\u0006\u0010S\u001a\u00020?H\u0016¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u0017H\u0016J\u0015\u0010W\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020X¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020XH$¢\u0006\u0004\b\\\u0010ZJ\u0017\u0010]\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020XH$¢\u0006\u0004\b^\u0010ZJ\b\u0010_\u001a\u00020\u0017H\u0014J\u0015\u0010`\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020X¢\u0006\u0004\ba\u0010ZJ\n\u0010d\u001a\u00020\u0017*\u000209J\u000f\u0010e\u001a\u0004\u0018\u00010\u0017H\u0004¢\u0006\u0002\u0010fJ\u0010\u0010i\u001a\u00020\u00172\u0006\u0010C\u001a\u00020jH\u0004J\u0010\u0010i\u001a\u00020\u00172\u0006\u0010C\u001a\u00020kH\u0004J\u001f\u0010i\u001a\u00020\u00172\u0006\u0010l\u001a\u0002002\u0006\u0010m\u001a\u00020\u000fH\u0004¢\u0006\u0004\bn\u0010oJ\u001f\u0010p\u001a\u00020\u00172\u0006\u0010l\u001a\u0002002\u0006\u0010m\u001a\u00020\u000fH\u0004¢\u0006\u0004\bq\u0010oJ\u0010\u0010r\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u000fH\u0004J\u001c\u0010s\u001a\u00020\u0017*\u00020t2\u0006\u0010l\u001a\u000200H\u0084@¢\u0006\u0004\bu\u0010vJ\b\u0010w\u001a\u00020\u000fH\u0002J\u0012\u0010w\u001a\u00020\u000f2\b\u0010C\u001a\u0004\u0018\u00010kH\u0002J\u0010\u0010w\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020jH\u0002J\b\u0010x\u001a\u00020\u0017H\u0002J\b\u0010y\u001a\u00020\u0017H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020*0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010b\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bc\u0010\u001cR\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010z\u001a\u00020{X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}¨\u0006\u007f"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputModifierNode;", "Landroidx/compose/foundation/GestureConnection;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", StreamManagement.Enabled.ELEMENT, "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "getEnabled", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "localIndicationNodeFactory", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "gestureNode", "Landroidx/compose/ui/node/DelegatableNode;", "indicationNode", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "currentKeyPressInteractions", "Landroidx/collection/MutableLongObjectMap;", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "J", "indirectPointerPressInteraction", "indirectPointerEventPressPosition", "userProvidedInteractionSource", "lazilyCreateIndication", "shouldLazilyCreateIndication", "createPointerInputNodeIfNeeded", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateCommon", "updateCommon-O2vRcR0", "getExtendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/unit/IntSize;", "getExtendedTouchPadding-hWWAJMo", "(J)J", "onIndirectPointerEvent", "event", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onAttach", "onObservedReadsChanged", "onDetach", "disposeInteractions", "onFocusChange", "isFocused", "recreateIndicationIfNeeded", "initializeIndicationAndInteractionSourceIfNeeded", "initializeGestureCoordination", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onKeyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyDownEvent", "onClickKeyDownEvent-ZmokQxo", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "resetPointerInputHandler", "()Lkotlin/Unit;", "delayJob", "Lkotlinx/coroutines/Job;", "handlePressInteractionStart", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "indirectPointer", "handlePressInteractionStart-3MmeM6k", "(JZ)V", "handlePressInteractionRelease", "handlePressInteractionRelease-3MmeM6k", "handlePressInteractionCancel", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "handlePressInteraction-d-4ec7I", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delayPressInteraction", "emitHoverEnter", "emitHoverExit", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "TraverseKey", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, SemanticsModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, IndirectPointerInputModifierNode, GestureConnection {
    private long centerOffset;
    private final MutableLongObjectMap<PressInteraction.Press> currentKeyPressInteractions;
    private Job delayJob;
    private boolean enabled;
    private final FocusableNode focusableNode;
    private DelegatableNode gestureNode;
    private HoverInteraction.Enter hoverInteraction;
    private DelegatableNode indicationNode;
    private IndicationNodeFactory indicationNodeFactory;
    private Offset indirectPointerEventPressPosition;
    private PressInteraction.Press indirectPointerPressInteraction;
    private MutableInteractionSource interactionSource;
    private boolean lazilyCreateIndication;
    private IndicationNodeFactory localIndicationNodeFactory;
    private Function0<Unit> onClick;
    private String onClickLabel;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private PressInteraction.Press pressInteraction;
    private Role role;
    private final boolean shouldAutoInvalidate;
    private final Object traverseKey;
    private boolean useLocalIndication;
    private MutableInteractionSource userProvidedInteractionSource;

    /* JADX INFO: renamed from: TraverseKey, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z, z2, str, role, function0);
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        return null;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    protected void onCancelKeyInput() {
    }

    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo, reason: not valid java name */
    protected abstract boolean mo277onClickKeyDownEventZmokQxo(KeyEvent event);

    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo, reason: not valid java name */
    protected abstract boolean mo278onClickKeyUpEventZmokQxo(KeyEvent event);

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo281onPreKeyEventZmokQxo(KeyEvent event) {
        return false;
    }

    private AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0<Unit> function0) {
        this.interactionSource = mutableInteractionSource;
        this.indicationNodeFactory = indicationNodeFactory;
        this.useLocalIndication = z;
        this.onClickLabel = str;
        this.role = role;
        this.enabled = z2;
        this.onClick = function0;
        this.focusableNode = new FocusableNode(this.interactionSource, Focusability.INSTANCE.m5659getSystemDefinedLCbbffg(), new AbstractClickableNode$focusableNode$1(this), null);
        this.currentKeyPressInteractions = LongObjectMapKt.mutableLongObjectMapOf();
        this.centerOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();
        this.userProvidedInteractionSource = this.interactionSource;
        this.lazilyCreateIndication = shouldLazilyCreateIndication();
        this.traverseKey = INSTANCE;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    private final boolean shouldLazilyCreateIndication() {
        return this.userProvidedInteractionSource == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX INFO: renamed from: updateCommon-O2vRcR0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void m282updateCommonO2vRcR0(androidx.compose.foundation.interaction.MutableInteractionSource r3, androidx.compose.foundation.IndicationNodeFactory r4, boolean r5, boolean r6, java.lang.String r7, androidx.compose.ui.semantics.Role r8, kotlin.jvm.functions.Function0<kotlin.Unit> r9) {
        /*
            r2 = this;
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = r2.userProvidedInteractionSource
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            r1 = 1
            if (r0 != 0) goto L12
            r2.disposeInteractions()
            r2.userProvidedInteractionSource = r3
            r2.interactionSource = r3
            r3 = r1
            goto L13
        L12:
            r3 = 0
        L13:
            androidx.compose.foundation.IndicationNodeFactory r0 = r2.indicationNodeFactory
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r4)
            if (r0 != 0) goto L1e
            r2.indicationNodeFactory = r4
            r3 = r1
        L1e:
            boolean r4 = r2.useLocalIndication
            if (r4 == r5) goto L2a
            r2.useLocalIndication = r5
            if (r5 == 0) goto L29
            r2.onObservedReadsChanged()
        L29:
            r3 = r1
        L2a:
            boolean r4 = r2.enabled
            if (r4 == r6) goto L4a
            if (r6 == 0) goto L38
            androidx.compose.foundation.FocusableNode r4 = r2.focusableNode
            androidx.compose.ui.node.DelegatableNode r4 = (androidx.compose.ui.node.DelegatableNode) r4
            r2.delegate(r4)
            goto L42
        L38:
            androidx.compose.foundation.FocusableNode r4 = r2.focusableNode
            androidx.compose.ui.node.DelegatableNode r4 = (androidx.compose.ui.node.DelegatableNode) r4
            r2.undelegate(r4)
            r2.disposeInteractions()
        L42:
            r4 = r2
            androidx.compose.ui.node.SemanticsModifierNode r4 = (androidx.compose.ui.node.SemanticsModifierNode) r4
            androidx.compose.ui.node.SemanticsModifierNodeKt.invalidateSemantics(r4)
            r2.enabled = r6
        L4a:
            java.lang.String r4 = r2.onClickLabel
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r4 != 0) goto L5a
            r2.onClickLabel = r7
            r4 = r2
            androidx.compose.ui.node.SemanticsModifierNode r4 = (androidx.compose.ui.node.SemanticsModifierNode) r4
            androidx.compose.ui.node.SemanticsModifierNodeKt.invalidateSemantics(r4)
        L5a:
            androidx.compose.ui.semantics.Role r4 = r2.role
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r8)
            if (r4 != 0) goto L6a
            r2.role = r8
            r4 = r2
            androidx.compose.ui.node.SemanticsModifierNode r4 = (androidx.compose.ui.node.SemanticsModifierNode) r4
            androidx.compose.ui.node.SemanticsModifierNodeKt.invalidateSemantics(r4)
        L6a:
            r2.onClick = r9
            boolean r4 = r2.lazilyCreateIndication
            boolean r5 = r2.shouldLazilyCreateIndication()
            if (r4 == r5) goto L81
            boolean r4 = r2.shouldLazilyCreateIndication()
            r2.lazilyCreateIndication = r4
            if (r4 != 0) goto L81
            androidx.compose.ui.node.DelegatableNode r4 = r2.indicationNode
            if (r4 != 0) goto L81
            goto L82
        L81:
            r1 = r3
        L82:
            if (r1 == 0) goto L87
            r2.recreateIndicationIfNeeded()
        L87:
            androidx.compose.foundation.FocusableNode r3 = r2.focusableNode
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r2.interactionSource
            r3.update(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.m282updateCommonO2vRcR0(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.IndicationNodeFactory, boolean, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function0):void");
    }

    /* JADX INFO: renamed from: getExtendedTouchPadding-hWWAJMo, reason: not valid java name */
    protected final long m273getExtendedTouchPaddinghWWAJMo(long size) {
        long jMo489toSizeXkaWNTQ = DelegatableNodeKt.requireDensity(this).mo489toSizeXkaWNTQ(((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).mo7678getMinimumTouchTargetSizeMYxV2XQ());
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (jMo489toSizeXkaWNTQ >> 32)) - ((int) (size >> 32))) / 2.0f;
        return Size.m5783constructorimpl((((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jMo489toSizeXkaWNTQ & 4294967295L)) - ((int) (size & 4294967295L))) / 2.0f)) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32));
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent event, PointerEventPass pass) {
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled) {
            initializeGestureCoordination();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        onObservedReadsChanged();
        if (!this.lazilyCreateIndication) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            delegate(this.focusableNode);
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        if (this.useLocalIndication) {
            ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.AbstractClickableNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AbstractClickableNode.onObservedReadsChanged$lambda$0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onObservedReadsChanged$lambda$0(AbstractClickableNode abstractClickableNode) {
        Indication indication = (Indication) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractClickableNode, IndicationKt.getLocalIndication());
        if (!(indication instanceof IndicationNodeFactory)) {
            InlineClassHelperKt.throwIllegalArgumentException(ClickableKt.unsupportedIndicationExceptionMessage(indication));
        }
        IndicationNodeFactory indicationNodeFactory = abstractClickableNode.localIndicationNodeFactory;
        IndicationNodeFactory indicationNodeFactory2 = (IndicationNodeFactory) indication;
        abstractClickableNode.localIndicationNodeFactory = indicationNodeFactory2;
        if (indicationNodeFactory != null && !Intrinsics.areEqual(indicationNodeFactory2, indicationNodeFactory)) {
            abstractClickableNode.recreateIndicationIfNeeded();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractions();
        if (this.userProvidedInteractionSource == null) {
            this.interactionSource = null;
        }
        DelegatableNode delegatableNode = this.indicationNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.indicationNode = null;
        DelegatableNode delegatableNode2 = this.gestureNode;
        if (delegatableNode2 != null) {
            undelegate(delegatableNode2);
        }
        this.gestureNode = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void disposeInteractions() {
        /*
            r15 = this;
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = r15.interactionSource
            if (r0 == 0) goto L7e
            androidx.compose.foundation.interaction.PressInteraction$Press r1 = r15.pressInteraction
            if (r1 == 0) goto L12
            androidx.compose.foundation.interaction.PressInteraction$Cancel r2 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r2.<init>(r1)
            androidx.compose.foundation.interaction.Interaction r2 = (androidx.compose.foundation.interaction.Interaction) r2
            r0.tryEmit(r2)
        L12:
            androidx.compose.foundation.interaction.PressInteraction$Press r1 = r15.indirectPointerPressInteraction
            if (r1 == 0) goto L20
            androidx.compose.foundation.interaction.PressInteraction$Cancel r2 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r2.<init>(r1)
            androidx.compose.foundation.interaction.Interaction r2 = (androidx.compose.foundation.interaction.Interaction) r2
            r0.tryEmit(r2)
        L20:
            androidx.compose.foundation.interaction.HoverInteraction$Enter r1 = r15.hoverInteraction
            if (r1 == 0) goto L2e
            androidx.compose.foundation.interaction.HoverInteraction$Exit r2 = new androidx.compose.foundation.interaction.HoverInteraction$Exit
            r2.<init>(r1)
            androidx.compose.foundation.interaction.Interaction r2 = (androidx.compose.foundation.interaction.Interaction) r2
            r0.tryEmit(r2)
        L2e:
            androidx.collection.MutableLongObjectMap<androidx.compose.foundation.interaction.PressInteraction$Press> r1 = r15.currentKeyPressInteractions
            androidx.collection.LongObjectMap r1 = (androidx.collection.LongObjectMap) r1
            java.lang.Object[] r2 = r1.values
            long[] r1 = r1.metadata
            int r3 = r1.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7e
            r4 = 0
            r5 = r4
        L3d:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L79
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L57:
            if (r10 >= r8) goto L77
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L73
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.foundation.interaction.PressInteraction$Press r11 = (androidx.compose.foundation.interaction.PressInteraction.Press) r11
            androidx.compose.foundation.interaction.PressInteraction$Cancel r12 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r12.<init>(r11)
            androidx.compose.foundation.interaction.Interaction r12 = (androidx.compose.foundation.interaction.Interaction) r12
            r0.tryEmit(r12)
        L73:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L57
        L77:
            if (r8 != r9) goto L7e
        L79:
            if (r5 == r3) goto L7e
            int r5 = r5 + 1
            goto L3d
        L7e:
            r0 = 0
            r15.pressInteraction = r0
            r15.indirectPointerPressInteraction = r0
            r15.indirectPointerEventPressPosition = r0
            r15.hoverInteraction = r0
            androidx.collection.MutableLongObjectMap<androidx.compose.foundation.interaction.PressInteraction$Press> r0 = r15.currentKeyPressInteractions
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.disposeInteractions():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onFocusChange(boolean r20) {
        /*
            r19 = this;
            r0 = r19
            if (r20 == 0) goto L8
            r0.initializeIndicationAndInteractionSourceIfNeeded()
            return
        L8:
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = r0.interactionSource
            r2 = 0
            if (r1 == 0) goto L80
            androidx.collection.MutableLongObjectMap<androidx.compose.foundation.interaction.PressInteraction$Press> r1 = r0.currentKeyPressInteractions
            androidx.collection.LongObjectMap r1 = (androidx.collection.LongObjectMap) r1
            java.lang.Object[] r3 = r1.values
            long[] r1 = r1.metadata
            int r4 = r1.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L69
            r5 = 0
            r6 = r5
        L1c:
            r7 = r1[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L64
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = r5
        L36:
            if (r11 >= r9) goto L62
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L5e
            int r12 = r6 << 3
            int r12 = r12 + r11
            r12 = r3[r12]
            androidx.compose.foundation.interaction.PressInteraction$Press r12 = (androidx.compose.foundation.interaction.PressInteraction.Press) r12
            kotlinx.coroutines.CoroutineScope r13 = r0.getCoroutineScope()
            androidx.compose.foundation.AbstractClickableNode$onFocusChange$1$1 r14 = new androidx.compose.foundation.AbstractClickableNode$onFocusChange$1$1
            r14.<init>(r0, r12, r2)
            r16 = r14
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            r17 = 3
            r18 = 0
            r14 = 0
            r15 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r13, r14, r15, r16, r17, r18)
        L5e:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L36
        L62:
            if (r9 != r10) goto L69
        L64:
            if (r6 == r4) goto L69
            int r6 = r6 + 1
            goto L1c
        L69:
            androidx.compose.foundation.interaction.PressInteraction$Press r1 = r0.indirectPointerPressInteraction
            if (r1 == 0) goto L80
            kotlinx.coroutines.CoroutineScope r3 = r0.getCoroutineScope()
            androidx.compose.foundation.AbstractClickableNode$onFocusChange$2$1 r4 = new androidx.compose.foundation.AbstractClickableNode$onFocusChange$2$1
            r4.<init>(r0, r1, r2)
            r6 = r4
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r4 = 0
            r5 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
        L80:
            androidx.collection.MutableLongObjectMap<androidx.compose.foundation.interaction.PressInteraction$Press> r1 = r0.currentKeyPressInteractions
            r1.clear()
            r0.indirectPointerPressInteraction = r2
            r0.onCancelKeyInput()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.onFocusChange(boolean):void");
    }

    private final void recreateIndicationIfNeeded() {
        DelegatableNode delegatableNode = this.indicationNode;
        if (delegatableNode == null && this.lazilyCreateIndication) {
            return;
        }
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.indicationNode = null;
        initializeIndicationAndInteractionSourceIfNeeded();
    }

    private final void initializeIndicationAndInteractionSourceIfNeeded() {
        if (this.indicationNode != null) {
            return;
        }
        IndicationNodeFactory indicationNodeFactory = this.useLocalIndication ? this.localIndicationNodeFactory : this.indicationNodeFactory;
        if (indicationNodeFactory != null) {
            if (this.interactionSource == null) {
                this.interactionSource = InteractionSourceKt.MutableInteractionSource();
            }
            this.focusableNode.update(this.interactionSource);
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            Intrinsics.checkNotNull(mutableInteractionSource);
            DelegatableNode delegatableNodeCreate = indicationNodeFactory.create(mutableInteractionSource);
            delegate(delegatableNodeCreate);
            this.indicationNode = delegatableNodeCreate;
        }
    }

    private final void initializeGestureCoordination() {
        if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled && this.gestureNode == null) {
            this.gestureNode = delegate(GestureNodeKt.gestureNode(this));
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo280onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNodeCreatePointerInputNodeIfNeeded;
        long jM9007getCenterozmzZPI = IntSizeKt.m9007getCenterozmzZPI(bounds);
        this.centerOffset = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(IntOffset.m8958getXimpl(jM9007getCenterozmzZPI))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.m8959getYimpl(jM9007getCenterozmzZPI))) & 4294967295L));
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled) {
            initializeGestureCoordination();
            if (pass == PointerEventPass.Main) {
                int type = pointerEvent.getType();
                if (PointerEventType.m7252equalsimpl0(type, PointerEventType.INSTANCE.m7256getEnter7fucELk())) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
                } else if (PointerEventType.m7252equalsimpl0(type, PointerEventType.INSTANCE.m7257getExit7fucELk())) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
                }
            }
        }
        if (this.pointerInputNode == null && (suspendingPointerInputModifierNodeCreatePointerInputNodeIfNeeded = createPointerInputNodeIfNeeded()) != null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(suspendingPointerInputModifierNodeCreatePointerInputNodeIfNeeded);
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo280onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        HoverInteraction.Enter enter;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null && (enter = this.hoverInteraction) != null) {
            mutableInteractionSource.tryEmit(new HoverInteraction.Exit(enter));
        }
        this.hoverInteraction = null;
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo279onKeyEventZmokQxo(KeyEvent event) {
        boolean z;
        initializeIndicationAndInteractionSourceIfNeeded();
        long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(event);
        if (this.enabled && ClickableKt.m372isPressZmokQxo(event)) {
            if (this.currentKeyPressInteractions.containsKey(jM7144getKeyZmokQxo)) {
                z = false;
            } else {
                PressInteraction.Press press = new PressInteraction.Press(this.centerOffset, null);
                this.currentKeyPressInteractions.set(jM7144getKeyZmokQxo, press);
                if (this.interactionSource != null) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, press, null), 3, null);
                }
                z = true;
            }
            return mo277onClickKeyDownEventZmokQxo(event) || z;
        }
        if (this.enabled && ClickableKt.m370isClickZmokQxo(event)) {
            PressInteraction.Press pressRemove = this.currentKeyPressInteractions.remove(jM7144getKeyZmokQxo);
            if (pressRemove != null) {
                if (this.interactionSource != null) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2(this, pressRemove, null), 3, null);
                }
                mo278onClickKeyUpEventZmokQxo(event);
            }
            if (pressRemove != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role = this.role;
        if (role != null) {
            Intrinsics.checkNotNull(role);
            SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, role.getValue());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.onClickLabel, new Function0() { // from class: androidx.compose.foundation.AbstractClickableNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(AbstractClickableNode.applySemantics$lambda$0(this.f$0));
            }
        });
        if (this.enabled) {
            this.focusableNode.applySemantics(semanticsPropertyReceiver);
        } else {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        applyAdditionalSemantics(semanticsPropertyReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$0(AbstractClickableNode abstractClickableNode) {
        abstractClickableNode.onClick.invoke();
        return true;
    }

    protected final Unit resetPointerInputHandler() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode == null) {
            return null;
        }
        suspendingPointerInputModifierNode.resetPointerInputHandler();
        return Unit.INSTANCE;
    }

    protected final void handlePressInteractionStart(IndirectPointerInputChange event) {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction.Press press = new PressInteraction.Press(event.getPosition(), null);
            if (delayPressInteraction(event)) {
                this.delayJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$1(mutableInteractionSource, press, this, null), 3, null);
            } else {
                this.indirectPointerPressInteraction = press;
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$2(mutableInteractionSource, press, null), 3, null);
            }
        }
    }

    protected final void handlePressInteractionStart(PointerInputChange event) {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction.Press press = new PressInteraction.Press(event.getPosition(), null);
            if (delayPressInteraction(event)) {
                this.delayJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$2$1(mutableInteractionSource, press, this, null), 3, null);
            } else {
                this.pressInteraction = press;
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$2$2(mutableInteractionSource, press, null), 3, null);
            }
        }
    }

    /* JADX INFO: renamed from: handlePressInteractionStart-3MmeM6k, reason: not valid java name */
    protected final void m276handlePressInteractionStart3MmeM6k(long offset, boolean indirectPointer) {
        boolean zDelayPressInteraction;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction.Press press = new PressInteraction.Press(offset, null);
            if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
                zDelayPressInteraction = delayPressInteraction((PointerInputChange) null);
            } else {
                zDelayPressInteraction = delayPressInteraction();
            }
            if (!zDelayPressInteraction) {
                if (indirectPointer) {
                    this.indirectPointerPressInteraction = press;
                } else {
                    this.pressInteraction = press;
                }
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$3$2(mutableInteractionSource, press, null), 3, null);
                return;
            }
            this.delayJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$3$1(mutableInteractionSource, press, indirectPointer, this, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: handlePressInteractionRelease-3MmeM6k, reason: not valid java name */
    protected final void m275handlePressInteractionRelease3MmeM6k(long offset, boolean indirectPointer) {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            Job job = this.delayJob;
            if (job != null && job.isActive()) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1(job, offset, mutableInteractionSource, null), 3, null);
            } else {
                PressInteraction.Press press = indirectPointer ? this.indirectPointerPressInteraction : this.pressInteraction;
                if (press != null) {
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$2$1(press, mutableInteractionSource, null), 3, null);
                }
            }
            if (indirectPointer) {
                this.indirectPointerPressInteraction = null;
            } else {
                this.pressInteraction = null;
            }
        }
    }

    protected final void handlePressInteractionCancel(boolean indirectPointer) {
        final MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            Job job = this.delayJob;
            if (job != null && job.isActive()) {
                Job job2 = this.delayJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
            } else {
                PressInteraction.Press press = indirectPointer ? this.indirectPointerPressInteraction : this.pressInteraction;
                if (press != null) {
                    final PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                    Job job3 = (Job) getCoroutineScope().getCoroutineContext().get(Job.INSTANCE);
                    BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionCancel$1$1$1(mutableInteractionSource, cancel, job3 != null ? job3.invokeOnCompletion(new Function1() { // from class: androidx.compose.foundation.AbstractClickableNode$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AbstractClickableNode.handlePressInteractionCancel$lambda$0$0$0(mutableInteractionSource, cancel, (Throwable) obj);
                        }
                    }) : null, null), 3, null);
                }
            }
            if (indirectPointer) {
                this.indirectPointerPressInteraction = null;
            } else {
                this.pressInteraction = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handlePressInteractionCancel$lambda$0$0$0(MutableInteractionSource mutableInteractionSource, PressInteraction.Cancel cancel, Throwable th) {
        mutableInteractionSource.tryEmit(cancel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: handlePressInteraction-d-4ec7I, reason: not valid java name */
    protected final Object m274handlePressInteractiond4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
        Object objCoroutineScope;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        return (mutableInteractionSource == null || (objCoroutineScope = CoroutineScopeKt.coroutineScope(new AbstractClickableNode$handlePressInteraction$2$1(pressGestureScope, j, mutableInteractionSource, this, null), continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objCoroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean delayPressInteraction() {
        return ClickableKt.hasScrollableContainer(this) || Clickable_androidKt.isComposeRootInScrollableContainer(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean delayPressInteraction(PointerInputChange event) {
        boolean zHasInterestedParent;
        if (event == null) {
            zHasInterestedParent = GestureNodeKt.getParentGestureConnection(this) != null;
        } else {
            zHasInterestedParent = ClickableKt.hasInterestedParent(this, event);
        }
        return zHasInterestedParent || Clickable_androidKt.isComposeRootInScrollableContainer(this);
    }

    private final boolean delayPressInteraction(IndirectPointerInputChange event) {
        return ClickableKt.hasInterestedParent(this, event) || Clickable_androidKt.isComposeRootInScrollableContainer(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitHoverEnter() {
        if (this.hoverInteraction == null) {
            HoverInteraction.Enter enter = new HoverInteraction.Enter();
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(mutableInteractionSource, enter, null), 3, null);
            }
            this.hoverInteraction = enter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitHoverExit() {
        HoverInteraction.Enter enter = this.hoverInteraction;
        if (enter != null) {
            HoverInteraction.Exit exit = new HoverInteraction.Exit(enter);
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(mutableInteractionSource, exit, null), 3, null);
            }
            this.hoverInteraction = null;
        }
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.AbstractClickableNode$TraverseKey, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode$TraverseKey;", "", "<init>", "()V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
