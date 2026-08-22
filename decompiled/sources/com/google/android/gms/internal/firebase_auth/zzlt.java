package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzlt {

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzb extends zzie<zzb, zza> implements zzjr {
        private static final zzb zzj;
        private static volatile zzjz<zzb> zzk;
        private long zzd;
        private long zzi;
        private String zzc = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        private zzb() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzb, zza> implements zzjr {
            private zza() {
                super(zzb.zzj);
            }

            /* synthetic */ zza(zzlv zzlvVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzc;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final String zzd() {
            return this.zzf;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            zzlv zzlvVar = null;
            switch (zzlv.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzlvVar);
                case 3:
                    return zza(zzj, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzjz<zzb> zzjzVar = zzk;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzb.class) {
                        zzaVar = zzk;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzj);
                            zzk = zzaVar;
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

        public static zzjz<zzb> zze() {
            return (zzjz) zzj.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzb zzbVar = new zzb();
            zzj = zzbVar;
            zzie.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zza extends zzie<zza, C0143zza> implements zzjr {
        private static final zza zzf;
        private static volatile zzjz<zza> zzg;
        private String zzc = "";
        private String zzd = "";
        private String zze = "";

        private zza() {
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.firebase_auth.zzlt$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class C0143zza extends zzie.zzb<zza, C0143zza> implements zzjr {
            private C0143zza() {
                super(zza.zzf);
            }

            public final C0143zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final C0143zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(str);
                return this;
            }

            /* synthetic */ C0143zza(zzlv zzlvVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zze = str;
        }

        public static C0143zza zza() {
            return zzf.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            zzlv zzlvVar = null;
            switch (zzlv.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0143zza(zzlvVar);
                case 3:
                    return zza(zzf, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjz<zza> zzjzVar = zzg;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zza.class) {
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
            zza zzaVar = new zza();
            zzf = zzaVar;
            zzie.zza((Class<zza>) zza.class, zzaVar);
        }
    }
}
