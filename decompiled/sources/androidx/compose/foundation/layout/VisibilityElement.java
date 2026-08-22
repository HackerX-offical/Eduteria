package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: Visible.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\f\u0010\u000b\u001a\u00020\t*\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/VisibilityElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/VisibilityNode;", "visible", "", "<init>", "(Z)V", "create", DiscoverItems.Item.UPDATE_ACTION, "", NodeElement.ELEMENT, "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "other", "", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class VisibilityElement extends ModifierNodeElement<VisibilityNode> {
    private final boolean visible;

    public VisibilityElement(boolean z) {
        this.visible = z;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public VisibilityNode create() {
        return new VisibilityNode(this.visible);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(VisibilityNode node) {
        boolean visible = node.getVisible();
        boolean z = this.visible;
        if (visible != z) {
            node.setVisible(z);
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("Visible");
        inspectorInfo.getProperties().set("Visible", Boolean.valueOf(this.visible));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return Boolean.hashCode(this.visible);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        VisibilityElement visibilityElement = other instanceof VisibilityElement ? (VisibilityElement) other : null;
        return visibilityElement != null && this.visible == visibilityElement.visible;
    }
}
