package com.google.firebase.database.core.utilities;

import java.util.Random;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class PushIdGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String PUSH_CHARS = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
    private static final Random randGen = new Random();
    private static long lastPushTime = 0;
    private static final int[] lastRandChars = new int[12];

    public static synchronized String generatePushChildName(long j) {
        StringBuilder sb;
        boolean z = j == lastPushTime;
        lastPushTime = j;
        char[] cArr = new char[8];
        sb = new StringBuilder(20);
        for (int i = 7; i >= 0; i--) {
            cArr[i] = PUSH_CHARS.charAt((int) (j % 64));
            j /= 64;
        }
        sb.append(cArr);
        if (z) {
            incrementArray();
        } else {
            for (int i2 = 0; i2 < 12; i2++) {
                lastRandChars[i2] = randGen.nextInt(64);
            }
        }
        for (int i3 = 0; i3 < 12; i3++) {
            sb.append(PUSH_CHARS.charAt(lastRandChars[i3]));
        }
        return sb.toString();
    }

    private static void incrementArray() {
        for (int i = 11; i >= 0; i--) {
            int[] iArr = lastRandChars;
            int i2 = iArr[i];
            if (i2 != 63) {
                iArr[i] = i2 + 1;
                return;
            }
            iArr[i] = 0;
        }
    }
}
