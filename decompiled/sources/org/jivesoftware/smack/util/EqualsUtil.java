package org.jivesoftware.smack.util;

/* JADX INFO: loaded from: classes10.dex */
public final class EqualsUtil {

    @FunctionalInterface
    public interface EqualsComperator<T> {
        void compare(Builder builder, T t);
    }

    private EqualsUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean equals(T t, Object obj, EqualsComperator<T> equalsComperator) {
        if (obj == null) {
            return false;
        }
        if (t == obj) {
            return true;
        }
        Class<?> cls = t.getClass();
        if (cls != obj.getClass() || t.hashCode() != obj.hashCode()) {
            return false;
        }
        Builder builder = new Builder();
        equalsComperator.compare(builder, cls.cast(obj));
        return builder.isEquals;
    }

    public static final class Builder {
        private boolean isEquals;

        private Builder() {
            this.isEquals = true;
        }

        private void nullSafeCompare(Object obj, Object obj2, Runnable runnable) {
            if (this.isEquals && obj != obj2) {
                if (obj == null || obj2 == null) {
                    this.isEquals = false;
                } else {
                    runnable.run();
                }
            }
        }

        public <O> Builder append(O o, O o2) {
            if (!this.isEquals || o == o2) {
                return this;
            }
            if (o == null || o2 == null) {
                this.isEquals = false;
                return this;
            }
            this.isEquals = o.equals(o2);
            return this;
        }

        public Builder append(boolean z, boolean z2) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = z == z2;
            return this;
        }

