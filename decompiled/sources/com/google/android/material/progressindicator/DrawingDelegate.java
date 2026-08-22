package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes8.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    protected DrawableWithAnimatedVisibilityChange drawable;
    S spec;

    abstract void adjustCanvas(Canvas canvas, Rect rect, float f2);

    abstract void fillIndicator(Canvas canvas, Paint paint, float f2, float f3, int i);

    abstract void fillTrack(Canvas canvas, Paint paint);

    abstract int getPreferredHeight();

    abstract int getPreferredWidth();

    public DrawingDelegate(S s) {
        this.spec = s;
    }

    protected void registerDrawable(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
        this.drawable = drawableWithAnimatedVisibilityChange;
    }

    void validateSpecAndAdjustCanvas(Canvas canvas, Rect rect, float f2) {
        this.spec.validateSpec();
        adjustCanvas(canvas, rect, f2);
    }
}
