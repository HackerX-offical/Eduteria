package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InlineDensity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity;", "", "packedValue", "", "constructor-impl", "(J)J", "density", "", "fontScale", "(FF)J", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)J", "getDensity-impl", "(J)F", "getFontScale-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class InlineDensity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Unspecified = m2197constructorimpl(Float.NaN, Float.NaN);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InlineDensity m2196boximpl(long j) {
        return new InlineDensity(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m2198constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2200equalsimpl(long j, Object obj) {
        return (obj instanceof InlineDensity) && j == ((InlineDensity) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2201equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2204hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m2200equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m2204hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ InlineDensity(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2199constructorimpl(Density density) {
        return m2197constructorimpl(density.getDensity(), density.getFontScale());
    }

    public String toString() {
        return m2205toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2205toStringimpl(long j) {
        return "InlineDensity(density=" + m2202getDensityimpl(j) + ", fontScale=" + m2203getFontScaleimpl(j) + ')';
    }

    /* JADX INFO: compiled from: InlineDensity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "getUnspecified-L26CHvs", "()J", "J", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-L26CHvs, reason: not valid java name */
        public final long m2207getUnspecifiedL26CHvs() {
            return InlineDensity.Unspecified;
        }
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2197constructorimpl(float f2, float f3) {
        return m2198constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    /* JADX INFO: renamed from: getDensity-impl, reason: not valid java name */
    public static final float m2202getDensityimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getFontScale-impl, reason: not valid java name */
    public static final float m2203getFontScaleimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
