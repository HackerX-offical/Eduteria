package androidx.compose.ui.unit;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntOffset.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b#\u0010$J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"H\u0087\u0002¢\u0006\u0004\b&\u0010$J\u0018\u0010'\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020+H\u0017¢\u0006\u0004\b,\u0010-J\u0014\u0010.\u001a\u00020/2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00062"}, d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", Constants.COPY_TYPE, "copy-iSbpLlY", "(JII)J", "minus", "other", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "unaryMinus", "unaryMinus-nOcc-ac", "times", "operand", "", "times-Bjo55l4", "(JF)J", "div", "div-Bjo55l4", "rem", "rem-Bjo55l4", "(JI)J", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class IntOffset {
    private final long packedValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m8952constructorimpl(0);
    private static final long Max = m8952constructorimpl(9223372034707292159L);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m8949boximpl(long j) {
        return new IntOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m8952constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8956equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m8967unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8957equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final int m8958getXimpl(long j) {
        return (int) (j >> 32);
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final int m8959getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8960hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m8956equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m8960hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m8967unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m8950component1impl(long j) {
        return m8958getXimpl(j);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m8951component2impl(long j) {
        return m8959getYimpl(j);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m8954copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = (int) (j >> 32);
        }
        if ((i3 & 2) != 0) {
            i2 = (int) (4294967295L & j);
        }
        return m8953copyiSbpLlY(j, i, i2);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m8953copyiSbpLlY(long j, int i, int i2) {
        return m8952constructorimpl((((long) i) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m8961minusqkQi6aY(long j, long j2) {
        return m8952constructorimpl((((long) (((int) (j >> 32)) - ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)))) & 4294967295L));
    }

    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m8962plusqkQi6aY(long j, long j2) {
        return m8952constructorimpl((((long) (((int) (j >> 32)) + ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L)))) & 4294967295L));
    }

    /* JADX INFO: renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m8966unaryMinusnOccac(long j) {
        int i = -((int) (j >> 32));
        return m8952constructorimpl((((long) (-((int) (j & 4294967295L)))) & 4294967295L) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m8963remBjo55l4(long j, int i) {
        return m8952constructorimpl((((long) (((int) (j >> 32)) % i)) << 32) | (((long) (((int) (j & 4294967295L)) % i)) & 4294967295L));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8965toStringimpl(long j) {
        return "(" + m8958getXimpl(j) + ", " + m8959getYimpl(j) + ')';
    }

    public String toString() {
        return m8965toStringimpl(this.packedValue);
    }

    /* JADX INFO: compiled from: IntOffset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "Max", "getMax-nOcc-ac", "ui-unit"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m8969getZeronOccac() {
            return IntOffset.Zero;
        }

        /* JADX INFO: renamed from: getMax-nOcc-ac, reason: not valid java name */
        public final long m8968getMaxnOccac() {
            return IntOffset.Max;
        }
    }

    /* JADX INFO: renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m8964timesBjo55l4(long j, float f2) {
        return m8952constructorimpl((((long) Math.round(((int) (j >> 32)) * f2)) << 32) | (((long) Math.round(((int) (j & 4294967295L)) * f2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m8955divBjo55l4(long j, float f2) {
        return m8952constructorimpl((((long) Math.round(((int) (j >> 32)) / f2)) << 32) | (((long) Math.round(((int) (j & 4294967295L)) / f2)) & 4294967295L));
    }
}
