package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.vision.L;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public class LogUtils {
    public static zzfi.zzo zza(long j, int i, String str, String str2, List<zzfi.zzn> list, zzs zzsVar) {
        zzfi.zzi.zza zzaVarZza = zzfi.zzi.zza();
        zzfi.zzf.zzb zzbVarZzb = zzfi.zzf.zza().zza(str2).zza(j).zzb(i);
        zzbVarZzb.zza(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((zzfi.zzf) ((zzjb) zzbVarZzb.zzf()));
        return (zzfi.zzo) ((zzjb) zzfi.zzo.zza().zza((zzfi.zzi) ((zzjb) zzaVarZza.zza(arrayList).zza((zzfi.zzj) ((zzjb) zzfi.zzj.zza().zzb(zzsVar.zzb).zza(zzsVar.zza).zzc(zzsVar.zzc).zzd(zzsVar.zzd).zzf())).zzf())).zzf());
    }

    public static zzfi.zza zza(Context context) {
        zzfi.zza.C0154zza c0154zzaZza = zzfi.zza.zza().zza(context.getPackageName());
        String strZzb = zzb(context);
        if (strZzb != null) {
            c0154zzaZza.zzb(strZzb);
        }
        return (zzfi.zza) ((zzjb) c0154zzaZza.zzf());
    }

    private static String zzb(Context context) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            L.e(e2, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }
}
