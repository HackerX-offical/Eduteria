package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.billingclient.api.BillingFlowParams;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StorageHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J,\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0007J$\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0007J.\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0007J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0007J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0007J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ*\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0007J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0019H\u0007J(\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0019H\u0007J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u001cJ(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ(\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0016H\u0007J\u001e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0016J\u001e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0016J \u0010 \u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0019H\u0007J(\u0010 \u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0019H\u0007J\u001e\u0010!\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0019J\u001e\u0010\"\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001cJ(\u0010\"\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001cJ \u0010#\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0007J\u0016\u0010$\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0007J\u0016\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t¨\u0006+"}, d2 = {"Lcom/clevertap/android/sdk/StorageHelper;", "", "<init>", "()V", "getPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "namespace", "", "getStringFromPrefs", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "rawKey", "defaultValue", "getString", "key", "nameSpace", "putString", "", "value", "putStringImmediate", "getBoolean", "", "getBooleanFromPrefs", "getInt", "", "getIntFromPrefs", "getLong", "", "getLongFromPrefs", "putBoolean", "putBooleanImmediate", "putInt", "putIntImmediate", "putLong", "remove", "removeImmediate", "persist", "editor", "Landroid/content/SharedPreferences$Editor;", "persistImmediately", "storageKeyWithSuffix", "accountID", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StorageHelper {
    public static final StorageHelper INSTANCE = new StorageHelper();

    private StorageHelper() {
    }

    @JvmStatic
    public static final SharedPreferences getPreferences(Context context, String namespace) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        if (namespace == null) {
            str = Constants.CLEVERTAP_STORAGE_TAG;
        } else {
            str = "WizRocket_" + namespace;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    @JvmStatic
    public static final SharedPreferences getPreferences(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getPreferences(context, null);
    }

    @JvmStatic
    public static final String getStringFromPrefs(Context context, String accountId, String rawKey, String defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(rawKey, "rawKey");
        return getString(context, INSTANCE.storageKeyWithSuffix(accountId, rawKey), defaultValue);
    }

    @JvmStatic
    public static final String getString(Context context, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return getPreferences(context).getString(key, defaultValue);
    }

    @JvmStatic
    public static final String getString(Context context, String nameSpace, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return getPreferences(context, nameSpace).getString(key, defaultValue);
    }

    @JvmStatic
    public static final void putString(Context context, String key, String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorPutString = getPreferences(context).edit().putString(key, value);
        Intrinsics.checkNotNull(editorPutString);
        persist(editorPutString);
    }

    @JvmStatic
    public static final void putString(Context context, String accountId, String key, String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(key, "key");
        putString(context, INSTANCE.storageKeyWithSuffix(accountId, key), value);
    }

    public final void putStringImmediate(Context context, String key, String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorPutString = getPreferences(context).edit().putString(key, value);
        Intrinsics.checkNotNull(editorPutString);
        persistImmediately(editorPutString);
    }

    @JvmStatic
    public static final void putStringImmediate(Context context, String accountId, String key, String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(key, "key");
        StorageHelper storageHelper = INSTANCE;
        storageHelper.putStringImmediate(context, storageHelper.storageKeyWithSuffix(accountId, key), value);
    }

    public final boolean getBoolean(Context context, String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return getPreferences(context).getBoolean(key, defaultValue);
    }

    @JvmStatic
    public static final boolean getBooleanFromPrefs(Context context, String accountId, String rawKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(rawKey, "rawKey");
        StorageHelper storageHelper = INSTANCE;
        return storageHelper.getBoolean(context, storageHelper.storageKeyWithSuffix(accountId, rawKey), false);
    }

    @JvmStatic
    public static final int getInt(Context context, String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return getPreferences(context).getInt(key, defaultValue);
    }

    @JvmStatic
    public static final int getIntFromPrefs(Context context, String accountId, String rawKey, int defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(rawKey, "rawKey");
        return getInt(context, INSTANCE.storageKeyWithSuffix(accountId, rawKey), defaultValue);
    }

    public final long getLong(Context context, String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return getPreferences(context).getLong(key, defaultValue);
    }

    public final long getLong(Context context, String nameSpace, String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return getPreferences(context, nameSpace).getLong(key, defaultValue);
    }

    public final long getLongFromPrefs(Context context, String accountId, String rawKey, long defaultValue, String nameSpace) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(rawKey, "rawKey");
        return getLong(context, nameSpace, storageKeyWithSuffix(accountId, rawKey), defaultValue);
    }

    @JvmStatic
    public static final void putBoolean(Context context, String accountId, String key, boolean value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(key, "key");
        StorageHelper storageHelper = INSTANCE;
        storageHelper.putBoolean(context, storageHelper.storageKeyWithSuffix(accountId, key), value);
    }

    public final void putBoolean(Context context, String key, boolean value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorPutBoolean = getPreferences(context).edit().putBoolean(key, value);
        Intrinsics.checkNotNull(editorPutBoolean);
        persist(editorPutBoolean);
    }

    public final void putBooleanImmediate(Context context, String key, boolean value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorPutBoolean = getPreferences(context).edit().putBoolean(key, value);
        Intrinsics.checkNotNull(editorPutBoolean);
        persistImmediately(editorPutBoolean);
    }

    @JvmStatic
    public static final void putInt(Context context, String key, int value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorPutInt = getPreferences(context).edit().putInt(key, value);
        Intrinsics.checkNotNull(editorPutInt);
        persist(editorPutInt);
    }

    @JvmStatic
    public static final void putInt(Context context, String accountId, String key, int value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(key, "key");
        putInt(context, INSTANCE.storageKeyWithSuffix(accountId, key), value);
    }

    public final void putIntImmediate(Context context, String key, int value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorPutInt = getPreferences(context).edit().putInt(key, value);
        Intrinsics.checkNotNull(editorPutInt);
        persistImmediately(editorPutInt);
    }

    public final void putLong(Context context, String key, long value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        putLong(context, null, key, value);
    }

    public final void putLong(Context context, String namespace, String key, long value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorPutLong = getPreferences(context, namespace).edit().putLong(key, value);
        Intrinsics.checkNotNull(editorPutLong);
        persist(editorPutLong);
    }

    @JvmStatic
    public static final void remove(Context context, String accountId, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(key, "key");
        remove(context, INSTANCE.storageKeyWithSuffix(accountId, key));
    }

    @JvmStatic
    public static final void remove(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorRemove = getPreferences(context).edit().remove(key);
        Intrinsics.checkNotNull(editorRemove);
        persist(editorRemove);
    }

    public final void removeImmediate(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorRemove = getPreferences(context).edit().remove(key);
        Intrinsics.checkNotNull(editorRemove);
        persistImmediately(editorRemove);
    }

    @JvmStatic
    public static final void persist(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        try {
            editor.apply();
        } catch (Throwable th) {
            Logger.v("CRITICAL: Failed to persist shared preferences!", th);
        }
    }

    public final void persistImmediately(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        try {
            editor.commit();
        } catch (Throwable th) {
            Logger.v("CRITICAL: Failed to persist shared preferences!", th);
        }
    }

    public final String storageKeyWithSuffix(String accountID, String key) {
        Intrinsics.checkNotNullParameter(accountID, "accountID");
        Intrinsics.checkNotNullParameter(key, "key");
        return key + ':' + accountID;
    }
}
