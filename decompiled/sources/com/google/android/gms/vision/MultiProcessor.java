package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public class MultiProcessor<T> implements Detector.Processor<T> {
    private Factory<T> zza;
    private SparseArray<zza> zzb;
    private int zzc;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        for (int i = 0; i < this.zzb.size(); i++) {
            this.zzb.valueAt(i).zza.onDone();
        }
        this.zzb.clear();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private class zza {
        private Tracker<T> zza;
        private int zzb;

        private zza(MultiProcessor multiProcessor) {
            this.zzb = 0;
        }

        static /* synthetic */ int zzb(zza zzaVar) {
            int i = zzaVar.zzb;
            zzaVar.zzb = i + 1;
            return i;
        }

        static /* synthetic */ int zza(zza zzaVar, int i) {
            zzaVar.zzb = 0;
            return 0;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static class Builder<T> {
        private MultiProcessor<T> zza;

        public Builder(Factory<T> factory) {
            MultiProcessor<T> multiProcessor = new MultiProcessor<>();
            this.zza = multiProcessor;
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            ((MultiProcessor) multiProcessor).zza = factory;
        }

        public Builder<T> setMaxGapFrames(int i) {
            if (i < 0) {
                throw new IllegalArgumentException(new StringBuilder(28).append("Invalid max gap: ").append(i).toString());
            }
            ((MultiProcessor) this.zza).zzc = i;
            return this;
        }

        public MultiProcessor<T> build() {
            return this.zza;
        }
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int iKeyAt = detectedItems.keyAt(i);
            T tValueAt = detectedItems.valueAt(i);
            if (this.zzb.get(iKeyAt) == null) {
                zza zzaVar = new zza();
                zzaVar.zza = this.zza.create(tValueAt);
                zzaVar.zza.onNewItem(iKeyAt, tValueAt);
                this.zzb.append(iKeyAt, zzaVar);
            }
        }
        SparseArray<T> detectedItems2 = detections.getDetectedItems();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            int iKeyAt2 = this.zzb.keyAt(i2);
            if (detectedItems2.get(iKeyAt2) == null) {
                zza zzaVarValueAt = this.zzb.valueAt(i2);
                zza.zzb(zzaVarValueAt);
                if (zzaVarValueAt.zzb >= this.zzc) {
                    zzaVarValueAt.zza.onDone();
                    hashSet.add(Integer.valueOf(iKeyAt2));
                } else {
                    zzaVarValueAt.zza.onMissing(detections);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.zzb.delete(((Integer) it.next()).intValue());
        }
        SparseArray<T> detectedItems3 = detections.getDetectedItems();
        for (int i3 = 0; i3 < detectedItems3.size(); i3++) {
            int iKeyAt3 = detectedItems3.keyAt(i3);
            T tValueAt2 = detectedItems3.valueAt(i3);
            zza zzaVar2 = this.zzb.get(iKeyAt3);
            zza.zza(zzaVar2, 0);
            zzaVar2.zza.onUpdate(detections, tValueAt2);
        }
    }

    private MultiProcessor() {
        this.zzb = new SparseArray<>();
        this.zzc = 3;
    }
}
