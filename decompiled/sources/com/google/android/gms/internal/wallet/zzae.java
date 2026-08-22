package com.google.android.gms.internal.wallet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.wobs.WalletObjects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzae implements WalletObjects {
    @Override // com.google.android.gms.wallet.wobs.WalletObjects
    public final void createWalletObjects(GoogleApiClient googleApiClient, CreateWalletObjectsRequest createWalletObjectsRequest, int i) {
        googleApiClient.enqueue(new zzad(this, googleApiClient, createWalletObjectsRequest, i));
    }
}
