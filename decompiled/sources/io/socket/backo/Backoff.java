package io.socket.backo;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes9.dex */
public class Backoff {
    private int attempts;
    private double jitter;
    private long ms = 100;
    private long max = 10000;
    private int factor = 2;

    public long duration() {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(this.ms);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(this.factor);
        int i = this.attempts;
        this.attempts = i + 1;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf2.pow(i));
        if (this.jitter != 0.0d) {
            double dRandom = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(dRandom).multiply(BigDecimal.valueOf(this.jitter)).multiply(new BigDecimal(bigIntegerMultiply)).toBigInteger();
            bigIntegerMultiply = (((int) Math.floor(dRandom * 10.0d)) & 1) == 0 ? bigIntegerMultiply.subtract(bigInteger) : bigIntegerMultiply.add(bigInteger);
        }
        return bigIntegerMultiply.min(BigInteger.valueOf(this.max)).longValue();
    }

    public void reset() {
        this.attempts = 0;
    }

    public Backoff setMin(long j) {
        this.ms = j;
        return this;
    }

    public Backoff setMax(long j) {
        this.max = j;
        return this;
    }

    public Backoff setFactor(int i) {
        this.factor = i;
        return this;
    }

    public Backoff setJitter(double d2) {
        this.jitter = d2;
        return this;
    }

    public int getAttempts() {
        return this.attempts;
    }
}
