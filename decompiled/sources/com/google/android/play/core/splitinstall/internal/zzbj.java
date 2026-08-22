package com.google.android.play.core.splitinstall.internal;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzbj {
    private final Object zza;
    private final Field zzb;
    private final Class zzc;

    zzbj(Object obj, Field field, Class cls) {
        this.zza = obj;
        this.zzb = field;
        this.zzc = cls;
    }

    public final Object zzc() {
        try {
            return this.zzc.cast(this.zzb.get(this.zza));
        } catch (Exception e2) {
            throw new zzbl(String.format("Failed to get value of field %s of type %s on object of type %s", this.zzb.getName(), this.zza.getClass().getName(), this.zzc.getName()), e2);
        }
    }

    protected final Field zzd() {
        return this.zzb;
    }

    public final void zze(Object obj) {
        try {
            this.zzb.set(this.zza, obj);
        } catch (Exception e2) {
            throw new zzbl(String.format("Failed to set value of field %s of type %s on object of type %s", this.zzb.getName(), this.zza.getClass().getName(), this.zzc.getName()), e2);
        }
    }
}
