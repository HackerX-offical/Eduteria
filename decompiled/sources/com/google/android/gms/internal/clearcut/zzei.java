package com.google.android.gms.internal.clearcut;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes8.dex */
class zzei<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzgu;
    private final int zzol;
    private List<zzep> zzom;
    private Map<K, V> zzon;
    private volatile zzer zzoo;
    private Map<K, V> zzop;
    private volatile zzel zzoq;

    private zzei(int i) {
        this.zzol = i;
        this.zzom = Collections.emptyList();
        this.zzon = Collections.emptyMap();
        this.zzop = Collections.emptyMap();
    }

    /* synthetic */ zzei(int i, zzej zzejVar) {
        this(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zza(K r5) {
        /*
            r4 = this;
            java.util.List<com.google.android.gms.internal.clearcut.zzep> r0 = r4.zzom
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L25
            java.util.List<com.google.android.gms.internal.clearcut.zzep> r2 = r4.zzom
            java.lang.Object r2 = r2.get(r1)
            com.google.android.gms.internal.clearcut.zzep r2 = (com.google.android.gms.internal.clearcut.zzep) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L22
            int r0 = r0 + 1
        L20:
            int r5 = -r0
            return r5
        L22:
            if (r2 != 0) goto L25
            return r1
        L25:
            r0 = 0
        L26:
            if (r0 > r1) goto L49
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List<com.google.android.gms.internal.clearcut.zzep> r3 = r4.zzom
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.clearcut.zzep r3 = (com.google.android.gms.internal.clearcut.zzep) r3
            java.lang.Object r3 = r3.getKey()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L43
            int r1 = r2 + (-1)
            goto L26
        L43:
            if (r3 <= 0) goto L48
            int r0 = r2 + 1
            goto L26
        L48:
            return r2
        L49:
            int r0 = r0 + 1
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzei.zza(java.lang.Comparable):int");
    }

    static <FieldDescriptorType extends zzca<FieldDescriptorType>> zzei<FieldDescriptorType, Object> zzaj(int i) {
        return new zzej(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzal(int i) {
        zzdu();
        V v = (V) this.zzom.remove(i).getValue();
        if (!this.zzon.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzdv().entrySet().iterator();
            this.zzom.add(new zzep(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzdu() {
        if (this.zzgu) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzdv() {
        zzdu();
        if (this.zzon.isEmpty() && !(this.zzon instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzon = treeMap;
            this.zzop = treeMap.descendingMap();
        }
        return (SortedMap) this.zzon;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzdu();
        if (!this.zzom.isEmpty()) {
            this.zzom.clear();
        }
        if (this.zzon.isEmpty()) {
            return;
        }
        this.zzon.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzon.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzoo == null) {
            this.zzoo = new zzer(this, null);
        }
        return this.zzoo;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        Object objEntrySet;
        Object objEntrySet2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzei)) {
            return super.equals(obj);
        }
        zzei zzeiVar = (zzei) obj;
        int size = size();
        if (size != zzeiVar.size()) {
            return false;
        }
        int iZzdr = zzdr();
        if (iZzdr != zzeiVar.zzdr()) {
            objEntrySet = entrySet();
            objEntrySet2 = zzeiVar.entrySet();
        } else {
            for (int i = 0; i < iZzdr; i++) {
                if (!zzak(i).equals(zzeiVar.zzak(i))) {
                    return false;
                }
            }
            if (iZzdr == size) {
                return true;
            }
            objEntrySet = this.zzon;
            objEntrySet2 = zzeiVar.zzon;
        }
        return objEntrySet.equals(objEntrySet2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        return iZza >= 0 ? (V) this.zzom.get(iZza).getValue() : this.zzon.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZzdr = zzdr();
        int iHashCode = 0;
        for (int i = 0; i < iZzdr; i++) {
            iHashCode += this.zzom.get(i).hashCode();
        }
        return this.zzon.size() > 0 ? iHashCode + this.zzon.hashCode() : iHashCode;
    }

    public final boolean isImmutable() {
        return this.zzgu;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzdu();
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return zzal(iZza);
        }
        if (this.zzon.isEmpty()) {
            return null;
        }
        return this.zzon.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzom.size() + this.zzon.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzdu();
        int iZza = zza(k);
        if (iZza >= 0) {
            return (V) this.zzom.get(iZza).setValue(v);
        }
        zzdu();
        if (this.zzom.isEmpty() && !(this.zzom instanceof ArrayList)) {
            this.zzom = new ArrayList(this.zzol);
        }
        int i = -(iZza + 1);
        if (i >= this.zzol) {
            return zzdv().put(k, v);
        }
        int size = this.zzom.size();
        int i2 = this.zzol;
        if (size == i2) {
            zzep zzepVarRemove = this.zzom.remove(i2 - 1);
            zzdv().put((Comparable) zzepVarRemove.getKey(), zzepVarRemove.getValue());
        }
        this.zzom.add(i, new zzep(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzak(int i) {
        return this.zzom.get(i);
    }

    public final int zzdr() {
        return this.zzom.size();
    }

    public final Iterable<Map.Entry<K, V>> zzds() {
        return this.zzon.isEmpty() ? zzem.zzdx() : this.zzon.entrySet();
    }

    final Set<Map.Entry<K, V>> zzdt() {
        if (this.zzoq == null) {
            this.zzoq = new zzel(this, null);
        }
        return this.zzoq;
    }

    public void zzv() {
        if (this.zzgu) {
            return;
        }
        this.zzon = this.zzon.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzon);
        this.zzop = this.zzop.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzop);
        this.zzgu = true;
    }
}
