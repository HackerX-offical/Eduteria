package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FloatAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/FloatSpringSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "<init>", "(FFF)V", "getDampingRatio", "()F", "getStiffness", "spring", "Landroidx/compose/animation/core/SpringSimulation;", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getEndVelocity", "getDurationNanos", "animation-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatSpringSpec implements FloatAnimationSpec {
    public static final int $stable = 8;
    private final float dampingRatio;
    private final SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;

    public FloatSpringSpec() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getEndVelocity(float initialValue, float targetValue, float initialVelocity) {
        return 0.0f;
    }

    public FloatSpringSpec(float f2, float f3, float f4) {
        this.dampingRatio = f2;
        this.stiffness = f3;
        this.visibilityThreshold = f4;
        SpringSimulation springSimulation = new SpringSimulation(1.0f);
        springSimulation.setDampingRatio(f2);
        springSimulation.setStiffness(f3);
        this.spring = springSimulation;
    }

    public /* synthetic */ FloatSpringSpec(float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f2, (i & 2) != 0 ? 1500.0f : f3, (i & 4) != 0 ? 0.01f : f4);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        this.spring.setFinalPosition(targetValue);
        return Float.intBitsToFloat((int) (this.spring.m233updateValuesIJZedt4$animation_core(initialValue, initialVelocity, playTimeNanos / 1000000) >> 32));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long playTimeNanos, float initialValue, float targetValue, float initialVelocity) {
        this.spring.setFinalPosition(targetValue);
        return Float.intBitsToFloat((int) (this.spring.m233updateValuesIJZedt4$animation_core(initialValue, initialVelocity, playTimeNanos / 1000000) & 4294967295L));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float initialValue, float targetValue, float initialVelocity) {
        float stiffness = this.spring.getStiffness();
        float dampingRatio = this.spring.getDampingRatio();
        float f2 = initialValue - targetValue;
        float f3 = this.visibilityThreshold;
        return SpringEstimationKt.estimateAnimationDurationMillis(stiffness, dampingRatio, initialVelocity / f3, f2 / f3, 1.0f) * 1000000;
    }
}
