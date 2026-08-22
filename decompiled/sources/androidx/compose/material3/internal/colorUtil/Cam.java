package androidx.compose.material3.internal.colorUtil;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.canhub.cropper.CropImageOptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Cam.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006 "}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Cam;", "", "hue", "", "chroma", "j", "m", CmcdData.Factory.STREAMING_FORMAT_SS, "jstar", "astar", "bstar", "<init>", "(FFFFFFFF)V", "getHue", "()F", "getChroma", "getJ", "getM", "getS", "getJstar", "setJstar", "(F)V", "getAstar", "getBstar", "distance", "other", "viewedInSrgb", "", "viewed", TypedValues.AttributesType.S_FRAME, "Landroidx/compose/material3/internal/colorUtil/Frame;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Cam {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float astar;
    private final float bstar;
    private final float chroma;
    private final float hue;
    private final float j;
    private float jstar;
    private final float m;
    private final float s;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public Cam(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.hue = f2;
        this.chroma = f3;
        this.j = f4;
        this.m = f5;
        this.s = f6;
        this.jstar = f7;
        this.astar = f8;
        this.bstar = f9;
    }

    public final float getHue() {
        return this.hue;
    }

    public final float getChroma() {
        return this.chroma;
    }

    public final float getJ() {
        return this.j;
    }

    public final float getM() {
        return this.m;
    }

    public final float getS() {
        return this.s;
    }

    public final float getJstar() {
        return this.jstar;
    }

    public final void setJstar(float f2) {
        this.jstar = f2;
    }

    public final float getAstar() {
        return this.astar;
    }

    public final float getBstar() {
        return this.bstar;
    }

    public final float distance(Cam other) {
        float f2 = this.jstar - other.jstar;
        float f3 = this.astar - other.astar;
        float f4 = this.bstar - other.bstar;
        return (float) (Math.pow(Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4)), 0.63d) * 1.41d);
    }

    public final int viewedInSrgb() {
        return viewed(Frame.INSTANCE.getDefault());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int viewed(androidx.compose.material3.internal.colorUtil.Frame r14) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.colorUtil.Cam.viewed(androidx.compose.material3.internal.colorUtil.Frame):int");
    }

    /* JADX INFO: compiled from: Cam.android.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J(\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Cam$Companion;", "", "<init>", "()V", "DL_MAX", "", "DE_MAX", "CHROMA_SEARCH_ENDPOINT", "LIGHTNESS_SEARCH_ENDPOINT", "getInt", "", "hue", "chroma", "lstar", "fromInt", "Landroidx/compose/material3/internal/colorUtil/Cam;", "argb", "fromIntInFrame", TypedValues.AttributesType.S_FRAME, "Landroidx/compose/material3/internal/colorUtil/Frame;", "fromJch", "j", "c", "h", "fromJchInFrame", "findCamByJ", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getInt(float hue, float chroma, float lstar) {
            return getInt(hue, chroma, lstar, Frame.INSTANCE.getDefault());
        }

        public final Cam fromInt(int argb) {
            return fromIntInFrame(argb, Frame.INSTANCE.getDefault());
        }

        private final Cam fromIntInFrame(int argb, Frame frame) {
            float[] fArrXyzFromInt = CamUtils.INSTANCE.xyzFromInt(argb);
            float[][] xyz_to_cam16rgb = CamUtils.INSTANCE.getXYZ_TO_CAM16RGB();
            float f2 = fArrXyzFromInt[0];
            float[] fArr = xyz_to_cam16rgb[0];
            float f3 = fArr[0] * f2;
            float f4 = fArrXyzFromInt[1];
            float f5 = f3 + (fArr[1] * f4);
            float f6 = fArrXyzFromInt[2];
            float f7 = f5 + (fArr[2] * f6);
            float[] fArr2 = xyz_to_cam16rgb[1];
            float f8 = (fArr2[0] * f2) + (fArr2[1] * f4) + (fArr2[2] * f6);
            float[] fArr3 = xyz_to_cam16rgb[2];
            float f9 = (f2 * fArr3[0]) + (f4 * fArr3[1]) + (f6 * fArr3[2]);
            float f10 = frame.getRgbD()[0] * f7;
            float f11 = frame.getRgbD()[1] * f8;
            float f12 = frame.getRgbD()[2] * f9;
            double d2 = 0.42f;
            float fPow = (float) Math.pow((frame.getFl() * Math.abs(f10)) / 100.0f, d2);
            float fPow2 = (float) Math.pow((frame.getFl() * Math.abs(f11)) / 100.0f, d2);
            float fPow3 = (float) Math.pow((frame.getFl() * Math.abs(f12)) / 100.0f, d2);
            float fSignum = ((Math.signum(f10) * 400.0f) * fPow) / (fPow + 27.13f);
            float fSignum2 = ((Math.signum(f11) * 400.0f) * fPow2) / (fPow2 + 27.13f);
            float fSignum3 = ((Math.signum(f12) * 400.0f) * fPow3) / (fPow3 + 27.13f);
            float f13 = (((fSignum * 11.0f) + ((-12.0f) * fSignum2)) + fSignum3) / 11.0f;
            float f14 = ((fSignum + fSignum2) - (fSignum3 * 2.0f)) / 9.0f;
            float f15 = fSignum2 * 20.0f;
            float f16 = (((fSignum * 20.0f) + f15) + (21.0f * fSignum3)) / 20.0f;
            float f17 = (((fSignum * 40.0f) + f15) + fSignum3) / 20.0f;
            float fAtan2 = (((float) Math.atan2(f14, f13)) * 180.0f) / 3.1415927f;
            if (fAtan2 < 0.0f) {
                fAtan2 += 360.0f;
            } else if (fAtan2 >= 360.0f) {
                fAtan2 -= 360.0f;
            }
            float f18 = fAtan2;
            float f19 = (f18 * 3.1415927f) / 180.0f;
            float fPow4 = ((float) Math.pow((f17 * frame.getNbb()) / frame.getAw(), frame.getC() * frame.getZ())) * 100.0f;
            float fPow5 = ((float) Math.pow(((((((((float) Math.cos((((((double) f18) < 20.14d ? CropImageOptionsKt.DEGREES_360 + f18 : f18) * 3.1415927f) / 180.0f) + 2.0f)) + 3.8f) * 0.25f) * 3846.1538f) * frame.getNc()) * frame.getNcb()) * ((float) Math.sqrt((f13 * f13) + (f14 * f14)))) / (f16 + 0.305f), 0.9f)) * ((float) Math.pow(1.64f - ((float) Math.pow(0.29f, frame.getN())), 0.73f)) * ((float) Math.sqrt(fPow4 / 100.0f));
            float flRoot = fPow5 * frame.getFlRoot();
            float fSqrt = ((float) Math.sqrt((r0 * frame.getC()) / (frame.getAw() + 4.0f))) * 50.0f;
            float f20 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
            float fLog = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
            double d3 = f19;
            return new Cam(f18, fPow5, fPow4, flRoot, fSqrt, f20, fLog * ((float) Math.cos(d3)), fLog * ((float) Math.sin(d3)));
        }

        private final Cam fromJch(float j, float c2, float h2) {
            return fromJchInFrame(j, c2, h2, Frame.INSTANCE.getDefault());
        }

        private final Cam fromJchInFrame(float j, float c2, float h2, Frame frame) {
            float flRoot = c2 * frame.getFlRoot();
            float fSqrt = ((float) Math.sqrt(((c2 / ((float) Math.sqrt(((double) j) / 100.0d))) * frame.getC()) / (frame.getAw() + 4.0f))) * 50.0f;
            float f2 = (1.7f * j) / ((0.007f * j) + 1.0f);
            float fLog = ((float) Math.log((((double) flRoot) * 0.0228d) + 1.0d)) * 43.85965f;
            double d2 = (3.1415927f * h2) / 180.0f;
            return new Cam(h2, c2, j, flRoot, fSqrt, f2, fLog * ((float) Math.cos(d2)), fLog * ((float) Math.sin(d2)));
        }

        private final int getInt(float hue, float chroma, float lstar, Frame frame) {
            if (Intrinsics.areEqual(frame, Frame.INSTANCE.getDefault())) {
                return HctSolver.INSTANCE.solveToInt(hue, chroma, lstar);
            }
            if (chroma < 1.0d || Math.round(lstar) <= 0.0d || Math.round(lstar) >= 100.0d) {
                return CamUtils.INSTANCE.intFromLstar(lstar);
            }
            float fMin = hue < 0.0f ? 0.0f : Math.min(360.0f, hue);
            Cam cam = null;
            boolean z = true;
            float f2 = 0.0f;
            float f3 = chroma;
            while (Math.abs(f2 - chroma) >= 0.4000000059604645d) {
                Cam camFindCamByJ = findCamByJ(fMin, f3, lstar);
                if (!z) {
                    if (camFindCamByJ == null) {
                        chroma = f3;
                    } else {
                        f2 = f3;
                        cam = camFindCamByJ;
                    }
                    f3 = ((chroma - f2) / 2.0f) + f2;
                } else {
                    if (camFindCamByJ != null) {
                        return camFindCamByJ.viewed(frame);
                    }
                    f3 = ((chroma - f2) / 2.0f) + f2;
                    z = false;
                }
            }
            if (cam == null) {
                return CamUtils.INSTANCE.intFromLstar(lstar);
            }
            return cam.viewed(frame);
        }

        private final Cam findCamByJ(float hue, float chroma, float lstar) {
            float f2 = 100.0f;
            float f3 = 1000.0f;
            float f4 = 0.0f;
            Cam cam = null;
            float f5 = 1000.0f;
            while (Math.abs(f4 - f2) > 0.009999999776482582d) {
                float f6 = ((f2 - f4) / 2) + f4;
                int iViewedInSrgb = fromJch(f6, chroma, hue).viewedInSrgb();
                float fLstarFromInt = CamUtils.INSTANCE.lstarFromInt(iViewedInSrgb);
                float fAbs = (float) Math.abs(lstar - fLstarFromInt);
                if (fAbs < 0.2f) {
                    Cam camFromInt = fromInt(iViewedInSrgb);
                    float fDistance = camFromInt.distance(fromJch(camFromInt.getJ(), camFromInt.getChroma(), hue));
                    if (fDistance <= 1.0f) {
                        cam = camFromInt;
                        f3 = fAbs;
                        f5 = fDistance;
                    }
                }
                if (f3 == 0.0f && f5 == 0.0f) {
                    return cam;
                }
                if (fLstarFromInt < lstar) {
                    f4 = f6;
                } else {
                    f2 = f6;
                }
            }
            return cam;
        }
    }
}
