package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.wallet.Wallet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaj extends Api.AbstractClientBuilder<com.google.android.gms.internal.wallet.zzab, Wallet.WalletOptions> {
    zzaj() {
    }

    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Wallet.WalletOptions walletOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Wallet.WalletOptions walletOptions2 = walletOptions;
        if (walletOptions2 == null) {
            walletOptions2 = new Wallet.WalletOptions((zzaj) null);
        }
        return new com.google.android.gms.internal.wallet.zzab(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener, walletOptions2.environment, walletOptions2.theme, walletOptions2.zzb);
    }
}
