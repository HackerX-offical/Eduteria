package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkp<K, V> implements Comparable<zzkp>, Map.Entry<K, V> {

    /* JADX INFO: Incorrect field signature: TK; */
    private final Comparable zza;
    private V zzb;
    private final /* synthetic */ zzkg zzc;

    zzkp(zzkg zzkgVar, Map.Entry<K, V> entry) {
        this(zzkgVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzkp(zzkg zzkgVar, K k, V v) {
        this.zzc = zzkgVar;
        this.zza = k;
        this.zzb = v;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.zzb;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzc.zzf();
        V v2 = this.zzb;
        this.zzb = v;
        return v2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zza;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.zzb;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        String strValueOf2 = String.valueOf(this.zzb);
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length()).append(strValueOf).append("=").append(strValueOf2).toString();
    }

    private static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzkp zzkpVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzkpVar.getKey());
    }
}
