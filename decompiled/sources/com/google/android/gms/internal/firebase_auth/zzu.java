package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzu extends zzie<zzu, zza> implements zzjr {
    private static final zzu zzl;
    private static volatile zzjz<zzu> zzm;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    private zzu() {
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zza extends zzie.zzb<zzu, zza> implements zzjr {
        private zza() {
            super(zzu.zzl);
        }

        /* synthetic */ zza(zzt zztVar) {
            this();
        }
    }

    public final String zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzh;
    }

    public final String zzf() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzie
    protected final Object zza(int i, Object obj, Object obj2) {
        zzjz zzaVar;
        zzt zztVar = null;
        switch (zzt.zza[i - 1]) {
            case 1:
                return new zzu();
            case 2:
                return new zza(zztVar);
            case 3:
                return zza(zzl, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\t\b\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                zzjz<zzu> zzjzVar = zzm;
                if (zzjzVar != null) {
                    return zzjzVar;
                }
                synchronized (zzu.class) {
                    zzaVar = zzm;
                    if (zzaVar == null) {
                        zzaVar = new zzie.zza(zzl);
                        zzm = zzaVar;
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

    static {
        zzu zzuVar = new zzu();
        zzl = zzuVar;
        zzie.zza((Class<zzu>) zzu.class, zzuVar);
    }
}
