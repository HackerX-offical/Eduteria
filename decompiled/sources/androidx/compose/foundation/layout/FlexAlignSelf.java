package androidx.compose.foundation.layout;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FlexBox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/layout/FlexAlignSelf;", "", "bits", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class FlexAlignSelf {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int bits;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FlexAlignSelf m898boximpl(int i) {
        return new FlexAlignSelf(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m899constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m900equalsimpl(int i, Object obj) {
        return (obj instanceof FlexAlignSelf) && i == ((FlexAlignSelf) obj).getBits();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m901equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m902hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m900equalsimpl(this.bits, other);
    }

    public int hashCode() {
        return m902hashCodeimpl(this.bits);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getBits() {
        return this.bits;
    }

    private /* synthetic */ FlexAlignSelf(int i) {
        this.bits = i;
    }

    public String toString() {
        return m903toStringimpl(this.bits);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m903toStringimpl(int i) {
        if (i == 0) {
            return "Auto";
        }
        if (i == 1) {
            return "Start";
        }
        if (i == 2) {
            return "End";
        }
        if (i == 3) {
            return "Center";
        }
        if (i == 4) {
            return "Stretch";
        }
        if (i == 5) {
            return "Baseline";
        }
        return "INVALID";
    }

    /* JADX INFO: compiled from: FlexBox.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0012\u0010\f\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0012\u0010\u0010\u001a\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/FlexAlignSelf$Companion;", "", "<init>", "()V", "Auto", "Landroidx/compose/foundation/layout/FlexAlignSelf;", "getAuto-_ov7Qcc", "()I", "Start", "getStart-_ov7Qcc", "End", "getEnd-_ov7Qcc", "Center", "getCenter-_ov7Qcc", "Stretch", "getStretch-_ov7Qcc", "Baseline", "getBaseline-_ov7Qcc", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getAuto-_ov7Qcc, reason: not valid java name */
        public final int m905getAuto_ov7Qcc() {
            return FlexAlignSelf.m899constructorimpl(0);
        }

        /* JADX INFO: renamed from: getStart-_ov7Qcc, reason: not valid java name */
        public final int m909getStart_ov7Qcc() {
            return FlexAlignSelf.m899constructorimpl(1);
        }

        /* JADX INFO: renamed from: getEnd-_ov7Qcc, reason: not valid java name */
        public final int m908getEnd_ov7Qcc() {
            return FlexAlignSelf.m899constructorimpl(2);
        }

        /* JADX INFO: renamed from: getCenter-_ov7Qcc, reason: not valid java name */
        public final int m907getCenter_ov7Qcc() {
            return FlexAlignSelf.m899constructorimpl(3);
        }

        /* JADX INFO: renamed from: getStretch-_ov7Qcc, reason: not valid java name */
        public final int m910getStretch_ov7Qcc() {
            return FlexAlignSelf.m899constructorimpl(4);
        }

        /* JADX INFO: renamed from: getBaseline-_ov7Qcc, reason: not valid java name */
        public final int m906getBaseline_ov7Qcc() {
            return FlexAlignSelf.m899constructorimpl(5);
        }
    }
}
