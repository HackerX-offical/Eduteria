package com.appnew.android.Utils.imagecropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.appnew.android.Utils.imagecropper.HighlightView;
import com.appnew.android.Utils.imagecropper.ImageViewTouchBase;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CropImageViews extends ImageViewTouchBase {
    private Context mContext;
    ArrayList<HighlightView> mHighlightViews;
    float mLastX;
    float mLastY;
    int mMotionEdge;
    HighlightView mMotionHighlightView;

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase, android.view.View, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase, android.widget.ImageView
    public /* bridge */ /* synthetic */ void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageBitmapResetBase(final Bitmap bitmap, final boolean resetSupp) {
        super.setImageBitmapResetBase(bitmap, resetSupp);
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setImageRotateBitmapResetBase(final RotateBitmap bitmap, final boolean resetSupp) {
        super.setImageRotateBitmapResetBase(bitmap, resetSupp);
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase
    public /* bridge */ /* synthetic */ void setRecycler(ImageViewTouchBase.Recycler r) {
        super.setRecycler(r);
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mBitmapDisplayed.getBitmap() != null) {
            for (HighlightView highlightView : this.mHighlightViews) {
                highlightView.mMatrix.set(getImageMatrix());
                highlightView.invalidate();
                if (highlightView.mIsFocused) {
                    centerBasedOnHighlightView(highlightView);
                }
            }
        }
    }

    public CropImageViews(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHighlightViews = new ArrayList<>();
        this.mMotionHighlightView = null;
        this.mContext = context;
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase
    protected void zoomTo(float scale, float centerX, float centerY) {
        super.zoomTo(scale, centerX, centerY);
        for (HighlightView highlightView : this.mHighlightViews) {
            highlightView.mMatrix.set(getImageMatrix());
            highlightView.invalidate();
        }
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase
    protected void zoomIn() {
        super.zoomIn();
        for (HighlightView highlightView : this.mHighlightViews) {
            highlightView.mMatrix.set(getImageMatrix());
            highlightView.invalidate();
        }
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase
    protected void zoomOut() {
        super.zoomOut();
        for (HighlightView highlightView : this.mHighlightViews) {
            highlightView.mMatrix.set(getImageMatrix());
            highlightView.invalidate();
        }
    }

    @Override // com.appnew.android.Utils.imagecropper.ImageViewTouchBase
    protected void postTranslate(float deltaX, float deltaY) {
        super.postTranslate(deltaX, deltaY);
        for (int i = 0; i < this.mHighlightViews.size(); i++) {
            HighlightView highlightView = this.mHighlightViews.get(i);
            highlightView.mMatrix.postTranslate(deltaX, deltaY);
            highlightView.invalidate();
        }
    }

    private void recomputeFocus(MotionEvent event) {
        int i = 0;
        for (int i2 = 0; i2 < this.mHighlightViews.size(); i2++) {
            HighlightView highlightView = this.mHighlightViews.get(i2);
            highlightView.setFocus(false);
            highlightView.invalidate();
        }
        while (true) {
            if (i >= this.mHighlightViews.size()) {
                break;
            }
            HighlightView highlightView2 = this.mHighlightViews.get(i);
            if (highlightView2.getHit(event.getX(), event.getY()) == 1) {
                i++;
            } else if (!highlightView2.hasFocus()) {
                highlightView2.setFocus(true);
                highlightView2.invalidate();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        HighlightView.ModifyMode modifyMode;
        CropImage cropImage = (CropImage) this.mContext;
        int i = 0;
        if (cropImage.mSaving) {
            return false;
        }
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                if (cropImage.mWaitingToPick) {
                    for (int i2 = 0; i2 < this.mHighlightViews.size(); i2++) {
                        HighlightView highlightView = this.mHighlightViews.get(i2);
                        if (highlightView.hasFocus()) {
                            cropImage.mCrop = highlightView;
                            for (int i3 = 0; i3 < this.mHighlightViews.size(); i3++) {
                                if (i3 != i2) {
                                    this.mHighlightViews.get(i3).setHidden(true);
                                }
                            }
                            centerBasedOnHighlightView(highlightView);
                            ((CropImage) this.mContext).mWaitingToPick = false;
                            return true;
                        }
                    }
                } else {
                    HighlightView highlightView2 = this.mMotionHighlightView;
                    if (highlightView2 != null) {
                        centerBasedOnHighlightView(highlightView2);
                        this.mMotionHighlightView.setMode(HighlightView.ModifyMode.None);
                    }
                }
                this.mMotionHighlightView = null;
            } else if (action == 2) {
                if (cropImage.mWaitingToPick) {
                    recomputeFocus(event);
                } else {
                    HighlightView highlightView3 = this.mMotionHighlightView;
                    if (highlightView3 != null) {
                        highlightView3.handleMotion(this.mMotionEdge, event.getX() - this.mLastX, event.getY() - this.mLastY);
                        this.mLastX = event.getX();
                        this.mLastY = event.getY();
                        ensureVisible(this.mMotionHighlightView);
                    }
                }
            }
        } else if (cropImage.mWaitingToPick) {
            recomputeFocus(event);
        } else {
            while (true) {
                if (i >= this.mHighlightViews.size()) {
                    break;
                }
                HighlightView highlightView4 = this.mHighlightViews.get(i);
                int hit = highlightView4.getHit(event.getX(), event.getY());
                if (hit != 1) {
                    this.mMotionEdge = hit;
                    this.mMotionHighlightView = highlightView4;
                    this.mLastX = event.getX();
                    this.mLastY = event.getY();
                    HighlightView highlightView5 = this.mMotionHighlightView;
                    if (hit == 32) {
                        modifyMode = HighlightView.ModifyMode.Move;
                    } else {
                        modifyMode = HighlightView.ModifyMode.Grow;
                    }
                    highlightView5.setMode(modifyMode);
                } else {
                    i++;
                }
            }
        }
        int action2 = event.getAction();
        if (action2 == 1) {
            center(true, true);
        } else if (action2 == 2 && getScale() == 1.0f) {
            center(true, true);
        }
        return true;
    }

    private void ensureVisible(HighlightView hv) {
        Rect rect = hv.mDrawRect;
        int iMax = Math.max(0, this.mLeft - rect.left);
        int iMin = Math.min(0, this.mRight - rect.right);
        int iMax2 = Math.max(0, this.mTop - rect.top);
        int iMin2 = Math.min(0, this.mBottom - rect.bottom);
        if (iMax == 0) {
            iMax = iMin;
        }
        if (iMax2 == 0) {
            iMax2 = iMin2;
        }
        if (iMax == 0 && iMax2 == 0) {
            return;
        }
        panBy(iMax, iMax2);
    }

    private void centerBasedOnHighlightView(HighlightView hv) {
        Rect rect = hv.mDrawRect;
        float fMax = Math.max(1.0f, Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f) * getScale());
        if (Math.abs(fMax - getScale()) / fMax > 0.1d) {
            float[] fArr = {hv.mCropRect.centerX(), hv.mCropRect.centerY()};
            getImageMatrix().mapPoints(fArr);
            zoomTo(fMax, fArr[0], fArr[1], 300.0f);
        }
        ensureVisible(hv);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.mHighlightViews.size(); i++) {
            this.mHighlightViews.get(i).draw(canvas);
        }
    }

    public void add(HighlightView hv) {
        this.mHighlightViews.add(hv);
        invalidate();
    }
}
