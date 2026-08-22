package com.google.android.gms.internal.vision;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzdo<K, V> implements zzen<K, V> {

    @NullableDecl
    private transient Map<K, Collection<V>> zza;

    zzdo() {
    }

    abstract Map<K, Collection<V>> zzb();

    public boolean zza(@NullableDecl Object obj) {
        Iterator<Collection<V>> it = zza().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzen
    public Map<K, Collection<V>> zza() {
        Map<K, Collection<V>> map = this.zza;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapZzb = zzb();
        this.zza = mapZzb;
        return mapZzb;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzen) {
            return zza().equals(((zzen) obj).zza());
        }
        return false;
    }

    public int hashCode() {
        return zza().hashCode();
    }

    public String toString() {
        return zza().toString();
    }
}
