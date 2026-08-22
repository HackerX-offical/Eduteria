package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjh;
import com.google.android.gms.internal.play_billing.zzjm;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzkw;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzba implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final BillingClientStateListener zzb;

    /* synthetic */ zzba(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzbl zzblVar) {
        this.zza = billingClientImpl;
        this.zzb = billingClientStateListener;
    }

    private final void zzc(BillingResult billingResult) {
        synchronized (this.zza.zza) {
            if (this.zza.zzb == 3) {
                return;
            }
            this.zzb.onBillingSetupFinished(billingResult);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing service died.");
        try {
            if (BillingClientImpl.zzaq(this.zza)) {
                zzch zzchVar = this.zza.zzg;
                zzjf zzjfVarZzc = zzjh.zzc();
                zzjfVarZzc.zzn(6);
                zzjm zzjmVarZzc = zzjq.zzc();
                zzjmVarZzc.zzo(122);
                zzjfVarZzc.zza(zzjmVarZzc);
                zzchVar.zza((zzjh) zzjfVarZzc.zzf());
            } else {
                this.zza.zzg.zze(zzjt.zzB());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
        synchronized (this.zza.zza) {
            if (this.zza.zzb != 3 && this.zza.zzb != 0) {
                this.zza.zzaJ(0);
                this.zza.zzaL();
                this.zzb.onBillingServiceDisconnected();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Billing service connected.");
        synchronized (this.zza.zza) {
            if (this.zza.zzb == 3) {
                return;
            }
            this.zza.zzh = com.google.android.gms.internal.play_billing.zzu.zzu(iBinder);
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzE(new Callable() { // from class: com.android.billingclient.api.zzay
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    this.zza.zza();
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            }, billingClientImpl.zzax(), billingClientImpl.zzaD()) == null) {
                BillingClientImpl billingClientImpl2 = this.zza;
                BillingResult billingResultZzaA = billingClientImpl2.zzaA();
                billingClientImpl2.zzbe(25, 6, billingResultZzaA);
                zzc(billingResultZzaA);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing service disconnected.");
        try {
            if (BillingClientImpl.zzaq(this.zza)) {
                zzch zzchVar = this.zza.zzg;
                zzjf zzjfVarZzc = zzjh.zzc();
                zzjfVarZzc.zzn(6);
                zzjm zzjmVarZzc = zzjq.zzc();
                zzjmVarZzc.zzo(121);
                zzjfVarZzc.zza(zzjmVarZzc);
                zzchVar.zza((zzjh) zzjfVarZzc.zzf());
            } else {
                this.zza.zzg.zzg(zzkw.zzB());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
        synchronized (this.zza.zza) {
            if (this.zza.zzb == 3) {
                return;
            }
            this.zza.zzaJ(0);
            this.zzb.onBillingServiceDisconnected();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0274  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ java.lang.Object zza() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzba.zza():java.lang.Object");
    }

    final /* synthetic */ void zzb() {
        this.zza.zzaJ(0);
        this.zza.zzbe(24, 6, zzcj.zzn);
        zzc(zzcj.zzn);
    }
}
