package com.anychart;

import android.text.TextUtils;
import com.anychart.chart.common.dataentry.DataEntry;
import com.clevertap.android.sdk.Constants;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JsObject {
    protected static int variableIndex;
    protected StringBuilder js = new StringBuilder();
    protected String jsBase;

    public String getJsBase() {
        return this.js.toString();
    }

    protected StringBuilder getJs() {
        return this.js;
    }

    protected JsObject() {
    }

    protected JsObject(String str) {
        this.jsBase = str;
    }

    protected static String wrapQuotes(String str) {
        if (TextUtils.isEmpty(str) || isJSONValid(str) || isFunction(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("'").append(str).append("'");
        return sb.toString();
    }

    private static boolean isJSONValid(String str) {
        try {
            try {
                new JSONObject(str);
                return true;
            } catch (JSONException unused) {
                new JSONArray(str);
                return true;
            }
        } catch (JSONException unused2) {
            return false;
        }
    }

    private static boolean isFunction(String str) {
        return str.length() > 10 && str.trim().toLowerCase().substring(0, 8).equals("function");
    }

    private static boolean isContainBracketOrBrace(String str) {
        return str.charAt(0) == '[' || str.charAt(0) == '{';
    }

    protected static String arrayToStringWrapQuotes(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isDigitsOnly(strArr[i]) && !isContainBracketOrBrace(strArr[i])) {
                strArr[i] = wrapQuotes(strArr[i]);
            }
        }
        return Arrays.toString(strArr);
    }

    protected static String arrayToString(JsObject[] jsObjectArr) {
        if (jsObjectArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Constants.AES_PREFIX);
        for (int i = 0; i < jsObjectArr.length; i++) {
            sb.append(jsObjectArr[i].getJsBase());
            if (i != jsObjectArr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(Constants.AES_SUFFIX);
        return sb.toString();
    }

    protected static String arrayToString(Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Constants.AES_PREFIX);
        for (int i = 0; i < objArr.length; i++) {
            try {
                sb.append((String) objArr[i].getClass().getMethod("generateJs", new Class[0]).invoke(objArr[i], new Object[0]));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
            if (i != objArr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(Constants.AES_SUFFIX);
        return sb.toString();
    }

    protected static String arrayToString(List<DataEntry> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.AES_PREFIX);
        Iterator<DataEntry> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().generateJs()).append(", ");
        }
        sb.setLength(sb.length() - 1);
        sb.append(Constants.AES_SUFFIX);
        return sb.toString();
    }
}
