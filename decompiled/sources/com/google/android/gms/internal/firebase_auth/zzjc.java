package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjc implements zzke {
    private static final zzjm zzb = new zzjf();
    private final zzjm zza;

    public zzjc() {
        this(new zzje(zzif.zza(), zza()));
    }

    private zzjc(zzjm zzjmVar) {
        this.zza = (zzjm) zzig.zza(zzjmVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzke
    public final <T> zzkf<T> zza(Class<T> cls) {
        zzkh.zza((Class<?>) cls);
        zzjn zzjnVarZzb = this.zza.zzb(cls);
        if (zzjnVarZzb.zzb()) {
            if (zzie.class.isAssignableFrom(cls)) {
                return zzjs.zza(zzkh.zzc(), zzhu.zza(), zzjnVarZzb.zzc());
            }
            return zzjs.zza(zzkh.zza(), zzhu.zzb(), zzjnVarZzb.zzc());
        }
        if (zzie.class.isAssignableFrom(cls)) {
            if (zza(zzjnVarZzb)) {
                return zzjt.zza(cls, zzjnVarZzb, zzjw.zzb(), zziz.zzb(), zzkh.zzc(), zzhu.zza(), zzjk.zzb());
            }
            return zzjt.zza(cls, zzjnVarZzb, zzjw.zzb(), zziz.zzb(), zzkh.zzc(), null, zzjk.zzb());
        }
        if (zza(zzjnVarZzb)) {
            return zzjt.zza(cls, zzjnVarZzb, zzjw.zza(), zziz.zza(), zzkh.zza(), zzhu.zzb(), zzjk.zza());
        }
        return zzjt.zza(cls, zzjnVarZzb, zzjw.zza(), zziz.zza(), zzkh.zzb(), null, zzjk.zza());
    }

    private static boolean zza(zzjn zzjnVar) {
        return zzjnVar.zza() == zzie.zze.zzh;
    }

    private static zzjm zza() {
        try {
            return (zzjm) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
