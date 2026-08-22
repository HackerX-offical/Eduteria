package com.google.android.gms.internal.firebase_auth;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzig {
    public static final byte[] zzb;
    private static final ByteBuffer zzd;
    private static final zzhf zze;
    static final Charset zza = Charset.forName("UTF-8");
    private static final Charset zzc = Charset.forName("ISO-8859-1");

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T zza(T t) {
        t.getClass();
        return t;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zza(byte[] bArr) {
        return zzlg.zza(bArr);
    }

    public static String zzb(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        int iZza = zza(length, bArr, 0, length);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static boolean zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzgn)) {
            return false;
        }
        return false;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzjp) obj).zzae().zza((zzjp) obj2).zze();
    }

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zzd = ByteBuffer.wrap(bArr);
        zze = zzhf.zza(bArr, 0, bArr.length, false);
    }
}
