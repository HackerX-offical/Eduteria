package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: FocusInvalidationManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/focus/FocusOwner;Landroidx/compose/ui/node/Owner;)V", "focusTargetNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusEventNodes", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "isInvalidationScheduled", "", "scheduleInvalidation", "", NodeElement.ELEMENT, "hasPendingInvalidation", "invalidateNodes", "invalidateOwnerFocusState", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FocusInvalidationManager {
    public static final int $stable = 8;
    private final FocusOwner focusOwner;
    private boolean isInvalidationScheduled;
    private final Owner owner;
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();

    public FocusInvalidationManager(FocusOwner focusOwner, Owner owner) {
        this.focusOwner = focusOwner;
        this.owner = owner;
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        if (this.focusTargetNodes.add(node)) {
            scheduleInvalidation();
        }
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        if (this.focusEventNodes.add(node)) {
            scheduleInvalidation();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.focus.FocusInvalidationManager$scheduleInvalidation$1, reason: invalid class name */
    /* JADX INFO: compiled from: FocusInvalidationManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object obj) {
            super(0, obj, FocusInvalidationManager.class, "invalidateNodes", "invalidateNodes()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((FocusInvalidationManager) this.receiver).invalidateNodes();
        }
    }

    public final void scheduleInvalidation() {
        if (this.isInvalidationScheduled) {
            return;
        }
        this.owner.registerOnEndApplyChangesListener(new AnonymousClass1(this));
        this.isInvalidationScheduled = true;
    }

    /* JADX INFO: renamed from: hasPendingInvalidation, reason: from getter */
    public final boolean getIsInvalidationScheduled() {
        return this.isInvalidationScheduled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invalidateNodes() {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusInvalidationManager.invalidateNodes():void");
    }

    private final void invalidateOwnerFocusState() {
        if (this.focusOwner.getActiveFocusTargetNode() == null || this.focusOwner.getRootState() == FocusStateImpl.Inactive) {
            this.focusOwner.clearOwnerFocus();
        }
    }
}
