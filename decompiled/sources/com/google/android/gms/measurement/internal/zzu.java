package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.appnew.android.Utils.StoreProvider;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzu {
    private final zzhy zza;

    public zzu(zzhy zzhyVar) {
        this.zza = zzhyVar;
    }

    final void zza(String str, Bundle bundle) {
        String string;
        this.zza.zzl().zzt();
        if (this.zza.zzac()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            string = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.zza.zzn().zzr.zza(string);
        this.zza.zzn().zzs.zza(this.zza.zzb().currentTimeMillis());
    }

    final void zza() {
        String str;
        this.zza.zzl().zzt();
        if (zzc()) {
            if (zzd()) {
                this.zza.zzn().zzr.zza(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", SDKConstants.PARAM_INTENT);
                bundle.putLong("_cc", 1L);
                this.zza.zzp().zzc("auto", "_cmpx", bundle);
            } else {
                String strZza = this.zza.zzn().zzr.zza();
                if (TextUtils.isEmpty(strZza)) {
                    this.zza.zzj().zzn().zza("Cache still valid but referrer not found");
                } else {
                    long jZza = ((this.zza.zzn().zzs.zza() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strZza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str2 : uri.getQueryParameterNames()) {
                        bundle2.putString(str2, uri.getQueryParameter(str2));
                    }
                    ((Bundle) pair.second).putLong("_cc", jZza);
                    if (pair.first == null) {
                        str = StoreProvider.StoreData.APP;
                    } else {
                        str = (String) pair.first;
                    }
                    this.zza.zzp().zzc(str, "_cmp", (Bundle) pair.second);
                }
                this.zza.zzn().zzr.zza(null);
            }
            this.zza.zzn().zzs.zza(0L);
        }
    }

    final void zzb() {
        if (zzc() && zzd()) {
            this.zza.zzn().zzr.zza(null);
        }
    }

    private final boolean zzc() {
        return this.zza.zzn().zzs.zza() > 0;
    }

    private final boolean zzd() {
        return zzc() && this.zza.zzb().currentTimeMillis() - this.zza.zzn().zzs.zza() > this.zza.zzf().zzc((String) null, zzbh.zzav);
    }
}
