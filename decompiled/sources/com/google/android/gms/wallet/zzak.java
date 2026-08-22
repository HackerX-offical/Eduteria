package com.google.android.gms.wallet;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzak<R extends Result> extends BaseImplementation.ApiMethodImpl<R, com.google.android.gms.internal.wallet.zzab> {
    public zzak(GoogleApiClient googleApiClient) {
        super(Wallet.API, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract void doExecute(com.google.android.gms.internal.wallet.zzab zzabVar) throws RemoteException;
}
