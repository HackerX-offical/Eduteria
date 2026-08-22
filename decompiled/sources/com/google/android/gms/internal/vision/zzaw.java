package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaw extends ContentObserver {
    private final /* synthetic */ zzau zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaw(zzau zzauVar, Handler handler) {
        super(null);
        this.zza = zzauVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zza();
    }
}
