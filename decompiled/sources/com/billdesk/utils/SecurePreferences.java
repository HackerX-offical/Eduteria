package com.billdesk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes6.dex */
public class SecurePreferences implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f535a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<SharedPreferences.OnSharedPreferenceChangeListener, SharedPreferences.OnSharedPreferenceChangeListener> f536b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f537c = "com.billdesk.utils.SecurePreferences";

    public static class Editor implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SharedPreferences.Editor f538a = SecurePreferences.f535a.edit();

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.f538a.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f538a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.f538a.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f538a.putString(str, Boolean.toString(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            this.f538a.putString(str, Float.toString(f2));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.f538a.putString(str, Integer.toString(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.f538a.putString(str, Long.toString(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.f538a.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
            this.f538a.putStringSet(str, hashSet);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f538a.remove(str);
            return this;
        }
    }

    public SecurePreferences(Context context) {
        if (f535a == null) {
            f535a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        try {
            String strA = a(context);
            String string = f535a.getString(strA, null);
            if (string == null) {
                string = b();
                f535a.edit().putString(strA, string).commit();
            }
            a(string);
            f536b = new HashMap<>(10);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String a(Context context) throws InvalidKeySpecException {
        String string;
        SecretKey secretKeyGenerateSecret;
        char[] charArray = context.getPackageName().toCharArray();
        try {
            string = (String) Build.class.getField("SERIAL").get(null);
            if (TextUtils.isEmpty(string)) {
                string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
        } catch (Exception unused) {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        byte[] bytes = string.getBytes();
        try {
            secretKeyGenerateSecret = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1", BouncyCastleProvider.PROVIDER_NAME).generateSecret(new PBEKeySpec(charArray, bytes, 2000, 256));
        } catch (NoSuchAlgorithmException unused2) {
            secretKeyGenerateSecret = SecretKeyFactory.getInstance("PBEWithMD5AndDES", BouncyCastleProvider.PROVIDER_NAME).generateSecret(new PBEKeySpec(charArray, bytes, 2000, 256));
        }
        return Base64.encodeToString(secretKeyGenerateSecret.getEncoded(), 3);
    }

    public static byte[] a(String str) {
        return Base64.decode(str, 3);
    }

    public static String b() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        try {
            keyGenerator.init(256, secureRandom);
        } catch (Exception unused) {
            try {
                keyGenerator.init(192, secureRandom);
            } catch (Exception unused2) {
                keyGenerator.init(128, secureRandom);
            }
        }
        return Base64.encodeToString(keyGenerator.generateKey().getEncoded(), 3);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return f535a.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new Editor();
    }

    @Override // android.content.SharedPreferences
    public Map<String, String> getAll() {
        Map<String, ?> all = f535a.getAll();
        HashMap map = new HashMap(all.size());
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            try {
                map.put(entry.getKey(), entry.getValue().toString());
            } catch (Exception unused) {
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        String string = f535a.getString(str, null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(string);
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        String string = f535a.getString(str, null);
        if (string == null) {
            return f2;
        }
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        String string = f535a.getString(str, null);
        if (string == null) {
            return i;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        String string = f535a.getString(str, null);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        String string = f535a.getString(str, null);
        return string != null ? string : str2;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = f535a.getStringSet(str, null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        return hashSet;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        f535a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (f536b.containsKey(onSharedPreferenceChangeListener)) {
            onSharedPreferenceChangeListener = f536b.remove(onSharedPreferenceChangeListener);
        }
        f535a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
