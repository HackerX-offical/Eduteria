package info.bideens.barcode.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import info.bideens.barcode.camera.GraphicOverlay.Graphic;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/* JADX INFO: loaded from: classes9.dex */
public class GraphicOverlay<T extends Graphic> extends View {
    private int mFacing;
    private Set<T> mGraphics;
    private float mHeightScaleFactor;
    private final Object mLock;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private float mWidthScaleFactor;

    public static abstract class Graphic {
        private GraphicOverlay mOverlay;

        public abstract void draw(Canvas canvas);

        public Graphic(GraphicOverlay graphicOverlay) {
            this.mOverlay = graphicOverlay;
        }

        public float scaleX(float f2) {
            return f2 * this.mOverlay.mWidthScaleFactor;
        }

        public float scaleY(float f2) {
            return f2 * this.mOverlay.mHeightScaleFactor;
        }

        public float translateX(float f2) {
            if (this.mOverlay.mFacing == 1) {
                return this.mOverlay.getWidth() - scaleX(f2);
            }
            return scaleX(f2);
        }

        public float translateY(float f2) {
            return scaleY(f2);
        }

        public void postInvalidate() {
            this.mOverlay.postInvalidate();
        }
    }

    public GraphicOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLock = new Object();
        this.mWidthScaleFactor = 1.0f;
        this.mHeightScaleFactor = 1.0f;
        this.mFacing = 0;
        this.mGraphics = new HashSet();
    }

    public void clear() {
        synchronized (this.mLock) {
            this.mGraphics.clear();
        }
        postInvalidate();
    }

    public void add(T t) {
        synchronized (this.mLock) {
            this.mGraphics.add(t);
        }
        postInvalidate();
    }

    public void remove(T t) {
        synchronized (this.mLock) {
            this.mGraphics.remove(t);
        }
        postInvalidate();
    }

    public List<T> getGraphics() {
        Vector vector;
        synchronized (this.mLock) {
            vector = new Vector(this.mGraphics);
        }
        return vector;
    }

    public float getWidthScaleFactor() {
        return this.mWidthScaleFactor;
    }

    public float getHeightScaleFactor() {
        return this.mHeightScaleFactor;
    }

    public void setCameraInfo(int i, int i2, int i3) {
        synchronized (this.mLock) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
            this.mFacing = i3;
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.mLock) {
            if (this.mPreviewWidth != 0 && this.mPreviewHeight != 0) {
                this.mWidthScaleFactor = canvas.getWidth() / this.mPreviewWidth;
                this.mHeightScaleFactor = canvas.getHeight() / this.mPreviewHeight;
            }
            Iterator<T> it = this.mGraphics.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas);
            }
        }
    }
}
