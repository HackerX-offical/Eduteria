package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzey extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzey> CREATOR = new zzfb();
    private List<zzew> zza;

    public zzey() {
        this.zza = new ArrayList();
    }

    zzey(List<zzew> list) {
        List<zzew> listUnmodifiableList;
        if (list == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(list);
        }
        this.zza = listUnmodifiableList;
    }

    public final List<zzew> zza() {
        return this.zza;
    }

    public static zzey zza(zzey zzeyVar) {
        Preconditions.checkNotNull(zzeyVar);
        List<zzew> list = zzeyVar.zza;
        zzey zzeyVar2 = new zzey();
        if (list != null && !list.isEmpty()) {
            zzeyVar2.zza.addAll(list);
        }
        return zzeyVar2;
    }

    public static zzey zza(zzp.zzg zzgVar) {
        ArrayList arrayList = new ArrayList(zzgVar.zza());
        for (int i = 0; i < zzgVar.zza(); i++) {
            zzz zzzVarZza = zzgVar.zza(i);
            arrayList.add(new zzew(Strings.emptyToNull(zzzVarZza.zza()), Strings.emptyToNull(zzzVarZza.zzb()), zzzVarZza.zze(), Strings.emptyToNull(zzzVarZza.zzc()), Strings.emptyToNull(zzzVarZza.zzd()), zzfl.zza(zzzVarZza.zzf()), Strings.emptyToNull(zzzVarZza.zzi()), Strings.emptyToNull(zzzVarZza.zzj()), zzzVarZza.zzh(), zzzVarZza.zzg(), false, null, zzfh.zza(zzzVarZza.zzk())));
        }
        return new zzey(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
