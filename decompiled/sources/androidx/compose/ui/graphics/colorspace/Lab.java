package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import com.clevertap.android.sdk.network.api.CtApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: Lab.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics", "toZ", "toZ$ui_graphics", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", CtApi.QUERY_PARAM_Z_KEY, "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "Companion", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Lab extends ColorSpace {
    public static final int $stable = 0;
    private static final float A = 0.008856452f;
    private static final float B = 7.787037f;
    private static final float C = 0.13793103f;
    private static final float D = 0.20689656f;

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    public Lab(String str, int i) {
        super(str, ColorModel.INSTANCE.m6406getLabxdoWZVw(), i, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        float f2 = v[0];
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 100.0f) {
            f2 = 100.0f;
        }
        v[0] = f2;
        float f3 = v[1];
        if (f3 < -128.0f) {
            f3 = -128.0f;
        }
        if (f3 > 128.0f) {
            f3 = 128.0f;
        }
        v[1] = f3;
        float f4 = v[2];
        float f5 = f4 >= -128.0f ? f4 : -128.0f;
        float f6 = f5 <= 128.0f ? f5 : 128.0f;
        v[2] = f6;
        float f7 = (f2 + 16.0f) / 116.0f;
        float f8 = (f3 * 0.002f) + f7;
        float f9 = f7 - (f6 * 0.005f);
        float f10 = f8 > D ? f8 * f8 * f8 : (f8 - C) * 0.12841855f;
        float f11 = f7 > D ? f7 * f7 * f7 : (f7 - C) * 0.12841855f;
        float f12 = f9 > D ? f9 * f9 * f9 : (f9 - C) * 0.12841855f;
        v[0] = f10 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        v[1] = f11 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        v[2] = f12 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics(float v0, float v1, float v2) {
        if (v0 < 0.0f) {
            v0 = 0.0f;
        }
        if (v0 > 100.0f) {
            v0 = 100.0f;
        }
        if (v1 < -128.0f) {
            v1 = -128.0f;
        }
        if (v1 > 128.0f) {
            v1 = 128.0f;
        }
        float f2 = (v0 + 16.0f) / 116.0f;
        float f3 = (v1 * 0.002f) + f2;
        float f4 = f3 > D ? f3 * f3 * f3 : (f3 - C) * 0.12841855f;
        return (((long) Float.floatToRawIntBits((f2 > D ? f2 * f2 * f2 : (f2 - C) * 0.12841855f) * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1])) & 4294967295L) | (((long) Float.floatToRawIntBits(f4 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0])) << 32);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics(float v0, float v1, float v2) {
        if (v0 < 0.0f) {
            v0 = 0.0f;
        }
        if (v0 > 100.0f) {
            v0 = 100.0f;
        }
        if (v2 < -128.0f) {
            v2 = -128.0f;
        }
        if (v2 > 128.0f) {
            v2 = 128.0f;
        }
        float f2 = ((v0 + 16.0f) / 116.0f) - (v2 * 0.005f);
        return (f2 > D ? f2 * f2 * f2 : 0.12841855f * (f2 - C)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics */
    public long mo6410xyzaToColorJlNiLsg$ui_graphics(float x, float y, float z, float a2, ColorSpace colorSpace) {
        float f2 = x / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        float f3 = y / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        float f4 = z / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
        float fCbrt = f2 > A ? (float) Math.cbrt(f2) : (f2 * B) + C;
        float fCbrt2 = f3 > A ? (float) Math.cbrt(f3) : (f3 * B) + C;
        float f5 = (116.0f * fCbrt2) - 16.0f;
        float f6 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f4 > A ? (float) Math.cbrt(f4) : (f4 * B) + C)) * 200.0f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 100.0f) {
            f5 = 100.0f;
        }
        if (f6 < -128.0f) {
            f6 = -128.0f;
        }
        if (f6 > 128.0f) {
            f6 = 128.0f;
        }
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        return ColorKt.Color(f5, f6, fCbrt3 <= 128.0f ? fCbrt3 : 128.0f, a2, colorSpace);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        float f2 = v[0] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        float f3 = v[1] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        float f4 = v[2] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
        float fCbrt = f2 > A ? (float) Math.cbrt(f2) : (f2 * B) + C;
        float fCbrt2 = f3 > A ? (float) Math.cbrt(f3) : (f3 * B) + C;
        float f5 = (116.0f * fCbrt2) - 16.0f;
        float f6 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f4 > A ? (float) Math.cbrt(f4) : (f4 * B) + C)) * 200.0f;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 100.0f) {
            f5 = 100.0f;
        }
        v[0] = f5;
        if (f6 < -128.0f) {
            f6 = -128.0f;
        }
        if (f6 > 128.0f) {
            f6 = 128.0f;
        }
        v[1] = f6;
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        v[2] = fCbrt3 <= 128.0f ? fCbrt3 : 128.0f;
        return v;
    }
}
