package com.google.android.gms.wallet.callback;

import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zze implements OnCompleteListener<PaymentAuthorizationResult> {
    private final OnCompleteListener<CallbackOutput> zza;

    zze(OnCompleteListener<CallbackOutput> onCompleteListener) {
        this.zza = onCompleteListener;
    }

    @Override // com.google.android.gms.wallet.callback.OnCompleteListener
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized void complete(PaymentAuthorizationResult paymentAuthorizationResult) {
        OnCompleteListener<CallbackOutput> onCompleteListener = this.zza;
        zzj zzjVarZza = CallbackOutput.zza();
        CallbackOutput callbackOutput = zzjVarZza.zza;
        callbackOutput.zza = 1;
        callbackOutput.zzb = 1;
        byte[] bArrSerializeToBytes = SafeParcelableSerializer.serializeToBytes(paymentAuthorizationResult);
        CallbackOutput callbackOutput2 = zzjVarZza.zza;
        callbackOutput2.zzc = bArrSerializeToBytes;
        onCompleteListener.complete(callbackOutput2);
    }
}
