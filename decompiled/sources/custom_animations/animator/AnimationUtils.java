package custom_animations.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import custom_ui_components.loader.PWELoaderAnimation;

/* JADX INFO: loaded from: classes9.dex */
public class AnimationUtils {
    public static void start(Animator animator) {
        if (animator == null || animator.isStarted()) {
            return;
        }
        animator.start();
    }

    public static void stop(Animator animator) {
        if (animator == null || animator.isRunning()) {
            return;
        }
        animator.end();
    }

    public static void start(PWELoaderAnimation... pWELoaderAnimationArr) {
        for (PWELoaderAnimation pWELoaderAnimation : pWELoaderAnimationArr) {
            pWELoaderAnimation.start();
        }
    }

    public static void stop(PWELoaderAnimation... pWELoaderAnimationArr) {
        for (PWELoaderAnimation pWELoaderAnimation : pWELoaderAnimationArr) {
            pWELoaderAnimation.stop();
        }
    }

    public static boolean isRunning(PWELoaderAnimation... pWELoaderAnimationArr) {
        for (PWELoaderAnimation pWELoaderAnimation : pWELoaderAnimationArr) {
            if (pWELoaderAnimation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRunning(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public static boolean isStarted(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isStarted();
    }
}
