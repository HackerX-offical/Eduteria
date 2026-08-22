package com.github.kotvertolet.youtubejextractor.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.clevertap.android.sdk.Constants;
import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes7.dex */
public class StringUtils {
    public static final String UTF_8 = StandardCharsets.UTF_8.name();

    public static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return URLDecoder.decode(str);
        }
    }

    static String escapeRegExSpecialCharacters(String str) {
        String[] strArr = {"\\", "^", "$", "{", "}", Constants.AES_PREFIX, Constants.AES_SUFFIX, "(", ")", InstructionFileId.DOT, "*", MqttTopic.SINGLE_LEVEL_WILDCARD, "?", "|", "<", ">", "-", "&", "%"};
        for (int i = 0; i < 19; i++) {
            String str2 = strArr[i];
            if (str.contains(str2)) {
                str = str.replace(str2, "\\" + str2);
            }
        }
        return str;
    }

    public static String urlParamsToJson(String str) {
        return "{\"" + str.replaceAll("=", "\":\"").replaceAll("&", "\",\"") + "\"}";
    }

    public static Map<String, String> splitUrlParams(String str) throws ExtractionException {
        return splitUrlParams(str.split("&"));
    }

    public static Map<String, String> splitUrlParams(URL url) throws ExtractionException {
        return splitUrlParams(url.getQuery().split("&"));
    }

    private static Map<String, String> splitUrlParams(String[] strArr) throws ExtractionException {
        String strDecode;
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : strArr) {
            int iIndexOf = str.indexOf("=");
            if (iIndexOf > 0) {
                try {
                    strDecode = URLDecoder.decode(str.substring(0, iIndexOf), UTF_8);
                } catch (UnsupportedEncodingException e2) {
                    throw new ExtractionException(e2);
                }
            } else {
                strDecode = str;
            }
            if (!linkedHashMap.containsKey(strDecode)) {
                linkedHashMap.put(strDecode, (iIndexOf <= 0 || str.length() <= (i = iIndexOf + 1)) ? null : URLDecoder.decode(str.substring(i), UTF_8));
            }
        }
        return linkedHashMap;
    }
}
