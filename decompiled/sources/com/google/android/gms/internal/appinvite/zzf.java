package com.google.android.gms.internal.appinvite;

import android.app.Activity;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public final class zzf implements AppInviteApi {
    @Override // com.google.android.gms.appinvite.AppInviteApi
    public final PendingResult<Status> updateInvitationOnInstall(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new zzg(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public final PendingResult<Status> convertInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new zzi(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public final PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient googleApiClient, Activity activity, boolean z) {
        return googleApiClient.enqueue(new zzk(this, googleApiClient, activity, z));
    }
}
