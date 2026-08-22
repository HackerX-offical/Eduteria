package info.bideens.barcode;

import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;
import info.bideens.barcode.BarcodeGraphicTracker;
import info.bideens.barcode.camera.GraphicOverlay;

/* JADX INFO: loaded from: classes9.dex */
class BarcodeTrackerFactory implements MultiProcessor.Factory<Barcode> {
    private BarcodeGraphicTracker.BarcodeGraphicTrackerListener listener;
    private GraphicOverlay<BarcodeGraphic> mGraphicOverlay;

    BarcodeTrackerFactory(GraphicOverlay<BarcodeGraphic> graphicOverlay, BarcodeGraphicTracker.BarcodeGraphicTrackerListener barcodeGraphicTrackerListener) {
        this.mGraphicOverlay = graphicOverlay;
        this.listener = barcodeGraphicTrackerListener;
    }

    @Override // com.google.android.gms.vision.MultiProcessor.Factory
    public Tracker<Barcode> create(Barcode barcode) {
        return new BarcodeGraphicTracker(this.mGraphicOverlay, new BarcodeGraphic(this.mGraphicOverlay), this.listener);
    }
}
