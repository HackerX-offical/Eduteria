package com.amazonaws.internal.keyvaluestore;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
class KeyProvider10 implements KeyProvider {
    static final String AES_KEY_ALGORITHM = "AES";
    static final int CIPHER_AES_GCM_NOPADDING_KEY_LENGTH_IN_BITS = 256;
    static final String SHARED_PREFERENCES_KEY_NAME_FOR_ENCRYPTION_KEY = "AesGcmNoPaddingEncryption10-encryption-key";
    private SecureRandom secureRandom = new SecureRandom();
    private static final Log logger = LogFactory.getLog("KeyProvider10");
    private static final Object LOCK = new Object();

    KeyProvider10() {
    }

    @Override // com.amazonaws.internal.keyvaluestore.KeyProvider
    public Key getKey(SharedPreferences sharedPreferences, String str, Context context) {
        synchronized (LOCK) {
            try {
                try {
                    if (sharedPreferences.contains(SHARED_PREFERENCES_KEY_NAME_FOR_ENCRYPTION_KEY)) {
                        logger.debug("Loading the encryption key from SharedPreferences");
                        return new SecretKeySpec(Base64.decode(sharedPreferences.getString(SHARED_PREFERENCES_KEY_NAME_FOR_ENCRYPTION_KEY, null)), "AES");
                    }
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                    keyGenerator.init(256, this.secureRandom);
                    SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
                    sharedPreferences.edit().putString(SHARED_PREFERENCES_KEY_NAME_FOR_ENCRYPTION_KEY, Base64.encodeAsString(secretKeyGenerateKey.getEncoded())).apply();
                    logger.info("Generated and saved the encryption key to SharedPreferences");
                    return secretKeyGenerateKey;
                } catch (Exception e2) {
                    logger.error("Error in loading the key from keystore.");
                    throw new IllegalStateException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
