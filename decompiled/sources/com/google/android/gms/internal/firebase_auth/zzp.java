package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzp {

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzb extends zzie<zzb, zza> implements zzjr {
        private static final zzb zzn;
        private static volatile zzjz<zzb> zzo;
        private int zzc;
        private boolean zzg;
        private boolean zzi;
        private boolean zzj;
        private byte zzm = 2;
        private String zzd = "";
        private String zze = "";
        private zzim<String> zzf = zzie.zzad();
        private String zzh = "";
        private String zzk = "";
        private zzim<String> zzl = zzie.zzad();

        private zzb() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzb, zza> implements zzjr {
            private zza() {
                super(zzb.zzn);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final List<String> zzb() {
            return this.zzf;
        }

        public final int zzc() {
            return this.zzf.size();
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final String zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final List<String> zzg() {
            return this.zzl;
        }

        public final int zzh() {
            return this.zzl.size();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\u001a\u0004\u0007\u0002\u0005\b\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\b\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
                case 4:
                    return zzn;
                case 5:
                    zzjz<zzb> zzjzVar = zzo;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzb.class) {
                        zzaVar = zzo;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzn);
                            zzo = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzm);
                case 7:
                    this.zzm = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zzb> zzi() {
            return (zzjz) zzn.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzb zzbVar = new zzb();
            zzn = zzbVar;
            zzie.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zze extends zzie<zze, zza> implements zzjr {
        private static final zze zzn;
        private static volatile zzjz<zze> zzo;
        private int zzc;
        private long zzh;
        private boolean zzj;
        private byte zzm = 2;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzi = "";
        private String zzk = "";
        private zzim<com.google.android.gms.internal.firebase_auth.zzr> zzl = zzad();

        private zze() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zze, zza> implements zzjr {
            private zza() {
                super(zze.zzn);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final long zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzi;
        }

        public final boolean zzf() {
            return this.zzj;
        }

        public final String zzg() {
            return this.zzk;
        }

        public final List<com.google.android.gms.internal.firebase_auth.zzr> zzh() {
            return this.zzl;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u0002\u0004\u0006\b\u0005\u0007\u0007\u0006\b\b\u0007\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", com.google.android.gms.internal.firebase_auth.zzr.class});
                case 4:
                    return zzn;
                case 5:
                    zzjz<zze> zzjzVar = zzo;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zze.class) {
                        zzaVar = zzo;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzn);
                            zzo = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzm);
                case 7:
                    this.zzm = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zze> zzi() {
            return (zzjz) zzn.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zze zzeVar = new zze();
            zzn = zzeVar;
            zzie.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzg extends zzie<zzg, zza> implements zzjr {
        private static final zzg zzg;
        private static volatile zzjz<zzg> zzh;
        private int zzc;
        private byte zzf = 2;
        private String zzd = "";
        private zzim<zzz> zze = zzad();

        private zzg() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzg, zza> implements zzjr {
            private zza() {
                super(zzg.zzg);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final int zza() {
            return this.zze.size();
        }

        public final zzz zza(int i) {
            return this.zze.get(i);
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", "zze", zzz.class});
                case 4:
                    return zzg;
                case 5:
                    zzjz<zzg> zzjzVar = zzh;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzg.class) {
                        zzaVar = zzh;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzg);
                            zzh = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzf);
                case 7:
                    this.zzf = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zzg> zzb() {
            return (zzjz) zzg.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzg zzgVar = new zzg();
            zzg = zzgVar;
            zzie.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzi extends zzie<zzi, zza> implements zzjr {
        private static final zzi zzi;
        private static volatile zzjz<zzi> zzj;
        private int zzc;
        private byte zzh = 2;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";

        private zzi() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzi, zza> implements zzjr {
            private zza() {
                super(zzi.zzi);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzi;
                case 5:
                    zzjz<zzi> zzjzVar = zzj;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzi.class) {
                        zzaVar = zzj;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzi);
                            zzj = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzh);
                case 7:
                    this.zzh = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zzi> zza() {
            return (zzjz) zzi.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzi zziVar = new zzi();
            zzi = zziVar;
            zzie.zza((Class<zzi>) zzi.class, zziVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzk extends zzie<zzk, zza> implements zzjr {
        private static final zzk zzj;
        private static volatile zzjz<zzk> zzk;
        private int zzc;
        private int zzg;
        private com.google.android.gms.internal.firebase_auth.zzr zzh;
        private byte zzi = 2;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";

        private zzk() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzk, zza> implements zzjr {
            private zza() {
                super(zzk.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final zzgk zzc() {
            zzgk zzgkVarZza = zzgk.zza(this.zzg);
            return zzgkVarZza == null ? zzgk.OOB_REQ_TYPE_UNSPECIFIED : zzgkVarZza;
        }

        public final boolean zzd() {
            return (this.zzc & 16) != 0;
        }

        public final com.google.android.gms.internal.firebase_auth.zzr zze() {
            com.google.android.gms.internal.firebase_auth.zzr zzrVar = this.zzh;
            return zzrVar == null ? com.google.android.gms.internal.firebase_auth.zzr.zzf() : zzrVar;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\f\u0003\u0005\t\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzgk.zzb(), "zzh"});
                case 4:
                    return zzj;
                case 5:
                    zzjz<zzk> zzjzVar = zzk;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzk.class) {
                        zzaVar = zzk;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzj);
                            zzk = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzi);
                case 7:
                    this.zzi = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zzk> zzf() {
            return (zzjz) zzj.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzk zzkVar = new zzk();
            zzj = zzkVar;
            zzie.zza((Class<zzk>) zzk.class, zzkVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzm extends zzie<zzm, zza> implements zzjr {
        private static final zzm zze;
        private static volatile zzjz<zzm> zzf;
        private int zzc;
        private String zzd = "";

        private zzm() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzm, zza> implements zzjr {
            private zza() {
                super(zzm.zze);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzjz<zzm> zzjzVar = zzf;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzm.class) {
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

        public static zzjz<zzm> zzb() {
            return (zzjz) zze.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzm zzmVar = new zzm();
            zze = zzmVar;
            zzie.zza((Class<zzm>) zzm.class, zzmVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzo extends zzie<zzo, zza> implements zzjr {
        private static final zzo zzr;
        private static volatile zzjz<zzo> zzs;
        private int zzc;
        private long zzn;
        private boolean zzp;
        private byte zzq = 2;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private zzim<String> zzh = zzie.zzad();
        private String zzi = "";
        private zzim<com.google.android.gms.internal.firebase_auth.zzu> zzj = zzad();
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzo = "";

        private zzo() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzo, zza> implements zzjr {
            private zza() {
                super(zzo.zzr);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        @Deprecated
        public final String zza() {
            return this.zzf;
        }

        @Deprecated
        public final String zzb() {
            return this.zzg;
        }

        public final String zzc() {
            return this.zzi;
        }

        @Deprecated
        public final List<com.google.android.gms.internal.firebase_auth.zzu> zzd() {
            return this.zzj;
        }

        @Deprecated
        public final String zze() {
            return this.zzl;
        }

        public final String zzf() {
            return this.zzm;
        }

        public final long zzg() {
            return this.zzn;
        }

        public final String zzh() {
            return this.zzo;
        }

        public final boolean zzi() {
            return this.zzp;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzr, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u001a\u0006\b\u0004\u0007\u001b\b\b\u0005\t\b\u0006\n\b\u0007\u000b\u0002\b\f\b\t\r\u0007\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", com.google.android.gms.internal.firebase_auth.zzu.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
                case 4:
                    return zzr;
                case 5:
                    zzjz<zzo> zzjzVar = zzs;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzo.class) {
                        zzaVar = zzs;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzr);
                            zzs = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzq);
                case 7:
                    this.zzq = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zzo> zzj() {
            return (zzjz) zzr.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzo zzoVar = new zzo();
            zzr = zzoVar;
            zzie.zza((Class<zzo>) zzo.class, zzoVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzq extends zzie<zzq, zza> implements zzjr {
        private static final zzq zzl;
        private static volatile zzjz<zzq> zzm;
        private int zzc;
        private long zzi;
        private byte zzk = 2;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzj = "";

        private zzq() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzq, zza> implements zzjr {
            private zza() {
                super(zzq.zzl);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final String zzd() {
            return this.zzh;
        }

        public final long zze() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzl, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005\b\b\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzl;
                case 5:
                    zzjz<zzq> zzjzVar = zzm;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzq.class) {
                        zzaVar = zzm;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzl);
                            zzm = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzk);
                case 7:
                    this.zzk = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zzq> zzf() {
            return (zzjz) zzl.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzq zzqVar = new zzq();
            zzl = zzqVar;
            zzie.zza((Class<zzq>) zzq.class, zzqVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzs extends zzie<zzs, zza> implements zzjr {
        private static final zzs zzav;
        private static volatile zzjz<zzs> zzaw;
        private boolean zzab;
        private long zzag;
        private boolean zzai;
        private long zzal;
        private boolean zzaq;
        private int zzc;
        private int zzd;
        private boolean zzh;
        private boolean zzv;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private String zzq = "";
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private String zzu = "";
        private String zzw = "";
        private String zzx = "";
        private String zzy = "";
        private String zzz = "";
        private zzim<String> zzaa = zzie.zzad();
        private String zzac = "";
        private String zzad = "";
        private String zzae = "";
        private String zzaf = "";
        private String zzah = "";
        private String zzaj = "";
        private String zzak = "";
        private String zzam = "";
        private String zzan = "";
        private String zzao = "";
        private String zzap = "";
        private String zzar = "";
        private String zzas = "";
        private String zzat = "";
        private zzim<com.google.android.gms.internal.firebase_auth.zzr> zzau = zzad();

        private zzs() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzs, zza> implements zzjr {
            private zza() {
                super(zzs.zzav);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzf;
        }

        public final String zzb() {
            return this.zzg;
        }

        public final String zzc() {
            return this.zzo;
        }

        public final String zzd() {
            return this.zzu;
        }

        public final String zze() {
            return this.zzw;
        }

        public final String zzf() {
            return this.zzx;
        }

        public final boolean zzg() {
            return this.zzab;
        }

        public final String zzh() {
            return this.zzae;
        }

        public final boolean zzi() {
            return this.zzai;
        }

        public final String zzj() {
            return this.zzaj;
        }

        public final String zzk() {
            return this.zzak;
        }

        public final long zzl() {
            return this.zzal;
        }

        public final String zzm() {
            return this.zzam;
        }

        public final String zzn() {
            return this.zzao;
        }

        public final String zzo() {
            return this.zzap;
        }

        public final boolean zzp() {
            return this.zzaq;
        }

        public final String zzq() {
            return this.zzar;
        }

        public final String zzr() {
            return this.zzas;
        }

        public final String zzs() {
            return this.zzat;
        }

        public final List<com.google.android.gms.internal.firebase_auth.zzr> zzt() {
            return this.zzau;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzav, "\u0001+\u0000\u0002\u0001-+\u0000\u0002\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\b\r\u000f\b\u000e\u0010\b\u000f\u0011\b\u0010\u0012\u0007\u0011\u0013\b\u0012\u0014\b\u0013\u0015\b\u0014\u0017\b\u0015\u0018\u001a\u0019\u0007\u0016\u001a\b\u0017\u001b\b\u0018\u001c\b\u0019\u001d\b\u001a\u001e\u0002\u001b\u001f\b\u001c \u0007\u001d!\b\u001e\"\b\u001f#\u0002 $\b!%\b\"&\b#'\b$(\u0007%*\b&+\b',\b(-\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", com.google.android.gms.internal.firebase_auth.zzr.class});
                case 4:
                    return zzav;
                case 5:
                    zzjz<zzs> zzjzVar = zzaw;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzs.class) {
                        zzaVar = zzaw;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzav);
                            zzaw = zzaVar;
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

        public static zzjz<zzs> zzu() {
            return (zzjz) zzav.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzs zzsVar = new zzs();
            zzav = zzsVar;
            zzie.zza((Class<zzs>) zzs.class, zzsVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzu extends zzie<zzu, zza> implements zzjr {
        private static final zzu zzj;
        private static volatile zzjz<zzu> zzk;
        private int zzc;
        private long zzg;
        private boolean zzh;
        private byte zzi = 2;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";

        private zzu() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzu, zza> implements zzjr {
            private zza() {
                super(zzu.zzj);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final long zzc() {
            return this.zzg;
        }

        public final boolean zzd() {
            return this.zzh;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzj;
                case 5:
                    zzjz<zzu> zzjzVar = zzk;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzu.class) {
                        zzaVar = zzk;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzj);
                            zzk = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzi);
                case 7:
                    this.zzi = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zzu> zze() {
            return (zzjz) zzj.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzu zzuVar = new zzu();
            zzj = zzuVar;
            zzie.zza((Class<zzu>) zzu.class, zzuVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzw extends zzie<zzw, zza> implements zzjr {
        private static final zzw zzs;
        private static volatile zzjz<zzw> zzt;
        private int zzc;
        private boolean zzi;
        private long zzl;
        private long zzo;
        private byte zzr = 2;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzj = "";
        private String zzk = "";
        private String zzm = "";
        private String zzn = "";
        private String zzp = "";
        private zzim<com.google.android.gms.internal.firebase_auth.zzr> zzq = zzad();

        private zzw() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzw, zza> implements zzjr {
            private zza() {
                super(zzw.zzs);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzj;
        }

        public final String zzf() {
            return this.zzn;
        }

        public final long zzg() {
            return this.zzo;
        }

        public final String zzh() {
            return this.zzp;
        }

        public final List<com.google.android.gms.internal.firebase_auth.zzr> zzi() {
            return this.zzq;
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzs, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0007\u0005\u0007\b\u0006\b\b\u0007\t\u0002\b\n\b\t\u000b\b\n\f\u0002\u000b\u000e\b\f\u000f\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", com.google.android.gms.internal.firebase_auth.zzr.class});
                case 4:
                    return zzs;
                case 5:
                    zzjz<zzw> zzjzVar = zzt;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzw.class) {
                        zzaVar = zzt;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzs);
                            zzt = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return Byte.valueOf(this.zzr);
                case 7:
                    this.zzr = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjz<zzw> zzj() {
            return (zzjz) zzs.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzw zzwVar = new zzw();
            zzs = zzwVar;
            zzie.zza((Class<zzw>) zzw.class, zzwVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zza extends zzie<zza, C0144zza> implements zzjr {
        private static final zza zzs;
        private static volatile zzjz<zza> zzt;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private zzim<com.google.android.gms.internal.firebase_auth.zzl> zzq = zzad();
        private String zzr = "";

        private zza() {
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.firebase_auth.zzp$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class C0144zza extends zzie.zzb<zza, C0144zza> implements zzjr {
            private C0144zza() {
                super(zza.zzs);
            }

            public final C0144zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final C0144zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(str);
                return this;
            }

            public final C0144zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ C0144zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzr = str;
        }

        public static C0144zza zza() {
            return zzs.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0144zza(zzoVar);
                case 3:
                    return zza(zzs, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\u001b\u000f\b\r", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", com.google.android.gms.internal.firebase_auth.zzl.class, "zzr"});
                case 4:
                    return zzs;
                case 5:
                    zzjz<zza> zzjzVar = zzt;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zza.class) {
                        zzaVar = zzt;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzs);
                            zzt = zzaVar;
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
            zzs = zzaVar;
            zzie.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzc extends zzie<zzc, zza> implements zzjr {
        private static final zzc zzg;
        private static volatile zzjz<zzc> zzh;
        private int zzc;
        private long zze;
        private String zzd = "";
        private String zzf = "";

        private zzc() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzc, zza> implements zzjr {
            private zza() {
                super(zzc.zzg);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        public static zza zza() {
            return zzg.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzjz<zzc> zzjzVar = zzh;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzc.class) {
                        zzaVar = zzh;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzg);
                            zzh = zzaVar;
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
            zzc zzcVar = new zzc();
            zzg = zzcVar;
            zzie.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzd extends zzie<zzd, zza> implements zzjr {
        private static final zzd zzh;
        private static volatile zzjz<zzd> zzi;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";

        private zzd() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzd, zza> implements zzjr {
            private zza() {
                super(zzd.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzd(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        public static zza zza() {
            return zzh.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0006\b\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjz<zzd> zzjzVar = zzi;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzd.class) {
                        zzaVar = zzi;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzh);
                            zzi = zzaVar;
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
            zzd zzdVar = new zzd();
            zzh = zzdVar;
            zzie.zza((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzf extends zzie<zzf, zza> implements zzjr {
        private static final zzf zzh;
        private static volatile zzjz<zzf> zzi;
        private int zzc;
        private String zzd = "";
        private zzim<String> zze = zzie.zzad();
        private zzim<String> zzf = zzie.zzad();
        private long zzg;

        private zzf() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzf, zza> implements zzjr {
            private zza() {
                super(zzf.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public static zza zza() {
            return zzh.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\b\u0000\u0002\u001a\u0003\u001a\u0004\u0002\u0001", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjz<zzf> zzjzVar = zzi;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzf.class) {
                        zzaVar = zzi;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzh);
                            zzi = zzaVar;
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
            zzf zzfVar = new zzf();
            zzh = zzfVar;
            zzie.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzh extends zzie<zzh, zza> implements zzjr {
        private static final zzh zzu;
        private static volatile zzjz<zzh> zzv;
        private int zzc;
        private int zzd;
        private boolean zzo;
        private boolean zzq;
        private boolean zzt;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private String zzp = "";
        private String zzr = "";
        private String zzs = "";

        private zzh() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzh, zza> implements zzjr {
            private zza() {
                super(zzh.zzu);
            }

            public final zza zza(zzgk zzgkVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza(zzgkVar);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zze(str);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzg(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza(z);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzh(str);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzb(z);
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzi(str);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzj(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzgk zzgkVar) {
            this.zzd = zzgkVar.zza();
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 32;
            this.zzi = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzj = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzm = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= 1024;
            this.zzn = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 2048;
            this.zzo = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8192;
            this.zzq = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zzc |= 16384;
            this.zzr = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzc |= 32768;
            this.zzs = str;
        }

        public static zza zza() {
            return zzu.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzu, "\u0001\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\u0007\u000b\r\b\f\u000e\u0007\r\u000f\b\u000e\u0012\b\u000f\u0013\u0007\u0010", new Object[]{"zzc", "zzd", zzgk.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
                case 4:
                    return zzu;
                case 5:
                    zzjz<zzh> zzjzVar = zzv;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzh.class) {
                        zzaVar = zzv;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzu);
                            zzv = zzaVar;
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
            zzh zzhVar = new zzh();
            zzu = zzhVar;
            zzie.zza((Class<zzh>) zzh.class, zzhVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzj extends zzie<zzj, zza> implements zzjr {
        private static final zzj zzi;
        private static volatile zzjz<zzj> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        private zzj() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzj, zza> implements zzjr {
            private zza() {
                super(zzj.zzi);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        public static zza zza() {
            return zzi.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0006\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjz<zzj> zzjzVar = zzj;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzj.class) {
                        zzaVar = zzj;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzi);
                            zzj = zzaVar;
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
            zzj zzjVar = new zzj();
            zzi = zzjVar;
            zzie.zza((Class<zzj>) zzj.class, zzjVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzl extends zzie<zzl, zza> implements zzjr {
        private static final zzl zzi;
        private static volatile zzjz<zzl> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        private zzl() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzl, zza> implements zzjr {
            private zza() {
                super(zzl.zzi);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzl) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzl) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzl) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        public static zza zza() {
            return zzi.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjz<zzl> zzjzVar = zzj;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzl.class) {
                        zzaVar = zzj;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzi);
                            zzj = zzaVar;
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
            zzi = zzlVar;
            zzie.zza((Class<zzl>) zzl.class, zzlVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzn extends zzie<zzn, zzb> implements zzjr {
        private static final zzn zzab;
        private static volatile zzjz<zzn> zzac;
        private static final zzin<Integer, com.google.android.gms.internal.firebase_auth.zzv> zzu = new com.google.android.gms.internal.firebase_auth.zzq();
        private zza zzaa;
        private int zzc;
        private boolean zzk;
        private boolean zzl;
        private zzku zzo;
        private boolean zzp;
        private long zzr;
        private boolean zzv;
        private long zzx;
        private long zzy;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private zzim<String> zzi = zzie.zzad();
        private String zzj = "";
        private String zzm = "";
        private String zzn = "";
        private String zzq = "";
        private String zzs = "";
        private zzik zzt = zzac();
        private zzim<String> zzw = zzie.zzad();
        private String zzz = "";

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie<zza, C0145zza> implements zzjr {
            private static final zza zzd;
            private static volatile zzjz<zza> zze;
            private zzim<com.google.android.gms.internal.firebase_auth.zzr> zzc = zzad();

            private zza() {
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzn$zza$zza, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
            public static final class C0145zza extends zzie.zzb<zza, C0145zza> implements zzjr {
                private C0145zza() {
                    super(zza.zzd);
                }

                /* synthetic */ C0145zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.firebase_auth.zzie
            protected final Object zza(int i, Object obj, Object obj2) {
                zzjz zzaVar;
                com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
                switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0145zza(zzoVar);
                    case 3:
                        return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", com.google.android.gms.internal.firebase_auth.zzr.class});
                    case 4:
                        return zzd;
                    case 5:
                        zzjz<zza> zzjzVar = zze;
                        if (zzjzVar != null) {
                            return zzjzVar;
                        }
                        synchronized (zza.class) {
                            zzaVar = zze;
                            if (zzaVar == null) {
                                zzaVar = new zzie.zza(zzd);
                                zze = zzaVar;
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
                zzd = zzaVar;
                zzie.zza((Class<zza>) zza.class, zzaVar);
            }
        }

        private zzn() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zzb extends zzie.zzb<zzn, zzb> implements zzjr {
            private zzb() {
                super(zzn.zzab);
            }

            public final zzb zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(str);
                return this;
            }

            public final zzb zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzb(str);
                return this;
            }

            public final zzb zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzc(str);
                return this;
            }

            public final zzb zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzd(str);
                return this;
            }

            public final zzb zze(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zze(str);
                return this;
            }

            public final zzb zzf(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzf(str);
                return this;
            }

            public final zzb zza(Iterable<? extends com.google.android.gms.internal.firebase_auth.zzv> iterable) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(iterable);
                return this;
            }

            public final zzb zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(z);
                return this;
            }

            public final zzb zzb(Iterable<String> iterable) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzb(iterable);
                return this;
            }

            public final zzb zzg(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zzg(str);
                return this;
            }

            /* synthetic */ zzb(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 32;
            this.zzj = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 16384;
            this.zzs = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends com.google.android.gms.internal.firebase_auth.zzv> iterable) {
            if (!this.zzt.zza()) {
                zzik zzikVar = this.zzt;
                int size = zzikVar.size();
                this.zzt = zzikVar.zza(size == 0 ? 10 : size << 1);
            }
            Iterator<? extends com.google.android.gms.internal.firebase_auth.zzv> it = iterable.iterator();
            while (it.hasNext()) {
                this.zzt.zzd(it.next().zza());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 32768;
            this.zzv = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(Iterable<String> iterable) {
            if (!this.zzw.zza()) {
                zzim<String> zzimVar = this.zzw;
                int size = zzimVar.size();
                this.zzw = zzimVar.zza(size == 0 ? 10 : size << 1);
            }
            zzgl.zza(iterable, this.zzw);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzz = str;
        }

        public static zzb zza() {
            return zzab.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zzb(zzoVar);
                case 3:
                    return zza(zzab, "\u0001\u0017\u0000\u0001\u0002\u001c\u0017\u0000\u0003\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u001a\b\b\u0005\t\u0007\u0006\n\u0007\u0007\u000b\b\b\f\b\t\r\t\n\u000e\u0007\u000b\u000f\b\f\u0010\u0002\r\u0011\b\u000e\u0012\u001e\u0013\u0007\u000f\u0014\u001a\u0015\u0002\u0010\u0016\u0002\u0011\u0019\b\u0012\u001c\t\u0013", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", com.google.android.gms.internal.firebase_auth.zzv.zzb(), "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa"});
                case 4:
                    return zzab;
                case 5:
                    zzjz<zzn> zzjzVar = zzac;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzn.class) {
                        zzaVar = zzac;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzab);
                            zzac = zzaVar;
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
            zzn zznVar = new zzn();
            zzab = zznVar;
            zzie.zza((Class<zzn>) zzn.class, zznVar);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzp, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class C0146zzp extends zzie<C0146zzp, zza> implements zzjr {
        private static final C0146zzp zzo;
        private static volatile zzjz<C0146zzp> zzp;
        private int zzc;
        private boolean zzk;
        private boolean zzm;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzl = "";
        private String zzn = "";

        private C0146zzp() {
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzp$zza */
        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<C0146zzp, zza> implements zzjr {
            private zza() {
                super(C0146zzp.zzo);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((C0146zzp) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((C0146zzp) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((C0146zzp) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 1024;
            this.zzn = str;
        }

        public static zza zza() {
            return zzo.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new C0146zzp();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzo, "\u0001\u000b\u0000\u0001\u0001\r\u000b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0007\u0007\t\b\b\n\u0007\t\r\b\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzjz<C0146zzp> zzjzVar = zzp;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (C0146zzp.class) {
                        zzaVar = zzp;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzo);
                            zzp = zzaVar;
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
            C0146zzp c0146zzp = new C0146zzp();
            zzo = c0146zzp;
            zzie.zza((Class<C0146zzp>) C0146zzp.class, c0146zzp);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzr extends zzie<zzr, zza> implements zzjr {
        private static final zzr zzq;
        private static volatile zzjz<zzr> zzr;
        private int zzc;
        private boolean zzg;
        private long zzj;
        private boolean zzl;
        private boolean zzm;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzh = "";
        private String zzi = "";
        private String zzk = "";
        private boolean zzn = true;
        private String zzo = "";
        private String zzp = "";

        private zzr() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzr, zza> implements zzjr {
            private zza() {
                super(zzr.zzq);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzd(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zza(z);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzc(z);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zze(str);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzr) this.zza).zzf(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 256;
            this.zzl = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 512;
            this.zzm = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zzc |= 1024;
            this.zzn = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 2048;
            this.zzo = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzp = str;
        }

        public static zza zza() {
            return zzq.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzq, "\u0001\r\u0000\u0001\u0001\u000f\r\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\u0002\u0006\b\b\u0007\t\u0007\b\n\u0007\t\u000b\u0007\n\r\b\u000b\u000f\b\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
                case 4:
                    return zzq;
                case 5:
                    zzjz<zzr> zzjzVar = zzr;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzr.class) {
                        zzaVar = zzr;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzq);
                            zzr = zzaVar;
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
            zzr zzrVar = new zzr();
            zzq = zzrVar;
            zzie.zza((Class<zzr>) zzr.class, zzrVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzt extends zzie<zzt, zza> implements zzjr {
        private static final zzt zzi;
        private static volatile zzjz<zzt> zzj;
        private int zzc;
        private boolean zzf;
        private long zzg;
        private String zzd = "";
        private String zze = "";
        private String zzh = "";

        private zzt() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzt, zza> implements zzjr {
            private zza() {
                super(zzt.zzi);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzt) this.zza).zza(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzt) this.zza).zza(true);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzt) this.zza).zzb(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 4;
            this.zzf = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        public static zza zza() {
            return zzi.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u0002\u0003\u0005\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjz<zzt> zzjzVar = zzj;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzt.class) {
                        zzaVar = zzj;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzi);
                            zzj = zzaVar;
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
            zzt zztVar = new zzt();
            zzi = zztVar;
            zzie.zza((Class<zzt>) zzt.class, zztVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzv extends zzie<zzv, zza> implements zzjr {
        private static final zzv zzo;
        private static volatile zzjz<zzv> zzp;
        private int zzc;
        private long zzk;
        private boolean zzm;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzl = "";
        private String zzn = "";

        private zzv() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzv, zza> implements zzjr {
            private zza() {
                super(zzv.zzo);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzv) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzv) this.zza).zzb(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzv) this.zza).zza(z);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzv) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 512;
            this.zzm = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 1024;
            this.zzn = str;
        }

        public static zza zza() {
            return zzo.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0007\t\u000b\b\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzjz<zzv> zzjzVar = zzp;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzv.class) {
                        zzaVar = zzp;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzo);
                            zzp = zzaVar;
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
            zzv zzvVar = new zzv();
            zzo = zzvVar;
            zzie.zza((Class<zzv>) zzv.class, zzvVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzx extends zzie<zzx, zza> implements zzjr {
        private static final zzx zzl;
        private static volatile zzjz<zzx> zzm;
        private int zzc;
        private int zzj;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzk = "";

        private zzx() {
        }

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzx, zza> implements zzjr {
            private zza() {
                super(zzx.zzl);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zze(str);
                return this;
            }

            public final zza zza(zzaa zzaaVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzx) this.zza).zza(zzaaVar);
                return this;
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 32;
            this.zzi = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzaa zzaaVar) {
            this.zzj = zzaaVar.zza();
            this.zzc |= 64;
        }

        public static zza zza() {
            return zzl.zzz();
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\f\u0006\b\b\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzaa.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzjz<zzx> zzjzVar = zzm;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzx.class) {
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
            zzx zzxVar = new zzx();
            zzl = zzxVar;
            zzie.zza((Class<zzx>) zzx.class, zzxVar);
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static final class zzy extends zzie<zzy, zza> implements zzjr {
        private static final zzy zzn;
        private static volatile zzjz<zzy> zzo;
        private int zzc;
        private long zzf;
        private boolean zzh;
        private long zzk;
        private long zzm;
        private String zzd = "";
        private String zze = "";
        private String zzg = "";
        private String zzi = "";
        private String zzj = "";
        private String zzl = "";

        /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
        public static final class zza extends zzie.zzb<zzy, zza> implements zzjr {
            private zza() {
                super(zzy.zzn);
            }

            /* synthetic */ zza(com.google.android.gms.internal.firebase_auth.zzo zzoVar) {
                this();
            }
        }

        static {
            zzy zzyVar = new zzy();
            zzn = zzyVar;
            zzie.zza((Class<zzy>) zzy.class, zzyVar);
        }

        private zzy() {
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzie
        protected final Object zza(int i, Object obj, Object obj2) {
            zzjz zzaVar;
            com.google.android.gms.internal.firebase_auth.zzo zzoVar = null;
            switch (com.google.android.gms.internal.firebase_auth.zzo.zza[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zza(zzoVar);
                case 3:
                    return zza(zzn, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\b\u0003\u0005\u0007\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0002\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzn;
                case 5:
                    zzjz<zzy> zzjzVar = zzo;
                    if (zzjzVar != null) {
                        return zzjzVar;
                    }
                    synchronized (zzy.class) {
                        zzaVar = zzo;
                        if (zzaVar == null) {
                            zzaVar = new zzie.zza(zzn);
                            zzo = zzaVar;
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

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        public final long zzc() {
            return this.zzf;
        }

        public final String zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final String zzf() {
            return this.zzi;
        }

        public final String zzg() {
            return this.zzj;
        }

        public final long zzh() {
            return this.zzk;
        }

        public final String zzi() {
            return this.zzl;
        }

        public static zzjz<zzy> zzj() {
            return (zzjz) zzn.zza(zzie.zze.zzg, (Object) null, (Object) null);
        }
    }
}
