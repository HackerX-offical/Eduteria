package com.google.android.gms.internal.appinvite;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes8.dex */
final class zzj extends zze {
    private final /* synthetic */ zzg zzk;

    zzj(zzg zzgVar) {
        this.zzk = zzgVar;
    }

    @Override // com.google.android.gms.internal.appinvite.zze, com.google.android.gms.internal.appinvite.zzo
    public final void zza(Status status) throws RemoteException {
        this.zzk.setResult(status);
    }
}
