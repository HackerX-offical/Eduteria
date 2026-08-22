package com.google.android.gms.internal.vision;

import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzeg<E> extends zzee<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzee zzc;

    zzeg(zzee zzeeVar, int i, int i2) {
        this.zzc = zzeeVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final boolean zzf() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzde.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.vision.zzee
    /* JADX INFO: renamed from: zza */
    public final zzee<E> subList(int i, int i2) {
        zzde.zza(i, i2, this.zzb);
        zzee zzeeVar = this.zzc;
        int i3 = this.zza;
        return (zzee) zzeeVar.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.vision.zzee, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
