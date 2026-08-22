package com.github.jorgecastilloprz.utils;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes7.dex */
public class AnimationUtils {
    public static final int SHOW_SCALE_ANIM_DELAY = 150;

    public static float getAnimatedFraction(ValueAnimator valueAnimator) {
        return valueAnimator.getInterpolator().getInterpolation(Math.min(valueAnimator.getCurrentPlayTime() / valueAnimator.getDuration(), 1.0f));
    }
}
