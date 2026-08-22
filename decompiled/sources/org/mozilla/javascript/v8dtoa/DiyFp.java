package org.mozilla.javascript.v8dtoa;

import com.clevertap.android.sdk.Constants;
import cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy;

/* JADX INFO: loaded from: classes10.dex */
class DiyFp {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int kSignificandSize = 64;
    static final long kUint64MSB = Long.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f1509f;

    private static boolean uint64_gte(long j, long j2) {
        if (j != j2) {
            if (!(((j < 0) ^ (j > j2)) ^ (j2 < 0))) {
                return false;
            }
        }
        return true;
    }

    DiyFp() {
        this.f1509f = 0L;
        this.f1508e = 0;
    }

    DiyFp(long j, int i) {
        this.f1509f = j;
        this.f1508e = i;
    }

    void subtract(DiyFp diyFp) {
        this.f1509f -= diyFp.f1509f;
    }

    static DiyFp minus(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f1509f, diyFp.f1508e);
        diyFp3.subtract(diyFp2);
        return diyFp3;
    }

    void multiply(DiyFp diyFp) {
        long j = this.f1509f;
        long j2 = j >>> 32;
        long j3 = j & 4294967295L;
        long j4 = diyFp.f1509f;
        long j5 = j4 >>> 32;
        long j6 = j4 & 4294967295L;
        long j7 = j2 * j5;
        long j8 = j5 * j3;
        long j9 = j2 * j6;
        long j10 = j7 + (j9 >>> 32) + (j8 >>> 32) + ((((((j3 * j6) >>> 32) + (j9 & 4294967295L)) + (4294967295L & j8)) + CacheValidityPolicy.MAX_AGE) >>> 32);
        this.f1508e += diyFp.f1508e + 64;
        this.f1509f = j10;
    }

    static DiyFp times(DiyFp diyFp, DiyFp diyFp2) {
        DiyFp diyFp3 = new DiyFp(diyFp.f1509f, diyFp.f1508e);
        diyFp3.multiply(diyFp2);
        return diyFp3;
    }

    void normalize() {
        long j = this.f1509f;
        int i = this.f1508e;
        while (((-18014398509481984L) & j) == 0) {
            j <<= 10;
            i -= 10;
        }
        while ((Long.MIN_VALUE & j) == 0) {
            j <<= 1;
            i--;
        }
        this.f1509f = j;
        this.f1508e = i;
    }

    static DiyFp normalize(DiyFp diyFp) {
        DiyFp diyFp2 = new DiyFp(diyFp.f1509f, diyFp.f1508e);
        diyFp2.normalize();
        return diyFp2;
    }

    long f() {
        return this.f1509f;
    }

    int e() {
        return this.f1508e;
    }

    void setF(long j) {
        this.f1509f = j;
    }

    void setE(int i) {
        this.f1508e = i;
    }

    public String toString() {
        return "[DiyFp f:" + this.f1509f + ", e:" + this.f1508e + Constants.AES_SUFFIX;
    }
}
