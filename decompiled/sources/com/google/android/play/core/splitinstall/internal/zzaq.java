package com.google.android.play.core.splitinstall.internal;

import java.io.File;

/* JADX INFO: compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaq implements zzar {
    zzaq() {
    }

    @Override // com.google.android.play.core.splitinstall.internal.zzar
    public final boolean zza(Object obj, File file, File file2) {
        return new File((String) zzbk.zzg(obj.getClass(), "optimizedPathFor", String.class, File.class, file, File.class, file2)).exists();
    }
}
