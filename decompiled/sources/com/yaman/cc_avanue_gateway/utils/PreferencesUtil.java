package com.yaman.cc_avanue_gateway.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Prefs.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ \u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0018"}, d2 = {"Lcom/yaman/cc_avanue_gateway/utils/PreferencesUtil;", "", "<init>", "()V", "getSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "setStringPreference", "", "key", "", "val", "setBooleanPreference", "", "setIntegerPreference", "", "getStringPreference", "getStringPreference1", "getBooleanPreference", "getIntegerPreference", "getAllPreference", "removePreference", "removeAllPreference", "cc_avanue_gateway_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreferencesUtil {
    public static final PreferencesUtil INSTANCE = new PreferencesUtil();

    private PreferencesUtil() {
    }

    private final SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tag", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final void setStringPreference(Context context, String key, String val) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.putString(key, val);
        editorEdit.apply();
    }

    public final void setBooleanPreference(Context context, String key, boolean val) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.putBoolean(key, val);
        editorEdit.commit();
    }

    public final void setIntegerPreference(Context context, String key, int val) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.putInt(key, val);
        editorEdit.commit();
    }

    public final String getStringPreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getString(key, "");
    }

    public final String getStringPreference1(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getString(key, "0");
    }

    public final boolean getBooleanPreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getBoolean(key, false);
    }

    public final int getIntegerPreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getInt(key, -1);
    }

    public final String getAllPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Map<String, ?> all = getSharedPreferences(context).getAll();
        String str = "";
        try {
            Intrinsics.checkNotNull(all);
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value);
                str = str + "\t" + key + " = " + value + "\t";
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final void removePreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.remove(key);
        editorEdit.commit();
    }

    public final void removeAllPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.clear();
        editorEdit.commit();
    }
}
