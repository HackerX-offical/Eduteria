package com.github.kotvertolet.youtubejextractor.utils;

import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class CommonUtils {
    public static void LogE(String str, String str2) {
    }

    public static void LogI(String str, String str2) {
    }

    public static Matcher getMatcher(String str, String str2) {
        return Pattern.compile(str).matcher(str2);
    }

    public static String matchWithPatterns(List<Pattern> list, String str) {
        Iterator<Pattern> it = list.iterator();
        String strGroup = null;
        while (strGroup == null && it.hasNext()) {
            Matcher matcher = it.next().matcher(str);
            if (matcher.find()) {
                matcher.find(0);
                strGroup = matcher.group(1);
            }
        }
        return strGroup;
    }
}
