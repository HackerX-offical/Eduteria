package androidx.compose.ui.text.font;

import com.appnew.android.Utils.Const;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FontStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/FontStyle;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class FontStyle {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Normal = m8385constructorimpl(0);
    private static final int Italic = m8385constructorimpl(1);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontStyle m8384boximpl(int i) {
        return new FontStyle(i);
    }

    @Deprecated(message = "Please use FontStyle.Normal or FontStyle.Italic", replaceWith = @ReplaceWith(expression = "FontStyle.", imports = {}))
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m8385constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8386equalsimpl(int i, Object obj) {
        return (obj instanceof FontStyle) && i == ((FontStyle) obj).m8390unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8387equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8388hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m8386equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m8388hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m8390unboximpl() {
        return this.value;
    }

    @Deprecated(message = "Please use FontStyle.Normal or FontStyle.Italic", replaceWith = @ReplaceWith(expression = "FontStyle.", imports = {}))
    private /* synthetic */ FontStyle(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m8389toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8389toStringimpl(int i) {
        return m8387equalsimpl0(i, Normal) ? Const.Normal : m8387equalsimpl0(i, Italic) ? "Italic" : "Invalid";
    }

    /* JADX INFO: compiled from: FontStyle.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eR\u0019\u0010\u0004\u001a\u00020\u0005¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\u0005¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/font/FontStyle$Companion;", "", "<init>", "()V", Const.Normal, "Landroidx/compose/ui/text/font/FontStyle;", "getNormal-_-LCdwA$annotations", "getNormal-_-LCdwA", "()I", "I", "Italic", "getItalic-_-LCdwA$annotations", "getItalic-_-LCdwA", "values", "", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getItalic-_-LCdwA$annotations, reason: not valid java name */
        public static /* synthetic */ void m8391getItalic_LCdwA$annotations() {
        }

        /* JADX INFO: renamed from: getNormal-_-LCdwA$annotations, reason: not valid java name */
        public static /* synthetic */ void m8392getNormal_LCdwA$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNormal-_-LCdwA, reason: not valid java name */
        public final int m8394getNormal_LCdwA() {
            return FontStyle.Normal;
        }

        /* JADX INFO: renamed from: getItalic-_-LCdwA, reason: not valid java name */
        public final int m8393getItalic_LCdwA() {
            return FontStyle.Italic;
        }

        public final List<FontStyle> values() {
            return CollectionsKt.listOf((Object[]) new FontStyle[]{FontStyle.m8384boximpl(m8394getNormal_LCdwA()), FontStyle.m8384boximpl(m8393getItalic_LCdwA())});
        }
    }
}
