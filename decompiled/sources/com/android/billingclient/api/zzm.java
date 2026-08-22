package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzjh;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzm extends BroadcastReceiver {
    final /* synthetic */ zzn zza;
    private boolean zzb;
    private final boolean zzc;

    zzm(zzn zznVar, boolean z) {
        this.zza = zznVar;
        this.zzc = z;
    }

    private final void zzd(Bundle bundle, BillingResult billingResult, int i) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            this.zza.zze.zza(zzcg.zzb(23, i, billingResult));
            return;
        }
        try {
            this.zza.zze.zza(zzjh.zzC(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzge.zza()));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingBroadcastManager", "Bundle is null.");
            this.zza.zze.zza(zzcg.zzb(11, 1, zzcj.zzk));
            zzn zznVar = this.zza;
            if (zznVar.zzb != null) {
                zznVar.zzb.onPurchasesUpdated(zzcj.zzk, null);
                return;
            }
            return;
        }
        BillingResult billingResultZzf = com.google.android.gms.internal.play_billing.zze.zzf(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        int i = true == Objects.equals(extras.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW") ? 2 : 1;
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List<Purchase> listZzj = com.google.android.gms.internal.play_billing.zze.zzj(extras);
            if (billingResultZzf.getResponseCode() == 0) {
                this.zza.zze.zzc(zzcg.zzd(i));
            } else {
                zzd(extras, billingResultZzf, i);
            }
            this.zza.zzb.onPurchasesUpdated(billingResultZzf, listZzj);
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            if (billingResultZzf.getResponseCode() != 0) {
                zzd(extras, billingResultZzf, i);
                this.zza.zzb.onPurchasesUpdated(billingResultZzf, com.google.android.gms.internal.play_billing.zzbw.zzl());
                return;
            }
            zzn zznVar2 = this.zza;
            if (zznVar2.zzc == null && zznVar2.zzd == null) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                this.zza.zze.zza(zzcg.zzb(77, i, zzcj.zzk));
                this.zza.zzb.onPurchasesUpdated(zzcj.zzk, com.google.android.gms.internal.play_billing.zzbw.zzl());
                return;
            }
            String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
            if (string == null) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                this.zza.zze.zza(zzcg.zzb(16, i, zzcj.zzk));
                this.zza.zzb.onPurchasesUpdated(zzcj.zzk, com.google.android.gms.internal.play_billing.zzbw.zzl());
                return;
            }
            try {
                if (this.zza.zzd != null) {
                    this.zza.zzd.userSelectedAlternativeBilling(new UserChoiceDetails(string));
                } else {
                    JSONArray jSONArrayOptJSONArray = new JSONObject(string).optJSONArray("products");
                    ArrayList arrayList = new ArrayList();
                    if (jSONArrayOptJSONArray != null) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                            if (jSONObjectOptJSONObject != null) {
                                arrayList.add(new zzc(jSONObjectOptJSONObject, null));
                            }
                        }
                    }
                    this.zza.zzc.zza();
                }
                this.zza.zze.zzc(zzcg.zzd(i));
            } catch (JSONException unused) {
                com.google.android.gms.internal.play_billing.zze.zzl("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", string));
                this.zza.zze.zza(zzcg.zzb(17, i, zzcj.zzk));
                this.zza.zzb.onPurchasesUpdated(zzcj.zzk, com.google.android.gms.internal.play_billing.zzbw.zzl());
            }
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        this.zzb = true;
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter, String str) {
        zzm zzmVar;
        try {
            try {
                if (this.zzb) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    zzmVar = this;
                    context.registerReceiver(zzmVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.zzc ? 4 : 2);
                } else {
                    zzmVar = this;
                    context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                zzmVar.zzb = true;
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final synchronized void zzc(Context context) {
        if (!this.zzb) {
            com.google.android.gms.internal.play_billing.zze.zzl("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.zzb = false;
        }
    }
}
