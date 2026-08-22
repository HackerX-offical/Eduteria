package com.appnew.android.Utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes6.dex */
public class CustomCheckBox extends View implements Checkable {
    private static final int COLOR_CHECKED = Color.parseColor("#FB4846");
    private static final int COLOR_FLOOR_UNCHECKED = Color.parseColor("#DFDFDF");
    private static final int COLOR_TICK = -1;
    private static final int COLOR_UNCHECKED = -1;
    private static final int DEF_ANIM_DURATION = 300;
    private static final int DEF_DRAW_SIZE = 100;
    private static final String KEY_INSTANCE_STATE = "InstanceState";
    private int mAnimDuration;
    private Point mCenterPoint;
    private boolean mChecked;
    private int mCheckedColor;
    private float mDrewDistance;
    private int mFloorColor;
    private Paint mFloorPaint;
    private float mFloorScale;
    private int mFloorUnCheckedColor;
    private float mLeftLineDistance;
    private OnCheckedChangeListener mListener;
    private Paint mPaint;
    private float mRightLineDistance;
    private float mScaleVal;
    private boolean mSmallTick;
    private int mStrokeWidth;
    private int mTickColor;
    private boolean mTickDrawing;
    private Paint mTickPaint;
    private Path mTickPath;
    private Point[] mTickPoints;
    private int mUnCheckedColor;
    private int mWidth;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(CustomCheckBox checkBox, boolean isChecked);
    }

    public CustomCheckBox(Context context) {
        this(context, null);
    }

    public CustomCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mScaleVal = 1.0f;
        this.mFloorScale = 1.0f;
        this.mTickColor = -1;
        init(attrs);
    }

    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mScaleVal = 1.0f;
        this.mFloorScale = 1.0f;
        this.mTickColor = -1;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        this.mFloorUnCheckedColor = this.mFloorColor;
        Paint paint = new Paint(1);
        this.mTickPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mTickPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mTickPaint.setColor(this.mTickColor);
        Paint paint2 = new Paint(1);
        this.mFloorPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mFloorPaint.setColor(this.mFloorColor);
        Paint paint3 = new Paint(1);
        this.mPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mCheckedColor);
        this.mTickPath = new Path();
        this.mCenterPoint = new Point();
        Point[] pointArr = new Point[3];
        this.mTickPoints = pointArr;
        pointArr[0] = new Point();
        this.mTickPoints[1] = new Point();
        this.mTickPoints[2] = new Point();
        setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.CustomCheckBox.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CustomCheckBox.this.toggle();
                CustomCheckBox.this.mTickDrawing = false;
                CustomCheckBox.this.mDrewDistance = 0.0f;
                if (CustomCheckBox.this.isChecked()) {
                    CustomCheckBox.this.startCheckedAnimation();
                } else {
                    CustomCheckBox.this.startUnCheckedAnimation();
                }
            }
        });
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putBoolean(KEY_INSTANCE_STATE, isChecked());
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            setChecked(bundle.getBoolean(KEY_INSTANCE_STATE));
            super.onRestoreInstanceState(bundle.getParcelable(KEY_INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        this.mChecked = checked;
        reset();
        invalidate();
        OnCheckedChangeListener onCheckedChangeListener = this.mListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, this.mChecked);
        }
    }

    public void setChecked(boolean checked, boolean animate) {
        if (animate) {
            this.mTickDrawing = false;
            this.mChecked = checked;
            this.mDrewDistance = 0.0f;
            if (checked) {
                startCheckedAnimation();
            } else {
                startUnCheckedAnimation();
            }
            OnCheckedChangeListener onCheckedChangeListener = this.mListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.mChecked);
                return;
            }
            return;
        }
        setChecked(checked);
    }

    public boolean isSmallTick() {
        return this.mSmallTick;
    }

    public void setSmallTick(boolean small) {
        this.mSmallTick = small;
    }

    private void reset() {
        this.mTickDrawing = true;
        this.mFloorScale = 1.0f;
        this.mScaleVal = isChecked() ? 0.0f : 1.0f;
        this.mFloorColor = isChecked() ? this.mCheckedColor : this.mFloorUnCheckedColor;
        this.mDrewDistance = isChecked() ? this.mLeftLineDistance + this.mRightLineDistance : 0.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(100, size) : 100;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(100, size2) : 100;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.mWidth = getMeasuredWidth();
        int i = this.mSmallTick ? 30 : 11;
        this.mStrokeWidth = getMeasuredWidth() / i;
        this.mCenterPoint.x = this.mWidth / 2;
        this.mCenterPoint.y = getMeasuredHeight() / 2;
        float f2 = i;
        float measuredWidth = getMeasuredWidth() / f2;
        float measuredHeight = getMeasuredHeight() / f2;
        if (this.mSmallTick) {
            this.mTickPoints[0].x = Math.round(11.0f * measuredWidth);
            this.mTickPoints[0].y = Math.round(15.0f * measuredHeight);
            this.mTickPoints[1].x = Math.round(14.0f * measuredWidth);
            this.mTickPoints[1].y = Math.round(18.0f * measuredHeight);
            this.mTickPoints[2].x = Math.round(measuredWidth * 20.0f);
            this.mTickPoints[2].y = Math.round(measuredHeight * 13.0f);
        } else {
            this.mTickPoints[0].x = Math.round(1.0f * measuredWidth);
            this.mTickPoints[0].y = Math.round(5.0f * measuredHeight);
            this.mTickPoints[1].x = Math.round(4.0f * measuredWidth);
            this.mTickPoints[1].y = Math.round(8.0f * measuredHeight);
            this.mTickPoints[2].x = Math.round(measuredWidth * 10.0f);
            this.mTickPoints[2].y = Math.round(measuredHeight * 3.0f);
        }
        this.mLeftLineDistance = (float) Math.sqrt(Math.pow(this.mTickPoints[1].x - this.mTickPoints[0].x, 2.0d) + Math.pow(this.mTickPoints[1].y - this.mTickPoints[0].y, 2.0d));
        this.mRightLineDistance = (float) Math.sqrt(Math.pow(this.mTickPoints[2].x - this.mTickPoints[1].x, 2.0d) + Math.pow(this.mTickPoints[2].y - this.mTickPoints[1].y, 2.0d));
        this.mTickPaint.setStrokeWidth(this.mStrokeWidth);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawBorder(canvas);
        drawCenter(canvas);
        drawTick(canvas);
    }

    private void drawCenter(Canvas canvas) {
        this.mPaint.setColor(this.mUnCheckedColor);
        canvas.drawCircle(this.mCenterPoint.x, this.mCenterPoint.y, (this.mCenterPoint.x - this.mStrokeWidth) * this.mScaleVal, this.mPaint);
    }

    private void drawBorder(Canvas canvas) {
        this.mFloorPaint.setColor(this.mFloorColor);
        canvas.drawCircle(this.mCenterPoint.x, this.mCenterPoint.y, this.mCenterPoint.x * this.mFloorScale, this.mFloorPaint);
    }

    private void drawTick(Canvas canvas) {
        if (this.mTickDrawing && isChecked()) {
            drawTickPath(canvas);
        }
    }

    private void drawTickPath(Canvas canvas) {
        this.mTickPath.reset();
        float f2 = this.mDrewDistance;
        if (f2 < this.mLeftLineDistance) {
            int i = this.mWidth;
            this.mDrewDistance = f2 + (((float) i) / 20.0f >= 3.0f ? i / 20.0f : 3.0f);
            float f3 = this.mTickPoints[0].x + (((this.mTickPoints[1].x - this.mTickPoints[0].x) * this.mDrewDistance) / this.mLeftLineDistance);
            float f4 = this.mTickPoints[0].y + (((this.mTickPoints[1].y - this.mTickPoints[0].y) * this.mDrewDistance) / this.mLeftLineDistance);
            this.mTickPath.moveTo(this.mTickPoints[0].x, this.mTickPoints[0].y);
            this.mTickPath.lineTo(f3, f4);
            canvas.drawPath(this.mTickPath, this.mTickPaint);
            float f5 = this.mDrewDistance;
            float f6 = this.mLeftLineDistance;
            if (f5 > f6) {
                this.mDrewDistance = f6;
            }
        } else {
            this.mTickPath.moveTo(this.mTickPoints[0].x, this.mTickPoints[0].y);
            this.mTickPath.lineTo(this.mTickPoints[1].x, this.mTickPoints[1].y);
            canvas.drawPath(this.mTickPath, this.mTickPaint);
            if (this.mDrewDistance < this.mLeftLineDistance + this.mRightLineDistance) {
                float f7 = this.mTickPoints[1].x + (((this.mTickPoints[2].x - this.mTickPoints[1].x) * (this.mDrewDistance - this.mLeftLineDistance)) / this.mRightLineDistance);
                float f8 = this.mTickPoints[1].y - (((this.mTickPoints[1].y - this.mTickPoints[2].y) * (this.mDrewDistance - this.mLeftLineDistance)) / this.mRightLineDistance);
                this.mTickPath.reset();
                this.mTickPath.moveTo(this.mTickPoints[1].x, this.mTickPoints[1].y);
                this.mTickPath.lineTo(f7, f8);
                canvas.drawPath(this.mTickPath, this.mTickPaint);
                this.mDrewDistance += this.mWidth / 20 >= 3 ? r8 / 20 : 3.0f;
            } else {
                this.mTickPath.reset();
                this.mTickPath.moveTo(this.mTickPoints[1].x, this.mTickPoints[1].y);
                this.mTickPath.lineTo(this.mTickPoints[2].x, this.mTickPoints[2].y);
                canvas.drawPath(this.mTickPath, this.mTickPaint);
            }
        }
        if (this.mDrewDistance < this.mLeftLineDistance + this.mRightLineDistance) {
            postDelayed(new Runnable() { // from class: com.appnew.android.Utils.CustomCheckBox.2
                @Override // java.lang.Runnable
                public void run() {
                    CustomCheckBox.this.postInvalidate();
                }
            }, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCheckedAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration((this.mAnimDuration / 3) * 2);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.appnew.android.Utils.CustomCheckBox.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                CustomCheckBox.this.mScaleVal = ((Float) animation.getAnimatedValue()).floatValue();
                CustomCheckBox customCheckBox = CustomCheckBox.this;
                customCheckBox.mFloorColor = CustomCheckBox.getGradientColor(customCheckBox.mUnCheckedColor, CustomCheckBox.this.mCheckedColor, 1.0f - CustomCheckBox.this.mScaleVal);
                CustomCheckBox.this.postInvalidate();
            }
        });
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        valueAnimatorOfFloat2.setDuration(this.mAnimDuration);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.appnew.android.Utils.CustomCheckBox.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                CustomCheckBox.this.mFloorScale = ((Float) animation.getAnimatedValue()).floatValue();
                CustomCheckBox.this.postInvalidate();
            }
        });
        valueAnimatorOfFloat2.start();
        drawTickDelayed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUnCheckedAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.mAnimDuration);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.appnew.android.Utils.CustomCheckBox.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                CustomCheckBox.this.mScaleVal = ((Float) animation.getAnimatedValue()).floatValue();
                CustomCheckBox customCheckBox = CustomCheckBox.this;
                customCheckBox.mFloorColor = CustomCheckBox.getGradientColor(customCheckBox.mCheckedColor, CustomCheckBox.this.mFloorUnCheckedColor, CustomCheckBox.this.mScaleVal);
                CustomCheckBox.this.postInvalidate();
            }
        });
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        valueAnimatorOfFloat2.setDuration(this.mAnimDuration);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.appnew.android.Utils.CustomCheckBox.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                CustomCheckBox.this.mFloorScale = ((Float) animation.getAnimatedValue()).floatValue();
                CustomCheckBox.this.postInvalidate();
            }
        });
        valueAnimatorOfFloat2.start();
    }

    private void drawTickDelayed() {
        postDelayed(new Runnable() { // from class: com.appnew.android.Utils.CustomCheckBox.7
            @Override // java.lang.Runnable
            public void run() {
                CustomCheckBox.this.mTickDrawing = true;
                CustomCheckBox.this.postInvalidate();
            }
        }, this.mAnimDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getGradientColor(int startColor, int endColor, float percent) {
        float f2 = 1.0f - percent;
        return Color.argb((int) ((Color.alpha(startColor) * f2) + (Color.alpha(endColor) * percent)), (int) ((Color.red(startColor) * f2) + (Color.red(endColor) * percent)), (int) ((Color.green(startColor) * f2) + (Color.green(endColor) * percent)), (int) ((Color.blue(startColor) * f2) + (Color.blue(endColor) * percent)));
    }

    public void setTickColor(int color) {
        this.mTickColor = color;
        this.mTickPaint.setColor(color);
    }

    public void setUnCheckedColor(int unCheckedColor) {
        this.mUnCheckedColor = unCheckedColor;
    }

    public void setCheckedColor(int checkedColor) {
        this.mCheckedColor = checkedColor;
    }

    public void setFloorColor(int floorColor) {
        this.mFloorColor = floorColor;
    }

    public void setFloorUnCheckedColor(int floorUnCheckedColor) {
        this.mFloorUnCheckedColor = floorUnCheckedColor;
    }

    public int getTickColor() {
        return this.mTickColor;
    }

    public int getCheckedColor() {
        return this.mCheckedColor;
    }

    public int getUnCheckedColor() {
        return this.mUnCheckedColor;
    }

    public int getFloorColor() {
        return this.mFloorColor;
    }

    public int getFloorUnCheckedColor() {
        return this.mFloorUnCheckedColor;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener l) {
        this.mListener = l;
    }

    private static int dp2px(Context context, float dipValue) {
        return (int) ((dipValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
