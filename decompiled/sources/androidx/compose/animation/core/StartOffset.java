package androidx.compose.animation.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/animation/core/StartOffset;", "", "value", "", "constructor-impl", "(J)J", "offsetMillis", "", "offsetType", "Landroidx/compose/animation/core/StartOffsetType;", "(II)J", "getOffsetMillis-impl", "(J)I", "getOffsetType-Eo1U57Q", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "animation-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class StartOffset {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffset m234boximpl(long j) {
        return new StartOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m236constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m238equalsimpl(long j, Object obj) {
        return (obj instanceof StartOffset) && j == ((StartOffset) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m239equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m242hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m243toStringimpl(long j) {
        return "StartOffset(value=" + j + ')';
    }

    public boolean equals(Object other) {
        return m238equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m242hashCodeimpl(this.value);
    }

    public String toString() {
        return m243toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ StartOffset(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m237constructorimpl$default(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            i2 = StartOffsetType.INSTANCE.m252getDelayEo1U57Q();
        }
        return m235constructorimpl(i, i2);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m235constructorimpl(int i, int i2) {
        return m236constructorimpl(i * i2);
    }

    /* JADX INFO: renamed from: getOffsetMillis-impl, reason: not valid java name */
    public static final int m240getOffsetMillisimpl(long j) {
        return Math.abs((int) j);
    }

    /* JADX INFO: renamed from: getOffsetType-Eo1U57Q, reason: not valid java name */
    public static final int m241getOffsetTypeEo1U57Q(long j) {
        boolean z = j > 0;
        if (z) {
            return StartOffsetType.INSTANCE.m253getFastForwardEo1U57Q();
        }
        if (z) {
            throw new NoWhenBranchMatchedException();
        }
        return StartOffsetType.INSTANCE.m252getDelayEo1U57Q();
    }
}
