package androidx.compose.runtime.composer.linkbuffer;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: LinkAnchor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001a\u00060\bj\u0002`\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/AnchorHandle;", "", "groupAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "contextAnchor", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;)V", "toHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", InAppPurchaseConstants.METHOD_TO_STRING, "", "ownedBy", "", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "ownedBy$runtime", ReferenceElement.ATTR_ANCHOR, "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnchorHandle {
    public static final int $stable = 8;
    private final LinkAnchor contextAnchor;
    private final LinkAnchor groupAnchor;

    public AnchorHandle(LinkAnchor linkAnchor, LinkAnchor linkAnchor2) {
        this.groupAnchor = linkAnchor;
        this.contextAnchor = linkAnchor2;
    }

    public final long toHandle() {
        return (((long) UInt.m12488constructorimpl(this.groupAnchor.getAddress())) & 4294967295L) | (((long) this.contextAnchor.getAddress()) << 32);
    }

    public String toString() {
        return super.toString() + ": " + this.groupAnchor.getAddress() + ':' + this.contextAnchor.getAddress();
    }

    public final boolean ownedBy$runtime(SlotTableAddressSpace addressSpace) {
        return ownedBy(addressSpace, this.groupAnchor) && ownedBy(addressSpace, this.contextAnchor);
    }

    private final boolean ownedBy(SlotTableAddressSpace addressSpace, LinkAnchor anchor) {
        if (Intrinsics.areEqual(anchor, LinkAnchorKt.getNullAnchor()) || Intrinsics.areEqual(anchor, LinkAnchorKt.getLazyAnchor())) {
            return true;
        }
        return addressSpace.ownsAnchor(anchor);
    }
}
