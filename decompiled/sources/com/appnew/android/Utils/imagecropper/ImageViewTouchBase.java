package com.appnew.android.Utils.imagecropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes6.dex */
abstract class ImageViewTouchBase extends ImageView {
    static final float SCALE_RATE = 1.25f;
    private static final String TAG = "ImageViewTouchBase";
    protected Matrix mBaseMatrix;
    protected final RotateBitmap mBitmapDisplayed;
    int mBottom;
    private final Matrix mDisplayMatrix;
    protected Handler mHandler;
    int mLeft;
    private final float[] mMatrixValues;
    float mMaxZoom;
    private Runnable mOnLayoutRunnable;
    private Recycler mRecycler;
    int mRight;
    protected Matrix mSuppMatrix;
    int mThisHeight;
    int mThisWidth;
    int mTop;

    public interface Recycler {
        void recycle(Bitmap b2);
    }

    public void setRecycler(Recycler r) {
        this.mRecycler = r;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mLeft = left;
        this.mRight = right;
        this.mTop = top;
        this.mBottom = bottom;
        this.mThisWidth = right - left;
        this.mThisHeight = bottom - top;
        Runnable runnable = this.mOnLayoutRunnable;
        if (runnable != null) {
            this.mOnLayoutRunnable = null;
            runnable.run();
        }
        if (this.mBitmapDisplayed.getBitmap() != null) {
            getProperBaseMatrix(this.mBitmapDisplayed, this.mBaseMatrix);
            setImageMatrix(getImageViewMatrix());
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4 && getScale() > 1.0f) {
            zoomTo(1.0f);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, 0);
    }

    private void setImageBitmap(Bitmap bitmap, int rotation) {
        Recycler recycler;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmap2 = this.mBitmapDisplayed.getBitmap();
        this.mBitmapDisplayed.setBitmap(bitmap);
        this.mBitmapDisplayed.setRotation(rotation);
        if (bitmap2 == null || bitmap2 == bitmap || (recycler = this.mRecycler) == null) {
            return;
        }
        recycler.recycle(bitmap2);
    }

    public void clear() {
        setImageBitmapResetBase(null, true);
    }

    public void setImageBitmapResetBase(final Bitmap bitmap, final boolean resetSupp) {
        setImageRotateBitmapResetBase(new RotateBitmap(bitmap), resetSupp);
    }

    public void setImageRotateBitmapResetBase(final RotateBitmap bitmap, final boolean resetSupp) {
        if (getWidth() <= 0) {
            this.mOnLayoutRunnable = new Runnable() { // from class: com.appnew.android.Utils.imagecropper.ImageViewTouchBase.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageViewTouchBase.this.setImageRotateBitmapResetBase(bitmap, resetSupp);
                }
            };
            return;
        }
        if (bitmap.getBitmap() != null) {
            getProperBaseMatrix(bitmap, this.mBaseMatrix);
            setImageBitmap(bitmap.getBitmap(), bitmap.getRotation());
        } else {
            this.mBaseMatrix.reset();
            setImageBitmap(null);
        }
        if (resetSupp) {
            this.mSuppMatrix.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.mMaxZoom = maxZoom();
    }

    protected void center(boolean horizontal, boolean vertical) {
        float f2;
        float f3;
        float height;
        float f4;
        if (this.mBitmapDisplayed.getBitmap() == null) {
            return;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        float f5 = 0.0f;
        RectF rectF = new RectF(0.0f, 0.0f, this.mBitmapDisplayed.getBitmap().getWidth(), this.mBitmapDisplayed.getBitmap().getHeight());
        imageViewMatrix.mapRect(rectF);
        float fHeight = rectF.height();
        float fWidth = rectF.width();
        if (vertical) {
            float height2 = getHeight();
            if (fHeight < height2) {
                height = (height2 - fHeight) / 2.0f;
                f4 = rectF.top;
            } else if (rectF.top > 0.0f) {
                f2 = -rectF.top;
            } else {
                if (rectF.bottom < height2) {
                    height = getHeight();
                    f4 = rectF.bottom;
                }
                f2 = 0.0f;
            }
            f2 = height - f4;
        } else {
            f2 = 0.0f;
        }
        if (horizontal) {
            float width = getWidth();
            if (fWidth < width) {
                width = (width - fWidth) / 2.0f;
                f3 = rectF.left;
            } else if (rectF.left > 0.0f) {
                f5 = -rectF.left;
            } else if (rectF.right < width) {
                f3 = rectF.right;
            }
            f5 = width - f3;
        }
        postTranslate(f5, f2);
        setImageMatrix(getImageViewMatrix());
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mBitmapDisplayed = new RotateBitmap(null);
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mHandler = new Handler();
        this.mOnLayoutRunnable = null;
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mBitmapDisplayed = new RotateBitmap(null);
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mHandler = new Handler();
        this.mOnLayoutRunnable = null;
        init();
    }

    private void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    protected float getValue(Matrix matrix, int whichValue) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[whichValue];
    }

