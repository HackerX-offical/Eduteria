package info.bideens.barcode.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.google.android.gms.common.images.Size;
import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public class CameraSourcePreview extends ViewGroup {
    private static final String TAG = "CameraSourcePreview";
    private CameraSource mCameraSource;
    private Context mContext;
    private GraphicOverlay mOverlay;
    private boolean mStartRequested;
    private boolean mSurfaceAvailable;
    private SurfaceView mSurfaceView;

    public CameraSourcePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mStartRequested = false;
        this.mSurfaceAvailable = false;
        SurfaceView surfaceView = new SurfaceView(context);
        this.mSurfaceView = surfaceView;
        surfaceView.getHolder().addCallback(new SurfaceCallback());
        addView(this.mSurfaceView);
    }

    public void start(CameraSource cameraSource) throws IOException, SecurityException {
        if (cameraSource == null) {
            stop();
        }
        this.mCameraSource = cameraSource;
        if (cameraSource != null) {
            this.mStartRequested = true;
            startIfReady();
        }
    }

    public void start(CameraSource cameraSource, GraphicOverlay graphicOverlay) throws IOException, SecurityException {
        this.mOverlay = graphicOverlay;
        start(cameraSource);
    }

    public void stop() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.stop();
        }
    }

    public void release() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.release();
            this.mCameraSource = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startIfReady() throws IOException, SecurityException {
        if (this.mStartRequested && this.mSurfaceAvailable) {
            this.mCameraSource.start(this.mSurfaceView.getHolder());
            if (this.mOverlay != null) {
                Size previewSize = this.mCameraSource.getPreviewSize();
                int iMin = Math.min(previewSize.getWidth(), previewSize.getHeight());
                int iMax = Math.max(previewSize.getWidth(), previewSize.getHeight());
                if (isPortraitMode()) {
                    this.mOverlay.setCameraInfo(iMin, iMax, this.mCameraSource.getCameraFacing());
                } else {
                    this.mOverlay.setCameraInfo(iMax, iMin, this.mCameraSource.getCameraFacing());
                }
                this.mOverlay.clear();
            }
            this.mStartRequested = false;
        }
    }

    private class SurfaceCallback implements SurfaceHolder.Callback {
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private SurfaceCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.mSurfaceAvailable = true;
            try {
                CameraSourcePreview.this.startIfReady();
            } catch (IOException e2) {
                Log.e(CameraSourcePreview.TAG, "Could not start camera source.", e2);
            } catch (SecurityException e3) {
                Log.e(CameraSourcePreview.TAG, "Do not have permission to start the camera", e3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.mSurfaceAvailable = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Size previewSize;
        int width = getWidth();
        int height = getHeight();
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null && (previewSize = cameraSource.getPreviewSize()) != null) {
            width = previewSize.getWidth();
            height = previewSize.getHeight();
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (isPortraitMode()) {
            int i7 = height;
            height = width;
            width = i7;
        }
        float f2 = width;
        float f3 = height;
        int i8 = (int) ((i5 / f2) * f3);
        if (isPortraitMode()) {
            i5 = (int) ((i6 / f3) * f2);
        } else {
            i6 = i8;
        }
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            getChildAt(i9).layout(0, 0, i5, i6);
        }
        try {
            startIfReady();
        } catch (IOException e2) {
            Log.e(TAG, "Could not start camera source.", e2);
        } catch (SecurityException e3) {
            Log.e(TAG, "Do not have permission to start the camera", e3);
        }
    }

    private boolean isPortraitMode() {
        int i = this.mContext.getResources().getConfiguration().orientation;
        if (i == 2) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        Log.d(TAG, "isPortraitMode returning false by default");
        return false;
    }
}
