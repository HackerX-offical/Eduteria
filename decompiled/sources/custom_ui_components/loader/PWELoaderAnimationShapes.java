package custom_ui_components.loader;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes9.dex */
public abstract class PWELoaderAnimationShapes extends PWELoaderAnimation {
    private int mBaseColor;
    private Paint mPaint;
    private int mUseColor;

    public abstract void drawShape(Canvas canvas, Paint paint);

    public PWELoaderAnimationShapes() {
        setColor(-1);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(this.mUseColor);
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation
    public void setColor(int i) {
        this.mBaseColor = i;
        updateUseColor();
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation
    public int getColor() {
        return this.mBaseColor;
    }

    public int getUseColor() {
        return this.mUseColor;
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        updateUseColor();
    }

    private void updateUseColor() {
        int alpha = getAlpha();
        int i = this.mBaseColor;
        this.mUseColor = ((((i >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24) | ((i << 8) >>> 8);
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation
    protected final void drawSelf(Canvas canvas) {
        this.mPaint.setColor(this.mUseColor);
        drawShape(canvas, this.mPaint);
    }
}
