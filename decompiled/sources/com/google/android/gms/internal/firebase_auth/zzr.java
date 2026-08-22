package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzr extends zzie<zzr, zza> implements zzjr {
    private static final zzr zzk;
    private static volatile zzjz<zzr> zzl;
    private int zzc;
    private Object zze;
    private Object zzg;
    private zzku zzj;
    private int zzd = 0;
    private int zzf = 0;
    private String zzh = "";
    private String zzi = "";

    private zzr() {
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zza extends zzie.zzb<zzr, zza> implements zzjr {
        private zza() {
            super(zzr.zzk);
        }

        /* synthetic */ zza(zzs zzsVar) {
            this();
        }
    }

    public final String zza() {
        if (this.zzd == 1) {
            return (String) this.zze;
        }
        return "";
    }

    public final String zzb() {
        return this.zzh;
    }

    public final String zzc() {
        return this.zzi;
    }

    public final zzku zzd() {
        zzku zzkuVar = this.zzj;
        return zzkuVar == null ? zzku.zzb() : zzkuVar;
    }

    public final String zze() {
        if (this.zzf == 5) {
            return (String) this.zzg;
        }
        return "";
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzie
    protected final Object zza(int i, Object obj, Object obj2) {
        zzjz zzaVar;
        zzs zzsVar = null;
        switch (zzs.zza[i - 1]) {
            case 1:
                return new zzr();
            case 2:
                return new zza(zzsVar);
            case 3:
                return zza(zzk, "\u0001\u0005\u0002\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001;\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003\u0005;\u0001", new Object[]{"zze", "zzd", "zzg", "zzf", "zzc", "zzh", "zzi", "zzj"});
            case 4:
                return zzk;
            case 5:
                zzjz<zzr> zzjzVar = zzl;
                if (zzjzVar != null) {
                    return zzjzVar;
                }
                synchronized (zzr.class) {
                    zzaVar = zzl;
                    if (zzaVar == null) {
                        zzaVar = new zzie.zza(zzk);
                        zzl = zzaVar;
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

    public static zzr zzf() {
        return zzk;
    }

    static {
        zzr zzrVar = new zzr();
        zzk = zzrVar;
        zzie.zza((Class<zzr>) zzr.class, zzrVar);
    }
}
