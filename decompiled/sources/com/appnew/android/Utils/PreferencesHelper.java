package com.appnew.android.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes6.dex */
public class PreferencesHelper {
    private static PreferencesHelper instance;
    private SharedPreferences prefs;

    public static PreferencesHelper getInstance() {
        return instance;
    }

    private PreferencesHelper(Context context) {
        this.prefs = context.getApplicationContext().getSharedPreferences(context.getString(R.string.app_name), 0);
    }

    private PreferencesHelper(Context context, String sharePreferencesName) {
        this.prefs = context.getApplicationContext().getSharedPreferences(sharePreferencesName, 0);
    }

    public static PreferencesHelper initHelper(Context context) {
        if (instance == null) {
            instance = new PreferencesHelper(context);
        }
        return instance;
    }

    public static PreferencesHelper initHelper(Context context, String sharePreferencesName) {
        if (instance == null) {
            instance = new PreferencesHelper(context, sharePreferencesName);
        }
        return instance;
    }

    public void setValue(String KEY, boolean value) {
        this.prefs.edit().putBoolean(KEY, value).apply();
    }

    public void setValue(String KEY, String value) {
        this.prefs.edit().putString(KEY, value).apply();
    }

    public void setValue(String KEY, Object value) {
        this.prefs.edit().putString(KEY, new Gson().toJson(value)).apply();
    }

    public void setValue(String KEY, int value) {
        this.prefs.edit().putInt(KEY, value).apply();
    }

    public void setValue(String KEY, long value) {
        this.prefs.edit().putLong(KEY, value).apply();
    }

    public void setValue(String KEY, float value) {
        this.prefs.edit().putFloat(KEY, value).apply();
    }

    public void setValue(String KEY, double defValue) {
        setValue(KEY, String.valueOf(defValue));
    }

    public <T> void setValue(String KEY, List<T> strings) {
        setValue(KEY, new Gson().toJson(strings));
    }

    public <T> void setValue(String KEY, T[] array) {
        JSONArray jSONArray = new JSONArray();
        for (T t : array) {
            jSONArray.put(t);
        }
        this.prefs.edit().putString(KEY, new Gson().toJson(jSONArray)).apply();
    }

    public <T> T[] getArrayValue(String KEY) {
        try {
            JSONArray jSONArray = new JSONArray(this.prefs.getString(KEY, ""));
            if (jSONArray.length() <= 0) {
                return null;
            }
            jSONArray.get(0);
            throw null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public <T> List<T> getListValue(String KEY) {
        try {
            return (List) new Gson().fromJson(this.prefs.getString(KEY, ""), new TypeToken<List<T>>() { // from class: com.appnew.android.Utils.PreferencesHelper.1
            }.getType());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean getBooleanValue(String KEY, boolean defvalue) {
        return this.prefs.getBoolean(KEY, defvalue);
    }

    public String getStringValue(String KEY, String defvalue) {
        return this.prefs.getString(KEY, defvalue);
    }

    public <T> T getObjectValue(String str, Class<T> cls) {
        Object objFromJson;
        try {
            objFromJson = new Gson().fromJson(this.prefs.getString(str, ""), (Class<Object>) cls);
        } catch (Exception e2) {
            e2.printStackTrace();
            objFromJson = null;
        }
        return (T) Primitives.wrap(cls).cast(objFromJson);
    }

    public int getIntValue(String KEY, int defValue) {
        return this.prefs.getInt(KEY, defValue);
    }

    public long getLongValue(String KEY, long defValue) {
        return this.prefs.getLong(KEY, defValue);
    }

    public float getFloatValue(String KEY, float defValue) {
        return this.prefs.getFloat(KEY, defValue);
    }

    public double getDoubleValue(String KEY, double defValue) {
        return Double.parseDouble(getStringValue(KEY, String.valueOf(defValue)));
    }

    public void removeKey(String KEY) {
        this.prefs.edit().remove(KEY).apply();
    }

    public boolean contain(String KEY) {
        return this.prefs.contains(KEY);
    }

    public void registerChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        this.prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        this.prefs.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public void checkForNullKey(String key) {
        key.getClass();
    }

    public void setObject(String key, Object object) {
        this.prefs.edit().putString(key, new Gson().toJson(object)).commit();
    }

    public String getBhajanString(String key) {
        return this.prefs.getString(key, null);
    }
}
