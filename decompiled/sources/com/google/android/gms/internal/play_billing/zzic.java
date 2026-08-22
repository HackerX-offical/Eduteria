package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzic {
    public static final /* synthetic */ int zza = 0;
    private static final zzic zzb = new zzic();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzig zzc = new zzhm();

    private zzic() {
    }

    public static zzic zza() {
        return zzb;
    }

    public final zzif zzb(Class cls) {
        zzgx.zzc(cls, "messageType");
        zzif zzifVar = (zzif) this.zzd.get(cls);
        if (zzifVar != null) {
            return zzifVar;
        }
        zzif zzifVarZza = this.zzc.zza(cls);
        zzgx.zzc(cls, "messageType");
        zzif zzifVar2 = (zzif) this.zzd.putIfAbsent(cls, zzifVarZza);
        return zzifVar2 == null ? zzifVarZza : zzifVar2;
    }
}
