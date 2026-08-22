package org.jivesoftware.smack.util;

/* JADX INFO: loaded from: classes10.dex */
public class NumberUtil {
    @Deprecated
    public static void checkIfInUInt32Range(long j) {
        requireUInt32(j);
    }

    public static long requireUInt32(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("unsigned 32-bit integers can't be negative: " + j);
        }
        if (j <= 4294967295L) {
            return j;
        }
        throw new IllegalArgumentException("unsigned 32-bit integers can't be greater than 2^32 - 1: " + j);
    }

    public static int requireUShort16(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("unsigned 16-bit integers can't be negative: " + i);
        }
        if (i <= 65535) {
            return i;
        }
        throw new IllegalArgumentException("unsigned 16-bit integers can't be greater than 2^16 - 1: " + i);
    }
}
