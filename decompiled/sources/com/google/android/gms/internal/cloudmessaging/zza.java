package com.google.android.gms.internal.cloudmessaging;

import android.os.Build;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zza {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? GroupFlagsKt.HasAuxSlotFlag : 0;
    }
}
