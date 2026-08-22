package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: TextUnit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000f\u001a\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0016\u001a\u00020\u0006*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020\b2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010\f\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020#2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020&2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010-\u001a\u001d\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\bH\u0001¢\u0006\u0002\u00101\u001a\u0017\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0006H\u0001¢\u0006\u0004\b5\u0010\u0010\u001a\u001f\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0001¢\u0006\u0004\b7\u00108\u001a'\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H\u0001¢\u0006\u0004\b:\u0010;\u001a'\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\bH\u0007¢\u0006\u0004\b@\u0010A\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001f\u0010\r\u001a\u00020\u000e*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u001e\u0010 \u001a\u00020\u0006*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010$\u001a\u0004\b\u001e\u0010%\"\u001e\u0010 \u001a\u00020\u0006*\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010$\u001a\u0004\b\"\u0010%\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020&8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010'\u001a\u0004\b\u001e\u0010(\"\u001e\u0010 \u001a\u00020\u0006*\u00020&8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010'\u001a\u0004\b\"\u0010(¨\u0006B"}, d2 = {"UNIT_MASK", "", "UNIT_TYPE_UNSPECIFIED", "UNIT_TYPE_SP", "UNIT_TYPE_EM", "TextUnit", "Landroidx/compose/ui/unit/TextUnit;", "value", "", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "takeOrElse", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "sp", "getSp$annotations", "(F)V", "getSp", "(F)J", "em", "getEm$annotations", "getEm", "", "(D)V", "(D)J", "", "(I)V", "(I)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "pack", "unitType", "v", "(JF)J", "checkArithmetic", "", "a", "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "ui-unit"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    public static /* synthetic */ void getEm$annotations(double d2) {
    }

    public static /* synthetic */ void getEm$annotations(float f2) {
    }

    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static /* synthetic */ void getSp$annotations(double d2) {
    }

    public static /* synthetic */ void getSp$annotations(float f2) {
    }

    public static /* synthetic */ void getSp$annotations(int i) {
    }

    /* JADX INFO: renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m9041isSpecifiedR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m9043isUnspecifiedR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m9036TextUnitanM5pPY(float f2, long j) {
        return pack(j, f2);
    }

    /* JADX INFO: renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m9042isUnspecifiedR2X_6o(long j) {
        return TextUnit.m9022getRawTypeimpl(j) == 0;
    }

    public static final long getSp(float f2) {
        return pack(4294967296L, f2);
    }

    public static final long getEm(float f2) {
        return pack(UNIT_TYPE_EM, f2);
    }

    public static final long getSp(double d2) {
        return pack(4294967296L, (float) d2);
    }

    public static final long getEm(double d2) {
        return pack(UNIT_TYPE_EM, (float) d2);
    }

    public static final long getSp(int i) {
        return pack(4294967296L, i);
    }

    public static final long getEm(int i) {
        return pack(UNIT_TYPE_EM, i);
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m9047timesmpE4wyQ(float f2, long j) {
        m9037checkArithmeticR2X_6o(j);
        return pack(TextUnit.m9022getRawTypeimpl(j), f2 * TextUnit.m9024getValueimpl(j));
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m9046timesmpE4wyQ(double d2, long j) {
        m9037checkArithmeticR2X_6o(j);
        return pack(TextUnit.m9022getRawTypeimpl(j), ((float) d2) * TextUnit.m9024getValueimpl(j));
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m9048timesmpE4wyQ(int i, long j) {
        m9037checkArithmeticR2X_6o(j);
        return pack(TextUnit.m9022getRawTypeimpl(j), i * TextUnit.m9024getValueimpl(j));
    }

    public static final long pack(long j, float f2) {
        return TextUnit.m9016constructorimpl(j | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m9044lerpC3pnCVY(long j, long j2, float f2) {
        m9038checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m9022getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m9024getValueimpl(j), TextUnit.m9024getValueimpl(j2), f2));
    }

    /* JADX INFO: renamed from: isSpecified--R2X_6o, reason: not valid java name */
    public static final boolean m9040isSpecifiedR2X_6o(long j) {
        return !(TextUnit.m9022getRawTypeimpl(j) == 0);
    }

    /* JADX INFO: renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m9045takeOrElseeAf_CNQ(long j, Function0<TextUnit> function0) {
        return !((TextUnit.m9022getRawTypeimpl(j) > 0L ? 1 : (TextUnit.m9022getRawTypeimpl(j) == 0L ? 0 : -1)) == 0) ? j : function0.invoke().getPackedValue();
    }

    /* JADX INFO: renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m9037checkArithmeticR2X_6o(long j) {
        if (TextUnit.m9022getRawTypeimpl(j) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
    }

    /* JADX INFO: renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m9038checkArithmeticNB67dxo(long j, long j2) {
        if (!((TextUnit.m9022getRawTypeimpl(j) == 0 || TextUnit.m9022getRawTypeimpl(j2) == 0) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m9052equalsimpl0(TextUnit.m9023getTypeUIouoOA(j), TextUnit.m9023getTypeUIouoOA(j2))) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m9054toStringimpl(TextUnit.m9023getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m9054toStringimpl(TextUnit.m9023getTypeUIouoOA(j2))));
    }

    /* JADX INFO: renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    public static final void m9039checkArithmeticvU0ePk(long j, long j2, long j3) {
        if (!((TextUnit.m9022getRawTypeimpl(j) == 0 || TextUnit.m9022getRawTypeimpl(j2) == 0 || TextUnit.m9022getRawTypeimpl(j3) == 0) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m9052equalsimpl0(TextUnit.m9023getTypeUIouoOA(j), TextUnit.m9023getTypeUIouoOA(j2)) && TextUnitType.m9052equalsimpl0(TextUnit.m9023getTypeUIouoOA(j2), TextUnit.m9023getTypeUIouoOA(j3))) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m9054toStringimpl(TextUnit.m9023getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m9054toStringimpl(TextUnit.m9023getTypeUIouoOA(j2))));
    }
}
