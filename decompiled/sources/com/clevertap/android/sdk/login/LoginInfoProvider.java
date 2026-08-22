package com.clevertap.android.sdk.login;

import android.content.Context;
import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.cryption.EncryptionLevel;
import com.clevertap.android.sdk.cryption.ICryptHandler;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class LoginInfoProvider {
    private final CleverTapInstanceConfig config;
    private final Context context;
    private ICryptHandler cryptHandler;

    public LoginInfoProvider(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, ICryptHandler iCryptHandler) {
        this.context = context;
        this.config = cleverTapInstanceConfig;
        this.cryptHandler = iCryptHandler;
    }

    public LoginInfoProvider(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.context = context;
        this.config = cleverTapInstanceConfig;
    }

    public void cacheGUIDForIdentifier(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return;
        }
        String str4 = str2 + "_" + str3;
        JSONObject decryptedCachedGUIDs = getDecryptedCachedGUIDs();
        if (decryptedCachedGUIDs.optString(str4).equals(str)) {
            return;
        }
        try {
            decryptedCachedGUIDs.put(str4, str);
            setCachedGUIDsAndLength(decryptedCachedGUIDs.toString(), decryptedCachedGUIDs.length());
        } catch (Throwable th) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Error caching guid: " + th);
        }
    }

    public void removeValueFromCachedGUIDForIdentifier(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        JSONObject decryptedCachedGUIDs = getDecryptedCachedGUIDs();
        try {
            Iterator<String> itKeys = decryptedCachedGUIDs.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next.toLowerCase().contains(str2.toLowerCase()) && decryptedCachedGUIDs.getString(next).equals(str)) {
                    decryptedCachedGUIDs.remove(next);
                    setCachedGUIDsAndLength(decryptedCachedGUIDs.toString(), decryptedCachedGUIDs.length());
                }
            }
        } catch (Throwable th) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Error removing cached key: " + th);
        }
    }

    public boolean deviceIsMultiUser() {
        boolean z = getCachedGuidsLength() > 1;
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "deviceIsMultiUser:[" + z + Constants.AES_SUFFIX);
        return z;
    }

    private String getCachedGUIDStringFromPrefs() {
        String stringFromPrefs = StorageHelper.getStringFromPrefs(this.context, this.config.getAccountId(), Constants.CACHED_GUIDS_KEY, null);
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "getCachedGUIDs:[" + stringFromPrefs + Constants.AES_SUFFIX);
        return stringFromPrefs;
    }

    public JSONObject getDecryptedCachedGUIDs() {
        String cachedGUIDStringFromPrefs = getCachedGUIDStringFromPrefs();
        if (cachedGUIDStringFromPrefs != null) {
            cachedGUIDStringFromPrefs = this.cryptHandler.decryptSafe(cachedGUIDStringFromPrefs);
        }
        return CTJsonConverter.toJsonObject(cachedGUIDStringFromPrefs, this.config.getLogger(), this.config.getAccountId());
    }

    public void setCachedGUIDsAndLength(String str, int i) {
        String strEncryptSafe;
        if (str == null) {
            return;
        }
        if (EncryptionLevel.fromInt(this.config.getEncryptionLevel()) != EncryptionLevel.NONE) {
            strEncryptSafe = this.cryptHandler.encryptSafe(str);
            if (strEncryptSafe == null) {
                this.cryptHandler.updateMigrationFailureCount(false);
            }
        } else {
            strEncryptSafe = null;
        }
        if (strEncryptSafe == null) {
            strEncryptSafe = str;
        }
        StorageHelper.putInt(this.context, this.config.getAccountId(), Constants.CACHED_GUIDS_LENGTH_KEY, i);
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "Storing size of cachedGUIDs: " + i);
        if (i == 0) {
            removeCachedGuidFromSharedPrefs();
        } else {
            StorageHelper.putString(this.context, this.config.getAccountId(), Constants.CACHED_GUIDS_KEY, strEncryptSafe);
            this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "setCachedGUIDs:[" + str + Constants.AES_SUFFIX);
        }
    }

    private int getCachedGuidsLength() {
        int intFromPrefs = StorageHelper.getIntFromPrefs(this.context, this.config.getAccountId(), Constants.CACHED_GUIDS_LENGTH_KEY, 0);
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "Retrieved size of cachedGUIDs: " + intFromPrefs);
        return intFromPrefs;
    }

    public void removeCachedGuidFromSharedPrefs() {
        try {
            StorageHelper.remove(this.context, this.config.getAccountId(), Constants.CACHED_GUIDS_KEY);
            this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "removeCachedGUIDs:[]");
        } catch (Throwable th) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Error removing guid cache: " + th);
        }
    }

    public String getCachedIdentityKeysForAccount() {
        String stringFromPrefs = StorageHelper.getStringFromPrefs(this.context, this.config.getAccountId(), Constants.SP_KEY_PROFILE_IDENTITIES, "");
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "getCachedIdentityKeysForAccount:" + stringFromPrefs);
        return stringFromPrefs;
    }

    public String getGUIDForIdentifier(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                String string = getDecryptedCachedGUIDs().getString(str + "_" + str2);
                this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "getGUIDForIdentifier:[Key:" + str + ", value:" + string + Constants.AES_SUFFIX);
                return string;
            } catch (Throwable th) {
                this.config.getLogger().verbose(this.config.getAccountId(), "Error reading guid cache: " + th);
            }
        }
        return null;
    }

    public boolean isAnonymousDevice() {
        boolean z = getCachedGuidsLength() == 0;
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "isAnonymousDevice:[" + z + Constants.AES_SUFFIX);
        return z;
    }

    public boolean isLegacyProfileLoggedIn() {
        boolean z = getCachedGuidsLength() > 0 && TextUtils.isEmpty(getCachedIdentityKeysForAccount());
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "isLegacyProfileLoggedIn:" + z);
        return z;
    }

    public void saveIdentityKeysForAccount(String str) {
        StorageHelper.putString(this.context, this.config.getAccountId(), Constants.SP_KEY_PROFILE_IDENTITIES, str);
        this.config.log(LoginConstants.LOG_TAG_ON_USER_LOGIN, "saveIdentityKeysForAccount:" + str);
    }
}
