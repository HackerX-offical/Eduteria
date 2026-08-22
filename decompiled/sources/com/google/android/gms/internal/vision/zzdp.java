package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdp<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Object zzd = new Object();

    @NullableDecl
    transient int[] zza;

    @NullableDecl
    transient Object[] zzb;

    @NullableDecl
    transient Object[] zzc;

    @NullableDecl
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;

    @NullableDecl
    private transient Set<K> zzh;

    @NullableDecl
    private transient Set<Map.Entry<K, V>> zzi;

    @NullableDecl
    private transient Collection<V> zzj;

    zzdp() {
        zzde.zza(true, (Object) "Expected size must be >= 0");
        this.zzf = zzfc.zza(3, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    static int zzb(int i, int i2) {
        return i - 1;
    }

    final boolean zza() {
        return this.zze == null;
    }

    @NullableDecl
    final Map<K, V> zzb() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    private final void zzb(int i) {
        this.zzf = zzea.zza(this.zzf, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzi() {
        return (1 << (this.zzf & 31)) - 1;
    }

    final void zzc() {
        this.zzf += 32;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V put(@NullableDecl K k, @NullableDecl V v) {
        int i;
        int i2 = 1;
        if (zza()) {
            zzde.zzb(zza(), "Arrays already allocated");
            int i3 = this.zzf;
            int iMax = Math.max(i3 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            int iMax2 = Math.max(4, (iMax <= ((int) (((double) iHighestOneBit) * 1.0d)) || (iHighestOneBit = iHighestOneBit << 1) > 0) ? iHighestOneBit : 1073741824);
            this.zze = zzea.zza(iMax2);
            zzb(iMax2 - 1);
            this.zza = new int[i3];
            this.zzb = new Object[i3];
            this.zzc = new Object[i3];
        }
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            return mapZzb.put(k, v);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        Object[] objArr2 = this.zzc;
        int i4 = this.zzg;
        int i5 = i4 + 1;
        int iZza = zzec.zza(k);
        int iZzi = zzi();
        int i6 = iZza & iZzi;
        int iZza2 = zzea.zza(this.zze, i6);
        if (iZza2 == 0) {
            if (i5 > iZzi) {
                iZzi = zza(iZzi, zzea.zzb(iZzi), iZza, i4);
            } else {
                zzea.zza(this.zze, i6, i5);
            }
            i = 1;
        } else {
            int i7 = ~iZzi;
            int i8 = iZza & i7;
            int i9 = 0;
            while (true) {
                int i10 = iZza2 - i2;
                int i11 = iArr[i10];
                i = i2;
                if ((i11 & i7) == i8 && zzcz.zza(k, objArr[i10])) {
                    V v2 = (V) objArr2[i10];
                    objArr2[i10] = v;
                    return v2;
                }
                int i12 = i11 & iZzi;
                int i13 = i9 + 1;
                if (i12 != 0) {
                    iZza2 = i12;
                    i9 = i13;
                    i2 = i;
                } else {
                    if (i13 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzi() + 1, 1.0f);
                        int iZzd = zzd();
                        while (iZzd >= 0) {
                            linkedHashMap.put(this.zzb[iZzd], this.zzc[iZzd]);
                            iZzd = zza(iZzd);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzc();
                        return (V) linkedHashMap.put(k, v);
                    }
                    if (i5 > iZzi) {
                        iZzi = zza(iZzi, zzea.zzb(iZzi), iZza, i4);
                    } else {
                        iArr[i10] = zzea.zza(i11, i5, iZzi);
                    }
                }
            }
        }
        int length = this.zza.length;
        if (i5 > length) {
            int i14 = i;
            int iMin = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(i14, length >>> 1) + length) | i14);
            if (iMin != length) {
                this.zza = Arrays.copyOf(this.zza, iMin);
                this.zzb = Arrays.copyOf(this.zzb, iMin);
                this.zzc = Arrays.copyOf(this.zzc, iMin);
            }
        }
        this.zza[i4] = zzea.zza(iZza, 0, iZzi);
        this.zzb[i4] = k;
        this.zzc[i4] = v;
        this.zzg = i5;
        zzc();
        return null;
    }

    private final int zza(int i, int i2, int i3, int i4) {
        Object objZza = zzea.zza(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzea.zza(objZza, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i6 = 0; i6 <= i; i6++) {
            int iZza = zzea.zza(obj, i6);
            while (iZza != 0) {
                int i7 = iZza - 1;
                int i8 = iArr[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iZza2 = zzea.zza(objZza, i10);
                zzea.zza(objZza, i10, iZza);
                iArr[i7] = zzea.zza(i9, iZza2, i5);
                iZza = i8 & i;
            }
        }
        this.zze = objZza;
        zzb(i5);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zza(@NullableDecl Object obj) {
        if (zza()) {
            return -1;
        }
        int iZza = zzec.zza(obj);
        int iZzi = zzi();
        int iZza2 = zzea.zza(this.zze, iZza & iZzi);
        if (iZza2 == 0) {
            return -1;
        }
        int i = ~iZzi;
        int i2 = iZza & i;
        do {
            int i3 = iZza2 - 1;
            int i4 = this.zza[i3];
            if ((i4 & i) == i2 && zzcz.zza(obj, this.zzb[i3])) {
                return i3;
            }
            iZza2 = i4 & iZzi;
        } while (iZza2 != 0);
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@NullableDecl Object obj) {
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            return mapZzb.containsKey(obj);
        }
        return zza(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(@NullableDecl Object obj) {
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            return mapZzb.get(obj);
        }
        int iZza = zza(obj);
        if (iZza == -1) {
            return null;
        }
        return (V) this.zzc[iZza];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            return mapZzb.remove(obj);
        }
        V v = (V) zzb(obj);
        if (v == zzd) {
            return null;
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public final Object zzb(@NullableDecl Object obj) {
        if (zza()) {
            return zzd;
        }
        int iZzi = zzi();
        int iZza = zzea.zza(obj, null, iZzi, this.zze, this.zza, this.zzb, null);
        if (iZza == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[iZza];
        zza(iZza, iZzi);
        this.zzg--;
        zzc();
        return obj2;
    }

    final void zza(int i, int i2) {
        int size = size();
        int i3 = size - 1;
        if (i < i3) {
            Object[] objArr = this.zzb;
            Object obj = objArr[i3];
            objArr[i] = obj;
            Object[] objArr2 = this.zzc;
            objArr2[i] = objArr2[i3];
            objArr[i3] = null;
            objArr2[i3] = null;
            int[] iArr = this.zza;
            iArr[i] = iArr[i3];
            iArr[i3] = 0;
            int iZza = zzec.zza(obj) & i2;
            int iZza2 = zzea.zza(this.zze, iZza);
            if (iZza2 == size) {
                zzea.zza(this.zze, iZza, i + 1);
                return;
            }
            while (true) {
                int i4 = iZza2 - 1;
                int[] iArr2 = this.zza;
                int i5 = iArr2[i4];
                int i6 = i5 & i2;
                if (i6 == size) {
                    iArr2[i4] = zzea.zza(i5, i + 1, i2);
                    return;
                }
                iZza2 = i6;
            }
        } else {
            this.zzb[i] = null;
            this.zzc[i] = null;
            this.zza[i] = 0;
        }
    }

    final int zzd() {
        return isEmpty() ? -1 : 0;
    }

    final int zza(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        zzdv zzdvVar = new zzdv(this);
        this.zzh = zzdvVar;
        return zzdvVar;
    }

    final Iterator<K> zze() {
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            return mapZzb.keySet().iterator();
        }
        return new zzds(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        zzdt zzdtVar = new zzdt(this);
        this.zzi = zzdtVar;
        return zzdtVar;
    }

    final Iterator<Map.Entry<K, V>> zzf() {
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            return mapZzb.entrySet().iterator();
        }
        return new zzdr(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map<K, V> mapZzb = zzb();
        return mapZzb != null ? mapZzb.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@NullableDecl Object obj) {
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            return mapZzb.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzcz.zza(obj, this.zzc[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzdx zzdxVar = new zzdx(this);
        this.zzj = zzdxVar;
        return zzdxVar;
    }

    final Iterator<V> zzg() {
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            return mapZzb.values().iterator();
        }
        return new zzdu(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zza()) {
            return;
        }
        zzc();
        Map<K, V> mapZzb = zzb();
        if (mapZzb != null) {
            this.zzf = zzfc.zza(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            mapZzb.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(this.zzb, 0, this.zzg, (Object) null);
        Arrays.fill(this.zzc, 0, this.zzg, (Object) null);
        Object obj = this.zze;
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(this.zza, 0, this.zzg, 0);
        this.zzg = 0;
    }

    static /* synthetic */ int zzd(zzdp zzdpVar) {
        int i = zzdpVar.zzg;
        zzdpVar.zzg = i - 1;
        return i;
    }
}
