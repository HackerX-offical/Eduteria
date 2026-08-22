package com.appnew.android.customview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes6.dex */
public class TouchImageView extends AppCompatImageView {
    private static final String DEBUG = "DEBUG";
    private static final float SUPER_MAX_MULTIPLIER = 1.25f;
    private static final float SUPER_MIN_MULTIPLIER = 0.75f;
    private Context context;
    private ZoomVariables delayedZoomVariables;
    private GestureDetector.OnDoubleTapListener doubleTapListener;
    private Fling fling;
    private boolean imageRenderedAtLeastOnce;
    private float[] m;
    private GestureDetector mGestureDetector;
    private ScaleGestureDetector mScaleDetector;
    private ImageView.ScaleType mScaleType;
    private float matchViewHeight;
    private float matchViewWidth;
    private Matrix matrix;
    private float maxScale;
    private float minScale;
    private float normalizedScale;
    private boolean onDrawReady;
    private float prevMatchViewHeight;
    private float prevMatchViewWidth;
    private Matrix prevMatrix;
    private int prevViewHeight;
    private int prevViewWidth;
    private State state;
    private float superMaxScale;
    private float superMinScale;
    private OnTouchImageViewListener touchImageViewListener;
    private View.OnTouchListener userTouchListener;
    private int viewHeight;
    private int viewWidth;

    public interface OnTouchImageViewListener {
        void onMove();
    }

    private enum State {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFixDragTrans(float delta, float viewSize, float contentSize) {
        if (contentSize <= viewSize) {
            return 0.0f;
        }
        return delta;
    }

    private float getFixTrans(float trans, float viewSize, float contentSize) {
        float f2;
        float f3;
        if (contentSize <= viewSize) {
            f3 = viewSize - contentSize;
            f2 = 0.0f;
        } else {
            f2 = viewSize - contentSize;
            f3 = 0.0f;
        }
        if (trans < f2) {
            return (-trans) + f2;
        }
        if (trans > f3) {
            return (-trans) + f3;
        }
        return 0.0f;
    }

    public TouchImageView(Context context) {
        super(context);
        this.doubleTapListener = null;
        this.userTouchListener = null;
        this.touchImageViewListener = null;
        sharedConstructing(context);
    }

    public TouchImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.doubleTapListener = null;
        this.userTouchListener = null;
        this.touchImageViewListener = null;
        sharedConstructing(context);
    }

