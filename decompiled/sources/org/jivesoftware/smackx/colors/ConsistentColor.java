package org.jivesoftware.smackx.colors;

import org.hsluv.HUSLColorConverter;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.SHA1;

/* JADX INFO: loaded from: classes10.dex */
public class ConsistentColor {
    private static final ConsistentColorSettings DEFAULT_SETTINGS = new ConsistentColorSettings();

    public enum Deficiency {
        none,
        redGreenBlindness,
        blueBlindness
    }

    private static int u(byte b2) {
        return b2 & 255;
    }

    private static double createAngle(CharSequence charSequence) {
        byte[] bArrBytes = SHA1.bytes(charSequence.toString());
        return (((double) (u(bArrBytes[0]) + (u(bArrBytes[1]) * 256))) / 65536.0d) * 360.0d;
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.colors.ConsistentColor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency;

        static {
            int[] iArr = new int[Deficiency.values().length];
            $SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency = iArr;
            try {
                iArr[Deficiency.none.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency[Deficiency.redGreenBlindness.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency[Deficiency.blueBlindness.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static double applyColorDeficiencyCorrection(double d2, Deficiency deficiency) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency[deficiency.ordinal()];
        return i != 2 ? i != 3 ? d2 : d2 % 180.0d : (((d2 + 90.0d) % 180.0d) + 270.0d) % 360.0d;
    }

    private static double[] hsluvToRgb(double d2) {
        return hsluvToRgb(d2, 100.0d, 50.0d);
    }

    private static double[] hsluvToRgb(double d2, double d3, double d4) {
        return HUSLColorConverter.hsluvToRgb(new double[]{d2, d3, d4});
    }

    private static double[] mixWithBackground(double[] dArr, float[] fArr) {
        return new double[]{(((double) (1.0f - fArr[0])) * 0.2d) + (dArr[0] * 0.8d), (((double) (1.0f - fArr[1])) * 0.2d) + (dArr[1] * 0.8d), (((double) (1.0f - fArr[2])) * 0.2d) + (dArr[2] * 0.8d)};
    }

    public static float[] RGBFrom(CharSequence charSequence) {
        return RGBFrom(charSequence, DEFAULT_SETTINGS);
    }

    public static float[] RGBFrom(CharSequence charSequence, ConsistentColorSettings consistentColorSettings) {
        double[] dArrHsluvToRgb = hsluvToRgb(applyColorDeficiencyCorrection(createAngle(charSequence), consistentColorSettings.getDeficiency()));
        if (consistentColorSettings.backgroundRGB != null) {
            dArrHsluvToRgb = mixWithBackground(dArrHsluvToRgb, consistentColorSettings.backgroundRGB);
        }
        return new float[]{(float) dArrHsluvToRgb[0], (float) dArrHsluvToRgb[1], (float) dArrHsluvToRgb[2]};
    }

    public static int[] floatRgbToInts(float[] fArr) {
        return new int[]{(int) (fArr[0] * 255.0f), (int) (fArr[1] * 255.0f), (int) (fArr[2] * 255.0f)};
    }

    public static class ConsistentColorSettings {
        private final float[] backgroundRGB;
        private final Deficiency deficiency;

        public ConsistentColorSettings() {
            this.deficiency = Deficiency.none;
            this.backgroundRGB = null;
        }

        public ConsistentColorSettings(Deficiency deficiency) {
            this.deficiency = (Deficiency) Objects.requireNonNull(deficiency, "Deficiency must be given");
            this.backgroundRGB = null;
        }

        public ConsistentColorSettings(Deficiency deficiency, float[] fArr) {
            this.deficiency = (Deficiency) Objects.requireNonNull(deficiency, "Deficiency must be given");
            if (fArr.length != 3) {
                throw new IllegalArgumentException("Background RGB value array must have length 3.");
            }
            for (float f2 : fArr) {
                checkRange(f2, 0.0f, 1.0f);
            }
            this.backgroundRGB = fArr;
        }

        private static void checkRange(float f2, float f3, float f4) {
            if (f3 > f2 || f4 < f2) {
                throw new IllegalArgumentException("Value out of range.");
            }
        }

        public Deficiency getDeficiency() {
            return this.deficiency;
        }
    }
}
