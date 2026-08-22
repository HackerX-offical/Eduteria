package com.razorpay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes9.dex */
class CircularProgressView extends View {
    private static final float INDETERMINANT_MIN_SWEEP = 15.0f;
    private float actualProgress;
    private int animDuration;
    private int animSteps;
    private int animSwoopDuration;
    private int animSyncDuration;
    private boolean autostartAnimation;
    private RectF bounds;
    private int color;
    private Context context;
    private float currentProgress;
    private AnimatorSet indeterminateAnimator;
    private float indeterminateRotateOffset;
    private float indeterminateSweep;
    private float initialStartAngle;
    private boolean isIndeterminate;
    private float maxProgress;
    private Paint paint;
    private ValueAnimator progressAnimator;
    private int size;
    private float startAngle;
    private ValueAnimator startAngleRotate;
    private int thickness;

    public CircularProgressView(Context context) {
        super(context);
        this.size = 0;
        init(null, 0, context);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.size = 0;
        init(attributeSet, 0, context);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.size = 0;
        init(attributeSet, i, context);
    }

    protected void init(AttributeSet attributeSet, int i, Context context) {
        initAttributes(attributeSet, i, context);
        this.paint = new Paint(1);
        updatePaint();
        this.bounds = new RectF();
    }

    private void initAttributes(AttributeSet attributeSet, int i, Context context) {
        getResources();
        this.currentProgress = 0.0f;
        this.maxProgress = 100.0f;
        this.thickness = convertDPtoInt(context, 3);
        this.isIndeterminate = true;
        this.autostartAnimation = true;
        this.initialStartAngle = -90.0f;
        this.startAngle = -90.0f;
        this.color = Color.parseColor("#4aa3df");
        this.animDuration = 4000;
        this.animSwoopDuration = 5000;
        this.animSyncDuration = 500;
        this.animSteps = 3;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int measuredWidth = getMeasuredWidth() - paddingLeft;
        int measuredHeight = getMeasuredHeight() - paddingTop;
        if (measuredWidth >= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        this.size = measuredWidth;
        setMeasuredDimension(paddingLeft + measuredWidth, measuredWidth + paddingTop);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i >= i2) {
            i = i2;
        }
        this.size = i;
        updateBounds();
    }

