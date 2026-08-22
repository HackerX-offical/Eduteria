package com.github.jorgecastilloprz.progressarc.animations;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes7.dex */
public class GrowArcAnimation implements ArcAnimation {
    private ValueAnimator growAnim;

    GrowArcAnimation(ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(20.0f, 300.0f);
        this.growAnim = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        this.growAnim.setDuration(1000L);
        this.growAnim.addUpdateListener(animatorUpdateListener);
        this.growAnim.addListener(animatorListener);
    }

    @Override // com.github.jorgecastilloprz.progressarc.animations.ArcAnimation
    public ValueAnimator getAnimator() {
        return this.growAnim;
    }
}
