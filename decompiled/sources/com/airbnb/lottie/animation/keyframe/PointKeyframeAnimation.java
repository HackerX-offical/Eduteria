package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF point;

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2) {
        return getValue((Keyframe<PointF>) keyframe, f2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    protected /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f2, float f3, float f4) {
        return getValue((Keyframe<PointF>) keyframe, f2, f3, f4);
    }

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.point = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f2) {
        return getValue(keyframe, f2, f2, f2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    protected PointF getValue(Keyframe<PointF> keyframe, float f2, float f3, float f4) {
        PointF pointF;
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = keyframe.startValue;
        PointF pointF3 = keyframe.endValue;
        if (this.valueCallback != null && (pointF = (PointF) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF2, pointF3, f2, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
            return pointF;
        }
        this.point.set(pointF2.x + (f3 * (pointF3.x - pointF2.x)), pointF2.y + (f4 * (pointF3.y - pointF2.y)));
        return this.point;
    }
}
