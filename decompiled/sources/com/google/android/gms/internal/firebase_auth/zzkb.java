package com.google.android.gms.internal.firebase_auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkb {
    private static final zzkb zza = new zzkb();
    private final ConcurrentMap<Class<?>, zzkf<?>> zzc = new ConcurrentHashMap();
    private final zzke zzb = new zzjc();

    public static zzkb zza() {
        return zza;
    }

    public final <T> zzkf<T> zza(Class<T> cls) {
        zzig.zza(cls, "messageType");
        zzkf<T> zzkfVarZza = (zzkf) this.zzc.get(cls);
        if (zzkfVarZza == null) {
            zzkfVarZza = this.zzb.zza(cls);
            zzig.zza(cls, "messageType");
            zzig.zza(zzkfVarZza, "schema");
            zzkf<T> zzkfVar = (zzkf) this.zzc.putIfAbsent(cls, zzkfVarZza);
            if (zzkfVar != null) {
                return zzkfVar;
            }
        }
        return zzkfVarZza;
    }

    public final <T> zzkf<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzkb() {
    }
}
