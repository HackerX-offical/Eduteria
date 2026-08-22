package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzau implements zzay {
    private static final Map<Uri, zzau> zza = new ArrayMap();
    private static final String[] zzh = {"key", "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private final ContentObserver zzd;
    private final Object zze;
    private volatile Map<String, String> zzf;
    private final List<zzaz> zzg;

    private zzau(ContentResolver contentResolver, Uri uri) {
        zzaw zzawVar = new zzaw(this, null);
        this.zzd = zzawVar;
        this.zze = new Object();
        this.zzg = new ArrayList();
        zzde.zza(contentResolver);
        zzde.zza(uri);
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, zzawVar);
    }

    public static zzau zza(ContentResolver contentResolver, Uri uri) {
        zzau zzauVar;
        synchronized (zzau.class) {
            Map<Uri, zzau> map = zza;
            zzauVar = map.get(uri);
            if (zzauVar == null) {
                try {
                    zzau zzauVar2 = new zzau(contentResolver, uri);
                    try {
                        map.put(uri, zzauVar2);
                    } catch (SecurityException unused) {
                    }
                    zzauVar = zzauVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzauVar;
    }

    private final Map<String, String> zzd() {
        Map<String, String> mapZze = this.zzf;
        if (mapZze == null) {
            synchronized (this.zze) {
                mapZze = this.zzf;
                if (mapZze == null) {
                    mapZze = zze();
                    this.zzf = mapZze;
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }

    public final void zza() {
        synchronized (this.zze) {
            this.zzf = null;
            zzbi.zza();
        }
        synchronized (this) {
            Iterator<zzaz> it = this.zzg.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzbb.zza(new zzba(this) { // from class: com.google.android.gms.internal.vision.zzax
                    private final zzau zza;

                    {
                        this.zza = this;
                    }

                    @Override // com.google.android.gms.internal.vision.zzba
                    public final Object zza() {
                        return this.zza.zzc();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static synchronized void zzb() {
        for (zzau zzauVar : zza.values()) {
            zzauVar.zzb.unregisterContentObserver(zzauVar.zzd);
        }
        zza.clear();
    }

    @Override // com.google.android.gms.internal.vision.zzay
    public final /* synthetic */ Object zza(String str) {
        return zzd().get(str);
    }

    final /* synthetic */ Map zzc() {
        Map map;
        Cursor cursorQuery = this.zzb.query(this.zzc, zzh, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return map;
        } finally {
            cursorQuery.close();
        }
    }
}
