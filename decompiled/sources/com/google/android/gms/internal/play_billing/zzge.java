package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzge {
    static final zzge zza = new zzge(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzge zzd;
    private final Map zze;

    zzge() {
        this.zze = new HashMap();
    }

    public static zzge zza() {
        zzge zzgeVar = zzd;
        if (zzgeVar != null) {
            return zzgeVar;
        }
        synchronized (zzge.class) {
            zzge zzgeVar2 = zzd;
            if (zzgeVar2 != null) {
                return zzgeVar2;
            }
            int i = zzic.zza;
            zzge zzgeVarZzb = zzgm.zzb(zzge.class);
            zzd = zzgeVarZzb;
            return zzgeVarZzb;
        }
    }

    public final zzgr zzb(zzhu zzhuVar, int i) {
        return (zzgr) this.zze.get(new zzgd(zzhuVar, i));
    }

    zzge(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
