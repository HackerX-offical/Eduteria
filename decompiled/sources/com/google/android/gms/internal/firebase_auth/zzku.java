package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzku extends zzie<zzku, zza> implements zzjr {
    private static final zzku zze;
    private static volatile zzjz<zzku> zzf;
    private long zzc;
    private int zzd;

    private zzku() {
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zza extends zzie.zzb<zzku, zza> implements zzjr {
        private zza() {
            super(zzku.zze);
        }

        /* synthetic */ zza(zzkw zzkwVar) {
            this();
        }
    }

    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzie
    protected final Object zza(int i, Object obj, Object obj2) {
        zzjz zzaVar;
        zzkw zzkwVar = null;
        switch (zzkw.zza[i - 1]) {
            case 1:
                return new zzku();
            case 2:
                return new zza(zzkwVar);
            case 3:
                return zza(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzc", "zzd"});
            case 4:
                return zze;
            case 5:
                zzjz<zzku> zzjzVar = zzf;
                if (zzjzVar != null) {
                    return zzjzVar;
                }
                synchronized (zzku.class) {
                    zzaVar = zzf;
                    if (zzaVar == null) {
                        zzaVar = new zzie.zza(zze);
                        zzf = zzaVar;
                    }
                    break;
                }
                return zzaVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzku zzb() {
        return zze;
    }

    static {
        zzku zzkuVar = new zzku();
        zze = zzkuVar;
        zzie.zza((Class<zzku>) zzku.class, zzkuVar);
    }
}
