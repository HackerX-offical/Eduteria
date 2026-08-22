package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzgt implements Serializable, Iterable<Byte> {
    public static final zzgt zza = new zzhd(zzig.zzb);
    private static final zzgz zzb;
    private static final Comparator<zzgt> zzd;
    private int zzc = 0;

    zzgt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b2) {
        return b2 & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract int zza();

    protected abstract int zza(int i, int i2, int i3);

    public abstract zzgt zza(int i, int i2);

    protected abstract String zza(Charset charset);

    abstract void zza(zzgu zzguVar) throws IOException;

    abstract byte zzb(int i);

    public abstract boolean zzc();

    public static zzgt zza(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzhd(zzb.zza(bArr, i, i2));
    }

    public static zzgt zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    static zzgt zzb(byte[] bArr) {
        return new zzhd(bArr);
    }

    public static zzgt zza(String str) {
        return new zzhd(str.getBytes(zzig.zza));
    }

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzig.zza);
    }

    public final int hashCode() {
        int iZza = this.zzc;
        if (iZza == 0) {
            int iZza2 = zza();
            iZza = zza(iZza2, 0, iZza2);
            if (iZza == 0) {
                iZza = 1;
            }
            this.zzc = iZza;
        }
        return iZza;
    }

    static zzhb zzc(int i) {
        return new zzhb(i, null);
    }

    protected final int zzd() {
        return this.zzc;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i).append(" < 0").toString());
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i).append(", ").append(i2).toString());
        }
        throw new IndexOutOfBoundsException(new StringBuilder(37).append("End index: ").append(i2).append(" >= ").append(i3).toString());
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza()), zza() <= 50 ? zzkt.zza(this) : String.valueOf(zzkt.zza(zza(0, 47))).concat("..."));
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzgw(this);
    }

    static {
        zzgw zzgwVar = null;
        zzb = zzgs.zza() ? new zzhg(zzgwVar) : new zzgx(zzgwVar);
        zzd = new zzgv();
    }
}
