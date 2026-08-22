package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes8.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcDirectionFactor = 1;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(Canvas canvas, Rect rect, float f2) {
        float fWidth = rect.width() / getPreferredWidth();
        float fHeight = rect.height() / getPreferredHeight();
        float f3 = (((CircularProgressIndicatorSpec) this.spec).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
        canvas.translate((f3 * fWidth) + rect.left, (f3 * fHeight) + rect.top);
        canvas.scale(fWidth, fHeight);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        this.arcDirectionFactor = ((CircularProgressIndicatorSpec) this.spec).indicatorDirection == 0 ? 1 : -1;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) this.spec).trackThickness * f2;
        this.displayedCornerRadius = ((CircularProgressIndicatorSpec) this.spec).trackCornerRadius * f2;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) this.spec).indicatorSize - ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
            this.adjustedRadius += ((1.0f - f2) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        } else if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            this.adjustedRadius -= ((1.0f - f2) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(Canvas canvas, Paint paint, float f2, float f3, int i) {
        if (f2 == f3) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.displayedTrackThickness);
        int i2 = this.arcDirectionFactor;
        float f4 = f2 * 360.0f * i2;
        float f5 = (f3 >= f2 ? f3 - f2 : (1.0f + f3) - f2) * 360.0f * i2;
        float f6 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f6, -f6, f6, f6), f4, f5, false, paint);
        if (this.displayedCornerRadius <= 0.0f || Math.abs(f5) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f4);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f4 + f5);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas canvas, Paint paint) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iCompositeARGBWithAlpha);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f2 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f2, -f2, f2, f2), 0.0f, 360.0f, false, paint);
    }

    private int getSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize + (((CircularProgressIndicatorSpec) this.spec).indicatorInset * 2);
    }

    private void drawRoundedEnd(Canvas canvas, Paint paint, float f2, float f3, float f4) {
        canvas.save();
        canvas.rotate(f4);
        float f5 = this.adjustedRadius;
        float f6 = f2 / 2.0f;
        canvas.drawRoundRect(new RectF(f5 - f6, f3, f5 + f6, -f3), f3, f3, paint);
        canvas.restore();
    }
}
