package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes8.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private Path displayedTrackPath;
    private float displayedTrackThickness;
    private float trackLength;

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    public LinearDrawingDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.trackLength = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(Canvas canvas, Rect rect, float f2) {
        this.trackLength = rect.width();
        float f3 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.drawable.isShowing() && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.drawable.isShowing() || this.drawable.isHiding()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.spec).trackThickness * (f2 - 1.0f)) / 2.0f);
        }
        float f4 = this.trackLength;
        canvas.clipRect((-f4) / 2.0f, (-f3) / 2.0f, f4 / 2.0f, f3 / 2.0f);
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) this.spec).trackThickness * f2;
        this.displayedCornerRadius = ((LinearProgressIndicatorSpec) this.spec).trackCornerRadius * f2;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(Canvas canvas, Paint paint, float f2, float f3, int i) {
        if (f2 == f3) {
            return;
        }
        float f4 = this.trackLength;
        float f5 = (-f4) / 2.0f;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i);
        canvas.save();
        canvas.clipPath(this.displayedTrackPath);
        float f6 = this.displayedTrackThickness;
        RectF rectF = new RectF(((f2 * f4) + f5) - (this.displayedCornerRadius * 2.0f), (-f6) / 2.0f, f5 + (f3 * f4), f6 / 2.0f);
        float f7 = this.displayedCornerRadius;
        canvas.drawRoundRect(rectF, f7, f7, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas canvas, Paint paint) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iCompositeARGBWithAlpha);
        Path path = new Path();
        this.displayedTrackPath = path;
        float f2 = this.trackLength;
        float f3 = this.displayedTrackThickness;
        RectF rectF = new RectF((-f2) / 2.0f, (-f3) / 2.0f, f2 / 2.0f, f3 / 2.0f);
        float f4 = this.displayedCornerRadius;
        path.addRoundRect(rectF, f4, f4, Path.Direction.CCW);
        canvas.drawPath(this.displayedTrackPath, paint);
    }
}
