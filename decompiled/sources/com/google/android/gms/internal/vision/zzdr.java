package com.google.android.gms.internal.vision;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdr<K, V> extends zzdw<Map.Entry<K, V>> {
    private final /* synthetic */ zzdp zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdr(zzdp zzdpVar) {
        super(zzdpVar, null);
        this.zza = zzdpVar;
    }

    @Override // com.google.android.gms.internal.vision.zzdw
    final /* synthetic */ Object zza(int i) {
        return new zzdy(this.zza, i);
    }
}
