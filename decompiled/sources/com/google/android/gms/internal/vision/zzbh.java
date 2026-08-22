package com.google.android.gms.internal.vision;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbh {
    public static zzcy<zzbe> zza(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
            return zzcy.zzc();
        }
        if (zzas.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzcy<File> zzcyVarZzb = zzb(context);
        return zzcyVarZzb.zza() ? zzcy.zza(zza(zzcyVarZzb.zzb())) : zzcy.zzc();
    }

    private static zzcy<File> zzb(Context context) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? zzcy.zza(file) : zzcy.zzc();
        } catch (RuntimeException e2) {
            Log.e("HermeticFileOverrides", "no data dir", e2);
            return zzcy.zzc();
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private static zzbe zza(File file) {
        BufferedReader bufferedReader;
        HashMap map;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                map = new HashMap();
            } finally {
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] strArrSplit = line.split(" ", 3);
                if (strArrSplit.length != 3) {
                    String strValueOf = String.valueOf(line);
                    Log.e("HermeticFileOverrides", strValueOf.length() != 0 ? "Invalid: ".concat(strValueOf) : new String("Invalid: "));
                } else {
                    String str = strArrSplit[0];
                    String strDecode = Uri.decode(strArrSplit[1]);
                    String strDecode2 = Uri.decode(strArrSplit[2]);
                    if (!map.containsKey(str)) {
                        map.put(str, new HashMap());
                    }
                    ((Map) map.get(str)).put(strDecode, strDecode2);
                }
            } else {
                String strValueOf2 = String.valueOf(file);
                Log.i("HermeticFileOverrides", new StringBuilder(String.valueOf(strValueOf2).length() + 7).append("Parsed ").append(strValueOf2).toString());
                zzbe zzbeVar = new zzbe(map);
                bufferedReader.close();
                return zzbeVar;
            }
            throw new RuntimeException(e2);
        }
    }
}
