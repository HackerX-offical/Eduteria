package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzbg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzat();
    private final List<com.google.firebase.auth.zzaf> zza;

    zzaq(List<com.google.firebase.auth.zzaf> list) {
        this.zza = list == null ? zzbg.zza() : list;
    }

    public static zzaq zza(List<com.google.firebase.auth.zzy> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.google.firebase.auth.zzy zzyVar : list) {
            if (zzyVar instanceof com.google.firebase.auth.zzaf) {
                arrayList.add((com.google.firebase.auth.zzaf) zzyVar);
            }
        }
        return new zzaq(arrayList);
    }

    public final List<com.google.firebase.auth.zzy> zza() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.google.firebase.auth.zzaf> it = this.zza.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
