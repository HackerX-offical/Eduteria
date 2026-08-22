package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfg {
    private final String zza;
    private final String zzb;

    public zzfg(Context context) {
        this(context, context.getPackageName());
    }

    private zzfg(Context context, String str) {
        Preconditions.checkNotNull(context);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(str);
        this.zza = strCheckNotEmpty;
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, strCheckNotEmpty);
            if (packageCertificateHashBytes == null) {
                String strValueOf = String.valueOf(str);
                Log.e("FBA-PackageInfo", strValueOf.length() != 0 ? "single cert required: ".concat(strValueOf) : new String("single cert required: "));
                this.zzb = null;
                return;
            }
            this.zzb = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        } catch (PackageManager.NameNotFoundException unused) {
            String strValueOf2 = String.valueOf(str);
            Log.e("FBA-PackageInfo", strValueOf2.length() != 0 ? "no pkg: ".concat(strValueOf2) : new String("no pkg: "));
            this.zzb = null;
        }
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
