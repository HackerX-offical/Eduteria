package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzl extends zzie<zzl, zza> implements zzjr {
    private static final zzl zzf;
    private static volatile zzjz<zzl> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    private zzl() {
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zza extends zzie.zzb<zzl, zza> implements zzjr {
        private zza() {
            super(zzl.zzf);
        }

        /* synthetic */ zza(zzn zznVar) {
            this();
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzie
    protected final Object zza(int i, Object obj, Object obj2) {
        zzjz zzaVar;
        zzn zznVar = null;
        switch (zzn.zza[i - 1]) {
            case 1:
                return new zzl();
            case 2:
                return new zza(zznVar);
            case 3:
                return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                zzjz<zzl> zzjzVar = zzg;
                if (zzjzVar != null) {
                    return zzjzVar;
                }
                synchronized (zzl.class) {
                    zzaVar = zzg;
                    if (zzaVar == null) {
                        zzaVar = new zzie.zza(zzf);
                        zzg = zzaVar;
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
        zzl zzlVar = new zzl();
        zzf = zzlVar;
        zzie.zza((Class<zzl>) zzl.class, zzlVar);
    }
}
