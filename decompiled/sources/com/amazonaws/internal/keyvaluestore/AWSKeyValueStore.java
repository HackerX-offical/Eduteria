package com.amazonaws.internal.keyvaluestore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import com.clevertap.android.sdk.Constants;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes4.dex */
public class AWSKeyValueStore {
    private static final int ANDROID_API_LEVEL_10 = 10;
    private static final int ANDROID_API_LEVEL_18 = 18;
    private static final int ANDROID_API_LEVEL_23 = 23;
    private static final int AWS_KEY_VALUE_STORE_VERSION = 1;
    static final String CHARSET_NAME = "UTF-8";
    static final String CIPHER_AES_GCM_NOPADDING = "AES/GCM/NoPadding";
    static final int CIPHER_AES_GCM_NOPADDING_IV_LENGTH_IN_BYTES = 12;
    static final int CIPHER_AES_GCM_NOPADDING_TAG_LENGTH_LENGTH_IN_BITS = 128;
    static final String KEY_STORE_ALIAS_FOR_AES_SUFFIX = ".aesKeyStoreAlias";
    static final String KEY_STORE_ALIAS_FOR_RSA_SUFFIX = ".rsaKeyStoreAlias";
    static final String SHARED_PREFERENCES_DATA_IDENTIFIER_SUFFIX = ".encrypted";
    static final String SHARED_PREFERENCES_ENCRYPTION_KEY_NAMPESPACE_SUFFIX = ".encryptionkey";
    static final String SHARED_PREFERENCES_IV_SUFFIX = ".iv";
    static final String SHARED_PREFERENCES_STORE_VERSION_SUFFIX = ".keyvaluestoreversion";
    private int apiLevel;
    private Map<String, String> cache;
    Context context;
    private Key encryptionKey;
    boolean isPersistenceEnabled;
    private String keyAlias;
    private KeyProvider keyProvider;
    private SecureRandom secureRandom;
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferencesForEncryptionKey;
    final String sharedPreferencesName;
    private static final Log logger = LogFactory.getLog(AWSKeyValueStore.class);
    static Map<String, HashMap<String, String>> cacheFactory = new HashMap();
    private static final Object LOCK = new Object();

    private static Map<String, String> getCacheForKey(String str) {
        if (cacheFactory.containsKey(str)) {
            return cacheFactory.get(str);
        }
        HashMap<String, String> map = new HashMap<>();
        cacheFactory.put(str, map);
        return map;
    }

    public AWSKeyValueStore(Context context, String str, boolean z) {
        synchronized (LOCK) {
            this.secureRandom = new SecureRandom();
            this.cache = getCacheForKey(str);
            this.sharedPreferencesName = str;
            this.apiLevel = Build.VERSION.SDK_INT;
            this.context = context;
            setPersistenceEnabled(z);
        }
    }

    public void setPersistenceEnabled(boolean z) {
        synchronized (LOCK) {
            boolean z2 = this.isPersistenceEnabled;
            this.isPersistenceEnabled = z;
            if (z && !z2) {
                this.sharedPreferences = this.context.getSharedPreferences(this.sharedPreferencesName, 0);
                this.sharedPreferencesForEncryptionKey = this.context.getSharedPreferences(this.sharedPreferencesName + SHARED_PREFERENCES_ENCRYPTION_KEY_NAMPESPACE_SUFFIX, 0);
                Log log = logger;
                log.info("Detected Android API Level = " + this.apiLevel);
                int i = this.apiLevel;
                if (i >= 23) {
                    this.keyAlias = this.sharedPreferencesName + KEY_STORE_ALIAS_FOR_AES_SUFFIX;
                    log.info("Using keyAlias = " + this.keyAlias);
                    KeyProvider23 keyProvider23 = new KeyProvider23();
                    this.keyProvider = keyProvider23;
                    this.encryptionKey = keyProvider23.getKey(this.sharedPreferencesForEncryptionKey, this.keyAlias, this.context);
                } else if (i >= 18) {
                    this.keyAlias = this.sharedPreferencesName + KEY_STORE_ALIAS_FOR_RSA_SUFFIX;
                    log.info("Using keyAlias = " + this.keyAlias);
                    KeyProvider18 keyProvider18 = new KeyProvider18();
                    this.keyProvider = keyProvider18;
                    this.encryptionKey = keyProvider18.getKey(this.sharedPreferencesForEncryptionKey, this.keyAlias, this.context);
                } else if (i >= 10) {
                    KeyProvider10 keyProvider10 = new KeyProvider10();
                    this.keyProvider = keyProvider10;
                    this.encryptionKey = keyProvider10.getKey(this.sharedPreferencesForEncryptionKey, null, this.context);
                } else {
                    log.error("API Level " + String.valueOf(Build.VERSION.SDK_INT) + " not supported by the SDK. Setting persistence to false.");
                    this.isPersistenceEnabled = false;
                }
                log.info("Creating the AWSKeyValueStore with key for sharedPreferences = " + this.sharedPreferencesName);
                onMigrateFromNoEncryption();
            } else if (!z) {
                logger.info("Persistence is disabled. Data will be accessed from memory.");
            }
            if (!z && z2) {
                this.sharedPreferences.edit().clear().apply();
            }
        }
    }

    public boolean contains(String str) {
        synchronized (LOCK) {
            if (this.isPersistenceEnabled) {
                return this.sharedPreferences.contains(str + SHARED_PREFERENCES_DATA_IDENTIFIER_SUFFIX);
            }
            return this.cache.containsKey(str);
        }
    }

