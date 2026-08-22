package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkh {
    private static final Class<?> zza = zzd();
    private static final zzkx<?, ?> zzb = zza(false);
    private static final zzkx<?, ?> zzc = zza(true);
    private static final zzkx<?, ?> zzd = new zzkz();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzie.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzlu zzluVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzlu zzluVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zza(i, list);
    }

    public static void zzb(int i, List<zzgt> list, zzlu zzluVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzlu zzluVar, zzkf zzkfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zza(i, list, zzkfVar);
    }

    public static void zzb(int i, List<?> list, zzlu zzluVar, zzkf zzkfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzluVar.zzb(i, list, zzkfVar);
    }

    static int zza(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjd)) {
            int iZzd = 0;
            while (i < size) {
                iZzd += zzho.zzd(list.get(i).longValue());
                i++;
            }
            return iZzd;
        }
        zzjd zzjdVar = (zzjd) list;
        int iZzd2 = 0;
        while (i < size) {
            iZzd2 += zzho.zzd(zzjdVar.zzb(i));
            i++;
        }
        return iZzd2;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzho.zze(i));
    }

    static int zzb(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjd)) {
            int iZze = 0;
            while (i < size) {
                iZze += zzho.zze(list.get(i).longValue());
                i++;
            }
            return iZze;
        }
        zzjd zzjdVar = (zzjd) list;
        int iZze2 = 0;
        while (i < size) {
            iZze2 += zzho.zze(zzjdVar.zzb(i));
            i++;
        }
        return iZze2;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzho.zze(i));
    }

    static int zzc(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjd)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzho.zzf(list.get(i).longValue());
                i++;
            }
            return iZzf;
        }
        zzjd zzjdVar = (zzjd) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzho.zzf(zzjdVar.zzb(i));
            i++;
        }
        return iZzf2;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzho.zze(i));
    }

    static int zzd(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzih)) {
            int iZzk = 0;
            while (i < size) {
                iZzk += zzho.zzk(list.get(i).intValue());
                i++;
            }
            return iZzk;
        }
        zzih zzihVar = (zzih) list;
        int iZzk2 = 0;
        while (i < size) {
            iZzk2 += zzho.zzk(zzihVar.zzc(i));
            i++;
        }
        return iZzk2;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzho.zze(i));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzih)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzho.zzf(list.get(i).intValue());
                i++;
            }
            return iZzf;
        }
        zzih zzihVar = (zzih) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzho.zzf(zzihVar.zzc(i));
            i++;
        }
        return iZzf2;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzho.zze(i));
    }

    static int zzf(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzih)) {
            int iZzg = 0;
            while (i < size) {
                iZzg += zzho.zzg(list.get(i).intValue());
                i++;
            }
            return iZzg;
        }
        zzih zzihVar = (zzih) list;
        int iZzg2 = 0;
        while (i < size) {
            iZzg2 += zzho.zzg(zzihVar.zzc(i));
            i++;
        }
        return iZzg2;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzho.zze(i));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzih)) {
            int iZzh = 0;
            while (i < size) {
                iZzh += zzho.zzh(list.get(i).intValue());
                i++;
            }
            return iZzh;
        }
        zzih zzihVar = (zzih) list;
        int iZzh2 = 0;
        while (i < size) {
            iZzh2 += zzho.zzh(zzihVar.zzc(i));
            i++;
        }
        return iZzh2;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzho.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzho.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzho.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzho.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzho.zze(i) * size;
        if (!(list instanceof zziw)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzgt) {
                    iZzb = zzho.zzb((zzgt) obj);
                } else {
                    iZzb = zzho.zzb((String) obj);
                }
                iZze += iZzb;
                i2++;
            }
            return iZze;
        }
        zziw zziwVar = (zziw) list;
        while (i2 < size) {
            Object objZzb = zziwVar.zzb(i2);
            if (objZzb instanceof zzgt) {
                iZzb2 = zzho.zzb((zzgt) objZzb);
            } else {
                iZzb2 = zzho.zzb((String) objZzb);
            }
            iZze += iZzb2;
            i2++;
        }
        return iZze;
    }

    static int zza(int i, Object obj, zzkf zzkfVar) {
        if (obj instanceof zziu) {
            return zzho.zza(i, (zziu) obj);
        }
        return zzho.zzb(i, (zzjp) obj, zzkfVar);
    }

    static int zza(int i, List<?> list, zzkf zzkfVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzho.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zziu) {
                iZza = zzho.zza((zziu) obj);
            } else {
                iZza = zzho.zza((zzjp) obj, zzkfVar);
            }
            iZze += iZza;
        }
        return iZze;
    }

    static int zzb(int i, List<zzgt> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzho.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzho.zzb(list.get(i2));
        }
        return iZze;
    }

    static int zzb(int i, List<zzjp> list, zzkf zzkfVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzho.zzc(i, list.get(i2), zzkfVar);
        }
        return iZzc;
    }

    public static zzkx<?, ?> zza() {
        return zzb;
    }

    public static zzkx<?, ?> zzb() {
        return zzc;
    }

    public static zzkx<?, ?> zzc() {
        return zzd;
    }

    private static zzkx<?, ?> zza(boolean z) {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzkx) clsZze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzji zzjiVar, T t, T t2, long j) {
        zzld.zza(t, j, zzjiVar.zza(zzld.zzf(t, j), zzld.zzf(t2, j)));
    }

    static <T, FT extends zzhz<FT>> void zza(zzht<FT> zzhtVar, T t, T t2) {
        zzhx<T> zzhxVarZza = zzhtVar.zza(t2);
        if (zzhxVarZza.zza.isEmpty()) {
            return;
        }
        zzhtVar.zzb(t).zza((zzhx) zzhxVarZza);
    }

    static <T, UT, UB> void zza(zzkx<UT, UB> zzkxVar, T t, T t2) {
        zzkxVar.zza(t, zzkxVar.zzc(zzkxVar.zzb(t), zzkxVar.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzil zzilVar, UB ub, zzkx<UT, UB> zzkxVar) {
        if (zzilVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = list.get(i3).intValue();
                if (zzilVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, iIntValue, ub, zzkxVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!zzilVar.zza(iIntValue2)) {
                ub = (UB) zza(i, iIntValue2, ub, zzkxVar);
                it.remove();
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzkx<UT, UB> zzkxVar) {
        if (ub == null) {
            ub = zzkxVar.zza();
        }
        zzkxVar.zza(ub, i, i2);
        return ub;
    }
}
