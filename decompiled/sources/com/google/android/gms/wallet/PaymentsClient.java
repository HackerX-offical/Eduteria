package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wallet.Wallet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public class PaymentsClient extends GoogleApi<Wallet.WalletOptions> {
    public static final /* synthetic */ int zza = 0;

    PaymentsClient(Activity activity, Wallet.WalletOptions walletOptions) {
        super(activity, Wallet.API, walletOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Boolean> isReadyToPay(final IsReadyToPayRequest isReadyToPayRequest) {
        return doRead(TaskApiCall.builder().setMethodKey(23705).run(new RemoteCall() { // from class: com.google.android.gms.wallet.zzab
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                int i = PaymentsClient.zza;
                ((com.google.android.gms.internal.wallet.zzab) obj).zzr(isReadyToPayRequest, (TaskCompletionSource) obj2);
            }
        }).build());
    }

    public Task<PaymentData> loadPaymentData(final PaymentDataRequest paymentDataRequest) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.wallet.zzac
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i = PaymentsClient.zza;
                ((com.google.android.gms.internal.wallet.zzab) obj).zzs(paymentDataRequest, (TaskCompletionSource) obj2);
            }
        }).setFeatures(zzj.zzc).setAutoResolveMissingFeatures(true).setMethodKey(23707).build());
    }

    PaymentsClient(Context context, Wallet.WalletOptions walletOptions) {
        super(context, Wallet.API, walletOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
