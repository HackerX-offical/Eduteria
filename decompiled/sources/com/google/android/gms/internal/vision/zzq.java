package com.google.android.gms.internal.vision;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzq {
    public static boolean zza(Context context, String str, String str2) {
        String strZza = zzdg.zza(str2);
        if (!"face".equals(str) && !"ica".equals(str) && !"ocr".equals(str) && !"barcode".equals(str)) {
            Log.e("NativeLibraryLoader", String.format("Unrecognized engine: %s", str));
            return false;
        }
        int iLastIndexOf = strZza.lastIndexOf(".so");
        if (iLastIndexOf == strZza.length() - 3) {
            strZza = strZza.substring(0, iLastIndexOf);
        }
        if (strZza.indexOf("lib") == 0) {
            strZza = strZza.substring(3);
        }
        boolean zZza = zzr.zza(str, strZza);
        if (!zZza) {
            Log.d("NativeLibraryLoader", String.format("%s engine not loaded with %s.", str, strZza));
        }
        return zZza;
    }
}
