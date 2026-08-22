package com.appnew.android.Utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes6.dex */
public class ViewAnimation {

    public interface AnimListener {
        void onFinish();
    }

    public static void expand(final View v, final AnimListener animListener) {
        Animation animationExpandAction = expandAction(v);
        animationExpandAction.setAnimationListener(new Animation.AnimationListener() { // from class: com.appnew.android.Utils.ViewAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                animListener.onFinish();
            }
        });
        v.startAnimation(animationExpandAction);
    }

    public static void expand(final View v) {
        v.startAnimation(expandAction(v));
    }

    private static Animation expandAction(final View v) {
        v.measure(-1, -2);
        final int measuredHeight = v.getMeasuredHeight();
        v.getLayoutParams().height = 0;
        v.setVisibility(0);
        Animation animation = new Animation() { // from class: com.appnew.android.Utils.ViewAnimation.2
            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1.0f ? -2 : (int) (measuredHeight * interpolatedTime);
                v.requestLayout();
            }
        };
        animation.setDuration((int) (measuredHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(animation);
        return animation;
    }

    public static void collapse(final View v) {
        final int measuredHeight = v.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.appnew.android.Utils.ViewAnimation.3
            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1.0f) {
                    v.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                int i = measuredHeight;
                layoutParams.height = i - ((int) (i * interpolatedTime));
                v.requestLayout();
            }
        };
        animation.setDuration((int) (measuredHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(animation);
    }

    public static void flyInDown(final View v, final AnimListener animListener) {
        v.setVisibility(0);
        v.setAlpha(0.0f);
        v.setTranslationY(0.0f);
        v.setTranslationY(-v.getHeight());
        v.animate().setDuration(200L).translationY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).alpha(1.0f).start();
    }

    public static void flyOutDown(final View v, final AnimListener animListener) {
        v.setVisibility(0);
        v.setAlpha(1.0f);
        v.setTranslationY(0.0f);
        v.animate().setDuration(200L).translationY(v.getHeight()).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).alpha(0.0f).start();
    }

    public static void fadeIn(final View v) {
        fadeIn(v, null);
    }

    public static void fadeIn(final View v, final AnimListener animListener) {
        v.setVisibility(8);
        v.setAlpha(0.0f);
        v.animate().setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                v.setVisibility(0);
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).alpha(1.0f);
    }

    public static void fadeOut(final View v) {
        fadeOut(v, null);
    }

    public static void fadeOut(final View v, final AnimListener animListener) {
        v.setAlpha(1.0f);
        v.animate().setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).alpha(0.0f);
    }

    public static void showIn(final View v) {
        v.setVisibility(0);
        v.setAlpha(0.0f);
        v.setTranslationY(v.getHeight());
        v.animate().setDuration(200L).translationY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        }).alpha(1.0f).start();
    }

    public static void initShowOut(final View v) {
        v.setVisibility(8);
        v.setTranslationY(v.getHeight());
        v.setAlpha(0.0f);
    }

    public static void showOut(final View v) {
        v.setVisibility(0);
        v.setAlpha(1.0f);
        v.setTranslationY(0.0f);
        v.animate().setDuration(200L).translationY(v.getHeight()).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                v.setVisibility(8);
                super.onAnimationEnd(animation);
            }
        }).alpha(0.0f).start();
    }

    public static boolean rotateFab(final View v, boolean rotate) {
        v.animate().setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        }).rotation(rotate ? 135.0f : 0.0f);
        return rotate;
    }

    public static void fadeOutIn(View view) {
        view.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 0.5f, 1.0f);
        ObjectAnimator.ofFloat(view, "alpha", 0.0f).start();
        objectAnimatorOfFloat.setDuration(500L);
        animatorSet.play(objectAnimatorOfFloat);
        animatorSet.start();
    }

    public static void showScale(final View v) {
        showScale(v, null);
    }

    public static void showScale(final View v, final AnimListener animListener) {
        v.animate().scaleY(1.0f).scaleX(1.0f).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).start();
    }

    public static void hideScale(final View v) {
        fadeOut(v, null);
    }

    public static void hideScale(final View v, final AnimListener animListener) {
        v.animate().scaleY(0.0f).scaleX(0.0f).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.appnew.android.Utils.ViewAnimation.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimListener animListener2 = animListener;
                if (animListener2 != null) {
                    animListener2.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).start();
    }

    public static void hideFab(View fab) {
        fab.animate().translationY(fab.getHeight() * 2).setDuration(300L).start();
    }

    public static void showFab(View fab) {
        fab.animate().translationY(0.0f).setDuration(300L).start();
    }
}
