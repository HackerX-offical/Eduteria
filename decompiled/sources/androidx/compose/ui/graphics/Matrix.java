package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.imagecropper.CropImage;
import com.clevertap.android.sdk.network.api.CtApi;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Matrix.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086\n¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001d¢\u0006\u0004\b\u001b\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0010¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0010¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0000¢\u0006\u0004\b.\u0010\"J\u0015\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\t¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\u00102\u0006\u00100\u001a\u00020\t¢\u0006\u0004\b4\u00102J\u0015\u00105\u001a\u00020\u00102\u0006\u00100\u001a\u00020\t¢\u0006\u0004\b6\u00102J+\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020\t¢\u0006\u0004\b;\u0010<J+\u0010=\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020\t¢\u0006\u0004\b>\u0010<J{\u0010?\u001a\u00020\u00102\b\b\u0002\u0010@\u001a\u00020\t2\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\t2\b\b\u0002\u0010C\u001a\u00020\t2\b\b\u0002\u0010D\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020\t2\b\b\u0002\u0010F\u001a\u00020\t2\b\b\u0002\u0010G\u001a\u00020\t2\b\b\u0002\u0010H\u001a\u00020\t2\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t¢\u0006\u0004\bK\u0010LJ\u0014\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010P\u001a\u00020\u000bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006R"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "get", "", "row", "", "column", "get-impl", "([FII)F", "set", "", "v", "set-impl", "([FIIF)V", "map", "Landroidx/compose/ui/geometry/Offset;", Const.POINT, "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "rect", "map-impl", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/MutableRect;", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "timesAssign", "m", "timesAssign-58bKbWc", "([F[F)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "([F)Ljava/lang/String;", "invert", "invert-impl", "([F)V", "reset", "reset-impl", "setFrom", "matrix", "setFrom-58bKbWc", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", CropImage.SCALE, "x", "y", CtApi.QUERY_PARAM_Z_KEY, "scale-impl", "([FFFF)V", "translate", "translate-impl", "resetToPivotedTransform", "pivotX", "pivotY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "scaleZ", "resetToPivotedTransform-impl", "([FFFFFFFFFFFF)V", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class Matrix {
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Matrix m6212boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m6213constructorimpl(float[] fArr) {
        return fArr;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6215equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual(fArr, ((Matrix) obj).m6237unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6216equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6218hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public boolean equals(Object other) {
        return m6215equalsimpl(this.values, other);
    }

    public int hashCode() {
        return m6218hashCodeimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m6237unboximpl() {
        return this.values;
    }

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    public final float[] getValues() {
        return this.values;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m6214constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m6213constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m6217getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 4) + i2];
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m6231setimpl(float[] fArr, int i, int i2, float f2) {
        fArr[(i * 4) + i2] = f2;
    }

    /* JADX INFO: renamed from: map-MK-Hz9U, reason: not valid java name */
    public static final long m6220mapMKHz9U(float[] fArr, long j) {
        if (fArr.length < 16) {
            return j;
        }
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[7];
        float f8 = fArr[12];
        float f9 = fArr[13];
        float f10 = fArr[15];
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float f11 = 1 / (((f4 * fIntBitsToFloat) + (f7 * fIntBitsToFloat2)) + f10);
        if ((Float.floatToRawIntBits(f11) & Integer.MAX_VALUE) >= 2139095040) {
            f11 = 0.0f;
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits((((f2 * fIntBitsToFloat) + (f5 * fIntBitsToFloat2)) + f8) * f11)) << 32) | (((long) Float.floatToRawIntBits(f11 * ((f3 * fIntBitsToFloat) + (f6 * fIntBitsToFloat2) + f9))) & 4294967295L));
    }

    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final Rect m6221mapimpl(float[] fArr, Rect rect) {
        if (fArr.length < 16) {
            return rect;
        }
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[7];
        float f8 = fArr[12];
        float f9 = fArr[13];
        float f10 = fArr[15];
        float left = rect.getLeft();
        float top = rect.getTop();
        float right = rect.getRight();
        float bottom = rect.getBottom();
        float f11 = f4 * left;
        float f12 = f7 * top;
        float f13 = 1.0f / ((f11 + f12) + f10);
        if ((Float.floatToRawIntBits(f13) & Integer.MAX_VALUE) >= 2139095040) {
            f13 = 0.0f;
        }
        float f14 = f2 * left;
        float f15 = f5 * top;
        float f16 = f13 * (f14 + f15 + f8);
        float f17 = left * f3;
        float f18 = top * f6;
        float f19 = f13 * (f17 + f18 + f9);
        float f20 = f7 * bottom;
        float f21 = 1.0f / ((f11 + f20) + f10);
        if ((Float.floatToRawIntBits(f21) & Integer.MAX_VALUE) >= 2139095040) {
            f21 = 0.0f;
        }
        float f22 = f5 * bottom;
        float f23 = (f14 + f22 + f8) * f21;
        float f24 = f6 * bottom;
        float f25 = f21 * (f17 + f24 + f9);
        float f26 = f4 * right;
        float f27 = 1.0f / ((f12 + f26) + f10);
        if ((Float.floatToRawIntBits(f27) & Integer.MAX_VALUE) >= 2139095040) {
            f27 = 0.0f;
        }
        float f28 = f2 * right;
        float f29 = f27 * (f28 + f15 + f8);
        float f30 = right * f3;
        float f31 = f27 * (f18 + f30 + f9);
        float f32 = 1.0f / ((f26 + f20) + f10);
        float f33 = (Float.floatToRawIntBits(f32) & Integer.MAX_VALUE) < 2139095040 ? f32 : 0.0f;
        float f34 = (f28 + f22 + f8) * f33;
        float f35 = f33 * (f30 + f24 + f9);
        return new Rect(Math.min(f16, Math.min(f23, Math.min(f29, f34))), Math.min(f19, Math.min(f25, Math.min(f31, f35))), Math.max(f16, Math.max(f23, Math.max(f29, f34))), Math.max(f19, Math.max(f25, Math.max(f31, f35))));
    }

    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final void m6222mapimpl(float[] fArr, MutableRect mutableRect) {
        if (fArr.length < 16) {
            return;
        }
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[7];
        float f8 = fArr[12];
        float f9 = fArr[13];
        float f10 = fArr[15];
        float left = mutableRect.getLeft();
        float top = mutableRect.getTop();
        float right = mutableRect.getRight();
        float bottom = mutableRect.getBottom();
        float f11 = f4 * left;
        float f12 = f7 * top;
        float f13 = 1.0f / ((f11 + f12) + f10);
        if ((Float.floatToRawIntBits(f13) & Integer.MAX_VALUE) >= 2139095040) {
            f13 = 0.0f;
        }
        float f14 = f2 * left;
        float f15 = f5 * top;
        float f16 = f13 * (f14 + f15 + f8);
        float f17 = left * f3;
        float f18 = top * f6;
        float f19 = f13 * (f17 + f18 + f9);
        float f20 = f7 * bottom;
        float f21 = 1.0f / ((f11 + f20) + f10);
        if ((Float.floatToRawIntBits(f21) & Integer.MAX_VALUE) >= 2139095040) {
            f21 = 0.0f;
        }
        float f22 = f5 * bottom;
        float f23 = (f14 + f22 + f8) * f21;
        float f24 = f6 * bottom;
        float f25 = f21 * (f17 + f24 + f9);
        float f26 = f4 * right;
        float f27 = 1.0f / ((f12 + f26) + f10);
        if ((Float.floatToRawIntBits(f27) & Integer.MAX_VALUE) >= 2139095040) {
            f27 = 0.0f;
        }
        float f28 = f2 * right;
        float f29 = f27 * (f28 + f15 + f8);
        float f30 = right * f3;
        float f31 = f27 * (f18 + f30 + f9);
        float f32 = 1.0f / ((f26 + f20) + f10);
        float f33 = (Float.floatToRawIntBits(f32) & Integer.MAX_VALUE) < 2139095040 ? f32 : 0.0f;
        float f34 = (f28 + f22 + f8) * f33;
        float f35 = f33 * (f30 + f24 + f9);
        mutableRect.setLeft(Math.min(f16, Math.min(f23, Math.min(f29, f34))));
        mutableRect.setTop(Math.min(f19, Math.min(f25, Math.min(f31, f35))));
        mutableRect.setRight(Math.max(f16, Math.max(f23, Math.max(f29, f34))));
        mutableRect.setBottom(Math.max(f19, Math.max(f25, Math.max(f31, f35))));
    }

    /* JADX INFO: renamed from: timesAssign-58bKbWc, reason: not valid java name */
    public static final void m6233timesAssign58bKbWc(float[] fArr, float[] fArr2) {
        if (fArr.length >= 16 && fArr2.length >= 16) {
            float f2 = fArr[0];
            float f3 = fArr2[0];
            float f4 = fArr[1];
            float f5 = fArr2[4];
            float f6 = fArr[2];
            float f7 = fArr2[8];
            float f8 = fArr[3];
            float f9 = fArr2[12];
            float f10 = (f2 * f3) + (f4 * f5) + (f6 * f7) + (f8 * f9);
            float f11 = fArr2[1];
            float f12 = fArr2[5];
            float f13 = fArr2[9];
            float f14 = fArr2[13];
            float f15 = (f2 * f11) + (f4 * f12) + (f6 * f13) + (f8 * f14);
            float f16 = fArr2[2];
            float f17 = fArr2[6];
            float f18 = fArr2[10];
            float f19 = fArr2[14];
            float f20 = (f2 * f16) + (f4 * f17) + (f6 * f18) + (f8 * f19);
            float f21 = fArr2[3];
            float f22 = fArr2[7];
            float f23 = fArr2[11];
            float f24 = fArr2[15];
            float f25 = (f2 * f21) + (f4 * f22) + (f6 * f23) + (f8 * f24);
            float f26 = fArr[4];
            float f27 = fArr[5];
            float f28 = fArr[6];
            float f29 = fArr[7];
            float f30 = (f26 * f3) + (f27 * f5) + (f28 * f7) + (f29 * f9);
            float f31 = (f26 * f11) + (f27 * f12) + (f28 * f13) + (f29 * f14);
            float f32 = (f26 * f16) + (f27 * f17) + (f28 * f18) + (f29 * f19);
            float f33 = (f26 * f21) + (f27 * f22) + (f28 * f23) + (f29 * f24);
            float f34 = fArr[8];
            float f35 = fArr[9];
            float f36 = fArr[10];
            float f37 = fArr[11];
            float f38 = (f34 * f3) + (f35 * f5) + (f36 * f7) + (f37 * f9);
            float f39 = (f34 * f11) + (f35 * f12) + (f36 * f13) + (f37 * f14);
            float f40 = (f34 * f16) + (f35 * f17) + (f36 * f18) + (f37 * f19);
            float f41 = (f34 * f21) + (f35 * f22) + (f36 * f23) + (f37 * f24);
            float f42 = fArr[12];
            float f43 = fArr[13];
            float f44 = (f3 * f42) + (f5 * f43);
            float f45 = fArr[14];
            float f46 = f44 + (f7 * f45);
            float f47 = fArr[15];
            fArr[0] = f10;
            fArr[1] = f15;
            fArr[2] = f20;
            fArr[3] = f25;
            fArr[4] = f30;
            fArr[5] = f31;
            fArr[6] = f32;
            fArr[7] = f33;
            fArr[8] = f38;
            fArr[9] = f39;
            fArr[10] = f40;
            fArr[11] = f41;
            fArr[12] = f46 + (f9 * f47);
            fArr[13] = (f11 * f42) + (f12 * f43) + (f13 * f45) + (f14 * f47);
            fArr[14] = (f16 * f42) + (f17 * f43) + (f18 * f45) + (f19 * f47);
            fArr[15] = (f42 * f21) + (f43 * f22) + (f45 * f23) + (f47 * f24);
        }
    }

    public String toString() {
        return m6234toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6234toStringimpl(float[] fArr) {
        StringBuilder sb = new StringBuilder("\n            |");
        sb.append(fArr[0]).append(' ').append(fArr[1]).append(' ').append(fArr[2]).append(' ').append(fArr[3]).append("|\n            |").append(fArr[4]).append(' ').append(fArr[5]).append(' ').append(fArr[6]).append(' ').append(fArr[7]).append("|\n            |").append(fArr[8]).append(' ').append(fArr[9]).append(' ').append(fArr[10]).append(' ');
        sb.append(fArr[11]).append("|\n            |").append(fArr[12]).append(' ').append(fArr[13]).append(' ').append(fArr[14]).append(' ').append(fArr[15]).append("|\n        ");
        return StringsKt.trimIndent(sb.toString());
    }

    /* JADX INFO: renamed from: invert-impl, reason: not valid java name */
    public static final void m6219invertimpl(float[] fArr) {
        if (fArr.length < 16) {
            return;
        }
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float f5 = fArr[3];
        float f6 = fArr[4];
        float f7 = fArr[5];
        float f8 = fArr[6];
        float f9 = fArr[7];
        float f10 = fArr[8];
        float f11 = fArr[9];
        float f12 = fArr[10];
        float f13 = fArr[11];
        float f14 = fArr[12];
        float f15 = fArr[13];
        float f16 = fArr[14];
        float f17 = fArr[15];
        float f18 = (f2 * f7) - (f3 * f6);
        float f19 = (f2 * f8) - (f4 * f6);
        float f20 = (f2 * f9) - (f5 * f6);
        float f21 = (f3 * f8) - (f4 * f7);
        float f22 = (f3 * f9) - (f5 * f7);
        float f23 = (f4 * f9) - (f5 * f8);
        float f24 = (f10 * f15) - (f11 * f14);
        float f25 = (f10 * f16) - (f12 * f14);
        float f26 = (f10 * f17) - (f13 * f14);
        float f27 = (f11 * f16) - (f12 * f15);
        float f28 = (f11 * f17) - (f13 * f15);
        float f29 = (f12 * f17) - (f13 * f16);
        float f30 = (((((f18 * f29) - (f19 * f28)) + (f20 * f27)) + (f21 * f26)) - (f22 * f25)) + (f23 * f24);
        if (f30 == 0.0f) {
            return;
        }
        float f31 = 1.0f / f30;
        fArr[0] = (((f7 * f29) - (f8 * f28)) + (f9 * f27)) * f31;
        fArr[1] = ((((-f3) * f29) + (f4 * f28)) - (f5 * f27)) * f31;
        fArr[2] = (((f15 * f23) - (f16 * f22)) + (f17 * f21)) * f31;
        fArr[3] = ((((-f11) * f23) + (f12 * f22)) - (f13 * f21)) * f31;
        float f32 = -f6;
        fArr[4] = (((f32 * f29) + (f8 * f26)) - (f9 * f25)) * f31;
        fArr[5] = (((f29 * f2) - (f4 * f26)) + (f5 * f25)) * f31;
        float f33 = -f14;
        fArr[6] = (((f33 * f23) + (f16 * f20)) - (f17 * f19)) * f31;
        fArr[7] = (((f23 * f10) - (f12 * f20)) + (f13 * f19)) * f31;
        fArr[8] = (((f6 * f28) - (f7 * f26)) + (f9 * f24)) * f31;
        fArr[9] = ((((-f2) * f28) + (f26 * f3)) - (f5 * f24)) * f31;
        fArr[10] = (((f14 * f22) - (f15 * f20)) + (f17 * f18)) * f31;
        fArr[11] = ((((-f10) * f22) + (f20 * f11)) - (f13 * f18)) * f31;
        fArr[12] = (((f32 * f27) + (f7 * f25)) - (f8 * f24)) * f31;
        fArr[13] = (((f2 * f27) - (f3 * f25)) + (f4 * f24)) * f31;
        fArr[14] = (((f33 * f21) + (f15 * f19)) - (f16 * f18)) * f31;
        fArr[15] = (((f10 * f21) - (f11 * f19)) + (f12 * f18)) * f31;
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m6223resetimpl(float[] fArr) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    /* JADX INFO: renamed from: setFrom-58bKbWc, reason: not valid java name */
    public static final void m6232setFrom58bKbWc(float[] fArr, float[] fArr2) {
        if (fArr.length >= 16 && fArr2.length >= 16) {
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
        }
    }

    /* JADX INFO: renamed from: rotateX-impl, reason: not valid java name */
    public static final void m6226rotateXimpl(float[] fArr, float f2) {
        if (fArr.length < 16) {
            return;
        }
        double d2 = ((double) f2) * 0.017453292519943295d;
        float fSin = (float) Math.sin(d2);
        float fCos = (float) Math.cos(d2);
        float f3 = fArr[1];
        float f4 = fArr[2];
        float f5 = fArr[5];
        float f6 = fArr[6];
        float f7 = fArr[9];
        float f8 = fArr[10];
        float f9 = fArr[13];
        float f10 = fArr[14];
        fArr[1] = (f3 * fCos) - (f4 * fSin);
        fArr[2] = (f3 * fSin) + (f4 * fCos);
        fArr[5] = (f5 * fCos) - (f6 * fSin);
        fArr[6] = (f5 * fSin) + (f6 * fCos);
        fArr[9] = (f7 * fCos) - (f8 * fSin);
        fArr[10] = (f7 * fSin) + (f8 * fCos);
        fArr[13] = (f9 * fCos) - (f10 * fSin);
        fArr[14] = (f9 * fSin) + (f10 * fCos);
    }

    /* JADX INFO: renamed from: rotateY-impl, reason: not valid java name */
    public static final void m6227rotateYimpl(float[] fArr, float f2) {
        if (fArr.length < 16) {
            return;
        }
        double d2 = ((double) f2) * 0.017453292519943295d;
        float fSin = (float) Math.sin(d2);
        float fCos = (float) Math.cos(d2);
        float f3 = fArr[0];
        float f4 = fArr[2];
        float f5 = fArr[4];
        float f6 = fArr[6];
        float f7 = fArr[8];
        float f8 = fArr[10];
        float f9 = fArr[12];
        float f10 = fArr[14];
        fArr[0] = (f3 * fCos) + (f4 * fSin);
        fArr[2] = ((-f3) * fSin) + (f4 * fCos);
        fArr[4] = (f5 * fCos) + (f6 * fSin);
        fArr[6] = ((-f5) * fSin) + (f6 * fCos);
        fArr[8] = (f7 * fCos) + (f8 * fSin);
        fArr[10] = ((-f7) * fSin) + (f8 * fCos);
        fArr[12] = (f9 * fCos) + (f10 * fSin);
        fArr[14] = ((-f9) * fSin) + (f10 * fCos);
    }

    /* JADX INFO: renamed from: rotateZ-impl, reason: not valid java name */
    public static final void m6228rotateZimpl(float[] fArr, float f2) {
        if (fArr.length < 16) {
            return;
        }
        double d2 = ((double) f2) * 0.017453292519943295d;
        float fSin = (float) Math.sin(d2);
        float fCos = (float) Math.cos(d2);
        float f3 = fArr[0];
        float f4 = fArr[4];
        float f5 = (fCos * f3) + (fSin * f4);
        float f6 = -fSin;
        float f7 = fArr[1];
        float f8 = fArr[5];
        float f9 = (fCos * f7) + (fSin * f8);
        float f10 = fArr[2];
        float f11 = fArr[6];
        float f12 = (fCos * f10) + (fSin * f11);
        float f13 = fArr[3];
        float f14 = fArr[7];
        fArr[0] = f5;
        fArr[1] = f9;
        fArr[2] = f12;
        fArr[3] = (fCos * f13) + (fSin * f14);
        fArr[4] = (f3 * f6) + (f4 * fCos);
        fArr[5] = (f7 * f6) + (f8 * fCos);
        fArr[6] = (f10 * f6) + (f11 * fCos);
        fArr[7] = (f6 * f13) + (fCos * f14);
    }

    /* JADX INFO: renamed from: scale-impl$default, reason: not valid java name */
    public static /* synthetic */ void m6230scaleimpl$default(float[] fArr, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i & 4) != 0) {
            f4 = 1.0f;
        }
        m6229scaleimpl(fArr, f2, f3, f4);
    }

    /* JADX INFO: renamed from: scale-impl, reason: not valid java name */
    public static final void m6229scaleimpl(float[] fArr, float f2, float f3, float f4) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = fArr[0] * f2;
        fArr[1] = fArr[1] * f2;
        fArr[2] = fArr[2] * f2;
        fArr[3] = fArr[3] * f2;
        fArr[4] = fArr[4] * f3;
        fArr[5] = fArr[5] * f3;
        fArr[6] = fArr[6] * f3;
        fArr[7] = fArr[7] * f3;
        fArr[8] = fArr[8] * f4;
        fArr[9] = fArr[9] * f4;
        fArr[10] = fArr[10] * f4;
        fArr[11] = fArr[11] * f4;
    }

    /* JADX INFO: renamed from: translate-impl$default, reason: not valid java name */
    public static /* synthetic */ void m6236translateimpl$default(float[] fArr, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i & 4) != 0) {
            f4 = 0.0f;
        }
        m6235translateimpl(fArr, f2, f3, f4);
    }

    /* JADX INFO: renamed from: translate-impl, reason: not valid java name */
    public static final void m6235translateimpl(float[] fArr, float f2, float f3, float f4) {
        if (fArr.length < 16) {
            return;
        }
        float f5 = (fArr[0] * f2) + (fArr[4] * f3) + (fArr[8] * f4) + fArr[12];
        float f6 = (fArr[1] * f2) + (fArr[5] * f3) + (fArr[9] * f4) + fArr[13];
        float f7 = (fArr[2] * f2) + (fArr[6] * f3) + (fArr[10] * f4) + fArr[14];
        float f8 = (fArr[3] * f2) + (fArr[7] * f3) + (fArr[11] * f4) + fArr[15];
        fArr[12] = f5;
        fArr[13] = f6;
        fArr[14] = f7;
        fArr[15] = f8;
    }

    /* JADX INFO: renamed from: resetToPivotedTransform-impl$default, reason: not valid java name */
    public static /* synthetic */ void m6225resetToPivotedTransformimpl$default(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i & 8) != 0) {
            f5 = 0.0f;
        }
        if ((i & 16) != 0) {
            f6 = 0.0f;
        }
        if ((i & 32) != 0) {
            f7 = 0.0f;
        }
        if ((i & 64) != 0) {
            f8 = 0.0f;
        }
        if ((i & 128) != 0) {
            f9 = 0.0f;
        }
        if ((i & 256) != 0) {
            f10 = 1.0f;
        }
        if ((i & 512) != 0) {
            f11 = 1.0f;
        }
        if ((i & 1024) != 0) {
            f12 = 1.0f;
        }
        m6224resetToPivotedTransformimpl(fArr, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12);
    }

    /* JADX INFO: renamed from: resetToPivotedTransform-impl, reason: not valid java name */
    public static final void m6224resetToPivotedTransformimpl(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        double d2 = ((double) f7) * 0.017453292519943295d;
        float fSin = (float) Math.sin(d2);
        float fCos = (float) Math.cos(d2);
        float f13 = -fSin;
        float f14 = (f5 * fCos) - (f6 * fSin);
        float f15 = (f5 * fSin) + (f6 * fCos);
        double d3 = ((double) f8) * 0.017453292519943295d;
        float fSin2 = (float) Math.sin(d3);
        float fCos2 = (float) Math.cos(d3);
        float f16 = -fSin2;
        float f17 = fSin * fSin2;
        float f18 = fSin * fCos2;
        float f19 = fCos * fSin2;
        float f20 = fCos * fCos2;
        float f21 = (f4 * fCos2) + (f15 * fSin2);
        float f22 = ((-f4) * fSin2) + (f15 * fCos2);
        double d4 = ((double) f9) * 0.017453292519943295d;
        float fSin3 = (float) Math.sin(d4);
        float fCos3 = (float) Math.cos(d4);
        float f23 = -fSin3;
        float f24 = (f23 * fCos2) + (fCos3 * f17);
        float f25 = fCos * fCos3;
        float f26 = (f23 * f16) + (fCos3 * f18);
        float f27 = ((fCos2 * fCos3) + (f17 * fSin3)) * f10;
        float f28 = fSin3 * fCos * f10;
        float f29 = ((fCos3 * f16) + (fSin3 * f18)) * f10;
        float f30 = f24 * f11;
        float f31 = f25 * f11;
        float f32 = f26 * f11;
        float f33 = f19 * f12;
        float f34 = f13 * f12;
        float f35 = f20 * f12;
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = f27;
        fArr[1] = f28;
        fArr[2] = f29;
        fArr[3] = 0.0f;
        fArr[4] = f30;
        fArr[5] = f31;
        fArr[6] = f32;
        fArr[7] = 0.0f;
        fArr[8] = f33;
        fArr[9] = f34;
        fArr[10] = f35;
        fArr[11] = 0.0f;
        float f36 = -f2;
        fArr[12] = ((f27 * f36) - (f30 * f3)) + f21 + f2;
        fArr[13] = ((f28 * f36) - (f31 * f3)) + f14 + f3;
        fArr[14] = ((f36 * f29) - (f3 * f32)) + f22;
        fArr[15] = 1.0f;
    }
}
