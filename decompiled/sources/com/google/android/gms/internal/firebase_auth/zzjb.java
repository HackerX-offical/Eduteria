package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjb extends zziz {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzjb() {
        super();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziz
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziz
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzld.zzf(obj, j);
        if (list instanceof zziw) {
            objUnmodifiableList = ((zziw) list).b_();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzjy) && (list instanceof zzim)) {
                zzim zzimVar = (zzim) list;
                if (zzimVar.zza()) {
                    zzimVar.c_();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzld.zza(obj, j, objUnmodifiableList);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> arrayList;
        List<L> listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            if (listZzc instanceof zziw) {
                arrayList = new zzix(i);
            } else if ((listZzc instanceof zzjy) && (listZzc instanceof zzim)) {
                arrayList = ((zzim) listZzc).zza(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            zzld.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList2 = new ArrayList(listZzc.size() + i);
            arrayList2.addAll(listZzc);
            zzld.zza(obj, j, arrayList2);
            return arrayList2;
        }
        if (listZzc instanceof zzlc) {
            zzix zzixVar = new zzix(listZzc.size() + i);
            zzixVar.addAll((zzlc) listZzc);
            zzld.zza(obj, j, zzixVar);
            return zzixVar;
        }
        if ((listZzc instanceof zzjy) && (listZzc instanceof zzim)) {
            zzim zzimVar = (zzim) listZzc;
            if (!zzimVar.zza()) {
                zzim zzimVarZza = zzimVar.zza(listZzc.size() + i);
                zzld.zza(obj, j, zzimVarZza);
                return zzimVarZza;
            }
        }
        return listZzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zziz
    final <E> void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzld.zza(obj, j, listZzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzld.zzf(obj, j);
    }
}
