package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: FocusOwnerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\b\u001aJ!\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0015H\u0016J/\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b)\u0010*J\u001a\u0010#\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0017\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010*J\u001f\u0010,\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0015H\u0016¢\u0006\u0004\b/\u00100J7\u00101\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u00192\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001504H\u0016¢\u0006\u0004\b5\u00106J%\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00152\u0006\u00108\u001a\u000209H\u0016¢\u0006\u0004\b?\u0010@J\u001e\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020C2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;H\u0016J\u0010\u0010D\u001a\u00020\u00152\u0006\u0010B\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020!H\u0016J\b\u0010G\u001a\u00020!H\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\tH\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020!H\u0016Jd\u0010L\u001a\u00020!\"\n\b\u0000\u0010M\u0018\u0001*\u00020N*\u00020N2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HM0P2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020!042\f\u0010R\u001a\b\u0012\u0004\u0012\u00020!0;2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u00020!04H\u0082\b¢\u0006\u0004\bT\u0010UJ0\u0010V\u001a\u0004\u0018\u0001HM\"\n\b\u0000\u0010M\u0018\u0001*\u00020W*\u00020N2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HM0PH\u0082\b¢\u0006\u0004\bX\u0010YJ\n\u0010Z\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010[\u001a\u00020\u0015H\u0016J\b\u0010\\\u001a\u00020\u0015H\u0016J\n\u0010]\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010o\u001a\u0004\u0018\u00010p*\u00020NH\u0002J\u0017\u0010q\u001a\u00020\u00152\u0006\u00108\u001a\u000209H\u0002¢\u0006\u0004\br\u0010@R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\u00020_8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR*\u0010h\u001a\u0004\u0018\u00010\t2\b\u0010g\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\rR$\u0010k\u001a\u00020\u00152\u0006\u0010g\u001a\u00020\u0015@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006s"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "platformFocusOwner", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/focus/PlatformFocusOwner;Landroidx/compose/ui/node/Owner;)V", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "requestOwnerFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-7o62pno", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "releaseFocus", "", "clearOwnerFocus", "clearFocus", "force", "refreshFocusEvents", "clearFocus-I7lrPNg", "(ZZZI)Z", "resetFocus", "resetFocus-3ESFkO8", "(I)Z", "forced", "moveFocus", "moveFocus-3ESFkO8", "wrapAroundForOneDimensionalFocus", "moveFocus-aToIllA", "(IZ)Z", "focusSearch", "focusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchInterceptedSoftKeyboardEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "dispatchIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "dispatchIndirectPointerCancel", "focusTargetAvailable", "scheduleInvalidation", NodeElement.ELEMENT, "Landroidx/compose/ui/focus/FocusEventModifierNode;", "scheduleInvalidationForOwner", "traverseAncestorsIncludingSelf", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "nearestAncestorIncludingSelf", "", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "getFocusRect", "hasFocusableContent", "hasNonInteropFocusableContent", "findFocusTargetNode", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "value", "activeFocusTargetNode", "getActiveFocusTargetNode", "setActiveFocusTargetNode", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private FocusTargetNode activeFocusTargetNode;
    private final FocusInvalidationManager focusInvalidationManager;
    private boolean isFocusCaptured;
    private MutableLongSet keysCurrentlyDown;
    private final Owner owner;
    private final PlatformFocusOwner platformFocusOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode(Focusability.INSTANCE.m5658getNeverLCbbffg(), false, null, null, 14, null);
    private final Modifier modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: create */
        public FocusTargetNode getNode() {
            return this.this$0.getRootFocusNode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.this$0.getRootFocusNode().hashCode();
        }
    };
    private final MutableObjectList<FocusListener> listeners = new MutableObjectList<>(1);

    /* JADX INFO: compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FocusOwnerImpl(PlatformFocusOwner platformFocusOwner, Owner owner) {
        this.platformFocusOwner = platformFocusOwner;
        this.owner = owner;
        this.focusInvalidationManager = new FocusInvalidationManager(this, owner);
    }

    /* JADX INFO: renamed from: getRootFocusNode$ui, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: requestOwnerFocus-7o62pno */
    public boolean mo5619requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return this.platformFocusOwner.mo5665requestOwnerFocus7o62pno(focusDirection, previouslyFocusedRect);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: takeFocus-aToIllA */
    public boolean mo5621takeFocusaToIllA(final int focusDirection, Rect previouslyFocusedRect) {
        Boolean boolMo5617focusSearchULY8qGw = mo5617focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo5632requestFocus3ESFkO8(focusDirection));
            }
        });
        if (boolMo5617focusSearchULY8qGw != null) {
            return boolMo5617focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
        if (!ComposeUiFlags.isOptimizedFocusEventDispatchEnabled || getActiveFocusTargetNode() == null) {
            return;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        setActiveFocusTargetNode(null);
        if (activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui(FocusStateImpl.Active, FocusStateImpl.Inactive);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearOwnerFocus() {
        this.platformFocusOwner.clearOwnerFocus();
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo5614clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m5604getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: clearFocus-I7lrPNg */
    public boolean mo5614clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        boolean zClearFocus;
        if (!force) {
            int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m5641performCustomClearFocusMxy_nc0(this.rootFocusNode, focusDirection).ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                zClearFocus = false;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                zClearFocus = clearFocus(force, refreshFocusEvents);
            }
        } else {
            zClearFocus = clearFocus(force, refreshFocusEvents);
        }
        if (zClearFocus && clearOwnerFocus) {
            clearOwnerFocus();
        }
        return zClearFocus;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: resetFocus-3ESFkO8 */
    public boolean mo5620resetFocus3ESFkO8(final int focusDirection) {
        if (!mo5614clearFocusI7lrPNg(false, true, false, focusDirection)) {
            return false;
        }
        Boolean boolMo5617focusSearchULY8qGw = mo5617focusSearchULY8qGw(focusDirection, null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$resetFocus$successfulReset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo5632requestFocus3ESFkO8(focusDirection));
            }
        });
        boolean zBooleanValue = boolMo5617focusSearchULY8qGw != null ? boolMo5617focusSearchULY8qGw.booleanValue() : false;
        if (!zBooleanValue) {
            clearOwnerFocus();
        }
        return zBooleanValue;
    }

    static /* synthetic */ boolean clearFocus$default(FocusOwnerImpl focusOwnerImpl, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return focusOwnerImpl.clearFocus(z, z2);
    }

    private final boolean clearFocus(boolean forced, boolean refreshFocusEvents) {
        NodeChain nodes;
        if (getActiveFocusTargetNode() == null) {
            return true;
        }
        if (getIsFocusCaptured() && !forced) {
            return false;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        setActiveFocusTargetNode(null);
        if (refreshFocusEvents && activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui(getIsFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active, FocusStateImpl.Inactive);
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int iM7763constructorimpl = NodeKind.m7763constructorimpl(1024);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            while (layoutNodeRequireLayoutNode != null) {
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM7763constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Modifier.Node nodePop = parent;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    ((FocusTargetNode) nodePop).dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                                } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                        if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* JADX INFO: renamed from: moveFocus-3ESFkO8 */
    public boolean mo5612moveFocus3ESFkO8(int focusDirection) {
        return mo5618moveFocusaToIllA(focusDirection, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: moveFocus-aToIllA */
    public boolean mo5618moveFocusaToIllA(final int focusDirection, boolean wrapAroundForOneDimensionalFocus) {
        FocusTargetNode activeFocusTargetNode;
        if ((ComposeUiFlags.isViewFocusFixEnabled || (ComposeUiFlags.isBypassUnfocusableComposeViewEnabled && (activeFocusTargetNode = getActiveFocusTargetNode()) != null && activeFocusTargetNode.getIsInteropViewHost())) && this.platformFocusOwner.mo5664moveFocusInChildren3ESFkO8(focusDirection)) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = false;
        FocusTargetNode activeFocusTargetNode2 = getActiveFocusTargetNode();
        Boolean boolMo5617focusSearchULY8qGw = mo5617focusSearchULY8qGw(focusDirection, this.platformFocusOwner.getEmbeddedViewFocusRect(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = Boolean.valueOf(focusTargetNode.mo5632requestFocus3ESFkO8(focusDirection));
                return objectRef.element;
            }
        });
        if (Intrinsics.areEqual((Object) boolMo5617focusSearchULY8qGw, (Object) true) && activeFocusTargetNode2 != getActiveFocusTargetNode()) {
            return true;
        }
        if (boolMo5617focusSearchULY8qGw != null && objectRef.element != 0) {
            if (boolMo5617focusSearchULY8qGw.booleanValue() && ((Boolean) objectRef.element).booleanValue()) {
                return true;
            }
            if (FocusOwnerImplKt.m5625is1dFocusSearch3ESFkO8(focusDirection) && wrapAroundForOneDimensionalFocus) {
                return mo5614clearFocusI7lrPNg(false, true, false, focusDirection) && mo5621takeFocusaToIllA(focusDirection, null);
            }
            if (!ComposeUiFlags.isViewFocusFixEnabled && !ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
                return this.platformFocusOwner.mo5664moveFocusInChildren3ESFkO8(focusDirection);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x00b8, code lost:
    
        continue;
     */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: focusSearch-ULY8qGw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Boolean mo5617focusSearchULY8qGw(int r18, androidx.compose.ui.geometry.Rect r19, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.focus.FocusTargetNode, java.lang.Boolean> r20) {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo5617focusSearchULY8qGw(int, androidx.compose.ui.geometry.Rect, kotlin.jvm.functions.Function1):java.lang.Boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f4 A[Catch: all -> 0x0394, TryCatch #0 {all -> 0x0394, blocks: (B:3:0x0009, B:5:0x0012, B:8:0x001d, B:12:0x0027, B:15:0x0036, B:118:0x01af, B:120:0x01bf, B:121:0x01c2, B:123:0x01d1, B:126:0x01e2, B:130:0x01ed, B:133:0x01f3, B:134:0x01fa, B:137:0x0202, B:139:0x0209, B:141:0x020d, B:143:0x0217, B:145:0x021e, B:147:0x0222, B:149:0x0228, B:152:0x0233, B:155:0x023d, B:156:0x0244, B:159:0x024c, B:160:0x0251, B:161:0x0256, B:163:0x025c, B:165:0x0262, B:168:0x026d, B:170:0x0278, B:177:0x028f, B:178:0x0291, B:180:0x0298, B:182:0x029c, B:208:0x02f2, B:186:0x02a8, B:188:0x02af, B:190:0x02b3, B:192:0x02bd, B:194:0x02c4, B:196:0x02c8, B:198:0x02ce, B:201:0x02d9, B:204:0x02e3, B:205:0x02ea, B:209:0x02f7, B:213:0x0307, B:215:0x030e, B:217:0x0312, B:243:0x0368, B:221:0x031e, B:223:0x0325, B:225:0x0329, B:227:0x0333, B:229:0x033a, B:231:0x033e, B:233:0x0344, B:236:0x034f, B:239:0x0359, B:240:0x0360, B:245:0x036f, B:247:0x0379, B:252:0x038c, B:253:0x038e, B:18:0x0041, B:20:0x0051, B:21:0x0054, B:23:0x005e, B:26:0x006f, B:30:0x007a, B:64:0x00ea, B:66:0x00ee, B:33:0x0080, B:35:0x0087, B:37:0x008b, B:39:0x0095, B:41:0x009c, B:43:0x00a0, B:45:0x00a6, B:48:0x00b1, B:51:0x00bb, B:52:0x00c2, B:55:0x00ca, B:56:0x00cf, B:57:0x00d4, B:59:0x00da, B:61:0x00e0, B:67:0x00f4, B:69:0x0106, B:70:0x0109, B:72:0x0117, B:75:0x0128, B:79:0x0133, B:113:0x01a3, B:115:0x01a7, B:82:0x0139, B:84:0x0140, B:86:0x0144, B:88:0x014e, B:90:0x0155, B:92:0x0159, B:94:0x015f, B:97:0x016a, B:100:0x0174, B:101:0x017b, B:104:0x0183, B:105:0x0188, B:106:0x018d, B:108:0x0193, B:110:0x0199), top: B:259:0x0009 }] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v30 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo5616dispatchKeyEventYhN2O0w(android.view.KeyEvent r17, kotlin.jvm.functions.Function0<java.lang.Boolean> r18) {
        /*
            Method dump skipped, instruction units count: 921
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo5616dispatchKeyEventYhN2O0w(android.view.KeyEvent, kotlin.jvm.functions.Function0):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo5615dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        NodeChain nodes;
        boolean z;
        ?? Pop;
        NodeChain nodes2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            FocusTargetNode focusTargetNode = focusTargetNodeFindActiveFocusNode;
            int iM7763constructorimpl = NodeKind.m7763constructorimpl(131072);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    Pop = 0;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM7763constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Pop = node;
                            while (Pop != 0) {
                                if (Pop instanceof SoftKeyboardInterceptionModifierNode) {
                                    break loop0;
                                }
                                if ((Pop.getKindSet() & iM7763constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) Pop).getDelegate();
                                    int i = 0;
                                    Pop = Pop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Unit unit = Unit.INSTANCE;
                                                Pop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    if (mutableVector != null) {
                                                        Boolean.valueOf(mutableVector.add(Pop));
                                                    }
                                                    Pop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    Boolean.valueOf(mutableVector.add(delegate));
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        Pop = Pop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Pop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) Pop;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode;
            int iM7763constructorimpl2 = NodeKind.m7763constructorimpl(131072);
            if (!softKeyboardInterceptionModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = softKeyboardInterceptionModifierNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode2);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM7763constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof SoftKeyboardInterceptionModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (nodePop.getKindSet() & iM7763constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM7763constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                Unit unit2 = Unit.INSTANCE;
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(nodePop));
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    Boolean.valueOf(mutableVector2.add(delegate2));
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (((SoftKeyboardInterceptionModifierNode) arrayList.get(size)).mo6820onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                            return true;
                        }
                        if (i3 < 0) {
                            break;
                        }
                        size = i3;
                    }
                }
                Unit unit3 = Unit.INSTANCE;
            }
            ?? node2 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node2 != 0) {
                if (node2 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node2).mo6820onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node2.getKindSet() & iM7763constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate();
                    int i4 = 0;
                    node2 = node2;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & iM7763constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                Unit unit4 = Unit.INSTANCE;
                                node2 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    if (mutableVector3 != null) {
                                        Boolean.valueOf(mutableVector3.add(node2));
                                    }
                                    node2 = 0;
                                }
                                if (mutableVector3 != null) {
                                    Boolean.valueOf(mutableVector3.add(delegate3));
                                }
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node2 = node2;
                    }
                    if (i4 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector3);
            }
            ?? node3 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node3 != 0) {
                if (node3 instanceof SoftKeyboardInterceptionModifierNode) {
                    if (((SoftKeyboardInterceptionModifierNode) node3).mo6819onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & iM7763constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = ((DelegatingNode) node3).getDelegate();
                    int i5 = 0;
                    node3 = node3;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & iM7763constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                Unit unit5 = Unit.INSTANCE;
                                node3 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    if (mutableVector4 != null) {
                                        Boolean.valueOf(mutableVector4.add(node3));
                                    }
                                    node3 = 0;
                                }
                                if (mutableVector4 != null) {
                                    Boolean.valueOf(mutableVector4.add(delegate4));
                                }
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node3 = node3;
                    }
                    if (i5 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i6)).mo6819onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                }
                Unit unit6 = Unit.INSTANCE;
            }
            Unit unit7 = Unit.INSTANCE;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event, Function0<Boolean> onFocusedItem) {
        RotaryInputModifierNode rotaryInputModifierNode;
        NodeChain nodes;
        boolean z;
        ?? Pop;
        NodeChain nodes2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode focusTargetNodeFindFocusTargetNode = findFocusTargetNode();
        if (focusTargetNodeFindFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = focusTargetNodeFindFocusTargetNode;
            int iM7763constructorimpl = NodeKind.m7763constructorimpl(16384);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    Pop = 0;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM7763constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Pop = node;
                            while (Pop != 0) {
                                if (Pop instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((Pop.getKindSet() & iM7763constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) Pop).getDelegate();
                                    int i = 0;
                                    Pop = Pop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Unit unit = Unit.INSTANCE;
                                                Pop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    if (mutableVector != null) {
                                                        Boolean.valueOf(mutableVector.add(Pop));
                                                    }
                                                    Pop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    Boolean.valueOf(mutableVector.add(delegate));
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        Pop = Pop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Pop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) Pop;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            RotaryInputModifierNode rotaryInputModifierNode2 = rotaryInputModifierNode;
            int iM7763constructorimpl2 = NodeKind.m7763constructorimpl(16384);
            if (!rotaryInputModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = rotaryInputModifierNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode2);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM7763constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (nodePop.getKindSet() & iM7763constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM7763constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                Unit unit2 = Unit.INSTANCE;
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(nodePop));
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    Boolean.valueOf(mutableVector2.add(delegate2));
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(event)) {
                            return true;
                        }
                        if (i3 < 0) {
                            break;
                        }
                        size = i3;
                    }
                }
                Unit unit3 = Unit.INSTANCE;
            }
            ?? node2 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node2 != 0) {
                if (node2 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node2).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node2.getKindSet() & iM7763constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate();
                    int i4 = 0;
                    node2 = node2;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & iM7763constructorimpl2) != 0) {
                            i4++;
                            if (i4 == 1) {
                                Unit unit4 = Unit.INSTANCE;
                                node2 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node2 != 0) {
                                    if (mutableVector3 != null) {
                                        Boolean.valueOf(mutableVector3.add(node2));
                                    }
                                    node2 = 0;
                                }
                                if (mutableVector3 != null) {
                                    Boolean.valueOf(mutableVector3.add(delegate3));
                                }
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node2 = node2;
                    }
                    if (i4 == 1) {
                    }
                }
                node2 = DelegatableNodeKt.pop(mutableVector3);
            }
            if (onFocusedItem.invoke().booleanValue()) {
                return true;
            }
            ?? node3 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node3 != 0) {
                if (node3 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node3).onRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & iM7763constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = ((DelegatingNode) node3).getDelegate();
                    int i5 = 0;
                    node3 = node3;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & iM7763constructorimpl2) != 0) {
                            i5++;
                            if (i5 == 1) {
                                Unit unit5 = Unit.INSTANCE;
                                node3 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    if (mutableVector4 != null) {
                                        Boolean.valueOf(mutableVector4.add(node3));
                                    }
                                    node3 = 0;
                                }
                                if (mutableVector4 != null) {
                                    Boolean.valueOf(mutableVector4.add(delegate4));
                                }
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node3 = node3;
                    }
                    if (i5 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if (((RotaryInputModifierNode) arrayList.get(i6)).onRotaryScrollEvent(event)) {
                        return true;
                    }
                }
                Unit unit6 = Unit.INSTANCE;
            }
            Unit unit7 = Unit.INSTANCE;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchIndirectPointerEvent(IndirectPointerEvent event) {
        IndirectPointerInputModifierNode indirectPointerInputModifierNode;
        int size;
        int size2;
        NodeChain nodes;
        boolean z;
        ?? Pop;
        NodeChain nodes2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching indirect pointer event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        if (activeFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int iM7763constructorimpl = NodeKind.m7763constructorimpl(2097152);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    Pop = 0;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM7763constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Pop = node;
                            while (Pop != 0) {
                                if (Pop instanceof IndirectPointerInputModifierNode) {
                                    break loop0;
                                }
                                if ((Pop.getKindSet() & iM7763constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) Pop).getDelegate();
                                    int i = 0;
                                    Pop = Pop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Pop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(Pop);
                                                    }
                                                    Pop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        Pop = Pop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Pop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            indirectPointerInputModifierNode = (IndirectPointerInputModifierNode) Pop;
        } else {
            indirectPointerInputModifierNode = null;
        }
        if (indirectPointerInputModifierNode != null) {
            IndirectPointerInputModifierNode indirectPointerInputModifierNode2 = indirectPointerInputModifierNode;
            int iM7763constructorimpl2 = NodeKind.m7763constructorimpl(2097152);
            if (!indirectPointerInputModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = indirectPointerInputModifierNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(indirectPointerInputModifierNode2);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM7763constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof IndirectPointerInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (nodePop.getKindSet() & iM7763constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM7763constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i3 = size2 - 1;
                    ((IndirectPointerInputModifierNode) arrayList.get(size2)).onIndirectPointerEvent(event, PointerEventPass.Initial);
                    if (i3 < 0) {
                        break;
                    }
                    size2 = i3;
                }
            }
            indirectPointerInputModifierNode.onIndirectPointerEvent(event, PointerEventPass.Initial);
            indirectPointerInputModifierNode.onIndirectPointerEvent(event, PointerEventPass.Main);
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    ((IndirectPointerInputModifierNode) arrayList.get(i4)).onIndirectPointerEvent(event, PointerEventPass.Main);
                }
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i5 = size - 1;
                    ((IndirectPointerInputModifierNode) arrayList.get(size)).onIndirectPointerEvent(event, PointerEventPass.Final);
                    if (i5 < 0) {
                        break;
                    }
                    size = i5;
                }
            }
            indirectPointerInputModifierNode.onIndirectPointerEvent(event, PointerEventPass.Final);
        }
        List<IndirectPointerInputChange> changes = event.getChanges();
        int size4 = changes.size();
        for (int i6 = 0; i6 < size4; i6++) {
            if (changes.get(i6).getIsConsumed()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public void dispatchIndirectPointerCancel() {
        IndirectPointerInputModifierNode indirectPointerInputModifierNode;
        NodeChain nodes;
        boolean z;
        ?? Pop;
        NodeChain nodes2;
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        if (activeFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int iM7763constructorimpl = NodeKind.m7763constructorimpl(2097152);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = focusTargetNode.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    Pop = 0;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & iM7763constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Pop = node;
                            while (Pop != 0) {
                                if (Pop instanceof IndirectPointerInputModifierNode) {
                                    break loop0;
                                }
                                if ((Pop.getKindSet() & iM7763constructorimpl) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) Pop).getDelegate();
                                    int i = 0;
                                    Pop = Pop;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                Pop = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (Pop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(Pop);
                                                    }
                                                    Pop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        Pop = Pop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                Pop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            indirectPointerInputModifierNode = (IndirectPointerInputModifierNode) Pop;
        } else {
            indirectPointerInputModifierNode = null;
        }
        if (indirectPointerInputModifierNode != null) {
            IndirectPointerInputModifierNode indirectPointerInputModifierNode2 = indirectPointerInputModifierNode;
            int iM7763constructorimpl2 = NodeKind.m7763constructorimpl(2097152);
            if (!indirectPointerInputModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = indirectPointerInputModifierNode2.getNode().getParent();
            LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(indirectPointerInputModifierNode2);
            ArrayList arrayList = null;
            while (layoutNodeRequireLayoutNode2 != null) {
                if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM7763constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & iM7763constructorimpl2) != 0) {
                            Modifier.Node nodePop = parent;
                            MutableVector mutableVector2 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof IndirectPointerInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(nodePop);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z && (nodePop.getKindSet() & iM7763constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & iM7763constructorimpl2) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(nodePop);
                                                    }
                                                    nodePop = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            indirectPointerInputModifierNode.onCancelIndirectPointerInput();
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((IndirectPointerInputModifierNode) arrayList.get(i3)).onCancelIndirectPointerInput();
                }
            }
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void focusTargetAvailable() {
        this.platformFocusOwner.focusTargetAvailable();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidationForOwner() {
        this.focusInvalidationManager.scheduleInvalidation();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindFocusTargetNode = findFocusTargetNode();
        if (focusTargetNodeFindFocusTargetNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindFocusTargetNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean hasFocusableContent() {
        if (!this.rootFocusNode.getIsAttached()) {
            return false;
        }
        FocusTargetNode focusTargetNode = this.rootFocusNode;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM7763constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.getIsAttached() && focusTargetNode2.fetchFocusProperties$ui().getCanFocus()) {
                                    return true;
                                }
                            } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean hasNonInteropFocusableContent() {
        if (!this.rootFocusNode.getIsAttached()) {
            return false;
        }
        FocusTargetNode focusTargetNode = this.rootFocusNode;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                for (Modifier.Node child2 = node; child2 != null && child2.getIsAttached(); child2 = child2.getChild()) {
                    if ((child2.getKindSet() & iM7763constructorimpl) != 0) {
                        Modifier.Node nodePop = child2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
                                if (focusTargetNode2.getIsAttached()) {
                                    FocusProperties focusPropertiesFetchFocusProperties$ui = focusTargetNode2.fetchFocusProperties$ui();
                                    if (focusTargetNode2.getIsAttached() && !focusTargetNode2.getIsInteropViewHost() && focusPropertiesFetchFocusProperties$ui.getCanFocus()) {
                                        return true;
                                    }
                                }
                            } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & iM7763constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
        return false;
    }

    private final FocusTargetNode findFocusTargetNode() {
        return FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public MutableObjectList<FocusListener> getListeners() {
        return this.listeners;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTargetNode getActiveFocusTargetNode() {
        FocusTargetNode focusTargetNode = this.activeFocusTargetNode;
        if (focusTargetNode == null || !focusTargetNode.getIsAttached()) {
            return null;
        }
        return this.activeFocusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            setFocusCaptured(false);
        }
        MutableObjectList<FocusListener> listeners2 = getListeners();
        Object[] objArr = listeners2.content;
        int i = listeners2._size;
        for (int i2 = 0; i2 < i; i2++) {
            ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* JADX INFO: renamed from: isFocusCaptured, reason: from getter */
    public boolean getIsFocusCaptured() {
        return this.isFocusCaptured;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setFocusCaptured(boolean z) {
        if (!((z && getActiveFocusTargetNode() == null) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot capture focus when the active focus target node is unset");
        }
        this.isFocusCaptured = z;
    }

    /* JADX INFO: renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m5624validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent);
        int iM7145getTypeZmokQxo = KeyEvent_androidKt.m7145getTypeZmokQxo(keyEvent);
        if (KeyEventType.m7137equalsimpl0(iM7145getTypeZmokQxo, KeyEventType.INSTANCE.m7141getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(jM7144getKeyZmokQxo);
        } else if (KeyEventType.m7137equalsimpl0(iM7145getTypeZmokQxo, KeyEventType.INSTANCE.m7142getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(jM7144getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(jM7144getKeyZmokQxo);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: traverseAncestorsIncludingSelf-QFhIj7k, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m5623traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        int i2;
        int size;
        NodeChain nodes;
        boolean z;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(nodePop);
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z && (nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        if (arrayList != null && arrayList.size() - 1 >= 0) {
            while (true) {
                int i4 = size - 1;
                function1.invoke((Object) arrayList.get(size));
                if (i4 < 0) {
                    break;
                } else {
                    size = i4;
                }
            }
        }
        Modifier.Node node = delegatableNode.getNode();
        MutableVector mutableVector2 = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node instanceof Object) {
                function1.invoke(node);
            } else if ((node.getKindSet() & i) != 0 && (node instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate2 = ((DelegatingNode) node).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                    if ((delegate2.getKindSet() & i) != 0) {
                        i5++;
                        if (i5 == 1) {
                            node = delegate2;
                        } else {
                            if (mutableVector2 == null) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector2 != null) {
                                mutableVector2.add(delegate2);
                            }
                        }
                    }
                }
                if (i5 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector2);
        }
        function0.invoke();
        Modifier.Node node2 = delegatableNode.getNode();
        MutableVector mutableVector3 = null;
        while (node2 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node2 instanceof Object) {
                function12.invoke(node2);
            } else if ((node2.getKindSet() & i) != 0 && (node2 instanceof DelegatingNode)) {
                int i6 = 0;
                for (Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                    if ((delegate3.getKindSet() & i) != 0) {
                        i6++;
                        if (i6 == 1) {
                            node2 = delegate3;
                        } else {
                            if (mutableVector3 == null) {
                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node2 != null) {
                                if (mutableVector3 != null) {
                                    mutableVector3.add(node2);
                                }
                                node2 = null;
                            }
                            if (mutableVector3 != null) {
                                mutableVector3.add(delegate3);
                            }
                        }
                    }
                }
                if (i6 == 1) {
                }
            }
            node2 = DelegatableNodeKt.pop(mutableVector3);
        }
        if (arrayList != null) {
            int size2 = arrayList.size();
            for (i2 = 0; i2 < size2; i2++) {
                function12.invoke((Object) arrayList.get(i2));
            }
        }
    }

    /* JADX INFO: renamed from: nearestAncestorIncludingSelf-64DMado, reason: not valid java name */
    private final /* synthetic */ <T> T m5622nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        Object obj = (T) node;
                        MutableVector mutableVector = null;
                        while (obj != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (obj instanceof Object) {
                                return (T) obj;
                            }
                            if ((((Modifier.Node) obj).getKindSet() & i) != 0 && (obj instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = obj.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            obj = (T) delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (obj != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(obj);
                                                }
                                                obj = (T) null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            obj = (T) DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(1024) | NodeKind.m7763constructorimpl(8192);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & iM7763constructorimpl) != 0) {
                    if ((NodeKind.m7763constructorimpl(1024) & child.getKindSet()) != 0) {
                        return node2;
                    }
                    node2 = child;
                }
            }
        }
        return node2;
    }
}
