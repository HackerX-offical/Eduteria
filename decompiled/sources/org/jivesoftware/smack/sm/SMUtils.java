package org.jivesoftware.smack.sm;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class SMUtils {
    private static long MASK_32_BIT = BigInteger.ONE.shiftLeft(32).subtract(BigInteger.ONE).longValue();

    public static long incrementHeight(long j) {
        return (j + 1) & MASK_32_BIT;
    }

    public static long calculateDelta(long j, long j2) {
        if (j2 > j) {
            throw new IllegalStateException("Illegal Stream Management State: Last known handled count (" + j2 + ") is greater than reported handled count (" + j + ')');
        }
        return (j - j2) & MASK_32_BIT;
    }
}
