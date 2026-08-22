package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 1;
        while (i2 < str.length()) {
            int iNextStart = nextStart(str, i2);
            String strTrim = str.substring(i, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i = iNextStart;
            i2 = iNextStart + 1;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        arrayList.add(new PathDataNode(c2, fArr));
    }

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L37
        L27:
            r10.mEndWithNegOrDot = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.mEndWithNegOrDot = r7
            goto L35
        L31:
            r2 = r0
            goto L37
        L33:
            r2 = r7
            goto L37
        L35:
            r2 = r0
            r4 = r7
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    public static void interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, float f2, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    @Deprecated
    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f2) {
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f2);
        }
        return true;
    }

    public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
        float[] fArr = new float[6];
        char c2 = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c2, pathDataNode.mType, pathDataNode.mParams);
            c2 = pathDataNode.mType;
        }
    }

    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public char getType() {
            return this.mType;
        }

        public float[] getParams() {
            return this.mParams;
        }

        PathDataNode(char c2, float[] fArr) {
            this.mType = c2;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        @Deprecated
        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f2) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i >= fArr.length) {
                    return;
                }
                this.mParams[i] = (fArr[i] * (1.0f - f2)) + (pathDataNode2.mParams[i] * f2);
                i++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i;
            int i2;
            boolean z;
            boolean z2;
            char c4;
            char c5;
            int i3;
            float f2;
            boolean z3;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            boolean z4;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            Path path2 = path;
            boolean z5 = false;
            float f18 = fArr[0];
            boolean z6 = true;
            float f19 = fArr[1];
            char c6 = 2;
            float f20 = fArr[2];
            char c7 = 3;
            float f21 = fArr[3];
            float f22 = fArr[4];
            float f23 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    i2 = i;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    i2 = i;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                    i2 = 2;
                    break;
            }
            float f24 = f18;
            float f25 = f19;
            float f26 = f22;
            float f27 = f23;
            int i4 = 0;
            char c8 = c2;
            while (i4 < fArr2.length) {
                if (c3 == 'A') {
                    float f28 = f24;
                    float f29 = f25;
                    z = z5;
                    z2 = z6;
                    c4 = c6;
                    c5 = c7;
                    i3 = i4;
                    int i5 = i3 + 5;
                    float f30 = fArr2[i5];
                    int i6 = i3 + 6;
                    float f31 = fArr2[i6];
                    float f32 = fArr2[i3];
                    float f33 = fArr2[i3 + 1];
                    float f34 = fArr2[i3 + 2];
                    if (fArr2[i3 + 3] != 0.0f) {
                        f2 = 0.0f;
                        z3 = z2;
                    } else {
                        f2 = 0.0f;
                        z3 = z;
                    }
                    drawArc(path, f28, f29, f30, f31, f32, f33, f34, z3, fArr2[i3 + 4] != f2 ? z2 : z);
                    f20 = fArr2[i5];
                    f24 = f20;
                    f21 = fArr2[i6];
                    f25 = f21;
                } else if (c3 == 'C') {
                    z = z5;
                    z2 = z6;
                    c4 = c6;
                    c5 = c7;
                    i3 = i4;
                    int i7 = i3 + 2;
                    int i8 = i3 + 3;
                    int i9 = i3 + 4;
                    int i10 = i3 + 5;
                    path2.cubicTo(fArr2[i3], fArr2[i3 + 1], fArr2[i7], fArr2[i8], fArr2[i9], fArr2[i10]);
                    float f35 = fArr2[i9];
                    float f36 = fArr2[i10];
                    float f37 = fArr2[i7];
                    float f38 = fArr2[i8];
                    f24 = f35;
                    f25 = f36;
                    f21 = f38;
                    f20 = f37;
                } else if (c3 != 'H') {
                    if (c3 != 'Q') {
                        z = z5;
                        if (c3 == 'V') {
                            z2 = z6;
                            c4 = c6;
                            c5 = c7;
                            i3 = i4;
                            path2.lineTo(f24, fArr2[i3]);
                            f5 = fArr2[i3];
                        } else if (c3 != 'a') {
                            if (c3 != 'c') {
                                z2 = z6;
                                if (c3 != 'h') {
                                    if (c3 != 'q') {
                                        c4 = c6;
                                        if (c3 != 'v') {
                                            if (c3 != 'L') {
                                                if (c3 != 'M') {
                                                    c5 = c7;
                                                    if (c3 == 'S') {
                                                        if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                            f24 = (f24 * 2.0f) - f20;
                                                            f25 = (f25 * 2.0f) - f21;
                                                        }
                                                        int i11 = i4 + 1;
                                                        int i12 = i4 + 2;
                                                        int i13 = i4 + 3;
                                                        path2.cubicTo(f24, f25, fArr2[i4], fArr2[i11], fArr2[i12], fArr2[i13]);
                                                        f3 = fArr2[i4];
                                                        f4 = fArr2[i11];
                                                        f24 = fArr2[i12];
                                                        f25 = fArr2[i13];
                                                        i3 = i4;
                                                    } else if (c3 == 'T') {
                                                        if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                            f24 = (f24 * 2.0f) - f20;
                                                            f25 = (f25 * 2.0f) - f21;
                                                        }
                                                        int i14 = i4 + 1;
                                                        path2.quadTo(f24, f25, fArr2[i4], fArr2[i14]);
                                                        float f39 = fArr2[i4];
                                                        f5 = fArr2[i14];
                                                        f20 = f24;
                                                        f21 = f25;
                                                        i3 = i4;
                                                        f24 = f39;
                                                    } else if (c3 == 'l') {
                                                        int i15 = i4 + 1;
                                                        path2.rLineTo(fArr2[i4], fArr2[i15]);
                                                        f24 += fArr2[i4];
                                                        f11 = fArr2[i15];
                                                    } else if (c3 == 'm') {
                                                        float f40 = fArr2[i4];
                                                        f24 += f40;
                                                        float f41 = fArr2[i4 + 1];
                                                        f25 += f41;
                                                        if (i4 > 0) {
                                                            path2.rLineTo(f40, f41);
                                                        } else {
                                                            path2.rMoveTo(f40, f41);
                                                            f26 = f24;
                                                        }
                                                    } else if (c3 == 's') {
                                                        if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                            f14 = f25 - f21;
                                                            f15 = f24 - f20;
                                                        } else {
                                                            f15 = 0.0f;
                                                            f14 = 0.0f;
                                                        }
                                                        int i16 = i4 + 1;
                                                        int i17 = i4 + 2;
                                                        int i18 = i4 + 3;
                                                        path2.rCubicTo(f15, f14, fArr2[i4], fArr2[i16], fArr2[i17], fArr2[i18]);
                                                        f8 = fArr2[i4] + f24;
                                                        f9 = fArr2[i16] + f25;
                                                        f24 += fArr2[i17];
                                                        f10 = fArr2[i18];
                                                    } else if (c3 == 't') {
                                                        if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                            f16 = f24 - f20;
                                                            f17 = f25 - f21;
                                                        } else {
                                                            f17 = 0.0f;
                                                            f16 = 0.0f;
                                                        }
                                                        int i19 = i4 + 1;
                                                        path2.rQuadTo(f16, f17, fArr2[i4], fArr2[i19]);
                                                        float f42 = f16 + f24;
                                                        float f43 = f17 + f25;
                                                        f24 += fArr2[i4];
                                                        f25 += fArr2[i19];
                                                        f21 = f43;
                                                        f20 = f42;
                                                    }
                                                } else {
                                                    c5 = c7;
                                                    f12 = fArr2[i4];
                                                    f13 = fArr2[i4 + 1];
                                                    if (i4 > 0) {
                                                        path2.lineTo(f12, f13);
                                                    } else {
                                                        path2.moveTo(f12, f13);
                                                        f24 = f12;
                                                        f26 = f24;
                                                        f25 = f13;
                                                    }
                                                }
                                                f27 = f25;
                                            } else {
                                                c5 = c7;
                                                int i20 = i4 + 1;
                                                path2.lineTo(fArr2[i4], fArr2[i20]);
                                                f12 = fArr2[i4];
                                                f13 = fArr2[i20];
                                            }
                                            f24 = f12;
                                            f25 = f13;
                                        } else {
                                            c5 = c7;
                                            path2.rLineTo(0.0f, fArr2[i4]);
                                            f11 = fArr2[i4];
                                        }
                                        f25 += f11;
                                    } else {
                                        c4 = c6;
                                        c5 = c7;
                                        int i21 = i4 + 1;
                                        int i22 = i4 + 2;
                                        int i23 = i4 + 3;
                                        path2.rQuadTo(fArr2[i4], fArr2[i21], fArr2[i22], fArr2[i23]);
                                        f8 = fArr2[i4] + f24;
                                        f9 = fArr2[i21] + f25;
                                        f24 += fArr2[i22];
                                        f10 = fArr2[i23];
                                    }
                                    f25 += f10;
                                    f20 = f8;
                                    f21 = f9;
                                } else {
                                    c4 = c6;
                                    c5 = c7;
                                    path2.rLineTo(fArr2[i4], 0.0f);
                                    f24 += fArr2[i4];
                                }
                            } else {
                                z2 = z6;
                                c4 = c6;
                                c5 = c7;
                                int i24 = i4 + 2;
                                int i25 = i4 + 3;
                                int i26 = i4 + 4;
                                int i27 = i4 + 5;
                                path2.rCubicTo(fArr2[i4], fArr2[i4 + 1], fArr2[i24], fArr2[i25], fArr2[i26], fArr2[i27]);
                                float f44 = fArr2[i24] + f24;
                                float f45 = fArr2[i25] + f25;
                                f24 += fArr2[i26];
                                f25 += fArr2[i27];
                                f20 = f44;
                                f21 = f45;
                            }
                            i3 = i4;
                        } else {
                            z2 = z6;
                            c4 = c6;
                            c5 = c7;
                            int i28 = i4 + 5;
                            float f46 = fArr2[i28] + f24;
                            int i29 = i4 + 6;
                            float f47 = fArr2[i29] + f25;
                            float f48 = fArr2[i4];
                            float f49 = fArr2[i4 + 1];
                            float f50 = fArr2[i4 + 2];
                            if (fArr2[i4 + 3] != 0.0f) {
                                f6 = 0.0f;
                                f7 = f25;
                                z4 = z2;
                            } else {
                                f6 = 0.0f;
                                f7 = f25;
                                z4 = z;
                            }
                            i3 = i4;
                            boolean z7 = fArr2[i4 + 4] != f6 ? z2 : z;
                            float f51 = f24;
                            drawArc(path, f51, f7, f46, f47, f48, f49, f50, z4, z7);
                            f24 = f51 + fArr2[i28];
                            f25 = f7 + fArr2[i29];
                            f20 = f24;
                            f21 = f25;
                        }
                        f25 = f5;
                    } else {
                        z = z5;
                        z2 = z6;
                        c4 = c6;
                        c5 = c7;
                        i3 = i4;
                        int i30 = i3 + 1;
                        int i31 = i3 + 2;
                        int i32 = i3 + 3;
                        path2.quadTo(fArr2[i3], fArr2[i30], fArr2[i31], fArr2[i32]);
                        f3 = fArr2[i3];
                        f4 = fArr2[i30];
                        f24 = fArr2[i31];
                        f25 = fArr2[i32];
                    }
                    f20 = f3;
                    f21 = f4;
                } else {
                    z = z5;
                    z2 = z6;
                    c4 = c6;
                    c5 = c7;
                    i3 = i4;
                    path2.lineTo(fArr2[i3], f25);
                    f24 = fArr2[i3];
                }
                i4 = i3 + i2;
                path2 = path;
                c8 = c3;
                z5 = z;
                z6 = z2;
                c6 = c4;
                c7 = c5;
            }
            fArr[z5 ? 1 : 0] = f24;
            fArr[z6 ? 1 : 0] = f25;
            fArr[c6] = f20;
            fArr[c7] = f21;
            fArr[4] = f26;
            fArr[5] = f27;
        }

        private static void drawArc(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians(f8);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d4 = f2;
            double d5 = f3;
            double d6 = f6;
            double d7 = ((d4 * dCos) + (d5 * dSin)) / d6;
            double d8 = f7;
            double d9 = ((((double) (-f2)) * dSin) + (d5 * dCos)) / d8;
            double d10 = f5;
            double d11 = ((((double) f4) * dCos) + (d10 * dSin)) / d6;
            double d12 = ((((double) (-f4)) * dSin) + (d10 * dCos)) / d8;
            double d13 = d7 - d11;
            double d14 = d9 - d12;
            double d15 = (d7 + d11) / 2.0d;
            double d16 = (d9 + d12) / 2.0d;
            double d17 = (d13 * d13) + (d14 * d14);
            if (d17 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d18 = (1.0d / d17) - 0.25d;
            if (d18 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d17);
                float fSqrt = (float) (Math.sqrt(d17) / 1.99999d);
                drawArc(path, f2, f3, f4, f5, f6 * fSqrt, fSqrt * f7, f8, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d18);
            double d19 = d13 * dSqrt;
            double d20 = dSqrt * d14;
            if (z == z2) {
                d2 = d15 - d20;
                d3 = d16 + d19;
            } else {
                d2 = d15 + d20;
                d3 = d16 - d19;
            }
            double dAtan2 = Math.atan2(d9 - d3, d7 - d2);
            double dAtan22 = Math.atan2(d12 - d3, d11 - d2) - dAtan2;
            if (z2 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d21 = d2 * d6;
            double d22 = d3 * d8;
            arcToBezier(path, (d21 * dCos) - (d22 * dSin), (d21 * dSin) + (d22 * dCos), d6, d8, d4, d5, radians, dAtan2, dAtan22);
        }

        private static void arcToBezier(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int iCeil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d8);
            double dSin = Math.sin(d8);
            double dCos2 = Math.cos(d9);
            double dSin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * dCos;
            double d14 = d5 * dSin;
            double d15 = (d13 * dSin2) - (d14 * dCos2);
            double d16 = d12 * dSin;
            double d17 = d5 * dCos;
            double d18 = (dSin2 * d16) + (dCos2 * d17);
            double d19 = d10 / ((double) iCeil);
            double d20 = d18;
            double d21 = d15;
            int i = 0;
            double d22 = d6;
            double d23 = d7;
            double d24 = d9;
            while (i < iCeil) {
                double d25 = d24 + d19;
                double dSin3 = Math.sin(d25);
                double dCos3 = Math.cos(d25);
                double d26 = (d2 + ((d11 * dCos) * dCos3)) - (d14 * dSin3);
                int i2 = i;
                double d27 = d3 + (d4 * dSin * dCos3) + (d17 * dSin3);
                double d28 = (d13 * dSin3) - (d14 * dCos3);
                double d29 = (dSin3 * d16) + (dCos3 * d17);
                double d30 = d25 - d24;
                double dTan = Math.tan(d30 / 2.0d);
                double dSin4 = (Math.sin(d30) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d31 = d22 + (d21 * dSin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d31, (float) (d23 + (d20 * dSin4)), (float) (d26 - (dSin4 * d28)), (float) (d27 - (dSin4 * d29)), (float) d26, (float) d27);
                dSin = dSin;
                d19 = d19;
                d22 = d26;
                d16 = d16;
                d24 = d25;
                d20 = d29;
                dCos = dCos;
                d11 = d4;
                d23 = d27;
                i = i2 + 1;
                iCeil = iCeil;
                d21 = d28;
            }
        }
    }

    private PathParser() {
    }
}
