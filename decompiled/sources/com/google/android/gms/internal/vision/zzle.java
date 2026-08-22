package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzle {
    private static final Class<?> zza = zzd();
    private static final zzlu<?, ?> zzb = zza(false);
    private static final zzlu<?, ?> zzc = zza(true);
    private static final zzlu<?, ?> zzd = new zzlw();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzjb.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzmr zzmrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzmr zzmrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zza(i, list);
    }

    public static void zzb(int i, List<zzht> list, zzmr zzmrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzmr zzmrVar, zzlc zzlcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zza(i, list, zzlcVar);
    }

    public static void zzb(int i, List<?> list, zzmr zzmrVar, zzlc zzlcVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmrVar.zzb(i, list, zzlcVar);
    }

    static int zza(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjy)) {
            int iZzd = 0;
            while (i < size) {
                iZzd += zzii.zzd(list.get(i).longValue());
                i++;
            }
            return iZzd;
        }
        zzjy zzjyVar = (zzjy) list;
        int iZzd2 = 0;
        while (i < size) {
            iZzd2 += zzii.zzd(zzjyVar.zzb(i));
            i++;
        }
        return iZzd2;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzii.zze(i));
    }

    static int zzb(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjy)) {
            int iZze = 0;
            while (i < size) {
                iZze += zzii.zze(list.get(i).longValue());
                i++;
            }
            return iZze;
        }
        zzjy zzjyVar = (zzjy) list;
        int iZze2 = 0;
        while (i < size) {
            iZze2 += zzii.zze(zzjyVar.zzb(i));
            i++;
        }
        return iZze2;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzii.zze(i));
    }

    static int zzc(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjy)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzii.zzf(list.get(i).longValue());
                i++;
            }
            return iZzf;
        }
        zzjy zzjyVar = (zzjy) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzii.zzf(zzjyVar.zzb(i));
            i++;
        }
        return iZzf2;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzii.zze(i));
    }

    static int zzd(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjd)) {
            int iZzk = 0;
            while (i < size) {
                iZzk += zzii.zzk(list.get(i).intValue());
                i++;
            }
            return iZzk;
        }
        zzjd zzjdVar = (zzjd) list;
        int iZzk2 = 0;
        while (i < size) {
            iZzk2 += zzii.zzk(zzjdVar.zzb(i));
            i++;
        }
        return iZzk2;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzii.zze(i));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjd)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzii.zzf(list.get(i).intValue());
                i++;
            }
            return iZzf;
        }
        zzjd zzjdVar = (zzjd) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzii.zzf(zzjdVar.zzb(i));
            i++;
        }
        return iZzf2;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzii.zze(i));
    }

    static int zzf(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjd)) {
            int iZzg = 0;
            while (i < size) {
                iZzg += zzii.zzg(list.get(i).intValue());
                i++;
            }
            return iZzg;
        }
        zzjd zzjdVar = (zzjd) list;
        int iZzg2 = 0;
        while (i < size) {
            iZzg2 += zzii.zzg(zzjdVar.zzb(i));
            i++;
        }
        return iZzg2;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzii.zze(i));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzjd)) {
            int iZzh = 0;
            while (i < size) {
                iZzh += zzii.zzh(list.get(i).intValue());
                i++;
            }
            return iZzh;
        }
        zzjd zzjdVar = (zzjd) list;
        int iZzh2 = 0;
        while (i < size) {
            iZzh2 += zzii.zzh(zzjdVar.zzb(i));
            i++;
        }
        return iZzh2;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzii.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzii.zze(i) * size;
        if (!(list instanceof zzjv)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzht) {
                    iZzb = zzii.zzb((zzht) obj);
                } else {
                    iZzb = zzii.zzb((String) obj);
                }
                iZze += iZzb;
                i2++;
            }
            return iZze;
        }
        zzjv zzjvVar = (zzjv) list;
        while (i2 < size) {
            Object objZzb = zzjvVar.zzb(i2);
            if (objZzb instanceof zzht) {
                iZzb2 = zzii.zzb((zzht) objZzb);
            } else {
                iZzb2 = zzii.zzb((String) objZzb);
            }
            iZze += iZzb2;
            i2++;
        }
        return iZze;
    }

    static int zza(int i, Object obj, zzlc zzlcVar) {
        if (obj instanceof zzjt) {
            return zzii.zza(i, (zzjt) obj);
        }
        return zzii.zzb(i, (zzkk) obj, zzlcVar);
    }

    static int zza(int i, List<?> list, zzlc zzlcVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzii.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzjt) {
                iZza = zzii.zza((zzjt) obj);
            } else {
                iZza = zzii.zza((zzkk) obj, zzlcVar);
            }
            iZze += iZza;
        }
        return iZze;
    }

    static int zzb(int i, List<zzht> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzii.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzii.zzb(list.get(i2));
        }
        return iZze;
    }

    static int zzb(int i, List<zzkk> list, zzlc zzlcVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzii.zzc(i, list.get(i2), zzlcVar);
        }
        return iZzc;
    }

    public static zzlu<?, ?> zza() {
        return zzb;
    }

    public static zzlu<?, ?> zzb() {
        return zzc;
    }

    public static zzlu<?, ?> zzc() {
        return zzd;
    }

    private static zzlu<?, ?> zza(boolean z) {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzlu) clsZze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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

    static <T> void zza(zzkh zzkhVar, T t, T t2, long j) {
        zzma.zza(t, j, zzkhVar.zza(zzma.zzf(t, j), zzma.zzf(t2, j)));
    }

    static <T, FT extends zziw<FT>> void zza(zziq<FT> zziqVar, T t, T t2) {
        zziu<T> zziuVarZza = zziqVar.zza(t2);
        if (zziuVarZza.zza.isEmpty()) {
            return;
        }
        zziqVar.zzb(t).zza((zziu) zziuVarZza);
    }

    static <T, UT, UB> void zza(zzlu<UT, UB> zzluVar, T t, T t2) {
        zzluVar.zza(t, zzluVar.zzc(zzluVar.zzb(t), zzluVar.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzjg zzjgVar, UB ub, zzlu<UT, UB> zzluVar) {
        if (zzjgVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = list.get(i3).intValue();
                if (zzjgVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, iIntValue, ub, zzluVar);
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
            if (!zzjgVar.zza(iIntValue2)) {
                ub = (UB) zza(i, iIntValue2, ub, zzluVar);
                it.remove();
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzlu<UT, UB> zzluVar) {
        if (ub == null) {
            ub = zzluVar.zza();
        }
        zzluVar.zza(ub, i, i2);
        return ub;
    }
}
