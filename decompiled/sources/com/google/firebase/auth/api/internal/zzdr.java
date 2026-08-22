package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdr implements Callable<zzal<zzei>> {
    private final zzei zza;
    private final Context zzb;

    public zzdr(zzei zzeiVar, Context context) {
        this.zza = zzeiVar;
        this.zzb = context;
    }

    private final GoogleApi<zzei> zza(boolean z, Context context) {
        zzei zzeiVar = (zzei) this.zza.clone();
        zzeiVar.zza = z;
        return new zzaq(context, zzeh.zza, zzeiVar, new FirebaseExceptionMapper());
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzal<zzei> call() throws Exception {
        int remoteVersion;
        if (zzds.zza == -1 || zzds.zzb == -1) {
            int localVersion = DynamiteModule.getLocalVersion(this.zzb, "com.google.firebase.auth");
            if (localVersion == 0) {
                remoteVersion = 1;
            } else {
                int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzb, 12451000);
                remoteVersion = (iIsGooglePlayServicesAvailable == 0 || iIsGooglePlayServicesAvailable == 2) ? DynamiteModule.getRemoteVersion(this.zzb, "com.google.android.gms.firebase_auth") : 0;
            }
            int unused = zzds.zza = remoteVersion;
            int unused2 = zzds.zzb = localVersion;
        }
        return new zzal<>(zzds.zza != 0 ? zza(false, this.zzb) : null, zzds.zzb != 0 ? zza(true, this.zzb) : null, new zzan(zzds.zza, zzds.zzb, Collections.emptyMap()));
    }
}
