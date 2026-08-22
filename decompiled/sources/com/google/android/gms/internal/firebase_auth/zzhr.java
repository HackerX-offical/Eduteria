package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzhr {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzhr zzc;
    private static volatile zzhr zzd;
    private static final zzhr zze = new zzhr(true);
    private final Map<zza, zzie.zzf<?, ?>> zzf;

    public static zzhr zza() {
        zzhr zzhrVar;
        zzhr zzhrVar2 = zzc;
        if (zzhrVar2 != null) {
            return zzhrVar2;
        }
        synchronized (zzhr.class) {
            zzhrVar = zzc;
            if (zzhrVar == null) {
                zzhrVar = zze;
                zzc = zzhrVar;
            }
        }
        return zzhrVar;
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }
    }

    public static zzhr zzb() {
        zzhr zzhrVar = zzd;
        if (zzhrVar != null) {
            return zzhrVar;
        }
        synchronized (zzhr.class) {
            zzhr zzhrVar2 = zzd;
            if (zzhrVar2 != null) {
                return zzhrVar2;
            }
            zzhr zzhrVarZza = zzic.zza(zzhr.class);
            zzd = zzhrVarZza;
            return zzhrVarZza;
        }
    }

    public final <ContainingType extends zzjp> zzie.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzie.zzf) this.zzf.get(new zza(containingtype, i));
    }

    zzhr() {
        this.zzf = new HashMap();
    }

    private zzhr(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
