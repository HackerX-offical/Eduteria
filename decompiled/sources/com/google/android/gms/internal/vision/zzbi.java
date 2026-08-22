package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzbi<T> {

    @Nullable
    private static volatile zzbr zzb = null;
    private static volatile boolean zzc = false;
    private final zzbo zzf;
    private final String zzg;
    private final T zzh;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzbi<?>>> zzd = new AtomicReference<>();
    private static zzbs zze = new zzbs(zzbk.zza);
    private static final AtomicInteger zzi = new AtomicInteger();

    @Deprecated
    public static void zza(final Context context) {
        synchronized (zza) {
            zzbr zzbrVar = zzb;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzbrVar == null || zzbrVar.zza() != context) {
                zzau.zzb();
                zzbq.zza();
                zzbd.zza();
                zzb = new zzav(context, zzdi.zza(new zzdf(context) { // from class: com.google.android.gms.internal.vision.zzbl
                    private final Context zza;

                    {
                        this.zza = context;
                    }

                    @Override // com.google.android.gms.internal.vision.zzdf
                    public final Object zza() {
                        return zzbi.zzc(this.zza);
                    }
                }));
                zzi.incrementAndGet();
            }
        }
    }

    static final /* synthetic */ boolean zzd() {
        return true;
    }

    abstract T zza(Object obj);

    public static void zzb(Context context) {
        if (zzb != null) {
            return;
        }
        synchronized (zza) {
            if (zzb == null) {
                zza(context);
            }
        }
    }

    static void zza() {
        zzi.incrementAndGet();
    }

    private zzbi(zzbo zzboVar, String str, T t, boolean z) {
        this.zzj = -1;
        if (zzboVar.zza == null && zzboVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (zzboVar.zza != null && zzboVar.zzb != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzf = zzboVar;
        this.zzg = str;
        this.zzh = t;
        this.zzl = z;
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf(this.zzg);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004e A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:14:0x0027, B:16:0x0032, B:29:0x0050, B:31:0x0060, B:33:0x007a, B:34:0x007d, B:35:0x0081, B:19:0x0039, B:28:0x004e, B:22:0x0040, B:25:0x0047, B:36:0x0085), top: B:43:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:14:0x0027, B:16:0x0032, B:29:0x0050, B:31:0x0060, B:33:0x007a, B:34:0x007d, B:35:0x0081, B:19:0x0039, B:28:0x004e, B:22:0x0040, B:25:0x0047, B:36:0x0085), top: B:43:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T zzc() {
        /*
            r6 = this;
            boolean r0 = r6.zzl
            if (r0 != 0) goto L11
            com.google.android.gms.internal.vision.zzbs r0 = com.google.android.gms.internal.vision.zzbi.zze
            java.lang.String r1 = r6.zzg
            boolean r0 = r0.zza(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            com.google.android.gms.internal.vision.zzde.zzb(r0, r1)
        L11:
            java.util.concurrent.atomic.AtomicInteger r0 = com.google.android.gms.internal.vision.zzbi.zzi
            int r0 = r0.get()
            int r1 = r6.zzj
            if (r1 >= r0) goto L8a
            monitor-enter(r6)
            int r1 = r6.zzj     // Catch: java.lang.Throwable -> L87
            if (r1 >= r0) goto L85
            com.google.android.gms.internal.vision.zzbr r1 = com.google.android.gms.internal.vision.zzbi.zzb     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L26
            r2 = 1
            goto L27
        L26:
            r2 = 0
        L27:
            java.lang.String r3 = "Must call PhenotypeFlag.init() first"
            com.google.android.gms.internal.vision.zzde.zzb(r2, r3)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.vision.zzbo r2 = r6.zzf     // Catch: java.lang.Throwable -> L87
            boolean r2 = r2.zzf     // Catch: java.lang.Throwable -> L87
            if (r2 == 0) goto L40
            java.lang.Object r2 = r6.zzb(r1)     // Catch: java.lang.Throwable -> L87
            if (r2 == 0) goto L39
            goto L50
        L39:
            java.lang.Object r2 = r6.zza(r1)     // Catch: java.lang.Throwable -> L87
            if (r2 == 0) goto L4e
            goto L50
        L40:
            java.lang.Object r2 = r6.zza(r1)     // Catch: java.lang.Throwable -> L87
            if (r2 == 0) goto L47
            goto L50
        L47:
            java.lang.Object r2 = r6.zzb(r1)     // Catch: java.lang.Throwable -> L87
            if (r2 == 0) goto L4e
            goto L50
        L4e:
            T r2 = r6.zzh     // Catch: java.lang.Throwable -> L87
        L50:
            com.google.android.gms.internal.vision.zzdf r1 = r1.zzb()     // Catch: java.lang.Throwable -> L87
            java.lang.Object r1 = r1.zza()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.vision.zzcy r1 = (com.google.android.gms.internal.vision.zzcy) r1     // Catch: java.lang.Throwable -> L87
            boolean r3 = r1.zza()     // Catch: java.lang.Throwable -> L87
            if (r3 == 0) goto L81
            java.lang.Object r1 = r1.zzb()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.vision.zzbe r1 = (com.google.android.gms.internal.vision.zzbe) r1     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.vision.zzbo r2 = r6.zzf     // Catch: java.lang.Throwable -> L87
            android.net.Uri r2 = r2.zzb     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.vision.zzbo r3 = r6.zzf     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = r3.zza     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.vision.zzbo r4 = r6.zzf     // Catch: java.lang.Throwable -> L87
            java.lang.String r4 = r4.zzd     // Catch: java.lang.Throwable -> L87
            java.lang.String r5 = r6.zzg     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = r1.zza(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L87
            if (r1 != 0) goto L7d
            T r2 = r6.zzh     // Catch: java.lang.Throwable -> L87
            goto L81
        L7d:
            java.lang.Object r2 = r6.zza(r1)     // Catch: java.lang.Throwable -> L87
        L81:
            r6.zzk = r2     // Catch: java.lang.Throwable -> L87
            r6.zzj = r0     // Catch: java.lang.Throwable -> L87
        L85:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L87
            goto L8a
        L87:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L87
            throw r0
        L8a:
            T r0 = r6.zzk
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzbi.zzc():java.lang.Object");
    }

    @Nullable
    private final T zza(zzbr zzbrVar) {
        zzay zzayVarZza;
        Object objZza;
        String str;
        if (this.zzf.zzg || (str = (String) zzbd.zza(zzbrVar.zza()).zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype")) == null || !zzaq.zzb.matcher(str).matches()) {
            if (this.zzf.zzb != null) {
                if (!zzbg.zza(zzbrVar.zza(), this.zzf.zzb)) {
                    zzayVarZza = null;
                } else if (this.zzf.zzh) {
                    ContentResolver contentResolver = zzbrVar.zza().getContentResolver();
                    String lastPathSegment = this.zzf.zzb.getLastPathSegment();
                    String packageName = zzbrVar.zza().getPackageName();
                    zzayVarZza = zzau.zza(contentResolver, zzbj.zza(new StringBuilder(String.valueOf(lastPathSegment).length() + 1 + String.valueOf(packageName).length()).append(lastPathSegment).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(packageName).toString()));
                } else {
                    zzayVarZza = zzau.zza(zzbrVar.zza().getContentResolver(), this.zzf.zzb);
                }
            } else {
                zzayVarZza = zzbq.zza(zzbrVar.zza(), this.zzf.zza);
            }
            if (zzayVarZza != null && (objZza = zzayVarZza.zza(zzb())) != null) {
                return zza(objZza);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String strValueOf = String.valueOf(zzb());
            Log.d("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    @Nullable
    private final T zzb(zzbr zzbrVar) {
        if (!this.zzf.zze && (this.zzf.zzi == null || this.zzf.zzi.zza(zzbrVar.zza()).booleanValue())) {
            Object objZza = zzbd.zza(zzbrVar.zza()).zza(this.zzf.zze ? null : zza(this.zzf.zzc));
            if (objZza != null) {
                return zza(objZza);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> zzbi<T> zzb(zzbo zzboVar, String str, T t, zzbp<T> zzbpVar, boolean z) {
        return new zzbm(zzboVar, str, t, true, zzbpVar);
    }

    static final /* synthetic */ zzcy zzc(Context context) {
        new zzbh();
        return zzbh.zza(context);
    }

    /* synthetic */ zzbi(zzbo zzboVar, String str, Object obj, boolean z, zzbn zzbnVar) {
        this(zzboVar, str, obj, z);
    }
}
