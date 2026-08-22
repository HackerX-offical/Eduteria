package com.appnew.android.Utils;

import java.io.IOException;
import javax.crypto.CipherInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Extension.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"forceSkip", "", "Ljavax/crypto/CipherInputStream;", "bytesToSkip", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExtensionKt {
    public static final long forceSkip(CipherInputStream cipherInputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(cipherInputStream, "<this>");
        long j2 = 0;
        while (j2 < j) {
            cipherInputStream.read();
            j2++;
        }
        return j2;
    }
}
