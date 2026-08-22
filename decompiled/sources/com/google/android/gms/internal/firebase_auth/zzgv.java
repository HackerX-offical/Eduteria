package com.google.android.gms.internal.firebase_auth;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzgv implements Comparator<zzgt> {
    zzgv() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzgt zzgtVar, zzgt zzgtVar2) {
        zzgt zzgtVar3 = zzgtVar;
        zzgt zzgtVar4 = zzgtVar2;
        zzhc zzhcVar = (zzhc) zzgtVar3.iterator();
        zzhc zzhcVar2 = (zzhc) zzgtVar4.iterator();
        while (zzhcVar.hasNext() && zzhcVar2.hasNext()) {
            int iCompare = Integer.compare(zzgt.zzb(zzhcVar.zza()), zzgt.zzb(zzhcVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzgtVar3.zza(), zzgtVar4.zza());
    }
}
