package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.BuildConfig;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.play_billing.zzed;
import com.google.android.gms.internal.play_billing.zzej;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjh;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjm;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzka;
import com.google.android.gms.internal.play_billing.zzkc;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzkj;
import com.google.android.gms.internal.play_billing.zzkx;
import com.google.android.gms.internal.play_billing.zzkz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private PendingPurchasesParams zzB;
    private boolean zzC;
    private ExecutorService zzD;
    private volatile zzed zzE;
    private final Long zzF;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final Handler zzd;
    private volatile zzn zze;
    private Context zzf;
    private zzch zzg;
    private volatile com.google.android.gms.internal.play_billing.zzv zzh;
    private volatile zzba zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private BillingClientImpl(Activity activity, PendingPurchasesParams pendingPurchasesParams, String str) {
        this(activity.getApplicationContext(), pendingPurchasesParams, new zzbm(), str, null, null, null, null);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzch zzchVar) {
        this.zzf = context.getApplicationContext();
        zzka zzkaVarZzc = zzkc.zzc();
        zzkaVarZzc.zzo(str);
        zzkaVarZzc.zzn(this.zzf.getPackageName());
        zzkaVarZzc.zzm(this.zzF.longValue());
        if (zzchVar != null) {
            this.zzg = zzchVar;
        } else {
            this.zzg = new zzcl(this.zzf, (zzkc) zzkaVarZzc.zzf());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zze = new zzn(this.zzf, purchasesUpdatedListener, null, zzbVar, null, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzC = zzbVar != null;
        this.zzf.getPackageName();
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        startConnection(new zzbm(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Future zzE(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaf
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Async task throws exception!", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaA() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzcj.zzm;
                }
            }
            return zzcj.zzk;
        }
    }

    private final String zzaB(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzf.getPackageName();
        }
        return null;
    }

    private static String zzaC() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    private final synchronized ExecutorService zzaD() {
        if (this.zzD == null) {
            this.zzD = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zze.zza, new zzas(this));
        }
        return this.zzD;
    }

    /* JADX WARN: Finally extract failed */
    private final void zzaE(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Throwable {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        int iZza;
        String strZzh;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Consuming purchase with token: " + purchaseToken);
            try {
                synchronized (this.zza) {
                    try {
                        zzvVar = this.zzh;
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                }
                if (zzvVar == null) {
                    try {
                        zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, 119, "Service has been reset to null.", null);
                        return;
                    } catch (DeadObjectException e2) {
                        e = e2;
                        zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, 29, "Error consuming purchase!", e);
                    } catch (Exception e3) {
                        e = e3;
                        zzaW(consumeResponseListener, purchaseToken, zzcj.zzk, 29, "Error consuming purchase!", e);
                    }
                }
                if (this.zzo) {
                    String packageName = this.zzf.getPackageName();
                    boolean z = this.zzo;
                    String str = this.zzc;
                    long jLongValue = this.zzF.longValue();
                    Bundle bundle = new Bundle();
                    if (z) {
                        com.google.android.gms.internal.play_billing.zze.zzc(bundle, str, jLongValue);
                    }
                    Bundle bundleZze = zzvVar.zze(9, packageName, purchaseToken, bundle);
                    iZza = bundleZze.getInt("RESPONSE_CODE");
                    strZzh = com.google.android.gms.internal.play_billing.zze.zzh(bundleZze, "BillingClient");
                } else {
                    iZza = zzvVar.zza(3, this.zzf.getPackageName(), purchaseToken);
                    strZzh = "";
                }
                BillingResult billingResultZza = zzcj.zza(iZza, strZzh);
                if (iZza == 0) {
                    com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Successfully consumed purchase.");
                    consumeResponseListener.onConsumeResponse(billingResultZza, purchaseToken);
                } else {
                    zzaW(consumeResponseListener, purchaseToken, billingResultZza, 23, "Error consuming purchase with token. Response code: " + iZza, null);
                }
            } catch (DeadObjectException e4) {
                e = e4;
                zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, 29, "Error consuming purchase!", e);
            } catch (Exception e5) {
                e = e5;
                zzaW(consumeResponseListener, purchaseToken, zzcj.zzk, 29, "Error consuming purchase!", e);
            }
        } catch (DeadObjectException e6) {
            e = e6;
        } catch (Exception e7) {
            e = e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaF(zzjh zzjhVar) {
        try {
            this.zzg.zzb(zzjhVar, this.zzl);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaG(zzjl zzjlVar) {
        try {
            this.zzg.zzd(zzjlVar, this.zzl);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaH(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            zzbe(2, 11, zzcj.zzm);
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzcj.zzm, null);
        } else if (zzE(new zzau(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzal
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzak(purchaseHistoryResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 11, billingResultZzaA);
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(billingResultZzaA, null);
        }
    }

    private final void zzaI(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            zzbe(2, 9, zzcj.zzm);
            purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzm, com.google.android.gms.internal.play_billing.zzbw.zzl());
        } else if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Please provide a valid product type.");
            zzbe(50, 9, zzcj.zzh);
            purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzh, com.google.android.gms.internal.play_billing.zzbw.zzl());
        } else if (zzE(new zzat(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzac
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzal(purchasesResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 9, billingResultZzaA);
            purchasesResponseListener.onQueryPurchasesResponse(billingResultZzaA, com.google.android.gms.internal.play_billing.zzbw.zzl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ(int i) {
        synchronized (this.zza) {
            if (this.zzb == 3) {
                return;
            }
            com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Setting clientState from " + zzaN(this.zzb) + " to " + zzaN(i));
            this.zzb = i;
        }
    }

    private final synchronized void zzaK() {
        ExecutorService executorService = this.zzD;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzD = null;
            this.zzE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzaL() {
        synchronized (this.zza) {
            if (this.zzi != null) {
                try {
                    this.zzf.unbindService(this.zzi);
                } catch (Throwable th) {
                    try {
                        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzh = null;
                        this.zzi = null;
                    } finally {
                        this.zzh = null;
                        this.zzi = null;
                    }
                }
            }
        }
    }

    private final boolean zzaM() {
        return this.zzw && this.zzB.isEnabledForPrepaidPlans();
    }

    private static final String zzaN(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    private final zzbj zzaO(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        zzbf(i, 7, billingResult, zzcg.zza(exc));
        return new zzbj(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList());
    }

    private final zzbk zzaP(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        zzbf(i, 11, billingResult, zzcg.zza(exc));
        return new zzbk(billingResult, null);
    }

    private final zzcu zzaQ(int i, BillingResult billingResult, int i2, String str, Exception exc) {
        zzbf(i2, 9, billingResult, zzcg.zza(exc));
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        return new zzcu(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzcu zzaR(String str, int i) {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        BillingClientImpl billingClientImpl = this;
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzd = com.google.android.gms.internal.play_billing.zze.zzd(billingClientImpl.zzo, billingClientImpl.zzw, billingClientImpl.zzB.isEnabledForOneTimeProducts(), billingClientImpl.zzB.isEnabledForPrepaidPlans(), billingClientImpl.zzc, billingClientImpl.zzF.longValue());
        String string = null;
        do {
            try {
                synchronized (billingClientImpl.zza) {
                    zzvVar = billingClientImpl.zzh;
                }
                if (zzvVar == null) {
                    return billingClientImpl.zzaQ(9, zzcj.zzm, 119, "Service has been reset to null", null);
                }
                Bundle bundleZzj = billingClientImpl.zzo ? zzvVar.zzj(true != billingClientImpl.zzw ? 9 : 19, billingClientImpl.zzf.getPackageName(), str, string, bundleZzd) : zzvVar.zzi(3, billingClientImpl.zzf.getPackageName(), str, string);
                zzcw zzcwVarZza = zzcx.zza(bundleZzj, "BillingClient", "getPurchase()");
                BillingResult billingResultZza = zzcwVarZza.zza();
                if (billingResultZza != zzcj.zzl) {
                    return billingClientImpl.zzaQ(9, billingResultZza, zzcwVarZza.zzb(), "Purchase bundle invalid", null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z = false;
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    String str2 = stringArrayList2.get(i2);
                    String str3 = stringArrayList3.get(i2);
                    com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i2))));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e2) {
                        return zzaQ(9, zzcj.zzk, 51, "Got an exception trying to decode the purchase!", e2);
                    }
                }
                billingClientImpl = this;
                if (z) {
                    billingClientImpl.zzbe(26, 9, zzcj.zzk);
                }
                string = bundleZzj.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (DeadObjectException e3) {
                return zzaQ(9, zzcj.zzm, 52, "Got exception trying to get purchases try to reconnect", e3);
            } catch (Exception e4) {
                return billingClientImpl.zzaQ(9, zzcj.zzk, 52, "Got exception trying to get purchases try to reconnect", e4);
            }
        } while (!TextUtils.isEmpty(string));
        return new zzcu(zzcj.zzl, arrayList);
    }

    private final zzdb zzaS(BillingResult billingResult, int i, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str, exc);
        zzbf(i, 8, billingResult, zzcg.zza(exc));
        return new zzdb(billingResult.getResponseCode(), billingResult.getDebugMessage(), null);
    }

    private final void zzaT(BillingResult billingResult, int i, int i2) {
        zzjl zzjlVar = null;
        zzjh zzjhVar = null;
        if (billingResult.getResponseCode() == 0) {
            int i3 = zzcg.zza;
            try {
                zzjj zzjjVarZzc = zzjl.zzc();
                zzjjVarZzc.zzn(5);
                zzkg zzkgVarZzc = zzkj.zzc();
                zzkgVarZzc.zza(i2);
                zzjjVarZzc.zza((zzkj) zzkgVarZzc.zzf());
                zzjlVar = (zzjl) zzjjVarZzc.zzf();
            } catch (Exception e2) {
                com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", e2);
            }
            zzaG(zzjlVar);
            return;
        }
        int i4 = zzcg.zza;
        try {
            zzjf zzjfVarZzc = zzjh.zzc();
            zzjm zzjmVarZzc = zzjq.zzc();
            zzjmVarZzc.zzn(billingResult.getResponseCode());
            zzjmVarZzc.zzm(billingResult.getDebugMessage());
            zzjmVarZzc.zzo(i);
            zzjfVarZzc.zza(zzjmVarZzc);
            zzjfVarZzc.zzn(5);
            zzkg zzkgVarZzc2 = zzkj.zzc();
            zzkgVarZzc2.zza(i2);
            zzjfVarZzc.zzm((zzkj) zzkgVarZzc2.zzf());
            zzjhVar = (zzjh) zzjfVarZzc.zzf();
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", e3);
        }
        zzaF(zzjhVar);
    }

    private final void zzaU(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, int i, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Error in acknowledge purchase!", exc);
        zzbf(i, 3, billingResult, zzcg.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    private final void zzaV(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 14, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    private final void zzaW(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, int i, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", str2, exc);
        zzbf(i, 4, billingResult, zzcg.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    private final void zzaX(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 15, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    private final void zzaY(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 24, billingResult, zzcg.zza(exc));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(billingResult, null);
    }

    private final void zzaZ(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 23, billingResult, zzcg.zza(exc));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(billingResult);
    }

    static /* bridge */ /* synthetic */ boolean zzaq(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzax() {
        return Looper.myLooper() == null ? this.zzd : new Handler(Looper.myLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzbk zzay(String str) {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzd = com.google.android.gms.internal.play_billing.zze.zzd(this.zzo, this.zzw, this.zzB.isEnabledForOneTimeProducts(), this.zzB.isEnabledForPrepaidPlans(), this.zzc, this.zzF.longValue());
        String string = null;
        while (this.zzm) {
            try {
                synchronized (this.zza) {
                    zzvVar = this.zzh;
                }
                if (zzvVar == null) {
                    return zzaP(zzcj.zzm, 119, "Service reset to null", null);
                }
                Bundle bundleZzh = zzvVar.zzh(6, this.zzf.getPackageName(), str, string, bundleZzd);
                zzcw zzcwVarZza = zzcx.zza(bundleZzh, "BillingClient", "getPurchaseHistory()");
                BillingResult billingResultZza = zzcwVarZza.zza();
                if (billingResultZza != zzcj.zzl) {
                    zzbe(zzcwVarZza.zzb(), 11, billingResultZza);
                    return new zzbk(billingResultZza, null);
                }
                ArrayList<String> stringArrayList = bundleZzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z = false;
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str2 = stringArrayList2.get(i);
                    String str3 = stringArrayList3.get(i);
                    com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str2, str3);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e2) {
                        return zzaP(zzcj.zzk, 51, "Got an exception trying to decode the purchase!", e2);
                    }
                }
                if (z) {
                    zzbe(26, 11, zzcj.zzk);
                }
                string = bundleZzh.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new zzbk(zzcj.zzl, arrayList);
                }
            } catch (DeadObjectException e3) {
                return zzaP(zzcj.zzm, 59, "Got exception trying to get purchase history", e3);
            } catch (Exception e4) {
                return zzaP(zzcj.zzk, 59, "Got exception trying to get purchase history", e4);
            }
        }
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzbk(zzcj.zzq, null);
    }

    private final BillingResult zzaz() {
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzjj zzjjVarZzc = zzjl.zzc();
        zzjjVarZzc.zzn(6);
        zzkx zzkxVarZzc = zzkz.zzc();
        zzkxVarZzc.zza(true);
        zzjjVarZzc.zzm(zzkxVarZzc);
        zzaG((zzjl) zzjjVarZzc.zzf());
        return zzcj.zzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzba(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 25, billingResult, zzcg.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    private final void zzbb(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, int i, Exception exc) {
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "getBillingConfig got an exception.", exc);
        zzbf(i, 13, billingResult, zzcg.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbc(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 16, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    private final void zzbd(int i, int i2, Exception exc) {
        zzjh zzjhVar;
        com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "showInAppMessages error.", exc);
        zzch zzchVar = this.zzg;
        String strZza = zzcg.zza(exc);
        try {
            zzjm zzjmVarZzc = zzjq.zzc();
            zzjmVarZzc.zzn(i);
            zzjmVarZzc.zzo(i2);
            if (strZza != null) {
                zzjmVarZzc.zza(strZza);
            }
            zzjf zzjfVarZzc = zzjh.zzc();
            zzjfVarZzc.zza(zzjmVarZzc);
            zzjfVarZzc.zzn(30);
            zzjhVar = (zzjh) zzjfVarZzc.zzf();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingLogger", "Unable to create logging payload", th);
            zzjhVar = null;
        }
        zzchVar.zza(zzjhVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbe(int i, int i2, BillingResult billingResult) {
        try {
            zzaF(zzcg.zzb(i, i2, billingResult));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbf(int i, int i2, BillingResult billingResult, String str) {
        try {
            zzaF(zzcg.zzc(i, i2, billingResult, str));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbg(int i) {
        try {
            zzaG(zzcg.zzd(i));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            zzbe(2, 3, zzcj.zzm);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzm);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Please provide a valid purchase token.");
            zzbe(26, 3, zzcj.zzj);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzj);
        } else if (!this.zzo) {
            zzbe(27, 3, zzcj.zzb);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzb);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzt
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzs(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzab(acknowledgePurchaseResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 3, billingResultZzaA);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResultZzaA);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            zzbe(2, 4, zzcj.zzm);
            consumeResponseListener.onConsumeResponse(zzcj.zzm, consumeParams.getPurchaseToken());
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzag
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzt(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzah
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzad(consumeResponseListener, consumeParams);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 4, billingResultZzaA);
            consumeResponseListener.onConsumeResponse(billingResultZzaA, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (!isReady()) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support alternative billing only.");
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzE, 66, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzx
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzx(alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzy
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzae(alternativeBillingOnlyReportingDetailsListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzaA(), 25, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        if (!isReady()) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support external offer.");
            zzaY(externalOfferReportingDetailsListener, zzcj.zzx, 103, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzy(externalOfferReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaf(externalOfferReportingDetailsListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaY(externalOfferReportingDetailsListener, zzaA(), 25, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbg(12);
        synchronized (this.zza) {
            try {
            } finally {
            }
            if (this.zze != null) {
                this.zze.zzf();
                try {
                    com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Unbinding from service.");
                    zzaL();
                } catch (Throwable th) {
                    com.google.android.gms.internal.play_billing.zze.zzm("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                }
                try {
                    zzaK();
                } finally {
                    try {
                    } finally {
                    }
                }
            } else {
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Unbinding from service.");
                zzaL();
                zzaK();
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Service disconnected.");
            zzbe(2, 13, zzcj.zzm);
            billingConfigResponseListener.onBillingConfigResponse(zzcj.zzm, null);
        } else if (!this.zzv) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support get billing config.");
            zzbe(32, 13, zzcj.zzA);
            billingConfigResponseListener.onBillingConfigResponse(zzcj.zzA, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzv
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzu(billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzag(billingConfigResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 13, billingResultZzaA);
            billingConfigResponseListener.onBillingConfigResponse(billingResultZzaA, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        int i;
        synchronized (this.zza) {
            i = this.zzb;
        }
        return i;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (!isReady()) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support alternative billing only.");
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzE, 66, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzad
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzz(alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzah(alternativeBillingOnlyAvailabilityListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzaA(), 25, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (!isReady()) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzm, 2, null);
            return;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support external offer.");
            zzaZ(externalOfferAvailabilityListener, zzcj.zzx, 103, null);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzap
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzA(externalOfferAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzai(externalOfferAvailabilityListener);
            }
        }, zzax(), zzaD()) == null) {
            zzaZ(externalOfferAvailabilityListener, zzaA(), 25, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        if (!isReady()) {
            BillingResult billingResult = zzcj.zzm;
            if (billingResult.getResponseCode() != 0) {
                zzbe(2, 5, billingResult);
            } else {
                zzbg(5);
            }
            return zzcj.zzm;
        }
        int i = zzcj.zzH;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    BillingResult billingResult2 = this.zzk ? zzcj.zzl : zzcj.zzp;
                    zzaT(billingResult2, 10, 3);
                    return billingResult2;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    BillingResult billingResult3 = this.zzs ? zzcj.zzl : zzcj.zzs;
                    zzaT(billingResult3, 31, 6);
                    return billingResult3;
                }
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    BillingResult billingResult4 = this.zzq ? zzcj.zzl : zzcj.zzw;
                    zzaT(billingResult4, 30, 5);
                    return billingResult4;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    BillingResult billingResult5 = this.zzt ? zzcj.zzl : zzcj.zzt;
                    zzaT(billingResult5, 19, 8);
                    return billingResult5;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    BillingResult billingResult6 = this.zzr ? zzcj.zzl : zzcj.zzu;
                    zzaT(billingResult6, 21, 7);
                    return billingResult6;
                }
                break;
            case 100293:
                if (str.equals("eee")) {
                    BillingResult billingResult7 = this.zzt ? zzcj.zzl : zzcj.zzt;
                    zzaT(billingResult7, 61, 9);
                    return billingResult7;
                }
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    BillingResult billingResult8 = this.zzu ? zzcj.zzl : zzcj.zzv;
                    zzaT(billingResult8, 20, 10);
                    return billingResult8;
                }
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    BillingResult billingResult9 = this.zzv ? zzcj.zzl : zzcj.zzA;
                    zzaT(billingResult9, 32, 11);
                    return billingResult9;
                }
                break;
            case 103272:
                if (str.equals("hhh")) {
                    BillingResult billingResult10 = this.zzv ? zzcj.zzl : zzcj.zzB;
                    zzaT(billingResult10, 33, 12);
                    return billingResult10;
                }
                break;
            case 104265:
                if (str.equals("iii")) {
                    BillingResult billingResult11 = this.zzx ? zzcj.zzl : zzcj.zzD;
                    zzaT(billingResult11, 60, 13);
                    return billingResult11;
                }
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    BillingResult billingResult12 = this.zzy ? zzcj.zzl : zzcj.zzE;
                    zzaT(billingResult12, 66, 14);
                    return billingResult12;
                }
                break;
            case 106251:
                if (str.equals(BillingClient.FeatureType.EXTERNAL_OFFER)) {
                    BillingResult billingResult13 = this.zzz ? zzcj.zzl : zzcj.zzx;
                    zzaT(billingResult13, 103, 18);
                    return billingResult13;
                }
                break;
            case 107244:
                if (str.equals("lll")) {
                    BillingResult billingResult14 = this.zzA ? zzcj.zzl : zzcj.zzy;
                    zzaT(billingResult14, 116, 19);
                    return billingResult14;
                }
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    BillingResult billingResult15 = this.zzn ? zzcj.zzl : zzcj.zzr;
                    zzaT(billingResult15, 35, 4);
                    return billingResult15;
                }
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    BillingResult billingResult16 = this.zzj ? zzcj.zzl : zzcj.zzo;
                    zzaT(billingResult16, 9, 2);
                    return billingResult16;
                }
                break;
        }
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
        zzaT(zzcj.zzz, 34, 1);
        return zzcj.zzz;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzb == 2 && this.zzh != null && this.zzi != null) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x049f  */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r35, final com.android.billingclient.api.BillingFlowParams r36) {
        /*
            Method dump skipped, instruction units count: 1502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            zzbe(2, 7, zzcj.zzm);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zzm, new ArrayList());
        } else if (!this.zzu) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Querying product details is not supported.");
            zzbe(20, 7, zzcj.zzv);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zzv, new ArrayList());
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzam
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzbj zzbjVarZzh = this.zza.zzh(queryProductDetailsParams);
                productDetailsResponseListener.onProductDetailsResponse(zzcj.zza(zzbjVarZzh.zza(), zzbjVarZzh.zzb()), zzbjVarZzh.zzc());
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzan
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaj(productDetailsResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 7, billingResultZzaA);
            productDetailsResponseListener.onProductDetailsResponse(billingResultZzaA, new ArrayList());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzaH(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzaI(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            zzbe(2, 8, zzcj.zzm);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzm, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Please fix the input params. SKU type can't be empty.");
            zzbe(49, 8, zzcj.zzg);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzg, null);
        } else if (skusList == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            zzbe(48, 8, zzcj.zzf);
            skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzf, null);
        } else {
            final String str = null;
            if (zzE(new Callable(skuType, skusList, str, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzz
                public final /* synthetic */ String zzb;
                public final /* synthetic */ List zzc;
                public final /* synthetic */ SkuDetailsResponseListener zzd;

                {
                    this.zzd = skuDetailsResponseListener;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdb zzdbVarZzn = this.zza.zzn(this.zzb, this.zzc, null);
                    this.zzd.onSkuDetailsResponse(zzcj.zza(zzdbVarZzn.zza(), zzdbVarZzn.zzb()), zzdbVarZzn.zzc());
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzab
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzam(skuDetailsResponseListener);
                }
            }, zzax(), zzaD()) == null) {
                BillingResult billingResultZzaA = zzaA();
                zzbe(25, 8, billingResultZzaA);
                skuDetailsResponseListener.onSkuDetailsResponse(billingResultZzaA, null);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Service disconnected.");
            return zzcj.zzm;
        }
        if (!this.zzq) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzcj.zzw;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzc);
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        final zzav zzavVar = new zzav(this, this.zzd, inAppMessageResponseListener);
        zzE(new Callable() { // from class: com.android.billingclient.api.zzao
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzv(bundle, activity, zzavVar);
                return null;
            }
        }, 5000L, null, this.zzd, zzaD());
        return zzcj.zzl;
    }

    final /* synthetic */ Void zzA(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzaZ(externalOfferAvailabilityListener, zzcj.zzm, 119, null);
            } else {
                zzvVar.zzs(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbh(externalOfferAvailabilityListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e2) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzm, 91, e2);
        } catch (Exception e3) {
            zzaZ(externalOfferAvailabilityListener, zzcj.zzk, 91, e3);
        }
        return null;
    }

    final /* synthetic */ Void zzB(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzm, 119, null);
            } else {
                zzvVar.zzo(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbd(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e2) {
            zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzm, 74, e2);
        } catch (Exception e3) {
            zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzk, 74, e3);
        }
        return null;
    }

    final /* synthetic */ Void zzC(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzba(externalOfferInformationDialogListener, zzcj.zzm, 119, null);
            } else {
                zzvVar.zzq(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbf(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e2) {
            zzba(externalOfferInformationDialogListener, zzcj.zzm, 98, e2);
        } catch (Exception e3) {
            zzba(externalOfferInformationDialogListener, zzcj.zzk, 98, e3);
        }
        return null;
    }

    final /* synthetic */ void zzab(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzbe(24, 3, zzcj.zzn);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zzn);
    }

    final /* synthetic */ void zzac(BillingResult billingResult) {
        if (this.zze.zzd() != null) {
            this.zze.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    final /* synthetic */ void zzad(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzbe(24, 4, zzcj.zzn);
        consumeResponseListener.onConsumeResponse(zzcj.zzn, consumeParams.getPurchaseToken());
    }

    final /* synthetic */ void zzae(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzaf(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        zzaY(externalOfferReportingDetailsListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzag(BillingConfigResponseListener billingConfigResponseListener) {
        zzbe(24, 13, zzcj.zzn);
        billingConfigResponseListener.onBillingConfigResponse(zzcj.zzn, null);
    }

    final /* synthetic */ void zzah(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzai(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        zzaZ(externalOfferAvailabilityListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzaj(ProductDetailsResponseListener productDetailsResponseListener) {
        zzbe(24, 7, zzcj.zzn);
        productDetailsResponseListener.onProductDetailsResponse(zzcj.zzn, new ArrayList());
    }

    final /* synthetic */ void zzak(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzbe(24, 11, zzcj.zzn);
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzcj.zzn, null);
    }

    final /* synthetic */ void zzal(PurchasesResponseListener purchasesResponseListener) {
        zzbe(24, 9, zzcj.zzn);
        purchasesResponseListener.onQueryPurchasesResponse(zzcj.zzn, com.google.android.gms.internal.play_billing.zzbw.zzl());
    }

    final /* synthetic */ void zzam(SkuDetailsResponseListener skuDetailsResponseListener) {
        zzbe(24, 8, zzcj.zzn);
        skuDetailsResponseListener.onSkuDetailsResponse(zzcj.zzn, null);
    }

    final /* synthetic */ void zzan(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        zzbc(alternativeBillingOnlyInformationDialogListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ void zzao(ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        zzba(externalOfferInformationDialogListener, zzcj.zzn, 24, null);
    }

    final /* synthetic */ Bundle zzd(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            return zzvVar == null ? com.google.android.gms.internal.play_billing.zze.zzn(zzcj.zzm, 119) : zzvVar.zzg(i, this.zzf.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e2) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzm, 5, zzcg.zza(e2));
        } catch (Exception e3) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzk, 5, zzcg.zza(e3));
        }
    }

    final /* synthetic */ Bundle zze(String str, String str2) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            return zzvVar == null ? com.google.android.gms.internal.play_billing.zze.zzn(zzcj.zzm, 119) : zzvVar.zzf(3, this.zzf.getPackageName(), str, str2, null);
        } catch (DeadObjectException e2) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzm, 5, zzcg.zza(e2));
        } catch (Exception e3) {
            return com.google.android.gms.internal.play_billing.zze.zzo(zzcj.zzk, 5, zzcg.zza(e3));
        }
    }

    final zzbj zzh(QueryProductDetailsParams queryProductDetailsParams) {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        ArrayList arrayList = new ArrayList();
        String strZzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzbw zzbwVarZza = queryProductDetailsParams.zza();
        int size = zzbwVarZza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList arrayList2 = new ArrayList(zzbwVarZza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(((QueryProductDetailsParams.Product) arrayList2.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.zzc);
            try {
                synchronized (this.zza) {
                    zzvVar = this.zzh;
                }
                if (zzvVar == null) {
                    return zzaO(zzcj.zzm, 119, "Service has been reset to null.", null);
                }
                boolean z = true;
                int i4 = true != this.zzx ? 17 : 20;
                String packageName = this.zzf.getPackageName();
                boolean zZzaM = zzaM();
                String str = this.zzc;
                zzaB(queryProductDetailsParams);
                zzaB(queryProductDetailsParams);
                zzaB(queryProductDetailsParams);
                long jLongValue = this.zzF.longValue();
                Bundle bundle2 = new Bundle();
                com.google.android.gms.internal.play_billing.zze.zzc(bundle2, str, jLongValue);
                bundle2.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
                bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                if (zZzaM) {
                    bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                }
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                int size3 = arrayList2.size();
                int i5 = 0;
                boolean z2 = false;
                boolean z3 = false;
                while (i5 < size3) {
                    QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList2.get(i5);
                    boolean z4 = z;
                    arrayList4.add(null);
                    z2 |= !TextUtils.isEmpty(null);
                    String strZzb2 = product.zzb();
                    com.google.android.gms.internal.play_billing.zzv zzvVar2 = zzvVar;
                    if (strZzb2.equals("first_party")) {
                        com.google.android.gms.internal.play_billing.zzam.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add(null);
                        z3 = z4;
                    }
                    i5++;
                    zzvVar = zzvVar2;
                    z = z4;
                }
                com.google.android.gms.internal.play_billing.zzv zzvVar3 = zzvVar;
                if (z2) {
                    bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z3 && !TextUtils.isEmpty(null)) {
                    bundle2.putString("accountName", null);
                }
                Bundle bundleZzl = zzvVar3.zzl(i4, packageName, strZzb, bundle, bundle2);
                if (bundleZzl == null) {
                    return zzaO(zzcj.zzC, 44, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzl.containsKey("DETAILS_LIST")) {
                    int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundleZzl, "BillingClient");
                    String strZzh = com.google.android.gms.internal.play_billing.zze.zzh(bundleZzl, "BillingClient");
                    if (iZzb == 0) {
                        return zzaO(zzcj.zza(6, strZzh), 45, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return zzaO(zzcj.zza(iZzb, strZzh), 23, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzl.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaO(zzcj.zzC, 46, "queryProductDetailsAsync got null response list", null);
                }
                for (int i6 = 0; i6 < stringArrayList.size(); i6++) {
                    try {
                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i6));
                        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Got product details: ".concat(productDetails.toString()));
                        arrayList.add(productDetails);
                    } catch (JSONException e2) {
                        return zzaO(zzcj.zza(6, "Error trying to decode SkuDetails."), 47, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e2);
                    }
                }
                i = i2;
            } catch (DeadObjectException e3) {
                return zzaO(zzcj.zzm, 43, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return zzaO(zzcj.zzk, 43, "queryProductDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new zzbj(0, "", arrayList);
    }

    final zzch zzk() {
        return this.zzg;
    }

    final BillingResult zzm(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzd.post(new Runnable() { // from class: com.android.billingclient.api.zzp
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzac(billingResult);
            }
        });
        return billingResult;
    }

    final zzdb zzn(String str, List list, String str2) {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        Bundle bundleZzk;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i, i2 > size ? size : i2));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.zzc);
            try {
                synchronized (this.zza) {
                    zzvVar = this.zzh;
                }
                if (zzvVar == null) {
                    return zzaS(zzcj.zzm, 119, "Service has been reset to null.", null);
                }
                if (this.zzp) {
                    String packageName = this.zzf.getPackageName();
                    int i3 = this.zzl;
                    boolean zIsEnabledForOneTimeProducts = this.zzB.isEnabledForOneTimeProducts();
                    boolean zZzaM = zzaM();
                    String str3 = this.zzc;
                    long jLongValue = this.zzF.longValue();
                    Bundle bundle2 = new Bundle();
                    if (i3 >= 9) {
                        com.google.android.gms.internal.play_billing.zze.zzc(bundle2, str3, jLongValue);
                    }
                    if (i3 >= 9 && zIsEnabledForOneTimeProducts) {
                        bundle2.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
                    }
                    if (zZzaM) {
                        bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                    }
                    bundleZzk = zzvVar.zzl(10, packageName, str, bundle, bundle2);
                } else {
                    bundleZzk = zzvVar.zzk(3, this.zzf.getPackageName(), str, bundle);
                }
                if (bundleZzk == null) {
                    return zzaS(zzcj.zzC, 44, "querySkuDetailsAsync got null sku details list", null);
                }
                if (!bundleZzk.containsKey("DETAILS_LIST")) {
                    int iZzb = com.google.android.gms.internal.play_billing.zze.zzb(bundleZzk, "BillingClient");
                    String strZzh = com.google.android.gms.internal.play_billing.zze.zzh(bundleZzk, "BillingClient");
                    if (iZzb == 0) {
                        return zzaS(zzcj.zza(6, strZzh), 45, "getSkuDetails() returned a bundle with neither an error nor a detail list.", null);
                    }
                    return zzaS(zzcj.zza(iZzb, strZzh), 23, "getSkuDetails() failed. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzk.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaS(zzcj.zzC, 46, "querySkuDetailsAsync got null response list", null);
                }
                for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                    try {
                        SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                        arrayList.add(skuDetails);
                    } catch (JSONException e2) {
                        return zzaS(zzcj.zza(6, "Error trying to decode SkuDetails."), 47, "Got a JSON exception trying to decode SkuDetails.", e2);
                    }
                }
                i = i2;
            } catch (DeadObjectException e3) {
                return zzaS(zzcj.zzm, 43, "querySkuDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return zzaS(zzcj.zzk, 43, "querySkuDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new zzdb(0, "", arrayList);
    }

    final synchronized zzed zzp() {
        if (this.zzE == null) {
            this.zzE = zzej.zza(zzaD());
        }
        return this.zzE;
    }

    final /* synthetic */ Object zzs(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzaU(acknowledgePurchaseResponseListener, zzcj.zzm, 119, null);
                return null;
            }
            String packageName = this.zzf.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzc;
            long jLongValue = this.zzF.longValue();
            Bundle bundle = new Bundle();
            com.google.android.gms.internal.play_billing.zze.zzc(bundle, str, jLongValue);
            Bundle bundleZzd = zzvVar.zzd(9, packageName, purchaseToken, bundle);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zza(com.google.android.gms.internal.play_billing.zze.zzb(bundleZzd, "BillingClient"), com.google.android.gms.internal.play_billing.zze.zzh(bundleZzd, "BillingClient")));
            return null;
        } catch (DeadObjectException e2) {
            zzaU(acknowledgePurchaseResponseListener, zzcj.zzm, 28, e2);
            return null;
        } catch (Exception e3) {
            zzaU(acknowledgePurchaseResponseListener, zzcj.zzk, 28, e3);
            return null;
        }
    }

    final /* synthetic */ Object zzt(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        zzaE(consumeParams, consumeResponseListener);
        return null;
    }

    final /* synthetic */ Object zzu(BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzbb(billingConfigResponseListener, zzcj.zzm, 119, null);
            } else {
                String packageName = this.zzf.getPackageName();
                String str = this.zzc;
                long jLongValue = this.zzF.longValue();
                Bundle bundle = new Bundle();
                com.google.android.gms.internal.play_billing.zze.zzc(bundle, str, jLongValue);
                zzvVar.zzp(18, packageName, bundle, new zzbe(billingConfigResponseListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e2) {
            zzbb(billingConfigResponseListener, zzcj.zzm, 62, e2);
        } catch (Exception e3) {
            zzbb(billingConfigResponseListener, zzcj.zzk, 62, e3);
        }
        return null;
    }

    final /* synthetic */ Object zzv(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzbd(-1, 119, null);
            } else {
                zzvVar.zzt(12, this.zzf.getPackageName(), bundle, new zzbi(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e2) {
            zzbd(-1, 118, e2);
        } catch (Exception e3) {
            zzbd(6, 118, e3);
        }
        return null;
    }

    final /* synthetic */ Void zzx(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, 119, null);
            } else {
                zzvVar.zzm(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbb(alternativeBillingOnlyReportingDetailsListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e2) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzm, 70, e2);
        } catch (Exception e3) {
            zzaX(alternativeBillingOnlyReportingDetailsListener, zzcj.zzk, 70, e3);
        }
        return null;
    }

    final /* synthetic */ Void zzy(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzaY(externalOfferReportingDetailsListener, zzcj.zzm, 119, null);
            } else {
                zzvVar.zzn(22, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbc(externalOfferReportingDetailsListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e2) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzm, 94, e2);
        } catch (Exception e3) {
            zzaY(externalOfferReportingDetailsListener, zzcj.zzk, 94, e3);
        }
        return null;
    }

    final /* synthetic */ Void zzz(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzv zzvVar;
        try {
            synchronized (this.zza) {
                zzvVar = this.zzh;
            }
            if (zzvVar == null) {
                zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, 119, null);
            } else {
                zzvVar.zzr(21, this.zzf.getPackageName(), com.google.android.gms.internal.play_billing.zze.zze(this.zzc, this.zzF.longValue()), new zzbg(alternativeBillingOnlyAvailabilityListener, this.zzg, this.zzl, null));
            }
        } catch (DeadObjectException e2) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzm, 69, e2);
        } catch (Exception e3) {
            zzaV(alternativeBillingOnlyAvailabilityListener, zzcj.zzk, 69, e3);
        }
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzaH(str, purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzaI(str, purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!isReady()) {
            zzbe(2, 16, zzcj.zzm);
            return zzcj.zzm;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzbe(66, 16, zzcj.zzE);
            return zzcj.zzE;
        }
        final zzaw zzawVar = new zzaw(this, this.zzd, alternativeBillingOnlyInformationDialogListener);
        if (zzE(new Callable() { // from class: com.android.billingclient.api.zzr
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzB(alternativeBillingOnlyInformationDialogListener, activity, zzawVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzan(alternativeBillingOnlyInformationDialogListener);
            }
        }, this.zzd, zzaD()) != null) {
            return zzcj.zzl;
        }
        BillingResult billingResultZzaA = zzaA();
        zzbe(25, 16, billingResultZzaA);
        return billingResultZzaA;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!isReady()) {
            zzbe(2, 25, zzcj.zzm);
            return zzcj.zzm;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Current Play Store version doesn't support external offer.");
            zzbe(103, 25, zzcj.zzx);
            return zzcj.zzx;
        }
        final zzax zzaxVar = new zzax(this, this.zzd, externalOfferInformationDialogListener);
        if (zzE(new Callable() { // from class: com.android.billingclient.api.zzai
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzC(externalOfferInformationDialogListener, activity, zzaxVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzak
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzao(externalOfferInformationDialogListener);
            }
        }, this.zzd, zzaD()) != null) {
            return zzcj.zzl;
        }
        BillingResult billingResultZzaA = zzaA();
        zzbe(25, 25, billingResultZzaA);
        return billingResultZzaA;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        BillingResult billingResultZzaz;
        synchronized (this.zza) {
            if (isReady()) {
                billingResultZzaz = zzaz();
            } else if (this.zzb == 1) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client is already in the process of connecting to billing service.");
                zzbe(37, 6, zzcj.zze);
                billingResultZzaz = zzcj.zze;
            } else if (this.zzb == 3) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                zzbe(38, 6, zzcj.zzm);
                billingResultZzaz = zzcj.zzm;
            } else {
                zzaJ(1);
                zzaL();
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Starting in-app billing setup.");
                this.zzi = new zzba(this, billingClientStateListener, null);
                Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                intent.setPackage("com.android.vending");
                List<ResolveInfo> listQueryIntentServices = this.zzf.getPackageManager().queryIntentServices(intent, 0);
                int i = 41;
                if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
                    ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                    if (resolveInfo.serviceInfo != null) {
                        String str = resolveInfo.serviceInfo.packageName;
                        String str2 = resolveInfo.serviceInfo.name;
                        if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "The device doesn't have valid Play Store.");
                        } else {
                            ComponentName componentName = new ComponentName(str, str2);
                            Intent intent2 = new Intent(intent);
                            intent2.setComponent(componentName);
                            intent2.putExtra("playBillingLibraryVersion", this.zzc);
                            synchronized (this.zza) {
                                if (this.zzb == 2) {
                                    billingResultZzaz = zzaz();
                                } else if (this.zzb != 1) {
                                    com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                    zzbe(117, 6, zzcj.zzm);
                                    billingResultZzaz = zzcj.zzm;
                                } else {
                                    zzba zzbaVar = this.zzi;
                                    if (this.zzf.bindService(intent2, zzbaVar, 1)) {
                                        com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Service was bonded successfully.");
                                        billingResultZzaz = null;
                                    } else {
                                        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Connection to Billing service is blocked.");
                                        i = 39;
                                    }
                                }
                            }
                        }
                    } else {
                        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "The device doesn't have valid Play Store.");
                    }
                    i = 40;
                }
                zzaJ(0);
                com.google.android.gms.internal.play_billing.zze.zzk("BillingClient", "Billing service unavailable on device.");
                zzbe(i, 6, zzcj.zzc);
                billingResultZzaz = zzcj.zzc;
            }
        }
        if (billingResultZzaz != null) {
            billingClientStateListener.onBillingSetupFinished(billingResultZzaz);
        }
    }

    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = str;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, str, (zzch) null);
    }

    private BillingClientImpl(String str) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = str;
    }

    BillingClientImpl(String str, Context context, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzF = lValueOf;
        String strZzaC = zzaC();
        this.zzc = strZzaC;
        this.zzf = context.getApplicationContext();
        zzka zzkaVarZzc = zzkc.zzc();
        zzkaVarZzc.zzo(strZzaC);
        zzkaVarZzc.zzn(this.zzf.getPackageName());
        zzkaVarZzc.zzm(lValueOf.longValue());
        this.zzg = new zzcl(this.zzf, (zzkc) zzkaVarZzc.zzf());
        this.zzf.getPackageName();
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, String str, zzch zzchVar) {
        this.zzf = context.getApplicationContext();
        zzka zzkaVarZzc = zzkc.zzc();
        zzkaVarZzc.zzo(str);
        zzkaVarZzc.zzn(this.zzf.getPackageName());
        zzkaVarZzc.zzm(this.zzF.longValue());
        if (zzchVar != null) {
            this.zzg = zzchVar;
        } else {
            this.zzg = new zzcl(this.zzf, (zzkc) zzkaVarZzc.zzf());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zze = new zzn(this.zzf, purchasesUpdatedListener, null, null, userChoiceBillingListener, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzC = userChoiceBillingListener != null;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzco zzcoVar, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzF = lValueOf;
        this.zzc = zzaC();
        this.zzf = context.getApplicationContext();
        zzka zzkaVarZzc = zzkc.zzc();
        zzkaVarZzc.zzo(zzaC());
        zzkaVarZzc.zzn(this.zzf.getPackageName());
        zzkaVarZzc.zzm(lValueOf.longValue());
        this.zzg = new zzcl(this.zzf, (zzkc) zzkaVarZzc.zzf());
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zze = new zzn(this.zzf, null, null, null, null, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzf.getPackageName();
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzch zzchVar, ExecutorService executorService) {
        String strZzaC = zzaC();
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = strZzaC;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, (zzb) null, strZzaC, (zzch) null);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, zzaC(), null, userChoiceBillingListener, null, null);
    }
}
