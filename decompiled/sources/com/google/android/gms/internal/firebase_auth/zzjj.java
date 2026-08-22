package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzjj<K, V> extends LinkedHashMap<K, V> {
    private static final zzjj zzb;
    private boolean zza;

    private zzjj() {
        this.zza = true;
    }

    private zzjj(Map<K, V> map) {
        super(map);
        this.zza = true;
    }

    public static <K, V> zzjj<K, V> zza() {
        return zzb;
    }

    public final void zza(zzjj<K, V> zzjjVar) {
        zze();
        if (zzjjVar.isEmpty()) {
            return;
        }
        putAll(zzjjVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zze();
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zze();
        zzig.zza(k);
        zzig.zza(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zze();
        for (K k : map.keySet()) {
            zzig.zza(k);
            zzig.zza(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zze();
        return (V) super.remove(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean zEquals;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                zEquals = Arrays.equals((byte[]) value, (byte[]) obj2);
            } else {
                zEquals = value.equals(obj2);
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    private static int zza(Object obj) {
        if (obj instanceof byte[]) {
            return zzig.zzc((byte[]) obj);
        }
        if (obj instanceof zzij) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZza = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iZza += zza(entry.getValue()) ^ zza(entry.getKey());
        }
        return iZza;
    }

    public final zzjj<K, V> zzb() {
        return isEmpty() ? new zzjj<>() : new zzjj<>(this);
    }

    public final void zzc() {
        this.zza = false;
    }

    public final boolean zzd() {
        return this.zza;
    }

    private final void zze() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzjj zzjjVar = new zzjj();
        zzb = zzjjVar;
        zzjjVar.zza = false;
    }
}
