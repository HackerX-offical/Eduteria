package com.google.android.gms.internal.vision;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzed<E> extends zzdm<E> {
    private final zzee<E> zza;

    zzed(zzee<E> zzeeVar, int i) {
        super(zzeeVar.size(), i);
        this.zza = zzeeVar;
    }

    @Override // com.google.android.gms.internal.vision.zzdm
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
