package androidx.compose.ui.unit;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "()V", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", Constants.COPY_TYPE, "copy-tPigGR8", "(JFF)J", "minus", "other", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "", "Companion", "ui-unit"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class DpOffset {
    private final long packedValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m8886constructorimpl(0);
    private static final long Unspecified = m8886constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m8885boximpl(long j) {
        return new DpOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m8886constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8889equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m8899unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8890equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m8892getXD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m8894getYD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8895hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m8889equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m8895hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m8899unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m8888copytPigGR8$default(long j, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = m8891getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f3 = m8893getYD9Ej5fM(j);
        }
        return m8887copytPigGR8(j, f2, f3);
    }

    /* JADX INFO: renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m8896minusCBMgk4(long j, long j2) {
        float fM8830constructorimpl = Dp.m8830constructorimpl(m8891getXD9Ej5fM(j) - m8891getXD9Ej5fM(j2));
        float fM8830constructorimpl2 = Dp.m8830constructorimpl(m8893getYD9Ej5fM(j) - m8893getYD9Ej5fM(j2));
        return m8886constructorimpl((((long) Float.floatToRawIntBits(fM8830constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM8830constructorimpl2))));
    }

    /* JADX INFO: renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m8897plusCBMgk4(long j, long j2) {
        float fM8830constructorimpl = Dp.m8830constructorimpl(m8891getXD9Ej5fM(j) + m8891getXD9Ej5fM(j2));
        float fM8830constructorimpl2 = Dp.m8830constructorimpl(m8893getYD9Ej5fM(j) + m8893getYD9Ej5fM(j2));
        return m8886constructorimpl((((long) Float.floatToRawIntBits(fM8830constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM8830constructorimpl2))));
    }

    public String toString() {
        return m8898toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8898toStringimpl(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "(" + ((Object) Dp.m8841toStringimpl(m8891getXD9Ej5fM(j))) + ", " + ((Object) Dp.m8841toStringimpl(m8893getYD9Ej5fM(j))) + ')';
        }
        return "DpOffset.Unspecified";
    }

    /* JADX INFO: compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/DpOffset;", "getZero-RKDOV3M", "()J", "J", "Unspecified", "getUnspecified-RKDOV3M", "ui-unit"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m8901getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        /* JADX INFO: renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m8900getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m8891getXD9Ej5fM(long j) {
        return Dp.m8830constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m8893getYD9Ej5fM(long j) {
        return Dp.m8830constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m8887copytPigGR8(long j, float f2, float f3) {
        return m8886constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
    }
}
