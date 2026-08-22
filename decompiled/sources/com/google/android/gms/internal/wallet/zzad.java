package com.google.android.gms.internal.wallet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.zzal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzad extends zzal {
    final /* synthetic */ CreateWalletObjectsRequest zza;
    final /* synthetic */ int zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzad(zzae zzaeVar, GoogleApiClient googleApiClient, CreateWalletObjectsRequest createWalletObjectsRequest, int i) {
        super(googleApiClient);
        this.zza = createWalletObjectsRequest;
        this.zzb = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.wallet.zzak, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    /* JADX INFO: renamed from: zza */
    public final void doExecute(zzab zzabVar) {
        zzabVar.zzp(this.zza, this.zzb);
        setResult(Status.RESULT_SUCCESS);
    }
}
