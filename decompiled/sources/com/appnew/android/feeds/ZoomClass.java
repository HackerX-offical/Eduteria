package com.appnew.android.feeds;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ZoomClass.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 ^2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002]^B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bB%\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eJ\u0010\u0010<\u001a\u00020=2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010>\u001a\u00020=H\u0002J\u0006\u0010?\u001a\u00020=J \u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\"H\u0002J \u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\"H\u0002J\u0018\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020\r2\u0006\u0010H\u001a\u00020\rH\u0014J\u001a\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020NH\u0016J\u0010\u0010Q\u001a\u00020=2\u0006\u0010P\u001a\u00020NH\u0016J\u0010\u0010R\u001a\u00020J2\u0006\u0010P\u001a\u00020NH\u0016J*\u0010S\u001a\u00020J2\b\u0010T\u001a\u0004\u0018\u00010N2\u0006\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\"H\u0016J\u0010\u0010X\u001a\u00020=2\u0006\u0010P\u001a\u00020NH\u0016J*\u0010Y\u001a\u00020J2\b\u0010T\u001a\u0004\u0018\u00010N2\u0006\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\"H\u0016J\u0010\u0010Z\u001a\u00020J2\u0006\u0010P\u001a\u00020NH\u0016J\u0010\u0010[\u001a\u00020J2\u0006\u0010P\u001a\u00020NH\u0016J\u0010\u0010\\\u001a\u00020J2\u0006\u0010P\u001a\u00020NH\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001a\u0010-\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\u001a\u00100\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001a\u00103\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u001a\u00106\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/appnew/android/feeds/ZoomClass;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/view/View$OnTouchListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "mScaleDetector", "Landroid/view/ScaleGestureDetector;", "mGestureDetector", "Landroid/view/GestureDetector;", "mMatrix", "Landroid/graphics/Matrix;", "getMMatrix", "()Landroid/graphics/Matrix;", "setMMatrix", "(Landroid/graphics/Matrix;)V", "mMatrixValues", "", "mode", "getMode", "()I", "setMode", "(I)V", "mSaveScale", "", "getMSaveScale", "()F", "setMSaveScale", "(F)V", "mMinScale", "getMMinScale", "setMMinScale", "mMaxScale", "getMMaxScale", "setMMaxScale", "origWidth", "getOrigWidth", "setOrigWidth", "origHeight", "getOrigHeight", "setOrigHeight", "viewWidth", "getViewWidth", "setViewWidth", "viewHeight", "getViewHeight", "setViewHeight", "mLast", "Landroid/graphics/PointF;", "mStart", "sharedConstructing", "", "fitToScreen", "fixTranslation", "getFixTranslation", "trans", "viewSize", "contentSize", "getFixDragTrans", "delta", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouch", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onDown", "motionEvent", "onShowPress", "onSingleTapUp", "onScroll", "p0", "p1", "p2", "p3", "onLongPress", "onFling", "onSingleTapConfirmed", "onDoubleTap", "onDoubleTapEvent", "ScaleListener", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZoomClass extends AppCompatImageView implements View.OnTouchListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    public static final int DRAG = 1;
    public static final int NONE = 0;
    public static final int ZOOM = 2;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private PointF mLast;
    private Matrix mMatrix;
    private float[] mMatrixValues;
    private float mMaxScale;
    private float mMinScale;
    private float mSaveScale;
    private ScaleGestureDetector mScaleDetector;
    private PointF mStart;
    private int mode;
    private float origHeight;
    private float origWidth;
    private int viewHeight;
    private int viewWidth;
    public static final int $stable = 8;

    private final float getFixDragTrans(float delta, float viewSize, float contentSize) {
        if (contentSize <= viewSize) {
            return 0.0f;
        }
        return delta;
    }

    private final float getFixTranslation(float trans, float viewSize, float contentSize) {
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

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent p0, MotionEvent p1, float p2, float p3) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent p0, MotionEvent p1, float p2, float p3) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        return false;
    }

    public final Matrix getMMatrix() {
        return this.mMatrix;
    }

    public final void setMMatrix(Matrix matrix) {
        this.mMatrix = matrix;
    }

    public final int getMode() {
        return this.mode;
    }

    public final void setMode(int i) {
        this.mode = i;
    }

    public final float getMSaveScale() {
        return this.mSaveScale;
    }

    public final void setMSaveScale(float f2) {
        this.mSaveScale = f2;
    }

    public final float getMMinScale() {
        return this.mMinScale;
    }

    public final void setMMinScale(float f2) {
        this.mMinScale = f2;
    }

    public final float getMMaxScale() {
        return this.mMaxScale;
    }

    public final void setMMaxScale(float f2) {
        this.mMaxScale = f2;
    }

    public final float getOrigWidth() {
        return this.origWidth;
    }

    public final void setOrigWidth(float f2) {
        this.origWidth = f2;
    }

    public final float getOrigHeight() {
        return this.origHeight;
    }

    public final void setOrigHeight(float f2) {
        this.origHeight = f2;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final void setViewWidth(int i) {
        this.viewWidth = i;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final void setViewHeight(int i) {
        this.viewHeight = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomClass(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSaveScale = 1.0f;
        this.mMinScale = 1.0f;
        this.mMaxScale = 4.0f;
        this.mLast = new PointF();
        this.mStart = new PointF();
        sharedConstructing(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomClass(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSaveScale = 1.0f;
        this.mMinScale = 1.0f;
        this.mMaxScale = 4.0f;
        this.mLast = new PointF();
        this.mStart = new PointF();
        sharedConstructing(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomClass(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        this.mSaveScale = 1.0f;
        this.mMinScale = 1.0f;
        this.mMaxScale = 4.0f;
        this.mLast = new PointF();
        this.mStart = new PointF();
    }

    private final void sharedConstructing(Context context) {
        super.setClickable(true);
        this.mContext = context;
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        Matrix matrix = new Matrix();
        this.mMatrix = matrix;
        this.mMatrixValues = new float[9];
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mGestureDetector = new GestureDetector(context, this);
        setOnTouchListener(this);
    }

    /* JADX INFO: compiled from: ZoomClass.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/appnew/android/feeds/ZoomClass$ScaleListener;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "<init>", "(Lcom/appnew/android/feeds/ZoomClass;)V", "onScaleBegin", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScale", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            ZoomClass.this.setMode(2);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00a0  */
        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onScale(android.view.ScaleGestureDetector r5) {
            /*
                r4 = this;
                java.lang.String r0 = "detector"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                float r0 = r5.getScaleFactor()
                com.appnew.android.feeds.ZoomClass r1 = com.appnew.android.feeds.ZoomClass.this
                float r1 = r1.getMSaveScale()
                com.appnew.android.feeds.ZoomClass r2 = com.appnew.android.feeds.ZoomClass.this
                float r3 = r2.getMSaveScale()
                float r3 = r3 * r0
                r2.setMSaveScale(r3)
                com.appnew.android.feeds.ZoomClass r2 = com.appnew.android.feeds.ZoomClass.this
                float r2 = r2.getMSaveScale()
                com.appnew.android.feeds.ZoomClass r3 = com.appnew.android.feeds.ZoomClass.this
                float r3 = r3.getMMaxScale()
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L3a
                com.appnew.android.feeds.ZoomClass r0 = com.appnew.android.feeds.ZoomClass.this
                float r2 = r0.getMMaxScale()
                r0.setMSaveScale(r2)
                com.appnew.android.feeds.ZoomClass r0 = com.appnew.android.feeds.ZoomClass.this
                float r0 = r0.getMMaxScale()
            L38:
                float r0 = r0 / r1
                goto L5a
            L3a:
                com.appnew.android.feeds.ZoomClass r2 = com.appnew.android.feeds.ZoomClass.this
                float r2 = r2.getMSaveScale()
                com.appnew.android.feeds.ZoomClass r3 = com.appnew.android.feeds.ZoomClass.this
                float r3 = r3.getMMinScale()
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 >= 0) goto L5a
                com.appnew.android.feeds.ZoomClass r0 = com.appnew.android.feeds.ZoomClass.this
                float r2 = r0.getMMinScale()
                r0.setMSaveScale(r2)
                com.appnew.android.feeds.ZoomClass r0 = com.appnew.android.feeds.ZoomClass.this
                float r0 = r0.getMMinScale()
                goto L38
            L5a:
                com.appnew.android.feeds.ZoomClass r1 = com.appnew.android.feeds.ZoomClass.this
                float r1 = r1.getOrigWidth()
                com.appnew.android.feeds.ZoomClass r2 = com.appnew.android.feeds.ZoomClass.this
                float r2 = r2.getMSaveScale()
                float r1 = r1 * r2
                com.appnew.android.feeds.ZoomClass r2 = com.appnew.android.feeds.ZoomClass.this
                int r2 = r2.getViewWidth()
                float r2 = (float) r2
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 <= 0) goto La0
                com.appnew.android.feeds.ZoomClass r1 = com.appnew.android.feeds.ZoomClass.this
                float r1 = r1.getOrigHeight()
                com.appnew.android.feeds.ZoomClass r2 = com.appnew.android.feeds.ZoomClass.this
                float r2 = r2.getMSaveScale()
                float r1 = r1 * r2
                com.appnew.android.feeds.ZoomClass r2 = com.appnew.android.feeds.ZoomClass.this
                int r2 = r2.getViewHeight()
                float r2 = (float) r2
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 > 0) goto L8b
                goto La0
            L8b:
                com.appnew.android.feeds.ZoomClass r1 = com.appnew.android.feeds.ZoomClass.this
                android.graphics.Matrix r1 = r1.getMMatrix()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                float r2 = r5.getFocusX()
                float r5 = r5.getFocusY()
                r1.postScale(r0, r0, r2, r5)
                goto Lbe
            La0:
                com.appnew.android.feeds.ZoomClass r5 = com.appnew.android.feeds.ZoomClass.this
                android.graphics.Matrix r5 = r5.getMMatrix()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                com.appnew.android.feeds.ZoomClass r1 = com.appnew.android.feeds.ZoomClass.this
                int r1 = r1.getViewWidth()
                float r1 = (float) r1
                r2 = 1073741824(0x40000000, float:2.0)
                float r1 = r1 / r2
                com.appnew.android.feeds.ZoomClass r3 = com.appnew.android.feeds.ZoomClass.this
                int r3 = r3.getViewHeight()
                float r3 = (float) r3
                float r3 = r3 / r2
                r5.postScale(r0, r0, r1, r3)
            Lbe:
                com.appnew.android.feeds.ZoomClass r5 = com.appnew.android.feeds.ZoomClass.this
                r5.fixTranslation()
                r5 = 1
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.ZoomClass.ScaleListener.onScale(android.view.ScaleGestureDetector):boolean");
        }
    }

    private final void fitToScreen() {
        this.mSaveScale = 1.0f;
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float fCoerceAtMost = RangesKt.coerceAtMost(this.viewWidth / intrinsicWidth, this.viewHeight / intrinsicHeight);
        Matrix matrix = this.mMatrix;
        Intrinsics.checkNotNull(matrix);
        matrix.setScale(fCoerceAtMost, fCoerceAtMost);
        float f2 = (this.viewHeight - (intrinsicHeight * fCoerceAtMost)) / 2.0f;
        float f3 = (this.viewWidth - (fCoerceAtMost * intrinsicWidth)) / 2.0f;
        Matrix matrix2 = this.mMatrix;
        Intrinsics.checkNotNull(matrix2);
        matrix2.postTranslate(f3, f2);
        float f4 = 2;
        this.origWidth = this.viewWidth - (f3 * f4);
        this.origHeight = this.viewHeight - (f4 * f2);
        setImageMatrix(this.mMatrix);
    }

    public final void fixTranslation() {
        Matrix matrix = this.mMatrix;
        Intrinsics.checkNotNull(matrix);
        matrix.getValues(this.mMatrixValues);
        float[] fArr = this.mMatrixValues;
        Intrinsics.checkNotNull(fArr);
        float f2 = fArr[2];
        float[] fArr2 = this.mMatrixValues;
        Intrinsics.checkNotNull(fArr2);
        float f3 = fArr2[5];
        float fixTranslation = getFixTranslation(f2, this.viewWidth, this.origWidth * this.mSaveScale);
        float fixTranslation2 = getFixTranslation(f3, this.viewHeight, this.origHeight * this.mSaveScale);
        if (fixTranslation == 0.0f && fixTranslation2 == 0.0f) {
            return;
        }
        Matrix matrix2 = this.mMatrix;
        Intrinsics.checkNotNull(matrix2);
        matrix2.postTranslate(fixTranslation, fixTranslation2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.viewWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        this.viewHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.mSaveScale == 1.0f) {
            fitToScreen();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ScaleGestureDetector scaleGestureDetector = this.mScaleDetector;
        Intrinsics.checkNotNull(scaleGestureDetector);
        scaleGestureDetector.onTouchEvent(event);
        GestureDetector gestureDetector = this.mGestureDetector;
        Intrinsics.checkNotNull(gestureDetector);
        gestureDetector.onTouchEvent(event);
        PointF pointF = new PointF(event.getX(), event.getY());
        int action = event.getAction();
        if (action == 0) {
            this.mLast.set(pointF);
            this.mStart.set(this.mLast);
            this.mode = 1;
        } else if (action != 2) {
            if (action == 6) {
                this.mode = 0;
            }
        } else if (this.mode == 1) {
            float f2 = pointF.x - this.mLast.x;
            float f3 = pointF.y - this.mLast.y;
            float fixDragTrans = getFixDragTrans(f2, this.viewWidth, this.origWidth * this.mSaveScale);
            float fixDragTrans2 = getFixDragTrans(f3, this.viewHeight, this.origHeight * this.mSaveScale);
            Matrix matrix = this.mMatrix;
            Intrinsics.checkNotNull(matrix);
            matrix.postTranslate(fixDragTrans, fixDragTrans2);
            fixTranslation();
            this.mLast.set(pointF.x, pointF.y);
        }
        setImageMatrix(this.mMatrix);
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        fitToScreen();
        return false;
    }
}
