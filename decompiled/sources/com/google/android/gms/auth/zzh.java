package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.paytm.pgsdk.Constants;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes8.dex */
final class zzh implements zzk {
    final /* synthetic */ String zza;
    final /* synthetic */ Bundle zzb;

    zzh(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    @Override // com.google.android.gms.auth.zzk
    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle bundleZzd = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzd(this.zza, this.zzb);
        zzl.zzc(bundleZzd);
        String string = bundleZzd.getString(Constants.EVENT_ACTION_ERROR);
        if (bundleZzd.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
