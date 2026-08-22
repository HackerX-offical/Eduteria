package androidx.compose.ui.text.style;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TextAlign.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/style/TextAlign;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class TextAlign {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Left = m8702constructorimpl(1);
    private static final int Right = m8702constructorimpl(2);
    private static final int Center = m8702constructorimpl(3);
    private static final int Justify = m8702constructorimpl(4);
    private static final int Start = m8702constructorimpl(5);
    private static final int End = m8702constructorimpl(6);
    private static final int Unspecified = m8702constructorimpl(0);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m8701boximpl(int i) {
        return new TextAlign(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m8702constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8703equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).m8707unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8704equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8705hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m8703equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m8705hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m8707unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m8706toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8706toStringimpl(int i) {
        return m8704equalsimpl0(i, Left) ? "Left" : m8704equalsimpl0(i, Right) ? "Right" : m8704equalsimpl0(i, Center) ? "Center" : m8704equalsimpl0(i, Justify) ? "Justify" : m8704equalsimpl0(i, Start) ? "Start" : m8704equalsimpl0(i, End) ? "End" : m8704equalsimpl0(i, Unspecified) ? "Unspecified" : "Invalid";
    }

    /* JADX INFO: compiled from: TextAlign.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/text/style/TextAlign$Companion;", "", "<init>", "()V", "Left", "Landroidx/compose/ui/text/style/TextAlign;", "getLeft-e0LSkKk", "()I", "I", "Right", "getRight-e0LSkKk", "Center", "getCenter-e0LSkKk", "Justify", "getJustify-e0LSkKk", "Start", "getStart-e0LSkKk", "End", "getEnd-e0LSkKk", "Unspecified", "getUnspecified-e0LSkKk", "values", "", "valueOf", "value", "", "valueOf-IgVj0fw", "(I)I", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m8711getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* JADX INFO: renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m8712getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* JADX INFO: renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m8708getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* JADX INFO: renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m8710getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* JADX INFO: renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m8713getStarte0LSkKk() {
            return TextAlign.Start;
        }

        /* JADX INFO: renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m8709getEnde0LSkKk() {
            return TextAlign.End;
        }

        /* JADX INFO: renamed from: getUnspecified-e0LSkKk, reason: not valid java name */
        public final int m8714getUnspecifiede0LSkKk() {
            return TextAlign.Unspecified;
        }

        public final List<TextAlign> values() {
            return CollectionsKt.listOf((Object[]) new TextAlign[]{TextAlign.m8701boximpl(m8711getLefte0LSkKk()), TextAlign.m8701boximpl(m8712getRighte0LSkKk()), TextAlign.m8701boximpl(m8708getCentere0LSkKk()), TextAlign.m8701boximpl(m8710getJustifye0LSkKk()), TextAlign.m8701boximpl(m8713getStarte0LSkKk()), TextAlign.m8701boximpl(m8709getEnde0LSkKk())});
        }

        /* JADX INFO: renamed from: valueOf-IgVj0fw, reason: not valid java name */
        public final int m8715valueOfIgVj0fw(int value) {
            boolean z = false;
            if (value >= 0 && value < 7) {
                z = true;
            }
            if (!z) {
                InlineClassHelperKt.throwIllegalArgumentException("The given value=" + value + " is not recognized by TextAlign.");
            }
            return TextAlign.m8702constructorimpl(value);
        }
    }
}
