package com.clevertap.android.sdk.cryption;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CryptExtensions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toBase64", "", "", "fromBase64", "clevertap-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CryptExtensionsKt {
    public static final String toBase64(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        String strEncodeToString = Base64.encodeToString(bArr, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public static final byte[] fromBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArrDecode = Base64.decode(str, 2);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return bArrDecode;
    }
}