    protected float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    protected float getScale() {
        return getScale(this.mSuppMatrix);
    }

    private void getProperBaseMatrix(RotateBitmap bitmap, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float width2 = bitmap.getWidth();
        float height2 = bitmap.getHeight();
        bitmap.getRotation();
        matrix.reset();
        float fMin = Math.min(Math.min(width / width2, 2.0f), Math.min(height / height2, 2.0f));
        matrix.postConcat(bitmap.getRotateMatrix());
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (width2 * fMin)) / 2.0f, (height - (height2 * fMin)) / 2.0f);
    }

    protected Matrix getImageViewMatrix() {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(this.mSuppMatrix);
        return this.mDisplayMatrix;
    }

    protected float maxZoom() {
        if (this.mBitmapDisplayed.getBitmap() == null) {
            return 1.0f;
        }
        return Math.max(this.mBitmapDisplayed.getWidth() / this.mThisWidth, this.mBitmapDisplayed.getHeight() / this.mThisHeight) * 4.0f;
    }

    protected void zoomTo(float scale, float centerX, float centerY) {
        float f2 = this.mMaxZoom;
        if (scale > f2) {
            scale = f2;
        }
        float scale2 = scale / getScale();
        this.mSuppMatrix.postScale(scale2, scale2, centerX, centerY);
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    protected void zoomTo(final float scale, final float centerX, final float centerY, final float durationMs) {
        final float scale2 = (scale - getScale()) / durationMs;
        final float scale3 = getScale();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.mHandler.post(new Runnable() { // from class: com.appnew.android.Utils.imagecropper.ImageViewTouchBase.2
            @Override // java.lang.Runnable
            public void run() {
                float fMin = Math.min(durationMs, System.currentTimeMillis() - jCurrentTimeMillis);
                ImageViewTouchBase.this.zoomTo(scale3 + (scale2 * fMin), centerX, centerY);
                if (fMin < durationMs) {
                    ImageViewTouchBase.this.mHandler.post(this);
                }
            }
        });
    }

    protected void zoomTo(float scale) {
        zoomTo(scale, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    protected void zoomIn() {
        zoomIn(SCALE_RATE);
    }

    protected void zoomOut() {
        zoomOut(SCALE_RATE);
    }

    protected void zoomIn(float rate) {
        if (getScale() < this.mMaxZoom && this.mBitmapDisplayed.getBitmap() != null) {
            this.mSuppMatrix.postScale(rate, rate, getWidth() / 2.0f, getHeight() / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void zoomOut(float rate) {
        if (this.mBitmapDisplayed.getBitmap() == null) {
            return;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        Matrix matrix = new Matrix(this.mSuppMatrix);
        float f2 = 1.0f / rate;
        matrix.postScale(f2, f2, width, height);
        if (getScale(matrix) < 1.0f) {
            this.mSuppMatrix.setScale(1.0f, 1.0f, width, height);
        } else {
            this.mSuppMatrix.postScale(f2, f2, width, height);
        }
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    protected void postTranslate(float dx, float dy) {
        this.mSuppMatrix.postTranslate(dx, dy);
    }

    protected void panBy(float dx, float dy) {
        postTranslate(dx, dy);
        setImageMatrix(getImageViewMatrix());
    }
}
