package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.CombinedClickableNode;
import androidx.compose.foundation.gestures.IndirectPointerInputDragCycleDetectorKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetector_androidKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001^B\u007f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J'\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016¢\u0006\u0004\b=\u0010>J\u0018\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020$H\u0002J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020-H\u0002J\u0018\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020$H\u0002J\u0018\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020-H\u0002J\u001f\u0010G\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0002¢\u0006\u0004\bH\u0010IJ\u0010\u0010G\u001a\u00020\u00052\u0006\u0010J\u001a\u00020AH\u0002J\b\u0010K\u001a\u00020\u0005H\u0002J\u0010\u0010L\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010L\u001a\u00020\u00052\u0006\u0010J\u001a\u00020AH\u0002J\b\u0010M\u001a\u00020\u0005H\u0016J\b\u0010N\u001a\u00020\u0005H\u0016J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u000bH\u0002J{\u0010Q\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\bRJ\f\u0010S\u001a\u00020\u0005*\u00020TH\u0016J\u0017\u0010U\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020VH\u0014¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020VH\u0014¢\u0006\u0004\bZ\u0010XJ\b\u0010[\u001a\u00020\u0005H\u0014J\b\u0010\\\u001a\u00020\u0005H\u0016J\b\u0010]\u001a\u00020\u0005H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u000bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", StreamManagement.Enabled.ELEMENT, "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHapticFeedbackEnabled", "()Z", "setHapticFeedbackEnabled", "(Z)V", "longKeyPressJobs", "Landroidx/collection/MutableLongObjectMap;", "Lkotlinx/coroutines/Job;", "doubleKeyClickStates", "Landroidx/compose/foundation/CombinedClickableNode$DoubleKeyClickState;", "isSuspendingPointerInputEnabled", "isSuspendingPointerInputEnabled$annotations", "()V", "downEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "longPressJob", "tapJob", "isSecondTap", "longPressTriggered", "firstTapUpTime", "", "ignoreNextUp", "indirectDownEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "indirectLongPressJob", "indirectTapJob", "indirectIsSecondTap", "indirectLongPressTriggered", "indirectFirstTapUpTime", "indirectIgnoreNextUp", "createPointerInputNodeIfNeeded", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onIndirectPointerEvent", "event", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "handleDownEvent", "down", "handleUpEvent", "uptimeMillis", "downChange", "handleNonUpEventIfNeeded", "handleNonUpEventIfNeeded-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "indirectPointerEvent", "handleDeepPress", "checkForCancellation", "onCancelPointerInput", "onCancelIndirectPointerInput", "cancelInput", "indirectPointer", DiscoverItems.Item.UPDATE_ACTION, "update-2tQrsxU", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onClickKeyDownEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onClickKeyDownEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onReset", "resetKeyPressState", "DoubleKeyClickState", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class CombinedClickableNode extends AbstractClickableNode implements CompositionLocalConsumerModifierNode {
    private final MutableLongObjectMap<DoubleKeyClickState> doubleKeyClickStates;
    private PointerInputChange downEvent;
    private long firstTapUpTime;
    private boolean hapticFeedbackEnabled;
    private boolean ignoreNextUp;
    private IndirectPointerInputChange indirectDownEvent;
    private long indirectFirstTapUpTime;
    private boolean indirectIgnoreNextUp;
    private boolean indirectIsSecondTap;
    private Job indirectLongPressJob;
    private boolean indirectLongPressTriggered;
    private Job indirectTapJob;
    private boolean isSecondTap;
    private final boolean isSuspendingPointerInputEnabled;
    private final MutableLongObjectMap<Job> longKeyPressJobs;
    private Job longPressJob;
    private boolean longPressTriggered;
    private Function0<Unit> onDoubleClick;
    private Function0<Unit> onLongClick;
    private String onLongClickLabel;
    private Job tapJob;

    public /* synthetic */ CombinedClickableNode(Function0 function0, String str, Function0 function02, Function0 function03, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, boolean z3, String str2, Role role, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, function02, function03, z, mutableInteractionSource, indicationNodeFactory, z2, z3, str2, role);
    }

    private static /* synthetic */ void isSuspendingPointerInputEnabled$annotations() {
    }

    private CombinedClickableNode(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, boolean z3, String str2, Role role) {
        super(mutableInteractionSource, indicationNodeFactory, z2, z3, str2, role, function0, null);
        this.onLongClickLabel = str;
        this.onLongClick = function02;
        this.onDoubleClick = function03;
        this.hapticFeedbackEnabled = z;
        this.longKeyPressJobs = LongObjectMapKt.mutableLongObjectMapOf();
        this.doubleKeyClickStates = LongObjectMapKt.mutableLongObjectMapOf();
        this.isSuspendingPointerInputEnabled = !ComposeFoundationFlags.isNonSuspendingPointerInputInCombinedClickableEnabled;
        this.firstTapUpTime = -1L;
        this.indirectFirstTapUpTime = -1L;
    }

    public final boolean getHapticFeedbackEnabled() {
        return this.hapticFeedbackEnabled;
    }

    public final void setHapticFeedbackEnabled(boolean z) {
        this.hapticFeedbackEnabled = z;
    }

    /* JADX INFO: compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/CombinedClickableNode$DoubleKeyClickState;", "", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "doubleTapMinTimeMillisElapsed", "", "getDoubleTapMinTimeMillisElapsed", "()Z", "setDoubleTapMinTimeMillisElapsed", "(Z)V", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DoubleKeyClickState {
        public static final int $stable = 8;
        private boolean doubleTapMinTimeMillisElapsed;
        private final Job job;

        public DoubleKeyClickState(Job job) {
            this.job = job;
        }

        public final Job getJob() {
            return this.job;
        }

        public final boolean getDoubleTapMinTimeMillisElapsed() {
            return this.doubleTapMinTimeMillisElapsed;
        }

        public final void setDoubleTapMinTimeMillisElapsed(boolean z) {
            this.doubleTapMinTimeMillisElapsed = z;
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        if (this.isSuspendingPointerInputEnabled) {
            return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1());
        }
        return null;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass1 implements PointerInputEventHandler {
        AnonymousClass1() {
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            Function1 function1;
            Function1 function12;
            if (!CombinedClickableNode.this.getEnabled() || CombinedClickableNode.this.onDoubleClick == null) {
                function1 = null;
            } else {
                final CombinedClickableNode combinedClickableNode = CombinedClickableNode.this;
                function1 = new Function1() { // from class: androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CombinedClickableNode.AnonymousClass1.invoke$lambda$0(combinedClickableNode, (Offset) obj);
                    }
                };
            }
            if (!CombinedClickableNode.this.getEnabled() || CombinedClickableNode.this.onLongClick == null) {
                function12 = null;
            } else {
                final CombinedClickableNode combinedClickableNode2 = CombinedClickableNode.this;
                function12 = new Function1() { // from class: androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CombinedClickableNode.AnonymousClass1.invoke$lambda$1(combinedClickableNode2, (Offset) obj);
                    }
                };
            }
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(CombinedClickableNode.this, null);
            final CombinedClickableNode combinedClickableNode3 = CombinedClickableNode.this;
            Object objDetectTapGestures = TapGestureDetectorKt.detectTapGestures(pointerInputScope, function1, function12, anonymousClass3, new Function1() { // from class: androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CombinedClickableNode.AnonymousClass1.invoke$lambda$2(combinedClickableNode3, (Offset) obj);
                }
            }, continuation);
            return objDetectTapGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$0(CombinedClickableNode combinedClickableNode, Offset offset) {
            Function0 function0 = combinedClickableNode.onDoubleClick;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1(CombinedClickableNode combinedClickableNode, Offset offset) {
            Function0 function0 = combinedClickableNode.onLongClick;
            if (function0 != null) {
                function0.invoke();
            }
            if (combinedClickableNode.getHapticFeedbackEnabled()) {
                ((HapticFeedback) CompositionLocalConsumerModifierNodeKt.currentValueOf(combinedClickableNode, CompositionLocalsKt.getLocalHapticFeedback())).mo6744performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m6757getLongPress5zf0vsI());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: Clickable.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1$3", f = "Clickable.kt", i = {}, l = {1132}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
            /* synthetic */ long J$0;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CombinedClickableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(CombinedClickableNode combinedClickableNode, Continuation<? super AnonymousClass3> continuation) {
                super(3, continuation);
                this.this$0 = combinedClickableNode;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                return m379invoked4ec7I(pressGestureScope, offset.m5733unboximpl(), continuation);
            }

            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m379invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                anonymousClass3.L$0 = pressGestureScope;
                anonymousClass3.J$0 = j;
                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                    long j = this.J$0;
                    if (this.this$0.getEnabled()) {
                        this.label = 1;
                        if (this.this$0.m274handlePressInteractiond4ec7I(pressGestureScope, j, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2(CombinedClickableNode combinedClickableNode, Offset offset) {
            if (combinedClickableNode.getEnabled()) {
                combinedClickableNode.getOnClick().invoke();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo280onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        super.mo280onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        if (this.isSuspendingPointerInputEnabled) {
            return;
        }
        if (pass == PointerEventPass.Main) {
            if (this.downEvent == null) {
                if (TapGestureDetectorKt.isChangedToDown$default(pointerEvent, true, false, 2, null)) {
                    handleDownEvent(pointerEvent.getChanges().get(0));
                    return;
                }
                return;
            }
            if (TapGestureDetector_androidKt.isDeepPress(pointerEvent)) {
                handleDeepPress();
            }
            if (this.longPressTriggered) {
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i = 0; i < size; i++) {
                    if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i))) {
                        List<PointerInputChange> changes2 = pointerEvent.getChanges();
                        int size2 = changes2.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            changes2.get(i2).consume();
                        }
                        return;
                    }
                }
                PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                pointerInputChange.consume();
                long uptimeMillis = pointerInputChange.getUptimeMillis();
                PointerInputChange pointerInputChange2 = this.downEvent;
                Intrinsics.checkNotNull(pointerInputChange2);
                handleUpEvent(uptimeMillis, pointerInputChange2);
                return;
            }
            List<PointerInputChange> changes3 = pointerEvent.getChanges();
            int size3 = changes3.size();
            for (int i3 = 0; i3 < size3; i3++) {
                if (!PointerEventKt.changedToUp(changes3.get(i3))) {
                    m375handleNonUpEventIfNeededO0kMr_c(pointerEvent, bounds);
                    return;
                }
            }
            PointerInputChange pointerInputChange3 = pointerEvent.getChanges().get(0);
            pointerInputChange3.consume();
            long uptimeMillis2 = pointerInputChange3.getUptimeMillis();
            PointerInputChange pointerInputChange4 = this.downEvent;
            Intrinsics.checkNotNull(pointerInputChange4);
            handleUpEvent(uptimeMillis2, pointerInputChange4);
            return;
        }
        if (pass == PointerEventPass.Final) {
            checkForCancellation(pointerEvent);
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onIndirectPointerEvent(IndirectPointerEvent event, PointerEventPass pass) {
        super.onIndirectPointerEvent(event, pass);
        if (pass == PointerEventPass.Main) {
            if (this.indirectDownEvent == null) {
                List<IndirectPointerInputChange> changes = event.getChanges();
                int size = changes.size();
                for (int i = 0; i < size; i++) {
                    if (IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(changes.get(i))) {
                        handleDownEvent(event.getChanges().get(0));
                        return;
                    }
                }
                return;
            }
            if (this.indirectLongPressTriggered) {
                List<IndirectPointerInputChange> changes2 = event.getChanges();
                int size2 = changes2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (!ClickableKt.changedToUpIgnoreConsumed(changes2.get(i2))) {
                        List<IndirectPointerInputChange> changes3 = event.getChanges();
                        int size3 = changes3.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            changes3.get(i3).consume();
                        }
                        return;
                    }
                }
                IndirectPointerInputChange indirectPointerInputChange = event.getChanges().get(0);
                indirectPointerInputChange.consume();
                long uptimeMillis = indirectPointerInputChange.getUptimeMillis();
                IndirectPointerInputChange indirectPointerInputChange2 = this.indirectDownEvent;
                Intrinsics.checkNotNull(indirectPointerInputChange2);
                handleUpEvent(uptimeMillis, indirectPointerInputChange2);
                return;
            }
            List<IndirectPointerInputChange> changes4 = event.getChanges();
            int size4 = changes4.size();
            for (int i4 = 0; i4 < size4; i4++) {
                if (!ClickableKt.changedToUp(changes4.get(i4))) {
                    handleNonUpEventIfNeeded(event);
                    return;
                }
            }
            IndirectPointerInputChange indirectPointerInputChange3 = event.getChanges().get(0);
            indirectPointerInputChange3.consume();
            long uptimeMillis2 = indirectPointerInputChange3.getUptimeMillis();
            IndirectPointerInputChange indirectPointerInputChange4 = this.indirectDownEvent;
            Intrinsics.checkNotNull(indirectPointerInputChange4);
            handleUpEvent(uptimeMillis2, indirectPointerInputChange4);
            return;
        }
        if (pass == PointerEventPass.Final) {
            checkForCancellation(event);
        }
    }

    private final void handleDownEvent(PointerInputChange down) {
        down.consume();
        this.downEvent = down;
        if (getEnabled()) {
            Job job = this.tapJob;
            if (job != null && job.isActive()) {
                if (down.getUptimeMillis() - this.firstTapUpTime < ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getDoubleTapMinTimeMillis()) {
                    this.ignoreNextUp = true;
                    return;
                }
                this.isSecondTap = true;
                Job job2 = this.tapJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                this.tapJob = null;
            }
            this.longPressTriggered = false;
            if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
                handlePressInteractionStart(down);
            } else {
                m276handlePressInteractionStart3MmeM6k(down.getPosition(), false);
            }
            if (this.onLongClick != null) {
                this.longPressJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C02741(null), 3, null);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNode$handleDownEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$handleDownEvent$1", f = "Clickable.kt", i = {}, l = {1273}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02741(Continuation<? super C02741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CombinedClickableNode.this.new C02741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(CombinedClickableNode.this, CompositionLocalsKt.getLocalViewConfiguration())).getLongPressTimeoutMillis(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Function0 function0 = CombinedClickableNode.this.onLongClick;
            if (function0 != null) {
                function0.invoke();
            }
            if (CombinedClickableNode.this.getHapticFeedbackEnabled()) {
                ((HapticFeedback) CompositionLocalConsumerModifierNodeKt.currentValueOf(CombinedClickableNode.this, CompositionLocalsKt.getLocalHapticFeedback())).mo6744performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m6757getLongPress5zf0vsI());
            }
            CombinedClickableNode.this.longPressTriggered = true;
            Job job = CombinedClickableNode.this.tapJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            CombinedClickableNode.this.tapJob = null;
            CombinedClickableNode.this.longPressJob = null;
            return Unit.INSTANCE;
        }
    }

    private final void handleDownEvent(IndirectPointerInputChange down) {
        down.consume();
        this.indirectDownEvent = down;
        if (getEnabled()) {
            Job job = this.indirectTapJob;
            if (job != null && job.isActive()) {
                if (down.getUptimeMillis() - this.indirectFirstTapUpTime < ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getDoubleTapMinTimeMillis()) {
                    this.indirectIgnoreNextUp = true;
                    return;
                }
                this.indirectIsSecondTap = true;
                Job job2 = this.indirectTapJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                this.indirectTapJob = null;
            }
            this.indirectLongPressTriggered = false;
            if (ComposeFoundationFlags.isDelayPressesUsingGestureConsumptionEnabled) {
                handlePressInteractionStart(down);
            } else {
                m276handlePressInteractionStart3MmeM6k(down.getPosition(), true);
            }
            if (this.onLongClick != null) {
                this.indirectLongPressJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass2(null), 3, null);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNode$handleDownEvent$2, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$handleDownEvent$2", f = "Clickable.kt", i = {}, l = {1318}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CombinedClickableNode.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(CombinedClickableNode.this, CompositionLocalsKt.getLocalViewConfiguration())).getLongPressTimeoutMillis(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Function0 function0 = CombinedClickableNode.this.onLongClick;
            if (function0 != null) {
                function0.invoke();
            }
            if (CombinedClickableNode.this.getHapticFeedbackEnabled()) {
                ((HapticFeedback) CompositionLocalConsumerModifierNodeKt.currentValueOf(CombinedClickableNode.this, CompositionLocalsKt.getLocalHapticFeedback())).mo6744performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m6757getLongPress5zf0vsI());
            }
            CombinedClickableNode.this.indirectLongPressTriggered = true;
            Job job = CombinedClickableNode.this.indirectTapJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            CombinedClickableNode.this.indirectTapJob = null;
            CombinedClickableNode.this.indirectLongPressJob = null;
            return Unit.INSTANCE;
        }
    }

    private final void handleUpEvent(long uptimeMillis, PointerInputChange downChange) {
        if (getEnabled() && !this.ignoreNextUp) {
            m275handlePressInteractionRelease3MmeM6k(downChange.getPosition(), false);
            this.firstTapUpTime = uptimeMillis;
            if (!this.longPressTriggered) {
                if (this.isSecondTap) {
                    Function0<Unit> function0 = this.onDoubleClick;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else if (this.onDoubleClick != null) {
                    this.tapJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C02751(null), 3, null);
                } else {
                    getOnClick().invoke();
                }
            }
        }
        this.downEvent = null;
        this.ignoreNextUp = false;
        this.isSecondTap = false;
        Job job = this.longPressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.longPressJob = null;
        this.longPressTriggered = false;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNode$handleUpEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$handleUpEvent$1", f = "Clickable.kt", i = {}, l = {1344}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02751(Continuation<? super C02751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CombinedClickableNode.this.new C02751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(CombinedClickableNode.this, CompositionLocalsKt.getLocalViewConfiguration())).getDoubleTapTimeoutMillis(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CombinedClickableNode.this.getOnClick().invoke();
            CombinedClickableNode.this.tapJob = null;
            return Unit.INSTANCE;
        }
    }

    private final void handleUpEvent(long uptimeMillis, IndirectPointerInputChange downChange) {
        if (getEnabled() && !this.indirectIgnoreNextUp) {
            m275handlePressInteractionRelease3MmeM6k(downChange.getPosition(), true);
            this.indirectFirstTapUpTime = uptimeMillis;
            if (!this.indirectLongPressTriggered) {
                if (this.indirectIsSecondTap) {
                    Function0<Unit> function0 = this.onDoubleClick;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else if (this.onDoubleClick != null) {
                    this.indirectTapJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C02762(null), 3, null);
                } else {
                    getOnClick().invoke();
                }
            }
        }
        this.indirectDownEvent = null;
        this.indirectIgnoreNextUp = false;
        this.indirectIsSecondTap = false;
        Job job = this.indirectLongPressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.indirectLongPressJob = null;
        this.indirectLongPressTriggered = false;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNode$handleUpEvent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$handleUpEvent$2", f = "Clickable.kt", i = {}, l = {1373}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02762 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02762(Continuation<? super C02762> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CombinedClickableNode.this.new C02762(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02762) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(CombinedClickableNode.this, CompositionLocalsKt.getLocalViewConfiguration())).getDoubleTapTimeoutMillis(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            CombinedClickableNode.this.getOnClick().invoke();
            CombinedClickableNode.this.indirectTapJob = null;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: handleNonUpEventIfNeeded-O0kMr_c, reason: not valid java name */
    private final void m375handleNonUpEventIfNeededO0kMr_c(PointerEvent pointerEvent, long bounds) {
        long j = m273getExtendedTouchPaddinghWWAJMo(bounds);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (pointerInputChange.isConsumed() || PointerEventKt.m7248isOutOfBoundsjwHxaWs(pointerInputChange, bounds, j)) {
                cancelInput(false);
                return;
            }
        }
    }

    private final void handleNonUpEventIfNeeded(IndirectPointerEvent indirectPointerEvent) {
        float touchSlop = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getTouchSlop();
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            IndirectPointerInputChange indirectPointerInputChange = changes.get(i);
            long position = indirectPointerInputChange.getPosition();
            IndirectPointerInputChange indirectPointerInputChange2 = this.indirectDownEvent;
            Intrinsics.checkNotNull(indirectPointerInputChange2);
            boolean z = Math.abs(Offset.m5721getDistanceimpl(Offset.m5727minusMKHz9U(position, indirectPointerInputChange2.getPosition()))) > touchSlop;
            if (indirectPointerInputChange.getIsConsumed() || z) {
                cancelInput(true);
                return;
            }
        }
    }

    private final void handleDeepPress() {
        if (this.longPressTriggered || !getEnabled() || this.onLongClick == null) {
            return;
        }
        Job job = this.longPressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.longPressJob = null;
        Function0<Unit> function0 = this.onLongClick;
        if (function0 != null) {
            function0.invoke();
        }
        if (this.hapticFeedbackEnabled) {
            ((HapticFeedback) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalHapticFeedback())).mo6744performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m6757getLongPress5zf0vsI());
        }
        this.longPressTriggered = true;
    }

    private final void checkForCancellation(PointerEvent pointerEvent) {
        if (this.downEvent == null || this.longPressTriggered) {
            return;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (pointerInputChange.isConsumed() && !Intrinsics.areEqual(pointerInputChange, this.downEvent)) {
                cancelInput(false);
                return;
            }
        }
    }

    private final void checkForCancellation(IndirectPointerEvent indirectPointerEvent) {
        if (this.indirectDownEvent == null || this.indirectLongPressTriggered) {
            return;
        }
        List<IndirectPointerInputChange> changes = indirectPointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            IndirectPointerInputChange indirectPointerInputChange = changes.get(i);
            if (indirectPointerInputChange.getIsConsumed() && !Intrinsics.areEqual(indirectPointerInputChange, this.indirectDownEvent)) {
                cancelInput(true);
                return;
            }
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        super.onCancelPointerInput();
        cancelInput(false);
    }

    @Override // androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode
    public void onCancelIndirectPointerInput() {
        cancelInput(true);
    }

    private final void cancelInput(boolean indirectPointer) {
        if (indirectPointer) {
            this.indirectDownEvent = null;
            Job job = this.indirectLongPressJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.indirectLongPressJob = null;
            Job job2 = this.indirectTapJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.indirectTapJob = null;
            this.indirectIsSecondTap = false;
            this.indirectLongPressTriggered = false;
            this.indirectFirstTapUpTime = -1L;
            this.indirectIgnoreNextUp = false;
        } else {
            this.downEvent = null;
            Job job3 = this.longPressJob;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            this.longPressJob = null;
            Job job4 = this.tapJob;
            if (job4 != null) {
                Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
            }
            this.tapJob = null;
            this.isSecondTap = false;
            this.longPressTriggered = false;
            this.firstTapUpTime = -1L;
            this.ignoreNextUp = false;
        }
        handlePressInteractionCancel(indirectPointer);
    }

    /* JADX INFO: renamed from: update-2tQrsxU, reason: not valid java name */
    public final void m376update2tQrsxU(Function0<Unit> onClick, String onLongClickLabel, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean useLocalIndication, boolean enabled, String onClickLabel, Role role) {
        boolean z;
        if (!Intrinsics.areEqual(this.onLongClickLabel, onLongClickLabel)) {
            this.onLongClickLabel = onLongClickLabel;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if ((this.onLongClick == null) != (onLongClick == null)) {
            disposeInteractions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
            z = true;
        } else {
            z = false;
        }
        this.onLongClick = onLongClick;
        if ((this.onDoubleClick == null) != (onDoubleClick == null)) {
            z = true;
        }
        this.onDoubleClick = onDoubleClick;
        if (getEnabled() != enabled) {
            z = true;
        }
        m282updateCommonO2vRcR0(interactionSource, indicationNodeFactory, useLocalIndication, enabled, onClickLabel, role, onClick);
        if (z) {
            resetPointerInputHandler();
            cancelInput(false);
            cancelInput(true);
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.onLongClickLabel, new Function0() { // from class: androidx.compose.foundation.CombinedClickableNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(CombinedClickableNode.applyAdditionalSemantics$lambda$0(this.f$0));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applyAdditionalSemantics$lambda$0(CombinedClickableNode combinedClickableNode) {
        Function0<Unit> function0 = combinedClickableNode.onLongClick;
        if (function0 == null) {
            return true;
        }
        function0.invoke();
        return true;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo */
    protected boolean mo277onClickKeyDownEventZmokQxo(KeyEvent event) {
        boolean z;
        long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(event);
        if (this.onLongClick == null || this.longKeyPressJobs.get(jM7144getKeyZmokQxo) != null) {
            z = false;
        } else {
            this.longKeyPressJobs.set(jM7144getKeyZmokQxo, BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyDownEvent$1(this, null), 3, null));
            z = true;
        }
        DoubleKeyClickState doubleKeyClickState = this.doubleKeyClickStates.get(jM7144getKeyZmokQxo);
        if (doubleKeyClickState != null) {
            if (doubleKeyClickState.getJob().isActive()) {
                Job.DefaultImpls.cancel$default(doubleKeyClickState.getJob(), (CancellationException) null, 1, (Object) null);
                if (!doubleKeyClickState.getDoubleTapMinTimeMillisElapsed()) {
                    getOnClick().invoke();
                    this.doubleKeyClickStates.remove(jM7144getKeyZmokQxo);
                    return z;
                }
            } else {
                this.doubleKeyClickStates.remove(jM7144getKeyZmokQxo);
            }
        }
        return z;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo */
    protected boolean mo278onClickKeyUpEventZmokQxo(KeyEvent event) {
        Function0<Unit> function0;
        long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(event);
        boolean z = false;
        if (this.longKeyPressJobs.get(jM7144getKeyZmokQxo) != null) {
            Job job = this.longKeyPressJobs.get(jM7144getKeyZmokQxo);
            if (job != null) {
                if (job.isActive()) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                } else {
                    z = true;
                }
            }
            this.longKeyPressJobs.remove(jM7144getKeyZmokQxo);
        }
        if (this.onDoubleClick != null) {
            if (this.doubleKeyClickStates.get(jM7144getKeyZmokQxo) != null) {
                if (!z && (function0 = this.onDoubleClick) != null) {
                    function0.invoke();
                }
                this.doubleKeyClickStates.remove(jM7144getKeyZmokQxo);
            } else if (!z) {
                this.doubleKeyClickStates.set(jM7144getKeyZmokQxo, new DoubleKeyClickState(BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyUpEvent$2(this, jM7144getKeyZmokQxo, null), 3, null)));
            }
        } else if (!z) {
            getOnClick().invoke();
        }
        return true;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    protected void onCancelKeyInput() {
        resetKeyPressState();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        resetKeyPressState();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void resetKeyPressState() {
        /*
            r24 = this;
            r0 = r24
            androidx.collection.MutableLongObjectMap<kotlinx.coroutines.Job> r1 = r0.longKeyPressJobs
            r2 = r1
            androidx.collection.LongObjectMap r2 = (androidx.collection.LongObjectMap) r2
            java.lang.Object[] r3 = r2.values
            long[] r2 = r2.metadata
            int r4 = r2.length
            int r4 = r4 + (-2)
            r9 = 7
            r10 = 0
            r13 = 1
            r14 = 8
            r15 = 0
            if (r4 < 0) goto L50
            r5 = r15
            r16 = 128(0x80, double:6.3E-322)
            r18 = 255(0xff, double:1.26E-321)
        L1b:
            r7 = r2[r5]
            r20 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = ~r7
            long r11 = r11 << r9
            long r11 = r11 & r7
            long r11 = r11 & r20
            int r6 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r6 == 0) goto L4b
            int r6 = r5 - r4
            int r6 = ~r6
            int r6 = r6 >>> 31
            int r6 = 8 - r6
            r11 = r15
        L33:
            if (r11 >= r6) goto L49
            long r22 = r7 & r18
            int r12 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r12 >= 0) goto L45
            int r12 = r5 << 3
            int r12 = r12 + r11
            r12 = r3[r12]
            kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r12, r10, r13, r10)
        L45:
            long r7 = r7 >> r14
            int r11 = r11 + 1
            goto L33
        L49:
            if (r6 != r14) goto L59
        L4b:
            if (r5 == r4) goto L59
            int r5 = r5 + 1
            goto L1b
        L50:
            r16 = 128(0x80, double:6.3E-322)
            r18 = 255(0xff, double:1.26E-321)
            r20 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
        L59:
            r1.clear()
            androidx.collection.MutableLongObjectMap<androidx.compose.foundation.CombinedClickableNode$DoubleKeyClickState> r1 = r0.doubleKeyClickStates
            r2 = r1
            androidx.collection.LongObjectMap r2 = (androidx.collection.LongObjectMap) r2
            java.lang.Object[] r3 = r2.values
            long[] r2 = r2.metadata
            int r4 = r2.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L9f
            r5 = r15
        L6b:
            r6 = r2[r5]
            long r11 = ~r6
            long r11 = r11 << r9
            long r11 = r11 & r6
            long r11 = r11 & r20
            int r8 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r8 == 0) goto L9a
            int r8 = r5 - r4
            int r8 = ~r8
            int r8 = r8 >>> 31
            int r8 = 8 - r8
            r11 = r15
        L7e:
            if (r11 >= r8) goto L98
            long r22 = r6 & r18
            int r12 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r12 >= 0) goto L94
            int r12 = r5 << 3
            int r12 = r12 + r11
            r12 = r3[r12]
            androidx.compose.foundation.CombinedClickableNode$DoubleKeyClickState r12 = (androidx.compose.foundation.CombinedClickableNode.DoubleKeyClickState) r12
            kotlinx.coroutines.Job r12 = r12.getJob()
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r12, r10, r13, r10)
        L94:
            long r6 = r6 >> r14
            int r11 = r11 + 1
            goto L7e
        L98:
            if (r8 != r14) goto L9f
        L9a:
            if (r5 == r4) goto L9f
            int r5 = r5 + 1
            goto L6b
        L9f:
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.CombinedClickableNode.resetKeyPressState():void");
    }
}
