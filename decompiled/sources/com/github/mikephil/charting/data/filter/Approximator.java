package com.github.mikephil.charting.data.filter;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class Approximator {
    public float[] reduceWithDouglasPeucker(float[] fArr, float f2) {
        Line line = new Line(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1]);
        float f3 = 0.0f;
        int i = 0;
        for (int i2 = 2; i2 < fArr.length - 2; i2 += 2) {
            float fDistance = line.distance(fArr[i2], fArr[i2 + 1]);
            if (fDistance > f3) {
                i = i2;
                f3 = fDistance;
            }
        }
        if (f3 > f2) {
            float[] fArrReduceWithDouglasPeucker = reduceWithDouglasPeucker(Arrays.copyOfRange(fArr, 0, i + 2), f2);
            float[] fArrReduceWithDouglasPeucker2 = reduceWithDouglasPeucker(Arrays.copyOfRange(fArr, i, fArr.length), f2);
            return concat(fArrReduceWithDouglasPeucker, Arrays.copyOfRange(fArrReduceWithDouglasPeucker2, 2, fArrReduceWithDouglasPeucker2.length));
        }
        return line.getPoints();
    }

    float[] concat(float[]... fArr) {
        int length = 0;
        for (float[] fArr2 : fArr) {
            length += fArr2.length;
        }
        float[] fArr3 = new float[length];
        int i = 0;
        for (float[] fArr4 : fArr) {
            for (float f2 : fArr4) {
                fArr3[i] = f2;
                i++;
            }
        }
        return fArr3;
    }

    private class Line {
        private float dx;
        private float dy;
        private float exsy;
        private float length;
        private float[] points;
        private float sxey;

        public Line(float f2, float f3, float f4, float f5) {
            this.dx = f2 - f4;
            this.dy = f3 - f5;
            this.sxey = f2 * f5;
            this.exsy = f4 * f3;
            this.length = (float) Math.sqrt((r3 * r3) + (r0 * r0));
            this.points = new float[]{f2, f3, f4, f5};
        }

        public float distance(float f2, float f3) {
            return Math.abs((((this.dy * f2) - (this.dx * f3)) + this.sxey) - this.exsy) / this.length;
        }

        public float[] getPoints() {
            return this.points;
        }
    }
}
