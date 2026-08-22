package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzhf {
    int zza;
    int zzb;
    int zzc;
    zzhm zzd;
    private boolean zze;

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static zzhf zza(byte[] bArr, int i, int i2, boolean z) {
        zzhh zzhhVar = new zzhh(bArr, 0, i2, false);
        try {
            zzhhVar.zzc(i2);
            return zzhhVar;
        } catch (zzip e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zza() throws IOException;

    public abstract void zza(int i) throws zzip;

    public abstract double zzb() throws IOException;

    public abstract boolean zzb(int i) throws IOException;

    public abstract float zzc() throws IOException;

    public abstract int zzc(int i) throws zzip;

    public abstract long zzd() throws IOException;

    public abstract void zzd(int i);

    public abstract long zze() throws IOException;

    public abstract int zzf() throws IOException;

    public abstract long zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract boolean zzi() throws IOException;

    public abstract String zzj() throws IOException;

    public abstract String zzk() throws IOException;

    public abstract zzgt zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract int zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract int zzq() throws IOException;

    public abstract long zzr() throws IOException;

    abstract long zzs() throws IOException;

    public abstract boolean zzt() throws IOException;

    public abstract int zzu();

    private zzhf() {
        this.zzb = 100;
        this.zzc = Integer.MAX_VALUE;
        this.zze = false;
    }
}
