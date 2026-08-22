package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzju implements zzgu {
    static final zzgu zza = new zzju();

    private zzju() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgu
    public final boolean zza(int i) {
        return (i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : zzjv.ALTERNATIVE_BILLING_ACTION : zzjv.LOCAL_PURCHASES_UPDATED_ACTION : zzjv.PURCHASES_UPDATED_ACTION : zzjv.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
