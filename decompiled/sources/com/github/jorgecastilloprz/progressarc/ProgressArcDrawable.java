package com.github.jorgecastilloprz.progressarc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import com.github.jorgecastilloprz.progressarc.animations.ArcAnimationFactory;
import com.github.jorgecastilloprz.utils.AnimationUtils;

/* JADX INFO: loaded from: classes7.dex */
final class ProgressArcDrawable extends Drawable implements Animatable {
    private ArcAnimationFactory animationFactory;
    private boolean animationPlaying;
    private final RectF arcBounds = new RectF();
    private int arcColor;
    private ValueAnimator completeAnim;
    private boolean completeAnimOnNextCycle;
    private float currentRotationAngle;
    private float currentRotationAngleOffset;
    private float currentSweepAngle;
    private ValueAnimator growAnim;
    private boolean growing;
    private ArcListener internalListener;
    private int maxSweepAngle;
    private int minSweepAngle;
    private Paint paint;
    private ValueAnimator rotateAnim;
    private ValueAnimator shrinkAnim;
    private float strokeWidth;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 4;
    }

    ProgressArcDrawable(float f2, int i, boolean z) {
        this.strokeWidth = f2;
        this.arcColor = i;
        initPaint(z);
        setupAnimations();
    }

    private void initPaint(boolean z) {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.paint.setStrokeCap(z ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        this.paint.setColor(this.arcColor);
    }

    private void setupAnimations() {
        this.animationFactory = new ArcAnimationFactory();
        this.minSweepAngle = 20;
        this.maxSweepAngle = 300;
        setupRotateAnimation();
        setupGrowAnimation();
        setupShrinkAnimation();
        setupCompleteAnimation();
    }

    private void setupRotateAnimation() {
        this.rotateAnim = this.animationFactory.buildAnimation(ArcAnimationFactory.Type.ROTATE, new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressArcDrawable.this.updateCurrentRotationAngle(AnimationUtils.getAnimatedFraction(valueAnimator) * 360.0f);
            }
        }, null);
    }

    private void setupGrowAnimation() {
        this.growAnim = this.animationFactory.buildAnimation(ArcAnimationFactory.Type.GROW, new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressArcDrawable.this.updateCurrentSweepAngle(ProgressArcDrawable.this.minSweepAngle + (AnimationUtils.getAnimatedFraction(valueAnimator) * (ProgressArcDrawable.this.maxSweepAngle - ProgressArcDrawable.this.minSweepAngle)));
            }
        }, new Animator.AnimatorListener() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.3
            boolean cancelled = false;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                this.cancelled = false;
                ProgressArcDrawable.this.growing = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.cancelled) {
                    return;
                }
                ProgressArcDrawable.this.setShrinking();
                ProgressArcDrawable.this.shrinkAnim.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.cancelled = true;
            }
        });
    }

    private void setupShrinkAnimation() {
        this.shrinkAnim = this.animationFactory.buildAnimation(ArcAnimationFactory.Type.SHRINK, new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = AnimationUtils.getAnimatedFraction(valueAnimator);
                ProgressArcDrawable.this.updateCurrentSweepAngle(r0.maxSweepAngle - (animatedFraction * (ProgressArcDrawable.this.maxSweepAngle - ProgressArcDrawable.this.minSweepAngle)));
            }
        }, new Animator.AnimatorListener() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.5
            boolean cancelled;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                this.cancelled = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.cancelled) {
                    return;
                }
                ProgressArcDrawable.this.setGrowing();
                if (ProgressArcDrawable.this.completeAnimOnNextCycle) {
                    ProgressArcDrawable.this.completeAnimOnNextCycle = false;
                    ProgressArcDrawable.this.completeAnim.start();
                } else {
                    ProgressArcDrawable.this.growAnim.start();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.cancelled = true;
            }
        });
    }

    private void setupCompleteAnimation() {
        this.completeAnim = this.animationFactory.buildAnimation(ArcAnimationFactory.Type.COMPLETE, new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ProgressArcDrawable.this.updateCurrentSweepAngle(ProgressArcDrawable.this.minSweepAngle + (AnimationUtils.getAnimatedFraction(valueAnimator) * 360.0f));
            }
        }, new Animator.AnimatorListener() { // from class: com.github.jorgecastilloprz.progressarc.ProgressArcDrawable.7
            boolean cancelled = false;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                this.cancelled = false;
                ProgressArcDrawable.this.growing = true;
                ProgressArcDrawable.this.rotateAnim.setInterpolator(new DecelerateInterpolator());
                ProgressArcDrawable.this.rotateAnim.setDuration(12000L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.cancelled) {
                    ProgressArcDrawable.this.stop();
                }
                ProgressArcDrawable.this.completeAnim.removeListener(this);
                ProgressArcDrawable.this.internalListener.onArcAnimationComplete();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.cancelled = true;
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f2 = this.currentRotationAngle - this.currentRotationAngleOffset;
        float f3 = this.currentSweepAngle;
        if (!this.growing) {
            f2 += 360.0f - f3;
        }
        canvas.drawArc(this.arcBounds, f2, f3, false, this.paint);
    }

    public void reset() {
        stop();
        resetProperties();
        setupAnimations();
        start();
    }

    private void resetProperties() {
        this.currentSweepAngle = 0.0f;
        this.currentRotationAngle = 0.0f;
        this.currentRotationAngleOffset = 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.arcBounds.left = rect.left;
        this.arcBounds.right = rect.right;
        this.arcBounds.top = rect.top;
        this.arcBounds.bottom = rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGrowing() {
        this.growing = true;
        this.currentRotationAngleOffset += this.minSweepAngle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShrinking() {
        this.growing = false;
        this.currentRotationAngleOffset += 360 - this.maxSweepAngle;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.animationPlaying = true;
        resetProperties();
        this.rotateAnim.start();
        this.growAnim.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.animationPlaying = false;
        stopAnimators();
        invalidateSelf();
    }

    private void stopAnimators() {
        this.rotateAnim.cancel();
        this.growAnim.cancel();
        this.shrinkAnim.cancel();
        this.completeAnim.cancel();
    }

    void requestCompleteAnimation(ArcListener arcListener) {
        if (!isRunning() || this.completeAnim.isRunning()) {
            return;
        }
        this.internalListener = arcListener;
        startCompleteAnimationOnNextCycle();
    }

    private void startCompleteAnimationOnNextCycle() {
        this.completeAnimOnNextCycle = true;
    }

    void updateCurrentRotationAngle(float f2) {
        this.currentRotationAngle = f2;
        invalidateSelf();
    }

    void updateCurrentSweepAngle(float f2) {
        this.currentSweepAngle = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.animationPlaying;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
