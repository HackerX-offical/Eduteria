package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzca {
    private final List zza = new ArrayList();

    public final zzca zza(zzcp zzcpVar) {
        if (zzcpVar.zzd()) {
            throw new IllegalArgumentException(zzan.zza("range must not be empty, but was %s", zzcpVar));
        }
        this.zza.add(zzcpVar);
        return this;
    }

    final zzca zzb(zzca zzcaVar) {
        Iterator it = zzcaVar.zza.iterator();
        while (it.hasNext()) {
            zza((zzcp) it.next());
        }
        return this;
    }

    public final zzcb zzc() {
        zzbs zzbsVar = new zzbs(this.zza.size());
        Collections.sort(this.zza, zzco.zza);
        Iterator it = this.zza.iterator();
        zzcg zzcgVar = it instanceof zzcg ? (zzcg) it : new zzcg(it);
        while (zzcgVar.hasNext()) {
            zzcp zzcpVarZzc = (zzcp) zzcgVar.next();
            while (zzcgVar.hasNext()) {
                zzcp zzcpVar = (zzcp) zzcgVar.zza();
                if (zzcpVarZzc.zza.compareTo(zzcpVar.zzb) > 0 || zzcpVar.zza.compareTo(zzcpVarZzc.zzb) > 0) {
                    break;
                }
                zzam.zzd(zzcpVarZzc.zzb(zzcpVar).zzd(), "Overlapping ranges not permitted but found %s overlapping %s", zzcpVarZzc, zzcpVar);
                zzcpVarZzc = zzcpVarZzc.zzc((zzcp) zzcgVar.next());
            }
            zzbsVar.zzd(zzcpVarZzc);
        }
        zzbw zzbwVarZze = zzbsVar.zze();
        if (zzbwVarZze.isEmpty()) {
            return zzcb.zzb();
        }
        if (zzbwVarZze.size() == 1) {
            zzdf zzdfVarListIterator = zzbwVarZze.listIterator(0);
            Object next = zzdfVarListIterator.next();
            if (zzdfVarListIterator.hasNext()) {
                StringBuilder sb = new StringBuilder("expected one element but was: <");
                sb.append(next);
                for (int i = 0; i < 4 && zzdfVarListIterator.hasNext(); i++) {
                    sb.append(", ");
                    sb.append(zzdfVarListIterator.next());
                }
                if (zzdfVarListIterator.hasNext()) {
                    sb.append(", ...");
                }
                sb.append(Typography.greater);
                throw new IllegalArgumentException(sb.toString());
            }
            if (((zzcp) next).equals(zzcp.zza())) {
                return zzcb.zza();
            }
        }
        return new zzcb(zzbwVarZze);
    }
}
