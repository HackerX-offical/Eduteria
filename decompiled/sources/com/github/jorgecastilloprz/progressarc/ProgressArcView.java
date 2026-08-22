package com.github.jorgecastilloprz.progressarc;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes7.dex */
public final class ProgressArcView extends ProgressBar {
    private int arcColor;
    private int arcWidth;
    private ArcListener internalListener;
    private boolean roundedStroke;

    public ProgressArcView(Context context, int i, int i2, boolean z) {
        super(context);
        this.arcColor = i;
        this.arcWidth = i2;
        this.roundedStroke = z;
        init(i, i2, z);
    }

    public void init(int i, int i2, boolean z) {
        setupInitialAlpha();
        setIndeterminateDrawable(new ProgressArcDrawable(i2, i, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupInitialAlpha() {
        setAlpha(0.0f);
    }

    public void setInternalListener(ArcListener arcListener) {
        this.internalListener = arcListener;
    }

    public void show() {
        postDelayed(new Runnable() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcView.1
            @Override // java.lang.Runnable
            public void run() {
                ProgressArcView.this.setAlpha(1.0f);
                ProgressArcView.this.getDrawable().reset();
            }
        }, 150L);
    }

    public void stop() {
        getDrawable().stop();
        ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f).setDuration(100L).start();
    }

    public void reset() {
        getDrawable().reset();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleX", 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(0L).setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.start();
    }

    public void requestCompleteAnimation() {
        getDrawable().requestCompleteAnimation(this.internalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ProgressArcDrawable getDrawable() {
        return (ProgressArcDrawable) getIndeterminateDrawable();
    }

    public AnimatorSet getScaleDownAnimator() {
        float width = getWidth() / ((getWidth() + this.arcWidth) + 5);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleX", width);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "scaleY", width);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(150L).setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ProgressArcView.this.setupInitialAlpha();
            }
        });
        return animatorSet;
    }
}
