package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzu extends com.google.firebase.auth.zzab {
    public static final Parcelable.Creator<zzu> CREATOR = new zzt();
    private final List<com.google.firebase.auth.zzaf> zza = new ArrayList();
    private final zzw zzb;
    private final String zzc;
    private final com.google.firebase.auth.zzg zzd;
    private final zzn zze;

    public zzu(List<com.google.firebase.auth.zzaf> list, zzw zzwVar, String str, com.google.firebase.auth.zzg zzgVar, zzn zznVar) {
        for (com.google.firebase.auth.zzaf zzafVar : list) {
            if (zzafVar instanceof com.google.firebase.auth.zzaf) {
                this.zza.add(zzafVar);
            }
        }
        this.zzb = (zzw) Preconditions.checkNotNull(zzwVar);
        this.zzc = Preconditions.checkNotEmpty(str);
        this.zzd = zzgVar;
        this.zze = zznVar;
    }

    public static zzu zza(zzej zzejVar, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        List<com.google.firebase.auth.zzy> listZzc = zzejVar.zzc();
        ArrayList arrayList = new ArrayList();
        for (com.google.firebase.auth.zzy zzyVar : listZzc) {
            if (zzyVar instanceof com.google.firebase.auth.zzaf) {
                arrayList.add((com.google.firebase.auth.zzaf) zzyVar);
            }
        }
        return new zzu(arrayList, zzw.zza(zzejVar.zzc(), zzejVar.zza()), firebaseAuth.zzb().getName(), zzejVar.zzb(), (zzn) firebaseUser);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
