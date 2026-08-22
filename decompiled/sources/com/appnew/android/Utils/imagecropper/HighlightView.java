package com.appnew.android.Utils.imagecropper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
class HighlightView {
    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_NONE = 1;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    public static final int MOVE = 32;
    private static final String TAG = "HighlightView";
    View mContext;
    RectF mCropRect;
    Rect mDrawRect;
    boolean mHidden;
    private RectF mImageRect;
    private float mInitialAspectRatio;
    boolean mIsFocused;
    Matrix mMatrix;
    private Drawable mResizeDrawableDiagonal;
    private Drawable mResizeDrawableHeight;
    private Drawable mResizeDrawableWidth;
    private ModifyMode mMode = ModifyMode.None;
    private boolean mMaintainAspectRatio = false;
    private boolean mCircle = false;
    private final Paint mFocusPaint = new Paint();
    private final Paint mNoFocusPaint = new Paint();
    private final Paint mOutlinePaint = new Paint();

    enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View ctx) {
        this.mContext = ctx;
    }

    private void init() {
        Resources resources = this.mContext.getResources();
        this.mResizeDrawableWidth = resources.getDrawable(R.drawable.camera_crop_width);
        this.mResizeDrawableHeight = resources.getDrawable(R.drawable.camera_crop_height);
        this.mResizeDrawableDiagonal = resources.getDrawable(R.drawable.indicator_autocrop);
    }

    public boolean hasFocus() {
        return this.mIsFocused;
    }

    public void setFocus(boolean f2) {
        this.mIsFocused = f2;
    }

    public void setHidden(boolean hidden) {
        this.mHidden = hidden;
    }

    protected void draw(Canvas canvas) {
        if (this.mHidden) {
            return;
        }
        Path path = new Path();
        if (!hasFocus()) {
            this.mOutlinePaint.setColor(-16777216);
            canvas.drawRect(this.mDrawRect, this.mOutlinePaint);
            return;
        }
        Rect rect = new Rect();
        this.mContext.getDrawingRect(rect);
        if (this.mCircle) {
            canvas.save();
            float fWidth = this.mDrawRect.width() / 2.0f;
            path.addCircle(this.mDrawRect.left + fWidth, this.mDrawRect.top + (this.mDrawRect.height() / 2.0f), fWidth, Path.Direction.CW);
            this.mOutlinePaint.setColor(-1112874);
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, hasFocus() ? this.mFocusPaint : this.mNoFocusPaint);
            canvas.restore();
        } else {
            Rect rect2 = new Rect(rect.left, rect.top, rect.right, this.mDrawRect.top);
            if (rect2.width() > 0 && rect2.height() > 0) {
                canvas.drawRect(rect2, hasFocus() ? this.mFocusPaint : this.mNoFocusPaint);
            }
            Rect rect3 = new Rect(rect.left, this.mDrawRect.bottom, rect.right, rect.bottom);
            if (rect3.width() > 0 && rect3.height() > 0) {
                canvas.drawRect(rect3, hasFocus() ? this.mFocusPaint : this.mNoFocusPaint);
            }
            Rect rect4 = new Rect(rect.left, rect2.bottom, this.mDrawRect.left, rect3.top);
            if (rect4.width() > 0 && rect4.height() > 0) {
                canvas.drawRect(rect4, hasFocus() ? this.mFocusPaint : this.mNoFocusPaint);
            }
            Rect rect5 = new Rect(this.mDrawRect.right, rect2.bottom, rect.right, rect3.top);
            if (rect5.width() > 0 && rect5.height() > 0) {
                canvas.drawRect(rect5, hasFocus() ? this.mFocusPaint : this.mNoFocusPaint);
            }
            path.addRect(new RectF(this.mDrawRect), Path.Direction.CW);
            this.mOutlinePaint.setColor(-30208);
        }
        canvas.drawPath(path, this.mOutlinePaint);
        if (this.mMode == ModifyMode.Grow) {
            if (this.mCircle) {
                int intrinsicWidth = this.mResizeDrawableDiagonal.getIntrinsicWidth();
                int intrinsicHeight = this.mResizeDrawableDiagonal.getIntrinsicHeight();
                int iRound = (int) Math.round(Math.cos(0.7853981633974483d) * (((double) this.mDrawRect.width()) / 2.0d));
                int iWidth = ((this.mDrawRect.left + (this.mDrawRect.width() / 2)) + iRound) - (intrinsicWidth / 2);
                int iHeight = ((this.mDrawRect.top + (this.mDrawRect.height() / 2)) - iRound) - (intrinsicHeight / 2);
                Drawable drawable = this.mResizeDrawableDiagonal;
                drawable.setBounds(iWidth, iHeight, drawable.getIntrinsicWidth() + iWidth, this.mResizeDrawableDiagonal.getIntrinsicHeight() + iHeight);
                this.mResizeDrawableDiagonal.draw(canvas);
                return;
            }
            int i = this.mDrawRect.left + 1;
            int i2 = this.mDrawRect.right + 1;
            int i3 = this.mDrawRect.top + 4;
            int i4 = this.mDrawRect.bottom + 3;
            int intrinsicWidth2 = this.mResizeDrawableWidth.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.mResizeDrawableWidth.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.mResizeDrawableHeight.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.mResizeDrawableHeight.getIntrinsicWidth() / 2;
            int i5 = this.mDrawRect.left + ((this.mDrawRect.right - this.mDrawRect.left) / 2);
            int i6 = this.mDrawRect.top + ((this.mDrawRect.bottom - this.mDrawRect.top) / 2);
            int i7 = i6 - intrinsicHeight2;
            int i8 = i6 + intrinsicHeight2;
            this.mResizeDrawableWidth.setBounds(i - intrinsicWidth2, i7, i + intrinsicWidth2, i8);
            this.mResizeDrawableWidth.draw(canvas);
            this.mResizeDrawableWidth.setBounds(i2 - intrinsicWidth2, i7, i2 + intrinsicWidth2, i8);
            this.mResizeDrawableWidth.draw(canvas);
            int i9 = i5 - intrinsicWidth3;
            int i10 = i5 + intrinsicWidth3;
            this.mResizeDrawableHeight.setBounds(i9, i3 - intrinsicHeight3, i10, i3 + intrinsicHeight3);
            this.mResizeDrawableHeight.draw(canvas);
            this.mResizeDrawableHeight.setBounds(i9, i4 - intrinsicHeight3, i10, i4 + intrinsicHeight3);
            this.mResizeDrawableHeight.draw(canvas);
        }
    }

    public ModifyMode getMode() {
        return this.mMode;
    }

    public void setMode(ModifyMode mode) {
        if (mode != this.mMode) {
            this.mMode = mode;
            this.mContext.invalidate();
        }
    }

    public int getHit(float x, float y) {
        Rect rectComputeLayout = computeLayout();
        if (this.mCircle) {
            float fCenterX = x - rectComputeLayout.centerX();
            float fCenterY = y - rectComputeLayout.centerY();
            int iSqrt = (int) Math.sqrt((fCenterX * fCenterX) + (fCenterY * fCenterY));
            int iWidth = this.mDrawRect.width() / 2;
            return ((float) Math.abs(iSqrt - iWidth)) <= 20.0f ? Math.abs(fCenterY) > Math.abs(fCenterX) ? fCenterY < 0.0f ? 8 : 16 : fCenterX < 0.0f ? 2 : 4 : iSqrt < iWidth ? 32 : 1;
        }
        boolean z = false;
        boolean z2 = y >= ((float) rectComputeLayout.top) - 20.0f && y < ((float) rectComputeLayout.bottom) + 20.0f;
        if (x >= rectComputeLayout.left - 20.0f && x < rectComputeLayout.right + 20.0f) {
            z = true;
        }
        int i = (Math.abs(((float) rectComputeLayout.left) - x) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(rectComputeLayout.right - x) < 20.0f && z2) {
            i |= 4;
        }
        if (Math.abs(rectComputeLayout.top - y) < 20.0f && z) {
            i |= 8;
        }
        if (Math.abs(rectComputeLayout.bottom - y) < 20.0f && z) {
            i |= 16;
        }
        if (i == 1 && rectComputeLayout.contains((int) x, (int) y)) {
            return 32;
        }
        return i;
    }

    void handleMotion(int edge, float dx, float dy) {
        Rect rectComputeLayout = computeLayout();
        if (edge == 1) {
            return;
        }
        if (edge == 32) {
            moveBy(dx * (this.mCropRect.width() / rectComputeLayout.width()), dy * (this.mCropRect.height() / rectComputeLayout.height()));
            return;
        }
        if ((edge & 6) == 0) {
            dx = 0.0f;
        }
        if ((edge & 24) == 0) {
            dy = 0.0f;
        }
        growBy(((edge & 2) != 0 ? -1 : 1) * dx * (this.mCropRect.width() / rectComputeLayout.width()), ((edge & 8) != 0 ? -1 : 1) * dy * (this.mCropRect.height() / rectComputeLayout.height()));
    }

    void moveBy(float dx, float dy) {
        Rect rect = new Rect(this.mDrawRect);
        this.mCropRect.offset(dx, dy);
        this.mCropRect.offset(Math.max(0.0f, this.mImageRect.left - this.mCropRect.left), Math.max(0.0f, this.mImageRect.top - this.mCropRect.top));
        this.mCropRect.offset(Math.min(0.0f, this.mImageRect.right - this.mCropRect.right), Math.min(0.0f, this.mImageRect.bottom - this.mCropRect.bottom));
        Rect rectComputeLayout = computeLayout();
        this.mDrawRect = rectComputeLayout;
        rect.union(rectComputeLayout);
        rect.inset(-10, -10);
        this.mContext.invalidate(rect);
    }

    void growBy(float dx, float dy) {
        if (this.mMaintainAspectRatio) {
            if (dx != 0.0f) {
                dy = dx / this.mInitialAspectRatio;
            } else if (dy != 0.0f) {
                dx = this.mInitialAspectRatio * dy;
            }
        }
        RectF rectF = new RectF(this.mCropRect);
        if (dx > 0.0f && rectF.width() + (dx * 2.0f) > this.mImageRect.width()) {
            dx = (this.mImageRect.width() - rectF.width()) / 2.0f;
            if (this.mMaintainAspectRatio) {
                dy = dx / this.mInitialAspectRatio;
            }
        }
        if (dy > 0.0f && rectF.height() + (dy * 2.0f) > this.mImageRect.height()) {
            dy = (this.mImageRect.height() - rectF.height()) / 2.0f;
            if (this.mMaintainAspectRatio) {
                dx = this.mInitialAspectRatio * dy;
            }
        }
        rectF.inset(-dx, -dy);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        float f2 = this.mMaintainAspectRatio ? 25.0f / this.mInitialAspectRatio : 25.0f;
        if (rectF.height() < f2) {
            rectF.inset(0.0f, (-(f2 - rectF.height())) / 2.0f);
        }
        if (rectF.left < this.mImageRect.left) {
            rectF.offset(this.mImageRect.left - rectF.left, 0.0f);
        } else if (rectF.right > this.mImageRect.right) {
            rectF.offset(-(rectF.right - this.mImageRect.right), 0.0f);
        }
        if (rectF.top < this.mImageRect.top) {
            rectF.offset(0.0f, this.mImageRect.top - rectF.top);
        } else if (rectF.bottom > this.mImageRect.bottom) {
            rectF.offset(0.0f, -(rectF.bottom - this.mImageRect.bottom));
        }
        this.mCropRect.set(rectF);
        this.mDrawRect = computeLayout();
        this.mContext.invalidate();
    }

    public Rect getCropRect() {
        return new Rect((int) this.mCropRect.left, (int) this.mCropRect.top, (int) this.mCropRect.right, (int) this.mCropRect.bottom);
    }

    private Rect computeLayout() {
        RectF rectF = new RectF(this.mCropRect.left, this.mCropRect.top, this.mCropRect.right, this.mCropRect.bottom);
        this.mMatrix.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public void invalidate() {
        this.mDrawRect = computeLayout();
    }

    public void setup(Matrix m, Rect imageRect, RectF cropRect, boolean circle, boolean maintainAspectRatio) {
        if (circle) {
            maintainAspectRatio = true;
        }
        this.mMatrix = new Matrix(m);
        this.mCropRect = cropRect;
        this.mImageRect = new RectF(imageRect);
        this.mMaintainAspectRatio = maintainAspectRatio;
        this.mCircle = circle;
        this.mInitialAspectRatio = this.mCropRect.width() / this.mCropRect.height();
        this.mDrawRect = computeLayout();
        this.mFocusPaint.setARGB(125, 50, 50, 50);
        this.mNoFocusPaint.setARGB(125, 50, 50, 50);
        this.mOutlinePaint.setStrokeWidth(3.0f);
        this.mOutlinePaint.setStyle(Paint.Style.STROKE);
        this.mOutlinePaint.setAntiAlias(true);
        this.mMode = ModifyMode.None;
        init();
    }
}
