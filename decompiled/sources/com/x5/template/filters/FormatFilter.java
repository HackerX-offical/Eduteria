package com.x5.template.filters;

import com.clevertap.android.sdk.Constants;
import com.x5.template.Chunk;
import com.x5.template.ChunkLocale;
import java.util.IllegalFormatException;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class FormatFilter extends BasicFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        String unparsedArgs = filterArgs.getUnparsedArgs();
        if (unparsedArgs == null) {
            return "";
        }
        return applyFormatString(str, unparsedArgs, chunk != null ? chunk.getLocale() : null);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "sprintf";
    }

    private static String applyFormatString(String str, String str2, ChunkLocale chunkLocale) {
        if (str2.startsWith("sprintf(")) {
            str2 = str2.substring(8);
            if (str2.endsWith(")")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
        }
        char cCharAt = str2.charAt(0);
        if (cCharAt == str2.charAt(str2.length() - 1) && (cCharAt == '\'' || cCharAt == '\"')) {
            str2 = str2.substring(1, str2.length() - 1);
        }
        return formatNumberFromString(str2, str, chunkLocale);
    }

    public static String formatNumberFromString(String str, String str2) {
        return formatNumberFromString(str, str2, null);
    }

    public static Locale getJavaLocale(ChunkLocale chunkLocale) {
        if (chunkLocale == null) {
            return null;
        }
        return chunkLocale.getJavaLocale();
    }

    public static String formatNumberFromString(String str, String str2, ChunkLocale chunkLocale) {
        char cCharAt = str.charAt(str.length() - 1);
        try {
            Locale javaLocale = getJavaLocale(chunkLocale);
            if ("sS".indexOf(cCharAt) > -1) {
                return String.format(javaLocale, str, str2);
            }
            if ("eEfgGaA".indexOf(cCharAt) > -1) {
                return String.format(javaLocale, str, Float.valueOf(Float.valueOf(str2).floatValue()));
            }
            if ("doxX".indexOf(cCharAt) > -1) {
                if (str2.trim().startsWith(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                    return String.format(javaLocale, str, Long.valueOf(Long.parseLong(str2.trim().substring(1), 16)));
                }
                if (!str2.trim().startsWith("0X") && !str2.trim().startsWith("0x")) {
                    return String.format(javaLocale, str, Long.valueOf((long) Float.valueOf(str2).floatValue()));
                }
                return String.format(javaLocale, str, Long.valueOf(Long.parseLong(str2.trim().substring(2), 16)));
            }
            if ("cC".indexOf(cCharAt) <= -1) {
                return "[Unknown format " + cCharAt + ": \"" + str + "\"," + str2 + Constants.AES_SUFFIX;
            }
            if (!str2.trim().startsWith("0X") && !str2.trim().startsWith("0x")) {
                return String.format(javaLocale, str, Character.valueOf((char) Float.valueOf(str2).floatValue()));
            }
            return String.format(javaLocale, str, Character.valueOf((char) Integer.parseInt(str2.trim().substring(2), 16)));
        } catch (NumberFormatException unused) {
            return str2;
        } catch (IllegalFormatException e2) {
            return Constants.AES_PREFIX + e2.getClass().getName() + ": " + e2.getMessage() + " \"" + str + "\"," + str2 + Constants.AES_SUFFIX;
        }
    }
}
