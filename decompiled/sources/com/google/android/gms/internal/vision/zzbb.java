package com.google.android.gms.internal.vision;

import android.os.Binder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class zzbb {
    public static <V> V zza(zzba<V> zzbaVar) {
        try {
            return zzbaVar.zza();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzbaVar.zza();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
