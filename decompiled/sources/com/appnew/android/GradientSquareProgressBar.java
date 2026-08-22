package com.appnew.android;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes6.dex */
public class GradientSquareProgressBar extends View {
    private static final int BODY_STROKE_WIDTH = 1;
    private static final int GLOW_STROKE_WIDTH = 3;
    private static final int PADDING = 2;
    private float mBodyStrokeWidthPx;
    private float mGlowStrokeWidthPx;
    private float mPaddingPx;
    private Paint mPaintBody;
    private Paint mPaintGlow;
    private float progress;

    public GradientSquareProgressBar(Context context) {
        super(context);
        this.progress = 0.0f;
        init();
    }

    public GradientSquareProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.progress = 0.0f;
        init();
    }

    public GradientSquareProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.progress = 0.0f;
        init();
    }

    private void init() {
        setLayerType(1, null);
        int color = ResourcesCompat.getColor(getResources(), com.eduteria.app.app.R.color.squire_body, null);
        int color2 = ResourcesCompat.getColor(getResources(), com.eduteria.app.app.R.color.squire_glow, null);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mBodyStrokeWidthPx = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.mGlowStrokeWidthPx = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.mPaddingPx = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        Paint paint = new Paint();
        this.mPaintBody = paint;
        paint.setAntiAlias(true);
        this.mPaintBody.setColor(color);
        this.mPaintBody.setStrokeWidth(this.mBodyStrokeWidthPx);
        this.mPaintBody.setStyle(Paint.Style.STROKE);
        this.mPaintBody.setStrokeJoin(Paint.Join.MITER);
        this.mPaintBody.setStrokeCap(Paint.Cap.SQUARE);
        Paint paint2 = new Paint(this.mPaintBody);
        this.mPaintGlow = paint2;
        paint2.setColor(color2);
        this.mPaintGlow.setStrokeWidth(this.mGlowStrokeWidthPx);
        this.mPaintGlow.setMaskFilter(new BlurMaskFilter(this.mBodyStrokeWidthPx, BlurMaskFilter.Blur.NORMAL));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2 = this.mPaddingPx;
        float width = getWidth() - this.mPaddingPx;
        float height = getHeight() - this.mPaddingPx;
        float f3 = width - f2;
        float f4 = height - f2;
        float f5 = f3 + f4;
        float f6 = 2.0f * f5 * this.progress;
        Path path = new Path();
        path.moveTo(f2, f2);
        if (f6 <= f3) {
            path.lineTo(f6 + f2, f2);
        } else if (f6 <= f5) {
            path.lineTo(width, f2);
            path.lineTo(width, f2 + (f6 - f3));
        } else if (f6 <= f5 + f3) {
            path.lineTo(width, f2);
            path.lineTo(width, height);
            path.lineTo(width - ((f6 - f3) - f4), height);
        } else {
            path.lineTo(width, f2);
            path.lineTo(width, height);
            path.lineTo(f2, height);
            path.lineTo(f2, height - (((f6 - f3) - f4) - f3));
        }
        canvas.drawPath(path, this.mPaintGlow);
        canvas.drawPath(path, this.mPaintBody);
    }

    public void setProgress(float progress) {
        this.progress = Math.max(0.0f, Math.min(progress, 1.0f));
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }
}
