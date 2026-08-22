package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: RequestChildFocus.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"requestFocusForChildInRootBounds", "", "Landroidx/compose/ui/node/DelegatableNode;", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RequestChildFocusKt {
    public static final boolean requestFocusForChildInRootBounds(DelegatableNode delegatableNode, int i, int i2, int i3, int i4) {
        FocusTargetModifierNode focusTargetModifierNodeFindFocusableNodeFromRect$ui = DelegatableNodeKt.requireOwner(delegatableNode).getRectManager().findFocusableNodeFromRect$ui(i, i2, i3, i4, DelegatableNodeKt.requireLayoutNode(delegatableNode).getSemanticsId());
        if (focusTargetModifierNodeFindFocusableNodeFromRect$ui != null) {
            return FocusTargetModifierNode.m5630requestFocus3ESFkO8$default(focusTargetModifierNodeFindFocusableNodeFromRect$ui, 0, 1, null);
        }
        return false;
    }
}
