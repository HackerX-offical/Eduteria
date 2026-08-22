package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzw extends com.google.firebase.auth.zzaa {
    public static final Parcelable.Creator<zzw> CREATOR = new zzv();
    private String zza;
    private String zzb;
    private List<com.google.firebase.auth.zzaf> zzc;

    private zzw() {
    }

    zzw(String str, String str2, List<com.google.firebase.auth.zzaf> list) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
    }

    public static zzw zza(List<com.google.firebase.auth.zzy> list, String str) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotEmpty(str);
        zzw zzwVar = new zzw();
        zzwVar.zzc = new ArrayList();
        for (com.google.firebase.auth.zzy zzyVar : list) {
            if (zzyVar instanceof com.google.firebase.auth.zzaf) {
                zzwVar.zzc.add((com.google.firebase.auth.zzaf) zzyVar);
            }
        }
        zzwVar.zzb = str;
        return zzwVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
