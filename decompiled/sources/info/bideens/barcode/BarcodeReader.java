package info.bideens.barcode;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.tv9news.utils.helpers.AnalyticsConstants;
import info.bideens.barcode.BarcodeGraphicTracker;
import info.bideens.barcode.camera.CameraSource;
import info.bideens.barcode.camera.CameraSourcePreview;
import info.bideens.barcode.camera.GraphicOverlay;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class BarcodeReader extends Fragment implements View.OnTouchListener, BarcodeGraphicTracker.BarcodeGraphicTrackerListener {
    public static final String BarcodeObject = "Barcode";
    private static final int PERMISSION_CALLBACK_CONSTANT = 101;
    private static final int RC_HANDLE_GMS = 9001;
    private static final int REQUEST_PERMISSION_SETTING = 102;
    private static final String TAG = "BarcodeReader";
    private String beepSoundFile;
    private GestureDetector gestureDetector;
    private CameraSource mCameraSource;
    private GraphicOverlay<BarcodeGraphic> mGraphicOverlay;
    private BarcodeReaderListener mListener;
    private CameraSourcePreview mPreview;
    private SharedPreferences permissionStatus;
    private ScaleGestureDetector scaleGestureDetector;
    private boolean autoFocus = false;
    private boolean useFlash = false;
    private boolean isPaused = false;
    private boolean sentToSettings = false;

    public interface BarcodeReaderListener {
        void onBitmapScanned(SparseArray<Barcode> sparseArray);

        void onCameraPermissionDenied();

        void onScanError(String str);

        void onScanned(Barcode barcode);

        void onScannedMultiple(List<Barcode> list);
    }

    public void setListener(BarcodeReaderListener barcodeReaderListener) {
        this.mListener = barcodeReaderListener;
    }

    public void setBeepSoundFile(String str) {
        this.beepSoundFile = str;
    }

    public void pauseScanning() {
        this.isPaused = true;
    }

    public void resumeScanning() {
        this.isPaused = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_barcode_reader, viewGroup, false);
        FragmentActivity activity = getActivity();
        getActivity();
        this.permissionStatus = activity.getSharedPreferences("permissionStatus", 0);
        this.mPreview = (CameraSourcePreview) viewInflate.findViewById(R.id.preview);
        this.mGraphicOverlay = (GraphicOverlay) viewInflate.findViewById(R.id.graphicOverlay);
        this.gestureDetector = new GestureDetector(getActivity(), new CaptureGestureListener());
        this.scaleGestureDetector = new ScaleGestureDetector(getActivity(), new ScaleListener());
        viewInflate.setOnTouchListener(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BarcodeReader);
        this.autoFocus = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BarcodeReader_auto_focus, true);
        this.useFlash = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BarcodeReader_use_flash, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BarcodeReaderListener) {
            this.mListener = (BarcodeReaderListener) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        getActivity();
        this.permissionStatus = activity.getSharedPreferences("permissionStatus", 0);
        if (ActivityCompat.checkSelfPermission(getActivity(), "android.permission.CAMERA") != 0) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), "android.permission.CAMERA")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(getString(R.string.grant_permission));
                builder.setMessage(getString(R.string.permission_camera));
                builder.setPositiveButton(R.string.grant, new DialogInterface.OnClickListener() { // from class: info.bideens.barcode.BarcodeReader.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        BarcodeReader.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 101);
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: info.bideens.barcode.BarcodeReader.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        BarcodeReader.this.mListener.onCameraPermissionDenied();
                    }
                });
                builder.show();
            } else if (this.permissionStatus.getBoolean("android.permission.CAMERA", false)) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                builder2.setTitle(getString(R.string.grant_permission));
                builder2.setMessage(getString(R.string.permission_camera));
                builder2.setPositiveButton(R.string.grant, new DialogInterface.OnClickListener() { // from class: info.bideens.barcode.BarcodeReader.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        BarcodeReader.this.sentToSettings = true;
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts(AnalyticsConstants.PACKAGE, BarcodeReader.this.getActivity().getPackageName(), null));
                        BarcodeReader.this.startActivityForResult(intent, 102);
                    }
                });
                builder2.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: info.bideens.barcode.BarcodeReader.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        BarcodeReader.this.mListener.onCameraPermissionDenied();
                    }
                });
                builder2.show();
            } else {
                requestPermissions(new String[]{"android.permission.CAMERA"}, 101);
            }
            SharedPreferences.Editor editorEdit = this.permissionStatus.edit();
            editorEdit.putBoolean("android.permission.CAMERA", true);
            editorEdit.commit();
            return;
        }
        proceedAfterPermission();
    }

    private void proceedAfterPermission() {
        createCameraSource(this.autoFocus, this.useFlash);
    }

    private void createCameraSource(boolean z, boolean z2) {
        String str = TAG;
        Log.e(str, "createCameraSource:");
        BarcodeDetector barcodeDetectorBuild = new BarcodeDetector.Builder(getActivity()).build();
        barcodeDetectorBuild.setProcessor(new MultiProcessor.Builder(new BarcodeTrackerFactory(this.mGraphicOverlay, this)).build());
        if (!barcodeDetectorBuild.isOperational()) {
            Log.w(str, "Detector dependencies are not yet available.");
            if (getActivity().registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) != null) {
                Toast.makeText(getActivity(), R.string.low_storage_error, 1).show();
                Log.w(str, getString(R.string.low_storage_error));
            }
        }
        this.mCameraSource = new CameraSource.Builder(getActivity(), barcodeDetectorBuild).setFacing(0).setRequestedPreviewSize(WindowSizeClass.WIDTH_DP_EXTRA_LARGE_LOWER_BOUND, 1024).setRequestedFps(15.0f).setFocusMode(z ? "continuous-picture" : null).setFlashMode(z2 ? "torch" : null).build();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        startCameraSource();
        if (this.sentToSettings) {
            if (ActivityCompat.checkSelfPermission(getActivity(), "android.permission.CAMERA") == 0) {
                proceedAfterPermission();
            } else {
                this.mListener.onCameraPermissionDenied();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.stop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.release();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 101) {
            boolean z = false;
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                if (i2 >= iArr.length) {
                    z = z2;
                    break;
                } else {
                    if (iArr[i2] != 0) {
                        break;
                    }
                    i2++;
                    z2 = true;
                }
            }
            if (z) {
                proceedAfterPermission();
                return;
            }
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), "android.permission.CAMERA")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(getString(R.string.grant_permission));
                builder.setMessage(getString(R.string.permission_camera));
                builder.setPositiveButton(R.string.grant, new DialogInterface.OnClickListener() { // from class: info.bideens.barcode.BarcodeReader.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        dialogInterface.cancel();
                        BarcodeReader.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 101);
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: info.bideens.barcode.BarcodeReader.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        dialogInterface.cancel();
                        BarcodeReader.this.mListener.onCameraPermissionDenied();
                    }
                });
                builder.show();
                return;
            }
            this.mListener.onCameraPermissionDenied();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 102 && ActivityCompat.checkSelfPermission(getActivity(), "android.permission.CAMERA") == 0) {
            proceedAfterPermission();
        }
    }

    private void startCameraSource() throws SecurityException {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getActivity());
        if (iIsGooglePlayServicesAvailable != 0) {
            GoogleApiAvailability.getInstance().getErrorDialog(getActivity(), iIsGooglePlayServicesAvailable, RC_HANDLE_GMS).show();
        }
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            try {
                this.mPreview.start(cameraSource, this.mGraphicOverlay);
            } catch (IOException e2) {
                Log.e(TAG, "Unable to start camera source.", e2);
                this.mCameraSource.release();
                this.mCameraSource = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onTap(float f2, float f3) {
        this.mGraphicOverlay.getLocationOnScreen(new int[2]);
        float widthScaleFactor = (f2 - r0[0]) / this.mGraphicOverlay.getWidthScaleFactor();
        float heightScaleFactor = (f3 - r0[1]) / this.mGraphicOverlay.getHeightScaleFactor();
        Iterator it = this.mGraphicOverlay.getGraphics().iterator();
        Barcode barcode = null;
        float f4 = Float.MAX_VALUE;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Barcode barcode2 = ((BarcodeGraphic) it.next()).getBarcode();
            if (barcode2.getBoundingBox().contains((int) widthScaleFactor, (int) heightScaleFactor)) {
                barcode = barcode2;
                break;
            }
            float fCenterX = widthScaleFactor - barcode2.getBoundingBox().centerX();
            float fCenterY = heightScaleFactor - barcode2.getBoundingBox().centerY();
            float f5 = (fCenterX * fCenterX) + (fCenterY * fCenterY);
            if (f5 < f4) {
                barcode = barcode2;
                f4 = f5;
            }
        }
        if (barcode == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra(BarcodeObject, barcode);
        getActivity().setResult(0, intent);
        getActivity().finish();
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.scaleGestureDetector.onTouchEvent(motionEvent) || this.gestureDetector.onTouchEvent(motionEvent) || view.onTouchEvent(motionEvent);
    }

    @Override // info.bideens.barcode.BarcodeGraphicTracker.BarcodeGraphicTrackerListener
    public void onScanned(Barcode barcode) {
        BarcodeReaderListener barcodeReaderListener = this.mListener;
        if (barcodeReaderListener == null || this.isPaused) {
            return;
        }
        barcodeReaderListener.onScanned(barcode);
    }

    @Override // info.bideens.barcode.BarcodeGraphicTracker.BarcodeGraphicTrackerListener
    public void onScannedMultiple(List<Barcode> list) {
        BarcodeReaderListener barcodeReaderListener = this.mListener;
        if (barcodeReaderListener == null || this.isPaused) {
            return;
        }
        barcodeReaderListener.onScannedMultiple(list);
    }

    @Override // info.bideens.barcode.BarcodeGraphicTracker.BarcodeGraphicTrackerListener
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {
        BarcodeReaderListener barcodeReaderListener = this.mListener;
        if (barcodeReaderListener != null) {
            barcodeReaderListener.onBitmapScanned(sparseArray);
        }
    }

    @Override // info.bideens.barcode.BarcodeGraphicTracker.BarcodeGraphicTrackerListener
    public void onScanError(String str) {
        BarcodeReaderListener barcodeReaderListener = this.mListener;
        if (barcodeReaderListener != null) {
            barcodeReaderListener.onScanError(str);
        }
    }

    private class CaptureGestureListener extends GestureDetector.SimpleOnGestureListener {
        private CaptureGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return BarcodeReader.this.onTap(motionEvent.getRawX(), motionEvent.getRawY()) || super.onSingleTapConfirmed(motionEvent);
        }
    }

    private class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener {
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            BarcodeReader.this.mCameraSource.doZoom(scaleGestureDetector.getScaleFactor());
        }
    }

    public void playBeep() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = new MediaPlayer();
            }
            MediaPlayer mediaPlayer2 = mediaPlayer;
            AssetManager assets = getActivity().getAssets();
            String str = this.beepSoundFile;
            if (str == null) {
                str = "beep.mp3";
            }
            AssetFileDescriptor assetFileDescriptorOpenFd = assets.openFd(str);
            mediaPlayer2.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
            assetFileDescriptorOpenFd.close();
            mediaPlayer2.prepare();
            mediaPlayer2.setVolume(1.0f, 1.0f);
            mediaPlayer2.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
