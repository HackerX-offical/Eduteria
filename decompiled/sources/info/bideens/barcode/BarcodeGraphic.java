package info.bideens.barcode;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.gms.vision.barcode.Barcode;
import info.bideens.barcode.camera.GraphicOverlay;

/* JADX INFO: loaded from: classes9.dex */
public class BarcodeGraphic extends GraphicOverlay.Graphic {
    private static final int[] COLOR_CHOICES = {-16776961, -16711681, -16711936};
    private static int mCurrentColorIndex = 0;
    private volatile Barcode mBarcode;
    private int mId;
    private Paint mRectPaint;
    private Paint mTextPaint;

    BarcodeGraphic(GraphicOverlay graphicOverlay) {
        super(graphicOverlay);
        int i = mCurrentColorIndex + 1;
        int[] iArr = COLOR_CHOICES;
        int length = i % iArr.length;
        mCurrentColorIndex = length;
        int i2 = iArr[length];
        Paint paint = new Paint();
        this.mRectPaint = paint;
        paint.setColor(i2);
        this.mRectPaint.setStyle(Paint.Style.STROKE);
        this.mRectPaint.setStrokeWidth(4.0f);
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setColor(i2);
        this.mTextPaint.setTextSize(36.0f);
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public Barcode getBarcode() {
        return this.mBarcode;
    }

    void updateItem(Barcode barcode) {
        this.mBarcode = barcode;
        postInvalidate();
    }

    @Override // info.bideens.barcode.camera.GraphicOverlay.Graphic
    public void draw(Canvas canvas) {
        Barcode barcode = this.mBarcode;
        if (barcode == null) {
            return;
        }
        RectF rectF = new RectF(barcode.getBoundingBox());
        rectF.left = translateX(rectF.left);
        rectF.top = translateY(rectF.top);
        rectF.right = translateX(rectF.right);
        rectF.bottom = translateY(rectF.bottom);
        canvas.drawRect(rectF, this.mRectPaint);
        canvas.drawText(barcode.rawValue, rectF.left, rectF.bottom, this.mTextPaint);
    }
}
