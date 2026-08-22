package com.amazonaws.internal.keyvaluestore;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.KeyPairGeneratorSpec;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes4.dex */
public class KeyProvider18 implements KeyProvider {
    static final String ANDROID_KEY_STORE_NAME = "AndroidKeyStore";
    static final int CIPHER_AES_GCM_NOPADDING_KEY_LENGTH_IN_BITS = 256;
    static final String CIPHER_PROVIDER_NAME_FOR_RSA = "AndroidOpenSSL";
    static final String CIPHER_RSA_MODE = "RSA/ECB/PKCS1Padding";
    static final String ENCRYPTED_AES_KEY = "AesGcmNoPadding18-encrypted-encryption-key";
    static final String KEY_ALGORITHM_AES = "AES";
    static final String KEY_ALGORITHM_RSA = "RSA";
    private SecureRandom secureRandom;
    private static final Log logger = LogFactory.getLog(KeyProvider18.class);
    private static final Object LOCK = new Object();

    @Override // com.amazonaws.internal.keyvaluestore.KeyProvider
    public Key getKey(SharedPreferences sharedPreferences, String str, Context context) {
        synchronized (LOCK) {
            try {
                try {
                    KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
                    keyStore.load(null);
                    initializeRSAKeyFromKeyStore(context, keyStore, str);
                    if (sharedPreferences.contains(ENCRYPTED_AES_KEY)) {
                        logger.debug("Loading the encryption key from SharedPreferences");
                        return new SecretKeySpec(rsaDecrypt(str, Base64.decode(sharedPreferences.getString(ENCRYPTED_AES_KEY, null))), "AES");
                    }
                    this.secureRandom = new SecureRandom();
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                    keyGenerator.init(256, this.secureRandom);
                    SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
                    sharedPreferences.edit().putString(ENCRYPTED_AES_KEY, Base64.encodeAsString(rsaEncrypt(str, secretKeyGenerateKey.getEncoded()))).apply();
                    logger.info("Generated and saved the encryption key to SharedPreferences");
                    return secretKeyGenerateKey;
                } catch (Exception e2) {
                    logger.error("Error in getting the key.", e2);
                    throw new IllegalStateException(e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private byte[] rsaEncrypt(String str, byte[] bArr) {
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
            keyStore.load(null);
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(str, null);
            Cipher cipher = Cipher.getInstance(CIPHER_RSA_MODE, CIPHER_PROVIDER_NAME_FOR_RSA);
            cipher.init(1, privateKeyEntry.getCertificate().getPublicKey());
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            logger.error("Exception occurred while encrypting data. " + e2.getMessage());
            return null;
        }
    }

    private byte[] rsaDecrypt(String str, byte[] bArr) {
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE_NAME);
            keyStore.load(null);
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(str, null);
            Cipher cipher = Cipher.getInstance(CIPHER_RSA_MODE, CIPHER_PROVIDER_NAME_FOR_RSA);
            cipher.init(2, privateKeyEntry.getPrivateKey());
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            logger.error("Exception occurred while decrypting data. " + e2.getMessage());
            return null;
        }
    }

    private void initializeRSAKeyFromKeyStore(Context context, KeyStore keyStore, String str) throws Exception {
        if (!keyStore.containsAlias(str)) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal("CN=" + str)).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM_RSA, ANDROID_KEY_STORE_NAME);
            keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
            keyPairGenerator.generateKeyPair();
            return;
        }
        logger.info("Android KeyStore contains the alias: " + str);
    }
}
