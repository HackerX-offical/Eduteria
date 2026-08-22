package com.google.android.gms.internal.appinvite;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
final class zzk extends zzh<AppInviteInvitationResult> {
    private final WeakReference<Activity> zzl;
    private final boolean zzm;
    private final Intent zzn;

    public zzk(zzf zzfVar, GoogleApiClient googleApiClient, Activity activity, boolean z) {
        super(googleApiClient);
        this.zzm = z;
        this.zzl = new WeakReference<>(activity);
        this.zzn = activity != null ? activity.getIntent() : null;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzm zzmVar = (zzm) anyClient;
        if (AppInviteReferral.hasReferral(this.zzn)) {
            setResult(new zzp(Status.RESULT_SUCCESS, this.zzn));
            zzmVar.zza((zzo) null);
        } else {
            zzmVar.zza(new zzn(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* synthetic */ Result createFailedResult(Status status) {
        return new zzp(status, new Intent());
    }
}
