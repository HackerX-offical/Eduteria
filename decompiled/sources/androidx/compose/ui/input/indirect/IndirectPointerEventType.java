package androidx.compose.ui.input.indirect;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IndirectPointerEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class IndirectPointerEventType {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unknown = m6806constructorimpl(0);
    private static final int Press = m6806constructorimpl(1);
    private static final int Release = m6806constructorimpl(2);
    private static final int Move = m6806constructorimpl(3);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IndirectPointerEventType m6805boximpl(int i) {
        return new IndirectPointerEventType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m6806constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6807equalsimpl(int i, Object obj) {
        return (obj instanceof IndirectPointerEventType) && i == ((IndirectPointerEventType) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6808equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6809hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m6807equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m6809hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: IndirectPointerEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectPointerEventType$Companion;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "getUnknown-4ZHQPSE", "()I", "I", "Press", "getPress-4ZHQPSE", "Release", "getRelease-4ZHQPSE", "Move", "getMove-4ZHQPSE", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnknown-4ZHQPSE, reason: not valid java name */
        public final int m6815getUnknown4ZHQPSE() {
            return IndirectPointerEventType.Unknown;
        }

        /* JADX INFO: renamed from: getPress-4ZHQPSE, reason: not valid java name */
        public final int m6813getPress4ZHQPSE() {
            return IndirectPointerEventType.Press;
        }

        /* JADX INFO: renamed from: getRelease-4ZHQPSE, reason: not valid java name */
        public final int m6814getRelease4ZHQPSE() {
            return IndirectPointerEventType.Release;
        }

        /* JADX INFO: renamed from: getMove-4ZHQPSE, reason: not valid java name */
        public final int m6812getMove4ZHQPSE() {
            return IndirectPointerEventType.Move;
        }
    }

    private /* synthetic */ IndirectPointerEventType(int i) {
        this.value = i;
    }

    public String toString() {
        return m6810toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6810toStringimpl(int i) {
        return m6808equalsimpl0(i, Press) ? "Press" : m6808equalsimpl0(i, Release) ? "Release" : m6808equalsimpl0(i, Move) ? "Move" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
