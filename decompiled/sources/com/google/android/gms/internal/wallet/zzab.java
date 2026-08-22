package com.google.android.gms.internal.wallet;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wallet.AutoResolvableVoidResult;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentDataRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzab extends GmsClient<zzs> {
    private final Context zze;
    private final int zzf;
    private final String zzg;
    private final int zzh;
    private final boolean zzi;

    public zzab(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, int i, int i2, boolean z) {
        super(context, looper, 4, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zze = context;
        this.zzf = i;
        Account account = clientSettings.getAccount();
        this.zzg = account != null ? account.name : null;
        this.zzh = i2;
        this.zzi = z;
    }

    private final Bundle zzt() {
        int i = this.zzf;
        String packageName = this.zze.getPackageName();
        String str = this.zzg;
        int i2 = this.zzh;
        boolean z = this.zzi;
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putBoolean("com.google.android.gms.wallet.EXTRA_USING_ANDROID_PAY_BRAND", z);
        bundle.putString("androidPackageName", packageName);
        if (!TextUtils.isEmpty(str)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
        return iInterfaceQueryLocalInterface instanceof zzs ? (zzs) iInterfaceQueryLocalInterface : new zzs(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.wallet.zzj.zzg;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12600000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresAccount() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzp(CreateWalletObjectsRequest createWalletObjectsRequest, int i) {
        zzw zzwVar = new zzw((Activity) this.zze, i);
        try {
            ((zzs) getService()).zzc(createWalletObjectsRequest, zzt(), zzwVar);
        } catch (RemoteException e2) {
            Log.e("WalletClientImpl", "RemoteException creating wallet objects", e2);
            zzwVar.zzg(8, Bundle.EMPTY);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzq(CreateWalletObjectsRequest createWalletObjectsRequest, TaskCompletionSource<AutoResolvableVoidResult> taskCompletionSource) {
        Bundle bundleZzt = zzt();
        bundleZzt.putBoolean("com.google.android.gms.wallet.EXTRA_USING_AUTO_RESOLVABLE_RESULT", true);
        zzz zzzVar = new zzz(taskCompletionSource);
        try {
            ((zzs) getService()).zzc(createWalletObjectsRequest, bundleZzt, zzzVar);
        } catch (RemoteException e2) {
            Log.e("WalletClientImpl", "RemoteException creating wallet objects", e2);
            zzzVar.zzg(8, Bundle.EMPTY);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzr(IsReadyToPayRequest isReadyToPayRequest, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        zzy zzyVar = new zzy(taskCompletionSource);
        try {
            ((zzs) getService()).zzd(isReadyToPayRequest, zzt(), zzyVar);
        } catch (RemoteException e2) {
            Log.e("WalletClientImpl", "RemoteException during isReadyToPay", e2);
            zzyVar.zzc(Status.RESULT_INTERNAL_ERROR, false, Bundle.EMPTY);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzs(PaymentDataRequest paymentDataRequest, TaskCompletionSource<PaymentData> taskCompletionSource) {
        Bundle bundleZzt = zzt();
        bundleZzt.putBoolean("com.google.android.gms.wallet.EXTRA_USING_AUTO_RESOLVABLE_RESULT", true);
        zzaa zzaaVar = new zzaa(taskCompletionSource);
        try {
            ((zzs) getService()).zze(paymentDataRequest, bundleZzt, zzaaVar);
        } catch (RemoteException e2) {
            Log.e("WalletClientImpl", "RemoteException getting payment data", e2);
            zzaaVar.zze(Status.RESULT_INTERNAL_ERROR, null, Bundle.EMPTY);
        }
    }
}