    private void updateBounds() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        RectF rectF = this.bounds;
        int i = this.thickness;
        int i2 = this.size;
        rectF.set(paddingLeft + i, paddingTop + i, (i2 - paddingLeft) - i, (i2 - paddingTop) - i);
    }

    private void updatePaint() {
        this.paint.setColor(this.color);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.thickness);
        this.paint.setStrokeCap(Paint.Cap.BUTT);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = ((isInEditMode() ? this.currentProgress : this.actualProgress) / this.maxProgress) * 360.0f;
        if (!this.isIndeterminate) {
            canvas.drawArc(this.bounds, this.startAngle, f2, false, this.paint);
        } else {
            canvas.drawArc(this.bounds, this.startAngle + this.indeterminateRotateOffset, this.indeterminateSweep, false, this.paint);
        }
    }

    public boolean isIndeterminate() {
        return this.isIndeterminate;
    }

    public void setIndeterminate(boolean z) {
        boolean z2 = this.isIndeterminate == z;
        this.isIndeterminate = z;
        if (z2) {
            resetAnimation();
        }
    }

    public int getThickness() {
        return this.thickness;
    }

    public void setThickness(int i) {
        this.thickness = i;
        updatePaint();
        updateBounds();
        invalidate();
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
        updatePaint();
        invalidate();
    }

    public float getMaxProgress() {
        return this.maxProgress;
    }

    public void setMaxProgress(float f2) {
        this.maxProgress = f2;
        invalidate();
    }

    public float getProgress() {
        return this.currentProgress;
    }

    public void setProgress(float f2) {
        this.currentProgress = f2;
        if (!this.isIndeterminate) {
            ValueAnimator valueAnimator = this.progressAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.progressAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.actualProgress, f2);
            this.progressAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(this.animSyncDuration);
            this.progressAnimator.setInterpolator(new LinearInterpolator());
            this.progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.razorpay.CircularProgressView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CircularProgressView.this.actualProgress = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.progressAnimator.start();
        }
        invalidate();
    }

    public void startAnimation() {
        resetAnimation();
    }

    public void resetAnimation() {
        ValueAnimator valueAnimator = this.startAngleRotate;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.startAngleRotate.cancel();
        }
        ValueAnimator valueAnimator2 = this.progressAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.progressAnimator.cancel();
        }
        AnimatorSet animatorSet = this.indeterminateAnimator;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.indeterminateAnimator.cancel();
        }
        int i = 0;
        if (!this.isIndeterminate) {
            float f2 = this.initialStartAngle;
            this.startAngle = f2;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, 360.0f + f2);
            this.startAngleRotate = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(this.animSwoopDuration);
            this.startAngleRotate.setInterpolator(new DecelerateInterpolator(2.0f));
            this.startAngleRotate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.razorpay.CircularProgressView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    CircularProgressView.this.startAngle = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.startAngleRotate.start();
            this.actualProgress = 0.0f;
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, this.currentProgress);
            this.progressAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(this.animSyncDuration);
            this.progressAnimator.setInterpolator(new LinearInterpolator());
            this.progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.razorpay.CircularProgressView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    CircularProgressView.this.actualProgress = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.progressAnimator.start();
            return;
        }
        this.indeterminateSweep = INDETERMINANT_MIN_SWEEP;
        this.indeterminateAnimator = new AnimatorSet();
        AnimatorSet animatorSet2 = null;
        while (i < this.animSteps) {
            AnimatorSet animatorSetCreateIndeterminateAnimator = createIndeterminateAnimator(i);
            AnimatorSet.Builder builderPlay = this.indeterminateAnimator.play(animatorSetCreateIndeterminateAnimator);
            if (animatorSet2 != null) {
                builderPlay.after(animatorSet2);
            }
            i++;
            animatorSet2 = animatorSetCreateIndeterminateAnimator;
        }
        this.indeterminateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.razorpay.CircularProgressView.4
            boolean wasCancelled = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.wasCancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.wasCancelled) {
                    return;
                }
                CircularProgressView.this.resetAnimation();
            }
        });
        this.indeterminateAnimator.start();
    }

    public void stopAnimation() {
        ValueAnimator valueAnimator = this.startAngleRotate;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.startAngleRotate = null;
        }
        ValueAnimator valueAnimator2 = this.progressAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.progressAnimator = null;
        }
        AnimatorSet animatorSet = this.indeterminateAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.indeterminateAnimator = null;
        }
    }

    private AnimatorSet createIndeterminateAnimator(float f2) {
        final float f3 = (((r0 - 1) * 360.0f) / this.animSteps) + INDETERMINANT_MIN_SWEEP;
        final float f4 = ((f3 - INDETERMINANT_MIN_SWEEP) * f2) - 90.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(INDETERMINANT_MIN_SWEEP, f3);
        valueAnimatorOfFloat.setDuration((this.animDuration / this.animSteps) / 2);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.0f));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.razorpay.CircularProgressView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.indeterminateSweep = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressView.this.invalidate();
            }
        });
        int i = this.animSteps;
        float f5 = (0.5f + f2) * 720.0f;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat((f2 * 720.0f) / i, f5 / i);
        valueAnimatorOfFloat2.setDuration((this.animDuration / this.animSteps) / 2);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.razorpay.CircularProgressView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.indeterminateRotateOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(f4, (f4 + f3) - INDETERMINANT_MIN_SWEEP);
        valueAnimatorOfFloat3.setDuration((this.animDuration / this.animSteps) / 2);
        valueAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator(1.0f));
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.razorpay.CircularProgressView.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.startAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressView circularProgressView = CircularProgressView.this;
                circularProgressView.indeterminateSweep = (f3 - circularProgressView.startAngle) + f4;
                CircularProgressView.this.invalidate();
            }
        });
        int i2 = this.animSteps;
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(f5 / i2, ((f2 + 1.0f) * 720.0f) / i2);
        valueAnimatorOfFloat4.setDuration((this.animDuration / this.animSteps) / 2);
        valueAnimatorOfFloat4.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.razorpay.CircularProgressView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.indeterminateRotateOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
        animatorSet.play(valueAnimatorOfFloat3).with(valueAnimatorOfFloat4).after(valueAnimatorOfFloat2);
        return animatorSet;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autostartAnimation) {
            startAnimation();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if (i != visibility) {
            if (i == 0) {
                resetAnimation();
            } else if (i == 8 || i == 4) {
                stopAnimation();
            }
        }
    }

    private int convertDPtoInt(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }
}
