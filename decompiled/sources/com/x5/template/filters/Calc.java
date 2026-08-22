package com.x5.template.filters;

import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.Constants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;
import org.cheffo.jeplite.JEP;
import org.cheffo.jeplite.ParseException;

/* JADX INFO: loaded from: classes9.dex */
public class Calc {
    private static boolean isLegalNameChar(char c2) {
        if (c2 >= 'a' && c2 <= 'z') {
            return true;
        }
        if ((c2 < 'A' || c2 > 'Z') && c2 != '_') {
            return c2 >= '0' && c2 <= '9';
        }
        return true;
    }

    public static void main(String[] strArr) {
        String[] strArr2 = {"x"};
        String[] strArr3 = {"20"};
        System.out.println(evalExpression("2 + 2 * x", "0", strArr2, strArr3));
        System.out.println(evalExpression("sin(pi)", "0.00", null, null));
        System.out.println(evalExpression("(2 + 2 * x^x) % 2", null, strArr2, strArr3));
        HashMap map = new HashMap();
        map.put("a", "20");
        map.put("b", "30");
        System.out.println(evalCalc("\"$x * 3 + $y * 40\",\"%.2f\",~a,~b", map));
        System.out.println(evalCalc("\"$x * $x\",\"%.2f\",~a,~b", map));
        System.out.println(evalCalc("\"$x + $y\",\"%.2f\",$a,$b", map));
        map.put("c", "40");
        System.out.println(evalCalc("\"$x + $y + $z\",$a,$b,$c", map));
    }

    public static String evalCalc(String str, Map<String, Object> map) {
        int i;
        int iIndexOf;
        String strSubstring;
        String[] strArrGrokVarValues;
        String strReplaceAll;
        int i2;
        int iIndexOf2;
        int iIndexOf3 = str.indexOf("\"");
        if (iIndexOf3 < 0 || (iIndexOf = str.indexOf("\"", (i = iIndexOf3 + 1))) < 0) {
            return null;
        }
        String strSubstring2 = str.substring(i, iIndexOf);
        int i3 = iIndexOf + 1;
        int iIndexOf4 = str.indexOf("\"", i3);
        if (iIndexOf4 <= 0 || (iIndexOf2 = str.indexOf("\"", (i2 = iIndexOf4 + 1))) <= 0) {
            strSubstring = null;
        } else {
            i3 = iIndexOf2 + 1;
            strSubstring = str.substring(i2, iIndexOf2);
        }
        String[] varNames = parseVarNames(strSubstring2);
        if (varNames != null) {
            strReplaceAll = strSubstring2.replaceAll("\\$", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            int iIndexOf5 = str.indexOf(Constants.SEPARATOR_COMMA, i3);
            if (iIndexOf5 > 0) {
                i3 = iIndexOf5 + 1;
            }
            int iIndexOf6 = str.indexOf(")", i3);
            if (iIndexOf6 < 0) {
                iIndexOf6 = str.length();
            }
            strArrGrokVarValues = grokVarValues(str.substring(i3, iIndexOf6), map);
        } else {
            strArrGrokVarValues = null;
            strReplaceAll = strSubstring2;
        }
        try {
            return evalExpression(strReplaceAll, strSubstring, varNames, strArrGrokVarValues);
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder();
            if (strArrGrokVarValues != null) {
                for (int i4 = 0; i4 < strArrGrokVarValues.length; i4++) {
                    if (i4 > 0) {
                        sb.append(Constants.SEPARATOR_COMMA);
                    }
                    sb.append(strArrGrokVarValues[i4]);
                }
            }
            return "[error evaluating expression - '" + strSubstring2 + "' - input (" + ((Object) sb) + ") must be numeric]";
        }
    }

    private static String[] grokVarValues(String str, Map<String, Object> map) {
        String[] strArrSplit = str.split(Constants.SEPARATOR_COMMA);
        if (strArrSplit == null) {
            return null;
        }
        String[] strArr = new String[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            String strTrim = strArrSplit[i].trim();
            if (strTrim.startsWith("~") || strTrim.startsWith("$")) {
                strTrim = strTrim.substring(1);
            }
            Object obj = map.get(strTrim);
            if (obj instanceof String) {
                strArr[i] = (String) obj;
            }
        }
        return strArr;
    }

    private static String[] parseVarNames(String str) {
        int iIndexOf = str.indexOf("$");
        ArrayList arrayList = null;
        while (iIndexOf > -1) {
            int i = iIndexOf + 1;
            char cCharAt = str.charAt(i);
            int i2 = i;
            while (isLegalNameChar(cCharAt) && (i2 = i2 + 1) < str.length()) {
                cCharAt = str.charAt(i2);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            String str2 = ExifInterface.GPS_MEASUREMENT_INTERRUPTED + str.substring(i, i2);
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
            iIndexOf = str.indexOf("$", i2);
        }
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String evalExpression(String str, String str2, String[] strArr, String[] strArr2) {
        JEP jep = new JEP();
        jep.addStandardConstants();
        jep.addStandardFunctions();
        if (strArr != null && strArr2 != null && strArr.length <= strArr2.length) {
            for (int i = 0; i < strArr.length; i++) {
                String str3 = strArr[i];
                if (str3 != null) {
                    String str4 = strArr2[i];
                    jep.addVariable(str3, str4 != null ? Double.parseDouble(str4) : 0.0d);
                }
            }
        }
        try {
            jep.parseExpression(str);
            double value = jep.getValue();
            if (str2 == null) {
                return Double.toString(value);
            }
            try {
                if (str2.startsWith("%")) {
                    return String.format(str2, Double.valueOf(value));
                }
                return new DecimalFormat(str2).format(value);
            } catch (NumberFormatException unused) {
                return Double.toString(value);
            } catch (IllegalFormatException unused2) {
                return Double.toString(value);
            }
        } catch (ParseException e2) {
            e2.printStackTrace(System.err);
            return e2.getMessage();
        } catch (Exception e3) {
            e3.printStackTrace(System.err);
            return e3.getMessage();
        }
    }
}
