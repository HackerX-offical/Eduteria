package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.csvreader.CsvReader;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: compiled from: RectList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\f\u001a\u00020\bH\u0082\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J`\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\bJN\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\bJ.\u0010$\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u001e\u0010%\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010&\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001aJ.\u0010'\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ6\u0010(\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bJ\u001e\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bJ \u0010)\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002J\u000e\u0010/\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\bJ4\u00100\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2$\u00101\u001a \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e02J(\u00103\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000e04J\u000e\u00105\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\bJ\u0011\u00106\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\bH\u0086\u0002J\u000e\u00107\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u00108\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\bJ=\u00109\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0:H\u0086\bJ=\u0010;\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0:H\u0086\bJ=\u0010<\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0:H\u0086\bJ5\u0010=\u001a\u00020\u000e2*\u00101\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0>H\u0086\bJ-\u00109\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0:H\u0086\bJ=\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\b2*\u00101\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0>H\u0086\bJ5\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0000¢\u0006\u0002\bFJÇ\u0001\u0010G\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\b2\u0006\u0010H\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u008b\u0001\u00101\u001a\u0086\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\b¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0IH\u0086\bJ1\u0010M\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0086\bJ\u0006\u0010N\u001a\u00020\u000eJ\u0006\u0010O\u001a\u00020\u000eJ)\u0010P\u001a\u00020\u000e2\u001e\u00101\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000e0QH\u0086\bJ\u0006\u0010R\u001a\u00020SR\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006T"}, d2 = {"Landroidx/compose/ui/spatial/RectList;", "", "<init>", "()V", FirebaseAnalytics.Param.ITEMS, "", "stack", "itemsSize", "", "size", "getSize", "()I", "allocateItemsIndex", "resizeStorage", "", "actualSize", "currentSize", "currentItems", "insert", "value", CmcdData.Factory.STREAM_TYPE_LIVE, "t", StreamManagement.AckRequest.ELEMENT, "b", "parentId", "focusable", "", "gesturable", "hasCallbacks", "parentIndexInRectList", "insertBasedOnParentOffset", "offsetFromParentX", "offsetFromParentY", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "remove", DiscoverItems.Item.UPDATE_ACTION, "updateFlagsFor", "updateHasCallbacks", "move", "moveBasedOnParentOffset", "updateSubhierarchy", "id", "deltaX", "deltaY", "stackMeta", "", "markUpdated", "withRect", BlockContactsIQ.ELEMENT, "Lkotlin/Function4;", "withTopLeftBottomRight", "Lkotlin/Function2;", "getTopLeft", "contains", "indexOf", "metaFor", "forEachIntersection", "Lkotlin/Function1;", "forEachGesturableIntersection", "forEachFocusableIntersection", "forEachRect", "Lkotlin/Function5;", "x", "y", "forEachIntersectingRectWithValueAt", FirebaseAnalytics.Param.INDEX, "neighborsScoredByDistance", "", "searchAxis", "neighborsScoredByDistance$ui", "findKNearestNeighbors", "k", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "score", "findNearestNeighbor", "defragment", "clearUpdated", "forEachUpdatedRect", "Lkotlin/Function3;", "debugString", "", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RectList {
    public static final int $stable = 8;
    public int itemsSize;
    public long[] items = new long[192];
    public long[] stack = new long[192];

    public final int getSize() {
        return this.itemsSize / 3;
    }

    private final int allocateItemsIndex() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i2 = i + 3;
        this.itemsSize = i2;
        int length = jArr.length;
        if (length <= i2) {
            resizeStorage(length, i, jArr);
        }
        return i;
    }

    private final void resizeStorage(int actualSize, int currentSize, long[] currentItems) {
        int iMax = Math.max(actualSize * 2, currentSize + 3);
        long[] jArrCopyOf = Arrays.copyOf(currentItems, iMax);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        this.items = jArrCopyOf;
        long[] jArrCopyOf2 = Arrays.copyOf(this.stack, iMax);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf2, "copyOf(...)");
        this.stack = jArrCopyOf2;
    }

    public static /* synthetic */ void insert$default(RectList rectList, int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, int i7, int i8, Object obj) {
        if ((i8 & 32) != 0) {
            i6 = -1;
        }
        if ((i8 & 64) != 0) {
            z = false;
        }
        if ((i8 & 128) != 0) {
            z2 = false;
        }
        if ((i8 & 256) != 0) {
            z3 = false;
        }
        if ((i8 & 512) != 0) {
            i7 = -1;
        }
        rectList.insert(i, i2, i3, i4, i5, i6, z, z2, z3, i7);
    }

    public final void insertBasedOnParentOffset(int value, int parentId, int offsetFromParentX, int offsetFromParentY, int width, int height, boolean focusable, boolean gesturable, boolean hasCallbacks) {
        int i = value & 33554431;
        long[] jArr = this.items;
        for (int i2 = this.itemsSize - 3; i2 >= 0; i2 -= 3) {
            if ((((int) jArr[i2 + 2]) & 33554431) == parentId) {
                long j = jArr[i2];
                int i3 = ((int) (j >> 32)) + offsetFromParentX;
                int i4 = ((int) j) + offsetFromParentY;
                insert(i, i3, i4, i3 + width, i4 + height, parentId, focusable, gesturable, hasCallbacks, i2);
                return;
            }
        }
    }

    public final boolean remove(int value) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            if ((((int) jArr[i4]) & 33554431) == i) {
                jArr[i3] = -1;
                jArr[i3 + 1] = -1;
                jArr[i4] = RectListKt.getTombStone();
                return true;
            }
        }
        return false;
    }

    public final boolean update(int value, int l, int t, int r, int b2) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & 33554431) == i) {
                jArr[i3] = (((long) l) << 32) | (((long) t) & 4294967295L);
                jArr[i3 + 1] = (((long) r) << 32) | (((long) b2) & 4294967295L);
                jArr[i4] = (((j >> 63) & 1) << 60) | j;
                return true;
            }
        }
        return false;
    }

    public final boolean updateFlagsFor(int value, boolean focusable, boolean gesturable) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & 33554431) == i) {
                jArr[i4] = ((focusable ? 1L : 0L) * LockFreeTaskQueueCore.CLOSED_MASK) | ((-6917529027641081857L) & j) | ((gesturable ? 1L : 0L) * 4611686018427387904L);
                return true;
            }
        }
        return false;
    }

    public final boolean updateHasCallbacks(int value, boolean hasCallbacks) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & 33554431) == i) {
                jArr[i4] = ((hasCallbacks ? 1L : 0L) * Long.MIN_VALUE) | (8070450532247928831L & j) | ((hasCallbacks ? 1L : 0L) * LockFreeTaskQueueCore.FROZEN_MASK);
                return true;
            }
        }
        return false;
    }

    public final void move(int value, int l, int t, int r, int b2) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & 33554431) == i) {
                long j2 = jArr[i3];
                jArr[i3] = (((long) t) & 4294967295L) | (((long) l) << 32);
                int i5 = i3;
                jArr[i3 + 1] = (((long) b2) & 4294967295L) | (((long) r) << 32);
                jArr[i4] = (((j >> 63) & 1) << 60) | j;
                int i6 = l - ((int) (j2 >> 32));
                int i7 = t - ((int) j2);
                if ((i6 != 0) || (i7 != 0)) {
                    updateSubhierarchy((RectListKt.getEverythingButParentId() & j) | (((long) ((i5 + 3) & 33554431)) << 25), i6, i7);
                    return;
                }
                return;
            }
        }
    }

    public final void moveBasedOnParentOffset(int value, int parentId, int offsetFromParentX, int offsetFromParentY, int width, int height) {
        int i;
        long j;
        int i2 = 33554431;
        int i3 = value & 33554431;
        int i4 = this.itemsSize;
        int i5 = 0;
        for (long[] jArr = this.items; i5 < jArr.length - 2 && i5 < i4; jArr = jArr) {
            if ((((int) jArr[i5 + 2]) & i2) == parentId) {
                long j2 = jArr[i5];
                int i6 = ((int) (j2 >> 32)) + offsetFromParentX;
                int i7 = ((int) j2) + offsetFromParentY;
                int i8 = i6 + width;
                int i9 = i7 + height;
                do {
                    i5 += 3;
                    if (i5 >= jArr.length - 2 || i5 >= i4) {
                        break;
                    }
                    i = i5 + 2;
                    j = jArr[i];
                } while ((((int) j) & i2) != i3);
                int i10 = i2;
                long j3 = jArr[i5];
                int i11 = i6 - ((int) (j3 >> 32));
                int i12 = i7 - ((int) j3);
                long[] jArr2 = jArr;
                jArr2[i5] = (((long) i7) & 4294967295L) | (((long) i6) << 32);
                jArr2[i5 + 1] = (((long) i8) << 32) | (((long) i9) & 4294967295L);
                jArr2[i] = (((j >> 63) & 1) << 60) | j;
                if (i11 == 0 && i12 == 0) {
                    return;
                }
                updateSubhierarchy((RectListKt.getEverythingButParentId() & j) | (((long) ((i5 + 3) & i10)) << 25), i11, i12);
                return;
            }
            i5 += 3;
            i2 = i2;
        }
    }

    public final void updateSubhierarchy(int id, int deltaX, int deltaY) {
        updateSubhierarchy((((long) Math.min(this.itemsSize / 3, 1023)) << 50) | (((long) 0) << 25) | ((long) (id & 33554431)), deltaX, deltaY);
    }

    private final void updateSubhierarchy(long stackMeta, int deltaX, int deltaY) {
        int i;
        char c2;
        char c3;
        long[] jArr = this.items;
        long[] jArr2 = this.stack;
        getSize();
        jArr2[0] = stackMeta;
        int i2 = 1;
        while (i2 > 0) {
            i2--;
            long j = jArr2[i2];
            int i3 = 33554431;
            int i4 = ((int) j) & 33554431;
            char c4 = 25;
            int i5 = ((int) (j >> 25)) & 33554431;
            char c5 = '2';
            int i6 = ((int) (j >> 50)) & 1023;
            int i7 = i6 == 1023 ? this.itemsSize : (i6 * 3) + i5;
            if (i5 < 0) {
                return;
            }
            while (i5 < jArr.length - 2 && i5 < i7) {
                int i8 = i5 + 2;
                long j2 = jArr[i8];
                if ((((int) (j2 >> c4)) & i3) == i4) {
                    long j3 = jArr[i5];
                    int i9 = i5 + 1;
                    i = i3;
                    c2 = c4;
                    long j4 = jArr[i9];
                    c3 = c5;
                    jArr[i5] = (((long) (((int) j3) + deltaY)) & 4294967295L) | (((long) (((int) (j3 >> 32)) + deltaX)) << 32);
                    jArr[i9] = (((long) (((int) j4) + deltaY)) & 4294967295L) | (((long) (((int) (j4 >> 32)) + deltaX)) << 32);
                    jArr[i8] = (((j2 >> 63) & 1) << 60) | j2;
                    if ((((int) (j2 >> c3)) & 1023) > 0) {
                        jArr2[i2] = (RectListKt.getEverythingButParentId() & j2) | (((long) ((i5 + 3) & i)) << c2);
                        i2++;
                    }
                } else {
                    i = i3;
                    c2 = c4;
                    c3 = c5;
                }
                i5 += 3;
                i3 = i;
                c4 = c2;
                c5 = c3;
            }
        }
    }

    public final void markUpdated(int value) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & 33554431) == i) {
                jArr[i4] = (((j >> 63) & 1) << 60) | j;
                return;
            }
        }
    }

    public final boolean withRect(int value, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> block) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & 33554431) == i) {
                long j = jArr[i3];
                long j2 = jArr[i3 + 1];
                block.invoke(Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                return true;
            }
        }
        return false;
    }

    public final boolean withTopLeftBottomRight(int value, Function2<? super Long, ? super Long, Unit> block) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & 33554431) == i) {
                block.invoke(Long.valueOf(jArr[i3]), Long.valueOf(jArr[i3 + 1]));
                return true;
            }
        }
        return false;
    }

    public final long getTopLeft(int value) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & 33554431) == i) {
                return jArr[i3];
            }
        }
        return Long.MAX_VALUE;
    }

    public final boolean contains(int value) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & 33554431) == i) {
                return true;
            }
        }
        return false;
    }

    public final int indexOf(int value) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & 33554431) == i) {
                return i3;
            }
        }
        return -1;
    }

    public final long metaFor(int value) {
        int i = value & 33554431;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            long j = jArr[i3 + 2];
            if ((((int) j) & 33554431) == i) {
                return j;
            }
        }
        return RectListKt.getTombStone();
    }

    public final void forEachIntersection(int l, int t, int r, int b2, Function1<? super Integer, Unit> block) {
        long j = (((long) l) << 32) | (((long) t) & 4294967295L);
        long j2 = (((long) r) << 32) | (((long) b2) & 4294967295L);
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            if (((((j2 - jArr[i2]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i2 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                block.invoke(Integer.valueOf(((int) jArr[i2 + 2]) & 33554431));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void forEachGesturableIntersection(int r17, int r18, int r19, int r20, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            long r1 = (long) r1
            r3 = 32
            long r1 = r1 << r3
            r4 = r18
            long r4 = (long) r4
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            long r1 = r1 | r4
            r4 = r19
            long r4 = (long) r4
            long r3 = r4 << r3
            r5 = r20
            long r8 = (long) r5
            long r5 = r8 & r6
            long r3 = r3 | r5
            long[] r5 = r0.items
            int r6 = r0.itemsSize
            r7 = 0
        L22:
            int r8 = r5.length
            int r8 = r8 + (-2)
            if (r7 >= r8) goto L67
            if (r7 >= r6) goto L67
            int r8 = r7 + 2
            r8 = r5[r8]
            r10 = 62
            long r10 = r8 >> r10
            int r10 = (int) r10
            r10 = r10 & 1
            if (r10 == 0) goto L62
            r10 = r5[r7]
            int r12 = r7 + 1
            r12 = r5[r12]
            long r10 = r3 - r10
            r14 = 4294967297(0x100000001, double:2.1219957915E-314)
            long r10 = r10 - r14
            long r12 = r12 - r1
            long r12 = r12 - r14
            long r10 = r10 | r12
            r12 = -9223372034707292160(0x8000000080000000, double:-1.0609978955E-314)
            long r10 = r10 & r12
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 != 0) goto L62
            int r8 = (int) r8
            r9 = 33554431(0x1ffffff, float:9.403954E-38)
            r8 = r8 & r9
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9 = r21
            r9.invoke(r8)
            goto L64
        L62:
            r9 = r21
        L64:
            int r7 = r7 + 3
            goto L22
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.RectList.forEachGesturableIntersection(int, int, int, int, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void forEachFocusableIntersection(int r17, int r18, int r19, int r20, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            long r1 = (long) r1
            r3 = 32
            long r1 = r1 << r3
            r4 = r18
            long r4 = (long) r4
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            long r1 = r1 | r4
            r4 = r19
            long r4 = (long) r4
            long r3 = r4 << r3
            r5 = r20
            long r8 = (long) r5
            long r5 = r8 & r6
            long r3 = r3 | r5
            long[] r5 = r0.items
            int r6 = r0.itemsSize
            r7 = 0
        L22:
            int r8 = r5.length
            int r8 = r8 + (-2)
            if (r7 >= r8) goto L67
            if (r7 >= r6) goto L67
            int r8 = r7 + 2
            r8 = r5[r8]
            r10 = 61
            long r10 = r8 >> r10
            int r10 = (int) r10
            r10 = r10 & 1
            if (r10 == 0) goto L62
            r10 = r5[r7]
            int r12 = r7 + 1
            r12 = r5[r12]
            long r10 = r3 - r10
            r14 = 4294967297(0x100000001, double:2.1219957915E-314)
            long r10 = r10 - r14
            long r12 = r12 - r1
            long r12 = r12 - r14
            long r10 = r10 | r12
            r12 = -9223372034707292160(0x8000000080000000, double:-1.0609978955E-314)
            long r10 = r10 & r12
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 != 0) goto L62
            int r8 = (int) r8
            r9 = 33554431(0x1ffffff, float:9.403954E-38)
            r8 = r8 & r9
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9 = r21
            r9.invoke(r8)
            goto L64
        L62:
            r9 = r21
        L64:
            int r7 = r7 + 3
            goto L22
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.RectList.forEachFocusableIntersection(int, int, int, int, kotlin.jvm.functions.Function1):void");
    }

    public final void forEachRect(Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            long j = jArr[i2];
            long j2 = jArr[i2 + 1];
            block.invoke(Integer.valueOf(((int) jArr[i2 + 2]) & 33554431), Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
        }
    }

    public final void forEachIntersection(int x, int y, Function1<? super Integer, Unit> block) {
        long j = (((long) y) & 4294967295L) | (((long) x) << 32);
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            if (((((j - jArr[i2]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i2 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                block.invoke(Integer.valueOf(((int) jArr[i2 + 2]) & 33554431));
            }
        }
    }

    public final void forEachIntersectingRectWithValueAt(int index, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        long j = jArr[index];
        long j2 = jArr[index + 1];
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            if (i2 != index) {
                long j3 = jArr[i2];
                long j4 = jArr[i2 + 1];
                if (((((j2 - j3) - InlineClassHelperKt.Uint64Low32) | ((j4 - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    block.invoke(Integer.valueOf((int) (j3 >> 32)), Integer.valueOf((int) j3), Integer.valueOf((int) (j4 >> 32)), Integer.valueOf((int) j4), Integer.valueOf(((int) jArr[i2 + 2]) & 33554431));
                }
            }
        }
    }

    public final int[] neighborsScoredByDistance$ui(int searchAxis, int l, int t, int r, int b2) {
        long[] jArr = this.items;
        int i = this.itemsSize / 3;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 3;
            if (i3 < 0 || i3 >= jArr.length - 1) {
                break;
            }
            long j = jArr[i3];
            long j2 = jArr[i3 + 1];
            iArr[i2] = RectListKt.distanceScore(searchAxis, l, t, r, b2, (int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
        }
        return iArr;
    }

    public final void findKNearestNeighbors(int searchAxis, int k, int l, int t, int r, int b2, Function6<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> block) {
        int i;
        int[] iArrNeighborsScoredByDistance$ui = neighborsScoredByDistance$ui(searchAxis, l, t, r, b2);
        long[] jArr = this.items;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 <= k) {
            int iMin = Integer.MAX_VALUE;
            int i5 = 0;
            while (i5 < iArrNeighborsScoredByDistance$ui.length) {
                int i6 = iArrNeighborsScoredByDistance$ui[i5];
                if (i6 > i2) {
                    iMin = Math.min(iMin, i6);
                }
                if (i6 == i2) {
                    int i7 = i5 * 3;
                    long j = jArr[i7];
                    long j2 = jArr[i7 + 1];
                    i = i2;
                    block.invoke(Integer.valueOf(i6), Integer.valueOf(((int) jArr[i7 + 2]) & 33554431), Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                    i4++;
                    if (i4 == k) {
                        return;
                    }
                } else {
                    i = i2;
                }
                i5++;
                i2 = i;
            }
            i3++;
            i2 = iMin;
        }
    }

    public final int findNearestNeighbor(int searchAxis, int l, int t, int r, int b2) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i; i4 += 3) {
            long j = jArr[i4];
            int i5 = i4 + 1;
            long j2 = jArr[i5];
            int iDistanceScore = RectListKt.distanceScore(searchAxis, l, t, r, b2, (int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
            boolean z = (iDistanceScore < i2) & (iDistanceScore > 0);
            if (z) {
                i2 = iDistanceScore;
            }
            if (z) {
                i3 = i5;
            }
        }
        if (i3 < 0 || i3 >= jArr.length) {
            return -1;
        }
        return ((int) jArr[i3]) & 33554431;
    }

    public final void defragment() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        long[] jArr2 = this.stack;
        int i2 = 0;
        for (int i3 = 0; i3 < jArr.length - 2 && i2 < jArr2.length - 2 && i3 < i; i3 += 3) {
            int i4 = i3 + 2;
            if (jArr[i4] != RectListKt.getTombStone()) {
                jArr2[i2] = jArr[i3];
                jArr2[i2 + 1] = jArr[i3 + 1];
                jArr2[i2 + 2] = jArr[i4];
                i2 += 3;
            }
        }
        this.itemsSize = i2;
        this.items = jArr2;
        this.stack = jArr;
    }

    public final void clearUpdated() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            int i3 = i2 + 2;
            jArr[i3] = jArr[i3] & (-1152921504606846977L);
        }
    }

    public final void forEachUpdatedRect(Function3<? super Integer, ? super Long, ? super Long, Unit> block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            long j = jArr[i2 + 2];
            if ((((int) (j >> 60)) & 1) != 0) {
                block.invoke(Integer.valueOf(((int) j) & 33554431), Long.valueOf(jArr[i2]), Long.valueOf(jArr[i2 + 1]));
            }
        }
    }

    public final String debugString() {
        StringBuilder sb = new StringBuilder();
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i2 = 0;
        while (i2 < jArr.length - 2 && i2 < i) {
            long j = jArr[i2];
            long j2 = jArr[i2 + 1];
            long j3 = jArr[i2 + 2];
            long[] jArr2 = jArr;
            int i3 = i;
            StringBuilder sb2 = sb;
            sb2.append("id=" + (((int) j3) & 33554431) + ", rect=[" + ((int) (j >> 32)) + CsvReader.Letters.COMMA + ((int) j) + CsvReader.Letters.COMMA + ((int) (j2 >> 32)) + CsvReader.Letters.COMMA + ((int) j2) + "], parent=" + (33554431 & ((int) (j3 >> 25))) + ", lastChildOffset=" + (((int) (j3 >> 50)) & 1023) + ", updated=" + (((int) (j3 >> 60)) & 1) + ", focusable=" + (((int) (j3 >> 61)) & 1) + ", gesturable=" + (((int) (j3 >> 62)) & 1)).append('\n');
            i2 += 3;
            jArr = jArr2;
            sb = sb2;
            i = i3;
        }
        return sb.toString();
    }

    public final void insert(int value, int l, int t, int r, int b2, int parentId, boolean focusable, boolean gesturable, boolean hasCallbacks, int parentIndexInRectList) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i2 = i + 3;
        this.itemsSize = i2;
        int length = jArr.length;
        if (length <= i2) {
            resizeStorage(length, i, jArr);
        }
        long[] jArr2 = this.items;
        jArr2[i] = (((long) l) << 32) | (((long) t) & 4294967295L);
        jArr2[i + 1] = (((long) r) << 32) | (((long) b2) & 4294967295L);
        int i3 = parentId & 33554431;
        jArr2[i + 2] = ((hasCallbacks ? 1L : 0L) << 63) | ((gesturable ? 1L : 0L) << 62) | ((focusable ? 1L : 0L) << 61) | (((long) 1) << 60) | (((long) Math.min(0, 1023)) << 50) | (((long) i3) << 25) | ((long) (value & 33554431));
        if (parentId < 0) {
            return;
        }
        for (int i4 = parentIndexInRectList != -1 ? parentIndexInRectList : i - 3; i4 >= 0; i4 -= 3) {
            int i5 = i4 + 2;
            long j = jArr2[i5];
            if ((((int) j) & 33554431) == i3) {
                jArr2[i5] = (j & RectListKt.getEverythingButLastChildOffset()) | (((long) Math.min((i - i4) / 3, 1023)) << 50);
                return;
            }
        }
    }
}
