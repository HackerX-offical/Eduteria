package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.FirebaseApp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzau {
    private volatile int zza;
    private final zzaa zzb;
    private volatile boolean zzc;

    public zzau(FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzaa(firebaseApp));
    }

    private zzau(Context context, zzaa zzaaVar) {
        this.zzc = false;
        this.zza = 0;
        this.zzb = zzaaVar;
        BackgroundDetector.initialize((Application) context.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzax(this));
    }

    public final void zza(int i) {
        if (i > 0 && this.zza == 0) {
            this.zza = i;
            if (zzb()) {
                this.zzb.zza();
            }
        } else if (i == 0 && this.zza != 0) {
            this.zzb.zzc();
        }
        this.zza = i;
    }

    public final void zza(zzff zzffVar) {
        if (zzffVar == null) {
            return;
        }
        long jZze = zzffVar.zze();
        if (jZze <= 0) {
            jZze = 3600;
        }
        long jZzg = zzffVar.zzg() + (jZze * 1000);
        zzaa zzaaVar = this.zzb;
        zzaaVar.zza = jZzg;
        zzaaVar.zzb = -1L;
        if (zzb()) {
            this.zzb.zza();
        }
    }

    public final void zza() {
        this.zzb.zzc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzb() {
        return this.zza > 0 && !this.zzc;
    }
}
