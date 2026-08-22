package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.play.core.splitinstall.internal.zzbk;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zza {
    private final zze zza;

    public zza(zze zzeVar) {
        this.zza = zzeVar;
    }

    public static final int zzc(AssetManager assetManager, File file) {
        int iIntValue = ((Integer) zzbk.zzd(assetManager, "addAssetPath", Integer.class, String.class, file.getPath())).intValue();
        Log.d("SplitCompat", "addAssetPath completed with " + iIntValue);
        return iIntValue;
    }

    public final synchronized void zza(Context context, Set set) {
        AssetManager assets = context.getAssets();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzc(assets, (File) it.next());
        }
    }

    final synchronized boolean zzb(Context context, Set set) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
        } catch (Exception e2) {
            e = e2;
            threadPolicy = null;
        }
        try {
            StrictMode.allowThreadDiskReads();
            StrictMode.allowThreadDiskWrites();
        } catch (Exception e3) {
            e = e3;
            Log.i("SplitCompat", "Unable to set up strict mode.", e);
        }
        try {
            try {
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    hashSet.add(this.zza.zzg((String) it.next()));
                }
                zza(context, hashSet);
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
            } catch (Throwable th) {
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                throw th;
            }
        } catch (Exception e4) {
            Log.e("SplitCompat", "Error installing additional splits", e4);
            if (threadPolicy == null) {
                return false;
            }
            StrictMode.setThreadPolicy(threadPolicy);
            return false;
        }
        return true;
    }
}
