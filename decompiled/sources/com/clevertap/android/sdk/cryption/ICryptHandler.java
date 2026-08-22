package com.clevertap.android.sdk.cryption;

import com.clevertap.android.sdk.cryption.CryptHandler;
import kotlin.Metadata;

/* JADX INFO: compiled from: CryptHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/sdk/cryption/ICryptHandler;", "", "encryptSafe", "", "plainText", "decryptSafe", "cipherText", "encrypt", "decrypt", "decryptWithAlgorithm", "algorithm", "Lcom/clevertap/android/sdk/cryption/CryptHandler$EncryptionAlgorithm;", "updateMigrationFailureCount", "", "migrationSuccessful", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICryptHandler {
    String decrypt(String cipherText);

    String decryptSafe(String cipherText);

    String decryptWithAlgorithm(String cipherText, CryptHandler.EncryptionAlgorithm algorithm);

    String encrypt(String plainText);

    String encryptSafe(String plainText);

    void updateMigrationFailureCount(boolean migrationSuccessful);
}
