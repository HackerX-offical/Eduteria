package com.google.android.gms.internal.firebase_auth;

import com.amazonaws.services.s3.internal.Constants;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzbl<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zza = new Map.Entry[0];
    private transient zzbn<Map.Entry<K, V>> zzb;
    private transient zzbn<K> zzc;
    private transient zzbh<V> zzd;

    public static <K, V> zzbl<K, V> zza() {
        return (zzbl<K, V>) zzbp.zza;
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    abstract zzbn<Map.Entry<K, V>> zzb();

    abstract zzbn<K> zzc();

    abstract zzbh<V> zzd();

    zzbl() {
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzbh) values()).contains(obj);
    }

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzbs.zza((zzbn) entrySet());
    }

    public String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf("size").length() + 40).append("size cannot be negative but was: ").append(size).toString());
        }
        StringBuilder sbAppend = new StringBuilder((int) Math.min(((long) size) << 3, Constants.GB)).append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sbAppend.append(", ");
            }
            sbAppend.append(entry.getKey()).append('=').append(entry.getValue());
            z = false;
        }
        return sbAppend.append('}').toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzbn<Map.Entry<K, V>> zzbnVar = this.zzb;
        if (zzbnVar != null) {
            return zzbnVar;
        }
        zzbn<Map.Entry<K, V>> zzbnVarZzb = zzb();
        this.zzb = zzbnVarZzb;
        return zzbnVarZzb;
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzbh<V> zzbhVar = this.zzd;
        if (zzbhVar != null) {
            return zzbhVar;
        }
        zzbh<V> zzbhVarZzd = zzd();
        this.zzd = zzbhVarZzd;
        return zzbhVarZzd;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzbn<K> zzbnVar = this.zzc;
        if (zzbnVar != null) {
            return zzbnVar;
        }
        zzbn<K> zzbnVarZzc = zzc();
        this.zzc = zzbnVarZzc;
        return zzbnVarZzc;
    }
}
