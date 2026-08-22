package androidx.compose.material3;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Tooltip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/TooltipAnchorPosition;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TooltipAnchorPosition {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Above = m3881constructorimpl(1);
    private static final int Below = m3881constructorimpl(2);
    private static final int Left = m3881constructorimpl(3);
    private static final int Right = m3881constructorimpl(4);
    private static final int Start = m3881constructorimpl(5);
    private static final int End = m3881constructorimpl(6);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TooltipAnchorPosition m3880boximpl(int i) {
        return new TooltipAnchorPosition(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3881constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3882equalsimpl(int i, Object obj) {
        return (obj instanceof TooltipAnchorPosition) && i == ((TooltipAnchorPosition) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3883equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3884hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m3882equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m3884hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ TooltipAnchorPosition(int i) {
        this.value = i;
    }

    public String toString() {
        return m3885toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3885toStringimpl(int i) {
        return m3883equalsimpl0(i, Above) ? "Above" : m3883equalsimpl0(i, Below) ? "Below" : m3883equalsimpl0(i, Left) ? "Left" : m3883equalsimpl0(i, Right) ? "Right" : m3883equalsimpl0(i, Start) ? "Start" : m3883equalsimpl0(i, End) ? "End" : "Invalid";
    }

    /* JADX INFO: compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/TooltipAnchorPosition$Companion;", "", "<init>", "()V", "Above", "Landroidx/compose/material3/TooltipAnchorPosition;", "getAbove-lOKsHw4", "()I", "I", "Below", "getBelow-lOKsHw4", "Left", "getLeft-lOKsHw4", "Right", "getRight-lOKsHw4", "Start", "getStart-lOKsHw4", "End", "getEnd-lOKsHw4", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getAbove-lOKsHw4, reason: not valid java name */
        public final int m3887getAbovelOKsHw4() {
            return TooltipAnchorPosition.Above;
        }

        /* JADX INFO: renamed from: getBelow-lOKsHw4, reason: not valid java name */
        public final int m3888getBelowlOKsHw4() {
            return TooltipAnchorPosition.Below;
        }

        /* JADX INFO: renamed from: getLeft-lOKsHw4, reason: not valid java name */
        public final int m3890getLeftlOKsHw4() {
            return TooltipAnchorPosition.Left;
        }

        /* JADX INFO: renamed from: getRight-lOKsHw4, reason: not valid java name */
        public final int m3891getRightlOKsHw4() {
            return TooltipAnchorPosition.Right;
        }

        /* JADX INFO: renamed from: getStart-lOKsHw4, reason: not valid java name */
        public final int m3892getStartlOKsHw4() {
            return TooltipAnchorPosition.Start;
        }

        /* JADX INFO: renamed from: getEnd-lOKsHw4, reason: not valid java name */
        public final int m3889getEndlOKsHw4() {
            return TooltipAnchorPosition.End;
        }
    }
}
