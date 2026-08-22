package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzih {
    public static final /* synthetic */ int zza = 0;
    private static final zzir zzb;

    static {
        int i = zzic.zza;
        zzb = new zzit();
    }

    public static void zzA(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzL(i, list, z);
    }

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgt)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzfz.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzA;
        }
        zzgt zzgtVar = (zzgt) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzfz.zzA(zzgtVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfz.zzz(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfz.zzz(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgt)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzfz.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzA;
        }
        zzgt zzgtVar = (zzgt) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzfz.zzA(zzgtVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzfz.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzA;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzfz.zzA(zzhjVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    static int zzh(int i, Object obj, zzif zzifVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzhf)) {
            return zzfz.zzz(i2) + zzfz.zzx((zzhu) obj, zzifVar);
        }
        int iZzz = zzfz.zzz(i2);
        int iZza = ((zzhf) obj).zza();
        return iZzz + zzfz.zzz(iZza) + iZza;
    }

    static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgt)) {
            int iZzz = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzz += zzfz.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzz;
        }
        zzgt zzgtVar = (zzgt) list;
        int iZzz2 = 0;
        while (i < size) {
            int iZze = zzgtVar.zze(i);
            iZzz2 += zzfz.zzz((iZze >> 31) ^ (iZze + iZze));
            i++;
        }
        return iZzz2;
    }

    static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzA = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzA += zzfz.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzA;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzA2 = 0;
        while (i < size) {
            long jZze = zzhjVar.zze(i);
            iZzA2 += zzfz.zzA((jZze >> 63) ^ (jZze + jZze));
            i++;
        }
        return iZzA2;
    }

    static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgt)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzfz.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzz;
        }
        zzgt zzgtVar = (zzgt) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzfz.zzz(zzgtVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhj)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzfz.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzA;
        }
        zzhj zzhjVar = (zzhj) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzfz.zzA(zzhjVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    public static zzir zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, int i2, Object obj2, zzir zzirVar) {
        Object obj3 = obj2;
        if (obj2 == null) {
            zzgs zzgsVar = (zzgs) obj;
            zzis zzisVar = zzgsVar.zzc;
            obj3 = zzisVar;
            if (zzisVar == zzis.zzc()) {
                zzis zzisVarZzf = zzis.zzf();
                zzgsVar.zzc = zzisVarZzf;
                obj3 = zzisVarZzf;
            }
        }
        ((zzis) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    static void zzo(zzgf zzgfVar, Object obj, Object obj2) {
        if (((zzgp) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzp(zzir zzirVar, Object obj, Object obj2) {
        zzgs zzgsVar = (zzgs) obj;
        zzis zzisVarZze = zzgsVar.zzc;
        zzis zzisVar = ((zzgs) obj2).zzc;
        if (!zzis.zzc().equals(zzisVar)) {
            if (zzis.zzc().equals(zzisVarZze)) {
                zzisVarZze = zzis.zze(zzisVarZze, zzisVar);
            } else {
                zzisVarZze.zzd(zzisVar);
            }
        }
        zzgsVar.zzc = zzisVarZze;
    }

    public static void zzq(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzje zzjeVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjeVar.zzA(i, list, z);
    }
}
