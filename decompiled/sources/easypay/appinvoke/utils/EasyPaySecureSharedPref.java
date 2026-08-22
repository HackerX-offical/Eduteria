package easypay.appinvoke.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Base64;
import com.amazonaws.services.s3.internal.Constants;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes9.dex */
public class EasyPaySecureSharedPref implements SharedPreferences {
    private static final String ALGTHM_CBC_PAD_AES = "AES/CBC/PKCS5PADDING";
    private static final String ALGTHM_TYPE_AES = "AES";
    private static final byte[] ivParamBytes = {64, 64, 64, 64, 38, 38, 38, 38, 35, 35, 35, 35, 36, 36, 36, 36};
    private Context mContext;
    private SharedPreferences mSharedPreferences;

    public EasyPaySecureSharedPref(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mSharedPreferences = context.getSharedPreferences("app_pref", 0);
        }
    }

    public EasyPaySecureSharedPref(Context context, String str) {
        if (context != null) {
            this.mContext = context;
            this.mSharedPreferences = context.getSharedPreferences(str, 0);
        }
    }

    @Override // android.content.SharedPreferences
    public Editor edit() {
        return new Editor();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        String strDecrypt;
        String string = this.mSharedPreferences.getString(str, null);
        return (string == null || string.equalsIgnoreCase(Constants.NULL_VERSION_ID) || (strDecrypt = decrypt(string)) == null) ? z : Boolean.parseBoolean(strDecrypt);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        String strDecrypt;
        String string = this.mSharedPreferences.getString(str, null);
        return (string == null || string.equalsIgnoreCase(Constants.NULL_VERSION_ID) || (strDecrypt = decrypt(string)) == null) ? f2 : Float.parseFloat(strDecrypt);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        String strDecrypt;
        String string = this.mSharedPreferences.getString(str, null);
        return (string == null || string.equalsIgnoreCase(Constants.NULL_VERSION_ID) || (strDecrypt = decrypt(string)) == null) ? i : Integer.parseInt(strDecrypt);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        String strDecrypt;
        String string = this.mSharedPreferences.getString(str, null);
        return (string == null || string.equalsIgnoreCase(Constants.NULL_VERSION_ID) || (strDecrypt = decrypt(string)) == null) ? j : Long.parseLong(strDecrypt);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            return null;
        }
        String string = sharedPreferences.getString(str, null);
        return (string == null || string.equalsIgnoreCase(Constants.NULL_VERSION_ID)) ? str2 : decrypt(string);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.mSharedPreferences.contains(str);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance(ALGTHM_CBC_PAD_AES);
            cipher.init(1, new SecretKeySpec(generateSecretKey(), "AES"), new IvParameterSpec(ivParamBytes));
            return new String(Base64.encode(cipher.doFinal(str.getBytes()), 2));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String decrypt(String str) {
        try {
            Cipher cipher = Cipher.getInstance(ALGTHM_CBC_PAD_AES);
            cipher.init(2, new SecretKeySpec(generateSecretKey(), "AES"), new IvParameterSpec(ivParamBytes));
            return new String(cipher.doFinal(Base64.decode(str, 2)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getStringSet(str, set);
    }

    private byte[] generateSecretKey() {
        String string = Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
        int length = string.length();
        if (length > 16) {
            string = string.substring(0, 16);
        } else if (length < 16) {
            for (int i = 16 - length; i > 0; i--) {
                string = "0" + string;
            }
        }
        char[] cArr = {'p', '@', 'y', '!', 'm', 'k', 'e', 'Y', '4', 'o', 'n', 'E', '9', '7', 'p', com.clevertap.android.sdk.Constants.INAPP_POSITION_RIGHT};
        char[] charArray = string.toCharArray();
        char[] cArr2 = new char[16];
        for (int i2 = 0; i2 < 16; i2++) {
            cArr2[i2] = (char) (cArr[i2] ^ charArray[i2]);
        }
        return new String(cArr2).getBytes();
    }

    public class Editor implements SharedPreferences.Editor {
        protected SharedPreferences.Editor mEditor;

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        public Editor() {
            this.mEditor = EasyPaySecureSharedPref.this.mSharedPreferences.edit();
        }

        @Override // android.content.SharedPreferences.Editor
        public Editor putBoolean(String str, boolean z) {
            this.mEditor.putString(str, EasyPaySecureSharedPref.this.encrypt(Boolean.toString(z)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public Editor putFloat(String str, float f2) {
            this.mEditor.putString(str, EasyPaySecureSharedPref.this.encrypt(Float.toString(f2)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public Editor putInt(String str, int i) {
            this.mEditor.putString(str, EasyPaySecureSharedPref.this.encrypt(Integer.toString(i)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public Editor putLong(String str, long j) {
            this.mEditor.putString(str, EasyPaySecureSharedPref.this.encrypt(Long.toString(j)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public Editor putString(String str, String str2) {
            if (str2 != null) {
                this.mEditor.putString(str, EasyPaySecureSharedPref.this.encrypt(str2));
                return this;
            }
            this.mEditor.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.mEditor.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public Editor clear() {
            this.mEditor.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.mEditor.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public Editor remove(String str) {
            this.mEditor.remove(str);
            this.mEditor.apply();
            return this;
        }
    }
}
