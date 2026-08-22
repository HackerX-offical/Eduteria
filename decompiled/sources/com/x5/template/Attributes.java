package com.x5.template;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class Attributes {
    private static final Pattern PARAM_AND_VALUE = Pattern.compile(" ([a-zA-Z0-9_-]+)=(\"([^\"]*)\"|'([^']*)'|([^ \"']+))");

    public static Map<String, Object> parse(String str) {
        Matcher matcher = PARAM_AND_VALUE.matcher(str);
        HashMap map = null;
        while (matcher.find()) {
            matcher.group(0);
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                if (map == null) {
                    map = new HashMap();
                }
                String strGroup2 = matcher.group(3);
                String strGroup3 = matcher.group(4);
                String strGroup4 = matcher.group(5);
                if (strGroup2 == null) {
                    strGroup2 = strGroup3;
                }
                if (strGroup2 != null) {
                    strGroup4 = strGroup2;
                }
                map.put(strGroup, strGroup4);
            }
        }
        return map;
    }
}