    public synchronized String get(String str) {
        synchronized (LOCK) {
            if (this.isPersistenceEnabled) {
                String str2 = str + SHARED_PREFERENCES_DATA_IDENTIFIER_SUFFIX;
                if (!this.sharedPreferences.contains(str2)) {
                    return null;
                }
                try {
                    if (Integer.parseInt(this.sharedPreferences.getString(str2 + SHARED_PREFERENCES_STORE_VERSION_SUFFIX, null)) != 1) {
                        logger.error("The version of the data read from SharedPreferences for " + str + " does not match the version of the store.");
                        return null;
                    }
                    String string = this.sharedPreferences.getString(str2, null);
                    byte[] initializationVector = getInitializationVector(str2);
                    String strDecrypt = decrypt(this.apiLevel >= 23 ? new GCMParameterSpec(128, initializationVector) : new IvParameterSpec(initializationVector), string);
                    this.cache.put(str, strDecrypt);
                    return strDecrypt;
                } catch (Exception e2) {
                    logger.error("Error in decrypting data. ", e2);
                    return null;
                }
            }
            return this.cache.get(str);
        }
    }

    public void put(String str, String str2) {
        synchronized (LOCK) {
            try {
                if (str == null) {
                    throw new IllegalArgumentException("Key cannot be null");
                }
                this.cache.put(str, str2);
                if (this.isPersistenceEnabled) {
                    if (str2 == null) {
                        logger.debug("Value is null. Removing the data, IV and version from SharedPreferences");
                        remove(str);
                    } else {
                        String str3 = str + SHARED_PREFERENCES_DATA_IDENTIFIER_SUFFIX;
                        try {
                            byte[] bArrGenerateInitializationVector = generateInitializationVector();
                            this.sharedPreferences.edit().putString(str3, encrypt(this.apiLevel >= 23 ? new GCMParameterSpec(128, bArrGenerateInitializationVector) : new IvParameterSpec(bArrGenerateInitializationVector), str2)).putString(str3 + SHARED_PREFERENCES_IV_SUFFIX, Base64.encodeAsString(bArrGenerateInitializationVector)).putString(str3 + SHARED_PREFERENCES_STORE_VERSION_SUFFIX, String.valueOf(1)).apply();
                        } catch (Exception e2) {
                            logger.error("Error in encrypting data. ", e2);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void remove(String str) {
        synchronized (LOCK) {
            this.cache.remove(str);
            if (this.isPersistenceEnabled) {
                String str2 = str + SHARED_PREFERENCES_DATA_IDENTIFIER_SUFFIX;
                this.sharedPreferences.edit().remove(str2).remove(str2 + SHARED_PREFERENCES_IV_SUFFIX).remove(str2 + SHARED_PREFERENCES_STORE_VERSION_SUFFIX).apply();
            }
        }
    }

    public void clear() {
        synchronized (LOCK) {
            this.cache.clear();
            if (this.isPersistenceEnabled) {
                this.sharedPreferences.edit().clear().apply();
            }
        }
    }

    private void onMigrateFromNoEncryption() {
        Map<String, ?> all = this.sharedPreferences.getAll();
        for (String str : all.keySet()) {
            if (!str.endsWith(SHARED_PREFERENCES_DATA_IDENTIFIER_SUFFIX) && !str.endsWith(SHARED_PREFERENCES_IV_SUFFIX) && !str.endsWith(SHARED_PREFERENCES_STORE_VERSION_SUFFIX)) {
                if (all.get(str) instanceof Long) {
                    put(str, String.valueOf(Long.valueOf(this.sharedPreferences.getLong(str, 0L))));
                } else if (all.get(str) instanceof String) {
                    put(str, this.sharedPreferences.getString(str, null));
                } else if (all.get(str) instanceof Float) {
                    put(str, String.valueOf(Float.valueOf(this.sharedPreferences.getFloat(str, 0.0f))));
                } else if (all.get(str) instanceof Boolean) {
                    put(str, String.valueOf(Boolean.valueOf(this.sharedPreferences.getBoolean(str, false))));
                } else if (all.get(str) instanceof Integer) {
                    put(str, String.valueOf(Integer.valueOf(this.sharedPreferences.getInt(str, 0))));
                } else if (all.get(str) instanceof Set) {
                    Set set = (Set) all.get(str);
                    StringBuilder sb = new StringBuilder();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        if (it.hasNext()) {
                            sb.append(Constants.SEPARATOR_COMMA);
                        }
                    }
                    put(str, sb.toString());
                }
                this.sharedPreferences.edit().remove(str).apply();
            }
        }
    }

    private String encrypt(AlgorithmParameterSpec algorithmParameterSpec, String str) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_AES_GCM_NOPADDING);
            cipher.init(1, this.encryptionKey, algorithmParameterSpec);
            return Base64.encodeAsString(cipher.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            logger.error("Error in encrypting data. ", e2);
            return null;
        }
    }

    private String decrypt(AlgorithmParameterSpec algorithmParameterSpec, String str) {
        try {
            byte[] bArrDecode = Base64.decode(str);
            Cipher cipher = Cipher.getInstance(CIPHER_AES_GCM_NOPADDING);
            cipher.init(2, this.encryptionKey, algorithmParameterSpec);
            return new String(cipher.doFinal(bArrDecode), "UTF-8");
        } catch (Exception e2) {
            logger.error("Error in decrypting data. ", e2);
            return null;
        }
    }

    private byte[] getInitializationVector(String str) {
        String str2 = str + SHARED_PREFERENCES_IV_SUFFIX;
        if (this.sharedPreferences.contains(str2)) {
            return Base64.decode(this.sharedPreferences.getString(str2, null));
        }
        return null;
    }

    private byte[] generateInitializationVector() {
        byte[] bArr = new byte[12];
        this.secureRandom.nextBytes(bArr);
        return bArr;
    }
}
