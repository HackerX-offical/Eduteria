package androidx.compose.ui.layout;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScaleFactor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006("}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "scaleX", "", "getScaleX$annotations", "()V", "getScaleX-impl", "(J)F", "scaleY", "getScaleY$annotations", "getScaleY-impl", "component1", "component1-impl", "component2", "component2-impl", Constants.COPY_TYPE, "copy-8GGzs04", "(JFF)J", "times", "operand", "times-44nBxM0", "(JF)J", "div", "div-44nBxM0", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class ScaleFactor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Unspecified = m7555constructorimpl((((long) Float.floatToRawIntBits(Float.NaN)) << 32) | (((long) Float.floatToRawIntBits(Float.NaN)) & 4294967295L));
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m7552boximpl(long j) {
        return new ScaleFactor(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m7555constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m7559equalsimpl(long j, Object obj) {
        return (obj instanceof ScaleFactor) && j == ((ScaleFactor) obj).m7566unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7560equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getScaleX$annotations() {
    }

    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m7563hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m7559equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m7563hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7566unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ ScaleFactor(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m7565toStringimpl(long j) {
        return "ScaleFactor(" + Float.intBitsToFloat((int) (j >> 32)) + ", " + Float.intBitsToFloat((int) (j & 4294967295L)) + ')';
    }

    public String toString() {
        return m7565toStringimpl(this.packedValue);
    }

    /* JADX INFO: compiled from: ScaleFactor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/layout/ScaleFactor;", "getUnspecified-_hLwfpc$annotations", "getUnspecified-_hLwfpc", "()J", "J", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-_hLwfpc$annotations, reason: not valid java name */
        public static /* synthetic */ void m7567getUnspecified_hLwfpc$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-_hLwfpc, reason: not valid java name */
        public final long m7568getUnspecified_hLwfpc() {
            return ScaleFactor.Unspecified;
        }
    }

    /* JADX INFO: renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m7561getScaleXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m7562getScaleYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m7553component1impl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m7554component2impl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: copy-8GGzs04, reason: not valid java name */
    public static final long m7556copy8GGzs04(long j, float f2, float f3) {
        return m7555constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
    }

    /* JADX INFO: renamed from: copy-8GGzs04$default, reason: not valid java name */
    public static /* synthetic */ long m7557copy8GGzs04$default(long j, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f3 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m7556copy8GGzs04(j, f2, f3);
    }

    /* JADX INFO: renamed from: times-44nBxM0, reason: not valid java name */
    public static final long m7564times44nBxM0(long j, float f2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * f2;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * f2;
        return m7555constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-44nBxM0, reason: not valid java name */
    public static final long m7558div44nBxM0(long j, float f2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / f2;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) / f2;
        return m7555constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }
}
