package com.anychart.chart.common.dataentry;

import com.amazonaws.services.s3.internal.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class DataEntry {
    private Map<String, Object> hashMap = new HashMap();

    public void setValue(String str, String str2) {
        this.hashMap.put(str, str2);
    }

    public void setValue(String str, String[] strArr) {
        this.hashMap.put(str, strArr);
    }

    public void setValue(String str, Number[] numberArr) {
        this.hashMap.put(str, numberArr);
    }

    public void setValue(String str, Number number) {
        this.hashMap.put(str, number != null ? number.toString() : null);
    }

    public void setValue(String str, Boolean bool) {
        this.hashMap.put(str, bool);
    }

    public void setValue(String str, DataEntry dataEntry) {
        this.hashMap.put(str, dataEntry);
    }

    public void setValue(String str, DataEntry[] dataEntryArr) {
        this.hashMap.put(str, dataEntryArr);
    }

    public Object getValue(String str) {
        return this.hashMap.get(str);
    }

    public Set<String> keySet() {
        return this.hashMap.keySet();
    }

    public String generateJs() {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String str : this.hashMap.keySet()) {
            Object obj = this.hashMap.get(str);
            if (obj == null) {
                sb.append(String.format(Locale.US, "%s: %s,", str, Constants.NULL_VERSION_ID));
            } else if (obj instanceof DataEntry) {
                sb.append(String.format(Locale.US, "%s: %s,", str, ((DataEntry) obj).generateJs()));
            } else if (obj instanceof DataEntry[]) {
                sb.append(String.format(Locale.US, "%s: %s,", str, toString((DataEntry[]) obj)));
            } else if (obj.getClass().isArray()) {
                if (obj instanceof Number[]) {
                    string = toString((Number[]) obj);
                } else {
                    string = toString((String[]) obj);
                }
                sb.append(String.format(Locale.US, "%s: %s,", str, string));
            } else if ((obj instanceof Number) || (obj instanceof Boolean)) {
                sb.append(String.format(Locale.US, "%s: %s,", str, obj));
            } else {
                sb.append(String.format(Locale.US, "%s: '%s',", str, obj));
            }
        }
        if (this.hashMap.size() > 0) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }

    private String toString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.clevertap.android.sdk.Constants.AES_PREFIX);
        for (String str : strArr) {
            sb.append("'").append(str).append("',");
        }
        if (strArr.length > 0) {
            sb.setLength(sb.length() - 1);
        }
        sb.append(com.clevertap.android.sdk.Constants.AES_SUFFIX);
        return sb.toString();
    }

    private String toString(Number[] numberArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.clevertap.android.sdk.Constants.AES_PREFIX);
        for (Number number : numberArr) {
            sb.append(number).append(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA);
        }
        if (numberArr.length > 0) {
            sb.setLength(sb.length() - 1);
        }
        sb.append(com.clevertap.android.sdk.Constants.AES_SUFFIX);
        return sb.toString();
    }

    private String toString(DataEntry[] dataEntryArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.clevertap.android.sdk.Constants.AES_PREFIX);
        for (DataEntry dataEntry : dataEntryArr) {
            sb.append(dataEntry.generateJs()).append(com.clevertap.android.sdk.Constants.SEPARATOR_COMMA);
        }
        if (dataEntryArr.length > 0) {
            sb.setLength(sb.length() - 1);
        }
        sb.append(com.clevertap.android.sdk.Constants.AES_SUFFIX);
        return sb.toString();
    }
}
