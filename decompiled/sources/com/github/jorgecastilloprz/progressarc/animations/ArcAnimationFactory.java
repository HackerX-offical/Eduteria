package com.github.jorgecastilloprz.progressarc.animations;

import android.animation.Animator;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes7.dex */
public class ArcAnimationFactory {
    public static final int COMPLETE_ANIM_DURATION = 2000;
    public static final int COMPLETE_ROTATE_DURATION = 12000;
    public static final int MAXIMUM_SWEEP_ANGLE = 300;
    public static final int MINIMUM_SWEEP_ANGLE = 20;
    public static final int ROTATE_ANIMATOR_DURATION = 2000;
    public static final int SWEEP_ANIM_DURATION = 1000;

    public enum Type {
        ROTATE,
        GROW,
        SHRINK,
        COMPLETE
    }

    /* JADX INFO: renamed from: com.github.jorgecastilloprz.progressarc.animations.ArcAnimationFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$jorgecastilloprz$progressarc$animations$ArcAnimationFactory$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$github$jorgecastilloprz$progressarc$animations$ArcAnimationFactory$Type = iArr;
            try {
                iArr[Type.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$jorgecastilloprz$progressarc$animations$ArcAnimationFactory$Type[Type.GROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$jorgecastilloprz$progressarc$animations$ArcAnimationFactory$Type[Type.SHRINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ValueAnimator buildAnimation(Type type, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ArcAnimation rotateArcAnimation;
        int i = AnonymousClass1.$SwitchMap$com$github$jorgecastilloprz$progressarc$animations$ArcAnimationFactory$Type[type.ordinal()];
        if (i == 1) {
            rotateArcAnimation = new RotateArcAnimation(animatorUpdateListener);
        } else if (i == 2) {
            rotateArcAnimation = new GrowArcAnimation(animatorUpdateListener, animatorListener);
        } else if (i == 3) {
            rotateArcAnimation = new ShrinkArcAnimation(animatorUpdateListener, animatorListener);
        } else {
            rotateArcAnimation = new CompleteArcAnimation(animatorUpdateListener, animatorListener);
        }
        return rotateArcAnimation.getAnimator();
    }
}