        public Builder append(final boolean[] zArr, final boolean[] zArr2) {
            nullSafeCompare(zArr, zArr2, new Runnable() { // from class: org.jivesoftware.smack.util.EqualsUtil$Builder$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14225lambda$append$0$orgjivesoftwaresmackutilEqualsUtil$Builder(zArr, zArr2);
                }
            });
            return this;
        }

        /* JADX INFO: renamed from: lambda$append$0$org-jivesoftware-smack-util-EqualsUtil$Builder, reason: not valid java name */
        /* synthetic */ void m14225lambda$append$0$orgjivesoftwaresmackutilEqualsUtil$Builder(boolean[] zArr, boolean[] zArr2) {
            if (zArr.length != zArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i = 0; i < zArr.length && this.isEquals; i++) {
                append(zArr[i], zArr2[i]);
            }
        }

        public Builder append(byte b2, byte b3) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = b2 == b3;
            return this;
        }

        public Builder append(final byte[] bArr, final byte[] bArr2) {
            nullSafeCompare(bArr, bArr2, new Runnable() { // from class: org.jivesoftware.smack.util.EqualsUtil$Builder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14226lambda$append$1$orgjivesoftwaresmackutilEqualsUtil$Builder(bArr, bArr2);
                }
            });
            return this;
        }

        /* JADX INFO: renamed from: lambda$append$1$org-jivesoftware-smack-util-EqualsUtil$Builder, reason: not valid java name */
        /* synthetic */ void m14226lambda$append$1$orgjivesoftwaresmackutilEqualsUtil$Builder(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i = 0; i < bArr.length && this.isEquals; i++) {
                append(bArr[i], bArr2[i]);
            }
        }

        public Builder append(char c2, char c3) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = c2 == c3;
            return this;
        }

        public Builder append(final char[] cArr, final char[] cArr2) {
            nullSafeCompare(cArr, cArr2, new Runnable() { // from class: org.jivesoftware.smack.util.EqualsUtil$Builder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14227lambda$append$2$orgjivesoftwaresmackutilEqualsUtil$Builder(cArr, cArr2);
                }
            });
            return this;
        }

        /* JADX INFO: renamed from: lambda$append$2$org-jivesoftware-smack-util-EqualsUtil$Builder, reason: not valid java name */
        /* synthetic */ void m14227lambda$append$2$orgjivesoftwaresmackutilEqualsUtil$Builder(char[] cArr, char[] cArr2) {
            if (cArr.length != cArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i = 0; i < cArr.length && this.isEquals; i++) {
                append(cArr[i], cArr2[i]);
            }
        }

        public Builder append(double d2, double d3) {
            return !this.isEquals ? this : append(Double.doubleToLongBits(d2), Double.doubleToLongBits(d3));
        }

        public Builder append(final double[] dArr, final double[] dArr2) {
            nullSafeCompare(dArr, dArr2, new Runnable() { // from class: org.jivesoftware.smack.util.EqualsUtil$Builder$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14228lambda$append$3$orgjivesoftwaresmackutilEqualsUtil$Builder(dArr, dArr2);
                }
            });
            return this;
        }

        /* JADX INFO: renamed from: lambda$append$3$org-jivesoftware-smack-util-EqualsUtil$Builder, reason: not valid java name */
        /* synthetic */ void m14228lambda$append$3$orgjivesoftwaresmackutilEqualsUtil$Builder(double[] dArr, double[] dArr2) {
            if (dArr.length != dArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i = 0; i < dArr.length && this.isEquals; i++) {
                append(dArr[i], dArr2[i]);
            }
        }

        public Builder append(float f2, float f3) {
            return !this.isEquals ? this : append(Float.floatToIntBits(f2), Float.floatToIntBits(f3));
        }

        public Builder append(final float[] fArr, final float[] fArr2) {
            nullSafeCompare(fArr, fArr2, new Runnable() { // from class: org.jivesoftware.smack.util.EqualsUtil$Builder$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14229lambda$append$4$orgjivesoftwaresmackutilEqualsUtil$Builder(fArr, fArr2);
                }
            });
            return this;
        }

        /* JADX INFO: renamed from: lambda$append$4$org-jivesoftware-smack-util-EqualsUtil$Builder, reason: not valid java name */
        /* synthetic */ void m14229lambda$append$4$orgjivesoftwaresmackutilEqualsUtil$Builder(float[] fArr, float[] fArr2) {
            if (fArr.length != fArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i = 0; i < fArr.length && this.isEquals; i++) {
                append(fArr[i], fArr2[i]);
            }
        }

        public Builder append(int i, int i2) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = i == i2;
            return this;
        }

        public Builder append(final int[] iArr, final int[] iArr2) {
            nullSafeCompare(iArr, iArr2, new Runnable() { // from class: org.jivesoftware.smack.util.EqualsUtil$Builder$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14230lambda$append$5$orgjivesoftwaresmackutilEqualsUtil$Builder(iArr, iArr2);
                }
            });
            return this;
        }

        /* JADX INFO: renamed from: lambda$append$5$org-jivesoftware-smack-util-EqualsUtil$Builder, reason: not valid java name */
        /* synthetic */ void m14230lambda$append$5$orgjivesoftwaresmackutilEqualsUtil$Builder(int[] iArr, int[] iArr2) {
            if (iArr.length != iArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i = 0; i < iArr.length && this.isEquals; i++) {
                append(iArr[i], iArr2[i]);
            }
        }

        public Builder append(long j, long j2) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = j == j2;
            return this;
        }

        public Builder append(final long[] jArr, final long[] jArr2) {
            nullSafeCompare(jArr, jArr2, new Runnable() { // from class: org.jivesoftware.smack.util.EqualsUtil$Builder$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14231lambda$append$6$orgjivesoftwaresmackutilEqualsUtil$Builder(jArr, jArr2);
                }
            });
            return this;
        }

        /* JADX INFO: renamed from: lambda$append$6$org-jivesoftware-smack-util-EqualsUtil$Builder, reason: not valid java name */
        /* synthetic */ void m14231lambda$append$6$orgjivesoftwaresmackutilEqualsUtil$Builder(long[] jArr, long[] jArr2) {
            if (jArr.length != jArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i = 0; i < jArr.length && this.isEquals; i++) {
                append(jArr[i], jArr2[i]);
            }
        }
    }
}
