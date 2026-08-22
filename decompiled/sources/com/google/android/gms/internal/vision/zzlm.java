package com.google.android.gms.internal.vision;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzlm<K, V> implements Comparable<zzlm>, Map.Entry<K, V> {

    /* JADX INFO: Incorrect field signature: TK; */
    private final Comparable zza;
    private V zzb;
    private final /* synthetic */ zzlh zzc;

    zzlm(zzlh zzlhVar, Map.Entry<K, V> entry) {
        this(zzlhVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzlm(zzlh zzlhVar, K k, V v) {
        this.zzc = zzlhVar;
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
    public final /* synthetic */ int compareTo(zzlm zzlmVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzlmVar.getKey());
    }
}