    public TouchImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.doubleTapListener = null;
        this.userTouchListener = null;
        this.touchImageViewListener = null;
        sharedConstructing(context);
    }

    private void sharedConstructing(Context context) {
        super.setClickable(true);
        this.context = context;
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        this.mGestureDetector = new GestureDetector(context, new GestureListener());
        this.matrix = new Matrix();
        this.prevMatrix = new Matrix();
        this.m = new float[9];
        this.normalizedScale = 1.0f;
        if (this.mScaleType == null) {
            this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        }
        this.minScale = 1.0f;
        this.maxScale = 3.0f;
        this.superMinScale = 1.0f * 0.75f;
        this.superMaxScale = 3.0f * SUPER_MAX_MULTIPLIER;
        setImageMatrix(this.matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(State.NONE);
        this.onDrawReady = false;
        super.setOnTouchListener(new PrivateOnTouchListener());
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener l) {
        this.userTouchListener = l;
    }

    public void setOnTouchImageViewListener(OnTouchImageViewListener l) {
        this.touchImageViewListener = l;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener l) {
        this.doubleTapListener = l;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        savePreviousImageValues();
        fitImageToView();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        savePreviousImageValues();
        fitImageToView();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        savePreviousImageValues();
        fitImageToView();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        savePreviousImageValues();
        fitImageToView();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType type) {
        if (type == ImageView.ScaleType.FIT_START || type == ImageView.ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        }
        if (type == ImageView.ScaleType.MATRIX) {
            super.setScaleType(ImageView.ScaleType.MATRIX);
            return;
        }
        this.mScaleType = type;
        if (this.onDrawReady) {
            setZoom(this);
        }
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public boolean isZoomed() {
        return this.normalizedScale != 1.0f;
    }

    public RectF getZoomedRect() {
        if (this.mScaleType == ImageView.ScaleType.FIT_XY) {
            throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
        }
        PointF pointFTransformCoordTouchToBitmap = transformCoordTouchToBitmap(0.0f, 0.0f, true);
        PointF pointFTransformCoordTouchToBitmap2 = transformCoordTouchToBitmap(this.viewWidth, this.viewHeight, true);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        return new RectF(pointFTransformCoordTouchToBitmap.x / intrinsicWidth, pointFTransformCoordTouchToBitmap.y / intrinsicHeight, pointFTransformCoordTouchToBitmap2.x / intrinsicWidth, pointFTransformCoordTouchToBitmap2.y / intrinsicHeight);
    }

    private void savePreviousImageValues() {
        Matrix matrix = this.matrix;
        if (matrix == null || this.viewHeight == 0 || this.viewWidth == 0) {
            return;
        }
        matrix.getValues(this.m);
        this.prevMatrix.setValues(this.m);
        this.prevMatchViewHeight = this.matchViewHeight;
        this.prevMatchViewWidth = this.matchViewWidth;
        this.prevViewHeight = this.viewHeight;
        this.prevViewWidth = this.viewWidth;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.normalizedScale);
        bundle.putFloat("matchViewHeight", this.matchViewHeight);
        bundle.putFloat("matchViewWidth", this.matchViewWidth);
        bundle.putInt("viewWidth", this.viewWidth);
        bundle.putInt("viewHeight", this.viewHeight);
        this.matrix.getValues(this.m);
        bundle.putFloatArray("matrix", this.m);
        bundle.putBoolean("imageRendered", this.imageRenderedAtLeastOnce);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.normalizedScale = bundle.getFloat("saveScale");
            float[] floatArray = bundle.getFloatArray("matrix");
            this.m = floatArray;
            this.prevMatrix.setValues(floatArray);
            this.prevMatchViewHeight = bundle.getFloat("matchViewHeight");
            this.prevMatchViewWidth = bundle.getFloat("matchViewWidth");
            this.prevViewHeight = bundle.getInt("viewHeight");
            this.prevViewWidth = bundle.getInt("viewWidth");
            this.imageRenderedAtLeastOnce = bundle.getBoolean("imageRendered");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.onDrawReady = true;
        this.imageRenderedAtLeastOnce = true;
        ZoomVariables zoomVariables = this.delayedZoomVariables;
        if (zoomVariables != null) {
            setZoom(zoomVariables.scale, this.delayedZoomVariables.focusX, this.delayedZoomVariables.focusY, this.delayedZoomVariables.scaleType);
            this.delayedZoomVariables = null;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        savePreviousImageValues();
    }

    public float getMaxZoom() {
        return this.maxScale;
    }

    public void setMaxZoom(float max) {
        this.maxScale = max;
        this.superMaxScale = max * SUPER_MAX_MULTIPLIER;
    }

    public float getMinZoom() {
        return this.minScale;
    }

    public float getCurrentZoom() {
        return this.normalizedScale;
    }

    public void setMinZoom(float min) {
        this.minScale = min;
        this.superMinScale = min * 0.75f;
    }

    public void resetZoom() {
        this.normalizedScale = 1.0f;
        fitImageToView();
    }

    public void setZoom(float scale) {
        setZoom(scale, 0.5f, 0.5f);
    }

    public void setZoom(float scale, float focusX, float focusY) {
        setZoom(scale, focusX, focusY, this.mScaleType);
    }

    public void setZoom(float scale, float focusX, float focusY, ImageView.ScaleType scaleType) {
        if (!this.onDrawReady) {
            this.delayedZoomVariables = new ZoomVariables(scale, focusX, focusY, scaleType);
            return;
        }
        if (scaleType != this.mScaleType) {
            setScaleType(scaleType);
        }
        resetZoom();
        scaleImage(scale, this.viewWidth / 2, this.viewHeight / 2, true);
        this.matrix.getValues(this.m);
        this.m[2] = -((focusX * getImageWidth()) - (this.viewWidth * 0.5f));
        this.m[5] = -((getImageHeight() * focusY) - (this.viewHeight * 0.5f));
        this.matrix.setValues(this.m);
        fixTrans();
        setImageMatrix(this.matrix);
    }

    public void setZoom(TouchImageView img) {
        PointF scrollPosition = img.getScrollPosition();
        setZoom(img.getCurrentZoom(), scrollPosition.x, scrollPosition.y, img.getScaleType());
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF pointFTransformCoordTouchToBitmap = transformCoordTouchToBitmap(this.viewWidth / 2, this.viewHeight / 2, true);
        pointFTransformCoordTouchToBitmap.x /= intrinsicWidth;
        pointFTransformCoordTouchToBitmap.y /= intrinsicHeight;
        return pointFTransformCoordTouchToBitmap;
    }

    public void setScrollPosition(float focusX, float focusY) {
        setZoom(this.normalizedScale, focusX, focusY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixTrans() {
        this.matrix.getValues(this.m);
        float[] fArr = this.m;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float fixTrans = getFixTrans(f2, this.viewWidth, getImageWidth());
        float fixTrans2 = getFixTrans(f3, this.viewHeight, getImageHeight());
        if (fixTrans == 0.0f && fixTrans2 == 0.0f) {
            return;
        }
        this.matrix.postTranslate(fixTrans, fixTrans2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixScaleTrans() {
        fixTrans();
        this.matrix.getValues(this.m);
        float imageWidth = getImageWidth();
        int i = this.viewWidth;
        if (imageWidth < i) {
            this.m[2] = (i - getImageWidth()) / 2.0f;
        }
        float imageHeight = getImageHeight();
        int i2 = this.viewHeight;
        if (imageHeight < i2) {
            this.m[5] = (i2 - getImageHeight()) / 2.0f;
        }
        this.matrix.setValues(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageWidth() {
        return this.matchViewWidth * this.normalizedScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageHeight() {
        return this.matchViewHeight * this.normalizedScale;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        this.viewWidth = setViewSize(mode, size, intrinsicWidth);
        int viewSize = setViewSize(mode2, size2, intrinsicHeight);
        this.viewHeight = viewSize;
        setMeasuredDimension(this.viewWidth, viewSize);
        fitImageToView();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void fitImageToView() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.customview.TouchImageView.fitImageToView():void");
    }

    /* JADX INFO: renamed from: com.appnew.android.customview.TouchImageView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private int setViewSize(int mode, int size, int drawableWidth) {
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : drawableWidth;
        }
        return Math.min(drawableWidth, size);
    }

    private void translateMatrixAfterRotate(int axis, float trans, float prevImageSize, float imageSize, int prevViewSize, int viewSize, int drawableSize) {
        float f2 = viewSize;
        if (imageSize < f2) {
            float[] fArr = this.m;
            fArr[axis] = (f2 - (drawableSize * fArr[0])) * 0.5f;
        } else if (trans > 0.0f) {
            this.m[axis] = -((imageSize - f2) * 0.5f);
        } else {
            this.m[axis] = -((((Math.abs(trans) + (prevViewSize * 0.5f)) / prevImageSize) * imageSize) - (f2 * 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(State state) {
        this.state = state;
    }

    public boolean canScrollHorizontallyFroyo(int direction) {
        return canScrollHorizontally(direction);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        this.matrix.getValues(this.m);
        float f2 = this.m[2];
        if (getImageWidth() < this.viewWidth) {
            return false;
        }
        if (f2 < -1.0f || direction >= 0) {
            return (Math.abs(f2) + ((float) this.viewWidth)) + 1.0f < getImageWidth() || direction <= 0;
        }
        return false;
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e2) {
            if (TouchImageView.this.doubleTapListener != null) {
                return TouchImageView.this.doubleTapListener.onSingleTapConfirmed(e2);
            }
            return TouchImageView.this.performClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e2) {
            TouchImageView.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (TouchImageView.this.fling != null) {
                TouchImageView.this.fling.cancelFling();
            }
            TouchImageView.this.fling = TouchImageView.this.new Fling((int) velocityX, (int) velocityY);
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.compatPostOnAnimation(touchImageView.fling);
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e2) {
            boolean zOnDoubleTap = TouchImageView.this.doubleTapListener != null ? TouchImageView.this.doubleTapListener.onDoubleTap(e2) : false;
            if (TouchImageView.this.state != State.NONE) {
                return zOnDoubleTap;
            }
            TouchImageView.this.compatPostOnAnimation(TouchImageView.this.new DoubleTapZoom(TouchImageView.this.normalizedScale == TouchImageView.this.minScale ? TouchImageView.this.maxScale : TouchImageView.this.minScale, e2.getX(), e2.getY(), false));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent e2) {
            if (TouchImageView.this.doubleTapListener != null) {
                return TouchImageView.this.doubleTapListener.onDoubleTapEvent(e2);
            }
            return false;
        }
    }

    private class PrivateOnTouchListener implements View.OnTouchListener {
        private PointF last;

        private PrivateOnTouchListener() {
            this.last = new PointF();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00a0  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instruction units count: 241
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.customview.TouchImageView.PrivateOnTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            TouchImageView.this.setState(State.ZOOM);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            TouchImageView.this.scaleImage(detector.getScaleFactor(), detector.getFocusX(), detector.getFocusY(), true);
            if (TouchImageView.this.touchImageViewListener == null) {
                return true;
            }
            TouchImageView.this.touchImageViewListener.onMove();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
            super.onScaleEnd(detector);
            TouchImageView.this.setState(State.NONE);
            float f2 = TouchImageView.this.normalizedScale;
            boolean z = true;
            if (TouchImageView.this.normalizedScale > TouchImageView.this.maxScale) {
                f2 = TouchImageView.this.maxScale;
            } else if (TouchImageView.this.normalizedScale < TouchImageView.this.minScale) {
                f2 = TouchImageView.this.minScale;
            } else {
                z = false;
            }
            float f3 = f2;
            if (z) {
                TouchImageView.this.compatPostOnAnimation(TouchImageView.this.new DoubleTapZoom(f3, r3.viewWidth / 2, TouchImageView.this.viewHeight / 2, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleImage(double deltaScale, float focusX, float focusY, boolean stretchImageToSuper) {
        float f2;
        float f3;
        if (stretchImageToSuper) {
            f2 = this.superMinScale;
            f3 = this.superMaxScale;
        } else {
            f2 = this.minScale;
            f3 = this.maxScale;
        }
        float f4 = this.normalizedScale;
        float f5 = (float) (((double) f4) * deltaScale);
        this.normalizedScale = f5;
        if (f5 > f3) {
            this.normalizedScale = f3;
            deltaScale = f3 / f4;
        } else if (f5 < f2) {
            this.normalizedScale = f2;
            deltaScale = f2 / f4;
        }
        float f6 = (float) deltaScale;
        this.matrix.postScale(f6, f6, focusX, focusY);
        fixScaleTrans();
    }

    private class DoubleTapZoom implements Runnable {
        private static final float ZOOM_TIME = 500.0f;
        private float bitmapX;
        private float bitmapY;
        private PointF endTouch;
        private AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        private long startTime;
        private PointF startTouch;
        private float startZoom;
        private boolean stretchImageToSuper;
        private float targetZoom;

        DoubleTapZoom(float targetZoom, float focusX, float focusY, boolean stretchImageToSuper) {
            TouchImageView.this.setState(State.ANIMATE_ZOOM);
            this.startTime = System.currentTimeMillis();
            this.startZoom = TouchImageView.this.normalizedScale;
            this.targetZoom = targetZoom;
            this.stretchImageToSuper = stretchImageToSuper;
            PointF pointFTransformCoordTouchToBitmap = TouchImageView.this.transformCoordTouchToBitmap(focusX, focusY, false);
            this.bitmapX = pointFTransformCoordTouchToBitmap.x;
            float f2 = pointFTransformCoordTouchToBitmap.y;
            this.bitmapY = f2;
            this.startTouch = TouchImageView.this.transformCoordBitmapToTouch(this.bitmapX, f2);
            this.endTouch = new PointF(TouchImageView.this.viewWidth / 2, TouchImageView.this.viewHeight / 2);
        }

        @Override // java.lang.Runnable
        public void run() {
            float fInterpolate = interpolate();
            TouchImageView.this.scaleImage(calculateDeltaScale(fInterpolate), this.bitmapX, this.bitmapY, this.stretchImageToSuper);
            translateImageToCenterTouchPosition(fInterpolate);
            TouchImageView.this.fixScaleTrans();
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.setImageMatrix(touchImageView.matrix);
            if (TouchImageView.this.touchImageViewListener != null) {
                TouchImageView.this.touchImageViewListener.onMove();
            }
            if (fInterpolate < 1.0f) {
                TouchImageView.this.compatPostOnAnimation(this);
            } else {
                TouchImageView.this.setState(State.NONE);
            }
        }

        private void translateImageToCenterTouchPosition(float t) {
            float f2 = this.startTouch.x + ((this.endTouch.x - this.startTouch.x) * t);
            float f3 = this.startTouch.y + (t * (this.endTouch.y - this.startTouch.y));
            PointF pointFTransformCoordBitmapToTouch = TouchImageView.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
            TouchImageView.this.matrix.postTranslate(f2 - pointFTransformCoordBitmapToTouch.x, f3 - pointFTransformCoordBitmapToTouch.y);
        }

        private float interpolate() {
            return this.interpolator.getInterpolation(Math.min(1.0f, (System.currentTimeMillis() - this.startTime) / ZOOM_TIME));
        }

        private double calculateDeltaScale(float t) {
            float f2 = this.startZoom;
            return ((double) (f2 + (t * (this.targetZoom - f2)))) / ((double) TouchImageView.this.normalizedScale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF transformCoordTouchToBitmap(float x, float y, boolean clipToBitmap) {
        this.matrix.getValues(this.m);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float[] fArr = this.m;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float imageWidth = ((x - f2) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((y - f3) * intrinsicHeight) / getImageHeight();
        if (clipToBitmap) {
            imageWidth = Math.min(Math.max(imageWidth, 0.0f), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, 0.0f), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF transformCoordBitmapToTouch(float bx, float by) {
        this.matrix.getValues(this.m);
        return new PointF(this.m[2] + (getImageWidth() * (bx / getDrawable().getIntrinsicWidth())), this.m[5] + (getImageHeight() * (by / getDrawable().getIntrinsicHeight())));
    }

    private class Fling implements Runnable {
        int currX;
        int currY;
        CompatScroller scroller;

        Fling(int velocityX, int velocityY) {
            int imageWidth;
            int i;
            int imageHeight;
            int i2;
            TouchImageView.this.setState(State.FLING);
            this.scroller = TouchImageView.this.new CompatScroller(TouchImageView.this.context);
            TouchImageView.this.matrix.getValues(TouchImageView.this.m);
            int i3 = (int) TouchImageView.this.m[2];
            int i4 = (int) TouchImageView.this.m[5];
            if (TouchImageView.this.getImageWidth() > TouchImageView.this.viewWidth) {
                imageWidth = TouchImageView.this.viewWidth - ((int) TouchImageView.this.getImageWidth());
                i = 0;
            } else {
                imageWidth = i3;
                i = imageWidth;
            }
            if (TouchImageView.this.getImageHeight() > TouchImageView.this.viewHeight) {
                imageHeight = TouchImageView.this.viewHeight - ((int) TouchImageView.this.getImageHeight());
                i2 = 0;
            } else {
                imageHeight = i4;
                i2 = imageHeight;
            }
            this.scroller.fling(i3, i4, velocityX, velocityY, imageWidth, i, imageHeight, i2);
            this.currX = i3;
            this.currY = i4;
        }

        public void cancelFling() {
            if (this.scroller != null) {
                TouchImageView.this.setState(State.NONE);
                this.scroller.forceFinished(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TouchImageView.this.touchImageViewListener != null) {
                TouchImageView.this.touchImageViewListener.onMove();
            }
            if (this.scroller.isFinished()) {
                this.scroller = null;
                return;
            }
            if (this.scroller.computeScrollOffset()) {
                int currX = this.scroller.getCurrX();
                int currY = this.scroller.getCurrY();
                int i = currX - this.currX;
                int i2 = currY - this.currY;
                this.currX = currX;
                this.currY = currY;
                TouchImageView.this.matrix.postTranslate(i, i2);
                TouchImageView.this.fixTrans();
                TouchImageView touchImageView = TouchImageView.this;
                touchImageView.setImageMatrix(touchImageView.matrix);
                TouchImageView.this.compatPostOnAnimation(this);
            }
        }
    }

    private class CompatScroller {
        boolean isPreGingerbread = false;
        OverScroller overScroller;
        Scroller scroller;

        public CompatScroller(Context context) {
            this.overScroller = new OverScroller(context);
        }

        public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
            if (this.isPreGingerbread) {
                this.scroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
            } else {
                this.overScroller.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
            }
        }

        public void forceFinished(boolean finished) {
            if (this.isPreGingerbread) {
                this.scroller.forceFinished(finished);
            } else {
                this.overScroller.forceFinished(finished);
            }
        }

        public boolean isFinished() {
            if (this.isPreGingerbread) {
                return this.scroller.isFinished();
            }
            return this.overScroller.isFinished();
        }

        public boolean computeScrollOffset() {
            if (this.isPreGingerbread) {
                return this.scroller.computeScrollOffset();
            }
            this.overScroller.computeScrollOffset();
            return this.overScroller.computeScrollOffset();
        }

        public int getCurrX() {
            if (this.isPreGingerbread) {
                return this.scroller.getCurrX();
            }
            return this.overScroller.getCurrX();
        }

        public int getCurrY() {
            if (this.isPreGingerbread) {
                return this.scroller.getCurrY();
            }
            return this.overScroller.getCurrY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void compatPostOnAnimation(Runnable runnable) {
        postOnAnimation(runnable);
    }

    private class ZoomVariables {
        public float focusX;
        public float focusY;
        public float scale;
        public ImageView.ScaleType scaleType;

        public ZoomVariables(float scale, float focusX, float focusY, ImageView.ScaleType scaleType) {
            this.scale = scale;
            this.focusX = focusX;
            this.focusY = focusY;
            this.scaleType = scaleType;
        }
    }

    private void printMatrixInfo() {
        this.matrix.getValues(new float[9]);
    }
}
