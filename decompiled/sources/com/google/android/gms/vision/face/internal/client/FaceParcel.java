package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public class FaceParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FaceParcel> CREATOR = new zzd();
    public final int zza;
    public final float zzb;
    public final float zzc;
    public final float zzd;
    public final float zze;
    public final float zzf;
    public final float zzg;
    public final float zzh;
    public final LandmarkParcel[] zzi;
    public final float zzj;
    public final float zzk;
    public final float zzl;
    public final zza[] zzm;
    public final float zzn;
    private final int zzo;

    public FaceParcel(int i, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, LandmarkParcel[] landmarkParcelArr, float f9, float f10, float f11, zza[] zzaVarArr, float f12) {
        this.zzo = i;
        this.zza = i2;
        this.zzb = f2;
        this.zzc = f3;
        this.zzd = f4;
        this.zze = f5;
        this.zzf = f6;
        this.zzg = f7;
        this.zzh = f8;
        this.zzi = landmarkParcelArr;
        this.zzj = f9;
        this.zzk = f10;
        this.zzl = f11;
        this.zzm = zzaVarArr;
        this.zzn = f12;
    }

    public FaceParcel(int i, int i2, float f2, float f3, float f4, float f5, float f6, float f7, LandmarkParcel[] landmarkParcelArr, float f8, float f9, float f10) {
        this(i, i2, f2, f3, f4, f5, f6, f7, 0.0f, landmarkParcelArr, f8, f9, f10, new zza[0], -1.0f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzo);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.writeFloat(parcel, 3, this.zzb);
        SafeParcelWriter.writeFloat(parcel, 4, this.zzc);
        SafeParcelWriter.writeFloat(parcel, 5, this.zzd);
        SafeParcelWriter.writeFloat(parcel, 6, this.zze);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzf);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzg);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeFloat(parcel, 10, this.zzj);
        SafeParcelWriter.writeFloat(parcel, 11, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 12, this.zzl);
        SafeParcelWriter.writeTypedArray(parcel, 13, this.zzm, i, false);
        SafeParcelWriter.writeFloat(parcel, 14, this.zzh);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzn);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
