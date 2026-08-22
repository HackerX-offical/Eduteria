package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjs<T> implements zzkf<T> {
    private final zzjp zza;
    private final zzkx<?, ?> zzb;
    private final boolean zzc;
    private final zzht<?> zzd;

    private zzjs(zzkx<?, ?> zzkxVar, zzht<?> zzhtVar, zzjp zzjpVar) {
        this.zzb = zzkxVar;
        this.zzc = zzhtVar.zza(zzjpVar);
        this.zzd = zzhtVar;
        this.zza = zzjpVar;
    }

    static <T> zzjs<T> zza(zzkx<?, ?> zzkxVar, zzht<?> zzhtVar, zzjp zzjpVar) {
        return new zzjs<>(zzkxVar, zzhtVar, zzjpVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final T zza() {
        return (T) this.zza.zzaf().zze();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final int zza(T t) {
        int iHashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final void zzb(T t, T t2) {
        zzkh.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzkh.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final void zza(T t, zzlu zzluVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzhz zzhzVar = (zzhz) entry.getKey();
            if (zzhzVar.zzc() != zzlr.MESSAGE || zzhzVar.zzd() || zzhzVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzis) {
                zzluVar.zza(zzhzVar.zza(), (Object) ((zzis) entry).zza().zzc());
            } else {
                zzluVar.zza(zzhzVar.zza(), entry.getValue());
            }
        }
        zzkx<?, ?> zzkxVar = this.zzb;
        zzkxVar.zzb(zzkxVar.zzb(t), zzluVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:0: B:45:0x000c->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r11, com.google.android.gms.internal.firebase_auth.zzkc r12, com.google.android.gms.internal.firebase_auth.zzhr r13) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.gms.internal.firebase_auth.zzkx<?, ?> r0 = r10.zzb
            com.google.android.gms.internal.firebase_auth.zzht<?> r1 = r10.zzd
            java.lang.Object r2 = r0.zzc(r11)
            com.google.android.gms.internal.firebase_auth.zzhx r3 = r1.zzb(r11)
        Lc:
            int r4 = r12.zza()     // Catch: java.lang.Throwable -> L8f
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.zzb(r11, r2)
            return
        L19:
            int r4 = r12.zzb()     // Catch: java.lang.Throwable -> L8f
            r6 = 11
            if (r4 == r6) goto L3e
            r5 = r4 & 7
            r6 = 2
            if (r5 != r6) goto L39
            com.google.android.gms.internal.firebase_auth.zzjp r5 = r10.zza     // Catch: java.lang.Throwable -> L8f
            int r4 = r4 >>> 3
            java.lang.Object r4 = r1.zza(r13, r5, r4)     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L34
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L83
        L34:
            boolean r4 = r0.zza(r2, r12)     // Catch: java.lang.Throwable -> L8f
            goto L84
        L39:
            boolean r4 = r12.zzc()     // Catch: java.lang.Throwable -> L8f
            goto L84
        L3e:
            r4 = 0
            r6 = 0
            r7 = r6
            r6 = r4
        L42:
            int r8 = r12.zza()     // Catch: java.lang.Throwable -> L8f
            if (r8 == r5) goto L70
            int r8 = r12.zzb()     // Catch: java.lang.Throwable -> L8f
            r9 = 16
            if (r8 != r9) goto L5b
            int r7 = r12.zzo()     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.internal.firebase_auth.zzjp r4 = r10.zza     // Catch: java.lang.Throwable -> L8f
            java.lang.Object r4 = r1.zza(r13, r4, r7)     // Catch: java.lang.Throwable -> L8f
            goto L42
        L5b:
            r9 = 26
            if (r8 != r9) goto L6a
            if (r4 == 0) goto L65
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L42
        L65:
            com.google.android.gms.internal.firebase_auth.zzgt r6 = r12.zzn()     // Catch: java.lang.Throwable -> L8f
            goto L42
        L6a:
            boolean r8 = r12.zzc()     // Catch: java.lang.Throwable -> L8f
            if (r8 != 0) goto L42
        L70:
            int r5 = r12.zzb()     // Catch: java.lang.Throwable -> L8f
            r8 = 12
            if (r5 != r8) goto L8a
            if (r6 == 0) goto L83
            if (r4 == 0) goto L80
            r1.zza(r6, r4, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L83
        L80:
            r0.zza(r2, r7, r6)     // Catch: java.lang.Throwable -> L8f
        L83:
            r4 = 1
        L84:
            if (r4 != 0) goto Lc
            r0.zzb(r11, r2)
            return
        L8a:
            com.google.android.gms.internal.firebase_auth.zzip r12 = com.google.android.gms.internal.firebase_auth.zzip.zze()     // Catch: java.lang.Throwable -> L8f
            throw r12     // Catch: java.lang.Throwable -> L8f
        L8f:
            r12 = move-exception
            r0.zzb(r11, r2)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjs.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzkc, com.google.android.gms.internal.firebase_auth.zzhr):void");
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final void zzb(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final boolean zzc(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkf
    public final int zzd(T t) {
        zzkx<?, ?> zzkxVar = this.zzb;
        int iZze = zzkxVar.zze(zzkxVar.zzb(t));
        return this.zzc ? iZze + this.zzd.zza(t).zzg() : iZze;
    }
}
