package com.google.android.gms.internal.vision;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzep<E> extends zzee<E> {
    static final zzee<Object> zza = new zzep(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzep(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final boolean zzf() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.vision.zzee, com.google.android.gms.internal.vision.zzeb
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzde.zza(i, this.zzc);
        return (E) this.zzb[i];
    }
}
