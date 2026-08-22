package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\b\b\u0000\u0010\f*\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\f0\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/gestures/DelegatingAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/foundation/gestures/AnimationData;", "zoomAnimationSpec", "", "offsetAnimationSpec", "Landroidx/compose/ui/geometry/Offset;", "rotationAnimationSpec", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DelegatingAnimationSpec implements AnimationSpec<AnimationData> {
    private final AnimationSpec<Offset> offsetAnimationSpec;
    private final AnimationSpec<Float> rotationAnimationSpec;
    private final AnimationSpec<Float> zoomAnimationSpec;

    public DelegatingAnimationSpec(AnimationSpec<Float> animationSpec, AnimationSpec<Offset> animationSpec2, AnimationSpec<Float> animationSpec3) {
        this.zoomAnimationSpec = animationSpec;
        this.offsetAnimationSpec = animationSpec2;
        this.rotationAnimationSpec = animationSpec3;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedAnimationSpec<V> vectorize(final TwoWayConverter<AnimationData, V> converter) {
        final VectorizedAnimationSpec<V> vectorizedAnimationSpecVectorize = this.zoomAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
        final VectorizedAnimationSpec<V> vectorizedAnimationSpecVectorize2 = this.offsetAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(Offset.INSTANCE));
        final VectorizedAnimationSpec<V> vectorizedAnimationSpecVectorize3 = this.rotationAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
        return new VectorizedFiniteAnimationSpec<V>() { // from class: androidx.compose.foundation.gestures.DelegatingAnimationSpec.vectorize.1
            /* JADX WARN: Incorrect types in method signature: (TV;TV;TV;)J */
            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public long getDurationNanos(AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
                AnimationData animationDataInvoke = converter.getConvertFromVector().invoke(initialValue);
                AnimationData animationDataInvoke2 = converter.getConvertFromVector().invoke(targetValue);
                AnimationData animationDataInvoke3 = converter.getConvertFromVector().invoke(initialVelocity);
                return Math.max(vectorizedAnimationSpecVectorize.getDurationNanos(zoomVector(animationDataInvoke), zoomVector(animationDataInvoke2), zoomVector(animationDataInvoke3)), Math.max(vectorizedAnimationSpecVectorize2.getDurationNanos(offsetVector(animationDataInvoke), offsetVector(animationDataInvoke2), offsetVector(animationDataInvoke3)), vectorizedAnimationSpecVectorize3.getDurationNanos(degreesVector(animationDataInvoke), degreesVector(animationDataInvoke2), degreesVector(animationDataInvoke3))));
            }

            /* JADX WARN: Incorrect return type in method signature: (JTV;TV;TV;)TV; */
            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public AnimationVector getVelocityFromNanos(long playTimeNanos, AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
                AnimationData animationDataInvoke = converter.getConvertFromVector().invoke(initialValue);
                AnimationData animationDataInvoke2 = converter.getConvertFromVector().invoke(targetValue);
                AnimationData animationDataInvoke3 = converter.getConvertFromVector().invoke(initialVelocity);
                return packToAnimationVector((AnimationVector1D) vectorizedAnimationSpecVectorize.getVelocityFromNanos(playTimeNanos, zoomVector(animationDataInvoke), zoomVector(animationDataInvoke2), zoomVector(animationDataInvoke3)), (AnimationVector2D) vectorizedAnimationSpecVectorize2.getVelocityFromNanos(playTimeNanos, offsetVector(animationDataInvoke), offsetVector(animationDataInvoke2), offsetVector(animationDataInvoke3)), (AnimationVector1D) vectorizedAnimationSpecVectorize3.getVelocityFromNanos(playTimeNanos, degreesVector(animationDataInvoke), degreesVector(animationDataInvoke2), degreesVector(animationDataInvoke3)));
            }

            /* JADX WARN: Incorrect return type in method signature: (JTV;TV;TV;)TV; */
            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public AnimationVector getValueFromNanos(long playTimeNanos, AnimationVector initialValue, AnimationVector targetValue, AnimationVector initialVelocity) {
                AnimationData animationDataInvoke = converter.getConvertFromVector().invoke(initialValue);
                AnimationData animationDataInvoke2 = converter.getConvertFromVector().invoke(targetValue);
                AnimationData animationDataInvoke3 = converter.getConvertFromVector().invoke(initialVelocity);
                return packToAnimationVector((AnimationVector1D) vectorizedAnimationSpecVectorize.getValueFromNanos(playTimeNanos, zoomVector(animationDataInvoke), zoomVector(animationDataInvoke2), zoomVector(animationDataInvoke3)), (AnimationVector2D) vectorizedAnimationSpecVectorize2.getValueFromNanos(playTimeNanos, offsetVector(animationDataInvoke), offsetVector(animationDataInvoke2), offsetVector(animationDataInvoke3)), (AnimationVector1D) vectorizedAnimationSpecVectorize3.getValueFromNanos(playTimeNanos, degreesVector(animationDataInvoke), degreesVector(animationDataInvoke2), degreesVector(animationDataInvoke3)));
            }

            private final AnimationVector1D zoomVector(AnimationData animationData) {
                return (AnimationVector1D) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE).getConvertToVector().invoke(Float.valueOf(animationData.getZoom()));
            }

            private final AnimationVector2D offsetVector(AnimationData animationData) {
                Function1<Offset, V> convertToVector = VectorConvertersKt.getVectorConverter(Offset.INSTANCE).getConvertToVector();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (animationData.m521getOffsetF1C5BW0() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (animationData.m521getOffsetF1C5BW0() & 4294967295L));
                return (AnimationVector2D) convertToVector.invoke(Offset.m5712boximpl(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L))));
            }

            private final AnimationVector1D degreesVector(AnimationData animationData) {
                return (AnimationVector1D) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE).getConvertToVector().invoke(Float.valueOf(animationData.getDegrees()));
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/animation/core/AnimationVector1D;Landroidx/compose/animation/core/AnimationVector2D;Landroidx/compose/animation/core/AnimationVector1D;)TV; */
            private final AnimationVector packToAnimationVector(AnimationVector1D zoom, AnimationVector2D offset, AnimationVector1D rotation) {
                Function1<AnimationData, V> convertToVector = converter.getConvertToVector();
                float value = zoom.getValue();
                float v1 = offset.getV1();
                return (AnimationVector) convertToVector.invoke(new AnimationData(value, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(offset.getV2())) & 4294967295L) | (Float.floatToRawIntBits(v1) << 32)), rotation.getValue(), null));
            }
        };
    }
}
