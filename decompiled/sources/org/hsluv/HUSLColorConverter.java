package org.hsluv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class HUSLColorConverter {
    private static double[][] m = {new double[]{3.240969941904521d, -1.537383177570093d, -0.498610760293d}, new double[]{-0.96924363628087d, 1.87596750150772d, 0.041555057407175d}, new double[]{0.055630079696993d, -0.20397695888897d, 1.056971514242878d}};
    private static double[][] minv = {new double[]{0.41239079926595d, 0.35758433938387d, 0.18048078840183d}, new double[]{0.21263900587151d, 0.71516867876775d, 0.072192315360733d}, new double[]{0.019330818715591d, 0.11919477979462d, 0.95053215224966d}};
    private static double refY = 1.0d;
    private static double refU = 0.19783000664283d;
    private static double refV = 0.46831999493879d;
    private static double kappa = 903.2962962d;
    private static double epsilon = 0.0088564516d;

    private static List<double[]> getBounds(double d2) {
        ArrayList arrayList = new ArrayList();
        double dPow = Math.pow(d2 + 16.0d, 3.0d) / 1560896.0d;
        if (dPow <= epsilon) {
            dPow = d2 / kappa;
        }
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            double[] dArr = m[i2];
            double d3 = dArr[i];
            char c2 = 1;
            double d4 = dArr[1];
            int i3 = 2;
            double d5 = dArr[2];
            int i4 = i;
            while (i4 < i3) {
                int i5 = i;
                char c3 = c2;
                double d6 = d4;
                double d7 = (((632260.0d * d5) - (126452.0d * d6)) * dPow) + ((double) (126452 * i4));
                double[] dArr2 = new double[2];
                dArr2[i5] = (((284517.0d * d3) - (94839.0d * d5)) * dPow) / d7;
                dArr2[c3] = ((((((838422.0d * d5) + (769860.0d * d4)) + (731718.0d * d3)) * d2) * dPow) - (((double) (i4 * 769860)) * d2)) / d7;
                arrayList.add(dArr2);
                i4++;
                i3 = 2;
                c2 = c3;
                i = i5;
                d4 = d6;
                d5 = d5;
            }
        }
        return arrayList;
    }

    private static double intersectLineLine(double[] dArr, double[] dArr2) {
        return (dArr[1] - dArr2[1]) / (dArr2[0] - dArr[0]);
    }

    private static double distanceFromPole(double[] dArr) {
        return Math.sqrt(Math.pow(dArr[0], 2.0d) + Math.pow(dArr[1], 2.0d));
    }

    private static Length lengthOfRayUntilIntersect(double d2, double[] dArr) {
        return new Length(dArr[1] / (Math.sin(d2) - (dArr[0] * Math.cos(d2))));
    }

    private static class Length {
        final boolean greaterEqualZero;
        final double length;

        private Length(double d2) {
            this.greaterEqualZero = d2 >= 0.0d;
            this.length = d2;
        }
    }

    private static double maxSafeChromaForL(double d2) {
        List<double[]> bounds = getBounds(d2);
        double dMin = Double.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            double d3 = bounds.get(i)[0];
            double d4 = bounds.get(i)[1];
            double dIntersectLineLine = intersectLineLine(new double[]{d3, d4}, new double[]{(-1.0d) / d3, 0.0d});
            dMin = Math.min(dMin, distanceFromPole(new double[]{dIntersectLineLine, d4 + (d3 * dIntersectLineLine)}));
        }
        return dMin;
    }

    private static double maxChromaForLH(double d2, double d3) {
        double d4 = (d3 / 360.0d) * 3.141592653589793d * 2.0d;
        Iterator<double[]> it = getBounds(d2).iterator();
        double dMin = Double.MAX_VALUE;
        while (it.hasNext()) {
            Length lengthLengthOfRayUntilIntersect = lengthOfRayUntilIntersect(d4, it.next());
            if (lengthLengthOfRayUntilIntersect.greaterEqualZero) {
                dMin = Math.min(dMin, lengthLengthOfRayUntilIntersect.length);
            }
        }
        return dMin;
    }

    private static double dotProduct(double[] dArr, double[] dArr2) {
        double d2 = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            d2 += dArr[i] * dArr2[i];
        }
        return d2;
    }

    private static double round(double d2, int i) {
        return Math.round(d2 * r0) / Math.pow(10.0d, i);
    }

    private static double fromLinear(double d2) {
        return d2 <= 0.0031308d ? d2 * 12.92d : (Math.pow(d2, 0.4166666666666667d) * 1.055d) - 0.055d;
    }

    private static double toLinear(double d2) {
        return d2 > 0.04045d ? Math.pow((d2 + 0.055d) / 1.055d, 2.4d) : d2 / 12.92d;
    }

    private static int[] rgbPrepare(double[] dArr) {
        int[] iArr = new int[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            double dRound = round(dArr[i], 3);
            if (dRound < -1.0E-4d || dRound > 1.0001d) {
                throw new IllegalArgumentException("Illegal rgb value: " + dRound);
            }
            iArr[i] = (int) Math.round(dRound * 255.0d);
        }
        return iArr;
    }

    public static double[] xyzToRgb(double[] dArr) {
        return new double[]{fromLinear(dotProduct(m[0], dArr)), fromLinear(dotProduct(m[1], dArr)), fromLinear(dotProduct(m[2], dArr))};
    }

    public static double[] rgbToXyz(double[] dArr) {
        double[] dArr2 = {toLinear(dArr[0]), toLinear(dArr[1]), toLinear(dArr[2])};
        return new double[]{dotProduct(minv[0], dArr2), dotProduct(minv[1], dArr2), dotProduct(minv[2], dArr2)};
    }

    private static double yToL(double d2) {
        if (d2 <= epsilon) {
            return (d2 / refY) * kappa;
        }
        return (Math.pow(d2 / refY, 0.3333333333333333d) * 116.0d) - 16.0d;
    }

    private static double lToY(double d2) {
        if (d2 <= 8.0d) {
            return (refY * d2) / kappa;
        }
        return refY * Math.pow((d2 + 16.0d) / 116.0d, 3.0d);
    }

    public static double[] xyzToLuv(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = 4.0d * d2;
        double d5 = d2 + (15.0d * d3) + (dArr[2] * 3.0d);
        double d6 = d4 / d5;
        double d7 = (9.0d * d3) / d5;
        double dYToL = yToL(d3);
        if (dYToL == 0.0d) {
            return new double[]{0.0d, 0.0d, 0.0d};
        }
        double d8 = 13.0d * dYToL;
        return new double[]{dYToL, (d6 - refU) * d8, d8 * (d7 - refV)};
    }

    public static double[] luvToXyz(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        if (d2 == 0.0d) {
            return new double[]{0.0d, 0.0d, 0.0d};
        }
        double d5 = 13.0d * d2;
        double d6 = (d3 / d5) + refU;
        double d7 = (d4 / d5) + refV;
        double dLToY = lToY(d2);
        double d8 = 9.0d * dLToY;
        double d9 = 0.0d - ((d8 * d6) / (((d6 - 4.0d) * d7) - (d6 * d7)));
        return new double[]{d9, dLToY, ((d8 - ((15.0d * d7) * dLToY)) - (d7 * d9)) / (d7 * 3.0d)};
    }

    public static double[] luvToLch(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        double dSqrt = Math.sqrt((d3 * d3) + (d4 * d4));
        double d5 = 0.0d;
        if (dSqrt >= 1.0E-8d) {
            double dAtan2 = (Math.atan2(d4, d3) * 180.0d) / 3.141592653589793d;
            d5 = dAtan2 < 0.0d ? dAtan2 + 360.0d : dAtan2;
        }
        return new double[]{d2, dSqrt, d5};
    }

    public static double[] lchToLuv(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = (dArr[2] / 360.0d) * 2.0d * 3.141592653589793d;
        return new double[]{d2, Math.cos(d4) * d3, Math.sin(d4) * d3};
    }

    public static double[] hsluvToLch(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        if (d4 > 99.9999999d) {
            return new double[]{100.0d, 0.0d, d2};
        }
        if (d4 < 1.0E-8d) {
            return new double[]{0.0d, 0.0d, d2};
        }
        return new double[]{d4, (maxChromaForLH(d4, d2) / 100.0d) * d3, d2};
    }

    public static double[] lchToHsluv(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        if (d2 > 99.9999999d) {
            return new double[]{d4, 0.0d, 100.0d};
        }
        if (d2 < 1.0E-8d) {
            return new double[]{d4, 0.0d, 0.0d};
        }
        return new double[]{d4, (d3 / maxChromaForLH(d2, d4)) * 100.0d, d2};
    }

    public static double[] hpluvToLch(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        if (d4 > 99.9999999d) {
            return new double[]{100.0d, 0.0d, d2};
        }
        if (d4 < 1.0E-8d) {
            return new double[]{0.0d, 0.0d, d2};
        }
        return new double[]{d4, (maxSafeChromaForL(d4) / 100.0d) * d3, d2};
    }

    public static double[] lchToHpluv(double[] dArr) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        if (d2 > 99.9999999d) {
            return new double[]{d4, 0.0d, 100.0d};
        }
        if (d2 < 1.0E-8d) {
            return new double[]{d4, 0.0d, 0.0d};
        }
        return new double[]{d4, (d3 / maxSafeChromaForL(d2)) * 100.0d, d2};
    }

    public static String rgbToHex(double[] dArr) {
        int[] iArrRgbPrepare = rgbPrepare(dArr);
        return String.format("#%02x%02x%02x", Integer.valueOf(iArrRgbPrepare[0]), Integer.valueOf(iArrRgbPrepare[1]), Integer.valueOf(iArrRgbPrepare[2]));
    }

    public static double[] hexToRgb(String str) {
        return new double[]{((double) Integer.parseInt(str.substring(1, 3), 16)) / 255.0d, ((double) Integer.parseInt(str.substring(3, 5), 16)) / 255.0d, ((double) Integer.parseInt(str.substring(5, 7), 16)) / 255.0d};
    }

    public static double[] lchToRgb(double[] dArr) {
        return xyzToRgb(luvToXyz(lchToLuv(dArr)));
    }

    public static double[] rgbToLch(double[] dArr) {
        return luvToLch(xyzToLuv(rgbToXyz(dArr)));
    }

    public static double[] hsluvToRgb(double[] dArr) {
        return lchToRgb(hsluvToLch(dArr));
    }

    public static double[] rgbToHsluv(double[] dArr) {
        return lchToHsluv(rgbToLch(dArr));
    }

    public static double[] hpluvToRgb(double[] dArr) {
        return lchToRgb(hpluvToLch(dArr));
    }

    public static double[] rgbToHpluv(double[] dArr) {
        return lchToHpluv(rgbToLch(dArr));
    }

    public static String hsluvToHex(double[] dArr) {
        return rgbToHex(hsluvToRgb(dArr));
    }

    public static String hpluvToHex(double[] dArr) {
        return rgbToHex(hpluvToRgb(dArr));
    }

    public static double[] hexToHsluv(String str) {
        return rgbToHsluv(hexToRgb(str));
    }

    public static double[] hexToHpluv(String str) {
        return rgbToHpluv(hexToRgb(str));
    }
}
