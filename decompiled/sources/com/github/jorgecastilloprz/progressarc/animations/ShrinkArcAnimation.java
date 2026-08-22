package com.github.jorgecastilloprz.progressarc.animations;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes7.dex */
public class ShrinkArcAnimation implements ArcAnimation {
    private ValueAnimator shrinkAnim;

    ShrinkArcAnimation(ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(300.0f, 20.0f);
        this.shrinkAnim = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        this.shrinkAnim.setDuration(1000L);
        this.shrinkAnim.addUpdateListener(animatorUpdateListener);
        this.shrinkAnim.addListener(animatorListener);
    }

    @Override // com.github.jorgecastilloprz.progressarc.animations.ArcAnimation
    public ValueAnimator getAnimator() {
        return this.shrinkAnim;
    }
}
