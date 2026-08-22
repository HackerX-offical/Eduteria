package com.google.android.gms.internal.p000authapi;

import android.util.Base64;
import java.security.SecureRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zbat {
    private static final SecureRandom zba = new SecureRandom();

    public static String zba() {
        byte[] bArr = new byte[16];
        zba.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
