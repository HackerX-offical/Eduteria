package com.amazonaws.services.s3.internal.crypto;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
final class KMSSecuredCEK extends SecuredCEK {
    static final String KEY_PROTECTION_MECHANISM = "kms";

    KMSSecuredCEK(byte[] bArr, Map<String, String> map) {
        super(bArr, KEY_PROTECTION_MECHANISM, map);
    }

    public static boolean isKMSKeyWrapped(String str) {
        return KEY_PROTECTION_MECHANISM.equals(str);
    }
}
