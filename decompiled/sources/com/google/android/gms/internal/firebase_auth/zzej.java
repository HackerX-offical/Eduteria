package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzej extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzej> CREATOR = new zzel();
    private String zza;
    private List<zzfh> zzb;
    private com.google.firebase.auth.zzg zzc;

    public zzej(String str, List<zzfh> list, com.google.firebase.auth.zzg zzgVar) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzgVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final com.google.firebase.auth.zzg zzb() {
        return this.zzc;
    }

    public final List<com.google.firebase.auth.zzy> zzc() {
        return com.google.firebase.auth.internal.zzar.zza(this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
