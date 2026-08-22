package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zzkm;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcn {
    private boolean zza;
    private Transport zzb;

    zzcn(Context context) {
        try {
            TransportRuntime.initialize(context);
            this.zzb = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE).getTransport("PLAY_BILLING_LIBRARY", zzkm.class, Encoding.of("proto"), new Transformer() { // from class: com.android.billingclient.api.zzcm
                @Override // com.google.android.datatransport.Transformer
                public final Object apply(Object obj) {
                    return ((zzkm) obj).zzh();
                }
            });
        } catch (Throwable unused) {
            this.zza = true;
        }
    }

    public final void zza(zzkm zzkmVar) {
        if (this.zza) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.zzb.send(Event.ofData(zzkmVar));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingLogger", "logging failed.");
        }
    }
}
