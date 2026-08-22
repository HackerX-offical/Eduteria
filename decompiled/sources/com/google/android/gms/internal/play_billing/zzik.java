package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzik implements Iterator {
    final /* synthetic */ zzin zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzik(zzin zzinVar, zzim zzimVar) {
        this.zza = zzinVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzin zzinVar = this.zza;
        if (i >= zzinVar.zzb) {
            return !zzinVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzin zzinVar = this.zza;
        return i < zzinVar.zzb ? (zzij) zzinVar.zza[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzo();
        int i = this.zzb;
        zzin zzinVar = this.zza;
        if (i >= zzinVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzinVar.zzm(i);
        }
    }
}
