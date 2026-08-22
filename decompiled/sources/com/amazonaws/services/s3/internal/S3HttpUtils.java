package com.amazonaws.services.s3.internal;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public final class S3HttpUtils {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Pattern ENCODED_CHARACTERS_PATTERN;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Pattern.quote(MqttTopic.SINGLE_LEVEL_WILDCARD)).append("|").append(Pattern.quote("*")).append("|").append(Pattern.quote("%7E")).append("|").append(Pattern.quote("%2F")).append("|").append(Pattern.quote("%3A")).append("|").append(Pattern.quote("%27")).append("|").append(Pattern.quote("%28")).append("|").append(Pattern.quote("%29")).append("|").append(Pattern.quote("%21")).append("|").append(Pattern.quote("%5B")).append("|").append(Pattern.quote("%5D")).append("|").append(Pattern.quote("%24"));
        ENCODED_CHARACTERS_PATTERN = Pattern.compile(sb.toString());
    }

    public static String urlEncode(String str, boolean z) {
        if (str == null) {
            return "";
        }
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(strEncode);
            StringBuffer stringBuffer = new StringBuffer(strEncode.length());
            while (matcher.find()) {
                String strGroup = matcher.group(0);
                if (MqttTopic.SINGLE_LEVEL_WILDCARD.equals(strGroup)) {
                    strGroup = " ";
                } else if ("*".equals(strGroup)) {
                    strGroup = "%2A";
                } else if ("%7E".equals(strGroup)) {
                    strGroup = "~";
                } else if (z && "%2F".equals(strGroup)) {
                    strGroup = MqttTopic.TOPIC_LEVEL_SEPARATOR;
                } else if (z && "%3A".equals(strGroup)) {
                    strGroup = ":";
                } else if (z && "%27".equals(strGroup)) {
                    strGroup = "'";
                } else if (z && "%28".equals(strGroup)) {
                    strGroup = "(";
                } else if (z && "%29".equals(strGroup)) {
                    strGroup = ")";
                } else if (z && "%21".equals(strGroup)) {
                    strGroup = "!";
                } else if (z && "%5B".equals(strGroup)) {
                    strGroup = com.clevertap.android.sdk.Constants.AES_PREFIX;
                } else if (z && "%5D".equals(strGroup)) {
                    strGroup = com.clevertap.android.sdk.Constants.AES_SUFFIX;
                }
                matcher.appendReplacement(stringBuffer, strGroup);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String urlDecode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }
}
