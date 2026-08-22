package info.bideens.barcode;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;
import info.bideens.barcode.camera.GraphicOverlay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
class BarcodeGraphicTracker extends Tracker<Barcode> {
    private BarcodeGraphicTrackerListener listener;
    private BarcodeGraphic mGraphic;
    private GraphicOverlay<BarcodeGraphic> mOverlay;

    public interface BarcodeGraphicTrackerListener {
        void onBitmapScanned(SparseArray<Barcode> sparseArray);

        void onScanError(String str);

        void onScanned(Barcode barcode);

        void onScannedMultiple(List<Barcode> list);
    }

    BarcodeGraphicTracker(GraphicOverlay<BarcodeGraphic> graphicOverlay, BarcodeGraphic barcodeGraphic, BarcodeGraphicTrackerListener barcodeGraphicTrackerListener) {
        this.mOverlay = graphicOverlay;
        this.mGraphic = barcodeGraphic;
        this.listener = barcodeGraphicTrackerListener;
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onNewItem(int i, Barcode barcode) {
        this.mGraphic.setId(i);
        Log.e("XX", "barcode detected: " + barcode.displayValue + ", listener: " + this.listener);
        BarcodeGraphicTrackerListener barcodeGraphicTrackerListener = this.listener;
        if (barcodeGraphicTrackerListener != null) {
            barcodeGraphicTrackerListener.onScanned(barcode);
        }
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onUpdate(Detector.Detections<Barcode> detections, Barcode barcode) {
        this.mOverlay.add(this.mGraphic);
        this.mGraphic.updateItem(barcode);
        if (detections == null || detections.getDetectedItems().size() <= 1) {
            return;
        }
        Log.e("XX", "Multiple items detected");
        Log.e("XX", "onUpdate: " + detections.getDetectedItems().size());
        if (this.listener != null) {
            this.listener.onScannedMultiple(asList(detections.getDetectedItems()));
        }
    }

    public static <C> List<C> asList(SparseArray<C> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.valueAt(i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onMissing(Detector.Detections<Barcode> detections) {
        this.mOverlay.remove(this.mGraphic);
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onDone() {
        this.mOverlay.remove(this.mGraphic);
    }
}
