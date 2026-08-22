package info.bideens.barcode.camera;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.canhub.cropper.CropImageOptionsKt;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class CameraSource {
    private static final float ASPECT_RATIO_TOLERANCE = 0.01f;
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    private static final int DUMMY_TEXTURE_NAME = 100;
    private static final String TAG = "OpenCameraSource";
    private Map<byte[], ByteBuffer> mBytesToByteBuffer;
    private Camera mCamera;
    private final Object mCameraLock;
    private Context mContext;
    private SurfaceTexture mDummySurfaceTexture;
    private SurfaceView mDummySurfaceView;
    private int mFacing;
    private String mFlashMode;
    private String mFocusMode;
    private FrameProcessingRunnable mFrameProcessor;
    private Size mPreviewSize;
    private Thread mProcessingThread;
    private float mRequestedFps;
    private int mRequestedPreviewHeight;
    private int mRequestedPreviewWidth;
    private int mRotation;

    public interface AutoFocusCallback {
        void onAutoFocus(boolean z);
    }

    public interface AutoFocusMoveCallback {
        void onAutoFocusMoving(boolean z);
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    public static class Builder {
        private CameraSource mCameraSource;
        private final Detector<?> mDetector;

        public Builder(Context context, Detector<?> detector) {
            CameraSource cameraSource = new CameraSource();
            this.mCameraSource = cameraSource;
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            }
            if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            }
            this.mDetector = detector;
            cameraSource.mContext = context;
        }

        public Builder setRequestedFps(float f2) {
            if (f2 > 0.0f) {
                this.mCameraSource.mRequestedFps = f2;
                return this;
            }
            throw new IllegalArgumentException("Invalid fps: " + f2);
        }

        public Builder setFocusMode(String str) {
            this.mCameraSource.mFocusMode = str;
            return this;
        }

        public Builder setFlashMode(String str) {
            this.mCameraSource.mFlashMode = str;
            return this;
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i > 0 && i <= 1000000 && i2 > 0 && i2 <= 1000000) {
                this.mCameraSource.mRequestedPreviewWidth = i;
                this.mCameraSource.mRequestedPreviewHeight = i2;
                return this;
            }
            throw new IllegalArgumentException("Invalid preview size: " + i + "x" + i2);
        }

        public Builder setFacing(int i) {
            if (i == 0 || i == 1) {
                this.mCameraSource.mFacing = i;
                return this;
            }
            throw new IllegalArgumentException("Invalid camera: " + i);
        }

        public CameraSource build() {
            CameraSource cameraSource = this.mCameraSource;
            CameraSource cameraSource2 = this.mCameraSource;
            cameraSource2.getClass();
            cameraSource.mFrameProcessor = cameraSource2.new FrameProcessingRunnable(this.mDetector);
            return this.mCameraSource;
        }
    }

    public void release() {
        synchronized (this.mCameraLock) {
            stop();
            this.mFrameProcessor.release();
        }
    }

    public CameraSource start() throws IOException {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                return this;
            }
            this.mCamera = createCamera();
            SurfaceTexture surfaceTexture = new SurfaceTexture(100);
            this.mDummySurfaceTexture = surfaceTexture;
            this.mCamera.setPreviewTexture(surfaceTexture);
            this.mCamera.startPreview();
            this.mProcessingThread = new Thread(this.mFrameProcessor);
            this.mFrameProcessor.setActive(true);
            this.mProcessingThread.start();
            return this;
        }
    }

    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                return this;
            }
            Camera cameraCreateCamera = createCamera();
            this.mCamera = cameraCreateCamera;
            cameraCreateCamera.setPreviewDisplay(surfaceHolder);
            this.mCamera.startPreview();
            this.mProcessingThread = new Thread(this.mFrameProcessor);
            this.mFrameProcessor.setActive(true);
            this.mProcessingThread.start();
            return this;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:7:0x0010, B:10:0x001b, B:11:0x001d, B:13:0x0026, B:14:0x002e, B:18:0x0047, B:17:0x0035, B:19:0x004e, B:9:0x0014), top: B:24:0x0005, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e A[Catch: all -> 0x0050, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x0005, B:7:0x0010, B:10:0x001b, B:11:0x001d, B:13:0x0026, B:14:0x002e, B:18:0x0047, B:17:0x0035, B:19:0x004e, B:9:0x0014), top: B:24:0x0005, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void stop() {
        /*
            r6 = this;
            java.lang.String r0 = "Failed to clear camera preview: "
            java.lang.Object r1 = r6.mCameraLock
            monitor-enter(r1)
            info.bideens.barcode.camera.CameraSource$FrameProcessingRunnable r2 = r6.mFrameProcessor     // Catch: java.lang.Throwable -> L50
            r3 = 0
            r2.setActive(r3)     // Catch: java.lang.Throwable -> L50
            java.lang.Thread r2 = r6.mProcessingThread     // Catch: java.lang.Throwable -> L50
            r3 = 0
            if (r2 == 0) goto L1d
            r2.join()     // Catch: java.lang.InterruptedException -> L14 java.lang.Throwable -> L50
            goto L1b
        L14:
            java.lang.String r2 = "OpenCameraSource"
            java.lang.String r4 = "Frame processing thread interrupted on release."
            android.util.Log.d(r2, r4)     // Catch: java.lang.Throwable -> L50
        L1b:
            r6.mProcessingThread = r3     // Catch: java.lang.Throwable -> L50
        L1d:
            java.util.Map<byte[], java.nio.ByteBuffer> r2 = r6.mBytesToByteBuffer     // Catch: java.lang.Throwable -> L50
            r2.clear()     // Catch: java.lang.Throwable -> L50
            android.hardware.Camera r2 = r6.mCamera     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L4e
            r2.stopPreview()     // Catch: java.lang.Throwable -> L50
            android.hardware.Camera r2 = r6.mCamera     // Catch: java.lang.Throwable -> L50
            r2.setPreviewCallbackWithBuffer(r3)     // Catch: java.lang.Throwable -> L50
            android.hardware.Camera r2 = r6.mCamera     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L50
            r2.setPreviewTexture(r3)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L50
            goto L47
        L34:
            r2 = move-exception
            java.lang.String r4 = "OpenCameraSource"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L50
            java.lang.StringBuilder r0 = r5.append(r2)     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L50
            android.util.Log.e(r4, r0)     // Catch: java.lang.Throwable -> L50
        L47:
            android.hardware.Camera r0 = r6.mCamera     // Catch: java.lang.Throwable -> L50
            r0.release()     // Catch: java.lang.Throwable -> L50
            r6.mCamera = r3     // Catch: java.lang.Throwable -> L50
        L4e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L50
            return
        L50:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L50
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: info.bideens.barcode.camera.CameraSource.stop():void");
    }

    public Size getPreviewSize() {
        return this.mPreviewSize;
    }

    public int getCameraFacing() {
        return this.mFacing;
    }

    public int doZoom(float f2) {
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            int i = 0;
            if (camera == null) {
                return 0;
            }
            Camera.Parameters parameters = camera.getParameters();
            if (!parameters.isZoomSupported()) {
                Log.w(TAG, "Zoom is not supported on this device");
                return 0;
            }
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom() + 1;
            int iRound = Math.round(f2 > 1.0f ? zoom + (f2 * (maxZoom / 10)) : zoom * f2) - 1;
            if (iRound >= 0) {
                i = iRound > maxZoom ? maxZoom : iRound;
            }
            parameters.setZoom(i);
            this.mCamera.setParameters(parameters);
            return i;
        }
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                PictureStartCallback pictureStartCallback = new PictureStartCallback();
                pictureStartCallback.mDelegate = shutterCallback;
                PictureDoneCallback pictureDoneCallback = new PictureDoneCallback();
                pictureDoneCallback.mDelegate = pictureCallback;
                this.mCamera.takePicture(pictureStartCallback, null, null, pictureDoneCallback);
            }
        }
    }

    public String getFocusMode() {
        return this.mFocusMode;
    }

    public boolean setFocusMode(String str) {
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            if (camera != null && str != null) {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters.getSupportedFocusModes().contains(str)) {
                    parameters.setFocusMode(str);
                    this.mCamera.setParameters(parameters);
                    this.mFocusMode = str;
                    return true;
                }
            }
            return false;
        }
    }

    public String getFlashMode() {
        return this.mFlashMode;
    }

    public boolean setFlashMode(String str) {
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            if (camera != null && str != null) {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters.getSupportedFlashModes().contains(str)) {
                    parameters.setFlashMode(str);
                    this.mCamera.setParameters(parameters);
                    this.mFlashMode = str;
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void autoFocus(AutoFocusCallback autoFocusCallback) {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                CameraAutoFocusCallback cameraAutoFocusCallback = null;
                Object[] objArr = 0;
                if (autoFocusCallback != null) {
                    CameraAutoFocusCallback cameraAutoFocusCallback2 = new CameraAutoFocusCallback();
                    cameraAutoFocusCallback2.mDelegate = autoFocusCallback;
                    cameraAutoFocusCallback = cameraAutoFocusCallback2;
                }
                this.mCamera.autoFocus(cameraAutoFocusCallback);
            }
        }
    }

    public void cancelAutoFocus() {
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.cancelAutoFocus();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setAutoFocusMoveCallback(AutoFocusMoveCallback autoFocusMoveCallback) {
        synchronized (this.mCameraLock) {
            if (this.mCamera != null) {
                CameraAutoFocusMoveCallback cameraAutoFocusMoveCallback = null;
                Object[] objArr = 0;
                if (autoFocusMoveCallback != null) {
                    CameraAutoFocusMoveCallback cameraAutoFocusMoveCallback2 = new CameraAutoFocusMoveCallback();
                    cameraAutoFocusMoveCallback2.mDelegate = autoFocusMoveCallback;
                    cameraAutoFocusMoveCallback = cameraAutoFocusMoveCallback2;
                }
                this.mCamera.setAutoFocusMoveCallback(cameraAutoFocusMoveCallback);
            }
        }
        return true;
    }

    private CameraSource() {
        this.mCameraLock = new Object();
        this.mFacing = 0;
        this.mRequestedFps = 30.0f;
        this.mRequestedPreviewWidth = 1024;
        this.mRequestedPreviewHeight = 768;
        this.mFocusMode = null;
        this.mFlashMode = null;
        this.mBytesToByteBuffer = new HashMap();
    }

    private class PictureStartCallback implements Camera.ShutterCallback {
        private ShutterCallback mDelegate;

        private PictureStartCallback() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            ShutterCallback shutterCallback = this.mDelegate;
            if (shutterCallback != null) {
                shutterCallback.onShutter();
            }
        }
    }

    private class PictureDoneCallback implements Camera.PictureCallback {
        private PictureCallback mDelegate;

        private PictureDoneCallback() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            PictureCallback pictureCallback = this.mDelegate;
            if (pictureCallback != null) {
                pictureCallback.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.mCameraLock) {
                if (CameraSource.this.mCamera != null) {
                    CameraSource.this.mCamera.startPreview();
                }
            }
        }
    }

    private class CameraAutoFocusCallback implements Camera.AutoFocusCallback {
        private AutoFocusCallback mDelegate;

        private CameraAutoFocusCallback() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            AutoFocusCallback autoFocusCallback = this.mDelegate;
            if (autoFocusCallback != null) {
                autoFocusCallback.onAutoFocus(z);
            }
        }
    }

    private class CameraAutoFocusMoveCallback implements Camera.AutoFocusMoveCallback {
        private AutoFocusMoveCallback mDelegate;

        private CameraAutoFocusMoveCallback() {
        }

        @Override // android.hardware.Camera.AutoFocusMoveCallback
        public void onAutoFocusMoving(boolean z, Camera camera) {
            AutoFocusMoveCallback autoFocusMoveCallback = this.mDelegate;
            if (autoFocusMoveCallback != null) {
                autoFocusMoveCallback.onAutoFocusMoving(z);
            }
        }
    }

    private Camera createCamera() {
        int idForRequestedCamera = getIdForRequestedCamera(this.mFacing);
        if (idForRequestedCamera == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera cameraOpen = Camera.open(idForRequestedCamera);
        SizePair sizePairSelectSizePair = selectSizePair(cameraOpen, this.mRequestedPreviewWidth, this.mRequestedPreviewHeight);
        if (sizePairSelectSizePair == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size sizePictureSize = sizePairSelectSizePair.pictureSize();
        this.mPreviewSize = sizePairSelectSizePair.previewSize();
        int[] iArrSelectPreviewFpsRange = selectPreviewFpsRange(cameraOpen, this.mRequestedFps);
        if (iArrSelectPreviewFpsRange == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Camera.Parameters parameters = cameraOpen.getParameters();
        if (sizePictureSize != null) {
            parameters.setPictureSize(sizePictureSize.getWidth(), sizePictureSize.getHeight());
        }
        parameters.setPreviewSize(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight());
        parameters.setPreviewFpsRange(iArrSelectPreviewFpsRange[0], iArrSelectPreviewFpsRange[1]);
        parameters.setPreviewFormat(17);
        setRotation(cameraOpen, parameters, idForRequestedCamera);
        if (this.mFocusMode != null) {
            if (parameters.getSupportedFocusModes().contains(this.mFocusMode)) {
                parameters.setFocusMode(this.mFocusMode);
            } else {
                Log.i(TAG, "Camera focus mode: " + this.mFocusMode + " is not supported on this device.");
            }
        }
        this.mFocusMode = parameters.getFocusMode();
        if (this.mFlashMode != null && parameters.getSupportedFlashModes() != null) {
            if (parameters.getSupportedFlashModes().contains(this.mFlashMode)) {
                parameters.setFlashMode(this.mFlashMode);
            } else {
                Log.i(TAG, "Camera flash mode: " + this.mFlashMode + " is not supported on this device.");
            }
        }
        this.mFlashMode = parameters.getFlashMode();
        cameraOpen.setParameters(parameters);
        cameraOpen.setPreviewCallbackWithBuffer(new CameraPreviewCallback());
        cameraOpen.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        cameraOpen.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        cameraOpen.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        cameraOpen.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        return cameraOpen;
    }

    private static int getIdForRequestedCamera(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    private static SizePair selectSizePair(Camera camera, int i, int i2) {
        SizePair sizePair = null;
        int i3 = Integer.MAX_VALUE;
        for (SizePair sizePair2 : generateValidPreviewSizeList(camera)) {
            Size sizePreviewSize = sizePair2.previewSize();
            int iAbs = Math.abs(sizePreviewSize.getWidth() - i) + Math.abs(sizePreviewSize.getHeight() - i2);
            if (iAbs < i3) {
                sizePair = sizePair2;
                i3 = iAbs;
            }
        }
        return sizePair;
    }

    private static class SizePair {
        private Size mPicture;
        private Size mPreview;

        public SizePair(Camera.Size size, Camera.Size size2) {
            this.mPreview = new Size(size.width, size.height);
            if (size2 != null) {
                this.mPicture = new Size(size2.width, size2.height);
            }
        }

        public Size previewSize() {
            return this.mPreview;
        }

        public Size pictureSize() {
            return this.mPicture;
        }
    }

    private static List<SizePair> generateValidPreviewSizeList(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f2 = size.width / size.height;
            Iterator<Camera.Size> it = supportedPictureSizes.iterator();
            while (true) {
                if (it.hasNext()) {
                    Camera.Size next = it.next();
                    if (Math.abs(f2 - (next.width / next.height)) < 0.01f) {
                        arrayList.add(new SizePair(size, next));
                        break;
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w(TAG, "No preview sizes have a corresponding same-aspect-ratio picture size");
            Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
            while (it2.hasNext()) {
                arrayList.add(new SizePair(it2.next(), null));
            }
        }
        return arrayList;
    }

    private int[] selectPreviewFpsRange(Camera camera, float f2) {
        int i = (int) (f2 * 1000.0f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int iAbs = Math.abs(i - iArr2[0]) + Math.abs(i - iArr2[1]);
            if (iAbs < i2) {
                iArr = iArr2;
                i2 = iAbs;
            }
        }
        return iArr;
    }

    private void setRotation(Camera camera, Camera.Parameters parameters, int i) {
        int i2;
        int i3;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i4 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i4 = 90;
            } else if (rotation == 2) {
                i4 = 180;
            } else if (rotation != 3) {
                Log.e(TAG, "Bad rotation value: " + rotation);
            } else {
                i4 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i2 = (cameraInfo.orientation + i4) % CropImageOptionsKt.DEGREES_360;
            i3 = (360 - i2) % CropImageOptionsKt.DEGREES_360;
        } else {
            i2 = ((cameraInfo.orientation - i4) + CropImageOptionsKt.DEGREES_360) % CropImageOptionsKt.DEGREES_360;
            i3 = i2;
        }
        this.mRotation = i2 / 90;
        camera.setDisplayOrientation(i3);
        parameters.setRotation(i2);
    }

    private byte[] createPreviewBuffer(Size size) {
        byte[] bArr = new byte[((int) Math.ceil(((double) ((size.getHeight() * size.getWidth()) * ImageFormat.getBitsPerPixel(17))) / 8.0d)) + 1];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (!byteBufferWrap.hasArray() || byteBufferWrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.mBytesToByteBuffer.put(bArr, byteBufferWrap);
        return bArr;
    }

    private class CameraPreviewCallback implements Camera.PreviewCallback {
        private CameraPreviewCallback() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.mFrameProcessor.setNextFrame(bArr, camera);
        }
    }

    private class FrameProcessingRunnable implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Detector<?> mDetector;
        private ByteBuffer mPendingFrameData;
        private long mPendingTimeMillis;
        private long mStartTimeMillis = SystemClock.elapsedRealtime();
        private final Object mLock = new Object();
        private boolean mActive = true;
        private int mPendingFrameId = 0;

        FrameProcessingRunnable(Detector<?> detector) {
            this.mDetector = detector;
        }

        void release() {
            Detector<?> detector = this.mDetector;
            if (detector != null) {
                detector.release();
                this.mDetector = null;
            }
        }

        void setActive(boolean z) {
            synchronized (this.mLock) {
                this.mActive = z;
                this.mLock.notifyAll();
            }
        }

        void setNextFrame(byte[] bArr, Camera camera) {
            synchronized (this.mLock) {
                ByteBuffer byteBuffer = this.mPendingFrameData;
                if (byteBuffer != null) {
                    camera.addCallbackBuffer(byteBuffer.array());
                    this.mPendingFrameData = null;
                }
                if (!CameraSource.this.mBytesToByteBuffer.containsKey(bArr)) {
                    Log.d(CameraSource.TAG, "Skipping frame.  Could not find ByteBuffer associated with the image data from the camera.");
                    return;
                }
                this.mPendingTimeMillis = SystemClock.elapsedRealtime() - this.mStartTimeMillis;
                this.mPendingFrameId++;
                this.mPendingFrameData = (ByteBuffer) CameraSource.this.mBytesToByteBuffer.get(bArr);
                this.mLock.notifyAll();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Frame frameBuild;
            while (true) {
                synchronized (this.mLock) {
                    while (true) {
                        z = this.mActive;
                        if (!z || this.mPendingFrameData != null) {
                            break;
                        }
                        try {
                            this.mLock.wait();
                        } catch (InterruptedException e2) {
                            Log.d(CameraSource.TAG, "Frame processing loop terminated.", e2);
                            return;
                        }
                    }
                    if (!z) {
                        return;
                    }
                    frameBuild = new Frame.Builder().setImageData(this.mPendingFrameData, CameraSource.this.mPreviewSize.getWidth(), CameraSource.this.mPreviewSize.getHeight(), 17).setId(this.mPendingFrameId).setTimestampMillis(this.mPendingTimeMillis).setRotation(CameraSource.this.mRotation).build();
                    ByteBuffer byteBuffer = this.mPendingFrameData;
                    this.mPendingFrameData = null;
                }
                try {
                    this.mDetector.receiveFrame(frameBuild);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }
}
