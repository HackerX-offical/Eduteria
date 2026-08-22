package androidx.compose.foundation.layout;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0014\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides;", "", "value", "", "constructor-impl", "(I)I", "plus", "sides", "plus-gK_yJZ4", "(II)I", "hasAny", "", "hasAny-bkgdKaI$foundation_layout", "(II)Z", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "valueToString", "valueToString-impl", "equals", "other", "hashCode", "Companion", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class WindowInsetsSides {
    private static final int AllowLeftInLtr;
    private static final int AllowLeftInRtl;
    private static final int AllowRightInLtr;
    private static final int AllowRightInRtl;
    private static final int Bottom;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int End;
    private static final int Horizontal;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Top;
    private static final int Vertical;
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ WindowInsetsSides m1260boximpl(int i) {
        return new WindowInsetsSides(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1261constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1262equalsimpl(int i, Object obj) {
        return (obj instanceof WindowInsetsSides) && i == ((WindowInsetsSides) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1263equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hasAny-bkgdKaI$foundation_layout, reason: not valid java name */
    public static final boolean m1264hasAnybkgdKaI$foundation_layout(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1265hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m1262equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m1265hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ WindowInsetsSides(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m1266plusgK_yJZ4(int i, int i2) {
        return m1261constructorimpl(i | i2);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1267toStringimpl(int i) {
        return "WindowInsetsSides(" + m1268valueToStringimpl(i) + ')';
    }

    public String toString() {
        return m1267toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: valueToString-impl, reason: not valid java name */
    private static final String m1268valueToStringimpl(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = Start;
        if ((i & i2) == i2) {
            valueToString_impl$lambda$0$appendPlus(sb, "Start");
        }
        int i3 = Left;
        if ((i & i3) == i3) {
            valueToString_impl$lambda$0$appendPlus(sb, "Left");
        }
        int i4 = Top;
        if ((i & i4) == i4) {
            valueToString_impl$lambda$0$appendPlus(sb, "Top");
        }
        int i5 = End;
        if ((i & i5) == i5) {
            valueToString_impl$lambda$0$appendPlus(sb, "End");
        }
        int i6 = Right;
        if ((i & i6) == i6) {
            valueToString_impl$lambda$0$appendPlus(sb, "Right");
        }
        int i7 = Bottom;
        if ((i & i7) == i7) {
            valueToString_impl$lambda$0$appendPlus(sb, "Bottom");
        }
        return sb.toString();
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    /* JADX INFO: compiled from: WindowInsets.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", "", "<init>", "()V", "AllowLeftInLtr", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "getAllowLeftInLtr-JoeWqyM$foundation_layout", "()I", "I", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout", "Start", "getStart-JoeWqyM", "End", "getEnd-JoeWqyM", "Top", "getTop-JoeWqyM", "Bottom", "getBottom-JoeWqyM", "Left", "getLeft-JoeWqyM", "Right", "getRight-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "Vertical", "getVertical-JoeWqyM", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m1270getAllowLeftInLtrJoeWqyM$foundation_layout() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        /* JADX INFO: renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m1272getAllowRightInLtrJoeWqyM$foundation_layout() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        /* JADX INFO: renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m1271getAllowLeftInRtlJoeWqyM$foundation_layout() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        /* JADX INFO: renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout, reason: not valid java name */
        public final int m1273getAllowRightInRtlJoeWqyM$foundation_layout() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        /* JADX INFO: renamed from: getStart-JoeWqyM, reason: not valid java name */
        public final int m1279getStartJoeWqyM() {
            return WindowInsetsSides.Start;
        }

        /* JADX INFO: renamed from: getEnd-JoeWqyM, reason: not valid java name */
        public final int m1275getEndJoeWqyM() {
            return WindowInsetsSides.End;
        }

        /* JADX INFO: renamed from: getTop-JoeWqyM, reason: not valid java name */
        public final int m1280getTopJoeWqyM() {
            return WindowInsetsSides.Top;
        }

        /* JADX INFO: renamed from: getBottom-JoeWqyM, reason: not valid java name */
        public final int m1274getBottomJoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        /* JADX INFO: renamed from: getLeft-JoeWqyM, reason: not valid java name */
        public final int m1277getLeftJoeWqyM() {
            return WindowInsetsSides.Left;
        }

        /* JADX INFO: renamed from: getRight-JoeWqyM, reason: not valid java name */
        public final int m1278getRightJoeWqyM() {
            return WindowInsetsSides.Right;
        }

        /* JADX INFO: renamed from: getHorizontal-JoeWqyM, reason: not valid java name */
        public final int m1276getHorizontalJoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }

        /* JADX INFO: renamed from: getVertical-JoeWqyM, reason: not valid java name */
        public final int m1281getVerticalJoeWqyM() {
            return WindowInsetsSides.Vertical;
        }
    }

    static {
        int iM1261constructorimpl = m1261constructorimpl(8);
        AllowLeftInLtr = iM1261constructorimpl;
        int iM1261constructorimpl2 = m1261constructorimpl(4);
        AllowRightInLtr = iM1261constructorimpl2;
        int iM1261constructorimpl3 = m1261constructorimpl(2);
        AllowLeftInRtl = iM1261constructorimpl3;
        int iM1261constructorimpl4 = m1261constructorimpl(1);
        AllowRightInRtl = iM1261constructorimpl4;
        Start = m1266plusgK_yJZ4(iM1261constructorimpl, iM1261constructorimpl4);
        End = m1266plusgK_yJZ4(iM1261constructorimpl2, iM1261constructorimpl3);
        int iM1261constructorimpl5 = m1261constructorimpl(16);
        Top = iM1261constructorimpl5;
        int iM1261constructorimpl6 = m1261constructorimpl(32);
        Bottom = iM1261constructorimpl6;
        int iM1266plusgK_yJZ4 = m1266plusgK_yJZ4(iM1261constructorimpl, iM1261constructorimpl3);
        Left = iM1266plusgK_yJZ4;
        int iM1266plusgK_yJZ42 = m1266plusgK_yJZ4(iM1261constructorimpl2, iM1261constructorimpl4);
        Right = iM1266plusgK_yJZ42;
        Horizontal = m1266plusgK_yJZ4(iM1266plusgK_yJZ4, iM1266plusgK_yJZ42);
        Vertical = m1266plusgK_yJZ4(iM1261constructorimpl5, iM1261constructorimpl6);
    }
}
