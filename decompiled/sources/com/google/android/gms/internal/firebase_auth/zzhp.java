package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhp extends zzgp<Double> implements zzim<Double>, zzjy, RandomAccess {
    private static final zzhp zza;
    private double[] zzb;
    private int zzc;

    zzhp() {
        this(new double[10], 0);
    }

    private zzhp(double[] dArr, int i) {
        this.zzb = dArr;
        this.zzc = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzc();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzb;
        System.arraycopy(dArr, i2, dArr, i, this.zzc - i2);
        this.zzc -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhp)) {
            return super.equals(obj);
        }
        zzhp zzhpVar = (zzhp) obj;
        if (this.zzc != zzhpVar.zzc) {
            return false;
        }
        double[] dArr = zzhpVar.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (Double.doubleToLongBits(this.zzb[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i = 0; i < this.zzc; i++) {
            iZza = (iZza * 31) + zzig.zza(Double.doubleToLongBits(this.zzb[i]));
        }
        return iZza;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    public final void zza(double d2) {
        zzc();
        int i = this.zzc;
        double[] dArr = this.zzb;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        dArr3[i2] = d2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzc();
        zzig.zza(collection);
        if (!(collection instanceof zzhp)) {
            return super.addAll(collection);
        }
        zzhp zzhpVar = (zzhp) collection;
        int i = zzhpVar.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.zzb;
        if (i3 > dArr.length) {
            this.zzb = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(zzhpVar.zzb, 0, this.zzb, this.zzc, zzhpVar.zzc);
        this.zzc = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzc();
        for (int i = 0; i < this.zzc; i++) {
            if (obj.equals(Double.valueOf(this.zzb[i]))) {
                double[] dArr = this.zzb;
                System.arraycopy(dArr, i + 1, dArr, i, (this.zzc - i) - 1);
                this.zzc--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzb(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
    }

    private final String zzc(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.zzc).toString();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzc();
        zzb(i);
        double[] dArr = this.zzb;
        double d2 = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzc();
        zzb(i);
        double[] dArr = this.zzb;
        double d2 = dArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        zzc();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzc(i));
        }
        double[] dArr = this.zzb;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzb, i, dArr2, i + 1, this.zzc - i);
            this.zzb = dArr2;
        }
        this.zzb[i] = dDoubleValue;
        this.zzc++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgp, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zza(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzim
    public final /* synthetic */ zzim<Double> zza(int i) {
        if (i < this.zzc) {
            throw new IllegalArgumentException();
        }
        return new zzhp(Arrays.copyOf(this.zzb, i), this.zzc);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzb(i);
        return Double.valueOf(this.zzb[i]);
    }

    static {
        zzhp zzhpVar = new zzhp(new double[0], 0);
        zza = zzhpVar;
        zzhpVar.c_();
    }
}
