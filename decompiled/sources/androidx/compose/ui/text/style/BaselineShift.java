package androidx.compose.ui.text.style;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BaselineShift.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift;", "", "multiplier", "", "constructor-impl", "(F)F", "getMultiplier", "()F", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class BaselineShift {
    private final float multiplier;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Superscript = m8571constructorimpl(0.5f);
    private static final float Subscript = m8571constructorimpl(-0.5f);
    private static final float None = m8571constructorimpl(0.0f);
    private static final float Unspecified = m8571constructorimpl(Float.NaN);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BaselineShift m8570boximpl(float f2) {
        return new BaselineShift(f2);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m8571constructorimpl(float f2) {
        return f2;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8572equalsimpl(float f2, Object obj) {
        return (obj instanceof BaselineShift) && Float.compare(f2, ((BaselineShift) obj).m8576unboximpl()) == 0;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8573equalsimpl0(float f2, float f3) {
        return Float.compare(f2, f3) == 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8574hashCodeimpl(float f2) {
        return Float.hashCode(f2);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8575toStringimpl(float f2) {
        return "BaselineShift(multiplier=" + f2 + ')';
    }

    public boolean equals(Object other) {
        return m8572equalsimpl(this.multiplier, other);
    }

    public int hashCode() {
        return m8574hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m8575toStringimpl(this.multiplier);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m8576unboximpl() {
        return this.multiplier;
    }

    /* JADX INFO: compiled from: BaselineShift.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/style/BaselineShift$Companion;", "", "<init>", "()V", "Superscript", "Landroidx/compose/ui/text/style/BaselineShift;", "getSuperscript-y9eOQZs$annotations", "getSuperscript-y9eOQZs", "()F", "F", "Subscript", "getSubscript-y9eOQZs$annotations", "getSubscript-y9eOQZs", "None", "getNone-y9eOQZs$annotations", "getNone-y9eOQZs", "Unspecified", "getUnspecified-y9eOQZs$annotations", "getUnspecified-y9eOQZs", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getNone-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m8577getNoney9eOQZs$annotations() {
        }

        /* JADX INFO: renamed from: getSubscript-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m8578getSubscripty9eOQZs$annotations() {
        }

        /* JADX INFO: renamed from: getSuperscript-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m8579getSuperscripty9eOQZs$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-y9eOQZs$annotations, reason: not valid java name */
        public static /* synthetic */ void m8580getUnspecifiedy9eOQZs$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getSuperscript-y9eOQZs, reason: not valid java name */
        public final float m8583getSuperscripty9eOQZs() {
            return BaselineShift.Superscript;
        }

        /* JADX INFO: renamed from: getSubscript-y9eOQZs, reason: not valid java name */
        public final float m8582getSubscripty9eOQZs() {
            return BaselineShift.Subscript;
        }

        /* JADX INFO: renamed from: getNone-y9eOQZs, reason: not valid java name */
        public final float m8581getNoney9eOQZs() {
            return BaselineShift.None;
        }

        /* JADX INFO: renamed from: getUnspecified-y9eOQZs, reason: not valid java name */
        public final float m8584getUnspecifiedy9eOQZs() {
            return BaselineShift.Unspecified;
        }
    }

    private /* synthetic */ BaselineShift(float f2) {
        this.multiplier = f2;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }
}
