package com.google.android.gms.internal.vision;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzew extends zzee<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzew(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final boolean zzf() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzde.zza(i, this.zzc);
        return this.zza[(i * 2) + this.zzb];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
