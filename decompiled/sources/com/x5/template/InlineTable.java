package com.x5.template;

import com.clevertap.android.sdk.Constants;
import com.x5.util.TableData;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class InlineTable {
    private static final Pattern DELIM = Pattern.compile("[,\\]]");

    public static void main(String[] strArr) {
        System.out.println("Reading in table...");
        TableData table = parseTable("[[code,name,price],[abc,Apples,$2.50],[xyz,Whiz-Bang \\[you\\, and everyone\\, will love it!\\],$13.99]]");
        System.out.println("...finished.  Checking data structures:");
        String[] columnLabels = table.getColumnLabels();
        while (table.hasNext()) {
            Map<String, Object> mapNextRecord = table.nextRecord();
            for (int i = 0; i < columnLabels.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                String str = columnLabels[i];
                System.out.print(str + "=" + mapNextRecord.get(str));
            }
            System.out.println();
        }
    }

    public static TableData parseTable(String str) {
        return _parseTable(str);
    }

    private static SimpleTable _parseTable(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int iIndexOf = str.indexOf(Constants.AES_PREFIX);
        if (iIndexOf < 0) {
            return null;
        }
        String[] strArr = null;
        ArrayList arrayList2 = null;
        while (iIndexOf > -1 && iIndexOf < length && (iIndexOf = str.indexOf(Constants.AES_PREFIX, iIndexOf + 1)) >= 0) {
            while (iIndexOf > 0 && iIndexOf < length && str.charAt(iIndexOf) != ']') {
                int i = iIndexOf + 1;
                int iNextUnescapedDelim = nextUnescapedDelim(DELIM, str, i);
                if (iNextUnescapedDelim > 0) {
                    arrayList.add(str.substring(i, iNextUnescapedDelim).replace("\\[", Constants.AES_PREFIX).replace("\\]", Constants.AES_SUFFIX).replace("\\,", Constants.SEPARATOR_COMMA));
                }
                iIndexOf = iNextUnescapedDelim;
            }
            if (arrayList.size() > 0) {
                String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
                if (strArr == null) {
                    strArr = strArr2;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(strArr2);
                }
                arrayList.clear();
            }
            if (iIndexOf > 0) {
                iIndexOf = str.indexOf(Constants.SEPARATOR_COMMA, iIndexOf + 1);
            }
        }
        if (strArr == null) {
            return null;
        }
        return new SimpleTable(strArr, (ArrayList<String[]>) arrayList2);
    }

    private static int nextUnescapedDelim(Pattern pattern, String str, int i) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find(i)) {
            return -1;
        }
        int iStart = matcher.start();
        boolean z = false;
        while (!z) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                int i4 = iStart - i3;
                if (i4 < i || str.charAt(i4) != '\\') {
                    break;
                }
                i2 = i3;
            }
            if (i2 % 2 == 0) {
                z = true;
            } else {
                if (!matcher.find()) {
                    return -1;
                }
                iStart = matcher.start();
            }
        }
        return iStart;
    }
}
