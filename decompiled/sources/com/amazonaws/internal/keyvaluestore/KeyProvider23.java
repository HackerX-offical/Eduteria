package com.amazonaws.internal.keyvaluestore;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.android.gms.stats.CodePackage;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes4.dex */
class KeyProvider23 implements KeyProvider {
    static final String AES_KEY_ALGORITHM = "AES";
    static final String ANDROID_KEY_STORE_NAME = "AndroidKeyStore";
    static final int CIPHER_AES_GCM_NOPADDING_KEY_LENGTH_IN_BITS = 256;
    private static final Log logger = LogFactory.getLog(KeyProvider23.class);
    private static final Object LOCK = new Object();

    KeyProvider23() {
    }

    @Override // com.amazonaws.internal.keyvaluestore.KeyProvider
    public Key getKey(SharedPreferences sharedPreferences, String str, Context context) {
        synchronized (LOCK) {
            try {
                try {
                    KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
                    keyStore.load(null);
                    if (!keyStore.containsAlias(str)) {
                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", ANDROID_KEY_STORE_NAME);
                        keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setKeySize(256).setRandomizedEncryptionRequired(false).build());
                        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
                        logger.info("Generated the encryption key using Android KeyStore.");
                        return secretKeyGenerateKey;
                    }
                    Log log = logger;
                    log.debug("AndroidKeyStore contains keyAlias " + str);
                    log.debug("Loading the encryption key from Android KeyStore.");
                    return keyStore.getKey(str, null);
                } catch (Exception e2) {
                    logger.error("Error in accessing the Android KeyStore.", e2);
                    throw new IllegalStateException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
