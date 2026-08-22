package androidx.compose.foundation.text.modifiers;

import com.appnew.android.Utils.Const;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ParagraphLayoutCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "", Const.FLAG, "", "constructor-impl", "(J)J", "getFlag", "()J", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class LayoutCacheOperation {
    private final long flag;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long MarkDirtyStyle = m2209constructorimpl(0);
    private static final long MarkDirtyDensity = m2209constructorimpl(1);
    private static final long MarkDirtyNode = m2209constructorimpl(2);
    private static final long LayoutWithConstraints = m2209constructorimpl(3);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LayoutCacheOperation m2208boximpl(long j) {
        return new LayoutCacheOperation(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m2209constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2210equalsimpl(long j, Object obj) {
        return (obj instanceof LayoutCacheOperation) && j == ((LayoutCacheOperation) obj).m2214unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2211equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2212hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2213toStringimpl(long j) {
        return "LayoutCacheOperation(flag=" + j + ')';
    }

    public boolean equals(Object other) {
        return m2210equalsimpl(this.flag, other);
    }

    public int hashCode() {
        return m2212hashCodeimpl(this.flag);
    }

    public String toString() {
        return m2213toStringimpl(this.flag);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2214unboximpl() {
        return this.flag;
    }

    /* JADX INFO: compiled from: ParagraphLayoutCache.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation$Companion;", "", "<init>", "()V", "MarkDirtyStyle", "Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "getMarkDirtyStyle-DEKiAbY", "()J", "J", "MarkDirtyDensity", "getMarkDirtyDensity-DEKiAbY", "MarkDirtyNode", "getMarkDirtyNode-DEKiAbY", "LayoutWithConstraints", "getLayoutWithConstraints-DEKiAbY", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getMarkDirtyStyle-DEKiAbY, reason: not valid java name */
        public final long m2218getMarkDirtyStyleDEKiAbY() {
            return LayoutCacheOperation.MarkDirtyStyle;
        }

        /* JADX INFO: renamed from: getMarkDirtyDensity-DEKiAbY, reason: not valid java name */
        public final long m2216getMarkDirtyDensityDEKiAbY() {
            return LayoutCacheOperation.MarkDirtyDensity;
        }

        /* JADX INFO: renamed from: getMarkDirtyNode-DEKiAbY, reason: not valid java name */
        public final long m2217getMarkDirtyNodeDEKiAbY() {
            return LayoutCacheOperation.MarkDirtyNode;
        }

        /* JADX INFO: renamed from: getLayoutWithConstraints-DEKiAbY, reason: not valid java name */
        public final long m2215getLayoutWithConstraintsDEKiAbY() {
            return LayoutCacheOperation.LayoutWithConstraints;
        }
    }

    private /* synthetic */ LayoutCacheOperation(long j) {
        this.flag = j;
    }

    public final long getFlag() {
        return this.flag;
    }
}
