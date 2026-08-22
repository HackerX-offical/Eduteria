package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzp;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzeu extends AbstractSafeParcelable implements com.google.firebase.auth.api.internal.zzdz<zzeu, zzp.zzg> {
    public static final Parcelable.Creator<zzeu> CREATOR = new zzex();
    private zzey zza;

    public zzeu() {
    }

    zzeu(zzey zzeyVar) {
        this.zza = zzeyVar == null ? new zzey() : zzey.zza(zzeyVar);
    }

    public final List<zzew> zzb() {
        return this.zza.zza();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzg> zza() {
        return zzp.zzg.zzb();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        if (!(zzjpVar instanceof zzp.zzg)) {
            throw new IllegalArgumentException("The passed proto must be an instance of GetAccountInfoResponse.");
        }
        zzp.zzg zzgVar = (zzp.zzg) zzjpVar;
        if (zzgVar.zza() == 0) {
            this.zza = new zzey();
            return this;
        }
        this.zza = zzey.zza(zzgVar);
        return this;
    }
}
