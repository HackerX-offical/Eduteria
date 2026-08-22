package com.clevertap.android.sdk.store.preference;

import android.content.Context;
import android.content.SharedPreferences;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.mam.element.MamPrefsIQ;

/* JADX INFO: compiled from: CTPreference.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00172\u0006\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0017J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000fH\u0017J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0011H\u0017J\u0018\u0010\"\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0013H\u0017J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0015H\u0017J\u001e\u0010&\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0016J\u001e\u0010'\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0017J\"\u0010(\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0019H\u0016J\"\u0010)\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u00052\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0019H\u0017J\"\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0019H\u0003J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u00020\u0011H\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u0005H\u0017J\u0010\u00102\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000f\u00103\u001a\u0004\u0018\u00010-H\u0001¢\u0006\u0002\b4R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00030\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/clevertap/android/sdk/store/preference/CTPreference;", "Lcom/clevertap/android/sdk/store/preference/ICTPreference;", "context", "Landroid/content/Context;", "prefName", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "readString", "key", CookieSpecs.DEFAULT, "readBoolean", "", "readInt", "", "readLong", "", "readFloat", "", "readStringSet", "", "readAll", "", "writeString", "", "value", "writeStringImmediate", "writeBoolean", "writeBooleanImmediate", "writeInt", "writeIntImmediate", "writeLong", "writeLongImmediate", "writeFloat", "writeFloatImmediate", "writeStringSet", "writeStringSetImmediate", "writeMap", "writeMapImmediate", "writeMapToEditor", "Landroid/content/SharedPreferences$Editor;", MamPrefsIQ.ELEMENT, "Landroid/content/SharedPreferences;", "isEmpty", "size", "remove", "removeImmediate", "changePreferenceName", "sharedPrefs", "sharedPrefs$clevertap_core_release", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTPreference implements ICTPreference {
    private final WeakReference<Context> contextRef;
    private String prefName;

    public CTPreference(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefName = str;
        this.contextRef = new WeakReference<>(context);
    }

    public /* synthetic */ CTPreference(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : str);
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public String readString(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        return sharedPreferencesSharedPrefs$clevertap_core_release == null ? str : sharedPreferencesSharedPrefs$clevertap_core_release.getString(key, str);
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public boolean readBoolean(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        return sharedPreferencesSharedPrefs$clevertap_core_release == null ? z : sharedPreferencesSharedPrefs$clevertap_core_release.getBoolean(key, z);
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public int readInt(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        return sharedPreferencesSharedPrefs$clevertap_core_release == null ? i : sharedPreferencesSharedPrefs$clevertap_core_release.getInt(key, i);
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public long readLong(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        return sharedPreferencesSharedPrefs$clevertap_core_release == null ? j : sharedPreferencesSharedPrefs$clevertap_core_release.getLong(key, j);
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public float readFloat(String key, float f2) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        return sharedPreferencesSharedPrefs$clevertap_core_release == null ? f2 : sharedPreferencesSharedPrefs$clevertap_core_release.getFloat(key, f2);
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public Set<String> readStringSet(String key, Set<String> set) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(set, "default");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        return sharedPreferencesSharedPrefs$clevertap_core_release == null ? set : sharedPreferencesSharedPrefs$clevertap_core_release.getStringSet(key, set);
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public Map<String, ?> readAll() {
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        return sharedPreferencesSharedPrefs$clevertap_core_release == null ? MapsKt.emptyMap() : sharedPreferencesSharedPrefs$clevertap_core_release.getAll();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putString(key, value).apply();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeStringImmediate(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putString(key, value).commit();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putBoolean(key, value).apply();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeBooleanImmediate(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putBoolean(key, value).commit();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putInt(key, value).apply();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeIntImmediate(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putInt(key, value).commit();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeLong(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putLong(key, value).apply();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeLongImmediate(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putLong(key, value).commit();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeFloat(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putFloat(key, value).apply();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeFloatImmediate(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putFloat(key, value).commit();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeStringSet(String key, Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putStringSet(key, value).apply();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeStringSetImmediate(String key, Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().putStringSet(key, value).commit();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeMap(String key, Map<String, ?> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        writeMapToEditor(sharedPreferencesSharedPrefs$clevertap_core_release, value).apply();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void writeMapImmediate(String key, Map<String, ?> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        writeMapToEditor(sharedPreferencesSharedPrefs$clevertap_core_release, value).commit();
    }

    private final SharedPreferences.Editor writeMapToEditor(SharedPreferences prefs, Map<String, ?> value) {
        SharedPreferences.Editor editorEdit = prefs.edit();
        for (Map.Entry<String, ?> entry : value.entrySet()) {
            String key = entry.getKey();
            Object value2 = entry.getValue();
            if (value2 instanceof String) {
                editorEdit.putString(key, (String) value2);
            } else if (value2 instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value2).booleanValue());
            } else if (value2 instanceof Integer) {
                editorEdit.putInt(key, ((Number) value2).intValue());
            } else if (value2 instanceof Long) {
                editorEdit.putLong(key, ((Number) value2).longValue());
            } else if (value2 instanceof Float) {
                editorEdit.putFloat(key, ((Number) value2).floatValue());
            }
        }
        Intrinsics.checkNotNull(editorEdit);
        return editorEdit;
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public boolean isEmpty() {
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return true;
        }
        return sharedPreferencesSharedPrefs$clevertap_core_release.getAll().isEmpty();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public int size() {
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return 0;
        }
        return sharedPreferencesSharedPrefs$clevertap_core_release.getAll().size();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().remove(key).apply();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void removeImmediate(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferencesSharedPrefs$clevertap_core_release = sharedPrefs$clevertap_core_release();
        if (sharedPreferencesSharedPrefs$clevertap_core_release == null) {
            return;
        }
        sharedPreferencesSharedPrefs$clevertap_core_release.edit().remove(key).commit();
    }

    @Override // com.clevertap.android.sdk.store.preference.ICTPreference
    public void changePreferenceName(String prefName) {
        Intrinsics.checkNotNullParameter(prefName, "prefName");
        this.prefName = prefName;
    }

    public final SharedPreferences sharedPrefs$clevertap_core_release() {
        Context context = this.contextRef.get();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(this.prefName, 0);
    }
}
