package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzfh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzar {
    public static com.google.firebase.auth.zzy zza(zzfh zzfhVar) {
        if (zzfhVar == null || TextUtils.isEmpty(zzfhVar.zza())) {
            return null;
        }
        return new com.google.firebase.auth.zzaf(zzfhVar.zzb(), zzfhVar.zzc(), zzfhVar.zzd(), zzfhVar.zza());
    }

    public static List<com.google.firebase.auth.zzy> zza(List<zzfh> list) {
        if (list == null || list.isEmpty()) {
            return zzbg.zza();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<zzfh> it = list.iterator();
        while (it.hasNext()) {
            com.google.firebase.auth.zzy zzyVarZza = zza(it.next());
            if (zzyVarZza != null) {
                arrayList.add(zzyVarZza);
            }
        }
        return arrayList;
    }
}
