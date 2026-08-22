package org.jivesoftware.smack.util;

/* JADX INFO: loaded from: classes10.dex */
public class HashCode {
    private static final int MULTIPLIER_VALUE = 37;

    @FunctionalInterface
    public interface Calculator {
        void calculateHash(Builder builder);
    }

    public static class Cache {
        private boolean calculated;
        private int hashcode;

        public int getHashCode(Calculator calculator) {
            if (this.calculated) {
                return this.hashcode;
            }
            Builder builder = new Builder();
            calculator.calculateHash(builder);
            this.calculated = true;
            int i = builder.hashcode;
            this.hashcode = i;
            return i;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int hashcode = 17;

        private void applyHash() {
            applyHash(0);
        }

        private void applyHash(int i) {
            this.hashcode = (this.hashcode * 37) + i;
        }

        public Builder append(Object obj) {
            if (obj == null) {
                applyHash();
                return this;
            }
            if (obj.getClass().isArray()) {
                if (obj instanceof int[]) {
                    append(obj);
                } else if (obj instanceof long[]) {
                    append((long[]) obj);
                } else if (obj instanceof boolean[]) {
                    append((boolean[]) obj);
                } else if (obj instanceof double[]) {
                    append((double[]) obj);
                } else if (obj instanceof float[]) {
                    append((float[]) obj);
                } else if (obj instanceof short[]) {
                    append(obj);
                } else if (obj instanceof char[]) {
                    append((char[]) obj);
                } else if (obj instanceof byte[]) {
                    append((byte[]) obj);
                } else {
                    append((Object[]) obj);
                }
            }
            applyHash(obj.hashCode());
            return this;
        }

        public Builder append(boolean z) {
            applyHash(!z ? 1 : 0);
            return this;
        }

        public Builder append(boolean[] zArr) {
            if (zArr == null) {
                applyHash();
                return this;
            }
            for (boolean z : zArr) {
                append(z);
            }
            return this;
        }

        public Builder append(byte b2) {
            applyHash(b2);
            return this;
        }

        public Builder append(byte[] bArr) {
            if (bArr == null) {
                applyHash();
                return this;
            }
            for (byte b2 : bArr) {
                append(b2);
            }
            return this;
        }

        public Builder append(char c2) {
            applyHash(c2);
            return this;
        }

        public Builder append(char[] cArr) {
            if (cArr == null) {
                applyHash();
                return this;
            }
            for (char c2 : cArr) {
                append(c2);
            }
            return this;
        }

        public Builder append(double d2) {
            return append(Double.doubleToLongBits(d2));
        }

        public Builder append(double[] dArr) {
            if (dArr == null) {
                applyHash();
                return this;
            }
            for (double d2 : dArr) {
                append(d2);
            }
            return this;
        }

        public Builder append(float f2) {
            return append(Float.floatToIntBits(f2));
        }

        public Builder append(float[] fArr) {
            if (fArr == null) {
                applyHash();
                return this;
            }
            for (float f2 : fArr) {
                append(f2);
            }
            return this;
        }

        public Builder append(long j) {
            applyHash((int) (j ^ (j >>> 32)));
            return this;
        }

        public Builder append(long[] jArr) {
            if (jArr == null) {
                applyHash();
                return this;
            }
            for (long j : jArr) {
                append(j);
            }
            return this;
        }

        public Builder append(Object[] objArr) {
            if (objArr == null) {
                applyHash();
                return this;
            }
            for (Object obj : objArr) {
                append(obj);
            }
            return this;
        }

        public int build() {
            return this.hashcode;
        }
    }
}
