package com.google.android.gms.internal.play_billing;

import com.amazonaws.services.s3.internal.Constants;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzbz implements Map, Serializable {

    @CheckForNull
    private transient zzcd zza;

    @CheckForNull
    private transient zzcd zzb;

    @CheckForNull
    private transient zzbr zzc;

    zzbz() {
    }

    public static zzbz zzc(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        zzbe.zzb("com.android.vending.billing.PURCHASES_UPDATED", obj2);
        zzbe.zzb("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", obj4);
        zzbe.zzb("com.android.vending.billing.ALTERNATIVE_BILLING", obj6);
        return zzcx.zzg(3, new Object[]{"com.android.vending.billing.PURCHASES_UPDATED", obj2, "com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED", obj4, "com.android.vending.billing.ALTERNATIVE_BILLING", obj6}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzda.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzcd zzcdVar = this.zzb;
        if (zzcdVar != null) {
            return zzcdVar;
        }
        zzcd zzcdVarZze = zze();
        this.zzb = zzcdVarZze;
        return zzcdVarZze;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzbe.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, Constants.GB));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    abstract zzbr zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzbr values() {
        zzbr zzbrVar = this.zzc;
        if (zzbrVar != null) {
            return zzbrVar;
        }
        zzbr zzbrVarZza = zza();
        this.zzc = zzbrVarZza;
        return zzbrVarZza;
    }

    abstract zzcd zzd();

    abstract zzcd zze();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzcd entrySet() {
        zzcd zzcdVar = this.zza;
        if (zzcdVar != null) {
            return zzcdVar;
        }
        zzcd zzcdVarZzd = zzd();
        this.zza = zzcdVarZzd;
        return zzcdVarZzd;
    }
}
