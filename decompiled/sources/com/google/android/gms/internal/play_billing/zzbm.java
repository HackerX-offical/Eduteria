package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzbm implements Comparable, Serializable {
    final Comparable zza = "";

    zzbm(Comparable comparable) {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzbm) {
            try {
                if (compareTo((zzbm) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public int compareTo(zzbm zzbmVar) {
        if (zzbmVar == zzbl.zzb) {
            return 1;
        }
        if (zzbmVar == zzbj.zzb) {
            return -1;
        }
        Comparable comparable = zzbmVar.zza;
        int i = zzcp.zzc;
        int iCompareTo = "".compareTo("");
        return iCompareTo != 0 ? iCompareTo : Boolean.compare(this instanceof zzbk, zzbmVar instanceof zzbk);
    }

    abstract void zzc(StringBuilder sb);

    abstract void zzd(StringBuilder sb);
}
