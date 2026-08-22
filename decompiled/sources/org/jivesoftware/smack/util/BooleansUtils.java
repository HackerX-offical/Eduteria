package org.jivesoftware.smack.util;

/* JADX INFO: loaded from: classes10.dex */
public class BooleansUtils {
    public static boolean contains(boolean[] zArr, boolean z) {
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    public static int numberOf(boolean[] zArr, boolean z) {
        int i = 0;
        for (boolean z2 : zArr) {
            if (z2 == z) {
                i++;
            }
        }
        return i;
    }
}
