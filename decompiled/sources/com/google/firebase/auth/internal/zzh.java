package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzh implements AuthResult {
    public static final Parcelable.Creator<zzh> CREATOR = new zzk();
    private zzn zza;
    private zzf zzb;
    private com.google.firebase.auth.zzg zzc;

    zzh(zzn zznVar, zzf zzfVar, com.google.firebase.auth.zzg zzgVar) {
        this.zza = zznVar;
        this.zzb = zzfVar;
        this.zzc = zzgVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public zzh(zzn zznVar) {
        zzn zznVar2 = (zzn) Preconditions.checkNotNull(zznVar);
        this.zza = zznVar2;
        List<zzj> listZzi = zznVar2.zzi();
        this.zzb = null;
        for (int i = 0; i < listZzi.size(); i++) {
            if (!TextUtils.isEmpty(listZzi.get(i).zza())) {
                this.zzb = new zzf(listZzi.get(i).getProviderId(), listZzi.get(i).zza(), zznVar.zzj());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzf(zznVar.zzj());
        }
        this.zzc = zznVar.zzk();
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser getUser() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
