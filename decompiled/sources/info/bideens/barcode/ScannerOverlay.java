package info.bideens.barcode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes9.dex */
public class ScannerOverlay extends ViewGroup {
    private float endY;
    private int frames;
    private float left;
    private int lineColor;
    private int lineWidth;
    private int rectHeight;
    private int rectWidth;
    private boolean revAnimation;
    private float top;

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ScannerOverlay(Context context) {
        super(context);
    }

    public ScannerOverlay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScannerOverlay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ScannerOverlay, 0, 0);
        this.rectWidth = typedArrayObtainStyledAttributes.getInteger(R.styleable.ScannerOverlay_square_width, getResources().getInteger(R.integer.scanner_rect_width));
        this.rectHeight = typedArrayObtainStyledAttributes.getInteger(R.styleable.ScannerOverlay_square_height, getResources().getInteger(R.integer.scanner_rect_height));
        this.lineColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ScannerOverlay_line_color, ContextCompat.getColor(context, R.color.scanner_line));
        this.lineWidth = typedArrayObtainStyledAttributes.getInteger(R.styleable.ScannerOverlay_line_width, getResources().getInteger(R.integer.line_width));
        this.frames = typedArrayObtainStyledAttributes.getInteger(R.styleable.ScannerOverlay_line_speed, getResources().getInteger(R.integer.line_width));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.left = (i - dpToPx(this.rectWidth)) / 2;
        float fDpToPx = (i2 - dpToPx(this.rectHeight)) / 2;
        this.top = fDpToPx;
        this.endY = fDpToPx;
        super.onSizeChanged(i, i2, i3, i4);
    }

    public int dpToPx(int i) {
        return Math.round(i * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float f2 = 0;
        canvas.drawRoundRect(new RectF(this.left, this.top, dpToPx(this.rectWidth) + this.left, dpToPx(this.rectHeight) + this.top), f2, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(this.lineColor);
        paint2.setStrokeWidth(Float.valueOf(this.lineWidth).floatValue());
        float f3 = this.endY;
        float fDpToPx = this.top + dpToPx(this.rectHeight);
        int i = this.frames;
        if (f3 >= fDpToPx + i) {
            this.revAnimation = true;
        } else if (this.endY == this.top + i) {
            this.revAnimation = false;
        }
        if (this.revAnimation) {
            this.endY -= i;
        } else {
            this.endY += i;
        }
        float f4 = this.left;
        canvas.drawLine(f4, this.endY, f4 + dpToPx(this.rectWidth), this.endY, paint2);
        invalidate();
    }
}
