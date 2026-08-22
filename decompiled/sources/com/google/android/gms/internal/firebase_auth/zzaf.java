package com.google.android.gms.internal.firebase_auth;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzaf {
    protected zzaf() {
    }

    public abstract boolean zza(char c2);

    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzav.zza(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzc(char c2) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }
}
