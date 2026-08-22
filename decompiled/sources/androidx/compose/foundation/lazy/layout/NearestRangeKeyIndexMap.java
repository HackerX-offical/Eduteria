package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.IntervalList;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LazyLayoutKeyIndexMap.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/NearestRangeKeyIndexMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "nearestRange", "Lkotlin/ranges/IntRange;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "<init>", "(Lkotlin/ranges/IntRange;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;)V", "map", "Landroidx/collection/ObjectIntMap;", "", "keys", "", "[Ljava/lang/Object;", "keysStartIndex", "", "getIndex", "key", "getKey", FirebaseAnalytics.Param.INDEX, "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    public static final int $stable = 8;
    private final Object[] keys;
    private final int keysStartIndex;
    private final ObjectIntMap<Object> map;

    public NearestRangeKeyIndexMap(IntRange intRange, LazyLayoutIntervalContent<?> lazyLayoutIntervalContent) {
        IntervalList<Interval> intervals = lazyLayoutIntervalContent.getIntervals();
        final int first = intRange.getFirst();
        if (!(first >= 0)) {
            InlineClassHelperKt.throwIllegalStateException("negative nearestRange.first");
        }
        final int iMin = Math.min(intRange.getLast(), intervals.getSize() - 1);
        if (iMin < first) {
            this.map = ObjectIntMapKt.emptyObjectIntMap();
            this.keys = new Object[0];
            this.keysStartIndex = 0;
        } else {
            int i = (iMin - first) + 1;
            this.keys = new Object[i];
            this.keysStartIndex = first;
            final MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(i);
            intervals.forEach(first, iMin, new Function1() { // from class: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NearestRangeKeyIndexMap.lambda$1$0(first, iMin, mutableObjectIntMap, this, (IntervalList.Interval) obj);
                }
            });
            this.map = mutableObjectIntMap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046 A[LOOP:0: B:4:0x0023->B:10:0x0046, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049 A[EDGE_INSN: B:13:0x0049->B:11:0x0049 BREAK  A[LOOP:0: B:4:0x0023->B:10:0x0046], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static final kotlin.Unit lambda$1$0(int r4, int r5, androidx.collection.MutableObjectIntMap r6, androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r7, androidx.compose.foundation.lazy.layout.IntervalList.Interval r8) {
        /*
            java.lang.Object r0 = r8.getValue()
            androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval) r0
            kotlin.jvm.functions.Function1 r0 = r0.getKey()
            int r1 = r8.getStartIndex()
            int r4 = java.lang.Math.max(r4, r1)
            int r1 = r8.getStartIndex()
            int r2 = r8.getSize()
            int r1 = r1 + r2
            int r1 = r1 + (-1)
            int r5 = java.lang.Math.min(r5, r1)
            if (r4 > r5) goto L49
        L23:
            if (r0 == 0) goto L35
            int r1 = r8.getStartIndex()
            int r1 = r4 - r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r0.invoke(r1)
            if (r1 != 0) goto L39
        L35:
            java.lang.Object r1 = androidx.compose.foundation.lazy.layout.Lazy_androidKt.getDefaultLazyLayoutKey(r4)
        L39:
            r6.set(r1, r4)
            java.lang.Object[] r2 = r7.keys
            int r3 = r7.keysStartIndex
            int r3 = r4 - r3
            r2[r3] = r1
            if (r4 == r5) goto L49
            int r4 = r4 + 1
            goto L23
        L49:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap.lambda$1$0(int, int, androidx.collection.MutableObjectIntMap, androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap, androidx.compose.foundation.lazy.layout.IntervalList$Interval):kotlin.Unit");
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int getIndex(Object key) {
        ObjectIntMap<Object> objectIntMap = this.map;
        int iFindKeyIndex = objectIntMap.findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return objectIntMap.values[iFindKeyIndex];
        }
        return -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object getKey(int index) {
        Object[] objArr = this.keys;
        int i = index - this.keysStartIndex;
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }
}
