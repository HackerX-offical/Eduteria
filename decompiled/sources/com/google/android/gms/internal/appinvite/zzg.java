package com.google.android.gms.internal.appinvite;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes8.dex */
final class zzg extends zzh<Status> {
    private final String zzj;

    public zzg(zzf zzfVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzj = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzm zzmVar = (zzm) anyClient;
        try {
            ((zzq) zzmVar.getService()).zza(new zzj(this), this.zzj);
        } catch (RemoteException unused) {
        }
    }
}
