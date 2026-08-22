package com.github.jorgecastilloprz.completefab;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.github.jorgecastilloprz.library.R;

/* JADX INFO: loaded from: classes7.dex */
public class CompleteFABView extends FrameLayout {
    private final int RESET_DELAY;
    private int arcColor;
    private Drawable iconDrawable;
    private CompleteFABListener listener;
    private boolean viewsAdded;

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public CompleteFABView(Context context, Drawable drawable, int i) {
        super(context);
        this.RESET_DELAY = 3000;
        this.iconDrawable = drawable;
        this.arcColor = i;
        init();
    }

    public void attachListener(CompleteFABListener completeFABListener) {
        this.listener = completeFABListener;
    }

    private void init() {
        inflate(getContext(), R.layout.complete_fab, this);
    }

    private void tintCompleteFabWithArcColor() {
        Drawable drawable = getResources().getDrawable(R.drawable.oval_complete);
        drawable.setColorFilter(this.arcColor, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.completeFabRoot).setBackgroundDrawable(drawable);
    }

    private void setIcon() {
        ImageView imageView = (ImageView) findViewById(R.id.completeFabIcon);
        Drawable drawable = this.iconDrawable;
        if (drawable == null) {
            drawable = getResources().getDrawable(R.drawable.ic_done);
        }
        imageView.setImageDrawable(drawable);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.viewsAdded) {
            return;
        }
        setupContentSize();
        tintCompleteFabWithArcColor();
        setIcon();
        this.viewsAdded = true;
    }

    private void setupContentSize() {
        int measuredWidth = (getChildAt(0).getMeasuredWidth() - ((int) getResources().getDimension(R.dimen.fab_content_size))) / 2;
        getChildAt(0).setPadding(measuredWidth, measuredWidth, measuredWidth, measuredWidth);
    }

    public void animate(AnimatorSet animatorSet) {
        animate(animatorSet, false);
    }

    private void animate(AnimatorSet animatorSet, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getChildAt(0), "alpha", z ? 0.0f : 1.0f);
        objectAnimatorOfFloat.setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
        View viewFindViewById = findViewById(R.id.completeFabIcon);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewFindViewById, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewFindViewById, "scaleY", 0.0f, 1.0f);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        objectAnimatorOfFloat2.setDuration(250L).setInterpolator(linearInterpolator);
        objectAnimatorOfFloat3.setDuration(250L).setInterpolator(linearInterpolator);
        AnimatorSet animatorSet2 = new AnimatorSet();
        if (z) {
            animatorSet2.playTogether(objectAnimatorOfFloat);
        } else {
            animatorSet2.playTogether(objectAnimatorOfFloat, animatorSet, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        }
        animatorSet2.addListener(z ? getInverseAnimatorListener() : getAnimatorListener());
        if (z) {
            animatorSet2.setStartDelay(3000L);
        }
        animatorSet2.start();
    }

    private Animator.AnimatorListener getAnimatorListener() {
        return new Animator.AnimatorListener() { // from class: com.github.jorgecastilloprz.completefab.CompleteFABView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CompleteFABView.this.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CompleteFABView.this.listener != null) {
                    CompleteFABView.this.listener.onCompleteFABAnimationEnd();
                }
            }
        };
    }

    private Animator.AnimatorListener getInverseAnimatorListener() {
        return new Animator.AnimatorListener() { // from class: com.github.jorgecastilloprz.completefab.CompleteFABView.2
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
                CompleteFABView.this.setVisibility(8);
            }
        };
    }

    public void reset() {
        animate(null, true);
    }
}
