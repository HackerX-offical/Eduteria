package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzai {
    private final String zza;
    private final zzah zzb;
    private zzah zzc;

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzah zzahVar = this.zzb.zzb;
        String str = "";
        while (zzahVar != null) {
            Object obj = zzahVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzahVar = zzahVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzai zza(@CheckForNull Object obj) {
        zzah zzahVar = new zzah();
        this.zzc.zzb = zzahVar;
        this.zzc = zzahVar;
        zzahVar.zza = obj;
        return this;
    }

    /* synthetic */ zzai(String str, zzaj zzajVar) {
        zzah zzahVar = new zzah();
        this.zzb = zzahVar;
        this.zzc = zzahVar;
        str.getClass();
        this.zza = str;
    }
}
