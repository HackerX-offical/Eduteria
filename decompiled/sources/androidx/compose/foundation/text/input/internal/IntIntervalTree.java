package androidx.compose.foundation.text.input.internal;

import androidx.collection.MutableIntList;
import androidx.collection.MutableLongList;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: IntIntervalTree.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b-\b\u0001\u0018\u0000 }*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001}B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010'\u001a\u00020\n*\u00020\n¢\u0006\u0004\b(\u0010\fJ\u0011\u0010)\u001a\u00020\n*\u00020\n¢\u0006\u0004\b*\u0010\fJ!\u0010+\u001a\u00020,*\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b-\u0010.J3\u0010/\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u00101Jc\u0010G\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072K\u0010I\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020H0JJS\u0010M\u001a\u00020H2K\u0010I\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020H0JJ\u0006\u0010N\u001a\u00020HJ\b\u0010O\u001a\u00020HH\u0002J/\u0010P\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020H0QH\u0082\bJ/\u0010R\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020H0QH\u0082\bJ-\u0010S\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070QH\u0086\bJ#\u0010U\u001a\u00020,2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010VJ#\u0010W\u001a\u00020,2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010VJ'\u0010X\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\bY\u0010ZJ!\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\b\b\u0002\u0010]\u001a\u00020,H\u0002¢\u0006\u0004\b^\u0010_J\u001f\u0010`\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010a\u001a\u00020\nH\u0002¢\u0006\u0004\bb\u0010\u000eJ\u001f\u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020\n2\u0006\u0010]\u001a\u00020,H\u0002¢\u0006\u0004\be\u0010_J\b\u0010f\u001a\u00020HH\u0002J\u001f\u0010g\u001a\u00020H2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010h\u001a\u00020\nH\u0002¢\u0006\u0004\bi\u0010\u000eJ\u0017\u0010j\u001a\u00020H2\u0006\u0010\\\u001a\u00020\nH\u0002¢\u0006\u0004\bk\u0010=J\u0017\u0010l\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bm\u0010=J\u0017\u0010n\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bo\u0010=J\u0017\u0010p\u001a\u00020H2\u0006\u0010d\u001a\u00020\nH\u0002¢\u0006\u0004\bq\u0010=J\u0013\u0010r\u001a\u00020,2\b\u0010s\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010t\u001a\u00020\u0007H\u0016J\f\u0010u\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0006\u0010v\u001a\u00020,J\u001d\u0010w\u001a\u00020H*\u00060Bj\u0002`C2\u0006\u0010d\u001a\u00020\n¢\u0006\u0004\bx\u0010yJ\u0015\u0010z\u001a\u00020\n*\u00060Bj\u0002`C¢\u0006\u0004\b{\u0010|R0\u0010\t\u001a\u00060\u0007j\u0002`\b*\u00020\n2\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR(\u0010\u0015\u001a\u00020\n*\u00020\n2\u0006\u0010\u0006\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR(\u0010\u0018\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR(\u0010\u001b\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR(\u0010\u001e\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR(\u0010!\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u0004\u0018\u00018\u0000*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u000003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b;\u00108\"\u0004\b<\u0010=R\u0013\u0010?\u001a\u00020\n¢\u0006\n\n\u0002\u0010>\u001a\u0004\b@\u00108R\u0016\u0010A\u001a\n\u0018\u00010Bj\u0004\u0018\u0001`CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010D\u001a\u00060Bj\u0002`C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006~"}, d2 = {"Landroidx/compose/foundation/text/input/internal/IntIntervalTree;", ExifInterface.GPS_DIRECTION_TRUE, "", "source", "<init>", "(Landroidx/compose/foundation/text/input/internal/IntIntervalTree;)V", "value", "", "Landroidx/compose/foundation/text/input/internal/TreeColor;", "color", "Landroidx/compose/foundation/text/input/internal/Node;", "getColor-330cO7A", "(I)I", "setColor-9hnwElY", "(II)V", Message.Thread.PARENT_ATTRIBUTE_NAME, "getParent-bLpG9ms", "setParent-cfX_BQo", "left", "getLeft-bLpG9ms", "setLeft-cfX_BQo", "right", "getRight-bLpG9ms", "setRight-cfX_BQo", "start", "getStart-330cO7A", "setStart-9hnwElY", "end", "getEnd-330cO7A", "setEnd-9hnwElY", "min", "getMin-330cO7A", "setMin-9hnwElY", Constants.PRIORITY_MAX, "getMax-330cO7A", "setMax-9hnwElY", "item", "getItem-330cO7A", "(I)Ljava/lang/Object;", "lowestNode", "lowestNode-bLpG9ms", ES6Iterator.NEXT_METHOD, "next-bLpG9ms", "overlaps", "", "overlaps-XzpGiIY", "(III)Z", "Node", "Node-l-p996k", "(IILjava/lang/Object;I)I", FirebaseAnalytics.Param.ITEMS, "", "nodeInfo", "Landroidx/collection/MutableLongList;", "totalNodeCount", "getTotalNodeCount", "()I", "deletedNodeCount", "root", "getRoot-27flxzM", "setRoot-330cO7A", "(I)V", "I", "terminator", "getTerminator-27flxzM", "_tempArray", "Landroidx/collection/MutableIntList;", "Landroidx/compose/foundation/text/input/internal/NodeList;", "tempArray", "getTempArray", "()Landroidx/collection/MutableIntList;", "forEachIntervalInRange", "", BlockContactsIQ.ELEMENT, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "forAllIntervals", FasteningElement.ATTR_CLEAR, "cleanDeletedNodes", "forEachNodeInRange", "Lkotlin/Function1;", "forEachNodeMinMaxInRange", "mapIntervals", "mapper", "addInterval", "(Ljava/lang/Object;II)Z", "removeInterval", "findNode", "findNode-cKdZwxc", "(Ljava/lang/Object;II)I", "removeNode", TypedValues.AttributesType.S_TARGET, "cleanUp", "removeNode-9hnwElY", "(IZ)V", "transplant", "replacement", "transplant-cfX_BQo", "deleteNode", NodeElement.ELEMENT, "deleteNode-9hnwElY", "cleanDeletedNodesIfNeeded", "rebalanceAfterDeletion", "targetParent", "rebalanceAfterDeletion-cfX_BQo", "rebalanceAfterInsertion", "rebalanceAfterInsertion-330cO7A", "rotateLeft", "rotateLeft-330cO7A", "rotateRight", "rotateRight-330cO7A", "updateNodeMinMax", "updateNodeMinMax-330cO7A", "equals", "other", "hashCode", Constants.COPY_TYPE, "isEmpty", "add", "add-ZlWbn38", "(Landroidx/collection/MutableIntList;I)V", "pop", "pop-2SV_EgM", "(Landroidx/collection/MutableIntList;)I", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IntIntervalTree<T> {
    private static final int COLOR_PARENT = 0;
    private static final int LEFT_RIGHT = 1;
    private static final int MIN_MAX = 3;
    private static final int NODE_CLEANUP_SIZE_THRESHOLD = 64;
    private static final int START_END = 2;
    private static final int STRIDE = 4;
    private MutableIntList _tempArray;
    private int deletedNodeCount;
    private final List<T> items;
    private final MutableLongList nodeInfo;
    private int root;
    private final int terminator;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public IntIntervalTree() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public IntIntervalTree(IntIntervalTree<T> intIntervalTree) {
        if (intIntervalTree != null) {
            this.items = CollectionsKt.toMutableList((Collection) intIntervalTree.items);
            MutableLongList mutableLongList = new MutableLongList(intIntervalTree.nodeInfo._size);
            mutableLongList.addAll(mutableLongList._size, intIntervalTree.nodeInfo);
            this.nodeInfo = mutableLongList;
            this.terminator = intIntervalTree.terminator;
            this.root = intIntervalTree.root;
            this.deletedNodeCount = intIntervalTree.deletedNodeCount;
            return;
        }
        this.items = new ArrayList();
        this.nodeInfo = new MutableLongList(0, 1, null);
        int iM2008Nodelp996k = m2008Nodelp996k(Integer.MAX_VALUE, Integer.MIN_VALUE, null, 1);
        this.terminator = iM2008Nodelp996k;
        this.root = iM2008Nodelp996k;
        this.deletedNodeCount = 0;
    }

    public /* synthetic */ IntIntervalTree(IntIntervalTree intIntervalTree, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : intIntervalTree);
    }

    /* JADX INFO: renamed from: getColor-330cO7A, reason: not valid java name */
    public final int m2023getColor330cO7A(int i) {
        return (int) (this.nodeInfo.get(i) >> 32);
    }

    /* JADX INFO: renamed from: setColor-9hnwElY, reason: not valid java name */
    public final void m2037setColor9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.set(i, (((long) ((int) (mutableLongList.get(i) & 4294967295L))) & 4294967295L) | (((long) i2) << 32));
    }

    /* JADX INFO: renamed from: getParent-bLpG9ms, reason: not valid java name */
    public final int m2028getParentbLpG9ms(int i) {
        return Node.m2050constructorimpl((int) (this.nodeInfo.get(i) & 4294967295L));
    }

    /* JADX INFO: renamed from: setParent-cfX_BQo, reason: not valid java name */
    public final void m2042setParentcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.set(i, (((long) ((int) (mutableLongList.get(i) >> 32))) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getLeft-bLpG9ms, reason: not valid java name */
    public final int m2025getLeftbLpG9ms(int i) {
        return Node.m2050constructorimpl((int) (this.nodeInfo.get(i + 1) >> 32));
    }

    /* JADX INFO: renamed from: setLeft-cfX_BQo, reason: not valid java name */
    public final void m2039setLeftcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 1;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) & 4294967295L))) & 4294967295L) | (((long) i2) << 32));
    }

    /* JADX INFO: renamed from: getRight-bLpG9ms, reason: not valid java name */
    public final int m2029getRightbLpG9ms(int i) {
        return Node.m2050constructorimpl((int) (this.nodeInfo.get(i + 1) & 4294967295L));
    }

    /* JADX INFO: renamed from: setRight-cfX_BQo, reason: not valid java name */
    public final void m2043setRightcfX_BQo(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 1;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) >> 32))) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getStart-330cO7A, reason: not valid java name */
    public final int m2031getStart330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 2) >> 32);
    }

    /* JADX INFO: renamed from: setStart-9hnwElY, reason: not valid java name */
    public final void m2045setStart9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 2;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) & 4294967295L))) & 4294967295L) | (((long) i2) << 32));
    }

    /* JADX INFO: renamed from: getEnd-330cO7A, reason: not valid java name */
    public final int m2024getEnd330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 2) & 4294967295L);
    }

    /* JADX INFO: renamed from: setEnd-9hnwElY, reason: not valid java name */
    public final void m2038setEnd9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 2;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) >> 32))) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getMin-330cO7A, reason: not valid java name */
    public final int m2027getMin330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 3) >> 32);
    }

    /* JADX INFO: renamed from: setMin-9hnwElY, reason: not valid java name */
    public final void m2041setMin9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 3;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) & 4294967295L))) & 4294967295L) | (((long) i2) << 32));
    }

    /* JADX INFO: renamed from: getMax-330cO7A, reason: not valid java name */
    public final int m2026getMax330cO7A(int i) {
        return (int) (this.nodeInfo.get(i + 3) & 4294967295L);
    }

    /* JADX INFO: renamed from: setMax-9hnwElY, reason: not valid java name */
    public final void m2040setMax9hnwElY(int i, int i2) {
        MutableLongList mutableLongList = this.nodeInfo;
        int i3 = i + 3;
        mutableLongList.set(i3, (((long) ((int) (mutableLongList.get(i3) >> 32))) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getItem-330cO7A, reason: not valid java name */
    private final T m2013getItem330cO7A(int i) {
        return this.items.get(i / 4);
    }

    /* JADX INFO: renamed from: lowestNode-bLpG9ms, reason: not valid java name */
    public final int m2033lowestNodebLpG9ms(int i) {
        while (!Node.m2052equalsimpl0(m2025getLeftbLpG9ms(i), this.terminator)) {
            i = m2025getLeftbLpG9ms(i);
        }
        return i;
    }

    /* JADX INFO: renamed from: next-bLpG9ms, reason: not valid java name */
    public final int m2034nextbLpG9ms(int i) {
        if (!Node.m2052equalsimpl0(m2029getRightbLpG9ms(i), this.terminator)) {
            return m2033lowestNodebLpG9ms(m2029getRightbLpG9ms(i));
        }
        int iM2028getParentbLpG9ms = m2028getParentbLpG9ms(i);
        while (true) {
            int i2 = iM2028getParentbLpG9ms;
            int i3 = i;
            i = i2;
            if (Node.m2052equalsimpl0(i, this.terminator) || !Node.m2052equalsimpl0(i3, m2029getRightbLpG9ms(i))) {
                break;
            }
            iM2028getParentbLpG9ms = m2028getParentbLpG9ms(i);
        }
        return i;
    }

    /* JADX INFO: renamed from: overlaps-XzpGiIY, reason: not valid java name */
    public final boolean m2035overlapsXzpGiIY(int i, int i2, int i3) {
        return IntIntervalTreeKt.intersect(i2, i3, m2031getStart330cO7A(i), m2024getEnd330cO7A(i));
    }

    /* JADX INFO: renamed from: Node-l-p996k$default, reason: not valid java name */
    static /* synthetic */ int m2009Nodelp996k$default(IntIntervalTree intIntervalTree, int i, int i2, Object obj, int i3, int i4, Object obj2) {
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return intIntervalTree.m2008Nodelp996k(i, i2, obj, i3);
    }

    /* JADX INFO: renamed from: Node-l-p996k, reason: not valid java name */
    private final int m2008Nodelp996k(int start, int end, T item, int color) {
        int i = this.nodeInfo._size;
        this.nodeInfo.add((((long) color) << 32) | (((long) 0) & 4294967295L));
        this.nodeInfo.add(0L);
        long j = (((long) end) & 4294967295L) | (((long) start) << 32);
        this.nodeInfo.add(j);
        this.nodeInfo.add(j);
        this.items.add(item);
        return Node.m2050constructorimpl(i);
    }

    private final int getTotalNodeCount() {
        return this.nodeInfo._size / 4;
    }

    /* JADX INFO: renamed from: getRoot-27flxzM, reason: not valid java name and from getter */
    public final int getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: setRoot-330cO7A, reason: not valid java name */
    public final void m2044setRoot330cO7A(int i) {
        this.root = i;
    }

    /* JADX INFO: renamed from: getTerminator-27flxzM, reason: not valid java name and from getter */
    public final int getTerminator() {
        return this.terminator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableIntList getTempArray() {
        MutableIntList mutableIntList = this._tempArray;
        if (mutableIntList != null) {
            return mutableIntList;
        }
        MutableIntList mutableIntList2 = new MutableIntList(0, 1, null);
        this._tempArray = mutableIntList2;
        return mutableIntList2;
    }

    public final void forEachIntervalInRange(int start, int end, Function3<? super T, ? super Integer, ? super Integer, Unit> block) {
        MutableIntList tempArray = getTempArray();
        if (!Node.m2052equalsimpl0(getRoot(), getTerminator()) && m2026getMax330cO7A(getRoot()) >= start && m2027getMin330cO7A(getRoot()) <= end) {
            int root = getRoot();
            loop0: while (true) {
                char c2 = 0;
                while (!Node.m2052equalsimpl0(root, getTerminator())) {
                    if (c2 != 0) {
                        if (c2 == 1) {
                            int iM2050constructorimpl = Node.m2050constructorimpl(root);
                            if (m2035overlapsXzpGiIY(iM2050constructorimpl, start, end)) {
                                tempArray.add(iM2050constructorimpl);
                            }
                            if (Node.m2052equalsimpl0(m2029getRightbLpG9ms(root), getTerminator()) || m2026getMax330cO7A(m2029getRightbLpG9ms(root)) < start || m2027getMin330cO7A(m2029getRightbLpG9ms(root)) > end) {
                                c2 = 2;
                            } else {
                                root = m2029getRightbLpG9ms(root);
                            }
                        } else if (c2 == 2) {
                            if (!Node.m2052equalsimpl0(m2028getParentbLpG9ms(root), getTerminator())) {
                                c2 = Node.m2052equalsimpl0(root, m2025getLeftbLpG9ms(m2028getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                            }
                            root = m2028getParentbLpG9ms(root);
                        }
                    } else if (Node.m2052equalsimpl0(m2025getLeftbLpG9ms(root), getTerminator()) || m2026getMax330cO7A(m2025getLeftbLpG9ms(root)) < start) {
                        c2 = 1;
                    } else {
                        root = m2025getLeftbLpG9ms(root);
                    }
                }
                break loop0;
            }
        }
        tempArray.sort();
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i = mutableIntList._size;
        for (int i2 = 0; i2 < i; i2++) {
            int iM2050constructorimpl2 = Node.m2050constructorimpl(iArr[i2]);
            T tM2013getItem330cO7A = m2013getItem330cO7A(iM2050constructorimpl2);
            if (tM2013getItem330cO7A != null) {
                block.invoke(tM2013getItem330cO7A, Integer.valueOf(m2031getStart330cO7A(iM2050constructorimpl2)), Integer.valueOf(m2024getEnd330cO7A(iM2050constructorimpl2)));
            }
        }
        tempArray.clear();
    }

    public final void forAllIntervals(Function3<? super T, ? super Integer, ? super Integer, Unit> block) {
        if (Node.m2052equalsimpl0(this.root, this.terminator)) {
            return;
        }
        for (int i = 4; i < this.nodeInfo._size; i += 4) {
            int iM2050constructorimpl = Node.m2050constructorimpl(i);
            if (m2023getColor330cO7A(iM2050constructorimpl) != 2) {
                int iM2031getStart330cO7A = m2031getStart330cO7A(iM2050constructorimpl);
                int iM2024getEnd330cO7A = m2024getEnd330cO7A(iM2050constructorimpl);
                T tM2013getItem330cO7A = m2013getItem330cO7A(iM2050constructorimpl);
                if (tM2013getItem330cO7A != null) {
                    block.invoke(tM2013getItem330cO7A, Integer.valueOf(iM2031getStart330cO7A), Integer.valueOf(iM2024getEnd330cO7A));
                }
            }
        }
    }

    public final void clear() {
        this.root = this.terminator;
        MutableLongList mutableLongList = this.nodeInfo;
        mutableLongList.removeRange(4, mutableLongList._size);
        List<T> list = this.items;
        list.subList(1, list.size()).clear();
        this.deletedNodeCount = 0;
    }

    private final void cleanDeletedNodes() {
        int i;
        if (this.deletedNodeCount == 0) {
            return;
        }
        MutableIntList tempArray = getTempArray();
        tempArray.ensureCapacity(getTotalNodeCount());
        int totalNodeCount = getTotalNodeCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = 4;
            if (i2 >= totalNodeCount) {
                break;
            }
            if (((int) (this.nodeInfo.get(i2 * 4) >> 32)) == 2) {
                i3++;
            }
            tempArray.add((i2 - i3) * 4);
            i2++;
        }
        this.root = Node.m2050constructorimpl(cleanDeletedNodes$map(tempArray, this.root));
        int i4 = 4;
        while (i < this.nodeInfo._size) {
            if (((int) (this.nodeInfo.get(i) >> 32)) == 2) {
                i += 4;
            } else {
                if (i4 != i) {
                    long j = this.nodeInfo.get(i);
                    this.nodeInfo.set(i4, (((long) ((int) (j >> 32))) << 32) | (((long) cleanDeletedNodes$map(tempArray, (int) (j & 4294967295L))) & 4294967295L));
                    long j2 = this.nodeInfo.get(i + 1);
                    this.nodeInfo.set(i4 + 1, (((long) cleanDeletedNodes$map(tempArray, (int) (j2 & 4294967295L))) & 4294967295L) | (((long) cleanDeletedNodes$map(tempArray, (int) (j2 >> 32))) << 32));
                    MutableLongList mutableLongList = this.nodeInfo;
                    mutableLongList.set(i4 + 2, mutableLongList.get(i + 2));
                    MutableLongList mutableLongList2 = this.nodeInfo;
                    mutableLongList2.set(i4 + 3, mutableLongList2.get(i + 3));
                    List<T> list = this.items;
                    list.set(i4 / 4, list.get(i / 4));
                } else {
                    long j3 = this.nodeInfo.get(i);
                    this.nodeInfo.set(i4, (((long) ((int) (j3 >> 32))) << 32) | (((long) cleanDeletedNodes$map(tempArray, (int) (j3 & 4294967295L))) & 4294967295L));
                    long j4 = this.nodeInfo.get(i + 1);
                    this.nodeInfo.set(i4 + 1, (((long) cleanDeletedNodes$map(tempArray, (int) (j4 >> 32))) << 32) | (((long) cleanDeletedNodes$map(tempArray, (int) (j4 & 4294967295L))) & 4294967295L));
                }
                i += 4;
                i4 += 4;
            }
        }
        MutableLongList mutableLongList3 = this.nodeInfo;
        mutableLongList3.removeRange(i4, mutableLongList3._size);
        List<T> list2 = this.items;
        list2.subList(list2.size() - this.deletedNodeCount, this.items.size()).clear();
        this.deletedNodeCount = 0;
        tempArray.clear();
    }

    private static final int cleanDeletedNodes$map(MutableIntList mutableIntList, int i) {
        return mutableIntList.get(i / 4);
    }

    private final void forEachNodeMinMaxInRange(int start, int end, Function1<? super Integer, Unit> block) {
        if (Node.m2052equalsimpl0(getRoot(), getTerminator()) || m2026getMax330cO7A(getRoot()) < start || m2027getMin330cO7A(getRoot()) > end) {
            return;
        }
        int root = getRoot();
        while (true) {
            char c2 = 0;
            while (!Node.m2052equalsimpl0(root, getTerminator())) {
                if (c2 != 0) {
                    if (c2 == 1) {
                        block.invoke(Integer.valueOf(root));
                        if (Node.m2052equalsimpl0(m2029getRightbLpG9ms(root), getTerminator()) || m2026getMax330cO7A(m2029getRightbLpG9ms(root)) < start || m2027getMin330cO7A(m2029getRightbLpG9ms(root)) > end) {
                            c2 = 2;
                        } else {
                            root = m2029getRightbLpG9ms(root);
                        }
                    } else if (c2 == 2) {
                        if (!Node.m2052equalsimpl0(m2028getParentbLpG9ms(root), getTerminator())) {
                            c2 = Node.m2052equalsimpl0(root, m2025getLeftbLpG9ms(m2028getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                        }
                        root = m2028getParentbLpG9ms(root);
                    }
                } else if (Node.m2052equalsimpl0(m2025getLeftbLpG9ms(root), getTerminator()) || m2026getMax330cO7A(m2025getLeftbLpG9ms(root)) < start) {
                    c2 = 1;
                } else {
                    root = m2025getLeftbLpG9ms(root);
                }
            }
            return;
        }
    }

    static /* synthetic */ void forEachNodeMinMaxInRange$default(IntIntervalTree intIntervalTree, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        if (Node.m2052equalsimpl0(intIntervalTree.getRoot(), intIntervalTree.getTerminator()) || intIntervalTree.m2026getMax330cO7A(intIntervalTree.getRoot()) < i || intIntervalTree.m2027getMin330cO7A(intIntervalTree.getRoot()) > i2) {
            return;
        }
        int root = intIntervalTree.getRoot();
        while (true) {
            char c2 = 0;
            while (!Node.m2052equalsimpl0(root, intIntervalTree.getTerminator())) {
                if (c2 != 0) {
                    if (c2 == 1) {
                        function1.invoke(Integer.valueOf(root));
                        if (Node.m2052equalsimpl0(intIntervalTree.m2029getRightbLpG9ms(root), intIntervalTree.getTerminator()) || intIntervalTree.m2026getMax330cO7A(intIntervalTree.m2029getRightbLpG9ms(root)) < i || intIntervalTree.m2027getMin330cO7A(intIntervalTree.m2029getRightbLpG9ms(root)) > i2) {
                            c2 = 2;
                        } else {
                            root = intIntervalTree.m2029getRightbLpG9ms(root);
                        }
                    } else if (c2 == 2) {
                        if (!Node.m2052equalsimpl0(intIntervalTree.m2028getParentbLpG9ms(root), intIntervalTree.getTerminator())) {
                            c2 = Node.m2052equalsimpl0(root, intIntervalTree.m2025getLeftbLpG9ms(intIntervalTree.m2028getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                        }
                        root = intIntervalTree.m2028getParentbLpG9ms(root);
                    }
                } else if (Node.m2052equalsimpl0(intIntervalTree.m2025getLeftbLpG9ms(root), intIntervalTree.getTerminator()) || intIntervalTree.m2026getMax330cO7A(intIntervalTree.m2025getLeftbLpG9ms(root)) < i) {
                    c2 = 1;
                } else {
                    root = intIntervalTree.m2025getLeftbLpG9ms(root);
                }
            }
            return;
        }
    }

    public final void mapIntervals(int start, int end, Function1<? super Integer, Integer> mapper) {
        MutableIntList tempArray = getTempArray();
        if (!Node.m2052equalsimpl0(getRoot(), getTerminator()) && m2026getMax330cO7A(getRoot()) >= start && m2027getMin330cO7A(getRoot()) <= end) {
            int root = getRoot();
            loop0: while (true) {
                char c2 = 0;
                while (!Node.m2052equalsimpl0(root, getTerminator())) {
                    if (c2 != 0) {
                        if (c2 == 1) {
                            int iM2050constructorimpl = Node.m2050constructorimpl(root);
                            m2045setStart9hnwElY(iM2050constructorimpl, mapper.invoke(Integer.valueOf(m2031getStart330cO7A(iM2050constructorimpl))).intValue());
                            m2038setEnd9hnwElY(iM2050constructorimpl, mapper.invoke(Integer.valueOf(m2024getEnd330cO7A(iM2050constructorimpl))).intValue());
                            m2041setMin9hnwElY(iM2050constructorimpl, mapper.invoke(Integer.valueOf(m2027getMin330cO7A(iM2050constructorimpl))).intValue());
                            m2040setMax9hnwElY(iM2050constructorimpl, mapper.invoke(Integer.valueOf(m2026getMax330cO7A(iM2050constructorimpl))).intValue());
                            if (m2024getEnd330cO7A(iM2050constructorimpl) <= m2031getStart330cO7A(iM2050constructorimpl)) {
                                m2022addZlWbn38(tempArray, iM2050constructorimpl);
                            }
                            if (Node.m2052equalsimpl0(m2029getRightbLpG9ms(root), getTerminator()) || m2026getMax330cO7A(m2029getRightbLpG9ms(root)) < start || m2027getMin330cO7A(m2029getRightbLpG9ms(root)) > end) {
                                c2 = 2;
                            } else {
                                root = m2029getRightbLpG9ms(root);
                            }
                        } else if (c2 == 2) {
                            if (!Node.m2052equalsimpl0(m2028getParentbLpG9ms(root), getTerminator())) {
                                c2 = Node.m2052equalsimpl0(root, m2025getLeftbLpG9ms(m2028getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                            }
                            root = m2028getParentbLpG9ms(root);
                        }
                    } else if (Node.m2052equalsimpl0(m2025getLeftbLpG9ms(root), getTerminator()) || m2026getMax330cO7A(m2025getLeftbLpG9ms(root)) < start) {
                        c2 = 1;
                    } else {
                        root = m2025getLeftbLpG9ms(root);
                    }
                }
                break loop0;
            }
        }
        MutableIntList mutableIntList = tempArray;
        int[] iArr = mutableIntList.content;
        int i = mutableIntList._size;
        for (int i2 = 0; i2 < i; i2++) {
            m2016removeNode9hnwElY(Node.m2050constructorimpl(iArr[i2]), false);
        }
        tempArray.clear();
        cleanDeletedNodesIfNeeded();
    }

    public final boolean addInterval(T item, int start, int end) {
        int iM2029getRightbLpG9ms;
        if (start >= end || !Node.m2052equalsimpl0(m2012findNodecKdZwxc(item, start, end), this.terminator)) {
            return false;
        }
        int iM2008Nodelp996k = m2008Nodelp996k(start, end, item, 0);
        int i = this.root;
        int i2 = this.terminator;
        while (!Node.m2052equalsimpl0(i, this.terminator)) {
            if (m2031getStart330cO7A(iM2008Nodelp996k) <= m2031getStart330cO7A(i)) {
                iM2029getRightbLpG9ms = m2025getLeftbLpG9ms(i);
            } else {
                iM2029getRightbLpG9ms = m2029getRightbLpG9ms(i);
            }
            int i3 = iM2029getRightbLpG9ms;
            i2 = i;
            i = i3;
        }
        m2042setParentcfX_BQo(iM2008Nodelp996k, i2);
        if (Node.m2052equalsimpl0(i2, this.terminator)) {
            this.root = iM2008Nodelp996k;
        } else if (m2031getStart330cO7A(iM2008Nodelp996k) <= m2031getStart330cO7A(i2)) {
            m2039setLeftcfX_BQo(i2, iM2008Nodelp996k);
        } else {
            m2043setRightcfX_BQo(i2, iM2008Nodelp996k);
        }
        m2021updateNodeMinMax330cO7A(i2);
        m2015rebalanceAfterInsertion330cO7A(iM2008Nodelp996k);
        return true;
    }

    public final boolean removeInterval(T item, int start, int end) {
        if (start >= end) {
            return false;
        }
        int iM2012findNodecKdZwxc = m2012findNodecKdZwxc(item, start, end);
        if (Node.m2052equalsimpl0(iM2012findNodecKdZwxc, this.terminator)) {
            return false;
        }
        m2017removeNode9hnwElY$default(this, iM2012findNodecKdZwxc, false, 2, null);
        return true;
    }

    /* JADX INFO: renamed from: findNode-cKdZwxc, reason: not valid java name */
    private final int m2012findNodecKdZwxc(T item, int start, int end) {
        if (Node.m2052equalsimpl0(this.root, this.terminator) || m2026getMax330cO7A(this.root) < end || m2027getMin330cO7A(this.root) > start) {
            return this.terminator;
        }
        MutableIntList tempArray = getTempArray();
        m2022addZlWbn38(tempArray, this.root);
        while (tempArray._size != 0) {
            int iM2036pop2SV_EgM = m2036pop2SV_EgM(tempArray);
            if (m2031getStart330cO7A(iM2036pop2SV_EgM) == start && m2024getEnd330cO7A(iM2036pop2SV_EgM) == end && Intrinsics.areEqual(m2013getItem330cO7A(iM2036pop2SV_EgM), item)) {
                tempArray.clear();
                return iM2036pop2SV_EgM;
            }
            if (m2031getStart330cO7A(iM2036pop2SV_EgM) >= start) {
                int iM2025getLeftbLpG9ms = m2025getLeftbLpG9ms(iM2036pop2SV_EgM);
                if (!Node.m2052equalsimpl0(iM2025getLeftbLpG9ms, this.terminator) && m2026getMax330cO7A(iM2025getLeftbLpG9ms) >= end) {
                    m2022addZlWbn38(tempArray, iM2025getLeftbLpG9ms);
                }
            }
            if (m2031getStart330cO7A(iM2036pop2SV_EgM) <= start) {
                int iM2029getRightbLpG9ms = m2029getRightbLpG9ms(iM2036pop2SV_EgM);
                if (!Node.m2052equalsimpl0(iM2029getRightbLpG9ms, this.terminator) && m2027getMin330cO7A(iM2029getRightbLpG9ms) <= start && m2026getMax330cO7A(iM2029getRightbLpG9ms) >= end) {
                    m2022addZlWbn38(tempArray, iM2029getRightbLpG9ms);
                }
            }
        }
        return this.terminator;
    }

    /* JADX INFO: renamed from: removeNode-9hnwElY$default, reason: not valid java name */
    static /* synthetic */ void m2017removeNode9hnwElY$default(IntIntervalTree intIntervalTree, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        intIntervalTree.m2016removeNode9hnwElY(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: removeNode-9hnwElY, reason: not valid java name */
    public final void m2016removeNode9hnwElY(int target, boolean cleanUp) {
        int iM2028getParentbLpG9ms;
        int iM2025getLeftbLpG9ms;
        int iM2028getParentbLpG9ms2;
        int iM2023getColor330cO7A = m2023getColor330cO7A(target);
        if (Node.m2052equalsimpl0(m2025getLeftbLpG9ms(target), this.terminator)) {
            iM2025getLeftbLpG9ms = m2029getRightbLpG9ms(target);
            iM2028getParentbLpG9ms2 = m2028getParentbLpG9ms(target);
            m2020transplantcfX_BQo(target, m2029getRightbLpG9ms(target));
        } else if (Node.m2052equalsimpl0(m2029getRightbLpG9ms(target), this.terminator)) {
            iM2025getLeftbLpG9ms = m2025getLeftbLpG9ms(target);
            iM2028getParentbLpG9ms2 = m2028getParentbLpG9ms(target);
            m2020transplantcfX_BQo(target, m2025getLeftbLpG9ms(target));
        } else {
            int iM2033lowestNodebLpG9ms = m2033lowestNodebLpG9ms(m2029getRightbLpG9ms(target));
            int iM2023getColor330cO7A2 = m2023getColor330cO7A(iM2033lowestNodebLpG9ms);
            int iM2029getRightbLpG9ms = m2029getRightbLpG9ms(iM2033lowestNodebLpG9ms);
            if (Node.m2052equalsimpl0(m2028getParentbLpG9ms(iM2033lowestNodebLpG9ms), target)) {
                iM2028getParentbLpG9ms = iM2033lowestNodebLpG9ms;
            } else {
                iM2028getParentbLpG9ms = m2028getParentbLpG9ms(iM2033lowestNodebLpG9ms);
                m2020transplantcfX_BQo(iM2033lowestNodebLpG9ms, m2029getRightbLpG9ms(iM2033lowestNodebLpG9ms));
                m2043setRightcfX_BQo(iM2033lowestNodebLpG9ms, m2029getRightbLpG9ms(target));
                m2042setParentcfX_BQo(m2029getRightbLpG9ms(iM2033lowestNodebLpG9ms), iM2033lowestNodebLpG9ms);
            }
            m2020transplantcfX_BQo(target, iM2033lowestNodebLpG9ms);
            m2039setLeftcfX_BQo(iM2033lowestNodebLpG9ms, m2025getLeftbLpG9ms(target));
            m2042setParentcfX_BQo(m2025getLeftbLpG9ms(iM2033lowestNodebLpG9ms), iM2033lowestNodebLpG9ms);
            m2037setColor9hnwElY(iM2033lowestNodebLpG9ms, m2023getColor330cO7A(target));
            m2041setMin9hnwElY(iM2033lowestNodebLpG9ms, m2027getMin330cO7A(target));
            m2040setMax9hnwElY(iM2033lowestNodebLpG9ms, m2026getMax330cO7A(target));
            iM2023getColor330cO7A = iM2023getColor330cO7A2;
            iM2025getLeftbLpG9ms = iM2029getRightbLpG9ms;
            iM2028getParentbLpG9ms2 = iM2028getParentbLpG9ms;
        }
        m2021updateNodeMinMax330cO7A(iM2028getParentbLpG9ms2);
        if (iM2023getColor330cO7A == 1) {
            m2014rebalanceAfterDeletioncfX_BQo(iM2025getLeftbLpG9ms, iM2028getParentbLpG9ms2);
        }
        m2011deleteNode9hnwElY(target, cleanUp);
    }

    /* JADX INFO: renamed from: transplant-cfX_BQo, reason: not valid java name */
    private final void m2020transplantcfX_BQo(int target, int replacement) {
        if (Node.m2052equalsimpl0(target, replacement)) {
            return;
        }
        if (Node.m2052equalsimpl0(m2028getParentbLpG9ms(target), this.terminator)) {
            this.root = replacement;
        } else if (Node.m2052equalsimpl0(target, m2025getLeftbLpG9ms(m2028getParentbLpG9ms(target)))) {
            m2039setLeftcfX_BQo(m2028getParentbLpG9ms(target), replacement);
        } else {
            m2043setRightcfX_BQo(m2028getParentbLpG9ms(target), replacement);
        }
        if (Node.m2052equalsimpl0(replacement, this.terminator)) {
            return;
        }
        m2042setParentcfX_BQo(replacement, m2028getParentbLpG9ms(target));
    }

    /* JADX INFO: renamed from: deleteNode-9hnwElY, reason: not valid java name */
    private final void m2011deleteNode9hnwElY(int node, boolean cleanUp) {
        m2037setColor9hnwElY(node, 2);
        this.deletedNodeCount++;
        if (cleanUp) {
            cleanDeletedNodesIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanDeletedNodesIfNeeded() {
        if (getTotalNodeCount() <= 64 || this.deletedNodeCount < getTotalNodeCount() / 2) {
            return;
        }
        cleanDeletedNodes();
    }

    /* JADX INFO: renamed from: rebalanceAfterDeletion-cfX_BQo, reason: not valid java name */
    private final void m2014rebalanceAfterDeletioncfX_BQo(int target, int targetParent) {
        int iM2028getParentbLpG9ms;
        while (!Node.m2052equalsimpl0(target, this.root) && m2023getColor330cO7A(target) == 1) {
            if (Node.m2052equalsimpl0(target, m2025getLeftbLpG9ms(targetParent))) {
                int iM2029getRightbLpG9ms = m2029getRightbLpG9ms(targetParent);
                if (m2023getColor330cO7A(iM2029getRightbLpG9ms) == 0) {
                    m2037setColor9hnwElY(iM2029getRightbLpG9ms, 1);
                    m2037setColor9hnwElY(targetParent, 0);
                    m2018rotateLeft330cO7A(targetParent);
                    iM2029getRightbLpG9ms = m2029getRightbLpG9ms(targetParent);
                }
                if (m2023getColor330cO7A(m2025getLeftbLpG9ms(iM2029getRightbLpG9ms)) == 1 && m2023getColor330cO7A(m2029getRightbLpG9ms(iM2029getRightbLpG9ms)) == 1) {
                    m2037setColor9hnwElY(iM2029getRightbLpG9ms, 0);
                    iM2028getParentbLpG9ms = m2028getParentbLpG9ms(targetParent);
                    int i = targetParent;
                    targetParent = iM2028getParentbLpG9ms;
                    target = i;
                } else {
                    if (m2023getColor330cO7A(m2029getRightbLpG9ms(iM2029getRightbLpG9ms)) == 1) {
                        m2037setColor9hnwElY(m2025getLeftbLpG9ms(iM2029getRightbLpG9ms), 1);
                        m2037setColor9hnwElY(iM2029getRightbLpG9ms, 0);
                        m2019rotateRight330cO7A(iM2029getRightbLpG9ms);
                        iM2029getRightbLpG9ms = m2029getRightbLpG9ms(targetParent);
                    }
                    m2037setColor9hnwElY(iM2029getRightbLpG9ms, m2023getColor330cO7A(targetParent));
                    m2037setColor9hnwElY(targetParent, 1);
                    m2037setColor9hnwElY(m2029getRightbLpG9ms(iM2029getRightbLpG9ms), 1);
                    m2018rotateLeft330cO7A(targetParent);
                    target = this.root;
                }
            } else {
                int iM2025getLeftbLpG9ms = m2025getLeftbLpG9ms(targetParent);
                if (m2023getColor330cO7A(iM2025getLeftbLpG9ms) == 0) {
                    m2037setColor9hnwElY(iM2025getLeftbLpG9ms, 1);
                    m2037setColor9hnwElY(targetParent, 0);
                    m2019rotateRight330cO7A(targetParent);
                    iM2025getLeftbLpG9ms = m2025getLeftbLpG9ms(targetParent);
                }
                if (m2023getColor330cO7A(m2029getRightbLpG9ms(iM2025getLeftbLpG9ms)) == 1 && m2023getColor330cO7A(m2025getLeftbLpG9ms(iM2025getLeftbLpG9ms)) == 1) {
                    m2037setColor9hnwElY(iM2025getLeftbLpG9ms, 0);
                    iM2028getParentbLpG9ms = m2028getParentbLpG9ms(targetParent);
                    int i2 = targetParent;
                    targetParent = iM2028getParentbLpG9ms;
                    target = i2;
                } else {
                    if (m2023getColor330cO7A(m2025getLeftbLpG9ms(iM2025getLeftbLpG9ms)) == 1) {
                        m2037setColor9hnwElY(m2029getRightbLpG9ms(iM2025getLeftbLpG9ms), 1);
                        m2037setColor9hnwElY(iM2025getLeftbLpG9ms, 0);
                        m2018rotateLeft330cO7A(iM2025getLeftbLpG9ms);
                        iM2025getLeftbLpG9ms = m2025getLeftbLpG9ms(targetParent);
                    }
                    m2037setColor9hnwElY(iM2025getLeftbLpG9ms, m2023getColor330cO7A(targetParent));
                    m2037setColor9hnwElY(targetParent, 1);
                    m2037setColor9hnwElY(m2025getLeftbLpG9ms(iM2025getLeftbLpG9ms), 1);
                    m2019rotateRight330cO7A(targetParent);
                    target = this.root;
                }
            }
        }
        m2037setColor9hnwElY(target, 1);
    }

    /* JADX INFO: renamed from: rebalanceAfterInsertion-330cO7A, reason: not valid java name */
    private final void m2015rebalanceAfterInsertion330cO7A(int target) {
        while (!Node.m2052equalsimpl0(target, this.root) && m2023getColor330cO7A(m2028getParentbLpG9ms(target)) == 0) {
            int iM2028getParentbLpG9ms = m2028getParentbLpG9ms(m2028getParentbLpG9ms(target));
            if (Node.m2052equalsimpl0(m2028getParentbLpG9ms(target), m2025getLeftbLpG9ms(iM2028getParentbLpG9ms))) {
                int iM2029getRightbLpG9ms = m2029getRightbLpG9ms(iM2028getParentbLpG9ms);
                if (m2023getColor330cO7A(iM2029getRightbLpG9ms) == 0) {
                    m2037setColor9hnwElY(iM2029getRightbLpG9ms, 1);
                    m2037setColor9hnwElY(m2028getParentbLpG9ms(target), 1);
                    m2037setColor9hnwElY(iM2028getParentbLpG9ms, 0);
                    target = iM2028getParentbLpG9ms;
                } else {
                    if (Node.m2052equalsimpl0(target, m2029getRightbLpG9ms(m2028getParentbLpG9ms(target)))) {
                        target = m2028getParentbLpG9ms(target);
                        m2018rotateLeft330cO7A(target);
                    }
                    m2037setColor9hnwElY(m2028getParentbLpG9ms(target), 1);
                    m2037setColor9hnwElY(iM2028getParentbLpG9ms, 0);
                    m2019rotateRight330cO7A(iM2028getParentbLpG9ms);
                }
            } else {
                int iM2025getLeftbLpG9ms = m2025getLeftbLpG9ms(iM2028getParentbLpG9ms);
                if (m2023getColor330cO7A(iM2025getLeftbLpG9ms) == 0) {
                    m2037setColor9hnwElY(iM2025getLeftbLpG9ms, 1);
                    m2037setColor9hnwElY(m2028getParentbLpG9ms(target), 1);
                    m2037setColor9hnwElY(iM2028getParentbLpG9ms, 0);
                    target = iM2028getParentbLpG9ms;
                } else {
                    if (Node.m2052equalsimpl0(target, m2025getLeftbLpG9ms(m2028getParentbLpG9ms(target)))) {
                        target = m2028getParentbLpG9ms(target);
                        m2019rotateRight330cO7A(target);
                    }
                    m2037setColor9hnwElY(m2028getParentbLpG9ms(target), 1);
                    m2037setColor9hnwElY(iM2028getParentbLpG9ms, 0);
                    m2018rotateLeft330cO7A(iM2028getParentbLpG9ms);
                }
            }
        }
        m2037setColor9hnwElY(this.root, 1);
    }

    /* JADX INFO: renamed from: rotateLeft-330cO7A, reason: not valid java name */
    private final void m2018rotateLeft330cO7A(int node) {
        int iM2029getRightbLpG9ms = m2029getRightbLpG9ms(node);
        m2043setRightcfX_BQo(node, m2025getLeftbLpG9ms(iM2029getRightbLpG9ms));
        if (!Node.m2052equalsimpl0(m2025getLeftbLpG9ms(iM2029getRightbLpG9ms), this.terminator)) {
            m2042setParentcfX_BQo(m2025getLeftbLpG9ms(iM2029getRightbLpG9ms), node);
        }
        m2042setParentcfX_BQo(iM2029getRightbLpG9ms, m2028getParentbLpG9ms(node));
        if (Node.m2052equalsimpl0(m2028getParentbLpG9ms(node), this.terminator)) {
            this.root = iM2029getRightbLpG9ms;
        } else if (Node.m2052equalsimpl0(m2025getLeftbLpG9ms(m2028getParentbLpG9ms(node)), node)) {
            m2039setLeftcfX_BQo(m2028getParentbLpG9ms(node), iM2029getRightbLpG9ms);
        } else {
            m2043setRightcfX_BQo(m2028getParentbLpG9ms(node), iM2029getRightbLpG9ms);
        }
        m2039setLeftcfX_BQo(iM2029getRightbLpG9ms, node);
        m2042setParentcfX_BQo(node, iM2029getRightbLpG9ms);
        m2021updateNodeMinMax330cO7A(node);
    }

    /* JADX INFO: renamed from: rotateRight-330cO7A, reason: not valid java name */
    private final void m2019rotateRight330cO7A(int node) {
        int iM2025getLeftbLpG9ms = m2025getLeftbLpG9ms(node);
        m2039setLeftcfX_BQo(node, m2029getRightbLpG9ms(iM2025getLeftbLpG9ms));
        if (!Node.m2052equalsimpl0(m2029getRightbLpG9ms(iM2025getLeftbLpG9ms), this.terminator)) {
            m2042setParentcfX_BQo(m2029getRightbLpG9ms(iM2025getLeftbLpG9ms), node);
        }
        m2042setParentcfX_BQo(iM2025getLeftbLpG9ms, m2028getParentbLpG9ms(node));
        if (Node.m2052equalsimpl0(m2028getParentbLpG9ms(node), this.terminator)) {
            this.root = iM2025getLeftbLpG9ms;
        } else if (Node.m2052equalsimpl0(m2029getRightbLpG9ms(m2028getParentbLpG9ms(node)), node)) {
            m2043setRightcfX_BQo(m2028getParentbLpG9ms(node), iM2025getLeftbLpG9ms);
        } else {
            m2039setLeftcfX_BQo(m2028getParentbLpG9ms(node), iM2025getLeftbLpG9ms);
        }
        m2043setRightcfX_BQo(iM2025getLeftbLpG9ms, node);
        m2042setParentcfX_BQo(node, iM2025getLeftbLpG9ms);
        m2021updateNodeMinMax330cO7A(node);
    }

    /* JADX INFO: renamed from: updateNodeMinMax-330cO7A, reason: not valid java name */
    private final void m2021updateNodeMinMax330cO7A(int node) {
        while (!Node.m2052equalsimpl0(node, this.terminator)) {
            m2041setMin9hnwElY(node, Math.min(m2031getStart330cO7A(node), Math.min(m2027getMin330cO7A(m2025getLeftbLpG9ms(node)), m2027getMin330cO7A(m2029getRightbLpG9ms(node)))));
            m2040setMax9hnwElY(node, Math.max(m2024getEnd330cO7A(node), Math.max(m2026getMax330cO7A(m2025getLeftbLpG9ms(node)), m2026getMax330cO7A(m2029getRightbLpG9ms(node)))));
            node = m2028getParentbLpG9ms(node);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntIntervalTree)) {
            return false;
        }
        IntIntervalTree intIntervalTree = (IntIntervalTree) other;
        if (this.nodeInfo.get(this.root + 3) != intIntervalTree.nodeInfo.get(intIntervalTree.root + 3) || getTotalNodeCount() - this.deletedNodeCount != intIntervalTree.getTotalNodeCount() - intIntervalTree.deletedNodeCount) {
            return false;
        }
        int i = 4;
        int i2 = 4;
        while (i < this.nodeInfo._size && i2 < intIntervalTree.nodeInfo._size) {
            if (((int) (this.nodeInfo.get(i) >> 32)) == 2) {
                i += 4;
            } else {
                if (((int) (intIntervalTree.nodeInfo.get(i2) >> 32)) != 2) {
                    if (this.nodeInfo.get(i + 2) != intIntervalTree.nodeInfo.get(i2 + 2) || !Intrinsics.areEqual(this.items.get(i / 4), intIntervalTree.items.get(i2 / 4))) {
                        return false;
                    }
                    i += 4;
                }
                i2 += 4;
            }
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (int i = 4; i < this.nodeInfo._size; i += 4) {
            int iM2050constructorimpl = Node.m2050constructorimpl(i);
            if (m2023getColor330cO7A(iM2050constructorimpl) != 2) {
                int iM2031getStart330cO7A = ((((iHashCode * 31) + m2031getStart330cO7A(iM2050constructorimpl)) * 31) + m2024getEnd330cO7A(iM2050constructorimpl)) * 31;
                T tM2013getItem330cO7A = m2013getItem330cO7A(iM2050constructorimpl);
                iHashCode = iM2031getStart330cO7A + (tM2013getItem330cO7A != null ? tM2013getItem330cO7A.hashCode() : 0);
            }
        }
        return iHashCode;
    }

    public final IntIntervalTree<T> copy() {
        cleanDeletedNodes();
        return new IntIntervalTree<>(this);
    }

    public final boolean isEmpty() {
        return Node.m2052equalsimpl0(this.root, this.terminator);
    }

    /* JADX INFO: renamed from: add-ZlWbn38, reason: not valid java name */
    public final void m2022addZlWbn38(MutableIntList mutableIntList, int i) {
        mutableIntList.add(i);
    }

    /* JADX INFO: renamed from: pop-2SV_EgM, reason: not valid java name */
    public final int m2036pop2SV_EgM(MutableIntList mutableIntList) {
        return Node.m2050constructorimpl(mutableIntList.removeAt(mutableIntList._size - 1));
    }

    private final void forEachNodeInRange(int start, int end, Function1<? super Integer, Unit> block) {
        if (Node.m2052equalsimpl0(getRoot(), getTerminator()) || m2026getMax330cO7A(getRoot()) < start || m2027getMin330cO7A(getRoot()) > end) {
            return;
        }
        int root = getRoot();
        while (true) {
            char c2 = 0;
            while (!Node.m2052equalsimpl0(root, getTerminator())) {
                if (c2 != 0) {
                    if (c2 == 1) {
                        int iM2050constructorimpl = Node.m2050constructorimpl(root);
                        if (m2035overlapsXzpGiIY(iM2050constructorimpl, start, end)) {
                            block.invoke(Integer.valueOf(iM2050constructorimpl));
                        }
                        if (Node.m2052equalsimpl0(m2029getRightbLpG9ms(root), getTerminator()) || m2026getMax330cO7A(m2029getRightbLpG9ms(root)) < start || m2027getMin330cO7A(m2029getRightbLpG9ms(root)) > end) {
                            c2 = 2;
                        } else {
                            root = m2029getRightbLpG9ms(root);
                        }
                    } else if (c2 == 2) {
                        if (!Node.m2052equalsimpl0(m2028getParentbLpG9ms(root), getTerminator())) {
                            c2 = Node.m2052equalsimpl0(root, m2025getLeftbLpG9ms(m2028getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                        }
                        root = m2028getParentbLpG9ms(root);
                    }
                } else if (Node.m2052equalsimpl0(m2025getLeftbLpG9ms(root), getTerminator()) || m2026getMax330cO7A(m2025getLeftbLpG9ms(root)) < start) {
                    c2 = 1;
                } else {
                    root = m2025getLeftbLpG9ms(root);
                }
            }
            return;
        }
    }

    static /* synthetic */ void forEachNodeInRange$default(IntIntervalTree intIntervalTree, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        if (Node.m2052equalsimpl0(intIntervalTree.getRoot(), intIntervalTree.getTerminator()) || intIntervalTree.m2026getMax330cO7A(intIntervalTree.getRoot()) < i || intIntervalTree.m2027getMin330cO7A(intIntervalTree.getRoot()) > i2) {
            return;
        }
        int root = intIntervalTree.getRoot();
        while (true) {
            char c2 = 0;
            while (!Node.m2052equalsimpl0(root, intIntervalTree.getTerminator())) {
                if (c2 != 0) {
                    if (c2 == 1) {
                        int iM2050constructorimpl = Node.m2050constructorimpl(root);
                        if (intIntervalTree.m2035overlapsXzpGiIY(iM2050constructorimpl, i, i2)) {
                            function1.invoke(Integer.valueOf(iM2050constructorimpl));
                        }
                        if (Node.m2052equalsimpl0(intIntervalTree.m2029getRightbLpG9ms(root), intIntervalTree.getTerminator()) || intIntervalTree.m2026getMax330cO7A(intIntervalTree.m2029getRightbLpG9ms(root)) < i || intIntervalTree.m2027getMin330cO7A(intIntervalTree.m2029getRightbLpG9ms(root)) > i2) {
                            c2 = 2;
                        } else {
                            root = intIntervalTree.m2029getRightbLpG9ms(root);
                        }
                    } else if (c2 == 2) {
                        if (!Node.m2052equalsimpl0(intIntervalTree.m2028getParentbLpG9ms(root), intIntervalTree.getTerminator())) {
                            c2 = Node.m2052equalsimpl0(root, intIntervalTree.m2025getLeftbLpG9ms(intIntervalTree.m2028getParentbLpG9ms(root))) ? (char) 1 : (char) 2;
                        }
                        root = intIntervalTree.m2028getParentbLpG9ms(root);
                    }
                } else if (Node.m2052equalsimpl0(intIntervalTree.m2025getLeftbLpG9ms(root), intIntervalTree.getTerminator()) || intIntervalTree.m2026getMax330cO7A(intIntervalTree.m2025getLeftbLpG9ms(root)) < i) {
                    c2 = 1;
                } else {
                    root = intIntervalTree.m2025getLeftbLpG9ms(root);
                }
            }
            return;
        }
    }
}
