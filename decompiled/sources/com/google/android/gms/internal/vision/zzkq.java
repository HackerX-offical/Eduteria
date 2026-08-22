package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkq<T> implements zzlc<T> {
    private final zzkk zza;
    private final zzlu<?, ?> zzb;
    private final boolean zzc;
    private final zziq<?> zzd;

    private zzkq(zzlu<?, ?> zzluVar, zziq<?> zziqVar, zzkk zzkkVar) {
        this.zzb = zzluVar;
        this.zzc = zziqVar.zza(zzkkVar);
        this.zzd = zziqVar;
        this.zza = zzkkVar;
    }

    static <T> zzkq<T> zza(zzlu<?, ?> zzluVar, zziq<?> zziqVar, zzkk zzkkVar) {
        return new zzkq<>(zzluVar, zziqVar, zzkkVar);
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final T zza() {
        return (T) this.zza.zzq().zze();
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final int zza(T t) {
        int iHashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zzb(T t, T t2) {
        zzle.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzle.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zza(T t, zzmr zzmrVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zziw zziwVar = (zziw) entry.getKey();
            if (zziwVar.zzc() != zzmo.MESSAGE || zziwVar.zzd() || zziwVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzjr) {
                zzmrVar.zza(zziwVar.zza(), (Object) ((zzjr) entry).zza().zzc());
            } else {
                zzmrVar.zza(zziwVar.zza(), entry.getValue());
            }
        }
        zzlu<?, ?> zzluVar = this.zzb;
        zzluVar.zzb(zzluVar.zzb(t), zzmrVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c2 A[EDGE_INSN: B:61:0x00c2->B:33:0x00c2 BREAK  A[LOOP:1: B:17:0x0069->B:64:0x0069], SYNTHETIC] */
    @Override // com.google.android.gms.internal.vision.zzlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.vision.zzhn r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzkq.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzhn):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:0: B:45:0x000c->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.vision.zzlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r11, com.google.android.gms.internal.vision.zzld r12, com.google.android.gms.internal.vision.zzio r13) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.gms.internal.vision.zzlu<?, ?> r0 = r10.zzb
            com.google.android.gms.internal.vision.zziq<?> r1 = r10.zzd
            java.lang.Object r2 = r0.zzc(r11)
            com.google.android.gms.internal.vision.zziu r3 = r1.zzb(r11)
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
            com.google.android.gms.internal.vision.zzkk r5 = r10.zza     // Catch: java.lang.Throwable -> L8f
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
            com.google.android.gms.internal.vision.zzkk r4 = r10.zza     // Catch: java.lang.Throwable -> L8f
            java.lang.Object r4 = r1.zza(r13, r4, r7)     // Catch: java.lang.Throwable -> L8f
            goto L42
        L5b:
            r9 = 26
            if (r8 != r9) goto L6a
            if (r4 == 0) goto L65
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L8f
            goto L42
        L65:
            com.google.android.gms.internal.vision.zzht r6 = r12.zzn()     // Catch: java.lang.Throwable -> L8f
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
            com.google.android.gms.internal.vision.zzjk r12 = com.google.android.gms.internal.vision.zzjk.zze()     // Catch: java.lang.Throwable -> L8f
            throw r12     // Catch: java.lang.Throwable -> L8f
        L8f:
            r12 = move-exception
            r0.zzb(r11, r2)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzkq.zza(java.lang.Object, com.google.android.gms.internal.vision.zzld, com.google.android.gms.internal.vision.zzio):void");
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final int zzb(T t) {
        zzlu<?, ?> zzluVar = this.zzb;
        int iZze = zzluVar.zze(zzluVar.zzb(t));
        return this.zzc ? iZze + this.zzd.zza(t).zzg() : iZze;
    }
}
