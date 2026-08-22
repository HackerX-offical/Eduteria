package androidx.compose.ui.unit;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.mozilla.javascript.typedarrays.Conversions;

/* JADX INFO: compiled from: TextUnit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u000b\u0010\u000eJ\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u000b\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0086\n¢\u0006\u0004\b\u0012\u0010\fJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0086\n¢\u0006\u0004\b\u0012\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010*\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\u000fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b(\u0010)\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, d2 = {"Landroidx/compose/ui/unit/TextUnit;", "", "packedValue", "", "constructor-impl", "(J)J", "unaryMinus", "unaryMinus-XSAIIZE", "div", "other", "", "div-kPz2Gy4", "(JF)J", "", "(JD)J", "", "(JI)J", "times", "times-kPz2Gy4", "compareTo", "compareTo--R2X_6o", "(JJ)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "rawType", "getRawType$annotations", "()V", "getRawType-impl", "type", "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "isSp", "", "isSp-impl", "(J)Z", "isEm", "isEm-impl", "value", "getValue-impl", "(J)F", "equals", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class TextUnit {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextUnitType[] TextUnitTypes = {TextUnitType.m9049boximpl(TextUnitType.INSTANCE.m9058getUnspecifiedUIouoOA()), TextUnitType.m9049boximpl(TextUnitType.INSTANCE.m9057getSpUIouoOA()), TextUnitType.m9049boximpl(TextUnitType.INSTANCE.m9056getEmUIouoOA())};
    private static final long Unspecified = TextUnitKt.pack(0, Float.NaN);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m9014boximpl(long j) {
        return new TextUnit(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m9016constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9020equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9021equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* JADX INFO: renamed from: getRawType-impl, reason: not valid java name */
    public static final long m9022getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9025hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object other) {
        return m9020equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m9025hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m9032unaryMinusXSAIIZE(long j) {
        TextUnitKt.m9037checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m9022getRawTypeimpl(j), -m9024getValueimpl(j));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m9018divkPz2Gy4(long j, float f2) {
        TextUnitKt.m9037checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m9022getRawTypeimpl(j), m9024getValueimpl(j) / f2);
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m9017divkPz2Gy4(long j, double d2) {
        TextUnitKt.m9037checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m9022getRawTypeimpl(j), (float) (((double) m9024getValueimpl(j)) / d2));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m9019divkPz2Gy4(long j, int i) {
        TextUnitKt.m9037checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m9022getRawTypeimpl(j), m9024getValueimpl(j) / i);
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m9029timeskPz2Gy4(long j, float f2) {
        TextUnitKt.m9037checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m9022getRawTypeimpl(j), m9024getValueimpl(j) * f2);
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m9028timeskPz2Gy4(long j, double d2) {
        TextUnitKt.m9037checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m9022getRawTypeimpl(j), (float) (((double) m9024getValueimpl(j)) * d2));
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m9030timeskPz2Gy4(long j, int i) {
        TextUnitKt.m9037checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m9022getRawTypeimpl(j), m9024getValueimpl(j) * i);
    }

    /* JADX INFO: renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m9015compareToR2X_6o(long j, long j2) {
        TextUnitKt.m9038checkArithmeticNB67dxo(j, j2);
        return Float.compare(m9024getValueimpl(j), m9024getValueimpl(j2));
    }

    public String toString() {
        return m9031toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9031toStringimpl(long j) {
        long jM9023getTypeUIouoOA = m9023getTypeUIouoOA(j);
        return TextUnitType.m9052equalsimpl0(jM9023getTypeUIouoOA, TextUnitType.INSTANCE.m9058getUnspecifiedUIouoOA()) ? "Unspecified" : TextUnitType.m9052equalsimpl0(jM9023getTypeUIouoOA, TextUnitType.INSTANCE.m9057getSpUIouoOA()) ? m9024getValueimpl(j) + ".sp" : TextUnitType.m9052equalsimpl0(jM9023getTypeUIouoOA, TextUnitType.INSTANCE.m9056getEmUIouoOA()) ? m9024getValueimpl(j) + ".em" : "Invalid";
    }

    /* JADX INFO: compiled from: TextUnit.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/TextUnit$Companion;", "", "<init>", "()V", "TextUnitTypes", "", "Landroidx/compose/ui/unit/TextUnitType;", "getTextUnitTypes$ui_unit", "()[Landroidx/compose/ui/unit/TextUnitType;", "[Landroidx/compose/ui/unit/TextUnitType;", "Unspecified", "Landroidx/compose/ui/unit/TextUnit;", "getUnspecified-XSAIIZE$annotations", "getUnspecified-XSAIIZE", "()J", "J", "ui-unit"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE$annotations, reason: not valid java name */
        public static /* synthetic */ void m9034getUnspecifiedXSAIIZE$annotations() {
        }

        private Companion() {
        }

        public final TextUnitType[] getTextUnitTypes$ui_unit() {
            return TextUnit.TextUnitTypes;
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m9035getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m9023getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m9022getRawTypeimpl(j) >>> 32)].getType();
    }

    /* JADX INFO: renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m9027isSpimpl(long j) {
        return m9022getRawTypeimpl(j) == Conversions.THIRTYTWO_BIT;
    }

    /* JADX INFO: renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m9026isEmimpl(long j) {
        return m9022getRawTypeimpl(j) == 8589934592L;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m9024getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
