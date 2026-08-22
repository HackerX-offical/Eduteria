package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: compiled from: RelativeLayoutBounds.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0'J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0000J&\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0019J\u0006\u00100\u001a\u00020)J\u001d\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b%\u0010!¨\u0006:"}, d2 = {"Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", NodeElement.ELEMENT, "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "(JJJJJ[FLandroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "[F", "positionInRoot", "getPositionInRoot-nOcc-ac", "()J", "positionInWindow", "getPositionInWindow-nOcc-ac", "positionInScreen", "getPositionInScreen-nOcc-ac", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", "getWidth", "()I", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight", "boundsInRoot", "Landroidx/compose/ui/unit/IntRect;", "getBoundsInRoot", "()Landroidx/compose/ui/unit/IntRect;", "boundsInWindow", "getBoundsInWindow", "boundsInScreen", "getBoundsInScreen", "calculateOcclusions", "", "fractionVisibleIn", "", "viewport", "fractionVisibleInRect", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "fractionVisibleInWindow", "fractionVisibleInWindowWithInsets", "topLeftInset", "bottomRightInset", "fractionVisibleInWindowWithInsets-E1MhUcY", "(JJ)F", "equals", "", "other", "hashCode", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RelativeLayoutBounds {
    public static final int $stable = 8;
    private final long bottomRight;
    private final DelegatableNode node;
    private final long screenOffset;
    private final long topLeft;
    private final float[] viewToWindowMatrix;
    private final long windowOffset;
    private final long windowSize;

    public /* synthetic */ RelativeLayoutBounds(long j, long j2, long j3, long j4, long j5, float[] fArr, DelegatableNode delegatableNode, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, fArr, delegatableNode);
    }

    private RelativeLayoutBounds(long j, long j2, long j3, long j4, long j5, float[] fArr, DelegatableNode delegatableNode) {
        this.topLeft = j;
        this.bottomRight = j2;
        this.windowOffset = j3;
        this.screenOffset = j4;
        this.windowSize = j5;
        this.viewToWindowMatrix = fArr;
        this.node = delegatableNode;
    }

    /* JADX INFO: renamed from: getPositionInRoot-nOcc-ac, reason: not valid java name */
    public final long m8043getPositionInRootnOccac() {
        return IntOffset.m8952constructorimpl(this.topLeft);
    }

    /* JADX INFO: renamed from: getPositionInWindow-nOcc-ac, reason: not valid java name */
    public final long m8045getPositionInWindownOccac() {
        int iM8958getXimpl = IntOffset.m8958getXimpl(this.screenOffset) - IntOffset.m8958getXimpl(this.windowOffset);
        int iM8959getYimpl = IntOffset.m8959getYimpl(this.screenOffset) - IntOffset.m8959getYimpl(this.windowOffset);
        long j = this.topLeft;
        return IntOffset.m8952constructorimpl((((long) (((int) (j >> 32)) + iM8958getXimpl)) << 32) | (((long) (((int) j) + iM8959getYimpl)) & 4294967295L));
    }

    /* JADX INFO: renamed from: getPositionInScreen-nOcc-ac, reason: not valid java name */
    public final long m8044getPositionInScreennOccac() {
        int iM8958getXimpl = IntOffset.m8958getXimpl(this.screenOffset);
        int iM8959getYimpl = IntOffset.m8959getYimpl(this.screenOffset);
        long j = this.topLeft;
        return IntOffset.m8952constructorimpl((((long) (((int) (j >> 32)) + iM8958getXimpl)) << 32) | (((long) (((int) j) + iM8959getYimpl)) & 4294967295L));
    }

    public final int getWidth() {
        return ((int) (this.bottomRight >> 32)) - ((int) (this.topLeft >> 32));
    }

    public final int getHeight() {
        return ((int) this.bottomRight) - ((int) this.topLeft);
    }

    public final IntRect getBoundsInRoot() {
        long j = this.topLeft;
        long j2 = this.bottomRight;
        return new IntRect((int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
    }

    public final IntRect getBoundsInWindow() {
        long j = this.topLeft;
        int i = (int) (j >> 32);
        int i2 = (int) j;
        long j2 = this.bottomRight;
        int i3 = (int) (j2 >> 32);
        int i4 = (int) j2;
        float[] fArr = this.viewToWindowMatrix;
        if (fArr != null) {
            return IntRectKt.roundToIntRect(Matrix.m6221mapimpl(fArr, new Rect(i, i2, i3, i4)));
        }
        int iM8958getXimpl = IntOffset.m8958getXimpl(this.screenOffset) - IntOffset.m8958getXimpl(this.windowOffset);
        int iM8959getYimpl = IntOffset.m8959getYimpl(this.screenOffset) - IntOffset.m8959getYimpl(this.windowOffset);
        return new IntRect(i + iM8958getXimpl, i2 + iM8959getYimpl, i3 + iM8958getXimpl, i4 + iM8959getYimpl);
    }

    public final IntRect getBoundsInScreen() {
        if (this.viewToWindowMatrix != null) {
            IntRect boundsInWindow = getBoundsInWindow();
            long j = this.windowOffset;
            return new IntRect(boundsInWindow.getLeft() + IntOffset.m8958getXimpl(j), boundsInWindow.getTop() + IntOffset.m8959getYimpl(j), boundsInWindow.getRight() + IntOffset.m8958getXimpl(j), boundsInWindow.getBottom() + IntOffset.m8959getYimpl(j));
        }
        long j2 = this.topLeft;
        int i = (int) (j2 >> 32);
        long j3 = this.bottomRight;
        int i2 = (int) (j3 >> 32);
        int i3 = (int) j3;
        int iM8958getXimpl = IntOffset.m8958getXimpl(this.screenOffset);
        int iM8959getYimpl = IntOffset.m8959getYimpl(this.screenOffset);
        return new IntRect(i + iM8958getXimpl, ((int) j2) + iM8959getYimpl, i2 + iM8958getXimpl, i3 + iM8959getYimpl);
    }

    public final List<IntRect> calculateOcclusions() {
        int i;
        int i2;
        RectManager rectManager = DelegatableNodeKt.requireOwner(this.node).getRectManager();
        int semanticsId = DelegatableNodeKt.requireLayoutNode(this.node).getSemanticsId();
        RectList rects = rectManager.getRects();
        int iIndexOf = rects.indexOf(semanticsId);
        if (iIndexOf < 0) {
            return CollectionsKt.emptyList();
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        long[] jArr = rects.items;
        int i3 = rects.itemsSize;
        long j = jArr[iIndexOf];
        long j2 = jArr[iIndexOf + 1];
        int i4 = 0;
        while (i4 < jArr.length - 2 && i4 < i3) {
            if (i4 == iIndexOf) {
                i4 += 3;
            } else {
                long j3 = jArr[i4];
                long j4 = jArr[i4 + 1];
                if (((((j2 - j3) - InlineClassHelperKt.Uint64Low32) | ((j4 - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    i = i3;
                    i2 = iIndexOf;
                    int i5 = (int) (j3 >> 32);
                    int i6 = (int) j3;
                    int i7 = (int) (j4 >> 32);
                    int i8 = (int) j4;
                    if (rectManager.isTargetDrawnFirst$ui(semanticsId, ((int) jArr[i4 + 2]) & 33554431)) {
                        listCreateListBuilder.add(new IntRect(i5, i6, i7, i8));
                    }
                } else {
                    i = i3;
                    i2 = iIndexOf;
                }
                i4 += 3;
                iIndexOf = i2;
                i3 = i;
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public final float fractionVisibleIn(RelativeLayoutBounds viewport) {
        long j = viewport.topLeft;
        long j2 = viewport.bottomRight;
        return fractionVisibleInRect((int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
    }

    public final float fractionVisibleInRect(int left, int top, int right, int bottom) {
        int iMin = Math.min(Math.max((int) (this.topLeft >> 32), left), right);
        int iMin2 = Math.min(Math.max((int) this.topLeft, top), bottom);
        int iMax = Math.max(Math.min((int) (this.bottomRight >> 32), right), left);
        int i = (int) this.bottomRight;
        return Math.max((iMax - iMin) * (Math.max(Math.min(i, bottom), top) - iMin2), 0) / Math.min((right - left) * (bottom - top), (r2 - r0) * (i - r3));
    }

    public final float fractionVisibleInWindow() {
        long j = this.windowSize;
        return fractionVisibleInRect(0, 0, (int) (j >> 32), (int) j);
    }

    /* JADX INFO: renamed from: fractionVisibleInWindowWithInsets-E1MhUcY, reason: not valid java name */
    public final float m8042fractionVisibleInWindowWithInsetsE1MhUcY(long topLeftInset, long bottomRightInset) {
        long j = this.windowSize;
        int iM8958getXimpl = IntOffset.m8958getXimpl(this.windowOffset);
        int iM8959getYimpl = IntOffset.m8959getYimpl(this.windowOffset);
        return fractionVisibleInRect(IntOffset.m8958getXimpl(topLeftInset) + iM8958getXimpl, IntOffset.m8959getYimpl(topLeftInset) + iM8959getYimpl, (iM8958getXimpl + ((int) (j >> 32))) - IntOffset.m8958getXimpl(bottomRightInset), (iM8959getYimpl + ((int) j)) - IntOffset.m8959getYimpl(bottomRightInset));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto L66
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L12
            goto L66
        L12:
            androidx.compose.ui.spatial.RelativeLayoutBounds r7 = (androidx.compose.ui.spatial.RelativeLayoutBounds) r7
            long r2 = r6.topLeft
            long r4 = r7.topLeft
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L1d
            return r1
        L1d:
            long r2 = r6.bottomRight
            long r4 = r7.bottomRight
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L26
            return r1
        L26:
            long r2 = r6.windowSize
            long r4 = r7.windowSize
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L2f
            return r1
        L2f:
            long r2 = r6.windowOffset
            long r4 = r7.windowOffset
            boolean r2 = androidx.compose.ui.unit.IntOffset.m8957equalsimpl0(r2, r4)
            if (r2 != 0) goto L3a
            return r1
        L3a:
            long r2 = r6.screenOffset
            long r4 = r7.screenOffset
            boolean r2 = androidx.compose.ui.unit.IntOffset.m8957equalsimpl0(r2, r4)
            if (r2 != 0) goto L45
            return r1
        L45:
            float[] r2 = r6.viewToWindowMatrix
            float[] r3 = r7.viewToWindowMatrix
            if (r2 != 0) goto L4f
            if (r3 != 0) goto L51
            r2 = r0
            goto L57
        L4f:
            if (r3 != 0) goto L53
        L51:
            r2 = r1
            goto L57
        L53:
            boolean r2 = androidx.compose.ui.graphics.Matrix.m6216equalsimpl0(r2, r3)
        L57:
            if (r2 != 0) goto L5a
            return r1
        L5a:
            androidx.compose.ui.node.DelegatableNode r2 = r6.node
            androidx.compose.ui.node.DelegatableNode r7 = r7.node
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r7)
            if (r7 != 0) goto L65
            return r1
        L65:
            return r0
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.RelativeLayoutBounds.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.topLeft) * 31) + Long.hashCode(this.bottomRight)) * 31) + Long.hashCode(this.windowSize)) * 31) + IntOffset.m8960hashCodeimpl(this.windowOffset)) * 31) + IntOffset.m8960hashCodeimpl(this.screenOffset)) * 31;
        float[] fArr = this.viewToWindowMatrix;
        return ((iHashCode + (fArr != null ? Matrix.m6218hashCodeimpl(fArr) : 0)) * 31) + this.node.hashCode();
    }
}
