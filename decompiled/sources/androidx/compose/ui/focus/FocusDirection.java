package androidx.compose.ui.focus;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FocusDirection.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class FocusDirection {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Next = m5596constructorimpl(1);
    private static final int Previous = m5596constructorimpl(2);
    private static final int Left = m5596constructorimpl(3);
    private static final int Right = m5596constructorimpl(4);
    private static final int Up = m5596constructorimpl(5);
    private static final int Down = m5596constructorimpl(6);
    private static final int Enter = m5596constructorimpl(7);
    private static final int Exit = m5596constructorimpl(8);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FocusDirection m5595boximpl(int i) {
        return new FocusDirection(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5596constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5597equalsimpl(int i, Object obj) {
        return (obj instanceof FocusDirection) && i == ((FocusDirection) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5598equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5599hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m5597equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m5599hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ FocusDirection(int i) {
        this.value = i;
    }

    public String toString() {
        return m5600toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5600toStringimpl(int i) {
        return m5598equalsimpl0(i, Next) ? "Next" : m5598equalsimpl0(i, Previous) ? "Previous" : m5598equalsimpl0(i, Left) ? "Left" : m5598equalsimpl0(i, Right) ? "Right" : m5598equalsimpl0(i, Up) ? "Up" : m5598equalsimpl0(i, Down) ? "Down" : m5598equalsimpl0(i, Enter) ? "Enter" : m5598equalsimpl0(i, Exit) ? "Exit" : "Invalid FocusDirection";
    }

    /* JADX INFO: compiled from: FocusDirection.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection$Companion;", "", "<init>", "()V", "Next", "Landroidx/compose/ui/focus/FocusDirection;", "getNext-dhqQ-8s", "()I", "I", "Previous", "getPrevious-dhqQ-8s", "Left", "getLeft-dhqQ-8s", "Right", "getRight-dhqQ-8s", "Up", "getUp-dhqQ-8s", "Down", "getDown-dhqQ-8s", "Enter", "getEnter-dhqQ-8s", "Exit", "getExit-dhqQ-8s", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNext-dhqQ-8s, reason: not valid java name */
        public final int m5606getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        /* JADX INFO: renamed from: getPrevious-dhqQ-8s, reason: not valid java name */
        public final int m5607getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* JADX INFO: renamed from: getLeft-dhqQ-8s, reason: not valid java name */
        public final int m5605getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* JADX INFO: renamed from: getRight-dhqQ-8s, reason: not valid java name */
        public final int m5608getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* JADX INFO: renamed from: getUp-dhqQ-8s, reason: not valid java name */
        public final int m5609getUpdhqQ8s() {
            return FocusDirection.Up;
        }

        /* JADX INFO: renamed from: getDown-dhqQ-8s, reason: not valid java name */
        public final int m5602getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        /* JADX INFO: renamed from: getEnter-dhqQ-8s, reason: not valid java name */
        public final int m5603getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        /* JADX INFO: renamed from: getExit-dhqQ-8s, reason: not valid java name */
        public final int m5604getExitdhqQ8s() {
            return FocusDirection.Exit;
        }
    }
}
