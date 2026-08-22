package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdj<T> implements zzdf<T>, Serializable {

    @NullableDecl
    private final T zza;

    zzdj(@NullableDecl T t) {
        this.zza = t;
    }

    @Override // com.google.android.gms.internal.vision.zzdf
    public final T zza() {
        return this.zza;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdj) {
            return zzcz.zza(this.zza, ((zzdj) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        return new StringBuilder(String.valueOf(strValueOf).length() + 22).append("Suppliers.ofInstance(").append(strValueOf).append(")").toString();
    }
}
