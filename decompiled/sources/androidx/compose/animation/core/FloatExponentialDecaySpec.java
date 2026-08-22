package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FloatDecayAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/core/FloatExponentialDecaySpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "frictionMultiplier", "", "absVelocityThreshold", "<init>", "(FF)V", "getAbsVelocityThreshold", "()F", "friction", "getValueFromNanos", "playTimeNanos", "", "initialValue", "initialVelocity", "getVelocityFromNanos", "getDurationNanos", "getTargetValue", "animation-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatExponentialDecaySpec implements FloatDecayAnimationSpec {
    public static final int $stable = 0;
    private final float absVelocityThreshold;
    private final float friction;

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatExponentialDecaySpec() {
        float f2 = 0.0f;
        this(f2, f2, 3, null);
    }

    public FloatExponentialDecaySpec(float f2, float f3) {
        this.absVelocityThreshold = Math.max(1.0E-7f, Math.abs(f3));
        this.friction = Math.max(1.0E-4f, f2) * (-4.2f);
    }

    public /* synthetic */ FloatExponentialDecaySpec(float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f2, (i & 2) != 0 ? 0.1f : f3);
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getValueFromNanos(long playTimeNanos, float initialValue, float initialVelocity) {
        float f2 = this.friction;
        return (initialValue - (initialVelocity / f2)) + ((initialVelocity / f2) * ((float) Math.exp((f2 * (playTimeNanos / 1000000)) / 1000.0f)));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getVelocityFromNanos(long playTimeNanos, float initialValue, float initialVelocity) {
        return initialVelocity * ((float) Math.exp(((playTimeNanos / 1000000) / 1000.0f) * this.friction));
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public long getDurationNanos(float initialValue, float initialVelocity) {
        return ((long) ((((float) Math.log(getAbsVelocityThreshold() / Math.abs(initialVelocity))) * 1000.0f) / this.friction)) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
    public float getTargetValue(float initialValue, float initialVelocity) {
        if (Math.abs(initialVelocity) <= getAbsVelocityThreshold()) {
            return initialValue;
        }
        double dLog = Math.log(Math.abs(getAbsVelocityThreshold() / initialVelocity));
        float f2 = this.friction;
        return (initialValue - (initialVelocity / f2)) + ((initialVelocity / f2) * ((float) Math.exp((((double) f2) * ((dLog / ((double) f2)) * ((double) 1000))) / ((double) 1000.0f))));
    }
}
