package androidx.compose.runtime.composer.linkbuffer;

import io.socket.engineio.client.Socket;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: SlotTableAddresSpace.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eJ\u0013\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u001b\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR$\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotMoveManager;", "", "source", "", "destination", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;)V", "getSource", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getDestination", "setDestination", "([Ljava/lang/Object;)V", "pendingMoveOffset", "", "pendingMoveStart", "pendingMoveEnd", "highest", "move", "", "destinationOffset", "startIndex", "endIndex", ES6Iterator.DONE_PROPERTY, Socket.EVENT_FLUSH, "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlotMoveManager {
    public static final int $stable = 8;
    private Object[] destination;
    private final Object[] source;
    private int pendingMoveOffset = -1;
    private int pendingMoveStart = -1;
    private int pendingMoveEnd = -1;
    private int highest = -1;

    public SlotMoveManager(Object[] objArr, Object[] objArr2) {
        this.source = objArr;
        this.destination = objArr2;
    }

    public final Object[] getDestination() {
        return this.destination;
    }

    public final Object[] getSource() {
        return this.source;
    }

    public final void setDestination(Object[] objArr) {
        this.destination = objArr;
    }

    public final void move(int destinationOffset, int startIndex, int endIndex) {
        Object[] objArr = this.source;
        Object[] objArr2 = this.destination;
        if (objArr == objArr2) {
            if (startIndex == destinationOffset) {
                return;
            }
            int i = (endIndex - startIndex) + destinationOffset + destinationOffset;
            if (i >= objArr2.length) {
                Object[] objArr3 = this.source;
                Object[] objArrCopyOf = Arrays.copyOf(objArr3, objArr3.length);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                this.destination = objArrCopyOf;
                break;
            }
            for (int i2 = destinationOffset; i2 < i; i2++) {
                if (objArr2[i2] != SlotTableAddresSpaceKt.Unallocated) {
                    Object[] objArr32 = this.source;
                    Object[] objArrCopyOf2 = Arrays.copyOf(objArr32, objArr32.length);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
                    this.destination = objArrCopyOf2;
                    break;
                }
            }
        }
        if (this.pendingMoveEnd == startIndex) {
            this.pendingMoveEnd = endIndex;
            return;
        }
        flush();
        this.pendingMoveOffset = destinationOffset;
        this.pendingMoveStart = startIndex;
        this.pendingMoveEnd = endIndex;
    }

    public final Object[] done() {
        flush();
        int i = this.highest;
        if (i >= 0) {
            Object[] objArr = this.destination;
            if (i < objArr.length) {
                int length = objArr.length;
                if (length == i + 1) {
                    objArr[i] = SlotTableAddresSpaceKt.Unallocated;
                } else {
                    ArraysKt.fill(objArr, SlotTableAddresSpaceKt.Unallocated, i, length);
                }
            }
        }
        return this.destination;
    }

    private final void flush() {
        int i = this.pendingMoveOffset;
        if (i >= 0) {
            Object[] objArr = this.source;
            ArraysKt.copyInto(objArr, this.destination, i, this.pendingMoveStart, this.pendingMoveEnd);
            if (objArr == this.destination) {
                ArraysKt.fill(objArr, SlotTableAddresSpaceKt.Unallocated, this.pendingMoveStart, this.pendingMoveEnd);
            }
            int i2 = this.pendingMoveOffset + (this.pendingMoveEnd - this.pendingMoveStart);
            this.pendingMoveOffset = -1;
            this.pendingMoveEnd = -1;
            if (i2 > this.highest) {
                this.highest = i2;
            }
        }
    }
}
