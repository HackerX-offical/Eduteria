package com.github.jorgecastilloprz.progressarc.animations;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes7.dex */
final class RotateArcAnimation implements ArcAnimation {
    private ValueAnimator rotateAnim;

    RotateArcAnimation(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.rotateAnim = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.rotateAnim.setDuration(2000L);
        this.rotateAnim.addUpdateListener(animatorUpdateListener);
        this.rotateAnim.setRepeatCount(-1);
        this.rotateAnim.setRepeatMode(1);
    }

    @Override // com.github.jorgecastilloprz.progressarc.animations.ArcAnimation
    public ValueAnimator getAnimator() {
        return this.rotateAnim;
    }
}
