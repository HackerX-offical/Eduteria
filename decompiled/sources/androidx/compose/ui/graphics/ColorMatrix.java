package androidx.compose.ui.graphics;

import androidx.core.text.util.LocalePreferences;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: ColorMatrix.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086\n¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019JP\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00100\u001dH\u0082\b¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b&\u0010\u0019J\u0015\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J-\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b3\u0010*J\u0015\u00104\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b5\u0010*J\u0015\u00106\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b7\u0010*J\r\u00108\u001a\u00020\u0010¢\u0006\u0004\b9\u0010\u0016J\r\u0010:\u001a\u00020\u0010¢\u0006\u0004\b;\u0010\u0016J\u0014\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010?\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010@\u001a\u00020AHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006B"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "get", "", "row", "", "column", "get-impl", "([FII)F", "set", "", "v", "set-impl", "([FIIF)V", "reset", "reset-impl", "([F)V", "src", "set-jHG-Opc", "([F[F)V", "rotateInternal", "degrees", BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "setToSaturation", LocalePreferences.FirstDayOfWeek.SATURDAY, "setToSaturation-impl", "([FF)V", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "setToRotateRed", "setToRotateRed-impl", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateBlue", "setToRotateBlue-impl", "convertRgbToYuv", "convertRgbToYuv-impl", "convertYuvToRgb", "convertYuvToRgb-impl", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class ColorMatrix {
    private final float[] values;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m6023boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m6024constructorimpl(float[] fArr) {
        return fArr;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6028equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual(fArr, ((ColorMatrix) obj).m6043unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6029equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6031hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6042toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object other) {
        return m6028equalsimpl(this.values, other);
    }

    public int hashCode() {
        return m6031hashCodeimpl(this.values);
    }

    public String toString() {
        return m6042toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m6043unboximpl() {
        return this.values;
    }

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    public final float[] getValues() {
        return this.values;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m6025constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m6024constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m6030getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 5) + i2];
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m6034setimpl(float[] fArr, int i, int i2, float f2) {
        fArr[(i * 5) + i2] = f2;
    }

    /* JADX INFO: renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m6035setjHGOpc(float[] fArr, float[] fArr2) {
        if (fArr.length >= 20 && fArr2.length >= 20) {
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = fArr2[2];
            fArr[3] = fArr2[3];
            fArr[4] = fArr2[4];
            fArr[5] = fArr2[5];
            fArr[6] = fArr2[6];
            fArr[7] = fArr2[7];
            fArr[8] = fArr2[8];
            fArr[9] = fArr2[9];
            fArr[10] = fArr2[10];
            fArr[11] = fArr2[11];
            fArr[12] = fArr2[12];
            fArr[13] = fArr2[13];
            fArr[14] = fArr2[14];
            fArr[15] = fArr2[15];
            fArr[16] = fArr2[16];
            fArr[17] = fArr2[17];
            fArr[18] = fArr2[18];
            fArr[19] = fArr2[19];
        }
    }

    /* JADX INFO: renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m6041timesAssignjHGOpc(float[] fArr, float[] fArr2) {
        if (fArr.length < 20) {
            return;
        }
        float f2 = fArr[0];
        float f3 = fArr2[0];
        float f4 = fArr[1];
        float f5 = fArr2[5];
        float f6 = fArr[2];
        float f7 = fArr2[10];
        float f8 = fArr[3];
        float f9 = fArr2[15];
        float f10 = (f2 * f3) + (f4 * f5) + (f6 * f7) + (f8 * f9);
        float f11 = fArr2[1];
        float f12 = fArr2[6];
        float f13 = fArr2[11];
        float f14 = fArr2[16];
        float f15 = (f2 * f11) + (f4 * f12) + (f6 * f13) + (f8 * f14);
        float f16 = fArr2[2];
        float f17 = fArr2[7];
        float f18 = fArr2[12];
        float f19 = fArr2[17];
        float f20 = (f2 * f16) + (f4 * f17) + (f6 * f18) + (f8 * f19);
        float f21 = fArr2[3];
        float f22 = fArr2[8];
        float f23 = fArr2[13];
        float f24 = fArr2[18];
        float f25 = (f2 * f21) + (f4 * f22) + (f6 * f23) + (f8 * f24);
        float f26 = fArr2[4];
        float f27 = fArr2[9];
        float f28 = fArr2[14];
        float f29 = fArr2[19];
        float f30 = (f2 * f26) + (f4 * f27) + (f6 * f28) + (f8 * f29) + fArr[4];
        float f31 = fArr[5];
        float f32 = fArr[6];
        float f33 = fArr[7];
        float f34 = fArr[8];
        float f35 = (f31 * f3) + (f32 * f5) + (f33 * f7) + (f34 * f9);
        float f36 = (f31 * f11) + (f32 * f12) + (f33 * f13) + (f34 * f14);
        float f37 = (f31 * f16) + (f32 * f17) + (f33 * f18) + (f34 * f19);
        float f38 = (f31 * f21) + (f32 * f22) + (f33 * f23) + (f34 * f24);
        float f39 = (f31 * f26) + (f32 * f27) + (f33 * f28) + (f34 * f29) + fArr[9];
        float f40 = fArr[10];
        float f41 = fArr[11];
        float f42 = fArr[12];
        float f43 = fArr[13];
        float f44 = (f40 * f3) + (f41 * f5) + (f42 * f7) + (f43 * f9);
        float f45 = (f40 * f11) + (f41 * f12) + (f42 * f13) + (f43 * f14);
        float f46 = (f40 * f16) + (f41 * f17) + (f42 * f18) + (f43 * f19);
        float f47 = (f40 * f21) + (f41 * f22) + (f42 * f23) + (f43 * f24);
        float f48 = (f40 * f26) + (f41 * f27) + (f42 * f28) + (f43 * f29) + fArr[14];
        float f49 = fArr[15];
        float f50 = fArr[16];
        float f51 = (f3 * f49) + (f5 * f50);
        float f52 = fArr[17];
        float f53 = f51 + (f7 * f52);
        float f54 = fArr[18];
        float f55 = (f11 * f49) + (f12 * f50) + (f13 * f52) + (f14 * f54);
        float f56 = (f16 * f49) + (f17 * f50) + (f18 * f52) + (f19 * f54);
        float f57 = (f21 * f49) + (f22 * f50) + (f23 * f52) + (f24 * f54);
        float f58 = (f49 * f26) + (f50 * f27) + (f52 * f28) + (f54 * f29) + fArr[19];
        fArr[0] = f10;
        fArr[1] = f15;
        fArr[2] = f20;
        fArr[3] = f25;
        fArr[4] = f30;
        fArr[5] = f35;
        fArr[6] = f36;
        fArr[7] = f37;
        fArr[8] = f38;
        fArr[9] = f39;
        fArr[10] = f44;
        fArr[11] = f45;
        fArr[12] = f46;
        fArr[13] = f47;
        fArr[14] = f48;
        fArr[15] = f53 + (f9 * f54);
        fArr[16] = f55;
        fArr[17] = f56;
        fArr[18] = f57;
        fArr[19] = f58;
    }

    /* JADX INFO: renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m6039setToSaturationimpl(float[] fArr, float f2) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f3 = 1 - f2;
        float f4 = 0.213f * f3;
        float f5 = 0.715f * f3;
        float f6 = f3 * 0.072f;
        fArr[0] = f4 + f2;
        fArr[1] = f5;
        fArr[2] = f6;
        fArr[5] = f4;
        fArr[6] = f5 + f2;
        fArr[7] = f6;
        fArr[10] = f4;
        fArr[11] = f5;
        fArr[12] = f6 + f2;
    }

    /* JADX INFO: renamed from: setToScale-impl, reason: not valid java name */
    public static final void m6040setToScaleimpl(float[] fArr, float f2, float f3, float f4, float f5) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[0] = f2;
        fArr[6] = f3;
        fArr[12] = f4;
        fArr[18] = f5;
    }

    /* JADX INFO: renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m6038setToRotateRedimpl(float[] fArr, float f2) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f3 = f2 * 0.0027777778f;
        float fFloor = (0.25f + f3) - ((float) Math.floor(r2 + 0.5f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f4 = 1.0f - fAbs;
        float f5 = ((fFloor * 8.0f) * f4) / (1.25f - (fAbs * f4));
        float fFloor2 = f3 - ((float) Math.floor(0.5f + f3));
        float fAbs2 = Math.abs(fFloor2) * 2.0f;
        float f6 = 1.0f - fAbs2;
        float f7 = ((fFloor2 * 8.0f) * f6) / (1.25f - (fAbs2 * f6));
        fArr[6] = f5;
        fArr[7] = f7;
        fArr[11] = -f7;
        fArr[12] = f5;
    }

    /* JADX INFO: renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m6037setToRotateGreenimpl(float[] fArr, float f2) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f3 = f2 * 0.0027777778f;
        float fFloor = (0.25f + f3) - ((float) Math.floor(r3 + 0.5f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f4 = 1.0f - fAbs;
        float f5 = ((fFloor * 8.0f) * f4) / (1.25f - (fAbs * f4));
        float fFloor2 = f3 - ((float) Math.floor(0.5f + f3));
        float fAbs2 = Math.abs(fFloor2) * 2.0f;
        float f6 = 1.0f - fAbs2;
        float f7 = ((fFloor2 * 8.0f) * f6) / (1.25f - (fAbs2 * f6));
        fArr[0] = f5;
        fArr[2] = -f7;
        fArr[10] = f7;
        fArr[12] = f5;
    }

    /* JADX INFO: renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m6036setToRotateBlueimpl(float[] fArr, float f2) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f3 = f2 * 0.0027777778f;
        float fFloor = (0.25f + f3) - ((float) Math.floor(r3 + 0.5f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f4 = 1.0f - fAbs;
        float f5 = ((fFloor * 8.0f) * f4) / (1.25f - (fAbs * f4));
        float fFloor2 = f3 - ((float) Math.floor(0.5f + f3));
        float fAbs2 = Math.abs(fFloor2) * 2.0f;
        float f6 = 1.0f - fAbs2;
        float f7 = ((fFloor2 * 8.0f) * f6) / (1.25f - (fAbs2 * f6));
        fArr[0] = f5;
        fArr[1] = f7;
        fArr[5] = -f7;
        fArr[6] = f5;
    }

    /* JADX INFO: renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m6026convertRgbToYuvimpl(float[] fArr) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* JADX INFO: renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m6027convertYuvToRgbimpl(float[] fArr) {
        if (fArr.length < 20) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m6032resetimpl(float[] fArr) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
    }

    /* JADX INFO: renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m6033rotateInternalimpl(float[] fArr, float f2, Function2<? super Float, ? super Float, Unit> function2) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 0.0f;
        fArr[11] = 0.0f;
        fArr[12] = 1.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 0.0f;
        fArr[16] = 0.0f;
        fArr[17] = 0.0f;
        fArr[18] = 1.0f;
        fArr[19] = 0.0f;
        float f3 = f2 * 0.0027777778f;
        float fFloor = (0.25f + f3) - ((float) Math.floor(r8 + 0.5f));
        float fAbs = Math.abs(fFloor) * 2.0f;
        float f4 = 1.0f - fAbs;
        float fFloor2 = f3 - ((float) Math.floor(0.5f + f3));
        float fAbs2 = Math.abs(fFloor2) * 2.0f;
        float f5 = 1.0f - fAbs2;
        function2.invoke(Float.valueOf(((fFloor * 8.0f) * f4) / (1.25f - (fAbs * f4))), Float.valueOf(((fFloor2 * 8.0f) * f5) / (1.25f - (fAbs2 * f5))));
    }
}
