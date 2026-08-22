package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzfz extends zzfk {
    private static final Logger zzb = Logger.getLogger(zzfz.class.getName());
    private static final boolean zzc = zziy.zzx();
    zzga zza;

    private zzfz() {
        throw null;
    }

    /* synthetic */ zzfz(zzfy zzfyVar) {
    }

    public static int zzA(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    static int zzw(int i, zzhu zzhuVar, zzif zzifVar) {
        int iZzz = zzz(i << 3);
        return iZzz + iZzz + ((zzfd) zzhuVar).zze(zzifVar);
    }

    static int zzx(zzhu zzhuVar, zzif zzifVar) {
        int iZze = ((zzfd) zzhuVar).zze(zzifVar);
        return zzz(iZze) + iZze;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzjb.zzc(str);
        } catch (zzja unused) {
            length = str.getBytes(zzgx.zza).length;
        }
        return zzz(length) + length;
    }

    public static int zzz(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void zzB() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzC(String str, zzja zzjaVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzjaVar);
        byte[] bytes = str.getBytes(zzgx.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzfx(e2);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b2) throws IOException;

    public abstract void zzd(int i, boolean z) throws IOException;

    public abstract void zze(int i, zzfs zzfsVar) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    abstract void zzm(int i, zzhu zzhuVar, zzif zzifVar) throws IOException;

    public abstract void zzn(int i, zzhu zzhuVar) throws IOException;

    public abstract void zzo(int i, zzfs zzfsVar) throws IOException;

    public abstract void zzp(int i, String str) throws IOException;

    public abstract void zzr(int i, int i2) throws IOException;

    public abstract void zzs(int i, int i2) throws IOException;

    public abstract void zzt(int i) throws IOException;

    public abstract void zzu(int i, long j) throws IOException;

    public abstract void zzv(long j) throws IOException;
}
