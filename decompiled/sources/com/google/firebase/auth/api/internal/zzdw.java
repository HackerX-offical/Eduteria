package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdw extends GmsClient<zzed> implements zzdt {
    private static Logger zza = new Logger("FirebaseAuth", "FirebaseAuth:");
    private final Context zzb;
    private final zzei zzc;

    public zzdw(Context context, Looper looper, ClientSettings clientSettings, zzei zzeiVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzb = (Context) Preconditions.checkNotNull(context);
        this.zzc = zzeiVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServicePackage() {
        if (this.zzc.zza) {
            zza.i("Preparing to create service connection to fallback implementation", new Object[0]);
            return this.zzb.getPackageName();
        }
        zza.i("Preparing to create service connection to gms implementation", new Object[0]);
        return "com.google.android.gms";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return DynamiteModule.getLocalVersion(this.zzb, "com.google.firebase.auth") == 0;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        if (getServiceRequestExtraArgs == null) {
            getServiceRequestExtraArgs = new Bundle();
        }
        zzei zzeiVar = this.zzc;
        if (zzeiVar != null) {
            getServiceRequestExtraArgs.putString("com.google.firebase.auth.API_KEY", zzeiVar.zzb());
        }
        getServiceRequestExtraArgs.putString("com.google.firebase.auth.LIBRARY_VERSION", zzek.zzb());
        return getServiceRequestExtraArgs;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.internal.firebase_auth.zze.zzb;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        if (iInterfaceQueryLocalInterface instanceof zzed) {
            return (zzed) iInterfaceQueryLocalInterface;
        }
        return new zzef(iBinder);
    }

    @Override // com.google.firebase.auth.api.internal.zzdt
    public final /* synthetic */ zzed zza() throws DeadObjectException {
        return (zzed) super.getService();
    }
}
