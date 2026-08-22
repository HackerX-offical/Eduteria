package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class BarcodeDetector extends Detector<Barcode> {
    private final com.google.android.gms.internal.vision.zzm zza;

    private BarcodeDetector() {
        throw new IllegalStateException("Default constructor called");
    }

    private BarcodeDetector(com.google.android.gms.internal.vision.zzm zzmVar) {
        this.zza = zzmVar;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
    public static class Builder {
        private Context zza;
        private com.google.android.gms.internal.vision.zzk zzb = new com.google.android.gms.internal.vision.zzk();

        public Builder(Context context) {
            this.zza = context;
        }

        public Builder setBarcodeFormats(int i) {
            this.zzb.zza = i;
            return this;
        }

        public BarcodeDetector build() {
            return new BarcodeDetector(new com.google.android.gms.internal.vision.zzm(this.zza, this.zzb));
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public final void release() {
        super.release();
        this.zza.zzc();
    }

    @Override // com.google.android.gms.vision.Detector
    public final SparseArray<Barcode> detect(Frame frame) {
        Barcode[] barcodeArrZza;
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        zzs zzsVarZza = zzs.zza(frame);
        if (frame.getBitmap() != null) {
            barcodeArrZza = this.zza.zza((Bitmap) Preconditions.checkNotNull(frame.getBitmap()), zzsVarZza);
            if (barcodeArrZza == null) {
                throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
            }
        } else if (frame.getPlanes() != null) {
            barcodeArrZza = this.zza.zza((ByteBuffer) Preconditions.checkNotNull(((Image.Plane[]) Preconditions.checkNotNull(frame.getPlanes()))[0].getBuffer()), new zzs(((Image.Plane[]) Preconditions.checkNotNull(frame.getPlanes()))[0].getRowStride(), zzsVarZza.zzb, zzsVarZza.zzc, zzsVarZza.zzd, zzsVarZza.zze));
        } else {
            barcodeArrZza = this.zza.zza((ByteBuffer) Preconditions.checkNotNull(frame.getGrayscaleImageData()), zzsVarZza);
        }
        SparseArray<Barcode> sparseArray = new SparseArray<>(barcodeArrZza.length);
        for (Barcode barcode : barcodeArrZza) {
            sparseArray.append(barcode.rawValue.hashCode(), barcode);
        }
        return sparseArray;
    }

    @Override // com.google.android.gms.vision.Detector
    public final boolean isOperational() {
        return this.zza.zzb();
    }
}
