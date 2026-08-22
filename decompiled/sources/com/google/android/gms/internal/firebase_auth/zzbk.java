package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbk<K, V> {
    private Object[] zza;
    private int zzb;
    private boolean zzc;

    public zzbk() {
        this(4);
    }

    private zzbk(int i) {
        this.zza = new Object[8];
        this.zzb = 0;
        this.zzc = false;
    }

    public final zzbk<K, V> zza(K k, V v) {
        int i = (this.zzb + 1) << 1;
        Object[] objArr = this.zza;
        if (i > objArr.length) {
            int length = objArr.length;
            if (i < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = length + (length >> 1) + 1;
            if (iHighestOneBit < i) {
                iHighestOneBit = Integer.highestOneBit(i - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                iHighestOneBit = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, iHighestOneBit);
            this.zzc = false;
        }
        zzbf.zza(k, v);
        Object[] objArr2 = this.zza;
        int i2 = this.zzb;
        objArr2[i2 * 2] = k;
        objArr2[(i2 * 2) + 1] = v;
        this.zzb = i2 + 1;
        return this;
    }

    public final zzbl<K, V> zza() {
        this.zzc = true;
        return zzbp.zza(this.zzb, this.zza);
    }
}
