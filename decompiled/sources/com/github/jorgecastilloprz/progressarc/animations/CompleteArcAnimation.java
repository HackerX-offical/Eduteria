package com.github.jorgecastilloprz.progressarc.animations;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes7.dex */
public class CompleteArcAnimation implements ArcAnimation {
    private ValueAnimator completeAnim;

    CompleteArcAnimation(ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(300.0f, 20.0f);
        this.completeAnim = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        this.completeAnim.setDuration(2000L);
        this.completeAnim.addUpdateListener(animatorUpdateListener);
        this.completeAnim.addListener(animatorListener);
    }

    @Override // com.github.jorgecastilloprz.progressarc.animations.ArcAnimation
    public ValueAnimator getAnimator() {
        return this.completeAnim;
    }
}
