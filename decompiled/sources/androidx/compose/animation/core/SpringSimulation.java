package androidx.compose.animation.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0005R$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0005¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "<init>", "(F)V", "getFinalPosition", "()F", "setFinalPosition", "naturalFreq", "", "value", "stiffness", "getStiffness", "setStiffness", "dampingRatio", "getDampingRatio", "setDampingRatio", "getAcceleration", "lastDisplacement", "lastVelocity", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core", "(FFJ)J", "animation-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpringSimulation {
    public static final int $stable = 8;
    private float finalPosition;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f2) {
        this.finalPosition = f2;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final void setFinalPosition(float f2) {
        this.finalPosition = f2;
    }

    public final void setStiffness(float f2) {
        if (getStiffness() <= 0.0f) {
            PreconditionsKt.throwIllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f2);
    }

    public final float getStiffness() {
        double d2 = this.naturalFreq;
        return (float) (d2 * d2);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final void setDampingRatio(float f2) {
        if (f2 < 0.0f) {
            PreconditionsKt.throwIllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f2;
    }

    public final float getAcceleration(float lastDisplacement, float lastVelocity) {
        float f2 = lastDisplacement - this.finalPosition;
        double d2 = this.naturalFreq;
        return (float) (((-(d2 * d2)) * ((double) f2)) - (((d2 * 2.0d) * ((double) this.dampingRatio)) * ((double) lastVelocity)));
    }

    /* JADX INFO: renamed from: updateValues-IJZedt4$animation_core, reason: not valid java name */
    public final long m233updateValuesIJZedt4$animation_core(float lastDisplacement, float lastVelocity, long timeElapsed) {
        double dExp;
        double dExp2;
        float f2 = lastDisplacement - this.finalPosition;
        double d2 = timeElapsed / 1000.0d;
        float f3 = this.dampingRatio;
        double d3 = ((double) f3) * ((double) f3);
        double d4 = this.naturalFreq;
        double d5 = ((double) (-f3)) * d4;
        if (f3 > 1.0f) {
            double dSqrt = d4 * Math.sqrt(d3 - ((double) 1));
            double d6 = d5 + dSqrt;
            double d7 = d5 - dSqrt;
            double d8 = f2;
            double d9 = ((d7 * d8) - ((double) lastVelocity)) / (d7 - d6);
            double d10 = d8 - d9;
            double d11 = d7 * d2;
            double d12 = d2 * d6;
            dExp2 = (Math.exp(d11) * d10) + (Math.exp(d12) * d9);
            dExp = (d10 * d7 * Math.exp(d11)) + (d9 * d6 * Math.exp(d12));
        } else if (f3 == 1.0f) {
            double d13 = f2;
            double d14 = ((double) lastVelocity) + (d4 * d13);
            double d15 = (-d4) * d2;
            double d16 = d13 + (d2 * d14);
            dExp2 = d16 * Math.exp(d15);
            dExp = (d16 * Math.exp(d15) * (-this.naturalFreq)) + (d14 * Math.exp(d15));
        } else {
            double d17 = 1;
            double dSqrt2 = d4 * Math.sqrt(d17 - d3);
            double d18 = f2;
            double d19 = (d17 / dSqrt2) * (((-d5) * d18) + ((double) lastVelocity));
            double d20 = dSqrt2 * d2;
            double d21 = d2 * d5;
            double dExp3 = Math.exp(d21) * ((Math.cos(d20) * d18) + (Math.sin(d20) * d19));
            dExp = (d5 * dExp3) + (Math.exp(d21) * (((-dSqrt2) * d18 * Math.sin(d20)) + (dSqrt2 * d19 * Math.cos(d20))));
            dExp2 = dExp3;
        }
        return Motion.m223constructorimpl((((long) Float.floatToRawIntBits((float) dExp)) & 4294967295L) | (Float.floatToRawIntBits((float) (dExp2 + ((double) this.finalPosition))) << 32));
    }
}
