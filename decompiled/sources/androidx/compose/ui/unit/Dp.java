package androidx.compose.ui.unit;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000f\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0011\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0013J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0014\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0016\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0000H\u0097\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010 HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "plus", "other", "plus-5rwHm24", "(FF)F", "minus", "minus-5rwHm24", "unaryMinus", "unaryMinus-D9Ej5fM", "div", "div-u2uoSUM", "", "(FI)F", "div-0680j_4", "times", "times-u2uoSUM", "compareTo", "compareTo-0680j_4", "(FF)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class Dp implements Comparable<Dp> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Hairline = m8830constructorimpl(0.0f);
    private static final float Infinity = m8830constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m8830constructorimpl(Float.NaN);
    private final float value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Dp m8828boximpl(float f2) {
        return new Dp(f2);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m8830constructorimpl(float f2) {
        return f2;
    }

    /* JADX INFO: renamed from: div-0680j_4, reason: not valid java name */
    public static final float m8831div0680j_4(float f2, float f3) {
        return f2 / f3;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8834equalsimpl(float f2, Object obj) {
        return (obj instanceof Dp) && Float.compare(f2, ((Dp) obj).m8844unboximpl()) == 0;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8835equalsimpl0(float f2, float f3) {
        return Float.compare(f2, f3) == 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8836hashCodeimpl(float f2) {
        return Float.hashCode(f2);
    }

    public boolean equals(Object other) {
        return m8834equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m8836hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m8844unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Dp dp) {
        return m8843compareTo0680j_4(dp.m8844unboximpl());
    }

    private /* synthetic */ Dp(float f2) {
        this.value = f2;
    }

    public final float getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m8838plus5rwHm24(float f2, float f3) {
        return m8830constructorimpl(f2 + f3);
    }

    /* JADX INFO: renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m8837minus5rwHm24(float f2, float f3) {
        return m8830constructorimpl(f2 - f3);
    }

    /* JADX INFO: renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m8842unaryMinusD9Ej5fM(float f2) {
        return m8830constructorimpl(-f2);
    }

    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m8832divu2uoSUM(float f2, float f3) {
        return m8830constructorimpl(f2 / f3);
    }

    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m8833divu2uoSUM(float f2, int i) {
        return m8830constructorimpl(f2 / i);
    }

    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m8839timesu2uoSUM(float f2, float f3) {
        return m8830constructorimpl(f2 * f3);
    }

    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m8840timesu2uoSUM(float f2, int i) {
        return m8830constructorimpl(f2 * i);
    }

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m8843compareTo0680j_4(float f2) {
        return m8829compareTo0680j_4(this.value, f2);
    }

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m8829compareTo0680j_4(float f2, float f3) {
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            return 0;
        }
        return Float.compare(f2, f3);
    }

    public String toString() {
        return m8841toStringimpl(this.value);
    }

    /* JADX INFO: compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", "<init>", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", "F", "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m8845getHairlineD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m8846getInfinityD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m8847getUnspecifiedD9Ej5fM$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m8848getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m8849getInfinityD9Ej5fM() {
            return Dp.Infinity;
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m8850getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8841toStringimpl(float f2) {
        return Float.isNaN(f2) ? "Dp.Unspecified" : f2 + ".dp";
    }
}
