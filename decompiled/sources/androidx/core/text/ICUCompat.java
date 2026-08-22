package androidx.core.text;

import android.icu.util.ULocale;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    public static String maximizeAndGetScript(Locale locale) {
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(locale)));
    }

    private static String getScriptBelowApi21(String str) {
        try {
            Method method = sGetScriptMethod;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w(TAG, e2);
        } catch (InvocationTargetException e3) {
            Log.w(TAG, e3);
        }
        return null;
    }

    private static String addLikelySubtagsBelowApi21(Locale locale) {
        String string = locale.toString();
        try {
            Method method = sAddLikelySubtagsMethod;
            if (method != null) {
                return (String) method.invoke(null, string);
            }
        } catch (IllegalAccessException e2) {
            Log.w(TAG, e2);
        } catch (InvocationTargetException e3) {
            Log.w(TAG, e3);
        }
        return string;
    }

    private ICUCompat() {
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale forLocale(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static ULocale addLikelySubtags(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static String getScript(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static String getScript(Locale locale) {
            return locale.getScript();
        }
    }
}
