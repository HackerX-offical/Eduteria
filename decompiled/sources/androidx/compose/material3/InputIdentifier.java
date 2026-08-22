package androidx.compose.material3;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DateInput.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/InputIdentifier;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class InputIdentifier {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SingleDateInput = m3022constructorimpl(0);
    private static final int StartDateInput = m3022constructorimpl(1);
    private static final int EndDateInput = m3022constructorimpl(2);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InputIdentifier m3021boximpl(int i) {
        return new InputIdentifier(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3022constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3023equalsimpl(int i, Object obj) {
        return (obj instanceof InputIdentifier) && i == ((InputIdentifier) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3024equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3025hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m3023equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m3025hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ InputIdentifier(int i) {
        this.value = i;
    }

    /* JADX INFO: compiled from: DateInput.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/InputIdentifier$Companion;", "", "<init>", "()V", "SingleDateInput", "Landroidx/compose/material3/InputIdentifier;", "getSingleDateInput-J2x2o4M", "()I", "I", "StartDateInput", "getStartDateInput-J2x2o4M", "EndDateInput", "getEndDateInput-J2x2o4M", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getSingleDateInput-J2x2o4M, reason: not valid java name */
        public final int m3029getSingleDateInputJ2x2o4M() {
            return InputIdentifier.SingleDateInput;
        }

        /* JADX INFO: renamed from: getStartDateInput-J2x2o4M, reason: not valid java name */
        public final int m3030getStartDateInputJ2x2o4M() {
            return InputIdentifier.StartDateInput;
        }

        /* JADX INFO: renamed from: getEndDateInput-J2x2o4M, reason: not valid java name */
        public final int m3028getEndDateInputJ2x2o4M() {
            return InputIdentifier.EndDateInput;
        }
    }

    public String toString() {
        return m3026toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3026toStringimpl(int i) {
        return m3024equalsimpl0(i, SingleDateInput) ? "SingleDateInput" : m3024equalsimpl0(i, StartDateInput) ? "StartDateInput" : m3024equalsimpl0(i, EndDateInput) ? "EndDateInput" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
