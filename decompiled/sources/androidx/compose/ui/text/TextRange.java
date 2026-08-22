package androidx.compose.ui.text;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

/* JADX INFO: compiled from: TextRange.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u0014\u0010%\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextRange;", "", "packedValue", "", "constructor-impl", "(J)J", "start", "", "getStart-impl", "(J)I", "end", "getEnd-impl", "min", "getMin-impl", Constants.PRIORITY_MAX, "getMax-impl", "collapsed", "", "getCollapsed-impl", "(J)Z", "reversed", "getReversed-impl", Range.ATTR_LENGTH, "getLength-impl", "intersects", "other", "intersects-5zc-tL8", "(JJ)Z", "contains", "contains-5zc-tL8", "offset", "contains-impl", "(JI)Z", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class TextRange {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m8261boximpl(long j) {
        return new TextRange(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m8262constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8265equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8266equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m8268getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m8273getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8274hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m8265equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m8274hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: getMin-impl, reason: not valid java name */
    public static final int m8271getMinimpl(long j) {
        return Math.min(m8273getStartimpl(j), m8268getEndimpl(j));
    }

    /* JADX INFO: renamed from: getMax-impl, reason: not valid java name */
    public static final int m8270getMaximpl(long j) {
        return Math.max(m8273getStartimpl(j), m8268getEndimpl(j));
    }

    /* JADX INFO: renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m8267getCollapsedimpl(long j) {
        return m8273getStartimpl(j) == m8268getEndimpl(j);
    }

    /* JADX INFO: renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m8272getReversedimpl(long j) {
        return m8273getStartimpl(j) > m8268getEndimpl(j);
    }

    /* JADX INFO: renamed from: getLength-impl, reason: not valid java name */
    public static final int m8269getLengthimpl(long j) {
        return m8270getMaximpl(j) - m8271getMinimpl(j);
    }

    /* JADX INFO: renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m8275intersects5zctL8(long j, long j2) {
        return (m8271getMinimpl(j) < m8270getMaximpl(j2)) & (m8271getMinimpl(j2) < m8270getMaximpl(j));
    }

    /* JADX INFO: renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m8263contains5zctL8(long j, long j2) {
        return (m8271getMinimpl(j) <= m8271getMinimpl(j2)) & (m8270getMaximpl(j2) <= m8270getMaximpl(j));
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m8264containsimpl(long j, int i) {
        return i < m8270getMaximpl(j) && m8271getMinimpl(j) <= i;
    }

    public String toString() {
        return m8276toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8276toStringimpl(long j) {
        return "TextRange(" + m8273getStartimpl(j) + ", " + m8268getEndimpl(j) + ')';
    }

    /* JADX INFO: compiled from: TextRange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextRange$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/text/TextRange;", "getZero-d9O1mEE", "()J", "J", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m8278getZerod9O1mEE() {
            return TextRange.Zero;
        }
    }
}
