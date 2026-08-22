package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzem extends AbstractSafeParcelable implements com.google.firebase.auth.api.internal.zzdz<zzem, zzp.zzb> {
    public static final Parcelable.Creator<zzem> CREATOR = new zzep();
    private String zza;
    private boolean zzb;
    private String zzc;
    private boolean zzd;
    private zzfw zze;
    private List<String> zzf;

    public zzem() {
        this.zze = zzfw.zzb();
    }

    public zzem(String str, boolean z, String str2, boolean z2, zzfw zzfwVar, List<String> list) {
        this.zza = str;
        this.zzb = z;
        this.zzc = str2;
        this.zzd = z2;
        this.zze = zzfwVar == null ? zzfw.zzb() : zzfw.zza(zzfwVar);
        this.zzf = list;
    }

    public final List<String> zzb() {
        return this.zzf;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zze, i, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final zzjz<zzp.zzb> zza() {
        return zzp.zzb.zzi();
    }

    @Override // com.google.firebase.auth.api.internal.zzdz
    public final /* synthetic */ com.google.firebase.auth.api.internal.zzdz zza(zzjp zzjpVar) {
        zzfw zzfwVar;
        if (!(zzjpVar instanceof zzp.zzb)) {
            throw new IllegalArgumentException("The passed proto must be an instance of CreateAuthUriResponse.");
        }
        zzp.zzb zzbVar = (zzp.zzb) zzjpVar;
        this.zza = Strings.emptyToNull(zzbVar.zza());
        this.zzb = zzbVar.zzd();
        this.zzc = Strings.emptyToNull(zzbVar.zze());
        this.zzd = zzbVar.zzf();
        if (zzbVar.zzc() == 0) {
            zzfwVar = zzfw.zzb();
        } else {
            zzfwVar = new zzfw(1, new ArrayList(zzbVar.zzb()));
        }
        this.zze = zzfwVar;
        this.zzf = zzbVar.zzh() == 0 ? new ArrayList<>(0) : zzbVar.zzg();
        return this;
    }
}
