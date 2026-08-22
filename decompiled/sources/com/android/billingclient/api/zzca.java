package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzca implements ServiceConnection {
    final /* synthetic */ zzcc zza;

    /* synthetic */ zzca(zzcc zzccVar, zzcb zzcbVar) {
        this.zza = zzccVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClientTesting", "Billing Override Service connected.");
        this.zza.zzc = com.google.android.gms.internal.play_billing.zzac.zzc(iBinder);
        this.zza.zzb = 2;
        this.zza.zzaT(26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClientTesting", "Billing Override Service disconnected.");
        this.zza.zzc = null;
        this.zza.zzb = 0;
    }
}
