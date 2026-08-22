package com.clevertap.android.sdk.cryption;

import android.security.keystore.KeyGenParameterSpec;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.clevertap.android.sdk.Logger;
import com.google.android.gms.stats.CodePackage;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTKeyGenerator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\n\u001a\u00020\tJ\n\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/cryption/CTKeyGenerator;", "", "cryptRepository", "Lcom/clevertap/android/sdk/cryption/CryptRepository;", "<init>", "(Lcom/clevertap/android/sdk/cryption/CryptRepository;)V", "getCryptRepository", "()Lcom/clevertap/android/sdk/cryption/CryptRepository;", "generateOrGetKey", "Ljavax/crypto/SecretKey;", "generateSecretKey", "fromAndroidKeystore", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTKeyGenerator {
    private final CryptRepository cryptRepository;

    public CTKeyGenerator(CryptRepository cryptRepository) {
        Intrinsics.checkNotNullParameter(cryptRepository, "cryptRepository");
        this.cryptRepository = cryptRepository;
    }

    public final CryptRepository getCryptRepository() {
        return this.cryptRepository;
    }

    public final SecretKey generateOrGetKey() {
        return fromAndroidKeystore();
    }

    public final SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        keyGenerator.init(256);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNull(secretKeyGenerateKey);
        return secretKeyGenerateKey;
    }

    private final SecretKey fromAndroidKeystore() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!keyStore.containsAlias(CryptRepositoryKt.ENCRYPTION_KEY)) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM, "AndroidKeyStore");
                KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(CryptRepositoryKt.ENCRYPTION_KEY, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build();
                Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
                keyGenerator.init(keyGenParameterSpecBuild);
                return keyGenerator.generateKey();
            }
            Key key = keyStore.getKey(CryptRepositoryKt.ENCRYPTION_KEY, null);
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type javax.crypto.SecretKey");
            return (SecretKey) key;
        } catch (Exception e2) {
            Logger.v("Error generating or retrieving key", e2);
            return null;
        }
    }
}
