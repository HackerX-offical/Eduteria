package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkr implements zzor {
    private final /* synthetic */ zzjq zza;

    zzkr(zzjq zzjqVar) {
        this.zza = zzjqVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzb("auto", str2, bundle);
        } else {
            this.zza.zza("auto", str2, bundle, str);
        }
    }
}
