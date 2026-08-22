package com.google.android.gms.internal.vision;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhv implements Comparator<zzht> {
    zzhv() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzht zzhtVar, zzht zzhtVar2) {
        zzht zzhtVar3 = zzhtVar;
        zzht zzhtVar4 = zzhtVar2;
        zzhy zzhyVar = (zzhy) zzhtVar3.iterator();
        zzhy zzhyVar2 = (zzhy) zzhtVar4.iterator();
        while (zzhyVar.hasNext() && zzhyVar2.hasNext()) {
            int iCompare = Integer.compare(zzht.zzb(zzhyVar.zza()), zzht.zzb(zzhyVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzhtVar3.zza(), zzhtVar4.zza());
    }
}
