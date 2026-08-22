package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: ArcSpline.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "<init>", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", "v", "getSlope", "Arc", "animation-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ArcSpline {
    public static final int $stable = 8;
    private final Arc[][] arcs;
    private final boolean isExtrapolate = true;

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[PHI: r10
      0x002f: PHI (r10v1 int) = (r10v0 int), (r10v3 int), (r10v4 int) binds: [B:5:0x0018, B:10:0x0021, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArcSpline(int[] r22, float[] r23, float[][] r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            r0.<init>()
            r2 = 1
            r0.isExtrapolate = r2
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.compose.animation.core.ArcSpline$Arc[][] r4 = new androidx.compose.animation.core.ArcSpline.Arc[r3][]
            r5 = 0
            r7 = r2
            r8 = r7
            r6 = r5
        L12:
            if (r6 >= r3) goto L66
            r9 = r22[r6]
            r10 = 3
            r11 = 2
            if (r9 == 0) goto L2f
            if (r9 == r2) goto L2c
            if (r9 == r11) goto L2a
            if (r9 == r10) goto L28
            r10 = 4
            if (r9 == r10) goto L2f
            r10 = 5
            if (r9 == r10) goto L2f
            r13 = r8
            goto L30
        L28:
            if (r7 != r2) goto L2c
        L2a:
            r7 = r11
            goto L2d
        L2c:
            r7 = r2
        L2d:
            r13 = r7
            goto L30
        L2f:
            r13 = r10
        L30:
            r8 = r24[r6]
            int r9 = r6 + 1
            r10 = r24[r9]
            r14 = r1[r6]
            r15 = r1[r9]
            int r12 = r8.length
            int r12 = r12 / r11
            int r2 = r8.length
            int r2 = r2 % r11
            int r2 = r2 + r12
            androidx.compose.animation.core.ArcSpline$Arc[] r11 = new androidx.compose.animation.core.ArcSpline.Arc[r2]
            r12 = r5
        L42:
            if (r12 >= r2) goto L60
            int r16 = r12 * 2
            r17 = r12
            androidx.compose.animation.core.ArcSpline$Arc r12 = new androidx.compose.animation.core.ArcSpline$Arc
            r18 = r16
            r16 = r8[r18]
            int r19 = r18 + 1
            r20 = r17
            r17 = r8[r19]
            r18 = r10[r18]
            r19 = r10[r19]
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            r11[r20] = r12
            int r12 = r20 + 1
            goto L42
        L60:
            r4[r6] = r11
            r6 = r9
            r8 = r13
            r2 = 1
            goto L12
        L66:
            r0.arcs = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.ArcSpline.<init>(int[], float[], float[][]):void");
    }

    public final void getPos(float time, float[] v) {
        Arc[][] arcArr = this.arcs;
        Arc[][] arcArr2 = arcArr;
        int length = arcArr2.length - 1;
        int i = 0;
        float time1 = arcArr[0][0].getTime1();
        float time2 = arcArr[length][0].getTime2();
        int length2 = v.length;
        if (!this.isExtrapolate) {
            time = Math.min(Math.max(time, time1), time2);
        } else if (time < time1 || time > time2) {
            if (time > time2) {
                time1 = time2;
            } else {
                length = 0;
            }
            float f2 = time - time1;
            int i2 = 0;
            while (i < length2 - 1) {
                Arc arc = arcArr[length][i2];
                if (arc.isLinear) {
                    v[i] = arc.getLinearX(time1) + (arc.ellipseCenterX * f2);
                    v[i + 1] = arc.getLinearY(time1) + (arc.ellipseCenterY * f2);
                } else {
                    arc.setPoint(time1);
                    v[i] = arc.ellipseCenterX + (arc.ellipseA * arc.tmpSinAngle) + (arc.calcDX() * f2);
                    v[i + 1] = arc.ellipseCenterY + (arc.ellipseB * arc.tmpCosAngle) + (arc.calcDY() * f2);
                }
                i += 2;
                i2++;
            }
            return;
        }
        int length3 = arcArr2.length;
        boolean z = false;
        for (int i3 = 0; i3 < length3; i3++) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < length2 - 1) {
                Arc arc2 = arcArr[i3][i5];
                if (time <= arc2.getTime2()) {
                    if (arc2.isLinear) {
                        v[i4] = arc2.getLinearX(time);
                        v[i4 + 1] = arc2.getLinearY(time);
                    } else {
                        arc2.setPoint(time);
                        v[i4] = arc2.ellipseCenterX + (arc2.ellipseA * arc2.tmpSinAngle);
                        v[i4 + 1] = arc2.ellipseCenterY + (arc2.ellipseB * arc2.tmpCosAngle);
                    }
                    z = true;
                }
                i4 += 2;
                i5++;
            }
            if (z) {
                return;
            }
        }
    }

    public final void getSlope(float time, float[] v) {
        Arc[][] arcArr = this.arcs;
        float time1 = arcArr[0][0].getTime1();
        Arc[][] arcArr2 = arcArr;
        float time2 = arcArr[arcArr2.length - 1][0].getTime2();
        if (time < time1) {
            time = time1;
        }
        if (time <= time2) {
            time2 = time;
        }
        int length = v.length;
        int length2 = arcArr2.length;
        boolean z = false;
        for (int i = 0; i < length2; i++) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < length - 1) {
                Arc arc = arcArr[i][i3];
                if (time2 <= arc.getTime2()) {
                    if (!arc.isLinear) {
                        arc.setPoint(time2);
                        v[i2] = arc.calcDX();
                        v[i2 + 1] = arc.calcDY();
                    } else {
                        v[i2] = arc.ellipseCenterX;
                        v[i2 + 1] = arc.ellipseCenterY;
                    }
                    z = true;
                }
                i2 += 2;
                i3++;
            }
            if (z) {
                return;
            }
        }
    }

    /* JADX INFO: compiled from: ArcSpline.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u0011\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0082\bJ\t\u0010&\u001a\u00020\u0005H\u0086\bJ\t\u0010'\u001a\u00020\u0005H\u0086\bJ\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J-\u0010.\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0002\b/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u001e\u001a\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR\u0015\u0010 \u001a\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000e¨\u00060"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "mode", "", "time1", "", "time2", "x1", "y1", "x2", "y2", "<init>", "(IFFFFFF)V", "getTime1", "()F", "getTime2", "arcDistance", "tmpSinAngle", "tmpCosAngle", "lut", "", "oneOverDeltaTime", "arcVelocity", "vertical", "ellipseA", "ellipseB", "isLinear", "", "ellipseCenterX", "ellipseCenterY", "linearDX", "getLinearDX$animation_core", "linearDY", "getLinearDY$animation_core", "setPoint", "", "time", "calcAngle", "calcX", "calcY", "calcDX", "calcDY", "getLinearX", "getLinearY", "lookup", "v", "buildTable", "buildTable$animation_core", "animation-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Arc {
        public static final int $stable = 8;
        private float arcDistance;
        private final float arcVelocity;
        public final float ellipseA;
        public final float ellipseB;
        public final float ellipseCenterX;
        public final float ellipseCenterY;
        public final boolean isLinear;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float vertical;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        public Arc(int i, float f2, float f3, float f4, float f5, float f6, float f7) {
            this.time1 = f2;
            this.time2 = f3;
            this.x1 = f4;
            this.y1 = f5;
            this.x2 = f6;
            this.y2 = f7;
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            boolean z = true;
            boolean z2 = i == 1 || (i == 4 ? f9 > 0.0f : !(i != 5 || f9 >= 0.0f));
            float f10 = z2 ? -1.0f : 1.0f;
            this.vertical = f10;
            float f11 = 1 / (f3 - f2);
            this.oneOverDeltaTime = f11;
            this.lut = new float[101];
            boolean z3 = i == 3;
            if (z3 || Math.abs(f8) < 0.001f || Math.abs(f9) < 0.001f) {
                float fHypot = (float) Math.hypot(f9, f8);
                this.arcDistance = fHypot;
                this.arcVelocity = fHypot * f11;
                this.ellipseCenterX = f8 * f11;
                this.ellipseCenterY = f9 * f11;
                this.ellipseA = Float.NaN;
                this.ellipseB = Float.NaN;
            } else {
                this.ellipseA = f8 * f10;
                this.ellipseB = f9 * (-f10);
                this.ellipseCenterX = z2 ? f6 : f4;
                this.ellipseCenterY = z2 ? f5 : f7;
                buildTable$animation_core(f4, f5, f6, f7);
                this.arcVelocity = this.arcDistance * f11;
                z = z3;
            }
            this.isLinear = z;
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        /* JADX INFO: renamed from: getLinearDX$animation_core, reason: from getter */
        public final float getEllipseCenterX() {
            return this.ellipseCenterX;
        }

        /* JADX INFO: renamed from: getLinearDY$animation_core, reason: from getter */
        public final float getEllipseCenterY() {
            return this.ellipseCenterY;
        }

        private final float calcAngle(float time) {
            return lookup((this.vertical == -1.0f ? this.time2 - time : time - this.time1) * this.oneOverDeltaTime) * 1.5707964f;
        }

        public final float calcX() {
            return this.ellipseCenterX + (this.ellipseA * this.tmpSinAngle);
        }

        public final float calcY() {
            return this.ellipseCenterY + (this.ellipseB * this.tmpCosAngle);
        }

        public final float calcDX() {
            float f2 = this.ellipseA * this.tmpCosAngle;
            return f2 * this.vertical * (this.arcVelocity / ((float) Math.hypot(f2, (-this.ellipseB) * this.tmpSinAngle)));
        }

        public final float calcDY() {
            float f2 = this.ellipseA * this.tmpCosAngle;
            float f3 = (-this.ellipseB) * this.tmpSinAngle;
            return f3 * this.vertical * (this.arcVelocity / ((float) Math.hypot(f2, f3)));
        }

        public final float getLinearX(float time) {
            float f2 = (time - this.time1) * this.oneOverDeltaTime;
            float f3 = this.x1;
            return f3 + (f2 * (this.x2 - f3));
        }

        public final float getLinearY(float time) {
            float f2 = (time - this.time1) * this.oneOverDeltaTime;
            float f3 = this.y1;
            return f3 + (f2 * (this.y2 - f3));
        }

        private final float lookup(float v) {
            if (v <= 0.0f) {
                return 0.0f;
            }
            if (v >= 1.0f) {
                return 1.0f;
            }
            float f2 = v * 100;
            int i = (int) f2;
            float f3 = f2 - i;
            float[] fArr = this.lut;
            float f4 = fArr[i];
            return f4 + (f3 * (fArr[i + 1] - f4));
        }

        public final void buildTable$animation_core(float x1, float y1, float x2, float y2) {
            float f2;
            float f3;
            float fHypot;
            float f4 = x2 - x1;
            float f5 = y1 - y2;
            float[] fArr = ArcSplineKt.OurPercentCache;
            int length = fArr.length - 1;
            float f6 = length;
            float[] fArr2 = this.lut;
            if (1 <= length) {
                float f7 = f5;
                int i = 1;
                fHypot = 0.0f;
                float f8 = 0.0f;
                while (true) {
                    f3 = 0.0f;
                    double d2 = (float) (((((double) i) * 90.0d) / ((double) length)) * 0.017453292519943295d);
                    float fSin = ((float) Math.sin(d2)) * f4;
                    float fCos = ((float) Math.cos(d2)) * f5;
                    f2 = f6;
                    fHypot += (float) Math.hypot(fSin - f8, fCos - f7);
                    fArr[i] = fHypot;
                    if (i == length) {
                        break;
                    }
                    i++;
                    f7 = fCos;
                    f6 = f2;
                    f8 = fSin;
                }
            } else {
                f2 = f6;
                f3 = 0.0f;
                fHypot = 0.0f;
            }
            this.arcDistance = fHypot;
            if (1 <= length) {
                int i2 = 1;
                while (true) {
                    fArr[i2] = fArr[i2] / fHypot;
                    if (i2 == length) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            int length2 = fArr2.length;
            for (int i3 = 0; i3 < length2; i3++) {
                float f9 = i3 / 100.0f;
                int iBinarySearch$default = ArraysKt.binarySearch$default(fArr, f9, 0, 0, 6, (Object) null);
                if (iBinarySearch$default >= 0) {
                    fArr2[i3] = iBinarySearch$default / f2;
                } else if (iBinarySearch$default == -1) {
                    fArr2[i3] = f3;
                } else {
                    int i4 = -iBinarySearch$default;
                    int i5 = i4 - 2;
                    float f10 = i5;
                    float f11 = fArr[i5];
                    fArr2[i3] = (f10 + ((f9 - f11) / (fArr[i4 - 1] - f11))) / f2;
                }
            }
        }

        public final void setPoint(float time) {
            double dLookup = lookup((this.vertical == -1.0f ? this.time2 - time : time - this.time1) * this.oneOverDeltaTime) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(dLookup);
            this.tmpCosAngle = (float) Math.cos(dLookup);
        }
    }
}
