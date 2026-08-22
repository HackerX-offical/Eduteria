package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzby {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzbx zzc;

    public final zzby zza(Object obj, Object obj2) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzbq.zzc(length, i2));
        }
        zzbe.zzb(obj, obj2);
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.zzb = i3 + 1;
        return this;
    }

    public final zzbz zzb() {
        zzbx zzbxVar = this.zzc;
        if (zzbxVar != null) {
            throw zzbxVar.zza();
        }
        zzcx zzcxVarZzg = zzcx.zzg(this.zzb, this.zza, this);
        zzbx zzbxVar2 = this.zzc;
        if (zzbxVar2 == null) {
            return zzcxVarZzg;
        }
        throw zzbxVar2.zza();
    }
}
