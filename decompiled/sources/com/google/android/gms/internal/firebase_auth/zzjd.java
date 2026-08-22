package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjd extends zzgp<Long> implements zzim<Long>, zzjy, RandomAccess {
    private static final zzjd zza;
    private long[] zzb;
    private int zzc;

    zzjd() {
        this(new long[10], 0);
    }

    private zzjd(long[] jArr, int i) {
        this.zzb = jArr;
        this.zzc = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzc();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzb;
        System.arraycopy(jArr, i2, jArr, i, this.zzc - i2);
        this.zzc -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjd)) {
            return super.equals(obj);
        }
        zzjd zzjdVar = (zzjd) obj;
        if (this.zzc != zzjdVar.zzc) {
            return false;
        }
        long[] jArr = zzjdVar.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (this.zzb[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i = 0; i < this.zzc; i++) {
            iZza = (iZza * 31) + zzig.zza(this.zzb[i]);
        }
        return iZza;
    }

    public final long zzb(int i) {
        zzc(i);
        return this.zzb[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    public final void zza(long j) {
        zzc();
        int i = this.zzc;
        long[] jArr = this.zzb;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzc();
        zzig.zza(collection);
        if (!(collection instanceof zzjd)) {
            return super.addAll(collection);
        }
        zzjd zzjdVar = (zzjd) collection;
        int i = zzjdVar.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.zzb;
        if (i3 > jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(zzjdVar.zzb, 0, this.zzb, this.zzc, zzjdVar.zzc);
        this.zzc = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzc();
        for (int i = 0; i < this.zzc; i++) {
            if (obj.equals(Long.valueOf(this.zzb[i]))) {
                long[] jArr = this.zzb;
                System.arraycopy(jArr, i + 1, jArr, i, (this.zzc - i) - 1);
                this.zzc--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzc(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzd(i));
        }
    }

    private final String zzd(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.zzc).toString();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzc();
        zzc(i);
        long[] jArr = this.zzb;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzc();
        zzc(i);
        long[] jArr = this.zzb;
        long j = jArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        zzc();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzd(i));
        }
        long[] jArr = this.zzb;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzb, i, jArr2, i + 1, this.zzc - i);
            this.zzb = jArr2;
        }
        this.zzb[i] = jLongValue;
        this.zzc++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Long) obj).longValue());
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzim
    public final /* synthetic */ zzim<Long> zza(int i) {
        if (i < this.zzc) {
            throw new IllegalArgumentException();
        }
        return new zzjd(Arrays.copyOf(this.zzb, i), this.zzc);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(zzb(i));
    }

    static {
        zzjd zzjdVar = new zzjd(new long[0], 0);
        zza = zzjdVar;
        zzjdVar.c_();
    }
}
