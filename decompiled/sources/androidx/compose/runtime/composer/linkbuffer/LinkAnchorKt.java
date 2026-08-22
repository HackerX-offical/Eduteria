package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.ComposerKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

/* JADX INFO: compiled from: LinkAnchor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\b\u001a\u00020\t*\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\n2\u0006\u0010\b\u001a\u00020\tH\u0000\"\u0014\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"asLinkAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "Landroidx/compose/runtime/Anchor;", "NullAnchor", "getNullAnchor", "()Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "LazyAnchor", "getLazyAnchor", "anchorHandle", "Landroidx/compose/runtime/composer/linkbuffer/AnchorHandle;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "handle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "ownsHandle", "", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LinkAnchorKt {
    private static final LinkAnchor NullAnchor = new LinkAnchor(-1);
    private static final LinkAnchor LazyAnchor = new LinkAnchor(0);

    public static final LinkAnchor asLinkAnchor(Anchor anchor) {
        LinkAnchor linkAnchor = anchor instanceof LinkAnchor ? (LinkAnchor) anchor : null;
        if (linkAnchor != null) {
            return linkAnchor;
        }
        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    public static final LinkAnchor getNullAnchor() {
        return NullAnchor;
    }

    public static final LinkAnchor getLazyAnchor() {
        return LazyAnchor;
    }

    private static final LinkAnchor anchorHandle$anchorOf(SlotTableAddressSpace slotTableAddressSpace, int i) {
        if (i == -1) {
            return NullAnchor;
        }
        if (i == 0) {
            return LazyAnchor;
        }
        return slotTableAddressSpace.anchorOfAddress(i);
    }

    public static final AnchorHandle anchorHandle(SlotTableAddressSpace slotTableAddressSpace, long j) {
        return new AnchorHandle(anchorHandle$anchorOf(slotTableAddressSpace, GroupHandleKt.getGroup(j)), anchorHandle$anchorOf(slotTableAddressSpace, GroupHandleKt.getContext(j)));
    }

    public static final boolean ownsHandle(SlotTableAddressSpace slotTableAddressSpace, AnchorHandle anchorHandle) {
        return anchorHandle.ownedBy$runtime(slotTableAddressSpace);
    }
}
