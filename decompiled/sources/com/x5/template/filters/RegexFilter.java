package com.x5.template.filters;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.clevertap.android.sdk.Constants;
import com.csvreader.CsvReader;
import com.x5.template.Chunk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class RegexFilter extends BasicFilter implements ChunkFilter {
    private static final Pattern INNOCUOUS_CHARS = Pattern.compile("^[-A-Za-z0-9_ <>\"']*$");

    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        String unparsedArgs;
        return (str == null || (unparsedArgs = filterArgs.getUnparsedArgs()) == null) ? str : applyRegex(str, unparsedArgs);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return CmcdData.Factory.STREAMING_FORMAT_SS;
    }

    public static int nextRegexDelim(String str, int i) {
        return FilterArgs.nextUnescapedDelim(MqttTopic.TOPIC_LEVEL_SEPARATOR, str, i);
    }

    public static String applyRegex(String str, String str2) {
        int i;
        int iNextRegexDelim;
        String strReplaceFirst;
        boolean z = false;
        int i2 = str2.charAt(0) == 's' ? 2 : 1;
        int iNextRegexDelim2 = nextRegexDelim(str2, i2);
        if (iNextRegexDelim2 < 0 || (iNextRegexDelim = nextRegexDelim(str2, (i = iNextRegexDelim2 + 1))) < 0) {
            return str;
        }
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (int length = str2.length() - 1; length > iNextRegexDelim; length--) {
            char cCharAt = str2.charAt(length);
            if (cCharAt == 'g') {
                z5 = true;
            }
            if (cCharAt == 'i') {
                z3 = true;
            }
            if (cCharAt == 'm') {
                z2 = true;
            }
            if (cCharAt == 's') {
                z4 = true;
            }
        }
        String strSubstring = str2.substring(i2, iNextRegexDelim2);
        String strFindAndReplace = Chunk.findAndReplace(parseRegexEscapes(str2.substring(i, iNextRegexDelim)), "\\", "\\\\");
        if (z2) {
            strSubstring = "(?m)" + strSubstring;
        }
        if (z3) {
            strSubstring = "(?i)" + strSubstring;
        }
        if (z4) {
            strSubstring = "(?s)" + strSubstring;
        }
        if (strFindAndReplace.matches(".*\\\\[UL][\\$\\\\]\\d.*")) {
            strFindAndReplace = strFindAndReplace.replaceAll("\\\\([UL])[\\$\\\\](\\d)", "!$1@\\$$2@$1!");
            z = true;
        }
        try {
            if (z5) {
                strReplaceFirst = str.replaceAll(strSubstring, strFindAndReplace);
            } else {
                strReplaceFirst = str.replaceFirst(strSubstring, strFindAndReplace);
            }
            return z ? applyCaseConversions(strReplaceFirst) : strReplaceFirst;
        } catch (IndexOutOfBoundsException e2) {
            return str + "[REGEX " + str2 + " Error: " + e2.getMessage() + Constants.AES_SUFFIX;
        }
    }

    private static String applyCaseConversions(String str) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = Pattern.compile("!U@(.*?)@U!").matcher(str);
        int iEnd = 0;
        int iEnd2 = 0;
        while (matcher.find()) {
            sb.append(str.substring(iEnd2, matcher.start()));
            sb.append(matcher.group(1).toUpperCase());
            iEnd2 = matcher.end();
        }
        if (iEnd2 > 0) {
            sb.append(str.substring(iEnd2));
            str = sb.toString();
            sb = new StringBuilder();
        } else {
            iEnd = iEnd2;
        }
        Matcher matcher2 = Pattern.compile("!L@(.*?)@L!").matcher(str);
        while (matcher2.find()) {
            sb.append(str.substring(iEnd, matcher2.start()));
            sb.append(matcher2.group(1).toLowerCase());
            iEnd = matcher2.end();
        }
        if (iEnd <= 0) {
            return str;
        }
        sb.append(str.substring(iEnd));
        return sb.toString();
    }

    public static String parseRegexEscapes(String str) {
        int i;
        if (str == null) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        boolean z = false;
        while (i2 < charArray.length) {
            if (z) {
                char c2 = charArray[i2];
                if (c2 == 'b') {
                    sb.append('\b');
                } else if (c2 == 't') {
                    sb.append('\t');
                } else if (c2 == 'n') {
                    sb.append('\n');
                } else if (c2 == 'r') {
                    sb.append('\r');
                } else if (c2 == 'f') {
                    sb.append(CsvReader.Letters.FORM_FEED);
                } else if (c2 == 'U') {
                    sb.append("\\U");
                } else if (c2 == 'L') {
                    sb.append("\\L");
                } else if (c2 == 'u') {
                    int i3 = i2 + 4;
                    if (i3 < charArray.length) {
                        sb.append((char) Integer.parseInt(str.substring(i2 + 1, i2 + 5), 16));
                        i2 = i3;
                    } else {
                        sb.append('\\');
                        sb.append(charArray[i2]);
                    }
                } else if (Character.isDigit(c2)) {
                    int i4 = 1;
                    while (i4 < 2 && (i = i2 + i4) < charArray.length && Character.isDigit(charArray[i])) {
                        i4++;
                    }
                    sb.append((char) Integer.parseInt(str.substring(i2, i2 + i4), 8));
                    i2 += i4 - 1;
                } else {
                    sb.append(charArray[i2]);
                }
                z = false;
            } else {
                char c3 = charArray[i2];
                if (c3 == '\\') {
                    z = true;
                } else {
                    sb.append(c3);
                }
            }
            i2++;
        }
        return sb.toString();
    }

    public static String escapeRegex(String str) {
        if (INNOCUOUS_CHARS.matcher(str).find()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ' ' || ((cCharAt >= 'A' && cCharAt <= 'Z') || ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= '0' && cCharAt <= '9')))) {
                sb.append(cCharAt);
            } else {
                sb.append("\\");
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}
