package androidx.compose.foundation.gestures;

import androidx.collection.LongList;
import androidx.collection.MutableLongList;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: IndirectPointerInputDragCycleDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/OffsetSmoother;", "", "<init>", "()V", "eventRotatingIndex", "", "eventRotatingArray", "Landroidx/collection/MutableLongList;", "smoothEventPosition", "Landroidx/compose/ui/geometry/Offset;", "offset", "smoothEventPosition-MK-Hz9U", "(J)J", "reset", "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OffsetSmoother {
    public static final int $stable = 8;
    private MutableLongList eventRotatingArray = new MutableLongList(0, 1, null);
    private int eventRotatingIndex;

    /* JADX INFO: renamed from: smoothEventPosition-MK-Hz9U, reason: not valid java name */
    public final long m634smoothEventPositionMKHz9U(long offset) {
        if (this.eventRotatingArray._size == 3) {
            MutableLongList mutableLongList = this.eventRotatingArray;
            int i = this.eventRotatingIndex;
            this.eventRotatingIndex = i + 1;
            mutableLongList.set(i, offset);
        } else {
            this.eventRotatingArray.add(offset);
        }
        if (this.eventRotatingIndex == 3) {
            this.eventRotatingIndex = 0;
        }
        float fSmoothEventPosition_MK_Hz9U$averageBy = smoothEventPosition_MK_Hz9U$averageBy(this.eventRotatingArray, new Function1() { // from class: androidx.compose.foundation.gestures.OffsetSmoother$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(OffsetSmoother.smoothEventPosition_MK_Hz9U$lambda$1(((Long) obj).longValue()));
            }
        });
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(smoothEventPosition_MK_Hz9U$averageBy(this.eventRotatingArray, new Function1() { // from class: androidx.compose.foundation.gestures.OffsetSmoother$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(OffsetSmoother.smoothEventPosition_MK_Hz9U$lambda$2(((Long) obj).longValue()));
            }
        }))) & 4294967295L) | (Float.floatToRawIntBits(fSmoothEventPosition_MK_Hz9U$averageBy) << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float smoothEventPosition_MK_Hz9U$lambda$1(long j) {
        return Float.intBitsToFloat((int) (Offset.m5715constructorimpl(j) >> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float smoothEventPosition_MK_Hz9U$lambda$2(long j) {
        return Float.intBitsToFloat((int) (Offset.m5715constructorimpl(j) & 4294967295L));
    }

    public final void reset() {
        this.eventRotatingIndex = 0;
        this.eventRotatingArray.clear();
    }

    private static final float smoothEventPosition_MK_Hz9U$averageBy(LongList longList, Function1<? super Long, Float> function1) {
        long[] jArr = longList.content;
        int i = longList._size;
        float fFloatValue = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            fFloatValue += function1.invoke(Long.valueOf(jArr[i2])).floatValue();
        }
        return fFloatValue / longList._size;
    }
}
