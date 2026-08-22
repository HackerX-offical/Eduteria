package androidx.compose.material3.internal.colorUtil;

import com.clevertap.android.sdk.network.api.CtApi;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Frame.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0013\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBY\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\f\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Frame;", "", CTProductConfigConstants.PRODUCT_CONFIG_JSON_KEY_FOR_KEY, "", "aw", "nbb", "ncb", "c", "nc", "rgbD", "", "fl", "flRoot", CtApi.QUERY_PARAM_Z_KEY, "<init>", "(FFFFFF[FFFF)V", "getN", "()F", "getAw", "getNbb", "getNcb", "getC", "getNc", "getRgbD", "()[F", "getFl", "getFlRoot", "getZ", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Frame {
    public static final int $stable;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Frame Default;
    private final float aw;
    private final float c;
    private final float fl;
    private final float flRoot;
    private final float n;
    private final float nbb;
    private final float nc;
    private final float ncb;
    private final float[] rgbD;
    private final float z;

    public /* synthetic */ Frame(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5, f6, f7, fArr, f8, f9, f10);
    }

    private Frame(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10) {
        this.n = f2;
        this.aw = f3;
        this.nbb = f4;
        this.ncb = f5;
        this.c = f6;
        this.nc = f7;
        this.rgbD = fArr;
        this.fl = f8;
        this.flRoot = f9;
        this.z = f10;
    }

    public final float getN() {
        return this.n;
    }

    public final float getAw() {
        return this.aw;
    }

    public final float getNbb() {
        return this.nbb;
    }

    public final float getNcb() {
        return this.ncb;
    }

    public final float getC() {
        return this.c;
    }

    public final float getNc() {
        return this.nc;
    }

    public final float[] getRgbD() {
        return this.rgbD;
    }

    public final float getFl() {
        return this.fl;
    }

    public final float getFlRoot() {
        return this.flRoot;
    }

    public final float getZ() {
        return this.z;
    }

    /* JADX INFO: compiled from: Frame.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Frame$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/material3/internal/colorUtil/Frame;", "getDefault", "()Landroidx/compose/material3/internal/colorUtil/Frame;", "make", "whitepoint", "", "adaptingLuminance", "", "backgroundLstar", "surround", "discountingIlluminant", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Frame getDefault() {
            return Frame.Default;
        }

        public final Frame make(float[] whitepoint, float adaptingLuminance, float backgroundLstar, float surround, boolean discountingIlluminant) {
            float[][] xyz_to_cam16rgb = CamUtils.INSTANCE.getXYZ_TO_CAM16RGB();
            float f2 = whitepoint[0];
            float[] fArr = xyz_to_cam16rgb[0];
            float f3 = fArr[0] * f2;
            float f4 = whitepoint[1];
            float f5 = f3 + (fArr[1] * f4);
            float f6 = whitepoint[2];
            float f7 = f5 + (fArr[2] * f6);
            float[] fArr2 = xyz_to_cam16rgb[1];
            float f8 = (fArr2[0] * f2) + (fArr2[1] * f4) + (fArr2[2] * f6);
            float[] fArr3 = xyz_to_cam16rgb[2];
            float f9 = (f2 * fArr3[0]) + (f4 * fArr3[1]) + (f6 * fArr3[2]);
            float f10 = (surround / 10.0f) + 0.8f;
            float fLerp = ((double) f10) >= 0.9d ? Frame_androidKt.lerp(0.59f, 0.69f, (f10 - 0.9f) * 10.0f) : Frame_androidKt.lerp(0.525f, 0.59f, (f10 - 0.8f) * 10.0f);
            float fExp = discountingIlluminant ? 1.0f : (1.0f - (((float) Math.exp(((-adaptingLuminance) - 42.0f) / 92.0f)) * 0.2777778f)) * f10;
            double d2 = fExp;
            if (d2 > 1.0d) {
                fExp = 1.0f;
            } else if (d2 < 0.0d) {
                fExp = 0.0f;
            }
            float[] fArr4 = {(((100.0f / f7) * fExp) + 1.0f) - fExp, (((100.0f / f8) * fExp) + 1.0f) - fExp, (((100.0f / f9) * fExp) + 1.0f) - fExp};
            float f11 = 1.0f / ((5.0f * adaptingLuminance) + 1.0f);
            float f12 = f11 * f11 * f11 * f11;
            float f13 = 1.0f - f12;
            float fCbrt = (f12 * adaptingLuminance) + (0.1f * f13 * f13 * ((float) Math.cbrt(((double) adaptingLuminance) * 5.0d)));
            float fYFromLstar = ((float) CamUtils.INSTANCE.yFromLstar(backgroundLstar)) / whitepoint[1];
            double d3 = fYFromLstar;
            float fSqrt = ((float) Math.sqrt(d3)) + 1.48f;
            float fPow = 0.725f / ((float) Math.pow(d3, 0.2f));
            double d4 = 0.42f;
            float[] fArr5 = {(float) Math.pow(((fArr4[0] * fCbrt) * f7) / 100.0f, d4), (float) Math.pow(((fArr4[1] * fCbrt) * f8) / 100.0f, d4), (float) Math.pow(((fArr4[2] * fCbrt) * f9) / 100.0f, d4)};
            float f14 = fArr5[0];
            float f15 = (f14 * 400.0f) / (f14 + 27.13f);
            float f16 = fArr5[1];
            float f17 = (f16 * 400.0f) / (f16 + 27.13f);
            float f18 = fArr5[2];
            float[] fArr6 = {f15, f17, (400.0f * f18) / (f18 + 27.13f)};
            return new Frame(fYFromLstar, ((fArr6[0] * 2.0f) + fArr6[1] + (fArr6[2] * 0.05f)) * fPow, fPow, fPow, fLerp, f10, fArr4, fCbrt, (float) Math.pow(fCbrt, 0.25f), fSqrt, null);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        $stable = 8;
        Default = companion.make(CamUtils.INSTANCE.getWHITE_POINT_D65(), (float) ((CamUtils.INSTANCE.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }
}
