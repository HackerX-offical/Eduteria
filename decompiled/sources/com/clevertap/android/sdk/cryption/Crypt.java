package com.clevertap.android.sdk.cryption;

import kotlin.Metadata;

/* JADX INFO: compiled from: Crypt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/clevertap/android/sdk/cryption/Crypt;", "", "<init>", "()V", "encryptInternal", "", "plainText", "decryptInternal", "cipherText", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Crypt {
    public abstract String decryptInternal(String cipherText);

    public abstract String encryptInternal(String plainText);

    protected Crypt() {
    }
}
